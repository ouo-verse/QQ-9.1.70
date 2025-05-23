package com.tencent.mobileqq.qqlive.sail.error;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.room.l;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/error/a;", "", "<init>", "()V", "a", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<Long, String> f272181b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J7\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000fR\u0014\u0010\u001b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001cR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/error/a$a;", "", "", "e", "", "errCode", "", "d", "T", "value", "errMsg", "Lcom/tencent/mobileqq/qqlive/sail/room/l;", "b", "(JLjava/lang/Object;Ljava/lang/String;)Lcom/tencent/mobileqq/qqlive/sail/room/l;", "ERROR_CODE_BASE", "J", "ERROR_CREATE_VIDEO_PLAYER_FAILED", "ERROR_ILLEGAL_VIDEO_PLAYER_CONFIG", "ERROR_ILLEGAL_VIDEO_PLAYER_URL", "ERROR_INIT_TRTC_FAILED", "ERROR_INVALID_ANCHOR_ID", "ERROR_INVALID_PROGRAM_ID", "ERROR_INVALID_ROOM_ID", "ERROR_INVALID_ROOM_STATE", "ERROR_INVALID_UID", "ERROR_PERMISSION_DENIED", "ERROR_UPDATE_USER_INFO_FAILED", "TAG", "Ljava/lang/String;", "UNKNOWN_ERROR_MSG", "Ljava/util/concurrent/ConcurrentHashMap;", "errorMsgMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.error.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public static /* synthetic */ l c(Companion companion, long j3, Object obj, String str, int i3, Object obj2) {
            if ((i3 & 4) != 0) {
                str = null;
            }
            return companion.b(j3, obj, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e() {
            String str;
            try {
                Field[] fields = a.class.getFields();
                Intrinsics.checkNotNullExpressionValue(fields, "LocalError::class.java.fields");
                for (Field field : fields) {
                    if (field.isAnnotationPresent(ErrorCodeMsg.class)) {
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                        Long l3 = null;
                        Object obj = field.get(null);
                        if (obj instanceof Long) {
                            l3 = (Long) obj;
                        }
                        if (l3 != null) {
                            long longValue = l3.longValue();
                            ConcurrentHashMap concurrentHashMap = a.f272181b;
                            Long valueOf = Long.valueOf(longValue);
                            ErrorCodeMsg errorCodeMsg = (ErrorCodeMsg) field.getAnnotation(ErrorCodeMsg.class);
                            if (errorCodeMsg == null || (str = errorCodeMsg.msg()) == null) {
                                str = "Unknown";
                            }
                            concurrentHashMap.put(valueOf, str);
                        }
                    }
                }
            } catch (SecurityException e16) {
                QLog.e("LocalError", 1, "loadErrorCode failed", e16);
            }
        }

        @NotNull
        public final <T> l<T> b(long errCode, @Nullable T value, @Nullable String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (l) iPatchRedirector.redirect((short) 3, this, Long.valueOf(errCode), value, errMsg);
            }
            if (errMsg == null && (errMsg = (String) a.f272181b.get(Long.valueOf(errCode))) == null) {
                errMsg = "Unknown";
            }
            return new l<>(value, errCode, errMsg, 1);
        }

        @NotNull
        public final String d(long errCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, errCode);
            }
            String str = (String) a.f272181b.get(Long.valueOf(errCode));
            if (str == null) {
                return "Unknown";
            }
            return str;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30715);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f272181b = new ConcurrentHashMap<>();
        companion.e();
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
