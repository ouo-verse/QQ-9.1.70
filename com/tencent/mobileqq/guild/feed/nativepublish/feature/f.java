package com.tencent.mobileqq.guild.feed.nativepublish.feature;

import android.view.View;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorGlobalController;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/f;", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController;", "a", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController;", "b", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController;", "d", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController;)V", "globalController", "Landroid/view/View;", "Landroid/view/View;", "()Landroid/view/View;", "c", "(Landroid/view/View;)V", "bottomAnchorView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SimplifiedFeedEditorGlobalController globalController;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bottomAnchorView;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final View getBottomAnchorView() {
        return this.bottomAnchorView;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final SimplifiedFeedEditorGlobalController getGlobalController() {
        return this.globalController;
    }

    public final void c(@Nullable View view) {
        this.bottomAnchorView = view;
    }

    public final void d(@Nullable SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController) {
        this.globalController = simplifiedFeedEditorGlobalController;
    }
}
