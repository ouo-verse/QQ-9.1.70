package hu2;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.biz.qqcircle.activity.TVideoFragmentActivity;
import com.tencent.biz.qqcircle.immersive.views.QFSTVKVideoView;
import com.tencent.biz.qqcircle.launcher.QCircleLauncherUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.player.events.RFWTVKPlayerStatusEvent;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.LibraryLoadListener;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.f;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdVideoInfoDefine$StrategyAdParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.authpay.TVideoAuthPayFragment;
import com.tencent.mobileqq.tvideo.event.QFSTVideoMidAdCountDownStartEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoMidAdPlayEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoRewardAdClickEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.playerinterface.QAdUserInfo;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.tvideo.protocol.pb.ADVideoInfo;
import com.tencent.tvideo.protocol.pb.RewardAdSceneType;
import com.tencent.tvideo.protocol.pb.SegmentRewardItem;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kt3.j;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0003()'B)\u0012\u0006\u00101\u001a\u00020-\u0012\u0006\u0010R\u001a\u00020Q\u0012\b\u00106\u001a\u0004\u0018\u000102\u0012\u0006\u0010;\u001a\u000207\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u001a\u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001eH\u0016J\b\u0010(\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016J\u000e\u0010+\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010,\u001a\u00020\u0003H\u0016R\u0017\u00101\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b(\u0010.\u001a\u0004\b/\u00100R\u0019\u00106\u001a\u0004\u0018\u0001028\u0006\u00a2\u0006\f\n\u0004\b)\u00103\u001a\u0004\b4\u00105R\u0017\u0010;\u001a\u0002078\u0006\u00a2\u0006\f\n\u0004\b'\u00108\u001a\u0004\b9\u0010:R\"\u0010>\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010E\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010=\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR\u0018\u0010H\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010GR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010JR\u0016\u0010M\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010LR\u0016\u0010N\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010=R\u0018\u0010P\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010O\u00a8\u0006U"}, d2 = {"Lhu2/b;", "Lnu2/b;", "Lcom/tencent/hippy/qq/api/LibraryLoadListener;", "", "w", "v", "Lhu2/b$b;", "adInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqlive/playerinterface/QAdUserInfo;", tl.h.F, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", ReportConstant.COSTREPORT_PREFIX, "t", "y", "o", "p", "", "progress", "l", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, "j", "Lcom/tencent/mobileqq/tvideo/event/QFSTVideoRewardAdClickEvent;", "rewardClickEvent", "g", "onLoadSuccess", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "errorMsg", "onLoadFail", "", "showPanel", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/MediaAd/data/g;", "rewardItemWrapper", DomainData.DOMAIN_NAME, "unlockTips", "c", "a", "b", "onFailed", "r", "f", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/biz/qqcircle/immersive/views/QFSTVKVideoView;", "Lcom/tencent/biz/qqcircle/immersive/views/QFSTVKVideoView;", "getPlayerView", "()Lcom/tencent/biz/qqcircle/immersive/views/QFSTVKVideoView;", "playerView", "Lhu2/b$c;", "Lhu2/b$c;", "getListener", "()Lhu2/b$c;", "listener", "d", "Z", "isPlayingVideo", "()Z", HippyTKDListViewAdapter.X, "(Z)V", "e", "i", "setPlayingAd", "isPlayingAd", "Lhu2/a;", "Lhu2/a;", "adListener", "Lpu2/a;", "Lpu2/a;", "adManager", "J", "currentPos", "isBlockPlayingAd", "Ljava/lang/String;", "rewardAdRequestId", "Landroid/view/ViewGroup;", "adLayout", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/biz/qqcircle/immersive/views/QFSTVKVideoView;Lhu2/b$c;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b implements nu2.b, LibraryLoadListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QFSTVKVideoView playerView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c listener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isPlayingVideo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isPlayingAd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a adListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final pu2.a adManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long currentPos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isBlockPlayingAd;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String rewardAdRequestId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0012\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0010\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lhu2/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "cid", "b", "f", "vid", "c", "definition", "", "d", "J", "e", "()J", "skipEndMs", "duration", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_FLOW_ID, "g", "I", "getPos", "()I", com.tencent.luggage.wxa.c8.c.G, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hu2.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes19.dex */
    public static final /* data */ class MidAdInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String cid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String vid;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String definition;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long skipEndMs;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final long duration;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String flowId;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pos;

        public MidAdInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, long j3, long j16, @Nullable String str4, int i3) {
            this.cid = str;
            this.vid = str2;
            this.definition = str3;
            this.skipEndMs = j3;
            this.duration = j16;
            this.flowId = str4;
            this.pos = i3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getCid() {
            return this.cid;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getDefinition() {
            return this.definition;
        }

        /* renamed from: c, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getFlowId() {
            return this.flowId;
        }

        /* renamed from: e, reason: from getter */
        public final long getSkipEndMs() {
            return this.skipEndMs;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MidAdInfo)) {
                return false;
            }
            MidAdInfo midAdInfo = (MidAdInfo) other;
            if (Intrinsics.areEqual(this.cid, midAdInfo.cid) && Intrinsics.areEqual(this.vid, midAdInfo.vid) && Intrinsics.areEqual(this.definition, midAdInfo.definition) && this.skipEndMs == midAdInfo.skipEndMs && this.duration == midAdInfo.duration && Intrinsics.areEqual(this.flowId, midAdInfo.flowId) && this.pos == midAdInfo.pos) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getVid() {
            return this.vid;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            String str = this.cid;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.vid;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.definition;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int a16 = (((((i17 + hashCode3) * 31) + androidx.fragment.app.a.a(this.skipEndMs)) * 31) + androidx.fragment.app.a.a(this.duration)) * 31;
            String str4 = this.flowId;
            if (str4 != null) {
                i3 = str4.hashCode();
            }
            return ((a16 + i3) * 31) + this.pos;
        }

        @NotNull
        public String toString() {
            return "MidAdInfo(cid=" + this.cid + ", vid=" + this.vid + ", definition=" + this.definition + ", skipEndMs=" + this.skipEndMs + ", duration=" + this.duration + ", flowId=" + this.flowId + ", pos=" + this.pos + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u000f\u001a\u00020\u0004H&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0004H&\u00a8\u0006\u0014"}, d2 = {"Lhu2/b$c;", "", "", "isPlayingAd", "", "d", "showPanel", "", "countdownTime", "e", "(ZLjava/lang/Long;)V", "", "unlockTips", "c", "a", "onFailed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, "onWarnerTipClick", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface c {
        void a();

        void b();

        void c(@NotNull String unlockTips);

        void d(boolean isPlayingAd);

        void e(boolean showPanel, @Nullable Long countdownTime);

        void onFailed();

        void onWarnerTipClick(int adType);
    }

    public b(@NotNull Context context, @NotNull ViewGroup adLayout, @Nullable QFSTVKVideoView qFSTVKVideoView, @NotNull c listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.playerView = qFSTVKVideoView;
        this.listener = listener;
        this.isPlayingVideo = true;
        this.currentPos = -1L;
        this.adManager = new pu2.a(context, adLayout);
    }

    private final void v() {
        QFSTVideoMidAdPlayEvent qFSTVideoMidAdPlayEvent = new QFSTVideoMidAdPlayEvent();
        qFSTVideoMidAdPlayEvent.setComplete(true);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoMidAdPlayEvent);
    }

    private final void w() {
        QFSTVideoMidAdPlayEvent qFSTVideoMidAdPlayEvent = new QFSTVideoMidAdPlayEvent();
        qFSTVideoMidAdPlayEvent.setStart(true);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoMidAdPlayEvent);
    }

    @Override // nu2.b
    public void a() {
        nu2.a.b(this);
        n.e("MidAdController", "onMultiAdUnlockFail");
        this.listener.a();
    }

    @Override // nu2.b
    public void b() {
        n.e("MidAdController", "onRewardDialogClose");
        this.listener.b();
    }

    @Override // nu2.b
    public void c(@NotNull String unlockTips) {
        Intrinsics.checkNotNullParameter(unlockTips, "unlockTips");
        nu2.a.c(this, unlockTips);
        n.e("MidAdController", "onMultiAdUnlockSuccess");
        this.listener.c(unlockTips);
    }

    @Override // nu2.b
    public /* synthetic */ void d() {
        nu2.a.f(this);
    }

    @Override // nu2.b
    public /* synthetic */ void e() {
        nu2.a.e(this);
    }

    @Override // nu2.b
    public void f() {
        n.a("MidAdController", "onEnterVipClick top activity = " + Foreground.getTopActivity());
        if (Foreground.getTopActivity() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(Foreground.getTopActivity(), TVideoFragmentActivity.class);
        intent.putExtra("public_fragment_class", TVideoAuthPayFragment.class.getName());
        QCircleLauncherUtil.q(Foreground.getTopActivity(), intent, false);
    }

    public final void g(@NotNull QFSTVideoRewardAdClickEvent rewardClickEvent) {
        Intrinsics.checkNotNullParameter(rewardClickEvent, "rewardClickEvent");
        n.e("AdManagerListener", "onRewardAdPanelShow requestId = " + this.rewardAdRequestId);
        ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).loadLibraryIfNeed(this);
        ADVideoInfo.a g16 = new ADVideoInfo.a().b(rewardClickEvent.getCid()).g(rewardClickEvent.getVid());
        String flowId = rewardClickEvent.getFlowId();
        if (flowId == null) {
            flowId = "";
        }
        this.adManager.v(new f.a().d(this.rewardAdRequestId).a(ev2.a.a()).e(RewardAdSceneType.REWARD_AD_SCENE_TYPE_QQ_VIDEO).f(g16.c(flowId).build()).c(QAdVrReport.d(this.playerView)).b(), this);
        SimpleEventBus.getInstance().dispatchEvent(new RFWTVKPlayerStatusEvent(11));
    }

    @NotNull
    public final QAdUserInfo h() {
        QAdUserInfo qAdUserInfo = new QAdUserInfo();
        qAdUserInfo.l(RFWApplication.getAccountId());
        bu2.a i3 = zt2.e.f453199a.i();
        if (i3 != null) {
            qAdUserInfo.k(i3.getOpenId());
            qAdUserInfo.i(i3.getCom.huawei.hms.support.feature.result.CommonConstant.KEY_ACCESS_TOKEN java.lang.String());
            qAdUserInfo.j(i3.getOpenId());
        }
        return qAdUserInfo;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsPlayingAd() {
        return this.isPlayingAd;
    }

    public final void j(int adType) {
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoMidAdCountDownStartEvent(adType));
    }

    public final void k() {
        QLog.i("MidAdController", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        if (this.isPlayingAd) {
            this.adManager.G();
        } else {
            this.adManager.E(2, 0, 0, null, null);
        }
    }

    public final void l(long progress) {
        QLog.d("MidAdController", 1, "onProgressChanged:" + progress);
        if (this.currentPos == progress) {
            return;
        }
        this.currentPos = progress;
        this.adManager.E(12, 0, 0, null, Long.valueOf(progress));
    }

    public final void m() {
        QLog.i("MidAdController", 1, "onResume");
        if (this.isBlockPlayingAd) {
            t();
        } else if (this.isPlayingAd) {
            this.adManager.N();
        } else {
            this.adManager.E(3, 0, 0, null, null);
        }
    }

    public final void n(boolean showPanel, @Nullable com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.g rewardItemWrapper) {
        String str;
        String str2;
        SegmentRewardItem segmentRewardItem;
        Long l3 = null;
        if (rewardItemWrapper != null) {
            str = rewardItemWrapper.f303620a;
        } else {
            str = null;
        }
        n.e("MidAdController", "onRewardAdPanelShow, showPanel = " + showPanel + " ; requestId = " + str);
        if (rewardItemWrapper != null) {
            str2 = rewardItemWrapper.f303620a;
        } else {
            str2 = null;
        }
        this.rewardAdRequestId = str2;
        c cVar = this.listener;
        if (rewardItemWrapper != null && (segmentRewardItem = rewardItemWrapper.f303621b) != null) {
            l3 = Long.valueOf(segmentRewardItem.countdown_time);
        }
        cVar.e(showPanel, l3);
    }

    public final void o() {
        this.adManager.E(2, 0, 0, null, null);
    }

    @Override // nu2.b
    public void onFailed() {
        nu2.a.a(this);
        this.listener.onFailed();
    }

    @Override // nu2.b
    public /* synthetic */ void onSuccess() {
        nu2.a.d(this);
    }

    public final void p() {
        this.adManager.E(3, 0, 0, null, null);
    }

    public final void q(@NotNull MidAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        QLog.i("MidAdController", 1, "onVideoStartPlay:cid=" + adInfo.getCid() + " vid=" + adInfo.getVid() + " definition= " + adInfo.getDefinition() + ", skip=" + adInfo.getSkipEndMs() + ", duration=" + adInfo.getDuration());
        a aVar = new a(this);
        this.adListener = aVar;
        this.adManager.M(aVar);
        this.adManager.R(h());
        this.adManager.P(adInfo.getDefinition());
        j jVar = new j();
        jVar.m(adInfo.getCid());
        jVar.q(adInfo.getVid());
        jVar.o(2);
        jVar.p(adInfo.getSkipEndMs());
        jVar.r(adInfo.getDuration());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(QAdVideoInfoDefine$StrategyAdParams.IS_SCROLL_ENABLE, Boolean.TRUE);
        jVar.l(linkedHashMap);
        jVar.n(adInfo.getFlowId());
        this.adManager.S(jVar);
        this.adManager.E(1, 0, 0, null, null);
        this.adManager.O();
    }

    public final void r(int adType) {
        this.listener.onWarnerTipClick(adType);
    }

    public final void s() {
        QLog.i("MidAdController", 1, "playAd");
        QFSTVKVideoView qFSTVKVideoView = this.playerView;
        if (qFSTVKVideoView != null) {
            qFSTVKVideoView.pause();
        }
        if (com.tencent.mobileqq.tvideo.floatingwindow.h.l().r()) {
            this.isBlockPlayingAd = true;
        } else {
            t();
        }
    }

    public final void t() {
        QLog.i("MidAdController", 1, "playAd");
        this.adManager.N();
        this.isPlayingAd = true;
        this.adManager.E(2, 0, 0, null, null);
        this.listener.d(true);
        w();
        this.isBlockPlayingAd = false;
        SimpleEventBus.getInstance().dispatchEvent(new RFWTVKPlayerStatusEvent(11));
    }

    public final void u() {
        QLog.i("MidAdController", 1, "release");
        this.adManager.s(0);
        this.adManager.I();
        this.isPlayingAd = false;
        this.isBlockPlayingAd = false;
    }

    public final void x(boolean z16) {
        this.isPlayingVideo = z16;
    }

    public final void y() {
        QFSTVKVideoView qFSTVKVideoView;
        QLog.i("MidAdController", 1, "stopAd");
        this.adManager.s(0);
        if (this.isPlayingVideo && (qFSTVKVideoView = this.playerView) != null) {
            qFSTVKVideoView.start();
        }
        this.isPlayingAd = false;
        this.adManager.E(3, 0, 0, null, null);
        this.listener.d(false);
        v();
    }

    @Override // com.tencent.hippy.qq.api.LibraryLoadListener
    public void onLoadSuccess() {
    }

    @Override // com.tencent.hippy.qq.api.LibraryLoadListener
    public void onLoadFail(int statusCode, @Nullable String errorMsg) {
    }
}
