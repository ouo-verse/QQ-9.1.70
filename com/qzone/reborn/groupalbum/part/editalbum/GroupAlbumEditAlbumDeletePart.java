package com.qzone.reborn.groupalbum.part.editalbum;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.viewmodel.EditAlbumResult;
import com.qzone.reborn.albumx.common.viewmodel.EditAlbumType;
import com.qzone.reborn.base.k;
import com.qzone.reborn.groupalbum.viewmodel.r;
import com.qzone.util.l;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R#\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/editalbum/GroupAlbumEditAlbumDeletePart;", "Lcom/qzone/reborn/base/k;", "", "showConfirmDialog", "", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/qzone/reborn/groupalbum/viewmodel/r;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "H9", "()Lcom/qzone/reborn/groupalbum/viewmodel/r;", "vm", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumEditAlbumDeletePart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    public GroupAlbumEditAlbumDeletePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<r>() { // from class: com.qzone.reborn.groupalbum.part.editalbum.GroupAlbumEditAlbumDeletePart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final r invoke() {
                return (r) GroupAlbumEditAlbumDeletePart.this.getViewModel(r.class);
            }
        });
        this.vm = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r H9() {
        return (r) this.vm.getValue();
    }

    private final boolean I9() {
        Intent intent;
        Activity activity = getActivity();
        CommonAlbumEditInitBean commonAlbumEditInitBean = (activity == null || (intent = activity.getIntent()) == null) ? null : (CommonAlbumEditInitBean) intent.getParcelableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(commonAlbumEditInitBean, "null cannot be cast to non-null type com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean");
        return commonAlbumEditInitBean.getHasDeleteRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(GroupAlbumEditAlbumDeletePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showConfirmDialog();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(GroupAlbumEditAlbumDeletePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9().m2();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void showConfirmDialog() {
        DialogUtil.createCustomDialog(getContext(), 230, "\u786e\u8ba4\u5220\u9664\u6b64\u76f8\u518c\u5417", "\u5220\u9664\u540e\u7fa4\u6210\u5458\u90fd\u5c06\u65e0\u6cd5\u67e5\u770b\u3002", "\u53d6\u6d88", "\u5220\u9664", new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.editalbum.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GroupAlbumEditAlbumDeletePart.L9(GroupAlbumEditAlbumDeletePart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.editalbum.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GroupAlbumEditAlbumDeletePart.M9(dialogInterface, i3);
            }
        }).show();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.m1t);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.editalbum.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupAlbumEditAlbumDeletePart.J9(GroupAlbumEditAlbumDeletePart.this, view);
                }
            });
            findViewById.setVisibility(I9() ? 0 : 8);
        }
        LiveData<EditAlbumResult> N1 = H9().N1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<EditAlbumResult, Unit> function1 = new Function1<EditAlbumResult, Unit>() { // from class: com.qzone.reborn.groupalbum.part.editalbum.GroupAlbumEditAlbumDeletePart$onInitView$2
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
                r H9;
                if (editAlbumResult.getType() == EditAlbumType.DELETE) {
                    if (!editAlbumResult.getIsSucceed()) {
                        QQToast.makeText(GroupAlbumEditAlbumDeletePart.this.getContext(), 1, l.a(R.string.v8y), 0).show();
                        return;
                    }
                    Activity activity = GroupAlbumEditAlbumDeletePart.this.getActivity();
                    Intent intent = new Intent();
                    intent.putExtra("KEY_DELETE_ALBUM_INFO", editAlbumResult.getAlbumInfo());
                    Unit unit = Unit.INSTANCE;
                    activity.setResult(-1, intent);
                    activity.finish();
                    com.qzone.reborn.part.publish.common.selectalbum.d dVar = com.qzone.reborn.part.publish.common.selectalbum.d.f58616a;
                    H9 = GroupAlbumEditAlbumDeletePart.this.H9();
                    dVar.a("group_album_selected_album_info", H9.O1().getBizId());
                }
            }
        };
        N1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.part.editalbum.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAlbumEditAlbumDeletePart.K9(Function1.this, obj);
            }
        });
    }
}
