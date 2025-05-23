package com.tencent.state.library.focus.component;

import com.tencent.state.library.focus.FocusBaseFragment;
import com.tencent.state.library.focus.IFocusParentView;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.data.FocusGroupItem;
import com.tencent.state.library.focus.data.FocusSingleItem;
import com.tencent.state.library.focus.view.FocusGroupView;
import com.tencent.state.square.data.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/library/focus/component/FocusRecordComponent;", "Lcom/tencent/state/library/focus/component/FocusBaseComponent;", "()V", "doGroupMeRecordAvatar", "", "data", "Lcom/tencent/state/library/focus/data/FocusGroupItem;", "doSingleMeRecord", "Lcom/tencent/state/library/focus/data/FocusSingleItem;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusRecordComponent extends FocusBaseComponent {
    private static final String TAG = "FocusRecordComponent";

    public final void doGroupMeRecordAvatar(FocusGroupItem data) {
        Resource meResource;
        FocusBaseFragment focusFragment;
        FocusBaseFragment focusFragment2 = getFocusFragment();
        IFocusParentView fragmentView = focusFragment2 != null ? focusFragment2.getFragmentView() : null;
        if (!(fragmentView instanceof FocusGroupView)) {
            fragmentView = null;
        }
        FocusGroupView focusGroupView = (FocusGroupView) fragmentView;
        if (focusGroupView != null) {
            if ((data != null ? Boolean.valueOf(FocusDataKt.hasMe(data)) : null) == null || !FocusDataKt.hasMe(data) || (meResource = FocusDataKt.getMeResource(data)) == null || !meResource.getIsDefault() || (focusFragment = getFocusFragment()) == null) {
                return;
            }
            focusFragment.recordAvatar(meResource, new FocusRecordComponent$doGroupMeRecordAvatar$1(data, focusGroupView));
        }
    }

    public final void doSingleMeRecord(FocusSingleItem data) {
        FocusBaseFragment focusFragment;
        Intrinsics.checkNotNullParameter(data, "data");
        Resource focusResource = FocusDataKt.focusResource(data.getSingleItem());
        if (focusResource == null || !focusResource.getIsDefault() || (focusFragment = getFocusFragment()) == null) {
            return;
        }
        focusFragment.recordAvatar(FocusDataKt.focusResource(data.getSingleItem()), new FocusRecordComponent$doSingleMeRecord$1(this, data));
    }
}
