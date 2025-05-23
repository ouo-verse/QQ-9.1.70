package com.tencent.mobileqq.guild.contentshare;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0016\u00a2\u0006\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0003\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\b\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001d\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/d;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "contentId", "b", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "data", "", "Lcom/tencent/mobileqq/guild/contentshare/b;", "Ljava/util/List;", "()Ljava/util/List;", "anchorInfo", "Lcom/tencent/mobileqq/guild/contentshare/c;", "Lcom/tencent/mobileqq/guild/contentshare/c;", "()Lcom/tencent/mobileqq/guild/contentshare/c;", "channelInfo", "", "e", "I", "()I", "g", "(I)V", "width", "f", "getMaxHeight", NodeProps.MAX_HEIGHT, "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/util/List;Lcom/tencent/mobileqq/guild/contentshare/c;II)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String contentId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object data;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<AnchorInfo> anchorInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChannelInfo channelInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int width;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int maxHeight;

    public d(@NotNull String contentId, @NotNull Object data, @NotNull List<AnchorInfo> anchorInfo, @NotNull ChannelInfo channelInfo, int i3, int i16) {
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        this.contentId = contentId;
        this.data = data;
        this.anchorInfo = anchorInfo;
        this.channelInfo = channelInfo;
        this.width = i3;
        this.maxHeight = i16;
    }

    @NotNull
    public final List<AnchorInfo> a() {
        return this.anchorInfo;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getContentId() {
        return this.contentId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    /* renamed from: e, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public final void f(int i3) {
        this.maxHeight = i3;
    }

    public final void g(int i3) {
        this.width = i3;
    }
}
