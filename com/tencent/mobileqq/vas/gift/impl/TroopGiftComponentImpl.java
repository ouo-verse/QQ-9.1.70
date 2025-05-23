package com.tencent.mobileqq.vas.gift.impl;

import android.content.Context;
import com.tencent.aio.data.msglist.a;
import com.tencent.mobileqq.vas.gift.ITroopGiftComponent;
import com.tencent.mobileqq.vas.gift.TroopGiftView;
import com.tencent.mobileqq.vas.gift.b;
import com.tencent.mobileqq.vas.gift.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/gift/impl/TroopGiftComponentImpl;", "Lcom/tencent/mobileqq/vas/gift/ITroopGiftComponent;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/gift/b;", "createGiftView", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "preLoadGiftRes", "preLoadPag", "", "isPause", "setPause", "", "selfId", "needAutoShowAnim", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class TroopGiftComponentImpl implements ITroopGiftComponent {
    @Override // com.tencent.mobileqq.vas.gift.ITroopGiftComponent
    @NotNull
    public b createGiftView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new TroopGiftView(context);
    }

    @Override // com.tencent.mobileqq.vas.gift.ITroopGiftComponent
    public boolean needAutoShowAnim(@NotNull a msgItem, @NotNull String selfId) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(selfId, "selfId");
        return g.f309293a.l(msgItem, selfId);
    }

    @Override // com.tencent.mobileqq.vas.gift.ITroopGiftComponent
    public void preLoadGiftRes(@NotNull a msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
    }

    @Override // com.tencent.mobileqq.vas.gift.ITroopGiftComponent
    public void setPause(boolean isPause) {
        TroopGiftView.INSTANCE.b(isPause);
    }

    @Override // com.tencent.mobileqq.vas.gift.ITroopGiftComponent
    public void preLoadPag() {
    }
}
