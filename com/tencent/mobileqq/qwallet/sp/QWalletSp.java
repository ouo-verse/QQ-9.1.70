package com.tencent.mobileqq.qwallet.sp;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qwallet.sp.QWalletSp;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0003)*+B\u0011\b\u0004\u0012\u0006\u0010&\u001a\u00020\u0001\u00a2\u0006\u0004\b'\u0010(J\u0019\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u0096\u0003J\u0011\u0010\b\u001a\n \u0004*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001J5\u0010\u000b\u001a.\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\u0002\b\u0003 \u0004*\u0016\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\u0002\b\u0003\u0018\u00010\n0\tH\u0096\u0001J!\u0010\r\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0001J!\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0096\u0001J!\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\f\u001a\u00020\u0010H\u0096\u0001J!\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\f\u001a\u00020\u0012H\u0096\u0001J'\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0097\u0001Jo\u0010\u0017\u001a(\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u0001 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00160\u00152\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032.\b\u0001\u0010\f\u001a(\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u0001 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00160\u0015H\u0097\u0001J\u0019\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00180\u0018H\u0096\u0001J\u0019\u0010\u001b\u001a\u00020\u00192\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00180\u0018H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0019H\u0096\u0001J\u0011\u0010\u001d\u001a\n \u0004*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u0006H\u0096\u0001J)\u0010\u001f\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0001J)\u0010 \u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0096\u0001J)\u0010!\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\f\u001a\u00020\u0010H\u0096\u0001J)\u0010\"\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\f\u001a\u00020\u0012H\u0096\u0001J-\u0010#\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0096\u0001JQ\u0010$\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032.\b\u0001\u0010\f\u001a(\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u0001 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00160\u0015H\u0096\u0001J!\u0010%\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u0096\u0001\u0082\u0001\u0003,-.\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/qwallet/sp/QWalletSp;", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences$Editor;", "", "kotlin.jvm.PlatformType", "p0", "", "contains", "edit", "", "", "getAll", "p1", "getBoolean", "", "getFloat", "", "getInt", "", "getLong", "getString", "", "", "getStringSet", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "", "registerOnSharedPreferenceChangeListener", "unregisterOnSharedPreferenceChangeListener", "apply", QCircleLpReportDc05507.KEY_CLEAR, "commit", "putBoolean", "putFloat", "putInt", "putLong", "putString", "putStringSet", "remove", "sp", "<init>", "(Landroid/content/SharedPreferences;)V", "AutoMigrate", "a", "b", "Lcom/tencent/mobileqq/qwallet/sp/QWalletSp$AutoMigrate;", "Lcom/tencent/mobileqq/qwallet/sp/QWalletSp$a;", "Lcom/tencent/mobileqq/qwallet/sp/QWalletSp$b;", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class QWalletSp implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ SharedPreferences f279189d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ SharedPreferences.Editor f279190e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J\"\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u001a\u0010\u0014\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\u001a\u0010\u0016\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0015H\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0017H\u0016R\u0014\u0010\u001a\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R \u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qwallet/sp/QWalletSp$AutoMigrate;", "Lcom/tencent/mobileqq/qwallet/sp/QWalletSp;", "", "i", "g", "", "processId", "", "f", "Lkotlin/Function0;", "action", "e", "key", "", "values", "Landroid/content/SharedPreferences$Editor;", "putStringSet", "value", "putInt", "", "putLong", "", "putFloat", "", "putBoolean", "Ljava/lang/String;", "spFileName", "Landroid/content/SharedPreferences;", h.F, "Landroid/content/SharedPreferences;", "systemSp", "mmkvAdapter", "Ljava/util/concurrent/atomic/AtomicBoolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isMigrating", "Ljava/util/concurrent/ConcurrentLinkedQueue;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/ConcurrentLinkedQueue;", "cachedPutActions", "Ljava/lang/Runnable;", "D", "Ljava/lang/Runnable;", "flushAction", "<init>", "(Ljava/lang/String;Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class AutoMigrate extends QWalletSp {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final ConcurrentLinkedQueue<Function0<Unit>> cachedPutActions;

        /* renamed from: D, reason: from kotlin metadata */
        @Nullable
        private Runnable flushAction;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String spFileName;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SharedPreferences systemSp;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SharedPreferences mmkvAdapter;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicBoolean isMigrating;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AutoMigrate(@NotNull String spFileName, @NotNull SharedPreferences systemSp, @NotNull SharedPreferences mmkvAdapter) {
            super(systemSp, null);
            Intrinsics.checkNotNullParameter(spFileName, "spFileName");
            Intrinsics.checkNotNullParameter(systemSp, "systemSp");
            Intrinsics.checkNotNullParameter(mmkvAdapter, "mmkvAdapter");
            this.spFileName = spFileName;
            this.systemSp = systemSp;
            this.mmkvAdapter = mmkvAdapter;
            this.isMigrating = new AtomicBoolean(true);
            this.cachedPutActions = new ConcurrentLinkedQueue<>();
            mmkvAdapter.edit().putBoolean(f(MobileQQ.sProcessId), false).apply();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.sp.a
                @Override // java.lang.Runnable
                public final void run() {
                    QWalletSp.AutoMigrate.c(QWalletSp.AutoMigrate.this);
                }
            }, 64, null, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(AutoMigrate this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.isMigrating.compareAndSet(true, false)) {
                QMMKV.migrateToSpAdapter(BaseApplication.context, this$0.spFileName, QMMKVFile.FILE_QWALLET);
            }
            this$0.i();
        }

        private final void e(Function0<Unit> action) {
            this.cachedPutActions.add(action);
            g();
        }

        private final String f(int processId) {
            return "is_sp_per_process_migrated_process_id_" + processId + util.base64_pad_url + this.spFileName;
        }

        private final void g() {
            Runnable runnable = this.flushAction;
            if (runnable != null) {
                ThreadManagerV2.removeJob(runnable, 64);
            }
            if (this.isMigrating.get()) {
                this.flushAction = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.qwallet.sp.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        QWalletSp.AutoMigrate.h(QWalletSp.AutoMigrate.this);
                    }
                }, 64, null, true, 1000L);
                return;
            }
            Iterator<Function0<Unit>> it = this.cachedPutActions.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "cachedPutActions.iterator()");
            while (it.hasNext()) {
                it.next().invoke();
                it.remove();
            }
            i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(AutoMigrate this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.g();
        }

        private final void i() {
            int i3;
            if (!this.isMigrating.get() && !(!this.cachedPutActions.isEmpty())) {
                int i16 = MobileQQ.sProcessId;
                this.mmkvAdapter.edit().putBoolean(f(i16), true).apply();
                if (i16 == 1) {
                    i3 = 7;
                } else {
                    i3 = 1;
                }
                if (this.mmkvAdapter.getBoolean(f(i3), true)) {
                    this.mmkvAdapter.edit().putBoolean("is_sp_migrated_" + this.spFileName, true).apply();
                }
            }
        }

        @Override // com.tencent.mobileqq.qwallet.sp.QWalletSp, android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putBoolean(@Nullable final String key, final boolean value) {
            e(new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.sp.QWalletSp$AutoMigrate$putBoolean$1
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
                    SharedPreferences sharedPreferences;
                    sharedPreferences = QWalletSp.AutoMigrate.this.mmkvAdapter;
                    sharedPreferences.edit().putBoolean(key, value).apply();
                }
            });
            SharedPreferences.Editor putBoolean = this.systemSp.edit().putBoolean(key, value);
            Intrinsics.checkNotNullExpressionValue(putBoolean, "systemSp.edit().putBoolean(key, value)");
            return putBoolean;
        }

        @Override // com.tencent.mobileqq.qwallet.sp.QWalletSp, android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putFloat(@Nullable final String key, final float value) {
            e(new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.sp.QWalletSp$AutoMigrate$putFloat$1
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
                    SharedPreferences sharedPreferences;
                    sharedPreferences = QWalletSp.AutoMigrate.this.mmkvAdapter;
                    sharedPreferences.edit().putFloat(key, value).apply();
                }
            });
            SharedPreferences.Editor putFloat = this.systemSp.edit().putFloat(key, value);
            Intrinsics.checkNotNullExpressionValue(putFloat, "systemSp.edit().putFloat(key, value)");
            return putFloat;
        }

        @Override // com.tencent.mobileqq.qwallet.sp.QWalletSp, android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putInt(@Nullable final String key, final int value) {
            e(new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.sp.QWalletSp$AutoMigrate$putInt$1
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
                    SharedPreferences sharedPreferences;
                    sharedPreferences = QWalletSp.AutoMigrate.this.mmkvAdapter;
                    sharedPreferences.edit().putInt(key, value).apply();
                }
            });
            SharedPreferences.Editor putInt = this.systemSp.edit().putInt(key, value);
            Intrinsics.checkNotNullExpressionValue(putInt, "systemSp.edit().putInt(key, value)");
            return putInt;
        }

        @Override // com.tencent.mobileqq.qwallet.sp.QWalletSp, android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putLong(@Nullable final String key, final long value) {
            e(new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.sp.QWalletSp$AutoMigrate$putLong$1
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
                    SharedPreferences sharedPreferences;
                    sharedPreferences = QWalletSp.AutoMigrate.this.mmkvAdapter;
                    sharedPreferences.edit().putLong(key, value).apply();
                }
            });
            SharedPreferences.Editor putLong = this.systemSp.edit().putLong(key, value);
            Intrinsics.checkNotNullExpressionValue(putLong, "systemSp.edit().putLong(key, value)");
            return putLong;
        }

        @Override // com.tencent.mobileqq.qwallet.sp.QWalletSp, android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putStringSet(@Nullable final String key, @Nullable final Set<String> values) {
            e(new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.sp.QWalletSp$AutoMigrate$putStringSet$1
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
                    SharedPreferences sharedPreferences;
                    sharedPreferences = QWalletSp.AutoMigrate.this.mmkvAdapter;
                    sharedPreferences.edit().putStringSet(key, values).apply();
                }
            });
            SharedPreferences.Editor putStringSet = this.systemSp.edit().putStringSet(key, values);
            Intrinsics.checkNotNullExpressionValue(putStringSet, "systemSp.edit().putStringSet(key, values)");
            return putStringSet;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qwallet/sp/QWalletSp$a;", "Lcom/tencent/mobileqq/qwallet/sp/QWalletSp;", "Landroid/content/SharedPreferences;", "sp", "<init>", "(Landroid/content/SharedPreferences;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends QWalletSp {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull SharedPreferences sp5) {
            super(sp5, null);
            Intrinsics.checkNotNullParameter(sp5, "sp");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qwallet/sp/QWalletSp$b;", "Lcom/tencent/mobileqq/qwallet/sp/QWalletSp;", "Landroid/content/SharedPreferences;", "spAdapter", "<init>", "(Landroid/content/SharedPreferences;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends QWalletSp {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull SharedPreferences spAdapter) {
            super(spAdapter, null);
            Intrinsics.checkNotNullParameter(spAdapter, "spAdapter");
        }
    }

    public /* synthetic */ QWalletSp(SharedPreferences sharedPreferences, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences);
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f279190e.apply();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        return this.f279190e.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f279190e.commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String p06) {
        return this.f279189d.contains(p06);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f279189d.edit();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f279189d.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String p06, boolean p16) {
        return this.f279189d.getBoolean(p06, p16);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String p06, float p16) {
        return this.f279189d.getFloat(p06, p16);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String p06, int p16) {
        return this.f279189d.getInt(p06, p16);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String p06, long p16) {
        return this.f279189d.getLong(p06, p16);
    }

    @Override // android.content.SharedPreferences
    @android.annotation.Nullable
    @Nullable
    public String getString(String p06, @android.annotation.Nullable @Nullable String p16) {
        return this.f279189d.getString(p06, p16);
    }

    @Override // android.content.SharedPreferences
    @android.annotation.Nullable
    @Nullable
    public Set<String> getStringSet(String p06, @android.annotation.Nullable @Nullable Set<String> p16) {
        return this.f279189d.getStringSet(p06, p16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String p06, boolean p16) {
        return this.f279190e.putBoolean(p06, p16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String p06, float p16) {
        return this.f279190e.putFloat(p06, p16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String p06, int p16) {
        return this.f279190e.putInt(p06, p16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String p06, long p16) {
        return this.f279190e.putLong(p06, p16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String p06, @android.annotation.Nullable @Nullable String p16) {
        return this.f279190e.putString(p06, p16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String p06, @android.annotation.Nullable @Nullable Set<String> p16) {
        return this.f279190e.putStringSet(p06, p16);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener p06) {
        this.f279189d.registerOnSharedPreferenceChangeListener(p06);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String p06) {
        return this.f279190e.remove(p06);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener p06) {
        this.f279189d.unregisterOnSharedPreferenceChangeListener(p06);
    }

    QWalletSp(SharedPreferences sharedPreferences) {
        this.f279189d = sharedPreferences;
        this.f279190e = sharedPreferences.edit();
    }
}
