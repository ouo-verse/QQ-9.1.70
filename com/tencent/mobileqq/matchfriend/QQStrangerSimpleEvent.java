package com.tencent.mobileqq.matchfriend;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/QQStrangerSimpleEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "QQStrangerOnMsgSentEvent", "Lcom/tencent/mobileqq/matchfriend/QQStrangerSimpleEvent$QQStrangerOnMsgSentEvent;", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public abstract class QQStrangerSimpleEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/QQStrangerSimpleEvent$QQStrangerOnMsgSentEvent;", "Lcom/tencent/mobileqq/matchfriend/QQStrangerSimpleEvent;", "tinyId", "", "isSuccess", "", "(JZ)V", "()Z", "getTinyId", "()J", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class QQStrangerOnMsgSentEvent extends QQStrangerSimpleEvent {
        static IPatchRedirector $redirector_;
        private final boolean isSuccess;
        private final long tinyId;

        public QQStrangerOnMsgSentEvent(long j3, boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Boolean.valueOf(z16));
            } else {
                this.tinyId = j3;
                this.isSuccess = z16;
            }
        }

        public final long getTinyId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.tinyId;
        }

        public final boolean isSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isSuccess;
        }
    }

    public /* synthetic */ QQStrangerSimpleEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    QQStrangerSimpleEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
