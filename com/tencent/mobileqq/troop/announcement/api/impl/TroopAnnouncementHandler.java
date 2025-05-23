package com.tencent.mobileqq.troop.announcement.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.mobileqq.troop.announcement.api.b;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.w;
import com.tencent.mobileqq.troop.api.handler.c;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.TroopExtDBInfoRepo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GroupFeedsRecord;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9$ReqBody;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9$RspBody;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9$SourceID;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAnnouncementHandler extends TroopBaseHandler implements com.tencent.mobileqq.troop.announcement.api.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Boolean> f293934e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends e {
        static IPatchRedirector $redirector_;
        final /* synthetic */ int C;
        final /* synthetic */ boolean D;
        final /* synthetic */ short E;
        final /* synthetic */ boolean F;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f293935d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f293936e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f293937f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f293938h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f293939i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f293940m;

        a(long j3, String str, int i3, long j16, long j17, String str2, int i16, boolean z16, short s16, boolean z17) {
            this.f293935d = j3;
            this.f293936e = str;
            this.f293937f = i3;
            this.f293938h = j16;
            this.f293939i = j17;
            this.f293940m = str2;
            this.C = i16;
            this.D = z16;
            this.E = s16;
            this.F = z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopAnnouncementHandler.this, Long.valueOf(j3), str, Integer.valueOf(i3), Long.valueOf(j16), Long.valueOf(j17), str2, Integer.valueOf(i16), Boolean.valueOf(z16), Short.valueOf(s16), Boolean.valueOf(z17));
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        public void onGetTroopAuth(boolean z16, long j3, String str, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), str, bArr);
                return;
            }
            if (this.f293935d == j3 && str.equals("SUBCMD_GET_TROOP_AUTH_FOR_ANNOUNCEMENT")) {
                if (z16 && bArr != null) {
                    short length = (short) bArr.length;
                    if ("OidbSvc.0x852_35".equals(this.f293936e)) {
                        TroopAnnouncementHandler.this.Q2(this.f293937f, this.f293938h, this.f293935d, length, bArr, this.f293939i, this.f293940m, this.C, this.D);
                    } else if ("OidbSvc.0x852_48".equals(this.f293936e)) {
                        TroopAnnouncementHandler.this.P2(this.f293937f, this.f293938h, this.f293935d, length, bArr, this.E, this.F);
                    }
                } else {
                    TroopAnnouncementHandler.f293934e.remove(this.f293940m);
                }
                ((BaseBusinessHandler) TroopAnnouncementHandler.this).appRuntime.removeObserver(this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63834);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f293934e = new ConcurrentHashMap<>();
        }
    }

    public TroopAnnouncementHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private static byte[] J2(long j3, short s16, byte[] bArr, String str) {
        int i3 = (int) j3;
        byte[] bArr2 = new byte[32];
        Arrays.fill(bArr2, (byte) 0);
        byte[] bytes = str.getBytes();
        for (int i16 = 0; i16 < 32 && i16 < bytes.length; i16++) {
            bArr2[i16] = bytes[i16];
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int currentTimeMillis2 = (int) (System.currentTimeMillis() / 1000);
        byte[] bArr3 = new byte[16];
        int i17 = 65 + s16;
        short s17 = (short) i17;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(i17);
            dataOutputStream.write(1);
            dataOutputStream.writeShort(s17);
            dataOutputStream.writeInt(i3);
            dataOutputStream.write(bArr2);
            dataOutputStream.writeInt(currentTimeMillis);
            dataOutputStream.writeInt(currentTimeMillis2);
            dataOutputStream.writeShort(s16);
            dataOutputStream.write(bArr);
            dataOutputStream.write(bArr3);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            dataOutputStream.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAnnouncementHandler", 2, e16.getMessage());
                return null;
            }
            return null;
        }
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String string = toServiceMsg.extraData.getString("feedsId");
        if (fromServiceMsg.getResultCode() != 1000) {
            f293934e.remove(string);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAnnouncementHandler", 2, "handleGetTroopNotification");
        }
        int i3 = toServiceMsg.extraData.getInt("appId");
        long j3 = toServiceMsg.extraData.getLong("troopUin");
        long j16 = toServiceMsg.extraData.getLong(IProfileProtocolConst.PARAM_TROOP_CODE);
        boolean z16 = toServiceMsg.extraData.getBoolean("isRemindNotify");
        byte[] bArr = (byte[]) obj;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        try {
            oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
            int i16 = oidb_sso_oidbssopkg.uint32_result.get();
            if (i16 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAnnouncementHandler", 2, "0x852_35 cResult=" + i16);
                }
                f293934e.remove(string);
                return;
            }
            try {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray()));
                dataInputStream.readInt();
                w.a().c(this.appRuntime, j3, j16, i3, V(dataInputStream, false), string, z16);
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAnnouncementHandler", 2, e17.getMessage());
                }
            }
            f293934e.remove(string);
            return;
        }
        f293934e.remove(string);
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.getResultCode() != 1000) {
            return;
        }
        int i3 = toServiceMsg.extraData.getInt("appId");
        long j3 = toServiceMsg.extraData.getLong("troopUin");
        long j16 = toServiceMsg.extraData.getLong(IProfileProtocolConst.PARAM_TROOP_CODE);
        String string = toServiceMsg.extraData.getString("feedsId");
        int i16 = toServiceMsg.extraData.getInt("feedType");
        boolean z16 = toServiceMsg.extraData.getBoolean("aioRequest", false);
        byte[] bArr = (byte[]) obj;
        if (QLog.isColorLevel()) {
            QLog.d("TroopAnnouncementHandler", 2, "handle get troop guide");
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        try {
            oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
            int i17 = oidb_sso_oidbssopkg.uint32_result.get();
            if (i17 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAnnouncementHandler", 2, "oidb0x852_48 cResult=" + i17 + ", troop = " + j16 + ", feedType = " + i16 + ", aioRequest = " + z16);
                    return;
                }
                return;
            }
            w.a().d(this.appRuntime, j3, j16, i3, string, i16, z16, new DataInputStream(new ByteArrayInputStream(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray())));
        }
    }

    private void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (toServiceMsg != null && fromServiceMsg != null) {
            String string = toServiceMsg.extraData.getString("from");
            oidb_0x8f9$RspBody oidb_0x8f9_rspbody = new oidb_0x8f9$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x8f9_rspbody);
            if ("getLatestTroopMemo".equals(string)) {
                oidb_0x8f9$GroupFeedsRecord oidb_0x8f9_groupfeedsrecord = null;
                if (parseOIDBPkg == 0 && (parseOIDBPkg = oidb_0x8f9_rspbody.msg_result_msg.uint32_result.get()) == 0) {
                    List<oidb_0x8f9$GroupFeedsRecord> list = oidb_0x8f9_rspbody.rpt_feeds_recored.get();
                    if (list != null && list.size() > 0) {
                        oidb_0x8f9_groupfeedsrecord = list.get(0);
                    }
                    z16 = true;
                } else {
                    z16 = false;
                }
                long j3 = toServiceMsg.extraData.getLong("group_code");
                int i3 = oidb_0x8f9_rspbody.msg_source_id.uint32_source_type.get();
                long j16 = oidb_0x8f9_rspbody.msg_source_id.uint64_source_code.get();
                if (z16 && ((i3 != 1 || j3 != j16) && QLog.isColorLevel())) {
                    QLog.i("TroopAnnouncementHandler", 2, String.format("0x8f9_14 [%s, %s, %s]", Integer.valueOf(i3), Long.valueOf(j16), Long.valueOf(j3)));
                }
                String str = "";
                ITroopInfoService iTroopInfoService = (ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
                String valueOf = String.valueOf(j3);
                TroopInfo troopInfo = iTroopInfoService.getTroopInfo(valueOf);
                if (z16 && troopInfo != null && !TextUtils.isEmpty(valueOf)) {
                    R2(oidb_0x8f9_groupfeedsrecord, troopInfo);
                    str = troopInfo.getLatestMemo();
                }
                notifyUI(b.f293931e, z16, new Object[]{valueOf, str});
                if (QLog.isColorLevel()) {
                    QLog.i("TroopAnnouncementHandler", 2, String.format("0x8f9_14 latest memo suc: %s, uin: %s, re: %s, data: %s", Boolean.valueOf(z16), valueOf, Integer.valueOf(parseOIDBPkg), oidb_0x8f9_groupfeedsrecord));
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopAnnouncementHandler", 2, "0x8f9_14 unknow from:  " + string);
                return;
            }
            return;
        }
        QLog.i("TroopAnnouncementHandler", 1, "0x8f9_6 req or resp is null.");
    }

    private void O2(int i3, long j3, long j16, long j17, String str, int i16, String str2, short s16, boolean z16, boolean z17, boolean z18) {
        c cVar = (c) this.appRuntime.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
        byte[] I0 = cVar.I0(j16);
        if (!z17 && I0 != null) {
            short length = (short) I0.length;
            if ("OidbSvc.0x852_35".equals(str2)) {
                f293934e.put(str, Boolean.TRUE);
                Q2(i3, j3, j16, length, I0, j17, str, i16, z18);
                return;
            } else {
                if ("OidbSvc.0x852_48".equals(str2)) {
                    P2(i3, j3, j16, length, I0, s16, z16);
                    return;
                }
                return;
            }
        }
        if ("OidbSvc.0x852_35".equals(str2)) {
            f293934e.put(str, Boolean.TRUE);
        }
        S2(i3, j3, j16, j17, str, i16, str2, s16, z16, z18);
        cVar.P0(j16, "SUBCMD_GET_TROOP_AUTH_FOR_ANNOUNCEMENT");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2(int i3, long j3, long j16, short s16, byte[] bArr, short s17, boolean z16) {
        long j17;
        if (QLog.isColorLevel()) {
            QLog.d("TroopAnnouncementHandler", 2, "send get troop guide");
        }
        int i16 = (int) j16;
        try {
            j17 = Long.valueOf(this.appRuntime.getCurrentAccountUin().trim()).longValue() & 4294967295L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAnnouncementHandler", 2, e16.getMessage());
            }
            j17 = 0;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int currentTimeMillis2 = (int) (System.currentTimeMillis() / 1000);
        byte[] bArr2 = new byte[16];
        int i17 = 47 + s16;
        short s18 = (short) i17;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(i17);
            dataOutputStream.write(1);
            dataOutputStream.writeShort(s18);
            dataOutputStream.writeInt(i16);
            dataOutputStream.writeInt((int) j17);
            dataOutputStream.writeShort(s17);
            dataOutputStream.writeInt(-1);
            dataOutputStream.writeInt(1);
            dataOutputStream.writeInt(currentTimeMillis);
            dataOutputStream.writeInt(currentTimeMillis2);
            dataOutputStream.writeShort(s16);
            dataOutputStream.write(bArr);
            dataOutputStream.write(bArr2);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            dataOutputStream.close();
            byteArrayOutputStream.close();
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x852_48");
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(2130);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            oidb_sso_oidbssopkg.uint32_service_type.set(48);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(byteArray));
            toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            toServiceMsg.extraData.putInt("appId", i3);
            toServiceMsg.extraData.putLong("troopUin", j3);
            toServiceMsg.extraData.putLong(IProfileProtocolConst.PARAM_TROOP_CODE, j16);
            toServiceMsg.extraData.putInt("feedType", s17);
            toServiceMsg.extraData.putBoolean("aioRequest", z16);
            toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
            toServiceMsg.extraData.putString("REQ_TAG", getTag());
            this.appRuntime.sendToService(toServiceMsg);
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAnnouncementHandler", 2, e17.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2(int i3, long j3, long j16, short s16, byte[] bArr, long j17, String str, int i16, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopAnnouncementHandler", 2, "send get notices");
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x852_35");
        byte[] J2 = J2(j16, s16, bArr, str);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2130);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(35);
        if (J2 != null) {
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(J2));
        }
        toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        toServiceMsg.extraData.putInt("appId", i3);
        toServiceMsg.extraData.putLong("troopUin", j3);
        toServiceMsg.extraData.putLong(IProfileProtocolConst.PARAM_TROOP_CODE, j16);
        toServiceMsg.extraData.putLong("userUin", j17);
        toServiceMsg.extraData.putString("feedsId", str);
        toServiceMsg.extraData.putInt("time", i16);
        toServiceMsg.extraData.putBoolean("isRemindNotify", z16);
        toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        toServiceMsg.extraData.putString("REQ_TAG", getTag());
        this.appRuntime.sendToService(toServiceMsg);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void R2(oidb_0x8f9$GroupFeedsRecord oidb_0x8f9_groupfeedsrecord, TroopInfo troopInfo) {
        ITroopAnnouncementHelperApi.a decodeToFeedItem;
        String str;
        if (troopInfo == null) {
            return;
        }
        String str2 = "";
        if (oidb_0x8f9_groupfeedsrecord != null) {
            try {
                decodeToFeedItem = ((ITroopAnnouncementHelperApi) QRoute.api(ITroopAnnouncementHelperApi.class)).decodeToFeedItem(String.valueOf(oidb_0x8f9_groupfeedsrecord.uint32_feeds_type.get()), oidb_0x8f9_groupfeedsrecord.msg_feeds_content.get().toByteArray(), true);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            if (decodeToFeedItem != null) {
                str = decodeToFeedItem.f293919d;
                if (str != null) {
                    str2 = str;
                }
                TroopExtDBInfoRepo.INSTANCE.updateAnnouncement(troopInfo.troopuin, str2);
                if (!QLog.isColorLevel()) {
                    QLog.i("TroopAnnouncementHandler", 2, "setLastMemoData : " + troopInfo.extDBInfo.strLastAnnouncement);
                    return;
                }
                return;
            }
        }
        str = "";
        if (str != null) {
        }
        TroopExtDBInfoRepo.INSTANCE.updateAnnouncement(troopInfo.troopuin, str2);
        if (!QLog.isColorLevel()) {
        }
    }

    private void S2(int i3, long j3, long j16, long j17, String str, int i16, String str2, short s16, boolean z16, boolean z17) {
        this.appRuntime.addDefaultObservers(new a(j16, str2, i3, j3, j17, str, i16, z17, s16, z16));
    }

    public void K2(String str, String str2, short s16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, str2, Short.valueOf(s16));
            return;
        }
        try {
            i3 = 2;
            try {
                O2(0, Long.parseLong(str2), Long.parseLong(str), Long.parseLong(this.appRuntime.getCurrentAccountUin()), "", (int) System.currentTimeMillis(), "OidbSvc.0x852_48", s16, true, true, false);
            } catch (NumberFormatException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAnnouncementHandler", i3, "troopCode not long type!");
                }
            }
        } catch (NumberFormatException unused2) {
            i3 = 2;
        }
    }

    @Override // com.tencent.mobileqq.troop.announcement.api.a
    public ITroopAnnouncementHelperApi.a V(DataInputStream dataInputStream, boolean z16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ITroopAnnouncementHelperApi.a) iPatchRedirector.redirect((short) 10, this, dataInputStream, Boolean.valueOf(z16));
        }
        dataInputStream.read();
        dataInputStream.readShort();
        short readShort = dataInputStream.readShort();
        dataInputStream.readInt();
        int readInt = dataInputStream.readInt();
        byte[] bArr = new byte[32];
        Arrays.fill(bArr, (byte) 0);
        dataInputStream.read(bArr);
        dataInputStream.readInt();
        dataInputStream.readInt();
        dataInputStream.readInt();
        int readInt2 = dataInputStream.readInt();
        dataInputStream.readInt();
        dataInputStream.readInt();
        dataInputStream.readInt();
        dataInputStream.readInt();
        dataInputStream.skip(dataInputStream.readShort() * 5);
        dataInputStream.skip(16L);
        byte[] bArr2 = new byte[dataInputStream.readInt()];
        dataInputStream.read(bArr2);
        String str = new String(bArr);
        int indexOf = str.indexOf(0);
        if (indexOf == -1) {
            indexOf = str.length();
        }
        ITroopAnnouncementHelperApi.a decodeToFeedItem = ((ITroopAnnouncementHelperApi) QRoute.api(ITroopAnnouncementHelperApi.class)).decodeToFeedItem(str.substring(0, indexOf), bArr2, z16);
        if (decodeToFeedItem != null) {
            if (readInt < 0) {
                decodeToFeedItem.f293922g = readInt & 4294967295L;
            } else {
                decodeToFeedItem.f293922g = readInt;
            }
            decodeToFeedItem.f293923h = readInt2;
            decodeToFeedItem.f293921f = readShort;
        }
        return decodeToFeedItem;
    }

    @Override // com.tencent.mobileqq.troop.announcement.api.a
    public void a(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            notifyUI(i3, z16, obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.announcement.api.a
    public void b1(int i3, long j3, long j16, long j17, String str, int i16, short s16, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), str, Integer.valueOf(i16), Short.valueOf(s16), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            O2(i3, j3, j16, j17, str, i16, "OidbSvc.0x852_48", s16, z16, z17, false);
        }
    }

    @Override // com.tencent.mobileqq.troop.announcement.api.a
    public boolean e1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        ConcurrentHashMap<String, Boolean> concurrentHashMap = f293934e;
        if (concurrentHashMap.containsKey(str)) {
            return concurrentHashMap.get(str).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.announcement.api.a
    public void f0(String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            j3 = 0;
        }
        if (j3 == 0) {
            QLog.d("TroopAnnouncementHandler", 1, "getLatestTroopMemo group code is 0! groupCode: " + str);
            return;
        }
        oidb_0x8f9$SourceID oidb_0x8f9_sourceid = new oidb_0x8f9$SourceID();
        oidb_0x8f9_sourceid.uint32_source_type.set(1);
        oidb_0x8f9_sourceid.uint64_source_code.set(j3);
        oidb_0x8f9$ReqBody oidb_0x8f9_reqbody = new oidb_0x8f9$ReqBody();
        oidb_0x8f9_reqbody.msg_source_id.set(oidb_0x8f9_sourceid);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x8f9_14", 2297, 14, oidb_0x8f9_reqbody.toByteArray());
        makeOIDBPkg.extraData.putString("from", "getLatestTroopMemo");
        makeOIDBPkg.extraData.putLong("group_code", j3);
        super.sendPbReq(makeOIDBPkg);
        if (QLog.isColorLevel()) {
            QLog.d("TroopAnnouncementHandler", 2, "sendPbRequest. cmd=" + makeOIDBPkg.getServiceCmd());
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("TroopAnnouncementHandler", 4, "getLatestTroopMemo code: " + str);
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
            hashSet.add("OidbSvc.0x8f9_14");
            this.allowCmdSet.add("OidbSvc.0x852_35");
            this.allowCmdSet.add("OidbSvc.0x852_48");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopAnnouncementHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.class;
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
                    QLog.d("TroopAnnouncementHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAnnouncementHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0x8f9_14".equals(fromServiceMsg.getServiceCmd())) {
                N2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else if ("OidbSvc.0x852_35".equals(fromServiceMsg.getServiceCmd())) {
                L2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvc.0x852_48".equals(fromServiceMsg.getServiceCmd())) {
                    M2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAnnouncementHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.announcement.api.a
    public void p2(int i3, long j3, long j16, long j17, String str, int i16, short s16, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), str, Integer.valueOf(i16), Short.valueOf(s16), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        } else {
            O2(i3, j3, j16, j17, str, i16, "OidbSvc.0x852_35", s16, z16, z17, z18);
        }
    }
}
