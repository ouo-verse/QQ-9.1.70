package com.tencent.ams.dynamicwidget;

import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dynamicwidget.data.AdInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ams/dynamicwidget/DWMethodHandler;", "Lcom/tencent/ams/dsdk/event/DKMethodHandler;", "d", "a", "GetTemplateErrorCode", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class DWMethodHandler implements DKMethodHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ams/dynamicwidget/DWMethodHandler$GetTemplateErrorCode;", "", "Companion", "a", "lib_release"}, k = 1, mv = {1, 4, 0})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes3.dex */
    public @interface GetTemplateErrorCode {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final int LOAD_CONFIG_FAILED = -31;
        public static final int LOAD_TEMPLATE_FAILED = -32;
        public static final int LOAD_TEMPLATE_TIMEOUT = -33;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ams/dynamicwidget/DWMethodHandler$GetTemplateErrorCode$a;", "", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.ams.dynamicwidget.DWMethodHandler$GetTemplateErrorCode$a, reason: from kotlin metadata */
        /* loaded from: classes3.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f70141a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15975);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f70141a = new Companion();
                }
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(15976), (Class<?>) GetTemplateErrorCode.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                INSTANCE = Companion.f70141a;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ams/dynamicwidget/DWMethodHandler$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.ams.dynamicwidget.DWMethodHandler$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16019);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public static final /* synthetic */ void a(DWMethodHandler dWMethodHandler, String str, AdInfo adInfo) {
        throw null;
    }

    public static final /* synthetic */ void b(DWMethodHandler dWMethodHandler, String str, AdInfo adInfo) {
        throw null;
    }

    public static final /* synthetic */ AdInfo c(DWMethodHandler dWMethodHandler) {
        throw null;
    }

    public static final /* synthetic */ String d(DWMethodHandler dWMethodHandler) {
        throw null;
    }

    public static final /* synthetic */ void e(DWMethodHandler dWMethodHandler, DKMethodHandler.Callback callback, int i3, String str) {
        throw null;
    }
}
