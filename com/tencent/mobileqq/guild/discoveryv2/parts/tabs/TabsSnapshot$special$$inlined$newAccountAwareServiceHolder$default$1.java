package com.tencent.mobileqq.guild.discoveryv2.parts.tabs;

import com.tencent.mobileqq.guild.base.f;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabsSnapshot$special$$inlined$newAccountAwareServiceHolder$default$1", "Lcom/tencent/mobileqq/guild/base/a;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "destroy", "", "account", "onAccountChanged", "Lcom/tencent/mobileqq/guild/base/f;", "d", "Lcom/tencent/mobileqq/guild/base/f;", "holder", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", "value", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TabsSnapshot$special$$inlined$newAccountAwareServiceHolder$default$1 implements com.tencent.mobileqq.guild.base.a<MMKVOptionEntityV2>, com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private f<MMKVOptionEntityV2> holder;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Function1 f217708e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f217709f;

    public TabsSnapshot$special$$inlined$newAccountAwareServiceHolder$default$1(Function1 function1, Function1 function12) {
        this.f217708e = function1;
        this.f217709f = function12;
        this.holder = new f<MMKVOptionEntityV2>(function1) { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsSnapshot$special$$inlined$newAccountAwareServiceHolder$default$1.1

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy value;

            {
                Lazy lazy;
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntityV2>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsSnapshot$special$.inlined.newAccountAwareServiceHolder.default.1.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final MMKVOptionEntityV2 invoke() {
                        MMKVOptionEntityV2 withoutAccount = QMMKV.withoutAccount(MobileQQ.sMobileQQ.getApplicationContext(), "guild_mmkv_configurations_mvp_feed_cache");
                        Function1 function13 = Function1.this;
                        if (function13 != null) {
                            function13.invoke(withoutAccount);
                        }
                        return withoutAccount;
                    }
                });
                this.value = lazy;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2] */
            @Override // com.tencent.mobileqq.guild.base.f
            public MMKVOptionEntityV2 getValue() {
                return this.value.getValue();
            }
        };
        try {
            AccountChangedNotifier.f214789d.a(this);
        } catch (Throwable th5) {
            QLog.e("ServiceHolder", 1, "newAccountAwareServiceHolder e: " + th5);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.a
    public void destroy() {
        AccountChangedNotifier.f214789d.d(this);
        Function1 function1 = this.f217709f;
        if (function1 != null) {
            function1.invoke(this.holder.getValue());
        }
    }

    @Override // com.tencent.mobileqq.guild.base.f
    public MMKVOptionEntityV2 getValue() {
        return this.holder.getValue();
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        Function1 function1 = this.f217709f;
        if (function1 != null) {
            function1.invoke(this.holder.getValue());
        }
        f<MMKVOptionEntityV2> fVar = new f<MMKVOptionEntityV2>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsSnapshot$special$$inlined$newAccountAwareServiceHolder$default$1.2

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy value;

            {
                Lazy lazy;
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntityV2>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsSnapshot$special$.inlined.newAccountAwareServiceHolder.default.1.2.1
                    @Override // kotlin.jvm.functions.Function0
                    public final MMKVOptionEntityV2 invoke() {
                        return QMMKV.withoutAccount(MobileQQ.sMobileQQ.getApplicationContext(), "guild_mmkv_configurations_mvp_feed_cache");
                    }
                });
                this.value = lazy;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2] */
            @Override // com.tencent.mobileqq.guild.base.f
            public MMKVOptionEntityV2 getValue() {
                return this.value.getValue();
            }
        };
        this.holder = fVar;
        Function1 function12 = this.f217708e;
        if (function12 != null) {
            function12.invoke(fVar.getValue());
        }
    }
}
