package com.qzone.reborn.albumx.qzonex.part.albumdetail;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-B\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R#\u0010)\u001a\n $*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumxAlbumDetailPlusMenuPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "hasRight", "needHide", "", "Q9", "N9", "Landroid/view/View;", "view", "K9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "d", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "getInitBean", "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "initBean", "e", "Landroid/view/View;", "btnPlus", "f", "Z", "shouldAutoJump", tl.h.F, "hasUpLoadRight", "i", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "albumDetailViewModel", "Lnc/ap;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "M9", "()Lnc/ap;", "operateVm", "<init>", "(Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;)V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumDetailPlusMenuPart extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy operateVm;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZAlbumxAlbumDetailInitBean initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View btnPlus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean shouldAutoJump;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasUpLoadRight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean needHide;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.common.viewmodel.b albumDetailViewModel;

    public QZAlbumxAlbumDetailPlusMenuPart(QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean) {
        Lazy lazy;
        this.initBean = qZAlbumxAlbumDetailInitBean;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<nc.ap>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailPlusMenuPart$operateVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final nc.ap invoke() {
                return (nc.ap) QZAlbumxAlbumDetailPlusMenuPart.this.getViewModel(nc.ap.class);
            }
        });
        this.operateVm = lazy;
    }

    private final void K9(View view) {
        fo.b bVar = new fo.b();
        bVar.k(ExposurePolicy.REPORT_NONE);
        bVar.h(new IDynamicParams() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.an
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map L9;
                L9 = QZAlbumxAlbumDetailPlusMenuPart.L9(str);
                return L9;
            }
        });
        fo.c.o(view, "em_qz_plus_suspend", bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map L9(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, eo.c.f396879a.c());
        return linkedHashMap;
    }

    private final nc.ap M9() {
        return (nc.ap) this.operateVm.getValue();
    }

    private final void N9() {
        String str;
        com.qzone.reborn.albumx.common.viewmodel.b bVar = this.albumDetailViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumDetailViewModel");
            bVar = null;
        }
        CommonAlbumInfo value = bVar.M1().getValue();
        if (value == null) {
            RFWLog.w("QZAlbumxAlbumDetailPlusMenuPart", RFWLog.USR, "albumInfo is null ");
            return;
        }
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
        if (qZAlbumxAlbumDetailInitBean == null || (str = qZAlbumxAlbumDetailInitBean.getUin()) == null) {
            str = "";
        }
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = new QZAlbumxUploadAlbumInitBean(str, 0, true, value, 2);
        vb.b x16 = ho.i.x();
        Intrinsics.checkNotNullExpressionValue(x16, "qzAlbumx()");
        vb.b.m(x16, getContext(), qZAlbumxUploadAlbumInitBean, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n9w) {
            N9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
        boolean z16 = false;
        if (qZAlbumxAlbumDetailInitBean != null && qZAlbumxAlbumDetailInitBean.getAction() == 1) {
            z16 = true;
        }
        this.shouldAutoJump = z16;
        if (rootView != null) {
            View view = null;
            l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, rootView, null);
            com.qzone.reborn.albumx.common.viewmodel.b Ne = cVar != null ? cVar.Ne() : null;
            Intrinsics.checkNotNull(Ne, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.QZAlbumxAlbumDetailViewModel");
            this.albumDetailViewModel = (nc.y) Ne;
            View findViewById = rootView.findViewById(R.id.n9w);
            findViewById.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.\u2026usMenuPart)\n            }");
            this.btnPlus = findViewById;
            findViewById.setVisibility(8);
            com.qzone.reborn.albumx.common.viewmodel.b bVar = this.albumDetailViewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumDetailViewModel");
                bVar = null;
            }
            MutableLiveData<ArrayList<Integer>> T1 = bVar.T1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<ArrayList<Integer>, Unit> function1 = new Function1<ArrayList<Integer>, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailPlusMenuPart$onInitView$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ArrayList<Integer> arrayList) {
                    invoke2(arrayList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ArrayList<Integer> arrayList) {
                    boolean z17;
                    boolean z18;
                    QZAlbumxAlbumDetailPlusMenuPart.this.hasUpLoadRight = arrayList.contains(20);
                    QZAlbumxAlbumDetailPlusMenuPart qZAlbumxAlbumDetailPlusMenuPart = QZAlbumxAlbumDetailPlusMenuPart.this;
                    z17 = qZAlbumxAlbumDetailPlusMenuPart.hasUpLoadRight;
                    z18 = QZAlbumxAlbumDetailPlusMenuPart.this.needHide;
                    qZAlbumxAlbumDetailPlusMenuPart.Q9(z17, z18);
                }
            };
            T1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.al
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxAlbumDetailPlusMenuPart.O9(Function1.this, obj);
                }
            });
            MutableLiveData<Boolean> d26 = M9().d2();
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailPlusMenuPart$onInitView$1$3
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
                    boolean z17;
                    boolean z18;
                    QZAlbumxAlbumDetailPlusMenuPart qZAlbumxAlbumDetailPlusMenuPart = QZAlbumxAlbumDetailPlusMenuPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qZAlbumxAlbumDetailPlusMenuPart.needHide = it.booleanValue();
                    QZAlbumxAlbumDetailPlusMenuPart qZAlbumxAlbumDetailPlusMenuPart2 = QZAlbumxAlbumDetailPlusMenuPart.this;
                    z17 = qZAlbumxAlbumDetailPlusMenuPart2.hasUpLoadRight;
                    z18 = QZAlbumxAlbumDetailPlusMenuPart.this.needHide;
                    qZAlbumxAlbumDetailPlusMenuPart2.Q9(z17, z18);
                }
            };
            d26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.am
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxAlbumDetailPlusMenuPart.P9(Function1.this, obj);
                }
            });
            View view2 = this.btnPlus;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnPlus");
            } else {
                view = view2;
            }
            K9(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(boolean hasRight, boolean needHide) {
        View view = null;
        if (hasRight && !needHide) {
            View view2 = this.btnPlus;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnPlus");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        View view3 = this.btnPlus;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPlus");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }
}
