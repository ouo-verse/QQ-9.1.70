package com.tencent.qqnt.aio.publicaccount.inputadorn;

import android.content.Context;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.aio.input.adorn.a;
import com.tencent.mobileqq.aio.input.adorn.b;
import com.tencent.mobileqq.aio.input.adorn.c;
import com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextTalkbackDelegate;
import com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextVBDelegate;
import com.tencent.mobileqq.aio.input.edit.delegate.p;
import com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVBDelegate;
import com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVMDelegate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.publicaccount.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J<\u0010\r\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0006\b\u0000\u0012\u00020\u00020\tj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`\f0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J2\u0010\u0012\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\u000fj\u0002`\u00110\b2\u0006\u0010\u0007\u001a\u00020\u000eH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/publicaccount/inputadorn/a;", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "Lcom/tencent/qqnt/aio/publicaccount/viewbinding/a;", "Landroid/content/Context;", "context", "f", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "e", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "c", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements com.tencent.mobileqq.aio.input.adorn.a<com.tencent.qqnt.aio.publicaccount.viewbinding.a> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, Object> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return a.C7250a.a(this);
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public List<e<at.a, InputUIState, com.tencent.aio.api.runtime.a, c>> c(@NotNull c host) {
        List<e<at.a, InputUIState, com.tencent.aio.api.runtime.a, c>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) host);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new e[]{new p(host), new AIOSendMsgVMDelegate(host), new com.tencent.qqnt.aio.publicaccount.e(host)});
        return listOf;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return a.C7250a.b(this);
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, b, ? super com.tencent.qqnt.aio.publicaccount.viewbinding.a>> e(@NotNull b host) {
        List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, b, ? super com.tencent.qqnt.aio.publicaccount.viewbinding.a>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) host);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.c[]{new InputEditTextVBDelegate(host), new AIOSendMsgVBDelegate(host), new d(host), new InputEditTextTalkbackDelegate(host)});
        return listOf;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.aio.publicaccount.viewbinding.a b(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.aio.publicaccount.viewbinding.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new com.tencent.qqnt.aio.publicaccount.viewbinding.a(context);
    }
}
