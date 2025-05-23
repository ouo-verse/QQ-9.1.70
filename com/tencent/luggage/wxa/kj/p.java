package com.tencent.luggage.wxa.kj;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.luggage.wxa.fd.b;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.kj.g;
import com.tencent.luggage.wxa.kj.i1;
import com.tencent.luggage.wxa.xd.g;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p extends FrameLayout {
    public static final int R = 2131363125;
    public com.tencent.luggage.wxa.kj.v C;
    public com.tencent.luggage.wxa.kj.v D;
    public boolean E;
    public com.tencent.luggage.wxa.kj.n F;
    public i1 G;
    public final com.tencent.luggage.wxa.kj.i0 H;
    public long I;
    public k0 J;
    public final com.tencent.luggage.wxa.kj.k0 K;
    public boolean L;
    public j0 M;
    public n0 N;
    public m0 O;
    public boolean P;
    public i0 Q;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f132281a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.ic.g f132282b;

    /* renamed from: c, reason: collision with root package name */
    public String f132283c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f132284d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f132285e;

    /* renamed from: f, reason: collision with root package name */
    public e0 f132286f;

    /* renamed from: g, reason: collision with root package name */
    public f0 f132287g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f132288h;

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f132289i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedList f132290j;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedList f132291k;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedList f132292l;

    /* renamed from: m, reason: collision with root package name */
    public final LinkedList f132293m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132294a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f132295b;

        public a(com.tencent.luggage.wxa.kj.n nVar, String str) {
            this.f132294a = nVar;
            this.f132295b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int e16 = p.this.e(this.f132294a);
            if (e16 >= 0) {
                p.this.b(e16 + 1, this.f132295b, (JSONObject) null, (com.tencent.luggage.wxa.nj.f) null);
            } else {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandPageContainer", "navigateBack with appId(%s) Page(%s), but already off stack, maybe frequent clicks were performed", p.this.getAppId(), this.f132294a.getCurrentUrl());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132297a;

        public a0(String str) {
            this.f132297a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.c(this.f132297a, k1.SWITCH_TAB);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132299a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f132300b;

        public b(com.tencent.luggage.wxa.kj.n nVar, String str) {
            this.f132299a = nVar;
            this.f132300b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.b(p.this.e(this.f132299a), this.f132300b, (JSONObject) null, (com.tencent.luggage.wxa.nj.f) null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b0 implements h0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f132302a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f132303b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f132304c = false;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f132305d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ k1 f132306e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f132307f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f132308g;

        public b0(String str, k1 k1Var, long j3, JSONObject jSONObject) {
            this.f132305d = str;
            this.f132306e = k1Var;
            this.f132307f = j3;
            this.f132308g = jSONObject;
        }

        @Override // com.tencent.luggage.wxa.kj.p.h0
        public void a(boolean z16) {
            this.f132304c = !z16;
        }

        @Override // com.tencent.luggage.wxa.kj.p.h0
        public void cancel() {
            this.f132303b = true;
        }

        @Override // com.tencent.luggage.wxa.kj.p.h0
        public void proceed() {
            if (this.f132303b) {
                return;
            }
            if (p.this.f132282b == null) {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandPageContainer", "attempt to proceed but destroyed, url[%s], type[%s]", this.f132305d, this.f132306e);
                return;
            }
            if (!this.f132302a) {
                p.this.a(this.f132307f, this.f132305d, this.f132306e, this.f132304c, this.f132308g);
                this.f132302a = true;
                if (p.this.J != null) {
                    k0 k0Var = p.this.J;
                    com.tencent.luggage.wxa.kj.n currentPage = p.this.getCurrentPage();
                    Objects.requireNonNull(currentPage);
                    k0Var.a(currentPage, this.f132306e);
                }
            }
        }

        @Override // com.tencent.luggage.wxa.kj.p.h0
        public void a(String str, Object obj) {
            p.this.H.a(this.f132307f, str, obj, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132310a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f132311b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f132312c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f132313d;

        public c(String str, int i3, JSONObject jSONObject, long j3) {
            this.f132310a = str;
            this.f132311b = i3;
            this.f132312c = jSONObject;
            this.f132313d = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.kj.n nVar;
            synchronized (p.this.f132289i) {
                p.this.b();
                com.tencent.luggage.wxa.kj.n currentPage = p.this.getCurrentPage();
                if (currentPage != null && (currentPage.getCurrentRenderPagesCount() > 1 || p.this.d(currentPage) != null)) {
                    if (this.f132311b <= currentPage.getCurrentRenderPagesCount() - 1) {
                        currentPage.a(this.f132311b, this.f132312c, true);
                        return;
                    }
                    int i3 = this.f132311b;
                    Iterator q16 = p.this.q();
                    while (true) {
                        nVar = (com.tencent.luggage.wxa.kj.n) q16.next();
                        if (i3 <= 0) {
                            break;
                        }
                        if (i3 >= nVar.getCurrentRenderPagesCount()) {
                            i3 -= nVar.getCurrentRenderPagesCount();
                            if (!q16.hasNext()) {
                                break;
                            }
                        } else {
                            nVar.a(i3, this.f132312c, false);
                            break;
                        }
                    }
                    m0 b16 = p.this.b(currentPage, nVar);
                    p.this.a(currentPage, nVar);
                    p.this.a(this.f132313d, nVar, currentPage, k1.NAVIGATE_BACK, b16);
                    return;
                }
                if (StringUtils.equals("scene_jsapi_navigate_back", this.f132310a)) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPageContainer", "navigateBackImpl appId:%s, %s", p.this.getAppId(), com.tencent.luggage.wxa.af.j.f121382b);
                } else {
                    com.tencent.luggage.wxa.ic.e.a(p.this.f132283c, e.d.BACK);
                    p.this.f132282b.o();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132315a;

        public c0(String str) {
            this.f132315a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.a(1, this.f132315a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Callable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132317a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1 f132318b;

        public d(String str, k1 k1Var) {
            this.f132317a = str;
            this.f132318b = k1Var;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.kj.n call() {
            return p.this.b(this.f132317a, this.f132318b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f132320a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f132321b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f132322c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.nj.f f132323d;

        public d0(int i3, String str, JSONObject jSONObject, com.tencent.luggage.wxa.nj.f fVar) {
            this.f132320a = i3;
            this.f132321b = str;
            this.f132322c = jSONObject;
            this.f132323d = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.b(this.f132320a, this.f132321b, this.f132322c, this.f132323d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132325a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1 f132326b;

        public e(String str, k1 k1Var) {
            this.f132325a = str;
            this.f132326b = k1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.kj.n invoke() {
            return p.this.a(this.f132325a, this.f132326b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e0 {
        com.tencent.luggage.wxa.kj.n a(String str, k1 k1Var, p pVar, Callable callable);

        com.tencent.luggage.wxa.kj.v a(p pVar, String str);

        boolean a(com.tencent.luggage.wxa.kj.v vVar, String str);

        boolean a(String str);

        boolean a(String str, k1 k1Var, p pVar, h0 h0Var);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements g0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f132328a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f132329b = false;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k1 f132330c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132331d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132332e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f132333f;

        public f(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2, long j3) {
            this.f132330c = k1Var;
            this.f132331d = nVar;
            this.f132332e = nVar2;
            this.f132333f = j3;
        }

        @Override // com.tencent.luggage.wxa.kj.p.g0
        public void a(boolean z16) {
            this.f132329b = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.kj.n nVar;
            if (!this.f132328a && !p.this.f132281a) {
                this.f132328a = true;
                if (p.this.getPageCount() != 0) {
                    synchronized (p.this.f132289i) {
                        nVar = (com.tencent.luggage.wxa.kj.n) p.this.f132290j.peekFirst();
                    }
                    String str = null;
                    if (l1.b(this.f132330c)) {
                        p.this.a(nVar, (com.tencent.luggage.wxa.kj.n) null);
                    }
                    boolean z16 = !this.f132329b;
                    boolean c16 = l1.c(this.f132330c);
                    Object[] objArr = new Object[6];
                    objArr[0] = p.this.getAppId();
                    com.tencent.luggage.wxa.kj.n nVar2 = this.f132331d;
                    if (nVar2 != null) {
                        str = com.tencent.luggage.wxa.h6.o.b(nVar2.getCurrentUrl());
                    }
                    objArr[1] = str;
                    objArr[2] = com.tencent.luggage.wxa.h6.o.b(this.f132332e.getCurrentUrl());
                    objArr[3] = Boolean.valueOf(z16);
                    objArr[4] = Boolean.valueOf(c16);
                    objArr[5] = this.f132330c;
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "navigateToNext$navigateTask.run(), before switch page, appId[%s], out[%s] in[%s] animate[%b] close[%b] type[%s]", objArr);
                    p.this.a(this.f132330c, nVar, this.f132332e, new l0(p.this.a(this.f132333f, this.f132332e, this.f132330c, z16), p.this.a(nVar, z16, c16)));
                    p.this.a(nVar, this.f132332e, this.f132330c);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface f0 {
        e0 a(e0 e0Var);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements g.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f132335a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1 f132336b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f132337c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132338d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ g0 f132339e;

        public g(long j3, k1 k1Var, String str, com.tencent.luggage.wxa.kj.n nVar, g0 g0Var) {
            this.f132335a = j3;
            this.f132336b = k1Var;
            this.f132337c = str;
            this.f132338d = nVar;
            this.f132339e = g0Var;
        }

        @Override // com.tencent.luggage.wxa.xd.g.f
        public void onReady() {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "navigateToNext, onReady cost[%dms], appId[%s] type[%s], url[%s]", Long.valueOf(com.tencent.luggage.wxa.tn.w0.a() - this.f132335a), p.this.getAppId(), this.f132336b, this.f132337c);
            this.f132338d.getCurrentPageView().b(this);
            p.this.removeCallbacks(this.f132339e);
            p.this.post(this.f132339e);
            p.this.m();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface g0 extends Runnable {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface h0 {
        void a(String str, Object obj);

        void a(boolean z16);

        void cancel();

        void proceed();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface i0 {
        void a(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2);

        void a(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2, float f16);

        void b(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2);

        m0 c(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f132348a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132349b;

        public j(boolean z16, com.tencent.luggage.wxa.kj.n nVar) {
            this.f132348a = z16;
            this.f132349b = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f132348a) {
                p.this.g(this.f132349b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface j0 {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements Comparator {
        public k() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.luggage.wxa.nj.e eVar, com.tencent.luggage.wxa.nj.e eVar2) {
            com.tencent.luggage.wxa.nj.g a16 = p.this.getCurrentPage().a(eVar.a());
            com.tencent.luggage.wxa.nj.g a17 = p.this.getCurrentPage().a(eVar2.a());
            if (a16 == null) {
                return 1;
            }
            if (a17 == null) {
                return -1;
            }
            return eVar2.b().a() - eVar.b().a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface k0 {
        void a(com.tencent.luggage.wxa.kj.n nVar, k1 k1Var);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132352a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f132353b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int[] f132354c;

        public l(String str, String str2, int[] iArr) {
            this.f132352a = str;
            this.f132353b = str2;
            this.f132354c = iArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.b(this.f132352a, this.f132353b, this.f132354c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class l0 {

        /* renamed from: a, reason: collision with root package name */
        public final Object f132356a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f132357b;

        public l0(Object obj, Object obj2) {
            this.f132356a = obj;
            this.f132357b = obj2;
        }

        public String toString() {
            return "PageSwitchResult{enterAnimation=" + this.f132356a + ", exitAnimation=" + this.f132357b + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f132358a;

        public m(com.tencent.luggage.wxa.kj.v vVar) {
            this.f132358a = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.c(this.f132358a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum m0 {
        MIN(Element.ELEMENT_NAME_MIN),
        MAX("max");


        /* renamed from: a, reason: collision with root package name */
        public final String f132363a;

        m0(String str) {
            this.f132363a = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132364a;

        public n(String str) {
            this.f132364a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.k(this.f132364a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface n0 {
        void a(com.tencent.luggage.wxa.kj.n nVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132366a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f132367b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!p.this.f132281a) {
                    o.this.f132367b.run();
                }
            }
        }

        public o(com.tencent.luggage.wxa.kj.n nVar, Runnable runnable) {
            this.f132366a = nVar;
            this.f132367b = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f132366a.setTag(p.R, null);
            Runnable runnable = this.f132367b;
            if (runnable != null) {
                p.this.removeCallbacks(runnable);
                if (!p.this.f132281a) {
                    this.f132367b.run();
                }
            }
            this.f132366a.setIsAnimating(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f132366a.setTag(p.R, null);
            if (this.f132367b != null) {
                p.this.post(new a());
            }
            this.f132366a.setIsAnimating(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class q extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1 f132374a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132375b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132376c;

        public q(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
            this.f132374a = k1Var;
            this.f132375b = nVar;
            this.f132376c = nVar2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            p.this.a(this.f132374a, this.f132375b, this.f132376c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            p.this.b(this.f132374a, this.f132375b, this.f132376c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class r implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1 f132378a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132379b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132380c;

        public r(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
            this.f132378a = k1Var;
            this.f132379b = nVar;
            this.f132380c = nVar2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            p.this.a(this.f132378a, this.f132379b, this.f132380c, (int) (valueAnimator.getAnimatedFraction() * 100.0f));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class s implements Choreographer.FrameCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f132382a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f132383b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k1 f132384c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132385d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132386e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Animation f132387f;

        public s(long j3, long j16, k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2, Animation animation) {
            this.f132382a = j3;
            this.f132383b = j16;
            this.f132384c = k1Var;
            this.f132385d = nVar;
            this.f132386e = nVar2;
            this.f132387f = animation;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            if (1.0f <= (((float) (SystemClock.elapsedRealtime() - this.f132382a)) + 0.0f) / ((float) this.f132383b)) {
                p.this.b(this.f132384c, this.f132385d, this.f132386e);
                return;
            }
            p.this.a(this.f132384c, this.f132385d, this.f132386e, (int) (this.f132387f.getInterpolator().getInterpolation(r4) * 100.0f));
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class t implements p0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f132389a;

        public t(com.tencent.luggage.wxa.kj.v vVar) {
            this.f132389a = vVar;
        }

        @Override // com.tencent.luggage.wxa.kj.p0
        public void a(com.tencent.luggage.wxa.kj.r rVar) {
            this.f132389a.b0().a(this.f132389a, rVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class u implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        public final ListIterator f132391a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f132392b;

        public u(List list) {
            this.f132392b = list;
            this.f132391a = list.listIterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.kj.n next() {
            return (com.tencent.luggage.wxa.kj.n) this.f132391a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f132391a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class v implements g0 {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f132394a = new AtomicBoolean(false);

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f132395b;

        public v(Runnable runnable) {
            this.f132395b = runnable;
        }

        @Override // com.tencent.luggage.wxa.kj.p.g0
        public /* synthetic */ void a(boolean z16) {
            b31.r.a(this, z16);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f132394a.getAndSet(true)) {
                this.f132395b.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class w {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f132397a;

        static {
            int[] iArr = new int[k1.values().length];
            f132397a = iArr;
            try {
                iArr[k1.REDIRECT_TO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class x implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132398a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f132399b;

        public x(String str, JSONObject jSONObject) {
            this.f132398a = str;
            this.f132399b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.a(this.f132398a, k1.NAVIGATE_TO, this.f132399b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class y implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132401a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f132402b;

        public y(String str, boolean z16) {
            this.f132401a = str;
            this.f132402b = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            k1 k1Var;
            p pVar = p.this;
            String str = this.f132401a;
            if (this.f132402b) {
                k1Var = k1.AUTO_RE_LAUNCH;
            } else {
                k1Var = k1.RE_LAUNCH;
            }
            pVar.c(str, k1Var);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class z implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132404a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f132405b;

        public z(String str, JSONObject jSONObject) {
            this.f132404a = str;
            this.f132405b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.a(this.f132404a, k1.REDIRECT_TO, this.f132405b);
        }
    }

    public p(Context context, com.tencent.luggage.wxa.ic.g gVar) {
        super(context);
        this.f132281a = false;
        this.f132284d = false;
        this.f132285e = false;
        this.f132288h = new HashMap();
        this.f132289i = new byte[0];
        this.f132290j = new LinkedList();
        this.f132291k = new LinkedList();
        this.f132292l = new LinkedList();
        this.f132293m = new LinkedList();
        this.E = false;
        this.H = new com.tencent.luggage.wxa.kj.i0();
        this.I = 500L;
        this.K = new com.tencent.luggage.wxa.kj.k0();
        this.L = true;
        this.N = null;
        this.O = null;
        this.P = false;
        this.Q = null;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "AppBrandPageContainerProfile| <init> appId[%s]", gVar.getAppId());
        this.f132282b = gVar;
        this.f132283c = gVar.getAppId();
        this.G = new i1.a();
    }

    public void d(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
    }

    public boolean f() {
        return false;
    }

    public final int getActualPageStackSize() {
        int size;
        synchronized (this.f132289i) {
            size = this.f132290j.size();
        }
        return size;
    }

    public final com.tencent.luggage.wxa.fd.b getAppConfig() {
        return this.f132282b.E();
    }

    public String getAppId() {
        return this.f132283c;
    }

    @Nullable
    public com.tencent.luggage.wxa.kj.n getCurrentPage() {
        boolean z16;
        boolean z17;
        boolean z18;
        synchronized (this.f132289i) {
            try {
                if (!this.f132291k.isEmpty()) {
                    com.tencent.luggage.wxa.kj.n nVar = (com.tencent.luggage.wxa.kj.n) this.f132291k.getFirst();
                    com.tencent.luggage.wxa.ic.g gVar = this.f132282b;
                    if (gVar != null) {
                        if (gVar.m1() && !this.f132282b.s0()) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (nVar == null && !z18) {
                            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPageContainer", "getCurrentPage returns NULL, appId[%s] mStagingStack.size[%d] mPageStack.size[%d] stack:%s", getAppId(), Integer.valueOf(this.f132291k.size()), Integer.valueOf(this.f132290j.size()), Log.getStackTraceString(new Throwable()));
                        }
                    }
                    return nVar;
                }
                com.tencent.luggage.wxa.kj.n nVar2 = (com.tencent.luggage.wxa.kj.n) this.f132290j.peekFirst();
                com.tencent.luggage.wxa.ic.g gVar2 = this.f132282b;
                if (gVar2 != null) {
                    if (gVar2.m1() && !this.f132282b.s0()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (nVar2 == null && !z17) {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPageContainer", "getCurrentPage returns NULL, appId[%s] mStagingStack.size[%d] mPageStack.size[%d] stack:%s", getAppId(), Integer.valueOf(this.f132291k.size()), Integer.valueOf(this.f132290j.size()), Log.getStackTraceString(new Throwable()));
                    }
                }
                return nVar2;
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.ic.g gVar3 = this.f132282b;
                if (gVar3 != null) {
                    if (gVar3.m1() && !this.f132282b.s0()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPageContainer", "getCurrentPage returns NULL, appId[%s] mStagingStack.size[%d] mPageStack.size[%d] stack:%s", getAppId(), Integer.valueOf(this.f132291k.size()), Integer.valueOf(this.f132290j.size()), Log.getStackTraceString(new Throwable()));
                    }
                }
                throw th5;
            }
        }
    }

    @Nullable
    public com.tencent.luggage.wxa.dm.a getCurrentTabBar() {
        com.tencent.luggage.wxa.kj.n currentPage = getCurrentPage();
        if (!(currentPage instanceof com.tencent.luggage.wxa.kj.g)) {
            return null;
        }
        return ((com.tencent.luggage.wxa.kj.g) currentPage).getTabBar();
    }

    public String getCurrentUrl() {
        com.tencent.luggage.wxa.kj.n currentPage = getCurrentPage();
        if (currentPage != null) {
            return currentPage.getCurrentUrl();
        }
        return null;
    }

    @NonNull
    public i1 getDecorWidgetFactory() {
        return this.G;
    }

    @Nullable
    public List<com.tencent.luggage.wxa.nj.e> getNavigateBackInterceptorChain() {
        synchronized (this.f132288h) {
            if (this.f132288h.size() != 0 && getCurrentPage() != null) {
                ArrayList arrayList = new ArrayList(this.f132288h.values());
                Collections.sort(arrayList, new k());
                return arrayList;
            }
            return null;
        }
    }

    public final int getPageCount() {
        int size;
        synchronized (this.f132289i) {
            size = this.f132290j.size() + this.f132291k.size();
        }
        return size;
    }

    @Nullable
    public final com.tencent.luggage.wxa.kj.v getPageView() {
        if (this.f132281a) {
            return null;
        }
        boolean k3 = this.f132282b.k();
        com.tencent.luggage.wxa.kj.n currentPage = getCurrentPage();
        if (currentPage == null) {
            if (k3) {
                com.tencent.luggage.wxa.er.a.a("getPageView() assert by NULL page, appId=" + getAppId());
            }
            return null;
        }
        com.tencent.luggage.wxa.kj.v currentPageView = currentPage.getCurrentPageView();
        if (currentPageView == null && k3) {
            com.tencent.luggage.wxa.er.a.a("getPageView() assert by NULL pv, appId=" + getAppId());
        }
        return currentPageView;
    }

    @Nullable
    public final List<com.tencent.luggage.wxa.kj.v> getPreloadedPageView() {
        LinkedList linkedList = new LinkedList();
        com.tencent.luggage.wxa.kj.v vVar = this.C;
        if (vVar != null) {
            linkedList.add(vVar);
        }
        com.tencent.luggage.wxa.kj.v vVar2 = this.D;
        if (vVar2 != null) {
            linkedList.add(vVar2);
        }
        return linkedList;
    }

    public final int getRenderPagesCount() {
        int i3;
        synchronized (this.f132289i) {
            Iterator it = this.f132290j.iterator();
            i3 = 0;
            while (it.hasNext()) {
                i3 += ((com.tencent.luggage.wxa.kj.n) it.next()).getCurrentPageView().d0();
            }
            Iterator it5 = this.f132291k.iterator();
            while (it5.hasNext()) {
                i3 += ((com.tencent.luggage.wxa.kj.n) it5.next()).getCurrentPageView().d0();
            }
        }
        return i3;
    }

    public com.tencent.luggage.wxa.ic.g getRuntime() {
        return this.f132282b;
    }

    public void i(String str) {
        a(new c0(str));
    }

    public void j(String str) {
        a(str, (JSONObject) null);
    }

    public void k() {
    }

    public int l(com.tencent.luggage.wxa.kj.n nVar) {
        return 0;
    }

    public void m(String str) {
        a(str, false);
    }

    public void n() {
    }

    public int o() {
        return 0;
    }

    public final boolean p() {
        if (getActualPageStackSize() > 1 || getRuntime().l()) {
            return true;
        }
        return false;
    }

    public Iterator q() {
        return a(false);
    }

    public boolean r() {
        return getRuntime().r1();
    }

    public void setActuallyVisible(boolean z16) {
        boolean z17;
        if (this.f132284d != z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f132284d = z16;
        if (z16 && z17) {
            com.tencent.luggage.wxa.kj.n currentPage = getCurrentPage();
            if (currentPage != null) {
                currentPage.getCurrentPageView().b1();
            }
            super.setVisibility(0);
            if (this.f132285e) {
                k("setActuallyVisible");
            }
        }
        if (!z16 && z17) {
            super.setVisibility(4);
        }
    }

    public void setDecorWidgetFactory(i1 i1Var) {
        if (i1Var != null) {
            this.G = i1Var;
            return;
        }
        throw new NullPointerException("Should not be null");
    }

    public final void setDelegate(e0 e0Var) {
        if (this.f132286f == null) {
            f0 f0Var = this.f132287g;
            if (f0Var != null) {
                e0Var = f0Var.a(e0Var);
            }
            this.f132286f = e0Var;
            return;
        }
        throw new IllegalAccessError("Duplicated call!!!");
    }

    public void setDelegateWrapperFactory(@NonNull f0 f0Var) {
        this.f132287g = f0Var;
        e0 e0Var = this.f132286f;
        if (e0Var != null) {
            this.f132286f = f0Var.a(e0Var);
        }
    }

    @MainThread
    public void setOnPageSwitchListener(@Nullable i0 i0Var) {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandPageContainer", "setOnPageSwitchListener, onPageSwitchListener: " + i0Var);
        this.Q = i0Var;
    }

    public void setOnReadyListener(@Nullable j0 j0Var) {
        this.M = j0Var;
    }

    public void setPageDidPushInCallback(@Nullable k0 k0Var) {
        this.J = k0Var;
    }

    public void setPageNavigationPushTimeout(long j3) {
        this.I = Math.max(0L, j3);
    }

    @MainThread
    public void setPipPageLifeCycleListener(@Nullable n0 n0Var) {
        this.N = n0Var;
    }

    public void setPipVideoRelatedPage(@Nullable com.tencent.luggage.wxa.kj.n nVar) {
        if (nVar != null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page(%s)", nVar.getCurrentUrl());
        } else {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page is null");
        }
        this.F = nVar;
    }

    public void a(com.tencent.luggage.wxa.kj.n nVar, k1 k1Var) {
    }

    public void b(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2, float f16) {
    }

    public boolean d() {
        return false;
    }

    public final com.tencent.luggage.wxa.kj.g e(String str) {
        synchronized (this.f132289i) {
            if (this.f132290j.size() < 2) {
                return null;
            }
            ListIterator listIterator = this.f132290j.listIterator(1);
            while (listIterator.hasNext()) {
                com.tencent.luggage.wxa.kj.n nVar = (com.tencent.luggage.wxa.kj.n) listIterator.next();
                if ((nVar instanceof com.tencent.luggage.wxa.kj.g) && nVar.a(str)) {
                    return (com.tencent.luggage.wxa.kj.g) nVar;
                }
            }
            return null;
        }
    }

    public void h(String str) {
        com.tencent.luggage.wxa.er.a.c(Looper.getMainLooper(), Looper.myLooper());
        c(str, k1.APP_LAUNCH);
    }

    public Object i(com.tencent.luggage.wxa.kj.n nVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nVar, "translationX", 0.0f, nVar.getWidth());
        ofFloat.setDuration(250L);
        return ofFloat;
    }

    public void j() {
        com.tencent.luggage.wxa.kj.n nVar;
        synchronized (this.f132289i) {
            nVar = (com.tencent.luggage.wxa.kj.n) this.f132290j.peekFirst();
        }
        if (nVar == null) {
            return;
        }
        nVar.x();
    }

    public final void k(String str) {
        if (!com.tencent.luggage.wxa.tn.c0.b()) {
            getRuntime().e(new n(str));
            return;
        }
        if (this.f132281a) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandPageContainer", "preloadNext, destroyed, appId:%s, reason:%s", getAppId(), str);
            return;
        }
        if (!this.f132284d) {
            this.f132285e = true;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "preloadNext, deferred, appId:%s, reason:%s", getAppId(), str);
            return;
        }
        this.f132285e = false;
        e0 e0Var = this.f132286f;
        if (e0Var != null && e0Var.a(str)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "preloadNext, intercepted, appId:%s, reason:%s", getAppId(), str);
            return;
        }
        if (this.C != null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "preloadNext, already preloaded, appId:%s, reason:%s", getAppId(), str);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.luggage.wxa.kj.v l3 = l("preload");
        if (l3 == null) {
            l3 = new com.tencent.luggage.wxa.kj.v();
        }
        l3.a(getDecorWidgetFactory());
        l3.a(getContext(), this.f132282b);
        l3.K();
        addView(l3.getContentView(), 0);
        this.C = l3;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "preloadNextPageView: appId:%s, cost:%d, reason:%s", getAppId(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), str);
    }

    public final com.tencent.luggage.wxa.kj.v l(String str) {
        com.tencent.luggage.wxa.kj.v a16;
        e0 e0Var = this.f132286f;
        if (e0Var == null || (a16 = e0Var.a(this, str)) == null) {
            return null;
        }
        return a16;
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final void g(com.tencent.luggage.wxa.kj.n nVar) {
        n0 n0Var = this.N;
        if (n0Var != null) {
            n0Var.a(nVar);
        }
        nVar.setVisibility(8);
        nVar.x();
        if (!nVar.o()) {
            nVar.z();
        }
        removeView(nVar);
        if (!nVar.o()) {
            nVar.y();
        }
        if (getRuntime() == null || getRuntime().L() == null || com.tencent.luggage.wxa.ol.q.b(getRuntime().L()) == null) {
            return;
        }
        com.tencent.luggage.wxa.ol.q.b(getRuntime().L()).requestLayout();
    }

    public void n(String str) {
        a(new a0(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        k(com.tencent.luggage.wxa.yf.h.NAME);
    }

    public boolean a(k1 k1Var) {
        return false;
    }

    public final void c(String str, k1 k1Var) {
        a(str, k1Var, (JSONObject) null);
    }

    public boolean n(com.tencent.luggage.wxa.kj.n nVar) {
        com.tencent.luggage.wxa.kj.v currentPageView = nVar.getCurrentPageView();
        if (currentPageView == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPageContainer", "shouldShowActionBarHomeButton, appId:%s, page:%s, get NULL PageView", getAppId(), nVar.getCurrentUrl());
            return false;
        }
        String currentUrl = nVar.getCurrentUrl();
        if (getRuntime() == null || getRuntime().E() == null) {
            return false;
        }
        boolean z16 = !currentUrl.startsWith(getRuntime().E().c());
        boolean[] zArr = new boolean[3];
        zArr[0] = (getPageCount() == 1 && z16) || (currentPageView.r0() != null && currentPageView.r0().f125699s && getPageCount() != 1 && z16);
        zArr[1] = (currentPageView.W() == null || currentPageView.W().k()) ? false : true;
        zArr[2] = !(nVar instanceof com.tencent.luggage.wxa.kj.g);
        for (int i3 = 0; i3 < 3; i3++) {
            if (!zArr[i3]) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "[%s,%s]->shouldShowActionBarHomeButton: test fail cause #[%d] condition,", nVar.getAppId(), nVar.getCurrentUrl(), Integer.valueOf(i3));
                return false;
            }
        }
        return true;
    }

    public final void c() {
        LinkedList linkedList;
        synchronized (this.f132289i) {
            linkedList = new LinkedList(this.f132293m);
            this.f132293m.clear();
        }
        Iterator descendingIterator = linkedList.descendingIterator();
        while (descendingIterator.hasNext()) {
            ((g0) descendingIterator.next()).run();
            descendingIterator.remove();
        }
    }

    public final boolean d(String str, k1 k1Var) {
        int i3;
        int size;
        if (k1Var == k1.SWITCH_TAB) {
            return true;
        }
        if (k1Var != k1.RE_LAUNCH && k1Var != k1.AUTO_RE_LAUNCH) {
            synchronized (this.f132289i) {
                if (k1Var != k1.REDIRECT_TO && k1Var != k1.REWRITE_ROUTE) {
                    i3 = 0;
                    size = (this.f132290j.size() + 1) - i3;
                }
                i3 = 1;
                size = (this.f132290j.size() + 1) - i3;
            }
            return this.f132282b.E().i().a(str) && size == 1;
        }
        return this.f132282b.E().i().a(str);
    }

    public final com.tencent.luggage.wxa.kj.g f(String str) {
        synchronized (this.f132289i) {
            com.tencent.luggage.wxa.kj.n nVar = (com.tencent.luggage.wxa.kj.n) this.f132290j.peekFirst();
            if (!(nVar instanceof com.tencent.luggage.wxa.kj.g) || !nVar.a(str)) {
                return null;
            }
            return (com.tencent.luggage.wxa.kj.g) nVar;
        }
    }

    public final String g(String str) {
        if (com.tencent.luggage.wxa.tn.w0.c(str)) {
            str = this.f132282b.E().c();
        }
        if (!str.startsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            return str;
        }
        return this.f132282b.E().c() + str;
    }

    public void h() {
        a(this.f132282b.E().c(), true);
    }

    public void l() {
        com.tencent.luggage.wxa.kj.n nVar;
        synchronized (this.f132289i) {
            nVar = (com.tencent.luggage.wxa.kj.n) this.f132290j.peekFirst();
        }
        if (nVar == null) {
            return;
        }
        nVar.A();
        if (this.f132284d) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandPageContainer", "onForeground, call onUserVisible, appId[%s] url[%s]", getAppId(), nVar.getCurrentPageView().A0());
            nVar.getCurrentPageView().b1();
        }
    }

    public void b(String str, JSONObject jSONObject) {
        a(new z(str, jSONObject));
    }

    public Object h(com.tencent.luggage.wxa.kj.n nVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nVar, "translationX", -(nVar.getWidth() * 0.25f), 0.0f);
        ofFloat.setDuration(250L);
        return ofFloat;
    }

    public void i() {
        boolean z16;
        com.tencent.luggage.wxa.kj.n currentPage = getCurrentPage();
        if (currentPage == null || currentPage.getCurrentPageView().U0()) {
            return;
        }
        synchronized (this.f132289i) {
            z16 = !this.f132291k.isEmpty();
        }
        if (!z16 && currentPage.getTag(R) == null) {
            i("scene_back_key_pressed");
        } else {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandPageContainer", "onBackPressed, has navigating pages, skip");
        }
    }

    public final boolean b(int i3, String str) {
        com.tencent.luggage.wxa.kj.v vVar;
        if (i3 == 0) {
            if (getCurrentPage() == null || (vVar = getCurrentPage().getCurrentPageView()) == null) {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, url:%s", getAppId(), str);
                return false;
            }
        } else {
            com.tencent.luggage.wxa.kj.v a16 = a(i3);
            if (a16 == null) {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, webviewId:%d, url:%s", getAppId(), Integer.valueOf(i3), str);
                return false;
            }
            vVar = a16;
        }
        return vVar.a(Objects.hash(Integer.valueOf(k1.REWRITE_ROUTE.ordinal()), Long.valueOf(com.tencent.luggage.wxa.tn.w0.a())), str);
    }

    public Object j(com.tencent.luggage.wxa.kj.n nVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nVar, "translationX", nVar.getWidth(), 0.0f);
        ofFloat.setDuration(250L);
        return ofFloat;
    }

    public void f(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
        if (nVar != nVar2) {
            c(nVar2);
        }
    }

    public void b(com.tencent.luggage.wxa.kj.n nVar, String str) {
        a(new b(nVar, str));
    }

    public final int e(com.tencent.luggage.wxa.kj.n nVar) {
        int indexOf;
        synchronized (this.f132289i) {
            indexOf = this.f132290j.indexOf(nVar);
        }
        return indexOf;
    }

    public final void b(int i3, String str, JSONObject jSONObject, com.tencent.luggage.wxa.nj.f fVar) {
        b();
        long hash = Objects.hash(Integer.valueOf(k1.NAVIGATE_BACK.ordinal()), Long.valueOf(com.tencent.luggage.wxa.tn.w0.a()));
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(jSONObject == null ? -1 : jSONObject.length());
        objArr[3] = Boolean.valueOf(fVar != null);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "navigateBackImpl delta:%d, scene:%s, customArgs.length:%s, interceptorCallback:%b", objArr);
        c cVar = new c(str, i3, jSONObject, hash);
        boolean a16 = a(str, cVar);
        if (fVar != null) {
            fVar.a(a16);
        }
        if (a16) {
            return;
        }
        cVar.run();
    }

    public com.tencent.luggage.wxa.kj.n d(com.tencent.luggage.wxa.kj.n nVar) {
        synchronized (this.f132289i) {
            if (this.f132291k.contains(nVar)) {
                return (com.tencent.luggage.wxa.kj.n) this.f132290j.peekFirst();
            }
            int indexOf = this.f132290j.indexOf(nVar);
            if (indexOf >= this.f132290j.size() - 1) {
                return null;
            }
            return (com.tencent.luggage.wxa.kj.n) this.f132290j.get(indexOf + 1);
        }
    }

    public final boolean c(String str) {
        e0 e0Var = this.f132286f;
        if (e0Var != null) {
            return e0Var.a(this.D, str);
        }
        return this.D != null;
    }

    public final void m() {
        if (this.f132282b != null && this.L) {
            j0 j0Var = this.M;
            if (j0Var != null) {
                j0Var.a();
            }
            n();
            this.L = false;
        }
    }

    public final boolean e() {
        if (getRuntime().x0()) {
            return false;
        }
        if ((!getRuntime().z0() || getRuntime().d0() == null) ? getActualPageStackSize() <= 1 : false) {
            return f();
        }
        return true;
    }

    public void a(com.tencent.luggage.wxa.nj.i iVar, com.tencent.luggage.wxa.nj.e eVar) {
        if (eVar == null || iVar == null) {
            return;
        }
        synchronized (this.f132288h) {
            this.f132288h.put(iVar, eVar);
        }
    }

    public final void c(com.tencent.luggage.wxa.kj.v vVar) {
        boolean z16;
        if (!com.tencent.luggage.wxa.tn.c0.b()) {
            getRuntime().e(new m(vVar));
            return;
        }
        if (!this.K.b(vVar) || vVar.b0() == null) {
            return;
        }
        synchronized (this.f132289i) {
            z16 = !this.f132291k.contains(vVar.b0());
        }
        if (z16) {
            a(vVar);
        }
    }

    public final void a(Runnable runnable) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        com.tencent.luggage.wxa.ic.g gVar = this.f132282b;
        if (gVar == null) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandPageContainer", "runOnUiThread but mRuntime==NULL, appId:%s, stack:%s", getAppId(), Log.getStackTraceString(new Throwable()));
        } else {
            gVar.e(runnable);
        }
    }

    public void e(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
        if (nVar != nVar2) {
            b(nVar);
        }
    }

    public m0 b(com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
        Objects.requireNonNull(nVar2);
        Object[] objArr = new Object[4];
        objArr[0] = getAppId();
        objArr[1] = nVar == null ? null : com.tencent.luggage.wxa.h6.o.b(nVar.getCurrentUrl());
        objArr[2] = com.tencent.luggage.wxa.h6.o.b(nVar2.getCurrentUrl());
        objArr[3] = Boolean.valueOf(this.f132284d);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "onNavigateBack, appId[%s] out[%s], in[%s], mActuallyVisible[%b]", objArr);
        if (this.f132284d) {
            nVar2.getCurrentPageView().b1();
        }
        if (nVar != null) {
            nVar.k();
        }
        com.tencent.luggage.wxa.lj.e I = getRuntime().I();
        com.tencent.luggage.wxa.kj.v currentPageView = nVar2.getCurrentPageView();
        k1 k1Var = k1.NAVIGATE_BACK;
        I.a(currentPageView, k1Var);
        b(nVar2.getCurrentPageView());
        c(k1Var, nVar, nVar2);
        return this.O;
    }

    public final com.tencent.luggage.wxa.kj.v d(String str) {
        boolean z16 = !this.E;
        this.E = true;
        if (c(str)) {
            com.tencent.luggage.wxa.kj.v vVar = this.D;
            this.D = null;
            if (z16) {
                vVar.R0();
            }
            vVar.M();
            removeView(vVar.getContentView());
            return vVar;
        }
        if (!b(str)) {
            com.tencent.luggage.wxa.kj.v l3 = l(str);
            if (l3 == null) {
                l3 = new com.tencent.luggage.wxa.kj.v();
            }
            if (z16) {
                l3.R0();
            }
            l3.a(getDecorWidgetFactory());
            l3.a(getContext(), this.f132282b);
            return l3;
        }
        com.tencent.luggage.wxa.kj.v vVar2 = this.C;
        this.C = null;
        if (z16) {
            vVar2.R0();
        }
        vVar2.M();
        removeView(vVar2.getContentView());
        return vVar2;
    }

    public Object k(com.tencent.luggage.wxa.kj.n nVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nVar, "translationX", 0.0f, -(nVar.getWidth() * 0.25f));
        ofFloat.setDuration(250L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(nVar, "translationX", 0.0f);
        ofFloat2.setDuration(0L);
        new AnimatorSet().playSequentially(ofFloat, ofFloat2);
        return ofFloat;
    }

    public Iterator a(boolean z16) {
        LinkedList linkedList = new LinkedList();
        synchronized (this.f132289i) {
            if (z16) {
                linkedList.addAll(this.f132291k);
            }
            linkedList.addAll(this.f132290j);
        }
        return new u(linkedList);
    }

    public final Object c(com.tencent.luggage.wxa.kj.n nVar, Runnable runnable) {
        return a(nVar, j(nVar), runnable);
    }

    public void c(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
        if (this.P) {
            return;
        }
        f(k1Var, nVar, nVar2);
        i0 i0Var = this.Q;
        if (i0Var != null) {
            this.O = i0Var.c(k1Var, nVar, nVar2);
        }
        this.P = true;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kj.p$p, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class AnimationAnimationListenerC6391p implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f132370a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132371b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.kj.p$p$a */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!p.this.f132281a) {
                    AnimationAnimationListenerC6391p.this.f132370a.run();
                }
                AnimationAnimationListenerC6391p.this.f132371b.setTag(p.R, null);
            }
        }

        public AnimationAnimationListenerC6391p(Runnable runnable, com.tencent.luggage.wxa.kj.n nVar) {
            this.f132370a = runnable;
            this.f132371b = nVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f132370a != null) {
                a aVar = new a();
                if (animation.getStartTime() == Long.MIN_VALUE) {
                    aVar.run();
                } else if (!p.this.f132281a) {
                    p.this.post(aVar);
                }
            } else {
                this.f132371b.setTag(p.R, null);
            }
            this.f132371b.setIsAnimating(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public final com.tencent.luggage.wxa.kj.n b(String str, k1 k1Var) {
        if (d(str, k1Var)) {
            return new com.tencent.luggage.wxa.kj.g(getContext(), this);
        }
        return new com.tencent.luggage.wxa.kj.a0(getContext(), this);
    }

    public void a(String str, JSONObject jSONObject) {
        a(new x(str, jSONObject));
    }

    public final void c(com.tencent.luggage.wxa.kj.n nVar) {
        View contentView;
        if (nVar == null || (contentView = nVar.getContentView()) == null) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "fixAccessibilityPageSwitchIssueOnStart, " + nVar.getCurrentUrl());
        contentView.setImportantForAccessibility(1);
    }

    public void a(String str, boolean z16) {
        a(new y(str, z16));
    }

    public com.tencent.luggage.wxa.kj.v a(int i3) {
        return a(i3, false);
    }

    public final void b() {
        LinkedList linkedList;
        synchronized (this.f132289i) {
            linkedList = new LinkedList(this.f132292l);
            this.f132292l.clear();
        }
        Iterator descendingIterator = linkedList.descendingIterator();
        while (descendingIterator.hasNext()) {
            g0 g0Var = (g0) descendingIterator.next();
            g0Var.a(true);
            g0Var.run();
            descendingIterator.remove();
        }
    }

    public com.tencent.luggage.wxa.kj.v a(int i3, boolean z16) {
        com.tencent.luggage.wxa.kj.v a16;
        LinkedList linkedList = new LinkedList();
        synchronized (this.f132289i) {
            linkedList.addAll(this.f132291k);
            linkedList.addAll(this.f132290j);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.kj.n nVar = (com.tencent.luggage.wxa.kj.n) it.next();
                if (nVar != null && (a16 = nVar.a(i3, z16)) != null) {
                    return a16;
                }
            }
            return null;
        }
    }

    public final Object d(com.tencent.luggage.wxa.kj.n nVar, Runnable runnable) {
        return a(nVar, k(nVar), runnable);
    }

    public final boolean a(String str, k1 k1Var, h0 h0Var) {
        e0 e0Var = this.f132286f;
        if (e0Var != null) {
            return e0Var.a(str, k1Var, this, h0Var);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.tencent.luggage.wxa.kj.n nVar, long j3, k1 k1Var) {
        nVar.a(j3, k1Var);
        c();
    }

    public final void a(String str, k1 k1Var, JSONObject jSONObject) {
        if (this.f132282b == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPageContainer", "navigateToImpl destroyed, url[%s], type[%s]", str, k1Var);
            return;
        }
        long a16 = this.H.a(k1Var);
        this.H.a(a16, Boolean.valueOf(this.f132282b.E().T && TextUtils.isEmpty(com.tencent.luggage.wxa.h6.o.b(str)) && (k1Var == k1.APP_LAUNCH || k1Var == k1.AUTO_RE_LAUNCH || k1Var == k1.RE_LAUNCH)));
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "navigateTo: %s, type[%s]", str, k1Var);
        String g16 = g(str);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "navigateTo: %s fixed, type[%s]", g16, k1Var);
        b();
        if (k1Var == k1.SWITCH_TAB && a(a16, g16)) {
            return;
        }
        b0 b0Var = new b0(g16, k1Var, a16, jSONObject);
        if (a(g16, k1Var, b0Var)) {
            return;
        }
        b0Var.proceed();
    }

    public final void b(String str, String str2, int[] iArr) {
        synchronized (this.f132289i) {
            Iterator it = this.f132290j.iterator();
            while (it.hasNext()) {
                ((com.tencent.luggage.wxa.kj.n) it.next()).a(str, str2, iArr);
            }
            Iterator it5 = this.f132291k.iterator();
            while (it5.hasNext()) {
                ((com.tencent.luggage.wxa.kj.n) it5.next()).a(str, str2, iArr);
            }
        }
        com.tencent.luggage.wxa.kj.v vVar = this.C;
        if (vVar != null && iArr != null && com.tencent.luggage.wxa.u9.a.a(iArr, vVar.getComponentId())) {
            this.C.a(str, str2);
        }
        com.tencent.luggage.wxa.kj.v vVar2 = this.D;
        if (vVar2 != null && iArr != null && com.tencent.luggage.wxa.u9.a.a(iArr, vVar2.getComponentId())) {
            this.D.a(str, str2);
        }
        com.tencent.luggage.wxa.kj.n nVar = this.F;
        if (nVar != null) {
            nVar.a(str, str2, iArr);
        }
    }

    public void a(int i3, String str, JSONObject jSONObject, com.tencent.luggage.wxa.nj.f fVar) {
        a(new d0(i3, str, jSONObject, fVar));
    }

    public void a(int i3, String str) {
        a(i3, str, (JSONObject) null, (com.tencent.luggage.wxa.nj.f) null);
    }

    public void a(com.tencent.luggage.wxa.kj.n nVar, String str) {
        a(new a(nVar, str));
    }

    public final boolean b(String str) {
        e0 e0Var = this.f132286f;
        if (e0Var != null) {
            return e0Var.a(this.C, str);
        }
        return this.C != null;
    }

    public boolean a(String str, Runnable runnable) {
        List<com.tencent.luggage.wxa.nj.e> navigateBackInterceptorChain = getNavigateBackInterceptorChain();
        boolean z16 = false;
        if (navigateBackInterceptorChain == null) {
            return false;
        }
        Iterator<com.tencent.luggage.wxa.nj.e> it = navigateBackInterceptorChain.iterator();
        while (it.hasNext() && !(z16 = it.next().a(getRuntime(), str, runnable))) {
        }
        return z16;
    }

    public final Object b(com.tencent.luggage.wxa.kj.n nVar, Runnable runnable) {
        return a(nVar, i(nVar), runnable);
    }

    public final com.tencent.luggage.wxa.kj.n a(String str, k1 k1Var) {
        com.tencent.luggage.wxa.kj.n a16;
        e0 e0Var = this.f132286f;
        return (e0Var == null || (a16 = e0Var.a(str, k1Var, this, new d(str, k1Var))) == null) ? b(str, k1Var) : a16;
    }

    public final void b(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
        c(k1Var, nVar, nVar2);
        e(k1Var, nVar, nVar2);
        i0 i0Var = this.Q;
        if (i0Var != null) {
            i0Var.a(k1Var, nVar, nVar2);
        }
        this.P = false;
    }

    public final void a(long j3, String str, k1 k1Var, boolean z16, JSONObject jSONObject) {
        int size;
        final com.tencent.luggage.wxa.kj.n currentPage;
        com.tencent.luggage.wxa.kj.n nVar;
        com.tencent.luggage.wxa.kj.n nVar2;
        com.tencent.luggage.wxa.kj.n nVar3;
        synchronized (this.f132289i) {
            size = this.f132291k.size();
            currentPage = getCurrentPage();
        }
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(j3);
        objArr[1] = str;
        objArr[2] = k1Var;
        objArr[3] = Integer.valueOf(size);
        objArr[4] = Boolean.valueOf(z16);
        objArr[5] = Integer.valueOf(jSONObject == null ? -1 : jSONObject.length());
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "navigateToNext: routeId:%d, url:%s, type:%s), Staging Count: %d, disableAnimation %b, customArgs.size:%d", objArr);
        if (currentPage != null && currentPage.E()) {
            b.k i3 = getAppConfig().i();
            if (currentPage.b(str)) {
                if (i3 == null || !i3.a(str) || (k1.RE_LAUNCH != k1Var && k1.AUTO_RE_LAUNCH != k1Var && (currentPage instanceof com.tencent.luggage.wxa.kj.g) && i3.f125673f)) {
                    if (l1.b(k1Var)) {
                        a(currentPage, (com.tencent.luggage.wxa.kj.n) null);
                    }
                    currentPage.a(j3, str, k1Var, jSONObject);
                    return;
                }
            } else if (w.f132397a[k1Var.ordinal()] == 1 && currentPage.getCurrentRenderPagesCount() > 1) {
                g0 b16 = b(new Runnable() { // from class: b31.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.luggage.wxa.kj.n.this.a(1, (JSONObject) null, false);
                    }
                });
                synchronized (this.f132289i) {
                    this.f132292l.push(b16);
                    this.f132293m.push(b16);
                }
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "navigateToNext: routeId:%d, redirectTo -> navigateTo", Long.valueOf(j3));
                com.tencent.luggage.wxa.kj.i0 i0Var = this.H;
                k1 k1Var2 = k1.REDIRECT_TO;
                k1 k1Var3 = k1.NAVIGATE_TO;
                i0Var.a(j3, k1Var2, k1Var3);
                a(j3, str, k1Var3, z16 || !l1.a(k1Var), jSONObject);
                return;
            }
        }
        com.tencent.luggage.wxa.kj.n nVar4 = (com.tencent.luggage.wxa.kj.n) com.tencent.luggage.wxa.e5.g.a("AppBrandPageContainerProfile| createPage", new e(str, k1Var));
        Objects.requireNonNull(nVar4);
        synchronized (this.f132289i) {
            nVar = (com.tencent.luggage.wxa.kj.n) this.f132290j.peekFirst();
        }
        if (nVar4.getContentView() == null) {
            nVar4.setInitialUrl(str);
            nVar4.l();
        }
        boolean[] zArr = {false};
        if (k1.APP_LAUNCH == k1Var) {
            nVar4.getCurrentPageView().R0();
        }
        boolean z17 = z16 | (!l1.a(k1Var));
        m0 a16 = a(nVar, nVar4, k1Var, str, !z17);
        if (a(k1Var)) {
            nVar4.a(j3, k1Var, a16, jSONObject);
            zArr[0] = true;
        }
        ViewGroup viewGroup = (ViewGroup) nVar4.getParent();
        if (viewGroup != null) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandPageContainer", new Throwable(), "page already has a parent", new Object[0]);
            nVar2 = nVar4;
            viewGroup.removeView(nVar2);
        } else {
            nVar2 = nVar4;
        }
        addView(nVar2, 0);
        com.tencent.luggage.wxa.kj.n nVar5 = nVar2;
        f fVar = new f(k1Var, nVar, nVar2, j3);
        fVar.a(z17);
        synchronized (this.f132289i) {
            this.f132291k.push(nVar5);
            this.f132292l.push(fVar);
            if (this.f132290j.size() == 0) {
                postDelayed(fVar, 5000L);
            } else if (k1Var == k1.AUTO_RE_LAUNCH) {
                postOnAnimation(fVar);
            } else {
                postDelayed(fVar, this.I);
            }
            if ((!l1.c(k1Var) && !l1.b(k1Var)) || (nVar3 = (com.tencent.luggage.wxa.kj.n) this.f132290j.peekFirst()) == null || nVar3 == nVar5) {
                nVar3 = null;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "navigateToNext mStagingStack push done, appId[%s] url[%s] type[%s]", getAppId(), str, k1Var);
        }
        if (nVar3 != null) {
            nVar3.r();
        }
        nVar5.getCurrentPageView().a(new g(com.tencent.luggage.wxa.tn.w0.a(), k1Var, str, nVar5, fVar));
        nVar5.a(j3, str, k1Var);
        a(nVar5, k1Var);
        if (zArr[0]) {
            return;
        }
        nVar5.a(j3, k1Var, a16, jSONObject);
    }

    public final void b(com.tencent.luggage.wxa.kj.v vVar) {
        if (getRuntime().R() == null) {
            return;
        }
        getRuntime().R().a(vVar.h0());
        getRuntime().R().a(new t(vVar));
    }

    public final void b(com.tencent.luggage.wxa.kj.n nVar) {
        View contentView;
        if (nVar == null || (contentView = nVar.getContentView()) == null) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "fixAccessibilityPageSwitchIssueOnEnd, " + nVar.getCurrentUrl());
        contentView.setImportantForAccessibility(4);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements g.j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132341a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m0[] f132342b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f132343c;

        public h(com.tencent.luggage.wxa.kj.n nVar, m0[] m0VarArr, long j3) {
            this.f132341a = nVar;
            this.f132342b = m0VarArr;
            this.f132343c = j3;
        }

        @Override // com.tencent.luggage.wxa.kj.g.j
        public void a(com.tencent.luggage.wxa.kj.g gVar, String str) {
            long j3 = this.f132343c;
            k1 k1Var = k1.SWITCH_TAB;
            gVar.a(j3, k1Var);
            p.this.b(k1Var, this.f132341a, gVar);
            p.this.a(this.f132341a, gVar, k1Var);
        }

        @Override // com.tencent.luggage.wxa.kj.g.j
        public void c(com.tencent.luggage.wxa.kj.g gVar, String str) {
            p pVar = p.this;
            com.tencent.luggage.wxa.kj.n nVar = this.f132341a;
            k1 k1Var = k1.SWITCH_TAB;
            m0 a16 = pVar.a(nVar, gVar, k1Var, str, l1.a(k1Var));
            this.f132342b[0] = a16;
            gVar.a(this.f132343c, k1Var, a16);
        }

        @Override // com.tencent.luggage.wxa.kj.g.j
        public void b(com.tencent.luggage.wxa.kj.g gVar, String str) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements g.j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f132345a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m0[] f132346b;

        public i(com.tencent.luggage.wxa.kj.n nVar, m0[] m0VarArr) {
            this.f132345a = nVar;
            this.f132346b = m0VarArr;
        }

        @Override // com.tencent.luggage.wxa.kj.g.j
        public void a(com.tencent.luggage.wxa.kj.g gVar, String str) {
            p.this.a(this.f132345a, gVar, k1.SWITCH_TAB);
        }

        @Override // com.tencent.luggage.wxa.kj.g.j
        public void c(com.tencent.luggage.wxa.kj.g gVar, String str) {
            p pVar = p.this;
            com.tencent.luggage.wxa.kj.n nVar = this.f132345a;
            k1 k1Var = k1.SWITCH_TAB;
            this.f132346b[0] = pVar.a(nVar, gVar, k1Var, str, l1.a(k1Var));
        }

        @Override // com.tencent.luggage.wxa.kj.g.j
        public void b(com.tencent.luggage.wxa.kj.g gVar, String str) {
        }
    }

    public final g0 b(Runnable runnable) {
        v vVar = new v(runnable);
        synchronized (this.f132289i) {
            this.f132292l.push(vVar);
        }
        return vVar;
    }

    public m0 a(com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2, k1 k1Var, String str, boolean z16) {
        Object[] objArr = new Object[5];
        objArr[0] = getAppId();
        objArr[1] = nVar == null ? null : com.tencent.luggage.wxa.h6.o.b(nVar.getCurrentUrl());
        objArr[2] = com.tencent.luggage.wxa.h6.o.b(str);
        objArr[3] = Boolean.valueOf(this.f132284d);
        objArr[4] = k1Var;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "onNavigateStart, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", objArr);
        if (nVar != null) {
            nVar.k();
        }
        c(k1Var, nVar, nVar2);
        if (k1.APP_LAUNCH == k1Var) {
            getRuntime().I().a(nVar2.getCurrentPageView(), k1Var);
            b(nVar2.getCurrentPageView());
        }
        if (nVar != null && nVar.getCurrentPageView() != null && nVar.getCurrentPageView().u0() != null) {
            nVar.getCurrentPageView().u0().d();
        }
        if (nVar != null && nVar.getCurrentPageView() != null && nVar.getCurrentPageView().h0() != null && nVar.getCurrentPageView().h0().b()) {
            nVar.getCurrentPageView().h0().c();
        }
        return this.O;
    }

    public void a(com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2, k1 k1Var) {
        Object[] objArr = new Object[5];
        objArr[0] = getAppId();
        objArr[1] = nVar == null ? null : com.tencent.luggage.wxa.h6.o.b(nVar.getCurrentUrl());
        objArr[2] = com.tencent.luggage.wxa.h6.o.b(nVar2.getCurrentUrl());
        objArr[3] = Boolean.valueOf(this.f132284d);
        objArr[4] = k1Var;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "onNavigateEnd, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", objArr);
        if (this.f132284d) {
            nVar2.getCurrentPageView().b1();
        }
        if (k1.APP_LAUNCH != k1Var) {
            getRuntime().I().a(nVar2.getCurrentPageView(), k1Var);
        }
        if (n(nVar2)) {
            nVar2.getCurrentPageView().N();
        }
        b(nVar2.getCurrentPageView());
    }

    public final boolean a(long j3, String str) {
        com.tencent.luggage.wxa.kj.n nVar;
        com.tencent.luggage.wxa.kj.n currentPage = getCurrentPage();
        com.tencent.luggage.wxa.kj.g f16 = f(str);
        if (f16 != null) {
            f16.a(j3, str, new h(currentPage, new m0[1], j3), k1.SWITCH_TAB);
            return true;
        }
        com.tencent.luggage.wxa.kj.g e16 = e(str);
        if (e16 == null) {
            return false;
        }
        m0[] m0VarArr = new m0[1];
        i iVar = new i(currentPage, m0VarArr);
        k1 k1Var = k1.SWITCH_TAB;
        e16.a(j3, str, iVar, k1Var);
        synchronized (this.f132289i) {
            nVar = (com.tencent.luggage.wxa.kj.n) this.f132290j.getFirst();
        }
        a(nVar, e16);
        a(j3, e16, nVar, k1Var, m0VarArr[0]);
        return true;
    }

    public final void a(com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
        LinkedList<com.tencent.luggage.wxa.kj.n> linkedList = new LinkedList();
        synchronized (this.f132289i) {
            Iterator it = this.f132290j.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                com.tencent.luggage.wxa.kj.n nVar3 = (com.tencent.luggage.wxa.kj.n) it.next();
                if (nVar3 == nVar) {
                    z16 = true;
                } else {
                    if (nVar3 == nVar2) {
                        break;
                    }
                    if (z16) {
                        linkedList.add(nVar3);
                        it.remove();
                        this.f132291k.remove(nVar3);
                    }
                }
            }
        }
        for (com.tencent.luggage.wxa.kj.n nVar4 : linkedList) {
            a(nVar4);
            g(nVar4);
        }
    }

    public final void a(final long j3, final com.tencent.luggage.wxa.kj.n nVar, final com.tencent.luggage.wxa.kj.n nVar2, final k1 k1Var, m0 m0Var) {
        Object obj;
        synchronized (this.f132289i) {
            this.f132290j.remove(nVar2);
            this.f132291k.remove(nVar2);
        }
        boolean z16 = !nVar2.q();
        a(nVar2);
        Object obj2 = null;
        if (z16) {
            obj = b(nVar2, b(new Runnable() { // from class: b31.o
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.luggage.wxa.kj.p.this.g(nVar2);
                }
            }));
        } else {
            g(nVar2);
            obj = null;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", nVar.getCurrentUrl(), nVar2.getCurrentUrl());
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandPageContainer", "switchPageClear, dispatchRoute, type: %s, pipMode: %s", k1Var, m0Var);
        nVar.a(j3, k1Var, m0Var);
        nVar.A();
        a(nVar);
        if (z16) {
            obj2 = a(nVar, b(new Runnable() { // from class: b31.p
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.luggage.wxa.kj.n.this.a(j3, k1Var);
                }
            }));
        } else {
            nVar.a(j3, k1Var);
        }
        a(k1Var, nVar2, nVar, new l0(obj2, obj));
    }

    public final Object a(com.tencent.luggage.wxa.kj.n nVar, boolean z16, boolean z17) {
        if (nVar == null) {
            return null;
        }
        if (z17) {
            synchronized (this.f132289i) {
                this.f132290j.remove(nVar);
                this.f132291k.remove(nVar);
            }
        }
        nVar.x();
        j jVar = new j(z17, nVar);
        if (z16) {
            return d(nVar, b(jVar));
        }
        a(nVar);
        jVar.run();
        return null;
    }

    public final Object a(final long j3, final com.tencent.luggage.wxa.kj.n nVar, final k1 k1Var, boolean z16) {
        if (nVar == null) {
            return null;
        }
        synchronized (this.f132289i) {
            this.f132290j.remove(nVar);
            this.f132290j.push(nVar);
            this.f132291k.remove(nVar);
        }
        nVar.bringToFront();
        requestLayout();
        invalidate();
        nVar.A();
        Runnable runnable = new Runnable() { // from class: b31.m
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.kj.p.this.b(nVar, j3, k1Var);
            }
        };
        if (z16) {
            return c(nVar, b(runnable));
        }
        a(nVar);
        runnable.run();
        return null;
    }

    public void a(String str, String str2, int[] iArr) {
        a(new l(str, str2, iArr));
    }

    public void a() {
        this.f132281a = true;
        k();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (this.f132289i) {
            linkedList.addAll(this.f132290j);
            linkedList.addAll(this.f132291k);
            this.f132290j.clear();
            this.f132291k.clear();
            linkedList2.addAll(this.f132292l);
            linkedList2.addAll(this.f132293m);
            this.f132292l.clear();
            this.f132293m.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.kj.n nVar = (com.tencent.luggage.wxa.kj.n) it.next();
            nVar.x();
            nVar.z();
            nVar.y();
            a(nVar);
        }
        linkedList.clear();
        Iterator it5 = linkedList2.iterator();
        while (it5.hasNext()) {
            removeCallbacks((g0) it5.next());
        }
        linkedList2.clear();
        com.tencent.luggage.wxa.kj.v vVar = this.C;
        if (vVar != null) {
            try {
                vVar.X0();
            } catch (Exception unused) {
            }
            try {
                this.C.e();
            } catch (Exception unused2) {
            }
        }
        com.tencent.luggage.wxa.kj.v vVar2 = this.D;
        if (vVar2 != null) {
            try {
                vVar2.X0();
            } catch (Exception unused3) {
            }
            try {
                this.D.e();
            } catch (Exception unused4) {
            }
        }
        removeAllViews();
        this.M = null;
        this.f132282b = null;
        this.N = null;
        this.H.a();
    }

    public void a(com.tencent.luggage.wxa.kj.v vVar) {
        com.tencent.luggage.wxa.ic.g runtime;
        if (!this.K.a(vVar) || (runtime = getRuntime()) == null) {
            return;
        }
        runtime.b(new Runnable() { // from class: b31.n
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.kj.p.this.g();
            }
        }, 200L);
    }

    public final Object a(com.tencent.luggage.wxa.kj.n nVar, Runnable runnable) {
        return a(nVar, h(nVar), runnable);
    }

    public final void a(com.tencent.luggage.wxa.kj.n nVar) {
        nVar.clearAnimation();
        Object tag = nVar.getTag(R);
        if (tag instanceof Animator) {
            Animator animator = (Animator) tag;
            animator.cancel();
            animator.removeAllListeners();
            nVar.setIsAnimating(false);
            return;
        }
        if (tag instanceof Animation) {
            Animation animation = (Animation) tag;
            animation.setAnimationListener(null);
            animation.cancel();
            nVar.setIsAnimating(false);
        }
    }

    public final Object a(com.tencent.luggage.wxa.kj.n nVar, Object obj, Runnable runnable) {
        if (obj instanceof Animator) {
            Animator animator = (Animator) obj;
            a(nVar);
            nVar.setTag(R, animator);
            animator.addListener(new o(nVar, runnable));
            animator.start();
        } else if (obj instanceof Animation) {
            Animation animation = (Animation) obj;
            animation.setAnimationListener(new AnimationAnimationListenerC6391p(runnable, nVar));
            a(nVar);
            nVar.setTag(R, animation);
            nVar.startAnimation(animation);
        } else {
            if (obj != null) {
                throw new IllegalArgumentException("Page animation should be Animator or Animation");
            }
            if (runnable != null) {
                runnable.run();
            }
        }
        nVar.setIsAnimating(true);
        return obj;
    }

    public final void a(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2, l0 l0Var) {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, pageSwitchResult: " + l0Var);
        Object obj = l0Var.f132356a;
        if (obj instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) obj;
            valueAnimator.addListener(new q(k1Var, nVar, nVar2));
            valueAnimator.addUpdateListener(new r(k1Var, nVar, nVar2));
        } else {
            if (obj instanceof Animation) {
                Animation animation = (Animation) obj;
                Choreographer.getInstance().postFrameCallback(new s(SystemClock.elapsedRealtime(), animation.getDuration(), k1Var, nVar, nVar2, animation));
                return;
            }
            b(k1Var, nVar, nVar2);
        }
    }

    public void a(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2, float f16) {
        c(k1Var, nVar, nVar2);
        b(k1Var, nVar, nVar2, f16);
        i0 i0Var = this.Q;
        if (i0Var != null) {
            i0Var.a(k1Var, nVar, nVar2, f16);
        }
    }

    public void a(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
        c(k1Var, nVar, nVar2);
        d(k1Var, nVar, nVar2);
        i0 i0Var = this.Q;
        if (i0Var != null) {
            i0Var.b(k1Var, nVar, nVar2);
        }
        this.P = false;
    }
}
