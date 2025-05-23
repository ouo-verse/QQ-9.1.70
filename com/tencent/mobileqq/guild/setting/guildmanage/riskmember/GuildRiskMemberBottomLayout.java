package com.tencent.mobileqq.guild.setting.guildmanage.riskmember;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.df;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskMemberBottomLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "", "selectCount", "", "c", "", "isEditMode", "b", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/a;", "batchHandleRiskData", "a", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/f;", "onClickCallback", "setOnClickCallback", "Lvp1/df;", "d", "Lvp1/df;", "binding", "e", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/f;", "f", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/a;", "data", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRiskMemberBottomLayout extends LinearLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private df binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f onClickCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private BatchHandleRiskData data;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildRiskMemberBottomLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(boolean isEditMode) {
        if (isEditMode) {
            this.binding.f442888c.setVisibility(8);
            this.binding.f442889d.setVisibility(0);
        } else {
            this.binding.f442888c.setVisibility(0);
            this.binding.f442889d.setVisibility(8);
        }
    }

    private final void c(long selectCount) {
        String valueOf;
        if (selectCount > 500) {
            valueOf = "500+";
        } else {
            valueOf = String.valueOf(selectCount);
        }
        boolean z16 = true;
        this.binding.f442891f.setText(getContext().getString(R.string.f153321bs, valueOf));
        QUIButton qUIButton = this.binding.f442890e;
        if (selectCount <= 0) {
            z16 = false;
        }
        qUIButton.setEnabled(z16);
    }

    public final void a(@Nullable BatchHandleRiskData batchHandleRiskData) {
        BatchHandleRiskData batchHandleRiskData2;
        if (batchHandleRiskData == null) {
            batchHandleRiskData2 = new BatchHandleRiskData(false, false, null, 7, null);
        } else {
            batchHandleRiskData2 = batchHandleRiskData;
        }
        this.data = batchHandleRiskData2;
        if (batchHandleRiskData != null && batchHandleRiskData.getShowBatchHandleLayout()) {
            setVisibility(0);
            b(batchHandleRiskData.getIsEditMode());
            c(batchHandleRiskData.a());
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        int i3;
        Map<String, ? extends Object> mapOf;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (Intrinsics.areEqual(v3, this.binding.f442888c)) {
            g.b(g.f234195a, v3, "clck", "em_sgrp_to_clean_danger_user", null, 8, null);
            f fVar = this.onClickCallback;
            if (fVar != null) {
                fVar.a();
            }
        } else if (Intrinsics.areEqual(v3, this.binding.f442887b)) {
            g.b(g.f234195a, v3, "clck", "em_sgrp_cancel_btn", null, 8, null);
            f fVar2 = this.onClickCallback;
            if (fVar2 != null) {
                fVar2.onCancel();
            }
        } else if (Intrinsics.areEqual(v3, this.binding.f442890e)) {
            if (this.data.getSelectedMemberInfo().f()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            g gVar = g.f234195a;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_option_type", Integer.valueOf(i3)));
            gVar.a(v3, "clck", "em_sgrp_batch_remove_channel", mapOf);
            f fVar3 = this.onClickCallback;
            if (fVar3 != null) {
                fVar3.b(this.data.getSelectedMemberInfo());
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setOnClickCallback(@Nullable f onClickCallback) {
        this.onClickCallback = onClickCallback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildRiskMemberBottomLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildRiskMemberBottomLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildRiskMemberBottomLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = new BatchHandleRiskData(false, false, null, 7, null);
        df f16 = df.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setOrientation(1);
        setBackgroundResource(R.drawable.qui_common_bg_middle_light_bg);
        this.binding.f442888c.setOnClickListener(this);
        this.binding.f442887b.setOnClickListener(this);
        this.binding.f442890e.setOnClickListener(this);
        a(this.data);
    }
}
