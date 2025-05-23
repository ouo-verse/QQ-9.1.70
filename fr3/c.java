package fr3;

import com.tencent.qmethod.monitor.base.exception.UpdateRuleException;
import com.tencent.qmethod.monitor.config.CacheTime;
import com.tencent.qmethod.monitor.config.GeneralRule;
import com.tencent.qmethod.monitor.config.HighFrequency;
import com.tencent.qmethod.monitor.config.Silence;
import com.tencent.qmethod.monitor.config.bean.ConfigRule;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010+\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020\n\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020\n0/\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0004R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR>\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0012`\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R>\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001a0\u0011j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001a`\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R>\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0\u0011j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f`\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R>\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020$0\u0011j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020$`\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b%\u0010\u0018R\u001a\u0010+\u001a\u00020\u00048\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010.\u001a\u00020\n8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b'\u0010-R \u00100\u001a\b\u0012\u0004\u0012\u00020\n0/8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b\u001b\u0010\r\u00a8\u00063"}, d2 = {"Lfr3/c;", "", "", "b", "Lcom/tencent/qmethod/monitor/config/c;", "k", "Lcom/tencent/qmethod/monitor/config/bean/ConfigRule;", "newRule", "a", "", "", "Ljava/util/Set;", "g", "()Ljava/util/Set;", "setPages", "(Ljava/util/Set;)V", "pages", "Ljava/util/HashMap;", "Lcom/tencent/qmethod/monitor/config/GeneralRule;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "i", "()Ljava/util/HashMap;", "setRules", "(Ljava/util/HashMap;)V", "rules", "Lcom/tencent/qmethod/monitor/config/HighFrequency;", "c", "e", "setHighFrequencies", "highFrequencies", "Lcom/tencent/qmethod/monitor/config/Silence;", "d", "j", "setSilences", "silences", "Lcom/tencent/qmethod/monitor/config/CacheTime;", "setCacheTimes", "cacheTimes", "f", "Lcom/tencent/qmethod/monitor/config/c;", h.F, "()Lcom/tencent/qmethod/monitor/config/c;", "ruleConfig", "Ljava/lang/String;", "()Ljava/lang/String;", "module", "", "apis", "<init>", "(Lcom/tencent/qmethod/monitor/config/c;Ljava/lang/String;Ljava/util/Set;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<String> pages;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, GeneralRule> rules;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, HighFrequency> highFrequencies;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, Silence> silences;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, CacheTime> cacheTimes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qmethod.monitor.config.c ruleConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String module;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> apis;

    public c(@NotNull com.tencent.qmethod.monitor.config.c ruleConfig, @NotNull String module, @NotNull Set<String> apis) {
        Intrinsics.checkParameterIsNotNull(ruleConfig, "ruleConfig");
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(apis, "apis");
        this.ruleConfig = ruleConfig;
        this.module = module;
        this.apis = apis;
        this.pages = new LinkedHashSet();
        this.rules = new HashMap<>();
        this.highFrequencies = new HashMap<>();
        this.silences = new HashMap<>();
        this.cacheTimes = new HashMap<>();
    }

    private final void b() {
        boolean z16;
        if (this.module.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
        } else {
            throw new UpdateRuleException(UpdateRuleException.UpdateRuleFailType.EMPTY_INFO, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(@NotNull ConfigRule newRule) {
        Intrinsics.checkParameterIsNotNull(newRule, "newRule");
        ConfigRule configRule = this.ruleConfig.h().get(newRule.getModule() + newRule.getCom.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants.TAG.API java.lang.String() + newRule.getPage());
        if (configRule != null) {
            if (newRule.getCom.tencent.mobileqq.shortvideo.videotransfer.TransferConfig.ExtendParamFloats.KEY_RULE java.lang.String() == null && configRule.getCom.tencent.mobileqq.shortvideo.videotransfer.TransferConfig.ExtendParamFloats.KEY_RULE java.lang.String() != null) {
                newRule.k(configRule.getCom.tencent.mobileqq.shortvideo.videotransfer.TransferConfig.ExtendParamFloats.KEY_RULE java.lang.String());
            }
            if (newRule.getHighFrequency() == null && configRule.getHighFrequency() != null) {
                newRule.j(configRule.getHighFrequency());
            }
            if (newRule.getSilence() == null && configRule.getSilence() != null) {
                newRule.l(configRule.getSilence());
            }
            if (newRule.getCacheTime() == null && configRule.getCacheTime() != null) {
                newRule.i(configRule.getCacheTime());
            }
        }
        this.ruleConfig.h().put(newRule.getModule() + newRule.getCom.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants.TAG.API java.lang.String() + newRule.getPage(), newRule);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Set<String> c() {
        return this.apis;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final HashMap<String, CacheTime> d() {
        return this.cacheTimes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final HashMap<String, HighFrequency> e() {
        return this.highFrequencies;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getModule() {
        return this.module;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Set<String> g() {
        return this.pages;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: h, reason: from getter */
    public final com.tencent.qmethod.monitor.config.c getRuleConfig() {
        return this.ruleConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final HashMap<String, GeneralRule> i() {
        return this.rules;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final HashMap<String, Silence> j() {
        return this.silences;
    }

    @NotNull
    public com.tencent.qmethod.monitor.config.c k() {
        b();
        return this.ruleConfig;
    }
}
