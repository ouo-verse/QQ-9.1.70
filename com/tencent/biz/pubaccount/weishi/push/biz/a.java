package com.tencent.biz.pubaccount.weishi.push.biz;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.push.a;
import com.tencent.biz.pubaccount.weishi.push.b;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class a<MSG extends com.tencent.biz.pubaccount.weishi.push.a, INFO extends com.tencent.biz.pubaccount.weishi.push.b> {

    /* renamed from: a, reason: collision with root package name */
    MSG f81348a;

    public a(MSG msg2) {
        this.f81348a = msg2;
    }

    public abstract boolean a(Context context, INFO info);
}
