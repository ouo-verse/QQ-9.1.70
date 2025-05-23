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

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR#\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/editalbum/QZAlbumxEditStickTopPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/widget/Switch;", "view", "", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Lcom/tencent/widget/Switch;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "Lnc/au;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "I9", "()Lnc/au;", "vm", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxEditStickTopPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Switch switch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    public QZAlbumxEditStickTopPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<au>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditStickTopPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final au invoke() {
                return (au) QZAlbumxEditStickTopPart.this.getViewModel(au.class);
            }
        });
        this.vm = lazy;
    }

    private final void G9(Switch view) {
        fo.b bVar = new fo.b();
        bVar.h(new IDynamicParams() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.y
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map H9;
                H9 = QZAlbumxEditStickTopPart.H9(QZAlbumxEditStickTopPart.this, str);
                return H9;
            }
        });
        fo.c.o(view, "em_qz_album_top", bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map H9(QZAlbumxEditStickTopPart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Switch r26 = this$0.switch;
        boolean z16 = false;
        if (r26 != null && r26.isChecked()) {
            z16 = true;
        }
        linkedHashMap.put("op_result", Integer.valueOf(z16 ? 1 : 2));
        return linkedHashMap;
    }

    private final au I9() {
        return (au) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QZAlbumxEditStickTopPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(compoundButton.getTag(), Boolean.TRUE)) {
            compoundButton.setTag(Boolean.FALSE);
        } else {
            this$0.I9().e2(z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            Switch r46 = (Switch) rootView.findViewById(R.id.ng8);
            r46.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.w
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    QZAlbumxEditStickTopPart.J9(QZAlbumxEditStickTopPart.this, compoundButton, z16);
                }
            });
            this.switch = r46;
            G9(r46);
        }
        LiveData<CommonAlbumEditInitBean> M1 = I9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonAlbumEditInitBean, Unit> function1 = new Function1<CommonAlbumEditInitBean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditStickTopPart$onInitView$2
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
                r06 = QZAlbumxEditStickTopPart.this.switch;
                boolean z16 = false;
                if (r06 != null && r06.isChecked() == commonAlbumEditInitBean.isStickTop()) {
                    z16 = true;
                }
                if (z16) {
                    return;
                }
                r07 = QZAlbumxEditStickTopPart.this.switch;
                if (r07 != null) {
                    r07.setTag(Boolean.TRUE);
                }
                r08 = QZAlbumxEditStickTopPart.this.switch;
                if (r08 == null) {
                    return;
                }
                r08.setChecked(commonAlbumEditInitBean.isStickTop());
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxEditStickTopPart.K9(Function1.this, obj);
            }
        });
    }
}
