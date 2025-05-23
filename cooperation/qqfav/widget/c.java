package cooperation.qqfav.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c extends ReportDialog {
    Animatable C;
    SlideDetectListView D;
    TextView E;
    Context F;

    public c(Context context) {
        super(context, R.style.avk);
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.al7, (ViewGroup) null);
        setContentView(inflate);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
        RFWImmersiveUtils.setTransparentStatusBar(getWindow());
        RFWImmersiveUtils.setImmersiveLayout(getWindow(), false);
        View findViewById = inflate.findViewById(R.id.rlCommenTitle);
        findViewById.setBackgroundResource(R.drawable.qui_bg_nav_secondary);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(context);
            findViewById.getLayoutParams().height += statusBarHeight;
            findViewById.setPadding(findViewById.getPaddingLeft(), statusBarHeight, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        }
        TextView textView = (TextView) inflate.findViewById(R.id.ivTitleBtnLeft);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText("");
        }
        ImageView imageView = (ImageView) findViewById(R.id.f165972dz1);
        imageView.setBackground(null);
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_chevron_left_icon_navigation_02_selector));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = BaseAIOUtils.f(10.0f, context.getResources());
        imageView.setLayoutParams(marginLayoutParams);
        imageView.setVisibility(0);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ivTitleName);
        this.E = textView2;
        if (textView2 != null) {
            try {
                textView2.setVisibility(0);
                this.E.setText(R.string.b4t);
                this.E.setTextColor(context.getResources().getColorStateList(R.color.qui_common_text_nav_secondary));
            } catch (Exception unused) {
            }
        }
        FadeIconImageView fadeIconImageView = (FadeIconImageView) inflate.findViewById(R.id.ivTitleBtnRightImage);
        if (fadeIconImageView != null) {
            fadeIconImageView.setVisibility(0);
            fadeIconImageView.setImageResource(R.drawable.qui_add_icon_nav_secondary_selector);
        }
        if (QLog.isColorLevel()) {
            QLog.d(ProcessConstant.QQFAV, 2, "enter into QfavLoadingDialog");
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Animatable animatable = this.C;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        TextView textView;
        super.onWindowFocusChanged(z16);
        Animatable animatable = (Animatable) this.F.getResources().getDrawable(R.drawable.common_loading5);
        this.C = animatable;
        if (animatable != null && (textView = this.E) != null) {
            textView.setCompoundDrawablePadding(10);
            this.E.setCompoundDrawablesWithIntrinsicBounds((Drawable) this.C, (Drawable) null, (Drawable) null, (Drawable) null);
            this.C.start();
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        ImmersiveUtils.setWindowImmersive(getWindow());
    }
}
