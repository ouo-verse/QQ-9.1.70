package com.tencent.open.base.http;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class a<Param, Progress, Result> extends AsyncTask<Param, Progress, Result> {

    /* renamed from: a, reason: collision with root package name */
    protected String f341008a;

    /* renamed from: b, reason: collision with root package name */
    protected String f341009b;

    public a(String str, String str2) {
        this.f341009b = null;
        this.f341008a = str;
        if (!str.toLowerCase().startsWith("http")) {
            this.f341008a = "https://openmobile.qq.com/" + str;
        }
        this.f341009b = str2;
    }

    @SuppressLint({"InlinedApi", "NewApi"})
    public Executor a() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }
}
