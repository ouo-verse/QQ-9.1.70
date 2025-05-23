package com.tencent.mobileqq.wink.dailysign;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B1\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0014R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/af;", "", "", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "setOriginMediaPath", "(Ljava/util/List;)V", "originMediaPath", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setTextContent", "(Ljava/lang/String;)V", "textContent", "d", "missionId", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<String> originMediaPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String textContent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String missionId;

    public af(@Nullable List<String> list, @Nullable String str, @Nullable String str2) {
        this.originMediaPath = list;
        this.textContent = str;
        this.missionId = str2;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getMissionId() {
        return this.missionId;
    }

    @Nullable
    public final List<String> b() {
        return this.originMediaPath;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getTextContent() {
        return this.textContent;
    }

    public final void d(@Nullable String str) {
        this.missionId = str;
    }

    public /* synthetic */ af(List list, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2);
    }
}
