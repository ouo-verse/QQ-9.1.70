package com.tencent.open.pcpush;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import java.io.File;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a {
    public static boolean a(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static Intent b(Context context, File file) {
        if (context != null && file != null && file.isFile()) {
            String trim = file.getName().toLowerCase().trim();
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.addFlags(268435456);
            if (a(trim, context.getResources().getStringArray(R.array.f155197am))) {
                intent.setDataAndType(Uri.fromFile(file), "image/*");
            } else if (a(trim, context.getResources().getStringArray(R.array.f155203as))) {
                intent.setDataAndType(Uri.parse(file.toString()).buildUpon().encodedAuthority("com.android.htmlfileprovider").scheme("content").encodedPath(file.toString()).build(), "text/html");
            } else if (a(trim, context.getResources().getStringArray(R.array.f155194aj))) {
                intent.addFlags(67108864);
                intent.putExtra("oneshot", 0);
                intent.putExtra("configchange", 0);
                intent.setDataAndType(Uri.fromFile(file), "audio/*");
            } else if (a(trim, context.getResources().getStringArray(R.array.f155202ar))) {
                intent.addFlags(67108864);
                intent.putExtra("oneshot", 0);
                intent.putExtra("configchange", 0);
                intent.setDataAndType(Uri.fromFile(file), "video/*");
            } else if (a(trim, context.getResources().getStringArray(R.array.f155201aq))) {
                intent.setDataAndType(Uri.fromFile(file), "text/plain");
            } else if (a(trim, context.getResources().getStringArray(R.array.f155200ap))) {
                intent.setDataAndType(Uri.fromFile(file), MediaType.APPLICATION_PDF_VALUE);
            } else if (a(trim, context.getResources().getStringArray(R.array.f155204at))) {
                intent.setDataAndType(Uri.fromFile(file), "application/msword");
            } else if (a(trim, context.getResources().getStringArray(R.array.f155196al))) {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.ms-excel");
            } else if (a(trim, context.getResources().getStringArray(R.array.f155198an))) {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.ms-powerpoint");
            } else if (a(trim, context.getResources().getStringArray(R.array.f155195ak))) {
                intent.setDataAndType(Uri.fromFile(file), "application/x-chm");
            } else {
                intent.setDataAndType(Uri.fromFile(file), MimeTypeMap.getSingleton().getMimeTypeFromExtension(trim.substring(trim.lastIndexOf(".") + 1).toLowerCase().trim()));
            }
            FileProvider7Helper.intentCompatForN(context, intent);
            return intent;
        }
        return null;
    }
}
