package com.tencent.mobileqq.aio.notifyservice;

import at.e;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.mobileqq.aio.layout.d;
import com.tencent.mobileqq.aio.title.AIODefaultTitleContainerVB;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\b\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0005\u0018\u00010\u0004H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0014\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0013RG\u0010\u001b\u001a.\u0012\u0004\u0012\u00020\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0015j\u0016\u0012\u0004\u0012\u00020\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005`\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2 = {"com/tencent/mobileqq/aio/notifyservice/NotifyServiceAIOFactory$buildBusinessLevel$1", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/mobileqq/aio/notifyservice/input/a;", "j", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "buildBusinessVB", "Lcom/tencent/aio/api/b;", "getLayoutDelegate", "Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVB;", "a", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVB;", "mTitleVB", "b", "l", "()Lcom/tencent/mobileqq/aio/notifyservice/input/a;", "mInputVB", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/aio/layout/d;", "Lkotlin/collections/HashMap;", "c", "k", "()Ljava/util/HashMap;", "mChildVB", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class NotifyServiceAIOFactory$buildBusinessLevel$1 implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTitleVB;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mInputVB;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mChildVB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotifyServiceAIOFactory$buildBusinessLevel$1() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(NotifyServiceAIOFactory$buildBusinessLevel$1$mTitleVB$2.INSTANCE);
            this.mTitleVB = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(NotifyServiceAIOFactory$buildBusinessLevel$1$mInputVB$2.INSTANCE);
            this.mInputVB = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<d, com.tencent.aio.base.mvvm.a<?, ?>>>() { // from class: com.tencent.mobileqq.aio.notifyservice.NotifyServiceAIOFactory$buildBusinessLevel$1$mChildVB$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NotifyServiceAIOFactory$buildBusinessLevel$1.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final HashMap<d, com.tencent.aio.base.mvvm.a<?, ?>> invoke() {
                    AIODefaultTitleContainerVB m3;
                    com.tencent.mobileqq.aio.notifyservice.input.a l3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    HashMap<d, com.tencent.aio.base.mvvm.a<?, ?>> hashMap = new HashMap<>();
                    NotifyServiceAIOFactory$buildBusinessLevel$1 notifyServiceAIOFactory$buildBusinessLevel$1 = NotifyServiceAIOFactory$buildBusinessLevel$1.this;
                    d.e eVar = d.e.f189939b;
                    m3 = notifyServiceAIOFactory$buildBusinessLevel$1.m();
                    hashMap.put(eVar, m3);
                    d.b bVar = d.b.f189936b;
                    l3 = notifyServiceAIOFactory$buildBusinessLevel$1.l();
                    hashMap.put(bVar, l3);
                    return hashMap;
                }
            });
            this.mChildVB = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final HashMap<d, com.tencent.aio.base.mvvm.a<?, ?>> k() {
        return (HashMap) this.mChildVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.aio.notifyservice.input.a l() {
        return (com.tencent.mobileqq.aio.notifyservice.input.a) this.mInputVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIODefaultTitleContainerVB m() {
        return (AIODefaultTitleContainerVB) this.mTitleVB.getValue();
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
    @Nullable
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> buildBusinessVB() {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(m());
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
    public com.tencent.aio.base.mvvm.a<? extends e, ? extends TopTipViewState> buildTopTipVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return f.a.f(this);
    }

    @Override // com.tencent.aio.api.factory.h
    @Nullable
    public com.tencent.aio.api.b getLayoutDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.api.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new com.tencent.mobileqq.aio.layout.a(k());
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.notifyservice.input.a buildInputVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.notifyservice.input.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return l();
    }
}
