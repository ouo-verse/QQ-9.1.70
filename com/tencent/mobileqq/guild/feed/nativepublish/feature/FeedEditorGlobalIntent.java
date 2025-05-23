package com.tencent.mobileqq.guild.feed.nativepublish.feature;

import android.os.Message;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent;", "Lol3/b;", "<init>", "()V", "d", "a", "b", "Forward", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$Forward;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class FeedEditorGlobalIntent implements ol3.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicReference<b> f221961e = new AtomicReference<>(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$Forward;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "SaveDraftIntent", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$Forward$SaveDraftIntent;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static abstract class Forward extends FeedEditorGlobalIntent implements MsgIntent {

        /* compiled from: P */
        @AutoEventName
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$Forward$SaveDraftIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$Forward;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class SaveDraftIntent extends Forward {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$a;", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$b;", "a", "Ljava/util/concurrent/atomic/AtomicReference;", "envelopePool", "Ljava/util/concurrent/atomic/AtomicReference;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorGlobalIntent$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a() {
            b bVar = (b) FeedEditorGlobalIntent.f221961e.getAndSet(null);
            if (bVar == null) {
                bVar = new b();
            }
            bVar.e(false);
            return bVar;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent;", "", "c", "Lcom/tencent/mvi/base/route/MsgIntent;", "f", "Lcom/tencent/mvi/base/route/MsgIntent;", "b", "()Lcom/tencent/mvi/base/route/MsgIntent;", "d", "(Lcom/tencent/mvi/base/route/MsgIntent;)V", "msgIntent", "Landroid/os/Message;", h.F, "Landroid/os/Message;", "getMsg", "()Landroid/os/Message;", "setMsg", "(Landroid/os/Message;)V", "msg", "", "i", "Z", "isRecycled", "()Z", "e", "(Z)V", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends FeedEditorGlobalIntent {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private MsgIntent msgIntent;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Message msg;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private boolean isRecycled;

        public b() {
            super(null);
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final MsgIntent getMsgIntent() {
            return this.msgIntent;
        }

        public final void c() {
            if (this.isRecycled) {
                return;
            }
            this.msgIntent = null;
            Message message = this.msg;
            if (message != null) {
                message.recycle();
            }
            this.msg = null;
            FeedEditorGlobalIntent.f221961e.set(this);
            this.isRecycled = true;
        }

        public final void d(@Nullable MsgIntent msgIntent) {
            this.msgIntent = msgIntent;
        }

        public final void e(boolean z16) {
            this.isRecycled = z16;
        }
    }

    public /* synthetic */ FeedEditorGlobalIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    FeedEditorGlobalIntent() {
    }
}
