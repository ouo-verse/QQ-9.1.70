package com.qzone.reborn.intimate.part;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.richframework.data.base.UIStateData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZIntimateLoverSpaceMigrationQueryPart;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lnk/at;", "d", "Lnk/at;", "mainTabViewModel", "Lnk/h;", "e", "Lnk/h;", "migrationViewModel", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateLoverSpaceMigrationQueryPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.at mainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private nk.h migrationViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initViewModel() {
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1;
        this.migrationViewModel = (nk.h) getViewModel(nk.h.class);
        nk.at atVar = (nk.at) getViewModel(nk.at.class);
        this.mainTabViewModel = atVar;
        if (atVar == null || (U1 = atVar.U1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateLoverSpaceMigrationQueryPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                nk.at atVar2;
                nk.h hVar;
                nk.h hVar2;
                nk.at atVar3;
                nk.at atVar4;
                if (uIStateData.getData() != null && mk.d.f416875a.y(Integer.valueOf(uIStateData.getData().getSpaceType()))) {
                    atVar2 = QZIntimateLoverSpaceMigrationQueryPart.this.mainTabViewModel;
                    if (TextUtils.isEmpty(atVar2 != null ? atVar2.getMSpaceId() : null) || com.qzone.reborn.util.k.f59549a.g()) {
                        return;
                    }
                    hVar = QZIntimateLoverSpaceMigrationQueryPart.this.migrationViewModel;
                    if (hVar != null) {
                        atVar4 = QZIntimateLoverSpaceMigrationQueryPart.this.mainTabViewModel;
                        String mSpaceId = atVar4 != null ? atVar4.getMSpaceId() : null;
                        Intrinsics.checkNotNull(mSpaceId);
                        hVar.U1(mSpaceId);
                    }
                    hVar2 = QZIntimateLoverSpaceMigrationQueryPart.this.migrationViewModel;
                    if (hVar2 != null) {
                        atVar3 = QZIntimateLoverSpaceMigrationQueryPart.this.mainTabViewModel;
                        String mSpaceId2 = atVar3 != null ? atVar3.getMSpaceId() : null;
                        Intrinsics.checkNotNull(mSpaceId2);
                        hVar2.S1(mSpaceId2);
                    }
                }
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateLoverSpaceMigrationQueryPart.F9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
    }
}
