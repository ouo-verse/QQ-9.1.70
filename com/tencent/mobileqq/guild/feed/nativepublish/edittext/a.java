package com.tencent.mobileqq.guild.feed.nativepublish.edittext;

import android.text.Editable;
import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/a;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class a implements k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/a$a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/a;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.edittext.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7764a extends a {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/a$b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/a;", "Landroid/text/Editable;", "a", "Landroid/text/Editable;", "()Landroid/text/Editable;", "editable", "<init>", "(Landroid/text/Editable;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Editable editable;

        public b(@NotNull Editable editable) {
            Intrinsics.checkNotNullParameter(editable, "editable");
            this.editable = editable;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Editable getEditable() {
            return this.editable;
        }
    }
}
