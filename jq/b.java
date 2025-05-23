package jq;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements GLGestureListener {

    /* renamed from: a, reason: collision with root package name */
    protected View f410819a;

    /* renamed from: b, reason: collision with root package name */
    protected List<AEAbsBottomPanal> f410820b;

    /* renamed from: c, reason: collision with root package name */
    private List<InterfaceC10606b> f410821c;

    /* renamed from: d, reason: collision with root package name */
    private a f410822d;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    /* renamed from: jq.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public interface InterfaceC10606b {
        void a();
    }

    public void a(AEAbsBottomPanal aEAbsBottomPanal) {
        List<AEAbsBottomPanal> list = this.f410820b;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.f410820b = arrayList;
            arrayList.add(aEAbsBottomPanal);
        } else {
            if (list.contains(aEAbsBottomPanal)) {
                return;
            }
            this.f410820b.add(aEAbsBottomPanal);
        }
    }

    public void c(a aVar) {
        this.f410822d = aVar;
    }

    public void d(View view) {
        this.f410819a = view;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public int onGetPriority() {
        return 1060;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public boolean onTouchEvent(MotionEvent motionEvent, boolean z16) {
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction() & 255;
        if (pointerCount != 1 || z16 || action != 0) {
            return false;
        }
        View view = this.f410819a;
        if (view == null) {
            view = GLGestureProxy.getInstance().getGLSurfaceView();
        }
        a aVar = this.f410822d;
        if (aVar != null) {
            aVar.a();
        }
        List<AEAbsBottomPanal> list = this.f410820b;
        if (list != null) {
            for (AEAbsBottomPanal aEAbsBottomPanal : list) {
                if (view != null && aEAbsBottomPanal != null && motionEvent.getY() < view.getHeight() - aEAbsBottomPanal.getHeight() && !aEAbsBottomPanal.g()) {
                    aEAbsBottomPanal.e();
                }
            }
        }
        List<InterfaceC10606b> list2 = this.f410821c;
        if (list2 == null) {
            return false;
        }
        Iterator<InterfaceC10606b> it = list2.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        return false;
    }

    public void b(InterfaceC10606b interfaceC10606b) {
        if (interfaceC10606b == null) {
            return;
        }
        if (this.f410821c == null) {
            this.f410821c = new ArrayList();
        }
        if (this.f410821c.contains(interfaceC10606b)) {
            return;
        }
        this.f410821c.add(interfaceC10606b);
    }
}
