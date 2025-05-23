package com.tencent.mobileqq.qmmkv;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getWhiteList", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "<init>", "()V", "Companion", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MMKVCleanUpThoroughCacheTool implements com.tencent.mobileqq.app.message.messageclean.y {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String MMKV_TRIM_SWITCH_KEY = "mmkv_trim_on_cleanup_switch";
    public static final String TAG = "MMKVCleanUpThoroughCacheTool";
    private static final Lazy<List<String>> mmkvFileListForTrim$delegate;
    private static final Lazy<Boolean> mmkvTrimOnCleanUpSwitch$delegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVCleanUpThoroughCacheTool$a;", "", "", "mmkvTrimOnCleanUpSwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "mmkvTrimOnCleanUpSwitch", "", "", "mmkvFileListForTrim$delegate", "a", "()Ljava/util/List;", "mmkvFileListForTrim", "MMKV_TRIM_SWITCH_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qmmkv.MMKVCleanUpThoroughCacheTool$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<String> a() {
            return (List) MMKVCleanUpThoroughCacheTool.mmkvFileListForTrim$delegate.getValue();
        }

        public final boolean b() {
            return ((Boolean) MMKVCleanUpThoroughCacheTool.mmkvTrimOnCleanUpSwitch$delegate.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Boolean> lazy;
        Lazy<List<String>> lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qmmkv.MMKVCleanUpThoroughCacheTool$Companion$mmkvTrimOnCleanUpSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
            
                if (((com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager.class)).isSwitchOn(com.tencent.mobileqq.qmmkv.MMKVCleanUpThoroughCacheTool.MMKV_TRIM_SWITCH_KEY, false) != false) goto L6;
             */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Boolean invoke() {
                boolean z16;
                if (!AppSetting.s()) {
                    z16 = false;
                }
                z16 = true;
                QLog.d(MMKVCleanUpThoroughCacheTool.TAG, 1, "init mmkvTrimOnCleanUpSwitch =" + z16);
                return Boolean.valueOf(z16);
            }
        });
        mmkvTrimOnCleanUpSwitch$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends String>>() { // from class: com.tencent.mobileqq.qmmkv.MMKVCleanUpThoroughCacheTool$Companion$mmkvFileListForTrim$2
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends String> invoke() {
                List<? extends String> listOf;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{QMMKVFile.FILE_QCIRCLE, "QCIRCLE_MMKV_COMMON", "common_mmkv_configurations", QMMKVFile.FILE_ZPLAN, QMMKVFile.FILE_QZONE, "vas_mmkv_configurations", QMMKVFile.FILE_JSAPI, QMMKVFile.FILE_WEB, QMMKVFile.FILE_GUILD, QMMKVFile.FILE_UNITED_CONFIG, "qsec_mmkv_configurations"});
                return listOf;
            }
        });
        mmkvFileListForTrim$delegate = lazy2;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        String account;
        y.a.a(this);
        Companion companion = INSTANCE;
        QLog.i(TAG, 1, "clearCache mmkvTrimOnCleanUpSwitch=" + companion.b());
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.removeKey(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_bubble_view_show_count");
        from.removeKey("qsec.report.cache.key");
        from.removeKey("qsec.report.cache.key.report.time/2022/12/19");
        if (companion.b()) {
            BaseApplication context = BaseApplication.getContext();
            Iterator<T> it = companion.a().iterator();
            while (true) {
                MMKVOptionEntity mMKVOptionEntity = null;
                if (!it.hasNext()) {
                    break;
                }
                try {
                    mMKVOptionEntity = QMMKV.from(context, (String) it.next());
                } catch (Throwable unused) {
                }
                if (mMKVOptionEntity != null) {
                    mMKVOptionEntity.trim();
                }
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || (account = peekAppRuntime.getAccount()) == null) {
                return;
            }
            String str = account.length() > 0 ? account : null;
            if (str != null) {
                QMMKV.from(context, str + "_config_manager_mmkv_configurations").trim();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        return y.a.b(this);
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public ArrayList<String> getWhiteList() {
        return new ArrayList<>();
    }
}
