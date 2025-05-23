package com.tencent.xweb.debug;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.preference.Preference;
import com.tencent.luggage.wxa.ar.r0;
import com.tencent.luggage.wxa.qq.k;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;

/* loaded from: classes27.dex */
public class XWebDebugPreference extends Preference implements k {

    /* renamed from: a, reason: collision with root package name */
    public String f385105a;

    public XWebDebugPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XWebDebugPreference);
        this.f385105a = obtainStyledAttributes.getString(R.styleable.XWebDebugPreference_debug_key);
        obtainStyledAttributes.recycle();
    }

    @Override // com.tencent.luggage.wxa.qq.k
    public com.tencent.luggage.wxa.qq.a a(b bVar, Object obj) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.qq.k
    public com.tencent.luggage.wxa.qq.a a(b bVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("source", com.tencent.luggage.wxa.qq.b.DEBUG_VIEW.ordinal());
        bundle.putString("command", "http://debugxweb.qq.com/?" + a());
        return r0.a(bundle, bVar);
    }

    @Override // com.tencent.luggage.wxa.qq.k
    public String a() {
        return this.f385105a;
    }
}
