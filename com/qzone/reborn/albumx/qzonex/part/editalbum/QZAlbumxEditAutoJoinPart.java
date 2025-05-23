package com.qzone.reborn.albumx.qzonex.part.editalbum;

import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.widget.Switch;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.au;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR#\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/editalbum/QZAlbumxEditAutoJoinPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/widget/Switch;", "view", "", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Lcom/tencent/widget/Switch;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "e", "Landroid/view/View;", "autoJoinContainer", "Lnc/au;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "J9", "()Lnc/au;", "vm", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxEditAutoJoinPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Switch switch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View autoJoinContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    public QZAlbumxEditAutoJoinPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<au>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditAutoJoinPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final au invoke() {
                return (au) QZAlbumxEditAutoJoinPart.this.getViewModel(au.class);
            }
        });
        this.vm = lazy;
    }

    private final void H9(Switch view) {
        fo.b bVar = new fo.b();
        bVar.h(new IDynamicParams() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.k
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map I9;
                I9 = QZAlbumxEditAutoJoinPart.I9(QZAlbumxEditAutoJoinPart.this, str);
                return I9;
            }
        });
        fo.c.o(view, "em_qz_auto_enter", bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map I9(QZAlbumxEditAutoJoinPart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Switch r16 = this$0.switch;
        if (r16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
            r16 = null;
        }
        linkedHashMap.put("op_result", Integer.valueOf(r16.isChecked() ? 1 : 2));
        return linkedHashMap;
    }

    private final au J9() {
        return (au) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(QZAlbumxEditAutoJoinPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(compoundButton.getTag(), Boolean.TRUE)) {
            compoundButton.setTag(Boolean.FALSE);
        } else {
            this$0.J9().y2(z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.m1e);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout_auto_join_part)");
            this.autoJoinContainer = findViewById;
            Switch r16 = null;
            if (findViewById == null) {
                Intrinsics.throwUninitializedPropertyAccessException("autoJoinContainer");
                findViewById = null;
            }
            View findViewById2 = findViewById.findViewById(R.id.ng8);
            Switch r26 = (Switch) findViewById2;
            r26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.i
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    QZAlbumxEditAutoJoinPart.K9(QZAlbumxEditAutoJoinPart.this, compoundButton, z16);
                }
            });
            Intrinsics.checkNotNullExpressionValue(findViewById2, "autoJoinContainer.findVi\u2026          }\n            }");
            this.switch = r26;
            View view = this.autoJoinContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("autoJoinContainer");
                view = null;
            }
            view.setVisibility(8);
            Switch r56 = this.switch;
            if (r56 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
            } else {
                r16 = r56;
            }
            H9(r16);
        }
        LiveData<CommonAlbumEditInitBean> M1 = J9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonAlbumEditInitBean, Unit> function1 = new Function1<CommonAlbumEditInitBean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditAutoJoinPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonAlbumEditInitBean commonAlbumEditInitBean) {
                invoke2(commonAlbumEditInitBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommonAlbumEditInitBean commonAlbumEditInitBean) {
                View view2;
                Switch r06;
                Switch r07;
                Switch r08;
                View view3;
                if (commonAlbumEditInitBean != null && com.qzone.reborn.albumx.qzonex.utils.c.f53402a.f(commonAlbumEditInitBean.getAlbumInfo())) {
                    Switch r36 = null;
                    if (commonAlbumEditInitBean.getAlbumInfo().getQzAlbumType() != 12) {
                        view3 = QZAlbumxEditAutoJoinPart.this.autoJoinContainer;
                        if (view3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("autoJoinContainer");
                            view3 = null;
                        }
                        view3.setVisibility(8);
                    } else {
                        view2 = QZAlbumxEditAutoJoinPart.this.autoJoinContainer;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("autoJoinContainer");
                            view2 = null;
                        }
                        view2.setVisibility(0);
                    }
                    r06 = QZAlbumxEditAutoJoinPart.this.switch;
                    if (r06 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                        r06 = null;
                    }
                    if (r06.isChecked() != commonAlbumEditInitBean.getAlbumInfo().getShareAlbum().getAutoJoin()) {
                        r07 = QZAlbumxEditAutoJoinPart.this.switch;
                        if (r07 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                            r07 = null;
                        }
                        r07.setTag(Boolean.TRUE);
                        r08 = QZAlbumxEditAutoJoinPart.this.switch;
                        if (r08 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                        } else {
                            r36 = r08;
                        }
                        r36.setChecked(commonAlbumEditInitBean.getAlbumInfo().getShareAlbum().getAutoJoin());
                    }
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxEditAutoJoinPart.L9(Function1.this, obj);
            }
        });
    }
}
