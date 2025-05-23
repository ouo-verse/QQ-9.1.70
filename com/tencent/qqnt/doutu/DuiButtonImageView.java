package com.tencent.qqnt.doutu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.doutu.CustomFrameAnimationDrawable;
import com.tencent.qqnt.doutu.api.IDoutuService;
import com.tencent.qqnt.doutu.api.IDoutuUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes24.dex */
public class DuiButtonImageView extends ImageView {
    static IPatchRedirector $redirector_;
    private static List<File> C;

    /* renamed from: h, reason: collision with root package name */
    static WeakReference<DuiButtonImageView> f355984h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile boolean f355985i;

    /* renamed from: m, reason: collision with root package name */
    public static volatile boolean f355986m;

    /* renamed from: d, reason: collision with root package name */
    CustomFrameAnimationDrawable f355987d;

    /* renamed from: e, reason: collision with root package name */
    Context f355988e;

    /* renamed from: f, reason: collision with root package name */
    AIOMsgItem f355989f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31183);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f355985i = false;
        f355986m = false;
        C = new ArrayList();
    }

    public DuiButtonImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f355988e = context;
        }
    }

    private static void a() {
        DuiButtonImageView duiButtonImageView;
        f355985i = true;
        WeakReference<DuiButtonImageView> weakReference = f355984h;
        if (weakReference == null || (duiButtonImageView = weakReference.get()) == null) {
            return;
        }
        duiButtonImageView.m();
    }

    public static void b() {
        DuiButtonImageView duiButtonImageView;
        if (QLog.isColorLevel()) {
            QLog.d("DuiButtonImageView", 2, "doOnFinish");
        }
        f355985i = false;
        WeakReference<DuiButtonImageView> weakReference = f355984h;
        if (weakReference == null || (duiButtonImageView = weakReference.get()) == null) {
            return;
        }
        duiButtonImageView.n();
        f355984h = null;
    }

    public static void c() {
        DuiButtonImageView duiButtonImageView;
        f355985i = false;
        WeakReference<DuiButtonImageView> weakReference = f355984h;
        if (weakReference == null || (duiButtonImageView = weakReference.get()) == null) {
            return;
        }
        duiButtonImageView.j();
    }

    public static void d() {
        a();
    }

    public static void e() {
        if (QLog.isColorLevel()) {
            QLog.d("DuiButtonImageView", 2, "doOnShowFirst");
        }
        a();
    }

    private boolean f() {
        AIOMsgItem aIOMsgItem = this.f355989f;
        if (aIOMsgItem != null) {
            return aIOMsgItem.G();
        }
        return false;
    }

    private static void g(DuiButtonImageView duiButtonImageView) {
        f355984h = new WeakReference<>(duiButtonImageView);
    }

    private void h() {
        IDoutuService iDoutuService;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 1;
            options.inMutable = true;
            List<File> list = C;
            if (list != null && list.size() > 0) {
                Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(C.get(0).getAbsolutePath(), options);
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
                if (waitAppRuntime == null || (iDoutuService = (IDoutuService) waitAppRuntime.getRuntimeService(IDoutuService.class, "")) == null) {
                    return;
                }
                if (decodeFileWithBufferedStream == null) {
                    f355986m = false;
                    ((IDoutuUtils) QRoute.api(IDoutuUtils.class)).markResDamaged(this.f355988e);
                }
                this.f355987d = new CustomFrameAnimationDrawable(this.f355988e.getResources(), decodeFileWithBufferedStream, iDoutuService.getDoutuAnimationHandler());
                for (int i3 = 0; i3 < C.size(); i3++) {
                    File file = C.get(i3);
                    if (file != null) {
                        this.f355987d.i(i3, 77, file.getAbsolutePath());
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static boolean i() {
        File file = new File(IDoutuUtils.DOUTU_ANIMA_RES_PATH + IDoutuUtils.DUI_ICONS_RES_PATH);
        if (file.exists()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            C.add(file2);
                        }
                    }
                    if (C.size() > 1) {
                        Collections.sort(C);
                    }
                    f355986m = true;
                    return true;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private void l(boolean z16) {
        AIOMsgItem aIOMsgItem = this.f355989f;
        if (aIOMsgItem != null) {
            aIOMsgItem.p1(z16);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        CustomFrameAnimationDrawable customFrameAnimationDrawable = this.f355987d;
        if (customFrameAnimationDrawable != null) {
            customFrameAnimationDrawable.p();
        }
    }

    public boolean k() {
        CustomFrameAnimationDrawable.b bVar;
        ArrayList<CustomFrameAnimationDrawable.d> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        f355984h = null;
        if (QLog.isDevelopLevel()) {
            QLog.d("DuiButtonImageView", 4, "resumeAnim");
        }
        CustomFrameAnimationDrawable customFrameAnimationDrawable = this.f355987d;
        if (customFrameAnimationDrawable != null && (bVar = customFrameAnimationDrawable.f355958e) != null && (arrayList = bVar.f355969b) != null && arrayList.size() > 0) {
            this.f355987d.t();
        } else {
            if (QLog.isDevelopLevel()) {
                QLog.d("DuiButtonImageView", 4, "showLastFrame");
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                options.inMutable = true;
                if (C.size() > 0) {
                    List<File> list = C;
                    Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(list.get(list.size() - 1).getAbsolutePath(), options);
                    if (decodeFileWithBufferedStream == null) {
                        f355986m = false;
                        ((IDoutuUtils) QRoute.api(IDoutuUtils.class)).markResDamaged(this.f355988e);
                    }
                    setImageBitmap(decodeFileWithBufferedStream);
                    return true;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("DuiButtonImageView", 2, "resumeAnim error!", e16);
                }
            } catch (OutOfMemoryError unused) {
                QLog.e("DuiButtonImageView", 1, "oom occur!");
                System.gc();
            }
        }
        return false;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!f355985i) {
            g(this);
            return;
        }
        if (f()) {
            k();
            return;
        }
        h();
        CustomFrameAnimationDrawable customFrameAnimationDrawable = this.f355987d;
        if (customFrameAnimationDrawable != null) {
            customFrameAnimationDrawable.v();
            this.f355987d.u();
            setImageDrawable(this.f355987d);
            this.f355987d.x();
            l(true);
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DuiButtonImageView", 2, "stopAnim");
        }
        f355984h = null;
        CustomFrameAnimationDrawable customFrameAnimationDrawable = this.f355987d;
        if (customFrameAnimationDrawable != null) {
            customFrameAnimationDrawable.stop();
        }
    }

    public void setMsg(AIOMsgItem aIOMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aIOMsgItem);
        } else {
            this.f355989f = aIOMsgItem;
        }
    }
}
