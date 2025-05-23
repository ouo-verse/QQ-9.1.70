package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMediaVoiceMicView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f229754d;

    public GuildMediaVoiceMicView(Context context) {
        super(context);
        this.f229754d = false;
        a();
    }

    private void a() {
        setImageResource(R.drawable.guild_item_icon_mic_off_dark);
    }

    private void b() {
        if (!this.f229754d) {
            setImageResource(R.drawable.guild_av_mic_off_btn_layer_dark);
            this.f229754d = true;
            if (QLog.isColorLevel()) {
                QLog.d("QGMC.VoiceMicView", 2, "set alpha bg drawable !");
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (QLog.isDevelopLevel()) {
            QLog.d("QGMC.VoiceMicView", 4, NodeProps.ON_ATTACHED_TO_WINDOW);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (QLog.isDevelopLevel()) {
            QLog.d("QGMC.VoiceMicView", 4, NodeProps.ON_DETACHED_FROM_WINDOW);
        }
    }

    public void setImageDrawable(Drawable drawable, boolean z16) {
        if (z16) {
            b();
            setImageDrawable(drawable);
        } else {
            setImageDrawable(drawable);
        }
    }

    public void setMicState(int i3) {
        if (i3 == 0) {
            setImageResource(R.drawable.guild_av_mic_off_btn_layer_dark);
        } else if (i3 == 1) {
            setImageResource(R.drawable.guild_av_mic_off_btn_layer_5d6064);
        } else if (i3 == 2) {
            setImageResource(R.drawable.guild_av_mic_off_btn_layer);
        }
    }

    public GuildMediaVoiceMicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f229754d = false;
        a();
    }

    public GuildMediaVoiceMicView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f229754d = false;
        a();
    }
}
