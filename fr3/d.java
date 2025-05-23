package fr3;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.monitor.base.exception.UpdateRuleException;
import com.tencent.qmethod.monitor.config.CacheTime;
import com.tencent.qmethod.monitor.config.GeneralRule;
import com.tencent.qmethod.monitor.config.HighFrequency;
import com.tencent.qmethod.monitor.config.Silence;
import com.tencent.qmethod.monitor.config.bean.ConfigRule;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002JM\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u001c"}, d2 = {"Lfr3/d;", "Lfr3/c;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", DTConstants.TAG.API, DomainData.DOMAIN_NAME, "l", "Lcom/tencent/qmethod/monitor/config/GeneralRule;", "generalRule", "Lcom/tencent/qmethod/monitor/config/HighFrequency;", "highFrequency", "Lcom/tencent/qmethod/monitor/config/Silence;", "silence", "", "pages", "Lcom/tencent/qmethod/monitor/config/CacheTime;", "cacheTime", "o", "(Lcom/tencent/qmethod/monitor/config/GeneralRule;Lcom/tencent/qmethod/monitor/config/HighFrequency;Lcom/tencent/qmethod/monitor/config/Silence;[Ljava/lang/String;Lcom/tencent/qmethod/monitor/config/CacheTime;)Lfr3/d;", "Lcom/tencent/qmethod/monitor/config/c;", "k", "ruleConfig", "module", "", "apis", "<init>", "(Lcom/tencent/qmethod/monitor/config/c;Ljava/lang/String;Ljava/util/Set;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class d extends c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull com.tencent.qmethod.monitor.config.c ruleConfig, @NotNull String module, @NotNull Set<String> apis) {
        super(ruleConfig, module, apis);
        Intrinsics.checkParameterIsNotNull(ruleConfig, "ruleConfig");
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(apis, "apis");
    }

    private final void l() {
        if (!g().isEmpty()) {
        } else {
            throw new UpdateRuleException(UpdateRuleException.UpdateRuleFailType.EMPTY_PAGE, null, 2, null);
        }
    }

    private final void m() {
        if (c().isEmpty()) {
            n("");
            return;
        }
        Iterator<T> it = c().iterator();
        while (it.hasNext()) {
            n((String) it.next());
        }
    }

    private final void n(String api) {
        for (String str : g()) {
            a(new ConfigRule(getModule(), api, str, i().get(str), e().get(str), j().get(str), d().get(str)));
        }
    }

    @Override // fr3.c
    @NotNull
    public com.tencent.qmethod.monitor.config.c k() {
        super.k();
        l();
        m();
        return getRuleConfig();
    }

    @NotNull
    public final d o(@Nullable GeneralRule generalRule, @Nullable HighFrequency highFrequency, @Nullable Silence silence, @NotNull String[] pages, @Nullable CacheTime cacheTime) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(pages, "pages");
        if (pages.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            for (String str : pages) {
                if (!g().contains(str)) {
                    g().add(str);
                    if (generalRule != null) {
                        i().put(str, generalRule);
                    }
                    if (highFrequency != null) {
                        e().put(str, highFrequency);
                    }
                    if (silence != null) {
                        j().put(str, silence);
                    }
                    if (cacheTime != null) {
                        d().put(str, cacheTime);
                    }
                } else {
                    throw new UpdateRuleException(UpdateRuleException.UpdateRuleFailType.REPEAT_PAGE, str);
                }
            }
            return this;
        }
        throw new UpdateRuleException(UpdateRuleException.UpdateRuleFailType.EMPTY_PAGE, null, 2, null);
    }
}
