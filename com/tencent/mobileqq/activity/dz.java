package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes9.dex */
public class dz implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private b C;
    private b D;
    private int E;
    private ArrayList<String> F;
    private Map<String, String> G;
    private boolean H;
    private int I;
    private MqqHandler J;
    private QQAppInterface K;
    private boolean L;

    /* renamed from: d, reason: collision with root package name */
    private ImageSwitcher f181899d;

    /* renamed from: e, reason: collision with root package name */
    private ImageSwitcher f181900e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f181901f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f181902h;

    /* renamed from: i, reason: collision with root package name */
    private b f181903i;

    /* renamed from: m, reason: collision with root package name */
    private b f181904m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f181905d;

        a(boolean z16) {
            this.f181905d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, dz.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            if (this.f181905d && dz.this.F != null && dz.this.F.size() >= 2) {
                dz.this.J.sendEmptyMessageDelayed(1688002, 1400L);
            }
            if (dz.this.f181903i != null) {
                dz.this.f181903i.f();
                dz.this.f181903i = null;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        private static final Object f181907e;

        /* renamed from: f, reason: collision with root package name */
        private static b f181908f;

        /* renamed from: g, reason: collision with root package name */
        private static int f181909g;

        /* renamed from: a, reason: collision with root package name */
        String f181910a;

        /* renamed from: b, reason: collision with root package name */
        volatile boolean f181911b;

        /* renamed from: c, reason: collision with root package name */
        Drawable f181912c;

        /* renamed from: d, reason: collision with root package name */
        private b f181913d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67188);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f181907e = new Object();
                f181909g = 0;
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static b d() {
            synchronized (f181907e) {
                b bVar = f181908f;
                if (bVar != null) {
                    f181908f = bVar.f181913d;
                    bVar.f181913d = null;
                    f181909g--;
                    return bVar;
                }
                return new b();
            }
        }

        static b e(String str, QQAppInterface qQAppInterface, @NonNull dz dzVar) {
            if (QLog.isColorLevel()) {
                QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "obtain FacePlayInfo:", str);
            }
            b d16 = d();
            d16.f181910a = str;
            Drawable b16 = d16.b();
            if (b16 instanceof FaceDrawable) {
                ((FaceDrawable) b16).cancel();
            }
            Map map = dzVar.G;
            if (dzVar.j() && map != null && !TextUtils.isEmpty((CharSequence) map.get(str))) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable defaultFaceDrawable = ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true);
                obtain.mLoadingDrawable = defaultFaceDrawable;
                obtain.mFailedDrawable = defaultFaceDrawable;
                d16.f181912c = new be2.a(URLDrawable.getDrawable((String) map.get(str), obtain));
            } else {
                d16.f181912c = FaceDrawable.getUserFaceDrawable(qQAppInterface, String.valueOf(str), (byte) 4);
            }
            d16.f181911b = false;
            return d16;
        }

        boolean a(String str) {
            if (!this.f181911b && str != null && str.equals(this.f181910a)) {
                return true;
            }
            return false;
        }

        Drawable b() {
            Drawable drawable = this.f181912c;
            if (drawable == null) {
                return null;
            }
            return drawable;
        }

        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.f181911b;
        }

        void f() {
            if (QLog.isColorLevel()) {
                QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "recycle FacePlayInfo:", this.f181910a);
            }
            this.f181911b = true;
            Drawable b16 = b();
            if (b16 instanceof FaceDrawable) {
                ((FaceDrawable) b16).cancel();
            }
            this.f181910a = null;
            synchronized (f181907e) {
                if (f181909g < 3) {
                    this.f181913d = f181908f;
                    f181908f = this;
                }
            }
        }
    }

    public dz(ImageSwitcher imageSwitcher, ImageSwitcher imageSwitcher2, ImageView imageView, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, imageSwitcher, imageSwitcher2, imageView, qQAppInterface);
            return;
        }
        this.f181902h = false;
        this.I = 0;
        this.L = false;
        this.f181899d = imageSwitcher;
        this.f181900e = imageSwitcher2;
        this.f181901f = imageView;
        this.J = new MqqHandler(Looper.getMainLooper(), this);
        this.K = qQAppInterface;
    }

    private String B(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        return HardCodeUtil.qqStr(R.string.nlq);
                    }
                    return HardCodeUtil.qqStr(R.string.nlv);
                }
                return HardCodeUtil.qqStr(R.string.nlt);
            }
            return HardCodeUtil.qqStr(R.string.nlu);
        }
        return HardCodeUtil.qqStr(R.string.nls);
    }

    private void g() {
        b bVar = this.f181903i;
        if (bVar != null && !bVar.c()) {
            this.f181903i.f();
            this.f181903i = null;
        }
        b bVar2 = this.f181904m;
        if (bVar2 != null && !bVar2.c()) {
            this.f181904m.f();
            this.f181904m = null;
        }
        b bVar3 = this.C;
        if (bVar3 != null && !bVar3.c()) {
            this.C.f();
            this.C = null;
        }
        b bVar4 = this.D;
        if (bVar4 != null && !bVar4.c()) {
            this.D.f();
            this.D = null;
        }
    }

    private boolean h() {
        if (this.f181899d == null) {
            if (QLog.isColorLevel()) {
                QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "mQzoneFeedSubIcon=null");
            }
            return false;
        }
        ArrayList<String> arrayList = this.F;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "activeFeedsUin\u6ca1\u6709uin\u6570\u636e");
        }
        return false;
    }

    private void i() {
        ImageSwitcher imageSwitcher = this.f181899d;
        if (imageSwitcher == null) {
            return;
        }
        Animation inAnimation = imageSwitcher.getInAnimation();
        if (inAnimation != null) {
            inAnimation.cancel();
        }
        Animation outAnimation = this.f181899d.getOutAnimation();
        if (outAnimation != null) {
            outAnimation.cancel();
        }
        this.f181899d.setOutAnimation(null);
        this.f181899d.setInAnimation(null);
        this.f181900e.setOutAnimation(null);
        this.f181900e.setInAnimation(null);
        for (int i3 = 0; i3 < this.f181899d.getChildCount(); i3++) {
            View childAt = this.f181899d.getChildAt(i3);
            if (childAt != null) {
                childAt.clearAnimation();
            }
        }
        for (int i16 = 0; i16 < this.f181900e.getChildCount(); i16++) {
            View childAt2 = this.f181900e.getChildAt(i16);
            if (childAt2 != null) {
                childAt2.clearAnimation();
            }
        }
        this.L = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        return this.H;
    }

    private b k(String str) {
        b bVar = this.D;
        if (bVar != null) {
            if (bVar.a(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "\u547d\u4e2d\u9884\u52a0\u8f7dfaceDrawable  uin:" + str);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "\u6ca1\u6709\u547d\u4e2d\u9884\u52a0\u8f7d\uff0c\u56de\u6536\u9884\u52a0\u8f7d:" + str);
                }
                this.D.f();
                this.D = null;
            }
        }
        return this.D;
    }

    private boolean n(int i3) {
        if (this.I >= i3) {
            return true;
        }
        return false;
    }

    private boolean o(int i3) {
        if (this.I < i3) {
            return true;
        }
        return false;
    }

    private static boolean p(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList == null && arrayList2 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, " equal arrayList1==null&&arrayList2==null");
            }
            return true;
        }
        if (arrayList != null && arrayList2 != null) {
            if (arrayList.size() != arrayList2.size()) {
                if (QLog.isColorLevel()) {
                    QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "not equal arrayList1.size()!=arrayList2.size()");
                }
                return false;
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                try {
                    String str = arrayList.get(i3);
                    String str2 = arrayList2.get(i3);
                    if (!str.equals(str2)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("not equal index: %d,uin1:%s,uin2:%s", Integer.valueOf(i3), str, str2));
                        }
                        return false;
                    }
                } catch (Throwable th5) {
                    QLog.e("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 1, th5, new Object[0]);
                    return false;
                }
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "not equal  arrayList1==null||arrayList2==null");
        }
        return false;
    }

    private boolean q() {
        if (this.E >= this.F.size() || ((this.f181902h && this.F.size() == 2) || (this.f181902h && this.E >= this.F.size() - 1))) {
            b bVar = this.D;
            if (bVar != null && this.I != 4) {
                if (this.f181902h) {
                    b bVar2 = this.C;
                    if (bVar2 != null && !bVar2.c()) {
                        if (!this.C.f181910a.equals(this.F.get(1))) {
                            if (!this.C.c()) {
                                this.C.f();
                                this.C = null;
                            }
                            String str = this.F.get(1);
                            if (!this.D.c() && this.D.f181910a.equals(str)) {
                                this.C = this.D;
                                this.D = null;
                            } else {
                                this.C = b.e(str, this.K, this);
                            }
                        }
                    } else {
                        String str2 = this.F.get(1);
                        if (!this.D.c() && this.D.f181910a.equals(str2)) {
                            this.C = this.D;
                            this.D = null;
                        } else {
                            this.C = b.e(str2, this.K, this);
                        }
                    }
                    this.f181900e.setImageDrawable(this.C.f181912c);
                    if (QLog.isColorLevel()) {
                        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "isPlayFinished play two" + this.C.f181910a);
                    }
                    String str3 = this.F.get(0);
                    b bVar3 = this.D;
                    if (bVar3 != null && !bVar3.c() && this.D.f181910a.equals(str3)) {
                        this.f181899d.setImageDrawable(this.D.f181912c);
                        this.f181903i = this.f181904m;
                        this.f181904m = this.D;
                        this.D = null;
                    } else {
                        this.f181903i = this.f181904m;
                        b bVar4 = this.D;
                        if (bVar4 != null && !bVar4.c()) {
                            this.D.f();
                            this.D = null;
                        }
                        b e16 = b.e(str3, this.K, this);
                        this.f181904m = e16;
                        this.f181899d.setImageDrawable(e16.f181912c);
                    }
                } else {
                    this.f181899d.setImageDrawable(bVar.f181912c);
                    this.f181903i = this.f181904m;
                    this.f181904m = this.D;
                    this.D = null;
                    if (QLog.isColorLevel()) {
                        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "isPlayFinished play one" + this.f181904m.f181910a);
                    }
                }
            }
            this.I = 4;
        }
        if (this.I != 4) {
            return false;
        }
        return true;
    }

    private void y() {
        ImageView imageView = this.f181901f;
        if (imageView != null) {
            if (this.f181902h) {
                if (imageView.getVisibility() != 0) {
                    this.f181901f.setVisibility(0);
                }
            } else if (imageView.getVisibility() != 8) {
                this.f181901f.setVisibility(8);
            }
        }
    }

    public void A(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
            return;
        }
        if (map == null) {
            return;
        }
        this.G = map;
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        z(arrayList);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        QQAppInterface qQAppInterface = this.K;
        if (qQAppInterface != null && "0".equals(qQAppInterface.getCurrentAccountUin())) {
            return false;
        }
        switch (message.what) {
            case 1688002:
                u();
                return true;
            case 1688003:
                this.E = 0;
                ArrayList<String> arrayList = this.F;
                if (arrayList != null) {
                    arrayList.clear();
                }
                return true;
            default:
                return false;
        }
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        ArrayList<String> arrayList = this.F;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ArrayList<String> arrayList = this.F;
        if (arrayList != null) {
            arrayList.clear();
            this.E = 0;
        }
        this.f181902h = false;
        i();
        ImageSwitcher imageSwitcher = this.f181899d;
        if (imageSwitcher != null) {
            imageSwitcher.setImageDrawable(null);
            this.f181899d.setVisibility(8);
        }
        ImageSwitcher imageSwitcher2 = this.f181900e;
        if (imageSwitcher2 != null) {
            imageSwitcher2.setImageDrawable(null);
            this.f181900e.setVisibility(8);
        }
        ImageView imageView = this.f181901f;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        g();
    }

    public void r(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) qQAppInterface);
        } else {
            m();
            this.K = qQAppInterface;
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            m();
            this.K = null;
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "pausePlayFace pre playState=" + B(this.I));
        }
        if (n(2) && o(4)) {
            this.J.removeMessages(1688002);
            this.I = 1;
        }
    }

    void u() {
        try {
            if (h()) {
                if (q()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "\u5df2\u7ecf\u64ad\u653e\u5b8c\u6bd5\uff0c\u4e0d\u518d\u8f6e\u64ad\u5934\u50cf");
                        return;
                    }
                    return;
                }
                if (n(2)) {
                    if (this.F.size() > 1 && this.E > 0) {
                        w(true);
                    } else {
                        i();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("play index :%d, uin:%s,total size=:%d", Integer.valueOf(this.E), this.F.get(this.E), Integer.valueOf(this.F.size())));
                    }
                    this.f181903i = this.f181904m;
                    String str = this.F.get(this.E);
                    if (this.f181902h) {
                        b bVar = this.C;
                        if (bVar != null && !bVar.c()) {
                            if (this.C.f181910a.equals(str)) {
                                this.f181904m = this.C;
                                this.C = null;
                            } else if (!this.C.c()) {
                                this.C.f();
                                this.C = null;
                            }
                        } else {
                            b bVar2 = this.f181904m;
                            if (bVar2 == null || (!bVar2.c() && !this.f181904m.f181910a.equals(str))) {
                                this.f181904m = b.e(str, this.K, this);
                            }
                        }
                        this.f181899d.setImageDrawable(this.f181904m.b());
                        if (QLog.isColorLevel()) {
                            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "play two" + this.f181904m.f181910a);
                        }
                        b k3 = k(this.F.get(this.E + 1));
                        this.C = k3;
                        if (k3 == null) {
                            this.C = b.e(this.F.get(this.E + 1), this.K, this);
                        }
                        Drawable b16 = this.C.b();
                        if (b16 != null) {
                            this.f181900e.setImageDrawable(b16);
                            if (QLog.isColorLevel()) {
                                QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "play two" + this.C.f181910a);
                            }
                        }
                    } else {
                        b k16 = k(str);
                        this.f181904m = k16;
                        if (k16 == null) {
                            this.f181904m = b.e(str, this.K, this);
                        }
                        Drawable b17 = this.f181904m.b();
                        if (b17 != null) {
                            this.f181899d.setImageDrawable(b17);
                            if (QLog.isColorLevel()) {
                                QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "play one" + this.f181904m.f181910a);
                            }
                        }
                    }
                    if (this.E == 0) {
                        this.J.sendEmptyMessageDelayed(1688002, 1400L);
                    }
                    int i3 = this.E + 1;
                    this.E = i3;
                    if ((this.f181902h && i3 < this.F.size() - 1) || (!this.f181902h && this.E < this.F.size())) {
                        String str2 = this.F.get(this.E);
                        if (this.f181902h) {
                            str2 = this.F.get(this.E + 1);
                        }
                        this.D = b.e(str2, this.K, this);
                        return;
                    }
                    if ((!this.f181902h && this.E == this.F.size()) || (this.f181902h && this.E == this.F.size() - 1)) {
                        this.D = b.e(this.F.get(0), this.K, this);
                        if (this.f181902h) {
                            this.C = b.e(this.F.get(1), this.K, this);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "\u64ad\u653e\u72b6\u6001\u4e0d\u5bf9\uff0c\u4e0d\u8fdb\u884c\u64ad\u653e playState:" + this.I);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "\u975e\u6cd5\u72b6\u6001\uff0c\u4e0d\u8fdb\u884c\u64ad\u653e\u4e0b\u4e00\u5f20\u5934\u50cf");
            }
        } catch (Throwable th5) {
            QLog.e("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 1, "\u64ad\u653e\u5934\u50cf\u8fc7\u7a0b\u4e2d\u51fa\u73b0\u9519\u8bef\uff0c\u8bf7\u5173\u6ce8\u5f02\u5e38\u4fe1\u606f", th5);
            ((IQzoneExceptionReport) QRoute.api(IQzoneExceptionReport.class)).doReport(th5, HardCodeUtil.qqStr(R.string.nlr));
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        y();
        if (QLog.isColorLevel()) {
            QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "resumePlayFace pre playState=" + B(this.I));
        }
        if (!o(4)) {
            this.I = 2;
            this.E = 0;
            u();
        } else if (n(1)) {
            this.I = 2;
            ArrayList<String> arrayList = this.F;
            if (arrayList != null && this.E >= arrayList.size()) {
                this.E = 0;
            }
            u();
        }
    }

    void w(boolean z16) {
        ImageSwitcher imageSwitcher = this.f181899d;
        if (imageSwitcher == null || this.L) {
            return;
        }
        imageSwitcher.setAnimateFirstView(false);
        this.f181900e.setAnimateFirstView(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1400L);
        alphaAnimation.setAnimationListener(new a(z16));
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setDuration(1400L);
        this.f181899d.setInAnimation(alphaAnimation);
        this.f181900e.setInAnimation(alphaAnimation2);
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation3.setDuration(1400L);
        this.f181899d.setOutAnimation(alphaAnimation3);
        this.f181900e.setOutAnimation(alphaAnimation3);
        this.L = true;
    }

    public void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.H = z16;
        }
    }

    public void z(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
            return;
        }
        if (this.K == null) {
            return;
        }
        if (arrayList != null && arrayList.size() > 1) {
            this.f181902h = true;
        } else {
            this.f181902h = false;
        }
        if (o(2) || !p(this.F, arrayList)) {
            this.J.removeMessages(1688002);
            if (arrayList != null && !arrayList.isEmpty()) {
                this.I = 2;
                this.E = 0;
                ArrayList<String> arrayList2 = this.F;
                if (arrayList2 == null) {
                    this.F = new ArrayList<>(arrayList.size());
                } else {
                    arrayList2.clear();
                }
                this.F.addAll(arrayList);
                String str = this.F.get(this.E);
                if (this.f181902h) {
                    str = this.F.get(this.E + 1);
                }
                this.D = b.e(str, this.K, this);
                if (this.f181899d.getVisibility() != 0) {
                    this.f181899d.setVisibility(0);
                }
                if (this.f181902h) {
                    if (this.f181900e.getVisibility() != 0) {
                        this.f181900e.setVisibility(0);
                    }
                    y();
                } else {
                    ImageSwitcher imageSwitcher = this.f181900e;
                    if (imageSwitcher != null) {
                        imageSwitcher.setVisibility(8);
                    }
                    ImageView imageView = this.f181901f;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                }
                u();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "start play qzone face \u66f4\u65b0\u6570\u636e\u4e3a null\uff0c\u9690\u85cf\u5934\u50cf");
            }
            m();
            this.I = 0;
        }
    }
}
