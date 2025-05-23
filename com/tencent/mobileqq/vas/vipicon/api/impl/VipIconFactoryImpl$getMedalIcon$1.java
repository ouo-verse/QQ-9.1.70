package com.tencent.mobileqq.vas.vipicon.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.vipicon.VipIcon;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "", "it", "Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable;", "invoke", "(Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable;)[Ljava/lang/String;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
final class VipIconFactoryImpl$getMedalIcon$1 extends Lambda implements Function1<VipIcon, String[]> {
    final /* synthetic */ int $id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipIconFactoryImpl$getMedalIcon$1(int i3) {
        super(1);
        this.$id = i3;
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
        final com.tencent.mobileqq.vas.updatesystem.business.g gVar = (com.tencent.mobileqq.vas.updatesystem.business.g) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.updatesystem.business.g.class);
        final int i3 = this.$id;
        final Function0<String[]> function0 = new Function0<String[]>() { // from class: com.tencent.mobileqq.vas.vipicon.api.impl.VipIconFactoryImpl$getMedalIcon$1$getUrls$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String[] invoke() {
                return new String[]{com.tencent.mobileqq.vas.updatesystem.business.g.this.e(i3)};
            }
        };
        if (!gVar.isFileExists(this.$id)) {
            gVar.addDownLoadListener(this.$id, new Runnable() { // from class: com.tencent.mobileqq.vas.vipicon.api.impl.h
                @Override // java.lang.Runnable
                public final void run() {
                    VipIconFactoryImpl$getMedalIcon$1.b(VipIcon.this, function0);
                }
            });
            gVar.startDownload(this.$id);
        }
        return function0.invoke();
    }
}
