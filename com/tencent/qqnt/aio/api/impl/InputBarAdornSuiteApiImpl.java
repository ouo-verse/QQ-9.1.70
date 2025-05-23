package com.tencent.qqnt.aio.api.impl;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.aio.input.at.InputAtVBDelegate;
import com.tencent.mobileqq.aio.input.at.InputAtVMDelegate;
import com.tencent.mobileqq.aio.input.draft.InputDraftVMDelegate;
import com.tencent.mobileqq.aio.input.edit.delegate.AIOEditTextInitializeVBDelegate;
import com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextVBDelegate;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenVBDelegate;
import com.tencent.mobileqq.aio.input.fullscreen.entry.FullScreenBtnVBDelegate;
import com.tencent.mobileqq.aio.input.gag.InputGagVBDelegate;
import com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVBDelegate;
import com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVMDelegate;
import com.tencent.mobileqq.aio.zhitu.InputRightIconVMDelegate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.api.IInputBarAdornSuiteApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015JB\u0010\u000b\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u0007j\u0006\u0012\u0002\b\u0003`\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J@\u0010\u0010\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\rj\u0002`\u000f0\u00042\u0006\u0010\u0003\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J6\u0010\u0012\u001a \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u0007j\u0006\u0012\u0002\b\u0003`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J4\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\rj\u0002`\u000f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/InputBarAdornSuiteApiImpl;", "Lcom/tencent/qqnt/aio/api/IInputBarAdornSuiteApi;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "", "", "delegateIdList", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "getVBDelegateList", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "getVMDelegateList", "delegateId", "getVBDelegate", "getVMDelegate", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class InputBarAdornSuiteApiImpl implements IInputBarAdornSuiteApi {
    static IPatchRedirector $redirector_;

    public InputBarAdornSuiteApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IInputBarAdornSuiteApi
    @NotNull
    public com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ?> getVBDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.b host, int delegateId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.input.base.mvicompat.c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) host, delegateId);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189165b) {
            return new InputEditTextVBDelegate(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189166c) {
            return new AIOEditTextInitializeVBDelegate(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189167d) {
            return new AIOSendMsgVBDelegate(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189168e) {
            return new com.tencent.mobileqq.aio.input.inputbar.compat.b(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189169f) {
            return new InputAtVBDelegate(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189170g) {
            return new com.tencent.mobileqq.aio.input.reply.h(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189171h) {
            return new com.tencent.mobileqq.aio.zhitu.d(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189172i) {
            return new InputGagVBDelegate(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189173j) {
            return new com.tencent.mobileqq.aio.input.simpleui.b(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189174k) {
            return new FullScreenVBDelegate(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189175l) {
            return new FullScreenBtnVBDelegate(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189176m) {
            return new com.tencent.mobileqq.aio.input.draft.b(host);
        }
        throw new IllegalArgumentException("VBDelegate not found, id=" + delegateId);
    }

    @Override // com.tencent.qqnt.aio.api.IInputBarAdornSuiteApi
    @NotNull
    public List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ?>> getVBDelegateList(@NotNull com.tencent.mobileqq.aio.input.adorn.b host, @NotNull List<Integer> delegateIdList) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) host, (Object) delegateIdList);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(delegateIdList, "delegateIdList");
        List<Integer> list = delegateIdList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getVBDelegate(host, ((Number) it.next()).intValue()));
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.api.IInputBarAdornSuiteApi
    @NotNull
    public com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c> getVMDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.c host, int delegateId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.input.base.mvicompat.e) iPatchRedirector.redirect((short) 5, (Object) this, (Object) host, delegateId);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189165b) {
            return new com.tencent.mobileqq.aio.input.edit.delegate.p(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189166c) {
            return new com.tencent.mobileqq.aio.input.edit.delegate.e(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189167d) {
            return new AIOSendMsgVMDelegate(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189168e) {
            return new com.tencent.mobileqq.aio.input.inputbar.compat.d(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189169f) {
            return new InputAtVMDelegate(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189170g) {
            return new com.tencent.mobileqq.aio.input.reply.i(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189171h) {
            return new InputRightIconVMDelegate(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189172i) {
            return new com.tencent.mobileqq.aio.input.gag.e(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189173j) {
            return new com.tencent.mobileqq.aio.input.simpleui.c(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189174k) {
            return new com.tencent.mobileqq.aio.input.fullscreen.o(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189175l) {
            return new com.tencent.mobileqq.aio.input.fullscreen.entry.c(host);
        }
        if (delegateId == com.tencent.mobileqq.aio.input.adorn.d.f189176m) {
            return new InputDraftVMDelegate(host);
        }
        throw new IllegalArgumentException("VMDelegate not found, id=" + delegateId);
    }

    @Override // com.tencent.qqnt.aio.api.IInputBarAdornSuiteApi
    @NotNull
    public List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> getVMDelegateList(@NotNull com.tencent.mobileqq.aio.input.adorn.c host, @NotNull List<Integer> delegateIdList) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) host, (Object) delegateIdList);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(delegateIdList, "delegateIdList");
        List<Integer> list = delegateIdList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getVMDelegate(host, ((Number) it.next()).intValue()));
        }
        return arrayList;
    }
}
