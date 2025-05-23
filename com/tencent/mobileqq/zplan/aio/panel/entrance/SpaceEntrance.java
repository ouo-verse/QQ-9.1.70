package com.tencent.mobileqq.zplan.aio.panel.entrance;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance;
import com.tencent.mobileqq.zplan.aio.panel.page.ActionPageBuilder;
import com.tencent.mobileqq.zplan.aio.panel.page.ScenePageBuilder;
import com.tencent.mobileqq.zplan.aio.panel.page.view.PageView;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.aio.panel.panel.PanelAdapter;
import com.tencent.mobileqq.zplan.aio.panel.panel.view.SpacePanelLayout;
import com.tencent.state.report.SquareReportConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import le3.ApiPanelEventHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001#Bn\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012H\u0010\u001f\u001aD\b\u0001\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\fR\\\u0010\u001f\u001aD\b\u0001\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00148\u0006\u00f8\u0001\u0000\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u000e\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/entrance/SpaceEntrance;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "text", "b", "I", "()I", "drawableRes", "c", "reportElementId", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "scope", "Landroid/view/View;", "view", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function3;", "()Lkotlin/jvm/functions/Function3;", "onPerformClick", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function3;)V", "e", "Companion", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final /* data */ class SpaceEntrance {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int drawableRes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String reportElementId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final Function3<CoroutineScope, View, Continuation<? super Unit>, Object> onPerformClick;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J@\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/entrance/SpaceEntrance$Companion;", "", "Landroid/content/Context;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "Landroid/view/View;", "behindViews", "popupParent", "Lle3/a;", "handler", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/zplan/aio/panel/entrance/SpaceEntrance;", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(CoroutineScope scope, MutableStateFlow this_apply, View view) {
            Intrinsics.checkNotNullParameter(scope, "$scope");
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            CorountineFunKt.e(scope, "zplan_SpaceEntrance_\u6253\u5f00\u52a8\u4f5c\u9762\u677f", null, null, null, new SpaceEntrance$Companion$generateSource$4$1$1(this_apply, scope, view, null), 14, null);
        }

        public final StateFlow<List<SpaceEntrance>> b(final Context context, final CoroutineScope scope, List<? extends View> behindViews, View popupParent, final ApiPanelEventHandler handler) {
            List listOf;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(behindViews, "behindViews");
            Intrinsics.checkNotNullParameter(popupParent, "popupParent");
            Intrinsics.checkNotNullParameter(handler, "handler");
            SpaceEntrance$Companion$generateSource$showPanelLayout$1 spaceEntrance$Companion$generateSource$showPanelLayout$1 = new SpaceEntrance$Companion$generateSource$showPanelLayout$1(handler, scope, context, new Function0<SpacePanelLayout>() { // from class: com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance$Companion$generateSource$createPanelLayout$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SpacePanelLayout invoke() {
                    List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> listOf2;
                    SpacePanelLayout spacePanelLayout = new SpacePanelLayout(context, null, 0, 6, null);
                    CoroutineScope coroutineScope = scope;
                    Context context2 = context;
                    ApiPanelEventHandler apiPanelEventHandler = handler;
                    PageView.Theme.Companion companion = PageView.Theme.INSTANCE;
                    listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.zplan.aio.panel.page.c[]{new ActionPageBuilder(coroutineScope, context2, companion.c(), apiPanelEventHandler.d(), null, 16, null), new ScenePageBuilder(coroutineScope, context2, companion.c(), apiPanelEventHandler.b(), apiPanelEventHandler.e(), apiPanelEventHandler.getFriendUin())});
                    StateFlow<Panel> j3 = Panel.f331286c.j(coroutineScope, listOf2);
                    PanelAdapter panelAdapter = new PanelAdapter(coroutineScope, j3, listOf2);
                    spacePanelLayout.setDataSource(j3);
                    spacePanelLayout.j().setAdapter(panelAdapter);
                    new com.google.android.material.tabs.d(spacePanelLayout.i(), spacePanelLayout.j(), spacePanelLayout.h()).a();
                    CorountineFunKt.e(coroutineScope, "zplan_AbstractPanelLayout_\u597d\u53cb\u65f6\u5149_\u76d1\u542c\u9762\u677f\u66f4\u65b0", null, null, null, new SpaceEntrance$Companion$generateSource$createPanelLayout$1$1$1(j3, panelAdapter, null), 14, null);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 300.0f, context2.getResources().getDisplayMetrics()));
                    layoutParams.addRule(14);
                    layoutParams.addRule(12);
                    spacePanelLayout.setLayoutParams(layoutParams);
                    return spacePanelLayout;
                }
            }, behindViews, popupParent, null);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new SpaceEntrance[]{new SpaceEntrance("\u52a8\u4f5c", R.drawable.i4o, SquareReportConst.ElementId.ELEMENT_ID_MULTI_ACTION_ITEM, new SpaceEntrance$Companion$generateSource$1(spaceEntrance$Companion$generateSource$showPanelLayout$1, null)), new SpaceEntrance("\u573a\u666f", R.drawable.i4q, "em_zplan_scene_icon", new SpaceEntrance$Companion$generateSource$2(spaceEntrance$Companion$generateSource$showPanelLayout$1, null)), new SpaceEntrance("\u6362\u88c5", R.drawable.i4r, "em_zplan_dressup_icon", new SpaceEntrance$Companion$generateSource$3(handler, null))});
            final MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(listOf);
            handler.f().invoke(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aio.panel.entrance.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpaceEntrance.Companion.c(CoroutineScope.this, MutableStateFlow, view);
                }
            });
            return MutableStateFlow;
        }

        Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpaceEntrance(String text, int i3, String reportElementId, Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> onPerformClick) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(reportElementId, "reportElementId");
        Intrinsics.checkNotNullParameter(onPerformClick, "onPerformClick");
        this.text = text;
        this.drawableRes = i3;
        this.reportElementId = reportElementId;
        this.onPerformClick = onPerformClick;
    }

    /* renamed from: a, reason: from getter */
    public final int getDrawableRes() {
        return this.drawableRes;
    }

    public final Function3<CoroutineScope, View, Continuation<? super Unit>, Object> b() {
        return this.onPerformClick;
    }

    /* renamed from: c, reason: from getter */
    public final String getReportElementId() {
        return this.reportElementId;
    }

    /* renamed from: d, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((((this.text.hashCode() * 31) + this.drawableRes) * 31) + this.reportElementId.hashCode()) * 31) + this.onPerformClick.hashCode();
    }

    public String toString() {
        return "SpaceEntrance(text=" + this.text + ", drawableRes=" + this.drawableRes + ", reportElementId=" + this.reportElementId + ", onPerformClick=" + this.onPerformClick + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpaceEntrance)) {
            return false;
        }
        SpaceEntrance spaceEntrance = (SpaceEntrance) other;
        return Intrinsics.areEqual(this.text, spaceEntrance.text) && this.drawableRes == spaceEntrance.drawableRes && Intrinsics.areEqual(this.reportElementId, spaceEntrance.reportElementId) && Intrinsics.areEqual(this.onPerformClick, spaceEntrance.onPerformClick);
    }
}
