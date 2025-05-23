package com.tencent.mobileqq.aio.input.dialog;

import android.text.Spanned;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.at.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J(\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J0\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/input/dialog/c;", "Lcom/tencent/mobileqq/aio/input/dialog/a;", "", "", "g", "", "f", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "c", "Landroid/text/Spanned;", "spannedChars", "", "selectionStart", "lineCount", "a", "e", "", "getTag", "traceId", "", "b", "d", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c implements com.tencent.mobileqq.aio.input.dialog.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a f189376a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/dialog/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54490);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f189376a = new a(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public boolean a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned spannedChars, int selectionStart, int lineCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, aioContext, spannedChars, Integer.valueOf(selectionStart), Integer.valueOf(lineCount))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(spannedChars, "spannedChars");
        return false;
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public void b(int traceId, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned spannedChars, int selectionStart, int lineCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(traceId), aioContext, spannedChars, Integer.valueOf(selectionStart), Integer.valueOf(lineCount));
        } else {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            Intrinsics.checkNotNullParameter(spannedChars, "spannedChars");
        }
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public boolean c(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        a.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aioContext)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        k k3 = aioContext.e().k(InputAtMsgIntent.GetAtDialogState.f189182d);
        if (k3 instanceof a.c) {
            cVar = (a.c) k3;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            return cVar.a();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public void d(int traceId, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, traceId, (Object) aioContext);
        } else {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        }
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public boolean e(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned spannedChars, int selectionStart, int lineCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, aioContext, spannedChars, Integer.valueOf(selectionStart), Integer.valueOf(lineCount))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(spannedChars, "spannedChars");
        aioContext.e().h(new InputAtMsgIntent.OnTextChangedForAtDialog(spannedChars, selectionStart, lineCount));
        return true;
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    @NotNull
    public List<Character> g() {
        List<Character> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Character[]{'@', '\uff20'});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "TroopAtDialogPriorityProcessor";
    }
}
