package pq;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a implements GLGestureListener {

    /* renamed from: a, reason: collision with root package name */
    protected View f426979a;

    /* renamed from: b, reason: collision with root package name */
    protected List<AEAbsBottomPanal> f426980b;

    /* renamed from: c, reason: collision with root package name */
    private List<b> f426981c;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC11035a f426982d;

    /* compiled from: P */
    /* renamed from: pq.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public interface InterfaceC11035a {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface b {
        void a();
    }

    public void a(AEAbsBottomPanal aEAbsBottomPanal) {
        List<AEAbsBottomPanal> list = this.f426980b;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.f426980b = arrayList;
            arrayList.add(aEAbsBottomPanal);
        } else {
            if (list.contains(aEAbsBottomPanal)) {
                return;
            }
            this.f426980b.add(aEAbsBottomPanal);
        }
    }

    public void c(InterfaceC11035a interfaceC11035a) {
        this.f426982d = interfaceC11035a;
    }

    public void d(View view) {
        this.f426979a = view;
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
        View view = this.f426979a;
        if (view == null) {
            view = GLGestureProxy.getInstance().getGLSurfaceView();
        }
        InterfaceC11035a interfaceC11035a = this.f426982d;
        if (interfaceC11035a != null) {
            interfaceC11035a.a();
        }
        List<AEAbsBottomPanal> list = this.f426980b;
        if (list != null) {
            for (AEAbsBottomPanal aEAbsBottomPanal : list) {
                if (view != null && aEAbsBottomPanal != null && motionEvent.getY() < view.getHeight() - aEAbsBottomPanal.getHeight() && !aEAbsBottomPanal.g()) {
                    aEAbsBottomPanal.e();
                }
            }
        }
        List<b> list2 = this.f426981c;
        if (list2 == null) {
            return false;
        }
        Iterator<b> it = list2.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        return false;
    }

    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.f426981c == null) {
            this.f426981c = new ArrayList();
        }
        if (this.f426981c.contains(bVar)) {
            return;
        }
        this.f426981c.add(bVar);
    }
}
