package com.tencent.mobileqq.guild.media.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.channel.frame.titlebar.GuildChannelTitleBarManager;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.media.GuildMediaChannelViewModel;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.notify.aq;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.floatwindow.FloatWindowPermissionHandler;
import com.tencent.mobileqq.guild.media.thirdapp.share.GuildMediaShareActionSheet;
import com.tencent.mobileqq.guild.media.thirdapp.share.g;
import com.tencent.mobileqq.guild.media.widget.GuildMediaRankingUserCase;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.ClickType;
import com.tencent.mobileqq.guild.widget.GuildAIOTitleBar;
import com.tencent.mobileqq.guild.widget.GuildRightIconLayout;
import com.tencent.mobileqq.guild.widget.IconType;
import com.tencent.mobileqq.guild.widget.TitleBarTheme;
import com.tencent.mobileqq.guild.widget.ah;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelState;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cz;
import com.tencent.mobileqq.qqguildsdk.data.dt;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0002gj\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0001pB'\u0012\u0006\u00107\u001a\u000202\u0012\u0006\u0010<\u001a\u00020\f\u0012\u0006\u0010A\u001a\u00020\f\u0012\u0006\u0010G\u001a\u00020B\u00a2\u0006\u0004\bm\u0010nJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J&\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u0003H\u0002J\u0012\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u0003H\u0002J\b\u0010(\u001a\u00020\u0003H\u0002J\b\u0010)\u001a\u00020\u0003H\u0002J\u0006\u0010*\u001a\u00020\u0003J\u0006\u0010+\u001a\u00020\u0003J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0005\u001a\u00020\u001eH\u0016J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\n\u00101\u001a\u0004\u0018\u000100H\u0016R\u0017\u00107\u001a\u0002028\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u0010<\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\"\u0010A\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00109\u001a\u0004\b>\u0010;\"\u0004\b?\u0010@R\u0017\u0010G\u001a\u00020B8\u0006\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010N\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010JR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010SR\u0016\u0010W\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010VR\u001b\u0010\\\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010Y\u001a\u0004\bZ\u0010[R\u001b\u0010`\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010Y\u001a\u0004\bL\u0010_R\u0016\u0010c\u001a\u00020a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010bR\u0014\u0010f\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010eR\u0014\u0010i\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010hR\u0014\u0010l\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010k\u00a8\u0006q"}, d2 = {"Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentTitleBarPresenter;", "Lcom/tencent/mobileqq/guild/widget/ah;", "Lcom/tencent/mobileqq/guild/channel/frame/titlebar/g;", "", "E", "v", "u", "t", HippyTKDListViewAdapter.X, "L", UserInfo.SEX_FEMALE, "D", "", "errMsg", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", ReportConstant.COSTREPORT_PREFIX, "guildId", "channelId", "", "o", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$e;", "extraInfo", "G", "Landroid/view/View;", "view", "y", "l", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "w", "p", "J", "K", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "Lcom/tencent/mobileqq/guild/widget/ClickType;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "u2", "H5", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "T3", "Landroidx/fragment/app/Fragment;", "d", "Landroidx/fragment/app/Fragment;", "getMFragment", "()Landroidx/fragment/app/Fragment;", "mFragment", "e", "Ljava/lang/String;", "getMGuildId", "()Ljava/lang/String;", "mGuildId", "f", "getMChannelId", "setMChannelId", "(Ljava/lang/String;)V", "mChannelId", "Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", tl.h.F, "Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", "getMTitleBar", "()Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", "mTitleBar", "Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;", "i", "Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;", "mSettingBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mShareBtn", "mRankingListBtn", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/guild/media/core/e;", "Lcom/tencent/mobileqq/guild/media/core/e;", "mCore", "Lcom/tencent/mobileqq/guild/channel/frame/titlebar/GuildChannelTitleBarManager;", "Lcom/tencent/mobileqq/guild/channel/frame/titlebar/GuildChannelTitleBarManager;", "mChannelTitleManager", "Lcom/tencent/mobileqq/guild/media/presenter/GuildMediaShareAnimUseCase;", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/guild/media/presenter/GuildMediaShareAnimUseCase;", "mShareAnimUseCase", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaRankingUserCase;", "H", "()Lcom/tencent/mobileqq/guild/media/widget/GuildMediaRankingUserCase;", "mRankingListGuideUserCase", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "mSelfInfo", "Lcom/tencent/mobileqq/guild/media/floatwindow/FloatWindowPermissionHandler;", "Lcom/tencent/mobileqq/guild/media/floatwindow/FloatWindowPermissionHandler;", "mFloatWindowPermissionHandler", "com/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentTitleBarPresenter$c", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentTitleBarPresenter$c;", "mAudioObserver", "com/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentTitleBarPresenter$d", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentTitleBarPresenter$d;", "mShareABTestEventObserver", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;)V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelFragmentTitleBarPresenter implements ah, com.tencent.mobileqq.guild.channel.frame.titlebar.g {

    @NotNull
    private static final TitleBarTheme N = TitleBarTheme.TITLE_BAR_STYLE_02;

    /* renamed from: C, reason: from kotlin metadata */
    private GuildRightIconLayout mRankingListBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.e mCore;

    /* renamed from: F, reason: from kotlin metadata */
    private GuildChannelTitleBarManager mChannelTitleManager;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy mShareAnimUseCase;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRankingListGuideUserCase;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.media.core.data.f mSelfInfo;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final FloatWindowPermissionHandler mFloatWindowPermissionHandler;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final c mAudioObserver;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final d mShareABTestEventObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment mFragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mGuildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mChannelId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildAIOTitleBar mTitleBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildRightIconLayout mSettingBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GuildRightIconLayout mShareBtn;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentTitleBarPresenter$b", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/b;", "", "code", "", "fileId", "sessionId", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.thirdapp.share.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGProGuildInfo f229121b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IGProChannelInfo f229122c;

        b(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo) {
            this.f229121b = iGProGuildInfo;
            this.f229122c = iGProChannelInfo;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.share.b
        public void onResult(int code, @Nullable String fileId, @Nullable String sessionId) {
            Logger.f235387a.d().d("QGMC.MediaChannelFragmentTitleBarPresenter", 1, "[onResult] GuildMediaFetchShareUseCase code " + code + " fileId " + fileId + ", sessionId " + sessionId);
            if (sessionId == null) {
                sessionId = "";
            }
            MediaChannelFragmentTitleBarPresenter.this.G(this.f229121b, this.f229122c, new GuildMediaShareActionSheet.MediaShareExtraInfo(null, null, sessionId, null, 11, null));
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J0\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentTitleBarPresenter$c", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelNumber", "", "B", "from", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", "", HippyTKDListViewAdapter.X, "i", "j", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends y {
        c() {
        }

        private final String B(IGProChannelUserNum channelNumber) {
            boolean z16;
            if (channelNumber == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return "null";
            }
            if (!z16) {
                return "total: " + channelNumber.getUserNum() + ", player: " + channelNumber.getPlayersNum() + ", viewer: " + channelNumber.getViewersNum();
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void i() {
            MediaChannelFragmentTitleBarPresenter.this.m().k();
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void j(@Nullable String from, @Nullable IGProChannelUserNum channelNumber) {
            QLog.i("QGMC.MediaChannelFragmentTitleBarPresenter", 1, "[onUserNumberOfChannelChanged] from: " + from + ", data: " + B(channelNumber) + " ");
            MediaChannelFragmentTitleBarPresenter.this.L();
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void x(@Nullable String from, @Nullable String guildId, @Nullable String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo) {
            if (localUserInfo != null) {
                MediaChannelFragmentTitleBarPresenter.this.mSelfInfo = localUserInfo;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentTitleBarPresenter$d", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/aq;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.media.core.notify.o<aq> {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull aq event) {
            Intrinsics.checkNotNullParameter(event, "event");
            MediaChannelFragmentTitleBarPresenter.this.n().s();
        }
    }

    public MediaChannelFragmentTitleBarPresenter(@NotNull Fragment mFragment, @NotNull String mGuildId, @NotNull String mChannelId, @NotNull GuildAIOTitleBar mTitleBar) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mFragment, "mFragment");
        Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
        Intrinsics.checkNotNullParameter(mChannelId, "mChannelId");
        Intrinsics.checkNotNullParameter(mTitleBar, "mTitleBar");
        this.mFragment = mFragment;
        this.mGuildId = mGuildId;
        this.mChannelId = mChannelId;
        this.mTitleBar = mTitleBar;
        Context requireContext = mFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mFragment.requireContext()");
        this.mContext = requireContext;
        com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
        this.mCore = a16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildMediaShareAnimUseCase>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelFragmentTitleBarPresenter$mShareAnimUseCase$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.media.presenter.MediaChannelFragmentTitleBarPresenter$mShareAnimUseCase$2$1, reason: invalid class name */
            /* loaded from: classes14.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
                AnonymousClass1(Object obj) {
                    super(0, obj, MediaChannelFragmentTitleBarPresenter.class, "handleShareClick", "handleShareClick()V", 0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((MediaChannelFragmentTitleBarPresenter) this.receiver).r();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildMediaShareAnimUseCase invoke() {
                GuildRightIconLayout guildRightIconLayout;
                guildRightIconLayout = MediaChannelFragmentTitleBarPresenter.this.mShareBtn;
                if (guildRightIconLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                    guildRightIconLayout = null;
                }
                return new GuildMediaShareAnimUseCase(guildRightIconLayout, 2, "scene_audio", new AnonymousClass1(MediaChannelFragmentTitleBarPresenter.this));
            }
        });
        this.mShareAnimUseCase = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildMediaRankingUserCase>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelFragmentTitleBarPresenter$mRankingListGuideUserCase$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.media.presenter.MediaChannelFragmentTitleBarPresenter$mRankingListGuideUserCase$2$1, reason: invalid class name */
            /* loaded from: classes14.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
                AnonymousClass1(Object obj) {
                    super(0, obj, MediaChannelFragmentTitleBarPresenter.class, "handleRankingListClick", "handleRankingListClick()V", 0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((MediaChannelFragmentTitleBarPresenter) this.receiver).q();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildMediaRankingUserCase invoke() {
                GuildRightIconLayout guildRightIconLayout;
                guildRightIconLayout = MediaChannelFragmentTitleBarPresenter.this.mRankingListBtn;
                if (guildRightIconLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRankingListBtn");
                    guildRightIconLayout = null;
                }
                return new GuildMediaRankingUserCase(guildRightIconLayout, new AnonymousClass1(MediaChannelFragmentTitleBarPresenter.this));
            }
        });
        this.mRankingListGuideUserCase = lazy2;
        com.tencent.mobileqq.guild.media.core.data.f fVar = new com.tencent.mobileqq.guild.media.core.data.f();
        fVar.R = a16.isInChannel();
        this.mSelfInfo = fVar;
        this.mFloatWindowPermissionHandler = new FloatWindowPermissionHandler(mFragment.getActivity());
        this.mAudioObserver = new c();
        this.mShareABTestEventObserver = new d();
        v();
        t();
        u();
        GuildChannelTitleBarManager guildChannelTitleBarManager = this.mChannelTitleManager;
        if (guildChannelTitleBarManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelTitleManager");
            guildChannelTitleBarManager = null;
        }
        guildChannelTitleBarManager.D();
        x();
        E();
    }

    private final void A() {
        bw.f235485a.x1(true);
        J();
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildMediaChannelDetailFragment(((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface(), this.mContext, this.mGuildId, this.mChannelId, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(String errMsg) {
        this.mFloatWindowPermissionHandler.f();
        this.mCore.D("", errMsg);
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        this.mFloatWindowPermissionHandler.f();
        IGProGuildInfo guildInfo = com.tencent.mobileqq.guild.media.core.j.a().getGuildInfo();
        IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
        if (guildInfo != null && channelInfo != null) {
            Integer value = com.tencent.mobileqq.guild.media.core.j.c().T().getValue();
            Intrinsics.checkNotNull(value);
            GuildFloatWindowUtils.F(guildInfo, channelInfo, value.intValue(), false, 0, 24, null);
        } else {
            QLog.w("QGMC.MediaChannelFragmentTitleBarPresenter", 1, "[showFloatWindow] guildInfo or channelInfo is null, ignore");
        }
        l();
    }

    private final void E() {
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        GuildRightIconLayout guildRightIconLayout = this.mRankingListBtn;
        GuildRightIconLayout guildRightIconLayout2 = null;
        if (guildRightIconLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRankingListBtn");
            guildRightIconLayout = null;
        }
        iGuildDTReportApi.setElementExposureAndClickParams(guildRightIconLayout, "em_sgrp_contribute_charm_list_entry", null);
        GuildRightIconLayout guildRightIconLayout3 = this.mShareBtn;
        if (guildRightIconLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            guildRightIconLayout3 = null;
        }
        VideoReport.setElementExposePolicy(guildRightIconLayout3, ExposurePolicy.REPORT_ALL);
        GuildRightIconLayout guildRightIconLayout4 = this.mShareBtn;
        if (guildRightIconLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
        } else {
            guildRightIconLayout2 = guildRightIconLayout4;
        }
        VideoReport.setElementClickPolicy(guildRightIconLayout2, ClickPolicy.REPORT_NONE);
    }

    private final void F() {
        MediaChannelUtils.f228046a.H(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelFragmentTitleBarPresenter$showFloatWindow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MediaChannelFragmentTitleBarPresenter.this.D();
            }
        }, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelFragmentTitleBarPresenter$showFloatWindow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String err) {
                Intrinsics.checkNotNullParameter(err, "err");
                MediaChannelFragmentTitleBarPresenter.this.C(err);
            }
        }, "QGMC.MediaChannelFragmentTitleBarPresenter", this.mFragment.getActivity(), this.mFloatWindowPermissionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo, GuildMediaShareActionSheet.MediaShareExtraInfo extraInfo) {
        FragmentActivity requireActivity = this.mFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "mFragment.requireActivity()");
        GuildMediaShareActionSheet guildMediaShareActionSheet = new GuildMediaShareActionSheet(requireActivity, guildInfo, channelInfo, GuildMediaShareActionSheet.ShareScene.MEDIA_TITLE_BAR);
        if (extraInfo != null) {
            guildMediaShareActionSheet.W(extraInfo);
        }
        guildMediaShareActionSheet.z();
    }

    static /* synthetic */ void H(MediaChannelFragmentTitleBarPresenter mediaChannelFragmentTitleBarPresenter, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, GuildMediaShareActionSheet.MediaShareExtraInfo mediaShareExtraInfo, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            mediaShareExtraInfo = null;
        }
        mediaChannelFragmentTitleBarPresenter.G(iGProGuildInfo, iGProChannelInfo, mediaShareExtraInfo);
    }

    private final void I() {
        GuildRightIconLayout guildRightIconLayout = this.mShareBtn;
        if (guildRightIconLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            guildRightIconLayout = null;
        }
        guildRightIconLayout.setVisibility(0);
    }

    private final void J() {
        IconType iconType;
        GuildRightIconLayout guildRightIconLayout = this.mShareBtn;
        GuildRightIconLayout guildRightIconLayout2 = null;
        if (guildRightIconLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            guildRightIconLayout = null;
        }
        guildRightIconLayout.setVisibility(0);
        GuildRightIconLayout guildRightIconLayout3 = this.mSettingBtn;
        if (guildRightIconLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingBtn");
            guildRightIconLayout3 = null;
        }
        guildRightIconLayout3.setVisibility(0);
        GuildRightIconLayout guildRightIconLayout4 = this.mSettingBtn;
        if (guildRightIconLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingBtn");
        } else {
            guildRightIconLayout2 = guildRightIconLayout4;
        }
        TitleBarTheme titleBarTheme = N;
        if (bw.f235485a.Q()) {
            iconType = IconType.THREE_LINES_SETTING;
        } else {
            iconType = IconType.THREE_LINES_SETTING_RED_DOT;
        }
        guildRightIconLayout2.setIconRes(titleBarTheme, iconType);
    }

    private final void K() {
        GuildRightIconLayout guildRightIconLayout = this.mShareBtn;
        GuildRightIconLayout guildRightIconLayout2 = null;
        if (guildRightIconLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            guildRightIconLayout = null;
        }
        guildRightIconLayout.setVisibility(0);
        GuildRightIconLayout guildRightIconLayout3 = this.mSettingBtn;
        if (guildRightIconLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingBtn");
            guildRightIconLayout3 = null;
        }
        guildRightIconLayout3.setVisibility(0);
        GuildRightIconLayout guildRightIconLayout4 = this.mSettingBtn;
        if (guildRightIconLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingBtn");
        } else {
            guildRightIconLayout2 = guildRightIconLayout4;
        }
        guildRightIconLayout2.setIconRes(N, IconType.THREE_LINES_SETTING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        int W = com.tencent.mobileqq.guild.media.core.j.c().W();
        int X = com.tencent.mobileqq.guild.media.core.j.c().X();
        QLog.i("QGMC.MediaChannelFragmentTitleBarPresenter", 1, "updateChannelOnlineMemberCount, mOnLineNum[" + W + "], threshold: " + X);
        this.mTitleBar.setMemberCount(W, X);
    }

    private final void l() {
        if (!w(this.mFragment.getActivity())) {
            ((GuildMediaChannelViewModel) com.tencent.mobileqq.mvvm.h.a(g.f229131d).get(GuildMediaChannelViewModel.class)).P1().postValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildMediaRankingUserCase m() {
        return (GuildMediaRankingUserCase) this.mRankingListGuideUserCase.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildMediaShareAnimUseCase n() {
        return (GuildMediaShareAnimUseCase) this.mShareAnimUseCase.getValue();
    }

    private final int o(String guildId, String channelId) {
        List<cz> channelStateList;
        IAudioChannelState iAudioChannelState;
        dt guildState = ((IGPSService) ch.R0(IGPSService.class)).getGuildState(guildId);
        if (guildState == null || (channelStateList = guildState.getChannelStateList()) == null) {
            return 0;
        }
        for (cz czVar : channelStateList) {
            if (Intrinsics.areEqual(czVar.getChannelId(), channelId)) {
                Integer num = null;
                if (czVar instanceof IAudioChannelState) {
                    iAudioChannelState = (IAudioChannelState) czVar;
                } else {
                    iAudioChannelState = null;
                }
                if (iAudioChannelState != null) {
                    num = Integer.valueOf(iAudioChannelState.getChannelState());
                }
                int i3 = 4;
                if (num != null && num.intValue() == 4) {
                    return 1;
                }
                if (num != null && num.intValue() == 9) {
                    return 2;
                }
                if (num == null || num.intValue() != 17) {
                    if (num != null && num.intValue() == 8) {
                        return 5;
                    }
                    i3 = 6;
                    if (num == null || num.intValue() != 18) {
                        if (num == null || num.intValue() != 6) {
                            return 0;
                        }
                        if (com.tencent.mobileqq.guild.media.core.j.a().H0().C()) {
                            return 7;
                        }
                        return 3;
                    }
                }
                return i3;
            }
        }
        return 0;
    }

    private final void p(View v3) {
        GuildChannelTitleBarManager guildChannelTitleBarManager = this.mChannelTitleManager;
        if (guildChannelTitleBarManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelTitleManager");
            guildChannelTitleBarManager = null;
        }
        guildChannelTitleBarManager.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        if (com.tencent.mobileqq.guild.util.o.d("QGMC.MediaChannelFragmentTitleBarPresenter_ranking", 1000L)) {
            return;
        }
        QRouteApi api = QRoute.api(IGuildMediaChannelApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMediaChannelApi::class.java)");
        IGuildMediaChannelApi.a.i((IGuildMediaChannelApi) api, this.mGuildId, this.mChannelId, null, null, null, null, 60, null);
        Logger.f235387a.d().d("QGMC.MediaChannelFragmentTitleBarPresenter", 1, "[handleRankingListClick] ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        boolean z16;
        GuildRightIconLayout guildRightIconLayout = this.mShareBtn;
        if (guildRightIconLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            guildRightIconLayout = null;
        }
        if (com.tencent.mobileqq.guild.util.o.a(guildRightIconLayout)) {
            return;
        }
        n().u();
        com.tencent.mobileqq.guild.performance.report.e.b("audio_room_invite_button", null, 0, null, 0, null, 62, null);
        IGProGuildInfo guildInfo = com.tencent.mobileqq.guild.media.core.j.a().getGuildInfo();
        IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
        if (guildInfo != null && channelInfo != null) {
            s(guildInfo, channelInfo);
            if (com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()) == 6) {
                z16 = true;
            } else {
                z16 = false;
            }
            IGProLobbyAppInfo thirdAppInfo = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppInfo();
            IGProLobbyStateInfo lobbyRoomInfo = com.tencent.mobileqq.guild.media.core.j.a().d0().getLobbyRoomInfo();
            if (z16 && thirdAppInfo != null && lobbyRoomInfo != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", thirdAppInfo.getAppId());
                jSONObject.put("appName", thirdAppInfo.getAppName());
                jSONObject.put("channelId", com.tencent.mobileqq.guild.media.core.j.a().E());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playAppInfo", jSONObject);
                jSONObject2.put("query", "");
                Logger.f235387a.d().d("QGMC.MediaChannelFragmentTitleBarPresenter", 1, "[handleShareClick] GuildMediaFetchShareUseCase.request " + jSONObject2);
                g.Companion companion = com.tencent.mobileqq.guild.media.thirdapp.share.g.INSTANCE;
                String jSONObject3 = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "queryString.toString()");
                companion.b(jSONObject3, "", new b(guildInfo, channelInfo));
                return;
            }
            H(this, guildInfo, channelInfo, null, 4, null);
            return;
        }
        QLog.w("QGMC.MediaChannelFragmentTitleBarPresenter", 1, "[handleShareClick] guildInfo or channelInfo is null, ignore");
    }

    private final void s(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
        HashMap hashMapOf;
        String guildID = guildInfo.getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
        String channelUin = channelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
        int o16 = o(guildID, channelUin);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        GuildRightIconLayout guildRightIconLayout = this.mShareBtn;
        if (guildRightIconLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            guildRightIconLayout = null;
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_avchannel_enter_playmodule", Integer.valueOf(o16)));
        iGuildDTReportApi.reportDtEventManual(guildRightIconLayout, "em_sgrp_subchannel_top_invite", "clck", hashMapOf);
    }

    private final void t() {
        L();
    }

    private final void u() {
        Context requireContext = this.mFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mFragment.requireContext()");
        String str = this.mGuildId;
        String str2 = this.mChannelId;
        Bundle arguments = this.mFragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        GuildChannelTitleBarManager guildChannelTitleBarManager = new GuildChannelTitleBarManager(requireContext, str, str2, arguments);
        this.mChannelTitleManager = guildChannelTitleBarManager;
        guildChannelTitleBarManager.z(this.mTitleBar);
        GuildChannelTitleBarManager guildChannelTitleBarManager2 = this.mChannelTitleManager;
        GuildChannelTitleBarManager guildChannelTitleBarManager3 = null;
        if (guildChannelTitleBarManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelTitleManager");
            guildChannelTitleBarManager2 = null;
        }
        guildChannelTitleBarManager2.y(this);
        GuildChannelTitleBarManager guildChannelTitleBarManager4 = this.mChannelTitleManager;
        if (guildChannelTitleBarManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelTitleManager");
            guildChannelTitleBarManager4 = null;
        }
        guildChannelTitleBarManager4.q();
        GuildChannelTitleBarManager guildChannelTitleBarManager5 = this.mChannelTitleManager;
        if (guildChannelTitleBarManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelTitleManager");
        } else {
            guildChannelTitleBarManager3 = guildChannelTitleBarManager5;
        }
        guildChannelTitleBarManager3.D();
        this.mTitleBar.setTitleBarClickListener(this);
    }

    private final void v() {
        List<? extends IconType> listOf;
        List listOf2;
        GuildAIOTitleBar guildAIOTitleBar = this.mTitleBar;
        IconType iconType = IconType.RANKING_LIST;
        IconType iconType2 = IconType.SHARE;
        IconType iconType3 = IconType.THREE_DOTS_SETTING;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IconType[]{iconType, iconType2, iconType3});
        guildAIOTitleBar.setRightIcons(listOf);
        GuildRightIconLayout E0 = this.mTitleBar.E0(iconType2);
        Intrinsics.checkNotNull(E0);
        this.mShareBtn = E0;
        GuildRightIconLayout E02 = this.mTitleBar.E0(iconType3);
        Intrinsics.checkNotNull(E02);
        this.mSettingBtn = E02;
        GuildRightIconLayout E03 = this.mTitleBar.E0(iconType);
        Intrinsics.checkNotNull(E03);
        this.mRankingListBtn = E03;
        GuildRightIconLayout[] guildRightIconLayoutArr = new GuildRightIconLayout[2];
        GuildRightIconLayout guildRightIconLayout = this.mShareBtn;
        GuildRightIconLayout guildRightIconLayout2 = null;
        if (guildRightIconLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            guildRightIconLayout = null;
        }
        guildRightIconLayoutArr[0] = guildRightIconLayout;
        GuildRightIconLayout guildRightIconLayout3 = this.mSettingBtn;
        if (guildRightIconLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingBtn");
            guildRightIconLayout3 = null;
        }
        guildRightIconLayoutArr[1] = guildRightIconLayout3;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) guildRightIconLayoutArr);
        Iterator it = listOf2.iterator();
        while (it.hasNext()) {
            ((GuildRightIconLayout) it.next()).setVisibility(8);
        }
        GuildRightIconLayout guildRightIconLayout4 = this.mShareBtn;
        if (guildRightIconLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
        } else {
            guildRightIconLayout2 = guildRightIconLayout4;
        }
        VideoReport.setElementId(guildRightIconLayout2, "em_sgrp_subchannel_top_invite");
    }

    private final boolean w(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    private final void x() {
        this.mCore.l0().b(this.mAudioObserver);
        com.tencent.mobileqq.guild.media.core.notify.p d16 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner = this.mFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "mFragment.viewLifecycleOwner");
        d16.k0(viewLifecycleOwner, aq.class, this.mShareABTestEventObserver);
    }

    private final void y(View view) {
        GuildChannelTitleBarManager guildChannelTitleBarManager = this.mChannelTitleManager;
        if (guildChannelTitleBarManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelTitleManager");
            guildChannelTitleBarManager = null;
        }
        FragmentActivity requireActivity = this.mFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "mFragment.requireActivity()");
        guildChannelTitleBarManager.s(requireActivity);
        VideoReport.setElementId(view, "em_sgrp_half_channel");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, null);
    }

    public final void B() {
        GuildChannelTitleBarManager guildChannelTitleBarManager = this.mChannelTitleManager;
        if (guildChannelTitleBarManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelTitleManager");
            guildChannelTitleBarManager = null;
        }
        guildChannelTitleBarManager.v();
    }

    @Override // com.tencent.mobileqq.guild.channel.frame.titlebar.g
    public void H5(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        if (!ch.l0(guildInfo) && !channelInfo.isChannelOrCategoryAdmin()) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean j06 = ch.j0(guildInfo.getGuildID());
        if (z16) {
            J();
        } else if (j06) {
            I();
        } else {
            K();
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.frame.titlebar.g
    @Nullable
    public JumpGuildParam.JoinInfoParam T3() {
        JumpGuildParam jumpGuildParam = MediaChannelCore.INSTANCE.a().o0().getStartParams().getJumpGuildParam();
        if (jumpGuildParam != null) {
            return jumpGuildParam.getJoinInfoParam();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.widget.ah
    public void u2(@NotNull ClickType clickType, @NotNull View v3) {
        Intrinsics.checkNotNullParameter(clickType, "clickType");
        Intrinsics.checkNotNullParameter(v3, "v");
        if (com.tencent.mobileqq.guild.util.o.c("QGMC.MediaChannelFragmentTitleBarPresenter_onClick")) {
            return;
        }
        QLog.i("QGMC.MediaChannelFragmentTitleBarPresenter", 1, "[onClick] clickType: " + clickType);
        if (clickType == ClickType.SCALE) {
            F();
            return;
        }
        if (clickType == ClickType.JOIN) {
            p(v3);
            return;
        }
        if (clickType != ClickType.THREE_LINES_SETTING && clickType != ClickType.THREE_LINES_SETTING_RED_DOT) {
            if (clickType == ClickType.SHOW_GUILD_DIALOG) {
                y(v3);
                return;
            }
            if (clickType == ClickType.SHARE) {
                r();
                return;
            } else if (clickType == ClickType.BACK) {
                l();
                return;
            } else {
                if (clickType == ClickType.RANKING_LIST) {
                    q();
                    return;
                }
                return;
            }
        }
        A();
    }

    public final void z() {
        this.mCore.l0().B(this.mAudioObserver);
        GuildChannelTitleBarManager guildChannelTitleBarManager = this.mChannelTitleManager;
        if (guildChannelTitleBarManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelTitleManager");
            guildChannelTitleBarManager = null;
        }
        guildChannelTitleBarManager.r();
    }
}
