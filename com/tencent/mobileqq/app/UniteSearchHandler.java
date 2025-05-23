package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.api.ISearchReportApi;
import com.tencent.mobileqq.search.api.impl.FunctionConfigManagerImpl;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.search.DynamicKdReport$ReqBody;
import tencent.im.oidb.search.DynamicSearch$ExtensionRequestInfo;
import tencent.im.oidb.search.DynamicSearch$RootSearcherRequest;
import tencent.im.oidb.search.DynamicTabSearch$ReqBody;
import tencent.im.oidb.search.DynamicTabSearch$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class UniteSearchHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static long[] f195175f;

    /* renamed from: h, reason: collision with root package name */
    public static long[] f195176h;

    /* renamed from: i, reason: collision with root package name */
    public static long[] f195177i;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f195178d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f195179e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70023);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f195175f = new long[]{1001, Constant.FROM_ID_UNINSTALL_PLUGIN, Constant.FROM_ID_START_ACTIVITY, Constant.FROM_ID_STOP_SERVICE, 2073745984, 1006};
        f195176h = new long[]{1004};
        f195177i = new long[]{2073745984, 1073745984, 1001, 8001, Constant.FROM_ID_UNINSTALL_PLUGIN, Constant.FROM_ID_START_ACTIVITY, Constant.FROM_ID_STOP_SERVICE, 1006};
    }

    public UniteSearchHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195178d = qQAppInterface;
            this.f195179e = qQAppInterface;
        }
    }

    private String D2(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Object[] objArr;
        long[] jArr;
        boolean z16;
        boolean z17;
        int resultCode = fromServiceMsg.getResultCode();
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "<<---handleTabSearchResult. resultCode=" + resultCode);
        }
        String string = toServiceMsg.extraData.getString("keyword", "");
        String string2 = toServiceMsg.extraData.getString("time", "");
        long[] longArray = toServiceMsg.extraData.getLongArray("masks");
        boolean z18 = toServiceMsg.extraData.getBoolean("isFirstReq");
        Object[] objArr2 = {string, Boolean.valueOf(z18), string2, -1, "", longArray};
        F2("dynamic_tab_search.1", toServiceMsg.extraData.getLong(ISearchReportApi.KEY_SEND_REQ_TIME), resultCode, string);
        int i3 = 1000;
        if (resultCode != 1000) {
            notifyUI(1000, false, objArr2);
            return;
        }
        if (obj == null) {
            notifyUI(1000, false, objArr2);
            return;
        }
        if (!(obj instanceof byte[])) {
            notifyUI(1000, false, objArr2);
            return;
        }
        DynamicTabSearch$RspBody dynamicTabSearch$RspBody = new DynamicTabSearch$RspBody();
        try {
            dynamicTabSearch$RspBody.mergeFrom((byte[]) obj);
            int i16 = dynamicTabSearch$RspBody.result_code.get();
            String str = dynamicTabSearch$RspBody.error_msg.get();
            if (i16 != 0 && i16 < 1000) {
                objArr = new Object[]{string, Boolean.valueOf(z18), string2, Integer.valueOf(i16), str, longArray};
                try {
                    notifyUI(1000, false, objArr);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    notifyUI(i3, false, objArr);
                    e.printStackTrace();
                }
            }
            byte[] byteArray = dynamicTabSearch$RspBody.cookie.get().toByteArray();
            if (dynamicTabSearch$RspBody.search_ver.has()) {
                jArr = longArray;
                SearchUtils.p1("dynamic_tab_search.1", jArr, dynamicTabSearch$RspBody.search_ver.get().toStringUtf8());
            } else {
                jArr = longArray;
            }
            if (dynamicTabSearch$RspBody.is_end.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            try {
                List<com.tencent.mobileqq.search.model.x> a16 = new ip2.e().a(string, dynamicTabSearch$RspBody.item_groups.get(), Integer.valueOf(toServiceMsg.extraData.getInt(IProfileCardConst.KEY_FROM_TYPE)));
                String stringUtf8 = dynamicTabSearch$RspBody.sub_hot_top_wording.get().toStringUtf8();
                if (dynamicTabSearch$RspBody.dont_need_merge.get() == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                Object[] objArr3 = {string, Boolean.valueOf(z18), string2, byteArray, valueOf, a16, jArr, stringUtf8, dynamicTabSearch$RspBody.hot_words.get(), Boolean.valueOf(z17), dynamicTabSearch$RspBody.extension.get().toStringUtf8(), Integer.valueOf(i16)};
                i3 = 1000;
                try {
                    notifyUI(1000, true, objArr3);
                } catch (InvalidProtocolBufferMicroException e17) {
                    e = e17;
                    objArr = objArr3;
                    notifyUI(i3, false, objArr);
                    e.printStackTrace();
                }
            } catch (InvalidProtocolBufferMicroException e18) {
                e = e18;
                objArr = objArr2;
                i3 = 1000;
            }
        } catch (InvalidProtocolBufferMicroException e19) {
            e = e19;
            objArr = objArr2;
        }
    }

    private void F2(String str, long j3, long j16, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        new com.tencent.mobileqq.statistics.q(this.f195178d).i("dc00899").a("grp_search_engineer").f("search_net").d(str).b(j16 + "", "" + (currentTimeMillis - j3), "" + str2, id0.a.d(null)).g();
    }

    public void G2(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, qQAppInterface, str, str2, str3, str4);
            return;
        }
        if (qQAppInterface == null) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        String b16 = com.dataline.util.d.b(com.dataline.util.d.a());
        DynamicKdReport$ReqBody dynamicKdReport$ReqBody = new DynamicKdReport$ReqBody();
        dynamicKdReport$ReqBody.suin.set(D2(currentAccountUin));
        dynamicKdReport$ReqBody.sclientIp.set(D2(b16));
        dynamicKdReport$ReqBody.splatform.set("android");
        dynamicKdReport$ReqBody.sversion.set(D2(AppSetting.f99551k));
        dynamicKdReport$ReqBody.ssessionId.set(D2(currentAccountUin + valueOf));
        dynamicKdReport$ReqBody.stimeStamp.set(D2(valueOf));
        dynamicKdReport$ReqBody.sopername.set("Grp_all_search");
        dynamicKdReport$ReqBody.smodule.set("hot_list");
        dynamicKdReport$ReqBody.saction.set(D2(str));
        dynamicKdReport$ReqBody.sreseverver2.set(D2(str3));
        dynamicKdReport$ReqBody.sreseverver4.set(D2(str2));
        dynamicKdReport$ReqBody.sreseverobj2.set(D2(str4));
        ToServiceMsg createToServiceMsg = createToServiceMsg("KDSearch.1");
        createToServiceMsg.putWupBuffer(dynamicKdReport$ReqBody.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void H2(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, qQAppInterface, str, str2, str3, str4, str5, str6);
            return;
        }
        if (qQAppInterface == null) {
            return;
        }
        QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 1, "sasa_report=" + str + " module=" + com.tencent.qqnt.kernel.nativeinterface.cq.w(str2, 5) + " ver2=" + com.tencent.qqnt.kernel.nativeinterface.cq.w(str3, 5) + " ver4=" + com.tencent.qqnt.kernel.nativeinterface.cq.w(str5, 5) + " ver7=" + com.tencent.qqnt.kernel.nativeinterface.cq.w(str6, 5));
        String valueOf = String.valueOf(System.currentTimeMillis());
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        DynamicKdReport$ReqBody dynamicKdReport$ReqBody = new DynamicKdReport$ReqBody();
        dynamicKdReport$ReqBody.sopername.set("Grp_all_search");
        dynamicKdReport$ReqBody.suin.set(D2(currentAccountUin));
        dynamicKdReport$ReqBody.sreseverver2.set(D2(str3));
        dynamicKdReport$ReqBody.splatform.set("android");
        dynamicKdReport$ReqBody.sversion.set(D2(AppSetting.f99551k));
        dynamicKdReport$ReqBody.smodule.set(D2(str2));
        dynamicKdReport$ReqBody.sreseverobj1.set("2049");
        dynamicKdReport$ReqBody.sreseverver3.set(D2(str4));
        dynamicKdReport$ReqBody.sreseverver4.set(D2(str5));
        dynamicKdReport$ReqBody.sreseverver7.set(D2(str6));
        dynamicKdReport$ReqBody.stimeStamp.set(D2(valueOf));
        dynamicKdReport$ReqBody.saction.set(D2(str));
        ToServiceMsg createToServiceMsg = createToServiceMsg("KDSearch.1");
        createToServiceMsg.putWupBuffer(dynamicKdReport$ReqBody.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void I2(String str, String str2, int i3, List<Long> list, List<Long> list2, byte[] bArr, double d16, double d17, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, Integer.valueOf(i3), list, list2, bArr, Double.valueOf(d16), Double.valueOf(d17), bundle);
        } else {
            J2(str, str2, i3, list, list2, bArr, 0, d16, d17, bundle);
        }
    }

    public void J2(String str, String str2, int i3, List<Long> list, List<Long> list2, byte[] bArr, int i16, double d16, double d17, Bundle bundle) {
        int i17;
        int i18;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Integer.valueOf(i3), list, list2, bArr, Integer.valueOf(i16), Double.valueOf(d16), Double.valueOf(d17), bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            i17 = 2;
            QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "send tabSearch keyword = [" + str + "], reqTime = [" + str2 + "], count = [" + i3 + "], businessMaskArray = [" + list + "], cookie = [" + bArr + "], latitude = [" + d16 + "], longitude = [" + d17 + "]");
        } else {
            i17 = 2;
        }
        DynamicTabSearch$ReqBody dynamicTabSearch$ReqBody = new DynamicTabSearch$ReqBody();
        if (TextUtils.isEmpty(str)) {
            QLog.e("Q.uniteSearch.UniteSearchHandler818searchProto_old", i17, "send tabSearch. keyword is empty.");
            return;
        }
        dynamicTabSearch$ReqBody.key_word.set(ByteStringMicro.copyFromUtf8(str));
        dynamicTabSearch$ReqBody.version.set(ByteStringMicro.copyFromUtf8(AppSetting.f99551k));
        DynamicSearch$RootSearcherRequest dynamicSearch$RootSearcherRequest = new DynamicSearch$RootSearcherRequest();
        dynamicSearch$RootSearcherRequest.business.set(128);
        dynamicSearch$RootSearcherRequest.page_size.set(i3);
        dynamicSearch$RootSearcherRequest.rpt_busi_mask.set(list);
        if (bArr != null) {
            dynamicSearch$RootSearcherRequest.cookie.set(ByteStringMicro.copyFrom(bArr));
        }
        dynamicTabSearch$ReqBody.search_request.set(dynamicSearch$RootSearcherRequest);
        DynamicSearch$ExtensionRequestInfo dynamicSearch$ExtensionRequestInfo = new DynamicSearch$ExtensionRequestInfo();
        dynamicSearch$ExtensionRequestInfo.latitude.set((float) d16);
        dynamicSearch$ExtensionRequestInfo.longitude.set((float) d17);
        if (FunctionConfigManagerImpl.busiHotWordListMap.isEmpty()) {
            i18 = 0;
        } else {
            Iterator<List<BusinessGroupWord.c>> it = FunctionConfigManagerImpl.busiHotWordListMap.values().iterator();
            i18 = 2;
            while (it.hasNext()) {
                Iterator<BusinessGroupWord.c> it5 = it.next().iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    } else if (str.equals(it5.next())) {
                        i18 = 1;
                        break;
                    }
                }
            }
        }
        dynamicSearch$ExtensionRequestInfo.key_word_src.set(i18);
        if (list2 != null) {
            dynamicSearch$ExtensionRequestInfo.rpt_pubacc_local_result.set(list2);
        }
        dynamicTabSearch$ReqBody.extension_request_info.set(dynamicSearch$ExtensionRequestInfo);
        if (i16 != 0) {
            dynamicTabSearch$ReqBody.from_sub_hot_word_id.set(i16, true);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("dynamic_tab_search.1");
        createToServiceMsg.extraData.putString("keyword", str);
        createToServiceMsg.extraData.putString("time", str2);
        createToServiceMsg.extraData.putLongArray("masks", SearchUtil.k(list));
        Bundle bundle2 = createToServiceMsg.extraData;
        if (bArr == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        bundle2.putBoolean("isFirstReq", z16);
        createToServiceMsg.extraData.putLong(ISearchReportApi.KEY_SEND_REQ_TIME, System.currentTimeMillis());
        if (bundle != null) {
            boolean z17 = bundle.getBoolean(QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, false);
            int i19 = bundle.getInt("fromTypeForReport", 0);
            if (!z17) {
                SearchUtils.W0("sub_result", "active_search", str, SearchUtils.d0(list), "" + i19, "");
            }
            createToServiceMsg.extraData.putAll(bundle);
        }
        createToServiceMsg.putWupBuffer(dynamicTabSearch$ReqBody.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return dj.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append("onReceive success ssoSeq: ");
            sb5.append(toServiceMsg.getRequestSsoSeq());
            sb5.append(", serviceCmd: ");
            sb5.append(serviceCmd);
            sb5.append(", resultCode: ");
            sb5.append(fromServiceMsg.getResultCode());
            QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, sb5.toString());
        }
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "cmd filter error=" + serviceCmd);
                return;
            }
            return;
        }
        if ("dynamic_tab_search.1".equals(serviceCmd)) {
            E2(toServiceMsg, fromServiceMsg, obj);
        }
    }

    public UniteSearchHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
            return;
        }
        this.f195179e = appInterface;
        if (appInterface instanceof QQAppInterface) {
            this.f195178d = (QQAppInterface) appInterface;
        }
    }
}
