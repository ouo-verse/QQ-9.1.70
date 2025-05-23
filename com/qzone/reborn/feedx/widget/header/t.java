package com.qzone.reborn.feedx.widget.header;

import NS_MOBILE_WIDGET.GetWidgetRsp;
import android.os.Message;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.module.personalitycomponent.entity.QZoneVisitorNotifyView;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.proxy.personalitycomponent.canvasui.QZoneCanvasWidgetView;
import com.qzone.proxy.personalitycomponent.manager.QzoneWidgetService;
import com.qzone.proxy.personalitycomponent.model.WidgetPublicCacheData;
import com.qzone.proxy.personalitycomponent.ui.QZoneWidgetControllerDecorator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZonePermission;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class t extends d implements IObserver.main {
    private static final String[] E = {"android.permission.ACCESS_FINE_LOCATION"};
    private int C;
    private QQPermission D;

    /* renamed from: f, reason: collision with root package name */
    private final QZoneVisitorNotifyView f56320f;

    /* renamed from: h, reason: collision with root package name */
    private final QZoneCanvasWidgetView f56321h;

    /* renamed from: i, reason: collision with root package name */
    private QZoneWidgetControllerDecorator f56322i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f56323m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            t.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
        }
    }

    public t(View view) {
        super(view);
        this.f56323m = true;
        this.C = 0;
        this.f56320f = (QZoneVisitorNotifyView) view.findViewById(R.id.n07);
        this.f56321h = (QZoneCanvasWidgetView) view.findViewById(R.id.mzs);
        this.f56322i = (QZoneWidgetControllerDecorator) view.findViewById(R.id.mzv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(QZoneResult qZoneResult) {
        u(QzoneWidgetService.shouldShowWidget(g(), LoginData.getInstance().getUin()), qZoneResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(final String str) {
        final Object widgetInfoFromCache = QzoneWidgetService.getInstance().getWidgetInfoFromCache(this.C, false, LoginData.getInstance().getUin());
        f().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.r
            @Override // java.lang.Runnable
            public final void run() {
                t.this.B(widgetInfoFromCache, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(final boolean z16) {
        final boolean shouldShowWidget = QzoneWidgetService.shouldShowWidget(g(), LoginData.getInstance().getUin());
        if (d() != null) {
            d().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.q
                @Override // java.lang.Runnable
                public final void run() {
                    t.this.D(shouldShowWidget, z16);
                }
            });
        }
    }

    private void F(String str) {
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56322i;
        if (qZoneWidgetControllerDecorator != null) {
            qZoneWidgetControllerDecorator.refreshFailed(str);
        }
        QZoneCanvasWidgetView qZoneCanvasWidgetView = this.f56321h;
        if (qZoneCanvasWidgetView != null) {
            qZoneCanvasWidgetView.refreshFailed(str);
        }
    }

    private void H(Message message) {
        Object obj = message.obj;
        if (obj == null) {
            return;
        }
        boolean z16 = obj instanceof WidgetPublicCacheData;
        if (!z16 && this.f56322i != null) {
            J(true);
            this.f56322i.update(obj);
        } else if (z16 && this.f56321h != null) {
            J(false);
            this.f56321h.update(obj);
        }
        this.f56323m = false;
    }

    private void I(Message message) {
        Object obj = message.obj;
        if (obj instanceof String) {
            final String str = (String) obj;
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.o
                @Override // java.lang.Runnable
                public final void run() {
                    t.this.C(str);
                }
            });
        }
    }

    private void K(Message message) {
        Object obj = message.obj;
        if (obj instanceof GetWidgetRsp) {
            GetWidgetRsp getWidgetRsp = (GetWidgetRsp) obj;
            if (getWidgetRsp.today_delta > 0 && getWidgetRsp.stored_widget_id != 4) {
                this.f56320f.setVisibility(0);
                this.f56320f.setUnReadNum(getWidgetRsp.stored_widget_id, getWidgetRsp.today_delta);
                return;
            } else {
                this.f56320f.setVisibility(8);
                return;
            }
        }
        this.f56320f.setVisibility(8);
    }

    private void L() {
        if (g() == null && g().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            return;
        }
        long I = u5.b.I("lastShowPermissionDialogTime", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (I == 0 || currentTimeMillis - I > QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_LOCATE_PERMISSION_INTERVAL, 172800000L)) {
            QQPermission qQPermission = QQPermissionFactory.getQQPermission(QZonePermission.getRealPluginActivity(g()), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QZONE, QQPermissionConstants.Business.SCENE.QQ_QZONE_HEADER_LOCATION_WIDGET));
            this.D = qQPermission;
            if (qQPermission == null) {
                return;
            }
            qQPermission.requestPermissions(E, 2, new a());
            u5.b.s0("lastShowPermissionDialogTime", currentTimeMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void B(Object obj, String str) {
        if (!(obj instanceof WidgetPublicCacheData)) {
            if (this.f56322i == null) {
                return;
            }
            J(true);
            if (obj != null) {
                this.f56322i.update(obj);
                return;
            } else {
                this.f56322i.refreshFailed(str);
                return;
            }
        }
        if (this.f56321h == null) {
            return;
        }
        J(false);
        this.f56321h.update(obj);
    }

    private void O(final boolean z16) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.n
            @Override // java.lang.Runnable
            public final void run() {
                t.this.E(z16);
            }
        });
    }

    private void u(final boolean z16, final QZoneResult qZoneResult) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.s
            @Override // java.lang.Runnable
            public final void run() {
                t.this.z(z16, qZoneResult);
            }
        });
    }

    private void w() {
        if (g() == null && g().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(QZonePermission.getRealPluginActivity(g()), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QZONE, QQPermissionConstants.Business.SCENE.QQ_QZONE_HEADER_LOCATION_WIDGET));
        this.D = qQPermission;
        if (qQPermission == null) {
            return;
        }
        qQPermission.requestPermissions(E, 2, new b());
    }

    private void y(boolean z16) {
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator;
        int widgetType = QzoneWidgetService.getWidgetType(g(), LoginData.getInstance().getUin());
        this.C = widgetType;
        if (widgetType == -1 || (qZoneWidgetControllerDecorator = this.f56322i) == null) {
            return;
        }
        if (qZoneWidgetControllerDecorator.getWidgetType() != this.C) {
            this.f56322i.init(g(), f(), this.C);
        }
        this.f56322i.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(boolean z16, QZoneResult qZoneResult) {
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56322i;
        if (qZoneWidgetControllerDecorator == null) {
            return;
        }
        if (z16) {
            y(false);
            this.f56322i.update(qZoneResult.getData());
        } else {
            qZoneWidgetControllerDecorator.hide();
        }
    }

    public void G() {
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56322i;
        if (qZoneWidgetControllerDecorator != null) {
            qZoneWidgetControllerDecorator.onLbsPermissionFail(g().getResources().getString(R.string.vq_));
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void delayShow() {
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56322i;
        if (qZoneWidgetControllerDecorator != null) {
            qZoneWidgetControllerDecorator.show();
        }
        QZoneCanvasWidgetView qZoneCanvasWidgetView = this.f56321h;
        if (qZoneCanvasWidgetView != null) {
            qZoneCanvasWidgetView.setVisibility(0);
        }
        O(false);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneFeedxHeaderWidgetElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        if (SimpleUIUtil.isNowElderMode()) {
            this.f56322i = null;
        }
        f6.a.c(this.f56321h);
        f6.a.c(this.f56322i);
        EventCenter.getInstance().addUIObserver(this, "Personalize", 9);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56322i;
        if (qZoneWidgetControllerDecorator != null) {
            qZoneWidgetControllerDecorator.onDestory();
        }
        QZoneCanvasWidgetView qZoneCanvasWidgetView = this.f56321h;
        if (qZoneCanvasWidgetView != null && qZoneCanvasWidgetView.getCanvasArea() != null) {
            this.f56321h.getCanvasArea().clearAllAreaCache();
        }
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("Personalize".equals(event.source.getName())) {
            if (event.what == 9) {
                f().sendEmptyMessageAtTime(3, 500L);
            }
        } else if ("Lbs".equals(event.source.getName())) {
            int i3 = event.what;
            if (i3 == 5) {
                L();
            } else if (i3 == 6) {
                w();
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onHandleMessage(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        switch (message.what) {
            case 3:
                O(true);
                return;
            case 1000032:
                x(message, unpack);
                return;
            case PersonalityConfig.MSG_REFRESH_WIDGET /* 20130703 */:
                H(message);
                return;
            case PersonalityConfig.MSG_REQUEST_DRAW /* 20140716 */:
                QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56322i;
                if (qZoneWidgetControllerDecorator != null) {
                    qZoneWidgetControllerDecorator.requestLayout();
                    return;
                }
                return;
            case PersonalityConfig.MSG_REFRESH_WIDGET_FAILED /* 20160112 */:
                I(message);
                return;
            case PersonalityConfig.MSG_REFRESH_WIDGET_VISITOR_NUM /* 20190721 */:
                K(message);
                return;
            default:
                return;
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onPause() {
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56322i;
        if (qZoneWidgetControllerDecorator != null) {
            qZoneWidgetControllerDecorator.clearNextRefresh();
            this.f56322i.onPause();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
        QZoneVisitorNotifyView qZoneVisitorNotifyView = this.f56320f;
        if (qZoneVisitorNotifyView != null) {
            qZoneVisitorNotifyView.j();
        }
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56322i;
        if (qZoneWidgetControllerDecorator != null) {
            qZoneWidgetControllerDecorator.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void D(boolean z16, boolean z17) {
        if (z16) {
            y(z17);
            QzoneWidgetService.getInstance().getWidgetData(g(), LoginData.getInstance().getUin(), this.f56323m, true, f());
            return;
        }
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56322i;
        if (qZoneWidgetControllerDecorator != null) {
            qZoneWidgetControllerDecorator.hide();
        }
        QZoneCanvasWidgetView qZoneCanvasWidgetView = this.f56321h;
        if (qZoneCanvasWidgetView != null) {
            qZoneCanvasWidgetView.setVisibility(8);
        }
        QZoneVisitorNotifyView qZoneVisitorNotifyView = this.f56320f;
        if (qZoneVisitorNotifyView != null) {
            qZoneVisitorNotifyView.setVisibility(8);
        }
    }

    private void x(Message message, final QZoneResult qZoneResult) {
        if (qZoneResult != null && qZoneResult.getSucceed()) {
            if (this.f56322i == null) {
                return;
            }
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.p
                @Override // java.lang.Runnable
                public final void run() {
                    t.this.A(qZoneResult);
                }
            });
        } else {
            F(qZoneResult != null ? qZoneResult.getMessage() : null);
            O(false);
        }
    }

    private void J(boolean z16) {
        if (z16) {
            QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56322i;
            if (qZoneWidgetControllerDecorator != null) {
                qZoneWidgetControllerDecorator.setVisibility(0);
            }
            QZoneCanvasWidgetView qZoneCanvasWidgetView = this.f56321h;
            if (qZoneCanvasWidgetView != null) {
                qZoneCanvasWidgetView.setVisibility(8);
                return;
            }
            return;
        }
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator2 = this.f56322i;
        if (qZoneWidgetControllerDecorator2 != null) {
            qZoneWidgetControllerDecorator2.setVisibility(8);
        }
        QZoneCanvasWidgetView qZoneCanvasWidgetView2 = this.f56321h;
        if (qZoneCanvasWidgetView2 != null) {
            qZoneCanvasWidgetView2.setVisibility(0);
        }
    }
}
