package com.tenpay.idverify;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tenpay.api.QFuncProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x05.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJZ\u0010 \u001a\u00020\u001b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001fJ\u0012\u0010'\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010(\u001a\u00020\u001b2\b\b\u0002\u0010)\u001a\u00020\u0017J\u000e\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010\u0005J\u0012\u0010/\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u001a\u00100\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u001d2\b\u0010&\u001a\u0004\u0018\u00010\u001fJ\u0012\u00101\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0002J\u000e\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/tenpay/idverify/IdVerifyCommonHintVC;", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "(Landroid/app/Activity;Landroid/view/View;)V", "getActivity", "()Landroid/app/Activity;", "confirmBtn", "Landroid/widget/Button;", "extraContentRoot", "Landroid/view/ViewGroup;", "hintDesc", "Landroid/widget/TextView;", "hintLogoView", "Landroid/widget/ImageView;", "hintRoot", "hintTitle", "getRootView", "()Landroid/view/View;", "textLinkBtn", "getVisibility", "", DKConfiguration.Directory.RESOURCES, "Landroid/content/res/Resources;", "setConfirmButton", "", "confirmBtnDesc", "", "confirmBtnClickListener", "Landroid/view/View$OnClickListener;", "setData", "logoDrawable", "Landroid/graphics/drawable/Drawable;", "title", "desc", "textLinkText", "textLinkClickListener", "setDesc", "setDescGravity", LayoutAttrDefine.Gravity.Gravity, "setDescSize", "titleSize", "", "setExtraContent", "extraView", "setLogoResource", "setTextLink", "setTitle", "setVisibility", "visibility", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyCommonHintVC {

    @Nullable
    private final Activity activity;

    @NotNull
    private final Button confirmBtn;

    @NotNull
    private final ViewGroup extraContentRoot;

    @NotNull
    private final TextView hintDesc;

    @NotNull
    private final ImageView hintLogoView;

    @NotNull
    private final View hintRoot;

    @NotNull
    private final TextView hintTitle;

    @NotNull
    private final View rootView;

    @NotNull
    private final TextView textLinkBtn;

    public IdVerifyCommonHintVC(@Nullable Activity activity, @NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.activity = activity;
        this.rootView = rootView;
        View findViewById = rootView.findViewById(R.id.x_t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.hint_root)");
        this.hintRoot = findViewById;
        View findViewById2 = rootView.findViewById(R.id.x_s);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.hint_logo)");
        this.hintLogoView = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.x_v);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.hint_title)");
        this.hintTitle = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.x_q);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.hint_desc)");
        this.hintDesc = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.x_p);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.hint_confirm_button)");
        this.confirmBtn = (Button) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.x_u);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.hint_text_link)");
        this.textLinkBtn = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.uys);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.extra_content_root)");
        this.extraContentRoot = (ViewGroup) findViewById7;
    }

    public static /* synthetic */ void setData$default(IdVerifyCommonHintVC idVerifyCommonHintVC, Drawable drawable, String str, String str2, String str3, View.OnClickListener onClickListener, String str4, View.OnClickListener onClickListener2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            drawable = null;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        if ((i3 & 8) != 0) {
            str3 = null;
        }
        if ((i3 & 16) != 0) {
            onClickListener = null;
        }
        if ((i3 & 32) != 0) {
            str4 = null;
        }
        if ((i3 & 64) != 0) {
            onClickListener2 = null;
        }
        idVerifyCommonHintVC.setData(drawable, str, str2, str3, onClickListener, str4, onClickListener2);
    }

    private final void setDesc(String desc) {
        boolean z16;
        if (desc != null && desc.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.hintDesc.setVisibility(8);
            return;
        }
        this.hintDesc.setVisibility(0);
        this.hintDesc.setMovementMethod(LinkMovementMethod.getInstance());
        this.hintDesc.setText(x05.c.e(desc, new c.InterfaceC11524c() { // from class: com.tenpay.idverify.a
            @Override // x05.c.InterfaceC11524c
            public final void onClickUrl(String str) {
                IdVerifyCommonHintVC.setDesc$lambda$0(IdVerifyCommonHintVC.this, str);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDesc$lambda$0(IdVerifyCommonHintVC this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFuncProxy.gotoH5(this$0.activity, str, true, false);
    }

    public static /* synthetic */ void setDescGravity$default(IdVerifyCommonHintVC idVerifyCommonHintVC, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 17;
        }
        idVerifyCommonHintVC.setDescGravity(i3);
    }

    private final void setLogoResource(Drawable logoDrawable) {
        if (logoDrawable == null) {
            this.hintLogoView.setVisibility(8);
        } else {
            this.hintLogoView.setVisibility(0);
            this.hintLogoView.setImageDrawable(logoDrawable);
        }
    }

    private final void setTitle(String title) {
        boolean z16;
        if (title != null && title.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.hintTitle.setVisibility(8);
        } else {
            this.hintTitle.setVisibility(0);
            this.hintTitle.setText(title);
        }
    }

    @Nullable
    public final Activity getActivity() {
        return this.activity;
    }

    @NotNull
    public final View getRootView() {
        return this.rootView;
    }

    public final int getVisibility() {
        return this.hintRoot.getVisibility();
    }

    @NotNull
    public final Resources resources() {
        Resources resources = this.rootView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "rootView.resources");
        return resources;
    }

    public final void setConfirmButton(@Nullable String confirmBtnDesc, @Nullable View.OnClickListener confirmBtnClickListener) {
        boolean z16;
        if (confirmBtnDesc != null && confirmBtnDesc.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && confirmBtnClickListener != null) {
            this.confirmBtn.setVisibility(0);
            this.confirmBtn.setText(confirmBtnDesc);
            this.confirmBtn.setOnClickListener(confirmBtnClickListener);
            return;
        }
        this.confirmBtn.setVisibility(8);
    }

    public final void setData(@Nullable Drawable logoDrawable, @Nullable String title, @Nullable String desc, @Nullable String confirmBtnDesc, @Nullable View.OnClickListener confirmBtnClickListener, @Nullable String textLinkText, @Nullable View.OnClickListener textLinkClickListener) {
        setLogoResource(logoDrawable);
        setTitle(title);
        setDesc(desc);
        setTextLink(textLinkText, textLinkClickListener);
        setConfirmButton(confirmBtnDesc, confirmBtnClickListener);
    }

    public final void setDescGravity(int gravity) {
        this.hintDesc.setGravity(gravity);
    }

    public final void setDescSize(float titleSize) {
        this.hintDesc.setTextSize(titleSize);
    }

    public final void setExtraContent(@Nullable View extraView) {
        if (extraView != null) {
            this.extraContentRoot.addView(extraView);
            this.extraContentRoot.setVisibility(0);
        } else {
            this.extraContentRoot.removeAllViews();
            this.extraContentRoot.setVisibility(8);
        }
    }

    public final void setTextLink(@Nullable String textLinkText, @Nullable View.OnClickListener textLinkClickListener) {
        boolean z16;
        if (textLinkText != null && textLinkText.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && textLinkClickListener != null) {
            this.textLinkBtn.setVisibility(0);
            this.textLinkBtn.setText(textLinkText);
            this.textLinkBtn.setOnClickListener(textLinkClickListener);
            return;
        }
        this.textLinkBtn.setVisibility(8);
    }

    public final void setVisibility(int visibility) {
        this.hintRoot.setVisibility(visibility);
    }
}
