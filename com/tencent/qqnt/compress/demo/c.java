package com.tencent.qqnt.compress.demo;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.util.InputMethodUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/compress/demo/c;", "", "", WadlProxyConsts.PARAM_FILENAME, "", "e", "(Ljava/lang/String;)[Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "c", "Ljava/io/File;", "file", "newName", "d", "Ljava/io/InputStream;", "input", "Ljava/io/OutputStream;", "output", "", "a", "b", "<init>", "()V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f355724a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39381);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f355724a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long a(InputStream input, OutputStream output) throws IOException {
        byte[] bArr = new byte[4096];
        long j3 = 0;
        while (true) {
            int read = input.read(bArr);
            Unit unit = Unit.INSTANCE;
            if (-1 != read) {
                Intrinsics.checkNotNull(output);
                output.write(bArr, 0, read);
                j3 += read;
            } else {
                return j3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x003e, code lost:
    
        if (r9 != null) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String c(Context context, Uri uri) {
        int lastIndexOf$default;
        String str = null;
        if (Intrinsics.areEqual(uri.getScheme(), "content")) {
            Cursor query = ContactsMonitor.query(context.getContentResolver(), uri, null, null, null, null);
            try {
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str = query.getString(query.getColumnIndex(InputMethodUtil.SOUGOU_URI_DISPLAYNAME));
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        if (str != null) {
                        }
                    }
                }
            } finally {
                query.close();
            }
        }
        if (str != null) {
            String path = uri.getPath();
            Intrinsics.checkNotNull(path);
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) path, separator, 0, false, 6, (Object) null);
            if (lastIndexOf$default != -1) {
                String substring = path.substring(lastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                return substring;
            }
            return path;
        }
        return str;
    }

    private final File d(File file, String newName) {
        File file2 = new File(file.getParent(), newName);
        if (!Intrinsics.areEqual(file2, file)) {
            if (file2.exists() && file2.delete()) {
                Log.d("FileUtil", "Delete old " + newName + " file");
            }
            if (file.renameTo(file2)) {
                Log.d("FileUtil", "Rename file to " + newName);
            }
        }
        return file2;
    }

    private final String[] e(String fileName) {
        int lastIndexOf$default;
        String str;
        Intrinsics.checkNotNull(fileName);
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) fileName, ".", 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            String substring = fileName.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring2 = fileName.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            str = substring2;
            fileName = substring;
        } else {
            str = "";
        }
        return new String[]{fileName, str};
    }

    @NotNull
    public final File b(@NotNull Context context, @NotNull Uri uri) throws IOException {
        FileOutputStream fileOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) uri);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        String c16 = c(context, uri);
        String[] e16 = e(c16);
        File tempFile = File.createTempFile(e16[0], e16[1]);
        Intrinsics.checkNotNullExpressionValue(tempFile, "tempFile");
        File tempFile2 = d(tempFile, c16);
        tempFile2.deleteOnExit();
        try {
            fileOutputStream = new FileOutputStream(tempFile2);
        } catch (FileNotFoundException e17) {
            e17.printStackTrace();
            fileOutputStream = null;
        }
        if (openInputStream != null) {
            a(openInputStream, fileOutputStream);
            openInputStream.close();
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        Intrinsics.checkNotNullExpressionValue(tempFile2, "tempFile");
        return tempFile2;
    }
}
