package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ActionSheetDialog extends ReportDialog implements DialogInterface.OnCancelListener {
    public static final int BUTTON_ADD_IMAGE = 2;
    public static final int BUTTON_DELETE = 1;
    public static final int BUTTON_NORMAL = 0;
    public static final int BUTTON_TITLE = 3;
    private TranslateAnimation animation;
    private RelativeLayout backgroundLayout;
    private int buttonCount;
    private ArrayList<Button> buttonsList;
    private View.OnClickListener cancelListener;
    private LinearLayout customButtonContainer;
    private Handler handler;
    private boolean mCancelButtonHasAdd;
    private LinearLayout mContainer;
    private Context mContext;
    private View.OnClickListener mDefaultDismissListener;
    private boolean mDismissFinish;
    private LayoutInflater mInflater;
    private boolean mNeedInitContentView;

    public ActionSheetDialog(Context context) {
        this(context, R.style.mini_sdk_MenuDialogStyle);
    }

    private void bindEvents() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    private int getBackgroundId(int i3, int i16) {
        if (i16 == 0 && i3 == 1) {
            return R.drawable.mini_sdk_actionsheet_single;
        }
        if (i16 == 0 && i3 > 1) {
            return R.drawable.mini_sdk_actionsheet_top;
        }
        if (i16 == i3 - 1 && i3 > 1) {
            return R.drawable.mini_sdk_actionsheet_bottom;
        }
        return R.drawable.mini_sdk_actionsheet_middle;
    }

    private void init() {
        this.customButtonContainer = (LinearLayout) findViewById(R.id.customButtonContainer);
        this.mContainer = (LinearLayout) findViewById(R.id.mContainer);
        this.backgroundLayout = (RelativeLayout) findViewById(R.id.background);
    }

    private void prepareContentViews() {
        int color;
        if (!this.mNeedInitContentView) {
            return;
        }
        int size = this.buttonsList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Button button = this.buttonsList.get(i3);
            int intValue = ((Integer) button.getTag()).intValue();
            int i16 = R.drawable.mini_app_loading_00000;
            int backgroundId = getBackgroundId(size, i3);
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                        color = this.mContext.getResources().getColor(R.color.mini_sdk_action_sheet_button_blue);
                    } else {
                        button.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.mini_sdk_textSizeS3));
                        button.setClickable(false);
                        button.setVisibility(8);
                        addTitle(button.getText().toString());
                        color = -16777216;
                    }
                } else {
                    DisplayUtil.dip2px(getContext(), 8.0f);
                    int color2 = this.mContext.getResources().getColor(R.color.mini_sdk_action_sheet_button_blue);
                    SpannableString spannableString = new SpannableString(button.getText());
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.mini_sdk_ys_huangzuan);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    ImageSpan imageSpan = new ImageSpan(drawable, 1);
                    if (spannableString.length() >= 1 && spannableString.charAt(spannableString.length() - 1) == '@') {
                        spannableString.setSpan(imageSpan, spannableString.length() - 1, spannableString.length(), 33);
                    }
                    button.setText(spannableString);
                    color = color2;
                }
            } else {
                color = this.mContext.getResources().getColor(R.color.mini_sdk_action_sheet_button_red);
            }
            button.setBackgroundResource(backgroundId);
            button.setTextColor(color);
        }
        if (!this.mCancelButtonHasAdd) {
            View inflate = this.mInflater.inflate(R.layout.mini_sdk_action_sheet_cancel_button, (ViewGroup) null);
            Button button2 = (Button) inflate.findViewById(R.id.action_sheet_btnCancel);
            button2.setOnClickListener(this.mDefaultDismissListener);
            button2.setText(R.string.mini_sdk_cancel);
            this.customButtonContainer.addView(inflate);
            this.mCancelButtonHasAdd = true;
        }
        this.mNeedInitContentView = false;
    }

    private void setTransparentStatusBar() {
        if (DisplayUtil.isImmersiveSupported()) {
            getWindow().addFlags(67108864);
        }
    }

    public Button addButton(int i3, int i16, View.OnClickListener onClickListener) {
        return addButton(getContext().getResources().getString(i3), i16, onClickListener);
    }

    public TextView addTitle(String str) {
        try {
            Button button = new Button(this.mContext);
            this.customButtonContainer.addView(button, 0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = (int) this.mContext.getResources().getDimension(R.dimen.mini_sdk_common_action_sheet_layout_height);
            layoutParams.gravity = 17;
            button.setLayoutParams(layoutParams);
            button.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.mini_sdk_textSizeS3));
            button.setText(str);
            button.setTextColor(-16777216);
            button.setBackgroundResource(R.drawable.mini_sdk_actionsheet_top);
            button.setClickable(false);
            return button;
        } catch (Exception e16) {
            QMLog.e("ActionSheetDialog", "e:" + e16.toString());
            return null;
        }
    }

    public void clear() {
        LinearLayout linearLayout = this.customButtonContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.mCancelButtonHasAdd = false;
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mDismissFinish) {
            this.mDismissFinish = false;
            this.handler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.ActionSheetDialog.3
                @Override // java.lang.Runnable
                public void run() {
                    ActionSheetDialog.this.animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, ActionSheetDialog.this.mContainer.getHeight());
                    ActionSheetDialog.this.animation.setInterpolator(AnimationUtils.loadInterpolator(ActionSheetDialog.this.mContext, android.R.anim.decelerate_interpolator));
                    ActionSheetDialog.this.animation.setDuration(200L);
                    ActionSheetDialog.this.animation.setFillAfter(true);
                    ActionSheetDialog.this.mContainer.startAnimation(ActionSheetDialog.this.animation);
                    ActionSheetDialog.this.animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.qqmini.sdk.widget.ActionSheetDialog.3.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            try {
                                ActionSheetDialog.super.dismiss();
                                ActionSheetDialog.this.mDismissFinish = true;
                            } catch (Exception unused) {
                            }
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

    public Button getButtonById(int i3) {
        View findViewById = this.customButtonContainer.findViewById(i3);
        if (findViewById != null && (findViewById instanceof Button)) {
            return (Button) findViewById;
        }
        return null;
    }

    public Button getButtonByIndex(int i3) {
        if (i3 >= 0 && i3 < this.buttonsList.size()) {
            return this.buttonsList.get(i3);
        }
        return null;
    }

    public Button getButtonByTag(int i3) {
        for (int i16 = 0; i16 < this.buttonsList.size(); i16++) {
            if (((Integer) this.buttonsList.get(i16).getTag()).intValue() == i3) {
                return this.buttonsList.get(i16);
            }
        }
        return null;
    }

    public int getButtonCount() {
        return this.buttonCount;
    }

    public int getButtonIndexById(int i3) {
        for (int i16 = 0; i16 < this.buttonsList.size(); i16++) {
            if (i3 == this.buttonsList.get(i16).getId()) {
                return i16;
            }
        }
        return this.buttonsList.size();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        View.OnClickListener onClickListener = this.cancelListener;
        if (onClickListener != null) {
            try {
                onClickListener.onClick(null);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 82) {
            dismiss();
        }
        return super.onKeyDown(i3, keyEvent);
    }

    public void setAddImageButtonText(Button button) {
        if (button != null) {
            int dip2px = DisplayUtil.dip2px(getContext(), 8.0f);
            int color = this.mContext.getResources().getColor(R.color.mini_sdk_action_sheet_button_blue);
            SpannableString spannableString = new SpannableString(button.getText());
            Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.mini_sdk_ys_huangzuan);
            drawable.setBounds(dip2px, 0, drawable.getIntrinsicWidth() + dip2px, drawable.getIntrinsicHeight());
            spannableString.setSpan(new ImageSpan(drawable, 1), spannableString.length() - 1, spannableString.length(), 33);
            button.setText(spannableString);
            button.setTextColor(color);
        }
    }

    public void setDefaultDismissListener(View.OnClickListener onClickListener) {
        this.mDefaultDismissListener = onClickListener;
    }

    public void setNeedInitContentView(boolean z16) {
        this.mNeedInitContentView = z16;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        prepareContentViews();
        this.mContainer.setVisibility(4);
        this.backgroundLayout.setVisibility(4);
        this.mDismissFinish = true;
        this.handler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.ActionSheetDialog.2
            @Override // java.lang.Runnable
            public void run() {
                ActionSheetDialog.this.mContainer.setVisibility(0);
                ActionSheetDialog.this.backgroundLayout.setVisibility(0);
                ActionSheetDialog.this.animation = new TranslateAnimation(0.0f, 0.0f, ActionSheetDialog.this.mContainer.getHeight(), 0.0f);
                ActionSheetDialog.this.animation.setFillEnabled(true);
                ActionSheetDialog.this.animation.setInterpolator(AnimationUtils.loadInterpolator(ActionSheetDialog.this.mContext, android.R.anim.decelerate_interpolator));
                ActionSheetDialog.this.animation.setDuration(400L);
                ActionSheetDialog.this.mContainer.startAnimation(ActionSheetDialog.this.animation);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setDuration(200L);
                ActionSheetDialog.this.backgroundLayout.startAnimation(alphaAnimation);
            }
        }, 0L);
    }

    public ActionSheetDialog(Context context, int i3) {
        super(context, i3);
        this.buttonCount = 0;
        this.buttonsList = new ArrayList<>();
        this.cancelListener = null;
        this.mNeedInitContentView = true;
        this.mCancelButtonHasAdd = false;
        this.mDismissFinish = true;
        this.mDefaultDismissListener = new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.ActionSheetDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ActionSheetDialog.this.dismiss();
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mContext = context;
        setTransparentStatusBar();
        this.mInflater = LayoutInflater.from(context);
        setContentView(R.layout.mini_sdk_action_sheet);
        init();
        bindEvents();
    }

    public Button addButton(String str, int i3, View.OnClickListener onClickListener) {
        try {
            Button button = new Button(this.mContext);
            this.customButtonContainer.addView(button);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = (int) this.mContext.getResources().getDimension(R.dimen.mini_sdk_common_action_sheet_layout_height);
            layoutParams.gravity = 17;
            button.setLayoutParams(layoutParams);
            button.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.mini_sdk_textSizeS2));
            button.setText(str);
            button.setOnClickListener(onClickListener);
            this.buttonCount++;
            button.setTag(Integer.valueOf(i3));
            this.buttonsList.add(button);
            this.mNeedInitContentView = true;
            return button;
        } catch (Exception e16) {
            QMLog.e("ActionSheetDialog", "e:" + e16.toString());
            return null;
        }
    }

    public Button addButton(String str, int i3, int i16, View.OnClickListener onClickListener) {
        if (i16 >= 0 && i16 <= this.buttonCount) {
            try {
                Button button = new Button(this.mContext);
                this.customButtonContainer.addView(button, i16);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = (int) this.mContext.getResources().getDimension(R.dimen.mini_sdk_common_action_sheet_layout_height);
                button.setLayoutParams(layoutParams);
                button.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.mini_sdk_textSizeS2));
                button.setText(str);
                button.setOnClickListener(onClickListener);
                this.buttonCount++;
                button.setTag(Integer.valueOf(i3));
                if (i16 >= 0 && i16 <= this.buttonsList.size()) {
                    this.buttonsList.add(i16, button);
                }
                this.mNeedInitContentView = true;
                return button;
            } catch (Exception e16) {
                QMLog.e("ActionSheetDialog", "e:" + e16.toString());
            }
        }
        return null;
    }

    public Button addButton(int i3, int i16, int i17, View.OnClickListener onClickListener) {
        Button addButton = addButton(i16, i17, onClickListener);
        if (addButton != null) {
            addButton.setId(i3);
        }
        return addButton;
    }

    public Button addButton(int i3, int i16, int i17, int i18, View.OnClickListener onClickListener) {
        Button addButton = addButton(getContext().getResources().getString(i16), i17, i18, onClickListener);
        if (addButton != null) {
            addButton.setId(i3);
        }
        return addButton;
    }
}
