package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class AIOEmotionBaseFragment extends PublicBaseFragment {
    static IPatchRedirector $redirector_;
    protected View C;
    protected Context D;
    protected int E;
    protected ViewGroup F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionBaseFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AIOEmotionBaseFragment.this.xh("0X8009980");
                AIOEmotionBaseFragment.this.qh(view);
                AIOEmotionBaseFragment.this.rh();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public AIOEmotionBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void uh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        wh();
        EventCollector.getInstance().onViewClicked(view);
    }

    public abstract View generateRootView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public void initTitleBar(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        th(view);
        if (vh()) {
            ImageView imageView = (ImageView) view.findViewById(R.id.ivTitleBtnRightImage);
            imageView.setImageResource(R.drawable.f160122aq);
            imageView.setVisibility(0);
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.j8o));
            imageView.setOnClickListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViewWithBusiness(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            View findViewById = view.findViewById(R.id.jo9);
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
            findViewById.getLayoutParams().height += statusBarHeight;
            findViewById.setPadding(findViewById.getPaddingLeft(), statusBarHeight, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View generateRootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            generateRootView = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            xh("0X800997D");
            generateRootView = generateRootView(layoutInflater, viewGroup);
            this.C = generateRootView;
            this.D = getBaseActivity();
            initTitleBar(generateRootView);
            initViewWithBusiness(generateRootView);
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                RFWImmersiveUtils.setTransparentStatusBar(getActivity().getWindow());
                RFWImmersiveUtils.setImmersiveLayout(getActivity().getWindow(), false);
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, generateRootView);
        return generateRootView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onPause();
        AbstractGifImage.pauseAll();
        ApngImage.pauseByTag(0);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        AbstractGifImage.resumeAll();
        ApngImage.playByTag(0);
    }

    protected abstract void qh(View view);

    protected abstract void rh();

    /* JADX INFO: Access modifiers changed from: protected */
    public QQAppInterface sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    protected void th(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        TextView textView2 = (TextView) view.findViewById(R.id.xzi);
        this.F = (ViewGroup) view.findViewById(R.id.yft);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
        if (QQTheme.isVasTheme()) {
            textView.setBackgroundResource(R.drawable.top_back_left_selector);
            marginLayoutParams.leftMargin = -ViewUtils.dip2px(4.0f);
        } else {
            textView.setBackgroundResource(R.drawable.qui_chevron_left_icon_navigation_01_selector);
            marginLayoutParams.leftMargin = 0;
        }
        textView2.setLayoutParams(marginLayoutParams);
        textView2.setTextColor(getResources().getColorStateList(R.color.qui_common_text_nav_secondary));
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emotionintegrate.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AIOEmotionBaseFragment.this.uh(view2);
            }
        });
    }

    public boolean vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    protected void wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            getBaseActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xh(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            ReportController.o(null, "dc00898", "", "", str, str, this.E, 0, "", "", "", "");
        }
    }
}
