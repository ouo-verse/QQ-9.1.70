package com.tencent.av.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.TextView;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi;
import com.tencent.av.utils.AVUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseInviteFloatBarUICtr {

    /* renamed from: q, reason: collision with root package name */
    public static int f74723q = 6000;

    /* renamed from: n, reason: collision with root package name */
    VideoInviteFloatBar f74737n;

    /* renamed from: b, reason: collision with root package name */
    VideoAppInterface f74725b = null;

    /* renamed from: c, reason: collision with root package name */
    long f74726c = 0;

    /* renamed from: d, reason: collision with root package name */
    String f74727d = null;

    /* renamed from: e, reason: collision with root package name */
    Bitmap f74728e = null;

    /* renamed from: f, reason: collision with root package name */
    int f74729f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f74730g = 0;

    /* renamed from: h, reason: collision with root package name */
    long f74731h = 0;

    /* renamed from: i, reason: collision with root package name */
    long[] f74732i = null;

    /* renamed from: j, reason: collision with root package name */
    boolean f74733j = false;

    /* renamed from: k, reason: collision with root package name */
    SessionInfo f74734k = null;

    /* renamed from: l, reason: collision with root package name */
    String f74735l = null;

    /* renamed from: m, reason: collision with root package name */
    String f74736m = null;

    /* renamed from: o, reason: collision with root package name */
    o f74738o = new a();

    /* renamed from: p, reason: collision with root package name */
    Runnable f74739p = new Runnable() { // from class: com.tencent.av.ui.BaseInviteFloatBarUICtr.2
        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d(BaseInviteFloatBarUICtr.this.f74724a, 2, "timeout~ mPeerUin:" + BaseInviteFloatBarUICtr.this.f74735l);
            }
            BaseInviteFloatBarUICtr.this.c();
        }
    };

    /* renamed from: a, reason: collision with root package name */
    final String f74724a = getClass().getSimpleName() + "_" + com.tencent.av.utils.e.d();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements o {
        a() {
        }

        @Override // com.tencent.av.ui.o
        public boolean a(Bitmap bitmap, String str) {
            VideoInviteFloatBar videoInviteFloatBar = BaseInviteFloatBarUICtr.this.f74737n;
            if (videoInviteFloatBar != null) {
                videoInviteFloatBar.e(bitmap);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f74739p != null) {
            this.f74725b.M().removeCallbacks(this.f74739p);
            this.f74739p = null;
        }
    }

    public void b() {
        QLog.d(this.f74724a, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ((INTGaInviteFragmentPluginHelperApi) QRoute.api(INTGaInviteFragmentPluginHelperApi.class)).stopRefreshGaFaceUI();
        VideoInviteFloatBar videoInviteFloatBar = this.f74737n;
        if (videoInviteFloatBar != null) {
            videoInviteFloatBar.b();
            this.f74737n = null;
        }
        a();
    }

    abstract void c();

    public void d(String str) {
        TextView textView;
        String valueOf = String.valueOf(this.f74726c);
        VideoInviteFloatBar videoInviteFloatBar = this.f74737n;
        if (videoInviteFloatBar != null) {
            textView = videoInviteFloatBar.a();
        } else {
            textView = null;
        }
        this.f74727d = ((INTGaInviteFragmentPluginHelperApi) QRoute.api(INTGaInviteFragmentPluginHelperApi.class)).genGroupName(this.f74725b, textView, this.f74729f, this.f74730g, valueOf, this.f74732i);
        this.f74728e = this.f74725b.J(this.f74729f, valueOf, null, true, false);
        ((INTGaInviteFragmentPluginHelperApi) QRoute.api(INTGaInviteFragmentPluginHelperApi.class)).refreshGaFaceUI(str, this.f74724a, this.f74725b, this.f74729f, this.f74730g, this.f74726c, this.f74731h, this.f74738o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.w(this.f74724a, 1, "refreshUI, isMultiCall[" + AVUtil.o(this.f74729f) + "], multiIncomingCall[" + z16 + "], mUinType[" + this.f74729f + "], mIsAudioMode[" + this.f74733j + "]");
        }
        String str = this.f74735l;
        int i3 = this.f74729f;
        if (AVUtil.o(i3)) {
            d("refreshUI");
        } else {
            SessionInfo sessionInfo = this.f74734k;
            if (sessionInfo != null && sessionInfo.B0 == 1 && this.f74729f == 9500 && !TextUtils.isEmpty(sessionInfo.D0)) {
                str = this.f74734k.D0;
                i3 = 0;
            }
            this.f74728e = this.f74725b.J(i3, str, this.f74736m, true, true);
            String G = this.f74725b.G(i3, str, this.f74736m);
            this.f74727d = G;
            if (this.f74729f == 25 && G.equals(this.f74735l)) {
                SessionInfo sessionInfo2 = this.f74734k;
                if (sessionInfo2 != null) {
                    this.f74727d = sessionInfo2.B;
                }
                if (QLog.isColorLevel()) {
                    QLog.w(this.f74724a, 2, "refreshUI mPeerName = " + this.f74727d);
                }
            }
        }
        if (this.f74737n == null) {
            VideoInviteFloatBar videoInviteFloatBar = new VideoInviteFloatBar(this.f74725b.getApp().getApplicationContext());
            this.f74737n = videoInviteFloatBar;
            videoInviteFloatBar.f(this.f74728e, this.f74727d);
            this.f74737n.i(new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(new Date()));
            this.f74737n.k(this.f74733j, AVUtil.o(this.f74729f), z16);
            if (AVUtil.o(this.f74729f)) {
                this.f74725b.M().postDelayed(this.f74739p, f74723q);
            }
        }
        com.tencent.av.compat.b.b(this.f74725b.getApplication(), 500L);
    }
}
