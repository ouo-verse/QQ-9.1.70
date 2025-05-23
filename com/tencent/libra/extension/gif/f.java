package com.tencent.libra.extension.gif;

import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class f {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class b extends f {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f118753a;

        /* renamed from: b, reason: collision with root package name */
        private final String f118754b;

        public b(@NonNull AssetManager assetManager, @NonNull String str) {
            super();
            this.f118753a = assetManager;
            this.f118754b = str;
        }

        @Override // com.tencent.libra.extension.gif.f
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f118753a.openFd(this.f118754b));
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class c extends f {

        /* renamed from: a, reason: collision with root package name */
        private final String f118755a;

        public c(@NonNull File file) {
            super();
            this.f118755a = file.getPath();
        }

        @Override // com.tencent.libra.extension.gif.f
        GifInfoHandle a() throws GifIOException {
            return new GifInfoHandle(this.f118755a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class d extends f {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f118756a;

        /* renamed from: b, reason: collision with root package name */
        private final int f118757b;

        public d(@NonNull Resources resources, @DrawableRes @RawRes int i3) {
            super();
            this.f118756a = resources;
            this.f118757b = i3;
        }

        @Override // com.tencent.libra.extension.gif.f
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f118756a.openRawResourceFd(this.f118757b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract GifInfoHandle a() throws IOException;

    f() {
    }
}
