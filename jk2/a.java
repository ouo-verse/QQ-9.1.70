package jk2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    public static void a(Activity activity, Uri uri) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.intent.extra.STREAM", uri);
        intent.putExtras(bundle);
        intent.putExtra("isFromShare", true);
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_IS_FROMJUMP, true);
        intent.setData(uri);
        intent.putExtra("sendMultiple", false);
        RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT);
    }
}
