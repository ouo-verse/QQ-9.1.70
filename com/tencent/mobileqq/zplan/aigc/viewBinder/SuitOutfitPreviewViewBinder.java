package com.tencent.mobileqq.zplan.aigc.viewBinder;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import bv4.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.zplan.aigc.data.SuitAnimationItem;
import com.tencent.mobileqq.zplan.aigc.data.ZplanSuitOutfitPreviewConfig;
import com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper;
import com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.report.SquareReportConst;
import fi3.bz;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import t74.i;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006R+\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/viewBinder/SuitOutfitPreviewViewBinder;", "Lcom/tencent/mobileqq/mvvm/b;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lfi3/bz;", "binding", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitOutfitViewModel;", "viewModel", "Lzd3/a;", "dtReporter", "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lbv4/f;", "pose", "l", "", "<set-?>", "d", "Lkotlin/properties/ReadWriteProperty;", DomainData.DOMAIN_NAME, "()Z", "o", "(Z)V", "isChangePoseClicked", "<init>", "()V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitOutfitPreviewViewBinder extends com.tencent.mobileqq.mvvm.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty isChangePoseClicked;

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f330795f = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuitOutfitPreviewViewBinder.class, "isChangePoseClicked", "isChangePoseClicked()Z", 0))};

    public SuitOutfitPreviewViewBinder() {
        QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
        this.isChangePoseClicked = i.b((IZPlanMMKVApi) api, "ZPLAN_SuitOutfitPreviewViewBinder_isSuitOutfitChangePoseClicked_" + bb.f335811a.e(), false);
    }

    private final void i(LifecycleOwner owner, bz binding, final SuitOutfitViewModel viewModel, final zd3.a dtReporter) {
        MutableLiveData<ZplanSuitOutfitPreviewConfig> q26 = viewModel.q2();
        final SuitOutfitPreviewViewBinder$bindMasterActionButton$1 suitOutfitPreviewViewBinder$bindMasterActionButton$1 = new SuitOutfitPreviewViewBinder$bindMasterActionButton$1(binding, viewModel);
        q26.observe(owner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.viewBinder.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitOutfitPreviewViewBinder.j(Function1.this, obj);
            }
        });
        binding.f399192g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.viewBinder.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitOutfitPreviewViewBinder.k(SuitOutfitViewModel.this, dtReporter, view);
            }
        });
        if (n()) {
            return;
        }
        o(true);
        QUIDefaultBubbleTip.r(binding.f399192g.getContext()).S(binding.f399192g).o0("\u73b0\u5728\u53ef\u4ee5\u6362\u52a8\u4f5c\u5566!").k0(2).R(0).m0(3).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final SuitOutfitViewModel viewModel, final zd3.a dtReporter, final View view) {
        Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        Intrinsics.checkNotNullParameter(dtReporter, "$dtReporter");
        SuitOutfitViewModel.T1(viewModel, false, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.viewBinder.SuitOutfitPreviewViewBinder$bindMasterActionButton$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    f i26 = SuitOutfitViewModel.this.i2();
                    linkedHashMap.put(SquareReportConst.Key.KEY_ACTION_ID, i26.f29280a + "," + i26.f29281b);
                    linkedHashMap.put("dt_pgid", "pg_zplan_contribute");
                    zd3.a aVar = dtReporter;
                    View it = view;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    aVar.t(it, "em_zplan_change_action", linkedHashMap);
                }
            }
        }, 1, null);
    }

    private final boolean n() {
        return ((Boolean) this.isChangePoseClicked.getValue(this, f330795f[0])).booleanValue();
    }

    private final void o(boolean z16) {
        this.isChangePoseClicked.setValue(this, f330795f[0], Boolean.valueOf(z16));
    }

    public final void l(bz binding, f pose, SuitOutfitViewModel viewModel) {
        List<SuitAnimationItem> mutableListOf;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (pose != null) {
            String str = pose.f29281b;
            if (!(str == null || str.length() == 0)) {
                String str2 = pose.f29280a;
                if (!(str2 == null || str2.length() == 0)) {
                    SuitAnimationItem suitAnimationItem = new SuitAnimationItem();
                    String str3 = pose.f29281b;
                    Intrinsics.checkNotNullExpressionValue(str3, "pose.bodyAction");
                    suitAnimationItem.setBodyAction(str3);
                    String str4 = pose.f29280a;
                    Intrinsics.checkNotNullExpressionValue(str4, "pose.headAction");
                    suitAnimationItem.setHeadAction(str4);
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(suitAnimationItem);
                    AigcAnimHelper suitAnimHelper = viewModel.getSuitAnimHelper();
                    if (suitAnimHelper != null) {
                        suitAnimHelper.z1(mutableListOf, new SuitOutfitPreviewViewBinder$bindOtherOutfitAction$1(binding, viewModel));
                        return;
                    }
                    return;
                }
            }
        }
        QLog.e("SuitOutfitPreviewViewBinder", 1, "bodyAction or headAction is null, headAction: " + (pose != null ? pose.f29280a : null) + ", bodyAction: " + (pose != null ? pose.f29281b : null));
    }

    public final void m(LifecycleOwner owner, bz binding, SuitOutfitViewModel viewModel, zd3.a dtReporter) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReporter, "dtReporter");
        i(owner, binding, viewModel, dtReporter);
    }
}
