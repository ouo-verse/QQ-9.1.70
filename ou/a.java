package ou;

import android.content.ContentResolver;
import android.content.Context;
import android.os.SystemClock;
import android.provider.Settings;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.utils.ad;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.avcore.jni.render.FocusDetectCallback;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import wy2.c;
import wy2.d;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements fx.a {
    @Override // fx.a
    public void a() {
        URLDrawable.clearMemoryCache();
    }

    @Override // fx.a
    public int b() {
        return c.d().e();
    }

    @Override // fx.a
    public boolean c(Context context) {
        return ad.p(context);
    }

    @Override // fx.a
    public void d(Context context, String str) {
        QavCameraUsage.c(context, "switchCamera");
    }

    @Override // fx.a
    public int e(Context context, boolean z16, boolean z17, byte b16, boolean z18) {
        return pu.c.b(context, z16, z17, b16, z18);
    }

    @Override // fx.a
    public boolean f(Context context) {
        return ad.a(context, "ro.qq.orientation").equalsIgnoreCase("ZTE");
    }

    @Override // fx.a
    public boolean g() {
        return "1".equalsIgnoreCase(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.use720PCameraPreviewSize.name(), "0"));
    }

    @Override // fx.a
    public boolean h() {
        mv.a a16 = mv.a.a();
        if (a16 != null && a16.g()) {
            return true;
        }
        return false;
    }

    @Override // fx.a
    public void i(boolean z16, List<String> list, FocusDetectCallback focusDetectCallback) {
        if (!list.contains("auto")) {
            return;
        }
        if (z16) {
            NtrtcVideoRender.getInstance().setFocusDetectCallback(focusDetectCallback);
            NtrtcVideoRender.getInstance().setFocusConfig(true, SystemClock.elapsedRealtime(), 111, 3000);
        } else {
            NtrtcVideoRender.getInstance().setFocusDetectCallback(null);
            NtrtcVideoRender.getInstance().setFocusConfig(false, SystemClock.elapsedRealtime(), 111, 3000);
        }
    }

    @Override // fx.a
    public boolean isSupportSurfaceMode() {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).isSupportSurfaceMode();
    }

    @Override // fx.a
    public boolean j() {
        return ad.k();
    }

    @Override // fx.a
    public boolean k(Context context) {
        ContentResolver contentResolver;
        int i3;
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            return false;
        }
        try {
            i3 = Settings.System.getInt(contentResolver, "accelerometer_rotation", 1);
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = 1;
        }
        if (i3 == 1) {
            return false;
        }
        return true;
    }

    @Override // fx.a
    public void l(Context context, String str) {
        QavCameraUsage.e(context, "switchCamera");
    }

    @Override // fx.a
    public boolean m() {
        return d.f446758h;
    }

    @Override // fx.a
    public void n(boolean z16) {
        NtrtcVideoRender.getInstance().setIsFocusing(z16);
    }

    @Override // fx.a
    public int o(Context context, boolean z16, boolean z17, byte b16, boolean z18) {
        return pu.c.i(context, z16, z17, b16, z18);
    }
}
