package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.qqlive.playerinterface.IQAdPlayerView;
import pw2.n;

/* loaded from: classes19.dex */
public class QAdPlayerLayout extends QAdBasePlayerLayout {

    /* renamed from: h, reason: collision with root package name */
    private static String f303649h;

    /* renamed from: d, reason: collision with root package name */
    private IQAdPlayerView f303650d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.a f303651e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f303652f;

    public QAdPlayerLayout(@NonNull Context context) {
        super(context);
        this.f303652f = true;
        f(context);
    }

    private void f(Context context) {
        f303649h = QAdPlayerLayout.class.getSimpleName() + hashCode();
        this.f303650d = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.b.c(context, 1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, 0, 0, 0);
        addView(this.f303650d.getPlayerView(), layoutParams);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.QAdBasePlayerLayout, kt3.f
    public void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.a aVar) {
        if (aVar != null) {
            this.f303651e = aVar;
        }
    }

    @Override // kt3.f
    public void b(final boolean z16, @ColorInt final int i3) {
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.QAdPlayerLayout.1
            @Override // java.lang.Runnable
            public void run() {
                if (z16) {
                    QAdPlayerLayout.this.setBackgroundColor(i3);
                }
                QAdPlayerLayout.this.f303650d.setOpaqueInfo(true);
                QAdPlayerLayout.this.f303650d.getPlayerView().requestFocus();
            }
        });
    }

    @Override // kt3.f
    public IQAdPlayerView c() {
        return this.f303650d;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.QAdBasePlayerLayout
    public void d(boolean z16) {
        n.e(f303649h, "[notifyTextureView]QAdPlayerLayout \u8bbe\u7f6eTextureView" + z16);
        this.f303650d.a(z16);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        n.e(f303649h, "onSizeChanged: setVideoWidthAndHeight: w=" + i3 + ", h=" + i16 + ", mResizePlayerEnable=" + this.f303652f);
        if (i17 == 0 && i18 == 0 && this.f303650d != null && this.f303652f) {
            setVideoWidthAndHeight(i3, i16);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.f303651e) {
            this.f303651e = null;
        }
        super.removeView(view);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.QAdBasePlayerLayout
    public void setPlayerCallback(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a aVar) {
        this.f303650d.setPlayerCallback(aVar);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.QAdBasePlayerLayout
    public void setResizePlayerEnable(boolean z16) {
        n.e(f303649h, "[notifyTextureView]QAdPlayerLayout \u8bbe\u7f6eTextureView, setResizePlayerEnable" + z16);
        this.f303652f = z16;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.QAdBasePlayerLayout
    public void setVideoWidthAndHeight(int i3, int i16) {
        n.e(f303649h, "setVideoWidthAndHeight: width=" + i3 + ", height=" + i16);
        this.f303650d.setVideoWidthAndHeight(i3, i16);
    }

    public QAdPlayerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f303652f = true;
        f(context);
    }

    public QAdPlayerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f303652f = true;
        f(context);
    }
}
