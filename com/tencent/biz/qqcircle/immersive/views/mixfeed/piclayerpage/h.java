package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QFSVideoControlEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSNewContentDetailPicPositionChangeEvent;
import com.tencent.biz.qqcircle.immersive.gallery.view.QFSGalleryProgressViewNoAnim;
import com.tencent.biz.qqcircle.immersive.report.QFSImageBannerReport;
import com.tencent.biz.qqcircle.immersive.request.QFSGetMusicInfoRequest;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.immersive.views.QFSAudioView;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.widget.video.QFSAudioFocusManager;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerUpperData;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.event.QCircleKeyVolumeChangeEvent;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.richframework.sender.call.Call;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedMusic;
import feedcloud.FeedCloudMeta$StImage;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;
import qqcircle.QQCircleSmartMatchMusic$SongInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 \u008c\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001GB\u0011\u0012\u0006\u0010P\u001a\u00020M\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010'\u001a\u00020\u0004H\u0002J \u0010-\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\nH\u0002J\b\u0010.\u001a\u00020\u0004H\u0002J\b\u0010/\u001a\u00020\u0014H\u0002J\b\u00100\u001a\u00020\u0004H\u0002J\b\u00101\u001a\u00020\u0004H\u0002J\u0010\u00102\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0002J\u001a\u00105\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010\u000e2\u0006\u00104\u001a\u00020\nH\u0002J\u0010\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0016J\u0018\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J0\u0010?\u001a*\u0012\u0010\u0012\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010=\u0018\u00010<0;j\u0014\u0012\u0010\u0012\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010=\u0018\u00010<`>H\u0016J\u0012\u0010A\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010C\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010E\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u000106H\u0016J\b\u0010F\u001a\u00020\u000eH\u0016J\u0006\u0010G\u001a\u00020\u0004J\u0012\u0010J\u001a\u00020\u00042\b\u0010I\u001a\u0004\u0018\u00010HH\u0016J\u0012\u0010K\u001a\u00020\u00042\b\u0010I\u001a\u0004\u0018\u00010HH\u0016J\b\u0010L\u001a\u00020\u0004H\u0016R\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010SR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010SR\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010NR\u0016\u0010x\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010NR\u0016\u0010{\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010}\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010zR\u0016\u0010\u007f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010zR0\u0010\u0085\u0001\u001a\u00020\u00142\u0007\u0010\u0080\u0001\u001a\u00020\u00148B@BX\u0082\u000e\u00a2\u0006\u0016\n\u0004\bz\u0010z\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0017\u0010\u0087\u0001\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0082\u0001R\u0017\u0010\u0089\u0001\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0082\u0001\u00a8\u0006\u008d\u0001"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/h;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Landroid/view/View$OnClickListener;", "", "d2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "A1", "W1", "C1", "", "position", "P1", "c2", "", "eventId", com.tencent.luggage.wxa.c8.c.G, "count", "direction", "E1", "", "isClick", "isMute", Constants.BASE_IN_PLUGIN_ID, "y1", "z1", "isVisible", "U1", "targetW", "F1", "e2", "N1", "Lcom/tencent/biz/qqcircle/events/QFSVideoControlEvent;", "event", "H1", "Lcom/tencent/mobileqq/qcircle/api/event/QCircleKeyVolumeChangeEvent;", "I1", "J1", "Z1", "K1", "Lcom/tencent/biz/richframework/video/rfw/player/RFWPlayerOptions;", "options", "Lfeedcloud/FeedCloudMeta$StFeedMusic;", "music", "offset", "x1", "S1", "B1", "V1", "Q1", "w1", "mid", "start", "R1", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "data", "O1", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", "getEventClass", "simpleBaseEvent", "onReceiveEvent", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "C0", "v", NodeProps.ON_CLICK, "w0", "a", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onResumed", "onPaused", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "I", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "mInitBean", "Landroid/widget/FrameLayout;", "J", "Landroid/widget/FrameLayout;", "mFlBannerContainer", "Lcom/tencent/biz/qqcircle/immersive/views/banner/QFSImageBanner;", "K", "Lcom/tencent/biz/qqcircle/immersive/views/banner/QFSImageBanner;", "mBanner", "L", "mProgressFl", "Lcom/tencent/biz/qqcircle/immersive/gallery/view/QFSGalleryProgressViewNoAnim;", "M", "Lcom/tencent/biz/qqcircle/immersive/gallery/view/QFSGalleryProgressViewNoAnim;", "mProgressView", "N", "mMuteContainer", "Landroid/widget/TextView;", "P", "Landroid/widget/TextView;", "mTvPosition", "Landroid/widget/ImageView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/ImageView;", "mMuteIcon", "Lcom/tencent/biz/qqcircle/immersive/views/QFSAudioView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/biz/qqcircle/immersive/views/QFSAudioView;", "mAudioView", "Lcom/tencent/biz/qqcircle/widgets/QCircleDoublePraiseView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/biz/qqcircle/widgets/QCircleDoublePraiseView;", "mPraiseView", "Lcom/tencent/biz/qqcircle/immersive/report/QFSImageBannerReport;", "T", "Lcom/tencent/biz/qqcircle/immersive/report/QFSImageBannerReport;", "mBannerReport", "U", "mTotalCount", "V", "mCurrentPosition", "W", "Z", "mMusicHashGrant", "X", "mShouldPlayAudio", "Y", "mIsAudioMuted", "value", Constants.APK_CERTIFICATE, "()Z", "T1", "(Z)V", "mPicAutoPlay", "M1", "isShowProgressView", "L1", "isFeedPicType", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)V", "a0", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class h extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: b0, reason: collision with root package name */
    private static final int f90966b0 = cx.a(470.0f);

    /* renamed from: c0, reason: collision with root package name */
    private static final int f90967c0 = cx.a(242.0f);

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final QCircleInitBean mInitBean;

    /* renamed from: J, reason: from kotlin metadata */
    private FrameLayout mFlBannerContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private QFSImageBanner mBanner;

    /* renamed from: L, reason: from kotlin metadata */
    private FrameLayout mProgressFl;

    /* renamed from: M, reason: from kotlin metadata */
    private QFSGalleryProgressViewNoAnim mProgressView;

    /* renamed from: N, reason: from kotlin metadata */
    private FrameLayout mMuteContainer;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView mTvPosition;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImageView mMuteIcon;

    /* renamed from: R, reason: from kotlin metadata */
    private QFSAudioView mAudioView;

    /* renamed from: S, reason: from kotlin metadata */
    private QCircleDoublePraiseView mPraiseView;

    /* renamed from: T, reason: from kotlin metadata */
    private QFSImageBannerReport mBannerReport;

    /* renamed from: U, reason: from kotlin metadata */
    private int mTotalCount;

    /* renamed from: V, reason: from kotlin metadata */
    private int mCurrentPosition;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean mMusicHashGrant;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean mShouldPlayAudio;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean mIsAudioMuted;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean mPicAutoPlay;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/h$b", "Lcom/tencent/biz/richframework/video/rfw/player/ioc/RFWPlayerIOC;", "", AppConstants.Key.COLUMN_IS_VALID, "Lcom/tencent/biz/richframework/video/rfw/player/stinfo/RFWPlayerReportInfo;", "Le30/b;", "getBusinessReportInfo", "Lcom/tencent/biz/richframework/video/rfw/player/ioc/RFWPlayerUpperData;", "getPlayerUpperData", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RFWPlayerIOC {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        @Nullable
        public RFWPlayerReportInfo<e30.b> getBusinessReportInfo() {
            return gb0.b.m(((QFSBaseFeedChildPresenter) h.this).E.o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(((QFSBaseFeedChildPresenter) h.this).f85018i)));
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        @Nullable
        /* renamed from: getPlayerUpperData */
        public RFWPlayerUpperData getUpperData() {
            return new RFWPlayerUpperData().addValue("QFS_PLAYER_MUTE_KEY", Boolean.FALSE);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/h$d", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayErrorStatusListener;", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "", "onVideoPlayError", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d implements IRFWPlayErrorStatusListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeedMusic f90971e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f90972f;

        d(FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic, int i3) {
            this.f90971e = feedCloudMeta$StFeedMusic;
            this.f90972f = i3;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
        public void onVideoPlayError(int module, int errorType, int errorCode, @Nullable String extraInfo) {
            QFSAudioView qFSAudioView = h.this.mAudioView;
            if (qFSAudioView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                qFSAudioView = null;
            }
            if (qFSAudioView.getSuperPlayer() != null) {
                h.this.R1(this.f90971e.MID.get(), this.f90972f);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J@\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/h$e", "Lcom/tencent/richframework/sender/call/Call$OnRspCallBack;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "isSuccess", "", "retCode", "", "errMsg", "reqObj", "", "rspObj", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements Call.OnRspCallBack<QCircleBaseRequest> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f90974e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f90975f;

        e(String str, int i3) {
            this.f90974e = str;
            this.f90975f = i3;
        }

        @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable QCircleBaseRequest reqObj, @Nullable Object rspObj, @Nullable Bundle extraData) {
            if (!(rspObj instanceof QQCircleSmartMatchMusic$MusicInfoRsp)) {
                return;
            }
            QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp = (QQCircleSmartMatchMusic$MusicInfoRsp) rspObj;
            if (qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.isEmpty()) {
                QLog.e(h.this.getTAG(), 1, "[requestMusicInfo] musicListInfo is null");
                return;
            }
            QQCircleSmartMatchMusic$SongInfo qQCircleSmartMatchMusic$SongInfo = qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.get().get(0).songInfo;
            if (qQCircleSmartMatchMusic$SongInfo == null) {
                QLog.e(h.this.getTAG(), 1, "[requestMusicInfo] songInfo is null");
                return;
            }
            RFWPlayerOptions options = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setFileId(this.f90974e).setPlayUrl(qQCircleSmartMatchMusic$SongInfo.get().PlayUrl.get()).setIsVideo(false).setStartOffset(this.f90975f);
            h hVar = h.this;
            Intrinsics.checkNotNullExpressionValue(options, "options");
            hVar.w1(options);
            QFSAudioView qFSAudioView = h.this.mAudioView;
            if (qFSAudioView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                qFSAudioView = null;
            }
            qFSAudioView.loadPlayOptions(options);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/h$f", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class f extends ViewPager2.OnPageChangeCallback {
        f() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            String str;
            super.onPageSelected(position);
            w20.a.j().t(((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) h.this).f85017h).f398449id.get(), position);
            h.this.c2(position);
            int i3 = position - h.this.mCurrentPosition;
            if (i3 != 0) {
                h hVar = h.this;
                int size = hVar.n0().images.size();
                if (i3 < 0) {
                    str = "left";
                } else {
                    str = "right";
                }
                hVar.E1("ev_xsj_left_right_slide", position, size, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/h$g", "Lcom/tencent/biz/qqcircle/immersive/views/banner/QFSImageBanner$d;", "", "eventX", "eventY", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class g implements QFSImageBanner.d {
        g() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.d
        public void a(float eventX, float eventY) {
            QLog.d(h.this.getTAG(), 1, "QFSImageBanner [onItemDoubleClick]");
            QCircleDoublePraiseView qCircleDoublePraiseView = h.this.mPraiseView;
            if (qCircleDoublePraiseView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPraiseView");
                qCircleDoublePraiseView = null;
            }
            qCircleDoublePraiseView.c(eventX, eventY);
            h.this.C1();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/h$h", "Lcom/tencent/biz/qqcircle/immersive/views/banner/QFSImageBanner$c;", "", "position", "", "onItemClick", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.h$h, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0917h implements QFSImageBanner.c {
        C0917h() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.c
        public void onItemClick(int position) {
            QLog.d(h.this.getTAG(), 1, "QFSImageBanner [onItemClick]");
            h.this.N1();
            h hVar = h.this;
            hVar.E1("dt_clck", position, hVar.n0().images.size(), "");
        }
    }

    public h(@NotNull QCircleInitBean mInitBean) {
        Intrinsics.checkNotNullParameter(mInitBean, "mInitBean");
        this.mInitBean = mInitBean;
        this.mCurrentPosition = -1;
        this.mMusicHashGrant = true;
        this.mIsAudioMuted = tb0.a.f435779d.b();
    }

    private final void A1() {
        int i3;
        FrameLayout frameLayout = this.mMuteContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteContainer");
            frameLayout = null;
        }
        if (!(frameLayout.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            QLog.e(getTAG(), 1, "[adjustMuteBottomMargin] lp error");
            return;
        }
        FrameLayout frameLayout3 = this.mMuteContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteContainer");
            frameLayout3 = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (M1()) {
            i3 = 23;
        } else {
            i3 = 8;
        }
        layoutParams2.bottomMargin = cx.a(i3);
        FrameLayout frameLayout4 = this.mMuteContainer;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteContainer");
        } else {
            frameLayout2 = frameLayout4;
        }
        frameLayout2.setLayoutParams(layoutParams2);
    }

    private final boolean B1() {
        boolean E0 = E0();
        QLog.d(getTAG(), 1, "[canPlayAudio] isFeedOnScreen = " + E0 + ", isGalleryPageOnShow = " + QCirclePluginUtil.isGalleryPageOnShow());
        if (E0 || QCirclePluginUtil.isGalleryPageOnShow()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_action_type", "like");
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, n0().poster.f398463id.get());
        buildElementParams.put("dt_eid", QCircleDaTongConstant.ElementId.EM_XSJ_PICTURE_BUTTON);
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_LIKE_WORK, buildElementParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D1(boolean isClick, boolean isMute) {
        String str;
        FrameLayout frameLayout = this.mMuteContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteContainer");
            frameLayout = null;
        }
        VideoReport.setElementClickPolicy(frameLayout, ClickPolicy.REPORT_NONE);
        FrameLayout frameLayout3 = this.mMuteContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteContainer");
            frameLayout3 = null;
        }
        VideoReport.setElementId(frameLayout3, QCircleDaTongConstant.ElementId.EM_XSJ_MUTE_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, ((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get());
        if (isMute) {
            str = "mute";
        } else {
            str = QCircleDaTongConstant.ElementParamValue.UNMUTE;
        }
        buildElementParams.put("xsj_action_type", str);
        buildElementParams.put("xsj_music_id", Long.valueOf(((FeedCloudMeta$StFeed) this.f85017h).musicInfo.ID.get()));
        buildElementParams.put("xsj_music_name", ((FeedCloudMeta$StFeed) this.f85017h).musicInfo.musicName.get());
        if (isClick) {
            FrameLayout frameLayout4 = this.mMuteContainer;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMuteContainer");
            } else {
                frameLayout2 = frameLayout4;
            }
            VideoReport.reportEvent("dt_clck", frameLayout2, buildElementParams);
            return;
        }
        FrameLayout frameLayout5 = this.mMuteContainer;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteContainer");
        } else {
            frameLayout2 = frameLayout5;
        }
        VideoReport.setElementParams(frameLayout2, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void E1(String eventId, int pos, int count, String direction) {
        FrameLayout frameLayout = this.mFlBannerContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlBannerContainer");
            frameLayout = null;
        }
        VideoReport.setElementId(frameLayout, QCircleDaTongConstant.ElementId.EM_XSJ_PICTURE_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, ((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_START_INDEX, Integer.valueOf(pos));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PICTURE_INDEX, Integer.valueOf(pos));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_PIC_NUM, Integer.valueOf(count));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_DIRECTION_TYPE, direction);
        FrameLayout frameLayout3 = this.mFlBannerContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlBannerContainer");
        } else {
            frameLayout2 = frameLayout3;
        }
        VideoReport.reportEvent(eventId, frameLayout2, buildElementParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int F1(int targetW) {
        if (((FeedCloudMeta$StFeed) this.f85017h).images.size() < 1) {
            U1(false);
            return 0;
        }
        U1(true);
        FeedCloudMeta$StImage feedCloudMeta$StImage = ((FeedCloudMeta$StFeed) this.f85017h).images.get().get(0);
        int i3 = (feedCloudMeta$StImage.height.get() * targetW) / feedCloudMeta$StImage.width.get();
        int i16 = f90966b0;
        if (i3 > i16 || i3 < (i16 = f90967c0)) {
            return i16;
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean G1() {
        return w20.a.j().d(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H1(QFSVideoControlEvent event) {
        if (!QCirclePluginUtil.isGalleryPageOnShow() || !Intrinsics.areEqual(event.getFeedId(), ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get())) {
            return;
        }
        QLog.d(getTAG(), 1, "[handleAudioChangeEvent] event.isPlay = " + event + ".isPlay");
        if (event.isPlay()) {
            S1();
        } else {
            Q1();
        }
    }

    private final void I1(QCircleKeyVolumeChangeEvent event) {
        QLog.d(getTAG(), 1, "[handleKeyVolumeChangeEvent] keyCode = " + event);
        if (event.getKeyCode() != 24) {
            return;
        }
        QFSAudioView qFSAudioView = this.mAudioView;
        QFSAudioView qFSAudioView2 = null;
        if (qFSAudioView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
            qFSAudioView = null;
        }
        if (qFSAudioView.getSuperPlayer() == null) {
            QLog.e(getTAG(), 1, "[handleKeyVolumeChangeEvent] superPlayer is null");
            return;
        }
        if (!E0() && !QCirclePluginUtil.isGalleryPageOnShow()) {
            QLog.e(getTAG(), 1, "[handleKeyVolumeChangeEvent] feed is not on screen, and not open gallery page");
            return;
        }
        QFSAudioView qFSAudioView3 = this.mAudioView;
        if (qFSAudioView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
            qFSAudioView3 = null;
        }
        if (qFSAudioView3.getSuperPlayer().isPlaying()) {
            QFSAudioView qFSAudioView4 = this.mAudioView;
            if (qFSAudioView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
            } else {
                qFSAudioView2 = qFSAudioView4;
            }
            if (!qFSAudioView2.getOutPutMute()) {
                QLog.d(getTAG(), 1, "[handleKeyVolumeChangeEvent] audio is playing");
                return;
            }
        }
        J1();
    }

    private final void J1() {
        QFSAudioView qFSAudioView = this.mAudioView;
        QFSAudioView qFSAudioView2 = null;
        QFSImageBanner qFSImageBanner = null;
        if (qFSAudioView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
            qFSAudioView = null;
        }
        if (qFSAudioView.getSuperPlayer() == null) {
            return;
        }
        if (this.mIsAudioMuted) {
            QFSAudioView qFSAudioView3 = this.mAudioView;
            if (qFSAudioView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                qFSAudioView3 = null;
            }
            qFSAudioView3.start();
            this.mShouldPlayAudio = true;
            this.mIsAudioMuted = false;
            QFSAudioView qFSAudioView4 = this.mAudioView;
            if (qFSAudioView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                qFSAudioView4 = null;
            }
            qFSAudioView4.setOutPutMute(false);
            Z1(this.mIsAudioMuted);
            tb0.a.f435779d.c(false);
            if (!G1()) {
                T1(true);
                QFSImageBanner qFSImageBanner2 = this.mBanner;
                if (qFSImageBanner2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBanner");
                } else {
                    qFSImageBanner = qFSImageBanner2;
                }
                qFSImageBanner.v0();
            }
            D1(true, false);
        } else {
            QFSAudioView qFSAudioView5 = this.mAudioView;
            if (qFSAudioView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
            } else {
                qFSAudioView2 = qFSAudioView5;
            }
            qFSAudioView2.setOutPutMute(true);
            this.mIsAudioMuted = true;
            Z1(true);
            tb0.a.f435779d.c(true);
            D1(true, true);
        }
        if (!this.mMusicHashGrant) {
            V1();
            QLog.e(getTAG(), 1, "[updateMuteIcon] music has not grant");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K1() {
        QFSAudioView qFSAudioView = this.mAudioView;
        QFSAudioView qFSAudioView2 = null;
        if (qFSAudioView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
            qFSAudioView = null;
        }
        if (qFSAudioView.getSuperPlayer() != null) {
            QFSAudioView qFSAudioView3 = this.mAudioView;
            if (qFSAudioView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                qFSAudioView3 = null;
            }
            if (qFSAudioView3.getSuperPlayer().isPlaying()) {
                QLog.e(getTAG(), 1, "[startPlayer] player is playing");
                return;
            }
        }
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic = ((FeedCloudMeta$StFeed) this.f85017h).musicInfo;
        if (feedCloudMeta$StFeedMusic == null) {
            QLog.e(getTAG(), 1, "[startPlayer] music == null");
            return;
        }
        if (!TextUtils.isEmpty(feedCloudMeta$StFeedMusic.MID.get()) && !TextUtils.isEmpty(feedCloudMeta$StFeedMusic.playUrl.get())) {
            this.mMusicHashGrant = true;
            int i3 = feedCloudMeta$StFeedMusic.startPos.get();
            int i16 = feedCloudMeta$StFeedMusic.endPos.get();
            int c16 = w20.a.j().c(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
            QLog.d(getTAG(), 1, "[startPlayer] url = " + feedCloudMeta$StFeedMusic.playUrl.get() + ",start = " + i3 + ",end = " + i16);
            QFSAudioView qFSAudioView4 = this.mAudioView;
            if (qFSAudioView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                qFSAudioView4 = null;
            }
            qFSAudioView4.setPlayRange(feedCloudMeta$StFeedMusic.startPos.get(), i16);
            RFWPlayerOptions options = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setFileId(feedCloudMeta$StFeedMusic.MID.get()).setPlayUrl(feedCloudMeta$StFeedMusic.playUrl.get()).setIsVideo(false).setStartOffset(c16);
            Intrinsics.checkNotNullExpressionValue(options, "options");
            w1(options);
            x1(options, feedCloudMeta$StFeedMusic, c16);
            QFSAudioView qFSAudioView5 = this.mAudioView;
            if (qFSAudioView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                qFSAudioView5 = null;
            }
            qFSAudioView5.loadPlayOptions(options);
            QFSAudioView qFSAudioView6 = this.mAudioView;
            if (qFSAudioView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                qFSAudioView6 = null;
            }
            qFSAudioView6.setOutPutMute(this.mIsAudioMuted);
            if (!G1()) {
                QFSAudioView qFSAudioView7 = this.mAudioView;
                if (qFSAudioView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                } else {
                    qFSAudioView2 = qFSAudioView7;
                }
                qFSAudioView2.stop();
                return;
            }
            return;
        }
        this.mMusicHashGrant = false;
        Z1(true);
        QLog.e(getTAG(), 1, "[startPlayer] mid or url is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean L1() {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).type.get() == 2) {
            return true;
        }
        return false;
    }

    private final boolean M1() {
        if (this.mTotalCount > 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void N1() {
        QCirclePluginUtil.setIsGalleryPageOnShow(true);
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setFeed((FeedCloudMeta$StFeed) this.f85017h);
        qCircleInitBean.setEnableReleaseAudioFocus(false);
        qCircleInitBean.setFromReportBean(getReportBean());
        com.tencent.biz.qqcircle.launcher.c.F(m0(), qCircleInitBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P1(int position) {
        QLog.i(getTAG(), 1, "[openSharePanel] -> position = " + position);
        QCircleShareInfo c16 = au.c((FeedCloudMeta$StFeed) this.f85017h);
        c16.isEnableShareToMutual = com.tencent.biz.qqcircle.immersive.utils.a.c();
        c16.type = 15;
        c16.isShowBarrageSwitch = false;
        c16.isShareBottomBarrageSwitch = com.tencent.biz.qqcircle.immersive.utils.o.e((FeedCloudMeta$StFeed) this.f85017h);
        c16.feedBlockData = new e30.b((FeedCloudMeta$StFeed) this.f85017h);
        c16.mReportBean = getReportBean();
        c16.picDownPos = position;
        s0().onHandlerMessage("event_open_share", c16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Q1() {
        if (QCirclePluginUtil.isSharePanelOnShow()) {
            QLog.d(getTAG(), 1, "[pausePlayer] isSharePanelOnShow don't release player");
            return;
        }
        QFSAudioView qFSAudioView = this.mAudioView;
        QFSAudioView qFSAudioView2 = null;
        if (qFSAudioView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
            qFSAudioView = null;
        }
        if (qFSAudioView.getSuperPlayer() != null) {
            QFSAudioView qFSAudioView3 = this.mAudioView;
            if (qFSAudioView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                qFSAudioView3 = null;
            }
            if (qFSAudioView3.getSuperPlayer().isPlaying()) {
                String tag = getTAG();
                QFSAudioView qFSAudioView4 = this.mAudioView;
                if (qFSAudioView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                    qFSAudioView4 = null;
                }
                QLog.d(tag, 1, "[pausePlayer] " + qFSAudioView4.getSuperPlayer().getCurrentPositionMs());
                w20.a j3 = w20.a.j();
                String str = ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get();
                QFSAudioView qFSAudioView5 = this.mAudioView;
                if (qFSAudioView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                    qFSAudioView5 = null;
                }
                j3.q(str, (int) qFSAudioView5.getSuperPlayer().getCurrentPositionMs());
                QFSAudioView qFSAudioView6 = this.mAudioView;
                if (qFSAudioView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                } else {
                    qFSAudioView2 = qFSAudioView6;
                }
                qFSAudioView2.pause();
                return;
            }
        }
        QLog.e(getTAG(), 1, "player is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R1(String mid, int start) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(mid);
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSGetMusicInfoRequest(arrayList)).m250setRspOnCallBack((Call.OnRspCallBack) new e(mid, start)).execute();
    }

    private final void S1() {
        if (!B1()) {
            QLog.e(getTAG(), 1, "[resumePlayer] can not play audio");
            return;
        }
        QLog.d(getTAG(), 1, "[resumePlayer] mIsAudioMuted:" + this.mIsAudioMuted + ", mPicAutoPlay:" + G1() + ", mShouldPlayAudio:" + this.mShouldPlayAudio);
        Z1(this.mIsAudioMuted);
        if (this.mShouldPlayAudio) {
            QFSAudioView qFSAudioView = this.mAudioView;
            if (qFSAudioView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                qFSAudioView = null;
            }
            qFSAudioView.start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T1(boolean z16) {
        this.mPicAutoPlay = z16;
        w20.a.j().r(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), z16);
    }

    private final void U1(boolean isVisible) {
        int i3;
        FrameLayout frameLayout = this.mFlBannerContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlBannerContainer");
            frameLayout = null;
        }
        if (isVisible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
    }

    private final void V1() {
        QCircleToast.j(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f1919846_), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void W1() {
        y1();
        com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.f fVar = new com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.f();
        fVar.s0(uq3.c.P2());
        fVar.q0(uq3.c.O2());
        fVar.setEnableLoop(true);
        fVar.w0((FeedCloudMeta$StFeed) this.f85017h);
        fVar.notifyDataSetChanged();
        QFSImageBanner qFSImageBanner = this.mBanner;
        QFSImageBanner qFSImageBanner2 = null;
        if (qFSImageBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner = null;
        }
        qFSImageBanner.setAdapter(fVar);
        QFSImageBanner qFSImageBanner3 = this.mBanner;
        if (qFSImageBanner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner3 = null;
        }
        qFSImageBanner3.setEnableOperate(true);
        QFSImageBanner qFSImageBanner4 = this.mBanner;
        if (qFSImageBanner4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner4 = null;
        }
        qFSImageBanner4.setStopBanner(false);
        QFSImageBanner qFSImageBanner5 = this.mBanner;
        if (qFSImageBanner5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner5 = null;
        }
        if (qFSImageBanner5.X() != null) {
            QFSImageBanner qFSImageBanner6 = this.mBanner;
            if (qFSImageBanner6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBanner");
                qFSImageBanner6 = null;
            }
            qFSImageBanner6.X().setOffscreenPageLimit(1);
        }
        QFSImageBanner qFSImageBanner7 = this.mBanner;
        if (qFSImageBanner7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner7 = null;
        }
        qFSImageBanner7.q0(new f());
        QFSImageBanner qFSImageBanner8 = this.mBanner;
        if (qFSImageBanner8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner8 = null;
        }
        qFSImageBanner8.setOnItemDoubleClickListener(new g());
        QFSImageBanner qFSImageBanner9 = this.mBanner;
        if (qFSImageBanner9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner9 = null;
        }
        qFSImageBanner9.setOnItemClickListener(new C0917h());
        QFSImageBanner qFSImageBanner10 = this.mBanner;
        if (qFSImageBanner10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner10 = null;
        }
        qFSImageBanner10.setOnSwitchListener(new i());
        QFSImageBanner qFSImageBanner11 = this.mBanner;
        if (qFSImageBanner11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner11 = null;
        }
        qFSImageBanner11.setOnItemLongClickListener(new QFSImageBanner.e() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.g
            @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.e
            public final void onItemLongClick(int i3) {
                h.X1(h.this, i3);
            }
        });
        QFSImageBanner qFSImageBanner12 = this.mBanner;
        if (qFSImageBanner12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner12 = null;
        }
        QFSImageBannerReport qFSImageBannerReport = this.mBannerReport;
        if (qFSImageBannerReport == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerReport");
            qFSImageBannerReport = null;
        }
        qFSImageBanner12.setStatusListener(qFSImageBannerReport);
        QFSImageBannerReport qFSImageBannerReport2 = this.mBannerReport;
        if (qFSImageBannerReport2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerReport");
            qFSImageBannerReport2 = null;
        }
        qFSImageBannerReport2.o((FeedCloudMeta$StFeed) this.f85017h);
        this.mCurrentPosition = w20.a.j().f(n0().f398449id.get());
        QLog.d(getTAG(), 1, "curPos: " + this.mCurrentPosition + " needAutoPlay: " + G1());
        QFSImageBanner qFSImageBanner13 = this.mBanner;
        if (qFSImageBanner13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner13 = null;
        }
        qFSImageBanner13.setCurrentItem(this.mCurrentPosition, false);
        if (((FeedCloudMeta$StFeed) this.f85017h).images.get().size() > 1 && G1()) {
            QFSImageBanner qFSImageBanner14 = this.mBanner;
            if (qFSImageBanner14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            } else {
                qFSImageBanner2 = qFSImageBanner14;
            }
            qFSImageBanner2.x0(this.mCurrentPosition);
            return;
        }
        QFSImageBanner qFSImageBanner15 = this.mBanner;
        if (qFSImageBanner15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
        } else {
            qFSImageBanner2 = qFSImageBanner15;
        }
        qFSImageBanner2.w0(this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(h this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P1(i3);
    }

    private final void Z1(boolean isMute) {
        QLog.d(getTAG(), 1, "[updateMuteIcon] isMute = " + isMute);
        ImageView imageView = this.mMuteIcon;
        QFSAudioView qFSAudioView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteIcon");
            imageView = null;
        }
        imageView.setSelected(!isMute);
        if (!isMute) {
            QFSAudioView qFSAudioView2 = this.mAudioView;
            if (qFSAudioView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
            } else {
                qFSAudioView = qFSAudioView2;
            }
            qFSAudioView.setOutPutMute(false);
            QFSAudioFocusManager.f().i(m0());
            return;
        }
        QFSAudioFocusManager.f().h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a2() {
        T mData = this.f85017h;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        FrameLayout frameLayout = null;
        if (!o.c((FeedCloudMeta$StFeed) mData)) {
            QLog.d(getTAG(), 1, "[updateMuteView] musicName text is empty");
            FrameLayout frameLayout2 = this.mMuteContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMuteContainer");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.setVisibility(8);
            return;
        }
        FrameLayout frameLayout3 = this.mMuteContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteContainer");
        } else {
            frameLayout = frameLayout3;
        }
        frameLayout.setVisibility(0);
        A1();
        D1(false, this.mIsAudioMuted);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void c2(int position) {
        this.mCurrentPosition = position;
        TextView textView = this.mTvPosition;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvPosition");
            textView = null;
        }
        textView.setText((this.mCurrentPosition + 1) + "/" + this.mTotalCount);
        SimpleEventBus.getInstance().dispatchEvent(new QFSNewContentDetailPicPositionChangeEvent(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), position));
        e2(position);
    }

    private final void d2() {
        int i3;
        FrameLayout frameLayout = this.mProgressFl;
        QFSGalleryProgressViewNoAnim qFSGalleryProgressViewNoAnim = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressFl");
            frameLayout = null;
        }
        if (M1()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
        QFSGalleryProgressViewNoAnim qFSGalleryProgressViewNoAnim2 = this.mProgressView;
        if (qFSGalleryProgressViewNoAnim2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressView");
        } else {
            qFSGalleryProgressViewNoAnim = qFSGalleryProgressViewNoAnim2;
        }
        qFSGalleryProgressViewNoAnim.setTotalCount(this.mTotalCount);
    }

    private final void e2(int pos) {
        QFSGalleryProgressViewNoAnim qFSGalleryProgressViewNoAnim = this.mProgressView;
        if (qFSGalleryProgressViewNoAnim == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressView");
            qFSGalleryProgressViewNoAnim = null;
        }
        qFSGalleryProgressViewNoAnim.f(pos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(RFWPlayerOptions options) {
        options.setPlayIOC(new b());
        options.getListenerSet().addPrepareListeners(new c());
    }

    private final void x1(RFWPlayerOptions options, FeedCloudMeta$StFeedMusic music, int offset) {
        options.getListenerSet().addErrorStatusListener(new d(music, offset));
    }

    private final void y1() {
        if (bz.k()) {
            z1();
            return;
        }
        DisplayUtil.AdjustViewSizeParams adjustViewSizeParams = new DisplayUtil.AdjustViewSizeParams();
        FrameLayout frameLayout = this.mFlBannerContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlBannerContainer");
            frameLayout = null;
        }
        DisplayUtil.adjustViewSize(adjustViewSizeParams.setView(frameLayout).setDefaultWidth(DisplayUtil.getScreenWidth()).setDefaultHeight(F1(DisplayUtil.getScreenWidth())).setTargetWidth(bz.j()).setMaxCardWidthScale(1.0f));
    }

    private final void z1() {
        FrameLayout frameLayout = this.mFlBannerContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlBannerContainer");
            frameLayout = null;
        }
        int instantScreenWidth = DisplayUtil.getInstantScreenWidth(frameLayout.getContext());
        Size size = new Size(instantScreenWidth, F1(instantScreenWidth));
        FrameLayout frameLayout3 = this.mFlBannerContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlBannerContainer");
        } else {
            frameLayout2 = frameLayout3;
        }
        bz.d(frameLayout2, size);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(@Nullable com.tencent.biz.qqcircle.immersive.feed.event.h event) {
        super.C0(event);
        if (event instanceof com.tencent.biz.qqcircle.immersive.feed.event.k) {
            y1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        View findViewById = rootView.findViewById(R.id.v9n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<QC\u2026ash_show_double_ain_view)");
        this.mPraiseView = (QCircleDoublePraiseView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f44001o0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Fr\u2026s_image_banner_container)");
        this.mFlBannerContainer = (FrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f43991nz);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<QF\u2026?>(R.id.qfs_image_banner)");
        QFSImageBanner qFSImageBanner = (QFSImageBanner) findViewById3;
        this.mBanner = qFSImageBanner;
        FrameLayout frameLayout = null;
        if (qFSImageBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner = null;
        }
        VideoReport.setElementId(qFSImageBanner, QCircleDaTongConstant.ElementId.EM_XSJ_PICTURE_BUTTON);
        QFSImageBanner qFSImageBanner2 = this.mBanner;
        if (qFSImageBanner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner2 = null;
        }
        VideoReport.setElementId(qFSImageBanner2, QCircleDaTongConstant.ElementId.EM_XSJ_PICTURE_BUTTON);
        View findViewById4 = rootView.findViewById(R.id.f40941fq);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById<QF\u2026s_feed_pic_progress_view)");
        this.mProgressView = (QFSGalleryProgressViewNoAnim) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f40921fo);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById<Fr\u2026qfs_feed_pic_progress_fl)");
        this.mProgressFl = (FrameLayout) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f42901l1);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById<Fr\u2026llery_detail_mute_layout)");
        this.mMuteContainer = (FrameLayout) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f56552kx);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById<Te\u2026ew>(R.id.qfs_tv_position)");
        this.mTvPosition = (TextView) findViewById7;
        FrameLayout frameLayout2 = this.mMuteContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteContainer");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.setOnClickListener(this);
        View findViewById8 = rootView.findViewById(R.id.f42881kz);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById<Im\u2026s_gallery_detail_iv_mute)");
        this.mMuteIcon = (ImageView) findViewById8;
        this.mAudioView = new QFSAudioView(m0());
        QFSImageBannerReport p16 = new QFSImageBannerReport(y0()).p(2);
        Intrinsics.checkNotNullExpressionValue(p16, "QFSImageBannerReport(pageId).setDisplayType(2)");
        this.mBannerReport = p16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull FeedCloudMeta$StFeed data, int position) {
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(this.f85017h, data)) {
            QLog.d(getTAG(), 1, "data already bound " + data.images.size() + " " + ((FeedCloudMeta$StFeed) this.f85017h).images.size());
            return;
        }
        super.L0(data, position);
        QCircleDoublePraiseView qCircleDoublePraiseView = this.mPraiseView;
        TextView textView = null;
        if (qCircleDoublePraiseView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPraiseView");
            qCircleDoublePraiseView = null;
        }
        qCircleDoublePraiseView.setFeed(data, position);
        this.mTotalCount = data.images.get().size();
        TextView textView2 = this.mTvPosition;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvPosition");
        } else {
            textView = textView2;
        }
        if (G1()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
        int f16 = w20.a.j().f(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        this.mCurrentPosition = f16;
        c2(f16);
        if (!G1()) {
            this.mIsAudioMuted = true;
        }
        this.mShouldPlayAudio = G1();
        d2();
        a2();
        Z1(this.mIsAudioMuted);
        W1();
        K1();
    }

    public final void a() {
        QLog.d(getTAG(), 1, "[releasePlayer]");
        QFSAudioView qFSAudioView = this.mAudioView;
        if (qFSAudioView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
            qFSAudioView = null;
        }
        qFSAudioView.release();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QCircleKeyVolumeChangeEvent.class, QFSVideoControlEvent.class);
        return arrayListOf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 == null) {
            QLog.e(getTAG(), 1, "[onClick] v == null");
        } else if (v3.getId() == R.id.f42901l1) {
            J1();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        a();
        QFSImageBanner qFSImageBanner = this.mBanner;
        QFSAudioView qFSAudioView = null;
        if (qFSImageBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner = null;
        }
        qFSImageBanner.z0(true);
        if (!G1() && !tb0.a.f435779d.b()) {
            QFSAudioView qFSAudioView2 = this.mAudioView;
            if (qFSAudioView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
            } else {
                qFSAudioView = qFSAudioView2;
            }
            qFSAudioView.setOutPutMute(false);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onPaused(selectInfo);
        QFSImageBanner qFSImageBanner = this.mBanner;
        if (qFSImageBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner = null;
        }
        qFSImageBanner.y0();
        if (QCirclePluginUtil.isGalleryPageOnShow()) {
            QLog.d(getTAG(), 1, "[pausePlayer] isGalleryPageOnShow don't release player");
        } else {
            Q1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleKeyVolumeChangeEvent) {
            I1((QCircleKeyVolumeChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSVideoControlEvent) {
            H1((QFSVideoControlEvent) simpleBaseEvent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        if (!L1()) {
            QLog.d(getTAG(), 1, "[onPartResume] current feed not is pic type.");
            return;
        }
        this.mCurrentPosition = w20.a.j().f(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        QLog.d(getTAG(), 1, "onPartResume " + this.mCurrentPosition);
        QFSImageBanner qFSImageBanner = this.mBanner;
        QFSImageBanner qFSImageBanner2 = null;
        if (qFSImageBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner = null;
        }
        qFSImageBanner.setCurrentItem(this.mCurrentPosition, false);
        if (((FeedCloudMeta$StFeed) this.f85017h).images.get().size() > 1 && G1()) {
            QFSImageBanner qFSImageBanner3 = this.mBanner;
            if (qFSImageBanner3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            } else {
                qFSImageBanner2 = qFSImageBanner3;
            }
            qFSImageBanner2.v0();
        }
        S1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSNewContentDetailBodyPicPresenter";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/h$c", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerPrepareListener;", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "", "onVideoPrepared", "onFirstFrameRendered", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements IRFWPlayerPrepareListener {
        c() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(@Nullable RFWPlayer player) {
            QFSAudioView qFSAudioView = h.this.mAudioView;
            if (qFSAudioView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioView");
                qFSAudioView = null;
            }
            qFSAudioView.setOutPutMute(h.this.mIsAudioMuted);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(@Nullable RFWPlayer player) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/h$i", "Lcom/tencent/biz/qqcircle/immersive/views/banner/QFSImageBanner$h;", "", "targetPos", "", "a", "b", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class i implements QFSImageBanner.h {
        i() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.h
        public void c() {
            QLog.d(h.this.getTAG(), 1, "onUserTouchSwitch");
            QFSImageBanner qFSImageBanner = h.this.mBanner;
            TextView textView = null;
            if (qFSImageBanner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBanner");
                qFSImageBanner = null;
            }
            qFSImageBanner.y0();
            w20.a.j().r(((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) h.this).f85017h).f398449id.get(), false);
            TextView textView2 = h.this.mTvPosition;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvPosition");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.h
        public void a(int targetPos) {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.h
        public void b(int targetPos) {
        }
    }
}
