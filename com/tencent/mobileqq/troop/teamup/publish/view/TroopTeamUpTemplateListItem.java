package com.tencent.mobileqq.troop.teamup.publish.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.profileskin.widget.QUITextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.teamup.publish.data.TroopTeamUpTemplateKt;
import com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpTemplateListItem;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.widget.listitem.QUIListItem;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTemplate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u00a2\u0006\u0004\b\"\u0010#R\u001a\u0010\u0007\u001a\u00020\u00038\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/view/TroopTeamUpTemplateListItem;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem;", "Lcom/tencent/mobileqq/troop/teamup/publish/view/TroopTeamUpTemplateListItem$a;", "", "I", "k", "()I", "itemHeight", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "Lcom/tencent/biz/qui/profileskin/widget/QUITextView;", "K", "Lcom/tencent/biz/qui/profileskin/widget/QUITextView;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/biz/qui/profileskin/widget/QUITextView;", "titleView", "Landroid/view/View;", "L", "Landroid/view/View;", "getDividerView", "()Landroid/view/View;", "dividerView", "M", "r", "contentView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpTemplateListItem extends QUIListItem<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    private final int itemHeight;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout container;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final QUITextView titleView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final View dividerView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final QUITextView contentView;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/view/TroopTeamUpTemplateListItem$a;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/troop/teamup/publish/view/TroopTeamUpTemplateListItem;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "M", "view", "", "position", "", "", "payloads", "", "K", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;", "getTemplate", "()Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;", "template", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends w<TroopTeamUpTemplateListItem> {
        static IPatchRedirector $redirector_;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TeamUpTemplate template;

        public a(@NotNull TeamUpTemplate template) {
            Intrinsics.checkNotNullParameter(template, "template");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) template);
            } else {
                this.template = template;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map L(a this$0, String str) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, Integer.valueOf(this$0.template.templateId)));
            return mapOf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.w
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public void F(@NotNull TroopTeamUpTemplateListItem view, int position, @NotNull List<? extends Object> payloads) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(position), payloads);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            view.setThemeId(getThemeId());
            view.s().setText(this.template.title);
            view.r().setText(TroopTeamUpTemplateKt.a(this.template));
            h.a.m(com.tencent.mobileqq.troop.teamup.report.a.f299203a, view, "em_group_model_list", ExposurePolicy.REPORT_FIRST, ClickPolicy.REPORT_ALL, new IDynamicParams() { // from class: com.tencent.mobileqq.troop.teamup.publish.view.c
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map L;
                    L = TroopTeamUpTemplateListItem.a.L(TroopTeamUpTemplateListItem.a.this, str);
                    return L;
                }
            }, null, 32, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.w
        @NotNull
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public TroopTeamUpTemplateListItem H(@NotNull ViewGroup parent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TroopTeamUpTemplateListItem) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            TroopTeamUpTemplateListItem troopTeamUpTemplateListItem = new TroopTeamUpTemplateListItem(context, null, 0, 6, null);
            troopTeamUpTemplateListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return troopTeamUpTemplateListItem;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopTeamUpTemplateListItem(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
    }

    @Override // com.tencent.mobileqq.widget.listitem.QUIListItem
    /* renamed from: k */
    protected int getItemHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.itemHeight;
    }

    @NotNull
    public final QUITextView r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (QUITextView) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.contentView;
    }

    @NotNull
    public final QUITextView s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QUITextView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.titleView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopTeamUpTemplateListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TroopTeamUpTemplateListItem(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopTeamUpTemplateListItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.itemHeight = getResources().getDimensionPixelSize(R.dimen.dar) * 2;
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        int dimensionPixelSize = linearLayout.getResources().getDimensionPixelSize(R.dimen.d_z);
        marginLayoutParams.setMargins(dimensionPixelSize, marginLayoutParams.topMargin, dimensionPixelSize, marginLayoutParams.bottomMargin);
        linearLayout.setLayoutParams(marginLayoutParams);
        linearLayout.setOrientation(1);
        d(linearLayout);
        this.container = linearLayout;
        QUITextView qUITextView = new QUITextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int dimensionPixelSize2 = qUITextView.getResources().getDimensionPixelSize(R.dimen.f158729nj);
        layoutParams.setMargins(((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, dimensionPixelSize2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, dimensionPixelSize2);
        qUITextView.setLayoutParams(layoutParams);
        qUITextView.setTextColor(qUITextView.getResources().getColor(R.color.qui_common_text_primary, null));
        qUITextView.setSingleLine(true);
        qUITextView.setMaxLines(1);
        qUITextView.setEllipsize(TextUtils.TruncateAt.END);
        qUITextView.setTextSize(0, qUITextView.getResources().getDimension(R.dimen.da_));
        qUITextView.setTypeface(null, 1);
        linearLayout.addView(qUITextView);
        this.titleView = qUITextView;
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.f159499da3)));
        view.setBackground(ResourcesCompat.getDrawable(view.getResources(), R.drawable.qui_common_border_standard_bg, null));
        linearLayout.addView(view);
        this.dividerView = view;
        QUITextView qUITextView2 = new QUITextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        int dimensionPixelSize3 = qUITextView2.getResources().getDimensionPixelSize(R.dimen.c9y);
        layoutParams2.setMargins(((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin, dimensionPixelSize3, ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, dimensionPixelSize3);
        qUITextView2.setLayoutParams(layoutParams2);
        qUITextView2.setTextColor(qUITextView2.getResources().getColor(R.color.qui_common_text_secondary, null));
        qUITextView2.setSingleLine(false);
        qUITextView2.setMaxLines(2);
        qUITextView2.setEllipsize(TextUtils.TruncateAt.END);
        qUITextView2.setTextSize(0, qUITextView2.getResources().getDimension(R.dimen.da_));
        qUITextView2.setGravity(16);
        linearLayout.addView(qUITextView2);
        this.contentView = qUITextView2;
    }
}
