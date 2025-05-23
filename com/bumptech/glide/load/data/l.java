package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class l<T> implements d<T> {

    /* renamed from: d, reason: collision with root package name */
    private final Uri f31591d;

    /* renamed from: e, reason: collision with root package name */
    private final ContentResolver f31592e;

    /* renamed from: f, reason: collision with root package name */
    private T f31593f;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f31592e = contentResolver;
        this.f31591d = uri;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T d16 = d(this.f31591d, this.f31592e);
            this.f31593f = d16;
            aVar.d(d16);
        } catch (FileNotFoundException e16) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e16);
            }
            aVar.c(e16);
        }
    }

    protected abstract void c(T t16) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void cleanup() {
        T t16 = this.f31593f;
        if (t16 != null) {
            try {
                c(t16);
            } catch (IOException unused) {
            }
        }
    }

    protected abstract T d(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
