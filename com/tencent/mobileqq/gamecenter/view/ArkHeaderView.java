package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.view.a;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ArkHeaderView extends ArkAppView implements a {

    /* renamed from: i, reason: collision with root package name */
    private String f213451i;

    /* renamed from: m, reason: collision with root package name */
    private ArkAppContainer f213452m;

    public ArkHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void b(QQGameMsgInfo qQGameMsgInfo, Context context, int i3, String str) {
        this.f213452m = new ArkAppContainer();
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179557e = "2747277822";
        this.f213452m.h(qQGameMsgInfo.arkAppName, qQGameMsgInfo.arkAppView, "", qQGameMsgInfo.arkAppMinVersion, qQGameMsgInfo.arkMetaList, context.getResources().getDisplayMetrics().scaledDensity, sessionInfo);
        int f16 = BaseAIOUtils.f(350.0f, context.getResources());
        int i16 = f.f199484d;
        this.f213452m.setMaxSize(i16, f16);
        this.f213452m.setFixSize(i16, f16);
        setClipRadius(5.0f);
        a(this.f213452m, null);
        setVisibility(0);
        try {
            this.f213451i = qQGameMsgInfo.gameAppId;
        } catch (Throwable th5) {
            QLog.e("ArkHeaderView", 1, "parse meta error =" + th5.toString());
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onPause() {
        ArkAppContainer arkAppContainer = this.f213452m;
        if (arkAppContainer != null) {
            arkAppContainer.doOnEvent(0);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onResume() {
        ArkAppContainer arkAppContainer = this.f213452m;
        if (arkAppContainer != null) {
            arkAppContainer.doOnEvent(1);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onDestory() {
    }
}
