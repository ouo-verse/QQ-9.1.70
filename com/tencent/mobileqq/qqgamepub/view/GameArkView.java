package com.tencent.mobileqq.qqgamepub.view;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.open.ArkView;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class GameArkView extends RelativeLayout implements a, ArkViewImplement.LoadCallback, HippyViewBase {
    static IPatchRedirector $redirector_;
    private String C;
    private boolean D;
    private boolean E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    private ArkView f264730d;

    /* renamed from: e, reason: collision with root package name */
    private String f264731e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f264732f;

    /* renamed from: h, reason: collision with root package name */
    private long f264733h;

    /* renamed from: i, reason: collision with root package name */
    private int f264734i;

    /* renamed from: m, reason: collision with root package name */
    private QQGameMsgInfo f264735m;

    public GameArkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f264732f = true;
        this.f264734i = 101;
        this.D = false;
        this.E = true;
        this.F = false;
        LayoutInflater.from(getContext()).inflate(R.layout.ebd, this);
        this.f264730d = (ArkView) findViewById(R.id.cvu);
        try {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[1];
                if ((" density= " + displayMetrics) != null) {
                    f16 = displayMetrics.density;
                } else {
                    f16 = -1.0f;
                }
                objArr[0] = Float.valueOf(f16);
                QLog.d("QQGamePub_GameArkView", 4, objArr);
            }
            float f17 = FontSettingManager.systemMetrics.density;
            if (displayMetrics != null) {
                float min = Math.min(f17, displayMetrics.density);
                if (QLog.isColorLevel()) {
                    QLog.d("QQGamePub_GameArkView", 4, "min density= " + min);
                }
                this.f264730d.setScaleDensity(min);
            }
        } catch (Throwable th5) {
            QLog.d("QQGamePub_GameArkView", 4, "set ark density fail:" + th5.getMessage());
        }
    }

    private void d() {
        onPause();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.view.GameArkView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameArkView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    GameArkView.this.onResume();
                }
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            if (this.f264730d != null && GamePubAccountHelper.E(this.f264731e) && this.f264732f) {
                this.f264730d.onPause();
            }
            if (this.D) {
                c();
                this.D = false;
            }
        } catch (Throwable th5) {
            QLog.e("QQGamePub_GameArkView", 1, "-->onLoadState init arkview faile:" + th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void b(QQGameMsgInfo qQGameMsgInfo, Context context, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQGameMsgInfo, context, Integer.valueOf(i3), str);
            return;
        }
        this.C = str;
        if (this.f264730d != null) {
            this.f264735m = qQGameMsgInfo;
            this.f264731e = qQGameMsgInfo.arkAppName;
            ArkView.InitInfo initInfo = new ArkView.InitInfo();
            initInfo.appID = qQGameMsgInfo.arkAppName;
            initInfo.view = qQGameMsgInfo.arkAppView;
            initInfo.minVersion = qQGameMsgInfo.arkAppMinVersion;
            initInfo.meta = qQGameMsgInfo.arkMetaList;
            initInfo.config = qQGameMsgInfo.arkAppConfig;
            if (!TextUtils.isEmpty(qQGameMsgInfo.loadArkResPath)) {
                initInfo.resPath = qQGameMsgInfo.loadArkResPath + this.f264731e;
            }
            this.f264730d.load(initInfo, this);
            this.f264733h = SystemClock.elapsedRealtime();
            if (QLog.isColorLevel()) {
                QLog.i("QQGamePub_GameArkView", 2, "init...mPubType:" + this.C + ",appName:" + this.f264731e + ",loadArkResPath:" + initInfo.resPath + ",process:" + MobileQQ.processName + ",mInitStartTime:" + this.f264733h);
            }
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.D = true;
        if (!this.F) {
            QLog.d("QQGamePub_GameArkView", 1, "not callArKExposure,because ark is not loaded");
        } else if (this.E) {
            d();
            this.E = false;
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ArkView arkView = this.f264730d;
        if (arkView != null) {
            arkView.onDestroy();
        }
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f264731e;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (NativeGestureDispatcher) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return null;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f264734i == 101) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.f264730d != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_GameArkView", 1, "GameArkView onDestory");
            }
            this.f264730d.onDestroy();
        }
    }

    @Override // com.tencent.ark.ArkViewImplement.LoadCallback
    public void onLoadFailed(int i3, int i16, String str, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_GameArkView", 1, "onLoadFailed state=" + i3 + "|errCode=" + i16 + "|errMsg=" + str + "|canRetry=" + z16);
        }
        if (this.f264735m != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f264733h;
            WadlReportBuilder gameAppId = GamePubAccountHelper.r(this.C).setModuleType("76918").setOperId("207984").setExt(2, this.f264735m.advId).setGameAppId(this.f264735m.gameAppId);
            if (elapsedRealtime <= 0) {
                str2 = "";
            } else {
                str2 = String.valueOf(elapsedRealtime);
            }
            gameAppId.setExt(17, str2).setExt(18, this.f264735m.arkAppName).setExt(19, i3 + "").setExt(20, i16 + "").setExt(21, str).setExt(22, z16 + "").report();
        }
    }

    @Override // com.tencent.ark.ArkViewImplement.LoadCallback
    public void onLoadState(int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_GameArkView", 1, "onLoadState state=" + i3);
        }
        this.F = true;
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.view.GameArkView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GameArkView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    GameArkView.this.g();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 500L);
        if (this.f264735m != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f264733h;
            WadlReportBuilder gameAppId = GamePubAccountHelper.r(this.C).setModuleType("76918").setOperId("207984").setExt(2, this.f264735m.advId).setGameAppId(this.f264735m.gameAppId);
            if (elapsedRealtime <= 0) {
                str = "";
            } else {
                str = String.valueOf(elapsedRealtime);
            }
            gameAppId.setExt(17, str).setExt(18, this.f264735m.arkAppName).setExt(19, i3 + "").report();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (this.f264730d != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_GameArkView", 1, "GameArkView onPause");
            }
            this.f264734i = 102;
            this.f264730d.onPause();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.f264730d != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_GameArkView", 1, "GameArkView onResume");
            }
            this.f264734i = 101;
            this.f264730d.onResume();
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) nativeGestureDispatcher);
        }
    }

    public void setPrePause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f264732f = z16;
        }
    }
}
