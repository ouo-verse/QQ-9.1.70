package com.tencent.robot.slash.businessapi;

import android.view.View;
import b54.FunctionReportArgs;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w64.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\fH&J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J \u0010#\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0016J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020'H\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/robot/slash/businessapi/c;", "Lcom/tencent/robot/slash/businessapi/b;", "Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Lw64/n;", "Lu54/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "args", "Lcom/tencent/robot/slash/businessapi/d;", "k", "searchResponse", "", "keyword", "Lcom/tencent/robot/slash/businessapi/a;", "j", "Lb74/a;", "itemData", "", "a", "Lb54/a;", "itemArgs", "g", "e", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "f", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "functionInfo", "", "functionType", "i", "robotUin", "robotTinyId", "b", "", "hideKeyboard", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface c extends b {
    void a(@NotNull b74.a itemData, @Nullable String keyword);

    void b(@NotNull String robotUin, @NotNull String robotTinyId);

    void c();

    void d(@NotNull View rootView);

    void e(@NotNull FunctionReportArgs itemArgs);

    void f(@NotNull View rootView);

    void g(@NotNull FunctionReportArgs itemArgs);

    boolean hideKeyboard();

    void i(@NotNull CommonBotInfo robotInfo, @NotNull CommonBotFeatureInfo functionInfo, int functionType);

    @Nullable
    com.tencent.robot.slash.businessapi.a j(@Nullable Object searchResponse, @NotNull String keyword);

    @Nullable
    SearchSessionParams k(@Nullable Object args);

    @NotNull
    n<u54.c> m(@NotNull com.tencent.mvi.api.runtime.b mviContext);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ SearchSessionParams a(c cVar, Object obj, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 1) != 0) {
                    obj = null;
                }
                return cVar.k(obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildSearchParams");
        }

        public static boolean b(@NotNull c cVar) {
            return false;
        }

        public static void d(@NotNull c cVar, @NotNull FunctionReportArgs itemArgs) {
            Intrinsics.checkNotNullParameter(itemArgs, "itemArgs");
        }

        public static void e(@NotNull c cVar, @NotNull FunctionReportArgs itemArgs) {
            Intrinsics.checkNotNullParameter(itemArgs, "itemArgs");
        }

        public static void f(@NotNull c cVar, @NotNull String robotUin, @NotNull String robotTinyId) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(robotTinyId, "robotTinyId");
        }

        public static void g(@NotNull c cVar, @NotNull CommonBotInfo robotInfo, @NotNull CommonBotFeatureInfo functionInfo, int i3) {
            Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
            Intrinsics.checkNotNullParameter(functionInfo, "functionInfo");
        }

        public static void c(@NotNull c cVar) {
        }
    }
}
