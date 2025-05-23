package com.tribe.async.async;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class SimpleJob<Result> extends Job<Void, Void, Result> {
    public SimpleJob() {
        this("SimpleJob");
    }

    public SimpleJob(@NonNull String str) {
        super(str);
    }
}
