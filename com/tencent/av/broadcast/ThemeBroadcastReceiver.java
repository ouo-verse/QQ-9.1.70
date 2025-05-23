package com.tencent.av.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0002\t\u0011B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/av/broadcast/ThemeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/tencent/av/broadcast/ThemeBroadcastReceiver$b;", "a", "Lcom/tencent/av/broadcast/ThemeBroadcastReceiver$b;", "getCallback", "()Lcom/tencent/av/broadcast/ThemeBroadcastReceiver$b;", IECSearchBar.METHOD_SET_CALLBACK, "(Lcom/tencent/av/broadcast/ThemeBroadcastReceiver$b;)V", "callback", "<init>", "b", "qqrtc_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ThemeBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private b callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/av/broadcast/ThemeBroadcastReceiver$b;", "", "", "onPostThemeChanged", "qqrtc_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface b {
        void onPostThemeChanged();
    }

    public ThemeBroadcastReceiver(b bVar) {
        this.callback = bVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("ThemeBroadcastReceiver", 1, "ThemeBroadcastReceiver on theme changed");
        }
        b bVar = this.callback;
        if (bVar != null) {
            bVar.onPostThemeChanged();
        }
    }
}
