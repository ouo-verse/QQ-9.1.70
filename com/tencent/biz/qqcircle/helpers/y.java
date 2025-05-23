package com.tencent.biz.qqcircle.helpers;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import java.util.Iterator;
import qqcircle.QQCircleCounter$RedPointInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class y {

    /* renamed from: p, reason: collision with root package name */
    private static volatile y f84672p;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f84673a;

    /* renamed from: b, reason: collision with root package name */
    private int f84674b = -1;

    /* renamed from: c, reason: collision with root package name */
    private boolean f84675c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f84676d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f84677e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f84678f;

    /* renamed from: g, reason: collision with root package name */
    private String f84679g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f84680h;

    /* renamed from: i, reason: collision with root package name */
    private String f84681i;

    /* renamed from: j, reason: collision with root package name */
    private String f84682j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f84683k;

    /* renamed from: l, reason: collision with root package name */
    private QQCircleCounter$RedPointInfo f84684l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f84685m;

    /* renamed from: n, reason: collision with root package name */
    private int f84686n;

    /* renamed from: o, reason: collision with root package name */
    private long f84687o;

    private static boolean b(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Iterator<FeedCloudCommon$Entry> it = qQCircleCounter$RedPointInfo.extInfo.mapInfo.get().iterator();
        while (it.hasNext()) {
            if (it.next().key.get().equals("shoudNotRefresh")) {
                return true;
            }
        }
        return false;
    }

    public static QQCircleCounter$RedPointInfo e(Context context) {
        if (context == null) {
            return new QQCircleCounter$RedPointInfo();
        }
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(context);
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            String str = qCircleInitBean.getSchemeAttrs().get("xsj_main_entrance");
            if (QCircleDaTongConstant.ElementParamValue.QQ_MAIN_TAB.equals(str)) {
                return QCircleHostRedPointHelper.getQQMainTabOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
            }
            if (QCircleDaTongConstant.ElementParamValue.QQ_UPDATES_TAB.equals(str)) {
                return QCircleHostRedPointHelper.getQQUpdatesTabOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
            }
            if (QCircleDaTongConstant.ElementParamValue.QQ_UPDATES_TAB_SECOND.equals(str)) {
                return QCircleHostRedPointHelper.getQQUpdatesTabOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
            }
            return new QQCircleCounter$RedPointInfo();
        }
        return new QQCircleCounter$RedPointInfo();
    }

    public static y g() {
        if (f84672p == null) {
            synchronized (y.class) {
                if (f84672p == null) {
                    f84672p = new y();
                }
            }
        }
        return f84672p;
    }

    public static QQCircleCounter$RedPointInfo i() {
        return QCircleHostRedPointHelper.getQQMainTabOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
    }

    public static int j() {
        QQCircleCounter$RedPointInfo i3 = i();
        if (!q(i3)) {
            return 0;
        }
        return i3.tabType.get();
    }

    public static boolean q(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (qQCircleCounter$RedPointInfo == null) {
            return false;
        }
        boolean checkOperateMaskEnabled = QCircleHostUtil.checkOperateMaskEnabled(qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get(), 3);
        String redPointId = EeveeRedpointUtil.getRedPointId(qQCircleCounter$RedPointInfo);
        boolean s16 = s(qQCircleCounter$RedPointInfo, redPointId);
        boolean b16 = b(qQCircleCounter$RedPointInfo);
        QLog.d("QFSTempRedPointHelper", 1, "[isRedPointNeedRefreshFeed] hasRedPoint:" + checkOperateMaskEnabled + ",redPointId:" + redPointId + ",needAlienation:" + s16 + ",combineRedTypes:" + qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get() + ",forbiddenRefresh:" + b16);
        if ((!checkOperateMaskEnabled && !s16) || b16) {
            return false;
        }
        return true;
    }

    private static boolean s(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, String str) {
        if (qQCircleCounter$RedPointInfo == null || !EeveeRedpointUtil.enableNumRedShowAvatar(qQCircleCounter$RedPointInfo) || TextUtils.equals(str, uq3.k.a().h("sp_key_last_insert_red_point_id", ""))) {
            return false;
        }
        return true;
    }

    public static void u() {
        synchronized (y.class) {
            f84672p = new y();
        }
    }

    public void a() {
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo = this.f84684l;
        if (qQCircleCounter$RedPointInfo == null) {
            return;
        }
        String redPointId = EeveeRedpointUtil.getRedPointId(qQCircleCounter$RedPointInfo);
        if (s(qQCircleCounter$RedPointInfo, redPointId)) {
            QLog.d("QFSTempRedPointHelper", 1, "[consumeRedPointNeedAlienationFlag] redPointId: " + redPointId);
            uq3.k.a().p("sp_key_last_insert_red_point_id", redPointId);
        }
    }

    public String c() {
        return this.f84681i;
    }

    public String d() {
        return this.f84682j;
    }

    public byte[] f(boolean z16) {
        byte[] bArr = this.f84676d;
        if (z16) {
            this.f84676d = null;
        }
        return bArr;
    }

    public long h() {
        return this.f84687o;
    }

    public int k() {
        return this.f84686n;
    }

    public int l() {
        return this.f84674b;
    }

    public byte[] m(boolean z16) {
        byte[] bArr = this.f84673a;
        if (z16) {
            this.f84673a = null;
        }
        return bArr;
    }

    public boolean n() {
        return this.f84683k;
    }

    public boolean o() {
        return this.f84678f;
    }

    public boolean p() {
        return this.f84677e;
    }

    public boolean r() {
        return this.f84685m;
    }

    public boolean t() {
        return this.f84675c;
    }

    public void v(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (qQCircleCounter$RedPointInfo == null) {
            return;
        }
        this.f84676d = qQCircleCounter$RedPointInfo.transInfo.get().toByteArray();
        QLog.e("QFSTempRedPointHelper", 1, "saveFriendRedPointInfo extend = " + qQCircleCounter$RedPointInfo.extend.get());
    }

    public void w(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        boolean z16;
        this.f84687o = System.currentTimeMillis();
        if (qQCircleCounter$RedPointInfo == null) {
            return;
        }
        this.f84684l = qQCircleCounter$RedPointInfo;
        this.f84683k = QCircleHostUtil.checkOperateMaskEnabled(qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get(), 3);
        this.f84679g = EeveeRedpointUtil.getRedPointId(qQCircleCounter$RedPointInfo);
        this.f84682j = EeveeRedpointUtil.getRedPointFeedId(qQCircleCounter$RedPointInfo);
        this.f84686n = qQCircleCounter$RedPointInfo.redType.get();
        this.f84681i = EeveeRedpointUtil.getEeveeTraceId(qQCircleCounter$RedPointInfo);
        this.f84674b = qQCircleCounter$RedPointInfo.tabType.get();
        this.f84680h = false;
        boolean s16 = s(qQCircleCounter$RedPointInfo, this.f84679g);
        if ((this.f84683k || s16) && !b(qQCircleCounter$RedPointInfo)) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f84675c = z16;
        if (z16) {
            this.f84673a = qQCircleCounter$RedPointInfo.transInfo.get().toByteArray();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[saveOutLayerRedPointInfo] receive redpoint. appid: ");
        sb5.append(qQCircleCounter$RedPointInfo.appid.get());
        sb5.append(", redType: ");
        sb5.append(qQCircleCounter$RedPointInfo.redType.get());
        sb5.append(", redTotalNum: ");
        sb5.append(qQCircleCounter$RedPointInfo.redTotalNum.get());
        sb5.append(", avatarId: ");
        sb5.append(qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.button.f429299id.get());
        sb5.append(", wording: ");
        sb5.append(qQCircleCounter$RedPointInfo.wording.get());
        sb5.append(", tabTipWording: ");
        sb5.append(qQCircleCounter$RedPointInfo.allPushInfo.tabTipWording.get());
        sb5.append(", combineRedTypes: ");
        sb5.append(qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get());
        sb5.append(", tabType: ");
        sb5.append(qQCircleCounter$RedPointInfo.tabType.get());
        sb5.append(", needAlienation: ");
        sb5.append(s16);
        sb5.append(", hasRedPoint: ");
        sb5.append(this.f84683k);
        sb5.append(", feedId: ");
        sb5.append(this.f84682j);
        sb5.append(", needRefresh: ");
        sb5.append(this.f84675c);
        QLog.d("QFSTempRedPointHelper", 1, sb5);
    }

    public void x(boolean z16) {
        this.f84678f = z16;
    }

    public void y(boolean z16) {
        this.f84680h = z16;
    }

    public void z(boolean z16) {
        if (!uq3.o.S1()) {
            QLog.d("QFSTempRedPointHelper", 1, "[setSmallWindowJumpIntercept] close small window red point intercept");
            return;
        }
        QLog.d("QFSTempRedPointHelper", 1, "[setSmallWindowJumpIntercept] smallWindowJumpIntercept: " + z16);
        this.f84685m = z16;
    }
}
