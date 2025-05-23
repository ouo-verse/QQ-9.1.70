package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.dataline.activities.LiteActivity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.k;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filebrowser.richmedia.FilePreviewLayerFragment;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.app.j;
import com.tencent.mobileqq.filemanager.app.k;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.fileassistant.util.b;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.openbrowser.FlashTransferMediaFileBrowseProcessor;
import com.tencent.mobileqq.filemanager.openbrowser.g;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.ap;
import com.tencent.mobileqq.filemanager.util.bb;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanageraux.link.LinkByWeiyunFragment;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.haoliyou.JumpShareUtils;
import com.tencent.mobileqq.multimsg.i;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.s;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocsListFragment;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileProcessor;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.vip.d;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.widget.BubblePopupWindow;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavUtil;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQFileTempUtilsImpl implements IQQFileTempUtils {
    private static final String TAG = "QQFileTempUtilsImpl";
    k mDataLineObserver = null;
    private k.a mTroopDocsQIPCModuleListener = null;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends com.tencent.mobileqq.app.k {

        /* renamed from: d, reason: collision with root package name */
        private Map<Long, FileManagerEntity> f206781d = new HashMap();

        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void b(long j3, String str, int i3, boolean z16, boolean z17, long j16) {
            super.b(j3, str, i3, z16, z17, j16);
            FileManagerEntity u16 = u(j3);
            if (u16 == null) {
                return;
            }
            u16.status = 2;
            QQFileTempUtilsImpl.this.notifyItemStatus(u16.uniseq, u16.nSessionId, AppConstants.DATALINE_PC_UIN, 6000, 10, null, 0, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void c(long j3, String str, int i3, boolean z16, boolean z17, long j16) {
            super.c(j3, str, i3, z16, z17, j16);
            FileManagerEntity u16 = u(j3);
            if (u16 == null) {
                return;
            }
            u16.status = 2;
            QQFileTempUtilsImpl.this.notifyItemStatus(u16.uniseq, u16.nSessionId, AppConstants.DATALINE_PC_UIN, 6000, 10, null, 0, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void h(long j3, float f16) {
            super.h(j3, f16);
            FileManagerEntity u16 = u(j3);
            if (u16 == null) {
                return;
            }
            u16.fProgress = f16;
            QQFileTempUtilsImpl.this.notifyItemStatus(u16.uniseq, u16.nSessionId, AppConstants.DATALINE_PC_UIN, 6000, 16, null, 0, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void j(boolean z16, long j3, String str) {
            int i3;
            super.j(z16, j3, str);
            FileManagerEntity u16 = u(j3);
            if (u16 == null) {
                return;
            }
            if (z16) {
                u16.status = 1;
            } else {
                u16.status = 0;
            }
            if (QQFileTempUtilsImpl.this.getApp() != null) {
                ((IQQFileDataCenter) ((QQAppInterface) QQFileTempUtilsImpl.this.getApp()).getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(u16);
            }
            QLog.e("QQFileTempUtilsImpl<FileAssistant>", 2, "FMConstants.TYPE_FILE_RECVFILE_SUCCESS in onRecvFile,entity.cloudtype:" + u16.cloudType + ",filepath:" + u16.getFilePath());
            QQFileTempUtilsImpl qQFileTempUtilsImpl = QQFileTempUtilsImpl.this;
            long j16 = u16.uniseq;
            long j17 = u16.nSessionId;
            String str2 = AppConstants.DATALINE_PC_UIN;
            if (z16) {
                i3 = 11;
            } else {
                i3 = 12;
            }
            qQFileTempUtilsImpl.notifyItemStatus(j16, j17, str2, 6000, i3, null, 0, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void l(boolean z16, long j3, String str) {
            int i3;
            super.l(z16, j3, str);
            super.j(z16, j3, str);
            FileManagerEntity u16 = u(j3);
            if (u16 == null) {
                return;
            }
            if (z16) {
                u16.status = 1;
            } else {
                u16.status = 0;
            }
            ((IQQFileDataCenter) QQFileTempUtilsImpl.this.getApp().getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(u16);
            QLog.e("QQFileTempUtilsImpl<FileAssistant>", 2, "FMConstants.TYPE_FILE_RECVFILE_SUCCESS in onSendFile,entity.cloudtype:" + u16.cloudType + ",filepath:" + u16.getFilePath());
            QQFileTempUtilsImpl qQFileTempUtilsImpl = QQFileTempUtilsImpl.this;
            long j16 = u16.uniseq;
            long j17 = u16.nSessionId;
            String str2 = AppConstants.DATALINE_PC_UIN;
            if (z16) {
                i3 = 11;
            } else {
                i3 = 12;
            }
            qQFileTempUtilsImpl.notifyItemStatus(j16, j17, str2, 6000, i3, null, 0, null);
        }

        FileManagerEntity u(long j3) {
            if (this.f206781d.containsKey(Long.valueOf(j3))) {
                return this.f206781d.get(Long.valueOf(j3));
            }
            if (QQFileTempUtilsImpl.this.getApp() != null) {
                FileManagerEntity C = ((QQAppInterface) QQFileTempUtilsImpl.this.getApp()).getFileManagerDataCenter().C(j3, AppConstants.DATALINE_PC_UIN, 6000, -1L);
                this.f206781d.put(Long.valueOf(j3), C);
                return C;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FMDialogUtil.c f206783a;

        c(FMDialogUtil.c cVar) {
            this.f206783a = cVar;
        }

        @Override // com.tencent.mobileqq.vip.d.b
        public void callback(int i3) {
            if (i3 != 1 && i3 != 2) {
                this.f206783a.a();
            } else {
                this.f206783a.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FMDialogUtil.c f206785a;

        d(FMDialogUtil.c cVar) {
            this.f206785a = cVar;
        }

        @Override // com.tencent.mobileqq.vip.d.b
        public void callback(int i3) {
            if (i3 != 1 && i3 != 2) {
                this.f206785a.a();
            } else {
                this.f206785a.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQFileTempUtils.a f206787a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f206788b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f206789c;

        e(IQQFileTempUtils.a aVar, Activity activity, int i3) {
            this.f206787a = aVar;
            this.f206788b = activity;
            this.f206789c = i3;
        }

        @Override // com.tencent.mobileqq.vip.d.b
        public void callback(int i3) {
            if (i3 == 1 || i3 == 2) {
                this.f206787a.a(this.f206788b, this.f206789c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ah.f f206791d;

        f(ah.f fVar) {
            this.f206791d = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ah.f fVar = this.f206791d;
            if (fVar != null) {
                fVar.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private String fixDocUrl(String str) {
        Uri parse = Uri.parse(str);
        String path = parse.getPath();
        int indexOf = path.indexOf(ContainerUtils.FIELD_DELIMITER);
        if (indexOf > -1) {
            return new Uri.Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(path.substring(0, indexOf)).query(parse.getQuery()).fragment(parse.getFragment()).toString();
        }
        return str;
    }

    private FileManagerEntity getweiyunFileEntity(QQAppInterface qQAppInterface, WeiYunFileInfo weiYunFileInfo) {
        FileManagerEntity c16 = qQAppInterface.getFileManagerRSCenter().c(weiYunFileInfo.f209603d);
        if (c16 != null) {
            return c16;
        }
        FileManagerEntity H = qQAppInterface.getFileManagerDataCenter().H(weiYunFileInfo.f209603d);
        if (H != null) {
            return H;
        }
        return FileManagerUtil.newEntityByWeiYunFileInfo(weiYunFileInfo);
    }

    private void openTroopVideo(QQAppInterface qQAppInterface, Context context, FileManagerEntity fileManagerEntity, boolean z16, String str, View view) {
        dc1.b commonFileBrowserParams = getCommonFileBrowserParams(qQAppInterface, context, fileManagerEntity, 10001);
        Bundle bundle = new Bundle();
        bundle.putBoolean("from_qlink_enter_recent", z16);
        if (str != null && str.trim().length() != 0) {
            bundle.putString("c2c_discussion_recentfile", str);
        }
        commonFileBrowserParams.x(bundle);
        new dc1.d(context, commonFileBrowserParams).m(7);
        g gVar = new g(qQAppInterface, str, fileManagerEntity);
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        eVar.g(com.tencent.mobileqq.richmedia.depend.f.class.getName(), gVar);
        eVar.g(com.tencent.mobileqq.richmedia.depend.d.class.getName(), gVar);
        eVar.g(com.tencent.mobileqq.richmedia.depend.a.class.getName(), gVar);
        browserRichMedia(new ImageView(context), gVar.p(), gVar.s(), new Bundle());
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void addDatalineObserver() {
        if (this.mDataLineObserver != null) {
            return;
        }
        this.mDataLineObserver = new b();
        getApp().addObserver(this.mDataLineObserver);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void addObserver(FMObserver fMObserver) {
        if (getApp() != null) {
            ((QQAppInterface) getApp()).getFileManagerNotifyCenter().addObserver(fMObserver);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean bShowFlowDialog(FileManagerEntity fileManagerEntity, boolean z16) {
        return kc1.a.c(fileManagerEntity).c(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void browseFlashTransferFile(BaseQQAppInterface baseQQAppInterface, Context context, List<FileManagerEntity> list, int i3, int i16, String str) {
        int i17;
        FileManagerEntity fileManagerEntity = list.get(i3);
        if (fileManagerEntity.cloudType != 3 && !TextUtils.isEmpty(str) && !((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).isTencentDocFileSizeExceeded(fileManagerEntity.nFileType, fileManagerEntity.fileSize)) {
            String str2 = "https://qfile.qq.com/doc-preview?" + fileManagerEntity.Uuid + "&fileType=" + str;
            if (this.mTroopDocsQIPCModuleListener != null) {
                com.tencent.mobileqq.filemanager.app.k.c().d(this.mTroopDocsQIPCModuleListener);
                this.mTroopDocsQIPCModuleListener = null;
            }
            this.mTroopDocsQIPCModuleListener = new j((Activity) context, true);
            com.tencent.mobileqq.filemanager.app.k.c().b(this.mTroopDocsQIPCModuleListener);
            QQAppInterface qQAppInterface = (QQAppInterface) baseQQAppInterface;
            t o16 = TroopFileUtils.o(qQAppInterface, fileManagerEntity, true);
            if (o16 == null) {
                o16 = TroopFileUtils.k(qQAppInterface, fileManagerEntity.TroopUin, fileManagerEntity.strTroopFileID, fileManagerEntity.strTroopFilePath, fileManagerEntity.fileName, fileManagerEntity.fileSize, fileManagerEntity.busId);
            }
            bb.s(qQAppInterface, context, o16, -1, 0, fileManagerEntity.lastTime, fileManagerEntity.selfUin.toString(), true, false, fileManagerEntity.bSend, fileManagerEntity.TroopUin, 0, fileManagerEntity.strFileMd5, fileManagerEntity.nSessionId, fileManagerEntity.cloudType, fileManagerEntity.nOpType, str2);
            return;
        }
        QQAppInterface qQAppInterface2 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        int i18 = fileManagerEntity.nFileType;
        if (i18 != 0 && i18 != 2) {
            com.tencent.mobileqq.filemanager.openbrowser.d dVar = new com.tencent.mobileqq.filemanager.openbrowser.d(qQAppInterface2, fileManagerEntity);
            com.tencent.mobileqq.filemanager.openbrowser.c cVar = new com.tencent.mobileqq.filemanager.openbrowser.c();
            cVar.e(i16);
            Bundle bundle = new Bundle();
            if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strFilePath)) {
                i17 = 4;
            } else {
                i17 = 0;
            }
            bundle.putString("file_status", String.valueOf(i17));
            dVar.S(bundle);
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(context, dVar, cVar);
            return;
        }
        FlashTransferMediaFileBrowseProcessor flashTransferMediaFileBrowseProcessor = new FlashTransferMediaFileBrowseProcessor(qQAppInterface2, list, i3);
        ImageView imageView = new ImageView(context);
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        eVar.g(com.tencent.mobileqq.richmedia.depend.f.class.getName(), flashTransferMediaFileBrowseProcessor);
        eVar.g(com.tencent.mobileqq.richmedia.depend.d.class.getName(), flashTransferMediaFileBrowseProcessor);
        eVar.g(com.tencent.mobileqq.richmedia.depend.a.class.getName(), flashTransferMediaFileBrowseProcessor);
        eVar.g(com.tencent.mobileqq.richmedia.depend.e.class.getName(), flashTransferMediaFileBrowseProcessor);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("is_share_to_wx", true);
        browserRichMedia(imageView, flashTransferMediaFileBrowseProcessor.p(), flashTransferMediaFileBrowseProcessor.s(), bundle2);
    }

    public void browserRichMedia(ImageView imageView, int i3, List<RFWLayerItemMediaInfo> list, Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        if (i3 < list.size()) {
            arrayList.add(list.get(i3));
            com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
            eVar.j(list);
            eVar.i(i3);
            RFWLayerLaunchUtil.jumpToGallery(imageView, arrayList, 0, QQGalleryActivity.class, FilePreviewLayerFragment.class, bundle);
            return;
        }
        QLog.i(TAG, 1, "browserRichMedia exception: index=" + i3 + ", dataList size=" + arrayList.size());
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void cancelDatalineFile(FileManagerEntity fileManagerEntity) {
        getDatalineHandler().j3(0, fileManagerEntity.uniseq, false);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void changeKingCardWording(QQCustomDialog qQCustomDialog, Context context, CharSequence charSequence) {
        if (KingCardProcessor.get().group.enable && !TMSManager.e().h()) {
            qQCustomDialog.setMessageWithoutAutoLink(KingCardProcessor.get().group.appendKingcardString(context, charSequence));
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean checkEnds(String str, String[] strArr) {
        return com.tencent.open.pcpush.a.a(str, strArr);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean checkFileWithCUKingCardHelper(Activity activity, int i3, IQQFileTempUtils.a aVar) {
        return com.tencent.mobileqq.vip.d.i(activity, 2, new e(aVar, activity, i3), "");
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean checkFileWithFreeWifiHelper(Activity activity, int i3, IQQFileTempUtils.a aVar) {
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean checkNotifyDeviceOnline(BaseQQAppInterface baseQQAppInterface) {
        DataLineHandler dataLineHandler = (DataLineHandler) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        boolean C3 = dataLineHandler.C3();
        boolean z36 = dataLineHandler.z3();
        if (C3 && z36) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean checkStatusToResume(Activity activity, BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        int i3 = fileManagerEntity.status;
        if (i3 == 0 || i3 == 3) {
            if (((activity instanceof ChatActivity) || (activity instanceof SplashActivity)) && !fileManagerEntity.bSend) {
                ((QQAppInterface) baseQQAppInterface).getFileManagerEngine().o0(fileManagerEntity.nSessionId);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean checkWifiWithCUKingCardHelper(boolean z16, Activity activity, FMDialogUtil.c cVar) {
        int i3;
        if (z16) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        return com.tencent.mobileqq.vip.d.i(activity, i3, new d(cVar), "");
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean checkWifiWithFreeWifiHelper(boolean z16, Activity activity, FMDialogUtil.c cVar) {
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void clearAllData(BaseQQAppInterface baseQQAppInterface) {
        ((QQAppInterface) baseQQAppInterface).getFileManagerProxy().k();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public qb1.b createFileAssistantExt() {
        return new com.tencent.mobileqq.filemanager.api.impl.f();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public URL createFilePicDrawlableURLWithSend(FileManagerEntity fileManagerEntity) {
        return FilePicURLDrawlableHelper.d(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public ForwardFileInfo createForwardFileInfo(FileManagerEntity fileManagerEntity) {
        return ForwardFileOption.U(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void createShortcut(BaseQQAppInterface baseQQAppInterface, Intent intent, String str, Bitmap bitmap) {
        QQUtils.c((QQAppInterface) baseQQAppInterface, intent, str, bitmap);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void createThumbWithOrig(FileManagerEntity fileManagerEntity) {
        FilePicURLDrawlableHelper.j(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public Bitmap decodeFileWithBufferedStream(String str, BitmapFactory.Options options) {
        return FilePicURLDrawlableHelper.m(str, options);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean deleteFile(String str) {
        return q.d(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void deleteObserver(FMObserver fMObserver) {
        if (getApp() != null) {
            ((QQAppInterface) getApp()).getFileManagerNotifyCenter().deleteObserver(fMObserver);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void deleteOfflineFile(BaseQQAppInterface baseQQAppInterface, String str, String str2, String str3, String str4, boolean z16) {
        ((QQAppInterface) baseQQAppInterface).getFileManagerEngine().j(str, str2, str3, str4, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void doJumpAction(Context context, String str) {
        ax c16 = bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), context, str);
        if (c16 != null) {
            c16.b();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void doWithWifiChecked(FileManagerEntity fileManagerEntity, boolean z16, Context context, FMDialogUtil.c cVar) {
        kc1.a.c(fileManagerEntity).d(z16, context, cVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String downLoadDiscThumb(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity, int i3) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerEngine().m(fileManagerEntity, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void downloadDatalineFile(FileManagerEntity fileManagerEntity) {
        DataLineHandler datalineHandler = getDatalineHandler();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(fileManagerEntity.uniseq));
        if (!datalineHandler.c4(arrayList)) {
            com.tencent.mobileqq.filemanager.util.d.e(R.string.b_n);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String downloadDiscVideoThumb(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerEngine().o(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String downloadOfflineVideoThumb(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerEngine().p(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public int dp2px(int i3, Resources resources) {
        return BaseAIOUtils.f(i3, resources);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean favBuilderNewFile(Activity activity, String str) {
        return QfavBuilder.Y().x((QQAppInterface) getApp(), activity, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean favBuilderNewLink(Activity activity, String str) {
        String currentUin = getApp().getCurrentUin();
        return QfavBuilder.a0(str).F(currentUin).h(activity, currentUin);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public ContentValues favUtilhandleFileEntry(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity, String str, boolean z16) {
        return QfavUtil.x(baseQQAppInterface, fileManagerEntity, str, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public ContentValues favUtilhandleWeiyunFile(WeiYunFileInfo weiYunFileInfo) {
        return QfavUtil.y(weiYunFileInfo);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String formatNewRefreshTime(long j3) {
        return ap.a(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void forwardFile(Activity activity, FileManagerEntity fileManagerEntity) {
        QFileUtils.y((QQAppInterface) getApp(), activity, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void forwardFileDirect(Activity activity, FileManagerEntity fileManagerEntity, String str, int i3) {
        QFileUtils.z((QQAppInterface) getApp(), activity, fileManagerEntity, true, str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean forwardFileManagerEntity(FileManagerEntity fileManagerEntity) {
        return getDatalineHandler().y3().c(fileManagerEntity);
    }

    public BaseQQAppInterface getApp() {
        return ah.W();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public Intent getChatActivityIntent(Context context) {
        Intent intent = new Intent();
        if (!h.o()) {
            QLog.d("QfileAssistant", 1, "QQfileTempUtilsImpl.getChatActivityIntent error: ", new Exception());
            intent.setClass(context, LiteActivity.class);
            return intent;
        }
        intent.setClassName(context, ChatActivity.class.getName());
        return BaseAIOUtils.m(intent, new int[]{1});
    }

    public dc1.b getCommonFileBrowserParams(QQAppInterface qQAppInterface, Context context, FileManagerEntity fileManagerEntity, int i3) {
        return new dc1.b((QQAppInterface) getApp(), context, fileManagerEntity, i3);
    }

    public DataLineHandler getDatalineHandler() {
        return (DataLineHandler) getApp().getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public int getDefaultTarget(BaseQQAppInterface baseQQAppInterface) {
        return ((DataLineHandler) ((QQAppInterface) baseQQAppInterface).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).x3();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public URLDrawable getDrawable(URL url) {
        return URLDrawableHelper.getDrawable(url);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public long getDuration(String str) {
        return ShortVideoUtils.getDuration(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public int getExifRotation(String str) {
        return URLDrawableHelper.getExifRotation(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getExtension(String str) {
        return q.j(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public ArrayList<FavFileInfo> getFavFiles() {
        return ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getFavFiles();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getFileDirectoryOf(String str) {
        return q.k(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public FileManagerEntity getFileEntityByUniseq(BaseQQAppInterface baseQQAppInterface, long j3, String str, int i3) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().i(j3, str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public int[] getFileMediaInfo(String str) {
        int fileType = FileManagerUtil.getFileType(str);
        if (fileType == 0) {
            if (FileUtils.fileExistsAndNotEmpty(str)) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                FilePicURLDrawlableHelper.m(str, options);
                int exifRotation = URLDrawableHelper.getExifRotation(str);
                if (exifRotation != 90 && exifRotation != 270) {
                    return new int[]{options.outWidth, options.outHeight, 0};
                }
                return new int[]{options.outHeight, options.outWidth, 0};
            }
            return new int[]{0, 0, 0};
        }
        if (fileType == 2) {
            int[] videoFileRtAndTime = ShortVideoUtils.getVideoFileRtAndTime(str);
            return new int[]{videoFileRtAndTime[0], videoFileRtAndTime[1], videoFileRtAndTime[2]};
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public long getFileSize(String str) {
        return q.m(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public ArrayList<FileInfo> getFiles(String str, boolean z16, int i3) {
        return q.n(str, z16, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public int getForwardId() {
        return com.tencent.mobileqq.activity.aio.forward.b.d().c();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public int getForwardUtilsForwardTypeFILE() {
        return 0;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public int getFromStatisticAssist(Context context, String str, String str2) {
        return s.b(context, str, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getHistoryGroupByTime(long j3) {
        return ap.c(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public int getImageDegree(String str) {
        return n0.b.a(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public Bitmap getImageThumbnail(String str, int i3, int i16) {
        return n0.b.b(str, i3, i16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public Intent getIntentForFileBrowserActivity(Activity activity) {
        return new Intent(activity, (Class<?>) FileBrowserActivity.class);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean getIsOnline(BaseQQAppInterface baseQQAppInterface) {
        return ((RegisterProxySvcPackHandler) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).K2(1);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean getIsQRing() {
        return JumpShareUtils.isQRing;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getJumpActivityName() {
        return JumpActivity.class.getName();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public int getMsfConnectedNetType() {
        return BaseApplicationImpl.sApplication.getMsfConnectedNetType();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public com.tencent.mobileqq.service.message.e getMsgCache(BaseQQAppInterface baseQQAppInterface) {
        return ((QQAppInterface) baseQQAppInterface).getMsgCache();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public List<MessageRecord> getMsgList(BaseQQAppInterface baseQQAppInterface, String str, int i3) {
        return ((QQAppInterface) baseQQAppInterface).getMessageFacade().Q(str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getMultiMsgConstantEXTRAKEYOUTESTUIN() {
        return "outest_uin";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getMultiMsgConstantEXTRAKEYOUTESTUINTYPE() {
        return "outest_uintype";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getMultiMsgConstantEXTRAKEYOUTESTUNISEQ() {
        return "outest_uniseq";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public int getNetWorkType(Context context) {
        return com.tencent.wstt.SSCM.c.b(context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getNickByDiscussionManager(BaseQQAppInterface baseQQAppInterface, String str) {
        String str2;
        DiscussionInfo h16 = ((n) ((QQAppInterface) baseQQAppInterface).getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(String.valueOf(str));
        if (h16 != null && (str2 = h16.discussionName) != null) {
            if (str2 != null && str2.length() > 14) {
                return h16.discussionName;
            }
            return h16.discussionName;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getNickName(BaseQQAppInterface baseQQAppInterface, String str, int i3) {
        return ac.R((QQAppInterface) baseQQAppInterface, str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public MessageRecord getPrimaryStructMsg(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        return i.f((QQAppInterface) baseQQAppInterface, messageRecord);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public long getProgress(BaseQQAppInterface baseQQAppInterface, String str, long j3, long j16, int i3) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerRSCenter().a(str, j3, j16, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public Pair<StringBuilder, StringBuilder> getQRCodeResult(Context context, File file) {
        return JumpShareUtils.getQRCodeResult(context, file);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getSUNIFORMABSDKDOWNLOADCANCEL() {
        return "Stop_download_2-1_3-1";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getSUNIFORMABSDKDOWNLOADENTER() {
        return "Start_download_2-0_3-0";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getSUNIFORMABSDKDOWNLOADFAILD() {
        return "Stop_download_2-0_3-0";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getSUNIFORMABSDKDOWNLOADPAUSE() {
        return "Stop_download_2-2_3-0";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getSUNIFORMABSDKDOWNLOADRUN() {
        return "Start_download_2-3_3-0";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getSUNIFORMABSDKDOWNLOADSUCC() {
        return "Complete_download_2_0";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getSUNIFORMGENDOWNLOADCANCEL() {
        return "Stop_download_2-1_3-1";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getSUNIFORMGENDOWNLOADENTER() {
        return "Start_download_2-0_3-1";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getSUNIFORMGENDOWNLOADFAILD() {
        return "Stop_download_2-0_3-1";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getSUNIFORMGENDOWNLOADPAUSE() {
        return "Stop_download_2-2_3-1";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getSUNIFORMGENDOWNLOADRUN() {
        return "Start_download_2-3_3-1";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getSUNIFORMGENDOWNLOADSUCC() {
        return "Complete_download_2_1";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public SpannableString getSpannableString(String str, ah.f fVar, ColorStateList colorStateList, int i3, int i16) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new com.tencent.mobileqq.filemanager.widget.d(new f(fVar), colorStateList), i3, i16, 33);
        return spannableString;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public Intent getSplashActivityIntent(Context context, String str) {
        Intent aliasIntent = SplashActivity.getAliasIntent(context);
        if (!h.o()) {
            QLog.d("QfileAssistant", 1, "QQfileTempUtilsImpl.getSplashActivityIntent error: ", new Exception());
            aliasIntent.addFlags(67108864);
            aliasIntent.putExtra("uin", AppConstants.DATALINE_PC_UIN);
            aliasIntent.putExtra("uintype", 6000);
            return aliasIntent;
        }
        aliasIntent.putExtra("uin", str);
        aliasIntent.putExtra("uintype", 0);
        return BaseAIOUtils.m(aliasIntent, null);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void getTDDocFileThumbUrl(String str, String str2, qb1.e eVar) {
        TeamWorkUtils.b(str, str2, eVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public TroopInfo getTroopInfo(BaseQQAppInterface baseQQAppInterface, long j3) {
        return ((TroopManager) ((QQAppInterface) baseQQAppInterface).getManager(QQManagerFactory.TROOP_MANAGER)).k(String.valueOf(j3));
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String getVipType() {
        return ff.t((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void gotoTIMTeamworkFileUrl(Activity activity, boolean z16) {
        String e16;
        try {
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().e())) {
                e16 = "https://docs.qq.com/desktop/m/index.html?_from=1";
            } else {
                e16 = TencentDocConvertConfigProcessor.a().e();
            }
            String tencentDocSourceAdtagStrUrl = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(e16, ITeamWorkUtils.TD_SOURCE_QQ_MYFILE);
            intent.putExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_MYFILE);
            intent.putExtra("big_brother_source_key", "biz_src_jc_file");
            if (z16) {
                tencentDocSourceAdtagStrUrl = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(e16, ITeamWorkUtils.TD_SOURCE_QQ_MYFILE_BANNER);
                intent.putExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_MYFILE_BANNER);
            }
            intent.putExtra("fragment_class", ((ITeamWorkDocsListFragment) QRoute.api(ITeamWorkDocsListFragment.class)).getCanonicalName());
            if (!((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(activity, tencentDocSourceAdtagStrUrl, intent.getStringExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG))) {
                activity.startActivity(intent.putExtra("url", tencentDocSourceAdtagStrUrl));
            }
        } catch (Exception e17) {
            QLog.i(TAG, 1, e17.toString());
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean handleVipForTroopFile(Context context, boolean z16, boolean z17, final View.OnClickListener onClickListener) {
        QVipTroopFileConfig qVipTroopFileConfig = QVipTroopFileProcessor.get();
        if (qVipTroopFileConfig.isEnable()) {
            if (qVipTroopFileConfig.showAlertGuideMessage(context, new Runnable() { // from class: com.tencent.mobileqq.filemanager.api.impl.QQFileTempUtilsImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    onClickListener.onClick(null);
                }
            }, z17, ff.t((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()), z16)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean hasShortCut(Activity activity, String[] strArr) {
        return QQUtils.j(activity, strArr);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public long insertAIOGrayTips(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3, int i16, String str3) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().n(str, str2, i3, i16, str3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void insertToFMList(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().t(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void insertToMemMap(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().v(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void insertToMemMapByFileManagerProxy(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        ((QQAppInterface) baseQQAppInterface).getFileManagerProxy().x(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean isContainChinese(String str) {
        return ac.o0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean isFileExists(String str) {
        return q.p(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean isKingCard() {
        return TMSManager.e().h();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean isNeedCompressCut(FileManagerEntity fileManagerEntity) {
        return FilePicURLDrawlableHelper.t(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean isRunIWeiyunSaveTipsHelper(BaseQQAppInterface baseQQAppInterface) {
        if (BaseActivity.sTopActivity != null) {
            IWeiyunSaveTipsHelper iWeiyunSaveTipsHelper = (IWeiyunSaveTipsHelper) QRoute.api(IWeiyunSaveTipsHelper.class);
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            iWeiyunSaveTipsHelper.showTopTips(baseQQAppInterface, baseActivity, baseActivity.getTitleBarHeight());
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean isShowByCUKingCardHelper(Context context, boolean z16, FMDialogUtil.c cVar) {
        int i3;
        Activity activity = (Activity) context;
        if (z16) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        return com.tencent.mobileqq.vip.d.i(activity, i3, new c(cVar), "");
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean isShowByFreeWifiHelper(Context context, boolean z16, FMDialogUtil.c cVar) {
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean isUndownloadDatalineEntity(FileManagerEntity fileManagerEntity) {
        return QFileUtils.g0(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void notifyFlashTransferDownloadProgress(long j3, int i3, long j16) {
        if (getApp() != null) {
            ((QQAppInterface) getApp()).getFileManagerNotifyCenter().b(true, 57, new Object[]{Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16)});
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void notifyFlashTransferDownloadResult(long j3, boolean z16, String str) {
        if (getApp() != null) {
            ((QQAppInterface) getApp()).getFileManagerNotifyCenter().b(true, 56, new Object[]{Long.valueOf(j3), Boolean.valueOf(z16), str});
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void notifyItemStatus(long j3, long j16, String str, int i3, int i16, Object obj, int i17, String str2) {
        ((QQAppInterface) getApp()).getFileManagerNotifyCenter().c(j3, j16, str, i3, i16, obj, i17, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void notifyUpdateRecentFileAssistant(BaseQQAppInterface baseQQAppInterface) {
        RecentUserProxy recentUserProxy = ((QQAppInterface) baseQQAppInterface).getRecentUserProxy();
        RecentUser findRecentUserByUin = recentUserProxy.findRecentUserByUin(h.g(baseQQAppInterface), 0);
        findRecentUserByUin.lastmsgtime = com.tencent.mobileqq.service.message.e.K0();
        recentUserProxy.saveRecentUser(findRecentUserByUin);
        MqqHandler handler = baseQQAppInterface.getHandler(Conversation.class);
        if (handler != null) {
            handler.sendEmptyMessage(1009);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void onResultByDataLineHandler(boolean z16, long j3, int i3, String str, BaseQQAppInterface baseQQAppInterface, int i16) {
        FileManagerEntity D;
        DataLineHandler dataLineHandler = (DataLineHandler) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        if (!z16) {
            dataLineHandler.OnSessionComplete(j3, 41, i3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            dataLineHandler.OnSessionComplete(j3, 0, i3);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) baseQQAppInterface;
        DataLineMsgRecord d16 = qQAppInterface.getMessageFacade().t1(i16).d(j3);
        if (d16 == null) {
            return;
        }
        d16.serverPath = str;
        d16.nOpType = 1;
        d16.bIsSended = true;
        d16.bIsTransfering = false;
        if (d16.entityID != 0 && (D = qQAppInterface.getFileManagerDataCenter().D(d16.entityID)) != null) {
            D.status = 1;
            D.Uuid = d16.serverPath;
        }
        if (dataLineHandler.k3(d16)) {
            dataLineHandler.v4(d16);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void openAIO(Context context, Intent intent) {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(context), new int[]{2});
        m3.putExtras(new Bundle(intent.getExtras()));
        context.startActivity(m3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void openFavorite(Activity activity, String str, long j3) {
        QfavHelper.u(activity, str, j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void openFileBrowserByFileInfo(Context context, FileInfo fileInfo, int i3, String str, View view) {
        FileManagerEntity newEntityByLocalFileInfo = FileManagerUtil.newEntityByLocalFileInfo(fileInfo);
        newEntityByLocalFileInfo.nFileType = i3;
        newEntityByLocalFileInfo.setFilePath(str);
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (i3 != 0 && i3 != 2) {
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(context, new com.tencent.mobileqq.filemanager.openbrowser.d(qQAppInterface, newEntityByLocalFileInfo), new com.tencent.mobileqq.filemanager.openbrowser.c().d(8));
            return;
        }
        com.tencent.mobileqq.filemanager.openbrowser.e eVar = new com.tencent.mobileqq.filemanager.openbrowser.e(qQAppInterface, newEntityByLocalFileInfo);
        ImageView imageView = new ImageView(context);
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        }
        com.tencent.mobileqq.richmedia.e eVar2 = com.tencent.mobileqq.richmedia.e.f281568a;
        eVar2.g(com.tencent.mobileqq.richmedia.depend.f.class.getName(), eVar);
        eVar2.g(com.tencent.mobileqq.richmedia.depend.d.class.getName(), eVar);
        eVar2.g(com.tencent.mobileqq.richmedia.depend.a.class.getName(), eVar);
        browserRichMedia(imageView, eVar.p(), eVar.s(), new Bundle());
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void openLocalFileViewBrowser(Activity activity, LinkedHashMap<String, List<FileInfo>> linkedHashMap, FileInfo fileInfo, View view, FileManagerEntity fileManagerEntity) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        int i3 = fileManagerEntity.nFileType;
        if (i3 != 0 && i3 != 2) {
            com.tencent.mobileqq.filemanager.openbrowser.d dVar = new com.tencent.mobileqq.filemanager.openbrowser.d(qQAppInterface, fileManagerEntity);
            com.tencent.mobileqq.filemanager.openbrowser.c d16 = new com.tencent.mobileqq.filemanager.openbrowser.c().d(8);
            if (activity.getIntent().getBooleanExtra("from_aio", false)) {
                d16.e(4);
            } else {
                d16.e(2);
            }
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(activity, dVar, d16);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (linkedHashMap != null) {
            Iterator<String> it = linkedHashMap.keySet().iterator();
            while (it.hasNext()) {
                arrayList.addAll(linkedHashMap.get(it.next()));
            }
        }
        com.tencent.mobileqq.filemanager.openbrowser.e eVar = new com.tencent.mobileqq.filemanager.openbrowser.e(qQAppInterface, arrayList, fileInfo);
        ImageView imageView = new ImageView(activity);
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        }
        com.tencent.mobileqq.richmedia.e eVar2 = com.tencent.mobileqq.richmedia.e.f281568a;
        eVar2.g(com.tencent.mobileqq.richmedia.depend.f.class.getName(), eVar);
        eVar2.g(com.tencent.mobileqq.richmedia.depend.d.class.getName(), eVar);
        eVar2.g(com.tencent.mobileqq.richmedia.depend.a.class.getName(), eVar);
        browserRichMedia(imageView, eVar.p(), eVar.s(), new Bundle());
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void openQQBrowserWithoutAD(Context context, String str) {
        VasWebviewUtil.openQQBrowserWithoutAD(context, str, -1L, null, false, 0);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void openRencentFileBrowser(Activity activity, ForwardFileInfo forwardFileInfo) {
        Intent intent = new Intent(activity, (Class<?>) FileBrowserActivity.class);
        intent.putExtra("fileinfo", forwardFileInfo);
        activity.startActivityForResult(intent, 102);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void openRencentFileBrowserOnItemClick(BaseQQAppInterface baseQQAppInterface, Context context, FileManagerEntity fileManagerEntity, boolean z16, String str, View view, boolean z17, boolean z18, int i3) {
        int i16;
        if (fileManagerEntity.nFileType == 13 && !TextUtils.isEmpty(fileManagerEntity.Uuid)) {
            String fixDocUrl = fixDocUrl(fileManagerEntity.Uuid);
            if (z17) {
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).clickWebTDDocAndUpdateTitle(fixDocUrl, context, 3, fileManagerEntity, (QQAppInterface) baseQQAppInterface);
                return;
            } else if (z18) {
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).clickWebTDDocAndUpdateTitle(fixDocUrl, context, 20, fileManagerEntity, (QQAppInterface) baseQQAppInterface);
                return;
            } else {
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).clickWebTDDocAndUpdateTitle(fixDocUrl, context, 21, fileManagerEntity, (QQAppInterface) baseQQAppInterface);
                return;
            }
        }
        if (fileManagerEntity.nFileType == 2 && !FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
            if (fileManagerEntity.isSend() && (i16 = fileManagerEntity.status) != 1 && i16 != -1) {
                com.tencent.mobileqq.filemanager.util.d.f(HardCodeUtil.qqStr(R.string.zyu));
                return;
            }
            if (!NetworkUtil.isNetSupport(baseQQAppInterface.getApplicationContext())) {
                com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
                return;
            }
            int i17 = fileManagerEntity.peerType;
            if (i17 != 0 && i17 != 3000) {
                dc1.b commonFileBrowserParams = getCommonFileBrowserParams((QQAppInterface) baseQQAppInterface, context, fileManagerEntity, 10001);
                Bundle bundle = new Bundle();
                bundle.putBoolean("from_qlink_enter_recent", z16);
                if (str != null && str.trim().length() != 0) {
                    bundle.putString("c2c_discussion_recentfile", str);
                }
                commonFileBrowserParams.x(bundle);
                dc1.d dVar = new dc1.d(context, commonFileBrowserParams);
                dVar.m(7);
                dVar.d();
                return;
            }
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (fileManagerEntity.nFileType == 2 && fileManagerEntity.peerType == 1 && !QFileUtils.e0(qQAppInterface)) {
            openTroopVideo(qQAppInterface, context, fileManagerEntity, z16, str, view);
            return;
        }
        int i18 = fileManagerEntity.nFileType;
        if (i18 != 0 && i18 != 2) {
            if (fileManagerEntity.cloudType == 14 && PackageUtil.isAppInstalled(context, fileManagerEntity.yybApkName) && fileManagerEntity.status == 1) {
                PackageUtil.startAppWithPkgName(context, fileManagerEntity.yybApkName, null, "biz_src_jc_file", 0);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("from_qlink_enter_recent", z16);
            if (str != null && str.trim().length() != 0) {
                bundle2.putString("c2c_discussion_recentfile", str);
            }
            com.tencent.mobileqq.filemanager.openbrowser.d dVar2 = new com.tencent.mobileqq.filemanager.openbrowser.d(qQAppInterface, fileManagerEntity);
            dVar2.S(bundle2);
            com.tencent.mobileqq.filemanager.openbrowser.c h16 = new com.tencent.mobileqq.filemanager.openbrowser.c().d(7).h(str);
            h16.e(i3);
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(context, dVar2, h16);
            return;
        }
        g gVar = new g(qQAppInterface, str, fileManagerEntity);
        ImageView imageView = new ImageView(context);
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        }
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        eVar.g(com.tencent.mobileqq.richmedia.depend.f.class.getName(), gVar);
        eVar.g(com.tencent.mobileqq.richmedia.depend.d.class.getName(), gVar);
        eVar.g(com.tencent.mobileqq.richmedia.depend.a.class.getName(), gVar);
        browserRichMedia(imageView, gVar.p(), gVar.s(), new Bundle());
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void openTroopFilerDetailBrowse(Activity activity, ForwardFileInfo forwardFileInfo) {
        Intent intent = new Intent();
        intent.setClass(activity, TroopFileDetailBrowserActivity.class);
        intent.putExtra("fileinfo", forwardFileInfo);
        intent.putExtra("removemementity", true);
        intent.putExtra(AppConstants.Key.FORWARD_FROM_TROOP_FILE, true);
        intent.putExtra("not_forward", true);
        intent.putExtra("last_time", 0);
        activity.startActivityForResult(intent, 102);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void openWeiYunFileBrowser(Context context, ArrayList<WeiYunFileInfo> arrayList, WeiYunFileInfo weiYunFileInfo) {
        QQAppInterface qQAppInterface = (QQAppInterface) getApp();
        int fileType = FileManagerUtil.getFileType(weiYunFileInfo.f209605f);
        if (fileType != 0 && fileType != 2) {
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(context, new com.tencent.mobileqq.filemanager.openbrowser.d(qQAppInterface, getweiyunFileEntity(qQAppInterface, weiYunFileInfo)), new com.tencent.mobileqq.filemanager.openbrowser.c().d(9));
            return;
        }
        g gVar = new g(qQAppInterface, arrayList, weiYunFileInfo);
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        eVar.g(com.tencent.mobileqq.richmedia.depend.f.class.getName(), gVar);
        eVar.g(com.tencent.mobileqq.richmedia.depend.d.class.getName(), gVar);
        eVar.g(com.tencent.mobileqq.richmedia.depend.a.class.getName(), gVar);
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_share_to_wx", true);
        browserRichMedia(new ImageView(context), gVar.p(), gVar.s(), bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public long prepareForwardByDataLineMsgRecord(String str, int i3, String str2, int i16, String str3, String str4, String str5, long j3, int i17, BaseQQAppInterface baseQQAppInterface, int i18) {
        DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
        dataLineMsgRecord.fileUuid = str3;
        if (str2 != null) {
            dataLineMsgRecord.uOwnerUin = Long.valueOf(str2).longValue();
        }
        dataLineMsgRecord.selfuin = str;
        dataLineMsgRecord.filename = str4;
        if (str5 != null) {
            String a16 = q.a(q.o(baseQQAppInterface.getApplication()), ah.h0(str5));
            dataLineMsgRecord.thumbPath = a16;
            FileUtils.copyFile(str5, a16);
        }
        dataLineMsgRecord.filesize = j3;
        dataLineMsgRecord.busId = i16;
        dataLineMsgRecord.forwardTroopFileEntrance = i17;
        if (i3 == 0) {
            dataLineMsgRecord.fileFrom = 1;
            dataLineMsgRecord.nOpType = 29;
        } else {
            dataLineMsgRecord.fileFrom = 2;
            dataLineMsgRecord.nOpType = 31;
        }
        dataLineMsgRecord.istroop = i3;
        DataLineHandler dataLineHandler = (DataLineHandler) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        dataLineMsgRecord.sessionid = dataLineHandler.u3(0, i18).longValue();
        dataLineMsgRecord.f203106msg = "";
        dataLineMsgRecord.issend = 1;
        dataLineMsgRecord.isread = true;
        dataLineMsgRecord.issuc = false;
        ((SVIPHandler) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(dataLineMsgRecord);
        dataLineMsgRecord.time = com.tencent.mobileqq.service.message.e.K0();
        dataLineMsgRecord.progress = 0.2f;
        dataLineMsgRecord.fileMsgStatus = 0L;
        dataLineMsgRecord.msgtype = DataLineHandler.C4(0);
        dataLineMsgRecord.bIsTransfering = true;
        ((QQAppInterface) baseQQAppInterface).getMessageFacade().t1(i18).a(dataLineMsgRecord, true);
        Boolean bool = Boolean.FALSE;
        dataLineHandler.N3(7, true, new Object[]{0L, Long.valueOf(dataLineMsgRecord.sessionid), dataLineMsgRecord.path, Byte.valueOf((byte) DataLineHandler.D4(dataLineMsgRecord.msgtype)), bool, bool, Long.valueOf(dataLineMsgRecord.filesize)});
        return dataLineMsgRecord.sessionid;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void previewFavImageFile(Activity activity) {
        FileManagerUtil.previewFavImageFile(activity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void previewImage(Activity activity, FileManagerEntity fileManagerEntity, boolean z16) {
        FileManagerUtil.previewImage(activity, fileManagerEntity, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public FileManagerEntity queryFileEntityBySessionId(BaseQQAppInterface baseQQAppInterface, long j3) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().D(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public FileManagerEntity queryFileEntityByUniseq(BaseQQAppInterface baseQQAppInterface, long j3, String str, int i3) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().E(j3, str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public List<FileManagerEntity> queryFileManagerEntityByNameAndSize(BaseQQAppInterface baseQQAppInterface, String str, long j3) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().I(str, j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public FileManagerEntity queryFileManagerEntityBySessionId(BaseQQAppInterface baseQQAppInterface, long j3) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().M(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public FileManagerEntity queryFileManagerEntityByWeiYunFileIdForMemory(BaseQQAppInterface baseQQAppInterface, String str) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().O(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public List<FileManagerEntity> queryMaxRecentReocrds(BaseQQAppInterface baseQQAppInterface) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerProxy().S();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void removeDatalineObserver() {
        if (this.mDataLineObserver != null) {
            getApp().removeObserver(this.mDataLineObserver);
            this.mDataLineObserver = null;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void reportAppStoreDownloadSuc() {
        QFileAppStorePromoteManager.m();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public ArrayList<String> reqDnsForIpList(String str, boolean z16, int i3) {
        return InnerDns.getInstance().reqDnsForIpList(str, 1019, z16, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void resetFileAssistantOnlineMark(BaseQQAppInterface baseQQAppInterface) {
        DataLineHandler dataLineHandler = (DataLineHandler) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        dataLineHandler.A4(false);
        dataLineHandler.y4(false);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void resumeByFileManagerEngine(BaseQQAppInterface baseQQAppInterface, long j3) {
        ((QQAppInterface) baseQQAppInterface).getFileManagerEngine().o0(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public FileManagerEntity saveOfflineFile2WeiYun(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity, String str) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerEngine().v0(fileManagerEntity, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void sendFavFiles(ArrayList<FavFileInfo> arrayList, String str, int i3, Bundle bundle) {
        ((QQAppInterface) getApp()).getFileManagerEngine().W().sendFavFiles(arrayList, str, "", i3, bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void sendFileToDataline(BaseQQAppInterface baseQQAppInterface, Context context, FileManagerEntity fileManagerEntity) {
        QFileUtils.l0((QQAppInterface) baseQQAppInterface, context, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void sendFiles(ArrayList<FileInfo> arrayList) {
        getDatalineHandler().sendFiles(arrayList);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void sendFilesWithService(ArrayList<FileInfo> arrayList, String str, byte[] bArr, long j3) {
        ((RouterHandler) getApp().getBusinessHandler(BusinessHandlerFactory.ROUTER_HANDLER)).sendFilesWithService(arrayList, str, bArr, j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public FileManagerEntity sendLocalFile(BaseQQAppInterface baseQQAppInterface, String str, String str2, String str3, int i3, boolean z16) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerEngine().F0(str, str2, str3, "", i3, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void sendLocalFileToGuild(BaseQQAppInterface baseQQAppInterface, String str, String str2, Set<FileInfo> set) {
        ((QQAppInterface) baseQQAppInterface).getFileManagerEngine().M0(str, str2, set);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void sendQlinkFiles(Activity activity, String str, ArrayList<String> arrayList, int i3) {
        if (222 == i3) {
            activity.getIntent().putExtra("string_filepaths", arrayList);
            activity.setResult(-1, activity.getIntent());
            return;
        }
        if (333 != i3 && 666 != i3 && 3333 != i3 && 6666 != i3) {
            boolean z16 = true;
            if (444 != i3 && 555 != i3) {
                if (777 != i3 && 888 != i3) {
                    if (getApp() != null) {
                        ((QQAppInterface) getApp()).getQQProxyForQlink().H(str, arrayList);
                    }
                    Intent intent = activity.getIntent();
                    intent.putExtra("_UIN_", str);
                    intent.putExtra("_SEND_QLINK_FILE_", true);
                    activity.setResult(-1, activity.getIntent());
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("string_filepaths", arrayList);
                if (getApp() != null) {
                    ((QQAppInterface) getApp()).getQQProxyForQlink();
                    QQProxyForQlink.P(activity, 16, bundle);
                    return;
                }
                return;
            }
            Intent intent2 = activity.getIntent();
            if (444 != i3) {
                z16 = false;
            }
            intent2.putExtra("_INIT_SEND_IOS_", z16);
            intent2.putExtra("string_filepaths", arrayList);
            activity.setResult(i3, activity.getIntent());
            return;
        }
        activity.getIntent().putExtra("string_filepaths", arrayList);
        activity.setResult(i3, activity.getIntent());
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public long sendTencentDocEntity(FileManagerEntity fileManagerEntity) {
        return getDatalineHandler().sendTencentDocEntity(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void sendWeiYunFile(FileManagerEntity fileManagerEntity) {
        getDatalineHandler().sendWeiYunFile(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void setDefaultTarget(BaseQQAppInterface baseQQAppInterface, int i3) {
        ((DataLineHandler) ((QQAppInterface) baseQQAppInterface).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).w4(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public String setEntityUuidByEntityManager(BaseQQAppInterface baseQQAppInterface, MessageForFile messageForFile) {
        byte[] bArr;
        EntityManager createEntityManager = baseQQAppInterface.getEntityManagerFactory().createEntityManager();
        TransFileInfo transFileInfo = (TransFileInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) TransFileInfo.class, String.valueOf(messageForFile.time), String.valueOf(messageForFile.msgseq), baseQQAppInterface.getCurrentAccountUin(), messageForFile.frienduin);
        String str = "";
        if (transFileInfo != null && (bArr = transFileInfo.uuid) != null) {
            str = new String(bArr);
        }
        createEntityManager.close();
        return str;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void setFileAssistantOnlineMark(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16) {
        DataLineHandler dataLineHandler = (DataLineHandler) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        if (i3 == 0) {
            dataLineHandler.A4(z16);
        } else if (i3 == 1) {
            dataLineHandler.y4(z16);
        } else if (i3 == 2) {
            dataLineHandler.z4(z16);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void setForwardBundle(Intent intent, Bundle bundle) {
        String string = bundle.getString("key_direct_show_uin", "");
        if (!TextUtils.isEmpty(string) && AppConstants.DATALINE_PC_UIN.equals(string)) {
            bundle.putString("key_direct_show_uin", AppConstants.DATALINE_NEW_VERSION_UIN);
            bundle.putInt("key_direct_show_uin_type", 0);
            intent.putExtra("key_direct_show_uin_type", 0);
            intent.putExtra("key_direct_show_uin", AppConstants.DATALINE_NEW_VERSION_UIN);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void setImageDegree(String str, int i3) {
        n0.b.e(str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void setStorageRptNeedScan(boolean z16) {
        StorageReport.k().A(true);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public BubblePopupWindow showAsDropDown(View view, com.tencent.mobileqq.utils.dialogutils.a aVar, View.OnClickListener onClickListener, BubblePopupWindow.OnDismissListener onDismissListener) {
        return com.tencent.mobileqq.utils.s.d(view, aVar, onClickListener, onDismissListener);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void showDeviceChoose(Context context, String str, List<FileManagerEntity> list, Set<FileInfo> set, View.OnClickListener onClickListener) {
        com.tencent.mobileqq.filemanager.fileassistant.util.b.l(list, set).b(context, str, new a(onClickListener));
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void speak(String str) {
        if (getApp() != null) {
            QQAppInterface.speak(str);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void startActivityByLinkByWeiyunFragment(Context context, FileManagerEntity fileManagerEntity, String str, boolean z16) {
        ForwardFileInfo U;
        if (fileManagerEntity == null) {
            U = null;
        } else {
            U = ForwardFileOption.U(fileManagerEntity);
        }
        LinkByWeiyunFragment.th(context, U, str, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void startAppStoreByTmast(String str, int i3) {
        QFileAppStorePromoteManager.p(str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void startChatAndSendMsg(Activity activity, Bundle bundle) {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(activity), new int[]{2});
        m3.putExtras(new Bundle(bundle));
        m3.addFlags(67108864);
        activity.startActivity(m3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void startForwardActivityForResult(Activity activity, Intent intent, int i3) {
        ForwardBaseOption.startForwardActivityForResult(activity, intent, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void startForwardByOriginFile(Activity activity, Intent intent, boolean z16) {
        intent.putExtra("k_dataline", z16);
        intent.putExtra("k_favorites", false);
        intent.putExtra("forward_type", 0);
        ForwardBaseOption.startForwardActivityForResult(activity, intent, 103);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void startSeach(Activity activity, int i3, Bundle bundle) {
        FileSearchActivity.Z2(activity, "", new ArrayList(), false, i3, "", bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void updateFileEntity(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().f0(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean uploadToWyForFreeWifi(Activity activity, View.OnClickListener onClickListener) {
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public int dp2px(float f16, Resources resources) {
        return BaseAIOUtils.f(f16, resources);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public boolean favBuilderNewFile(Activity activity, FileManagerEntity fileManagerEntity) {
        return QfavBuilder.Y().u((QQAppInterface) getApp(), activity, fileManagerEntity, null, true);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public long insertAIOGrayTips(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3, int i16, Map<String, String> map, String str3, long j3, long j16, long j17) {
        return ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().o(str, str2, i3, i16, map, str3, j3, j16, j17);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void notifyItemStatus(BaseQQAppInterface baseQQAppInterface, long j3, long j16, String str, int i3, int i16, Object obj, int i17, String str2) {
        ((QQAppInterface) baseQQAppInterface).getFileManagerNotifyCenter().c(j3, j16, str, i3, i16, obj, i17, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void sendWeiYunFile(WeiYunFileInfo weiYunFileInfo) {
        getDatalineHandler().sendWeiYunFile(weiYunFileInfo);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void startSeach(Activity activity) {
        FileSearchActivity.W2(activity, "", new ArrayList(), false, 8);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements b.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f206779a;

        a(View.OnClickListener onClickListener) {
            this.f206779a = onClickListener;
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void a() {
            this.f206779a.onClick(null);
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void b() {
            this.f206779a.onClick(null);
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void onDismiss() {
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
    public void checkPermission(AppActivity appActivity, View.OnClickListener onClickListener) {
    }
}
