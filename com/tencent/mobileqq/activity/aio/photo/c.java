package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.anonymous.a;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticonview.api.IEmoAddedAuthCallbackService;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IPictureBusinessApi;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f179719a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f179720b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ URLDrawable f179721c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f179722d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ StructMsgForImageShare f179723e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PicMessageExtraData f179724f;

        a(Context context, int i3, URLDrawable uRLDrawable, QQAppInterface qQAppInterface, StructMsgForImageShare structMsgForImageShare, PicMessageExtraData picMessageExtraData) {
            this.f179719a = context;
            this.f179720b = i3;
            this.f179721c = uRLDrawable;
            this.f179722d = qQAppInterface;
            this.f179723e = structMsgForImageShare;
            this.f179724f = picMessageExtraData;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            File file;
            String str;
            boolean z16;
            String str2;
            if (this.f179721c.getStatus() != 1) {
                this.f179721c.downloadImediatly(false);
            }
            URLDrawable.removeMemoryCacheByUrl(this.f179721c.getURL().toString());
            if (this.f179721c.getTag() == null) {
                return 1;
            }
            String str3 = ((MessageForPic) this.f179721c.getTag()).path;
            CustomEmotionData i3 = c.i(this.f179719a, str3);
            if (i3 != null) {
                c.k(this.f179722d, this.f179723e, i3);
                return 2;
            }
            if (FileUtils.fileExistsAndNotEmpty(str3)) {
                file = new File(str3);
            } else {
                String url = this.f179721c.getURL().toString();
                if (!AbsDownloader.hasFile(url)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOGalleryUtils", 2, "addCustomEmotionFromDownLoad fail, has file");
                    }
                    return 1;
                }
                file = AbsDownloader.getFile(url);
            }
            if (file != null) {
                str = SecUtil.getFileMd5(file.getAbsolutePath());
            } else {
                str = null;
            }
            if (str != null) {
                String str4 = "";
                if (!"".equals(str)) {
                    StringBuilder sb5 = new StringBuilder();
                    String str5 = AppConstants.SDCARD_IMG_FAVORITE;
                    sb5.append(str5);
                    sb5.append(".nomedia");
                    FileUtils.createFileIfNotExits(sb5.toString());
                    String currentAccountUin = this.f179722d.getCurrentAccountUin();
                    PicMessageExtraData picMessageExtraData = this.f179724f;
                    if (picMessageExtraData != null && picMessageExtraData.isDiyDouTu()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("_diydoutu@");
                        if (TextUtils.isEmpty(this.f179724f.emojiId)) {
                            str2 = "0";
                        } else {
                            str2 = this.f179724f.emojiId;
                        }
                        sb6.append(str2);
                        str4 = sb6.toString();
                    }
                    String str6 = str5 + DiySecureFileHelper.secureUin(currentAccountUin) + str + str4 + ".jpg";
                    try {
                        FileUtils.copyFile(file, new File(str6));
                        return Integer.valueOf(c.c(this.f179719a, str6, this.f179723e, this.f179724f));
                    } catch (Exception e16) {
                        QLog.d("AIOGalleryUtils", 1, e16, new Object[0]);
                        return 1;
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOGalleryUtils", 2, "addCustomEmotionFromDownLoad fail, md5 is null");
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            if (num.intValue() == 1) {
                QQToast.makeText(this.f179719a.getApplicationContext(), R.string.cwa, 0).show(this.f179720b);
                EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2004", 1);
            } else if (num.intValue() == 2) {
                QQToast.makeText(this.f179719a.getApplicationContext(), 0, R.string.f170070f0, 0).show(this.f179720b);
                EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2003", 1);
            } else {
                if (num.intValue() != 4 || c.l(this.f179719a)) {
                    return;
                }
                QQToast.makeText(this.f179719a.getApplicationContext(), 0, FavEmoConstant.getAddFavEmoOverLimitTips(), 0).show(this.f179720b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f179725a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f179726b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f179727c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f179728d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PicMessageExtraData f179729e;

        b(Context context, int i3, String str, QQAppInterface qQAppInterface, PicMessageExtraData picMessageExtraData) {
            this.f179725a = context;
            this.f179726b = i3;
            this.f179727c = str;
            this.f179728d = qQAppInterface;
            this.f179729e = picMessageExtraData;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            File file = new File(this.f179727c);
            String fileMd5 = SecUtil.getFileMd5(file.getAbsolutePath());
            if (fileMd5 != null && !"".equals(fileMd5)) {
                StringBuilder sb5 = new StringBuilder();
                String str = AppConstants.SDCARD_IMG_FAVORITE;
                sb5.append(str);
                sb5.append(".nomedia");
                FileUtils.createFileIfNotExits(sb5.toString());
                String str2 = str + DiySecureFileHelper.secureUin(this.f179728d.getCurrentAccountUin()) + fileMd5 + ".jpg";
                CustomEmotionData h16 = c.h(this.f179725a, str2, fileMd5);
                if (h16 != null) {
                    c.k(this.f179728d, null, h16);
                    return 2;
                }
                try {
                    FileUtils.copyFile(file, new File(str2));
                    return Integer.valueOf(c.c(this.f179725a, str2, null, this.f179729e));
                } catch (Exception e16) {
                    QLog.d("AIOGalleryUtils", 1, e16, new Object[0]);
                    return 1;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOGalleryUtils", 2, "addCustomEmotionFromDownLoad fail, md5 is null");
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            if (num.intValue() == 1) {
                QQToast.makeText(this.f179725a.getApplicationContext(), R.string.cwa, 0).show(this.f179726b);
                EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2004", 1);
            } else if (num.intValue() == 2) {
                QQToast.makeText(this.f179725a.getApplicationContext(), 0, R.string.f170070f0, 0).show(this.f179726b);
                EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2003", 1);
            } else {
                if (num.intValue() != 4 || c.l(this.f179725a)) {
                    return;
                }
                QQToast.makeText(this.f179725a.getApplicationContext(), 0, FavEmoConstant.getAddFavEmoOverLimitTips(), 0).show(this.f179726b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.aio.photo.c$c, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class DialogInterfaceOnClickListenerC7132c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f179730d;

        DialogInterfaceOnClickListenerC7132c(Context context) {
            this.f179730d = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.e("AIOGalleryUtils", 1, "click pay for handleOverSizeOpenSvip");
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            Context context = this.f179730d;
            VasH5PayUtil.openClubPay(context, "mvip.n.a.bqsc_ql", 3, "1450000516", "CJCLUBT", context.getString(R.string.f173184hu3), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    public static void b(Context context, String str, QQAppInterface qQAppInterface, int i3, PicMessageExtraData picMessageExtraData) {
        new b(context, i3, str, qQAppInterface, picMessageExtraData).execute(new Void[0]);
    }

    public static int c(Context context, String str, StructMsgForImageShare structMsgForImageShare, PicMessageExtraData picMessageExtraData) {
        int i3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !(peekAppRuntime instanceof QQAppInterface)) {
            return 1;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        String bytes2HexStr = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) qQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
        if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
        }
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) qQAppInterface.getRuntimeService(IFavroamingManagerService.class);
        iFavroamingManagerService.checkFavEmotionInit();
        if (emoticonDataList != null) {
            int size = emoticonDataList.size();
            if (size >= FavEmoConstant.getAddFavEmoOverLimit()) {
                QLog.e("AIOGalleryUtils", 1, "[addCustomEmotionForAIO] add fav emo over count limit. currentCount=", Integer.valueOf(size), ", limitCount=", Integer.valueOf(FavEmoConstant.getAddFavEmoOverLimit()));
                return 4;
            }
            i3 = 1;
            for (int i16 = 0; i16 < emoticonDataList.size(); i16++) {
                int i17 = emoticonDataList.get(i16).emoId;
                if (str != null && str.equals(emoticonDataList.get(i16).emoPath)) {
                    k(qQAppInterface, structMsgForImageShare, emoticonDataList.get(i16));
                    return 2;
                }
                if (bytes2HexStr != null && emoticonDataList.get(i16).md5 != null && bytes2HexStr.equals(emoticonDataList.get(i16).md5)) {
                    k(qQAppInterface, structMsgForImageShare, emoticonDataList.get(i16));
                    if (!"needDel".equals(emoticonDataList.get(i16).RomaingType)) {
                        return 2;
                    }
                    iFavroamingDBManagerService.updateDeletedEmoticon(emoticonDataList.get(i16), i16);
                    MqqHandler handler = qQAppInterface.getHandler(ChatActivity.class);
                    if (handler != null) {
                        handler.obtainMessage(10).sendToTarget();
                    }
                    QLog.i("AIOGalleryUtils", 1, "equals.md5==ADD_SUCCESS");
                    return 0;
                }
                if (i3 < i17) {
                    i3 = i17;
                }
            }
        } else {
            i3 = 1;
        }
        CustomEmotionData customEmotionData = new CustomEmotionData();
        customEmotionData.uin = qQAppInterface.getCurrentAccountUin();
        customEmotionData.emoId = i3 + 1;
        customEmotionData.emoPath = str;
        customEmotionData.md5 = bytes2HexStr;
        if (picMessageExtraData != null) {
            if (picMessageExtraData.isDiyDouTu()) {
                customEmotionData.eId = picMessageExtraData.emojiPkgId;
            }
            customEmotionData.jumpId = picMessageExtraData.jumpId;
        }
        if (!TextUtils.isEmpty(str) && str.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY)) {
            ReportController.o(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
        }
        iFavroamingManagerService.syncUpload(customEmotionData, ((IEmoAddedAuthCallbackService) QRoute.api(IEmoAddedAuthCallbackService.class)).createEmoAddedAuthCallback(qQAppInterface, context, customEmotionData, structMsgForImageShare, 0));
        QLog.i("AIOGalleryUtils", 1, "real==ADD_SUCCESS");
        return 0;
    }

    public static int d(QQAppInterface qQAppInterface, String str) {
        String bytes2HexStr = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) qQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
        if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
        }
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        int i3 = 1;
        if (emoticonDataList != null) {
            for (int i16 = 0; i16 < emoticonDataList.size(); i16++) {
                int i17 = emoticonDataList.get(i16).emoId;
                if (str != null && str.equals(emoticonDataList.get(i16).emoPath)) {
                    return 2;
                }
                if (bytes2HexStr != null && bytes2HexStr.equals(emoticonDataList.get(i16).md5)) {
                    if (!"needDel".equals(emoticonDataList.get(i16).RomaingType)) {
                        return 2;
                    }
                    iFavroamingDBManagerService.updateDeletedEmoticon(emoticonDataList.get(i16), i16);
                    MqqHandler handler = qQAppInterface.getHandler(ChatActivity.class);
                    if (handler != null) {
                        handler.obtainMessage(10).sendToTarget();
                    }
                    return 0;
                }
                if (i3 < i17) {
                    i3 = i17;
                }
            }
        }
        CustomEmotionData customEmotionData = new CustomEmotionData();
        customEmotionData.uin = qQAppInterface.getCurrentAccountUin();
        customEmotionData.emoId = i3 + 1;
        customEmotionData.emoPath = str;
        customEmotionData.md5 = bytes2HexStr;
        if (!TextUtils.isEmpty(str) && str.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY)) {
            ReportController.o(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
        }
        ad createEmoAddedAuthCallback = ((IEmoAddedAuthCallbackService) QRoute.api(IEmoAddedAuthCallbackService.class)).createEmoAddedAuthCallback(qQAppInterface, BaseApplication.getContext(), customEmotionData, null, 3);
        IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) qQAppInterface.getRuntimeService(IFavroamingManagerService.class);
        if (iFavroamingManagerService != null) {
            iFavroamingManagerService.syncUpload(customEmotionData, createEmoAddedAuthCallback);
        }
        return 0;
    }

    public static void e(Context context, QQAppInterface qQAppInterface, URLDrawable uRLDrawable, String str, int i3, StructMsgForImageShare structMsgForImageShare, PicMessageExtraData picMessageExtraData) {
        new a(context, i3, uRLDrawable, qQAppInterface, structMsgForImageShare, picMessageExtraData).execute(new Void[0]);
    }

    public static int f(Context context, String str, QQAppInterface qQAppInterface, int i3, com.tencent.mobileqq.emosm.favroaming.j jVar) {
        CustomEmotionData i16 = i(context, str);
        if (i16 != null) {
            k(qQAppInterface, null, i16);
            return 2;
        }
        File file = new File(str);
        String fileMd5 = SecUtil.getFileMd5(file.getAbsolutePath());
        if (fileMd5 != null && !"".equals(fileMd5)) {
            StringBuilder sb5 = new StringBuilder();
            String str2 = AppConstants.SDCARD_IMG_FAVORITE;
            sb5.append(str2);
            sb5.append(".nomedia");
            FileUtils.createFileIfNotExits(sb5.toString());
            String str3 = str2 + DiySecureFileHelper.secureUin(qQAppInterface.getCurrentAccountUin()) + fileMd5 + ".jpg";
            try {
                FileUtils.copyFile(file, new File(str3));
                return v(qQAppInterface, null, jVar, i3, str3);
            } catch (Exception e16) {
                QLog.d("AIOGalleryUtils", 1, e16, new Object[0]);
                return 1;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryUtils", 2, "addPicToCustomEmotion fail, md5 is null");
        }
        return 1;
    }

    public static int g(AIORichMediaData aIORichMediaData) {
        if (AIOLightVideoData.class.isInstance(aIORichMediaData)) {
            return 3;
        }
        if (!AIOShortVideoData.class.isInstance(aIORichMediaData) && !AIOFileVideoData.class.isInstance(aIORichMediaData)) {
            return 1;
        }
        return 2;
    }

    public static CustomEmotionData h(Context context, String str, String str2) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !(peekAppRuntime instanceof QQAppInterface)) {
            return null;
        }
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) ((QQAppInterface) peekAppRuntime).getRuntimeService(IFavroamingDBManagerService.class);
        if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from getExitInCustomEmotionResp.");
        }
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        if (emoticonDataList == null) {
            return null;
        }
        for (int i3 = 0; i3 < emoticonDataList.size(); i3++) {
            CustomEmotionData customEmotionData = emoticonDataList.get(i3);
            if (TextUtils.equals(customEmotionData.emoPath, str) || TextUtils.equals(str2, customEmotionData.md5)) {
                CustomEmotionData customEmotionData2 = emoticonDataList.get(i3);
                iFavroamingDBManagerService.updateDeletedEmoticon(customEmotionData2, i3);
                return customEmotionData2;
            }
        }
        return null;
    }

    public static CustomEmotionData i(Context context, String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !(peekAppRuntime instanceof QQAppInterface)) {
            return null;
        }
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) ((QQAppInterface) peekAppRuntime).getRuntimeService(IFavroamingDBManagerService.class);
        if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from getExitInCustomEmotionResp.");
        }
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        if (emoticonDataList == null) {
            return null;
        }
        for (int i3 = 0; i3 < emoticonDataList.size(); i3++) {
            if (str != null && str.equals(emoticonDataList.get(i3).emoPath)) {
                CustomEmotionData customEmotionData = emoticonDataList.get(i3);
                iFavroamingDBManagerService.updateDeletedEmoticon(customEmotionData, i3);
                return customEmotionData;
            }
        }
        return null;
    }

    public static void j(QQAppInterface qQAppInterface, StructMsgForImageShare structMsgForImageShare, CustomEmotionData customEmotionData) {
        String actionDataFromStructMsg = ((IPictureBusinessApi) QRoute.api(IPictureBusinessApi.class)).getActionDataFromStructMsg(structMsgForImageShare);
        if (qQAppInterface != null && !TextUtils.isEmpty(actionDataFromStructMsg) && actionDataFromStructMsg.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID) && customEmotionData != null && !TextUtils.isEmpty(customEmotionData.md5)) {
            IVipComicMqqManagerService iVipComicMqqManagerService = (IVipComicMqqManagerService) qQAppInterface.getRuntimeService(IVipComicMqqManagerService.class);
            VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
            vipComicFavorEmoStructMsgInfo.picMd5 = customEmotionData.md5;
            vipComicFavorEmoStructMsgInfo.actionData = actionDataFromStructMsg;
            ArrayList arrayList = new ArrayList();
            arrayList.add(vipComicFavorEmoStructMsgInfo);
            iVipComicMqqManagerService.setMyComicEmoticon(arrayList, true);
            if (QLog.isColorLevel()) {
                QLog.d("AIOGalleryUtils", 2, "handleComicStructMsg , emoStructMsgInfo = " + vipComicFavorEmoStructMsgInfo);
            }
        }
    }

    public static void k(QQAppInterface qQAppInterface, StructMsgForImageShare structMsgForImageShare, CustomEmotionData customEmotionData) {
        String actionDataFromStructMsg = ((IPictureBusinessApi) QRoute.api(IPictureBusinessApi.class)).getActionDataFromStructMsg(structMsgForImageShare);
        if (qQAppInterface != null && !TextUtils.isEmpty(actionDataFromStructMsg) && actionDataFromStructMsg.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID) && customEmotionData != null && !TextUtils.isEmpty(customEmotionData.md5)) {
            IVipComicMqqManagerService iVipComicMqqManagerService = (IVipComicMqqManagerService) qQAppInterface.getRuntimeService(IVipComicMqqManagerService.class);
            VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
            String str = customEmotionData.md5;
            vipComicFavorEmoStructMsgInfo.picMd5 = str;
            vipComicFavorEmoStructMsgInfo.actionData = actionDataFromStructMsg;
            if (!vipComicFavorEmoStructMsgInfo.equals(iVipComicMqqManagerService.getComicStructInfo(str))) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(vipComicFavorEmoStructMsgInfo);
                iVipComicMqqManagerService.setMyComicEmoticon(arrayList, true);
                if (QLog.isColorLevel()) {
                    QLog.d("AIOGalleryUtils", 2, "handleOldComicStructMsg , emoStructMsgInfo = " + vipComicFavorEmoStructMsgInfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(Context context) {
        int i3;
        if (FavEmoConstant.getAddFavEmoOverLimit() < 1000) {
            if (m()) {
                i3 = R.string.zun;
            } else {
                i3 = R.string.zuo;
            }
            int i16 = i3;
            DialogUtil.createCustomDialog(context, 0, HardCodeUtil.qqStr(R.string.zut), HardCodeUtil.qqStr(i16) + HardCodeUtil.qqStr(R.string.zus), R.string.d2d, i16, new DialogInterfaceOnClickListenerC7132c(context), new d()).show();
            return true;
        }
        return false;
    }

    private static boolean m() {
        List<CustomEmotionData> emoticonDataList;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface) || (emoticonDataList = ((IFavroamingDBManagerService) ((QQAppInterface) peekAppRuntime).getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList()) == null) {
            return false;
        }
        int size = emoticonDataList.size();
        if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryUtils", 2, "isOldSvip emoCount=" + size);
        }
        if (size <= 500) {
            return false;
        }
        return true;
    }

    public static void n(Activity activity, File file, String str) {
        AIOGalleryUtils.p(activity, file, str, null);
    }

    public static AIORichMediaData o(ChatMessage chatMessage, QQAppInterface qQAppInterface) {
        AIORichMediaData aIORichMediaData = null;
        if (chatMessage == null) {
            return null;
        }
        if (chatMessage instanceof MessageForFile) {
            aIORichMediaData = q(chatMessage, qQAppInterface);
        } else if (chatMessage instanceof MessageForTroopFile) {
            aIORichMediaData = r(chatMessage, qQAppInterface);
        } else if (chatMessage instanceof MessageForDLFile) {
            aIORichMediaData = p(chatMessage, qQAppInterface);
        }
        if (aIORichMediaData != null) {
            QLog.i("AIOGalleryUtils<QFile>", 1, "toAIOFileMediaData: media data is null.");
            aIORichMediaData.E = MessageHandlerUtils.isMsgSeqReady(chatMessage);
        }
        return aIORichMediaData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static AIORichMediaData p(ChatMessage chatMessage, QQAppInterface qQAppInterface) {
        DataLineMsgRecord d16;
        AIOFileVideoData aIOFileVideoData;
        MessageForDLFile messageForDLFile = (MessageForDLFile) chatMessage;
        DatalineMessageManager t16 = qQAppInterface.getMessageFacade().t1(messageForDLFile.deviceType);
        if (t16 == null || (d16 = t16.d(messageForDLFile.associatedId)) == null) {
            return null;
        }
        int fileType = FileManagerUtil.getFileType(d16.filename);
        if (fileType == 0) {
            AIOFilePicData aIOFilePicData = new AIOFilePicData();
            aIOFilePicData.f(d16);
            aIOFileVideoData = aIOFilePicData;
        } else {
            if (fileType != 2) {
                return null;
            }
            AIOFileVideoData aIOFileVideoData2 = new AIOFileVideoData();
            aIOFileVideoData2.f(d16);
            aIOFileVideoData2.I = ((IQFileConfigManager) qQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(com.tencent.mobileqq.troop.utils.d.a(d16.filename)).f207738b;
            aIOFileVideoData = aIOFileVideoData2;
        }
        aIOFileVideoData.f179628d = chatMessage.uniseq;
        aIOFileVideoData.C = chatMessage.isMultiMsg;
        return aIOFileVideoData;
    }

    private static AIORichMediaData q(ChatMessage chatMessage, QQAppInterface qQAppInterface) {
        String str;
        MediaMetadataRetriever mediaMetadataRetriever;
        String extractMetadata;
        String extractMetadata2;
        int parseInt;
        MessageForFile messageForFile = (MessageForFile) chatMessage;
        FileManagerEntity E = qQAppInterface.getFileManagerDataCenter().E(messageForFile.uniseq, messageForFile.frienduin, messageForFile.istroop);
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        MediaMetadataRetriever mediaMetadataRetriever3 = null;
        if (E == null) {
            return null;
        }
        int i3 = E.nFileType;
        boolean z16 = true;
        if (i3 == 0) {
            AIOFilePicData aIOFilePicData = new AIOFilePicData();
            aIOFilePicData.f179628d = messageForFile.uniseq;
            aIOFilePicData.f179630f = messageForFile.time;
            aIOFilePicData.f179632i = messageForFile.shmsgseq;
            aIOFilePicData.f179631h = messageForFile.fileSize;
            aIOFilePicData.F = messageForFile.frienduin;
            aIOFilePicData.G = messageForFile.istroop;
            aIOFilePicData.U = qQAppInterface.getCurrentAccountUin();
            aIOFilePicData.V = messageForFile.issend;
            aIOFilePicData.f179633m = chatMessage.istroop;
            aIOFilePicData.C = chatMessage.isMultiMsg;
            aIOFilePicData.X = E.Uuid;
            if (E.status != 2) {
                z16 = false;
            }
            aIOFilePicData.Y = z16;
            aIOFilePicData.Z = E.strFileMd5;
            aIOFilePicData.f179567a0 = E.imgWidth;
            aIOFilePicData.f179568b0 = E.imgHeight;
            aIOFilePicData.f179569c0 = E.thumbInvalidCode;
            aIOFilePicData.j(qQAppInterface);
            return aIOFilePicData;
        }
        if (i3 == 2) {
            if (E.status == 16) {
                if (QLog.isColorLevel()) {
                    QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + E.nSessionId + " file is invalid!");
                }
                return null;
            }
            if (E.sendCloudUnsuccessful()) {
                if (QLog.isColorLevel()) {
                    QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + E.nSessionId + " file is sendCloudUnsuccessful!");
                }
                return null;
            }
            boolean fileExistsAndNotEmpty = FileUtils.fileExistsAndNotEmpty(E.getFilePath());
            if (fileExistsAndNotEmpty && E.status != 1) {
                if (QLog.isColorLevel()) {
                    QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + E.nSessionId + " file is localfile, but status is not success!");
                }
                return null;
            }
            com.tencent.mobileqq.filemanager.data.c fileAutoDownloadConfig = ((IQFileConfigManager) qQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(com.tencent.mobileqq.troop.utils.d.a(E.fileName));
            if (com.tencent.mobileqq.filemanager.util.q.f(E.strLargeThumPath)) {
                str = E.strLargeThumPath;
            } else if (com.tencent.mobileqq.filemanager.util.q.f(E.strMiddleThumPath)) {
                str = E.strMiddleThumPath;
            } else if (com.tencent.mobileqq.filemanager.util.q.f(E.strThumbPath)) {
                str = E.strThumbPath;
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                QLog.w("AIOGalleryUtils", 1, "file[" + E.nSessionId + "] don't has thumb!!!");
            }
            AIOFileVideoData aIOFileVideoData = new AIOFileVideoData(str);
            aIOFileVideoData.U = messageForFile.frienduin;
            aIOFileVideoData.V = messageForFile.istroop;
            aIOFileVideoData.W = messageForFile.issend;
            aIOFileVideoData.X = E.Uuid;
            aIOFileVideoData.Y = E.strFileMd5;
            aIOFileVideoData.f179628d = messageForFile.uniseq;
            aIOFileVideoData.f179630f = messageForFile.time;
            aIOFileVideoData.f179632i = messageForFile.shmsgseq;
            aIOFileVideoData.f179631h = E.fileSize;
            aIOFileVideoData.F = E.fileName;
            aIOFileVideoData.f179633m = chatMessage.istroop;
            aIOFileVideoData.K = E.imgHeight;
            aIOFileVideoData.J = E.imgWidth;
            aIOFileVideoData.I = fileAutoDownloadConfig.f207738b;
            if (fileExistsAndNotEmpty) {
                aIOFileVideoData.H = E.getFilePath();
                aIOFileVideoData.P = true;
                try {
                    try {
                        mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(aIOFileVideoData.H);
                            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                            extractMetadata = mediaMetadataRetriever.extractMetadata(19);
                            extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
                            parseInt = Integer.parseInt(extractMetadata3);
                        } catch (Exception e16) {
                            e = e16;
                            mediaMetadataRetriever3 = mediaMetadataRetriever;
                            e.printStackTrace();
                            mediaMetadataRetriever2 = mediaMetadataRetriever3;
                            if (mediaMetadataRetriever3 != null) {
                                mediaMetadataRetriever3.release();
                                mediaMetadataRetriever2 = mediaMetadataRetriever3;
                            }
                            aIOFileVideoData.C = chatMessage.isMultiMsg;
                            return aIOFileVideoData;
                        } catch (Throwable th5) {
                            th = th5;
                            mediaMetadataRetriever2 = mediaMetadataRetriever;
                            if (mediaMetadataRetriever2 != null) {
                                mediaMetadataRetriever2.release();
                            }
                            throw th;
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                    if (parseInt != 90 && parseInt != 270) {
                        aIOFileVideoData.J = Integer.parseInt(extractMetadata2);
                        aIOFileVideoData.K = Integer.parseInt(extractMetadata);
                        mediaMetadataRetriever.release();
                        mediaMetadataRetriever2 = extractMetadata2;
                    }
                    aIOFileVideoData.J = Integer.parseInt(extractMetadata);
                    aIOFileVideoData.K = Integer.parseInt(extractMetadata2);
                    mediaMetadataRetriever.release();
                    mediaMetadataRetriever2 = extractMetadata2;
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            aIOFileVideoData.C = chatMessage.isMultiMsg;
            return aIOFileVideoData;
        }
        QLog.e("AIOGalleryUtils", 1, "unknow file Type");
        return null;
    }

    private static AIORichMediaData r(ChatMessage chatMessage, QQAppInterface qQAppInterface) {
        int i3;
        MessageForTroopFile messageForTroopFile = (MessageForTroopFile) chatMessage;
        t m3 = TroopFileUtils.m(qQAppInterface, messageForTroopFile);
        if (m3 == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AIOGalleryUtils", 4, "get fileStatusInfo fail ");
            }
            return null;
        }
        if (FileManagerUtil.getFileType(messageForTroopFile.fileName) != 2) {
            QLog.e("AIOGalleryUtils", 1, "unknow file Type");
            return null;
        }
        int i16 = m3.f294972f;
        if (i16 == 12) {
            if (QLog.isColorLevel()) {
                QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + m3.f294967a + " file is deleted!");
            }
            return null;
        }
        if (i16 != 4 && i16 != 5) {
            if (FileUtils.fileExistsAndNotEmpty(m3.f294978l) && ((i3 = m3.f294972f) == 1 || i3 == 2 || i3 == 3)) {
                if (QLog.isColorLevel()) {
                    QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + m3.f294967a + " file is:" + m3.f294972f);
                }
                return null;
            }
            com.tencent.mobileqq.filemanager.data.c fileAutoDownloadConfig = ((IQFileConfigManager) qQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(com.tencent.mobileqq.troop.utils.d.a(m3.f294987u));
            String str = m3.f294981o;
            if (TextUtils.isEmpty(str)) {
                str = m3.f294980n;
            }
            if (messageForTroopFile.isMultiMsg && TextUtils.isEmpty(str)) {
                str = FileManagerUtil.getMultiFileThumbPath(messageForTroopFile);
            }
            AIOFileVideoData aIOFileVideoData = new AIOFileVideoData(str);
            aIOFileVideoData.U = messageForTroopFile.frienduin;
            int i17 = messageForTroopFile.istroop;
            aIOFileVideoData.V = i17;
            aIOFileVideoData.W = messageForTroopFile.issend;
            aIOFileVideoData.f179628d = messageForTroopFile.uniseq;
            aIOFileVideoData.f179630f = messageForTroopFile.time;
            aIOFileVideoData.f179632i = messageForTroopFile.shmsgseq;
            aIOFileVideoData.f179631h = messageForTroopFile.fileSize;
            aIOFileVideoData.F = messageForTroopFile.fileName;
            aIOFileVideoData.f179633m = i17;
            aIOFileVideoData.I = fileAutoDownloadConfig.f207738b;
            aIOFileVideoData.J = messageForTroopFile.width;
            aIOFileVideoData.K = messageForTroopFile.height;
            if (FileUtils.fileExistsAndNotEmpty(m3.f294978l)) {
                aIOFileVideoData.H = m3.f294978l;
                aIOFileVideoData.P = true;
            }
            aIOFileVideoData.C = chatMessage.isMultiMsg;
            return aIOFileVideoData;
        }
        if (QLog.isColorLevel()) {
            QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + m3.f294967a + " file is:" + m3.f294972f);
        }
        return null;
    }

    public static AIOFilePicData s(MessageForTroopFile messageForTroopFile, QQAppInterface qQAppInterface) {
        int i3;
        t m3 = TroopFileUtils.m(qQAppInterface, messageForTroopFile);
        if (m3 == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AIOGalleryUtils", 4, "get fileStatusInfo fail ");
            }
            return null;
        }
        boolean z16 = true;
        if (FileManagerUtil.getFileType(messageForTroopFile.fileName) != 0) {
            QLog.e("AIOGalleryUtils", 1, "unknow file Type");
            return null;
        }
        int i16 = m3.f294972f;
        if (i16 == 12) {
            if (QLog.isColorLevel()) {
                QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + m3.f294967a + " file is deleted!");
            }
            return null;
        }
        if (i16 != 4 && i16 != 5) {
            if (FileUtils.fileExistsAndNotEmpty(m3.f294978l) && ((i3 = m3.f294972f) == 1 || i3 == 2 || i3 == 3)) {
                if (QLog.isColorLevel()) {
                    QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + m3.f294967a + " file is:" + m3.f294972f);
                }
                return null;
            }
            ((IQFileConfigManager) qQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(com.tencent.mobileqq.troop.utils.d.a(m3.f294987u));
            String str = m3.f294981o;
            if (messageForTroopFile.isMultiMsg && TextUtils.isEmpty(str)) {
                FileManagerUtil.getMultiFileThumbPath(messageForTroopFile);
            }
            AIOFilePicData aIOFilePicData = new AIOFilePicData();
            aIOFilePicData.f179628d = messageForTroopFile.uniseq;
            aIOFilePicData.f179630f = messageForTroopFile.time;
            aIOFilePicData.f179632i = messageForTroopFile.shmsgseq;
            aIOFilePicData.f179631h = messageForTroopFile.fileSize;
            aIOFilePicData.F = messageForTroopFile.frienduin;
            aIOFilePicData.G = messageForTroopFile.istroop;
            aIOFilePicData.U = qQAppInterface.getCurrentAccountUin();
            aIOFilePicData.V = messageForTroopFile.issend;
            aIOFilePicData.f179633m = messageForTroopFile.istroop;
            aIOFilePicData.C = messageForTroopFile.isMultiMsg;
            aIOFilePicData.f179567a0 = messageForTroopFile.width;
            aIOFilePicData.f179568b0 = messageForTroopFile.height;
            aIOFilePicData.f179569c0 = m3.I;
            aIOFilePicData.X = messageForTroopFile.url;
            if (m3.f294972f != 8) {
                z16 = false;
            }
            aIOFilePicData.Y = z16;
            aIOFilePicData.g(m3);
            aIOFilePicData.E = MessageHandlerUtils.isMsgSeqReady(messageForTroopFile);
            return aIOFilePicData;
        }
        if (QLog.isColorLevel()) {
            QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + m3.f294967a + " file is:" + m3.f294972f);
        }
        return null;
    }

    public static AIOImageData t(MessageForPic messageForPic) {
        int i3;
        AIOImageData aIOImageData = new AIOImageData();
        aIOImageData.f179628d = messageForPic.uniseq;
        aIOImageData.f179629e = messageForPic.subMsgId;
        aIOImageData.f179630f = messageForPic.time;
        aIOImageData.f179632i = messageForPic.shmsgseq;
        aIOImageData.f179631h = messageForPic.size;
        aIOImageData.f179633m = messageForPic.istroop;
        aIOImageData.X = messageForPic.md5;
        aIOImageData.f179577h0 = messageForPic.rawMsgUrl;
        aIOImageData.f179578i0 = messageForPic.senderuin;
        aIOImageData.f179582m0 = messageForPic.frienduin;
        if (com.tencent.biz.anonymous.a.m(messageForPic)) {
            a.C0789a e16 = com.tencent.biz.anonymous.a.e(messageForPic);
            if (e16.f78366b == null && e16.f78365a != 2) {
                if (QLog.isColorLevel()) {
                    QLog.i("AIOGalleryUtils", 2, "toAIOImageData anonymousExtInfo : an_id is null");
                }
            } else {
                byte[] a16 = e16.a();
                if (a16 != null && e16.f78365a != 2) {
                    String encode = URLEncoder.encode(Base64.encodeToString(a16, 2));
                    com.tencent.biz.anonymous.a.h().q(messageForPic.frienduin, encode, messageForPic);
                    aIOImageData.f179583n0 = true;
                    aIOImageData.f179585p0 = com.tencent.biz.anonymous.a.h().j(messageForPic.frienduin, encode);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryUtils", 2, "toAIOImageData, pic_server_url = " + aIOImageData.f179577h0 + "  send_uin = " + aIOImageData.f179578i0);
        }
        PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
        if (picMessageExtraData != null) {
            aIOImageData.f179576g0 = picMessageExtraData.doutuSupplier;
        }
        if (messageForPic.isMixed) {
            i3 = 1;
        } else {
            i3 = 65537;
        }
        String filePath = AbsDownloader.getFilePath(URLDrawableHelper.getURL(messageForPic, i3, "chatthumb").toString());
        aIOImageData.F = filePath;
        if (messageForPic.isMixed) {
            aIOImageData.G = filePath;
        } else {
            URL url = URLDrawableHelper.getURL(messageForPic, 1, null);
            aIOImageData.G = AbsDownloader.getFilePath(url.toString());
            if (messageForPic.fileSizeFlag != 1) {
                long j3 = messageForPic.size;
                File file = new File(aIOImageData.G);
                if (file.exists() && file.length() < j3) {
                    aIOImageData.N = true;
                }
                aIOImageData.I = AbsDownloader.getDisplayFilePath(url.toString());
                int i16 = messageForPic.mShowLength;
                if (i16 > 0 && i16 < messageForPic.mDownloadLength) {
                    aIOImageData.R = true;
                }
            }
        }
        if (messageForPic.fileSizeFlag == 1) {
            aIOImageData.H = AbsDownloader.getFilePath(URLDrawableHelper.getURL(messageForPic, 131075, null).toString());
        }
        aIOImageData.U = messageForPic.uuid;
        aIOImageData.W = messageForPic.groupFileID;
        aIOImageData.S = messageForPic.width;
        aIOImageData.T = messageForPic.height;
        aIOImageData.Q = messageForPic.isSendFromLocal();
        aIOImageData.P = messageForPic.imageType;
        aIOImageData.C = messageForPic.isMultiMsg;
        aIOImageData.f179581l0 = messageForPic.isSend();
        PicMessageExtraData picMessageExtraData2 = messageForPic.picExtraData;
        if (picMessageExtraData2 != null) {
            if (picMessageExtraData2.isHotPics()) {
                aIOImageData.Y = 4;
            }
            PicMessageExtraData picMessageExtraData3 = messageForPic.picExtraData;
            aIOImageData.f179580k0 = picMessageExtraData3.imageBizType;
            aIOImageData.f179586q0 = picMessageExtraData3.mTemplateId;
            aIOImageData.f179587r0 = picMessageExtraData3.mTemplateName;
        }
        aIOImageData.D = messageForPic.isInMixedMsg;
        aIOImageData.E = MessageHandlerUtils.isMsgSeqReady(messageForPic);
        return aIOImageData;
    }

    public static AIOShortVideoData u(MessageForShortVideo messageForShortVideo) {
        AIOShortVideoData aIOShortVideoData = new AIOShortVideoData();
        aIOShortVideoData.f179628d = messageForShortVideo.uniseq;
        aIOShortVideoData.f179630f = messageForShortVideo.time;
        aIOShortVideoData.f179631h = messageForShortVideo.videoFileSize;
        aIOShortVideoData.f179632i = messageForShortVideo.shmsgseq;
        String l3 = com.tencent.mobileqq.shortvideo.j.l(messageForShortVideo.thumbMD5, "jpg");
        String j3 = com.tencent.mobileqq.shortvideo.j.j(messageForShortVideo, "mp4");
        aIOShortVideoData.F = l3;
        aIOShortVideoData.G = j3;
        aIOShortVideoData.H = messageForShortVideo.videoFileTime;
        aIOShortVideoData.I = messageForShortVideo.busiType;
        aIOShortVideoData.L = messageForShortVideo.thumbWidth;
        aIOShortVideoData.M = messageForShortVideo.thumbHeight;
        aIOShortVideoData.N = messageForShortVideo.uniseq;
        aIOShortVideoData.P = messageForShortVideo.redBagType;
        aIOShortVideoData.Q = messageForShortVideo.shortVideoId;
        aIOShortVideoData.R = com.tencent.imcore.message.ad.k(messageForShortVideo);
        aIOShortVideoData.S = messageForShortVideo.redBagStat;
        aIOShortVideoData.T = messageForShortVideo.frienduin;
        aIOShortVideoData.f179633m = messageForShortVideo.istroop;
        aIOShortVideoData.U = messageForShortVideo.isSend() ? 1 : 0;
        aIOShortVideoData.W = messageForShortVideo.specialVideoType;
        aIOShortVideoData.V = messageForShortVideo.videoFileStatus;
        aIOShortVideoData.C = messageForShortVideo.isMultiMsg;
        aIOShortVideoData.Y = messageForShortVideo.templateId;
        aIOShortVideoData.Z = messageForShortVideo.templateName;
        aIOShortVideoData.E = MessageHandlerUtils.isMsgSeqReady(messageForShortVideo);
        return aIOShortVideoData;
    }

    private static int v(QQAppInterface qQAppInterface, PicMessageExtraData picMessageExtraData, com.tencent.mobileqq.emosm.favroaming.j jVar, int i3, String str) {
        String bytes2HexStr = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) qQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
        if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
        }
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        if (emoticonDataList != null) {
            for (int i16 = 0; i16 < emoticonDataList.size(); i16++) {
                if (str != null && str.equals(emoticonDataList.get(i16).emoPath)) {
                    return 2;
                }
                if (bytes2HexStr != null && emoticonDataList.get(i16).md5 != null && bytes2HexStr.equals(emoticonDataList.get(i16).md5)) {
                    if (!"needDel".equals(emoticonDataList.get(i16).RomaingType)) {
                        return 2;
                    }
                    iFavroamingDBManagerService.updateDeletedEmoticon(emoticonDataList.get(i16), i16);
                    return 0;
                }
            }
        }
        CustomEmotionData customEmotionData = new CustomEmotionData();
        customEmotionData.uin = qQAppInterface.getCurrentAccountUin();
        customEmotionData.emoId = i3;
        customEmotionData.emoPath = str;
        customEmotionData.md5 = bytes2HexStr;
        if (picMessageExtraData != null && picMessageExtraData.isDiyDouTu()) {
            customEmotionData.eId = picMessageExtraData.emojiPkgId;
        }
        if (!TextUtils.isEmpty(str) && str.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY)) {
            ReportController.o(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
        }
        jVar.b(customEmotionData);
        IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) qQAppInterface.getRuntimeService(IFavroamingManagerService.class);
        if (iFavroamingManagerService != null) {
            iFavroamingManagerService.syncUpload(customEmotionData, jVar);
            return 3;
        }
        return 3;
    }
}
