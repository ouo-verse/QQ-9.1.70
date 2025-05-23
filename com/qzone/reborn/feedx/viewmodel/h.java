package com.qzone.reborn.feedx.viewmodel;

import NS_MOBILE_FEEDS.cnst.TONGCHENG_ATTACH;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.detail.business.service.QZoneDetailService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class h extends com.qzone.reborn.base.n implements IObserver.main {
    private String E;
    private String F;
    private String G;
    private String H;
    private Map<Integer, String> I;
    protected long J;
    protected int K;
    protected String L;
    private String M;
    private String N;
    private String R;
    private boolean S;
    private String T;
    private String U;
    private boolean V;
    private int W;
    private boolean X;
    private HashMap<String, String> Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f55888a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f55889b0;

    /* renamed from: d0, reason: collision with root package name */
    private int f55891d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f55892e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f55893f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f55894g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f55895h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f55897i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f55898j0;

    /* renamed from: l0, reason: collision with root package name */
    private String f55900l0;

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<UIStateData<BusinessFeedData>> f55901m = new MutableLiveData<>();
    public MutableLiveData<UIStateData<com.qzone.reborn.feedx.bean.a>> C = new MutableLiveData<>();
    private long D = 0;

    /* renamed from: c0, reason: collision with root package name */
    private String f55890c0 = "";

    /* renamed from: k0, reason: collision with root package name */
    private boolean f55899k0 = false;

    /* renamed from: i, reason: collision with root package name */
    QZoneDetailService f55896i = QZoneDetailService.U();
    private Handler P = new a();
    private List<b> Q = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends Handler {
        a() {
        }

        private void a(QZoneResult qZoneResult) {
            Iterator it = h.this.Q.iterator();
            while (it.hasNext()) {
                ((b) it.next()).K6(qZoneResult);
            }
            int i3 = qZoneResult.what;
            if (i3 == 999900) {
                h.this.J2(qZoneResult);
            } else if (i3 == 999927) {
                h.this.I2(qZoneResult, false);
            } else if (i3 == 1000144) {
                h.this.I2(qZoneResult, true);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Iterator it = h.this.Q.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onHandleMessage(message);
            }
            QZoneResult unpack = QZoneResult.unpack(message);
            if (unpack != null) {
                a(unpack);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
        void K6(QZoneResult qZoneResult);

        void onHandleMessage(Message message);
    }

    public h() {
        EventCenter.getInstance().addUIObserver(this, "Detail", 1);
    }

    private boolean B2() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DETAIL_COMMENT_SOFT_ORDER, 1) == 1;
    }

    private void E2(Intent intent) {
        ro.a a16 = ro.a.a(intent);
        if (a16 != null) {
            this.F = a16.c();
        }
        this.K = intent.getIntExtra("appid", 0);
        this.L = intent.getStringExtra(s4.c.CELLID);
        this.M = intent.getStringExtra("subid");
        this.f55898j0 = intent.getBooleanExtra("isTodayInHistoryFeed", false);
        this.J = intent.getLongExtra("uin", 0L);
        if (intent.getLongExtra("targetuin", 0L) != 0) {
            this.J = intent.getLongExtra("targetuin", 0L);
        }
        if (this.J == 0) {
            this.J = intent.getLongExtra("uin_from_main_process", 0L);
        }
        this.Z = intent.getIntExtra("fromTranslucent", 0) != 0;
        this.f55888a0 = intent.getBooleanExtra("frompublicaccount", false);
        this.f55889b0 = intent.getStringExtra("todayinhistoryheader");
        this.f55890c0 = intent.getStringExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY);
        this.f55893f0 = intent.getStringExtra("lloc");
        this.f55900l0 = intent.getStringExtra("bid");
    }

    private void F2(String str) {
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("u");
            String queryParameter2 = Uri.parse(str).getQueryParameter("a");
            String queryParameter3 = Uri.parse(str).getQueryParameter("i");
            if (!TextUtils.isEmpty(queryParameter)) {
                this.J = Long.parseLong(queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                this.L = queryParameter3;
            }
            if (TextUtils.isEmpty(queryParameter2)) {
                queryParameter2 = Uri.parse(str).getQueryParameter("appid");
            }
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            this.K = Integer.parseInt(queryParameter2);
        } catch (Throwable th5) {
            RFWLog.fatal("QZoneFeedxDetailViewModel", 1, th5);
        }
    }

    private void H2(Intent intent) {
        MapParcelable mapParcelable = (MapParcelable) intent.getParcelableExtra("businessparam");
        if (mapParcelable != null) {
            this.I = mapParcelable.getSingleMap();
        }
        try {
            this.f55897i0 = intent.getIntExtra("source", 0);
        } catch (Exception e16) {
            QZLog.w("QZoneFeedxDetailViewModel", "getDataFromIntent:", e16);
        }
        this.W = intent.getIntExtra("from", -1);
        this.N = intent.getStringExtra(QZoneHelper.CIPHERTEXT);
        this.f55894g0 = intent.getStringExtra("mainTitle");
        this.f55895h0 = intent.getStringExtra(QCircleLpReportDc010001.KEY_SUBTYPE);
        this.E = intent.getStringExtra("curlikekey");
        this.D = intent.getLongExtra("feedtime", 0L);
        String stringExtra = intent.getStringExtra("source");
        this.G = stringExtra;
        if (!TextUtils.isEmpty(stringExtra) && this.G.equals("local_city")) {
            this.H = intent.getStringExtra("bypassparam");
        }
        Z1(intent.getExtras());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(QZoneResult qZoneResult, boolean z16) {
        com.qzone.reborn.feedx.bean.a aVar;
        if (qZoneResult == null) {
            QLog.e("QZoneFeedxDetailViewModel", 1, "processDetailCommentRsp: result is null");
            return;
        }
        if (qZoneResult.getSucceed()) {
            Bundle bundle = (Bundle) qZoneResult.getData();
            if (bundle == null) {
                QLog.e("QZoneFeedxDetailViewModel", 1, "processDetailCommentRsp: bundle is null");
                return;
            }
            BusinessFeedData businessFeedData = (BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, BusinessFeedData.STORE_KEY);
            if (businessFeedData == null) {
                QLog.e("QZoneFeedxDetailViewModel", 1, "processDetailCommentRsp: businessDetailData is null");
                return;
            }
            if (z16) {
                aVar = new com.qzone.reborn.feedx.bean.a(businessFeedData.getCommentEssence());
            } else {
                aVar = new com.qzone.reborn.feedx.bean.a(businessFeedData.getCommentInfo());
            }
            QLog.d("QZoneFeedxDetailViewModel", 1, "processDetailCommentRsp  success  | moreCommentInfo = " + aVar + " | hasMore = " + this.f55896i.C + " | hasMoreEssence = " + this.f55896i.E);
            UIStateData<com.qzone.reborn.feedx.bean.a> obtainSuccess = UIStateData.obtainSuccess(false);
            obtainSuccess.setDataList(aVar);
            obtainSuccess.setFinish(A2() ^ true);
            this.C.setValue(obtainSuccess);
            return;
        }
        QLog.d("QZoneFeedxDetailViewModel", 1, "processDetailCommentRsp  error | code = " + qZoneResult.getReturnCode() + " | msg = " + qZoneResult.getMessage());
        UIStateData<com.qzone.reborn.feedx.bean.a> obtainError = UIStateData.obtainError(qZoneResult.getMessage());
        obtainError.setRetCode((long) qZoneResult.getReturnCode());
        obtainError.setFinish(true);
        this.C.setValue(obtainError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2(QZoneResult qZoneResult) {
        if (qZoneResult.getSucceed()) {
            Bundle bundle = (Bundle) qZoneResult.getData();
            if (bundle == null) {
                QLog.e("QZoneFeedxDetailViewModel", 1, "processDetailRsp: bundle is null");
                return;
            }
            BusinessFeedData businessFeedData = (BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, BusinessFeedData.STORE_KEY);
            N2(businessFeedData);
            t2();
            if (this.f55899k0) {
                e.f55883a.d(c2(), businessFeedData);
                return;
            }
            return;
        }
        UIStateData<BusinessFeedData> obtainError = UIStateData.obtainError(qZoneResult.getMessage());
        obtainError.setRetCode(qZoneResult.getReturnCode());
        obtainError.setFinish(true);
        this.f55901m.setValue(obtainError);
    }

    private void Q1() {
        BusinessFeedData b16;
        if (TextUtils.isEmpty(c2()) || (b16 = e.f55883a.b(c2())) == null) {
            return;
        }
        RFWLog.d("QZoneFeedxDetailViewModel", RFWLog.USR, "checkDetailCache, getFeedCacheKey: " + c2() + ", feedData: " + b16.hashCode());
        N2(b16);
    }

    private void R1() {
        if (this.I == null) {
            this.I = new HashMap();
        }
        if (this.D > 0) {
            this.I.put(42, String.valueOf(this.D));
        }
        if (TextUtils.isEmpty(this.f55893f0)) {
            return;
        }
        this.I.put(2, this.f55893f0);
    }

    private String c2() {
        return this.K + "_" + this.L + "_" + this.M + "_" + this.f55900l0;
    }

    public boolean A2() {
        QZoneDetailService qZoneDetailService = this.f55896i;
        return qZoneDetailService != null && (qZoneDetailService.C > 0 || qZoneDetailService.E > 0);
    }

    public boolean C2() {
        return !TextUtils.isEmpty(this.f55889b0);
    }

    public void D2() {
        QLog.d("QZoneFeedxDetailViewModel", 1, "loadMoreComment   | mDetailService.hasMore = " + this.f55896i.C + " | mDetailService.hasMoreEssence = " + this.f55896i.E + " | mDetailService.isLoadingMoreComment = " + this.f55896i.f46826d);
        QZoneDetailService qZoneDetailService = this.f55896i;
        if (qZoneDetailService.C > 0 && !qZoneDetailService.f46826d) {
            R1();
            QZoneDetailService qZoneDetailService2 = this.f55896i;
            qZoneDetailService2.a0(this.J, this.K, this.L, this.M, qZoneDetailService2.f46831m, 29, this.I, 1048578, false, true, this.P);
        } else {
            if (qZoneDetailService.E <= 0 || qZoneDetailService.f46826d) {
                return;
            }
            R1();
            QZoneDetailService qZoneDetailService3 = this.f55896i;
            qZoneDetailService3.b0(this.J, this.K, this.L, this.M, qZoneDetailService3.D, 29, this.I, 1048579, false, true, this.P);
        }
    }

    @Override // com.qzone.reborn.base.n
    public void L1() {
        EventCenter.getInstance().removeObserver(this);
    }

    public void L2(String str) {
        this.L = str;
    }

    public void M2(boolean z16) {
        this.S = z16;
    }

    public void P1(b bVar) {
        this.Q.add(bVar);
    }

    public void S1() {
        this.f55896i.J();
    }

    public int T1() {
        return this.K;
    }

    public String U1() {
        return this.L;
    }

    public BusinessFeedData W1() {
        return this.f55896i.Q();
    }

    public BusinessFeedData X1() {
        if (this.f55901m.getValue() != null) {
            return this.f55901m.getValue().getData();
        }
        return this.f55896i.R();
    }

    public QZoneDetailService b2() {
        return this.f55896i;
    }

    public String d2() {
        return this.U;
    }

    public String e2() {
        return this.R;
    }

    public int f2() {
        return this.W;
    }

    public Handler g2() {
        return this.P;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxDetailViewModel";
    }

    public String h2() {
        return this.G;
    }

    public int i2() {
        return this.f55891d0;
    }

    public String j2() {
        return this.f55893f0;
    }

    public String k2() {
        return this.f55894g0;
    }

    public String l2() {
        return this.f55890c0;
    }

    public int m2() {
        return this.f55897i0;
    }

    public String n2() {
        return this.M;
    }

    public String o2() {
        return this.f55895h0;
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("Detail".equals(event.source.getName()) && event.what == 1) {
            N2(this.f55896i.R());
            if (this.f55899k0) {
                e.f55883a.d(c2(), this.f55896i.R());
            }
        }
    }

    public int p2() {
        int i3 = this.W;
        if (i3 == -1) {
            return -1;
        }
        if (i3 == 0) {
            return 312;
        }
        return i3 == 2 ? 302 : -1;
    }

    public String q2() {
        return this.f55889b0;
    }

    public long r2() {
        return this.J;
    }

    public boolean u2() {
        return this.f55892e0;
    }

    public boolean v2() {
        return this.S;
    }

    public boolean w2() {
        return this.f55888a0;
    }

    public boolean x2() {
        return this.X || this.Z || QQBrowserActivity.class.getSimpleName().equals(this.f55890c0);
    }

    public boolean y2() {
        return this.f55898j0;
    }

    public boolean z2() {
        return this.Z;
    }

    public void K2() {
        if (this.X) {
            this.f55896i.Z(this.Y, this.P, this.F);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("curlikekey", this.E);
        R1();
        if (TextUtils.isEmpty(this.F) && !TextUtils.isEmpty(this.G) && !TextUtils.isEmpty(this.H)) {
            hashMap.put(TONGCHENG_ATTACH.value, this.H);
        }
        this.f55896i.X(this.J, this.K, this.L, this.M, this.I, this.P, this.F, hashMap, B2(), this.N);
    }

    private void Z1(Bundle bundle) {
        if (bundle == null) {
            QLog.e("QZoneFeedxDetailViewModel", 1, "getDataForFeed: bundle is null");
            return;
        }
        this.R = bundle.getString("feedskey");
        BusinessFeedData businessFeedData = (BusinessFeedData) com.qzone.reborn.feedx.util.m.a("extra_key_parcelable_feed_for_detail");
        if (businessFeedData != null) {
            this.f55896i.A0(businessFeedData, bundle.getString(s4.c.UGCKEY));
            this.T = businessFeedData.getFeedCommInfo().clientkey;
            this.U = businessFeedData.getFeedCommInfo().feedsid;
            this.S = businessFeedData.getFeedCommInfo().isTopFeed();
            this.V = businessFeedData.getLocalInfo().isReal();
            N2(businessFeedData);
            return;
        }
        this.f55899k0 = true;
        Q1();
    }

    private void a2(Bundle bundle) {
        if (bundle == null) {
            QLog.e("QZoneFeedxDetailViewModel", 1, "getDataForQQJump: bundle is null");
            return;
        }
        this.Y = new HashMap<>();
        for (String str : bundle.keySet()) {
            this.Y.put(str, String.valueOf(bundle.get(str)));
        }
        this.f55891d0 = bundle.getInt(QZoneHelper.QZoneAppConstants.JUMP_TO_DETAIL_FROM_QQ_WHAT, -1);
        String string = bundle.getString("cell_operation.qq_url");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        F2(string);
    }

    public void G2(Intent intent) {
        if (intent == null) {
            QLog.e("QZoneFeedxDetailViewModel", 1, "parseIntent: intent is null");
            return;
        }
        E2(intent);
        this.X = intent.getIntExtra("mqqflag", 0) == 1;
        boolean booleanExtra = intent.getBooleanExtra("qzone.sourceFrom", false);
        this.f55892e0 = booleanExtra;
        if (this.X) {
            a2(intent.getExtras());
            this.f55899k0 = true;
            Q1();
        } else {
            if (booleanExtra) {
                s2(intent.getExtras());
                this.f55899k0 = true;
                Q1();
                return;
            }
            H2(intent);
        }
    }

    public void N2(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            QLog.e("QZoneFeedxDetailViewModel", 1, "updateDetailData: businessDetailData is null");
            return;
        }
        if (!businessFeedData.hasCalculate) {
            com.qzone.adapter.feedcomponent.d.w(businessFeedData);
        }
        UIStateData<BusinessFeedData> obtainSuccess = UIStateData.obtainSuccess(false);
        obtainSuccess.setDataList(businessFeedData);
        obtainSuccess.setFinish(true);
        this.f55901m.setValue(obtainSuccess);
        if (TextUtils.isEmpty(ef.b.a(businessFeedData))) {
            return;
        }
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.c(ef.b.a(businessFeedData), businessFeedData.cellLikeInfo), true);
        af.b bVar = new af.b(ef.b.a(businessFeedData), businessFeedData.getCommentInfoV2());
        bVar.e(true);
        ze.a.a().initOrUpdateGlobalState((ze.a) bVar, true);
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.d(ef.b.a(businessFeedData), businessFeedData.getVisitorInfo()), true);
    }

    private void s2(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.K = 7035;
        this.L = bundle.getString("qzone.cellid");
        this.J = bundle.getLong("qzone.favorOwner");
    }

    protected void t2() {
    }
}
