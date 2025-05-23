package com.tencent.mobileqq.nearbypro.forward.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.nearbypro.forward.api.INearbyProForwardApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010JF\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/forward/api/impl/NearbyProForwardApiImpl;", "Lcom/tencent/mobileqq/nearbypro/forward/api/INearbyProForwardApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", QzoneIPCModule.RESULT_CODE, "", "multiSelect", "needTroop", "", "title", "troopTitle", "finishText", "", "openForwardSelectPage", "<init>", "()V", "Companion", "a", "qq_nearby_pro_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class NearbyProForwardApiImpl implements INearbyProForwardApi {
    public static final String TAG = "NearbyProForwardApiImpl";

    @Override // com.tencent.mobileqq.nearbypro.forward.api.INearbyProForwardApi
    public void openForwardSelectPage(Activity activity, int resultCode, boolean multiSelect, boolean needTroop, String title, String troopTitle, String finishText) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent(activity, (Class<?>) ForwardFriendListActivity.class);
        intent.putExtra("only_single_selection", !multiSelect);
        intent.putExtra("call_by_forward", false);
        intent.putExtra("extra_mini_mode", true);
        intent.putExtra("extra_show_friend_first", true);
        intent.putExtra("key_forward_is_show_troop", needTroop);
        intent.putExtra("extra_forward_title", title);
        intent.putExtra("extra_troop_entrance_title", troopTitle);
        intent.putExtra("extra_select_finish_text", finishText);
        intent.putExtra("key_forward_is_show_guild", false);
        intent.putExtra(AppConstants.Key.IS_SELECT_TROOP, true);
        intent.putExtra("extra_choose_friend", 9);
        activity.startActivityForResult(intent, resultCode);
    }
}
