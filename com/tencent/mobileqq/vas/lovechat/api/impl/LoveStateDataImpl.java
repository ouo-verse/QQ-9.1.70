package com.tencent.mobileqq.vas.lovechat.api.impl;

import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.lovechat.api.ILoveStateData;
import com.tencent.mobileqq.vas.lovechat.api.impl.LoveStateDataImpl;
import com.tencent.mobileqq.vip.api.i;
import com.tencent.mobileqq.vip.api.impl.VipDataUtilsImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback;
import com.tencent.qqnt.msg.f;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/lovechat/api/impl/LoveStateDataImpl;", "Lcom/tencent/mobileqq/vas/lovechat/api/ILoveStateData;", "()V", "getLoveState", "", "getLoveUin", "", "setLoveState", "", "state", "setLoveUin", "uin", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class LoveStateDataImpl implements ILoveStateData {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLoveUin$lambda$1$lambda$0(long j3, HashMap hashMap) {
        i.c cVar = new i.c(0);
        String str = (String) hashMap.get(Long.valueOf(j3));
        if (str == null) {
            str = "";
        }
        cVar.e(false, j3, str);
    }

    @Override // com.tencent.mobileqq.vas.lovechat.api.ILoveStateData
    public int getLoveState() {
        String str;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 0;
        }
        return VipMMKV.INSTANCE.getLoveZone(str).decodeInt("love_state", 0);
    }

    @Override // com.tencent.mobileqq.vas.lovechat.api.ILoveStateData
    @NotNull
    public String getLoveUin() {
        String str;
        boolean z16;
        String decodeString;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (decodeString = VipMMKV.INSTANCE.getLoveZone(str).decodeString("love_uin", "0")) == null) {
            return "0";
        }
        return decodeString;
    }

    @Override // com.tencent.mobileqq.vas.lovechat.api.ILoveStateData
    public void setLoveState(int state) {
        String str;
        if (QLog.isColorLevel()) {
            VasLogReporter.INSTANCE.getQzoneVip().reportLow("save love_state = " + state);
        }
        VipMMKV.Companion companion = VipMMKV.INSTANCE;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        companion.getLoveZone(str).encodeInt("love_state", state);
    }

    @Override // com.tencent.mobileqq.vas.lovechat.api.ILoveStateData
    public void setLoveUin(@NotNull String uin) {
        String str;
        ag j3;
        HashSet<Long> hashSetOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (QLog.isColorLevel()) {
            VasLogReporter.INSTANCE.getQzoneVip().reportLow("save love_uin = " + uin);
        }
        try {
            String loveUin = getLoveUin();
            if (!Intrinsics.areEqual(loveUin, uin)) {
                Long[] lArr = {Long.valueOf(Long.parseLong(loveUin)), Long.valueOf(Long.parseLong(uin))};
                for (int i3 = 0; i3 < 2; i3++) {
                    final long longValue = lArr[i3].longValue();
                    if (longValue != 0 && (j3 = f.j()) != null) {
                        hashSetOf = SetsKt__SetsKt.hashSetOf(Long.valueOf(longValue));
                        j3.getUid(hashSetOf, new IKernelGetUidInfoCallback() { // from class: v13.a
                            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback
                            public final void onResult(HashMap hashMap) {
                                LoveStateDataImpl.setLoveUin$lambda$1$lambda$0(longValue, hashMap);
                            }
                        });
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(VipDataUtilsImpl.TAG, 1, e16, new Object[0]);
        }
        VipMMKV.Companion companion = VipMMKV.INSTANCE;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        companion.getLoveZone(str).encodeString("love_uin", uin);
    }
}
