package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import com.tencent.richframework.text.rich.style.NoScrollLinkMovementMethod;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleAsyncTextView extends RFWAsyncRichTextView {
    private boolean C;
    private int D;

    /* renamed from: h, reason: collision with root package name */
    private long f92892h;

    /* renamed from: i, reason: collision with root package name */
    public int f92893i;

    /* renamed from: m, reason: collision with root package name */
    private HashSet<BoldClickableSpan.OnClickBoldTextListener> f92894m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements BoldClickableSpan.OnClickBoldTextListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f92895a;

        a(b bVar) {
            this.f92895a = bVar;
        }

        @Override // com.tencent.richframework.text.rich.span.BoldClickableSpan.OnClickBoldTextListener
        public void onClick(Object obj) {
            QCircleAsyncTextView.this.setIsSpanClick(true);
            b bVar = this.f92895a;
            if (bVar != null) {
                bVar.onClick();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void onClick();
    }

    public QCircleAsyncTextView(Context context) {
        super(context, null);
        this.f92893i = R.color.qvideo_skin_color_text_primary;
        this.f92894m = new HashSet<>();
    }

    public static void e(SpannableStringBuilder spannableStringBuilder, int i3, Drawable drawable) {
        f(spannableStringBuilder, i3, drawable, 0, 0);
    }

    public static void f(SpannableStringBuilder spannableStringBuilder, int i3, Drawable drawable, int i16, int i17) {
        if (!TextUtils.isEmpty(spannableStringBuilder) && i3 >= 0 && i3 <= spannableStringBuilder.length() && drawable != null) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            spannableStringBuilder.clear();
            spannableStringBuilder.append(spannableStringBuilder2.subSequence(0, i3)).append(" ");
            if (i3 < spannableStringBuilder2.length()) {
                spannableStringBuilder.append(spannableStringBuilder2.subSequence(i3, spannableStringBuilder2.length()));
            }
            nb0.d dVar = new nb0.d(drawable);
            dVar.a(i16, i17);
            spannableStringBuilder.setSpan(dVar, i3, i3 + 1, 33);
        }
    }

    public void b(SpannableStringBuilder spannableStringBuilder, int i3, int i16, b bVar) {
        d(spannableStringBuilder, i3, i16, bVar, this.f92893i, true);
    }

    public void d(SpannableStringBuilder spannableStringBuilder, int i3, int i16, b bVar, int i17, boolean z16) {
        if (!TextUtils.isEmpty(spannableStringBuilder) && i16 >= i3 && spannableStringBuilder.length() >= i16) {
            BoldClickableSpan boldClickableSpan = new BoldClickableSpan(g(bVar), QCircleSkinHelper.getInstance().getColor(getContext(), i17), z16);
            setHighlightColor(getResources().getColor(R.color.ajr));
            spannableStringBuilder.setSpan(boldClickableSpan, i3, i16, 33);
        }
    }

    protected BoldClickableSpan.OnClickBoldTextListener g(b bVar) {
        a aVar = new a(bVar);
        this.f92894m.add(aVar);
        return aVar;
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView, android.widget.TextView
    protected MovementMethod getDefaultMovementMethod() {
        return NoScrollLinkMovementMethod.getInstance();
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        setIsSpanClick(false);
        if (!this.C) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.f92892h = System.currentTimeMillis();
        } else if (motionEvent.getAction() == 1 && System.currentTimeMillis() - this.f92892h > 500) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (isSpanClick()) {
            return true;
        }
        return super.performClick();
    }

    public void setClickAreaTextColor(int i3) {
        this.f92893i = i3;
    }

    public void setIsEllipsizeEnd(boolean z16) {
        this.mIsEllipsizeEnd = z16;
    }

    @Override // android.view.View
    public void setOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        boolean z16;
        super.setOnLongClickListener(onLongClickListener);
        if (onLongClickListener != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.C = z16;
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView, com.tencent.richframework.text.rich.RFWSafeTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (isNeedSpecialHashTagAreaBackground() && this.D == 0) {
            int lineHeight = getLineHeight() + ImmersiveUtils.dpToPx(2.0f);
            this.D = lineHeight;
            setLineHeight(lineHeight);
            setPadding(getPaddingLeft(), getPaddingTop() + ImmersiveUtils.dpToPx(2.0f), getPaddingRight(), getPaddingBottom());
        }
        super.setText(charSequence, bufferType);
    }

    public QCircleAsyncTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f92893i = R.color.qvideo_skin_color_text_primary;
        this.f92894m = new HashSet<>();
    }

    public QCircleAsyncTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f92893i = R.color.qvideo_skin_color_text_primary;
        this.f92894m = new HashSet<>();
    }
}
