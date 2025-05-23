package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avatar.api.IQQAvatarMagicAvatarUtilsApi;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarIpcUpdateAvatarUtilsApiImpl;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.friendclue.FriendClueManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static g f195659d;

    g() {
        super("CommonModule");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static g b() {
        if (f195659d == null) {
            synchronized (g.class) {
                if (f195659d == null) {
                    f195659d = new g();
                }
            }
        }
        return f195659d;
    }

    public void c(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CommonModule", 2, "onSetAvatarBackResult\uff0c intent=" + intent);
        }
        if (intent != null) {
            int intExtra = intent.getIntExtra("param_callback_id", -1);
            int intExtra2 = intent.getIntExtra(FaceConstant.HeadParams.PARAM_RESULT_CODE, -99999);
            String stringExtra = intent.getStringExtra(FaceConstant.HeadParams.PARAM_RESULT_DESC);
            if (intExtra > 0) {
                Bundle bundle = new Bundle();
                bundle.putInt(FaceConstant.HeadParams.PARAM_RESULT_CODE, intExtra2);
                bundle.putString(FaceConstant.HeadParams.PARAM_RESULT_DESC, stringExtra);
                bundle.putString("param_action", "set_avatar");
                callbackResult(intExtra, EIPCResult.createSuccessResult(bundle));
            }
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("CommonModule", 2, "action = " + str + ", params = " + bundle);
        }
        Bundle bundle2 = new Bundle();
        String str2 = "";
        if ("getPhoneBindState".equals(str)) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                bundle2.putInt("selfBindState", ((IPhoneContactService) runtime.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState());
                return EIPCResult.createSuccessResult(bundle2);
            }
        } else if ("set_avatar".equals(str)) {
            AppRuntime runtime2 = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime2 instanceof QQAppInterface) {
                if (bundle != null) {
                    str2 = bundle.getString("param_avatar_path");
                }
                Intent intent = new Intent();
                intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_MINI_APP");
                intent.putExtra("param_callback_id", i3);
                if (bundle != null && bundle.containsKey(QQAvatarIpcUpdateAvatarUtilsApiImpl.PHOTO_SYNCQZONE)) {
                    boolean z17 = bundle.getBoolean(QQAvatarIpcUpdateAvatarUtilsApiImpl.PHOTO_SYNCQZONE, false);
                    ((IQQAvatarMagicAvatarUtilsApi) QRoute.api(IQQAvatarMagicAvatarUtilsApi.class)).setSyncQzoneSwitch(BaseApplicationImpl.getApplication(), z17);
                    intent.putExtra(QQAvatarIpcUpdateAvatarUtilsApiImpl.PHOTO_SYNCQZONE, z17);
                }
                if (bundle != null && bundle.containsKey("PhotoConst.EXT_INFO")) {
                    intent.putExtra("PhotoConst.EXT_INFO", bundle.getSerializable("PhotoConst.EXT_INFO"));
                }
                if (bundle == null || !bundle.getBoolean(QQAvatarIpcUpdateAvatarUtilsApiImpl.PARAM_NEED_CROP_TO_SQUARE, false)) {
                    z16 = false;
                }
                ProfileCardUtil.a j06 = ProfileCardUtil.j0((QQAppInterface) runtime2, str2, intent, z16);
                int i16 = j06.f306430a;
                if (i16 != 0) {
                    bundle2.putInt(FaceConstant.HeadParams.PARAM_RESULT_CODE, i16);
                    bundle2.putString(FaceConstant.HeadParams.PARAM_RESULT_DESC, j06.f306431b);
                    bundle2.putString("param_action", "set_avatar");
                    callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
                } else {
                    return null;
                }
            }
        } else if ("jumpToCommonGroup".equals(str)) {
            AppRuntime runtime3 = BaseApplicationImpl.getApplication().getRuntime();
            if ((runtime3 instanceof QQAppInterface) && bundle != null) {
                ((FriendClueManager) runtime3.getManager(QQManagerFactory.FRIEND_CLUE_MANAGER)).e(bundle.getString("cur_friend_uin"));
            }
        } else if ("jumpToRemarkEdit".equals(str)) {
            AppRuntime runtime4 = BaseApplicationImpl.getApplication().getRuntime();
            if ((runtime4 instanceof QQAppInterface) && bundle != null) {
                ((FriendClueManager) runtime4.getManager(QQManagerFactory.FRIEND_CLUE_MANAGER)).f(bundle.getString("cur_friend_uin"));
            }
        }
        return EIPCResult.createSuccessResult(bundle2);
    }
}
