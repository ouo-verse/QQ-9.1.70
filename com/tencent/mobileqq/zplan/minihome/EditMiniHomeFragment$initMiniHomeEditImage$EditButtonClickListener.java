package com.tencent.mobileqq.zplan.minihome;

import android.view.View;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeActionBtnComponent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import yk0.DecorateInfo;
import yk0.FurnitureDesc;

/* compiled from: P */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment$initMiniHomeEditImage$EditButtonClickListener", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "", "d", "Ljava/lang/String;", "slot", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "<init>", "(Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class EditMiniHomeFragment$initMiniHomeEditImage$EditButtonClickListener implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String slot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> onClick;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ EditMiniHomeFragment f334258f;

    public EditMiniHomeFragment$initMiniHomeEditImage$EditButtonClickListener(EditMiniHomeFragment this$0, String slot, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.f334258f = this$0;
        this.slot = slot;
        this.onClick = onClick;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        MiniHomeActionBtnComponent miniHomeActionBtnComponent;
        if (v3 != null) {
            v3.setSelected(true);
        }
        this.onClick.invoke();
        miniHomeActionBtnComponent = this.f334258f.actionBtnComponent;
        if (miniHomeActionBtnComponent != null) {
            miniHomeActionBtnComponent.i();
        }
        final EditMiniHomeFragment editMiniHomeFragment = this.f334258f;
        editMiniHomeFragment.nj(this.slot, new com.tencent.filament.zplan.scene.minihome.a() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$initMiniHomeEditImage$EditButtonClickListener$onClick$1
            @Override // com.tencent.filament.zplan.scene.minihome.a
            public void onDecorateInfoCallback(DecorateInfo decorateInfo) {
                FurnitureDesc furniture;
                ConcurrentHashMap concurrentHashMap;
                String str;
                String str2;
                String str3;
                if (decorateInfo != null) {
                    EditMiniHomeFragment$initMiniHomeEditImage$EditButtonClickListener editMiniHomeFragment$initMiniHomeEditImage$EditButtonClickListener = EditMiniHomeFragment$initMiniHomeEditImage$EditButtonClickListener.this;
                    EditMiniHomeFragment editMiniHomeFragment2 = editMiniHomeFragment;
                    if (decorateInfo.getSuccess() && (furniture = decorateInfo.getFurniture()) != null) {
                        if (furniture.getError() != 0) {
                            str3 = editMiniHomeFragment$initMiniHomeEditImage$EditButtonClickListener.slot;
                            QLog.e("EditMiniHomeFragment", 1, "selectDecorate " + str3 + " error.");
                        }
                        concurrentHashMap = editMiniHomeFragment2.furnitureDescMapOnScreen;
                        str = editMiniHomeFragment$initMiniHomeEditImage$EditButtonClickListener.slot;
                        concurrentHashMap.put(str, furniture);
                        str2 = editMiniHomeFragment$initMiniHomeEditImage$EditButtonClickListener.slot;
                        editMiniHomeFragment2.dj(str2, furniture);
                        editMiniHomeFragment2.fj(furniture.getCondition(), 0);
                    }
                }
            }
        });
    }
}
