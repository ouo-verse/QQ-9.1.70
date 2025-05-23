package com.tencent.mobileqq.qmmkv;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVWithAccountDeleteConfig;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "Lorg/json/JSONObject;", "jsonObj", "", "b", "", "d", "Z", "()Z", "e", "(Z)V", "switchOn", "", "Ljava/util/List;", "c", "()Ljava/util/List;", "setBlacklist", "(Ljava/util/List;)V", "blacklist", "<init>", "()V", "f", "a", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MMKVWithAccountDeleteConfig implements IConfigData {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<MMKVWithAccountDeleteConfig> f261983h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean switchOn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> blacklist;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVWithAccountDeleteConfig$a;", "", "Lcom/tencent/mobileqq/qmmkv/MMKVWithAccountDeleteConfig;", "sConfig$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qmmkv/MMKVWithAccountDeleteConfig;", "sConfig", "", "GROUPID", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qmmkv.MMKVWithAccountDeleteConfig$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MMKVWithAccountDeleteConfig a() {
            return (MMKVWithAccountDeleteConfig) MMKVWithAccountDeleteConfig.f261983h.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<MMKVWithAccountDeleteConfig> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVWithAccountDeleteConfig>() { // from class: com.tencent.mobileqq.qmmkv.MMKVWithAccountDeleteConfig$Companion$sConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MMKVWithAccountDeleteConfig invoke() {
                MMKVWithAccountDeleteConfigParser mMKVWithAccountDeleteConfigParser = new MMKVWithAccountDeleteConfigParser();
                MMKVWithAccountDeleteConfig c16 = mMKVWithAccountDeleteConfigParser.c();
                c16.e(mMKVWithAccountDeleteConfigParser.isSwitchOn(false));
                QLog.d("MMKVDelete_config", 1, "init switchOn: " + c16.getSwitchOn());
                return c16;
            }
        });
        f261983h = lazy;
    }

    public MMKVWithAccountDeleteConfig() {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.blacklist = emptyList;
    }

    public final void b(@NotNull JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        if (QLog.isColorLevel()) {
            QLog.d("MMKVDelete_config", 2, "from json:" + jsonObj);
        }
        this.blacklist = com.tencent.mobileqq.perf.process.config.g.a(jsonObj, "black");
    }

    @NotNull
    public final List<String> c() {
        return this.blacklist;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getSwitchOn() {
        return this.switchOn;
    }

    public final void e(boolean z16) {
        this.switchOn = z16;
    }

    @NotNull
    public String toString() {
        return "MMKVWithAccountDeleteConfig:{ black:" + this.blacklist + " }";
    }
}
