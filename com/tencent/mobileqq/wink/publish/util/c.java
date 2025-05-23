package com.tencent.mobileqq.wink.publish.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.qcircle.api.IQCircleImagePreviewUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.preview.WinkPreviewFragment;
import com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment;
import com.tencent.mobileqq.wink.publish.fs.activity.PublishPicPreviewFragment;
import com.tencent.mobileqq.winkpublish.common.WinkPublishEnvironment;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c {
    public static void a(Context context, String str, int i3, Bundle bundle) {
        QZoneHelper.forwardToMoodSelectLocation(c(context), str, i3, bundle);
    }

    public static String b(String str) {
        return ((IFriendNameService) WinkPublishEnvironment.getAppRuntime().getRuntimeService(IFriendNameService.class, "all")).getFriendNick(str);
    }

    public static Context c(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.getBaseContext() instanceof ContextWrapper) {
                return activity.getBaseContext();
            }
            return context;
        }
        return context;
    }

    public static int[] d(int i3, int i16) {
        return ((IQCircleImagePreviewUtil) QRoute.api(IQCircleImagePreviewUtil.class)).getTargetWidthAndHeight(i3, i16);
    }

    public static void e(Context context, boolean z16, int i3, int i16, ArrayList<String> arrayList, int i17) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, z16);
        bundle.putInt(ISelectMemberActivityConstants.PARAM_MIN, i3);
        bundle.putInt(ISelectMemberActivityConstants.PARAM_MAX, i16);
        bundle.putInt(ISelectMemberActivityConstants.PARAM_ENTRANCE, 41);
        if (arrayList != null) {
            bundle.putStringArrayList(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList);
        }
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult((Activity) c(context), bundle, i17);
    }

    public static void f(Context context, Intent intent, int i3) {
        Bundle extras = ((QQWinkActivity) context).getIntent().getExtras();
        Context c16 = c(context);
        intent.setClass(c16, QQWinkActivity.class);
        intent.putExtras(extras);
        intent.putExtra("public_fragment_class", WinkPreviewFragment.class.getName());
        ((Activity) c16).startActivityForResult(intent, i3);
    }

    public static void g(Context context, Intent intent, int i3) {
        Context c16 = c(context);
        intent.setClass(c16, QQWinkActivity.class);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        intent.putExtra("public_fragment_class", WinkCoverSelectFragment.class.getName());
        ((Activity) c16).startActivityForResult(intent, i3);
    }

    public static void h(Context context, Intent intent) {
        Context c16 = c(context);
        intent.setClass(c16, CompatPublicActivity.class);
        intent.putExtra("public_fragment_class", PublishPicPreviewFragment.class.getName());
        ((Activity) c16).startActivity(intent);
    }

    public static boolean i(String str) {
        return MimeHelper.validateVideoType(str);
    }
}
