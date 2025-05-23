package com.tencent.mobileqq.qwallet.pet.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Outline;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000bH\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/fragment/HalfKuiklyDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", "arguments", "", "sh", "view", "th", "rh", "", "xh", "actionName", "wh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/DialogInterface;", "dialog", "onCancel", "", "getTheme", "Landroid/app/Dialog;", "onCreateDialog", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HalfKuiklyDialogFragment extends BottomSheetDialogFragment {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/pet/fragment/HalfKuiklyDialogFragment$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getWidth() / 2.0f);
        }
    }

    private final Bundle rh(Bundle arguments) {
        boolean z16;
        String string = arguments.getString("url");
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return arguments;
        }
        Bundle xh5 = xh(string);
        if (arguments.getBoolean("qwShowStatusBar")) {
            xh5.putBoolean("showStatusBar", true);
        }
        xh5.putBoolean("isHalfPage", true);
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).updateLaunchArgs(xh5);
        Bundle bundle = new Bundle();
        bundle.putBundle("launchKuiklyParams", xh5);
        bundle.putString("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(IPublicAccountUtil.UIN_FOR_SHOP));
        return bundle;
    }

    private final void sh(View contentView, Bundle arguments) {
        Integer num;
        int screenHeight;
        Resources resources;
        Configuration configuration;
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            int i3 = arguments.getInt("qwHeightPercentage", 88);
            FragmentActivity activity = getActivity();
            if (activity != null && (resources = activity.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
                num = Integer.valueOf(configuration.orientation);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 2) {
                screenHeight = ViewUtils.getScreenWidth();
            } else {
                screenHeight = ViewUtils.getScreenHeight();
            }
            layoutParams.height = (screenHeight * i3) / 100;
            ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
            contentView.setLayoutParams(layoutParams);
        }
    }

    private final void th(View view, Bundle arguments) {
        String string = arguments.getString("title");
        View findViewById = view.findViewById(R.id.kbs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tv_title)");
        ((TextView) findViewById).setText(string);
        String string2 = arguments.getString("qwMerchantTitle");
        View findViewById2 = view.findViewById(R.id.x5r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.h\u2026_web_view_merchant_title)");
        ((TextView) findViewById2).setText(string2);
        String string3 = arguments.getString("qwMerchantLogo");
        View findViewById3 = view.findViewById(R.id.x5q);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.h\u2026f_web_view_merchant_logo)");
        ImageView imageView = (ImageView) findViewById3;
        imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(string3));
        imageView.setOutlineProvider(new b());
        imageView.setClipToOutline(true);
        View findViewById4 = view.findViewById(R.id.dum);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.iv_close)");
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.pet.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HalfKuiklyDialogFragment.uh(HalfKuiklyDialogFragment.this, view2);
            }
        });
        BaseAIOUtils.g(findViewById4, ViewUtils.dpToPx(20.0f));
        View findViewById5 = view.findViewById(R.id.x5g);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.half_kuikly_outside)");
        findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.pet.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HalfKuiklyDialogFragment.vh(HalfKuiklyDialogFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(HalfKuiklyDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.wh("qqwallet.halfkuikly_close.click");
        FragmentKt.setFragmentResult(this$0, "qwallet_half_kuikly_request", new Bundle());
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(HalfKuiklyDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.setFragmentResult(this$0, "qwallet_half_kuikly_request", new Bundle());
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void wh(String actionName) {
        String str;
        String str2;
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("qwMerchantTitle");
        } else {
            str = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("url");
        } else {
            str2 = null;
        }
        com.tencent.mobileqq.qwallet.c.f(actionName, null, null, str, str2, 6, null);
    }

    private final Bundle xh(String str) {
        Bundle bundle = new Bundle();
        try {
            Uri parse = Uri.parse(str);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null) {
                for (String str2 : queryParameterNames) {
                    String queryParameter = parse.getQueryParameter(str2);
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    bundle.putString(str2, queryParameter);
                }
            }
        } catch (Throwable th5) {
            QLog.e("schemeParams", 1, "schemeParams error: " + th5);
        }
        return bundle;
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.a76;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        FragmentKt.setFragmentResult(this, "qwallet_half_kuikly_request", new Bundle());
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        QUIImmersiveHelper.t(onCreateDialog.getWindow(), false, null, true, getView());
        onCreateDialog.setCanceledOnTouchOutside(true);
        if (onCreateDialog instanceof com.google.android.material.bottomsheet.a) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.getBehavior().setState(3);
            aVar.getBehavior().setDraggable(false);
            aVar.getBehavior().setPeekHeight(-1);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f_m, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0085, code lost:
    
        if (r5.getBoolean("qwShowStatusBar") == true) goto L30;
     */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        sh(view, arguments);
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            arguments2 = new Bundle();
        }
        th(view, arguments2);
        QPublicBaseFragment createQQKuiklyFragment = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createQQKuiklyFragment();
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            arguments3 = new Bundle();
        }
        createQQKuiklyFragment.setArguments(rh(arguments3));
        View findViewById = view.findViewById(R.id.cks);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.fragment_container)");
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
            int i16 = -2;
            if (layoutParams2 != null) {
                i3 = layoutParams2.width;
            } else {
                i3 = -2;
            }
            ViewGroup.LayoutParams layoutParams3 = findViewById.getLayoutParams();
            if (layoutParams3 != null) {
                i16 = layoutParams3.height;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, i16);
        }
        Bundle arguments4 = getArguments();
        int i17 = 0;
        if (arguments4 != null) {
            z16 = true;
        }
        z16 = false;
        if (!z16) {
            i17 = -ImmersiveUtils.getStatusBarHeight(getActivity());
        }
        marginLayoutParams.topMargin = i17;
        getChildFragmentManager().beginTransaction().replace(R.id.cks, createQQKuiklyFragment).commit();
        wh("qqwallet.halfkuikly_open.show");
    }
}
