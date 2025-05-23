package com.qq.e.comm.plugin.base.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.base.media.video.i;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.webview.inner.IInnerWebView;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private final IInnerWebView f39317a;

    /* renamed from: b, reason: collision with root package name */
    private final ImageView f39318b;

    public d(Context context) {
        super(context);
        ImageView imageView = new ImageView(getContext());
        this.f39318b = imageView;
        IInnerWebView buildInnerWebView = ((PublicApi.WebViewApi) PublicApiHelper.getModuleApi(PublicApi.WebViewApi.class)).buildInnerWebView(context, null);
        this.f39317a = buildInnerWebView;
        if (buildInnerWebView != null && buildInnerWebView.getView() != null) {
            addView(buildInnerWebView.getView(), new RelativeLayout.LayoutParams(-1, -1));
            imageView.setImageBitmap(i.a(context.getApplicationContext()));
            Context applicationContext = context.getApplicationContext();
            int a16 = ak.a(applicationContext, 12);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a16, a16);
            layoutParams.gravity = 51;
            imageView.setPadding(a16, a16, a16, a16);
            imageView.setLayoutParams(layoutParams);
            int a17 = ak.a(applicationContext, 24) + (a16 * 2);
            addView(imageView, new RelativeLayout.LayoutParams(a17, a17));
            d();
        }
    }

    public void a(ViewGroup viewGroup, int i3, int i16) {
        if (getParent() == null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i16 > 0) {
                layoutParams.height = i16;
            }
            if (i3 > 0) {
                layoutParams.width = i3;
            }
            viewGroup.addView(this, layoutParams);
        }
    }

    public ImageView b() {
        return this.f39318b;
    }

    public void c() {
        this.f39318b.setVisibility(0);
    }

    public void d() {
        this.f39318b.setVisibility(4);
    }

    public IInnerWebView a() {
        return this.f39317a;
    }
}
