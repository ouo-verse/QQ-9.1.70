package com.tencent.mobileqq.vas.vipicon.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.vipicon.VipIcon;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "", "drawable", "Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable;", "invoke", "(Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable;)[Ljava/lang/String;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
final class VipIconFactoryImpl$getIcoinFromNamePlateData$3 extends Lambda implements Function1<VipIcon, String[]> {
    final /* synthetic */ VASPersonalNamePlate $data;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipIconFactoryImpl$getIcoinFromNamePlateData$3(VASPersonalNamePlate vASPersonalNamePlate) {
        super(1);
        this.$data = vASPersonalNamePlate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VipIcon drawable, Function0 getUrls) {
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        Intrinsics.checkNotNullParameter(getUrls, "$getUrls");
        drawable.M((String[]) getUrls.invoke());
        AbsAsyncDrawable.load$default(drawable, false, 1, null);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final String[] invoke(@NotNull final VipIcon drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        final com.tencent.mobileqq.vas.vipicon.g gVar = (com.tencent.mobileqq.vas.vipicon.g) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.vipicon.g.class);
        final VASPersonalNamePlate vASPersonalNamePlate = this.$data;
        final Function0<String[]> function0 = new Function0<String[]>() { // from class: com.tencent.mobileqq.vas.vipicon.api.impl.VipIconFactoryImpl$getIcoinFromNamePlateData$3$getUrls$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String[] invoke() {
                int size = VASPersonalNamePlate.this.carouselNamePlateIds.size();
                String[] strArr = new String[size];
                for (int i3 = 0; i3 < size; i3++) {
                    com.tencent.mobileqq.vas.vipicon.g gVar2 = gVar;
                    long intValue = VASPersonalNamePlate.this.carouselNamePlateIds.get(i3).intValue();
                    Integer num = VASPersonalNamePlate.this.vipType;
                    Intrinsics.checkNotNullExpressionValue(num, "data.vipType");
                    int intValue2 = num.intValue();
                    Integer num2 = VASPersonalNamePlate.this.vipLevel;
                    Intrinsics.checkNotNullExpressionValue(num2, "data.vipLevel");
                    strArr[i3] = gVar2.h(intValue, intValue2, num2.intValue(), false);
                }
                return strArr;
            }
        };
        String[] invoke = function0.invoke();
        ArrayList<Integer> arrayList = this.$data.carouselNamePlateIds;
        Intrinsics.checkNotNullExpressionValue(arrayList, "data.carouselNamePlateIds");
        for (Integer it : arrayList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (!gVar.isFileExists(it.intValue())) {
                gVar.addDownLoadListener(it.intValue(), new Runnable() { // from class: com.tencent.mobileqq.vas.vipicon.api.impl.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        VipIconFactoryImpl$getIcoinFromNamePlateData$3.b(VipIcon.this, function0);
                    }
                });
                gVar.startDownload(it.intValue());
            }
        }
        return invoke;
    }
}
