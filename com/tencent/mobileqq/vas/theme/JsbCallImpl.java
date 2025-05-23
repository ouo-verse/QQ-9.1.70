package com.tencent.mobileqq.vas.theme;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.vas.api.IVasProfileCardApi;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.inject.IVasInject;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.manager.api.IJsbCallManager;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateBusiness;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.theme.api.IThemeRequest;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeDIYData;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 52\u00020\u0001:\u0002\u00036B\u0007\u00a2\u0006\u0004\b3\u00104J\u000e\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\u000e\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016JJ\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u001a\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0004H\u0016J:\u0010*\u001a\u00020\b2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010-\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010,\u001a\u00020+H\u0016R\u001a\u00102\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/JsbCallImpl;", "Lcom/tencent/mobileqq/vas/manager/api/IJsbCallManager;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "a", "", "uin", "Lcom/tencent/mobileqq/vas/theme/diy/ThemeDIYData;", "diyData", "", "setDiyThemeBackground", "picPath", "", "effectId", "uinType", "setCustomChatBackground", "id", "friendUin", "path", "name", "url", "feetype", "entryType", "setChatBackground", "curThemeId", "Leipc/EIPCCallback;", "callback", "detailWithDarkMode", "Landroid/os/Bundle;", "bundle", "requestThemeServer", "getCurrentChatBgId", "startDownloadTheme", "type", "saveFont", "themeId", "setThemeAndBackGround", "", "layoutId", "backgroundId", "cardId", "extInfo", "diyTemplate", "setProfileCard", "", "forceRequest", "getCardInfo", "d", "Ljava/lang/String;", "getManagerName", "()Ljava/lang/String;", "managerName", "<init>", "()V", "e", "DialogFragment", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class JsbCallImpl implements IJsbCallManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String managerName = "JsbCall";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/JsbCallImpl$DialogFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class DialogFragment extends QPublicBaseFragment {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private static String D = "";

        @Nullable
        private static EIPCCallback E;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/JsbCallImpl$DialogFragment$a;", "", "", "curThemeId", "Ljava/lang/String;", "getCurThemeId", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "Leipc/EIPCCallback;", "callback", "Leipc/EIPCCallback;", "a", "()Leipc/EIPCCallback;", "b", "(Leipc/EIPCCallback;)V", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.vas.theme.JsbCallImpl$DialogFragment$a, reason: from kotlin metadata */
        /* loaded from: classes20.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Nullable
            public final EIPCCallback a() {
                return DialogFragment.E;
            }

            public final void b(@Nullable EIPCCallback eIPCCallback) {
                DialogFragment.E = eIPCCallback;
            }

            public final void c(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                DialogFragment.D = str;
            }

            Companion() {
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/vas/theme/JsbCallImpl$DialogFragment$b", "Lcom/tencent/mobileqq/vas/inject/IVasInject$ActionResult;", "", "onConfirm", "onCancel", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class b implements IVasInject.ActionResult {
            b() {
            }

            @Override // com.tencent.mobileqq.vas.inject.IVasInject.ActionResult
            public void onCancel() {
                EIPCCallback a16 = DialogFragment.INSTANCE.a();
                if (a16 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("choose", "cancel");
                    a16.callback(EIPCResult.createSuccessResult(bundle));
                }
                DialogFragment.this.requireActivity().finish();
            }

            @Override // com.tencent.mobileqq.vas.inject.IVasInject.ActionResult
            public void onConfirm() {
                EIPCCallback a16 = DialogFragment.INSTANCE.a();
                if (a16 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("choose", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
                    a16.callback(EIPCResult.createSuccessResult(bundle));
                }
                DialogFragment.this.requireActivity().finish();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
        public int getContentLayoutId() {
            return R.layout.ccn;
        }

        @Override // androidx.fragment.app.Fragment
        public void onDestroyView() {
            super.onDestroyView();
            D = "";
            E = null;
        }

        @Override // androidx.fragment.app.Fragment
        public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            if (!VasInjectApi.getInstance().darkModeUserSetThemeAction(getActivity(), D, new b())) {
                EIPCCallback eIPCCallback = E;
                if (eIPCCallback != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("choose", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
                    eIPCCallback.callback(EIPCResult.createSuccessResult(bundle));
                }
                requireActivity().finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J4\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/vas/theme/JsbCallImpl$b", "Lcom/tencent/mobileqq/vas/updatesystem/callback/QuickUpdateListener;", "", "bid", "", "scid", "cfgScid", "from", "", "errorCode", "httpCode", "", "onCompleted", "dwProgress", "dwProgressMax", "onProgress", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements QuickUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EIPCCallback f310879d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f310880e;

        b(EIPCCallback eIPCCallback, String str) {
            this.f310879d = eIPCCallback;
            this.f310880e = str;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener
        public void onCompleted(long bid, @Nullable String scid, @Nullable String cfgScid, @Nullable String from, int errorCode, int httpCode) {
            String str;
            EIPCCallback eIPCCallback = this.f310879d;
            if (eIPCCallback != null) {
                Bundle bundle = new Bundle();
                bundle.putString("themeId", this.f310880e);
                if (errorCode == 0) {
                    str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                } else {
                    str = "fail";
                }
                bundle.putString("result", str);
                bundle.putInt("errorCode", errorCode);
                bundle.putInt("httpCode", httpCode);
                eIPCCallback.callback(EIPCResult.createSuccessResult(bundle));
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener
        public void onProgress(long bid, @Nullable String scid, @Nullable String cfgScid, long dwProgress, long dwProgressMax) {
            EIPCCallback eIPCCallback = this.f310879d;
            if (eIPCCallback != null) {
                Bundle bundle = new Bundle();
                bundle.putString("themeId", this.f310880e);
                bundle.putBoolean("isProgress", true);
                bundle.putLong("progress", dwProgress);
                bundle.putLong("progressMax", dwProgressMax);
                eIPCCallback.callback(EIPCResult.createSuccessResult(bundle));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/theme/JsbCallImpl$c", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadFail", "onLoadSuccess", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f310881a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EIPCCallback f310882b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f310883c;

        c(String str, EIPCCallback eIPCCallback, String str2) {
            this.f310881a = str;
            this.f310882b = eIPCCallback;
            this.f310883c = str2;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            QLog.i("JsbCallImpl", 1, "startDownloadTheme failed: scid=" + this.f310881a);
            EIPCCallback eIPCCallback = this.f310882b;
            if (eIPCCallback != null) {
                Bundle bundle = new Bundle();
                bundle.putString("themeId", this.f310883c);
                bundle.putString("result", "fail");
                bundle.putInt("errorCode", params.mErrorCode);
                bundle.putInt("httpCode", params.mHttpCode);
                eIPCCallback.callback(EIPCResult.createSuccessResult(bundle));
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            QLog.i("JsbCallImpl", 1, "startDownloadTheme success: scid=" + this.f310881a);
            EIPCCallback eIPCCallback = this.f310882b;
            if (eIPCCallback != null) {
                Bundle bundle = new Bundle();
                bundle.putString("themeId", this.f310883c);
                bundle.putString("result", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                bundle.putInt("errorCode", params.mErrorCode);
                bundle.putInt("httpCode", params.mHttpCode);
                eIPCCallback.callback(EIPCResult.createSuccessResult(bundle));
            }
        }
    }

    private final QQVasUpdateBusiness<?> a() {
        Boolean isUseUpdateBusinessMigration = QQVasUpdateBusiness.isUseUpdateBusinessMigration(3L);
        Intrinsics.checkNotNullExpressionValue(isUseUpdateBusinessMigration, "isUseUpdateBusinessMigration(3L)");
        if (isUseUpdateBusinessMigration.booleanValue()) {
            try {
                return ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 3L);
            } catch (Exception e16) {
                QLog.i("JsbCallImpl", 1, "getNewBusiness", e16);
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IJsbCallManager
    public void detailWithDarkMode(@NotNull String curThemeId, @Nullable EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(curThemeId, "curThemeId");
        DialogFragment.Companion companion = DialogFragment.INSTANCE;
        companion.b(callback);
        companion.c(curThemeId);
        BaseApplication context = BaseApplication.getContext();
        Intent intent = new Intent();
        intent.addFlags(268435456);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, DialogFragment.class);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IJsbCallManager
    public void getCardInfo(@Nullable EIPCCallback callback, boolean forceRequest) {
        IVasProfileCardApi.Companion companion = IVasProfileCardApi.INSTANCE;
        QRouteApi api = QRoute.api(IVasProfileCardApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasProfileCardApi::class.java)");
        ((IVasProfileCardApi) api).getCardInfo(callback, forceRequest);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IJsbCallManager
    public void getCurrentChatBgId(@NotNull String friendUin, @Nullable EIPCCallback callback) {
        String str;
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        String str2 = "none";
        if (Intrinsics.areEqual("none", friendUin)) {
            friendUin = null;
        }
        String chatBackgroundId = VasInjectApi.getInstance().getChatBackgroundId(friendUin);
        if (chatBackgroundId != null && !Intrinsics.areEqual(chatBackgroundId, "null") && !Intrinsics.areEqual(chatBackgroundId, "custom") && !new File(ChatBackgroundUtil.getShopBgPath(chatBackgroundId)).exists()) {
            chatBackgroundId = "none";
        }
        String userCurrentThemeId = ThemeUtil.getUserCurrentThemeId(MobileQQ.sMobileQQ.peekAppRuntime());
        if (ThemeUtil.getIsDIYTheme(userCurrentThemeId)) {
            userCurrentThemeId = "1000";
            str = "1";
        } else {
            str = "0";
        }
        if (!Intrinsics.areEqual(chatBackgroundId, "null")) {
            str2 = chatBackgroundId;
        }
        if (callback != null) {
            Bundle bundle = new Bundle();
            bundle.putString("id", str2);
            bundle.putString("themeId", userCurrentThemeId);
            bundle.putString("isDIYTheme", str);
            callback.callback(EIPCResult.createSuccessResult(bundle));
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        return this.managerName;
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IJsbCallManager
    public void requestThemeServer(@NotNull Bundle bundle, @Nullable final EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        try {
            ((IThemeRequest) QRoute.api(IThemeRequest.class)).setTheme(bundle, new Function3<String, Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.theme.JsbCallImpl$requestThemeServer$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, String str2) {
                    invoke(str, num.intValue(), str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String themeID, int i3, @NotNull String msg2) {
                    Intrinsics.checkNotNullParameter(themeID, "themeID");
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    EIPCCallback eIPCCallback = EIPCCallback.this;
                    if (eIPCCallback != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("themeId", themeID);
                        bundle2.putInt(ThemeConstants.THEME_STATUS, i3);
                        bundle2.putString("message", msg2);
                        eIPCCallback.callback(EIPCResult.createSuccessResult(bundle2));
                    }
                }
            });
        } catch (Exception e16) {
            QLog.e(getManagerName(), 1, "requestThemeServer error =" + e16);
        }
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IJsbCallManager
    public void saveFont(int id5, int type) {
        IVasTempApi.Companion companion = IVasTempApi.INSTANCE;
        QRouteApi api = QRoute.api(IVasTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasTempApi::class.java)");
        ((IVasTempApi) api).saveFont(id5, type);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IJsbCallManager
    public void setChatBackground(@NotNull String id5, @Nullable String friendUin, @NotNull String path, @NotNull String name, @NotNull String url, int feetype, int uinType, int entryType) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        IVasTempApi.Companion companion = IVasTempApi.INSTANCE;
        QRouteApi api = QRoute.api(IVasTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasTempApi::class.java)");
        ((IVasTempApi) api).setChatBackground(id5, friendUin, path, name, url, feetype, uinType, entryType);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IJsbCallManager
    public void setCustomChatBackground(@Nullable String uin, @Nullable String picPath, int effectId, int uinType) {
        IVasTempApi.Companion companion = IVasTempApi.INSTANCE;
        QRouteApi api = QRoute.api(IVasTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasTempApi::class.java)");
        ((IVasTempApi) api).setCustomChatBackground(uin, picPath, effectId, uinType);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IJsbCallManager
    public void setDiyThemeBackground(@NotNull String uin, @NotNull ThemeDIYData diyData) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(diyData, "diyData");
        ThemeDiyModule.setSpThemeBackground(BaseApplication.getContext(), uin, diyData);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IJsbCallManager
    public void setProfileCard(long layoutId, long backgroundId, long cardId, @NotNull String extInfo, @NotNull String diyTemplate, @Nullable EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        Intrinsics.checkNotNullParameter(diyTemplate, "diyTemplate");
        IVasProfileCardApi.Companion companion = IVasProfileCardApi.INSTANCE;
        QRouteApi api = QRoute.api(IVasProfileCardApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasProfileCardApi::class.java)");
        ((IVasProfileCardApi) api).setProfileCard(layoutId, backgroundId, cardId, extInfo, diyTemplate, callback);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IJsbCallManager
    public void setThemeAndBackGround(@NotNull String themeId) {
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        IVasTempApi.Companion companion = IVasTempApi.INSTANCE;
        QRouteApi api = QRoute.api(IVasTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasTempApi::class.java)");
        ((IVasTempApi) api).setThemeAndBackGround(themeId);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IJsbCallManager
    public void startDownloadTheme(@NotNull String curThemeId, @Nullable EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(curThemeId, "curThemeId");
        if (TextUtils.isEmpty(curThemeId)) {
            return;
        }
        String str = ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + curThemeId;
        QQVasUpdateBusiness<?> a16 = a();
        if (a16 == null) {
            UpdateCallbackSelector.getCallback(3L).download(3L, str, new b(callback, curThemeId), false);
            return;
        }
        if (a16.isFileExist(str)) {
            if (callback != null) {
                Bundle bundle = new Bundle();
                bundle.putString("themeId", curThemeId);
                bundle.putString("result", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                bundle.putInt("errorCode", 0);
                bundle.putInt("httpCode", 0);
                callback.callback(EIPCResult.createSuccessResult(bundle));
            }
        } else {
            a16.addDownLoadListener(str, new c(str, callback, curThemeId));
            a16.startDownload(str);
        }
        QLog.i("JsbCallImpl", 1, "startDownloadTheme start scid=" + str);
    }
}
