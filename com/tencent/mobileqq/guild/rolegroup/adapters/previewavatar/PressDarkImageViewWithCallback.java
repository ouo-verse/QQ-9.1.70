package com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;

@TargetApi(14)
/* loaded from: classes14.dex */
public class PressDarkImageViewWithCallback extends GuildUserAvatarView {

    /* renamed from: d, reason: collision with root package name */
    private a f232293d;

    /* loaded from: classes14.dex */
    public interface a {
        boolean a(@Nullable Drawable drawable);

        void onStateChanged(boolean z16);
    }

    public PressDarkImageViewWithCallback(Context context) {
        this(context, null, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        a aVar = this.f232293d;
        if (aVar != null) {
            aVar.onStateChanged(isPressed());
        }
    }

    public void e(a aVar) {
        this.f232293d = aVar;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (this.f232293d.a(drawable)) {
            super.setImageDrawable(drawable);
        }
    }

    public PressDarkImageViewWithCallback(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressDarkImageViewWithCallback(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
