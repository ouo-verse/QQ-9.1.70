package com.tencent.mobileqq.groupvideo.bridgeengine;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.util.Consumer;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.api.ITroopAvatarLoaderApi;
import com.tencent.mobileqq.troop.api.ITroopQIPCModuleApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ProcessUtil;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/bridgeengine/TroopManageService;", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/ITroopManageService;", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfoList", "Lorg/json/JSONArray;", "getTroopInfo", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/ITroopManageCallback;", "callback", "", "asyncCreateAndManageTroopList", "", "troopUin", "loadTroopAvatar", "<init>", "()V", "Companion", "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class TroopManageService implements ITroopManageService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TroopListManageService";

    @NotNull
    private static final String processName = "com.tencent.mobileqq";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/bridgeengine/TroopManageService$a;", "", "", "TAG", "Ljava/lang/String;", "processName", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.groupvideo.bridgeengine.TroopManageService$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/groupvideo/bridgeengine/TroopManageService$b", "Lcom/tencent/mobileqq/troop/api/b;", "", "uin", "Landroid/graphics/Bitmap;", "head", "", "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements com.tencent.mobileqq.troop.api.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ITroopManageCallback f213718a;

        b(ITroopManageCallback iTroopManageCallback) {
            this.f213718a = iTroopManageCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iTroopManageCallback);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.b
        public void a(@NotNull String uin, @NotNull Bitmap head) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin, (Object) head);
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(head, "head");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("troopUin", uin);
            jSONObject.put("troopHead", head);
            this.f213718a.onFaceUpdate(jSONObject);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23690);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopManageService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncCreateAndManageTroopList$lambda$0(TroopManageService this$0, ITroopManageCallback iTroopManageCallback, List troopInfoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(troopInfoList, "troopInfoList");
        iTroopManageCallback.onAsyncCreateAndManageTroopList(this$0.getTroopInfo(troopInfoList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncCreateAndManageTroopList$lambda$1(TroopManageService this$0, ITroopManageCallback iTroopManageCallback, EIPCResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        Serializable serializable = result.data.getSerializable(GetCMShowInfoServlet.EXTRA_RESULT_DATA);
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.data.troop.TroopInfo>");
        iTroopManageCallback.onAsyncCreateAndManageTroopList(this$0.getTroopInfo((List) serializable));
    }

    private final JSONArray getTroopInfo(List<? extends TroopInfo> troopInfoList) {
        JSONArray jSONArray = new JSONArray();
        for (TroopInfo troopInfo : troopInfoList) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("troopUin", troopInfo.getTroopUin());
            jSONObject.put("troopName", troopInfo.getNewTroopNameOrTroopName());
            jSONObject.put("isAdmin", troopInfo.isAdmin());
            jSONObject.put("isOwner", troopInfo.isOwner());
            jSONObject.put("troopOwnerUin", troopInfo.troopowneruin);
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadTroopAvatar$lambda$2(String str, ITroopManageCallback iTroopManageCallback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ITroopAvatarLoaderApi iTroopAvatarLoaderApi = (ITroopAvatarLoaderApi) QRoute.api(ITroopAvatarLoaderApi.class);
        BaseApplication app = peekAppRuntime.getApp();
        Intrinsics.checkNotNullExpressionValue(app, "appRuntime.app");
        iTroopAvatarLoaderApi.loadAvatar(app, 4, str, new b(iTroopManageCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadTroopAvatar$lambda$3(ITroopManageCallback iTroopManageCallback, EIPCResult result) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(result, "result");
        Bundle bundle = result.data;
        String string = bundle.getString("troop_uin");
        Parcelable parcelable = bundle.getParcelable("troop_head");
        if (parcelable instanceof Bitmap) {
            bitmap = (Bitmap) parcelable;
        } else {
            bitmap = null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("troop_uin", string);
        jSONObject.put("troop_head", bitmap);
        iTroopManageCallback.onFaceUpdate(jSONObject);
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITroopManageService
    public void asyncCreateAndManageTroopList(@Nullable final ITroopManageCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
            return;
        }
        if (callback == null) {
            return;
        }
        if (TextUtils.equals(ProcessUtil.getCurrentProcessName(BaseApplication.context), "com.tencent.mobileqq")) {
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getCreatedTroopListAsync(false, new Consumer() { // from class: com.tencent.mobileqq.groupvideo.bridgeengine.b
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    TroopManageService.asyncCreateAndManageTroopList$lambda$0(TroopManageService.this, callback, (List) obj);
                }
            });
            return;
        }
        try {
            QIPCClientHelper.getInstance().callServer(ITroopQIPCModuleApi.NAME, "action_request_troop_list", new Bundle(), new EIPCResultCallback() { // from class: com.tencent.mobileqq.groupvideo.bridgeengine.c
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    TroopManageService.asyncCreateAndManageTroopList$lambda$1(TroopManageService.this, callback, eIPCResult);
                }
            });
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITroopManageService
    public void loadTroopAvatar(@Nullable final String troopUin, @Nullable final ITroopManageCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) callback);
            return;
        }
        if (troopUin != null && callback != null) {
            if (TextUtils.equals(ProcessUtil.getCurrentProcessName(BaseApplication.context), "com.tencent.mobileqq")) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.groupvideo.bridgeengine.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopManageService.loadTroopAvatar$lambda$2(troopUin, callback);
                    }
                }, 16, null, false);
                return;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putString("troop_uin", troopUin);
                QIPCClientHelper.getInstance().callServer(ITroopQIPCModuleApi.NAME, "action_request_troop_avatar", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.groupvideo.bridgeengine.e
                    @Override // eipc.EIPCResultCallback
                    public final void onCallback(EIPCResult eIPCResult) {
                        TroopManageService.loadTroopAvatar$lambda$3(ITroopManageCallback.this, eIPCResult);
                    }
                });
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
    }
}
