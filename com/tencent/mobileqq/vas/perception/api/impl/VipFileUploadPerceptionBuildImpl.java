package com.tencent.mobileqq.vas.perception.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.VasNtMMKV;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.api.INtVipStatus;
import com.tencent.mobileqq.vas.api.IVas04586Report;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.perception.api.IVipFileUploadPerceptionBuild;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0002\u0011\u0012B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/perception/api/impl/VipFileUploadPerceptionBuildImpl;", "Lcom/tencent/mobileqq/vas/perception/api/IVipFileUploadPerceptionBuild;", "Lcom/tencent/qqnt/kernel/api/w;", "getMsgService", "", "peerUid", "", "chatType", "", "addMsgListener", "removeMsgListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "lastMsgListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "<init>", "()V", "Companion", "a", "b", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipFileUploadPerceptionBuildImpl implements IVipFileUploadPerceptionBuild {

    @NotNull
    private static final String HIPPY_PAY_URL = "mqqapi://kuikly/open?aid=mios.n.gw.gn_aiplus&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMTAzIn0%3D&version=1&kr_turbo_display=svip&src_type=web&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_pay&bundle_name=vas_qqvip_pay&pay_type=svip&business_type=svip&half_pay=1&modal_mode=1&month=1&policy_id=aiplus";

    @NotNull
    private static final String KEY_VAS_PERCEPTION_FILE_UPLOAD_OVER_1G = "vas_perception_file_upload_over_1g";

    @NotNull
    private static final String KEY_VAS_PERCEPTION_FILE_UPLOAD_OVER_LIMIT = "vas_perception_file_upload_over_limit";

    @NotNull
    private static final String OVER_1G_TEXT = "\u5f00\u901aSVIP\u4eab\u6700\u9ad84T/\u65e5";

    @NotNull
    private static final String OVER_LIMIT_TEXT = "\u53d1\u9001\u6587\u4ef6\u5df2\u8fbe\u4e0a\u9650\uff0c\u5f00\u901aSVIP\u4eab\u6700\u9ad84T/\u65e5";

    @NotNull
    private static final String OVER_VIP_LIMIT_TEXT = "\u4eca\u65e5\u6587\u4ef6\u53d1\u9001\u5bb9\u91cf\u5df2\u8fbe\u4e0a\u9650";

    @NotNull
    private static final String TAG = "VipFileUploadPerceptionBuildImpl";

    @NotNull
    private static final String UPGRADE_SVIP_TEXT = "\u4eca\u65e5\u6587\u4ef6\u53d1\u9001\u5bb9\u91cf\u5df2\u8fbe\u4e0a\u9650\uff0c\u63d0\u5347\u5bb9\u91cf";
    private static final int UPGRADE_SVIP_TEXT_END = 17;
    private static final int UPGRADE_SVIP_TEXT_START = 13;

    @NotNull
    private static final String UPGRADE_SVIP_URL = "mqqapi://kuikly/open?version=1&src_type=web&page_name=vas_qqvip_file_transfer&bundle_name=vas_qqvip_file_transfer&kr_turbo_display=1&kr_fast_json=on&trace_detail%3D%7B%5C%22appid%5C%22%3A%5C%22outside%5C%22%2C%5C%22page_id%5C%22%3A%5C%22103%5C%22%7D";
    private static final int _24H = 86400000;
    private static final long _M = 1048576;

    @Nullable
    private IKernelMsgListener lastMsgListener;

    @NotNull
    private static final UnitedProxy TOGGLE_SVIP_FILE_UPLOAD = ar.INSTANCE.a("shouyouye", "2024-07-08", "vas_aio_upgrade_svip_file_upload");

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u000e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0011H\u0002J\u001a\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/vas/perception/api/impl/VipFileUploadPerceptionBuildImpl$b;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "", "o", "", "from", "c", "b", "a", "", DomainData.DOMAIN_NAME, "l", "k", "key", "", "days", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Triple;", "g", "i", "j", tl.h.F, "d", "f", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "onRichMediaUploadComplete", "Ljava/lang/String;", "peerUid", "I", "chatType", "<init>", "(Ljava/lang/String;I)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IKernelMsgListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String peerUid;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int chatType;

        public b(@NotNull String peerUid, int i3) {
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            this.peerUid = peerUid;
            this.chatType = i3;
        }

        private final void a() {
            String str;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            Triple<String, Integer, Integer> g16 = g();
            String first = g16.getFirst();
            if (g16.getSecond().intValue() > 0) {
                str = first.subSequence(0, g16.getSecond().intValue()).toString();
            } else {
                str = "";
            }
            String substring = first.substring(g16.getSecond().intValue(), g16.getThird().intValue());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            com.tencent.qqnt.graytips.action.m mVar = new com.tencent.qqnt.graytips.action.m(d());
            LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(this.peerUid, this.chatType, 3002L, 0, false, false, null, 120, null);
            if (!TextUtils.isEmpty(str)) {
                LocalGrayTip.LocalGrayTipBuilder.i(localGrayTipBuilder, str, 0, 2, null);
            }
            LocalGrayTip m3 = localGrayTipBuilder.h(substring, mVar, 3).m();
            QRouteApi api = QRoute.api(INtGrayTipApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
            INtGrayTipApi.a.a((INtGrayTipApi) api, peekAppRuntime, m3, null, 4, null);
            VasNtMMKV.INSTANCE.getVipPerception().encodeLong(VipFileUploadPerceptionBuildImpl.KEY_VAS_PERCEPTION_FILE_UPLOAD_OVER_1G, System.currentTimeMillis());
            QLog.i(VipFileUploadPerceptionBuildImpl.TAG, 1, "addOver1GGrayTips: " + first);
        }

        private final void b() {
            c("novip_exp");
        }

        private final void c(String from) {
            String str;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            Triple<String, Integer, Integer> i3 = i();
            String first = i3.getFirst();
            if (i3.getSecond().intValue() > 0) {
                str = first.subSequence(0, i3.getSecond().intValue()).toString();
            } else {
                str = "";
            }
            String substring = first.substring(i3.getSecond().intValue(), i3.getThird().intValue());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            LocalGrayTip m3 = LocalGrayTip.LocalGrayTipBuilder.i(new LocalGrayTip.LocalGrayTipBuilder(this.peerUid, this.chatType, 3001L, 0, false, false, null, 120, null), str, 0, 2, null).h(substring, new com.tencent.qqnt.graytips.action.n(j()), 3).m();
            QRouteApi api = QRoute.api(INtGrayTipApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
            INtGrayTipApi.a.a((INtGrayTipApi) api, peekAppRuntime, m3, null, 4, null);
            VasNtMMKV.INSTANCE.getVipPerception().encodeLong("vas_perception_file_upload_over_limit_upgrade", System.currentTimeMillis());
            QLog.i(VipFileUploadPerceptionBuildImpl.TAG, 1, "addUpgradeGrayTips: " + first + " from:" + from);
        }

        private final String d() {
            String optString = VasNtToggle.VAS_UPLOAD_FILE_VIP_PERCEPTION_CONFIG.getJson().optString("hippy_pay_url", VipFileUploadPerceptionBuildImpl.HIPPY_PAY_URL);
            Intrinsics.checkNotNullExpressionValue(optString, "VAS_UPLOAD_FILE_VIP_PERC\u2026_pay_url\", HIPPY_PAY_URL)");
            return optString;
        }

        private final int e() {
            return VasNtToggle.VAS_UPLOAD_FILE_VIP_PERCEPTION_CONFIG.getJson().optInt("no_vip_tips_days", 7);
        }

        private final int f() {
            return VasNtToggle.VAS_UPLOAD_FILE_VIP_PERCEPTION_CONFIG.getJson().optInt("no_vip_tips_size", 1024);
        }

        private final Triple<String, Integer, Integer> g() {
            try {
                JSONObject jSONObject = VasNtToggle.VAS_UPLOAD_FILE_VIP_PERCEPTION_CONFIG.getJson().getJSONObject("over_1G");
                String optString = jSONObject.optString("text", VipFileUploadPerceptionBuildImpl.OVER_1G_TEXT);
                int optInt = jSONObject.optInt("start", 0);
                int optInt2 = jSONObject.optInt("end", optString.length());
                if (optInt2 > optString.length()) {
                    optInt2 = optString.length();
                }
                return new Triple<>(optString, Integer.valueOf(optInt), Integer.valueOf(optInt2));
            } catch (Exception unused) {
                return new Triple<>(VipFileUploadPerceptionBuildImpl.OVER_1G_TEXT, 0, 13);
            }
        }

        private final String h() {
            String optString = VasNtToggle.VAS_UPLOAD_FILE_VIP_PERCEPTION_CONFIG.getJson().optString("over_vip_limit", VipFileUploadPerceptionBuildImpl.OVER_VIP_LIMIT_TEXT);
            Intrinsics.checkNotNullExpressionValue(optString, "VAS_UPLOAD_FILE_VIP_PERC\u2026it\", OVER_VIP_LIMIT_TEXT)");
            return optString;
        }

        private final Triple<String, Integer, Integer> i() {
            try {
                JSONObject jSONObject = VipFileUploadPerceptionBuildImpl.TOGGLE_SVIP_FILE_UPLOAD.getJson().getJSONObject("upgrade");
                String string = jSONObject.getString("text");
                int optInt = jSONObject.optInt("start", 0);
                int optInt2 = jSONObject.optInt("end", string.length());
                if (optInt2 > string.length()) {
                    optInt2 = string.length();
                }
                return new Triple<>(string, Integer.valueOf(optInt), Integer.valueOf(optInt2));
            } catch (Exception unused) {
                return new Triple<>(VipFileUploadPerceptionBuildImpl.UPGRADE_SVIP_TEXT, 13, 17);
            }
        }

        private final String j() {
            try {
                String optString = VipFileUploadPerceptionBuildImpl.TOGGLE_SVIP_FILE_UPLOAD.getJson().getJSONObject("upgrade").optString("url", VipFileUploadPerceptionBuildImpl.UPGRADE_SVIP_URL);
                Intrinsics.checkNotNullExpressionValue(optString, "{\n                TOGGLE\u2026E_SVIP_URL)\n            }");
                return optString;
            } catch (Exception unused) {
                return VipFileUploadPerceptionBuildImpl.UPGRADE_SVIP_URL;
            }
        }

        private final boolean k() {
            return m(VipFileUploadPerceptionBuildImpl.KEY_VAS_PERCEPTION_FILE_UPLOAD_OVER_1G, e());
        }

        private final boolean l() {
            return !k();
        }

        private final boolean m(String key, int days) {
            long decodeLong = VasNtMMKV.INSTANCE.getVipPerception().decodeLong(key, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            QLog.i(VipFileUploadPerceptionBuildImpl.TAG, 1, "key:" + key + " isInNDays:" + decodeLong + " current:" + currentTimeMillis);
            long j3 = (long) 86400000;
            if (((int) (currentTimeMillis / j3)) - ((int) (decodeLong / j3)) < days) {
                return true;
            }
            return false;
        }

        private final boolean n() {
            if (!((INtVipStatus) QRoute.api(INtVipStatus.class)).isSVip() && !((INtVipStatus) QRoute.api(INtVipStatus.class)).isVip()) {
                return false;
            }
            return true;
        }

        private final void o() {
            QQToast.makeText(MobileQQ.sMobileQQ, 0, h(), 1).show();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
            ax.b(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
            ax.p(this, importOldDbMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
            ax.u(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
            ax.y(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
            ax.E(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncEnd() {
            ax.G(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncStart() {
            ax.H(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            ax.J(this, j3, contact, i3, i16, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.N(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.O(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaUploadComplete(@Nullable FileTransNotifyInfo notifyInfo) {
            long j3;
            ax.P(this, notifyInfo);
            if (notifyInfo == null) {
                return;
            }
            QLog.i(VipFileUploadPerceptionBuildImpl.TAG, 1, "fileErrCode:" + notifyInfo.fileErrCode + " sec:" + notifyInfo.fileSrvErrCode + " cmsg:" + notifyInfo.clientMsg + " smsg:" + notifyInfo.fileErrMsg);
            if (notifyInfo.fileErrCode == 2006023) {
                if (!n()) {
                    b();
                    return;
                } else if (VipFileUploadPerceptionBuildImpl.TOGGLE_SVIP_FILE_UPLOAD.isEnable(true)) {
                    c("vip");
                    return;
                } else {
                    o();
                    return;
                }
            }
            if (notifyInfo.fileSrvErrCode == -98010) {
                ((IVas04586Report) QRoute.api(IVas04586Report.class)).reportAction("qqviptrace21", "pg_aio", "", "", "toast", "", "4", 101, 0, 0, "", "", "");
                return;
            }
            try {
                Long l3 = notifyInfo.userUsedSpacePerDay;
                Intrinsics.checkNotNullExpressionValue(l3, "notifyInfo.userUsedSpacePerDay");
                j3 = l3.longValue();
            } catch (Exception e16) {
                QLog.i(VipFileUploadPerceptionBuildImpl.TAG, 1, "getUserUsedSpacePerDay error!!", e16);
                j3 = 0;
            }
            if (!n() && j3 >= f() * 1048576 && l()) {
                a();
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
            ax.S(this, i3, j3, j16, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            ax.Z(this, i3, j3, str);
        }
    }

    private final w getMsgService() {
        AppRuntime appRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return null;
        }
        return ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
    }

    @Override // com.tencent.mobileqq.vas.perception.api.IVipFileUploadPerceptionBuild
    public void addMsgListener(@NotNull String peerUid, int chatType) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        if (!VasNtToggle.VAS_UPLOAD_FILE_VIP_PERCEPTION_CONFIG.isEnable(true)) {
            return;
        }
        removeMsgListener();
        w msgService = getMsgService();
        if (msgService == null) {
            return;
        }
        b bVar = new b(peerUid, chatType);
        msgService.addMsgListener(bVar);
        this.lastMsgListener = bVar;
    }

    @Override // com.tencent.mobileqq.vas.perception.api.IVipFileUploadPerceptionBuild
    public void removeMsgListener() {
        if (!VasNtToggle.VAS_UPLOAD_FILE_VIP_PERCEPTION_CONFIG.isEnable(true)) {
            return;
        }
        IKernelMsgListener iKernelMsgListener = this.lastMsgListener;
        if (iKernelMsgListener != null) {
            w msgService = getMsgService();
            if (msgService == null) {
                return;
            } else {
                msgService.removeMsgListener(iKernelMsgListener);
            }
        }
        this.lastMsgListener = null;
    }
}
