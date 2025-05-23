package com.tencent.state.square.components;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.state.SquareRuntime;
import com.tencent.state.VasBaseActivity;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u00a8\u0006\u0003"}, d2 = {"getSourceFrom", "", "Landroid/content/Context;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareGroupReportComponentKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String getSourceFrom(Context context) {
        boolean z16;
        boolean isBlank;
        Intent intent;
        String str = null;
        Activity activity = (Activity) (!(context instanceof Activity) ? null : context);
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("subReferer");
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    return str;
                }
                if (context instanceof VasBaseActivity) {
                    return "";
                }
                return SquareRuntime.INSTANCE.getSourceFrom();
            }
        }
        z16 = true;
        if (z16) {
        }
    }
}
