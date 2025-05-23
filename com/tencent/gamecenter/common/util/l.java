package com.tencent.gamecenter.common.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.gamecenter.api.IGameReportApi;
import com.tencent.mobileqq.gamecenter.data.GameReportExtraData;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class l {
    private static String e(MsgRecord msgRecord) {
        ArrayList<MsgElement> elements;
        if (msgRecord != null && (elements = msgRecord.getElements()) != null && elements.size() > 0) {
            MsgElement msgElement = elements.get(0);
            if (msgElement.getElementType() == 10) {
                ArkAppMessage arkAppMessage = new ArkAppMessage();
                arkAppMessage.fromAppXml(msgElement.getArkElement().getBytesData());
                return m(arkAppMessage.metaList);
            }
        }
        return "";
    }

    public static boolean f(RecentBaseData recentBaseData, String str) {
        if (recentBaseData != null && recentBaseData.getRecentUserType() != 0) {
            return false;
        }
        return ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).isGameRobot(str);
    }

    public static boolean g(String str) {
        return f(null, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(String str, boolean z16, int i3, String str2, ArrayList arrayList) {
        String str3;
        String str4;
        String str5;
        if (i3 != 0 || arrayList.size() <= 0) {
            str3 = "";
        } else {
            str3 = e((MsgRecord) arrayList.get(0));
        }
        if (z16) {
            str4 = "61402";
        } else {
            str4 = "104705";
        }
        if (z16) {
            str5 = "913727";
        } else {
            str5 = "913725";
        }
        n(str, str4, str5, "", str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(long j3, Contact contact, final String str, final boolean z16) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.valueOf(j3));
            ((IMsgService) QRoute.api(IMsgService.class)).getMsgsByMsgId(contact, arrayList, new IMsgOperateCallback() { // from class: com.tencent.gamecenter.common.util.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str2, ArrayList arrayList2) {
                    l.h(str, z16, i3, str2, arrayList2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(String str, boolean z16, int i3, String str2, ArrayList arrayList) {
        String str3;
        String str4;
        String str5;
        if (i3 != 0 || arrayList.size() <= 0) {
            str3 = "";
        } else {
            str3 = e((MsgRecord) arrayList.get(0));
        }
        if (z16) {
            str4 = "61402";
        } else {
            str4 = "104705";
        }
        if (z16) {
            str5 = "913726";
        } else {
            str5 = "913724";
        }
        n(str, str4, str5, "", str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(long j3, Contact contact, final String str, final boolean z16) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.valueOf(j3));
            ((IMsgService) QRoute.api(IMsgService.class)).getMsgsByMsgId(contact, arrayList, new IMsgOperateCallback() { // from class: com.tencent.gamecenter.common.util.k
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str2, ArrayList arrayList2) {
                    l.j(str, z16, i3, str2, arrayList2);
                }
            });
        }
    }

    public static String l(ArkAppMessage arkAppMessage) {
        String str;
        if (arkAppMessage != null && (str = arkAppMessage.metaList) != null) {
            return m(str);
        }
        return "";
    }

    public static String m(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TtmlNode.TAG_METADATA);
            if (optJSONObject == null) {
                return "";
            }
            for (String str2 : optJSONObject.optString("report").split(ContainerUtils.FIELD_DELIMITER)) {
                if (str2.split(ContainerUtils.KEY_VALUE_DELIMITER).length == 2) {
                    int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                    if ("adtag".equals(str2.substring(0, indexOf))) {
                        return str2.substring(indexOf + 1);
                    }
                }
            }
            return "";
        } catch (JSONException e16) {
            QLog.e("GameRobotReportUtil", 1, "parseArkAdtag exception=", e16);
            return "";
        }
    }

    public static void n(String str, String str2, String str3, String str4, String str5) {
        GameReportExtraData gameReportExtraData = new GameReportExtraData();
        gameReportExtraData.k(str2);
        gameReportExtraData.m(str);
        gameReportExtraData.n(str4);
        ((IGameReportApi) QRoute.api(IGameReportApi.class)).reportRobot(str3, str5, gameReportExtraData);
    }

    public static void o(String str, String str2, String str3, @Nullable String str4) {
        if (!g(str)) {
            return;
        }
        GameReportExtraData gameReportExtraData = new GameReportExtraData();
        gameReportExtraData.k(str2);
        gameReportExtraData.m(str);
        gameReportExtraData.n(str4);
        ((IGameReportApi) QRoute.api(IGameReportApi.class)).reportRobot(str3, "", gameReportExtraData);
    }

    public static void p(final boolean z16, final Contact contact, final String str, final long j3) {
        if (!TextUtils.isEmpty(str) && g(str)) {
            QLog.d("GameRobotReportUtil", 1, "reportRobotPushClick, isForground=", Boolean.valueOf(z16));
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.common.util.h
                @Override // java.lang.Runnable
                public final void run() {
                    l.i(j3, contact, str, z16);
                }
            }, 32, null, false);
        }
    }

    public static void q(final Contact contact, final String str, final long j3) {
        final boolean z16;
        if (!TextUtils.isEmpty(str) && g(str)) {
            QLog.d("GameRobotReportUtil", 1, "reportRobotPushShow");
            if (Foreground.getResumeActivityCount() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("GameRobotReportUtil", 1, "reportRobotPushShow, isQQForeground=", Boolean.valueOf(z16));
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.common.util.j
                @Override // java.lang.Runnable
                public final void run() {
                    l.k(j3, contact, str, z16);
                }
            }, 32, null, false);
        }
    }
}
