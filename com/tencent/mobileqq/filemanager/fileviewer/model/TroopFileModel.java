package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.troop.file.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.aio.utils.al;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.filemanager.api.IFileDataReporter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.b;
import com.tencent.mobileqq.filemanager.fileviewer.api.IFileReportApi;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.util.v;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.r;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.aio.locate.api.IMsgLocationApi;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetMultiMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.util.URLUtil;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import tencent.im.cs.group_file_common.group_file_common$FileInfo;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$DownloadFileRspBody;
import zb1.a;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TroopFileModel extends com.tencent.mobileqq.filemanager.fileviewer.model.b {
    private com.tencent.mobileqq.app.c Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f208357a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f208358b0;

    /* renamed from: c0, reason: collision with root package name */
    private FileBrowserModelBase.d f208359c0;

    /* renamed from: d0, reason: collision with root package name */
    private ef0.m f208360d0;

    /* renamed from: e0, reason: collision with root package name */
    private ef0.g f208361e0;

    /* renamed from: f0, reason: collision with root package name */
    private TroopFileError.d f208362f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f208363g0;

    /* renamed from: h0, reason: collision with root package name */
    private o f208364h0;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends ef0.g {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7569a implements a.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f208368a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f208369b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ short f208370c;

            C7569a(boolean z16, String str, short s16) {
                this.f208368a = z16;
                this.f208369b = str;
                this.f208370c = s16;
            }

            @Override // com.tencent.biz.troop.file.a.b
            public void a(List<ZipFilePresenter.f> list) {
                boolean z16 = true;
                QLog.d("TroopFileModel<FileAssistant>", 1, "loadZipPreviewFiles onGetZipFileList");
                TroopFileModel troopFileModel = TroopFileModel.this;
                FileBrowserModelBase.g gVar = troopFileModel.f208351m;
                if (gVar != null) {
                    gVar.g(list, troopFileModel.R, troopFileModel.S, troopFileModel.T, troopFileModel.U, this.f208368a, this.f208369b, this.f208370c);
                }
                IFileDataReporter iFileDataReporter = (IFileDataReporter) QRoute.api(IFileDataReporter.class);
                if (list == null || list.isEmpty()) {
                    z16 = false;
                }
                iFileDataReporter.reportZipPreviewListResult(z16);
            }
        }

        a() {
        }

        @Override // ef0.g
        public void c(boolean z16, int i3, String str, String str2, int i16, int i17, String str3, ByteStringMicro byteStringMicro, String str4, ByteStringMicro byteStringMicro2, Bundle bundle) {
            String str5;
            boolean z17 = true;
            QLog.d("TroopFileModel<FileAssistant>", 1, "loadZipPreviewFiles onGetFilePreviewResult");
            short s16 = 0;
            if (byteStringMicro == null) {
                ((IFileDataReporter) QRoute.api(IFileDataReporter.class)).reportZipPreviewListResult(false);
                FileBrowserModelBase.g gVar = TroopFileModel.this.f208351m;
                if (gVar != null) {
                    gVar.c(i3);
                    return;
                }
                return;
            }
            TroopFileModel.this.V = FileManagerUtil.binToHEX(byteStringMicro);
            if (z16 && !TextUtils.isEmpty(TroopFileModel.this.V)) {
                QLog.d("TroopFileModel<FileAssistant>", 1, "downURL:" + TroopFileModel.this.V);
                TroopFileModel troopFileModel = TroopFileModel.this;
                troopFileModel.R = str3;
                troopFileModel.S = "" + i17;
                TroopFileModel.this.T = FileManagerUtil.binToHEX(byteStringMicro);
                TroopFileModel troopFileModel2 = TroopFileModel.this;
                troopFileModel2.U = str4;
                troopFileModel2.T = FileManagerUtil.binToHEX(byteStringMicro);
                if (TroopFileUtils.u(TroopFileModel.this.N) && TroopFileUtils.v(TroopFileModel.this.N) && bundle != null) {
                    str5 = bundle.getString("strHttpsDomain");
                    if (!TextUtils.isEmpty(str5)) {
                        s16 = (short) bundle.getInt("httpsPort", 0);
                        if (s16 == 0) {
                            s16 = 443;
                        }
                        TroopFileModel troopFileModel3 = TroopFileModel.this;
                        com.tencent.biz.troop.file.a.k(TroopFileModel.this.N, str3, "" + i17, troopFileModel3.T, FileManagerUtil.chechZipFileType(troopFileModel3.Q.getEntity()), "/", str4, TroopFileModel.this.Q.getEntity(), new C7569a(z17, str5, s16));
                        return;
                    }
                }
                str5 = null;
                z17 = false;
                TroopFileModel troopFileModel32 = TroopFileModel.this;
                com.tencent.biz.troop.file.a.k(TroopFileModel.this.N, str3, "" + i17, troopFileModel32.T, FileManagerUtil.chechZipFileType(troopFileModel32.Q.getEntity()), "/", str4, TroopFileModel.this.Q.getEntity(), new C7569a(z17, str5, s16));
                return;
            }
            QLog.e("TroopFileModel<FileAssistant>", 1, "get preview url failed for troop, retCode[" + i3 + "], retMeg[" + str + "]");
            QQAppInterface qQAppInterface = TroopFileModel.this.N;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            sb5.append(TroopFileModel.this.Q.getEntity().TroopUin);
            ReportController.o(qQAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, sb5.toString(), "-1", FileManagerUtil.getFileSuffix(TroopFileModel.this.L()), "1");
            ((IFileDataReporter) QRoute.api(IFileDataReporter.class)).reportZipPreviewListResult(false);
            FileBrowserModelBase.g gVar2 = TroopFileModel.this.f208351m;
            if (gVar2 != null) {
                gVar2.c(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TroopFileModel troopFileModel = TroopFileModel.this;
            FileManagerUtil.openWithOtherApp(troopFileModel.f208346d, troopFileModel.N());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileBrowserModelBase.d f208375a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TroopInfo f208376b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208377c;

        d(FileBrowserModelBase.d dVar, TroopInfo troopInfo, FileManagerEntity fileManagerEntity) {
            this.f208375a = dVar;
            this.f208376b = troopInfo;
            this.f208377c = fileManagerEntity;
        }

        @Override // zb1.a.b
        public void a(int i3, int i16) {
            FileBrowserModelBase.d dVar = this.f208375a;
            if (dVar != null) {
                if (i3 != 0) {
                    dVar.n();
                } else {
                    dVar.b();
                }
            }
            if (i3 != 0) {
                FileBrowserModelBase.d dVar2 = this.f208375a;
                if (dVar2 != null) {
                    dVar2.n();
                }
                ReportController.o(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
            } else {
                FileBrowserModelBase.d dVar3 = this.f208375a;
                if (dVar3 != null) {
                    dVar3.b();
                }
                ReportController.o(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", "-1", "-1", "-1");
            }
            TroopExtDBInfo troopExtDBInfo = this.f208376b.extDBInfo;
            troopExtDBInfo.fileVideoIsWhite = i3;
            troopExtDBInfo.fileVideoReqInterval = System.currentTimeMillis() + (i16 * 1000);
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateTroopFileVideo(this.f208377c.TroopUin, i3, System.currentTimeMillis() + (i16 * 1000), "TroopFileModel<FileAssistant>");
            if (QLog.isColorLevel()) {
                QLog.d("zivonchen", 2, "OfflineVideoFileView initVarView() is_white = " + i3 + ", req_interval = " + i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e extends ef0.g {
        e() {
        }

        @Override // ef0.g
        public void c(boolean z16, int i3, String str, String str2, int i16, int i17, String str3, ByteStringMicro byteStringMicro, String str4, ByteStringMicro byteStringMicro2, Bundle bundle) {
            String str5;
            String str6;
            String str7;
            FileManagerEntity entity = TroopFileModel.this.Q.getEntity();
            String binToHEX = FileManagerUtil.binToHEX(byteStringMicro);
            if (z16 && !TextUtils.isEmpty(binToHEX)) {
                str5 = "http://" + str3 + ":" + i17 + "/ftn_compress_getfile/rkey=" + binToHEX + "&filetype=" + entity.zipType + "&path=" + URLUtil.encodeUrl(entity.zipInnerPath) + ContainerUtils.FIELD_DELIMITER;
            } else {
                str5 = null;
            }
            if (!TextUtils.isEmpty(str5)) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopFileModel<FileAssistant>", 1, "url = " + str5 + ", cookies = " + str4);
                }
                if (TroopFileModel.this.f208359c0 != null) {
                    TroopFileModel.this.f208359c0.s(str5, str4);
                }
                if (TroopFileModel.this.Q.getEntity() != null) {
                    str6 = String.valueOf(TroopFileModel.this.Q.getEntity().TroopUin);
                } else {
                    str6 = "";
                }
                String str8 = str6;
                if (TroopFileModel.this.Q.getEntity() != null) {
                    str7 = FileManagerUtil.getReportFileTypeStr(TroopFileModel.this.Q.getEntity().nFileType);
                } else {
                    str7 = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
                }
                ReportController.o(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str8, "", str7, "1");
                return;
            }
            QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl_onGetFilePreviewResult error, url is null.");
            if (TroopFileModel.this.f208359c0 != null) {
                TroopFileModel.this.f208359c0.o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f extends ef0.m {
        f() {
        }

        @Override // ef0.m
        public void c(boolean z16, int i3, oidb_0x6d6$DownloadFileRspBody oidb_0x6d6_downloadfilerspbody, Bundle bundle) {
            String str;
            if (TroopFileModel.this.f208359c0 == null) {
                return;
            }
            if (oidb_0x6d6_downloadfilerspbody == null) {
                QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error DownloadFileRspBody is null!");
                TroopFileModel.this.f208359c0.o();
                return;
            }
            long j3 = bundle.getLong("troopUin");
            TroopFileTransferManager N = TroopFileTransferManager.N(j3);
            if (N == null) {
                QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error bad troopUin[" + j3 + "]");
                TroopFileModel.this.f208359c0.o();
                return;
            }
            String string = bundle.getString("itemKey");
            if (string == null) {
                TroopFileModel.this.f208359c0.o();
                return;
            }
            TroopFileTransferManager.Item J = N.J(UUID.fromString(string));
            if (J == null) {
                QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error bad item key" + string + "]");
                TroopFileModel.this.f208359c0.o();
                return;
            }
            int i16 = oidb_0x6d6_downloadfilerspbody.int32_ret_code.get();
            if (QLog.isColorLevel()) {
                QLog.i("TroopFileModel<FileAssistant>", 2, "requestOnlinePreviewDownloadUrl: onRspDownload - retCode[" + i16 + "]");
            }
            TroopFileModel troopFileModel = TroopFileModel.this;
            if (troopFileModel.K1(i16, troopFileModel.f208359c0)) {
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
            String str2 = "";
            String a16 = zb1.a.a(J.DownloadIp, J.DownloadUrl, J.FilePath, J.cookieValue, "");
            if (!TextUtils.isEmpty(a16)) {
                TroopFileModel.this.f208359c0.s(a16, J.cookieValue);
                if (QLog.isColorLevel()) {
                    QLog.i("TroopFileModel<FileAssistant>", 2, "requestOnlinePreviewDownloadUrl: url[" + a16 + "], cookies [" + J.cookieValue + "]");
                }
                if (TroopFileModel.this.Q.getEntity() != null) {
                    str2 = String.valueOf(TroopFileModel.this.Q.getEntity().TroopUin);
                }
                String str3 = str2;
                if (TroopFileModel.this.Q.getEntity() != null) {
                    str = FileManagerUtil.getReportFileTypeStr(TroopFileModel.this.Q.getEntity().nFileType);
                } else {
                    str = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
                }
                ReportController.o(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str3, "", str, "1");
                return;
            }
            TroopFileModel.this.f208359c0.o();
            if (QLog.isColorLevel()) {
                QLog.i("TroopFileModel<FileAssistant>", 2, "requestOnlinePreviewDownloadUrl: url[" + a16 + "], cookies [" + J.cookieValue + "]");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208381d;

        g(FileManagerEntity fileManagerEntity) {
            this.f208381d = fileManagerEntity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IMsgLocationApi iMsgLocationApi = (IMsgLocationApi) QRoute.api(IMsgLocationApi.class);
            Activity activity = TroopFileModel.this.f208346d;
            FileManagerEntity fileManagerEntity = this.f208381d;
            int i3 = fileManagerEntity.peerType;
            String str = fileManagerEntity.peerUin;
            iMsgLocationApi.jumpToTargetNTAIOPosition(activity, i3, str, str, fileManagerEntity.msgSeq, fileManagerEntity.ntMsgId);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h extends ef0.i {
        h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit e(group_file_common$FileInfo group_file_common_fileinfo, TroopMemberNickInfo troopMemberNickInfo) {
            String str;
            if (troopMemberNickInfo != null) {
                str = troopMemberNickInfo.getShowName();
            } else {
                str = "";
            }
            Date date = new Date(group_file_common_fileinfo.uint32_upload_time.get() * 1000);
            String str2 = " \u4e8e" + new SimpleDateFormat("yyyy.MM.dd").format(date) + "\u4e0a\u4f20";
            FileBrowserModelBase.g gVar = TroopFileModel.this.f208351m;
            if (gVar != null) {
                gVar.i(str, str2);
                return null;
            }
            return null;
        }

        @Override // ef0.i
        protected void c(boolean z16, int i3, final group_file_common$FileInfo group_file_common_fileinfo) {
            if (group_file_common_fileinfo != null) {
                ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(String.valueOf(TroopFileModel.this.Q.getEntity().TroopUin), String.valueOf(group_file_common_fileinfo.uint64_uploader_uin.get()), "TroopFileModel<FileAssistant>", new Function1() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit e16;
                        e16 = TroopFileModel.h.this.e(group_file_common_fileinfo, (TroopMemberNickInfo) obj);
                        return e16;
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class i implements cc1.c {
        i() {
        }

        @Override // cc1.c
        public void a(FileBrowserModelBase.b bVar) {
            com.tencent.mobileqq.filemanager.fileviewer.j g16 = ((com.tencent.mobileqq.filemanager.fileviewer.data.c) bVar).g();
            if (g16 != null && FileManagerUtil.getFileType(g16.getFileName()) == 0 && !TextUtils.isEmpty(g16.getFileName()) && TextUtils.isEmpty(g16.getFilePath())) {
                FileManagerEntity entity = g16.getEntity();
                if (entity == null) {
                    QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : can not get the troop file entity, return.");
                    return;
                }
                t k3 = TroopFileUtils.k(TroopFileModel.this.N, entity.TroopUin, entity.strTroopFileID, entity.strTroopFilePath, entity.fileName, entity.fileSize, entity.busId);
                if (QLog.isColorLevel()) {
                    QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : troopUin[" + entity.TroopUin + "] troopFileId[" + entity.strTroopFileID + "] troopFilePath[" + entity.strTroopFilePath + "]");
                }
                if (TextUtils.isEmpty(k3.f294980n)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can not find local thumb file, download.");
                    }
                    TroopFileTransferManager O = TroopFileTransferManager.O(TroopFileModel.this.N, entity.TroopUin);
                    String str = entity.strTroopFileID;
                    if (str == null) {
                        O.C(entity.strTroopFilePath, g16.getFileName(), entity.busId, 640, null);
                        return;
                    } else {
                        O.D(UUID.fromString(str), 640);
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can find local thumb file, refresh the picture browser.");
                }
                FileBrowserModelBase.e eVar = TroopFileModel.this.G;
                if (eVar != null) {
                    eVar.k(k3.f294985s, k3.f294980n);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class j implements cc1.d {
        j() {
        }

        @Override // cc1.d
        public void e() {
            UUID uuid;
            UUID uuid2;
            FileManagerEntity entity = TroopFileModel.this.Q.getEntity();
            t I1 = TroopFileModel.this.I1(entity);
            if (TextUtils.isEmpty(TroopFileModel.this.f208357a0) && (uuid2 = I1.f294967a) != null) {
                TroopFileModel.this.f208357a0 = uuid2.toString();
            }
            long j3 = entity.TroopUin;
            TroopFileModel troopFileModel = TroopFileModel.this;
            TroopFileItemOperation troopFileItemOperation = new TroopFileItemOperation(j3, troopFileModel.N, troopFileModel.f208346d);
            int i3 = I1.f294972f;
            if ((i3 == 3 || i3 == 2) && (uuid = I1.f294967a) != null) {
                troopFileItemOperation.z(uuid, null);
            }
            entity.status = 2;
        }

        @Override // cc1.d
        public void f() {
            FileManagerEntity entity = TroopFileModel.this.Q.getEntity();
            TroopFileTransferManager O = TroopFileTransferManager.O(TroopFileModel.this.N, entity.TroopUin);
            t I1 = TroopFileModel.this.I1(entity);
            if (!TextUtils.isEmpty(TroopFileModel.this.f208357a0)) {
                O.D0(UUID.fromString(TroopFileModel.this.f208357a0));
                TroopFileModel.this.X1(I1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class k implements cc1.a {
        k() {
        }

        @Override // cc1.a
        public void a() {
            TroopFileModel.this.V1();
        }

        @Override // cc1.a
        public void b() {
            UUID uuid;
            FileManagerEntity entity = TroopFileModel.this.Q.getEntity();
            TroopFileTransferManager O = TroopFileTransferManager.O(TroopFileModel.this.N, entity.TroopUin);
            t I1 = TroopFileModel.this.I1(entity);
            if (TextUtils.isEmpty(TroopFileModel.this.f208357a0) && (uuid = I1.f294967a) != null) {
                TroopFileModel.this.f208357a0 = uuid.toString();
            }
            if (!TextUtils.isEmpty(TroopFileModel.this.f208357a0)) {
                O.C0(UUID.fromString(TroopFileModel.this.f208357a0));
                if (QFileUtils.e0(TroopFileModel.this.N)) {
                    TroopFileModel.this.k("0x8009D61", null);
                }
            }
            TroopFileModel.this.X1(I1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class l implements qb1.a {
        l() {
        }

        @Override // qb1.a
        public void a() {
            TroopFileModel.this.D().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class m implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f208388d;

        m(int i3) {
            this.f208388d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TroopFileModel troopFileModel = TroopFileModel.this;
            com.tencent.mobileqq.filemanager.fileviewer.g gVar = troopFileModel.f208348f;
            if (gVar != null) {
                int i3 = this.f208388d;
                if (i3 == 1) {
                    ReportController.o(null, "dc00898", "", "", "0X800A745", "0X800A745", QFileUtils.H(troopFileModel.V()), 0, "", "", "", "");
                    if (TroopFileModel.this.f208348f.s()) {
                        TroopFileModel.this.f208348f.P0();
                    }
                } else if (i3 == 2) {
                    gVar.t2();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IFileReportApi iFileReportApi = (IFileReportApi) QRoute.api(IFileReportApi.class);
            TroopFileModel troopFileModel = TroopFileModel.this;
            iFileReportApi.reportFile(troopFileModel.N, troopFileModel.Q.getEntity(), TroopFileModel.this.Q.getPeerUin(), null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class o extends FMObserver {

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<TroopFileModel> f208391e;

        o(TroopFileModel troopFileModel) {
            QLog.i("TroopFileModel<FileAssistant>", 1, "FlashTransferFileObserver. this: " + this);
            this.f208391e = new WeakReference<>(troopFileModel);
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void W(Object[] objArr) {
            TroopFileModel troopFileModel = this.f208391e.get();
            if (troopFileModel == null) {
                return;
            }
            Object[] objArr2 = (Object[]) objArr[2];
            long longValue = ((Long) objArr2[0]).longValue();
            int intValue = ((Integer) objArr2[1]).intValue();
            ((Long) objArr2[2]).longValue();
            if (longValue != troopFileModel.Q.getSessionId()) {
                return;
            }
            float f16 = intValue / 100.0f;
            troopFileModel.Q.getEntity().fProgress = f16;
            FileBrowserModelBase.f fVar = troopFileModel.E;
            if (fVar != null) {
                fVar.a(f16);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void X(Object[] objArr) {
            TroopFileModel troopFileModel = this.f208391e.get();
            if (troopFileModel == null) {
                return;
            }
            Object[] objArr2 = (Object[]) objArr[2];
            long longValue = ((Long) objArr2[0]).longValue();
            boolean booleanValue = ((Boolean) objArr2[1]).booleanValue();
            String str = (String) objArr2[2];
            QLog.i("TroopFileModel<FileAssistant>", 1, "onFlashTransferDownloadResult: sessionId: " + longValue + ", isSuccess: " + booleanValue + ", targetPath: " + str);
            if (longValue != troopFileModel.Q.getSessionId()) {
                return;
            }
            troopFileModel.Q.getEntity().strFilePath = str;
            if (troopFileModel.E == null) {
                return;
            }
            if (!booleanValue) {
                troopFileModel.Q.getEntity().status = 0;
                troopFileModel.E.e();
                return;
            }
            troopFileModel.Q.getEntity().status = 1;
            FileBrowserModelBase.f fVar = troopFileModel.E;
            if (fVar != null) {
                fVar.f();
            }
        }

        protected void finalize() throws Throwable {
            super.finalize();
            QLog.i("TroopFileModel<FileAssistant>", 1, "finalize FlashTransferFileObserver. this: " + this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class p extends com.tencent.mobileqq.app.c {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<TroopFileModel> f208393d;

        p(TroopFileModel troopFileModel) {
            this.f208393d = new WeakReference<>(troopFileModel);
        }

        @Override // com.tencent.mobileqq.app.c
        protected void b(t tVar, int i3, int i16, String str, String str2, Bundle bundle) {
            FileBrowserModelBase.c cVar;
            TroopFileModel troopFileModel = this.f208393d.get();
            if (troopFileModel != null && troopFileModel.Q.getEntity().TroopUin == tVar.f294971e && tVar.f294967a != null && troopFileModel.f208357a0 != null && troopFileModel.f208357a0.equals(tVar.f294967a.toString()) && (cVar = troopFileModel.M) != null && i3 == 0) {
                cVar.h(i16, str, str2, bundle);
            }
        }

        @Override // com.tencent.mobileqq.app.c
        protected void g(Object obj) {
            UUID uuid;
            TroopFileModel troopFileModel = this.f208393d.get();
            if (troopFileModel == null) {
                return;
            }
            FileManagerEntity entity = troopFileModel.Q.getEntity();
            t tVar = (t) obj;
            if (entity.TroopUin != tVar.f294971e) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(troopFileModel.f208357a0) && (uuid = troopFileModel.I1(entity).f294967a) != null) {
                troopFileModel.f208357a0 = uuid.toString();
            }
            if (tVar.f294967a != null && troopFileModel.f208357a0 != null && troopFileModel.f208357a0.equals(tVar.f294967a.toString())) {
                troopFileModel.X1(tVar);
            }
        }
    }

    public TroopFileModel(QQAppInterface qQAppInterface, Activity activity, List<com.tencent.mobileqq.filemanager.fileviewer.j> list, int i3) {
        super(qQAppInterface, activity);
        this.f208363g0 = "";
        this.f208364h0 = null;
        if (QLog.isColorLevel()) {
            QLog.i("TroopFileModel<FileAssistant>", 1, "FileBrowserModel init: type = troop");
        }
        l1(list, i3);
    }

    @Nullable
    private MsgRecord F1(MsgRecord msgRecord) {
        Iterator<MsgElement> it = msgRecord.getElements().iterator();
        ReplyElement replyElement = null;
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.getElementType() == 7 && next.getReplyElement() != null) {
                replyElement = next.getReplyElement();
            }
        }
        if (replyElement != null && replyElement.getSourceMsgIdInRecords() != null && replyElement.getSourceMsgIdInRecords().longValue() > 0) {
            Iterator<MsgRecord> it5 = msgRecord.getRecords().iterator();
            while (it5.hasNext()) {
                MsgRecord next2 = it5.next();
                if (next2.getMsgId() == replyElement.getSourceMsgIdInRecords().longValue()) {
                    return next2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K1(int i3, FileBrowserModelBase.d dVar) {
        if (i3 != -133 && i3 != -132 && i3 != -134) {
            if (i3 != -103 && i3 != -301) {
                return false;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("TroopFileModel<FileAssistant>", 4, "file invalidate retCode = " + i3);
            }
            return true;
        }
        dVar.o();
        if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileModel<FileAssistant>", 4, "file invalidate retCode = " + i3);
        }
        return true;
    }

    private void L1() {
        if (this.f208360d0 == null) {
            this.f208360d0 = new f();
        }
    }

    private void M1() {
        if (this.f208361e0 == null) {
            this.f208361e0 = new e();
        }
    }

    private boolean N1(MsgRecord msgRecord) {
        if (msgRecord.getMsgType() == 9) {
            ArrayList<MsgElement> elements = msgRecord.getElements();
            if (elements != null && !elements.isEmpty()) {
                ReplyElement replyElement = elements.get(0).getReplyElement();
                if (replyElement == null) {
                    QLog.i("TroopFileModel<FileAssistant>", 1, "[isReplyMultiForwardMsg]: replyElement is null");
                    return false;
                }
                ArrayList<MsgRecord> records = msgRecord.getRecords();
                if (records != null && !records.isEmpty()) {
                    MsgRecord msgRecord2 = records.get(0);
                    if (msgRecord2.getMsgId() != replyElement.getSourceMsgIdInRecords().longValue() || !al.c(msgRecord2)) {
                        return false;
                    }
                    return true;
                }
                QLog.i("TroopFileModel<FileAssistant>", 1, "[isReplyMultiForwardMsg]: subMsgRecordList is null or empty");
                return false;
            }
            QLog.i("TroopFileModel<FileAssistant>", 1, "[isReplyMultiForwardMsg]: elements is null or empty");
        }
        return false;
    }

    private boolean O1(int i3, int i16) {
        if ((i3 == 4 || i3 == 13) && i16 == 2 && ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).useNewBrowserOpenMediaFile()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P1(MsgRecord msgRecord) {
        AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
        aIOMsgItem.Y0(this.f208346d);
        ArrayList arrayList = new ArrayList();
        arrayList.add(aIOMsgItem);
        ((IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.b(IRichMediaBrowserApi.class)).enterVideoPreview(MobileQQ.sMobileQQ.peekAppRuntime(), this.f208346d, null, aIOMsgItem, 0L, false, false, null, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q1(MsgRecord msgRecord) {
        if (msgRecord.getMsgType() == 3) {
            this.f208348f.P0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1(long j3, int i3, String str, ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MsgRecord msgRecord = (MsgRecord) it.next();
                if (msgRecord.getMsgId() == j3) {
                    U1(msgRecord);
                }
            }
            return;
        }
        QLog.d("TroopFileModel<FileAssistant>", 1, "[updateFileInfoWithStateDownloaded] getMultiMsg null " + i3 + " " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(boolean z16, w wVar, Contact contact, int i3, String str, ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            QLog.d("TroopFileModel<FileAssistant>", 1, "updateFileInfoWithStateDownloaded find msg success");
            MsgRecord msgRecord = (MsgRecord) arrayList.get(0);
            if (this.f208348f != null && msgRecord != null && !z16) {
                if (msgRecord.getMsgType() != 8 && ((msgRecord.getMsgType() != 11 || msgRecord.getSubMsgType() != 7) && !N1(msgRecord))) {
                    if (msgRecord.getMsgType() == 9) {
                        U1(F1(msgRecord));
                        return;
                    } else {
                        U1(msgRecord);
                        return;
                    }
                }
                final long j3 = this.I.getLong("multi_msg_file_id");
                MsgRecordParams msgRecordParams = (MsgRecordParams) this.I.getParcelable("multi_msg_file_parent_params");
                if (msgRecordParams == null) {
                    return;
                }
                wVar.getMultiMsg(contact, msgRecord.getMsgId(), msgRecordParams.b(), new IGetMultiMsgCallback() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMultiMsgCallback
                    public final void onResult(int i16, String str2, ArrayList arrayList2) {
                        TroopFileModel.this.R1(j3, i16, str2, arrayList2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(FileManagerEntity fileManagerEntity, t tVar) {
        QFileUtils.h0(this.f208346d, fileManagerEntity.TroopUin, tVar, fileManagerEntity);
        com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208348f;
        if (gVar != null) {
            gVar.P0();
        }
    }

    private void U1(@Nullable final MsgRecord msgRecord) {
        if (msgRecord != null && msgRecord.getMsgType() == 3) {
            QLog.d("TroopFileModel<FileAssistant>", 1, "[processVideoFile] " + com.tencent.util.k.f(msgRecord, Arrays.asList("sendNickName")));
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.g
                @Override // java.lang.Runnable
                public final void run() {
                    TroopFileModel.this.P1(msgRecord);
                }
            }, 100L);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.h
                @Override // java.lang.Runnable
                public final void run() {
                    TroopFileModel.this.Q1(msgRecord);
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1(FileManagerEntity fileManagerEntity, final t tVar) {
        long j3 = fileManagerEntity.lastTime;
        String str = fileManagerEntity.selfUin;
        boolean z16 = fileManagerEntity.bSend;
        boolean z17 = fileManagerEntity.isZipInnerFile;
        final FileManagerEntity newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(tVar);
        newEntityByTroopFileInfo.Uuid = fileManagerEntity.Uuid;
        fileManagerEntity.copyFrom(newEntityByTroopFileInfo);
        fileManagerEntity.lastTime = j3;
        fileManagerEntity.selfUin = str;
        fileManagerEntity.bSend = z16;
        fileManagerEntity.isZipInnerFile = z17;
        if (this.H == 3 && V() == 2) {
            final boolean z18 = this.I.getBoolean("is_multi_aio_msg", false);
            final Contact contact = new Contact(2, String.valueOf(tVar.f294971e), "");
            final w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 == null) {
                return;
            }
            ArrayList<Long> arrayList = new ArrayList<>();
            MsgRecordParams msgRecordParams = (MsgRecordParams) this.I.getParcelable("reply_msg_file_params");
            if (msgRecordParams != null) {
                arrayList.add(Long.valueOf(msgRecordParams.b()));
            } else {
                arrayList.add(Long.valueOf(tVar.J));
            }
            e16.getMsgsByMsgId(contact, arrayList, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str2, ArrayList arrayList2) {
                    TroopFileModel.this.S1(z18, e16, contact, i3, str2, arrayList2);
                }
            });
        } else if (O1(this.H, V())) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.e
                @Override // java.lang.Runnable
                public final void run() {
                    TroopFileModel.this.T1(newEntityByTroopFileInfo, tVar);
                }
            }, 100L);
        }
        if (G() == 3) {
            FileBrowserModelBase.f fVar = this.E;
            if (fVar != null) {
                fVar.f();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TroopFileModel<FileAssistant>", 2, "file download finished, but file not exist.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X1(final t tVar) {
        this.f208346d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.6
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isDevelopLevel()) {
                    t tVar2 = tVar;
                    QLog.d("TroopFileModel<FileAssistant>", 4, String.format("update file info: status:%d fileName:%s errorCode:%d", Integer.valueOf(tVar.f294972f), tVar2.f294987u, Integer.valueOf(tVar2.f294974h)));
                }
                FileManagerEntity entity = TroopFileModel.this.Q.getEntity();
                if (!entity.isFromProcessingForward2c2cOrDiscItem() && !entity.isFromProcessingForward2DatalineItem()) {
                    FileBrowserModelBase.e eVar = TroopFileModel.this.G;
                    if (eVar != null) {
                        t tVar3 = tVar;
                        eVar.k(tVar3.f294985s, tVar3.f294980n);
                    }
                    TroopFileModel troopFileModel = TroopFileModel.this;
                    FileBrowserModelBase.f fVar = troopFileModel.E;
                    if (fVar == null) {
                        QLog.d("TroopFileModel<FileAssistant>", 1, "updateTroopFileInfo: error, transListener is null!");
                        if (QLog.isDevelopLevel()) {
                            QQToast.makeText(TroopFileModel.this.f208346d, 1, R.string.zyy, 0);
                            return;
                        }
                        return;
                    }
                    t tVar4 = tVar;
                    int i3 = tVar4.f294972f;
                    if (i3 != 1) {
                        if (i3 != 2 && i3 != 3) {
                            if (i3 != 6) {
                                switch (i3) {
                                    case 8:
                                        if (troopFileModel.f208358b0 != 8) {
                                            TroopFileModel.this.E.j();
                                        }
                                        FileBrowserModelBase.f fVar2 = TroopFileModel.this.E;
                                        t tVar5 = tVar;
                                        fVar2.a((((float) tVar5.f294977k) * 1.0f) / (((float) tVar5.f294976j) * 1.0f));
                                        break;
                                    case 9:
                                    case 10:
                                        fVar.l();
                                        break;
                                    case 11:
                                        troopFileModel.W1(entity, tVar4);
                                        break;
                                    case 12:
                                        Intent intent = new Intent();
                                        intent.putExtra("TroopFile_DeleteFile", true);
                                        intent.putExtra("TroopFile_FileName", tVar.f294987u);
                                        TroopFileModel.this.f208346d.setResult(-1, intent);
                                        TroopFileModel.this.f208346d.finish();
                                        break;
                                }
                            } else {
                                fVar.f();
                            }
                        } else {
                            fVar.l();
                        }
                    } else {
                        fVar.j();
                        FileBrowserModelBase.f fVar3 = TroopFileModel.this.E;
                        t tVar6 = tVar;
                        fVar3.a((((float) tVar6.f294977k) * 1.0f) / (((float) tVar6.f294976j) * 1.0f));
                    }
                    TroopFileModel.this.f208358b0 = tVar.f294972f;
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int A() {
        int V = V();
        int A = super.A();
        if ((this.H == 3 && V == 2 && !this.I.getBoolean("is_multi_aio_msg", false)) || O1(this.H, V)) {
            return 8;
        }
        if (A != 0) {
            return A;
        }
        if (V != 0) {
            if (V == 2) {
                return 8;
            }
            if (V != 4) {
                if (V == 5) {
                    if (!FileUtils.fileExistsAndNotEmpty(N())) {
                        return 11;
                    }
                    return A;
                }
            } else if (FileManagerUtil.canPreviewZip(this.N, this.Q, false) && FileManagerUtil.canPreview(this.f208346d, L(), Q())) {
                return 5;
            }
            return 7;
        }
        return 6;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    protected void B0() {
        String str;
        if (this.Z != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("fobserver<FileAssistant>", 1, "del troopMngObserver");
            }
            ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.Z);
        }
        TroopFileError.d dVar = this.f208362f0;
        if (dVar != null) {
            TroopFileError.f(this.N, dVar);
        }
        this.Z = null;
        this.f208362f0 = null;
        this.f208360d0 = null;
        this.f208361e0 = null;
        if (this.f208364h0 != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("deleteObserver FlashTransferFileObserver: ");
            sb5.append(this.f208364h0);
            sb5.append(", this: ");
            sb5.append(this);
            sb5.append(", filePath: ");
            if (this.Q.getEntity() != null) {
                str = this.Q.getEntity().strFilePath;
            } else {
                str = "";
            }
            sb5.append(str);
            QLog.i("TroopFileModel<FileAssistant>", 1, sb5.toString());
            ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().deleteObserver(this.f208364h0);
            this.f208364h0 = null;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public cc1.a D() {
        if (this.C == null) {
            this.C = new k();
        }
        return this.C;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String E() {
        t I1 = I1(this.Q.getEntity());
        if (I1 != null) {
            return I1.A;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void E0(int i3) {
        String str;
        String str2;
        super.E0(i3);
        if (i3 == 6) {
            FileManagerEntity entity = this.Q.getEntity();
            if (entity != null) {
                str = String.valueOf(entity.TroopUin);
            } else {
                str = "";
            }
            String str3 = str;
            if (entity != null) {
                str2 = FileManagerUtil.getReportFileTypeStr(entity.nFileType);
            } else {
                str2 = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
            }
            ReportController.o(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str3, "", str2, "1");
            return;
        }
        if (i3 == 4) {
            ReportController.o(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", "-1", "-1", "-1");
        } else if (i3 == 8) {
            ReportController.o(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
        }
    }

    protected boolean E1(FileManagerEntity fileManagerEntity) {
        boolean o16;
        String e16;
        long docsImportFileMaxSize = FileManagerUtil.getDocsImportFileMaxSize(fileManagerEntity.fileName);
        ta1.k c16 = TencentDocImportFileInfoProcessor.c();
        ta1.f a16 = TencentDocConvertConfigProcessor.a();
        if (a16 == null) {
            o16 = false;
        } else {
            o16 = a16.o();
        }
        if (c16 == null) {
            e16 = "";
        } else {
            e16 = c16.e();
        }
        if (TextUtils.isEmpty(e16)) {
            e16 = ITeamWorkUtils.FILE_WORD_XLS;
        }
        if (!o16 || !((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsSupport(fileManagerEntity.getFilePath(), fileManagerEntity.fileName, e16) || fileManagerEntity.fileSize > docsImportFileMaxSize) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void F0(final FileBrowserModelBase.d dVar) {
        this.f208359c0 = dVar;
        L1();
        M1();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.13
            @Override // java.lang.Runnable
            public void run() {
                FileManagerEntity entity = TroopFileModel.this.Q.getEntity();
                if (entity.isZipInnerFile) {
                    TroopFileModel troopFileModel = TroopFileModel.this;
                    com.tencent.biz.troop.file.a.h(troopFileModel.N, entity.TroopUin, entity.zipFilePath, entity.busId, troopFileModel.f208361e0);
                    return;
                }
                TroopFileTransferManager N = TroopFileTransferManager.N(entity.TroopUin);
                if (N == null) {
                    QLog.e("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl error: " + entity.TroopUin);
                    dVar.o();
                    return;
                }
                N.d0(entity.strTroopFilePath, entity.fileName, entity.fileSize, entity.busId, TroopFileModel.this.f208360d0);
            }
        }, 8, null, true);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean G0(FileBrowserModelBase.d dVar) {
        TroopInfo findTroopInfo;
        FileManagerEntity entity = this.Q.getEntity();
        ITroopInfoService iTroopInfoService = (ITroopInfoService) this.N.getRuntimeService(ITroopInfoService.class, "");
        if (iTroopInfoService == null || (findTroopInfo = iTroopInfoService.findTroopInfo(String.valueOf(entity.TroopUin))) == null) {
            return false;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        TroopExtDBInfo troopExtDBInfo = findTroopInfo.extDBInfo;
        if (serverTimeMillis <= troopExtDBInfo.fileVideoReqInterval) {
            if (troopExtDBInfo.fileVideoIsWhite != 0) {
                if (dVar != null) {
                    dVar.n();
                }
                ReportController.o(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
            } else {
                if (dVar != null) {
                    dVar.b();
                }
                ReportController.o(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", "-1", "-1", "-1");
            }
            return true;
        }
        zb1.a.b(this.N, entity.TroopUin, new d(dVar, findTroopInfo, entity));
        return true;
    }

    protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> G1(FileManagerEntity fileManagerEntity) {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        arrayList.add(QFileUtils.c(2, com.tencent.mobileqq.filemanager.fileviewer.c.r(this.f208348f, fileManagerEntity)));
        arrayList.add(QFileUtils.c(26, null));
        arrayList.add(QFileUtils.c(27, com.tencent.mobileqq.filemanager.fileviewer.c.s(this.f208348f, fileManagerEntity)));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public com.tencent.mobileqq.colornote.f H() {
        FileManagerEntity entity = this.Q.getEntity();
        t I1 = I1(entity);
        if (I1 == null) {
            QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file info is null.");
            return new bc1.c();
        }
        long j3 = entity.TroopUin;
        int i3 = I1.f294972f;
        if (i3 != 3 && i3 != 2 && i3 != 1) {
            return new bc1.h(j3, I1);
        }
        if (TextUtils.isEmpty(I1.f294985s) && FileUtils.fileExistsAndNotEmpty(I1.f294978l)) {
            QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
            return new bc1.e(I1.f294978l);
        }
        QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
        return new bc1.c();
    }

    protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> H1(FileManagerEntity fileManagerEntity) {
        com.tencent.mobileqq.filemanager.fileviewer.g gVar;
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        String N = N();
        boolean f16 = q.f(N);
        if (f16) {
            V0(fileManagerEntity, arrayList);
        }
        int y16 = y();
        if (y16 != 0 && (gVar = this.f208348f) != null && gVar.shouldDisplayColorNote()) {
            int i3 = 70;
            if (y16 != 1 && y16 == 2) {
                i3 = 82;
            }
            arrayList.add(QFileUtils.c(i3, new m(y16)));
        }
        if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && f16) {
            arrayList.add(QFileUtils.c(39, null));
        }
        if (FileManagerUtil.isSupportFavorite(fileManagerEntity)) {
            arrayList.add(QFileUtils.c(6, com.tencent.mobileqq.filemanager.fileviewer.c.c(this.f208348f, fileManagerEntity)));
        }
        U0(fileManagerEntity, arrayList);
        if (E1(fileManagerEntity)) {
            ShareActionSheetBuilder.ActionSheetItem c16 = QFileUtils.c(119, com.tencent.mobileqq.filemanager.fileviewer.c.e(fileManagerEntity, this.f208346d));
            ReportController.o(this.N, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
            arrayList.add(c16);
        }
        if (com.tencent.mobileqq.filemanageraux.link.b.h(fileManagerEntity, f16)) {
            arrayList.add(QFileUtils.c(122, com.tencent.mobileqq.filemanager.fileviewer.c.p(this.f208346d, fileManagerEntity, N)));
            arrayList.add(QFileUtils.c(123, com.tencent.mobileqq.filemanager.fileviewer.c.q(this.f208346d, fileManagerEntity, N)));
        }
        t I1 = I1(fileManagerEntity);
        if (I1 != null && I1.f294967a != null && V() == 0 && (FileUtils.fileExistsAndNotEmpty(I1.f294980n) || f16)) {
            arrayList.add(QFileUtils.c(52, null));
        }
        if (f16 && X0(N)) {
            arrayList.add(QFileUtils.c(132, null));
            ReportController.o(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
        }
        arrayList.add(d1());
        return arrayList;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String I() {
        FileManagerEntity entity = this.Q.getEntity();
        StringBuilder sb5 = new StringBuilder(q.g(Q()));
        if (104 == entity.busId && entity.lastTime > 0) {
            sb5.append(BaseApplication.getContext().getString(R.string.b78));
            sb5.append(TroopFileUtils.e(BaseApplication.getContext(), entity.lastTime));
        }
        return sb5.toString();
    }

    protected t I1(FileManagerEntity fileManagerEntity) {
        return TroopFileUtils.n(this.N, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    /* renamed from: J1, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.filemanager.fileviewer.data.i j0() {
        return new com.tencent.mobileqq.filemanager.fileviewer.data.i(I1(this.Q.getEntity()));
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String K() {
        FileManagerEntity entity;
        if (V() == 5 && (entity = this.Q.getEntity()) != null) {
            return entity.yybApkIconUrl;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int R() {
        int i3 = I1(this.Q.getEntity()).f294972f;
        if (i3 == 3 || i3 == 2 || i3 == 10 || i3 == 9) {
            return 3;
        }
        if (i3 == 8 || i3 == 1 || i3 == 4) {
            return 2;
        }
        if (i3 == 6 || i3 == 11) {
            return 1;
        }
        if (i3 == 12) {
            return 16;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel getFileStatus : troopFileStatus[" + i3 + "] can not change troop file status to FMConstants status");
        }
        return super.R();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int U() {
        int i3 = I1(this.Q.getEntity()).f294972f;
        if (i3 == 3 || i3 == 2 || i3 == 1) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b
    public void U0(FileManagerEntity fileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        Bundle bundle;
        int D;
        if (fileManagerEntity.cloudType == 15 || (bundle = this.I) == null || bundle.getBoolean("file_location_pos_entrance_multiseq", false) || (D = QFileUtils.D(this.H, 0)) == 0) {
            return;
        }
        arrayList.add(QFileUtils.c(54, new g(fileManagerEntity)));
        ReportController.o(null, "dc00898", "", "", "0X800B450", "0X800B450", D, 0, "", "", "", "");
    }

    public void V1() {
        UUID uuid;
        FileManagerEntity entity = this.Q.getEntity();
        if (entity.cloudType == 17) {
            v d16 = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getFlashTransferFileBrowser().d();
            if (d16 != null) {
                d16.a(entity);
                return;
            }
            return;
        }
        t I1 = I1(entity);
        if (TextUtils.isEmpty(this.f208357a0) && (uuid = I1.f294967a) != null) {
            this.f208357a0 = uuid.toString();
        }
        Bundle bundle = new Bundle();
        bundle.putLong("TRANS_PARAM_NT_MSGID", entity.ntMsgId);
        bundle.putLong("TRANS_PARAM_NT_ELEMENTID", entity.uniseq);
        bundle.putLong("TRANS_PARAM_UPLOAD_TIME", entity.srvTime / 1000);
        boolean fileExist = FileManagerUtil.fileExist(I1.f294978l);
        TroopFileItemOperation troopFileItemOperation = new TroopFileItemOperation(entity.TroopUin, this.N, this.f208346d);
        int i3 = I1.f294972f;
        if (i3 != 10 && i3 != 9) {
            if (i3 != 7 && (fileExist || i3 != 6)) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : can not handle file info status,download error");
                    return;
                }
                return;
            } else {
                if (entity.isZipInnerFile) {
                    troopFileItemOperation.D(entity);
                } else {
                    troopFileItemOperation.C(entity.strTroopFilePath, I1.f294987u, I1.f294976j, I1.f294988v, bundle, null);
                }
                entity.fProgress = 0.0f;
                entity.status = 2;
                return;
            }
        }
        UUID uuid2 = I1.f294967a;
        if (uuid2 != null) {
            troopFileItemOperation.w(uuid2, bundle, null);
            entity.status = 2;
        } else if (QLog.isColorLevel()) {
            QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : resumeDownload error, infoId is null");
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public List<FileBrowserModelBase.b> W() {
        ArrayList arrayList = new ArrayList();
        List<com.tencent.mobileqq.filemanager.fileviewer.j> list = this.P;
        if (list != null) {
            Iterator<com.tencent.mobileqq.filemanager.fileviewer.j> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.mobileqq.filemanager.fileviewer.data.e(it.next()));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public Intent X() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity == null) {
            return null;
        }
        return QFileUtils.Z(this.N, entity);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] Y() {
        boolean z16;
        int G = G();
        if (G != 5 && G != 4) {
            return super.Y();
        }
        FileManagerEntity entity = this.Q.getEntity();
        if (entity == null || entity.isZipInnerFile || entity.status == 16) {
            return null;
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> G1 = G1(entity);
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> H1 = H1(entity);
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        if (G1 != null && !G1.isEmpty()) {
            arrayList.addAll(G1);
        }
        if (H1 != null && !H1.isEmpty()) {
            arrayList2.addAll(H1);
        }
        IPrintApi iPrintApi = (IPrintApi) QRoute.api(IPrintApi.class);
        String L = L();
        if (entity.TroopUin != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (iPrintApi.isSupportPrint(L, false, z16) && !ae.h(entity)) {
            arrayList2.add(QFileUtils.c(121, ((IPrintApi) QRoute.api(IPrintApi.class)).getFilePrintClick(this.f208348f.getActivity(), entity, new l(), false)));
        }
        return new ArrayList[]{arrayList, arrayList2};
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b
    protected boolean Y0() {
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public cc1.c d0() {
        return new i();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b
    protected ShareActionSheetBuilder.ActionSheetItem d1() {
        com.tencent.mobileqq.filemanager.fileviewer.j jVar = this.Q;
        if (jVar != null && jVar.getEntity() != null && this.Q.getEntity().cloudType == 15) {
            QLog.i("TroopFileModel<FileAssistant>", 1, "edit file not show jubao menu item!");
            return null;
        }
        return QFileUtils.c(11, new n());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public long f0() {
        com.tencent.mobileqq.filemanager.fileviewer.j jVar = this.Q;
        if (jVar != null) {
            return jVar.getEntity().TroopUin;
        }
        return super.f0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public cc1.d g0() {
        if (this.D == null) {
            this.D = new j();
        }
        return this.D;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b
    public boolean g1() {
        com.tencent.mobileqq.filemanager.fileviewer.j jVar = this.Q;
        if (jVar == null || jVar.getEntity() == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean h() {
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] i0() {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        FileManagerEntity entity = this.Q.getEntity();
        String N = N();
        boolean f16 = q.f(N);
        arrayList.add(QFileUtils.c(2, com.tencent.mobileqq.filemanager.fileviewer.c.r(this.f208348f, entity)));
        arrayList.add(QFileUtils.c(26, null));
        if (!f16) {
            arrayList.add(QFileUtils.c(27, com.tencent.mobileqq.filemanager.fileviewer.c.s(this.f208348f, entity)));
        } else {
            arrayList.add(QFileUtils.c(27, com.tencent.mobileqq.filemanager.fileviewer.c.h(entity.nSessionId, this.f208348f, N)));
        }
        WXShareHelper b06 = WXShareHelper.b0();
        if (f16 && b06.e0() && b06.d0()) {
            arrayList.add(QFileUtils.c(9, com.tencent.mobileqq.filemanager.fileviewer.c.o(this.f208346d, N)));
        }
        if (Y0()) {
            a(arrayList, f16);
        }
        if (f16) {
            arrayList.add(QFileUtils.c(64, new b()));
        }
        if (f16) {
            arrayList2.add(QFileUtils.c(39, null));
        }
        if (FileManagerUtil.isSupportFavorite(this.Q.getEntity())) {
            arrayList.add(QFileUtils.c(6, com.tencent.mobileqq.filemanager.fileviewer.c.c(this.f208348f, entity)));
        }
        if (com.tencent.mobileqq.filemanageraux.link.b.h(entity, f16)) {
            arrayList2.add(QFileUtils.c(122, com.tencent.mobileqq.filemanager.fileviewer.c.p(this.f208346d, entity, N)));
            arrayList2.add(QFileUtils.c(123, com.tencent.mobileqq.filemanager.fileviewer.c.q(this.f208346d, entity, N)));
        }
        i(arrayList2);
        if (f16 && X0(N)) {
            arrayList2.add(QFileUtils.c(132, null));
            ReportController.o(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
        }
        ShareActionSheetBuilder.ActionSheetItem d16 = d1();
        if (d16 != null) {
            arrayList2.add(d16);
        }
        return new ArrayList[]{arrayList, arrayList2};
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b
    public void j1() {
        FileManagerEntity entity = this.Q.getEntity();
        super.j1();
        if (G() == 4) {
            this.N.getFileManagerDataCenter().Q(new r(this.N, entity.TroopUin, I1(entity)));
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void k(String str, Bundle bundle) {
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k0(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        boolean z16;
        FileManagerEntity entity;
        if (actionSheetItem == null) {
            return;
        }
        FileManagerEntity entity2 = this.Q.getEntity();
        String N = N();
        if (entity2 == null && TextUtils.isEmpty(N)) {
            return;
        }
        int i3 = actionSheetItem.action;
        if (i3 == 73) {
            com.tencent.mobileqq.filemanager.fileviewer.c.r(this.f208348f, entity2).onClick(null);
        } else if (i3 == 72) {
            int i16 = actionSheetItem.uinType;
            String str = actionSheetItem.uin;
            if (!TextUtils.isEmpty(str)) {
                QFileUtils.B(this.N, this.f208346d, entity2, true, str, i16);
            }
        } else if (i3 == 52) {
            String N2 = N();
            if (!FileUtils.fileExistsAndNotEmpty(N2) && (entity = this.Q.getEntity()) != null) {
                N2 = entity.strLargeThumPath;
            }
            String str2 = N2;
            if (FileUtils.fileExistsAndNotEmpty(str2)) {
                ((IOCR) QRoute.api(IOCR.class)).startOcrPerformFragment(this.f208346d, str2, 1, -1002, null, false);
            }
        } else if (i3 == 132) {
            QbSdk.clearDefaultBrowser(this.f208346d, N());
            FileManagerUtil.openWithOtherApp(this.f208346d, N());
            ReportController.o(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
        } else if (i3 == 26) {
            ReportController.o(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
            com.tencent.mobileqq.filemanager.fileassistant.util.b.i(entity2).a(this.f208346d, this.N, new c(entity2));
        } else {
            super.k0(actionSheetItem);
            z16 = false;
            if (!z16) {
                D0(i3);
                return;
            }
            return;
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void l0() {
        String str;
        FileManagerEntity entity;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
        if (this.Z == null) {
            this.Z = new p(this);
            if (QLog.isDevelopLevel()) {
                QLog.i("fobserver<FileAssistant>", 1, "add troopMngObserver");
            }
            qQAppInterface.addObserver(this.Z);
            if (this.f208362f0 == null && (entity = this.Q.getEntity()) != null) {
                TroopFileError.d dVar = new TroopFileError.d(this.f208346d, entity.TroopUin, this.N);
                this.f208362f0 = dVar;
                TroopFileError.a(qQAppInterface, dVar);
            }
        }
        if (this.f208364h0 == null && this.Q.getEntity() != null && this.Q.getEntity().nOpType == 58 && !FileUtils.fileExists(this.Q.getEntity().strFilePath)) {
            this.f208364h0 = new o(this);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("addObserver FlashTransferFileObserver: ");
            sb5.append(this.f208364h0);
            sb5.append(", this: ");
            sb5.append(this);
            sb5.append(", filePath: ");
            if (this.Q.getEntity() != null) {
                str = this.Q.getEntity().strFilePath;
            } else {
                str = "";
            }
            sb5.append(str);
            QLog.i("TroopFileModel<FileAssistant>", 1, sb5.toString());
            qQAppInterface.getFileManagerNotifyCenter().addObserver(this.f208364h0);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String r() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null) {
            return entity.yybApkPackageName;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void v0() {
        com.tencent.biz.troop.file.a.h(this.N, this.Q.getEntity().TroopUin, this.Q.getEntity().strTroopFilePath, this.Q.getEntity().busId, new a());
        com.tencent.biz.troop.file.a.m(this.N, this.Q.getEntity().TroopUin, this.Q.getEntity().busId, this.Q.getEntity().strTroopFilePath, new h());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String w() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null) {
            return entity.yybApkName;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String x() {
        FileManagerEntity entity;
        com.tencent.mobileqq.filemanager.fileviewer.j jVar = this.Q;
        if (jVar == null || (entity = jVar.getEntity()) == null || entity.nOpType != 58) {
            return "biz_src_jc_file";
        }
        return "biz_src_jc_flash_transfer";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int y() {
        boolean z16;
        t I1;
        int V = V();
        if (V != 0 && V != 2 && V != 13) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || (I1 = I1(this.Q.getEntity())) == null) {
            return 0;
        }
        int i3 = I1.f294972f;
        if ((i3 == 3 || i3 == 2 || i3 == 1) && TextUtils.isEmpty(I1.f294985s)) {
            QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
            return 0;
        }
        if (TextUtils.isEmpty(I1.f294985s) && !FileUtils.fileExistsAndNotEmpty(N())) {
            return 0;
        }
        com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208348f;
        if (gVar != null && gVar.g2()) {
            return 2;
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String z() {
        if (A() == 2) {
            t I1 = I1(this.Q.getEntity());
            if (TextUtils.isEmpty(this.f208363g0)) {
                this.f208363g0 = I1.f294985s + "_" + System.currentTimeMillis();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getContextId: troop video file random contextId: ");
                sb5.append(this.f208363g0);
                QLog.i("TroopFileModel<FileAssistant>", 1, sb5.toString());
            }
            return this.f208363g0;
        }
        return super.z();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements b.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208373a;

        c(FileManagerEntity fileManagerEntity) {
            this.f208373a = fileManagerEntity;
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void a() {
            QFileAssistantForwardManager qFileAssistantForwardManager = new QFileAssistantForwardManager(TroopFileModel.this.N);
            qFileAssistantForwardManager.c(true);
            qFileAssistantForwardManager.b(this.f208373a);
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void b() {
            TroopFileModel troopFileModel = TroopFileModel.this;
            QQAppInterface qQAppInterface = troopFileModel.N;
            Activity activity = troopFileModel.f208346d;
            FileManagerEntity fileManagerEntity = this.f208373a;
            QFileUtils.m0(qQAppInterface, activity, fileManagerEntity.TroopUin, fileManagerEntity.strTroopFileID, fileManagerEntity.strTroopFilePath, fileManagerEntity.fileName, fileManagerEntity.fileSize, fileManagerEntity.busId);
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void onDismiss() {
        }
    }
}
