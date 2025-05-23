package com.tencent.mobileqq.aio.shop;

import com.tencent.aio.api.factory.f;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.aio.layout.d;
import com.tencent.mobileqq.aio.shop.api.IShopAIOApi;
import com.tencent.mobileqq.aio.toppopup.AIOTopPopupContainerVB;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\u0016RG\u0010\u001e\u001a.\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0018j\u0016\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005`\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001f"}, d2 = {"com/tencent/mobileqq/aio/shop/ShopPublicAccountAIOFactory$buildBusinessLevel$1", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/mobileqq/aio/chatfactory/publicaccount/input/a;", "k", "", "Lcom/tencent/aio/base/mvvm/a;", "buildBusinessVB", "Lcom/tencent/mobileqq/aio/layout/a;", "l", "a", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/aio/chatfactory/publicaccount/input/a;", "mInputVB", "Lcom/tencent/mobileqq/aio/shop/f;", "b", "o", "()Lcom/tencent/mobileqq/aio/shop/f;", "mTitleVB", "Lcom/tencent/mobileqq/aio/toppopup/AIOTopPopupContainerVB;", "c", "p", "()Lcom/tencent/mobileqq/aio/toppopup/AIOTopPopupContainerVB;", "mTopPopupVB", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/aio/layout/d;", "Lkotlin/collections/HashMap;", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/HashMap;", "mChildVB", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ShopPublicAccountAIOFactory$buildBusinessLevel$1 implements com.tencent.aio.api.factory.f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mInputVB;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTitleVB;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTopPopupVB;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mChildVB;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/shop/ShopPublicAccountAIOFactory$buildBusinessLevel$1$a", "Lcom/tencent/mobileqq/aio/layout/c;", "", "parentLeft", "parentTop", "parentRight", "parentBottom", "", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mobileqq.aio.layout.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShopPublicAccountAIOFactory$buildBusinessLevel$1.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.layout.c
        public void a(int parentLeft, int parentTop, int parentRight, int parentBottom) {
            int inputBarHeight;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(parentLeft), Integer.valueOf(parentTop), Integer.valueOf(parentRight), Integer.valueOf(parentBottom));
                return;
            }
            if (((IShopAIOApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IShopAIOApi.class)).getQQShopIs2Tab()) {
                inputBarHeight = com.tencent.qqnt.util.view.b.f362999a.a(60.0f);
            } else {
                inputBarHeight = ShopPublicAccountAIOFactory$buildBusinessLevel$1.this.n().getInputBarHeight();
            }
            ShopPublicAccountAIOFactory$buildBusinessLevel$1.this.n().sendIntent(new f.c(parentLeft, parentBottom - inputBarHeight, parentRight, parentBottom));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShopPublicAccountAIOFactory$buildBusinessLevel$1() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(ShopPublicAccountAIOFactory$buildBusinessLevel$1$mInputVB$2.INSTANCE);
            this.mInputVB = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(ShopPublicAccountAIOFactory$buildBusinessLevel$1$mTitleVB$2.INSTANCE);
            this.mTitleVB = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(ShopPublicAccountAIOFactory$buildBusinessLevel$1$mTopPopupVB$2.INSTANCE);
            this.mTopPopupVB = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>>>() { // from class: com.tencent.mobileqq.aio.shop.ShopPublicAccountAIOFactory$buildBusinessLevel$1$mChildVB$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShopPublicAccountAIOFactory$buildBusinessLevel$1.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>> invoke() {
                    f o16;
                    AIOTopPopupContainerVB p16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>> hashMap = new HashMap<>();
                    ShopPublicAccountAIOFactory$buildBusinessLevel$1 shopPublicAccountAIOFactory$buildBusinessLevel$1 = ShopPublicAccountAIOFactory$buildBusinessLevel$1.this;
                    hashMap.put(d.b.f189936b, shopPublicAccountAIOFactory$buildBusinessLevel$1.n());
                    d.e eVar = d.e.f189939b;
                    o16 = shopPublicAccountAIOFactory$buildBusinessLevel$1.o();
                    hashMap.put(eVar, o16);
                    d.f fVar = d.f.f189940b;
                    p16 = shopPublicAccountAIOFactory$buildBusinessLevel$1.p();
                    hashMap.put(fVar, p16);
                    return hashMap;
                }
            });
            this.mChildVB = lazy4;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>> m() {
        return (HashMap) this.mChildVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.aio.chatfactory.publicaccount.input.a n() {
        return (com.tencent.mobileqq.aio.chatfactory.publicaccount.input.a) this.mInputVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f o() {
        return (f) this.mTitleVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIOTopPopupContainerVB p() {
        return (AIOTopPopupContainerVB) this.mTopPopupVB.getValue();
    }

    @Override // com.tencent.aio.api.factory.f
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return f.a.a(this);
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<?, ?>> buildBusinessVB() {
        List<com.tencent.aio.base.mvvm.a<?, ?>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{p(), o()});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.aio.api.factory.f
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return f.a.d(this);
    }

    @Override // com.tencent.aio.api.factory.f
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return f.a.e(this);
    }

    @Override // com.tencent.aio.api.factory.f
    @Nullable
    public com.tencent.aio.base.mvvm.a<? extends at.e, ? extends TopTipViewState> buildTopTipVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return f.a.f(this);
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.chatfactory.publicaccount.input.a buildInputVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.chatfactory.publicaccount.input.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return n();
    }

    @Override // com.tencent.aio.api.factory.h
    @NotNull
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.layout.a getLayoutDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.layout.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        com.tencent.mobileqq.aio.layout.a aVar = new com.tencent.mobileqq.aio.layout.a(m());
        aVar.f(new a());
        return aVar;
    }
}
