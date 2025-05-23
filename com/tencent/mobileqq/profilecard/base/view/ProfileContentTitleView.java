package com.tencent.mobileqq.profilecard.base.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ProfileContentTitleView extends FrameLayout {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileContentTitleView";
    public FrameLayout mContentContainer;
    protected Context mContext;
    public ViewGroup mRoot;
    public ImageView mTitleArrow;
    public ViewGroup mTitleContainer;
    public ViewGroup mTitleExtContainer;
    public ImageView mTitleIcon;
    public TextView mTitleText;
    public ViewGroup mTitleTextBg;

    public ProfileContentTitleView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void addContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
            return;
        }
        FrameLayout frameLayout = this.mContentContainer;
        if (frameLayout != null) {
            if (frameLayout.getChildCount() > 0) {
                QLog.e(TAG, 1, "addContentView add fail, already exit.");
            } else {
                this.mContentContainer.addView(view);
            }
        }
    }

    public View getContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (View) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        FrameLayout frameLayout = this.mContentContainer;
        if (frameLayout != null) {
            return frameLayout.getChildAt(0);
        }
        return null;
    }

    public ImageView getIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ImageView) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mTitleIcon;
    }

    public int getLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.f168391fs1;
    }

    public TextView getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TextView) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mTitleText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(getLayoutId(), (ViewGroup) this, true);
        this.mRoot = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.mTitleContainer = (ViewGroup) inflate.findViewById(R.id.title_container);
        this.mTitleIcon = (ImageView) inflate.findViewById(R.id.joy);
        this.mTitleText = (TextView) inflate.findViewById(R.id.f166992jq2);
        this.mTitleTextBg = (ViewGroup) inflate.findViewById(R.id.f98905oc);
        this.mTitleArrow = (ImageView) inflate.findViewById(R.id.f98225mi);
        this.mTitleExtContainer = (RelativeLayout) inflate.findViewById(R.id.f98445n4);
        this.mContentContainer = (FrameLayout) inflate.findViewById(R.id.b9t);
        setIconVisible(false);
    }

    public void removeContentViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        FrameLayout frameLayout = this.mContentContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    public void setArrowEnable(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        ImageView imageView = this.mTitleArrow;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    public void setClickBgArea(boolean z16) {
        Context context;
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        if (this.mTitleContainer != null && this.mContentContainer != null && (context = this.mContext) != null && context.getResources() != null) {
            ViewGroup viewGroup = this.mTitleContainer;
            Drawable drawable2 = null;
            if (z16) {
                drawable = null;
            } else {
                drawable = this.mContext.getResources().getDrawable(R.drawable.f161824ku1);
            }
            viewGroup.setBackground(drawable);
            ViewGroup viewGroup2 = this.mRoot;
            if (z16) {
                drawable2 = this.mContext.getResources().getDrawable(R.drawable.f161824ku1);
            }
            viewGroup2.setBackground(drawable2);
        }
    }

    public void setContentContainerMarginBottomEnable(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        if (this.mContentContainer != null) {
            if (z16) {
                i3 = getResources().getDimensionPixelSize(R.dimen.cyf);
            } else {
                i3 = 0;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContentContainer.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.bottomMargin = i3;
                this.mContentContainer.setLayoutParams(layoutParams);
            }
        }
    }

    public void setHorizontalMarginEnable(boolean z16) {
        LinearLayout.LayoutParams layoutParams;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        FrameLayout frameLayout = this.mContentContainer;
        if (frameLayout == null || (layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams()) == null) {
            return;
        }
        if (z16) {
            i3 = ViewUtils.dpToPx(15.0f);
        } else {
            i3 = 0;
        }
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        this.mContentContainer.setLayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
            return;
        }
        ImageView imageView = this.mTitleIcon;
        if (imageView != null) {
            imageView.setBackgroundDrawable(drawable);
        }
    }

    public void setIconSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        ImageView imageView = this.mTitleIcon;
        if (imageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = i3;
        layoutParams.width = i3;
    }

    public void setIconVisible(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        ImageView imageView = this.mTitleIcon;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    public void setMarginBottomEnable(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        if (this.mRoot != null) {
            if (z16) {
                i3 = getResources().getDimensionPixelSize(R.dimen.f159310a02);
            } else {
                i3 = 0;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRoot.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.bottomMargin = i3;
                this.mRoot.setLayoutParams(layoutParams);
            }
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        TextView textView = this.mTitleText;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitleBackground(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) drawable);
            return;
        }
        ViewGroup viewGroup = this.mTitleContainer;
        if (viewGroup != null) {
            viewGroup.setBackgroundDrawable(drawable);
        }
    }

    public void updateViewHeight(int i3) {
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        FrameLayout frameLayout = this.mContentContainer;
        if (frameLayout == null || (layoutParams = frameLayout.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = i3 + this.mContentContainer.getPaddingTop() + this.mContentContainer.getPaddingBottom();
        invalidate();
    }

    public ProfileContentTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.mContext = context;
            init();
        }
    }
}
