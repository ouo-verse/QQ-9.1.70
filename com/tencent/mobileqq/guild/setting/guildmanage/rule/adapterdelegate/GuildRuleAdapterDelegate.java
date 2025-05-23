package com.tencent.mobileqq.guild.setting.guildmanage.rule.adapterdelegate;

import android.os.Build;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.rule.adapterdelegate.GuildRuleAdapterDelegate;
import com.tencent.mobileqq.guild.setting.guildmanage.rule.t;
import com.tencent.mobileqq.guild.setting.guildmanage.rule.u;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.EdgeTransparentView;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.inputview.CharacterCountEditText;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import h53.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rz1.RuleItemData;
import rz1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0001\u001eB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007H\u0014J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/adapterdelegate/GuildRuleAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lrz1/e;", "Lrz1/b;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/adapterdelegate/GuildRuleAdapterDelegate$a;", "Landroid/view/View$OnClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/t;", "d", "Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/t;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/t;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRuleAdapterDelegate extends AbsListItemAdapterDelegate<RuleItemData, b, a> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final t eventHandler;

    public GuildRuleAdapterDelegate(@NotNull t eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull b item, @NotNull List<? extends b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof RuleItemData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!QQGuildUIUtil.v()) {
            Object tag = v3.getTag();
            if ((tag instanceof RuleItemData) && v3.getId() == R.id.ug6) {
                this.eventHandler.c().invoke(v3, ((RuleItemData) tag).getRuleData());
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull RuleItemData item, @NotNull a holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.contains(2)) {
            holder.C();
        } else {
            holder.s(item);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f6x, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026edit_item, parent, false)");
        a aVar = new a(inflate, this.eventHandler);
        aVar.getDeleteView().setOnClickListener(this);
        return aVar;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u00015B\u0017\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\u0004*\u00020\b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010*\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010)R\u0017\u0010/\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/adapterdelegate/GuildRuleAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lrz1/e;", "data", "", "r", "D", "u", "Lcom/tencent/mobileqq/guild/widget/EdgeTransparentView;", "", "show", "", "position", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/t;", "E", "Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/t;", "eventHandler", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "orderNumber", "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", "G", "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", "y", "()Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", "ruleTitle", "H", "w", "ruleDesc", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "v", "()Landroid/widget/ImageView;", "deleteView", "J", HippyTKDListViewAdapter.X, "()Landroid/widget/TextView;", "ruleDescCount", "K", "Lcom/tencent/mobileqq/guild/widget/EdgeTransparentView;", "getEdgeContainer", "()Lcom/tencent/mobileqq/guild/widget/EdgeTransparentView;", "edgeContainer", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/t;)V", "L", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final t eventHandler;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView orderNumber;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final CharacterCountEditText ruleTitle;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final CharacterCountEditText ruleDesc;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final ImageView deleteView;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TextView ruleDescCount;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final EdgeTransparentView edgeContainer;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/rule/adapterdelegate/GuildRuleAdapterDelegate$a$c", "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText$b;", "", "l", "t", "oldl", "oldt", "", "onScrollChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class c implements CharacterCountEditText.b {
            c() {
            }

            @Override // com.tencent.mobileqq.widget.inputview.CharacterCountEditText.b
            public void onScrollChanged(int l3, int t16, int oldl, int oldt) {
                a.this.u();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView, @NotNull t eventHandler) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
            this.eventHandler = eventHandler;
            View findViewById = itemView.findViewById(R.id.f2146013);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.order_number)");
            TextView textView = (TextView) findViewById;
            this.orderNumber = textView;
            View findViewById2 = itemView.findViewById(R.id.f787147t);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.rule_title)");
            CharacterCountEditText characterCountEditText = (CharacterCountEditText) findViewById2;
            this.ruleTitle = characterCountEditText;
            View findViewById3 = itemView.findViewById(R.id.f786647o);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.rule_desc)");
            CharacterCountEditText characterCountEditText2 = (CharacterCountEditText) findViewById3;
            this.ruleDesc = characterCountEditText2;
            View findViewById4 = itemView.findViewById(R.id.ug6);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.delete_view)");
            this.deleteView = (ImageView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f786747p);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.rule_desc_count)");
            this.ruleDescCount = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.upi);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.\u2026ge_transparent_container)");
            this.edgeContainer = (EdgeTransparentView) findViewById6;
            textView.setTypeface(u.f234280a.a());
            if (Build.VERSION.SDK_INT >= 29) {
                characterCountEditText.setBreakStrategy(1);
            }
            characterCountEditText.setLimitCount(20);
            characterCountEditText2.setLimitCount(200);
            characterCountEditText.setInputViewWatcher(new C7899a());
            characterCountEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: qz1.b
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z16) {
                    GuildRuleAdapterDelegate.a.o(GuildRuleAdapterDelegate.a.this, view, z16);
                }
            });
            characterCountEditText2.setInputViewWatcher(new b());
            characterCountEditText2.setScrollChangedListener(new c());
        }

        private final void A(EdgeTransparentView edgeTransparentView, boolean z16, int i3) {
            int i16;
            if (z16) {
                edgeTransparentView.setEdgePosition(i3);
            }
            if (z16) {
                i16 = QQGuildUIUtil.f(24.0f);
            } else {
                i16 = 0;
            }
            edgeTransparentView.setEdgeWidth(i16);
        }

        static /* synthetic */ void B(a aVar, EdgeTransparentView edgeTransparentView, boolean z16, int i3, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            aVar.A(edgeTransparentView, z16, i3);
        }

        private final void D() {
            if (this.ruleDesc.isFocused()) {
                this.ruleDescCount.setVisibility(0);
                GuildUIUtils.f235378a.b(this.ruleDesc, R.color.qui_common_text_primary);
            } else {
                this.ruleDescCount.setVisibility(8);
                GuildUIUtils.f235378a.b(this.ruleDesc, R.color.qui_common_text_secondary);
            }
            GuildUIUtils.d(this.deleteView, R.drawable.qui_delete_light, Integer.valueOf(R.color.qui_common_icon_secondary));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(final a this$0, View view, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.D();
            this$0.ruleDesc.post(new Runnable() { // from class: qz1.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildRuleAdapterDelegate.a.z(GuildRuleAdapterDelegate.a.this);
                }
            });
        }

        private final void r(RuleItemData data) {
            this.ruleTitle.setTag(data);
            this.ruleDesc.setTag(data);
            this.deleteView.setTag(data);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(a this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void u() {
            if (!this.ruleDesc.hasFocus() && (this.ruleDesc.canScrollVertically(-1) || this.ruleDesc.canScrollVertically(1))) {
                int i3 = 0;
                if (this.ruleDesc.canScrollVertically(-1)) {
                    i3 = 0 | EdgeTransparentView.G;
                }
                if (this.ruleDesc.canScrollVertically(1)) {
                    i3 |= EdgeTransparentView.H;
                }
                if (i3 == 0) {
                    i3 = EdgeTransparentView.H | EdgeTransparentView.G;
                }
                A(this.edgeContainer, true, i3);
                return;
            }
            B(this, this.edgeContainer, false, 0, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(a this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.u();
        }

        public final void C() {
            this.ruleTitle.requestFocus();
            InputMethodUtil.show(this.ruleTitle);
        }

        public final void s(@NotNull RuleItemData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            r(data);
            this.orderNumber.setText(String.valueOf(data.getOrder()));
            this.ruleTitle.setHint("\u8f93\u5165\u7b2c" + data.getOrder() + "\u6761\u89c4\u5219");
            this.ruleTitle.setText(data.getRuleData().getTitle());
            this.ruleDesc.setText(data.getRuleData().getContent());
            D();
            this.ruleDesc.post(new Runnable() { // from class: qz1.a
                @Override // java.lang.Runnable
                public final void run() {
                    GuildRuleAdapterDelegate.a.t(GuildRuleAdapterDelegate.a.this);
                }
            });
        }

        @NotNull
        /* renamed from: v, reason: from getter */
        public final ImageView getDeleteView() {
            return this.deleteView;
        }

        @NotNull
        /* renamed from: w, reason: from getter */
        public final CharacterCountEditText getRuleDesc() {
            return this.ruleDesc;
        }

        @NotNull
        /* renamed from: x, reason: from getter */
        public final TextView getRuleDescCount() {
            return this.ruleDescCount;
        }

        @NotNull
        /* renamed from: y, reason: from getter */
        public final CharacterCountEditText getRuleTitle() {
            return this.ruleTitle;
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/rule/adapterdelegate/GuildRuleAdapterDelegate$a$a", "Lh53/k;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.rule.adapterdelegate.GuildRuleAdapterDelegate$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7899a implements k {
            C7899a() {
            }

            @Override // h53.k
            public void afterTextChanged(@Nullable Editable s16) {
                String obj = a.this.getRuleTitle().getText().toString();
                String replace = new Regex("\\s+").replace(obj, " ");
                if (!Intrinsics.areEqual(replace, obj)) {
                    a.this.getRuleTitle().setText(replace);
                    a.this.getRuleTitle().setSelection(a.this.getRuleTitle().getText().length());
                } else {
                    Object tag = a.this.getRuleTitle().getTag();
                    if (tag instanceof RuleItemData) {
                        ((RuleItemData) tag).getRuleData().g(obj);
                    }
                    a.this.eventHandler.b().invoke();
                }
            }

            @Override // h53.k
            public void f8(boolean z16) {
                k.a.a(this, z16);
            }

            @Override // h53.k
            public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
                if (a.this.getRuleTitle().getCurrentCount() > a.this.getRuleTitle().getCharacterLimitCount()) {
                    QQToast.makeText(a.this.getRuleTitle().getContext(), 0, "\u5df2\u8fbe\u5b57\u6570\u4e0a\u9650" + a.this.getRuleTitle().getCharacterLimitCount() + "\u4e2a\u5b57", 0).show();
                }
            }

            @Override // h53.k
            public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/rule/adapterdelegate/GuildRuleAdapterDelegate$a$b", "Lh53/k;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class b implements k {
            b() {
            }

            @Override // h53.k
            public void afterTextChanged(@Nullable Editable s16) {
                String str;
                if (a.this.getRuleDesc().getCharacterLimitCount() > 0) {
                    if (a.this.getRuleDesc().getCurrentCount() > 0) {
                        str = a.this.getRuleDesc().getCurrentCount() + "/" + a.this.getRuleDesc().getCharacterLimitCount() + "\u5b57";
                    } else {
                        str = a.this.getRuleDesc().getCharacterLimitCount() + "\u5b57";
                    }
                    a.this.getRuleDescCount().setText(str);
                }
                Object tag = a.this.getRuleDesc().getTag();
                if (tag instanceof RuleItemData) {
                    ((RuleItemData) tag).getRuleData().f(a.this.getRuleDesc().getText().toString());
                }
                a.this.eventHandler.b().invoke();
            }

            @Override // h53.k
            public void f8(boolean z16) {
                k.a.a(this, z16);
            }

            @Override // h53.k
            public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
                if (a.this.getRuleDesc().getCurrentCount() > a.this.getRuleDesc().getCharacterLimitCount()) {
                    QQToast.makeText(a.this.getRuleDesc().getContext(), 0, "\u5df2\u8fbe\u5b57\u6570\u4e0a\u9650" + a.this.getRuleDesc().getCharacterLimitCount() + "\u4e2a\u5b57", 0).show();
                }
            }

            @Override // h53.k
            public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            }
        }
    }
}
