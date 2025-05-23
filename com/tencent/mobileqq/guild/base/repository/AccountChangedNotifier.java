package com.tencent.mobileqq.guild.base.repository;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R.\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00120\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/base/repository/AccountChangedNotifier;", "Lmqq/app/IAccountCallback;", "", "account", "", "c", "Lcom/tencent/mobileqq/guild/base/repository/a;", "aware", "a", "d", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "", "Lmqq/util/WeakReference;", "e", "Ljava/util/List;", "b", "()Ljava/util/List;", "setListeners", "(Ljava/util/List;)V", "listeners", "Landroid/content/BroadcastReceiver;", "f", "Landroid/content/BroadcastReceiver;", "getReceiver", "()Landroid/content/BroadcastReceiver;", "receiver", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AccountChangedNotifier implements IAccountCallback {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final AccountChangedNotifier f214789d = new AccountChangedNotifier();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static List<? extends WeakReference<a>> listeners;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final BroadcastReceiver receiver;

    static {
        List<? extends WeakReference<a>> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        listeners = emptyList;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                boolean z16;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    String account = extras.getString("account", "");
                    Intrinsics.checkNotNullExpressionValue(account, "account");
                    AccountChangedNotifier.c(account);
                    return;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        };
        receiver = broadcastReceiver;
        BaseApplication context = BaseApplication.getContext();
        if (context != null && context.getContentResolver() != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NewIntent.ACTION_LOGIN);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            MobileQQ.sMobileQQ.registerReceiver(broadcastReceiver, intentFilter, null, ThreadManagerV2.getUIHandlerV2());
        }
    }

    AccountChangedNotifier() {
    }

    @JvmStatic
    public static final void c(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        Logger.f235387a.d().i("AccountChangedNotifier", 1, "notifyAccountChange: will notify size=" + f214789d.b().size() + " listeners");
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                aVar.onAccountChanged(account);
            }
        }
    }

    public final synchronized void a(@NotNull a aware) {
        boolean z16;
        boolean z17;
        List<? extends WeakReference<a>> plus;
        boolean z18;
        Intrinsics.checkNotNullParameter(aware, "aware");
        List<? extends WeakReference<a>> list = listeners;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() == aware) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = false;
                    break;
                }
            }
        }
        z17 = true;
        if (z17) {
            List<? extends WeakReference<a>> list2 = listeners;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                if (((WeakReference) obj).get() != 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    arrayList.add(obj);
                }
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends WeakReference>) ((Collection<? extends Object>) arrayList), new WeakReference(aware));
            listeners = plus;
        }
    }

    @NotNull
    public final List<WeakReference<a>> b() {
        return listeners;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0014 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void d(@NotNull a aware) {
        boolean z16;
        Intrinsics.checkNotNullParameter(aware, "aware");
        List<? extends WeakReference<a>> list = listeners;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            WeakReference weakReference = (WeakReference) obj;
            if (weakReference.get() != aware && weakReference.get() != 0) {
                z16 = false;
                if (z16) {
                    arrayList.add(obj);
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        listeners = arrayList;
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
        Logger.f235387a.d().i("AccountChangedNotifier", 1, "onAccountChangeFailed: ... " + newRuntime);
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        String str;
        if (newRuntime != null) {
            str = newRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            str = TVKUpdateInfo.APP_ID;
        }
        c(str);
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason reason) {
        Logger.f235387a.d().i("AccountChangedNotifier", 1, "reason: ... " + reason);
    }
}
