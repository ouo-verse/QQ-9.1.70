package com.tencent.mobileqq.matchfriend.aio.quote;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/d;", "Lol3/b;", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/mobileqq/matchfriend/aio/quote/d$a;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/d$b;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/d$c;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/d$d;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class d implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/d$a;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/d;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a extends d {

        /* renamed from: d, reason: collision with root package name */
        public static final a f243953d = new a();

        a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/d$b;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/d;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends d {

        /* renamed from: d, reason: collision with root package name */
        public static final b f243954d = new b();

        b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/d$c;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/d;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/c;", "d", "Lcom/tencent/mobileqq/matchfriend/aio/quote/c;", "b", "()Lcom/tencent/mobileqq/matchfriend/aio/quote/c;", "data", "Lcom/tencent/mobileqq/matchfriend/aio/quote/a;", "e", "Lcom/tencent/mobileqq/matchfriend/aio/quote/a;", "a", "()Lcom/tencent/mobileqq/matchfriend/aio/quote/a;", "action", "<init>", "(Lcom/tencent/mobileqq/matchfriend/aio/quote/c;Lcom/tencent/mobileqq/matchfriend/aio/quote/a;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c extends d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final QQStrangerQuoteData data;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final QQStrangerQuoteAction action;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(QQStrangerQuoteData data, QQStrangerQuoteAction action) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(action, "action");
            this.data = data;
            this.action = action;
        }

        /* renamed from: a, reason: from getter */
        public final QQStrangerQuoteAction getAction() {
            return this.action;
        }

        /* renamed from: b, reason: from getter */
        public final QQStrangerQuoteData getData() {
            return this.data;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/d$d;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/d;", "", "d", "Z", "a", "()Z", "clip", "", "e", "I", "b", "()I", "padding", "<init>", "(ZI)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.aio.quote.d$d, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static final class C8004d extends d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean clip;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int padding;

        /* renamed from: a, reason: from getter */
        public final boolean getClip() {
            return this.clip;
        }

        /* renamed from: b, reason: from getter */
        public final int getPadding() {
            return this.padding;
        }

        public C8004d(boolean z16, int i3) {
            super(null);
            this.clip = z16;
            this.padding = i3;
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    d() {
    }
}
