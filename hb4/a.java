package hb4;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.view.widget.ZootopiaDoubleClickLayout;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressDetailVideoChildView;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pu4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J\u0016\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\b\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001e\u00a8\u0006\""}, d2 = {"Lhb4/a;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/view/View;", "view", "", "position", "", "f", "", "Lpu4/g;", "data", "g", "getCount", "", "object", "", "isViewFromObject", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "instantiateItem", "destroyItem", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressDetailVideoChildView$b;", "d", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressDetailVideoChildView$b;", "e", "()Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressDetailVideoChildView$b;", "listener", "", "Ljava/lang/String;", "TAG", "Ljava/util/List;", "dataList", "<init>", "(Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressDetailVideoChildView$b;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final DressDetailVideoChildView.b listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<g> dataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"hb4/a$a", "Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaDoubleClickLayout$b;", "Landroid/view/MotionEvent;", "event", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hb4.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10429a implements ZootopiaDoubleClickLayout.b {
        C10429a() {
        }

        @Override // com.tencent.sqshow.zootopia.card.view.widget.ZootopiaDoubleClickLayout.b
        public void a(MotionEvent event) {
            QLog.d(a.this.TAG, 1, "onDoubleTap, event: " + event);
            a.this.getListener().onDoubleTap(event);
        }
    }

    public a(DressDetailVideoChildView.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.TAG = "DressSquareDetailViewPageAdapter";
    }

    private final void f(View view, int position) {
        Object orNull;
        List<g> list = this.dataList;
        if (list != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, position);
            g gVar = (g) orNull;
            if (gVar == null) {
                return;
            }
            ((ZPlanMediaView) view.findViewById(R.id.f163464q92)).e(gVar);
            ((ZootopiaDoubleClickLayout) view.findViewById(R.id.qcd)).setOnDoubleClickListener(new C10429a());
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        View view = object instanceof View ? (View) object : null;
        if (view != null) {
            container.removeView(view);
        }
    }

    /* renamed from: e, reason: from getter */
    public final DressDetailVideoChildView.b getListener() {
        return this.listener;
    }

    public final void g(List<g> data) {
        this.dataList = data;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        List<g> list = this.dataList;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        List<g> list2 = this.dataList;
        Intrinsics.checkNotNull(list2);
        return list2.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        QLog.d(this.TAG, 1, "instantiateItem, position:" + position);
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.dbm, container, false);
        container.addView(view, new ViewGroup.LayoutParams(-1, -1));
        Intrinsics.checkNotNullExpressionValue(view, "view");
        f(view, position);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual(view, object);
    }
}
