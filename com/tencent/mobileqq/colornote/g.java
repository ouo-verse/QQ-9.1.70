package com.tencent.mobileqq.colornote;

import android.graphics.Point;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {
    public void onAddColorNote(Bundle bundle, boolean z16) {
        if (bundle != null) {
            int i3 = bundle.getInt(ColorNote.PARAM_SERVICETYPE);
            String string = bundle.getString(ColorNote.PARAM_SUBTYPE);
            if (bundle.getInt(ColorNote.PARAM_EXTRA, 1) != 2) {
                ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).updateColorNoteSet(i3, string, z16);
            }
            ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).updateFloatingWindowPosition(new Point(bundle.getInt("key_float_window_position_x"), bundle.getInt("key_float_window_position_y")));
        }
    }

    public void onDeleteColorNote(int i3, String str, boolean z16) {
        ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).updateColorNoteSet(i3, str, z16);
    }

    public void onUpdateColorNoteState(int i3, String str, Bundle bundle) {
        if (bundle != null) {
            ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).updateColorNoteSet(i3, str, bundle.getBoolean("extra_is_colornote_exists"));
            ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).setCanAddColorNote(bundle.getBoolean("extra_can_add_colornote"));
            ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).updateFloatingWindowPosition(new Point(bundle.getInt("key_float_window_position_x"), bundle.getInt("key_float_window_position_y")));
            ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).setSyncState(bundle.getBoolean("extra_after_sync_msg"));
        }
    }

    public void onUpdateColorNote(ColorNote colorNote, boolean z16) {
    }
}
