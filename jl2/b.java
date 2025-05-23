package jl2;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qwallet.pet.data.DownloadDetail;
import com.tencent.mobileqq.qwallet.pet.data.ModelDownloadState;
import com.tencent.mobileqq.qwallet.pet.data.ModelType;
import com.tencent.mobileqq.qwallet.pet.download.PetDownloadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a8\u0006\u001b"}, d2 = {"Ljl2/b;", "", "Lcom/tencent/mobileqq/qwallet/pet/data/ModelType;", "modelType", "", "url", "filePath", "", "c", "", "i", "suffix", "e", "finalFilePath", "d", "f", "Landroid/content/Context;", "a", "Lcom/tencent/mobileqq/qwallet/pet/data/b;", "b", "g", "Lorg/json/JSONArray;", "intJsonArray", "", h.F, "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f410584a = new b();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f410585a;

        static {
            int[] iArr = new int[ModelType.values().length];
            try {
                iArr[ModelType.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ModelType.PET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ModelType.CLOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ModelType.KTX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f410585a = iArr;
        }
    }

    b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean c(ModelType modelType, String url, String filePath) {
        boolean z16;
        boolean z17;
        boolean z18;
        try {
            if (a.f410585a[modelType.ordinal()] != 1) {
                String g16 = g(modelType, filePath);
                if (g16 != null && g16.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        z17 = false;
                        if (filePath != null && filePath.length() != 0) {
                            z18 = false;
                            if (!z18 && !z17) {
                                d(url, filePath);
                            }
                            i(filePath);
                            return z17;
                        }
                        z18 = true;
                        if (!z18) {
                            d(url, filePath);
                        }
                        i(filePath);
                        return z17;
                    }
                }
                z16 = true;
                if (!z16) {
                }
            }
            z17 = true;
            if (filePath != null) {
                z18 = false;
                if (!z18) {
                }
                i(filePath);
                return z17;
            }
            z18 = true;
            if (!z18) {
            }
            i(filePath);
            return z17;
        } catch (Exception e16) {
            QLog.w("QWallet.Pet.utils", 1, "checkTargetFileExist catch:", e16);
            return false;
        }
    }

    private final void d(String url, String finalFilePath) {
        if (finalFilePath == null) {
            return;
        }
        PetDownloadManager petDownloadManager = PetDownloadManager.f278805a;
        petDownloadManager.s(finalFilePath);
        QLog.w("QWallet.Pet.utils", 1, "deleteInvalidModel: " + url + " " + finalFilePath);
        String v3 = petDownloadManager.v(url);
        if (!Intrinsics.areEqual(v3, finalFilePath)) {
            petDownloadManager.s(v3);
            QLog.w("QWallet.Pet.utils", 1, "deleteInvalidModel: " + url + " " + v3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00da, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String e(String filePath, String suffix) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean endsWith$default;
        boolean z19;
        boolean endsWith$default2;
        if (filePath != null && filePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        File file = new File(filePath);
        if (!file.isDirectory()) {
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(filePath, suffix, false, 2, null);
            if (!endsWith$default2) {
                return null;
            }
            return file.getName();
        }
        String[] files = file.list();
        if (files != null) {
            if (files.length == 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (!z19) {
                z17 = false;
                if (!z17) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(files, "files");
                ArrayList arrayList = new ArrayList();
                for (String str : files) {
                    if (!Intrinsics.areEqual(str, "__MACOSX")) {
                        arrayList.add(str);
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    String str3 = filePath + File.separator + str2;
                    File file2 = new File(str3);
                    if (file2.isDirectory()) {
                        String e16 = f410584a.e(str3, suffix);
                        if (e16 != null && e16.length() != 0) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        if (!z18) {
                            return e16;
                        }
                    } else if (file2.isFile()) {
                        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str3, suffix, false, 2, null);
                        if (endsWith$default) {
                            long length = file2.length();
                            QLog.i("QWallet.Pet.utils", 2, "target file: " + file2 + " size=" + length);
                            if (length > 0) {
                                return str2;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        z17 = true;
        if (!z17) {
        }
    }

    private final String f(String filePath) {
        String[] list;
        String it;
        boolean endsWith$default;
        if (filePath == null || (list = new File(filePath).list()) == null) {
            return null;
        }
        int length = list.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                it = list[i3];
                Intrinsics.checkNotNullExpressionValue(it, "it");
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(it, ".gltf", false, 2, null);
                if (endsWith$default) {
                    break;
                }
                i3++;
            } else {
                it = null;
                break;
            }
        }
        String e16 = e(filePath, ".gltf");
        String e17 = e(filePath, ".bin");
        if (e16 != null && e17 != null) {
            return it;
        }
        QLog.w("QWallet.Pet.utils", 1, "model res error: gltfFile=" + e16 + " binFile=" + e17 + ", path=" + filePath);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void i(String filePath) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (filePath != null && filePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        File file = new File(filePath);
        if (!file.isDirectory()) {
            QLog.i("QWallet.Pet.utils", 1, "size=" + file.length() + MsgSummary.STR_COLON + filePath);
            return;
        }
        String[] files = file.list();
        if (files != null) {
            if (files.length == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                z17 = false;
                if (!z17) {
                    QLog.w("QWallet.Pet.utils", 1, filePath + " is empty dir!!");
                    return;
                }
                StringBuilder sb5 = new StringBuilder(filePath + MsgSummary.STR_COLON);
                Intrinsics.checkNotNullExpressionValue(files, "files");
                ArrayList<String> arrayList = new ArrayList();
                for (String str : files) {
                    if (!Intrinsics.areEqual(str, "__MACOSX")) {
                        arrayList.add(str);
                    }
                }
                for (String str2 : arrayList) {
                    String str3 = filePath + File.separator + str2;
                    File file2 = new File(str3);
                    if (file2.isDirectory()) {
                        f410584a.i(str3);
                    } else if (file2.isFile()) {
                        sb5.append("[" + str2 + ContainerUtils.KEY_VALUE_DELIMITER + file2.length() + "]");
                    }
                }
                QLog.i("QWallet.Pet.utils", 1, sb5.toString());
                return;
            }
        }
        z17 = true;
        if (!z17) {
        }
    }

    @NotNull
    public final Context a() {
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        return applicationContext;
    }

    @Nullable
    public final DownloadDetail b(@NotNull ModelType modelType, @Nullable String url) {
        boolean z16;
        ModelDownloadState modelDownloadState;
        Intrinsics.checkNotNullParameter(modelType, "modelType");
        boolean z17 = false;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        String p16 = PetDownloadManager.f278805a.p(url);
        boolean c16 = c(modelType, url, p16);
        if (p16 == null || p16.length() == 0) {
            z17 = true;
        }
        if (!z17 && c16) {
            modelDownloadState = ModelDownloadState.DOWNLOADED;
        } else {
            modelDownloadState = ModelDownloadState.UNKNOWN;
        }
        return new DownloadDetail(url, modelDownloadState, p16, g(modelType, p16), modelType);
    }

    @Nullable
    public final String g(@NotNull ModelType modelType, @Nullable String filePath) {
        Intrinsics.checkNotNullParameter(modelType, "modelType");
        int i3 = a.f410585a[modelType.ordinal()];
        if (i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                return null;
            }
            return e(filePath, ".ktx");
        }
        return f(filePath);
    }

    @Nullable
    public final List<String> h(@Nullable JSONArray intJsonArray) {
        if (intJsonArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = intJsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            String string = intJsonArray.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "intJsonArray.getString(index)");
            arrayList.add(string);
        }
        return arrayList;
    }
}
