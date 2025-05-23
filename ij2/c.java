package ij2;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqshop.message.db.f;
import com.tencent.mobileqq.qqshop.report.dev.KuiklyLaunchAction;
import com.tencent.mobileqq.qqshop.report.dev.KuiklyLaunchData;
import com.tencent.qphone.base.util.QLog;
import i01.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0016\u0010\u0016\u001a\u00020\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0018\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0017j\b\u0012\u0004\u0012\u00020\u0012`\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0012\u0010\u001c\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006\""}, d2 = {"Lij2/c;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "g", "", "msgTime", "", "msgCount", "", "Lcom/tencent/mobileqq/qqshop/message/db/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, TabPreloadItem.TAB_NAME_MESSAGE, "Lorg/json/JSONArray;", "p", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "l", "", "o", "d", "method", "call", "<init>", "()V", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c extends e {
    private final void d(String params) {
        if (params == null) {
            QLog.e("QQShopMsgModule", 1, "deleteAd params is null");
            return;
        }
        try {
            com.tencent.mobileqq.qqshop.publicaccount.c.f274574a.a(new JSONObject(params).optLong("msgID"));
        } catch (JSONException e16) {
            QLog.e("QQShopMsgModule", 1, "deleteAd params is error", e16);
        }
    }

    private final void g(String params, final Function1<Object, Unit> callback) {
        final int coerceAtLeast;
        KuiklyLaunchData kuiklyLaunchData;
        if (params == null) {
            QLog.e("QQShopMsgModule", 1, "fetchMsg params is null");
            if (callback != null) {
                callback.invoke(new JSONObject());
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            final long optLong = jSONObject.optLong("msgTime");
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(jSONObject.optInt("msgCount"), 5);
            final long uptimeMillis = SystemClock.uptimeMillis();
            WeakReference<KuiklyLaunchData> b16 = com.tencent.mobileqq.qqshop.report.dev.b.f274713a.b();
            if (b16 != null && (kuiklyLaunchData = b16.get()) != null) {
                KuiklyLaunchData.addNativeAction$default(kuiklyLaunchData, KuiklyLaunchAction.FETCH_MSG_START, 0L, 2, null);
            }
            QLog.d("QQShopMsgModule", 1, "fetchMsg isMainThread: " + o());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final Runnable runnable = new Runnable() { // from class: ij2.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.i(atomicBoolean, this, uptimeMillis, callback);
                }
            };
            ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 1000L);
            ThreadManagerV2.excute(new Runnable() { // from class: ij2.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.j(c.this, optLong, coerceAtLeast, atomicBoolean, runnable, callback, uptimeMillis);
                }
            }, 32, null, true);
        } catch (JSONException e16) {
            QLog.e("QQShopMsgModule", 1, "fetchMsg params is error", e16);
            if (callback != null) {
                callback.invoke(new JSONObject());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AtomicBoolean isCallbacked, c this$0, long j3, Function1 function1) {
        Intrinsics.checkNotNullParameter(isCallbacked, "$isCallbacked");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!isCallbacked.compareAndSet(false, true)) {
            QLog.d("QQShopMsgModule", 1, "fetchMsg callback is callbacked");
            return;
        }
        JSONArray p16 = this$0.p(this$0.l());
        long uptimeMillis = SystemClock.uptimeMillis();
        QLog.d("QQShopMsgModule", 1, "fetchMsg timeout msgSize = " + p16.length() + ", time = " + (uptimeMillis - j3));
        String jSONObject = new JSONObject().put("msgs", p16).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().put(\"msgs\",\u2026sgContentList).toString()");
        if (function1 != null) {
            function1.invoke(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(c this$0, long j3, int i3, AtomicBoolean isCallbacked, Runnable timeoutRunnable, Function1 function1, long j16) {
        KuiklyLaunchData kuiklyLaunchData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(isCallbacked, "$isCallbacked");
        Intrinsics.checkNotNullParameter(timeoutRunnable, "$timeoutRunnable");
        long uptimeMillis = SystemClock.uptimeMillis();
        List<com.tencent.mobileqq.qqshop.message.db.a> m3 = this$0.m(j3, i3);
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (!isCallbacked.compareAndSet(false, true)) {
            QLog.d("QQShopMsgModule", 1, "fetchMsg callback timeout");
            return;
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(timeoutRunnable);
        JSONArray p16 = this$0.p(m3);
        String jSONObject = new JSONObject().put("msgs", p16).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().put(\"msgs\",\u2026sgContentList).toString()");
        long uptimeMillis3 = SystemClock.uptimeMillis();
        WeakReference<KuiklyLaunchData> b16 = com.tencent.mobileqq.qqshop.report.dev.b.f274713a.b();
        if (b16 != null && (kuiklyLaunchData = b16.get()) != null) {
            KuiklyLaunchData.addNativeAction$default(kuiklyLaunchData, KuiklyLaunchAction.FETCH_MSG_END, 0L, 2, null);
        }
        if (function1 != null) {
            function1.invoke(jSONObject);
        }
        QLog.d("QQShopMsgModule", 1, "fetchMsg callback msgSize = " + p16.length() + ", GetMsgTime = " + (uptimeMillis2 - uptimeMillis) + ", allTime=" + (uptimeMillis3 - j16));
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0021, code lost:
    
        r0 = kotlin.collections.CollectionsKt__CollectionsKt.arrayListOf(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ArrayList<com.tencent.mobileqq.qqshop.message.db.a> l() {
        ArrayList<com.tencent.mobileqq.qqshop.message.db.a> arrayListOf;
        com.tencent.mobileqq.qqshop.message.db.a i3 = com.tencent.mobileqq.qqshop.message.a.f274473a.i();
        QLog.d("QQShopMsgModule", 1, "getCacheMsgList lastMsg = " + i3);
        if (i3 == null || arrayListOf == null) {
            return new ArrayList<>();
        }
        return arrayListOf;
    }

    private final List<com.tencent.mobileqq.qqshop.message.db.a> m(long msgTime, int msgCount) {
        try {
            List<com.tencent.mobileqq.qqshop.message.db.a> d16 = f.f274497a.d(msgTime, msgCount);
            QLog.d("QQShopMsgModule", 1, "dbMsgList.size = " + d16.size());
            List<com.tencent.mobileqq.qqshop.message.db.a> list = d16;
            if (list.isEmpty()) {
                list = l();
            }
            return list;
        } catch (Throwable th5) {
            QLog.e("QQShopMsgModule", 1, th5, new Object[0]);
            return l();
        }
    }

    private final boolean o() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    private final JSONArray p(List<com.tencent.mobileqq.qqshop.message.db.a> msgList) {
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mobileqq.qqshop.message.db.a aVar : msgList) {
            try {
                JSONObject jSONObject = new JSONObject(aVar.a());
                jSONObject.put("isADDeleted", com.tencent.mobileqq.qqshop.publicaccount.c.f274574a.c(aVar.b()));
                jSONObject.put("msgID", aVar.b());
                jSONObject.put("msgTime", aVar.c());
                jSONArray.mo162put(jSONObject);
            } catch (JSONException e16) {
                QLog.d("QQShopMsgModule", 1, e16, new Object[0]);
            }
        }
        return jSONArray;
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "fetchMsg")) {
            g(params, callback);
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(method, "deleteAD")) {
            d(params);
            return Unit.INSTANCE;
        }
        QLog.e("QQShopMsgModule", 1, "unknown method: " + method);
        return super.call(method, params, callback);
    }
}
