package com.tencent.mobileqq.aio.notification;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fJ7\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001H&\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/d;", "", "Lcom/tencent/mobileqq/aio/notification/c;", "notificationManager", "", "eventType", "", "params", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/notification/c;I[Ljava/lang/Object;)V", "", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", h.F, "L3", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface d {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: L3, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/d$a;", "", "", "b", "I", "f", "()I", "TYPE_ON_SHOW", "c", "getTYPE_ON_MSG_SENT_RECV", "TYPE_ON_MSG_SENT_RECV", "d", "getTYPE_ON_SEND", "TYPE_ON_SEND", "e", "TYPE_ON_PAUSE", "TYPE_ON_DESTROY", "g", "a", "TYPE_ON_CREATE", h.F, "TYPE_ON_DELAY_LOAD", "i", "TYPE_ON_RESUME", "j", "TYPE_ON_STOP", "k", "getTYPE_ON_DISMISS", "TYPE_ON_DISMISS", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.d$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f192866a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_ON_SHOW;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_ON_MSG_SENT_RECV;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_ON_SEND;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_ON_PAUSE;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_ON_DESTROY;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_ON_CREATE;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_ON_DELAY_LOAD;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_ON_RESUME;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_ON_STOP;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_ON_DISMISS;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49686);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 12)) {
                redirector.redirect((short) 12);
                return;
            }
            f192866a = new Companion();
            TYPE_ON_SHOW = 1000;
            TYPE_ON_MSG_SENT_RECV = 1001;
            TYPE_ON_SEND = 1002;
            TYPE_ON_PAUSE = 1003;
            TYPE_ON_DESTROY = 1004;
            TYPE_ON_CREATE = 1005;
            TYPE_ON_DELAY_LOAD = 1006;
            TYPE_ON_RESUME = 1007;
            TYPE_ON_STOP = 1008;
            TYPE_ON_DISMISS = 2000;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return TYPE_ON_CREATE;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return TYPE_ON_DELAY_LOAD;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return TYPE_ON_DESTROY;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return TYPE_ON_PAUSE;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return TYPE_ON_RESUME;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return TYPE_ON_SHOW;
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return TYPE_ON_STOP;
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(49688), (Class<?>) d.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f192866a;
        }
    }

    @NotNull
    List<AIONotificationBusiId> h();

    void m(@NotNull c notificationManager, int eventType, @NotNull Object... params);
}
