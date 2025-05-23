package com.tencent.luggage.wxa.tn;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m {
    public static Uri a(Context context, com.tencent.luggage.wxa.cp.v vVar) {
        String b16 = com.tencent.luggage.wxa.cp.x.b(vVar.m(), false);
        if (b16 == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".external.fileprovider", new File(b16));
        }
        return Uri.fromFile(new File(b16));
    }
}
