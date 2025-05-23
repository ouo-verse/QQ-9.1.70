package com.tencent.av.business.manager.pendant;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.b;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import cw.e;

/* loaded from: classes3.dex */
public class EffectPendantTipsImpl implements b {

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f73390a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f73391b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f73392c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f73393d;

    public EffectPendantTipsImpl(Context context) {
        this.f73391b = context;
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.f73393d = sparseIntArray;
        sparseIntArray.put(PTFaceAttr.PTExpression.MOUTH_OPEN.value, R.string.da8);
        sparseIntArray.put(PTFaceAttr.PTExpression.EYEBROWS_RAISE.value, R.string.da6);
        sparseIntArray.put(PTFaceAttr.PTExpression.BLINK.value, R.string.da5);
        sparseIntArray.put(PTFaceAttr.PTExpression.HEAD_SHAKE.value, R.string.da9);
        sparseIntArray.put(PTFaceAttr.PTExpression.KISS.value, R.string.da7);
        sparseIntArray.put(100, R.string.d_w);
    }

    private void k(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f73392c.post(new Runnable() { // from class: com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.p(EffectPendantTipsImpl.this.f73390a, 1016, str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    @Override // com.tencent.av.business.manager.pendant.b
    public void a(final int i3) {
        if (i3 == 0) {
            return;
        }
        this.f73392c.post(new Runnable() { // from class: com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EffectPendantTipsImpl effectPendantTipsImpl = EffectPendantTipsImpl.this;
                    String i16 = effectPendantTipsImpl.i(effectPendantTipsImpl.f73391b, i3);
                    if (!TextUtils.isEmpty(i16)) {
                        e.p(EffectPendantTipsImpl.this.f73390a, 1016, i16);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    @Override // com.tencent.av.business.manager.pendant.b
    public void b(final Drawable drawable, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f73392c.post(new Runnable() { // from class: com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.q(EffectPendantTipsImpl.this.f73390a, 1016, str, drawable, -1, null);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    @Override // com.tencent.av.business.manager.pendant.b
    public void c(int i3) {
        this.f73392c.postDelayed(new Runnable() { // from class: com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.d(EffectPendantTipsImpl.this.f73390a, 1016);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }, i3);
    }

    @Override // com.tencent.av.business.manager.pendant.b
    public void d(String str) {
        k(str);
    }

    @Override // com.tencent.av.business.manager.pendant.b
    public void e(int i3, final b.a aVar) {
        this.f73392c.postDelayed(new Runnable() { // from class: com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.d(EffectPendantTipsImpl.this.f73390a, 1016);
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }, i3);
    }

    @Override // com.tencent.av.business.manager.pendant.b
    public void f(String str) {
        k(str);
    }

    public String i(Context context, int i3) {
        int i16 = this.f73393d.get(i3);
        if (i16 > 0) {
            return context.getResources().getString(i16);
        }
        return null;
    }

    public void j(VideoAppInterface videoAppInterface) {
        this.f73390a = videoAppInterface;
        if (QLog.isColorLevel()) {
            QLog.i("EffectPendantTipsImpl", 2, "setTipsManager, app[" + videoAppInterface + "]");
        }
    }

    public void l(int i3) {
        a(i3);
    }
}
