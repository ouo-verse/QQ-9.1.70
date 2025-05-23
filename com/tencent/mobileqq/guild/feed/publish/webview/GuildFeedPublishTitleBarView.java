package com.tencent.mobileqq.guild.feed.publish.webview;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import tp1.a;

@KeepClassConstructor
/* loaded from: classes13.dex */
public class GuildFeedPublishTitleBarView extends SwiftIphoneTitleBarUI {

    /* renamed from: s0, reason: collision with root package name */
    private TextView f223180s0;

    public GuildFeedPublishTitleBarView(v vVar) {
        super(vVar);
    }

    private void g0() {
        TextView textView = this.f314054i;
        textView.setTextColor(AppCompatResources.getColorStateList(textView.getContext(), R.color.qui_common_text_primary));
        TextView textView2 = this.f314059m;
        textView2.setTextColor(AppCompatResources.getColorStateList(textView2.getContext(), R.color.qui_common_text_primary));
        this.M.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
    }

    public void i0(String str) {
        this.f223180s0.setText(str);
    }

    public void j0(boolean z16) {
        float f16;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.C.getLayoutParams();
        marginLayoutParams.rightMargin = ViewUtils.dpToPx(16.0f);
        marginLayoutParams.width = ViewUtils.dpToPx(60.0f);
        marginLayoutParams.height = ViewUtils.dpToPx(29.0f);
        this.C.setLayoutParams(marginLayoutParams);
        this.C.setTextSize(14.0f);
        this.C.setPadding(0, 0, 0, 0);
        TextView textView = this.C;
        textView.setTextColor(AppCompatResources.getColorStateList(textView.getContext(), R.color.qui_button_text_primary));
        this.C.setBackgroundResource(R.drawable.guild_feed_publish_feed_back_selector);
        TextView textView2 = this.C;
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.5f;
        }
        textView2.setAlpha(f16);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void l() {
        boolean z16;
        try {
            Activity activity = this.f314045d.E;
            if (activity != null) {
                ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).setStatusBarColor(activity, ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(this.f314054i.getContext(), R.color.qui_common_bg_bottom_light));
                if (!GuildThemeManager.f235286a.c(this.f314054i.getContext())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ImmersiveUtils.setStatusTextColor(z16, activity.getWindow());
            }
            int paddingRight = this.f314054i.getPaddingRight();
            this.f314054i.setPadding(paddingRight, this.f314054i.getPaddingTop(), paddingRight, this.f314054i.getPaddingBottom());
            this.C.setBackgroundDrawable(null);
        } catch (Exception e16) {
            QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "initDefaultThemeTitleBar error" + e16.getMessage());
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void m() {
        ViewGroup viewGroup = this.M;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        WebViewProgressBar webViewProgressBar = this.f314045d.T;
        if (webViewProgressBar != null) {
            webViewProgressBar.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void n(Intent intent, String str) {
        super.n(intent, str);
        this.f314054i.setText(((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getString(R.string.f140850f3));
        this.f314054i.setTextColor(((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(this.f314054i.getContext(), R.color.qui_common_text_primary));
        TextView textView = this.f314059m;
        textView.setTypeface(textView.getTypeface(), 1);
        this.f314059m.getLayoutParams().height = -2;
        TextView textView2 = (TextView) this.M.findViewById(a.h());
        this.f223180s0 = textView2;
        textView2.setTextColor(((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(this.f314054i.getContext(), R.color.qui_common_text_secondary));
        this.f223180s0.setTextSize(12.0f);
        this.f223180s0.setVisibility(0);
        j0(false);
        g0();
    }
}
