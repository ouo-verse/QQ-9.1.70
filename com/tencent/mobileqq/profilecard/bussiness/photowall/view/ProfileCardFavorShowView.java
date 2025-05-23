package com.tencent.mobileqq.profilecard.bussiness.photowall.view;

import android.content.Context;
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

@Deprecated
/* loaded from: classes16.dex */
public class ProfileCardFavorShowView extends FrameLayout {
    static IPatchRedirector $redirector_;
    public ImageView mArrowImage;
    public LinearLayout mContentContainer;
    protected Context mContext;
    public ViewGroup mGuideTipsContainer;
    public ViewGroup mRoot;
    private int mTemplateLayout;
    public ViewGroup mTitleBar;
    public TextView mTitleText;

    public ProfileCardFavorShowView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else {
            this.mContentContainer.addView(view);
        }
    }

    public int getChildCountInContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.mContentContainer.getChildCount();
    }

    public LinearLayout getContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.mContentContainer;
    }

    protected int getGuideTipsContainerId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.id.vvp;
    }

    protected int getImageArrowId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return R.id.dcv;
    }

    protected int getLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        int i3 = this.mTemplateLayout;
        if (i3 <= 0) {
            return R.layout.f168336tb;
        }
        return i3;
    }

    protected int getProfileMoreContainerId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return R.id.g0s;
    }

    protected int getRootLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return R.id.root_layout;
    }

    protected int getTitleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return R.id.f164866b64;
    }

    protected int getTitleTextId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return R.id.jj7;
    }

    public View getViewInContainer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (View) iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
        return this.mContentContainer.getChildAt(i3);
    }

    protected void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        LayoutInflater.from(this.mContext).inflate(getLayout(), (ViewGroup) this, true);
        this.mRoot = (LinearLayout) findViewById(getRootLayoutId());
        this.mTitleBar = (ViewGroup) findViewById(getTitleId());
        this.mTitleText = (TextView) findViewById(getTitleTextId());
        this.mArrowImage = (ImageView) findViewById(getImageArrowId());
        this.mContentContainer = (LinearLayout) findViewById(getProfileMoreContainerId());
        this.mGuideTipsContainer = (RelativeLayout) findViewById(getGuideTipsContainerId());
        this.mTitleText.setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary));
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.mContentContainer.removeAllViews();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view);
        } else if (this.mContentContainer.indexOfChild(view) >= 0) {
            this.mContentContainer.removeView(view);
        }
    }

    public void setMarginBottomEnable(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
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

    public void setShowArrow(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        ImageView imageView = this.mArrowImage;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            imageView.setVisibility(i3);
        }
    }

    public void setShowTitle(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        ViewGroup viewGroup = this.mTitleBar;
        if (viewGroup != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            viewGroup.setVisibility(i3);
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        TextView textView = this.mTitleText;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void updateViewHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        ((LinearLayout.LayoutParams) this.mContentContainer.getLayoutParams()).height = i3 + this.mContentContainer.getPaddingTop() + this.mContentContainer.getPaddingBottom();
        invalidate();
    }

    public ProfileCardFavorShowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mTemplateLayout = -1;
        this.mContext = context;
        init();
    }

    public ProfileCardFavorShowView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mContext = context;
        this.mTemplateLayout = i3;
        init();
    }
}
