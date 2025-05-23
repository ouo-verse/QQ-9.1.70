package k02;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.share.GuildMiniAppShareData;
import com.tencent.mobileqq.guild.share.app.FakeGuildInfoForMini;
import com.tencent.mobileqq.guild.share.y;
import com.tencent.mobileqq.guild.usecases.b;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import com.tencent.util.URLUtil;
import java.util.regex.Matcher;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e extends y {

    /* renamed from: l, reason: collision with root package name */
    private final GuildMiniAppShareData f411366l;

    /* renamed from: m, reason: collision with root package name */
    private final GuildMiniAppShareData.a f411367m;

    public e(@NonNull GuildMiniAppShareData guildMiniAppShareData, @NonNull GuildMiniAppShareData.a aVar, @NonNull String str) {
        super(new FakeGuildInfoForMini(), null, guildMiniAppShareData.invitorName, new b.c(aVar.f234947a, aVar.f234948b, aVar.f234949c, aVar.f234950d, ""), str);
        this.f411366l = guildMiniAppShareData;
        this.f411367m = H(aVar, guildMiniAppShareData.invitorName);
    }

    @NonNull
    private GuildMiniAppShareData.a H(GuildMiniAppShareData.a aVar, String str) {
        Matcher matcher = y.f235161k.matcher(aVar.f234948b);
        StringBuffer stringBuffer = new StringBuffer(aVar.f234948b.length());
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, b(matcher.group(), null));
        }
        matcher.appendTail(stringBuffer);
        return new GuildMiniAppShareData.a(b(aVar.f234947a, str), stringBuffer.toString(), aVar.f234949c, aVar.f234950d);
    }

    private boolean J() {
        if (this.f411366l.channelType == 6) {
            return true;
        }
        return false;
    }

    @NonNull
    private String b(String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str2)) {
            str = URLUtil.addParameter(str, "nickName", URLUtil.encodeUrl(str2));
        }
        return URLUtil.addParameter(URLUtil.addParameter(str, "from", String.valueOf(246610)), "biz", "ka");
    }

    protected String I(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appId", "com.tencent.qun.pro");
            jSONObject2.put("title", str);
            jSONObject2.put("tag", "\u817e\u8baf\u9891\u9053");
            jSONObject2.put("desc", str2);
            jSONObject2.put("preview", str3);
            jSONObject2.put(WadlProxyConsts.KEY_JUMP_URL, v());
            jSONObject2.put("guildId", str4);
            jSONObject2.put("channelId", str5);
            jSONObject.put("contact", jSONObject2);
        } catch (Exception e16) {
            QLog.e("ShareInfoProviderForMini", 1, "getMetaString exception=", e16);
        }
        return jSONObject.toString();
    }

    @Override // com.tencent.mobileqq.guild.share.y
    public String d() {
        if (J()) {
            return this.f411366l.guildName;
        }
        if (!TextUtils.isEmpty(this.f411366l.guildProfile)) {
            return this.f411366l.guildProfile;
        }
        return QQGuildUIUtil.s(R.string.f156591km, this.f411366l.creatorName);
    }

    @Override // com.tencent.mobileqq.guild.share.y
    public com.tencent.mobileqq.sharehelper.a e() {
        String q16 = q();
        String d16 = d();
        String g16 = g();
        GuildMiniAppShareData guildMiniAppShareData = this.f411366l;
        String I = I(q16, d16, g16, guildMiniAppShareData.guildId, guildMiniAppShareData.channelId);
        Bundle bundle = new Bundle();
        bundle.putString("appName", "com.tencent.qun.pro");
        bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, "1.0.0.0");
        bundle.putString(QQCustomArkDialogUtil.APP_VIEW, "contact");
        bundle.putString(QQCustomArkDialogUtil.META_DATA, I);
        bundle.putString(QQCustomArkDialogUtil.BIZ_SRC, "");
        bundle.putFloat("scale", ViewUtils.getDensity());
        bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, "{\"autosize\": 1, \"forward\": 1}");
        return new com.tencent.mobileqq.sharehelper.a("com.tencent.qun.pro", "contact", "1.0.0.0", q(), I, bundle, "guild_share_label", 1003, "");
    }

    @Override // com.tencent.mobileqq.guild.share.y
    public String g() {
        return this.f411366l.guildAvatarUrl;
    }

    @Override // com.tencent.mobileqq.guild.share.y
    public String m() {
        boolean k3 = com.tencent.mobileqq.guild.share.shorturl.a.k(v());
        String a16 = com.tencent.mobileqq.guild.share.util.c.a(v(), String.valueOf(11));
        if (!k3) {
            a16 = v();
        }
        if (!TextUtils.isEmpty(this.f411367m.f234948b)) {
            if (k3) {
                return this.f411367m.f234948b.replace(v(), a16);
            }
            return this.f411367m.f234948b;
        }
        if (J()) {
            return QQGuildUIUtil.s(R.string.f156641kr, QQGuildUIUtil.r(R.string.f141960i3), this.f411366l.channelName, a16);
        }
        return QQGuildUIUtil.s(R.string.f156751l2, this.f411366l.guildName, a16);
    }

    @Override // com.tencent.mobileqq.guild.share.y
    public String n() {
        return QQGuildUIUtil.r(R.string.f156601kn);
    }

    @Override // com.tencent.mobileqq.guild.share.y
    public String q() {
        if (J()) {
            return QQGuildUIUtil.s(R.string.f156631kq, QQGuildUIUtil.r(R.string.f141960i3), this.f411366l.channelName);
        }
        return QQGuildUIUtil.s(R.string.f156521kf, this.f411366l.guildName);
    }

    @Override // com.tencent.mobileqq.guild.share.y
    public long t() {
        try {
            return Long.parseLong(this.f411366l.channelId);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    @Override // com.tencent.mobileqq.guild.share.y
    public long u() {
        try {
            return Long.parseLong(this.f411366l.guildId);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    @Override // com.tencent.mobileqq.guild.share.y
    public String v() {
        return this.f411367m.f234947a;
    }
}
