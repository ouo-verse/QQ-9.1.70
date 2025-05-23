package com.tencent.qqmini.sdk.core.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.File;

/* loaded from: classes23.dex */
public class FileProvider7Helper {
    public static Uri savePhotoToSysAlbum(Context context, File file) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        Uri fromFile = Uri.fromFile(file);
        intent.setData(fromFile);
        context.sendBroadcast(intent);
        return fromFile;
    }
}
