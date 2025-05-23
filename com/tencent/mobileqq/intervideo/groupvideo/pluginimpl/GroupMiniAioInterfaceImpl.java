package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.j;
import com.tencent.mobileqq.activity.home.impl.a;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.yiqikan.i;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.NewMiniAioInterface;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GroupMiniAioInterfaceImpl implements NewMiniAioInterface {
    private static final String TAG = "GroupMiniAioInterfaceImpl";
    private Activity mActivity;
    private i mMiniMsgUser;
    private long roomId = 0;
    private int roomType = 0;
    private int xPoint = 0;
    private int yPoint = 0;

    Intent getBackIntent() {
        PendingIntent pendingIntent;
        Intent intent = new Intent();
        intent.setFlags(67108864);
        intent.putExtra("tab_index", a.f183038a);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        intent.putExtra("banner_wording", HardCodeUtil.qqStr(R.string.n4s));
        intent.putExtra("banner_iconIdx", 13);
        intent.putExtra("banner_iconIdx", 14);
        intent.putExtra("banner_businessCategory", "GroupVideo");
        intent.putExtra("banner_activityName", JumpActivity.class);
        intent.putExtra("banner_plguinType", 1);
        intent.putExtra("banner_pluginProxyActivityName", this.mActivity.getClass().getName());
        Intent intent2 = new Intent(this.mActivity, (Class<?>) JumpActivity.class);
        intent2.setData(Uri.parse(String.format("nowmqqapi://now/openroom?src_type=app&version=1&bid=88&roomid=%d&fromid=10001&roomtype=%d", Long.valueOf(this.roomId), Integer.valueOf(this.roomType))));
        intent2.addFlags(268435456);
        try {
            pendingIntent = PendingIntent.getActivities(this.mActivity, 0, new Intent[]{intent2}, 201326592);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "PendingIntent getActivity error!", th5);
            pendingIntent = null;
        }
        if (pendingIntent != null) {
            intent.putExtra("banner_pendingIntent", pendingIntent);
        }
        return intent;
    }

    protected MiniMsgUserParam getMiniMsgUserParam() {
        int i3 = this.mActivity.getApplication().getResources().getDisplayMetrics().widthPixels;
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(this.mActivity);
        int dimensionPixelSize = this.mActivity.getApplication().getResources().getDimensionPixelSize(R.dimen.f159144wq);
        int i16 = this.xPoint;
        if (i16 == 0) {
            i16 = (i3 - (dimensionPixelSize * 4)) - ViewUtils.dpToPx(35.0f);
        }
        int i17 = this.yPoint;
        if (i17 == 0) {
            i17 = ViewUtils.dip2px(7.0f);
        }
        int i18 = statusBarHeight + i17;
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = 26;
        miniMsgUserParam.accessType = 0;
        miniMsgUserParam.entryType = 1;
        miniMsgUserParam.positionX = i16;
        miniMsgUserParam.positionY = i18;
        miniMsgUserParam.colorType = 1;
        miniMsgUserParam.filterMsgType = 1;
        miniMsgUserParam.backConversationIntent = getBackIntent();
        return miniMsgUserParam;
    }

    @Override // com.tencent.qqinterface.NewMiniAioInterface
    public void onBackground() {
        this.mMiniMsgUser.a();
    }

    @Override // com.tencent.qqinterface.NewMiniAioInterface
    public void onCreate(Context context, String str, String str2, long j3, int i3) {
        j.registerModule();
        TextUtils.isEmpty(str);
        Activity activity = (Activity) ((ContextWrapper) context).getBaseContext();
        this.mActivity = activity;
        this.roomId = j3;
        this.roomType = i3;
        this.mMiniMsgUser = new i(activity, str, str2, getMiniMsgUserParam());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.GroupMiniAioInterfaceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                GroupMiniAioInterfaceImpl.this.mMiniMsgUser.c();
            }
        });
    }

    @Override // com.tencent.qqinterface.NewMiniAioInterface
    public void onDestroy() {
        this.mMiniMsgUser.destroy();
    }

    @Override // com.tencent.qqinterface.NewMiniAioInterface
    public void onForeground() {
        this.mMiniMsgUser.b();
    }

    @Override // com.tencent.qqinterface.NewMiniAioInterface
    public void setPoint(int i3, int i16) {
        this.xPoint = i3;
        this.yPoint = i16;
    }
}
