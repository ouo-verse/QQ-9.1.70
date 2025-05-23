package com.tencent.mobileqq.vas.vipicon.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.vipicon.VipIcon;
import com.tencent.mobileqq.vas.vipicon.k;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "", "it", "Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable;", "invoke", "(Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable;)[Ljava/lang/String;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
final class VipIconExFactoryImpl$getIconFromNamePlateData$1 extends Lambda implements Function1<VipIcon, String[]> {
    final /* synthetic */ VASPersonalNamePlate $data;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipIconExFactoryImpl$getIconFromNamePlateData$1(VASPersonalNamePlate vASPersonalNamePlate) {
        super(1);
        this.$data = vASPersonalNamePlate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VipIcon it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        AbsAsyncDrawable.load$default(it, false, 1, null);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final String[] invoke(@NotNull final VipIcon it) {
        Intrinsics.checkNotNullParameter(it, "it");
        k kVar = (k) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(k.class);
        Integer num = this.$data.extendNamePlateId;
        Intrinsics.checkNotNullExpressionValue(num, "data.extendNamePlateId");
        if (!kVar.isFileExists(num.intValue())) {
            Integer num2 = this.$data.extendNamePlateId;
            Intrinsics.checkNotNullExpressionValue(num2, "data.extendNamePlateId");
            kVar.addDownLoadListener(num2.intValue(), new Runnable() { // from class: com.tencent.mobileqq.vas.vipicon.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    VipIconExFactoryImpl$getIconFromNamePlateData$1.b(VipIcon.this);
                }
            });
            Integer num3 = this.$data.extendNamePlateId;
            Intrinsics.checkNotNullExpressionValue(num3, "data.extendNamePlateId");
            kVar.startDownload(num3.intValue());
        }
        Integer num4 = this.$data.extendNamePlateId;
        Intrinsics.checkNotNullExpressionValue(num4, "data.extendNamePlateId");
        String e16 = kVar.e(num4.intValue());
        Intrinsics.checkNotNullExpressionValue(e16, "business.getIconPath(data.extendNamePlateId)");
        return new String[]{e16};
    }
}
