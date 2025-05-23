package com.tencent.mobileqq.zplan.smallhome.floatwindow;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zplan.lua.plugins.ZPlanDialogLuaPlugin;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanUEShowDialogEvent;
import com.tencent.mobileqq.zplan.smallhome.network.ConfigHelper;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusInfo;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForMain;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.open.agent.notify.CommonAuthorityEvent;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.zplan.luabridge.LuaArgument;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 52\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u00016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0014J\b\u0010\u0012\u001a\u00020\u0007H\u0014J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0007J\u0016\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0015J\u0010\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u0015J\u0006\u0010\u001f\u001a\u00020\u0007J\u0012\u0010 \u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010$\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"`#H\u0016J\b\u0010&\u001a\u00020%H\u0016R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010.R\u0016\u00101\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/ZPlanSmallHomeFloatView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "statusInfo", "", "l", "Lcom/tencent/mobileqq/zplan/smallhome/event/ZPlanUEShowDialogEvent;", "event", ReportConstant.COSTREPORT_PREFIX, "", "Lcom/tencent/open/model/AppInfo;", "infos", "g", "o", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isLeft", "f", "e", "", "percent", "isResume", DomainData.DOMAIN_NAME, "isFromClick", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "", "d", "I", "getMapId", "()I", "mapId", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/e;", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/e;", "floatProxyWrapper", "Z", "isEdgeStatus", "Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "i", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanSmallHomeFloatView extends FrameLayout implements SimpleEventReceiver<SimpleBaseEvent>, LifecycleOwner {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int mapId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private e floatProxyWrapper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isEdgeStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final LifecycleRegistry lifecycle;

    private final void g(List<? extends AppInfo> infos) {
        if (infos.isEmpty()) {
            QLog.i("ZPlanSmallHomeFloatView", 1, "handleDelAuthority: list is empty, return");
            return;
        }
        for (AppInfo appInfo : infos) {
            QLog.i("ZPlanSmallHomeFloatView", 1, "handleDelAuthority: " + appInfo.c());
            if (Intrinsics.areEqual(String.valueOf(appInfo.c()), ZootopiaEnterParams.ZPLAN_APP_ID)) {
                QLog.i("ZPlanSmallHomeFloatView", 1, "handleDelAuthority:, hide float");
                ((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class)).notifyHideFloatWindow(this.mapId, true);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(SimpleBaseEvent simpleBaseEvent, ZPlanSmallHomeFloatView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        ZPlanUEShowDialogEvent zPlanUEShowDialogEvent = (ZPlanUEShowDialogEvent) simpleBaseEvent;
        if (zPlanUEShowDialogEvent.getDialogType() == 0) {
            LuaArgument argument = zPlanUEShowDialogEvent.getArgument();
            if (argument != null) {
                argument.callback(ZPlanDialogLuaPlugin.INSTANCE.a(true));
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(zPlanUEShowDialogEvent.getConfirmBtn())) {
            this$0.s(zPlanUEShowDialogEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(SimpleBaseEvent simpleBaseEvent, ZPlanSmallHomeFloatView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        ZPlanUEShowDialogEvent zPlanUEShowDialogEvent = (ZPlanUEShowDialogEvent) simpleBaseEvent;
        if (zPlanUEShowDialogEvent.getDialogType() == 0) {
            LuaArgument argument = zPlanUEShowDialogEvent.getArgument();
            if (argument != null) {
                argument.callback(ZPlanDialogLuaPlugin.INSTANCE.a(false));
                return;
            }
            return;
        }
        this$0.s(zPlanUEShowDialogEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(ZPlanModLoadStatusInfo statusInfo) {
        ConfigHelper.f335704a.b().get(ConfigHelper.MaterialState.Downloading);
        throw null;
    }

    private final void o() {
        LiveData<Boolean> isInMeetingLiveData = ((kk3.b) k74.i.INSTANCE.a(kk3.b.class)).getIsInMeetingLiveData();
        if (isInMeetingLiveData != null) {
            isInMeetingLiveData.observe(this, new Observer() { // from class: com.tencent.mobileqq.zplan.smallhome.floatwindow.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZPlanSmallHomeFloatView.p(ZPlanSmallHomeFloatView.this, (Boolean) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ZPlanSmallHomeFloatView this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
    }

    private final void s(ZPlanUEShowDialogEvent event) {
        if (TextUtils.isEmpty(event.getNativeScheme())) {
            return;
        }
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        String nativeScheme = event.getNativeScheme();
        Intrinsics.checkNotNull(nativeScheme);
        ZootopiaSource b16 = ag.f373258a.b();
        if (b16 == null) {
            b16 = ZootopiaSource.INSTANCE.g();
        }
        String appendSourceToScheme = iSchemeApi.appendSourceToScheme(nativeScheme, b16);
        ISchemeApi iSchemeApi2 = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi2.launchScheme(context, appendSourceToScheme);
    }

    public final void e() {
        ZPlanModLoadStatusInfo h16 = ZPlanModLoadStatusManagerForMain.f335706a.h();
        if (h16 != null) {
            l(h16);
        }
        rk3.a aVar = rk3.a.f431649a;
        throw null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ZPlanUEShowDialogEvent.class);
        arrayList.add(CommonAuthorityEvent.class);
        return arrayList;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public final void k() {
        QLog.i("ZPlanSmallHomeFloatView", 1, "onWindowShow - " + this);
        m();
    }

    public final void m() {
        com.tencent.mobileqq.activity.qcircle.utils.g.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.smallhome.floatwindow.ZPlanSmallHomeFloatView$refreshUIWithCurStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ZPlanModLoadStatusInfo h16 = ZPlanModLoadStatusManagerForMain.f335706a.h();
                if (h16 != null) {
                    ZPlanSmallHomeFloatView.this.l(h16);
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.i("ZPlanSmallHomeFloatView", 1, "onAttachedToWindow - " + this);
        this.lifecycle.setCurrentState(Lifecycle.State.CREATED);
        this.lifecycle.setCurrentState(Lifecycle.State.RESUMED);
        SimpleEventBus.getInstance().registerReceiver(this);
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.i("ZPlanSmallHomeFloatView", 1, "onDetachedFromWindow - " + this);
        this.lifecycle.setCurrentState(Lifecycle.State.DESTROYED);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent event) {
        QLog.i("ZPlanSmallHomeFloatView", 1, "onReceiveEvent: " + event);
        if (event instanceof CommonAuthorityEvent) {
            g(((CommonAuthorityEvent) event).getInfos());
            return;
        }
        if (event instanceof ZPlanUEShowDialogEvent) {
            ZPlanUEShowDialogEvent zPlanUEShowDialogEvent = (ZPlanUEShowDialogEvent) event;
            if (zPlanUEShowDialogEvent.getDialogType() != 1) {
                return;
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, zPlanUEShowDialogEvent.getTitle(), zPlanUEShowDialogEvent.getMsg(), zPlanUEShowDialogEvent.getCancelBtn(), zPlanUEShowDialogEvent.getConfirmBtn(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.smallhome.floatwindow.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ZPlanSmallHomeFloatView.i(SimpleBaseEvent.this, this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.smallhome.floatwindow.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ZPlanSmallHomeFloatView.j(SimpleBaseEvent.this, this, dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026         }\n            })");
            createCustomDialog.show();
        }
    }

    public final void q(boolean isFromClick) {
        c animationHelper;
        if (this.isEdgeStatus) {
            this.isEdgeStatus = false;
            e eVar = this.floatProxyWrapper;
            if (eVar == null || (animationHelper = eVar.getAnimationHelper()) == null) {
                return;
            }
            animationHelper.d(isFromClick);
        }
    }

    public final void f(boolean isLeft) {
        this.isEdgeStatus = true;
        throw null;
    }

    public final void h() {
        QLog.i("ZPlanSmallHomeFloatView", 1, "hide view");
        ZPlanModLoadStatusManagerForMain.f335706a.q(null);
    }

    public final void n(float percent, boolean isResume) {
        if (isResume) {
            throw null;
        }
        throw null;
    }

    public static /* synthetic */ void r(ZPlanSmallHomeFloatView zPlanSmallHomeFloatView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        zPlanSmallHomeFloatView.q(z16);
    }
}
