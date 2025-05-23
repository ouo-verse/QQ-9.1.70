package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.accountdetail.api.IEqqAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.z;
import com.tencent.mobileqq.applets.c;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$GetEqqDetailInfoRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.cc;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import ff0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EqqAccountDetailActivityImpl extends PublicAccountDetailActivityImpl implements IEqqAccountDetailActivity {
    mobileqq_mp$GetEqqAccountDetailInfoResponse gEqqData;
    LinearLayout groupListContainer;
    com.tencent.mobileqq.applets.c newStatusObserver;
    QidianManager qidianManager;
    NewIntent stateIntent;
    NewIntent statusIntent;
    TextView statusTextView;
    String TAG = "EqqAccountDetailActivity";
    EqqDetail eqqDetail = null;
    boolean fromUser = true;
    int selectedState = 0;
    boolean messageSettingActionSheetHasClick = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EqqDetail eqqDetail = EqqAccountDetailActivityImpl.this.eqqDetail;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f78989d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f78990e;

        b(ActionSheet actionSheet, String str) {
            this.f78989d = actionSheet;
            this.f78990e = str;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            this.f78989d.dismiss();
            if (i3 == 0) {
                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl = EqqAccountDetailActivityImpl.this;
                EqqDetail eqqDetail = eqqAccountDetailActivityImpl.eqqDetail;
                if (eqqDetail != null) {
                    CrmUtils.z(((PublicAccountDetailActivityImpl) eqqAccountDetailActivityImpl).app, eqqAccountDetailActivityImpl, eqqDetail.name, eqqAccountDetailActivityImpl.uin, "IvrEnterpriseDetailEngineFalse");
                    return;
                }
                return;
            }
            if (i3 != 1) {
                return;
            }
            EqqAccountDetailActivityImpl.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + this.f78990e)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f78992d;

        c(IPublicAccountConfigAttr.a aVar) {
            this.f78992d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl = EqqAccountDetailActivityImpl.this;
            IPublicAccountConfigAttr.a aVar = this.f78992d;
            int i3 = aVar.f79334f;
            eqqAccountDetailActivityImpl.selectedState = i3;
            eqqAccountDetailActivityImpl.showMessageSettingActionSheet(aVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            EqqAccountDetailActivityImpl.this.messageSettingActionSheetHasClick = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f78995d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f78996e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f78997f;

        e(IPublicAccountConfigAttr.a aVar, ActionSheet actionSheet, int i3) {
            this.f78995d = aVar;
            this.f78996e = actionSheet;
            this.f78997f = i3;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl = EqqAccountDetailActivityImpl.this;
            if (eqqAccountDetailActivityImpl.messageSettingActionSheetHasClick) {
                return;
            }
            eqqAccountDetailActivityImpl.messageSettingActionSheetHasClick = true;
            int i16 = i3 + 1;
            eqqAccountDetailActivityImpl.changeMsgState(this.f78995d, i16);
            this.f78996e.dismiss();
            if (!((EcShopAssistantManager) ((PublicAccountDetailActivityImpl) EqqAccountDetailActivityImpl.this).app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).o(EqqAccountDetailActivityImpl.this.uin) || this.f78997f == i3) {
                return;
            }
            ((EcshopReportHandler) ((PublicAccountDetailActivityImpl) EqqAccountDetailActivityImpl.this).app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).H2(134243867, EqqAccountDetailActivityImpl.this.uin, null, null, null, i16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f extends c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f78999a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f79000b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f79001c;

        f(IPublicAccountConfigAttr.a aVar, int i3, int i16) {
            this.f78999a = aVar;
            this.f79000b = i3;
            this.f79001c = i16;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void a(boolean z16, Object obj) {
            EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl = EqqAccountDetailActivityImpl.this;
            int i3 = eqqAccountDetailActivityImpl.waitingCount - 1;
            eqqAccountDetailActivityImpl.waitingCount = i3;
            if (i3 == 0) {
                eqqAccountDetailActivityImpl.removeLoading();
            }
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void b(boolean z16, Object obj) {
            if (QLog.isColorLevel()) {
                QLog.d(EqqAccountDetailActivityImpl.this.TAG, 2, "success:" + z16);
            }
            EqqAccountDetailActivityImpl.this.removeLoading();
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void c(Object obj) {
            EqqAccountDetailActivityImpl.this.displayToast(R.string.d6b);
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void d(Object obj) {
            if (obj instanceof ArrayList) {
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if ((next instanceof AppletItem) && ((AppletItem) next).f().equals(EqqAccountDetailActivityImpl.this.uin)) {
                        this.f78999a.f79334f = this.f79000b;
                        EqqAccountDetailActivityImpl.this.setAccountData();
                        if (this.f78999a.f79335g == 6) {
                            if (this.f79001c == 1) {
                                EqqAccountDetailActivityImpl.this.setShowMsgFlag(1);
                                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl = EqqAccountDetailActivityImpl.this;
                                ReportController.o(((PublicAccountDetailActivityImpl) eqqAccountDetailActivityImpl).app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, eqqAccountDetailActivityImpl.uin, "mp_msg_ziliao_2", "share_click", 0, 0, "", "", "", "");
                                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl2 = EqqAccountDetailActivityImpl.this;
                                ReportController.o(((PublicAccountDetailActivityImpl) eqqAccountDetailActivityImpl2).app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, eqqAccountDetailActivityImpl2.uin, "0X8004F05", "0X8004F05", 0, 0, "", "", "", "");
                            } else {
                                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl3 = EqqAccountDetailActivityImpl.this;
                                ReportController.o(((PublicAccountDetailActivityImpl) eqqAccountDetailActivityImpl3).app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, eqqAccountDetailActivityImpl3.uin, "0X8004F07", "0X8004F07", 0, 0, "", "", "", "");
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(EqqAccountDetailActivityImpl.this.TAG, 2, String.valueOf(this.f79001c));
                        }
                        EqqAccountDetailActivityImpl.this.saveAccountDetailInSubThread();
                        if (QLog.isColorLevel()) {
                            QLog.d(EqqAccountDetailActivityImpl.this.TAG, 2, "\u72b6\u6001\u5207\u6362\u6210\u529f");
                        }
                        EqqAccountDetailActivityImpl.this.setStatusText(this.f78999a);
                        return;
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public int e() {
            return 7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79003d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79004e;

        g(String str, IPublicAccountConfigAttr.a aVar) {
            this.f79003d = str;
            this.f79004e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EqqAccountDetailActivityImpl.this.jumpWebView(this.f79003d);
            String str = this.f79004e.f79330b;
            if (str != null && str.contains(HardCodeUtil.qqStr(R.string.m_d))) {
                IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl = EqqAccountDetailActivityImpl.this;
                iPublicAccountReportUtils.publicAccountReportClickEventForMigrate(((PublicAccountDetailActivityImpl) eqqAccountDetailActivityImpl).app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, eqqAccountDetailActivityImpl.uin, "0X8005A29", "0X8005A29", 0, 0, "", "", "", "", false);
                return;
            }
            EqqAccountDetailActivityImpl.this.reportItemEvent(this.f79004e.f79330b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h implements BusinessObserver {
        h() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(EqqAccountDetailActivityImpl.this.TAG, 2, "success:" + String.valueOf(z16));
            }
            if (z16) {
                try {
                    if (z16) {
                        byte[] byteArray = bundle.getByteArray("data");
                        if (byteArray != null) {
                            mobileqq_mp$GetEqqAccountDetailInfoResponse mobileqq_mp_geteqqaccountdetailinforesponse = new mobileqq_mp$GetEqqAccountDetailInfoResponse();
                            mobileqq_mp_geteqqaccountdetailinforesponse.mergeFrom(byteArray);
                            if (mobileqq_mp_geteqqaccountdetailinforesponse.ret_info.get().ret_code.get() == 0) {
                                if (EqqAccountDetailActivityImpl.this.eqqDetail != null && (!mobileqq_mp_geteqqaccountdetailinforesponse.seqno.has() || mobileqq_mp_geteqqaccountdetailinforesponse.seqno.get() == EqqAccountDetailActivityImpl.this.eqqDetail.seqno)) {
                                    EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl = EqqAccountDetailActivityImpl.this;
                                    if (eqqAccountDetailActivityImpl.mIsSendMessage && eqqAccountDetailActivityImpl.eqqDetail.followType == 1) {
                                        eqqAccountDetailActivityImpl.gotoChatActivity();
                                    }
                                }
                                EqqAccountDetailActivityImpl.this.gEqqData = mobileqq_mp_geteqqaccountdetailinforesponse;
                                EqqDetail eqqDetail = new EqqDetail(mobileqq_mp_geteqqaccountdetailinforesponse);
                                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl2 = EqqAccountDetailActivityImpl.this;
                                if (eqqAccountDetailActivityImpl2.mIsSendMessage && eqqDetail.followType == 1) {
                                    eqqAccountDetailActivityImpl2.updateDetailInfo(eqqDetail, false);
                                } else {
                                    eqqAccountDetailActivityImpl2.updateDetailInfo(eqqDetail, true);
                                }
                            } else {
                                EqqAccountDetailActivityImpl.this.displayToast(R.string.d6b);
                            }
                        } else {
                            EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl3 = EqqAccountDetailActivityImpl.this;
                            if (!eqqAccountDetailActivityImpl3.isFirst) {
                                eqqAccountDetailActivityImpl3.displayToast(R.string.d6b);
                            }
                        }
                    } else {
                        EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl4 = EqqAccountDetailActivityImpl.this;
                        if (!eqqAccountDetailActivityImpl4.isFirst) {
                            eqqAccountDetailActivityImpl4.displayToast(R.string.d6b);
                        }
                    }
                } catch (Exception unused) {
                }
            } else {
                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl5 = EqqAccountDetailActivityImpl.this;
                if (!eqqAccountDetailActivityImpl5.isFirst) {
                    eqqAccountDetailActivityImpl5.displayToast(R.string.d6b);
                }
            }
            EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl6 = EqqAccountDetailActivityImpl.this;
            int i16 = eqqAccountDetailActivityImpl6.waitingCount - 1;
            eqqAccountDetailActivityImpl6.waitingCount = i16;
            if (i16 == 0) {
                eqqAccountDetailActivityImpl6.removeLoading();
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("crmtest", 4, "receive sendCrmDetailInfoRequest, ts=" + System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79007d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f79008e;

        i(IPublicAccountConfigAttr.a aVar, String str) {
            this.f79007d = aVar;
            this.f79008e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f79007d.f79341m) && !TextUtils.isEmpty(this.f79007d.f79340l)) {
                Intent intent = new Intent(EqqAccountDetailActivityImpl.this, (Class<?>) QQMapActivity.class);
                intent.putExtra(QCircleSchemeAttr.Polymerize.LAT, this.f79007d.f79341m);
                intent.putExtra("lon", this.f79007d.f79340l);
                if (!TextUtils.isEmpty(this.f79008e)) {
                    intent.putExtra("loc", this.f79008e);
                }
                EqqAccountDetailActivityImpl.this.startActivity(intent);
                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl = EqqAccountDetailActivityImpl.this;
                ReportController.o(((PublicAccountDetailActivityImpl) eqqAccountDetailActivityImpl).app, "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, eqqAccountDetailActivityImpl.uin, "", "", "");
                EqqAccountDetailActivityImpl.this.reportItemEvent(this.f79007d.f79330b);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(EqqAccountDetailActivityImpl.this.TAG, 2, "buildMapItemForEqq no lat or lng");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class j implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f79010d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f79011e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f79012f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79013h;

        j(boolean z16, String str, boolean z17, IPublicAccountConfigAttr.a aVar) {
            this.f79010d = z16;
            this.f79011e = str;
            this.f79012f = z17;
            this.f79013h = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EqqAccountDetailActivityImpl.this.showCallConfirm(this.f79010d, this.f79011e, this.f79012f);
            EqqAccountDetailActivityImpl.this.reportItemEvent(this.f79013h.f79330b);
        }
    }

    protected void addGroupList() {
        this.groupListContainer.removeAllViews();
        List<IPublicAccountConfigAttr> castToPaConfigAttrs = this.eqqDetail != null ? ((IPublicAccountConfigAttr) QRoute.api(IPublicAccountConfigAttr.class)).castToPaConfigAttrs(this.eqqDetail.groupInfoList) : null;
        if (castToPaConfigAttrs != null) {
            int size = castToPaConfigAttrs.size();
            boolean z16 = false;
            for (int i3 = 0; i3 < size; i3++) {
                z16 = addGroup(castToPaConfigAttrs.get(i3), i3, size, true, z16);
            }
        }
        addSummaryItemForEqq();
    }

    void addGroupListForEqq() {
        if (isFollowed()) {
            addGroupList();
        } else {
            addUnfollowGroupListForEqq();
        }
    }

    protected void addSummaryItemForEqq() {
        EqqDetail eqqDetail = this.eqqDetail;
        if (eqqDetail == null || TextUtils.isEmpty(eqqDetail.realSummary)) {
            return;
        }
        TextView textView = new TextView(getActivity().getBaseContext());
        textView.setText(this.eqqDetail.realSummary);
        textView.setTextSize(14.0f);
        textView.setTextColor(getActivity().getBaseContext().getResources().getColor(R.color.black));
        float f16 = this.density;
        textView.setPadding((int) (f16 * 16.5d), (int) (f16 * 22.5d), (int) (f16 * 16.5d), (int) (f16 * 22.5d));
        textView.setLineSpacing((int) (f16 * 5.0f), 1.0f);
        textView.setVisibility(0);
        this.groupListContainer.addView(textView);
    }

    protected void addUnfollowGroupListForEqq() {
        this.groupListContainer.removeAllViews();
        EqqDetail eqqDetail = this.eqqDetail;
        if (eqqDetail == null) {
            return;
        }
        if (eqqDetail.groupInfoList != null) {
            List<IPublicAccountConfigAttr> castToPaConfigAttrs = ((IPublicAccountConfigAttr) QRoute.api(IPublicAccountConfigAttr.class)).castToPaConfigAttrs(this.eqqDetail.groupInfoList);
            int size = castToPaConfigAttrs.size();
            boolean z16 = false;
            for (int i3 = 0; i3 < size; i3++) {
                z16 = addGroup(castToPaConfigAttrs.get(i3), i3, size, false, z16);
            }
        }
        addSummaryItemForEqq();
    }

    void afterAddAllDetailItemForEqq(ViewGroup viewGroup, boolean z16) {
        if (this.eqqDetail == null) {
            return;
        }
        if (z16) {
            this.sendMsgBtn.setVisibility(0);
            if (this.eqqDetail.hasIvrAbility()) {
                this.callBtn.setVisibility(0);
            } else {
                this.callBtn.setVisibility(8);
            }
        } else {
            this.sendMsgBtn.setVisibility(8);
            if (this.eqqDetail.hasIvrAbility()) {
                this.callBtn.setVisibility(0);
            } else {
                this.callBtn.setVisibility(8);
            }
        }
        if (needShowQQCall()) {
            this.callBtn.setVisibility(0);
        } else {
            this.callBtn.setVisibility(8);
        }
    }

    protected View buildHistoryItemForEqq(IPublicAccountConfigAttr.a aVar) {
        View inflate = super.getLayoutInflater().inflate(R.layout.c5g, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        String str = aVar.f79330b;
        if (str != null && str.startsWith(HardCodeUtil.qqStr(R.string.m_h))) {
            str = str.replaceFirst(HardCodeUtil.qqStr(R.string.m_g), "");
        }
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.j1x)).setText(aVar.f79331c);
        inflate.setOnClickListener(new a());
        return inflate;
    }

    protected View buildMapItemForEqq(IPublicAccountConfigAttr.a aVar) {
        View inflate = super.getLayoutInflater().inflate(R.layout.c4n, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.f165861dq1)).setImageResource(R.drawable.cad);
        ((ImageView) inflate.findViewById(R.id.f164472yw)).setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R.id.content);
        String str = aVar.f79331c;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        textView.setText(str);
        inflate.setOnClickListener(new i(aVar, str));
        return inflate;
    }

    View buildMsgSettingItem(IPublicAccountConfigAttr.a aVar) {
        if (aVar.f79335g != 6) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "Unhandled ConfigInfo(" + aVar.f79329a + ", " + aVar.f79333e + ", " + aVar.f79335g + ")");
            }
            return null;
        }
        View inflate = super.getLayoutInflater().inflate(R.layout.c5g, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.j1x);
        this.statusTextView = textView;
        int i3 = aVar.f79334f;
        if (i3 != 1 && i3 != 2) {
            textView.setText(R.string.f171062c20);
        } else {
            textView.setText(R.string.c1z);
        }
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        inflate.setOnClickListener(new c(aVar));
        return inflate;
    }

    protected View buildRichTextItemForEqq(IPublicAccountConfigAttr.a aVar) {
        String str = aVar.f79330b;
        if (str != null && str.equals(HardCodeUtil.qqStr(R.string.m_c))) {
            return null;
        }
        View inflate = super.getLayoutInflater().inflate(R.layout.c4n, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.f165861dq1)).setImageResource(R.drawable.caf);
        ((TextView) inflate.findViewById(R.id.content)).setText(aVar.f79330b + " " + aVar.f79331c);
        return inflate;
    }

    View buildStateChangeItem(IPublicAccountConfigAttr.a aVar) {
        return null;
    }

    ViewGroup createGroupLayout() {
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "createGroupLayout");
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "createGroupLayout exit");
        }
        return linearLayout;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        QidianManager qidianManager = (QidianManager) ((PublicAccountDetailActivityImpl) this).app.getManager(QQManagerFactory.QIDIAN_MANAGER);
        this.qidianManager = qidianManager;
        String str = this.uin;
        if (str != null && qidianManager.S(str, false)) {
            Intent intent = new Intent(this, (Class<?>) QidianProfileCardActivity.class);
            intent.putExtra("uin", this.uin);
            startActivity(intent);
            finish();
        }
        return true;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected void follow() {
        cc.a(null, "pubAcc_follow_confirm", this.uin);
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "follow uin=" + this.uin);
        }
        this.needUpdateView = true;
        this.followBtn.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.11
            @Override // java.lang.Runnable
            public void run() {
                EqqAccountDetailActivityImpl.this.needUpdateView = false;
            }
        }, 3000L);
        delayShowLoading(R.string.d5n);
        ((FriendListHandler) ((PublicAccountDetailActivityImpl) this).app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.uin);
        NewIntent newIntent = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
        this.followIntent = newIntent;
        newIntent.putExtra("cmd", "follow");
        mobileqq_mp$FollowRequest mobileqq_mp_followrequest = new mobileqq_mp$FollowRequest();
        if (!TextUtils.isEmpty(this.mSendMessage) && this.mIsReportMessage) {
            mobileqq_mp_followrequest.ext.set(this.mSendMessage);
        }
        mobileqq_mp_followrequest.uin.set((int) Long.parseLong(this.uin));
        mobileqq_mp_followrequest.account_type.set(getAccountType());
        this.followIntent.putExtra("data", mobileqq_mp_followrequest.toByteArray());
        BusinessObserver businessObserver = new BusinessObserver() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.12
            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                if (QLog.isColorLevel()) {
                    QLog.d(EqqAccountDetailActivityImpl.this.TAG, 2, "follow isSuccess:" + String.valueOf(z16));
                }
                if (!z16) {
                    EqqAccountDetailActivityImpl.this.displayToast(R.string.d6b);
                } else {
                    JSONObject jSONObject = new JSONObject();
                    ((FriendListHandler) ((PublicAccountDetailActivityImpl) EqqAccountDetailActivityImpl.this).app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true, false);
                    EqqDetail eqqDetail = EqqAccountDetailActivityImpl.this.eqqDetail;
                    if (eqqDetail != null) {
                        try {
                            jSONObject.put("uin", eqqDetail.uin);
                            jSONObject.put("name", EqqAccountDetailActivityImpl.this.eqqDetail.name);
                            jSONObject.put("summary", EqqAccountDetailActivityImpl.this.eqqDetail.summary);
                            jSONObject.put("certified", EqqAccountDetailActivityImpl.this.eqqDetail.certifiedGrade);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_FIND);
                            arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_POST);
                            arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE);
                            com.tencent.mobileqq.jsp.h.w("follow", jSONObject, arrayList, null);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                    try {
                        if (z16) {
                            byte[] byteArray = bundle.getByteArray("data");
                            if (byteArray != null) {
                                mobileqq_mp$FollowResponse mobileqq_mp_followresponse = new mobileqq_mp$FollowResponse();
                                mobileqq_mp_followresponse.mergeFrom(byteArray);
                                int i16 = mobileqq_mp_followresponse.ret_info.get().ret_code.get();
                                if (i16 == 0) {
                                    EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl = EqqAccountDetailActivityImpl.this;
                                    EqqDetail eqqDetail2 = eqqAccountDetailActivityImpl.eqqDetail;
                                    if (eqqDetail2 != null) {
                                        eqqDetail2.followType = 1;
                                    }
                                    eqqAccountDetailActivityImpl.followBtn.setEnabled(false);
                                    EqqAccountDetailActivityImpl.this.setFollowStatus();
                                    EqqAccountDetailActivityImpl.this.updateFollowInfo();
                                    EqqAccountDetailActivityImpl.this.showAttentionSuccessDlgIfJumpFromOtherApp();
                                    EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl2 = EqqAccountDetailActivityImpl.this;
                                    PublicAccountDetailActivityImpl.reportEvents(((PublicAccountDetailActivityImpl) eqqAccountDetailActivityImpl2).app, eqqAccountDetailActivityImpl2.uin, eqqAccountDetailActivityImpl2.mIntent);
                                    if (!TextUtils.isEmpty(EqqAccountDetailActivityImpl.this.sopType) && !TextUtils.isEmpty(EqqAccountDetailActivityImpl.this.sopName)) {
                                        EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl3 = EqqAccountDetailActivityImpl.this;
                                        QQAppInterface qQAppInterface = ((PublicAccountDetailActivityImpl) eqqAccountDetailActivityImpl3).app;
                                        ReportController.o(qQAppInterface, "CliOper", "", "", eqqAccountDetailActivityImpl3.sopType, eqqAccountDetailActivityImpl3.sopName, 0, 0, "", "", qQAppInterface.getCurrentAccountUin(), EqqAccountDetailActivityImpl.this.uin);
                                        if (QLog.isColorLevel()) {
                                            QLog.d(EqqAccountDetailActivityImpl.this.TAG, 2, "----[follow report done]----");
                                        }
                                    }
                                } else if (i16 == 58) {
                                    EqqAccountDetailActivityImpl.this.displayToast(R.string.d69);
                                } else if (i16 == 65) {
                                    EqqAccountDetailActivityImpl.this.displayToast(R.string.d5i);
                                } else if (i16 == 20) {
                                    EqqAccountDetailActivityImpl.this.displayToast(R.string.d5j);
                                } else {
                                    EqqAccountDetailActivityImpl.this.displayToast(R.string.d6b);
                                }
                            }
                        } else {
                            EqqAccountDetailActivityImpl.this.displayToast(R.string.d6b);
                        }
                    } catch (Exception unused) {
                    }
                }
                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl4 = EqqAccountDetailActivityImpl.this;
                int i17 = eqqAccountDetailActivityImpl4.waitingCount - 1;
                eqqAccountDetailActivityImpl4.waitingCount = i17;
                if (i17 == 0) {
                    eqqAccountDetailActivityImpl4.removeLoading();
                }
                EqqAccountDetailActivityImpl.this.followBtn.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EqqAccountDetailActivityImpl.this.needUpdateView = false;
                    }
                }, 1000L);
            }
        };
        this.followObserver = businessObserver;
        this.followIntent.setObserver(businessObserver);
        ((PublicAccountDetailActivityImpl) this).app.startServlet(this.followIntent);
        this.waitingCount++;
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "follow exit");
        }
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected String getAccountName() {
        EqqDetail eqqDetail = this.eqqDetail;
        if (eqqDetail != null) {
            return eqqDetail.name;
        }
        return "";
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected int getAccountType() {
        return 2;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected int getCertifiedGrade() {
        EqqDetail eqqDetail = this.eqqDetail;
        if (eqqDetail != null) {
            return eqqDetail.certifiedGrade;
        }
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected a.b getShareDetail() {
        EqqDetail eqqDetail = this.eqqDetail;
        return new a.b(eqqDetail.uin, eqqDetail.name, eqqDetail.summary);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    public String getShareUrl() {
        if (this.shareUrl == null) {
            this.shareUrl = "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.uin + "&account_flag=" + this.eqqDetail.eqqAccountFlag + "&jumptype=1&card_type=crm";
        }
        return this.shareUrl;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected void gotoChatActivity() {
        EqqDetail eqqDetail = this.eqqDetail;
        if (eqqDetail != null) {
            open(this.uin, 1008, eqqDetail.name, ChatActivity.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    public void initAccountDetailListView() {
        super.initAccountDetailListView();
        LinearLayout linearLayout = new LinearLayout(this);
        this.groupListContainer = linearLayout;
        linearLayout.setOrientation(1);
        this.groupListContainer.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected boolean isFollowed() {
        EqqDetail eqqDetail = this.eqqDetail;
        return (eqqDetail != null ? eqqDetail.followType : -1) == 1;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected boolean loadCache() {
        EntityManager createEntityManager = ((PublicAccountDetailActivityImpl) this).app.getEntityManagerFactory().createEntityManager();
        this.eqqDetail = (EqqDetail) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) EqqDetail.class, this.uin);
        createEntityManager.close();
        if (this.eqqDetail == null) {
            return false;
        }
        try {
            mobileqq_mp$GetEqqAccountDetailInfoResponse mobileqq_mp_geteqqaccountdetailinforesponse = new mobileqq_mp$GetEqqAccountDetailInfoResponse();
            this.gEqqData = mobileqq_mp_geteqqaccountdetailinforesponse;
            mobileqq_mp_geteqqaccountdetailinforesponse.mergeFrom(this.eqqDetail.accountData);
            PBRepeatMessageField<mobileqq_mp$ConfigGroupInfo> pBRepeatMessageField = this.gEqqData.config_group_info;
            if (pBRepeatMessageField == null) {
                return true;
            }
            this.eqqDetail.groupInfoList = pBRepeatMessageField.get();
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected boolean needShowQQCall() {
        EqqDetail eqqDetail = this.eqqDetail;
        return eqqDetail != null && eqqDetail.hasIvrAbility();
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected boolean needShowUnFollowBtnInActionSheet() {
        EqqDetail eqqDetail = this.eqqDetail;
        return eqqDetail != null && eqqDetail.followType == 1;
    }

    void notifyUpdateDetailInfo(EqqDetail eqqDetail) {
        this.publicAccountHandler.onGetPublicAccount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        NewIntent newIntent = this.stateIntent;
        if (newIntent != null) {
            newIntent.setObserver(null);
            this.stateIntent = null;
        }
        NewIntent newIntent2 = this.statusIntent;
        if (newIntent2 != null) {
            newIntent2.setObserver(null);
            this.statusIntent = null;
        }
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected void open(String str, int i3, String str2, Class<? extends Activity> cls, boolean z16) {
        this.mIntent.getBooleanExtra(IPublicAccountUtil.NEED_FINISH, false);
        EqqDetail eqqDetail = this.eqqDetail;
        if (eqqDetail == null) {
            return;
        }
        if (eqqDetail.followType == 1) {
            Intent intent = new Intent(this, (Class<?>) ChatActivity.class);
            intent.putExtra("chat_subType", 1);
            intent.putExtra(AppConstants.Key.CSPECIAL_FLAG, this.mIntent.getExtras().getInt(AppConstants.Key.CSPECIAL_FLAG));
            intent.putExtra("uin", str);
            intent.putExtra("uintype", 0);
            intent.putExtra("uinname", this.eqqDetail.name);
            intent.putExtra("isforceRequestDetail", z16);
            intent.putExtra("jump_from", 2);
            startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) ChatActivity.class);
        intent2.putExtra("chat_subType", 1);
        intent2.putExtra("uin", str);
        intent2.putExtra("uintype", 1024);
        intent2.putExtra("uinname", this.eqqDetail.name);
        intent2.putExtra("isforceRequestDetail", z16);
        intent2.putExtra("jump_from", 2);
        startActivity(intent2);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected void saveAccountDetailInSubThread() {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.5
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(EqqAccountDetailActivityImpl.this.TAG, 2, "saveEqqDetailInSubThread");
                }
                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl = EqqAccountDetailActivityImpl.this;
                eqqAccountDetailActivityImpl.saveEqqDetailToDBAndCache(eqqAccountDetailActivityImpl.eqqDetail);
            }
        }, 10L);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected void saveDetailForStateChange(int i3, boolean z16) {
        this.eqqDetail.accountData = this.gEqqData.toByteArray();
        if (i3 == 3) {
            EqqDetail eqqDetail = this.eqqDetail;
            eqqDetail.mIsSyncLbs = true;
            eqqDetail.mIsAgreeSyncLbs = z16;
        }
        saveEqqDetailInSubThread(this.eqqDetail);
    }

    void saveEqqDetailInSubThread(final EqqDetail eqqDetail) {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.4
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(EqqAccountDetailActivityImpl.this.TAG, 2, "saveEqqDetailInSubThread");
                }
                EqqAccountDetailActivityImpl.this.saveEqqDetailToDBAndCache(eqqDetail);
            }
        }, 10L);
    }

    void sendCrmDetailInfoRequest() {
        if (QLog.isDevelopLevel()) {
            QLog.d("crmtest", 4, "sendCrmDetailInfoRequest, ts=" + System.currentTimeMillis());
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "sendDetailInfoRequest");
        }
        NewIntent newIntent = this.detailIntent;
        if (newIntent != null) {
            newIntent.setObserver(null);
        }
        NewIntent newIntent2 = new NewIntent(super.getApplicationContext(), com.tencent.biz.m.class);
        this.detailIntent = newIntent2;
        newIntent2.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
        mobileqq_mp$GetEqqDetailInfoRequest mobileqq_mp_geteqqdetailinforequest = new mobileqq_mp$GetEqqDetailInfoRequest();
        mobileqq_mp_geteqqdetailinforequest.version.set(2);
        EqqDetail eqqDetail = this.eqqDetail;
        if (eqqDetail != null) {
            mobileqq_mp_geteqqdetailinforequest.seqno.set(eqqDetail.seqno);
        } else {
            mobileqq_mp_geteqqdetailinforequest.seqno.set(0);
        }
        try {
            mobileqq_mp_geteqqdetailinforequest.eqq_id.set((int) Long.parseLong(this.uin));
        } catch (Exception unused) {
        }
        this.detailIntent.putExtra("data", mobileqq_mp_geteqqdetailinforequest.toByteArray());
        h hVar = new h();
        this.detailObserver = hVar;
        this.detailIntent.setObserver(hVar);
        ((PublicAccountDetailActivityImpl) this).app.startServlet(this.detailIntent);
        this.waitingCount++;
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "sendCrmDetailInfoRequest exit");
        }
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected void sendDetailInfoRequest() {
        sendCrmDetailInfoRequest();
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected void setAccountData() {
        EqqDetail eqqDetail = this.eqqDetail;
        if (eqqDetail != null) {
            eqqDetail.accountData = this.gEqqData.toByteArray();
        }
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected void setIsConfirmed(boolean z16) {
        EqqDetail eqqDetail = this.eqqDetail;
        if (eqqDetail != null) {
            eqqDetail.isConfirmed = z16;
        }
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected void setShowMsgFlag(int i3) {
        EqqDetail eqqDetail = this.eqqDetail;
        if (eqqDetail != null) {
            eqqDetail.mShowMsgFlag = i3;
        }
    }

    void setStatusText(IPublicAccountConfigAttr.a aVar) {
        int i3 = aVar.f79334f;
        this.fromUser = false;
        if (i3 != 1 && i3 != 2) {
            this.statusTextView.setText(R.string.f171062c20);
        } else {
            this.statusTextView.setText(R.string.c1z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    public void share() {
        super.share();
        if (TextUtils.isEmpty(this.uin) || this.eqqDetail == null) {
            return;
        }
        if (this.mShareActionSheet == null) {
            this.mShareActionSheet = new ff0.a(((PublicAccountDetailActivityImpl) this).app, this, getShareDetail(), getAccountType(), getShareUrl());
        }
        this.mShareActionSheet.i();
        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(((PublicAccountDetailActivityImpl) this).app, this.uin, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_10", "pbshare_click");
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    void updateBottomContainer() {
        EqqDetail eqqDetail = this.eqqDetail;
        if (eqqDetail == null) {
            return;
        }
        if (eqqDetail.followType == 1) {
            this.sendMsgBtn.setVisibility(0);
            this.followBtn.setVisibility(8);
            this.bottomContainer.setVisibility(0);
        } else {
            this.followBtn.setVisibility(0);
            this.followBtn.setOnClickListener(this);
            this.sendMsgBtn.setVisibility(8);
            this.bottomContainer.setVisibility(0);
        }
        if (needShowQQCall()) {
            this.btnsDivider1.setVisibility(0);
            this.callBtn.setVisibility(0);
            this.callBtn.setOnClickListener(this);
        } else {
            this.btnsDivider1.setVisibility(8);
            this.callBtn.setVisibility(8);
        }
        if (this.sendMsgBtn.getVisibility() == 8 && this.followBtn.getVisibility() == 8) {
            this.bottomContainer.setVisibility(8);
        }
    }

    void updateDetailInfo(final EqqDetail eqqDetail, final boolean z16) {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(EqqAccountDetailActivityImpl.this.TAG, 2, "updateDetailInfo");
                }
                EqqDetail eqqDetail2 = eqqDetail;
                if (eqqDetail2 != null) {
                    EqqAccountDetailActivityImpl.this.saveEqqDetailToDBAndCache(eqqDetail2);
                    EqqAccountDetailActivityImpl.this.notifyUpdateDetailInfo(eqqDetail);
                    if (!z16) {
                        EqqAccountDetailActivityImpl.super.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                EqqAccountDetailActivityImpl.this.gotoChatActivity();
                            }
                        });
                    } else {
                        EqqAccountDetailActivityImpl.this.mHandler.sendEmptyMessage(1);
                    }
                }
            }
        }, 10L);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected void updateFollowInfo() {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.7
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(EqqAccountDetailActivityImpl.this.TAG, 2, "updateFollowInfo");
                }
                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl = EqqAccountDetailActivityImpl.this;
                EqqDetail eqqDetail = eqqAccountDetailActivityImpl.eqqDetail;
                if (eqqDetail != null) {
                    eqqAccountDetailActivityImpl.saveEqqDetailToDBAndCache(eqqDetail);
                    EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl2 = EqqAccountDetailActivityImpl.this;
                    eqqAccountDetailActivityImpl2.publicAccountHandler.onFollowPublicAccount(eqqAccountDetailActivityImpl2.eqqDetail);
                    EqqAccountDetailActivityImpl.this.sendDetailInfoRequest();
                    EnterpriseQQManager j3 = EnterpriseQQManager.j(((PublicAccountDetailActivityImpl) EqqAccountDetailActivityImpl.this).app);
                    EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl3 = EqqAccountDetailActivityImpl.this;
                    j3.k(((PublicAccountDetailActivityImpl) eqqAccountDetailActivityImpl3).app, eqqAccountDetailActivityImpl3.eqqDetail.uin, true);
                    EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl4 = EqqAccountDetailActivityImpl.this;
                    if (eqqAccountDetailActivityImpl4.mProfileParams == null) {
                        EqqAccountDetailActivityImpl.super.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl5 = EqqAccountDetailActivityImpl.this;
                                eqqAccountDetailActivityImpl5.open(eqqAccountDetailActivityImpl5.uin, 1008, eqqAccountDetailActivityImpl5.eqqDetail.name, ChatActivity.class, true);
                            }
                        });
                    }
                }
            }
        }, 10L);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    void updateListView() {
        if (this.mAccountDetailAdapter != null && this.mAccountDetailListView.getAdapter() != null && (this.eqqDetail == null || this.mAccountDetailAdapter.p() != null)) {
            EqqDetail eqqDetail = this.eqqDetail;
            if (eqqDetail != null) {
                this.mAccountDetailAdapter.M(eqqDetail);
            }
            this.mAccountDetailAdapter.P(getFace());
            this.mAccountDetailAdapter.N(this.groupListContainer);
            this.mAccountDetailAdapter.S(getContainerListviewHeight());
            this.mAccountDetailAdapter.notifyDataSetChanged();
            return;
        }
        if (this.mAccountDetailListView.getAdapter() != null) {
            ((AccountDetailBaseAdapter) this.mAccountDetailListView.getAdapter()).destroy();
            this.mAccountDetailListView.setAdapter((ListAdapter) null);
        }
        AccountDetailBaseAdapter accountDetailBaseAdapter = new AccountDetailBaseAdapter(((PublicAccountDetailActivityImpl) this).app, this, this.uin, this.mAccountDetailListView, this.iconTop, this.iconCicleTop, this.titleViewLayout, this.iconCertifiedTop, this.mTopGestureLayout);
        this.mAccountDetailAdapter = accountDetailBaseAdapter;
        accountDetailBaseAdapter.P(getFace());
        this.mAccountDetailAdapter.N(this.groupListContainer);
        EqqDetail eqqDetail2 = this.eqqDetail;
        if (eqqDetail2 != null) {
            this.mAccountDetailAdapter.M(eqqDetail2);
        }
        this.mAccountDetailListView.j0(false);
        this.mAccountDetailAdapter.S(getContainerListviewHeight());
        this.mAccountDetailListView.setAdapter((ListAdapter) this.mAccountDetailAdapter);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected void updateUnfollowInfo() {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.6
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(EqqAccountDetailActivityImpl.this.TAG, 2, "updateUnfollowInfo");
                }
                EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl = EqqAccountDetailActivityImpl.this;
                EqqDetail eqqDetail = eqqAccountDetailActivityImpl.eqqDetail;
                if (eqqDetail != null) {
                    try {
                        eqqAccountDetailActivityImpl.publicAccountHandler.onUnfollowPublicAccount(eqqDetail);
                        EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl2 = EqqAccountDetailActivityImpl.this;
                        eqqAccountDetailActivityImpl2.deleteAccount(eqqAccountDetailActivityImpl2.eqqDetail);
                        EqqAccountDetailActivityImpl.this.mHandler.sendEmptyMessage(2);
                        ((PublicAccountDetailActivityImpl) EqqAccountDetailActivityImpl.this).app.getMessageFacade().q(EqqAccountDetailActivityImpl.this.uin, 1008);
                        ((PublicAccountDetailActivityImpl) EqqAccountDetailActivityImpl.this).app.getMessageFacade().q(EqqAccountDetailActivityImpl.this.uin, 1024);
                        ((PublicAccountDetailActivityImpl) EqqAccountDetailActivityImpl.this).app.getMessageFacade().q(EqqAccountDetailActivityImpl.this.uin, 0);
                        EqqAccountDetailActivityImpl eqqAccountDetailActivityImpl3 = EqqAccountDetailActivityImpl.this;
                        QQAppInterface qQAppInterface = ((PublicAccountDetailActivityImpl) eqqAccountDetailActivityImpl3).app;
                        String str = eqqAccountDetailActivityImpl3.uin;
                        ReportController.o(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str, "0X8004E43", "0X8004E43", 0, 0, str, "", "", "");
                    } catch (Exception unused) {
                    }
                }
            }
        }, 10L);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
    protected void updateView() {
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, VasPerfReportUtils.WHILE_UPDATE_ITEM);
        }
        addGroupListForEqq();
        updateBottomContainer();
        updateListView();
    }

    void showMessageSettingActionSheet(IPublicAccountConfigAttr.a aVar, int i3) {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createFullScreenDialog(this, null);
        actionSheet.addRadioButton(R.string.c1z, 5, false);
        actionSheet.addRadioButton(R.string.f171062c20, 5, false);
        if (i3 != 1 && i3 != 2) {
            actionSheet.setRadioButtonChecked(1);
        } else {
            actionSheet.setRadioButtonChecked(0);
        }
        int i16 = (i3 == 1 || i3 == 2) ? 0 : 1;
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnDismissListener(new d());
        actionSheet.setOnButtonClickListener(new e(aVar, actionSheet, i16));
        if (actionSheet.isShowing()) {
            return;
        }
        this.messageSettingActionSheetHasClick = false;
        actionSheet.show();
    }

    void showPhoneActionSheet(String str) {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createFullScreenDialog(this, null);
        actionSheet.addButton(R.string.i3u);
        actionSheet.addButton(getString(R.string.ano) + str);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new b(actionSheet, str));
        actionSheet.show();
    }

    protected View buildPhoneItemForEqq(IPublicAccountConfigAttr.a aVar) {
        if (this.eqqDetail == null) {
            return null;
        }
        View inflate = super.getLayoutInflater().inflate(R.layout.c4n, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.f165861dq1)).setImageResource(R.drawable.cag);
        ((ImageView) inflate.findViewById(R.id.f164472yw)).setVisibility(0);
        String str = aVar.f79331c;
        if (str != null) {
            String trim = str.trim();
            boolean hasIvrAbility = this.eqqDetail.hasIvrAbility();
            boolean matches = Pattern.compile("[\\d-]+?").matcher(trim).matches();
            if (matches) {
                ((TextView) inflate.findViewById(R.id.content)).setText(trim);
            } else if (hasIvrAbility) {
                ((TextView) inflate.findViewById(R.id.content)).setText(R.string.i3u);
            } else if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "buildPhoneItem no phone ability and no ivr ability");
            }
            inflate.setOnClickListener(new j(matches, trim, hasIvrAbility, aVar));
            ReportController.o(((PublicAccountDetailActivityImpl) this).app, "CliOper", "", "", "Biz_card", "Biz_card_call", 0, 0, this.uin, "", "", "");
            return inflate;
        }
        return null;
    }

    void deleteAccount(EqqDetail eqqDetail) {
        if (eqqDetail == null) {
            return;
        }
        EntityManager createEntityManager = ((PublicAccountDetailActivityImpl) this).app.getEntityManagerFactory().createEntityManager();
        createEntityManager.remove(eqqDetail);
        createEntityManager.close();
    }

    void saveEqqDetailToDBAndCache(EqqDetail eqqDetail) {
        IPublicAccountDataManager iPublicAccountDataManager;
        if (eqqDetail == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "saveEqqDetailToDBAndCache");
        }
        z zVar = (z) ((PublicAccountDetailActivityImpl) this).app.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
        if (zVar != null) {
            zVar.d(eqqDetail);
        }
        EntityManager createEntityManager = ((PublicAccountDetailActivityImpl) this).app.getEntityManagerFactory().createEntityManager();
        EqqDetail eqqDetail2 = this.eqqDetail;
        if (eqqDetail2 != null && eqqDetail2.getId() != -1) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, eqqDetail.name);
            }
            this.eqqDetail.clone(eqqDetail);
            if (!createEntityManager.update(this.eqqDetail)) {
                createEntityManager.drop(EqqDetail.class);
            }
        } else {
            this.eqqDetail = eqqDetail;
            createEntityManager.persist(eqqDetail);
        }
        createEntityManager.close();
        if (eqqDetail.followType == 1 && (iPublicAccountDataManager = (IPublicAccountDataManager) ((PublicAccountDetailActivityImpl) this).app.getRuntimeService(IPublicAccountDataManager.class, "all")) != null) {
            iPublicAccountDataManager.savePublicAccountInfo(PublicAccountInfo.createPublicAccount(eqqDetail, 0L));
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "saveEqqDetailToDBAndCache exit");
        }
    }

    void showCallConfirm(boolean z16, String str, boolean z17) {
        if (z17 && z16) {
            showPhoneActionSheet(str);
            return;
        }
        if (z16) {
            showPhoneConfirm(str);
            return;
        }
        if (z17) {
            EqqDetail eqqDetail = this.eqqDetail;
            if (eqqDetail != null) {
                CrmUtils.z(((PublicAccountDetailActivityImpl) this).app, this, eqqDetail.name, this.uin, "IvrEnterpriseDetailEngineFalse");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "showCallConfirm no phone ability and no ivr ability");
        }
    }

    public boolean addGroup(IPublicAccountConfigAttr iPublicAccountConfigAttr, int i3, int i16, boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "addGroup start");
        }
        ViewGroup createGroupLayout = createGroupLayout();
        List<IPublicAccountConfigAttr.a> resetConfigInfoListForUnfollow = resetConfigInfoListForUnfollow(iPublicAccountConfigAttr.getConfigs(), z16);
        Iterator<IPublicAccountConfigAttr.a> it = resetConfigInfoListForUnfollow.iterator();
        while (it.hasNext()) {
            if (it.next().f79335g == 5) {
                it.remove();
            }
        }
        int size = resetConfigInfoListForUnfollow.size();
        if (z16 && i3 > 0 && size > 0 && z17) {
            View view = new View(this);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (this.density * 9.0f)));
            view.setBackgroundColor(Color.parseColor("#f0f0f0"));
            createGroupLayout.addView(view);
        }
        boolean z18 = false;
        for (int i17 = 0; i17 < size; i17++) {
            z18 = addCrmDetailItem(createGroupLayout, resetConfigInfoListForUnfollow.get(i17), getItemBgType(size, i16, i3, i17, z16), z16) || z18;
        }
        if (!z16 && i3 == i16 - 1) {
            View view2 = new View(this);
            view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            view2.setBackgroundColor(Color.parseColor("#d6d6d6"));
            createGroupLayout.addView(view2);
        }
        afterAddAllDetailItemForEqq(createGroupLayout, z16);
        this.groupListContainer.addView(createGroupLayout);
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "addGroup exit");
        }
        return z18;
    }

    void changeMsgState(IPublicAccountConfigAttr.a aVar, int i3) {
        int i16;
        int i17 = aVar.f79335g;
        if (i3 == 1) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(((PublicAccountDetailActivityImpl) this).app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.uin, "0X8005A2B", "0X8005A2B", 0, 0, "", "", "", "", false);
            i16 = 1;
        } else {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(((PublicAccountDetailActivityImpl) this).app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.uin, "0X8005A2A", "0X8005A2A", 0, 0, "", "", "", "", false);
            i16 = 3;
        }
        delayShowLoading(R.string.d7n);
        ((PublicAccountDetailActivityImpl) this).app.removeObserver(this.newStatusObserver);
        com.tencent.mobileqq.applets.c cVar = new com.tencent.mobileqq.applets.c(new f(aVar, i16, i3));
        this.newStatusObserver = cVar;
        ((PublicAccountDetailActivityImpl) this).app.addObserver(cVar);
        QQAppInterface qQAppInterface = ((PublicAccountDetailActivityImpl) this).app;
        EqqDetail eqqDetail = this.eqqDetail;
        com.tencent.mobileqq.applets.e.e(qQAppInterface, eqqDetail.uin, eqqDetail.name, i3 == 1 ? 1 : 0);
        this.waitingCount++;
    }

    boolean addCrmDetailItem(ViewGroup viewGroup, IPublicAccountConfigAttr.a aVar, int i3, boolean z16) {
        View inflate;
        boolean z17;
        View findViewById;
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "addCrmDetailItem");
        }
        LayoutInflater layoutInflater = super.getLayoutInflater();
        float f16 = this.density;
        int i16 = (int) (10.0f * f16);
        int i17 = (int) (f16 * 15.0f);
        int i18 = aVar.f79329a;
        if (i18 == 3) {
            int i19 = aVar.f79333e;
            if (i19 == 3) {
                this.sendMsgBtn.setVisibility(0);
                return false;
            }
            if (i19 == 10) {
                inflate = buildMsgSettingItem(aVar);
                if (inflate == null) {
                    return false;
                }
            } else {
                if (i19 == 7) {
                    EqqDetail eqqDetail = this.eqqDetail;
                    aVar.f79341m = eqqDetail.latitude;
                    aVar.f79340l = eqqDetail.longitude;
                    inflate = buildMapItemForEqq(aVar);
                    if (inflate == null) {
                        return false;
                    }
                } else if (i19 == 8) {
                    inflate = buildPhoneItemForEqq(aVar);
                    if (inflate == null) {
                        return false;
                    }
                } else if (i19 == 9) {
                    inflate = buildHistoryItemForEqq(aVar);
                    if (inflate == null) {
                        return false;
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(this.TAG, 2, "unhandled event_id: " + aVar.f79333e);
                    }
                    return false;
                }
                z17 = false;
            }
            z17 = true;
        } else {
            if (i18 == 1) {
                inflate = layoutInflater.inflate(R.layout.c4n, (ViewGroup) null);
                ((ImageView) inflate.findViewById(R.id.f165861dq1)).setImageResource(R.drawable.cae);
                ((ImageView) inflate.findViewById(R.id.f164472yw)).setVisibility(0);
                String str = aVar.f79336h;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                ((TextView) inflate.findViewById(R.id.content)).setText(str);
                if (aVar.f79330b.contains(HardCodeUtil.qqStr(R.string.m_i))) {
                    ReportController.o(((PublicAccountDetailActivityImpl) this).app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.uin, "0X8004E45", "0X8004E45", 0, 0, "", "", "", "");
                }
                inflate.setOnClickListener(new g(str, aVar));
            } else if (i18 == 2) {
                inflate = buildStateChangeItem(aVar);
                if (inflate == null) {
                    return false;
                }
                z17 = true;
            } else if (i18 == 4) {
                inflate = buildRichTextItemForEqq(aVar);
                if (inflate == null) {
                    return false;
                }
            } else {
                if (i18 == 5) {
                    return false;
                }
                inflate = layoutInflater.inflate(R.layout.c4n, (ViewGroup) null);
            }
            z17 = false;
        }
        if (z17) {
            if (i3 == 0) {
                inflate.setBackgroundResource(R.drawable.f160022g);
            } else if (i3 == 1) {
                inflate.setBackgroundResource(R.drawable.f160025j);
            } else if (i3 == 2) {
                inflate.setBackgroundResource(R.drawable.f160024i);
            } else if (i3 == 3) {
                inflate.setBackgroundResource(R.drawable.f160024i);
            } else if (i3 != 4) {
                if (i3 != 5) {
                    inflate.setBackgroundResource(R.drawable.f160022g);
                } else {
                    inflate.setBackgroundResource(R.drawable.f160024i);
                }
            }
            int i26 = aVar.f79329a;
            if (i26 == 4) {
                inflate.setPadding(i17, i17, i17, i17);
            } else if (i26 == 2) {
                if (aVar.f79335g == 5) {
                    inflate.setPadding(i17, i16, i17, i17);
                } else {
                    inflate.setPadding(i17, 0, i17, 0);
                }
            } else {
                inflate.setPadding(i17, i16, i17, i17);
            }
            findViewById = inflate;
        } else {
            findViewById = inflate.findViewById(R.id.b9x);
            if (i3 == 0) {
                findViewById.setBackgroundResource(R.drawable.f160022g);
            } else if (i3 == 1) {
                findViewById.setBackgroundResource(R.drawable.f160025j);
            } else if (i3 == 2) {
                findViewById.setBackgroundResource(R.drawable.f160023h);
            } else if (i3 == 3) {
                findViewById.setBackgroundResource(R.drawable.f160024i);
            } else if (i3 != 4) {
                if (i3 != 5) {
                    findViewById.setBackgroundResource(R.drawable.f160022g);
                } else {
                    findViewById.setBackgroundResource(R.drawable.f160024i);
                }
            }
            findViewById.setPadding(0, i17, i17, i17);
        }
        viewGroup.addView(inflate);
        if (z17 && i3 == 2) {
            View view = new View(findViewById.getContext());
            view.setBackgroundColor(Color.parseColor("#dedfe0"));
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, 1));
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "addCrmDetailItem exit");
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        if (r8 == (r5 - 1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x002a, code lost:
    
        if (r8 == 0) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getItemBgType(int i3, int i16, int i17, int i18, boolean z16) {
        int i19 = 0;
        if (!z16) {
            if (i3 > 1) {
                if (i18 != 0) {
                    if (i18 == i3 - 1) {
                        return 5;
                    }
                    return 3;
                }
                return 1;
            }
            return i19;
        }
        if (i17 == 0) {
            if (i17 == i16 - 1) {
                if (i3 != 1 && i3 > 1) {
                    if (i18 != 0) {
                    }
                    return 1;
                }
                return i19;
            }
            if (i18 != 0) {
                if (i18 == i3 - 1) {
                    return 5;
                }
                return 3;
            }
            return 1;
        }
        if (i17 > 0) {
            i19 = 4;
            if (i17 == i16 - 1) {
                if (i18 != i3 - 1) {
                }
                return 2;
            }
            if (i18 != 0) {
                if (i18 == i3 - 1) {
                    return 5;
                }
                return 3;
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "getItemBgType error groupId < 0");
        }
        return i19;
    }
}
