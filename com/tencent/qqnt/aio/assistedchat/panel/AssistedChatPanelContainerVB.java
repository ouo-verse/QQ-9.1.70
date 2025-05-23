package com.tencent.qqnt.aio.assistedchat.panel;

import android.view.View;
import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelContainerUIState;
import com.tencent.qqnt.aio.assistedchat.panel.c;
import com.tencent.qqnt.aio.assistedchat.panel.setting.AssistedChatPanelSettingVB;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 G2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u001a\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0003H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\u0019\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020&H\u0016\u00a2\u0006\u0004\b(\u0010)R0\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00030\u00010*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R$\u00102\u001a\u0012\u0012\u0004\u0012\u00020\f0.j\b\u0012\u0004\u0012\u00020\f`/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u00109\u001a\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "Lpz0/b;", "", ICustomDataEditor.NUMBER_PARAM_1, "", "Lcom/tencent/qqnt/aio/assistedchat/panel/k;", "subPanelItems", "e1", "q1", "", "subPanelId", "f1", "l1", "k1", "o1", "", "i1", "j1", "()Ljava/lang/Integer;", "visibility", "p1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "bindViewAndData", "state", "m1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isInMultiWindowMode", "Y", "(Z)Ljava/lang/Integer;", "", "d", "Ljava/util/Map;", "subPanelVBMap", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "e", "Ljava/util/HashSet;", "subPanelShownSet", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/b;", "f", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/b;", "panelExtendHelper", "Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingVB;", tl.h.F, "Lkotlin/Lazy;", "h1", "()Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingVB;", "settingVB", "i", "Z", "isSettingShown", "Lcom/tencent/qqnt/aio/assistedchat/panel/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g1", "()Lcom/tencent/qqnt/aio/assistedchat/panel/i;", "containerWrapper", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatPanelContainerVB extends com.tencent.aio.base.mvvm.a<at.c, PanelUIState> implements pz0.b {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, com.tencent.aio.base.mvvm.a<? extends at.c, ? extends PanelUIState>> subPanelVBMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<Integer> subPanelShownSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.assistedchat.panel.extend.b panelExtendHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy settingVB;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isSettingShown;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy containerWrapper;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelContainerVB$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58908);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatPanelContainerVB() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.subPanelVBMap = new LinkedHashMap();
        this.subPanelShownSet = new HashSet<>();
        lazy = LazyKt__LazyJVMKt.lazy(AssistedChatPanelContainerVB$settingVB$2.INSTANCE);
        this.settingVB = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<i>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelContainerVB$containerWrapper$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerVB$containerWrapper$2$a", "Lcom/tencent/qqnt/aio/assistedchat/panel/p;", "", "panelId", "Landroid/view/View;", "a", "", "c", "b", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes23.dex */
            public static final class a implements p {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ AssistedChatPanelContainerVB f349137a;

                a(AssistedChatPanelContainerVB assistedChatPanelContainerVB) {
                    this.f349137a = assistedChatPanelContainerVB;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) assistedChatPanelContainerVB);
                    }
                }

                @Override // com.tencent.qqnt.aio.assistedchat.panel.p
                @NotNull
                public View a(int panelId) {
                    Map map;
                    View hostView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        map = this.f349137a.subPanelVBMap;
                        com.tencent.aio.base.mvvm.a aVar = (com.tencent.aio.base.mvvm.a) map.get(Integer.valueOf(panelId));
                        if (aVar == null || (hostView = aVar.getHostView()) == null) {
                            return new View(this.f349137a.getMContext());
                        }
                        return hostView;
                    }
                    return (View) iPatchRedirector.redirect((short) 2, (Object) this, panelId);
                }

                @Override // com.tencent.qqnt.aio.assistedchat.panel.p
                public void b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                        this.f349137a.p1(0);
                    } else {
                        iPatchRedirector.redirect((short) 4, (Object) this);
                    }
                }

                @Override // com.tencent.qqnt.aio.assistedchat.panel.p
                public void c(int panelId) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        this.f349137a.f1(panelId);
                    } else {
                        iPatchRedirector.redirect((short) 3, (Object) this, panelId);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatPanelContainerVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new i(new a(AssistedChatPanelContainerVB.this)) : (i) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.containerWrapper = lazy2;
    }

    private final void e1(List<k> subPanelItems) {
        for (k kVar : subPanelItems) {
            com.tencent.aio.base.mvvm.a<? extends at.c, ? extends PanelUIState> a16 = m.f349196a.a(kVar.a());
            this.subPanelVBMap.put(Integer.valueOf(kVar.a()), a16);
            com.tencent.mvi.mvvm.framework.b.a(this, a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1(int subPanelId) {
        sendIntent(new c.a(subPanelId));
        com.tencent.qqnt.aio.assistedchat.panel.subpanel.n nVar = null;
        if (this.subPanelShownSet.contains(Integer.valueOf(subPanelId))) {
            QLog.d("AssistedChatPanelContainerVB", 2, "dispatchSubPanelShowState subPanelId=" + subPanelId);
            com.tencent.mvi.mvvm.b bVar = this.subPanelVBMap.get(Integer.valueOf(subPanelId));
            if (bVar instanceof com.tencent.qqnt.aio.assistedchat.panel.subpanel.n) {
                nVar = (com.tencent.qqnt.aio.assistedchat.panel.subpanel.n) bVar;
            }
            if (nVar != null) {
                nVar.b0(false);
                return;
            }
            return;
        }
        QLog.d("AssistedChatPanelContainerVB", 2, "dispatchSubPanelShowState subPanelId=" + subPanelId + " first");
        this.subPanelShownSet.add(Integer.valueOf(subPanelId));
        com.tencent.mvi.mvvm.b bVar2 = this.subPanelVBMap.get(Integer.valueOf(subPanelId));
        if (bVar2 instanceof com.tencent.qqnt.aio.assistedchat.panel.subpanel.n) {
            nVar = (com.tencent.qqnt.aio.assistedchat.panel.subpanel.n) bVar2;
        }
        if (nVar != null) {
            nVar.b0(true);
        }
    }

    private final i g1() {
        return (i) this.containerWrapper.getValue();
    }

    private final AssistedChatPanelSettingVB h1() {
        return (AssistedChatPanelSettingVB) this.settingVB.getValue();
    }

    private final String i1() {
        f fVar;
        j p16;
        String a16;
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel instanceof f) {
            fVar = (f) mUIModel;
        } else {
            fVar = null;
        }
        if (fVar == null || (p16 = fVar.p()) == null || (a16 = p16.a()) == null) {
            return "";
        }
        return a16;
    }

    private final Integer j1() {
        f fVar;
        j p16;
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel instanceof f) {
            fVar = (f) mUIModel;
        } else {
            fVar = null;
        }
        if (fVar == null || (p16 = fVar.p()) == null) {
            return null;
        }
        return Integer.valueOf(p16.b());
    }

    private final void k1() {
        QLog.d("AssistedChatPanelContainerVB", 4, "handlePanelHide");
        g1().m(false);
        com.tencent.qqnt.aio.assistedchat.panel.extend.b bVar = this.panelExtendHelper;
        if (bVar != null) {
            bVar.o(false);
        }
    }

    private final void l1() {
        QLog.d("AssistedChatPanelContainerVB", 4, "handlePanelShow");
        g1().m(true);
        if (this.panelExtendHelper == null) {
            o1();
        }
        com.tencent.qqnt.aio.assistedchat.panel.extend.b bVar = this.panelExtendHelper;
        if (bVar != null) {
            bVar.o(true);
        }
    }

    private final void n1() {
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        f fVar;
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (g16 = aVar.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            FrameworkVM mUIModel2 = getMUIModel();
            j jVar = null;
            if (mUIModel2 instanceof f) {
                fVar = (f) mUIModel2;
            } else {
                fVar = null;
            }
            if (fVar != null) {
                jVar = fVar.p();
            }
            List<k> a16 = l.f349194a.a(c16.e()).a(c16, jVar);
            e1(a16);
            g1().o(a16);
        }
    }

    private final void o1() {
        FrameworkVM mUIModel;
        com.tencent.aio.api.runtime.a aVar;
        if (this.panelExtendHelper == null && (mUIModel = getMUIModel()) != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null) {
            this.panelExtendHelper = new com.tencent.qqnt.aio.assistedchat.panel.extend.b(aVar);
        }
        com.tencent.qqnt.aio.assistedchat.panel.extend.b bVar = this.panelExtendHelper;
        if (bVar != null) {
            bVar.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1(int visibility) {
        if (visibility == 0) {
            if (!this.isSettingShown) {
                addChildVB(h1());
            }
            this.isSettingShown = true;
        } else {
            if (this.isSettingShown) {
                removeChildVB(h1());
            }
            this.isSettingShown = false;
        }
    }

    private final void q1() {
        Integer j16 = j1();
        int d16 = g1().d();
        if (j16 != null && j16.intValue() != d16) {
            g1().n(j16.intValue());
        } else if (d16 >= 0) {
            f1(d16);
        }
    }

    @Override // pz0.b
    @Nullable
    public Integer Y(boolean isInMultiWindowMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Integer) iPatchRedirector.redirect((short) 8, (Object) this, isInMultiWindowMode);
        }
        return Integer.valueOf(com.tencent.qqnt.aio.utils.l.b(com.tencent.luggage.wxa.rf.g.CTRL_INDEX));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        com.tencent.aio.api.runtime.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.bindViewAndData();
        sendIntent(c.b.f349150d);
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null) {
            g1().h(aVar);
            g1().l(i1());
        }
        n1();
        q1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<at.c, PanelUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new f();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull PanelUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AssistedChatPanelContainerUIState.PanelShowUIState) {
            l1();
        } else if (state instanceof AssistedChatPanelContainerUIState.PanelHideUIState) {
            k1();
        } else if (state instanceof AssistedChatPanelContainerUIState.SetSettingPanelVisibility) {
            p1(((AssistedChatPanelContainerUIState.SetSettingPanelVisibility) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        if (QLog.isDevelopLevel()) {
            QLog.d("AssistedChatPanelContainerVB", 4, "onCreateView");
        }
        return g1().i(createViewParams.a());
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        this.subPanelVBMap.clear();
        this.subPanelShownSet.clear();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        QLog.d("AssistedChatPanelContainerVB", 4, "onReuseView");
        sendIntent(c.b.f349150d);
        g1().l(i1());
        this.subPanelShownSet.clear();
        q1();
    }
}
