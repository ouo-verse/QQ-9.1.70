package jf3;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.scene.component.base.FromLifeCycle;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.loading.ILoadingLifeCycle;
import com.tencent.zplan.world.model.FirstFrameResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0014J\u001c\u0010\u0015\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0019\u001a\u00020\u0002H\u0014J\u0012\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0014J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J\u001a\u0010'\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020%H\u0014J\b\u0010(\u001a\u00020\u0002H\u0007J\u0006\u0010)\u001a\u00020\u0002R\"\u00100\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\"\u00106\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010+\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Ljf3/e;", "Lld3/c;", "", "z0", "k0", "p0", "x0", "r0", "y0", "i0", "l0", "", "s0", "Lod3/a;", "scene", "gh", "t0", "Landroid/graphics/Bitmap;", "lastFrame", "", "from", "v0", "o0", "G", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "w0", "P", "v4", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "params", "needWaitEngineInit", "Q2", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "textureView", "U", "j0", "m0", ExifInterface.LATITUDE_SOUTH, "Z", "getCanShowAvatar", "()Z", "setCanShowAvatar", "(Z)V", "canShowAvatar", "T", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "enterSceneInfo", "getEnterAvatarTaskRunning", "setEnterAvatarTaskRunning", "enterAvatarTaskRunning", "Ljf3/a;", "V", "Ljf3/a;", "touchListener", "W", "Lod3/a;", "avatarScene", "Ljava/lang/Runnable;", "X", "Ljava/lang/Runnable;", "delayShowAvatarTask", "<init>", "()V", "Y", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class e extends ld3.c {

    /* renamed from: S, reason: from kotlin metadata */
    private boolean canShowAvatar;

    /* renamed from: T, reason: from kotlin metadata */
    private SceneInfo enterSceneInfo;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean enterAvatarTaskRunning;

    /* renamed from: V, reason: from kotlin metadata */
    private a touchListener;

    /* renamed from: W, reason: from kotlin metadata */
    private od3.a avatarScene;

    /* renamed from: X, reason: from kotlin metadata */
    private final Runnable delayShowAvatarTask;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View zplanTextureView = this$0.getZplanTextureView();
        QLog.i(this$0.o0(), 1, "delayShowAvatarTask enterAvatarTaskRunning:" + this$0.enterAvatarTaskRunning + ", view:" + zplanTextureView);
        this$0.canShowAvatar = true;
        this$0.z0();
    }

    private final void i0() {
        QLog.i(o0(), 1, "disableSurface");
        View zplanTextureView = getZplanTextureView();
        if (zplanTextureView == null) {
            return;
        }
        zplanTextureView.setVisibility(4);
    }

    private final void k0() {
        View zplanTextureView = getZplanTextureView();
        QLog.i(o0(), 1, "doPauseTextureTask view:" + zplanTextureView);
        p0();
        i0();
        this.canShowAvatar = false;
        t0();
    }

    private final void l0() {
        QLog.i(o0(), 1, "enableSurface");
        View zplanTextureView = getZplanTextureView();
        if (zplanTextureView == null) {
            return;
        }
        zplanTextureView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p0();
    }

    private final void p0() {
        r0();
        j0();
    }

    private final void r0() {
        QLog.i(o0(), 1, "hideTextureView");
        View zplanTextureView = getZplanTextureView();
        if (zplanTextureView == null) {
            return;
        }
        zplanTextureView.setAlpha(0.0f);
    }

    private final boolean s0() {
        FragmentActivity attachedActivity = getAttachedActivity();
        if (attachedActivity != null) {
            return xk3.b.f448110a.c(attachedActivity);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z0();
    }

    private final void x0() {
        y0();
        m0();
    }

    private final void y0() {
        boolean s06 = s0();
        QLog.i(o0(), 1, "showTextureView, isTopEngineAc:" + s06);
        View zplanTextureView = getZplanTextureView();
        if (zplanTextureView != null) {
            zplanTextureView.setAlpha(1.0f);
        }
        if (s06) {
            l0();
        }
    }

    private final void z0() {
        QLog.i(o0(), 1, "tryShowAvatar canShowAvatar:" + this.canShowAvatar + ", enterAvatarTaskRunning:" + this.enterAvatarTaskRunning);
        if (!this.canShowAvatar || this.enterAvatarTaskRunning) {
            return;
        }
        x0();
    }

    @Override // ld3.c, md3.a, wb4.a
    public void G() {
        super.G();
        QLog.i(o0(), 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // md3.a
    protected void P(@FromLifeCycle String from) {
        SceneInfo sceneInfo;
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i(o0(), 1, "pauseTexture from:" + from + " isResumed:" + getIsResumed() + ", isHiddenState:" + getIsHiddenState() + ",canShowAvatar:" + this.canShowAvatar);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.delayShowAvatarTask);
        if (!getIsResumed() || getIsHiddenState()) {
            boolean z16 = this.canShowAvatar && !this.enterAvatarTaskRunning;
            od3.a aVar = this.avatarScene;
            if (aVar == null || (sceneInfo = aVar.M2()) == null) {
                sceneInfo = this.enterSceneInfo;
            }
            QLog.i(o0(), 1, "pauseTexture self:" + sceneInfo);
            boolean m3 = sceneInfo.m(((xe3.a) vb3.a.f441346a.b(xe3.a.class)).Q0()) ^ true;
            QLog.i(o0(), 1, "pauseTexture avatarShow:" + z16 + " sceneChanged:" + m3);
            v0((!z16 || m3) ? null : c0(), from);
            k0();
        }
    }

    @Override // md3.a
    protected void Q(@FromLifeCycle String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        boolean a16 = com.tencent.mobileqq.zplan.utils.a.f335750a.a();
        boolean s06 = s0();
        QLog.i(o0(), 1, "resumeTexture from:" + from + ", isAppForeground:" + a16 + ", isHiddenState:" + getIsHiddenState() + ", isResumed:" + getIsResumed() + ", ac:" + getAttachedActivity() + ", isTopEngineActivity:" + s06);
        if (s06 && getIsResumed() && !getIsHiddenState()) {
            l0();
            super.Q(from);
            w0();
        }
        QLog.i(o0(), 1, "resumeTexture canShowAvatar:" + this.canShowAvatar);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.delayShowAvatarTask, 450L);
    }

    @Override // md3.a, a84.a
    public void Q2(SceneInfo params, boolean needWaitEngineInit) {
        Intrinsics.checkNotNullParameter(params, "params");
        super.Q2(params, needWaitEngineInit);
        QLog.i(o0(), 1, "enterAvatarScene params:" + params);
        this.enterSceneInfo = params;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jf3.c
            @Override // java.lang.Runnable
            public final void run() {
                e.n0(e.this);
            }
        });
        this.enterAvatarTaskRunning = true;
    }

    @Override // ld3.c
    protected void U(ViewGroup container, View textureView) {
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        QLog.i(o0(), 1, "addTextureView ");
        textureView.setVisibility(4);
        dy4.a zplanRender = getZplanRender();
        if (zplanRender != null) {
            zplanRender.setOnTouchEventListener(this.touchListener);
        }
        super.U(container, textureView);
    }

    @Override // ld3.c, a84.a
    public void gh(od3.a scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.avatarScene = scene;
    }

    public final void j0() {
        this.touchListener.a(true);
        QLog.i(o0(), 1, "enterAvatarScene disableTextureViewTouchEvent");
    }

    public final void m0() {
        this.touchListener.a(false);
        QLog.i(o0(), 1, "enterAvatarScene enableTextureViewTouchEvent");
    }

    protected String o0() {
        throw null;
    }

    @Override // md3.a, com.tencent.zplan.world.IZPlanWorldStatusListener
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ((ILoadingLifeCycle) QRoute.api(ILoadingLifeCycle.class)).onFirstFrame(result);
        super.onFirstFrame(result);
        SceneInfo sceneInfo = this.enterSceneInfo;
        boolean m3 = sceneInfo.m(SceneInfo.INSTANCE.b(result.getParams()));
        if (m3) {
            this.enterAvatarTaskRunning = false;
        }
        QLog.i(o0(), 1, "onFirstFrame canShowAvatar:" + this.canShowAvatar + " isSame:" + m3 + " self:" + sceneInfo + " params:" + result.getParams());
        if (m3) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jf3.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.u0(e.this);
                }
            });
        }
    }

    protected void v0(Bitmap lastFrame, @FromLifeCycle String from) {
        throw null;
    }

    @Override // ld3.c, a84.a
    public Bitmap v4() {
        QLog.i(o0(), 1, "captureFrame enterAvatarTaskRunning:" + this.enterAvatarTaskRunning);
        if (this.enterAvatarTaskRunning) {
            return null;
        }
        return super.v4();
    }

    public e() {
        super(false, 1, null);
        this.enterSceneInfo = SceneInfo.INSTANCE.c();
        this.enterAvatarTaskRunning = true;
        this.touchListener = new a(false);
        this.delayShowAvatarTask = new Runnable() { // from class: jf3.d
            @Override // java.lang.Runnable
            public final void run() {
                e.h0(e.this);
            }
        };
    }

    protected void t0() {
    }

    protected void w0() {
    }
}
