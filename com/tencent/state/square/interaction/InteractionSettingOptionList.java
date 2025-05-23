package com.tencent.state.square.interaction;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pt4.d;
import pt4.p;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0011\u0010\u0015J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003J\u0019\u0010\u0006\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionSettingOptionList;", "", "", "Lcom/tencent/state/square/interaction/InteractionSettingOption;", "component1", "options", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Lpt4/d;", "pb", "(Lpt4/d;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionSettingOptionList {
    private final List<InteractionSettingOption> options;

    public InteractionSettingOptionList(List<InteractionSettingOption> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
    }

    public final List<InteractionSettingOption> component1() {
        return this.options;
    }

    public final InteractionSettingOptionList copy(List<InteractionSettingOption> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        return new InteractionSettingOptionList(options);
    }

    public final List<InteractionSettingOption> getOptions() {
        return this.options;
    }

    public int hashCode() {
        List<InteractionSettingOption> list = this.options;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "InteractionSettingOptionList(options=" + this.options + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InteractionSettingOptionList(d pb5) {
        this(r0);
        Intrinsics.checkNotNullParameter(pb5, "pb");
        p[] pVarArr = pb5.f427165a;
        Intrinsics.checkNotNullExpressionValue(pVarArr, "pb.options");
        ArrayList arrayList = new ArrayList(pVarArr.length);
        for (p it : pVarArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(new InteractionSettingOption(it));
        }
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof InteractionSettingOptionList) && Intrinsics.areEqual(this.options, ((InteractionSettingOptionList) other).options);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InteractionSettingOptionList copy$default(InteractionSettingOptionList interactionSettingOptionList, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = interactionSettingOptionList.options;
        }
        return interactionSettingOptionList.copy(list);
    }
}
