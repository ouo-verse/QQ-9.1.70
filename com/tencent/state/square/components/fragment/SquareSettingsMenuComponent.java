package com.tencent.state.square.components.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.view.BottomActionSheet;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareSettingsMenuComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", "onFragmentViewCreated", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "showMenu", "context", "Landroid/content/Context;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareSettingsMenuComponent extends SquareBaseComponent {
    private static final int ACTION_ADD_FRIEND_TO_SQUARE = 2;
    private static final int ACTION_SHARE = 1;
    private static final String TAG = "SquareSettingsMenuComponent";
    private VasSquareFragmentSquareBinding binding;

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMenu(Context context) {
        final BottomActionSheet bottomActionSheet = new BottomActionSheet(context);
        bottomActionSheet.addActionSheet(1, "\u5206\u4eab");
        bottomActionSheet.addActionSheet(2, "\u6dfb\u52a0\u597d\u53cb\u81f3\u5e7f\u573a");
        bottomActionSheet.setItemClickListener(new Function2<Integer, View, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareSettingsMenuComponent$showMenu$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, View view) {
                invoke(num.intValue(), view);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, View view) {
                WeakReference<VasBaseFragmentComponentGroup> parent;
                FragmentComponent fragmentComponent;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                WeakReference<VasBaseFragmentComponentGroup> parent2;
                FragmentComponent fragmentComponent2;
                FragmentComponent component$default2;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
                ISquareBaseMessageService messageService;
                VasBaseFragment fragment;
                Intrinsics.checkNotNullParameter(view, "view");
                FragmentComponent fragmentComponent3 = null;
                if (i3 == 1) {
                    SquareSettingsMenuComponent squareSettingsMenuComponent = SquareSettingsMenuComponent.this;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!(squareSettingsMenuComponent instanceof VasBaseFragmentComponentGroup) ? null : squareSettingsMenuComponent);
                    if ((vasBaseFragmentComponentGroup3 == null || (fragmentComponent = vasBaseFragmentComponentGroup3.getComponent(SquareShareComponent.class, null)) == null) && ((parent = squareSettingsMenuComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(SquareShareComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) squareSettingsMenuComponent).fragment;
                        if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareShareComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) squareSettingsMenuComponent).parentFragment;
                            if (vasBaseFragment2 != null) {
                                fragmentComponent3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareShareComponent.class, null, null, 6, null);
                            }
                        } else {
                            fragmentComponent3 = component$default;
                        }
                        fragmentComponent = fragmentComponent3;
                    }
                    SquareShareComponent squareShareComponent = (SquareShareComponent) fragmentComponent;
                    if (squareShareComponent != null) {
                        squareShareComponent.share();
                    }
                } else if (i3 == 2) {
                    SquareSettingsMenuComponent squareSettingsMenuComponent2 = SquareSettingsMenuComponent.this;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(squareSettingsMenuComponent2 instanceof VasBaseFragmentComponentGroup) ? null : squareSettingsMenuComponent2);
                    if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent2 = vasBaseFragmentComponentGroup4.getComponent(SquareServiceProvider.class, null)) == null) && ((parent2 = squareSettingsMenuComponent2.getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (fragmentComponent2 = vasBaseFragmentComponentGroup2.getComponent(SquareServiceProvider.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) squareSettingsMenuComponent2).fragment;
                        if (vasBaseFragment3 == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, SquareServiceProvider.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) squareSettingsMenuComponent2).parentFragment;
                            if (vasBaseFragment4 != null) {
                                fragmentComponent3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, SquareServiceProvider.class, null, null, 6, null);
                            }
                        } else {
                            fragmentComponent3 = component$default2;
                        }
                        fragmentComponent2 = fragmentComponent3;
                    }
                    SquareServiceProvider squareServiceProvider = (SquareServiceProvider) fragmentComponent2;
                    if (squareServiceProvider != null && (messageService = squareServiceProvider.getMessageService()) != null) {
                        fragment = SquareSettingsMenuComponent.this.getFragment();
                        ISquareBaseMessageService.DefaultImpls.openMiniSelectPage$default(messageService, fragment, 1000, true, true, null, 16, null);
                    }
                }
                bottomActionSheet.dismiss();
            }
        });
        bottomActionSheet.show();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        VasSquareFragmentSquareBinding bind = VasSquareFragmentSquareBinding.bind(v3);
        bind.setting.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.components.fragment.SquareSettingsMenuComponent$onFragmentViewCreated$$inlined$also$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View v16) {
                SquareSettingsMenuComponent squareSettingsMenuComponent = SquareSettingsMenuComponent.this;
                Intrinsics.checkNotNullExpressionValue(v16, "v");
                Context context = v16.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                squareSettingsMenuComponent.showMenu(context);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.binding = bind;
    }
}
