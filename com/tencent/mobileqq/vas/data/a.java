package com.tencent.mobileqq.vas.data;

import com.tencent.state.square.util.Mp4SizeUtil;
import com.tencent.zplan.meme.action.MODE;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0011\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/vas/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "actionId", "b", "tWidth", "c", "tHeight", "d", "actionStyle", "Lcom/tencent/zplan/meme/action/MODE;", "e", "Lcom/tencent/zplan/meme/action/MODE;", "()Lcom/tencent/zplan/meme/action/MODE;", "mode", "f", "width", "g", "height", "<init>", "(IIIILcom/tencent/zplan/meme/action/MODE;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int actionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int tWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int tHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int actionStyle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MODE mode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int height;

    public a(int i3, int i16, int i17, int i18, @NotNull MODE mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.actionId = i3;
        this.tWidth = i16;
        this.tHeight = i17;
        this.actionStyle = i18;
        this.mode = mode;
        Mp4SizeUtil mp4SizeUtil = Mp4SizeUtil.INSTANCE;
        this.width = mp4SizeUtil.formatSize(i16);
        this.height = mp4SizeUtil.formatSize(i17);
    }

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    /* renamed from: b, reason: from getter */
    public final int getActionStyle() {
        return this.actionStyle;
    }

    /* renamed from: c, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final MODE getMode() {
        return this.mode;
    }

    /* renamed from: e, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.actionId == aVar.actionId && this.tWidth == aVar.tWidth && this.tHeight == aVar.tHeight && this.actionStyle == aVar.actionStyle && this.mode == aVar.mode) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.actionId * 31) + this.tWidth) * 31) + this.tHeight) * 31) + this.actionStyle) * 31) + this.mode.hashCode();
    }

    @NotNull
    public String toString() {
        return "{a:" + this.actionId + ", as:" + this.actionStyle + ", w:" + this.width + ", h:" + this.height + ", m:" + this.mode.name() + '}';
    }
}
