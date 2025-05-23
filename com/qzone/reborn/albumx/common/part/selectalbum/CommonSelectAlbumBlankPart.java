package com.qzone.reborn.albumx.common.part.selectalbum;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.common.bean.h;
import com.qzone.reborn.albumx.common.viewmodel.l;
import com.qzone.reborn.base.k;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J\b\u0010\r\u001a\u00020\fH$J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H$R\"\u0010\u0019\u001a\u00020\u00128\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\f8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/selectalbum/CommonSelectAlbumBlankPart;", "Lcom/qzone/reborn/base/k;", "", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/h;", "listUIStateData", "H9", "I9", "M9", "N9", "Lcom/qzone/reborn/albumx/common/viewmodel/l;", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "J9", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "d", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "F9", "()Lcom/qzone/reborn/widget/QZoneBlankStateView;", "L9", "(Lcom/qzone/reborn/widget/QZoneBlankStateView;)V", "blankView", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "f", "Lkotlin/Lazy;", "G9", "()Lcom/qzone/reborn/albumx/common/viewmodel/l;", "vm", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class CommonSelectAlbumBlankPart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected QZoneBlankStateView blankView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView rv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    public CommonSelectAlbumBlankPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumBlankPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final l invoke() {
                return CommonSelectAlbumBlankPart.this.E9();
            }
        });
        this.vm = lazy;
    }

    private final void I9() {
        F9().o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void M9() {
        J9();
        F9().s0();
    }

    private final void N9(UIStateData<List<h>> listUIStateData) {
        J9();
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        F9().showErrorView();
    }

    private final void initData() {
        LiveData<UIStateData<List<h>>> M1 = G9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<h>>, Unit> function1 = new Function1<UIStateData<List<h>>, Unit>() { // from class: com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumBlankPart$initData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<h>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<h>> uIStateData) {
                CommonSelectAlbumBlankPart.this.H9(uIStateData);
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.common.part.selectalbum.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommonSelectAlbumBlankPart.K9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract l E9();

    /* JADX INFO: Access modifiers changed from: protected */
    public final QZoneBlankStateView F9() {
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView != null) {
            return qZoneBlankStateView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("blankView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final l G9() {
        return (l) this.vm.getValue();
    }

    protected abstract void J9();

    protected final void L9(QZoneBlankStateView qZoneBlankStateView) {
        Intrinsics.checkNotNullParameter(qZoneBlankStateView, "<set-?>");
        this.blankView = qZoneBlankStateView;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.mqu);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_blank_view)");
            L9((QZoneBlankStateView) findViewById);
            View findViewById2 = rootView.findViewById(R.id.f18743t);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.album_list)");
            this.rv = (RecyclerView) findViewById2;
        }
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(UIStateData<List<h>> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        int state = listUIStateData.getState();
        if (state == 0) {
            M9();
            return;
        }
        if (state == 2 || state == 3) {
            I9();
        } else {
            if (state != 4) {
                return;
            }
            N9(listUIStateData);
        }
    }
}
