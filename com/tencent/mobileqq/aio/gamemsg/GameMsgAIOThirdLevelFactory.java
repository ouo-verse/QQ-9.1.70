package com.tencent.mobileqq.aio.gamemsg;

import com.tencent.aio.api.factory.f;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001b\u0010\u0013\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001c\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010$R\u001b\u0010)\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010(RG\u00100\u001a.\u0012\u0004\u0012\u00020+\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b0*j\u0016\u0012\u0004\u0012\u00020+\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b`,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/aio/gamemsg/GameMsgAIOThirdLevelFactory;", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/mobileqq/aio/gamemsg/GameMsgAIOBottomBarVB;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/input/AIOInputContainerVB;", "o", "Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVB;", "p", "Lcom/tencent/mobileqq/aio/gamemsg/GameMsgAIOTopBarVB;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Lcom/tencent/aio/base/mvvm/a;", "buildBusinessVB", "Lcom/tencent/mobileqq/aio/layout/a;", "r", "a", "Lkotlin/Lazy;", "u", "()Lcom/tencent/mobileqq/aio/input/AIOInputContainerVB;", "mInputVB", "Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVB;", "b", "w", "()Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVB;", "mTitleVB", "c", "v", "()Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVB;", "mShortCutVB", "d", "y", "()Lcom/tencent/mobileqq/aio/gamemsg/GameMsgAIOTopBarVB;", "mTopTipsVB", "Lcom/tencent/mobileqq/aio/toppopup/AIOTopPopupContainerVB;", "e", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/aio/toppopup/AIOTopPopupContainerVB;", "mTopPopupVB", "f", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/aio/gamemsg/GameMsgAIOBottomBarVB;", "mBottomBarVB", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/aio/layout/d;", "Lkotlin/collections/HashMap;", "g", "t", "()Ljava/util/HashMap;", "mChildVB", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class GameMsgAIOThirdLevelFactory implements f {
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
    private final Lazy mTopTipsVB;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTopPopupVB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBottomBarVB;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mChildVB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/gamemsg/GameMsgAIOThirdLevelFactory$a", "Lcom/tencent/mobileqq/aio/layout/c;", "", "left", "top", "right", "bottom", "", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements com.tencent.mobileqq.aio.layout.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgAIOThirdLevelFactory.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.layout.c
        public void a(int left, int top, int right, int bottom) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
                return;
            }
            if (GameMsgAIOThirdLevelFactory.this.u().getVisibility() == 0) {
                i3 = GameMsgAIOThirdLevelFactory.this.u().getInputBarHeight();
            } else {
                i3 = 0;
            }
            if (GameMsgAIOThirdLevelFactory.this.v().getVisibility() == 0) {
                i16 = GameMsgAIOThirdLevelFactory.this.v().g1();
            }
            GameMsgAIOThirdLevelFactory.this.u().sendIntent(new f.c(left, bottom - ((i3 + i16) + GameMsgAIOThirdLevelFactory.this.s().b1()), right, bottom));
        }
    }

    public GameMsgAIOThirdLevelFactory() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(GameMsgAIOThirdLevelFactory$mInputVB$2.INSTANCE);
            this.mInputVB = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(GameMsgAIOThirdLevelFactory$mTitleVB$2.INSTANCE);
            this.mTitleVB = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(GameMsgAIOThirdLevelFactory$mShortCutVB$2.INSTANCE);
            this.mShortCutVB = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(GameMsgAIOThirdLevelFactory$mTopTipsVB$2.INSTANCE);
            this.mTopTipsVB = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(GameMsgAIOThirdLevelFactory$mTopPopupVB$2.INSTANCE);
            this.mTopPopupVB = lazy5;
            lazy6 = LazyKt__LazyJVMKt.lazy(GameMsgAIOThirdLevelFactory$mBottomBarVB$2.INSTANCE);
            this.mBottomBarVB = lazy6;
            lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<d, com.tencent.aio.base.mvvm.a<?, ?>>>() { // from class: com.tencent.mobileqq.aio.gamemsg.GameMsgAIOThirdLevelFactory$mChildVB$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GameMsgAIOThirdLevelFactory.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final HashMap<d, com.tencent.aio.base.mvvm.a<?, ?>> invoke() {
                    AIODefaultTitleContainerVB w3;
                    AIOTopPopupContainerVB x16;
                    GameMsgAIOTopBarVB y16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    HashMap<d, com.tencent.aio.base.mvvm.a<?, ?>> hashMap = new HashMap<>();
                    GameMsgAIOThirdLevelFactory gameMsgAIOThirdLevelFactory = GameMsgAIOThirdLevelFactory.this;
                    hashMap.put(d.b.f189936b, gameMsgAIOThirdLevelFactory.u());
                    d.e eVar = d.e.f189939b;
                    w3 = gameMsgAIOThirdLevelFactory.w();
                    hashMap.put(eVar, w3);
                    hashMap.put(d.C7289d.f189938b, gameMsgAIOThirdLevelFactory.v());
                    d.f fVar = d.f.f189940b;
                    x16 = gameMsgAIOThirdLevelFactory.x();
                    hashMap.put(fVar, x16);
                    d.g gVar = d.g.f189941b;
                    y16 = gameMsgAIOThirdLevelFactory.y();
                    hashMap.put(gVar, y16);
                    hashMap.put(d.a.f189935b, gameMsgAIOThirdLevelFactory.s());
                    return hashMap;
                }
            });
            this.mChildVB = lazy7;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GameMsgAIOBottomBarVB s() {
        return (GameMsgAIOBottomBarVB) this.mBottomBarVB.getValue();
    }

    private final HashMap<d, com.tencent.aio.base.mvvm.a<?, ?>> t() {
        return (HashMap) this.mChildVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIOInputContainerVB u() {
        return (AIOInputContainerVB) this.mInputVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIOShortcutBarVB v() {
        return (AIOShortcutBarVB) this.mShortCutVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIODefaultTitleContainerVB w() {
        return (AIODefaultTitleContainerVB) this.mTitleVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIOTopPopupContainerVB x() {
        return (AIOTopPopupContainerVB) this.mTopPopupVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GameMsgAIOTopBarVB y() {
        return (GameMsgAIOTopBarVB) this.mTopTipsVB.getValue();
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<?, ?>> buildBusinessVB() {
        List<com.tencent.aio.base.mvvm.a<?, ?>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{x(), w()});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.aio.api.factory.f
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return f.a.e(this);
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public GameMsgAIOBottomBarVB buildBottomBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GameMsgAIOBottomBarVB) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return s();
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public AIOInputContainerVB buildInputVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOInputContainerVB) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return u();
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public AIOShortcutBarVB buildShortcutBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AIOShortcutBarVB) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return v();
    }

    @Override // com.tencent.aio.api.factory.f
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public GameMsgAIOTopBarVB buildTopTipVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (GameMsgAIOTopBarVB) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return y();
    }

    @Override // com.tencent.aio.api.factory.h
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.layout.a getLayoutDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.aio.layout.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        com.tencent.mobileqq.aio.layout.a aVar = new com.tencent.mobileqq.aio.layout.a(t());
        aVar.f(new a());
        return aVar;
    }
}
