package com.tencent.mobileqq.zplan.servlet;

import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/m;", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "success", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "a", "<init>", "()V", "d", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class m implements b {
    public void a(boolean success, @NotNull List<String> uinList) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        QLog.i("[zplan][ZPlanRequestObserver]", 1, "onUserAppearanceKeyChange, success:" + success + ", uinList:" + uinList);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        List<String> emptyList;
        if (type == 27405) {
            try {
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                emptyList = (List) data;
            } catch (Throwable th5) {
                QLog.e("[zplan][ZPlanRequestObserver]", 1, "onUpdate PROFILE_APPEARANCE_KEY exception", th5);
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            a(isSuccess, emptyList);
        }
    }
}
