package com.tencent.zplan.meme.encoder;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.ERROR_JS_CALLBACK_ACTION_FAIL;
import com.tencent.zplan.meme.action.ERROR_RECORD_FRAME_OOM;
import com.tencent.zplan.meme.action.RECORD_COMPLETE;
import com.tencent.zplan.meme.action.UNKNOWN;
import com.tencent.zplan.meme.encoder.MemeEncodeController;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MemeEncodeController$onPostWriteEncodeFile$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f385779d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Boolean f385780e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f385781f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f385782h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ IRecordOperator f385783i;
    final /* synthetic */ MemeEncodeController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemeEncodeController$onPostWriteEncodeFile$1(MemeEncodeController memeEncodeController, b bVar, Boolean bool, int i3, String str, IRecordOperator iRecordOperator) {
        this.this$0 = memeEncodeController;
        this.f385779d = bVar;
        this.f385780e = bool;
        this.f385781f = i3;
        this.f385782h = str;
        this.f385783i = iRecordOperator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        if (this.f385779d != null) {
            try {
                Runnable runnable = new Runnable() { // from class: com.tencent.zplan.meme.encoder.MemeEncodeController$onPostWriteEncodeFile$1$runnable$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ActionStatus actionStatus;
                        boolean z16;
                        ConcurrentHashMap concurrentHashMap;
                        String str3;
                        ConcurrentHashMap concurrentHashMap2;
                        String outputFilePath = MemeEncodeController$onPostWriteEncodeFile$1.this.f385779d.getOutputFilePath();
                        a encoder = MemeEncodeController$onPostWriteEncodeFile$1.this.f385779d.getEncoder();
                        if (Intrinsics.areEqual(MemeEncodeController$onPostWriteEncodeFile$1.this.f385780e, Boolean.TRUE)) {
                            MemeEncodeController$onPostWriteEncodeFile$1 memeEncodeController$onPostWriteEncodeFile$1 = MemeEncodeController$onPostWriteEncodeFile$1.this;
                            actionStatus = encoder.a(memeEncodeController$onPostWriteEncodeFile$1.f385781f, outputFilePath, memeEncodeController$onPostWriteEncodeFile$1.f385779d.getFrameTime());
                        } else {
                            actionStatus = ERROR_JS_CALLBACK_ACTION_FAIL.INSTANCE;
                        }
                        encoder.close();
                        if (Intrinsics.areEqual(actionStatus, RECORD_COMPLETE.INSTANCE) && com.tencent.zplan.common.utils.c.f385288a.h(outputFilePath)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        MemeEncodeController$onPostWriteEncodeFile$1.this.f385779d.m(actionStatus);
                        if (!z16) {
                            outputFilePath = null;
                        }
                        String str4 = outputFilePath;
                        List<String> frames = encoder.getFrames();
                        d a16 = LogUtil.f385285b.a();
                        if (a16 != null) {
                            str3 = MemeEncodeController$onPostWriteEncodeFile$1.this.this$0.TAG;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("onPostWriteEncodeFile key:");
                            sb5.append(MemeEncodeController$onPostWriteEncodeFile$1.this.f385779d.k());
                            sb5.append(", resMapKey:");
                            sb5.append(MemeEncodeController$onPostWriteEncodeFile$1.this.f385782h);
                            sb5.append(", success:");
                            sb5.append(z16);
                            sb5.append(", ");
                            sb5.append("status:");
                            sb5.append(MemeEncodeController$onPostWriteEncodeFile$1.this.f385779d.getStatus());
                            sb5.append(", resultPath:");
                            sb5.append(str4);
                            sb5.append(", frameCount:");
                            sb5.append(frames.size());
                            sb5.append(" encodeResCount:");
                            concurrentHashMap2 = MemeEncodeController$onPostWriteEncodeFile$1.this.this$0.encoderResMap;
                            sb5.append(concurrentHashMap2.size());
                            d.a.c(a16, str3, 1, sb5.toString(), null, 8, null);
                        }
                        MemeEncodeController$onPostWriteEncodeFile$1 memeEncodeController$onPostWriteEncodeFile$12 = MemeEncodeController$onPostWriteEncodeFile$1.this;
                        IRecordOperator iRecordOperator = memeEncodeController$onPostWriteEncodeFile$12.f385783i;
                        if (iRecordOperator != null) {
                            MemeEncodeController.INSTANCE.b(iRecordOperator, memeEncodeController$onPostWriteEncodeFile$12.f385779d, memeEncodeController$onPostWriteEncodeFile$12.f385781f, str4, frames);
                        }
                        concurrentHashMap = MemeEncodeController$onPostWriteEncodeFile$1.this.this$0.encoderResMap;
                        concurrentHashMap.remove(MemeEncodeController$onPostWriteEncodeFile$1.this.f385782h);
                    }
                };
                if (this.f385779d.getEncoder().c()) {
                    MemeEncodeController.Companion companion = MemeEncodeController.INSTANCE;
                    Executor a16 = companion.a();
                    if (a16 == null) {
                        this.f385779d.getEncoder().close();
                        this.f385779d.m(ERROR_RECORD_FRAME_OOM.INSTANCE);
                        IRecordOperator iRecordOperator = this.f385783i;
                        if (iRecordOperator != null) {
                            MemeEncodeController.Companion.c(companion, iRecordOperator, this.f385779d, this.f385781f, null, null, 12, null);
                            return;
                        }
                        return;
                    }
                    a16.execute(runnable);
                    return;
                }
                runnable.run();
            } catch (OutOfMemoryError e16) {
                d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    str2 = this.this$0.TAG;
                    a17.e(str2, 1, "onPostWriteEncodeFile OOM, key:" + this.f385779d.k() + ", resMapKey:" + this.f385782h, e16);
                }
                this.f385779d.m(ERROR_RECORD_FRAME_OOM.INSTANCE);
                this.f385779d.getStatistic().d(true);
                IRecordOperator iRecordOperator2 = this.f385783i;
                if (iRecordOperator2 != null) {
                    MemeEncodeController.Companion.c(MemeEncodeController.INSTANCE, iRecordOperator2, this.f385779d, this.f385781f, null, null, 12, null);
                }
            } catch (Throwable th5) {
                d a18 = LogUtil.f385285b.a();
                if (a18 != null) {
                    str = this.this$0.TAG;
                    a18.e(str, 1, "onPostWriteEncodeFile exception, key:" + this.f385779d.k() + ", resMapKey:" + this.f385782h, th5);
                }
                this.f385779d.m(UNKNOWN.INSTANCE);
                IRecordOperator iRecordOperator3 = this.f385783i;
                if (iRecordOperator3 != null) {
                    MemeEncodeController.Companion.c(MemeEncodeController.INSTANCE, iRecordOperator3, this.f385779d, this.f385781f, null, null, 12, null);
                }
            }
        }
    }
}
