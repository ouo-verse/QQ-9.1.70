package com.tencent.qqmini.sdk.launcher.core.proxy.va;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/TipsData;", "", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "Ljava/util/ArrayList;", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/TipsElementData;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getElements", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final /* data */ class TipsData {

    @NotNull
    private final ArrayList<TipsElementData> elements;

    public TipsData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TipsData copy$default(TipsData tipsData, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = tipsData.elements;
        }
        return tipsData.copy(arrayList);
    }

    @NotNull
    public final ArrayList<TipsElementData> component1() {
        return this.elements;
    }

    @NotNull
    public final TipsData copy(@NotNull ArrayList<TipsElementData> elements) {
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        return new TipsData(elements);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof TipsData) || !Intrinsics.areEqual(this.elements, ((TipsData) other).elements)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @NotNull
    public final ArrayList<TipsElementData> getElements() {
        return this.elements;
    }

    public int hashCode() {
        ArrayList<TipsElementData> arrayList = this.elements;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "TipsData(elements=" + this.elements + ")";
    }

    public TipsData(@NotNull ArrayList<TipsElementData> elements) {
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        this.elements = elements;
    }

    public /* synthetic */ TipsData(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : arrayList);
    }
}
