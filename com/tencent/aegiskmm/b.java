package com.tencent.aegiskmm;

import android.os.Build;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aegiskmm/b;", "Lcom/tencent/aegiskmm/f;", "", "a", "", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public final class b implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String name = "Android " + Build.VERSION.SDK_INT;

    @Override // com.tencent.aegiskmm.f
    public long a() {
        return System.currentTimeMillis();
    }
}
