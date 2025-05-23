package com.tencent.state.library.components.fragments;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseFragmentKt;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.square.DebugPageType;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquareFragmentLibraryBinding;
import com.tencent.state.template.map.component.TemplateRoomComponent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J,\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryDebugComponent;", "Lcom/tencent/state/library/components/fragments/LibraryBaseComponent;", "Landroid/view/View$OnLongClickListener;", "()V", "onFragmentResult", "", "type", "", "data", "Landroid/os/Bundle;", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, NodeProps.ON_LONG_CLICK, "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryDebugComponent extends LibraryBaseComponent implements View.OnLongClickListener {
    public static final int DEBUG_TYPE_FIND_EMPTY_SEAT = 2;
    public static final int DEBUG_TYPE_SWITCH_ROOM = 1;
    public static final String KEY_DEBUG_ITEM_TYPE = "key_debug_item_type";
    public static final String KEY_REQUEST_DEBUG = "key_request_debug";

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        if (Square.INSTANCE.getConfig().isDebug()) {
            VasSquareFragmentLibraryBinding bind = VasSquareFragmentLibraryBinding.bind(v3);
            Intrinsics.checkNotNullExpressionValue(bind, "VasSquareFragmentLibraryBinding.bind(v)");
            bind.title.setOnLongClickListener(this);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v3) {
        VasBaseFragment fragment;
        VasBaseFragment fragment2 = getFragment();
        if (fragment2 != null) {
            VasBaseFragmentKt.setFragmentResultListener(fragment2, KEY_REQUEST_DEBUG, new Function2<String, Bundle, Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryDebugComponent$onLongClick$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
                    invoke2(str, bundle);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str, Bundle data) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(data, "data");
                    LibraryDebugComponent.this.onFragmentResult(data.getInt(LibraryDebugComponent.KEY_DEBUG_ITEM_TYPE), data);
                }
            });
        }
        QPublicBaseFragment debugFragment = SquareBaseKt.getSquareCommon().getDebugFragment(DebugPageType.LIBRARY);
        if (debugFragment == null || (fragment = getFragment()) == null) {
            return true;
        }
        fragment.pushFragment(debugFragment);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFragmentResult(int type, Bundle data) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        VasBaseFragment vasBaseFragment2;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        if (type == 1) {
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup3 == null || (component$default = vasBaseFragmentComponentGroup3.getComponent(LibraryRoomComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(LibraryRoomComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, LibraryRoomComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default = vasBaseFragment3 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, LibraryRoomComponent.class, null, null, 6, null) : null;
            }
            LibraryRoomComponent libraryRoomComponent = (LibraryRoomComponent) component$default;
            if (libraryRoomComponent != null) {
                TemplateRoomComponent.switchRoom$default(libraryRoomComponent, null, null, 3, null);
                return;
            }
            return;
        }
        if (type != 2) {
            return;
        }
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup4 == null || (component$default2 = vasBaseFragmentComponentGroup4.getComponent(LibraryFocusComponent.class, null)) == null) && (((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default2 = vasBaseFragmentComponentGroup2.getComponent(LibraryFocusComponent.class, null)) == null) && ((vasBaseFragment2 = ((VasBaseFragmentComponent) this).fragment) == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, LibraryFocusComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default2 = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, LibraryFocusComponent.class, null, null, 6, null) : null;
        }
        LibraryFocusComponent libraryFocusComponent = (LibraryFocusComponent) component$default2;
        if (libraryFocusComponent != null) {
            libraryFocusComponent.showSitDownPanel(null, true);
        }
    }
}
