package com.tencent.biz.pubaccount.weishi.home;

import android.view.ViewGroup;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.weishi.view.nav.WSNavigationBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import vy.WSNavigationBarInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0019 B\u0011\u0012\b\u0010)\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b?\u0010@J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\b\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0002J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016J(\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J(\u0010 \u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010!R\u0016\u0010)\u001a\u0004\u0018\u00010&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00020,j\b\u0012\u0004\u0012\u00020\u0002`-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010.R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010>\u001a\u0002082\u0006\u00109\u001a\u0002088\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/d;", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$c;", "Lcom/tencent/biz/pubaccount/weishi/home/WSTopBarHolder;", "Le00/a;", "", "Lvy/a;", "barInfoList", "", "w", "", WidgetCacheConstellationData.NUM, HippyTKDListViewAdapter.X, "o", h.F, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "barType", "u", "barHolder", "position", "t", ReportConstant.COSTREPORT_PREFIX, "index", "totalCount", "c", "a", "", "leavePercent", "", "leftToRight", "d", "enterPercent", "b", "", "r", "v", "id", "p", "Lcom/tencent/biz/pubaccount/weishi/home/a;", "e", "Lcom/tencent/biz/pubaccount/weishi/home/a;", "homePresenter", "f", "Ljava/util/List;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "barHolderList", "Lcom/tencent/biz/pubaccount/weishi/home/d$b;", "i", "Lcom/tencent/biz/pubaccount/weishi/home/d$b;", "getOnTabSelectedListener", "()Lcom/tencent/biz/pubaccount/weishi/home/d$b;", "y", "(Lcom/tencent/biz/pubaccount/weishi/home/d$b;)V", "onTabSelectedListener", "Le00/c;", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Le00/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Le00/c;", "scrollHelper", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/home/a;)V", BdhLogUtil.LogTag.Tag_Conn, "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d extends WSNavigationBar.c<WSTopBarHolder> implements e00.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final a homePresenter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<WSNavigationBarInfo> barInfoList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private b onTabSelectedListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<WSTopBarHolder> barHolderList = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private e00.c scrollHelper = new e00.c(this);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/d$b;", "", "Lvy/a;", "barInfo", "", "a", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface b {
        void a(WSNavigationBarInfo barInfo);

        void b(WSNavigationBarInfo barInfo);
    }

    public d(a aVar) {
        this.homePresenter = aVar;
    }

    @Override // e00.a
    public void a(int index, int totalCount) {
        this.barHolderList.get(index).a(index, totalCount);
    }

    @Override // e00.a
    public void b(int index, int totalCount, float enterPercent, boolean leftToRight) {
        this.barHolderList.get(index).b(index, totalCount, enterPercent, leftToRight);
    }

    @Override // e00.a
    public void c(int index, int totalCount) {
        List<WSNavigationBarInfo> list = this.barInfoList;
        List<WSNavigationBarInfo> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
            list = null;
        }
        String barId = list.get(index).getBarId();
        List<WSNavigationBarInfo> list3 = this.barInfoList;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
        } else {
            list2 = list3;
        }
        for (WSNavigationBarInfo wSNavigationBarInfo : list2) {
            if (wSNavigationBarInfo != null) {
                wSNavigationBarInfo.i(barId);
            }
        }
        this.barHolderList.get(index).c(index, totalCount);
    }

    @Override // e00.a
    public void d(int index, int totalCount, float leavePercent, boolean leftToRight) {
        this.barHolderList.get(index).d(index, totalCount, leavePercent, leftToRight);
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.nav.WSNavigationBar.c
    public int h() {
        List<WSNavigationBarInfo> list = this.barInfoList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
            list = null;
        }
        return list.size();
    }

    public final int o() {
        return this.barHolderList.get(0).m().getRedNum();
    }

    public final int p(String id5) {
        List<WSNavigationBarInfo> list = this.barInfoList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
            list = null;
        }
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((WSNavigationBarInfo) obj).getBarId(), id5)) {
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    /* renamed from: q, reason: from getter */
    public final e00.c getScrollHelper() {
        return this.scrollHelper;
    }

    public final String r() {
        String e16;
        a aVar = this.homePresenter;
        return (aVar == null || (e16 = aVar.e()) == null) ? "" : e16;
    }

    public final void s(WSTopBarHolder barHolder) {
        Intrinsics.checkNotNullParameter(barHolder, "barHolder");
        WSNavigationBarInfo m3 = barHolder.m();
        if (m3.f()) {
            b bVar = this.onTabSelectedListener;
            if (bVar != null) {
                bVar.b(m3);
                return;
            }
            return;
        }
        b bVar2 = this.onTabSelectedListener;
        if (bVar2 != null) {
            bVar2.a(m3);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.nav.WSNavigationBar.c
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void k(WSTopBarHolder barHolder, int position) {
        Intrinsics.checkNotNullParameter(barHolder, "barHolder");
        List<WSNavigationBarInfo> list = this.barInfoList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
            list = null;
        }
        barHolder.l(list.get(position), position);
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.nav.WSNavigationBar.c
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public WSTopBarHolder l(ViewGroup parent, int barType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        WSTopBarHolder wSTopBarHolder = new WSTopBarHolder(this, parent);
        this.barHolderList.add(wSTopBarHolder);
        return wSTopBarHolder;
    }

    public final void v() {
        Iterator<T> it = this.barHolderList.iterator();
        while (it.hasNext()) {
            ((WSTopBarHolder) it.next()).p();
        }
    }

    public final void w(List<WSNavigationBarInfo> barInfoList) {
        Intrinsics.checkNotNullParameter(barInfoList, "barInfoList");
        this.barInfoList = barInfoList;
        this.scrollHelper.e(false);
        this.scrollHelper.f(h());
        g();
    }

    public final void x(int num) {
        this.barHolderList.get(0).m().h(num);
        j(0);
    }

    public final void y(b bVar) {
        this.onTabSelectedListener = bVar;
    }
}
