package i51;

import com.tencent.minibox.common.log.LogUtils;
import com.tencent.oskplayer.cache.FileDataSink;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import m51.b;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Li51/a;", "", "", "targetPath", "Ljava/io/File;", "a", "url", "", "b", "<init>", "()V", "MiniBoxCommon_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f407248a = new a();

    a() {
    }

    private final File a(String targetPath) {
        File file = new File(targetPath + FileDataSink.TEMP_FILE);
        try {
            m51.a.e(file);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        } catch (Exception e16) {
            LogUtils.e("FileDownloader", "download: targetFile operate fail.", e16);
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(@NotNull String url, @NotNull String targetPath) {
        FileOutputStream fileOutputStream;
        boolean z16;
        ResponseBody body;
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(targetPath, "targetPath");
        Response response = j51.a.f409276b.a().newCall(new Request.Builder().url(url).build()).execute();
        Intrinsics.checkExpressionValueIsNotNull(response, "response");
        if (!response.isSuccessful()) {
            LogUtils.e("FileDownloader", "download: failed. code=" + response.code() + ", msg=" + response.message());
            return false;
        }
        File a16 = a(targetPath);
        InputStream inputStream = null;
        try {
            body = response.body();
        } catch (Exception unused) {
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
        if (body != null) {
            InputStream byteStream = body.byteStream();
            if (byteStream != null) {
                try {
                    fileOutputStream = new FileOutputStream(a16);
                } catch (Exception unused2) {
                    fileOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[4096];
                    Ref.IntRef intRef = new Ref.IntRef();
                    while (true) {
                        int read = byteStream.read(bArr);
                        intRef.element = read;
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    b.a(byteStream);
                    b.a(fileOutputStream);
                    z16 = true;
                } catch (Exception unused3) {
                    inputStream = byteStream;
                    try {
                        LogUtils.e("FileDownloader", "download: failed. url=" + url + ", targetPath=" + targetPath);
                        b.a(inputStream);
                        b.a(fileOutputStream);
                        z16 = false;
                        if (z16) {
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        b.a(inputStream);
                        b.a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    inputStream = byteStream;
                    b.a(inputStream);
                    b.a(fileOutputStream);
                    throw th;
                }
                if (z16) {
                    return false;
                }
                File file = new File(targetPath);
                if (file.exists()) {
                    file.delete();
                }
                return a16.renameTo(file);
            }
        }
        b.a(null);
        b.a(null);
        return false;
    }
}
