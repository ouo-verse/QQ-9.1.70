package com.tencent.mtt.hippy.runtime.builtins;

import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g extends e {

    /* renamed from: a, reason: collision with root package name */
    private Pattern f337634a;

    public g(String str, int i3) {
        a("source", str);
        a(WadlProxyConsts.FLAGS, Integer.valueOf(i3));
    }

    public String a() {
        return (String) a("source");
    }

    public int b() {
        return ((Integer) a(WadlProxyConsts.FLAGS)).intValue();
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.e
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g clone() throws CloneNotSupportedException {
        g gVar = (g) super.clone();
        if (gVar.f337634a != null) {
            gVar.f337634a = Pattern.compile(this.f337634a.pattern(), this.f337634a.flags());
        }
        return gVar;
    }
}
