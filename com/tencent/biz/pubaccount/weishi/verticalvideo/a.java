package com.tencent.biz.pubaccount.weishi.verticalvideo;

import com.tencent.biz.pubaccount.weishi.util.ah;
import com.tencent.biz.pubaccount.weishi.util.bb;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/a;", "", "", "key", "b", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f81840a = new a();

    a() {
    }

    private final String b(String key) {
        String str;
        Map<String, String> i3 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().i();
        return (i3 == null || (str = i3.get(key)) == null) ? "" : str;
    }

    public final int a() {
        int i3 = 84;
        int Y = bb.Y(b("icon_size"), 84);
        if (Y <= 84) {
            i3 = 72;
            if (Y >= 72) {
                i3 = Y;
            }
        }
        return ah.b(i3 / 2.0f);
    }
}
