package com.tencent.mobileqq.guild.feed.webbundle;

import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\tJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0011\u001a\u00020\u0010R$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/k;", "", "", WebAccelerateHelper.KEY_PRELOAD_URL, "g", "Lcom/tencent/mobileqq/guild/feed/webbundle/l;", "optionListener", "f", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "", "b", "", "d", "a", "", "e", "Ljava/util/ArrayList;", "preloadUrlList", "J", "preloadTimeoutLimit", "I", "preloadWebViewCount", "Lcom/tencent/mobileqq/guild/feed/webbundle/l;", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> preloadUrlList = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long preloadTimeoutLimit = 30000;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int preloadWebViewCount = 2;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private l optionListener;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final l getOptionListener() {
        return this.optionListener;
    }

    /* renamed from: b, reason: from getter */
    public final long getPreloadTimeoutLimit() {
        return this.preloadTimeoutLimit;
    }

    @NotNull
    public final ArrayList<String> c() {
        return this.preloadUrlList;
    }

    /* renamed from: d, reason: from getter */
    public final int getPreloadWebViewCount() {
        return this.preloadWebViewCount;
    }

    public final void e() {
        this.preloadUrlList.clear();
        this.preloadTimeoutLimit = 30000L;
        this.preloadWebViewCount = 2;
        this.optionListener = null;
    }

    @NotNull
    public final k f(@Nullable l optionListener) {
        this.optionListener = optionListener;
        return this;
    }

    @NotNull
    public final k g(@NotNull String preloadUrl) {
        Intrinsics.checkNotNullParameter(preloadUrl, "preloadUrl");
        this.preloadUrlList.clear();
        this.preloadUrlList.add(preloadUrl);
        return this;
    }
}
