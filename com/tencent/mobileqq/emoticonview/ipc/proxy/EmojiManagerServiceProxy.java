package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.TaskStatus;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class EmojiManagerServiceProxy extends AbsEmoRuntimeServiceProxy<IEmojiManagerService> {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_EMOJIMANAGER_DOWNLOADAIOEMOTICON = "emojimanager_downemoticon";
    public static final String ACTION_EMOJIMANAGER_GETLOADINGPROGRESS = "emojimanager_getloadingprogress";
    public static final String ACTION_EMOJIMANAGER_HAVEINITFAV = "emojimanager_haveinitfav";
    public static final String ACTION_EMOJIMANAGER_HAVEINITSMALLANDNORMAL = "emojimanager_haveInitSmallAndNormal";
    public static final String ACTION_EMOJIMANAGER_PULLEMOTICONPACKAGE = "emojimanager_pullemoticonpackage";
    public static final String ACTION_EMOJIMANAGER_SETHAVEINITFAV = "emojimanager_setHaveInitFav";
    public static final String ACTION_EMOJIMANAGER_SETHAVEINITSMALLANDNORMAL = "emojimanager_sethaveinitsmallandnormal";
    public static final String ACTION_EMOJIMANAGER_STARTCOVERDOWNLOAD = "emojimanager_startcoverdownload";
    public static final String ACTION_EMOJIMANAGER_STARTDOWNLOADEMOSMJSON = "emojimanager_startdownloademosmjson";
    public static final String ACTION_EMOJIMANAGER_STATUSPERCENT = "emojimanager_statuspercent";
    public static final String ACTION_EMOJIMANAGER_STOPEMOTICONPACKAGE = "emojimanager_stopemoticonpackage";
    public static final String ACTION_EMOJIMANAGER_TASKSFILEEXISTS = "emojimanager_tasksfileexists";
    public static final String BUSINESS_TYPE = "businessType";
    public static final String EMOTICON_BUSINESSTYPE = "emoticon_businessType";
    public static final String EMOTICON_NEWPACKAGE = "emoticon_newPackage";
    public static final String EMOTICON_PACKAGE = "emoticon_package";
    public static final String EMOTICON_SWITCHTAB = "emoticon_switchTab";
    public static final String EMOTICON_TASKS = "emoticon_tasks";
    public static final String EMOTICON_TASKS_DOWNLOAD = "emoticon_download";
    public static final String EMOTICON_TASKS_FILEEXISTS = "emoticon_tasksfileexists";
    public static final String EPID = "epId";
    public static final String HAVE_INITFAV = "haveInitFav";
    public static final String IS_SMALLEMOTICON = "is_smallemoticon";
    public static final String JSON_TYPE = "jsonType";
    public static final String LOADING_PROGRESS = "loading_progress";
    public static final String REQ_PRAMAS = "req_pramas";
    public static final String TAG = "EmojiManagerServiceProxy";

    public EmojiManagerServiceProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, IEmojiManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult checkMatch(AppRuntime appRuntime, String str, Bundle bundle, int i3) {
        if (ACTION_EMOJIMANAGER_HAVEINITFAV.equals(str)) {
            return onHaveInitFav((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOJIMANAGER_SETHAVEINITFAV.equals(str)) {
            return onSetHaveInitFav((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOJIMANAGER_HAVEINITSMALLANDNORMAL.equals(str)) {
            return onHaveInitSmallAndNormal((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOJIMANAGER_SETHAVEINITSMALLANDNORMAL.equals(str)) {
            return onSetHaveInitSmallAndNormal((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOJIMANAGER_GETLOADINGPROGRESS.equals(str)) {
            return onGetEmoticonPackageLoadingProgress((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOJIMANAGER_PULLEMOTICONPACKAGE.equals(str)) {
            return onPullEmoticonPackage((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOJIMANAGER_STOPEMOTICONPACKAGE.equals(str)) {
            return onStopEmoticonPackageDownload((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOJIMANAGER_STARTDOWNLOADEMOSMJSON.equals(str)) {
            return onStartDownloadEmosmJson((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOJIMANAGER_STARTCOVERDOWNLOAD.equals(str)) {
            return onStartCoverDownload((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOJIMANAGER_TASKSFILEEXISTS.equals(str)) {
            return onTasksFileExists((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOJIMANAGER_DOWNLOADAIOEMOTICON.equals(str)) {
            return onDownloadAIOEmoticon((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOJIMANAGER_STATUSPERCENT.equals(str)) {
            return onGetStatusPercent((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        return null;
    }

    public static EIPCResult onDownloadAIOEmoticon(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        boolean downloadAIOEmoticon = ((IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).downloadAIOEmoticon((Emoticon) bundle.getSerializable(EMOTICON_PACKAGE), bundle.getInt(EMOTICON_TASKS));
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(EMOTICON_TASKS_DOWNLOAD, downloadAIOEmoticon);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public static EIPCResult onGetEmoticonPackageLoadingProgress(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        float emoticonPackageLoadingProgress = ((IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).getEmoticonPackageLoadingProgress(bundle.getString(EPID));
        Bundle bundle2 = new Bundle();
        bundle2.putFloat(LOADING_PROGRESS, emoticonPackageLoadingProgress);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public static EIPCResult onGetStatusPercent(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        float f16;
        TaskStatus taskStatus = ((IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).getStatusMap().get(bundle.getString(EPID));
        if (taskStatus != null) {
            f16 = taskStatus.getPercent();
        } else {
            f16 = -1.0f;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putFloat(EMOTICON_TASKS_DOWNLOAD, f16);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public static EIPCResult onHaveInitFav(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(HAVE_INITFAV, iEmojiManagerService.getHaveInitFav());
        return EIPCResult.createSuccessResult(bundle2);
    }

    public static EIPCResult onHaveInitSmallAndNormal(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(HAVE_INITFAV, iEmojiManagerService.getHaveInitSmallAndNormal());
        return EIPCResult.createSuccessResult(bundle2);
    }

    public static EIPCResult onPullEmoticonPackage(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        QLog.d(TAG, 4, "thread_name: " + Thread.currentThread().getName());
        ((IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).pullEmoticonPackage((EmoticonPackage) bundle.getSerializable(EMOTICON_PACKAGE), bundle.getBoolean(EMOTICON_NEWPACKAGE), bundle.getBoolean(EMOTICON_SWITCHTAB), bundle.getInt(EMOTICON_BUSINESSTYPE, 0));
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onSetHaveInitFav(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).setHaveInitFav(bundle.getBoolean(HAVE_INITFAV));
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onSetHaveInitSmallAndNormal(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).setHaveInitSmallAndNormal(bundle.getBoolean(HAVE_INITFAV));
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onStartCoverDownload(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).startCoverDownload((EmoticonPackage) bundle.getSerializable(EMOTICON_PACKAGE));
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onStartDownloadEmosmJson(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        String string = bundle.getString(EPID);
        int i16 = bundle.getInt("jsonType");
        int i17 = bundle.getInt("businessType");
        ((IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).startDownloadEmosmJson(string, i16, bundle.getBundle(REQ_PRAMAS), bundle.getBoolean(IS_SMALLEMOTICON), i17);
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onStopEmoticonPackageDownload(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).stopEmoticonPackageDownload(bundle.getString(EPID));
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onTasksFileExists(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        boolean tasksFileExists = ((IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).tasksFileExists((Emoticon) bundle.getSerializable(EMOTICON_PACKAGE), bundle.getInt(EMOTICON_TASKS));
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(EMOTICON_TASKS_FILEEXISTS, tasksFileExists);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public boolean downloadAIOEmoticon(Emoticon emoticon, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) emoticon, i3)).booleanValue();
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmojiManagerService) t16).downloadAIOEmoticon(emoticon, i3);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(EMOTICON_PACKAGE, emoticon);
        bundle.putInt(EMOTICON_TASKS, i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOJIMANAGER_DOWNLOADAIOEMOTICON, bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean(EMOTICON_TASKS_DOWNLOAD);
        }
        QLog.e(TAG, 4, "downloadAIOEmoticon fail.");
        return false;
    }

    public float getEmoticonPackageLoadingProgress(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).floatValue();
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmojiManagerService) t16).getEmoticonPackageLoadingProgress(str);
        }
        Bundle bundle = new Bundle();
        bundle.putString(EPID, str);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOJIMANAGER_GETLOADINGPROGRESS, bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getFloat(LOADING_PROGRESS);
        }
        QLog.e(TAG, 4, "setHaveInitSmallAndNormal fail.");
        return 0.0f;
    }

    public float getStatusPercent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Float) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str)).floatValue();
        }
        if (str == null) {
            return -1.0f;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            TaskStatus taskStatus = ((IEmojiManagerService) t16).getStatusMap().get(str);
            if (taskStatus == null) {
                return -1.0f;
            }
            return taskStatus.getPercent();
        }
        Bundle bundle = new Bundle();
        bundle.putString(EPID, str);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOJIMANAGER_STATUSPERCENT, bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getFloat(EMOTICON_TASKS_DOWNLOAD);
        }
        QLog.e(TAG, 4, "getStatusPercent fail.");
        return -1.0f;
    }

    public boolean haveInitFav() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmojiManagerService) t16).getHaveInitFav();
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOJIMANAGER_HAVEINITFAV, null);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean(HAVE_INITFAV);
        }
        QLog.e(TAG, 4, "haveInitFav fail.");
        return false;
    }

    public boolean haveInitSmallAndNormal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmojiManagerService) t16).getHaveInitSmallAndNormal();
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOJIMANAGER_HAVEINITSMALLANDNORMAL, null);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean(HAVE_INITFAV);
        }
        QLog.e(TAG, 4, "haveInitSmallAndNormal fail.");
        return false;
    }

    public void pullEmoticonPackage(EmoticonPackage emoticonPackage, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            pullEmoticonPackage(emoticonPackage, z16, true, i3);
        } else {
            iPatchRedirector.redirect((short) 7, this, emoticonPackage, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    public void setHaveInitFav(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IEmojiManagerService) t16).setHaveInitFav(z16);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(HAVE_INITFAV, z16);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOJIMANAGER_SETHAVEINITFAV, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "setHaveInitFav suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "setHaveInitFav fail.");
    }

    public void setHaveInitSmallAndNormal(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IEmojiManagerService) t16).setHaveInitSmallAndNormal(z16);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(HAVE_INITFAV, z16);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOJIMANAGER_SETHAVEINITSMALLANDNORMAL, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "setHaveInitSmallAndNormal suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "setHaveInitSmallAndNormal fail.");
    }

    public void startCoverDownload(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) emoticonPackage);
            return;
        }
        if (emoticonPackage == null) {
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IEmojiManagerService) t16).startCoverDownload(emoticonPackage);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(EMOTICON_PACKAGE, emoticonPackage);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOJIMANAGER_STARTCOVERDOWNLOAD, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "startCoverDownload suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "startCoverDownload fail.");
    }

    public void startDownloadEmosmJson(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            startDownloadEmosmJson(str, i3, null, false, 0);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
        }
    }

    public void stopEmoticonPackageDownload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IEmojiManagerService) t16).stopEmoticonPackageDownload(str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(EPID, str);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOJIMANAGER_STOPEMOTICONPACKAGE, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "stopEmoticonPackageDownload suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "stopEmoticonPackageDownload fail.");
    }

    public boolean tasksFileExists(Emoticon emoticon, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) emoticon, i3)).booleanValue();
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmojiManagerService) t16).tasksFileExists(emoticon, i3);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(EMOTICON_PACKAGE, emoticon);
        bundle.putInt(EMOTICON_TASKS, i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOJIMANAGER_TASKSFILEEXISTS, bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean(EMOTICON_TASKS_FILEEXISTS);
        }
        QLog.e(TAG, 4, "tasksFileExists fail.");
        return false;
    }

    public void pullEmoticonPackage(EmoticonPackage emoticonPackage, boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, emoticonPackage, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
            return;
        }
        if (emoticonPackage == null) {
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IEmojiManagerService) t16).pullEmoticonPackage(emoticonPackage, z16, z17, i3);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(EMOTICON_PACKAGE, emoticonPackage);
        bundle.putBoolean(EMOTICON_NEWPACKAGE, z16);
        bundle.putBoolean(EMOTICON_SWITCHTAB, z17);
        bundle.putInt(EMOTICON_BUSINESSTYPE, i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOJIMANAGER_PULLEMOTICONPACKAGE, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "pullEmoticonPackage suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "pullEmoticonPackage fail.");
    }

    public void startDownloadEmosmJson(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            startDownloadEmosmJson(str, i3, null, false, i16);
        } else {
            iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void startDownloadEmosmJson(String str, int i3, Bundle bundle, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            startDownloadEmosmJson(str, i3, bundle, z16, 0);
        } else {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), bundle, Boolean.valueOf(z16));
        }
    }

    public void startDownloadEmosmJson(String str, int i3, Bundle bundle, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), bundle, Boolean.valueOf(z16), Integer.valueOf(i16));
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IEmojiManagerService) t16).startDownloadEmosmJson(str, i3, bundle, z16, i16);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(EPID, str);
        bundle2.putInt("jsonType", i3);
        bundle2.putInt("businessType", i16);
        bundle2.putBundle(REQ_PRAMAS, bundle);
        bundle2.putBoolean(IS_SMALLEMOTICON, z16);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOJIMANAGER_STARTDOWNLOADEMOSMJSON, bundle2);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "startDownloadEmosmJson suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "startDownloadEmosmJson fail.");
    }
}
