package b54;

import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lb54/b;", "", "Lb54/a;", "args", "", "b", "a", "d", "c", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f27956a = new b();

    b() {
    }

    public final void a(@NotNull FunctionReportArgs args) {
        Intrinsics.checkNotNullParameter(args, "args");
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_order_id", Integer.valueOf(args.getFunctionInfo().f359162id));
        hashMap.put("qq_robot_order_name", args.getFunctionInfo().name);
        hashMap.put("qq_robot_order_location", Integer.valueOf(args.getPosition()));
        VideoReport.setElementId(args.getItemView(), "em_qqrobot_robot_order");
        VideoReport.reportEvent("dt_clck", args.getItemView(), hashMap);
    }

    public final void b(@NotNull FunctionReportArgs args) {
        Intrinsics.checkNotNullParameter(args, "args");
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_order_id", Integer.valueOf(args.getFunctionInfo().f359162id));
        hashMap.put("qq_robot_order_name", args.getFunctionInfo().name);
        hashMap.put("qq_robot_order_location", Integer.valueOf(args.getPosition()));
        VideoReport.setElementId(args.getItemView(), "em_qqrobot_robot_order");
        VideoReport.reportEvent("dt_imp", args.getItemView(), hashMap);
    }

    public final void c(@NotNull FunctionReportArgs args) {
        Intrinsics.checkNotNullParameter(args, "args");
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_service_location", Integer.valueOf(args.getPosition()));
        hashMap.put("qq_robot_order_id", Long.valueOf(args.getRobotInfo().uin));
        hashMap.put("qq_robot_function_id", Integer.valueOf(args.getFunctionInfo().f359162id));
        hashMap.put("qq_robot_function_name", args.getFunctionInfo().name);
        VideoReport.setElementId(args.getItemView(), "em_qqrobot_function_at");
        VideoReport.reportEvent("dt_clck", args.getItemView(), hashMap);
    }

    public final void d(@NotNull FunctionReportArgs args) {
        Intrinsics.checkNotNullParameter(args, "args");
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_service_location", Integer.valueOf(args.getPosition()));
        hashMap.put("qq_robot_order_id", Long.valueOf(args.getRobotInfo().uin));
        hashMap.put("qq_robot_function_id", Integer.valueOf(args.getFunctionInfo().f359162id));
        hashMap.put("qq_robot_function_name", args.getFunctionInfo().name);
        VideoReport.setElementId(args.getItemView(), "em_qqrobot_function_at");
        VideoReport.reportEvent("dt_imp", args.getItemView(), hashMap);
    }
}
