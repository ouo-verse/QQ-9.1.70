package com.tencent.mobileqq.kandian.glue.report;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.a;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import r62.b;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a;

/* compiled from: P */
/* loaded from: classes33.dex */
public class WeishiReportUtil {

    /* renamed from: a, reason: collision with root package name */
    private static long f239849a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static long f239850b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil$4, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MessageForStructing f239866d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f239867e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecentBaseData f239868f;

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            RecentBaseData recentBaseData;
            boolean j3 = WeishiReportUtil.j(this.f239866d);
            b.a put = new b.a(null, null, null, null).put("folder_status", WeishiReportUtil.d(this.f239866d)).put("EnterType", WeishiReportUtil.c(this.f239867e)).put("is_jump_to_video_content", Integer.valueOf(ReadInJoyHelper.z(com.tencent.mobileqq.kandian.biz.common.b.a())));
            if (j3 && (recentBaseData = this.f239868f) != null) {
                put.put("reddot_style", WeishiReportUtil.g(recentBaseData)).put("algorithm_id", WeishiReportUtil.a(this.f239866d));
            }
            if (j3) {
                str = WeishiReportUtil.b(this.f239866d);
                str2 = WeishiReportUtil.h(this.f239866d);
            } else {
                str = "0";
                str2 = "0";
            }
            WeishiReportUtil.k(str, str2, "0X8009291", put.g().b());
        }
    }

    public static MessageForStructing i() {
        return a.f239844a.a();
    }

    public static void k(String str, String str2, String str3, String str4) {
        if (QLog.isColorLevel()) {
            QLog.d("WeishiReportUtil", 2, " " + str3 + "|" + str + "|" + str2 + "|" + str4);
        }
        PublicAccountReportUtils.n(null, "dc01160", "", "", str3, str3, 0, 0, "", str, str2, str4, false);
    }

    public static void m(final int i3, final String str, final String str2, final String str3, final String str4) {
        f239850b = System.currentTimeMillis();
        ReadinjoySPEventReport.d.h(25);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
                attributeList.att_id.set(1);
                attributeList.att_name.set("EnterType");
                attributeList.att_value.set(WeishiReportUtil.e(i3));
                arrayList.add(attributeList);
                oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
                attributeList2.att_id.set(2);
                attributeList2.att_name.set("FolderStatus");
                attributeList2.att_value.set("" + str);
                arrayList.add(attributeList2);
                if (!"1".equals(str)) {
                    oidb_cmd0x80a.AttributeList attributeList3 = new oidb_cmd0x80a.AttributeList();
                    attributeList3.att_id.set(3);
                    attributeList3.att_name.set("StrategyID");
                    attributeList3.att_value.set(str2);
                    arrayList.add(attributeList3);
                    oidb_cmd0x80a.AttributeList attributeList4 = new oidb_cmd0x80a.AttributeList();
                    attributeList4.att_id.set(4);
                    attributeList4.att_name.set("AlgorithmID");
                    attributeList4.att_value.set(str3);
                    arrayList.add(attributeList4);
                    oidb_cmd0x80a.AttributeList attributeList5 = new oidb_cmd0x80a.AttributeList();
                    attributeList5.att_id.set(5);
                    attributeList5.att_name.set("costtime");
                    attributeList5.att_value.set("" + str4);
                    arrayList.add(attributeList5);
                }
                ReadinjoyReportUtils.b(25, arrayList);
            }
        });
    }

    public static void p(final int i3, final String str, final String str2, final String str3, final String str4, final long j3, String str5, boolean z16) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
                attributeList.att_id.set(1);
                attributeList.att_name.set("ExitType");
                attributeList.att_value.set(WeishiReportUtil.e(i3));
                arrayList.add(attributeList);
                oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
                attributeList2.att_id.set(2);
                attributeList2.att_name.set("FolderStatus");
                attributeList2.att_value.set(String.valueOf(str));
                arrayList.add(attributeList2);
                oidb_cmd0x80a.AttributeList attributeList3 = new oidb_cmd0x80a.AttributeList();
                attributeList3.att_id.set(3);
                attributeList3.att_name.set("Time");
                attributeList3.att_value.set(String.valueOf(ReadinjoySPEventReport.I(j3) / 1000));
                arrayList.add(attributeList3);
                if (!"1".equals(str)) {
                    oidb_cmd0x80a.AttributeList attributeList4 = new oidb_cmd0x80a.AttributeList();
                    attributeList4.att_id.set(5);
                    attributeList4.att_name.set("StrategyID");
                    attributeList4.att_value.set(str2);
                    arrayList.add(attributeList4);
                    oidb_cmd0x80a.AttributeList attributeList5 = new oidb_cmd0x80a.AttributeList();
                    attributeList5.att_id.set(6);
                    attributeList5.att_name.set("AlgorithmID");
                    attributeList5.att_value.set(str3);
                    arrayList.add(attributeList5);
                    oidb_cmd0x80a.AttributeList attributeList6 = new oidb_cmd0x80a.AttributeList();
                    attributeList6.att_id.set(7);
                    attributeList6.att_name.set("costtime");
                    attributeList6.att_value.set("" + str4);
                    arrayList.add(attributeList6);
                }
                ReadinjoyReportUtils.b(26, arrayList);
            }
        });
        if (z16) {
            ReadinjoySPEventReport.d.c();
        }
    }

    public static void q(final RecentBaseData recentBaseData, final int i3) {
        final QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        final MessageForStructing a16 = a.f239844a.a();
        if (a16 == null || a16.isread) {
            return;
        }
        String extInfoFromExtStr = a16.getExtInfoFromExtStr("weishi_red_pnt_report");
        if (TextUtils.isEmpty(extInfoFromExtStr) || !"1".equals(extInfoFromExtStr)) {
            a16.saveExtInfoToExtStr("weishi_red_pnt_report", "1");
            f239849a = System.currentTimeMillis();
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    QQMessageFacade messageFacade = QQAppInterface.this.getMessageFacade();
                    MessageForStructing messageForStructing = a16;
                    messageFacade.a1(messageForStructing.frienduin, messageForStructing.istroop, messageForStructing.uniseq, AppConstants.Key.COLUMN_EXT_LONG, Integer.valueOf(messageForStructing.extLong));
                    MessageForStructing messageForStructing2 = a16;
                    if (messageForStructing2.structingMsg == null) {
                        messageForStructing2.parse();
                    }
                    WeishiReportUtil.k(WeishiReportUtil.b(a16), WeishiReportUtil.h(a16), "0X8009290", new b.a(null, null, null, null).put("folder_status", WeishiReportUtil.d(a16)).put("algorithm_id", WeishiReportUtil.a(a16)).put("reddot_style", WeishiReportUtil.g(recentBaseData)).put("is_jump_to_video_content", Integer.valueOf(ReadInJoyHelper.z(com.tencent.mobileqq.kandian.biz.common.b.a()))).put("EnterType", WeishiReportUtil.c(i3)).g().b());
                }
            }, 5, null, false);
        }
    }

    public static void r() {
        String d16 = d(i());
        ArrayList arrayList = new ArrayList();
        oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
        attributeList.att_id.set(1);
        attributeList.att_name.set("FolderStatus");
        attributeList.att_value.set(d16);
        arrayList.add(attributeList);
        ReadinjoyReportUtils.b(27, arrayList);
    }

    public static String a(MessageForStructing messageForStructing) {
        AbsStructMsg absStructMsg;
        if (messageForStructing != null && (absStructMsg = messageForStructing.structingMsg) != null && !TextUtils.isEmpty(absStructMsg.mAlgorithmIds)) {
            return messageForStructing.structingMsg.mAlgorithmIds;
        }
        return "";
    }

    public static String b(MessageForStructing messageForStructing) {
        AbsStructMsg absStructMsg;
        if (messageForStructing != null && (absStructMsg = messageForStructing.structingMsg) != null && !TextUtils.isEmpty(absStructMsg.mArticleIds)) {
            String[] split = messageForStructing.structingMsg.mArticleIds.split("\\|");
            if (split.length > 0) {
                return split[0];
            }
            return "";
        }
        return "";
    }

    public static String d(MessageForStructing messageForStructing) {
        AbsStructMsg absStructMsg;
        if (messageForStructing != null && (absStructMsg = messageForStructing.structingMsg) != null) {
            if (!TextUtils.isEmpty(absStructMsg.reportEventFolderStatusValue)) {
                return messageForStructing.structingMsg.reportEventFolderStatusValue;
            }
            return "2";
        }
        return "1";
    }

    public static String g(RecentBaseData recentBaseData) {
        if (recentBaseData != null) {
            return f(recentBaseData.mUnreadFlag);
        }
        return "";
    }

    public static String h(MessageForStructing messageForStructing) {
        AbsStructMsg absStructMsg;
        if (messageForStructing != null && (absStructMsg = messageForStructing.structingMsg) != null && !TextUtils.isEmpty(absStructMsg.mStrategyIds)) {
            return messageForStructing.structingMsg.mStrategyIds;
        }
        return "";
    }

    public static boolean j(MessageForStructing messageForStructing) {
        return (messageForStructing == null || messageForStructing.structingMsg == null) ? false : true;
    }

    public static void l() {
        m(9, "", "", "", "");
    }

    public static void n() {
        o(9, "", "", "", "", f239850b, "");
    }

    public static String f(int i3) {
        if (i3 == 1) {
            return "1";
        }
        if (i3 == 2) {
            return "0";
        }
        return "";
    }

    public static String c(int i3) {
        if (i3 != 9) {
            return "1";
        }
        return "0";
    }

    public static String e(int i3) {
        if (i3 != 9) {
            return "Other";
        }
        return "MsgTab";
    }

    public static void o(int i3, String str, String str2, String str3, String str4, long j3, String str5) {
        p(i3, str, str2, str3, str4, j3, str5, true);
    }
}
