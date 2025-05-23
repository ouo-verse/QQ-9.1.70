package com.tencent.luggage.wxa.kl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.R;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h extends e {

    /* renamed from: f, reason: collision with root package name */
    public String f132654f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f132655g;

    public h(Context context) {
        super(context);
        View.inflate(context, R.layout.dxs, this);
        View findViewById = findViewById(R.id.tlt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.capsule_trade_option_view_iv)");
        setIcon((ImageView) findViewById);
        View findViewById2 = findViewById(R.id.tlu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.capsule_trade_option_view_tv)");
        this.f132655g = (TextView) findViewById2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        com.tencent.luggage.wxa.bk.h hVar = (com.tencent.luggage.wxa.bk.h) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.bk.h.class);
        if (hVar != null) {
            String str = this.f132654f;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appId");
                str = null;
            }
            hVar.k(str);
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.tencent.luggage.wxa.bk.h hVar = (com.tencent.luggage.wxa.bk.h) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.bk.h.class);
        if (hVar != null) {
            String str = this.f132654f;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appId");
                str = null;
            }
            hVar.m(str);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.luggage.wxa.kl.e
    public void setColor(@ColorInt int i3) {
        if (getMStyleColor() == i3) {
            return;
        }
        if (i3 == -1) {
            this.f132655g.setTextColor(-1);
        } else {
            this.f132655g.setTextColor(-16777216);
        }
        a(i3);
        setMStyleColor(i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Context context, Map params, Function1 onViewCreated) {
        this(context);
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(onViewCreated, "onViewCreated");
        this.f132654f = String.valueOf(params.get("key_appid"));
        this.f132655g.setText(String.valueOf(params.get("key_content")));
        setMOnViewCreated(onViewCreated);
        a(String.valueOf(params.get("key_img_url")), false);
        a(String.valueOf(params.get("key_img_url_dark")), true);
    }
}
