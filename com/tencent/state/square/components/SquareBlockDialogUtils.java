package com.tencent.state.square.components;

import android.content.Context;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.square.api.p015const.LauncherConst;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/components/SquareBlockDialogUtils;", "", "()V", "isBlockDialog", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareBlockDialogUtils {
    public static final SquareBlockDialogUtils INSTANCE = new SquareBlockDialogUtils();

    SquareBlockDialogUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0036 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isBlockDialog(Context activity) {
        if (activity == null) {
            return false;
        }
        String sourceFrom = SquareGroupReportComponentKt.getSourceFrom(activity);
        switch (sourceFrom.hashCode()) {
            case -742233791:
                return sourceFrom.equals(LauncherConst.SQUARE_SOURCE_QQ_PORTAL);
            case -247340672:
                if (!sourceFrom.equals(LauncherConst.SQUARE_SOURCE_POSTER)) {
                    return false;
                }
                break;
            case 1311603960:
                if (!sourceFrom.equals(LauncherConst.SQUARE_SOURCE_QQ_ONLINE_STATE)) {
                    return false;
                }
                break;
            case 1886460853:
                if (!sourceFrom.equals(LauncherConst.SQUARE_SOURCE_FESTIVAL)) {
                    return false;
                }
                break;
            default:
                return false;
        }
    }
}
