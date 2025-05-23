package com.tencent.libra.base.model;

import android.graphics.ImageDecoder;
import android.os.Parcelable;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u01.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0007H&J\u000f\u0010\t\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0013\u0010\u0011\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0017\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/libra/base/model/Model;", "Z", "Landroid/os/Parcelable;", "Landroid/graphics/ImageDecoder$Source;", "b", "Ljava/io/InputStream;", "c", "Lu01/c;", "e", "a", "()Ljava/lang/Object;", "", "f", "", "g", "", "other", "equals", "", "hashCode", "toString", "d", "Ljava/lang/Object;", "modelData", "<init>", "(Ljava/lang/Object;)V", "libra-extension-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public abstract class Model<Z> implements Parcelable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Z modelData;

    public Model(Z z16) {
        this.modelData = z16;
    }

    public Z a() {
        return this.modelData;
    }

    @NotNull
    public abstract ImageDecoder.Source b();

    @NotNull
    public abstract InputStream c();

    @NotNull
    public abstract c e();

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        Class<?> cls2 = getClass();
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (true ^ Intrinsics.areEqual(cls2, cls)) {
            return false;
        }
        if (other != null) {
            return Intrinsics.areEqual(a(), ((Model) other).a());
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.libra.base.model.Model<*>");
    }

    @NotNull
    public String f() {
        return String.valueOf(a());
    }

    public boolean g() {
        return false;
    }

    public int hashCode() {
        Z a16 = a();
        if (a16 != null) {
            return a16.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return super.toString() + ':' + f();
    }
}
