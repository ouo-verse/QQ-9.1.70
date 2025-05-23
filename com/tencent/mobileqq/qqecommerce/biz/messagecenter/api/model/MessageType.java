package com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "", "Lorg/json/JSONObject;", "c", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "id", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "<init>", "(ILjava/lang/String;)V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.c, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class MessageType {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c$a;", "", "Lorg/json/JSONObject;", "data", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "a", "<init>", "()V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.c$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MessageType a(@NotNull JSONObject data) {
            Intrinsics.checkNotNullParameter(data, "data");
            int optInt = data.optInt("id");
            String optString = data.optString("text");
            Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"text\")");
            return new MessageType(optInt, optString);
        }

        Companion() {
        }
    }

    public MessageType(int i3, @NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.id = i3;
        this.text = text;
    }

    /* renamed from: a, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        jSONObject.put("text", this.text);
        return jSONObject;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageType)) {
            return false;
        }
        MessageType messageType = (MessageType) other;
        if (this.id == messageType.id && Intrinsics.areEqual(this.text, messageType.text)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.id * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        return "MessageType(id=" + this.id + ", text=" + this.text + ')';
    }
}
