package com.tencent.mobileqq.qwallet.web;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qwallet.c;
import com.tencent.mobileqq.qwallet.web.DoubleWebContainerFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qwallet/web/DoubleWebContainerFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "leftPageTitle", "D", "rightPageTitle", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "leftPageIcon", UserInfo.SEX_FEMALE, "rightPageIcon", "Landroidx/viewpager2/widget/ViewPager2;", "G", "Landroidx/viewpager2/widget/ViewPager2;", "fragmentContainer", "Ltl2/a;", "H", "Ltl2/a;", "fragmentAdapter", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class DoubleWebContainerFragment extends QWalletBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView leftPageTitle;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView rightPageTitle;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView leftPageIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView rightPageIcon;

    /* renamed from: G, reason: from kotlin metadata */
    private ViewPager2 fragmentContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private a fragmentAdapter;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(DoubleWebContainerFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(DoubleWebContainerFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.leftPageTitle;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftPageTitle");
            textView = null;
        }
        textView.setTextSize(2, 21.0f);
        TextView textView3 = this$0.leftPageTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftPageTitle");
            textView3 = null;
        }
        textView3.setTypeface(Typeface.defaultFromStyle(1));
        TextView textView4 = this$0.rightPageTitle;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightPageTitle");
            textView4 = null;
        }
        textView4.setTextSize(2, 17.0f);
        TextView textView5 = this$0.rightPageTitle;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightPageTitle");
            textView5 = null;
        }
        textView5.setTypeface(Typeface.defaultFromStyle(0));
        ViewPager2 viewPager2 = this$0.fragmentContainer;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            viewPager2 = null;
        }
        viewPager2.setCurrentItem(0, false);
        TextView textView6 = this$0.leftPageTitle;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftPageTitle");
        } else {
            textView2 = textView6;
        }
        c.e("qqwallet.cellularphonereplenishingtab.click", "0", "", textView2.getText().toString(), "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(DoubleWebContainerFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.leftPageTitle;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftPageTitle");
            textView = null;
        }
        textView.setTextSize(2, 17.0f);
        TextView textView3 = this$0.leftPageTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftPageTitle");
            textView3 = null;
        }
        textView3.setTypeface(Typeface.defaultFromStyle(0));
        TextView textView4 = this$0.rightPageTitle;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightPageTitle");
            textView4 = null;
        }
        textView4.setTextSize(2, 21.0f);
        TextView textView5 = this$0.rightPageTitle;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightPageTitle");
            textView5 = null;
        }
        textView5.setTypeface(Typeface.defaultFromStyle(1));
        ViewPager2 viewPager2 = this$0.fragmentContainer;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            viewPager2 = null;
        }
        viewPager2.setCurrentItem(1, false);
        TextView textView6 = this$0.rightPageTitle;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightPageTitle");
        } else {
            textView2 = textView6;
        }
        c.e("qqwallet.cellularphonereplenishingtab.click", "1", "", textView2.getText().toString(), "");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hiq, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.ivTitleBtnLeft).setOnClickListener(new View.OnClickListener() { // from class: tl2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DoubleWebContainerFragment.sh(DoubleWebContainerFragment.this, view2);
            }
        });
        View findViewById = view.findViewById(R.id.yhc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.left_page_title)");
        this.leftPageTitle = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.f74783x7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.right_page_title)");
        this.rightPageTitle = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.yhb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.left_page_icon)");
        this.leftPageIcon = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f74773x6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.right_page_icon)");
        this.rightPageIcon = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(R.id.cks);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.fragment_container)");
        this.fragmentContainer = (ViewPager2) findViewById5;
        Intent intent = getIntent();
        TextView textView = null;
        if (intent != null) {
            arrayList = intent.getParcelableArrayListExtra("web_list");
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            QLog.d(QPublicBaseFragment.TAG, 1, "onViewCreated webList is null");
            finish();
            return;
        }
        if (arrayList.size() < 2) {
            QLog.d(QPublicBaseFragment.TAG, 1, "onViewCreated size < 2 " + arrayList);
            finish();
            return;
        }
        WebPageData webPageData = (WebPageData) arrayList.get(0);
        TextView textView2 = this.leftPageTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftPageTitle");
            textView2 = null;
        }
        textView2.setText(webPageData.getTitle());
        ImageView imageView = this.leftPageIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftPageIcon");
            imageView = null;
        }
        imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(webPageData.getIcon()));
        WebPageData webPageData2 = (WebPageData) arrayList.get(1);
        TextView textView3 = this.rightPageTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightPageTitle");
            textView3 = null;
        }
        textView3.setText(webPageData2.getTitle());
        ImageView imageView2 = this.rightPageIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightPageIcon");
            imageView2 = null;
        }
        imageView2.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(webPageData2.getIcon()));
        this.fragmentAdapter = new a(this, arrayList);
        ViewPager2 viewPager2 = this.fragmentContainer;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            viewPager2 = null;
        }
        viewPager2.setUserInputEnabled(false);
        ViewPager2 viewPager22 = this.fragmentContainer;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            viewPager22 = null;
        }
        a aVar = this.fragmentAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentAdapter");
            aVar = null;
        }
        viewPager22.setAdapter(aVar);
        TextView textView4 = this.leftPageTitle;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftPageTitle");
            textView4 = null;
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: tl2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DoubleWebContainerFragment.th(DoubleWebContainerFragment.this, view2);
            }
        });
        TextView textView5 = this.rightPageTitle;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightPageTitle");
        } else {
            textView = textView5;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: tl2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DoubleWebContainerFragment.uh(DoubleWebContainerFragment.this, view2);
            }
        });
    }
}
