package a13;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.vas.font.drawable.ETDrawable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private static Bitmap f25349a;

    public a(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Bitmap bitmap;
        Bitmap bitmap2;
        int i3 = message.what;
        if (i3 != 2) {
            if (i3 == 3 && (bitmap2 = f25349a) != null) {
                bitmap2.recycle();
                f25349a = null;
                return;
            }
            return;
        }
        com.tencent.mobileqq.vas.font.drawable.a aVar = (com.tencent.mobileqq.vas.font.drawable.a) message.obj;
        if (aVar != null && (bitmap = aVar.f309167f) != null) {
            int width = bitmap.getWidth();
            int height = aVar.f309167f.getHeight();
            Bitmap bitmap3 = f25349a;
            if (bitmap3 != null && (bitmap3.getWidth() < width || f25349a.getHeight() < height)) {
                f25349a.recycle();
                f25349a = null;
            }
            Bitmap bitmap4 = f25349a;
            boolean z16 = false;
            if (bitmap4 == null) {
                f25349a = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            } else {
                bitmap4.eraseColor(0);
            }
            ETEngine instanceForAnimation = ETEngine.getInstanceForAnimation();
            ETDecoration e16 = aVar.f309166e.e(instanceForAnimation, false);
            if (e16 != null) {
                e16.gotoFrame(aVar.f309165d);
            }
            aVar.f309166e.g(instanceForAnimation, f25349a, e16, true);
            if (e16 != null) {
                e16.deleteDescriptor();
            }
            Bitmap bitmap5 = aVar.f309167f;
            ETDrawable eTDrawable = aVar.f309162a.get();
            if (eTDrawable != null) {
                synchronized (eTDrawable.getBitmapLocker()) {
                    if (!bitmap5.isRecycled() && eTDrawable.getMsgId() == aVar.f309163b) {
                        bitmap5.eraseColor(0);
                        instanceForAnimation.native_cloneBitmap(f25349a, bitmap5);
                        z16 = true;
                    }
                }
                if (z16) {
                    eTDrawable.getUiHandler().obtainMessage(1, aVar).sendToTarget();
                }
            }
        }
    }
}
