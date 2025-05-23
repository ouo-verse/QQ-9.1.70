package com.tencent.mobileqq.ocr;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.ocr.api.IPicOcrService;
import com.tencent.mobileqq.ocr.api.impl.OCRHandler;
import com.tencent.mobileqq.ocr.d;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.view.EyeButton;
import com.tencent.mobileqq.ocr.view.OcrImageTextView;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView;
import com.tencent.mobileqq.ocr.view.d;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.share.api.IShareActivityStartup;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DrawableLoader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.bw;
import com.tencent.mobileqq.utils.bx;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class OCRPerformFragment extends QPublicBaseFragment implements View.OnClickListener, Handler.Callback, d.a {
    static IPatchRedirector $redirector_;
    private final WeakReferenceHandler C;
    private QBaseActivity D;
    private String E;
    private OCRHandler F;
    private com.tencent.mobileqq.gallery.picocr.c G;
    private BroadcastReceiver H;
    private View I;
    private String J;
    private ImageView K;
    private ScanSuccessView L;
    private TranslateLanguageOptionsView M;
    private TranslateLanguageOptionsView N;
    private RelativeLayout P;
    private RelativeLayout Q;
    private RelativeLayout R;
    private RelativeLayout S;
    private GestureFrameLayout T;
    private OcrImageTextView U;
    private LinearLayout V;
    private ActionSheet W;
    private com.tencent.mobileqq.widget.tip.a X;
    private QQProgressDialog Y;
    private ImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f254477a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f254478b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f254479c0;

    /* renamed from: d0, reason: collision with root package name */
    private volatile boolean f254480d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f254481e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f254482f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f254483g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f254484h0;

    /* renamed from: i0, reason: collision with root package name */
    private long f254485i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f254486j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f254487k0;

    /* renamed from: l0, reason: collision with root package name */
    private AtomicBoolean f254488l0;

    /* renamed from: m0, reason: collision with root package name */
    private com.tencent.mobileqq.gallery.picocr.a f254489m0;

    /* renamed from: n0, reason: collision with root package name */
    private com.tencent.mobileqq.ocr.c f254490n0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements PopupWindow.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.a f254499d;

        a(d.a aVar) {
            this.f254499d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRPerformFragment.this, (Object) aVar);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                OCRPerformFragment.this.M = null;
                List<String> list = this.f254499d.f254719g;
                if (list != null && list.size() > 1) {
                    OCRPerformFragment.this.f254479c0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, OCRPerformFragment.this.getResources().getDrawable(R.drawable.f161904ni1));
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* loaded from: classes16.dex */
    class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRPerformFragment.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(intent.getAction())) {
                QLog.d("OCRPerformFragment", 4, "receive videochat");
                OCRPerformFragment.this.D.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c implements EyeButton.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRPerformFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.ocr.view.EyeButton.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.ocr.d.n("0X800AAE1", 0);
            if (OCRPerformFragment.this.U.I()) {
                OCRPerformFragment.this.U.setShowTextMask(false);
            }
        }

        @Override // com.tencent.mobileqq.ocr.view.EyeButton.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (!OCRPerformFragment.this.U.I()) {
                OCRPerformFragment.this.U.setShowTextMask(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRPerformFragment.this);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0) {
                com.tencent.mobileqq.ocr.d.i(OCRPerformFragment.this.D, String.valueOf(OCRPerformFragment.this.hi()));
                if (com.tencent.mobileqq.ocr.d.f254704a) {
                    str2 = "0X800B55F";
                } else {
                    str2 = "0X800AAE9";
                }
                com.tencent.mobileqq.ocr.d.n(str2, 0);
            }
            if (i3 == 1) {
                if (com.tencent.mobileqq.ocr.d.f254704a) {
                    com.tencent.mobileqq.ocr.d.j(OCRPerformFragment.this.D, OCRPerformFragment.this.U);
                } else {
                    ((IShareActivityStartup) QRoute.api(IShareActivityStartup.class)).gotoShareActivity(OCRPerformFragment.this.D, OCRPerformFragment.this.E);
                }
                if (com.tencent.mobileqq.ocr.d.f254704a) {
                    str = "0X800B560";
                } else {
                    str = "0X800AAEA";
                }
                com.tencent.mobileqq.ocr.d.n(str, 0);
            }
            if (OCRPerformFragment.this.W != null && OCRPerformFragment.this.W.isShowing()) {
                OCRPerformFragment.this.W.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRPerformFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                com.tencent.mobileqq.ocr.d.n("0X800AADF", 0);
                OCRPerformFragment.this.onBackEvent();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class f implements TranslateLanguageOptionsView.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.a f254505a;

        f(d.a aVar) {
            this.f254505a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRPerformFragment.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.a
        public void a(int i3, TranslateLanguageOptionsView.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bVar);
                return;
            }
            if (bVar != null && !TextUtils.isEmpty(bVar.f254924b)) {
                if (!this.f254505a.f254716d.equalsIgnoreCase(bVar.f254924b)) {
                    OCRPerformFragment oCRPerformFragment = OCRPerformFragment.this;
                    String str = bVar.f254924b;
                    oCRPerformFragment.bi(str, this.f254505a.c(str), false);
                }
                com.tencent.mobileqq.ocr.d.n("0X800B559", com.tencent.mobileqq.ocr.d.f(bVar.f254924b));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class g implements PopupWindow.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.a f254507d;

        g(d.a aVar) {
            this.f254507d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRPerformFragment.this, (Object) aVar);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                OCRPerformFragment.this.N = null;
                List<String> list = this.f254507d.f254718f;
                if (list != null && list.size() > 1) {
                    OCRPerformFragment.this.f254478b0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, OCRPerformFragment.this.getResources().getDrawable(R.drawable.f161904ni1));
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class h implements TranslateLanguageOptionsView.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.a f254509a;

        h(d.a aVar) {
            this.f254509a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRPerformFragment.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.a
        public void a(int i3, TranslateLanguageOptionsView.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bVar);
            } else if (bVar != null && !TextUtils.isEmpty(bVar.f254924b)) {
                if (!this.f254509a.f254717e.equalsIgnoreCase(bVar.f254924b)) {
                    OCRPerformFragment.this.bi(this.f254509a.f254716d, bVar.f254924b, false);
                }
                com.tencent.mobileqq.ocr.d.n("0X800B55A", com.tencent.mobileqq.ocr.d.f(bVar.f254924b));
            }
        }
    }

    public OCRPerformFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.C = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.H = null;
        this.f254481e0 = false;
        this.f254482f0 = false;
        this.f254483g0 = false;
        this.f254484h0 = false;
        this.f254485i0 = -1L;
        this.f254486j0 = 0;
        this.f254487k0 = -1;
        this.f254488l0 = new AtomicBoolean(false);
        this.f254489m0 = new com.tencent.mobileqq.gallery.picocr.a() { // from class: com.tencent.mobileqq.ocr.OCRPerformFragment.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OCRPerformFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.gallery.picocr.a
            protected void a(boolean z16, com.tencent.mobileqq.gallery.picocr.c cVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), cVar);
                    return;
                }
                if (OCRPerformFragment.this.f254480d0 && OCRPerformFragment.this.D != null) {
                    OCRPerformFragment.this.C.removeMessages(101);
                    OCRPerformFragment.this.f254480d0 = false;
                    OCRPerformFragment.this.D.runOnUiThread(new Runnable(z16, cVar) { // from class: com.tencent.mobileqq.ocr.OCRPerformFragment.6.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f254496d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mobileqq.gallery.picocr.c f254497e;

                        {
                            this.f254496d = z16;
                            this.f254497e = cVar;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass6.this, Boolean.valueOf(z16), cVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z17;
                            View view;
                            ArrayList<com.tencent.mobileqq.gallery.picocr.b> arrayList;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (this.f254496d && (arrayList = this.f254497e.f211819f) != null && !arrayList.isEmpty()) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            OCRPerformFragment.this.V.setVisibility(0);
                            OCRPerformFragment.this.V.bringToFront();
                            OCRPerformFragment.this.Ph();
                            if (z17) {
                                OCRPerformFragment.this.f254485i0 = System.currentTimeMillis() - OCRPerformFragment.this.f254485i0;
                                if (OCRPerformFragment.this.f254485i0 > 0) {
                                    com.tencent.mobileqq.ocr.d.n("0X800AD16", (int) OCRPerformFragment.this.f254485i0);
                                }
                                OCRPerformFragment.this.Yh(0);
                                OCRPerformFragment oCRPerformFragment = OCRPerformFragment.this;
                                oCRPerformFragment.Xh(oCRPerformFragment.f254485i0);
                                if (OCRPerformFragment.this.f254486j0 <= 1) {
                                    com.tencent.mobileqq.ocr.d.n("0X800AD17", 0);
                                }
                                OCRPerformFragment.this.ii(this.f254497e, true);
                                if (OCRPerformFragment.this.f254488l0.compareAndSet(true, false)) {
                                    if (OCRPerformFragment.this.I != null) {
                                        view = OCRPerformFragment.this.I.findViewById(R.id.h4z);
                                    } else {
                                        view = null;
                                    }
                                    if (view != null && !com.tencent.mobileqq.ocr.d.f254704a) {
                                        view.performClick();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            QQToast.makeText(MobileQQ.sMobileQQ, 1, R.string.fo_, 0).show();
                            com.tencent.mobileqq.ocr.d.n("0X800AD18", 0);
                            OCRPerformFragment.this.onBackEvent();
                        }
                    });
                } else if (QLog.isColorLevel()) {
                    QLog.d("OCRPerformFragment", 2, "onPicOcrResult other! or mActivity null");
                }
            }

            @Override // com.tencent.mobileqq.gallery.picocr.a
            public void b() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                } else {
                    OCRPerformFragment.this.C.sendEmptyMessageDelayed(101, 60000L);
                }
            }

            @Override // com.tencent.mobileqq.gallery.picocr.a
            public void c(com.tencent.mobileqq.gallery.picocr.c cVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) cVar);
                } else {
                    OCRPerformFragment.this.C.obtainMessage(102, cVar).sendToTarget();
                }
            }
        };
        this.f254490n0 = new com.tencent.mobileqq.ocr.c() { // from class: com.tencent.mobileqq.ocr.OCRPerformFragment.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OCRPerformFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.ocr.c
            public void c(boolean z16, int i3, TranslateResult translateResult) {
                int i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), translateResult);
                    return;
                }
                if (OCRPerformFragment.this.f254480d0) {
                    OCRPerformFragment.this.f254480d0 = false;
                    if (QLog.isColorLevel()) {
                        QLog.d("OCRPerformFragment", 2, String.format("onGetTranslateResult isSuccess:%s, type:%s, result:%s", Boolean.valueOf(z16), Integer.valueOf(i3), translateResult));
                    }
                    OCRPerformFragment.this.D.runOnUiThread(new Runnable(z16, translateResult) { // from class: com.tencent.mobileqq.ocr.OCRPerformFragment.11.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f254492d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ TranslateResult f254493e;

                        {
                            this.f254492d = z16;
                            this.f254493e = translateResult;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass11.this, Boolean.valueOf(z16), translateResult);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            TranslateResult translateResult2;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                OCRPerformFragment.this.ki(true);
                                if (this.f254492d && (translateResult2 = this.f254493e) != null && translateResult2.j() && !this.f254493e.g()) {
                                    TranslateResult translateResult3 = this.f254493e;
                                    com.tencent.mobileqq.ocr.d.f254711h = translateResult3;
                                    OCRPerformFragment.this.ji(translateResult3);
                                    return;
                                }
                                String string = OCRPerformFragment.this.getResources().getString(R.string.fou);
                                TranslateResult translateResult4 = this.f254493e;
                                if (translateResult4 != null) {
                                    if (!TextUtils.isEmpty(translateResult4.E)) {
                                        string = this.f254493e.E;
                                    } else if (this.f254493e.g()) {
                                        string = OCRPerformFragment.this.getResources().getString(R.string.fo_);
                                    }
                                }
                                QQToast.makeText(OCRPerformFragment.this.D, 1, string, 0).show();
                                com.tencent.mobileqq.ocr.d.n("0X800B558", 0);
                                return;
                            }
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    });
                    HashMap<String, String> hashMap = new HashMap<>();
                    if (translateResult != null) {
                        i16 = translateResult.D;
                    } else {
                        i16 = 2000;
                    }
                    hashMap.put("errCode", String.valueOf(i16));
                    hashMap.put("type", String.valueOf(i3));
                    StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", "SCAN_TRANSLATE_RESULT", z16, 0L, 0L, hashMap, "", false);
                }
            }
        };
    }

    private void Oh() {
        if (this.K != null) {
            if (QLog.isColorLevel()) {
                QLog.d("OCRPerformFragment", 2, "hideInRecoViewAnimation, mRecognizeBackBtn");
            }
            this.K.setVisibility(8);
            this.P.removeView(this.K);
            this.K = null;
        }
        if (this.L != null) {
            if (QLog.isColorLevel()) {
                QLog.d("OCRPerformFragment", 2, "hideInRecoViewAnimation, mRecognizeView");
            }
            this.L.setVisibility(8);
            this.P.removeView(this.L);
            this.L = null;
        }
        this.R.setVisibility(0);
        this.V.setVisibility(0);
    }

    private void Qh(List<com.tencent.mobileqq.ocr.view.c> list, List<com.tencent.mobileqq.ocr.view.b> list2) {
        this.T.e().R(new com.tencent.mobileqq.ocr.view.d(this.T, list, list2, this, this));
    }

    private void Sh() {
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0);
        String str = "businessinfo_ocr_gesture_guide_" + bw.a();
        if (sharedPreferences.getBoolean(str, true)) {
            this.Z.setImageResource(R.drawable.n4m);
            this.f254477a0.setText(R.string.f201374um);
            this.Q.setVisibility(0);
            sharedPreferences.edit().putBoolean(str, false).commit();
            return;
        }
        this.Q.setVisibility(8);
    }

    private void Th() {
        if (this.X == null) {
            return;
        }
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0);
        String str = "businessinfo_ocr_gesture_fullText_guide_" + bw.a();
        if (sharedPreferences.getBoolean(str, true)) {
            this.X.s0();
            sharedPreferences.edit().putBoolean(str, false).commit();
        } else if (this.X.L()) {
            this.X.o();
        }
    }

    private void Uh() {
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0);
        String str = "businessinfo_ocr_gesture_select_guide_" + bw.a();
        if (sharedPreferences.getBoolean(str, true)) {
            this.Q.setVisibility(0);
            this.Z.setImageResource(R.drawable.n4n);
            this.f254477a0.setText(R.string.f201384un);
            sharedPreferences.edit().putBoolean(str, false).commit();
            return;
        }
        this.Q.setVisibility(8);
    }

    private void Vh(View view) {
        OCRBottomTabView oCRBottomTabView = (OCRBottomTabView) view.findViewById(R.id.h4y);
        oCRBottomTabView.setOnClickListener(this);
        if (AppSetting.f99565y && oCRBottomTabView.isEnabled()) {
            com.tencent.mobileqq.util.c.a(oCRBottomTabView, String.valueOf(oCRBottomTabView.c()).trim());
        }
        OCRBottomTabView oCRBottomTabView2 = (OCRBottomTabView) view.findViewById(R.id.h4x);
        oCRBottomTabView2.setOnClickListener(this);
        if (AppSetting.f99565y && oCRBottomTabView2.isEnabled()) {
            com.tencent.mobileqq.util.c.a(oCRBottomTabView2, String.valueOf(oCRBottomTabView2.c()).trim());
        }
        OCRBottomTabView oCRBottomTabView3 = (OCRBottomTabView) view.findViewById(R.id.h4w);
        oCRBottomTabView3.setOnClickListener(this);
        if (AppSetting.f99565y && oCRBottomTabView3.isEnabled()) {
            com.tencent.mobileqq.util.c.a(oCRBottomTabView3, String.valueOf(oCRBottomTabView3.c()).trim());
        }
        OCRBottomTabView oCRBottomTabView4 = (OCRBottomTabView) view.findViewById(R.id.h4v);
        oCRBottomTabView4.setOnClickListener(this);
        if (AppSetting.f99565y && oCRBottomTabView4.isEnabled()) {
            com.tencent.mobileqq.util.c.a(oCRBottomTabView4, String.valueOf(oCRBottomTabView4.c()).trim());
        }
        OCRBottomTabView oCRBottomTabView5 = (OCRBottomTabView) view.findViewById(R.id.h4z);
        oCRBottomTabView5.setOnClickListener(this);
        if (AppSetting.f99565y && oCRBottomTabView5.isEnabled()) {
            com.tencent.mobileqq.util.c.a(oCRBottomTabView5, String.valueOf(oCRBottomTabView5.c()).trim());
        }
        this.J = getResources().getString(R.string.w4k);
        this.I = view;
        OcrImageTextView ocrImageTextView = (OcrImageTextView) view.findViewById(R.id.h4q);
        this.U = ocrImageTextView;
        ocrImageTextView.setVisibility(0);
        this.U.setOnClickListener(this);
        this.P = (RelativeLayout) view.findViewById(R.id.h4r);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.h4t);
        imageButton.setOnClickListener(this);
        AccessibilityUtil.c(imageButton, getResources().getString(R.string.button_back), null);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.zvz);
        this.Q = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.Z = (ImageView) view.findViewById(R.id.zvx);
        this.f254477a0 = (TextView) view.findViewById(R.id.zvy);
        this.X = QUIDefaultBubbleTip.r(requireContext()).S(oCRBottomTabView2).o0(getResources().getString(R.string.f201364ul)).R(0).m0(1).k0(0).b0(-1L);
        EyeButton eyeButton = (EyeButton) view.findViewById(R.id.h4u);
        AccessibilityUtil.c(eyeButton, getResources().getString(R.string.f201354uk), null);
        eyeButton.setLonTouchListener(new c());
        this.f254478b0 = (TextView) view.findViewById(R.id.mb_);
        this.f254479c0 = (TextView) view.findViewById(R.id.mb9);
        this.f254478b0.setOnClickListener(this);
        this.f254479c0.setOnClickListener(this);
        this.S = (RelativeLayout) view.findViewById(R.id.f166447zw0);
        li(com.tencent.mobileqq.ocr.d.f254706c, false);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.h4s);
        this.R = relativeLayout2;
        relativeLayout2.bringToFront();
        z81.e.d(this.D, this.R);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.h4p);
        this.V = linearLayout;
        linearLayout.setVisibility(4);
        this.T = (GestureFrameLayout) view.findViewById(R.id.fja);
    }

    private void Wh(String str) {
        com.tencent.mobileqq.ocr.d.f254709f = hi();
        Intent intent = new Intent(this.D, (Class<?>) OCRResultFragmentNew.class);
        intent.putExtra("param_ocr_path", str);
        QPublicFragmentActivity.start(this.D, intent, OCRResultFragmentNew.class);
        this.D.overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh(long j3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_ocr_cost", j3 + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "picOcrCost", true, 0L, 0L, hashMap, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yh(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_ocr_is_cache", i3 + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "picOcrIsCache", true, 0L, 0L, hashMap, "");
    }

    private void Zh(boolean z16) {
        String string = getResources().getString(R.string.w4r);
        String string2 = getResources().getString(R.string.w4s);
        OCRBottomTabView oCRBottomTabView = (OCRBottomTabView) this.I.findViewById(R.id.h4v);
        if (z16) {
            String valueOf = String.valueOf(oCRBottomTabView.c());
            if (!valueOf.contains(string2)) {
                oCRBottomTabView.setTabText(valueOf + string2);
            }
            OCRBottomTabView oCRBottomTabView2 = (OCRBottomTabView) this.I.findViewById(R.id.h4y);
            String valueOf2 = String.valueOf(oCRBottomTabView2.c());
            if (!valueOf2.contains(string2)) {
                oCRBottomTabView2.setTabText(valueOf2 + string2);
            }
            OCRBottomTabView oCRBottomTabView3 = (OCRBottomTabView) this.I.findViewById(R.id.h4x);
            String valueOf3 = String.valueOf(oCRBottomTabView3.c());
            if (!valueOf3.contains(string2)) {
                oCRBottomTabView3.setTabText(valueOf3.replace(string, string2));
            }
            this.J = this.J.replace(string, string2);
            return;
        }
        oCRBottomTabView.setTabText(getResources().getString(R.string.w4o));
        ((OCRBottomTabView) this.I.findViewById(R.id.h4y)).setTabText(getResources().getString(R.string.bbp));
        ((OCRBottomTabView) this.I.findViewById(R.id.h4z)).setTabText(getResources().getString(R.string.fos));
        ((OCRBottomTabView) this.I.findViewById(R.id.h4x)).setTabText(getResources().getString(R.string.w4q));
        this.J = getResources().getString(R.string.w4k);
    }

    private void ai(com.tencent.mobileqq.ocr.req.a aVar, boolean z16) {
        if (z16 && com.tencent.mobileqq.ocr.d.f254710g != null) {
            Yh(1);
            ii(com.tencent.mobileqq.ocr.d.f254710g, false);
            return;
        }
        if (aVar == null) {
            QLog.d("OCRPerformFragment", 2, "requestOcr, reqContext is null!!! BusinessType = " + this.f254487k0);
            return;
        }
        if (!FileUtils.fileExists(aVar.f254767c)) {
            QLog.d("OCRPerformFragment", 1, "requestOcr, file not exist, picPath:" + aVar.f254767c);
            QQToast.makeText(this.D, 1, R.string.fo9, 0).show();
            return;
        }
        if (this.f254480d0) {
            QLog.d("OCRPerformFragment", 1, "requestOcr, in ocr request, " + aVar.f254767c);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OCRPerformFragment", 2, "requestOcr:" + aVar.f254767c);
        }
        di();
        this.f254480d0 = true;
        this.f254485i0 = System.currentTimeMillis();
        ((IPicOcrService) this.D.getAppRuntime().getRuntimeService(IPicOcrService.class, "")).requestOcr(aVar, this.f254489m0);
        this.f254486j0++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(String str, String str2, boolean z16) {
        TranslateResult translateResult;
        if (z16 && (translateResult = com.tencent.mobileqq.ocr.d.f254711h) != null) {
            ji(translateResult);
            return;
        }
        if (this.f254480d0) {
            if (QLog.isColorLevel()) {
                QLog.d("OCRPerformFragment", 2, "updateTranslateTitle, inTranslateRequestNow");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!NetworkUtil.isNetworkAvailable(this.D)) {
                QQToast.makeText(this.D, 1, R.string.b3j, 0).show();
                com.tencent.mobileqq.ocr.d.n("0X800B557", 0);
                return;
            }
            String valueOf = String.valueOf(com.tencent.mobileqq.ocr.d.f254708e);
            if (TextUtils.isEmpty(valueOf)) {
                QLog.d("OCRPerformFragment", 1, "requestTranslate, mInputTransText null");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("OCRPerformFragment", 2, "requestTranslate, srcLan:" + str + ", dstLan:" + str2);
            }
            this.f254480d0 = true;
            ki(false);
            OCRHandler oCRHandler = this.F;
            if (oCRHandler != null) {
                oCRHandler.batchTranslate(valueOf, str, str2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OCRPerformFragment", 2, "updateTranslateTitle, srcLan/dstLan is null");
        }
    }

    private void ci() {
        ActionSheet create = ActionSheet.create(this.D);
        this.W = create;
        create.addButton(this.J);
        this.W.addButton(R.string.w4j);
        this.W.addCancelButton(R.string.cancel);
        this.W.setOnButtonClickListener(new d());
        this.W.show();
    }

    private void di() {
        this.R.setVisibility(8);
        this.V.setVisibility(8);
        if (this.L == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            ScanSuccessView scanSuccessView = new ScanSuccessView(this.D);
            this.L = scanSuccessView;
            scanSuccessView.setShowProgress(false);
            this.L.setBackgroundColor(HWColorFormat.COLOR_FormatVendorStartUnused);
            this.L.setScale(ScreenUtil.SCREEN_WIDTH);
            this.P.addView(this.L, layoutParams);
            this.L.setScanText(HardCodeUtil.qqStr(R.string.oxs));
        }
        if (this.K == null) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            ImageView imageView = new ImageView(this.D);
            this.K = imageView;
            imageView.setImageResource(R.drawable.a39);
            layoutParams2.leftMargin = x.c(this.D, 12.0f);
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                layoutParams2.topMargin = ImmersiveUtils.getStatusBarHeight(this.D) + x.c(this.D, 12.0f);
            } else {
                layoutParams2.topMargin = x.c(this.D, 12.0f);
            }
            this.P.addView(this.K, layoutParams2);
            this.K.setOnClickListener(new e());
            this.K.bringToFront();
        }
    }

    private void ei(d.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("OCRPerformFragment", 2, "showTranslateDstLanOptions, lanHolder:" + aVar.e());
        }
        TranslateLanguageOptionsView translateLanguageOptionsView = this.N;
        if (translateLanguageOptionsView != null && translateLanguageOptionsView.isShowing()) {
            this.N.dismiss();
        }
        TranslateLanguageOptionsView translateLanguageOptionsView2 = this.M;
        if (translateLanguageOptionsView2 != null && translateLanguageOptionsView2.isShowing()) {
            this.M.dismiss();
            return;
        }
        List<String> list = aVar.f254719g;
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (int i16 = 0; i16 < aVar.f254719g.size(); i16++) {
                String str = aVar.f254719g.get(i16);
                if (!str.equalsIgnoreCase(aVar.f254716d)) {
                    if (str.equalsIgnoreCase(aVar.f254717e)) {
                        i3 = i16;
                    }
                    TranslateLanguageOptionsView.b bVar = new TranslateLanguageOptionsView.b();
                    bVar.f254924b = str;
                    bVar.f254923a = com.tencent.mobileqq.ocr.d.h(str);
                    arrayList.add(bVar);
                }
            }
            this.M = TranslateLanguageOptionsView.a(this.D, arrayList, i3, new h(aVar));
            int measuredWidth = (this.f254479c0.getMeasuredWidth() / 2) - x.c(this.D, 75.0f);
            this.f254479c0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.M.showAsDropDown(this.f254479c0, measuredWidth, 0);
            this.M.setOnDismissListener(new a(aVar));
        }
    }

    private void fi(d.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("OCRPerformFragment", 2, "showTranslateSrcLanOptions, lanHolder:" + aVar.e());
        }
        TranslateLanguageOptionsView translateLanguageOptionsView = this.M;
        if (translateLanguageOptionsView != null && translateLanguageOptionsView.isShowing()) {
            this.M.dismiss();
        }
        TranslateLanguageOptionsView translateLanguageOptionsView2 = this.N;
        if (translateLanguageOptionsView2 != null && translateLanguageOptionsView2.isShowing()) {
            this.N.dismiss();
            return;
        }
        List<String> list = aVar.f254718f;
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (int i16 = 0; i16 < aVar.f254718f.size(); i16++) {
                String str = aVar.f254718f.get(i16);
                if (str.equalsIgnoreCase(aVar.f254716d)) {
                    i3 = i16;
                }
                TranslateLanguageOptionsView.b bVar = new TranslateLanguageOptionsView.b();
                bVar.f254924b = str;
                bVar.f254923a = com.tencent.mobileqq.ocr.d.h(str);
                arrayList.add(bVar);
            }
            this.N = TranslateLanguageOptionsView.a(this.D, arrayList, i3, new f(aVar));
            int measuredWidth = (this.f254478b0.getMeasuredWidth() / 2) - x.c(this.D, 75.0f);
            this.f254478b0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.N.showAsDropDown(this.f254478b0, measuredWidth, 0);
            this.N.setOnDismissListener(new g(aVar));
        }
    }

    public static void gi(Activity activity, String str, int i3, int i16, String str2, boolean z16) {
        Intent intent = new Intent(activity, (Class<?>) OCRPerformFragment.class);
        intent.putExtra("param_ocr_path", str);
        intent.putExtra("PARAM_FROM", i3);
        intent.putExtra("param_ocr_md5", str2);
        intent.putExtra("param_business_type", i16);
        intent.putExtra("param_auto_translate_mode", z16);
        QPublicFragmentActivity.start(activity, intent, OCRPerformFragment.class);
        activity.overridePendingTransition(0, 0);
        com.tencent.mobileqq.ocr.d.n("0X80082C7", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence hi() {
        TranslateResult translateResult;
        OcrImageTextView ocrImageTextView = this.U;
        if (ocrImageTextView != null && ocrImageTextView.E()) {
            CharSequence R = this.U.R();
            com.tencent.mobileqq.ocr.d.f254709f = R;
            return R;
        }
        if (com.tencent.mobileqq.ocr.d.f254704a && (translateResult = com.tencent.mobileqq.ocr.d.f254711h) != null) {
            return translateResult.e();
        }
        return com.tencent.mobileqq.ocr.d.f254708e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii(com.tencent.mobileqq.gallery.picocr.c cVar, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("OCRPerformFragment", 2, "updateOcrResultData\uff1a" + cVar.toString());
        }
        if (z16) {
            com.tencent.mobileqq.ocr.d.f254708e = com.tencent.mobileqq.ocr.d.r(cVar.f211819f);
            if (!com.tencent.mobileqq.ocr.d.f254704a) {
                com.tencent.mobileqq.ocr.d.f254706c = com.tencent.mobileqq.ocr.d.l(com.tencent.mobileqq.ocr.d.f254706c, cVar.f211817d, cVar.f211820g, cVar.f211821h);
                com.tencent.mobileqq.ocr.d.f254707d = com.tencent.mobileqq.ocr.d.l(com.tencent.mobileqq.ocr.d.f254707d, cVar.f211817d, cVar.f211820g, cVar.f211821h);
            }
            com.tencent.mobileqq.ocr.req.a aVar = com.tencent.mobileqq.ocr.d.f254705b;
            if (aVar != null) {
                aVar.f254765a = cVar.f211817d;
                aVar.f254766b = this.f254487k0;
                aVar.f254770f = cVar.f211814a;
                aVar.f254767c = this.E;
                aVar.f254776l = cVar.f211818e;
                aVar.f254773i = cVar.f211823j;
                aVar.f254774j = cVar.f211824k;
                aVar.f254769e = cVar.f211822i;
                aVar.f254771g = cVar.f211825l;
            }
            cVar.f211826m = BaseImageUtil.getExifOrientation(this.E);
            com.tencent.mobileqq.ocr.d.f254710g = cVar;
        }
        if (com.tencent.mobileqq.ocr.d.f254704a) {
            d.a aVar2 = com.tencent.mobileqq.ocr.d.f254706c;
            bi(aVar2.f254716d, aVar2.f254717e, false);
        } else {
            this.U.setResultNormal(com.tencent.mobileqq.ocr.d.f254710g);
            if (bx.INSTANCE.a()) {
                AccessibilityUtil.c(this.U, com.tencent.mobileqq.ocr.d.f254708e, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji(TranslateResult translateResult) {
        if (QLog.isColorLevel()) {
            QLog.d("OCRPerformFragment", 2, "src:" + translateResult.f254722e + ", dst:" + translateResult.f254723f + ", OCRLanHolder:" + com.tencent.mobileqq.ocr.d.f254706c.e());
        }
        d.a aVar = com.tencent.mobileqq.ocr.d.f254706c;
        if (aVar != null) {
            aVar.g(translateResult.f254722e);
            com.tencent.mobileqq.ocr.d.f254706c.f(translateResult.f254723f);
            com.tencent.mobileqq.ocr.d.f254707d.i(com.tencent.mobileqq.ocr.d.f254706c.f254717e);
            li(com.tencent.mobileqq.ocr.d.f254706c, com.tencent.mobileqq.ocr.d.f254704a);
        }
        if (QLog.isColorLevel()) {
            QLog.d("OCRPerformFragment", 2, translateResult.c());
        }
        this.U.setResultSection(translateResult);
        if (bx.INSTANCE.a()) {
            AccessibilityUtil.c(this.U, translateResult.b(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ki(boolean z16) {
        if (z16) {
            QQProgressDialog qQProgressDialog = this.Y;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.Y.dismiss();
                return;
            }
            return;
        }
        if (this.Y == null) {
            QQProgressDialog qQProgressDialog2 = new QQProgressDialog(this.D, getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.Y = qQProgressDialog2;
            qQProgressDialog2.setMessage(R.string.fow);
        }
        if (!this.D.isFinishing()) {
            this.Y.show();
        }
        com.tencent.mobileqq.ocr.d.n("0X800B556", 0);
    }

    private void li(d.a aVar, boolean z16) {
        int i3;
        int i16;
        OCRBottomTabView oCRBottomTabView = (OCRBottomTabView) this.I.findViewById(R.id.h4z);
        if (oCRBottomTabView != null) {
            if (z16) {
                if (QQTheme.isNowThemeIsNight()) {
                    i16 = R.drawable.kt7;
                } else {
                    i16 = R.drawable.kt6;
                }
            } else {
                i16 = R.drawable.qui_translate_icon_allwhite_primary;
            }
            DrawableLoader.b(i16, oCRBottomTabView);
        }
        RelativeLayout relativeLayout = this.S;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        relativeLayout.setVisibility(i3);
        if (!z16 || aVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OCRPerformFragment", 2, "updateTranslateTitle, lanHolder:" + aVar.e());
        }
        this.f254478b0.setText(aVar.d(aVar.f254716d));
        this.f254479c0.setText(aVar.d(aVar.f254717e));
        List<String> list = aVar.f254718f;
        if (list != null && list.size() > 1) {
            this.f254478b0.setClickable(true);
            this.f254478b0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.f161904ni1));
        } else {
            this.f254478b0.setClickable(false);
            this.f254478b0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        List<String> list2 = aVar.f254719g;
        if (list2 != null && list2.size() > 1) {
            this.f254479c0.setClickable(true);
            this.f254479c0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.f161904ni1));
        } else {
            this.f254479c0.setClickable(false);
            this.f254479c0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.d.a
    public void F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (!this.f254483g0) {
            this.f254483g0 = true;
            Sh();
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.d.a
    public void F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            Zh(this.U.E());
            this.U.L();
        }
    }

    public boolean Nh() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        float i3 = this.T.e().P().i();
        if (i3 > 1.0f) {
            z16 = true;
        } else if (i3 == 1.0f) {
            z16 = !this.U.s(this.T.getHeight());
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OCRPerformFragment", 2, "checkImageFitView, zoom:", Float.valueOf(i3), " result:", Boolean.valueOf(z16));
        }
        return z16;
    }

    public void Ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        OcrImageTextView ocrImageTextView = this.U;
        if (ocrImageTextView != null) {
            Qh(ocrImageTextView.y(), this.U.z());
        }
        Oh();
        Rh();
    }

    public void Rh() {
        OcrImageTextView ocrImageTextView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (!this.f254482f0) {
            this.f254482f0 = true;
            Uh();
        } else if (!this.f254483g0 && (ocrImageTextView = this.U) != null && !ocrImageTextView.s(this.T.getHeight())) {
            this.f254483g0 = true;
            Sh();
        } else if (!this.f254484h0) {
            this.f254484h0 = true;
            Th();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.tencent.mobileqq.gallery.picocr.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) message)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("OCRPerformFragment", 2, "what:" + message.what);
        }
        int i3 = message.what;
        if (i3 == 100) {
            Bitmap bitmap = (Bitmap) message.obj;
            if (bitmap != null) {
                this.U.setImageBitmap(bitmap);
                this.f254481e0 = true;
                if (this.G != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("OCRPerformFragment", 2, "onUpdate useLocalResult\uff01");
                    }
                    this.f254489m0.onUpdate(100, true, this.G);
                }
            } else {
                QBaseActivity qBaseActivity = this.D;
                if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                    QQToast.makeText(this.D, 1, R.string.w4m, 0).show();
                    onBackEvent();
                }
            }
        } else if (i3 == 101) {
            QQToast.makeText(MobileQQ.sMobileQQ, 1, R.string.fo_, 0).show();
            onBackEvent();
        } else if (i3 == 102 && (cVar = (com.tencent.mobileqq.gallery.picocr.c) message.obj) != null) {
            if (this.f254481e0) {
                if (QLog.isColorLevel()) {
                    QLog.i("OCRPerformFragment", 2, "onUpdate useRspCache\uff01");
                }
                this.f254489m0.onUpdate(100, true, cVar);
            } else {
                this.G = cVar;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
        activity.getWindow().setFlags(1024, 1024);
        activity.getWindow().getDecorView().setSystemUiVisibility(5);
        activity.getWindow().setNavigationBarColor(-16777216);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            super.onAttach(activity);
            this.D = (QBaseActivity) activity;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        QBaseActivity qBaseActivity = this.D;
        if (qBaseActivity != null) {
            qBaseActivity.finish();
            return true;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.h4t) {
                com.tencent.mobileqq.ocr.d.n("0X800AAE0", 0);
                onBackEvent();
            } else {
                int i3 = 1;
                if (id5 == R.id.h4u) {
                    this.U.setShowTextMask(!r0.I());
                } else if (id5 == R.id.h4w) {
                    com.tencent.mobileqq.ocr.d.e(this.D, this.E);
                    if (com.tencent.mobileqq.ocr.d.f254704a) {
                        str5 = "0X800B55C";
                    } else {
                        str5 = "0X800AAE2";
                    }
                    com.tencent.mobileqq.ocr.d.n(str5, 0);
                } else {
                    int i16 = 2;
                    if (id5 == R.id.h4v) {
                        BaseMenuUtil.copy(String.valueOf(hi()), "OCRPerformFragment");
                        if (com.tencent.mobileqq.ocr.d.f254704a) {
                            str4 = "0X800B55D";
                        } else {
                            str4 = "0X800AAE7";
                        }
                        if (this.U.E()) {
                            i3 = 2;
                        }
                        com.tencent.mobileqq.ocr.d.n(str4, i3);
                    } else if (id5 == R.id.h4z) {
                        boolean z16 = !com.tencent.mobileqq.ocr.d.f254704a;
                        com.tencent.mobileqq.ocr.d.f254704a = z16;
                        if (z16) {
                            str3 = "0X800B555";
                        } else {
                            str3 = "0X800B562";
                        }
                        if (!this.U.E()) {
                            i16 = 1;
                        }
                        com.tencent.mobileqq.ocr.d.n(str3, i16);
                        Zh(false);
                        if (com.tencent.mobileqq.ocr.d.f254704a) {
                            d.a aVar = com.tencent.mobileqq.ocr.d.f254706c;
                            bi(aVar.f254716d, aVar.f254717e, true);
                            com.tencent.mobileqq.ocr.d.f254707d.i(com.tencent.mobileqq.ocr.d.f254706c.f254717e);
                        } else {
                            li(com.tencent.mobileqq.ocr.d.f254706c, false);
                            ai(com.tencent.mobileqq.ocr.d.f254705b, true);
                            com.tencent.mobileqq.ocr.d.f254707d.h(com.tencent.mobileqq.ocr.d.f254706c);
                        }
                    } else if (id5 == R.id.h4y) {
                        if (com.tencent.mobileqq.ocr.d.f254704a) {
                            str2 = "0X800B55E";
                        } else {
                            str2 = "0X800AAE8";
                        }
                        if (this.U.E()) {
                            i3 = 2;
                        }
                        com.tencent.mobileqq.ocr.d.n(str2, i3);
                        ci();
                    } else if (id5 == R.id.h4x) {
                        com.tencent.mobileqq.widget.tip.a aVar2 = this.X;
                        if (aVar2 != null && aVar2.L()) {
                            this.X.o();
                        }
                        Wh(this.E);
                        if (com.tencent.mobileqq.ocr.d.f254704a) {
                            str = "0X800B561";
                        } else {
                            str = "0X800AAEC";
                        }
                        if (this.U.E()) {
                            i3 = 2;
                        }
                        com.tencent.mobileqq.ocr.d.n(str, i3);
                    } else if (id5 == R.id.bbi) {
                        BaseMenuUtil.copy(String.valueOf(hi()), "OCRPerformFragment");
                        com.tencent.mobileqq.ocr.d.n("0X800AAEF", 0);
                    } else if (id5 == R.id.cjs) {
                        com.tencent.mobileqq.ocr.d.i(this.D, String.valueOf(hi()));
                        com.tencent.mobileqq.ocr.d.n("0X800AAF0", 0);
                    } else if (id5 == R.id.j5q) {
                        TranslateFragment.Gh(this.D, String.valueOf(hi()));
                        if (this.U.E()) {
                            i3 = 2;
                        }
                        com.tencent.mobileqq.ocr.d.n("0X800AAEB", i3);
                    } else if (id5 == R.id.zvz) {
                        this.Q.setVisibility(8);
                        Rh();
                    } else if (id5 == R.id.mb_) {
                        fi(com.tencent.mobileqq.ocr.d.f254706c);
                    } else if (id5 == R.id.mb9) {
                        ei(com.tencent.mobileqq.ocr.d.f254706c);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        Intent intent = this.D.getIntent();
        com.tencent.mobileqq.ocr.d.f254704a = false;
        this.E = intent.getStringExtra("param_ocr_path");
        if (QLog.isColorLevel()) {
            QLog.e("OCRPerformFragment", 2, "mPicPath=" + this.E);
        }
        this.f254487k0 = intent.getIntExtra("param_business_type", -1);
        String stringExtra = intent.getStringExtra("param_ocr_md5");
        if (com.tencent.mobileqq.ocr.d.f254705b == null) {
            com.tencent.mobileqq.ocr.req.a aVar = new com.tencent.mobileqq.ocr.req.a();
            com.tencent.mobileqq.ocr.d.f254705b = aVar;
            aVar.f254765a = "";
            aVar.f254772h = false;
        }
        com.tencent.mobileqq.ocr.req.a aVar2 = com.tencent.mobileqq.ocr.d.f254705b;
        aVar2.f254766b = this.f254487k0;
        aVar2.f254770f = stringExtra;
        aVar2.f254767c = this.E;
        if (intent.getBooleanExtra("param_auto_translate_mode", false)) {
            this.f254488l0.set(true);
        }
        this.H = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        try {
            this.D.registerReceiver(this.H, intentFilter);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.D.getAppRuntime() != null) {
            this.D.addObserver(this.f254490n0);
            this.D.addObserver(this.f254489m0);
        }
        this.F = (OCRHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(OCRHandler.f254678e);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            inflate = (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        } else {
            inflate = layoutInflater.inflate(R.layout.f168828b20, viewGroup, false);
            Vh(inflate);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ocr.OCRPerformFragment.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OCRPerformFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (OCRPerformFragment.this.getContext() == null) {
                            return;
                        }
                        OCRPerformFragment.this.C.obtainMessage(100, com.tencent.mobileqq.ocr.d.c(OCRPerformFragment.this.E, OCRPerformFragment.this.getResources().getDisplayMetrics())).sendToTarget();
                    }
                }
            }, 16, null, true);
            ai(com.tencent.mobileqq.ocr.d.f254705b, false);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OCRPerformFragment", 2, "onDestroy!");
        }
        BroadcastReceiver broadcastReceiver = this.H;
        if (broadcastReceiver != null) {
            this.D.unregisterReceiver(broadcastReceiver);
            this.H = null;
        }
        this.D.removeObserver(this.f254490n0);
        this.D.removeObserver(this.f254489m0);
        OcrImageTextView ocrImageTextView = this.U;
        if (ocrImageTextView != null) {
            ocrImageTextView.M();
            this.U.t();
        }
        com.tencent.mobileqq.ocr.d.m();
        this.D = null;
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
            return;
        }
        super.onNewIntent(intent);
        if (this.D != null && intent != null && intent.getIntExtra("qq_sub_business_id", -1) == 103) {
            if (this.D.isInMultiWindow()) {
                QQToast.makeText(this.D, R.string.d6g, 0).show();
            } else {
                this.E = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
                OcrImageTextView ocrImageTextView = this.U;
                if (ocrImageTextView != null) {
                    ocrImageTextView.setImageURI(Uri.fromFile(new File(this.E)));
                    this.U.setShowTextMask(false);
                }
                GestureFrameLayout gestureFrameLayout = this.T;
                if (gestureFrameLayout != null && gestureFrameLayout.e() != null) {
                    this.T.e().Q();
                }
                com.tencent.mobileqq.ocr.d.f254705b.b();
                com.tencent.mobileqq.ocr.d.f254705b.e(this.E);
                com.tencent.mobileqq.ocr.d.f254705b.c(true);
                ai(com.tencent.mobileqq.ocr.d.f254705b, false);
            }
            ReportController.o(null, "dc00898", "", "", "0X80082DD", "0X80082DD", 0, 0, "", "", "", "");
        }
    }
}
