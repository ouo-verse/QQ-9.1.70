package com.qzone.reborn.albumx.common.share;

import android.app.Activity;
import android.content.Intent;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J<\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014J\u001e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/albumx/common/share/ShareApi;", "", "Lcom/qzone/reborn/albumx/common/share/ShareApi$ArkShareParams;", "arkShareParams", "Landroid/content/Intent;", "intent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "Lcom/qzone/reborn/albumx/common/share/ShareApi$FriendSelectParams;", "params", h.F, "Landroid/os/ResultReceiver;", "resultReceiver", "d", "b", "c", "", "requestCode", "", "isNeedReturnSelectedList", "isNeedBottomSheetPreview", "e", "g", "<init>", "()V", "ArkShareParams", "FriendSelectParams", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ShareApi {

    /* renamed from: a, reason: collision with root package name */
    public static final ShareApi f52556a = new ShareApi();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/albumx/common/share/ShareApi$ArkShareParams;", "Ljava/io/Serializable;", "()V", "appID", "", "getAppID", "()Ljava/lang/String;", "setAppID", "(Ljava/lang/String;)V", "arkAppName", "getArkAppName", "setArkAppName", "arkContent", "getArkContent", "setArkContent", "arkId", "getArkId", "setArkId", "arkJson", "getArkJson", "setArkJson", "detailUrl", "getDetailUrl", "setDetailUrl", "forwardType", "", "getForwardType", "()I", "setForwardType", "(I)V", "nickName", "getNickName", "setNickName", "reqType", "getReqType", "setReqType", "toUin", "getToUin", "setToUin", "toUinType", "getToUinType", "setToUinType", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public static final class ArkShareParams implements Serializable {
        private int forwardType;
        private int reqType;
        private int toUinType;
        private String detailUrl = "";
        private String appID = "";
        private String arkJson = "";
        private String arkId = "";
        private String arkAppName = "";
        private String arkContent = "";
        private String toUin = "";
        private String nickName = "";

        public final String getAppID() {
            return this.appID;
        }

        public final String getArkAppName() {
            return this.arkAppName;
        }

        public final String getArkContent() {
            return this.arkContent;
        }

        public final String getArkId() {
            return this.arkId;
        }

        public final String getArkJson() {
            return this.arkJson;
        }

        public final String getDetailUrl() {
            return this.detailUrl;
        }

        public final int getForwardType() {
            return this.forwardType;
        }

        public final String getNickName() {
            return this.nickName;
        }

        public final int getReqType() {
            return this.reqType;
        }

        public final String getToUin() {
            return this.toUin;
        }

        public final int getToUinType() {
            return this.toUinType;
        }

        public final void setAppID(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appID = str;
        }

        public final void setArkAppName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.arkAppName = str;
        }

        public final void setArkContent(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.arkContent = str;
        }

        public final void setArkId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.arkId = str;
        }

        public final void setArkJson(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.arkJson = str;
        }

        public final void setDetailUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.detailUrl = str;
        }

        public final void setForwardType(int i3) {
            this.forwardType = i3;
        }

        public final void setNickName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.nickName = str;
        }

        public final void setReqType(int i3) {
            this.reqType = i3;
        }

        public final void setToUin(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.toUin = str;
        }

        public final void setToUinType(int i3) {
            this.toUinType = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/albumx/common/share/ShareApi$FriendSelectParams;", "Ljava/io/Serializable;", "()V", "finishText", "", "getFinishText", "()Ljava/lang/String;", "setFinishText", "(Ljava/lang/String;)V", "isMiniMode", "", "()Z", "setMiniMode", "(Z)V", "isShowFriendFirst", "setShowFriendFirst", "isShowGuild", "setShowGuild", "isShowTroop", "setShowTroop", "isSingle", "setSingle", "maxNum", "", "getMaxNum", "()I", "setMaxNum", "(I)V", "requestCode", "getRequestCode", "setRequestCode", "title", "getTitle", "setTitle", "troopEnterTitle", "getTroopEnterTitle", "setTroopEnterTitle", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public static final class FriendSelectParams implements Serializable {
        private boolean isMiniMode;
        private boolean isShowGuild;
        private boolean isSingle;
        private int maxNum = 9;
        private String title = "";
        private String finishText = "";
        private boolean isShowTroop = true;
        private String troopEnterTitle = "";
        private boolean isShowFriendFirst = true;
        private int requestCode = 1000;

        public final String getFinishText() {
            return this.finishText;
        }

        public final int getMaxNum() {
            return this.maxNum;
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getTroopEnterTitle() {
            return this.troopEnterTitle;
        }

        /* renamed from: isMiniMode, reason: from getter */
        public final boolean getIsMiniMode() {
            return this.isMiniMode;
        }

        /* renamed from: isShowFriendFirst, reason: from getter */
        public final boolean getIsShowFriendFirst() {
            return this.isShowFriendFirst;
        }

        /* renamed from: isShowGuild, reason: from getter */
        public final boolean getIsShowGuild() {
            return this.isShowGuild;
        }

        /* renamed from: isShowTroop, reason: from getter */
        public final boolean getIsShowTroop() {
            return this.isShowTroop;
        }

        /* renamed from: isSingle, reason: from getter */
        public final boolean getIsSingle() {
            return this.isSingle;
        }

        public final void setFinishText(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.finishText = str;
        }

        public final void setMaxNum(int i3) {
            this.maxNum = i3;
        }

        public final void setMiniMode(boolean z16) {
            this.isMiniMode = z16;
        }

        public final void setRequestCode(int i3) {
            this.requestCode = i3;
        }

        public final void setShowFriendFirst(boolean z16) {
            this.isShowFriendFirst = z16;
        }

        public final void setShowGuild(boolean z16) {
            this.isShowGuild = z16;
        }

        public final void setShowTroop(boolean z16) {
            this.isShowTroop = z16;
        }

        public final void setSingle(boolean z16) {
            this.isSingle = z16;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final void setTroopEnterTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.troopEnterTitle = str;
        }
    }

    ShareApi() {
    }

    public final Intent b(Activity activity, ArkShareParams arkShareParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(arkShareParams, "arkShareParams");
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        a(arkShareParams, intent, activity);
        return intent;
    }

    public final Intent c(Activity activity, ArkShareParams arkShareParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(arkShareParams, "arkShareParams");
        Intent intent = new Intent(activity, (Class<?>) DirectForwardActivity.class);
        intent.putExtra("toUin", arkShareParams.getToUin().toString());
        intent.putExtra("uinType", arkShareParams.getToUinType());
        intent.putExtra("nickName", arkShareParams.getNickName());
        a(arkShareParams, intent, activity);
        return intent;
    }

    public final void e(Activity activity, ArkShareParams arkShareParams, int requestCode, ResultReceiver resultReceiver, boolean isNeedReturnSelectedList, boolean isNeedBottomSheetPreview) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(arkShareParams, "arkShareParams");
        Intent b16 = b(activity, arkShareParams);
        if (resultReceiver != null) {
            d(b16, resultReceiver);
        }
        b16.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        if (isNeedBottomSheetPreview) {
            b16.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
        }
        if (isNeedReturnSelectedList) {
            b16.putExtra("key_is_need_return_selected_list", true);
        }
        activity.startActivityForResult(b16, requestCode);
    }

    public final void g(Activity activity, ArkShareParams arkShareParams, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(arkShareParams, "arkShareParams");
        activity.startActivityForResult(c(activity, arkShareParams), requestCode);
    }

    public final void h(Activity activity, FriendSelectParams params) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        Intent intent = new Intent(activity, (Class<?>) ForwardFriendListActivity.class);
        intent.putExtra("only_single_selection", params.getIsSingle());
        intent.putExtra("key_forward_is_show_troop", params.getIsShowTroop());
        if (!TextUtils.isEmpty(params.getTroopEnterTitle())) {
            intent.putExtra("extra_troop_entrance_title", params.getTroopEnterTitle());
        }
        intent.putExtra("key_forward_is_show_guild", params.getIsShowGuild());
        intent.putExtra("extra_mini_mode", params.getIsMiniMode());
        intent.putExtra("extra_show_friend_first", params.getIsShowFriendFirst());
        intent.putExtra("extra_max_num", params.getMaxNum());
        if (!TextUtils.isEmpty(params.getTitle())) {
            intent.putExtra("extra_forward_title", params.getTitle());
        }
        if (!TextUtils.isEmpty(params.getFinishText())) {
            intent.putExtra("extra_select_finish_text", params.getFinishText());
        }
        intent.putExtra("extra_choose_friend", 9);
        intent.putExtra("call_by_forward", false);
        activity.startActivityForResult(intent, params.getRequestCode());
    }

    private final void a(ArkShareParams arkShareParams, Intent intent, Activity activity) {
        boolean contains$default;
        String replace$default;
        String arkJson = arkShareParams.getArkJson();
        if (arkJson == null || arkJson.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(arkShareParams.getArkJson());
            String optString = jSONObject.optString("app");
            String optString2 = jSONObject.optString("ver");
            String optString3 = jSONObject.optString("view");
            String metaList = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
            String optString4 = jSONObject.optString("prompt");
            String optString5 = jSONObject.optString(DownloadInfo.spKey_Config);
            String optString6 = jSONObject.optString("desc");
            String optString7 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
            intent.putExtra("forward_ark_app_name", optString);
            intent.putExtra("forward_ark_app_view", optString3);
            intent.putExtra("forward_ark_app_ver", optString2);
            intent.putExtra("forward_ark_app_prompt", optString4);
            intent.putExtra("forward_ark_app_meta", metaList);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString5);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, optString6);
            intent.putExtra("forward_ark_biz_src", optString7);
            if (!TextUtils.isEmpty(metaList)) {
                Intrinsics.checkNotNullExpressionValue(metaList, "metaList");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) metaList, (CharSequence) "\"isAIO\":1", false, 2, (Object) null);
                if (contains$default) {
                    replace$default = StringsKt__StringsJVMKt.replace$default(metaList, "\"isAIO\":1", "\"isAIO\":0", false, 4, (Object) null);
                    metaList = replace$default;
                }
            }
            intent.putExtras(QQCustomArkDialog.b.a(optString, optString3, optString7, optString2, metaList, activity.getResources().getDisplayMetrics().scaledDensity, null, null));
        } catch (JSONException e16) {
            e16.printStackTrace();
            QLog.d("ShareApi", 1, "getArkIntent  exception message: " + e16.getMessage());
        }
        intent.putExtra("forward_type", arkShareParams.getForwardType());
        String appID = arkShareParams.getAppID();
        if (!(appID == null || appID.length() == 0)) {
            intent.putExtra("req_share_id", Long.parseLong(arkShareParams.getAppID()));
        }
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, arkShareParams.getReqType());
        intent.putExtra("is_ark_display_share", true);
    }

    public final void d(Intent intent, ResultReceiver resultReceiver) {
        if (intent == null) {
            QLog.w("ShareApi", 1, "[registerForwardResultReceiver] intent should not be null.");
        } else {
            intent.putExtra("PARAM_ActivityResultReceiver", resultReceiver);
        }
    }
}
