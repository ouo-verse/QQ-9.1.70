package com.qzone.business.tianshu;

import android.text.TextUtils;
import com.qzone.business.plusunion.plusoperation.PlusMenuContainerNew;
import com.qzone.business.tianshu.model.QZoneBubbleInfo;
import com.qzone.common.account.LoginData;
import com.qzone.util.ak;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.vip.pb.TianShuAccess;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends b {

    /* renamed from: f, reason: collision with root package name */
    private static volatile c f44857f;

    /* renamed from: b, reason: collision with root package name */
    private long f44858b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f44859c = 0;

    /* renamed from: d, reason: collision with root package name */
    private QZoneBubbleInfo f44860d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<a> f44861e;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void a(QZoneBubbleInfo qZoneBubbleInfo);
    }

    public static c j() {
        if (f44857f == null) {
            synchronized (c.class) {
                if (f44857f == null) {
                    f44857f = new c();
                }
            }
        }
        return f44857f;
    }

    private String m(String str) {
        return "feed_publish_bubble_count_" + str;
    }

    private void r(QZoneBubbleInfo qZoneBubbleInfo, int i3) {
        String str;
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = 309;
        lpReportInfo_pf00064.subactionType = 160;
        lpReportInfo_pf00064.reserves = i3;
        String str2 = "0";
        lpReportInfo_pf00064.reserves5 = "0";
        lpReportInfo_pf00064.reserves6 = qZoneBubbleInfo.getWords();
        if (!QzoneFrame.isNewConciseFragment()) {
            str = "0";
        } else {
            str = "1";
        }
        lpReportInfo_pf00064.reserves8 = str;
        if (QQTheme.isNowSimpleUI()) {
            str2 = "1";
        }
        lpReportInfo_pf00064.reserves9 = str2;
        lpReportInfo_pf00064.reserves10 = "1";
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    private void s(QZoneBubbleInfo qZoneBubbleInfo, int i3) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = 1301;
        lpReportInfo_pf00064.subactionType = i3;
        lpReportInfo_pf00064.reserves3 = qZoneBubbleInfo.getAdPostId() + "";
        lpReportInfo_pf00064.reserves4 = qZoneBubbleInfo.getPublishTag();
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    @Override // com.qzone.business.tianshu.b
    int b() {
        return 0;
    }

    @Override // com.qzone.business.tianshu.b
    void f(int i3) {
        WeakReference<a> weakReference;
        a aVar;
        List<TianShuAccess.MapEntry> list = this.f44856a.argList.get();
        HashMap hashMap = new HashMap();
        for (TianShuAccess.MapEntry mapEntry : list) {
            String str = mapEntry.key.get();
            String str2 = mapEntry.value.get();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                hashMap.put(str, str2);
            }
        }
        if (i3 == 1046) {
            QZoneBubbleInfo qZoneBubbleInfo = new QZoneBubbleInfo(this.f44856a);
            this.f44860d = qZoneBubbleInfo;
            qZoneBubbleInfo.setId(String.valueOf(this.f44856a.iAdId.get()));
            this.f44860d.setAdPostId(i3);
            this.f44860d.setWords((String) hashMap.get("words"));
            long b16 = com.qzone.album.util.o.b((String) hashMap.get("startTime"), 0L);
            this.f44860d.setStartTime(b16);
            long b17 = com.qzone.album.util.o.b((String) hashMap.get("endTime"), 0L);
            this.f44860d.setEndTime(b17);
            this.f44860d.setBackgroundUrl((String) hashMap.get("pic1"));
            this.f44860d.setWordsIsTag(TextUtils.equals((CharSequence) hashMap.get("is_tag"), "1"));
            this.f44860d.setArrowUrl((String) hashMap.get("pic2"));
            this.f44860d.setDifferIconUrl((String) hashMap.get("shaishai_icon"));
            this.f44860d.setPublishTag((String) hashMap.get("shaishai_huati"));
            this.f44860d.setJumpUrl((String) hashMap.get(QZoneDTLoginReporter.SCHEMA));
            PlusMenuContainerNew.setShowTemplateRedDot(this.f44860d.getId(), com.qzone.album.util.o.a((String) hashMap.get("showTemplateRedDot"), 0) == 1, b16, b17);
        } else if (i3 == 1126) {
            QZoneBubbleInfo qZoneBubbleInfo2 = new QZoneBubbleInfo(this.f44856a);
            this.f44860d = qZoneBubbleInfo2;
            qZoneBubbleInfo2.setId(String.valueOf(this.f44856a.iAdId.get()));
            this.f44860d.setAdPostId(i3);
            this.f44860d.setWords((String) hashMap.get("text"));
            this.f44860d.setDifferIconUrl((String) hashMap.get("pic"));
            this.f44860d.setPublishTag((String) hashMap.get("tag"));
            this.f44860d.setPublishTagUin((String) hashMap.get("taguin"));
        }
        if (this.f44860d == null || (weakReference = this.f44861e) == null || (aVar = weakReference.get()) == null) {
            return;
        }
        QLog.w("QZoneFeedPublishTianShuBubbleHelper", 1, "parseBubbleInfo onBubbleInfoUpdate: " + this.f44860d);
        aVar.a(this.f44860d);
    }

    public QZoneBubbleInfo k() {
        return this.f44860d;
    }

    public void o() {
        this.f44858b = System.currentTimeMillis();
        this.f44859c = System.currentTimeMillis();
    }

    public void p(QZoneBubbleInfo qZoneBubbleInfo) {
        if (qZoneBubbleInfo.getAdPostId() == 1046) {
            r(qZoneBubbleInfo, 2);
        } else if (qZoneBubbleInfo.getAdPostId() == 1126) {
            s(qZoneBubbleInfo, 2);
            ak.g(qZoneBubbleInfo.getOriginAdItem(), 138);
        }
    }

    public void q(QZoneBubbleInfo qZoneBubbleInfo) {
        if (qZoneBubbleInfo.getAdPostId() == 1046) {
            r(qZoneBubbleInfo, 1);
        } else if (qZoneBubbleInfo.getAdPostId() == 1126) {
            s(qZoneBubbleInfo, 1);
            ak.g(qZoneBubbleInfo.getOriginAdItem(), 101);
        }
        ak.g(this.f44856a, 101);
    }

    public boolean t() {
        return this.f44858b > 0 && System.currentTimeMillis() - this.f44858b < 180000;
    }

    public static void i() {
        f44857f = null;
    }

    @Override // com.qzone.business.tianshu.b
    List<Integer> c() {
        return Arrays.asList(1046, 1126);
    }

    public void n(QZoneBubbleInfo qZoneBubbleInfo) {
        if (qZoneBubbleInfo != null) {
            u5.b.r0(m(qZoneBubbleInfo.getId()), l(qZoneBubbleInfo) + 1, LoginData.getInstance().getUin());
        }
    }

    public int l(QZoneBubbleInfo qZoneBubbleInfo) {
        if (qZoneBubbleInfo == null) {
            return 0;
        }
        return u5.b.H(m(qZoneBubbleInfo.getId()), 0, LoginData.getInstance().getUin());
    }
}
