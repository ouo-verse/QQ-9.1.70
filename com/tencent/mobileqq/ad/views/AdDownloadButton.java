package com.tencent.mobileqq.ad.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.views.button.IAdAppDownloadButtonView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.views.AdProgressButton;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u00010B\u0011\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*B\u0019\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b)\u0010-B!\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010.\u001a\u00020\n\u00a2\u0006\u0004\b)\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/ad/views/AdDownloadButton;", "Lcom/tencent/ad/tangram/views/button/IAdAppDownloadButtonView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mobileqq/ad/views/AdProgressButton$a;", "b", "", "c", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "setAd", "", "status", "progress", "update", "Lcom/tencent/mobileqq/ad/views/AdDownloadButton$a;", "onClickListener", "setOnAdBtnClickListener", "", "text", "width", HippyQQPagView.FunctionName.SET_PROGRESS, "Lcom/tencent/mobileqq/ad/views/AdProgressButton;", "d", "Lcom/tencent/mobileqq/ad/views/AdProgressButton;", "progressBtn", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "btnLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "btnDownloadContinue", h.F, "btnDownloadCancel", "i", "Lcom/tencent/gdtad/aditem/GdtAd;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AdDownloadButton extends RelativeLayout implements IAdAppDownloadButtonView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdProgressButton progressBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout btnLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView btnDownloadContinue;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView btnDownloadCancel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtAd ad;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int status;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ad/views/AdDownloadButton$a;", "", "", "status", "", NodeProps.ON_CLICK, "onCancelClick", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface a {
        void onCancelClick();

        void onClick(int status);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/ad/views/AdDownloadButton$b", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f186977d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AdDownloadButton f186978e;

        b(a aVar, AdDownloadButton adDownloadButton) {
            this.f186977d = aVar;
            this.f186978e = adDownloadButton;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) adDownloadButton);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else if (v3 != null) {
                a aVar = this.f186977d;
                AdDownloadButton adDownloadButton = this.f186978e;
                if (v3.getId() == R.id.say) {
                    aVar.onCancelClick();
                } else {
                    aVar.onClick(adDownloadButton.status);
                }
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdDownloadButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.ec_, (ViewGroup) this, true);
            c();
        }
    }

    private final AdProgressButton.a b() {
        AdProgressButton.a aVar = new AdProgressButton.a();
        aVar.f186985a = ViewUtils.dpToPx(14.0f);
        aVar.f186986b = Color.parseColor("#0099FF");
        aVar.f186987c = -1;
        aVar.f186988d = Color.parseColor("#800099FF");
        aVar.f186989e = -1;
        aVar.f186990f = ViewUtils.dpToPx(4.0f);
        return aVar;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f163964sb1);
        this.btnLayout = linearLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        this.btnDownloadContinue = (TextView) findViewById(R.id.saz);
        this.btnDownloadCancel = (TextView) findViewById(R.id.say);
        AdProgressButton adProgressButton = (AdProgressButton) findViewById(R.id.f163963sb0);
        this.progressBtn = adProgressButton;
        if (adProgressButton != null) {
            adProgressButton.setParams(b());
        }
    }

    public final void setAd(@NotNull GdtAd ad5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) ad5);
        } else {
            Intrinsics.checkNotNullParameter(ad5, "ad");
            this.ad = ad5;
        }
    }

    public final void setOnAdBtnClickListener(@NotNull a onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onClickListener);
            return;
        }
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        b bVar = new b(onClickListener, this);
        TextView textView = this.btnDownloadContinue;
        if (textView != null) {
            textView.setOnClickListener(bVar);
        }
        TextView textView2 = this.btnDownloadCancel;
        if (textView2 != null) {
            textView2.setOnClickListener(bVar);
        }
        AdProgressButton adProgressButton = this.progressBtn;
        if (adProgressButton != null) {
            adProgressButton.setOnClickListener(bVar);
        }
    }

    public final void setProgress(@NotNull String text, int progress, int width) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, text, Integer.valueOf(progress), Integer.valueOf(width));
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = width;
        }
        AdProgressButton adProgressButton = this.progressBtn;
        if (adProgressButton != null) {
            adProgressButton.requestLayout();
        }
        AdProgressButton adProgressButton2 = this.progressBtn;
        if (adProgressButton2 != null) {
            adProgressButton2.setText(text);
        }
        AdProgressButton adProgressButton3 = this.progressBtn;
        if (adProgressButton3 != null) {
            adProgressButton3.setProgress(progress);
        }
    }

    @Override // com.tencent.ad.tangram.views.button.IAdAppDownloadButtonView
    public void update(int status, int progress) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(status), Integer.valueOf(progress));
            return;
        }
        GdtAd gdtAd = this.ad;
        if (gdtAd != null) {
            str = gdtAd.getButtonText(status, progress);
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.status = status;
        switch (status) {
            case 0:
            case 1:
            case 2:
            case 3:
                LinearLayout linearLayout = this.btnLayout;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                setProgress(str, 100, ViewUtils.dpToPx(88.0f));
                return;
            case 4:
            default:
                return;
            case 5:
                LinearLayout linearLayout2 = this.btnLayout;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                setProgress(str, progress, ViewUtils.dpToPx(138.0f));
                return;
            case 6:
                LinearLayout linearLayout3 = this.btnLayout;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                setProgress(str, progress, ViewUtils.dpToPx(138.0f));
                AdProgressButton adProgressButton = this.progressBtn;
                if (adProgressButton != null) {
                    adProgressButton.setText("");
                }
                TextView textView = this.btnDownloadContinue;
                if (textView != null) {
                    textView.setText(str);
                    return;
                }
                return;
            case 7:
                LinearLayout linearLayout4 = this.btnLayout;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
                setProgress(str, 100, ViewUtils.dpToPx(88.0f));
                return;
            case 8:
                LinearLayout linearLayout5 = this.btnLayout;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                }
                setProgress(str, progress, ViewUtils.dpToPx(138.0f));
                return;
            case 9:
                LinearLayout linearLayout6 = this.btnLayout;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(8);
                }
                setProgress(str, 100, ViewUtils.dpToPx(88.0f));
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdDownloadButton(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attrs);
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.ec_, (ViewGroup) this, true);
            c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdDownloadButton(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attrs, Integer.valueOf(i3));
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.ec_, (ViewGroup) this, true);
            c();
        }
    }
}
