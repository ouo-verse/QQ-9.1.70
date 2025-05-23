package com.tencent.zplan.world.render.normal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import com.epicgames.ue4.UE4;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.view.NormalRenderSurfaceView;
import com.tencent.zplan.world.view.NormalRenderTextureView;
import com.tencent.zplan.world.view.a;
import com.tencent.zplan.world.view.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 ?2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\bE\u0010FJ2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J$\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u001a\u0010 \u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0004R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00101\u001a\u0004\u0018\u00010+8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00107\u001a\u00020\u001b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010=\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010A\u001a\u00020\u00158\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\"\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/zplan/world/render/normal/a;", "Ldy4/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "", "needEvent", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "useSurfaceView", "Landroid/view/View;", "b", "Lcom/tencent/zplan/world/view/b;", "listener", "", "setOnTouchEventListener", "pause", "resume", "destroy", "", "sceneType", "", "sceneParams", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "c", "Lcom/tencent/zplan/world/view/d;", "setRenderListener", "Lcom/tencent/zplan/model/a;", "d", "hasFocus", "a", "Lorg/json/JSONObject;", "e", "Landroid/app/Activity;", "f", "()Landroid/app/Activity;", "k", "(Landroid/app/Activity;)V", "Landroid/content/Context;", "g", "()Landroid/content/Context;", "l", "(Landroid/content/Context;)V", "Lcom/tencent/zplan/world/view/a;", "Lcom/tencent/zplan/world/view/a;", "getRenderView", "()Lcom/tencent/zplan/world/view/a;", "setRenderView", "(Lcom/tencent/zplan/world/view/a;)V", "renderView", "Lcom/tencent/zplan/model/a;", "i", "()Lcom/tencent/zplan/model/a;", "setSceneData", "(Lcom/tencent/zplan/model/a;)V", ISchemeApi.KEY_SCENE_DATA, "Ljava/lang/Boolean;", "j", "()Ljava/lang/Boolean;", "setSetFocusState", "(Ljava/lang/Boolean;)V", "setFocusState", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "renderHashCode", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "focusListener", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public abstract class a implements dy4.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.zplan.world.view.a renderView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean setFocusState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile com.tencent.zplan.model.a sceneData = new com.tencent.zplan.model.a();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String renderHashCode = "_" + hashCode();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ViewTreeObserver.OnWindowFocusChangeListener focusListener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/world/render/normal/a$b", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "", "hasFocus", "", "onWindowFocusChanged", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements ViewTreeObserver.OnWindowFocusChangeListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean hasFocus) {
            ZLog.f386189b.k("AbsZPlanNormalRender", "onWindowFocusChanged, hasFocus: " + hasFocus);
            a.this.a(hasFocus);
        }
    }

    @Override // dy4.a
    public void a(boolean hasFocus) {
        ZLog.f386189b.l("AbsZPlanNormalRender", "setFocusState, hasFocus: " + hasFocus + ", ", new StackPrinter("enterAvatarScene"));
        this.setFocusState = Boolean.valueOf(hasFocus);
    }

    @Override // dy4.a
    @NotNull
    public View b(@Nullable Activity activity, @NotNull Context context, boolean needEvent, boolean opaque, boolean useSurfaceView) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.renderView == null) {
            ZLog.f386189b.k("AbsZPlanNormalRender", "create RenderView");
            if (useSurfaceView) {
                this.renderView = new NormalRenderSurfaceView(context, needEvent, false, 4, null);
            } else {
                this.renderView = new NormalRenderTextureView(context, needEvent, opaque);
            }
            com.tencent.zplan.world.view.a aVar = this.renderView;
            Intrinsics.checkNotNull(aVar);
            aVar.getView().getViewTreeObserver().addOnWindowFocusChangeListener(this.focusListener);
        }
        com.tencent.zplan.world.view.a aVar2 = this.renderView;
        Intrinsics.checkNotNull(aVar2);
        return aVar2.getView();
    }

    @Override // dy4.a
    public void c(int sceneType, @Nullable String sceneParams, @Nullable IZPlanWorldStatusListener listener) {
        this.sceneData.c(sceneType);
        ZLog.f386189b.l("AbsZPlanNormalRender", "enterAvatarScene,", new StackPrinter("enterAvatarScene"));
    }

    @Override // dy4.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public com.tencent.zplan.model.a getSceneData() {
        return this.sceneData;
    }

    @Override // dy4.a
    public void destroy() {
        View view;
        ViewTreeObserver viewTreeObserver;
        com.tencent.zplan.world.view.a aVar = this.renderView;
        if (aVar != null) {
            aVar.onDestroy();
        }
        com.tencent.zplan.world.view.a aVar2 = this.renderView;
        if (aVar2 != null && (view = aVar2.getView()) != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnWindowFocusChangeListener(this.focusListener);
        }
        this.renderView = null;
        this.activity = null;
        this.context = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final JSONObject e(int sceneType, @Nullable String sceneParams) {
        JSONObject jSONObject;
        if (sceneParams != null) {
            jSONObject = new JSONObject(sceneParams);
        } else {
            jSONObject = new JSONObject();
        }
        jSONObject.put("ViewType", sceneType);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: f, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: g, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getRenderHashCode() {
        return this.renderHashCode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.zplan.model.a i() {
        return this.sceneData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: j, reason: from getter */
    public final Boolean getSetFocusState() {
        return this.setFocusState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(@Nullable Activity activity) {
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(@Nullable Context context) {
        this.context = context;
    }

    @Override // dy4.a
    public void pause() {
        Activity activity;
        ZLog.f386189b.k("AbsZPlanNormalRender", "pause");
        if (UE4.getContext() instanceof Activity) {
            Context context = UE4.getContext();
            if (context != null) {
                activity = (Activity) context;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        } else {
            activity = null;
        }
        com.tencent.zplan.world.view.a aVar = this.renderView;
        if (aVar != null) {
            aVar.onPause(activity);
        }
    }

    @Override // dy4.a
    public void resume() {
        Activity activity;
        ZLog.f386189b.k("AbsZPlanNormalRender", "resume");
        if (UE4.getContext() instanceof Activity) {
            Context context = UE4.getContext();
            if (context != null) {
                activity = (Activity) context;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        } else {
            activity = null;
        }
        com.tencent.zplan.world.view.a aVar = this.renderView;
        if (aVar != null) {
            a.C10078a.a(aVar, activity, false, 2, null);
        }
    }

    @Override // dy4.a
    public void setOnTouchEventListener(@NotNull com.tencent.zplan.world.view.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.zplan.world.view.a aVar = this.renderView;
        if (aVar != null) {
            aVar.setOnTouchEventListener(listener);
        }
    }

    @Override // dy4.a
    public void setRenderListener(@Nullable d listener) {
        com.tencent.zplan.world.view.a aVar;
        if (listener != null && (aVar = this.renderView) != null) {
            aVar.setTextureViewListener(listener);
        }
    }
}
