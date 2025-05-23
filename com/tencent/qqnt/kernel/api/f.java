package com.tencent.qqnt.kernel.api;

import com.tencent.qqnt.kernel.nativeinterface.AccountInfo;
import com.tencent.qqnt.kernel.nativeinterface.AddBuddyReq;
import com.tencent.qqnt.kernel.nativeinterface.BuddySettingReq;
import com.tencent.qqnt.kernel.nativeinterface.IAddBuddyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IBuddySettingCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetBuddyInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetBuddyTagCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetSmartInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQueryUinSafetyFlagCallback;
import com.tencent.qqnt.kernel.nativeinterface.SmartReq;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J0\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000eH&J0\u0010\u0012\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0011H&J0\u0010\u0016\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0015H&J0\u0010\u0018\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0017H&J0\u0010\u001a\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0019H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/kernel/api/f;", "", "", "callFrom", "Lcom/tencent/qqnt/kernel/nativeinterface/AccountInfo;", "acc", "", "reqContext", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryUinSafetyFlagCallback;", "callback", "", "queryUinSafetyFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddySettingReq;", "reqInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IBuddySettingCallback;", "getBuddySetting", "Lcom/tencent/qqnt/kernel/nativeinterface/AddBuddyReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAddBuddyCallback;", "addBuddy", "Lcom/tencent/qqnt/kernel/nativeinterface/SmartReq;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetSmartInfoCallback;", "getSmartInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetBuddyInfoCallback;", "requestInfoByAccount", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetBuddyTagCallback;", "getAddBuddyRequestTag", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface f {
    void addBuddy(@Nullable String callFrom, @Nullable AddBuddyReq reqInfo, @Nullable byte[] reqContext, @Nullable IAddBuddyCallback callback);

    void getAddBuddyRequestTag(@Nullable String callFrom, @Nullable AccountInfo acc, @Nullable byte[] context, @Nullable IGetBuddyTagCallback callback);

    void getBuddySetting(@Nullable String callFrom, @Nullable BuddySettingReq reqInfo, @Nullable byte[] reqContext, @Nullable IBuddySettingCallback callback);

    void getSmartInfo(@Nullable String callFrom, @Nullable SmartReq reqInfo, @Nullable byte[] context, @Nullable IGetSmartInfoCallback callback);

    void queryUinSafetyFlag(@Nullable String callFrom, @Nullable AccountInfo acc, @Nullable byte[] reqContext, @Nullable IQueryUinSafetyFlagCallback callback);

    void requestInfoByAccount(@Nullable String callFrom, @Nullable AccountInfo acc, @Nullable byte[] context, @Nullable IGetBuddyInfoCallback callback);
}
