package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import s62.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J.\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u001c\u0010\u001a\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001fR\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010!R\u0016\u0010\u0019\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R0\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0)j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R0\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0)j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010,\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/share/f;", "Ls62/b$a;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Landroid/content/DialogInterface$OnCancelListener;", "Landroid/content/DialogInterface$OnDismissListener;", "", "b", "c", "", "id", "", "action", "e", "", "showRecentFriend", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "paths", "operations", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "f", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "d", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "shareActionSheet", "onItemClick", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "onCancel", "Z", "hasInit", "Ljava/lang/String;", "callbackId", h.F, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "Lcom/tencent/mobileqq/kandian/biz/share/e;", "i", "Lcom/tencent/mobileqq/kandian/biz/share/e;", "shareToComputerHelper", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashMap;", "idToActionMap", BdhLogUtil.LogTag.Tag_Conn, "actionToIdMap", "Ls62/b;", "plugin", "<init>", "(Ls62/b;)V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f extends b.a implements ShareActionSheet.OnItemClickListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final HashMap<Integer, String> actionToIdMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasInit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String callbackId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ShareActionSheet shareActionSheet;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private e shareToComputerHelper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Integer> idToActionMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(s62.b plugin) {
        super(plugin);
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.callbackId = "";
        this.idToActionMap = new HashMap<>();
        this.actionToIdMap = new HashMap<>();
    }

    private final void b() {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        WebViewPlugin.b bVar = getPlugin().mRuntime;
        if (bVar != null) {
            Activity a16 = getPlugin().mRuntime.a();
            param.context = a16;
            ShareActionSheet create = ShareActionSheetFactory.create(param);
            Intrinsics.checkNotNullExpressionValue(create, "create(param)");
            this.shareActionSheet = create;
            a16.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
            this.shareToComputerHelper = new e(bVar.b());
        }
        c();
    }

    private final void c() {
        e("Qfriend", 2);
        e("Qzone", 3);
        e("wechat", 9);
        e("wechat_", 10);
        e("weibo", 12);
        e("sys_browser", 4);
        e("sent_pc", 26);
        e("add_to_digest", 145);
        e("cancel_digest", 146);
        e("interest", 147);
        e("look_owner", 148);
        e("push_topics", 149);
        e("pull_black", 150);
        e("feedback", 151);
        e("colornote", 70);
        e("colornote_cancel", 82);
        e("save", 43);
        e("adjust_font", 7);
        e(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, 1);
        e("report", 11);
        e("aio_position", 54);
        e(QCircleDaTongConstant.ElementParamValue.COLLECT, 6);
        e(QCircleDaTongConstant.ElementParamValue.COLLECT_CANCEL, 84);
        e("stick", 96);
        e("unstick", 97);
        e("follow", 87);
        e(IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW, 32);
    }

    private final void e(String id5, int action) {
        this.idToActionMap.put(id5, Integer.valueOf(action));
        this.actionToIdMap.put(Integer.valueOf(action), id5);
    }

    private final ShareActionSheet f(boolean showRecentFriend, List<? extends ShareActionSheetBuilder.ActionSheetItem> paths, List<? extends ShareActionSheetBuilder.ActionSheetItem> operations) {
        Intent intent;
        WebViewPlugin.b bVar = getPlugin().mRuntime;
        Activity a16 = bVar != null ? bVar.a() : null;
        if (a16 != null && (intent = a16.getIntent()) != null) {
            intent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
        }
        ShareActionSheet shareActionSheet = this.shareActionSheet;
        if (shareActionSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
            shareActionSheet = null;
        }
        shareActionSheet.setActionSheetItems(paths, operations);
        ShareActionSheet shareActionSheet2 = this.shareActionSheet;
        if (shareActionSheet2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
            shareActionSheet2 = null;
        }
        shareActionSheet2.setItemClickListenerV2(this);
        ShareActionSheet shareActionSheet3 = this.shareActionSheet;
        if (shareActionSheet3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
            shareActionSheet3 = null;
        }
        shareActionSheet3.setCancelListener(this);
        ShareActionSheet shareActionSheet4 = this.shareActionSheet;
        if (shareActionSheet4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
            shareActionSheet4 = null;
        }
        shareActionSheet4.setOnDismissListener(this);
        ShareActionSheet shareActionSheet5 = this.shareActionSheet;
        if (shareActionSheet5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
            shareActionSheet5 = null;
        }
        shareActionSheet5.setIntentForStartForwardRecentActivity(new Intent());
        ShareActionSheet shareActionSheet6 = this.shareActionSheet;
        if (shareActionSheet6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
            shareActionSheet6 = null;
        }
        shareActionSheet6.setRowVisibility(showRecentFriend ? 0 : 8, 0, 0);
        ShareActionSheet shareActionSheet7 = this.shareActionSheet;
        if (shareActionSheet7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
            shareActionSheet7 = null;
        }
        shareActionSheet7.show();
        ShareActionSheet shareActionSheet8 = this.shareActionSheet;
        if (shareActionSheet8 != null) {
            return shareActionSheet8;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
        return null;
    }

    public void d(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        if (!this.hasInit) {
            this.hasInit = true;
            b();
        }
        JSONArray optJSONArray = json.optJSONArray("secondLineIcons");
        JSONArray optJSONArray2 = json.optJSONArray("thirdLineIcons");
        boolean optBoolean = json.optBoolean("needRecentFriend");
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Integer num = this.idToActionMap.get(optJSONArray.get(i3));
            if (num != null) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(num.intValue()));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int length2 = optJSONArray2.length();
        for (int i16 = 0; i16 < length2; i16++) {
            Integer num2 = this.idToActionMap.get(optJSONArray2.get(i16));
            if (num2 != null) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(num2.intValue()));
            }
        }
        String optString = json.optString("callback");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"callback\")");
        this.callbackId = optString;
        f(optBoolean, arrayList, arrayList2);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("id", 0);
        jSONObject.putOpt("shared", Boolean.FALSE);
        jSONObject.putOpt("toUin", 0L);
        jSONObject.putOpt("uinType", 0);
        getPlugin().callJs(this.callbackId, jSONObject.toString());
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("id", 0);
        jSONObject.putOpt("shared", Boolean.FALSE);
        jSONObject.putOpt("toUin", 0L);
        jSONObject.putOpt("uinType", 0);
        getPlugin().callJs(this.callbackId, jSONObject.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Long longOrNull;
        if (item != null) {
            JSONObject jSONObject = new JSONObject();
            String str = this.actionToIdMap.get(Integer.valueOf(item.action));
            if (str == null) {
                str = 0;
            }
            jSONObject.putOpt("id", str);
            jSONObject.putOpt("shared", Boolean.TRUE);
            String str2 = item.uin;
            long longValue = (str2 == null || longOrNull == null) ? 0L : longOrNull.longValue();
            jSONObject.putOpt("toUin", Long.valueOf(longValue));
            jSONObject.putOpt("uinType", Integer.valueOf(item.uinType));
            getPlugin().callJs(this.callbackId, jSONObject.toString());
            ShareActionSheet shareActionSheet2 = this.shareActionSheet;
            if (shareActionSheet2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
                shareActionSheet2 = null;
            }
            shareActionSheet2.dismiss();
        }
    }
}
