package com.tencent.icgame.game.liveroom.impl.room.audience.component.audiofocus;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u00014B\u000f\u0012\u0006\u00100\u001a\u00020/\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/audience/component/audiofocus/AudioFocusComponent;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", WSPublicAccReport.SOP_NAME_FOCUS, "t", "c", "k", "i", "u", "v", HippyTKDListViewAdapter.X, "y", "w", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "e", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "log", "Landroid/media/AudioAttributes;", "kotlin.jvm.PlatformType", "f", "Landroid/media/AudioAttributes;", "audioAttributes", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", h.F, "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "focusChangeListener", "Landroid/media/AudioManager;", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/media/AudioManager;", "audioManager", "Lcom/tencent/icgame/game/liveroom/impl/room/audience/component/audiofocus/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "()Lcom/tencent/icgame/game/liveroom/impl/room/audience/component/audiofocus/a;", "afterAnchorOFocusHolder", BdhLogUtil.LogTag.Tag_Conn, "Z", "isPageIn", "D", "isActivityPaused", "Landroid/os/Handler;", "E", "Landroid/os/Handler;", "handler", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", UserInfo.SEX_FEMALE, "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class AudioFocusComponent extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isPageIn;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isActivityPaused;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Handler handler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @RequiresApi(21)
    private final AudioAttributes audioAttributes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AudioManager.OnAudioFocusChangeListener focusChangeListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy audioManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy afterAnchorOFocusHolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioFocusComponent(@NotNull final f32.a componentContext) {
        super(componentContext);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        this.audioAttributes = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        this.focusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.audience.component.audiofocus.b
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i3) {
                AudioFocusComponent.q(AudioFocusComponent.this, i3);
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AudioManager>() { // from class: com.tencent.icgame.game.liveroom.impl.room.audience.component.audiofocus.AudioFocusComponent$audioManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AudioManager invoke() {
                Object systemService = f32.a.this.getContext().getSystemService("audio");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                return (AudioManager) systemService;
            }
        });
        this.audioManager = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.icgame.game.liveroom.impl.room.audience.component.audiofocus.AudioFocusComponent$afterAnchorOFocusHolder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                Handler handler;
                AudioAttributes audioAttributes;
                AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
                handler = AudioFocusComponent.this.handler;
                audioAttributes = AudioFocusComponent.this.audioAttributes;
                Intrinsics.checkNotNullExpressionValue(audioAttributes, "audioAttributes");
                onAudioFocusChangeListener = AudioFocusComponent.this.focusChangeListener;
                return new a(handler, audioAttributes, onAudioFocusChangeListener);
            }
        });
        this.afterAnchorOFocusHolder = lazy2;
        this.handler = new Handler(Looper.getMainLooper());
    }

    private final void c() {
        if (Build.VERSION.SDK_INT >= 26) {
            s().abandonAudioFocusRequest(r().getFocusRequest());
        } else {
            s().abandonAudioFocus(this.focusChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(AudioFocusComponent this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        this$0.log.i("ICGameAudioFocusComponent", "onAudioFocusChange: " + z16);
        if (this$0.isPageIn && this$0.isActivityPaused) {
            this$0.t(z16);
        }
    }

    private final a r() {
        return (a) this.afterAnchorOFocusHolder.getValue();
    }

    private final AudioManager s() {
        return (AudioManager) this.audioManager.getValue();
    }

    private final void t(boolean focus) {
        getComponentContext().w0(new FocusChangeEvent(focus));
    }

    private final void z() {
        int requestAudioFocus;
        boolean z16;
        if (Build.VERSION.SDK_INT >= 26) {
            requestAudioFocus = s().requestAudioFocus(r().getFocusRequest());
        } else {
            requestAudioFocus = s().requestAudioFocus(this.focusChangeListener, 3, 1);
        }
        if (requestAudioFocus == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.log.i("ICGameAudioFocusComponent", "requestAudioFocus, focus " + z16);
        if (z16) {
            t(true);
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
        c();
    }

    public final void u() {
        this.isPageIn = true;
        z();
    }

    public final void v() {
        this.isPageIn = false;
    }

    public final void w() {
        c();
    }

    public final void x() {
        this.isActivityPaused = false;
        if (this.isPageIn) {
            z();
        }
    }

    public final void y() {
        this.isActivityPaused = true;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
