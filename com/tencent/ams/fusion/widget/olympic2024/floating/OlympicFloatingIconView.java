package com.tencent.ams.fusion.widget.olympic2024.floating;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ams.fusion.widget.base.NetworkImageView;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OlympicFloatingIconView extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    private static final String AD_TAG = "iVBORw0KGgoAAAANSUhEUgAAAEAAAAAgCAYAAACinX6EAAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAX1SURBVHgB7VjJTyRVGH9VTTdLszTrDDM4IBJaNsPmDSOZmyJ6UDImGIch/gcmZi4mEGNCJmpiYjzMlYQDRGASPaAXxMAEIyRkFC4QcECWAGHfeqny96t+r9O0zkA32Gqmv+SXr+q9V2/59ldCxClOcYrTM0yauEQyTdOaT9M09S7Uu3w2Vd/T5njSGDPQKS6TdHEx0iQ4jyZJb2xstO3v79/0er13Dg4ObqLPpvo6Ojr0kO+sb6XgrD6O4fjt7e1ij8dzx+fztaE9dPylUrQTBjc0NzdXzAZsVsNhLYHi4Fptbe09h8PxBtq/nZyc/Mhut5sE2izgYFtut3sLwtKGh4c1wzB+wOELV1dXb+Xn5z9aW1t7JS8vb8haTNOSwfyAKSHU8z9hFWeS1GIC4MDGF8wo6OTkpLuoqCiJmJiYKFPtENhPEo9C2yDUEQKC+1HigdyDsqCYERez8fCA0+/3/y43uRgOHHIpvA0bf0zAWr7G92ldXV03jo6OvjMjJAoe3yfCghLEBVwjQURJBQUFtqWlJbuS/tDQ0N3m5uafExMTqd1wnzXQ7oepGsfHx36n0+mFAHxot7e2tr6ZlJT0OoTzx/j4+Kebm5v7nLO0tLSsoqLiLj8eGBi4DffxJycn+wjOBdpElw73MRgjAA41RQxIWYATyKU2qZH+/v738e7G5krAXwCK8Wxx4HmgCAe9gQNcx/PVtLS0HPCcmZmZ2xDGw87Ozlfx/iLiQwV4VXd39wdK23xnn5zvBnANyAZSy8vLaYlRu0G0FqDn5uZq6+vrOkxRs9lsAqCWvdC+F/3ULtvIgkEL2uezQezt7ZHboMGZ4uLiL6urq5+DEAshUJ0oKysrVYv19PS8DOFR85b2aQUpKSm+qampX9ra2tZFQCmGiBFxMXtOTk4a+FX6NbUEF3gX79RuLpABpMsxCumSO69cueKUfZkbGxv3zChpfn7+NcyRKAIWGVML+AvBR6kBD3BcUlLimZ2dNQoLCwWBKH9qLFKclfezsrI0BMDHwEOaMK2J/fL5VI2i67qBGGKCM+1ZQK2wK7tjlwWkr1kWgGAWtICRkZF30J6N4MicrTRyCvJbraWlRWWRVCCXsQGcscMNlAGVEGg1eI0EY0AFzN8txxXBBfLBXUDyRTJBxBagig6YroAAgu3wdzM9Pd3yd0Rkk3jSt729vUZ9fb1Oy0hNTRXLy8v3cbjK0EAW+kxth85Da0DBdL+qquqrnZ0dZTUiVgWRVldXZxcBfw5awOjo6NsQQBbaksTZJTZ3msBYAJ5zeHg4ZkZIKysrn3M9aXEJphldBoz4LsCF4LPBHA9TLSCnP1JTqOyEzMlPnSbkOai2sbGxjzHHS7CGKvBKySv4zHYC8eOBGr+7u6uhHjh1AYuUIhYAbzSs+/mINPgh2xCwdpuamn6DOYqFhYW/Nf/waeC3VjCEC2hhOZzfsu73YR0P0x7TH9t4hwgOkvEk5JuoKKosgAhvLZ6ZmXmL79D+99wE3o2tra1zbQb53+K4NQYPX1NT8x7mektFfNXOwypAYG7VjmJKwBUEgqro6+sTMSF5EaKfu1gFQkm/tre3V+I9TwTigv0c/mjFAMCJA+WxEjQjJATOL2Q1GZp1IqaILSDUvxcXFz9DKfoNYgJN1ouA5EMNcJ7rqXWVRRCkGxiDg4OfIK1lw5915nnW/eQcSM7KkDUCboNWacmqE642y2oSV2etoaGBFhCVG0QjNRsOmQBTdUD7dgQiWoQlAAjDMz09TX89qyxV/utwuVxJmCcFB3SgVFYKMcLm0BAHdHnJEnK9I7jcUXZ29jFc0itiXQqLgBswjdHsU4QsSc+bjqQrcR4WQ1ksqmAFvORcl/ya4gq4AzDjXKPbZGRkZHJdFkFmLP8HyMV0WQuwmnPIZ1skG5FjVUWYgrI4HdbAyo4Hc0G7GfLdpbgCx4qA0B2RrnuZRA2qf3zqP18kpMlvKQQ7r7VwrUT+IRIB6woirJ2WZpflb9TB779EVnoLEeQphAo4TNj/+4PHKU5x+vfpT3qeCVT10CGSAAAAAElFTkSuQmCC";
    private static final String CLOSE_IMAGE_DATA = "iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAYAAADhAJiYAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAJKADAAQAAAABAAAAJAAAAAAqDuP8AAADX0lEQVRYCb2Yy08TURTGAalYbXwmis/EhHTRxNiNCSaybrpySdixhUX/DPe4ILpjRyCEFYQFYaU7FxBjXAgL07QRNL4CpFCq8fsNvc106L0zYx8n+Xpn5p577tdzzpyZM/198WVIS24IKeGKMFiHhr6acCwcCb+E7/VzDdGkP5qap3VLvwASceRQymVhL8qiKIQgkBYuRDHo0MFrRcFJ7JzDAKF4KIwIHLcr2CDUCWFf+CucEZuH8EZGuHRmRWcu4K33AvnWJK08BJlHwsUmzc6eGG+R9H/8poOEUHwstJsv/j1sx+x1VfgmNMIXJETOXBN6Jee1ERx+mg0HzIFGbuk7vvNeHbJno5T4CT3oFYMW+1BWPDGE8E5o3iwsLDybnJwcrq8NHUZHR1OsCVU83RsOXvwYYUg8rTI/Pz82Pj7+IpfLjZXL5TdbW1sHVmVNQHxxcfFVNpt9nk6nd5aXlymKLiHJ9/AQnuG55JSZmZnNSqWym0wmh2dnZ1+6PMUcOuiyZn19fdtp/HSSPBoiw28K10+v2X9LpVIVz+AhNrJ5Kkhmenq6MDc3t2u33DRzBKH7QqQiSJhcpNokA7MTCN0TnPmDphEbKeVKyh+mmJ4x5gd5lj0VSKhYEvQGi03O/CcZTNTwENU5tgQ9lUgkUiRwG2TgMGDqUGxC3VqAh+7CLO4GwZDVarUD190X0b4XsttSjpVDQTKEaXV1dS2sJEQgVcFDFMXQwmiMtSJDnQnmlK1OGTuWcR9CdBGhhREDNjLMIR0g9QVCJwJ55JQwMmZxK1IbGxtrVHqj4xh3SGbeb387lLypfD4/ErXOEELyyjz7CoVCNsy+5mmXjvGQEToCqywtLRUzmcz21NTU65WVlR9WxfqE8VS1Wt2cmJh4G6av+c/Cob/reKILoe9E0umGEKV3GPbXn0/d2CmizaLR84eMHol6dNlM9mikzS6Zvfwe4hpMSa5eCaFqeIdN/R7inP6IloQEj1W9pR9XIEP3StlpSJAQE3xS4S7qJimi8EGI1EpLzyP1VSMh7XROkTPcQE2e0bknrTxk5kz4+Bd8dGg3hIToo8D7daN11nGT+OtQ00SLE9PZRn4Q123wJQ1vO78Lmf3iEDJrKJ48jGlbOAbGe+Qf4FFE3xb7k94/rf6XEYTt3tIAAAAASUVORK5CYII=";
    private static final int DEFAULT_BOTTOM_MARGIN_DP = 108;
    private static final String TAG = "OlympicFloatingIconView";
    private int mBottomMargin;
    private ImageView mCloseView;
    private NetworkImageView mExpandView;
    private int mExpandViewBottomMargin;
    private NetworkImageView mFoldView;
    private int mFoldViewBottomMargin;
    private View mTagView;
    private OnViewClickListener mViewClickListener;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnViewClickListener {
        void onClick(int i3);
    }

    public OlympicFloatingIconView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            setGravity(85);
            init(context);
        }
    }

    private void addCloseView(Context context) {
        ImageView imageView = new ImageView(context);
        int dp2px = (int) Utils.dp2px(7.0f);
        imageView.setPadding(dp2px, dp2px, dp2px, dp2px);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int dp2px2 = (int) Utils.dp2px(32.0f);
        imageView.setImageBitmap(Utils.bitmapFromBase64StringSafe(CLOSE_IMAGE_DATA, dp2px2, dp2px2));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingIconView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicFloatingIconView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (OlympicFloatingIconView.this.mViewClickListener != null) {
                    OlympicFloatingIconView.this.mViewClickListener.onClick(2);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp2px2, dp2px2);
        layoutParams.gravity = 5;
        addView(imageView, layoutParams);
        this.mCloseView = imageView;
    }

    private void addExpandView(Context context) {
        int dp2px = (int) Utils.dp2px(120.0f);
        NetworkImageView networkImageView = new NetworkImageView(context);
        addView(networkImageView, new LinearLayout.LayoutParams(dp2px, dp2px));
        networkImageView.setVisibility(8);
        networkImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingIconView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicFloatingIconView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (OlympicFloatingIconView.this.mViewClickListener != null) {
                    OlympicFloatingIconView.this.mViewClickListener.onClick(3);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mExpandView = networkImageView;
    }

    private void addFoldView(Context context) {
        int dp2px = (int) Utils.dp2px(32.0f);
        int dp2px2 = (int) Utils.dp2px(120.0f);
        NetworkImageView networkImageView = new NetworkImageView(context);
        addView(networkImageView, new LinearLayout.LayoutParams(dp2px, dp2px2));
        networkImageView.setVisibility(8);
        networkImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingIconView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicFloatingIconView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (OlympicFloatingIconView.this.mViewClickListener != null) {
                    OlympicFloatingIconView.this.mViewClickListener.onClick(4);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mFoldView = networkImageView;
    }

    private void addTagView(Context context) {
        int dp2px = (int) Utils.dp2px(32.0f);
        int dp2px2 = (int) Utils.dp2px(16.0f);
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(Utils.bitmapFromBase64StringSafe(AD_TAG, dp2px, dp2px2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp2px, dp2px2);
        layoutParams.bottomMargin = (int) Utils.dp2px(108.0f);
        addView(imageView, layoutParams);
        this.mTagView = imageView;
    }

    private void animShowExpand() {
        NetworkImageView networkImageView = this.mExpandView;
        if (networkImageView != null && networkImageView.getVisibility() == 0) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", Utils.dp2px(120.0f), 0.0f);
        try {
            ofFloat.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f));
        } catch (Throwable unused) {
        }
        ofFloat.setDuration(300L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingIconView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicFloatingIconView.this);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                    return;
                }
                if (OlympicFloatingIconView.this.mExpandViewBottomMargin > 0) {
                    OlympicFloatingIconView olympicFloatingIconView = OlympicFloatingIconView.this;
                    olympicFloatingIconView.setViewBottomMargin(olympicFloatingIconView.mTagView, OlympicFloatingIconView.this.mExpandViewBottomMargin);
                } else if (OlympicFloatingIconView.this.mBottomMargin > 0) {
                    OlympicFloatingIconView olympicFloatingIconView2 = OlympicFloatingIconView.this;
                    olympicFloatingIconView2.setViewBottomMargin(olympicFloatingIconView2.mTagView, OlympicFloatingIconView.this.mBottomMargin + ((int) Utils.dp2px(108.0f)));
                }
                if (OlympicFloatingIconView.this.mExpandView != null) {
                    OlympicFloatingIconView.this.mExpandView.setVisibility(0);
                }
                if (OlympicFloatingIconView.this.mFoldView != null) {
                    OlympicFloatingIconView.this.mFoldView.setVisibility(8);
                }
            }
        });
        ofFloat.start();
    }

    private void animShowFold() {
        NetworkImageView networkImageView = this.mFoldView;
        if (networkImageView != null && networkImageView.getVisibility() == 0) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", 0.0f, Utils.dp2px(120.0f));
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingIconView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicFloatingIconView.this);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                    return;
                }
                if (OlympicFloatingIconView.this.mExpandView != null) {
                    OlympicFloatingIconView.this.mExpandView.setVisibility(8);
                }
                if (OlympicFloatingIconView.this.mFoldView != null) {
                    OlympicFloatingIconView.this.mFoldView.setVisibility(0);
                }
                if (OlympicFloatingIconView.this.mFoldViewBottomMargin > 0) {
                    OlympicFloatingIconView olympicFloatingIconView = OlympicFloatingIconView.this;
                    olympicFloatingIconView.setViewBottomMargin(olympicFloatingIconView.mTagView, OlympicFloatingIconView.this.mFoldViewBottomMargin);
                } else if (OlympicFloatingIconView.this.mBottomMargin > 0) {
                    OlympicFloatingIconView olympicFloatingIconView2 = OlympicFloatingIconView.this;
                    olympicFloatingIconView2.setViewBottomMargin(olympicFloatingIconView2.mTagView, OlympicFloatingIconView.this.mBottomMargin + ((int) Utils.dp2px(108.0f)));
                } else {
                    OlympicFloatingIconView olympicFloatingIconView3 = OlympicFloatingIconView.this;
                    olympicFloatingIconView3.setViewBottomMargin(olympicFloatingIconView3.mTagView, (int) Utils.dp2px(108.0f));
                }
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "translationX", Utils.dp2px(32.0f), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat2).after(ofFloat);
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    private void init(Context context) {
        setOrientation(1);
        addCloseView(context);
        addExpandView(context);
        addFoldView(context);
        addTagView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewBottomMargin(View view, int i3) {
        Logger.d(TAG, "setViewBottomMargin: " + i3);
        if (view != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.bottomMargin = i3;
                Logger.d(TAG, "setViewBottomMargin success: " + i3);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public void expand() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            animShowExpand();
        }
    }

    public void fold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            animShowFold();
        }
    }

    public void setBottomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        Logger.d(TAG, "setBottomMargin: " + i3);
        this.mBottomMargin = i3;
    }

    public void setExpandViewBottomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        Logger.d(TAG, "setExpandViewBottomMargin: " + i3);
        this.mExpandViewBottomMargin = i3;
    }

    public void setFoldViewBottomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        Logger.d(TAG, "setFoldViewBottomMargin: " + i3);
        this.mFoldViewBottomMargin = i3;
    }

    public void setIconImage(Bitmap bitmap, Bitmap bitmap2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bitmap, (Object) bitmap2);
            return;
        }
        NetworkImageView networkImageView = this.mExpandView;
        if (networkImageView != null) {
            networkImageView.setImageBitmap(bitmap);
        }
        NetworkImageView networkImageView2 = this.mFoldView;
        if (networkImageView2 != null) {
            networkImageView2.setImageBitmap(bitmap2);
        }
    }

    public void setIconPath(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        NetworkImageView networkImageView = this.mExpandView;
        if (networkImageView != null) {
            networkImageView.setSrc(str);
        }
        NetworkImageView networkImageView2 = this.mFoldView;
        if (networkImageView2 != null) {
            networkImageView2.setSrc(str2);
        }
    }

    public void setViewClickListener(OnViewClickListener onViewClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onViewClickListener);
        } else {
            this.mViewClickListener = onViewClickListener;
        }
    }
}
