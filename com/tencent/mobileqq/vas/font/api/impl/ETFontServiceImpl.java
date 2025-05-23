package com.tencent.mobileqq.vas.font.api.impl;

import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETSegment;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.etrump.mixlayout.api.IETSegment;
import com.etrump.mixlayout.d;
import com.tencent.mobileqq.vas.font.api.IETFontService;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ETFontServiceImpl implements IETFontService {
    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public IETDecoration createDecoration(IETEngine iETEngine, String str, int i3, int i16, int i17, int i18, IETSegment[] iETSegmentArr, Object[] objArr, boolean z16, int i19, IETFont iETFont, boolean z17) {
        return ETDecoration.createDecoration(iETEngine, str, i3, i16, i17, i18, iETSegmentArr, objArr, z16, i19, iETFont, z17);
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public IETDecoration createDecorationSpace(IETEngine iETEngine, String str, int i3, int i16, Point point, int i17, Point[] pointArr, int i18, IETSegment[] iETSegmentArr, Object[] objArr, boolean z16, int i19, boolean z17, IETFont iETFont, boolean z18) {
        return ETDecoration.createDecorationSpace(iETEngine, str, i3, i16, point, i17, pointArr, i18, iETSegmentArr, objArr, z16, i19, z17, iETFont, z18);
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public IETFont createETFont() {
        return new ETFont();
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public ReplacementSpan createETImageSpan(Drawable drawable) {
        return new d(drawable);
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public IETSegment createETSegment() {
        return new ETSegment();
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public IETEngine getETEngineInstance() {
        return ETEngine.getInstance();
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public IETEngine getInstanceForAnimation() {
        return ETEngine.getInstanceForAnimation();
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public IETEngine getInstanceForDiyPendant() {
        return ETEngine.getInstanceForDiyPendant();
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public IETEngine getInstanceForRedPacket() {
        return ETEngine.getInstanceForRedPacket();
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public IETEngine getInstanceForSpace() {
        return ETEngine.getInstanceForSpace();
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public IETFont createETFont(IETFont iETFont) {
        return ETFont.createFont((ETFont) iETFont);
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public IETFont createETFont(int i3, String str, float f16) {
        return new ETFont(i3, str, f16);
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETFontService
    public IETFont createETFont(int i3, String str, float f16, int i16, Typeface typeface) {
        return new ETFont(i3, str, f16, i16, typeface);
    }
}
