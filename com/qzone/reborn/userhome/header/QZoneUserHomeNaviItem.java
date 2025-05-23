package com.qzone.reborn.userhome.header;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.reborn.userhome.header.QZoneUserHomeNaviItem;
import com.qzone.util.l;
import com.qzone.widget.ScrollingNumTextView;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneUserHomeNaviItem extends FrameLayout {
    private volatile boolean C;

    /* renamed from: d, reason: collision with root package name */
    private TextView f59526d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f59527e;

    /* renamed from: f, reason: collision with root package name */
    private View f59528f;

    /* renamed from: h, reason: collision with root package name */
    private ScrollingNumTextView f59529h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f59530i;

    /* renamed from: m, reason: collision with root package name */
    private String f59531m;

    public QZoneUserHomeNaviItem(Context context) {
        this(context, null);
    }

    private void g() {
        LayoutInflater.from(getContext()).inflate(R.layout.coc, (ViewGroup) this, true);
        this.f59526d = (TextView) findViewById(R.id.ncq);
        this.f59527e = (TextView) findViewById(R.id.ncr);
        this.f59528f = findViewById(R.id.ncs);
        this.f59529h = (ScrollingNumTextView) findViewById(R.id.nct);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(ScaleAnimation scaleAnimation) {
        this.f59529h.setSingleNumDuration(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_USERHOME_NEW_VISITOR_ANIMATION_SINGLE_FRAME_DURANTION, 200L));
        this.f59529h.r();
        this.f59529h.setVisibility(0);
        this.f59529h.startAnimation(scaleAnimation);
    }

    private void k() {
        if (this.C) {
            return;
        }
        this.C = true;
        if (this.f59529h.getVisibility() != 0 && !this.f59529h.q()) {
            final ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.0f, 1, 1.0f);
            scaleAnimation.setDuration(300L);
            scaleAnimation.setAnimationListener(new a());
            this.f59529h.postDelayed(new Runnable() { // from class: mo.p
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneUserHomeNaviItem.this.h(scaleAnimation);
                }
            }, 500L);
            return;
        }
        if (TextUtils.equals(this.f59529h.getText(), this.f59531m)) {
            return;
        }
        this.f59531m = this.f59529h.getText().toString();
        this.f59529h.s(true);
    }

    public void d() {
        this.f59528f.setVisibility(8);
        this.f59529h.setVisibility(8);
    }

    public boolean f() {
        return this.f59528f.getVisibility() == 0 || this.f59529h.getVisibility() == 0;
    }

    public void j() {
        if (this.f59530i) {
            this.f59529h.setVisibility(0);
            k();
        } else {
            this.f59528f.setVisibility(0);
        }
    }

    public void setCount(int i3) {
        this.f59526d.setText(i(i3));
    }

    public void setDefaultTextColor() {
        setTextColor(getContext().getColor(R.color.qui_common_text_secondary), getContext().getColor(R.color.qui_common_text_primary));
    }

    public void setName(int i3) {
        this.f59527e.setText(getContext().getResources().getText(i3));
    }

    public void setRedDotNum(int i3) {
        if (this.f59530i) {
            this.f59529h.setTextString(e(i3));
        }
    }

    public void setShowRedDotInNumStyle(boolean z16) {
        this.f59530i = z16;
    }

    public void setTextColor(int i3, int i16) {
        this.f59527e.setTextColor(i3);
        this.f59526d.setTextColor(i16);
    }

    public QZoneUserHomeNaviItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QZoneUserHomeNaviItem(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public QZoneUserHomeNaviItem(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f59530i = false;
        this.f59531m = "";
        this.C = false;
        g();
    }

    private static String e(int i3) {
        if (i3 > 99) {
            return "99+";
        }
        return String.valueOf(i3);
    }

    public static String i(long j3) {
        if (j3 < 0) {
            return String.valueOf(0);
        }
        if (j3 <= 99999) {
            return String.valueOf(j3);
        }
        if (j3 >= JsonGrayBusiId.UI_RESERVE_100000_110000 && j3 <= 99999999) {
            return ((int) Math.floor(j3 / 10000)) + l.a(R.string.ty7);
        }
        return String.format("%.1f", Double.valueOf((j3 * 1.0d) / 1.0E8d)) + l.a(R.string.ty6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QZoneUserHomeNaviItem.this.C = false;
            QZoneUserHomeNaviItem.this.f59529h.s(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
