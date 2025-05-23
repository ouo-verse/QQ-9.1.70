package kz1;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mz1.AdditionAppItem;
import mz1.NavigatorItem;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\t\u00a8\u0006\u001e"}, d2 = {"Lkz1/f;", "Lkz1/g;", "Lmz1/c;", "Lvp1/f;", "Lmz1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "y", "D", "", "isShowOperateIcon", BdhLogUtil.LogTag.Tag_Conn, "isEditStatus", "L", "Lmz1/d;", "E", ViewStickEventHelper.IS_SHOW, "M", "isSetDefaultZero", "K", "", "position", DomainData.DOMAIN_NAME, "isDragMove", "J", "viewBinding", "<init>", "(Lvp1/f;)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f extends g<mz1.c, vp1.f> {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lkz1/f$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lkz1/f;", "a", "", "FLEX_BASIS_33_PERCENT", UserInfo.SEX_FEMALE, "FLEX_BASIS_50_PERCENT", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kz1.f$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final f a(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            vp1.f g16 = vp1.f.g(com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(parent), parent, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(parent.layoutInflater, parent, false)");
            return new f(g16);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull vp1.f viewBinding) {
        super(viewBinding);
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        LinearLayout linearLayout = viewBinding.f443012e;
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        linearLayout.setBackground(GuildUIUtils.n(guildUIUtils, context, R.color.qui_common_text_primary, 0.5f, 100.0f, 0.0f, 0.0f, 48, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(f this$0, AdditionAppItem item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.o().c(item);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(f this$0, AdditionAppItem item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.o().g(item);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C(AdditionAppItem item, boolean isShowOperateIcon) {
        boolean z16;
        int i3;
        int i16;
        ImageView imageView = s().f443009b;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.ivAdd");
        boolean z17 = true;
        int i17 = 0;
        if (isShowOperateIcon && item.getEditType() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        ImageView imageView2 = s().f443011d;
        Intrinsics.checkNotNullExpressionValue(imageView2, "viewBinding.ivDelete");
        if (!isShowOperateIcon || item.getEditType() == 0) {
            z17 = false;
        }
        if (!z17) {
            i17 = 8;
        }
        imageView2.setVisibility(i17);
        if (item.getEditType() != 0) {
            i16 = R.color.qui_common_text_primary;
        } else {
            i16 = R.color.qui_common_icon_tertiary;
        }
        int i18 = i16;
        LinearLayout linearLayout = s().f443012e;
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        linearLayout.setBackground(GuildUIUtils.n(guildUIUtils, context, i18, 0.5f, 100.0f, 0.0f, 0.0f, 48, null));
    }

    private final void D(AdditionAppItem item) {
        if (item.getFlexType() != 0 && (this.itemView.getLayoutParams() instanceof FlexboxLayoutManager.LayoutParams)) {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayoutManager.LayoutParams");
            FlexboxLayoutManager.LayoutParams layoutParams2 = (FlexboxLayoutManager.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
            layoutParams2.a(-1.0f);
            int flexType = item.getFlexType();
            if (flexType != 1) {
                if (flexType != 2) {
                    if (flexType == 3) {
                        layoutParams2.a(0.333f);
                    }
                } else {
                    layoutParams2.a(0.5f);
                }
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
            }
            this.itemView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
    
        if (r1.intValue() == 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void E(final mz1.d item) {
        final boolean z16;
        float f16;
        Integer d16 = o().d();
        if (d16 != null) {
            z16 = true;
        }
        z16 = false;
        LinearLayout linearLayout = s().f443012e;
        if (item.getIsOverServiceNumber()) {
            f16 = 0.3f;
        } else {
            f16 = 1.0f;
        }
        linearLayout.setAlpha(f16);
        ViewUtils viewUtils = ViewUtils.f352270a;
        linearLayout.setPadding(viewUtils.b(20), linearLayout.getPaddingTop(), viewUtils.b(22), linearLayout.getPaddingBottom());
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        linearLayout.setBackground(GuildUIUtils.n(guildUIUtils, context, R.color.qui_common_icon_tertiary, 0.5f, 100.0f, 0.0f, 0.0f, 48, null));
        s().getRoot().setOnClickListener(new View.OnClickListener() { // from class: kz1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.H(f.this, z16, item, view);
            }
        });
        K(false);
        s().f443010c.setImageDrawable(this.itemView.getContext().getDrawable(R.drawable.guild_app_manage_customize));
        ImageView imageView = s().f443009b;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.ivAdd");
        imageView.setVisibility(8);
        ImageView imageView2 = s().f443011d;
        Intrinsics.checkNotNullExpressionValue(imageView2, "viewBinding.ivDelete");
        imageView2.setVisibility(8);
        s().f443014g.setText(this.itemView.getContext().getString(R.string.f1489210w));
        if (this.itemView.getLayoutParams() instanceof FlexboxLayoutManager.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayoutManager.LayoutParams");
            FlexboxLayoutManager.LayoutParams layoutParams2 = (FlexboxLayoutManager.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
            layoutParams2.a(-1.0f);
            if (z16) {
                layoutParams2.a(0.333f);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
            }
            this.itemView.setLayoutParams(layoutParams2);
        }
        VideoReport.setElementId(s().getRoot(), "em_sgrp_apply_category_max_tips");
        VideoReport.setElementExposePolicy(s().getRoot(), ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(s().getRoot(), ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(f this$0, boolean z16, mz1.d item, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard") && !z16) {
            lz1.a o16 = this$0.o();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            o16.f(it, item);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I(f this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o().b(this$0);
        return true;
    }

    private final void K(boolean isSetDefaultZero) {
        LinearLayout.LayoutParams layoutParams;
        float f16;
        ViewGroup.LayoutParams layoutParams2 = s().f443014g.getLayoutParams();
        if (layoutParams2 instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            if (isSetDefaultZero) {
                f16 = 0.0f;
            } else {
                f16 = 1.0f;
            }
            layoutParams.weight = f16;
            s().f443014g.setLayoutParams(layoutParams);
        }
    }

    private final void L(boolean isEditStatus) {
        int i3;
        ViewUtils viewUtils;
        int i16;
        LinearLayout linearLayout = s().f443012e;
        ViewUtils viewUtils2 = ViewUtils.f352270a;
        if (isEditStatus) {
            i3 = 12;
        } else {
            i3 = 20;
        }
        int b16 = viewUtils2.b(i3);
        if (isEditStatus) {
            viewUtils = ViewUtils.f352270a;
            i16 = 0;
        } else {
            viewUtils = ViewUtils.f352270a;
            i16 = 22;
        }
        linearLayout.setPadding(b16, linearLayout.getPaddingTop(), viewUtils.b(i16), linearLayout.getPaddingBottom());
    }

    private final void M(boolean isShow) {
        int i3;
        int v3 = GuildUIUtils.f235378a.v(Color.parseColor("#2B64F5"), 0.2f, true);
        if (!isShow) {
            v3 = this.itemView.getContext().getResources().getColor(R.color.ajr);
        }
        s().f443013f.setShadowColor(v3);
        s().f443013f.setFillColor(this.itemView.getContext().getResources().getColorStateList(R.color.qui_common_bg_bottom_light), isShow);
        ShadowFrameLayout shadowFrameLayout = s().f443013f;
        if (isShow) {
            i3 = ViewUtils.f352270a.a(12.0f);
        } else {
            i3 = 0;
        }
        shadowFrameLayout.setShadowRadius(i3);
    }

    private final void y(final AdditionAppItem item) {
        final boolean z16;
        String str;
        Map<String, ? extends Object> mapOf;
        NavigatorItem navigation;
        String magnet;
        boolean z17;
        Integer d16 = o().d();
        if (d16 != null && d16.intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        s().f443012e.setAlpha(1.0f);
        L(z16);
        C(item, z16);
        K(!z16);
        s().getRoot().setOnClickListener(new View.OnClickListener() { // from class: kz1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.z(f.this, z16, item, view);
            }
        });
        s().f443009b.setOnClickListener(new View.OnClickListener() { // from class: kz1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.A(f.this, item, view);
            }
        });
        s().f443011d.setOnClickListener(new View.OnClickListener() { // from class: kz1.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.B(f.this, item, view);
            }
        });
        s().f443014g.setText(item.getAppName());
        if (item.getJumpType() == 11) {
            String iconUrl = item.getIconUrl();
            if (iconUrl != null && iconUrl.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                String iconUrl2 = item.getIconUrl();
                if (iconUrl2 != null) {
                    ImageView imageView = s().f443010c;
                    Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.ivAppIcon");
                    v.i(iconUrl2, imageView);
                }
                D(item);
                ShadowFrameLayout root = s().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
                Pair[] pairArr = new Pair[3];
                pairArr[0] = TuplesKt.to("sgrp_apply_category_name", item.getAppName());
                str = "";
                if (item.getJumpType() == 11 && (navigation = item.getNavigation()) != null && (magnet = navigation.getMagnet()) != null) {
                    str = magnet;
                }
                pairArr[1] = TuplesKt.to("sgrp_navigation_url", str);
                pairArr[2] = TuplesKt.to("sgrp_apply_category_type", Integer.valueOf(item.getJumpType()));
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                q(root, "em_sgrp_apply_category", true, mapOf, item.getItemId());
            }
        }
        if (item.getIconRes() != null) {
            ImageView imageView2 = s().f443010c;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            imageView2.setImageDrawable(GuildUIUtils.w(context, item.getIconRes().intValue(), Integer.valueOf(R.color.qui_common_icon_primary)));
        } else {
            s().f443010c.setImageDrawable(null);
        }
        D(item);
        ShadowFrameLayout root2 = s().getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "viewBinding.root");
        Pair[] pairArr2 = new Pair[3];
        pairArr2[0] = TuplesKt.to("sgrp_apply_category_name", item.getAppName());
        str = "";
        if (item.getJumpType() == 11) {
            str = magnet;
        }
        pairArr2[1] = TuplesKt.to("sgrp_navigation_url", str);
        pairArr2[2] = TuplesKt.to("sgrp_apply_category_type", Integer.valueOf(item.getJumpType()));
        mapOf = MapsKt__MapsKt.mapOf(pairArr2);
        q(root2, "em_sgrp_apply_category", true, mapOf, item.getItemId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(f this$0, boolean z16, AdditionAppItem item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard") && !z16) {
            this$0.o().e(item);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void J(boolean isDragMove) {
        int i3;
        int i16;
        if (!(this.itemView.getTag() instanceof AdditionAppItem)) {
            return;
        }
        Object tag = this.itemView.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.model.AdditionAppItem");
        AdditionAppItem additionAppItem = (AdditionAppItem) tag;
        M(isDragMove);
        L(!isDragMove);
        ViewGroup.LayoutParams layoutParams = s().f443012e.getLayoutParams();
        if (layoutParams != null) {
            if (isDragMove) {
                i16 = -2;
            } else {
                i16 = -1;
            }
            layoutParams.width = i16;
            s().f443012e.setLayoutParams(layoutParams);
        }
        C(additionAppItem, !isDragMove);
        LinearLayout linearLayout = s().f443012e;
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        if (isDragMove) {
            i3 = R.color.qui_common_feedback_normal;
        } else {
            i3 = R.color.qui_common_text_primary;
        }
        linearLayout.setBackground(GuildUIUtils.n(guildUIUtils, context, i3, 0.5f, 100.0f, 0.0f, 0.0f, 48, null));
    }

    @Override // kz1.i
    public void n(@NotNull mz1.c item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        boolean z16 = item instanceof AdditionAppItem;
        if (z16) {
            y((AdditionAppItem) item);
        } else if (item instanceof mz1.d) {
            E((mz1.d) item);
        }
        if (z16 && ((AdditionAppItem) item).getIsCanDragEdit()) {
            s().getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: kz1.a
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean I;
                    I = f.I(f.this, view);
                    return I;
                }
            });
        } else {
            s().getRoot().setOnLongClickListener(null);
        }
    }
}
