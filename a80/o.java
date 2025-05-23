package a80;

import android.graphics.RectF;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.views.pag.PAGImageViewImpl;
import com.tencent.biz.qqcircle.immersive.views.pag.PAGViewImpl;
import com.tencent.biz.qqcircle.immersive.views.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.libpag.PAGFile;

/* compiled from: P */
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Boolean> f25667a = new MutableLiveData<>(null);

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f25668b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private Function0<Unit> f25669c;

    /* renamed from: d, reason: collision with root package name */
    private b f25670d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f25671e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f25672f;

    /* renamed from: g, reason: collision with root package name */
    private i f25673g;

    public static boolean e() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_use_pag_image_view", 1) == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(FrameLayout frameLayout) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f25672f && e()) {
            this.f25670d = new PAGImageViewImpl(frameLayout.getContext());
        } else {
            this.f25670d = new PAGViewImpl(frameLayout.getContext());
        }
        this.f25670d.b(frameLayout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f25670d.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        this.f25670d.setLayoutParams(layoutParams);
        QLog.w("QFSPagAnimationV.PAGViewLoader", 2, "init view cost :" + (System.currentTimeMillis() - currentTimeMillis));
        this.f25667a.postValue(Boolean.TRUE);
        this.f25668b.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(i iVar, FrameLayout frameLayout) {
        PAGFile pAGFile = iVar.d().get(0);
        int measuredHeight = frameLayout.getMeasuredHeight();
        if (measuredHeight == 0) {
            QLog.d("QFSPagAnimationV.PAGViewLoader", 1, "[tryAdjustViewBoundsIfNeed] rootHeight is 0");
            return;
        }
        RectF bounds = pAGFile.getBounds();
        if (bounds != null) {
            QLog.d("QFSPagAnimationV.PAGViewLoader", 1, "tryAdjustViewBoundsIfNeed");
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f25670d.getLayoutParams();
            layoutParams.width = (int) ((measuredHeight / (bounds.bottom - bounds.top)) * (bounds.right - bounds.left));
            layoutParams.height = measuredHeight;
            layoutParams.gravity = 17;
            this.f25670d.setLayoutParams(layoutParams);
            return;
        }
        QLog.d("QFSPagAnimationV.PAGViewLoader", 1, "[tryAdjustViewBoundsIfNeed] bounds is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(FrameLayout frameLayout) {
        if (x.c()) {
            l(frameLayout);
            return;
        }
        QLog.w("QFSPagAnimationV.PAGViewLoader", 1, "init view checkPagSoRead return false");
        this.f25667a.postValue(Boolean.FALSE);
        this.f25668b.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(final FrameLayout frameLayout) {
        if (x.h()) {
            l(frameLayout);
            return null;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: a80.m
            @Override // java.lang.Runnable
            public final void run() {
                o.this.j(frameLayout);
            }
        });
        return null;
    }

    private void l(final FrameLayout frameLayout) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: a80.n
            @Override // java.lang.Runnable
            public final void run() {
                o.this.h(frameLayout);
            }
        });
    }

    public b f() {
        return this.f25670d;
    }

    public boolean g() {
        Boolean value = this.f25667a.getValue();
        if (value != null && value.booleanValue()) {
            return true;
        }
        return false;
    }

    public void m(boolean z16) {
        this.f25671e = z16;
    }

    public void n(boolean z16) {
        this.f25672f = z16;
    }

    public void o(final FrameLayout frameLayout, final i iVar) {
        if (this.f25671e && frameLayout != null && this.f25670d != null) {
            if (!g()) {
                QLog.d("QFSPagAnimationV.PAGViewLoader", 1, "[tryAdjustViewBoundsIfNeed] isViewLoadSucceed false");
            } else {
                if (iVar == null || iVar.d().isEmpty() || this.f25673g == iVar) {
                    return;
                }
                this.f25673g = iVar;
                frameLayout.post(new Runnable() { // from class: a80.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.this.i(iVar, frameLayout);
                    }
                });
            }
        }
    }

    public void p(final FrameLayout frameLayout) {
        if (!this.f25668b.compareAndSet(false, true)) {
            QLog.d("QFSPagAnimationV.PAGViewLoader", 2, "[loadPagFile] is load ing");
        } else {
            if (g()) {
                return;
            }
            this.f25669c = new Function0() { // from class: a80.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit k3;
                    k3 = o.this.k(frameLayout);
                    return k3;
                }
            };
            x.g(new WeakReference(this.f25669c));
        }
    }
}
