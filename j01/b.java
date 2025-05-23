package j01;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.expand.module.u;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import d01.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J-\u0010\"\u001a\u00020\u00052%\u0010!\u001a!\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00050\u001cj\u0002` R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010%R;\u0010)\u001a'\u0012#\u0012!\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00050\u001cj\u0002` 0'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010(R\u0016\u0010+\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010*\u00a8\u0006."}, d2 = {"Lj01/b;", "Lcom/tencent/kuikly/core/render/android/performace/b;", "Lj01/a;", "", "r", "", "u", "", "p", "onInit", "l", "j", "f", "k", "i", h.F, "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "c", "a", "Lcom/tencent/kuikly/core/render/android/expand/module/u;", "createTrace", "t", "e", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "data", "Lcom/tencent/kuikly/core/render/android/performace/launch/KRLaunchDataListener;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "", "[Ljava/lang/Long;", "eventTimestamps", "", "Ljava/util/List;", "listeners", "Z", "hasNotifyListener", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b extends com.tencent.kuikly.core.render.android.performace.b<a> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Long[] eventTimestamps;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<Function1<a, Unit>> listeners;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasNotifyListener;

    public b() {
        Long[] lArr = new Long[21];
        for (int i3 = 0; i3 < 21; i3++) {
            lArr[i3] = 0L;
        }
        this.eventTimestamps = lArr;
        this.listeners = new ArrayList();
        lArr[20] = Long.MAX_VALUE;
    }

    private final boolean r() {
        int length = this.eventTimestamps.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.eventTimestamps[i3].longValue() == 0) {
                w.f392617a.c("KRLaunchMonitor", "timestamp is invalid:[" + i3 + ']');
                return false;
            }
        }
        return true;
    }

    private final void u() {
        a s16;
        if (!this.hasNotifyListener && (s16 = s()) != null) {
            this.hasNotifyListener = true;
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(s16);
            }
        }
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void a() {
        this.eventTimestamps[18] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void c() {
        this.eventTimestamps[10] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void d() {
        this.eventTimestamps[7] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void e() {
        this.eventTimestamps[19] = Long.valueOf(System.currentTimeMillis());
        u();
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void f() {
        this.eventTimestamps[3] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void g() {
        this.eventTimestamps[9] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void h() {
        this.eventTimestamps[6] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void i() {
        this.eventTimestamps[5] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void j() {
        this.eventTimestamps[2] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void k() {
        this.eventTimestamps[4] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void l() {
        this.eventTimestamps[1] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void m() {
        this.eventTimestamps[8] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void onDestroy() {
        this.listeners.clear();
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void onInit() {
        this.eventTimestamps[0] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void onPause() {
        this.eventTimestamps[20] = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b
    @NotNull
    public String p() {
        return "KRLaunchMonitor";
    }

    public final void q(@NotNull Function1<? super a, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    @Nullable
    public a s() {
        if (!r()) {
            return null;
        }
        return new a((Long[]) this.eventTimestamps.clone());
    }

    public final void t(@Nullable u createTrace) {
        w.f392617a.a("KRLaunchMonitor", "--onPageCreateFinish--");
        if (createTrace != null) {
            this.eventTimestamps[13] = Long.valueOf(createTrace.getCreateStartTimeMills());
            this.eventTimestamps[13] = Long.valueOf(createTrace.getBuildStartTimeMills());
            this.eventTimestamps[14] = Long.valueOf(createTrace.getBuildEndTimeMills());
            this.eventTimestamps[15] = Long.valueOf(createTrace.getLayoutStartTimeMills());
            this.eventTimestamps[16] = Long.valueOf(createTrace.getLayoutEndTimeMills());
            this.eventTimestamps[11] = Long.valueOf(createTrace.getNewPageStartTimeMills());
            this.eventTimestamps[12] = Long.valueOf(createTrace.getNewPageEndTimeMills());
            this.eventTimestamps[17] = Long.valueOf(createTrace.getCreateEndTimeMills());
        }
        u();
    }
}
