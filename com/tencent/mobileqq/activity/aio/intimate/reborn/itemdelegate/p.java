package com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.zplan.IntimateUpgradeBannerView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.List;
import k61.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J4\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u001a\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r0\fH\u0016J\u0014\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/p;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/h;", "Lj61/a;", "model", "", "b", "", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "onCreateViewHolder", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class p extends h {
    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h
    public boolean b(@NotNull IntimateBaseModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (!((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).hasAvatarFeature() || ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleAvatarSwitchState(model.getFriendUin())) {
            return false;
        }
        return !AppSetting.t(BaseApplication.getContext());
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<IntimateBaseModel>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(x.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    public SectionViewHolder<?> onCreateViewHolder(@NotNull ViewGroup parent) {
        Context context;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (!(parent.getContext() instanceof Activity) && (parent.getContext() instanceof ContextWrapper)) {
            Context context2 = parent.getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.content.ContextWrapper");
            context = ((ContextWrapper) context2).getBaseContext();
        } else {
            context = parent.getContext();
        }
        Context realContext = context;
        Intrinsics.checkNotNullExpressionValue(realContext, "realContext");
        View intimateUpgradeBannerView = new IntimateUpgradeBannerView(realContext, null, 0, 6, null);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.leftMargin = ViewUtils.dpToPx(15.0f);
        marginLayoutParams.rightMargin = ViewUtils.dpToPx(15.0f);
        marginLayoutParams.bottomMargin = ViewUtils.dpToPx(16.0f);
        intimateUpgradeBannerView.setLayoutParams(marginLayoutParams);
        List<Class<? extends Section<IntimateBaseModel>>> arrayList = new ArrayList<>();
        initSection(parent, intimateUpgradeBannerView, arrayList);
        return new SectionViewHolder<>(intimateUpgradeBannerView, arrayList);
    }
}
