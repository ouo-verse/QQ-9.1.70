package com.tencent.mtt.hippy.dom.node;

import android.text.style.ForegroundColorSpan;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class HippyForegroundColorSpan extends ForegroundColorSpan {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private Object f337372a;

    public HippyForegroundColorSpan(int i3) {
        this(i3, null);
    }

    public Object a() {
        return this.f337372a;
    }

    public HippyForegroundColorSpan(int i3, Object obj) {
        super(i3);
        this.f337372a = obj;
    }
}
