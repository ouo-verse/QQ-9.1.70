package com.tencent.aelight.camera.ae.flashshow.zshow;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aelight.camera.ae.flashshow.zshow.WinkZShowForOnlineStatusLoadingView;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.aelight.camera.api.IWinkZShowViewForOnlineStatusProvider;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WinkZShowForOnlineStatusLoadingView extends ConstraintLayout implements IWinkZShowViewForOnlineStatusProvider.a {
    private static final String C = WinkZShowDownloadHelper.f65190a + "zpai_loading_animation.pag";

    /* renamed from: d, reason: collision with root package name */
    private TextView f65199d;

    /* renamed from: e, reason: collision with root package name */
    private VasPagView f65200e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f65201f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f65202h;

    /* renamed from: i, reason: collision with root package name */
    private String f65203i;

    /* renamed from: m, reason: collision with root package name */
    private Boolean f65204m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Downloader.DownloadListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit c(PAGView pAGView) {
            pAGView.setComposition(PagViewMonitor.Load(WinkZShowForOnlineStatusLoadingView.this.f65203i));
            pAGView.setRepeatCount(0);
            pAGView.play();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            WinkZShowForOnlineStatusLoadingView.this.f65200e.api().postAction(new Function1() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit c16;
                    c16 = WinkZShowForOnlineStatusLoadingView.a.this.c((PAGView) obj);
                    return c16;
                }
            });
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            QLog.i("WinkZShowForOnlineStatusLoadingView", 1, "downloadLoadingPAG onDownloadCanceled");
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            QLog.i("WinkZShowForOnlineStatusLoadingView", 1, "downloadLoadingPAG onDownloadFailed");
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            QLog.i("WinkZShowForOnlineStatusLoadingView", 1, "downloadLoadingPAG onDownloadSucceed");
            if (downloadResult != null) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkZShowForOnlineStatusLoadingView.a.this.d();
                    }
                });
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }

    public WinkZShowForOnlineStatusLoadingView(Context context) {
        super(context);
        this.f65203i = null;
        this.f65204m = Boolean.TRUE;
        K0(context);
    }

    private boolean H0() {
        d dVar = (d) ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getConfig("online_status_device_black_list_for_pag", d.class, "");
        String lowerCase = ah.F().toLowerCase();
        String str = ah.C().toLowerCase() + " " + lowerCase;
        boolean z16 = false;
        if (dVar != null) {
            Iterator<String> it = dVar.a().iterator();
            while (it.hasNext()) {
                String lowerCase2 = it.next().toLowerCase();
                if (lowerCase2.equals(lowerCase) || lowerCase2.equals(str)) {
                    z16 = true;
                    break;
                }
            }
            QLog.d("WinkZShowForOnlineStatusLoadingView", 1, "checkDeviceInBlackListForPag, config: " + dVar);
            QLog.i("WinkZShowForOnlineStatusLoadingView", 1, "checkDeviceInBlackListForPag, device: " + str + ",check in black list result: " + z16);
            return z16;
        }
        QLog.e("WinkZShowForOnlineStatusLoadingView", 1, "checkDeviceInBlackListForPag config is null, device: " + str);
        return false;
    }

    private Boolean I0() {
        String c16 = com.tencent.aelight.camera.ae.flashshow.util.d.f65104a.c();
        QLog.d("WinkZShowForOnlineStatusLoadingView", 1, "gpuName: ", c16);
        if (TextUtils.isEmpty(c16)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(!c16.contains("PowerVR"));
    }

    private void J0() {
        WinkZShowDownloadHelper.g(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit L0(PAGView pAGView) {
        pAGView.stop();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit N0(PAGView pAGView) {
        pAGView.setComposition(PagViewMonitor.Load(this.f65203i));
        pAGView.setRepeatCount(0);
        pAGView.play();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit P0(PAGView pAGView) {
        if (pAGView.isPlaying()) {
            return null;
        }
        pAGView.play();
        return null;
    }

    private void Q0(final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.h
                @Override // java.lang.Runnable
                public final void run() {
                    runnable.run();
                }
            });
        }
    }

    public void G0(IWinkZShowViewForOnlineStatusProvider.LoadViewConfig loadViewConfig) {
        this.f65199d.setVisibility(loadViewConfig.getShowProgress() ? 0 : 8);
        this.f65201f.setText(loadViewConfig.getText());
        this.f65201f.setTextColor(loadViewConfig.getTextColor());
        this.f65201f.setTextSize(0, loadViewConfig.getTextSize());
        if (this.f65204m.booleanValue()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f65200e.getLayoutParams();
            marginLayoutParams.bottomMargin = loadViewConfig.getBottomForIcon();
            int iconSize = loadViewConfig.getIconSize();
            marginLayoutParams.height = iconSize;
            marginLayoutParams.width = iconSize;
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f65202h.getLayoutParams();
        marginLayoutParams2.bottomMargin = loadViewConfig.getBottomForIcon();
        int iconSize2 = loadViewConfig.getIconSize();
        marginLayoutParams2.height = iconSize2;
        marginLayoutParams2.width = iconSize2;
    }

    @Override // com.tencent.aelight.camera.api.IWinkZShowViewForOnlineStatusProvider.a
    public TextView f0() {
        return this.f65199d;
    }

    @Override // com.tencent.aelight.camera.api.IWinkZShowViewForOnlineStatusProvider.a
    public void hide() {
        Log.i("WinkZShowForOnlineStatusLoadingView", "hide");
        Q0(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.g
            @Override // java.lang.Runnable
            public final void run() {
                WinkZShowForOnlineStatusLoadingView.this.M0();
            }
        });
    }

    @Override // com.tencent.aelight.camera.api.IWinkZShowViewForOnlineStatusProvider.a
    public void show() {
        Log.i("WinkZShowForOnlineStatusLoadingView", "show ");
        setVisibility(0);
        if (this.f65204m.booleanValue()) {
            this.f65200e.api().postAction(new Function1() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit P0;
                    P0 = WinkZShowForOnlineStatusLoadingView.P0((PAGView) obj);
                    return P0;
                }
            });
        }
    }

    protected void K0(Context context) {
        try {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f167507dp0, (ViewGroup) this, true);
            this.f65199d = (TextView) inflate.findViewById(R.id.s59);
            this.f65201f = (TextView) inflate.findViewById(R.id.s56);
            this.f65200e = (VasPagView) inflate.findViewById(R.id.s57);
            this.f65202h = (ImageView) inflate.findViewById(R.id.s58);
            Boolean valueOf = Boolean.valueOf(I0().booleanValue() && !H0());
            this.f65204m = valueOf;
            if (!valueOf.booleanValue()) {
                this.f65202h.setVisibility(0);
                this.f65200e.setVisibility(8);
                return;
            }
            this.f65200e.api().build();
            this.f65203i = C;
            if (new File(this.f65203i).exists()) {
                this.f65200e.api().postAction(new Function1() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit N0;
                        N0 = WinkZShowForOnlineStatusLoadingView.this.N0((PAGView) obj);
                        return N0;
                    }
                });
            } else {
                J0();
            }
        } catch (Exception e16) {
            if (QLog.isDebugVersion()) {
                QLog.d("WinkZShowForOnlineStatusLoadingView", 1, "download err: ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0() {
        setVisibility(8);
        if (this.f65204m.booleanValue()) {
            this.f65200e.api().postAction(new Function1() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit L0;
                    L0 = WinkZShowForOnlineStatusLoadingView.L0((PAGView) obj);
                    return L0;
                }
            });
        }
    }

    public WinkZShowForOnlineStatusLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f65203i = null;
        this.f65204m = Boolean.TRUE;
        K0(context);
    }

    public WinkZShowForOnlineStatusLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f65203i = null;
        this.f65204m = Boolean.TRUE;
        K0(context);
    }
}
