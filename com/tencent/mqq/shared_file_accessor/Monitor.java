package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes21.dex */
public final class Monitor {
    private static final String CP_URI_BASE = "content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl";
    private static final String DEFAULT_SP_NAME = "default";
    private static final String TAG = "Monitor";
    private WeakReference<Context> mContext;
    private Uri mUri;

    public Monitor(WeakReference<Context> weakReference, String str) {
        this.mContext = weakReference;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/params?file=");
        sb5.append(str == null ? "default" : str);
        this.mUri = Uri.parse(sb5.toString());
    }

    public void log(String str) {
        Cursor cursor;
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null) {
            return;
        }
        Context context = weakReference.get();
        if (context == null && TextUtils.isEmpty(str)) {
            return;
        }
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), this.mUri, new String[]{"cmd", "101", "process", Utils.sCurrentProcessName, "log", str}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused2) {
            }
        }
    }
}
