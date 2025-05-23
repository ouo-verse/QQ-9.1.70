package com.tencent.filament.zplan.plugin;

import android.util.Log;
import com.tencent.filament.js.annotation.JsFilamentEvent;
import com.tencent.filament.js.annotation.JsFilamentPlugin;
import com.tencent.filament.zplanservice.util.log.FLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@JsFilamentPlugin
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/filament/zplan/plugin/FilamentZipPlugin;", "", "", "zipFilePath", "folderPath", "b", "Lcom/tencent/filament/zplan/engine/js/a;", "req", "unzip", "<init>", "()V", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentZipPlugin {
    /* JADX INFO: Access modifiers changed from: private */
    public final String b(String zipFilePath, String folderPath) {
        char last;
        boolean contains$default;
        BufferedOutputStream bufferedOutputStream;
        try {
            last = StringsKt___StringsKt.last(folderPath);
            if (last != File.separatorChar) {
                folderPath = folderPath + File.separatorChar;
            }
            ZipFile zipFile = new ZipFile(zipFilePath);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            byte[] bArr = new byte[8192];
            while (true) {
                InputStream inputStream = null;
                if (!entries.hasMoreElements()) {
                    return null;
                }
                ZipEntry nextElement = entries.nextElement();
                if (nextElement != null) {
                    ZipEntry zipEntry = nextElement;
                    String name = zipEntry.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "ze.name");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "..", false, 2, (Object) null);
                    if (!contains$default) {
                        if (zipEntry.isDirectory()) {
                            String str = folderPath + zipEntry.getName();
                            Charset forName = Charset.forName("8859_1");
                            Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
                            if (str != null) {
                                byte[] bytes = str.getBytes(forName);
                                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                                Charset forName2 = Charset.forName("GB2312");
                                Intrinsics.checkNotNullExpressionValue(forName2, "Charset.forName(charsetName)");
                                new File(new String(bytes, forName2)).mkdir();
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            File file = new File(folderPath + zipEntry.getName());
                            File parentFile = file.getParentFile();
                            if (parentFile != null) {
                                parentFile.mkdirs();
                            }
                            try {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedOutputStream = null;
                            }
                            try {
                                inputStream = zipFile.getInputStream(zipEntry);
                                while (true) {
                                    int read = inputStream.read(bArr, 0, 8192);
                                    if (read != -1) {
                                        bufferedOutputStream.write(bArr, 0, read);
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException unused) {
                                        }
                                    }
                                }
                                inputStream.close();
                                try {
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream.close();
                                } catch (IOException unused2) {
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.flush();
                                        bufferedOutputStream.close();
                                        throw th;
                                    } catch (IOException unused4) {
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.util.zip.ZipEntry");
                }
            }
        } catch (Exception e16) {
            Log.e("FilamentZipPlugin", "unzip error: ", e16);
            return e16.getMessage();
        }
    }

    @JsFilamentEvent({"unzip"})
    @NotNull
    public final String unzip(@NotNull com.tencent.filament.zplan.engine.js.a req) {
        Intrinsics.checkNotNullParameter(req, "req");
        FLog.INSTANCE.i("FilamentZipPlugin", "unzip. req: " + req);
        JSONObject jSONObject = new JSONObject(req.getJsonParams());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FilamentZipPlugin$unzip$1(this, jSONObject.optString("zipPath"), jSONObject.optString("toPath"), req, null), 3, null);
        return "";
    }
}
