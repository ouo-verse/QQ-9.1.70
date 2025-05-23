package com.tencent.mobileqq.vas.iceBreak.impl;

import android.content.Context;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.iceBreak.IIceBreakManager;
import com.tencent.mobileqq.vas.iceBreak.TroopIceBreakView;
import com.tencent.mobileqq.vas.iceBreak.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/iceBreak/impl/IceBreakManagerImpl;", "Lcom/tencent/mobileqq/vas/iceBreak/IIceBreakManager;", "Landroid/content/Context;", "context", "", "templateId", "Lcom/tencent/mobileqq/vas/iceBreak/a;", "getVipIceBreakView", "", "canShowVipStyle", "<init>", "()V", "Companion", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class IceBreakManagerImpl implements IIceBreakManager {

    @NotNull
    private static final String TAG = "IceBreakManagerImpl";

    @Override // com.tencent.mobileqq.vas.iceBreak.IIceBreakManager
    public boolean canShowVipStyle(int templateId) {
        if (templateId == 0 || templateId == 2000 || SimpleUIUtil.getSimpleUISwitch() || !VasNtToggle.INSTANCE.getTROOP_ICE_BREAK_ENABLE().isEnable(true)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.iceBreak.IIceBreakManager
    @Nullable
    public a getVipIceBreakView(@NotNull Context context, int templateId) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new TroopIceBreakView(context, null, 2, null);
    }
}
