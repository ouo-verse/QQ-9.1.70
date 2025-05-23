package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import qb1.h;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQFileEngineImpl implements IQQFileEngine {
    public static final String TAG = "QQFileEngineImpl";
    QQAppInterface mApp;

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void clearNewDownload() {
        this.mApp.getFileManagerEngine().d();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void delAllSelectedFiles(boolean z16) {
        this.mApp.getFileManagerEngine().h(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public boolean delete(long j3) {
        return this.mApp.getFileManagerEngine().i(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void deleteOfflineFile(String str, String str2, String str3, String str4, boolean z16) {
        this.mApp.getFileManagerEngine().j(str, str2, str3, str4, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void deleteWeiYunFile(WeiYunFileInfo weiYunFileInfo) {
        this.mApp.getFileManagerEngine().k(weiYunFileInfo);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void downLoadAllSelectFiles(Context context) {
        this.mApp.getFileManagerEngine().l(context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void downLoadDiscThumb(FileManagerEntity fileManagerEntity, int i3) {
        this.mApp.getFileManagerEngine().m(fileManagerEntity, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public String downloadOfflineVideoThumb(FileManagerEntity fileManagerEntity) {
        return this.mApp.getFileManagerEngine().p(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void exitQlinkLocalFileBrowser() {
        this.mApp.getQQProxyForQlink().l();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void favProxyAddListener(IQQFavProxy.b bVar) {
        this.mApp.getFileManagerEngine().W().addListener(bVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void favProxyCancelGetFileList(long j3) {
        this.mApp.getFileManagerEngine().W().cancelGetFileList(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void favProxyDeleteListener(IQQFavProxy.b bVar) {
        this.mApp.getFileManagerEngine().W().deleteListener(bVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void favProxyGetFileList(long j3, boolean z16, Bundle bundle, IQQFavProxy.a aVar) {
        this.mApp.getFileManagerEngine().W().getFileList(j3, z16, bundle, aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public long favProxyGetGettedPartList(long j3, List<FavFileInfo> list) {
        return this.mApp.getFileManagerEngine().W().getGettedPartList(j3, list);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void favProxyRefreshList(Bundle bundle) {
        this.mApp.getFileManagerEngine().W().refreshList(bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void favProxydownloadThumb(FavFileInfo favFileInfo, int i3) {
        this.mApp.getFileManagerEngine().W().downloadThumb(favFileInfo, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public int getBigDataHostList(boolean z16, int i3, List<h> list) {
        List<ExcitingTransferHostInfo> bigDataHostList;
        if (list == null) {
            return -1;
        }
        IExcitingTransferAdapter iExcitingTransferAdapter = (IExcitingTransferAdapter) this.mApp.getRuntimeService(IExcitingTransferAdapter.class, "");
        int i16 = 1;
        if (z16) {
            QLog.i(TAG, 1, "[IPv6-File] exciting offlinefile upload. is config enable IPv6.");
            bigDataHostList = iExcitingTransferAdapter.getBigDataHostList(false);
            List<ExcitingTransferHostInfo> iPV6listForExcitingUpload = com.tencent.mobileqq.filemanager.core.d.c().getIPV6listForExcitingUpload(this.mApp, i3);
            if (iPV6listForExcitingUpload != null && iPV6listForExcitingUpload.size() > 0) {
                if (bigDataHostList == null) {
                    bigDataHostList = new ArrayList<>();
                }
                for (int size = iPV6listForExcitingUpload.size() - 1; size >= 0; size--) {
                    bigDataHostList.add(0, iPV6listForExcitingUpload.get(size));
                }
                QLog.i(TAG, 1, "[IPv6-File] exciting offlinefile upload. use IPv6. iplist:" + bigDataHostList.toString());
                i16 = 2;
            }
        } else {
            bigDataHostList = iExcitingTransferAdapter.getBigDataHostList(false);
        }
        if (bigDataHostList != null && bigDataHostList.size() > 0) {
            for (ExcitingTransferHostInfo excitingTransferHostInfo : bigDataHostList) {
                list.add(new h(excitingTransferHostInfo.mstrIp, excitingTransferHostInfo.mport));
            }
        }
        return i16;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public int getIPv6HostsFromDns(String str, int i3, int i16, List<String> list) {
        if (list == null) {
            return -1;
        }
        d.c iPlistForV6Domain = com.tencent.mobileqq.filemanager.core.d.c().getIPlistForV6Domain(this.mApp, new d.a(str, i3), i16);
        if (iPlistForV6Domain == null || iPlistForV6Domain.a()) {
            return -1;
        }
        for (d.b bVar : iPlistForV6Domain.f207644b) {
            if (i3 == 0) {
                list.add(bVar.f207641a);
            } else {
                list.add(bVar.f207641a + ":" + bVar.f207642b);
            }
        }
        return iPlistForV6Domain.f207643a;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public String getWeiYunPicThumb(String str, String str2, int i3, Object obj) {
        return this.mApp.getFileManagerEngine().Z(str, str2, i3, obj);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void getWeiYunPreview(String str, String str2) {
        this.mApp.getFileManagerEngine().a0(str, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public String getWeiYunVideoThumb(String str, String str2, int i3, WeiYunFileInfo weiYunFileInfo) {
        return this.mApp.getFileManagerEngine().b0(str, str2, i3, weiYunFileInfo);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public boolean hasQueriedVerifyPassword() {
        return this.mApp.getFileManagerEngine().d0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void initAppStoreSDK() {
        this.mApp.getFileManagerEngine().J().l();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public boolean isFileInUploaderQueue(String str) {
        return this.mApp.getFileManagerRSCenter().b(str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            this.mApp = (QQAppInterface) appRuntime;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void pause(long j3) {
        this.mApp.getFileManagerEngine().i0(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void pauseOnlineTrans(long j3) {
        this.mApp.getOnlineFileSessionCenter().u(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public FileManagerEntity queryFileEntityByFileId(String str) {
        return this.mApp.getFileManagerRSCenter().c(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void queryNeedVerifyPwd() {
        this.mApp.getFileManagerEngine().j0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void queryWeiyunFileList(int i3, String str, int i16, int i17, String str2) {
        this.mApp.getFileManagerEngine().k0(i3, str, i16, i17, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void reciveFile(FileManagerEntity fileManagerEntity) {
        this.mApp.getFileManagerEngine().t0(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void recvOnLineFile(long j3) {
        this.mApp.getOnlineFileSessionCenter().v(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void requestSendQlinkFile(Activity activity, ArrayList<String> arrayList, String str) {
        this.mApp.getQQProxyForQlink().D(activity, arrayList, 15, 0, true, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void resume(long j3) {
        this.mApp.getFileManagerEngine().o0(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void resumeOnlineTrans(long j3) {
        this.mApp.getOnlineFileSessionCenter().x(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void reviceFile(FileManagerEntity fileManagerEntity) {
        this.mApp.getFileManagerEngine().t0(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public ArrayList<FileManagerEntity> saveAllSelectFileToWeiYun() {
        return this.mApp.getFileManagerEngine().u0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void sendAllSelectedFiles(boolean z16, String str, String str2, String str3, int i3) {
        this.mApp.getFileManagerEngine().y0(z16, str, str2, str3, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileEngine
    public void verifyPwd(String str) {
        this.mApp.getFileManagerEngine().S0(str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
