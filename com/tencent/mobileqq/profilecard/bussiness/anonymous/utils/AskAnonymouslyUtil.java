package com.tencent.mobileqq.profilecard.bussiness.anonymous.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.tencent.biz.ProtoUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.qrcode.api.impl.TroopQRCodeShareApiImpl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.relation.common.utils.c;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x11b2.oidb_0x11b2$AskAnonymouslyV2Req;
import tencent.im.oidb.cmd0x11b2.oidb_0x11b2$AskAnonymouslyV2Rsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/utils/AskAnonymouslyUtil;", "", "()V", "Companion", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class AskAnonymouslyUtil {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String ARK_APP_COMPACT = "[\u533f\u95ee\u6211\u7b54\uff0c\u7b49\u4f60\u6765\u63d0\u95ee\uff5e] \u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u624b\u673aQQ\u67e5\u770b";

    @NotNull
    public static final String ARK_APP_NAME = "com.tencent.askanonymously";

    @NotNull
    public static final String ARK_APP_PROMPT = "[\u533f\u95ee\u6211\u7b54] \u7edd\u5bf9\u5766\u767d\uff0c\u7b49\u4f60\u6765\u63d0\u95ee\uff5e";

    @NotNull
    public static final String ARK_APP_VER = "1.0.0.1";

    @NotNull
    public static final String ARK_APP_VIEW = "invite";

    @NotNull
    private static final String CMD_REQ_0XED4_ARK_SIGN = "OidbSvcTrpcTcp.0x11c9_0";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String JUMP_URL = "https://ti.qq.com/v2/anonymous/question?_wv=16777218&_wwv=129&uin=%s&from=%d";

    @NotNull
    public static final String META_BUTTON_KEY = "button";

    @NotNull
    public static final String META_JUMP_URL_KEY = "jump_url";

    @NotNull
    public static final String META_META_DATA_TYPE = "invite";

    @NotNull
    public static final String META_SUMMARY_KEY = "summary";

    @NotNull
    public static final String META_TITLE_KEY = "title";

    @NotNull
    public static final String SHARE_INVITE_TO_QZONE_BG_URL = "https://downv6.qq.com/qq_relation/ask_anonymously/ask_anonymously_invite_bg_to_qzone_v2.png";
    public static final int SHARE_TO_QZONE_ACTION_TYPE = 2;
    public static final int SHARE_TO_QZONE_RECOM_BOTTOM_ID = 5;

    @NotNull
    public static final String SHARE_TO_QZONE_SUMMARY = "\u533f\u540d\u63d0\u95ee\uff0c\u6709\u95ee\u5fc5\u7b54";

    @NotNull
    public static final String SHARE_TO_QZONE_TITLE = "\u533f\u95ee\u6211\u7b54";
    public static final int SHARE_TYPE_DETAIL = 2;

    @NotNull
    public static final String TAG = "AskAnonymouslyUtil";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u0004\u0018\u00010\u0004J\"\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010(\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&J$\u0010)\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010*\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$J$\u0010+\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/utils/AskAnonymouslyUtil$Companion;", "", "()V", "ARK_APP_COMPACT", "", "ARK_APP_NAME", "ARK_APP_PROMPT", "ARK_APP_VER", "ARK_APP_VIEW", "CMD_REQ_0XED4_ARK_SIGN", "JUMP_URL", "META_BUTTON_KEY", "META_JUMP_URL_KEY", "META_META_DATA_TYPE", "META_SUMMARY_KEY", "META_TITLE_KEY", "SHARE_INVITE_TO_QZONE_BG_URL", "SHARE_TO_QZONE_ACTION_TYPE", "", "SHARE_TO_QZONE_RECOM_BOTTOM_ID", "SHARE_TO_QZONE_SUMMARY", "SHARE_TO_QZONE_TITLE", "SHARE_TYPE_DETAIL", "TAG", "constructShareData", "Lcooperation/qzone/QZoneShareData;", "imageUrl", WadlProxyConsts.KEY_JUMP_URL, "dismissLoadingDialog", "", "dialog", "Landroid/app/Dialog;", "getAskAnonymouslyArkMeta", "getInviteAskAnonymouslyIntent", "Landroid/content/Intent;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "showQzone", "", "singedJson", "inviteAskAnonymously", AskAnonymouslyApiPlugin.METHOD_SHARE_DETAIL_TO_QZONE, "shareInviteToQZone", "syncDetailToQZone", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }

        private final QZoneShareData constructShareData(String imageUrl, String jumpUrl) {
            QZoneShareData qZoneShareData = new QZoneShareData();
            qZoneShareData.mSummary = AskAnonymouslyUtil.SHARE_TO_QZONE_SUMMARY;
            qZoneShareData.mTitle = AskAnonymouslyUtil.SHARE_TO_QZONE_TITLE;
            ArrayList<String> arrayList = new ArrayList<>();
            qZoneShareData.mImageUrls = arrayList;
            arrayList.add(imageUrl);
            qZoneShareData.targetUrl = jumpUrl;
            qZoneShareData.from = 0;
            HashMap hashMap = new HashMap();
            qZoneShareData.qzoneShareInfo = hashMap;
            Intrinsics.checkNotNullExpressionValue(hashMap, "shareData.qzoneShareInfo");
            hashMap.put("change_big_pic", "1");
            Map<String, String> map = qZoneShareData.qzoneShareInfo;
            Intrinsics.checkNotNullExpressionValue(map, "shareData.qzoneShareInfo");
            map.put("need_circular_bead", "1");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("icon_url", IProfileCardConst.SHARE_TO_QZONE_ICON_URL);
                jSONObject.put("title", AskAnonymouslyUtil.SHARE_TO_QZONE_TITLE);
                jSONObject.put("summary", AskAnonymouslyUtil.SHARE_TO_QZONE_SUMMARY);
                jSONObject.put("jump_url", jumpUrl);
                jSONObject.put(AppDownloadCallback.BUTTON_TXT, MobileQQ.sMobileQQ.getApplicationContext().getResources().getString(R.string.f20336500));
                jSONObject.put(TroopQRCodeShareApiImpl.TAIL_KEY_RECOM_ID, 5);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
                jSONObject.put("action_type", 2);
                Map<String, String> map2 = qZoneShareData.qzoneShareInfo;
                Intrinsics.checkNotNullExpressionValue(map2, "shareData.qzoneShareInfo");
                map2.put("comm_recom_bottom", jSONObject2);
                QLog.d(AskAnonymouslyUtil.TAG, 1, "shareInviteToQZone\uff0c comm_recom_bottom\uff1a " + jSONObject2);
            } catch (Exception e16) {
                QLog.e(AskAnonymouslyUtil.TAG, 1, "shareInviteToQZone exception: " + Log.getStackTraceString(e16));
            }
            return qZoneShareData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void dismissLoadingDialog(Dialog dialog) {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Intent getInviteAskAnonymouslyIntent(Activity activity, boolean showQzone, String singedJson) {
            Intent intent = new Intent(activity, (Class<?>) ((IForwardApi) QRoute.api(IForwardApi.class)).getForwardRecentActivityClass());
            try {
                intent.putExtra("forward_type", ((IForwardApi) QRoute.api(IForwardApi.class)).SEND_ASK_ANONYMOUSLY_ARK_MSG());
                intent.putExtra("is_ark_display_share", true);
                intent.putExtra("forward_ark_app_name", AskAnonymouslyUtil.ARK_APP_NAME);
                intent.putExtra("forward_ark_app_view", "invite");
                intent.putExtra("forward_ark_app_ver", AskAnonymouslyUtil.ARK_APP_VER);
                intent.putExtra("forward_ark_app_prompt", AskAnonymouslyUtil.ARK_APP_PROMPT);
                intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_COMPAT, AskAnonymouslyUtil.ARK_APP_COMPACT);
                intent.putExtra("k_qzone", showQzone);
                intent.putExtra(((IForwardApi) QRoute.api(IForwardApi.class)).SELECTION_MODE(), ((IForwardApi) QRoute.api(IForwardApi.class)).SELECTION_MODE_MULTI());
                String c16 = c.c(singedJson);
                intent.putExtra("forward_ark_app_meta", c16);
                if (QLog.isColorLevel()) {
                    QLog.d(AskAnonymouslyUtil.TAG, 2, "getInviteAskAnonymouslyIntent metaDataString: " + c16);
                }
                Bundle zipArgs = QQCustomArkDialogUtil.zipArgs(AskAnonymouslyUtil.ARK_APP_NAME, "invite", AskAnonymouslyUtil.ARK_APP_VER, c16, MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density, null, null);
                zipArgs.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, c.b(singedJson));
                intent.putExtras(zipArgs);
            } catch (JSONException e16) {
                QLog.e(AskAnonymouslyUtil.TAG, 1, "getInviteAskAnonymouslyIntent exception message: " + e16.getMessage());
            }
            return intent;
        }

        @Nullable
        public final String getAskAnonymouslyArkMeta() throws JSONException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(AskAnonymouslyUtil.JUMP_URL, Arrays.copyOf(new Object[]{MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), 4}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            jSONObject2.put("jump_url", format);
            jSONObject.put("invite", jSONObject2);
            return jSONObject.toString();
        }

        public final void inviteAskAnonymously(@Nullable final Activity activity, final boolean showQzone) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, activity, Boolean.valueOf(showQzone));
                return;
            }
            if (activity != null) {
                str = activity.getString(R.string.f213335px);
            } else {
                str = null;
            }
            final Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(activity, str, true);
            Intrinsics.checkNotNullExpressionValue(showLoadingDialog, "showLoadingDialog(\n     \u2026ding), true\n            )");
            showLoadingDialog.show();
            Long uin = Long.valueOf(MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
            oidb_0x11b2$AskAnonymouslyV2Req oidb_0x11b2_askanonymouslyv2req = new oidb_0x11b2$AskAnonymouslyV2Req();
            PBUInt64Field pBUInt64Field = oidb_0x11b2_askanonymouslyv2req.uin;
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            pBUInt64Field.set(uin.longValue());
            ProtoUtils.a(MobileQQ.sMobileQQ.peekAppRuntime(), new ProtoUtils.TroopProtocolObserver(showLoadingDialog, activity, showQzone) { // from class: com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil$Companion$inviteAskAnonymously$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity $activity;
                final /* synthetic */ Dialog $dialog;
                final /* synthetic */ boolean $showQzone;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$dialog = showLoadingDialog;
                    this.$activity = activity;
                    this.$showQzone = showQzone;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, showLoadingDialog, activity, Boolean.valueOf(showQzone));
                    }
                }

                @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
                public boolean onError(int errorCode, @Nullable String errorMsg, @Nullable Bundle bundle) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                        AskAnonymouslyUtil.INSTANCE.dismissLoadingDialog(this.$dialog);
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("inviteAskAnonymously sendOIDBRequest errorCode:%s, errorMsg:%s", Arrays.copyOf(new Object[]{Integer.valueOf(errorCode), errorMsg}, 2));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        QLog.e(AskAnonymouslyApiPlugin.TAG, 1, format);
                        return super.onError(errorCode, errorMsg, bundle);
                    }
                    return ((Boolean) iPatchRedirector2.redirect((short) 3, this, Integer.valueOf(errorCode), errorMsg, bundle)).booleanValue();
                }

                @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
                public void onResult(int errorCode, @Nullable byte[] data, @NotNull Bundle bundle) {
                    Intent inviteAskAnonymouslyIntent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(bundle, "bundle");
                    AskAnonymouslyUtil.Companion companion = AskAnonymouslyUtil.INSTANCE;
                    companion.dismissLoadingDialog(this.$dialog);
                    if (errorCode == 0 && data != null) {
                        oidb_0x11b2$AskAnonymouslyV2Rsp oidb_0x11b2_askanonymouslyv2rsp = new oidb_0x11b2$AskAnonymouslyV2Rsp();
                        oidb_0x11b2_askanonymouslyv2rsp.mergeFrom(data);
                        String signedJson = oidb_0x11b2_askanonymouslyv2rsp.signed_ark_msg.get();
                        if (QLog.isColorLevel()) {
                            QLog.i(AskAnonymouslyUtil.TAG, 2, "inviteAskAnonymously");
                        }
                        if (TextUtils.isEmpty(signedJson)) {
                            QLog.e(AskAnonymouslyUtil.TAG, 2, "inviteAskAnonymously error: signedJson is null");
                            return;
                        }
                        Activity activity2 = this.$activity;
                        if (activity2 == null) {
                            QLog.e(AskAnonymouslyUtil.TAG, 2, "inviteAskAnonymously error: activity is null");
                            return;
                        }
                        boolean z16 = this.$showQzone;
                        Intrinsics.checkNotNullExpressionValue(signedJson, "signedJson");
                        inviteAskAnonymouslyIntent = companion.getInviteAskAnonymouslyIntent(activity2, z16, signedJson);
                        if (inviteAskAnonymouslyIntent == null) {
                            QLog.e(AskAnonymouslyUtil.TAG, 1, "inviteAskAnonymously error: params wrong");
                            return;
                        } else {
                            this.$activity.startActivity(inviteAskAnonymouslyIntent);
                            return;
                        }
                    }
                    ToastUtil.a().b(R.string.ci7);
                }
            }, oidb_0x11b2_askanonymouslyv2req.toByteArray(), AskAnonymouslyUtil.CMD_REQ_0XED4_ARK_SIGN, 4553, 0);
        }

        public final void shareDetailToQZone(@Nullable Activity activity, @Nullable String imageUrl, @Nullable String jumpUrl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, activity, imageUrl, jumpUrl);
                return;
            }
            if (activity != null && !TextUtils.isEmpty(imageUrl) && !TextUtils.isEmpty(jumpUrl)) {
                Intrinsics.checkNotNull(imageUrl);
                Intrinsics.checkNotNull(jumpUrl);
                QZoneShareManager.shareToQzoneFromAskAnonymously(activity, MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), constructShareData(imageUrl, jumpUrl), 2);
                return;
            }
            QLog.e(AskAnonymouslyUtil.TAG, 2, "shareDetailToQZone error: param is invalid");
        }

        public final void shareInviteToQZone(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(AskAnonymouslyUtil.TAG, 2, "shareInviteToQZone");
            }
            if (activity == null) {
                QLog.e(AskAnonymouslyUtil.TAG, 2, "shareInviteToQZone error: activity is null");
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(AskAnonymouslyUtil.JUMP_URL, Arrays.copyOf(new Object[]{MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), 5}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            Intrinsics.checkNotNull(format);
            QZoneShareManager.shareToQzoneFromAskAnonymously(activity, MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), constructShareData(AskAnonymouslyUtil.SHARE_INVITE_TO_QZONE_BG_URL, format), 1);
        }

        public final void syncDetailToQZone(@Nullable Activity activity, @Nullable String imageUrl, @Nullable String jumpUrl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, activity, imageUrl, jumpUrl);
                return;
            }
            if (activity != null && !TextUtils.isEmpty(imageUrl) && !TextUtils.isEmpty(jumpUrl)) {
                Intrinsics.checkNotNull(imageUrl);
                Intrinsics.checkNotNull(jumpUrl);
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).startShareServlet(activity, "", MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin(), constructShareData(imageUrl, jumpUrl));
                return;
            }
            QLog.e(AskAnonymouslyUtil.TAG, 2, "syncDetailToQZone error: param is invalid");
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18458);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AskAnonymouslyUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
