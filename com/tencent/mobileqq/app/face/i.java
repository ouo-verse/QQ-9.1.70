package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.handler.AvatarHandler;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proavatar.ProAvatarComponentInit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/app/face/i;", "", "Lcom/tencent/mobileqq/avatar/handler/AvatarHandler;", "avatarHandler", "Lcom/tencent/mobileqq/app/face/FaceInfo;", "faceInfo", "", "a", "Lcom/tencent/mobileqq/data/Setting;", "setting", "b", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f195595a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17061);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f195595a = new i();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @WorkerThread
    public static final void a(@NotNull AvatarHandler avatarHandler, @NotNull FaceInfo faceInfo) {
        Intrinsics.checkNotNullParameter(avatarHandler, "avatarHandler");
        Intrinsics.checkNotNullParameter(faceInfo, "faceInfo");
        if (!AvatarOptimiseConfigUtil.a()) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("FaceInfoSaveHelper", 4, "saveInfoAndNotify faceInfo: " + faceInfo);
        }
        QQHeadInfo qQHeadInfo = faceInfo.mHeadInfo;
        Intrinsics.checkNotNullExpressionValue(qQHeadInfo, "faceInfo.mHeadInfo");
        String h36 = AvatarHandler.h3(qQHeadInfo.uin, qQHeadInfo.phoneNum);
        String j3 = com.tencent.mobileqq.avatar.utils.c.j(qQHeadInfo.dstUsrType, h36, qQHeadInfo.idType);
        ProAvatarComponentInit.f(faceInfo);
        Object obj = QQHeadDownloadHandler.getFaceSetting(faceInfo, h36, j3, false, true)[1];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.data.Setting");
        Setting setting = (Setting) obj;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ((IQQAvatarDataService) peekAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).updateSettingTableCache(setting);
        f195595a.b(setting);
        com.tencent.mobileqq.avatar.utils.c.t(peekAppRuntime, setting);
        avatarHandler.r3(com.tencent.mobileqq.avatar.utils.c.h(qQHeadInfo.dstUsrType, h36, qQHeadInfo.idType, qQHeadInfo.sizeType), true);
        avatarHandler.notifyUI(0, true, setting);
        ArrayList arrayList = new ArrayList();
        arrayList.add(qQHeadInfo);
        com.tencent.mobileqq.proavatar.info.a.o(arrayList);
    }

    private final void b(Setting setting) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("FaceInfoSaveHelper", 1, "UpdateSettingRunnable app is null");
            return;
        }
        EntityManager createEntityManager = peekAppRuntime.getEntityManagerFactory().createEntityManager();
        if (setting.getStatus() == 1000) {
            createEntityManager.persistOrReplace(setting);
        } else if (setting.getStatus() == 1001 || setting.getStatus() == 1002) {
            createEntityManager.update(setting);
        }
        createEntityManager.close();
    }
}
