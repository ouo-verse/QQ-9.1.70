package com.tencent.ad.tangram.views.button;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;
import java.lang.ref.WeakReference;

/* compiled from: P */
@SuppressLint({"ValidFragment"})
@Deprecated
/* loaded from: classes3.dex */
final class AdAppDownloadLayerFragmentAppDownload extends ReportDialogFragment implements IAdAppDownloadButtonView, AdImageViewAdapter.Callback {
    private static final String CLOSE_ICON = "iVBORw0KGgoAAAANSUhEUgAAADIAAAAyBAMAAADsEZWCAAAAMFBMVEUAAADGx8fPzAdImageViewBuilder8/HycnHyMjHyMjHx8fFyMjDx8e/v7/Gx8fHyMjGxsbGyMjGycnHyMjDlXnoAAAAD3RSTlMAgBDPn98gX0AQ77+Pb1ATznxzAAAAm0lEQVQ4y+3QsQkCQRSE4T1YjAzsQBEr2AYs4cAK7EBLsAljS7AEyzC3g0OMRw9+hL152XHZTfIeDF8yac6YLF7/91k31/eGL+tSNTcVvnbQNAJldanOWgWy6o8jiCOII0iEII52EEd3iCOIZ69DXGQxhKXVQyUmXeOIxRjCCUNEJIGcgAICchKiU09A56pZ/gjoc+SzbNOcafIFUxpMBYjKjmsAAAAASUVORK5CYII=";
    private static final String TAG = "AdAppDownloadLayerFragment";
    private AdAppDownloadButtonView buttonView;
    private TextView company;
    private final WeakReference<AdImageViewBuilder.Listener> imageViewlistener = new WeakReference<>(new AdImageViewBuilder.Listener() { // from class: com.tencent.ad.tangram.views.button.AdAppDownloadLayerFragmentAppDownload.1
        @Override // com.tencent.ad.tangram.image.AdImageViewBuilder.Listener
        public void onStopLoad(boolean z16) {
            AdAppDownloadLayerFragmentAppDownload.this.onStopLoad(z16);
        }
    });
    private volatile Params params;
    private TextView version;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Params {

        @Nullable
        public String appName;
        public String developer;

        @Nullable
        public String logoUrl;

        @Nullable
        public String rightInfoUrl;
        public String version;
    }

    AdAppDownloadLayerFragmentAppDownload() {
    }

    @NonNull
    private View createView(int i3, int i16) {
        RelativeLayout relativeLayout = new RelativeLayout(getActivity());
        View frameLayout = new FrameLayout(getActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i16 * 2);
        layoutParams.addRule(10);
        RelativeLayout relativeLayout2 = new RelativeLayout(getActivity());
        relativeLayout2.setGravity(1);
        relativeLayout2.setBackgroundColor(Color.parseColor("#FFFFFF"));
        setBackground(relativeLayout2);
        relativeLayout.addView(frameLayout, layoutParams);
        relativeLayout.addView(relativeLayout2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i3, i16);
        layoutParams2.addRule(12, frameLayout.getId());
        relativeLayout2.setLayoutParams(layoutParams2);
        AdImageViewBuilder.Params params = new AdImageViewBuilder.Params();
        params.context = new WeakReference<>(getActivity().getApplicationContext());
        params.url = this.params.logoUrl;
        params.callback = new WeakReference<>(this);
        params.listener = this.imageViewlistener;
        View buildImageView = AdImageViewBuilder.getInstance().buildImageView(params);
        buildImageView.setId(273);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(AdUIUtils.getValueDependsOnScreenWidth(getActivity(), 750, 166), AdUIUtils.getValueDependsOnScreenWidth(getActivity(), 750, 166));
        layoutParams3.addRule(14);
        buildImageView.setPadding(13, 13, 13, 13);
        layoutParams3.topMargin = 37;
        relativeLayout2.addView(buildImageView, layoutParams3);
        ImageView imageView = new ImageView(getActivity());
        imageView.setImageBitmap(AdUIUtils.getBitmapFromString(CLOSE_ICON));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(AdUIUtils.dp2px(32.0f, getResources()), AdUIUtils.dp2px(32.0f, getResources()));
        layoutParams4.addRule(11);
        layoutParams4.rightMargin = 37;
        layoutParams4.topMargin = 37;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ad.tangram.views.button.AdAppDownloadLayerFragmentAppDownload.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (AdAppDownloadLayerFragmentAppDownload.this.getDialog() != null && AdAppDownloadLayerFragmentAppDownload.this.getDialog().isShowing()) {
                    AdAppDownloadLayerFragmentAppDownload.this.dismiss();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        relativeLayout2.addView(imageView, layoutParams4);
        TextView textView = new TextView(getActivity());
        textView.setId(546);
        textView.setText(this.params.appName);
        textView.setTextColor(Color.parseColor("#222222"));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(17);
        textView.setTextSize(2, 17.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(3, buildImageView.getId());
        layoutParams5.topMargin = 7;
        relativeLayout2.addView(textView, layoutParams5);
        TextView textView2 = new TextView(getActivity());
        this.version = textView2;
        textView2.setId(819);
        this.version.setTextColor(Color.parseColor("#878B99"));
        this.version.setGravity(17);
        this.version.setTextSize(2, 15.0f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(3, textView.getId());
        layoutParams6.topMargin = 40;
        this.version.setVisibility(8);
        relativeLayout2.addView(this.version, layoutParams6);
        TextView textView3 = new TextView(getActivity());
        this.company = textView3;
        textView3.setId(1092);
        this.company.setTextColor(Color.parseColor("#878B99"));
        this.company.setMaxLines(1);
        this.company.setEllipsize(TextUtils.TruncateAt.END);
        this.company.setGravity(17);
        this.company.setTextSize(2, 15.0f);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams7.addRule(3, this.version.getId());
        layoutParams7.topMargin = 12;
        this.company.setVisibility(8);
        relativeLayout2.addView(this.company, layoutParams7);
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(0);
        TextView textView4 = new TextView(getActivity());
        textView4.setText("\u6743\u9650\u5217\u8868");
        textView4.setGravity(17);
        textView4.setTextSize(2, 14.0f);
        textView4.setTextColor(Color.parseColor("#579AD8"));
        TextView textView5 = new TextView(getActivity());
        textView5.setText("|");
        textView5.setGravity(17);
        textView5.setTextSize(2, 14.0f);
        textView5.setTextColor(Color.parseColor("#878B99"));
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.leftMargin = 20;
        layoutParams8.rightMargin = 20;
        TextView textView6 = new TextView(getActivity());
        textView6.setText("\u9690\u79c1\u653f\u7b56");
        textView6.setGravity(17);
        textView6.setTextSize(2, 14.0f);
        textView6.setTextColor(Color.parseColor("#579AD8"));
        linearLayout.addView(textView4);
        linearLayout.addView(textView5, layoutParams8);
        linearLayout.addView(textView6);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.addRule(14);
        layoutParams9.addRule(3, this.company.getId());
        layoutParams9.topMargin = 20;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ad.tangram.views.button.AdAppDownloadLayerFragmentAppDownload.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!TextUtils.isEmpty(AdAppDownloadLayerFragmentAppDownload.this.params.rightInfoUrl)) {
                    AdBrowser.Params params2 = new AdBrowser.Params();
                    params2.activity = new WeakReference<>(AdAppDownloadLayerFragmentAppDownload.this.getActivity());
                    params2.url = AdAppDownloadLayerFragmentAppDownload.this.params.rightInfoUrl;
                    AdBrowser.getInstance().showWithoutAd(params2);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        relativeLayout2.addView(linearLayout, layoutParams9);
        int valueDependsOnScreenWidth = AdUIUtils.getValueDependsOnScreenWidth(getActivity(), 750, 584);
        int valueDependsOnScreenWidth2 = AdUIUtils.getValueDependsOnScreenWidth(getActivity(), 750, 80);
        this.buttonView = new AdAppDownloadButtonView(getActivity(), null, valueDependsOnScreenWidth, valueDependsOnScreenWidth2);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, valueDependsOnScreenWidth2);
        layoutParams10.addRule(12);
        layoutParams10.topMargin = 70;
        layoutParams10.leftMargin = 83;
        layoutParams10.rightMargin = 83;
        layoutParams10.bottomMargin = 89;
        return relativeLayout;
    }

    private void hideStatusBar(@Nullable ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.setSystemUiVisibility(4);
    }

    private void setBackground(@Nullable View view) {
        if (view == null) {
            return;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{80.0f, 80.0f, 80.0f, 80.0f, 0.0f, 0.0f, 0.0f, 0.0f}, null, null));
        shapeDrawable.getPaint().setColor(-1);
        view.setBackgroundDrawable(shapeDrawable);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(-1, -1);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment, android.app.DialogFragment
    @RequiresApi(api = 17)
    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        ViewGroup viewGroup;
        AlertDialog create = new AlertDialog.Builder(getActivity()).create();
        create.setCanceledOnTouchOutside(false);
        if (this.params == null) {
            return create;
        }
        try {
            window = create.getWindow();
            viewGroup = (ViewGroup) window.getDecorView();
        } catch (Throwable th5) {
            AdLog.e(TAG, "onCreateDialog", th5);
        }
        if (viewGroup == null) {
            return create;
        }
        hideStatusBar(viewGroup);
        window.setDimAmount(0.0f);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 80;
        attributes.windowAnimations = 0;
        window.setAttributes(attributes);
        viewGroup.setPadding(0, 0, 0, 0);
        viewGroup.setBackgroundColor(Color.parseColor(GameCenterVideoViewController.GRAY_MASK));
        viewGroup.addView(createView(AdUIUtils.getScreenWidth(getActivity()), AdUIUtils.getScreenHeight(getActivity()) / 2));
        return create;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getDialog() != null) {
            getDialog().requestWindowFeature(1);
        }
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        FragmentCollector.onFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // android.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        if (getDialog() == null || (window = getDialog().getWindow()) == null) {
            return;
        }
        hideStatusBar((ViewGroup) window.getDecorView());
    }

    public void setParams(@Nullable final Params params) {
        if (params != null) {
            if (this.params == null) {
                this.params = new Params();
            }
            if (!TextUtils.isEmpty(params.logoUrl)) {
                this.params.logoUrl = params.logoUrl;
            }
            if (!TextUtils.isEmpty(params.appName)) {
                this.params.appName = params.appName;
            }
            if (!TextUtils.isEmpty(params.version)) {
                this.params.version = params.version;
                if (this.version != null) {
                    AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.button.AdAppDownloadLayerFragmentAppDownload.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AdAppDownloadLayerFragmentAppDownload.this.version.setText("\u7248\u672c " + params.version);
                            AdAppDownloadLayerFragmentAppDownload.this.version.setVisibility(0);
                        }
                    }, 0);
                }
            }
            if (!TextUtils.isEmpty(params.developer)) {
                this.params.developer = params.developer;
                AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.button.AdAppDownloadLayerFragmentAppDownload.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AdAppDownloadLayerFragmentAppDownload.this.company != null) {
                            AdAppDownloadLayerFragmentAppDownload.this.company.setText(params.developer);
                            AdAppDownloadLayerFragmentAppDownload.this.company.setVisibility(0);
                        }
                    }
                }, 0);
            }
            if (!TextUtils.isEmpty(params.rightInfoUrl)) {
                this.params.rightInfoUrl = params.rightInfoUrl;
            }
        }
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        if (this.params == null) {
            return;
        }
        super.show(fragmentManager, str);
    }

    @Override // com.tencent.ad.tangram.views.button.IAdAppDownloadButtonView
    public void update(int i3, int i16) {
        AdAppDownloadButtonView adAppDownloadButtonView = this.buttonView;
        if (adAppDownloadButtonView != null) {
            adAppDownloadButtonView.update(i3, i16);
        }
    }

    @Override // android.app.DialogFragment
    public int show(FragmentTransaction fragmentTransaction, String str) {
        if (this.params == null) {
            return -1;
        }
        return super.show(fragmentTransaction, str);
    }

    @Override // com.tencent.ad.tangram.image.AdImageViewAdapter.Callback
    public void onStopLoad(boolean z16) {
    }
}
