package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class EmoticonHandlerProxy extends AbsHandlerProxy<EmoticonHandler> {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_EMOTICONHANDLER_FETCHEMOTICONRECOMMEND = "emoticonhandler_fetchemoticonrecommend";
    public static final String ACTION_EMOTICONHANDLER_FETCHIPSITEINFOEX = "emoticonhandler_fetchipsiteinfoex";
    public static final String ACTION_EMOTICONHANDLER_GETRECOMMENDEMOTICONINFO = "emoticonhandler_recommendEmoticonInfo";
    public static final String ACTION_EMOTICONHANDLER_GETSMALLYELLOWEMOITONREQUEST = "emoticonhandler_smallyellowemoitonrequest";
    public static final String ACTION_EMOTICONHANDLER_REPORTADDEMOTICONPKG = "emoticonhandler_reportaddemoticonpkg";
    public static final String ACTION_EMOTICONHANDLER_SAVEKANDIANRECOMMENDEMOTICON = "emoticonhandler_savekandianrecommendemoticon";
    private static final String BUSINESS_TYPE = "businessType";
    private static final String EPID = "epId";
    private static final String IGNORE_RICHINFO = "ignoreRichInfo";
    private static final String PARAM_BUSINESSTYPE = "param_businesstype";
    private static final String PARAM_LOCALLIST = "param_list_locallist";
    private static final String PARAM_SHOULDREVERSE = "param_shouldreverse";
    private static final String PARSEINT = "parseInt";
    public static final String TAG = "EmoticonHandlerProxy";

    public EmoticonHandlerProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, EmoticonHandler.F);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult checkMatch(AppRuntime appRuntime, String str, Bundle bundle, int i3) {
        if (ACTION_EMOTICONHANDLER_GETRECOMMENDEMOTICONINFO.equals(str)) {
            return onGetRecommendEmoticonInfo((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONHANDLER_GETSMALLYELLOWEMOITONREQUEST.equals(str)) {
            return onGetCommonUsedSmallYellowEmoitonRequest((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONHANDLER_REPORTADDEMOTICONPKG.equals(str)) {
            return onReportAddEmoticonPkg((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONHANDLER_FETCHEMOTICONRECOMMEND.equals(str)) {
            return onFetchEmoticonRecommend((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONHANDLER_FETCHIPSITEINFOEX.equals(str)) {
            return onFetchEmoticonIPSiteInformationEx((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONHANDLER_SAVEKANDIANRECOMMENDEMOTICON.equals(str)) {
            return onSaveKandianRecommendEmoticon((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        return null;
    }

    public static EIPCResult onFetchEmoticonIPSiteInformationEx(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((EmoticonHandler) baseQQAppInterface.getBusinessHandler(EmoticonHandler.F)).H2(bundle.getString("epId"), bundle.getBoolean(IGNORE_RICHINFO));
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onFetchEmoticonRecommend(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((EmoticonHandler) baseQQAppInterface.getBusinessHandler(EmoticonHandler.F)).J2(bundle.getInt(PARSEINT));
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onGetCommonUsedSmallYellowEmoitonRequest(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((EmoticonHandler) baseQQAppInterface.getBusinessHandler(EmoticonHandler.F)).Y0();
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onGetRecommendEmoticonInfo(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((EmoticonHandler) baseQQAppInterface.getBusinessHandler(EmoticonHandler.F)).h();
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onReportAddEmoticonPkg(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((EmoticonHandler) baseQQAppInterface.getBusinessHandler(EmoticonHandler.F)).W2(bundle.getString("epId"), bundle.getInt("businessType"));
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onSaveKandianRecommendEmoticon(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((EmoticonHandler) baseQQAppInterface.getBusinessHandler(EmoticonHandler.F)).k();
        return EIPCResult.createSuccessResult(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void fetchEmoticonIPSiteInformationEx(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
            return;
        }
        T t16 = this.businessHandler;
        if (t16 != 0) {
            ((EmoticonHandler) t16).H2(str, z16);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("epId", str);
        bundle.putBoolean(IGNORE_RICHINFO, z16);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOTICONHANDLER_FETCHIPSITEINFOEX, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "fetchEmoticonIPSiteInformationEx suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "fetchEmoticonIPSiteInformationEx fail.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void fetchEmoticonRecommend(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        T t16 = this.businessHandler;
        if (t16 != 0) {
            ((EmoticonHandler) t16).J2(i3);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(PARSEINT, i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOTICONHANDLER_FETCHEMOTICONRECOMMEND, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "fetchEmoticonRecommend suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "fetchEmoticonRecommend fail.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getCommonUsedSmallYellowEmoitonRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        T t16 = this.businessHandler;
        if (t16 != 0) {
            ((EmoticonHandler) t16).Y0();
            return;
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOTICONHANDLER_GETSMALLYELLOWEMOITONREQUEST, null);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "getCommonUsedSmallYellowEmoitonRequest suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "getCommonUsedSmallYellowEmoitonRequest fail.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getRecommendEmoticonInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        T t16 = this.businessHandler;
        if (t16 != 0) {
            ((EmoticonHandler) t16).h();
            return;
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOTICONHANDLER_GETRECOMMENDEMOTICONINFO, null);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "getRecommendEmoticonInfo suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "getRecommendEmoticonInfo fail.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reportAddEmoticonPkg(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
            return;
        }
        T t16 = this.businessHandler;
        if (t16 != 0) {
            ((EmoticonHandler) t16).W2(str, i3);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("epId", str);
        bundle.putInt("businessType", i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOTICONHANDLER_REPORTADDEMOTICONPKG, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "reportAddEmoticonPkg suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "reportAddEmoticonPkg fail.");
    }
}
