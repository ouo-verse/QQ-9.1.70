package com.tencent.mobileqq.nsr;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/nsr/c;", "", "", "downloadUrl", "", h.F, "Lcom/tencent/mobileqq/vip/g;", "task", "f", "url", "filePath", "Lcom/tencent/mobileqq/vip/f;", "downloadListener", "c", "g", "Lkotlin/Pair;", "", "e", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "b", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mEntity", "Lcom/tencent/mobileqq/vip/h;", "Lcom/tencent/mobileqq/vip/h;", "mDownloaderInterface", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f254415a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MMKVOptionEntity mEntity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.vip.h mDownloaderInterface;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/nsr/c$a", "Lcom/tencent/mobileqq/vip/f;", "Lcom/tencent/mobileqq/vip/g;", "task", "", "onDoneFile", "onDone", "", "onStart", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class a extends f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(@Nullable g task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) task);
            } else {
                super.onDone(task);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(@Nullable g task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
            } else {
                super.onDoneFile(task);
                c.f254415a.f(task);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(@Nullable g task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) task)).booleanValue();
            }
            return super.onStart(task);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28424);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f254415a = new c();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        mEntity = from;
        mDownloaderInterface = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(final String url, final String filePath, final f downloadListener) {
        boolean z16;
        if (!TextUtils.isEmpty(url)) {
            if (filePath != null && filePath.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nsr.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.d(url, filePath, downloadListener);
                    }
                }, 128, null, true);
                return;
            }
        }
        QLog.i("NsrResDownloader", 1, "cancel real download");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, String filePath, f downloadListener) {
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        Intrinsics.checkNotNullParameter(downloadListener, "$downloadListener");
        g gVar = new g(str, new File(filePath));
        gVar.f313008f = 1;
        gVar.S = "nsr";
        com.tencent.mobileqq.vip.h hVar = mDownloaderInterface;
        if (hVar != null) {
            hVar.startDownload(gVar, downloadListener, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:43:0x000a, B:5:0x0013, B:8:0x001d, B:10:0x0029, B:13:0x0030, B:16:0x0039, B:18:0x003d, B:20:0x004f, B:25:0x005b, B:27:0x005f, B:29:0x007f, B:34:0x008b, B:35:0x0097, B:37:0x0091, B:40:0x00a4), top: B:42:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005f A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:43:0x000a, B:5:0x0013, B:8:0x001d, B:10:0x0029, B:13:0x0030, B:16:0x0039, B:18:0x003d, B:20:0x004f, B:25:0x005b, B:27:0x005f, B:29:0x007f, B:34:0x008b, B:35:0x0097, B:37:0x0091, B:40:0x00a4), top: B:42:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008b A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:43:0x000a, B:5:0x0013, B:8:0x001d, B:10:0x0029, B:13:0x0030, B:16:0x0039, B:18:0x003d, B:20:0x004f, B:25:0x005b, B:27:0x005f, B:29:0x007f, B:34:0x008b, B:35:0x0097, B:37:0x0091, B:40:0x00a4), top: B:42:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091 A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:43:0x000a, B:5:0x0013, B:8:0x001d, B:10:0x0029, B:13:0x0030, B:16:0x0039, B:18:0x003d, B:20:0x004f, B:25:0x005b, B:27:0x005f, B:29:0x007f, B:34:0x008b, B:35:0x0097, B:37:0x0091, B:40:0x00a4), top: B:42:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(g task) {
        Map<String, File> map;
        boolean z16;
        boolean z17;
        JSONObject jSONObject;
        if (task != null) {
            try {
                map = task.f313010h;
            } catch (Throwable th5) {
                QLog.e("NsrResDownloader", 1, th5, new Object[0]);
                return;
            }
        } else {
            map = null;
        }
        if (map != null && !TextUtils.isEmpty(task.f313004c)) {
            File file = task.f313010h.get(task.f313004c);
            if (file == null) {
                QLog.i("NsrResDownloader", 1, "downloaded file is null, cancel handleOnFile");
                return;
            }
            if (!file.exists()) {
                QLog.i("NsrResDownloader", 1, "downloaded file not exit, cancel handleOnFile");
                return;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getPath(), options);
            String str = options.outMimeType;
            if (str != null && str.length() != 0) {
                z16 = false;
                if (!z16) {
                    QLog.i("NsrResDownloader", 1, "downloaded file not exit, cancel handleOnFile");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", options.outWidth);
                jSONObject2.put("height", options.outHeight);
                MMKVOptionEntity mMKVOptionEntity = mEntity;
                String decodeString = mMKVOptionEntity.decodeString("nsrImg", "");
                if (decodeString != null && decodeString.length() != 0) {
                    z17 = false;
                    if (!z17) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = new JSONObject(decodeString);
                    }
                    jSONObject.put(task.f313004c, jSONObject2);
                    mMKVOptionEntity.encodeString("nsrImg", jSONObject.toString());
                    return;
                }
                z17 = true;
                if (!z17) {
                }
                jSONObject.put(task.f313004c, jSONObject2);
                mMKVOptionEntity.encodeString("nsrImg", jSONObject.toString());
                return;
            }
            z16 = true;
            if (!z16) {
            }
        }
        QLog.i("NsrResDownloader", 1, "task info unusual, cancel handleOnFile");
    }

    private final void h(String downloadUrl) {
        c(downloadUrl, com.tencent.mobileqq.nsr.a.f254411a.b(downloadUrl), new a());
    }

    @NotNull
    public final Pair<Integer, Integer> e(@Nullable String url) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
        }
        boolean z17 = false;
        Pair<Integer, Integer> pair = new Pair<>(0, 0);
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return pair;
        }
        String decodeString = mEntity.decodeString("nsrImg", "");
        if (decodeString == null || decodeString.length() == 0) {
            z17 = true;
        }
        if (z17) {
            return pair;
        }
        JSONObject optJSONObject = new JSONObject(decodeString).optJSONObject(url);
        if (optJSONObject == null) {
            return pair;
        }
        return new Pair<>(Integer.valueOf(optJSONObject.optInt("width")), Integer.valueOf(optJSONObject.optInt("height")));
    }

    public final void g(@Nullable String url) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
            return;
        }
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("NsrResDownloader", 1, "url is empty, cancel download");
            }
        } else {
            if (com.tencent.mobileqq.nsr.a.f254411a.a(url) && QLog.isColorLevel()) {
                QLog.d("NsrResDownloader", 1, "file exit, cancel download");
            }
            h(url);
        }
    }
}
