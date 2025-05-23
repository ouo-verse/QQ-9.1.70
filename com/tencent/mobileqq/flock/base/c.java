package com.tencent.mobileqq.flock.base;

import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ'\u0010\u0006\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/flock/base/c;", "T", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "E", "Ljava/lang/Class;", "iocClass", "p", "(Ljava/lang/Class;)Ljava/lang/Object;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class c<T> extends Section<T> {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <E> E p(@Nullable Class<E> iocClass) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (E) iPatchRedirector.redirect((short) 5, (Object) this, (Object) iocClass);
        }
        return (E) RFWIocAbilityProvider.g().getIocInterface(iocClass, this.mRootView, null);
    }
}
