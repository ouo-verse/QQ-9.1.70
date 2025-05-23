package com.tencent.mobileqq.tvideo.viewmodel;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/tvideo/viewmodel/k;", "", "", "a", "I", "c", "()I", "setPageNum", "(I)V", "pageNum", "", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "setPageContext", "(Ljava/util/Map;)V", "pageContext", "setChannelId", "channelId", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "setReserveVid", "(Ljava/lang/String;)V", "reserveVid", "<init>", "(ILjava/util/Map;ILjava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int pageNum;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, String> pageContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String reserveVid;

    public k(int i3, @Nullable Map<String, String> map, int i16, @Nullable String str) {
        this.pageNum = i3;
        this.pageContext = map;
        this.channelId = i16;
        this.reserveVid = str;
    }

    /* renamed from: a, reason: from getter */
    public final int getChannelId() {
        return this.channelId;
    }

    @Nullable
    public final Map<String, String> b() {
        return this.pageContext;
    }

    /* renamed from: c, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getReserveVid() {
        return this.reserveVid;
    }
}
