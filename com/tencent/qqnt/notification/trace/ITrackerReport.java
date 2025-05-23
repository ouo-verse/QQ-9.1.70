package com.tencent.qqnt.notification.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/notification/trace/ITrackerReport;", "", "report", "", "event", "", "ReportEvent", "notification_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public interface ITrackerReport {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/notification/trace/ITrackerReport$ReportEvent;", "", "Companion", "a", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes24.dex */
    public @interface ReportEvent {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        @NotNull
        public static final String PUSH_NOTIFICATION_SHOW = "push_notification_show";

        @NotNull
        public static final String PUSH_NOTIFICATION_SHOW_NO = "push_notification_show_no";

        @NotNull
        public static final String PUSH_VIBRATOR_AUDIO_ACTION = "push_vibrator_audio_action";

        @NotNull
        public static final String PUSH_VIBRATOR_AUDIO_ACTION_NO = "push_vibrator_audio_action_no";

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/notification/trace/ITrackerReport$ReportEvent$a;", "", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.notification.trace.ITrackerReport$ReportEvent$a, reason: from kotlin metadata */
        /* loaded from: classes24.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f359907a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45674);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f359907a = new Companion();
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
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(45675), (Class<?>) ReportEvent.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                INSTANCE = Companion.f359907a;
            }
        }
    }

    void report(@ReportEvent @NotNull String event);
}
