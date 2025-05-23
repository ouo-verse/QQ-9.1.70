package com.tencent.mobileqq.zplan.api;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/UECacheData;", "Ljava/io/Serializable;", "", "a", "", AppConstants.Key.COLUMN_IS_VALID, "toString", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "value", HippyTextInputController.COMMAND_getValue, "", "expiredTime", "J", "getExpiredTime", "()J", "canPutInInitParam", "Z", "getCanPutInInitParam", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;JZ)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class UECacheData implements Serializable {
    private final boolean canPutInInitParam;
    private final long expiredTime;

    @NotNull
    private final String key;

    @NotNull
    private final String value;

    public UECacheData(@NotNull String key, @NotNull String value, long j3, boolean z16) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.key = key;
        this.value = value;
        this.expiredTime = j3;
        this.canPutInInitParam = z16;
    }

    private final String a(String str) {
        String substring = str.substring(0, RangesKt.coerceAtMost(str.length(), 100));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        if (str.length() > 100) {
            return substring + "...(" + str.length() + ')';
        }
        return substring;
    }

    public final boolean getCanPutInInitParam() {
        return this.canPutInInitParam;
    }

    public final long getExpiredTime() {
        return this.expiredTime;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public final boolean isValid() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (serverTimeMillis > this.expiredTime) {
            QLog.e("UECacheData", 1, "cache is invalid. serverTime:" + serverTimeMillis + TokenParser.SP + this);
            return false;
        }
        QLog.d("UECacheData", 4, "cache is valid. " + this);
        return true;
    }

    @NotNull
    public String toString() {
        return "{key:" + this.key + ", value:" + a(this.value) + ", expiredTime:" + this.expiredTime + ", canPutInInitParam:" + this.canPutInInitParam + '}';
    }

    public /* synthetic */ UECacheData(String str, String str2, long j3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j3, (i3 & 8) != 0 ? false : z16);
    }
}
