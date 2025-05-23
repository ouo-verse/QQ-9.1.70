package com.tencent.qqnt.aio.api.impl;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.aio.factory.inputadorn.c;
import com.tencent.mobileqq.aio.helper.provider.C2CAIOHelperProvider;
import com.tencent.mobileqq.aio.helper.provider.GroupAIOHelperProvider;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.TemplateMsgPreloader;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.api.IPreloadUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/PreloadUtilsImpl;", "Lcom/tencent/qqnt/aio/api/IPreloadUtils;", "()V", "enableHelperClassPreload", "", "getEnableHelperClassPreload", "()Z", "enableHelperClassPreload$delegate", "Lkotlin/Lazy;", "helperClassPreload", "", "preload", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class PreloadUtilsImpl implements IPreloadUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: enableHelperClassPreload$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy enableHelperClassPreload;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/api/impl/PreloadUtilsImpl$a", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "", "getTag", "Lat/a;", "t", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements com.tencent.mobileqq.aio.input.adorn.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(@Nullable at.a t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16);
            }
        }

        @Override // com.tencent.mobileqq.aio.input.adorn.b
        @NotNull
        public String getTag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "";
        }
    }

    public PreloadUtilsImpl() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(PreloadUtilsImpl$enableHelperClassPreload$2.INSTANCE);
            this.enableHelperClassPreload = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean getEnableHelperClassPreload() {
        return ((Boolean) this.enableHelperClassPreload.getValue()).booleanValue();
    }

    private final void helperClassPreload() {
        if (!getEnableHelperClassPreload()) {
            return;
        }
        AIOSession aIOSession = new AIOSession(new AIOContact(0, "", "", null, 8, null));
        Map<String, Function0<com.tencent.aio.main.businesshelper.h>> lifeCycleHelperCreator = new C2CAIOHelperProvider().getLifeCycleHelperCreator(new com.tencent.aio.api.help.a(aIOSession));
        if (lifeCycleHelperCreator != null) {
            Iterator<Map.Entry<String, Function0<com.tencent.aio.main.businesshelper.h>>> it = lifeCycleHelperCreator.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().invoke();
            }
        }
        Map<String, Function0<com.tencent.aio.main.businesshelper.h>> lifeCycleHelperCreator2 = new GroupAIOHelperProvider().getLifeCycleHelperCreator(new com.tencent.aio.api.help.a(aIOSession));
        if (lifeCycleHelperCreator2 != null) {
            Iterator<Map.Entry<String, Function0<com.tencent.aio.main.businesshelper.h>>> it5 = lifeCycleHelperCreator2.entrySet().iterator();
            while (it5.hasNext()) {
                it5.next().getValue().invoke();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preload$lambda$0(PreloadUtilsImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.helperClassPreload();
        new TemplateMsgPreloader().run();
    }

    @Override // com.tencent.qqnt.aio.api.IPreloadUtils
    public void preload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            c.b.f188793a.a(new a());
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.api.impl.af
                @Override // java.lang.Runnable
                public final void run() {
                    PreloadUtilsImpl.preload$lambda$0(PreloadUtilsImpl.this);
                }
            }, 16, null, true);
        }
    }
}
