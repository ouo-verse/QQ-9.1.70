package com.tencent.mobileqq.wink.editor.menu;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004\u001a\u0006\u0010\t\u001a\u00020\u0004\u001a\u0006\u0010\n\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"", "Lcom/tencent/mobileqq/wink/editor/menu/MenuItem;", "menuItems", "e", "", "b", "stateOn", "", "a", "c", "d", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class v {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f320581d;

        public a(List list) {
            this.f320581d = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            boolean z16;
            int i3;
            int compareValues;
            Integer valueOf = Integer.valueOf(this.f320581d.indexOf((MenuItem) t16));
            boolean z17 = true;
            if (valueOf.intValue() != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            Integer num = null;
            if (!z16) {
                valueOf = null;
            }
            int i16 = Integer.MAX_VALUE;
            if (valueOf != null) {
                i3 = valueOf.intValue();
            } else {
                i3 = Integer.MAX_VALUE;
            }
            Integer valueOf2 = Integer.valueOf(i3);
            Integer valueOf3 = Integer.valueOf(this.f320581d.indexOf((MenuItem) t17));
            if (valueOf3.intValue() == -1) {
                z17 = false;
            }
            if (z17) {
                num = valueOf3;
            }
            if (num != null) {
                i16 = num.intValue();
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf2, Integer.valueOf(i16));
            return compareValues;
        }
    }

    public static final int a(boolean z16) {
        if (b()) {
            if (z16) {
                return R.drawable.m4g;
            }
            return R.drawable.m4e;
        }
        if (z16) {
            return R.drawable.m4f;
        }
        return R.drawable.m4d;
    }

    public static final boolean b() {
        if (((!((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_fabuqi_bianjiyegongnengchongxinpaixu", "exp_xsj_fabuqi_bianjiyegongnengchongxinpaixu_B") && !((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_fabuqi_bianjiyegongnengchongxinpaixu", "exp_xsj_fabuqi_bianjiyegongnengchongxinpaixu_C")) || !Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QCIRCLE")) && !r93.h.f430993a.g()) {
            return false;
        }
        return true;
    }

    public static final boolean c() {
        if ((((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_fabuqi_bianjiyegongnengchongxinpaixu", "exp_xsj_fabuqi_bianjiyegongnengchongxinpaixu_B") || ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_fabuqi_bianjiyegongnengchongxinpaixu", "exp_xsj_fabuqi_bianjiyegongnengchongxinpaixu_C")) && Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QCIRCLE")) {
            return true;
        }
        return false;
    }

    public static final boolean d() {
        if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_fabuqi_bianjiyegongnengchongxinpaixu", "exp_xsj_fabuqi_bianjiyegongnengchongxinpaixu_B") && Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QCIRCLE")) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final List<MenuItem> e(@NotNull List<? extends MenuItem> menuItems) {
        List listOf;
        List<MenuItem> sortedWith;
        boolean z16;
        Intrinsics.checkNotNullParameter(menuItems, "menuItems");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MenuItem[]{MenuItem.CLIPPING, MenuItem.TEMPLATE_CLIP, MenuItem.TEMPLATE_TEXT, MenuItem.ADD_TEXT, MenuItem.TEXT, MenuItem.STICKER, MenuItem.STICKER_OLD, MenuItem.FILTER, MenuItem.VIDEO_TEMPLATE, MenuItem.ENHANCE, MenuItem.EFFECT, MenuItem.CROP, MenuItem.TO_IMAGE, MenuItem.SUBTITLE, MenuItem.TO_VIDEO, MenuItem.MOSAIC});
        ArrayList arrayList = new ArrayList();
        for (Object obj : menuItems) {
            if (((MenuItem) obj) == MenuItem.OPENING_ENDING) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                arrayList.add(obj);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new a(listOf));
        return sortedWith;
    }
}
