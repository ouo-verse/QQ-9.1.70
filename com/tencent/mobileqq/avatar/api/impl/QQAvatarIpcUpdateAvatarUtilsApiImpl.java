package com.tencent.mobileqq.avatar.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avatar.api.IQQAvatarIpcUpdateAvatarUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/impl/QQAvatarIpcUpdateAvatarUtilsApiImpl;", "Lcom/tencent/mobileqq/avatar/api/IQQAvatarIpcUpdateAvatarUtilsApi;", "", "path", "", "syncQzone", "Lcom/tencent/mobileqq/avatar/api/IQQAvatarIpcUpdateAvatarUtilsApi$a;", "callback", "", "callIpcSetAvatar", "setUserAvatar", "<init>", "()V", "Companion", "a", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QQAvatarIpcUpdateAvatarUtilsApiImpl implements IQQAvatarIpcUpdateAvatarUtilsApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String ACTION_SET_AVATAR = "set_avatar";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String NAME_COMMON_MODULE = "CommonModule";

    @NotNull
    public static final String PARAM_AVATAR_PATH = "param_avatar_path";

    @NotNull
    public static final String PARAM_NEED_CROP_TO_SQUARE = "param_need_crop_to_square";

    @NotNull
    public static final String PHOTO_SYNCQZONE = "PhotoConst.SYNCQZONE";

    @NotNull
    public static final String TAG = "magicAvatar.SetAvatarUtilsApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/impl/QQAvatarIpcUpdateAvatarUtilsApiImpl$a;", "", "", "ACTION_SET_AVATAR", "Ljava/lang/String;", "NAME_COMMON_MODULE", "PARAM_AVATAR_PATH", "PARAM_NEED_CROP_TO_SQUARE", "PHOTO_SYNCQZONE", "TAG", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.avatar.api.impl.QQAvatarIpcUpdateAvatarUtilsApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17297);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQAvatarIpcUpdateAvatarUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void callIpcSetAvatar(String path, boolean syncQzone, final IQQAvatarIpcUpdateAvatarUtilsApi.a callback) {
        boolean z16;
        boolean z17;
        QLog.d(TAG, 1, "call path: " + path + ", syncQzone: " + syncQzone);
        if (path != null) {
            if (path.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if (!z16) {
                    if (callback != null) {
                        callback.onResult(false, "path is null or empty");
                        return;
                    }
                    return;
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("param_avatar_path", path);
                    bundle.putBoolean(PHOTO_SYNCQZONE, syncQzone);
                    bundle.putBoolean(PARAM_NEED_CROP_TO_SQUARE, true);
                    QIPCClientHelper.getInstance().getClient().callServer(NAME_COMMON_MODULE, ACTION_SET_AVATAR, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.avatar.api.impl.c
                        @Override // eipc.EIPCResultCallback
                        public final void onCallback(EIPCResult eIPCResult) {
                            QQAvatarIpcUpdateAvatarUtilsApiImpl.callIpcSetAvatar$lambda$0(IQQAvatarIpcUpdateAvatarUtilsApi.a.this, eIPCResult);
                        }
                    });
                    return;
                }
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callIpcSetAvatar$lambda$0(IQQAvatarIpcUpdateAvatarUtilsApi.a aVar, EIPCResult eIPCResult) {
        Integer num;
        if (eIPCResult == null) {
            if (aVar != null) {
                aVar.onResult(false, "eipcResult is null");
                return;
            }
            return;
        }
        if (!eIPCResult.isSuccess()) {
            if (aVar != null) {
                aVar.onResult(false, "eipc connect fail. code: " + eIPCResult.code);
                return;
            }
            return;
        }
        Bundle bundle = eIPCResult.data;
        String str = null;
        if (bundle != null) {
            num = Integer.valueOf(bundle.getInt(FaceConstant.HeadParams.PARAM_RESULT_CODE, -99999));
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            if (aVar != null) {
                IQQAvatarIpcUpdateAvatarUtilsApi.a.C7431a.a(aVar, true, null, 2, null);
                return;
            }
            return;
        }
        Bundle bundle2 = eIPCResult.data;
        if (bundle2 != null) {
            str = bundle2.getString(FaceConstant.HeadParams.PARAM_RESULT_DESC);
        }
        String str2 = "code: " + num + ", desc: " + str;
        if (aVar != null) {
            aVar.onResult(false, str2);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarIpcUpdateAvatarUtilsApi
    public void setUserAvatar(@Nullable String path, boolean syncQzone, @Nullable IQQAvatarIpcUpdateAvatarUtilsApi.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, path, Boolean.valueOf(syncQzone), callback);
        } else {
            callIpcSetAvatar(path, syncQzone, callback);
        }
    }
}
