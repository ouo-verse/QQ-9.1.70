package com.tencent.ams.fusion.widget.downloadcard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.fusion.widget.utils.IFusionWebView;
import com.tencent.ams.fusion.widget.utils.IFusionWebViewBuilder;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadWebView extends FrameLayout {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DownloadWebView";
    private DownloadWebViewListener mListener;
    private TextView mTitleView;
    private IFusionWebView mWebView;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface DownloadWebViewListener {
        void onClose();
    }

    public DownloadWebView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadWebView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DownloadWebView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        linearLayout.setOrientation(1);
        addTitleView(linearLayout, context);
        addWebView(linearLayout, context);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        View createBackView = ViewUtils.createBackView(context);
        createBackView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadWebView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DownloadWebView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    DownloadWebView.this.close();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        addView(createBackView);
        setBackground(ViewUtils.createCornerBackground());
    }

    private void addTitleView(ViewGroup viewGroup, Context context) {
        int i3;
        TextView textView = new TextView(context);
        textView.setTextSize(0, Utils.dp2px(18.0f));
        if (ViewUtils.isDarkMode()) {
            i3 = DownloadCardView.COLOR_APP_NAME_DARK;
        } else {
            i3 = DownloadCardView.COLOR_APP_NAME;
        }
        textView.setTextColor(i3);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        int dp2px = (int) Utils.dp2px(16.0f);
        layoutParams.leftMargin = dp2px;
        layoutParams.rightMargin = dp2px;
        layoutParams.topMargin = dp2px;
        layoutParams.bottomMargin = (int) Utils.dp2px(20.0f);
        viewGroup.addView(textView, layoutParams);
        this.mTitleView = textView;
    }

    private void addWebView(ViewGroup viewGroup, Context context) {
        IFusionWebView iFusionWebView;
        IFusionWebViewBuilder fusionWebViewBuilder = DownloadCardViewConfig.getFusionWebViewBuilder();
        if (fusionWebViewBuilder != null) {
            iFusionWebView = fusionWebViewBuilder.build(context);
        } else {
            iFusionWebView = null;
        }
        if (iFusionWebView == null) {
            iFusionWebView = new DefaultFusionWebViewImpl(context);
        }
        if (iFusionWebView.getView() != null && viewGroup != null) {
            viewGroup.addView(iFusionWebView.getView(), new FrameLayout.LayoutParams(-1, -1));
            this.mWebView = iFusionWebView;
        } else {
            Logger.e(TAG, "[addWebView] view is null");
        }
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        setVisibility(8);
        DownloadWebViewListener downloadWebViewListener = this.mListener;
        if (downloadWebViewListener != null) {
            downloadWebViewListener.onClose();
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        IFusionWebView iFusionWebView = this.mWebView;
        if (iFusionWebView != null) {
            iFusionWebView.destroy();
        }
    }

    public void loadUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        IFusionWebView iFusionWebView = this.mWebView;
        if (iFusionWebView != null) {
            iFusionWebView.loadUrl("about:blank");
            this.mWebView.loadUrl(str);
        }
    }

    public void setListener(DownloadWebViewListener downloadWebViewListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) downloadWebViewListener);
        } else {
            this.mListener = downloadWebViewListener;
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
