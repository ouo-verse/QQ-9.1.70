package mz1;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u0000 \b2\u00020\u0001:\u0001\u001bB\u0011\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0014\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u001c\u0010\u001a\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018J\u001c\u0010\u001b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J$\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010!\u001a\u0004\b\"\u0010#R(\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b*\u0010&R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b,\u0010$\u001a\u0004\b,\u0010&R\"\u00103\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lmz1/b;", "", "", "c", "", "isEditStatus", "", "Lmz1/c;", "f", "Lmz1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "categories", "k", "e", "o", "curItem", "targetItem", "j", "Lkotlin/Function0;", "successFun", DomainData.DOMAIN_NAME, "a", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "from", "to", "l", "Z", "isEnableShowNavBar", "()Z", "Ljava/util/List;", "g", "()Ljava/util/List;", "setModelShowList", "(Ljava/util/List;)V", "modelShowList", tl.h.F, "previewList", "d", "additionList", "I", "getMaxNumberOfNavigationItem", "()I", "p", "(I)V", "maxNumberOfNavigationItem", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, Integer> f417882g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isEnableShowNavBar;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<c> modelShowList = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c> previewList = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c> additionList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int maxNumberOfNavigationItem = 14;

    static {
        Map<Integer, Integer> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(2, 6), TuplesKt.to(9, 5), TuplesKt.to(3, 4), TuplesKt.to(7, 3), TuplesKt.to(10, 2), TuplesKt.to(11, 1));
        f417882g = mapOf;
    }

    public b(boolean z16) {
        this.isEnableShowNavBar = z16;
    }

    private final void b(AdditionAppItem item) {
        int i3;
        int i16;
        int i17;
        int size = this.additionList.size();
        while (true) {
            size--;
            i3 = 0;
            if (size < 0) {
                break;
            }
            c cVar = this.additionList.get(size);
            if (cVar instanceof AdditionAppItem) {
                Map<Integer, Integer> map = f417882g;
                Integer num = map.get(Integer.valueOf(((AdditionAppItem) cVar).getJumpType()));
                if (num != null) {
                    i16 = num.intValue();
                } else {
                    i16 = 0;
                }
                Integer num2 = map.get(Integer.valueOf(item.getJumpType()));
                if (num2 != null) {
                    i17 = num2.intValue();
                } else {
                    i17 = 0;
                }
                if (i16 >= i17) {
                    size++;
                    break;
                }
            }
        }
        if (size > -1) {
            i3 = size;
        }
        this.additionList.add(i3, item);
    }

    private final void c() {
        this.previewList.clear();
        this.additionList.clear();
    }

    private final List<c> f(boolean isEditStatus) {
        int i3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z16 = true;
        if (!this.previewList.isEmpty()) {
            arrayList.addAll(this.previewList);
            if (this.previewList.size() <= 3) {
                i3 = 74;
            } else {
                i3 = 30;
            }
            arrayList2.add(new e(i(isEditStatus), i3));
        } else {
            arrayList.add(new g());
        }
        arrayList2.add(new ListTitleItem("\u53ef\u6dfb\u52a0\u7684\u5e94\u7528"));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        arrayList3.addAll(this.additionList);
        if (this.isEnableShowNavBar) {
            ArrayList arrayList4 = new ArrayList();
            Iterator it = arrayList3.iterator();
            while (true) {
                boolean z17 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                c cVar = (c) next;
                if ((cVar instanceof AdditionAppItem) && ((AdditionAppItem) cVar).getJumpType() == 11) {
                    z17 = true;
                }
                if (z17) {
                    arrayList4.add(next);
                }
            }
            if (arrayList4.size() < this.maxNumberOfNavigationItem) {
                z16 = false;
            }
            arrayList3.add(new d(z16));
        } else if (this.additionList.isEmpty()) {
            arrayList3.add(new f());
        }
        o(isEditStatus);
        return arrayList3;
    }

    private final String i(boolean isEditStatus) {
        if (isEditStatus) {
            if (this.previewList.size() == 1) {
                return "\u70b9\u51fb\u4ee5\u4e0b\u5e94\u7528\u5373\u53ef\u6dfb\u52a0";
            }
            return "\u957f\u6309\u62d6\u62fd\u53ef\u8c03\u6574\u6392\u5e8f";
        }
        return "\u4ee5\u4e0a\u4e3a\u300c\u4e3b\u9875\u300d\u5e94\u7528";
    }

    private final void m() {
        boolean z16;
        List<c> list = this.modelShowList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            c cVar = (c) obj;
            if ((cVar instanceof AdditionAppItem) && this.previewList.contains(cVar)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        this.previewList.clear();
        this.previewList.addAll(arrayList);
    }

    public final void a(@NotNull AdditionAppItem item, @NotNull Function0<Unit> successFun) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(successFun, "successFun");
        if (this.additionList.remove(item)) {
            this.previewList.add(item);
            this.modelShowList.clear();
            this.modelShowList.addAll(f(true));
            q(true);
            successFun.invoke();
        }
    }

    @NotNull
    public final List<c> d() {
        return this.additionList;
    }

    @NotNull
    public final List<c> e(boolean isEditStatus) {
        List<c> f16 = f(isEditStatus);
        this.modelShowList = f16;
        return f16;
    }

    @NotNull
    public final List<c> g() {
        return this.modelShowList;
    }

    @NotNull
    public final List<c> h() {
        return this.previewList;
    }

    public final boolean j(@NotNull c curItem, @NotNull c targetItem) {
        Intrinsics.checkNotNullParameter(curItem, "curItem");
        Intrinsics.checkNotNullParameter(targetItem, "targetItem");
        if ((curItem instanceof AdditionAppItem) && (targetItem instanceof AdditionAppItem) && ((AdditionAppItem) curItem).getIsCanDragEdit() && ((AdditionAppItem) targetItem).getIsCanDragEdit()) {
            return true;
        }
        return false;
    }

    public final void k(@NotNull ArrayList<IGProCategoryChannelInfoList> categories) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        c();
        for (IGProCategoryChannelInfoList iGProCategoryChannelInfoList : categories) {
            ArrayList<AdditionAppItem> a16 = AdditionAppItem.INSTANCE.a(iGProCategoryChannelInfoList);
            if (iGProCategoryChannelInfoList.getCloseSwitch()) {
                this.additionList.addAll(a16);
            } else {
                this.previewList.addAll(a16);
            }
        }
    }

    public final void l(int from, int to5, @NotNull Function0<Unit> successFun) {
        Intrinsics.checkNotNullParameter(successFun, "successFun");
        if (from != -1 && to5 != -1 && from != to5) {
            this.modelShowList.add(to5, this.modelShowList.remove(from));
            m();
            successFun.invoke();
        }
    }

    public final void n(@NotNull AdditionAppItem item, @NotNull Function0<Unit> successFun) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(successFun, "successFun");
        if (this.previewList.remove(item)) {
            b(item);
            this.modelShowList.clear();
            this.modelShowList.addAll(f(true));
            q(true);
            successFun.invoke();
        }
    }

    public final void o(boolean isEditStatus) {
        int i3;
        int i16;
        List<c> list = this.previewList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((c) obj) instanceof AdditionAppItem) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (size != 1) {
            i3 = 2;
            if (size != 2) {
                if (isEditStatus) {
                    i3 = 3;
                } else {
                    i3 = 1;
                }
            }
        } else {
            i3 = 0;
        }
        for (c cVar : this.previewList) {
            if (cVar instanceof AdditionAppItem) {
                AdditionAppItem additionAppItem = (AdditionAppItem) cVar;
                additionAppItem.s(i3);
                additionAppItem.r(1);
                additionAppItem.q(isEditStatus);
            }
        }
        for (c cVar2 : this.additionList) {
            if (cVar2 instanceof AdditionAppItem) {
                AdditionAppItem additionAppItem2 = (AdditionAppItem) cVar2;
                if (isEditStatus) {
                    i16 = 3;
                } else {
                    i16 = 1;
                }
                additionAppItem2.s(i16);
                additionAppItem2.r(0);
                additionAppItem2.q(false);
            }
        }
    }

    public final void p(int i3) {
        this.maxNumberOfNavigationItem = i3;
    }

    public final void q(boolean isEditStatus) {
        List<c> list = this.modelShowList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof e) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((e) it.next()).f(i(isEditStatus));
        }
    }
}
