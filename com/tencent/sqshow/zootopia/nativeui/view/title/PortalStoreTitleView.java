package com.tencent.sqshow.zootopia.nativeui.view.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.card.view.widget.PortalStoreCurrencyView;
import com.tencent.sqshow.zootopia.nativeui.data.repo.h;
import com.tencent.sqshow.zootopia.nativeui.data.repo.p;
import com.tencent.sqshow.zootopia.utils.aa;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.ch;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u00012B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u000e\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00063"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStoreTitleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "D0", "H0", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "commonData", "Lb94/c;", "backHandler", "F0", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStoreTitleView$Companion$a;", "listener", "setOnBackListener", "destroy", "", "style", "setStyle", "Ln74/ch;", "d", "Ln74/ch;", "mBinding", "e", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "f", "Lb94/c;", "mBackHandler", "Landroidx/lifecycle/Observer;", "Lcom/tencent/sqshow/zootopia/data/f;", tl.h.F, "Landroidx/lifecycle/Observer;", "coinUpdateObserver", "i", "I", "mStyle", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "mPageId", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStoreTitleView$Companion$a;", "backListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "Companion", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreTitleView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private Companion.a backListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ch mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b94.c mBackHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Observer<com.tencent.sqshow.zootopia.data.f> coinUpdateObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mStyle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String mPageId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreTitleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(PortalStoreTitleView this$0, View view) {
        Map<String, Object> hashMap;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        y94.a reporter2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion.a aVar = this$0.backListener;
        if (aVar != null) {
            aVar.a(this$0.mStyle);
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this$0.mChannel;
        if (jVar == null || (reporter2 = jVar.getReporter()) == null || (hashMap = reporter2.b()) == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put("zplan_is_loading", "1");
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this$0.mChannel;
        if (jVar2 == null || (reporter = jVar2.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
            return;
        }
        ImageView imageView = this$0.mBinding.f419010b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.backIgv");
        ZplanViewReportHelper.f(mReporter, imageView, "em_zplan_back_btn", null, 4, null);
    }

    private final void D0() {
        gb4.a.f401894a.b().removeObserver(this.coinUpdateObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(PortalStoreTitleView this$0, com.tencent.sqshow.zootopia.data.f data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PortalStoreCurrencyView portalStoreCurrencyView = this$0.mBinding.f419011c;
        Intrinsics.checkNotNullExpressionValue(data, "data");
        portalStoreCurrencyView.h(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(com.tencent.sqshow.zootopia.nativeui.data.j commonData, PortalStoreTitleView this$0, View view) {
        Intrinsics.checkNotNullParameter(commonData, "$commonData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZplanViewReportHelper mReporter = commonData.getReporter().getMReporter();
        PortalStoreCurrencyView portalStoreCurrencyView = this$0.mBinding.f419011c;
        Intrinsics.checkNotNullExpressionValue(portalStoreCurrencyView, "mBinding.coinArea");
        ZplanViewReportHelper.f(mReporter, portalStoreCurrencyView, "em_zplan_recharge", null, 4, null);
    }

    private final void H0() {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        QLog.i("PortalStoreTitleView_", 1, "updateCurrency begin");
        p dataControllerV1 = jVar.getDataControllerV1();
        if (dataControllerV1 != null) {
            h.a.a(dataControllerV1, null, 1, null);
        }
    }

    public final void F0(final com.tencent.sqshow.zootopia.nativeui.data.j commonData, b94.c backHandler) {
        Intrinsics.checkNotNullParameter(commonData, "commonData");
        this.mChannel = commonData;
        this.mBackHandler = backHandler;
        LifecycleOwner lifecycleOwner = commonData.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        gb4.a.f401894a.b().observe(lifecycleOwner, this.coinUpdateObserver);
        H0();
        this.mBinding.f419011c.setCoinListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreTitleView.G0(com.tencent.sqshow.zootopia.nativeui.data.j.this, this, view);
            }
        });
    }

    public final void destroy() {
        D0();
    }

    public final void setOnBackListener(Companion.a listener) {
        this.backListener = listener;
    }

    public final void setStyle(@Companion.AvatarNativeTitleViewStyle int style) {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        y94.a reporter2;
        Map<String, Object> hashMap;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2;
        y94.a reporter3;
        ZplanViewReportHelper mReporter2;
        y94.a reporter4;
        ZplanViewReportHelper mReporter3;
        y94.a reporter5;
        y94.a reporter6;
        ZplanViewReportHelper mReporter4;
        y94.a reporter7;
        y94.a reporter8;
        ZplanViewReportHelper mReporter5;
        y94.a reporter9;
        QLog.i("PortalStoreTitleView_", 1, "setStyle style:" + style);
        Map<String, Object> map = null;
        if (style == 0) {
            this.mBinding.f419011c.setVisibility(0);
            if (!Intrinsics.areEqual(this.mPageId, "pg_zplan_avatar_mall") && (jVar = this.mChannel) != null && (reporter = jVar.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
                if (jVar3 != null && (reporter2 = jVar3.getReporter()) != null) {
                    map = reporter2.b();
                }
                mReporter.a(context, this, "pg_zplan_avatar_mall", map);
            }
        } else if (style == 1) {
            this.mBinding.f419011c.setVisibility(8);
            com.tencent.sqshow.zootopia.nativeui.data.j jVar4 = this.mChannel;
            if (jVar4 != null && (reporter6 = jVar4.getReporter()) != null && (mReporter4 = reporter6.getMReporter()) != null) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                com.tencent.sqshow.zootopia.nativeui.data.j jVar5 = this.mChannel;
                if (jVar5 != null && (reporter7 = jVar5.getReporter()) != null) {
                    map = reporter7.b();
                }
                mReporter4.a(context2, this, "pg_zplan_avatar_sculpt", map);
            }
            this.mPageId = "pg_zplan_avatar_sculpt";
        } else if (style == 2) {
            this.mBinding.f419011c.setVisibility(0);
            com.tencent.sqshow.zootopia.nativeui.data.j jVar6 = this.mChannel;
            if (jVar6 != null && (reporter8 = jVar6.getReporter()) != null && (mReporter5 = reporter8.getMReporter()) != null) {
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                com.tencent.sqshow.zootopia.nativeui.data.j jVar7 = this.mChannel;
                if (jVar7 != null && (reporter9 = jVar7.getReporter()) != null) {
                    map = reporter9.b();
                }
                mReporter5.a(context3, this, "pg_zplan_avatar_dye", map);
            }
            this.mPageId = "pg_zplan_avatar_dye";
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar8 = this.mChannel;
        if (jVar8 == null || (reporter5 = jVar8.getReporter()) == null || (hashMap = reporter5.b()) == null) {
            hashMap = new HashMap<>();
        }
        Map<String, Object> map2 = hashMap;
        map2.put("zplan_is_loading", "1");
        com.tencent.sqshow.zootopia.nativeui.data.j jVar9 = this.mChannel;
        if (jVar9 != null && (reporter4 = jVar9.getReporter()) != null && (mReporter3 = reporter4.getMReporter()) != null) {
            ImageView imageView = this.mBinding.f419010b;
            Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.backIgv");
            mReporter3.g(imageView, "em_zplan_back_btn", (r16 & 4) != 0 ? null : map2, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
        if (this.mBinding.f419011c.getVisibility() == 0 && (jVar2 = this.mChannel) != null && (reporter3 = jVar2.getReporter()) != null && (mReporter2 = reporter3.getMReporter()) != null) {
            PortalStoreCurrencyView portalStoreCurrencyView = this.mBinding.f419011c;
            Intrinsics.checkNotNullExpressionValue(portalStoreCurrencyView, "mBinding.coinArea");
            mReporter2.g(portalStoreCurrencyView, "em_zplan_recharge", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
        this.mStyle = style;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PortalStoreTitleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreTitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ch f16 = ch.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.coinUpdateObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreTitleView.E0(PortalStoreTitleView.this, (com.tencent.sqshow.zootopia.data.f) obj);
            }
        };
        this.mStyle = -1;
        this.mPageId = "pg_zplan_avatar_mall";
        ImageView imageView = f16.f419010b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.backIgv");
        aa.d(imageView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreTitleView.C0(PortalStoreTitleView.this, view);
            }
        });
    }
}
