package com.tencent.state.square.components;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.SquareRoute;
import com.tencent.state.VasBaseFragmentComponent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/components/SquareGroupLibraryComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "()V", "gotoLibrary", "", "locateTo", "", "source", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareGroupLibraryComponent extends VasBaseFragmentComponent {
    public final void gotoLibrary(String locateTo, int source) {
        QBaseActivity activity = getActivity();
        if (activity != null) {
            Intent intent = activity.getIntent();
            Bundle extras = intent != null ? intent.getExtras() : null;
            if (locateTo != null && extras != null) {
                extras.putString("uin", locateTo);
            }
            String string = extras != null ? extras.getString("source") : null;
            if ((string == null || string.length() == 0) && extras != null) {
                extras.putString("source", "1");
            }
            SquareRoute.INSTANCE.gotoLibrary(activity, source, extras, 1003);
        }
    }

    public static /* synthetic */ void gotoLibrary$default(SquareGroupLibraryComponent squareGroupLibraryComponent, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = null;
        }
        squareGroupLibraryComponent.gotoLibrary(str, i3);
    }
}
