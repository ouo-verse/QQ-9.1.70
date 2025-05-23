package ho1;

import android.text.Editable;
import android.text.TextUtils;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedRichContentResultBean;
import com.tencent.mobileqq.guild.nt.qzone.api.IQzoneTextApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes13.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f405439a = Pattern.compile("@?\\{uin?:.*?\\,nick(name)?:.*?\\{?.*?\\}?\\}");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f405440b = Pattern.compile("\\[em\\]e[0-9]+\\[\\/em\\]");

    private static void a(GuildFeedRichContentResultBean guildFeedRichContentResultBean, String str) {
        guildFeedRichContentResultBean.addTextContent(str.replaceAll("@\\{uin:\\d+,?\\s*(nick:)?", ""));
    }

    public static Editable.Factory b() {
        return ((IQzoneTextApi) QRoute.api(IQzoneTextApi.class)).getEmoctationFacory();
    }

    public static boolean c(String str, int i3) {
        if (i3 < str.length() && str.charAt(i3) == 20) {
            return true;
        }
        return false;
    }

    private static GuildFeedRichContentResultBean d(GuildFeedRichContentResultBean guildFeedRichContentResultBean) {
        GuildFeedRichContentResultBean guildFeedRichContentResultBean2 = new GuildFeedRichContentResultBean();
        for (GuildFeedRichContentResultBean.RichContent richContent : guildFeedRichContentResultBean.contents) {
            if (richContent.getType() == 1) {
                String text = ((GuildFeedRichContentResultBean.RichTextContent) richContent).getContent().getText();
                StringBuilder sb5 = new StringBuilder();
                int i3 = -1;
                for (int i16 = 0; i16 < text.length(); i16++) {
                    if (i16 > i3) {
                        if (c(text, i16)) {
                            if (sb5.length() > 0) {
                                a(guildFeedRichContentResultBean2, sb5.toString());
                                sb5.setLength(0);
                            }
                            if (((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).isValidEmojiFaceId(text, i16)) {
                                guildFeedRichContentResultBean2.addEmojiContent(String.valueOf(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseEmojiFaceStrToServerId(text, i16)));
                                i3 = i16 + 1;
                            }
                        } else {
                            sb5.append(text.charAt(i16));
                        }
                    }
                }
                if (sb5.length() > 0) {
                    a(guildFeedRichContentResultBean2, sb5.toString());
                }
            } else {
                guildFeedRichContentResultBean2.addContent(richContent);
            }
        }
        return guildFeedRichContentResultBean2;
    }

    private static void e(String str, GuildFeedRichContentResultBean guildFeedRichContentResultBean) {
        StringBuilder sb5 = new StringBuilder(str);
        Matcher matcher = f405439a.matcher(sb5);
        int length = sb5.length();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start();
                if (start > i3) {
                    a(guildFeedRichContentResultBean, sb5.substring(i3, start));
                }
                String group = matcher.group();
                QLog.d("GuildFeedHostTextBuilder", 1, "parseTextAndAt atString:" + group);
                int indexOf = group.indexOf(",nick:");
                int length2 = group.length() - 1;
                String substring = group.substring(6, indexOf);
                String substring2 = group.substring(indexOf + 6, length2);
                if (substring.equals("at_all")) {
                    guildFeedRichContentResultBean.addAtContent(3, substring, substring2, null);
                    i16++;
                } else if (substring.equals("at_online")) {
                    guildFeedRichContentResultBean.addAtContent(4, substring, substring2, null);
                    i17++;
                } else if (substring.equals("at_role")) {
                    f(guildFeedRichContentResultBean, substring, substring2);
                    i18++;
                } else {
                    guildFeedRichContentResultBean.addAtContent(1, substring, substring2, null);
                }
                i3 = matcher.end();
            } catch (Exception e16) {
                QLog.e("GuildFeedHostTextBuilder", 1, e16, new Object[0]);
                return;
            }
        }
        if (length > i3) {
            a(guildFeedRichContentResultBean, sb5.substring(i3, length));
        }
        guildFeedRichContentResultBean.addAtNums(i16, i17, i18);
    }

    private static void f(GuildFeedRichContentResultBean guildFeedRichContentResultBean, String str, String str2) throws JSONException {
        int indexOf = str2.indexOf(",role_info:");
        GuildFeedRichContentResultBean.RoleInfo roleInfo = null;
        if (indexOf != -1) {
            String substring = str2.substring(0, indexOf);
            String substring2 = str2.substring(indexOf + 11);
            QLog.d("GuildFeedHostTextBuilder", 1, "parseTextAndAt atString: role_info:" + substring2);
            if (!TextUtils.isEmpty(substring2)) {
                JSONObject jSONObject = new JSONObject(substring2);
                jSONObject.get("role_id");
                roleInfo = new GuildFeedRichContentResultBean.RoleInfo(jSONObject.getString("role_id"), jSONObject.getString("name"), jSONObject.getLong("color"));
            }
            str2 = substring;
        }
        guildFeedRichContentResultBean.addAtContent(2, str, str2, roleInfo);
    }

    public static GuildFeedRichContentResultBean g(String str, List<? extends GuildFeedRichContentResultBean.ImageContent> list) {
        GuildFeedRichContentResultBean guildFeedRichContentResultBean = new GuildFeedRichContentResultBean();
        if (!TextUtils.isEmpty(str)) {
            e(str, guildFeedRichContentResultBean);
        }
        GuildFeedRichContentResultBean d16 = d(guildFeedRichContentResultBean);
        d16.ext = guildFeedRichContentResultBean.ext;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                d16.addImageContent(list.get(i3));
            }
        }
        QLog.d("GuildFeedHostTextBuilder", 1, "toGuildRichText result:" + d16);
        return d16;
    }
}
