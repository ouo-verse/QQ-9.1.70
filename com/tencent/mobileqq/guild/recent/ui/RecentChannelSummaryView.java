package com.tencent.mobileqq.guild.recent.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.config.recent.a;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.SingleLineTextView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RecentChannelSummaryView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f231962d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f231963e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f231964f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f231965h;

    /* renamed from: i, reason: collision with root package name */
    private SingleLineTextView f231966i;

    /* renamed from: m, reason: collision with root package name */
    private float f231967m;

    public RecentChannelSummaryView(Context context) {
        super(context);
        g(context, null);
    }

    private void a() {
        this.f231963e = new ImageView(getContext());
        int dpToPx = ViewUtils.dpToPx(13.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.rightMargin = ViewUtils.dpToPx(4.0f);
        this.f231963e.setLayoutParams(layoutParams);
        n(this.f231963e, ViewUtils.dpToPx(this.f231967m));
        addView(this.f231963e, 0);
    }

    private void b() {
        this.f231962d = new ImageView(getContext());
        int dpToPx = ViewUtils.dpToPx(13.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.rightMargin = ViewUtils.dpToPx(4.0f);
        this.f231962d.setLayoutParams(layoutParams);
        n(this.f231962d, ViewUtils.dpToPx(this.f231967m));
        addView(this.f231962d, 0);
    }

    private void c() {
        this.f231965h = new TextView(getContext());
        this.f231965h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f231965h.setPadding(0, 0, ViewUtils.dpToPx(4.0f), 0);
        this.f231965h.setEllipsize(TextUtils.TruncateAt.END);
        this.f231965h.setIncludeFontPadding(false);
        this.f231965h.setSingleLine(true);
        this.f231965h.setTextColor(Color.parseColor("#0099FF"));
        this.f231965h.setTextSize(1, this.f231967m);
        addView(this.f231965h, f(this.f231962d, this.f231964f));
    }

    private void d() {
        int i3;
        this.f231964f = new ImageView(getContext());
        int dpToPx = ViewUtils.dpToPx(13.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.rightMargin = ViewUtils.dpToPx(4.0f);
        this.f231964f.setLayoutParams(layoutParams);
        n(this.f231964f, ViewUtils.dpToPx(this.f231967m));
        ImageView imageView = this.f231964f;
        if (this.f231962d == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        addView(imageView, i3);
    }

    private void e() {
        if (this.f231965h == null) {
            return;
        }
        if (a.d()) {
            this.f231965h.setTextColor(getContext().getResources().getColor(R.color.qui_common_feedback_error));
        } else {
            this.f231965h.setTextColor(getContext().getResources().getColor(R.color.ag5));
        }
    }

    private int f(View... viewArr) {
        int i3 = 0;
        for (View view : viewArr) {
            if (view != null) {
                i3++;
            }
        }
        return i3;
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.f231967m = 14.0f;
        setGravity(16);
        SingleLineTextView singleLineTextView = new SingleLineTextView(getContext());
        this.f231966i = singleLineTextView;
        singleLineTextView.setTextSize(this.f231967m);
        this.f231966i.setTextColor(context.getResources().getColorStateList(R.color.skin_gray2_theme_version2));
        addView(this.f231966i);
    }

    private void h(int i3) {
        if (i3 != -1) {
            if (this.f231963e == null) {
                a();
            }
            this.f231963e.setVisibility(0);
            this.f231963e.setBackgroundResource(i3);
            return;
        }
        ImageView imageView = this.f231963e;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void i(MsgSummary msgSummary) {
        if (!msgSummary.bShowDraft && TextUtils.isEmpty(msgSummary.mDraft)) {
            ImageView imageView = this.f231962d;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f231962d == null) {
            b();
        }
        this.f231962d.setVisibility(0);
        this.f231962d.setBackgroundResource(R.drawable.conversation_unsend_icon);
    }

    private void j(MsgSummary msgSummary) {
        if (TextUtils.isEmpty(msgSummary.strPrefix)) {
            TextView textView = this.f231965h;
            if (textView != null) {
                textView.setText("");
                this.f231965h.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f231965h == null) {
            c();
        }
        this.f231965h.setVisibility(0);
        this.f231965h.setText(msgSummary.strPrefix);
        e();
    }

    private void k(SingleLineTextView singleLineTextView, boolean z16, @NonNull String str) {
        if (z16) {
            singleLineTextView.setPadding(0, 0, 0, ScreenUtil.dip2px(2.0f));
            singleLineTextView.setText(new QQText(str, 3, 14));
        } else {
            singleLineTextView.setPadding(0, 0, 0, 0);
            singleLineTextView.setText(str);
        }
    }

    private void l(int i3) {
        if (i3 != -1) {
            if (this.f231964f == null) {
                d();
            }
            this.f231964f.setVisibility(0);
            this.f231964f.setBackgroundResource(i3);
            return;
        }
        ImageView imageView = this.f231964f;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void m(MsgSummary msgSummary) {
        String str = "";
        boolean z16 = true;
        if (msgSummary.bShowDraft) {
            SingleLineTextView singleLineTextView = this.f231966i;
            if (msgSummary.mEmojiFlag == 0) {
                z16 = false;
            }
            CharSequence charSequence = msgSummary.mDraft;
            if (charSequence != null) {
                str = (String) charSequence;
            }
            k(singleLineTextView, z16, str);
            return;
        }
        SingleLineTextView singleLineTextView2 = this.f231966i;
        if (msgSummary.mEmojiFlag == 0) {
            z16 = false;
        }
        CharSequence charSequence2 = msgSummary.strContent;
        if (charSequence2 != null) {
            str = (String) charSequence2;
        }
        k(singleLineTextView2, z16, str);
    }

    private void n(View view, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }

    public void setBusinessIcon(int i3) {
        if (i3 == -1) {
            return;
        }
        h(i3);
        invalidate();
    }

    public void setBusinessSummaryContent(String str) {
        SingleLineTextView singleLineTextView = this.f231966i;
        if (singleLineTextView == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        k(singleLineTextView, false, str);
    }

    public void setHighlightStatus(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f231965h == null) {
                c();
            }
            this.f231965h.setVisibility(0);
            this.f231965h.setText(str);
            e();
        }
    }

    public void setSummaryData(MsgSummary msgSummary) {
        if (msgSummary == null) {
            return;
        }
        h(-1);
        i(msgSummary);
        l(-1);
        j(msgSummary);
        m(msgSummary);
        invalidate();
    }

    public void setSummaryLastMsgTextColor(int i3) {
        SingleLineTextView singleLineTextView = this.f231966i;
        if (singleLineTextView == null) {
            return;
        }
        singleLineTextView.setTextColor(i3);
    }

    public RecentChannelSummaryView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context, attributeSet);
    }

    public RecentChannelSummaryView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        g(context, attributeSet);
    }
}
