package com.tencent.luggage.wxa.standalone_open_runtime.container;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.ui.WxaSimpleWebViewActivity;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.bo.a;
import com.tencent.luggage.wxa.g6.c;
import com.tencent.luggage.wxa.g6.p;
import com.tencent.luggage.wxa.g6.q;
import com.tencent.luggage.wxa.hn.y0;
import com.tencent.luggage.wxa.k7.g;
import com.tencent.luggage.wxa.n3.x;
import com.tencent.luggage.wxa.o1.b;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.v3.d;
import com.tencent.luggage.wxa.v3.e;
import com.tencent.luggage.wxa.v3.f;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0003H\u0014J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0002R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/luggage/wxa/standalone_open_runtime/container/WxaContainerActivity0;", "Lcom/tencent/luggage/wxa/o1/b;", "Lcom/tencent/luggage/wxa/g6/q;", "Ljava/lang/Class;", "Lcom/tencent/luggage/wxa/c5/e;", "i", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Lcom/tencent/luggage/wxa/o1/a;", "k", "Landroid/content/res/Resources;", "getResources", "", "name", "", "getSystemService", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/app/Activity;", "f", "Lcom/tencent/luggage/wxa/g6/p;", "getNavigator", "r", "Landroid/view/ContextThemeWrapper;", h.F, "Landroid/view/ContextThemeWrapper;", "mThemeWrapper", "", "Z", "mInitializingResources", "j", "Landroid/content/res/Resources;", "mOverrideResources", "mInitializingInflater", "Landroid/view/LayoutInflater;", "l", "Landroid/view/LayoutInflater;", "mOverrideInflater", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class WxaContainerActivity0 extends b implements q {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public ContextThemeWrapper mThemeWrapper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public boolean mInitializingResources;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public Resources mOverrideResources;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public boolean mInitializingInflater;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public LayoutInflater mOverrideInflater;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements f.c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f140727a = new a();

        @Override // com.tencent.luggage.wxa.v3.f.c
        public final String a(BaseResp baseResp) {
            if (baseResp instanceof WXLaunchWxaRedirectingPage.Resp) {
                return ((WXLaunchWxaRedirectingPage.Resp) baseResp).invokeTicket;
            }
            return "";
        }
    }

    static {
        f.a(WXLaunchWxaRedirectingPage.Resp.class, a.f140727a);
        final com.tencent.luggage.wxa.z8.b bVar = com.tencent.luggage.wxa.z8.b.f146383a;
        new IListener<e>(bVar) { // from class: com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerActivity0$Companion$2
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(e event) {
                Context context;
                com.tencent.luggage.wxa.v3.b bVar2;
                Intrinsics.checkNotNullParameter(event, "event");
                d d16 = event.d();
                if (d16 != null && (bVar2 = d16.f143055a) != null) {
                    context = bVar2.getContext();
                } else {
                    context = null;
                }
                Activity a16 = a.a(context);
                if (a16 != null) {
                    Intent intent = new Intent(a16, (Class<?>) WxaContainerToFrontProxyActivity.class);
                    intent.addFlags(65536);
                    com.tencent.luggage.wxa.fa.b.a(a16, intent);
                    a16.startActivity(intent);
                    return false;
                }
                return false;
            }
        }.alive();
        new IListener<x>(bVar) { // from class: com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerActivity0$Companion$3
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(x event) {
                boolean z16;
                Intrinsics.checkNotNullParameter(event, "event");
                y0 d16 = event.d();
                if (-13003 == d16.f129051e.f128970d) {
                    String str = d16.f129059m;
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        WxaSimpleWebViewActivity.INSTANCE.a(z.c(), d16.f129059m);
                    }
                }
                return false;
            }
        }.alive();
    }

    @Override // com.tencent.luggage.wxa.g6.q
    public p getNavigator() {
        return c.f126467a;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mInitializingResources) {
            return super.getResources();
        }
        Resources resources = this.mOverrideResources;
        if (resources != null) {
            return resources;
        }
        this.mInitializingResources = true;
        Resources resources2 = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "super.getResources()");
        com.tencent.luggage.wxa.k7.b bVar = new com.tencent.luggage.wxa.k7.b(resources2);
        this.mOverrideResources = bVar;
        this.mInitializingResources = false;
        return bVar;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual("layout_inflater", name)) {
            if (this.mInitializingInflater) {
                return super.getSystemService(name);
            }
            LayoutInflater layoutInflater = this.mOverrideInflater;
            if (layoutInflater != null) {
                return layoutInflater;
            }
            this.mInitializingInflater = true;
            r();
            LayoutInflater from = LayoutInflater.from(this.mThemeWrapper);
            this.mOverrideInflater = from;
            this.mInitializingInflater = false;
            return from;
        }
        return super.getSystemService(name);
    }

    @Override // com.tencent.luggage.wxa.o1.b
    public Class i() {
        return com.tencent.luggage.wxa.g7.d.class;
    }

    @Override // com.tencent.luggage.wxa.o1.b
    public Class k() {
        return com.tencent.luggage.wxa.k7.e.class;
    }

    @Override // com.tencent.luggage.wxa.o1.b, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            com.tencent.luggage.wxa.q7.b.a(applicationContext);
        }
        setTheme(R.style.atv);
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.luggage.wxa.o1.b, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.tencent.luggage.wxa.o1.a j3 = j();
        if (j3 != null) {
            j3.t();
        }
        super.onDestroy();
        LuggageActivityHelper.REMOVE(this);
        com.tencent.luggage.wxa.bo.a.b(this);
    }

    public final void r() {
        if (this.mThemeWrapper != null) {
            return;
        }
        this.mThemeWrapper = new g(this);
    }

    @Override // com.tencent.luggage.wxa.ol.t0
    public Activity f() {
        return this;
    }
}
