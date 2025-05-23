package com.tencent.mobileqq.bizParts;

import android.os.Looper;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/Observer;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class QQSettingMeNavigationPart$showZPlanOrBannerObserver$2 extends Lambda implements Function0<Observer<Boolean>> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QQSettingMeNavigationPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQSettingMeNavigationPart$showZPlanOrBannerObserver$2(QQSettingMeNavigationPart qQSettingMeNavigationPart) {
        super(0);
        this.this$0 = qQSettingMeNavigationPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQSettingMeNavigationPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final QQSettingMeNavigationPart this$0, final Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.ba(it.booleanValue());
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.bizParts.ai
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeNavigationPart$showZPlanOrBannerObserver$2.d(QQSettingMeNavigationPart.this, it);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QQSettingMeNavigationPart this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.ba(it.booleanValue());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Observer<Boolean> invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Observer) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final QQSettingMeNavigationPart qQSettingMeNavigationPart = this.this$0;
        return new Observer() { // from class: com.tencent.mobileqq.bizParts.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeNavigationPart$showZPlanOrBannerObserver$2.c(QQSettingMeNavigationPart.this, (Boolean) obj);
            }
        };
    }
}
