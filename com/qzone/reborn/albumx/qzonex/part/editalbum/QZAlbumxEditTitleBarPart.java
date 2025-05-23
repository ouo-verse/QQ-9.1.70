package com.qzone.reborn.albumx.qzonex.part.editalbum;

import android.content.DialogInterface;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditTitleBarPart;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.au;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/editalbum/QZAlbumxEditTitleBarPart;", "Lcom/qzone/reborn/albumx/common/part/editalbum/CommonAlbumEditTitleBarPart;", "", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxEditTitleBarPart extends CommonAlbumEditTitleBarPart {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        DialogUtil.createCustomDialog(getContext(), 230, "", com.qzone.util.l.a(R.string.imv), com.qzone.util.l.a(R.string.jka), com.qzone.util.l.a(R.string.f133145b), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.aa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZAlbumxEditTitleBarPart.M9(QZAlbumxEditTitleBarPart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.ab
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZAlbumxEditTitleBarPart.N9(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(QZAlbumxEditTitleBarPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().finish();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    @Override // com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditTitleBarPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        LiveData<Integer> p26;
        super.onInitView(rootView);
        com.qzone.reborn.albumx.common.viewmodel.c D9 = D9();
        au auVar = D9 instanceof au ? (au) D9 : null;
        if (auVar == null || (p26 = auVar.p2()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditTitleBarPart$onInitView$1
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
                QZAlbumxEditTitleBarPart.this.L9();
            }
        };
        p26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxEditTitleBarPart.K9(Function1.this, obj);
            }
        });
    }
}
