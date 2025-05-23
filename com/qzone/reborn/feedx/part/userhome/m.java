package com.qzone.reborn.feedx.part.userhome;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.Observer;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class m extends com.qzone.reborn.feedx.part.g {

    /* renamed from: d, reason: collision with root package name */
    public ActionSheet f55372d;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.w f55373e;

    /* renamed from: f, reason: collision with root package name */
    protected ActionSheet.WatchDismissActions f55374f = new ActionSheet.WatchDismissActions() { // from class: com.qzone.reborn.feedx.part.userhome.l
        @Override // com.tencent.widget.ActionSheet.WatchDismissActions
        public final void onDismissOperations() {
            m.this.M9();
        }
    };

    /* renamed from: h, reason: collision with root package name */
    protected ActionSheet.OnButtonClickListener f55375h = new a();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements ActionSheet.OnButtonClickListener {
        a() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            m mVar = m.this;
            if (mVar.f55372d == null) {
                return;
            }
            ActionSheetHelper.dismissActionSheet(mVar.getActivity(), m.this.f55372d);
            ActionMenuItem actionMenuItem = m.this.f55372d.getActionMenuItem(i3);
            if (actionMenuItem == null) {
                return;
            }
            int i16 = actionMenuItem.action;
            if (i16 == 223) {
                ho.i.z().k(view.getContext(), m.this.f55373e.getMUin());
                LpReportInfo_pf00064.allReport(308, 9, 22);
                return;
            }
            if (i16 == 225) {
                ho.i.z().q(m.this.getActivity(), m.this.f55373e.C2().getValue(), false);
                LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(308, 9, 24), false, false);
            } else {
                if (i16 != 229) {
                    switch (i16) {
                        case 231:
                            m.this.O9();
                            return;
                        case 232:
                            m.this.K9();
                            return;
                        case 233:
                            vo.c.M(m.this.getActivity(), IVipTraceDetailReport.FROM.QZONE_DRESS_UP_PRESONAL_PANEL);
                            LpReportInfo_pf00064.allReport(308, 9, 40);
                            return;
                        case 234:
                            vo.c.G(m.this.getActivity());
                            return;
                        default:
                            return;
                    }
                }
                ho.i.z().v(m.this.getActivity(), m.this.f55373e.getMUin());
            }
        }
    }

    private void I9(x6.a aVar) {
        ArrayList arrayList = new ArrayList();
        if (this.f55373e.K2()) {
            arrayList.add(H9(229, R.string.f173020gj0));
        }
        if (this.f55373e.R2(aVar)) {
            arrayList.add(H9(231, aVar.isSpecialCare ? R.string.goj : R.string.gok));
        }
        if (this.f55373e.I2(aVar)) {
            arrayList.add(H9(232, R.string.gh_));
        }
        arrayList.add(H9(225, R.string.gha));
        arrayList.add(H9(223, R.string.f21929661));
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(getActivity(), arrayList, this.f55375h);
        this.f55372d = createActionSheet;
        createActionSheet.addCancelButton(R.string.cancel);
        this.f55372d.registerWatchDisMissActionListener(this.f55374f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K9() {
        String str;
        x6.a value = this.f55373e.C2().getValue();
        if (value != null) {
            str = value.nickName;
        } else {
            str = "";
        }
        ho.i.g().b(getActivity(), this.f55373e.F2(), str);
        LpReportInfo_pf00064.allReport(308, 9, 1, this.f55373e.getMUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L9(x6.a aVar) {
        if (this.f55373e.M2()) {
            J9(aVar);
        } else {
            I9(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O9() {
        x6.a value = this.f55373e.C2().getValue();
        if (value == null) {
            return;
        }
        if (!value.isSpecialCare) {
            z5.a.f().a(value.uin, getMainHandler());
            LpReportInfo_pf00064.allReport(308, 9, 25);
        } else {
            z5.a.f().v(value.uin, getMainHandler());
            LpReportInfo_pf00064.allReport(308, 9, 26);
        }
    }

    public ActionMenuItem H9(int i3, int i16) {
        return new ActionMenuItem(i3, ActionSheetHelper.getStringById(getActivity(), i16), i3, 0);
    }

    protected void J9(x6.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(H9(225, R.string.gha));
        arrayList.add(H9(233, R.string.f2196166w));
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qzone_master_more_feed_back", true)) {
            arrayList.add(H9(234, R.string.f2196366y));
        }
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(getActivity(), arrayList, this.f55375h);
        this.f55372d = createActionSheet;
        createActionSheet.addCancelButton(R.string.cancel);
        this.f55372d.registerWatchDisMissActionListener(this.f55374f);
    }

    void N9(QZoneResult qZoneResult) {
        String config;
        if (qZoneResult != null && qZoneResult.getSucceed()) {
            int intValue = ((Integer) qZoneResult.getData()).intValue();
            if (intValue == 1) {
                config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSettingYet", "\u8bbe\u7f6e\u6210\u529f");
                com.qzone.reborn.feedx.viewmodel.w wVar = this.f55373e;
                if (wVar != null) {
                    wVar.n3(true);
                }
            } else {
                config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCancelSpecialCare", "\u5df2\u53d6\u6d88\u7279\u522b\u5173\u5fc3");
                com.qzone.reborn.feedx.viewmodel.w wVar2 = this.f55373e;
                if (wVar2 != null) {
                    wVar2.n3(false);
                }
            }
            ToastUtil.s(config, 5);
            com.qzone.reborn.feedx.viewmodel.w wVar3 = this.f55373e;
            if (wVar3 != null) {
                wVar3.i3(intValue == 1);
                if (this.f55373e.K2()) {
                    I9(this.f55373e.C2().getValue());
                    return;
                }
                return;
            }
            return;
        }
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSettingFail", "\u8bbe\u7f6e\u5931\u8d25"), 4);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneUserHomeActionPanelPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        ActionSheet actionSheet;
        super.handleBroadcastMessage(str, obj);
        if (!TextUtils.equals(str, "OPEN_USER_HOME_ACTION_PANEL") || (actionSheet = this.f55372d) == null) {
            return;
        }
        actionSheet.show();
        Window window = this.f55372d.getWindow();
        if (window != null) {
            QUIImmersiveHelper.u(window, true, true);
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && unpack.what == 1000116) {
            N9(unpack);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        this.f55373e = wVar;
        wVar.C2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.feedx.part.userhome.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m.this.L9((x6.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M9() {
        LpReportInfo_pf00064.allReport(308, 9, 8);
    }
}
