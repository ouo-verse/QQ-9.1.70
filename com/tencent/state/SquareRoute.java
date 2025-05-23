package com.tencent.state;

import android.content.Context;
import android.os.Bundle;
import com.tencent.state.SquarePublicActivity;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J5\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/SquareRoute;", "", "()V", "LIBRARY_SRC_AVATAR_LABEL", "", "LIBRARY_SRC_FLOAT_BALL", "LIBRARY_SRC_NONE", "LIBRARY_SRC_WELCOME_DIALOG", "TAG", "", "gotoLibrary", "", "context", "Landroid/content/Context;", "source", "bundle", "Landroid/os/Bundle;", "requestCode", "(Landroid/content/Context;ILandroid/os/Bundle;Ljava/lang/Integer;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class SquareRoute {
    public static final SquareRoute INSTANCE = new SquareRoute();
    public static final int LIBRARY_SRC_AVATAR_LABEL = 3;
    public static final int LIBRARY_SRC_FLOAT_BALL = 2;
    public static final int LIBRARY_SRC_NONE = 0;
    public static final int LIBRARY_SRC_WELCOME_DIALOG = 1;
    private static final String TAG = "SquareRoute";

    SquareRoute() {
    }

    public static /* synthetic */ void gotoLibrary$default(SquareRoute squareRoute, Context context, int i3, Bundle bundle, Integer num, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            bundle = null;
        }
        if ((i16 & 8) != 0) {
            num = null;
        }
        squareRoute.gotoLibrary(context, i3, bundle, num);
    }

    public final void gotoLibrary(Context context, int source, Bundle bundle, Integer requestCode) {
        String str;
        if (context != null) {
            if (source == 1) {
                str = "em_zplan_library_open_popup_window";
            } else if (source != 2) {
                str = source != 3 ? null : "em_zplan_avatar_library_icon";
            } else {
                str = SquareReportConst.ElementId.ELEMENT_ID_LIBRARY_FLOAT_BALL;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            if (str != null) {
                bundle2.putString("subReferer", str);
            }
            SquareBaseKt.getSquareLog().i(TAG, "gotoLibrary: source=" + str);
            if (requestCode == null) {
                SquarePublicActivity.Launcher.start$default(context, 2, bundle2, (Integer) null, 8, (Object) null);
            } else {
                SquarePublicActivity.Launcher.start(context, 2, bundle2, requestCode);
            }
        }
    }
}
