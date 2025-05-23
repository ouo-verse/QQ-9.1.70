package com.tencent.biz.pubaccount.weishi.share.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/share/action/b;", "Lcom/tencent/biz/pubaccount/weishi/share/action/a;", "Landroid/content/Context;", "context", "Lj10/a;", "shareParam", "", "d", "", "c", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "sheetItem", "a", "", "b", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public class b implements a {
    private final boolean d(Context context, j10.a shareParam) {
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return false;
        }
        Bundle a16 = k10.c.f411392a.a(shareParam != null ? shareParam.f409063a : null, shareParam != null ? Integer.valueOf(shareParam.f409064b) : null);
        if (a16 == null) {
            x.f("WSShare2QQFriendAction", "[share2QQFriend] arkInfoBundle is null!");
            return false;
        }
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        intent.putExtra("is_need_show_toast", false);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra("key_allow_multiple_forward_from_limit", false);
        intent.putExtra("forward_type", 56);
        intent.putExtra("app_name", HardCodeUtil.qqStr(R.string.vkp));
        intent.putExtra(AppConstants.Key.FORWARD_NT_FROM_AIO_MSG, true);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
        intent.putExtras(a16);
        activity.startActivity(intent);
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.share.action.a
    public boolean a(Context context, ShareActionSheetBuilder.ActionSheetItem sheetItem, j10.a shareParam) {
        boolean d16 = d(context, shareParam);
        if (d16) {
            c(shareParam);
        }
        return d16;
    }

    public int b() {
        return 1003019;
    }

    private final void c(j10.a shareParam) {
        if (shareParam != null) {
            WSPublicAccReport.getInstance().reportShareClick(shareParam.f409069g, b(), shareParam.f409067e, shareParam.f409068f, shareParam.f409063a, shareParam.f409071i);
        }
    }
}
