package com.heytap.mcssdk.b;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.mcssdk.f.d;
import com.heytap.mcssdk.f.f;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36133a = "Heytap PUSH";

    /* renamed from: b, reason: collision with root package name */
    private static final String f36134b = "System Default Channel";

    /* renamed from: c, reason: collision with root package name */
    private static final int f36135c = 3;

    public void a(final Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        f.a(new Runnable() { // from class: com.heytap.mcssdk.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.a(context)) {
                    return;
                }
                String string = context.getString(R.string.f230106y9);
                if (TextUtils.isEmpty(string)) {
                    string = a.f36134b;
                }
                d.a(context, a.this.a(context, a.f36133a, string, 3));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(26)
    public boolean a(Context context, String str, String str2, int i3) {
        NotificationManager notificationManager;
        if (context != null && (notificationManager = (NotificationManager) context.getSystemService("notification")) != null) {
            notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i3));
            return true;
        }
        return false;
    }
}
