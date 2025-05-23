package com.tencent.mobileqq.filemanager.fileviewer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\f\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J:\u0010\u0015\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J?\u0010\u0019\u001a\u00020\n2\u0010\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/l;", "Landroid/print/PrintDocumentAdapter;", "Ljava/io/File;", "file", "", "a", "Landroid/os/ParcelFileDescriptor;", "destination", "Landroid/print/PrintDocumentAdapter$WriteResultCallback;", "callback", "", "b", "c", "Landroid/print/PrintAttributes;", "oldAttributes", "newAttributes", "Landroid/os/CancellationSignal;", "cancellationSignal", "Landroid/print/PrintDocumentAdapter$LayoutResultCallback;", "Landroid/os/Bundle;", "extras", "onLayout", "", "Landroid/print/PageRange;", "pages", "onWrite", "([Landroid/print/PageRange;Landroid/os/ParcelFileDescriptor;Landroid/os/CancellationSignal;Landroid/print/PrintDocumentAdapter$WriteResultCallback;)V", "", "Ljava/lang/String;", "filePath", "Ljava/io/File;", "<init>", "(Ljava/lang/String;)V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class l extends PrintDocumentAdapter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String filePath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final File file;

    public l(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    private final boolean a(File file) {
        List listOf;
        String extension;
        boolean equals;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"jpg", MimeHelper.IMAGE_SUBTYPE_JPEG, "png", "bmp", "gif"});
        List<String> list = listOf;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            extension = FilesKt__UtilsKt.getExtension(file);
            equals = StringsKt__StringsJVMKt.equals(extension, str, true);
            if (equals) {
                return true;
            }
        }
        return false;
    }

    private final void b(ParcelFileDescriptor destination, PrintDocumentAdapter.WriteResultCallback callback) {
        Bitmap decodeFile = BitmapFactory.decodeFile(this.file.getPath());
        PdfDocument pdfDocument = new PdfDocument();
        PdfDocument.Page startPage = pdfDocument.startPage(new PdfDocument.PageInfo.Builder(decodeFile.getWidth(), decodeFile.getHeight(), 1).create());
        FileDescriptor fileDescriptor = null;
        startPage.getCanvas().drawBitmap(decodeFile, 0.0f, 0.0f, (Paint) null);
        pdfDocument.finishPage(startPage);
        try {
            try {
                if (destination != null) {
                    fileDescriptor = destination.getFileDescriptor();
                }
                pdfDocument.writeTo(new FileOutputStream(fileDescriptor));
                if (callback != null) {
                    callback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                }
            } catch (IOException e16) {
                if (callback != null) {
                    String message = e16.getMessage();
                    if (message == null) {
                        message = "Unknown error";
                    }
                    callback.onWriteFailed(message);
                }
            }
        } finally {
            pdfDocument.close();
            decodeFile.recycle();
        }
    }

    private final void c(ParcelFileDescriptor destination, PrintDocumentAdapter.WriteResultCallback callback) {
        FileDescriptor fileDescriptor;
        FileInputStream fileInputStream = new FileInputStream(this.file);
        try {
            if (destination != null) {
                fileDescriptor = destination.getFileDescriptor();
            } else {
                fileDescriptor = null;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(fileDescriptor);
            try {
                ByteStreamsKt.copyTo$default(fileInputStream, fileOutputStream, 0, 2, null);
                CloseableKt.closeFinally(fileOutputStream, null);
                CloseableKt.closeFinally(fileInputStream, null);
                if (callback != null) {
                    callback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                }
            } finally {
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(fileInputStream, th5);
                throw th6;
            }
        }
    }

    @Override // android.print.PrintDocumentAdapter
    public void onLayout(@Nullable PrintAttributes oldAttributes, @Nullable PrintAttributes newAttributes, @Nullable CancellationSignal cancellationSignal, @Nullable PrintDocumentAdapter.LayoutResultCallback callback, @Nullable Bundle extras) {
        boolean z16;
        if (cancellationSignal != null && cancellationSignal.isCanceled()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (callback != null) {
                callback.onLayoutCancelled();
            }
        } else {
            if (this.file.exists() && this.file.canRead()) {
                if (callback != null) {
                    callback.onLayoutFinished(new PrintDocumentInfo.Builder(this.file.getName()).setContentType(0).setPageCount(-1).build(), true);
                    return;
                }
                return;
            }
            QLog.e("PdfPrintDocumentAdapter", 1, "[onLayout] File does not exist or cannot be read: " + this.filePath);
            if (callback != null) {
                callback.onLayoutFailed("File not accessible");
            }
        }
    }

    @Override // android.print.PrintDocumentAdapter
    public void onWrite(@Nullable PageRange[] pages, @Nullable ParcelFileDescriptor destination, @Nullable CancellationSignal cancellationSignal, @Nullable PrintDocumentAdapter.WriteResultCallback callback) {
        boolean z16 = false;
        if (cancellationSignal != null && cancellationSignal.isCanceled()) {
            z16 = true;
        }
        if (z16) {
            if (callback != null) {
                callback.onWriteCancelled();
                return;
            }
            return;
        }
        try {
            if (a(this.file)) {
                b(destination, callback);
            } else {
                c(destination, callback);
            }
        } catch (Exception e16) {
            QLog.e("PdfPrintDocumentAdapter", 1, "print file failed: " + e16.getMessage());
            if (callback != null) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                callback.onWriteFailed(message);
            }
        }
    }
}
