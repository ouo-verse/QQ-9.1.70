package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class VasEmojiManager implements IVasEmojiManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public BaseQQAppInterface f204681a;

    /* renamed from: b, reason: collision with root package name */
    public IEmojiManagerService f204682b;

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap<String, Bundle> f204683c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.vip.f f204684d;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VasEmojiManager.this);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
                return;
            }
            super.onDone(gVar);
            IEmojiManagerService c16 = VasEmojiManager.this.c();
            Bundle h16 = gVar.h();
            if (gVar.i() != 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            c16.handleEmoticonPackageDownloaded(h16, gVar, z16, gVar.f313006d, gVar.f313026x, System.currentTimeMillis() - h16.getLong(VasEmojiManagerContstant.PARAMS_DOWNLOAD_START), 0);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                return;
            }
            Bundle h16 = gVar.h();
            int i3 = h16.getInt(gVar.f313011i);
            EmoticonPackage emoticonPackage = (EmoticonPackage) h16.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG);
            if (QLog.isColorLevel()) {
                QLog.d(IVasEmojiManager.TAG, 2, "emotionDownloadListener | onDoneFile epId=" + emoticonPackage.epId + ",task:" + gVar);
            }
            if (gVar.f313006d != 0) {
                QLog.e(IVasEmojiManager.TAG, 1, "onDoneFile : ondone error , reportCode = " + gVar.f313006d);
                if (EmojiManagerServiceConstant.isCover(i3)) {
                    ((IEmojiManagerService) VasEmojiManager.this.f204681a.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().notifyEmoticonCoverListener(emoticonPackage, i3, -1, gVar.f313006d);
                }
                VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "10", emoticonPackage.epId, "", "", gVar.f313006d + "", "", "", "");
                return;
            }
            IEmojiManagerService c16 = VasEmojiManager.this.c();
            if (EmojiManagerServiceConstant.isCover(i3)) {
                ((IEmojiManagerService) VasEmojiManager.this.f204681a.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().notifyEmoticonCoverListener(emoticonPackage, i3, 0, 0);
            } else if (i3 == 7) {
                c16.handleEmotionEncryptKey(gVar);
            }
            int i16 = emoticonPackage.jobType;
            if (i16 == 3 || i16 == 5) {
                c16.handleMagicOrH5MagicDownloadOnDoneFile(gVar);
            }
        }
    }

    public VasEmojiManager(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f204683c = new ConcurrentHashMap<>();
        this.f204684d = new a();
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appInterface;
        this.f204681a = baseQQAppInterface;
        this.f204682b = (IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class);
    }

    private void b(EmoticonPackage emoticonPackage, ArrayList<Emoticon> arrayList, boolean z16, Bundle bundle) {
        IEmojiManagerService c16 = c();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        bundle.putSerializable(EmojiManagerServiceConstant.PARAMS_EMOTICON_LIST, arrayList);
        c16.addThumbTask(arrayList2, hashMap, emoticonPackage, bundle);
        int addEmotionTaskByList = c16.addEmotionTaskByList(emoticonPackage, arrayList, arrayList2, hashMap, bundle, 6);
        if (addEmotionTaskByList != 0) {
            QLog.e(IVasEmojiManager.TAG, 1, "downloadOthers error : " + addEmotionTaskByList);
            return;
        }
        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(arrayList2, hashMap, EmojiManagerServiceConstant.KEY_PRE + emoticonPackage.epId);
        gVar.Q = true;
        if (arrayList2.size() == 0) {
            gVar.w(bundle);
            gVar.y(3);
            this.f204684d.onDone(gVar);
        } else {
            c16.getDownloader().startDownload(gVar, this.f204684d, bundle);
        }
        c16.addH5MagicChildDownloadTask(emoticonPackage, z16);
    }

    private String d(String str, String str2, String str3, File file) {
        boolean z16;
        File file2 = new File(MarketFaceConstants.emoticonJsonFilePath.replace("[epId]", str));
        if (file2.exists()) {
            z16 = file2.delete();
        } else {
            z16 = true;
        }
        if (!z16) {
            return "delete jsonFile failed.";
        }
        if (!file.renameTo(file2)) {
            return "rename tmpJsonFile failed.";
        }
        FileUtils.deleteDirectory(str2);
        File file3 = new File(str2);
        if (file3.exists()) {
            return "delete h5magic failed.";
        }
        if (!new File(str3).renameTo(file3)) {
            return "rename tmpUnzipPath failed.";
        }
        c().generateFileList(str, str2);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ca A[Catch: Exception -> 0x01d3, all -> 0x01df, TRY_LEAVE, TryCatch #1 {Exception -> 0x01d3, blocks: (B:7:0x0012, B:9:0x0059, B:13:0x0064, B:15:0x008b, B:17:0x0091, B:18:0x00b4, B:20:0x00ca, B:23:0x00e4, B:25:0x00e9, B:28:0x0105, B:30:0x010f, B:33:0x0115, B:35:0x011f, B:36:0x0137, B:43:0x014b, B:45:0x0151, B:46:0x0174, B:48:0x0178, B:52:0x01ae, B:54:0x01b4, B:57:0x01ce, B:65:0x0097), top: B:6:0x0012, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e4 A[Catch: Exception -> 0x01d3, all -> 0x01df, TRY_ENTER, TryCatch #1 {Exception -> 0x01d3, blocks: (B:7:0x0012, B:9:0x0059, B:13:0x0064, B:15:0x008b, B:17:0x0091, B:18:0x00b4, B:20:0x00ca, B:23:0x00e4, B:25:0x00e9, B:28:0x0105, B:30:0x010f, B:33:0x0115, B:35:0x011f, B:36:0x0137, B:43:0x014b, B:45:0x0151, B:46:0x0174, B:48:0x0178, B:52:0x01ae, B:54:0x01b4, B:57:0x01ce, B:65:0x0097), top: B:6:0x0012, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean e(String str, Bundle bundle, EmoticonPackage emoticonPackage) {
        byte[] bArr;
        String parseJson;
        ArrayList<Emoticon> arrayList;
        boolean z16 = bundle.getBoolean(EmojiManagerServiceConstant.PARAMS_PKG_NEW_ADD);
        String str2 = emoticonPackage.epId;
        try {
            String replace = MarketFaceConstants.H5MagicRootPath.replace("[epId]", str2);
            String replace2 = replace.replace("h5magic", "tmp_unzip");
            FileUtils.uncompressZip(str, replace2, false);
            String str3 = replace2 + "h5.zip";
            String str4 = replace2 + "h5magic";
            if (!new File(str3).exists()) {
                QLog.e(IVasEmojiManager.TAG, 1, "h5.zip is not exist");
                return false;
            }
            FileUtils.uncompressZip(str3, str4, false);
            ArrayList<Emoticon> arrayList2 = new ArrayList<>();
            ReqInfo reqInfo = new ReqInfo();
            File file = new File(replace2 + str2 + "_android.json");
            try {
            } catch (OutOfMemoryError e16) {
                QLog.e(IVasEmojiManager.TAG, 1, "OutOfMemoryError e = " + e16.getMessage());
            }
            if (file.exists()) {
                bArr = FileUtils.fileToBytes(file);
                ArrayList<Emoticon> arrayList3 = arrayList2;
                parseJson = EmotionJsonUtils.parseJson(this.f204681a, emoticonPackage, EmojiManagerServiceConstant.JSON_EMOSM_MALL, bArr, arrayList2, reqInfo);
                if (parseJson == null) {
                    QLog.e(IVasEmojiManager.TAG, 1, "parseJsonError: " + parseJson);
                    return false;
                }
                if (emoticonPackage.jobType != 5) {
                    QLog.e(IVasEmojiManager.TAG, 1, "not support jobType: " + emoticonPackage.jobType);
                    return false;
                }
                IEmojiManagerService c16 = c();
                if (!reqInfo.encryptKeysSuccess && emoticonPackage.jobType != 4) {
                    int i3 = 0;
                    while (true) {
                        reqInfo.strGetKeySeq = null;
                        if (QLog.isColorLevel()) {
                            QLog.d(IVasEmojiManager.TAG, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i3);
                        }
                        arrayList = arrayList3;
                        c16.fetchEmoticonEncryptKeys(emoticonPackage.epId, arrayList, reqInfo);
                        i3++;
                        if (reqInfo.encryptKeysSuccess || i3 >= 3) {
                            break;
                        }
                        arrayList3 = arrayList;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(IVasEmojiManager.TAG, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i3 + " encryptKeysSuccess=" + reqInfo.encryptKeysSuccess);
                    }
                    if (!reqInfo.encryptKeysSuccess) {
                        QLog.e(IVasEmojiManager.TAG, 1, "addEmoticonsTask| fetchEncryptKeys fail epId=" + emoticonPackage.epId + " encryptGetKeySeq=" + reqInfo.strGetKeySeq + " encryptKeysResultCode" + reqInfo.encryptKeysResultCode);
                        return false;
                    }
                } else {
                    arrayList = arrayList3;
                }
                String d16 = d(str2, replace, str4, file);
                if (d16 != null) {
                    QLog.e(IVasEmojiManager.TAG, 1, "moveFiles error: " + d16);
                    return false;
                }
                b(emoticonPackage, arrayList, z16, bundle);
                return true;
            }
            bArr = null;
            ArrayList<Emoticon> arrayList32 = arrayList2;
            parseJson = EmotionJsonUtils.parseJson(this.f204681a, emoticonPackage, EmojiManagerServiceConstant.JSON_EMOSM_MALL, bArr, arrayList2, reqInfo);
            if (parseJson == null) {
            }
        } catch (Exception e17) {
            QLog.e(IVasEmojiManager.TAG, 1, "", e17);
            return false;
        }
    }

    public void a(EmoticonPackage emoticonPackage, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, emoticonPackage, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        String str = VasUpdateConstants.SCID_H5_MAGIC_ZIP + emoticonPackage.epId + ".zip";
        if (this.f204683c.contains(emoticonPackage.epId)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG, emoticonPackage);
        bundle.putBoolean(EmojiManagerServiceConstant.PARAMS_PKG_NEW_ADD, z16);
        bundle.putBoolean(EmojiManagerServiceConstant.PARAMS_SWITCH_TAB, z17);
        bundle.putBoolean("isUpdate", com.tencent.mobileqq.core.util.a.b(emoticonPackage));
        bundle.putLong(VasEmojiManagerContstant.PARAMS_DOWNLOAD_START, System.currentTimeMillis());
        this.f204683c.put(emoticonPackage.epId, bundle);
        ConcurrentHashMap<String, TaskStatus> statusMap = c().getStatusMap();
        String str2 = emoticonPackage.epId;
        statusMap.put(str2, new TaskStatus(str2, null));
        ThreadManagerV2.post(new Runnable(str, emoticonPackage) { // from class: com.tencent.mobileqq.emoticon.VasEmojiManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f204685d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ EmoticonPackage f204686e;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.emoticon.VasEmojiManager$1$a */
            /* loaded from: classes12.dex */
            class a implements IDownLoadListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
                    } else {
                        ((IVasEmojiManager) ((IEmosmService) QRoute.api(IEmosmService.class)).getVasEmojiManager(VasEmojiManager.this.f204681a)).complete(AnonymousClass1.this.f204685d, updateListenerParams.mErrorCode);
                    }
                }

                @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
                    } else {
                        ((IVasEmojiManager) ((IEmosmService) QRoute.api(IEmosmService.class)).getVasEmojiManager(VasEmojiManager.this.f204681a)).complete(AnonymousClass1.this.f204685d, updateListenerParams.mErrorCode);
                    }
                }
            }

            {
                this.f204685d = str;
                this.f204686e = emoticonPackage;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, VasEmojiManager.this, str, emoticonPackage);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IVasQuickUpdateService iVasQuickUpdateService;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IEmojiManagerService c16 = VasEmojiManager.this.c();
                boolean z18 = true;
                if ((!new File(VasEmojiManagerContstant.getSavePath(this.f204685d)).exists() || !c16.isH5MagicFacePackageIntact(this.f204686e.epId, true, false)) && (iVasQuickUpdateService = (IVasQuickUpdateService) VasEmojiManager.this.f204681a.getRuntimeService(IVasQuickUpdateService.class, "")) != null) {
                    QQVasUpdateBusiness<?> newBusiness = VasUpdateConstants.getNewBusiness(1004L);
                    if (newBusiness != null) {
                        newBusiness.addDownLoadListener(this.f204685d, new a());
                        newBusiness.startDownload(this.f204685d);
                    } else {
                        ((IEmojiManagerService) VasEmojiManager.this.f204681a.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().notifyPackageStart(this.f204686e);
                        iVasQuickUpdateService.downloadItem(1004L, this.f204685d, IVasEmojiManager.TAG);
                    }
                } else {
                    z18 = false;
                }
                if (!z18) {
                    IEmojiManagerService c17 = VasEmojiManager.this.c();
                    c17.getStatusMap().remove(this.f204686e.epId);
                    c17.handleEmoticonPackageDownloaded(VasEmojiManager.this.f204683c.remove(this.f204686e.epId), null, false, 0, "nomatch", 0L, 0);
                }
            }
        }, 5, null, true);
    }

    public IEmojiManagerService c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IEmojiManagerService) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f204682b;
    }

    @Override // com.tencent.mobileqq.emoticon.IVasEmojiManager
    public void complete(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
            return;
        }
        if (i3 != 0) {
            QLog.e(IVasEmojiManager.TAG, 1, "complete error: " + i3);
        }
        String epId = VasEmojiManagerContstant.getEpId(str);
        Bundle remove = this.f204683c.remove(epId);
        if (remove == null) {
            remove = new Bundle();
            EmoticonPackage syncFindEmoticonPackageById = ((IEmoticonManagerService) this.f204681a.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(epId);
            if (syncFindEmoticonPackageById == null) {
                syncFindEmoticonPackageById = new EmoticonPackage();
                syncFindEmoticonPackageById.name = HardCodeUtil.qqStr(R.string.f209385f_);
                syncFindEmoticonPackageById.epId = epId;
                syncFindEmoticonPackageById.jobType = 5;
                syncFindEmoticonPackageById.type = 1;
                syncFindEmoticonPackageById.aio = true;
                syncFindEmoticonPackageById.isMagicFaceDownloading = true;
            }
            remove.putSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG, syncFindEmoticonPackageById);
            remove.putBoolean(EmojiManagerServiceConstant.PARAMS_PKG_NEW_ADD, false);
            remove.putBoolean(EmojiManagerServiceConstant.PARAMS_SWITCH_TAB, false);
            remove.putBoolean("isUpdate", com.tencent.mobileqq.core.util.a.b(syncFindEmoticonPackageById));
            remove.putLong(VasEmojiManagerContstant.PARAMS_DOWNLOAD_START, System.currentTimeMillis());
        }
        EmoticonPackage emoticonPackage = (EmoticonPackage) remove.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG);
        if (i3 != 0 || !e(VasEmojiManagerContstant.getSavePath(str), remove, emoticonPackage)) {
            ((IEmojiManagerService) this.f204681a.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().notifyPackageFail(emoticonPackage, i3, 8, this.f204681a);
        }
        c().getStatusMap().remove(epId);
    }

    @Override // com.tencent.mobileqq.emoticon.IVasEmojiManager
    public ConcurrentHashMap<String, Bundle> getParamMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f204683c;
    }

    @Override // com.tencent.mobileqq.emoticon.IVasEmojiManager
    public void onProgress(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        String epId = VasEmojiManagerContstant.getEpId(str);
        TaskStatus taskStatus = c().getStatusMap().get(epId);
        if (taskStatus != null) {
            taskStatus.setPercent((((float) j3) * 100.0f) / ((float) j16));
        }
        Bundle bundle = this.f204683c.get(epId);
        if (bundle != null) {
            ((IEmojiManagerService) this.f204681a.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().notifyPackageProgress((EmoticonPackage) bundle.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG), (int) j3, (int) j16);
        }
    }
}
