package com.tencent.mobileqq.icgame.room.frame.page;

import android.content.Context;
import com.tencent.mobileqq.icgame.framework.page.Page;
import com.tencent.mobileqq.icgame.room.config.ICGameConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/frame/page/ICGamePageFragment;", "Lcom/tencent/mobileqq/icgame/room/frame/page/BasePageFragment;", "Lcom/tencent/mobileqq/icgame/framework/page/Page;", "Bh", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ICGamePageFragment extends BasePageFragment {
    @Override // com.tencent.mobileqq.icgame.room.frame.page.BasePageFragment
    @NotNull
    public Page Bh() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new Page(requireContext, ICGameConfig.f237442a);
    }
}
