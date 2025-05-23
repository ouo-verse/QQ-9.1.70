package com.tencent.mobileqq.wxmini.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.wechat.mini.IGdtWXMINIProgramAPI;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate;
import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import com.tencent.luggage.wxaapi.m;
import com.tencent.luggage.wxaapi.q;
import com.tencent.luggage.wxaapi.r;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.minigame.api.report.IMiniGameReport;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.g;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.api.data.d;
import com.tencent.mobileqq.wxmini.impl.WxaSDKInit;
import com.tencent.mobileqq.wxmini.impl.ui.ShareFragment;
import com.tencent.mobileqq.wxmini.impl.util.i;
import com.tencent.mobileqq.wxmini.ui.QPublicTransFragmentActivityForNoRecent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.core.AssetExtension;
import com.tencent.util.AbiUtil;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qqfav.QfavBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 52\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002JL\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J \u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00192\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002JD\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0002J2\u0010 \u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0002J \u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0011H\u0002J@\u0010'\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fH\u0002J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0002J\u0018\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\tH\u0002R\u0014\u00102\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/WxaSDKInit;", "", "Lcom/tencent/luggage/wxaapi/WxaApi;", "v", "wxaApi", "", "J", "L", "I", "", "appId", "Lorg/json/JSONObject;", "args", "Lcom/tencent/luggage/wxaapi/WxaAppCustomActionSheetDelegate$a;", "actionHandleCallback", "", "hostExtraData", "", "shareSource", BdhLogUtil.LogTag.Tag_Conn, "ret", "P", "bizData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "G", "filePath", "Lcom/tencent/mobileqq/mini/api/IMiniCallback;", "callback", BdhLogUtil.LogTag.Tag_Req, "o", "y", "event", "hostScene", "M", "", "isSucceed", "ext", "N", "Ljava/lang/Runnable;", "task", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "imagePath", HippyTKDListViewAdapter.X, "Landroid/graphics/Bitmap;", "source", "w", "a", "Z", "useEmptyAndroidId", "<init>", "()V", "b", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WxaSDKInit {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f327636c;

    /* renamed from: d, reason: collision with root package name */
    private static final List<String> f327637d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean useEmptyAndroidId = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("loadEmptyAndroidID", true);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0005R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0005R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0005R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0005\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/WxaSDKInit$a;", "", "", "a", "EV_ADD_MY_APP_CLICK", "Ljava/lang/String;", "EV_ADD_MY_APP_RESULT", "EV_COLLECT_CLICK", "EV_COLLECT_RESULT", "", "ITEM_ADD_TO_FAVORITE", "I", "ITEM_ADD_TO_MINE", "ITEM_SHARE_WITH_FRIENDS", "PARAM_IS_SUCCEED", "PRIVACY_LISTEN_HOOK_METHOD", "", "PRIVACY_LIST_HOCK_METHODS", "Ljava/util/List;", "PRIVACY_METHODS", "PROCESS_MAX_COUNT", "TAG", "WX_APPID_DEBUG", "WX_APPID_RELEASE", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wxmini.impl.WxaSDKInit$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String a() {
            return "wxf14070172bb44e41";
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wxmini/impl/WxaSDKInit$b", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            kb3.a.f411988a.h(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            kb3.a.f411988a.i(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            kb3.a.f411988a.j(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            kb3.a.f411988a.k(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    static {
        List<String> listOf;
        List<String> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"getMeid", "getImei", "getDeviceId"});
        f327636c = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"getInstalledPackages", "getInstalledApplications", "getConfiguredNetworks"});
        f327637d = listOf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(final String appId, final WxaSDKInit this$0, final int i3, final WxaAppCustomActionSheetDelegate.a aVar) {
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final int miniAppTopTypeByAppId = ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppTopTypeByAppId(appId);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).updateTopTypeByAppId(appId, 1 - miniAppTopTypeByAppId, new IMiniCallback() { // from class: fb3.o
            @Override // com.tencent.mobileqq.mini.api.IMiniCallback
            public final void onCallbackResult(boolean z16, Bundle bundle) {
                WxaSDKInit.B(WxaSDKInit.this, appId, i3, miniAppTopTypeByAppId, aVar, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(WxaSDKInit this$0, String appId, int i3, int i16, WxaAppCustomActionSheetDelegate.a aVar, boolean z16, Bundle bundle) {
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("operation_type", String.valueOf(i16 + 1)));
        this$0.N("ev_applet_add_my_app_result", appId, i3, z16, mapOf);
        if (aVar != null) {
            if (z16) {
                aVar.onSuccess();
            } else {
                aVar.onFail(bundle.getString("ErrorMsg", "reason unknown"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(String str, Intent intent, String appId, String str2, String str3, String str4, int i3, int i16, final WxaAppCustomActionSheetDelegate.a aVar, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        String string = bundle != null ? bundle.getString("imageUrl", "") : "";
        if (TextUtils.isEmpty(string)) {
            string = str;
        }
        intent.putExtra("app_id", appId);
        intent.putExtra("icon", str);
        intent.putExtra("title", str2);
        intent.putExtra(AssetExtension.SCENE_THUMBNAIL, string);
        intent.putExtra("path", str3);
        intent.putExtra("desc", str4);
        intent.putExtra("host_scene", i3);
        intent.putExtra("share_source", i16);
        intent.putExtra("public_fragment_window_feature", 1);
        final Handler handler = new Handler(Looper.getMainLooper());
        intent.putExtra("share_result", new ResultReceiver(handler) { // from class: com.tencent.mobileqq.wxmini.impl.WxaSDKInit$doShare$1$1$callback$1$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                if (resultCode == 0) {
                    WxaAppCustomActionSheetDelegate.a aVar2 = WxaAppCustomActionSheetDelegate.a.this;
                    if (aVar2 != null) {
                        aVar2.onSuccess();
                        return;
                    }
                    return;
                }
                WxaAppCustomActionSheetDelegate.a aVar3 = WxaAppCustomActionSheetDelegate.a.this;
                if (aVar3 != null) {
                    aVar3.onFail("share failed");
                }
            }
        });
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            intent.addFlags(402653184);
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivityForNoRecent.class, ShareFragment.class);
        }
    }

    private final ArrayList<byte[]> G(JSONObject bizData) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appName", bizData.optString("appName"));
            jSONObject.put(QQCustomArkDialogUtil.APP_VIEW, bizData.optString(QQCustomArkDialogUtil.APP_VIEW));
            jSONObject.put(QQCustomArkDialogUtil.META_DATA, bizData.optJSONObject(QQCustomArkDialogUtil.META_DATA));
            jSONObject.put(QQCustomArkDialogUtil.APP_MIN_VERSION, bizData.optString("ver"));
            jSONObject.put("appConfig", bizData.optJSONObject(DownloadInfo.spKey_Config));
            jSONObject.put(QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT, bizData.optString("prompt"));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("arkAppInfo", jSONObject);
            String jSONObject3 = jSONObject2.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "favJson.toString()");
            byte[] bytes = jSONObject3.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            arrayList.add(bytes);
        } catch (JSONException e16) {
            QLog.e("[wxa-q]WxaSDKInit", 1, "addToFavorite failed, parse json failed!", e16);
        }
        return arrayList;
    }

    @JvmStatic
    public static final String H() {
        return INSTANCE.a();
    }

    private final void I(WxaApi wxaApi) {
        wxaApi.setWxaAppActionSheetDelegate(new c(wxaApi));
    }

    private final void J(WxaApi wxaApi) {
        String c16;
        if (this.useEmptyAndroidId) {
            c16 = "";
        } else {
            c16 = o.c();
        }
        wxaApi.updateDeviceInfo(c16, c16, c16);
        if (QLog.isColorLevel()) {
            QLog.d("[wxa-q]WxaSDKInit", 2, "set aid=" + c16);
        }
        wxaApi.getDebugApi().setMultiTaskModeEnabledForWxaApp(true);
        wxaApi.updateTuringOAID(c16);
        try {
            ((IGdtWXMINIProgramAPI) QRoute.api(IGdtWXMINIProgramAPI.class)).updateTuringAIDTicketAsync(new WeakReference<>(BaseApplication.getContext()));
        } catch (Throwable th5) {
            QLog.e("[wxa-q]WxaSDKInit", 1, "[initWxApi]", th5);
        }
        WxaExtendApiJSBridge extendApiJSBridge = wxaApi.getExtendApiJSBridge();
        if (extendApiJSBridge != null) {
            extendApiJSBridge.setOpenUrlHandler(new a());
        }
        I(wxaApi);
        wxaApi.setDebugLogImpl(new q() { // from class: fb3.j
            @Override // com.tencent.luggage.wxaapi.q
            public final void println(int i3, String str, String str2) {
                WxaSDKInit.K(i3, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(int i3, String s16, String s17) {
        Intrinsics.checkNotNullParameter(s16, "s");
        Intrinsics.checkNotNullParameter(s17, "s1");
        QLog.d("[wxa-q]WxaSDKInit", 1, s16, s17);
    }

    private final void L() {
        try {
            System.loadLibrary("c++_shared");
        } catch (Exception e16) {
            QLog.e("[wxa-q]WxaSDKInit", 1, "failed to load library", e16);
        }
    }

    private final void M(String event, String appId, int hostScene) {
        HashMap hashMap = new HashMap();
        hashMap.put("applet_appid", appId);
        hashMap.put("host_scene", String.valueOf(hostScene));
        d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        String f16 = bindingWeChatUserInfo != null ? bindingWeChatUserInfo.f() : null;
        if (f16 == null) {
            f16 = "";
        }
        hashMap.put(StartupReportKey.WX_OPENID, f16);
        ((IMiniGameReport) QRoute.api(IMiniGameReport.class)).reportToBeacon(event, hashMap);
    }

    private final void N(String event, String appId, int hostScene, boolean isSucceed, Map<String, String> ext) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("applet_appid", appId);
        hashMap.put("host_scene", String.valueOf(hostScene));
        d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        String f16 = bindingWeChatUserInfo != null ? bindingWeChatUserInfo.f() : null;
        if (f16 == null) {
            f16 = "";
        }
        hashMap.put(StartupReportKey.WX_OPENID, f16);
        if (isSucceed) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_succeed", str);
        if (ext != null) {
            hashMap.putAll(ext);
        }
        ((IMiniGameReport) QRoute.api(IMiniGameReport.class)).reportToBeacon(event, hashMap);
    }

    private final String P(JSONObject ret) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = ret.optJSONObject(QQCustomArkDialogUtil.META_DATA);
        if (optJSONObject2 != null) {
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("detail_1");
            if (optJSONObject3 == null) {
                return "";
            }
            String optString = optJSONObject3.optString("url", "");
            Intrinsics.checkNotNullExpressionValue(optString, "detail.optString(\"url\", \"\")");
            return optString;
        }
        JSONObject optJSONObject4 = ret.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
        if (optJSONObject4 == null || (optJSONObject = optJSONObject4.optJSONObject("miniapp")) == null) {
            return "";
        }
        String optString2 = optJSONObject.optString(WadlProxyConsts.KEY_JUMP_URL, "");
        Intrinsics.checkNotNullExpressionValue(optString2, "miniApp.optString(\"jumpUrl\", \"\")");
        return optString2;
    }

    private final void Q(Runnable task) {
        ThreadManager.getUIHandler().post(task);
    }

    private final void R(String filePath, IMiniCallback callback) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).uploadArkImage(filePath, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final String str, final String appId, String str2, final String str3, final String str4, final WxaSDKInit this$0, final WxaAppCustomActionSheetDelegate.a aVar, final int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = bundle != null ? bundle.getString("imageUrl", "") : "";
        if (TextUtils.isEmpty(string)) {
            string = str;
        }
        final String str5 = string;
        i.d(appId, str2, str3, str4, str, string, new MiniAppCmdInterface() { // from class: fb3.s
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z17, JSONObject jSONObject) {
                WxaSDKInit.s(WxaSDKInit.this, aVar, appId, i3, str3, str4, str5, str, z17, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(final WxaSDKInit this$0, final WxaAppCustomActionSheetDelegate.a aVar, final String appId, final int i3, final String str, final String str2, final String str3, final String str4, boolean z16, final JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        if (z16 && jSONObject != null) {
            this$0.Q(new Runnable() { // from class: fb3.k
                @Override // java.lang.Runnable
                public final void run() {
                    WxaSDKInit.u(str, this$0, jSONObject, str2, str3, str4, aVar, appId, i3);
                }
            });
            return;
        }
        QLog.e("[wxa-q]WxaSDKInit", 1, "addToFavorite failed, shareInfo is null.");
        this$0.Q(new Runnable() { // from class: fb3.t
            @Override // java.lang.Runnable
            public final void run() {
                WxaSDKInit.t();
            }
        });
        if (aVar != null) {
            aVar.onFail("shareInfo is null");
        }
        O(this$0, "ev_applet_collect_my_qq_result", appId, i3, false, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t() {
        QQToast makeText = QQToast.makeText(BaseApplicationImpl.getApplication(), R.string.f16527283, 0);
        Intrinsics.checkNotNullExpressionValue(makeText, "makeText(\n              \u2026                        )");
        makeText.setToastIcon(QQToast.getIconRes(0));
        makeText.setType(0);
        makeText.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(String str, WxaSDKInit this$0, JSONObject jSONObject, String str2, String str3, String str4, WxaAppCustomActionSheetDelegate.a aVar, String appId, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        String str5 = context.getString(R.string.zxl) + str;
        String string = context.getString(R.string.zxk);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026ing.favorite_miniapp_tag)");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            MessageRecord messageRecord = new MessageRecord();
            QQAppInterface qQAppInterface = (QQAppInterface) runtime;
            messageRecord.senderuin = qQAppInterface.getAccount();
            QLog.i("[wxa-q]WxaSDKInit", 1, "addToFavorite done, success = " + QfavBuilder.Z(8, str5, this$0.P(jSONObject), string, str2, str3, str4, null, true, 0L).G("sBizDataList", this$0.G(jSONObject)).R(qQAppInterface, messageRecord).z(context));
            if (aVar != null) {
                aVar.onSuccess();
            }
            O(this$0, "ev_applet_collect_my_qq_result", appId, i3, true, null, 16, null);
            return;
        }
        if (aVar != null) {
            aVar.onFail("runtime is not qq interface!");
        }
        O(this$0, "ev_applet_collect_my_qq_result", appId, i3, false, null, 16, null);
    }

    private final void w(Bitmap source, String filePath) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);
                try {
                    source.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream2);
                    fileOutputStream2.close();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e16) {
                        QLog.e("[wxa-q]WxaSDKInit", 1, e16, new Object[0]);
                    }
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    QLog.e("[wxa-q]WxaSDKInit", 1, e, new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e18) {
                            QLog.e("[wxa-q]WxaSDKInit", 1, e18, new Object[0]);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                            QLog.e("[wxa-q]WxaSDKInit", 1, e19, new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
    }

    private final String x(String imagePath) {
        boolean startsWith$default;
        if (!TextUtils.isEmpty(imagePath)) {
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(imagePath, separator, false, 2, null);
            if (startsWith$default) {
                Bitmap decodeFile = BitmapFactory.decodeFile(imagePath);
                int width = decodeFile.getWidth();
                int height = decodeFile.getHeight();
                if (width != 0 && height != 0) {
                    float f16 = width;
                    if ((1.0f * f16) / height < 1.46f) {
                        height = (int) (f16 / 1.46f);
                    }
                    Bitmap destination = Bitmap.createBitmap(decodeFile, 0, 0, width, height);
                    String str = imagePath + util.base64_pad_url + System.currentTimeMillis();
                    Intrinsics.checkNotNullExpressionValue(destination, "destination");
                    w(destination, str);
                    return (new File(str).exists() && new File(imagePath).delete()) ? str : imagePath;
                }
                decodeFile.recycle();
            }
        }
        return imagePath;
    }

    public final WxaApi v() {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        QLog.i("[wxa-q]WxaSDKInit", 1, "buildWxaApi:" + BaseApplication.getContext() + " isApplication: " + BaseApplicationImpl.getApplication());
        int i3 = AbiUtil.isArm64Runtime(context) ? 2 : 1;
        boolean b16 = g.b();
        if (!b16) {
            L();
            BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(new b());
        }
        WxaApi a16 = WxaApi.a.a(context, INSTANCE.a(), i3);
        if (a16 == null) {
            return a16;
        }
        if (b16) {
            a16.setWxaProcessMaxCount(4);
        }
        J(a16);
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(final WxaApi wxaApi, final String appId, final JSONObject args, final WxaAppCustomActionSheetDelegate.a actionHandleCallback, final Map<String, ? extends Object> hostExtraData, final int shareSource) {
        QLog.i("[wxa-q]WxaSDKInit", 1, "doShare start");
        if (args == null) {
            QLog.e("[wxa-q]WxaSDKInit", 1, "doShare failed, args is null.");
            if (actionHandleCallback != null) {
                actionHandleCallback.onFail("args is null");
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: fb3.n
            @Override // java.lang.Runnable
            public final void run() {
                WxaSDKInit.D(WxaApi.this, appId, actionHandleCallback, args, this, hostExtraData, shareSource);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(final WxaApi wxaApi, final String appId, final JSONObject args, final WxaAppCustomActionSheetDelegate.a actionHandleCallback, Map<String, ? extends Object> hostExtraData) {
        Object obj = hostExtraData != null ? hostExtraData.get("host_scene") : null;
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        final int intValue = num != null ? num.intValue() : 0;
        M("ev_applet_wx_share_collect_my_qq", appId, intValue);
        if (args == null) {
            QLog.e("[wxa-q]WxaSDKInit", 1, "addToFavorite failed, args is null.");
            if (actionHandleCallback != null) {
                actionHandleCallback.onFail("args is null");
            }
            O(this, "ev_applet_collect_my_qq_result", appId, intValue, false, null, 16, null);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: fb3.l
            @Override // java.lang.Runnable
            public final void run() {
                WxaSDKInit.q(WxaApi.this, appId, actionHandleCallback, args, this, intValue);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(final String appId, final WxaAppCustomActionSheetDelegate.a actionHandleCallback, Map<String, ? extends Object> hostExtraData) {
        Object obj = hostExtraData != null ? hostExtraData.get("host_scene") : null;
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        final int intValue = num != null ? num.intValue() : 0;
        M("ev_applet_wx_share_add_my_app", appId, intValue);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: fb3.m
            @Override // java.lang.Runnable
            public final void run() {
                WxaSDKInit.A(appId, this, intValue, actionHandleCallback);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void z(WxaSDKInit wxaSDKInit, String str, WxaAppCustomActionSheetDelegate.a aVar, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        wxaSDKInit.y(str, aVar, map);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JP\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J2\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/wxmini/impl/WxaSDKInit$c", "Lcom/tencent/luggage/wxaapi/m;", "", "appId", "", "Lcom/tencent/luggage/wxaapi/WxaAppCustomActionSheetDelegate$ActionItem;", "provideCustomActionItems", "wxaAppID", "", "wxaAppVersionType", "itemID", "Lorg/json/JSONObject;", "args", "Lcom/tencent/luggage/wxaapi/WxaAppCustomActionSheetDelegate$a;", "actionHandleCallback", "Lcom/tencent/luggage/wxaapi/WxaAppCustomActionSheetDelegate$ActionType;", "type", "", "", "hostExtraData", "", "handleCustomAction", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements m {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WxaApi f327640b;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f327641a;

            static {
                int[] iArr = new int[WxaAppCustomActionSheetDelegate.ActionType.values().length];
                try {
                    iArr[WxaAppCustomActionSheetDelegate.ActionType.onShareAPPMessage.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[WxaAppCustomActionSheetDelegate.ActionType.onAddToFavorites.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[WxaAppCustomActionSheetDelegate.ActionType.onAddToMine.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f327641a = iArr;
            }
        }

        c(WxaApi wxaApi) {
            this.f327640b = wxaApi;
        }

        @Override // com.tencent.luggage.wxaapi.m
        public void handleCustomAction(String wxaAppID, int wxaAppVersionType, int itemID, JSONObject args, WxaAppCustomActionSheetDelegate.a actionHandleCallback, WxaAppCustomActionSheetDelegate.ActionType type, Map<String, ? extends Object> hostExtraData) {
            Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
            Intrinsics.checkNotNullParameter(actionHandleCallback, "actionHandleCallback");
            Intrinsics.checkNotNullParameter(type, "type");
            QLog.d("[wxa-q]WxaSDKInit", 1, "handleCustomActionEx wxaAppID = " + wxaAppID + ", wxaAppVersionType = " + wxaAppVersionType + ", itemId = " + itemID + " type = " + type);
            if (args != null) {
                QLog.d("[wxa-q]WxaSDKInit", 4, "args = " + args);
            }
            int i3 = a.f327641a[type.ordinal()];
            if (i3 == 1) {
                WxaSDKInit.this.C(this.f327640b, wxaAppID, args, actionHandleCallback, hostExtraData, itemID != 3 ? 1 : 2);
            } else if (i3 == 2) {
                WxaSDKInit.this.o(this.f327640b, wxaAppID, args, actionHandleCallback, hostExtraData);
            } else {
                if (i3 != 3) {
                    return;
                }
                WxaSDKInit.this.y(wxaAppID, actionHandleCallback, hostExtraData);
            }
        }

        @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate
        public List<WxaAppCustomActionSheetDelegate.ActionItem> provideCustomActionItems(String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            ArrayList arrayList = new ArrayList();
            WxaAppCustomActionSheetDelegate.ActionItem actionItem = new WxaAppCustomActionSheetDelegate.ActionItem();
            actionItem.f146876d = WxaAppCustomActionSheetDelegate.ActionType.onShareAPPMessage;
            actionItem.f146880i = 3;
            actionItem.f146877e = MobileQQ.sMobileQQ.getString(R.string.f20410520);
            actionItem.f146879h = R.drawable.of7;
            actionItem.f146881m = 10;
            arrayList.add(actionItem);
            WxaAppCustomActionSheetDelegate.ActionItem actionItem2 = new WxaAppCustomActionSheetDelegate.ActionItem();
            actionItem2.f146876d = WxaAppCustomActionSheetDelegate.ActionType.onAddToFavorites;
            actionItem2.f146880i = 6;
            actionItem2.f146877e = MobileQQ.sMobileQQ.getString(R.string.f197274jk);
            actionItem2.f146879h = R.drawable.f162708of4;
            actionItem2.f146881m = 20;
            arrayList.add(actionItem2);
            WxaAppCustomActionSheetDelegate.ActionItem actionItem3 = new WxaAppCustomActionSheetDelegate.ActionItem();
            actionItem3.f146876d = WxaAppCustomActionSheetDelegate.ActionType.onAddToMine;
            actionItem3.f146880i = 8;
            actionItem3.f146881m = 30;
            int miniAppTopTypeByAppId = ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppTopTypeByAppId(appId);
            if (miniAppTopTypeByAppId == 0) {
                actionItem3.f146877e = MobileQQ.sMobileQQ.getString(R.string.f197264jj);
                actionItem3.f146879h = R.drawable.of5;
                actionItem3.C = false;
                arrayList.add(actionItem3);
                QLog.d("[wxa-q]WxaSDKInit", 4, "topType = 0, show add ");
            } else if (miniAppTopTypeByAppId == 1) {
                actionItem3.f146877e = MobileQQ.sMobileQQ.getString(R.string.f2038951f);
                actionItem3.f146879h = R.drawable.of6;
                actionItem3.C = true;
                arrayList.add(actionItem3);
                QLog.d("[wxa-q]WxaSDKInit", 4, "topType = 1, show delete ");
            }
            return arrayList;
        }

        @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate
        public void handleCustomAction(String wxaAppID, int wxaAppVersionType, int itemID, JSONObject args, WxaAppCustomActionSheetDelegate.a actionHandleCallback) {
            Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
            Intrinsics.checkNotNullParameter(actionHandleCallback, "actionHandleCallback");
            QLog.d("[wxa-q]WxaSDKInit", 1, "handleCustomAction wxaAppID = " + wxaAppID + ", wxaAppVersionType = " + wxaAppVersionType + ", itemId = " + itemID);
            if (args != null) {
                QLog.d("[wxa-q]WxaSDKInit", 4, "args = " + args);
            }
            if (itemID == 3) {
                WxaSDKInit.this.C(this.f327640b, wxaAppID, args, actionHandleCallback, null, itemID == 3 ? 2 : 1);
            } else if (itemID == 6) {
                WxaSDKInit.p(WxaSDKInit.this, this.f327640b, wxaAppID, args, actionHandleCallback, null, 16, null);
            } else {
                if (itemID != 8) {
                    return;
                }
                WxaSDKInit.z(WxaSDKInit.this, wxaAppID, actionHandleCallback, null, 4, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(WxaApi wxaApi, final String appId, final WxaAppCustomActionSheetDelegate.a aVar, JSONObject jSONObject, final WxaSDKInit this$0, final int i3) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(wxaApi, "$wxaApi");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        r queryWxaProfileForAppId = wxaApi.queryWxaProfileForAppId(appId);
        if (queryWxaProfileForAppId == null) {
            QLog.e("[wxa-q]WxaSDKInit", 1, "addToFavorite failed, wxaInfo is null.");
            if (aVar != null) {
                aVar.onFail("wxaInfo is null");
                return;
            }
            return;
        }
        final String str = queryWxaProfileForAppId.f146896c;
        final String str2 = queryWxaProfileForAppId.f146895b;
        final String str3 = queryWxaProfileForAppId.f146897d;
        final String optString = jSONObject.optString("path", "");
        String imagePath = jSONObject.optString("imageUrl", "");
        Intrinsics.checkNotNullExpressionValue(imagePath, "imagePath");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(imagePath, "file://", false, 2, null);
        if (startsWith$default) {
            Intrinsics.checkNotNullExpressionValue(imagePath, "imagePath");
            imagePath = new Regex("file://").replaceFirst(imagePath, "");
        }
        Intrinsics.checkNotNullExpressionValue(imagePath, "imagePath");
        String x16 = this$0.x(imagePath);
        IMiniCallback iMiniCallback = new IMiniCallback() { // from class: fb3.q
            @Override // com.tencent.mobileqq.mini.api.IMiniCallback
            public final void onCallbackResult(boolean z16, Bundle bundle) {
                WxaSDKInit.r(str, appId, optString, str2, str3, this$0, aVar, i3, z16, bundle);
            }
        };
        if (!TextUtils.isEmpty(x16)) {
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(x16, separator, false, 2, null);
            if (startsWith$default2) {
                this$0.R(x16, iMiniCallback);
                return;
            }
        }
        iMiniCallback.onCallbackResult(true, new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(r rVar, JSONObject jSONObject, String thumbnail, WxaSDKInit this$0, final String appId, final int i3, final int i16, final WxaAppCustomActionSheetDelegate.a aVar) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(thumbnail, "$thumbnail");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        final Intent intent = new Intent();
        final String str = rVar.f146896c;
        final String str2 = rVar.f146895b;
        final String optString = jSONObject.optString("title", "");
        final String optString2 = jSONObject.optString("path", "");
        IMiniCallback iMiniCallback = new IMiniCallback() { // from class: fb3.r
            @Override // com.tencent.mobileqq.mini.api.IMiniCallback
            public final void onCallbackResult(boolean z16, Bundle bundle) {
                WxaSDKInit.F(str, intent, appId, str2, optString2, optString, i3, i16, aVar, z16, bundle);
            }
        };
        if (!TextUtils.isEmpty(thumbnail)) {
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(thumbnail, separator, false, 2, null);
            if (startsWith$default) {
                this$0.R(thumbnail, iMiniCallback);
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("imageUrl", thumbnail);
        iMiniCallback.onCallbackResult(true, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(WxaApi wxaApi, final String appId, final WxaAppCustomActionSheetDelegate.a aVar, final JSONObject jSONObject, final WxaSDKInit this$0, Map map, final int i3) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(wxaApi, "$wxaApi");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final r queryWxaProfileForAppId = wxaApi.queryWxaProfileForAppId(appId);
        if (queryWxaProfileForAppId == null) {
            QLog.e("[wxa-q]WxaSDKInit", 1, "doShare failed, wxaInfo is null.");
            if (aVar != null) {
                aVar.onFail("wxaInfo is null");
                return;
            }
            return;
        }
        String imagePath = jSONObject.optString("imageUrl", "");
        Intrinsics.checkNotNullExpressionValue(imagePath, "imagePath");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(imagePath, "file://", false, 2, null);
        if (startsWith$default) {
            Intrinsics.checkNotNullExpressionValue(imagePath, "imagePath");
            imagePath = new Regex("file://").replaceFirst(imagePath, "");
        }
        Intrinsics.checkNotNullExpressionValue(imagePath, "imagePath");
        final String x16 = this$0.x(imagePath);
        Object obj = map != null ? map.get("host_scene") : null;
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        final int intValue = num != null ? num.intValue() : 0;
        QLog.d("[wxa-q]WxaSDKInit", 2, "doShare args:" + jSONObject + " hostScene:" + intValue);
        this$0.Q(new Runnable() { // from class: fb3.p
            @Override // java.lang.Runnable
            public final void run() {
                WxaSDKInit.E(com.tencent.luggage.wxaapi.r.this, jSONObject, x16, this$0, appId, intValue, i3, aVar);
            }
        });
    }

    static /* synthetic */ void O(WxaSDKInit wxaSDKInit, String str, String str2, int i3, boolean z16, Map map, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            map = null;
        }
        wxaSDKInit.N(str, str2, i3, z16, map);
    }

    static /* synthetic */ void p(WxaSDKInit wxaSDKInit, WxaApi wxaApi, String str, JSONObject jSONObject, WxaAppCustomActionSheetDelegate.a aVar, Map map, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            map = null;
        }
        wxaSDKInit.o(wxaApi, str, jSONObject, aVar, map);
    }
}
