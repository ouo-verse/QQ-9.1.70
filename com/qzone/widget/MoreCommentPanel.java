package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* loaded from: classes37.dex */
public class MoreCommentPanel extends RelativeLayout {
    private ImageView arrowIcon;
    private TextView hintText;
    private boolean isAlphaBg;
    private Context mContext;

    public MoreCommentPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isAlphaBg = false;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.bu8, this);
        this.hintText = (TextView) findViewById(R.id.f166318f03);
        this.arrowIcon = (ImageView) findViewById(R.id.f166316f01);
        if (this.isAlphaBg) {
            setBackgroundColor(this.mContext.getResources().getColor(R.color.qzone_skin_feed_background_color));
            this.hintText.setTextColor(this.mContext.getResources().getColor(R.color.qzone_skin_feed_second_content_text_color));
            this.arrowIcon.setImageResource(R.drawable.gi5);
        } else {
            setBackgroundColor(this.mContext.getResources().getColor(R.color.f157363np));
            setBackgroundResource(R.drawable.gi6);
        }
    }

    public void setHintText(CharSequence charSequence) {
        TextView textView = this.hintText;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public MoreCommentPanel(Context context, boolean z16) {
        super(context);
        this.mContext = context;
        this.isAlphaBg = z16;
        init();
    }

    public MoreCommentPanel(Context context) {
        super(context);
        this.isAlphaBg = false;
        this.mContext = context;
        init();
    }
}
