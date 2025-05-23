package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.api.IFileThumbGeneratorApi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00112\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\tJ\u0014\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001dR\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0016\u0010!\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/filemanager/util/c;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "outputPath", "", "c", "", "", "cache", TagName.FILE_TYPE, "b", "outDir", "e", "width", "height", "f", "gap", "d", "", "Lcom/tencent/mobileqq/filemanager/data/FileInfo;", "fileList", "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Ljava/lang/String;", "mOutDir", "I", "mWidth", "mHeight", "mGap", "<init>", "(Landroid/content/Context;)V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mOutDir;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mGap;

    public c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mOutDir = "";
    }

    private final Bitmap b(Map<Integer, Bitmap> cache, int fileType) {
        int a16 = FlashTransferUtils.f209184a.a(fileType);
        Bitmap bitmap = cache.get(Integer.valueOf(a16));
        if (bitmap == null && (bitmap = BitmapFactory.decodeResource(this.context.getResources(), a16)) != null) {
            cache.put(Integer.valueOf(a16), bitmap);
        }
        return bitmap;
    }

    private final void c(Bitmap bitmap, String outputPath) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(outputPath));
        try {
            fileOutputStream.write(byteArray);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    @NotNull
    public final String a(@NotNull List<? extends FileInfo> fileList) {
        boolean z16;
        Iterator<? extends FileInfo> it;
        Bitmap bitmap;
        int i3;
        Intrinsics.checkNotNullParameter(fileList, "fileList");
        if (fileList.isEmpty()) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String SDCARD_FILE_SAVE_TMP_PATH = this.mOutDir;
        if (SDCARD_FILE_SAVE_TMP_PATH.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            SDCARD_FILE_SAVE_TMP_PATH = AppConstants.SDCARD_FILE_SAVE_TMP_PATH;
            Intrinsics.checkNotNullExpressionValue(SDCARD_FILE_SAVE_TMP_PATH, "SDCARD_FILE_SAVE_TMP_PATH");
        }
        File file = new File(SDCARD_FILE_SAVE_TMP_PATH);
        if (!file.exists()) {
            file.mkdir();
        }
        String str = SDCARD_FILE_SAVE_TMP_PATH + fileList.hashCode() + util.base64_pad_url + currentTimeMillis + ".png";
        try {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            ArrayList arrayList2 = new ArrayList();
            Iterator<? extends FileInfo> it5 = fileList.iterator();
            while (it5.hasNext()) {
                FileInfo next = it5.next();
                long currentTimeMillis2 = System.currentTimeMillis();
                next.B(ah.o0(next.j()));
                if (next.getType() == 0) {
                    bitmap = BitmapFactory.decodeFile(next.k());
                    it = it5;
                } else if (next.getType() == 2) {
                    IFileThumbGeneratorApi iFileThumbGeneratorApi = (IFileThumbGeneratorApi) QRoute.api(IFileThumbGeneratorApi.class);
                    String k3 = next.k();
                    int i16 = this.mWidth;
                    it = it5;
                    int i17 = this.mHeight;
                    if (i16 <= i17) {
                        i16 = i17;
                    }
                    bitmap = iFileThumbGeneratorApi.generateViewThumbBitmap(k3, i16);
                } else {
                    it = it5;
                    bitmap = null;
                }
                if (bitmap == null) {
                    bitmap = b(hashMap, next.getType());
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (bitmap != null) {
                    arrayList.add(new a(bitmap, i3));
                }
                arrayList2.add(Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                it5 = it;
            }
            Object[] array = arrayList.toArray(new a[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            long currentTimeMillis3 = System.currentTimeMillis();
            Bitmap d16 = new ax(this.context).k(this.mGap).l(this.mWidth, this.mHeight).i((a[]) array).d();
            long currentTimeMillis4 = System.currentTimeMillis();
            c(d16, str);
            QLog.d("CoverPictureHelper", 1, "generate cover sucess readBitmap: " + (currentTimeMillis3 - currentTimeMillis) + ", " + arrayList2 + ", combine: " + (currentTimeMillis4 - currentTimeMillis3) + ", save: " + (System.currentTimeMillis() - currentTimeMillis4));
            return str;
        } catch (IOException e16) {
            QLog.d("CoverPictureHelper", 1, "generate cover Failed", e16);
            return "";
        }
    }

    @NotNull
    public final c d(int gap) {
        this.mGap = gap;
        return this;
    }

    @NotNull
    public final c e(@NotNull String outDir) {
        Intrinsics.checkNotNullParameter(outDir, "outDir");
        this.mOutDir = outDir;
        return this;
    }

    @NotNull
    public final c f(int width, int height) {
        this.mWidth = width;
        this.mHeight = height;
        return this;
    }
}
