package com.tencent.mobileqq.vas.vipicon.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.vipicon.VipIcon;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "", "it", "Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable;", "invoke", "(Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable;)[Ljava/lang/String;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
final class VipIconFactoryImpl$getIcoinFromNamePlateData$4 extends Lambda implements Function1<VipIcon, String[]> {
    final /* synthetic */ VASPersonalNamePlate $data;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipIconFactoryImpl$getIcoinFromNamePlateData$4(VASPersonalNamePlate vASPersonalNamePlate) {
        super(1);
        this.$data = vASPersonalNamePlate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VipIcon it, Function0 getUrls) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(getUrls, "$getUrls");
        it.M((String[]) getUrls.invoke());
        AbsAsyncDrawable.load$default(it, false, 1, null);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final String[] invoke(@NotNull final VipIcon it) {
        Intrinsics.checkNotNullParameter(it, "it");
        final com.tencent.mobileqq.vas.vipicon.g gVar = (com.tencent.mobileqq.vas.vipicon.g) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.vipicon.g.class);
        final VASPersonalNamePlate vASPersonalNamePlate = this.$data;
        final Function0<String[]> function0 = new Function0<String[]>() { // from class: com.tencent.mobileqq.vas.vipicon.api.impl.VipIconFactoryImpl$getIcoinFromNamePlateData$4$getUrls$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String[] invoke() {
                com.tencent.mobileqq.vas.vipicon.g gVar2 = com.tencent.mobileqq.vas.vipicon.g.this;
                long intValue = vASPersonalNamePlate.namePlateId.intValue();
                Integer num = vASPersonalNamePlate.vipType;
                Intrinsics.checkNotNullExpressionValue(num, "data.vipType");
                int intValue2 = num.intValue();
                Integer num2 = vASPersonalNamePlate.vipLevel;
                Intrinsics.checkNotNullExpressionValue(num2, "data.vipLevel");
                return new String[]{gVar2.h(intValue, intValue2, num2.intValue(), false)};
            }
        };
        Integer num = this.$data.namePlateId;
        Intrinsics.checkNotNullExpressionValue(num, "data.namePlateId");
        if (!gVar.isFileExists(num.intValue())) {
            Integer num2 = this.$data.namePlateId;
            Intrinsics.checkNotNullExpressionValue(num2, "data.namePlateId");
            gVar.addDownLoadListener(num2.intValue(), new Runnable() { // from class: com.tencent.mobileqq.vas.vipicon.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    VipIconFactoryImpl$getIcoinFromNamePlateData$4.b(VipIcon.this, function0);
                }
            });
            Integer num3 = this.$data.namePlateId;
            Intrinsics.checkNotNullExpressionValue(num3, "data.namePlateId");
            gVar.startDownload(num3.intValue());
        }
        return function0.invoke();
    }
}
