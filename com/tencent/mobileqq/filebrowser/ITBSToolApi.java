package com.tencent.mobileqq.filebrowser;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import com.tencent.luggage.wxa.bf.l0;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.RFWLayerFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H&J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J0\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u0010\u0017\u001a\u00020\u001f2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u0004\u0012\u00020\u00030 H&J4\u0010!\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030 H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/filebrowser/ITBSToolApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "forwardTBSToolFile", "", "filePath", "", "forwardTBSToolFileList", "fileList", "", "getFileListByExt", "extArray", "", "callback", "getMediaLayerFragment", "Ljava/lang/Class;", "Lcom/tencent/richframework/gallery/RFWLayerFragment;", "getTBSToolIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "openFile", "sessionId", "", "path", "openWebPage", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "args", "pickPhotoFromAlbum", "Landroid/content/Intent;", "pickPhotoFromCamera", "registerAlbumActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/ComponentActivity;", "Lkotlin/Function1;", l0.NAME, "tempFilePath", "srcFileName", "newSaveCallback", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "startWatchTopActivity", "stopWatchTopActivity", "qqfile-filebrowser-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface ITBSToolApi extends QRouteApi {
    void forwardTBSToolFile(@NotNull String filePath);

    void forwardTBSToolFileList(@NotNull List<String> fileList);

    void getFileListByExt(@Nullable Object extArray, @Nullable Object callback);

    @NotNull
    Class<? extends RFWLayerFragment> getMediaLayerFragment();

    @NotNull
    QIPCModule getTBSToolIPCModule();

    void openFile(long sessionId);

    void openFile(@NotNull String path);

    void openWebPage(@NotNull Activity activity, @Nullable Object args);

    @NotNull
    Intent pickPhotoFromAlbum(@NotNull Activity activity);

    void pickPhotoFromCamera(@NotNull Activity activity);

    @NotNull
    ActivityResultLauncher<Intent> registerAlbumActivityResult(@NotNull ComponentActivity activity, @NotNull Function1<? super List<String>, Unit> callback);

    void saveFile(long sessionId, @NotNull String tempFilePath, @NotNull String srcFileName, @NotNull Function1<? super FileManagerEntity, Unit> newSaveCallback);

    void startWatchTopActivity(@NotNull Activity activity);

    void stopWatchTopActivity(@NotNull Activity activity);
}
