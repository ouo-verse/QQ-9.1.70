package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.util.SparseArray;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final String f208240a;

    /* renamed from: b, reason: collision with root package name */
    private final int f208241b;

    /* renamed from: c, reason: collision with root package name */
    private final SparseArray<Object> f208242c;

    public d(String str, int i3, @NonNull SparseArray<Object> sparseArray) {
        this.f208240a = str;
        this.f208241b = i3;
        this.f208242c = sparseArray;
    }

    public SparseArray<Object> a() {
        return this.f208242c;
    }

    public int b() {
        return this.f208241b;
    }

    public boolean c() {
        if (!com.tencent.mobileqq.qrscan.utils.b.g(this.f208241b) && !com.tencent.mobileqq.qrscan.utils.b.f(this.f208241b)) {
            return false;
        }
        return true;
    }
}
