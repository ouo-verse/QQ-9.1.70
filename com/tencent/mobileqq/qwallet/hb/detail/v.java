package com.tencent.mobileqq.qwallet.hb.detail;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk2.HbDetailCommon;
import sk2.QWalletHbCommonConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/v;", "", "", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "d", "Landroid/view/View;", "lastView", "c", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "knowSkinText", "", "b", "Z", "needShow", "", "Ljava/lang/String;", "knowSkinTitle", "knowSkinUrl", "", "I", "recyclerViewTop", "f", "recyclerViewBottom", "g", "recyclerViewPaddingBottom", tl.h.F, "lastViewBottom", "<init>", "(Landroid/widget/TextView;Z)V", "i", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView knowSkinText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean needShow;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String knowSkinTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String knowSkinUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int recyclerViewTop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int recyclerViewBottom;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int recyclerViewPaddingBottom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int lastViewBottom;

    public v(@NotNull TextView knowSkinText, boolean z16) {
        String str;
        boolean z17;
        Intrinsics.checkNotNullParameter(knowSkinText, "knowSkinText");
        this.knowSkinText = knowSkinText;
        this.needShow = z16;
        QWalletHbCommonConfig qWalletHbCommonConfig = (QWalletHbCommonConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_HB_COMMON_CONFIG, new QWalletHbCommonConfig(null, null, false, false, 15, null));
        HbDetailCommon hbDetail = qWalletHbCommonConfig.getHbDetail();
        if (hbDetail != null) {
            str = hbDetail.getKnowSkinTitle();
        } else {
            str = null;
        }
        this.knowSkinTitle = str;
        HbDetailCommon hbDetail2 = qWalletHbCommonConfig.getHbDetail();
        this.knowSkinUrl = hbDetail2 != null ? hbDetail2.getKnowSkinUrl() : null;
        String str2 = this.knowSkinTitle;
        boolean z18 = true;
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            String str3 = this.knowSkinUrl;
            if (str3 != null && str3.length() != 0) {
                z18 = false;
            }
            if (!z18) {
                knowSkinText.setText(this.knowSkinTitle);
                knowSkinText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        v.b(v.this, view);
                    }
                });
                return;
            }
        }
        knowSkinText.setVisibility(8);
        this.needShow = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(v this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qwallet.utils.k.h(this$0.knowSkinText.getContext(), this$0.knowSkinUrl);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void e() {
        if (!this.needShow) {
            return;
        }
        int i3 = this.recyclerViewBottom;
        if (i3 == 0 && this.lastViewBottom == 0) {
            this.knowSkinText.setVisibility(8);
            QLog.e("HbDetailKnowSkinVC", 1, "updateUserBalance: error bottom is 0");
            return;
        }
        int max = Math.max(i3 - this.recyclerViewPaddingBottom, this.recyclerViewTop + this.lastViewBottom);
        if (max >= this.recyclerViewBottom) {
            this.knowSkinText.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.knowSkinText.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = max;
            this.knowSkinText.setLayoutParams(layoutParams);
            this.knowSkinText.setVisibility(0);
        }
    }

    public final void c(@NotNull View lastView) {
        Intrinsics.checkNotNullParameter(lastView, "lastView");
        this.lastViewBottom = lastView.getBottom();
        e();
    }

    public final void d(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerViewBottom = recyclerView.getBottom();
        this.recyclerViewPaddingBottom = recyclerView.getPaddingBottom();
        this.recyclerViewTop = recyclerView.getTop();
        e();
    }
}
