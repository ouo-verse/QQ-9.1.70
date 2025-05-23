package com.qzone.reborn.albumx.qzonex.part.editalbum;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.viewmodel.EditAlbumResult;
import com.qzone.reborn.albumx.common.viewmodel.EditAlbumType;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.au;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R#\u0010\u001b\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/editalbum/QZAlbumxEditAlbumDeletePart;", "Lcom/qzone/reborn/base/k;", "", "J9", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumEditInitBean;", "initBean", "N9", "showConfirmDialog", "", "K9", "", "O9", "Landroid/view/View;", "view", "L9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tvDelete", "Lnc/au;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "M9", "()Lnc/au;", "vm", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxEditAlbumDeletePart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvDelete;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    public QZAlbumxEditAlbumDeletePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<au>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditAlbumDeletePart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final au invoke() {
                return (au) QZAlbumxEditAlbumDeletePart.this.getViewModel(au.class);
            }
        });
        this.vm = lazy;
    }

    private final void J9() {
        TextView textView = this.tvDelete;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDelete");
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.gravity = 17;
        TextView textView3 = this.tvDelete;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDelete");
        } else {
            textView2 = textView3;
        }
        textView2.setLayoutParams(layoutParams2);
    }

    private final String K9() {
        com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        if (!cVar.f(M9().O1().getAlbumInfo()) && !cVar.g(M9().O1().getAlbumInfo())) {
            String a16 = com.qzone.util.l.a(R.string.f134709j);
            Intrinsics.checkNotNullExpressionValue(a16, "{\n            //\u5171\u4eab\u6210\u5458\u663e\u793a\u63d0\u793a\u2026member_content)\n        }");
            return a16;
        }
        if (M9().O1().getAlbumInfo().getIsShareAlbum()) {
            String a17 = com.qzone.util.l.a(R.string.f134699i);
            Intrinsics.checkNotNullExpressionValue(a17, "{\n            HardCodeUt\u2026_share_content)\n        }");
            return a17;
        }
        String a18 = com.qzone.util.l.a(R.string.f134689h);
        Intrinsics.checkNotNullExpressionValue(a18, "{\n            HardCodeUt\u2026rsonal_content)\n        }");
        return a18;
    }

    private final void L9(View view) {
        fo.b bVar = new fo.b();
        bVar.k(ExposurePolicy.REPORT_NONE);
        fo.c.o(view, "em_qz_album_delete", bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final au M9() {
        return (au) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(CommonAlbumEditInitBean initBean) {
        com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        TextView textView = null;
        if (!cVar.f(initBean.getAlbumInfo()) && !cVar.g(initBean.getAlbumInfo())) {
            TextView textView2 = this.tvDelete;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvDelete");
            } else {
                textView = textView2;
            }
            textView.setText(com.qzone.util.l.a(R.string.gza));
            return;
        }
        TextView textView3 = this.tvDelete;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDelete");
        } else {
            textView = textView3;
        }
        textView.setText(com.qzone.util.l.a(R.string.gmt));
    }

    private final boolean O9() {
        CommonAlbumEditInitBean O1 = M9().O1();
        if (O1 != null) {
            return O1.getHasDeleteRight();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QZAlbumxEditAlbumDeletePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showConfirmDialog();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(QZAlbumxEditAlbumDeletePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9().q2();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void showConfirmDialog() {
        DialogUtil.createCustomDialog(getContext(), 230, com.qzone.util.l.a(R.string.f134719k), K9(), com.qzone.util.l.a(R.string.jka), com.qzone.util.l.a(R.string.jml), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZAlbumxEditAlbumDeletePart.S9(QZAlbumxEditAlbumDeletePart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZAlbumxEditAlbumDeletePart.T9(dialogInterface, i3);
            }
        }).show();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View deleteButton = rootView.findViewById(R.id.m1t);
            deleteButton.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxEditAlbumDeletePart.P9(QZAlbumxEditAlbumDeletePart.this, view);
                }
            });
            deleteButton.setVisibility(O9() ? 0 : 8);
            View findViewById = rootView.findViewById(R.id.nim);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_delete)");
            this.tvDelete = (TextView) findViewById;
            J9();
            Intrinsics.checkNotNullExpressionValue(deleteButton, "deleteButton");
            L9(deleteButton);
        }
        LiveData<EditAlbumResult> N1 = M9().N1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<EditAlbumResult, Unit> function1 = new Function1<EditAlbumResult, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditAlbumDeletePart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditAlbumResult editAlbumResult) {
                invoke2(editAlbumResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EditAlbumResult editAlbumResult) {
                au M9;
                if (editAlbumResult.getType() == EditAlbumType.DELETE) {
                    if (!editAlbumResult.getIsSucceed()) {
                        QQToast.makeText(QZAlbumxEditAlbumDeletePart.this.getContext(), 1, com.qzone.util.l.a(R.string.v8y), 0).show();
                        return;
                    }
                    Activity activity = QZAlbumxEditAlbumDeletePart.this.getActivity();
                    Intent intent = new Intent();
                    intent.putExtra("KEY_DELETE_ALBUM_INFO", editAlbumResult.getAlbumInfo());
                    Unit unit = Unit.INSTANCE;
                    activity.setResult(-1, intent);
                    activity.finish();
                    com.qzone.reborn.part.publish.common.selectalbum.d dVar = com.qzone.reborn.part.publish.common.selectalbum.d.f58616a;
                    M9 = QZAlbumxEditAlbumDeletePart.this.M9();
                    dVar.a("qzone_albumx_selected_album_info", M9.O1().getBizId());
                }
            }
        };
        N1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxEditAlbumDeletePart.Q9(Function1.this, obj);
            }
        });
        LiveData<CommonAlbumEditInitBean> M1 = M9().M1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<CommonAlbumEditInitBean, Unit> function12 = new Function1<CommonAlbumEditInitBean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditAlbumDeletePart$onInitView$3
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
                if (commonAlbumEditInitBean == null) {
                    return;
                }
                QZAlbumxEditAlbumDeletePart.this.N9(commonAlbumEditInitBean);
            }
        };
        M1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxEditAlbumDeletePart.R9(Function1.this, obj);
            }
        });
    }
}
