package m40;

import android.os.Handler;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.utils.ac;
import com.tencent.biz.qqcircle.immersive.utils.bk;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import m40.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import tianshu.QQCircleTianShu$AdItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001gB\u0007\u00a2\u0006\u0004\bd\u0010eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J(\u0010\u0010\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\fj\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r`\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0012\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\b\u0010(\u001a\u00020\u0006H\u0002J\b\u0010)\u001a\u00020\u0006H\u0002J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0002J\u0012\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010-H\u0002J\u0018\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u00101\u001a\u00020\tH\u0002J\b\u00104\u001a\u00020\u0013H\u0002J\b\u00105\u001a\u00020\u0006H\u0002J\b\u00106\u001a\u00020\u0006H\u0002J\b\u00107\u001a\u00020\u0013H\u0002J\b\u00108\u001a\u00020\u0006H\u0002J\b\u00109\u001a\u00020\u0006H\u0002J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\tH\u0002J\b\u0010<\u001a\u00020\u0006H\u0002J\b\u0010>\u001a\u00020=H\u0002J\b\u0010?\u001a\u00020\u0006H\u0002R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010FR\u0016\u0010T\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR2\u0010^\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020Z0Yj\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020Z`[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010AR\u0016\u0010c\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010b\u00a8\u0006h"}, d2 = {"Lm40/n;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "N0", "data", "", "position", "E1", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", "getEventClass", "simpleBaseEvent", "onReceiveEvent", "", "B1", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "onResumed", "E0", DKHippyEvent.EVENT_STOP, "onFeedUnSelected", "onPaused", "", "w0", "v", NodeProps.ON_CLICK, "Q0", "I1", "event", "A1", "Lcom/tencent/biz/qqcircle/events/QCirclePanelStateEvent;", "z1", "r1", ICustomDataEditor.STRING_PARAM_1, "w1", "Le30/b;", "feedBlockData", "H1", "Lcom/tencent/biz/richframework/video/rfw/player/RFWPlayerOptions;", "options", "p1", "videoDuration", "currentDuration", "K1", Constants.APK_CERTIFICATE, "C1", "x1", DomainData.DOMAIN_NAME, "t1", "F1", "u1", "status", "J1", Constants.BASE_IN_PLUGIN_ID, "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "y1", "v1", "Lcom/tencent/biz/qqcircle/widgets/QFSExpandableAsyncTextView;", "I", "Lcom/tencent/biz/qqcircle/widgets/QFSExpandableAsyncTextView;", "descTv", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "mCoverImg", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "K", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "mPlayView", "Landroid/widget/TextView;", "L", "Landroid/widget/TextView;", "remainTimeTextView", "M", "controlPlayIcon", "N", "Landroid/view/View;", "backgroundView", "Lcom/tencent/libra/request/Option;", "P", "Lcom/tencent/libra/request/Option;", "mCoverOption", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/HashMap;", "mPosMap", BdhLogUtil.LogTag.Tag_Req, "playStatus", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "contentType", "<init>", "()V", "T", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class n extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: I, reason: from kotlin metadata */
    private QFSExpandableAsyncTextView descTv;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView mCoverImg;

    /* renamed from: K, reason: from kotlin metadata */
    private QFSVideoView mPlayView;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView remainTimeTextView;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView controlPlayIcon;

    /* renamed from: N, reason: from kotlin metadata */
    private View backgroundView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Option mCoverOption;

    /* renamed from: R, reason: from kotlin metadata */
    private int playStatus;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, Long> mPosMap = new HashMap<>();

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private String contentType = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"m40/n$b", "Lcom/tencent/biz/richframework/video/rfw/player/ioc/RFWPlayerIOC;", "", AppConstants.Key.COLUMN_IS_VALID, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RFWPlayerIOC {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return n.this.E0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"m40/n$c", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerPrepareListener;", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "", "onVideoPrepared", "onFirstFrameRendered", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements IRFWPlayerPrepareListener {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(n this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ImageView imageView = this$0.mCoverImg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverImg");
                imageView = null;
            }
            imageView.setVisibility(8);
            this$0.J1(2);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final n nVar = n.this;
            uIHandler.post(new Runnable() { // from class: m40.o
                @Override // java.lang.Runnable
                public final void run() {
                    n.c.b(n.this);
                }
            });
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            player.getRealPlayer().setXYaxis(2);
            n.this.v1();
            QFSVideoView qFSVideoView = n.this.mPlayView;
            if (qFSVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                qFSVideoView = null;
            }
            qFSVideoView.start();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"m40/n$d", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerSeekListener;", "", "timeString", "", "videoDuration", "currentDuration", "", "onProgress", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d implements IRFWPlayerSeekListener {
        d() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(@Nullable String timeString, int videoDuration, int currentDuration) {
            n.this.G1(currentDuration);
            n.this.K1(videoDuration, currentDuration);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public /* synthetic */ void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            re0.b.b(this, seekBar, i3, z16);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public /* synthetic */ void onStartTrackingTouch(SeekBar seekBar) {
            re0.b.c(this, seekBar);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public /* synthetic */ void onStopTrackingTouch(SeekBar seekBar) {
            re0.b.d(this, seekBar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"m40/n$e", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerLifeCycle;", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "", "onRelease", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements IRFWPlayerLifeCycle {
        e() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onDeInit(RFWPlayer rFWPlayer) {
            re0.a.a(this, rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onPause(RFWPlayer rFWPlayer) {
            re0.a.b(this, rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public void onRelease(@Nullable RFWPlayer player) {
            re0.a.c(this, player);
            n.this.s1();
            n.this.J1(0);
            QFSVideoView qFSVideoView = n.this.mPlayView;
            if (qFSVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                qFSVideoView = null;
            }
            qFSVideoView.setData(null, ((QFSBaseFeedChildPresenter) n.this).f85018i);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onStart(RFWPlayer rFWPlayer) {
            re0.a.d(this, rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onStop(RFWPlayer rFWPlayer) {
            re0.a.e(this, rFWPlayer);
        }
    }

    private final void A1(SimpleBaseEvent event) {
        if (event instanceof QCirclePanelStateEvent) {
            QCirclePanelStateEvent qCirclePanelStateEvent = (QCirclePanelStateEvent) event;
            if (qCirclePanelStateEvent.getPanelType() == 25) {
                z1(qCirclePanelStateEvent);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean C1() {
        String str;
        boolean equals$default;
        PBStringField pBStringField;
        if (this.f85017h == 0) {
            return false;
        }
        QFSVideoView qFSVideoView = this.mPlayView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        FeedCloudMeta$StFeed data = qFSVideoView.getData();
        if (data != null && (pBStringField = data.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        equals$default = StringsKt__StringsJVMKt.equals$default(str, ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), false, 2, null);
        if (!equals$default) {
            return false;
        }
        return true;
    }

    private final void D1() {
        com.tencent.biz.qqcircle.launcher.c.u(m0(), y1());
    }

    private final void F1() {
        QFSVideoView qFSVideoView = this.mPlayView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        if (qFSVideoView.getSuperPlayer() == null) {
            return;
        }
        QFSVideoView qFSVideoView3 = this.mPlayView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView3 = null;
        }
        VideoReport.unbindVideoPlayerInfo(qFSVideoView3);
        QFSVideoView qFSVideoView4 = this.mPlayView;
        if (qFSVideoView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
        } else {
            qFSVideoView2 = qFSVideoView4;
        }
        qFSVideoView2.pause();
        J1(0);
        RFWLog.d(getTAG(), RFWLog.USR, "pause success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void G1(int currentDuration) {
        PBStringField pBStringField;
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null && (str = pBStringField.get()) != null) {
            this.mPosMap.put(str, Long.valueOf(currentDuration));
        }
    }

    private final void H1(e30.b feedBlockData) {
        QFSVideoView qFSVideoView = this.mPlayView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        qFSVideoView.setData(n0(), this.f85018i);
        FeedCloudMeta$StFeed g16 = feedBlockData.g();
        RFWPlayerOptions fromType = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setPlayUrl(g16.video.playUrl.get()).setFileId(g16.video.fileId.get()).setStVideo(gb0.b.k(g16.video)).setIsMutualExclusion(true).setFromType(15);
        RFWLog.d("QFSLinearFeedVideoPresenter_" + fromType.tag(), RFWLog.USR, "fs_lifecycle  startANewPlayer:" + ac.f90062a.a(g16.content.get()));
        p1(fromType);
        QFSVideoView qFSVideoView3 = this.mPlayView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
        } else {
            qFSVideoView2 = qFSVideoView3;
        }
        qFSVideoView2.loadPlayOptions(fromType);
        J1(1);
    }

    private final void I1() {
        String str;
        Object b16 = this.E.b("KEY_LINEAR_FEED_CONTENT_TYPE");
        if (b16 instanceof String) {
            str = (String) b16;
        } else {
            str = null;
        }
        if (str != null) {
            this.contentType = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(int status) {
        this.playStatus = status;
        ImageView imageView = null;
        if (status != 0) {
            if (status != 1) {
                if (status == 2) {
                    ImageView imageView2 = this.controlPlayIcon;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("controlPlayIcon");
                        imageView2 = null;
                    }
                    imageView2.setImageResource(R.drawable.ntn);
                    ImageView imageView3 = this.controlPlayIcon;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("controlPlayIcon");
                    } else {
                        imageView = imageView3;
                    }
                    imageView.setClickable(true);
                    return;
                }
                return;
            }
            ImageView imageView4 = this.controlPlayIcon;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("controlPlayIcon");
                imageView4 = null;
            }
            imageView4.setImageResource(R.drawable.common_loading2);
            ImageView imageView5 = this.controlPlayIcon;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("controlPlayIcon");
            } else {
                imageView = imageView5;
            }
            imageView.setClickable(false);
            return;
        }
        ImageView imageView6 = this.controlPlayIcon;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlPlayIcon");
            imageView6 = null;
        }
        imageView6.setImageResource(R.drawable.nto);
        ImageView imageView7 = this.controlPlayIcon;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlPlayIcon");
        } else {
            imageView = imageView7;
        }
        imageView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1(int videoDuration, int currentDuration) {
        TextView textView = null;
        if ((videoDuration / 1000) / 60 < 1) {
            TextView textView2 = this.remainTimeTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remainTimeTextView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        int i3 = (videoDuration - currentDuration) / 1000;
        int i16 = i3 / 60;
        int i17 = i3 % 60;
        TextView textView3 = this.remainTimeTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remainTimeTextView");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.remainTimeTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remainTimeTextView");
        } else {
            textView = textView4;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.CHINA, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i16), Integer.valueOf(i17)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        textView.setText(format);
    }

    private final void n() {
        QFSVideoView qFSVideoView = this.mPlayView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        if (qFSVideoView.getSuperPlayer() == null) {
            RFWLog.d("QFSLinearFeedVideoPresenter", 1, "[startFromPause] current play view or player is null, end flow.");
            return;
        }
        QFSVideoView qFSVideoView3 = this.mPlayView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView3 = null;
        }
        if (qFSVideoView3.getSuperPlayer().isPausing()) {
            RFWLog.d("QFSLinearFeedVideoPresenter", 1, "[startFromPause] current player is pause, try start play.");
            v1();
            QFSVideoView qFSVideoView4 = this.mPlayView;
            if (qFSVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            } else {
                qFSVideoView2 = qFSVideoView4;
            }
            qFSVideoView2.start();
            J1(2);
        }
    }

    private final void p1(RFWPlayerOptions options) {
        if (options == null) {
            return;
        }
        options.setPlayIOC(new b());
        options.getListenerSet().addSDKInitListeners(new IRFWPlayerSdkInitListener() { // from class: m40.m
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
            public final void onInitSuccess(RFWPlayer rFWPlayer) {
                n.q1(n.this, rFWPlayer);
            }
        });
        options.getListenerSet().addPrepareListeners(new c());
        options.getListenerSet().addSeekListeners(new d());
        options.getListenerSet().addLifeCycleListeners(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(n this$0, RFWPlayer rFWPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSVideoView qFSVideoView = this$0.mPlayView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        qFSVideoView.setLoopBack(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r1() {
        Size r16 = ad.r((FeedCloudMeta$StFeed) this.f85017h, this.C, true);
        int width = r16.getWidth();
        int height = r16.getHeight();
        QFSVideoView qFSVideoView = this.mPlayView;
        ImageView imageView = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        qFSVideoView.getLayoutParams().width = width;
        QFSVideoView qFSVideoView2 = this.mPlayView;
        if (qFSVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView2 = null;
        }
        qFSVideoView2.getLayoutParams().height = height;
        ImageView imageView2 = this.mCoverImg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImg");
            imageView2 = null;
        }
        imageView2.getLayoutParams().width = width;
        ImageView imageView3 = this.mCoverImg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImg");
        } else {
            imageView = imageView3;
        }
        imageView.getLayoutParams().height = height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void s1() {
        q50.b.e().b(this.mCoverOption);
        Option url = Option.obtain().setUrl(((FeedCloudMeta$StFeed) this.f85017h).cover.picUrl.get());
        ImageView imageView = this.mCoverImg;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImg");
            imageView = null;
        }
        Option targetView = url.setTargetView(imageView);
        targetView.setSupportRecycler(true);
        targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        targetView.setLoadingDrawableColor(m0().getResources().getColor(R.color.cka, null));
        QCircleFeedPicLoader.g().loadImage(targetView);
        this.mCoverOption = targetView;
        ImageView imageView3 = this.mCoverImg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImg");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(0);
    }

    private final boolean t1() {
        if (E0()) {
            return false;
        }
        RFWLog.d("QFSLinearFeedVideoPresenter", RFWLog.USR, "canNotPlay");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void u1() {
        t40.a s06;
        int i3 = this.playStatus;
        if (i3 != 0) {
            if (i3 == 2) {
                F1();
                return;
            }
            return;
        }
        QFSVideoView qFSVideoView = this.mPlayView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        if (qFSVideoView.getQCirclePlayer() != null) {
            QFSVideoView qFSVideoView2 = this.mPlayView;
            if (qFSVideoView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                qFSVideoView2 = null;
            }
            if (!qFSVideoView2.isRelease()) {
                n();
                s06 = s0();
                if (s06 == null) {
                    s06.onHandlerMessage("event_open_full_screen_similar_panel", null);
                    return;
                }
                return;
            }
        }
        x1();
        s06 = s0();
        if (s06 == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void v1() {
        if (this.f85017h == 0) {
            return;
        }
        Map<String, ?> params = new QCircleDTParamBuilder().buildElementParams();
        Map<String, Object> d16 = ua0.c.d(this.E);
        Intrinsics.checkNotNullExpressionValue(d16, "convertDataToDTParamsMap(mFeedBlockData)");
        params.putAll(d16);
        Map<String, Object> e16 = ua0.c.e((FeedCloudMeta$StFeed) this.f85017h);
        Intrinsics.checkNotNullExpressionValue(e16, "convertDataToDTParamsMap(mData)");
        params.putAll(e16);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
        params.put("xsj_custom_pgid", r0());
        params.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_EXP_FEED_LIST, com.tencent.biz.qqcircle.immersive.utils.r.v(this.E));
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_REC_SLOT_VIDEO, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.r.A0(this.E) ? 1 : 0));
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_ORIGINAL_FEED_ID, this.E.e().f398449id.get());
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_TYPE, com.tencent.biz.qqcircle.immersive.utils.r.I(this.E));
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_SHOW_STYLE, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.r.E(this.E)));
        QQCircleTianShu$AdItem L = com.tencent.biz.qqcircle.immersive.utils.r.L((FeedCloudMeta$StFeed) this.f85017h, 1050);
        if (L != null) {
            params.put(QCircleDaTongConstant.ElementParamKey.XSJ_MULTIMEDIA_LIKE_TIANSHU_ID, Integer.valueOf(L.iAdId.get()));
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_EXP_STATUS, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.r.C(this.E)));
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_SHOW_AD, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.ad.a.h((ViewGroup) this.C.findViewById(R.id.f40181do))));
        VideoEntity.Builder videoDuration = new VideoEntity.Builder().setContentId(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()).setPage((Object) r0()).setContentType(2).setVideoDuration(((FeedCloudMeta$StFeed) this.f85017h).video.duration.get());
        QFSVideoView qFSVideoView = this.mPlayView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        VideoEntity build = videoDuration.setVideoView((View) qFSVideoView).addCustomParams(params).ignoreReport(false).bizReady(true).build();
        QFSVideoView qFSVideoView3 = this.mPlayView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView3 = null;
        }
        if (qFSVideoView3.getSuperPlayer() != null) {
            QFSVideoView qFSVideoView4 = this.mPlayView;
            if (qFSVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            } else {
                qFSVideoView2 = qFSVideoView4;
            }
            VideoReport.bindVideoPlayerInfo(qFSVideoView2.getSuperPlayer(), build);
            RFWLog.i("QFSLinearFeedVideoPresenter", RFWLog.USR, "dtReportBindVideoData  pos = " + this.f85018i);
        }
    }

    private final void w1() {
        boolean z16;
        QFSVideoView qFSVideoView = null;
        if (C1()) {
            QFSVideoView qFSVideoView2 = this.mPlayView;
            if (qFSVideoView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                qFSVideoView2 = null;
            }
            if (!e1(qFSVideoView2)) {
                RFWLog.d("QFSLinearFeedVideoPresenter", RFWLog.USR, "executeFromSelected return");
                return;
            }
        }
        if (!QCirclePanelStateEvent.isSpecifiedPanelShowing(25)) {
            RFWLog.d("QFSLinearFeedVideoPresenter", RFWLog.USR, "executeFromSelected hasShowMaxHeight = false");
            return;
        }
        QFSVideoView qFSVideoView3 = this.mPlayView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
        } else {
            qFSVideoView = qFSVideoView3;
        }
        RFWPlayer qCirclePlayer = qFSVideoView.getQCirclePlayer();
        if (qCirclePlayer != null && qCirclePlayer.isPlaying()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            RFWLog.d("QFSLinearFeedVideoPresenter", RFWLog.USR, "executeFromSelected return is playing");
            return;
        }
        RFWLog.d("QFSLinearFeedVideoPresenter", RFWLog.USR, "executeFromSelected");
        e30.b mFeedBlockData = this.E;
        Intrinsics.checkNotNullExpressionValue(mFeedBlockData, "mFeedBlockData");
        H1(mFeedBlockData);
    }

    private final void x1() {
        if (t1()) {
            return;
        }
        QFSVideoView qFSVideoView = this.mPlayView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        if (qFSVideoView.getSuperPlayer() == null) {
            RFWLog.d("QFSLinearFeedVideoPresenter", RFWLog.USR, "execute a new player" + hashCode());
            e30.b mFeedBlockData = this.E;
            Intrinsics.checkNotNullExpressionValue(mFeedBlockData, "mFeedBlockData");
            H1(mFeedBlockData);
            return;
        }
        QFSVideoView qFSVideoView3 = this.mPlayView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView3 = null;
        }
        if (!qFSVideoView3.isRelease()) {
            QFSVideoView qFSVideoView4 = this.mPlayView;
            if (qFSVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                qFSVideoView4 = null;
            }
            if (!qFSVideoView4.getQCirclePlayer().isDeInit()) {
                QFSVideoView qFSVideoView5 = this.mPlayView;
                if (qFSVideoView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                    qFSVideoView5 = null;
                }
                if (qFSVideoView5.getSuperPlayer().isPlaying()) {
                    RFWLog.d("QFSLinearFeedVideoPresenter", RFWLog.USR, "isPlaying when resume:" + hashCode());
                    return;
                }
                QFSVideoView qFSVideoView6 = this.mPlayView;
                if (qFSVideoView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                } else {
                    qFSVideoView2 = qFSVideoView6;
                }
                if (qFSVideoView2.getSuperPlayer().isPausing()) {
                    n();
                    RFWLog.d("QFSLinearFeedVideoPresenter", RFWLog.USR, "startFromPause hashCode:" + hashCode());
                    return;
                }
                e30.b mFeedBlockData2 = this.E;
                Intrinsics.checkNotNullExpressionValue(mFeedBlockData2, "mFeedBlockData");
                H1(mFeedBlockData2);
                return;
            }
        }
        RFWLog.d("QFSLinearFeedVideoPresenter", RFWLog.USR, "execute a new player released" + hashCode());
        e30.b mFeedBlockData3 = this.E;
        Intrinsics.checkNotNullExpressionValue(mFeedBlockData3, "mFeedBlockData");
        H1(mFeedBlockData3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final QCircleLayerBean y1() {
        QCircleInitBean qCircleInitBean;
        int i3;
        String str;
        Fragment hostFragment;
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setFeed((FeedCloudMeta$StFeed) this.f85017h);
        qCircleLayerBean.setUseLoadingPic(true);
        qCircleLayerBean.setSourceType(92);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        qCircleLayerBean.setFeedListBusiReqData(new QQCircleFeedBase$StFeedListBusiReqData());
        qCircleLayerBean.setFromReportBean(getReportBean().m466clone());
        t40.a s06 = s0();
        ImageView imageView = null;
        if (s06 != null) {
            qCircleInitBean = s06.getInitBean();
        } else {
            qCircleInitBean = null;
        }
        qCircleLayerBean.setTransInitBean(qCircleInitBean);
        t40.a s07 = s0();
        if (s07 != null && (hostFragment = s07.getHostFragment()) != null) {
            i3 = hostFragment.hashCode();
        } else {
            i3 = 0;
        }
        qCircleLayerBean.setPageCode(i3);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        t40.a s08 = s0();
        if (s08 != null) {
            str = s08.getViewModelKey();
        } else {
            str = null;
        }
        qCircleLayerBean.setGlobalViewModelKey(str);
        int[] iArr = new int[2];
        ImageView imageView2 = this.mCoverImg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImg");
            imageView2 = null;
        }
        imageView2.getLocationInWindow(iArr);
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        int i16 = iArr[0];
        int i17 = iArr[1];
        ImageView imageView3 = this.mCoverImg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImg");
            imageView3 = null;
        }
        int width = imageView3.getWidth() + i16;
        int i18 = iArr[1];
        ImageView imageView4 = this.mCoverImg;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImg");
            imageView4 = null;
        }
        qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, i17, width, i18 + imageView4.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(((FeedCloudMeta$StFeed) this.f85017h).cover.picUrl.get()));
        QFSTransitionAnimBean transitionAnimBean = qCircleLayerBean.getTransitionAnimBean();
        ImageView imageView5 = this.mCoverImg;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImg");
        } else {
            imageView = imageView5;
        }
        transitionAnimBean.setCoverDrawable(imageView.getDrawable());
        return qCircleLayerBean;
    }

    private final void z1(QCirclePanelStateEvent event) {
        if (this.E != null && this.f85018i == 1 && event.isShowing()) {
            e30.b mFeedBlockData = this.E;
            Intrinsics.checkNotNullExpressionValue(mFeedBlockData, "mFeedBlockData");
            H1(mFeedBlockData);
        }
        if (this.E != null && !event.isShowing()) {
            F1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean B1(@Nullable FeedCloudMeta$StFeed data) {
        String str;
        String str2;
        boolean equals$default;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        if (data != null && (pBStringField2 = data.f398449id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str2 = pBStringField.get();
        } else {
            str2 = null;
        }
        equals$default = StringsKt__StringsJVMKt.equals$default(str, str2, false, 2, null);
        return equals$default;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean E0() {
        if (s0() != null) {
            return s0().isContainerOnScreen();
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        if (B1(data)) {
            return;
        }
        super.L0(data, position);
        r1();
        s1();
        QFSVideoView qFSVideoView = this.mPlayView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        qFSVideoView.setReportBean(getReportBean());
        I1();
        QFSVideoView qFSVideoView3 = this.mPlayView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
        } else {
            qFSVideoView2 = qFSVideoView3;
        }
        f0(qFSVideoView2, QCircleDaTongConstant.ElementId.EM_XSJ_CONTENT_CARD);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        View findViewById = rootView.findViewById(R.id.f365814y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qfs_desc_text)");
        this.descTv = (QFSExpandableAsyncTextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f363914f);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qfs_cover_view)");
        this.mCoverImg = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f74163vi);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.rfw_video_view_id)");
        this.mPlayView = (QFSVideoView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f519529h);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.qfs_remain_time)");
        this.remainTimeTextView = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f363514b);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.qfs_control_icon)");
        this.controlPlayIcon = (ImageView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f45821sx);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026ar_feed_media_background)");
        this.backgroundView = findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f45831sy);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026ear_feed_media_container)");
        bk.d((RelativeLayout) findViewById7, 10);
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView = this.descTv;
        View view = null;
        if (qFSExpandableAsyncTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            qFSExpandableAsyncTextView = null;
        }
        qFSExpandableAsyncTextView.setOnClickListener(this);
        QFSVideoView qFSVideoView = this.mPlayView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        qFSVideoView.setOnClickListener(this);
        ImageView imageView = this.controlPlayIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlPlayIcon");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        View view2 = this.backgroundView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundView");
        } else {
            view = view2;
        }
        view.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void Q0() {
        R0(1, 1, r(), "");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCirclePanelStateEvent.class);
        Intrinsics.checkNotNullExpressionValue(eventClass, "eventClass");
        return eventClass;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.f363514b) {
            u1();
        } else {
            boolean z17 = false;
            if (id5 == R.id.f365814y || id5 == R.id.f74163vi) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 || id5 == R.id.f45821sx) {
                z17 = true;
            }
            if (z17) {
                D1();
                HashMap hashMap = new HashMap();
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CONTENT_TYPE, this.contentType);
                i0(this.C, "dt_clck", hashMap);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        if (selectInfo == null) {
            return;
        }
        RFWLog.d("QFSLinearFeedVideoPresenter", RFWLog.USR, "fs_lifecycle onSelected:" + selectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        if (selectInfo.getPosition() != this.f85018i) {
            return;
        }
        w1();
        com.tencent.biz.qqcircle.immersive.manager.f.f().i();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedUnSelected(selectInfo);
        QFSVideoView qFSVideoView = this.mPlayView;
        ImageView imageView = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        VideoReport.unbindVideoPlayerInfo(qFSVideoView);
        QFSVideoView qFSVideoView2 = this.mPlayView;
        if (qFSVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView2 = null;
        }
        qFSVideoView2.release();
        ImageView imageView2 = this.mCoverImg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImg");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(0);
        J1(0);
        R0(1, 8, r(), "");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onPaused(selectInfo);
        QLog.d(getTAG(), RFWLog.USR, "onPaused");
        F1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        A1(simpleBaseEvent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        if (selectInfo == null) {
            return;
        }
        if (!QCirclePanelStateEvent.isSpecifiedPanelShowing(25)) {
            RFWLog.d("QFSLinearFeedVideoPresenter", RFWLog.USR, "executeFromSelected hasShowMaxHeight = false");
            return;
        }
        if (this.f85018i == selectInfo.getPosition()) {
            x1();
        }
        RFWLog.d("QFSLinearFeedVideoPresenter", RFWLog.USR, "fs_lifecycle onResumed:" + selectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onStop(selectInfo);
        F1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSLinearFeedVideoPresenter";
    }
}
