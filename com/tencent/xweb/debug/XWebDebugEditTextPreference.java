package com.tencent.xweb.debug;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.preference.EditTextPreference;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.luggage.wxa.ar.r0;
import com.tencent.luggage.wxa.qq.k;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;

/* loaded from: classes27.dex */
public class XWebDebugEditTextPreference extends EditTextPreference implements k {

    /* renamed from: a, reason: collision with root package name */
    public String f385103a;

    public XWebDebugEditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XWebDebugPreference);
        this.f385103a = obtainStyledAttributes.getString(R.styleable.XWebDebugPreference_debug_key);
        obtainStyledAttributes.recycle();
    }

    @Override // com.tencent.luggage.wxa.qq.k
    public com.tencent.luggage.wxa.qq.a a(b bVar) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.qq.k
    public com.tencent.luggage.wxa.qq.a a(b bVar, Object obj) {
        Bundle bundle = new Bundle();
        bundle.putInt("source", com.tencent.luggage.wxa.qq.b.DEBUG_VIEW.ordinal());
        bundle.putString("command", "http://debugxweb.qq.com/?" + a() + ContainerUtils.KEY_VALUE_DELIMITER + obj);
        return r0.a(bundle, bVar);
    }

    @Override // com.tencent.luggage.wxa.qq.k
    public String a() {
        return this.f385103a;
    }
}
