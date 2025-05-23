package com.tencent.ecommerce.biz.hr.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.biz.hr.ECHRFragment;
import com.tencent.ecommerce.biz.hr.ktx.b;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.vivo.push.PushClientConstants;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u0006B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0014R\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRFragmentView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "c", "", "a", "", "propKey", "", "propValue", "b", NodeProps.ON_ATTACHED_TO_WINDOW, "d", "Ljava/lang/String;", PushClientConstants.TAG_CLASS_NAME, "e", "argument", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "f", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "fragment", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", h.F, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRFragmentView extends FrameLayout implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String className;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String argument;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ECBaseFragment fragment;

    public HRFragmentView(Context context) {
        super(context);
        this.className = "";
        this.argument = "";
        LayoutInflater.from(context).inflate(R.layout.cro, (ViewGroup) this, true);
    }

    private final boolean a() {
        FragmentManager childFragmentManager;
        if (this.fragment != null) {
            ECHRFragment b16 = b.b(this);
            if (((b16 == null || (childFragmentManager = b16.getChildFragmentManager()) == null) ? null : childFragmentManager.findFragmentByTag("HRFragmentView")) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c() {
        if (a()) {
            return;
        }
        try {
            ECHRFragment b16 = b.b(this);
            Intrinsics.checkNotNull(b16);
            FragmentTransaction beginTransaction = b16.getChildFragmentManager().beginTransaction();
            Class<?> cls = Class.forName(this.className);
            Bundle bundle = new Bundle();
            bundle.putString("argument", this.argument);
            Unit unit = Unit.INSTANCE;
            beginTransaction.add(R.id.nzv, cls, bundle, "HRFragmentView").commitAllowingStateLoss();
        } catch (Throwable th5) {
            cg0.a.a("HRFragmentView", "tryAttachFragment", "instance fragment failed, e=" + th5.getMessage());
        }
    }

    @Override // i01.c
    public boolean b(String propKey, Object propValue) {
        int hashCode = propKey.hashCode();
        if (hashCode != -1589682499) {
            if (hashCode == 1412273729 && propKey.equals("fragment_class_name")) {
                if (!(propValue instanceof String)) {
                    propValue = null;
                }
                String str = (String) propValue;
                this.className = str != null ? str : "";
                return true;
            }
        } else if (propKey.equals("argument")) {
            if (!(propValue instanceof String)) {
                propValue = null;
            }
            String str2 = (String) propValue;
            this.argument = str2 != null ? str2 : "";
            return true;
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.a
    public Object call(String str, Object obj, Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // i01.a
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
    }

    @Override // i01.c
    public boolean s(String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    public void setShadow(i01.b bVar) {
        c.a.q(this, bVar);
    }

    @Override // i01.c, i01.a
    public Object call(String str, String str2, Function1<Object, Unit> function1) {
        return c.a.b(this, str, str2, function1);
    }
}
