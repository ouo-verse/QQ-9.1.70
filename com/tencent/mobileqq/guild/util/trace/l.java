package com.tencent.mobileqq.guild.util.trace;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/util/trace/l;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "", "b", "I", "()I", "imageRes", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "()Landroid/view/View$OnClickListener;", "onClickListener", "<init>", "(Ljava/lang/String;ILandroid/view/View$OnClickListener;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int imageRes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener onClickListener;

    public l(@NotNull String title, int i3, @NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.title = title;
        this.imageRes = i3;
        this.onClickListener = onClickListener;
    }

    /* renamed from: a, reason: from getter */
    public final int getImageRes() {
        return this.imageRes;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }
}
