package fr3;

import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R$\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0002`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\tR\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lfr3/e;", "", "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "b", "Lcom/tencent/qmethod/monitor/config/c;", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "permList", "", "permControlRules", "c", "I", "controlRule", "", "d", "Z", "useSubMod", "e", "Ljava/lang/String;", HippyNestedScrollComponent.PRIORITY_PARENT, "f", "getName", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<String> permList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Integer> permControlRules;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int controlRule;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean useSubMod;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String parent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    public e(@NotNull String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.name = name;
        this.permList = new ArrayList<>();
        this.permControlRules = new ArrayList<>();
        this.controlRule = 1;
        this.parent = "";
    }

    @NotNull
    public final com.tencent.qmethod.monitor.config.c a() {
        com.tencent.qmethod.monitor.a.q().k(this.name, this.parent, this.useSubMod, null, this.permList, this.controlRule, this.permControlRules);
        return com.tencent.qmethod.monitor.a.f();
    }

    @NotNull
    public final e b(@NotNull String permission) {
        Intrinsics.checkParameterIsNotNull(permission, "permission");
        this.permList.add(permission);
        this.permControlRules.add(0);
        return this;
    }
}
