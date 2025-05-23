package ad2;

import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.qqperf.debug.report.PerfProblemBusinessHandler;
import com.tencent.util.AppSetting;
import java.util.List;
import jy3.LargeImageProblem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n04.b;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lad2/a;", "Lo04/a;", "", "Ln04/b;", "bigBitmapList", "", "a", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements o04.a {
    @Override // o04.a
    public void a(@Nullable List<b> bigBitmapList) {
        com.tencent.mobileqq.perf.log.a.d("BB", "QQRMonitorBitmapListener." + bigBitmapList);
        if (!AppSetting.isPublicVersion() && bigBitmapList != null) {
            for (b bVar : bigBitmapList) {
                String str = bVar.f417935c;
                Intrinsics.checkNotNullExpressionValue(str, "it.viewChain");
                String str2 = bVar.f417933a;
                Intrinsics.checkNotNullExpressionValue(str2, "it.activityName");
                String f16 = SceneTracker.f();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(bVar.f417939g);
                sb5.append('*');
                sb5.append(bVar.f417940h);
                String sb6 = sb5.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(bVar.f417937e);
                sb7.append('*');
                sb7.append(bVar.f417938f);
                PerfProblemBusinessHandler.INSTANCE.c(new LargeImageProblem("\u5927\u56fe\u95ee\u9898", str, str2, f16, sb6, sb7.toString()));
            }
        }
    }
}
