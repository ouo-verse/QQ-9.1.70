package com.tencent.mobileqq.matchfriend.aio.quote;

import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "OnQuoteStateChanged", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteEvent$OnQuoteStateChanged;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class QQStrangerQuoteEvent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteEvent$OnQuoteStateChanged;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteEvent;", "", "d", "Z", "getHasInit", "()Z", "hasInit", "e", "getShow", "show", "<init>", "(ZZ)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class OnQuoteStateChanged extends QQStrangerQuoteEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean hasInit;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean show;

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteEvent.OnQuoteStateChanged";
        }

        public OnQuoteStateChanged(boolean z16, boolean z17) {
            super(null);
            this.hasInit = z16;
            this.show = z17;
        }
    }

    public /* synthetic */ QQStrangerQuoteEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    QQStrangerQuoteEvent() {
    }
}
