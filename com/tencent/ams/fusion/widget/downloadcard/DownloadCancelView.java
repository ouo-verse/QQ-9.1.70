package com.tencent.ams.fusion.widget.downloadcard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.base.CustomImageView;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadCancelView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private ImageView mAppIcon;
    private TextView mDownloadCountTv;
    private DownloadHandler mDownloadHandler;
    private DownloadInfo mDownloadInfo;
    private TextView mLeftButton;
    private TextView mRightButton;

    public DownloadCancelView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            initView(context);
        }
    }

    private Drawable createButtonBgDrawable(int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float dp2px = Utils.dp2px(40.0f);
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px});
        return gradientDrawable;
    }

    private View createContentView(Context context) {
        int i3;
        int i16;
        int i17;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, (int) Utils.dp2px(268.0f)));
        CustomImageView customImageView = new CustomImageView(context);
        customImageView.setRadius(Utils.dp2px(10.0f));
        customImageView.setTag(1);
        int dp2px = (int) Utils.dp2px(70.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp2px, dp2px);
        layoutParams.topMargin = (int) Utils.dp2px(36.0f);
        linearLayout2.addView(customImageView, layoutParams);
        this.mAppIcon = customImageView;
        TextView textView = new TextView(context);
        textView.setText("\u786e\u5b9a\u53d6\u6d88\u4e0b\u8f7d\u4efb\u52a1\u5417\uff1f");
        textView.setTextSize(0, Utils.dp2px(18.0f));
        boolean isDarkMode = ViewUtils.isDarkMode();
        int i18 = DownloadCardView.COLOR_APP_NAME_DARK;
        if (isDarkMode) {
            i3 = -855310;
        } else {
            i3 = DownloadCardView.COLOR_APP_NAME;
        }
        textView.setTextColor(i3);
        textView.getPaint().setFakeBoldText(true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, (int) Utils.dp2px(24.0f));
        layoutParams2.topMargin = (int) Utils.dp2px(10.0f);
        linearLayout2.addView(textView, layoutParams2);
        TextView textView2 = new TextView(context);
        textView2.setTextSize(0, Utils.dp2px(13.0f));
        if (ViewUtils.isDarkMode()) {
            i16 = DownloadCardView.COLOR_APP_VERSION_DARK;
        } else {
            i16 = DownloadCardView.COLOR_APP_VERSION;
        }
        textView2.setTextColor(i16);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, (int) Utils.dp2px(20.0f));
        layoutParams3.topMargin = (int) Utils.dp2px(8.0f);
        linearLayout2.addView(textView2, layoutParams3);
        this.mDownloadCountTv = textView2;
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.leftMargin = (int) Utils.dp2px(24.0f);
        layoutParams4.rightMargin = (int) Utils.dp2px(24.0f);
        linearLayout3.setLayoutParams(layoutParams4);
        TextView textView3 = new TextView(context);
        textView3.setText("\u53d6\u6d88");
        if (ViewUtils.isDarkMode()) {
            i17 = -3355444;
        } else {
            i17 = -15395563;
        }
        textView3.setTextColor(i17);
        textView3.setTextSize(0, Utils.dp2px(14.0f));
        textView3.getPaint().setFakeBoldText(true);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, (int) Utils.dp2px(48.0f));
        layoutParams5.weight = 1.0f;
        layoutParams5.rightMargin = (int) Utils.dp2px(7.5f);
        textView3.setLayoutParams(layoutParams5);
        textView3.setGravity(17);
        this.mLeftButton = textView3;
        linearLayout3.addView(textView3);
        TextView textView4 = new TextView(context);
        textView4.setText("\u786e\u5b9a");
        if (!ViewUtils.isDarkMode()) {
            i18 = -1;
        }
        textView4.setTextColor(i18);
        textView4.setTextSize(0, Utils.dp2px(14.0f));
        textView4.getPaint().setFakeBoldText(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, (int) Utils.dp2px(48.0f));
        layoutParams6.weight = 1.0f;
        layoutParams6.leftMargin = (int) Utils.dp2px(7.5f);
        textView4.setLayoutParams(layoutParams6);
        textView4.setGravity(17);
        this.mRightButton = textView4;
        linearLayout3.addView(textView4);
        linearLayout.addView(linearLayout3);
        return linearLayout;
    }

    private void initView(Context context) {
        addView(createContentView(context));
        View createBackView = ViewUtils.createBackView(context);
        createBackView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCancelView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadCancelView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    DownloadCancelView.this.close();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        addView(createBackView);
        setBackground(ViewUtils.createCornerBackground());
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCancelView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadCancelView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            setVisibility(8);
        }
    }

    public void hide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            setVisibility(8);
        }
    }

    public void setDownloadHandler(DownloadHandler downloadHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) downloadHandler);
        } else {
            this.mDownloadHandler = downloadHandler;
        }
    }

    public void setDownloadInfo(DownloadInfo downloadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) downloadInfo);
        } else {
            this.mDownloadInfo = downloadInfo;
        }
    }

    public void setLeftButtonClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onClickListener);
            return;
        }
        TextView textView = this.mLeftButton;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setRightButtonClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onClickListener);
            return;
        }
        TextView textView = this.mRightButton;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setThemeColor(int i3) {
        int i16;
        int buildColorWithAlphaRatio;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        TextView textView = this.mLeftButton;
        if (textView != null) {
            if (ViewUtils.isDarkMode()) {
                i16 = -3355444;
            } else {
                i16 = i3;
            }
            textView.setTextColor(i16);
            TextView textView2 = this.mLeftButton;
            if (ViewUtils.isDarkMode()) {
                buildColorWithAlphaRatio = DownloadCardView.COLOR_BUTTON_BACKGROUND_DARK;
            } else {
                buildColorWithAlphaRatio = Utils.buildColorWithAlphaRatio(0.1f, i3);
            }
            textView2.setBackground(createButtonBgDrawable(buildColorWithAlphaRatio));
        }
        TextView textView3 = this.mRightButton;
        if (textView3 != null) {
            textView3.setBackground(createButtonBgDrawable(i3));
        }
    }

    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        DownloadInfo downloadInfo = this.mDownloadInfo;
        if (downloadInfo != null) {
            if (this.mAppIcon != null) {
                if (downloadInfo.getAppIcon() != null) {
                    this.mAppIcon.setImageBitmap(this.mDownloadInfo.getAppIcon());
                } else {
                    DownloadHandler downloadHandler = this.mDownloadHandler;
                    if (downloadHandler != null) {
                        downloadHandler.displayImage(this.mDownloadInfo.getAppIconUrl(), this.mAppIcon);
                    }
                }
            }
            if (this.mDownloadCountTv != null && this.mDownloadInfo.isShowCancelViewDownloadCountTv()) {
                this.mDownloadCountTv.setText("\u5df2\u6709" + this.mDownloadInfo.getDownloadCount() + "\u4eba\u4e0b\u8f7d\u8fc7\u6b64\u5e94\u7528");
            }
        }
        setVisibility(0);
    }
}
