package com.tencent.kuikly.core.views;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/views/ag;", "", "", "base64Image", "b", "", "src", "a", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    public static final ag f118358a = new ag();

    ag() {
    }

    public final String a(byte[] src) {
        Intrinsics.checkNotNullParameter(src, "src");
        return "byte_array:_Md5_" + src.hashCode();
    }

    public final String b(String base64Image) {
        Intrinsics.checkNotNullParameter(base64Image, "base64Image");
        return "data:image_Md5_" + base64Image.hashCode();
    }
}
