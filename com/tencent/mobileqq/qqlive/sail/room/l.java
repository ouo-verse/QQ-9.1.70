package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u0000  *\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0005B1\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u00a2\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0019\u0010\u0004\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/l;", "T", "", BdhLogUtil.LogTag.Tag_Req, "value", "a", "(Ljava/lang/Object;)Lcom/tencent/mobileqq/qqlive/sail/room/l;", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "", "b", "J", "()J", "errCode", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "I", "getErrType", "()I", ImageTaskConst.ERROR_TYPE, "<init>", "(Ljava/lang/Object;JLjava/lang/String;I)V", "e", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class l<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final T value;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long errCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String errMsg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int errType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/l$a;", "", "", "ERROR_OK", "J", "", "LOCAL_ERROR_TYPE", "I", "NET_ERROR_TYPE", "SVR_ERROR_TYPE", "TRTC_ERROR_TYPE", "UNKNOWN_ERROR_TYPE", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.room.l$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32093);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l(@Nullable T t16, long j3, @Nullable String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, t16, Long.valueOf(j3), str, Integer.valueOf(i3));
            return;
        }
        this.value = t16;
        this.errCode = j3;
        this.errMsg = str;
        this.errType = i3;
    }

    @NotNull
    public final <R> l<R> a(@Nullable R value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (l) iPatchRedirector.redirect((short) 7, (Object) this, (Object) value);
        }
        return new l<>(value, this.errCode, this.errMsg, this.errType);
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.errCode;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.errMsg;
    }

    @Nullable
    public final T d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.value;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof l)) {
            return false;
        }
        l lVar = (l) other;
        if (Intrinsics.areEqual(this.value, lVar.value) && this.errCode == lVar.errCode && Intrinsics.areEqual(this.errMsg, lVar.errMsg) && this.errType == lVar.errType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        T t16 = this.value;
        int i3 = 0;
        if (t16 == null) {
            hashCode = 0;
        } else {
            hashCode = t16.hashCode();
        }
        int a16 = ((hashCode * 31) + androidx.fragment.app.a.a(this.errCode)) * 31;
        String str = this.errMsg;
        if (str != null) {
            i3 = str.hashCode();
        }
        return ((a16 + i3) * 31) + this.errType;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", errType=" + this.errType;
    }

    public /* synthetic */ l(Object obj, long j3, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i16 & 2) != 0 ? 0L : j3, (i16 & 4) != 0 ? null : str, (i16 & 8) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, obj, Long.valueOf(j3), str, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
