package com.tencent.kuikly.core.render.android.expand.module;

import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0005\u0010\bR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0013\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\r\u0010\b\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/u;", "", "", "toString", "", "a", "J", "d", "()J", "createStartTimeMills", "b", tl.h.F, "newPageStartTimeMills", "c", "g", "newPageEndTimeMills", "buildStartTimeMills", "e", "buildEndTimeMills", "f", "layoutStartTimeMills", "layoutEndTimeMills", "createEndTimeMills", "jsonStr", "<init>", "(Ljava/lang/String;)V", "i", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long createStartTimeMills;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long newPageStartTimeMills;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long newPageEndTimeMills;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long buildStartTimeMills;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long buildEndTimeMills;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long layoutStartTimeMills;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final long layoutEndTimeMills;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long createEndTimeMills;

    public u(@NotNull String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        JSONObject k06 = KRCSSViewExtensionKt.k0(jsonStr);
        this.createStartTimeMills = k06.optLong("on_create_start", -1L);
        this.newPageStartTimeMills = k06.optLong("on_new_page_start", -1L);
        this.newPageEndTimeMills = k06.optLong("on_new_page_end", -1L);
        this.buildStartTimeMills = k06.optLong("on_build_start", -1L);
        this.buildEndTimeMills = k06.optLong("on_build_end", -1L);
        this.layoutStartTimeMills = k06.optLong("on_layout_start", -1L);
        this.layoutEndTimeMills = k06.optLong("on_layout_end", -1L);
        this.createEndTimeMills = k06.optLong("on_create_end", -1L);
    }

    /* renamed from: a, reason: from getter */
    public final long getBuildEndTimeMills() {
        return this.buildEndTimeMills;
    }

    /* renamed from: b, reason: from getter */
    public final long getBuildStartTimeMills() {
        return this.buildStartTimeMills;
    }

    /* renamed from: c, reason: from getter */
    public final long getCreateEndTimeMills() {
        return this.createEndTimeMills;
    }

    /* renamed from: d, reason: from getter */
    public final long getCreateStartTimeMills() {
        return this.createStartTimeMills;
    }

    /* renamed from: e, reason: from getter */
    public final long getLayoutEndTimeMills() {
        return this.layoutEndTimeMills;
    }

    /* renamed from: f, reason: from getter */
    public final long getLayoutStartTimeMills() {
        return this.layoutStartTimeMills;
    }

    /* renamed from: g, reason: from getter */
    public final long getNewPageEndTimeMills() {
        return this.newPageEndTimeMills;
    }

    /* renamed from: h, reason: from getter */
    public final long getNewPageStartTimeMills() {
        return this.newPageStartTimeMills;
    }

    @NotNull
    public String toString() {
        return "[PageCreateTrace] onCreateStartTimeMills: " + this.createStartTimeMills + " \nonCreateEndTimeMills: " + this.createEndTimeMills + " \nnewPageStartTimeMills: " + this.newPageStartTimeMills + " \nnewPageEndTimeMills: " + this.newPageEndTimeMills + " \nonBuildStartTimeMills: " + this.buildStartTimeMills + " \nonBuildEndTimeMills: " + this.buildEndTimeMills + " \nonLayoutStartTimeMills: " + this.layoutStartTimeMills + " \nonLayoutEndTimeMills: " + this.layoutEndTimeMills;
    }
}
