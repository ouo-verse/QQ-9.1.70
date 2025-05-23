package com.qzone.detail.ui.component;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneForbidenUserView extends FrameLayout {
    private TextView C;
    private View D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private View f47015d;

    /* renamed from: e, reason: collision with root package name */
    private View f47016e;

    /* renamed from: f, reason: collision with root package name */
    private AsyncImageView f47017f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f47018h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f47019i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f47020m;

    public QzoneForbidenUserView(Context context) {
        super(context);
        this.f47018h = null;
        this.f47019i = null;
        this.f47020m = null;
        this.C = null;
        this.E = true;
        c();
    }

    private void c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        View inflate = View.inflate(getContext(), R.layout.bgh, null);
        this.f47015d = inflate;
        addView(inflate, layoutParams);
        this.f47016e = findViewById(R.id.jtk);
        this.f47017f = (AsyncImageView) findViewById(R.id.jte);
        this.f47018h = (TextView) findViewById(R.id.cj9);
        this.f47019i = (TextView) findViewById(R.id.cj_);
        this.D = findViewById(R.id.f163918c6);
        this.C = (TextView) findViewById(R.id.cj_);
        this.f47020m = (TextView) findViewById(R.id.f85244of);
        setIconContent();
        if (QQTheme.isNowSimpleUI()) {
            this.f47020m.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0099FF")));
        }
        this.f47020m.setVisibility(0);
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_ARCHIVE_MEMORY, QzoneConfig.SECONDARY_MEMOEY_TEXT, QzoneConfig.DefaultValue.DEFAULT_MEMORY_DEFAUL_TEXT);
        String config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_ARCHIVE_MEMORY, QzoneConfig.SECONDARY_MEMOEY_COVER_URL, "https://qzonestyle.gtimg.cn/aoi/sola/20190329163959_MjiOsvgXQa.png");
        setMessage(config);
        this.f47017f.setDecodeConfig(Bitmap.Config.ARGB_8888);
        this.f47017f.setAsyncImageProcessor(new z4.a());
        setTopIcon(config2);
        float dpToPx = ViewUtils.dpToPx(8.0f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx}, null, null));
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.getPaint().setColor(-16725252);
        this.D.setBackgroundDrawable(shapeDrawable);
    }

    public void a() {
        if (this.C == null || QQTheme.isNowThemeIsNightForQzone()) {
            return;
        }
        this.C.setTextColor(Color.parseColor("#000000"));
    }

    public void b() {
        TextView textView = this.f47020m;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public void d() {
        TextView textView = this.f47020m;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }

    public void setBackgroundAlpha(int i3) {
        com.qzone.reborn.feedx.widget.i.a(this, i3);
    }

    public void setDefaultTopIcon(int i3) {
        this.f47017f.setDefaultImage(i3);
    }

    public void setIconContent() {
        TextView textView = this.f47020m;
        if (textView == null) {
            return;
        }
        if (this.E) {
            textView.setText(com.qzone.util.l.a(R.string.f213865rc));
        } else {
            textView.setText(com.qzone.util.l.a(R.string.f213865rc));
        }
    }

    public void setMessage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f47018h.setText(str);
            this.f47018h.setVisibility(0);
        } else {
            this.f47018h.setVisibility(8);
        }
    }

    public void setMessageTextSize(float f16) {
        this.f47018h.setTextSize(f16);
    }

    public void setMessageTopMargin(int i3) {
        ((LinearLayout.LayoutParams) this.f47018h.getLayoutParams()).topMargin = i3;
    }

    public void setTimelimitTextSize(float f16) {
        this.f47019i.setTextSize(f16);
    }

    public void setTimelimitTopMargin(int i3) {
        ((LinearLayout.LayoutParams) this.f47019i.getLayoutParams()).topMargin = i3;
    }

    public void setTopIcon(String str) {
        this.f47017f.setAsyncImage(str);
    }

    public void setTopIconSize(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams = this.f47017f.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
    }

    public void setTopIconTopMargin(int i3) {
        ((LinearLayout.LayoutParams) this.f47017f.getLayoutParams()).topMargin = i3;
    }

    public void setmTimelimitMessage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f47019i.setText(str);
            this.f47019i.setVisibility(0);
        } else {
            this.f47019i.setVisibility(8);
        }
    }

    public void setTopIcon(String str, int i3) {
        setDefaultTopIcon(i3);
        setTopIcon(str);
    }

    public void setShowTopLine(boolean z16) {
        if (z16) {
            this.f47016e.setVisibility(0);
        } else {
            this.f47016e.setVisibility(8);
        }
    }

    public void setMessage(int i3) {
        if (i3 > 0) {
            this.f47018h.setText(i3);
            this.f47018h.setVisibility(0);
        } else {
            this.f47018h.setVisibility(8);
        }
    }

    public void setmTimelimitMessage(int i3) {
        if (i3 > 0) {
            this.f47019i.setText(i3);
            this.f47019i.setVisibility(0);
        } else {
            this.f47019i.setVisibility(8);
        }
    }

    public QzoneForbidenUserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47018h = null;
        this.f47019i = null;
        this.f47020m = null;
        this.C = null;
        this.E = true;
        c();
    }

    public QzoneForbidenUserView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f47018h = null;
        this.f47019i = null;
        this.f47020m = null;
        this.C = null;
        this.E = true;
        c();
    }
}
