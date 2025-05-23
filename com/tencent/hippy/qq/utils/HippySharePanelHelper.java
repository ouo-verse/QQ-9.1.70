package com.tencent.hippy.qq.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J<\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001a\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010'2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J)\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00152\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0002\u0010.JH\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004`\u00162\"\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015`\u0016H\u0002J$\u00101\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004`\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004`\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004`\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/tencent/hippy/qq/utils/HippySharePanelHelper;", "", "()V", "KEY_CLOSE", "", "KEY_COPY_LINK", "KEY_FORWARD", "KEY_QCIRCLE", "KEY_QFRIEND", "KEY_QZONE", "KEY_SAVE", "KEY_WECHAT", "KEY_WECHAT_", "KEY_WEIBO", "PARAM_KEY_ITEM_LIST", "PROMISE_KEY_ITEM", "PROMISE_TO_UIN", "PROMISE_UIN_TYPE", "TAG", "actionToOperateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "actionToPathMap", "actionToRecentMap", "operateToActionMap", "pathToActionMap", "recentToActionMap", "callbackClose", "", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "doShowSharePanel", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "showRecentList", "", "pathList", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "operateList", "handleItemClick", "item", "makePromiseInfo", "uinType", HippySharePanelHelper.PROMISE_TO_UIN, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "reverseMap", "map", "showSharePanel", "jsonParams", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class HippySharePanelHelper {

    @NotNull
    public static final HippySharePanelHelper INSTANCE;

    @NotNull
    private static final String KEY_CLOSE = "close";

    @NotNull
    private static final String KEY_COPY_LINK = "copy_link";

    @NotNull
    private static final String KEY_FORWARD = "forward";

    @NotNull
    private static final String KEY_QCIRCLE = "qcircle";

    @NotNull
    private static final String KEY_QFRIEND = "Qfriend";

    @NotNull
    private static final String KEY_QZONE = "Qzone";

    @NotNull
    private static final String KEY_SAVE = "save";

    @NotNull
    private static final String KEY_WECHAT = "wechat";

    @NotNull
    private static final String KEY_WECHAT_ = "wechat_";

    @NotNull
    private static final String KEY_WEIBO = "weibo";

    @NotNull
    private static final String PARAM_KEY_ITEM_LIST = "itemList";

    @NotNull
    private static final String PROMISE_KEY_ITEM = "item";

    @NotNull
    private static final String PROMISE_TO_UIN = "toUin";

    @NotNull
    private static final String PROMISE_UIN_TYPE = "uinType";

    @NotNull
    private static final String TAG = "HippySharePanelHelper";

    @NotNull
    private static final HashMap<Integer, String> actionToOperateMap;

    @NotNull
    private static final HashMap<Integer, String> actionToPathMap;

    @NotNull
    private static final HashMap<Integer, String> actionToRecentMap;

    @NotNull
    private static final HashMap<String, Integer> operateToActionMap;

    @NotNull
    private static final HashMap<String, Integer> pathToActionMap;

    @NotNull
    private static final HashMap<String, Integer> recentToActionMap;

    static {
        HippySharePanelHelper hippySharePanelHelper = new HippySharePanelHelper();
        INSTANCE = hippySharePanelHelper;
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(KEY_FORWARD, 72);
        recentToActionMap = hashMap;
        actionToRecentMap = hippySharePanelHelper.reverseMap(hashMap);
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        hashMap2.put(KEY_QFRIEND, 2);
        hashMap2.put("Qzone", 3);
        hashMap2.put("wechat", 9);
        hashMap2.put(KEY_WECHAT_, 10);
        hashMap2.put(KEY_WEIBO, 12);
        hashMap2.put("qcircle", 203);
        pathToActionMap = hashMap2;
        actionToPathMap = hippySharePanelHelper.reverseMap(hashMap2);
        HashMap<String, Integer> hashMap3 = new HashMap<>();
        hashMap3.put("save", 39);
        hashMap3.put("copy_link", 1);
        operateToActionMap = hashMap3;
        actionToOperateMap = hippySharePanelHelper.reverseMap(hashMap3);
    }

    HippySharePanelHelper() {
    }

    private final void callbackClose(Promise promise) {
        promise.resolve(makePromiseInfo("close", 0, ""));
    }

    private final void doShowSharePanel(Activity activity, boolean showRecentList, List<? extends ShareActionSheetBuilder.ActionSheetItem> pathList, List<? extends ShareActionSheetBuilder.ActionSheetItem> operateList, final Promise promise) {
        int i3;
        int i16;
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = activity;
        activity.getIntent().putExtra("big_brother_source_key", "biz_src_unknown");
        final ShareActionSheet create = ShareActionSheetFactory.create(param);
        int i17 = 0;
        if (showRecentList) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        if (!pathList.isEmpty()) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        if (!(!operateList.isEmpty())) {
            i17 = 8;
        }
        create.setRowVisibility(i3, i16, i17);
        if (showRecentList) {
            create.setIntentForStartForwardRecentActivity(new Intent());
        }
        create.setActionSheetItems(pathList, operateList);
        create.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.hippy.qq.utils.j
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                HippySharePanelHelper.doShowSharePanel$lambda$8$lambda$5(Promise.this, create, actionSheetItem, shareActionSheet);
            }
        });
        create.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.hippy.qq.utils.k
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                HippySharePanelHelper.doShowSharePanel$lambda$8$lambda$6(Promise.this, dialogInterface);
            }
        });
        create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.hippy.qq.utils.l
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                HippySharePanelHelper.doShowSharePanel$lambda$8$lambda$7(Promise.this, dialogInterface);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doShowSharePanel$lambda$8$lambda$5(Promise promise, ShareActionSheet shareActionSheet, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet2) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        INSTANCE.handleItemClick(actionSheetItem, promise);
        shareActionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doShowSharePanel$lambda$8$lambda$6(Promise promise, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        INSTANCE.callbackClose(promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doShowSharePanel$lambda$8$lambda$7(Promise promise, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        INSTANCE.callbackClose(promise);
    }

    private final void handleItemClick(ShareActionSheetBuilder.ActionSheetItem item, Promise promise) {
        String str;
        if (item == null) {
            return;
        }
        int i3 = item.action;
        HashMap<Integer, String> hashMap = actionToRecentMap;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            String str2 = hashMap.get(Integer.valueOf(i3));
            Intrinsics.checkNotNull(str2);
            str = str2;
        } else {
            HashMap<Integer, String> hashMap2 = actionToPathMap;
            if (hashMap2.containsKey(Integer.valueOf(i3))) {
                String str3 = hashMap2.get(Integer.valueOf(i3));
                Intrinsics.checkNotNull(str3);
                str = str3;
            } else {
                HashMap<Integer, String> hashMap3 = actionToOperateMap;
                if (hashMap3.containsKey(Integer.valueOf(i3))) {
                    String str4 = hashMap3.get(Integer.valueOf(i3));
                    Intrinsics.checkNotNull(str4);
                    str = str4;
                } else {
                    QLog.e(TAG, 1, "[handleItemClick] invalid item:");
                    str = "";
                }
            }
        }
        String makePromiseInfo = makePromiseInfo(str, Integer.valueOf(item.uinType), item.uin);
        promise.resolve(makePromiseInfo);
        QLog.i(TAG, 1, "[handleItemClick] promiseInfo:" + makePromiseInfo + ",action:" + i3);
    }

    private final String makePromiseInfo(String item, Integer uinType, String toUin) {
        int i3;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("item", item);
        if (Intrinsics.areEqual(KEY_FORWARD, item)) {
            if (uinType != null) {
                i3 = uinType.intValue();
            } else {
                i3 = 0;
            }
            jSONObject.put("uinType", i3);
            if (toUin == null) {
                toUin = "";
            }
            jSONObject.put(PROMISE_TO_UIN, toUin);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026   }\n        }.toString()");
        return jSONObject2;
    }

    private final HashMap<Integer, String> reverseMap(HashMap<String, Integer> map) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        Set<String> keySet = map.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "map.keys");
        for (String str : keySet) {
            Integer num = map.get(str);
            Intrinsics.checkNotNull(num);
            hashMap.put(num, str);
        }
        return hashMap;
    }

    public final void showSharePanel(@Nullable String jsonParams, @Nullable Promise promise, @Nullable Activity activity) {
        boolean z16;
        QLog.i(TAG, 1, "[showSharePanel] jsonParams:" + jsonParams);
        if (!TextUtils.isEmpty(jsonParams) && promise != null) {
            if (activity != null && !activity.isFinishing()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Intrinsics.checkNotNull(jsonParams);
                JSONArray optJSONArray = new JSONObject(jsonParams).optJSONArray("itemList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int length = optJSONArray.length();
                    boolean z17 = false;
                    for (int i3 = 0; i3 < length; i3++) {
                        Object obj = optJSONArray.get(i3);
                        if (obj instanceof String) {
                            HashMap<String, Integer> hashMap = pathToActionMap;
                            if (hashMap.containsKey(obj)) {
                                Integer num = hashMap.get(obj);
                                Intrinsics.checkNotNull(num);
                                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(num.intValue()));
                            }
                            HashMap<String, Integer> hashMap2 = operateToActionMap;
                            if (hashMap2.containsKey(obj)) {
                                Integer num2 = hashMap2.get(obj);
                                Intrinsics.checkNotNull(num2);
                                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(num2.intValue()));
                            }
                            if (Intrinsics.areEqual(KEY_FORWARD, obj)) {
                                z17 = true;
                            }
                        }
                    }
                    doShowSharePanel(activity, z17, arrayList, arrayList2, promise);
                }
            }
        }
    }
}
