package com.tenpay.sdk.net.core.processor;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.e;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.net.core.comm.BannedUserInfo;
import com.tenpay.sdk.net.http.interceptor.PsKeyInterceptor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tenpay/sdk/net/core/processor/PsKeyProcessor;", "", "()V", "FORBID_URLS", "", "", "TIME_OUT_MS", "", "appendForbidParams2Url", "", "finalExtraMap", "", "getPsKey", "url", "isForbidUrl", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PsKeyProcessor {

    @NotNull
    private static final List<String> FORBID_URLS;

    @NotNull
    public static final PsKeyProcessor INSTANCE = new PsKeyProcessor();
    private static final long TIME_OUT_MS = 3000;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qwallet.cgi", "qpay_gate.cgi", "qpwd_sdk_auth.cgi"});
        FORBID_URLS = listOf;
    }

    PsKeyProcessor() {
    }

    public static /* synthetic */ String getPsKey$default(PsKeyProcessor psKeyProcessor, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        return psKeyProcessor.getPsKey(str);
    }

    public final void appendForbidParams2Url(@NotNull Map<String, String> finalExtraMap) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(finalExtraMap, "finalExtraMap");
        BannedUserInfo cache = BannedUserInfo.INSTANCE.getCache();
        boolean z18 = true;
        if (cache != null && cache.isValid()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            finalExtraMap.put("pskey_scene", "client");
            return;
        }
        String psKeyForbid = cache.getPsKeyForbid();
        if (psKeyForbid != null && psKeyForbid.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            finalExtraMap.put("p_skey_forbid", cache.getPsKeyForbid() + "&pskey_scene=h5");
        } else {
            finalExtraMap.put("pskey_scene", "client");
        }
        String bannedUserBuff = cache.getBannedUserBuff();
        if (bannedUserBuff != null && bannedUserBuff.length() != 0) {
            z18 = false;
        }
        if (!z18) {
            finalExtraMap.put("banned_user_buff", String.valueOf(cache.getBannedUserBuff()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final String getPsKey(@Nullable String url) {
        boolean z16;
        boolean z17;
        if (url != null && isForbidUrl(url)) {
            BannedUserInfo cache = BannedUserInfo.INSTANCE.getCache();
            if (cache != null && cache.isValid()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String psKey = cache.getPsKey();
                if (psKey != null && psKey.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    QLog.i(PsKeyInterceptor.TAG, 1, "use banned user psKey " + cache.getPsKey());
                    return cache.getPsKey();
                }
            }
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        e.b(false, Cgi.TENPAY_DOMAIN, new e.a() { // from class: com.tenpay.sdk.net.core.processor.PsKeyProcessor$getPsKey$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mobileqq.qwallet.e.a
            public void onFinish(int code, @Nullable String errMsg, @Nullable String pskey) {
                boolean z18;
                if (code == 0) {
                    if (pskey != 0 && pskey.length() != 0) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (!z18) {
                        objectRef.element = pskey;
                        QLog.i(PsKeyInterceptor.TAG, 1, "get psKey success");
                        countDownLatch.countDown();
                    }
                }
                QLog.e(PsKeyInterceptor.TAG, 1, "get psKey fail: " + code + ", " + errMsg + " " + pskey);
                countDownLatch.countDown();
            }
        });
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        countDownLatch.await(3000L, timeUnit);
        if (TextUtils.isEmpty((CharSequence) objectRef.element)) {
            final CountDownLatch countDownLatch2 = new CountDownLatch(1);
            e.b(true, Cgi.TENPAY_DOMAIN, new e.a() { // from class: com.tenpay.sdk.net.core.processor.PsKeyProcessor$getPsKey$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.tencent.mobileqq.qwallet.e.a
                public void onFinish(int code, @Nullable String errMsg, @Nullable String pskey) {
                    boolean z18;
                    if (code == 0) {
                        if (pskey != 0 && pskey.length() != 0) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        if (!z18) {
                            objectRef.element = pskey;
                            QLog.i(PsKeyInterceptor.TAG, 1, "refresh psKey success");
                            countDownLatch2.countDown();
                        }
                    }
                    QLog.e(PsKeyInterceptor.TAG, 1, "refresh psKey fail: " + code + ", " + errMsg + " " + pskey);
                    countDownLatch2.countDown();
                }
            });
            countDownLatch2.await(3000L, timeUnit);
        }
        QLog.d(PsKeyInterceptor.TAG, 2, "psKey: " + objectRef.element);
        return (String) objectRef.element;
    }

    public final boolean isForbidUrl(@NotNull String url) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(url, "url");
        List<String> list = FORBID_URLS;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) it.next(), false, 2, (Object) null);
            if (contains$default) {
                return true;
            }
        }
        return false;
    }
}
