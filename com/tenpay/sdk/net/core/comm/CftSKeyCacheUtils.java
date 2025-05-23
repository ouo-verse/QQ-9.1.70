package com.tenpay.sdk.net.core.comm;

import com.tencent.mobileqq.base.a;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tenpay.ndk.DesDecUtil;
import com.tenpay.ndk.DesEncUtil;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J3\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tenpay/sdk/net/core/comm/CftSKeyCacheUtils;", "", "()V", "TAG", "", "clearCftSKey", "", "uin", "getCftSKey", "Lcom/tenpay/sdk/net/core/comm/CftSKey;", "hasCftSKey", "", "saveCftSKey", "skey", "expireTime", "", "transSeq", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class CftSKeyCacheUtils {

    @NotNull
    public static final CftSKeyCacheUtils INSTANCE = new CftSKeyCacheUtils();

    @NotNull
    public static final String TAG = "QWalletHttp-CftSKey";

    CftSKeyCacheUtils() {
    }

    @JvmStatic
    public static final boolean hasCftSKey(@Nullable String uin) {
        CftSKey cftSKey = (CftSKey) g.h("qwallet_cft_skey_" + uin, CftSKey.class, null);
        if (cftSKey == null) {
            return false;
        }
        if (cftSKey.getExpireTime() < System.currentTimeMillis() / 1000) {
            INSTANCE.clearCftSKey(uin);
            ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, TAG, "getCftSKey in expired time: " + cftSKey, null, 4, null);
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean hasCftSKey$default(String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        return hasCftSKey(str);
    }

    public final void clearCftSKey(@Nullable String uin) {
        g.s("qwallet_cft_skey_" + uin);
    }

    @Nullable
    public final CftSKey getCftSKey(@Nullable String uin) {
        boolean z16;
        String c16;
        boolean z17 = false;
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            c16 = uin;
        } else {
            c16 = a.c();
        }
        CftSKey cftSKey = (CftSKey) g.h("qwallet_cft_skey_" + uin, CftSKey.class, null);
        if (cftSKey == null) {
            return null;
        }
        if (cftSKey.getExpireTime() < System.currentTimeMillis() / 1000) {
            clearCftSKey(uin);
            ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, TAG, "getCftSKey in expired time: " + cftSKey, null, 4, null);
            return null;
        }
        try {
            DesDecUtil desDecUtil = new DesDecUtil(MobileQQ.sMobileQQ);
            desDecUtil.decDesWithStringKey(c16, cftSKey.getSkey());
            String decryptResult = desDecUtil.getDecRes();
            if (decryptResult == null || decryptResult.length() == 0) {
                z17 = true;
            }
            if (z17) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(decryptResult, "decryptResult");
            return new CftSKey(decryptResult, cftSKey.getExpireTime(), cftSKey.getTransSeq());
        } catch (Exception e16) {
            DLog.INSTANCE.e(TAG, "getCftSKey error:", e16);
            return null;
        }
    }

    public final void saveCftSKey(@Nullable String uin, @Nullable String skey, @Nullable Long expireTime, @Nullable Integer transSeq) {
        if (uin != null && skey != null && expireTime != null && transSeq != null) {
            try {
                DesEncUtil desEncUtil = new DesEncUtil(MobileQQ.sMobileQQ);
                desEncUtil.encryptDesWithStringKey(uin, skey);
                String encryptSKey = desEncUtil.getDesEncResult();
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + expireTime.longValue();
                Intrinsics.checkNotNullExpressionValue(encryptSKey, "encryptSKey");
                CftSKey cftSKey = new CftSKey(encryptSKey, currentTimeMillis, transSeq.intValue());
                ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, TAG, "saveCftSKey " + cftSKey + " " + uin, null, 4, null);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("qwallet_cft_skey_");
                sb5.append(uin);
                g.p(sb5.toString(), cftSKey);
            } catch (Exception e16) {
                DLog.INSTANCE.e(TAG, "saveCftSKey error:", e16);
            }
        }
    }
}
