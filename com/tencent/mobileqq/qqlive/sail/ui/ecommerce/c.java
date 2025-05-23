package com.tencent.mobileqq.qqlive.sail.ui.ecommerce;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.common.api.AegisLogger;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/c;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "", "roomId", "", "N1", "R1", "S1", "Ljava/util/concurrent/atomic/AtomicBoolean;", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRequesting", "Landroidx/lifecycle/MutableLiveData;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_bubbleText", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "bubbleTextLiveData", "Landroid/os/Handler;", "D", "Landroid/os/Handler;", "handler", "<init>", "()V", "E", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c extends com.tencent.mobileqq.qqlive.sail.base.d {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> bubbleTextLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Handler handler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isRequesting = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _bubbleText;

    public c() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._bubbleText = mutableLiveData;
        this.bubbleTextLiveData = mutableLiveData;
    }

    private final void N1(final long roomId) {
        if (roomId <= 0) {
            AegisLogger.INSTANCE.w("Audience|ECBubbleViewModel", "fetchBuyingBubbleInfo", "invalid roomId");
            return;
        }
        if (!this.isRequesting.compareAndSet(false, true)) {
            AegisLogger.INSTANCE.i("Audience|ECBubbleViewModel", "fetchBuyingBubbleInfo", "roomId=" + roomId + ", requesting");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("KEY_LIVE_ROOM_ID", roomId);
        cj4.c.f31003a.c("ACTION_REQUEST_LIVE_BUYING_BUBBLE_INFO", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.a
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                c.O1(c.this, roomId, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(final c this$0, final long j3, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = false;
        this$0.isRequesting.set(false);
        if (!eIPCResult.isSuccess()) {
            AegisLogger.INSTANCE.e("Audience|ECBubbleViewModel", "fetchBuyingBubbleInfo", "roomId=" + j3 + ", failed, errCode=" + eIPCResult.code);
            return;
        }
        Bundle bundle = eIPCResult.data;
        Unit unit = null;
        if (bundle != null) {
            String bubbleText = bundle.getString("KEY_LIVE_BUYING_BUBBLE_TEXT", "");
            long j16 = bundle.getLong("KEY_LIVE_BUYING_BUBBLE_REQUEST_INTERVALS", 0L);
            Intrinsics.checkNotNullExpressionValue(bubbleText, "bubbleText");
            if (bubbleText.length() > 0) {
                z16 = true;
            }
            if (z16) {
                this$0._bubbleText.postValue(bubbleText);
            }
            if (j16 > 0) {
                if (this$0.handler == null) {
                    this$0.handler = new Handler(Looper.getMainLooper());
                }
                Handler handler = this$0.handler;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                Handler handler2 = this$0.handler;
                if (handler2 != null) {
                    handler2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.P1(c.this, j3);
                        }
                    }, 1000 * j16);
                }
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("Audience|ECBubbleViewModel", "fetchBuyingBubbleInfo", "roomId=" + j3 + ", bubbleText=" + bubbleText + ", requestInterval=" + j16 + ReportConstant.COSTREPORT_PREFIX);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.i("Audience|ECBubbleViewModel", "fetchBuyingBubbleInfo", "roomId=" + j3 + ", empty data");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(c this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N1(j3);
    }

    @NotNull
    public final LiveData<String> Q1() {
        return this.bubbleTextLiveData;
    }

    public final void R1(long roomId) {
        N1(roomId);
    }

    public final void S1() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.handler = null;
    }
}
