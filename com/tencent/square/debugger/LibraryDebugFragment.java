package com.tencent.square.debugger;

import android.os.Bundle;
import android.view.View;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.VasBaseFragmentKt;
import com.tencent.state.library.components.fragments.LibraryDebugComponent;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/square/debugger/LibraryDebugFragment;", "Lcom/tencent/square/debugger/BaseDebugFragment;", "", "sh", "<init>", "()V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryDebugFragment extends BaseDebugFragment {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            LibraryDebugFragment libraryDebugFragment = LibraryDebugFragment.this;
            Bundle bundle = new Bundle();
            bundle.putInt(LibraryDebugComponent.KEY_DEBUG_ITEM_TYPE, 1);
            Unit unit = Unit.INSTANCE;
            VasBaseFragmentKt.setFragmentResult(libraryDebugFragment, LibraryDebugComponent.KEY_REQUEST_DEBUG, bundle);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            LibraryDebugFragment libraryDebugFragment = LibraryDebugFragment.this;
            Bundle bundle = new Bundle();
            bundle.putInt(LibraryDebugComponent.KEY_DEBUG_ITEM_TYPE, 2);
            Unit unit = Unit.INSTANCE;
            VasBaseFragmentKt.setFragmentResult(libraryDebugFragment, LibraryDebugComponent.KEY_REQUEST_DEBUG, bundle);
        }
    }

    @Override // com.tencent.square.debugger.BaseDebugFragment
    protected void sh() {
        ph("\u5207\u6362\u623f\u95f4", new a());
        ph("\u627e\u4e2a\u7a7a\u5ea7", new b());
    }
}
