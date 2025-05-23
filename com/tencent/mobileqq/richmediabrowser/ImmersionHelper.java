package com.tencent.mobileqq.richmediabrowser;

import android.os.Handler;
import android.os.Looper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ImmersionHelper {

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.richmediabrowser.presenter.a f281780b;

    /* renamed from: d, reason: collision with root package name */
    public boolean f281782d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f281783e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f281784f;

    /* renamed from: a, reason: collision with root package name */
    private Handler f281779a = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private ImmersionTimerRunnable f281781c = new ImmersionTimerRunnable();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class ImmersionTimerRunnable implements Runnable {
        ImmersionTimerRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "ImmersionTimerRunnable run");
            ImmersionHelper immersionHelper = ImmersionHelper.this;
            immersionHelper.f281782d = true;
            if (immersionHelper.f281780b.f281860f != null) {
                ImmersionHelper.this.f281780b.f281860f.m(false);
            }
        }
    }

    public ImmersionHelper(com.tencent.mobileqq.richmediabrowser.presenter.a aVar) {
        this.f281780b = aVar;
    }

    private int c() {
        RichMediaBaseData richMediaBaseData;
        int i3;
        RichMediaBrowserInfo selectedItem = this.f281780b.f281861h.getSelectedItem();
        if (selectedItem == null || (richMediaBaseData = selectedItem.baseData) == null) {
            return -1;
        }
        if (richMediaBaseData instanceof AIOFilePictureData) {
            return 2;
        }
        if (richMediaBaseData instanceof AIOPictureData) {
            if (!((AIOPictureData) richMediaBaseData).isFromFile) {
                return 1;
            }
        } else {
            if (richMediaBaseData instanceof AIOVideoData) {
                int i16 = ((AIOVideoData) richMediaBaseData).f281846h;
                if (i16 == 0) {
                    i3 = 4;
                } else {
                    if (i16 != 1) {
                        return -1;
                    }
                    i3 = 3;
                }
                return i3;
            }
            if (!(richMediaBaseData instanceof AIOFileVideoData)) {
                return -1;
            }
        }
        return 5;
    }

    private int d(String str) {
        RichMediaBaseData richMediaBaseData;
        boolean z16;
        RichMediaBrowserInfo selectedItem = this.f281780b.f281861h.getSelectedItem();
        if (selectedItem == null || (richMediaBaseData = selectedItem.baseData) == null) {
            return -1;
        }
        if (richMediaBaseData instanceof AIOVideoData) {
            if (!"0X800A99B".equals(str) && !"0X800A9B5".equals(str)) {
                z16 = false;
            } else {
                z16 = true;
            }
            int i3 = ((AIOVideoData) selectedItem.baseData).f281846h;
            if (i3 == 0) {
                if (z16) {
                    return 2;
                }
                if (!"0X8009AA6".equals(str)) {
                    return -1;
                }
            } else {
                if (i3 != 1) {
                    return -1;
                }
                if (!z16 && !"0X8009AA6".equals(str)) {
                    return -1;
                }
            }
            return 1;
        }
        if (!(richMediaBaseData instanceof AIOFileVideoData)) {
            return -1;
        }
        if (!"0X800A99B".equals(str) && !"0X800A9B5".equals(str)) {
            return -1;
        }
        return 3;
    }

    public void b() {
        this.f281783e = false;
        this.f281784f = false;
    }

    public void e() {
        this.f281783e = this.f281780b.f281860f.s();
        this.f281784f = this.f281780b.w();
    }

    public void f() {
        BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "removeImmersionTimer");
        ImmersionTimerRunnable immersionTimerRunnable = this.f281781c;
        if (immersionTimerRunnable != null) {
            this.f281779a.removeCallbacks(immersionTimerRunnable);
        }
        this.f281781c = null;
    }

    public void g() {
        ReportController.o(null, "dc00898", "", "", "0X800A9B4", "0X800A9B4", c(), 0, "", "", "", "");
    }

    public void h() {
        String str;
        int d16 = d("0X800A9B5");
        if (this.f281780b.t()) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(null, "dc00898", "", "", "0X800A9B5", "0X800A9B5", d16, 0, str, "", "", "");
    }

    public void i() {
        int i3;
        if (this.f281782d) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A99B", "0X800A99B", i3, 0, "" + d("0X800A99B"), "", "", "");
    }

    public void j() {
        long j3;
        AppRuntime peekAppRuntime;
        if (!this.f281780b.x()) {
            BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "startImmersionTimer, immersion switch is not open");
            return;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "startImmersionTimer");
        if (this.f281781c == null) {
            this.f281781c = new ImmersionTimerRunnable();
        }
        if (AppSetting.f99565y && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("talkback_fix_enable")) {
            j3 = 12000;
        } else {
            j3 = 5000;
        }
        this.f281779a.postDelayed(this.f281781c, j3);
    }
}
