package com.tencent.square.debugger;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.zplan.cloud.record.api.Priority;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import dx4.CloudActionResult;
import dx4.CloudFailedResult;
import dx4.CloudForecastResult;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class DemoRecordMp4Fragment$doCloudRecord$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WeakReference $contextRef;
    final /* synthetic */ MemeZPlanAction $memeZPlanAction;
    final /* synthetic */ DemoRecordMp4Fragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J&\u0010\r\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/square/debugger/DemoRecordMp4Fragment$doCloudRecord$2$1", "Lcom/tencent/zplan/cloud/record/api/b;", "", "Ldx4/c;", "cloudForecastResultList", "", "b", "Ldx4/b;", "cloudFailedResultList", "", "errorCode", "", "errorMessage", "a", "", "isCloudCache", "Ldx4/a;", "userRecordTaskList", "c", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.square.debugger.DemoRecordMp4Fragment$doCloudRecord$2$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 implements com.tencent.zplan.cloud.record.api.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f373509b;

        AnonymousClass1(ViewGroup viewGroup) {
            this.f373509b = viewGroup;
        }

        @Override // com.tencent.zplan.cloud.record.api.b
        public void a(List<CloudFailedResult> cloudFailedResultList, int errorCode, String errorMessage) {
            Intrinsics.checkNotNullParameter(cloudFailedResultList, "cloudFailedResultList");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            Log.d("DemoRecordMp4Fragment", "record cloud failed " + errorCode + ", " + errorMessage);
            Iterator<T> it = cloudFailedResultList.iterator();
            while (it.hasNext()) {
                Log.d("DemoRecordMp4Fragment", "record cloud failed result:" + ((CloudFailedResult) it.next()));
            }
            SquareBaseKt.getSquareCommon().showToastSafely((Context) DemoRecordMp4Fragment$doCloudRecord$2.this.$contextRef.get(), "\u4e91\u5f55\u5236\u5931\u8d25 " + errorCode + ':' + errorMessage, 0);
        }

        @Override // com.tencent.zplan.cloud.record.api.b
        public void b(List<CloudForecastResult> cloudForecastResultList) {
            Intrinsics.checkNotNullParameter(cloudForecastResultList, "cloudForecastResultList");
            SquareBaseKt.getSquareCommon().showToastSafely((Context) DemoRecordMp4Fragment$doCloudRecord$2.this.$contextRef.get(), "\u7b49\u5f85\u5f55\u5236...", 0);
        }

        @Override // com.tencent.zplan.cloud.record.api.b
        public void c(boolean isCloudCache, List<CloudActionResult> userRecordTaskList) {
            Object first;
            final ViewGroup Qh;
            File externalCacheDir;
            Intrinsics.checkNotNullParameter(userRecordTaskList, "userRecordTaskList");
            SquareBaseKt.getSquareCommon().showToastSafely((Context) DemoRecordMp4Fragment$doCloudRecord$2.this.$contextRef.get(), "\u5f55\u5236\u6210\u529f", 0);
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) userRecordTaskList);
            final CloudActionResult cloudActionResult = (CloudActionResult) first;
            Log.d("DemoRecordMp4Fragment", "record cloud success " + cloudActionResult.getActionId() + MsgSummary.STR_COLON + cloudActionResult.getUrl());
            StringBuilder sb5 = new StringBuilder();
            Context context = (Context) DemoRecordMp4Fragment$doCloudRecord$2.this.$contextRef.get();
            sb5.append((context == null || (externalCacheDir = context.getExternalCacheDir()) == null) ? null : externalCacheDir.getAbsolutePath());
            sb5.append('/');
            sb5.append(cloudActionResult.getTaskId());
            Qh = DemoRecordMp4Fragment$doCloudRecord$2.this.this$0.Qh(cloudActionResult.getUrl(), sb5.toString(), DemoRecordMp4Fragment$doCloudRecord$2.this.this$0.width, DemoRecordMp4Fragment$doCloudRecord$2.this.this$0.height, this.f373509b);
            b.f373562c.c(new Function0<Unit>() { // from class: com.tencent.square.debugger.DemoRecordMp4Fragment$doCloudRecord$2$1$onActionSuccess$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DemoRecordMp4Fragment$doCloudRecord$2.this.this$0.Ph(cloudActionResult.getUrl(), Qh);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DemoRecordMp4Fragment$doCloudRecord$2(DemoRecordMp4Fragment demoRecordMp4Fragment, MemeZPlanAction memeZPlanAction, WeakReference weakReference) {
        super(0);
        this.this$0 = demoRecordMp4Fragment;
        this.$memeZPlanAction = memeZPlanAction;
        this.$contextRef = weakReference;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ViewGroup gi5;
        com.tencent.zplan.cloud.record.api.a aVar;
        gi5 = this.this$0.gi(this.$memeZPlanAction);
        aVar = this.this$0.cloudApi;
        if (aVar != null) {
            aVar.a(this.$memeZPlanAction, new gx4.a(), Integer.MAX_VALUE, 5, Priority.IMMEDIATE, new AnonymousClass1(gi5));
        }
    }
}
