package com.tencent.mobileqq.qmmkv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qmmkv.v2.MMKVMemoryCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010#\u001a\u00020!\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u001c\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\"R\u0014\u0010%\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVCacheReceiver;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "Landroid/content/BroadcastReceiver;", "", "uin", "uid", "", "b", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "count", "f", "Landroid/content/Intent;", "intent", "d", "e", tl.h.F, "", "c", "()[Ljava/lang/String;", "onApplicationForeground", "onApplicationBackground", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "Landroid/content/Context;", "context", "onReceive", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVMemoryCache;", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVMemoryCache;", "cache", "Ljava/lang/String;", "TAG", "<init>", "(Lcom/tencent/mobileqq/qmmkv/v2/MMKVMemoryCache;)V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MMKVCacheReceiver extends BroadcastReceiver implements IGuardInterface {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MMKVMemoryCache cache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    public MMKVCacheReceiver(@NotNull MMKVMemoryCache cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.cache = cache;
        this.TAG = "QMMKV_cache_MMKVCacheReceiver";
        h();
        cache.I();
    }

    private final void b(String uin, String uid) {
        File[] listFiles;
        boolean z16;
        File[] fileArr;
        String nameWithoutExtension;
        boolean endsWith$default;
        String substringBeforeLast$default;
        g gVar = g.f262011a;
        d a16 = gVar.a();
        Intrinsics.checkNotNull(a16);
        boolean z17 = false;
        if (!a16.a()) {
            f(false, 0, uin);
            QLog.d(this.TAG, 1, "deleteAccountRelatedMMKVFile switch off return.");
            return;
        }
        File file = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/mmkv");
        StringBuilder sb5 = new StringBuilder();
        List<String> c16 = gVar.a().c();
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            if (listFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int length = listFiles.length;
                int i3 = 0;
                int i16 = 0;
                while (i3 < length) {
                    File file2 = listFiles[i3];
                    if (file2.isDirectory()) {
                        fileArr = listFiles;
                    } else {
                        try {
                            Intrinsics.checkNotNullExpressionValue(file2, "file");
                            nameWithoutExtension = FilesKt__UtilsKt.getNameWithoutExtension(file2);
                            fileArr = listFiles;
                        } catch (Throwable th5) {
                            th = th5;
                            fileArr = listFiles;
                        }
                        try {
                            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(nameWithoutExtension, util.base64_pad_url + uid, z17, 2, null);
                            if (endsWith$default) {
                                if (!c16.isEmpty()) {
                                    substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(nameWithoutExtension, util.base64_pad_url + uid, (String) null, 2, (Object) null);
                                    if (!c16.contains(substringBeforeLast$default)) {
                                        String lowerCase = substringBeforeLast$default.toLowerCase();
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                                        if (!c16.contains(lowerCase)) {
                                            String upperCase = substringBeforeLast$default.toUpperCase();
                                            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
                                            if (c16.contains(upperCase)) {
                                            }
                                        }
                                    }
                                }
                                if (this.cache.h(nameWithoutExtension)) {
                                    QLog.w(this.TAG, 1, "deleteAccountRelatedMMKVFile [" + nameWithoutExtension + "] is in use, continue");
                                } else {
                                    file2.delete();
                                    i16++;
                                    sb5.append(file2.getName());
                                    sb5.append(",");
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            QLog.w(this.TAG, 1, "deleteAccountRelatedMMKVFile exception. " + th.getMessage(), th);
                            i3++;
                            listFiles = fileArr;
                            z17 = false;
                        }
                    }
                    i3++;
                    listFiles = fileArr;
                    z17 = false;
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                QLog.d(this.TAG, 1, "deleteAccountRelatedMMKVFile cost:" + (elapsedRealtime2 - elapsedRealtime) + " ms files: " + ((Object) sb5) + " blacklist:" + c16);
                f(true, i16, uin);
            }
        }
    }

    private final String[] c() {
        return new String[]{NewIntent.ACTION_ACCOUNT_KICKED, NewIntent.ACTION_ACCOUNT_CHANGED, NewIntent.ACTION_ACCOUNT_EXPIRED, NewIntent.ACTION_LOGOUT, NewIntent.ACTION_FORCE_LOGOUT, NewIntent.ACTION_LOGIN, "qmmkv.action.account_cleanup", "qmmkv.action.split_with_account"};
    }

    private final void d(Intent intent) {
        boolean z16;
        boolean z17 = true;
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra("uid");
        QLog.d(this.TAG, 1, "handleAccountCleanupEvent uin:" + stringExtra + " uid:" + stringExtra2);
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (stringExtra2 != null && stringExtra2.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                b(stringExtra, stringExtra2);
            }
        }
    }

    private final void e(Intent intent) {
        String stringExtra = intent.getStringExtra("mmapid");
        String stringExtra2 = intent.getStringExtra("uid");
        QLog.d(this.TAG, 1, "handleMMKVSplitWithAccountEvent mmapId:" + stringExtra + " uid:" + stringExtra2);
        this.cache.L(stringExtra);
    }

    private final void f(final boolean r26, final int count, final String uin) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.h
            @Override // java.lang.Runnable
            public final void run() {
                MMKVCacheReceiver.g(r26, count, uin);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(boolean z16, int i3, String uin) {
        String str;
        Intrinsics.checkNotNullParameter(uin, "$uin");
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, str);
        hashMap.put("count", String.valueOf(i3));
        hashMap.put("delAccount", uin);
        e a16 = k.f262017a.a();
        Intrinsics.checkNotNull(a16);
        a16.report("actMMKVDeleteReport", hashMap);
    }

    private final void h() {
        IntentFilter intentFilter = new IntentFilter();
        for (String str : c()) {
            intentFilter.addAction(str);
        }
        MobileQQ.sMobileQQ.registerReceiver(this, intentFilter);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        this.cache.H();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002c. Please report as an issue. */
    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String str;
        String action;
        String str2 = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onReceive action = ");
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        sb5.append(str);
        QLog.i(str2, 1, sb5.toString());
        if (intent != null && (action = intent.getAction()) != null) {
            switch (action.hashCode()) {
                case -1177559092:
                    if (!action.equals(NewIntent.ACTION_ACCOUNT_EXPIRED)) {
                        return;
                    }
                    this.cache.G();
                    return;
                case -1175284212:
                    if (action.equals("qmmkv.action.account_cleanup")) {
                        d(intent);
                        return;
                    }
                    return;
                case -573186114:
                    if (!action.equals(NewIntent.ACTION_ACCOUNT_KICKED)) {
                        return;
                    }
                    this.cache.G();
                    return;
                case 471887615:
                    if (action.equals("qmmkv.action.split_with_account")) {
                        e(intent);
                        return;
                    }
                    return;
                case 667652209:
                    if (!action.equals(NewIntent.ACTION_LOGOUT)) {
                        return;
                    }
                    this.cache.G();
                    return;
                case 870619995:
                    if (!action.equals(NewIntent.ACTION_ACCOUNT_CHANGED)) {
                        return;
                    }
                    this.cache.G();
                    return;
                case 1782925093:
                    if (!action.equals(NewIntent.ACTION_FORCE_LOGOUT)) {
                        return;
                    }
                    this.cache.G();
                    return;
                case 1822652290:
                    action.equals(NewIntent.ACTION_LOGIN);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean isEnabled) {
    }
}
