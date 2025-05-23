package com.tencent.qmethod.monitor.ext.traffic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 D2\u00020\u0001:\u0001\u0006B\u0094\u0001\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b\u0012\b\b\u0002\u0010\"\u001a\u00020\u0013\u0012\b\b\u0002\u0010(\u001a\u00020#\u0012#\b\u0002\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020#0)\u0012\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0014\b\u0002\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020:\u00a2\u0006\u0004\bB\u0010CJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u0017\u0010\n\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0006\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\"\u0010(\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010$\u001a\u0004\b\f\u0010%\"\u0004\b&\u0010'R=\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020#0)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R.\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\u00a8\u0006E"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureRule;", "", "", "", "g", "toString", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "sensitiveCategory", "", "b", "[Ljava/lang/String;", "c", "()[Ljava/lang/String;", "setKeys", "([Ljava/lang/String;)V", "keys", "", "I", "()I", "setCheckRule", "(I)V", "checkRule", "Lkotlin/text/Regex;", "d", "[Lkotlin/text/Regex;", "()[Lkotlin/text/Regex;", "setRegex", "([Lkotlin/text/Regex;)V", "regex", "f", "setValMinLengthFroContain", "valMinLengthFroContain", "", "Z", "()Z", "setEnable", "(Z)V", "enable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "Lkotlin/jvm/functions/Function1;", "getValFilter", "()Lkotlin/jvm/functions/Function1;", "setValFilter", "(Lkotlin/jvm/functions/Function1;)V", "valFilter", tl.h.F, "Ljava/util/Set;", "getValSet", "()Ljava/util/Set;", "setValSet", "(Ljava/util/Set;)V", "valSet", "Lkotlin/Function0;", "i", "Lkotlin/jvm/functions/Function0;", "getValProvider", "()Lkotlin/jvm/functions/Function0;", "setValProvider", "(Lkotlin/jvm/functions/Function0;)V", "valProvider", "<init>", "(Ljava/lang/String;[Ljava/lang/String;I[Lkotlin/text/Regex;IZLkotlin/jvm/functions/Function1;Ljava/util/Set;Lkotlin/jvm/functions/Function0;)V", "j", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class NetworkCaptureRule {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sensitiveCategory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String[] keys;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int valRule;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private Regex[] regex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int valMinLengthFroContain;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean enable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super String, Boolean> valFilter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<String> valSet;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends Set<String>> valProvider;

    public NetworkCaptureRule(@NotNull String sensitiveCategory, @NotNull String[] keys, int i3, @NotNull Regex[] regex, int i16, boolean z16, @NotNull Function1<? super String, Boolean> valFilter, @NotNull Set<String> valSet, @NotNull Function0<? extends Set<String>> valProvider) {
        Intrinsics.checkParameterIsNotNull(sensitiveCategory, "sensitiveCategory");
        Intrinsics.checkParameterIsNotNull(keys, "keys");
        Intrinsics.checkParameterIsNotNull(regex, "regex");
        Intrinsics.checkParameterIsNotNull(valFilter, "valFilter");
        Intrinsics.checkParameterIsNotNull(valSet, "valSet");
        Intrinsics.checkParameterIsNotNull(valProvider, "valProvider");
        this.sensitiveCategory = sensitiveCategory;
        this.keys = keys;
        this.valRule = i3;
        this.regex = regex;
        this.valMinLengthFroContain = i16;
        this.enable = z16;
        this.valFilter = valFilter;
        this.valSet = valSet;
        this.valProvider = valProvider;
    }

    /* renamed from: a, reason: from getter */
    public final int getValRule() {
        return this.valRule;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String[] getKeys() {
        return this.keys;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final Regex[] getRegex() {
        return this.regex;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSensitiveCategory() {
        return this.sensitiveCategory;
    }

    /* renamed from: f, reason: from getter */
    public final int getValMinLengthFroContain() {
        return this.valMinLengthFroContain;
    }

    @NotNull
    public Set<String> g() {
        Set<String> mutableSet;
        Set<String> invoke = this.valProvider.invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : invoke) {
            if (this.valFilter.invoke((String) obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        mutableSet = CollectionsKt___CollectionsKt.toMutableSet(arrayList);
        return mutableSet;
    }

    @NotNull
    public String toString() {
        return "SensitiveInfoRule{sensitiveCategory='" + this.sensitiveCategory + "', keys=" + Arrays.toString(this.keys) + ", valRule=" + this.valRule + ", regex=" + Arrays.toString(this.regex) + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ NetworkCaptureRule(String str, String[] strArr, int i3, Regex[] regexArr, int i16, boolean z16, Function1 function1, Set set, Function0 function0, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, strArr, i3, r6, r7, r8, r9, r10, (i17 & 256) != 0 ? new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureRule.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                return r1;
            }
        } : function0);
        Regex[] regexArr2 = (i17 & 8) != 0 ? new Regex[0] : regexArr;
        int i18 = (i17 & 16) != 0 ? 4 : i16;
        boolean z17 = (i17 & 32) != 0 ? true : z16;
        Function1 function12 = (i17 & 64) != 0 ? new Function1<String, Boolean>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureRule.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(@NotNull String it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return true;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(String str2) {
                return Boolean.valueOf(invoke2(str2));
            }
        } : function1;
        final Set linkedHashSet = (i17 & 128) != 0 ? new LinkedHashSet() : set;
    }
}
