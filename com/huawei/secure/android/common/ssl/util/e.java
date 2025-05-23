package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e extends AsyncTask<Context, Integer, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37983a = "e";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e16) {
            g.b(f37983a, "doInBackground: exception : " + e16.getMessage());
            inputStream = null;
        }
        g.a(f37983a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream != null) {
            f.a(inputStream);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        g.a(f37983a, "onPreExecute");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            g.c(f37983a, "onPostExecute: upate done");
        } else {
            g.b(f37983a, "onPostExecute: upate failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        g.c(f37983a, "onProgressUpdate");
    }
}
