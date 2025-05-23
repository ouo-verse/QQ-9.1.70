package com.tencent.mobileqq.location.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IImmersiveUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class HeadSetViewModule implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QPublicFragmentActivity f241377d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.location.ui.headset.a f241378e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f241379f;

    /* renamed from: h, reason: collision with root package name */
    private LocationRoom.b f241380h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f241382d;

        a(ActionSheet actionSheet) {
            this.f241382d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeadSetViewModule.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0) {
                HeadSetViewModule.this.f241377d.finish();
                Intent intent = HeadSetViewModule.this.f241377d.getIntent();
                String stringExtra = intent.getStringExtra("uin");
                int intExtra = intent.getIntExtra("uintype", -1);
                com.tencent.mobileqq.location.net.e.c().f241360d.e(3, intExtra, stringExtra);
                LocationShareLocationManager.h().o(new LocationRoom.b(intExtra, stringExtra), false);
                ReportController.o(null, "CliOper", "", "", "0X800A76E", "0X800A76E", 0, 0, "", "0", "0", "");
                ee2.d.b("aio");
            }
            this.f241382d.superDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeadSetViewModule(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        if (context instanceof QPublicFragmentActivity) {
            this.f241377d = (QPublicFragmentActivity) context;
        }
        d();
        e();
    }

    private void e() {
        ((IImmersiveUtilsApi) QRoute.api(IImmersiveUtilsApi.class)).setStatusTextColor(true, this.f241377d.getWindow());
        ((IImmersiveUtilsApi) QRoute.api(IImmersiveUtilsApi.class)).setStatusBarDarkMode(this.f241377d.getWindow(), true);
    }

    private void f() {
        if (QLog.isColorLevel()) {
            QLog.d("HeadSetViewModule", 2, "onClickCancelShare: invoked. ");
        }
        ActionSheet create = ActionSheet.create(this.f241377d);
        create.addButton(R.string.axs, 3);
        create.setMainTitle(R.string.iuz);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new a(create));
        create.show();
        ReportController.o(null, "CliOper", "", "", "0X800A76D", "0X800A76D", 0, 0, "", "0", "0", "");
    }

    private void g() {
        if (QLog.isColorLevel()) {
            QLog.d("HeadSetViewModule", 2, "onClickMinimizeShare: invoked. ", " textSharingCount: ", this.f241379f);
        }
        if (((IFloatMapService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).enterFloat(this.f241377d, this.f241380h)) {
            this.f241377d.finish();
        }
        ReportController.o(null, "CliOper", "", "", "0X800A76F", "0X800A76F", 0, 0, "", "0", "0", "");
    }

    private void i(ArrayList<String> arrayList) {
        if (QLog.isColorLevel()) {
            Iterator<String> it = arrayList.iterator();
            String str = "";
            while (it.hasNext()) {
                str = str + ", " + it.next();
            }
            com.tencent.mobileqq.location.ui.headset.a aVar = this.f241378e;
            if (aVar != null) {
                QLog.d("HeadSetViewModule", 2, "refreshHeadSet: invoked. ", " uins: ", str, " headAdapter.count: ", Integer.valueOf(aVar.getCount()));
            } else {
                QLog.d("HeadSetViewModule", 2, "refreshHeadSet: invoked. ", " uins: ", str, " headAdapter is null");
            }
        }
        if (this.f241378e == null) {
            return;
        }
        if (arrayList != null && arrayList.size() > 0) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.location.ui.HeadSetViewModule.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f241381d;

                {
                    this.f241381d = arrayList;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeadSetViewModule.this, (Object) arrayList);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        HeadSetViewModule.this.f241378e.c(this.f241381d);
                        HeadSetViewModule.this.j(this.f241381d);
                    }
                }
            });
        } else {
            QLog.e("HeadSetViewModule", 1, "refreshHeadSet: failed. uins empty, maybe exit room");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ArrayList<String> arrayList) {
        if (arrayList.size() == 1) {
            this.f241379f.setText(this.f241377d.getResources().getString(R.string.isz));
        } else {
            this.f241379f.setText(arrayList.size() + this.f241377d.getString(R.string.f171095it2));
        }
        MapUtils.i(this.f241379f, "" + ((Object) this.f241379f.getText()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(List<com.tencent.mobileqq.location.data.a> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<com.tencent.mobileqq.location.data.a> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().d()));
        }
        i(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(com.tencent.mobileqq.location.ui.headset.a aVar) {
        this.f241378e = aVar;
    }

    public void l(LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f241380h = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(TextView textView) {
        this.f241379f = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.lc6) {
                f();
            } else if (id5 == R.id.lsl) {
                g();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void d() {
    }
}
