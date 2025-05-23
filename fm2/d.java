package fm2;

import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d implements GLGestureListener {

    /* renamed from: a, reason: collision with root package name */
    private ViewPager f399863a;

    public d(ViewPager viewPager) {
        this.f399863a = viewPager;
    }

    public void a(ViewPager viewPager) {
        this.f399863a = viewPager;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public int onGetPriority() {
        return 1012;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public boolean onTouchEvent(MotionEvent motionEvent, boolean z16) {
        ViewPager viewPager;
        ViewPager viewPager2;
        int pointerCount = motionEvent.getPointerCount();
        motionEvent.getAction();
        if (pointerCount == 1 && !z16 && (viewPager2 = this.f399863a) != null && viewPager2.isShown()) {
            try {
                this.f399863a.onTouchEvent(motionEvent);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (pointerCount == 2 && z16 && (viewPager = this.f399863a) != null && viewPager.isShown()) {
            try {
                if (GLGestureProxy.getInstance().checkSecendFinger(motionEvent)) {
                    MotionEvent secendFingerMotionEvent = GLGestureProxy.getInstance().getSecendFingerMotionEvent(motionEvent);
                    this.f399863a.onTouchEvent(secendFingerMotionEvent);
                    secendFingerMotionEvent.recycle();
                    return false;
                }
                return false;
            } catch (Exception e17) {
                e17.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
