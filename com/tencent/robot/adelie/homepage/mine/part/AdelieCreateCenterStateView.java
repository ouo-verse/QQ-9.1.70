package com.tencent.robot.adelie.homepage.mine.part;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0005\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0003R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\fR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 \u00a8\u0006,"}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterStateView;", "Landroid/widget/RelativeLayout;", "Lkotlin/Function0;", "", "callback", IECSearchBar.METHOD_SET_CALLBACK, "e", "d", "b", "Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterHeaderView;", "Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterHeaderView;", "headerContent", "Landroid/widget/RelativeLayout;", "footerContent", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "errorIcon", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "errorTips", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "i", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "errorRetryButton", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "headerView", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "D", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "scanningHeader", "E", "scanningFooter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieCreateCenterStateView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> callback;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ScanningLightView scanningHeader;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ScanningLightView scanningFooter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieCreateCenterHeaderView headerContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout footerContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView errorIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView errorTips;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIButton errorRetryButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout headerView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieCreateCenterStateView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QUIButton this_apply, AdelieCreateCenterStateView this$0, View view) {
        Function0<Unit> function0;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g() && (function0 = this$0.callback) != null) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void b() {
        this.callback = null;
    }

    public final void d() {
        AdelieCreateCenterHeaderView adelieCreateCenterHeaderView = this.headerContent;
        if (adelieCreateCenterHeaderView != null) {
            adelieCreateCenterHeaderView.setVisibility(0);
        }
        RelativeLayout relativeLayout = this.footerContent;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        ScanningLightView scanningLightView = this.scanningHeader;
        if (scanningLightView != null) {
            scanningLightView.setVisibility(8);
        }
        ScanningLightView scanningLightView2 = this.scanningFooter;
        if (scanningLightView2 != null) {
            scanningLightView2.setVisibility(8);
        }
        QUIButton qUIButton = this.errorRetryButton;
        if (qUIButton != null) {
            qUIButton.setVisibility(0);
        }
        TextView textView = this.errorTips;
        if (textView != null) {
            textView.setText("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
        }
        ImageView imageView = this.errorIcon;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.j3t);
        }
        RelativeLayout relativeLayout2 = this.headerView;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundColor(0);
        }
        AdelieCreateCenterHeaderView adelieCreateCenterHeaderView2 = this.headerContent;
        if (adelieCreateCenterHeaderView2 != null) {
            adelieCreateCenterHeaderView2.setData(null);
        }
    }

    public final void e() {
        AdelieCreateCenterHeaderView adelieCreateCenterHeaderView = this.headerContent;
        if (adelieCreateCenterHeaderView != null) {
            adelieCreateCenterHeaderView.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.footerContent;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        ScanningLightView scanningLightView = this.scanningHeader;
        if (scanningLightView != null) {
            scanningLightView.setVisibility(0);
        }
        ScanningLightView scanningLightView2 = this.scanningFooter;
        if (scanningLightView2 != null) {
            scanningLightView2.setVisibility(0);
        }
        RelativeLayout relativeLayout2 = this.headerView;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundResource(R.drawable.j3v);
        }
    }

    public final void setCallback(@Nullable Function0<Unit> callback) {
        this.callback = callback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieCreateCenterStateView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieCreateCenterStateView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieCreateCenterStateView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.dru, this);
        this.scanningHeader = (ScanningLightView) findViewById(R.id.f79724_j);
        this.scanningFooter = (ScanningLightView) findViewById(R.id.f79714_i);
        this.headerView = (RelativeLayout) findViewById(R.id.d3z);
        this.headerContent = (AdelieCreateCenterHeaderView) findViewById(R.id.x8d);
        this.footerContent = (RelativeLayout) findViewById(R.id.vdc);
        this.errorIcon = (ImageView) findViewById(R.id.byb);
        this.errorTips = (TextView) findViewById(R.id.byh);
        final QUIButton qUIButton = (QUIButton) findViewById(R.id.uwv);
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.mine.part.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdelieCreateCenterStateView.c(QUIButton.this, this, view);
                }
            });
        } else {
            qUIButton = null;
        }
        this.errorRetryButton = qUIButton;
    }
}
