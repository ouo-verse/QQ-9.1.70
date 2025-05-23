package com.tencent.aio.stranger.impl.factory.supplier;

import android.os.Bundle;
import com.tencent.aio.stranger.impl.factory.CRMAIOFactory;
import com.tencent.aio.stranger.impl.factory.CRMExtAIOFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.factory.f;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/stranger/impl/factory/supplier/b;", "Lcom/tencent/qqnt/aio/factory/f;", "Lcom/tencent/qqnt/aio/factory/a;", "param", "", QZoneImageUtils.KEY_MATCH, "", "getAIOFactoryClassName", "<init>", "()V", "a", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class b implements com.tencent.qqnt.aio.factory.f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/stranger/impl/factory/supplier/b$a;", "", "", "QIDIAN_EXT", "I", "QIDIAN_MASTER", "", "QIDIAN_TYPE", "Ljava/lang/String;", "<init>", "()V", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aio.stranger.impl.factory.supplier.b$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35034);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.factory.f
    public boolean cacheAble() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return f.a.a(this);
    }

    @Override // com.tencent.qqnt.aio.factory.f
    @NotNull
    public String getAIOFactoryClassName(@NotNull com.tencent.qqnt.aio.factory.a param) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Bundle a16 = param.a();
        if (a16 != null) {
            num = Integer.valueOf(a16.getInt(AppConstants.Key.QIDIAN_TYPE));
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 16) {
            String name = CRMAIOFactory.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "CRMAIOFactory::class.java.name");
            return name;
        }
        if (num != null && num.intValue() == 4) {
            String name2 = CRMExtAIOFactory.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "CRMExtAIOFactory::class.java.name");
            return name2;
        }
        String name3 = CRMExtAIOFactory.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "CRMExtAIOFactory::class.java.name");
        return name3;
    }

    @Override // com.tencent.qqnt.aio.factory.f
    public boolean match(@NotNull com.tencent.qqnt.aio.factory.a param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) param)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(param, "param");
        if (param.b() == 102) {
            return true;
        }
        return false;
    }
}
