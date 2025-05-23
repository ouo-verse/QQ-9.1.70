package com.tencent.mobileqq.guild.vas.panel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.t;
import com.tencent.mobileqq.guild.vas.panel.b;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GroupGiftItem;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class a implements b, Application.ActivityLifecycleCallbacks {

    /* renamed from: d, reason: collision with root package name */
    protected final t f235731d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f235732e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f235733f;

    /* renamed from: h, reason: collision with root package name */
    protected String f235734h;

    /* renamed from: i, reason: collision with root package name */
    protected WeakReference<Activity> f235735i;

    public a(t tVar) {
        this.f235731d = tVar;
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void g(Activity activity, List<giftList$GroupGiftItem> list, b.a aVar, long j3) {
        this.f235735i = new WeakReference<>(activity);
        i(activity);
    }

    public void h() {
        if (this.f235731d.getGiftPanelAction() != null) {
            this.f235731d.getGiftPanelAction().b();
        }
    }

    private void i(Context context) {
        this.f235734h = null;
        if (context != null) {
            this.f235732e.setText(context.getText(R.string.f146100t_));
        }
        this.f235733f.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void d(String str, String str2, String str3, Drawable drawable) {
        if (str2 == null || str3 == null || drawable == null) {
            return;
        }
        this.f235734h = str2;
        this.f235732e.setText(str3);
        this.f235733f.setVisibility(0);
        ImageView imageView = this.f235733f;
        if (imageView instanceof GuildUserAvatarView) {
            ((GuildUserAvatarView) imageView).setAvatarTinyId(str, this.f235734h);
        } else {
            imageView.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void onFreeGiftCountDownEnd() {
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void onFreeGiftCountDownStart() {
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void toastSendError() {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void toRechargePanel(String str) {
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void updateGiftPanel(List<giftList$GroupGiftItem> list) {
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void e(int i3, int i16) {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void updateCoins(long j3, String str) {
    }
}
