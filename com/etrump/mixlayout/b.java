package com.etrump.mixlayout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.api.IETFontAdapter;
import com.tencent.mobileqq.vas.api.IEmoticonSpanApi;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b implements IETFontAdapter {

    /* renamed from: a, reason: collision with root package name */
    private IEmoticonSpanApi f32688a = IEmoticonSpanApi.INSTANCE.a();

    @Override // com.etrump.mixlayout.api.IETFontAdapter
    public void drawImage(Canvas canvas, float f16, float f17, Object obj, Paint paint) {
        Paint paint2;
        if (paint == null) {
            paint2 = new Paint();
        } else {
            paint2 = paint;
        }
        if (this.f32688a.isEmoticonSpan(obj)) {
            Rect rect = this.f32688a.getRect(obj);
            if (rect == null) {
                return;
            }
            int height = ((int) f17) + rect.height();
            this.f32688a.draw(obj, canvas, null, 0, 0, f16, 0, height, height, paint2);
            return;
        }
        if (obj instanceof d) {
            ((d) obj).draw(canvas, null, 0, 0, f16, 0, 0, (int) (f17 + r4.getDrawable().getBounds().height()), paint2);
        }
    }

    @Override // com.etrump.mixlayout.api.IETFontAdapter
    public void drawSignatureSpan(ArrayList<CharacterStyle> arrayList, ETFont eTFont, Paint paint, int i3, Canvas canvas) {
        p pVar = (p) arrayList.get(i3);
        paint.setTextSize(eTFont.mFontSize);
        paint.setColor(eTFont.mFontColor);
        int a16 = pVar.a();
        float f16 = pVar.D;
        pVar.E = false;
        pVar.draw(canvas, null, 0, 0, pVar.C, (int) f16, 0, a16 + ((int) f16), paint);
    }

    @Override // com.etrump.mixlayout.api.IETFontAdapter
    public String getDIYFontImage(String str) {
        return a.f32687b.get(str);
    }

    @Override // com.etrump.mixlayout.api.IETFontAdapter
    public int getSpanHeight(CharacterStyle characterStyle) {
        if (this.f32688a.isEmoticonSpan(characterStyle)) {
            Rect rect = this.f32688a.getRect(characterStyle);
            if (rect == null) {
                return 0;
            }
            return rect.height();
        }
        if (!(characterStyle instanceof p)) {
            return 0;
        }
        return ((p) characterStyle).a();
    }

    @Override // com.etrump.mixlayout.api.IETFontAdapter
    public int getSpanWidth(CharacterStyle characterStyle) {
        if (this.f32688a.isEmoticonSpan(characterStyle)) {
            Rect rect = this.f32688a.getRect(characterStyle);
            if (rect == null) {
                return 0;
            }
            return rect.width();
        }
        if (!(characterStyle instanceof p)) {
            return 0;
        }
        return ((p) characterStyle).b();
    }

    @Override // com.etrump.mixlayout.api.IETFontAdapter
    public char getSysEmotcationHead() {
        return (char) 20;
    }

    @Override // com.etrump.mixlayout.api.IETFontAdapter
    public boolean isInstanceOfEmoticonSpan(CharacterStyle characterStyle) {
        if (characterStyle != null && this.f32688a.isEmoticonSpan(characterStyle)) {
            return true;
        }
        return false;
    }

    @Override // com.etrump.mixlayout.api.IETFontAdapter
    public boolean isInstanceOfSignatureActionSpan(CharacterStyle characterStyle) {
        if (characterStyle != null && (characterStyle instanceof p)) {
            return true;
        }
        return false;
    }

    @Override // com.etrump.mixlayout.api.IETFontAdapter
    public void setSignatureActionSpanData(int i3, int i16, CharacterStyle characterStyle) {
        if (characterStyle instanceof p) {
            p pVar = (p) characterStyle;
            pVar.C = i3;
            pVar.D = i16;
        }
    }

    @Override // com.etrump.mixlayout.api.IETFontAdapter
    public void systemDrawSpan(Canvas canvas, int i3, int i16, Paint paint, CharacterStyle characterStyle, int i17) {
        Paint paint2;
        if (paint == null) {
            paint2 = new Paint();
        } else {
            paint2 = paint;
        }
        if (this.f32688a.isEmoticonSpan(characterStyle)) {
            Rect rect = this.f32688a.getRect(characterStyle);
            if (rect == null) {
                return;
            }
            int height = i16 + rect.height();
            this.f32688a.draw(characterStyle, canvas, null, 0, 0, i3, 0, height, height, paint2);
            return;
        }
        if (characterStyle instanceof p) {
            paint2.setTextSize(i17);
            p pVar = (p) characterStyle;
            int a16 = i16 + pVar.a();
            pVar.E = false;
            pVar.draw(canvas, null, 0, 0, i3, 0, i16, a16, paint2);
        }
    }
}
