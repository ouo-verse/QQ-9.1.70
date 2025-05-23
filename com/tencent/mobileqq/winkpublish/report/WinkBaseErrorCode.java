package com.tencent.mobileqq.winkpublish.report;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H&J\u0006\u0010\r\u001a\u00020\u0005J\b\u0010\u000e\u001a\u00020\u0005H&J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0006\u0010\u0012\u001a\u00020\u0003R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "", "errorCode", "", "errorMsg", "", "(JLjava/lang/String;)V", "getErrorCode", "()J", "getErrorMsg", "()Ljava/lang/String;", "computeWinkErrorCode", "getErrorCodePrefix", "getMessage", "getTag", "isOK", "", "toString", "transformedCode", "Companion", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public abstract class WinkBaseErrorCode {
    public static final long EXPORT_ERROR_CODE_PREFIX = 13;
    public static final long MATERIAL_DOWNLOAD_ERROR_CODE_PREFIX = 21;
    public static final long MEDIA_PICKER_ERROR_CODE_PREFIX = 15;
    public static final long ONE_CLICK_PUBLISHING_FEED_ERROR_CODE_PREFIX = 17;
    public static final long PUBLISH_ACTIVITY_CODE_PREFIX = 18;
    public static final long PUBLISH_FEED_ERROR_CODE_PREFIX = 14;
    public static final long SKIN_ENGINE_ERROR_CODE_PREFIX = 16;

    @NotNull
    private static final String TAG = "WinkPublishErrorCode";
    public static final long TASK_ERROR_CODE_PREFIX = 11;
    public static final long UPLOAD_ERROR_CODE_PREFIX = 12;
    public static final long WINK_CONTEXT_CODE_PREFIX = 19;
    public static final long WINK_HOOK_TEST_CODE_PREFIX = 20;

    @NotNull
    private static final ConcurrentHashMap<Long, String> errorMsgMap;
    private final long errorCode;

    @Nullable
    private final String errorMsg;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ConcurrentHashMap<Long, Long> errorCodeMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode$Companion;", "", "()V", "EXPORT_ERROR_CODE_PREFIX", "", "MATERIAL_DOWNLOAD_ERROR_CODE_PREFIX", "MEDIA_PICKER_ERROR_CODE_PREFIX", "ONE_CLICK_PUBLISHING_FEED_ERROR_CODE_PREFIX", "PUBLISH_ACTIVITY_CODE_PREFIX", "PUBLISH_FEED_ERROR_CODE_PREFIX", "SKIN_ENGINE_ERROR_CODE_PREFIX", "TAG", "", "TASK_ERROR_CODE_PREFIX", "UPLOAD_ERROR_CODE_PREFIX", "WINK_CONTEXT_CODE_PREFIX", "WINK_HOOK_TEST_CODE_PREFIX", "errorCodeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "errorMsgMap", "loadPredefinedCode", "", "kClass", "Lkotlin/reflect/KClass;", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void loadPredefinedCode(@NotNull KClass<?> kClass) {
            String msg2;
            Intrinsics.checkNotNullParameter(kClass, "kClass");
            QLog.i(WinkBaseErrorCode.TAG, 1, "[loadPredefinedCode] kClass=" + kClass);
            try {
                Field[] fields = JvmClassMappingKt.getJavaClass((KClass) kClass).getFields();
                Intrinsics.checkNotNullExpressionValue(fields, "fields");
                for (Field field : fields) {
                    if (field.isAnnotationPresent(WinkErrorCode.class)) {
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                        Long l3 = null;
                        Object obj = field.get(null);
                        boolean z16 = obj instanceof Long;
                        if (obj instanceof Long) {
                            l3 = (Long) obj;
                        }
                        if (l3 != null) {
                            long longValue = l3.longValue();
                            WinkBaseErrorCode.errorCodeMap.put(Long.valueOf(longValue), Long.valueOf(longValue));
                            int i3 = Build.VERSION.SDK_INT;
                            String str = WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN;
                            if (i3 > 23) {
                                ConcurrentHashMap concurrentHashMap = WinkBaseErrorCode.errorMsgMap;
                                Long valueOf = Long.valueOf(longValue);
                                WinkErrorCode winkErrorCode = (WinkErrorCode) field.getAnnotation(WinkErrorCode.class);
                                if (winkErrorCode != null && (msg2 = winkErrorCode.msg()) != null) {
                                    str = msg2;
                                }
                                concurrentHashMap.put(valueOf, str);
                            } else {
                                WinkBaseErrorCode.errorMsgMap.put(Long.valueOf(longValue), WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN);
                            }
                        }
                    }
                }
            } catch (SecurityException e16) {
                QLog.e(WinkBaseErrorCode.TAG, 1, "[loadPredefinedCode] ", e16);
            }
            WinkBaseErrorCode.errorCodeMap.put(0L, 0L);
            if (QLog.isColorLevel()) {
                QLog.d(WinkBaseErrorCode.TAG, 2, "[loadPredefinedCode] code map=" + WinkBaseErrorCode.errorCodeMap + ", msg map=" + WinkBaseErrorCode.errorMsgMap);
            }
        }

        Companion() {
        }
    }

    static {
        ConcurrentHashMap<Long, String> concurrentHashMap = new ConcurrentHashMap<>();
        errorMsgMap = concurrentHashMap;
        concurrentHashMap.put(0L, WinkBaseErrorCodeKt.ERROR_MSG_OK);
    }

    public WinkBaseErrorCode(long j3, @Nullable String str) {
        this.errorCode = j3;
        this.errorMsg = str;
        if (str != null) {
            errorMsgMap.put(Long.valueOf(j3), str);
        }
    }

    private final long computeWinkErrorCode() {
        int sign;
        long errorCodePrefix = getErrorCodePrefix();
        try {
            long errorCodePrefix2 = getErrorCodePrefix();
            long abs = Math.abs(this.errorCode);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(errorCodePrefix2);
            sb5.append(abs);
            long parseLong = Long.parseLong(sb5.toString());
            sign = MathKt__MathJVMKt.getSign(this.errorCode);
            errorCodePrefix = sign * parseLong;
        } catch (Exception e16) {
            QLog.e(getTag(), 1, "[computeWinkErrorCode] ", e16);
        }
        QLog.i(getTag(), 1, "[computeWinkErrorCode] " + this.errorCode + " -> " + errorCodePrefix);
        return errorCodePrefix;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long getErrorCode() {
        return this.errorCode;
    }

    public abstract long getErrorCodePrefix();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @NotNull
    public final String getMessage() {
        if (QLog.isColorLevel()) {
            QLog.d(getTag(), 2, "[getMessage] message map=" + errorMsgMap);
        }
        String str = errorMsgMap.get(Long.valueOf(this.errorCode));
        if (str == null) {
            str = WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN;
        }
        return str;
    }

    @NotNull
    public abstract String getTag();

    public final boolean isOK() {
        if (transformedCode() == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "(" + hashCode() + ") code=" + this.errorCode + ", msg=" + getMessage();
    }

    public final long transformedCode() {
        ConcurrentHashMap<Long, Long> concurrentHashMap = errorCodeMap;
        Long l3 = concurrentHashMap.get(Long.valueOf(this.errorCode));
        if (l3 != null) {
            if (QLog.isColorLevel()) {
                QLog.d(getTag(), 2, "[transformedCode] found, " + this.errorCode + " -> " + l3);
            }
            return l3.longValue();
        }
        long computeWinkErrorCode = computeWinkErrorCode();
        concurrentHashMap.put(Long.valueOf(this.errorCode), Long.valueOf(computeWinkErrorCode));
        return computeWinkErrorCode;
    }

    public /* synthetic */ WinkBaseErrorCode(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? null : str);
    }
}
