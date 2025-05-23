package com.tencent.mobileqq.activity.contacts.troopnotificationentry;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.redpoint.GroupSystemMsgRedPointClearEvent;
import com.tencent.mobileqq.troop.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopNotificationRepoApi;
import com.tencent.qqnt.troop.g;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f181835a;

    /* renamed from: b, reason: collision with root package name */
    private View f181836b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f181837c;

    /* renamed from: d, reason: collision with root package name */
    private Activity f181838d;

    /* renamed from: e, reason: collision with root package name */
    private QUIBadge f181839e;

    /* renamed from: f, reason: collision with root package name */
    int f181840f;

    /* renamed from: g, reason: collision with root package name */
    private final SimpleEventReceiver f181841g;

    /* renamed from: h, reason: collision with root package name */
    private g f181842h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (b.this.f181838d != null) {
                ReportController.o(null, "dc00898", "", "", "0X800B41B", "0X800B41B", 0, 0, "", "", null, null);
                Intent intent = new Intent();
                intent.putExtra("key_from", 2);
                if (((ITroopNotificationRepoApi) QRoute.api(ITroopNotificationRepoApi.class)).getNotificationUnreadCount() > 0) {
                    ReportController.o(null, "dc00898", "", "", "0X800B52B", "0X800B52B", 0, 0, "", "", null, null);
                }
                if (ax.a()) {
                    ax.b(false);
                    ReportController.o(null, "dc00898", "", "", "0X800B52F", "0X800B52F", 0, 0, "", "", null, null);
                }
                ((ILaunchTroopSysMsgUIUtilApi) QRoute.api(ILaunchTroopSysMsgUIUtilApi.class)).launchTroopNotificationWithRcmdFragment(intent);
                b.this.k();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.contacts.troopnotificationentry.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C7161b implements SimpleEventReceiver {
        static IPatchRedirector $redirector_;

        C7161b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class> getEventClass() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            ArrayList<Class> arrayList = new ArrayList<>();
            arrayList.add(GroupSystemMsgRedPointClearEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) simpleBaseEvent);
            } else if (simpleBaseEvent instanceof GroupSystemMsgRedPointClearEvent) {
                b.this.k();
            }
        }
    }

    public b(View view, QQAppInterface qQAppInterface, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, view, qQAppInterface, activity);
            return;
        }
        this.f181841g = new C7161b();
        this.f181842h = new g() { // from class: com.tencent.mobileqq.activity.contacts.troopnotificationentry.a
            @Override // com.tencent.qqnt.troop.g
            public final void b(int i3, int i16, int i17) {
                b.this.e(i3, i16, i17);
            }
        };
        this.f181835a = qQAppInterface;
        this.f181836b = view;
        this.f181838d = activity;
        d();
        c();
    }

    private void c() {
        LifecycleOwner lifecycleOwner;
        if (this.f181835a == null) {
            return;
        }
        ComponentCallbacks2 componentCallbacks2 = this.f181838d;
        if (componentCallbacks2 instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) componentCallbacks2;
        } else {
            lifecycleOwner = null;
        }
        ((ITroopNotificationRepoApi) QRoute.api(ITroopNotificationRepoApi.class)).registerNotificationChangedObserver(lifecycleOwner, this.f181842h);
        SimpleEventBus.getInstance().registerReceiver(this.f181841g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(int i3, int i16, int i17) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationEntryController", 2, "onUnreadCountChanged count:" + i3);
        }
        k();
    }

    private void i() {
        ((ITroopNotificationRepoApi) QRoute.api(ITroopNotificationRepoApi.class)).unregisterNotificationChangeObserver(this.f181842h);
        SimpleEventBus.getInstance().unRegisterReceiver(this.f181841g);
    }

    private void j() {
        QUIBadge qUIBadge = this.f181839e;
        if (qUIBadge != null && this.f181837c != null) {
            if (this.f181835a == null) {
                qUIBadge.setVisibility(8);
                return;
            }
            int notificationUnreadCount = ((ITroopNotificationRepoApi) QRoute.api(ITroopNotificationRepoApi.class)).getNotificationUnreadCount();
            if (this.f181840f != notificationUnreadCount) {
                ReportController.o(null, "dc00898", "", "", "0X800B52A", "0X800B52A", 0, 0, "", "", null, null);
                this.f181840f = notificationUnreadCount;
            }
            if (notificationUnreadCount > 0) {
                this.f181837c.setContentDescription(this.f181838d.getString(R.string.f235237b4) + String.valueOf(notificationUnreadCount) + this.f181838d.getString(R.string.f235247b5));
            } else {
                this.f181837c.setContentDescription(this.f181838d.getString(R.string.f235237b4));
            }
            if (notificationUnreadCount > 0) {
                this.f181839e.setRedNum(notificationUnreadCount);
                this.f181839e.setVisibility(0);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopNotificationEntryController", 2, "updateRedDot unReadCount:" + notificationUnreadCount + ",mRedDotTV is VISIBLE");
                    return;
                }
                return;
            }
            this.f181839e.setVisibility(8);
            if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationEntryController", 2, "updateRedDot mRedDotTV is GONE");
            }
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        View view = this.f181836b;
        if (view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f103145zt);
        this.f181837c = relativeLayout;
        relativeLayout.setOnClickListener(new a());
        this.f181839e = (QUIBadge) this.f181837c.findViewById(R.id.f10327606);
        k();
        this.f181837c.setVisibility(0);
    }

    public void f(QQAppInterface qQAppInterface, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qQAppInterface, (Object) activity);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationEntryController", 2, "onAccountChanged");
        }
        i();
        this.f181835a = qQAppInterface;
        this.f181838d = activity;
        c();
        k();
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        i();
        this.f181835a = null;
        this.f181838d = null;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ReportController.o(null, "dc00898", "", "", "0X800B41A", "0X800B41A", 0, 0, "", "", null, null);
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            j();
            this.f181837c.setVisibility(0);
        }
    }
}
