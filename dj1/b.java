package dj1;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.feedsquare.fragment.GuildFeedSquareSectionFragmentHome;
import com.tencent.mobileqq.guild.feed.report.f;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.bd;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import wh2.br;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b implements tf1.a {

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface a {
        void a(Fragment fragment);
    }

    public static Fragment d(Bundle bundle, int i3) {
        IGProGuildInfo i16 = i(bundle.getString("guild_id"));
        if (i16 == null) {
            return null;
        }
        return e(bundle, i3, h(bundle, i3, i16));
    }

    @NonNull
    private static Fragment e(Bundle bundle, int i3, GuildFeedSquareInitBean guildFeedSquareInitBean) {
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedSquareInitBean);
        bundle2.putInt("key_page_type", i3);
        bundle2.putAll(bundle);
        GuildFeedSquareSectionFragmentHome guildFeedSquareSectionFragmentHome = new GuildFeedSquareSectionFragmentHome();
        guildFeedSquareSectionFragmentHome.setArguments(bundle2);
        return guildFeedSquareSectionFragmentHome;
    }

    public static void f(final Bundle bundle, final int i3, final a aVar) {
        final String string = bundle.getString("guild_id");
        bd bdVar = new bd();
        bdVar.k(Long.parseLong(string));
        bdVar.i(true);
        ((IGPSService) ch.R0(IGPSService.class)).getCategoryChannelInfoListV2(bdVar, new br() { // from class: dj1.a
            @Override // wh2.br
            public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                b.j(string, aVar, bundle, i3, arrayList);
            }
        });
    }

    private static AppRuntime g() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @NonNull
    private static GuildFeedSquareInitBean h(Bundle bundle, int i3, IGProGuildInfo iGProGuildInfo) {
        GuildFeedSquareInitBean guildFeedSquareInitBean = (GuildFeedSquareInitBean) new GuildFeedSquareInitBean().setGuildId(iGProGuildInfo.getGuildID()).setIsMember(iGProGuildInfo.isMember()).setUserType(f.j(iGProGuildInfo.getGuildID())).setGuildUrl(iGProGuildInfo.getAvatarUrl(100)).setShareSource(11);
        JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) bundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        guildFeedSquareInitBean.setJoinInfoParam(joinInfoParam);
        if (ch.j0(iGProGuildInfo.getGuildID()) && (joinInfoParam == null || !joinInfoParam.isValid())) {
            s.e("GuildPostsLoadHandler", "JoinInfoParam is null in guest guild", new RuntimeException("JoinInfoParam is null in guest guild"));
        }
        guildFeedSquareInitBean.setJumpExtraInfo((GuildAppReportSourceInfo) bundle.getParcelable("GuildAppReportSourceInfo"));
        guildFeedSquareInitBean.setFeedReportSourceInfo((GuildFeedReportSourceInfo) bundle.getParcelable("GuildFeedReportSourceInfo"));
        guildFeedSquareInitBean.setOpenFrom(bundle.getInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM));
        String string = bundle.getString("detailId", "");
        if (!TextUtils.isEmpty(string)) {
            guildFeedSquareInitBean.getAttrs().put(AppConstants.Key.GUILD_EXTAR_DETAIL_CONTENT_JUMP_ID, string);
        }
        if (i3 == 2) {
            guildFeedSquareInitBean.setBusinessType(5);
        } else if (i3 == 3 || i3 == 4) {
            guildFeedSquareInitBean.setBusinessType(14);
        }
        if (TextUtils.isEmpty(string) || i3 != 3) {
            guildFeedSquareInitBean.setChannelId(bundle.getString("channelId", ""));
        }
        JumpGuildParam.ChannelDetailPageJumpInfo channelDetailPageJumpInfo = (JumpGuildParam.ChannelDetailPageJumpInfo) bundle.getParcelable(JumpGuildParam.KEY_DETAIL_PAGE_JUMP_INFO);
        if (channelDetailPageJumpInfo != null) {
            QLog.d("GuildPostsLoadHandler", 1, "parseData detailPageJumpInfo: " + channelDetailPageJumpInfo);
            guildFeedSquareInitBean.getAttrs().put(com.tencent.mobileqq.guild.feed.b.f218120f, channelDetailPageJumpInfo.getDetailId());
        }
        return guildFeedSquareInitBean;
    }

    @Nullable
    private static IGProGuildInfo i(String str) {
        IGProGuildInfo iGProGuildInfo;
        if (g() != null) {
            iGProGuildInfo = ((IGPSService) g().getRuntimeService(IGPSService.class, "")).getGuildInfo(str);
        } else {
            iGProGuildInfo = null;
        }
        if (iGProGuildInfo == null) {
            QLog.e("GuildPostsLoadHandler", 1, "createFragmentArguments: guildInfo get failed");
            return null;
        }
        return iGProGuildInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(String str, a aVar, Bundle bundle, int i3, ArrayList arrayList) {
        IGProGuildInfo i16 = i(str);
        if (i16 == null) {
            aVar.a(null);
            return;
        }
        GuildFeedSquareInitBean h16 = h(bundle, i3, i16);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IGProCategoryChannelInfoList iGProCategoryChannelInfoList = (IGProCategoryChannelInfoList) it.next();
            if (iGProCategoryChannelInfoList.getCategoryType() != 1) {
                Iterator<IGProChannel> it5 = iGProCategoryChannelInfoList.getChannelInfoList().iterator();
                while (it5.hasNext()) {
                    IGProChannel next = it5.next();
                    if (next.getHiddenPostChannel() == 1 && next.getChannelType() == 7) {
                        h16.setChannelId(String.valueOf(next.getChannelId()));
                    }
                }
            }
        }
        aVar.a(e(bundle, i3, h16));
    }

    @Override // tf1.a
    public Fragment a(Bundle bundle) {
        int i3 = bundle.getInt("guild_posts_type", 0);
        if (i3 != 2 && i3 != 3) {
            return null;
        }
        return d(bundle, i3);
    }

    @Override // tf1.a
    public String b(int i3) {
        if (i3 == 2) {
            return "GuildFeedSquareFragment";
        }
        return "";
    }
}
