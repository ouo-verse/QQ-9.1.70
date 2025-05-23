package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import org.light.utils.GsonUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ArkMsgUtils {
    private static volatile Boolean sIsXmlToArkEnabled;

    public static MessageForArkApp convertMultiStructMrToArkMr(MessageForStructing messageForStructing) {
        AbsStructMsg absStructMsg;
        ArkAppMessage convertMultiStructMsgToArkMsg;
        if (messageForStructing == null || (absStructMsg = messageForStructing.structingMsg) == null || !"viewMultiMsg".equals(absStructMsg.mMsgAction) || (convertMultiStructMsgToArkMsg = convertMultiStructMsgToArkMsg((AbsShareMsg) messageForStructing.structingMsg)) == null) {
            return null;
        }
        return q.u((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), messageForStructing.frienduin, messageForStructing.senderuin, messageForStructing.istroop, convertMultiStructMsgToArkMsg);
    }

    public static ArkAppMessage convertMultiStructMsgToArkMsg(AbsShareMsg absShareMsg) {
        if (absShareMsg != null && "viewMultiMsg".equals(absShareMsg.mMsgAction)) {
            ArkAppMessage arkAppMessage = new ArkAppMessage();
            try {
                arkAppMessage.appName = "com.tencent.multimsg";
                String str = absShareMsg.mMsgBrief;
                arkAppMessage.appDesc = str;
                arkAppMessage.appView = "contact";
                arkAppMessage.appMinVersion = "0.0.0.5";
                arkAppMessage.promptText = str;
                cb1.c cVar = new cb1.c();
                fillArkMultiMsgMeta(absShareMsg.getStructMsgItemLists(), cVar, absShareMsg);
                arkAppMessage.metaList = GsonUtils.obj2Json(cVar);
                ArkAppMessage.Config config = new ArkAppMessage.Config();
                config.autoSize = 1;
                config.forward = 1;
                config.type = "normal";
                config.round = 1;
                config.width = 300;
                arkAppMessage.config = config.toString();
            } catch (Exception e16) {
                QLog.d("ArkMsgUtils", 1, "convertStructMsgToArkMsg err: ", e16);
            }
            return arkAppMessage;
        }
        return null;
    }

    private static void fillArkMultiMsgMeta(List<AbsStructMsgElement> list, cb1.c cVar, AbsShareMsg absShareMsg) {
        if (list != null && cVar != null && !list.isEmpty()) {
            if (cVar.detail == null) {
                cVar.detail = new cb1.a();
            }
            cb1.a aVar = cVar.detail;
            for (AbsStructMsgElement absStructMsgElement : list) {
                if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.a) {
                    Iterator<AbsStructMsgElement> it = ((com.tencent.mobileqq.structmsg.a) absStructMsgElement).U0.iterator();
                    while (it.hasNext()) {
                        AbsStructMsgElement next = it.next();
                        if (next instanceof StructMsgItemTitle) {
                            StructMsgItemTitle structMsgItemTitle = (StructMsgItemTitle) next;
                            if (!TextUtils.isEmpty(structMsgItemTitle.X0)) {
                                if (TextUtils.isEmpty(aVar.source)) {
                                    aVar.source = structMsgItemTitle.X0;
                                } else {
                                    cb1.b bVar = new cb1.b();
                                    bVar.text = ((com.tencent.mobileqq.structmsg.b) next).X0;
                                    aVar.news.add(bVar);
                                }
                            }
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(absShareMsg.mResid)) {
                aVar.resid = absShareMsg.mResid;
            }
            long j3 = absShareMsg.uniseq;
            if (j3 != 0) {
                aVar.uniseq = String.valueOf(j3);
            }
            if (!TextUtils.isEmpty(absShareMsg.mContentSummary)) {
                aVar.summary = absShareMsg.mContentSummary;
            }
        }
    }

    public static String getAppIdFromMeta(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if ("appid".equals(str2)) {
                    return jSONObject.optString("appid", "");
                }
                Object opt = jSONObject.opt(str2);
                if ((opt instanceof JSONObject) && ((JSONObject) opt).has("appid")) {
                    return ((JSONObject) opt).optString("appid", "");
                }
            }
            return "";
        } catch (Exception e16) {
            QLog.e("ArkMsgUtils", 1, "arkMessage getAppIdFromMeta error : " + e16.getMessage());
            return "";
        }
    }

    public static String getMetaFromArkMsgRecord(MsgRecord msgRecord) {
        com.tencent.qqnt.msg.data.a parseArkMsgModelFromMsgRecord = parseArkMsgModelFromMsgRecord(msgRecord);
        if (parseArkMsgModelFromMsgRecord != null) {
            return parseArkMsgModelFromMsgRecord.m();
        }
        return "";
    }

    public static String getMusicAppId(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("music");
            if (optJSONObject == null) {
                return "";
            }
            return optJSONObject.optString("appid");
        } catch (Exception e16) {
            QLog.e("ArkMsgUtils", 1, e16, new Object[0]);
            return "";
        }
    }

    public static String getMusicTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("music");
            if (optJSONObject == null) {
                return "";
            }
            return optJSONObject.optString("title");
        } catch (Exception e16) {
            QLog.e("ArkMsgUtils", 1, e16, new Object[0]);
            return "";
        }
    }

    public static String getNewsAppId(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("news");
            if (optJSONObject == null) {
                return "";
            }
            return optJSONObject.optString("appid");
        } catch (Exception e16) {
            QLog.e("ArkMsgUtils", 1, e16, new Object[0]);
            return "";
        }
    }

    public static String getNewsTitle(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("news");
            if (optJSONObject == null) {
                return "";
            }
            return optJSONObject.optString("title");
        } catch (Exception e16) {
            QLog.e("ArkMsgUtils", 1, e16, new Object[0]);
            return "";
        }
    }

    public static boolean isFailHandleEnabled() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("qq_multi_msg_fail_handle_enabled", true);
    }

    public static boolean isFromSdkShare(com.tencent.qqnt.msg.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        String d16 = aVar.d();
        String e16 = aVar.e();
        if ("com.tencent.structmsg".equals(d16)) {
            if ("music".equals(e16)) {
                return !TextUtils.isEmpty(getMusicAppId(aVar.m()));
            }
            if ("news".equals(e16)) {
                return !TextUtils.isEmpty(getNewsAppId(aVar.m()));
            }
        }
        return false;
    }

    public static boolean isMultiMsg(ArkAppMessage arkAppMessage) {
        return (arkAppMessage == null || TextUtils.isEmpty(arkAppMessage.appName) || !"com.tencent.multimsg".equals(arkAppMessage.appName) || TextUtils.isEmpty(arkAppMessage.appView) || !"contact".equals(arkAppMessage.appView)) ? false : true;
    }

    public static boolean isShareRobotArkMsg(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals("com.tencent.contact.lua") || !str2.equals("contact")) {
            return false;
        }
        return true;
    }

    public static boolean isXmlToArkEnabled() {
        if (sIsXmlToArkEnabled != null) {
            return sIsXmlToArkEnabled.booleanValue();
        }
        sIsXmlToArkEnabled = Boolean.valueOf(((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("is_struct_msg_xml_to_ark_enabled", false));
        return sIsXmlToArkEnabled.booleanValue();
    }

    public static String optResIdFromMeta(ArkAppMessage arkAppMessage) {
        String str;
        cb1.a aVar;
        if (arkAppMessage == null) {
            return "";
        }
        if (!TextUtils.isEmpty(arkAppMessage.resId)) {
            return arkAppMessage.resId;
        }
        if (TextUtils.isEmpty(arkAppMessage.metaList)) {
            return "";
        }
        try {
            cb1.c cVar = (cb1.c) GsonUtils.json2Obj(arkAppMessage.metaList, cb1.c.class);
            if (cVar == null || (aVar = cVar.detail) == null) {
                str = "";
            } else {
                str = aVar.resid;
            }
            arkAppMessage.resId = str;
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static com.tencent.qqnt.msg.data.a parseArkMsgModelFromMsgRecord(MsgRecord msgRecord) {
        ArrayList<MsgElement> elements;
        ArkElement arkElement;
        if (msgRecord == null || (elements = msgRecord.getElements()) == null || elements.isEmpty() || (arkElement = elements.get(elements.size() - 1).getArkElement()) == null) {
            return null;
        }
        String bytesData = arkElement.getBytesData();
        com.tencent.qqnt.msg.data.a aVar = new com.tencent.qqnt.msg.data.a();
        aVar.o(bytesData);
        return aVar;
    }

    public static boolean shouldShowBorderInSetSize(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return isShareRobotArkMsg(str, str2);
        }
        return false;
    }

    public static boolean isMultiMsg(String str, String str2) {
        return "com.tencent.multimsg".equals(str) && "contact".equals(str2);
    }
}
