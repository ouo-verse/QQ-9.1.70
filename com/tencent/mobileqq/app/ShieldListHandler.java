package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.http.util.ByteArrayBuffer;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist$BlockUinInfo;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist$ReqBody;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist$ReqBodyAddBlockList;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist$ReqBodyDelBlockList;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist$ReqBodyGetBlockList;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist$RspBody;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist$RspBodyGetBlockList;
import tencent.im.sso2sns.sso2sns_comm_info$Sso2SnsCommInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ShieldListHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private QQAppInterface M;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentLinkedQueue<ShieldOperationItem> f195061d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f195062e;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f195063f;

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, ShieldListInfo> f195064h;

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, ShieldListInfo> f195065i;

    /* renamed from: m, reason: collision with root package name */
    private String f195066m;

    ShieldListHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195061d = new ConcurrentLinkedQueue<>();
        this.f195062e = false;
        this.f195063f = -1;
        this.f195064h = new ConcurrentHashMap<>();
        this.f195065i = new ConcurrentHashMap<>();
        this.f195066m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = qQAppInterface;
        this.f195066m = qQAppInterface.getApplication().getString(R.string.hk5);
        this.C = qQAppInterface.getApplication().getString(R.string.hk6);
        this.D = qQAppInterface.getApplication().getString(R.string.f173144hk3);
        this.E = qQAppInterface.getApplication().getString(R.string.hk7);
        this.H = qQAppInterface.getApplication().getString(R.string.f173142hk1);
        this.I = qQAppInterface.getApplication().getString(R.string.hjz);
        this.J = qQAppInterface.getApplication().getString(R.string.f173143hk2);
        this.F = qQAppInterface.getApplication().getString(R.string.f173145hk4);
        this.K = qQAppInterface.getApplication().getString(R.string.f173141hk0);
        this.G = qQAppInterface.getApplication().getString(R.string.f227586rf);
        this.L = qQAppInterface.getApplication().getString(R.string.f227556rc);
    }

    private void D2(ShieldOperationItem shieldOperationItem) {
        synchronized (this.f195061d) {
            this.f195061d.add(shieldOperationItem);
            G2();
        }
    }

    private byte[] E2(sso2sns_comm_info$Sso2SnsCommInfo sso2sns_comm_info_sso2snscomminfo, sso2sns_0x3_blocklist$ReqBody sso2sns_0x3_blocklist_reqbody) {
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] byteArray = sso2sns_comm_info_sso2snscomminfo.toByteArray();
        byte[] byteArray2 = sso2sns_0x3_blocklist_reqbody.toByteArray();
        long length = byteArray.length;
        long length2 = byteArray2.length;
        PkgTools.dWord2Byte(bArr, 0, length);
        PkgTools.dWord2Byte(bArr2, 0, length2);
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer((int) (8 + length + length2));
        byteArrayBuffer.append(bArr, 0, 4);
        byteArrayBuffer.append(bArr2, 0, 4);
        byteArrayBuffer.append(byteArray, 0, (int) length);
        byteArrayBuffer.append(byteArray2, 0, (int) length2);
        return byteArrayBuffer.toByteArray();
    }

    private boolean F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        sso2sns_comm_info$Sso2SnsCommInfo sso2sns_comm_info_sso2snscomminfo;
        byte[] bArr = (byte[]) obj;
        String serviceCmd = fromServiceMsg.getServiceCmd();
        sso2sns_comm_info$Sso2SnsCommInfo sso2sns_comm_info_sso2snscomminfo2 = new sso2sns_comm_info$Sso2SnsCommInfo();
        sso2sns_0x3_blocklist$RspBody sso2sns_0x3_blocklist_rspbody = new sso2sns_0x3_blocklist$RspBody();
        if (bArr.length < 8) {
            handleError(toServiceMsg, fromServiceMsg);
            return false;
        }
        long longData = PkgTools.getLongData(bArr, 0);
        int i3 = (int) longData;
        byte[] bArr2 = new byte[i3];
        int longData2 = (int) PkgTools.getLongData(bArr, 4);
        byte[] bArr3 = new byte[longData2];
        System.arraycopy(bArr, 8, bArr2, 0, i3);
        try {
            sso2sns_comm_info_sso2snscomminfo = sso2sns_comm_info_sso2snscomminfo2.mergeFrom(bArr2);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: exception : parse Sso2SnsCommInfo failed.", e16);
            }
            sso2sns_comm_info_sso2snscomminfo = null;
        }
        if (sso2sns_comm_info_sso2snscomminfo == null) {
            if (QLog.isColorLevel()) {
                QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: error: commInfo is null.");
            }
            handleError(toServiceMsg, fromServiceMsg);
            return false;
        }
        if (sso2sns_comm_info_sso2snscomminfo.uint32_result.has() && sso2sns_comm_info_sso2snscomminfo.uint32_result.get() == 0) {
            System.arraycopy(bArr, (int) (longData + 8), bArr3, 0, longData2);
            try {
                sso2sns_0x3_blocklist$RspBody mergeFrom = sso2sns_0x3_blocklist_rspbody.mergeFrom(bArr3);
                if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(serviceCmd)) {
                    return P2(toServiceMsg, fromServiceMsg, mergeFrom);
                }
                if ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(serviceCmd)) {
                    L2(toServiceMsg, fromServiceMsg, mergeFrom);
                    return false;
                }
                if (!"SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(serviceCmd)) {
                    return false;
                }
                N2(toServiceMsg, fromServiceMsg, mergeFrom);
                return false;
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: exception : parse RspBody failed.", e17);
                }
                handleError(toServiceMsg, fromServiceMsg);
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: error resultCode :" + sso2sns_comm_info_sso2snscomminfo.uint32_result.get());
        }
        handleError(toServiceMsg, fromServiceMsg);
        return false;
    }

    private void G2() {
        synchronized (this.f195061d) {
            boolean isEmpty = this.f195061d.isEmpty();
            if (QLog.isColorLevel()) {
                QLog.d("ShieldListHandler", 2, "--->execNextShieldOperation : isShieldOperating:" + this.f195062e + ",isEmpty:" + isEmpty);
            }
            if (!this.f195062e && !isEmpty) {
                ShieldOperationItem poll = this.f195061d.poll();
                if (poll == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("ShieldListHandler", 2, "--->execNextShieldOperation : queque is empty.");
                    }
                    return;
                }
                int i3 = poll.f195067d;
                this.f195062e = true;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            X2(poll);
                        }
                    } else {
                        V2(poll);
                    }
                } else {
                    Z2(0, 0);
                }
            }
        }
    }

    private void H2() {
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "flushPushCacheIntoDB : pushCache size" + this.f195064h.size());
        }
        if (this.f195064h.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f195064h.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(this.f195064h.get(it.next()));
        }
        ((ShieldMsgManger) this.M.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).i(arrayList);
        this.f195064h.clear();
        notifyUI(4, true, null);
    }

    private int I2() {
        if (this.f195063f == -1) {
            this.f195063f = this.M.getApp().getSharedPreferences(this.M.getCurrentAccountUin(), 0).getInt(AppConstants.Preferences.LAST_GET_SHIELD_LIST_TIME, 0);
        }
        return this.f195063f;
    }

    private String J2(boolean z16, long j3, int i3, String str) {
        QidianManager qidianManager;
        QidianManager qidianManager2;
        if (i3 != 1006) {
            if (z16) {
                String str2 = this.f195066m;
                if (ChatActivityUtils.f175163c.contains(j3 + "")) {
                    str2 = this.C;
                    ChatActivityUtils.f175163c.remove(j3 + "");
                }
                if (i3 == 1024 && ((qidianManager2 = (QidianManager) this.M.getManager(QQManagerFactory.QIDIAN_MANAGER)) == null || (!qidianManager2.L(str) && !qidianManager2.R(str)))) {
                    str2 = this.E;
                }
                if (i3 == 1044 || i3 == 1045) {
                    str2 = this.F;
                }
                String str3 = str2;
                if (i3 == 1046) {
                    return this.G;
                }
                return str3;
            }
            String str4 = this.H;
            if (i3 == 1024 && ((qidianManager = (QidianManager) this.M.getManager(QQManagerFactory.QIDIAN_MANAGER)) == null || (!qidianManager.L(str) && !qidianManager.R(str)))) {
                str4 = this.J;
            }
            if (i3 == 1044 || i3 == 1045) {
                str4 = this.K;
            }
            String str5 = str4;
            if (i3 == 1046) {
                return this.L;
            }
            return str5;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<---insertShieldMsgIntoMsgPool : isContactMsgType!");
        }
        if (str == null) {
            return "";
        }
        if (z16) {
            return this.D;
        }
        return this.I;
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long[] longArray = toServiceMsg.extraData.getLongArray(SquareJSConst.Params.PARAMS_UIN_LIST);
        int i3 = toServiceMsg.extraData.getInt(IProfileCardConst.KEY_FROM_TYPE);
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_add><E> : handleAddShieldListError :" + Arrays.toString(longArray));
        }
        notifyUI(2, false, new Object[]{longArray, Integer.valueOf(i3)});
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, sso2sns_0x3_blocklist$RspBody sso2sns_0x3_blocklist_rspbody) {
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_add><R><---handleAddShieldListResp.");
        }
        ArrayList arrayList = new ArrayList();
        long[] longArray = toServiceMsg.extraData.getLongArray(SquareJSConst.Params.PARAMS_UIN_LIST);
        int i3 = toServiceMsg.extraData.getInt("source_id");
        int i16 = toServiceMsg.extraData.getInt("source_sub_id");
        int i17 = toServiceMsg.extraData.getInt(IProfileCardConst.KEY_FROM_TYPE);
        for (long j3 : longArray) {
            Long valueOf = Long.valueOf(j3);
            ShieldListInfo shieldListInfo = new ShieldListInfo();
            shieldListInfo.uin = String.valueOf(valueOf);
            shieldListInfo.source_id = i3;
            shieldListInfo.source_sub_id = i16;
            shieldListInfo.flags = 1;
            arrayList.add(shieldListInfo);
        }
        ((ShieldMsgManger) this.M.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).i(arrayList);
        S2(true, i3, longArray);
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_add><R> : " + Arrays.toString(longArray));
        }
        notifyUI(2, true, new Object[]{longArray, Integer.valueOf(i17)});
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long[] longArray = toServiceMsg.extraData.getLongArray(SquareJSConst.Params.PARAMS_UIN_LIST);
        int i3 = toServiceMsg.extraData.getInt(IProfileCardConst.KEY_FROM_TYPE);
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_del><E> : handleDeleteShieldListError : " + Arrays.toString(longArray));
        }
        notifyUI(3, false, new Object[]{longArray, Integer.valueOf(i3)});
    }

    private void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, sso2sns_0x3_blocklist$RspBody sso2sns_0x3_blocklist_rspbody) {
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_del><R><---handleDeleteShieldListResp.");
        }
        ArrayList arrayList = new ArrayList();
        long[] longArray = toServiceMsg.extraData.getLongArray(SquareJSConst.Params.PARAMS_UIN_LIST);
        int i3 = toServiceMsg.extraData.getInt("source_id");
        int i16 = toServiceMsg.extraData.getInt("source_sub_id");
        int i17 = toServiceMsg.extraData.getInt(IProfileCardConst.KEY_FROM_TYPE);
        for (long j3 : longArray) {
            Long valueOf = Long.valueOf(j3);
            ShieldListInfo shieldListInfo = new ShieldListInfo();
            shieldListInfo.uin = String.valueOf(valueOf);
            shieldListInfo.source_id = i3;
            shieldListInfo.source_sub_id = i16;
            shieldListInfo.flags = 0;
            arrayList.add(shieldListInfo);
        }
        ((ShieldMsgManger) this.M.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).i(arrayList);
        S2(false, i3, longArray);
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_del><R> : " + Arrays.toString(longArray));
        }
        notifyUI(3, true, new Object[]{longArray, Integer.valueOf(i17)});
    }

    private void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_get><E><---handleGetShieldListError.");
        }
        notifyUI(1, false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean P2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, sso2sns_0x3_blocklist$RspBody sso2sns_0x3_blocklist_rspbody) {
        int i3;
        boolean i16;
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_get><R><---handleGetShieldListResp.");
        }
        if (sso2sns_0x3_blocklist_rspbody != null && sso2sns_0x3_blocklist_rspbody.msg_body_get_blocklist.has()) {
            sso2sns_0x3_blocklist$RspBodyGetBlockList sso2sns_0x3_blocklist_rspbodygetblocklist = sso2sns_0x3_blocklist_rspbody.msg_body_get_blocklist.get();
            int i17 = sso2sns_0x3_blocklist_rspbodygetblocklist.fixed32_get_time.get();
            int i18 = sso2sns_0x3_blocklist_rspbodygetblocklist.uint32_completed.get();
            int i19 = sso2sns_0x3_blocklist_rspbodygetblocklist.uint32_now_pos.get();
            int i26 = sso2sns_0x3_blocklist_rspbodygetblocklist.uint32_get_type.get();
            List<sso2sns_0x3_blocklist$BlockUinInfo> list = sso2sns_0x3_blocklist_rspbodygetblocklist.rpt_msg_block_uin_info.get();
            ShieldMsgManger shieldMsgManger = (ShieldMsgManger) this.M.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ShieldListHandler", 2, "<---handleGetShieldListResp : lastGetTime:" + i17 + ",isComplete:" + i18 + ",nowPos:" + i19 + ",getType:" + i26 + ",respSize:" + i3);
            }
            if (i26 == 2) {
                if (list != null && list.size() > 0) {
                    for (sso2sns_0x3_blocklist$BlockUinInfo sso2sns_0x3_blocklist_blockuininfo : list) {
                        ShieldListInfo shieldListInfo = new ShieldListInfo();
                        shieldListInfo.uin = String.valueOf(sso2sns_0x3_blocklist_blockuininfo.uint64_block_uin.get());
                        shieldListInfo.flags = 1;
                        shieldListInfo.source_id = sso2sns_0x3_blocklist_blockuininfo.uint32_source_id.get();
                        shieldListInfo.source_sub_id = sso2sns_0x3_blocklist_blockuininfo.uint32_source_sub_id.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("ShieldListHandler", 2, "<---handleGetShieldListResp : total data : shieldUin:" + shieldListInfo.uin + ",source_id:" + shieldListInfo.source_id + ",sub_ource_id:" + shieldListInfo.source_sub_id);
                        }
                        this.f195065i.put(shieldListInfo.uin, shieldListInfo);
                    }
                }
                if (i18 == 1) {
                    i16 = shieldMsgManger.j(this.f195065i);
                    this.f195065i.clear();
                    if (i18 != 0) {
                        Z2(i26, i19);
                        return true;
                    }
                    if (i18 == 1 && i16) {
                        a3(i17);
                    }
                }
                i16 = false;
                if (i18 != 0) {
                }
            } else {
                if (i26 == 1) {
                    ArrayList arrayList = new ArrayList();
                    if (list != null && list.size() > 0) {
                        for (sso2sns_0x3_blocklist$BlockUinInfo sso2sns_0x3_blocklist_blockuininfo2 : list) {
                            ShieldListInfo shieldListInfo2 = new ShieldListInfo();
                            shieldListInfo2.uin = String.valueOf(sso2sns_0x3_blocklist_blockuininfo2.uint64_block_uin.get());
                            shieldListInfo2.flags = 1;
                            shieldListInfo2.source_id = sso2sns_0x3_blocklist_blockuininfo2.uint32_source_id.get();
                            shieldListInfo2.source_sub_id = sso2sns_0x3_blocklist_blockuininfo2.uint32_source_sub_id.get();
                            if (QLog.isColorLevel()) {
                                QLog.d("ShieldListHandler", 2, "<---handleGetShieldListResp : add data :" + shieldListInfo2.toString());
                            }
                            arrayList.add(shieldListInfo2);
                        }
                    }
                    i16 = shieldMsgManger.i(arrayList);
                    if (i18 != 0) {
                    }
                }
                i16 = false;
                if (i18 != 0) {
                }
            }
        }
        return false;
    }

    private void R2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield><TO><---handleOperatingShieldList time out.");
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (serviceCmd != null && serviceCmd.length() != 0) {
            if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(serviceCmd)) {
                O2(toServiceMsg, fromServiceMsg);
            } else if ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(serviceCmd)) {
                K2(toServiceMsg, fromServiceMsg);
            } else if ("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(serviceCmd)) {
                M2(toServiceMsg, fromServiceMsg);
            }
        }
    }

    private void S2(boolean z16, int i3, long[] jArr) {
        int i16;
        int i17;
        boolean z17;
        ArrayList<MessageRecord> arrayList;
        String currentAccountUin = this.M.getCurrentAccountUin();
        ArrayList<MessageRecord> arrayList2 = new ArrayList<>();
        int length = jArr.length;
        boolean z18 = false;
        int i18 = 0;
        while (i18 < length) {
            long j3 = jArr[i18];
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            int SOURCE_ID_2_AIO_TYPE = ShieldListInfo.SOURCE_ID_2_AIO_TYPE(i3);
            String valueOf = String.valueOf(j3);
            if (SOURCE_ID_2_AIO_TYPE == 1006) {
                valueOf = com.tencent.mobileqq.utils.ac.V(this.M, String.valueOf(j3));
            }
            String str = valueOf;
            String J2 = J2(z16, j3, SOURCE_ID_2_AIO_TYPE, str);
            if (TextUtils.isEmpty(J2)) {
                i16 = i18;
                i17 = length;
                z17 = z18;
                arrayList = arrayList2;
            } else {
                MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_SHIELD_MSG);
                i16 = i18;
                i17 = length;
                z17 = z18;
                ArrayList<MessageRecord> arrayList3 = arrayList2;
                d16.init(currentAccountUin, str, currentAccountUin, J2, K0, 0, SOURCE_ID_2_AIO_TYPE, 0L);
                d16.msgtype = MessageRecord.MSG_TYPE_SHIELD_MSG;
                boolean z19 = true;
                d16.isread = true;
                List<MessageRecord> Q = this.M.getMessageFacade().Q(str, SOURCE_ID_2_AIO_TYPE);
                if (Q != null && Q.size() > 0 && com.tencent.imcore.message.ad.b(Q.get(Q.size() - 1), d16, z17)) {
                    if (QLog.isColorLevel()) {
                        QLog.w("ShieldListHandler", 2, "insertShieldMsgIntoMsgPool filtered!");
                    }
                } else {
                    z19 = z17;
                }
                arrayList = arrayList3;
                if (!z19) {
                    arrayList.add(d16);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ShieldListHandler", 2, "<---insertShieldMsgIntoMsgPool : insert:" + d16.toString());
                }
            }
            i18 = i16 + 1;
            z18 = z17;
            arrayList2 = arrayList;
            length = i17;
        }
        this.M.getMessageFacade().e(arrayList2, String.valueOf(currentAccountUin), z18);
    }

    private void T2() {
        this.f195062e = false;
        H2();
        G2();
    }

    private void V2(ShieldOperationItem shieldOperationItem) {
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_add><S> : sendGetShieldListReqInternal : queue size:" + this.f195061d.size());
        }
        long longValue = Long.valueOf(this.M.getCurrentAccountUin()).longValue();
        ToServiceMsg createToServiceMsg = createToServiceMsg("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList");
        sso2sns_comm_info$Sso2SnsCommInfo sso2sns_comm_info_sso2snscomminfo = new sso2sns_comm_info$Sso2SnsCommInfo();
        sso2sns_comm_info_sso2snscomminfo.uint32_seq.set(1234);
        sso2sns_0x3_blocklist$ReqBodyAddBlockList sso2sns_0x3_blocklist_reqbodyaddblocklist = new sso2sns_0x3_blocklist$ReqBodyAddBlockList();
        sso2sns_0x3_blocklist_reqbodyaddblocklist.uint64_uin.set(longValue);
        for (long j3 : shieldOperationItem.f195070h) {
            Long valueOf = Long.valueOf(j3);
            sso2sns_0x3_blocklist$BlockUinInfo sso2sns_0x3_blocklist_blockuininfo = new sso2sns_0x3_blocklist$BlockUinInfo();
            sso2sns_0x3_blocklist_blockuininfo.uint64_block_uin.set(valueOf.longValue());
            sso2sns_0x3_blocklist_blockuininfo.uint32_source_id.set(shieldOperationItem.f195068e);
            sso2sns_0x3_blocklist_blockuininfo.uint32_source_sub_id.set(0);
            sso2sns_0x3_blocklist_reqbodyaddblocklist.rpt_msg_block_uin_info.add(sso2sns_0x3_blocklist_blockuininfo);
        }
        sso2sns_0x3_blocklist$ReqBody sso2sns_0x3_blocklist_reqbody = new sso2sns_0x3_blocklist$ReqBody();
        sso2sns_0x3_blocklist_reqbody.msg_body_add_blocklist.set(sso2sns_0x3_blocklist_reqbodyaddblocklist);
        byte[] E2 = E2(sso2sns_comm_info_sso2snscomminfo, sso2sns_0x3_blocklist_reqbody);
        createToServiceMsg.setTimeout(60000L);
        createToServiceMsg.extraData.putInt("opType", shieldOperationItem.f195067d);
        createToServiceMsg.extraData.putInt("source_id", shieldOperationItem.f195068e);
        createToServiceMsg.extraData.putInt("source_sub_id", shieldOperationItem.f195069f);
        createToServiceMsg.extraData.putLongArray(SquareJSConst.Params.PARAMS_UIN_LIST, shieldOperationItem.f195070h);
        createToServiceMsg.extraData.putInt(IProfileCardConst.KEY_FROM_TYPE, shieldOperationItem.f195071i);
        createToServiceMsg.putWupBuffer(E2);
        sendPbReq(createToServiceMsg);
    }

    private void X2(ShieldOperationItem shieldOperationItem) {
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_del><S> : sendDeleteShieldListReqInternal : queue size:" + this.f195061d.size());
        }
        long longValue = Long.valueOf(this.M.getCurrentAccountUin()).longValue();
        ToServiceMsg createToServiceMsg = createToServiceMsg("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList");
        sso2sns_comm_info$Sso2SnsCommInfo sso2sns_comm_info_sso2snscomminfo = new sso2sns_comm_info$Sso2SnsCommInfo();
        sso2sns_comm_info_sso2snscomminfo.uint32_seq.set(1234);
        sso2sns_0x3_blocklist$ReqBodyDelBlockList sso2sns_0x3_blocklist_reqbodydelblocklist = new sso2sns_0x3_blocklist$ReqBodyDelBlockList();
        sso2sns_0x3_blocklist_reqbodydelblocklist.uint64_uin.set(longValue);
        for (long j3 : shieldOperationItem.f195070h) {
            sso2sns_0x3_blocklist_reqbodydelblocklist.rpt_uint64_del_uin.add(Long.valueOf(j3));
        }
        sso2sns_0x3_blocklist$ReqBody sso2sns_0x3_blocklist_reqbody = new sso2sns_0x3_blocklist$ReqBody();
        sso2sns_0x3_blocklist_reqbody.msg_body_del_blocklist.set(sso2sns_0x3_blocklist_reqbodydelblocklist);
        byte[] E2 = E2(sso2sns_comm_info_sso2snscomminfo, sso2sns_0x3_blocklist_reqbody);
        createToServiceMsg.extraData.putInt("opType", shieldOperationItem.f195067d);
        createToServiceMsg.extraData.putInt("source_id", shieldOperationItem.f195068e);
        createToServiceMsg.extraData.putInt("source_sub_id", shieldOperationItem.f195069f);
        createToServiceMsg.extraData.putLongArray(SquareJSConst.Params.PARAMS_UIN_LIST, shieldOperationItem.f195070h);
        createToServiceMsg.extraData.putInt(IProfileCardConst.KEY_FROM_TYPE, shieldOperationItem.f195071i);
        createToServiceMsg.setTimeout(60000L);
        createToServiceMsg.putWupBuffer(E2);
        sendPbReq(createToServiceMsg);
    }

    private void Z2(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_get><S> : sendGetShieldListReqInternal : queue size:" + this.f195061d.size());
        }
        Long valueOf = Long.valueOf(this.M.getCurrentAccountUin());
        int I2 = I2();
        ToServiceMsg createToServiceMsg = createToServiceMsg("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList");
        sso2sns_comm_info$Sso2SnsCommInfo sso2sns_comm_info_sso2snscomminfo = new sso2sns_comm_info$Sso2SnsCommInfo();
        sso2sns_comm_info_sso2snscomminfo.uint32_seq.set(1234);
        sso2sns_0x3_blocklist$ReqBodyGetBlockList sso2sns_0x3_blocklist_reqbodygetblocklist = new sso2sns_0x3_blocklist$ReqBodyGetBlockList();
        sso2sns_0x3_blocklist_reqbodygetblocklist.uint64_uin.set(valueOf.longValue());
        sso2sns_0x3_blocklist_reqbodygetblocklist.uint32_get_type.set(i3);
        sso2sns_0x3_blocklist_reqbodygetblocklist.uint32_start_pos.set(i16);
        sso2sns_0x3_blocklist_reqbodygetblocklist.uint32_want_num.set(1000);
        sso2sns_0x3_blocklist_reqbodygetblocklist.fixed32_last_get_time.set(I2);
        sso2sns_0x3_blocklist$ReqBody sso2sns_0x3_blocklist_reqbody = new sso2sns_0x3_blocklist$ReqBody();
        sso2sns_0x3_blocklist_reqbody.msg_body_get_blocklist.set(sso2sns_0x3_blocklist_reqbodygetblocklist);
        byte[] E2 = E2(sso2sns_comm_info_sso2snscomminfo, sso2sns_0x3_blocklist_reqbody);
        createToServiceMsg.setTimeout(60000L);
        createToServiceMsg.putWupBuffer(E2);
        sendPbReq(createToServiceMsg);
    }

    private void a3(int i3) {
        this.f195063f = i3;
        if (this.M.getCurrentAccountUin() != null) {
            SharedPreferences.Editor edit = this.M.getApp().getSharedPreferences(this.M.getCurrentAccountUin(), 0).edit();
            edit.putInt(AppConstants.Preferences.LAST_GET_SHIELD_LIST_TIME, i3);
            edit.commit();
            if (QLog.isColorLevel()) {
                QLog.d("ShieldListHandler", 2, "setLastGetShieldListTime lastTime = " + i3);
            }
        }
    }

    private void handleError(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (serviceCmd != null && serviceCmd.length() != 0) {
            if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(serviceCmd)) {
                O2(toServiceMsg, fromServiceMsg);
            } else if ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(serviceCmd)) {
                K2(toServiceMsg, fromServiceMsg);
            } else if ("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(serviceCmd)) {
                M2(toServiceMsg, fromServiceMsg);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Q2(String str, int i3) {
        long longValue;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        long[] jArr = new long[1];
        if (i3 == 1006) {
            String m06 = com.tencent.mobileqq.utils.ac.m0(this.M, str);
            if (m06 != null && m06.length() > 0) {
                longValue = Long.valueOf(m06).longValue();
            } else {
                longValue = -1;
                z16 = false;
                if (QLog.isColorLevel()) {
                    QLog.d("ShieldListHandler", 2, "<---handleSendMsgErrorWhileShield : msgType:" + i3 + Arrays.toString(jArr) + ",hasUin:" + z16);
                }
                if (!z16) {
                    jArr[0] = longValue;
                    ShieldListInfo shieldListInfo = new ShieldListInfo();
                    shieldListInfo.uin = String.valueOf(longValue);
                    shieldListInfo.source_id = ShieldListInfo.AIO_TYPE_2_SOURCE_ID(i3);
                    shieldListInfo.source_sub_id = 0;
                    shieldListInfo.flags = 1;
                    arrayList.add(shieldListInfo);
                    ((ShieldMsgManger) this.M.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).i(arrayList);
                    S2(true, shieldListInfo.source_id, jArr);
                    return;
                }
                return;
            }
        } else {
            longValue = Long.valueOf(str).longValue();
        }
        z16 = true;
        if (QLog.isColorLevel()) {
        }
        if (!z16) {
        }
    }

    public void U2(int i3, long[] jArr, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), jArr, Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_add><S> : msgType " + i3 + ",uinList:" + Arrays.toString(jArr));
        }
        if (jArr.length <= 0) {
            return;
        }
        ShieldOperationItem shieldOperationItem = new ShieldOperationItem();
        shieldOperationItem.f195067d = 2;
        int AIO_TYPE_2_SOURCE_ID = ShieldListInfo.AIO_TYPE_2_SOURCE_ID(i3);
        shieldOperationItem.f195068e = AIO_TYPE_2_SOURCE_ID;
        shieldOperationItem.f195070h = jArr;
        shieldOperationItem.f195071i = i16;
        if (AIO_TYPE_2_SOURCE_ID != -1) {
            D2(shieldOperationItem);
        }
    }

    public void W2(int i3, long[] jArr, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), jArr, Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_del><S> : msgType:" + i3 + ",uinList:" + Arrays.toString(jArr));
        }
        if (jArr != null && jArr.length > 0) {
            ShieldOperationItem shieldOperationItem = new ShieldOperationItem();
            shieldOperationItem.f195067d = 3;
            int AIO_TYPE_2_SOURCE_ID = ShieldListInfo.AIO_TYPE_2_SOURCE_ID(i3);
            shieldOperationItem.f195068e = AIO_TYPE_2_SOURCE_ID;
            shieldOperationItem.f195070h = jArr;
            shieldOperationItem.f195071i = i16;
            if (AIO_TYPE_2_SOURCE_ID != -1) {
                D2(shieldOperationItem);
            }
        }
    }

    public void Y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<shield_get><S> : sendGetShieldListReq");
        }
        ShieldOperationItem shieldOperationItem = new ShieldOperationItem();
        shieldOperationItem.f195067d = 1;
        shieldOperationItem.f195070h = null;
        D2(shieldOperationItem);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Class) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return cy.class;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean F2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (serviceCmd != null && serviceCmd.length() != 0) {
            if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(serviceCmd) || "SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(serviceCmd) || "SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(serviceCmd)) {
                if (fromServiceMsg.getResultCode() == 1000) {
                    try {
                        F2 = F2(toServiceMsg, fromServiceMsg, obj);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: exception.", e16);
                        }
                    }
                    if (F2) {
                        T2();
                        return;
                    }
                    return;
                }
                if (fromServiceMsg.getResultCode() != 1002 && fromServiceMsg.getResultCode() != 1013) {
                    handleError(toServiceMsg, fromServiceMsg);
                } else {
                    R2(toServiceMsg, fromServiceMsg);
                }
                F2 = false;
                if (F2) {
                }
            }
        }
    }
}
