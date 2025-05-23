package com.tencent.luggage.wxa.wd;

import android.os.Parcelable;
import com.tencent.luggage.wxa.ka.i;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements i {

    /* renamed from: a, reason: collision with root package name */
    public i f144201a;

    public e(i iVar) {
        this.f144201a = iVar;
    }

    @Override // com.tencent.luggage.wxa.ka.i
    public void a(Parcelable data) {
        Intrinsics.checkNotNullParameter(data, "data");
        i iVar = this.f144201a;
        if (iVar != null) {
            iVar.a(data);
        }
    }

    public final void a(i iVar) {
        this.f144201a = iVar;
    }
}
