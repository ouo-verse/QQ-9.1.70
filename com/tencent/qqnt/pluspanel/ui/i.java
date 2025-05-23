package com.tencent.qqnt.pluspanel.ui;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.pluspanel.data.PlusPanelUiState;
import com.tencent.qqnt.pluspanel.data.e;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 M2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0016\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016H\u0016J$\u0010\u001a\u001a\u00020\b2\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0018\u0010\"\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020 J\u0012\u0010#\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0003H\u0016J\u0006\u0010&\u001a\u00020\bJ\u0010\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u000fH\u0016J \u0010,\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000fH\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u000fH\u0016R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R&\u0010E\u001a\u0012\u0012\u0004\u0012\u00020A0@j\b\u0012\u0004\u0012\u00020A`B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006O"}, d2 = {"Lcom/tencent/qqnt/pluspanel/ui/i;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/pluspanel/data/e;", "Lcom/tencent/qqnt/pluspanel/data/PlusPanelUiState;", "Landroid/view/View$OnLongClickListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Landroid/view/View;", "root", "", "g1", "", "i1", "k1", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "e1", "l1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/base/mvvm/b;", "c1", "Lcom/tencent/mvi/mvvm/BaseVM;", "mUIModel", "afterCreateVM", "bindViewAndData", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "view", "", "elementId", "j1", NodeProps.ON_LONG_CLICK, "state", "f1", "d1", "position", "onPageSelected", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageScrollStateChanged", "d", "Landroid/view/View;", "mRoot", "Lcom/tencent/mobileqq/widget/QQViewPager;", "e", "Lcom/tencent/mobileqq/widget/QQViewPager;", "viewPager", "Lcom/tencent/qqnt/pluspanel/adapter/c;", "f", "Lcom/tencent/qqnt/pluspanel/adapter/c;", "adapter", "Lcom/tencent/qqnt/pluspanel/ui/PlusPanelRadioGroup;", tl.h.F, "Lcom/tencent/qqnt/pluspanel/ui/PlusPanelRadioGroup;", "radioGroup", "i", "Z", "mIsAnonymous", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/pluspanel/data/a;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "appDataLists", BdhLogUtil.LogTag.Tag_Conn, "I", "originPanelHeight", "D", "Lcom/tencent/aio/api/runtime/a;", "<init>", "()V", "E", "a", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class i extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.pluspanel.data.e, PlusPanelUiState> implements View.OnLongClickListener, ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int originPanelHeight;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mRoot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQViewPager viewPager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.pluspanel.adapter.c adapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private PlusPanelRadioGroup radioGroup;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAnonymous;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.qqnt.pluspanel.data.a> appDataLists;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/pluspanel/ui/i$a;", "", "", "RADIO_BUTTON_BOTTOM_MARGIN", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.ui.i$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45646);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.appDataLists = new ArrayList<>();
        }
    }

    private final int e1(com.tencent.aio.api.runtime.a aioContext) {
        h.b bVar;
        k k3 = aioContext.e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d);
        if (k3 instanceof h.b) {
            bVar = (h.b) k3;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            QLog.i("PlusPanelVB", 1, "[getCurPanelHeight]: result is null");
            return 0;
        }
        return bVar.b();
    }

    private final void g1(View root) {
        View findViewById = root.findViewById(R.id.icon_viewPager);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.icon_viewPager)");
        this.viewPager = (QQViewPager) findViewById;
        View findViewById2 = root.findViewById(R.id.f26050ch);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.plus_icon_group)");
        PlusPanelRadioGroup plusPanelRadioGroup = (PlusPanelRadioGroup) findViewById2;
        this.radioGroup = plusPanelRadioGroup;
        PlusPanelRadioGroup plusPanelRadioGroup2 = null;
        if (plusPanelRadioGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("radioGroup");
            plusPanelRadioGroup = null;
        }
        QQViewPager qQViewPager = this.viewPager;
        if (qQViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager = null;
        }
        plusPanelRadioGroup.b(qQViewPager);
        com.tencent.qqnt.pluspanel.adapter.c cVar = new com.tencent.qqnt.pluspanel.adapter.c(getMContext(), 0);
        this.adapter = cVar;
        cVar.l(new View.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.ui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.h1(i.this, view);
            }
        });
        com.tencent.qqnt.pluspanel.adapter.c cVar2 = this.adapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cVar2 = null;
        }
        cVar2.m(this);
        com.tencent.qqnt.pluspanel.adapter.c cVar3 = this.adapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cVar3 = null;
        }
        cVar3.m(this);
        QQViewPager qQViewPager2 = this.viewPager;
        if (qQViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager2 = null;
        }
        com.tencent.qqnt.pluspanel.adapter.c cVar4 = this.adapter;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cVar4 = null;
        }
        qQViewPager2.setAdapter(cVar4);
        QQViewPager qQViewPager3 = this.viewPager;
        if (qQViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager3 = null;
        }
        qQViewPager3.addOnPageChangeListener(this);
        PlusPanelRadioGroup plusPanelRadioGroup3 = this.radioGroup;
        if (plusPanelRadioGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("radioGroup");
            plusPanelRadioGroup3 = null;
        }
        ViewGroup.LayoutParams layoutParams = plusPanelRadioGroup3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.bottomMargin = ViewUtils.dip2px(19.0f);
        PlusPanelRadioGroup plusPanelRadioGroup4 = this.radioGroup;
        if (plusPanelRadioGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("radioGroup");
        } else {
            plusPanelRadioGroup2 = plusPanelRadioGroup4;
        }
        plusPanelRadioGroup2.setLayoutParams(layoutParams2);
        root.findViewById(R.id.j0s).setBackground(new ColorDrawable(getMContext().getColor(R.color.qui_common_border_light)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j1(view, "em_group_plus_application");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean i1() {
        AIOParam g16;
        AIOParam g17;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (g16 = aVar.g()) != null) {
            long a16 = su3.c.a(g16);
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 != null && (g17 = aVar2.g()) != null && (r16 = g17.r()) != null && (c16 = r16.c()) != null) {
                return ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(String.valueOf(a16), Integer.valueOf(c16.e()));
            }
        }
        return false;
    }

    private final void k1() {
        QQViewPager qQViewPager = this.viewPager;
        com.tencent.qqnt.pluspanel.adapter.c cVar = null;
        if (qQViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager = null;
        }
        int currentItem = qQViewPager.getCurrentItem();
        QLog.i("PlusPanelVB", 2, "page: " + currentItem);
        com.tencent.qqnt.pluspanel.adapter.c cVar2 = this.adapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            cVar = cVar2;
        }
        sendIntent(new e.c(cVar.f(currentItem)));
    }

    private final void l1() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null) {
            int e16 = e1(aVar);
            QLog.i("PlusPanelVB", 2, "resetPanelHeight cur: " + e16 + ", origin: " + this.originPanelHeight);
            if (e16 != this.originPanelHeight) {
                com.tencent.qqnt.pluspanel.adapter.c cVar = this.adapter;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    cVar = null;
                }
                cVar.i();
                this.originPanelHeight = e16;
            }
        }
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<com.tencent.qqnt.pluspanel.data.e, PlusPanelUiState, com.tencent.aio.api.runtime.a> mUIModel) {
        com.tencent.aio.api.runtime.a mContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) mUIModel);
            return;
        }
        super.afterCreateVM(mUIModel);
        if (mUIModel != null && (mContext = mUIModel.getMContext()) != null) {
            this.aioContext = mContext;
            this.originPanelHeight = e1(mContext);
            View view = null;
            if (i1()) {
                View view2 = this.mRoot;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRoot");
                } else {
                    view = view2;
                }
                view.setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg_robot);
                return;
            }
            View view3 = this.mRoot;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            } else {
                view = view3;
            }
            view.setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            sendIntent(e.a.f360417d);
            k1();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<com.tencent.qqnt.pluspanel.data.e, PlusPanelUiState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new com.tencent.qqnt.pluspanel.logic.e();
    }

    public final void d1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        int i3 = 0;
        for (Object obj : this.appDataLists) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.qqnt.pluspanel.data.a aVar = (com.tencent.qqnt.pluspanel.data.a) obj;
            HashMap hashMap = new HashMap();
            String h16 = aVar.h();
            if (h16 == null) {
                h16 = "";
            }
            hashMap.put("app_name", h16);
            hashMap.put("rank", String.valueOf(aVar.f()));
            hashMap.put("appid", String.valueOf(aVar.c()));
            com.tencent.mobileqq.aio.utils.b.t("em_group_plus_application", hashMap);
            i3 = i16;
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull PlusPanelUiState state) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        com.tencent.qqnt.pluspanel.adapter.c cVar = null;
        if (state instanceof PlusPanelUiState.FetchCompleted) {
            com.tencent.qqnt.pluspanel.adapter.c cVar2 = this.adapter;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                cVar2 = null;
            }
            PlusPanelUiState.FetchCompleted fetchCompleted = (PlusPanelUiState.FetchCompleted) state;
            cVar2.n(fetchCompleted.a());
            com.tencent.qqnt.pluspanel.adapter.c cVar3 = this.adapter;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                cVar3 = null;
            }
            cVar3.p(fetchCompleted.b());
            this.appDataLists = fetchCompleted.a();
            if (QLog.isColorLevel()) {
                ArrayList<com.tencent.qqnt.pluspanel.data.a> arrayList = this.appDataLists;
                if (arrayList != null) {
                    num = Integer.valueOf(arrayList.size());
                } else {
                    num = null;
                }
                com.tencent.qqnt.pluspanel.adapter.c cVar4 = this.adapter;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    cVar4 = null;
                }
                QLog.i("PlusPanelVB", 1, "handleUIState: appDataLists.size = " + num + ", adapter.count = " + Integer.valueOf(cVar4.getF373114d()));
            }
            com.tencent.qqnt.pluspanel.adapter.c cVar5 = this.adapter;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                cVar5 = null;
            }
            if (cVar5.getF373114d() > 1) {
                try {
                    PlusPanelRadioGroup plusPanelRadioGroup = this.radioGroup;
                    if (plusPanelRadioGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("radioGroup");
                        plusPanelRadioGroup = null;
                    }
                    com.tencent.qqnt.pluspanel.adapter.c cVar6 = this.adapter;
                    if (cVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        cVar6 = null;
                    }
                    plusPanelRadioGroup.c(cVar6.getF373114d());
                } catch (Exception e16) {
                    QLog.e("PlusPanelVB", 1, "error:" + e16.getMessage());
                }
                PlusPanelRadioGroup plusPanelRadioGroup2 = this.radioGroup;
                if (plusPanelRadioGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("radioGroup");
                    plusPanelRadioGroup2 = null;
                }
                plusPanelRadioGroup2.setVisibility(0);
            } else {
                PlusPanelRadioGroup plusPanelRadioGroup3 = this.radioGroup;
                if (plusPanelRadioGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("radioGroup");
                    plusPanelRadioGroup3 = null;
                }
                plusPanelRadioGroup3.setVisibility(4);
            }
            com.tencent.qqnt.pluspanel.adapter.c cVar7 = this.adapter;
            if (cVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                cVar7 = null;
            }
            cVar7.notifyDataSetChanged();
            if (this.mIsAnonymous) {
                return;
            }
            com.tencent.qqnt.pluspanel.adapter.c cVar8 = this.adapter;
            if (cVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                cVar8 = null;
            }
            int f373114d = cVar8.getF373114d();
            for (int i3 = 0; i3 < f373114d; i3++) {
                com.tencent.qqnt.pluspanel.adapter.c cVar9 = this.adapter;
                if (cVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    cVar9 = null;
                }
                cVar9.q(i3);
            }
            return;
        }
        if (state instanceof PlusPanelUiState.UpdateAnonymousPanel) {
            this.mIsAnonymous = ((PlusPanelUiState.UpdateAnonymousPanel) state).a();
            com.tencent.qqnt.pluspanel.adapter.c cVar10 = this.adapter;
            if (cVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                cVar = cVar10;
            }
            cVar.k(this.mIsAnonymous);
            sendIntent(e.d.f360420d);
        }
    }

    public final void j1(@Nullable View view, @NotNull String elementId) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) elementId);
            return;
        }
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (view != null) {
            obj = view.getTag();
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.qqnt.pluspanel.data.AppData");
        com.tencent.qqnt.pluspanel.data.a aVar = (com.tencent.qqnt.pluspanel.data.a) obj;
        HashMap hashMap = new HashMap();
        String h16 = aVar.h();
        if (h16 == null) {
            h16 = "";
        }
        hashMap.put("app_name", h16);
        hashMap.put("rank", String.valueOf(aVar.f()));
        hashMap.put("appid", String.valueOf(aVar.c()));
        com.tencent.mobileqq.aio.utils.b.l(elementId, hashMap);
        sendIntent(new e.b(aVar));
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View inflate = LayoutInflater.from(getMContext()).inflate(R.layout.f168350fq2, createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mContext)\n         \u2026ViewParams.parent, false)");
        this.mRoot = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            inflate = null;
        }
        g1(inflate);
        if (QLog.isColorLevel()) {
            QLog.d("PlusPanelVB", 2, "onCreateView");
        }
        View view = this.mRoot;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            return null;
        }
        return view;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("PlusPanelVB", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        QQViewPager qQViewPager = this.viewPager;
        if (qQViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager = null;
        }
        qQViewPager.removeOnPageChangeListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@Nullable View view) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) view)).booleanValue();
        } else {
            z16 = false;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, state);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(position), Float.valueOf(positionOffset), Integer.valueOf(positionOffsetPixels));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, position);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PlusPanelVB", 2, "onPageSelected page: " + position);
        }
        k1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        l1();
        sendIntent(e.a.f360417d);
        k1();
    }
}
