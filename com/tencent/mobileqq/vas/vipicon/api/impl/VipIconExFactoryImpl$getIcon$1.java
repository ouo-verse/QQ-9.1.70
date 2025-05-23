package com.tencent.mobileqq.vas.vipicon.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.vipicon.VipIcon;
import com.tencent.mobileqq.vas.vipicon.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "", "it", "Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable;", "invoke", "(Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable;)[Ljava/lang/String;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
final class VipIconExFactoryImpl$getIcon$1 extends Lambda implements Function1<VipIcon, String[]> {
    final /* synthetic */ IVasRecentData.FriendsVipData $data;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipIconExFactoryImpl$getIcon$1(IVasRecentData.FriendsVipData friendsVipData) {
        super(1);
        this.$data = friendsVipData;
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
        if (!kVar.isFileExists(this.$data.getVipIconEx())) {
            kVar.addDownLoadListener(this.$data.getVipIconEx(), new Runnable() { // from class: com.tencent.mobileqq.vas.vipicon.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    VipIconExFactoryImpl$getIcon$1.b(VipIcon.this);
                }
            });
            kVar.startDownload(this.$data.getVipIconEx());
        }
        String e16 = kVar.e(this.$data.getVipIconEx());
        Intrinsics.checkNotNullExpressionValue(e16, "business.getIconPath(data.vipIconEx)");
        return new String[]{e16};
    }
}
