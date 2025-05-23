package com.tencent.mobileqq.winkpublish.api;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\bg\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aJ,\u0010\t\u001a\u00020\b2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH&J\b\u0010\u0018\u001a\u00020\bH&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/api/ITaskSnapshotApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "localMediaInfo", "", "durationUs", "", "saveOriginalMediaInfo", "", "feat", "onFeatStart", "", "type", "onUpdateExportType", "recSize", "totalSize", "onUpdateUploadInfo", "onFeatEnd", "progressText", "exportProgress", "uploadProgress", "getSnapshotInfo", QCircleLpReportDc05507.KEY_CLEAR, "Companion", "a", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface ITaskSnapshotApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f327167a;

    @NotNull
    public static final String FEAT_UPLOAD_VIDEO = "UploadVideoFeat";

    @NotNull
    public static final String FEAT_UPLOAD_VIDEO_COVER = "UploadVideoCoverFeat";

    @NotNull
    public static final String FEAT_VIDEO_EXPORT_UPLOAD = "VideoExportUploadFeat";

    @NotNull
    public static final String FEAT_WAIT_VIDEO_EXPORT = "WaitVideoExportFeat";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/api/ITaskSnapshotApi$a;", "", "<init>", "()V", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f327167a = new Companion();

        Companion() {
        }
    }

    void clear();

    @NotNull
    String getSnapshotInfo(@NotNull String progressText, int exportProgress, int uploadProgress);

    void onFeatEnd(@NotNull String feat);

    void onFeatStart(@NotNull String feat);

    void onUpdateExportType(int type);

    void onUpdateUploadInfo(long recSize, long totalSize);

    void saveOriginalMediaInfo(@Nullable ArrayList<LocalMediaInfo> localMediaInfo, long durationUs);
}
