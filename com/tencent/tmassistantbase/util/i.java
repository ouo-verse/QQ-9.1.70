package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;

/* compiled from: P */
/* loaded from: classes26.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    protected Context f380475a;

    /* renamed from: b, reason: collision with root package name */
    protected Resources f380476b;

    public i(Context context) {
        this.f380475a = context;
        this.f380476b = context.getResources();
    }

    private int a(String str, String str2) {
        return this.f380476b.getIdentifier(str2, str, this.f380475a.getPackageName());
    }

    public int b(String str) {
        return a("id", str);
    }

    public int c(String str) {
        return a(TtmlNode.TAG_LAYOUT, str);
    }

    public int d(String str) {
        return a(HippyControllerProps.STRING, str);
    }

    public int a(String str) {
        return a("drawable", str);
    }
}
