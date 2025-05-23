package com.tencent.mobileqq.aio.factory;

import com.tencent.aio.api.factory.f;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.mobileqq.aio.input.AIOInputContainerVB;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.aio.layout.d;
import com.tencent.mobileqq.aio.shortcurtbar.AIOShortcutBarVB;
import com.tencent.mobileqq.aio.title.AIODefaultTitleContainerVB;
import com.tencent.mobileqq.aio.toppopup.AIOTopPopupContainerVB;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u001b\u0010\u000f\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0018\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b%\u0010&RG\u0010.\u001a.\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00070(j\u0016\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007`*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\f\u001a\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/GroupAIOThirdLevelFactory;", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/mobileqq/aio/input/AIOInputContainerVB;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVB;", "o", "", "Lcom/tencent/aio/base/mvvm/a;", "buildBusinessVB", "Lcom/tencent/mobileqq/aio/layout/a;", "p", "a", "Lkotlin/Lazy;", "t", "()Lcom/tencent/mobileqq/aio/input/AIOInputContainerVB;", "mInputVB", "Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVB;", "b", "v", "()Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVB;", "mTitleVB", "c", "u", "()Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVB;", "mShortCutVB", "Lcom/tencent/mobileqq/aio/toppopup/AIOTopPopupContainerVB;", "d", "w", "()Lcom/tencent/mobileqq/aio/toppopup/AIOTopPopupContainerVB;", "mTopPopupVB", "Lcom/tencent/mobileqq/aio/thirdlevel/c;", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/aio/thirdlevel/c;", "mCenterContainerVB", "Lcom/tencent/mobileqq/aio/input/placeholder/a;", "f", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/aio/input/placeholder/a;", "mInputPlaceholderVB", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/aio/layout/d;", "Lkotlin/collections/HashMap;", "g", "r", "()Ljava/util/HashMap;", "mChildVB", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class GroupAIOThirdLevelFactory implements com.tencent.aio.api.factory.f {
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
    private final Lazy mCenterContainerVB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mInputPlaceholderVB;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mChildVB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/factory/GroupAIOThirdLevelFactory$a", "Lcom/tencent/mobileqq/aio/layout/c;", "", "left", "top", "right", "bottom", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements com.tencent.mobileqq.aio.layout.c {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.aio.layout.a f188784b;

        a(com.tencent.mobileqq.aio.layout.a aVar) {
            this.f188784b = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupAIOThirdLevelFactory.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.aio.layout.c
        public void a(int left, int top, int right, int bottom) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
                return;
            }
            int inputBarHeight = GroupAIOThirdLevelFactory.this.t().getInputBarHeight();
            if (GroupAIOThirdLevelFactory.this.u().getVisibility() == 0) {
                inputBarHeight += GroupAIOThirdLevelFactory.this.u().g1();
            }
            GroupAIOThirdLevelFactory.this.t().sendIntent(new f.g(this.f188784b.e()));
            GroupAIOThirdLevelFactory.this.t().sendIntent(new f.c(left, bottom - inputBarHeight, right, bottom));
        }
    }

    public GroupAIOThirdLevelFactory() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(GroupAIOThirdLevelFactory$mInputVB$2.INSTANCE);
            this.mInputVB = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(GroupAIOThirdLevelFactory$mTitleVB$2.INSTANCE);
            this.mTitleVB = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(GroupAIOThirdLevelFactory$mShortCutVB$2.INSTANCE);
            this.mShortCutVB = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(GroupAIOThirdLevelFactory$mTopPopupVB$2.INSTANCE);
            this.mTopPopupVB = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(GroupAIOThirdLevelFactory$mCenterContainerVB$2.INSTANCE);
            this.mCenterContainerVB = lazy5;
            lazy6 = LazyKt__LazyJVMKt.lazy(GroupAIOThirdLevelFactory$mInputPlaceholderVB$2.INSTANCE);
            this.mInputPlaceholderVB = lazy6;
            lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>>>() { // from class: com.tencent.mobileqq.aio.factory.GroupAIOThirdLevelFactory$mChildVB$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupAIOThirdLevelFactory.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>> invoke() {
                    AIODefaultTitleContainerVB v3;
                    AIOTopPopupContainerVB w3;
                    com.tencent.mobileqq.aio.thirdlevel.c q16;
                    com.tencent.mobileqq.aio.input.placeholder.a s16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>> hashMap = new HashMap<>();
                    GroupAIOThirdLevelFactory groupAIOThirdLevelFactory = GroupAIOThirdLevelFactory.this;
                    hashMap.put(d.b.f189936b, groupAIOThirdLevelFactory.t());
                    d.e eVar = d.e.f189939b;
                    v3 = groupAIOThirdLevelFactory.v();
                    hashMap.put(eVar, v3);
                    hashMap.put(d.C7289d.f189938b, groupAIOThirdLevelFactory.u());
                    d.f fVar = d.f.f189940b;
                    w3 = groupAIOThirdLevelFactory.w();
                    hashMap.put(fVar, w3);
                    d.h hVar = d.h.f189942b;
                    q16 = groupAIOThirdLevelFactory.q();
                    hashMap.put(hVar, q16);
                    d.c cVar = d.c.f189937b;
                    s16 = groupAIOThirdLevelFactory.s();
                    hashMap.put(cVar, s16);
                    return hashMap;
                }
            });
            this.mChildVB = lazy7;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.aio.thirdlevel.c q() {
        return (com.tencent.mobileqq.aio.thirdlevel.c) this.mCenterContainerVB.getValue();
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

    @Override // com.tencent.aio.api.factory.f
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return f.a.a(this);
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<?, ?>> buildBusinessVB() {
        List<com.tencent.aio.base.mvvm.a<?, ?>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{w(), v(), q(), s()});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
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
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public AIOInputContainerVB buildInputVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOInputContainerVB) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return t();
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public AIOShortcutBarVB buildShortcutBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOShortcutBarVB) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return u();
    }

    @Override // com.tencent.aio.api.factory.h
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.layout.a getLayoutDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.aio.layout.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.mobileqq.aio.layout.a aVar = new com.tencent.mobileqq.aio.layout.a(r());
        aVar.f(new a(aVar));
        return aVar;
    }
}
