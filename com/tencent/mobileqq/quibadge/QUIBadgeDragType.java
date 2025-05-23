package com.tencent.mobileqq.quibadge;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/quibadge/QUIBadgeDragType;", "", "Companion", "a", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes17.dex */
public @interface QUIBadgeDragType {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int NONE = -1;
    public static final int SINGLE = 0;
    public static final int SINGLE_ONLY_BORN = 3;
    public static final int SINGLE_ONLY_SHAKE = 1;
    public static final int TAB = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/quibadge/QUIBadgeDragType$a;", "", "<init>", "()V", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.quibadge.QUIBadgeDragType$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f276962a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9314);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f276962a = new Companion();
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
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(AppConstants.RichMediaErrorCode.ERROR_PREEMPTED), (Class<?>) QUIBadgeDragType.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f276962a;
        }
    }
}
