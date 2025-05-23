package com.tencent.ams.dynamicwidget;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* compiled from: P */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"com/tencent/ams/dynamicwidget/OutConfigGetter$ConfigType", "", "Companion", "a", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public @interface OutConfigGetter$ConfigType {
    public static final IPatchRedirector $redirector_ = null;
    public static final int Boolean = 4;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final int Double = 3;
    public static final int Int = 1;
    public static final int Long = 2;
    public static final int String = 0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ams/dynamicwidget/OutConfigGetter$ConfigType$a;", "", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.ams.dynamicwidget.OutConfigGetter$ConfigType$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f70158a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16065);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f70158a = new Companion();
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
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(16067), (Class<?>) OutConfigGetter$ConfigType.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f70158a;
        }
    }
}
