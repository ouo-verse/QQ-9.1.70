package com.tencent.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.util.ab;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.QQUIAppSetting;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

/* loaded from: classes27.dex */
public class PopupMenuDialog extends BasePopupMenuDialog implements Animation.AnimationListener, View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PopupMenuDialog";
    private Activity activity;
    private View mDimView;
    private WindowManager.LayoutParams mDimViewLp;
    private MenuItem mLastClkItem;
    private int mMaxAvailableHeight;
    private boolean mNeedLine;
    public boolean mNeedRebuild;
    private OnClickActionListener mOnClickActionListener;
    private OnDismissListener mOnDismissListener;
    private Animation mOutAnimation;
    private int mTotalPopHeight;

    /* loaded from: classes27.dex */
    public static class MenuItem {
        static IPatchRedirector $redirector_;
        public String contentDescription;
        public BitmapDrawable danceDrawable;
        public Drawable drawable;
        public int iconId;

        /* renamed from: id, reason: collision with root package name */
        public int f384641id;
        public LinearLayout itemView;
        public URLDrawable netDrawable;
        public String title;
        public String titleColor;
        public int titleColorRes;
        public float titleSize;
        public String url;

        public MenuItem() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public MenuItem(int i3, String str, String str2, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16));
                return;
            }
            this.f384641id = i3;
            this.title = str;
            this.contentDescription = str2;
            this.iconId = i16;
        }
    }

    /* loaded from: classes27.dex */
    public interface OnClickActionListener {
        void onClickAction(MenuItem menuItem);
    }

    /* loaded from: classes27.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PopupMenuDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (PopupMenuDialog.this.isShowing()) {
                PopupMenuDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class b extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PopupMenuDialog.this);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        @TargetApi(14)
        public void sendAccessibilityEvent(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            } else if (i3 != 32) {
                super.sendAccessibilityEvent(view, i3);
            }
        }
    }

    PopupMenuDialog(Activity activity, View view, int i3, int i16, boolean z16) {
        super(view, i3, i16, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, view, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        this.mNeedRebuild = false;
        this.mLastClkItem = null;
        this.mMaxAvailableHeight = 0;
        this.mTotalPopHeight = 0;
        this.mNeedLine = false;
        this.activity = activity;
        initDimView();
    }

    public static PopupMenuDialog build(Activity activity, List<MenuItem> list) {
        return build(activity, list, null, null);
    }

    public static PopupMenuDialog conversationPlusBuild(Activity activity, List<MenuItem> list, OnClickActionListener onClickActionListener, OnDismissListener onDismissListener) {
        if (list != null && list.size() != 0) {
            int i3 = get800UIDesiredHeight(activity, list.size());
            PopupMenuDialog popupMenuDialog = new PopupMenuDialog(activity, prepareConversationPlusContent(activity, list), BasePopupMenuDialog.getScaledPixelSize(activity, R.dimen.au6), i3, true);
            popupMenuDialog.setAnimationStyle(R.style.f173310t);
            popupMenuDialog.setBackgroundDrawable(new ColorDrawable(0));
            popupMenuDialog.setOutsideTouchable(false);
            BasePopupMenuDialog.setWindowType(popupMenuDialog, 1002);
            popupMenuDialog.initListeners(popupMenuDialog.getContentView());
            popupMenuDialog.mTotalPopHeight = i3;
            popupMenuDialog.mOnClickActionListener = onClickActionListener;
            popupMenuDialog.mOnDismissListener = onDismissListener;
            popupMenuDialog.mNeedLine = false;
            return popupMenuDialog;
        }
        throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }

    private static void createAndAttachItemsView(Activity activity, List<MenuItem> list, LinearLayout linearLayout) {
        createAndAttachItemsView(activity, list, linearLayout, false);
    }

    public static final int dp2px(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static int get800UIDesiredHeight(Context context, int i3) {
        return (i3 * dp2px(52.0f, context.getResources())) + dp2px(10.0f, context.getResources()) + getBgPadding();
    }

    private static int getBgPadding() {
        return ViewUtils.dip2px(12.5f);
    }

    private static int getDesiredHeight(Context context, int i3, boolean z16) {
        return (i3 * BasePopupMenuDialog.getScaledPixelSize(context, R.dimen.aub)) + dp2px(10.0f, context.getResources()) + getBgPadding();
    }

    private void initDimView() {
        int i3;
        int height;
        if (this.mDimViewLp == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.mDimViewLp = layoutParams;
            layoutParams.type = 1000;
            layoutParams.format = -3;
            layoutParams.flags = 40;
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                this.mDimViewLp.flags |= 67108864;
            }
            int i16 = -1;
            this.mDimViewLp.width = -1;
            if (this.activity.getWindow() != null && this.activity.getWindow().getDecorView() != null && (height = this.activity.getWindow().getDecorView().getHeight()) > 0) {
                i16 = height;
            }
            WindowManager.LayoutParams layoutParams2 = this.mDimViewLp;
            layoutParams2.height = i16;
            layoutParams2.windowAnimations = R.style.f173628ho;
        }
        if (this.mDimView == null) {
            View view = new View(this.activity);
            this.mDimView = view;
            Resources resources = this.activity.getResources();
            if (QQTheme.isNowThemeIsNight()) {
                i3 = R.color.f156942fw;
            } else {
                i3 = R.color.f156934fo;
            }
            view.setBackgroundColor(resources.getColor(i3));
            this.mDimView.setContentDescription(HardCodeUtil.qqStr(R.string.paq));
            this.mDimView.setOnClickListener(new a());
        }
        if (QQUIAppSetting.enableTalkBack()) {
            getContentView().setAccessibilityDelegate(new b());
        }
    }

    private void initListeners(View view) {
        if (view.getTag() != null && (view.getTag() instanceof MenuItem)) {
            view.setOnClickListener(this);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                initListeners(viewGroup.getChildAt(i3));
            }
        }
    }

    public static final boolean is8973RecentOptPopBarTokenEnable() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101076", true);
    }

    private static View prepareContent(Activity activity, List<MenuItem> list, boolean z16, int i3) {
        View view;
        String str;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.bwf, (ViewGroup) null);
        BounceScrollView bounceScrollView = (BounceScrollView) inflate.findViewById(R.id.adr);
        Drawable background = bounceScrollView.getBackground();
        if (background != null) {
            background.setColorFilter(new LightingColorFilter(0, inflate.getResources().getColor(R.color.qui_common_bg_top_light)));
        }
        LinearLayout linearLayout = (LinearLayout) bounceScrollView.findViewById(R.id.content);
        bounceScrollView.setVerticalScrollBarEnabled(false);
        bounceScrollView.setOverScrollMode(2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BasePopupMenuDialog.getScaledPixelSize(activity, R.dimen.aub));
        for (int i16 = 0; i16 < list.size(); i16++) {
            MenuItem menuItem = list.get(i16);
            if (z16 && i16 != 0 && i16 != list.size() - 1) {
                view = BasePopupMenuDialog.createLineView(activity);
            } else {
                view = null;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.bwd, (ViewGroup) null);
            linearLayout2.setBackgroundResource(R.drawable.jju);
            ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.di9);
            TextView textView = (TextView) linearLayout2.findViewById(R.id.jjk);
            URLDrawable uRLDrawable = menuItem.netDrawable;
            if (uRLDrawable != null) {
                imageView.setImageDrawable(uRLDrawable);
            } else {
                BitmapDrawable bitmapDrawable = menuItem.danceDrawable;
                if (bitmapDrawable != null) {
                    imageView.setImageDrawable(bitmapDrawable);
                } else {
                    Drawable drawable = menuItem.drawable;
                    if (drawable != null) {
                        imageView.setImageDrawable(drawable);
                    } else {
                        imageView.setImageResource(menuItem.iconId);
                    }
                }
            }
            if (menuItem.iconId == 0 && menuItem.drawable == null) {
                imageView.setVisibility(8);
                linearLayout2.setPadding(0, 0, 0, 0);
            }
            textView.setText(menuItem.title);
            textView.setTextColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.qui_common_text_primary));
            float f16 = menuItem.titleSize;
            if (f16 > 0.0f) {
                textView.setTextSize(f16);
            }
            if (ab.a() && QQUIAppSetting.enableTalkBack()) {
                if (TextUtils.isEmpty(menuItem.contentDescription)) {
                    str = menuItem.title;
                } else {
                    str = menuItem.contentDescription;
                }
                AccessibilityUtil.c(linearLayout2, str, Button.class.getName());
            }
            if (view != null) {
                linearLayout.addView(view);
            }
            linearLayout2.setTag(menuItem);
            int i17 = menuItem.f384641id;
            if (i17 > 0) {
                linearLayout2.setId(i17);
            }
            linearLayout.addView(linearLayout2, layoutParams);
        }
        return inflate;
    }

    private static View prepareConversationPlusContent(Activity activity, List<MenuItem> list) {
        Drawable background;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.bwf, (ViewGroup) null);
        BounceScrollView bounceScrollView = (BounceScrollView) inflate.findViewById(R.id.adr);
        bounceScrollView.setVerticalScrollBarEnabled(false);
        bounceScrollView.setOverScrollMode(2);
        if (is8973RecentOptPopBarTokenEnable() && (background = bounceScrollView.getBackground()) != null) {
            background.setColorFilter(new LightingColorFilter(0, inflate.getResources().getColor(R.color.qui_common_bg_top_light)));
        }
        createAndAttachItemsView(activity, list, (LinearLayout) bounceScrollView.findViewById(R.id.content));
        return inflate;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        MenuItem menuItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            if (LiuHaiUtils.hasNotchInScreenWrapper(this.activity)) {
                ((ViewGroup) this.activity.getWindow().getDecorView()).removeView(this.mDimView);
            } else {
                this.activity.getWindowManager().removeView(this.mDimView);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, e16.toString());
            }
        }
        super.dismiss();
        OnClickActionListener onClickActionListener = this.mOnClickActionListener;
        if (onClickActionListener != null && (menuItem = this.mLastClkItem) != null) {
            onClickActionListener.onClickAction(menuItem);
        }
        this.mLastClkItem = null;
        OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        MenuItem menuItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onAnimationEnd");
        }
        OnClickActionListener onClickActionListener = this.mOnClickActionListener;
        if (onClickActionListener != null && (menuItem = this.mLastClkItem) != null) {
            onClickActionListener.onClickAction(menuItem);
        }
        this.mLastClkItem = null;
        OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        super.dismiss();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) animation);
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onAnimationStart");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            this.mLastClkItem = (MenuItem) view.getTag();
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int maxAvailableHeight = getMaxAvailableHeight(view, i16);
        if (maxAvailableHeight != this.mMaxAvailableHeight) {
            if (maxAvailableHeight < this.mTotalPopHeight) {
                i17 = ((1 - getBgPadding()) + maxAvailableHeight) / (BasePopupMenuDialog.getScaledPixelSize(this.activity, R.dimen.aub) + 1);
            }
            if (i17 > 0) {
                setHeight(getDesiredHeight(this.activity, i17, this.mNeedLine));
            } else {
                setHeight(this.mTotalPopHeight);
            }
            this.mMaxAvailableHeight = maxAvailableHeight;
        }
        try {
            if (LiuHaiUtils.hasNotchInScreenWrapper(this.activity)) {
                ((ViewGroup) this.activity.getWindow().getDecorView()).addView(this.mDimView, this.mDimViewLp);
            } else {
                this.activity.getWindowManager().addView(this.mDimView, this.mDimViewLp);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, e16.toString());
            }
        }
        super.showAsDropDown(view, i3, i16);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        try {
            if (LiuHaiUtils.hasNotchInScreenWrapper(this.activity)) {
                ((ViewGroup) this.activity.getWindow().getDecorView()).addView(this.mDimView, this.mDimViewLp);
            } else {
                this.activity.getWindowManager().addView(this.mDimView, this.mDimViewLp);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, e16.toString());
            }
        }
        super.showAtLocation(view, i3, i16, i17);
    }

    public static PopupMenuDialog build(Activity activity, List<MenuItem> list, OnClickActionListener onClickActionListener) {
        return build(activity, list, onClickActionListener, null);
    }

    private static void createAndAttachItemsView(Activity activity, List<MenuItem> list, LinearLayout linearLayout, boolean z16) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            MenuItem menuItem = list.get(i3);
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dp2px(52.0f, activity.getResources()));
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.bwa, (ViewGroup) null);
            if (is8973RecentOptPopBarTokenEnable()) {
                linearLayout2.setBackgroundResource(R.drawable.jju);
            }
            ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.di9);
            TextView textView = (TextView) linearLayout2.findViewById(R.id.jjk);
            URLDrawable uRLDrawable = menuItem.netDrawable;
            if (uRLDrawable != null) {
                imageView.setImageDrawable(uRLDrawable);
            } else {
                BitmapDrawable bitmapDrawable = menuItem.danceDrawable;
                if (bitmapDrawable != null) {
                    imageView.setImageDrawable(bitmapDrawable);
                } else {
                    Drawable drawable = menuItem.drawable;
                    if (drawable != null) {
                        imageView.setImageDrawable(drawable);
                    } else {
                        imageView.setImageResource(menuItem.iconId);
                    }
                }
            }
            if (menuItem.iconId == 0 && menuItem.drawable == null) {
                imageView.setVisibility(8);
                linearLayout2.setPadding(0, 0, 0, 0);
            }
            textView.setText(menuItem.title);
            if (!TextUtils.isEmpty(menuItem.titleColor)) {
                textView.setTextColor(Color.parseColor(menuItem.titleColor));
            }
            float f16 = menuItem.titleSize;
            if (f16 > 0.0f) {
                textView.setTextSize(f16);
            }
            if (((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("talkback_fix_enable_2") && QQUIAppSetting.enableTalkBack()) {
                AccessibilityUtil.c(linearLayout2, TextUtils.isEmpty(menuItem.contentDescription) ? menuItem.title : menuItem.contentDescription, Button.class.getName());
            }
            menuItem.itemView = linearLayout2;
            linearLayout2.setTag(menuItem);
            if (is8973RecentOptPopBarTokenEnable() && menuItem.titleColorRes > 0) {
                textView.setTextColor(textView.getResources().getColorStateList(menuItem.titleColorRes));
            }
            int i16 = menuItem.f384641id;
            if (i16 > 0) {
                linearLayout2.setId(i16);
            }
            linearLayout.addView(linearLayout2, layoutParams);
        }
    }

    public static PopupMenuDialog build(Activity activity, List<MenuItem> list, OnClickActionListener onClickActionListener, OnDismissListener onDismissListener) {
        return build(activity, list, onClickActionListener, onDismissListener, 0);
    }

    public static PopupMenuDialog build(Activity activity, List<MenuItem> list, OnClickActionListener onClickActionListener, OnDismissListener onDismissListener, int i3) {
        return build(activity, list, onClickActionListener, onDismissListener, i3, false);
    }

    public static PopupMenuDialog build(Activity activity, List<MenuItem> list, OnClickActionListener onClickActionListener, OnDismissListener onDismissListener, int i3, boolean z16) {
        return build(activity, list, onClickActionListener, onDismissListener, i3, z16, -1, R.style.f173310t);
    }

    public static PopupMenuDialog build(Activity activity, List<MenuItem> list, OnClickActionListener onClickActionListener, OnDismissListener onDismissListener, int i3, boolean z16, int i16, int i17) {
        if (list != null && list.size() != 0) {
            int desiredHeight = getDesiredHeight(activity, list.size(), z16);
            if (i3 <= 0) {
                i3 = BasePopupMenuDialog.getScaledPixelSize(activity, R.dimen.aua);
            }
            PopupMenuDialog popupMenuDialog = new PopupMenuDialog(activity, prepareContent(activity, list, z16, i16), i3, desiredHeight, true);
            popupMenuDialog.setAnimationStyle(i17);
            popupMenuDialog.setBackgroundDrawable(new ColorDrawable(0));
            popupMenuDialog.setOutsideTouchable(false);
            BasePopupMenuDialog.setWindowType(popupMenuDialog, 1002);
            if (QQUIAppSetting.enableTalkBack() && !ab.a()) {
                BasePopupMenuDialog.setModeTouch(popupMenuDialog);
            }
            popupMenuDialog.initListeners(popupMenuDialog.getContentView());
            popupMenuDialog.mTotalPopHeight = desiredHeight;
            popupMenuDialog.mOnClickActionListener = onClickActionListener;
            popupMenuDialog.mOnDismissListener = onDismissListener;
            popupMenuDialog.mNeedLine = z16;
            return popupMenuDialog;
        }
        throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }
}
