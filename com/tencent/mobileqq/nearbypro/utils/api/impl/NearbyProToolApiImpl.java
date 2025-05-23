package com.tencent.mobileqq.nearbypro.utils.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.map.MapUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.nearbypro.map.poi.PoiMapPartFragment;
import com.tencent.mobileqq.nearbypro.utils.api.INearbyProToolApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.widget.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/api/impl/NearbyProToolApiImpl;", "Lcom/tencent/mobileqq/nearbypro/utils/api/INearbyProToolApi;", "Landroid/widget/TextView;", "textView", "", WidgetCacheConstellationData.NUM, "resId", "maxNum", "", "updateCustomNoteText", "Landroid/content/Context;", "context", "", "peerUid", "Landroid/content/Intent;", "getNotificationIntent", "getLocationMode", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", "launchLocationSelectPage", "<init>", "()V", "Companion", "a", "qq_nearby_pro_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class NearbyProToolApiImpl implements INearbyProToolApi {
    private static final String AIO_ACTION_NAME = "com.tencent.mobileqq.action.MAINACTIVITY";
    private static final String OPEN_AIO_SOURCE_PUSH = "21";

    @Override // com.tencent.mobileqq.nearbypro.utils.api.INearbyProToolApi
    public int getLocationMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MapUtils.d(context);
    }

    @Override // com.tencent.mobileqq.nearbypro.utils.api.INearbyProToolApi
    public Intent getNotificationIntent(Context context, String peerUid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intent intent = SplashActivity.getAliasIntent(context);
        intent.putExtra("key_peerId", peerUid);
        intent.putExtra("key_chat_type", 119);
        intent.putExtra("key_from", "21");
        intent.putExtra("key_nearby_pro_need_open_aio", true);
        intent.putExtra("key_nearby_pro_chat_open_source", 1);
        intent.setFlags(335544320);
        intent.setAction(AIO_ACTION_NAME);
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return intent;
    }

    @Override // com.tencent.mobileqq.nearbypro.utils.api.INearbyProToolApi
    public void launchLocationSelectPage(Activity activity, int requestCode) {
        QPublicFragmentActivity.startForResult(activity, new Intent(), (Class<? extends QPublicBaseFragment>) PoiMapPartFragment.class, requestCode);
    }

    @Override // com.tencent.mobileqq.nearbypro.utils.api.INearbyProToolApi
    public void updateCustomNoteText(TextView textView, int num, int resId, int maxNum) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        d.c(textView, 3, num, resId, maxNum, null);
    }
}
