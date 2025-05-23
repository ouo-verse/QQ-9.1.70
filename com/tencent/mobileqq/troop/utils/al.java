package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5$LoginSig;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5$Player;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5$ReqBody;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5$RspBody;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2$GiftBagInfo;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2$LoginSig;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2$Player;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2$ReqBody;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2$RspBody;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3$ExtParam;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3$GetExtraDataReq;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3$GetExtraDataRsp;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3$GetStockReq;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3$GetStockRsp;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3$ImgShowItem;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3$LoginSig;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3$ReqBody;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3$RspBody;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3$StockInfo;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3$StockItem;
import tencent.im.oidb.cmd0x962.oidb_0x962$ClientInfo;
import tencent.im.oidb.cmd0x962.oidb_0x962$ReqBody;
import tencent.im.oidb.cmd0x962.oidb_0x962$RspBody;
import tencent.im.oidb.cmd0xa48.oidb_0xa48$ReqBody;
import tencent.im.oidb.cmd0xa48.oidb_0xa48$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class al extends Observable implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    AppInterface f302014d;

    /* renamed from: e, reason: collision with root package name */
    private EntityManager f302015e;

    /* renamed from: f, reason: collision with root package name */
    ConcurrentHashMap<String, TroopGiftBagInfo> f302016f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends ProtoUtils.c {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ak f302017e;

        a(ak akVar) {
            this.f302017e = akVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this, (Object) akVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null && this.f302017e != null) {
                try {
                    oidb_0x6c3$RspBody oidb_0x6c3_rspbody = new oidb_0x6c3$RspBody();
                    oidb_0x6c3_rspbody.mergeFrom(bArr);
                    int i16 = oidb_0x6c3_rspbody.int32_ret.get();
                    if (i16 == 0 && bundle != null) {
                        int i17 = bundle.getInt("subCmd");
                        if ((i17 == 0 || i17 == 2 || i17 == 7) && oidb_0x6c3_rspbody.msg_get_stock.has()) {
                            oidb_0x6c3$GetStockRsp oidb_0x6c3_getstockrsp = oidb_0x6c3_rspbody.msg_get_stock.get();
                            ArrayList arrayList = new ArrayList(10);
                            if (oidb_0x6c3_getstockrsp.msg_stock.has()) {
                                oidb_0x6c3$StockInfo oidb_0x6c3_stockinfo = oidb_0x6c3_getstockrsp.msg_stock.get();
                                if (oidb_0x6c3_stockinfo.msg_stock.has()) {
                                    List<oidb_0x6c3$StockItem> list = oidb_0x6c3_stockinfo.msg_stock.get();
                                    for (int i18 = 0; i18 < list.size(); i18++) {
                                        oidb_0x6c3$StockItem oidb_0x6c3_stockitem = list.get(i18);
                                        f fVar = new f();
                                        fVar.f302031a = oidb_0x6c3_stockitem.int32_productid.get();
                                        fVar.f302032b = oidb_0x6c3_stockitem.int32_amount.get();
                                        fVar.f302033c = oidb_0x6c3_stockitem.int32_free_limit_chance.get();
                                        arrayList.add(fVar);
                                    }
                                }
                            }
                            this.f302017e.h(oidb_0x6c3_getstockrsp.int32_count.get(), oidb_0x6c3_getstockrsp.int32_give_count.get(), oidb_0x6c3_getstockrsp.bytes_give_info.get().toStringUtf8(), arrayList);
                            SparseArray<g> sparseArray = new SparseArray<>();
                            if (oidb_0x6c3_getstockrsp.msg_imgshow_config.has()) {
                                int size = oidb_0x6c3_getstockrsp.msg_imgshow_config.msg_imgshow_item.size();
                                for (int i19 = 0; i19 < size; i19++) {
                                    oidb_0x6c3$ImgShowItem oidb_0x6c3_imgshowitem = oidb_0x6c3_getstockrsp.msg_imgshow_config.msg_imgshow_item.get(i19);
                                    g gVar = new g();
                                    gVar.f302034a = oidb_0x6c3_imgshowitem.uint32_price.get();
                                    gVar.f302035b = oidb_0x6c3_imgshowitem.bytes_wording.get().toStringUtf8();
                                    gVar.f302036c = oidb_0x6c3_imgshowitem.bytes_cut_wording.get().toStringUtf8();
                                    sparseArray.put(oidb_0x6c3_imgshowitem.uint32_productid.get(), gVar);
                                }
                            }
                            this.f302017e.j(sparseArray);
                            return;
                        }
                        if ((i17 == 1 || i17 == 3 || i17 == 4 || i17 == 5 || i17 == 6 || i17 == 8 || i17 == 9 || i17 == 10) && oidb_0x6c3_rspbody.msg_extra_data.has()) {
                            oidb_0x6c3$GetExtraDataRsp oidb_0x6c3_getextradatarsp = oidb_0x6c3_rspbody.msg_extra_data.get();
                            String c16 = com.tencent.biz.troopgift.c.c(oidb_0x6c3_rspbody.exclusive_gift_list.get());
                            int i26 = oidb_0x6c3_rspbody.msg_extra_data.int32_version_seq.get();
                            this.f302017e.b(oidb_0x6c3_getextradatarsp.bytes_shop_config.get().toStringUtf8(), i26);
                            this.f302017e.c(oidb_0x6c3_getextradatarsp.bytes_shop_config.get().toStringUtf8(), i26, c16);
                            return;
                        }
                        this.f302017e.a(-1, "Invalid RspData. subCmd:" + i17);
                        return;
                    }
                    this.f302017e.a(i16, oidb_0x6c3_rspbody.bytes_msg.get().toStringUtf8());
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6c3. InvalidProtocolBufferMicroException:" + e16);
                    }
                    this.f302017e.a(-1, "InvalidProtocolBufferMicroException");
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6c3. onResult error=" + i3 + " data=" + bArr + " callback=" + this.f302017e);
            }
            ak akVar = this.f302017e;
            if (akVar != null) {
                akVar.a(i3, "sso request error or callback is null.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends ProtoUtils.c {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ak f302019e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f302020f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f302021h;

        b(ak akVar, String str, String str2) {
            this.f302019e = akVar;
            this.f302020f = str;
            this.f302021h = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, al.this, akVar, str, str2);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null && this.f302019e != null) {
                try {
                    oidb_0x6b5$RspBody oidb_0x6b5_rspbody = new oidb_0x6b5$RspBody();
                    oidb_0x6b5_rspbody.mergeFrom(bArr);
                    int i16 = oidb_0x6b5_rspbody.uint32_result.get();
                    if (i16 == 0 && bundle != null) {
                        int i17 = bundle.getInt("subCmd");
                        if (i17 == 0 && oidb_0x6b5_rspbody.msg_grab_result.has()) {
                            oidb_0x6b5$Player oidb_0x6b5_player = oidb_0x6b5_rspbody.msg_grab_result.get();
                            TroopGiftBagInfo troopGiftBagInfo = al.this.f302016f.get(this.f302020f + "_" + this.f302021h);
                            if (troopGiftBagInfo != null) {
                                troopGiftBagInfo.myGrabResult = new com.tencent.mobileqq.troop.data.u(oidb_0x6b5_player.uint64_uin.get(), oidb_0x6b5_player.uint64_time.get(), oidb_0x6b5_player.int32_amount.get(), oidb_0x6b5_player.int32_index.get(), oidb_0x6b5_player.bytes_tips.get().toStringUtf8());
                                al.this.l(troopGiftBagInfo);
                            }
                            this.f302019e.f(oidb_0x6b5_player.uint64_uin.get(), oidb_0x6b5_player.uint64_time.get(), oidb_0x6b5_player.int32_amount.get(), oidb_0x6b5_player.int32_index.get(), oidb_0x6b5_player.bytes_tips.get().toStringUtf8());
                            return;
                        }
                        this.f302019e.a(-1, "Invalid RspData. subCmd:" + i17);
                        return;
                    }
                    this.f302019e.a(i16, oidb_0x6b5_rspbody.bytes_errmsg.get().toStringUtf8());
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6b5. InvalidProtocolBufferMicroException:" + e16);
                    }
                    this.f302019e.a(-1, "InvalidProtocolBufferMicroException");
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6b5. onResult error=" + i3 + " data=" + bArr + " callback=" + this.f302019e);
            }
            ak akVar = this.f302019e;
            if (akVar != null) {
                akVar.a(i3, "sso request error or callback is null.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c extends ProtoUtils.c {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ak f302023e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f302024f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f302025h;

        c(ak akVar, String str, String str2) {
            this.f302023e = akVar;
            this.f302024f = str;
            this.f302025h = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, al.this, akVar, str, str2);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            oidb_0x6c2$Player oidb_0x6c2_player;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null && this.f302023e != null) {
                try {
                    oidb_0x6c2$RspBody oidb_0x6c2_rspbody = new oidb_0x6c2$RspBody();
                    oidb_0x6c2_rspbody.mergeFrom(bArr);
                    int i16 = oidb_0x6c2_rspbody.uint32_result.get();
                    if (i16 == 0 && bundle != null) {
                        int i17 = bundle.getInt("subCmd");
                        if (i17 == 0 && oidb_0x6c2_rspbody.msg_gift_bag_info.has()) {
                            oidb_0x6c2$GiftBagInfo oidb_0x6c2_giftbaginfo = oidb_0x6c2_rspbody.msg_gift_bag_info.get();
                            if (oidb_0x6c2_rspbody.msg_winner.has()) {
                                oidb_0x6c2_player = oidb_0x6c2_rspbody.msg_winner.get();
                            } else {
                                oidb_0x6c2_player = null;
                            }
                            TroopGiftBagInfo troopGiftBagInfo = new TroopGiftBagInfo(oidb_0x6c2_giftbaginfo, oidb_0x6c2_player);
                            if (oidb_0x6c2_player != null) {
                                al.this.f302016f.put(this.f302024f + "_" + this.f302025h, troopGiftBagInfo);
                                al.this.l(troopGiftBagInfo);
                            }
                            this.f302023e.d(troopGiftBagInfo);
                            return;
                        }
                        if (i17 == 1 && oidb_0x6c2_rspbody.int32_player.has()) {
                            this.f302023e.g(oidb_0x6c2_rspbody.int32_player.get());
                            return;
                        }
                        this.f302023e.a(-1, "Invalid RspData. subCmd:" + i17);
                        return;
                    }
                    this.f302023e.a(i16, oidb_0x6c2_rspbody.bytes_errmsg.get().toStringUtf8());
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6c2. InvalidProtocolBufferMicroException:" + e16);
                    }
                    this.f302023e.a(-1, "InvalidProtocolBufferMicroException");
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6c2. onResult error=" + i3 + " data=" + bArr + " callback=" + this.f302023e);
            }
            ak akVar = this.f302023e;
            if (akVar != null) {
                akVar.a(i3, "sso request error or callback is null.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d extends ProtoUtils.a {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ak f302027e;

        d(ak akVar) {
            this.f302027e = akVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this, (Object) akVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            oidb_0x962$RspBody oidb_0x962_rspbody = new oidb_0x962$RspBody();
            if (bArr != null) {
                try {
                    oidb_0x962_rspbody.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x962. InvalidProtocolBufferMicroException:" + e16);
                    }
                }
            }
            ak akVar = this.f302027e;
            if (akVar != null) {
                akVar.i(i3, oidb_0x962_rspbody);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class e extends ProtoUtils.c {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ak f302029e;

        e(ak akVar) {
            this.f302029e = akVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this, (Object) akVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null) {
                oidb_0xa48$RspBody oidb_0xa48_rspbody = new oidb_0xa48$RspBody();
                try {
                    oidb_0xa48_rspbody.mergeFrom(bArr);
                    int size = oidb_0xa48_rspbody.msg_send_list_rsp.rpt_today_birth.size();
                    long[] jArr = new long[size];
                    for (int i16 = 0; i16 < size; i16++) {
                        jArr[i16] = oidb_0xa48_rspbody.msg_send_list_rsp.rpt_today_birth.get(i16).uint64_uin.get();
                    }
                    int size2 = oidb_0xa48_rspbody.msg_send_list_rsp.rpt_send_gift.size();
                    long[] jArr2 = new long[size2];
                    for (int i17 = 0; i17 < size2; i17++) {
                        jArr2[i17] = oidb_0xa48_rspbody.msg_send_list_rsp.rpt_send_gift.get(i17).uint64_uin.get();
                    }
                    int size3 = oidb_0xa48_rspbody.msg_send_list_rsp.rpt_recv_gift.size();
                    long[] jArr3 = new long[size3];
                    for (int i18 = 0; i18 < size3; i18++) {
                        jArr3[i18] = oidb_0xa48_rspbody.msg_send_list_rsp.rpt_recv_gift.get(i18).uint64_uin.get();
                    }
                    this.f302029e.e(jArr, jArr2, jArr3);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "requestGiftMemberList. error=" + QLog.getStackTraceString(e16));
                    }
                    this.f302029e.a(i3, "InvalidProtocolBufferMicroException");
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "requestGiftMemberList. onResult error=" + i3 + " data=" + bArr);
            }
            this.f302029e.a(i3, "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f302031a;

        /* renamed from: b, reason: collision with root package name */
        public int f302032b;

        /* renamed from: c, reason: collision with root package name */
        public int f302033c;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f302034a;

        /* renamed from: b, reason: collision with root package name */
        public String f302035b;

        /* renamed from: c, reason: collision with root package name */
        public String f302036c;

        public g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public al(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f302014d = null;
        this.f302016f = new ConcurrentHashMap<>();
        this.f302014d = appInterface;
        if (appInterface != null) {
            this.f302015e = appInterface.getEntityManagerFactory().createEntityManager();
        }
    }

    private int d(String str, int i3, int i16) {
        switch (i3) {
            case 4:
                return -1;
            case 5:
                return 2;
            case 6:
                return 504;
            case 7:
            case 9:
            case 10:
            default:
                return i16;
            case 8:
                return 508;
            case 11:
                return 1100;
            case 12:
                return 1300;
            case 13:
                return 1200;
        }
    }

    private void h(String str, int i3, int i16, String str2, String str3, long j3, ak akVar) {
        int i17;
        String str4;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && akVar != null) {
            oidb_0x6b5$ReqBody oidb_0x6b5_reqbody = new oidb_0x6b5$ReqBody();
            try {
                int i18 = 1;
                oidb_0x6b5_reqbody.uint64_group_id.set(Long.valueOf(str2).longValue(), true);
                PBUInt32Field pBUInt32Field = oidb_0x6b5_reqbody.uint32_portal;
                if (this.f302014d instanceof QQAppInterface) {
                    i17 = 7;
                } else {
                    i17 = 10;
                }
                pBUInt32Field.set(d(str2, i16, i17));
                oidb_0x6b5_reqbody.uint32_business_id.set(i16, true);
                oidb_0x6b5_reqbody.bytes_gift_bagid.set(ByteStringMicro.copyFrom(str3.getBytes()));
                oidb_0x6b5_reqbody.uint32_channel.set(1, true);
                oidb_0x6b5_reqbody.setHasFlag(true);
                TicketManager ticketManager = (TicketManager) this.f302014d.getManager(2);
                if (ticketManager != null) {
                    str4 = VasSkey.getSkey(ticketManager, this.f302014d.getCurrentAccountUin());
                } else {
                    str4 = "";
                }
                oidb_0x6b5$LoginSig oidb_0x6b5_loginsig = new oidb_0x6b5$LoginSig();
                oidb_0x6b5_loginsig.uint32_type.set(1);
                oidb_0x6b5_loginsig.uint32_appid.set(0);
                if (!TextUtils.isEmpty(str4)) {
                    oidb_0x6b5_loginsig.bytes_sig.set(ByteStringMicro.copyFromUtf8(str4));
                }
                oidb_0x6b5_reqbody.msg_login_sig.set(oidb_0x6b5_loginsig);
                Bundle bundle = new Bundle();
                bundle.putInt("subCmd", 0);
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6b5. serviceType=0");
                }
                if (i16 < 4) {
                    i18 = 0;
                }
                ProtoUtils.i(this.f302014d, new b(akVar, str2, str3), oidb_0x6b5_reqbody.toByteArray(), str + "_" + i18, i3, i18, bundle, j3);
                return;
            } catch (NumberFormatException unused) {
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6b5. NumberFormatException troopUin=" + str2);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6b5. troopUin=" + str2 + " giftBagID=" + str3 + " callback=" + akVar);
        }
    }

    private void i(String str, String str2, int i3, int i16, int i17, long j3, ak akVar) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && akVar != null) {
            oidb_0x6c2$ReqBody oidb_0x6c2_reqbody = new oidb_0x6c2$ReqBody();
            try {
                oidb_0x6c2_reqbody.uint64_group_id.set(Long.valueOf(str).longValue(), true);
                oidb_0x6c2_reqbody.bytes_gift_bagid.set(ByteStringMicro.copyFrom(str2.getBytes()));
                oidb_0x6c2_reqbody.uint32_channel.set(1, true);
                oidb_0x6c2_reqbody.setHasFlag(true);
                TicketManager ticketManager = (TicketManager) this.f302014d.getManager(2);
                if (ticketManager != null) {
                    str3 = VasSkey.getSkey(ticketManager, this.f302014d.getCurrentAccountUin());
                } else {
                    str3 = "";
                }
                oidb_0x6c2$LoginSig oidb_0x6c2_loginsig = new oidb_0x6c2$LoginSig();
                oidb_0x6c2_loginsig.uint32_type.set(1);
                oidb_0x6c2_loginsig.uint32_appid.set(0);
                if (!TextUtils.isEmpty(str3)) {
                    oidb_0x6c2_loginsig.bytes_sig.set(ByteStringMicro.copyFromUtf8(str3));
                }
                oidb_0x6c2_reqbody.msg_login_sig.set(oidb_0x6c2_loginsig);
                if (i17 == 0) {
                    oidb_0x6c2_reqbody.int32_page_index.set(i3, true);
                    oidb_0x6c2_reqbody.int32_page_size.set(i16, true);
                }
                Bundle bundle = new Bundle();
                bundle.putInt("subCmd", i17);
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6c2. serviceType=" + i17);
                }
                ProtoUtils.i(this.f302014d, new c(akVar, str, str2), oidb_0x6c2_reqbody.toByteArray(), "OidbSvc.0x6c2_" + i17, 1730, i17, bundle, j3);
                return;
            } catch (NumberFormatException unused) {
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6c2. NumberFormatException troopUin=" + str);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6c2. troopUin=" + str + " giftBagID=" + str2 + " callback=" + akVar);
        }
    }

    private void j(String str, int i3, int i16, String str2, int i17, int i18, oidb_0x6c3$GetStockReq oidb_0x6c3_getstockreq, oidb_0x6c3$GetExtraDataReq oidb_0x6c3_getextradatareq, long j3, ak akVar) {
        if (akVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6c3. troopUin is null. callback=" + akVar);
                return;
            }
            return;
        }
        oidb_0x6c3$ReqBody oidb_0x6c3_reqbody = new oidb_0x6c3$ReqBody();
        try {
            if (str2 != null) {
                oidb_0x6c3_reqbody.uint64_group.set(Long.valueOf(str2).longValue(), true);
            } else {
                oidb_0x6c3_reqbody.uint64_group.set(0L, true);
            }
            oidb_0x6c3_reqbody.uint32_portal.set(d(str2, i16, i17), true);
            if (oidb_0x6c3_getstockreq != null) {
                oidb_0x6c3_reqbody.msg_get_stock = oidb_0x6c3_getstockreq;
            } else if (oidb_0x6c3_getextradatareq != null) {
                oidb_0x6c3_reqbody.msg_extra_data = oidb_0x6c3_getextradatareq;
            }
            if (i18 == -1) {
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6c3. serviceType=" + i18);
                    return;
                }
                return;
            }
            String I = com.tencent.gamecenter.common.util.a.I();
            if (TextUtils.isEmpty(I)) {
                I = "0.0.0.0";
            }
            StringBuilder sb5 = new StringBuilder();
            String str3 = "";
            sb5.append("");
            sb5.append(AppSetting.d());
            String sb6 = sb5.toString();
            int f16 = AppSetting.f();
            oidb_0x6c3_reqbody.bytes_user_ip.set(ByteStringMicro.copyFrom(I.getBytes()), true);
            oidb_0x6c3_reqbody.bytes_version.set(ByteStringMicro.copyFrom(sb6.getBytes()), true);
            oidb_0x6c3_reqbody.uint32_client.set(1, true);
            oidb_0x6c3_reqbody.uint32_instance_id.set(f16, true);
            oidb_0x6c3_reqbody.uint32_business_id.set(i16, true);
            oidb_0x6c3_reqbody.setHasFlag(true);
            oidb_0x6c3$ExtParam oidb_0x6c3_extparam = new oidb_0x6c3$ExtParam();
            TicketManager ticketManager = (TicketManager) this.f302014d.getManager(2);
            if (ticketManager != null) {
                str3 = VasSkey.getSkey(ticketManager, this.f302014d.getCurrentAccountUin());
            }
            oidb_0x6c3$LoginSig oidb_0x6c3_loginsig = new oidb_0x6c3$LoginSig();
            oidb_0x6c3_loginsig.uint32_type.set(1);
            oidb_0x6c3_loginsig.uint32_appid.set(0);
            if (!TextUtils.isEmpty(str3)) {
                oidb_0x6c3_loginsig.bytes_sig.set(ByteStringMicro.copyFromUtf8(str3));
            }
            oidb_0x6c3_extparam.msg_login_sig.set(oidb_0x6c3_loginsig);
            oidb_0x6c3_reqbody.msg_ext_param.set(oidb_0x6c3_extparam);
            Bundle bundle = new Bundle();
            bundle.putInt("subCmd", i18);
            bundle.putString("troopUin", str2);
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6c3. serviceType=" + i18);
            }
            ProtoUtils.i(this.f302014d, new a(akVar), oidb_0x6c3_reqbody.toByteArray(), str + "_" + i18, i3, i18, bundle, j3);
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x6c3. NumberFormatException troopUin=" + str2);
            }
        }
    }

    private void k(String str, String str2, int i3, int i16, int i17, ak akVar) {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x962. interactId: " + str2 + ", cmd: " + i17);
        }
        try {
            long parseLong = Long.parseLong(str);
            oidb_0x962$ClientInfo oidb_0x962_clientinfo = new oidb_0x962$ClientInfo();
            oidb_0x962_clientinfo.uint32_client_type.set(1, true);
            oidb_0x962_clientinfo.bytes_version.set(ByteStringMicro.copyFrom(AppSetting.d().getBytes()), true);
            oidb_0x962$ReqBody oidb_0x962_reqbody = new oidb_0x962$ReqBody();
            oidb_0x962_reqbody.uint64_group_code.set(parseLong, true);
            oidb_0x962_reqbody.bytes_id.set(ByteStringMicro.copyFrom(str2.getBytes()), true);
            oidb_0x962_reqbody.uint32_times.set(i3, true);
            oidb_0x962_reqbody.msg_client_info.set(oidb_0x962_clientinfo, true);
            oidb_0x962_reqbody.uint32_product_id.set(i16, true);
            oidb_0x962_reqbody.uint32_cmd.set(i17, true);
            Bundle bundle = new Bundle();
            bundle.putInt("subCmd", i17);
            ProtoUtils.i(this.f302014d, new d(akVar), oidb_0x962_reqbody.toByteArray(), "OidbSvc.0x962_" + i17, 2402, 1, bundle, 500L);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, "send_oidb_0x962. troopUin is wrong" + str);
            }
        }
    }

    public void a(String str, String str2, int i3, ak akVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, str2, Integer.valueOf(i3), akVar);
            return;
        }
        VasCommonReporter.getHistoryFeature("TroopGift").setValue2("checkInteract").report();
        if (QLog.isColorLevel()) {
            QLog.d(".troop.send_gift .troop.send_gift", 2, "chechInteract. troopUin:" + str + " giftID:" + str2);
        }
        k(str, str2, 0, i3, 1, akVar);
    }

    public void b(String str, int i3, int i16, String str2, int i17, int i18, boolean z16, boolean z17, ak akVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Boolean.valueOf(z17), akVar);
            return;
        }
        VasCommonReporter.getHistoryFeature("TroopGift").setValue2("fetchGiftStock").report();
        if (QLog.isColorLevel()) {
            QLog.e(".troop.send_gift .troop.send_gift", 2, "fetchGiftStock. troopUin:" + str2 + " entranceID:" + i17);
        }
        oidb_0x6c3$GetStockReq oidb_0x6c3_getstockreq = new oidb_0x6c3$GetStockReq();
        oidb_0x6c3_getstockreq.setHasFlag(true);
        oidb_0x6c3_getstockreq.bool_not_need_gift_stock.set(z16, true);
        oidb_0x6c3_getstockreq.uint32_imgshow_config.set(z17 ? 1 : 0, true);
        j(str, i3, i16, str2, i17, i18, oidb_0x6c3_getstockreq, null, 0L, akVar);
    }

    public void c(String str, String str2, int i3, int i16, long j3, ak akVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), akVar);
            return;
        }
        VasCommonReporter.getHistoryFeature("TroopGift").setValue2("fetchGrabBagInfo").report();
        if (QLog.isColorLevel()) {
            QLog.e(".troop.send_gift .troop.send_gift", 2, "fetchGrabBagInfo. troopUin:" + str + " bagID:" + str2 + " pageIndex" + i3 + " pageSize:" + i16);
        }
        i(str, str2, i3, i16, 0, j3, akVar);
    }

    public TroopGiftBagInfo e(String str, String str2, ak akVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TroopGiftBagInfo) iPatchRedirector.redirect((short) 7, this, str, str2, akVar);
        }
        VasCommonReporter.getHistoryFeature("TroopGift").setValue2("getGrabBagInfo").report();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + "_" + str2;
            if (this.f302016f.get(str3) != null) {
                return this.f302016f.get(str3);
            }
            TroopGiftBagInfo troopGiftBagInfo = (TroopGiftBagInfo) DBMethodProxy.find(this.f302015e, (Class<? extends Entity>) TroopGiftBagInfo.class, str2);
            if (troopGiftBagInfo != null) {
                this.f302016f.put(str3, troopGiftBagInfo);
                return troopGiftBagInfo;
            }
            c(str, str2, 0, 0, 1000L, akVar);
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.e(".troop.send_gift .troop.send_gift", 2, "getGrabBagInfo. troopUin:" + str + " bagID:" + str2);
        }
        return null;
    }

    public void f(String str, int i3, int i16, String str2, String str3, long j3, ak akVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, str3, Long.valueOf(j3), akVar);
            return;
        }
        VasCommonReporter.getHistoryFeature("TroopGift").setValue2("grabGift").report();
        if (QLog.isColorLevel()) {
            QLog.e(".troop.send_gift .troop.send_gift", 2, "grabGift. troopUin:" + str2 + " bagID:" + str3);
        }
        h(str, i3, i16, str2, str3, j3, akVar);
    }

    public void g(String str, ak akVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) akVar);
            return;
        }
        VasCommonReporter.getHistoryFeature("TroopGift").setValue2("requestGiftMemberList").report();
        try {
            long parseLong = Long.parseLong(str);
            oidb_0xa48$ReqBody oidb_0xa48_reqbody = new oidb_0xa48$ReqBody();
            oidb_0xa48_reqbody.uint64_groupcode.set(parseLong, true);
            ProtoUtils.c((QQAppInterface) this.f302014d, new e(akVar), oidb_0xa48_reqbody.toByteArray(), "OidbSvc.0xa48_1", 2632, 1, new Bundle(), 6000L);
        } catch (Exception unused) {
            akVar.a(-1, "troop uin error");
        }
    }

    public boolean l(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) entity)).booleanValue();
        }
        if (this.f302015e == null || entity == null) {
            return false;
        }
        if (entity.getStatus() == 1000) {
            this.f302015e.persistOrReplace(entity);
            if (entity.getStatus() != 1001) {
                return false;
            }
            return true;
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return false;
        }
        return this.f302015e.update(entity);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (this.f302014d != null && QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "clear History. uin:" + this.f302014d.getAccount() + " app=" + String.valueOf(this.f302014d));
        }
        this.f302015e.close();
        this.f302015e = null;
    }
}
