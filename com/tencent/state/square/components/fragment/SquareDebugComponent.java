package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.SquareDebug;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J,\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareDebugComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", NodeProps.ON_CLICK, "", "v", "Landroid/view/View;", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareDebugComponent extends SquareBaseComponent implements View.OnClickListener {
    private VasSquareFragmentSquareBinding binding;

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        VasSquareFragmentSquareBinding bind = VasSquareFragmentSquareBinding.bind(v3);
        bind.btnOutMessage.setOnClickListener(this);
        bind.btnNewMessage.setOnClickListener(this);
        bind.btnSetTop.setOnClickListener(this);
        LinearLayout linearLayout = bind.dynamicDebugger;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "it.dynamicDebugger");
        linearLayout.setVisibility(SquareDebug.INSTANCE.getEnableDynamicSortDebug() ? 0 : 8);
        Unit unit = Unit.INSTANCE;
        this.binding = bind;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        SquareView mapView;
        ISquareViewUpdater updater;
        List listOf;
        int collectionSizeOrDefault;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.pgc) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"1406623898", "1304256889", "604026459", "780024656", "450632712", "549858045", "1608527810", "278329250"});
            List list = listOf;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            final ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new MoveItem((String) it.next(), 0, false, null, 12, null));
            }
            SquareFragment squareFragment = getSquareFragment();
            if (squareFragment != null) {
                SquareFragment.locateToNewLocation$default(squareFragment, arrayList, false, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareDebugComponent$onClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        ISquareViewUpdater updater2;
                        SquareView mapView2 = SquareDebugComponent.this.getMapView();
                        if (mapView2 == null || (updater2 = mapView2.getUpdater()) == null) {
                            return;
                        }
                        updater2.doAirborneLanding(arrayList);
                    }
                }, 2, null);
                return;
            }
            return;
        }
        if (valueOf == null || valueOf.intValue() != R.id.pga || (mapView = getMapView()) == null || (updater = mapView.getUpdater()) == null) {
            return;
        }
        updater.onNewMessage(1);
    }
}
