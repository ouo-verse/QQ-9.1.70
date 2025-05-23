package com.tencent.mobileqq.config;

import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR0\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/config/at;", "", "", "deviceType", TangramHippyConstants.LOGIN_TYPE, "", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsToggleInit", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "mNewDevLoginTimeMap", "d", "mNormalLoginTimeMap", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class at {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final at f202335a = new at();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean mIsToggleInit = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Long> mNewDevLoginTimeMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Long> mNormalLoginTimeMap;

    static {
        HashMap<String, Long> hashMapOf;
        HashMap<String, Long> hashMapOf2;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("gateway_login", 23L), TuplesKt.to("phone_num_verify_code_login", 76L), TuplesKt.to("phone_num_pwd_login", 60000L), TuplesKt.to("account_pwd_login", 30204L), TuplesKt.to("wechat_login", 60000L), TuplesKt.to("other_login", 30204L));
        mNewDevLoginTimeMap = hashMapOf;
        hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("gateway_login", 20L), TuplesKt.to("phone_num_verify_code_login", 58L), TuplesKt.to("phone_num_pwd_login", Long.valueOf(JoinTimeType.THIRTY_MINUTES)), TuplesKt.to("account_pwd_login", 890L), TuplesKt.to("wechat_login", 800L), TuplesKt.to("other_login", 890L));
        mNormalLoginTimeMap = hashMapOf2;
    }

    at() {
    }

    public final long a(@NotNull String deviceType, @NotNull String loginType) {
        HashMap<String, Long> hashMap;
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        if (Intrinsics.areEqual(deviceType, "new_device")) {
            hashMap = mNewDevLoginTimeMap;
        } else {
            hashMap = mNormalLoginTimeMap;
        }
        Long l3 = hashMap.get(loginType);
        if (l3 == null) {
            return 1000L;
        }
        return l3.longValue();
    }
}
