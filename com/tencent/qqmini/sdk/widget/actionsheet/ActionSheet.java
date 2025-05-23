package com.tencent.qqmini.sdk.widget.actionsheet;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.utils.AccessibilityUtil;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.VerticalCenterImageSpan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ActionSheet extends ReportDialog {
    public static final int BLUE_BOLD_STYLE_BTN = 6;
    public static final int BLUE_STYLE_BTN = 5;
    public static final int CUSTOM_TEXT_COLOR_BTN = 9;
    public static final int DEFAULT_STYLE_BTN = 0;
    public static final int GRAY_STYLE_BTN = 7;

    @Deprecated
    public static final int GREEN_STYLE_BTN = 2;

    @Deprecated
    public static final int GREY_STYLE_BTN = 4;
    public static final String ICON_PREFIX = "icon";
    public static final int REAL_BLUE_STYLE_BTN = 8;
    public static final int RED_STYLE_BTN = 3;
    public static final int SELECTOR_TYPE_BG = 0;
    public static final int SELECTOR_TYPE_BOTTOM = 3;
    public static final int SELECTOR_TYPE_BOTTOM_RADIUS_REAL = 4;
    public static final int SELECTOR_TYPE_MIDDLE = 2;
    public static final int SELECTOR_TYPE_SINGLE = 0;
    public static final int SELECTOR_TYPE_TOP = 1;
    public static final String TAG = "ActionSheet";

    @Deprecated
    public static final int WHITE_STYLE_BTN = 1;
    private TranslateAnimation animation;
    private HashMap<CharSequence, ActionMenuItem> mActionMenuMap;
    private RelativeLayout mActionView;
    private int mAnimationTime;
    private View.OnClickListener mBtnClickListener;
    private OnButtonClickListener mButtonsListener;
    private OnButtonClickListenerV2 mButtonsListenerV2;
    private Button mCancelBtn;
    private CharSequence mCancelText;
    private boolean mCloseAutoRead;
    public LinearLayout mContentContainer;
    private ArrayList<Pair<CharSequence, Integer>> mContents;
    private Context mContext;
    private int mCurrentSelectedViewId;
    private View.OnClickListener mDefaultDismissListener;
    private boolean mDismissFinish;
    private OnDismissListener mDismissListener;
    private Handler mHandler;
    private boolean mHasCustomeHeader;
    private HashMap<Integer, Integer> mIconsLayoutLeftMap;
    private HashMap<Integer, Drawable> mIconsLeftMap;
    private HashMap<Integer, Drawable> mIconsMap;
    private LayoutInflater mInflater;
    private boolean mIsMenuMode;
    public boolean mIsReady;
    private CharSequence mMainTitle;
    private a mOnPreShowListener;
    private SparseArray<View> mRadioButtonMap;
    private boolean mRadioGroupMode;
    private Resources mResources;
    private ViewGroup mRootView;
    private CharSequence mSecondaryTitle;
    private boolean mShowAnimation;
    protected boolean mSupportBottomRadius;
    private HashMap<Integer, String> mTextColorMap;
    private HashSet<Integer> mUncheckeable;
    public Object mUserData;
    private WatchDismissActions mWatchDismissListener;
    private TextView mainTitleText;
    private View.OnClickListener onBottomCancelListener;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnButtonClickListener {
        void onClick(View view, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnButtonClickListenerV2 {
        void onClick(View view, int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface WatchDismissActions {
        void onDismissOperations();
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
    }

    protected ActionSheet(Context context) {
        this(context, false, false);
    }

    static /* synthetic */ a access$800(ActionSheet actionSheet) {
        actionSheet.getClass();
        return null;
    }

    private void addCanelIfNeeded() {
        if (this.mCancelText != null) {
            View inflate = this.mInflater.inflate(R.layout.mini_sdk_action_sheet_cancel_button, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(R.id.action_sheet_btnCancel);
            button.setOnClickListener(this.onBottomCancelListener);
            button.setText(this.mCancelText);
            button.setContentDescription(this.mCancelText);
            this.mContentContainer.addView(inflate);
        }
    }

    public static ActionSheet create(Context context) {
        ActionSheet actionSheet = new ActionSheet(context, false, false);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.mini_sdk_ActionSheetAnimation);
        }
        return actionSheet;
    }

    public static ActionSheet createFullScreenDialog(Context context) {
        ActionSheet actionSheet = new ActionSheet(context, false, true);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.mini_sdk_ActionSheetAnimation);
        }
        return actionSheet;
    }

    public static ActionSheet createFullScreenMenuSheet(Context context) {
        ActionSheet actionSheet = new ActionSheet(context, true, true);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.mini_sdk_ActionSheetAnimation);
        }
        return actionSheet;
    }

    public static ActionSheet createMenuSheet(Context context) {
        ActionSheet actionSheet = new ActionSheet(context, true, false);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.mini_sdk_ActionSheetAnimation);
        }
        return actionSheet;
    }

    private int getActionButtonColorByType(int i3) {
        switch (i3) {
            case 0:
                return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
            case 1:
                return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
            case 2:
                return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
            case 3:
                return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_red);
            case 4:
                return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
            case 5:
                return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
            case 6:
                return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
            case 7:
                return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
            case 8:
                return this.mResources.getColor(R.color.mini_sdk_item_press_color);
            default:
                return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
        }
    }

    private void prepareContentViews() {
        int i3;
        if (this.mIsReady) {
            return;
        }
        if (this.mMainTitle != null) {
            View inflate = this.mInflater.inflate(R.layout.mini_sdk_action_sheet_title, (ViewGroup) null);
            inflate.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.mini_sdk_actionsheet_bottom_bg_normal));
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            TextView textView = (TextView) inflate.findViewById(R.id.action_sheet_title);
            this.mainTitleText = textView;
            textView.setVisibility(0);
            this.mainTitleText.setMaxLines(Integer.MAX_VALUE);
            this.mainTitleText.setText(this.mMainTitle);
            this.mainTitleText.setContentDescription(this.mMainTitle);
            if (this.mSecondaryTitle != null) {
                TextView textView2 = (TextView) inflate.findViewById(R.id.action_sheet_secondary_title);
                textView2.setVisibility(0);
                textView2.setText(this.mSecondaryTitle);
                textView2.setContentDescription(this.mSecondaryTitle);
            }
            this.mContentContainer.addView(inflate, 0);
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (this.mHasCustomeHeader) {
            i3 = 1;
        }
        ArrayList<Pair<CharSequence, Integer>> arrayList = this.mContents;
        if (arrayList != null) {
            int size = i3 + arrayList.size();
            int size2 = this.mContents.size();
            for (int i16 = 0; i16 < size2; i16++) {
                View inflate2 = this.mInflater.inflate(R.layout.mini_sdk_action_sheet_common_button, (ViewGroup) null);
                TextView textView3 = (TextView) inflate2.findViewById(R.id.action_sheet_button);
                Pair<CharSequence, Integer> pair = this.mContents.get(i16);
                textView3.setText((CharSequence) pair.first);
                AccessibilityUtil.changeAccessibilityForView(textView3, Button.class.getName());
                setTextViewId(textView3, pair);
                updateShowIcon(i16, inflate2);
                setTextColor(i16, textView3, pair);
                setSelector(size, size2, i16, inflate2);
                inflate2.setId(i16);
                inflate2.setOnClickListener(this.mBtnClickListener);
                this.mContentContainer.addView(inflate2);
                updateRadioIfNeeded(i16, inflate2, textView3);
            }
        }
        addCanelIfNeeded();
        this.mIsReady = true;
    }

    private void setSelector(int i3, int i16, int i17, View view) {
        Drawable selectorByType;
        if (this.mSupportBottomRadius && i3 > 1 && i17 == i16 - 1 && this.mCancelText == null) {
            selectorByType = getSelectorByType(4);
        } else if (i17 == 0 && i3 == i16 && i3 == 1) {
            selectorByType = getSelectorByType(0);
        } else if (i17 == 0 && i3 == i16 && i3 > 1) {
            selectorByType = getSelectorByType(3);
        } else if (i17 == i16 - 1 && i3 > 1) {
            selectorByType = getSelectorByType(0);
        } else {
            selectorByType = getSelectorByType(3);
        }
        view.setBackgroundDrawable(selectorByType);
    }

    private void setTextColor(int i3, TextView textView, Pair<CharSequence, Integer> pair) {
        if (((Integer) pair.second).intValue() == 9) {
            if (this.mTextColorMap.containsKey(Integer.valueOf(i3))) {
                textView.setTextColor(Color.parseColor(this.mTextColorMap.get(Integer.valueOf(i3))));
                return;
            }
            return;
        }
        textView.setTextColor(getActionButtonColorByType(((Integer) pair.second).intValue()));
    }

    private void setTextViewId(TextView textView, Pair<CharSequence, Integer> pair) {
        ActionMenuItem actionMenuItem;
        int i3;
        HashMap<CharSequence, ActionMenuItem> hashMap = this.mActionMenuMap;
        if (hashMap != null && hashMap.size() > 0 && (actionMenuItem = this.mActionMenuMap.get(pair.first)) != null && (i3 = actionMenuItem.viewid) != 0) {
            textView.setId(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadioGroupButtonDesc(TextView textView, boolean z16) {
        if (textView == null) {
            return;
        }
        if (z16) {
            textView.setContentDescription(getContext().getString(R.string.mini_sdk_content_desc_selected) + ((Object) textView.getText()));
            return;
        }
        textView.setContentDescription(getContext().getString(R.string.mini_sdk_content_desc_unselected) + ((Object) textView.getText()));
    }

    private void updateRadioIfNeeded(int i3, View view, TextView textView) {
        if (this.mRadioGroupMode) {
            if (this.mRadioButtonMap == null) {
                this.mRadioButtonMap = new SparseArray<>();
            }
            this.mRadioButtonMap.append(i3, view);
            if (i3 == this.mCurrentSelectedViewId) {
                view.findViewById(R.id.action_sheet_checkedIcon).setVisibility(0);
                updateRadioGroupButtonDesc(textView, true);
            } else {
                updateRadioGroupButtonDesc(textView, false);
            }
        }
    }

    private void updateShowIcon(int i3, View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.action_sheet_showIcon);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.rightMargin = DisplayUtil.dip2px(this.mContext, 15.0f);
        imageView.setLayoutParams(layoutParams);
        if (this.mIconsMap.containsKey(Integer.valueOf(i3))) {
            imageView.setVisibility(0);
            imageView.setImageDrawable(this.mIconsMap.get(Integer.valueOf(i3)));
        } else {
            imageView.setImageDrawable(null);
            imageView.setVisibility(8);
        }
        ImageView imageView2 = (ImageView) view.findViewById(R.id.action_sheet_showIcon_Left);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        if (this.mIconsLayoutLeftMap.containsKey(Integer.valueOf(i3)) && this.mIconsLayoutLeftMap.get(Integer.valueOf(i3)).intValue() == 0) {
            layoutParams2.width = DisplayUtil.dip2px(this.mContext, 28.0f);
            layoutParams2.height = DisplayUtil.dip2px(this.mContext, 28.0f);
            layoutParams2.addRule(15);
        }
        layoutParams2.rightMargin = DisplayUtil.dip2px(this.mContext, 5.0f);
        imageView2.setLayoutParams(layoutParams2);
        if (this.mIconsLeftMap.containsKey(Integer.valueOf(i3))) {
            imageView2.setVisibility(0);
            imageView2.setImageDrawable(this.mIconsLeftMap.get(Integer.valueOf(i3)));
        } else {
            imageView2.setImageDrawable(null);
            imageView2.setVisibility(8);
        }
    }

    public void addButton(int i3) {
        addButton(this.mResources.getText(i3), 0);
    }

    public void addButtonWithIcon(CharSequence charSequence, Drawable drawable, int i3) {
        if (this.mContents == null) {
            this.mContents = new ArrayList<>();
        }
        Pair<CharSequence, Integer> pair = new Pair<>(charSequence, Integer.valueOf(i3));
        if (!this.mContents.contains(pair)) {
            this.mContents.add(pair);
        }
        this.mIconsMap.put(Integer.valueOf(this.mContents.size() - 1), drawable);
    }

    public void addButtonWithLeftIcon(String str, int i3, int i16) {
        if (this.mContents == null) {
            this.mContents = new ArrayList<>();
        }
        Drawable drawable = this.mResources.getDrawable(i3);
        if (drawable == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("icon" + str);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(drawable, 0);
        verticalCenterImageSpan.setPadding(0, DisplayUtil.dip2px(this.mContext, 10.0f));
        spannableStringBuilder.setSpan(verticalCenterImageSpan, 0, 4, 18);
        Pair<CharSequence, Integer> pair = new Pair<>(spannableStringBuilder, Integer.valueOf(i16));
        if (this.mContents.contains(pair)) {
            return;
        }
        this.mContents.add(pair);
    }

    public void addButtonWithRightIcon(String str, int i3, int i16) {
        if (this.mContents == null) {
            this.mContents = new ArrayList<>();
        }
        Drawable drawable = this.mResources.getDrawable(i3);
        if (drawable == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + "icon");
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(drawable, 0);
        verticalCenterImageSpan.setPadding(DisplayUtil.dip2px(this.mContext, 10.0f), 0);
        spannableStringBuilder.setSpan(verticalCenterImageSpan, str.length(), spannableStringBuilder.length(), 18);
        Pair<CharSequence, Integer> pair = new Pair<>(spannableStringBuilder, Integer.valueOf(i16));
        if (!this.mContents.contains(pair)) {
            this.mContents.add(pair);
        }
    }

    public void addCancelButton(int i3) {
        addCancelButton(this.mResources.getText(i3));
    }

    public void addRadioButton(int i3, boolean z16) {
        addRadioButton(i3, 0, z16);
    }

    public void addView(View view) {
        this.mContentContainer.addView(view);
    }

    public void addViewCustomeTitle(View view) {
        this.mHasCustomeHeader = true;
        this.mContentContainer.addView(view);
    }

    public void clear() {
        this.mIsReady = false;
        this.mContents.clear();
        this.mActionMenuMap.clear();
        this.mIconsMap.clear();
        this.mIconsLeftMap.clear();
        this.mIconsLayoutLeftMap.clear();
        this.mTextColorMap.clear();
        this.mActionView.removeAllViews();
    }

    public void clearAllRadioBtnCheckStatus() {
        this.mCurrentSelectedViewId = -1;
        SparseArray<View> sparseArray = this.mRadioButtonMap;
        if (sparseArray == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            View valueAt = this.mRadioButtonMap.valueAt(i3);
            if (valueAt != null) {
                valueAt.findViewById(R.id.action_sheet_checkedIcon).setVisibility(8);
                updateRadioGroupButtonDesc((TextView) valueAt.findViewById(R.id.action_sheet_button), false);
            }
        }
    }

    public void disableAccessibilityForRootView() {
        ViewCompat.setImportantForAccessibility(this.mRootView.getChildAt(0), 2);
        ViewCompat.setImportantForAccessibility(this.mActionView, 2);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        WatchDismissActions watchDismissActions = this.mWatchDismissListener;
        if (watchDismissActions != null) {
            watchDismissActions.onDismissOperations();
        }
        if (this.mDismissFinish) {
            this.mDismissFinish = false;
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.5
                @Override // java.lang.Runnable
                public void run() {
                    ActionSheet.this.animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, ActionSheet.this.mActionView.getHeight());
                    ActionSheet.this.animation.setDuration(200L);
                    ActionSheet.this.animation.setFillAfter(true);
                    ActionSheet.this.mActionView.startAnimation(ActionSheet.this.animation);
                    ActionSheet.this.animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.5.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            ActionSheet.this.superDismiss();
                            ActionSheet.this.mDismissFinish = true;
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                }
            }, 0L);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (this.mCloseAutoRead && accessibilityEvent.getEventType() == 32) {
            return true;
        }
        super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Dialog.class.getName());
        return false;
    }

    public RelativeLayout getActionContentView() {
        return this.mActionView;
    }

    public ActionMenuItem getActionMenuItem(CharSequence charSequence) {
        HashMap<CharSequence, ActionMenuItem> hashMap = this.mActionMenuMap;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(charSequence);
    }

    public String getContent(int i3) {
        Pair<CharSequence, Integer> pair;
        ArrayList<Pair<CharSequence, Integer>> arrayList = this.mContents;
        if (arrayList != null && i3 < arrayList.size() && (pair = this.mContents.get(i3)) != null) {
            return ((CharSequence) pair.first).toString();
        }
        return null;
    }

    public ViewGroup getRootView() {
        return this.mRootView;
    }

    public Drawable getSelectorByType(int i3) {
        if (i3 != 0) {
            if (i3 != 3) {
                if (i3 != 4) {
                    return this.mResources.getDrawable(R.drawable.mini_sdk_actionsheet_bottom);
                }
                return this.mResources.getDrawable(R.drawable.mini_sdk_actionsheet_bottom_radius);
            }
            return this.mResources.getDrawable(R.drawable.mini_sdk_actionsheet_bottom);
        }
        return this.mResources.getDrawable(R.drawable.mini_sdk_actionsheet_bg);
    }

    @Override // android.app.Dialog
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.mIsMenuMode) {
            try {
                dismiss();
            } catch (Exception unused) {
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public void preInitView() {
        this.mRootView.setVisibility(8);
        prepareContentViews();
    }

    public void registerWatchDisMissActionListener(WatchDismissActions watchDismissActions) {
        this.mWatchDismissListener = watchDismissActions;
    }

    public void reset() {
        clear();
        this.mMainTitle = null;
        this.mSecondaryTitle = null;
        this.mCancelText = null;
        this.mButtonsListener = null;
        this.mButtonsListenerV2 = null;
    }

    public void setActionContentView(View view, LinearLayout.LayoutParams layoutParams) {
        if (view != null) {
            this.mActionView.removeAllViews();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            }
            this.mActionView.addView(view, layoutParams);
        }
    }

    public void setAnimationTime(int i3) {
        if (i3 > 0) {
            this.mAnimationTime = i3;
        }
    }

    public void setCloseAutoRead(boolean z16) {
        this.mCloseAutoRead = z16;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        throw new UnsupportedOperationException("this method is not support");
    }

    @Deprecated
    public void setHeaderView(View view, LinearLayout.LayoutParams layoutParams) {
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            }
            this.mContentContainer.addView(view, 0, layoutParams);
        }
    }

    public void setMainTitle(int i3) {
        setMainTitle(this.mResources.getText(i3));
    }

    public void setOnBottomCancelListener(View.OnClickListener onClickListener) {
        this.onBottomCancelListener = onClickListener;
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.mButtonsListener = onButtonClickListener;
    }

    public void setOnButtonClickListenerV2(OnButtonClickListenerV2 onButtonClickListenerV2) {
        this.mButtonsListenerV2 = onButtonClickListenerV2;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
    }

    public void setOutsideDismissEnable(boolean z16) {
        if (z16) {
            this.mRootView.setOnClickListener(this.mDefaultDismissListener);
        } else {
            this.mRootView.setOnClickListener(null);
        }
    }

    public void setOutsideDismissEnableCompat(boolean z16) {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null && viewGroup.getChildAt(0) != null) {
            if (z16) {
                this.mRootView.getChildAt(0).setOnClickListener(this.mDefaultDismissListener);
            } else {
                this.mRootView.getChildAt(0).setOnClickListener(null);
            }
        }
    }

    public void setRadioButtonChecked(int i3) {
        ArrayList<Pair<CharSequence, Integer>> arrayList;
        View view;
        if (i3 >= 0 && (arrayList = this.mContents) != null && i3 < arrayList.size()) {
            this.mCurrentSelectedViewId = i3;
            SparseArray<View> sparseArray = this.mRadioButtonMap;
            if (sparseArray != null && (view = sparseArray.get(i3)) != null) {
                view.findViewById(R.id.action_sheet_checkedIcon).setVisibility(0);
                updateRadioGroupButtonDesc((TextView) view.findViewById(R.id.action_sheet_button), true);
            }
        }
    }

    public void setSecondaryTitle(int i3) {
        setSecondaryTitle(this.mResources.getText(i3));
    }

    public void setSupportBottomRadius(boolean z16) {
        this.mSupportBottomRadius = z16;
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        throw new UnsupportedOperationException("this method is not support");
    }

    public void setTitleEllipsize(TextUtils.TruncateAt truncateAt) {
        TextView textView = this.mainTitleText;
        if (textView != null) {
            textView.setMaxLines(1);
            this.mainTitleText.setEllipsize(truncateAt);
            int dip2px = DisplayUtil.dip2px(this.mContext, 18.0f);
            this.mainTitleText.setPadding(dip2px, 0, dip2px, 0);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        this.mRootView.setVisibility(0);
        super.show();
        prepareContentViews();
        this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.4
            @Override // java.lang.Runnable
            public void run() {
                ActionSheet.access$800(ActionSheet.this);
                ActionSheet.this.animation = new TranslateAnimation(0.0f, 0.0f, ActionSheet.this.mActionView.getHeight(), 0.0f);
                ActionSheet.this.animation.setFillEnabled(true);
                ActionSheet.this.animation.setStartTime(300L);
                ActionSheet.this.animation.setDuration(ActionSheet.this.mAnimationTime);
                ActionSheet.this.mDismissFinish = true;
                ActionSheet.this.mActionView.startAnimation(ActionSheet.this.animation);
            }
        }, 0L);
    }

    public void superDismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public void updateAllButton() {
        this.mIsReady = false;
        this.mContentContainer.removeAllViews();
        prepareContentViews();
    }

    public void updateButton(int i3, CharSequence charSequence) {
        updateButton(i3, charSequence, 0);
    }

    public void updateUI() {
        this.mIsReady = false;
        invalidateOptionsMenu();
    }

    protected ActionSheet(Context context, boolean z16, boolean z17) {
        this(context, z16, z17, true);
    }

    public void addRadioButton(CharSequence charSequence, boolean z16) {
        addRadioButton(charSequence, 0, z16);
    }

    public ActionMenuItem getActionMenuItem(int i3) {
        return getActionMenuItem(getContent(i3));
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        throw new UnsupportedOperationException("this method is not support");
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        throw new UnsupportedOperationException("this method is not support");
    }

    public void updateButton(int i3, CharSequence charSequence, int i16) {
        ArrayList<Pair<CharSequence, Integer>> arrayList;
        View findViewById;
        View findViewById2;
        if (i3 < 0 || (arrayList = this.mContents) == null || i3 >= arrayList.size() || (findViewById = this.mContentContainer.findViewById(i3)) == null || (findViewById2 = findViewById.findViewById(R.id.action_sheet_button)) == null || !TextView.class.isInstance(findViewById2)) {
            return;
        }
        TextView textView = (TextView) findViewById2;
        textView.setText(charSequence);
        textView.setTextColor(getActionButtonColorByType(i16));
        this.mContents.set(i3, new Pair<>(charSequence, Integer.valueOf(i16)));
    }

    @TargetApi(14)
    protected ActionSheet(Context context, boolean z16, boolean z17, boolean z18) {
        super(context, R.style.mini_sdk_MenuDialogStyle);
        this.mSupportBottomRadius = false;
        this.mActionMenuMap = new HashMap<>();
        this.mIconsMap = new HashMap<>();
        this.mIconsLeftMap = new HashMap<>();
        this.mIconsLayoutLeftMap = new HashMap<>();
        this.mTextColorMap = new HashMap<>();
        this.mButtonsListener = null;
        this.mButtonsListenerV2 = null;
        this.mDismissListener = null;
        this.mCurrentSelectedViewId = -1;
        this.mRadioGroupMode = false;
        this.mAnimationTime = 300;
        this.mShowAnimation = true;
        this.mDismissFinish = true;
        this.mWatchDismissListener = null;
        this.mBtnClickListener = new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TextView textView;
                EventCollector.getInstance().onViewClickedBefore(view);
                int id5 = view.getId();
                if (ActionSheet.this.mRadioGroupMode && ((ActionSheet.this.mUncheckeable == null || !ActionSheet.this.mUncheckeable.contains(Integer.valueOf(id5))) && ActionSheet.this.mCurrentSelectedViewId != -1 && id5 != ActionSheet.this.mCurrentSelectedViewId)) {
                    View view2 = (View) ActionSheet.this.mRadioButtonMap.get(ActionSheet.this.mCurrentSelectedViewId);
                    int i3 = R.id.action_sheet_checkedIcon;
                    view2.findViewById(i3).setVisibility(8);
                    int i16 = R.id.action_sheet_button;
                    ActionSheet.this.updateRadioGroupButtonDesc((TextView) view2.findViewById(i16), false);
                    View view3 = (View) ActionSheet.this.mRadioButtonMap.get(id5);
                    view3.findViewById(i3).setVisibility(0);
                    ActionSheet.this.updateRadioGroupButtonDesc((TextView) view3.findViewById(i16), true);
                    ActionSheet.this.mCurrentSelectedViewId = id5;
                }
                if (ActionSheet.this.mButtonsListener != null) {
                    ActionSheet.this.mButtonsListener.onClick(view, id5);
                }
                if (ActionSheet.this.mButtonsListenerV2 != null && (textView = (TextView) view.findViewById(R.id.action_sheet_button)) != null) {
                    ActionSheet.this.mButtonsListenerV2.onClick(view, id5, textView.getText().toString());
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mDefaultDismissListener = new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ActionSheet.this.dismiss();
                if (ActionSheet.this.mDismissListener != null) {
                    ActionSheet.this.mDismissListener.onDismiss();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mCloseAutoRead = false;
        getWindow().setDimAmount(0.5f);
        this.mContext = context;
        this.mIsMenuMode = z16;
        this.mInflater = LayoutInflater.from(context);
        this.mResources = context.getResources();
        this.mHandler = new Handler(Looper.getMainLooper());
        if (z18 && DisplayUtil.isImmersiveSupported()) {
            getWindow().addFlags(67108864);
        }
        if (z17) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
        }
        DisplayUtil.clearCoverForStatus(getWindow(), true);
        ViewGroup viewGroup = (ViewGroup) this.mInflater.inflate(R.layout.mini_sdk_action_sheet_base, (ViewGroup) null);
        this.mRootView = viewGroup;
        super.setContentView(viewGroup);
        this.mActionView = (RelativeLayout) this.mRootView.findViewById(R.id.action_sheet_actionView);
        this.mContentContainer = (LinearLayout) this.mRootView.findViewById(R.id.action_sheet_contentView);
        this.mRootView.getChildAt(0).setOnClickListener(this.mDefaultDismissListener);
        this.mActionView.setOnClickListener(null);
        this.onBottomCancelListener = this.mDefaultDismissListener;
    }

    public void addButton(int i3, int i16) {
        addButton(this.mResources.getText(i3), i16);
    }

    public void addCancelButton(CharSequence charSequence) {
        if (charSequence != null) {
            this.mCancelText = charSequence;
        }
    }

    public void addRadioButton(int i3, int i16, boolean z16) {
        addRadioButton(this.mResources.getText(i3), i16, z16);
    }

    public void setMainTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.mMainTitle = charSequence;
        }
    }

    public void setSecondaryTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.mSecondaryTitle = charSequence;
        }
    }

    public static ActionSheet create(Context context, boolean z16) {
        ActionSheet actionSheet = new ActionSheet(context, false, false, z16);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.mini_sdk_ActionSheetAnimation);
        }
        return actionSheet;
    }

    public static ActionSheet createFullScreenDialog(Context context, boolean z16) {
        ActionSheet actionSheet = new ActionSheet(context, false, true, z16);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.mini_sdk_ActionSheetAnimation);
        }
        return actionSheet;
    }

    public void addButton(int i3, CharSequence charSequence, int i16) {
        if (charSequence != null) {
            if (this.mContents == null) {
                this.mContents = new ArrayList<>();
            }
            Pair<CharSequence, Integer> pair = new Pair<>(charSequence, Integer.valueOf(i16));
            if (!this.mContents.contains(pair)) {
                this.mContents.add(i3, pair);
            }
            if (this.mRadioGroupMode) {
                throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
            }
        }
    }

    public void addRadioButton(CharSequence charSequence, int i3, boolean z16) {
        addRadioButton(charSequence, i3, z16, true);
    }

    public void addRadioButton(CharSequence charSequence, int i3, boolean z16, boolean z17) {
        ArrayList<Pair<CharSequence, Integer>> arrayList;
        if (charSequence != null) {
            if (!this.mRadioGroupMode && (arrayList = this.mContents) != null && arrayList.size() > 0) {
                throw new UnsupportedOperationException("ActionSheet is in normal button mode,shouldn't call addRadioButton!");
            }
            if (this.mContents == null) {
                this.mContents = new ArrayList<>();
            }
            Pair<CharSequence, Integer> pair = new Pair<>(charSequence, Integer.valueOf(i3));
            if (!this.mContents.contains(pair)) {
                this.mContents.add(pair);
            }
            if (!z17) {
                if (this.mUncheckeable == null) {
                    this.mUncheckeable = new HashSet<>();
                }
                this.mUncheckeable.add(Integer.valueOf(this.mContents.size() - 1));
            } else if (z16) {
                this.mCurrentSelectedViewId = this.mContents.size() - 1;
            }
            this.mRadioGroupMode = true;
        }
    }

    public void addButton(CharSequence charSequence) {
        addButton(charSequence, 0);
    }

    public void addButtonWithLeftIcon(String str, Drawable drawable, int i3, int i16, String str2) {
        if (this.mContents == null) {
            this.mContents = new ArrayList<>();
        }
        if (drawable == null) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            i16 = 0;
        }
        Pair<CharSequence, Integer> pair = new Pair<>(str, Integer.valueOf(i16));
        if (!this.mContents.contains(pair)) {
            this.mContents.add(pair);
        }
        if (i16 == 9) {
            this.mTextColorMap.put(Integer.valueOf(this.mContents.size() - 1), str2);
        }
        this.mIconsLeftMap.put(Integer.valueOf(this.mContents.size() - 1), drawable);
        this.mIconsLayoutLeftMap.put(Integer.valueOf(this.mContents.size() - 1), Integer.valueOf(i3));
    }

    public void addButton(CharSequence charSequence, int i3) {
        if (charSequence != null) {
            if (this.mContents == null) {
                this.mContents = new ArrayList<>();
            }
            Pair<CharSequence, Integer> pair = new Pair<>(charSequence, Integer.valueOf(i3));
            if (!this.mContents.contains(pair)) {
                this.mContents.add(pair);
            }
            if (this.mRadioGroupMode) {
                throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
            }
        }
    }

    public void addButton(CharSequence charSequence, int i3, String str) {
        if (charSequence != null) {
            if (this.mContents == null) {
                this.mContents = new ArrayList<>();
            }
            if (TextUtils.isEmpty(str)) {
                i3 = 0;
            }
            Pair<CharSequence, Integer> pair = new Pair<>(charSequence, Integer.valueOf(i3));
            if (!this.mContents.contains(pair)) {
                this.mContents.add(pair);
            }
            if (i3 == 9) {
                this.mTextColorMap.put(Integer.valueOf(this.mContents.size() - 1), str);
            }
            if (this.mRadioGroupMode) {
                throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
            }
        }
    }

    public void setOnPreShowListener(a aVar) {
    }

    public void addButton(ActionMenuItem actionMenuItem, int i3) {
        if (actionMenuItem == null) {
            return;
        }
        this.mActionMenuMap.put(actionMenuItem.content, actionMenuItem);
        addButton(actionMenuItem.content, i3);
    }
}
