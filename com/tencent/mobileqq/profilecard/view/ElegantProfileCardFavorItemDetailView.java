package com.tencent.mobileqq.profilecard.view;

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
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.RoundRectImageView;
import mqq.app.MobileQQ;

/* loaded from: classes35.dex */
public class ElegantProfileCardFavorItemDetailView extends LinearLayout {
    private static final int COLOR_FILTER = 1996488704;
    private static final String TAG = "ElegantProfileCardFavorItemDetailView";
    private static final float TOP_MARGIN = 12.0f;
    private Context ctx;
    public RelativeLayout itemLayout;
    public LinearLayout itemLayoutMask;
    private View mContentView;
    public RoundRectImageView mFavorIcon;
    public ImageView mFavorIcon2;
    public RoundRectImageView mItemBgCard;
    public RoundRectImageView mItemBgCardClick;
    public RoundRectImageView mItemBgCardMask;
    public TextView row1Content;
    public TextView row2Content;
    public TextView row3Content;

    public ElegantProfileCardFavorItemDetailView(Context context) {
        super(context);
        this.ctx = context;
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(this.ctx).inflate(R.layout.f167371cz0, (ViewGroup) this, true);
        this.mContentView = inflate;
        this.mFavorIcon = (RoundRectImageView) inflate.findViewById(R.id.ou8);
        this.mItemBgCard = (RoundRectImageView) this.mContentView.findViewById(R.id.ov5);
        this.mItemBgCardMask = (RoundRectImageView) this.mContentView.findViewById(R.id.ov7);
        this.mItemBgCardClick = (RoundRectImageView) this.mContentView.findViewById(R.id.ov6);
        this.mFavorIcon2 = (ImageView) this.mContentView.findViewById(R.id.ou9);
        if (ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.peekAppRuntime())) {
            this.mFavorIcon.setColorFilter(COLOR_FILTER);
        } else {
            this.mFavorIcon.setColorFilter(0);
        }
        this.row1Content = (TextView) this.mContentView.findViewById(R.id.oy5);
        this.row2Content = (TextView) this.mContentView.findViewById(R.id.oy6);
        this.row3Content = (TextView) this.mContentView.findViewById(R.id.oy7);
        this.itemLayout = (RelativeLayout) this.mContentView.findViewById(R.id.ov8);
        this.itemLayoutMask = (LinearLayout) this.mContentView.findViewById(R.id.ov_);
    }

    public void setContent(String str) {
        this.row2Content.setText(str);
    }

    public void setDesc(String str) {
        this.row3Content.setText(str);
    }

    public void setIcon(Drawable drawable) {
        this.mFavorIcon.setImageDrawable(drawable);
    }

    public void setNeedTopMargin(boolean z16) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = z16 ? Utils.n(TOP_MARGIN, getResources()) : 0;
            this.mContentView.setLayoutParams(layoutParams);
        }
    }

    public void setTitle(String str) {
        this.row1Content.setText(str);
    }

    public ElegantProfileCardFavorItemDetailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ctx = context;
        init();
    }
}
