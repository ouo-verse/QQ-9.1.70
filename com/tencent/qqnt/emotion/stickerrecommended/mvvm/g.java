package com.tencent.qqnt.emotion.stickerrecommended.mvvm;

import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.StickerRecKeywordFrom;
import com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.qqnt.emotion.stickerrecommended.mvvm.b;
import com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.IScenesRecommendManager;
import com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.impl.ScenesRecommendManagerImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes24.dex */
public class g extends com.tencent.qqnt.emotion.stickerrecommended.mvvm.base.c<StickerRecRepository> implements b, com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.a {
    static IPatchRedirector $redirector_;
    private MutableLiveData<com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a> C;
    private MutableLiveData<String> D;
    private long E;
    private boolean F;
    private boolean G;
    private int H;
    private String I;

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.b> f356596m;

    public g(StickerRecRepository stickerRecRepository) {
        super(stickerRecRepository);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) stickerRecRepository);
            return;
        }
        this.f356596m = new MutableLiveData<>();
        this.C = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
        this.F = false;
        this.G = false;
        this.H = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(String str) {
        this.D.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(String str, String str2, StickerRecKeywordFrom stickerRecKeywordFrom, final b.a aVar) {
        final boolean z16 = z1(str, str2, stickerRecKeywordFrom);
        if (aVar != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.emotion.stickerrecommended.mvvm.f
                @Override // java.lang.Runnable
                public final void run() {
                    b.a.this.a(z16);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.b
    public void K0(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) appInterface);
        } else {
            ((StickerRecRepository) this.f356560i).i(appInterface);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.b
    public void O0(final String str, final String str2, final StickerRecKeywordFrom stickerRecKeywordFrom, final b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, stickerRecKeywordFrom, aVar);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.stickerrecommended.mvvm.d
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.U1(str, str2, stickerRecKeywordFrom, aVar);
                }
            }, 16, null, false);
        }
    }

    public MutableLiveData<String> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.D;
    }

    public MutableLiveData<com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a> P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.C;
    }

    public MutableLiveData<com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.b> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f356596m;
    }

    public boolean R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.G;
    }

    public void W1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.F = z16;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.b
    public void Y0(com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            this.C.setValue(aVar);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        String str2 = this.I;
        if (QLog.isColorLevel()) {
            QLog.i("StickerRecViewModel", 2, "checkUinIsCurrentChat  uin = " + str + " | curUin = " + str2);
        }
        if (str2 != null && str2.equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.b
    public void d1(boolean z16) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        ((StickerRecRepository) this.f356560i).g(z16);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("StickerRecViewModel", 1, "setListener error, appInterface is null!");
            return;
        }
        IScenesRecommendManager iScenesRecommendManager = ScenesRecommendManagerImpl.get(peekAppRuntime);
        if (z16) {
            gVar = this;
        } else {
            gVar = null;
        }
        iScenesRecommendManager.setUiHelper(gVar);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.b
    public void f0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.G = z16;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.b
    public void init(AIOParam aIOParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aIOParam);
            return;
        }
        if (aIOParam != null) {
            this.H = aIOParam.r().c().e();
            this.I = su3.c.b(aIOParam);
        }
        ((StickerRecRepository) this.f356560i).f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.base.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            super.onCleared();
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.a
    public void v1(com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) cVar);
            return;
        }
        QLog.i("StickerRecViewModel", 1, "handleScenesRec start");
        if (this.H > 0 && !TextUtils.isEmpty(this.I)) {
            if (!((StickerRecRepository) this.f356560i).e().isEmotionRecSettingOpen()) {
                QLog.i("StickerRecViewModel", 1, "handleScenesRec isEmotionRecSettingOpen = false");
                return;
            } else {
                this.E = System.currentTimeMillis();
                ((StickerRecRepository) this.f356560i).e().analyzeForScenesMode(cVar, this.H, this.I);
                return;
            }
        }
        QLog.w("StickerRecViewModel", 1, "[handleScenesRec] mAioParam is null");
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.b
    public boolean z1(final String str, String str2, StickerRecKeywordFrom stickerRecKeywordFrom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, str, str2, stickerRecKeywordFrom)).booleanValue();
        }
        boolean z16 = false;
        if (this.H > 0 && !TextUtils.isEmpty(this.I)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e("StickerRecViewModel", 1, "[handleCommonRec] error, AppInterface is null!");
                return false;
            }
            int maxMatchLength = StickerRecManagerImpl.getMaxMatchLength(peekAppRuntime.getApplicationContext(), peekAppRuntime.getCurrentUin(), 6);
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            if (maxMatchLength >= str.length()) {
                this.E = System.currentTimeMillis();
                IStickerRecManager e16 = ((StickerRecRepository) this.f356560i).e();
                if (e16.hasInit()) {
                    str = e16.preProcessUsrText(str);
                    z16 = ((StickerRecRepository) this.f356560i).e().analyze(str, this.H, this.I, stickerRecKeywordFrom);
                } else {
                    QLog.e("StickerRecViewModel", 1, "[handleCommonRec] error stickerRecManager not init!");
                }
            }
            if (Looper.getMainLooper() != Looper.myLooper()) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.emotion.stickerrecommended.mvvm.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.S1(str);
                    }
                });
            } else {
                this.D.setValue(str);
            }
            return z16;
        }
        QLog.i("StickerRecViewModel", 1, "[handleCommonRec] mAioParam is null");
        return false;
    }
}
