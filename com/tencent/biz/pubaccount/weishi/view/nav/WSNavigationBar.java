package com.tencent.biz.pubaccount.weishi.view.nav;

import android.content.Context;
import android.database.Observable;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0006'()\u0010*\bB)\b\u0007\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\f\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014R\u001a\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0018\u0010\u001e\u001a\u00060\u001bR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006+"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar;", "Landroid/widget/RelativeLayout;", "", h.F, "f", "g", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$d;", "barHolder", "e", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$c;", "adapter", "setAdapter", "", "barStyle", "setBottomBarStyle", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "navigationBarContainer", "Landroid/view/View;", "Landroid/view/View;", "viewLine", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$c;", "barAdapter", "", "Ljava/util/List;", "navigationBarHolderList", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$e;", "i", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$e;", "observer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "c", "Companion", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSNavigationBar extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout navigationBarContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View viewLine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private c<?> barAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<d> navigationBarHolderList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final e observer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$a;", "Landroid/database/Observable;", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$b;", "", "a", "", "position", "b", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a extends Observable<b> {
        public final void a() {
            Iterator it = ((Observable) this).mObservers.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a();
            }
        }

        public final void b(int position) {
            Iterator it = ((Observable) this).mObservers.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(position);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H&J\u001f\u0010\t\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u001d\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\nJ\u001d\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u000fJ\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0006\u0010\u0017\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$c;", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$d;", "VH", "", "", h.F, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "barType", "l", "(Landroid/view/ViewGroup;I)Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$d;", "barHolder", "position", "", "k", "(Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$d;I)V", "i", "f", "e", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$b;", "observer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "g", "j", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$a;", "d", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$a;", "mObservable", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static abstract class c<VH extends d> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final a mObservable = new a();

        public final void e(VH barHolder, int position) {
            Intrinsics.checkNotNullParameter(barHolder, "barHolder");
            barHolder.h(position);
            k(barHolder, position);
        }

        public final VH f(ViewGroup parent, int barType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            VH l3 = l(parent, barType);
            l3.g(barType);
            return l3;
        }

        public final void g() {
            this.mObservable.a();
        }

        public abstract int h();

        public int i(int position) {
            return 0;
        }

        public final void j(int position) {
            this.mObservable.b(position);
        }

        public abstract void k(VH barHolder, int position);

        public abstract VH l(ViewGroup parent, int barType);

        public void m(b observer) {
            this.mObservable.registerObserver(observer);
        }

        public void n() {
            this.mObservable.unregisterAll();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$e;", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$b;", "", "a", "", "position", "b", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public final class e extends b {
        public e() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.nav.WSNavigationBar.b
        public void a() {
            WSNavigationBar.this.navigationBarContainer.removeAllViews();
            WSNavigationBar.this.navigationBarHolderList.clear();
            c cVar = WSNavigationBar.this.barAdapter;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barAdapter");
                cVar = null;
            }
            WSNavigationBar wSNavigationBar = WSNavigationBar.this;
            int h16 = cVar.h();
            for (int i3 = 0; i3 < h16; i3++) {
                d f16 = cVar.f(wSNavigationBar, cVar.i(i3));
                cVar.e(f16, i3);
                wSNavigationBar.e(f16);
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.nav.WSNavigationBar.b
        public void b(int position) {
            d dVar = (d) WSNavigationBar.this.navigationBarHolderList.get(position);
            c cVar = WSNavigationBar.this.barAdapter;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barAdapter");
                cVar = null;
            }
            cVar.e(dVar, position);
        }
    }

    public WSNavigationBar(Context context) {
        this(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(d barHolder) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 16;
        this.navigationBarContainer.setOrientation(0);
        this.navigationBarContainer.addView(barHolder.getBarView(), layoutParams);
        this.navigationBarHolderList.add(barHolder);
    }

    private final void f() {
        this.navigationBarContainer.setBackgroundColor(Color.parseColor("#000000"));
        this.viewLine.setVisibility(8);
    }

    private final void g() {
        this.navigationBarContainer.setBackgroundColor(0);
        this.viewLine.setVisibility(8);
    }

    private final void h() {
        this.navigationBarContainer.setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.viewLine.setVisibility(0);
    }

    public final void setAdapter(c<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.barAdapter = adapter;
        c<?> cVar = null;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barAdapter");
            adapter = null;
        }
        adapter.n();
        c<?> cVar2 = this.barAdapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barAdapter");
        } else {
            cVar = cVar2;
        }
        cVar.m(this.observer);
    }

    public WSNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ WSNavigationBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public WSNavigationBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.navigationBarHolderList = new ArrayList();
        this.observer = new e();
        View.inflate(context, R.layout.d0_, this);
        View findViewById = findViewById(R.id.p4w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ll_bottom_item_view_container)");
        this.navigationBarContainer = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.p8u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.view_line)");
        this.viewLine = findViewById2;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\rJ%\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$d;", "", "Landroid/view/View;", "T", "", "id", "e", "(I)Landroid/view/View;", "d", "Landroid/view/View;", "f", "()Landroid/view/View;", "setBarView", "(Landroid/view/View;)V", "barView", "I", "getBarType", "()I", "g", "(I)V", "barType", "getPosition", h.F, "position", "<init>", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static abstract class d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private View barView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int barType;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int position;

        public d(View barView) {
            Intrinsics.checkNotNullParameter(barView, "barView");
            this.barView = barView;
            this.position = -1;
        }

        /* renamed from: f, reason: from getter */
        public final View getBarView() {
            return this.barView;
        }

        public final void g(int i3) {
            this.barType = i3;
        }

        public final void h(int i3) {
            this.position = i3;
        }

        public final <T extends View> T e(int id5) {
            if (id5 == -1) {
                return null;
            }
            return (T) this.barView.findViewById(id5);
        }
    }

    public final void setBottomBarStyle(int barStyle) {
        if (barStyle == 1) {
            h();
        } else if (barStyle == 2) {
            f();
        } else {
            if (barStyle != 3) {
                return;
            }
            g();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$b;", "", "", "a", "", "position", "b", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static abstract class b {
        public void a() {
        }

        public void b(int position) {
        }
    }
}
