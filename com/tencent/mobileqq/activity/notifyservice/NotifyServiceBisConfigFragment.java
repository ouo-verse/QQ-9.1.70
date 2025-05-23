package com.tencent.mobileqq.activity.notifyservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.notify.ServiceAssMsgTemplateItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.chats.api.INotifyServiceSettingApi;
import com.tencent.qqnt.kernel.nativeinterface.GetServiceAssistantSwitchRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetServiceAssistantSwitchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ServiceAssistantAppSwitch;
import com.tencent.qqnt.kernel.nativeinterface.ServiceAssistantTemplateSwitch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NotifyServiceBisConfigFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    private Intent C;
    private ArrayList<n03.a> D;
    private ServiceAssistantAppSwitch E;
    private LayoutInflater F;
    private long G;
    private int H;
    private boolean I;
    private ArrayList<LinearLayout> J;
    private FormSwitchSimpleItem K;
    private TextView L;
    private o03.b M;
    private LinearLayout N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.notifyservice.NotifyServiceBisConfigFragment$4, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass4 implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        AnonymousClass4() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyServiceBisConfigFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                boolean isChecked = NotifyServiceBisConfigFragment.this.K.getSwitch().isChecked();
                FormSwitchSimpleItem formSwitchSimpleItem = NotifyServiceBisConfigFragment.this.K;
                NotifyServiceBisConfigFragment notifyServiceBisConfigFragment = NotifyServiceBisConfigFragment.this;
                VideoReport.reportEvent("dt_clck", formSwitchSimpleItem, notifyServiceBisConfigFragment.Ch(Integer.valueOf(notifyServiceBisConfigFragment.H), !isChecked ? 1 : 0));
                if (NotifyServiceBisConfigFragment.this.M != null) {
                    NotifyServiceBisConfigFragment.this.M.c(NotifyServiceBisConfigFragment.this.G, isChecked);
                }
                ((INotifyServiceSettingApi) QRoute.api(INotifyServiceSettingApi.class)).requestSetSwitch(isChecked ? 1 : 0, 3, Integer.valueOf(NotifyServiceBisConfigFragment.this.H), Long.valueOf(NotifyServiceBisConfigFragment.this.G), new HashMap<>(), new IOperateCallback(isChecked) { // from class: com.tencent.mobileqq.activity.notifyservice.NotifyServiceBisConfigFragment.4.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ boolean f183675a;

                    {
                        this.f183675a = isChecked;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass4.this, Boolean.valueOf(isChecked));
                        }
                    }

                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public void onResult(int i3, String str) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) str);
                            return;
                        }
                        com.tencent.xaction.log.b.c("NotifyServiceBisConfigFragment", 1, "[onResult] toggle ret:" + i3 + ", msg:" + str, null);
                        if (!NotifyServiceBisConfigFragment.this.Bh()) {
                            return;
                        }
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3) { // from class: com.tencent.mobileqq.activity.notifyservice.NotifyServiceBisConfigFragment.4.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ int f183677d;

                            {
                                this.f183677d = i3;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, i3);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (!NotifyServiceBisConfigFragment.this.Bh()) {
                                    return;
                                }
                                if (this.f183677d == 0) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    NotifyServiceBisConfigFragment.this.I = anonymousClass1.f183675a;
                                    NotifyServiceBisConfigFragment.this.Jh();
                                    NotifyServiceBisConfigFragment.this.Fh();
                                    return;
                                }
                                QQToast.makeText(NotifyServiceBisConfigFragment.this.getContext(), HardCodeUtil.qqStr(R.string.f171642oa), 0).show();
                                NotifyServiceBisConfigFragment.this.K.setChecked(!AnonymousClass1.this.f183675a);
                                NotifyServiceBisConfigFragment.this.I = !r0.f183675a;
                            }
                        });
                    }
                });
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements IGetServiceAssistantSwitchCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyServiceBisConfigFragment.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetServiceAssistantSwitchCallback
        public void onResult(int i3, String str, GetServiceAssistantSwitchRsp getServiceAssistantSwitchRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, getServiceAssistantSwitchRsp);
            } else if (i3 == 0) {
                NotifyServiceBisConfigFragment.this.Eh(getServiceAssistantSwitchRsp);
            } else {
                NotifyServiceBisConfigFragment.this.Dh(i3, str);
            }
        }
    }

    public NotifyServiceBisConfigFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.D = new ArrayList<>();
        this.I = false;
        this.J = new ArrayList<>();
        this.M = null;
        this.N = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            com.tencent.xaction.log.b.c("NotifyServiceBisConfigFragment", 1, "[onResult] activity is null ,return", null);
            return false;
        }
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            return true;
        }
        com.tencent.xaction.log.b.c("NotifyServiceBisConfigFragment", 1, "[onResult] activity is finish ,return", null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> Ch(Object obj, int i3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("switching_direction", Integer.valueOf(i3));
        hashMap.put("business_type", obj);
        hashMap.putAll(c.a("pg_bas_business_notification_settings"));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(int i3, String str) {
        com.tencent.xaction.log.b.c("NotifyServiceBisConfigFragment", 1, "[handlerRspFail] handlerRspFail ret:" + i3 + ", msg:" + str, null);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.notifyservice.NotifyServiceBisConfigFragment.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyServiceBisConfigFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QQToast.makeText(NotifyServiceBisConfigFragment.this.getContext(), HardCodeUtil.qqStr(R.string.f171642oa), 0).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(GetServiceAssistantSwitchRsp getServiceAssistantSwitchRsp) {
        ArrayList<ServiceAssistantAppSwitch> appSwitch;
        if (getServiceAssistantSwitchRsp != null && (appSwitch = getServiceAssistantSwitchRsp.getAppSwitch()) != null && appSwitch.size() != 0) {
            this.E = appSwitch.get(0);
            Iterator<ServiceAssistantTemplateSwitch> it = getServiceAssistantSwitchRsp.getTemplateSwitch().iterator();
            while (it.hasNext()) {
                ServiceAssistantTemplateSwitch next = it.next();
                n03.a aVar = new n03.a();
                aVar.f417924b = next.getTemplateId();
                aVar.f417923a = next.getTitle();
                aVar.f417925c = next.getSwitchValue();
                com.tencent.xaction.log.b.a("NotifyServiceBisConfigFragment", 1, "[handlerRspResult] templateSwitch[" + aVar.f417924b + "," + aVar.f417923a + "," + aVar.f417925c + "]");
                Iterator<ServiceAssistantTemplateSwitch> it5 = next.getSubSwitch().iterator();
                while (it5.hasNext()) {
                    ServiceAssistantTemplateSwitch next2 = it5.next();
                    com.tencent.xaction.log.b.a("NotifyServiceBisConfigFragment", 1, "[handlerRspResult] subSwitch[" + next2.getTemplateId() + "," + next2.getTitle() + "," + next2.getSwitchValue() + "]");
                    aVar.f417926d.add(new ServiceAssMsgTemplateItem(next2.getTitle(), next2.getSwitchValue()));
                }
                this.D.add(aVar);
            }
            if (this.E == null) {
                com.tencent.xaction.log.b.c("NotifyServiceBisConfigFragment", 1, "[handlerRspResult] mAppSwitch is null!", null);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.notifyservice.NotifyServiceBisConfigFragment.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyServiceBisConfigFragment.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else if (NotifyServiceBisConfigFragment.this.isAdded() && NotifyServiceBisConfigFragment.this.Bh()) {
                            NotifyServiceBisConfigFragment.this.initUI();
                        } else {
                            com.tencent.xaction.log.b.c("NotifyServiceBisConfigFragment", 1, "[handlerRspResult] fragment not added. or activity is destroyed", null);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh() {
        String qqStr;
        if (this.N == null) {
            return;
        }
        if (!this.I) {
            Iterator<LinearLayout> it = this.J.iterator();
            while (it.hasNext()) {
                this.N.removeView(it.next());
            }
            this.J.clear();
            return;
        }
        ArrayList<LinearLayout> arrayList = this.J;
        if (arrayList != null && !arrayList.isEmpty()) {
            return;
        }
        Iterator<n03.a> it5 = this.D.iterator();
        while (it5.hasNext()) {
            final n03.a next = it5.next();
            int i3 = 0;
            LinearLayout linearLayout = (LinearLayout) this.F.inflate(R.layout.fpb, (ViewGroup) this.N, false);
            final QFormSimpleItem qFormSimpleItem = (QFormSimpleItem) linearLayout.findViewById(R.id.t8c);
            qFormSimpleItem.setLeftText(next.f417923a);
            qFormSimpleItem.setContentDescription(next.f417923a);
            qFormSimpleItem.setTag(next.f417924b);
            if (next.f417925c == 0) {
                qqStr = HardCodeUtil.qqStr(R.string.igj);
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.kp_);
            }
            qFormSimpleItem.setRightText(qqStr);
            qFormSimpleItem.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.notifyservice.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotifyServiceBisConfigFragment.this.Ih(qFormSimpleItem, next, view);
                }
            });
            this.N.addView(linearLayout);
            ArrayList<LinearLayout> arrayList2 = this.J;
            if (arrayList2 != null) {
                arrayList2.add(linearLayout);
            }
            Integer valueOf = Integer.valueOf(this.H);
            if (next.f417925c != 0) {
                i3 = 1;
            }
            VideoReport.setElementParams(qFormSimpleItem, Ch(valueOf, i3));
            VideoReport.setElementExposePolicy(qFormSimpleItem, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(qFormSimpleItem, ClickPolicy.REPORT_NONE);
            VideoReport.setElementId(qFormSimpleItem, "em_bas_sub_business_service_message_notification");
        }
    }

    private void Gh() {
        this.I = Hh();
        this.K.setVisibility(0);
        VideoReport.setElementParams(this.K, Ch(Integer.valueOf(this.H), !this.I ? 1 : 0));
        VideoReport.setElementExposePolicy(this.K, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.K, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.K, "em_bas_message_notification_main_switch");
        o03.b bVar = this.M;
        if (bVar != null) {
            bVar.a(this.G, this.I);
        }
        Jh();
        this.K.setOnCheckedChangeListener(new AnonymousClass4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih(QFormSimpleItem qFormSimpleItem, n03.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int i3 = 1;
        com.tencent.xaction.log.b.a("NotifyServiceBisConfigFragment", 1, "[inflateListElements] start item page!!!!");
        Integer valueOf = Integer.valueOf(this.H);
        if (aVar.f417925c == 0) {
            i3 = 0;
        }
        VideoReport.reportEvent("dt_clck", qFormSimpleItem, Ch(valueOf, i3));
        Intent intent = new Intent();
        intent.putExtra("title", aVar.f417923a);
        intent.putExtra("status", aVar.f417925c);
        intent.putExtra("template_id", aVar.f417924b);
        intent.putParcelableArrayListExtra("template_items", aVar.f417926d);
        intent.putExtra("key_notify_app_id", this.G);
        intent.putExtra("key_notify_app_type", this.H);
        QPublicFragmentActivity.b.f(getContext(), intent, QPublicFragmentActivity.class, NotifyServiceBisMsgConfigFragment.class, n03.b.f417927a);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh() {
        String format;
        this.K.setChecked(this.I);
        if (this.I) {
            format = String.format(HardCodeUtil.qqStr(R.string.f171602o7), this.E.getName());
        } else {
            format = String.format(HardCodeUtil.qqStr(R.string.f171592o6), this.E.getName());
        }
        TextView textView = this.L;
        if (textView != null) {
            textView.setVisibility(0);
            this.L.setText(format);
            this.L.setContentDescription(format);
        }
        this.K.setContentDescription(format);
    }

    private void initData() {
        Intent intent = this.C;
        if (intent == null) {
            return;
        }
        this.G = intent.getLongExtra("key_notify_app_id", 0L);
        this.H = this.C.getIntExtra("key_notify_app_type", 0);
        com.tencent.xaction.log.b.a("NotifyServiceBisConfigFragment", 1, "[initData] appId:" + this.G + ", appType:" + this.H);
        this.M = o03.c.a(this.H);
        ((INotifyServiceSettingApi) QRoute.api(INotifyServiceSettingApi.class)).requestGetSwitch(1, Integer.valueOf(this.H), Long.valueOf(this.G), new a());
    }

    public boolean Hh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        ServiceAssistantAppSwitch serviceAssistantAppSwitch = this.E;
        if (serviceAssistantAppSwitch == null || serviceAssistantAppSwitch.getSwitchValue() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view == null) {
            onFinish();
            return;
        }
        this.F = layoutInflater;
        this.L = (TextView) view.findViewById(R.id.f83744kd);
        this.K = (FormSwitchSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.xwe);
        this.N = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f83774kg);
        setTitle(HardCodeUtil.qqStr(R.string.f171612o8));
        this.leftView.setContentDescription(HardCodeUtil.qqStr(R.string.f170549u3));
        initData();
        VideoReport.setPageParams(((QIphoneTitleBarFragment) this).mContentView, c.b());
        VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_ALL);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_bas_business_notification_settings");
        o03.b bVar = this.M;
        if (bVar != null) {
            bVar.e(this.G);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.fpa;
    }

    public void initUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            Gh();
            Fh();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @androidx.annotation.Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        com.tencent.xaction.log.b.a("NotifyServiceBisConfigFragment", 1, "[onActivityResult] requestCode:" + i3 + ", resultCode:" + i16);
        super.onActivityResult(i3, i16, intent);
        if (i16 != 0 && intent != null && i3 == n03.b.f417927a) {
            int intExtra = intent.getIntExtra("result", 0);
            String stringExtra = intent.getStringExtra("template_id");
            com.tencent.xaction.log.b.a("NotifyServiceBisConfigFragment", 1, "[onActivityResult] switchValue:" + intExtra + ", tempId:" + stringExtra);
            Iterator<n03.a> it = this.D.iterator();
            while (it.hasNext()) {
                n03.a next = it.next();
                if (!TextUtils.isEmpty(next.f417924b) && next.f417924b.equals(stringExtra)) {
                    next.f417925c = intExtra;
                    View findViewWithTag = this.N.findViewWithTag(stringExtra);
                    if (findViewWithTag != null && (findViewWithTag instanceof QFormSimpleItem)) {
                        if (intExtra == 0) {
                            ((QFormSimpleItem) findViewWithTag).setRightText(HardCodeUtil.qqStr(R.string.igj));
                            return;
                        } else {
                            ((QFormSimpleItem) findViewWithTag).setRightText(HardCodeUtil.qqStr(R.string.kp_));
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@androidx.annotation.Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            this.C = getActivity().getIntent();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        o03.c.b();
        Iterator<LinearLayout> it = this.J.iterator();
        while (true) {
            int i3 = 1;
            if (it.hasNext()) {
                QFormSimpleItem qFormSimpleItem = (QFormSimpleItem) it.next().findViewById(R.id.t8c);
                if (qFormSimpleItem != null) {
                    Iterator<n03.a> it5 = this.D.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            n03.a next = it5.next();
                            if (!TextUtils.isEmpty(next.f417924b) && next.f417924b.equals(qFormSimpleItem.getTag())) {
                                Integer valueOf = Integer.valueOf(this.H);
                                if (next.f417925c == 0) {
                                    i3 = 0;
                                }
                                VideoReport.reportEvent("dt_imp_end", qFormSimpleItem, Ch(valueOf, i3));
                            }
                        }
                    }
                }
            } else {
                VideoReport.reportEvent("dt_imp_end", this.K, Ch(Integer.valueOf(this.H), 1 ^ (this.I ? 1 : 0)));
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onFinish();
        }
    }
}
