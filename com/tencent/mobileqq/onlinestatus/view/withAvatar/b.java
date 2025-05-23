package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import android.view.View;
import androidx.annotation.StringRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/b;", "", "", "a", "I", "c", "()I", "id", "b", "d", "type", "contentDescriptionRes", "Landroid/view/View;", "Landroid/view/View;", "e", "()Landroid/view/View;", "g", "(Landroid/view/View;)V", "view", "", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "contentDescription", "<init>", "(III)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int contentDescriptionRes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public View view;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public String contentDescription;

    public b(int i3, int i16, @StringRes int i17) {
        this.id = i3;
        this.type = i16;
        this.contentDescriptionRes = i17;
    }

    @NotNull
    public final String a() {
        String str = this.contentDescription;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentDescription");
        return null;
    }

    /* renamed from: b, reason: from getter */
    public final int getContentDescriptionRes() {
        return this.contentDescriptionRes;
    }

    /* renamed from: c, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final View e() {
        View view = this.view;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("view");
        return null;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.contentDescription = str;
    }

    public final void g(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.view = view;
    }
}
