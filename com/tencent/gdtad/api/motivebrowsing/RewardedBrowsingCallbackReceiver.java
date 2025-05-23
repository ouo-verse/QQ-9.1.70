package com.tencent.gdtad.api.motivebrowsing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.bf;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\nB\u001f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/gdtad/api/motivebrowsing/RewardedBrowsingCallbackReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lmqq/util/WeakReference;", "Lcom/tencent/qqmini/proxyimpl/bf;", "a", "Lmqq/util/WeakReference;", "mPlugin", "Lcom/tencent/qqmini/proxyimpl/AdProxyImpl;", "b", "mProxy", "plugin", "proxy", "<init>", "(Lcom/tencent/qqmini/proxyimpl/bf;Lcom/tencent/qqmini/proxyimpl/AdProxyImpl;)V", "c", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes31.dex */
public final class RewardedBrowsingCallbackReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<bf> mPlugin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<AdProxyImpl> mProxy;

    public RewardedBrowsingCallbackReceiver() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AdProxyImpl adProxyImpl;
        if (QLog.isColorLevel()) {
            QLog.d("RewardedBrowsingCallbackReceiver", 2, "RewardedBrowsingCallbackReceiver onReceive");
        }
        if (intent == null || !TextUtils.equals(intent.getAction(), "AD_PROXY_ACTION_MOTIVE_BROWSING_END") || (adProxyImpl = this.mProxy.get()) == null) {
            return;
        }
        adProxyImpl.r(intent);
    }

    public RewardedBrowsingCallbackReceiver(bf bfVar, AdProxyImpl adProxyImpl) {
        this.mPlugin = new WeakReference<>(bfVar);
        this.mProxy = new WeakReference<>(adProxyImpl);
    }

    public /* synthetic */ RewardedBrowsingCallbackReceiver(bf bfVar, AdProxyImpl adProxyImpl, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bfVar, (i3 & 2) != 0 ? null : adProxyImpl);
    }
}
