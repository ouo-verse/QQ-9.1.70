package com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\tH\u00c6\u0003J\t\u0010 \u001a\u00020\rH\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J_\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020&H\u00d6\u0001J\u0006\u0010'\u001a\u00020\tJ\t\u0010(\u001a\u00020\tH\u00d6\u0001R&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/ReqBody;", "", "stream", "", "messages", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/Extra;", "Lkotlin/collections/ArrayList;", "prompt", "", "sign", "model", "timestamp", "", "userSelected", "(ZLjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V", "getMessages", "()Ljava/util/ArrayList;", "getModel", "()Ljava/lang/String;", "getPrompt", "getSign", "getStream", "()Z", "getTimestamp", "()J", "getUserSelected", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toJson", "toString", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final /* data */ class ReqBody {

    @SerializedName("messages")
    @NotNull
    private final ArrayList<Extra> messages;

    @SerializedName("model")
    @NotNull
    private final String model;

    @SerializedName("prompt")
    @NotNull
    private final String prompt;

    @SerializedName("sign")
    @NotNull
    private final String sign;

    @SerializedName("stream")
    private final boolean stream;

    @SerializedName("timestamp")
    private final long timestamp;

    @SerializedName("user_selected")
    private final boolean userSelected;

    public ReqBody(boolean z16, @NotNull ArrayList<Extra> messages, @NotNull String prompt, @NotNull String sign, @NotNull String model, long j3, boolean z17) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(sign, "sign");
        Intrinsics.checkNotNullParameter(model, "model");
        this.stream = z16;
        this.messages = messages;
        this.prompt = prompt;
        this.sign = sign;
        this.model = model;
        this.timestamp = j3;
        this.userSelected = z17;
    }

    public static /* synthetic */ ReqBody copy$default(ReqBody reqBody, boolean z16, ArrayList arrayList, String str, String str2, String str3, long j3, boolean z17, int i3, Object obj) {
        boolean z18;
        ArrayList arrayList2;
        String str4;
        String str5;
        String str6;
        long j16;
        boolean z19;
        if ((i3 & 1) != 0) {
            z18 = reqBody.stream;
        } else {
            z18 = z16;
        }
        if ((i3 & 2) != 0) {
            arrayList2 = reqBody.messages;
        } else {
            arrayList2 = arrayList;
        }
        if ((i3 & 4) != 0) {
            str4 = reqBody.prompt;
        } else {
            str4 = str;
        }
        if ((i3 & 8) != 0) {
            str5 = reqBody.sign;
        } else {
            str5 = str2;
        }
        if ((i3 & 16) != 0) {
            str6 = reqBody.model;
        } else {
            str6 = str3;
        }
        if ((i3 & 32) != 0) {
            j16 = reqBody.timestamp;
        } else {
            j16 = j3;
        }
        if ((i3 & 64) != 0) {
            z19 = reqBody.userSelected;
        } else {
            z19 = z17;
        }
        return reqBody.copy(z18, arrayList2, str4, str5, str6, j16, z19);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getStream() {
        return this.stream;
    }

    @NotNull
    public final ArrayList<Extra> component2() {
        return this.messages;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getSign() {
        return this.sign;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component6, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getUserSelected() {
        return this.userSelected;
    }

    @NotNull
    public final ReqBody copy(boolean stream, @NotNull ArrayList<Extra> messages, @NotNull String prompt, @NotNull String sign, @NotNull String model, long timestamp, boolean userSelected) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(sign, "sign");
        Intrinsics.checkNotNullParameter(model, "model");
        return new ReqBody(stream, messages, prompt, sign, model, timestamp, userSelected);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReqBody)) {
            return false;
        }
        ReqBody reqBody = (ReqBody) other;
        if (this.stream == reqBody.stream && Intrinsics.areEqual(this.messages, reqBody.messages) && Intrinsics.areEqual(this.prompt, reqBody.prompt) && Intrinsics.areEqual(this.sign, reqBody.sign) && Intrinsics.areEqual(this.model, reqBody.model) && this.timestamp == reqBody.timestamp && this.userSelected == reqBody.userSelected) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<Extra> getMessages() {
        return this.messages;
    }

    @NotNull
    public final String getModel() {
        return this.model;
    }

    @NotNull
    public final String getPrompt() {
        return this.prompt;
    }

    @NotNull
    public final String getSign() {
        return this.sign;
    }

    public final boolean getStream() {
        return this.stream;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final boolean getUserSelected() {
        return this.userSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean z16 = this.stream;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode = ((((((((((r06 * 31) + this.messages.hashCode()) * 31) + this.prompt.hashCode()) * 31) + this.sign.hashCode()) * 31) + this.model.hashCode()) * 31) + androidx.fragment.app.a.a(this.timestamp)) * 31;
        boolean z17 = this.userSelected;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return hashCode + i3;
    }

    @NotNull
    public final String toJson() {
        String json = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
        return json;
    }

    @NotNull
    public String toString() {
        return "ReqBody(stream=" + this.stream + ", messages=" + this.messages + ", prompt=" + this.prompt + ", sign=" + this.sign + ", model=" + this.model + ", timestamp=" + this.timestamp + ", userSelected=" + this.userSelected + ")";
    }
}
