package com.tencent.mobileqq.guild.live.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildQUILoadingImageView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildLiveNetLoadingView extends LinearLayout {
    public GuildLiveNetLoadingView(Context context) {
        this(context, null);
    }

    public GuildLiveNetLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildLiveNetLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        View.inflate(context, R.layout.ewy, this);
        setOrientation(0);
        setGravity(16);
        GuildQUILoadingImageView guildQUILoadingImageView = (GuildQUILoadingImageView) findViewById(R.id.wmp);
        if (guildQUILoadingImageView != null) {
            guildQUILoadingImageView.setLoadingType(1);
        }
    }
}
