package com.tencent.mobileqq.app;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.emosm.EmosmPb$ReqBody;
import com.tencent.pb.emosm.EmosmPb$RspBody;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x10MoveOrderReq;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x1ReqDelTab;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x2ReqFetchTab;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x2RspFetchTab;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes11.dex */
public class r implements az {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f196535a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private WeakReference<EmoticonHandler> f196536b;

    /* renamed from: c, reason: collision with root package name */
    private AtomicInteger f196537c;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<Integer, List<EmosmPb$SubCmd0x2RspFetchTab.TabInfo>> f196538d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<Integer, List<EmosmPb$SubCmd0x2RspFetchTab.TabInfo>> f196539e;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<Integer, List<EmosmPb$SubCmd0x2RspFetchTab.TabInfo>> f196540f;

    /* renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<Integer, List<String>> f196541g;

    public r(@NonNull EmoticonHandler emoticonHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonHandler);
            return;
        }
        this.f196537c = new AtomicInteger();
        this.f196538d = new ConcurrentHashMap<>();
        this.f196539e = new ConcurrentHashMap<>();
        this.f196540f = new ConcurrentHashMap<>();
        this.f196541g = new ConcurrentHashMap<>();
        this.f196535a = emoticonHandler.getCurrentAccountUin();
        this.f196536b = new WeakReference<>(emoticonHandler);
    }

    private void a(int i3, EmoticonResp emoticonResp, int i16, List<EmosmPb$SubCmd0x2RspFetchTab.TabInfo> list) {
        boolean z16;
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f196538d.get(Integer.valueOf(i16)) != null) {
            this.f196538d.get(Integer.valueOf(i16)).addAll(list);
            list = this.f196538d.remove(Integer.valueOf(i16));
        }
        for (EmosmPb$SubCmd0x2RspFetchTab.TabInfo tabInfo : list) {
            EmoticonPackage emoticonPackage = new EmoticonPackage();
            emoticonPackage.epId = String.valueOf(tabInfo.uint32_tab_id.get());
            emoticonPackage.expiretime = tabInfo.fixed32_expire_time.get();
            if (tabInfo.uint32_flags.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            emoticonPackage.valid = z16;
            emoticonPackage.wordingId = tabInfo.int32_wording_id.get();
            emoticonPackage.name = tabInfo.str_tab_name.get();
            if (i3 == 0) {
                emoticonPackage.aio = true;
            } else if (i3 == 1) {
                emoticonPackage.kandian = true;
            }
            arrayList.add(emoticonPackage);
            if (!emoticonPackage.valid) {
                QLog.e("EmoticonTabLegacySubHandler", 1, "TYPE_EMOSM_PS_FETCH: normal emotion ep not valid ; ep = " + emoticonPackage);
            }
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonTabLegacySubHandler", 2, "TYPE_EMOSM_PS_FETCH: normal emotion ep = " + emoticonPackage);
            }
        }
        emoticonResp.data = arrayList;
    }

    private void j(int i3, int i16, int i17, List<EmosmPb$SubCmd0x2RspFetchTab.TabInfo> list, List<EmosmPb$SubCmd0x2RspFetchTab.TabInfo> list2, List<EmosmPb$SubCmd0x2RspFetchTab.TabInfo> list3, ArrayList<String> arrayList, int i18) {
        if (list != null && list2 != null) {
            if (this.f196538d.get(Integer.valueOf(i16)) != null) {
                this.f196538d.get(Integer.valueOf(i16)).addAll(list);
            } else {
                this.f196538d.put(Integer.valueOf(i16), list);
            }
            if (this.f196539e.get(Integer.valueOf(i16)) != null) {
                this.f196539e.get(Integer.valueOf(i16)).addAll(list2);
            } else {
                this.f196539e.put(Integer.valueOf(i16), list2);
            }
            if (this.f196540f.get(Integer.valueOf(i16)) != null) {
                this.f196540f.get(Integer.valueOf(i16)).addAll(list3);
            } else {
                this.f196540f.put(Integer.valueOf(i16), list3);
            }
            ArrayList arrayList2 = new ArrayList();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList2.add(arrayList.get(size));
            }
            if (this.f196541g.get(Integer.valueOf(i16)) != null) {
                this.f196541g.get(Integer.valueOf(i16)).addAll(arrayList2);
            } else {
                this.f196541g.put(Integer.valueOf(i16), arrayList2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonTabLegacySubHandler", 2, "--------secend fetch--------:");
                m(i16, arrayList);
            }
            c(i18, i17, i3, i16);
        }
    }

    private void k(int i3, EmoticonResp emoticonResp, int i16, List<EmosmPb$SubCmd0x2RspFetchTab.TabInfo> list) {
        boolean z16;
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f196539e.get(Integer.valueOf(i16)) != null) {
            this.f196539e.get(Integer.valueOf(i16)).addAll(list);
            list = this.f196539e.remove(Integer.valueOf(i16));
        }
        for (EmosmPb$SubCmd0x2RspFetchTab.TabInfo tabInfo : list) {
            EmoticonPackage emoticonPackage = new EmoticonPackage();
            emoticonPackage.epId = String.valueOf(tabInfo.uint32_tab_id.get());
            emoticonPackage.expiretime = tabInfo.fixed32_expire_time.get();
            if (tabInfo.uint32_flags.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            emoticonPackage.valid = z16;
            emoticonPackage.wordingId = tabInfo.int32_wording_id.get();
            emoticonPackage.name = tabInfo.str_tab_name.get();
            if (i3 == 0) {
                emoticonPackage.aio = true;
            } else if (i3 == 1) {
                emoticonPackage.kandian = true;
            }
            if (tabInfo.int32_tab_type.has()) {
                emoticonPackage.type = tabInfo.int32_tab_type.get();
                if (tabInfo.int32_tab_type.get() == 1) {
                    emoticonPackage.jobType = 3;
                } else if (tabInfo.int32_tab_type.get() == 4) {
                    emoticonPackage.jobType = 5;
                }
            }
            if (!emoticonPackage.valid) {
                QLog.e("EmoticonTabLegacySubHandler", 1, "TYPE_EMOSM_PS_FETCH: magic emotion ep not valid ; ep = " + emoticonPackage);
            }
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonTabLegacySubHandler", 2, "TYPE_EMOSM_PS_FETCH: magic emotion ep = " + emoticonPackage);
            }
            arrayList.add(emoticonPackage);
        }
        emoticonResp.magicData = arrayList;
    }

    private void l(int i3, EmoticonResp emoticonResp, int i16, List<EmosmPb$SubCmd0x2RspFetchTab.TabInfo> list, ArrayList<String> arrayList) {
        boolean z16;
        if (list == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (this.f196540f.get(Integer.valueOf(i16)) != null) {
            this.f196540f.get(Integer.valueOf(i16)).addAll(list);
            list = this.f196540f.remove(Integer.valueOf(i16));
        }
        for (EmosmPb$SubCmd0x2RspFetchTab.TabInfo tabInfo : list) {
            EmoticonPackage emoticonPackage = new EmoticonPackage();
            emoticonPackage.epId = String.valueOf(tabInfo.uint32_tab_id.get());
            emoticonPackage.expiretime = tabInfo.fixed32_expire_time.get();
            if (tabInfo.uint32_flags.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            emoticonPackage.valid = z16;
            emoticonPackage.wordingId = tabInfo.int32_wording_id.get();
            emoticonPackage.name = tabInfo.str_tab_name.get();
            emoticonPackage.jobType = 4;
            if (i3 == 0) {
                emoticonPackage.aio = true;
            } else if (i3 == 1) {
                emoticonPackage.kandian = true;
            }
            arrayList2.add(emoticonPackage);
            if (!emoticonPackage.valid) {
                QLog.e("EmoticonTabLegacySubHandler", 1, "TYPE_EMOSM_PS_FETCH: small emotion ep not valid ; ep = " + emoticonPackage);
            }
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonTabLegacySubHandler", 2, "TYPE_EMOSM_PS_FETCH: small emotion ep = " + emoticonPackage);
            }
        }
        emoticonResp.smallEmoticonData = arrayList2;
        List<String> remove = this.f196541g.remove(Integer.valueOf(i16));
        emoticonResp.tabOrderList = remove;
        if (remove == null) {
            emoticonResp.tabOrderList = new ArrayList();
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            emoticonResp.tabOrderList.add(arrayList.get(size));
        }
    }

    private void m(int i3, ArrayList<String> arrayList) {
        String str = "svr emoticon tab order list " + i3 + " =";
        StringBuilder obtainStringBuilder = ((IEmosmService) QRoute.api(IEmosmService.class)).obtainStringBuilder();
        obtainStringBuilder.append(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            obtainStringBuilder.append(it.next());
            obtainStringBuilder.append(",");
            if (obtainStringBuilder.length() >= 500) {
                QLog.d("EmoticonTabLegacySubHandler", 1, obtainStringBuilder.toString());
                obtainStringBuilder.setLength(str.length());
            }
        }
        QLog.d("EmoticonTabLegacySubHandler", 1, obtainStringBuilder.toString());
    }

    private void n(ToServiceMsg toServiceMsg) {
        EmoticonHandler emoticonHandler = this.f196536b.get();
        if (emoticonHandler != null) {
            emoticonHandler.sendPbReq(toServiceMsg);
        }
    }

    public void b(@NonNull EmosmPb$RspBody emosmPb$RspBody, int i3, @NonNull EmoticonResp emoticonResp, @NonNull IEmoticonManagerService iEmoticonManagerService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, emosmPb$RspBody, Integer.valueOf(i3), emoticonResp, iEmoticonManagerService);
            return;
        }
        emoticonResp.data = null;
        int i16 = emosmPb$RspBody.msg_subcmd0x1_rsp_deltab.get().uint32_tab_id.get();
        emoticonResp.delEpId = i16;
        String valueOf = String.valueOf(i16);
        iEmoticonManagerService.removeTabEmoticonPackage(valueOf, i3);
        com.tencent.mobileqq.emoticon.b.b().g(iEmoticonManagerService.syncFindEmoticonPackageById(valueOf, i3));
    }

    @Override // com.tencent.mobileqq.app.az
    public void c(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        EmosmPb$SubCmd0x2ReqFetchTab emosmPb$SubCmd0x2ReqFetchTab = new EmosmPb$SubCmd0x2ReqFetchTab();
        emosmPb$SubCmd0x2ReqFetchTab.fixed32_timestamp.set(i3);
        emosmPb$SubCmd0x2ReqFetchTab.int32_segment_flag.set(i16);
        EmosmPb$ReqBody emosmPb$ReqBody = new EmosmPb$ReqBody();
        emosmPb$ReqBody.uint32_sub_cmd.set(2);
        emosmPb$ReqBody.uint64_uin.set(Long.valueOf(this.f196535a).longValue());
        emosmPb$ReqBody.msg_subcmd0x2_req_fetchtab.set(emosmPb$SubCmd0x2ReqFetchTab);
        emosmPb$ReqBody.int32_plat_id.set(109);
        emosmPb$ReqBody.str_app_version.set(AppSetting.f99551k);
        emosmPb$ReqBody.uint32_business_id.set(i17);
        if (i18 == 0) {
            int incrementAndGet = this.f196537c.incrementAndGet();
            if (incrementAndGet == 0) {
                incrementAndGet = this.f196537c.incrementAndGet();
            }
            i18 = incrementAndGet;
            this.f196541g.remove(Integer.valueOf(i18));
            this.f196538d.remove(Integer.valueOf(i18));
            this.f196540f.remove(Integer.valueOf(i18));
            this.f196539e.remove(Integer.valueOf(i18));
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f196535a, "BQMallSvc.TabOpReq");
        toServiceMsg.extraData.putInt("EmosmSubCmd", 2);
        toServiceMsg.extraData.putInt("EmosmFetchSeq", i18);
        toServiceMsg.putWupBuffer(emosmPb$ReqBody.toByteArray());
        n(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.az
    public void d(@NonNull CommonTabEmojiInfo commonTabEmojiInfo, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, commonTabEmojiInfo, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.app.az
    public void e(@NotNull List<CommonTabEmojiInfo> list, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, list, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            ArrayList arrayList = new ArrayList();
            Iterator<CommonTabEmojiInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(it.next().epId));
            }
            QLog.d("EmoticonTabLegacySubHandler", 2, "reportEmoticonOrder, ids=" + arrayList);
        }
        if (list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonTabLegacySubHandler", 2, "reportEmoticonOrder, localList null, abort");
                return;
            }
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<CommonTabEmojiInfo> it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList2.add(String.valueOf(it5.next().epId));
        }
        EmosmPb$SubCmd0x10MoveOrderReq emosmPb$SubCmd0x10MoveOrderReq = new EmosmPb$SubCmd0x10MoveOrderReq();
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        try {
            if (z16) {
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    String str = (String) arrayList2.get(size);
                    if (!TextUtils.isEmpty(str)) {
                        arrayList3.add(Integer.valueOf(Integer.parseInt(str)));
                    }
                }
            } else {
                Iterator it6 = arrayList2.iterator();
                while (it6.hasNext()) {
                    String str2 = (String) it6.next();
                    if (!TextUtils.isEmpty(str2)) {
                        arrayList3.add(Integer.valueOf(Integer.parseInt(str2)));
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("EmoticonTabLegacySubHandler", 2, "reportEmoticonOrder, error=" + MsfSdkUtils.getStackTraceString(e16));
            }
        }
        emosmPb$SubCmd0x10MoveOrderReq.uint32_tab_id.set(arrayList3);
        EmosmPb$ReqBody emosmPb$ReqBody = new EmosmPb$ReqBody();
        emosmPb$ReqBody.uint32_sub_cmd.set(16);
        emosmPb$ReqBody.uint64_uin.set(Long.valueOf(this.f196535a).longValue());
        emosmPb$ReqBody.int32_plat_id.set(109);
        emosmPb$ReqBody.str_app_version.set(AppSetting.f99551k);
        emosmPb$ReqBody.msg_subcmd0x10_req.set(emosmPb$SubCmd0x10MoveOrderReq);
        emosmPb$ReqBody.uint32_business_id.set(i3);
        emosmPb$ReqBody.setHasFlag(true);
        if (this.f196536b.get() == null) {
            QLog.e("EmoticonTabLegacySubHandler", 1, "reportEmoticonOrder error, emoticonHandler is null!");
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f196535a, "BQMallSvc.TabOpReq");
        toServiceMsg.extraData.putInt("EmosmSubCmd", 16);
        toServiceMsg.putWupBuffer(emosmPb$ReqBody.toByteArray());
        n(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.az
    public void f(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        EmosmPb$SubCmd0x1ReqDelTab emosmPb$SubCmd0x1ReqDelTab = new EmosmPb$SubCmd0x1ReqDelTab();
        emosmPb$SubCmd0x1ReqDelTab.uint32_tab_id.set(i3);
        EmosmPb$ReqBody emosmPb$ReqBody = new EmosmPb$ReqBody();
        emosmPb$ReqBody.uint32_sub_cmd.set(1);
        emosmPb$ReqBody.uint64_uin.set(Long.valueOf(this.f196535a).longValue());
        emosmPb$ReqBody.msg_subcmd0x1_req_deltab.set(emosmPb$SubCmd0x1ReqDelTab);
        emosmPb$ReqBody.int32_plat_id.set(109);
        emosmPb$ReqBody.uint32_business_id.set(i16);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f196535a, "BQMallSvc.TabOpReq");
        toServiceMsg.extraData.putInt("EmosmPackageId", i3);
        toServiceMsg.extraData.putInt("EmosmSubCmd", 1);
        toServiceMsg.putWupBuffer(emosmPb$ReqBody.toByteArray());
        n(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.az
    public void g(@NonNull ArrayList<Integer> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        EmosmPb$SubCmd0x1ReqDelTab emosmPb$SubCmd0x1ReqDelTab = new EmosmPb$SubCmd0x1ReqDelTab();
        emosmPb$SubCmd0x1ReqDelTab.rpt_tab_id.addAll(arrayList);
        EmosmPb$ReqBody emosmPb$ReqBody = new EmosmPb$ReqBody();
        emosmPb$ReqBody.uint32_sub_cmd.set(1);
        emosmPb$ReqBody.uint64_uin.set(Long.valueOf(this.f196535a).longValue());
        emosmPb$ReqBody.msg_subcmd0x1_req_deltab.set(emosmPb$SubCmd0x1ReqDelTab);
        emosmPb$ReqBody.int32_plat_id.set(109);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f196535a, "BQMallSvc.TabOpReq");
        toServiceMsg.extraData.putInt("EmosmPackageId", -1);
        toServiceMsg.extraData.putInt("EmosmSubCmd", 17);
        toServiceMsg.extraData.putIntegerArrayList("EmosmPackageIds", arrayList);
        toServiceMsg.putWupBuffer(emosmPb$ReqBody.toByteArray());
        n(toServiceMsg);
    }

    public void h(@NonNull ToServiceMsg toServiceMsg, int i3, @NonNull EmoticonResp emoticonResp, @NonNull IEmoticonManagerService iEmoticonManagerService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, toServiceMsg, Integer.valueOf(i3), emoticonResp, iEmoticonManagerService);
            return;
        }
        ArrayList<Integer> integerArrayList = toServiceMsg.extraData.getIntegerArrayList("EmosmPackageIds");
        if (integerArrayList != null && integerArrayList.size() != 0) {
            emoticonResp.ids = integerArrayList;
            Iterator<Integer> it = integerArrayList.iterator();
            while (it.hasNext()) {
                String valueOf = String.valueOf(it.next());
                iEmoticonManagerService.removeTabEmoticonPackage(valueOf, i3);
                com.tencent.mobileqq.emoticon.b.b().g(iEmoticonManagerService.syncFindEmoticonPackageById(valueOf, i3));
            }
        }
    }

    public boolean i(ToServiceMsg toServiceMsg, int i3, EmoticonResp emoticonResp, EmosmPb$RspBody emosmPb$RspBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, toServiceMsg, Integer.valueOf(i3), emoticonResp, emosmPb$RspBody)).booleanValue();
        }
        int i16 = toServiceMsg.extraData.getInt("EmosmFetchSeq");
        EmosmPb$SubCmd0x2RspFetchTab emosmPb$SubCmd0x2RspFetchTab = emosmPb$RspBody.msg_subcmd0x2_rsp_fetchtab.get();
        int i17 = emosmPb$SubCmd0x2RspFetchTab.int32_segment_flag.get();
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonTabLegacySubHandler", 2, "fetchSeq:" + i16 + " cur segement:" + i17 + " mapSize:" + this.f196541g.size());
        }
        List<EmosmPb$SubCmd0x2RspFetchTab.TabInfo> list = emosmPb$SubCmd0x2RspFetchTab.rpt_msg_tabinfo.get();
        List<EmosmPb$SubCmd0x2RspFetchTab.TabInfo> list2 = emosmPb$SubCmd0x2RspFetchTab.rpt_magic_tabinfo.get();
        List<EmosmPb$SubCmd0x2RspFetchTab.TabInfo> list3 = emosmPb$SubCmd0x2RspFetchTab.rpt_smallbq_tabinfo.get();
        ArrayList<String> arrayList = new ArrayList<>();
        if (emosmPb$SubCmd0x2RspFetchTab.uint32_tab_id.has()) {
            Iterator<Integer> it = emosmPb$SubCmd0x2RspFetchTab.uint32_tab_id.get().iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next()));
            }
        }
        int i18 = emosmPb$RspBody.msg_subcmd0x2_rsp_fetchtab.get().fixed32_timestamp.get();
        if (i17 != 0 && i17 != -1) {
            j(i3, i16, i17, list, list2, list3, arrayList, i18);
            return true;
        }
        emoticonResp.timestamp = i18;
        a(i3, emoticonResp, i16, list);
        k(i3, emoticonResp, i16, list2);
        l(i3, emoticonResp, i16, list3, arrayList);
        QLog.d("EmoticonTabLegacySubHandler", 1, "svr big emoticon data size = " + emoticonResp.data.size() + ", magic size = " + emoticonResp.magicData.size() + ", small emotion size = " + emoticonResp.smallEmoticonData.size() + ", tab size = " + emoticonResp.tabOrderList.size());
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonTabLegacySubHandler", 2, "svr big emoticon list=" + emoticonResp.data + "svr magic emoticon list=" + emoticonResp.magicData + "svr small emoticon list=" + emoticonResp.smallEmoticonData);
            m(i16, arrayList);
        }
        return false;
    }
}
