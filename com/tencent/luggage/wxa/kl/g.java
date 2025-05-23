package com.tencent.luggage.wxa.kl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends e {

    /* renamed from: f, reason: collision with root package name */
    public String f132651f;

    /* renamed from: g, reason: collision with root package name */
    public String f132652g;

    /* renamed from: h, reason: collision with root package name */
    public String f132653h;

    public g(Context context) {
        super(context);
        View.inflate(context, R.layout.dxr, this);
        View findViewById = findViewById(R.id.tlr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.capsule_koubei_option_view_iv)");
        setIcon((ImageView) findViewById);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        com.tencent.luggage.wxa.bk.h hVar = (com.tencent.luggage.wxa.bk.h) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.bk.h.class);
        String str = this.f132651f;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appId");
            str = null;
        }
        String str3 = this.f132652g;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagePath");
            str3 = null;
        }
        String str4 = this.f132653h;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionBuffer");
        } else {
            str2 = str4;
        }
        hVar.a(str, str3, str2);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.tencent.luggage.wxa.bk.h hVar = (com.tencent.luggage.wxa.bk.h) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.bk.h.class);
        String str = this.f132651f;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appId");
            str = null;
        }
        String str3 = this.f132652g;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagePath");
            str3 = null;
        }
        String str4 = this.f132653h;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionBuffer");
        } else {
            str2 = str4;
        }
        hVar.b(str, str3, str2);
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Context context, Map params, Function1 onViewCreated) {
        this(context);
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(onViewCreated, "onViewCreated");
        setMOnViewCreated(onViewCreated);
        this.f132651f = String.valueOf(params.get("key_appid"));
        this.f132652g = String.valueOf(params.get("key_page_path"));
        this.f132653h = String.valueOf(params.get("key_session_buffer"));
        a(String.valueOf(params.get("key_img_url")), false);
        a(String.valueOf(params.get("key_img_url_dark")), true);
    }
}
