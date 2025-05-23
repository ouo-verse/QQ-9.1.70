package com.tencent.aio.api.runtime.emitter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"com/tencent/aio/api/runtime/emitter/AIOServiceContact$IRecycleViewScrollCallBack", "", "", "state", "", "onScrollStateChange", "ScrollType", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface AIOServiceContact$IRecycleViewScrollCallBack {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/api/runtime/emitter/AIOServiceContact$IRecycleViewScrollCallBack$ScrollType;", "", "Companion", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ScrollType {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final int SCROLL_STATE_DRAGGING = 1;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_SETTLING = 2;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/api/runtime/emitter/AIOServiceContact$IRecycleViewScrollCallBack$ScrollType$a;", "", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.aio.api.runtime.emitter.AIOServiceContact$IRecycleViewScrollCallBack$ScrollType$a, reason: from kotlin metadata */
        /* loaded from: classes3.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f69143a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23472);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f69143a = new Companion();
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
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(23474), (Class<?>) ScrollType.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                INSTANCE = Companion.f69143a;
            }
        }
    }

    void onScrollStateChange(int state);
}
