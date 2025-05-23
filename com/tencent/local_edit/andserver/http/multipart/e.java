package com.tencent.local_edit.andserver.http.multipart;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.http.g;
import java.util.Collections;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e extends g implements c {

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.local_edit.andserver.http.b f119830b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.local_edit.andserver.util.f<String, b> f119831c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.local_edit.andserver.util.f<String, String> f119832d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f119833e;

    public e(@NonNull com.tencent.local_edit.andserver.http.b bVar, @NonNull com.tencent.local_edit.andserver.util.f<String, b> fVar, @NonNull com.tencent.local_edit.andserver.util.f<String, String> fVar2, @NonNull Map<String, String> map) {
        super(bVar);
        this.f119830b = bVar;
        this.f119831c = new com.tencent.local_edit.andserver.util.e(Collections.unmodifiableMap(fVar));
        this.f119832d = new com.tencent.local_edit.andserver.util.e(Collections.unmodifiableMap(fVar2));
        this.f119833e = Collections.unmodifiableMap(map);
    }

    @Override // com.tencent.local_edit.andserver.http.multipart.c
    @NonNull
    public com.tencent.local_edit.andserver.util.f<String, b> c() {
        return this.f119831c;
    }

    @Nullable
    public b f(String str) {
        return this.f119831c.b(str);
    }

    @Override // com.tencent.local_edit.andserver.http.g, com.tencent.local_edit.andserver.http.b
    @Nullable
    public String getParameter(@NonNull String str) {
        String b16 = this.f119832d.b(str);
        if (TextUtils.isEmpty(b16)) {
            return this.f119830b.getParameter(str);
        }
        return b16;
    }
}
