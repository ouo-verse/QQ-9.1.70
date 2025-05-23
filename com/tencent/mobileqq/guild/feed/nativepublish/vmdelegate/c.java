package com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate;

import android.view.View;
import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/c;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/c$a;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class c implements k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/c$a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/c;", "Landroid/view/View;", "a", "Landroid/view/View;", "()Landroid/view/View;", "anchorView", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final View anchorView;

        public a(@Nullable View view) {
            super(null);
            this.anchorView = view;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final View getAnchorView() {
            return this.anchorView;
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    c() {
    }
}
