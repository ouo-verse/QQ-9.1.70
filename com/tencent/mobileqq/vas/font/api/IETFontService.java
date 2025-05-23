package com.tencent.mobileqq.vas.font.api;

import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.etrump.mixlayout.api.IETSegment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IETFontService extends QRouteApi {
    IETDecoration createDecoration(IETEngine iETEngine, String str, int i3, int i16, int i17, int i18, IETSegment[] iETSegmentArr, Object[] objArr, boolean z16, int i19, IETFont iETFont, boolean z17);

    IETDecoration createDecorationSpace(IETEngine iETEngine, String str, int i3, int i16, Point point, int i17, Point[] pointArr, int i18, IETSegment[] iETSegmentArr, Object[] objArr, boolean z16, int i19, boolean z17, IETFont iETFont, boolean z18);

    IETFont createETFont();

    IETFont createETFont(int i3, String str, float f16);

    IETFont createETFont(int i3, String str, float f16, int i16, Typeface typeface);

    IETFont createETFont(IETFont iETFont);

    ReplacementSpan createETImageSpan(Drawable drawable);

    IETSegment createETSegment();

    IETEngine getETEngineInstance();

    IETEngine getInstanceForAnimation();

    IETEngine getInstanceForDiyPendant();

    IETEngine getInstanceForRedPacket();

    IETEngine getInstanceForSpace();
}
