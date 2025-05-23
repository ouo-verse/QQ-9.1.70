package com.tencent.mobileqq.minigame.va.util;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.va.MiniGameDiffPatchInfo;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004JV\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/util/DiffPatchUtil;", "", "()V", "DIFF_FROM_DOWNLOAD", "", "DIFF_FROM_INSTALL", "TAG", "diffPatchInfo2Json", "info", "Lcom/tencent/mobileqq/minigame/va/MiniBoxDiffPatchInfo;", "json2DiffPatchInfo", "jsonString", "preloadDiffPatch", "", "reportBeginPatch", "data", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadData;", "from", "reportDiffPatchResult", "errorCode", "errorMessage", "diffPatchCost", "", "md5CheckCost", "diffPatchFinishFileLength", "diffPatchConfigFileLength", "isStartOnForeground", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class DiffPatchUtil {
    public static final String DIFF_FROM_DOWNLOAD = "1";
    public static final String DIFF_FROM_INSTALL = "2";
    public static final DiffPatchUtil INSTANCE = new DiffPatchUtil();
    private static final String TAG = "MiniGameVADiffPatchUtil";

    DiffPatchUtil() {
    }

    public final String diffPatchInfo2Json(MiniGameDiffPatchInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("diff_patch_cdn_url", info.getDiffPatchUrl());
            jSONObject.put("diff_patch_data_size", info.getPatchSize());
            jSONObject.put("diff_patch_md5", info.getPatchMd5());
            jSONObject.put("base_version_id", info.getBaseVersionName());
            jSONObject.put("new_version_id", info.getNewVersionName());
            jSONObject.put("new_apk_md5", info.getNewMd5());
            jSONObject.put("new_apk_data_size", info.getNewApkDataSize());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            return jSONObject2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "diffPatchInfo2Json: exception.", e16);
            return "";
        }
    }

    public final void reportBeginPatch(MiniGameDownloadData data, String from) {
        String str;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(from, "from");
        if (com.tencent.mobileqq.qmethodmonitor.a.a(BaseApplication.getContext())) {
            str = "1";
        } else {
            str = "2";
        }
        String gameId = data.getGameId();
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("ext3", from);
        MiniGameDiffPatchInfo diffPatchInfo = data.getDiffPatchInfo();
        String baseVersionName = diffPatchInfo != null ? diffPatchInfo.getBaseVersionName() : null;
        if (baseVersionName == null) {
            baseVersionName = "";
        }
        pairArr[1] = TuplesKt.to("ext7", baseVersionName);
        MiniGameDiffPatchInfo diffPatchInfo2 = data.getDiffPatchInfo();
        String newVersionName = diffPatchInfo2 != null ? diffPatchInfo2.getNewVersionName() : null;
        pairArr[2] = TuplesKt.to("ext8", newVersionName != null ? newVersionName : "");
        pairArr[3] = TuplesKt.to("ext9", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989562", "18", gameId, mutableMapOf);
    }

    public final void preloadDiffPatch() {
        QLog.i(TAG, 1, "start preloadDiffPatch");
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).preloadHDiffPatchSo(new IZPlanApi.c() { // from class: com.tencent.mobileqq.minigame.va.util.DiffPatchUtil$preloadDiffPatch$1
            @Override // com.tencent.mobileqq.zplan.api.IZPlanApi.c
            public void onLoaded(boolean isSuccess, int code, String msg2) {
                QLog.i("MiniGameVADiffPatchUtil", 1, "preloadDiffPatch onLoaded, isSuccess=" + isSuccess + " code:" + code + " msg:" + msg2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MiniGameDiffPatchInfo json2DiffPatchInfo(String jsonString) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (jsonString == null || jsonString.length() == 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonString);
            String optString = jSONObject.optString("diff_patch_cdn_url");
            long optLong = jSONObject.optLong("diff_patch_data_size");
            String optString2 = jSONObject.optString("diff_patch_md5");
            String optString3 = jSONObject.optString("base_version_id");
            String optString4 = jSONObject.optString("new_version_id");
            String optString5 = jSONObject.optString("new_apk_md5");
            long optLong2 = jSONObject.optLong("new_apk_data_size");
            if (optString != null && optString.length() != 0) {
                z16 = false;
                if (!z16 && optLong > 0) {
                    if (optString2 != null && optString2.length() != 0) {
                        z17 = false;
                        if (!z17) {
                            if (optString3 != null && optString3.length() != 0) {
                                z18 = false;
                                if (!z18) {
                                    if (optString4 != null && optString4.length() != 0) {
                                        z19 = false;
                                        if (!z19) {
                                            if (!(optString5 == null || optString5.length() == 0) && optLong2 > 0) {
                                                MiniGameDiffPatchInfo miniGameDiffPatchInfo = new MiniGameDiffPatchInfo();
                                                miniGameDiffPatchInfo.setDiffPatchUrl(optString);
                                                miniGameDiffPatchInfo.setPatchSize(optLong);
                                                miniGameDiffPatchInfo.setPatchMd5(optString2);
                                                miniGameDiffPatchInfo.setBaseVersionName(optString3);
                                                miniGameDiffPatchInfo.setNewVersionName(optString4);
                                                miniGameDiffPatchInfo.setNewMd5(optString5);
                                                miniGameDiffPatchInfo.setNewApkDataSize(optLong2);
                                                return miniGameDiffPatchInfo;
                                            }
                                        }
                                    }
                                    z19 = true;
                                    if (!z19) {
                                    }
                                }
                            }
                            z18 = true;
                            if (!z18) {
                            }
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                }
                QLog.e(TAG, 1, "diff patch info is not valid, data=" + jsonString);
                return null;
            }
            z16 = true;
            if (!z16) {
                if (optString2 != null) {
                    z17 = false;
                    if (!z17) {
                    }
                }
                z17 = true;
                if (!z17) {
                }
            }
            QLog.e(TAG, 1, "diff patch info is not valid, data=" + jsonString);
            return null;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "json2DiffPatchInfo: exception, json=" + jsonString, e16);
            return null;
        }
    }

    public final void reportDiffPatchResult(MiniGameDownloadData data, String errorCode, String errorMessage, long diffPatchCost, long md5CheckCost, long diffPatchFinishFileLength, long diffPatchConfigFileLength, String from, boolean isStartOnForeground) {
        Object obj;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(from, "from");
        String str = "1";
        if (com.tencent.mobileqq.qmethodmonitor.a.a(BaseApplication.getContext())) {
            obj = "1";
        } else {
            obj = "2";
        }
        String gameId = data.getGameId();
        Pair[] pairArr = new Pair[12];
        MiniGameDiffPatchInfo diffPatchInfo = data.getDiffPatchInfo();
        String baseVersionName = diffPatchInfo != null ? diffPatchInfo.getBaseVersionName() : null;
        if (baseVersionName == null) {
            baseVersionName = "";
        }
        pairArr[0] = TuplesKt.to("ext7", baseVersionName);
        MiniGameDiffPatchInfo diffPatchInfo2 = data.getDiffPatchInfo();
        String newVersionName = diffPatchInfo2 != null ? diffPatchInfo2.getNewVersionName() : null;
        if (newVersionName == null) {
            newVersionName = "";
        }
        pairArr[1] = TuplesKt.to("ext8", newVersionName);
        pairArr[2] = TuplesKt.to("ext2", errorCode);
        pairArr[3] = TuplesKt.to("ext3", from);
        pairArr[4] = TuplesKt.to("ext6", errorMessage == null ? "" : errorMessage);
        pairArr[5] = TuplesKt.to("ext46", String.valueOf(diffPatchCost));
        pairArr[6] = TuplesKt.to("ext45", String.valueOf(md5CheckCost));
        pairArr[7] = TuplesKt.to("ext9", obj);
        pairArr[8] = TuplesKt.to("ext13", String.valueOf(diffPatchFinishFileLength));
        pairArr[9] = TuplesKt.to("ext23", String.valueOf(diffPatchConfigFileLength));
        pairArr[10] = TuplesKt.to("ext16", String.valueOf(Thread.currentThread().getPriority()));
        if (!isStartOnForeground) {
            str = "2";
        }
        pairArr[11] = TuplesKt.to("ext17", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989563", "18", gameId, mutableMapOf);
    }
}
