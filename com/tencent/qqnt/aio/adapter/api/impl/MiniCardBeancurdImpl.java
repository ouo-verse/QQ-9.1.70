package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J0\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\b0\rj\b\u0012\u0004\u0012\u00020\b`\u000eH\u0016J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/MiniCardBeancurdImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IMiniCardBeancurd;", "Landroid/view/View;", "view", "", "setUIAlphaOnTouchListener", "Landroid/content/Context;", "context", "", "friendUin", "gotoQZoneUserHome", "", "position", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "originUrl", "gotoBigImagePreview", "content", "dataType", "resId", "defVal", "getResourceText", "actionId", "Landroid/graphics/drawable/BitmapDrawable;", "getSignActionEmoji", "gotoSignatureHistory", "jumpToQuestionListAndAnswer", "", "data", "Lorg/json/JSONObject;", "getSignFromRichStatus", "gotoProfileCard", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniCardBeancurdImpl implements IMiniCardBeancurd {
    private static final int QCIRCLE_DATA_TYPE = 3;
    private static final String TAG = "MiniCardBeancurdImpl";

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public String getResourceText(Context content, int dataType, int resId, String defVal) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(defVal, "defVal");
        if (dataType != 3) {
            return defVal;
        }
        String d16 = com.dataline.util.j.d(defVal);
        Intrinsics.checkNotNullExpressionValue(d16, "replaceToDynamicNameText(defVal)");
        return d16;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public BitmapDrawable getSignActionEmoji(Context context, int actionId) {
        int roundToInt;
        Intrinsics.checkNotNullParameter(context, "context");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return new BitmapDrawable();
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.STATUS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.richstatus.StatusManager");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), ((StatusManager) manager).K(actionId, 200));
        int f16 = BaseAIOUtils.f(12.0f, context.getResources());
        roundToInt = MathKt__MathJVMKt.roundToInt(((bitmapDrawable.getIntrinsicWidth() * 1.0f) / bitmapDrawable.getIntrinsicHeight()) * f16);
        bitmapDrawable.setBounds(0, 0, roundToInt, f16);
        return bitmapDrawable;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public JSONObject getSignFromRichStatus(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        RichStatus parseStatus = RichStatus.parseStatus(data);
        int i3 = parseStatus.actionId;
        String actionAndData = parseStatus.getActionAndData();
        String plainText = parseStatus.getPlainText();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("actionId", i3);
        jSONObject.put(IMiniCardBeancurd.SIGN_ACTION_DATA, actionAndData);
        jSONObject.put(IMiniCardBeancurd.SIGN_PLAIN_TEXT, plainText);
        return jSONObject;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public void gotoQZoneUserHome(Context context, String friendUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        QZoneHelper.forwardToUserHome(context, QZoneHelper.UserInfo.getInstance(), friendUin, 0, 0, 0);
        ReportController.o(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", "", "\u7a7a\u95f4");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public void jumpToQuestionListAndAnswer(Context context, String friendUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        if (context instanceof Activity) {
            AnonymousViewHelper.jumpToQuestionListAndAnswer((Activity) context, friendUin, 9);
        }
        ReportController.o(null, "dc00898", "", friendUin, "0X800B5BF", "0X800B5BF", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public void setUIAlphaOnTouchListener(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOnTouchListener(com.tencent.av.utils.ba.f77070d);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public void gotoBigImagePreview(Context context, int position, ArrayList<String> originUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        Intent intent = new Intent(context, (Class<?>) TroopAvatarWallPreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("index", position);
        bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, new ArrayList<>(originUrl));
        bundle.putBoolean("from_photo_wall", false);
        bundle.putBoolean("SHOW_MENU", true);
        bundle.putBoolean("IS_EDIT", false);
        bundle.putBoolean("is_use_path", true);
        bundle.putBoolean("is_show_action", true);
        bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, true);
        intent.putExtras(bundle);
        context.startActivity(intent);
        ReportController.o(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", "", "\u7cbe\u9009\u7167\u7247");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public void gotoProfileCard(Context context, String friendUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        AllInOne allInOne = new AllInOne(friendUin, 1);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 2);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 26);
        ProfileUtils.openProfileCard(context, allInOne);
        ReportController.o(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", "", "\u7a7a\u767d\u5904");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public void gotoSignatureHistory(Context context, String friendUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intent intent = new Intent(context, (Class<?>) PublicFragmentActivity.class);
        intent.putExtra("key_uin", friendUin);
        intent.putExtra("key_uin_name", "");
        intent.putExtra("key_open_via", "history-liaotian");
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
        ReportController.o(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", "", "\u4e2a\u6027\u7b7e\u540d");
    }
}
