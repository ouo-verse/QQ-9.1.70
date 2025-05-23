package com.qzone.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a implements TextLayoutBase {
    private String C;

    /* renamed from: d, reason: collision with root package name */
    private int f60695d;

    /* renamed from: e, reason: collision with root package name */
    private int f60696e;

    /* renamed from: f, reason: collision with root package name */
    private int f60697f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<TextCell> f60698h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f60699i = new Paint(5);

    /* renamed from: m, reason: collision with root package name */
    private TextCellLayout f60700m = new TextCellLayout(this, this.f60699i);

    private void g(float f16) {
        this.f60699i.setTextSize(f16);
        Paint.FontMetrics fontMetrics = this.f60699i.getFontMetrics();
        this.f60697f = (int) Math.ceil(fontMetrics.descent - fontMetrics.top);
    }

    public boolean a(Canvas canvas) {
        return this.f60700m.draw(this, canvas);
    }

    public int b() {
        return this.f60695d;
    }

    public ArrayList<TextCell> c() {
        return this.f60698h;
    }

    public int d() {
        return this.f60696e;
    }

    public void e(int i3, int i16) {
        this.f60700m.measure(i3, i16);
        this.f60695d = this.f60700m.getMeausredHeight();
        this.f60696e = this.f60700m.getMeausredWidth();
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public View getAttachedView() {
        return null;
    }

    public void h(int i3) {
        this.f60700m.setTextGravity(i3);
    }

    public void i(boolean z16) {
        this.f60700m.setHasMore(z16);
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public boolean isLongClickTrig() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public boolean isPressed() {
        return false;
    }

    public void j(String str) {
        this.C = str;
        this.f60698h = TextCellParser.parseContent(this, str, this.f60697f, true);
        this.f60700m.setMeasuredTextCacheEnabled(false);
        this.f60700m.setText(this.f60698h);
        this.f60700m.setDrawBackground(false);
    }

    public void k(boolean z16) {
        this.f60700m.setShowMore(z16);
    }

    public void l(int i3) {
        this.f60700m.setTextColor(i3);
    }

    public void m(int i3) {
        float f16 = i3;
        if (f16 != this.f60699i.getTextSize()) {
            g(f16);
        }
        this.f60700m.setTextSize(f16);
    }

    public void f(int i3, String str) {
        if (i3 <= 0) {
            this.f60699i.setTypeface(null);
        } else {
            this.f60700m.setFont(i3, str, 2, null);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void invalidate() {
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void performCellClick(TextCell textCell) {
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void performCellLongClick() {
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void postInvalidate() {
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void postRequestLayout() {
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void requestLayout() {
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void setLongClickTrig(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void setPressed(boolean z16) {
    }
}
