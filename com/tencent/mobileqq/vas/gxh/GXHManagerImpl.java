package com.tencent.mobileqq.vas.gxh;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.vas.VasIpcTempData;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.api.EIPCCallbackWrapper;
import com.tencent.mobileqq.vas.api.IVasAppIconStateManager;
import com.tencent.mobileqq.vas.api.f;
import com.tencent.mobileqq.vas.bubble.IBubbleTextColorManager;
import com.tencent.mobileqq.vas.inject.IVasInject;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.kuikly.ProxyFragment;
import com.tencent.mobileqq.vas.manager.api.IGXHManager;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.vas.quickupdate.ChatBackgroundBusiness;
import com.tencent.mobileqq.vas.report.VasJsbCommonReport;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import com.tencent.mobileqq.vip.api.h;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.vas.update.entity.UpdateListenerParams;
import cooperation.peak.PeakConstants;
import cooperation.qzone.util.QZonePermission;
import eipc.EIPCCallback;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 A2\u00020\u0001:\u0002BCB\u0007\u00a2\u0006\u0004\b?\u0010@J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J0\u0010$\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016J@\u0010+\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020,2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\n2\u0006\u0010\t\u001a\u00020/H\u0016J*\u00103\u001a\u00020\n2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00104\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00105\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010/H\u0016R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010>\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/GXHManagerImpl;", "Lcom/tencent/mobileqq/vas/manager/api/IGXHManager;", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "", "itemId", "", "bid", "Leipc/EIPCCallback;", "callback", "", GameCenterAPIJavaScript.QUERY_INFO, "business", "data", "notify", "quickSwitchDefaultMode", "iconId", "checkAppIconEnable", "getClientAppIconId", "setClientAppIconId", "type", "forceUpdateVasUserData", "jsonString", "updateTroopEnterEffectInfo", "updatePendant", ColorRingJsPlugin.Method_SetUp, "setMagicFont", "id", "setMagicFontType", "getCustomBgList", "uin", "path", "effectId", "uinType", "", "isEncode", "setCustomChatBackground", "title", "appId", "appName", WadlProxyConsts.SCENE_ID, "sourceId", "reportExt", "openRechargePanel", "Lcom/tencent/mobileqq/vas/manager/api/IGXHManager$FriendSelectParams;", "params", "openSelectFriendsPanel", "Lcom/tencent/mobileqq/vas/api/EIPCCallbackWrapper;", "openMobilePhotoSelect", "userId", "aid", "openPayItem", "getLocalToggleStatus", "setLocalToggleStatus", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport;", "d", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport;", "report", "e", "Ljava/lang/String;", "getManagerName", "()Ljava/lang/String;", "managerName", "<init>", "()V", "f", "a", "b", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class GXHManagerImpl implements IGXHManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VasJsbCommonReport report = VasJsbCommonReport.INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String managerName = "GXH";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/gxh/GXHManagerImpl$c", "Lcom/tencent/mobileqq/vas/pay/api/IVasNativePayManager$PayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPayViewClose", "onPaySuccess", "", "code", "onPayError", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements IVasNativePayManager.PayObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EIPCCallback f309432a;

        c(EIPCCallback eIPCCallback) {
            this.f309432a = eIPCCallback;
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewFail() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("result", 1);
                jSONObject.put("msg", "\u6253\u5f00\u652f\u4ed8\u9762\u677f\u5931\u8d25");
            } catch (JSONException e16) {
                jSONObject.put("msg", e16.getMessage());
                QLog.e("VasGXHApiImpl", 1, e16, new Object[0]);
            }
            f.b(this.f309432a, jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewSuccess() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("result", 0);
                jSONObject.put("msg", "\u6253\u5f00\u652f\u4ed8\u9762\u677f\u6210\u529f");
            } catch (JSONException e16) {
                jSONObject.put("msg", e16.getMessage());
                QLog.e("VasGXHApiImpl", 1, e16, new Object[0]);
            }
            f.b(this.f309432a, jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayError(int code) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "1");
                jSONObject.put("result", 1);
                jSONObject.put("msg", "\u652f\u4ed8\u5931\u8d25:code=" + code);
            } catch (JSONException e16) {
                jSONObject.put("msg", e16.getMessage());
                QLog.e("VasGXHApiImpl", 1, e16, new Object[0]);
            }
            f.b(this.f309432a, jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPaySuccess() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "1");
                jSONObject.put("result", 0);
                jSONObject.put("msg", "\u652f\u4ed8\u6210\u529f");
            } catch (JSONException e16) {
                jSONObject.put("msg", e16.getMessage());
                QLog.e("VasGXHApiImpl", 1, e16, new Object[0]);
            }
            f.b(this.f309432a, jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("result", 2);
                jSONObject.put("msg", "\u5173\u95ed\u652f\u4ed8\u9762\u677f");
            } catch (JSONException e16) {
                jSONObject.put("msg", e16.getMessage());
                QLog.e("VasGXHApiImpl", 1, e16, new Object[0]);
            }
            f.b(this.f309432a, jSONObject.toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/gxh/GXHManagerImpl$d", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadFail", "onLoadSuccess", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f309433a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GXHManagerImpl f309434b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f309435c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f309436d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQVasUpdateBusiness f309437e;

        d(long j3, GXHManagerImpl gXHManagerImpl, String str, int i3, QQVasUpdateBusiness qQVasUpdateBusiness) {
            this.f309433a = j3;
            this.f309434b = gXHManagerImpl;
            this.f309435c = str;
            this.f309436d = i3;
            this.f309437e = qQVasUpdateBusiness;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            long j3;
            Intrinsics.checkNotNullParameter(params, "params");
            long currentTimeMillis = System.currentTimeMillis() - this.f309433a;
            VasJsbCommonReport vasJsbCommonReport = this.f309434b.report;
            String str = this.f309435c;
            String valueOf = String.valueOf(this.f309436d);
            int i3 = params.mErrorCode;
            int i16 = params.mHttpCode;
            String str2 = params.mErrorMessage;
            Intrinsics.checkNotNullExpressionValue(str2, "params.mErrorMessage");
            vasJsbCommonReport.reportDownloadFail(str, valueOf, currentTimeMillis, i3, i16, str2);
            VasJsbCommonReport vasJsbCommonReport2 = this.f309434b.report;
            String str3 = this.f309435c;
            String valueOf2 = String.valueOf(this.f309436d);
            long currentTimeMillis2 = System.currentTimeMillis();
            VasJsbCommonReport.TimeRecord timeRecord = this.f309434b.report.getMSetKeyToStartTime().get(this.f309435c);
            if (timeRecord != null) {
                j3 = timeRecord.getFirstQueryTime();
            } else {
                j3 = this.f309433a;
            }
            vasJsbCommonReport2.reportSetEndDownloadFail(str3, valueOf2, currentTimeMillis2 - j3, params.mErrorCode);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            if (this.f309437e.isFileExists(this.f309436d)) {
                this.f309434b.report.reportDownloadSuccess(this.f309435c, String.valueOf(this.f309436d), System.currentTimeMillis() - this.f309433a, this.f309437e.getDownloadFileSize(this.f309436d));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/gxh/GXHManagerImpl$e", "Lhx3/c;", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onUpdateResult", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements hx3.c<NTVasSimpleInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EIPCCallback f309438a;

        e(EIPCCallback eIPCCallback) {
            this.f309438a = eIPCCallback;
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<NTVasSimpleInfo> responseData) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            jSONObject.put("msg", "");
            f.b(this.f309438a, jSONObject.toString());
        }
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void checkAppIconEnable(@NotNull String iconId, @NotNull EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(iconId, "iconId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", ((IVasAppIconStateManager) QRoute.api(IVasAppIconStateManager.class)).isSupport(Integer.parseInt(iconId)));
            jSONObject.put("msg", "");
        } catch (Exception e16) {
            jSONObject.put("msg", e16.getMessage());
            QLog.e("VasGXHApiImpl", 1, e16, new Object[0]);
        }
        f.b(callback, jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void forceUpdateVasUserData(int type) {
        VasInjectApi.getInstance().forceUpdateVasUserData(type);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void getClientAppIconId(@NotNull EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", 0);
            jSONObject.put("msg", "");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("iconId", ((IVasAppIconStateManager) QRoute.api(IVasAppIconStateManager.class)).getPrepareIconId());
            jSONObject.put("data", jSONObject2);
        } catch (Exception e16) {
            jSONObject.put("msg", e16.getMessage());
            QLog.e("VasGXHApiImpl", 1, e16, new Object[0]);
        }
        f.b(callback, jSONObject.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x01ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016e A[SYNTHETIC] */
    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getCustomBgList(@NotNull EIPCCallback callback) {
        String str;
        boolean z16;
        String str2;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean startsWith$default;
        boolean z26;
        Intrinsics.checkNotNullParameter(callback, "callback");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null) {
            return;
        }
        AppRuntime peekAppRuntime = mobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(mobileQQ, str);
        Pattern compile = Pattern.compile("[0-9]+");
        ArrayList arrayList = new ArrayList();
        Map<String, ?> all = mMKVData.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "pref.all");
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (compile.matcher(entry.getKey()).matches()) {
                String key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "it.key");
                arrayList.add(new BgInfo(key, null, 0, 0, false, null, 62, null));
            }
            VasLogReportProxy chatBackground = VasLogReporter.INSTANCE.getChatBackground();
            String key2 = entry.getKey();
            chatBackground.reportDebug(((Object) key2) + "  " + entry.getValue());
        }
        Iterator it = arrayList.iterator();
        while (true) {
            String str3 = "";
            boolean z27 = true;
            if (!it.hasNext()) {
                break;
            }
            BgInfo bgInfo = (BgInfo) it.next();
            String uin = bgInfo.getUin();
            String string = mMKVData.getString(uin, "");
            if (string != null && string.length() != 0) {
                z27 = false;
            }
            if (!z27 && !Intrinsics.areEqual(string, "null")) {
                str3 = string;
            }
            bgInfo.h(str3);
            bgInfo.j(mMKVData.getInt(uin + ChatBackgroundUtil.UIN_TYPE, 0));
            bgInfo.g(mMKVData.getInt(uin + AppConstants.Preferences.CHAT_BG_EFFECT, 0));
            bgInfo.f(mMKVData.getBoolean(uin + ChatBackgroundUtil.IS_C2C_SET, false));
        }
        String string2 = mMKVData.getString(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH, "");
        if (string2 != null && string2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !Intrinsics.areEqual(string2, "null")) {
            arrayList.add(new BgInfo("", null, 0, mMKVData.getInt(AppConstants.Preferences.CHAT_BG_EFFECT, 0), false, string2, 22, null));
        }
        String shopBackgroundPath = ((ChatBackgroundBusiness) QQVasUpdateBusiness.getBusiness(ChatBackgroundBusiness.class)).getSavePath("");
        ArrayList<BgInfo> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            BgInfo bgInfo2 = (BgInfo) obj;
            String imagePath = bgInfo2.getImagePath();
            if (imagePath.length() == 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (!z19) {
                if (!new File(imagePath).exists()) {
                    VasLogReporter.INSTANCE.getChatBackground().reportLow(imagePath + " not exists");
                } else {
                    Intrinsics.checkNotNullExpressionValue(shopBackgroundPath, "shopBackgroundPath");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(imagePath, shopBackgroundPath, false, 2, null);
                    if (startsWith$default) {
                        VasLogReporter.INSTANCE.getChatBackground().reportLow(imagePath + " is shop background");
                    } else {
                        String encode = URLEncoder.encode(imagePath, "utf-8");
                        Intrinsics.checkNotNullExpressionValue(encode, "encode(imagePath, \"utf-8\")");
                        bgInfo2.h(encode);
                        z26 = true;
                        if (!z26) {
                            arrayList2.add(obj);
                        }
                    }
                }
            }
            z26 = false;
            if (!z26) {
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (BgInfo bgInfo3 : arrayList2) {
            if (bgInfo3.getUinType() == 0) {
                String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(bgInfo3.getUin());
                IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                String remarkWithUid = iFriendsInfoService.getRemarkWithUid(uid, "VasKuiklyModule");
                if (TextUtils.isEmpty(remarkWithUid)) {
                    remarkWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(uid, "VasKuiklyModule");
                }
                if (remarkWithUid != null && remarkWithUid.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    bgInfo3.i(remarkWithUid);
                }
            } else {
                TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(bgInfo3.getUin());
                if (troopInfoFromCache != null) {
                    str2 = troopInfoFromCache.getTroopDisplayName();
                } else {
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    bgInfo3.i(str2);
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uin", bgInfo3.getUin());
            jSONObject.put("nick", bgInfo3.getNick());
            jSONObject.put("type", bgInfo3.getUinType());
            jSONObject.put("effectId", bgInfo3.getEffectId());
            jSONObject.put("imageName", bgInfo3.getImagePath());
            jSONArray.mo162put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("result", jSONArray);
        f.b(callback, jSONObject2.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getLocalToggleStatus(@NotNull String jsonString, @Nullable EIPCCallbackWrapper callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        JSONObject jSONObject = new JSONObject(jsonString);
        JSONObject jSONObject2 = new JSONObject();
        String optString = jSONObject.optString("key");
        jSONObject2.put("key", optString);
        if (optString != null) {
            int hashCode = optString.hashCode();
            if (hashCode != -559164346) {
                if (hashCode != -191225026) {
                    if (hashCode == 1569434331 && optString.equals("show_color_nick_for_normal")) {
                        jSONObject2.put("status", VasInjectApi.getInstance().isShowColorName() ? 1 : 0);
                    }
                } else if (optString.equals("show_nameplate_for_simple")) {
                    jSONObject2.put("status", VasInjectApi.getInstance().isShowVipIconForSimpleMode() ? 1 : 0);
                }
            } else if (optString.equals("show_nameplate_for_troop")) {
                jSONObject2.put("status", VasInjectApi.getInstance().isShowTroopVipIcon() ? 1 : 0);
            }
            if (callback == null) {
                callback.callWithData(jSONObject2.toString());
                return;
            }
            return;
        }
        Unit unit = Unit.INSTANCE;
        if (callback == null) {
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        return this.managerName;
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void notify(@NotNull String setKey, @NotNull String business, @NotNull String data, @NotNull final EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BusinessStrategyFactory.INSTANCE.a(business, new com.tencent.mobileqq.vas.gxh.d()).a(new JSONObject(data), setKey, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.vas.gxh.GXHManagerImpl$notify$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                f.b(EIPCCallback.this, it);
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void openMobilePhotoSelect(@NotNull final EIPCCallbackWrapper callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        final int i3 = 10086;
        final Function1<Activity, Unit> function1 = new Function1<Activity, Unit>() { // from class: com.tencent.mobileqq.vas.gxh.GXHManagerImpl$openMobilePhotoSelect$gotoSelectMobilePhoto$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Activity activity) {
                invoke2(activity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                QLog.i("VasKuiklyModule", 1, "\u6253\u5f00\u9009\u56fe\u5668");
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
                Bundle bundle = new Bundle();
                bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
                bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", activity.getPackageName());
                bundle.putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
                bundle.putBoolean(PeakConstants.IS_START_ACTIVITY_FOR_RESULT, true);
                bundle.putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
                bundle.putBoolean("PhotoConst.IS_SINGLE_MODE", true);
                bundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
                bundle.putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 6);
                activityURIRequest.extra().putAll(bundle);
                activityURIRequest.setRequestCode(i3);
                QRoute.startUri(activityURIRequest);
                QAlbumUtil.anim(activity, false, true);
            }
        };
        ProxyFragment.Companion companion = ProxyFragment.INSTANCE;
        companion.b(false);
        companion.a(new Function1<FragmentActivity, Unit>() { // from class: com.tencent.mobileqq.vas.gxh.GXHManagerImpl$openMobilePhotoSelect$1

            @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J(\u0010\n\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/gxh/GXHManagerImpl$openMobilePhotoSelect$1$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "onDeniedWithoutShowDlg", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes20.dex */
            public static final class a extends QQPermission.BasePermissionsListener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Function1<Activity, Unit> f309439a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ FragmentActivity f309440b;

                /* JADX WARN: Multi-variable type inference failed */
                a(Function1<? super Activity, Unit> function1, FragmentActivity fragmentActivity) {
                    this.f309439a = function1;
                    this.f309440b = fragmentActivity;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void b() {
                    ProxyFragment.INSTANCE.b(true);
                }

                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onAllGranted() {
                    super.onAllGranted();
                    this.f309439a.invoke(this.f309440b);
                    y13.d.a(500L, 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE 
                          (500 long)
                          (wrap:java.lang.Runnable:0x000c: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:13) call: com.tencent.mobileqq.vas.gxh.c.<init>():void type: CONSTRUCTOR)
                         STATIC call: y13.d.a(long, java.lang.Runnable):void A[MD:(long, java.lang.Runnable):void (m)] (LINE:18) in method: com.tencent.mobileqq.vas.gxh.GXHManagerImpl$openMobilePhotoSelect$1.a.onAllGranted():void, file: classes20.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.vas.gxh.c, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        super.onAllGranted()
                        kotlin.jvm.functions.Function1<android.app.Activity, kotlin.Unit> r0 = r3.f309439a
                        androidx.fragment.app.FragmentActivity r1 = r3.f309440b
                        r0.invoke(r1)
                        com.tencent.mobileqq.vas.gxh.c r0 = new com.tencent.mobileqq.vas.gxh.c
                        r0.<init>()
                        r1 = 500(0x1f4, double:2.47E-321)
                        y13.d.a(r1, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.vas.gxh.GXHManagerImpl$openMobilePhotoSelect$1.a.onAllGranted():void");
                }

                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
                    super.onDenied(permissions, results);
                    QLog.e("VasKuiklyModule", 1, "\u65e0\u6cd5\u83b7\u53d6\u9009\u56fe\u5668\u6743\u9650 onDenied");
                    ProxyFragment.Companion companion = ProxyFragment.INSTANCE;
                    companion.b(true);
                    companion.d(0);
                }

                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onDeniedWithoutShowDlg(@Nullable List<String> permissions, @Nullable List<Integer> results) {
                    super.onDeniedWithoutShowDlg(permissions, results);
                    QLog.e("VasKuiklyModule", 1, "\u65e0\u6cd5\u83b7\u53d6\u9009\u56fe\u5668\u6743\u9650 onDeniedWithoutShowDlg");
                    this.f309440b.finish();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
                invoke2(fragmentActivity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FragmentActivity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!QZonePermission.requestStoragePermission(activity, new a(function1, activity), QQPermissionConstants.Business.SCENE.QQ_QZONE_JS_SELECT_PHOTO)) {
                    QLog.e("VasKuiklyModule", 1, "\u65e0\u9009\u56fe\u5668\u6743\u9650");
                } else {
                    function1.invoke(activity);
                    ProxyFragment.INSTANCE.b(true);
                }
            }
        });
        companion.c(new Function4<FragmentActivity, Integer, Integer, Intent, Unit>() { // from class: com.tencent.mobileqq.vas.gxh.GXHManagerImpl$openMobilePhotoSelect$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity, Integer num, Integer num2, Intent intent) {
                invoke(fragmentActivity, num.intValue(), num2.intValue(), intent);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull FragmentActivity fragmentActivity, int i16, int i17, @Nullable Intent intent) {
                String str;
                String str2;
                Intrinsics.checkNotNullParameter(fragmentActivity, "<anonymous parameter 0>");
                String str3 = "";
                if (i16 != i3 || i17 != -1 || intent == null || (str = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH")) == null) {
                    str = "";
                }
                if (str.length() > 0) {
                    VasIpcTempData.INSTANCE.getKuikly().setBool(str, true);
                    byte[] bytes = str.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    str3 = Base64.encodeToString(bytes, 2);
                    Intrinsics.checkNotNullExpressionValue(str3, "encodeToString(originPat\u2026eArray(), Base64.NO_WRAP)");
                    str2 = URLEncoder.encode(str, "utf-8");
                    Intrinsics.checkNotNullExpressionValue(str2, "encode(originPath, \"utf-8\")");
                } else {
                    str2 = "";
                }
                EIPCCallbackWrapper eIPCCallbackWrapper = callback;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(IECDtReport.ACTION_IDENTIFIER, str3);
                jSONObject.put("pathEncode", str2);
                eIPCCallbackWrapper.callWithData(jSONObject.toString());
                QLog.i("VasKuiklyModule", 1, "requestCode=" + i16 + " resultCode=" + i17 + " base64path=" + ((Object) str3) + " pathEncode=" + ((Object) str2));
            }
        });
        BaseApplication context = BaseApplication.getContext();
        Intent intent = new Intent();
        intent.addFlags(268435456);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ProxyFragment.class);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void openPayItem(@NotNull final String userId, @NotNull final String aid, @NotNull final String itemId, @Nullable final EIPCCallbackWrapper callback) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        ProxyFragment.Companion companion = ProxyFragment.INSTANCE;
        companion.b(true);
        companion.a(new Function1<FragmentActivity, Unit>() { // from class: com.tencent.mobileqq.vas.gxh.GXHManagerImpl$openPayItem$1

            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/gxh/GXHManagerImpl$openPayItem$1$a", "Lcom/tencent/mobileqq/vip/api/h;", "", "vipMa", "billno", "payStr", "", "b", "", "code", "a", "msg", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes20.dex */
            public static final class a implements h {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ EIPCCallbackWrapper f309441a;

                a(EIPCCallbackWrapper eIPCCallbackWrapper) {
                    this.f309441a = eIPCCallbackWrapper;
                }

                @Override // com.tencent.mobileqq.vip.api.k
                public void a(int code) {
                    EIPCCallbackWrapper eIPCCallbackWrapper = this.f309441a;
                    if (eIPCCallbackWrapper != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("status", true);
                        jSONObject.put("code", code);
                        jSONObject.put("msg", "success");
                        eIPCCallbackWrapper.callWithData(jSONObject.toString());
                    }
                }

                @Override // com.tencent.mobileqq.vip.api.h
                public void b(@NotNull String vipMa, @NotNull String billno, @NotNull String payStr) {
                    Intrinsics.checkNotNullParameter(vipMa, "vipMa");
                    Intrinsics.checkNotNullParameter(billno, "billno");
                    Intrinsics.checkNotNullParameter(payStr, "payStr");
                }

                @Override // com.tencent.mobileqq.vip.api.k
                public void c(int code, @NotNull String msg2) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    EIPCCallbackWrapper eIPCCallbackWrapper = this.f309441a;
                    if (eIPCCallbackWrapper != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("status", false);
                        jSONObject.put("code", code);
                        jSONObject.put("msg", msg2);
                        eIPCCallbackWrapper.callWithData(jSONObject.toString());
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
                invoke2(fragmentActivity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FragmentActivity it) {
                Intrinsics.checkNotNullParameter(it, "it");
                new e23.c(it).b(userId, aid, itemId, new a(callback));
            }
        });
        BaseApplication context = BaseApplication.getContext();
        Intent intent = new Intent();
        intent.addFlags(268435456);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ProxyFragment.class);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void openRechargePanel(@NotNull String title, int appId, @NotNull String appName, @NotNull String sceneId, @NotNull String sourceId, @NotNull String reportExt, @NotNull EIPCCallback callback) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        Intrinsics.checkNotNullParameter(reportExt, "reportExt");
        Intrinsics.checkNotNullParameter(callback, "callback");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(appId);
        IVasNativePayManager.ReportData reportData = new IVasNativePayManager.ReportData(sb5.toString(), "0", "0", "0_0_0_0");
        boolean z18 = false;
        if (sceneId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            reportData.mSubBusinessId = sceneId;
        }
        if (sourceId.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            reportData.mSource = sourceId;
        }
        if (reportExt.length() == 0) {
            z18 = true;
        }
        if (!z18) {
            reportData.mExt = reportExt;
        }
        QLog.i("VasGXHApiImpl", 1, "openRechargePanel : " + reportData);
        ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).initAndShowPayPanel(QBaseActivity.sTopActivity, title, appName, reportData, new c(callback));
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void openSelectFriendsPanel(@NotNull final IGXHManager.FriendSelectParams params, @NotNull final EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ProxyFragment.Companion companion = ProxyFragment.INSTANCE;
        companion.a(new Function1<FragmentActivity, Unit>() { // from class: com.tencent.mobileqq.vas.gxh.GXHManagerImpl$openSelectFriendsPanel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
                invoke2(fragmentActivity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FragmentActivity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                VasInjectApi.getInstance().startForwardFriendListActivity(activity, IGXHManager.FriendSelectParams.this);
            }
        });
        companion.c(new Function4<FragmentActivity, Integer, Integer, Intent, Unit>() { // from class: com.tencent.mobileqq.vas.gxh.GXHManagerImpl$openSelectFriendsPanel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity, Integer num, Integer num2, Intent intent) {
                invoke(fragmentActivity, num.intValue(), num2.intValue(), intent);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull FragmentActivity fragmentActivity, int i3, int i16, @Nullable Intent intent) {
                ArrayList<ResultRecord> parcelableArrayListExtra;
                Intrinsics.checkNotNullParameter(fragmentActivity, "<anonymous parameter 0>");
                JSONArray jSONArray = new JSONArray();
                if (i16 != 0 && intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra("selected_target_list")) != null) {
                    for (ResultRecord resultRecord : parcelableArrayListExtra) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("uin", resultRecord.uin);
                        int i17 = resultRecord.uinType;
                        if (i17 == 0) {
                            i17 = 1;
                        } else if (i17 == 1) {
                            i17 = 4;
                        }
                        jSONObject.put("type", i17);
                        jSONObject.put("uinType", resultRecord.uinType);
                        jSONObject.put("name", resultRecord.name);
                        jSONArray.mo162put(jSONObject);
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("friends", jSONArray);
                String jSONObject3 = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().apply { put\u2026ends\", json) }.toString()");
                if (QLog.isColorLevel()) {
                    QLog.e("VasGXHApiImpl", 1, "callback: " + jSONObject3);
                }
                f.b(EIPCCallback.this, jSONObject3);
            }
        });
        BaseApplication context = BaseApplication.getContext();
        Intent intent = new Intent();
        intent.addFlags(268435456);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ProxyFragment.class);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void queryInfo(@NotNull String setKey, int itemId, long bid, @NotNull EIPCCallback callback) {
        boolean z16;
        boolean z17;
        d dVar;
        String errorMessage;
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i3 = 1;
        int i16 = 0;
        if (setKey.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("VasGXHApiImpl", 1, "setKey is null");
        }
        QQVasUpdateBusiness business = QQVasUpdateBusiness.getBusiness(bid);
        if (!TextUtils.isEmpty(setKey) && !this.report.getMSetKeyToStartTime().containsKey(setKey)) {
            VasJsbCommonReport.TimeRecord timeRecord = new VasJsbCommonReport.TimeRecord(setKey, System.currentTimeMillis(), String.valueOf(itemId), business.getBid());
            this.report.getMSetKeyToStartTime().put(setKey, timeRecord);
            this.report.reportFirstQuery(timeRecord);
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            dVar = new d(System.currentTimeMillis(), this, setKey, itemId, business);
        } else {
            dVar = null;
        }
        int a16 = com.tencent.mobileqq.webview.js.a.a(itemId, business, dVar);
        Intrinsics.checkNotNullExpressionValue(business, "business");
        VasJsbCommonReport.reportPreDownload(setKey, business, itemId, a16, z17, "kuikly");
        if (dVar != null && a16 == 2) {
            this.report.setStartDownload(setKey);
        }
        JSONObject jSONObject = new JSONObject();
        String str = "";
        if (a16 != 2) {
            if (a16 == 3) {
                jSONObject.put("result", 0);
                jSONObject.put("message", "");
                jSONObject.put("status", a16);
            }
        } else {
            VasJsbCommonReport.TimeRecord timeRecord2 = this.report.getMSetKeyToStartTime().get(setKey);
            if (timeRecord2 != null) {
                i16 = timeRecord2.getErrorCode();
            }
            jSONObject.put("result", i16);
            VasJsbCommonReport.TimeRecord timeRecord3 = this.report.getMSetKeyToStartTime().get(setKey);
            if (timeRecord3 != null && (errorMessage = timeRecord3.getErrorMessage()) != null) {
                str = errorMessage;
            }
            jSONObject.put("message", str);
            if (i16 == 0) {
                i3 = a16;
            }
            jSONObject.put("status", i3);
        }
        f.b(callback, jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void quickSwitchDefaultMode(@NotNull final EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        VasInjectApi.getInstance().quickSwitchDefaultMode(new Function1<JSONObject, Unit>() { // from class: com.tencent.mobileqq.vas.gxh.GXHManagerImpl$quickSwitchDefaultMode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                invoke2(jSONObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject) {
                f.b(EIPCCallback.this, jSONObject.toString());
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void setClientAppIconId(@NotNull String iconId, @NotNull EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(iconId, "iconId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject jSONObject = new JSONObject();
        VasLogReporter.INSTANCE.getAppIcon().reportHighest("call setClientAppIconId " + iconId);
        try {
            ((IVasAppIconStateManager) QRoute.api(IVasAppIconStateManager.class)).setUseAppIcon(true);
            VasUtil.getService().getAppIconSwitchManager().changeIconForJsb(MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), Integer.parseInt(iconId));
            jSONObject.put("result", 0);
            jSONObject.put("msg", "");
        } catch (Exception e16) {
            jSONObject.put("msg", e16.getMessage());
            QLog.e("VasGXHApiImpl", 1, e16, new Object[0]);
        }
        f.b(callback, jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void setCustomChatBackground(@NotNull String uin, @NotNull String path, int effectId, int uinType, boolean isEncode) {
        String str;
        String path2 = path;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(path2, "path");
        if (isEncode) {
            path2 = URLDecoder.decode(path2, "utf-8");
        }
        String str2 = path2;
        VasLogReporter.INSTANCE.getChatBackground().reportHighest("setCustomChatBackground " + uin + "-" + uinType + " " + str2 + " " + effectId);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null) {
            return;
        }
        AppRuntime peekAppRuntime = mobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        ThemeBackground.setThemeBackgroundPic(mobileQQ, AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, str, str2, "", "", "", 0, null, false);
        ChatBackgroundUtil.setChatBackground(mobileQQ, str, uin, str2, effectId, uinType);
        ((IBubbleTextColorManager) QRoute.api(IBubbleTextColorManager.class)).saveNativeAllChatBgMainPixel(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setLocalToggleStatus(@NotNull String jsonString, @Nullable EIPCCallbackWrapper callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        JSONObject jSONObject = new JSONObject(jsonString);
        JSONObject jSONObject2 = new JSONObject();
        String optString = jSONObject.optString("key");
        jSONObject2.put("key", optString);
        int optInt = jSONObject.optInt("status");
        if (optString != null) {
            int hashCode = optString.hashCode();
            boolean z16 = false;
            if (hashCode != -559164346) {
                if (hashCode != -191225026) {
                    if (hashCode == 1569434331 && optString.equals("show_color_nick_for_normal")) {
                        IVasInject vasInjectApi = VasInjectApi.getInstance();
                        if (optInt == 1) {
                            z16 = true;
                        }
                        vasInjectApi.setShowColorName(z16);
                        jSONObject2.put("status", VasInjectApi.getInstance().isShowColorName() ? 1 : 0);
                    }
                } else if (optString.equals("show_nameplate_for_simple")) {
                    IVasInject vasInjectApi2 = VasInjectApi.getInstance();
                    if (optInt == 1) {
                        z16 = true;
                    }
                    vasInjectApi2.setShowVipIconForSimpleMode(z16);
                    jSONObject2.put("status", VasInjectApi.getInstance().isShowVipIconForSimpleMode() ? 1 : 0);
                }
            } else if (optString.equals("show_nameplate_for_troop")) {
                IVasInject vasInjectApi3 = VasInjectApi.getInstance();
                BaseApplication context = BaseApplication.getContext();
                if (optInt == 1) {
                    z16 = true;
                }
                vasInjectApi3.setShowTroopVipIcon(context, z16);
                jSONObject2.put("status", VasInjectApi.getInstance().isShowTroopVipIcon() ? 1 : 0);
            }
            if (callback == null) {
                callback.callWithData(jSONObject2.toString());
                return;
            }
            return;
        }
        Unit unit = Unit.INSTANCE;
        if (callback == null) {
        }
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void setMagicFont(@NotNull String setup, @NotNull EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(setup, "setup");
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject jSONObject = new JSONObject();
        try {
            int parseInt = Integer.parseInt(setup);
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
            Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            Object businessHandler = ((AppInterface) waitAppRuntime).getBusinessHandler(((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.vas.svip.api.ISVIPHandler");
            ((ISVIPHandler) businessHandler).setMagicFont(parseInt);
            jSONObject.put("result", 0);
        } catch (Exception e16) {
            jSONObject.put("msg", e16.getMessage());
            QLog.e("VasGXHApiImpl", 1, e16, new Object[0]);
        }
        f.b(callback, jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void setMagicFontType(@NotNull String id5, @NotNull EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject jSONObject = new JSONObject();
        try {
            int parseInt = Integer.parseInt(id5);
            if (parseInt != 0 && parseInt != 2000) {
                jSONObject.put("result", 1);
                jSONObject.put("msg", "error id : " + parseInt);
            } else {
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
                Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                Object businessHandler = ((AppInterface) waitAppRuntime).getBusinessHandler(((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.vas.svip.api.ISVIPHandler");
                ((ISVIPHandler) businessHandler).setFontEffect(parseInt);
                jSONObject.put("result", 0);
            }
        } catch (Exception e16) {
            jSONObject.put("msg", e16.getMessage());
            QLog.e("VasGXHApiImpl", 1, e16, new Object[0]);
        }
        f.b(callback, jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void updatePendant(@NotNull String jsonString, @NotNull EIPCCallback callback) {
        long optLong;
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject jSONObject = new JSONObject(jsonString);
        String uin = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        if (jSONObject.has("itemId")) {
            optLong = jSONObject.optLong("itemId");
        } else {
            optLong = jSONObject.optLong("pendantId");
        }
        boolean optBoolean = jSONObject.optBoolean("is_diypendant");
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026.java).getUidFromUin(uin)");
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, uin);
        nTVasSimpleInfo.c();
        if (!optBoolean) {
            nTVasSimpleInfo.pendantDiyId = 0;
        }
        nTVasSimpleInfo.pendantId = optLong;
        nTVasSimpleInfo.timestamp = System.currentTimeMillis();
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "VasGXHApiImpl", new e(callback));
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IGXHManager
    public void updateTroopEnterEffectInfo(@NotNull String jsonString, @NotNull EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject jSONObject = new JSONObject(jsonString);
        JSONArray optJSONArray = jSONObject.optJSONArray("groupCodeList");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
        }
        int optInt = jSONObject.optInt("effectId");
        int optInt2 = jSONObject.optInt("svipLevel");
        int optInt3 = jSONObject.optInt("svipType");
        String optString = jSONObject.optString("effectName");
        Intrinsics.checkNotNullExpressionValue(optString, "params.optString(\"effectName\")");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopEnterEffectService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ava, ProcessConstant.ALL)");
        ITroopEnterEffectService iTroopEnterEffectService = (ITroopEnterEffectService) runtimeService;
        if (arrayList.size() == 0) {
            iTroopEnterEffectService.updateGlobalEffectInfo(optInt, optString, optInt2, optInt3);
        } else {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String groupCode = (String) it.next();
                Intrinsics.checkNotNullExpressionValue(groupCode, "groupCode");
                iTroopEnterEffectService.updateEffectInfo(Long.parseLong(groupCode), optInt, optString, optInt2, optInt3);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("result", 0);
        jSONObject2.put("msg", "");
        f.b(callback, jSONObject2.toString());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\t\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b!\u0010\u000e\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/GXHManagerImpl$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "uin", "b", "c", "i", "nick", "I", "e", "()I", "j", "(I)V", "uinType", "g", "effectId", "Z", "isC2CSet", "()Z", "f", "(Z)V", tl.h.F, "imagePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIZLjava/lang/String;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.gxh.GXHManagerImpl$a, reason: from toString */
    /* loaded from: classes20.dex */
    private static final /* data */ class BgInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String nick;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int uinType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int effectId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isC2CSet;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String imagePath;

        public BgInfo(@NotNull String uin, @NotNull String nick, int i3, int i16, boolean z16, @NotNull String imagePath) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(nick, "nick");
            Intrinsics.checkNotNullParameter(imagePath, "imagePath");
            this.uin = uin;
            this.nick = nick;
            this.uinType = i3;
            this.effectId = i16;
            this.isC2CSet = z16;
            this.imagePath = imagePath;
        }

        /* renamed from: a, reason: from getter */
        public final int getEffectId() {
            return this.effectId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getImagePath() {
            return this.imagePath;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getNick() {
            return this.nick;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        /* renamed from: e, reason: from getter */
        public final int getUinType() {
            return this.uinType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BgInfo)) {
                return false;
            }
            BgInfo bgInfo = (BgInfo) other;
            if (Intrinsics.areEqual(this.uin, bgInfo.uin) && Intrinsics.areEqual(this.nick, bgInfo.nick) && this.uinType == bgInfo.uinType && this.effectId == bgInfo.effectId && this.isC2CSet == bgInfo.isC2CSet && Intrinsics.areEqual(this.imagePath, bgInfo.imagePath)) {
                return true;
            }
            return false;
        }

        public final void f(boolean z16) {
            this.isC2CSet = z16;
        }

        public final void g(int i3) {
            this.effectId = i3;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imagePath = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((this.uin.hashCode() * 31) + this.nick.hashCode()) * 31) + this.uinType) * 31) + this.effectId) * 31;
            boolean z16 = this.isC2CSet;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + this.imagePath.hashCode();
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.nick = str;
        }

        public final void j(int i3) {
            this.uinType = i3;
        }

        @NotNull
        public String toString() {
            return "BgInfo(uin=" + this.uin + ", nick=" + this.nick + ", uinType=" + this.uinType + ", effectId=" + this.effectId + ", isC2CSet=" + this.isC2CSet + ", imagePath=" + this.imagePath + ")";
        }

        public /* synthetic */ BgInfo(String str, String str2, int i3, int i16, boolean z16, String str3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16, (i17 & 16) == 0 ? z16 : false, (i17 & 32) == 0 ? str3 : "");
        }
    }
}
