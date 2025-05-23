package com.tencent.mobileqq.troop.recommend;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchReportApi;
import com.tencent.mobileqq.troop.recommend.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$FirstShow;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$GetRecommendGroupReq;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$GetRecommendGroupRsp;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$RecommendGroup;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopSearchRecommendHandler extends BusinessHandler implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, ByteStringMicro> f298242d;

    public TroopSearchRecommendHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f298242d = new ConcurrentHashMap<>();
        }
    }

    private String D2() {
        return "OidbSvcTrpcTcp.0x9009_0";
    }

    private int E2() {
        return 36873;
    }

    private int F2() {
        return 0;
    }

    private ByteStringMicro G2(boolean z16, String str) {
        ByteStringMicro byteStringMicro;
        if (z16 && !TextUtils.isEmpty(str)) {
            byteStringMicro = this.f298242d.get(str);
        } else {
            byteStringMicro = null;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("TroopSearchRecommendHandler", 4, "[getRecommendTroopSessionInfo] loadMore:" + z16 + ", from:" + str + ", res:" + byteStringMicro);
        }
        return byteStringMicro;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        String str;
        int i3;
        int i16;
        int i17;
        ByteStringMicro copyFromUtf8;
        Iterator<guildSearchRecommendSvr$RecommendGroup> it;
        String str2;
        int i18;
        String str3;
        String str4;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        guildSearchRecommendSvr$GetRecommendGroupRsp guildsearchrecommendsvr_getrecommendgrouprsp = new guildSearchRecommendSvr$GetRecommendGroupRsp();
        if (!z16) {
            str = "";
            i3 = -1;
        } else {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg2.mergeFrom((byte[]) obj);
                try {
                    guildsearchrecommendsvr_getrecommendgrouprsp = guildsearchrecommendsvr_getrecommendgrouprsp.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    oidb_sso_oidbssopkg2 = oidb_sso_oidbssopkg;
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopSearchRecommendHandler", 2, "handleGetRecommendGroupRsp|oidb_sso parseFrom byte " + e.toString());
                    }
                    e.printStackTrace();
                    oidb_sso_oidbssopkg = oidb_sso_oidbssopkg2;
                    i3 = oidb_sso_oidbssopkg.uint32_result.get();
                    str = oidb_sso_oidbssopkg.str_error_msg.get();
                    if (i3 != 0) {
                    }
                    ArrayList arrayList = new ArrayList();
                    guildSearchRecommendSvr$FirstShow guildsearchrecommendsvr_firstshow = guildsearchrecommendsvr_getrecommendgrouprsp.first_show.get();
                    if (!z16) {
                    }
                    int i19 = toServiceMsg.extraData.getInt("find_group_item_type", -1);
                    boolean z17 = toServiceMsg.extraData.getBoolean("key_load_more", false);
                    String string = toServiceMsg.extraData.getString("find_group_item_key_word", "");
                    if (!guildsearchrecommendsvr_getrecommendgrouprsp.session_info.has()) {
                    }
                    QLog.i("TroopSearchRecommendHandler", 1, "handleGetRecommendGroupRsp, isSuc=" + z16 + ",oidbesult=" + i3 + ",isEnd = " + i16 + ",dataList.size() = " + arrayList.size() + ", serverPageId: " + i17 + ", errMsg: " + str);
                    notifyUI(c.f298244e, z16, new Object[]{Integer.valueOf(i19), string, Integer.valueOf(i17), Integer.valueOf(i16), arrayList, guildsearchrecommendsvr_firstshow, copyFromUtf8, Boolean.valueOf(z17)});
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
            }
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            str = oidb_sso_oidbssopkg.str_error_msg.get();
            if (i3 != 0) {
                z16 = false;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        guildSearchRecommendSvr$FirstShow guildsearchrecommendsvr_firstshow2 = guildsearchrecommendsvr_getrecommendgrouprsp.first_show.get();
        if (!z16) {
            i16 = guildsearchrecommendsvr_getrecommendgrouprsp.is_end.get();
            i17 = guildsearchrecommendsvr_getrecommendgrouprsp.cur_pos.get();
            String string2 = toServiceMsg.extraData.getString("key_request_rcmd_troop_from");
            if (toServiceMsg.extraData.getBoolean("key_first_fetch_from_find_troop", false) && string2.equals("TroopSearchRecommendHandler") && guildsearchrecommendsvr_firstshow2 != null && guildsearchrecommendsvr_firstshow2.recommend_tab.size() > 0) {
                string2 = "TroopSearchRecommendHandler" + guildsearchrecommendsvr_firstshow2.recommend_tab.get(0).name.get();
            }
            I2(string2, guildsearchrecommendsvr_getrecommendgrouprsp.session_info.get());
            Iterator<guildSearchRecommendSvr$RecommendGroup> it5 = guildsearchrecommendsvr_getrecommendgrouprsp.recommend_groups.get().iterator();
            while (it5.hasNext()) {
                guildSearchRecommendSvr$RecommendGroup next = it5.next();
                if (next.code.has()) {
                    c.a aVar = new c.a();
                    aVar.f298245a = String.valueOf(next.code.get());
                    if (next.name.has()) {
                        it = it5;
                        aVar.f298246b = new String(next.name.get().toByteArray());
                    } else {
                        it = it5;
                    }
                    if (next.memo.has()) {
                        aVar.f298247c = new String(next.memo.get().toByteArray());
                    }
                    aVar.f298249e = next.tags.get();
                    aVar.f298250f = next.v2_tags.get();
                    aVar.f298252h = next.medals.get();
                    aVar.f298251g = next.states.get();
                    aVar.f298258n = next.icon.get();
                    aVar.f298257m = next.type.get();
                    aVar.f298248d = next.member_num.get();
                    if (!next.join_group_auth.has()) {
                        str2 = "";
                    } else {
                        str2 = next.join_group_auth.get().toStringUtf8();
                    }
                    aVar.f298254j = str2;
                    if (next.activity.has()) {
                        i18 = next.activity.get();
                    } else {
                        i18 = 0;
                    }
                    aVar.f298255k = i18;
                    aVar.f298256l = next.uin_privilege.get();
                    if (!next.bytes_algorithm.has()) {
                        str3 = "";
                    } else {
                        str3 = next.bytes_algorithm.get().toStringUtf8();
                    }
                    aVar.f298253i = str3;
                    if (!next.recom_trace.has()) {
                        str4 = "";
                    } else {
                        str4 = next.recom_trace.get();
                    }
                    aVar.f298259o = str4;
                    arrayList2.add(aVar);
                    it5 = it;
                }
            }
        } else {
            i16 = -1;
            i17 = -1;
        }
        int i192 = toServiceMsg.extraData.getInt("find_group_item_type", -1);
        boolean z172 = toServiceMsg.extraData.getBoolean("key_load_more", false);
        String string3 = toServiceMsg.extraData.getString("find_group_item_key_word", "");
        if (!guildsearchrecommendsvr_getrecommendgrouprsp.session_info.has()) {
            copyFromUtf8 = guildsearchrecommendsvr_getrecommendgrouprsp.session_info.get();
        } else {
            copyFromUtf8 = ByteStringMicro.copyFromUtf8("");
        }
        QLog.i("TroopSearchRecommendHandler", 1, "handleGetRecommendGroupRsp, isSuc=" + z16 + ",oidbesult=" + i3 + ",isEnd = " + i16 + ",dataList.size() = " + arrayList2.size() + ", serverPageId: " + i17 + ", errMsg: " + str);
        notifyUI(c.f298244e, z16, new Object[]{Integer.valueOf(i192), string3, Integer.valueOf(i17), Integer.valueOf(i16), arrayList2, guildsearchrecommendsvr_firstshow2, copyFromUtf8, Boolean.valueOf(z172)});
    }

    private void I2(String str, ByteStringMicro byteStringMicro) {
        if (QLog.isDebugVersion()) {
            QLog.d("TroopSearchRecommendHandler", 4, "[updateRecommendTroopSessionInfo] from:" + str + ", info:" + byteStringMicro);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f298242d.put(str, byteStringMicro);
    }

    @Override // com.tencent.mobileqq.troop.recommend.a
    public void C1(int i3, String str, String str2, int i16, int i17, boolean z16, boolean z17, @NonNull String str3, boolean z18) {
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), Boolean.valueOf(z17), str3, Boolean.valueOf(z18));
            return;
        }
        QLog.i("TroopSearchRecommendHandler", 1, "[getRecommendGroupReq] itemType:" + i3 + ",keyWord:" + str + ",keyWordName:" + str2 + ",curPage = " + i16 + ",firstShow = " + z16 + ",loadMore = " + z17 + ",from = " + str3);
        guildSearchRecommendSvr$GetRecommendGroupReq guildsearchrecommendsvr_getrecommendgroupreq = new guildSearchRecommendSvr$GetRecommendGroupReq();
        guildsearchrecommendsvr_getrecommendgroupreq.appid.set(1);
        guildsearchrecommendsvr_getrecommendgroupreq.pos.set(Math.max(i16, 0));
        if (!z16) {
            if (str != null) {
                PBBytesField pBBytesField = guildsearchrecommendsvr_getrecommendgroupreq.class_param;
                if (!TextUtils.isEmpty(str)) {
                    str4 = str;
                } else {
                    str4 = "";
                }
                pBBytesField.set(ByteStringMicro.copyFromUtf8(str4));
            }
            guildsearchrecommendsvr_getrecommendgroupreq.class_name.set(str2);
        }
        ByteStringMicro G2 = G2(z17, str3);
        if (G2 != null) {
            guildsearchrecommendsvr_getrecommendgroupreq.session_info.set(G2);
        }
        guildsearchrecommendsvr_getrecommendgroupreq.style_type.set(i17);
        guildsearchrecommendsvr_getrecommendgroupreq.first_show.set(z16);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(E2());
        oidb_sso_oidbssopkg.uint32_service_type.set(F2());
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(guildsearchrecommendsvr_getrecommendgroupreq.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg(D2());
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        if (i3 != -1) {
            createToServiceMsg.extraData.putInt("find_group_item_type", i3);
        }
        createToServiceMsg.extraData.putBoolean("key_load_more", z17);
        createToServiceMsg.extraData.putString("key_request_rcmd_troop_from", str3);
        Bundle bundle = createToServiceMsg.extraData;
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        bundle.putString("find_group_item_key_word", str);
        createToServiceMsg.extraData.putBoolean("key_first_fetch_from_find_troop", z18);
        createToServiceMsg.extraData.putLong(ISearchReportApi.KEY_SEND_REQ_TIME, System.currentTimeMillis());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.troop.recommend.a
    public void D(int i3, String str, String str2, int i16, int i17, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        String str3 = "TroopSearchRecommendHandler";
        if (str2 != null && !str2.isEmpty()) {
            str3 = "TroopSearchRecommendHandler" + str2;
        }
        C1(i3, str, str2, i16, i17, z16, z17, str3, z18);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(D2());
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return c.class;
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
                    QLog.d("TroopSearchRecommendHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (D2().equals(fromServiceMsg.getServiceCmd())) {
                H2(toServiceMsg, fromServiceMsg, obj);
                ((ISearchReportApi) QRoute.api(ISearchReportApi.class)).reportCgiNetworkPerformance(toServiceMsg, fromServiceMsg);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopSearchRecommendHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.recommend.a
    public void q0(String str, @Nullable ByteStringMicro byteStringMicro) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) byteStringMicro);
        } else if (byteStringMicro == null) {
            QLog.e("TroopSearchRecommendHandler", 1, "updateCacheSessionInfo info is null");
        } else {
            I2(str, byteStringMicro);
        }
    }
}
