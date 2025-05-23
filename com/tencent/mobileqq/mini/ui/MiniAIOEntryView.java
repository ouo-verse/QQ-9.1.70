package com.tencent.mobileqq.mini.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAIOEntryView extends MiniAIOEntranceProxy implements IMiniMsgUnreadCallback, MiniMsgUser.IMiniMsgActionCallback {
    private static final String TAG = "MiniAIOEntryView";
    private Activity activity;
    private MiniMsgUser mMiniMsgUser;
    private RelativeLayout miniAIOEntryView;
    private ImageView miniAIOIcon;
    private TextView miniAIOUnReadView;
    private String style;

    public MiniAIOEntryView(Context context, String str) {
        super(context);
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        }
        this.style = str;
        initAppBrandRuntime();
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void hide() {
        RelativeLayout relativeLayout = this.miniAIOEntryView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void hideUnread() {
        TextView textView = this.miniAIOUnReadView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void initAppBrandRuntime() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.s_, (ViewGroup) null);
        this.miniAIOEntryView = relativeLayout;
        this.miniAIOIcon = (ImageView) relativeLayout.findViewById(R.id.ews);
        this.miniAIOUnReadView = (TextView) this.miniAIOEntryView.findViewById(R.id.ewt);
        if ("black".equals(this.style)) {
            this.miniAIOIcon.setBackgroundResource(R.drawable.mini_msg_float_view_top_black);
        } else {
            this.miniAIOIcon.setBackgroundResource(R.drawable.mini_msg_float_view_top_white);
        }
        initMiniMsgUser();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 36.0f), DisplayUtil.dip2px(getContext(), 36.0f));
        layoutParams.topMargin = DisplayUtil.dip2px(getContext(), 9.0f);
        layoutParams.rightMargin = DisplayUtil.dip2px(getContext(), 12.5f);
        addView(this.miniAIOEntryView, layoutParams);
    }

    public void initMiniMsgUser() {
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = 27;
        miniMsgUserParam.accessType = 1;
        miniMsgUserParam.isNeedBackConversation = true;
        miniMsgUserParam.unreadCallback = this;
        miniMsgUserParam.actionCallback = this;
        miniMsgUserParam.entryView = this.miniAIOEntryView;
        miniMsgUserParam.unreadView = this.miniAIOUnReadView;
        miniMsgUserParam.filterMsgType = 1;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initMiniMsgUse");
        }
        Activity activity = this.activity;
        if (activity != null) {
            MiniMsgUser miniMsgUser = new MiniMsgUser(activity, miniMsgUserParam);
            this.mMiniMsgUser = miniMsgUser;
            miniMsgUser.showEntry();
            this.mMiniMsgUser.onForeground();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy
    public void onPause() {
        MiniMsgUser miniMsgUser = this.mMiniMsgUser;
        if (miniMsgUser != null) {
            miniMsgUser.hideEntry();
            this.mMiniMsgUser.onBackground();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy
    public void onResume() {
        MiniMsgUser miniMsgUser = this.mMiniMsgUser;
        if (miniMsgUser != null) {
            miniMsgUser.showEntry();
            this.mMiniMsgUser.onForeground();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy
    public void setMiniAIOStyle(String str) {
        if (this.miniAIOIcon == null) {
            return;
        }
        if ("black".equals(str)) {
            this.miniAIOIcon.setBackgroundResource(R.drawable.mini_msg_float_view_top_black);
        } else {
            this.miniAIOIcon.setBackgroundResource(R.drawable.mini_msg_float_view_top_white);
        }
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public boolean show(int i3) {
        RelativeLayout relativeLayout = this.miniAIOEntryView;
        if (relativeLayout == null) {
            return true;
        }
        relativeLayout.setVisibility(0);
        updateUnreadCount(i3, false);
        return true;
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void updateUnreadCount(int i3, boolean z16) {
        TextView textView = this.miniAIOUnReadView;
        if (textView == null) {
            return;
        }
        String valueOf = String.valueOf(i3);
        if (i3 > 99) {
            valueOf = "99+";
        }
        textView.setText(valueOf);
        if (z16) {
            return;
        }
        if (i3 <= 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void destroy() {
        this.miniAIOUnReadView = null;
        this.miniAIOEntryView = null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy
    public void onDestroy() {
        this.miniAIOUnReadView = null;
        this.miniAIOEntryView = null;
    }

    @Override // com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback
    public void onFromMiniAIOToAIO() {
    }

    @Override // com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback
    public void onGoToConversation() {
    }

    @Override // com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback
    public void onOpenMiniAIOCallback() {
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void updateOnBackFromMiniAIO(Bundle bundle) {
    }
}
