package com.tencent.nativevue.hippy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mtt.hippy.devsupport.DevServerCallBack;
import com.tencent.mtt.hippy.devsupport.DevSupportManager;
import com.tencent.mtt.hippy.utils.FileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private String f337877d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f337878e;

    /* renamed from: f, reason: collision with root package name */
    private String f337879f;

    /* renamed from: h, reason: collision with root package name */
    private DevSupportManager f337880h;

    /* renamed from: i, reason: collision with root package name */
    private NVHippyModule f337881i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.nativevue.hippy.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C9238a extends AnimatorListenerAdapter {
        C9238a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            a.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements DevServerCallBack {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ rl3.a b(a aVar) {
        aVar.getClass();
        return null;
    }

    private String d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("index");
            if (TextUtils.isEmpty(optString)) {
                return jSONObject.optString((String) jSONObject.keys().next());
            }
            return optString;
        } catch (Exception e16) {
            ql3.a.a("[getDomString]: " + e16.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f337878e) {
            i();
        } else {
            h();
        }
    }

    private void h() {
        if (TextUtils.isEmpty(this.f337877d)) {
            return;
        }
        try {
            String readFile = FileUtils.readFile(this.f337877d);
            if (TextUtils.isEmpty(readFile)) {
                return;
            }
            this.f337879f = d(readFile);
        } catch (Throwable unused) {
        }
    }

    private void i() {
        DevSupportManager devSupportManager = this.f337880h;
        if (devSupportManager == null) {
            return;
        }
        this.f337880h.loadRemoteResource(devSupportManager.createResourceUrl("nv.json"), new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        NVHippyModule nVHippyModule = this.f337881i;
        if (nVHippyModule != null) {
            nVHippyModule.setViewModel(null);
            this.f337881i = null;
        }
    }

    public View e() {
        return null;
    }

    public void f() {
        View e16 = e();
        if (e16 == null) {
            j();
        } else {
            e16.animate().alpha(0.0f).setDuration(150L).setListener(new C9238a()).start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        f();
        EventCollector.getInstance().onViewClicked(view);
    }
}
