package jv;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\n\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Ljv/a;", "Lcom/tencent/qqnt/graytips/action/f;", "", "getActionType", "a", "I", "d", "()I", "uinType", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "uin", "e", "url", "effectTime", "", "J", "()J", "messageTime", "<init>", "(ILjava/lang/String;Ljava/lang/String;IJ)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class a implements com.tencent.qqnt.graytips.action.f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int uinType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int effectTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long messageTime;

    public a(int i3, @NotNull String uin, @NotNull String url, int i16, long j3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(url, "url");
        this.uinType = i3;
        this.uin = uin;
        this.url = url;
        this.effectTime = i16;
        this.messageTime = j3;
    }

    /* renamed from: a, reason: from getter */
    public final int getEffectTime() {
        return this.effectTime;
    }

    /* renamed from: b, reason: from getter */
    public final long getMessageTime() {
        return this.messageTime;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: d, reason: from getter */
    public final int getUinType() {
        return this.uinType;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Override // com.tencent.qqnt.graytips.action.f
    public int getActionType() {
        return 81;
    }
}
