package com.tencent.biz.qqcircle.manager;

import com.tencent.biz.qqcircle.immersive.adapter.n;
import com.tencent.biz.qqcircle.requests.QCircleSetCircleSwitchRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import qqcircle.QQCircleSwitch$SetCircleSwitchRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: g, reason: collision with root package name */
    public static volatile d f91547g;

    /* renamed from: c, reason: collision with root package name */
    private boolean f91550c;

    /* renamed from: d, reason: collision with root package name */
    private String f91551d;

    /* renamed from: a, reason: collision with root package name */
    private int f91548a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f91549b = -1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f91552e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f91553f = false;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleSwitch$SetCircleSwitchRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f91554a;

        a(String str) {
            this.f91554a = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSwitch$SetCircleSwitchRsp qQCircleSwitch$SetCircleSwitchRsp) {
            if (z16 && j3 == 0) {
                QLog.i("QCircleSwitchConfigManager", 1, "onReceive success isBarrageOpen = " + this.f91554a);
                uq3.c.h7("qqcircle", "qqcircle_show_barrage_personal_switch", this.f91554a);
                uq3.k.a().m("sp_key_barrage_enable_new", d.this.f91548a);
                return;
            }
            QLog.e("QCircleSwitchConfigManager", 1, "onReceive setBarrageClosed error retCode = " + j3);
        }
    }

    d() {
    }

    public static d b() {
        if (f91547g == null) {
            synchronized (d.class) {
                if (f91547g == null) {
                    f91547g = new d();
                }
            }
        }
        return f91547g;
    }

    public boolean c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (e(feedCloudMeta$StFeed) && d()) {
            return true;
        }
        return false;
    }

    public boolean d() {
        int i3;
        if (this.f91548a == -1) {
            int e16 = uq3.k.a().e("sp_key_barrage_enable_new", -1);
            QLog.i("QCircleSwitchConfigManager", 1, "[isBarrageOpen]  first time, enable = " + e16);
            if (e16 == -1) {
                this.f91548a = uq3.c.X0("qqcircle", "qqcircle_show_barrage_personal_switch", 1).intValue();
            } else {
                if (e16 == 1) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                this.f91548a = i3;
            }
            QLog.i("QCircleSwitchConfigManager", 1, "[isBarrageOpen]  first time, sBarrageSwitch = " + this.f91548a);
        }
        if (this.f91548a != 1) {
            return false;
        }
        return true;
    }

    public boolean e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        if (n.e(feedCloudMeta$StFeed) != 1003 && feedCloudMeta$StFeed.feedType.get() != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        PBRepeatField<Integer> pBRepeatField = feedCloudMeta$StFeed.opMask2;
        if (pBRepeatField != null && pBRepeatField.get().contains(29)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.f91549b == -1) {
            this.f91549b = uq3.c.X0("qqcircle", "qqcircle_show_barrage_enabled", 1).intValue();
            QLog.i("QCircleSwitchConfigManager", 1, "[isBarrageShow]  first time, isBarrageShow = " + this.f91549b);
        }
        if (this.f91549b == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (this.f91552e != z18 || this.f91553f != z17) {
            QLog.d("QCircleSwitchConfigManager", 1, "[isBarrageShow] SECONDARY_KEY_CIRCLE_BARRAGE_ENABLED isConfigOpened:" + z18 + " | opMask2: " + z17);
            this.f91552e = z18;
            this.f91553f = z17;
        }
        if (!z16 || z17 || !z18) {
            return false;
        }
        return true;
    }

    public void f() {
        this.f91548a = -1;
    }

    public void g(boolean z16, String str) {
        this.f91550c = z16;
        this.f91551d = str;
        QLog.i("QCircleSwitchConfigManager", 1, "share-guide-popup setShowShareGuidePopup , mShowShareGuidePopup = " + this.f91550c + " , mFeedId = " + this.f91551d);
    }

    public void h(boolean z16) {
        this.f91548a = z16 ? 1 : 0;
        String valueOf = String.valueOf(z16 ? 1 : 0);
        QLog.i("QCircleSwitchConfigManager", 1, "setBarrageSwitch , sBarrageSwitch = " + this.f91548a);
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetCircleSwitchRequest("qqcircle", "qqcircle_show_barrage_personal_switch", valueOf), new a(valueOf));
    }
}
