package com.tencent.mobileqq.aio.factory;

import com.tencent.aio.api.factory.f;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.input.AIOInputContainerVB;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.aio.layout.d;
import com.tencent.mobileqq.aio.shortcurtbar.AIOShortcutBarVB;
import com.tencent.mobileqq.aio.title.AIODefaultTitleContainerVB;
import com.tencent.mobileqq.aio.toppopup.AIOTopPopupContainerVB;
import com.tencent.mobileqq.aio.toptip.AIOTopTipVB;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\b\u0002\u00101\u001a\u0006\u0012\u0002\b\u000300\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001b\u0010\u0011\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010#\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010'RG\u0010/\u001a.\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0)j\u0016\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t`+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/AIOThirdLevelFactory;", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/mobileqq/aio/input/AIOInputContainerVB;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVB;", "o", "Lcom/tencent/mobileqq/aio/toptip/AIOTopTipVB;", "p", "", "Lcom/tencent/aio/base/mvvm/a;", "buildBusinessVB", "Lcom/tencent/mobileqq/aio/layout/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a", "Lkotlin/Lazy;", "t", "()Lcom/tencent/mobileqq/aio/input/AIOInputContainerVB;", "mInputVB", "Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVB;", "b", "v", "()Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVB;", "mTitleVB", "c", "u", "()Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVB;", "mShortCutVB", "Lcom/tencent/mobileqq/aio/toppopup/AIOTopPopupContainerVB;", "d", "w", "()Lcom/tencent/mobileqq/aio/toppopup/AIOTopPopupContainerVB;", "mTopPopupVB", "e", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/aio/toptip/AIOTopTipVB;", "mTopTipVB", "Lcom/tencent/mobileqq/aio/input/placeholder/a;", "f", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/aio/input/placeholder/a;", "mInputPlaceholderVB", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/aio/layout/d;", "Lkotlin/collections/HashMap;", "g", "r", "()Ljava/util/HashMap;", "mChildVB", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "inputBarAdornApi", "<init>", "(Lcom/tencent/mobileqq/aio/input/adorn/a;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOThirdLevelFactory implements com.tencent.aio.api.factory.f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mInputVB;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTitleVB;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mShortCutVB;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTopPopupVB;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTopTipVB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mInputPlaceholderVB;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mChildVB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/factory/AIOThirdLevelFactory$a", "Lcom/tencent/mobileqq/aio/layout/c;", "", "left", "top", "right", "bottom", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements com.tencent.mobileqq.aio.layout.c {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.aio.layout.a f188774b;

        a(com.tencent.mobileqq.aio.layout.a aVar) {
            this.f188774b = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOThirdLevelFactory.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.aio.layout.c
        public void a(int left, int top, int right, int bottom) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
                return;
            }
            int inputBarHeight = AIOThirdLevelFactory.this.t().getInputBarHeight();
            if (AIOThirdLevelFactory.this.u().getVisibility() == 0) {
                inputBarHeight += AIOThirdLevelFactory.this.u().g1();
            }
            AIOThirdLevelFactory.this.t().sendIntent(new f.g(this.f188774b.e()));
            AIOThirdLevelFactory.this.t().sendIntent(new f.c(left, bottom - inputBarHeight, right, bottom));
        }
    }

    public AIOThirdLevelFactory() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this);
    }

    private final HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>> r() {
        return (HashMap) this.mChildVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.aio.input.placeholder.a s() {
        return (com.tencent.mobileqq.aio.input.placeholder.a) this.mInputPlaceholderVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIOInputContainerVB t() {
        return (AIOInputContainerVB) this.mInputVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIOShortcutBarVB u() {
        return (AIOShortcutBarVB) this.mShortCutVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIODefaultTitleContainerVB v() {
        return (AIODefaultTitleContainerVB) this.mTitleVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIOTopPopupContainerVB w() {
        return (AIOTopPopupContainerVB) this.mTopPopupVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIOTopTipVB x() {
        return (AIOTopTipVB) this.mTopTipVB.getValue();
    }

    @Override // com.tencent.aio.api.factory.f
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return f.a.a(this);
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<?, ?>> buildBusinessVB() {
        List<com.tencent.aio.base.mvvm.a<?, ?>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{w(), v(), s()});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.aio.api.factory.f
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return f.a.e(this);
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public AIOInputContainerVB buildInputVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOInputContainerVB) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return t();
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public AIOShortcutBarVB buildShortcutBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AIOShortcutBarVB) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return u();
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public AIOTopTipVB buildTopTipVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIOTopTipVB) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return x();
    }

    @Override // com.tencent.aio.api.factory.h
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.layout.a getLayoutDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.aio.layout.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        com.tencent.mobileqq.aio.layout.a aVar = new com.tencent.mobileqq.aio.layout.a(r());
        aVar.f(new a(aVar));
        return aVar;
    }

    public AIOThirdLevelFactory(@NotNull final com.tencent.mobileqq.aio.input.adorn.a<?> inputBarAdornApi) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Intrinsics.checkNotNullParameter(inputBarAdornApi, "inputBarAdornApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputBarAdornApi);
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIOInputContainerVB>(inputBarAdornApi) { // from class: com.tencent.mobileqq.aio.factory.AIOThirdLevelFactory$mInputVB$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.aio.input.adorn.a<?> $inputBarAdornApi;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$inputBarAdornApi = inputBarAdornApi;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) inputBarAdornApi);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOInputContainerVB invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new AIOInputContainerVB(this.$inputBarAdornApi, true) : (AIOInputContainerVB) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mInputVB = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIOThirdLevelFactory$mTitleVB$2.INSTANCE);
        this.mTitleVB = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(AIOThirdLevelFactory$mShortCutVB$2.INSTANCE);
        this.mShortCutVB = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(AIOThirdLevelFactory$mTopPopupVB$2.INSTANCE);
        this.mTopPopupVB = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(AIOThirdLevelFactory$mTopTipVB$2.INSTANCE);
        this.mTopTipVB = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(AIOThirdLevelFactory$mInputPlaceholderVB$2.INSTANCE);
        this.mInputPlaceholderVB = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>>>() { // from class: com.tencent.mobileqq.aio.factory.AIOThirdLevelFactory$mChildVB$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOThirdLevelFactory.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>> invoke() {
                AIODefaultTitleContainerVB v3;
                AIOTopPopupContainerVB w3;
                AIOTopTipVB x16;
                com.tencent.mobileqq.aio.input.placeholder.a s16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>> hashMap = new HashMap<>();
                AIOThirdLevelFactory aIOThirdLevelFactory = AIOThirdLevelFactory.this;
                hashMap.put(d.b.f189936b, aIOThirdLevelFactory.t());
                d.e eVar = d.e.f189939b;
                v3 = aIOThirdLevelFactory.v();
                hashMap.put(eVar, v3);
                hashMap.put(d.C7289d.f189938b, aIOThirdLevelFactory.u());
                d.f fVar = d.f.f189940b;
                w3 = aIOThirdLevelFactory.w();
                hashMap.put(fVar, w3);
                d.g gVar = d.g.f189941b;
                x16 = aIOThirdLevelFactory.x();
                hashMap.put(gVar, x16);
                d.c cVar = d.c.f189937b;
                s16 = aIOThirdLevelFactory.s();
                hashMap.put(cVar, s16);
                return hashMap;
            }
        });
        this.mChildVB = lazy7;
    }

    public /* synthetic */ AIOThirdLevelFactory(com.tencent.mobileqq.aio.input.adorn.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new com.tencent.mobileqq.aio.factory.inputadorn.c() : aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
