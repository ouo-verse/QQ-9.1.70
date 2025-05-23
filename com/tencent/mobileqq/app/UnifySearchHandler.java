package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import circlesearch.CircleSearchExhibition$UnifySearchResultExt;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.api.ISearchReportApi;
import com.tencent.mobileqq.search.api.impl.FunctionConfigManagerImpl;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchBusiHotWord$ClueWordItem;
import pb.unify.search.UnifySearchBusiHotWord$GroupWord;
import pb.unify.search.UnifySearchBusiHotWord$HotWordItem;
import pb.unify.search.UnifySearchBusiHotWord$ReqBody;
import pb.unify.search.UnifySearchBusiHotWord$RspBody;
import pb.unify.search.UnifySearchGroupDiscovery$GroupDiscoveryReq;
import pb.unify.search.UnifySearchGroupDiscovery$GroupDiscoveryRsp;
import pb.unify.search.UnifySearchGroupDiscovery$GuessWantItem;
import pb.unify.search.UnifySearchGroupDiscovery$GuessWantSearch;
import pb.unify.search.UnifyTabSearch$ReqBody;
import pb.unify.search.UnifyTabSearch$RspBody;
import pb.unify.search.UnifyTabSearch$SubHotWord;
import unify.search.UnifySearchCommon$ExtensionRequestInfo;
import unify.search.UnifySearchCommon$ResultItemGroup;
import unify.search.UnifySearchCommon$RootSearcherRequest;

/* compiled from: P */
/* loaded from: classes11.dex */
public class UnifySearchHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;
    public static String C;
    public static String D;

    /* renamed from: f, reason: collision with root package name */
    public static long[] f195166f;

    /* renamed from: h, reason: collision with root package name */
    public static long[] f195167h;

    /* renamed from: i, reason: collision with root package name */
    public static long[] f195168i;

    /* renamed from: m, reason: collision with root package name */
    public static String f195169m;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f195170d;

    /* renamed from: e, reason: collision with root package name */
    private ByteStringMicro f195171e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.UnifySearchHandler$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f195172d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f195173e;
        final /* synthetic */ UnifySearchHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream openFileOutput = BaseApplication.getContext().openFileOutput(this.f195172d, 0);
                    if (openFileOutput != null) {
                        openFileOutput.write((byte[]) this.f195173e);
                        openFileOutput.flush();
                    } else {
                        QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 1, "saveData openFileOutput == null");
                    }
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e16) {
                            e = e16;
                            if (!QLog.isColorLevel()) {
                                return;
                            }
                            QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, QLog.getStackTraceString(e));
                        }
                    }
                } catch (IOException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, QLog.getStackTraceString(e17));
                    }
                    if (0 != 0) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e18) {
                            e = e18;
                            if (!QLog.isColorLevel()) {
                                return;
                            }
                            QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, QLog.getStackTraceString(e));
                        }
                    }
                }
            } catch (Throwable th5) {
                if (0 != 0) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e19) {
                        if (QLog.isColorLevel()) {
                            QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, QLog.getStackTraceString(e19));
                        }
                    }
                }
                throw th5;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public CircleSearchExhibition$UnifySearchResultExt f195174a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70021);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        f195166f = new long[]{1001, Constant.FROM_ID_UNINSTALL_PLUGIN, Constant.FROM_ID_START_ACTIVITY, Constant.FROM_ID_STOP_SERVICE, 2073745984, 1006, 1007, 1108, 1109, 1111, 1110};
        f195167h = new long[]{1004};
        f195168i = new long[]{2073745984, 1073745984, 1001, Constant.FROM_ID_UNINSTALL_PLUGIN, Constant.FROM_ID_START_ACTIVITY, Constant.FROM_ID_STOP_SERVICE, 1006};
        f195169m = "hot_word_for_sub_business_unify";
        C = "hot_word_for_sub_business_req_time_unify";
        D = "hot_word_for_sub_business_exprire_time_unify";
    }

    public UnifySearchHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f195170d = qQAppInterface;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String D2(Bundle bundle, String str) {
        String str2;
        JSONObject jSONObject;
        if (bundle != null) {
            int i3 = bundle.getInt(IProfileCardConst.KEY_FROM_TYPE, -1);
            int i16 = bundle.getInt("from_type_for_report", -1);
            if (i3 == 99 || i16 == 11) {
                JSONObject jSONObject2 = null;
                try {
                    if (str != null) {
                        jSONObject = new JSONObject(str);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject2 = jSONObject;
                    jSONObject2.put("scenario", "related_people_and_groups_panel");
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "getMergedJsonData JSONException", e16);
                    }
                }
                if (jSONObject2 != null) {
                    str2 = jSONObject2.toString();
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "getMergedJsonData finalJsonData = " + str2 + ",inputJson = " + str + ",extraData = " + bundle);
                    }
                    return str2;
                }
            }
        }
        str2 = str;
        if (QLog.isColorLevel()) {
        }
        return str2;
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "<<---handleTimeOut serviceCmd:" + serviceCmd);
        }
    }

    private void I2(int i3, Object obj) {
        QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "[handleUnifySearchGroupDiscovery] resultCode: " + i3);
        if (i3 == 1000 && (obj instanceof byte[])) {
            UnifySearchGroupDiscovery$GroupDiscoveryRsp unifySearchGroupDiscovery$GroupDiscoveryRsp = new UnifySearchGroupDiscovery$GroupDiscoveryRsp();
            try {
                unifySearchGroupDiscovery$GroupDiscoveryRsp.mergeFrom((byte[]) obj);
                UnifySearchGroupDiscovery$GuessWantSearch unifySearchGroupDiscovery$GuessWantSearch = unifySearchGroupDiscovery$GroupDiscoveryRsp.guess_want_items.get();
                boolean z16 = unifySearchGroupDiscovery$GroupDiscoveryRsp.is_jump_to_net_result_page.get();
                this.f195171e = unifySearchGroupDiscovery$GroupDiscoveryRsp.session_info.get();
                if (unifySearchGroupDiscovery$GuessWantSearch == null) {
                    notifyUI(1010, false, new Object[]{Boolean.valueOf(z16)});
                    return;
                }
                List<UnifySearchGroupDiscovery$GuessWantItem> list = unifySearchGroupDiscovery$GuessWantSearch.items.get();
                if (list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    Iterator<UnifySearchGroupDiscovery$GuessWantItem> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new com.tencent.mobileqq.activity.contact.addcontact.groupsearch.guess.b(it.next()));
                    }
                    notifyUI(1010, true, new Object[]{arrayList, Boolean.valueOf(z16)});
                    QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "[handleUnifySearchGroupDiscovery] success");
                    return;
                }
                notifyUI(1010, false, new Object[]{Boolean.valueOf(z16)});
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                notifyUI(1010, false, new Object[]{Boolean.FALSE});
                QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "[handleUnifySearchGroupDiscovery] exception: " + e16);
                return;
            }
        }
        notifyUI(1010, false, new Object[]{Boolean.FALSE});
    }

    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            long j3 = toServiceMsg.extraData.getLong(ISearchReportApi.KEY_SEND_REQ_TIME);
            if (j3 <= 0) {
                return;
            }
            ua0.j.g(new QCircleAlphaUserReportDataBuilder().setCmd(toServiceMsg.getServiceCmd()).setSvrRetCode(String.valueOf(fromServiceMsg.getResultCode())).setTimeCost(System.currentTimeMillis() - j3).setUser(this.f195170d.getCurrentAccountUin()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<BusinessGroupWord> K2(ToServiceMsg toServiceMsg, List<UnifySearchBusiHotWord$GroupWord> list) {
        String str;
        byte[] wupBuffer;
        if (toServiceMsg != null && (wupBuffer = toServiceMsg.getWupBuffer()) != null && wupBuffer.length > 4) {
            UnifySearchBusiHotWord$ReqBody unifySearchBusiHotWord$ReqBody = new UnifySearchBusiHotWord$ReqBody();
            try {
                unifySearchBusiHotWord$ReqBody.mergeFrom(wupBuffer, 4, wupBuffer.length - 4);
                str = unifySearchBusiHotWord$ReqBody.key_word.get().toStringUtf8();
            } catch (Exception e16) {
                QLog.w("Q.uniteSearch.UnifySearchHandler818searchProto_new", 1, e16.getMessage(), e16);
            }
            if (!TextUtils.isEmpty(str)) {
                return L2(list);
            }
            return M2(str, list);
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
        }
    }

    private List<BusinessGroupWord> L2(List<UnifySearchBusiHotWord$GroupWord> list) {
        ArrayList arrayList = new ArrayList();
        FunctionConfigManagerImpl.busiHotWordListMap.clear();
        FunctionConfigManagerImpl.busiClueItemWordMap.clear();
        for (UnifySearchBusiHotWord$GroupWord unifySearchBusiHotWord$GroupWord : list) {
            ArrayList arrayList2 = new ArrayList(list.size());
            BusinessGroupWord.b bVar = new BusinessGroupWord.b(unifySearchBusiHotWord$GroupWord.group_id.get().rpt_group_mask.get());
            List<UnifySearchBusiHotWord$HotWordItem> list2 = unifySearchBusiHotWord$GroupWord.rpt_hot_word_items.get();
            new ArrayList();
            for (UnifySearchBusiHotWord$HotWordItem unifySearchBusiHotWord$HotWordItem : list2) {
                arrayList2.add(new BusinessGroupWord.c(unifySearchBusiHotWord$HotWordItem.word_id.get().toStringUtf8(), unifySearchBusiHotWord$HotWordItem.word.get().toStringUtf8()));
            }
            FunctionConfigManagerImpl.busiHotWordListMap.put(FunctionConfigManagerImpl.convertGroupMaskToKey(bVar.f283445a), arrayList2);
            UnifySearchBusiHotWord$ClueWordItem unifySearchBusiHotWord$ClueWordItem = unifySearchBusiHotWord$GroupWord.clue_word_item.get();
            String stringUtf8 = unifySearchBusiHotWord$ClueWordItem.word_id.get().toStringUtf8();
            String stringUtf82 = unifySearchBusiHotWord$ClueWordItem.word.get().toStringUtf8();
            BusinessGroupWord.a aVar = new BusinessGroupWord.a(stringUtf8, stringUtf82);
            FunctionConfigManagerImpl.busiClueItemWordMap.put(FunctionConfigManagerImpl.convertGroupMaskToKey(bVar.f283445a), stringUtf82);
            arrayList.add(new BusinessGroupWord(bVar, arrayList2, aVar));
        }
        return arrayList;
    }

    private List<BusinessGroupWord> M2(String str, List<UnifySearchBusiHotWord$GroupWord> list) {
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        for (UnifySearchBusiHotWord$GroupWord unifySearchBusiHotWord$GroupWord : list) {
            for (UnifySearchBusiHotWord$HotWordItem unifySearchBusiHotWord$HotWordItem : unifySearchBusiHotWord$GroupWord.rpt_hot_word_items.get()) {
                BusinessGroupWord.c cVar = new BusinessGroupWord.c(unifySearchBusiHotWord$HotWordItem.word_id.get().toStringUtf8(), unifySearchBusiHotWord$HotWordItem.word.get().toStringUtf8());
                cVar.f283448c = unifySearchBusiHotWord$HotWordItem.extension.get().toStringUtf8();
                arrayList.add(cVar);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = unifySearchBusiHotWord$GroupWord.title.get();
            }
        }
        BusinessGroupWord businessGroupWord = new BusinessGroupWord();
        businessGroupWord.hotWordItemList = arrayList;
        businessGroupWord.keyword = str;
        businessGroupWord.title = str2;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(businessGroupWord);
        return arrayList2;
    }

    private void O2(String str, long j3, long j16) {
        P2(str, j3, j16, "");
    }

    private void handleError(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "<<---handleError serviceCmd:" + serviceCmd);
        }
    }

    public void E2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "[groupDiscoverySearch]");
        UnifySearchGroupDiscovery$GroupDiscoveryReq unifySearchGroupDiscovery$GroupDiscoveryReq = new UnifySearchGroupDiscovery$GroupDiscoveryReq();
        unifySearchGroupDiscovery$GroupDiscoveryReq.from.set(1);
        if (z16) {
            unifySearchGroupDiscovery$GroupDiscoveryReq.session_info.set(this.f195171e);
        } else {
            this.f195171e = null;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("UnifySearch.GroupDiscovery");
        createToServiceMsg.putWupBuffer(unifySearchGroupDiscovery$GroupDiscoveryReq.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void F2(ToServiceMsg toServiceMsg, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, Integer.valueOf(i3), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "<<---handleBusiHotWord. resultCode=" + i3);
        }
        if (toServiceMsg != null) {
            O2("UnifySearch.BusiHotWord", toServiceMsg.extraData.getLong(ISearchReportApi.KEY_SEND_REQ_TIME), i3);
        }
        if (i3 != 1000) {
            notifyUI(1002, false, null);
            return;
        }
        if (obj == null) {
            notifyUI(1002, false, null);
            return;
        }
        if (!(obj instanceof byte[])) {
            notifyUI(1002, false, null);
            return;
        }
        UnifySearchBusiHotWord$RspBody unifySearchBusiHotWord$RspBody = new UnifySearchBusiHotWord$RspBody();
        try {
            unifySearchBusiHotWord$RspBody.mergeFrom((byte[]) obj);
            int i16 = unifySearchBusiHotWord$RspBody.result_code.get();
            String str = unifySearchBusiHotWord$RspBody.error_msg.get();
            if (i16 == 0) {
                int i17 = unifySearchBusiHotWord$RspBody.expire_time.get();
                BaseApplication.getContext().getSharedPreferences(f195169m, 0).edit().putInt(D, i17).commit();
                List<UnifySearchBusiHotWord$GroupWord> list = unifySearchBusiHotWord$RspBody.rpt_item_groups.get();
                notifyUI(1002, true, new Object[]{Integer.valueOf(i17), K2(toServiceMsg, list)});
                if (QLog.isColorLevel()) {
                    QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "response data: expireTime:" + i17 + ",resultItemList :" + list.toString());
                }
            } else {
                notifyUI(1002, false, new Object[]{Integer.valueOf(i16), str});
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            notifyUI(1002, false, null);
            e16.printStackTrace();
        }
    }

    public void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        Object obj2;
        boolean z17;
        char c16;
        boolean z18;
        Object[] objArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        int resultCode = fromServiceMsg.getResultCode();
        QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "<<---handleTabSearchWrapResult. resultCode=" + resultCode);
        String string = toServiceMsg.extraData.getString("keyword", "");
        String string2 = toServiceMsg.extraData.getString("time", "");
        long[] longArray = toServiceMsg.extraData.getLongArray("masks");
        boolean z19 = toServiceMsg.extraData.getBoolean("isFirstReq");
        boolean z26 = toServiceMsg.extraData.getBoolean(QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, false);
        String string3 = toServiceMsg.extraData.getString("traceId", "");
        Object[] objArr2 = {string, Boolean.valueOf(z19), string2, -1, "", longArray, string3};
        P2("UnifySearch.Tab", toServiceMsg.extraData.getLong(ISearchReportApi.KEY_SEND_REQ_TIME), resultCode, string);
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
        UnifyTabSearch$RspBody unifyTabSearch$RspBody = new UnifyTabSearch$RspBody();
        try {
            unifyTabSearch$RspBody.mergeFrom((byte[]) obj);
            int i16 = unifyTabSearch$RspBody.result_code.get();
            String str = unifyTabSearch$RspBody.error_msg.get();
            if (i16 != 0 && i16 < 1000) {
                Object[] objArr3 = {string, Boolean.valueOf(z19), string2, Integer.valueOf(i16), str, longArray, string3};
                try {
                    notifyUI(1000, false, objArr3);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    obj2 = objArr3;
                    z16 = false;
                    notifyUI(i3, z16, obj2);
                    e.printStackTrace();
                }
            }
            byte[] byteArray = unifyTabSearch$RspBody.cookie.get().toByteArray();
            if (unifyTabSearch$RspBody.search_ver.has()) {
                SearchUtils.p1("UnifySearch.Tab", longArray, unifyTabSearch$RspBody.search_ver.get().toStringUtf8());
            }
            if (unifyTabSearch$RspBody.is_end.get() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            Boolean valueOf = Boolean.valueOf(z17);
            List<UnifySearchCommon$ResultItemGroup> list = unifyTabSearch$RspBody.item_groups.get();
            ip2.h hVar = new ip2.h();
            if (z26) {
                c16 = 1;
                hVar.b(true);
            } else {
                c16 = 1;
            }
            try {
                Object[] objArr4 = new Object[3];
                objArr4[0] = string;
                objArr4[c16] = list;
                objArr4[2] = Integer.valueOf(toServiceMsg.extraData.getInt(IProfileCardConst.KEY_FROM_TYPE));
                List<com.tencent.mobileqq.search.model.x> a16 = hVar.a(objArr4);
                String stringUtf8 = unifyTabSearch$RspBody.sub_hot_top_wording.get().toStringUtf8();
                if (unifyTabSearch$RspBody.dont_need_merge.get() == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                List<UnifyTabSearch$SubHotWord> list2 = unifyTabSearch$RspBody.hot_words.get();
                String stringUtf82 = unifyTabSearch$RspBody.extension.get().toStringUtf8();
                int i17 = unifyTabSearch$RspBody.exhibition_flags.get();
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    try {
                        sb5.append("handleTabSearchWrapResult subId = ");
                        sb5.append(i17);
                        QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, sb5.toString());
                    } catch (InvalidProtocolBufferMicroException e17) {
                        e = e17;
                        obj2 = objArr2;
                        i3 = 1000;
                        z16 = false;
                        notifyUI(i3, z16, obj2);
                        e.printStackTrace();
                    }
                }
                objArr = new Object[13];
                try {
                    objArr[0] = string;
                    objArr[1] = Boolean.valueOf(z19);
                    objArr[2] = string2;
                    objArr[3] = byteArray;
                    objArr[4] = valueOf;
                    objArr[5] = a16;
                    objArr[6] = longArray;
                    objArr[7] = stringUtf8;
                    objArr[8] = list2;
                    objArr[9] = Boolean.valueOf(z18);
                    objArr[10] = stringUtf82;
                    objArr[11] = Integer.valueOf(i17);
                    objArr[12] = string3;
                    i3 = 1000;
                } catch (InvalidProtocolBufferMicroException e18) {
                    e = e18;
                    z16 = false;
                    obj2 = objArr2;
                    i3 = 1000;
                    notifyUI(i3, z16, obj2);
                    e.printStackTrace();
                }
            } catch (InvalidProtocolBufferMicroException e19) {
                e = e19;
                z16 = false;
            }
        } catch (InvalidProtocolBufferMicroException e26) {
            e = e26;
            z16 = false;
            obj2 = objArr2;
        }
        try {
            notifyUI(1000, true, objArr);
        } catch (InvalidProtocolBufferMicroException e27) {
            e = e27;
            obj2 = objArr;
            z16 = false;
            notifyUI(i3, z16, obj2);
            e.printStackTrace();
        }
    }

    public byte[] N2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (byte[]) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        return FileUtils.fileToBytes(BaseApplication.getContext().getFileStreamPath(str));
    }

    public void P2(String str, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Long.valueOf(j3), Long.valueOf(j16), str2);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        new com.tencent.mobileqq.statistics.q(this.f195170d).i("dc00899").a("grp_search_engineer").f("search_net").d(str).b(j16 + "", "" + (currentTimeMillis - j3), "" + str2, id0.a.d(null)).g();
    }

    public void Q2(String str, String str2, int i3, List<Long> list, List<Long> list2, byte[] bArr, int i16, double d16, double d17, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, Integer.valueOf(i3), list, list2, bArr, Integer.valueOf(i16), Double.valueOf(d16), Double.valueOf(d17), bundle);
        } else {
            R2(str, str2, i3, list, list2, bArr, i16, d16, d17, bundle, null, 0L, 0);
        }
    }

    public void R2(String str, String str2, int i3, List<Long> list, List<Long> list2, byte[] bArr, int i16, double d16, double d17, Bundle bundle, String str3, long j3, int i17) {
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, Integer.valueOf(i3), list, list2, bArr, Integer.valueOf(i16), Double.valueOf(d16), Double.valueOf(d17), bundle, str3, Long.valueOf(j3), Integer.valueOf(i17));
            return;
        }
        if (QLog.isColorLevel()) {
            i18 = 2;
            QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "send tabSearchWrap keyword = [" + str + "], reqTime = [" + str2 + "], count = [" + i3 + "], businessMaskArray = [" + list + "], cookie = [" + bArr + "], latitude = [" + d16 + "], longitude = [" + d17 + "]\uff0cjsonData = [" + str3 + "]");
        } else {
            i18 = 2;
        }
        UnifyTabSearch$ReqBody unifyTabSearch$ReqBody = new UnifyTabSearch$ReqBody();
        if (TextUtils.isEmpty(str)) {
            QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", i18, "send tabSearch. keyword is empty.");
            return;
        }
        unifyTabSearch$ReqBody.key_word.set(ByteStringMicro.copyFromUtf8(str));
        unifyTabSearch$ReqBody.version.set(ByteStringMicro.copyFromUtf8(AppSetting.f99551k));
        UnifySearchCommon$RootSearcherRequest unifySearchCommon$RootSearcherRequest = new UnifySearchCommon$RootSearcherRequest();
        unifySearchCommon$RootSearcherRequest.business.set(128);
        unifySearchCommon$RootSearcherRequest.page_size.set(i3);
        unifySearchCommon$RootSearcherRequest.rpt_busi_mask.set(list);
        if (bArr != null) {
            unifySearchCommon$RootSearcherRequest.cookie.set(ByteStringMicro.copyFrom(bArr));
        }
        String D2 = D2(bundle, str3);
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "tabSearchWrap finalJsonData = " + D2);
        }
        if (D2 != null) {
            try {
                unifySearchCommon$RootSearcherRequest.json_data.set(ByteStringMicro.copyFrom(D2, "utf-8"));
            } catch (UnsupportedEncodingException e16) {
                QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 1, e16, new Object[0]);
            }
        }
        unifySearchCommon$RootSearcherRequest.query_ctrl_flag.set(i17);
        unifyTabSearch$ReqBody.search_request.set(unifySearchCommon$RootSearcherRequest);
        UnifySearchCommon$ExtensionRequestInfo unifySearchCommon$ExtensionRequestInfo = new UnifySearchCommon$ExtensionRequestInfo();
        if (FunctionConfigManagerImpl.busiHotWordListMap.isEmpty()) {
            i19 = 0;
        } else {
            Iterator<List<BusinessGroupWord.c>> it = FunctionConfigManagerImpl.busiHotWordListMap.values().iterator();
            int i26 = 2;
            while (it.hasNext()) {
                Iterator<BusinessGroupWord.c> it5 = it.next().iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    } else if (str.equals(it5.next())) {
                        i26 = 1;
                        break;
                    }
                }
            }
            i19 = i26;
        }
        unifySearchCommon$ExtensionRequestInfo.key_word_src.set(i19);
        if (list2 != null) {
            unifySearchCommon$ExtensionRequestInfo.rpt_pubacc_local_result.set(list2);
        }
        String j16 = SearchUtil.j();
        unifySearchCommon$ExtensionRequestInfo.trace_id.set(ByteStringMicro.copyFromUtf8(j16));
        unifyTabSearch$ReqBody.extension_request_info.set(unifySearchCommon$ExtensionRequestInfo);
        if (i16 != 0) {
            unifyTabSearch$ReqBody.from_sub_hot_word_id.set(i16, true);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("UnifySearch.Tab");
        createToServiceMsg.extraData.putString("keyword", str);
        createToServiceMsg.extraData.putString("time", str2);
        createToServiceMsg.extraData.putLongArray("masks", SearchUtil.k(list));
        createToServiceMsg.extraData.putBoolean("isFirstReq", bArr == null);
        createToServiceMsg.extraData.putLong(ISearchReportApi.KEY_SEND_REQ_TIME, System.currentTimeMillis());
        createToServiceMsg.extraData.putString("traceId", j16);
        if (bundle != null) {
            boolean z16 = bundle.getBoolean(QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, false);
            int i27 = bundle.getInt("fromTypeForReport", 0);
            if (!z16) {
                SearchUtils.W0("sub_result", "active_search", str, SearchUtils.d0(list), "" + i27, "");
            }
            createToServiceMsg.extraData.putAll(bundle);
        }
        if (j3 > 0) {
            createToServiceMsg.setTimeout(j3);
        }
        createToServiceMsg.putWupBuffer(unifyTabSearch$ReqBody.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return di.class;
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
            QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, sb5.toString());
        }
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "cmd filter error=" + serviceCmd);
                return;
            }
            return;
        }
        if (fromServiceMsg.getResultCode() == 1002) {
            H2(toServiceMsg, fromServiceMsg);
        } else if (fromServiceMsg.getResultCode() != 1000) {
            handleError(toServiceMsg, fromServiceMsg);
        }
        if ("UnifySearch.Tab".equals(serviceCmd)) {
            G2(toServiceMsg, fromServiceMsg, obj);
        } else if ("UnifySearch.GroupDiscovery".equals(serviceCmd)) {
            I2(fromServiceMsg.getResultCode(), obj);
        }
        J2(toServiceMsg, fromServiceMsg);
    }

    public UnifySearchHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
        } else if (appInterface instanceof QQAppInterface) {
            this.f195170d = (QQAppInterface) appInterface;
        }
    }
}
