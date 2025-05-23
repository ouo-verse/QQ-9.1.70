package com.qzone.reborn.intimate.part.editalbum;

import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.base.k;
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
import nk.ap;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR#\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/intimate/part/editalbum/QZoneEditAlbumStickTopPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/widget/Switch;", "d", "Lcom/tencent/widget/Switch;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "Lnk/ap;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "F9", "()Lnk/ap;", "vm", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneEditAlbumStickTopPart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Switch switch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    public QZoneEditAlbumStickTopPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ap>() { // from class: com.qzone.reborn.intimate.part.editalbum.QZoneEditAlbumStickTopPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ap invoke() {
                return (ap) QZoneEditAlbumStickTopPart.this.getViewModel(ap.class);
            }
        });
        this.vm = lazy;
    }

    private final ap F9() {
        return (ap) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(QZoneEditAlbumStickTopPart this$0, CompoundButton compoundButton, boolean z16) {
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
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.ng8);
            Switch r06 = (Switch) findViewById;
            r06.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qzone.reborn.intimate.part.editalbum.e
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    QZoneEditAlbumStickTopPart.G9(QZoneEditAlbumStickTopPart.this, compoundButton, z16);
                }
            });
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<Switch>(R.i\u2026          }\n            }");
            this.switch = r06;
        }
        LiveData<CommonAlbumEditInitBean> M1 = F9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonAlbumEditInitBean, Unit> function1 = new Function1<CommonAlbumEditInitBean, Unit>() { // from class: com.qzone.reborn.intimate.part.editalbum.QZoneEditAlbumStickTopPart$onInitView$2
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
                Switch r07;
                Switch r08;
                Switch r09;
                if (commonAlbumEditInitBean == null) {
                    return;
                }
                r07 = QZoneEditAlbumStickTopPart.this.switch;
                Switch r16 = null;
                if (r07 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                    r07 = null;
                }
                if (r07.isChecked() != commonAlbumEditInitBean.isStickTop()) {
                    r08 = QZoneEditAlbumStickTopPart.this.switch;
                    if (r08 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                        r08 = null;
                    }
                    r08.setTag(Boolean.TRUE);
                    r09 = QZoneEditAlbumStickTopPart.this.switch;
                    if (r09 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                    } else {
                        r16 = r09;
                    }
                    r16.setChecked(commonAlbumEditInitBean.isStickTop());
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.editalbum.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneEditAlbumStickTopPart.H9(Function1.this, obj);
            }
        });
    }
}
