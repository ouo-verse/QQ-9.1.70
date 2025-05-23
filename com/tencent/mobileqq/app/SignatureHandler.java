package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.pb.signature.SigActPb$RspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x792.oidb_0x792$ReqBody;
import tencent.im.oidb.cmd0x792.oidb_0x792$RspBody;
import tencent.im.oidb.cmd0x793.oidb_0x793$ReqBody;
import tencent.im.oidb.cmd0x793.oidb_0x793$RspBody;
import tencent.im.oidb.cmd0x793.oidb_0x793$UinListInfo;
import tencent.im.oidb.cmd0x795.oidb_0x795$ReqBody;
import tencent.im.oidb.cmd0x795.oidb_0x795$RspBody;
import tencent.im.oidb.cmd0x796.oidb_0x796$ItemInfo;
import tencent.im.oidb.cmd0x796.oidb_0x796$ReqBody;
import tencent.im.oidb.cmd0x796.oidb_0x796$RspBody;
import tencent.im.oidb.cmd0x798.oidb_0x798$Info;
import tencent.im.oidb.cmd0x798.oidb_0x798$RspBody;
import tencent.im.oidb.cmd0x799.oidb_0x799$LongNickInfo;
import tencent.im.oidb.cmd0x799.oidb_0x799$ReqBody;
import tencent.im.oidb.cmd0x799.oidb_0x799$RspBody;
import tencent.im.oidb.oidb_0xd9e.oidb_0xd9e$ReqBody;
import tencent.im.oidb.oidb_0xd9e.oidb_0xd9e$RspBody;
import tencent.im.oidb.oidb_0xd9e.oidb_0xd9e$UserTopicItem;
import tencent.im.oidb.oidb_0xda6.oidb_0xda6$RspBody;
import tencent.im.oidb.oidb_0xda6.oidb_0xda6$UserTopicItem;
import tencent.im.oidb.oidb_0xdd6.oidb_0xdd6$ReqBody;
import tencent.im.oidb.oidb_0xdd6.oidb_0xdd6$RspBody;
import tencent.im.oidb.oidb_0xde5.oidb_0xde5$ReqBody;
import tencent.im.oidb.oidb_0xde5.oidb_0xde5$RspBody;
import tencent.im.oidb.oidb_0xde7.oidb_0xde7$ReqBody;
import tencent.im.oidb.oidb_0xde7.oidb_0xde7$RspBody;
import tencent.im.oidb.oidb_0xde8.oidb_0xde8$CommentItem;
import tencent.im.oidb.oidb_0xde8.oidb_0xde8$NickInfo;
import tencent.im.oidb.oidb_0xde8.oidb_0xde8$ReqBody;
import tencent.im.oidb.oidb_0xde8.oidb_0xde8$RspBody;
import tencent.im.oidb.oidb_0xde8.oidb_0xde8$lightCommentInfo;
import tencent.im.oidb.oidb_0xde8.oidb_0xde8$lightCommentItem;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SignatureHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f195072d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f195073e;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class RspGetHistorySig implements Serializable {
        static IPatchRedirector $redirector_;
        public List<HistorySignItem> historySignItems;
        public boolean over;
        public int resultFieldNumber;

        public RspGetHistorySig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.over = false;
            this.resultFieldNumber = 0;
            this.historySignItems = new ArrayList();
        }
    }

    protected SignatureHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195072d = 0;
            this.f195073e = qQAppInterface;
        }
    }

    private boolean O2(String[] strArr, byte[] bArr) {
        if (strArr == null || strArr.length == 0 || bArr == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(ByteStringMicro.copyFrom(str.getBytes()));
        }
        oidb_0x799$ReqBody oidb_0x799_reqbody = new oidb_0x799$ReqBody();
        oidb_0x799_reqbody.StrTopicIdList.set(arrayList);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1945);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x799_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(this.f195073e.getApp(), db.class);
        if (bArr != null) {
            newIntent.putExtra("reqData", bArr);
        }
        newIntent.putExtra("cmd", "OidbSvc.0x799_0");
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.putExtra("timeout", 10000L);
        this.f195073e.startServlet(newIntent);
        return true;
    }

    private void Q2(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws Exception {
        if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
            oidb_0xde5$RspBody oidb_0xde5_rspbody = new oidb_0xde5$RspBody();
            oidb_0xde5_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            notifyUI(11, true, Long.valueOf(oidb_0xde5_rspbody.uint64_comment_id.get()));
            return;
        }
        notifyUI(11, false, -1L);
    }

    private void R2(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws Exception {
        if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
            new MessageMicro<oidb_0xde7$RspBody>() { // from class: tencent.im.oidb.oidb_0xde7.oidb_0xde7$RspBody
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xde7$RspBody.class);
            }.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            notifyUI(12, true, 0);
        } else {
            notifyUI(12, false, -1);
        }
    }

    private void S2(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) throws Exception {
        SigActPb$RspBody sigActPb$RspBody = new SigActPb$RspBody();
        sigActPb$RspBody.mergeFrom(bArr);
        if (sigActPb$RspBody.ret.get() == 0) {
            notifyUI(7, true, Integer.valueOf(sigActPb$RspBody.rsp.get().rank.get()));
        } else {
            notifyUI(7, false, Integer.valueOf(sigActPb$RspBody.ret.get()));
        }
    }

    private void T2(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws Exception {
        boolean z16;
        RspGetHistorySig rspGetHistorySig = new RspGetHistorySig();
        if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
            oidb_0xde8$RspBody oidb_0xde8_rspbody = new oidb_0xde8$RspBody();
            oidb_0xde8_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            if (oidb_0xde8_rspbody.uint32_is_over.get() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            rspGetHistorySig.over = z16;
            rspGetHistorySig.resultFieldNumber = 0;
            rspGetHistorySig.historySignItems = I2(oidb_0xde8_rspbody.rpt_info.get());
            notifyUI(13, true, rspGetHistorySig);
            return;
        }
        rspGetHistorySig.resultFieldNumber = oidb_sso_oidbssopkg.uint32_result.get();
        notifyUI(13, false, rspGetHistorySig);
    }

    private void V2(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws Exception {
        boolean z16;
        RichStatus k3;
        if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
            oidb_0x793$RspBody oidb_0x793_rspbody = new oidb_0x793$RspBody();
            byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
            oidb_0x793_rspbody.mergeFrom(byteArray);
            try {
                if (oidb_0x793_rspbody.uint32_result.get() == 0) {
                    SignatureManager signatureManager = (SignatureManager) this.f195073e.getManager(QQManagerFactory.SIGNATURE_MANAGER);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    SignatureManager.SigCommentInfo sigCommentInfo = null;
                    for (oidb_0x793$UinListInfo oidb_0x793_uinlistinfo : oidb_0x793_rspbody.rpt_uinlist.get()) {
                        SignatureManager.SigCommentInfo sigCommentInfo2 = new SignatureManager.SigCommentInfo();
                        sigCommentInfo2.feedsid = new String(oidb_0x793_uinlistinfo.feedsid.get().toByteArray());
                        sigCommentInfo2.type = oidb_0x793_uinlistinfo.uint32_type.get();
                        sigCommentInfo2.time = oidb_0x793_uinlistinfo.uint64_time.get();
                        sigCommentInfo2.uin = oidb_0x793_uinlistinfo.uint64_uin.get();
                        if (signatureManager != null && (k3 = signatureManager.k(sigCommentInfo2.feedsid)) != null) {
                            sigCommentInfo2.f195083rs = k3;
                            arrayList2.add(sigCommentInfo2);
                        } else {
                            arrayList.add(sigCommentInfo2.feedsid);
                        }
                        sigCommentInfo = sigCommentInfo2;
                    }
                    int i3 = oidb_0x793_rspbody.uint32_flag.get();
                    if (i3 == 0 && sigCommentInfo != null) {
                        this.f195073e.getPreferences().edit().putLong("sigNewCommentLastUin_", sigCommentInfo.uin).putLong("sigNewCommentLastFetchTime", sigCommentInfo.time).putString("sigNewCommentLastFeedsId_", sigCommentInfo.feedsid).commit();
                    }
                    if (arrayList.size() > 0) {
                        if (!O2((String[]) arrayList.toArray(new String[arrayList.size()]), byteArray)) {
                            notifyUI(6, false, -1000);
                            return;
                        }
                        return;
                    }
                    SignatureManager.SigComments sigComments = new SignatureManager.SigComments();
                    if (i3 == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sigComments.isOver = z16;
                    sigComments.mlist = arrayList2;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("data", sigComments);
                    notifyUI(6, true, bundle);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SignatureHandler", 2, "handleGetNewComment fail ret=" + oidb_0x793_rspbody.uint32_result.get() + ",msg=" + oidb_0x793_rspbody.errMsg.get());
                }
                notifyUI(6, false, Integer.valueOf(oidb_0x793_rspbody.uint32_result.get()));
                return;
            } catch (Exception e16) {
                notifyUI(6, false, -1);
                if (QLog.isColorLevel()) {
                    QLog.d("SignatureHandler", 2, "handleGetNewComment fail retcode=" + oidb_0x793_rspbody.uint32_result.get() + ",msg=" + e16.getMessage());
                    return;
                }
                return;
            }
        }
        notifyUI(6, false, Integer.valueOf(oidb_sso_oidbssopkg.uint32_result.get()));
    }

    private void W2(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws Exception {
        oidb_0x792$RspBody oidb_0x792_rspbody = new oidb_0x792$RspBody();
        byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
        if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
            oidb_0x792_rspbody.mergeFrom(byteArray);
            if (oidb_0x792_rspbody.uint32_result.get() == 0) {
                int i3 = oidb_0x792_rspbody.uint32_newnum.get();
                int i16 = oidb_0x792_rspbody.uint32_sleeptime.get();
                long j3 = oidb_0x792_rspbody.uint64_lastuin.get();
                this.f195073e.getPreferences().edit().putLong("sigNewCommentLastFetchTime", System.currentTimeMillis() + (i16 * 1000));
                if (i3 != 0 && 0 != j3) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("unReadNum", i3);
                    bundle.putLong("lastUin", j3);
                    notifyUI(5, true, bundle);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SignatureHandler", 2, "handleGetNewCommentNum fial retcode:" + oidb_0x792_rspbody.uint32_result.get());
            }
        }
    }

    private void X2(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws Exception {
        if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
            oidb_0xd9e$RspBody oidb_0xd9e_rspbody = new oidb_0xd9e$RspBody();
            oidb_0xd9e_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            List<oidb_0xd9e$UserTopicItem> arrayList = new ArrayList<>();
            if (oidb_0xd9e_rspbody.rpt_topic_item.get() != null) {
                arrayList = oidb_0xd9e_rspbody.rpt_topic_item.get();
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                SignatureManager.TopicInfo topicInfo = new SignatureManager.TopicInfo();
                topicInfo.topicId = arrayList.get(i3).uint32_topic_id.get();
                topicInfo.topicStr = arrayList.get(i3).str_topic.get();
                topicInfo.totalNum = arrayList.get(i3).uint32_total_num.get();
                topicInfo.friendNum = arrayList.get(i3).uint32_frd_num.get();
                arrayList2.add(topicInfo);
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("param_topicInfoList", arrayList2);
            bundle.putInt("param_searchResult", oidb_sso_oidbssopkg.uint32_result.get());
            notifyUI(8, true, bundle);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("param_topicInfoList", null);
        bundle2.putInt("param_searchResult", oidb_sso_oidbssopkg.uint32_result.get());
        notifyUI(8, false, bundle2);
    }

    private void Y2(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws Exception {
        RichStatus k3;
        boolean z16 = false;
        if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
            oidb_0x799$RspBody oidb_0x799_rspbody = new oidb_0x799$RspBody();
            oidb_0x799_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            if (oidb_0x799_rspbody.uint32_result.get() == 0) {
                List<oidb_0x799$LongNickInfo> list = oidb_0x799_rspbody.astLongNickInfoList.get();
                ArrayList arrayList = new ArrayList(list.size());
                for (oidb_0x799$LongNickInfo oidb_0x799_longnickinfo : list) {
                    byte[] byteArray = oidb_0x799_longnickinfo.StrNick.get().toByteArray();
                    String str = new String(oidb_0x799_longnickinfo.StrTopicId.get().toByteArray());
                    RichStatus parseStatus = RichStatus.parseStatus(byteArray);
                    parseStatus.feedsId = str;
                    arrayList.add(parseStatus);
                }
                SignatureManager signatureManager = (SignatureManager) this.f195073e.getManager(QQManagerFactory.SIGNATURE_MANAGER);
                if (signatureManager != null) {
                    signatureManager.t(arrayList);
                }
                byte[] byteArrayExtra = intent.getByteArrayExtra("reqData");
                oidb_0x793$RspBody oidb_0x793_rspbody = new oidb_0x793$RspBody();
                oidb_0x793_rspbody.mergeFrom(byteArrayExtra);
                ArrayList arrayList2 = new ArrayList(oidb_0x793_rspbody.rpt_uinlist.size());
                for (oidb_0x793$UinListInfo oidb_0x793_uinlistinfo : oidb_0x793_rspbody.rpt_uinlist.get()) {
                    SignatureManager.SigCommentInfo sigCommentInfo = new SignatureManager.SigCommentInfo();
                    sigCommentInfo.feedsid = new String(oidb_0x793_uinlistinfo.feedsid.get().toByteArray());
                    sigCommentInfo.type = oidb_0x793_uinlistinfo.uint32_type.get();
                    sigCommentInfo.time = oidb_0x793_uinlistinfo.uint64_time.get();
                    sigCommentInfo.uin = oidb_0x793_uinlistinfo.uint64_uin.get();
                    if (signatureManager != null && (k3 = signatureManager.k(sigCommentInfo.feedsid)) != null) {
                        sigCommentInfo.f195083rs = k3;
                        arrayList2.add(sigCommentInfo);
                    }
                }
                int i3 = oidb_0x793_rspbody.uint32_flag.get();
                SignatureManager.SigComments sigComments = new SignatureManager.SigComments();
                if (i3 == 1) {
                    z16 = true;
                }
                sigComments.isOver = z16;
                sigComments.mlist = arrayList2;
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", sigComments);
                notifyUI(6, true, bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SignatureHandler", 2, "handleGetRichStatusByFeedsId fail ret=" + oidb_0x799_rspbody.uint32_result.get());
            }
            notifyUI(6, false, Integer.valueOf(oidb_0x799_rspbody.uint32_result.get()));
            return;
        }
        notifyUI(6, false, Integer.valueOf(oidb_sso_oidbssopkg.uint32_result.get()));
    }

    private void Z2(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws Exception {
        oidb_0x796$RspBody oidb_0x796_rspbody = new oidb_0x796$RspBody();
        oidb_0x796_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
        String stringExtra = intent.getStringExtra("feedid");
        boolean booleanExtra = intent.getBooleanExtra("firstFlag", true);
        int i3 = oidb_0x796_rspbody.uint32_result.get();
        boolean z16 = false;
        if (i3 == 0) {
            if (oidb_0x796_rspbody.uint32_flag.get() == 0) {
                z16 = true;
            }
            oidb_0x796_rspbody.uint32_rsp_seq.get();
            oidb_0x796_rspbody.uint32_need_update.get();
            oidb_0x796$ItemInfo oidb_0x796_iteminfo = oidb_0x796_rspbody.stPagePointItem.get();
            if (!z16) {
                this.f195073e.getPreferences().edit().putLong("sigCommentDetailUin_" + stringExtra, oidb_0x796_iteminfo.uint64_uin.get()).putLong("sigCommentDetailTime_" + stringExtra, oidb_0x796_iteminfo.uint64_time.get()).commit();
            }
            PBRepeatMessageField<oidb_0x796$ItemInfo> pBRepeatMessageField = oidb_0x796_rspbody.rpt_items;
            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>(oidb_0x796_rspbody.rpt_items.get().size());
                Iterator<oidb_0x796$ItemInfo> it = oidb_0x796_rspbody.rpt_items.get().iterator();
                while (it.hasNext()) {
                    String str = it.next().uint64_uin.get() + "";
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString("feedid", stringExtra);
                bundle.putBoolean("overFlag", z16);
                bundle.putBoolean("firstFlag", booleanExtra);
                bundle.putStringArrayList("uins", arrayList);
                if (QLog.isColorLevel()) {
                    QLog.d("SignatureHandler", 2, "oidb796cmd feedid=" + stringExtra + ", firstFlag=" + booleanExtra + ", overFlag=" + z16 + ",num:" + arrayList.size());
                }
                notifyUI(3, true, bundle);
                return;
            }
            return;
        }
        notifyUI(3, false, Integer.valueOf(i3));
    }

    private void a3(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws Exception {
        RichStatus richStatus;
        oidb_0x798$RspBody oidb_0x798_rspbody = new oidb_0x798$RspBody();
        oidb_0x798_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
        int i3 = oidb_0x798_rspbody.uint32_result.get();
        if (i3 == 0) {
            if (oidb_0x798_rspbody.stInfos.has() && oidb_0x798_rspbody.stInfos.get().size() > 0) {
                String stringExtra = intent.getStringExtra("uin");
                String stringExtra2 = intent.getStringExtra("feedsid");
                ExtensionInfo H = ((FriendsManager) this.f195073e.getManager(QQManagerFactory.FRIENDS_MANAGER)).H(stringExtra);
                if (H != null) {
                    richStatus = com.tencent.mobileqq.richstatus.c.e(H);
                    if (richStatus == null) {
                        return;
                    }
                } else {
                    richStatus = null;
                }
                if (richStatus != null && !TextUtils.isEmpty(richStatus.feedsId) && richStatus.feedsId.equals(stringExtra2) && richStatus.sigZanInfo == null) {
                    richStatus.sigZanInfo = new HashMap<>(oidb_0x798_rspbody.stInfos.get().size());
                }
                List<oidb_0x798$Info> list = oidb_0x798_rspbody.stInfos.get();
                for (int i16 = 0; i16 < list.size(); i16++) {
                    RichStatus.b bVar = new RichStatus.b();
                    oidb_0x798$Info oidb_0x798_info = list.get(i16);
                    bVar.f282154a = stringExtra2;
                    bVar.f282156c = oidb_0x798_info.uint32_count.get();
                    bVar.f282155b = oidb_0x798_info.uint32_type.get();
                    bVar.f282157d = oidb_0x798_info.uint32_flag.get();
                    if (richStatus != null) {
                        richStatus.sigZanInfo.put(Integer.valueOf(bVar.f282155b), bVar);
                    }
                }
                long currentTimeMillis = (oidb_0x798_rspbody.uint64_sleeptime.get() * 1000) + System.currentTimeMillis();
                this.f195073e.getPreferences().edit().putLong("sigCommentUpdateTimeStamp_" + stringExtra, currentTimeMillis).commit();
                if (richStatus != null && richStatus.sigZanInfo.get(255) != null) {
                    this.f195072d = 90;
                    notifyUI(90, true, richStatus.sigZanInfo.get(255));
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SignatureHandler", 2, "handleGetSigZanInfo fail ret=" + i3);
        }
    }

    private void c3(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws Exception {
        RichStatus.b bVar;
        HashMap<Integer, RichStatus.b> hashMap;
        oidb_0x795$RspBody oidb_0x795_rspbody = new oidb_0x795$RspBody();
        oidb_0x795_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
        String stringExtra = intent.getStringExtra("feedid");
        String stringExtra2 = intent.getStringExtra("uin");
        boolean z16 = false;
        int intExtra = intent.getIntExtra("action", 0);
        int intExtra2 = intent.getIntExtra("type", 0);
        ExtensionInfo H = ((FriendsManager) this.f195073e.getManager(QQManagerFactory.FRIENDS_MANAGER)).H(stringExtra2);
        this.f195072d = 90;
        RichStatus e16 = com.tencent.mobileqq.richstatus.c.e(H);
        if (H != null && stringExtra.equals(e16.feedsId) && (hashMap = e16.sigZanInfo) != null) {
            bVar = hashMap.get(255);
            if (oidb_0x795_rspbody.uint32_result.get() == 0) {
                if (1 == intExtra) {
                    bVar.f282156c++;
                    bVar.f282157d = 1;
                } else {
                    int i3 = bVar.f282156c - 1;
                    bVar.f282156c = i3;
                    if (i3 <= 0) {
                        i3 = 0;
                    }
                    bVar.f282156c = i3;
                    bVar.f282157d = 0;
                }
            }
        } else {
            bVar = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SignatureHandler", 2, String.format("handleInteractiveSigature[%s %s %d %d]", StringUtil.getSimpleUinForPrint(stringExtra2), stringExtra, Integer.valueOf(intExtra2), Integer.valueOf(intExtra)));
        }
        int i16 = this.f195072d;
        if (oidb_0x795_rspbody.uint32_result.get() == 0) {
            z16 = true;
        }
        notifyUI(i16, z16, bVar);
    }

    public void D2(long j3, String str, long j16, long j17, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(j3), str, Long.valueOf(j16), Long.valueOf(j17), str2);
            return;
        }
        oidb_0xde5$ReqBody oidb_0xde5_reqbody = new oidb_0xde5$ReqBody();
        oidb_0xde5_reqbody.uint64_longnick_uin.set(j3);
        oidb_0xde5_reqbody.str_longnick_id.set(str);
        oidb_0xde5_reqbody.uint64_target_comment_id.set(j16);
        oidb_0xde5_reqbody.uint64_from_uin.set(j17);
        oidb_0xde5_reqbody.str_comment.set(str2);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3557);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xde5_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(this.f195073e.getApp(), db.class);
        newIntent.putExtra("cmd", "OidbSvc.0xde5_1");
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.putExtra("timeout", 10000L);
        this.f195073e.startServlet(newIntent);
    }

    public void E2(long j3, String str, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), str, Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        oidb_0xde7$ReqBody oidb_0xde7_reqbody = new oidb_0xde7$ReqBody();
        oidb_0xde7_reqbody.uint64_longnick_uin.set(j3);
        oidb_0xde7_reqbody.str_longnick_id.set(str);
        oidb_0xde7_reqbody.uint64_comment_id.set(j17);
        oidb_0xde7_reqbody.uint64_from_uin.set(j16);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3559);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xde7_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(this.f195073e.getApp(), db.class);
        newIntent.putExtra("cmd", "OidbSvc.0xde7_1");
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.putExtra("timeout", 10000L);
        this.f195073e.startServlet(newIntent);
    }

    public List<CommentItem> F2(List<oidb_0xde8$CommentItem> list, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (List) iPatchRedirector.redirect((short) 20, (Object) this, (Object) list, (Object) str);
        }
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (oidb_0xde8$CommentItem oidb_0xde8_commentitem : list) {
                CommentItem commentItem = new CommentItem();
                commentItem.feedId = str;
                commentItem.f282319id = oidb_0xde8_commentitem.uint64_comment_id.get();
                commentItem.targetId = oidb_0xde8_commentitem.uint64_target_comment_id.get();
                commentItem.timeStamp = oidb_0xde8_commentitem.uint64_time.get();
                commentItem.content = oidb_0xde8_commentitem.str_comment.get();
                long j3 = oidb_0xde8_commentitem.uint64_comment_uin.get();
                commentItem.user = new com.tencent.mobileqq.richstatus.comment.bean.b(String.valueOf(j3), K2(j3));
                if (commentItem.targetId != 0) {
                    long j16 = oidb_0xde8_commentitem.uint64_target_uin.get();
                    commentItem.toReplyUser = new com.tencent.mobileqq.richstatus.comment.bean.b(String.valueOf(j16), K2(j16));
                } else {
                    commentItem.toReplyUser = null;
                }
                arrayList.add(commentItem);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public void G2(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        oidb_0xde8$ReqBody oidb_0xde8_reqbody = new oidb_0xde8$ReqBody();
        oidb_0xde8_reqbody.uint64_to_uin.set(j3);
        oidb_0xde8_reqbody.uint32_check_fri_type.set(2);
        oidb_0xde8_reqbody.uint32_start_time.set(i3);
        oidb_0xde8_reqbody.uint32_end_time.set(i16);
        oidb_0xde8_reqbody.uint32_start.set(0);
        oidb_0xde8_reqbody.uint32_type.set(0);
        oidb_0xde8_reqbody.uint32_num.set(6);
        oidb_0xde8_reqbody.uint32_comment_size.set(60);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3560);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xde8_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(this.f195073e.getApp(), db.class);
        newIntent.putExtra("cmd", "OidbSvc.0xde8_1");
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.putExtra("timeout", 10000L);
        this.f195073e.startServlet(newIntent);
    }

    public void H2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
            return;
        }
        oidb_0xdd6$ReqBody oidb_0xdd6_reqbody = new oidb_0xdd6$ReqBody();
        oidb_0xdd6_reqbody.uint64_uin.set(j3);
        oidb_0xdd6_reqbody.uint64_start_time.set(0L);
        oidb_0xdd6_reqbody.uint64_end_time.set(NetConnInfoCenter.getServerTimeMillis() / 1000);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3542);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xdd6_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(this.f195073e.getApp(), db.class);
        newIntent.putExtra("cmd", "OidbSvc.0xdd6_1");
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.putExtra("timeout", 10000L);
        this.f195073e.startServlet(newIntent);
    }

    public List<HistorySignItem> I2(List<oidb_0xde8$NickInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (List) iPatchRedirector.redirect((short) 19, (Object) this, (Object) list);
        }
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (oidb_0xde8$NickInfo oidb_0xde8_nickinfo : list) {
                HistorySignItem historySignItem = new HistorySignItem();
                RichStatus parseStatus = RichStatus.parseStatus(oidb_0xde8_nickinfo.bytes_nick.get().toByteArray());
                historySignItem.richStatus = parseStatus;
                if (parseStatus != null) {
                    parseStatus.feedsId = new String(oidb_0xde8_nickinfo.bytes_feedid.get().toByteArray());
                    historySignItem.richStatus.time = oidb_0xde8_nickinfo.uint32_create_time.get();
                    if (oidb_0xde8_nickinfo.rpt_item.get() != null) {
                        historySignItem.commentItemList = F2(oidb_0xde8_nickinfo.rpt_item.get(), historySignItem.richStatus.feedsId);
                    }
                    oidb_0xde8$lightCommentInfo oidb_0xde8_lightcommentinfo = oidb_0xde8_nickinfo.msg_light_comment.get();
                    if (oidb_0xde8_lightcommentinfo != null) {
                        historySignItem.totalLikeNum = oidb_0xde8_lightcommentinfo.uint64_total_num.get();
                        historySignItem.likeItemList = J2(oidb_0xde8_lightcommentinfo.rpt_items.get());
                    }
                    arrayList.add(historySignItem);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public List<com.tencent.mobileqq.richstatus.comment.bean.a> J2(List<oidb_0xde8$lightCommentItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (List) iPatchRedirector.redirect((short) 21, (Object) this, (Object) list);
        }
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (oidb_0xde8$lightCommentItem oidb_0xde8_lightcommentitem : list) {
                com.tencent.mobileqq.richstatus.comment.bean.a aVar = new com.tencent.mobileqq.richstatus.comment.bean.a();
                aVar.f282320a = oidb_0xde8_lightcommentitem.uint64_time.get();
                long j3 = oidb_0xde8_lightcommentitem.uint64_uin.get();
                aVar.f282321b = new com.tencent.mobileqq.richstatus.comment.bean.b(String.valueOf(j3), K2(j3));
                arrayList.add(aVar);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public String K2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this, j3);
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        aVar.d(uidFromUin);
        String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
        if (TextUtils.isEmpty(nameWithConfig)) {
            return String.valueOf(j3);
        }
        return nameWithConfig;
    }

    public void L2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        Long l3 = 0L;
        Long l16 = 0L;
        String str = "0";
        if (!z16) {
            SharedPreferences preferences = this.f195073e.getPreferences();
            l3 = Long.valueOf(preferences.getLong("sigNewCommentLastUin_", 0L));
            l16 = Long.valueOf(preferences.getLong("sigNewCommentLastFetchTime", 0L));
            str = preferences.getString("sigNewCommentLastFeedsId_", "0");
        }
        oidb_0x793$ReqBody oidb_0x793_reqbody = new oidb_0x793$ReqBody();
        oidb_0x793_reqbody.feedsid.set(ByteStringMicro.copyFrom(str.getBytes()));
        oidb_0x793_reqbody.uint64_uin.set(l3.longValue());
        oidb_0x793_reqbody.uint64_time.set(l16.longValue());
        oidb_0x793_reqbody.uint32_getnum.set(100);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1939);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x793_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(this.f195073e.getApp(), db.class);
        newIntent.putExtra("feedsId", "OidbSvc.0x793_0");
        newIntent.putExtra("cmd", "OidbSvc.0x793_0");
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.putExtra("timeout", 10000L);
        this.f195073e.startServlet(newIntent);
    }

    public void M2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (System.currentTimeMillis() < Long.valueOf(this.f195073e.getPreferences().getLong("sigNewCommentLastFetchTime", 0L)).longValue()) {
            if (QLog.isColorLevel()) {
                QLog.d("SignatureHandler", 2, "getNewCommentNum freq limit");
                return;
            }
            return;
        }
        oidb_0x792$ReqBody oidb_0x792_reqbody = new oidb_0x792$ReqBody();
        oidb_0x792_reqbody.uint64_uin.set(Long.valueOf(this.f195073e.getAccount()).longValue());
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1938);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x792_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(this.f195073e.getApp(), db.class);
        newIntent.putExtra("cmd", "OidbSvc.0x792_0");
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.putExtra("timeout", 30000L);
        this.f195073e.startServlet(newIntent);
    }

    public void N2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        MessageMicro<oidb_0xd9e$ReqBody> messageMicro = new MessageMicro<oidb_0xd9e$ReqBody>() { // from class: tencent.im.oidb.oidb_0xd9e.oidb_0xd9e$ReqBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xd9e$ReqBody.class);
        };
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3486);
        oidb_sso_oidbssopkg.uint32_service_type.set(3);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(messageMicro.toByteArray()));
        NewIntent newIntent = new NewIntent(this.f195073e.getApp(), db.class);
        newIntent.putExtra("cmd", "OidbSvc.0xd9e_3");
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.putExtra("timeout", 10000L);
        this.f195073e.startServlet(newIntent);
    }

    public void P2(String str, String str2, int i3, boolean z16) {
        ExtensionInfo H;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (H = ((FriendsManager) this.f195073e.getManager(QQManagerFactory.FRIENDS_MANAGER)).H(str)) == null) {
            return;
        }
        RichStatus e16 = com.tencent.mobileqq.richstatus.c.e(H);
        oidb_0x796$ReqBody oidb_0x796_reqbody = new oidb_0x796$ReqBody();
        oidb_0x796_reqbody.feedsid.set(ByteStringMicro.copyFrom(str2.getBytes()));
        oidb_0x796_reqbody.uint64_time.set(e16.time);
        oidb_0x796_reqbody.uint64_uin.set(Long.valueOf(str).longValue());
        oidb_0x796_reqbody.uint32_type.set(i3);
        Long l3 = 0L;
        Long l16 = 0L;
        if (!z16) {
            SharedPreferences preferences = this.f195073e.getPreferences();
            Long valueOf = Long.valueOf(preferences.getLong("sigCommentDetailUin_" + str2, 0L));
            l16 = Long.valueOf(preferences.getLong("sigCommentDetailTime_" + str2, 0L));
            l3 = valueOf;
        }
        oidb_0x796$ItemInfo oidb_0x796_iteminfo = new oidb_0x796$ItemInfo();
        oidb_0x796_iteminfo.uint64_time.set(l16.longValue());
        oidb_0x796_iteminfo.uint64_uin.set(l3.longValue());
        oidb_0x796_reqbody.stLastInfo.set(oidb_0x796_iteminfo);
        oidb_0x796_reqbody.uint32_seq.set(0);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1942);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x796_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(this.f195073e.getApp(), db.class);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("feedid", str2);
        newIntent.putExtra("firstFlag", z16);
        newIntent.putExtra("cmd", "OidbSvc.0x796_0");
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.putExtra("timeout", 10000L);
        this.f195073e.startServlet(newIntent);
    }

    public void U2(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) intent, (Object) oidb_sso_oidbssopkg);
        } else {
            if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                oidb_0xdd6$RspBody oidb_0xdd6_rspbody = new oidb_0xdd6$RspBody();
                oidb_0xdd6_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                notifyUI(10, true, Integer.valueOf(oidb_0xdd6_rspbody.uint32_num.get()));
                return;
            }
            notifyUI(10, false, -1);
        }
    }

    public void b3(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) intent, (Object) oidb_sso_oidbssopkg);
            return;
        }
        if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
            oidb_0xda6$RspBody oidb_0xda6_rspbody = new oidb_0xda6$RspBody();
            oidb_0xda6_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            List<oidb_0xda6$UserTopicItem> arrayList = new ArrayList<>();
            if (oidb_0xda6_rspbody.rpt_topic_item.get() != null) {
                arrayList = oidb_0xda6_rspbody.rpt_topic_item.get();
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                SignatureManager.TopicInfo topicInfo = new SignatureManager.TopicInfo();
                topicInfo.topicId = arrayList.get(i3).uint32_topic_id.get();
                topicInfo.topicStr = arrayList.get(i3).str_topic.get();
                topicInfo.totalNum = arrayList.get(i3).uint32_total_num.get();
                topicInfo.friendNum = arrayList.get(i3).uint32_frd_num.get();
                arrayList2.add(topicInfo);
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("param_topicInfoList", arrayList2);
            int intExtra = intent.getIntExtra("param_atIndex", 0);
            int intExtra2 = intent.getIntExtra("param_atKeyLen", 0);
            String stringExtra = intent.getStringExtra("param_atKey");
            long longExtra = intent.getLongExtra("param_reqTs", 0L);
            bundle.putInt("param_atIndex", intExtra);
            bundle.putInt("param_atKeyLen", intExtra2);
            bundle.putString("param_atKey", stringExtra);
            bundle.putLong("param_reqTs", longExtra);
            notifyUI(9, true, bundle);
            return;
        }
        Bundle bundle2 = new Bundle();
        int intExtra3 = intent.getIntExtra("param_atIndex", 0);
        int intExtra4 = intent.getIntExtra("param_atKeyLen", 0);
        String stringExtra2 = intent.getStringExtra("param_atKey");
        long longExtra2 = intent.getLongExtra("param_reqTs", 0L);
        bundle2.putInt("param_atIndex", intExtra3);
        bundle2.putInt("param_atKeyLen", intExtra4);
        bundle2.putString("param_atKey", stringExtra2);
        bundle2.putLong("param_reqTs", longExtra2);
        bundle2.putInt("param_searchResult", oidb_sso_oidbssopkg.uint32_result.get());
        notifyUI(9, false, bundle2);
    }

    public void d3(String str, String str2, int i3, int i16) {
        ExtensionInfo H;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i("SignatureHandler", 1, String.format("InteractiveSignature[%s %s %d %d]", StringUtil.getSimpleUinForPrint(str), str2, Integer.valueOf(i3), Integer.valueOf(i16)));
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (H = ((FriendsManager) this.f195073e.getManager(QQManagerFactory.FRIENDS_MANAGER)).H(str)) == null) {
            return;
        }
        RichStatus e16 = com.tencent.mobileqq.richstatus.c.e(H);
        oidb_0x795$ReqBody oidb_0x795_reqbody = new oidb_0x795$ReqBody();
        oidb_0x795_reqbody.feedsid.set(ByteStringMicro.copyFrom(str2.getBytes()));
        oidb_0x795_reqbody.uint64_time.set(e16.time);
        oidb_0x795_reqbody.uint64_uin.set(Long.valueOf(str).longValue());
        oidb_0x795_reqbody.uint32_type.set(i3);
        oidb_0x795_reqbody.uint32_action.set(i16);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1941);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x795_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(this.f195073e.getApp(), db.class);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("feedid", str2);
        newIntent.putExtra("type", i3);
        newIntent.putExtra("action", i16);
        newIntent.putExtra("cmd", "OidbSvc.0x795_0");
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.putExtra("timeout", 10000L);
        this.f195073e.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f195072d == 90) {
            return ar.class;
        }
        return da.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
    }

    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, intent, fromServiceMsg, bArr);
            return;
        }
        String stringExtra = intent.getStringExtra("cmd");
        try {
            this.f195072d = 0;
            if ("Signature.act".equals(stringExtra)) {
                S2(intent, fromServiceMsg, bArr);
                return;
            }
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(bArr);
            int i3 = mergeFrom.uint32_result.get();
            int i16 = mergeFrom.uint32_command.get();
            if (i16 == 1938) {
                W2(intent, mergeFrom);
            } else if (i16 == 1939) {
                V2(intent, mergeFrom);
            } else if (i16 == 1941) {
                c3(intent, mergeFrom);
            } else if (i16 == 1942) {
                Z2(intent, mergeFrom);
            } else if (i16 == 1944) {
                a3(intent, mergeFrom);
            } else if (i16 == 1945) {
                Y2(intent, mergeFrom);
            } else if (i16 == 3486) {
                X2(intent, mergeFrom);
            } else if (i16 == 3494) {
                b3(intent, mergeFrom);
            } else if (i16 == 3542) {
                U2(intent, mergeFrom);
            } else if (i16 == 3557) {
                Q2(intent, mergeFrom);
            } else if (i16 == 3559) {
                R2(intent, mergeFrom);
            } else if (i16 == 3560) {
                T2(intent, mergeFrom);
            } else {
                throw new Exception("Unknow oidb cmd" + i16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("SignatureHandler", 2, "oidb_0x792|OIDBSSOPkg.result " + i3);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SignatureHandler", 2, "sign handler onRecive fail err:" + e16.getMessage());
            }
        }
    }
}
