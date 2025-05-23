package com.tencent.biz.qqcircle.viewmodels;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.event.QCirclePublishButtonEvent;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import java.util.HashMap;
import qqcircle.QQCircleBase$StPublishButtonAnimationInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h extends com.tencent.biz.qqcircle.viewmodels.a {
    private boolean C;
    private d D;
    private boolean E;
    private boolean F;
    private CountDownTimer G;
    private CountDownTimer H;
    private String J;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<d> f92850m = new MutableLiveData<>();
    private String I = "0";
    private long K = 0;
    private boolean L = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f92854a;

        /* renamed from: b, reason: collision with root package name */
        public String f92855b;

        /* renamed from: c, reason: collision with root package name */
        public String f92856c;

        /* renamed from: d, reason: collision with root package name */
        public String f92857d;

        /* renamed from: e, reason: collision with root package name */
        public NinePatchDrawable f92858e;

        /* renamed from: f, reason: collision with root package name */
        public Drawable f92859f;

        /* renamed from: g, reason: collision with root package name */
        public String f92860g;

        /* renamed from: h, reason: collision with root package name */
        public long f92861h;

        /* renamed from: i, reason: collision with root package name */
        public long f92862i;

        public int a() {
            Drawable drawable = this.f92859f;
            if (drawable != null && this.f92858e != null) {
                return 1;
            }
            if (drawable != null && this.f92858e == null) {
                return 2;
            }
            return -1;
        }

        public String toString() {
            return "PublishButtonEventInfo{isShow=" + this.f92854a + ", hashIcon='" + this.f92855b + "', hashTag='" + this.f92856c + "', words='" + this.f92857d + "', backImgDrawable=" + this.f92858e + ", operatorDrawable=" + this.f92859f + ", jumpUrl='" + this.f92860g + "', animationStartupTime=" + this.f92861h + ", animationShowTime=" + this.f92862i + '}';
        }
    }

    private QCircleLpReportDc05504.DataBuilder Q1(int i3, int i16) {
        QCircleLpReportDc05504.DataBuilder pageId = new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(14).setThrActionType(0).setExt1(String.valueOf(i16)).setExt3(String.valueOf(System.currentTimeMillis())).setExt6("0").setPageId(i3);
        if (this.F) {
            pageId.setExt6(this.I);
            if (this.J != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("YuhengChannelTransInfo", this.J);
                pageId.setExtras(hashMap);
            }
        }
        return pageId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R1() {
        QCircleEeveeMananger.getInstance().deleteBizUndealMsgBuffer(107);
    }

    public void N1() {
        CountDownTimer countDownTimer = this.H;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        d dVar = this.D;
        if (dVar != null) {
            dVar.f92854a = false;
            this.f92850m.postValue(dVar);
        }
    }

    public boolean O1() {
        return this.L;
    }

    public LiveData<d> P1() {
        return this.f92850m;
    }

    public void S1() {
        if (this.D != null && this.E && !this.F) {
            this.E = false;
            CountDownTimer countDownTimer = this.G;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            CountDownTimer countDownTimer2 = this.H;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
            }
        }
    }

    public void T1(QCirclePublishButtonEvent qCirclePublishButtonEvent) {
        if (!this.E && !this.C && qCirclePublishButtonEvent != null && qCirclePublishButtonEvent.mData != null) {
            QQCircleBase$StPublishButtonAnimationInfo qQCircleBase$StPublishButtonAnimationInfo = new QQCircleBase$StPublishButtonAnimationInfo();
            try {
                qQCircleBase$StPublishButtonAnimationInfo.mergeFrom(qCirclePublishButtonEvent.mData);
                if (qQCircleBase$StPublishButtonAnimationInfo.isShowAnimation.get() == 0 || this.D != null) {
                    return;
                }
                d dVar = new d();
                this.D = dVar;
                dVar.f92854a = true;
                dVar.f92855b = qQCircleBase$StPublishButtonAnimationInfo.hashIcon.get();
                this.D.f92856c = qQCircleBase$StPublishButtonAnimationInfo.hashTag.get();
                this.D.f92857d = qQCircleBase$StPublishButtonAnimationInfo.words.get();
                this.D.f92860g = qQCircleBase$StPublishButtonAnimationInfo.jumpUrl.get();
                this.D.f92861h = qQCircleBase$StPublishButtonAnimationInfo.animationStartupTime.get() * 1000;
                this.D.f92862i = qQCircleBase$StPublishButtonAnimationInfo.animationShowTime.get() * 1000;
                this.J = qQCircleBase$StPublishButtonAnimationInfo.reportExt.get();
                this.I = qQCircleBase$StPublishButtonAnimationInfo.taskId.get();
                String url = QCircleSkinHelper.getInstance().getUrl(qQCircleBase$StPublishButtonAnimationInfo.operatorIcon.get());
                if (!TextUtils.isEmpty(url)) {
                    URLDrawable drawable = URLDrawable.getDrawable(url, URLDrawable.URLDrawableOptions.obtain());
                    drawable.setURLDrawableListener(new a());
                    drawable.startDownload();
                }
                String url2 = QCircleSkinHelper.getInstance().getUrl(qQCircleBase$StPublishButtonAnimationInfo.backImg.get());
                if (!TextUtils.isEmpty(url2)) {
                    URLDrawable drawable2 = URLDrawable.getDrawable(url2, URLDrawable.URLDrawableOptions.obtain());
                    drawable2.setURLDrawableListener(new b());
                    drawable2.startDownload();
                }
            } catch (Exception e16) {
                QLog.e("QCirclePublishButtonViewModel", 1, "notifyPublishButtonEvent", e16);
            }
        }
    }

    public void U1() {
        this.D = null;
        this.K = 0L;
        this.I = "0";
        this.F = false;
    }

    public void W1() {
        if (!this.E || this.D == null) {
            return;
        }
        this.K = System.currentTimeMillis();
        long j3 = this.D.f92862i;
        this.H = new c(j3, j3).start();
    }

    public void X1() {
        this.C = true;
    }

    public void Z1(int i3, int i16) {
        QCircleLpReportDc05504.report(Q1(i3, i16).setSubActionType(2));
    }

    public void a2(int i3, int i16) {
        if (this.K > 0) {
            QCircleLpReportDc05504.report(Q1(i3, i16).setSubActionType(1).setExt4(String.valueOf(System.currentTimeMillis() - this.K)));
        } else {
            QCircleLpReportDc05504.report(Q1(i3, i16).setSubActionType(1));
        }
    }

    public void b2(Boolean bool) {
        this.L = bool.booleanValue();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCirclePublishButtonViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.viewmodels.g
            @Override // java.lang.Runnable
            public final void run() {
                h.R1();
            }
        });
        CountDownTimer countDownTimer = this.G;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.H;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c extends CountDownTimer {
        c(long j3, long j16) {
            super(j3, j16);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            h.this.N1();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements URLDrawable.URLDrawableListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QLog.e("QCirclePublishButtonViewModel", 1, "operatorIcon onLoadCanceled");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.e("QCirclePublishButtonViewModel", 1, "operatorIcon onLoadFialed: ", th5);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.i("QCirclePublishButtonViewModel", 1, "operatorIcon onLoadSuccessed");
            if (h.this.D == null) {
                return;
            }
            h.this.D.f92859f = uRLDrawable;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements URLDrawable.URLDrawableListener {
        b() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QLog.e("QCirclePublishButtonViewModel", 1, "backImg onLoadCanceled: ");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.e("QCirclePublishButtonViewModel", 1, "backImg onLoadFialed: ", th5);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.i("QCirclePublishButtonViewModel", 1, "backImg onLoadSuccessed");
            if (h.this.D == null) {
                return;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = 320;
            Bitmap decodeFile = BitmapFactory.decodeFile(uRLDrawable.getFileInLocal().getAbsolutePath(), options);
            if (decodeFile != null) {
                h.this.D.f92858e = new NinePatchDrawable(QCircleApplication.APP.getResources(), decodeFile, new byte[]{1, 2, 2, 3, 32, 0, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 48, 0, 0, 0, -88, 0, 0, 0, -87, 0, 0, 0, 0, 0, 0, 0, -54, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, new Rect(), "");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
