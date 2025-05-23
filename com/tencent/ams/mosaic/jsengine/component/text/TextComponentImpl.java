package com.tencent.ams.mosaic.jsengine.component.text;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.Html;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.facebook.yoga.YogaNode;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.jsengine.component.container.FlexContainerImpl;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TextComponentImpl extends BasicComponent implements TextComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final DecorationTextView f71309d;

    public TextComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f71309d = new DecorationTextView(context);
        }
    }

    private void D(SpannableString spannableString, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(spannableString) && jSONObject != null) {
            int optInt = jSONObject.optInt("start", -1);
            if (optInt < 0) {
                optInt = 0;
            }
            int optInt2 = jSONObject.optInt("end", -1);
            if (optInt2 < 0) {
                optInt2 = spannableString.length();
            }
            String optString = jSONObject.optString("spanType");
            String optString2 = jSONObject.optString("typeValue");
            if ("color".equals(optString)) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(optString2)), optInt, optInt2, 33);
                return;
            }
            if ("image".equals(optString)) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f71309d.getResources(), MosaicUtils.c(this.f71309d.getContext(), optString2));
                JSONArray optJSONArray = jSONObject.optJSONArray("bounds");
                if (optJSONArray != null && optJSONArray.length() == 4) {
                    bitmapDrawable.setBounds(optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(2), optJSONArray.optInt(3));
                    spannableString.setSpan(new p(bitmapDrawable, p.f71343d), optInt, optInt2, 1);
                    return;
                }
                return;
            }
            if (TextComponent.SpanStyle.TYPEFACE.equals(optString)) {
                spannableString.setSpan(new StyleSpan("bold".equals(optString2) ? 1 : 0), optInt, optInt2, 33);
            } else if ("textSize".equals(optString)) {
                try {
                    spannableString.setSpan(new AbsoluteSizeSpan(Integer.parseInt(optString2), true), optInt, optInt2, 33);
                } catch (Throwable th5) {
                    com.tencent.ams.mosaic.utils.f.c("TextComponentImpl", "assembleSpan", th5);
                }
            }
        }
    }

    private int E(String str) {
        int Y;
        if (MosaicUtils.v(str) && (Y = MosaicUtils.Y(str)) >= 100 && Y < 1000) {
            return (Y / 100) * 100;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(boolean z16) {
        this.f71309d.setIncludeFontPadding(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(float f16) {
        this.f71309d.setLetterSpacing(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(float f16) {
        this.f71309d.setLineSpacing(MosaicUtils.j(f16), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(int i3) {
        if (i3 == 1) {
            this.f71309d.setSingleLine();
        } else {
            this.f71309d.setMaxLines(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(boolean z16) {
        if (z16) {
            this.f71309d.setMovementMethod(ScrollingMovementMethod.getInstance());
        } else {
            this.f71309d.setMovementMethod(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(float f16, float f17, float f18, String str) {
        this.f71309d.setShadowLayer(MosaicUtils.j(f16), MosaicUtils.j(f17), MosaicUtils.j(f18), MosaicUtils.P(str, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(String str) {
        this.f71309d.setText(str);
        if (MosaicUtils.D()) {
            Object yogaNode = getYogaNode();
            if (yogaNode instanceof YogaNode) {
                YogaNode yogaNode2 = (YogaNode) yogaNode;
                if (!yogaNode2.isMeasureDefined()) {
                    yogaNode2.setMeasureFunction(new FlexContainerImpl.YogaLayout.a());
                }
                yogaNode2.dirty();
            }
        }
        this.f71309d.forceLayout();
        this.f71309d.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(int i3) {
        this.f71309d.setGravity(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(String str) {
        this.f71309d.setTextColor(MosaicUtils.P(str, -16777216));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(String str) {
        this.f71309d.setDecorationType(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(String str) {
        this.f71309d.setDecorationColor(MosaicUtils.O(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(float f16) {
        this.f71309d.setDecorationWeight(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(float f16) {
        this.f71309d.setTextSize(0, MosaicUtils.j(f16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(Typeface typeface) {
        this.f71309d.setTypeface(typeface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(TextUtils.TruncateAt truncateAt) {
        this.f71309d.setEllipsize(truncateAt);
    }

    private void U(Spanned spanned, boolean z16) {
        if (TextUtils.isEmpty(spanned)) {
            return;
        }
        this.f71309d.setText(spanned);
        if (z16) {
            float desiredWidth = Layout.getDesiredWidth(spanned, this.f71309d.getPaint());
            if (getView().getLayoutParams() != null) {
                setSize(MosaicUtils.E(desiredWidth), getHeight());
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f71309d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setIncludeFontPadding(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.n
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.F(z16);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    @RequiresApi(api = 21)
    public void setLetterSpacing(final float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.i
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.G(f16);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setLineSpacingExtra(final float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.m
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.H(f16);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setMaxLines(final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.l
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.I(i3);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setScrollable(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.e
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.J(z16);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setShadow(final float f16, final float f17, final float f18, final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), str);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.a
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.K(f16, f17, f18, str);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setSpannableString(String str) {
        Spanned spanned;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("text");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                if (TextComponent.SpanType.HTML.equals(jSONObject.optString("spanType"))) {
                    spanned = Html.fromHtml(optString);
                } else {
                    SpannableString spannableString = new SpannableString(optString);
                    JSONArray optJSONArray = jSONObject.optJSONArray("spans");
                    if (optJSONArray != null) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            D(spannableString, optJSONArray.optJSONObject(i3));
                        }
                    }
                    spanned = spannableString;
                }
                U(spanned, jSONObject.optBoolean("resizeWidth"));
            } catch (Exception e16) {
                com.tencent.ams.mosaic.utils.f.c("TextComponentImpl", "setSpannableString", e16);
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setText(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.d
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.L(str);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextAlign(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            final int covertAlignSplice = covertAlignSplice(str);
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.h
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.M(covertAlignSplice);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextColor(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.j
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.N(str);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextDecoration(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.o
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.O(str);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextDecorationColor(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.f
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.P(str);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextDecorationPadding(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
        } else {
            this.f71309d.setTextDecorationPadding(f16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextDecorationWeight(final float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.c
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.Q(f16);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextSize(final float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.k
                @Override // java.lang.Runnable
                public final void run() {
                    TextComponentImpl.this.R(f16);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextTypeface(String str, String str2) {
        int i3;
        final Typeface create;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if ("bold".equals(str2)) {
            i3 = 1;
        } else if ("italic".equals(str2)) {
            i3 = 2;
        } else if (TextComponent.TextStyle.BOLD_ITALIC.equals(str2)) {
            i3 = 3;
        } else {
            i3 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            create = Typeface.defaultFromStyle(i3);
        } else {
            create = Typeface.create(str, i3);
        }
        int E = E(str2);
        if (Build.VERSION.SDK_INT >= 28 && E > 0) {
            create = Typeface.create(create, E, false);
        }
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.b
            @Override // java.lang.Runnable
            public final void run() {
                TextComponentImpl.this.S(create);
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTruncateMode(String str) {
        final TextUtils.TruncateAt truncateAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TextComponentImpl", "setTruncateMode: " + str);
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -1074341483:
                    if (str.equals("middle")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 100571:
                    if (str.equals("end")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    truncateAt = TextUtils.TruncateAt.MIDDLE;
                    break;
                case 1:
                    truncateAt = TextUtils.TruncateAt.END;
                    break;
                case 2:
                    truncateAt = TextUtils.TruncateAt.START;
                    break;
                default:
                    truncateAt = null;
                    break;
            }
            if (truncateAt != null) {
                MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.text.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        TextComponentImpl.this.T(truncateAt);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TextComponentImpl";
    }
}
