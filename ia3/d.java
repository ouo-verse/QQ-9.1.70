package ia3;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.debug.panel.WinkNewAlbumDebugPanelFragment;
import com.tencent.mobileqq.wink.newalbum.debug.panel.WinkNewAlbumDebugPanelViewModel;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.WinkMemoryAlbumClickDelegator;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.WinkNewAlbumClickDelegator;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.peak.PeakConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BX\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013\u0012#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00040\u0018\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R2\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00040\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010'\u001a\u0004\u0018\u00010\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lia3/d;", "Lia3/b;", "Ls53/a;", "data", "", "a", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "c", "b", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "getNextStepHelper", "()Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnBeforeLoad", "()Lkotlin/jvm/functions/Function0;", "onBeforeLoad", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "d", "Lkotlin/jvm/functions/Function1;", "getOnAfterLoad", "()Lkotlin/jvm/functions/Function1;", "onAfterLoad", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/a;", "e", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/a;", "getReportHelper", "()Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/a;", "reportHelper", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/a;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkMediaPickerNextStepHelper nextStepHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> onBeforeLoad;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Boolean, Unit> onAfterLoad;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper.a reportHelper;

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull Activity activity, @NotNull WinkMediaPickerNextStepHelper nextStepHelper, @NotNull Function0<Unit> onBeforeLoad, @NotNull Function1<? super Boolean, Unit> onAfterLoad, @Nullable com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper.a aVar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(nextStepHelper, "nextStepHelper");
        Intrinsics.checkNotNullParameter(onBeforeLoad, "onBeforeLoad");
        Intrinsics.checkNotNullParameter(onAfterLoad, "onAfterLoad");
        this.activity = activity;
        this.nextStepHelper = nextStepHelper;
        this.onBeforeLoad = onBeforeLoad;
        this.onAfterLoad = onAfterLoad;
        this.reportHelper = aVar;
    }

    @Override // ia3.b
    public void a(@NotNull s53.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        new WinkMemoryAlbumClickDelegator(this.activity, this.nextStepHelper, this.onBeforeLoad, this.onAfterLoad).s(data);
        com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper.a aVar = this.reportHelper;
        if (aVar != null) {
            aVar.d(data);
        }
    }

    @Override // ia3.b
    public void b(@NotNull WinkNewMemoryAlbumResult data) {
        Intrinsics.checkNotNullParameter(data, "data");
        WinkNewAlbumDebugPanelViewModel c16 = u83.a.INSTANCE.c(data);
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(this.activity, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", WinkNewAlbumDebugPanelFragment.class.getName());
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, this.activity.getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID));
        intent.putExtra("result", c16);
        this.activity.startActivity(intent);
    }

    @Override // ia3.b
    public void c(@NotNull WinkNewMemoryAlbumResult data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (w83.b.f445025a.N()) {
            new WinkNewAlbumClickDelegator(this.activity, this.nextStepHelper, this.onBeforeLoad, this.onAfterLoad).t(data);
        } else {
            new WinkNewAlbumClickDelegator(this.activity, this.nextStepHelper, this.onBeforeLoad, this.onAfterLoad).s(data);
        }
        com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper.a aVar = this.reportHelper;
        if (aVar != null) {
            aVar.e(data);
        }
    }
}
