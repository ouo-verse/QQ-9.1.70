package com.tencent.mobileqq.guild.mission.beginmission.mainframe.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.theme.d;
import com.tencent.mobileqq.guild.util.cs;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uu1.Mission;
import vu1.b;
import vu1.c;
import vu1.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0014J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0014R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/mainframe/view/MissionListView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/guild/theme/d;", "", "Luu1/a;", "list", "", BdhLogUtil.LogTag.Tag_Conn, NodeProps.ON_ATTACHED_TO_WINDOW, "", "widthSpec", "heightSpec", "onMeasure", "onThemeChanged", NodeProps.ON_DETACHED_FROM_WINDOW, "com/tencent/mobileqq/guild/mission/beginmission/mainframe/view/MissionListView$a", "f", "Lcom/tencent/mobileqq/guild/mission/beginmission/mainframe/view/MissionListView$a;", "gestureListener", "Lvu1/f;", h.F, "Lvu1/f;", "pagerSnapHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MissionListView extends RecyclerView implements d {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a gestureListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private f pagerSnapHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/mission/beginmission/mainframe/view/MissionListView$a", "Lrr1/a;", "Landroid/view/MotionEvent;", "event", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends rr1.a {
        a() {
        }

        @Override // rr1.a
        public boolean b(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return cs.f235535a.a(MissionListView.this, event);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MissionListView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void C(List<Mission> list) {
        setLayoutManager(getLayoutManager());
        setAdapter(new c());
        this.pagerSnapHelper.attachToRecyclerView(null);
        f fVar = new f();
        this.pagerSnapHelper = fVar;
        fVar.m((int) (vu1.a.f443516a.b() * 0.9d));
        this.pagerSnapHelper.attachToRecyclerView(this);
        RecyclerView.Adapter adapter = getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.guild.mission.beginmission.mainframe.view.MissionListAdapter");
        ((c) adapter).l0(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        GuildThemeManager.g(this);
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).addGestureListener(this.gestureListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GuildThemeManager.j(this);
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).removeGestureListener(this.gestureListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        vu1.a aVar = vu1.a.f443516a;
        if (aVar.b() != getMeasuredWidth()) {
            aVar.c(getMeasuredWidth());
            this.pagerSnapHelper.m((int) (aVar.b() * 0.9d));
        }
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        RecyclerView.Adapter adapter = getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.guild.mission.beginmission.mainframe.view.MissionListAdapter");
        C(((c) adapter).k0());
    }

    public /* synthetic */ MissionListView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MissionListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gestureListener = new a();
        setOverScrollMode(2);
        setLayoutManager(new LinearLayoutManager(context, 0, false));
        setAdapter(new c());
        f fVar = new f();
        this.pagerSnapHelper = fVar;
        fVar.attachToRecyclerView(this);
        addItemDecoration(new b());
    }
}
