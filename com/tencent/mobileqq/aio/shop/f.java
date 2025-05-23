package com.tencent.mobileqq.aio.shop;

import android.view.View;
import com.tencent.mobileqq.aio.shop.api.IShopAIOApi;
import com.tencent.mobileqq.aio.title.AIODefaultTitleContainerVB;
import com.tencent.mobileqq.aio.title.AIODefaultTitleContainerVM;
import com.tencent.mobileqq.aio.title.AIOTitleContainerUIState;
import com.tencent.mobileqq.aio.title.AIOTitleVB;
import com.tencent.mobileqq.aio.title.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/shop/f;", "Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVB;", "Landroid/view/View;", "hostView", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/mobileqq/aio/title/l;", "Lcom/tencent/mobileqq/aio/title/AIOTitleContainerUIState;", "e1", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f extends AIODefaultTitleContainerVB {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.title.AIODefaultTitleContainerVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<l, AIOTitleContainerUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new AIODefaultTitleContainerVM();
    }

    @Override // com.tencent.mobileqq.aio.title.AIODefaultTitleContainerVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        if (!((IShopAIOApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IShopAIOApi.class)).getQQShopIs2Tab()) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new com.tencent.mobileqq.aio.reserve1.blur.d(), new com.tencent.mobileqq.aio.reserve1.mask.b(), new AIOTitleVB()});
            return listOf;
        }
        return c.f193705a.a();
    }
}
