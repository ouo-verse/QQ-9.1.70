package com.tencent.mobileqq.aio.chatfactory.publicaccount;

import android.os.Bundle;
import com.tencent.mobileqq.aio.shop.ShopPublicAccountAIOFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.factory.f;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/chatfactory/publicaccount/a;", "Lcom/tencent/qqnt/aio/factory/f;", "Lcom/tencent/qqnt/aio/factory/a;", "param", "", QZoneImageUtils.KEY_MATCH, "", "getAIOFactoryClassName", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a implements f {
    static IPatchRedirector $redirector_;

    public a() {
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
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Bundle a16 = param.a();
        if (a16 != null) {
            str = a16.getString("key_peerId");
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "u_2ZRcriDgt2a46svnxKPPMw")) {
            String name = ShopPublicAccountAIOFactory.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "ShopPublicAccountAIOFactory::class.java.name");
            return name;
        }
        String name2 = PublicAccountAIOFactory.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "PublicAccountAIOFactory::class.java.name");
        return name2;
    }

    @Override // com.tencent.qqnt.aio.factory.f
    public boolean match(@NotNull com.tencent.qqnt.aio.factory.a param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) param)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(param, "param");
        if (param.b() == 103) {
            return true;
        }
        return false;
    }
}
