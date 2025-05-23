package com.tencent.mobileqq.zootopia.download.normal;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.z1.download.FileDownloadParams;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zootopia.download.BaseDownloadTask;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u0016R\u0019\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/normal/f;", "Lcom/tencent/mobileqq/zootopia/download/BaseDownloadTask;", "", "I", "", DomainData.DOMAIN_NAME, "V", "", "M", "Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadEntity;", "fileDownloadEntity", "d0", HippyTKDListViewAdapter.X, "Ljava/lang/String;", "id", "", "y", "X", "()I", "category", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "b0", "()Ljava/lang/String;", "url", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Z", "filePath", "B", "Y", WadlProxyConsts.PARAM_FILENAME, "Lcom/tencent/mobileqq/z1/download/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/z1/download/a;", "a0", "()Lcom/tencent/mobileqq/z1/download/a;", "fullDownloadParams", "", "header", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/tencent/mobileqq/z1/download/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class f extends BaseDownloadTask {

    /* renamed from: A, reason: from kotlin metadata */
    private final String filePath;

    /* renamed from: B, reason: from kotlin metadata */
    private final String fileName;

    /* renamed from: C, reason: from kotlin metadata */
    private final FileDownloadParams fullDownloadParams;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final String id;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final int category;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final String url;

    public /* synthetic */ f(String str, int i3, String str2, String str3, String str4, Map map, FileDownloadParams fileDownloadParams, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, str3, str4, (i16 & 32) != 0 ? null : map, (i16 & 64) != 0 ? null : fileDownloadParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("Zootopia_DownloadTask", 1, " download file succes and save to album " + this$0.getFinalSavePath());
        ((IFileDepend) QRoute.api(IFileDepend.class)).saveToAlbum(BaseApplication.context, this$0.getFinalSavePath());
    }

    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask
    /* renamed from: I */
    public String getCategory() {
        FileDownloadManager fileDownloadManager = FileDownloadManager.f328148a;
        int i3 = this.category;
        FileDownloadParams fileDownloadParams = this.fullDownloadParams;
        return fileDownloadManager.n(i3, fileDownloadParams != null ? fileDownloadParams.getSubCategoryName() : null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask
    public void M() {
        super.M();
        FileDownloadParams fileDownloadParams = this.fullDownloadParams;
        boolean z16 = false;
        if (fileDownloadParams != null && fileDownloadParams.getNeedSaveToAlbum()) {
            z16 = true;
        }
        if (z16) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.normal.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.c0(f.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask
    public boolean V() {
        return n();
    }

    /* renamed from: X, reason: from getter */
    public final int getCategory() {
        return this.category;
    }

    /* renamed from: Y, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: Z, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: a0, reason: from getter */
    public final FileDownloadParams getFullDownloadParams() {
        return this.fullDownloadParams;
    }

    /* renamed from: b0, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final void d0(FileDownloadEntity fileDownloadEntity) {
        Intrinsics.checkNotNullParameter(fileDownloadEntity, "fileDownloadEntity");
        int i3 = fileDownloadEntity.downloadStatus;
        if (i3 == 5) {
            R(i3);
            N(0);
            String str = fileDownloadEntity.filePath;
            Intrinsics.checkNotNullExpressionValue(str, "fileDownloadEntity.filePath");
            P(str);
            O(ZPlanFileDownloadResult.INSTANCE.a(fileDownloadEntity));
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask, com.tencent.mobileqq.zootopia.download.x
    public boolean n() {
        return this.category == ZPlanFileCategory.LuaDownload.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String id5, int i3, String url, String filePath, String fileName, Map<String, String> map, FileDownloadParams fileDownloadParams) {
        super(id5, url, filePath, fileName, map);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.id = id5;
        this.category = i3;
        this.url = url;
        this.filePath = filePath;
        this.fileName = fileName;
        this.fullDownloadParams = fileDownloadParams;
    }
}
