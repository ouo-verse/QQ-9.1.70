package fr3;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.monitor.base.exception.UpdateRuleException;
import com.tencent.qmethod.monitor.config.CacheTime;
import com.tencent.qmethod.monitor.config.GeneralRule;
import com.tencent.qmethod.monitor.config.HighFrequency;
import com.tencent.qmethod.monitor.config.Silence;
import com.tencent.qmethod.monitor.config.bean.ConfigRule;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0017"}, d2 = {"Lfr3/b;", "Lfr3/c;", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qmethod/monitor/config/GeneralRule;", "value", "p", "Lcom/tencent/qmethod/monitor/config/HighFrequency;", "o", "Lcom/tencent/qmethod/monitor/config/Silence;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qmethod/monitor/config/CacheTime;", "l", "Lcom/tencent/qmethod/monitor/config/c;", "k", "ruleConfig", "", "module", "", "apis", "<init>", "(Lcom/tencent/qmethod/monitor/config/c;Ljava/lang/String;Ljava/util/Set;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b extends c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull com.tencent.qmethod.monitor.config.c ruleConfig, @NotNull String module, @NotNull Set<String> apis) {
        super(ruleConfig, module, apis);
        Intrinsics.checkParameterIsNotNull(ruleConfig, "ruleConfig");
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(apis, "apis");
    }

    private final void m() {
        GeneralRule generalRule;
        if (i().containsKey(getModule())) {
            if (d().containsKey(getModule()) && (generalRule = i().get(getModule())) != null) {
                int i3 = a.f400358a[generalRule.ordinal()];
                if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) {
                    UpdateRuleException.UpdateRuleFailType updateRuleFailType = UpdateRuleException.UpdateRuleFailType.CACHE_TIME_ONLY_USE_IN_CACHE_OR_STORAGE_RULE;
                    StringBuilder sb5 = new StringBuilder();
                    GeneralRule generalRule2 = i().get(getModule());
                    if (generalRule2 == null) {
                        Intrinsics.throwNpe();
                    }
                    sb5.append(generalRule2.name());
                    sb5.append(getModule());
                    sb5.append("");
                    sb5.append(c());
                    throw new UpdateRuleException(updateRuleFailType, sb5.toString());
                }
                return;
            }
            return;
        }
        throw new UpdateRuleException(UpdateRuleException.UpdateRuleFailType.EMPTY_API_RULE, null, 2, null);
    }

    private final void n() {
        m();
        if (c().isEmpty()) {
            a(new ConfigRule(getModule(), "", "", i().get(getModule()), e().get(getModule()), j().get(getModule()), d().get(getModule())));
            return;
        }
        Iterator<T> it = c().iterator();
        while (it.hasNext()) {
            a(new ConfigRule(getModule(), (String) it.next(), "", i().get(getModule()), e().get(getModule()), j().get(getModule()), d().get(getModule())));
        }
    }

    @Override // fr3.c
    @NotNull
    public com.tencent.qmethod.monitor.config.c k() {
        super.k();
        n();
        return getRuleConfig();
    }

    @NotNull
    public final b l(@NotNull CacheTime value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        d().put(getModule(), value);
        return this;
    }

    @NotNull
    public final b o(@NotNull HighFrequency value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        e().put(getModule(), value);
        return this;
    }

    @NotNull
    public final b p(@NotNull GeneralRule value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        i().put(getModule(), value);
        return this;
    }

    @NotNull
    public final b q(@NotNull Silence value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        j().put(getModule(), value);
        return this;
    }
}
