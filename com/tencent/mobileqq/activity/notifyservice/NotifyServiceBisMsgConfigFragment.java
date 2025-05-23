package com.tencent.mobileqq.activity.notifyservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.INotifySettingApi;
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
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NotifyServiceBisMsgConfigFragment extends QIphoneTitleBarFragment implements CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;
    private Intent C;
    private FormSwitchSimpleItem D;
    private String E;
    private int F;
    private Long G;
    private int H;
    private String I;
    private LinearLayout J;
    private ArrayList<ServiceAssMsgTemplateItem> K;
    private LayoutInflater L;
    private LinearLayout M;
    private o03.b N;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements IOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f183680a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f183681b;

        a(boolean z16, int i3) {
            this.f183680a = z16;
            this.f183681b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NotifyServiceBisMsgConfigFragment.this, Boolean.valueOf(z16), Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            com.tencent.xaction.log.b.a("NotifyServiceBisMsgConfigFragment", 1, "[onResult] ret:" + i3 + ", msg:" + str);
            if (!NotifyServiceBisMsgConfigFragment.this.vh()) {
                return;
            }
            if (i3 == 0) {
                NotifyServiceBisMsgConfigFragment.this.D.setChecked(this.f183680a);
                NotifyServiceBisMsgConfigFragment.this.F = this.f183680a ? 1 : 0;
                NotifyServiceBisMsgConfigFragment.this.C.putExtra("result", this.f183681b);
                NotifyServiceBisMsgConfigFragment.this.C.putExtra("template_id", NotifyServiceBisMsgConfigFragment.this.I);
                NotifyServiceBisMsgConfigFragment.this.C.putExtra("title", NotifyServiceBisMsgConfigFragment.this.E);
                if (NotifyServiceBisMsgConfigFragment.this.getActivity() != null) {
                    NotifyServiceBisMsgConfigFragment.this.getActivity().setResult(-1, NotifyServiceBisMsgConfigFragment.this.C);
                    return;
                }
                return;
            }
            QQToast.makeText(NotifyServiceBisMsgConfigFragment.this.getContext(), HardCodeUtil.qqStr(R.string.f171642oa), 0).show();
            NotifyServiceBisMsgConfigFragment.this.D.setChecked(!this.f183680a);
            NotifyServiceBisMsgConfigFragment.this.F = !this.f183680a ? 1 : 0;
        }
    }

    public NotifyServiceBisMsgConfigFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.J = null;
        this.K = null;
        this.M = null;
        this.N = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            com.tencent.xaction.log.b.c("NotifyServiceBisMsgConfigFragment", 1, "[onResult] activity is null ,return", null);
            return false;
        }
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            return true;
        }
        com.tencent.xaction.log.b.c("NotifyServiceBisMsgConfigFragment", 1, "[onResult] activity is finish ,return", null);
        return false;
    }

    private HashMap<String, Object> wh(Object obj, int i3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("switching_direction", Integer.valueOf(i3));
        hashMap.put("business_type", obj);
        hashMap.putAll(c.a("pg_bas_subbusiness_settings"));
        return hashMap;
    }

    private void xh() {
        int i3;
        FormSwitchSimpleItem formSwitchSimpleItem = (FormSwitchSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.xwe);
        this.D = formSwitchSimpleItem;
        boolean z16 = false;
        formSwitchSimpleItem.setVisibility(0);
        this.M = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f83774kg);
        if (this.F == 1) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        VideoReport.setElementParams(this.D, wh(Integer.valueOf(this.H), i3));
        VideoReport.setElementExposePolicy(this.D, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.D, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.D, "em_bas_accept_notification_switch");
        o03.b bVar = this.N;
        if (bVar != null) {
            bVar.d(this.F, this.I, this.K);
        }
        FormSwitchSimpleItem formSwitchSimpleItem2 = this.D;
        if (this.F == 1) {
            z16 = true;
        }
        formSwitchSimpleItem2.setChecked(z16);
        this.D.setOnCheckedChangeListener(this);
    }

    private void yh() {
        int i3;
        if (!((INotifySettingApi) QRoute.api(INotifySettingApi.class)).bShowSubItemList(this.H)) {
            com.tencent.xaction.log.b.a("NotifyServiceBisMsgConfigFragment", 1, "[optInflateListElements] not white appType, mAppType=" + this.H);
            return;
        }
        ArrayList<ServiceAssMsgTemplateItem> arrayList = this.K;
        if (arrayList != null && arrayList.size() >= 1 && this.M != null && this.J == null) {
            LinearLayout linearLayout = new LinearLayout(this.M.getContext());
            this.J = linearLayout;
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.J.setOrientation(1);
            Iterator<ServiceAssMsgTemplateItem> it = this.K.iterator();
            while (true) {
                i3 = 0;
                if (!it.hasNext()) {
                    break;
                }
                ServiceAssMsgTemplateItem next = it.next();
                LinearLayout linearLayout2 = (LinearLayout) this.L.inflate(R.layout.fpb, (ViewGroup) this.M, false);
                QFormSimpleItem qFormSimpleItem = (QFormSimpleItem) linearLayout2.findViewById(R.id.t8c);
                qFormSimpleItem.showArrow(false);
                qFormSimpleItem.setLeftText(next.f308939d);
                qFormSimpleItem.setContentDescription(next.f308939d);
                this.J.addView(linearLayout2);
            }
            this.M.addView(this.J);
            LinearLayout linearLayout3 = this.J;
            if (this.F != 1) {
                i3 = 8;
            }
            linearLayout3.setVisibility(i3);
            return;
        }
        com.tencent.xaction.log.b.a("NotifyServiceBisMsgConfigFragment", 1, "[optInflateListElements] params invalid, items=" + this.K + ",settingItemLayout=" + this.M + ",itemListLayout=" + this.J);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        if (((QIphoneTitleBarFragment) this).mContentView == null) {
            onFinish();
            return;
        }
        this.L = layoutInflater;
        setTitle(this.E);
        xh();
        yh();
        this.leftView.setContentDescription(HardCodeUtil.qqStr(R.string.f170549u3));
        VideoReport.setPageParams(((QIphoneTitleBarFragment) this).mContentView, c.b());
        VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_ALL);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_bas_subbusiness_settings");
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

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @androidx.annotation.Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, compoundButton, Boolean.valueOf(z16));
        } else {
            boolean isChecked = this.D.getSwitch().isChecked();
            VideoReport.reportEvent("dt_clck", this.D, wh(Integer.valueOf(this.H), !isChecked ? 1 : 0));
            o03.b bVar = this.N;
            if (bVar != null) {
                bVar.b(this.I, isChecked);
            }
            LinearLayout linearLayout = this.J;
            if (linearLayout != null) {
                if (!isChecked) {
                    i3 = 8;
                }
                linearLayout.setVisibility(i3);
            }
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put(this.I, Integer.valueOf(isChecked ? 1 : 0));
            ((INotifyServiceSettingApi) QRoute.api(INotifyServiceSettingApi.class)).requestSetSwitch(1, 3, Integer.valueOf(this.H), this.G, hashMap, new a(isChecked, isChecked ? 1 : 0));
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@androidx.annotation.Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        Intent intent = getActivity().getIntent();
        this.C = intent;
        this.E = intent.getStringExtra("title");
        this.F = this.C.getIntExtra("status", 0);
        this.I = this.C.getStringExtra("template_id");
        this.K = this.C.getParcelableArrayListExtra("template_items");
        this.G = Long.valueOf(this.C.getLongExtra("key_notify_app_id", 0L));
        int intExtra = this.C.getIntExtra("key_notify_app_type", 0);
        this.H = intExtra;
        this.N = o03.c.a(intExtra);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        FormSwitchSimpleItem formSwitchSimpleItem = this.D;
        Integer valueOf = Integer.valueOf(this.H);
        if (this.F == 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        VideoReport.reportEvent("dt_imp_end", formSwitchSimpleItem, wh(valueOf, i3));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onFinish();
        }
    }
}
