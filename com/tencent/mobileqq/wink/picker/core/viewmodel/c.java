package com.tencent.mobileqq.wink.picker.core.viewmodel;

import com.tencent.mobileqq.wink.picker.core.viewmodel.b;
import com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/c;", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;", "", "E0", "", "isError", "b0", "", "toCompressedMediaNum", "y0", "Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog$PreDealStep;", "step", "useVideoTemplate", "g0", "", "progress", "W0", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class c implements b {
    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void g0(@NotNull PhotoListLogicPreDealDialog.PreDealStep step, boolean useVideoTemplate) {
        Intrinsics.checkNotNullParameter(step, "step");
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void i0(float f16) {
        b.a.b(this, f16);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void E0() {
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void W0(float progress) {
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void b0(boolean isError) {
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void y0(int toCompressedMediaNum) {
    }
}
