package com.tencent.timi.game.liveroom.impl.room.userlevel;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CornerImageView extends AppCompatImageView {

    /* renamed from: m, reason: collision with root package name */
    ViewOutlineProvider f378570m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(new Rect(0, 0, CornerImageView.this.getWidth(), CornerImageView.this.getHeight()), x.c(CornerImageView.this.getContext(), 10.0f));
        }
    }

    public CornerImageView(Context context) {
        this(context, null);
    }

    public CornerImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CornerImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a aVar = new a();
        this.f378570m = aVar;
        setOutlineProvider(aVar);
        setClipToOutline(true);
    }
}
