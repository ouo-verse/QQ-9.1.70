package l42;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.pendant.IQQLiveModulePendant;
import com.tencent.mobileqq.icgame.data.pendant.PendantViewData;
import com.tencent.mobileqq.icgame.data.pendant.WebPendantData;
import com.tencent.mobileqq.icgame.room.pendant.webview.f;
import com.tencent.mobileqq.icgame.techreport.d;
import com.tencent.mobileqq.icgame.widget.chat.ChatMessageLayout;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements SimpleEventReceiver {
    private f C;
    private FrameLayout D;
    private f E;
    private FrameLayout F;
    private f H;
    private boolean I;
    private FrameLayout J;

    /* renamed from: d, reason: collision with root package name */
    private int f413829d;

    /* renamed from: e, reason: collision with root package name */
    private long f413830e;

    /* renamed from: f, reason: collision with root package name */
    private long f413831f;

    /* renamed from: h, reason: collision with root package name */
    private String f413832h;

    /* renamed from: i, reason: collision with root package name */
    private IQQLiveModulePendant f413833i;

    /* renamed from: m, reason: collision with root package name */
    private long f413834m;
    private float G = 0.0f;
    private boolean K = true;
    private boolean L = true;
    private z22.a M = new C10705a();

    /* compiled from: P */
    /* renamed from: l42.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C10705a implements z22.a {
        C10705a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            rt0.a.f("ICGamePendant|ICGamePendantManager", "PendantInfoCallBack.onFailed", "fetch pendant info fail, errorCode=" + i3 + ", errorMsg=" + str);
            a aVar = a.this;
            aVar.s(aVar.K, i3, str, null);
            a.this.K = false;
        }

        @Override // z22.a
        public void onRecv(ArrayList<PendantViewData> arrayList) {
            if (System.currentTimeMillis() - a.this.f413834m >= 5000) {
                a.this.f413834m = System.currentTimeMillis();
                a aVar = a.this;
                aVar.s(aVar.K, 0, "", arrayList);
                a.this.g(arrayList);
            }
            a.this.K = false;
        }
    }

    private void D(FrameLayout frameLayout, boolean z16) {
        int i3;
        if (frameLayout != null) {
            if (this.L && z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            frameLayout.setVisibility(i3);
        }
    }

    private void f(com.tencent.mobileqq.icgame.techreport.f fVar) {
        String str = this.f413832h;
        if (str == null) {
            str = "";
        }
        fVar.h(str);
        fVar.b(String.valueOf(this.f413831f));
        fVar.f(String.valueOf(this.f413830e));
        fVar.g(String.valueOf(this.f413829d));
    }

    private f h(PendantViewData pendantViewData, FrameLayout frameLayout) {
        if (pendantViewData != null && frameLayout != null && com.tencent.icgame.game.utils.a.c(frameLayout) != null) {
            frameLayout.setVisibility(0);
            f fVar = new f();
            fVar.g(frameLayout, pendantViewData);
            return fVar;
        }
        return null;
    }

    private String i(String str) {
        if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        return ContainerUtils.FIELD_DELIMITER;
    }

    private boolean l(PendantViewData pendantViewData) {
        WebPendantData webPendantData;
        if (pendantViewData == null || pendantViewData.viewWidth <= 0.0f || pendantViewData.viewHeight <= 0.0f || TextUtils.isEmpty(pendantViewData.version) || pendantViewData.version.compareTo("forDropVersion") == 0 || 1 != pendantViewData.viewType || (webPendantData = pendantViewData.webPendantData) == null || TextUtils.isEmpty(webPendantData.pendantWebUrl) || TextUtils.isEmpty(pendantViewData.webPendantData.pendantWebData)) {
            return false;
        }
        return true;
    }

    private void m() {
        View findViewById = this.J.getRootView().findViewById(R.id.xcx);
        if (findViewById instanceof ChatMessageLayout) {
            ((ChatMessageLayout) findViewById).notifyDataSetChanged();
        }
    }

    private void o() {
        if (this.C != null) {
            rt0.a.f("ICGamePendant|ICGamePendantManager", "releaseLeftTopPendant", "remove left_top pendant");
        }
        p(this.D, this.C);
        this.C = null;
    }

    private void p(ViewGroup viewGroup, f fVar) {
        if (fVar != null) {
            fVar.j();
        }
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
            viewGroup.setVisibility(8);
        }
    }

    private void r() {
        if (this.E != null) {
            rt0.a.f("ICGamePendant|ICGamePendantManager", "releaseRightTopPendant", "remove right_top pendant");
        }
        p(this.F, this.E);
        this.E = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z16, int i3, String str, ArrayList<PendantViewData> arrayList) {
        if (!z16) {
            return;
        }
        com.tencent.mobileqq.icgame.techreport.f fVar = new com.tencent.mobileqq.icgame.techreport.f("ev_icgame_pendant_fetch_result");
        fVar.c(String.valueOf(i3));
        if (str == null) {
            str = "";
        }
        fVar.d(str);
        f(fVar);
        if (arrayList != null) {
            fVar.e(String.valueOf(arrayList.size()));
        } else {
            fVar.e("0");
        }
        d.f(fVar);
    }

    private void t() {
        com.tencent.mobileqq.icgame.techreport.f fVar = new com.tencent.mobileqq.icgame.techreport.f("ev_icgame_pendant_fetch_start");
        f(fVar);
        d.f(fVar);
    }

    public a A(long j3) {
        this.f413830e = j3;
        return this;
    }

    public a B(int i3) {
        this.f413829d = i3;
        return this;
    }

    public a C(String str) {
        this.f413832h = str;
        return this;
    }

    public void E() {
        rt0.a.e("ICGamePendant|ICGamePendantManager", "unInit");
        this.f413834m = 0L;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        o();
        r();
        q();
        this.D = null;
        this.F = null;
        this.J = null;
        this.I = false;
        IQQLiveModulePendant iQQLiveModulePendant = this.f413833i;
        if (iQQLiveModulePendant != null) {
            iQQLiveModulePendant.removeFetchPendantInfoListener(this.M);
            this.f413833i.destroy();
            this.f413833i = null;
        }
    }

    protected void g(ArrayList<PendantViewData> arrayList) {
        boolean z16;
        boolean z17;
        if (arrayList != null && arrayList.size() != 0) {
            rt0.a.f("ICGamePendant|ICGamePendantManager", "buildPendants", "fetch pendant info, size=" + arrayList.size());
            boolean z18 = false;
            boolean z19 = false;
            boolean z26 = false;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                PendantViewData pendantViewData = arrayList.get(i3);
                if (pendantViewData == null) {
                    rt0.a.f("ICGamePendant|ICGamePendantManager", "buildPendants", "pendant info is null");
                } else {
                    rt0.a.f("ICGamePendant|ICGamePendantManager", "buildPendants", "pendant info : " + pendantViewData.toString());
                    if (!l(pendantViewData)) {
                        rt0.a.f("ICGamePendant|ICGamePendantManager", "buildPendants", "pendant info is not Valid");
                    } else {
                        n(pendantViewData);
                        long j3 = pendantViewData.viewId;
                        if (5 == j3) {
                            pendantViewData.location = 0;
                            f fVar = this.C;
                            if (fVar == null) {
                                this.C = h(pendantViewData, this.D);
                            } else {
                                fVar.k(pendantViewData, this.D);
                            }
                            FrameLayout frameLayout = this.D;
                            if (1 == pendantViewData.visible) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            D(frameLayout, z17);
                            z18 = true;
                        } else if (1 == j3) {
                            pendantViewData.location = 1;
                            f fVar2 = this.E;
                            if (fVar2 == null) {
                                this.E = h(pendantViewData, this.F);
                            } else {
                                fVar2.k(pendantViewData, this.F);
                            }
                            FrameLayout frameLayout2 = this.F;
                            if (1 == pendantViewData.visible) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            D(frameLayout2, z16);
                            z19 = true;
                        } else if (4 == j3) {
                            pendantViewData.location = 2;
                            f fVar3 = this.H;
                            if (fVar3 == null) {
                                this.H = h(pendantViewData, this.J);
                            } else {
                                fVar3.k(pendantViewData, this.J);
                            }
                            if (this.I) {
                                D(this.J, false);
                                z26 = false;
                            } else {
                                D(this.J, true);
                                z26 = true;
                            }
                        }
                    }
                }
            }
            if (!z18) {
                o();
            }
            if (!z19) {
                r();
            }
            if (!z26) {
                q();
                m();
                return;
            }
            return;
        }
        rt0.a.f("ICGamePendant|ICGamePendantManager", "buildPendants", "fetch pendant info onRecv, size=0");
        o();
        r();
        q();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<>();
    }

    public void j(boolean z16) {
        rt0.a.f("ICGamePendant|ICGamePendantManager", "hideRightBottomPendent", "hidden=" + z16);
        this.I = z16;
        FrameLayout frameLayout = this.J;
        if (frameLayout != null) {
            D(frameLayout, !z16);
        }
    }

    public void k() {
        rt0.a.e("ICGamePendant|ICGamePendantManager", "init");
        this.f413834m = 0L;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        if (this.f413833i != null) {
            rt0.a.f("ICGamePendant|ICGamePendantManager", "init", "startFetchPendantInfo");
            this.f413833i.removeFetchPendantInfoListener(this.M);
            this.f413833i.addFetchPendantInfoListener(this.M);
            this.f413833i.startFetchPendantInfo(this.f413831f, this.f413830e);
            t();
        }
    }

    protected void n(PendantViewData pendantViewData) {
        WebPendantData webPendantData;
        if (pendantViewData != null && (webPendantData = pendantViewData.webPendantData) != null && !TextUtils.isEmpty(webPendantData.pendantWebUrl)) {
            StringBuilder sb5 = new StringBuilder(pendantViewData.webPendantData.pendantWebUrl);
            if (!sb5.toString().contains("room_type")) {
                sb5.append(i(sb5.toString()));
                sb5.append("room_type=");
                sb5.append(this.f413829d);
            }
            if (!sb5.toString().contains("kk=")) {
                sb5.append(i(sb5.toString()));
                sb5.append("kk=");
                sb5.append(m42.a.d(this.f413831f));
            }
            pendantViewData.webPendantData.pendantWebUrl = sb5.toString();
        }
    }

    public void q() {
        if (this.H != null) {
            rt0.a.f("ICGamePendant|ICGamePendantManager", "releaseRightBottomPendant", "remove right_bottom pendant");
        }
        p(this.J, this.H);
        this.H = null;
    }

    public void u(boolean z16) {
        FrameLayout[] frameLayoutArr;
        rt0.a.f("ICGamePendant|ICGamePendantManager", "setAllVisible", "show=" + z16 + ", mShouldHideRightBottom " + this.I);
        this.L = z16;
        if (this.I) {
            frameLayoutArr = new FrameLayout[]{this.D, this.F};
        } else {
            frameLayoutArr = new FrameLayout[]{this.D, this.F, this.J};
        }
        for (FrameLayout frameLayout : frameLayoutArr) {
            D(frameLayout, z16);
        }
    }

    public a v(long j3) {
        this.f413831f = j3;
        return this;
    }

    public a w(FrameLayout frameLayout) {
        this.D = frameLayout;
        return this;
    }

    public a x(IQQLiveModulePendant iQQLiveModulePendant) {
        this.f413833i = iQQLiveModulePendant;
        return this;
    }

    public a y(FrameLayout frameLayout) {
        this.J = frameLayout;
        return this;
    }

    public a z(FrameLayout frameLayout) {
        this.F = frameLayout;
        return this;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
