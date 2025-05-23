package com.tencent.mobileqq.qqnt.videoplay.api.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqnt.videoplay.api.component.TimeAndMutePanel;
import com.tencent.mobileqq.qqnt.videoplay.api.param.e;
import com.tencent.mobileqq.qqnt.videoplay.api.param.g;
import com.tencent.mobileqq.qqnt.videoplay.player.PlayState;
import com.tencent.mobileqq.qqnt.videoplay.player.impl.PlayCoreProxy;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u0002:\u00016BI\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010S\u001a\u00020G\u0012\u0006\u0010W\u001a\u00020T\u0012\u0007\u0010\u0080\u0001\u001a\u00020\r\u0012\t\b\u0002\u0010\u0081\u0001\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010S\u001a\u00020G\u0012\u0006\u0010W\u001a\u00020T\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0084\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\rJ\u0006\u0010$\u001a\u00020#J\u000e\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%J\u0016\u0010+\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\r2\u0006\u0010*\u001a\u00020)J\u000e\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\rJ\u000e\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\rJ\u000f\u00101\u001a\u000200H\u0000\u00a2\u0006\u0004\b1\u00102J\u0006\u00104\u001a\u000203J\u0010\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020#H\u0016J\u0010\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u000203H\u0016J\b\u00109\u001a\u00020\u0007H\u0016J\u0010\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u000203H\u0016J*\u0010A\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\b\u0010@\u001a\u0004\u0018\u00010)H\u0016J\b\u0010B\u001a\u00020\u0007H\u0016J\b\u0010C\u001a\u00020\u0007H\u0016J\b\u0010D\u001a\u00020\u0007H\u0016J\b\u0010E\u001a\u00020\u0007H\u0016J\b\u0010F\u001a\u00020\u0007H\u0016J\u000e\u0010I\u001a\u00020\u00072\u0006\u0010H\u001a\u00020GJ\u0010\u0010L\u001a\u00020\u00072\b\u0010K\u001a\u0004\u0018\u00010JJ\u000e\u0010N\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\rJ\u000e\u0010P\u001a\u00020\u00072\u0006\u0010O\u001a\u00020<J\u0006\u0010Q\u001a\u00020\u0007R\u0016\u0010S\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010Z\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001a0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010^R\"\u0010f\u001a\u00020`8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010p\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010mR\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010u\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010x\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010|\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u007f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/qqnt/videoplay/player/b;", "Landroid/view/View;", "layoutContent", "", "radius", "", "v", "dp", "o", "Landroid/content/Context;", "context", "", "fullScreen", "setViewRadius", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "i", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/ProgressView;", "progressView", "setProgressView$videoplay_kit_release", "(Lcom/tencent/mobileqq/qqnt/videoplay/api/component/ProgressView;)V", "setProgressView", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/PlayControlView;", "playControlView", "l", "(Lcom/tencent/mobileqq/qqnt/videoplay/api/component/PlayControlView;)V", "y", "u", "t", "needRecordPosition", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/qqnt/videoplay/player/PlayState;", ReportConstant.COSTREPORT_PREFIX, "Landroid/graphics/drawable/Drawable;", "drawable", "setCoverImage", "error", "", "errorMsg", "w", "show", HippyTKDListViewAdapter.X, "isMute", "setMute", "Lcom/tencent/mobileqq/qqnt/videoplay/player/a;", "r", "()Lcom/tencent/mobileqq/qqnt/videoplay/player/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "state", "a", "position", "b", "onDownloadComplete", "downSize", "d", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "exInfo", "c", "onFirstFrameRendered", "onVideoPrepared", "onBufferStart", "onBufferEnd", "onSurfaceDestroy", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "param", "setVideoParam", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/a;", "listener", "setMuteClickCallback", "forbid", "setForbidStateCallBack", "visibility", "setVideoViewVisibility", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "videoParam", "Lkotlinx/coroutines/CoroutineScope;", "e", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "f", "Lcom/tencent/mobileqq/qqnt/videoplay/player/a;", "mPlayProxy", h.F, "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/ProgressView;", "", "Ljava/util/List;", "playControlViewList", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "p", "()Landroid/widget/ImageView;", "setCoverView", "(Landroid/widget/ImageView;)V", "coverView", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "videoView", "Landroid/widget/RelativeLayout;", "D", "Landroid/widget/RelativeLayout;", "bufferPanel", "E", "errorPanel", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "G", "Landroid/graphics/drawable/Drawable;", "coverImage", "H", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/a;", "muteChangeListener", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/TimeAndMutePanel;", "I", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/TimeAndMutePanel;", "timeAndMutePanel", "J", "Z", "forbidStateCallBack", "showTimeAndMute", "hideErrorPanel", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;Lkotlinx/coroutines/CoroutineScope;ZZZF)V", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;Lkotlinx/coroutines/CoroutineScope;)V", "K", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes17.dex */
public final class BaseVideoView extends FrameLayout implements com.tencent.mobileqq.qqnt.videoplay.player.b {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ISPlayerVideoView videoView;

    /* renamed from: D, reason: from kotlin metadata */
    private RelativeLayout bufferPanel;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout errorPanel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String errorMsg;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Drawable coverImage;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqnt.videoplay.api.param.a muteChangeListener;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TimeAndMutePanel timeAndMutePanel;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean forbidStateCallBack;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.qqnt.videoplay.api.param.c videoParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope coroutineScope;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqnt.videoplay.player.a mPlayProxy;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ProgressView progressView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<PlayControlView> playControlViewList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public ImageView coverView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqnt.videoplay.api.component.BaseVideoView$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView$b", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/TimeAndMutePanel$b;", "", "mute", "", "a", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements TimeAndMutePanel.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseVideoView.this);
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.component.TimeAndMutePanel.b
        public void a(boolean mute) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, mute);
                return;
            }
            BaseVideoView.this.setMute(mute);
            com.tencent.mobileqq.qqnt.videoplay.api.param.a aVar = BaseVideoView.this.muteChangeListener;
            if (aVar != null) {
                aVar.a(mute);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView$c", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f274156a;

        c(float f16) {
            this.f274156a = f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16));
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f274156a);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39072);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ BaseVideoView(Context context, com.tencent.mobileqq.qqnt.videoplay.api.param.c cVar, CoroutineScope coroutineScope, boolean z16, boolean z17, boolean z18, float f16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, cVar, coroutineScope, z16, (i3 & 16) != 0 ? false : z17, (i3 & 32) != 0 ? false : z18, (i3 & 64) != 0 ? 8.0f : f16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, cVar, coroutineScope, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Float.valueOf(f16), Integer.valueOf(i3), defaultConstructorMarker);
    }

    private final void i(Context context) {
        View b16 = new a().b(context, null);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.errorPanel = (RelativeLayout) b16;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        View view = this.errorPanel;
        Intrinsics.checkNotNull(view);
        addView(view, layoutParams);
        RelativeLayout relativeLayout = this.errorPanel;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(8);
    }

    private final void j(Context context) {
        RelativeLayout relativeLayout = null;
        View b16 = new com.tencent.mobileqq.qqnt.videoplay.api.component.c().b(context, null);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.bufferPanel = (RelativeLayout) b16;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        View view = this.bufferPanel;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bufferPanel");
            view = null;
        }
        addView(view, layoutParams);
        RelativeLayout relativeLayout2 = this.bufferPanel;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bufferPanel");
        } else {
            relativeLayout = relativeLayout2;
        }
        relativeLayout.setVisibility(8);
    }

    private final void k() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TimeAndMutePanel timeAndMutePanel = new TimeAndMutePanel(context, this.coroutineScope, this.mPlayProxy, this, new b());
        timeAndMutePanel.j(false);
        this.timeAndMutePanel = timeAndMutePanel;
    }

    private final void m(Context context, boolean fullScreen, boolean setViewRadius) {
        ImageView.ScaleType scaleType;
        ImageView imageView = new ImageView(context);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        if (fullScreen) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        } else {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        imageView.setScaleType(scaleType);
        if (setViewRadius) {
            v(imageView, o(8.0f));
        }
        setCoverView(imageView);
    }

    private final float o(float dp5) {
        return (getContext().getResources().getDisplayMetrics().density * dp5) + 0.5f;
    }

    private final void v(View layoutContent, float radius) {
        if (layoutContent == null) {
            return;
        }
        layoutContent.setOutlineProvider(new c(radius));
        layoutContent.setClipToOutline(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_ProgressView", 2, "startUpdatingTime");
        }
        TimeAndMutePanel timeAndMutePanel = this.timeAndMutePanel;
        if (timeAndMutePanel != null) {
            timeAndMutePanel.k();
        }
    }

    public final void A(boolean needRecordPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, needRecordPosition);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_BaseVideoView", 1, "stopPlay, this=" + hashCode());
        }
        this.mPlayProxy.stopPlay(needRecordPosition);
        p().setVisibility(0);
        TimeAndMutePanel timeAndMutePanel = this.timeAndMutePanel;
        if (timeAndMutePanel != null) {
            timeAndMutePanel.l();
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.b
    public void a(@NotNull PlayState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.forbidStateCallBack) {
            QLog.d("VideoPlay_BaseVideoView", 1, "forbidStateCallBack");
            return;
        }
        if (state.isSDKInited()) {
            if (this.videoParam.j() != null) {
                g j3 = this.videoParam.j();
                Intrinsics.checkNotNull(j3);
                if (!j3.a()) {
                    return;
                }
            }
            this.mPlayProxy.startPlay();
            return;
        }
        RelativeLayout relativeLayout = null;
        if (state.isPreparing()) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getMain(), null, new BaseVideoView$onStateChange$1(this, null), 2, null);
        } else if (state.isReleased()) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getMain(), null, new BaseVideoView$onStateChange$2(this, null), 2, null);
        }
        if (state.isInPlaying()) {
            z();
            ProgressView progressView = this.progressView;
            if (progressView != null) {
                progressView.setDuration$videoplay_kit_release();
            }
            ProgressView progressView2 = this.progressView;
            if (progressView2 != null) {
                progressView2.f(this.coroutineScope);
            }
            Iterator<T> it = this.playControlViewList.iterator();
            while (it.hasNext()) {
                ((PlayControlView) it.next()).setPlayState$videoplay_kit_release(true);
            }
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getMain(), null, new BaseVideoView$onStateChange$4(this, null), 2, null);
            return;
        }
        int i3 = 0;
        if (!state.isPaused() && !state.isReleased() && !state.isPlayCompleted()) {
            if (state.isPlayError()) {
                QLog.i("VideoPlay_BaseVideoView", 1, "onStateChange, play error");
                A(false);
                w(state.isPlayError(), this.errorMsg);
                return;
            }
            RelativeLayout relativeLayout2 = this.bufferPanel;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bufferPanel");
            } else {
                relativeLayout = relativeLayout2;
            }
            if (!state.isBuffering()) {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
            return;
        }
        ProgressView progressView3 = this.progressView;
        if (progressView3 != null) {
            progressView3.g();
        }
        Iterator<T> it5 = this.playControlViewList.iterator();
        while (it5.hasNext()) {
            ((PlayControlView) it5.next()).setPlayState$videoplay_kit_release(false);
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getMain(), null, new BaseVideoView$onStateChange$6(this, null), 2, null);
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.b
    public void b(long position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, position);
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.b
    public void c(int module, int errorType, int errorCode, @Nullable String exInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(module), Integer.valueOf(errorType), Integer.valueOf(errorCode), exInfo);
            return;
        }
        String string = getResources().getString(R.string.yi6);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.VideoPlay_Error)");
        this.errorMsg = string;
        if (module == 1) {
            String string2 = getResources().getString(R.string.yi8);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026ng.VideoPlay_OnlineError)");
            this.errorMsg = string2;
        }
        if (errorCode == 14011001) {
            String string3 = getResources().getString(R.string.yi7);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.VideoPlay_Expired)");
            this.errorMsg = string3;
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getMain(), null, new BaseVideoView$onPlayError$1(this, errorCode, null), 2, null);
        QLog.i("VideoPlay_BaseVideoView", 1, "[onPlayError] type=" + errorType + " code=" + errorCode + " msg=" + this.errorMsg + " exInfo=" + exInfo);
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.b
    public void d(long downSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, downSize);
        }
    }

    public final void l(@NotNull PlayControlView playControlView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) playControlView);
        } else {
            Intrinsics.checkNotNullParameter(playControlView, "playControlView");
            this.playControlViewList.add(playControlView);
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else {
            removeAllViews();
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.b
    public void onBufferEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getMain(), null, new BaseVideoView$onBufferEnd$1(this, null), 2, null);
        } else {
            iPatchRedirector.redirect((short) 28, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.b
    public void onBufferStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getMain(), null, new BaseVideoView$onBufferStart$1(this, null), 2, null);
        } else {
            iPatchRedirector.redirect((short) 27, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.b
    public void onDownloadComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        e h16 = this.videoParam.h();
        if (h16 != null) {
            h16.a(this.videoParam);
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.b
    public void onFirstFrameRendered() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_BaseVideoView", 1, "onFirstFrameRendered");
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getMain(), null, new BaseVideoView$onFirstFrameRendered$1(this, null), 2, null);
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.b
    public void onSurfaceDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getMain(), null, new BaseVideoView$onSurfaceDestroy$1(this, null), 2, null);
        } else {
            iPatchRedirector.redirect((short) 29, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.b
    public void onVideoPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getMain(), null, new BaseVideoView$onVideoPrepared$1(this, null), 2, null);
        } else {
            iPatchRedirector.redirect((short) 26, (Object) this);
        }
    }

    @NotNull
    public final ImageView p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ImageView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ImageView imageView = this.coverView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coverView");
        return null;
    }

    public final long q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
        }
        try {
            return this.mPlayProxy.getCurrentPositionMs();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i("VideoPlay_BaseVideoView", 1, "getCurPlayingPos error: " + th5.getMessage());
            }
            return -1L;
        }
    }

    @NotNull
    public final com.tencent.mobileqq.qqnt.videoplay.player.a r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.mobileqq.qqnt.videoplay.player.a) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mPlayProxy;
    }

    @NotNull
    public final PlayState s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (PlayState) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mPlayProxy.getPlayState();
    }

    public final void setCoverImage(@NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_BaseVideoView", 1, "setCoverImage");
        }
        this.coverImage = drawable;
        p().setImageDrawable(drawable);
        p().setVisibility(0);
    }

    public final void setCoverView(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.coverView = imageView;
        }
    }

    public final void setForbidStateCallBack(boolean forbid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, forbid);
        } else {
            this.forbidStateCallBack = forbid;
        }
    }

    public final void setMute(boolean isMute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, isMute);
            return;
        }
        this.mPlayProxy.setMute(isMute);
        TimeAndMutePanel timeAndMutePanel = this.timeAndMutePanel;
        if (timeAndMutePanel != null) {
            timeAndMutePanel.i(isMute);
        }
    }

    public final void setMuteClickCallback(@Nullable com.tencent.mobileqq.qqnt.videoplay.api.param.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) listener);
        } else {
            this.muteChangeListener = listener;
        }
    }

    public final void setProgressView$videoplay_kit_release(@NotNull ProgressView progressView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) progressView);
        } else {
            Intrinsics.checkNotNullParameter(progressView, "progressView");
            this.progressView = progressView;
        }
    }

    public final void setVideoParam(@NotNull com.tencent.mobileqq.qqnt.videoplay.api.param.c param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        if (this.videoParam.k(param)) {
            return;
        }
        this.videoParam = param;
        this.mPlayProxy.a(param);
        w(false, "");
    }

    public final void setVideoViewVisibility(int visibility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, visibility);
            return;
        }
        Object obj = this.videoView;
        if (obj instanceof View) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            ((View) obj).setVisibility(visibility);
        }
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_BaseVideoView", 1, "pausePlay, this=" + hashCode());
        }
        this.mPlayProxy.pausePlay();
    }

    public final void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_BaseVideoView", 1, "resumePlay, this=" + hashCode() + " isMute=" + this.mPlayProxy.isMute());
        }
        this.mPlayProxy.resumePlay();
        TimeAndMutePanel timeAndMutePanel = this.timeAndMutePanel;
        if (timeAndMutePanel != null) {
            timeAndMutePanel.i(this.mPlayProxy.isMute());
        }
    }

    public final void w(boolean error, @NotNull String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(error), errorMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        RelativeLayout relativeLayout = this.errorPanel;
        if (relativeLayout != null) {
            if (error) {
                relativeLayout.setVisibility(0);
                TextView textView = (TextView) relativeLayout.findViewById(R.id.uwy);
                if (textView != null) {
                    textView.setText(errorMsg);
                    return;
                }
                return;
            }
            relativeLayout.setVisibility(8);
        }
    }

    public final void x(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, show);
            return;
        }
        TimeAndMutePanel timeAndMutePanel = this.timeAndMutePanel;
        if (timeAndMutePanel != null) {
            timeAndMutePanel.j(show);
        }
    }

    public final void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_BaseVideoView", 1, "startPlay, this=" + hashCode() + ", state=" + s());
        }
        this.mPlayProxy.startPlay();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseVideoView(@NotNull Context context, @NotNull com.tencent.mobileqq.qqnt.videoplay.api.param.c videoParam, @NotNull CoroutineScope coroutineScope, boolean z16, boolean z17, boolean z18, float f16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoParam, "videoParam");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, videoParam, coroutineScope, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Float.valueOf(f16));
            return;
        }
        this.videoParam = videoParam;
        this.coroutineScope = coroutineScope;
        this.playControlViewList = new ArrayList();
        String string = context.getString(R.string.yi6);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.VideoPlay_Error)");
        this.errorMsg = string;
        PlayCoreProxy playCoreProxy = new PlayCoreProxy(this.videoParam, this, coroutineScope);
        this.mPlayProxy = playCoreProxy;
        ISPlayerVideoView videoView = playCoreProxy.getVideoView();
        this.videoView = videoView;
        if (videoView != 0 && (videoView instanceof View)) {
            Intrinsics.checkNotNull(videoView, "null cannot be cast to non-null type android.view.View");
            ((View) videoView).setId(R.id.f1183373v);
            if (z18) {
                Object obj = this.videoView;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
                v((View) obj, o(f16));
            }
            Object obj2 = this.videoView;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View");
            addView((View) obj2, new FrameLayout.LayoutParams(-1, -1));
        }
        m(context, this.videoParam.a().e(), z18);
        j(context);
        if (!z17) {
            i(context);
        }
        if (z16) {
            k();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseVideoView(@NotNull Context context, @NotNull com.tencent.mobileqq.qqnt.videoplay.api.param.c videoParam, @NotNull CoroutineScope coroutineScope) {
        this(context, videoParam, coroutineScope, false, false, false, 0.0f, 112, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoParam, "videoParam");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, this, context, videoParam, coroutineScope);
    }
}
