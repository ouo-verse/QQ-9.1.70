package com.tencent.mobileqq.search.guildsearch.activation.delegate;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.guildsearch.activation.ListBaseData;
import com.tencent.mobileqq.search.guildsearch.parts.GuildSearchActivationPart;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import hp2.r;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rn2.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/OperationHotSearchChildItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$OperationHotSearchItemData;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "p", DomainData.DOMAIN_NAME, "Lhp2/r;", "E", "Lhp2/r;", "viewBinding", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;", "listController", "G", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$OperationHotSearchItemData;", "mData", "<init>", "(Lhp2/r;Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;)V", "H", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class OperationHotSearchChildItemViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final r viewBinding;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final GuildSearchActivationPart.e listController;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ListBaseData.OperationHotSearchItemData mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationHotSearchChildItemViewHolder(@NotNull r viewBinding, @Nullable GuildSearchActivationPart.e eVar) {
        super(viewBinding.getRoot());
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        this.viewBinding = viewBinding;
        this.listController = eVar;
        j jVar = j.f431768a;
        ConstraintLayout root = viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        j.u(jVar, root, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.guildsearch.activation.delegate.OperationHotSearchChildItemViewHolder.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                GuildSearchActivationPart.e eVar2;
                Intrinsics.checkNotNullParameter(it, "it");
                ListBaseData.OperationHotSearchItemData operationHotSearchItemData = OperationHotSearchChildItemViewHolder.this.mData;
                if (operationHotSearchItemData == null || (eVar2 = OperationHotSearchChildItemViewHolder.this.listController) == null) {
                    return;
                }
                eVar2.b(operationHotSearchItemData);
            }
        }, 3, null);
    }

    private final void o(ListBaseData.OperationHotSearchItemData data) {
        if (TextUtils.isEmpty(data.getSerialNumUrl())) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = AppCompatResources.getDrawable(this.viewBinding.getRoot().getContext(), R.drawable.qui_common_fill_standard_primary_bg_corner_4);
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        this.viewBinding.f405736b.setImageDrawable(URLDrawable.getDrawable(data.getSerialNumUrl(), obtain));
    }

    private final void p(ListBaseData.OperationHotSearchItemData data) {
        if (!TextUtils.isEmpty(data.getTagText()) && !TextUtils.isEmpty(data.getTagColor()) && !TextUtils.isEmpty(data.getTagBgColor())) {
            try {
                int parseColor = Color.parseColor(data.getTagColor());
                int parseColor2 = Color.parseColor(data.getTagBgColor());
                this.viewBinding.f405737c.setVisibility(0);
                this.viewBinding.f405737c.setText(data.getTagText());
                this.viewBinding.f405737c.setTextColor(parseColor);
                this.viewBinding.f405737c.setBackground(ad.f(parseColor2, 3, 17, 17));
                return;
            } catch (IllegalArgumentException e16) {
                QLog.w("QQSearch.Local.Guild.OperationHotSearchChildItemViewHolder", 1, e16.getMessage(), e16);
                return;
            }
        }
        this.viewBinding.f405737c.setVisibility(8);
    }

    private final void q(int position, ListBaseData.OperationHotSearchItemData data) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_rank", Integer.valueOf(position));
        String word = data.getWord();
        if (word == null) {
            word = "";
        }
        hashMap.put("sgrp_word", word);
        VideoReport.setElementId(this.itemView, "em_sgrp_discover_search_hot_word");
        VideoReport.setElementParams(this.itemView, hashMap);
        VideoReport.setElementExposePolicy(this.itemView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.itemView, ClickPolicy.REPORT_ALL);
    }

    public final void n(@NotNull ListBaseData.OperationHotSearchItemData data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData = data;
        this.viewBinding.f405738d.setText(data.getWord());
        if (!TextUtils.isEmpty(data.getJumpUrl())) {
            AccessibilityUtil.d(this.viewBinding.f405738d, Button.class.getName());
        } else {
            AccessibilityUtil.d(this.viewBinding.f405738d, TextView.class.getName());
        }
        o(data);
        p(data);
        q(position, data);
    }
}
