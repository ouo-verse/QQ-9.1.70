package com.tencent.mobileqq.addfriend.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/addfriend/api/a;", "", "a", "qqaddfriend-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f187264b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String f187265c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String f187266d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f187267e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f187268f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final String f187269g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final String f187270h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final String f187271i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final String f187272j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final String f187273k;

    /* renamed from: l, reason: collision with root package name */
    private static final int f187274l = 0;

    /* renamed from: m, reason: collision with root package name */
    private static final int f187275m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final String f187276n;

    /* renamed from: o, reason: collision with root package name */
    private static final int f187277o;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R \u0010\f\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R \u0010\u000f\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R \u0010\u0012\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0006R \u0010\u0015\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0016\u0010\u0006R \u0010\u0018\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\u0006R \u0010\u001c\u001a\u00020\u001b8\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b \u0010\b\u001a\u0004\b\u001e\u0010\u001fR \u0010!\u001a\u00020\u001b8\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b!\u0010\u001d\u0012\u0004\b#\u0010\b\u001a\u0004\b\"\u0010\u001fR \u0010$\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b$\u0010\u0004\u0012\u0004\b&\u0010\b\u001a\u0004\b%\u0010\u0006\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/addfriend/api/a$a;", "", "", "CMD_ADD_FRIEND_GET_USER_SETTING", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "getCMD_ADD_FRIEND_GET_USER_SETTING$annotations", "()V", "CMD_ADD_FRIEND_INFO", "c", "getCMD_ADD_FRIEND_INFO$annotations", "CMD_ADD_FRIEND", "a", "getCMD_ADD_FRIEND$annotations", "CMD_ADD_FRIEND_SMART_INFO", "d", "getCMD_ADD_FRIEND_SMART_INFO$annotations", "CMD_REQUEST_TAG", "g", "getCMD_REQUEST_TAG$annotations", "CMD_REQUEST_INFO_BY_OPENID", "f", "getCMD_REQUEST_INFO_BY_OPENID$annotations", "CMD_DEL_FRIEND", "e", "getCMD_DEL_FRIEND$annotations", "", "NT_CALLBACK_RESULT_SUCCESS", "I", "j", "()I", "getNT_CALLBACK_RESULT_SUCCESS$annotations", "LOCAL_SERVICE_ERROR_CODE", h.F, "getLOCAL_SERVICE_ERROR_CODE$annotations", "LOCAL_SERVICE_ERROR_MSG", "i", "getLOCAL_SERVICE_ERROR_MSG$annotations", "<init>", "qqaddfriend-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.api.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                return;
            }
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return a.f187266d;
            }
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return a.f187264b;
            }
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return a.f187265c;
            }
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return a.f187267e;
            }
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return a.f187270h;
            }
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }

        @NotNull
        public final String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return a.f187269g;
            }
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }

        @NotNull
        public final String g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return a.f187268f;
            }
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }

        public final int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                return a.f187275m;
            }
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }

        @NotNull
        public final String i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                return a.f187276n;
            }
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }

        public final int j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                return a.f187274l;
            }
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25735);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        f187264b = "0x7c1";
        f187265c = "0xfe1";
        f187266d = "0x7c2";
        f187267e = "0x783";
        f187268f = "0x1004";
        f187269g = "0xbdd";
        f187270h = "0x10db";
        f187271i = "0xfe1_sub_cmd";
        f187272j = "0xfe1_add_friend_safety_flag";
        f187273k = "0xfe1_add_friend_by_openid";
        f187275m = -21000;
        f187276n = "NTService sendRequest error";
        f187277o = -1;
    }
}
