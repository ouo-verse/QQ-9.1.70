package com.tencent.zplan.world.render.parallel;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.zplan.common.utils.f;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.view.WorldRenderSurfaceView;
import com.tencent.zplan.world.view.WorldRenderTextureView;
import com.tencent.zplan.world.view.c;
import com.tencent.zplan.world.view.d;
import dy4.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 32\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\ba\u00101J/\u0010\t\u001a\u00020\u00072%\b\u0002\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H$J2\u0010\u0012\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J$\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0003H\u0016J$\u0010#\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u001bH$J\b\u0010$\u001a\u00020\u0007H&J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0017H&R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00107\u001a\u00020\u00178\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010=\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010D\u001a\u0004\u0018\u00010>8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010J\u001a\u00020\u001d8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010M\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b.\u00108\u001a\u0004\bK\u0010:\"\u0004\bL\u0010<R\"\u0010N\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b9\u00108\u001a\u0004\bN\u0010:\"\u0004\bO\u0010<R\u0018\u0010R\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0017\u0010S\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b@\u00102\u001a\u0004\bP\u00104R\u001a\u0010W\u001a\u00020\u00198\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bT\u0010VR$\u0010]\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0014\u0010`\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010_\u00a8\u0006b"}, d2 = {"Lcom/tencent/zplan/world/render/parallel/AbsZPlanWorldRender;", "Ldy4/a;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "afterInit", "o", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "needEvent", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "useSurfaceView", "Landroid/view/View;", "b", "Lcom/tencent/zplan/world/view/b;", "listener", "setOnTouchEventListener", "destroy", "", "sceneType", "", "sceneParams", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "c", "Lcom/tencent/zplan/model/a;", "d", "Lcom/tencent/zplan/world/view/d;", "setRenderListener", "hasFocus", "a", "e", "u", "width", "height", "p", "Landroid/app/Activity;", "f", "()Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroid/app/Activity;)V", "Landroid/content/Context;", "g", "()Landroid/content/Context;", "r", "(Landroid/content/Context;)V", "I", DomainData.DOMAIN_NAME, "()I", "t", "(I)V", "worldID", "Z", h.F, "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "engineInitDone", "Lcom/tencent/zplan/world/view/c;", "Lcom/tencent/zplan/world/view/c;", "j", "()Lcom/tencent/zplan/world/view/c;", "setRenderView", "(Lcom/tencent/zplan/world/view/c;)V", "renderView", "Lcom/tencent/zplan/model/a;", "l", "()Lcom/tencent/zplan/model/a;", "setSceneData", "(Lcom/tencent/zplan/model/a;)V", ISchemeApi.KEY_SCENE_DATA, "getInZPlanProcess", "setInZPlanProcess", "inZPlanProcess", "isPeakProcess", "setPeakProcess", "i", "Lcom/tencent/zplan/world/view/d;", "zPlanSurfaceTextureListener", "renderHashCode", "k", "Ljava/lang/String;", "()Ljava/lang/String;", "reportRenderHashCode", "Ljava/lang/Boolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/Boolean;", "setSetFocusState", "(Ljava/lang/Boolean;)V", "setFocusState", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "focusListener", "<init>", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public abstract class AbsZPlanWorldRender implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile int worldID;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean engineInitDone;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c renderView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.zplan.model.a sceneData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean inZPlanProcess;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isPeakProcess;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private d zPlanSurfaceTextureListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int renderHashCode;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String reportRenderHashCode;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean setFocusState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ViewTreeObserver.OnWindowFocusChangeListener focusListener;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/world/render/parallel/AbsZPlanWorldRender$b", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "", "hasFocus", "", "onWindowFocusChanged", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements ViewTreeObserver.OnWindowFocusChangeListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean hasFocus) {
            ZLog.f386189b.k("[zplan][AbsZPlanWorldRender]", "onWindowFocusChanged, hasFocus: " + hasFocus + ", renderView: " + AbsZPlanWorldRender.this.getRenderView());
            AbsZPlanWorldRender.this.a(hasFocus);
        }
    }

    public AbsZPlanWorldRender(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.worldID = -1;
        this.sceneData = new com.tencent.zplan.model.a();
        int hashCode = hashCode();
        this.renderHashCode = hashCode;
        this.reportRenderHashCode = "_" + hashCode;
        this.focusListener = new b();
        f fVar = f.f385292a;
        this.inZPlanProcess = fVar.e(context, ":zplan");
        this.isPeakProcess = fVar.e(context, ":peak");
        ZLog.f386189b.k("[zplan][AbsZPlanWorldRender]", "is zplan process " + this.inZPlanProcess + ", is peak Process " + this.isPeakProcess);
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
                this.renderView = new WorldRenderSurfaceView(context, needEvent, this.inZPlanProcess, this.isPeakProcess, this);
            } else {
                this.renderView = new WorldRenderTextureView(context, needEvent, opaque, this.inZPlanProcess, this.isPeakProcess, this);
            }
            c cVar = this.renderView;
            Intrinsics.checkNotNull(cVar);
            cVar.getView().getViewTreeObserver().addOnWindowFocusChangeListener(this.focusListener);
        }
        c cVar2 = this.renderView;
        Intrinsics.checkNotNull(cVar2);
        return cVar2.getView();
    }

    @Override // dy4.a
    public void c(final int sceneType, @Nullable final String sceneParams, @Nullable final IZPlanWorldStatusListener listener) {
        ZLog.f386189b.l("[zplan][AbsZPlanWorldRender]", "enterAvatarScene,", new StackPrinter("enterAvatarScene"));
        this.sceneData.c(sceneType);
        o(new Function1<Boolean, Unit>() { // from class: com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender$enterAvatarScene$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ZLog.f386189b.k("[zplan][AbsZPlanWorldRender]", "enterAvatarScene, sceneType:" + sceneType + ", worldID:" + AbsZPlanWorldRender.this.getWorldID() + ", engineInitResult: " + z16);
                if (!z16) {
                    IZPlanWorldStatusListener iZPlanWorldStatusListener = listener;
                    if (iZPlanWorldStatusListener != null) {
                        iZPlanWorldStatusListener.onEnterSceneResult(false);
                        return;
                    }
                    return;
                }
                AbsZPlanWorldRender.this.e(sceneType, sceneParams, listener);
            }
        });
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
        this.worldID = -1;
        c cVar = this.renderView;
        if (cVar != null && (view = cVar.getView()) != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnWindowFocusChangeListener(this.focusListener);
        }
        this.activity = null;
        this.context = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void e(int sceneType, @Nullable String sceneParams, @Nullable IZPlanWorldStatusListener listener);

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
    /* renamed from: h, reason: from getter */
    public final boolean getEngineInitDone() {
        return this.engineInitDone;
    }

    /* renamed from: i, reason: from getter */
    public final int getRenderHashCode() {
        return this.renderHashCode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: j, reason: from getter */
    public final c getRenderView() {
        return this.renderView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getReportRenderHashCode() {
        return this.reportRenderHashCode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.zplan.model.a l() {
        return this.sceneData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: m, reason: from getter */
    public final Boolean getSetFocusState() {
        return this.setFocusState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n, reason: from getter */
    public final int getWorldID() {
        return this.worldID;
    }

    protected abstract void o(@Nullable Function1<? super Boolean, Unit> afterInit);

    public abstract void p(int width, int height);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(@Nullable Activity activity) {
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(@Nullable Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(boolean z16) {
        this.engineInitDone = z16;
    }

    @Override // dy4.a
    public void setOnTouchEventListener(@NotNull com.tencent.zplan.world.view.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        c cVar = this.renderView;
        if (cVar != null) {
            cVar.setOnTouchEventListener(listener);
        }
    }

    @Override // dy4.a
    public void setRenderListener(@Nullable d listener) {
        this.zPlanSurfaceTextureListener = listener;
        c cVar = this.renderView;
        if (cVar != null) {
            cVar.setRenderListener(listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t(int i3) {
        this.worldID = i3;
    }

    public abstract void u();
}
