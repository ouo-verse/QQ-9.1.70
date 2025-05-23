package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected ArrayList<IPublicAccountConfigAttr.a> f79255a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f79256b;

    /* renamed from: c, reason: collision with root package name */
    String f79257c;

    /* renamed from: d, reason: collision with root package name */
    String f79258d;

    /* renamed from: e, reason: collision with root package name */
    protected ay.a f79259e;

    /* renamed from: f, reason: collision with root package name */
    protected View.OnClickListener f79260f = new a();

    /* renamed from: g, reason: collision with root package name */
    protected AdapterView.OnItemClickListener f79261g = new C0803b();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof IPublicAccountConfigAttr.a)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailCustomModuleBaseWrapper", 2, "click!");
            }
            IPublicAccountConfigAttr.a aVar = (IPublicAccountConfigAttr.a) tag;
            ay.a aVar2 = b.this.f79259e;
            if (aVar2 != null) {
                aVar2.d(aVar);
            }
            b.this.c(aVar);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.accountdetail.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C0803b implements AdapterView.OnItemClickListener {
        C0803b() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailCustomModuleBaseWrapper", 2, "onItemClick!");
            }
            IPublicAccountConfigAttr.a aVar = b.this.f79255a.get(i3);
            ay.a aVar2 = b.this.f79259e;
            if (aVar2 != null) {
                aVar2.d(aVar);
            }
            b.this.c(aVar);
        }
    }

    public b(Context context, ArrayList<IPublicAccountConfigAttr.a> arrayList, ay.a aVar, String str, String str2) {
        this.f79255a = new ArrayList<>();
        this.f79256b = context;
        this.f79255a = arrayList;
        this.f79259e = aVar;
        this.f79257c = str;
        this.f79258d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ArrayList<IPublicAccountConfigAttr.a> b(PublicAccountConfigAttrImpl publicAccountConfigAttrImpl, int i3) {
        List<IPublicAccountConfigAttr.a> list;
        ArrayList<IPublicAccountConfigAttr.a> arrayList = new ArrayList<>();
        if (publicAccountConfigAttrImpl != null && (list = publicAccountConfigAttrImpl.configs) != null) {
            for (IPublicAccountConfigAttr.a aVar : list) {
                int i16 = aVar.f79332d;
                boolean z16 = true;
                if (i16 != 0 && (i16 != 1 || i3 != 1)) {
                    z16 = false;
                }
                if (z16) {
                    int i17 = publicAccountConfigAttrImpl.type;
                    if (i17 != 2) {
                        if (i17 == 3 || i17 == 4) {
                            if (aVar.f79333e == 23) {
                                if (!TextUtils.isEmpty(aVar.f79339k) && !TextUtils.isEmpty(aVar.f79330b) && !TextUtils.isEmpty(aVar.f79331c)) {
                                    arrayList.add(aVar);
                                }
                            } else if (!TextUtils.isEmpty(aVar.f79339k) && !TextUtils.isEmpty(aVar.f79330b)) {
                                arrayList.add(aVar);
                            }
                        }
                    } else if (aVar.f79333e == 23) {
                        if (!TextUtils.isEmpty(aVar.f79339k) && !TextUtils.isEmpty(aVar.f79331c)) {
                            arrayList.add(aVar);
                        }
                    } else if (!TextUtils.isEmpty(aVar.f79339k)) {
                        arrayList.add(aVar);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(ArrayList<IPublicAccountConfigAttr.a> arrayList) {
        if (arrayList.size() != this.f79255a.size()) {
            return false;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3) != this.f79255a.get(i3)) {
                return false;
            }
        }
        return true;
    }

    public void c(IPublicAccountConfigAttr.a aVar) {
        String str;
        String str2;
        IPublicAccountDataManager iPublicAccountDataManager;
        PublicAccountDetailImpl publicAccountDetailImpl;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        String str3 = null;
        QQAppInterface qQAppInterface = (runtime == null || !(runtime instanceof QQAppInterface)) ? null : (QQAppInterface) runtime;
        boolean z16 = (qQAppInterface == null || (iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")) == null || (publicAccountDetailImpl = (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfo(this.f79257c)) == null || publicAccountDetailImpl.followType != 1) ? false : true;
        Context context = this.f79256b;
        int reportAccountType = (context == null || !(context instanceof PublicAccountDetailActivityImpl)) ? 1 : PublicAccountDetailImpl.getReportAccountType(qQAppInterface, this.f79257c, null);
        int i3 = aVar.f79329a;
        if (i3 == 3 && aVar.f79333e == 23) {
            String str4 = aVar.f79331c;
            zx.b bVar = new zx.b();
            bVar.b(str4);
            String str5 = bVar.f453632f.f453651g;
            IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
            String str6 = this.f79257c;
            if (z16) {
                str2 = "02";
            } else {
                str2 = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
            }
            iPublicAccountReportUtils.publicAccountReportClickEvent(null, str6, "0X80077F9", "0X80077F9", 0, 0, "2", str5, str2, String.valueOf(reportAccountType), false);
            return;
        }
        if (i3 == 1) {
            try {
                str3 = Uri.parse(aVar.f79336h).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            String str7 = str3;
            IPublicAccountReportUtils iPublicAccountReportUtils2 = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
            String str8 = this.f79257c;
            if (z16) {
                str = "02";
            } else {
                str = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
            }
            iPublicAccountReportUtils2.publicAccountReportClickEvent(null, str8, "0X80077F9", "0X80077F9", 0, 0, "1", str7, str, String.valueOf(reportAccountType), false);
        }
    }
}
