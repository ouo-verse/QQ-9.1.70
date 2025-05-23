package com.qwallet.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qwallet.activity.QWalletServiceManagerActivity;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppGroup;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.qwallet.utils.QWalletUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.home.HomeLegacyBizManager;
import com.tencent.mobileqq.qwallet.home.QWalletHomeFragment;
import com.tencent.mobileqq.qwallet.home.QWalletHomeViewModel;
import com.tencent.mobileqq.qwallet.home.u;
import com.tencent.mobileqq.qwallet.utils.m;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u00015B1\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u00100\u001a\u00020/\u0012\b\b\u0002\u00101\u001a\u00020/\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0014J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0014R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R \u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010'\u00a8\u00066"}, d2 = {"Lcom/qwallet/view/QWalletHomeAppsLayoutV2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "H0", "", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "fullApps", "C0", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppGroup;", "currentAppGroupList", "F0", "", "G0", "onFinishInflate", "Landroid/view/MotionEvent;", "event", NodeProps.ON_INTERCEPT_TOUCH_EVENT, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "d", "Lkotlin/Lazy;", "D0", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "viewModel", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "appListRecyclerView", "f", "Ljava/util/List;", "fullAppGroupList", "Landroid/view/View;", tl.h.F, "Landroid/view/View;", "addAppsLayout", "Landroidx/lifecycle/Observer;", "i", "Landroidx/lifecycle/Observer;", "gridAppsObserver", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "appSwitchObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class QWalletHomeAppsLayoutV2 extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView appListRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<QWalletHomePage$AppGroup> fullAppGroupList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View addAppsLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<QWalletHomePage$AppGroup>> gridAppsObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Boolean> appSwitchObserver;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QWalletHomeAppsLayoutV2(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(QWalletHomeAppsLayoutV2 this$0, Boolean changed) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(changed, "changed");
        if (changed.booleanValue()) {
            this$0.H0();
        }
    }

    private final List<QWalletHomePage$AppInfo> C0(List<QWalletHomePage$AppInfo> fullApps) {
        List<QWalletHomePage$AppInfo> emptyList;
        if (fullApps == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : fullApps) {
            String g16 = QWalletUtils.g(((QWalletHomePage$AppInfo) obj).f41686id.get());
            Intrinsics.checkNotNullExpressionValue(g16, "getSwitchAppKey(it.id.get())");
            if (com.tencent.mobileqq.qwallet.utils.g.c(g16, true)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final QWalletHomeViewModel D0() {
        return (QWalletHomeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(QWalletHomeAppsLayoutV2 this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fullAppGroupList = list;
        this$0.H0();
    }

    private final void F0(List<QWalletHomePage$AppGroup> currentAppGroupList) {
        Collection emptyList;
        Set set;
        Set subtract;
        String joinToString$default;
        boolean z16;
        List<QWalletHomePage$AppGroup> list = this.fullAppGroupList;
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                List<QWalletHomePage$AppInfo> list2 = ((QWalletHomePage$AppGroup) it.next()).apps.get();
                Intrinsics.checkNotNullExpressionValue(list2, "it.apps.get()");
                CollectionsKt__MutableCollectionsKt.addAll(emptyList, list2);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it5 = currentAppGroupList.iterator();
        while (it5.hasNext()) {
            List<QWalletHomePage$AppInfo> list3 = ((QWalletHomePage$AppGroup) it5.next()).apps.get();
            Intrinsics.checkNotNullExpressionValue(list3, "it.apps.get()");
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, list3);
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        subtract = CollectionsKt___CollectionsKt.subtract(emptyList, set);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(subtract, ",", null, null, 0, null, new Function1<QWalletHomePage$AppInfo, CharSequence>() { // from class: com.qwallet.view.QWalletHomeAppsLayoutV2$reportClosedApps$closedAppIdList$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull QWalletHomePage$AppInfo it6) {
                Intrinsics.checkNotNullParameter(it6, "it");
                return String.valueOf(it6.f41686id.get());
            }
        }, 30, null);
        if (joinToString$default.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            u.m("index.tuijian.close", joinToString$default, null, null, null, 0, 60, null);
        }
    }

    private final boolean G0() {
        return true;
    }

    private final void H0() {
        Integer num;
        ArrayList arrayList = new ArrayList();
        List<QWalletHomePage$AppGroup> list = this.fullAppGroupList;
        if (list != null) {
            for (QWalletHomePage$AppGroup qWalletHomePage$AppGroup : list) {
                List<QWalletHomePage$AppInfo> C0 = C0(qWalletHomePage$AppGroup.apps.get());
                if (!C0.isEmpty()) {
                    QWalletHomePage$AppGroup qWalletHomePage$AppGroup2 = new QWalletHomePage$AppGroup();
                    qWalletHomePage$AppGroup2.title.set(qWalletHomePage$AppGroup.title.get());
                    qWalletHomePage$AppGroup2.apps.set(C0);
                    QLog.i("QWalletHomeAppsLayoutV2", 1, "app list: title=" + qWalletHomePage$AppGroup2.title.get() + " appSize=" + qWalletHomePage$AppGroup2.apps.get().size());
                    arrayList.add(qWalletHomePage$AppGroup2);
                }
            }
        }
        F0(arrayList);
        List<QWalletHomePage$AppGroup> list2 = this.fullAppGroupList;
        RecyclerView recyclerView = null;
        if (list2 != null) {
            num = Integer.valueOf(list2.size());
        } else {
            num = null;
        }
        QLog.i("QWalletHomeAppsLayoutV2", 1, "updateAppList, full=" + num + ", current=" + arrayList.size());
        if (arrayList.size() == 1) {
            arrayList.get(0).title.set("");
        }
        RecyclerView recyclerView2 = this.appListRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appListRecyclerView");
            recyclerView2 = null;
        }
        RecyclerView.Adapter adapter = recyclerView2.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.qwallet.home.grid.GridAppGroupAdapter");
        ((com.tencent.mobileqq.qwallet.home.grid.a) adapter).submitList(arrayList);
        if (arrayList.isEmpty()) {
            View view = this.addAppsLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addAppsLayout");
                view = null;
            }
            view.setVisibility(0);
            RecyclerView recyclerView3 = this.appListRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appListRecyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setVisibility(8);
            u.m("index.tuijian_add.show", null, null, null, "\u53bb\u6dfb\u52a0", 0, 46, null);
            return;
        }
        View view2 = this.addAppsLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAppsLayout");
            view2 = null;
        }
        view2.setVisibility(8);
        RecyclerView recyclerView4 = this.appListRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appListRecyclerView");
        } else {
            recyclerView = recyclerView4;
        }
        recyclerView.setVisibility(0);
    }

    private final void initView() {
        View view;
        View findViewById = findViewById(R.id.sti);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.app_group_list_recycler)");
        this.appListRecyclerView = (RecyclerView) findViewById;
        com.tencent.mobileqq.qwallet.home.grid.a aVar = new com.tencent.mobileqq.qwallet.home.grid.a();
        RecyclerView recyclerView = this.appListRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appListRecyclerView");
            recyclerView = null;
        }
        recyclerView.setAdapter(aVar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        RecyclerView recyclerView2 = this.appListRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appListRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(linearLayoutManager);
        View findViewById2 = findViewById(R.id.scy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.add_apps_layout)");
        this.addAppsLayout = findViewById2;
        ol2.b.f((TextView) findViewById(R.id.scz), 0, false, 6, null);
        View view2 = this.addAppsLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAppsLayout");
            view2 = null;
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.scx);
        m mVar = m.f279290a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setColorFilter(mVar.a(context, R.attr.akw));
        View view3 = this.addAppsLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAppsLayout");
            view = null;
        } else {
            view = view3;
        }
        com.tencent.mobileqq.qwallet.k.d(view, 0L, new Function0<Unit>() { // from class: com.qwallet.view.QWalletHomeAppsLayoutV2$initView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.mobileqq.base.c.f(QWalletHomeAppsLayoutV2.this.getContext(), new Intent(), QWalletServiceManagerActivity.class, false, 8, null);
                u.m("index.tuijian_add.click", null, null, null, "\u53bb\u6dfb\u52a0", 0, 46, null);
            }
        }, 1, null);
        H0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!G0()) {
            return;
        }
        D0().T1().observeForever(this.gridAppsObserver);
        HomeLegacyBizManager.f277929d.e().observeForever(this.appSwitchObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!G0()) {
            return;
        }
        D0().T1().removeObserver(this.gridAppsObserver);
        HomeLegacyBizManager.f277929d.e().removeObserver(this.appSwitchObserver);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!G0()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        View.inflate(getContext(), R.layout.hii, this);
        initView();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction() & 255;
        if (action != 0) {
            if (action == 1 || action == 3) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(event);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QWalletHomeAppsLayoutV2(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QWalletHomeAppsLayoutV2(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QWalletHomeAppsLayoutV2(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QWalletHomeAppsLayoutV2(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomeViewModel>() { // from class: com.qwallet.view.QWalletHomeAppsLayoutV2$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletHomeViewModel invoke() {
                return ((QWalletHomeFragment) FragmentManager.findFragment(QWalletHomeAppsLayoutV2.this)).Oh();
            }
        });
        this.viewModel = lazy;
        this.gridAppsObserver = new Observer() { // from class: com.qwallet.view.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletHomeAppsLayoutV2.E0(QWalletHomeAppsLayoutV2.this, (List) obj);
            }
        };
        this.appSwitchObserver = new Observer() { // from class: com.qwallet.view.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletHomeAppsLayoutV2.B0(QWalletHomeAppsLayoutV2.this, (Boolean) obj);
            }
        };
    }
}
