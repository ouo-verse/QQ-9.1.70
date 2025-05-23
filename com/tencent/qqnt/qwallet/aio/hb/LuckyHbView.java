package com.tencent.qqnt.qwallet.aio.hb;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u00028\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/LuckyHbView;", "Lcom/tencent/qqnt/qwallet/aio/hb/SkinHbView;", "", "W", "Ljava/lang/String;", "V0", "()Ljava/lang/String;", "typeText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class LuckyHbView extends SkinHbView {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final String typeText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyHbView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.typeText = "\u62fc\u624b\u6c14\u7ea2\u5305";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView
    @NotNull
    /* renamed from: V0, reason: from getter */
    public String getTypeText() {
        return this.typeText;
    }
}
