package fm0;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteEntry;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import fm0.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lfm0/i;", "", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lfm0/i$a;", "", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "weakContext", "Lcom/tencent/ad/tangram/protocol/gdt_analysis_event;", "event", "", "b", "", "REPORT_URL_DEFAULT", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fm0.i$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(WeakReference weakContext, String url, gdt_analysis_event event) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(weakContext, "$weakContext");
            Intrinsics.checkNotNullParameter(url, "$url");
            Intrinsics.checkNotNullParameter(event, "$event");
            AdAnalysis adAnalysis = AdAnalysis.getInstance();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new AdAnalysisSQLiteEntry(new AdAnalysisEvent(event, 103)));
            adAnalysis.send(weakContext, url, arrayListOf);
        }

        public final void b(@NotNull final WeakReference<Context> weakContext, @NotNull final gdt_analysis_event event) {
            Intrinsics.checkNotNullParameter(weakContext, "weakContext");
            Intrinsics.checkNotNullParameter(event, "event");
            try {
                final String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("gdtad_olympic_report_cost", "https://sdkreport.e.qq.com/qq_dp3");
                if (TextUtils.isEmpty(loadAsString)) {
                    GdtLog.i("GdtOlympicReportUtil", "[reportCost] switch close");
                    return;
                }
                GdtLog.i("GdtOlympicReportUtil", "[reportForCost]" + event.eventId);
                AdThreadManager.getInstance().post(new Runnable() { // from class: fm0.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.Companion.c(weakContext, loadAsString, event);
                    }
                }, 4);
            } catch (Throwable th5) {
                GdtLog.e("GdtOlympicReportUtil", "[reportForCost]", th5);
            }
        }

        Companion() {
        }
    }
}
