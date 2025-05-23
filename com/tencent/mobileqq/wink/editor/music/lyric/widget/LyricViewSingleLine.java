package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes21.dex */
public class LyricViewSingleLine extends LyricView {
    public LyricViewSingleLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.layout.i5e, this);
        this.f321009e = (LyricViewScroll) inflate.findViewById(R.id.l37);
        LyricViewInternalSingleLine lyricViewInternalSingleLine = (LyricViewInternalSingleLine) inflate.findViewById(R.id.l36);
        this.f321008d = lyricViewInternalSingleLine;
        lyricViewInternalSingleLine.j(this.f321010f);
        this.f321009e.setScrollEnable(false);
    }
}
