package com.tencent.mobileqq.app;

import QQService.AddDiscussMemberInfo;
import QQService.DiscussRespHeader;
import QQService.InteRemarkInfo;
import QQService.RespAddDiscussMember;
import QQService.RespCreateDiscuss;
import QQService.RespGetDiscussInfo;
import QQService.RespGetDiscussInteRemark;
import QQService.RespJoinDiscuss;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.app.j;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.discussion.a;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.protofile.discuss.FlyTicket$DiscussGetUrlRequest;
import com.tencent.protofile.discuss.FlyTicket$DiscussGetUrlResponse;
import com.tencent.protofile.discuss.FlyTicket$DiscussSigDecodeRequest;
import com.tencent.protofile.discuss.FlyTicket$DiscussSigDecodeResponse;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x44c.cmd0x44c$ModifyConfInfoReq;
import tencent.im.oidb.cmd0x44c.cmd0x44c$ReqBody;
import tencent.im.oidb.cmd0x44c.cmd0x44c$RspBody;
import tencent.im.oidb.cmd0x58a.cmd0x58a$ConfBaseInfo;
import tencent.im.oidb.cmd0x58a.cmd0x58a$GetConfListRsp;
import tencent.im.oidb.cmd0x58a.cmd0x58a$ReqBody;
import tencent.im.oidb.cmd0x58a.cmd0x58a$RspBody;
import tencent.im.oidb.cmd0x58b.cmd0x58b$ConfBaseInfo;
import tencent.im.oidb.cmd0x58b.cmd0x58b$ConfMemberInfo;
import tencent.im.oidb.cmd0x58b.cmd0x58b$GetConfInfoRsp;
import tencent.im.oidb.cmd0x58b.cmd0x58b$GetMultiConfInfoReq;
import tencent.im.oidb.cmd0x58b.cmd0x58b$GetMultiConfInfoRsp;
import tencent.im.oidb.cmd0x58b.cmd0x58b$ReqBody;
import tencent.im.oidb.cmd0x58b.cmd0x58b$RspBody;
import tencent.im.oidb.cmd0x921.cmd0x921$GetAtAllRemain;
import tencent.im.oidb.cmd0x921.cmd0x921$ReqBody;
import tencent.im.oidb.cmd0x921.cmd0x921$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DiscussionHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;
    private ArrayList<Pair<Boolean, String>> C;
    private QQAppInterface D;

    /* renamed from: d, reason: collision with root package name */
    private LinkedHashMap<String, c> f194598d;

    /* renamed from: e, reason: collision with root package name */
    private FriendListHandler f194599e;

    /* renamed from: f, reason: collision with root package name */
    private GroupIconHelper f194600f;

    /* renamed from: h, reason: collision with root package name */
    private LinkedHashMap<String, c> f194601h;

    /* renamed from: i, reason: collision with root package name */
    private long f194602i;

    /* renamed from: m, reason: collision with root package name */
    private long f194603m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f194607a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f194608b;

        /* renamed from: c, reason: collision with root package name */
        private ArrayList<Object> f194609c;

        /* renamed from: d, reason: collision with root package name */
        private HashMap<String, c> f194610d;

        /* renamed from: e, reason: collision with root package name */
        private List<cmd0x58b$GetConfInfoRsp> f194611e;

        public a(byte[] bArr, ArrayList<Object> arrayList, HashMap<String, c> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DiscussionHandler.this, bArr, arrayList, hashMap);
                return;
            }
            this.f194608b = bArr;
            this.f194609c = arrayList;
            this.f194610d = hashMap;
        }

        boolean a() {
            return this.f194607a;
        }

        public List<cmd0x58b$GetConfInfoRsp> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f194611e;
        }

        public a c() {
            cmd0x58b$GetMultiConfInfoRsp cmd0x58b_getmulticonfinforsp;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(this.f194608b);
                if (mergeFrom.uint32_result.has() && mergeFrom.uint32_result.get() == 0 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    cmd0x58b$RspBody cmd0x58b_rspbody = new cmd0x58b$RspBody();
                    try {
                        cmd0x58b_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        if (cmd0x58b_rspbody.msg_cmd_error_code.uint32_code.get() != 0) {
                            DiscussionHandler.this.U2(this.f194610d.values());
                            DiscussionHandler.this.notifyUI(1001, false, this.f194609c);
                            this.f194607a = true;
                            return this;
                        }
                        List<cmd0x58b$GetConfInfoRsp> list = null;
                        if (cmd0x58b_rspbody.msg_get_multi_conf_info.has()) {
                            cmd0x58b_getmulticonfinforsp = cmd0x58b_rspbody.msg_get_multi_conf_info.get();
                        } else {
                            cmd0x58b_getmulticonfinforsp = null;
                        }
                        if (cmd0x58b_getmulticonfinforsp != null) {
                            if (cmd0x58b_getmulticonfinforsp.msg_get_conf_info.has()) {
                                list = cmd0x58b_getmulticonfinforsp.msg_get_conf_info.get();
                            }
                            this.f194611e = list;
                        } else {
                            this.f194611e = null;
                        }
                        this.f194607a = false;
                        return this;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("Q.contacttab.dscs", 2, "rspBody merge fail " + e16.toString());
                        }
                        DiscussionHandler.this.notifyUI(1001, false, this.f194609c);
                        this.f194607a = true;
                        return this;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.e("Q.contacttab.dscs", 2, "sso check fail " + mergeFrom.uint32_result.get());
                }
                DiscussionHandler.this.notifyUI(1001, false, this.f194609c);
                this.f194607a = true;
                return this;
            } catch (InvalidProtocolBufferMicroException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.contacttab.dscs", 2, "merge fail " + e17.toString());
                }
                DiscussionHandler.this.notifyUI(1001, false, this.f194609c);
                this.f194607a = true;
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f194613a;

        /* renamed from: b, reason: collision with root package name */
        private oidb_sso$OIDBSSOPkg f194614b;

        /* renamed from: c, reason: collision with root package name */
        private List<cmd0x58a$ConfBaseInfo> f194615c;

        /* renamed from: d, reason: collision with root package name */
        private List<Long> f194616d;

        public b(oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionHandler.this, (Object) oidb_sso_oidbssopkg);
            } else {
                this.f194614b = oidb_sso_oidbssopkg;
            }
        }

        public List<Long> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f194616d;
        }

        public List<cmd0x58a$ConfBaseInfo> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f194615c;
        }

        public b c() {
            int i3;
            cmd0x58a$GetConfListRsp cmd0x58a_getconflistrsp;
            List<cmd0x58a$ConfBaseInfo> list;
            List<Long> list2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = this.f194614b;
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has() && this.f194614b.uint32_result.get() == 0 && this.f194614b.bytes_bodybuffer.has() && this.f194614b.bytes_bodybuffer.get() != null) {
                cmd0x58a$RspBody cmd0x58a_rspbody = new cmd0x58a$RspBody();
                try {
                    cmd0x58a_rspbody.mergeFrom(this.f194614b.bytes_bodybuffer.get().toByteArray());
                    if (cmd0x58a_rspbody.msg_get_conf_list.has()) {
                        cmd0x58a_getconflistrsp = cmd0x58a_rspbody.msg_get_conf_list.get();
                    } else {
                        cmd0x58a_getconflistrsp = null;
                    }
                    if (cmd0x58a_getconflistrsp == null) {
                        if (QLog.isColorLevel()) {
                            QLog.e("Q.contacttab.dscs", 2, "getConfInfoRsp is null");
                        }
                        DiscussionHandler.this.notifyUI(1000, true, null);
                        this.f194613a = true;
                        return this;
                    }
                    if (cmd0x58a_getconflistrsp.rpt_msg_conf_base_info.has()) {
                        list = cmd0x58a_getconflistrsp.rpt_msg_conf_base_info.get();
                    } else {
                        list = null;
                    }
                    this.f194615c = list;
                    if (cmd0x58a_getconflistrsp.rpt_uint64_other_conf_list.has()) {
                        list2 = cmd0x58a_getconflistrsp.rpt_uint64_other_conf_list.get();
                    } else {
                        list2 = null;
                    }
                    this.f194616d = list2;
                    if (this.f194615c == null) {
                        if (QLog.isColorLevel()) {
                            QLog.e("Q.contacttab.dscs", 2, "baseInfo is null");
                        }
                        DiscussionHandler.this.notifyUI(1000, false, null);
                        this.f194613a = true;
                        return this;
                    }
                    this.f194613a = false;
                    return this;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.contacttab.dscs", 2, "rspBody merge fail " + e16.toString());
                    }
                    DiscussionHandler.this.notifyUI(1000, false, null);
                    this.f194613a = true;
                    return this;
                }
            }
            if (QLog.isColorLevel()) {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = this.f194614b;
                if (oidb_sso_oidbssopkg2 != null) {
                    i3 = oidb_sso_oidbssopkg2.uint32_result.get();
                } else {
                    i3 = -1;
                }
                QLog.e("Q.contacttab.dscs", 2, "sso check fail " + i3);
            }
            DiscussionHandler.this.notifyUI(1000, false, null);
            this.f194613a = true;
            return this;
        }

        boolean d() {
            return this.f194613a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f194618a;

        /* renamed from: b, reason: collision with root package name */
        public int f194619b;

        /* renamed from: c, reason: collision with root package name */
        public int f194620c;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f194620c = 100;
            }
        }
    }

    DiscussionHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194598d = new LinkedHashMap<>(100);
        this.f194601h = new LinkedHashMap<>();
        this.f194602i = 0L;
        this.f194603m = 0L;
        this.C = null;
        this.D = qQAppInterface;
        this.f194599e = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        this.f194600f = new GroupIconHelper(qQAppInterface.getCurrentAccountUin(), this);
    }

    private void A3(String str, cmd0x58b$ConfBaseInfo cmd0x58b_confbaseinfo, int i3, long j3, long j16, int i16, String str2, n nVar, DiscussionInfo discussionInfo) {
        discussionInfo.createTime = cmd0x58b_confbaseinfo.uint32_create_time.get();
        discussionInfo.ownerUin = String.valueOf(cmd0x58b_confbaseinfo.uint64_owner_uin.get());
        discussionInfo.inheritOwnerUin = String.valueOf(cmd0x58b_confbaseinfo.uint64_inherit_owner_uin.get());
        discussionInfo.timeSec = i3;
        discussionInfo.groupUin = cmd0x58b_confbaseinfo.uint64_group_uin.get();
        discussionInfo.groupCode = cmd0x58b_confbaseinfo.uint64_group_code.get();
        discussionInfo.mOrigin = j3;
        discussionInfo.mOriginExtra = j16;
        long j17 = i16;
        if ((64 & j17) == 0) {
            discussionInfo.discussionName = str2;
            discussionInfo.DiscussionFlag = j17 | 536870912;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoRespV2 disUin=" + str + " old flag=" + discussionInfo.DiscussionFlag);
            }
            discussionInfo.DiscussionFlag = j17 | 536870912;
            discussionInfo.discussionName = str2;
        }
        nVar.D(discussionInfo);
    }

    private void B3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("retryTime", 0);
        if (i3 < 1) {
            toServiceMsg.extraData.putInt("retryTime", i3 + 1);
            send(toServiceMsg);
        }
    }

    private void C3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("retryTime", 0);
        if (i3 < 1) {
            toServiceMsg.extraData.putInt("retryTime", i3 + 1);
            sendPbReq(toServiceMsg);
            return;
        }
        t3(toServiceMsg, fromServiceMsg);
    }

    private void D3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        a.C8574a c8574a = (a.C8574a) obj;
        RespGetDiscussInteRemark respGetDiscussInteRemark = (RespGetDiscussInteRemark) c8574a.f286099c;
        long j3 = respGetDiscussInteRemark.DiscussUin;
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c8574a.f286098b;
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handleGetDiscussInteRemarkResp header.Result" + discussRespHeader.Result);
        }
        if (discussRespHeader.Result != 0) {
            if (QLog.isColorLevel()) {
                QLog.w("DiscussionHandler", 2, "header failed code: " + discussRespHeader.Result);
            }
            notifyUI(1010, false, Long.valueOf(j3));
            return;
        }
        if (fromServiceMsg.isSuccess() && c8574a.f286097a) {
            Map<Long, InteRemarkInfo> map = respGetDiscussInteRemark.InteRemarks;
            n nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            Map<String, DiscussionMemberInfo> n3 = nVar.n(String.valueOf(j3));
            if (map != null && n3 != null) {
                map.keySet();
                for (Long l3 : map.keySet()) {
                    DiscussionMemberInfo discussionMemberInfo = n3.get(String.valueOf(l3));
                    if (discussionMemberInfo != null) {
                        InteRemarkInfo inteRemarkInfo = map.get(l3);
                        discussionMemberInfo.inteRemark = inteRemarkInfo.StrValue;
                        discussionMemberInfo.inteRemarkSource = inteRemarkInfo.Source;
                        nVar.E(discussionMemberInfo);
                    }
                }
                notifyUI(1010, true, Long.valueOf(j3));
                return;
            }
            return;
        }
        notifyUI(1010, false, Long.valueOf(j3));
    }

    private void F2(long j3, long j16, long j17, String str) {
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(-1004);
        d16.init(j3, j16, j16, str, NetConnInfoCenter.getServerTime(), -1004, 3000, NetConnInfoCenter.getServerTime());
        d16.isread = true;
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "----------addMsgToDB after analysis friendUin: " + j16 + " msgType: -1004 friendType: 3000 msgContent: " + com.tencent.mobileqq.util.aw.a(str));
        }
        if (!MessageHandlerUtils.msgFilter(this.D, d16, false)) {
            this.D.getMessageFacade().c(d16, String.valueOf(j3));
        }
    }

    private boolean F3(boolean z16, List<cmd0x58a$ConfBaseInfo> list, List<Long> list2) {
        ArrayList<DiscussionInfo> k3 = ((n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER)).k();
        HashMap hashMap = new HashMap(k3.size());
        Iterator<DiscussionInfo> it = k3.iterator();
        while (it.hasNext()) {
            DiscussionInfo next = it.next();
            hashMap.put(next.uin, next);
        }
        ArrayList<DiscussionInfo> arrayList = new ArrayList<>(list.size());
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (cmd0x58a$ConfBaseInfo cmd0x58a_confbaseinfo : list) {
            DiscussionInfo discussionInfo = new DiscussionInfo();
            discussionInfo.uin = String.valueOf(cmd0x58a_confbaseinfo.uint64_conf_uin.get());
            discussionInfo.infoSeq = cmd0x58a_confbaseinfo.uint32_info_seq.get();
            discussionInfo.mUnreliableMemberCount = cmd0x58a_confbaseinfo.uint32_member_num.get();
            arrayList.add(discussionInfo);
            if (cmd0x58a_confbaseinfo.uint32_is_favorite.get() == 1) {
                arrayList2.add(discussionInfo.uin);
            }
            if (hashMap.containsKey(discussionInfo.uin)) {
                hashMap.remove(discussionInfo.uin);
            }
        }
        if (list2 != null && list2.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionHandler", 2, "handleGetDiscussResp bakUinList size = " + list2.size());
            }
            Iterator<Long> it5 = list2.iterator();
            while (it5.hasNext()) {
                String valueOf = String.valueOf(it5.next());
                if (hashMap.containsKey(valueOf)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("DiscussionHandler", 2, "handleGetDiscussResp uin: " + valueOf + " is in bakUinList,can not delete");
                    }
                    hashMap.remove(valueOf);
                }
            }
        }
        com.tencent.mobileqq.service.message.e msgCache = this.D.getMsgCache();
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("need delete dis ");
        if (n.y()) {
            for (String str : hashMap.keySet()) {
                sb5.append(str);
                sb5.append(";");
                P2(str);
                if (msgCache.v0(str) != null) {
                    msgCache.B1(str);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, sb5.toString());
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionVerify", 2, "GetDiscussList dis_cnt=" + arrayList.size() + " fav_cnt=" + arrayList2.size());
        }
        return H2(arrayList, arrayList2);
    }

    private void G3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("retryTime", 0);
        if (i3 < 1) {
            toServiceMsg.extraData.putInt("retryTime", i3 + 1);
            send(toServiceMsg);
            return;
        }
        r3(toServiceMsg, fromServiceMsg);
    }

    private void J3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("retryTime", 0);
        if (i3 < 1) {
            toServiceMsg.extraData.putInt("retryTime", i3 + 1);
            send(toServiceMsg);
            return;
        }
        K3(toServiceMsg, fromServiceMsg);
    }

    private void K3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        notifyUI(1015, false, new long[]{Long.valueOf(toServiceMsg.extraData.getLong("dwConfUin")).longValue(), Long.valueOf(toServiceMsg.extraData.getLong("dwDelMemberUin")).longValue()});
    }

    private void M3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        notifyUI(1004, false, String.valueOf(toServiceMsg.extraData.getLong("discussUin")));
    }

    private void O3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("retryTime", 0);
        if (i3 < 1) {
            toServiceMsg.extraData.putInt("retryTime", i3 + 1);
            send(toServiceMsg);
            return;
        }
        M3(toServiceMsg, fromServiceMsg);
    }

    private void V3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handleTimeOut serviceCmd:" + serviceCmd);
        }
        if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(serviceCmd)) {
            e3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(serviceCmd)) {
            h3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(serviceCmd)) {
            o3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("OidbSvc.0x58a".equalsIgnoreCase(serviceCmd)) {
            G3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(serviceCmd)) {
            B3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(serviceCmd)) {
            O3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(serviceCmd)) {
            R3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(serviceCmd)) {
            U3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("QRCodeSvc.discuss_geturl".equals(serviceCmd)) {
            H3(toServiceMsg, fromServiceMsg, null);
            return;
        }
        if ("QRCodeSvc.discuss_decode".equals(serviceCmd)) {
            p3(toServiceMsg, fromServiceMsg, null);
            return;
        }
        if ("QQServiceDiscussSvc.ReqJoinDiscuss".equals(serviceCmd)) {
            I3(toServiceMsg, fromServiceMsg, null);
            return;
        }
        if ("OidbSvc.0x865_3".equals(serviceCmd)) {
            J3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("OidbSvc.0x870_4".equals(serviceCmd)) {
            k3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("OidbSvc.0x870_5".equals(serviceCmd)) {
            X3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("OidbSvc.0x921_0".equals(serviceCmd)) {
            notifyUI(1018, false, new Object[]{toServiceMsg.extraData.getString("discUid"), Boolean.FALSE, 0, 0});
        } else if ("OidbSvc.0x58b_0".equalsIgnoreCase(serviceCmd)) {
            C3(toServiceMsg, fromServiceMsg);
        } else if ("OidbSvc.0x44c".equals(serviceCmd)) {
            Z3(toServiceMsg, fromServiceMsg, null);
        }
    }

    private void W3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        notifyUI(1017, false, Long.valueOf(toServiceMsg.extraData.getLong("dwConfUin")));
    }

    private void X3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("retryTime", 0);
        if (i3 < 1) {
            toServiceMsg.extraData.putInt("retryTime", i3 + 1);
            send(toServiceMsg);
            return;
        }
        W3(toServiceMsg, fromServiceMsg);
    }

    private boolean a4() {
        if (this.f194601h.size() > 0) {
            return true;
        }
        return false;
    }

    private void b3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        notifyUI(1003, false, new Object[]{String.valueOf(toServiceMsg.extraData.getLong("discussUin")), -1, null});
    }

    private void d3(int i3) {
        String string;
        if (i3 != 110) {
            switch (i3) {
                case 100:
                case 103:
                case 104:
                case 105:
                    string = BaseApplicationImpl.getApplication().getResources().getString(R.string.at_);
                    break;
                case 101:
                    string = BaseApplicationImpl.getApplication().getResources().getString(R.string.atd);
                    break;
                case 102:
                    string = BaseApplicationImpl.getApplication().getResources().getString(R.string.at8);
                    break;
                default:
                    string = BaseApplicationImpl.getApplication().getResources().getString(R.string.at7);
                    break;
            }
        } else {
            string = BaseApplicationImpl.getApplication().getResources().getString(R.string.at9);
        }
        ThreadManager.getUIHandler().post(new Runnable(string) { // from class: com.tencent.mobileqq.app.DiscussionHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f194604d;

            {
                this.f194604d = string;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionHandler.this, (Object) string);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QQToast.makeText(BaseApplicationImpl.getApplication().getApplicationContext(), 1, this.f194604d, 0).show();
                }
            }
        });
    }

    private void e3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("retryTime", 0);
        if (i3 < 1) {
            toServiceMsg.extraData.putInt("retryTime", i3 + 1);
            send(toServiceMsg);
            return;
        }
        b3(toServiceMsg, fromServiceMsg);
    }

    private void f3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        notifyUI(1005, false, String.valueOf(toServiceMsg.extraData.getLong("discussUin")));
    }

    private void h3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("retryTime", 0);
        if (i3 < 1) {
            toServiceMsg.extraData.putInt("retryTime", i3 + 1);
            send(toServiceMsg);
            return;
        }
        f3(toServiceMsg, fromServiceMsg);
    }

    private String h4() {
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (i3 >= 8) {
                break;
            }
            sb5.append(stackTraceElement.getFileName());
            sb5.append("-");
            sb5.append(stackTraceElement.getMethodName());
            sb5.append(";");
            i3++;
        }
        return sb5.toString();
    }

    private void handleError(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handleError serviceCmd:" + serviceCmd);
        }
        if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(serviceCmd)) {
            b3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(serviceCmd)) {
            f3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(serviceCmd)) {
            m3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("OidbSvc.0x58a".equalsIgnoreCase(serviceCmd)) {
            r3(toServiceMsg, fromServiceMsg);
            return;
        }
        if (!"QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(serviceCmd)) {
            if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(serviceCmd)) {
                M3(toServiceMsg, fromServiceMsg);
                return;
            }
            if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(serviceCmd)) {
                P3(toServiceMsg, fromServiceMsg);
                return;
            }
            if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(serviceCmd)) {
                S3(toServiceMsg, fromServiceMsg);
                return;
            }
            if ("QRCodeSvc.discuss_geturl".equals(serviceCmd)) {
                H3(toServiceMsg, fromServiceMsg, null);
                return;
            }
            if ("QRCodeSvc.discuss_decode".equals(serviceCmd)) {
                p3(toServiceMsg, fromServiceMsg, null);
                return;
            }
            if ("QQServiceDiscussSvc.ReqJoinDiscuss".equals(serviceCmd)) {
                I3(toServiceMsg, fromServiceMsg, null);
                return;
            }
            if ("OidbSvc.0x921_0".equals(serviceCmd)) {
                notifyUI(1018, false, new Object[]{toServiceMsg.extraData.getString("discUid"), Boolean.FALSE, 0, 0});
            } else if ("OidbSvc.0x58b_0".equals(serviceCmd)) {
                t3(toServiceMsg, fromServiceMsg);
            } else if ("OidbSvc.0x44c".equals(serviceCmd)) {
                Z3(toServiceMsg, fromServiceMsg, null);
            }
        }
    }

    private boolean i4(DiscussionInfo discussionInfo, List<cmd0x58b$ConfMemberInfo> list, Map<String, DiscussionMemberInfo> map) {
        n nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        ArrayList arrayList = new ArrayList();
        if (list != null && map != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<cmd0x58b$ConfMemberInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                cmd0x58b$ConfMemberInfo next = it.next();
                if (next.bytes_member_interemark.has() && !TextUtils.isEmpty(next.bytes_member_interemark.get().toStringUtf8())) {
                    String valueOf = String.valueOf(next.uint64_uin.get());
                    DiscussionMemberInfo discussionMemberInfo = map.get(valueOf);
                    if (discussionMemberInfo == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("DiscussionHandler", 2, "warning dbMemberInfo is null uin=" + valueOf);
                        }
                        arrayList.add(r4(discussionInfo, next));
                    } else if (!discussionInfo.isDiscussHrMeeting() && !TextUtils.isEmpty(discussionMemberInfo.memberUin) && discussionMemberInfo.memberUin.equals(valueOf) && !TextUtils.isEmpty(discussionMemberInfo.inteRemark) && !discussionMemberInfo.inteRemark.equals(next.bytes_member_interemark.get().toStringUtf8())) {
                        discussionMemberInfo.dataTime = currentTimeMillis;
                        discussionMemberInfo.inteRemark = next.bytes_member_interemark.get().toStringUtf8();
                        discussionMemberInfo.inteRemarkSource = next.uint32_interemark_source.get();
                        arrayList.add(discussionMemberInfo);
                        break;
                    }
                }
            }
        } else if (list != null && map == null) {
            System.currentTimeMillis();
            Iterator<cmd0x58b$ConfMemberInfo> it5 = list.iterator();
            while (it5.hasNext()) {
                arrayList.add(r4(discussionInfo, it5.next()));
            }
        }
        if (arrayList.size() > 0) {
            nVar.F(arrayList);
            return true;
        }
        return false;
    }

    private void j3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        notifyUI(1016, false, Long.valueOf(toServiceMsg.extraData.getLong("dwConfUin")));
    }

    private void j4() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105887", true)) {
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionHandler", 2, "report58bReq: switch off");
                return;
            }
            return;
        }
        String h46 = h4();
        HashMap hashMap = new HashMap();
        hashMap.put("selectorName", "report58bReq");
        hashMap.put("functionCallTime", h46);
        hashMap.put("qq", this.D.getCurrentUin());
        QQBeaconReport.reportWithAppKey("0S200MNJT807V3GE", this.D.getCurrentUin(), "groupFunctionCall", hashMap);
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "report58bReq: ");
        }
    }

    private void k3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("retryTime", 0);
        if (i3 < 1) {
            toServiceMsg.extraData.putInt("retryTime", i3 + 1);
            send(toServiceMsg);
            return;
        }
        j3(toServiceMsg, fromServiceMsg);
    }

    private void m3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        Object[] objArr = new Object[3];
        objArr[2] = -1;
        notifyUI(1002, false, objArr);
    }

    private void o3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("retryTime", 0);
        if (i3 < 1) {
            toServiceMsg.extraData.putInt("retryTime", i3 + 1);
            send(toServiceMsg);
            return;
        }
        m3(toServiceMsg, fromServiceMsg);
    }

    private void q3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        int i16;
        if (toServiceMsg != null && fromServiceMsg != null) {
            String string = toServiceMsg.extraData.getString("discUid");
            Object[] objArr = {string, Boolean.FALSE, 0, 0};
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null && mergeFrom.uint32_result.has() && mergeFrom.uint32_result.get() == 0 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    cmd0x921$RspBody cmd0x921_rspbody = new cmd0x921$RspBody();
                    try {
                        cmd0x921_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        boolean z16 = cmd0x921_rspbody.msg_get_at_all_remain.bool_priviledge.get();
                        if (cmd0x921_rspbody.msg_get_at_all_remain.uint32_uin_remain.has()) {
                            i3 = cmd0x921_rspbody.msg_get_at_all_remain.uint32_uin_remain.get();
                        } else {
                            i3 = 0;
                        }
                        if (cmd0x921_rspbody.msg_get_at_all_remain.uint32_discuss_uin_remain.has()) {
                            i16 = cmd0x921_rspbody.msg_get_at_all_remain.uint32_discuss_uin_remain.get();
                        } else {
                            i16 = 0;
                        }
                        notifyUI(1018, true, new Object[]{string, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16)});
                        return;
                    } catch (InvalidProtocolBufferMicroException unused) {
                        notifyUI(1018, false, objArr);
                        return;
                    }
                }
                notifyUI(1018, false, objArr);
            } catch (InvalidProtocolBufferMicroException unused2) {
                notifyUI(1018, false, objArr);
            }
        }
    }

    private void r3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        notifyUI(1000, false, null);
    }

    private DiscussionMemberInfo r4(DiscussionInfo discussionInfo, cmd0x58b$ConfMemberInfo cmd0x58b_confmemberinfo) {
        String str;
        DiscussionMemberInfo discussionMemberInfo = new DiscussionMemberInfo();
        discussionMemberInfo.discussionUin = discussionInfo.uin;
        discussionMemberInfo.memberUin = String.valueOf(cmd0x58b_confmemberinfo.uint64_uin.get());
        discussionMemberInfo.flag = (byte) cmd0x58b_confmemberinfo.uint32_flag.get();
        discussionMemberInfo.dataTime = System.currentTimeMillis();
        if (!discussionInfo.isDiscussHrMeeting()) {
            if (cmd0x58b_confmemberinfo.bytes_member_interemark.has() && !TextUtils.isEmpty(cmd0x58b_confmemberinfo.bytes_member_interemark.get().toStringUtf8())) {
                discussionMemberInfo.inteRemark = cmd0x58b_confmemberinfo.bytes_member_interemark.get().toStringUtf8();
                discussionMemberInfo.inteRemarkSource = cmd0x58b_confmemberinfo.uint32_interemark_source.get();
            } else {
                FriendsManager friendsManager = (FriendsManager) this.D.getManager(QQManagerFactory.FRIENDS_MANAGER);
                if (friendsManager != null) {
                    Friends u16 = friendsManager.u(discussionMemberInfo.memberUin);
                    if (u16 != null && u16.isFriend()) {
                        discussionMemberInfo.memberName = u16.name;
                        if (TextUtils.isEmpty(u16.remark)) {
                            str = u16.name;
                        } else {
                            str = u16.remark;
                        }
                        discussionMemberInfo.inteRemark = str;
                        discussionMemberInfo.inteRemarkSource = 129L;
                    } else {
                        discussionMemberInfo.inteRemarkSource = 0L;
                    }
                }
            }
        }
        return discussionMemberInfo;
    }

    private void t3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String obj;
        if (toServiceMsg.extraData.getString("signature") == null) {
            ArrayList arrayList = (ArrayList) toServiceMsg.extraData.getSerializable("discussUin");
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleGetDiscussInfoErrorV2 disUin: ");
                if (arrayList == null) {
                    obj = "null";
                } else {
                    obj = arrayList.toString();
                }
                sb5.append(obj);
                QLog.d("Q.contacttab.dscs", 2, sb5.toString());
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList(arrayList.size() * 2);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Long l3 = (Long) it.next();
                    this.f194598d.remove(String.valueOf(l3));
                    arrayList2.add(l3);
                    arrayList2.add(Boolean.FALSE);
                }
                notifyUI(1001, false, arrayList2);
            }
            if (a4()) {
                q4();
            }
        }
    }

    private void v3(ArrayList<Long> arrayList, ArrayList<Object> arrayList2, HashMap<String, c> hashMap) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                c remove = this.f194598d.remove(String.valueOf(next));
                if (remove != null) {
                    remove.f194619b++;
                    hashMap.put(String.valueOf(next), remove);
                    arrayList2.add(String.valueOf(next));
                    arrayList2.add(Boolean.FALSE);
                }
            }
        }
    }

    private void w3(String str, cmd0x58b$ConfBaseInfo cmd0x58b_confbaseinfo, int i3, int i16, int i17, long j3, long j16) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(512);
            sb5.append("handleGetDiscussInfoRespV2, server data:");
            sb5.append(" disUin[");
            sb5.append(str);
            sb5.append("], owner[");
            sb5.append(cmd0x58b_confbaseinfo.uint64_owner_uin.get());
            sb5.append("], errCode[");
            sb5.append(i16);
            sb5.append("], flag[");
            sb5.append(cmd0x58b_confbaseinfo.uint32_flag.get());
            sb5.append("], createTime[");
            sb5.append(cmd0x58b_confbaseinfo.uint32_create_time.get());
            sb5.append("], disName[");
            sb5.append(com.tencent.mobileqq.util.aw.a(cmd0x58b_confbaseinfo.bytes_conf_name.get().toStringUtf8()));
            sb5.append("], infoseq[");
            sb5.append(i17);
            sb5.append("], timesec[");
            sb5.append(i3);
            sb5.append("], discOrigin[");
            sb5.append(j3);
            sb5.append("], discOriginExtra[");
            sb5.append(j16);
            sb5.append("]");
            QLog.d("Q.contacttab.dscs", 2, sb5);
        }
    }

    private void x3(String str, DiscussionInfo discussionInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2, new info, disUin[" + str + "], DiscussionFlag[" + discussionInfo.DiscussionFlag + "]");
        }
    }

    private void y3(String str, cmd0x58b$ConfBaseInfo cmd0x58b_confbaseinfo, List<cmd0x58b$ConfMemberInfo> list, FriendsManager friendsManager, n nVar, DiscussionInfo discussionInfo) {
        DiscussionMemberInfo discussionMemberInfo;
        String str2;
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, DiscussionMemberInfo> n3 = nVar.n(str);
        QAVHrMeeting.b("handleGetDiscussInfoRespV2", this.D, discussionInfo);
        StringBuffer stringBuffer = new StringBuffer();
        for (cmd0x58b$ConfMemberInfo cmd0x58b_confmemberinfo : list) {
            String valueOf = String.valueOf(cmd0x58b_confmemberinfo.uint64_uin.get());
            if (QLog.isColorLevel()) {
                stringBuffer.append("handleGetDiscussInfoRespV2, memberUin=");
                stringBuffer.append(valueOf.toString());
                stringBuffer.append("flag=");
                stringBuffer.append(cmd0x58b_confmemberinfo.uint32_flag.get());
                stringBuffer.append("inteRemark=");
                stringBuffer.append(com.tencent.mobileqq.util.aw.a(cmd0x58b_confmemberinfo.bytes_member_interemark.get().toStringUtf8()));
                stringBuffer.append("Source=");
                stringBuffer.append(cmd0x58b_confmemberinfo.uint32_interemark_source.get());
                stringBuffer.append("\r\n");
            }
            if (n3 != null) {
                discussionMemberInfo = n3.get(valueOf);
            } else {
                discussionMemberInfo = null;
            }
            if (discussionMemberInfo == null) {
                discussionMemberInfo = new DiscussionMemberInfo();
                discussionMemberInfo.discussionUin = str;
                discussionMemberInfo.memberUin = valueOf;
            }
            discussionMemberInfo.flag = (byte) cmd0x58b_confmemberinfo.uint32_flag.get();
            discussionMemberInfo.dataTime = currentTimeMillis;
            if (cmd0x58b_confmemberinfo.bytes_member_interemark.has() && !TextUtils.isEmpty(cmd0x58b_confmemberinfo.bytes_member_interemark.get().toStringUtf8())) {
                discussionMemberInfo.inteRemark = cmd0x58b_confmemberinfo.bytes_member_interemark.get().toStringUtf8();
            } else if (TextUtils.isEmpty(discussionMemberInfo.inteRemark)) {
                Friends u16 = friendsManager.u(discussionMemberInfo.memberUin);
                if (u16 != null && u16.isFriend()) {
                    discussionMemberInfo.memberName = u16.name;
                    if (TextUtils.isEmpty(u16.remark)) {
                        str2 = u16.name;
                    } else {
                        str2 = u16.remark;
                    }
                    discussionMemberInfo.inteRemark = str2;
                    discussionMemberInfo.inteRemarkSource = 129L;
                } else {
                    discussionMemberInfo.inteRemarkSource = 0L;
                }
            }
            QAVHrMeeting.d(this.D, discussionInfo, discussionMemberInfo);
            hashMap.put(discussionMemberInfo.memberUin, discussionMemberInfo);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, stringBuffer.toString());
        }
        nVar.L(str, discussionInfo, cmd0x58b_confbaseinfo.uint32_info_seq.get(), hashMap, currentTimeMillis);
        this.f194600f.P(discussionInfo.uin);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void z3(ArrayList<Object> arrayList, int i3, String str, List<cmd0x58b$ConfMemberInfo> list, long j3, long j16, int i16, String str2, n nVar, DiscussionInfo discussionInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        Map<String, DiscussionMemberInfo> n3 = nVar.n(str);
        arrayList.set((i3 * 2) + 1, Boolean.valueOf(i4(discussionInfo, list, n3)));
        long j17 = i16;
        if ((j17 & 64) == 0) {
            if (!discussionInfo.discussionName.equals(str2)) {
                discussionInfo.DiscussionFlag = j17 | 536870912;
                discussionInfo.discussionName = str2;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 disUin=" + str + " name need server name| local name=" + com.tencent.mobileqq.util.aw.a(discussionInfo.discussionName));
                }
            } else {
                z16 = false;
                if (j3 != discussionInfo.mOrigin && j16 == discussionInfo.mOriginExtra) {
                    z18 = z16;
                } else {
                    if (!QQAudioHelper.j()) {
                        z17 = true;
                        QLog.w("DiscussionHandler", 1, "handleGetDiscussInfoRespV2, update mOrigin[" + discussionInfo.mOrigin + "->" + j3 + "], mOriginExtra[" + discussionInfo.mOriginExtra + "->" + j16 + "]");
                    } else {
                        z17 = true;
                    }
                    discussionInfo.mOrigin = j3;
                    discussionInfo.mOriginExtra = j16;
                    z18 = z17;
                }
                if (!z18) {
                    nVar.D(discussionInfo);
                    return;
                }
                return;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 disUin=" + str + " old flag=" + discussionInfo.DiscussionFlag);
            }
            discussionInfo.DiscussionFlag = j17 | 536870912;
            com.tencent.mobileqq.utils.ac.B0(this.D, str, discussionInfo, n3, false);
        }
        z16 = true;
        if (j3 != discussionInfo.mOrigin) {
        }
        if (!QQAudioHelper.j()) {
        }
        discussionInfo.mOrigin = j3;
        discussionInfo.mOriginExtra = j16;
        z18 = z17;
        if (!z18) {
        }
    }

    public void E2(long j3, ArrayList<AddDiscussMemberInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Long.valueOf(j3), arrayList);
            return;
        }
        if (c4(j3)) {
            DiscussionInfo h16 = ((n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(String.valueOf(j3));
            if (h16 != null && h16.isDiscussHrMeeting()) {
                G2(j3, arrayList);
                return;
            } else {
                k4(j3, arrayList);
                return;
            }
        }
        notifyUI(1003, false, new Object[]{String.valueOf(j3), -1});
    }

    protected void E3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        b c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean z16 = false;
        try {
            try {
                c16 = new b(new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj)).c();
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.contacttab.dscs", 2, "merge fail " + e16.toString());
                }
                notifyUI(1000, false, null);
                return;
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussRespV2 excep", e17);
            }
        }
        if (c16.d()) {
            return;
        }
        z16 = F3(false, c16.b(), c16.a());
        notifyUI(1000, z16, null);
    }

    void G2(long j3, ArrayList<AddDiscussMemberInfo> arrayList) {
        ThreadManagerV2.post(new Runnable(j3, arrayList) { // from class: com.tencent.mobileqq.app.DiscussionHandler.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f194605d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ArrayList f194606e;

            {
                this.f194605d = j3;
                this.f194606e = arrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DiscussionHandler.this, Long.valueOf(j3), arrayList);
                }
            }

            /* JADX WARN: Can't wrap try/catch for region: R(19:8|(1:10)|11|(1:13)|14|(6:17|18|19|21|22|15)|24|25|26|27|28|(3:29|30|31)|(10:56|57|(2:61|(7:63|64|34|35|(4:37|38|39|40)|48|(2:50|51)(2:52|53)))|66|64|34|35|(0)|48|(0)(0))|33|34|35|(0)|48|(0)(0)) */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x019a, code lost:
            
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x019b, code lost:
            
                r3 = "DiscussionHandler";
             */
            /* JADX WARN: Removed duplicated region for block: B:37:0x017e A[Catch: Exception -> 0x019a, all -> 0x019e, TRY_LEAVE, TryCatch #2 {Exception -> 0x019a, blocks: (B:35:0x0178, B:37:0x017e), top: B:34:0x0178 }] */
            /* JADX WARN: Removed duplicated region for block: B:50:0x01c9  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x01d3  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str;
                int i3;
                HttpResponse execute;
                JSONObject jSONObject;
                int i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("DiscussionHandler", 2, "getRedirectInfo.run url = https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/post_nickname_video_meeting_for_hr");
                }
                long j16 = this.f194605d;
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                BasicHttpContext basicHttpContext = new BasicHttpContext();
                HttpPost httpPost = new HttpPost("https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/post_nickname_video_meeting_for_hr");
                new ArrayList();
                JSONArray jSONArray = new JSONArray();
                DiscussionMemberInfo l3 = ((n) DiscussionHandler.this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER)).l(String.valueOf(j16), DiscussionHandler.this.D.getCurrentUin());
                String string = BaseApplicationImpl.getApplication().getResources().getString(R.string.brx);
                if (l3 != null) {
                    string = l3.inteRemark;
                }
                for (int i17 = 0; i17 < this.f194606e.size(); i17++) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("Uin", String.valueOf(((AddDiscussMemberInfo) this.f194606e.get(i17)).getUin()));
                        jSONObject2.put("NickName", string.toString());
                        jSONArray.mo162put(jSONObject2);
                    } catch (JSONException unused) {
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair("UinArray", jSONArray.toString());
                BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("discid", String.valueOf(j16));
                arrayList2.add(basicNameValuePair);
                arrayList2.add(basicNameValuePair2);
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("UinArray", jSONArray.toString());
                    jSONObject3.put("discid", String.valueOf(j16));
                    HashMap hashMap = new HashMap();
                    hashMap.put("UinArray", jSONArray.toString());
                    hashMap.put("discid", String.valueOf(j16));
                    String obj = hashMap.toString();
                    UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList2, "UTF-8");
                    new StringEntity(obj, "UTF-8").setContentType("application/x-www-form-urlencoded");
                    httpPost.setEntity(urlEncodedFormEntity);
                } catch (UnsupportedEncodingException unused2) {
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                try {
                    try {
                        httpPost.addHeader("Cookie", "uin=o" + DiscussionHandler.this.D.getCurrentAccountUin());
                        execute = defaultHttpClient.execute(httpPost, basicHttpContext);
                    } finally {
                        defaultHttpClient.getConnectionManager().shutdown();
                    }
                } catch (Exception e17) {
                    e = e17;
                    str = "DiscussionHandler";
                    i3 = -1;
                }
                if (execute.getStatusLine().getStatusCode() == 200) {
                    try {
                        jSONObject = new JSONObject(EntityUtils.toString(execute.getEntity()));
                    } catch (Exception unused3) {
                    }
                    if (jSONObject.getInt("retcode") == 0 && jSONObject.has("result")) {
                        JSONObject jSONObject4 = jSONObject.getJSONObject("result");
                        if (jSONObject4.has("result_code")) {
                            i16 = jSONObject4.getInt("result_code");
                            i3 = i16;
                            if (QLog.isColorLevel()) {
                                str = "DiscussionHandler";
                                try {
                                    QLog.d(str, 2, "getRedirectInfo.run redirectUrl = " + ((String) null));
                                } catch (Exception e18) {
                                    e = e18;
                                    if (QLog.isColorLevel()) {
                                        QLog.d(str, 2, "getRedirectInfo.run e = " + e);
                                    }
                                    if (i3 != 0) {
                                    }
                                }
                            }
                            if (i3 != 0) {
                                DiscussionHandler.this.k4(this.f194605d, this.f194606e);
                                return;
                            } else {
                                DiscussionHandler.this.notifyUI(1003, false, new Object[]{String.valueOf(this.f194605d), -1});
                                return;
                            }
                        }
                    }
                    i16 = -1;
                    i3 = i16;
                    if (QLog.isColorLevel()) {
                    }
                    if (i3 != 0) {
                    }
                }
                i3 = -1;
                if (QLog.isColorLevel()) {
                }
                if (i3 != 0) {
                }
            }
        }, 5, null, false);
    }

    public boolean H2(@NonNull ArrayList<DiscussionInfo> arrayList, @NonNull ArrayList<String> arrayList2) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) arrayList, (Object) arrayList2)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "addOrUpdateDiscussionWithCollectData" + arrayList.size() + ", " + arrayList2.size());
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i16 = 0;
        try {
            SharedPreferences preferences = this.D.getPreferences();
            String str = "DiscusstionIconVersion" + this.D.getCurrentAccountUin();
            int i17 = preferences.getInt(str, -1);
            if (i17 != 1) {
                SharedPreferences.Editor edit = preferences.edit();
                edit.putInt(str, 1);
                edit.commit();
                if (i17 != -1) {
                    try {
                        String[] strArr = {AppConstants.PATH_HEAD_HD, "/data/data/com.tencent.mobileqq/files/head/_hd/"};
                        int i18 = 0;
                        while (i18 < 2) {
                            File file = new File(strArr[i18]);
                            if (file.exists() && file.isDirectory()) {
                                File[] listFiles = file.listFiles();
                                int length = listFiles.length;
                                int i19 = i16;
                                while (i19 < length) {
                                    File file2 = listFiles[i19];
                                    if (file2.getName().startsWith("discussion_")) {
                                        file2.delete();
                                        if (QLog.isColorLevel()) {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("del discussion icon. name=");
                                            sb5.append(file2.getName());
                                            sb5.append(",");
                                            i3 = i19;
                                            sb5.append(file2.lastModified());
                                            QLog.d("DiscussionHandler", 2, sb5.toString());
                                            i19 = i3 + 1;
                                        }
                                    }
                                    i3 = i19;
                                    i19 = i3 + 1;
                                }
                            }
                            i18++;
                            i16 = 0;
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
            n nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            ArrayList<DiscussionInfo> arrayList3 = new ArrayList<>();
            Iterator<DiscussionInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                DiscussionInfo next = it.next();
                DiscussionInfo h16 = nVar.h(next.uin);
                if (h16 == null) {
                    DiscussionInfo discussionInfo = new DiscussionInfo();
                    discussionInfo.uin = next.uin;
                    discussionInfo.infoSeq = -1L;
                    discussionInfo.timeSec = currentTimeMillis;
                    if (arrayList2.contains(next.uin)) {
                        discussionInfo.hasCollect = true;
                    } else {
                        discussionInfo.hasCollect = false;
                    }
                    c cVar = new c();
                    cVar.f194618a = discussionInfo.uin;
                    cVar.f194620c = discussionInfo.mUnreliableMemberCount;
                    T2(cVar);
                } else {
                    if (arrayList2.contains(next.uin)) {
                        h16.hasCollect = true;
                    } else {
                        h16.hasCollect = false;
                    }
                    if (h16.infoSeq != next.infoSeq) {
                        c cVar2 = new c();
                        cVar2.f194618a = h16.uin;
                        cVar2.f194620c = h16.mUnreliableMemberCount;
                        T2(cVar2);
                    } else {
                        arrayList3.add(h16);
                    }
                    h16.timeSec = currentTimeMillis;
                }
            }
            return nVar.C(arrayList3, currentTimeMillis, false);
        } catch (Exception e17) {
            e17.printStackTrace();
            return false;
        }
    }

    protected void H3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        FlyTicket$DiscussGetUrlResponse flyTicket$DiscussGetUrlResponse;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handleGetFlyTicket");
        }
        this.f194602i = 0L;
        FlyTicket$DiscussGetUrlResponse flyTicket$DiscussGetUrlResponse2 = new FlyTicket$DiscussGetUrlResponse();
        long j3 = -1;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            try {
                flyTicket$DiscussGetUrlResponse = flyTicket$DiscussGetUrlResponse2.mergeFrom(fromServiceMsg.getWupBuffer());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                flyTicket$DiscussGetUrlResponse = null;
            }
            flyTicket$DiscussGetUrlResponse2 = flyTicket$DiscussGetUrlResponse;
            if (flyTicket$DiscussGetUrlResponse2 != null && flyTicket$DiscussGetUrlResponse2.ret_info.get() != null) {
                j3 = flyTicket$DiscussGetUrlResponse2.ret_info.get().ret_code.get();
            }
        }
        boolean z16 = false;
        Object[] objArr = {String.valueOf(j3), flyTicket$DiscussGetUrlResponse2, Long.valueOf(toServiceMsg.extraData.getLong("discussUin"))};
        if (j3 == 0) {
            z16 = true;
        }
        notifyUI(1011, z16, objArr);
    }

    public void I2(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, Long.valueOf(j3), str);
            return;
        }
        if (str != null) {
            ToServiceMsg createToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqChangeDiscussName");
            createToServiceMsg.extraData.putLong("discussUin", j3);
            createToServiceMsg.extraData.putString("newName", str);
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionHandler", 2, "--->>change discuss name uin: " + j3 + " req: " + createToServiceMsg);
            }
            send(createToServiceMsg);
        }
    }

    protected void I3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        this.f194603m = 0L;
        long j17 = -1;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            a.C8574a c8574a = (a.C8574a) obj;
            DiscussRespHeader discussRespHeader = (DiscussRespHeader) c8574a.f286098b;
            RespJoinDiscuss respJoinDiscuss = (RespJoinDiscuss) c8574a.f286099c;
            if (discussRespHeader != null) {
                j16 = discussRespHeader.Result;
            } else {
                j16 = -1;
            }
            if (respJoinDiscuss != null) {
                j17 = respJoinDiscuss.DiscussUin;
            }
            long j18 = j17;
            j17 = j16;
            j3 = j18;
        } else {
            j3 = -1;
        }
        Long[] lArr = {Long.valueOf(j17), Long.valueOf(j3)};
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && j17 == 0 && j3 > 0) {
            notifyUI(1014, true, lArr);
        } else {
            notifyUI(1014, false, lArr);
        }
    }

    public void J2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, j3);
            return;
        }
        if (((n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(j3 + "") == null) {
            S2(j3);
        }
    }

    public void K2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, j3);
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2160);
        oidb_sso_oidbssopkg.uint32_service_type.set(4);
        ByteBuffer allocate = ByteBuffer.allocate(20);
        allocate.putInt(Utils.O(j3)).putInt(0).putShort((short) 4).putInt(Utils.O(j3));
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x870_4");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putLong("dwConfUin", j3);
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    public void L2(String str, ArrayList<AddDiscussMemberInfo> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, str, arrayList, Integer.valueOf(i3));
        } else {
            M2(str, arrayList, i3, 0L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void L3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        long[] jArr;
        boolean z18;
        DiscussionInfo h16;
        boolean z19;
        String str;
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handleKickoutMemberResp");
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Long valueOf = Long.valueOf(toServiceMsg.extraData.getLong("dwDelMemberUin"));
        Long valueOf2 = Long.valueOf(toServiceMsg.extraData.getLong("dwConfUin"));
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("kickOutMemberFromDiscussion", 2, e16.getMessage());
                }
                z17 = false;
            }
        }
        z17 = z16;
        long[] jArr2 = {valueOf2.longValue(), valueOf.longValue()};
        try {
            jArr = jArr2;
            z18 = z17;
        } catch (NumberFormatException e17) {
            e = e17;
            jArr = jArr2;
            z18 = z17;
        }
        try {
            F2(Long.parseLong(this.D.getCurrentAccountUin()), valueOf2.longValue(), valueOf2.longValue(), HardCodeUtil.qqStr(R.string.f171889lo3) + this.D.getApp().getString(R.string.f170850au3, com.tencent.mobileqq.utils.ac.n(this.D, String.valueOf(valueOf2), String.valueOf(valueOf))));
        } catch (NumberFormatException e18) {
            e = e18;
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionHandler", 2, "handleKickoutMemberResp exception ", e);
            }
            h16 = ((n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(String.valueOf(valueOf2));
            if (h16 != null) {
                while (r4 < r3) {
                }
            }
            z19 = false;
            String valueOf3 = String.valueOf(valueOf2);
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(valueOf + "");
            Q2(valueOf3, hashSet);
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(valueOf));
            f4(valueOf2.longValue(), this.D.getCurrentAccountUin(), arrayList, 2);
            if (z19) {
            }
            notifyUI(1015, z18, jArr);
        }
        h16 = ((n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(String.valueOf(valueOf2));
        if (h16 != null && (str = h16.faceUinSet) != null && !str.trim().equals("") && (split = str.split(";")) != null) {
            for (String str2 : split) {
                if (str2.equals(String.valueOf(valueOf))) {
                    z19 = true;
                    break;
                }
            }
        }
        z19 = false;
        String valueOf32 = String.valueOf(valueOf2);
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add(valueOf + "");
        Q2(valueOf32, hashSet2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.valueOf(valueOf));
        f4(valueOf2.longValue(), this.D.getCurrentAccountUin(), arrayList2, 2);
        if (z19) {
            this.f194600f.P(h16.uin);
        }
        notifyUI(1015, z18, jArr);
    }

    public void M2(String str, ArrayList<AddDiscussMemberInfo> arrayList, int i3, long j3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, str, arrayList, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (str != null && arrayList != null) {
            n nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            DiscussionInfo I = nVar.I(arrayList);
            if (I != null) {
                notifyUI(1002, true, new Object[]{Long.valueOf(Long.parseLong(I.uin)), I.discussionName, 0});
                ArrayList<DiscussionMemberInfo> m3 = nVar.m(I.uin);
                ArrayList arrayList2 = new ArrayList();
                DiscussionMemberInfo discussionMemberInfo = null;
                for (int i17 = 0; i17 < m3.size(); i17++) {
                    DiscussionMemberInfo discussionMemberInfo2 = m3.get(i17);
                    if (discussionMemberInfo2 != null) {
                        String str2 = discussionMemberInfo2.memberUin;
                        if (str2 != null) {
                            if (str2.equals(I.inheritOwnerUin) || discussionMemberInfo2.memberUin.equals(I.ownerUin)) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                discussionMemberInfo = new DiscussionMemberInfo();
                                discussionMemberInfo.memberUin = discussionMemberInfo2.memberUin;
                                discussionMemberInfo.memberName = com.tencent.mobileqq.utils.ac.m(discussionMemberInfo2, this.D);
                            } else if (discussionMemberInfo2.memberUin.equalsIgnoreCase(this.D.getCurrentAccountUin())) {
                            }
                        }
                        DiscussionMemberInfo discussionMemberInfo3 = new DiscussionMemberInfo();
                        discussionMemberInfo3.memberUin = discussionMemberInfo2.memberUin;
                        String m16 = com.tencent.mobileqq.utils.ac.m(discussionMemberInfo2, this.D);
                        discussionMemberInfo3.memberName = m16;
                        discussionMemberInfo3.discussionUin = ChnToSpell.d(m16, 1);
                        arrayList2.add(discussionMemberInfo3);
                    }
                }
                Collections.sort(arrayList2, new j.b());
                if (discussionMemberInfo != null) {
                    arrayList2.add(0, discussionMemberInfo);
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("\u4f60\u4e0e");
                while (i16 < arrayList2.size() && i16 < 3) {
                    DiscussionMemberInfo discussionMemberInfo4 = (DiscussionMemberInfo) arrayList2.get(i16);
                    if (!discussionMemberInfo4.memberUin.equalsIgnoreCase(this.D.getCurrentAccountUin())) {
                        stringBuffer.append(discussionMemberInfo4.memberName);
                        stringBuffer.append("\u3001");
                    }
                    i16++;
                }
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                if (arrayList2.size() > 3) {
                    stringBuffer.append("\u7b49");
                }
                stringBuffer.append(arrayList.size());
                stringBuffer.append("\u4e2a\u6210\u5458\u5df2\u6709\u8be5\u591a\u4eba\u804a\u5929\u3002");
                com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(I.uin, this.D.getCurrentAccountUin(), stringBuffer.toString(), 3000, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 65560, com.tencent.mobileqq.service.message.e.K0());
                MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
                messageForUniteGrayTip.initGrayTipMsg(this.D, gVar);
                com.tencent.mobileqq.graytip.f.a(this.D, messageForUniteGrayTip);
                return;
            }
            ToServiceMsg createToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqCreateDiscuss");
            int size = arrayList.size();
            long[] jArr = new long[size];
            int[] iArr = new int[size];
            long[] jArr2 = new long[size];
            String[] strArr = new String[size];
            while (i16 < size) {
                jArr[i16] = arrayList.get(i16).Uin;
                iArr[i16] = arrayList.get(i16).Type;
                jArr2[i16] = arrayList.get(i16).RefUin;
                strArr[i16] = arrayList.get(i16).RefStr;
                i16++;
            }
            createToServiceMsg.extraData.putLongArray("uin", jArr);
            createToServiceMsg.extraData.putIntArray("type", iArr);
            createToServiceMsg.extraData.putLongArray("refUin", jArr2);
            createToServiceMsg.extraData.putStringArray("refStr", strArr);
            createToServiceMsg.extraData.putString("name", str);
            createToServiceMsg.extraData.putInt("from", i3);
            createToServiceMsg.extraData.putLong("uiControlFlag", j3);
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionHandler", 2, "--->>create discuss name: " + str + " req: " + createToServiceMsg);
            }
            send(createToServiceMsg);
        }
    }

    public Bitmap N2(String str) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (Bitmap) iPatchRedirector.redirect((short) 59, (Object) this, (Object) str);
        }
        if (str == null || str.length() == 0) {
            return null;
        }
        float f17 = this.D.getApp().getResources().getDisplayMetrics().density;
        int i3 = (int) ((50.0f * f17) + 0.5d);
        String[] split = str.split(";");
        if (split.length <= 1) {
            f16 = 117.0f;
        } else if (split.length <= 4) {
            f16 = 53.0f;
        } else {
            f16 = 34.0f;
        }
        int i16 = (int) (f17 * f16);
        int i17 = 9;
        if (split.length <= 9) {
            i17 = split.length;
        }
        Bitmap[] bitmapArr = new Bitmap[i17];
        for (int i18 = 0; i18 < i17; i18++) {
            bitmapArr[i18] = (Bitmap) this.D.getScaledFaceBitmap(split[i18], (byte) 1, i16, i16).second;
        }
        try {
            return this.f194600f.x(i3, bitmapArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    protected void N3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handleQuitDiscussResp");
        }
        a.C8574a c8574a = (a.C8574a) obj;
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c8574a.f286098b;
        String valueOf = String.valueOf(toServiceMsg.extraData.getLong("discussUin"));
        Object[] objArr = {valueOf, Integer.valueOf(discussRespHeader.Result), discussRespHeader.ResultDesc};
        if (discussRespHeader.Result != 0) {
            if (QLog.isColorLevel()) {
                QLog.w("DiscussionHandler", 2, "header failed! failed code: " + discussRespHeader.Result);
            }
            notifyUI(2000, true, objArr);
            notifyUI(1004, false, valueOf);
            return;
        }
        if (fromServiceMsg.isSuccess() && c8574a.f286097a) {
            P2(valueOf);
            List<String> arrayList = new ArrayList<>();
            arrayList.add(this.D.getCurrentAccountUin());
            f4(toServiceMsg.extraData.getLong("discussUin"), this.D.getCurrentAccountUin(), arrayList, 10009);
            return;
        }
        notifyUI(1004, false, valueOf);
    }

    public void O2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("QRCodeSvc.discuss_decode");
        createToServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        createToServiceMsg.extraData.putString("signature", str);
        FlyTicket$DiscussSigDecodeRequest flyTicket$DiscussSigDecodeRequest = new FlyTicket$DiscussSigDecodeRequest();
        flyTicket$DiscussSigDecodeRequest.sig.set(str);
        createToServiceMsg.putWupBuffer(flyTicket$DiscussSigDecodeRequest.toByteArray());
        send(createToServiceMsg);
    }

    public void P2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        this.f194600f.R(str);
        ((n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER)).d(str);
        this.D.getMessageFacade().q(str, 3000);
        notifyUI(1004, true, str);
    }

    public void Q2(String str, HashSet<String> hashSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) hashSet);
            return;
        }
        if (str != null && hashSet != null && hashSet.size() != 0) {
            n nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            DiscussionInfo h16 = nVar.h(str);
            if (h16 != null) {
                h16.DiscussionFlag |= 536870912;
            }
            nVar.f(str, hashSet);
        }
    }

    protected void Q3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handle set discuss attr req: " + toServiceMsg + " ~~resp: " + fromServiceMsg + " ~~ data: " + obj);
        }
    }

    public void R2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "getDiscuss" + j3);
        }
        cmd0x58a$ReqBody cmd0x58a_reqbody = new cmd0x58a$ReqBody();
        cmd0x58a_reqbody.uint32_subcmd.set(1);
        sendPbReq(makeOIDBPkg("OidbSvc.0x58a", 1418, 0, cmd0x58a_reqbody.toByteArray()));
    }

    public void S2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, j3);
            return;
        }
        if (!c4(j3)) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(Long.valueOf(j3));
            arrayList.add(Boolean.FALSE);
            notifyUI(1001, false, arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "getDiscussInfo " + j3);
        }
        n nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        c cVar = new c();
        String valueOf = String.valueOf(j3);
        cVar.f194618a = valueOf;
        cVar.f194620c = nVar.q(valueOf);
        T2(cVar);
    }

    public void T2(@NonNull c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) cVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "getDiscussInfo2 " + cVar.f194618a);
        }
        synchronized (this.f194601h) {
            if (!this.f194601h.containsKey(cVar.f194618a) && !this.f194598d.containsKey(cVar.f194618a)) {
                this.f194601h.put(cVar.f194618a, cVar);
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "getDiscussionInfo filtered " + cVar.f194618a);
            }
        }
        q4();
    }

    protected void T3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        Long valueOf = Long.valueOf(toServiceMsg.extraData.getLong("discussUin"));
        byte b16 = toServiceMsg.extraData.getByte("infoflag");
        Byte valueOf2 = Byte.valueOf(b16);
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleSetDiscussFlagResp dis=" + valueOf + " flag=" + valueOf2);
        }
        n nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        DiscussionMemberInfo l3 = nVar.l(String.valueOf(valueOf), this.D.getCurrentAccountUin());
        if (l3 != null) {
            l3.flag = b16;
            nVar.E(l3);
        }
    }

    public void U2(@NonNull Collection<c> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) collection);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "getDiscussInfo" + collection.size());
        }
        synchronized (this.f194601h) {
            for (c cVar : collection) {
                if (!this.f194601h.containsKey(cVar.f194618a) && !this.f194598d.containsKey(cVar.f194618a) && cVar.f194619b <= 1) {
                    this.f194601h.put(cVar.f194618a, cVar);
                } else if (QLog.isColorLevel()) {
                    QLog.d("Q.contacttab.dscs", 2, "getDiscussionInfo2 filtered " + cVar.f194618a);
                }
            }
        }
        q4();
    }

    public Drawable V2(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (Drawable) iPatchRedirector.redirect((short) 55, this, str, Boolean.valueOf(z16));
        }
        Bitmap W2 = W2(str, z16);
        if (W2 != null) {
            return new BitmapDrawable(W2);
        }
        return null;
    }

    public Bitmap W2(String str, boolean z16) {
        Bitmap faceBitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (Bitmap) iPatchRedirector.redirect((short) 56, this, str, Boolean.valueOf(z16));
        }
        try {
            if (str == null) {
                if (!z16) {
                    return null;
                }
                return BaseImageUtil.getDefaultDiscusionFaceBitmap();
            }
            if (GroupIconHelper.K(str)) {
                faceBitmap = this.D.getFaceBitmap(1001, str, (byte) 3, false, (byte) 1, 0);
            } else {
                faceBitmap = this.D.getFaceBitmap(101, str, (byte) 3, false, (byte) 1, 0);
            }
            if (faceBitmap == null) {
                t4(str, true);
                if (!z16) {
                    return null;
                }
                return BaseImageUtil.getDefaultDiscusionFaceBitmap();
            }
            t4(str, false);
            return faceBitmap;
        } catch (Throwable th5) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e("DiscussionHandler", 2, "getDiscussionFaceIcon error", th5);
            return null;
        }
    }

    public void X2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqGetDiscussInfo");
        createToServiceMsg.extraData.putString("signature", str);
        send(createToServiceMsg);
    }

    public void Y2(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (this.f194602i > 0 && System.currentTimeMillis() - this.f194602i < 120000) {
            return;
        }
        this.f194602i = System.currentTimeMillis();
        ToServiceMsg createToServiceMsg = createToServiceMsg("QRCodeSvc.discuss_geturl");
        createToServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        createToServiceMsg.extraData.putLong("discussUin", j3);
        FlyTicket$DiscussGetUrlRequest flyTicket$DiscussGetUrlRequest = new FlyTicket$DiscussGetUrlRequest();
        flyTicket$DiscussGetUrlRequest.conf_uin.set((int) j3);
        flyTicket$DiscussGetUrlRequest.is_need_long_link.set(z16);
        createToServiceMsg.putWupBuffer(flyTicket$DiscussGetUrlRequest.toByteArray());
        send(createToServiceMsg);
    }

    protected void Y3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        n nVar;
        DiscussionInfo h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handleUncollectDisucssionResp");
        }
        boolean z17 = true;
        boolean z18 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Long valueOf = Long.valueOf(toServiceMsg.extraData.getLong("dwConfUin"));
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() != 0) {
                    z17 = false;
                }
                if (z17 && (h16 = (nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(String.valueOf(valueOf))) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    h16.hasCollect = false;
                    h16.timeSec = currentTimeMillis;
                    nVar.N(h16);
                    nVar.K(h16);
                }
                z18 = z17;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("handleUncollectDisucssionResp", 2, e16.getMessage());
                }
            }
        } else {
            z18 = z16;
        }
        notifyUI(1017, z18, valueOf);
    }

    public GroupIconHelper Z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (GroupIconHelper) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.f194600f;
    }

    void Z3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        String sb5;
        long j3;
        String str2;
        int i3;
        n nVar;
        DiscussionInfo h16;
        int i16 = -1;
        if (toServiceMsg == null) {
            sb5 = "req\u4e3a\u7a7a, ";
            j3 = 0;
            str2 = null;
            i3 = 0;
        } else {
            long j16 = toServiceMsg.extraData.getLong("debugSeq");
            String string = toServiceMsg.extraData.getString("uin");
            int i17 = toServiceMsg.extraData.getInt("value");
            if (fromServiceMsg == null) {
                sb5 = "res\u4e3a\u7a7a, ";
            } else {
                String str3 = "isSuccess[" + fromServiceMsg.isSuccess() + "], reqAppSeq[" + toServiceMsg.getAppSeq() + "], reqSsoSeq[" + toServiceMsg.getRequestSsoSeq() + "], resAppSeq[" + fromServiceMsg.getAppSeq() + "], resSsoSeq[" + fromServiceMsg.getRequestSsoSeq() + "], ";
                if (obj == null) {
                    sb5 = str3 + "data\u4e3a\u7a7a, ";
                } else {
                    cmd0x44c$RspBody cmd0x44c_rspbody = (cmd0x44c$RspBody) BusinessHandlerUtil.decodeOIDB("DiscussionHandler", (byte[]) obj, cmd0x44c$RspBody.class);
                    if (cmd0x44c_rspbody == null) {
                        sb5 = str3 + "rspBody\u4e3a\u7a7a, ";
                    } else {
                        i16 = cmd0x44c_rspbody.uint32_code.get();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(str3);
                        sb6.append("uint32_code[");
                        sb6.append(i16);
                        sb6.append("], bytes_err_msg[");
                        if (cmd0x44c_rspbody.bytes_err_msg.get() != null) {
                            str = cmd0x44c_rspbody.bytes_err_msg.get().toStringUtf8();
                        } else {
                            str = "null";
                        }
                        sb6.append(str);
                        sb6.append("]");
                        sb5 = sb6.toString();
                    }
                }
            }
            j3 = j16;
            str2 = string;
            i3 = i17;
        }
        if (i16 == 0 && !TextUtils.isEmpty(str2) && (h16 = (nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(str2)) != null && h16.getHrExtra() != i3) {
            h16.mOriginExtra = (h16.mOriginExtra & (-4)) | (i3 & 3);
            nVar.D(h16);
            QAVHrMeeting.b("handle_0x44c_rsp", this.D, h16);
            QAVHrMeeting.o(this.D, str2);
        }
        QLog.w("DiscussionHandler", 1, "handle_0x44c_rsp, debugSeq[" + j3 + "], strDiscUin[" + str2 + "], discHrExtraValue[" + i3 + "], " + sb5);
    }

    public void a3(String[] strArr, String[] strArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) strArr, (Object) strArr2);
            return;
        }
        NewIntent newIntent = new NewIntent(this.D.getApp(), o.class);
        newIntent.putExtra("key_cmd", 0);
        newIntent.putExtra("field_id", strArr);
        newIntent.putExtra("uin_list", strArr2);
        this.D.startServlet(newIntent);
    }

    public boolean b4(DiscussionInfo discussionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this, (Object) discussionInfo)).booleanValue();
        }
        RecentUser findRecentUserByUin = this.D.getProxyManager().m().findRecentUserByUin(discussionInfo.uin, 3000);
        if (findRecentUserByUin == null || findRecentUserByUin.showUpTime == 0) {
            return false;
        }
        return true;
    }

    protected void c3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        Map<Long, Integer> map;
        Object[] objArr;
        n nVar;
        DiscussionInfo discussionInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handleAddDiscussMemberResp");
        }
        a.C8574a c8574a = (a.C8574a) obj;
        RespAddDiscussMember respAddDiscussMember = (RespAddDiscussMember) c8574a.f286099c;
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c8574a.f286098b;
        String valueOf = String.valueOf(Long.valueOf(toServiceMsg.extraData.getLong("discussUin")));
        Object[] objArr2 = {valueOf, Integer.valueOf(discussRespHeader.Result), discussRespHeader.ResultDesc};
        int i16 = discussRespHeader.Result;
        if (i16 != 0) {
            notifyUI(2000, true, objArr2);
            return;
        }
        Object[] objArr3 = new Object[3];
        objArr3[0] = valueOf;
        objArr3[1] = Integer.valueOf(i16);
        if (fromServiceMsg.isSuccess() && c8574a.f286097a) {
            n nVar2 = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            DiscussionInfo h16 = nVar2.h(valueOf);
            if (h16 == null) {
                objArr3[0] = String.valueOf(respAddDiscussMember.DiscussUin);
                notifyUI(1003, false, objArr3);
                return;
            }
            String str = h16.faceUinSet;
            if (str != null && !str.trim().equals("")) {
                i3 = str.split(";").length;
            } else {
                i3 = 0;
            }
            if (9 - i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Map<Long, Integer> map2 = respAddDiscussMember.AddResult;
            Set<Long> keySet = map2.keySet();
            List<String> arrayList = new ArrayList<>(keySet.size());
            ArrayList arrayList2 = new ArrayList();
            StringBuffer stringBuffer = new StringBuffer();
            for (Long l3 : keySet) {
                int intValue = map2.get(l3).intValue();
                if (QLog.isColorLevel()) {
                    map = map2;
                    StringBuilder sb5 = new StringBuilder();
                    objArr = objArr3;
                    sb5.append("discussUin: ");
                    nVar = nVar2;
                    discussionInfo = h16;
                    sb5.append(respAddDiscussMember.DiscussUin);
                    sb5.append(" memberUin: ");
                    sb5.append(l3.longValue());
                    sb5.append(" value: ");
                    sb5.append(intValue);
                    stringBuffer.append(sb5.toString());
                    stringBuffer.append("\n");
                } else {
                    map = map2;
                    objArr = objArr3;
                    nVar = nVar2;
                    discussionInfo = h16;
                }
                if (intValue != 0) {
                    if (keySet.size() == 1) {
                        d3(intValue);
                    } else {
                        nVar2 = nVar;
                        h16 = discussionInfo;
                        map2 = map;
                        objArr3 = objArr;
                    }
                } else {
                    DiscussionMemberInfo discussionMemberInfo = new DiscussionMemberInfo();
                    discussionMemberInfo.discussionUin = String.valueOf(respAddDiscussMember.DiscussUin);
                    discussionMemberInfo.memberUin = String.valueOf(l3);
                    discussionMemberInfo.flag = (byte) 0;
                    String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(l3 + ""), "DiscussionHandler");
                    if (nickWithUid != null) {
                        discussionMemberInfo.memberName = nickWithUid;
                    }
                    arrayList.add(String.valueOf(l3));
                    arrayList2.add(discussionMemberInfo);
                }
                nVar2 = nVar;
                h16 = discussionInfo;
                map2 = map;
                objArr3 = objArr;
            }
            Object[] objArr4 = objArr3;
            n nVar3 = nVar2;
            DiscussionInfo discussionInfo2 = h16;
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionHandler", 2, stringBuffer.toString());
            }
            f4(respAddDiscussMember.DiscussUin, this.D.getCurrentAccountUin(), arrayList, 1);
            discussionInfo2.DiscussionFlag |= 536870912;
            nVar3.F(arrayList2);
            if (z16) {
                this.f194600f.P(discussionInfo2.uin);
            }
            objArr4[2] = c8574a.f286099c;
            notifyUI(1003, true, objArr4);
            return;
        }
        objArr3[2] = null;
        notifyUI(1003, false, objArr3);
    }

    public boolean c4(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this, j3)).booleanValue();
        }
        if (j3 > 1000000) {
            return true;
        }
        return false;
    }

    public void d4(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str, i3);
            return;
        }
        if (this.f194603m > 0 && System.currentTimeMillis() - this.f194603m < 120000) {
            return;
        }
        this.f194603m = System.currentTimeMillis();
        ToServiceMsg createToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqJoinDiscuss");
        createToServiceMsg.extraData.putString("signature", str);
        createToServiceMsg.extraData.putInt("addDisSource", i3);
        send(createToServiceMsg);
    }

    public void e4(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2149);
        oidb_sso_oidbssopkg.uint32_service_type.set(3);
        ByteBuffer allocate = ByteBuffer.allocate(20);
        allocate.putInt(Utils.O(j3)).putShort((short) 1).putInt(Utils.O(j16));
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x865_3");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putLong("dwConfUin", j3);
        createToServiceMsg.extraData.putShort("wUinNum", (short) 1);
        createToServiceMsg.extraData.putLong("dwDelMemberUin", j16);
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    public void f4(long j3, String str, List<String> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Long.valueOf(j3), str, list, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "notifyMemberChange disUin=" + j3 + " cmdUin=" + str + " opType=" + i3 + " uinsize=" + list.size());
        }
        MqqHandler handler = this.D.getHandler(AVNotifyCenter.class);
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(i3);
            obtainMessage.obj = new Object[]{Long.valueOf(j3), str, (String[]) list.toArray(new String[list.size()])};
            handler.sendMessage(obtainMessage);
        }
    }

    protected void g3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handleChangeDiscussNameResp");
        }
        a.C8574a c8574a = (a.C8574a) obj;
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c8574a.f286098b;
        String valueOf = String.valueOf(toServiceMsg.extraData.getLong("discussUin"));
        Object[] objArr = {valueOf, Integer.valueOf(discussRespHeader.Result), discussRespHeader.ResultDesc};
        if (discussRespHeader.Result != 0) {
            notifyUI(2000, true, objArr);
            notifyUI(1005, false, valueOf);
        } else {
            if (c8574a.f286097a) {
                n nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                DiscussionInfo h16 = nVar.h(valueOf);
                if (h16 != null) {
                    h16.discussionName = toServiceMsg.extraData.getString("newName");
                    h16.DiscussionFlag &= -65;
                    nVar.D(h16);
                }
                notifyUI(1005, true, valueOf);
                return;
            }
            notifyUI(1005, false, valueOf);
        }
    }

    public void g4(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, j3);
            return;
        }
        if (c4(j3)) {
            ToServiceMsg createToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqQuitDiscuss");
            createToServiceMsg.extraData.putLong("discussUin", j3);
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionHandler", 2, "--->>quit discuss uin: " + j3);
            }
            send(createToServiceMsg);
            return;
        }
        notifyUI(1004, false, String.valueOf(j3));
    }

    public void getAtAllRemainCountInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) str, (Object) str2);
            return;
        }
        cmd0x921$ReqBody cmd0x921_reqbody = new cmd0x921$ReqBody();
        cmd0x921_reqbody.uint32_subcmd.set(1);
        try {
            cmd0x921$GetAtAllRemain cmd0x921_getatallremain = new cmd0x921$GetAtAllRemain();
            cmd0x921_getatallremain.uint64_uin.set(Long.parseLong(str));
            cmd0x921_getatallremain.uint64_discuss_uin.set(Long.parseLong(str2));
            cmd0x921_reqbody.msg_get_at_all_remain.set(cmd0x921_getatallremain);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x921_0", 2337, 0, cmd0x921_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("discUid", str2);
            sendPbReq(makeOIDBPkg);
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionHandler", 2, "getAnonymousChatNick error, NumberFormatException, uin : " + str + ", discUin : " + str2);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("QQServiceDiscussSvc.ReqAddDiscussMember");
            this.allowCmdSet.add("QQServiceDiscussSvc.ReqChangeDiscussName");
            this.allowCmdSet.add("QQServiceDiscussSvc.ReqCreateDiscuss");
            this.allowCmdSet.add("OidbSvc.0x58a");
            this.allowCmdSet.add("QQServiceDiscussSvc.ReqGetDiscussInfo");
            this.allowCmdSet.add("QQServiceDiscussSvc.ReqQuitDiscuss");
            this.allowCmdSet.add("QQServiceDiscussSvc.ReqSetDiscussAttr");
            this.allowCmdSet.add("QQServiceDiscussSvc.ReqSetDiscussFlag");
            this.allowCmdSet.add("QQServiceDiscussSvc.ReqGetDiscussInteRemark");
            this.allowCmdSet.add("QRCodeSvc.discuss_geturl");
            this.allowCmdSet.add("QRCodeSvc.discuss_decode");
            this.allowCmdSet.add("QQServiceDiscussSvc.ReqJoinDiscuss");
            this.allowCmdSet.add("OidbSvc.0x865_3");
            this.allowCmdSet.add("OidbSvc.0x870_4");
            this.allowCmdSet.add("OidbSvc.0x870_5");
            this.allowCmdSet.add("OidbSvc.0x921_0");
            this.allowCmdSet.add("OidbSvc.0x58b_0");
            this.allowCmdSet.add("OidbSvc.0x44c");
        }
        return this.allowCmdSet;
    }

    public void i3(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str, (Object) str2);
            return;
        }
        n nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        DiscussionInfo h16 = nVar.h(str);
        if (h16 != null) {
            h16.discussionName = str2;
            h16.DiscussionFlag &= -65;
            nVar.D(h16);
            notifyUI(1005, true, str);
        }
    }

    public void k4(long j3, ArrayList<AddDiscussMemberInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Long.valueOf(j3), arrayList);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqAddDiscussMember");
        createToServiceMsg.extraData.putLong("discussUin", j3);
        int size = arrayList.size();
        long[] jArr = new long[size];
        int[] iArr = new int[size];
        long[] jArr2 = new long[size];
        String[] strArr = new String[size];
        for (int i3 = 0; i3 < size; i3++) {
            jArr[i3] = arrayList.get(i3).Uin;
            iArr[i3] = arrayList.get(i3).Type;
            jArr2[i3] = arrayList.get(i3).RefUin;
            strArr[i3] = arrayList.get(i3).RefStr;
        }
        createToServiceMsg.extraData.putLongArray("uin", jArr);
        createToServiceMsg.extraData.putIntArray("type", iArr);
        createToServiceMsg.extraData.putLongArray("refUin", jArr2);
        createToServiceMsg.extraData.putStringArray("refStr", strArr);
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "--->>add discuss member uin: " + j3 + " req: " + createToServiceMsg);
        }
        send(createToServiceMsg);
    }

    protected void l3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        n nVar;
        DiscussionInfo h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handleCollectDisucssionResp");
        }
        boolean z17 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Long valueOf = Long.valueOf(toServiceMsg.extraData.getLong("dwConfUin"));
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && (h16 = (nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(String.valueOf(valueOf))) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    h16.hasCollect = true;
                    h16.timeSec = currentTimeMillis;
                    nVar.N(h16);
                    nVar.K(h16);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("handleCollectDisucssionResp", 2, e16.getMessage());
                }
            }
        }
        z17 = z16;
        notifyUI(1016, z17, valueOf);
    }

    public void l4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
        } else {
            notifyUI(1008, true, null);
        }
    }

    public void m4(boolean z16, boolean z17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
        } else {
            notifyUI(1007, z16, Pair.create(Boolean.valueOf(z17), str));
        }
    }

    protected void n3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList<DiscussionMemberInfo> m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handleCreateDiscussResp ");
        }
        Object[] objArr = new Object[3];
        a.C8574a c8574a = (a.C8574a) obj;
        objArr[2] = Integer.valueOf(((DiscussRespHeader) c8574a.f286098b).Result);
        if (fromServiceMsg.isSuccess() && c8574a.f286097a) {
            RespCreateDiscuss respCreateDiscuss = (RespCreateDiscuss) c8574a.f286099c;
            if (!c4(respCreateDiscuss.DiscussUin)) {
                if (QLog.isColorLevel()) {
                    QLog.d("DiscussionHandler", 2, "create discussion fail: invalid discussion uin");
                }
                notifyUI(1002, false, objArr);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionHandler", 2, "create discussion succeeded " + respCreateDiscuss.DiscussUin);
            }
            FriendsManager friendsManager = (FriendsManager) this.D.getManager(QQManagerFactory.FRIENDS_MANAGER);
            n nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            DiscussionInfo discussionInfo = new DiscussionInfo();
            discussionInfo.uin = String.valueOf(respCreateDiscuss.DiscussUin);
            discussionInfo.discussionName = toServiceMsg.extraData.getString("name");
            discussionInfo.infoSeq = -1L;
            discussionInfo.createFrom = toServiceMsg.extraData.getInt("from", 0);
            discussionInfo.uiControlFlag = toServiceMsg.extraData.getLong("uiControlFlag", 0L);
            if (discussionInfo.isUIControlFlag_Hidden_RecentUser() && (m3 = nVar.m(discussionInfo.uin)) != null) {
                int size = m3.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    DiscussionMemberInfo discussionMemberInfo = m3.get(i3);
                    if (discussionMemberInfo != null) {
                        String str = discussionMemberInfo.memberUin;
                        if (!TextUtils.isEmpty(str) && !str.equals(this.D.getCurrentAccountUin())) {
                            discussionInfo.removeUIControlFlag_Hidden_RecentUser();
                            if (QLog.isDevelopLevel()) {
                                QLog.d("DiscussionHandler", 4, "\u4e0d\u662f\u5355\u4eba\u591a\u4eba\u804a\u5929");
                            }
                        }
                    }
                    i3++;
                }
            }
            Map<Long, Integer> map = respCreateDiscuss.AddResult;
            c cVar = new c();
            cVar.f194618a = String.valueOf(respCreateDiscuss.DiscussUin);
            cVar.f194620c = map.size();
            nVar.D(discussionInfo);
            T2(cVar);
            Set<Long> keySet = map.keySet();
            ArrayList arrayList = new ArrayList();
            for (Long l3 : keySet) {
                if (map.get(l3).intValue() == 0) {
                    DiscussionMemberInfo discussionMemberInfo2 = new DiscussionMemberInfo();
                    discussionMemberInfo2.discussionUin = String.valueOf(respCreateDiscuss.DiscussUin);
                    String valueOf = String.valueOf(l3);
                    discussionMemberInfo2.memberUin = valueOf;
                    discussionMemberInfo2.flag = (byte) 0;
                    Friends u16 = friendsManager.u(valueOf);
                    if (u16 != null && u16.isFriend()) {
                        discussionMemberInfo2.memberName = u16.name;
                    } else {
                        this.f194599e.getFriendInfo(discussionMemberInfo2.memberUin);
                    }
                    arrayList.add(discussionMemberInfo2);
                }
            }
            nVar.F(arrayList);
            objArr[0] = Long.valueOf(respCreateDiscuss.DiscussUin);
            objArr[1] = toServiceMsg.extraData.getString("name");
            objArr[2] = 0;
            notifyUI(1002, true, objArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "create discussion fail, result code: " + fromServiceMsg.getResultCode() + " errMsg: " + fromServiceMsg.getBusinessFailMsg() + " respPackage.bSuccess: " + c8574a.f286097a);
        }
        notifyUI(1002, false, objArr);
    }

    public void n4(long j3, byte b16, byte b17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, Long.valueOf(j3), Byte.valueOf(b16), Byte.valueOf(b17));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqSetDiscussFlag");
        createToServiceMsg.extraData.putLong("discussUin", j3);
        createToServiceMsg.extraData.putByte("flag", b16);
        createToServiceMsg.extraData.putByte("infoflag", b17);
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "--->>set discuss flag uin: " + j3 + " req: " + createToServiceMsg);
        }
        send(createToServiceMsg);
    }

    public void o4(long j3, int i3) {
        long j16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        long b16 = QQAudioHelper.b();
        String valueOf = String.valueOf(j3);
        DiscussionInfo h16 = ((n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(valueOf);
        if (h16 == null) {
            str = "[DiscussionInfo\u4e3a\u7a7a], ";
        } else if ((h16.mOrigin & 2) != 2) {
            str = "mOrigin[" + h16.mOrigin + "], ";
        } else {
            int hrExtra = h16.getHrExtra();
            if (i3 == 1 && hrExtra != 0) {
                str = "hrExtra[" + hrExtra + "], ";
            } else {
                cmd0x44c$ReqBody cmd0x44c_reqbody = new cmd0x44c$ReqBody();
                cmd0x44c_reqbody.uint32_subcmd.set(1);
                cmd0x44c$ModifyConfInfoReq cmd0x44c_modifyconfinforeq = new cmd0x44c$ModifyConfInfoReq();
                cmd0x44c_modifyconfinforeq.uint64_conf_uin.set(j3);
                cmd0x44c_modifyconfinforeq.uint32_conf_meeting_option.set((int) ((i3 & 3) | (h16.mOriginExtra & (-4))));
                cmd0x44c_reqbody.msg_modify_conf_info_req.set(cmd0x44c_modifyconfinforeq);
                ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x44c", 1100, 2, cmd0x44c_reqbody.toByteArray());
                j16 = b16;
                makeOIDBPkg.extraData.putLong("debugSeq", j16);
                makeOIDBPkg.extraData.putString("uin", valueOf);
                makeOIDBPkg.extraData.putInt("value", i3);
                sendPbReq(makeOIDBPkg);
                str = "reqAppSeq[" + makeOIDBPkg.getAppSeq() + "], reqSsoSeq[" + makeOIDBPkg.getRequestSsoSeq() + "], ";
                QLog.w("DiscussionHandler", 1, "setHrConfExtraInfo, discUin[" + j3 + "], discHrExtraValue[" + i3 + "], debugSeq[" + j16 + "], " + str);
            }
        }
        j16 = b16;
        QLog.w("DiscussionHandler", 1, "setHrConfExtraInfo, discUin[" + j3 + "], discHrExtraValue[" + i3 + "], debugSeq[" + j16 + "], " + str);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (Class) iPatchRedirector.redirect((short) 51, (Object) this);
        }
        return com.tencent.mobileqq.troop.discussion.b.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this);
            return;
        }
        GroupIconHelper groupIconHelper = this.f194600f;
        if (groupIconHelper != null) {
            groupIconHelper.Q();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionHandler", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        if (fromServiceMsg.getResultCode() == 1002) {
            V3(toServiceMsg, fromServiceMsg);
            return;
        }
        if (fromServiceMsg.getResultCode() != 1000) {
            handleError(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(serviceCmd)) {
            c3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(serviceCmd)) {
            g3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(serviceCmd)) {
            n3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x58a".equalsIgnoreCase(serviceCmd)) {
            E3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(serviceCmd)) {
            if (toServiceMsg.extraData.getString("signature") != null) {
                s3(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(serviceCmd)) {
            N3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(serviceCmd)) {
            Q3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(serviceCmd)) {
            T3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQServiceDiscussSvc.ReqGetDiscussInteRemark".equalsIgnoreCase(serviceCmd)) {
            D3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QRCodeSvc.discuss_geturl".equalsIgnoreCase(serviceCmd)) {
            H3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QRCodeSvc.discuss_decode".equalsIgnoreCase(serviceCmd)) {
            p3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQServiceDiscussSvc.ReqJoinDiscuss".equalsIgnoreCase(serviceCmd)) {
            I3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x865_3".equalsIgnoreCase(serviceCmd)) {
            L3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x870_4".equalsIgnoreCase(serviceCmd)) {
            l3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x870_5".equalsIgnoreCase(serviceCmd)) {
            Y3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x921_0".equalsIgnoreCase(serviceCmd)) {
            q3(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x58b_0".equalsIgnoreCase(serviceCmd)) {
            u3(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x44c".equalsIgnoreCase(serviceCmd)) {
            Z3(toServiceMsg, fromServiceMsg, obj);
        }
    }

    protected void p3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "<<---handleDecodeFlyTicket");
        }
        FlyTicket$DiscussSigDecodeResponse flyTicket$DiscussSigDecodeResponse = null;
        boolean z16 = false;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            try {
                flyTicket$DiscussSigDecodeResponse = new FlyTicket$DiscussSigDecodeResponse().mergeFrom(fromServiceMsg.getWupBuffer());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (flyTicket$DiscussSigDecodeResponse != null && flyTicket$DiscussSigDecodeResponse.ret_info.get() != null && flyTicket$DiscussSigDecodeResponse.ret_info.get().ret_code.get() == 0) {
                z16 = true;
            }
            notifyUI(1012, z16, flyTicket$DiscussSigDecodeResponse);
            return;
        }
        notifyUI(1012, false, null);
    }

    public void p4(DiscussionInfo discussionInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, discussionInfo, Boolean.valueOf(z16));
            return;
        }
        RecentUserProxy m3 = this.D.getProxyManager().m();
        RecentUser findRecentUserByUin = m3.findRecentUserByUin(discussionInfo.uin, 3000);
        if (findRecentUserByUin != null) {
            if (z16) {
                findRecentUserByUin.showUpTime = System.currentTimeMillis() / 1000;
            } else {
                findRecentUserByUin.showUpTime = 0L;
            }
            m3.saveRecentUser(findRecentUserByUin);
            MqqHandler handler = this.D.getHandler(Conversation.class);
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(1009));
            }
        }
    }

    public void q4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this);
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105888", false)) {
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionHandler", 2, "startGetDiscussionInfoWorkV2: switch off");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList(50);
        synchronized (this.f194601h) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "startGetDiscussionInfoWorkV2, discussionUinListofGetinfo[" + this.f194601h.size() + "], mGettingDiscussUins[" + this.f194598d.size() + "]");
            }
            if (this.f194601h.size() == 0) {
                return;
            }
            if (this.f194598d.size() >= 100) {
                return;
            }
            n nVar = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            Iterator<Map.Entry<String, c>> it = this.f194601h.entrySet().iterator();
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (it.hasNext()) {
                c value = it.next().getValue();
                if (value.f194620c + i3 > 500 || i16 >= 50) {
                    break;
                }
                it.remove();
                DiscussionInfo h16 = nVar.h(value.f194618a);
                if (h16 != null) {
                    long j3 = h16.timeSec;
                    if (i17 > ((int) j3)) {
                        i17 = (int) j3;
                    }
                }
                this.f194598d.put(value.f194618a, value);
                arrayList.add(Long.valueOf(Long.parseLong(value.f194618a)));
                i3 += value.f194620c;
                i16++;
            }
            QLog.d("DiscussionVerify", 2, "updateBatchDiscussInfo dis_cnt=%tu mem_cnt=%tu" + i16 + " mem_cnt=" + i3);
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "startGetDiscussionInfoWorkV2, disUin[" + arrayList.toString() + "]");
            }
            cmd0x58b$ReqBody cmd0x58b_reqbody = new cmd0x58b$ReqBody();
            cmd0x58b_reqbody.uint32_subcmd.set(3);
            try {
                cmd0x58b$GetMultiConfInfoReq cmd0x58b_getmulticonfinforeq = new cmd0x58b$GetMultiConfInfoReq();
                cmd0x58b_getmulticonfinforeq.uint64_conf_uin.set(arrayList);
                cmd0x58b_getmulticonfinforeq.uint32_interemark_timestamp.set(i17);
                cmd0x58b$ConfBaseInfo cmd0x58b_confbaseinfo = new cmd0x58b$ConfBaseInfo();
                cmd0x58b_confbaseinfo.bytes_conf_name.set(ByteStringMicro.copyFromUtf8(""));
                cmd0x58b_confbaseinfo.uint32_create_time.set(0);
                cmd0x58b_confbaseinfo.uint64_owner_uin.set(0L);
                cmd0x58b_confbaseinfo.uint32_info_seq.set(0);
                cmd0x58b_confbaseinfo.uint32_last_info_time.set(0);
                cmd0x58b_confbaseinfo.uint32_msg_seq.set(0);
                cmd0x58b_confbaseinfo.uint32_last_msg_time.set(0);
                cmd0x58b_confbaseinfo.uint32_member_num.set(0);
                cmd0x58b_confbaseinfo.uint32_flag.set(0);
                cmd0x58b_confbaseinfo.uint64_inherit_owner_uin.set(0L);
                cmd0x58b_confbaseinfo.uint64_group_code.set(0L);
                cmd0x58b_confbaseinfo.uint64_group_uin.set(0L);
                cmd0x58b_confbaseinfo.uint32_conf_meeting_origin.set(0);
                cmd0x58b_confbaseinfo.uint32_conf_meeting_option.set(0);
                cmd0x58b_getmulticonfinforeq.msg_conf_base_info.set(cmd0x58b_confbaseinfo);
                cmd0x58b$ConfMemberInfo cmd0x58b_confmemberinfo = new cmd0x58b$ConfMemberInfo();
                cmd0x58b_confmemberinfo.uint32_join_time.set(0);
                cmd0x58b_confmemberinfo.uint32_flag.set(0);
                cmd0x58b_confmemberinfo.uint32_read_msg_seq.set(0);
                cmd0x58b_confmemberinfo.bytes_member_interemark.set(ByteStringMicro.copyFromUtf8(""));
                cmd0x58b_confmemberinfo.uint32_interemark_source.set(0);
                cmd0x58b_getmulticonfinforeq.msg_conf_mem_info.set(cmd0x58b_confmemberinfo);
                cmd0x58b_reqbody.msg_get_multi_conf_info.set(cmd0x58b_getmulticonfinforeq);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("DiscussionHandler", 2, "startGetDiscussionInfoWorkV2 disUin:" + arrayList.toString() + " error:" + e16.toString());
                }
            }
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x58b_0", 1419, 0, cmd0x58b_reqbody.toByteArray());
            makeOIDBPkg.extraData.putSerializable("discussUin", arrayList);
            sendPbReq(makeOIDBPkg);
            j4();
        }
    }

    protected void s3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        RespGetDiscussInfo respGetDiscussInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        long j3 = -1;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            a.C8574a c8574a = (a.C8574a) obj;
            DiscussRespHeader discussRespHeader = (DiscussRespHeader) c8574a.f286098b;
            respGetDiscussInfo = (RespGetDiscussInfo) c8574a.f286099c;
            if (discussRespHeader != null) {
                j3 = discussRespHeader.Result;
            }
        } else {
            respGetDiscussInfo = null;
        }
        Object[] objArr = {String.valueOf(j3), respGetDiscussInfo};
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && j3 == 0) {
            notifyUI(1013, true, objArr);
        } else {
            notifyUI(1013, false, objArr);
        }
    }

    public void s4(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, j3);
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2160);
        oidb_sso_oidbssopkg.uint32_service_type.set(5);
        ByteBuffer allocate = ByteBuffer.allocate(20);
        allocate.putInt(Utils.O(j3)).putInt(0).putShort((short) 4).putInt(Utils.O(j3));
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x870_5");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putLong("dwConfUin", j3);
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    public void t4(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, str, Boolean.valueOf(z16));
            return;
        }
        if (this.D.mAutomator.H2()) {
            if (z16) {
                this.f194600f.z(str);
                return;
            } else {
                this.f194600f.u(str);
                return;
            }
        }
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.add(new Pair<>(Boolean.valueOf(z16), str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x01bd, code lost:
    
        if (r19.isDiscussHrMeeting() == false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0253 A[Catch: all -> 0x026b, TryCatch #7 {all -> 0x026b, blocks: (B:43:0x024d, B:45:0x0253, B:46:0x025d, B:108:0x021f, B:98:0x0230), top: B:107:0x021f }] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0272  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void u3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        int size;
        int i16;
        DiscussionHandler discussionHandler;
        ArrayList<Object> arrayList;
        a c16;
        boolean z16;
        DiscussionInfo discussionInfo;
        n nVar;
        int i17;
        HashMap<String, c> hashMap;
        DiscussionInfo discussionInfo2;
        DiscussionHandler discussionHandler2 = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        ArrayList<Long> arrayList2 = (ArrayList) toServiceMsg.extraData.getSerializable("discussUin");
        if (arrayList2 != null) {
            i3 = arrayList2.size() * 2;
        } else {
            i3 = 0;
        }
        ArrayList<Object> arrayList3 = new ArrayList<>(i3);
        if (arrayList2 == null) {
            size = 0;
        } else {
            size = arrayList2.size();
        }
        HashMap<String, c> hashMap2 = new HashMap<>(size);
        discussionHandler2.v3(arrayList2, arrayList3, hashMap2);
        int i18 = 1001;
        try {
            try {
                c16 = new a((byte[]) obj, arrayList3, hashMap2).c();
            } catch (Exception e16) {
                e = e16;
                i16 = i18;
                discussionHandler = discussionHandler2;
                arrayList = arrayList3;
            }
            if (c16.a()) {
                if (a4()) {
                    q4();
                    return;
                }
                return;
            }
            List<cmd0x58b$GetConfInfoRsp> b16 = c16.b();
            int i19 = 0;
            while (i19 < b16.size()) {
                try {
                    try {
                        cmd0x58b$GetConfInfoRsp cmd0x58b_getconfinforsp = b16.get(i19);
                        String valueOf = String.valueOf(cmd0x58b_getconfinforsp.uint64_conf_uin.get());
                        cmd0x58b$ConfBaseInfo cmd0x58b_confbaseinfo = cmd0x58b_getconfinforsp.msg_conf_base_info.get();
                        List<cmd0x58b$ConfMemberInfo> list = cmd0x58b_getconfinforsp.rpt_msg_member_info.get();
                        int i26 = cmd0x58b_getconfinforsp.uint32_server_remark_timestamp.get();
                        int i27 = cmd0x58b_confbaseinfo.uint32_err_code.get();
                        int i28 = cmd0x58b_confbaseinfo.uint32_info_seq.get();
                        long j3 = cmd0x58b_confbaseinfo.uint32_conf_meeting_origin.get() & 255;
                        long j16 = cmd0x58b_confbaseinfo.uint32_conf_meeting_option.get() & 65535;
                        List<cmd0x58b$GetConfInfoRsp> list2 = b16;
                        ArrayList<Object> arrayList4 = arrayList3;
                        int i29 = i19;
                        try {
                            w3(valueOf, cmd0x58b_confbaseinfo, i26, i27, i28, j3, j16);
                            if (i27 != 0) {
                                if (i27 == 1) {
                                    try {
                                        hashMap2.remove(valueOf);
                                    } catch (Exception e17) {
                                        e = e17;
                                        i16 = 1001;
                                        discussionHandler = this;
                                        arrayList = arrayList4;
                                        if (QLog.isColorLevel()) {
                                        }
                                        discussionHandler.notifyUI(i16, false, arrayList);
                                        if (!a4()) {
                                        }
                                        q4();
                                    }
                                }
                                hashMap = hashMap2;
                            } else {
                                hashMap2.remove(valueOf);
                                int i36 = cmd0x58b_confbaseinfo.uint32_flag.get();
                                String stringUtf8 = cmd0x58b_confbaseinfo.bytes_conf_name.get().toStringUtf8();
                                FriendsManager friendsManager = (FriendsManager) this.D.getManager(QQManagerFactory.FRIENDS_MANAGER);
                                n nVar2 = (n) this.D.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                                DiscussionInfo h16 = nVar2.h(valueOf);
                                if (h16 == null) {
                                    try {
                                        DiscussionInfo discussionInfo3 = new DiscussionInfo();
                                        discussionInfo3.uin = valueOf;
                                        discussionInfo3.createTime = cmd0x58b_confbaseinfo.uint32_create_time.get();
                                        discussionInfo3.discussionName = stringUtf8;
                                        discussionInfo3.ownerUin = String.valueOf(cmd0x58b_confbaseinfo.uint64_owner_uin.get());
                                        discussionInfo3.inheritOwnerUin = String.valueOf(cmd0x58b_confbaseinfo.uint64_inherit_owner_uin.get());
                                        discussionInfo3.timeSec = i26;
                                        discussionInfo3.groupCode = cmd0x58b_confbaseinfo.uint64_group_code.get();
                                        discussionInfo3.groupUin = cmd0x58b_confbaseinfo.uint64_group_uin.get();
                                        discussionInfo3.mOrigin = j3;
                                        discussionInfo3.mOriginExtra = j16;
                                        discussionInfo3.DiscussionFlag = (discussionInfo3.DiscussionFlag & 536870912) | i36;
                                        x3(valueOf, discussionInfo3);
                                        discussionInfo = discussionInfo3;
                                        nVar = nVar2;
                                        i17 = 1;
                                        hashMap = hashMap2;
                                    } catch (Exception e18) {
                                        e = e18;
                                        discussionHandler = this;
                                        arrayList = arrayList4;
                                        i16 = 1001;
                                        if (QLog.isColorLevel()) {
                                        }
                                        discussionHandler.notifyUI(i16, false, arrayList);
                                        if (!a4()) {
                                        }
                                        q4();
                                    }
                                } else {
                                    if (h16.infoSeq == i28) {
                                        nVar = nVar2;
                                        discussionInfo2 = h16;
                                        hashMap = hashMap2;
                                        i17 = 1;
                                        z3(arrayList4, i29, valueOf, list, j3, j16, i36, stringUtf8, nVar, discussionInfo2);
                                    } else {
                                        hashMap = hashMap2;
                                        i17 = 1;
                                        nVar = nVar2;
                                        discussionInfo2 = h16;
                                        A3(valueOf, cmd0x58b_confbaseinfo, i26, j3, j16, i36, stringUtf8, nVar, discussionInfo2);
                                    }
                                    discussionInfo = discussionInfo2;
                                }
                                y3(valueOf, cmd0x58b_confbaseinfo, list, friendsManager, nVar, discussionInfo);
                                arrayList = arrayList4;
                                try {
                                    arrayList.set((i29 * 2) + i17, Boolean.TRUE);
                                    i19 = i29 + 1;
                                    i18 = 1001;
                                    discussionHandler2 = this;
                                    arrayList3 = arrayList;
                                    b16 = list2;
                                    hashMap2 = hashMap;
                                } catch (Exception e19) {
                                    e = e19;
                                    i16 = 1001;
                                    discussionHandler = this;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 excep", e);
                                    }
                                    discussionHandler.notifyUI(i16, false, arrayList);
                                    if (!a4()) {
                                        return;
                                    }
                                    q4();
                                }
                            }
                            arrayList = arrayList4;
                            i19 = i29 + 1;
                            i18 = 1001;
                            discussionHandler2 = this;
                            arrayList3 = arrayList;
                            b16 = list2;
                            hashMap2 = hashMap;
                        } catch (Exception e26) {
                            e = e26;
                            arrayList = arrayList4;
                            i16 = 1001;
                            discussionHandler = this;
                            if (QLog.isColorLevel()) {
                            }
                            discussionHandler.notifyUI(i16, false, arrayList);
                            if (!a4()) {
                            }
                            q4();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (a4()) {
                        }
                        throw th;
                    }
                } catch (Exception e27) {
                    e = e27;
                    arrayList = arrayList3;
                    discussionHandler = this;
                    i16 = i18;
                }
            }
            HashMap<String, c> hashMap3 = hashMap2;
            arrayList = arrayList3;
            if (hashMap3.size() > 0) {
                try {
                    discussionHandler = this;
                    z16 = true;
                    try {
                        try {
                            discussionHandler.U2(hashMap3.values());
                        } catch (Exception e28) {
                            e = e28;
                            i16 = 1001;
                            if (QLog.isColorLevel()) {
                            }
                            discussionHandler.notifyUI(i16, false, arrayList);
                            if (!a4()) {
                            }
                            q4();
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        if (a4()) {
                            q4();
                        }
                        throw th;
                    }
                } catch (Exception e29) {
                    e = e29;
                    discussionHandler = this;
                }
            } else {
                discussionHandler = this;
                z16 = true;
            }
            i16 = 1001;
            try {
                discussionHandler.notifyUI(1001, z16, arrayList);
                if (!a4()) {
                    return;
                }
            } catch (Exception e36) {
                e = e36;
                if (QLog.isColorLevel()) {
                }
                discussionHandler.notifyUI(i16, false, arrayList);
                if (!a4()) {
                }
                q4();
            }
            q4();
        } catch (Throwable th7) {
            th = th7;
        }
    }

    DiscussionHandler(QQAppInterface qQAppInterface, boolean z16) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, Boolean.valueOf(z16));
            return;
        }
        this.f194598d = new LinkedHashMap<>(100);
        this.f194601h = new LinkedHashMap<>();
        this.f194602i = 0L;
        this.f194603m = 0L;
        this.C = null;
        this.D = qQAppInterface;
        if (!z16) {
            this.f194599e = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        }
        this.f194600f = new GroupIconHelper(qQAppInterface.getCurrentAccountUin(), this);
    }

    private void P3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
    }

    private void R3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
    }

    private void S3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
    }

    private void U3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
    }
}
