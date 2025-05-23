package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class bf extends MiniMsgUser {

    /* renamed from: d, reason: collision with root package name */
    String f292086d;

    /* renamed from: e, reason: collision with root package name */
    int f292087e;

    /* renamed from: f, reason: collision with root package name */
    String f292088f;

    /* renamed from: h, reason: collision with root package name */
    MiniMsgUserParam f292089h;

    /* renamed from: i, reason: collision with root package name */
    Activity f292090i;

    public bf(Activity activity, MiniMsgUserParam miniMsgUserParam, String str, int i3, String str2) {
        super(activity, miniMsgUserParam);
        this.f292086d = str;
        this.f292087e = i3;
        this.f292089h = miniMsgUserParam;
        this.f292090i = activity;
        this.f292088f = str2;
    }

    @Override // com.tencent.mobileqq.activity.miniaio.MiniMsgUser, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        MiniMsgUserParam miniMsgUserParam = this.f292089h;
        if (miniMsgUserParam != null) {
            MiniMsgUser.IMiniMsgActionCallback iMiniMsgActionCallback = miniMsgUserParam.actionCallback;
            if (iMiniMsgActionCallback != null) {
                iMiniMsgActionCallback.onOpenMiniAIOCallback();
            }
            String str = this.f292086d;
            int i3 = this.f292087e;
            if (i3 != -1 && !TextUtils.isEmpty(str)) {
                MiniChatActivity.Q2(this.f292090i, i3, str, this.f292088f);
                hideUnread();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.miniaio.MiniMsgUser
    public void updateUnreadCountSync(int i3) {
        super.updateUnreadCountSync(0);
    }
}
