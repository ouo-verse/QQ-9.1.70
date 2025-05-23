package com.tencent.mobileqq.guild.feed.nativepublish.title;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/title/SimplifiedFeedEditorTitleMviUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "EditorTitleVisible", "TitleStyle", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public class SimplifiedFeedEditorTitleMviUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/title/SimplifiedFeedEditorTitleMviUIState$EditorTitleVisible;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/title/SimplifiedFeedEditorTitleMviUIState;", "", "d", "Z", "b", "()Z", NodeProps.VISIBLE, "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "title", "<init>", "(ZLjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class EditorTitleVisible extends SimplifiedFeedEditorTitleMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean visible;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String title;

        public EditorTitleVisible(boolean z16, @NotNull String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.visible = z16;
            this.title = title;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \n2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/title/SimplifiedFeedEditorTitleMviUIState$TitleStyle;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/title/SimplifiedFeedEditorTitleMviUIState;", "", "d", "I", "a", "()I", "style", "<init>", "(I)V", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class TitleStyle extends SimplifiedFeedEditorTitleMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int style;

        public TitleStyle(int i3) {
            this.style = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getStyle() {
            return this.style;
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
