package com.tencent.ecommerce.biz.register;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.ui.ECBaseDialogFragment;
import com.tencent.ecommerce.repo.register.ECaptcha;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0003J\b\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0017J\b\u0010\u000f\u001a\u00020\u0005H\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog;", "Lcom/tencent/ecommerce/base/ui/ECBaseDialogFragment;", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$CaptchaVerifyDialogResult;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", OcrConfig.CHINESE, "view", "initView", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/smtt/sdk/WebView;", "G", "Lcom/tencent/smtt/sdk/WebView;", "webView", "Lcom/tencent/smtt/sdk/WebSettings;", "H", "Lcom/tencent/smtt/sdk/WebSettings;", "webSettings", "", "I", "J", "startTime", "<init>", "()V", "CaptchaVerifyDialogResult", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECommerceCaptchaVerifyDialog extends ECBaseDialogFragment<CaptchaVerifyDialogResult> {

    /* renamed from: G, reason: from kotlin metadata */
    private WebView webView;

    /* renamed from: H, reason: from kotlin metadata */
    private WebSettings webSettings;

    /* renamed from: I, reason: from kotlin metadata */
    private long startTime;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$CaptchaVerifyDialogResult;", "Landroid/os/Parcelable;", "()V", "Cancel", "PageReady", "Verified", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$CaptchaVerifyDialogResult$PageReady;", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$CaptchaVerifyDialogResult$Cancel;", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$CaptchaVerifyDialogResult$Verified;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class CaptchaVerifyDialogResult implements Parcelable {

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u00d6\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$CaptchaVerifyDialogResult$Cancel;", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$CaptchaVerifyDialogResult;", "()V", "describeContents", "", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class Cancel extends CaptchaVerifyDialogResult {

            /* renamed from: d, reason: collision with root package name */
            public static final Cancel f103956d = new Cancel();
            public static final Parcelable.Creator<Cancel> CREATOR = new a();

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static class a implements Parcelable.Creator<Cancel> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Cancel createFromParcel(Parcel parcel) {
                    if (parcel.readInt() != 0) {
                        return Cancel.f103956d;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Cancel[] newArray(int i3) {
                    return new Cancel[i3];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "Cancel";
            }

            Cancel() {
                super(null);
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                parcel.writeInt(1);
            }
        }

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u00d6\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$CaptchaVerifyDialogResult$PageReady;", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$CaptchaVerifyDialogResult;", "()V", "describeContents", "", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class PageReady extends CaptchaVerifyDialogResult {

            /* renamed from: d, reason: collision with root package name */
            public static final PageReady f103957d = new PageReady();
            public static final Parcelable.Creator<PageReady> CREATOR = new a();

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static class a implements Parcelable.Creator<PageReady> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final PageReady createFromParcel(Parcel parcel) {
                    if (parcel.readInt() != 0) {
                        return PageReady.f103957d;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final PageReady[] newArray(int i3) {
                    return new PageReady[i3];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "PageReady";
            }

            PageReady() {
                super(null);
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                parcel.writeInt(1);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$CaptchaVerifyDialogResult$Verified;", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$CaptchaVerifyDialogResult;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/ecommerce/repo/register/ECaptcha;", "d", "Lcom/tencent/ecommerce/repo/register/ECaptcha;", "captcha", "<init>", "(Lcom/tencent/ecommerce/repo/register/ECaptcha;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final /* data */ class Verified extends CaptchaVerifyDialogResult {
            public static final Parcelable.Creator<Verified> CREATOR = new a();

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            public final ECaptcha captcha;

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static class a implements Parcelable.Creator<Verified> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Verified createFromParcel(Parcel parcel) {
                    return new Verified(ECaptcha.CREATOR.createFromParcel(parcel));
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Verified[] newArray(int i3) {
                    return new Verified[i3];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public int hashCode() {
                ECaptcha eCaptcha = this.captcha;
                if (eCaptcha != null) {
                    return eCaptcha.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Verified(captcha=" + this.captcha + ')';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                this.captcha.writeToParcel(parcel, 0);
            }

            public Verified(ECaptcha eCaptcha) {
                super(null);
                this.captcha = eCaptcha;
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Verified) && Intrinsics.areEqual(this.captcha, ((Verified) other).captcha);
                }
                return true;
            }
        }

        CaptchaVerifyDialogResult() {
        }

        public /* synthetic */ CaptchaVerifyDialogResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECBaseDialogFragment.th(ECommerceCaptchaVerifyDialog.this, CaptchaVerifyDialogResult.Cancel.f103956d, 0, 2, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$c", "Lcom/tencent/smtt/sdk/WebViewClient;", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends WebViewClient {
        c() {
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public static final /* synthetic */ WebView xh(ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog) {
        WebView webView = eCommerceCaptchaVerifyDialog.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        return webView;
    }

    private final void zh(View rootView) {
        rootView.setOnClickListener(new b());
    }

    @Override // com.tencent.ecommerce.base.ui.ECBaseDialogFragment
    public int getContentLayoutId() {
        return R.layout.cqj;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WebSettings webSettings = this.webSettings;
        if (webSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSettings");
        }
        webSettings.setJavaScriptEnabled(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        WebSettings webSettings = this.webSettings;
        if (webSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSettings");
        }
        webSettings.setJavaScriptEnabled(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        zh(view);
    }

    private final void initView(View view) {
        String str;
        WebView webView = (WebView) view.findViewById(R.id.ofb);
        this.webView = webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        WebSettings settings = webView.getSettings();
        this.webSettings = settings;
        if (settings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSettings");
        }
        settings.setUseWideViewPort(true);
        WebSettings webSettings = this.webSettings;
        if (webSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSettings");
        }
        webSettings.setLoadWithOverviewMode(true);
        WebSettings webSettings2 = this.webSettings;
        if (webSettings2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSettings");
        }
        webSettings2.setCacheMode(2);
        WebView webView2 = this.webView;
        if (webView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView2.setWebViewClient(new c());
        WebSettings webSettings3 = this.webSettings;
        if (webSettings3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSettings");
        }
        webSettings3.setJavaScriptEnabled(true);
        ui0.a aVar = new ui0.a();
        aVar.a(new ECommerceCaptchaVerifyDialog$initView$2(this));
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView3.setBackgroundColor(0);
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView4.addJavascriptInterface(aVar, "ECommerceJSBridge");
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("appId")) == null) {
            str = "2065455486";
        }
        WebView webView5 = this.webView;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView5.loadUrl("file:///android_asset/ecommerce_puzzle_verify.html?appId=" + str);
        this.startTime = System.currentTimeMillis();
    }
}
