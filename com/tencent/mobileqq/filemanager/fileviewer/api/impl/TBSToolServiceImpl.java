package com.tencent.mobileqq.filemanager.fileviewer.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filebrowser.ITBSToolApi;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.ITBSToolService;
import com.tencent.mobileqq.filemanager.openbrowser.c;
import com.tencent.mobileqq.filemanager.openbrowser.d;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J#\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0016\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nH\u0016J(\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/api/impl/TBSToolServiceImpl;", "Lcom/tencent/mobileqq/filemanager/fileviewer/api/ITBSToolService;", "()V", "browserFile", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "entity", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "action", "", "browserMedia", "fileList", "", "(Landroid/app/Activity;[Ljava/lang/String;)V", "openMedia", "pathList", "", "saveFileToWeiYun", "path", "shareFileToFriend", "bundle", "Landroid/os/Bundle;", "uin", "uinType", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class TBSToolServiceImpl implements ITBSToolService {
    private final void openMedia(Activity activity, List<String> pathList) {
        ArrayList arrayList = new ArrayList();
        for (String str : pathList) {
            int fileType = FileManagerUtil.getFileType(str);
            if (fileType != 0) {
                if (fileType == 2) {
                    RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
                    RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
                    rFWLayerVideoInfo.setFileId(str);
                    rFWLayerVideoInfo.setLocalPath(str);
                    rFWLayerVideoInfo.setCurrentVideoUrl(str);
                    rFWLayerItemMediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
                    arrayList.add(rFWLayerItemMediaInfo);
                }
            } else {
                RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
                rFWPicInfo.setLocalPath(str);
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = new RFWLayerItemMediaInfo();
                RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
                rFWLayerPicInfo.setPicId(str);
                rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo);
                rFWLayerPicInfo.setBigPicInfo(rFWPicInfo);
                rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
                rFWLayerItemMediaInfo2.setLayerPicInfo(rFWLayerPicInfo);
                arrayList.add(rFWLayerItemMediaInfo2);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        RFWLayerLaunchUtil.jumpToGallery$default(activity, null, arrayList, 0, QQGalleryActivity.class, ((ITBSToolApi) QRoute.api(ITBSToolApi.class)).getMediaLayerFragment(), new Bundle(), 0, 128, null);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.ITBSToolService
    public void browserFile(@NotNull Activity activity, @NotNull FileManagerEntity entity, @NotNull String action) {
        QQAppInterface qQAppInterface;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(action, "action");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        int fileType = FileManagerUtil.getFileType(entity.strFilePath);
        if (fileType == 0 || fileType == 2) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(entity.getFilePath());
            openMedia(activity, arrayListOf);
        } else {
            Bundle bundle = new Bundle();
            d dVar = new d(qQAppInterface, entity);
            dVar.S(bundle);
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(activity, dVar, new c().d(13).g(action));
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.ITBSToolService
    public void browserMedia(@NotNull Activity activity, @NotNull String[] fileList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fileList, "fileList");
        ArrayList arrayList = new ArrayList();
        for (String str : fileList) {
            int fileType = FileManagerUtil.getFileType(str);
            if (fileType != 0 && fileType != 2) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        openMedia(activity, arrayList);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.ITBSToolService
    public void saveFileToWeiYun(@NotNull String path) {
        QQAppInterface qQAppInterface;
        Intrinsics.checkNotNullParameter(path, "path");
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) runtime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        qQAppInterface.getFileManagerEngine().F0(path, null, qQAppInterface.getAccount(), "", 0, false);
        com.tencent.mobileqq.filemanager.util.d.d(QBaseActivity.sTopActivity.getString(R.string.f170978be3));
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.ITBSToolService
    public void shareFileToFriend(@NotNull Activity activity, @NotNull Bundle bundle, @NotNull String uin, int uinType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        intent.putExtra("key_direct_show_uin_type", uinType);
        intent.putExtra("key_direct_show_uin", uin);
        ForwardBaseOption.startForwardActivityForResult(activity, intent, 103);
    }
}
