package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZIntimateMainPageVisionResourcesPart;", "Lcom/qzone/reborn/base/k;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Lnk/at;", "d", "Lnk/at;", "mainTabViewModel", "Lnk/i;", "e", "Lnk/i;", "styleViewModel", "Lnk/l;", "f", "Lnk/l;", "vipViewModel", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateMainPageVisionResourcesPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.at mainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private nk.i styleViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private nk.l vipViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(nk.i.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZIntimateM\u2026yleViewModel::class.java)");
        this.styleViewModel = (nk.i) viewModel;
        ViewModel viewModel2 = getViewModel(nk.at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        this.mainTabViewModel = (nk.at) viewModel2;
        ViewModel viewModel3 = getViewModel(nk.l.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "getViewModel(QZIntimateM\u2026nfoViewModel::class.java)");
        this.vipViewModel = (nk.l) viewModel3;
        nk.i iVar = this.styleViewModel;
        nk.at atVar = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
            iVar = null;
        }
        MutableLiveData<String> Q1 = iVar.Q1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateMainPageVisionResourcesPart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                nk.l lVar;
                if (TextUtils.isEmpty(it)) {
                    return;
                }
                lVar = QZIntimateMainPageVisionResourcesPart.this.vipViewModel;
                if (lVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vipViewModel");
                    lVar = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                lVar.a2(it);
            }
        };
        Q1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateMainPageVisionResourcesPart.G9(Function1.this, obj);
            }
        });
        nk.at atVar2 = this.mainTabViewModel;
        if (atVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
        } else {
            atVar = atVar2;
        }
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1 = atVar.U1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function12 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateMainPageVisionResourcesPart$onPartCreate$2
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
                nk.i iVar2;
                int state = uIStateData.getState();
                if (state != 2 && state != 3) {
                    if (state != 4) {
                        return;
                    }
                    QLog.e("QZIntimateMainPageStylePart", 1, "handleSpaceInfoRsp error, recode is " + uIStateData.getRetCode());
                    return;
                }
                if (uIStateData.getData() == null) {
                    return;
                }
                if (com.qzone.reborn.util.k.f59549a.g() && uIStateData.getData().isLoveSpace()) {
                    return;
                }
                iVar2 = QZIntimateMainPageVisionResourcesPart.this.styleViewModel;
                if (iVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
                    iVar2 = null;
                }
                iVar2.S1(uIStateData.getData().getSpaceType());
            }
        };
        U1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.intimate.part.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateMainPageVisionResourcesPart.H9(Function1.this, obj);
            }
        });
    }
}
