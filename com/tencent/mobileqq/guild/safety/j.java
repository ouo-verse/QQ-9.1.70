package com.tencent.mobileqq.guild.safety;

import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u001a\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\"\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "", "c", "", "tag", "content", "b", "d", "Lmqq/util/WeakReference;", "a", "Lmqq/util/WeakReference;", "shareDialogRef", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private static WeakReference<ShareActionSheet> f233052a;

    public static final void b(@NotNull String tag, @NotNull String content) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(content, "content");
        if (QLog.isColorLevel()) {
            QLog.i(tag, 2, content);
        }
    }

    public static final void c(@NotNull ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        f233052a = new WeakReference<>(shareActionSheet);
    }

    public static final void d(@NotNull String tag, @NotNull String content) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.i(tag, 1, content);
    }
}
