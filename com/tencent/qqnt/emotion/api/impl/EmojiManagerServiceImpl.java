package com.tencent.qqnt.emotion.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmojiManagerService;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.utils.f;
import com.tencent.qqnt.emotion.utils.j;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.l;
import com.tencent.qqnt.http.api.m;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes24.dex */
public class EmojiManagerServiceImpl implements IEmojiManagerService {
    static IPatchRedirector $redirector_;
    private static String JSON_PREFIX;
    private static int PACKAGE_TYPE_AUDIO;
    private static int PACKAGE_TYPE_VIDEO;
    private static final String TAG;
    public static com.tencent.qqnt.emotion.manager.a listenerManager;
    public static int sCurPlayTimes;
    public static long sRecordBeginTime;
    public static boolean sStartRecord;
    public JobQueue emoQueue;
    Map<String, String> encryptKeyMap;
    public boolean haveInitFav;
    public boolean haveInitFavWeb;
    public boolean haveInitSmallAndNormal;
    int limitSize;
    BaseQQAppInterface mApp;
    public HashMap<String, String> mapParams;
    private Map<String, com.tencent.qqnt.http.api.b> tasks;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    class a implements l {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f356149a;

        a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmojiManagerServiceImpl.this, (Object) str);
            } else {
                this.f356149a = str;
            }
        }

        Bundle a(com.tencent.qqnt.http.api.b bVar) {
            synchronized (EmojiManagerServiceImpl.this.tasks) {
                EmojiManagerServiceImpl.this.tasks.remove(this.f356149a);
            }
            return (Bundle) bVar.A(Bundle.class);
        }

        EmoticonPackage b(Bundle bundle, m mVar) {
            EmoticonPackage emoticonPackage = (EmoticonPackage) bundle.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG);
            if (emoticonPackage != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(EmojiManagerServiceImpl.TAG, 2, "jsonDownloadListener : onDone epid = " + emoticonPackage.epId + ";task status = " + mVar.a());
                }
                return emoticonPackage;
            }
            return null;
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onFailed(@NonNull com.tencent.qqnt.http.api.b bVar, @NonNull m mVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar, (Object) mVar);
                return;
            }
            try {
                Bundle a16 = a(bVar);
                EmoticonPackage b16 = b(a16, mVar);
                QLog.e(EmojiManagerServiceImpl.TAG, 1, "jsonDownloadListener : ondone error , reportCode = " + mVar.a());
                EmojiManagerServiceImpl.listenerManager.d(b16, mVar.a(), a16);
            } catch (Exception e16) {
                QLog.e(EmojiManagerServiceImpl.TAG, 1, "json download fail", e16);
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onSuccess(@NonNull com.tencent.qqnt.http.api.b bVar, @NonNull m mVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) mVar);
                return;
            }
            try {
                Bundle a16 = a(bVar);
                EmoticonPackage b16 = b(a16, mVar);
                String a17 = f.a(EmojiManagerServiceImpl.this.mApp, bVar, a16.getBoolean(EmojiManagerServiceConstant.PARAMS_IS_SMALLEMOTION));
                if (a17 != null) {
                    QLog.e(EmojiManagerServiceImpl.TAG, 1, "jsonDownloadListener : parse json error : = " + a17);
                    return;
                }
                EmojiManagerServiceImpl.listenerManager.d(b16, mVar.a(), a16);
            } catch (Exception e16) {
                QLog.e(EmojiManagerServiceImpl.TAG, 1, "json download fail", e16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34828);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        TAG = EmojiManagerServiceImpl.class.getSimpleName();
        PACKAGE_TYPE_AUDIO = 0;
        PACKAGE_TYPE_VIDEO = 1;
        sCurPlayTimes = 0;
        sRecordBeginTime = 0L;
        sStartRecord = false;
        listenerManager = null;
        JSON_PREFIX = "json_";
    }

    public EmojiManagerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mApp = null;
        this.encryptKeyMap = new HashMap();
        this.mapParams = new HashMap<>();
        this.limitSize = QzoneConfig.DefaultValue.DEFAULT_WEISHI_VIDEO_MAX_BITRATE;
        this.haveInitFavWeb = false;
        this.haveInitSmallAndNormal = false;
        this.haveInitFav = false;
        this.emoQueue = new JobQueue(3);
        this.tasks = new HashMap();
    }

    private boolean checkSDCardNoAvailable(Emoticon emoticon) {
        if (Utils.B()) {
            if (Utils.z() < 1048576) {
                QLog.d(TAG, 1, "sdcard check, sdcard full .return.");
                return true;
            }
            return false;
        }
        QLog.d(TAG, 1, "sdcard check, has sdcard FALSE .return.");
        return true;
    }

    private boolean handleDownloadGifApngTask(Emoticon emoticon, int i3) {
        String[] strArr;
        int i16;
        if ((i3 & 4) == 4 || (i3 & 32) == 32) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downloadAIOEmoticon| Emoticon download emo gif.pid=" + emoticon.epId + " eid=" + emoticon.eId + " type=" + i3 + " time:" + System.currentTimeMillis());
            }
            if (emoticon.jobType != 1) {
                if ((i3 & 32) == 32) {
                    i16 = 2;
                } else {
                    i16 = 0;
                }
                strArr = handleImgGif(emoticon, i16);
                if (emoticon.jobType != 3 && TextUtils.isEmpty(emoticon.encryptKey)) {
                    new ArrayList().add(emoticon);
                    if (TextUtils.isEmpty(emoticon.encryptKey)) {
                        QLog.i(TAG, 1, "Emoticon don't have encryptKey,epId=" + emoticon.epId + ", eid=" + emoticon.eId + " type=4");
                        return true;
                    }
                }
            } else {
                strArr = null;
            }
            if (strArr == null) {
                QLog.d(TAG, 1, "handleDownloadGifApngTask error, urlInfo is null!");
                return true;
            }
            String str = strArr[1];
            boolean fileExists = FileUtils.fileExists(str);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleDownloadGifApngTask encryptEmojiFilePath = ", str, ", isEncryptEmojiFileExist = ", Boolean.valueOf(fileExists));
            }
            if (!fileExists) {
                m syncExecute = ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(new b.a("emoji", strArr[0], new File(str)).c());
                if (!syncExecute.e()) {
                    QLog.e(TAG, 1, "task gif down fail :epid = " + emoticon.epId + ";eid = " + emoticon.eId + ":ret = " + syncExecute.a());
                    return true;
                }
                com.tencent.qqnt.emotion.emosm.b.g(emoticon, str);
            }
        }
        return false;
    }

    private boolean handleDownloadPreviewStaticTask(Emoticon emoticon, int i3) {
        if ((i3 & 1) == 1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downloadAIOEmoticon| Emoticon download emo AIO preview static.pid=" + emoticon.epId + " eid=" + emoticon.eId + " type=" + i3);
            }
            String[] imgPreviewStaticTask = getImgPreviewStaticTask(emoticon);
            if (!FileUtils.fileExists(imgPreviewStaticTask[1])) {
                m syncExecute = ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(new b.a("emoji", imgPreviewStaticTask[0], new File(imgPreviewStaticTask[1])).c());
                if (!syncExecute.e()) {
                    QLog.e(TAG, 1, "task aio static down fail :epid = " + emoticon.epId + ";eid = " + emoticon.eId + ";ret = " + syncExecute.a());
                    return true;
                }
            }
        }
        return false;
    }

    private boolean handleDownloadPreviewTask(Emoticon emoticon, int i3) {
        if ((i3 & 2) == 2) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downloadAIOEmoticon| Emoticon download emo imgPreview.pid=" + emoticon.epId + " eid=" + emoticon.eId + " type=" + i3 + " time:" + System.currentTimeMillis() + ",jobType:" + emoticon.jobType);
            }
            String[] imgPreviewTask = getImgPreviewTask(emoticon);
            if (!FileUtils.fileExists(imgPreviewTask[1])) {
                m syncExecute = ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(new b.a("emoji", imgPreviewTask[0], new File(imgPreviewTask[1])).R(true).c());
                if (!syncExecute.e()) {
                    QLog.e(TAG, 1, "task preview down fail :epid = " + emoticon.epId + ";eid = " + emoticon.eId);
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "ret:" + syncExecute.a());
                }
            }
        }
        return false;
    }

    private boolean handleDownloadSoundTask(Emoticon emoticon, int i3) {
        if (emoticon.isSound && (i3 & 8) == 8) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downloadAIOEmoticon| Emoticon download emo sound.pid=" + emoticon.epId + " eid=" + emoticon.eId + " type=" + i3 + " time:" + System.currentTimeMillis());
            }
            String[] soundTask = getSoundTask(emoticon);
            if (!FileUtils.fileExists(soundTask[1])) {
                m syncExecute = ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(new b.a("emoji", soundTask[0], new File(soundTask[1])).c());
                if (!syncExecute.e()) {
                    QLog.e(TAG, 1, "task sound down fail :epid = " + emoticon.epId + ";eid = " + emoticon.eId + ";ret = " + syncExecute.a());
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.tencent.qqnt.emotion.api.IEmojiManagerService
    public boolean downloadAIOEmoticon(Emoticon emoticon, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) emoticon, i3)).booleanValue();
        }
        if (emoticon == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "downloadAIOEmoticon|taskvalue:" + i3 + "\uff0cepid:" + emoticon.epId + "\uff0ceid=" + emoticon.eId);
        }
        if (checkSDCardNoAvailable(emoticon) || handleDownloadPreviewTask(emoticon, i3) || handleDownloadGifApngTask(emoticon, i3) || handleDownloadPreviewStaticTask(emoticon, i3)) {
            return false;
        }
        return handleDownloadSoundTask(emoticon, i3);
    }

    @Override // com.tencent.qqnt.emotion.api.IEmojiManagerService
    public JobQueue getEmoQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (JobQueue) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.emoQueue;
    }

    @Override // com.tencent.qqnt.emotion.api.IEmojiManagerService
    public com.tencent.qqnt.emotion.manager.c getEmojiListenerManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.emotion.manager.c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return listenerManager;
    }

    public IEmoticonManagerService getEmoticonManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IEmoticonManagerService) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (IEmoticonManagerService) this.mApp.getRuntimeService(IEmoticonManagerService.class);
    }

    String[] getImgPreviewStaticTask(Emoticon emoticon) {
        String str;
        String str2;
        String str3;
        if (emoticon.jobType != 1) {
            boolean supportExtensionDisplay = supportExtensionDisplay(emoticon);
            String replace = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]x[height].png".replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", emoticon.eId);
            String str4 = "200";
            if (!supportExtensionDisplay) {
                str3 = "200";
            } else {
                str3 = String.valueOf(emoticon.extensionWidth);
            }
            String replace2 = replace.replace("[width]", str3);
            if (supportExtensionDisplay) {
                str4 = String.valueOf(emoticon.extensionHeight);
            }
            str = replace2.replace("[height]", str4);
            str2 = com.tencent.qqnt.emotion.constant.d.f356215m.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
        } else {
            str = null;
            str2 = null;
        }
        return new String[]{str, str2};
    }

    String[] getImgPreviewTask(Emoticon emoticon) {
        return getImgPreviewTask(emoticon.epId, emoticon.eId, emoticon.jobType == 3);
    }

    String[] getSoundTask(Emoticon emoticon) {
        return new String[]{"https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/ring.amr".replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", emoticon.eId), j.d(emoticon.epId, emoticon.eId)};
    }

    String[] handleImgGif(Emoticon emoticon, int i3) {
        String str;
        String replace;
        String str2;
        if (emoticon.jobType == 3) {
            replace = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].gif".replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
            if (i3 == 2) {
                replace = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId]_apng.png".replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
            }
        } else {
            boolean supportExtensionDisplay = supportExtensionDisplay(emoticon);
            if (1 == i3) {
                replace = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/pngframe.zip".replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", emoticon.eId);
            } else {
                String str3 = "200";
                if (i3 == 2) {
                    String replace2 = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]_apng".replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", emoticon.eId);
                    if (!supportExtensionDisplay) {
                        str2 = "200";
                    } else {
                        str2 = String.valueOf(emoticon.extensionWidth);
                    }
                    String replace3 = replace2.replace("[width]", str2);
                    if (supportExtensionDisplay) {
                        str3 = String.valueOf(emoticon.extensionHeight);
                    }
                    replace = replace3.replace("[height]", str3);
                } else {
                    String replace4 = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]".replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", emoticon.eId);
                    if (!supportExtensionDisplay) {
                        str = "200";
                    } else {
                        str = String.valueOf(emoticon.extensionWidth);
                    }
                    String replace5 = replace4.replace("[width]", str);
                    if (supportExtensionDisplay) {
                        str3 = String.valueOf(emoticon.extensionHeight);
                    }
                    replace = replace5.replace("[height]", str3);
                }
            }
        }
        String c16 = j.c(emoticon.epId, emoticon.eId);
        if (i3 == 2) {
            c16 = j.b(emoticon.epId, emoticon.eId);
        }
        if (1 == i3 && !TextUtils.isEmpty(c16)) {
            c16 = c16 + ".zip";
        }
        return new String[]{replace, c16};
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = (BaseQQAppInterface) appRuntime;
            listenerManager = com.tencent.qqnt.emotion.manager.a.c();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "clear History. uin:" + this.mApp.getAccount() + " app=" + String.valueOf(this.mApp));
        }
        if (this.mApp.getAccount() != null && getEmoticonManager() != null) {
            getEmoticonManager().clearCache();
        }
        synchronized (this.encryptKeyMap) {
            this.encryptKeyMap.clear();
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmojiManagerService
    public void startDownloadEmosmJson(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            startDownloadEmosmJson(str, i3, null, false, 0);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmojiManagerService
    public boolean supportExtensionDisplay(Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) emoticon)).booleanValue();
        }
        if (emoticon != null && emoticon.extensionWidth != 0 && emoticon.extensionHeight != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.api.IEmojiManagerService
    public boolean tasksFileExists(Emoticon emoticon, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) emoticon, i3)).booleanValue();
        }
        if (emoticon == null) {
            return true;
        }
        String str = null;
        if ((i3 & 1) == 1) {
            if (emoticon.jobType != 1) {
                str = j.a(emoticon.epId, emoticon.eId);
            }
            z16 = FileUtils.fileExists(str);
        } else {
            z16 = true;
        }
        if (z16 && (i3 & 4) == 4) {
            if (emoticon.jobType != 1) {
                str = j.e(emoticon.epId, emoticon.eId);
            }
            z16 = FileUtils.fileExists(str);
        }
        if (z16 && (i3 & 2) == 2) {
            z16 = FileUtils.fileExists(j.f(emoticon.epId, emoticon.eId));
        }
        if (z16 && emoticon.isSound && (i3 & 8) == 8) {
            z16 = FileUtils.fileExists(j.d(emoticon.epId, emoticon.eId));
        }
        if (z16 && (i3 & 32) == 32) {
            return FileUtils.fileExists(j.b(emoticon.epId, emoticon.eId));
        }
        return z16;
    }

    public String[] getImgPreviewTask(String str, String str2, boolean z16) {
        String replace;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String[]) iPatchRedirector.redirect((short) 6, this, str, str2, Boolean.valueOf(z16));
        }
        if (z16) {
            replace = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].png".replace("[epId]", str).replace("[eId]", str2);
        } else {
            replace = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/126x126.png".replace("[eIdSub]", str2.substring(0, 2)).replace("[eId]", str2);
        }
        return new String[]{replace, com.tencent.qqnt.emotion.constant.d.f356216n.replace("[epId]", str).replace("[eId]", str2)};
    }

    public void startDownloadEmosmJson(String str, int i3, Bundle bundle, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), bundle, Boolean.valueOf(z16), Integer.valueOf(i16));
        } else {
            if (str == null || str.length() == 0) {
                return;
            }
            this.emoQueue.excuteOnNetThread(new Runnable(z16, str, i16, i3, bundle) { // from class: com.tencent.qqnt.emotion.api.impl.EmojiManagerServiceImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f356144d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f356145e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f356146f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f356147h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ Bundle f356148i;

                {
                    this.f356144d = z16;
                    this.f356145e = str;
                    this.f356146f = i16;
                    this.f356147h = i3;
                    this.f356148i = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, EmojiManagerServiceImpl.this, Boolean.valueOf(z16), str, Integer.valueOf(i16), Integer.valueOf(i3), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String b16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f356144d) {
                        b16 = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/xydata.json".replace("[epId]", this.f356145e);
                    } else {
                        b16 = com.tencent.qqnt.emotion.utils.d.b(this.f356145e);
                    }
                    synchronized (EmojiManagerServiceImpl.this.tasks) {
                        com.tencent.qqnt.http.api.b bVar = (com.tencent.qqnt.http.api.b) EmojiManagerServiceImpl.this.tasks.get(b16);
                        if (bVar != null && !bVar.z()) {
                            if (QLog.isColorLevel()) {
                                QLog.d(EmojiManagerServiceImpl.TAG, 2, "startDownloadEmosmJson|epId is in downloading:" + this.f356145e);
                            }
                            return;
                        }
                        EmoticonPackage syncFindEmoticonPackageById = EmojiManagerServiceImpl.this.getEmoticonManager().syncFindEmoticonPackageById(this.f356145e, this.f356146f);
                        if (syncFindEmoticonPackageById == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d(EmojiManagerServiceImpl.TAG, 2, "startDownloadEmosmJson|emoPackage is not exist:" + this.f356145e);
                            }
                            syncFindEmoticonPackageById = new EmoticonPackage();
                            syncFindEmoticonPackageById.epId = this.f356145e;
                            syncFindEmoticonPackageById.status = 0;
                            int i17 = this.f356146f;
                            if (i17 == 0) {
                                syncFindEmoticonPackageById.aio = true;
                            } else if (i17 == 1) {
                                syncFindEmoticonPackageById.kandian = true;
                            }
                            EmojiManagerServiceImpl.this.getEmoticonManager().saveEmoticonPackage(syncFindEmoticonPackageById);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(EmojiManagerServiceImpl.TAG, 2, "startDownloadEmosmJson epId:" + syncFindEmoticonPackageById.epId);
                        }
                        File file = new File(com.tencent.qqnt.emotion.constant.d.f356214l.replace("[epId]", this.f356145e));
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("jsonType", this.f356147h);
                        bundle2.putSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG, syncFindEmoticonPackageById);
                        bundle2.putBoolean(EmojiManagerServiceConstant.PARAMS_IS_SMALLEMOTION, this.f356144d);
                        Bundle bundle3 = this.f356148i;
                        if (bundle3 != null) {
                            bundle2.putBundle(EmojiManagerServiceConstant.PARAMS_REQ, bundle3);
                        }
                        com.tencent.qqnt.http.api.b c16 = new b.a(EmojiManagerServiceImpl.TAG, b16, file).S(Bundle.class, bundle2).T(new a(b16)).c();
                        ((IHttpService) QRoute.api(IHttpService.class)).asyncExecute(c16);
                        synchronized (EmojiManagerServiceImpl.this.tasks) {
                            EmojiManagerServiceImpl.this.tasks.put(b16, c16);
                        }
                    }
                }
            }, true);
        }
    }
}
