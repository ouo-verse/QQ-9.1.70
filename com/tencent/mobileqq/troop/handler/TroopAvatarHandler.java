package com.tencent.mobileqq.troop.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$GroupHeadPortrait;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$GroupHeadPortraitInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$RspGroupInfo;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8$DelPicReq;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8$GroupPicListInfo;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8$ModifyOrderReq;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8$ReqBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8$RspBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8$SetDefaultReq;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAvatarHandler extends TroopBaseHandler implements com.tencent.mobileqq.troop.api.handler.b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private byte[] f296227a;

        /* renamed from: b, reason: collision with root package name */
        private int f296228b;

        /* renamed from: c, reason: collision with root package name */
        private oidb_sso$OIDBSSOPkg f296229c;

        public a(byte[] bArr, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopAvatarHandler.this, bArr, Integer.valueOf(i3));
            } else {
                this.f296227a = bArr;
                this.f296228b = i3;
            }
        }

        public oidb_sso$OIDBSSOPkg a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (oidb_sso$OIDBSSOPkg) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f296229c;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f296228b;
        }

        public a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            this.f296229c = oidb_sso_oidbssopkg;
            try {
                this.f296229c = oidb_sso_oidbssopkg.mergeFrom(this.f296227a);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TROOP_DISBAND, 2, "handle_oidb_0x88d_7|oidb_sso parseFrom byte " + e16.toString());
                }
                e16.printStackTrace();
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = this.f296229c;
            if (oidb_sso_oidbssopkg2 != null) {
                this.f296228b = oidb_sso_oidbssopkg2.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAvatarHandler", 2, "oidb_sso.OIDBSSOPkg(oidb_0x88d_7): {\n" + OidbWrapper.proto2String(this.f296229c) + "}");
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("handle_oidb_0x88d_7|oidb_sso.OIDBSSOPkg.result ");
                    sb5.append(this.f296228b);
                    QLog.d(LogTag.TROOP_DISBAND, 2, sb5.toString());
                }
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f296231a;

        /* renamed from: b, reason: collision with root package name */
        private long f296232b;

        /* renamed from: c, reason: collision with root package name */
        private int f296233c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f296234d;

        /* renamed from: e, reason: collision with root package name */
        private oidb_0x88d$GroupInfo f296235e;

        public b(String str, long j3, int i3, byte... bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopAvatarHandler.this, str, Long.valueOf(j3), Integer.valueOf(i3), bArr);
                return;
            }
            this.f296231a = str;
            this.f296232b = j3;
            this.f296233c = i3;
            this.f296234d = bArr;
        }

        public oidb_0x88d$GroupInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (oidb_0x88d$GroupInfo) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f296235e;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f296233c;
        }

        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f296231a;
        }

        public b d() throws InvalidProtocolBufferMicroException {
            int size;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (b) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            oidb_0x88d$RspBody oidb_0x88d_rspbody = new oidb_0x88d$RspBody();
            oidb_0x88d_rspbody.mergeFrom(this.f296234d);
            if (this.f296233c != 0 && oidb_0x88d_rspbody.str_errorinfo.has()) {
                this.f296231a = String.valueOf(oidb_0x88d_rspbody.str_errorinfo.get().toByteArray());
            }
            this.f296235e = null;
            List<oidb_0x88d$RspGroupInfo> list = oidb_0x88d_rspbody.stzrspgroupinfo.get();
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            for (int i3 = 0; this.f296235e == null && i3 < size; i3++) {
                oidb_0x88d$RspGroupInfo oidb_0x88d_rspgroupinfo = list.get(i3);
                if (oidb_0x88d_rspgroupinfo != null && oidb_0x88d_rspgroupinfo.uint64_group_code.get() == this.f296232b) {
                    int i16 = oidb_0x88d_rspgroupinfo.uint32_result.get();
                    this.f296233c = i16;
                    if (i16 == 0 && oidb_0x88d_rspgroupinfo.stgroupinfo.has()) {
                        this.f296235e = oidb_0x88d_rspgroupinfo.stgroupinfo.get();
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopAvatarHandler", 2, "oidb_0x88d_7.RspBody: {\n" + OidbWrapper.proto2String(oidb_0x88d_rspbody) + "}");
            }
            return this;
        }
    }

    public TroopAvatarHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private static String getClipStr(int i3, int i16, int i17, int i18) {
        return "" + i3 + "_" + i16 + "_" + i17 + "_" + i18;
    }

    private static int getPicsFrom88d(oidb_0x88d$GroupHeadPortrait oidb_0x88d_groupheadportrait, List<TroopClipPic> list) {
        int i3;
        int i16;
        int i17;
        int i18 = oidb_0x88d_groupheadportrait.uint32_default_id.get();
        Iterator<oidb_0x88d$GroupHeadPortraitInfo> it = oidb_0x88d_groupheadportrait.rpt_msg_info.get().iterator();
        while (true) {
            int i19 = 0;
            if (!it.hasNext()) {
                break;
            }
            oidb_0x88d$GroupHeadPortraitInfo next = it.next();
            TroopClipPic troopClipPic = new TroopClipPic();
            troopClipPic.f203184id = String.valueOf(next.rpt_uint32_pic_id.get());
            if (next.uint32_left_x.has()) {
                i3 = next.uint32_left_x.get();
            } else {
                i3 = 0;
            }
            if (next.uint32_left_y.has()) {
                i16 = next.uint32_left_y.get();
            } else {
                i16 = 0;
            }
            if (next.uint32_right_x.has()) {
                i17 = next.uint32_right_x.get();
            } else {
                i17 = 0;
            }
            if (next.uint32_right_y.has()) {
                i19 = next.uint32_right_y.get();
            }
            if (i3 >= 0 && i16 >= 0 && i17 >= 0 && i19 >= 0) {
                troopClipPic.clipInfo = getClipStr(i3, i16, i17, i19);
            }
            if (i18 == next.rpt_uint32_pic_id.get()) {
                troopClipPic.type = 1;
            }
            list.add(troopClipPic);
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopAvatarHandler", 2, String.format("getPicsFrom88d avatarId=%d %s", Integer.valueOf(i18), Arrays.toString(list.toArray())));
        }
        return i18;
    }

    private static int getPicsFrom8b8(oidb_0x8b8$RspBody oidb_0x8b8_rspbody, List<TroopClipPic> list) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = oidb_0x8b8_rspbody.uint32_default_id.get();
        if (oidb_0x8b8_rspbody.rpt_msg_pic_list_info.has() && oidb_0x8b8_rspbody.rpt_msg_pic_list_info.get().size() > 0) {
            for (oidb_0x8b8$GroupPicListInfo oidb_0x8b8_grouppiclistinfo : oidb_0x8b8_rspbody.rpt_msg_pic_list_info.get()) {
                if (oidb_0x8b8_grouppiclistinfo.uint32_pic_id.get() > 0) {
                    TroopClipPic troopClipPic = new TroopClipPic();
                    troopClipPic.f203184id = String.valueOf(oidb_0x8b8_grouppiclistinfo.uint32_pic_id.get());
                    if (oidb_0x8b8_grouppiclistinfo.uint32_left_x.has()) {
                        i3 = oidb_0x8b8_grouppiclistinfo.uint32_left_x.get();
                    } else {
                        i3 = 0;
                    }
                    if (oidb_0x8b8_grouppiclistinfo.uint32_left_y.has()) {
                        i16 = oidb_0x8b8_grouppiclistinfo.uint32_left_y.get();
                    } else {
                        i16 = 0;
                    }
                    if (oidb_0x8b8_grouppiclistinfo.uint32_right_x.has()) {
                        i17 = oidb_0x8b8_grouppiclistinfo.uint32_right_x.get();
                    } else {
                        i17 = 0;
                    }
                    if (oidb_0x8b8_grouppiclistinfo.uint32_right_y.has()) {
                        i18 = oidb_0x8b8_grouppiclistinfo.uint32_right_y.get();
                    } else {
                        i18 = 0;
                    }
                    if (i3 >= 0 && i16 >= 0 && i17 >= 0 && i18 >= 0) {
                        troopClipPic.clipInfo = getClipStr(i3, i16, i17, i18);
                    }
                    if (i19 == oidb_0x8b8_grouppiclistinfo.uint32_pic_id.get()) {
                        troopClipPic.type = 1;
                    }
                    list.add(troopClipPic);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopAvatarHandler", 2, String.format("getPicsFrom8b8 avatarId=%d %s", Integer.valueOf(i19), Arrays.toString(list.toArray())));
        }
        return i19;
    }

    private static Set<String> setVerifyingAvatarPicId(oidb_0x88d$GroupHeadPortrait oidb_0x88d_groupheadportrait) {
        int i3 = oidb_0x88d_groupheadportrait.uint32_verifying_pic_cnt.get();
        int size = oidb_0x88d_groupheadportrait.rpt_msg_verifyingpic_info.size();
        if (i3 != size && QLog.isColorLevel()) {
            QLog.d(TroopInfo.TAG, 2, String.format("wrong data from server! uint32_verifying_pic_cnt = %d not equals rpt_msg_verifyingpic_info's size = %d", Integer.valueOf(i3), Integer.valueOf(size)));
        }
        HashSet hashSet = new HashSet();
        Iterator<oidb_0x88d$GroupHeadPortraitInfo> it = oidb_0x88d_groupheadportrait.rpt_msg_verifyingpic_info.get().iterator();
        while (it.hasNext()) {
            hashSet.add(String.valueOf(it.next().rpt_uint32_pic_id.get()));
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x010b A[Catch: Exception -> 0x01ca, TryCatch #0 {Exception -> 0x01ca, blocks: (B:25:0x00ce, B:27:0x00df, B:30:0x00eb, B:32:0x010b, B:33:0x0122, B:35:0x014b, B:38:0x0189, B:39:0x0181, B:40:0x01a6, B:42:0x01ac), top: B:24:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014b A[Catch: Exception -> 0x01ca, TryCatch #0 {Exception -> 0x01ca, blocks: (B:25:0x00ce, B:27:0x00df, B:30:0x00eb, B:32:0x010b, B:33:0x0122, B:35:0x014b, B:38:0x0189, B:39:0x0181, B:40:0x01a6, B:42:0x01ac), top: B:24:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ac A[Catch: Exception -> 0x01ca, TRY_LEAVE, TryCatch #0 {Exception -> 0x01ca, blocks: (B:25:0x00ce, B:27:0x00df, B:30:0x00eb, B:32:0x010b, B:33:0x0122, B:35:0x014b, B:38:0x0189, B:39:0x0181, B:40:0x01a6, B:42:0x01ac), top: B:24:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        TroopInfo findTroopInfo;
        Integer valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        long j3 = toServiceMsg.extraData.getLong("troop_uin");
        int i16 = toServiceMsg.extraData.getInt("subCmd");
        if (fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TROOP_DISBAND, 2, "handle_oidb_0x8b8_1|oidb_sso parseFrom byte " + e16.toString());
                }
            }
            int i17 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TROOP_DISBAND, 2, "handle_oidb_0x8b8_1|oidb_sso.OIDBSSOPkg.result " + i17);
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopAvatarHandler", 2, "oidb_sso.OIDBSSOPkg(0x8b8):{" + OidbWrapper.proto2String(oidb_sso_oidbssopkg) + "}");
            }
            if (oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                try {
                    oidb_0x8b8$RspBody oidb_0x8b8_rspbody = new oidb_0x8b8$RspBody();
                    oidb_0x8b8_rspbody.mergeFrom(byteArray);
                    if (oidb_0x8b8_rspbody.uint32_result.has()) {
                        i3 = oidb_0x8b8_rspbody.uint32_result.get();
                        if (i3 == 0) {
                            z16 = true;
                            findTroopInfo = ((ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(j3));
                            ArrayList arrayList = new ArrayList();
                            int picsFrom8b8 = getPicsFrom8b8(oidb_0x8b8_rspbody, arrayList);
                            if (findTroopInfo != null) {
                                findTroopInfo.extDBInfo.avatarId = picsFrom8b8;
                                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).updateTroopInfoAvatarId(findTroopInfo.troopuin, picsFrom8b8, "TroopAvatarHandler");
                                findTroopInfo.updateTroopPicList(arrayList, "TroopAvatarHandler-handleCmdTroopAvatarWall");
                            }
                            notifyUI(com.tencent.mobileqq.troop.api.observer.a.TYPE_CMD_TROOP_AVATAR, z16, new Object[]{String.valueOf(j3), Integer.valueOf(i3), null, Integer.valueOf(i16), arrayList});
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder(150);
                                sb5.append("handle_oidb_0x8b8_1");
                                sb5.append("|isSuccess = ");
                                sb5.append(z16);
                                sb5.append("|resultcode = ");
                                sb5.append(fromServiceMsg.getResultCode());
                                sb5.append("|troopuin = ");
                                sb5.append(j3);
                                sb5.append("|avatarId = ");
                                if (findTroopInfo == null) {
                                    valueOf = null;
                                } else {
                                    valueOf = Integer.valueOf(findTroopInfo.extDBInfo.avatarId);
                                }
                                sb5.append(valueOf);
                                sb5.append("|result = ");
                                sb5.append(i3);
                                sb5.append("|strErrorMsg = ");
                                sb5.append((String) null);
                                QLog.i(LogTag.TROOP_DISBAND, 2, sb5.toString());
                            }
                            if (!QLog.isColorLevel()) {
                                QLog.d("TroopAvatarHandler", 2, "oidb_0x8b8.RspBody:{" + OidbWrapper.proto2String(oidb_0x8b8_rspbody) + "}");
                                return;
                            }
                            return;
                        }
                    } else {
                        i3 = -1;
                    }
                    z16 = false;
                    findTroopInfo = ((ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(j3));
                    ArrayList arrayList2 = new ArrayList();
                    int picsFrom8b82 = getPicsFrom8b8(oidb_0x8b8_rspbody, arrayList2);
                    if (findTroopInfo != null) {
                    }
                    notifyUI(com.tencent.mobileqq.troop.api.observer.a.TYPE_CMD_TROOP_AVATAR, z16, new Object[]{String.valueOf(j3), Integer.valueOf(i3), null, Integer.valueOf(i16), arrayList2});
                    if (QLog.isColorLevel()) {
                    }
                    if (!QLog.isColorLevel()) {
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.TROOP_DISBAND, 2, e17.toString());
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        TroopInfo troopInfo;
        boolean z16;
        int i16;
        int i17;
        String str;
        int i18;
        Exception exc;
        String str2;
        int b16;
        oidb_0x88d$GroupInfo a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        long j3 = toServiceMsg.extraData.getLong("troop_uin");
        toServiceMsg.extraData.getInt("nFlag");
        ArrayList arrayList = new ArrayList();
        int i19 = -1;
        if (fromServiceMsg.getResultCode() == 1000) {
            a c16 = new a((byte[]) obj, -1).c();
            int b17 = c16.b();
            oidb_sso$OIDBSSOPkg a17 = c16.a();
            if (a17 != null && a17.bytes_bodybuffer.has() && a17.bytes_bodybuffer.get() != null) {
                try {
                    i3 = 2;
                    i18 = -1;
                    try {
                        b d16 = new b(null, j3, b17, a17.bytes_bodybuffer.get().toByteArray()).d();
                        str2 = d16.c();
                        try {
                            b16 = d16.b();
                            try {
                                a16 = d16.a();
                            } catch (Exception e16) {
                                exc = e16;
                                b17 = b16;
                                troopInfo = null;
                                z16 = false;
                                i19 = -1;
                                if (QLog.isColorLevel()) {
                                }
                                str = str2;
                                i16 = b17;
                                i17 = i18;
                                if (troopInfo == null) {
                                }
                                int i26 = com.tencent.mobileqq.troop.api.observer.a.TYPE_GET_TROOP_AVATAR;
                                Object[] objArr = new Object[5];
                                objArr[0] = String.valueOf(j3);
                                objArr[1] = Integer.valueOf(i16);
                                objArr[i3] = str;
                                objArr[3] = Integer.valueOf(i19);
                                objArr[4] = arrayList;
                                notifyUI(i26, z16, objArr);
                                if (QLog.isColorLevel()) {
                                }
                            }
                        } catch (Exception e17) {
                            exc = e17;
                        }
                    } catch (Exception e18) {
                        exc = e18;
                        troopInfo = null;
                        z16 = false;
                        i19 = -1;
                        str2 = null;
                        if (QLog.isColorLevel()) {
                        }
                        str = str2;
                        i16 = b17;
                        i17 = i18;
                        if (troopInfo == null) {
                        }
                        int i262 = com.tencent.mobileqq.troop.api.observer.a.TYPE_GET_TROOP_AVATAR;
                        Object[] objArr2 = new Object[5];
                        objArr2[0] = String.valueOf(j3);
                        objArr2[1] = Integer.valueOf(i16);
                        objArr2[i3] = str;
                        objArr2[3] = Integer.valueOf(i19);
                        objArr2[4] = arrayList;
                        notifyUI(i262, z16, objArr2);
                        if (QLog.isColorLevel()) {
                        }
                    }
                } catch (Exception e19) {
                    i3 = 2;
                    i18 = -1;
                    exc = e19;
                    troopInfo = null;
                    z16 = false;
                }
                if (a16 != null) {
                    try {
                        troopInfo = ((ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(j3));
                    } catch (Exception e26) {
                        exc = e26;
                        b17 = b16;
                        troopInfo = null;
                    }
                    try {
                        if (a16.msg_head_portrait.has() && a16.uint32_head_portrait_seq.has()) {
                            oidb_0x88d$GroupHeadPortrait oidb_0x88d_groupheadportrait = a16.msg_head_portrait;
                            int i27 = a16.uint32_head_portrait_seq.get();
                            try {
                                i17 = getPicsFrom88d(oidb_0x88d_groupheadportrait, arrayList);
                            } catch (Exception e27) {
                                exc = e27;
                            }
                            try {
                                Set<String> verifyingAvatarPicId = setVerifyingAvatarPicId(oidb_0x88d_groupheadportrait);
                                if (troopInfo != null && troopInfo.isMember()) {
                                    troopInfo.updateTroopPicList(arrayList, "TroopAvatarHandler-handleGetTroopAvatarWall");
                                    troopInfo.mTroopVerifyingPics.clear();
                                    troopInfo.mTroopVerifyingPics.addAll(verifyingAvatarPicId);
                                    troopInfo.extDBInfo.avatarId = i17;
                                    ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).updateTroopInfoAvatarId(troopInfo.troopuin, i17, "TroopAvatarHandler");
                                }
                                i18 = i27;
                            } catch (Exception e28) {
                                exc = e28;
                                i18 = i17;
                                b17 = b16;
                                z16 = true;
                                i19 = i27;
                                if (QLog.isColorLevel()) {
                                }
                                str = str2;
                                i16 = b17;
                                i17 = i18;
                                if (troopInfo == null) {
                                }
                                int i2622 = com.tencent.mobileqq.troop.api.observer.a.TYPE_GET_TROOP_AVATAR;
                                Object[] objArr22 = new Object[5];
                                objArr22[0] = String.valueOf(j3);
                                objArr22[1] = Integer.valueOf(i16);
                                objArr22[i3] = str;
                                objArr22[3] = Integer.valueOf(i19);
                                objArr22[4] = arrayList;
                                notifyUI(i2622, z16, objArr22);
                                if (QLog.isColorLevel()) {
                                }
                            }
                        } else if (a16.uint32_head_portrait_seq.has()) {
                            i17 = -1;
                            i18 = a16.uint32_head_portrait_seq.get();
                        } else {
                            z16 = true;
                        }
                        z16 = true;
                        str = str2;
                        i16 = b16;
                        i19 = i18;
                    } catch (Exception e29) {
                        exc = e29;
                        b17 = b16;
                        z16 = true;
                        i19 = -1;
                        if (QLog.isColorLevel()) {
                            QLog.i(LogTag.TROOP_DISBAND, i3, exc.toString());
                        }
                        str = str2;
                        i16 = b17;
                        i17 = i18;
                        if (troopInfo == null) {
                        }
                        int i26222 = com.tencent.mobileqq.troop.api.observer.a.TYPE_GET_TROOP_AVATAR;
                        Object[] objArr222 = new Object[5];
                        objArr222[0] = String.valueOf(j3);
                        objArr222[1] = Integer.valueOf(i16);
                        objArr222[i3] = str;
                        objArr222[3] = Integer.valueOf(i19);
                        objArr222[4] = arrayList;
                        notifyUI(i26222, z16, objArr222);
                        if (QLog.isColorLevel()) {
                        }
                    }
                    if (troopInfo == null && troopInfo.isMember()) {
                        int i28 = com.tencent.mobileqq.troop.api.observer.a.TYPE_GET_TROOP_AVATAR;
                        Object[] objArr3 = new Object[5];
                        objArr3[0] = String.valueOf(j3);
                        objArr3[1] = Integer.valueOf(i16);
                        objArr3[i3] = str;
                        objArr3[3] = Integer.valueOf(i19);
                        objArr3[4] = null;
                        notifyUI(i28, z16, objArr3);
                    } else {
                        int i262222 = com.tencent.mobileqq.troop.api.observer.a.TYPE_GET_TROOP_AVATAR;
                        Object[] objArr2222 = new Object[5];
                        objArr2222[0] = String.valueOf(j3);
                        objArr2222[1] = Integer.valueOf(i16);
                        objArr2222[i3] = str;
                        objArr2222[3] = Integer.valueOf(i19);
                        objArr2222[4] = arrayList;
                        notifyUI(i262222, z16, objArr2222);
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder(150);
                        sb5.append("handle_oidb_0x88d_0");
                        sb5.append("|isSuccess = ");
                        sb5.append(z16);
                        sb5.append("|resultcode = ");
                        sb5.append(fromServiceMsg.getResultCode());
                        sb5.append("|troopuin = ");
                        sb5.append(j3);
                        sb5.append("|avatarId = ");
                        sb5.append(i17);
                        sb5.append("|seq = ");
                        sb5.append(i19);
                        sb5.append("|result = ");
                        sb5.append(i16);
                        sb5.append("|strErrorMsg = ");
                        sb5.append(str);
                        QLog.i(LogTag.TROOP_DISBAND, i3, sb5.toString());
                        return;
                    }
                    return;
                }
                troopInfo = null;
                z16 = false;
                i17 = -1;
                str = str2;
                i16 = b16;
                i19 = i18;
                if (troopInfo == null) {
                }
                int i2622222 = com.tencent.mobileqq.troop.api.observer.a.TYPE_GET_TROOP_AVATAR;
                Object[] objArr22222 = new Object[5];
                objArr22222[0] = String.valueOf(j3);
                objArr22222[1] = Integer.valueOf(i16);
                objArr22222[i3] = str;
                objArr22222[3] = Integer.valueOf(i19);
                objArr22222[4] = arrayList;
                notifyUI(i2622222, z16, objArr22222);
                if (QLog.isColorLevel()) {
                }
            } else {
                i3 = 2;
                troopInfo = null;
                z16 = false;
                i16 = b17;
                i17 = -1;
            }
        } else {
            i3 = 2;
            troopInfo = null;
            z16 = false;
            i16 = -1;
            i17 = -1;
        }
        i19 = i17;
        str = null;
        if (troopInfo == null) {
        }
        int i26222222 = com.tencent.mobileqq.troop.api.observer.a.TYPE_GET_TROOP_AVATAR;
        Object[] objArr222222 = new Object[5];
        objArr222222[0] = String.valueOf(j3);
        objArr222222[1] = Integer.valueOf(i16);
        objArr222222[i3] = str;
        objArr222222[3] = Integer.valueOf(i19);
        objArr222222[4] = arrayList;
        notifyUI(i26222222, z16, objArr222222);
        if (QLog.isColorLevel()) {
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.b
    public void I(String str, int i3, ArrayList<Integer> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), arrayList);
            return;
        }
        oidb_0x8b8$ReqBody oidb_0x8b8_reqbody = new oidb_0x8b8$ReqBody();
        if (arrayList != null && i3 <= 2) {
            try {
                oidb_0x8b8_reqbody.uint64_group_uin.set(Long.parseLong(str));
                oidb_0x8b8_reqbody.uint32_subcmd.set(i3 + 1);
                oidb_0x8b8_reqbody.uint32_client_ver.set(AppSetting.f());
                oidb_0x8b8_reqbody.uint32_sequence.set(23);
                if (i3 == 0) {
                    oidb_0x8b8$ModifyOrderReq oidb_0x8b8_modifyorderreq = new oidb_0x8b8$ModifyOrderReq();
                    oidb_0x8b8_modifyorderreq.rpt_uint32_pic_list.set(arrayList);
                    oidb_0x8b8_modifyorderreq.uint32_pic_cnt.set(arrayList.size());
                    oidb_0x8b8_reqbody.msg_modify_order.set(oidb_0x8b8_modifyorderreq);
                } else if (i3 == 1) {
                    oidb_0x8b8$SetDefaultReq oidb_0x8b8_setdefaultreq = new oidb_0x8b8$SetDefaultReq();
                    Iterator<Integer> it = arrayList.iterator();
                    while (it.hasNext()) {
                        oidb_0x8b8_setdefaultreq.uint32_default_id.set(it.next().intValue());
                    }
                    oidb_0x8b8_reqbody.msg_set_default.set(oidb_0x8b8_setdefaultreq);
                } else if (i3 == 2) {
                    oidb_0x8b8$DelPicReq oidb_0x8b8_delpicreq = new oidb_0x8b8$DelPicReq();
                    Iterator<Integer> it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        oidb_0x8b8_delpicreq.rpt_uint32_del_list.add(Integer.valueOf(it5.next().intValue()));
                    }
                    oidb_0x8b8_delpicreq.uint32_del_cnt.set(arrayList.size());
                    oidb_0x8b8_reqbody.msg_del_pic.set(oidb_0x8b8_delpicreq);
                }
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.uint32_command.set(2232);
                oidb_sso_oidbssopkg.uint32_service_type.set(1);
                oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x8b8_reqbody.toByteArray()));
                ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x8b8_1");
                createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
                createToServiceMsg.extraData.putInt("subCmd", i3);
                createToServiceMsg.extraData.putLong("troop_uin", Long.parseLong(str));
                createToServiceMsg.setTimeout(30000L);
                sendPbReq(createToServiceMsg);
            } catch (NumberFormatException unused) {
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x88d_7");
            this.allowCmdSet.add("OidbSvc.0x8b8_1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopAvatarHandler";
    }

    @Override // com.tencent.mobileqq.troop.api.handler.b
    public void o2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        oidb_0x88d$GroupInfo oidb_0x88d_groupinfo = new oidb_0x88d$GroupInfo();
        oidb_0x88d_groupinfo.uint32_head_portrait_seq.set(0);
        oidb_0x88d_groupinfo.msg_head_portrait.set(new oidb_0x88d$GroupHeadPortrait());
        oidb_0x88d$ReqGroupInfo oidb_0x88d_reqgroupinfo = new oidb_0x88d$ReqGroupInfo();
        try {
            oidb_0x88d_reqgroupinfo.uint64_group_code.set(Long.parseLong(str));
            oidb_0x88d_reqgroupinfo.stgroupinfo.set(oidb_0x88d_groupinfo);
            oidb_0x88d$ReqBody oidb_0x88d_reqbody = new oidb_0x88d$ReqBody();
            oidb_0x88d_reqbody.uint32_appid.set(this.appRuntime.getAppid());
            oidb_0x88d_reqbody.stzreqgroupinfo.add(oidb_0x88d_reqgroupinfo);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(2189);
            oidb_sso_oidbssopkg.uint32_service_type.set(7);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x88d_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x88d_7");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.extraData.putLong("troop_uin", Long.parseLong(str));
            createToServiceMsg.setTimeout(30000L);
            sendPbReq(createToServiceMsg);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.troop.api.observer.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAvatarHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAvatarHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0x88d_7".equals(fromServiceMsg.getServiceCmd())) {
                G2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvc.0x8b8_1".equals(fromServiceMsg.getServiceCmd())) {
                    F2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAvatarHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
