package cf0;

import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends ClickableSpan {

    /* renamed from: d, reason: collision with root package name */
    private String f30767d;

    /* renamed from: e, reason: collision with root package name */
    private int f30768e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f30769f;

    /* renamed from: h, reason: collision with root package name */
    private a f30770h;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        boolean onClick(String str);
    }

    public c(String str, int i3, a aVar) {
        this.f30767d = str;
        this.f30768e = i3;
        this.f30770h = aVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        a aVar;
        if (!TextUtils.isEmpty(this.f30767d) && (aVar = this.f30770h) != null) {
            aVar.onClick(this.f30767d);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int i3 = this.f30768e;
        if (i3 > 0) {
            textPaint.setColor(i3);
        }
        ColorStateList colorStateList = this.f30769f;
        if (colorStateList != null) {
            textPaint.setColor(colorStateList.getColorForState(textPaint.drawableState, 0));
        }
        textPaint.setUnderlineText(false);
    }

    public c(String str, ColorStateList colorStateList, a aVar) {
        this.f30767d = str;
        this.f30769f = colorStateList;
        this.f30770h = aVar;
    }
}
