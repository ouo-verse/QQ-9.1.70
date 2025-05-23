package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.aio.data.AIOContact;
import com.tencent.biz.pubaccount.api.IPublicAccountReport;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOArkApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qzonehub.api.utils.IQZoneGroupAlbumArkUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J,\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOArkApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOArkApi;", "", "app", "view", "", "canReplyByFreesia", "Lcom/tencent/qqnt/aio/adapter/api/a;", "getArkPlatformConfig", "url", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/aio/adapter/api/b;", WadlProxyConsts.EXTRA_DATA, WadlProxyConsts.KEY_JUMP_URL, "", "jumpToPreViewImage", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOArkApiImpl implements IAIOArkApi {
    private static final String TAG = "TemMsg.AIOArkApiImpl";

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOArkApi
    public boolean canReplyByFreesia(String app, String view) {
        return ((IArkMsgReplyMgr) QRoute.api(IArkMsgReplyMgr.class)).canReplyByFreesia(app, view);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOArkApi
    public com.tencent.qqnt.aio.adapter.api.a getArkPlatformConfig() {
        d91.g arkPlatformConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkPlatformConfig();
        e91.g c16 = arkPlatformConfig != null ? arkPlatformConfig.c() : null;
        if (c16 == null) {
            QLog.w(TAG, 1, "loadFromFreesia failed");
            return null;
        }
        com.tencent.qqnt.aio.adapter.api.a aVar = new com.tencent.qqnt.aio.adapter.api.a();
        aVar.d(c16.f395983m.get("white"));
        aVar.c(c16.f395983m.get("black"));
        return aVar;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOArkApi
    public void jumpToPreViewImage(Activity activity, String url) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            QLog.e(TAG, 1, "jumpToPreViewImage but url is null");
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) TroopAvatarWallPreviewActivity.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(url);
        Bundle bundle = new Bundle();
        bundle.putInt("index", 0);
        bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayListOf);
        bundle.putBoolean("needBottomBar", false);
        bundle.putBoolean("IS_EDIT", false);
        bundle.putBoolean("is_use_path", true);
        bundle.putBoolean("is_show_action", true);
        bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, false);
        bundle.putBoolean("is_index_show_bottom", true);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x015f, code lost:
    
        if (r0 != false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x034b A[Catch: Exception -> 0x03b0, TRY_ENTER, TryCatch #0 {Exception -> 0x03b0, blocks: (B:84:0x0317, B:87:0x0323, B:105:0x034b, B:108:0x0352, B:119:0x02fd), top: B:118:0x02fd }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02f3 A[Catch: Exception -> 0x02d2, TRY_LEAVE, TryCatch #8 {Exception -> 0x02d2, blocks: (B:121:0x0200, B:122:0x0215, B:125:0x021e, B:127:0x0232, B:128:0x0257, B:136:0x025f, B:137:0x026e, B:139:0x0239, B:141:0x0241, B:144:0x0295, B:149:0x02a9, B:152:0x02c0, B:81:0x02f3, B:86:0x031d, B:89:0x033f, B:154:0x02b1, B:156:0x02d8), top: B:120:0x0200 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x031d A[Catch: Exception -> 0x02d2, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x02d2, blocks: (B:121:0x0200, B:122:0x0215, B:125:0x021e, B:127:0x0232, B:128:0x0257, B:136:0x025f, B:137:0x026e, B:139:0x0239, B:141:0x0241, B:144:0x0295, B:149:0x02a9, B:152:0x02c0, B:81:0x02f3, B:86:0x031d, B:89:0x033f, B:154:0x02b1, B:156:0x02d8), top: B:120:0x0200 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x033f A[Catch: Exception -> 0x02d2, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x02d2, blocks: (B:121:0x0200, B:122:0x0215, B:125:0x021e, B:127:0x0232, B:128:0x0257, B:136:0x025f, B:137:0x026e, B:139:0x0239, B:141:0x0241, B:144:0x0295, B:149:0x02a9, B:152:0x02c0, B:81:0x02f3, B:86:0x031d, B:89:0x033f, B:154:0x02b1, B:156:0x02d8), top: B:120:0x0200 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0372  */
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOArkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean jumpUrl(String url, MsgRecord msgRecord, Activity activity, com.tencent.qqnt.aio.adapter.api.b extraData) {
        String str;
        AIOContact aIOContact;
        String str2;
        boolean z16;
        boolean startsWith$default;
        String str3;
        String str4;
        int indexOf$default;
        JSONObject jSONObject;
        String str5;
        String str6;
        com.tencent.qqnt.msg.data.a parseArkMsgModelFromMsgRecord;
        boolean startsWith$default2;
        boolean startsWith$default3;
        String url2 = url;
        Intrinsics.checkNotNullParameter(url2, "url");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        String d16 = extraData.d() != null ? extraData.d() : "biz_src_jc_ark";
        if (activity instanceof BaseActivity) {
            AIOContact a16 = com.tencent.qqnt.aio.utils.a.f352276a.a((FragmentActivity) activity);
            if (a16 != null) {
                if (a16.e() == 103 && Intrinsics.areEqual(AdDownloadConstants.DOWNLOAD_SOURCE_AD, d16)) {
                    String sourceId = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(a16.j());
                    QLog.d(TAG, 1, "ArkSafe.OpenUrl set hsSourceID for " + a16.j() + ", input " + d16 + ", output " + sourceId);
                    str2 = sourceId;
                    aIOContact = a16;
                    str = url2;
                } else if (a16.e() == 2 && com.tencent.mobileqq.troop.utils.k.k(extraData.a(), url2)) {
                    url2 = com.tencent.mobileqq.troop.utils.k.h(a16.j(), url2);
                    Intrinsics.checkNotNullExpressionValue(url2, "getShareTroopRobotUrl(aioContact.peerUid, url)");
                }
            }
            aIOContact = a16;
            str2 = null;
            str = url2;
        } else {
            str = url2;
            aIOContact = null;
            str2 = null;
        }
        if (msgRecord != null) {
            ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportArkOpenUrl(extraData.a(), str, String.valueOf(msgRecord.senderUin));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("aio_information_type", 11);
        com.tencent.mobileqq.aio.utils.b.l("em_bas_message_bubble", hashMap);
        if (aIOContact != null && (aIOContact.e() == 103 || aIOContact.e() == 118)) {
            ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).publicAccountAIOMsgReport(118, Integer.valueOf(aIOContact.e()), msgRecord);
        }
        boolean z17 = false;
        try {
            try {
                try {
                    if (!((IArkAPIService) QRoute.api(IArkAPIService.class)).dispatchOpenURL(str, extraData.c(), extraData.e(), extraData.b(), extraData.a(), extraData.d())) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http://", false, 2, null);
                        if (!startsWith$default) {
                            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "https://", false, 2, null);
                            if (!startsWith$default2) {
                                if (extraData.b() == 0) {
                                    if (aIOContact != null && ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).handleHttpUrl(activity, str, Integer.valueOf(aIOContact.e()), extraData.d())) {
                                        return true;
                                    }
                                    com.tencent.mobileqq.utils.ax c16 = bi.c(ArkAppQQModuleBase.p(), activity, str);
                                    if (c16 != null) {
                                        c16.b();
                                    }
                                }
                                z17 = false;
                            }
                        }
                        try {
                            if (!TextUtils.isEmpty(extraData.c())) {
                                try {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(extraData.c());
                                        Iterator keys = jSONObject2.keys();
                                        Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
                                        boolean z18 = false;
                                        str4 = "";
                                        while (keys.hasNext()) {
                                            Object next = keys.next();
                                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                                            String str7 = (String) next;
                                            if (jSONObject2.get(str7) instanceof String) {
                                                str5 = jSONObject2.getString(str7);
                                                jSONObject = jSONObject2;
                                            } else if (jSONObject2.get(str7) instanceof Number) {
                                                Object obj = jSONObject2.get(str7);
                                                jSONObject = jSONObject2;
                                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
                                                str5 = ((Number) obj).toString();
                                            } else {
                                                jSONObject = jSONObject2;
                                                str5 = null;
                                            }
                                            if (TextUtils.isEmpty(str5)) {
                                                jSONObject2 = jSONObject;
                                            } else {
                                                if (z18) {
                                                    str4 = str4 + ContainerUtils.FIELD_DELIMITER;
                                                }
                                                str4 = str4 + str7 + ContainerUtils.KEY_VALUE_DELIMITER + str5;
                                                jSONObject2 = jSONObject;
                                                z18 = true;
                                            }
                                        }
                                    } catch (Exception e16) {
                                        e = e16;
                                        z17 = false;
                                        QLog.e(TAG, 1, "QQ_MODULE_API_OPENURL error = " + e.getMessage());
                                        return z17;
                                    }
                                } catch (JSONException e17) {
                                    e = e17;
                                    str3 = "";
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    str3 = "";
                                    try {
                                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 4, (Object) null);
                                        if (indexOf$default != -1) {
                                            str4 = ContainerUtils.FIELD_DELIMITER + str4;
                                        }
                                        str = str + str4;
                                    } catch (JSONException e18) {
                                        e = e18;
                                        QLog.e(TAG, 1, "jumpUrl failed for exception:" + e);
                                        str6 = str;
                                        if (aIOContact != null) {
                                        }
                                        com.tencent.mobileqq.ark.g.b(null, extraData.a(), "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                                        parseArkMsgModelFromMsgRecord = ArkMsgUtils.parseArkMsgModelFromMsgRecord(msgRecord);
                                        long c17 = com.tencent.open.agent.util.o.c(ArkMsgUtils.getAppIdFromMeta(parseArkMsgModelFromMsgRecord != null ? parseArkMsgModelFromMsgRecord.m() : str3));
                                        if (((IQZoneGroupAlbumArkUtil) QRoute.api(IQZoneGroupAlbumArkUtil.class)).isFromGroupAlbumArk(extraData.a(), extraData.d(), str6)) {
                                        }
                                        jq3.a.b(parseArkMsgModelFromMsgRecord, msgRecord);
                                        if (ArkMsgUtils.isFromSdkShare(parseArkMsgModelFromMsgRecord)) {
                                        }
                                        str = str6;
                                        z17 = z16;
                                        Log.d("ark.OpenUrl ", str);
                                        return z17;
                                    }
                                    str6 = str;
                                    if (aIOContact != null || aIOContact.e() != 103) {
                                        com.tencent.mobileqq.ark.g.b(null, extraData.a(), "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                                    }
                                    parseArkMsgModelFromMsgRecord = ArkMsgUtils.parseArkMsgModelFromMsgRecord(msgRecord);
                                    long c172 = com.tencent.open.agent.util.o.c(ArkMsgUtils.getAppIdFromMeta(parseArkMsgModelFromMsgRecord != null ? parseArkMsgModelFromMsgRecord.m() : str3));
                                    if (((IQZoneGroupAlbumArkUtil) QRoute.api(IQZoneGroupAlbumArkUtil.class)).isFromGroupAlbumArk(extraData.a(), extraData.d(), str6)) {
                                        ((IQZoneGroupAlbumArkUtil) QRoute.api(IQZoneGroupAlbumArkUtil.class)).handleGroupArkUrl(activity, str6);
                                        z16 = false;
                                    } else {
                                        z16 = false;
                                        try {
                                            a91.a.e(activity instanceof Context ? activity : null, str6, true, c172, msgRecord, d16, 0, extraData.a(), str2, extraData.d());
                                        } catch (Exception e19) {
                                            e = e19;
                                            z17 = z16;
                                            QLog.e(TAG, 1, "QQ_MODULE_API_OPENURL error = " + e.getMessage());
                                            return z17;
                                        }
                                    }
                                    jq3.a.b(parseArkMsgModelFromMsgRecord, msgRecord);
                                    if (ArkMsgUtils.isFromSdkShare(parseArkMsgModelFromMsgRecord)) {
                                        ReportController.o(null, "dc00898", "", "", "0X800A869", "0X800A869", 0, 0, c172 == 0 ? str3 : String.valueOf(c172), "", "", "");
                                    }
                                    str = str6;
                                    z17 = z16;
                                }
                            }
                            com.tencent.mobileqq.ark.g.b(null, extraData.a(), "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                            parseArkMsgModelFromMsgRecord = ArkMsgUtils.parseArkMsgModelFromMsgRecord(msgRecord);
                            long c1722 = com.tencent.open.agent.util.o.c(ArkMsgUtils.getAppIdFromMeta(parseArkMsgModelFromMsgRecord != null ? parseArkMsgModelFromMsgRecord.m() : str3));
                            if (((IQZoneGroupAlbumArkUtil) QRoute.api(IQZoneGroupAlbumArkUtil.class)).isFromGroupAlbumArk(extraData.a(), extraData.d(), str6)) {
                            }
                            jq3.a.b(parseArkMsgModelFromMsgRecord, msgRecord);
                            if (ArkMsgUtils.isFromSdkShare(parseArkMsgModelFromMsgRecord)) {
                            }
                            str = str6;
                            z17 = z16;
                        } catch (Exception e26) {
                            e = e26;
                            z16 = false;
                            z17 = z16;
                            QLog.e(TAG, 1, "QQ_MODULE_API_OPENURL error = " + e.getMessage());
                            return z17;
                        }
                        str3 = "";
                        str6 = str;
                        if (aIOContact != null) {
                        }
                    } else {
                        com.tencent.mobileqq.ark.g.b(null, extraData.a(), "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                        try {
                            if (!((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
                                if (!TextUtils.isEmpty(str)) {
                                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(str, "miniapp", false, 2, null);
                                }
                                z17 = true;
                            }
                            if (msgRecord != null) {
                                String appIdFromMeta = ArkMsgUtils.getAppIdFromMeta(ArkMsgUtils.getMetaFromArkMsgRecord(msgRecord));
                                if (appIdFromMeta == null) {
                                    appIdFromMeta = "";
                                }
                                if (Intrinsics.areEqual(appIdFromMeta, "") || new Regex("\\d+").matches(appIdFromMeta)) {
                                    ReportController.o(null, "dc00898", "", "", "0X800A86C", "0X800A86C", 0, 0, appIdFromMeta, "", "", "");
                                }
                            }
                            z17 = true;
                        } catch (Exception e27) {
                            e = e27;
                            z17 = true;
                            QLog.e(TAG, 1, "QQ_MODULE_API_OPENURL error = " + e.getMessage());
                            return z17;
                        }
                    }
                } catch (Exception e28) {
                    e = e28;
                    z17 = false;
                }
            } catch (Exception e29) {
                e = e29;
                z16 = false;
            }
        } catch (Exception e36) {
            e = e36;
        }
        try {
            Log.d("ark.OpenUrl ", str);
        } catch (Exception e37) {
            e = e37;
            QLog.e(TAG, 1, "QQ_MODULE_API_OPENURL error = " + e.getMessage());
            return z17;
        }
        return z17;
    }
}
