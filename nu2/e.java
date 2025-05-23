package nu2;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qq.taf.jce.JceInputStream;
import com.squareup.wire.AnyMessage;
import com.tencent.mobileqq.mini.servlet.CloudStorageServlet;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdVideoHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.report.funnel.videofunnel.QAdVideoFunnelUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.report.funnel.videofunnel.funnelconstants.VideoFunnelConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.timer.TimingLogicHandler;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoRequest;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoRequestExtraInfo;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoResponse;
import com.tencent.qqlive.ona.protocol.jce.AdTempletItem;
import com.tencent.qqlive.ona.protocol.jce.InsideVideoSkipAdInfo;
import com.tencent.tvideo.protocol.pb.ADVideoInfo;
import com.tencent.tvideo.protocol.pb.AdType;
import com.tencent.tvideo.protocol.pb.DynamicAdProxyRequest;
import com.tencent.tvideo.protocol.pb.DynamicAdProxyResponse;
import com.tencent.tvideo.protocol.pb.ExtraVideoInfo;
import com.tencent.tvideo.protocol.pb.RequestType;
import com.tencent.tvideo.protocol.pb.SegmentRewardItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import ou2.a;
import pw2.n;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends d implements a.InterfaceC10960a {

    /* renamed from: n, reason: collision with root package name */
    private ArrayList<AdTempletItem> f421312n;

    /* renamed from: o, reason: collision with root package name */
    private InsideVideoSkipAdInfo f421313o;

    /* renamed from: p, reason: collision with root package name */
    private Map<String, String> f421314p;

    /* renamed from: q, reason: collision with root package name */
    private vu2.a f421315q;

    /* renamed from: r, reason: collision with root package name */
    private ExtraVideoInfo f421316r;

    /* renamed from: s, reason: collision with root package name */
    private long f421317s;

    /* renamed from: t, reason: collision with root package name */
    private AdType f421318t;

    /* renamed from: u, reason: collision with root package name */
    private Map<String, String> f421319u;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        static e f421320a = new e();
    }

    private void A(int i3, DynamicAdProxyResponse dynamicAdProxyResponse) {
        AnyMessage anyMessage;
        n.e(this.f421305g, "handleMidResponse");
        wu2.a h16 = new wu2.a().j().h();
        if (dynamicAdProxyResponse != null && (anyMessage = dynamicAdProxyResponse.mid_ad_response) != null && anyMessage.getValue().size() != 0 && i3 == 0) {
            JceInputStream jceInputStream = new JceInputStream(dynamicAdProxyResponse.mid_ad_response.getValue().toByteArray());
            jceInputStream.setServerEncoding("UTF-8");
            AdInsideVideoResponse adInsideVideoResponse = new AdInsideVideoResponse();
            adInsideVideoResponse.readFrom(jceInputStream);
            if (adInsideVideoResponse.errCode != 0) {
                y(i3, h16, adInsideVideoResponse);
                O();
                return;
            }
            this.f421312n = adInsideVideoResponse.videoAdItemList;
            this.f421313o = adInsideVideoResponse.skipAdInfo;
            Q(adInsideVideoResponse.transparentData);
            K();
            List<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> b16 = yu2.e.b(this.f421312n, this.f421303e, false);
            h16.i(4);
            h16.h(QAdVideoFunnelUtil.e(b16));
            wu2.c.i(VideoFunnelConstant.MidReportEvent.AD_MID_RECEIVE_SSP, h16, null, this.f421315q);
            return;
        }
        n.e(this.f421305g, "handleMidResponse return , response is null");
        y(i3, h16, null);
        O();
    }

    private void B(int i3, String str, DynamicAdProxyResponse dynamicAdProxyResponse) {
        n.e(this.f421305g, "handleRewardResponse, requestId = " + str);
        if (dynamicAdProxyResponse != null && i3 == 0) {
            SegmentRewardItem segmentRewardItem = dynamicAdProxyResponse.segment_reward_item;
            n.e(this.f421305g, "handleRewardResponse rewardItem = " + segmentRewardItem);
            if (segmentRewardItem == null || !segmentRewardItem.show_panel) {
                n.e(this.f421305g, "handleRewardResponse no show panel");
                O();
            }
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.g gVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.g();
            gVar.f303620a = str;
            gVar.f303621b = segmentRewardItem;
            n.e("QAdBaseFrameAd", "onReceivedFrameAd");
            J(23, gVar);
            return;
        }
        n.e(this.f421305g, "handleRewardResponse fail, errCode = " + i3);
        O();
    }

    private void D() {
        if (this.f421301c == null) {
            return;
        }
        this.f421316r = new ExtraVideoInfo.a().c(this.f421301c.i()).b(this.f421301c.d()).d(i()).e(k() - this.f421317s).build();
        this.f421317s = k();
    }

    private void E(AdInsideVideoRequest adInsideVideoRequest) {
        if (adInsideVideoRequest == null) {
            return;
        }
        if (adInsideVideoRequest.extraInfo == null) {
            adInsideVideoRequest.extraInfo = new AdInsideVideoRequestExtraInfo();
        }
        n.e(this.f421305g, "initRequestExtraInfo");
        adInsideVideoRequest.extraInfo.transparentData = this.f421314p;
    }

    private synchronized boolean F() {
        boolean z16;
        if (this.f421301c != null && this.f421302d != null) {
            if (this.f421303e != null) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    private boolean G(kt3.j jVar) {
        if (this.f421301c == null && jVar != null) {
            return true;
        }
        if (this.f421301c != null && jVar != null && !TextUtils.equals(this.f421301c.i(), jVar.i())) {
            return true;
        }
        return false;
    }

    private void H(Context context, String str, RequestType requestType) {
        if (context != null && this.f421301c != null) {
            AdInsideVideoRequest I = I(context, str);
            if (I == null) {
                n.e(this.f421305g, "adMidVideoRequest is null");
                return;
            }
            if (this.f421315q == null) {
                vu2.a d16 = wu2.c.d(this.f421300b, str, this.f421301c);
                this.f421315q = d16;
                d16.a("mid_ad_show_type", 2);
                this.f421315q.a(CloudStorageServlet.REQUEST_TYPE, 1);
            }
            this.f421315q.i(str);
            wu2.c.i(VideoFunnelConstant.MidReportEvent.AD_MID_CALL_SDK, null, null, this.f421315q);
            iu2.a w3 = w(context, QAdVideoHelper.c(I, str, this.f421301c.j(), 3));
            wu2.a h16 = new wu2.a().j().h();
            if (w3 != null) {
                n.e(this.f421305g, "loadAd, not need to show ad,  errorCode = " + w3.a());
                h16.i(2);
                h16.g(w3.b());
                wu2.c.i(VideoFunnelConstant.MidReportEvent.AD_MID_SEND_SSP, h16, null, this.f421315q);
                return;
            }
            x(str, new AnyMessage("", ByteString.of(I.toByteArray())), requestType);
            return;
        }
        n.e(this.f421305g, "context is null");
    }

    private AdInsideVideoRequest I(Context context, String str) {
        AdInsideVideoRequest p16 = QAdVideoHelper.p(context, this.f421301c, this.f421303e, this.f421302d, str, 3, null);
        E(p16);
        return p16;
    }

    private void J(int i3, Object obj) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.b bVar = this.f421304f;
        if (bVar == null) {
            n.e(this.f421305g, "mFrameAdListener == null");
            O();
        } else {
            bVar.k(i3, obj);
        }
    }

    private void K() {
        n.e(this.f421305g, "playMidAdIfNeed");
        if (y.h(this.f421312n)) {
            n.e(this.f421305g, "mVideoAdItemList is empty!");
            O();
        } else {
            n.e(this.f421305g, "onReceivedFrameAd, mVideoAdItemList no null");
            J(3, new com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.a(this.f421312n, this.f421315q, this.f421313o));
            L();
        }
    }

    private void L() {
        ArrayList<AdTempletItem> arrayList = this.f421312n;
        if (arrayList == null) {
            return;
        }
        Iterator<AdTempletItem> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().viewType != 3) {
                return;
            }
        }
        this.f421312n = null;
    }

    private void O() {
        q();
        l();
    }

    private void P(DynamicAdProxyResponse dynamicAdProxyResponse) {
        if (dynamicAdProxyResponse != null && dynamicAdProxyResponse.request_interval > 0) {
            n.e(this.f421305g, "request interval = " + dynamicAdProxyResponse.request_interval);
            t(dynamicAdProxyResponse.request_interval);
        }
    }

    private void x(String str, AnyMessage anyMessage, RequestType requestType) {
        if (this.f421301c == null) {
            return;
        }
        ADVideoInfo build = new ADVideoInfo.a().g(this.f421301c.i()).b(this.f421301c.d()).build();
        DynamicAdProxyRequest.a b16 = new DynamicAdProxyRequest.a().d(str).e(requestType).b(this.f421316r);
        Map<String, String> map = this.f421319u;
        if (map == null) {
            map = new HashMap<>();
        }
        new ou2.a().e(b16.f(map).g(this.f421317s).h(build).c(anyMessage).build(), this);
    }

    private void y(int i3, wu2.a aVar, AdInsideVideoResponse adInsideVideoResponse) {
        int i16;
        if (adInsideVideoResponse == null) {
            i16 = 0;
        } else {
            i16 = adInsideVideoResponse.errCode;
        }
        int f16 = wu2.c.f(i3, i16);
        int g16 = wu2.c.g(i3, i16);
        aVar.g(f16);
        aVar.f(g16);
        aVar.i(6);
        wu2.c.i(VideoFunnelConstant.MidReportEvent.AD_MID_RECEIVE_SSP, aVar, null, this.f421315q);
    }

    public static e z() {
        return b.f421320a;
    }

    protected void C(@NonNull kt3.j jVar) {
        n.e(this.f421305g, "handleVideoChangeEvent\uff1a" + jVar.i());
        this.f421309k = true;
        this.f421318t = AdType.AD_TYPE_UNKNOWN;
        M(RequestType.REQUEST_TYPE_VIDEO_START);
    }

    protected synchronized void M(RequestType requestType) {
        Context context;
        n.e(this.f421305g, "requestDynamicAd requestType : " + requestType);
        WeakReference<Context> weakReference = this.f421299a;
        if (weakReference == null) {
            context = null;
        } else {
            context = weakReference.get();
        }
        if (F() && context != null) {
            if (this.f421316r != null) {
                n.e(this.f421305g, "requestDynamicAd  mLastExtraVideoInfo vid = " + this.f421316r.vid + "\uff0c cid = " + this.f421316r.cid + "\uff0c videoLeftInterval = " + this.f421316r.video_left_interval + "\uff0c videoWatchedTime = " + this.f421316r.video_watched_time + ", totalTime = " + k());
            }
            if (this.f421301c != null) {
                n.e(this.f421305g, "requestDynamicAd  currentVideo vid = " + this.f421301c.i() + "\uff0c cid = " + this.f421301c.d());
            }
            String a16 = pw2.b.a();
            AdType adType = this.f421318t;
            if (adType != AdType.AD_TYPE_UNKNOWN && requestType != RequestType.REQUEST_TYPE_VIDEO_START) {
                if (adType == AdType.AD_TYPE_MID) {
                    n.e(this.f421305g, "is MidAd, loadMidAd, requestId = " + a16);
                    H(context, a16, requestType);
                } else {
                    n.e(this.f421305g, "is RewardAd, loadRewardAd, requestId = " + a16);
                    x(a16, null, requestType);
                }
                return;
            }
            n.e(this.f421305g, "first video start, doDynamicProxyRequest");
            x(a16, null, requestType);
            return;
        }
        n.e(this.f421305g, "[frame] [anchor] ad process , load ad , but material not ready,context = " + context + ",mQAdVideoInfo = " + this.f421301c + ",mQAdUserInfo = " + this.f421302d + ",mDefinition = " + this.f421303e);
        s(60000L);
        l();
    }

    public synchronized void N() {
        C(this.f421301c);
    }

    public synchronized void Q(Map<String, String> map) {
        this.f421314p = map;
    }

    public synchronized void R(kt3.j jVar) {
        if (jVar == null) {
            return;
        }
        if (G(jVar)) {
            D();
        }
        this.f421301c = jVar;
    }

    @Override // ou2.a.InterfaceC10960a
    public void b(int i3, boolean z16, DynamicAdProxyRequest dynamicAdProxyRequest, DynamicAdProxyResponse dynamicAdProxyResponse) {
        String str;
        n.e(this.f421305g, "onLoadFinish errCode : " + i3);
        if (dynamicAdProxyResponse == null) {
            n.e(this.f421305g, "onLoadFinish fail, response is null");
            O();
            return;
        }
        if (!dynamicAdProxyResponse.stop_timing) {
            r(true);
        }
        n.e(this.f421305g, "next request dynamic ad interval :" + dynamicAdProxyResponse.request_interval + ",stop_timing = " + dynamicAdProxyResponse.stop_timing + ", adType = " + dynamicAdProxyResponse.ad_type + ", next_ad_type = " + dynamicAdProxyResponse.next_ad_type);
        P(dynamicAdProxyResponse);
        AdType adType = dynamicAdProxyResponse.ad_type;
        if (adType == AdType.AD_TYPE_UNKNOWN) {
            n.e(this.f421305g, "response, no ad, handleStartCount");
            O();
        } else if (adType == AdType.AD_TYPE_MID) {
            A(i3, dynamicAdProxyResponse);
        } else if (adType == AdType.AD_TYPE_SEGMENT_REWARD) {
            if (dynamicAdProxyRequest != null) {
                str = dynamicAdProxyRequest.request_id;
            } else {
                str = "";
            }
            B(i3, str, dynamicAdProxyResponse);
        }
        this.f421318t = dynamicAdProxyResponse.next_ad_type;
        this.f421319u = dynamicAdProxyResponse.strategy_params;
        if (dynamicAdProxyResponse.stop_timing) {
            n.e(this.f421305g, "stop_timing is true, stop request");
            m();
            r(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // nu2.d
    public void h(int i3) {
        super.h(i3);
        if (i3 != 10004) {
            if (i3 == 10005) {
                n.e(this.f421305g, "mid ad end");
                q();
                return;
            }
            return;
        }
        n.e(this.f421305g, "mid ad start");
        this.f421312n = null;
    }

    @Override // nu2.d
    protected TimingLogicHandler j() {
        return new TimingLogicHandler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // nu2.d
    public void l() {
        if (!this.f421308j) {
            return;
        }
        super.l();
    }

    @Override // nu2.d
    public synchronized void p() {
        n.e(this.f421305g, "release");
        super.p();
        this.f421312n = null;
        this.f421313o = null;
    }

    @Override // nu2.d
    protected void v() {
        Context context;
        n.e(this.f421305g, "it is time up to do something");
        m();
        q();
        WeakReference<Context> weakReference = this.f421299a;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (context != null && this.f421301c != null) {
            M(RequestType.REQUEST_TYPE_TIMING);
        } else {
            n.e(this.f421305g, "context is null");
        }
    }

    public iu2.a w(Context context, ju2.a aVar) {
        return zu2.c.a(3).a(context, aVar);
    }

    e() {
        this.f421318t = AdType.AD_TYPE_UNKNOWN;
        this.f421319u = new HashMap();
        this.f421305g = "[QAd]QAdInsideDynamicAdManager" + hashCode();
        u(true, 420000L);
    }
}
