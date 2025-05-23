package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileVideoOnlinePlayerFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$DownloadFileRspBody;
import zb1.a;

/* loaded from: classes12.dex */
public class OnlineVideoPreviewUtil {

    /* renamed from: a, reason: collision with root package name */
    private String f209189a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f209190b = "";

    /* renamed from: c, reason: collision with root package name */
    private e.a f209191c = null;

    /* renamed from: d, reason: collision with root package name */
    private ef0.m f209192d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a extends ef0.m {
        a() {
        }

        @Override // ef0.m
        public void c(boolean z16, int i3, oidb_0x6d6$DownloadFileRspBody oidb_0x6d6_downloadfilerspbody, Bundle bundle) {
            if (OnlineVideoPreviewUtil.this.f209191c == null) {
                return;
            }
            if (oidb_0x6d6_downloadfilerspbody == null) {
                QLog.i("OnlineVideoPreviewUtil", 1, "requestOnlinePreviewDownloadUrl: error DownloadFileRspBody is null!");
                OnlineVideoPreviewUtil.this.f209191c.n();
                return;
            }
            long j3 = bundle.getLong("troopUin");
            TroopFileTransferManager N = TroopFileTransferManager.N(j3);
            if (N == null) {
                QLog.i("OnlineVideoPreviewUtil", 1, "requestOnlinePreviewDownloadUrl: error bad troopUin[" + j3 + "]");
                OnlineVideoPreviewUtil.this.f209191c.n();
                return;
            }
            String string = bundle.getString("itemKey");
            if (string == null) {
                OnlineVideoPreviewUtil.this.f209191c.n();
                return;
            }
            TroopFileTransferManager.Item J = N.J(UUID.fromString(string));
            if (J == null) {
                QLog.i("OnlineVideoPreviewUtil", 1, "requestOnlinePreviewDownloadUrl: error bad item key" + string + "]");
                OnlineVideoPreviewUtil.this.f209191c.n();
                return;
            }
            int i16 = oidb_0x6d6_downloadfilerspbody.int32_ret_code.get();
            if (QLog.isColorLevel()) {
                QLog.i("OnlineVideoPreviewUtil", 2, "requestOnlinePreviewDownloadUrl: onRspDownload - retCode[" + i16 + "]");
            }
            OnlineVideoPreviewUtil onlineVideoPreviewUtil = OnlineVideoPreviewUtil.this;
            if (onlineVideoPreviewUtil.i(i16, onlineVideoPreviewUtil.f209191c)) {
                return;
            }
            String bytes2HexStr = HexUtil.bytes2HexStr(oidb_0x6d6_downloadfilerspbody.bytes_cookie_val.get().toByteArray());
            J.cookieValue = bytes2HexStr;
            if (bytes2HexStr != null) {
                J.cookieValue = bytes2HexStr.toLowerCase();
            }
            J.DownloadIp = oidb_0x6d6_downloadfilerspbody.str_download_ip.get();
            J.DownloadUrl = HexUtil.bytes2HexStr(oidb_0x6d6_downloadfilerspbody.bytes_download_url.get().toByteArray());
            J.Md5 = oidb_0x6d6_downloadfilerspbody.bytes_md5.get().toByteArray();
            J.NameForSave = oidb_0x6d6_downloadfilerspbody.str_save_file_name.get();
            String str = new String(oidb_0x6d6_downloadfilerspbody.str_download_dns.get().toByteArray());
            if (OnlineVideoPreviewUtil.this.k()) {
                str = J.DownloadIp;
            }
            String a16 = zb1.a.a(str, J.DownloadUrl, J.FilePath, J.cookieValue, "");
            if (!TextUtils.isEmpty(a16)) {
                OnlineVideoPreviewUtil.this.f209189a = a16;
                OnlineVideoPreviewUtil.this.f209190b = J.cookieValue;
                OnlineVideoPreviewUtil.this.f209191c.d();
                if (QLog.isColorLevel()) {
                    QLog.i("OnlineVideoPreviewUtil", 2, "requestOnlinePreviewDownloadUrl: url[" + a16 + "], cookies [" + J.cookieValue + "]");
                    return;
                }
                return;
            }
            OnlineVideoPreviewUtil.this.f209191c.n();
            if (QLog.isColorLevel()) {
                QLog.i("OnlineVideoPreviewUtil", 2, "requestOnlinePreviewDownloadUrl: url[" + a16 + "], cookies [" + J.cookieValue + "]");
            }
        }
    }

    private String h(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        return TroopFileUtils.n(qQAppInterface, fileManagerEntity).f294985s + "_" + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(int i3, e.a aVar) {
        if (i3 != -133 && i3 != -132 && i3 != -134) {
            if (i3 != -103 && i3 != -301) {
                return false;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("OnlineVideoPreviewUtil", 4, "file invalidate retCode = " + i3);
            }
            return true;
        }
        aVar.n();
        if (QLog.isDevelopLevel()) {
            QLog.i("OnlineVideoPreviewUtil", 4, "file invalidate retCode = " + i3);
        }
        return true;
    }

    private void j() {
        if (this.f209192d == null) {
            this.f209192d = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        if (NetConnInfoCenter.getActiveNetIpFamily(true) == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(e.a aVar, TroopInfo troopInfo, FileManagerEntity fileManagerEntity, int i3, int i16) {
        if (aVar != null) {
            if (i3 != 0) {
                aVar.m();
            } else {
                aVar.b();
            }
        }
        TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
        troopExtDBInfo.fileVideoIsWhite = i3;
        troopExtDBInfo.fileVideoReqInterval = System.currentTimeMillis() + (i16 * 1000);
        ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateTroopFileVideo(fileManagerEntity.TroopUin, i3, System.currentTimeMillis() + (i16 * 1000), "OnlineVideoPreviewUtil");
        if (QLog.isColorLevel()) {
            QLog.d("OnlineVideoPreviewUtil", 2, "OfflineVideoFileView initVarView() is_white = " + i3 + ", req_interval = " + i16);
        }
    }

    public void m(final FileManagerEntity fileManagerEntity, final e.a aVar) {
        if (fileManagerEntity == null) {
            return;
        }
        this.f209191c = aVar;
        j();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.OnlineVideoPreviewUtil.1
            @Override // java.lang.Runnable
            public void run() {
                TroopFileTransferManager N = TroopFileTransferManager.N(fileManagerEntity.TroopUin);
                if (N == null) {
                    QLog.e("OnlineVideoPreviewUtil", 1, "requestOnlinePreviewDownloadUrl error: " + fileManagerEntity.TroopUin);
                    aVar.n();
                    return;
                }
                FileManagerEntity fileManagerEntity2 = fileManagerEntity;
                N.d0(fileManagerEntity2.strTroopFilePath, fileManagerEntity2.fileName, fileManagerEntity2.fileSize, fileManagerEntity2.busId, OnlineVideoPreviewUtil.this.f209192d);
            }
        }, 8, null, true);
    }

    public void n(QQAppInterface qQAppInterface, final FileManagerEntity fileManagerEntity, final e.a aVar) {
        ITroopInfoService iTroopInfoService;
        final TroopInfo findTroopInfo;
        if (qQAppInterface == null || fileManagerEntity == null || (iTroopInfoService = (ITroopInfoService) qQAppInterface.getRuntimeService(ITroopInfoService.class, "")) == null || (findTroopInfo = iTroopInfoService.findTroopInfo(String.valueOf(fileManagerEntity.TroopUin))) == null) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        TroopExtDBInfo troopExtDBInfo = findTroopInfo.extDBInfo;
        if (serverTimeMillis <= troopExtDBInfo.fileVideoReqInterval) {
            if (troopExtDBInfo.fileVideoIsWhite != 0) {
                if (aVar != null) {
                    aVar.m();
                }
            } else if (aVar != null) {
                aVar.b();
            }
        }
        zb1.a.b(qQAppInterface, fileManagerEntity.TroopUin, new a.b() { // from class: com.tencent.mobileqq.filemanager.util.aa
            @Override // zb1.a.b
            public final void a(int i3, int i16) {
                OnlineVideoPreviewUtil.l(e.a.this, findTroopInfo, fileManagerEntity, i3, i16);
            }
        });
    }

    public void o(Context context, QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        if (TextUtils.isEmpty(this.f209189a)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(QCircleSchemeAttr.Detail.FEED_VIDEO_ID, h(qQAppInterface, fileManagerEntity));
        intent.putExtra("url", this.f209189a);
        intent.putExtra("cookie", this.f209190b);
        intent.putExtra("public_fragment_window_feature", 1);
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivity.class, FileVideoOnlinePlayerFragment.class);
    }
}
