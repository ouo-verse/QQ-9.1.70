package com.tencent.mobileqq.nearbypro.map.part;

import android.app.Activity;
import android.view.View;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J/\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001c\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bRR\u0010!\u001a>\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u001dj\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/part/PreloadPart;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "", "K9", "Lcom/tencent/mobileqq/nearbypro/map/part/c;", DownloadInfo.spKey_Config, "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "J9", "(Lcom/tencent/mobileqq/nearbypro/map/part/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "H9", "", "inflateId", "I9", "", "action", "", "args", "handleBroadcastMessage", "getMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "f", "Z", "hasInit", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", tl.h.F, "Ljava/util/HashMap;", "markerCacheViewMap", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "i", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "preloadJob", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class PreloadPart extends com.tencent.mobileqq.nearbypro.part.e {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasInit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Integer, ArrayList<View>> markerCacheViewMap = new HashMap<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b preloadJob;

    /* JADX INFO: Access modifiers changed from: private */
    public final List<InflateConfig> H9() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InflateConfig(R.layout.fnc, 10, GdtGetUserInfoHandler.KEY_AREA));
        arrayList.add(new InflateConfig(R.layout.fnl, 15, "person"));
        arrayList.add(new InflateConfig(R.layout.fnp, 50, "pic_status"));
        arrayList.add(new InflateConfig(R.layout.fnt, 50, "no_pic_status"));
        arrayList.add(new InflateConfig(R.layout.fnk, 15, "person_group"));
        arrayList.add(new InflateConfig(R.layout.fns, 15, "status_group"));
        return arrayList;
    }

    private final View I9(int inflateId) {
        ArrayList<View> arrayList = this.markerCacheViewMap.get(Integer.valueOf(inflateId));
        if (arrayList != null && (!arrayList.isEmpty())) {
            return arrayList.remove(0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object J9(InflateConfig inflateConfig, Continuation<? super ArrayList<View>> continuation) {
        Deferred o16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.a c16 = CorountineFunKt.c(fa2.a.a(), "CreateMarkerView", null, null, new PreloadPart$onCreateMarkerView$2(inflateConfig, this, null), 6, null);
        if (c16 == null || (o16 = c16.o()) == null) {
            return null;
        }
        return o16.await(continuation);
    }

    private final void K9() {
        if (!this.hasInit) {
            this.hasInit = true;
            this.preloadJob = CorountineFunKt.e(fa2.a.b(), "PreloadMarkerView", null, null, Boolean.TRUE, new PreloadPart$preloadMarkerView$1(this, null), 6, null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "msg_get_preload_marker_view")) {
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type kotlin.Int");
            return I9(((Integer) args).intValue());
        }
        return super.getMessage(action, args);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "has_location_permission")) {
            ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type kotlin.Boolean");
            Boolean bool = (Boolean) args;
            c16.e("NBP.PreloadPart", "permission change hasPermission:" + bool);
            if (bool.booleanValue()) {
                K9();
            }
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Job f16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.preloadJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
    }
}
