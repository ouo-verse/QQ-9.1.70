package c94;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.page.a;
import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002*\u0014\b\u0002\u0010\u0005*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u0006B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\b\u001a\u00020\u0007H&J\u0017\u0010\n\u001a\u00028\u00022\u0006\u0010\t\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u000f\u0010\u0013\u001a\u0004\u0018\u00018\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u0004\u0018\u00018\u00022\b\u0010\t\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J \u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0006\u0010&\u001a\u00020\u000eR*\u0010,\u001a\u0012\u0012\u0004\u0012\u00028\u00010'j\b\u0012\u0004\u0012\u00028\u0001`(8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b*\u0010+R6\u00102\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020-j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002`.8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010/\u001a\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00018\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00103R\u0018\u00106\u001a\u0004\u0018\u00018\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00105\u00a8\u00069"}, d2 = {"Lc94/a;", "T", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "D", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/a;", "P", "Landroidx/viewpager/widget/PagerAdapter;", "", "l", "data", "d", "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;)Lcom/tencent/sqshow/zootopia/nativeui/view/page/a;", "", "dataList", "", "k", "e", "i", h.F, "g", "()Lcom/tencent/sqshow/zootopia/nativeui/view/page/a;", "j", "f", "()Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "", "getCount", "", "object", "getItemPosition", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "position", "instantiateItem", "destroyItem", "Landroid/view/View;", "view", "", "isViewFromObject", "destroy", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getMDataList", "()Ljava/util/ArrayList;", "mDataList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getMPagePool", "()Ljava/util/HashMap;", "mPagePool", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "mCurrentSelectedData", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/a;", "mSelectedPage", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public abstract class a<T, D extends BaseZPlanTabTitleData<T>, P extends com.tencent.sqshow.zootopia.nativeui.view.page.a<T, D>> extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<D> mDataList = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final HashMap<T, P> mPagePool = new HashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private D mCurrentSelectedData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private P mSelectedPage;

    public abstract P d(D data);

    public final void destroy() {
        e();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        QLog.i(l(), 1, "destroyItem position:" + position);
        D d16 = this.mDataList.get(position);
        Intrinsics.checkNotNullExpressionValue(d16, "mDataList[position]");
        D d17 = d16;
        P p16 = this.mPagePool.get(d17.getId());
        if (p16 != null && Intrinsics.areEqual(p16, object)) {
            QLog.i(l(), 1, "destroyItem position:" + position + " cachePage:" + p16);
        } else {
            QLog.w(l(), 1, "destroyItem position:" + position + " no cache page!");
        }
        Object id5 = d17.getId();
        D d18 = this.mCurrentSelectedData;
        if (Intrinsics.areEqual(id5, d18 != null ? d18.getId() : null)) {
            this.mSelectedPage = p16;
            if (p16 != null) {
                p16.c();
            }
        } else if (p16 != null) {
            p16.f();
        }
        com.tencent.sqshow.zootopia.nativeui.view.page.a aVar = object instanceof com.tencent.sqshow.zootopia.nativeui.view.page.a ? (com.tencent.sqshow.zootopia.nativeui.view.page.a) object : null;
        container.removeView(aVar != null ? aVar.getView() : null);
    }

    public final void e() {
        Iterator<Map.Entry<T, P>> it = this.mPagePool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().h();
        }
        this.mPagePool.clear();
    }

    public final D f() {
        return this.mCurrentSelectedData;
    }

    public final P g() {
        return this.mSelectedPage;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.mDataList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object object) {
        Intrinsics.checkNotNullParameter(object, "object");
        com.tencent.sqshow.zootopia.nativeui.view.page.a aVar = object instanceof com.tencent.sqshow.zootopia.nativeui.view.page.a ? (com.tencent.sqshow.zootopia.nativeui.view.page.a) object : null;
        if (aVar == null) {
            return super.getItemPosition(object);
        }
        BaseZPlanTabTitleData baseZPlanTabTitleData = (BaseZPlanTabTitleData) aVar.getData();
        D d16 = this.mDataList.get(aVar.getPosition());
        Intrinsics.checkNotNullExpressionValue(d16, "mDataList[position]");
        return Intrinsics.areEqual(d16, baseZPlanTabTitleData) ? -1 : -2;
    }

    public final void h() {
        P p16 = this.mSelectedPage;
        if (p16 != null) {
            p16.d();
        }
    }

    public final void i() {
        P p16 = this.mSelectedPage;
        if (p16 != null) {
            p16.a();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        D d16 = this.mDataList.get(position);
        Intrinsics.checkNotNullExpressionValue(d16, "mDataList[position]");
        D d17 = d16;
        QLog.i(l(), 1, "instantiateItem position:" + position + ", pageId:" + d17.getId());
        P p16 = this.mPagePool.get(d17.getId());
        if (p16 == null) {
            p16 = d(d17);
            p16.g();
        }
        Intrinsics.checkNotNullExpressionValue(p16, "mPagePool[data.id] ?: bu\u2026a).apply { pageCreate() }");
        p16.setData(d17);
        p16.setPosition(position);
        this.mPagePool.put(d17.getId(), p16);
        container.addView(p16.getView());
        Object id5 = d17.getId();
        D d18 = this.mCurrentSelectedData;
        if (Intrinsics.areEqual(id5, d18 != null ? d18.getId() : null)) {
            this.mSelectedPage = p16;
            p16.c();
        } else {
            p16.f();
        }
        return p16;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        if (!(object instanceof View)) {
            boolean z16 = object instanceof com.tencent.sqshow.zootopia.nativeui.view.page.a;
            if ((z16 ? (com.tencent.sqshow.zootopia.nativeui.view.page.a) object : null) != null) {
                com.tencent.sqshow.zootopia.nativeui.view.page.a aVar = z16 ? (com.tencent.sqshow.zootopia.nativeui.view.page.a) object : null;
                if (view == (aVar != null ? aVar.getView() : null)) {
                    return true;
                }
            } else if (view == object) {
                return true;
            }
        } else if (view == object) {
            return true;
        }
        return false;
    }

    public final P j(D data) {
        if (!Intrinsics.areEqual(this.mCurrentSelectedData, data)) {
            QLog.i(l(), 1, "onPageSelected data changed. new data: " + data);
        }
        this.mCurrentSelectedData = data;
        this.mSelectedPage = null;
        Set<Map.Entry<T, P>> entrySet = this.mPagePool.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "mPagePool.entries");
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (Intrinsics.areEqual(entry.getKey(), data != null ? data.getId() : null)) {
                this.mSelectedPage = (P) entry.getValue();
                ((com.tencent.sqshow.zootopia.nativeui.view.page.a) entry.getValue()).c();
            } else {
                ((com.tencent.sqshow.zootopia.nativeui.view.page.a) entry.getValue()).f();
            }
        }
        return this.mSelectedPage;
    }

    public final void k(List<? extends D> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.mDataList.clear();
        this.mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public abstract String l();
}
