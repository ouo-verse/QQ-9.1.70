package com.tencent.aio.runtime.emitter;

import android.content.res.Configuration;
import com.tencent.aio.api.runtime.emitter.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aio/runtime/emitter/ConfigurationEmitter;", "Lcom/tencent/aio/runtime/emitter/AIOFunctionEmitter;", "Lcom/tencent/aio/api/runtime/emitter/b;", "Landroid/content/res/Configuration;", "configuration", "", "onConfigurationChanged", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ConfigurationEmitter extends AIOFunctionEmitter<b> implements b {
    static IPatchRedirector $redirector_;

    public ConfigurationEmitter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.runtime.emitter.b
    public void onConfigurationChanged(@NotNull final Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) configuration);
        } else {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            d(new Function1<b, Object>(configuration) { // from class: com.tencent.aio.runtime.emitter.ConfigurationEmitter$onConfigurationChanged$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Configuration $configuration;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$configuration = configuration;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) configuration);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Object invoke(@NotNull b it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        return iPatchRedirector2.redirect((short) 1, (Object) this, (Object) it);
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onConfigurationChanged(this.$configuration);
                    return Boolean.FALSE;
                }
            });
        }
    }
}
