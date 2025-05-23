package com.tencent.mobileqq.intervideo.now.dynamic;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqinterface.MiniAioInterface;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAioInterfaceImpl implements MiniAioInterface {

    /* renamed from: a, reason: collision with root package name */
    private MiniMsgUser f238340a;

    /* renamed from: b, reason: collision with root package name */
    private long f238341b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f238342c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f238343d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f238344e = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f238345f = -1;

    Intent a(Activity activity) {
        Intent intent = new Intent();
        intent.setFlags(67108864);
        intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        if (this.f238343d == 10026) {
            intent.putExtra("banner_wording", "\u6b63\u5728\u6d4f\u89c8\u8bed\u97f3\u623f");
            intent.putExtra("banner_iconIdx", 13);
        } else if (this.f238342c == 10001) {
            intent.putExtra("banner_wording", "\u6b63\u5728\u6d4f\u89c8NOW\u4ea4\u53cb");
            intent.putExtra("banner_iconIdx", 13);
        } else {
            intent.putExtra("banner_wording", "\u6b63\u5728\u6d4f\u89c8NOW\u76f4\u64ad");
            intent.putExtra("banner_iconIdx", 14);
        }
        intent.putExtra("banner_businessCategory", "NOW");
        intent.putExtra("banner_activityName", JumpActivity.class);
        intent.putExtra("banner_plguinType", 1);
        intent.putExtra("banner_pluginProxyActivityName", activity.getClass().getName());
        Intent intent2 = new Intent(activity, (Class<?>) JumpActivity.class);
        intent2.setData(Uri.parse(String.format("nowmqqapi://now/openroom?src_type=app&version=1&bid=88&roomid=%d&fromid=%d&roomtype=%d", Long.valueOf(this.f238341b), Integer.valueOf(this.f238343d), Integer.valueOf(this.f238342c))));
        intent2.addFlags(268435456);
        intent.putExtra("banner_pendingIntent", PendingIntent.getActivities(activity, 0, new Intent[]{intent2}, 201326592));
        return intent;
    }

    protected MiniMsgUserParam b(Activity activity) {
        int i3 = activity.getApplication().getResources().getDisplayMetrics().widthPixels;
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
        int dimensionPixelSize = i3 - (activity.getApplication().getResources().getDimensionPixelSize(R.dimen.f159144wq) * 4);
        int dpToPx = dimensionPixelSize - ViewUtils.dpToPx(47.0f);
        int i16 = this.f238344e;
        if (i16 != -1) {
            dpToPx = dimensionPixelSize - i16;
        }
        int dip2px = ViewUtils.dip2px(7.0f) + statusBarHeight;
        int i17 = this.f238345f;
        if (i17 != -1) {
            dip2px = statusBarHeight + i17;
        }
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = 11;
        miniMsgUserParam.accessType = 0;
        miniMsgUserParam.entryType = 1;
        miniMsgUserParam.positionX = dpToPx;
        miniMsgUserParam.positionY = dip2px;
        miniMsgUserParam.filterMsgType = 1;
        miniMsgUserParam.backConversationIntent = a(activity);
        if (this.f238343d == 10026) {
            miniMsgUserParam.contentIconResId = R.drawable.ocb;
            miniMsgUserParam.colorType = 2;
        } else {
            miniMsgUserParam.colorType = 1;
        }
        return miniMsgUserParam;
    }

    @Override // com.tencent.qqinterface.MiniAioInterface
    public void onBackground() {
        this.f238340a.onBackground();
    }

    @Override // com.tencent.qqinterface.MiniAioInterface
    public void onCreate(Context context, Bundle bundle) {
        Activity activity = (Activity) ((ContextWrapper) context).getBaseContext();
        this.f238341b = bundle.getLong("roomid");
        this.f238342c = bundle.getInt("roomType");
        this.f238343d = bundle.getInt("fromid", 10001);
        this.f238344e = bundle.getInt("offsetX", -1);
        this.f238345f = bundle.getInt("offsetY", -1);
        MiniMsgUser miniMsgUser = new MiniMsgUser(activity, b(activity));
        this.f238340a = miniMsgUser;
        miniMsgUser.showEntry();
    }

    @Override // com.tencent.qqinterface.MiniAioInterface
    public void onDestroy() {
        this.f238340a.destroy();
    }

    @Override // com.tencent.qqinterface.MiniAioInterface
    public void onForeground() {
        this.f238340a.onForeground();
    }

    @Override // com.tencent.qqinterface.MiniAioInterface
    public void showEntry(boolean z16) {
        if (z16) {
            this.f238340a.showEntry();
        } else {
            this.f238340a.hideEntry();
        }
    }
}
