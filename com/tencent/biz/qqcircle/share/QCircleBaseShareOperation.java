package com.tencent.biz.qqcircle.share;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager;
import com.tencent.biz.qqcircle.utils.af;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import yb0.r;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class QCircleBaseShareOperation {

    /* renamed from: a, reason: collision with root package name */
    private QCircleShareInfo f92303a;

    /* renamed from: b, reason: collision with root package name */
    private int f92304b;

    /* renamed from: c, reason: collision with root package name */
    private int f92305c;

    /* renamed from: d, reason: collision with root package name */
    private Activity f92306d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleReportBean f92307e;

    /* renamed from: f, reason: collision with root package name */
    private String f92308f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f92309g;

    /* renamed from: h, reason: collision with root package name */
    private String f92310h = "";

    /* renamed from: i, reason: collision with root package name */
    protected String f92311i = "";

    /* renamed from: j, reason: collision with root package name */
    protected int f92312j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f92313k;

    /* renamed from: l, reason: collision with root package name */
    public int f92314l;

    /* renamed from: m, reason: collision with root package name */
    private QCircleRichMediaDownLoadManager.e f92315m;

    /* renamed from: n, reason: collision with root package name */
    private wb0.a f92316n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f92317o;

    /* renamed from: p, reason: collision with root package name */
    private int f92318p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f92319q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f92320r;

    /* renamed from: s, reason: collision with root package name */
    private FrameLayout f92321s;

    /* renamed from: t, reason: collision with root package name */
    private View f92322t;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private QCircleShareInfo f92324a;

        /* renamed from: b, reason: collision with root package name */
        private int f92325b;

        /* renamed from: c, reason: collision with root package name */
        private int f92326c;

        /* renamed from: d, reason: collision with root package name */
        private Activity f92327d;

        /* renamed from: e, reason: collision with root package name */
        private QCircleReportBean f92328e;

        /* renamed from: f, reason: collision with root package name */
        private String f92329f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f92330g = null;

        /* renamed from: h, reason: collision with root package name */
        private String f92331h;

        /* renamed from: i, reason: collision with root package name */
        private String f92332i;

        /* renamed from: j, reason: collision with root package name */
        private int f92333j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f92334k;

        /* renamed from: l, reason: collision with root package name */
        private int f92335l;

        /* renamed from: m, reason: collision with root package name */
        private QCircleRichMediaDownLoadManager.e f92336m;

        /* renamed from: n, reason: collision with root package name */
        private wb0.a f92337n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f92338o;

        /* renamed from: p, reason: collision with root package name */
        private int f92339p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f92340q;

        public a A(QCircleReportBean qCircleReportBean) {
            this.f92328e = qCircleReportBean;
            return this;
        }

        public a B(QCircleShareInfo qCircleShareInfo) {
            this.f92324a = qCircleShareInfo;
            return this;
        }

        public a C(int i3) {
            this.f92335l = i3;
            return this;
        }

        public a D(boolean z16) {
            this.f92340q = z16;
            return this;
        }

        public a E(int i3) {
            this.f92339p = i3;
            return this;
        }

        public a F(String str) {
            this.f92332i = str;
            return this;
        }

        public a G(String str) {
            this.f92331h = str;
            return this;
        }

        public a H(int i3) {
            this.f92333j = i3;
            return this;
        }

        public a I(boolean z16) {
            this.f92334k = z16;
            return this;
        }

        public QCircleBaseShareOperation r(int i3) {
            return h.a(this, i3);
        }

        public a s(Activity activity) {
            this.f92327d = activity;
            return this;
        }

        public a t(wb0.a aVar) {
            this.f92337n = aVar;
            return this;
        }

        public a u(QCircleRichMediaDownLoadManager.e eVar) {
            this.f92336m = eVar;
            return this;
        }

        public a v(boolean z16) {
            this.f92338o = z16;
            return this;
        }

        public a w(int i3) {
            this.f92325b = i3;
            return this;
        }

        public a x(int i3) {
            this.f92326c = i3;
            return this;
        }

        public a y(String str) {
            this.f92329f = str;
            return this;
        }

        public a z(byte[] bArr) {
            this.f92330g = bArr;
            return this;
        }
    }

    public QCircleBaseShareOperation(a aVar) {
        K(aVar);
    }

    private boolean c() {
        r.a j3 = r.h().j();
        if (j3 == null) {
            return false;
        }
        cj.b(true, j3.b(), j3.a());
        return true;
    }

    private String i() {
        QCircleReportBean q16 = q();
        if (q16 == null) {
            return "";
        }
        String dtPageId = q16.getDtPageId();
        if (TextUtils.isEmpty(dtPageId)) {
            return "";
        }
        return dtPageId;
    }

    private wb0.c l() {
        return new wb0.c() { // from class: com.tencent.biz.qqcircle.share.a
            @Override // wb0.c
            public final void a() {
                QCircleBaseShareOperation.this.G();
            }

            @Override // wb0.c
            public /* synthetic */ void b() {
                wb0.b.a(this);
            }
        };
    }

    private String r() {
        if (t() == null) {
            return "other";
        }
        if (t().type == 0) {
            return "feed";
        }
        if (t().type != 12 && t().type != 13) {
            return "other";
        }
        return "cmt";
    }

    public static Intent s(Activity activity, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (activity != null && feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.share != null) {
            Intent intent = new Intent(activity.getApplicationContext(), (Class<?>) QCircleHostClassHelper.getForwardRecentActivityClass());
            intent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_TYPE(), QCircleHostConstants.ForwardType.SEND_QCIRCLE_ARK());
            intent.putExtra(QCircleHostConstants.AppConstants.Key.SHARE_REQ_TYPE(), QCircleHostConstants.AppConstants.Value.SHARE_REQ_TYPE_JOIN_GUILD());
            intent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_DISPLAY_ARK(), true);
            String str = feedCloudMeta$StFeed.share.shareCardInfo.get();
            if (TextUtils.isEmpty(str)) {
                return intent;
            }
            try {
                JSONObject jSONObject = new JSONObject(RichTextAtParser.changeAT2PlainText(str));
                String optString = jSONObject.optString("app");
                String optString2 = jSONObject.optString("ver");
                String optString3 = jSONObject.optString("view");
                String optString4 = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
                String optString5 = jSONObject.optString("prompt");
                String optString6 = jSONObject.optString(DownloadInfo.spKey_Config);
                String optString7 = jSONObject.optString("desc");
                String optString8 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
                intent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_NAME(), optString);
                intent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_VIEW(), optString3);
                intent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_VER(), optString2);
                intent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_PROMPT(), optString5);
                intent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_META(), optString4);
                intent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_CONFIG(), optString6);
                intent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_DESC(), optString7);
                if (!TextUtils.isEmpty(optString4) && optString4.contains("\"isAIO\":1")) {
                    optString4 = optString4.replace("\"isAIO\":1", "\"isAIO\":0");
                }
                intent.putExtras(HostDataTransUtils.getArkDialogZipArgs(optString, optString3, optString2, optString4));
                intent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_BIZSRC(), optString8);
            } catch (JSONException e16) {
                e16.printStackTrace();
                QLog.d("QFSSharePart", 1, "getShareArkIntent  exception message: " + e16.getMessage());
            }
            return intent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean A() {
        if (t() == null) {
            return false;
        }
        if (t().type != 4 && t().type != 5 && t().type != 6 && t().type != 8) {
            return false;
        }
        return true;
    }

    public boolean B() {
        return this.f92319q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean C(int i3) {
        if (i3 == m()) {
            return true;
        }
        return false;
    }

    public boolean D() {
        return this.f92313k;
    }

    public void E() {
        if (y()) {
            b();
        } else {
            G();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int F() {
        if (t() == null) {
            return 0;
        }
        int i3 = t().type;
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 != 6) {
                    if (i3 != 8) {
                        return 0;
                    }
                    return 118;
                }
                return 47;
            }
            return 48;
        }
        return 46;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void G();

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(int i3, int i16, QCircleExtraTypeInfo qCircleExtraTypeInfo, String str) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (qCircleExtraTypeInfo != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed) != null) {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed)).setActionType(i3).setSubActionType(i16).setToUin(qCircleExtraTypeInfo.mFeed.poster.f398463id.get()).setPosition(qCircleExtraTypeInfo.mDataPosition).setPlayScene(qCircleExtraTypeInfo.mPlayScene).setExt1(str).setPageId(m()).setfpageid(n()).setFirstFeedId(w20.a.j().h()));
            return;
        }
        QLog.e("QCircleReportHelper_QFSSharePart", 1, "extraTypeInfo is null or lost feed,actionType:" + i3 + ",subActionType:" + i16);
    }

    public void I(boolean z16) {
        this.f92320r = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(String str) {
        QLog.d(str, 1, "build " + str + " error, check the building params");
    }

    public void K(a aVar) {
        this.f92303a = aVar.f92324a;
        this.f92304b = aVar.f92325b;
        this.f92305c = aVar.f92326c;
        this.f92306d = aVar.f92327d;
        this.f92307e = aVar.f92328e;
        this.f92308f = aVar.f92329f;
        this.f92309g = aVar.f92330g;
        this.f92310h = aVar.f92331h;
        this.f92311i = aVar.f92332i;
        this.f92312j = aVar.f92333j;
        this.f92313k = aVar.f92334k;
        this.f92314l = aVar.f92335l;
        this.f92315m = aVar.f92336m;
        this.f92316n = aVar.f92337n;
        this.f92317o = aVar.f92338o;
        this.f92318p = aVar.f92339p;
        this.f92319q = aVar.f92340q;
    }

    public void b() {
        if (r.h().r(t())) {
            QLog.d("QFSSharePart", 1, "[beforeOperate] needRequestShareData");
            r.h().t(t(), h(), l());
            return;
        }
        if (r.h().d(t())) {
            QLog.d("QFSSharePart", 1, "[beforeOperate] isRequesting");
            wb0.a aVar = this.f92316n;
            if (aVar != null) {
                aVar.d();
            }
            if (y() && t() != null && t().feed != null) {
                r.h().b(af.a(t().feed.f398449id.get()), l());
                return;
            }
            return;
        }
        if (c()) {
            QLog.d("QFSSharePart", 1, "[beforeOperate] isNetworkRspErrorInfo");
            r.h().g();
        } else {
            QLog.d("QFSSharePart", 1, "[beforeOperate] realOperate");
            G();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str, String str2) {
        e(str, str2, "em_xsj_sharepanel");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str, String str2, String str3) {
        int i3;
        String str4;
        if (t() != null && t().feedBlockData != null && t().feed != null) {
            int i16 = 1;
            QLog.i("QFSSharePart", 1, "dtReportCustomShareReport actionType = " + str + " , shareTarget = " + str2);
            final Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(t().feedBlockData));
            if (t().extraTypeInfo != null) {
                i3 = t().extraTypeInfo.mDataPosition + 1;
            } else {
                i3 = -1;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3));
            buildElementParams.put("xsj_target_qq", this.f92311i);
            buildElementParams.put("xsj_action_type", str);
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            buildElementParams.put("xsj_topic_page_source", t().feedTagPageFromType);
            buildElementParams.put("xsj_topic_id", t().tagId);
            if (w20.a.j().k() > 0) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().k()));
            }
            if (!TextUtils.isEmpty(str2)) {
                buildElementParams.put("xsj_share_target", str2);
            }
            if (g() != null) {
                buildElementParams.putAll(g());
            }
            if (this.f92321s == null || this.f92322t == null) {
                this.f92321s = new FrameLayout(f());
                View view = new View(f());
                this.f92322t = view;
                this.f92321s.addView(view);
            }
            if (t().albumId != 0) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, String.valueOf(t().albumId));
                t().source = 2;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHAREPANEL_SOURCE, Integer.valueOf(t().source));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_BUTTON_TYPE, t().shareButtonType);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_FROM, t().shareFrom);
            buildElementParams.put("xsj_custom_pgid", i());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REF_LOCATION, Integer.valueOf(t().source));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_SHOW_AD, Integer.valueOf(t().hadAdBanner));
            if (QCircleHostGlobalInfo.isEnableMultiShare()) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHAREPANEL_STYLE, "multiple");
            } else {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHAREPANEL_STYLE, QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD);
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.SHARE_CONTENT_TYPE, r());
            if (t().source == 8) {
                if (t().comment != null) {
                    str4 = t().comment.f398447id.get();
                } else {
                    str4 = "";
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, str4);
                if (t().reply == null) {
                    i16 = 0;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_REPLY, Integer.valueOf(i16));
            }
            if (!TextUtils.isEmpty(this.f92303a.materialType)) {
                buildElementParams.put("xsj_material_type", this.f92303a.materialType);
            }
            if (!TextUtils.isEmpty(this.f92303a.materialId)) {
                buildElementParams.put("xsj_material_id", this.f92303a.materialId);
            }
            QLog.i("QFSSharePart", 2, "dtReportCustomReport... materialType:" + this.f92303a.materialType + " materialId:" + this.f92303a.materialId);
            VideoReport.setPageId(this.f92321s, q().getDtPageId());
            VideoReport.setElementId(this.f92322t, str3);
            if (VideoReport.getPageInfo() != null) {
                VideoReport.setLogicParent(this.f92322t, VideoReport.getPageInfo().pageView);
            }
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.share.QCircleBaseShareOperation.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoReport.reportEvent("ev_xsj_sharepanel_action", QCircleBaseShareOperation.this.f92322t, buildElementParams);
                }
            });
            return;
        }
        J("QFSSharePart");
    }

    public Activity f() {
        return this.f92306d;
    }

    protected Map<String, Object> g() {
        return null;
    }

    public wb0.a h() {
        return this.f92316n;
    }

    public String j() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QCircleShareInfo qCircleShareInfo = this.f92303a;
        if (qCircleShareInfo != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null) {
            return feedCloudMeta$StFeed.f398449id.get();
        }
        return "";
    }

    public QCircleRichMediaDownLoadManager.e k() {
        return this.f92315m;
    }

    public int m() {
        return this.f92304b;
    }

    public int n() {
        return this.f92305c;
    }

    public String o() {
        return this.f92308f;
    }

    public byte[] p() {
        return this.f92309g;
    }

    public QCircleReportBean q() {
        return this.f92307e;
    }

    public QCircleShareInfo t() {
        return this.f92303a;
    }

    public int u() {
        return this.f92318p;
    }

    public String v() {
        return this.f92311i;
    }

    public String w() {
        return this.f92310h;
    }

    public int x() {
        return this.f92312j;
    }

    protected abstract boolean y();

    public boolean z() {
        return this.f92317o;
    }
}
