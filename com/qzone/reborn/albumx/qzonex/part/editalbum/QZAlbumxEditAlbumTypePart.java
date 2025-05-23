package com.qzone.reborn.albumx.qzonex.part.editalbum;

import android.app.Dialog;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.au;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u001d\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R>\u0010'\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#0\"j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#`$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/editalbum/QZAlbumxEditAlbumTypePart;", "Lcom/qzone/reborn/base/k;", "", "P9", "M9", "", "albumType", "J9", "(I)Ljava/lang/Integer;", "which", "L9", "Landroid/view/View;", "view", "I9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tvAlbumType", "e", "Landroid/view/View;", "tvAlbumTypeContainer", "Lnc/au;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "K9", "()Lnc/au;", "vm", "Lcom/tencent/widget/ActionSheet;", tl.h.F, "Lcom/tencent/widget/ActionSheet;", "actionSheetWithSelect", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "actionSheetDatas", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxEditAlbumTypePart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvAlbumType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View tvAlbumTypeContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ActionSheet actionSheetWithSelect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Pair<Integer, Integer>> actionSheetDatas;

    public QZAlbumxEditAlbumTypePart() {
        Lazy lazy;
        ArrayList<Pair<Integer, Integer>> arrayListOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<au>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditAlbumTypePart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final au invoke() {
                return (au) QZAlbumxEditAlbumTypePart.this.getViewModel(au.class);
            }
        });
        this.vm = lazy;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new Pair(0, Integer.valueOf(R.string.gtq)), new Pair(12, Integer.valueOf(R.string.gsr)), new Pair(11, Integer.valueOf(R.string.grt)), new Pair(8, Integer.valueOf(R.string.f169516gt0)), new Pair(9, Integer.valueOf(R.string.gtr)));
        this.actionSheetDatas = arrayListOf;
    }

    private final void I9(View view) {
        fo.c.o(view, "em_qz_change_album_type", new fo.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer J9(int albumType) {
        Iterator<T> it = this.actionSheetDatas.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (((Number) pair.getFirst()).intValue() == albumType) {
                return (Integer) pair.getSecond();
            }
        }
        return null;
    }

    private final au K9() {
        return (au) this.vm.getValue();
    }

    private final void M9() {
        CommonAlbumInfo albumInfo;
        CommonAlbumEditInitBean value = K9().M1().getValue();
        if (value == null || (albumInfo = value.getAlbumInfo()) == null) {
            return;
        }
        int qzAlbumType = albumInfo.getQzAlbumType();
        Iterator<Pair<Integer, Integer>> it = this.actionSheetDatas.iterator();
        while (it.hasNext()) {
            Pair<Integer, Integer> next = it.next();
            ActionSheet actionSheet = this.actionSheetWithSelect;
            if (actionSheet != null) {
                actionSheet.addRadioButton(next.getSecond().intValue(), qzAlbumType == next.getFirst().intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QZAlbumxEditAlbumTypePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void P9() {
        ActionSheet actionSheet = this.actionSheetWithSelect;
        if (actionSheet != null) {
            if (actionSheet != null) {
                actionSheet.show();
                return;
            }
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        this.actionSheetWithSelect = (ActionSheet) createDialog;
        M9();
        ActionSheet actionSheet2 = this.actionSheetWithSelect;
        if (actionSheet2 != null) {
            actionSheet2.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.h
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    QZAlbumxEditAlbumTypePart.Q9(QZAlbumxEditAlbumTypePart.this, view, i3);
                }
            });
        }
        ActionSheet actionSheet3 = this.actionSheetWithSelect;
        if (actionSheet3 != null) {
            actionSheet3.addCancelButton(R.string.f185563ox);
        }
        ActionSheet actionSheet4 = this.actionSheetWithSelect;
        if (actionSheet4 != null) {
            actionSheet4.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QZAlbumxEditAlbumTypePart this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9(i3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.m1d);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxEditAlbumTypePart.N9(QZAlbumxEditAlbumTypePart.this, view);
                }
            });
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.\u2026          }\n            }");
            this.tvAlbumTypeContainer = findViewById;
            View findViewById2 = findViewById.findViewById(R.id.njc);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "tvAlbumTypeContainer.findViewById(R.id.tv_name)");
            this.tvAlbumType = (TextView) findViewById2;
            View view = this.tvAlbumTypeContainer;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAlbumTypeContainer");
                view = null;
            }
            view.setVisibility(8);
            View view3 = this.tvAlbumTypeContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAlbumTypeContainer");
            } else {
                view2 = view3;
            }
            I9(view2);
        }
        LiveData<CommonAlbumEditInitBean> M1 = K9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonAlbumEditInitBean, Unit> function1 = new Function1<CommonAlbumEditInitBean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditAlbumTypePart$onInitView$2
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
                View view4;
                Integer J9;
                TextView textView;
                if (commonAlbumEditInitBean == null || !com.qzone.reborn.albumx.qzonex.utils.c.f53402a.f(commonAlbumEditInitBean.getAlbumInfo()) || commonAlbumEditInitBean.getAlbumInfo().getOpInfo().getProhibitModifyAlbumType()) {
                    return;
                }
                view4 = QZAlbumxEditAlbumTypePart.this.tvAlbumTypeContainer;
                TextView textView2 = null;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvAlbumTypeContainer");
                    view4 = null;
                }
                view4.setVisibility(0);
                J9 = QZAlbumxEditAlbumTypePart.this.J9(commonAlbumEditInitBean.getAlbumInfo().getQzAlbumType());
                if (J9 != null) {
                    int intValue = J9.intValue();
                    textView = QZAlbumxEditAlbumTypePart.this.tvAlbumType;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvAlbumType");
                    } else {
                        textView2 = textView;
                    }
                    textView2.setText(QZAlbumxEditAlbumTypePart.this.getContext().getText(intValue));
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxEditAlbumTypePart.O9(Function1.this, obj);
            }
        });
    }

    private final void L9(int which) {
        if (which < 0 || which >= this.actionSheetDatas.size()) {
            return;
        }
        K9().x2(this.actionSheetDatas.get(which).getFirst().intValue());
        ActionSheet actionSheet = this.actionSheetWithSelect;
        if (actionSheet != null) {
            actionSheet.dismiss();
        }
    }
}
