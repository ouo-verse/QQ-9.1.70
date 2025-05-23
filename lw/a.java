package lw;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.funchat.magicface.MagicfaceViewForAV;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements EffectConfigBase.b<FaceItem> {
    FaceItem C;

    /* renamed from: d, reason: collision with root package name */
    private VideoAppInterface f415662d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.av.business.manager.magicface.a f415663e;

    /* renamed from: f, reason: collision with root package name */
    protected RelativeLayout f415664f;

    /* renamed from: h, reason: collision with root package name */
    protected MagicfaceViewForAV f415665h;

    /* renamed from: i, reason: collision with root package name */
    WeakReference<ViewGroup> f415666i;

    /* renamed from: m, reason: collision with root package name */
    boolean f415667m;

    public a(VideoAppInterface videoAppInterface, Context context) {
        this.f415662d = videoAppInterface;
    }

    private void a() {
        if (this.f415663e == null) {
            this.f415663e = (com.tencent.av.business.manager.magicface.a) this.f415662d.B(3);
        }
    }

    private void f(long j3, ViewGroup viewGroup, boolean z16, FaceItem faceItem, int i3) {
        if (faceItem.isSameType(IndividuationUrlHelper.UrlId.PENDANT_HOME)) {
            g(viewGroup);
        }
        this.f415663e.d0(j3, faceItem, faceItem.getId(), z16, this.f415665h);
    }

    public void b(ViewGroup viewGroup, String str, boolean z16) {
        if (viewGroup == null || !this.f415662d.Y(3)) {
            return;
        }
        a();
        this.f415663e.J(-1048L, this);
        this.f415663e.e0(0, str, z16);
        g(viewGroup);
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onDownloadFinish(long j3, FaceItem faceItem, boolean z16) {
        FaceItem faceItem2;
        ViewGroup viewGroup;
        if (z16 && this.f415666i != null && faceItem != null && (faceItem2 = this.C) != null && faceItem2.getId().equalsIgnoreCase(faceItem.getId()) && (viewGroup = this.f415666i.get()) != null) {
            QLog.w("MagicfaceViewProxy", 1, "onDownloadFinish, prepareShow, seq[" + j3 + "], FaceItem[" + faceItem + "]");
            f(j3, viewGroup, this.f415667m, this.C, 6);
        }
    }

    public void g(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = this.f415664f;
        if (relativeLayout != null) {
            viewGroup.removeView(relativeLayout);
            this.f415665h = null;
            this.f415664f = null;
        }
    }

    public void h(long j3, ViewGroup viewGroup, ControlUIObserver.d dVar) {
        boolean z16;
        boolean z17;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("showView, requestPlayMagicFace[");
        sb5.append(dVar);
        sb5.append("], mRootView[");
        boolean z18 = false;
        if (viewGroup != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("], mItem[");
        sb5.append(this.C);
        sb5.append("], seq[");
        sb5.append(j3);
        sb5.append("]");
        QLog.w("MagicfaceViewProxy", 1, sb5.toString());
        if (viewGroup == null) {
            return;
        }
        a();
        this.f415663e.p(j3, this);
        FaceItem w3 = this.f415663e.w(dVar.f74779f);
        if (w3 != null) {
            com.tencent.av.business.manager.support.a aVar = (com.tencent.av.business.manager.support.a) this.f415662d.B(5);
            boolean n3 = aVar.n(3, "normal");
            boolean n16 = aVar.n(3, "interact");
            if (n3 && (n16 || !w3.isInteract())) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (w3.isUsable()) {
                    f(j3, viewGroup, dVar.f74780g, w3, dVar.f74781h);
                } else {
                    this.f415666i = new WeakReference<>(viewGroup);
                    this.f415667m = dVar.f74780g;
                    this.C = w3;
                    this.f415663e.N(dVar.a(), w3);
                }
            }
            z18 = z17;
        }
        QLog.w("MagicfaceViewProxy", 1, "showView, dimmed[" + z18 + "], item[" + w3 + "]");
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onItemSelectedChanged(long j3, FaceItem faceItem) {
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(FaceItem faceItem, int i3) {
    }
}
