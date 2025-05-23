package ho;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.appcommon.AppClient;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.api.QZoneContant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J$\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bJ$\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\bJ\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015\u00a8\u0006\u001a"}, d2 = {"Lho/d;", "Lho/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "a", "", "uin", "nickName", "b", "groupId", "groupName", "g", "f", "actionUrl", "d", "Landroid/content/Context;", "context", "e", "", "from", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d implements a {
    public final void c(Activity activity, BusinessFeedData feedData, int from) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        CellFeedCommInfo feedCommInfo = feedData.getFeedCommInfo();
        String str = feedCommInfo.actionurl;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppClient.i(activity, str, feedCommInfo.appid, feedData.getFeedCommInfo().subid, from);
    }

    public final void d(Activity activity, String actionUrl) {
        if (TextUtils.isEmpty(actionUrl) || activity == null) {
            return;
        }
        AppClient.h(activity, actionUrl);
    }

    public final void e(Context context, String actionUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionUrl, "actionUrl");
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(actionUrl));
        intent.addFlags(268435456);
        if (TextUtils.isEmpty(actionUrl)) {
            return;
        }
        context.startActivity(intent);
    }

    public final void b(Activity activity, String uin, String nickName) {
        if (activity != null && !TextUtils.isEmpty(uin) && !TextUtils.isEmpty(nickName)) {
            MiniChatActivity.S2(activity, 0, uin, nickName, false, 1);
        } else {
            RFWLog.d("QZoneExternalNativeLauncher", RFWLog.USR, "launchMiniAio error");
        }
    }

    public final void f(Activity activity) {
        if (activity == null) {
            RFWLog.d("QZoneExternalNativeLauncher", RFWLog.USR, "launchSelectGroupMember error");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, QZoneConfigHelper.L());
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(activity, intent, QZoneContant.QZ_SEARCH_LOCAL_REQUEST_CODE);
    }

    public final void g(Activity activity, String groupId, String groupName) {
        if (activity != null && !TextUtils.isEmpty(groupId)) {
            Intent intent = new Intent();
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, true);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, QZoneConfigHelper.L());
            intent.putExtra("group_uin", groupId);
            intent.putExtra("group_name", groupName);
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(activity, intent, QZoneContant.QZ_SEARCH_LOCAL_REQUEST_CODE);
            return;
        }
        RFWLog.d("QZoneExternalNativeLauncher", RFWLog.USR, "launchSelectGroupMember error");
    }

    public final void a(Activity activity, BusinessFeedData feedData) {
        if (activity != null && feedData != null && feedData.getUser() != null) {
            User user = feedData.getUser();
            Intrinsics.checkNotNullExpressionValue(user, "feedData.user");
            b(activity, String.valueOf(user.uin), user.nickName);
            return;
        }
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        objArr[0] = "launchMiniAio error, feed data is null: " + (feedData == null);
        RFWLog.d("QZoneExternalNativeLauncher", i3, objArr);
    }
}
