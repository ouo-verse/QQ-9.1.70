package com.qzone.reborn.intimate.part.albumDetail;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateUploadAlbumInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nk.aa;
import nk.w;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR#\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0017\u001a\n \r*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/intimate/part/albumDetail/QZoneIntimateAlbumPlusMenuPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "v", NodeProps.ON_CLICK, "d", "Landroid/view/View;", "btnPlus", "Lnk/w;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "H9", "()Lnk/w;", "vm", "Lnk/aa;", "f", "G9", "()Lnk/aa;", "operateVm", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateAlbumPlusMenuPart extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View btnPlus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy operateVm;

    public QZoneIntimateAlbumPlusMenuPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<w>() { // from class: com.qzone.reborn.intimate.part.albumDetail.QZoneIntimateAlbumPlusMenuPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final w invoke() {
                return (w) QZoneIntimateAlbumPlusMenuPart.this.getViewModel(w.class);
            }
        });
        this.vm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<aa>() { // from class: com.qzone.reborn.intimate.part.albumDetail.QZoneIntimateAlbumPlusMenuPart$operateVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final aa invoke() {
                return (aa) QZoneIntimateAlbumPlusMenuPart.this.getViewModel(aa.class);
            }
        });
        this.operateVm = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final aa G9() {
        return (aa) this.operateVm.getValue();
    }

    private final w H9() {
        return (w) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n9w) {
            CommonAlbumInfo value = H9().M1().getValue();
            if (value == null) {
                RFWLog.w("QZoneIntimateAlbumPlusMenuPart", RFWLog.USR, "albumInfo is null ");
            } else {
                ck.c o16 = ho.i.o();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                QZoneIntimateAlbumDetailInitBean initBean = H9().getInitBean();
                if (initBean == null || (str = initBean.getSpaceId()) == null) {
                    str = "";
                }
                String str2 = str;
                QZoneIntimateAlbumDetailInitBean initBean2 = H9().getInitBean();
                o16.y(context, new QZoneIntimateUploadAlbumInitBean(str2, initBean2 != null ? initBean2.getSpaceType() : 0, false, xh.e.f(value), 4, null));
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.n9w);
            findViewById.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.\u2026usMenuPart)\n            }");
            this.btnPlus = findViewById;
            MutableLiveData<Boolean> X1 = H9().X1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.intimate.part.albumDetail.QZoneIntimateAlbumPlusMenuPart$onInitView$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(Boolean it) {
                    boolean z16;
                    View view;
                    aa G9;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        G9 = QZoneIntimateAlbumPlusMenuPart.this.G9();
                        if (Intrinsics.areEqual(G9.d2().getValue(), Boolean.FALSE)) {
                            z16 = true;
                            view = QZoneIntimateAlbumPlusMenuPart.this.btnPlus;
                            if (view == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("btnPlus");
                                view = null;
                            }
                            view.setVisibility(z16 ? 0 : 8);
                        }
                    }
                    z16 = false;
                    view = QZoneIntimateAlbumPlusMenuPart.this.btnPlus;
                    if (view == null) {
                    }
                    view.setVisibility(z16 ? 0 : 8);
                }
            };
            X1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.albumDetail.u
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZoneIntimateAlbumPlusMenuPart.I9(Function1.this, obj);
                }
            });
            MutableLiveData<Boolean> d26 = G9().d2();
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.intimate.part.albumDetail.QZoneIntimateAlbumPlusMenuPart$onInitView$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    View view;
                    view = QZoneIntimateAlbumPlusMenuPart.this.btnPlus;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("btnPlus");
                        view = null;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    view.setVisibility(it.booleanValue() ? 8 : 0);
                }
            };
            d26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.intimate.part.albumDetail.v
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZoneIntimateAlbumPlusMenuPart.J9(Function1.this, obj);
                }
            });
            View view = this.btnPlus;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnPlus");
                view = null;
            }
            fo.c.o(view, "em_qz_publish_button", null);
        }
    }
}
