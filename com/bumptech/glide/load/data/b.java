package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: d, reason: collision with root package name */
    private final String f31568d;

    /* renamed from: e, reason: collision with root package name */
    private final AssetManager f31569e;

    /* renamed from: f, reason: collision with root package name */
    private T f31570f;

    public b(AssetManager assetManager, String str) {
        this.f31569e = assetManager;
        this.f31568d = str;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T d16 = d(this.f31569e, this.f31568d);
            this.f31570f = d16;
            aVar.d(d16);
        } catch (IOException e16) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e16);
            }
            aVar.c(e16);
        }
    }

    protected abstract void c(T t16) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void cleanup() {
        T t16 = this.f31570f;
        if (t16 == null) {
            return;
        }
        try {
            c(t16);
        } catch (IOException unused) {
        }
    }

    protected abstract T d(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
