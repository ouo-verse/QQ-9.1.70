package com.qzone.reborn.albumx.qzonex.part.videotab;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.qzonex.view.ad;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.qqnt.kernel.nativeinterface.AlbumPageInfo;
import com.tencent.richframework.data.base.UIStateData;
import hb.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.bn;
import nc.br;
import nc.bs;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/videotab/QZAlbumTabVideoTitlePart;", "Lcom/qzone/reborn/base/k;", "", "initData", "initViewModel", "Lcb/a;", "bean", "L9", "H9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lnc/bn;", "d", "Lnc/bn;", "mainPageTabViewModel", "Lnc/br;", "e", "Lnc/br;", "videoTabViewModel", "Lnc/bs;", "f", "Lnc/bs;", "timeLineViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZAlbumTabVideoTitlePart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bn mainPageTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private br videoTabViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private bs timeLineViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9() {
        MutableLiveData<AlbumPageInfo> U1;
        AlbumPageInfo value;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bn bnVar = this.mainPageTabViewModel;
        new ad(context, (bnVar == null || (U1 = bnVar.U1()) == null || (value = U1.getValue()) == null) ? null : value.tools).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(final QZAlbumTabVideoTitlePart this$0, i iVar) {
        MutableLiveData<Integer> a26;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bn A7 = iVar.A7();
        this$0.mainPageTabViewModel = A7;
        if (A7 == null || (a26 = A7.a2()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.videotab.QZAlbumTabVideoTitlePart$initViewModel$1$1
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
                if (num != null && num.intValue() == 2) {
                    QZAlbumTabVideoTitlePart.this.H9();
                }
            }
        };
        a26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.videotab.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabVideoTitlePart.K9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(cb.a bean) {
        bn bnVar = this.mainPageTabViewModel;
        if (bnVar != null) {
            bnVar.z2(bean.getVideoNum() + "\u89c6\u9891");
        }
    }

    private final void initData() {
        br brVar = this.videoTabViewModel;
        if (brVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTabViewModel");
            brVar = null;
        }
        MutableLiveData<UIStateData<cb.a>> W1 = brVar.W1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<cb.a>, Unit> function1 = new Function1<UIStateData<cb.a>, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.videotab.QZAlbumTabVideoTitlePart$initData$1
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
                    QZAlbumTabVideoTitlePart.this.L9(data);
                }
            }
        };
        W1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.videotab.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabVideoTitlePart.I9(Function1.this, obj);
            }
        });
    }

    private final void initViewModel() {
        RFWIocAbilityProvider.g().getIoc(i.class).originView(getPartRootView()).done(new OnPromiseResolved() { // from class: com.qzone.reborn.albumx.qzonex.part.videotab.c
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZAlbumTabVideoTitlePart.J9(QZAlbumTabVideoTitlePart.this, (i) obj);
            }
        }).run();
        ViewModel viewModel = getViewModel(bs.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxTim\u2026ineViewModel::class.java)");
        this.timeLineViewModel = (bs) viewModel;
        ViewModel viewModel2 = getViewModel(br.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZAlbumxTab\u2026deoViewModel::class.java)");
        this.videoTabViewModel = (br) viewModel2;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumTabVideoTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
        initData();
    }
}
