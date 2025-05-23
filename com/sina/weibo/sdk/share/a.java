package com.sina.weibo.sdk.share;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.util.InputMethodUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c9 A[Catch: all -> 0x0162, Exception -> 0x0165, TryCatch #13 {Exception -> 0x0165, all -> 0x0162, blocks: (B:3:0x0007, B:6:0x0016, B:12:0x009a, B:13:0x00c3, B:15:0x00c9, B:18:0x00e2, B:20:0x00e9, B:77:0x00bf, B:82:0x015e, B:83:0x0161), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0127 A[Catch: all -> 0x0153, Exception -> 0x0157, TryCatch #12 {Exception -> 0x0157, all -> 0x0153, blocks: (B:22:0x0102, B:24:0x0127, B:25:0x012a), top: B:21:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013a A[Catch: all -> 0x014f, Exception -> 0x0151, LOOP:0: B:29:0x0133->B:31:0x013a, LOOP_END, TryCatch #11 {Exception -> 0x0151, all -> 0x014f, blocks: (B:28:0x0131, B:29:0x0133, B:31:0x013a, B:33:0x013f), top: B:27:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x013f A[EDGE_INSN: B:32:0x013f->B:33:0x013f BREAK  A[LOOP:0: B:29:0x0133->B:31:0x013a], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018e A[Catch: Exception -> 0x018a, TRY_LEAVE, TryCatch #2 {Exception -> 0x018a, blocks: (B:58:0x0186, B:51:0x018e), top: B:57:0x0186 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015e A[Catch: all -> 0x0162, Exception -> 0x0165, TRY_ENTER, TryCatch #13 {Exception -> 0x0165, all -> 0x0162, blocks: (B:3:0x0007, B:6:0x0016, B:12:0x009a, B:13:0x00c3, B:15:0x00c9, B:18:0x00e2, B:20:0x00e9, B:77:0x00bf, B:82:0x015e, B:83:0x0161), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, Uri uri, int i3) {
        FileOutputStream fileOutputStream;
        Cursor cursor;
        String str;
        BufferedInputStream bufferedInputStream;
        File file;
        byte[] bArr;
        int read;
        String str2;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            String str3 = com.sina.weibo.sdk.c.a.c(context).packageName;
            if (TextUtils.isEmpty(str3)) {
                str3 = "com.sina.weibo";
            }
            String str4 = "/Android/data/" + str3 + "/files/.composerTem/";
            new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str4).mkdirs();
            Calendar calendar = Calendar.getInstance();
            try {
                if ("file".equals(uri.getScheme())) {
                    str = calendar.getTimeInMillis() + uri.getLastPathSegment();
                    cursor = null;
                } else {
                    cursor = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{InputMethodUtil.SOUGOU_URI_DISPLAYNAME}, null, null, null);
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.moveToFirst()) {
                                    str = cursor.getString(cursor.getColumnIndex(InputMethodUtil.SOUGOU_URI_DISPLAYNAME));
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            com.sina.weibo.sdk.c.c.b("WBShareTag", "share util and exception is " + e.getMessage());
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                            str = null;
                            if (TextUtils.isEmpty(str)) {
                            }
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
                            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str4 + str);
                            if (file.exists()) {
                            }
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                bArr = new byte[1444];
                                while (true) {
                                    read = bufferedInputStream.read(bArr);
                                    if (read != -1) {
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                String path = file.getPath();
                                bufferedInputStream.close();
                                fileOutputStream.close();
                                return path;
                            } catch (Exception e17) {
                                e = e17;
                                bufferedInputStream2 = bufferedInputStream;
                                try {
                                    com.sina.weibo.sdk.c.c.b("WBShareTag", "share util and error is " + e.getMessage());
                                    throw new Throwable(e);
                                } catch (Throwable th6) {
                                    th = th6;
                                    if (bufferedInputStream2 != null) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (Exception e18) {
                                            e18.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                bufferedInputStream2 = bufferedInputStream;
                                if (bufferedInputStream2 != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        }
                    }
                    str = null;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e19) {
                e = e19;
                cursor = null;
            } catch (Throwable th8) {
                th = th8;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(Calendar.getInstance().getTimeInMillis());
                if (i3 == 0) {
                    str2 = "_sdk_temp.mp4";
                } else {
                    str2 = "_sdk_temp.jpg";
                }
                sb5.append(str2);
                str = sb5.toString();
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
            try {
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str4 + str);
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
                bArr = new byte[1444];
                while (true) {
                    read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                String path2 = file.getPath();
                try {
                    bufferedInputStream.close();
                    fileOutputStream.close();
                } catch (Exception e26) {
                    e26.printStackTrace();
                }
                return path2;
            } catch (Exception e27) {
                e = e27;
                fileOutputStream = null;
            } catch (Throwable th9) {
                th = th9;
                fileOutputStream = null;
            }
        } catch (Exception e28) {
            e = e28;
            fileOutputStream = null;
        } catch (Throwable th10) {
            th = th10;
            fileOutputStream = null;
        }
    }
}
