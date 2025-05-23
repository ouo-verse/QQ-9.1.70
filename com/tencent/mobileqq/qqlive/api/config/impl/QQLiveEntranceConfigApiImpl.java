package com.tencent.mobileqq.qqlive.api.config.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveEntranceConfigApi;
import com.tencent.qphone.base.util.QLog;
import ht3.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/config/impl/QQLiveEntranceConfigApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/config/IQQLiveEntranceConfigApi;", "()V", "_isEntranceOpen", "", "get_isEntranceOpen", "()Z", "_isEntranceOpen$delegate", "Lkotlin/Lazy;", "isEntranceOpen", "showQCircleEntrance", "Companion", "qq-live-common-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLiveEntranceConfigApiImpl implements IQQLiveEntranceConfigApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "QQLiveEntranceConfigApiImpl";

    /* renamed from: _isEntranceOpen$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy _isEntranceOpen;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/config/impl/QQLiveEntranceConfigApiImpl$Companion;", "", "()V", "TAG", "", "qq-live-common-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27369);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveEntranceConfigApiImpl() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qqlive.api.config.impl.QQLiveEntranceConfigApiImpl$_isEntranceOpen$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveEntranceConfigApiImpl.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    boolean e16 = a.e("qqlive_task_enter_live", true);
                    QLog.i("QQLiveEntranceConfigApiImpl", 1, "enterQQLive: " + e16);
                    boolean z16 = e16 || QQLiveEntranceConfigApiImpl.this.showQCircleEntrance();
                    QLog.i("QQLiveEntranceConfigApiImpl", 1, "isEntranceOpen:" + z16);
                    return Boolean.valueOf(z16);
                }
            });
            this._isEntranceOpen = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean get_isEntranceOpen() {
        return ((Boolean) this._isEntranceOpen.getValue()).booleanValue();
    }

    @Override // com.tencent.mobileqq.qqlive.api.config.IQQLiveEntranceConfigApi
    public boolean isEntranceOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return get_isEntranceOpen();
    }

    @Override // com.tencent.mobileqq.qqlive.api.config.IQQLiveEntranceConfigApi
    public boolean showQCircleEntrance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean e16 = a.e("qqlive_task_show_live", true);
        QLog.i(TAG, 1, "showQCircleEntrance, value " + e16);
        return e16;
    }
}
