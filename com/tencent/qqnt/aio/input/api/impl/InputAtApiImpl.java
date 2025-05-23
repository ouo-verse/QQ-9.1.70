package com.tencent.qqnt.aio.input.api.impl;

import android.widget.EditText;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.input.at.business.AtUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.at.c;
import com.tencent.qqnt.aio.input.api.IInputAtApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/input/api/impl/InputAtApiImpl;", "Lcom/tencent/qqnt/aio/input/api/IInputAtApi;", "()V", "mEditText", "Landroid/widget/EditText;", "getMatchAtSpanCount", "", "matcher", "Lkotlin/Function1;", "", "", "initInput", "", "editText", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class InputAtApiImpl implements IInputAtApi {
    static IPatchRedirector $redirector_;

    @Nullable
    private EditText mEditText;

    public InputAtApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.input.api.IInputAtApi
    public int getMatchAtSpanCount(@NotNull final Function1<? super String, Boolean> matcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) matcher)).intValue();
        }
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        EditText editText = this.mEditText;
        if (editText == null) {
            return 0;
        }
        return AtUtils.f189228a.f(editText.getEditableText(), 0, editText.length(), new Function1<c, Boolean>(matcher) { // from class: com.tencent.qqnt.aio.input.api.impl.InputAtApiImpl$getMatchAtSpanCount$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function1<String, Boolean> $matcher;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$matcher = matcher;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) matcher);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull c span) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) span);
                }
                Intrinsics.checkNotNullParameter(span, "span");
                Function1<String, Boolean> function1 = this.$matcher;
                Intrinsics.checkNotNull(function1);
                String k3 = span.k();
                Intrinsics.checkNotNullExpressionValue(k3, "span.troopMemUin");
                return function1.invoke(k3);
            }
        });
    }

    @Override // com.tencent.qqnt.aio.input.api.IInputAtApi
    public void initInput(@NotNull EditText editText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) editText);
        } else {
            Intrinsics.checkNotNullParameter(editText, "editText");
            this.mEditText = editText;
        }
    }

    @Override // com.tencent.qqnt.aio.input.api.IInputAtApi
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mEditText = null;
        }
    }
}
