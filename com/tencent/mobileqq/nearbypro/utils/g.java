package com.tencent.mobileqq.nearbypro.utils;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.util.RFWIOUtil;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J@\u0010\u0010\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u000e0\rJ\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/g;", "", "Ljava/io/File;", "b", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", WadlProxyConsts.PARAM_FILENAME, "f", "Landroid/content/Context;", "ctx", "", "saveToMediaStore", "Lkotlin/Function1;", "", "callback", "c", "filePath", "e", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f253949a = new g();

    g() {
    }

    private final File b() {
        File file = new File(BaseApplication.context.getExternalCacheDir(), "nearbypro/tmp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 callback, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (rFWSaveMediaResultBean != null && rFWSaveMediaResultBean.isSuccess) {
            callback.invoke(rFWSaveMediaResultBean.savePath);
            return;
        }
        callback.invoke(null);
        com.tencent.mobileqq.nearbypro.base.j.c().d("FileUtils", "savePNG: saveAsMediaStoreImage err " + rFWSaveMediaResultBean);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
    
        if (r1 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0069, code lost:
    
        r4.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b8, code lost:
    
        if (r1 != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String f(Bitmap bitmap, String fileName) {
        File file;
        String str;
        BufferedOutputStream bufferedOutputStream;
        boolean z16 = false;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            file = new File(b(), fileName);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 8192);
                try {
                    str = file.getAbsolutePath();
                } catch (Exception e16) {
                    e = e16;
                    str = null;
                } catch (Throwable th5) {
                    th = th5;
                    str = null;
                }
            } catch (Exception e17) {
                e = e17;
                str = null;
            } catch (Throwable th6) {
                th = th6;
                str = null;
            }
        } catch (Exception e18) {
            e = e18;
            file = null;
            str = null;
        } catch (Throwable th7) {
            th = th7;
            file = null;
            str = null;
        }
        try {
        } catch (Exception e19) {
            e = e19;
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                com.tencent.mobileqq.nearbypro.base.j.c().d("FileUtils", "saveBitmap: saveAsCacheImage err" + e);
                RFWIOUtil.flushAll(bufferedOutputStream2);
                RFWIOUtil.closeAll(bufferedOutputStream2);
                if (str == null) {
                    if (file != null && file.exists()) {
                        z16 = true;
                    }
                }
                return str;
            } catch (Throwable th8) {
                th = th8;
                RFWIOUtil.flushAll(bufferedOutputStream2);
                RFWIOUtil.closeAll(bufferedOutputStream2);
                if (str == null) {
                    if (file != null && file.exists()) {
                        z16 = true;
                    }
                    if (z16) {
                        file.delete();
                    }
                }
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            bufferedOutputStream2 = bufferedOutputStream;
            RFWIOUtil.flushAll(bufferedOutputStream2);
            RFWIOUtil.closeAll(bufferedOutputStream2);
            if (str == null) {
            }
            throw th;
        }
        if (!bitmap.compress(Bitmap.CompressFormat.PNG, 75, bufferedOutputStream)) {
            com.tencent.mobileqq.nearbypro.base.j.c().d("FileUtils", "savePNG: compress err");
            RFWIOUtil.flushAll(bufferedOutputStream);
            RFWIOUtil.closeAll(bufferedOutputStream);
            if (str == null) {
                if (file.exists()) {
                    z16 = true;
                }
                if (z16) {
                    file.delete();
                }
            }
            return null;
        }
        RFWIOUtil.flushAll(bufferedOutputStream);
        RFWIOUtil.closeAll(bufferedOutputStream);
        if (str == null) {
            if (file.exists()) {
                z16 = true;
            }
        }
        return str;
    }

    public final void c(@Nullable Context ctx, @NotNull Bitmap bitmap, @NotNull String fileName, boolean saveToMediaStore, @NotNull final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!saveToMediaStore) {
            callback.invoke(f(bitmap, fileName));
        } else if (ctx == null) {
            callback.invoke(null);
        } else {
            RFWSaveUtil.saveBitmapAndInsertImage(ctx, bitmap, new File(b(), fileName).getAbsolutePath(), false, new Consumer() { // from class: com.tencent.mobileqq.nearbypro.utils.f
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    g.d(Function1.this, (RFWSaveMediaResultBean) obj);
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006f, code lost:
    
        if (r1 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
    
        r4.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c0, code lost:
    
        if (r1 != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d5  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String e(@NotNull Bitmap bitmap, @NotNull String filePath) {
        File file;
        String str;
        BufferedOutputStream bufferedOutputStream;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        boolean z16 = false;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            file = new File(filePath);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 8192);
                try {
                    str = file.getAbsolutePath();
                    try {
                    } catch (Exception e16) {
                        e = e16;
                        bufferedOutputStream2 = bufferedOutputStream;
                        try {
                            com.tencent.mobileqq.nearbypro.base.j.c().d("FileUtils", "saveBitmap: saveAsCacheImage err" + e);
                            RFWIOUtil.flushAll(bufferedOutputStream2);
                            RFWIOUtil.closeAll(bufferedOutputStream2);
                            if (str == null) {
                                if (file != null && file.exists()) {
                                    z16 = true;
                                }
                            }
                            return str;
                        } catch (Throwable th5) {
                            th = th5;
                            RFWIOUtil.flushAll(bufferedOutputStream2);
                            RFWIOUtil.closeAll(bufferedOutputStream2);
                            if (str == null) {
                                if (file != null && file.exists()) {
                                    z16 = true;
                                }
                                if (z16) {
                                    file.delete();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedOutputStream2 = bufferedOutputStream;
                        RFWIOUtil.flushAll(bufferedOutputStream2);
                        RFWIOUtil.closeAll(bufferedOutputStream2);
                        if (str == null) {
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                    str = null;
                } catch (Throwable th7) {
                    th = th7;
                    str = null;
                }
            } catch (Exception e18) {
                e = e18;
                str = null;
            } catch (Throwable th8) {
                th = th8;
                str = null;
            }
        } catch (Exception e19) {
            e = e19;
            file = null;
            str = null;
        } catch (Throwable th9) {
            th = th9;
            file = null;
            str = null;
        }
        if (!bitmap.compress(Bitmap.CompressFormat.PNG, 75, bufferedOutputStream)) {
            com.tencent.mobileqq.nearbypro.base.j.c().d("FileUtils", "savePNG: compress err");
            RFWIOUtil.flushAll(bufferedOutputStream);
            RFWIOUtil.closeAll(bufferedOutputStream);
            if (str == null) {
                if (file.exists()) {
                    z16 = true;
                }
                if (z16) {
                    file.delete();
                }
            }
            return null;
        }
        RFWIOUtil.flushAll(bufferedOutputStream);
        RFWIOUtil.closeAll(bufferedOutputStream);
        if (str == null) {
            if (file.exists()) {
                z16 = true;
            }
        }
        return str;
    }
}
