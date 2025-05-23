package com.tencent.mobileqq.troop.essencemsg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.essence.api.ITroopEssenceMsgApi;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x857.TroopTips0x857$QQGroupDigestMsg;
import tencent.im.oidb.cmd0x857.TroopTips0x857$QQGroupDigestMsgSummary;
import tencent.im.oidb.cmd0x857.TroopTips0x857$QQGroupDigestSummaryInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f295353a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76353);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f295353a = 10;
        }
    }

    public static void b(AppRuntime appRuntime, TroopEssenceMsgItem.d dVar, IAddJsonGrayTipMsgCallback iAddJsonGrayTipMsgCallback) {
        TroopEssenceMsgItem troopEssenceMsgItem;
        if (appRuntime == null || dVar == null || (troopEssenceMsgItem = dVar.f295279a) == null || dVar.f295284f != 0) {
            return;
        }
        String valueOf = String.valueOf(troopEssenceMsgItem.troopUin);
        String string = BaseApplication.getContext().getResources().getString(R.string.f2329375w);
        String string2 = BaseApplication.getContext().getResources().getString(R.string.f2329275v);
        TroopEssenceMsgItem troopEssenceMsgItem2 = dVar.f295279a;
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(appRuntime, new LocalGrayTip.LocalGrayTipBuilder(String.valueOf(dVar.f295279a.troopUin), 2, 2401L, 1, true, true, null).h(dVar.f295282d, new com.tencent.mobileqq.troop.essencemsg.graytip.e(dVar.f295279a.msgSeq), 3).h(string, new com.tencent.mobileqq.troop.essencemsg.graytip.e(dVar.f295279a.msgSeq), 3).g(BaseApplication.getContext().getResources().getString(R.string.f2329575y), 1).h(string2, ((ITroopEssenceMsgApi) QRoute.api(ITroopEssenceMsgApi.class)).getGrayTipsToDetailsWebActionInfo(dVar.f295279a.troopUin, i(valueOf, troopEssenceMsgItem2.msgSeq, troopEssenceMsgItem2.msgRandom)), 3).m(), iAddJsonGrayTipMsgCallback);
    }

    @Nullable
    public static TroopEssenceMsgItem.a c(long j3, TroopTips0x857$QQGroupDigestMsgSummary troopTips0x857$QQGroupDigestMsgSummary) {
        if (troopTips0x857$QQGroupDigestMsgSummary != null && troopTips0x857$QQGroupDigestMsgSummary.succ_cnt.get() != 0 && troopTips0x857$QQGroupDigestMsgSummary.summary_info.has() && troopTips0x857$QQGroupDigestMsgSummary.summary_info.size() != 0) {
            ArrayList arrayList = new ArrayList(troopTips0x857$QQGroupDigestMsgSummary.summary_info.size());
            for (TroopTips0x857$QQGroupDigestSummaryInfo troopTips0x857$QQGroupDigestSummaryInfo : troopTips0x857$QQGroupDigestMsgSummary.summary_info.get()) {
                if (troopTips0x857$QQGroupDigestSummaryInfo != null && troopTips0x857$QQGroupDigestSummaryInfo.error_code.get() == 0) {
                    TroopEssenceMsgItem troopEssenceMsgItem = new TroopEssenceMsgItem();
                    troopEssenceMsgItem.troopUin = j3;
                    troopEssenceMsgItem.msgSeq = troopTips0x857$QQGroupDigestSummaryInfo.msg_seq.get();
                    troopEssenceMsgItem.msgRandom = troopTips0x857$QQGroupDigestSummaryInfo.msg_random.get();
                    if (troopTips0x857$QQGroupDigestMsgSummary.op_time.has()) {
                        troopEssenceMsgItem.opTime = troopTips0x857$QQGroupDigestMsgSummary.op_time.get();
                    }
                    troopEssenceMsgItem.opType = 1;
                    arrayList.add(troopEssenceMsgItem);
                }
            }
            return new TroopEssenceMsgItem.a(j3, arrayList, String.valueOf(troopTips0x857$QQGroupDigestMsgSummary.digest_oper.get()), troopTips0x857$QQGroupDigestMsgSummary.digest_nick.get().toStringUtf8());
        }
        return null;
    }

    public static TroopEssenceMsgItem.d d(TroopTips0x857$QQGroupDigestMsg troopTips0x857$QQGroupDigestMsg) {
        String str;
        String str2;
        int i3;
        if (troopTips0x857$QQGroupDigestMsg == null) {
            return null;
        }
        TroopEssenceMsgItem.b bVar = new TroopEssenceMsgItem.b(troopTips0x857$QQGroupDigestMsg.group_code.get(), troopTips0x857$QQGroupDigestMsg.msg_seq.get(), troopTips0x857$QQGroupDigestMsg.msg_random.get());
        TroopEssenceMsgItem.c cVar = new TroopEssenceMsgItem.c(troopTips0x857$QQGroupDigestMsg.op_type.get(), String.valueOf(troopTips0x857$QQGroupDigestMsg.msg_sender.get()), String.valueOf(troopTips0x857$QQGroupDigestMsg.digest_oper.get()), troopTips0x857$QQGroupDigestMsg.op_time.get(), 0L);
        String str3 = "";
        if (!troopTips0x857$QQGroupDigestMsg.oper_nick.has()) {
            str = "";
        } else {
            str = troopTips0x857$QQGroupDigestMsg.oper_nick.get().toStringUtf8();
        }
        if (!troopTips0x857$QQGroupDigestMsg.sender_nick.has()) {
            str2 = "";
        } else {
            str2 = troopTips0x857$QQGroupDigestMsg.sender_nick.get().toStringUtf8();
        }
        if (troopTips0x857$QQGroupDigestMsg.feed_url.has()) {
            str3 = troopTips0x857$QQGroupDigestMsg.feed_url.get().toStringUtf8();
        }
        String str4 = str3;
        if (troopTips0x857$QQGroupDigestMsg.msg_type.has()) {
            i3 = troopTips0x857$QQGroupDigestMsg.msg_type.get();
        } else {
            i3 = 0;
        }
        return new TroopEssenceMsgItem.d(new TroopEssenceMsgItem(bVar, cVar), troopTips0x857$QQGroupDigestMsg.lastest_msg_seq.get(), str, str2, str4, i3);
    }

    public static MessageForUniteGrayTip e(QQAppInterface qQAppInterface, TroopEssenceMsgItem.a aVar) {
        ArrayList<TroopEssenceMsgItem> arrayList;
        if (qQAppInterface != null && aVar != null && (arrayList = aVar.f295268b) != null && !arrayList.isEmpty()) {
            String valueOf = String.valueOf(aVar.f295267a);
            String string = BaseApplication.getContext().getResources().getString(R.string.f2329275v);
            String str = aVar.f295270d + BaseApplication.getContext().getResources().getString(R.string.f2329175u).replace("$COUNT", String.valueOf(aVar.f295268b.size())) + string;
            com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(valueOf, valueOf, str, 1, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 131090, com.tencent.mobileqq.service.message.e.K0());
            Iterator<TroopEssenceMsgItem> it = aVar.f295268b.iterator();
            long j3 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                TroopEssenceMsgItem next = it.next();
                long j16 = next.msgSeq;
                if (j16 > j3) {
                    i3 = next.msgRandom;
                    j3 = j16;
                }
            }
            Bundle bundle = new Bundle();
            String i16 = i(valueOf, j3, i3);
            bundle.putInt("key_action", 1);
            bundle.putString("textColor", "#40A0FF");
            bundle.putString("key_action_DATA", i16);
            gVar.b(str.length() - string.length(), str.length(), bundle);
            MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
            messageForUniteGrayTip.createMessageUniseq();
            messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
            return messageForUniteGrayTip;
        }
        return null;
    }

    public static int f(AIOMsgItem aIOMsgItem) {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return 0;
        }
        MsgRecord msgRecord = aIOMsgItem.getMsgRecord();
        if (msgRecord.getChatType() != 2) {
            return 0;
        }
        if ((msgRecord.getAnonymousExtInfo() == null || msgRecord.getAnonymousExtInfo().getAnonymousFlag() <= 0) && msgRecord.getSendStatus() != 0) {
            boolean z16 = true;
            if (msgRecord.getSendStatus() == 1 || com.tencent.mobileqq.aio.utils.d.b0(aIOMsgItem)) {
                return 0;
            }
            if (com.tencent.mobileqq.aio.utils.d.u(aIOMsgItem.getMsgRecord())) {
                com.tencent.qqnt.msg.data.a parseArkModel = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).parseArkModel(aIOMsgItem);
                if (parseArkModel == null || !p(parseArkModel.d(), parseArkModel.m())) {
                    z16 = false;
                }
                if (!z16) {
                    return 0;
                }
            }
            return g(qQAppInterface, new TroopEssenceMsgItem.b(msgRecord.getPeerUin(), msgRecord.getMsgSeq(), com.tencent.mobileqq.service.message.s.g(msgRecord.getMsgRandom())));
        }
        return 0;
    }

    public static int g(QQAppInterface qQAppInterface, TroopEssenceMsgItem.b bVar) {
        int i3;
        String l3 = Long.toString(bVar.f295271a);
        c cVar = (c) am.s().x(668);
        if (cVar != null && cVar.a(l3)) {
            TroopInfo findTroopInfo = ((ITroopInfoService) qQAppInterface.getRuntimeService(ITroopInfoService.class)).findTroopInfo(l3);
            if (findTroopInfo == null) {
                QLog.i("TroopEssenceUtil", 1, "troopInfo is null, troopUin=" + l3);
                return 0;
            }
            boolean isOwnerOrAdmin = findTroopInfo.isOwnerOrAdmin(qQAppInterface.getCurrentUin());
            GroupExt groupExt = findTroopInfo.groupExt;
            if (groupExt == null) {
                i3 = 0;
            } else {
                i3 = groupExt.essentialMsgPrivilege;
            }
            TroopEssenceMsgManager troopEssenceMsgManager = (TroopEssenceMsgManager) qQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
            troopEssenceMsgManager.c0(bVar);
            TroopEssenceMsgItem.c C = troopEssenceMsgManager.C(bVar);
            QLog.i("TroopEssenceUtil", 1, "isAdminOrOwner=" + isOwnerOrAdmin + ", privilege=" + i3 + ", troopUin=" + l3 + ", value=" + C);
            if (C != null && C.f295274a == 1 && TextUtils.equals(C.f295275b, qQAppInterface.getCurrentUin())) {
                return 2;
            }
            if (i3 != 2 && !isOwnerOrAdmin) {
                return 0;
            }
            return h(C);
        }
        QLog.i("TroopEssenceUtil", 1, "configData=" + cVar);
        return 0;
    }

    private static int h(@Nullable TroopEssenceMsgItem.c cVar) {
        if (cVar != null && cVar.f295274a != 2) {
            return 2;
        }
        return 1;
    }

    private static String i(String str, long j3, int i3) {
        if (str == null) {
            return "";
        }
        return "https://qun.qq.com/essence/index?gc=$GC&seq=$SEQ&random=$RANDOM&_wv=3&_wwv=128&_wvx=2&_wvxBclr=f5f6fa".replace("$GC", str).replace("$SEQ", String.valueOf(j3)).replace("$RANDOM", String.valueOf(i3));
    }

    public static int j(AIOMsgItem aIOMsgItem) {
        com.tencent.qqnt.msg.data.a parseArkModel;
        FileElement fileElement;
        int msgType = aIOMsgItem.getMsgRecord().getMsgType();
        if (com.tencent.mobileqq.aio.utils.d.Z(aIOMsgItem) || msgType == 9) {
            return 1;
        }
        if (com.tencent.mobileqq.aio.utils.d.E(aIOMsgItem)) {
            return 2;
        }
        if (com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem)) {
            return 3;
        }
        if (com.tencent.mobileqq.aio.utils.d.x(aIOMsgItem)) {
            MsgElement firstTypeElement = aIOMsgItem.getFirstTypeElement(3);
            if (firstTypeElement != null) {
                fileElement = firstTypeElement.getFileElement();
            } else {
                fileElement = null;
            }
            if (fileElement != null && fileElement.getSubElementType().intValue() == 1) {
                return 4;
            }
            if (fileElement != null && fileElement.getSubElementType().intValue() == 2) {
                return 5;
            }
            return 6;
        }
        if (com.tencent.mobileqq.aio.utils.d.u(aIOMsgItem.getMsgRecord()) && (parseArkModel = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).parseArkModel(aIOMsgItem)) != null) {
            String d16 = parseArkModel.d();
            if (n(d16, parseArkModel.m())) {
                return 7;
            }
            if ("com.tencent.structmsg".equals(d16)) {
                return 8;
            }
        }
        return 9;
    }

    public static int k(MsgRecord msgRecord) {
        if (com.tencent.mobileqq.aio.utils.d.a0(msgRecord) || msgRecord.getMsgType() == 9) {
            return 1;
        }
        if (MsgExtKt.M(msgRecord)) {
            return 3;
        }
        if (msgRecord.getMsgType() == 2 || msgRecord.getMsgType() == 31) {
            return 2;
        }
        if (msgRecord.getMsgType() == 3) {
            if (msgRecord.getSubMsgType() == 1) {
                return 4;
            }
            if (msgRecord.getSubMsgType() == 2) {
                return 5;
            }
            return 6;
        }
        if (!com.tencent.mobileqq.aio.utils.d.u(msgRecord)) {
            return 9;
        }
        if (msgRecord.getSubMsgType() == 1 || msgRecord.getSubMsgType() == 2) {
            return 4;
        }
        return 8;
    }

    public static long l(QQAppInterface qQAppInterface, String str) {
        TroopManager troopManager;
        TroopInfo B;
        if (qQAppInterface == null || TextUtils.isEmpty(str) || (troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)) == null || (B = troopManager.B(str)) == null) {
            return 0L;
        }
        return B.dwGroupClassExt;
    }

    public static void m(QQAppInterface qQAppInterface, String str, final String str2, final String str3, @NonNull final com.tencent.mobileqq.troop.e eVar) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str2.equals(qQAppInterface.getCurrentUin())) {
                eVar.a(BaseApplication.getContext().getResources().getString(R.string.f2329475x));
                return;
            } else {
                ac.k0(qQAppInterface, str2, str, ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).q(str), true, null, new com.tencent.mobileqq.troop.e() { // from class: com.tencent.mobileqq.troop.essencemsg.t
                    @Override // com.tencent.mobileqq.troop.e
                    public final void a(String str4) {
                        u.q(str2, str3, eVar, str4);
                    }
                });
                return;
            }
        }
        eVar.a("");
    }

    public static boolean n(String str, String str2) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if ("com.tencent.miniapp_01".equals(str)) {
                    if (jSONObject.has("detail_1") && (optJSONObject3 = jSONObject.optJSONObject("detail_1")) != null) {
                        String optString = optJSONObject3.optString("appid");
                        if (optString.equals(ITeamWorkUtils.TENCENT_DOC_MIMI_APPID) || optString.equals(ITeamWorkUtils.TROOP_FORM_MIMI_APPID)) {
                            return true;
                        }
                    }
                } else if ("com.tencent.miniapp".equals(str)) {
                    if (jSONObject.has("detail") && (optJSONObject2 = jSONObject.optJSONObject("detail")) != null) {
                        String optString2 = optJSONObject2.optString("appid");
                        if (optString2.equals(ITeamWorkUtils.TENCENT_DOC_MIMI_APPID) || optString2.equals(ITeamWorkUtils.TROOP_FORM_MIMI_APPID)) {
                            return true;
                        }
                    }
                } else if ("com.tencent.structmsg".equals(str) && jSONObject.has("news") && (optJSONObject = jSONObject.optJSONObject("news")) != null && optJSONObject.optLong("appid") == ITeamWorkUtils.DOCS_APPID) {
                    return true;
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static boolean o(QQAppInterface qQAppInterface, long j3, long j16, int i3) {
        TroopEssenceMsgManager troopEssenceMsgManager;
        if (qQAppInterface == null || (troopEssenceMsgManager = (TroopEssenceMsgManager) qQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)) == null || !troopEssenceMsgManager.K(new TroopEssenceMsgItem.b(j3, j16, i3))) {
            return false;
        }
        return true;
    }

    public static boolean p(String str, String str2) {
        if (!"com.tencent.structmsg".equals(str) && !n(str, str2)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(String str, String str2, com.tencent.mobileqq.troop.e eVar, String str3) {
        if (!TextUtils.isEmpty(str3) && !str3.equals(str)) {
            str = str3;
        } else if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        eVar.a(str);
    }

    public static void r(QQAppInterface qQAppInterface, String str, long j3, int i3, Context context, int i16) {
        if (!TextUtils.isEmpty(str) && context != null) {
            String i17 = i(str, j3, i3);
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", i17);
            intent.putExtra("webStyle", "noBottomBar");
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            if (context instanceof BaseActivity) {
                ((BaseActivity) context).startActivityForResult(intent, 20008);
            }
            if (i16 == 1) {
                ReportController.o(null, "dc00898", "", str, "0X800B34A", "0X800B34A", 0, 0, String.valueOf(l(qQAppInterface, str)), "", "", "");
                s.h(qQAppInterface, str);
            } else if (i16 == 2) {
                s.l(qQAppInterface, str, false);
                s.m(qQAppInterface, str, false);
            }
        }
    }

    public static void s(QQAppInterface qQAppInterface, TroopEssenceMsgItem troopEssenceMsgItem) {
        boolean z16;
        String str;
        String str2;
        if (qQAppInterface != null && troopEssenceMsgItem != null) {
            long l3 = l(qQAppInterface, Long.toString(troopEssenceMsgItem.troopUin));
            if (!((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(qQAppInterface, Long.toString(troopEssenceMsgItem.troopUin), qQAppInterface.getCurrentUin()) && !TroopUtils.B(qQAppInterface, Long.toString(troopEssenceMsgItem.troopUin), qQAppInterface.getCurrentUin())) {
                z16 = false;
            } else {
                z16 = true;
            }
            int i3 = troopEssenceMsgItem.opType;
            if (i3 == 1) {
                String l16 = Long.toString(troopEssenceMsgItem.troopUin);
                String valueOf = String.valueOf(l3);
                String valueOf2 = String.valueOf(troopEssenceMsgItem.msgType);
                if (z16) {
                    str2 = "1";
                } else {
                    str2 = "2";
                }
                ReportController.o(null, "dc00898", "", l16, "0X800B34B", "0X800B34B", 0, 0, valueOf, valueOf2, str2, "");
                return;
            }
            if (i3 == 2) {
                String l17 = Long.toString(troopEssenceMsgItem.troopUin);
                String valueOf3 = String.valueOf(l3);
                String valueOf4 = String.valueOf(troopEssenceMsgItem.msgType);
                if (z16) {
                    str = "1";
                } else {
                    str = "2";
                }
                ReportController.o(null, "dc00898", "", l17, "0X800B34D", "0X800B34D", 0, 0, valueOf3, valueOf4, str, "");
                s.k(qQAppInterface, troopEssenceMsgItem.troopUin, troopEssenceMsgItem.msgType, true, 2);
            }
        }
    }

    public static void t(MsgRecord msgRecord, int i3, int i16, int i17) {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return;
        }
        TroopEssenceMsgItem troopEssenceMsgItem = new TroopEssenceMsgItem();
        troopEssenceMsgItem.troopUin = msgRecord.getPeerUin();
        troopEssenceMsgItem.msgSeq = msgRecord.getMsgSeq();
        troopEssenceMsgItem.msgRandom = com.tencent.mobileqq.service.message.s.g(msgRecord.getMsgRandom());
        troopEssenceMsgItem.opUin = qQAppInterface.getCurrentUin();
        troopEssenceMsgItem.msgSenderUin = String.valueOf(msgRecord.getSenderUin());
        troopEssenceMsgItem.opType = i16;
        troopEssenceMsgItem.msgType = i3;
        ((TroopEssenceMsgManager) qQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).i0(troopEssenceMsgItem, i17);
        s(qQAppInterface, troopEssenceMsgItem);
    }
}
