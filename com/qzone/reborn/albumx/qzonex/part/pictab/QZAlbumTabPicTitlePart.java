package com.qzone.reborn.albumx.qzonex.part.pictab;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.qzonex.view.ad;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.qqnt.kernel.nativeinterface.AlbumPageInfo;
import com.tencent.qqnt.kernel.nativeinterface.ToolBox;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.bn;
import nc.bq;
import nc.bs;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/pictab/QZAlbumTabPicTitlePart;", "Lcom/qzone/reborn/base/k;", "", "initData", "initViewModel", "Lcb/a;", "bean", "N9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lnc/bn;", "d", "Lnc/bn;", "mainPageTabViewModel", "Lnc/bq;", "e", "Lnc/bq;", "picTabViewModel", "Lnc/bs;", "f", "Lnc/bs;", "timeLineViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZAlbumTabPicTitlePart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bn mainPageTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private bq picTabViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private bs timeLineViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(final QZAlbumTabPicTitlePart this$0, hb.i iVar) {
        MutableLiveData<Integer> a26;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bn A7 = iVar.A7();
        this$0.mainPageTabViewModel = A7;
        if (A7 == null || (a26 = A7.a2()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabPicTitlePart$initViewModel$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                bn bnVar;
                bn bnVar2;
                MutableLiveData<AlbumPageInfo> U1;
                AlbumPageInfo value;
                bs bsVar;
                MutableLiveData<Boolean> j26;
                if (num != null && num.intValue() == 1) {
                    bnVar = QZAlbumTabPicTitlePart.this.mainPageTabViewModel;
                    ArrayList<ToolBox> arrayList = null;
                    bs bsVar2 = null;
                    arrayList = null;
                    arrayList = null;
                    if ((bnVar == null || (j26 = bnVar.j2()) == null) ? false : Intrinsics.areEqual(j26.getValue(), Boolean.TRUE)) {
                        bsVar = QZAlbumTabPicTitlePart.this.timeLineViewModel;
                        if (bsVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
                        } else {
                            bsVar2 = bsVar;
                        }
                        bsVar2.W1();
                        return;
                    }
                    Context context = QZAlbumTabPicTitlePart.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    bnVar2 = QZAlbumTabPicTitlePart.this.mainPageTabViewModel;
                    if (bnVar2 != null && (U1 = bnVar2.U1()) != null && (value = U1.getValue()) != null) {
                        arrayList = value.tools;
                    }
                    new ad(context, arrayList).show();
                }
            }
        };
        a26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabPicTitlePart.M9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(cb.a bean) {
        bn bnVar = this.mainPageTabViewModel;
        if (bnVar != null) {
            bnVar.v2(bean.getPhotoNum() + "\u7167\u7247 " + bean.getVideoNum() + "\u89c6\u9891");
        }
    }

    private final void initData() {
        bq bqVar = this.picTabViewModel;
        bq bqVar2 = null;
        if (bqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picTabViewModel");
            bqVar = null;
        }
        MutableLiveData<UIStateData<cb.a>> W1 = bqVar.W1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<cb.a>, Unit> function1 = new Function1<UIStateData<cb.a>, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabPicTitlePart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<cb.a> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<cb.a> uIStateData) {
                cb.a data = uIStateData.getData();
                if (data != null) {
                    QZAlbumTabPicTitlePart.this.N9(data);
                }
            }
        };
        W1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabPicTitlePart.J9(Function1.this, obj);
            }
        });
        bq bqVar3 = this.picTabViewModel;
        if (bqVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picTabViewModel");
        } else {
            bqVar2 = bqVar3;
        }
        MutableLiveData<cb.b> R1 = bqVar2.R1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<cb.b, Unit> function12 = new Function1<cb.b, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabPicTitlePart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cb.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(cb.b bVar) {
                bn bnVar;
                bnVar = QZAlbumTabPicTitlePart.this.mainPageTabViewModel;
                if (bnVar != null) {
                    bnVar.r2(bVar.getCurTimeStamp());
                }
            }
        };
        R1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabPicTitlePart.K9(Function1.this, obj);
            }
        });
    }

    private final void initViewModel() {
        RFWIocAbilityProvider.g().getIoc(hb.i.class).originView(getPartRootView()).done(new OnPromiseResolved() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.k
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZAlbumTabPicTitlePart.L9(QZAlbumTabPicTitlePart.this, (hb.i) obj);
            }
        }).run();
        ViewModel viewModel = getViewModel(bs.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxTim\u2026ineViewModel::class.java)");
        this.timeLineViewModel = (bs) viewModel;
        ViewModel viewModel2 = getViewModel(bq.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZAlbumxTabPicViewModel::class.java)");
        this.picTabViewModel = (bq) viewModel2;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumTabPicTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
        initData();
    }
}
