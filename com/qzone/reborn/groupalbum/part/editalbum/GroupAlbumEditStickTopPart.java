package com.qzone.reborn.groupalbum.part.editalbum;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.base.k;
import com.qzone.reborn.groupalbum.viewmodel.r;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.widget.Switch;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR#\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/editalbum/GroupAlbumEditStickTopPart;", "Lcom/qzone/reborn/base/k;", "", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/widget/Switch;", "d", "Lcom/tencent/widget/Switch;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "Lcom/qzone/reborn/groupalbum/viewmodel/r;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "F9", "()Lcom/qzone/reborn/groupalbum/viewmodel/r;", "vm", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumEditStickTopPart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Switch switch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    public GroupAlbumEditStickTopPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<r>() { // from class: com.qzone.reborn.groupalbum.part.editalbum.GroupAlbumEditStickTopPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final r invoke() {
                return (r) GroupAlbumEditStickTopPart.this.getViewModel(r.class);
            }
        });
        this.vm = lazy;
    }

    private final r F9() {
        return (r) this.vm.getValue();
    }

    private final boolean G9() {
        Intent intent;
        Activity activity = getActivity();
        CommonAlbumEditInitBean commonAlbumEditInitBean = (activity == null || (intent = activity.getIntent()) == null) ? null : (CommonAlbumEditInitBean) intent.getParcelableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(commonAlbumEditInitBean, "null cannot be cast to non-null type com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean");
        return commonAlbumEditInitBean.getHasTopRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(GroupAlbumEditStickTopPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(compoundButton.getTag(), Boolean.TRUE)) {
            compoundButton.setTag(Boolean.FALSE);
        } else {
            this$0.F9().e2(z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.ng8);
            Switch r16 = (Switch) findViewById;
            r16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qzone.reborn.groupalbum.part.editalbum.e
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    GroupAlbumEditStickTopPart.H9(GroupAlbumEditStickTopPart.this, compoundButton, z16);
                }
            });
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<Switch>(R.i\u2026          }\n            }");
            this.switch = r16;
            View findViewById2 = rootView.findViewById(R.id.m_0);
            View findViewById3 = rootView.findViewById(R.id.ng9);
            if (G9()) {
                findViewById3.setVisibility(0);
                findViewById2.getVisibility();
            } else {
                findViewById3.setVisibility(8);
                findViewById2.setVisibility(8);
            }
        }
        LiveData<CommonAlbumEditInitBean> M1 = F9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonAlbumEditInitBean, Unit> function1 = new Function1<CommonAlbumEditInitBean, Unit>() { // from class: com.qzone.reborn.groupalbum.part.editalbum.GroupAlbumEditStickTopPart$onInitView$2
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
                Switch r06;
                Switch r07;
                Switch r08;
                if (commonAlbumEditInitBean == null) {
                    return;
                }
                r06 = GroupAlbumEditStickTopPart.this.switch;
                Switch r17 = null;
                if (r06 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                    r06 = null;
                }
                if (r06.isChecked() != commonAlbumEditInitBean.isStickTop()) {
                    r07 = GroupAlbumEditStickTopPart.this.switch;
                    if (r07 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                        r07 = null;
                    }
                    r07.setTag(Boolean.TRUE);
                    r08 = GroupAlbumEditStickTopPart.this.switch;
                    if (r08 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                    } else {
                        r17 = r08;
                    }
                    r17.setChecked(commonAlbumEditInitBean.isStickTop());
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.part.editalbum.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAlbumEditStickTopPart.I9(Function1.this, obj);
            }
        });
    }
}
