package com.tencent.icgame.game.liveroom.impl.room.payguide;

import android.app.Activity;
import android.text.TextUtils;
import az0.c;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.icgame.api.ITimiGameApi;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.icgame.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import yv0.e;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UniteDialogManager {

    /* renamed from: a, reason: collision with root package name */
    private int f115459a;

    /* renamed from: b, reason: collision with root package name */
    private long f115460b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f115461c;

    /* renamed from: d, reason: collision with root package name */
    private IQQLiveSsoProxyModule f115462d;

    /* renamed from: e, reason: collision with root package name */
    private lw0.a f115463e;

    /* renamed from: k, reason: collision with root package name */
    private fx0.a f115469k;

    /* renamed from: f, reason: collision with root package name */
    private final IAegisLogApi f115464f = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: g, reason: collision with root package name */
    private List<Runnable> f115465g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private List<Runnable> f115466h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private nw0.a f115467i = new nw0.a();

    /* renamed from: j, reason: collision with root package name */
    private Map<String, String> f115468j = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private boolean f115470l = false;

    /* renamed from: m, reason: collision with root package name */
    private final v22.a f115471m = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements e<c> {
        a() {
        }

        @Override // yv0.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(c cVar) {
            if (cVar != null) {
                UniteDialogManager.this.t(cVar.f27370b);
                az0.a[] aVarArr = cVar.f27369a;
                if (aVarArr == null) {
                    UniteDialogManager.this.f115464f.e("ICGameUnknown|ICGameUniteDialog", 1, "sendReqForShowDialog recv error, activityPopConfs is null");
                    return;
                }
                for (az0.a aVar : aVarArr) {
                    UniteDialogManager.this.f115464f.i("ICGameUnknown|ICGameUniteDialog", 1, "sendReqForShowDialog recv success popConf " + aVar);
                    if (aVar != null) {
                        boolean e16 = mw0.a.e(UniteDialogManager.this.f115460b, aVar.f27361a, aVar.f27366f, aVar.f27365e);
                        if (e16 && aVar.f27362b > 0) {
                            UniteDialogManager.this.m(aVar);
                        } else {
                            UniteDialogManager.this.f115464f.i("ICGameUnknown|ICGameUniteDialog", 1, "isShowAtCurRoom isShow=" + e16 + ", inRoomTime=" + aVar.f27362b);
                        }
                    }
                }
                return;
            }
            UniteDialogManager.this.f115464f.e("ICGameUnknown|ICGameUniteDialog", 1, "sendReqForShowDialog recv error, popConfRsp is null");
        }

        @Override // yv0.e
        public void fail(int i3, String str) {
            UniteDialogManager.this.f115464f.e("ICGameUnknown|ICGameUniteDialog", 1, "sendReqForShowDialog code= " + i3 + ",msg=" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b implements v22.a {
        b() {
        }

        @Override // v22.a
        public void a(GiftMessage giftMessage) {
            if (giftMessage == null) {
                return;
            }
            LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
            if (selfUserInfo == null) {
                UniteDialogManager.this.f115464f.e("ICGameUnknown|ICGameUniteDialog", 1, "none self userInfo");
            } else if (giftMessage.sender == selfUserInfo.uid) {
                UniteDialogManager.this.f115464f.i("ICGameUnknown|ICGameUniteDialog", 1, "receive self gift msg");
                UniteDialogManager.this.k();
            }
        }

        @Override // v22.a
        public void onError(int i3, String str) {
            UniteDialogManager.this.f115464f.e("ICGameUnknown|ICGameUniteDialog", 1, "mReceiveGiftMessageListener code=" + i3 + "msg=" + str);
        }
    }

    public UniteDialogManager(int i3, long j3, IQQLiveSsoProxyModule iQQLiveSsoProxyModule) {
        this.f115459a = i3;
        this.f115460b = j3;
        this.f115462d = iQQLiveSsoProxyModule;
    }

    private void h(az0.a aVar) {
        int i3;
        this.f115468j.put("qqlive_windows_type", String.valueOf(aVar.f27361a));
        Map<String, String> map = this.f115468j;
        if (aVar.f27362b > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        map.put("qqlive_windows_condition", String.valueOf(i3));
        this.f115468j.put("qqlive_windows_value", String.valueOf(aVar.f27362b));
    }

    private void i() {
        String str;
        this.f115468j.put("qqlive_room_id", String.valueOf(this.f115460b));
        long longValue = ((fu0.c) qx0.a.b(fu0.c.class)).K().longValue();
        this.f115468j.put("qqlive_user_id", String.valueOf(longValue));
        IAudienceRoom N = ((fu0.c) qx0.a.b(fu0.c.class)).N(this.f115460b);
        if (N != null) {
            this.f115468j.put("qqlive_anchor_id", String.valueOf(l(N)));
            this.f115468j.put("qqlive_program_id", String.valueOf(N.getRoomInfo().getProgramId()));
            this.f115468j.put("qqlive_enter_id", "" + longValue + "_" + this.f115460b + "_" + N.getEnterRoomTime());
            if (this.f115459a == 0) {
                str = "1";
            } else {
                str = "0";
            }
            this.f115468j.put("qqlive_zhibo_type", str);
        }
    }

    private void j() {
        Iterator<Runnable> it = this.f115466h.iterator();
        while (it.hasNext()) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(it.next());
        }
        this.f115466h.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Iterator<Runnable> it = this.f115465g.iterator();
        while (it.hasNext()) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(it.next());
        }
        this.f115465g.clear();
    }

    private long l(IAudienceRoom iAudienceRoom) {
        LiveInfo roomLiveInfo = iAudienceRoom.getRoomLiveInfo();
        if (roomLiveInfo != null) {
            LiveAnchorInfo liveAnchorInfo = roomLiveInfo.anchorInfo;
            if (liveAnchorInfo != null) {
                return liveAnchorInfo.uid;
            }
            this.f115464f.e("ICGameUnknown|ICGameUniteDialog", 1, "buildCommonReportParams error, anchorInfo is null!");
            return 0L;
        }
        this.f115464f.e("ICGameUnknown|ICGameUniteDialog", 1, "buildCommonReportParams error, getRoomLiveInfo is null!");
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final az0.a aVar) {
        if (aVar.f27363c) {
            ILiveRoomMessage k3 = ((fu0.c) qx0.a.b(fu0.c.class)).k(this.f115460b);
            if (k3 != null) {
                k3.registerReceiveGiftMessageListener(this.f115471m);
            }
            Runnable runnable = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.payguide.UniteDialogManager.2
                @Override // java.lang.Runnable
                public void run() {
                    if (UniteDialogManager.this.n()) {
                        UniteDialogManager.this.w(aVar);
                        mw0.a.f(UniteDialogManager.this.f115460b, aVar.f27361a);
                    }
                }
            };
            ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, aVar.f27362b * 1000);
            this.f115465g.add(runnable);
            return;
        }
        Runnable runnable2 = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.payguide.UniteDialogManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (UniteDialogManager.this.n()) {
                    UniteDialogManager.this.w(aVar);
                    mw0.a.f(UniteDialogManager.this.f115460b, aVar.f27361a);
                }
            }
        };
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable2, aVar.f27362b * 1000);
        this.f115466h.add(runnable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        boolean z16;
        fx0.a aVar = this.f115469k;
        if (aVar != null && aVar.a() && !this.f115470l) {
            z16 = true;
        } else {
            z16 = false;
        }
        rt0.a.f("ICGameUnknown|ICGameUniteDialog", "isCanShowDialog", "canShow=" + z16);
        return z16;
    }

    private String s(az0.a aVar) {
        String str;
        if (TextUtils.isEmpty(aVar.f27364d)) {
            return "";
        }
        String str2 = aVar.f27364d;
        if (str2.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str = str2 + ContainerUtils.FIELD_DELIMITER;
        } else {
            str = str2 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        h(aVar);
        for (Map.Entry<String, String> entry : this.f115468j.entrySet()) {
            str = str + ContainerUtils.FIELD_DELIMITER + entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(long j3) {
        Map<String, String> map = this.f115468j;
        if (map == null) {
            return;
        }
        map.put("qqlive_abtestid", String.valueOf(j3));
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("ev_qqlive_room_experimentid", this.f115468j);
    }

    private void u() {
        lw0.a aVar = new lw0.a();
        this.f115463e = aVar;
        aVar.j(this.f115462d);
        this.f115463e.g(this.f115459a, this.f115460b, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(az0.a aVar) {
        this.f115467i.f(this.f115461c, s(aVar));
    }

    public void o() {
        this.f115467i.c();
    }

    public void p() {
        this.f115467i.d();
    }

    public void q(Activity activity) {
        this.f115461c = activity;
        i();
        u();
    }

    public void r() {
        this.f115467i.a();
        lw0.a aVar = this.f115463e;
        if (aVar != null) {
            aVar.h();
        }
        k();
        j();
        this.f115469k = null;
    }

    public void v(fx0.a aVar) {
        this.f115469k = aVar;
    }
}
