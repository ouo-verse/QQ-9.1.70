package com.tencent.qqnt.contacts.data.converter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.contacts.data.f;
import com.tencent.qqnt.contacts.data.g;
import com.tencent.qqnt.contacts.data.j;
import com.tencent.qqnt.kernel.nativeinterface.GroupSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/contacts/data/converter/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSimpleInfo;", "Lcom/tencent/qqnt/contacts/data/f;", "model", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "b", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f355838a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34927);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f355838a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public f a(@NotNull GroupSimpleInfo model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        long j3 = model.groupCode;
        String str = model.groupName;
        Intrinsics.checkNotNullExpressionValue(str, "model.groupName");
        return new g(j3, str, "");
    }

    @NotNull
    public final f b(@NotNull MemberInfo model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        String str = model.uid;
        Intrinsics.checkNotNullExpressionValue(str, "model.uid");
        String str2 = model.nick;
        Intrinsics.checkNotNullExpressionValue(str2, "model.nick");
        return new j(str, str2, "", model.uin);
    }
}
