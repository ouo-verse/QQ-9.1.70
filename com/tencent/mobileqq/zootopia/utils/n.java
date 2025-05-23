package com.tencent.mobileqq.zootopia.utils;

import android.util.Log;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ipc.ai;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import defpackage.UEBuglyInfoRecorder;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/utils/n;", "", "", "c", "", "a", "I", "getScene", "()I", "scene", "", "b", "Z", "stopped", "<init>", "(I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static IZPlanWorldStatusListener f329566d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean stopped;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J.\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zootopia/utils/n$a;", "", "", "desc", "", "shouldCheckFloat", "", "sceneType", "", "b", "Ldy4/a;", "zplanRender", "sceneParams", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "listener", "a", "TAG", "Ljava/lang/String;", "zplanWorldStatusListener", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.utils.n$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zootopia/utils/n$a$a", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "", "success", "", "onEnterSceneResult", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zootopia.utils.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes35.dex */
        public static final class C9127a implements IZPlanWorldStatusListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ WeakReference<IZPlanWorldStatusListener> f329569d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f329570e;

            C9127a(WeakReference<IZPlanWorldStatusListener> weakReference, int i3) {
                this.f329569d = weakReference;
                this.f329570e = i3;
            }

            @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
            public void onEnterSceneResult(boolean success) {
                QLog.i("ZootopiaEngineHelper", 1, "onEnterSceneResult, weakListener.get()=" + this.f329569d.get());
                IZPlanWorldStatusListener iZPlanWorldStatusListener = this.f329569d.get();
                if (iZPlanWorldStatusListener != null) {
                    iZPlanWorldStatusListener.onEnterSceneResult(success);
                }
            }

            @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
            public void onFirstFrame(FirstFrameResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.i("ZootopiaEngineHelper", 1, "onFirstFrame, weakListener.get()=" + this.f329569d.get());
                IZPlanWorldStatusListener iZPlanWorldStatusListener = this.f329569d.get();
                if (iZPlanWorldStatusListener != null) {
                    iZPlanWorldStatusListener.onFirstFrame(result);
                }
                if (t74.h.e()) {
                    UEBuglyInfoRecorder.f25109a.onAvatarSceneEnter(this.f329570e);
                } else {
                    ((defpackage.c) k74.i.INSTANCE.a(defpackage.c.class)).onAvatarSceneEnter(this.f329570e);
                }
                n.f329566d = null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(dy4.a zplanRender, int sceneType, String sceneParams, IZPlanWorldStatusListener listener) {
            Intrinsics.checkNotNullParameter(zplanRender, "zplanRender");
            QLog.i("ZootopiaEngineHelper", 1, "enterAvatarScene: sceneType = " + sceneType + ", params = " + sceneParams);
            n.f329566d = new C9127a(new WeakReference(listener), sceneType);
            zplanRender.c(sceneType, sceneParams, n.f329566d);
            ((yk3.d) k74.i.INSTANCE.a(yk3.d.class)).ueEnterAvatarScene(sceneType, sceneParams);
        }

        public final void b(String desc, boolean shouldCheckFloat, int sceneType) {
            boolean R;
            Intrinsics.checkNotNullParameter(desc, "desc");
            if (t74.h.b()) {
                R = ZPlanServiceHelper.I.Q();
            } else {
                R = ZPlanServiceHelper.I.R();
            }
            QLog.i("ZootopiaEngineHelper", 1, "killZPlanProcess, desc:" + desc + ", isUsing:" + R + ", isFloatShow:" + shouldCheckFloat);
            if (!R) {
                ((ai) k74.i.INSTANCE.a(ai.class)).stopZPlanService(shouldCheckFloat);
            }
            if (t74.h.e()) {
                UEBuglyInfoRecorder.f25109a.onAvatarSceneExit(sceneType);
            } else {
                ((defpackage.c) k74.i.INSTANCE.a(defpackage.c.class)).onAvatarSceneExit(sceneType);
            }
        }

        Companion() {
        }

        public static /* synthetic */ void c(Companion companion, String str, boolean z16, int i3, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                z16 = false;
            }
            if ((i16 & 4) != 0) {
                i3 = 0;
            }
            companion.b(str, z16, i3);
        }
    }

    public n(int i3) {
        this.scene = i3;
        QLog.i("ZootopiaEngineHelper", 1, "init for " + i3);
    }

    public final void c() {
        QLog.i("ZootopiaEngineHelper", 1, "stopEngine for " + this.scene + ", stopped:" + this.stopped + ", stack:" + Log.getStackTraceString(new Throwable()));
        if (!t74.h.b()) {
            QLog.w("ZootopiaEngineHelper", 1, "stopEngine not main process, return, " + Log.getStackTraceString(new Throwable()));
            return;
        }
        i.Companion companion = k74.i.INSTANCE;
        if (((com.tencent.mobileqq.zootopia.ipc.f) companion.a(com.tencent.mobileqq.zootopia.ipc.f.class)).isFloat()) {
            QLog.w("ZootopiaEngineHelper", 1, "is float,return");
            return;
        }
        if (this.scene != -1 && ZPlanServiceHelper.I.Q()) {
            QLog.i("ZootopiaEngineHelper", 1, "stopEngine for " + this.scene + ", scene using");
            return;
        }
        if (this.stopped) {
            return;
        }
        this.stopped = true;
        QLog.i("ZootopiaEngineHelper", 1, "stopEngine for " + this.scene + ", not scene use, real stop");
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).stopZPlanEngine(true);
        if (t74.h.e()) {
            UEBuglyInfoRecorder.f25109a.onAvatarSceneExit(this.scene);
        } else {
            ((defpackage.c) companion.a(defpackage.c.class)).onAvatarSceneExit(this.scene);
        }
    }
}
