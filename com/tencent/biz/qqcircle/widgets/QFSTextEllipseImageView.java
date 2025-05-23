package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class QFSTextEllipseImageView extends QCircleAsyncTextView {
    private boolean E;
    private QCircleAsyncTextView.b F;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f93451a;

        /* renamed from: b, reason: collision with root package name */
        public int f93452b = R.color.ajr;

        /* renamed from: c, reason: collision with root package name */
        public boolean f93453c = false;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f93454d;

        /* renamed from: e, reason: collision with root package name */
        public QCircleAsyncTextView.b f93455e;

        public boolean a() {
            if (!TextUtils.isEmpty(this.f93451a) && this.f93454d != null) {
                return true;
            }
            return false;
        }
    }

    public QFSTextEllipseImageView(Context context) {
        super(context);
        this.E = false;
        h();
    }

    private void h() {
        showEllipseEndImageSpan(true);
    }

    public void i() {
        this.F = null;
        this.E = false;
        setText((CharSequence) null);
    }

    public boolean j(a aVar) {
        boolean z16;
        if (aVar == null) {
            QLog.e("QFSTextEllipseImageView", 1, "[setTextEllipseEndImage] error, params is null");
            return false;
        }
        if (!aVar.a()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[setTextEllipseEndImage] error, params not valid, text:");
            sb5.append(aVar.f93451a);
            sb5.append(" hasDrawable:");
            if (aVar.f93454d != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.e("QFSTextEllipseImageView", 1, sb5.toString());
            return false;
        }
        this.F = aVar.f93455e;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aVar.f93451a);
        QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), aVar.f93454d);
        if (this.F != null) {
            d(spannableStringBuilder, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), this.F, aVar.f93452b, aVar.f93453c);
        }
        setText(spannableStringBuilder);
        this.E = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    public void restoreTruncatedSpan(int i3, SpannableStringBuilder spannableStringBuilder) {
        super.restoreTruncatedSpan(i3, spannableStringBuilder);
        if (!this.E) {
            QLog.i("QFSTextEllipseImageView", 1, "[restoreTruncatedSpan] do nothing");
            return;
        }
        if (spannableStringBuilder == null) {
            QLog.e("QFSTextEllipseImageView", 1, "[restoreTruncatedSpan] error, resultBuilder is null");
            return;
        }
        if (TextUtils.isEmpty(getText())) {
            QLog.e("QFSTextEllipseImageView", 1, "[restoreTruncatedSpan] error, getText() is empty");
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getText());
        ImageSpan[] imageSpanArr = (ImageSpan[]) spannableStringBuilder.getSpans(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), ImageSpan.class);
        int i16 = 0;
        if (imageSpanArr != null && imageSpanArr.length == 1) {
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannableStringBuilder2.getSpans(spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), ClickableSpan.class);
            if (clickableSpanArr.length != 1) {
                QLog.i("QFSTextEllipseImageView", 1, "[restoreTruncatedSpan] do nothing, clickableSpans.length:" + clickableSpanArr.length);
                return;
            }
            int spanStart = spannableStringBuilder.getSpanStart(imageSpanArr[0]);
            int spanEnd = spannableStringBuilder.getSpanEnd(imageSpanArr[0]);
            QLog.i("QFSTextEllipseImageView", 1, "[restoreTruncatedSpan] imageSpanStart:" + spanStart + " imageSpanEnd:" + spanEnd);
            spannableStringBuilder.setSpan(clickableSpanArr[0], spanStart, spanEnd, 33);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[restoreTruncatedSpan] error, imageSpans.length:");
        if (imageSpanArr != null) {
            i16 = imageSpanArr.length;
        }
        sb5.append(i16);
        QLog.e("QFSTextEllipseImageView", 1, sb5.toString());
    }

    public QFSTextEllipseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = false;
        h();
    }

    public QFSTextEllipseImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = false;
        h();
    }
}
