package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001f\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010 \u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0018\u0010)\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\"R\u0018\u0010+\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\"R\u0018\u0010-\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\"R\u0018\u0010/\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\"R\u0018\u00101\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\"R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/bc;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "Lcom/tencent/mobileqq/troop/utils/e$a;", "", "ba", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "ca", "", "appIdStr", "R9", "Lorg/json/JSONObject;", "result", "Z9", "resultObj", "U9", "V9", "Y9", "aa", "message", "ea", "T9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "", "requestCode", "requstParams", "rg", "onPartDestroy", "e", "Ljava/lang/String;", "mShareAppId", "f", "mShareOpenId", tl.h.F, "mShareUin", "i", "mIsFromGame", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mGuildId", BdhLogUtil.LogTag.Tag_Conn, "mGameZoneId", "D", "mGameRoleId", "E", "mGameGroupCode", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mAccountConfirmDlg", "Landroid/os/Handler;", "G", "Landroid/os/Handler;", "mOpenIdTimeoutHandler", "", "H", "Z", "mGetOpenIdTimeout", "Lcom/tencent/mobileqq/app/BaseMessageObserver;", "I", "Lcom/tencent/mobileqq/app/BaseMessageObserver;", "openIdObserver", "<init>", "()V", "J", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class bc extends h implements e.a {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String mGameZoneId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String mGameRoleId;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String mGameGroupCode;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QQCustomDialog mAccountConfirmDlg;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Handler mOpenIdTimeoutHandler;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mGetOpenIdTimeout;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private BaseMessageObserver openIdObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mShareAppId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mShareOpenId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mShareUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mIsFromGame;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mGuildId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/bc$a;", "", "", "REQUEST_CODE_CHECK_JOIN_GROUP_STATE", "I", "REQUEST_CODE_JOIN_GROUP", "", "TAG", "Ljava/lang/String;", "TYPE_ON_GET_OPENID", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.bc$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/part/bc$b", "Lcom/tencent/mobileqq/app/BaseMessageObserver;", "", "isSuccess", "Lcom/tencent/mobileqq/data/OpenID;", "data", "", "a", "", "type", "", "onUpdate", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends BaseMessageObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bc.this);
            }
        }

        private final void a(boolean isSuccess, OpenID data) {
            if (bc.this.getActivity() != null && !bc.this.getActivity().isFinishing() && !bc.this.mGetOpenIdTimeout) {
                com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.f();
                Handler handler = bc.this.mOpenIdTimeoutHandler;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (isSuccess && data != null && data.openID != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopSettingGameSdkPart", 2, "openIdObserver success");
                    }
                    if (!Intrinsics.areEqual(data.openID, bc.this.mShareOpenId)) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TroopSettingGameSdkPart", 2, "-->onGetOpenId--openid doesn't equal current openid");
                        }
                        bc bcVar = bc.this;
                        Activity activity = bcVar.getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity, "activity");
                        bcVar.ca(activity);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopSettingGameSdkPart", 2, "openIdObserver fail");
                }
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
            OpenID openID;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
                return;
            }
            if (type == 1) {
                QLog.d("openid", 2, "isSuccess=" + isSuccess + ",data=" + data);
                if (data instanceof OpenID) {
                    openID = (OpenID) data;
                } else {
                    openID = null;
                }
                a(isSuccess, openID);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60717);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public bc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.openIdObserver = new b();
        }
    }

    private final void R9(String appIdStr) {
        OpenID openID;
        Object strOpenIDFromCacheAndDB = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getStrOpenIDFromCacheAndDB(z9(), appIdStr);
        QBaseActivity qBaseActivity = null;
        if (strOpenIDFromCacheAndDB instanceof OpenID) {
            openID = (OpenID) strOpenIDFromCacheAndDB;
        } else {
            openID = null;
        }
        if (openID == null) {
            com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
            Activity activity = getActivity();
            if (activity instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) activity;
            }
            aVar.i(qBaseActivity);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ax
                @Override // java.lang.Runnable
                public final void run() {
                    bc.S9(bc.this);
                }
            }, 3000L);
            this.mOpenIdTimeoutHandler = handler;
            z9().addObserver(this.openIdObserver);
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getOpenID(z9(), appIdStr);
            return;
        }
        if (!Intrinsics.areEqual(this.mShareOpenId, openID.openID)) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopSettingGameSdkPart", 2, "-->preForward--openid doesn't equal current local openid");
            }
            Activity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            ca(activity2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(bc this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity().isFinishing()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TroopSettingGameSdkPart", 2, "-->preForward--fetch openid timeout");
        }
        this$0.mGetOpenIdTimeout = true;
        com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.f();
    }

    private final void T9() {
        com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        aVar.h(activity);
    }

    private final void U9(JSONObject resultObj) throws JSONException {
        JSONObject jSONObject;
        Object obj = resultObj.get(Constants.Configs.BASICS);
        JSONArray jSONArray = null;
        if (obj instanceof JSONObject) {
            jSONObject = (JSONObject) obj;
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        Object obj2 = jSONObject.get("datas");
        if (obj2 instanceof JSONArray) {
            jSONArray = (JSONArray) obj2;
        }
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object obj3 = jSONArray.get(i3);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type org.json.JSONObject");
            JSONObject jSONObject2 = (JSONObject) obj3;
            Object obj4 = jSONObject2.get("name");
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj4;
            Object obj5 = jSONObject2.get("state");
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj5).intValue();
            Object obj6 = jSONObject2.get(DTConstants.TAG.API);
            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj6;
            Object obj7 = jSONObject2.get("msg");
            Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.String");
            String str3 = (String) obj7;
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingGameSdkPart", 2, "checkApiState onResult, basics name = " + str + " state = " + intValue + " api = " + str2 + " msg = " + str3);
            }
        }
    }

    private final void V9(JSONObject resultObj) throws JSONException {
        JSONObject jSONObject;
        Object obj = resultObj.get("friendlink");
        JSONArray jSONArray = null;
        if (obj instanceof JSONObject) {
            jSONObject = (JSONObject) obj;
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        Object obj2 = jSONObject.get("datas");
        if (obj2 instanceof JSONArray) {
            jSONArray = (JSONArray) obj2;
        }
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object obj3 = jSONArray.get(i3);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type org.json.JSONObject");
            JSONObject jSONObject2 = (JSONObject) obj3;
            Object obj4 = jSONObject2.get("name");
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj4;
            Object obj5 = jSONObject2.get("state");
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj5).intValue();
            Object obj6 = jSONObject2.get(DTConstants.TAG.API);
            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj6;
            Object obj7 = jSONObject2.get("msg");
            Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.String");
            String str3 = (String) obj7;
            if (Intrinsics.areEqual("add_group", str2) && intValue != 1) {
                getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.az
                    @Override // java.lang.Runnable
                    public final void run() {
                        bc.W9(bc.this);
                    }
                });
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingGameSdkPart", 2, "checkApiState onResult, friendlink name = " + str + " state = " + intValue + " api = " + str2 + " msg= " + str3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(final bc this$0) {
        QQCustomDialog qQCustomDialog;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQCustomDialog qQCustomDialog2 = this$0.mAccountConfirmDlg;
        if (qQCustomDialog2 != null) {
            boolean z16 = false;
            if (qQCustomDialog2 != null && !qQCustomDialog2.isShowing()) {
                z16 = true;
            }
            if (z16 && (qQCustomDialog = this$0.mAccountConfirmDlg) != null) {
                qQCustomDialog.show();
                return;
            }
            return;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                bc.X9(bc.this, dialogInterface, i3);
            }
        };
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this$0.getActivity(), 230);
        createCustomDialog.setMessage(this$0.getActivity().getResources().getString(R.string.f173230i72));
        createCustomDialog.setPositiveButton(R.string.a8j, onClickListener);
        this$0.mAccountConfirmDlg = createCustomDialog;
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(bc this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 1) {
            QQCustomDialog qQCustomDialog = this$0.mAccountConfirmDlg;
            if (qQCustomDialog != null) {
                qQCustomDialog.cancel();
            }
            this$0.T9();
        }
    }

    private final void Y9(JSONObject resultObj) throws JSONException {
        JSONObject jSONObject;
        Object obj = resultObj.get(PreDownloadConstants.DEPARTMENT_QQPAY);
        JSONArray jSONArray = null;
        if (obj instanceof JSONObject) {
            jSONObject = (JSONObject) obj;
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        Object obj2 = jSONObject.get("datas");
        if (obj2 instanceof JSONArray) {
            jSONArray = (JSONArray) obj2;
        }
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object obj3 = jSONArray.get(i3);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type org.json.JSONObject");
            JSONObject jSONObject2 = (JSONObject) obj3;
            Object obj4 = jSONObject2.get("name");
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj4;
            Object obj5 = jSONObject2.get("state");
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj5).intValue();
            Object obj6 = jSONObject2.get(DTConstants.TAG.API);
            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj6;
            Object obj7 = jSONObject2.get("msg");
            Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.String");
            String str3 = (String) obj7;
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingGameSdkPart", 2, "checkApiState onResult, qqpay name = " + str + " state = " + intValue + " api = " + str2 + " msg= " + str3);
            }
        }
    }

    private final void Z9(JSONObject result) {
        JSONObject jSONObject;
        if (result == null) {
            return;
        }
        try {
            Object obj = result.get("retcode");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj).intValue();
            Object obj2 = result.get("result");
            if (obj2 instanceof JSONObject) {
                jSONObject = (JSONObject) obj2;
            } else {
                jSONObject = null;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingGameSdkPart", 2, "checkApiState onResult. retCode = " + intValue + "\n");
            }
            if (intValue == 0 && jSONObject != null) {
                U9(jSONObject);
                V9(jSONObject);
                Object obj3 = jSONObject.get("appid");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                int intValue2 = ((Integer) obj3).intValue();
                if (QLog.isColorLevel()) {
                    QLog.i("TroopSettingGameSdkPart", 2, "checkApiState onResult, appid =" + intValue2 + "\n");
                }
                Y9(jSONObject);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopSettingGameSdkPart", 2, "checkApiState onResult " + e16);
            }
        }
    }

    private final void aa(JSONObject result) {
        JSONObject jSONObject;
        if (result == null) {
            return;
        }
        try {
            Object obj = result.get("data");
            JSONObject jSONObject2 = null;
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return;
            }
            Object obj2 = jSONObject.get("key");
            if (obj2 instanceof JSONObject) {
                jSONObject2 = (JSONObject) obj2;
            }
            if (jSONObject2 == null) {
                return;
            }
            Object obj3 = jSONObject2.get("retCode");
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            Object obj4 = jSONObject2.get("retMsg");
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj4;
            if (intValue == 0) {
                B9().b4(new a.C8823a(true));
                ReportController.o(z9(), "CliOper", "", "", "0x80084B5", "0x80084B5", 0, 0, "", "", "", "");
            } else {
                String string = getActivity().getResources().getString(R.string.i6y);
                Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026d_game_join_system_error)");
                if (intValue != 221002) {
                    if (intValue == 221020) {
                        string = getActivity().getResources().getString(R.string.i6z);
                        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026_card_join_pay_not_allow)");
                    }
                } else {
                    string = getActivity().getResources().getString(R.string.i6t);
                    Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026rd_game_already_not_join)");
                }
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                ea(activity, string);
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingGameSdkPart", 2, "joinGroup onResult retCode = " + intValue + " retMsg = " + str);
            }
        } catch (Exception e16) {
            Activity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            String string2 = getActivity().getResources().getString(R.string.i6y);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.resources.getSt\u2026d_game_join_system_error)");
            ea(activity2, string2);
            if (QLog.isColorLevel()) {
                QLog.e("TroopSettingGameSdkPart", 2, "joinGroup onResult " + e16);
            }
        }
    }

    private final void ba() {
        ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
        Bundle arguments = getPartHost().getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        this.mShareAppId = arguments.getString("appid");
        this.mShareOpenId = arguments.getString("openid");
        this.mShareUin = arguments.getString("share_uin");
        String string = arguments.getString("is_from_game");
        this.mIsFromGame = string;
        if (Intrinsics.areEqual("true", string) && !TextUtils.isEmpty(this.mShareAppId)) {
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).checkApiState(z9(), getActivity().getApplicationContext(), this.mShareAppId, this, 0, null);
            this.mGuildId = arguments.getString("guild_id");
            this.mGameZoneId = arguments.getString("zone_id");
            this.mGameRoleId = arguments.getString("role_id");
            String string2 = arguments.getString("gc");
            this.mGameGroupCode = string2;
            QLog.d("TroopSettingGameSdkPart", 2, "joinGroup appid = " + this.mShareAppId + " openid = " + this.mShareOpenId + " guild id = " + this.mGuildId + "zone_id = " + this.mGameZoneId + " role id = " + this.mGameRoleId + "  group code= " + string2);
        } else {
            QLog.d("TroopSettingGameSdkPart", 2, " joinGroup is from game = false");
        }
        String valueOf = String.valueOf(this.mShareAppId);
        if (!TextUtils.isEmpty(this.mShareUin) && !Intrinsics.areEqual(this.mShareUin, z9().getAccount())) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            ca(activity);
        } else if (!TextUtils.isEmpty(this.mShareOpenId)) {
            R9(valueOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca(final Activity activity) {
        QQCustomDialog qQCustomDialog;
        QQCustomDialog qQCustomDialog2 = this.mAccountConfirmDlg;
        if (qQCustomDialog2 != null) {
            boolean z16 = false;
            if (qQCustomDialog2 != null && qQCustomDialog2.isShowing()) {
                z16 = true;
            }
            if (!z16 && (qQCustomDialog = this.mAccountConfirmDlg) != null) {
                qQCustomDialog.show();
                return;
            }
            return;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ay
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                bc.da(activity, this, dialogInterface, i3);
            }
        };
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        createCustomDialog.setMessage(R.string.d65);
        createCustomDialog.setTitle(R.string.b1v);
        createCustomDialog.setNegativeButton(R.string.cancel, onClickListener);
        createCustomDialog.setPositiveButton(R.string.d5b, onClickListener);
        this.mAccountConfirmDlg = createCustomDialog;
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Activity activity, bc this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            if (i3 == 1) {
                ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).startJumpAccountLogin(activity, this$0.mAccountConfirmDlg);
                com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.h(activity);
                return;
            }
            return;
        }
        com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.h(activity);
    }

    private final void ea(final Activity activity, final String message) {
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.aw
            @Override // java.lang.Runnable
            public final void run() {
                bc.ga(bc.this, activity, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(final bc this$0, final Activity activity, final String message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(message, "$message");
        QQCustomDialog qQCustomDialog = this$0.mAccountConfirmDlg;
        if (qQCustomDialog != null) {
            Intrinsics.checkNotNull(qQCustomDialog);
            if (!qQCustomDialog.isShowing()) {
                QQCustomDialog qQCustomDialog2 = this$0.mAccountConfirmDlg;
                Intrinsics.checkNotNull(qQCustomDialog2);
                qQCustomDialog2.show();
                return;
            }
            return;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ba
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                bc.ha(bc.this, activity, message, dialogInterface, i3);
            }
        };
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        createCustomDialog.setMessage(message);
        createCustomDialog.setPositiveButton(R.string.a8j, onClickListener);
        createCustomDialog.setNegativeButton(R.string.cancel, onClickListener);
        this$0.mAccountConfirmDlg = createCustomDialog;
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(bc this$0, Activity activity, String message, DialogInterface dialogInterface, int i3) {
        long j3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(message, "$message");
        if (i3 == 1) {
            QQCustomDialog qQCustomDialog = this$0.mAccountConfirmDlg;
            if (qQCustomDialog != null) {
                qQCustomDialog.cancel();
                return;
            }
            return;
        }
        try {
            IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
            String str = this$0.mShareAppId;
            if (str != null) {
                j3 = Long.parseLong(str);
            } else {
                j3 = 0;
            }
            iChatSettingForTroopApi.startGameSdkCallback(activity, true, "action_game_join_group", j3, -1, message);
        } catch (Exception e16) {
            QLog.e("TroopSettingGameSdkPart", 1, "showAlertDlg error = " + e16);
        }
        QQCustomDialog qQCustomDialog2 = this$0.mAccountConfirmDlg;
        if (qQCustomDialog2 != null) {
            qQCustomDialog2.cancel();
        }
        this$0.T9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            ba();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        z9().removeObserver(this.openIdObserver);
        this.mAccountConfirmDlg = null;
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.mobileqq.troop.utils.e.a
    public void rg(@Nullable JSONObject result, int requestCode, @Nullable Bundle requstParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, result, Integer.valueOf(requestCode), requstParams);
        } else {
            if (requestCode != 0) {
                if (requestCode == 1) {
                    aa(result);
                    return;
                }
                return;
            }
            Z9(result);
        }
    }
}
