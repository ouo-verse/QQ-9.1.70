package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.nt.NTFileManageBridger;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.panorama.util.PanoramaConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J(\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J.\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001e\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\"\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u001d\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\"\u0010\u001f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOFileManagerApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOFileManagerApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "Lkotlin/Function0;", "", "updateUI", "downloadFile", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElement", "", "fileElemId", "Lkotlin/Pair;", "", "fixFileThumbSize", "", "path", "fixFileThumbSizeFromFile", "getPicFileDefaultSize", "Lmqq/app/AppRuntime;", "app", "troopUin", "fileUuid", "getTroopFilePathFromTransMgrByFileId", "getVideoFileDefaultSize", "cancelDownloadFile", "cancelSendFile", "reSendFile", PanoramaConfig.KEY_CURRENT_UIN, "openTroopFileBrowser", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOFileManagerApiImpl implements IAIOFileManagerApi {
    public static final int FILE_VIDEO_DEFAULT_HEIGHT = 480;
    public static final int FILE_VIDEO_DEFAULT_WIDTH = 640;
    private static final String TAG = "AIOFileManagerApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadFile$lambda$0(Function0 updateUI, int i3, String str) {
        Intrinsics.checkNotNullParameter(updateUI, "$updateUI");
        QLog.i(TAG, 1, "download errCode: " + i3 + ", errMsg: " + str);
        if (i3 == 0) {
            updateUI.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reSendFile$lambda$5(Function0 updateUI, int i3, String str) {
        Intrinsics.checkNotNullParameter(updateUI, "$updateUI");
        QLog.i(TAG, 1, "download errCode: " + i3 + ", errMsg: " + str);
        if (i3 == 0) {
            updateUI.invoke();
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public void cancelDownloadFile(AIOMsgItem aioMsgItem) {
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        MsgElement e16 = qu3.i.e(aioMsgItem.getMsgRecord());
        if (e16 == null) {
            return;
        }
        NTFileUtils.b a16 = su3.d.f434769a.a(aioMsgItem.s0());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i(TAG, 1, "appRuntime is not QQAppInterface");
        } else {
            ((QQAppInterface) peekAppRuntime).getNTFileManageBridger().I(a16, aioMsgItem.getMsgRecord(), e16.elementId);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public void cancelSendFile(AIOMsgItem aioMsgItem) {
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i(TAG, 1, "appRuntime is not QQAppInterface");
        } else {
            ((QQAppInterface) peekAppRuntime).getNTFileManageBridger().L(aioMsgItem.getMsgRecord());
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public void downloadFile(Activity activity, AIOMsgItem aioMsgItem, final Function0<Unit> updateUI) {
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Intrinsics.checkNotNullParameter(updateUI, "updateUI");
        MsgElement e16 = qu3.i.e(aioMsgItem.getMsgRecord());
        if (e16 == null) {
            return;
        }
        MsgRecordParams s06 = aioMsgItem.s0();
        if (s06 == null) {
            s06 = aioMsgItem.k0();
        }
        NTFileUtils.b a16 = su3.d.f434769a.a(s06);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i(TAG, 1, "appRuntime is not QQAppInterface");
        } else {
            ((QQAppInterface) peekAppRuntime).getNTFileManageBridger().O(activity, a16, aioMsgItem.getMsgRecord(), e16.elementId, "", new NTFileManageBridger.f() { // from class: com.tencent.qqnt.aio.adapter.api.impl.n
                @Override // com.tencent.mobileqq.filemanager.nt.NTFileManageBridger.f
                public final void onResult(int i3, String str) {
                    AIOFileManagerApiImpl.downloadFile$lambda$0(Function0.this, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public Pair<Integer, Integer> fixFileThumbSize(AIOMsgItem aioMsgItem, FileElement fileElement, long fileElemId) {
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Intrinsics.checkNotNullParameter(fileElement, "fileElement");
        NTFileUtils.b a16 = su3.d.f434769a.a(aioMsgItem.s0());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i(TAG, 1, "appRuntime is not QQAppInterface");
            return null;
        }
        FileManagerEntity j3 = NTFileUtils.j((QQAppInterface) peekAppRuntime, a16, aioMsgItem.getMsgRecord(), fileElement, fileElemId);
        if (j3 == null) {
            return null;
        }
        FileManagerUtil.fixEntityThumbSize(j3);
        return new Pair<>(Integer.valueOf(j3.imgWidth), Integer.valueOf(j3.imgHeight));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public Pair<Integer, Integer> fixFileThumbSizeFromFile(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!com.tencent.mobileqq.filemanager.util.q.f(path)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).decodeFileWithBufferedStream(path, options);
        int exifRotation = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExifRotation(path);
        if (exifRotation != 90 && exifRotation != 270) {
            return new Pair<>(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
        }
        return new Pair<>(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public Pair<Integer, Integer> getPicFileDefaultSize() {
        FilePicURLDrawlableHelper.a h16 = FilePicURLDrawlableHelper.h(FilePicURLDrawlableHelper.f209169c, FilePicURLDrawlableHelper.f209170d, false);
        return new Pair<>(Integer.valueOf(h16.f209173a), Integer.valueOf(h16.f209174b));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public String getTroopFilePathFromTransMgrByFileId(AppRuntime app, String troopUin, String fileUuid) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(fileUuid, "fileUuid");
        return NTFileUtils.n(app instanceof QQAppInterface ? (QQAppInterface) app : null, troopUin, fileUuid);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public void openTroopFileBrowser(Activity activity, String troopUin, String currentUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(currentUin, "currentUin");
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(QZoneHelper.Constants.KEY_QUN_ID, troopUin);
        ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileMainPage(activity, intent, 0);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public void reSendFile(Activity activity, AIOMsgItem aioMsgItem, final Function0<Unit> updateUI) {
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Intrinsics.checkNotNullParameter(updateUI, "updateUI");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i(TAG, 1, "appRuntime is not QQAppInterface");
        } else {
            ((QQAppInterface) peekAppRuntime).getNTFileManageBridger().F0(activity, aioMsgItem.getMsgRecord(), new NTFileManageBridger.f() { // from class: com.tencent.qqnt.aio.adapter.api.impl.m
                @Override // com.tencent.mobileqq.filemanager.nt.NTFileManageBridger.f
                public final void onResult(int i3, String str) {
                    AIOFileManagerApiImpl.reSendFile$lambda$5(Function0.this, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public Pair<Integer, Integer> getVideoFileDefaultSize() {
        int[] adjustSize = ShortVideoUtils.adjustSize(640, 480);
        return new Pair<>(Integer.valueOf(adjustSize[0]), Integer.valueOf(adjustSize[1]));
    }
}
