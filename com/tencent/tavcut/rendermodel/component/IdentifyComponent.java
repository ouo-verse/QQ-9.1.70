package com.tencent.tavcut.rendermodel.component;

import com.google.gson.JsonObject;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003B1\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0014\u001a\u00020\u0001H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u00c6\u0003J<\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "", "data", "(Ljava/lang/Object;)V", "id", "", TemplateParser.KEY_ENTITY_ID, "rawData", "Lcom/google/gson/JsonObject;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Lcom/google/gson/JsonObject;)V", "getData", "()Ljava/lang/Object;", "getEntityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getRawData", "()Lcom/google/gson/JsonObject;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Lcom/google/gson/JsonObject;)Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "equals", "", "other", "hashCode", "toString", "", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class IdentifyComponent {

    @NotNull
    private final Object data;

    @Nullable
    private final Integer entityId;

    @Nullable
    private final Integer id;

    @Nullable
    private final JsonObject rawData;

    public IdentifyComponent(@Nullable Integer num, @Nullable Integer num2, @NotNull Object data, @Nullable JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        this.id = num;
        this.entityId = num2;
        this.data = data;
        this.rawData = jsonObject;
    }

    public static /* synthetic */ IdentifyComponent copy$default(IdentifyComponent identifyComponent, Integer num, Integer num2, Object obj, JsonObject jsonObject, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            num = identifyComponent.id;
        }
        if ((i3 & 2) != 0) {
            num2 = identifyComponent.entityId;
        }
        if ((i3 & 4) != 0) {
            obj = identifyComponent.data;
        }
        if ((i3 & 8) != 0) {
            jsonObject = identifyComponent.rawData;
        }
        return identifyComponent.copy(num, num2, obj, jsonObject);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getEntityId() {
        return this.entityId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final JsonObject getRawData() {
        return this.rawData;
    }

    @NotNull
    public final IdentifyComponent copy(@Nullable Integer id5, @Nullable Integer entityId, @NotNull Object data, @Nullable JsonObject rawData) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        return new IdentifyComponent(id5, entityId, data, rawData);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof IdentifyComponent) {
                IdentifyComponent identifyComponent = (IdentifyComponent) other;
                if (!Intrinsics.areEqual(this.id, identifyComponent.id) || !Intrinsics.areEqual(this.entityId, identifyComponent.entityId) || !Intrinsics.areEqual(this.data, identifyComponent.data) || !Intrinsics.areEqual(this.rawData, identifyComponent.rawData)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Object getData() {
        return this.data;
    }

    @Nullable
    public final Integer getEntityId() {
        return this.entityId;
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final JsonObject getRawData() {
        return this.rawData;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        Integer num = this.id;
        int i18 = 0;
        if (num != null) {
            i3 = num.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        Integer num2 = this.entityId;
        if (num2 != null) {
            i16 = num2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        Object obj = this.data;
        if (obj != null) {
            i17 = obj.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        JsonObject jsonObject = this.rawData;
        if (jsonObject != null) {
            i18 = jsonObject.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "IdentifyComponent(id=" + this.id + ", entityId=" + this.entityId + ", data=" + this.data + ", rawData=" + this.rawData + ")";
    }

    public /* synthetic */ IdentifyComponent(Integer num, Integer num2, Object obj, JsonObject jsonObject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : num, (i3 & 2) != 0 ? 0 : num2, obj, (i3 & 8) != 0 ? null : jsonObject);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IdentifyComponent(@NotNull Object data) {
        this(r3, r3, data, null, 8, null);
        Intrinsics.checkParameterIsNotNull(data, "data");
        int i3 = 0;
    }
}
