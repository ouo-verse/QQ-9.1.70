package com.tencent.guild.aio.reserve2.busi.chosen;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u0017\u0010\u001b\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\r\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/a;", "", "", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "title", "", "b", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "content", "c", "missionPicUrl", "d", "e", "picThumbUrl", "", "I", "()I", "picNum", "g", "videoThumbUrl", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence content;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String missionPicUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String picThumbUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int picNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String videoThumbUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msg;

    public a(@NotNull String title, @NotNull CharSequence content, @NotNull String missionPicUrl, @NotNull String picThumbUrl, int i3, @NotNull String videoThumbUrl, @NotNull MsgRecord msg2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(missionPicUrl, "missionPicUrl");
        Intrinsics.checkNotNullParameter(picThumbUrl, "picThumbUrl");
        Intrinsics.checkNotNullParameter(videoThumbUrl, "videoThumbUrl");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.title = title;
        this.content = content;
        this.missionPicUrl = missionPicUrl;
        this.picThumbUrl = picThumbUrl;
        this.picNum = i3;
        this.videoThumbUrl = videoThumbUrl;
        this.msg = msg2;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final CharSequence getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMissionPicUrl() {
        return this.missionPicUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final MsgRecord getMsg() {
        return this.msg;
    }

    /* renamed from: d, reason: from getter */
    public final int getPicNum() {
        return this.picNum;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPicThumbUrl() {
        return this.picThumbUrl;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getVideoThumbUrl() {
        return this.videoThumbUrl;
    }
}
