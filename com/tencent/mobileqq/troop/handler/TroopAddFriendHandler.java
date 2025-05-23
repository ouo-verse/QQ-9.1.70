package com.tencent.mobileqq.troop.handler;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.config.v;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import tencent.im.oidb.cmd0xb01.cmd0xb01$ReqBody;
import tencent.im.oidb.cmd0xb01.cmd0xb01$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAddFriendHandler extends TroopBaseHandler implements com.tencent.mobileqq.troop.api.handler.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f296226e;

    public TroopAddFriendHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            v.a().c(appInterface);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v10 */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.tencent.mobileqq.troop.handler.TroopAddFriendHandler, com.tencent.mobileqq.app.BaseBusinessHandler, com.tencent.mobileqq.app.BusinessHandler] */
    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        char c16;
        char c17;
        ?? r232;
        boolean z16;
        char c18;
        boolean z17;
        int i3;
        int i16;
        char c19;
        boolean z18;
        String string = toServiceMsg.extraData.getString("troopUin");
        String string2 = toServiceMsg.extraData.getString(IProfileProtocolConst.PARAM_TROOP_CODE);
        long j3 = toServiceMsg.extraData.getLong("reqTs", 0L);
        int i17 = 0;
        int i18 = toServiceMsg.extraData.getInt("type", 0);
        cmd0xb01$RspBody cmd0xb01_rspbody = new cmd0xb01$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xb01_rspbody);
        int i19 = -1;
        if (parseOIDBPkg == 0) {
            if (cmd0xb01_rspbody.uint32_result.has()) {
                int i26 = cmd0xb01_rspbody.uint32_result.get();
                if (i26 == 0) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                if (i26 == 2) {
                    i16 = i26;
                    c19 = 2;
                    z18 = false;
                    ReportController.o(this.appRuntime, "dc00899", "Grp_addFrd", "", "nonGreyTip", "density", 0, 0, string, "", String.valueOf(cmd0xb01_rspbody.double_density.get()), "");
                } else {
                    i16 = i26;
                    c19 = 2;
                    z18 = false;
                }
                i17 = i3;
                i19 = i16;
                c18 = c19;
                z17 = z18;
            } else {
                c18 = 2;
                z17 = false;
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.appRuntime.getApp());
            Locale locale = Locale.getDefault();
            c17 = 3;
            Object[] objArr = new Object[3];
            objArr[z17 ? 1 : 0] = "sp_baf_security_check_flag";
            objArr[1] = this.appRuntime.getCurrentAccountUin();
            objArr[c18] = string;
            defaultSharedPreferences.edit().putInt(String.format(locale, "%s_%s_%s", objArr), i17).apply();
            c16 = c18;
            r232 = z17;
        } else {
            c16 = 2;
            c17 = 3;
            r232 = 0;
        }
        int i27 = e.TYPE_BATCH_ADD_FRIEND_SECURITY_CHECK;
        if (parseOIDBPkg == 0) {
            z16 = true;
        } else {
            z16 = r232;
        }
        Object[] objArr2 = new Object[5];
        objArr2[r232] = Integer.valueOf(i17);
        objArr2[1] = string;
        objArr2[c16] = string2;
        objArr2[c17] = Long.valueOf(j3);
        objArr2[4] = Integer.valueOf(i18);
        notifyUI(i27, z16, objArr2);
        if (QLog.isDevelopLevel()) {
            Locale locale2 = Locale.getDefault();
            Object[] objArr3 = new Object[6];
            objArr3[r232] = string;
            objArr3[1] = Integer.valueOf(i18);
            objArr3[c16] = Long.valueOf(j3);
            objArr3[c17] = Integer.valueOf(parseOIDBPkg);
            objArr3[4] = Integer.valueOf(i17);
            objArr3[5] = Integer.valueOf(i19);
            QLog.d("TroopAddFriendHandler", 4, String.format(locale2, "handleBatchAddFriendSecurityCheck %s_%d_%d result: %s_%s_%s", objArr3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v7 */
    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        char c16;
        char c17;
        char c18;
        int i3;
        char c19;
        char c26;
        ?? r142;
        long j3 = toServiceMsg.extraData.getLong("reqTs", 0L);
        int i16 = 0;
        int i17 = toServiceMsg.extraData.getInt("type", 0);
        String string = toServiceMsg.extraData.getString("fromUin");
        String string2 = toServiceMsg.extraData.getString("troopUin");
        int i18 = toServiceMsg.extraData.getInt("startOffset");
        boolean z17 = toServiceMsg.extraData.getBoolean("bIncrement");
        ArrayList<String> stringArrayList = toServiceMsg.extraData.getStringArrayList("uins");
        if (i18 >= stringArrayList.size()) {
            z16 = true;
        } else {
            z16 = false;
        }
        HashMap<String, Integer> hashMap = new HashMap<>(50);
        if (fromServiceMsg.getResultCode() == 1000) {
            byte[] bArr = (byte[]) obj;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                oidb_sso_oidbssopkg.uint32_result.get();
                ByteBuffer wrap = ByteBuffer.wrap(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                wrap.getInt();
                Short valueOf = Short.valueOf(wrap.getShort());
                while (i16 < valueOf.shortValue()) {
                    hashMap.put(Long.toString(wrap.getInt() & 4294967295L), Integer.valueOf(Short.valueOf(wrap.getShort()).shortValue()));
                    i16++;
                    stringArrayList = stringArrayList;
                }
                ArrayList<String> arrayList = stringArrayList;
                v.a().d(this.appRuntime, string2, hashMap);
                Short valueOf2 = Short.valueOf(wrap.getShort());
                if (QLog.isColorLevel()) {
                    c19 = 2;
                    c26 = 0;
                    r142 = 1;
                    QLog.i("TroopAddFriendHandler", 2, String.format("handleBatchReqMemberCmnFrds sucNum:%d, failNum:%d", valueOf, valueOf2));
                } else {
                    c19 = 2;
                    c26 = 0;
                    r142 = 1;
                }
                int i19 = e.TYPE_NOTIFY_BATCH_REQ_COMMFRDS;
                Object[] objArr = new Object[8];
                objArr[c26] = string2;
                objArr[r142] = string;
                objArr[c19] = Long.valueOf(j3);
                objArr[3] = Integer.valueOf(i17);
                objArr[4] = Boolean.valueOf(z16);
                objArr[5] = Boolean.valueOf(z17);
                objArr[6] = hashMap;
                objArr[7] = arrayList;
                notifyUI(i19, r142, objArr);
                if (!z16) {
                    t1(string2, arrayList, i18, j3, i17, z17);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                Object[] objArr2 = new Object[1];
                if (oidb_sso_oidbssopkg == null) {
                    i3 = -1;
                } else {
                    i3 = oidb_sso_oidbssopkg.uint32_result.get();
                }
                c18 = 0;
                objArr2[0] = Integer.valueOf(i3);
                c17 = 2;
                QLog.i("TroopAddFriendHandler", 2, String.format("handleBatchReqMemberCmnFrds result:%d", objArr2));
            } else {
                c17 = 2;
                c18 = 0;
            }
            int i26 = e.TYPE_NOTIFY_BATCH_REQ_COMMFRDS;
            Object[] objArr3 = new Object[8];
            objArr3[c18] = string2;
            objArr3[1] = string;
            objArr3[c17] = Long.valueOf(j3);
            objArr3[3] = Integer.valueOf(i17);
            objArr3[4] = Boolean.valueOf(z16);
            objArr3[5] = Boolean.valueOf(z17);
            objArr3[6] = null;
            objArr3[7] = null;
            notifyUI(i26, false, objArr3);
            return;
        }
        if (QLog.isColorLevel()) {
            c16 = 2;
            QLog.i("TroopAddFriendHandler", 2, String.format("handleBatchReqMemberCmnFrds result2:%d", Integer.valueOf(fromServiceMsg.getResultCode())));
        } else {
            c16 = 2;
        }
        int i27 = e.TYPE_NOTIFY_BATCH_REQ_COMMFRDS;
        Object[] objArr4 = new Object[8];
        objArr4[0] = string2;
        objArr4[1] = string;
        objArr4[c16] = Long.valueOf(j3);
        objArr4[3] = Integer.valueOf(i17);
        objArr4[4] = Boolean.valueOf(z16);
        objArr4[5] = Boolean.valueOf(z17);
        objArr4[6] = null;
        objArr4[7] = null;
        notifyUI(i27, false, objArr4);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.troop.api.handler.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b0(String str, String str2, long j3, int i3) {
        long j16;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        try {
            j16 = Long.parseLong(this.appRuntime.getAccount());
        } catch (Throwable th5) {
            th = th5;
            j16 = 0;
        }
        try {
            j17 = Long.parseLong(str2);
        } catch (Throwable th6) {
            th = th6;
            th.printStackTrace();
            j17 = 0;
            if (j16 == 0) {
            }
            if (!QLog.isDevelopLevel()) {
            }
        }
        if (j16 == 0 && j17 != 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TroopAddFriendHandler", 4, String.format(Locale.getDefault(), "batchAddFriendSecurityCheck %s_%d_%d", Long.valueOf(j17), Integer.valueOf(i3), Long.valueOf(j3)));
            }
            cmd0xb01$ReqBody cmd0xb01_reqbody = new cmd0xb01$ReqBody();
            cmd0xb01_reqbody.uint64_uin.set(j16);
            cmd0xb01_reqbody.uint64_group_uin.set(j17);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xb01", 2817, 1, cmd0xb01_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("troopUin", str);
            makeOIDBPkg.extraData.putString(IProfileProtocolConst.PARAM_TROOP_CODE, str2);
            makeOIDBPkg.extraData.putLong("reqTs", j3);
            makeOIDBPkg.extraData.putInt("type", i3);
            sendPbReq(makeOIDBPkg);
            return;
        }
        if (!QLog.isDevelopLevel()) {
            QLog.d("TroopAddFriendHandler", 4, "batchAddFriendSecurityCheck invalid param!");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f296226e == null) {
            HashSet hashSet = new HashSet();
            this.f296226e = hashSet;
            hashSet.add("OidbSvc.0x42d_4");
            this.f296226e.add("OidbSvc.0xb01");
        }
        return this.f296226e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "TroopAddFriendHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return e.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAddFriendHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAddFriendHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0x42d_4".equals(fromServiceMsg.getServiceCmd())) {
                G2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvc.0xb01".equals(fromServiceMsg.getServiceCmd())) {
                    F2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAddFriendHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.a
    public void t1(String str, List<String> list, int i3, long j3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, list, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopAddFriendHandler", 2, String.format("batchReqMemberCmnFrds %s_%d_%d_%d_%d_%b", str, Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(list.size()), Integer.valueOf(i3), Boolean.valueOf(z16)));
        }
        int i17 = i3 + 50;
        if (i17 > list.size()) {
            i17 = list.size();
        }
        List<String> subList = list.subList(i3, i17);
        int size = subList.size();
        if (size == 0) {
            return;
        }
        String currentUin = this.appRuntime.getCurrentUin();
        ByteBuffer allocate = ByteBuffer.allocate((size * 4) + 6);
        allocate.putInt((int) Long.parseLong(currentUin));
        allocate.putShort((short) size);
        for (int i18 = 0; i18 < size; i18++) {
            allocate.putInt((int) Long.parseLong(subList.get(i18)));
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1069);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(4);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x42d_4");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putLong("reqTs", j3);
        createToServiceMsg.extraData.putInt("type", i16);
        createToServiceMsg.extraData.putString("fromUin", currentUin);
        createToServiceMsg.extraData.putString("troopUin", str);
        createToServiceMsg.extraData.putInt("startOffset", i17);
        createToServiceMsg.extraData.putBoolean("bIncrement", z16);
        createToServiceMsg.extraData.putStringArrayList("uins", (ArrayList) list);
        sendPbReq(createToServiceMsg);
    }
}
