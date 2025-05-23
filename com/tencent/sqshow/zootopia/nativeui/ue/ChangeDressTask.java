package com.tencent.sqshow.zootopia.nativeui.ue;

import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\t\u0010\u0017R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010!\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b\u0015\u0010 R\u0019\u0010%\u001a\u0004\u0018\u00010\"8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b\u000f\u0010$R\u0019\u0010*\u001a\u0004\u0018\u00010&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/ue/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "from", "", "b", "Ljava/util/List;", "d", "()Ljava/util/List;", "dressIdList", "Lqu4/a;", "c", "Lqu4/a;", "()Lqu4/a;", "avatarCharacter", "Lb94/a;", "Lb94/a;", "e", "()Lb94/a;", "engineApi", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "clickedItemParam", "Lcom/tencent/zplan/luabridge/a$b;", "Lcom/tencent/zplan/luabridge/a$b;", "()Lcom/tencent/zplan/luabridge/a$b;", "cb", "Lcom/tencent/zplan/zplantracing/b;", "g", "Lcom/tencent/zplan/zplantracing/b;", "()Lcom/tencent/zplan/zplantracing/b;", "reportSpan", "<init>", "(Ljava/lang/String;Ljava/util/List;Lqu4/a;Lb94/a;Lorg/json/JSONObject;Lcom/tencent/zplan/luabridge/a$b;Lcom/tencent/zplan/zplantracing/b;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.nativeui.ue.k, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ChangeDressTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String from;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> dressIdList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final qu4.a avatarCharacter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final b94.a engineApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final JSONObject clickedItemParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final a.b cb;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final com.tencent.zplan.zplantracing.b reportSpan;

    public ChangeDressTask(String from, List<String> dressIdList, qu4.a avatarCharacter, b94.a aVar, JSONObject jSONObject, a.b bVar, com.tencent.zplan.zplantracing.b bVar2) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(dressIdList, "dressIdList");
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        this.from = from;
        this.dressIdList = dressIdList;
        this.avatarCharacter = avatarCharacter;
        this.engineApi = aVar;
        this.clickedItemParam = jSONObject;
        this.cb = bVar;
        this.reportSpan = bVar2;
    }

    /* renamed from: a, reason: from getter */
    public final qu4.a getAvatarCharacter() {
        return this.avatarCharacter;
    }

    /* renamed from: b, reason: from getter */
    public final a.b getCb() {
        return this.cb;
    }

    /* renamed from: c, reason: from getter */
    public final JSONObject getClickedItemParam() {
        return this.clickedItemParam;
    }

    public final List<String> d() {
        return this.dressIdList;
    }

    /* renamed from: e, reason: from getter */
    public final b94.a getEngineApi() {
        return this.engineApi;
    }

    /* renamed from: f, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    /* renamed from: g, reason: from getter */
    public final com.tencent.zplan.zplantracing.b getReportSpan() {
        return this.reportSpan;
    }

    public int hashCode() {
        int hashCode = ((((this.from.hashCode() * 31) + this.dressIdList.hashCode()) * 31) + this.avatarCharacter.hashCode()) * 31;
        b94.a aVar = this.engineApi;
        int hashCode2 = (hashCode + (aVar == null ? 0 : aVar.hashCode())) * 31;
        JSONObject jSONObject = this.clickedItemParam;
        int hashCode3 = (hashCode2 + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        a.b bVar = this.cb;
        int hashCode4 = (hashCode3 + (bVar == null ? 0 : bVar.hashCode())) * 31;
        com.tencent.zplan.zplantracing.b bVar2 = this.reportSpan;
        return hashCode4 + (bVar2 != null ? bVar2.hashCode() : 0);
    }

    public String toString() {
        return "ChangeDressTask(from=" + this.from + ", dressIdList=" + this.dressIdList + ", avatarCharacter=" + this.avatarCharacter + ", engineApi=" + this.engineApi + ", clickedItemParam=" + this.clickedItemParam + ", cb=" + this.cb + ", reportSpan=" + this.reportSpan + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChangeDressTask)) {
            return false;
        }
        ChangeDressTask changeDressTask = (ChangeDressTask) other;
        return Intrinsics.areEqual(this.from, changeDressTask.from) && Intrinsics.areEqual(this.dressIdList, changeDressTask.dressIdList) && Intrinsics.areEqual(this.avatarCharacter, changeDressTask.avatarCharacter) && Intrinsics.areEqual(this.engineApi, changeDressTask.engineApi) && Intrinsics.areEqual(this.clickedItemParam, changeDressTask.clickedItemParam) && Intrinsics.areEqual(this.cb, changeDressTask.cb) && Intrinsics.areEqual(this.reportSpan, changeDressTask.reportSpan);
    }

    public /* synthetic */ ChangeDressTask(String str, List list, qu4.a aVar, b94.a aVar2, JSONObject jSONObject, a.b bVar, com.tencent.zplan.zplantracing.b bVar2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, aVar, aVar2, (i3 & 16) != 0 ? null : jSONObject, (i3 & 32) != 0 ? null : bVar, (i3 & 64) != 0 ? ZPlanSpanFactory.INSTANCE.startRootSpan("ChangeDressTask") : bVar2);
    }
}
