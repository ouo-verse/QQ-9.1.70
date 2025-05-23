package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b&\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\fH\u0082\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0017\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0082\bJ\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\f2\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0011H&J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H&J\u001e\u0010 \u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vas/BaseConfigProxy;", "Lcom/tencent/mobileqq/vas/IConfigProxy;", "name", "", "backupToMMKV", "", "(Ljava/lang/String;Z)V", "isLogEnable", "isLogJson", "getName", "()Ljava/lang/String;", "checkRefresh", "", "getInt", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getJson", "Lorg/json/JSONObject;", "getStringData", "getStringDataSet", "key", "ifNoAppRuntime", "block", "Lkotlin/Function0;", "isEnable", "logConfig", "", "logEnable", "it", "onGetInt", "onGetJson", "onGetStringData", "onGetStringDataSet", "onIsEnable", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public abstract class BaseConfigProxy implements IConfigProxy {

    @NotNull
    public static final String TAG = "AbsConfigProxy";

    @Nullable
    private static String noAppRuntimeKey;
    private final boolean backupToMMKV;
    private boolean isLogEnable;
    private boolean isLogJson;

    @NotNull
    private final String name;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final AtomicBoolean needRefresh = new AtomicBoolean(true);

    @NotNull
    private static final ConcurrentHashMap<String, Function0<Unit>> refreshDataTasks = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR#\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vas/BaseConfigProxy$Companion;", "", "()V", "TAG", "", "needRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getNeedRefresh", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "noAppRuntimeKey", "getNoAppRuntimeKey", "()Ljava/lang/String;", "setNoAppRuntimeKey", "(Ljava/lang/String;)V", "refreshDataTasks", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function0;", "", "getRefreshDataTasks", "()Ljava/util/concurrent/ConcurrentHashMap;", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AtomicBoolean getNeedRefresh() {
            return BaseConfigProxy.needRefresh;
        }

        @Nullable
        public final String getNoAppRuntimeKey() {
            return BaseConfigProxy.noAppRuntimeKey;
        }

        @NotNull
        public final ConcurrentHashMap<String, Function0<Unit>> getRefreshDataTasks() {
            return BaseConfigProxy.refreshDataTasks;
        }

        public final void setNoAppRuntimeKey(@Nullable String str) {
            BaseConfigProxy.noAppRuntimeKey = str;
        }

        Companion() {
        }
    }

    public BaseConfigProxy(@NotNull String name, boolean z16) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.backupToMMKV = z16;
    }

    private final void checkRefresh() {
        Companion companion = INSTANCE;
        if (companion.getNeedRefresh().get() && MobileQQ.sMobileQQ.peekAppRuntime() != null && companion.getNeedRefresh().compareAndSet(true, false)) {
            QLog.e(TAG, 1, "refresh MMKV data");
            ThreadManagerV2.excute(BaseConfigProxy$checkRefresh$1.f307820d, 16, null, false);
        }
    }

    private final void ifNoAppRuntime(Function0<Unit> block) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            Companion companion = INSTANCE;
            if (TextUtils.isEmpty(companion.getNoAppRuntimeKey())) {
                QLog.e(TAG, 1, "runtime is null");
            }
            String noAppRuntimeKey2 = companion.getNoAppRuntimeKey();
            if (noAppRuntimeKey2 == null) {
                noAppRuntimeKey2 = "";
            }
            companion.setNoAppRuntimeKey(noAppRuntimeKey2 + this.name + ",");
            block.invoke();
            return;
        }
        Companion companion2 = INSTANCE;
        if (!TextUtils.isEmpty(companion2.getNoAppRuntimeKey())) {
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                QLog.e(TAG, 1, "runtime is not null, nameList: " + companion2.getNoAppRuntimeKey());
            }
            companion2.setNoAppRuntimeKey(null);
        }
    }

    private final void logConfig(final Function0<? extends Object> block) {
        if (this.isLogJson) {
            return;
        }
        this.isLogJson = true;
        y13.d.a(1000L, new Runnable() { // from class: com.tencent.mobileqq.vas.c
            @Override // java.lang.Runnable
            public final void run() {
                BaseConfigProxy.logConfig$lambda$12(BaseConfigProxy.this, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logConfig$lambda$12(BaseConfigProxy this$0, Function0 block) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(block, "$block");
        QLog.i(TAG, 1, "name: " + this$0.name + " config: " + block.invoke());
    }

    private final void logEnable(boolean it) {
        if (!this.isLogEnable && QLog.isColorLevel()) {
            this.isLogEnable = true;
            QLog.i(TAG, 1, "name: " + this.name + " enable: " + it);
        }
    }

    @Override // com.tencent.mobileqq.vas.IConfigProxy
    public int getInt(final int defaultValue) {
        Companion companion = INSTANCE;
        if (companion.getNeedRefresh().get() && MobileQQ.sMobileQQ.peekAppRuntime() != null && companion.getNeedRefresh().compareAndSet(true, false)) {
            QLog.e(TAG, 1, "refresh MMKV data");
            ThreadManagerV2.excute(BaseConfigProxy$checkRefresh$1.f307820d, 16, null, false);
        }
        if (QLog.isDebugVersion()) {
            logConfig(new Function0<Object>() { // from class: com.tencent.mobileqq.vas.BaseConfigProxy$getInt$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Object invoke() {
                    return Integer.valueOf(BaseConfigProxy.this.getInt(defaultValue));
                }
            });
        }
        if (this.backupToMMKV) {
            String str = this.name + "_int";
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                if (TextUtils.isEmpty(companion.getNoAppRuntimeKey())) {
                    QLog.e(TAG, 1, "runtime is null");
                }
                String noAppRuntimeKey2 = companion.getNoAppRuntimeKey();
                if (noAppRuntimeKey2 == null) {
                    noAppRuntimeKey2 = "";
                }
                companion.setNoAppRuntimeKey(noAppRuntimeKey2 + this.name + ",");
                refreshDataTasks.put(str, new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.BaseConfigProxy$getInt$2$1
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
                        BaseConfigProxy.this.getInt(defaultValue);
                    }
                });
                return VipNtMMKV.INSTANCE.getConfigBackup().decodeInt(str, defaultValue);
            }
            if (!TextUtils.isEmpty(companion.getNoAppRuntimeKey())) {
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    QLog.e(TAG, 1, "runtime is not null, nameList: " + companion.getNoAppRuntimeKey());
                }
                companion.setNoAppRuntimeKey(null);
            }
            int onGetInt = onGetInt(defaultValue);
            VipNtMMKV.INSTANCE.getConfigBackup().encodeInt(str, onGetInt);
            return onGetInt;
        }
        return onGetInt(defaultValue);
    }

    @Override // com.tencent.mobileqq.vas.IConfigProxy
    @NotNull
    public JSONObject getJson() {
        Companion companion = INSTANCE;
        boolean z16 = false;
        if (companion.getNeedRefresh().get() && MobileQQ.sMobileQQ.peekAppRuntime() != null && companion.getNeedRefresh().compareAndSet(true, false)) {
            QLog.e(TAG, 1, "refresh MMKV data");
            ThreadManagerV2.excute(BaseConfigProxy$checkRefresh$1.f307820d, 16, null, false);
        }
        if (QLog.isDebugVersion()) {
            logConfig(new Function0<Object>() { // from class: com.tencent.mobileqq.vas.BaseConfigProxy$getJson$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Object invoke() {
                    return BaseConfigProxy.this.getJson();
                }
            });
        }
        if (this.backupToMMKV) {
            String str = this.name + "_json";
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                if (TextUtils.isEmpty(companion.getNoAppRuntimeKey())) {
                    QLog.e(TAG, 1, "runtime is null");
                }
                String noAppRuntimeKey2 = companion.getNoAppRuntimeKey();
                if (noAppRuntimeKey2 == null) {
                    noAppRuntimeKey2 = "";
                }
                companion.setNoAppRuntimeKey(noAppRuntimeKey2 + this.name + ",");
                refreshDataTasks.put(str, new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.BaseConfigProxy$getJson$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        BaseConfigProxy.this.getJson();
                    }
                });
                String decodeString = VipNtMMKV.INSTANCE.getConfigBackup().decodeString(str, "");
                if (decodeString == null || decodeString.length() == 0) {
                    z16 = true;
                }
                if (z16) {
                    return new JSONObject();
                }
                try {
                    return new JSONObject(decodeString);
                } catch (Exception unused) {
                    return new JSONObject();
                }
            }
            if (!TextUtils.isEmpty(companion.getNoAppRuntimeKey())) {
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    QLog.e(TAG, 1, "runtime is not null, nameList: " + companion.getNoAppRuntimeKey());
                }
                companion.setNoAppRuntimeKey(null);
            }
            JSONObject onGetJson = onGetJson();
            if (onGetJson == null) {
                VipNtMMKV.INSTANCE.getConfigBackup().removeKey(str);
            } else {
                VipNtMMKV.INSTANCE.getConfigBackup().encodeString(str, onGetJson.toString());
            }
            if (onGetJson == null) {
                return new JSONObject();
            }
            return onGetJson;
        }
        JSONObject onGetJson2 = onGetJson();
        if (onGetJson2 == null) {
            return new JSONObject();
        }
        return onGetJson2;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Override // com.tencent.mobileqq.vas.IConfigProxy
    @NotNull
    public String getStringData(@NotNull final String defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Companion companion = INSTANCE;
        if (companion.getNeedRefresh().get() && MobileQQ.sMobileQQ.peekAppRuntime() != null && companion.getNeedRefresh().compareAndSet(true, false)) {
            QLog.e(TAG, 1, "refresh MMKV data");
            ThreadManagerV2.excute(BaseConfigProxy$checkRefresh$1.f307820d, 16, null, false);
        }
        if (QLog.isDebugVersion()) {
            logConfig(new Function0<Object>() { // from class: com.tencent.mobileqq.vas.BaseConfigProxy$getStringData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Object invoke() {
                    return BaseConfigProxy.this.getStringData(defaultValue);
                }
            });
        }
        if (this.backupToMMKV) {
            String str = this.name + "_string";
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                if (TextUtils.isEmpty(companion.getNoAppRuntimeKey())) {
                    QLog.e(TAG, 1, "runtime is null");
                }
                String noAppRuntimeKey2 = companion.getNoAppRuntimeKey();
                if (noAppRuntimeKey2 == null) {
                    noAppRuntimeKey2 = "";
                }
                companion.setNoAppRuntimeKey(noAppRuntimeKey2 + this.name + ",");
                refreshDataTasks.put(str, new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.BaseConfigProxy$getStringData$2$1
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
                        BaseConfigProxy.this.getStringData(defaultValue);
                    }
                });
                String decodeString = VipNtMMKV.INSTANCE.getConfigBackup().decodeString(str, defaultValue);
                if (decodeString != null) {
                    return decodeString;
                }
                return defaultValue;
            }
            if (!TextUtils.isEmpty(companion.getNoAppRuntimeKey())) {
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    QLog.e(TAG, 1, "runtime is not null, nameList: " + companion.getNoAppRuntimeKey());
                }
                companion.setNoAppRuntimeKey(null);
            }
            String onGetStringData = onGetStringData(defaultValue);
            VipNtMMKV.INSTANCE.getConfigBackup().encodeString(str, onGetStringData);
            if (onGetStringData != null) {
                return onGetStringData;
            }
            return defaultValue;
        }
        String onGetStringData2 = onGetStringData(defaultValue);
        if (onGetStringData2 != null) {
            return onGetStringData2;
        }
        return defaultValue;
    }

    @Override // com.tencent.mobileqq.vas.IConfigProxy
    @Nullable
    public String getStringDataSet(@NotNull final String key, @Nullable final String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Companion companion = INSTANCE;
        if (companion.getNeedRefresh().get() && MobileQQ.sMobileQQ.peekAppRuntime() != null && companion.getNeedRefresh().compareAndSet(true, false)) {
            QLog.e(TAG, 1, "refresh MMKV data");
            ThreadManagerV2.excute(BaseConfigProxy$checkRefresh$1.f307820d, 16, null, false);
        }
        if (QLog.isDebugVersion()) {
            logConfig(new Function0<Object>() { // from class: com.tencent.mobileqq.vas.BaseConfigProxy$getStringDataSet$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Object invoke() {
                    return BaseConfigProxy.this.getStringDataSet(key, defaultValue);
                }
            });
        }
        if (this.backupToMMKV) {
            String str = this.name + "_" + key + "_string";
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                if (TextUtils.isEmpty(companion.getNoAppRuntimeKey())) {
                    QLog.e(TAG, 1, "runtime is null");
                }
                String noAppRuntimeKey2 = companion.getNoAppRuntimeKey();
                if (noAppRuntimeKey2 == null) {
                    noAppRuntimeKey2 = "";
                }
                companion.setNoAppRuntimeKey(noAppRuntimeKey2 + this.name + ",");
                refreshDataTasks.put(str, new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.BaseConfigProxy$getStringDataSet$2$1
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
                        BaseConfigProxy.this.getStringDataSet(key, defaultValue);
                    }
                });
                if (defaultValue == null) {
                    return VipNtMMKV.INSTANCE.getConfigBackup().decodeString(str, defaultValue);
                }
                String decodeString = VipNtMMKV.INSTANCE.getConfigBackup().decodeString(str, defaultValue);
                if (decodeString != null) {
                    return decodeString;
                }
                return defaultValue;
            }
            if (!TextUtils.isEmpty(companion.getNoAppRuntimeKey())) {
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    QLog.e(TAG, 1, "runtime is not null, nameList: " + companion.getNoAppRuntimeKey());
                }
                companion.setNoAppRuntimeKey(null);
            }
            String onGetStringDataSet = onGetStringDataSet(key, defaultValue);
            VipNtMMKV.INSTANCE.getConfigBackup().encodeString(str, onGetStringDataSet);
            if (defaultValue == null || onGetStringDataSet != null) {
                return onGetStringDataSet;
            }
            return defaultValue;
        }
        if (defaultValue == null) {
            return onGetStringDataSet(key, defaultValue);
        }
        String onGetStringDataSet2 = onGetStringDataSet(key, defaultValue);
        if (onGetStringDataSet2 != null) {
            return onGetStringDataSet2;
        }
        return defaultValue;
    }

    @Override // com.tencent.mobileqq.vas.IConfigProxy
    public boolean isEnable(final boolean defaultValue) {
        Companion companion = INSTANCE;
        if (companion.getNeedRefresh().get() && MobileQQ.sMobileQQ.peekAppRuntime() != null && companion.getNeedRefresh().compareAndSet(true, false)) {
            QLog.e(TAG, 1, "refresh MMKV data");
            ThreadManagerV2.excute(BaseConfigProxy$checkRefresh$1.f307820d, 16, null, false);
        }
        if (this.backupToMMKV) {
            String str = this.name + "_bool";
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                if (TextUtils.isEmpty(companion.getNoAppRuntimeKey())) {
                    QLog.e(TAG, 1, "runtime is null");
                }
                String noAppRuntimeKey2 = companion.getNoAppRuntimeKey();
                if (noAppRuntimeKey2 == null) {
                    noAppRuntimeKey2 = "";
                }
                companion.setNoAppRuntimeKey(noAppRuntimeKey2 + this.name + ",");
                refreshDataTasks.put(str, new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.BaseConfigProxy$isEnable$1$1
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
                        BaseConfigProxy.this.isEnable(defaultValue);
                    }
                });
                boolean decodeBool = VipNtMMKV.INSTANCE.getConfigBackup().decodeBool(str, defaultValue);
                logEnable(decodeBool);
                return decodeBool;
            }
            if (!TextUtils.isEmpty(companion.getNoAppRuntimeKey())) {
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    QLog.e(TAG, 1, "runtime is not null, nameList: " + companion.getNoAppRuntimeKey());
                }
                companion.setNoAppRuntimeKey(null);
            }
            boolean onIsEnable = onIsEnable(defaultValue);
            VipNtMMKV.INSTANCE.getConfigBackup().encodeBool(str, onIsEnable);
            logEnable(onIsEnable);
            return onIsEnable;
        }
        boolean onIsEnable2 = onIsEnable(defaultValue);
        logEnable(onIsEnable2);
        return onIsEnable2;
    }

    public abstract int onGetInt(int defaultValue);

    @Nullable
    public abstract JSONObject onGetJson();

    @Nullable
    public abstract String onGetStringData(@Nullable String defaultValue);

    @Nullable
    public abstract String onGetStringDataSet(@Nullable String key, @Nullable String defaultValue);

    public abstract boolean onIsEnable(boolean defaultValue);

    public /* synthetic */ BaseConfigProxy(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? false : z16);
    }
}
