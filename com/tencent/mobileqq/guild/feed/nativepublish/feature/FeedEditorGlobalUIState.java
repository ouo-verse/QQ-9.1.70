package com.tencent.mobileqq.guild.feed.nativepublish.feature;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "WhiteSheetGuideLineAlignState", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public class FeedEditorGlobalUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalUIState$WhiteSheetGuideLineAlignState;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isAlignFirstLayerTop", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class WhiteSheetGuideLineAlignState extends FeedEditorGlobalUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isAlignFirstLayerTop;

        public WhiteSheetGuideLineAlignState(boolean z16) {
            this.isAlignFirstLayerTop = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsAlignFirstLayerTop() {
            return this.isAlignFirstLayerTop;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof WhiteSheetGuideLineAlignState) && this.isAlignFirstLayerTop == ((WhiteSheetGuideLineAlignState) other).isAlignFirstLayerTop) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isAlignFirstLayerTop;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "WhiteSheetGuideLineAlignState(isAlignFirstLayerTop=" + this.isAlignFirstLayerTop + ")";
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
