package com.tencent.mobileqq.mini.entry.search.ui;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J*\u0010\u0016\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0006\u0010\u001c\u001a\u00020\u0013J*\u0010\u001d\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00050\u00050\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/ui/DebounceTextWatcher;", "Landroid/text/TextWatcher;", "delayMillis", "", "listener", "Lcom/tencent/mobileqq/mini/entry/search/ui/TextChangeListener;", "(JLcom/tencent/mobileqq/mini/entry/search/ui/TextChangeListener;)V", "debounceRunnable", "Lcom/tencent/mobileqq/mini/entry/search/ui/DebounceTextWatcher$DebounceRunnable;", "handler", "Landroid/os/Handler;", "lastText", "", WadlProxyConsts.LAST_UPDATE_TIME, "listenerRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "pendingText", "afterTextChanged", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "dispose", "onTextChanged", "before", "DebounceRunnable", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class DebounceTextWatcher implements TextWatcher {
    private final DebounceRunnable debounceRunnable;
    private final long delayMillis;
    private final Handler handler;
    private volatile String lastText;
    private volatile long lastUpdateTime;
    private final WeakReference<TextChangeListener> listenerRef;
    private volatile String pendingText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/ui/DebounceTextWatcher$DebounceRunnable;", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/mini/entry/search/ui/DebounceTextWatcher;)V", TencentLocation.RUN_MODE, "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    private final class DebounceRunnable implements Runnable {
        public DebounceRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = DebounceTextWatcher.this.pendingText;
            if (Intrinsics.areEqual(str, DebounceTextWatcher.this.lastText)) {
                return;
            }
            DebounceTextWatcher.this.lastText = str;
            TextChangeListener textChangeListener = (TextChangeListener) DebounceTextWatcher.this.listenerRef.get();
            if (textChangeListener != null) {
                textChangeListener.onDebouncedTextChanged(str);
            }
        }
    }

    public DebounceTextWatcher(long j3, TextChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.delayMillis = j3;
        this.handler = new Handler(Looper.getMainLooper());
        this.listenerRef = new WeakReference<>(listener);
        this.debounceRunnable = new DebounceRunnable();
    }

    public final void dispose() {
        this.handler.removeCallbacks(this.debounceRunnable);
        this.listenerRef.clear();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s16) {
        String obj = s16 != null ? s16.toString() : null;
        long currentTimeMillis = System.currentTimeMillis();
        if (Intrinsics.areEqual(obj, this.lastText)) {
            return;
        }
        this.pendingText = obj;
        long max = Math.max(this.delayMillis - (currentTimeMillis - this.lastUpdateTime), 0L);
        this.handler.removeCallbacks(this.debounceRunnable);
        this.handler.postDelayed(this.debounceRunnable, max);
        this.lastUpdateTime = currentTimeMillis;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s16, int start, int before, int count) {
    }
}
