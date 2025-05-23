package com.tencent.mobileqq.troop.homework.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IHWTroopUtilsApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;
    public static final String HOMEWORK_AIO_TIPS_SOURCE = "aioTip";
    public static final Integer HOMEWORK_SCHOOL_EDIT_FROM;
    public static final String HOMEWORK_TROOP_JOIN_SOURCE = "join";
    public static final String HOMEWORK_TROOP_PROFILE_SOURCE = "troopProfile";
    public static final String HOMEWORK_TROOP_SCHOOL_MODIFY_URL = "https://admin.qun.qq.com/mcreatev4/classinfo?gc=%1$s&from=%2$s";
    public static final String HW_TROOP_BACK_EVENT = "onHomeworkTroopBack";
    public static final String HW_TROOP_IDENTITY_CHANGED_EVENT = "onHomeworkTroopIdentityChanged";

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(28582), (Class<?>) IHWTroopUtilsApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            HOMEWORK_SCHOOL_EDIT_FROM = 3;
        }
    }

    void clearHomeworkTroopRedPoint(AppInterface appInterface, String str);

    int getAIOHomeworkBtnRedPoint(AppRuntime appRuntime, String str);

    boolean hasHomeworkTroopIdentity(int i3);

    void setAIOHomeworkBtnRedPoint(AppRuntime appRuntime, String str, int i3);
}
