package com.tencent.mobileqq.qqpermission.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes17.dex */
public class PermissionRequestView extends FrameLayout {
    static IPatchRedirector $redirector_ = null;
    public static final int SCENE_FULL_SCREEN = 1;
    public static final int SCENE_HALF_SCREEN = 2;
    private TextView mContentTv;
    private ImageView mIconIv;
    private Button mSettingBigBtn;
    private Button mSettingBtn;
    private View.OnClickListener mSettingClickListener;
    private Button mSettingSmallBtn;
    private TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PermissionRequestView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (PermissionRequestView.this.mSettingClickListener != null) {
                PermissionRequestView.this.mSettingClickListener.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public PermissionRequestView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void setMarginTop(View view, int i3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i3;
        view.setLayoutParams(layoutParams);
    }

    public void initViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mIconIv = (ImageView) findViewById(R.id.f2405083);
        this.mTitleTv = (TextView) findViewById(R.id.f2408086);
        this.mContentTv = (TextView) findViewById(R.id.f2404082);
        this.mSettingBigBtn = (Button) findViewById(R.id.f2406084);
        this.mSettingSmallBtn = (Button) findViewById(R.id.f2407085);
        a aVar = new a();
        this.mSettingBigBtn.setOnClickListener(aVar);
        this.mSettingSmallBtn.setOnClickListener(aVar);
        this.mSettingBigBtn.setVisibility(8);
        this.mSettingSmallBtn.setVisibility(0);
        this.mSettingBtn = this.mSettingSmallBtn;
        setScene(2);
    }

    public void setContent(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            this.mContentTv.setText(charSequence);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) charSequence);
        }
    }

    public void setIcon(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.mIconIv.setImageDrawable(drawable);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable);
        }
    }

    public void setOnSettingClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) onClickListener);
        } else {
            this.mSettingClickListener = onClickListener;
        }
    }

    public void setScene(int i3) {
        float dpToPx;
        float dpToPx2;
        float dpToPx3;
        int dpToPx4;
        int dpToPx5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            dpToPx = ViewUtils.dpToPx(8.0f);
            dpToPx2 = ViewUtils.dpToPx(7.5f);
            dpToPx3 = ViewUtils.dpToPx(16.0f);
            dpToPx4 = ViewUtils.dpToPx(176.0f);
            dpToPx5 = ViewUtils.dpToPx(132.0f);
            this.mSettingSmallBtn.setVisibility(this.mSettingBtn.getVisibility());
            this.mSettingBigBtn.setVisibility(8);
            this.mSettingBtn = this.mSettingSmallBtn;
        } else {
            dpToPx = ViewUtils.dpToPx(12.0f);
            dpToPx2 = ViewUtils.dpToPx(8.0f);
            dpToPx3 = ViewUtils.dpToPx(16.0f);
            dpToPx4 = ViewUtils.dpToPx(256.0f);
            dpToPx5 = ViewUtils.dpToPx(192.0f);
            this.mSettingBigBtn.setVisibility(this.mSettingBtn.getVisibility());
            this.mSettingSmallBtn.setVisibility(8);
            this.mSettingBtn = this.mSettingBigBtn;
        }
        setMarginTop(this.mTitleTv, (int) dpToPx);
        setMarginTop(this.mContentTv, (int) dpToPx2);
        setMarginTop(this.mSettingBtn, (int) dpToPx3);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mIconIv.getLayoutParams();
        layoutParams.width = dpToPx4;
        layoutParams.height = dpToPx5;
        this.mIconIv.setLayoutParams(layoutParams);
    }

    public void setTitle(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.mTitleTv.setText(charSequence);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) charSequence);
        }
    }

    public void showButton(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        Button button = this.mSettingBtn;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        button.setVisibility(i3);
    }

    public void showContent(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        TextView textView = this.mContentTv;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    public void showIcon(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        ImageView imageView = this.mIconIv;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public void showTitle(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        TextView textView = this.mTitleTv;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    public PermissionRequestView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public void setContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.mContentTv.setText(i3);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
    }

    public void setIcon(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.mIconIv.setImageResource(i3);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
    }

    public void setTitle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.mTitleTv.setText(i3);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
    }

    public PermissionRequestView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            LayoutInflater.from(context).inflate(R.layout.gzj, this);
            initViews();
        }
    }
}
