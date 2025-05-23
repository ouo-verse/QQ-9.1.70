package com.tencent.mobileqq.troop.utils;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.listentogether.api.IListenTogetherApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troopAddFrd.nt.NtTroopMsgHelper;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import cooperation.ilive.group.IliveGroupTipsManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x857.GroupOpenSysMsg$SysMsgBody;
import tencent.im.oidb.cmd0x857.TroopTips0x857$GoldMsgTipsElem;
import tencent.im.oidb.cmd0x857.TroopTips0x857$NotifyMsgBody;
import tencent.im.oidb.cmd0x857.TroopTips0x857$NotifyObjmsgUpdate;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa$MsgBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class bf implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    protected static final String f302140f;

    /* renamed from: h, reason: collision with root package name */
    protected static HashMap<String, Boolean> f302141h;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f302142d;

    /* renamed from: e, reason: collision with root package name */
    protected Queue<String> f302143e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76799);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        f302140f = "<{text:'A',action:'',url:'',url_p:'schemel://xxx',actionData:'action:xxxx',actionData_i:'',actionData_a:''}>" + HardCodeUtil.qqStr(R.string.ur9) + "<{text:'B',action:'',url:'',url_p:'schemel://xxx',actionData:'action:xxxx',actionData_i:'',actionData_a:''}>" + HardCodeUtil.qqStr(R.string.ur_) + "<{icon:'/rose',url:'url.qq.com?rose.png',alt:'\u73ab\u7470'}>";
        f302141h = new HashMap<>();
    }

    public bf(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f302143e = new LinkedList();
        this.f302142d = qQAppInterface;
        new NtTroopMsgHelper().g();
    }

    private void d(GroupOpenSysMsg$SysMsgBody groupOpenSysMsg$SysMsgBody, TroopTipsEntity troopTipsEntity) {
        String str;
        if (groupOpenSysMsg$SysMsgBody.msg_type.get() == 2 && groupOpenSysMsg$SysMsgBody.light_app.has()) {
            MessageForArkApp messageForArkApp = (MessageForArkApp) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_ARK_APP);
            ArkAppMessage arkAppMessage = new ArkAppMessage();
            arkAppMessage.promptText = groupOpenSysMsg$SysMsgBody.light_app.prompt.get();
            arkAppMessage.appName = groupOpenSysMsg$SysMsgBody.light_app.app.get();
            arkAppMessage.appView = groupOpenSysMsg$SysMsgBody.light_app.view.get();
            arkAppMessage.appDesc = groupOpenSysMsg$SysMsgBody.light_app.desc.get();
            arkAppMessage.appMinVersion = groupOpenSysMsg$SysMsgBody.light_app.ver.get();
            arkAppMessage.metaList = groupOpenSysMsg$SysMsgBody.light_app.meta.get();
            arkAppMessage.config = groupOpenSysMsg$SysMsgBody.light_app.config.get();
            if (groupOpenSysMsg$SysMsgBody.light_app.source.has()) {
                arkAppMessage.mSourceName = groupOpenSysMsg$SysMsgBody.light_app.source.name.get();
                arkAppMessage.mSourceUrl = groupOpenSysMsg$SysMsgBody.light_app.source.url.get();
            }
            messageForArkApp.ark_app_message = arkAppMessage;
            if (groupOpenSysMsg$SysMsgBody.sender.has()) {
                messageForArkApp.saveExtInfoToExtStr("troop_msg_has", "1");
                messageForArkApp.saveExtInfoToExtStr("troop_msg_flag", "1");
                messageForArkApp.saveExtInfoToExtStr("troop_msg_head_url", groupOpenSysMsg$SysMsgBody.sender.avatar.get());
                messageForArkApp.saveExtInfoToExtStr("troop_msg_head_click_url", groupOpenSysMsg$SysMsgBody.sender.url.get());
                messageForArkApp.saveExtInfoToExtStr("troop_msg_nickname", groupOpenSysMsg$SysMsgBody.sender.nick.get());
                messageForArkApp.saveExtInfoToExtStr("troop_msg_nick_color", String.valueOf(BaseApplication.getContext().getResources().getColor(R.color.skin_chat_nick)));
                str = String.valueOf(groupOpenSysMsg$SysMsgBody.sender.uin.get());
            } else {
                str = "";
            }
            messageForArkApp.saveExtInfoToExtStr("troop_mini_app_sys", "1");
            messageForArkApp.frienduin = troopTipsEntity.troopUin;
            messageForArkApp.init(this.f302142d.getCurrentAccountUin(), troopTipsEntity.troopUin, str, troopTipsEntity.optContent, troopTipsEntity.time, MessageRecord.MSG_TYPE_ARK_APP, troopTipsEntity.uinType, troopTipsEntity.msgSeq);
            messageForArkApp.isread = true;
            messageForArkApp.getBytes();
            this.f302142d.getMessageFacade().c(messageForArkApp, this.f302142d.getCurrentAccountUin());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b9 A[Catch: JSONException -> 0x00e6, TryCatch #0 {JSONException -> 0x00e6, blocks: (B:6:0x001e, B:7:0x0026, B:9:0x002c, B:14:0x0044, B:16:0x004a, B:17:0x0050, B:19:0x0059, B:20:0x005d, B:22:0x0063, B:23:0x0069, B:25:0x006f, B:26:0x0073, B:41:0x00b3, B:43:0x00b9, B:44:0x00d0, B:46:0x00d6, B:47:0x00dd, B:49:0x0099, B:50:0x00a7), top: B:5:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d6 A[Catch: JSONException -> 0x00e6, TryCatch #0 {JSONException -> 0x00e6, blocks: (B:6:0x001e, B:7:0x0026, B:9:0x002c, B:14:0x0044, B:16:0x004a, B:17:0x0050, B:19:0x0059, B:20:0x005d, B:22:0x0063, B:23:0x0069, B:25:0x006f, B:26:0x0073, B:41:0x00b3, B:43:0x00b9, B:44:0x00d0, B:46:0x00d6, B:47:0x00dd, B:49:0x0099, B:50:0x00a7), top: B:5:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(MessageForGrayTips messageForGrayTips, String str) {
        int i3;
        String str2;
        String str3;
        String str4 = "url";
        if (messageForGrayTips != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i16 = 0;
                while (i16 < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i16);
                    int i17 = jSONObject.getInt("startIndex");
                    int optInt = jSONObject.optInt("endIndex");
                    if (optInt <= 0) {
                        str3 = str4;
                    } else {
                        if (jSONObject.has("cmd")) {
                            i3 = jSONObject.getInt("cmd");
                        } else {
                            i3 = -1;
                        }
                        String str5 = "";
                        if (jSONObject.has("data")) {
                            str5 = jSONObject.getString("data");
                        }
                        if (jSONObject.has("data_a")) {
                            str2 = jSONObject.getString("data_a");
                        } else {
                            str2 = null;
                        }
                        if (jSONObject.has(str4)) {
                            str5 = jSONObject.getString(str4);
                        }
                        Bundle bundle = new Bundle();
                        str3 = str4;
                        bundle.putInt("key_action", i3);
                        if (i3 != 1 && i3 != 2 && i3 != 3) {
                            if (i3 != 5) {
                                if (i3 != 15 && i3 != 18) {
                                    if (i3 != 28) {
                                        if (jSONObject.has("icon")) {
                                            bundle.putString("image_resource", jSONObject.optString("icon"));
                                            bundle.putString("image_alt", jSONObject.optString(QCircleSchemeAttr.Polymerize.ALT));
                                        }
                                        if (jSONObject.has("textColor")) {
                                            bundle.putString("textColor", jSONObject.getString("textColor"));
                                        }
                                        messageForGrayTips.addHightlightItem(i17, optInt, bundle);
                                    }
                                }
                            }
                            bundle.putString("troop_mem_uin", str5);
                            bundle.putBoolean("need_update_nick", true);
                            if (jSONObject.has("icon")) {
                            }
                            if (jSONObject.has("textColor")) {
                            }
                            messageForGrayTips.addHightlightItem(i17, optInt, bundle);
                        }
                        bundle.putString("key_action_DATA", str5);
                        bundle.putString("key_a_action_DATA", str2);
                        if (jSONObject.has("icon")) {
                        }
                        if (jSONObject.has("textColor")) {
                        }
                        messageForGrayTips.addHightlightItem(i17, optInt, bundle);
                    }
                    i16++;
                    str4 = str3;
                }
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopTipsMsgMgr", 2, "addGrayTips==>JSONException");
                }
            }
        }
    }

    private void i(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopTipsMsgMgr", 2, "removeReadedAIOGrayTips");
        }
        EntityManager createEntityManager = this.f302142d.getEntityManagerFactory().createEntityManager();
        ContentValues contentValues = new ContentValues();
        contentValues.put(com.tencent.mobileqq.msf.core.auth.k.f247491e, Boolean.TRUE);
        boolean update = createEntityManager.update(TroopTipsEntity.class.getSimpleName(), contentValues, "troopUin=? and msgSeq=?", new String[]{str, str2});
        createEntityManager.close();
        if (update) {
            QLog.d("TroopTipsMsgMgr", 2, "removeReadedAIOGrayTips ok troopUin:" + str + "msgSeq:" + str2);
            f302141h.remove(str + "_" + str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopTipsMsgMgr", 2, "removeReadedAIOGrayTips error");
        }
    }

    private void j(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopTipsMsgMgr", 2, "setUnreadAIOGrayTips");
        }
        f302141h.put(str + "_" + str2, Boolean.TRUE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(38:15|(1:17)(1:167)|18|(6:19|20|21|22|23|24)|(11:142|143|144|145|146|147|148|149|(1:151)(1:155)|(1:153)|154)(2:26|(34:28|(1:30)|31|32|(2:133|134)|34|(1:36)|37|(1:39)|40|(1:42)|43|44|45|(1:47)(1:129)|48|49|50|(5:117|118|119|120|121)(1:52)|53|54|55|(3:57|58|(11:60|61|62|63|64|66|67|68|69|70|(4:72|73|74|75)(11:76|77|78|79|80|(1:97)(3:84|85|86)|87|(1:89)|90|91|75))(1:109))(1:113)|110|78|79|80|(1:82)|97|87|(0)|90|91|75))|141|32|(0)|34|(0)|37|(0)|40|(0)|43|44|45|(0)(0)|48|49|50|(0)(0)|53|54|55|(0)(0)|110|78|79|80|(0)|97|87|(0)|90|91|75|13) */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02f7, code lost:
    
        r22 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02fc, code lost:
    
        r23 = r2;
        r2 = r18;
        r12 = r24;
        r1 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02fa, code lost:
    
        r25 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0305, code lost:
    
        r25 = r1;
        r5 = r23;
        r12 = r24;
        r1 = r28;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02b6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0218 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0181 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01ad A[Catch: JSONException -> 0x030e, TryCatch #14 {JSONException -> 0x030e, blocks: (B:149:0x010d, B:151:0x0116, B:153:0x0121, B:154:0x0138, B:32:0x017b, B:134:0x0181, B:34:0x01a7, B:36:0x01ad, B:37:0x01bd, B:39:0x01c3, B:40:0x01d7, B:42:0x01dd, B:136:0x019a, B:138:0x01a0, B:26:0x0147, B:28:0x0151, B:30:0x015b, B:31:0x0172), top: B:148:0x010d, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01c3 A[Catch: JSONException -> 0x030e, TryCatch #14 {JSONException -> 0x030e, blocks: (B:149:0x010d, B:151:0x0116, B:153:0x0121, B:154:0x0138, B:32:0x017b, B:134:0x0181, B:34:0x01a7, B:36:0x01ad, B:37:0x01bd, B:39:0x01c3, B:40:0x01d7, B:42:0x01dd, B:136:0x019a, B:138:0x01a0, B:26:0x0147, B:28:0x0151, B:30:0x015b, B:31:0x0172), top: B:148:0x010d, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01dd A[Catch: JSONException -> 0x030e, TRY_LEAVE, TryCatch #14 {JSONException -> 0x030e, blocks: (B:149:0x010d, B:151:0x0116, B:153:0x0121, B:154:0x0138, B:32:0x017b, B:134:0x0181, B:34:0x01a7, B:36:0x01ad, B:37:0x01bd, B:39:0x01c3, B:40:0x01d7, B:42:0x01dd, B:136:0x019a, B:138:0x01a0, B:26:0x0147, B:28:0x0151, B:30:0x015b, B:31:0x0172), top: B:148:0x010d, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01f9 A[Catch: JSONException -> 0x0305, TRY_LEAVE, TryCatch #2 {JSONException -> 0x0305, blocks: (B:45:0x01f3, B:47:0x01f9), top: B:44:0x01f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0245 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02c7 A[Catch: JSONException -> 0x0237, TRY_LEAVE, TryCatch #10 {JSONException -> 0x0237, blocks: (B:80:0x02be, B:82:0x02c7), top: B:79:0x02be }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02dc A[Catch: JSONException -> 0x0332, TRY_LEAVE, TryCatch #8 {JSONException -> 0x0332, blocks: (B:86:0x02d0, B:87:0x02d6, B:89:0x02dc), top: B:85:0x02d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0338  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalGrayTip a(TroopTipsEntity troopTipsEntity) {
        JSONArray jSONArray;
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        JSONArray jSONArray2;
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder;
        TroopTipsEntity troopTipsEntity2;
        String str5;
        StringBuilder sb5;
        JSONObject jSONObject;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String obj;
        String obj2;
        String str11;
        TroopTipsEntity troopTipsEntity3 = troopTipsEntity;
        String str12 = QCircleSchemeAttr.Polymerize.ALT;
        String str13 = "text";
        String str14 = "uin";
        String str15 = "icon";
        String str16 = "url";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (LocalGrayTip) iPatchRedirector.redirect((short) 12, (Object) this, (Object) troopTipsEntity3);
        }
        if (troopTipsEntity3 != null && troopTipsEntity3.optContent != null) {
            Matcher matcher = Pattern.compile(ITeamWorkUtils.TROOP_FORM_GREY_PATTERN).matcher(troopTipsEntity3.optContent);
            LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder2 = r15;
            LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder3 = new LocalGrayTip.LocalGrayTipBuilder(troopTipsEntity3.troopUin, 2, 2405L, 1, true, true, null);
            int i16 = 0;
            troopTipsEntity3.highlightNum = 0;
            JSONArray jSONArray3 = new JSONArray();
            int i17 = 0;
            String str17 = "";
            while (matcher.find()) {
                int i18 = i17 + 1;
                troopTipsEntity3.highlightNum = i18;
                if (QLog.isColorLevel()) {
                    StringBuilder sb6 = new StringBuilder();
                    jSONArray = jSONArray3;
                    sb6.append("match count=====>");
                    sb6.append(i18);
                    QLog.d("TroopTipsMsgMgr", 2, sb6.toString());
                } else {
                    jSONArray = jSONArray3;
                }
                int start = matcher.start();
                int end = matcher.end();
                Matcher matcher2 = matcher;
                String substring = troopTipsEntity3.optContent.substring(start + 1, end);
                String substring2 = troopTipsEntity3.optContent.substring(i16, start);
                localGrayTipBuilder2.g(substring2, 1);
                String str18 = str17 + substring2;
                int length = str18.length();
                int i19 = 1 + end;
                try {
                    sb5 = new StringBuilder();
                    i3 = i19;
                    try {
                        jSONObject = new JSONObject(substring);
                        jSONObject.put("startIndex", length);
                        str = str12;
                        str6 = str15;
                    } catch (JSONException unused) {
                        str = str12;
                        str2 = str13;
                        str3 = str14;
                        str4 = str16;
                        jSONArray2 = jSONArray;
                        localGrayTipBuilder = localGrayTipBuilder2;
                        troopTipsEntity2 = troopTipsEntity3;
                        str5 = str15;
                        if (QLog.isColorLevel()) {
                        }
                        troopTipsEntity3 = troopTipsEntity2;
                        jSONArray3 = jSONArray2;
                        str15 = str5;
                        localGrayTipBuilder2 = localGrayTipBuilder;
                        matcher = matcher2;
                        str12 = str;
                        str13 = str2;
                        str16 = str4;
                        str14 = str3;
                        str17 = str18;
                        i16 = i3;
                        i17 = i18;
                    }
                } catch (JSONException unused2) {
                    str = str12;
                    str2 = str13;
                    str3 = str14;
                    str4 = str16;
                    i3 = i19;
                }
                if (jSONObject.has(str14)) {
                    try {
                        str3 = str14;
                    } catch (JSONException unused3) {
                        str3 = str14;
                    }
                    try {
                        str4 = str16;
                        try {
                            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(troopTipsEntity3.troopUin, jSONObject.get(str14).toString(), null, "TroopTipsMsgMgr");
                            if (troopMemberInfoSync == null) {
                                str7 = "";
                            } else {
                                str7 = troopMemberInfoSync.nickInfo.getShowName();
                            }
                            if (str7 != null) {
                                str18 = str18 + str7;
                                jSONObject.put("endIndex", str7.length() + length);
                            }
                            sb5.append("text==>");
                            sb5.append(str7);
                        } catch (JSONException unused4) {
                            troopTipsEntity2 = troopTipsEntity;
                            str5 = str6;
                            localGrayTipBuilder = localGrayTipBuilder2;
                            str2 = str13;
                            jSONArray2 = jSONArray;
                            if (QLog.isColorLevel()) {
                            }
                            troopTipsEntity3 = troopTipsEntity2;
                            jSONArray3 = jSONArray2;
                            str15 = str5;
                            localGrayTipBuilder2 = localGrayTipBuilder;
                            matcher = matcher2;
                            str12 = str;
                            str13 = str2;
                            str16 = str4;
                            str14 = str3;
                            str17 = str18;
                            i16 = i3;
                            i17 = i18;
                        }
                    } catch (JSONException unused5) {
                        troopTipsEntity2 = troopTipsEntity;
                        str4 = str16;
                        str5 = str6;
                        localGrayTipBuilder = localGrayTipBuilder2;
                        str2 = str13;
                        jSONArray2 = jSONArray;
                        if (QLog.isColorLevel()) {
                            QLog.e("TroopTipsMsgMgr", 2, "decodeContent:JSONException");
                        }
                        troopTipsEntity3 = troopTipsEntity2;
                        jSONArray3 = jSONArray2;
                        str15 = str5;
                        localGrayTipBuilder2 = localGrayTipBuilder;
                        matcher = matcher2;
                        str12 = str;
                        str13 = str2;
                        str16 = str4;
                        str14 = str3;
                        str17 = str18;
                        i16 = i3;
                        i17 = i18;
                    }
                } else {
                    str3 = str14;
                    str4 = str16;
                    if (jSONObject.has(str13)) {
                        str8 = jSONObject.get(str13).toString();
                        if (str8 != null) {
                            str18 = str18 + str8;
                            jSONObject.put("endIndex", str8.length() + length);
                        }
                        sb5.append("text==>");
                        sb5.append(str8);
                        if (jSONObject.has("cmd")) {
                            try {
                                int parseInt = Integer.parseInt(jSONObject.get("cmd").toString());
                                jSONObject.put("cmd", parseInt);
                                sb5.append(",cmd==>");
                                sb5.append(parseInt);
                            } catch (NumberFormatException unused6) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("TroopTipsMsgMgr", 2, "decodeContent==>NumberFormatException");
                                }
                            }
                        }
                        if (jSONObject.has("textColor")) {
                            String string = jSONObject.getString("textColor");
                            jSONObject.put("textColor", string);
                            sb5.append(",textColor==>");
                            sb5.append(string);
                        }
                        if (jSONObject.has("data")) {
                            String obj3 = jSONObject.get("data").toString();
                            jSONObject.put("data", obj3);
                            sb5.append(",data==>");
                            sb5.append(obj3);
                        }
                        if (jSONObject.has("data_a")) {
                            String obj4 = jSONObject.get("data_a").toString();
                            jSONObject.put("data_a", obj4);
                            sb5.append(",data_a==>");
                            sb5.append(obj4);
                        }
                        str9 = str4;
                        if (jSONObject.has(str9)) {
                            str10 = "";
                        } else {
                            str10 = jSONObject.get(str9).toString();
                            jSONObject.put(str9, str10);
                            sb5.append(",url:");
                            sb5.append(str10);
                        }
                        str5 = str6;
                        if (!jSONObject.has(str5)) {
                            try {
                                obj = jSONObject.get(str5).toString();
                                jSONObject.put(str5, obj);
                                str4 = str9;
                            } catch (JSONException unused7) {
                                str4 = str9;
                            }
                            try {
                                sb5.append(",icon:");
                                sb5.append(obj);
                            } catch (JSONException unused8) {
                                troopTipsEntity2 = troopTipsEntity;
                                str2 = str13;
                                jSONArray2 = jSONArray;
                                localGrayTipBuilder = localGrayTipBuilder2;
                                if (QLog.isColorLevel()) {
                                }
                                troopTipsEntity3 = troopTipsEntity2;
                                jSONArray3 = jSONArray2;
                                str15 = str5;
                                localGrayTipBuilder2 = localGrayTipBuilder;
                                matcher = matcher2;
                                str12 = str;
                                str13 = str2;
                                str16 = str4;
                                str14 = str3;
                                str17 = str18;
                                i16 = i3;
                                i17 = i18;
                            }
                        } else {
                            str4 = str9;
                        }
                        if (!jSONObject.has(str)) {
                            try {
                                obj2 = jSONObject.get(str).toString();
                            } catch (JSONException unused9) {
                                str = str;
                                str2 = str13;
                            }
                            if (obj2 != null) {
                                str = str;
                                StringBuilder sb7 = new StringBuilder();
                                str2 = str13;
                                try {
                                    sb7.append("[");
                                    sb7.append(obj2);
                                    sb7.append("]");
                                    String sb8 = sb7.toString();
                                    str11 = str18 + sb8;
                                    try {
                                        jSONObject.put("endIndex", length + sb8.length());
                                        sb5.append(",alt:");
                                        sb5.append(sb8);
                                        troopTipsEntity2 = troopTipsEntity;
                                        try {
                                        } catch (JSONException unused10) {
                                            str18 = str11;
                                            jSONArray2 = jSONArray;
                                            localGrayTipBuilder = localGrayTipBuilder2;
                                            if (QLog.isColorLevel()) {
                                            }
                                            troopTipsEntity3 = troopTipsEntity2;
                                            jSONArray3 = jSONArray2;
                                            str15 = str5;
                                            localGrayTipBuilder2 = localGrayTipBuilder;
                                            matcher = matcher2;
                                            str12 = str;
                                            str13 = str2;
                                            str16 = str4;
                                            str14 = str3;
                                            str17 = str18;
                                            i16 = i3;
                                            i17 = i18;
                                        }
                                    } catch (JSONException unused11) {
                                        troopTipsEntity2 = troopTipsEntity;
                                    }
                                } catch (JSONException unused12) {
                                    troopTipsEntity2 = troopTipsEntity;
                                    jSONArray2 = jSONArray;
                                    localGrayTipBuilder = localGrayTipBuilder2;
                                    if (QLog.isColorLevel()) {
                                    }
                                    troopTipsEntity3 = troopTipsEntity2;
                                    jSONArray3 = jSONArray2;
                                    str15 = str5;
                                    localGrayTipBuilder2 = localGrayTipBuilder;
                                    matcher = matcher2;
                                    str12 = str;
                                    str13 = str2;
                                    str16 = str4;
                                    str14 = str3;
                                    str17 = str18;
                                    i16 = i3;
                                    i17 = i18;
                                }
                                if (!troopTipsEntity2.isSupportImage) {
                                    troopTipsEntity3 = troopTipsEntity2;
                                    str15 = str5;
                                    i16 = i3;
                                    jSONArray3 = jSONArray;
                                    i17 = i18;
                                    matcher = matcher2;
                                    str12 = str;
                                    str16 = str4;
                                    str14 = str3;
                                    str17 = str11;
                                    str13 = str2;
                                } else {
                                    str18 = str11;
                                    jSONArray2 = jSONArray;
                                    jSONArray2.mo162put(jSONObject);
                                    if (TextUtils.isEmpty(str8) && !TextUtils.isEmpty(str10)) {
                                        localGrayTipBuilder = localGrayTipBuilder2;
                                        try {
                                            localGrayTipBuilder.a(str8, str10, 3);
                                        } catch (JSONException unused13) {
                                            if (QLog.isColorLevel()) {
                                            }
                                            troopTipsEntity3 = troopTipsEntity2;
                                            jSONArray3 = jSONArray2;
                                            str15 = str5;
                                            localGrayTipBuilder2 = localGrayTipBuilder;
                                            matcher = matcher2;
                                            str12 = str;
                                            str13 = str2;
                                            str16 = str4;
                                            str14 = str3;
                                            str17 = str18;
                                            i16 = i3;
                                            i17 = i18;
                                        }
                                    } else {
                                        localGrayTipBuilder = localGrayTipBuilder2;
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("TroopTipsMsgMgr", 2, "decodeContent==>" + sb5.toString());
                                    }
                                    troopTipsEntity3 = troopTipsEntity2;
                                    jSONArray3 = jSONArray2;
                                    str15 = str5;
                                    localGrayTipBuilder2 = localGrayTipBuilder;
                                    matcher = matcher2;
                                    str12 = str;
                                    str13 = str2;
                                    str16 = str4;
                                    str14 = str3;
                                    str17 = str18;
                                    i16 = i3;
                                    i17 = i18;
                                }
                            }
                        }
                        str = str;
                        str2 = str13;
                        troopTipsEntity2 = troopTipsEntity;
                        jSONArray2 = jSONArray;
                        jSONArray2.mo162put(jSONObject);
                        if (TextUtils.isEmpty(str8)) {
                        }
                        localGrayTipBuilder = localGrayTipBuilder2;
                        if (QLog.isColorLevel()) {
                        }
                        troopTipsEntity3 = troopTipsEntity2;
                        jSONArray3 = jSONArray2;
                        str15 = str5;
                        localGrayTipBuilder2 = localGrayTipBuilder;
                        matcher = matcher2;
                        str12 = str;
                        str13 = str2;
                        str16 = str4;
                        str14 = str3;
                        str17 = str18;
                        i16 = i3;
                        i17 = i18;
                    }
                }
                str8 = "";
                if (jSONObject.has("cmd")) {
                }
                if (jSONObject.has("textColor")) {
                }
                if (jSONObject.has("data")) {
                }
                if (jSONObject.has("data_a")) {
                }
                str9 = str4;
                if (jSONObject.has(str9)) {
                }
                str5 = str6;
                if (!jSONObject.has(str5)) {
                }
                if (!jSONObject.has(str)) {
                }
                str = str;
                str2 = str13;
                troopTipsEntity2 = troopTipsEntity;
                jSONArray2 = jSONArray;
                jSONArray2.mo162put(jSONObject);
                if (TextUtils.isEmpty(str8)) {
                }
                localGrayTipBuilder = localGrayTipBuilder2;
                if (QLog.isColorLevel()) {
                }
                troopTipsEntity3 = troopTipsEntity2;
                jSONArray3 = jSONArray2;
                str15 = str5;
                localGrayTipBuilder2 = localGrayTipBuilder;
                matcher = matcher2;
                str12 = str;
                str13 = str2;
                str16 = str4;
                str14 = str3;
                str17 = str18;
                i16 = i3;
                i17 = i18;
            }
            TroopTipsEntity troopTipsEntity4 = troopTipsEntity3;
            JSONArray jSONArray4 = jSONArray3;
            LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder4 = localGrayTipBuilder2;
            StringBuilder sb9 = new StringBuilder();
            sb9.append(str17);
            String str19 = troopTipsEntity4.optContent;
            sb9.append(str19.substring(i16, str19.length()));
            String sb10 = sb9.toString();
            localGrayTipBuilder4.g(troopTipsEntity4.optContent.substring(i16), 1);
            troopTipsEntity4.optContent = sb10;
            if (troopTipsEntity4.highlightNum != 0) {
                troopTipsEntity4.highlightItems = jSONArray4.toString();
            }
            return localGrayTipBuilder4.m();
        }
        if (QLog.isColorLevel()) {
            QLog.e("TroopTipsMsgMgr", 2, "decodeContent ===> entity == null || content == null");
            return null;
        }
        return null;
    }

    public MessageForGrayTips b(TroopTipsEntity troopTipsEntity) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MessageForGrayTips) iPatchRedirector.redirect((short) 10, (Object) this, (Object) troopTipsEntity);
        }
        if (troopTipsEntity == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopTipsMsgMgr", 2, "decodeTroopTipsEntity2GrayTips,entity:" + troopTipsEntity.toString());
        }
        if (troopTipsEntity.grayTipsRemindFlag != 0) {
            i3 = -2042;
        } else {
            i3 = 2024;
        }
        MessageForGrayTips messageForGrayTips = (MessageForGrayTips) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_CONFIGURABLE_GRAY_TIPS);
        messageForGrayTips.frienduin = troopTipsEntity.troopUin;
        String currentAccountUin = this.f302142d.getCurrentAccountUin();
        String str = troopTipsEntity.troopUin;
        messageForGrayTips.init(currentAccountUin, str, str, troopTipsEntity.optContent, troopTipsEntity.time, i3, troopTipsEntity.uinType, troopTipsEntity.msgSeq);
        if (troopTipsEntity.highlightNum != 0) {
            h(messageForGrayTips, troopTipsEntity.highlightItems);
        }
        if (troopTipsEntity.optShowLatest == 1) {
            messageForGrayTips.shmsgseq = 0L;
        }
        messageForGrayTips.isread = true;
        messageForGrayTips.saveExtInfoToExtStr("gray_tips_serviceType", String.valueOf(troopTipsEntity.serviceType));
        return messageForGrayTips;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x034a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MessageRecord c(QQAppInterface qQAppInterface, byte[] bArr, int i3, long j3, long j16, int i16, boolean z16, boolean z17, Object obj, boolean z18) {
        TroopTips0x857$NotifyMsgBody mergeFrom;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 3, this, qQAppInterface, bArr, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), obj, Boolean.valueOf(z18));
        }
        if (bArr == null) {
            return null;
        }
        try {
            mergeFrom = new TroopTips0x857$NotifyMsgBody().mergeFrom(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
            }
        }
        if (mergeFrom == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10 ==> notifyMsgBody == null");
            }
            return null;
        }
        int i17 = mergeFrom.opt_enum_type.get();
        int i18 = mergeFrom.uint32_service_type.get();
        long j18 = mergeFrom.opt_uint64_group_code.get();
        if (QLog.isColorLevel()) {
            QLog.d("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10 ==> msgSeq:" + i3 + ", promptType: " + i17 + ", serviceType: " + i18 + ", troopUin: " + j18);
        }
        long j19 = i3;
        if (k(j18 + "", j19)) {
            return null;
        }
        if (j3 == 0) {
            j17 = NetConnInfoCenter.getServerTime();
        } else {
            j17 = j3;
        }
        long j26 = mergeFrom.opt_uint64_msg_expires.get();
        if (j26 != 0 && NetConnInfoCenter.getServerTime() >= j26) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10 ==> time expried!! promptType:" + i17);
            }
            return null;
        }
        TroopTipsEntity troopTipsEntity = new TroopTipsEntity();
        troopTipsEntity.troopUin = String.valueOf(j18);
        troopTipsEntity.time = j17;
        troopTipsEntity.expireTime = j26;
        troopTipsEntity.msgSeq = j19;
        troopTipsEntity.isOfflineMsg = z16;
        if (i17 != 9) {
            if (i17 != 10) {
                if (i17 != 13) {
                    if (i17 != 15) {
                        if (i17 != 30) {
                            if (i17 != 18) {
                                if (i17 != 19) {
                                    switch (i17) {
                                        case 21:
                                            if (mergeFrom.opt_msg_video_push.has()) {
                                                tr2.e w3 = ((tr2.b) qQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).w(2);
                                                if (w3 != null) {
                                                    w3.b(qQAppInterface, j19, j17, mergeFrom.opt_msg_video_push.get());
                                                    break;
                                                }
                                            } else {
                                                QLog.d("WatchTogetherParser", 2, "notifyMsgBody.opt_msg_video_push miss");
                                                break;
                                            }
                                            break;
                                        case 22:
                                            com.tencent.mobileqq.location.net.g.a(qQAppInterface, mergeFrom);
                                            break;
                                        case 23:
                                            if (mergeFrom.opt_msg_sing_push.has()) {
                                                tr2.e w16 = ((tr2.b) qQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).w(4);
                                                if (w16 != null) {
                                                    w16.b(qQAppInterface, j19, j17, mergeFrom.opt_msg_sing_push.get());
                                                    break;
                                                }
                                            } else {
                                                QLog.d("WatchTogetherParser", 2, "notifyMsgBody.opt_msg_sing_push miss");
                                                break;
                                            }
                                            break;
                                    }
                                } else if (mergeFrom.opt_msg_media_push.has()) {
                                    ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).decodeGroupPush(j19, j17, mergeFrom.opt_msg_media_push.get());
                                } else {
                                    QLog.d("ListenTogether", 1, "notifyMsgBody.opt_msg_media_push miss");
                                }
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("TroopTipsMsgMgr", 2, "recv Prompt_TroopFormGrayTips");
                                }
                                QLog.d("TroopTipsMsgMgr", 1, "troopFormLog receive Prompt_TroopFormGray");
                                if (mergeFrom.opt_msg_troopformtips_push.has()) {
                                    ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).insertTroopFormGrayTips(qQAppInterface, mergeFrom.opt_msg_troopformtips_push.get(), troopTipsEntity.troopUin);
                                }
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("TroopTipsMsgMgr", 2, "recv IliveGroup Prompt_QQLiveNotify");
                            }
                            if (mergeFrom.opt_qq_live_notify.has()) {
                                ((IliveGroupTipsManager) qQAppInterface.getManager(QQManagerFactory.ILIVE_GROUP_TIPS_MANAGER)).b(mergeFrom.opt_qq_live_notify.get(), j18);
                            }
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopTipsMsgMgr", 2, "recv miniAppNotify");
                        }
                        if (mergeFrom.opt_msg_miniapp_notify.has()) {
                            try {
                                byte[] byteArray = mergeFrom.opt_msg_miniapp_notify.bytes_msg.get().toByteArray();
                                GroupOpenSysMsg$SysMsgBody groupOpenSysMsg$SysMsgBody = new GroupOpenSysMsg$SysMsgBody();
                                groupOpenSysMsg$SysMsgBody.mergeFrom(byteArray);
                                d(groupOpenSysMsg$SysMsgBody, troopTipsEntity);
                            } catch (InvalidProtocolBufferMicroException unused) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("TroopTipsMsgMgr", 2, "parse miniAppNotify error");
                                }
                            }
                        }
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopTipsMsgMgr", 2, "recv action push message, [troop]");
                    }
                    if (mergeFrom.opt_msg_goldtips.has()) {
                        TroopTips0x857$GoldMsgTipsElem troopTips0x857$GoldMsgTipsElem = mergeFrom.opt_msg_goldtips.get();
                        if (troopTips0x857$GoldMsgTipsElem.type.has() && troopTips0x857$GoldMsgTipsElem.type.get() == 3) {
                            ((INotifyMsgApi) QRoute.api(INotifyMsgApi.class)).onReceiveAAPaySysNotify(1, mergeFrom.opt_msg_goldtips.get(), null);
                        }
                    }
                }
            } else if (mergeFrom.opt_msg_werewolf_push.has()) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_WEREWOLF, 2, "recv 0x857_werewolfPush");
                }
                ((WerewolvesHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).E2(mergeFrom.opt_msg_werewolf_push.get(), bArr);
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GameParty", 2, "recv 0x857_notifyobjmsgupdate push message");
        }
        if (mergeFrom.opt_msg_objmsg_update.has()) {
            TroopTips0x857$NotifyObjmsgUpdate troopTips0x857$NotifyObjmsgUpdate = mergeFrom.opt_msg_objmsg_update.get();
            if (troopTips0x857$NotifyObjmsgUpdate.bytes_ext_msg.has()) {
                try {
                    new SubMsgType0xaa$MsgBody().mergeFrom(troopTips0x857$NotifyObjmsgUpdate.bytes_ext_msg.get().toByteArray());
                } catch (Exception unused2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("GameParty", 2, "recv 0x857_notifyobjmsgupdate, prase msgBody error");
                    }
                }
            }
        }
        return null;
        e16.printStackTrace();
        if (QLog.isColorLevel()) {
            QLog.e("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10 Exception ", e16);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        if (r3.moveToFirst() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        r4 = r3.getColumnIndex("troopUin");
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        if (r4 == (-1)) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:
    
        r4 = r3.getString(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
    
        r7 = r3.getColumnIndex("msgSeq");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        if (r7 == (-1)) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
    
        r6 = r3.getString(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        if (r4 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        if (r6 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
    
        j(r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
    
        if (r3.moveToNext() != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006a, code lost:
    
        r4 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (qQAppInterface == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopTipsMsgMgr", 2, "initTroopTipsFlag");
        }
        f302141h.clear();
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        Cursor query = createEntityManager.query(true, TroopTipsEntity.class.getSimpleName(), new String[]{"troopUin"}, "read=?", new String[]{String.valueOf(0)}, "troopUin", (String) null, (String) null, (String) null);
        if (query != null) {
            try {
                try {
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopTipsMsgMgr", 2, "initTroopTipsFlag Exception");
                    }
                    createEntityManager.close();
                }
            } finally {
                query.close();
            }
        }
        createEntityManager.close();
    }

    public MessageForGrayTips f(TroopTipsEntity troopTipsEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MessageForGrayTips) iPatchRedirector.redirect((short) 9, (Object) this, (Object) troopTipsEntity);
        }
        if (this.f302142d != null && troopTipsEntity != null) {
            ArrayList arrayList = new ArrayList();
            MessageForGrayTips b16 = b(troopTipsEntity);
            if (!MessageHandlerUtils.msgFilter(this.f302142d, b16, false)) {
                arrayList.add(b16);
                this.f302142d.getMessageFacade().h(arrayList, this.f302142d.getCurrentAccountUin());
                if (troopTipsEntity.uinType == 1) {
                    i(troopTipsEntity.troopUin, troopTipsEntity.msgSeq + "");
                }
            }
            return b16;
        }
        return null;
    }

    public MessageForGrayTips g(String str, String str2, long j3, long j16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MessageForGrayTips) iPatchRedirector.redirect((short) 8, this, str, str2, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
        TroopTipsEntity troopTipsEntity = new TroopTipsEntity();
        troopTipsEntity.troopUin = str;
        troopTipsEntity.time = j3;
        troopTipsEntity.expireTime = j16;
        troopTipsEntity.msgSeq = i3;
        troopTipsEntity.tipsPromptType = 1;
        troopTipsEntity.currentUin = this.f302142d.getCurrentAccountUin();
        troopTipsEntity.optContent = str2;
        troopTipsEntity.optShowLatest = 1;
        troopTipsEntity.uinType = i16;
        a(troopTipsEntity);
        return f(troopTipsEntity);
    }

    public boolean k(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3))).booleanValue();
        }
        String str2 = str + "_" + j3;
        Iterator<String> it = this.f302143e.iterator();
        while (it.hasNext()) {
            if (it.next().equals(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopTipsMsgMgr", 2, "tipsMsgFilterBySeq, flag in queue equals uniFlag:" + str2);
                }
                return true;
            }
        }
        if (this.f302143e.size() > 30) {
            this.f302143e.poll();
        }
        this.f302143e.offer(str2);
        return false;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }
}
