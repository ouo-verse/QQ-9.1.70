package com.tencent.mobileqq.mini.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.DangerousPersonToastUtils;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.widget.MiniAppProfileCardView;
import com.tencent.mobileqq.minigame.report.ProfileCardReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniAppProfileCardItemView extends LinearLayout {
    private String mAppid;
    private Context mContext;
    private View mGapView;
    private ImageView mIconView;
    private boolean mIsOwner;
    private LayoutInflater mLayoutInflater;
    private TextView mNameView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.mini.widget.MiniAppProfileCardItemView$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ MiniAppProfileCardView.onItemClickListener val$listener;
        final /* synthetic */ int val$position;

        AnonymousClass1(MiniAppProfileCardView.onItemClickListener onitemclicklistener, int i3) {
            this.val$listener = onitemclicklistener;
            this.val$position = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MiniAppCmdUtil.getInstance().getAppInfoById(null, MiniAppProfileCardItemView.this.mAppid, "", "", new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.widget.MiniAppProfileCardItemView.1.1
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                    MiniAppInfo miniAppInfo;
                    final long optLong = jSONObject.optLong("retCode");
                    final String optString = jSONObject.optString("errMsg");
                    if (z16 && (miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data")) != null) {
                        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                        LaunchParam launchParam = new LaunchParam();
                        miniAppConfig.launchParam = launchParam;
                        launchParam.miniAppId = MiniAppProfileCardItemView.this.mAppid;
                        int i3 = MiniAppProfileCardItemView.this.mIsOwner ? 2062 : LaunchScene.LAUNCH_SCENE_PROFILE_GUEST_CARD;
                        miniAppConfig.launchParam.scene = i3;
                        if (miniAppInfo.isWxMiniApp()) {
                            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppIdWithCallback(MiniAppProfileCardItemView.this.mContext, miniAppInfo.appId, "", 2062, new com.tencent.mobileqq.wxmini.api.data.b() { // from class: com.tencent.mobileqq.mini.widget.MiniAppProfileCardItemView.1.1.1
                                @Override // com.tencent.mobileqq.wxmini.api.data.b
                                public void onCallback(boolean z17, Bundle bundle) {
                                    QLog.i("MiniAppProfileCardItemView wxa", 1, "click success:" + z17);
                                    if (z17) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        anonymousClass1.val$listener.onItemClick(anonymousClass1.val$position);
                                    }
                                }
                            });
                        } else {
                            MiniAppLauncher.launchAppByAppConfig((Activity) MiniAppProfileCardItemView.this.mContext, miniAppConfig, new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.mobileqq.mini.widget.MiniAppProfileCardItemView.1.1.2
                                @Override // android.os.ResultReceiver
                                protected void onReceiveResult(int i16, Bundle bundle) {
                                    super.onReceiveResult(i16, bundle);
                                    QLog.i("MiniAppProfileCardItemView", 1, "click resultCode:" + i16);
                                    if (i16 == 0) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        anonymousClass1.val$listener.onItemClick(anonymousClass1.val$position);
                                    }
                                }
                            });
                        }
                        ProfileCardReporter.reportMiniGameProfile(miniAppConfig, i3, true);
                        return;
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.widget.MiniAppProfileCardItemView.1.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            DangerousPersonToastUtils.openErrorToast(BaseApplication.getContext(), optLong, optString);
                        }
                    });
                }
            });
        }
    }

    public MiniAppProfileCardItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.mLayoutInflater = from;
        from.inflate(R.layout.cbn, (ViewGroup) this, true);
        this.mIconView = (ImageView) findViewById(R.id.ltq);
        this.mNameView = (TextView) findViewById(R.id.ltr);
        this.mGapView = findViewById(R.id.ltn);
    }

    public void setProfileType(boolean z16) {
        this.mIsOwner = z16;
    }

    public void setTextColor(ColorStateList colorStateList) {
        TextView textView = this.mNameView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public MiniAppProfileCardItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void setData(MiniAppInfo miniAppInfo, int i3, MiniAppProfileCardView.onItemClickListener onitemclicklistener) {
        if (miniAppInfo == null || TextUtils.isEmpty(miniAppInfo.iconUrl) || TextUtils.isEmpty(miniAppInfo.name) || TextUtils.isEmpty(miniAppInfo.appId)) {
            return;
        }
        View view = this.mGapView;
        if (view != null) {
            if (i3 == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            imageView.setImageDrawable(MiniAppUtils.getIcon(this.mContext, miniAppInfo.iconUrl, true));
        }
        TextView textView = this.mNameView;
        if (textView != null) {
            textView.setText(miniAppInfo.name);
        }
        this.mAppid = miniAppInfo.appId;
        setOnClickListener(new AnonymousClass1(onitemclicklistener, i3));
    }

    public void setTextColor(int i3) {
        TextView textView = this.mNameView;
        if (textView != null) {
            textView.setTextColor(i3);
        }
    }

    public MiniAppProfileCardItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init(context);
    }
}
