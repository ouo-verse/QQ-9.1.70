package com.tencent.mobileqq.nearbypro.land;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.view.AreaMarkInfoComponent;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/k;", "Lcom/tencent/mobileqq/nearbypro/land/i;", "", "count", "", "F9", "", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "update", "Lxa2/a;", "f", "Lxa2/a;", "binding", "<init>", "()V", tl.h.F, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class k extends i {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final int f253391i;

    /* renamed from: m, reason: collision with root package name */
    private static final int f253392m;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private xa2.a binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/k$a;", "", "", "MAX_WIDTH", "I", "a", "()I", "MAX_SHOWN_COUNT", "MIN_SPACING_PX", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.land.k$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return k.f253392m;
        }

        Companion() {
        }
    }

    static {
        int b16 = com.tencent.mobileqq.nearbypro.utils.d.b(40);
        f253391i = b16;
        f253392m = ((int) d.INSTANCE.a()) - b16;
    }

    public k() {
        super(R.id.sv6);
    }

    private final int[] E9() {
        boolean startsWith$default;
        String replace$default;
        try {
            int[] iArr = new int[0];
            String[] strArr = x9().getAreaInfo().f429201e.f429211b;
            Intrinsics.checkNotNullExpressionValue(strArr, "areaParam.areaInfo.summaryInfo.areaColors");
            int length = strArr.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                String color = strArr[i3];
                int i17 = i16 + 1;
                ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
                if (c16.isColorLevel()) {
                    c16.e("SummaryInfoComponent", "getBrandColors colorInt=" + color);
                }
                Intrinsics.checkNotNullExpressionValue(color, "color");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(color, "#", false, 2, null);
                if (!startsWith$default) {
                    replace$default = StringsKt__StringsJVMKt.replace$default(color, RelationNTPushServiceImpl.PRE_HEX_STRING, "#", false, 4, (Object) null);
                    iArr[i16] = Color.parseColor(replace$default);
                } else {
                    iArr[i16] = Color.parseColor(color);
                }
                i3++;
                i16 = i17;
            }
            return iArr;
        } catch (Exception e16) {
            com.tencent.mobileqq.nearbypro.base.j.c().d("SummaryInfoComponent", "getBrandColors error=" + e16);
            return new int[0];
        }
    }

    private final void F9(int count) {
        String valueOf;
        if (count > 99) {
            valueOf = "99+";
        } else {
            valueOf = String.valueOf(count);
        }
        xa2.a aVar = this.binding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.getRoot().setUserCount(valueOf);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        Integer num;
        int i3;
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual("msg_update_user_count_event", action)) {
            if (args instanceof Integer) {
                num = (Integer) args;
            } else {
                num = null;
            }
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            F9(i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        super.onInitView(rootView);
        xa2.a aVar = null;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.sv6);
        } else {
            viewGroup = null;
        }
        xa2.a g16 = xa2.a.g(LayoutInflater.from(getContext()), viewGroup, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026ontext), container, true)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        g16.getRoot().setBrandMaxWidth(f253392m);
        xa2.a aVar2 = this.binding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar2 = null;
        }
        AreaMarkInfoComponent root = aVar2.getRoot();
        String str = x9().getAreaInfo().f429201e.f429210a;
        Intrinsics.checkNotNullExpressionValue(str, "areaParam.areaInfo.summaryInfo.areaName");
        root.setAreaName(str);
        xa2.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar = aVar3;
        }
        aVar.getRoot().setBrandBg(E9());
        F9(0);
    }

    @Override // com.tencent.mobileqq.nearbypro.land.i
    public void update() {
        super.update();
        xa2.a aVar = this.binding;
        xa2.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        AreaMarkInfoComponent root = aVar.getRoot();
        String str = x9().getAreaInfo().f429201e.f429210a;
        Intrinsics.checkNotNullExpressionValue(str, "areaParam.areaInfo.summaryInfo.areaName");
        root.setAreaName(str);
        xa2.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar3;
        }
        aVar2.getRoot().setBrandBg(E9());
    }
}
