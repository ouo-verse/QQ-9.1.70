package com.tencent.mobileqq.filemanager.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;
import qb1.h;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes12.dex */
public interface IQQFileEngine extends IRuntimeService {
    void clearNewDownload();

    void delAllSelectedFiles(boolean z16);

    boolean delete(long j3);

    void deleteOfflineFile(String str, String str2, String str3, String str4, boolean z16);

    void deleteWeiYunFile(WeiYunFileInfo weiYunFileInfo);

    void downLoadAllSelectFiles(Context context);

    void downLoadDiscThumb(FileManagerEntity fileManagerEntity, int i3);

    String downloadOfflineVideoThumb(FileManagerEntity fileManagerEntity);

    void exitQlinkLocalFileBrowser();

    void favProxyAddListener(IQQFavProxy.b bVar);

    void favProxyCancelGetFileList(long j3);

    void favProxyDeleteListener(IQQFavProxy.b bVar);

    void favProxyGetFileList(long j3, boolean z16, Bundle bundle, IQQFavProxy.a aVar);

    long favProxyGetGettedPartList(long j3, List<FavFileInfo> list);

    void favProxyRefreshList(Bundle bundle);

    void favProxydownloadThumb(FavFileInfo favFileInfo, int i3);

    int getBigDataHostList(boolean z16, int i3, List<h> list);

    int getIPv6HostsFromDns(String str, int i3, int i16, List<String> list);

    String getWeiYunPicThumb(String str, String str2, int i3, Object obj);

    void getWeiYunPreview(String str, String str2);

    String getWeiYunVideoThumb(String str, String str2, int i3, WeiYunFileInfo weiYunFileInfo);

    boolean hasQueriedVerifyPassword();

    void initAppStoreSDK();

    boolean isFileInUploaderQueue(String str);

    void pause(long j3);

    void pauseOnlineTrans(long j3);

    FileManagerEntity queryFileEntityByFileId(String str);

    void queryNeedVerifyPwd();

    void queryWeiyunFileList(int i3, String str, int i16, int i17, String str2);

    void reciveFile(FileManagerEntity fileManagerEntity);

    void recvOnLineFile(long j3);

    void requestSendQlinkFile(Activity activity, ArrayList<String> arrayList, String str);

    void resume(long j3);

    void resumeOnlineTrans(long j3);

    void reviceFile(FileManagerEntity fileManagerEntity);

    ArrayList<FileManagerEntity> saveAllSelectFileToWeiYun();

    void sendAllSelectedFiles(boolean z16, String str, String str2, String str3, int i3);

    void verifyPwd(String str);
}
