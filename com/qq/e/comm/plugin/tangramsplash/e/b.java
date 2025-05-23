package com.qq.e.comm.plugin.tangramsplash.e;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.am;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    Context f39889a;

    /* renamed from: b, reason: collision with root package name */
    TextView f39890b;

    /* renamed from: c, reason: collision with root package name */
    String f39891c;

    public b(Context context) {
        this(context, null);
    }

    private void a() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ak.a(getContext(), 27), ak.a(getContext(), 27));
        layoutParams.gravity = 16;
        layoutParams.rightMargin = ak.a(getContext(), 5);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(am.a("iVBORw0KGgoAAAANSUhEUgAAADYAAAA2CAYAAACMRWrdAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAANJSURBVHgB7ZrRkZswEIbXmbzHqSByBXE6UDq4qyCkgriDcyq4XAV2KjinApwKcqkAUoHdgaI1q7AogBFICGb8zewAQmD93mUlIQBu3LiglBJoMHe0iLW2B22/tJ1UFSzbabuDuUCeSVV3Mm0JTBndwE+Wd1JtG23ShCLtJ9qeLYGPMEUo7LgXZIdrUOieXbeDKYHPCmscNnTpeP12cp6jfz2jRj1DTyhkDfGTiiqymwk/AQNgYZlBTMhbhqShzpKev1SVaV601D1F9xplt9Z/mMTYZNrWDfW/UZ0UYsHCcNdwPmFitvQcZW0NV2UiOkEsVNkRb66cf2Rlkold1lzDw/sdeOIVuCFoe75y/rcpWCwWR3b+jX2BPp+zw7fgCVdhs8FVmPGUU4fchpVUcvCEqzATYu/BH4K2Zx2WZ/CEq7Ajbe+U4zCqBUnbn+ARV2EHKMIRRW3ADwcyX/e74CSMQuWJDtfgAcya2u6t7DiY1+CIbgB2vC9QhqUL2KetaH/vW0ww2CgjscqbeIBAOHvMA0faSm3o/T9QPGMCisyYw9To4LEtKzODX7zGfr0gYCBjjzwObP9IWwHVDl9qS4d2J2MJ+4ymw+yFlfHO+CsU48QVlQttO/JeRtsEYtEUig11Zd10hYXooGQTcxCM3vsOhbc43JPYZ95TPWSr/I14qqhiOo8TSPwRaZ3Lunqs5f7mDVY65N5OHqNQwNDBiSTup8rDSx2LnLY/GsoF+ERVp/3mgebHwofHWn7f/N62S30Xj5kH90lnt5W2j3r/A5RZDEMnTPz3oJMwemAFHe5NOaVvFJfD//1RVPpkxUrjaQiE3sthQnQSRtOVIx3u7GRRI87bTDg4qljYO/FkUVMHE4iXeVrNvZ2Sh+vNr4oLRcisaJIFhty/TDimOBeck8dcxPUaK85BXO9BcERxOYwBJZQsdEJhSUvCWFjjRO/iVHXFRsCYhBSnynW5OIuDIcSp6qwigVjUiJPQE2tAEP+bEEucUi0L7C33+KIGjHIWEAhqCP7LkhXj6zdcVcGu4gzVwbKZGuES1QbKWQTW9f5ufzD0jHDvdQW9Fe7ljS9U8XXAXtV/9sfFpD4EBQvFLlDjLwJms/JyIxB/AYxl6EyiZ2pOAAAAAElFTkSuQmCC"));
        addView(imageView, layoutParams);
        TextView textView = new TextView(this.f39889a);
        this.f39890b = textView;
        textView.setText(this.f39891c);
        this.f39890b.setTextSize(14.0f);
        this.f39890b.setMaxLines(1);
        this.f39890b.setTextColor(Color.parseColor("#FFFFFF"));
        this.f39890b.setEllipsize(TextUtils.TruncateAt.END);
        this.f39890b.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_activated}, new int[]{R.attr.state_checkable}, new int[0]}, new int[]{-1, -1, -1, -1, -1}));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        addView(this.f39890b, layoutParams2);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f39891c = "\u8f7b\u89e6\u5c4f\u5e55\uff0c\u67e5\u770b\u66f4\u591a";
        this.f39889a = context;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{90.0f, 90.0f, 0.0f, 0.0f, 0.0f, 0.0f, 90.0f, 90.0f}, null, null));
        shapeDrawable.getPaint().setColor(Color.parseColor("#99000000"));
        shapeDrawable.getPaint().setAlpha(100);
        setBackground(shapeDrawable);
        a();
        setOrientation(0);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f39891c = str;
        this.f39890b.setText(str);
    }
}
