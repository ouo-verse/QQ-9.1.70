package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader;
import com.tencent.mobileqq.filemanager.core.a;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class DiscPicThumbDownloader extends com.tencent.mobileqq.filemanager.core.a {

    /* renamed from: c, reason: collision with root package name */
    private SparseArray<String> f207310c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.app.d f207311d;

    /* loaded from: classes12.dex */
    class a extends com.tencent.mobileqq.filemanager.app.d {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.d
        protected void a(boolean z16, long j3, String str, String str2, String str3, int i3, String str4, String str5, int i16, long j16, Bundle bundle) {
            QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j16 + "] OnDiscDownloadInfo");
            DiscPicThumbDownloader.this.x(z16, j3, str, str3, i3, str4, str5, i16, j16, bundle);
        }

        @Override // com.tencent.mobileqq.filemanager.app.d
        protected void j(boolean z16, long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z17, String str3, short s16, String str4, List<String> list, int i3, String str5, String str6, String str7, long j16, Bundle bundle) {
            QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j16 + "] OnDiscDownloadInfo");
            DiscPicThumbDownloader.this.y(j3, str, str2, byteStringMicro, z17, str3, s16, str4, str6, j16, bundle);
        }
    }

    /* loaded from: classes12.dex */
    public static class b extends a.C7549a {

        /* renamed from: c, reason: collision with root package name */
        int f207317c;

        /* renamed from: d, reason: collision with root package name */
        String f207318d;

        /* renamed from: e, reason: collision with root package name */
        long f207319e;

        public b(FileManagerEntity fileManagerEntity) {
            super(fileManagerEntity);
        }
    }

    public DiscPicThumbDownloader(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f207310c = new SparseArray<>();
        this.f207311d = new a();
        z();
    }

    private void v(int i3, b bVar, ThumbHttpDownloader.a aVar) {
        int i16;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "respose null";
        switch (i3) {
            case -11:
            case -6:
            case -5:
            case -4:
                HttpMsg httpMsg = aVar.f207626s;
                if (httpMsg != null) {
                    i16 = httpMsg.errCode;
                } else {
                    i16 = 0;
                }
                if (httpMsg != null) {
                    str = httpMsg.getErrorString();
                } else {
                    str = "http resp err";
                }
                QQAppInterface qQAppInterface = this.f207631a;
                FileManagerEntity fileManagerEntity = bVar.f207634b;
                long j3 = fileManagerEntity.nSessionId;
                long j16 = bVar.f207319e;
                String str8 = aVar.f207609b;
                String str9 = fileManagerEntity.peerUin;
                String str10 = fileManagerEntity.Uuid;
                String str11 = fileManagerEntity.strFileMd5;
                long j17 = i16;
                String str12 = str;
                long j18 = aVar.f207627t;
                long j19 = aVar.f207617j;
                long j26 = aVar.f207618k;
                HttpMsg httpMsg2 = aVar.f207626s;
                if (httpMsg2 == null) {
                    str2 = "respose null";
                } else {
                    str2 = httpMsg2.rawRespHeader;
                }
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, j3, "actFileDiscThumb", j16, str8, str9, str10, str11, j17, str12, j18, j19, j26, str8, str2, aVar.f207619l, str12, "");
                QQAppInterface qQAppInterface2 = this.f207631a;
                FileManagerEntity fileManagerEntity2 = bVar.f207634b;
                long j27 = fileManagerEntity2.nSessionId;
                long j28 = bVar.f207319e;
                String str13 = aVar.f207609b;
                String str14 = fileManagerEntity2.peerUin;
                String str15 = fileManagerEntity2.Uuid;
                String str16 = fileManagerEntity2.strFileMd5;
                long j29 = aVar.f207627t;
                long j36 = aVar.f207617j;
                long j37 = aVar.f207618k;
                HttpMsg httpMsg3 = aVar.f207626s;
                if (httpMsg3 == null) {
                    str3 = "respose null";
                } else {
                    str3 = httpMsg3.rawRespHeader;
                }
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, j27, "actFileDiscThumbDetail", j28, str13, str14, str15, str16, j17, str12, j29, j36, j37, str13, str3, aVar.f207621n, str12, "");
                bVar.f207634b.thumbInvalidCode = 2;
                return;
            case -10:
                FileManagerEntity fileManagerEntity3 = bVar.f207634b;
                if (fileManagerEntity3 != null) {
                    fileManagerEntity3.thumbInvalidCode = 1;
                    return;
                }
                return;
            case -9:
                QQAppInterface qQAppInterface3 = this.f207631a;
                FileManagerEntity fileManagerEntity4 = bVar.f207634b;
                long j38 = fileManagerEntity4.nSessionId;
                long j39 = bVar.f207319e;
                String str17 = aVar.f207609b;
                String str18 = fileManagerEntity4.peerUin;
                String str19 = fileManagerEntity4.Uuid;
                String str20 = fileManagerEntity4.strFileMd5;
                long j46 = aVar.f207627t;
                long j47 = aVar.f207617j;
                long j48 = aVar.f207618k;
                HttpMsg httpMsg4 = aVar.f207626s;
                if (httpMsg4 == null) {
                    str4 = "respose null";
                } else {
                    str4 = httpMsg4.rawRespHeader;
                }
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface3, j38, "actFileDiscThumb", j39, str17, str18, str19, str20, 9003L, "rename error", j46, j47, j48, str17, str4, aVar.f207619l, "rename error", "");
                QQAppInterface qQAppInterface4 = this.f207631a;
                FileManagerEntity fileManagerEntity5 = bVar.f207634b;
                long j49 = fileManagerEntity5.nSessionId;
                long j56 = bVar.f207319e;
                String str21 = aVar.f207609b;
                String str22 = fileManagerEntity5.peerUin;
                String str23 = fileManagerEntity5.Uuid;
                String str24 = fileManagerEntity5.strFileMd5;
                long j57 = aVar.f207627t;
                long j58 = aVar.f207617j;
                long j59 = aVar.f207618k;
                HttpMsg httpMsg5 = aVar.f207626s;
                if (httpMsg5 != null) {
                    str7 = httpMsg5.rawRespHeader;
                }
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface4, j49, "actFileDiscThumbDetail", j56, str21, str22, str23, str24, 9003L, "rename error", j57, j58, j59, str21, str7, aVar.f207621n, "rename error", "");
                return;
            case -8:
                QQAppInterface qQAppInterface5 = this.f207631a;
                FileManagerEntity fileManagerEntity6 = bVar.f207634b;
                long j65 = fileManagerEntity6.nSessionId;
                long j66 = bVar.f207319e;
                String str25 = aVar.f207609b;
                String str26 = fileManagerEntity6.peerUin;
                String str27 = fileManagerEntity6.Uuid;
                String str28 = fileManagerEntity6.strFileMd5;
                long j67 = aVar.f207617j;
                long j68 = aVar.f207618k;
                HttpMsg httpMsg6 = aVar.f207626s;
                if (httpMsg6 == null) {
                    str5 = "respose null";
                } else {
                    str5 = httpMsg6.rawRespHeader;
                }
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface5, j65, "actFileDiscThumb", j66, str25, str26, str27, str28, 9003L, "revStream write Exception", 0L, j67, j68, str25, str5, aVar.f207619l, "revStream write Exception", "");
                QQAppInterface qQAppInterface6 = this.f207631a;
                FileManagerEntity fileManagerEntity7 = bVar.f207634b;
                long j69 = fileManagerEntity7.nSessionId;
                long j75 = bVar.f207319e;
                String str29 = aVar.f207609b;
                String str30 = fileManagerEntity7.peerUin;
                String str31 = fileManagerEntity7.Uuid;
                String str32 = fileManagerEntity7.strFileMd5;
                long j76 = aVar.f207617j;
                long j77 = aVar.f207618k;
                HttpMsg httpMsg7 = aVar.f207626s;
                if (httpMsg7 != null) {
                    str7 = httpMsg7.rawRespHeader;
                }
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface6, j69, "actFileDiscThumbDetail", j75, str29, str30, str31, str32, 9003L, "revStream write Exception", 0L, j76, j77, str29, str7, aVar.f207621n, "revStream write Exception", "");
                return;
            case -7:
                QQAppInterface qQAppInterface7 = this.f207631a;
                FileManagerEntity fileManagerEntity8 = bVar.f207634b;
                long j78 = fileManagerEntity8.nSessionId;
                long j79 = bVar.f207319e;
                String str33 = aVar.f207609b;
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface7, j78, "actFileDiscThumb", j79, str33, fileManagerEntity8.peerUin, fileManagerEntity8.Uuid, fileManagerEntity8.strFileMd5, 9005L, "noRs", 0L, 0L, 0L, str33, "", 0, "noRs", "");
                QQAppInterface qQAppInterface8 = this.f207631a;
                FileManagerEntity fileManagerEntity9 = bVar.f207634b;
                long j85 = fileManagerEntity9.nSessionId;
                long j86 = bVar.f207319e;
                String str34 = aVar.f207609b;
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface8, j85, "actFileDiscThumbDetail", j86, str34, fileManagerEntity9.peerUin, fileManagerEntity9.Uuid, fileManagerEntity9.strFileMd5, 9005L, "noRs", aVar.f207627t, aVar.f207617j, aVar.f207618k, str34, "", 0, "noRs", "");
                return;
            case -3:
                QQAppInterface qQAppInterface9 = this.f207631a;
                FileManagerEntity fileManagerEntity10 = bVar.f207634b;
                long j87 = fileManagerEntity10.nSessionId;
                long j88 = bVar.f207319e;
                String str35 = aVar.f207609b;
                String str36 = fileManagerEntity10.peerUin;
                String str37 = fileManagerEntity10.Uuid;
                String str38 = fileManagerEntity10.strFileMd5;
                long j89 = aVar.f207627t;
                long j95 = aVar.f207617j;
                long j96 = bVar.f207317c;
                HttpMsg httpMsg8 = aVar.f207626s;
                if (httpMsg8 == null) {
                    str6 = "respose null";
                } else {
                    str6 = httpMsg8.rawRespHeader;
                }
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface9, j87, "actFileDiscThumb", j88, str35, str36, str37, str38, 9004L, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, j89, j95, j96, str35, str6, aVar.f207619l, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, "");
                QQAppInterface qQAppInterface10 = this.f207631a;
                FileManagerEntity fileManagerEntity11 = bVar.f207634b;
                long j97 = fileManagerEntity11.nSessionId;
                long j98 = bVar.f207319e;
                String str39 = aVar.f207609b;
                String str40 = fileManagerEntity11.peerUin;
                String str41 = fileManagerEntity11.Uuid;
                String str42 = fileManagerEntity11.strFileMd5;
                long j99 = aVar.f207627t;
                long j100 = aVar.f207617j;
                long j101 = bVar.f207317c;
                HttpMsg httpMsg9 = aVar.f207626s;
                if (httpMsg9 != null) {
                    str7 = httpMsg9.rawRespHeader;
                }
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface10, j97, "actFileDiscThumbDetail", j98, str39, str40, str41, str42, 9004L, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, j99, j100, j101, str39, str7, aVar.f207621n, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, "");
                return;
            case -2:
                QQAppInterface qQAppInterface11 = this.f207631a;
                FileManagerEntity fileManagerEntity12 = bVar.f207634b;
                long j102 = fileManagerEntity12.nSessionId;
                long j103 = bVar.f207319e;
                String str43 = aVar.f207609b;
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface11, j102, "actFileDiscThumb", j103, str43, fileManagerEntity12.peerUin, fileManagerEntity12.Uuid, fileManagerEntity12.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, str43, "", 0, "FileNotFoundException", "");
                QQAppInterface qQAppInterface12 = this.f207631a;
                FileManagerEntity fileManagerEntity13 = bVar.f207634b;
                long j104 = fileManagerEntity13.nSessionId;
                long j105 = bVar.f207319e;
                String str44 = aVar.f207609b;
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface12, j104, "actFileDiscThumbDetail", j105, str44, fileManagerEntity13.peerUin, fileManagerEntity13.Uuid, fileManagerEntity13.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, str44, "", 0, "size error", "");
                return;
            default:
                return;
        }
    }

    private void w(final b bVar, String str, ThumbHttpDownloader.a aVar) {
        DiscPicThumbDownloader discPicThumbDownloader;
        QQAppInterface qQAppInterface = this.f207631a;
        long j3 = bVar.f207634b.nSessionId;
        long currentTimeMillis = System.currentTimeMillis() - bVar.f207319e;
        String str2 = aVar.f207609b;
        FileManagerEntity fileManagerEntity = bVar.f207634b;
        FileManagerUtil.reportFilemanagerSuccessInfo(qQAppInterface, j3, "actFileDiscThumb", currentTimeMillis, str2, fileManagerEntity.peerUin, fileManagerEntity.Uuid, fileManagerEntity.strFileMd5, aVar.f207627t, aVar.f207617j, aVar.f207618k, aVar.f207619l, null);
        int i3 = bVar.f207317c;
        if (i3 == 7) {
            FileManagerEntity fileManagerEntity2 = bVar.f207634b;
            fileManagerEntity2.strLargeThumPath = str;
            FileManagerUtil.fixEntityThumbSize(fileManagerEntity2);
            discPicThumbDownloader = this;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.3
                @Override // java.lang.Runnable
                public void run() {
                    FilePicURLDrawlableHelper.k(bVar.f207634b);
                }
            }, 8, null, false);
        } else {
            discPicThumbDownloader = this;
            if (i3 == 5) {
                FileManagerEntity fileManagerEntity3 = bVar.f207634b;
                fileManagerEntity3.strMiddleThumPath = str;
                FileManagerUtil.fixEntityThumbSize(fileManagerEntity3);
                if (FilePicURLDrawlableHelper.t(bVar.f207634b)) {
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.4
                        @Override // java.lang.Runnable
                        public void run() {
                            FilePicURLDrawlableHelper.l(bVar.f207634b);
                        }
                    }, 8, null, false);
                }
            } else {
                bVar.f207634b.strThumbPath = str;
            }
        }
        discPicThumbDownloader.f207631a.getFileManagerDataCenter().f0(bVar.f207634b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y(long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z16, String str3, short s16, String str4, String str5, long j16, Bundle bundle) {
        String str6;
        boolean z17;
        short s17;
        String str7;
        String str8;
        ArrayList<String> arrayList;
        Bundle bundle2;
        if (z16) {
            str6 = str4 + "&isthumb=1";
        } else {
            str6 = str4;
        }
        b u16 = u(j16, false);
        if (u16 == null) {
            QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "onUpdateGetOfflineDownloadInfo, mapDowload is not existed taskid[" + String.valueOf(j16) + "]");
            o(j16, false, null, 0, null, null, str2, false, null, (short) 0, null);
            return;
        }
        if (TextUtils.isEmpty(u16.f207634b.strFileMd5) && !TextUtils.isEmpty(str5)) {
            u16.f207634b.strFileMd5 = str5;
        }
        FileManagerUtil.checkFileExisted(u16.f207634b, this.f207631a, null);
        if (j3 != 0) {
            QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j16 + "] OnDiscDownloadInfo isSuccess[false],retCode[" + String.valueOf(j3) + "],retMsg[" + String.valueOf(str) + "]");
            if (j3 != -100001 && (j3 == -25081 || j3 == -6101 || j3 == -7003)) {
                u16.f207634b.status = 16;
                this.f207631a.getFileManagerDataCenter().f0(u16.f207634b);
            }
            this.f207631a.getFileManagerNotifyCenter().b(false, 51, new Object[]{u16.f207634b, Integer.valueOf(u16.f207317c)});
            q(j16);
            o(j16, false, null, 0, null, null, str2, false, null, (short) 0, null);
            return;
        }
        if (str3 != null && byteStringMicro != null) {
            if (TextUtils.isEmpty(u16.f207634b.strFileMd5) && !TextUtils.isEmpty(str5)) {
                u16.f207634b.strFileMd5 = str5;
            }
            String str9 = this.f207310c.get(u16.f207317c, "");
            if (TextUtils.isEmpty(str9)) {
                QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j16 + "] unknow thumbSize!!!info:" + u16.toString());
                this.f207631a.getFileManagerNotifyCenter().b(false, 51, new Object[]{u16.f207634b, Integer.valueOf(u16.f207317c)});
                q(j16);
                o(j16, false, str3, s16, str6, null, str2, false, null, (short) 0, null);
                return;
            }
            String str10 = str6 + str9;
            if (((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsThumb4C2C(this.f207631a) && bundle != null) {
                String string = bundle.getString("strHttpsDomain");
                if (!TextUtils.isEmpty(string)) {
                    short s18 = bundle.getShort("httpsPort", (short) 0);
                    if (s18 == 0) {
                        s18 = 443;
                    }
                    str7 = string;
                    z17 = true;
                    s17 = s18;
                    if (bundle != null) {
                        str8 = "";
                        arrayList = null;
                    } else {
                        String string2 = bundle.getString("IPv6Dns");
                        arrayList = bundle.getStringArrayList("ipv6list");
                        str8 = string2;
                    }
                    bundle2 = new Bundle();
                    bundle2.putBoolean("usemediaplatform", z16);
                    if (arrayList != null && arrayList.size() > 0) {
                        bundle2.putStringArrayList("ipv6list", arrayList);
                    }
                    p(j16, true, str3, s16, str10, null, str2, z17, str7, s17, str8, bundle2);
                    return;
                }
            }
            z17 = false;
            s17 = 0;
            str7 = null;
            if (bundle != null) {
            }
            bundle2 = new Bundle();
            bundle2.putBoolean("usemediaplatform", z16);
            if (arrayList != null) {
                bundle2.putStringArrayList("ipv6list", arrayList);
            }
            p(j16, true, str3, s16, str10, null, str2, z17, str7, s17, str8, bundle2);
            return;
        }
        QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j16 + "]  get DiscdownLoad info Url is null ");
        if (j3 == -25081 || j3 == -6101 || j3 == -7003) {
            u16.f207634b.status = 16;
            this.f207631a.getFileManagerDataCenter().f0(u16.f207634b);
        }
        q(j16);
        o(j16, false, null, 0, null, null, str2, false, null, (short) 0, null);
    }

    private void z() {
        this.f207310c.put(0, "?pictype=scaled&size=16*16");
        this.f207310c.put(1, "?pictype=scaled&size=32*32");
        this.f207310c.put(2, "?pictype=scaled&size=64*64");
        this.f207310c.put(3, "?pictype=scaled&size=128*128");
        this.f207310c.put(4, "?pictype=scaled&size=320*320");
        this.f207310c.put(5, "?pictype=scaled&size=384*384");
        this.f207310c.put(6, "?pictype=scaled&size=640*640");
        this.f207310c.put(7, "?pictype=scaled&size=750*750");
        this.f207310c.put(8, "?pictype=scaled&size=1024*1024");
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public boolean b(long j3, ThumbHttpDownloader.a aVar) {
        b u16 = u(j3, false);
        if (u16 == null) {
            QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onGetDownloadUrl no this session");
            return false;
        }
        if (u16.f207634b.peerType == 3000) {
            FileTransferHandler fileTransferHandler = this.f207631a.getFileTransferHandler();
            FileManagerEntity fileManagerEntity = u16.f207634b;
            fileTransferHandler.F(j3, fileManagerEntity.fileName, Long.parseLong(fileManagerEntity.peerUin), u16.f207634b.Uuid, this.f207311d);
            return true;
        }
        FileTransferHandler fileTransferHandler2 = this.f207631a.getFileTransferHandler();
        FileManagerEntity fileManagerEntity2 = u16.f207634b;
        fileTransferHandler2.D(j3, fileManagerEntity2.Uuid, fileManagerEntity2.fileIdCrc, fileManagerEntity2.bSend, this.f207311d);
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.core.a, com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void c(long j3, boolean z16, int i3, String str, ThumbHttpDownloader.a aVar) {
        b u16 = u(j3, false);
        if (u16 == null) {
            QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onDownloadCompleted no this session");
            return;
        }
        if (z16) {
            w(u16, str, aVar);
        } else {
            v(i3, u16, aVar);
        }
        this.f207631a.getFileManagerNotifyCenter().b(z16, 50, new Object[]{u16.f207634b, Integer.valueOf(u16.f207317c)});
        super.c(j3, z16, i3, str, aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void d(long j3, ThumbHttpDownloader.a aVar) {
        String str;
        String str2;
        int i3 = 0;
        b u16 = u(j3, false);
        if (u16 == null) {
            QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onDownloadCompleted no this session");
            return;
        }
        HttpMsg httpMsg = aVar.f207626s;
        if (httpMsg != null) {
            i3 = httpMsg.errCode;
        }
        if (httpMsg != null) {
            str = httpMsg.getErrorString();
        } else {
            str = "start retry";
        }
        String str3 = str;
        QQAppInterface qQAppInterface = this.f207631a;
        FileManagerEntity fileManagerEntity = u16.f207634b;
        long j16 = fileManagerEntity.nSessionId;
        long j17 = u16.f207319e;
        String str4 = aVar.f207609b;
        String str5 = fileManagerEntity.peerUin;
        String str6 = fileManagerEntity.Uuid;
        String str7 = fileManagerEntity.strFileMd5;
        long j18 = i3;
        long j19 = aVar.f207627t;
        long j26 = aVar.f207617j;
        long j27 = aVar.f207618k;
        HttpMsg httpMsg2 = aVar.f207626s;
        if (httpMsg2 != null) {
            str2 = httpMsg2.rawRespHeader;
        } else {
            str2 = "respose null";
        }
        FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, j16, "actFileDiscThumbDetail", j17, str4, str5, str6, str7, j18, str3, j19, j26, j27, str4, str2, aVar.f207621n, str3, "");
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void e(long j3, HttpMsg httpMsg) {
        b u16 = u(j3, false);
        if (u16 == null) {
            QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onSetHttpMsg no this session");
            return;
        }
        httpMsg.busiType = 3000;
        httpMsg.setRequestProperty("Cookie", u16.f207318d);
    }

    @Override // com.tencent.mobileqq.filemanager.core.a, com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void f(long j3, int i3, ThumbHttpDownloader.a aVar) {
        b u16 = u(j3, false);
        if (u16 == null) {
            QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onDownloadCompleted no this session");
            return;
        }
        this.f207631a.getFileManagerNotifyCenter().b(true, 52, new Object[]{u16.f207634b, Integer.valueOf(i3)});
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public List<String> g(long j3, String str, int i3, boolean z16, List<String> list) {
        FileManagerEntity fileManagerEntity;
        int i16;
        b u16 = u(j3, false);
        if (u16 != null && (fileManagerEntity = u16.f207634b) != null) {
            if (fileManagerEntity.peerType == 3000) {
                i16 = 5;
            } else {
                i16 = 1;
            }
            if (!d.c().isConfigEnableIPV6(this.f207631a, i16)) {
                return null;
            }
            if (z16 && list != null && list.size() > 0) {
                QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] [IPv6-File] image thumb mediaplatform. is config enable IPv6. v6ipsize[" + list.size() + "] busiType:" + i16);
                List<String> iPV6listForMediaPlatfrom = d.c().getIPV6listForMediaPlatfrom(this.f207631a, i16, list);
                if (iPV6listForMediaPlatfrom != null && iPV6listForMediaPlatfrom.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    int size = iPV6listForMediaPlatfrom.size();
                    for (int i17 = 0; i17 < size; i17++) {
                        String str2 = iPV6listForMediaPlatfrom.get(i17);
                        if (!TextUtils.isEmpty(str2)) {
                            arrayList.add(0, "[" + str2 + "]:" + i3);
                        }
                    }
                    QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] [IPv6-File] image thumb mediaplatform. use IPv6. hostlist:" + arrayList.toString());
                    return arrayList;
                }
                QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] [IPv6-File] image thumb mediaplatform. use IPv4:");
            } else if (!TextUtils.isEmpty(str)) {
                QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] [IPv6-File] image thumb. is config enable IPv6. domain[" + str + "] busiType:" + i16);
                d.c iPlistForV6Domain = d.c().getIPlistForV6Domain(this.f207631a, new d.a(str, i3), i16);
                if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                    ArrayList arrayList2 = new ArrayList();
                    for (d.b bVar : iPlistForV6Domain.f207644b) {
                        arrayList2.add(bVar.f207641a + ":" + bVar.f207642b);
                    }
                    QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] [IPv6-File] image thumb. use IPv6. hostlist:" + arrayList2.toString());
                    return arrayList2;
                }
                QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] [IPv6-File] image thumb. use IPv4:");
            }
        }
        return null;
    }

    public String s(final FileManagerEntity fileManagerEntity, int i3) {
        if (TextUtils.isEmpty(fileManagerEntity.Uuid)) {
            QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + fileManagerEntity.nSessionId + "]");
            this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{fileManagerEntity, Integer.valueOf(i3)});
            return null;
        }
        j();
        if (TextUtils.isEmpty(fileManagerEntity.Uuid) && QLog.isDevelopLevel()) {
            throw new NullPointerException("uuid is null!!!");
        }
        String str = lc1.b.a().getDefaultThumbPath() + t(i3, com.tencent.securitysdk.utils.c.b(fileManagerEntity.Uuid));
        if (!q.f(str) && !TextUtils.isEmpty(fileManagerEntity.strFileMd5)) {
            str = lc1.b.a().getDefaultThumbPath() + t(i3, com.tencent.securitysdk.utils.c.b(fileManagerEntity.strFileMd5));
        }
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            if (i3 == 7) {
                fileManagerEntity.strLargeThumPath = str;
                if (FilePicURLDrawlableHelper.t(fileManagerEntity)) {
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FilePicURLDrawlableHelper.k(fileManagerEntity);
                        }
                    }, 8, null, false);
                }
            } else if (i3 == 5) {
                fileManagerEntity.strMiddleThumPath = str;
                if (FilePicURLDrawlableHelper.t(fileManagerEntity)) {
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FilePicURLDrawlableHelper.l(fileManagerEntity);
                        }
                    }, 8, null, false);
                }
            } else {
                fileManagerEntity.strThumbPath = str;
            }
            this.f207631a.getFileManagerDataCenter().f0(fileManagerEntity);
            this.f207631a.getFileManagerNotifyCenter().b(true, 50, new Object[]{fileManagerEntity, Integer.valueOf(i3)});
            QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + fileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
            FileManagerUtil.reportFilemanagerSuccessInfo(this.f207631a, fileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", fileManagerEntity.peerUin, fileManagerEntity.Uuid, fileManagerEntity.strFileMd5, 0L, 0L, 0L, 0, null);
            return str;
        }
        b bVar = new b(fileManagerEntity);
        bVar.f207317c = i3;
        i(bVar, str, true);
        QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + fileManagerEntity.nSessionId + "], ThumbDownloadId[" + bVar.f207633a + "]");
        return null;
    }

    protected String t(int i3, String str) {
        String str2;
        switch (i3) {
            case 0:
                str2 = "micro-dsc-";
                break;
            case 1:
                str2 = "minni-dsc-";
                break;
            case 2:
                str2 = "small-dsc-";
                break;
            case 3:
                str2 = "middle-dsc-";
                break;
            case 4:
                str2 = "large-dsc-";
                break;
            case 5:
                str2 = "qlarge-dsc-";
                break;
            case 6:
                str2 = "xlarge-dsc-";
                break;
            case 7:
                str2 = "qxlarge-dsc-";
                break;
            case 8:
                str2 = "screen-dsc-";
                break;
            default:
                str2 = "x-dsc-";
                break;
        }
        return str2 + str;
    }

    protected b u(long j3, boolean z16) {
        a.C7549a k3 = k(j3);
        if (k3 == null) {
            return null;
        }
        if (k3 instanceof b) {
            return (b) k3;
        }
        QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + j3 + "] no instance");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x032f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void x(boolean z16, long j3, String str, String str2, int i3, String str3, String str4, int i16, long j16, Bundle bundle) {
        String str5;
        short s16;
        long j17;
        b u16 = u(j16, false);
        if (u16 == null) {
            QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "OnDiscDownloadInfo, mapDowload is not existed taskid[" + String.valueOf(j16) + "]");
            FileManagerUtil.reportFilemanagerFaildInfo(this.f207631a, 0L, "actFileDiscThumb", 0L, "", "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
            FileManagerUtil.reportFilemanagerFaildInfo(this.f207631a, 0L, "actFileDiscThumbDetail", 0L, "", "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
            o(j16, false, null, 0, null, null, str4, false, null, (short) 0, null);
            return;
        }
        boolean z17 = true;
        if (!z16) {
            QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j16 + "] OnDiscDownloadInfo isSuccess[false],retCode[" + String.valueOf(j3) + "],retMsg[" + String.valueOf(str) + "]");
            if (j3 == -100001) {
                j17 = 9043;
            } else if (j3 == -25081 || j3 == -6101 || j3 == -7003) {
                u16.f207634b.status = 16;
                this.f207631a.getFileManagerDataCenter().f0(u16.f207634b);
                j17 = 0;
            } else {
                j17 = 9045;
            }
            QQAppInterface qQAppInterface = this.f207631a;
            FileManagerEntity fileManagerEntity = u16.f207634b;
            long j18 = j17;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity.nSessionId, "actFileDiscThumb", u16.f207319e, "", fileManagerEntity.peerUin, fileManagerEntity.Uuid, fileManagerEntity.strFileMd5, j18, String.valueOf(i16) + ContainerUtils.FIELD_DELIMITER + String.valueOf(j3), 0L, 0L, 0L, "", "", 0, "ret error", null);
            QQAppInterface qQAppInterface2 = this.f207631a;
            FileManagerEntity fileManagerEntity2 = u16.f207634b;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, fileManagerEntity2.nSessionId, "actFileDiscThumbDetail", u16.f207319e, "", fileManagerEntity2.peerUin, fileManagerEntity2.Uuid, fileManagerEntity2.strFileMd5, j18, String.valueOf(i16) + ContainerUtils.FIELD_DELIMITER + String.valueOf(j3), 0L, 0L, 0L, "", "", 0, "ret error", null);
            this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{u16.f207634b, Integer.valueOf(u16.f207317c)});
            q(j16);
            o(j16, false, null, 0, null, null, str4, false, null, (short) 0, null);
            return;
        }
        u16.f207318d = str4;
        String str6 = this.f207310c.get(u16.f207317c, "");
        if (TextUtils.isEmpty(str6)) {
            String str7 = "http://" + str2 + ":" + String.valueOf(i3) + "/ftn_handler/" + str3;
            QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j16 + "] unknow thumbSize!!!info:" + u16.toString());
            this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{u16.f207634b, Integer.valueOf(u16.f207317c)});
            QQAppInterface qQAppInterface3 = this.f207631a;
            FileManagerEntity fileManagerEntity3 = u16.f207634b;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface3, fileManagerEntity3.nSessionId, "actFileDiscThumb", u16.f207319e, str7, fileManagerEntity3.peerUin, fileManagerEntity3.Uuid, fileManagerEntity3.strFileMd5, 9005L, "size error", 0L, 0L, 0L, str7, "", 0, "size error", "");
            QQAppInterface qQAppInterface4 = this.f207631a;
            FileManagerEntity fileManagerEntity4 = u16.f207634b;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface4, fileManagerEntity4.nSessionId, "actFileDiscThumbDetail", u16.f207319e, str7, fileManagerEntity4.peerUin, fileManagerEntity4.Uuid, fileManagerEntity4.strFileMd5, 9005L, "size error", 0L, 0L, 0L, str7, "", 0, "size error", "");
            q(j16);
            o(j16, false, str2, i3, "/ftn_handler/" + str3, null, str4, false, null, (short) 0, null);
            return;
        }
        String str8 = "/ftn_handler/" + str3 + str6;
        if (((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsThumb4Disc(this.f207631a) && bundle != null) {
            String string = bundle.getString("strHttpsDomain");
            if (!TextUtils.isEmpty(string)) {
                short s17 = bundle.getShort("httpsPort", (short) 0);
                if (s17 == 0) {
                    s17 = 443;
                }
                str5 = string;
                s16 = s17;
                o(j16, true, str2, i3, str8, null, str4, z17, str5, s16, bundle != null ? bundle.getString("IPv6Dns") : "");
            }
        }
        str5 = null;
        z17 = false;
        s16 = 0;
        o(j16, true, str2, i3, str8, null, str4, z17, str5, s16, bundle != null ? bundle.getString("IPv6Dns") : "");
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void a(long j3, ThumbHttpDownloader.a aVar) {
    }
}
