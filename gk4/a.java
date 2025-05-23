package gk4;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qqlive.callback.pendant.PendantInfoCallBack;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.pendant.PendantViewData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.pendant.data.PendantDataModel;
import com.tencent.timi.game.liveroom.impl.room.pendant.util.AudienceFullScreenWatchTimer;
import com.tencent.timi.game.liveroom.impl.room.pendant.webview.QQLivePendantWebViewDelegate;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;

/* compiled from: P */
@Deprecated
/* loaded from: classes26.dex */
public class a implements AudienceFullScreenWatchTimer.b {
    protected FrameLayout C;
    protected boolean D;
    private String I;

    /* renamed from: d, reason: collision with root package name */
    protected int f402360d;

    /* renamed from: e, reason: collision with root package name */
    protected long f402361e;

    /* renamed from: f, reason: collision with root package name */
    private long f402362f;

    /* renamed from: i, reason: collision with root package name */
    private long f402364i;

    /* renamed from: m, reason: collision with root package name */
    protected QQLivePendantWebViewDelegate f402365m;

    /* renamed from: h, reason: collision with root package name */
    private final PendantDataModel f402363h = new PendantDataModel();
    protected boolean E = false;
    private boolean F = true;
    private AudienceFullScreenWatchTimer G = null;
    private boolean H = false;
    private final PendantInfoCallBack J = new C10384a();

    /* compiled from: P */
    /* renamed from: gk4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C10384a implements PendantInfoCallBack {
        C10384a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.pendant.PendantInfoCallBack
        public void onFailed(boolean z16, int i3, String str) {
            AegisLogger.i("Pendant|qqlive_pendant_manager", "PendantInfoCallBack.onFailed", "fetch pendant info fail, isTimeout=" + z16 + ", code=" + i3 + ", msg=" + str);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.pendant.PendantInfoCallBack
        public void onRecv(ArrayList<PendantViewData> arrayList) {
            if (System.currentTimeMillis() - a.this.f402364i >= 5000) {
                a.this.f402364i = System.currentTimeMillis();
                a.this.d(arrayList);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            AegisLogger.i("Pendant|qqlive_pendant_manager", "PendantInfoCallBack.onFailed", "fetch pendant info fail, errorCode=" + i3 + ", errorMsg=" + str);
        }
    }

    private String f(String str) {
        if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        return ContainerUtils.FIELD_DELIMITER;
    }

    private void i() {
        if (com.tencent.mobileqq.qqlive.sail.c.f272176a.J(this.f402361e, 1)) {
            AegisLogger.i("Pendant|qqlive_pendant_manager", "initAudienceWatchTimer", "no watchTimer");
            return;
        }
        AudienceFullScreenWatchTimer audienceFullScreenWatchTimer = new AudienceFullScreenWatchTimer();
        this.G = audienceFullScreenWatchTimer;
        audienceFullScreenWatchTimer.e(this);
    }

    private void j() {
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 == null) {
            return;
        }
        this.I = c16.l().get("auto_open_pendant_id");
        if (AegisLogger.isDevelopLevel()) {
            AegisLogger.i("Pendant|qqlive_pendant_manager", "initAutoPendantId id=" + this.I);
        }
    }

    private void l(boolean z16) {
        boolean z17;
        AudienceFullScreenWatchTimer audienceFullScreenWatchTimer = this.G;
        if (audienceFullScreenWatchTimer == null) {
            return;
        }
        if (this.H && !z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            audienceFullScreenWatchTimer.f();
            return;
        }
        audienceFullScreenWatchTimer.g();
        QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate = this.f402365m;
        if (qQLivePendantWebViewDelegate != null) {
            qQLivePendantWebViewDelegate.v();
        }
    }

    private void o(ViewGroup viewGroup, QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate) {
        if (qQLivePendantWebViewDelegate != null) {
            qQLivePendantWebViewDelegate.w();
        }
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.pendant.util.AudienceFullScreenWatchTimer.b
    public void a(long j3) {
        QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate = this.f402365m;
        if (qQLivePendantWebViewDelegate != null) {
            qQLivePendantWebViewDelegate.t(j3, this.H);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(ArrayList<PendantViewData> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            AegisLogger.i("Pendant|qqlive_pendant_manager", "buildPendants", "fetch pendant info, size=" + arrayList.size());
            boolean z16 = false;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                PendantViewData pendantViewData = arrayList.get(i3);
                if (pendantViewData == null) {
                    AegisLogger.i("Pendant|qqlive_pendant_manager", "buildPendants", "pendant info is null");
                } else {
                    AegisLogger.i("Pendant|qqlive_pendant_manager", "buildPendants", "pendant info : " + pendantViewData);
                    if (!k(pendantViewData)) {
                        AegisLogger.i("Pendant|qqlive_pendant_manager", "buildPendants", "pendant info is not Valid");
                    } else {
                        n(pendantViewData);
                        if (4 == pendantViewData.viewPosition) {
                            QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate = this.f402365m;
                            if (qQLivePendantWebViewDelegate == null) {
                                this.f402365m = e(pendantViewData, this.C);
                            } else {
                                qQLivePendantWebViewDelegate.y(pendantViewData, this.C);
                            }
                            if (this.D) {
                                v(this.C, false);
                                z16 = false;
                            } else {
                                if (!this.E) {
                                    v(this.C, true);
                                }
                                z16 = true;
                            }
                        }
                    }
                }
            }
            if (!z16 && this.f402365m != null) {
                p();
                return;
            }
            return;
        }
        AegisLogger.i("Pendant|qqlive_pendant_manager", "buildPendants", "fetch pendant info onRecv, size=0");
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QQLivePendantWebViewDelegate e(PendantViewData pendantViewData, FrameLayout frameLayout) {
        if (pendantViewData != null && frameLayout != null && com.tencent.timi.game.utils.b.d(frameLayout) != null) {
            frameLayout.setVisibility(0);
            QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate = new QQLivePendantWebViewDelegate();
            qQLivePendantWebViewDelegate.p(frameLayout, pendantViewData);
            return qQLivePendantWebViewDelegate;
        }
        return null;
    }

    public void g(boolean z16) {
        AegisLogger.i("Pendant|qqlive_pendant_manager", "hideRightBottomPendent", "hidden=" + z16);
        this.D = z16;
        FrameLayout frameLayout = this.C;
        if (frameLayout != null) {
            v(frameLayout, !z16);
        }
    }

    public void h() {
        AegisLogger.i("Pendant|qqlive_pendant_manager", "init");
        this.f402364i = 0L;
        j();
        AegisLogger.i("Pendant|qqlive_pendant_manager", "init", "startFetchPendantInfo");
        this.f402363h.n(this.J);
        this.f402363h.i(this.J);
        this.f402363h.o(this.f402362f, this.f402361e);
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean k(PendantViewData pendantViewData) {
        if (pendantViewData == null || pendantViewData.viewWidthDp <= 0.0f || pendantViewData.viewHeightDp <= 0.0f || pendantViewData.webData == null || TextUtils.isEmpty(pendantViewData.pendantUrl)) {
            return false;
        }
        return true;
    }

    public void m(boolean z16) {
        this.H = z16;
        QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate = this.f402365m;
        if (qQLivePendantWebViewDelegate != null) {
            qQLivePendantWebViewDelegate.u(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(PendantViewData pendantViewData) {
        if (pendantViewData != null && !TextUtils.isEmpty(pendantViewData.pendantUrl)) {
            StringBuilder sb5 = new StringBuilder(pendantViewData.pendantUrl);
            if (!sb5.toString().contains("room_type")) {
                sb5.append(f(sb5.toString()));
                sb5.append("room_type=");
                sb5.append(this.f402360d);
            }
            if (!TextUtils.isEmpty(this.I) && pendantViewData.getWebData().contains(this.I)) {
                sb5.append(f(sb5.toString()));
                sb5.append("auto_open_pendant_id");
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(this.I);
            }
            pendantViewData.pendantUrl = sb5.toString();
            if (AegisLogger.isDevelopLevel()) {
                AegisLogger.i("Pendant|qqlive_pendant_manager", "buildPendants", "pendantUrl rebuild=" + pendantViewData.pendantUrl);
            }
        }
    }

    public void p() {
        if (this.f402365m != null) {
            AegisLogger.i("Pendant|qqlive_pendant_manager", "releaseRightBottomPendant", "remove right_bottom pendant");
        }
        o(this.C, this.f402365m);
        this.f402365m = null;
    }

    public void q(boolean z16) {
        AegisLogger.i("Pendant|qqlive_pendant_manager", "setAllVisible", "show=" + z16 + ", mShouldHideRightBottom " + this.D);
        if (z16) {
            this.E = false;
        }
        this.F = z16;
        if (!this.D) {
            v(this.C, z16);
        }
        l(z16);
    }

    public a r(long j3) {
        this.f402362f = j3;
        return this;
    }

    public a s(FrameLayout frameLayout) {
        this.C = frameLayout;
        return this;
    }

    public a t(long j3) {
        this.f402361e = j3;
        return this;
    }

    public a u(int i3) {
        this.f402360d = i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(FrameLayout frameLayout, boolean z16) {
        int i3;
        if (frameLayout != null) {
            if (this.F && z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            frameLayout.setVisibility(i3);
        }
    }

    public void w() {
        QLog.i("Pendant|qqlive_pendant_manager", 1, "unInit");
        this.f402364i = 0L;
        p();
        this.C = null;
        this.D = false;
        this.f402363h.n(this.J);
        this.f402363h.k();
        AudienceFullScreenWatchTimer audienceFullScreenWatchTimer = this.G;
        if (audienceFullScreenWatchTimer != null) {
            audienceFullScreenWatchTimer.h();
            this.G = null;
        }
    }
}
