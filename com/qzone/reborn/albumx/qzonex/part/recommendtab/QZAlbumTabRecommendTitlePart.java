package com.qzone.reborn.albumx.qzonex.part.recommendtab;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import cooperation.qzone.util.QZLog;
import hb.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.bn;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/recommendtab/QZAlbumTabRecommendTitlePart;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "H9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lnc/bn;", "d", "Lnc/bn;", "mainPageTabViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZAlbumTabRecommendTitlePart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bn mainPageTabViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(final QZAlbumTabRecommendTitlePart this$0, i iVar) {
        MutableLiveData<Integer> a26;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bn A7 = iVar.A7();
        this$0.mainPageTabViewModel = A7;
        if (A7 == null || (a26 = A7.a2()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.recommendtab.QZAlbumTabRecommendTitlePart$initViewModel$1$1
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
                if (num != null && num.intValue() == 3) {
                    QZAlbumTabRecommendTitlePart.this.H9();
                }
            }
        };
        a26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.recommendtab.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabRecommendTitlePart.G9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9() {
        if (getContext() == null) {
            QZLog.e(getTAG(), 1, "[onClick] right desc click, view or context is null");
            return;
        }
        ka.a y16 = ho.i.y();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        y16.c(context);
    }

    private final void initViewModel() {
        RFWIocAbilityProvider.g().getIoc(i.class).originView(getPartRootView()).done(new OnPromiseResolved() { // from class: com.qzone.reborn.albumx.qzonex.part.recommendtab.a
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZAlbumTabRecommendTitlePart.F9(QZAlbumTabRecommendTitlePart.this, (i) obj);
            }
        }).run();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumTabRecommendTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
    }
}
