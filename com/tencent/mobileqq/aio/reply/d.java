package com.tencent.mobileqq.aio.reply;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d extends DynamicDrawableSpan {
    static IPatchRedirector $redirector_;
    private static String G;
    private Drawable C;
    protected View.OnClickListener D;
    private a E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    protected Context f193181d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f193182e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f193183f;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f193184h;

    /* renamed from: i, reason: collision with root package name */
    protected int f193185i;

    /* renamed from: m, reason: collision with root package name */
    public int f193186m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65932);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            G = "startPos";
        }
    }

    d(Context context, CharSequence charSequence, int i3, Paint paint, View.OnClickListener onClickListener, boolean z16) {
        super(0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, charSequence, Integer.valueOf(i3), paint, onClickListener, Boolean.valueOf(z16));
            return;
        }
        this.D = null;
        this.E = null;
        this.f193184h = charSequence;
        this.f193185i = i3;
        this.f193181d = context;
        this.F = z16;
        l(onClickListener);
        a(paint);
    }

    private void a(Paint paint) {
        if (this.f193182e != null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(f());
        if (b.c()) {
            this.f193183f = h(spannableStringBuilder);
            this.C = b(h(spannableStringBuilder), true);
            return;
        }
        Bitmap drawingCache = h(spannableStringBuilder).getDrawingCache();
        if (drawingCache != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f193181d.getResources(), drawingCache);
            this.f193182e = bitmapDrawable;
            int intrinsicHeight = bitmapDrawable.getIntrinsicHeight();
            Drawable drawable = this.f193182e;
            int width = drawingCache.getWidth();
            if (intrinsicHeight <= 0) {
                intrinsicHeight = 0;
            }
            drawable.setBounds(0, 0, width, intrinsicHeight);
        }
    }

    private Drawable b(TextView textView, boolean z16) {
        Drawable drawable;
        if (z16) {
            drawable = ResourcesCompat.getDrawable(this.f193181d.getResources(), R.drawable.qui_close_filled_icon_secondary_01_pressed, this.f193181d.getTheme());
        } else {
            drawable = ResourcesCompat.getDrawable(this.f193181d.getResources(), R.drawable.qui_close_filled_icon_secondary_01, this.f193181d.getTheme());
        }
        if (drawable == null) {
            return null;
        }
        drawable.mutate();
        int dip2px = ViewUtils.dip2px(11.0f);
        drawable.setBounds(0, 0, dip2px, dip2px);
        textView.setCompoundDrawables(null, null, drawable, null);
        textView.setCompoundDrawablePadding(ViewUtils.dip2px(5.0f));
        this.f193186m = drawable.getIntrinsicWidth() + ViewUtils.dip2px(4.0f) + ViewUtils.dip2px(5.0f);
        textView.measure(this.f193185i, View.MeasureSpec.makeMeasureSpec(0, 0));
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(textView.getDrawingCache());
        if (createBitmap == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f193181d.getResources(), createBitmap);
        bitmapDrawable.setBounds(0, 0, createBitmap.getWidth(), Math.max(bitmapDrawable.getIntrinsicHeight(), 0));
        textView.setDrawingCacheEnabled(false);
        textView.destroyDrawingCache();
        return bitmapDrawable;
    }

    public static d c(Context context, CharSequence charSequence, int i3, Paint paint, View.OnClickListener onClickListener, boolean z16) {
        if (context != null && i3 > 0) {
            return new d(context, charSequence, i3, paint, onClickListener, z16);
        }
        if (QLog.isColorLevel()) {
            QLog.w("ReplyedMessageSpan", 2, "create reply message span failed\uff0c width=" + i3);
            return null;
        }
        return null;
    }

    @DrawableRes
    private int e() {
        if (!this.F && QQTheme.isVasTheme()) {
            return R.drawable.gxi;
        }
        return R.drawable.k56;
    }

    @ColorInt
    private int g(@NonNull Context context) {
        if (!this.F && QQTheme.isVasTheme()) {
            return ColorUtils.setAlphaComponent(this.f193181d.getColor(R.color.skin_input_theme_version2), 230);
        }
        return this.f193181d.getColor(R.color.qui_common_text_secondary);
    }

    @NonNull
    private TextView h(SpannableStringBuilder spannableStringBuilder) {
        TextView textView = new TextView(this.f193181d);
        if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_input_reply_message_max_lines_9015_118461199", true)) {
            textView.setMaxLines(1);
        } else {
            textView.setSingleLine();
        }
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setBackgroundResource(e());
        textView.setGravity(16);
        textView.setTextColor(g(this.f193181d));
        textView.setText(spannableStringBuilder);
        textView.setTextSize(2, 12.0f);
        int dip2px = ViewUtils.dip2px(6.0f);
        int dip2px2 = ViewUtils.dip2px(4.0f);
        textView.setPadding(dip2px, dip2px2, dip2px, dip2px2);
        textView.setMaxWidth(this.f193185i);
        textView.setWidth(this.f193185i);
        textView.setDrawingCacheEnabled(true);
        return textView;
    }

    public Drawable d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.C;
    }

    public CharSequence f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ((IQQTextApi) com.tencent.qqnt.aio.adapter.a.b(IQQTextApi.class)).getQQText(this.f193184h.toString(), 7, 16, null, null);
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f193182e == null && (textView = this.f193183f) != null) {
            this.f193182e = b(textView, false);
        }
        return this.f193182e;
    }

    public void i(TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) textView);
            return;
        }
        View.OnClickListener onClickListener = this.D;
        if (onClickListener != null) {
            onClickListener.onClick(textView);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        a aVar = this.E;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void k(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            this.E = aVar;
        }
    }

    public void l(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onClickListener);
        } else {
            this.D = onClickListener;
        }
    }
}
