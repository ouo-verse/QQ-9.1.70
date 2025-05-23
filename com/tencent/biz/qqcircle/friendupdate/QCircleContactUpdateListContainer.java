package com.tencent.biz.qqcircle.friendupdate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.friendupdate.QCircleContactUpdateListContainer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QFSApertureExposeFeedEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q30.QCircleContactUpdateBean;
import q30.d;
import q30.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002+\bB\u001d\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120\u0011H\u0016J\u0006\u0010\u0014\u001a\u00020\u0004R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0016R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006,"}, d2 = {"Lcom/tencent/biz/qqcircle/friendupdate/QCircleContactUpdateListContainer;", "Landroid/widget/FrameLayout;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/qcircle/api/event/QFSApertureExposeFeedEvent;", "", "f", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "c", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "onResume", "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "d", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mUpdateList", "Landroidx/lifecycle/Observer;", "", "Lq30/f;", "Landroidx/lifecycle/Observer;", "mObserver", "Lcom/tencent/biz/qqcircle/friendupdate/QCircleContactUpdateListContainer$c;", "Lcom/tencent/biz/qqcircle/friendupdate/QCircleContactUpdateListContainer$c;", "getOnActionListener", "()Lcom/tencent/biz/qqcircle/friendupdate/QCircleContactUpdateListContainer$c;", "setOnActionListener", "(Lcom/tencent/biz/qqcircle/friendupdate/QCircleContactUpdateListContainer$c;)V", "onActionListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", h.F, "b", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QCircleContactUpdateListContainer extends FrameLayout implements SimpleEventReceiver<QFSApertureExposeFeedEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView mUpdateList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<QCircleContactUpdateBean>> mObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c onActionListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/friendupdate/QCircleContactUpdateListContainer$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lq30/f;", "oldItem", "newItem", "", "b", "a", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends DiffUtil.ItemCallback<QCircleContactUpdateBean> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull QCircleContactUpdateBean oldItem, @NotNull QCircleContactUpdateBean newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull QCircleContactUpdateBean oldItem, @NotNull QCircleContactUpdateBean newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/biz/qqcircle/friendupdate/QCircleContactUpdateListContainer$c;", "", "", "a", "b", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface c {
        void a();

        void b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QCircleContactUpdateListContainer(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QCircleContactUpdateListContainer this$0, List it) {
        d dVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!it.isEmpty()) {
            if (this$0.mUpdateList.getAdapter() != null) {
                RecyclerView.Adapter adapter = this$0.mUpdateList.getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.biz.qqcircle.friendupdate.QCircleContactUpdateAdapter");
                dVar = (d) adapter;
            } else {
                dVar = new d(new a());
            }
            this$0.setVisibility(0);
            this$0.mUpdateList.setAdapter(dVar);
            dVar.submitList(it);
            SimpleEventBus.getInstance().registerReceiver(this$0);
            return;
        }
        this$0.setVisibility(8);
        SimpleEventBus.getInstance().unRegisterReceiver(this$0);
    }

    private final void c(SimpleBaseEvent event) {
        if (!(event instanceof QFSApertureExposeFeedEvent)) {
            return;
        }
        i.f428290a.g(((QFSApertureExposeFeedEvent) event).getFeedId());
    }

    private final void f() {
        if (getContext() instanceof ComponentActivity) {
            i iVar = i.f428290a;
            if (!iVar.d().hasObservers()) {
                MutableLiveData<List<QCircleContactUpdateBean>> d16 = iVar.d();
                Context context = getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                d16.observe((ComponentActivity) context, this.mObserver);
            }
        }
    }

    public final void d() {
        RecyclerView.Adapter adapter = this.mUpdateList.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeChanged(0, adapter.getNUM_BACKGOURND_ICON());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        c cVar = this.onActionListener;
        if (cVar != null) {
            int actionMasked = ev5.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    cVar.b();
                }
            } else {
                cVar.a();
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    public final void e() {
        if (getParent() != null) {
            i.f428290a.h(true);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<QFSApertureExposeFeedEvent>> getEventClass() {
        ArrayList<Class<QFSApertureExposeFeedEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSApertureExposeFeedEvent.class);
        return arrayListOf;
    }

    public final void onDestroy() {
        i iVar = i.f428290a;
        iVar.d().removeObserver(this.mObserver);
        iVar.f();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        c(event);
    }

    public final void onResume() {
        i iVar = i.f428290a;
        if (iVar.b()) {
            setVisibility(8);
        }
        f();
        if (getParent() != null) {
            iVar.h(false);
        }
    }

    public final void setOnActionListener(@Nullable c cVar) {
        this.onActionListener = cVar;
    }

    public /* synthetic */ QCircleContactUpdateListContainer(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QCircleContactUpdateListContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.gwb, (ViewGroup) this, true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        View findViewById = findViewById(R.id.f33010va);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qcircle_update_firends)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.mUpdateList = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        setVisibility(8);
        this.mObserver = new Observer() { // from class: q30.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QCircleContactUpdateListContainer.b(QCircleContactUpdateListContainer.this, (List) obj);
            }
        };
    }
}
