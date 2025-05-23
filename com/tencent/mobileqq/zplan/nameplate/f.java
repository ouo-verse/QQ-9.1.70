package com.tencent.mobileqq.zplan.nameplate;

import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import java.io.File;
import java.io.FileFilter;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/nameplate/f;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "Lcom/tencent/vas/update/business/BaseUpdateBusiness;", "", "getBid", "", "getFrom", "getBusinessDir", "", "id", "getScid", MimeTypeParser.ATTR_EXTENSION, "Ljava/io/File;", "f", "", "i", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "listener", "", "addDownLoadListener", "isEnableCheckFile", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f extends QQVasUpdateBusiness<BaseUpdateBusiness> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(String extension, File file) {
        String extension2;
        Intrinsics.checkNotNullParameter(extension, "$extension");
        Intrinsics.checkNotNullExpressionValue(file, "file");
        extension2 = FilesKt__UtilsKt.getExtension(file);
        return Intrinsics.areEqual(extension2, extension);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public void addDownLoadListener(int id5, IDownLoadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        addDownLoadListener(getScid(id5), listener);
    }

    public final File f(int id5, final String extension) {
        File[] listFiles;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(extension, "extension");
        File file = new File(getSavePath(id5));
        if (!file.isDirectory() || (listFiles = file.listFiles(new FileFilter() { // from class: com.tencent.mobileqq.zplan.nameplate.e
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                boolean h16;
                h16 = f.h(extension, file2);
                return h16;
            }
        })) == null) {
            return null;
        }
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(listFiles);
        return (File) firstOrNull;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 332L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "superQQShowNameplate";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "superQQShowNameplate";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int id5) {
        return "superQQShowNameplate." + id5 + ".common.zip";
    }

    public final boolean i(int id5) {
        return isDownloadingOrUnpacking(getScid(id5));
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return QQVasUpdateBusiness.isEnableFileCheck(getBid());
    }

    public static /* synthetic */ File g(f fVar, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "png";
        }
        return fVar.f(i3, str);
    }
}
