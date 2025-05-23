package com.tencent.mobileqq.selectfriend.forward;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/forward/a;", "", "a", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/selectfriend/forward/a$a;", "", "", "b", "I", "getPTT_CENTER", "()I", "setPTT_CENTER", "(I)V", "PTT_CENTER", "c", "getMARKET_FACE", "setMARKET_FACE", "MARKET_FACE", "d", "getCOMPOSITE", "setCOMPOSITE", "COMPOSITE", "e", "a", "setSDK_SHARE", "SDK_SHARE", "f", "getAIO_ALBUM", "setAIO_ALBUM", "AIO_ALBUM", "g", "getVOICE_CALL", "setVOICE_CALL", "VOICE_CALL", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.selectfriend.forward.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f285398a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static int PTT_CENTER;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static int MARKET_FACE;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private static int COMPOSITE;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private static int SDK_SHARE;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private static int AIO_ALBUM;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private static int VOICE_CALL;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22871);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 14)) {
                redirector.redirect((short) 14);
                return;
            }
            f285398a = new Companion();
            PTT_CENTER = 8;
            MARKET_FACE = 9;
            COMPOSITE = 10;
            SDK_SHARE = 11;
            AIO_ALBUM = 12;
            VOICE_CALL = 13;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return SDK_SHARE;
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(22876), (Class<?>) a.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f285398a;
        }
    }
}
