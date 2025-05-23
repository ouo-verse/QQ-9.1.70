package com.tenpay.payment.qrcodehb;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.hb.detail.HbDetailModule;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.payment.QWalletPaymentExtKt;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0013J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001cH\u0016J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#J\u0014\u0010$\u001a\u00020\u00182\f\u0010%\u001a\b\u0012\u0004\u0012\u00020#0&J\b\u0010'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\u001d\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0002\u0010-R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/tenpay/payment/qrcodehb/QrCodeHbCodeController;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "fragment", "Lcom/tenpay/payment/qrcodehb/QrCodeHbFragment;", "(Lcom/tenpay/payment/qrcodehb/QrCodeHbFragment;)V", "codeViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getFragment", "()Lcom/tenpay/payment/qrcodehb/QrCodeHbFragment;", "packNextRoot", "Landroid/view/ViewGroup;", "pagerAdapter", "Lcom/tenpay/payment/qrcodehb/QrCodeHbAdapter;", "qrCodeEmptyContainer", "qrCodeEmptyHintTv", "Landroid/widget/TextView;", "qrCodeGotoDetailTv", "qrCodeRemainingHintTv", "qrCodeScanHint", "Landroid/view/View;", "qrCodeSwitchLeftHbIv", "Landroid/widget/ImageView;", "qrCodeSwitchRightHbIv", "changeVisible", "", ViewStickEventHelper.IS_SHOW, "", "getQrCodeHbCount", "", "initView", "view", "onPageSelected", "position", "receiveNewQrCodeHb", "newQrCodeHbInfo", "Lcom/tenpay/payment/qrcodehb/QrCodeHbInfo;", "setDataList", "dataList", "", "setupViewPager", "updateAllView", "updateReceiveNum", "listId", "", "receiveNum", "(Ljava/lang/String;Ljava/lang/Integer;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class QrCodeHbCodeController extends ViewPager2.OnPageChangeCallback {
    private ViewPager2 codeViewPager;

    @NotNull
    private final QrCodeHbFragment fragment;
    private ViewGroup packNextRoot;
    private QrCodeHbAdapter pagerAdapter;
    private ViewGroup qrCodeEmptyContainer;
    private TextView qrCodeEmptyHintTv;
    private TextView qrCodeGotoDetailTv;
    private TextView qrCodeRemainingHintTv;
    private View qrCodeScanHint;
    private ImageView qrCodeSwitchLeftHbIv;
    private ImageView qrCodeSwitchRightHbIv;

    public QrCodeHbCodeController(@NotNull QrCodeHbFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(QrCodeHbCodeController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.codeViewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeViewPager");
            viewPager2 = null;
        }
        int currentItem = viewPager2.getCurrentItem();
        if (currentItem > 0) {
            ViewPager2 viewPager23 = this$0.codeViewPager;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("codeViewPager");
            } else {
                viewPager22 = viewPager23;
            }
            viewPager22.setCurrentItem(currentItem - 1, true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(QrCodeHbCodeController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.codeViewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeViewPager");
            viewPager2 = null;
        }
        int currentItem = viewPager2.getCurrentItem();
        QrCodeHbAdapter qrCodeHbAdapter = this$0.pagerAdapter;
        if (qrCodeHbAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            qrCodeHbAdapter = null;
        }
        if (currentItem < qrCodeHbAdapter.getNUM_BACKGOURND_ICON() - 1) {
            ViewPager2 viewPager23 = this$0.codeViewPager;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("codeViewPager");
            } else {
                viewPager22 = viewPager23;
            }
            viewPager22.setCurrentItem(currentItem + 1, true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void setupViewPager() {
        Context requireContext = this.fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        this.pagerAdapter = new QrCodeHbAdapter(requireContext, new Function1<Integer, Unit>() { // from class: com.tenpay.payment.qrcodehb.QrCodeHbCodeController$setupViewPager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                QLog.i(QWalletPaymentExtKt.getPaymentTag(QrCodeHbCodeController.this), 1, "onDataChange, newSize=" + i3);
                QrCodeHbCodeController.this.updateAllView();
            }
        });
        ViewPager2 viewPager2 = this.codeViewPager;
        QrCodeHbAdapter qrCodeHbAdapter = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeViewPager");
            viewPager2 = null;
        }
        QrCodeHbAdapter qrCodeHbAdapter2 = this.pagerAdapter;
        if (qrCodeHbAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        } else {
            qrCodeHbAdapter = qrCodeHbAdapter2;
        }
        viewPager2.setAdapter(qrCodeHbAdapter);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);
        viewPager2.registerOnPageChangeCallback(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.ViewGroup] */
    public final void updateAllView() {
        int i3;
        int i16;
        int i17;
        boolean z16;
        Integer receiveNum;
        Integer totalNum;
        Integer totalNum2;
        Integer receiveNum2;
        ViewPager2 viewPager2 = this.codeViewPager;
        TextView textView = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeViewPager");
            viewPager2 = null;
        }
        int currentItem = viewPager2.getCurrentItem();
        if (currentItem > 0) {
            ImageView imageView = this.qrCodeSwitchLeftHbIv;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qrCodeSwitchLeftHbIv");
                imageView = null;
            }
            imageView.setVisibility(0);
        } else {
            ImageView imageView2 = this.qrCodeSwitchLeftHbIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qrCodeSwitchLeftHbIv");
                imageView2 = null;
            }
            imageView2.setVisibility(4);
        }
        QrCodeHbAdapter qrCodeHbAdapter = this.pagerAdapter;
        if (qrCodeHbAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            qrCodeHbAdapter = null;
        }
        if (currentItem < qrCodeHbAdapter.getNUM_BACKGOURND_ICON() - 1) {
            ImageView imageView3 = this.qrCodeSwitchRightHbIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qrCodeSwitchRightHbIv");
                imageView3 = null;
            }
            imageView3.setVisibility(0);
        } else {
            ImageView imageView4 = this.qrCodeSwitchRightHbIv;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qrCodeSwitchRightHbIv");
                imageView4 = null;
            }
            imageView4.setVisibility(4);
        }
        QrCodeHbAdapter qrCodeHbAdapter2 = this.pagerAdapter;
        if (qrCodeHbAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            qrCodeHbAdapter2 = null;
        }
        final QrCodeHbInfo itemData = qrCodeHbAdapter2.getItemData(currentItem);
        View view = this.qrCodeScanHint;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeScanHint");
            view = null;
        }
        view.setVisibility(0);
        TextView textView2 = this.qrCodeRemainingHintTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeRemainingHintTv");
            textView2 = null;
        }
        textView2.setVisibility(0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.fragment.getString(R.string.f2183963l);
        Intrinsics.checkNotNullExpressionValue(string, "fragment.getString(R.str\u2026let_qr_code_hb_remaining)");
        Object[] objArr = new Object[2];
        if (itemData != null && (receiveNum2 = itemData.getReceiveNum()) != null) {
            i3 = receiveNum2.intValue();
        } else {
            i3 = 0;
        }
        objArr[0] = Integer.valueOf(i3);
        if (itemData != null && (totalNum2 = itemData.getTotalNum()) != null) {
            i16 = totalNum2.intValue();
        } else {
            i16 = 0;
        }
        objArr[1] = Integer.valueOf(i16);
        String format = String.format(string, Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView2.setText(format);
        TextView textView3 = this.qrCodeGotoDetailTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeGotoDetailTv");
            textView3 = null;
        }
        textView3.setVisibility(0);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.qrcodehb.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QrCodeHbCodeController.updateAllView$lambda$8$lambda$7(QrCodeHbCodeController.this, itemData, view2);
            }
        });
        if (itemData != null && (totalNum = itemData.getTotalNum()) != null) {
            i17 = totalNum.intValue();
        } else {
            i17 = 0;
        }
        if (i17 != 0) {
            if (itemData != null && (receiveNum = itemData.getReceiveNum()) != null && receiveNum.intValue() == i17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ViewGroup viewGroup = this.qrCodeEmptyContainer;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qrCodeEmptyContainer");
                    viewGroup = null;
                }
                viewGroup.setVisibility(0);
                TextView textView4 = this.qrCodeEmptyHintTv;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qrCodeEmptyHintTv");
                } else {
                    textView = textView4;
                }
                String string2 = this.fragment.getString(R.string.f2183263e);
                Intrinsics.checkNotNullExpressionValue(string2, "fragment.getString(R.str\u2026et_qr_code_hb_empty_hint)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(i17)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                textView.setText(format2);
                return;
            }
        }
        ?? r06 = this.qrCodeEmptyContainer;
        if (r06 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeEmptyContainer");
        } else {
            textView = r06;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateAllView$lambda$8$lambda$7(QrCodeHbCodeController this$0, QrCodeHbInfo qrCodeHbInfo, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        if (qrCodeHbInfo != null) {
            str = qrCodeHbInfo.getSendListId();
        } else {
            str = null;
        }
        intent.putExtra("listid", str);
        intent.putExtra("from_out", false);
        HbDetailModule.k(this$0.fragment.getActivity(), intent, false);
        com.tencent.mobileqq.qwallet.c.f("face2face.detail.hbdetail", null, null, null, null, 30, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v22, types: [androidx.viewpager2.widget.ViewPager2] */
    public final void changeVisible(boolean isShow) {
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "changeVisible, isShow=" + isShow);
        ImageView imageView = null;
        if (isShow) {
            ?? r46 = this.codeViewPager;
            if (r46 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("codeViewPager");
            } else {
                imageView = r46;
            }
            imageView.setVisibility(0);
            updateAllView();
            return;
        }
        ViewPager2 viewPager2 = this.codeViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeViewPager");
            viewPager2 = null;
        }
        viewPager2.setVisibility(8);
        View view = this.qrCodeScanHint;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeScanHint");
            view = null;
        }
        view.setVisibility(8);
        TextView textView = this.qrCodeRemainingHintTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeRemainingHintTv");
            textView = null;
        }
        textView.setVisibility(8);
        TextView textView2 = this.qrCodeGotoDetailTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeGotoDetailTv");
            textView2 = null;
        }
        textView2.setVisibility(8);
        ImageView imageView2 = this.qrCodeSwitchLeftHbIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeSwitchLeftHbIv");
            imageView2 = null;
        }
        imageView2.setVisibility(4);
        ImageView imageView3 = this.qrCodeSwitchRightHbIv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeSwitchRightHbIv");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(4);
    }

    @NotNull
    public final QrCodeHbFragment getFragment() {
        return this.fragment;
    }

    public final int getQrCodeHbCount() {
        QrCodeHbAdapter qrCodeHbAdapter = this.pagerAdapter;
        if (qrCodeHbAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            qrCodeHbAdapter = null;
        }
        return qrCodeHbAdapter.getNUM_BACKGOURND_ICON();
    }

    public final void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.f653138l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qrcode_hb_view_pager)");
        this.codeViewPager = (ViewPager2) findViewById;
        View findViewById2 = view.findViewById(R.id.f652938j);
        ImageView imageView = (ImageView) findViewById2;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.qrcodehb.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QrCodeHbCodeController.initView$lambda$1$lambda$0(QrCodeHbCodeController.this, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById<ImageV\u2026}\n            }\n        }");
        this.qrCodeSwitchLeftHbIv = imageView;
        View findViewById3 = view.findViewById(R.id.f653038k);
        ImageView imageView2 = (ImageView) findViewById3;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.qrcodehb.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QrCodeHbCodeController.initView$lambda$3$lambda$2(QrCodeHbCodeController.this, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById<ImageV\u2026}\n            }\n        }");
        this.qrCodeSwitchRightHbIv = imageView2;
        View findViewById4 = view.findViewById(R.id.f652838i);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.qrcode_hb_scan_hint)");
        this.qrCodeScanHint = findViewById4;
        View findViewById5 = view.findViewById(R.id.f652738h);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.qrcode_hb_remaining_hint)");
        this.qrCodeRemainingHintTv = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f652638g);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.q\u2026e_hb_receive_detail_link)");
        this.qrCodeGotoDetailTv = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.f652338d);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.q\u2026_hb_empty_hint_container)");
        this.qrCodeEmptyContainer = (ViewGroup) findViewById7;
        View findViewById8 = view.findViewById(R.id.f652438e);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.qrcode_hb_empty_hint_tv)");
        this.qrCodeEmptyHintTv = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.f652538f);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById<ViewGr\u2026R.id.qrcode_hb_pack_next)");
        this.packNextRoot = (ViewGroup) findViewById9;
        setupViewPager();
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int position) {
        super.onPageSelected(position);
        updateAllView();
        com.tencent.mobileqq.qwallet.c.f("face2face.detail.slip", null, null, null, null, 30, null);
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "onPageSelected position=" + position);
    }

    public final void receiveNewQrCodeHb(@NotNull QrCodeHbInfo newQrCodeHbInfo) {
        Intrinsics.checkNotNullParameter(newQrCodeHbInfo, "newQrCodeHbInfo");
        ViewPager2 viewPager2 = this.codeViewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeViewPager");
            viewPager2 = null;
        }
        int currentItem = viewPager2.getCurrentItem();
        QrCodeHbAdapter qrCodeHbAdapter = this.pagerAdapter;
        if (qrCodeHbAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            qrCodeHbAdapter = null;
        }
        int updateItem = qrCodeHbAdapter.updateItem(newQrCodeHbInfo);
        ViewPager2 viewPager23 = this.codeViewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeViewPager");
        } else {
            viewPager22 = viewPager23;
        }
        viewPager22.setCurrentItem(currentItem, true);
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "receiveNewQrCodeHb " + newQrCodeHbInfo + ", updateIndex=" + updateItem + " current=" + currentItem);
    }

    public final void setDataList(@NotNull List<QrCodeHbInfo> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        QrCodeHbAdapter qrCodeHbAdapter = this.pagerAdapter;
        if (qrCodeHbAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            qrCodeHbAdapter = null;
        }
        qrCodeHbAdapter.setDataList(dataList);
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "setDataList size=" + dataList.size());
    }

    public final void updateReceiveNum(@NotNull String listId, @Nullable Integer receiveNum) {
        Intrinsics.checkNotNullParameter(listId, "listId");
        QrCodeHbAdapter qrCodeHbAdapter = this.pagerAdapter;
        if (qrCodeHbAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            qrCodeHbAdapter = null;
        }
        qrCodeHbAdapter.updateReceiveNum(listId, receiveNum);
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "updateReceiveNum listId=" + listId + ", receiveNum=" + receiveNum);
    }
}
