package nu2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.BaseMidCountView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdRewardCountDownView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.IQAdRewardMgrListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tvideo.protocol.pb.RewardAdOpenType;
import com.tencent.tvideo.protocol.pb.SegmentRewardItem;
import pw2.n;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j implements com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.a {
    private final ViewGroup C;
    private volatile boolean D = true;
    private final View.OnClickListener E = new View.OnClickListener() { // from class: nu2.i
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            j.this.l(view);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.g f421325d;

    /* renamed from: e, reason: collision with root package name */
    private SegmentRewardItem f421326e;

    /* renamed from: f, reason: collision with root package name */
    private b f421327f;

    /* renamed from: h, reason: collision with root package name */
    private kt3.d f421328h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.e f421329i;

    /* renamed from: m, reason: collision with root package name */
    private final Context f421330m;

    public j(Context context, ViewGroup viewGroup) {
        this.f421330m = context;
        this.C = viewGroup;
    }

    private void f() {
        if (this.f421326e == null) {
            return;
        }
        n.e("[QAd]QAdRewardUnlockImpl", "doLoadRewardView , reward_ad_open_type = " + this.f421326e.ad_open_type);
        if (this.f421326e.ad_open_type == RewardAdOpenType.REWARD_AD_OPEN_TYPE_AUTO_OPEN) {
            this.D = true;
            o(this.f421326e.countdown_time);
        } else {
            r(true, this.f421325d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(int i3, Object[] objArr) {
        if (this.f421327f == null) {
            return;
        }
        n.e("[QAd]QAdRewardUnlockImpl", "handleUnlockCallback, adPlayStatus = " + i3);
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            if (i3 != 11) {
                                if (i3 != 12) {
                                    if (i3 != 15) {
                                        if (i3 == 16) {
                                            this.f421327f.b();
                                        }
                                    } else {
                                        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: nu2.h
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                j.this.k();
                                            }
                                        });
                                    }
                                } else {
                                    this.f421327f.a();
                                }
                            } else {
                                String str = "\u606d\u559c\u89e3\u9501\u6210\u529f\uff0c\u7ee7\u7eed\u89c2\u770b\u7cbe\u5f69\u5185\u5bb9\uff01";
                                if (objArr != null && objArr.length == 1) {
                                    Object obj = objArr[0];
                                    if (obj instanceof String) {
                                        str = (String) obj;
                                    }
                                }
                                this.f421327f.c(str);
                            }
                        } else {
                            this.f421327f.e();
                        }
                    }
                }
            } else {
                this.f421327f.onSuccess();
            }
            this.f421327f.d();
        }
        this.f421327f.onFailed();
    }

    private boolean i(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.f fVar) {
        if (fVar == null) {
            n.e("[QAd]QAdRewardUnlockImpl", "requestId invalid, mSegmentRewardItem = " + this.f421325d);
            return true;
        }
        if (this.f421326e == null) {
            n.e("[QAd]QAdRewardUnlockImpl", "mSegmentRewardItem is null, create new");
            this.f421326e = new SegmentRewardItem.a().f(false).a(1).build();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        n.e("[QAd]QAdRewardUnlockImpl", "reward enter vip click");
        this.f421327f.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f421328h != null) {
            n.e("[QAd]QAdRewardUnlockImpl", "reward onWarnerTipClick");
            this.f421328h.onWarnerTipClick(23);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        n.e("[QAd]QAdRewardUnlockImpl", "onCountDownFinish, notifyShowRewardPanel, needCallback = " + this.D);
        if (this.D) {
            r(true, this.f421325d);
        }
        this.f421329i = null;
    }

    private synchronized void o(long j3) {
        if (j3 <= 0) {
            return;
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.e eVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.e(this.f421330m, 23, this.C, j3, 0L);
        this.f421329i = eVar;
        eVar.n(this);
        this.f421329i.o(this.f421328h);
        this.f421329i.p();
    }

    private synchronized void p() {
        this.f421328h = null;
        this.f421327f = null;
        this.f421329i = null;
    }

    private void r(boolean z16, com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.g gVar) {
        if (this.f421328h != null && gVar != null) {
            n.e("[QAd]QAdRewardUnlockImpl", "notifyShowRewardPanel requestId = " + gVar.f303620a + ",rewardItemWrapper = " + gVar);
            this.f421328h.j(z16, gVar);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.a
    public BaseMidCountView e() {
        if (this.f421330m == null) {
            return null;
        }
        return new QAdRewardCountDownView(this.f421330m, this.f421326e, this.E);
    }

    public synchronized void g(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.f fVar, b bVar) {
        n.e("[QAd]QAdRewardUnlockImpl", "enterRewardAd");
        if (i(fVar)) {
            n.e("[QAd]QAdRewardUnlockImpl", "enterRewardAd fail, rewardOpenParams is null");
            return;
        }
        this.f421327f = bVar;
        fx2.c cVar = new fx2.c(fVar.i());
        cVar.l(fVar.j());
        ex2.a aVar = new ex2.a();
        aVar.f(this.f421326e.adNum);
        cVar.j(aVar);
        cVar.a().put("dynamic_ad_request_id", fVar.h());
        if (!y.i(fVar.g())) {
            cVar.getMVrReportData().d(fVar.g());
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.controller.c cVar2 = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.controller.c(fVar.f());
        cVar2.f(new IQAdRewardMgrListener() { // from class: nu2.g
            @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.IQAdRewardMgrListener
            public final void a(int i3, Object[] objArr) {
                j.this.h(i3, objArr);
            }
        });
        cVar2.e(cVar);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.a
    public void j() {
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: nu2.f
            @Override // java.lang.Runnable
            public final void run() {
                j.this.m();
            }
        });
    }

    public synchronized void n(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.g gVar) {
        n.e("[QAd]QAdRewardUnlockImpl", "loadAd");
        if (gVar == null) {
            n.e("[QAd]QAdRewardUnlockImpl", "mRewardUnlockItem is null");
            p();
            return;
        }
        this.f421325d = gVar;
        SegmentRewardItem segmentRewardItem = gVar.f303621b;
        this.f421326e = segmentRewardItem;
        if (segmentRewardItem == null) {
            n.e("[QAd]QAdRewardUnlockImpl", "mRewardUnlockItem is null");
            p();
        } else if (!segmentRewardItem.show_panel) {
            n.e("[QAd]QAdRewardUnlockImpl", "user has watch permission!");
            r(false, gVar);
        } else {
            f();
        }
    }

    public void q(int i3) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.e eVar = this.f421329i;
        if (eVar == null) {
            return;
        }
        switch (i3) {
            case 1:
            case 3:
                eVar.r();
                return;
            case 2:
            case 4:
            case 5:
            case 6:
                eVar.k();
                return;
            default:
                return;
        }
    }

    public void s() {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.e eVar = this.f421329i;
        if (eVar != null) {
            eVar.m();
            this.f421329i.n(null);
            this.f421329i = null;
        }
    }

    public void t(kt3.d dVar) {
        this.f421328h = dVar;
    }
}
