package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util;

import android.text.Layout;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aio.widget.textView.view.AioTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u00a8\u0006\u0005"}, d2 = {"Landroid/widget/TextView;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/e;", "a", "Lcom/tencent/aio/widget/textView/view/AioTextView;", "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/d$a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/e;", "", "location", "", "getLocationInWindow", "a", "Landroid/text/Layout;", "getLayout", "()Landroid/text/Layout;", TtmlNode.TAG_LAYOUT, "", "getText", "()Ljava/lang/CharSequence;", "text", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f221653a;

        a(TextView textView) {
            this.f221653a = textView;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.e
        public void a(@NotNull int[] location) {
            Intrinsics.checkNotNullParameter(location, "location");
            this.f221653a.getLocationOnScreen(location);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.e
        @Nullable
        public Layout getLayout() {
            return this.f221653a.getLayout();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.e
        public void getLocationInWindow(@NotNull int[] location) {
            Intrinsics.checkNotNullParameter(location, "location");
            this.f221653a.getLocationInWindow(location);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.e
        @Nullable
        public CharSequence getText() {
            return this.f221653a.getText();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/d$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/e;", "", "location", "", "getLocationInWindow", "a", "Landroid/text/Layout;", "getLayout", "()Landroid/text/Layout;", TtmlNode.TAG_LAYOUT, "", "getText", "()Ljava/lang/CharSequence;", "text", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AioTextView f221654a;

        b(AioTextView aioTextView) {
            this.f221654a = aioTextView;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.e
        public void a(@NotNull int[] location) {
            Intrinsics.checkNotNullParameter(location, "location");
            this.f221654a.getLocationOnScreen(location);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.e
        @Nullable
        public Layout getLayout() {
            return this.f221654a.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.e
        public void getLocationInWindow(@NotNull int[] location) {
            Intrinsics.checkNotNullParameter(location, "location");
            this.f221654a.getLocationInWindow(location);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.e
        @Nullable
        public CharSequence getText() {
            return this.f221654a.o();
        }
    }

    @NotNull
    public static final e a(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        return new a(textView);
    }

    @NotNull
    public static final e b(@NotNull AioTextView aioTextView) {
        Intrinsics.checkNotNullParameter(aioTextView, "<this>");
        return new b(aioTextView);
    }
}
