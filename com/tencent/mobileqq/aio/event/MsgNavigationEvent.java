package com.tencent.mobileqq.aio.event;

import com.tencent.mobileqq.aio.msg.MsgSimpleInfo;
import com.tencent.mobileqq.aio.reserve1.navigation.AIONavType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "ClickNavigationEvent", "NavigateByIdEvent", "NavigateBySeqEvent", "NavigateByTimeEvent", "NavigateForMultiForward", "NavigateToBottomEvent", "NavigationNotify", "NavigationResultNotify", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$ClickNavigationEvent;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateByIdEvent;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateBySeqEvent;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateByTimeEvent;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateForMultiForward;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateToBottomEvent;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigationNotify;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigationResultNotify;", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public abstract class MsgNavigationEvent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$ClickNavigationEvent;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class ClickNavigationEvent extends MsgNavigationEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ClickNavigationEvent f188632d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46135);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f188632d = new ClickNavigationEvent();
            }
        }

        ClickNavigationEvent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgNavigationEvent.ClickNavigationEvent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\"\u001a\u00020\b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u0019\u0010(\u001a\u0004\u0018\u00010#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateByIdEvent;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "source", "", "e", "J", "a", "()J", "msgId", "f", "Z", "b", "()Z", "needFlush", "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", tl.h.F, "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "getNavType", "()Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "navType", "i", "c", "orderDown", "Lcom/tencent/mobileqq/aio/msg/MsgSimpleInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msg/MsgSimpleInfo;", "getReplyMsgInfo", "()Lcom/tencent/mobileqq/aio/msg/MsgSimpleInfo;", "replyMsgInfo", "<init>", "(Ljava/lang/String;JZLcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;ZLcom/tencent/mobileqq/aio/msg/MsgSimpleInfo;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class NavigateByIdEvent extends MsgNavigationEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long msgId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean needFlush;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final AIONavType navType;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final boolean orderDown;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final MsgSimpleInfo replyMsgInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateByIdEvent(@NotNull String source, long j3, boolean z16, @Nullable AIONavType aIONavType, boolean z17, @Nullable MsgSimpleInfo msgSimpleInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, source, Long.valueOf(j3), Boolean.valueOf(z16), aIONavType, Boolean.valueOf(z17), msgSimpleInfo);
                return;
            }
            this.source = source;
            this.msgId = j3;
            this.needFlush = z16;
            this.navType = aIONavType;
            this.orderDown = z17;
            this.replyMsgInfo = msgSimpleInfo;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.msgId;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.needFlush;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.orderDown;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavigateByIdEvent)) {
                return false;
            }
            NavigateByIdEvent navigateByIdEvent = (NavigateByIdEvent) other;
            if (Intrinsics.areEqual(this.source, navigateByIdEvent.source) && this.msgId == navigateByIdEvent.msgId && this.needFlush == navigateByIdEvent.needFlush && this.navType == navigateByIdEvent.navType && this.orderDown == navigateByIdEvent.orderDown && Intrinsics.areEqual(this.replyMsgInfo, navigateByIdEvent.replyMsgInfo)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (String) iPatchRedirector.redirect((short) 19, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigateByIdEvent";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
            }
            int hashCode2 = ((this.source.hashCode() * 31) + androidx.fragment.app.a.a(this.msgId)) * 31;
            boolean z16 = this.needFlush;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode2 + i16) * 31;
            AIONavType aIONavType = this.navType;
            int i18 = 0;
            if (aIONavType == null) {
                hashCode = 0;
            } else {
                hashCode = aIONavType.hashCode();
            }
            int i19 = (i17 + hashCode) * 31;
            boolean z17 = this.orderDown;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            int i26 = (i19 + i3) * 31;
            MsgSimpleInfo msgSimpleInfo = this.replyMsgInfo;
            if (msgSimpleInfo != null) {
                i18 = msgSimpleInfo.hashCode();
            }
            return i26 + i18;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (String) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return "NavigateByIdEvent(source=" + this.source + ", msgId=" + this.msgId + ", needFlush=" + this.needFlush + ", navType=" + this.navType + ", orderDown=" + this.orderDown + ", replyMsgInfo=" + this.replyMsgInfo + ")";
        }

        public /* synthetic */ NavigateByIdEvent(String str, long j3, boolean z16, AIONavType aIONavType, boolean z17, MsgSimpleInfo msgSimpleInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j3, (i3 & 4) != 0 ? true : z16, (i3 & 8) != 0 ? null : aIONavType, (i3 & 16) != 0 ? false : z17, (i3 & 32) != 0 ? null : msgSimpleInfo);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Boolean.valueOf(z16), aIONavType, Boolean.valueOf(z17), msgSimpleInfo, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010&\u001a\u00020\b\u0012\b\b\u0002\u0010(\u001a\u00020\b\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\b/\u00100J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\n\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\"\u0004\b$\u0010%R\u0017\u0010(\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b\u0015\u0010\u0019R\u0019\u0010.\u001a\u0004\u0018\u00010)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateBySeqEvent;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "source", "", "e", "J", "b", "()J", "msgSeq", "f", "a", "msgId", "Z", "()Z", "needFlush", "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "i", "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "c", "()Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "setNavType", "(Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;)V", "navType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setNeedSelect", "(Z)V", "needSelect", BdhLogUtil.LogTag.Tag_Conn, "orderDown", "Lcom/tencent/mobileqq/aio/msg/MsgSimpleInfo;", "D", "Lcom/tencent/mobileqq/aio/msg/MsgSimpleInfo;", "g", "()Lcom/tencent/mobileqq/aio/msg/MsgSimpleInfo;", "replyMsgInfo", "<init>", "(Ljava/lang/String;JJZLcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;ZZLcom/tencent/mobileqq/aio/msg/MsgSimpleInfo;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class NavigateBySeqEvent extends MsgNavigationEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        private final boolean orderDown;

        /* renamed from: D, reason: from kotlin metadata */
        @Nullable
        private final MsgSimpleInfo replyMsgInfo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long msgSeq;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long msgId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final boolean needFlush;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private AIONavType navType;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private boolean needSelect;

        public /* synthetic */ NavigateBySeqEvent(String str, long j3, long j16, boolean z16, AIONavType aIONavType, boolean z17, boolean z18, MsgSimpleInfo msgSimpleInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j3, (i3 & 4) != 0 ? 0L : j16, (i3 & 8) != 0 ? true : z16, (i3 & 16) != 0 ? null : aIONavType, (i3 & 32) != 0 ? false : z17, (i3 & 64) != 0 ? false : z18, (i3 & 128) != 0 ? null : msgSimpleInfo);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), aIONavType, Boolean.valueOf(z17), Boolean.valueOf(z18), msgSimpleInfo, Integer.valueOf(i3), defaultConstructorMarker);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.msgId;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.msgSeq;
        }

        @Nullable
        public final AIONavType c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (AIONavType) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.navType;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.needFlush;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            return this.needSelect;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavigateBySeqEvent)) {
                return false;
            }
            NavigateBySeqEvent navigateBySeqEvent = (NavigateBySeqEvent) other;
            if (Intrinsics.areEqual(this.source, navigateBySeqEvent.source) && this.msgSeq == navigateBySeqEvent.msgSeq && this.msgId == navigateBySeqEvent.msgId && this.needFlush == navigateBySeqEvent.needFlush && this.navType == navigateBySeqEvent.navType && this.needSelect == navigateBySeqEvent.needSelect && this.orderDown == navigateBySeqEvent.orderDown && Intrinsics.areEqual(this.replyMsgInfo, navigateBySeqEvent.replyMsgInfo)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (String) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigateBySeqEvent";
        }

        public final boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
            }
            return this.orderDown;
        }

        @Nullable
        public final MsgSimpleInfo g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (MsgSimpleInfo) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.replyMsgInfo;
        }

        @NotNull
        public final String h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.source;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
            }
            int hashCode2 = ((((this.source.hashCode() * 31) + androidx.fragment.app.a.a(this.msgSeq)) * 31) + androidx.fragment.app.a.a(this.msgId)) * 31;
            boolean z16 = this.needFlush;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode2 + i16) * 31;
            AIONavType aIONavType = this.navType;
            int i18 = 0;
            if (aIONavType == null) {
                hashCode = 0;
            } else {
                hashCode = aIONavType.hashCode();
            }
            int i19 = (i17 + hashCode) * 31;
            boolean z17 = this.needSelect;
            int i26 = z17;
            if (z17 != 0) {
                i26 = 1;
            }
            int i27 = (i19 + i26) * 31;
            boolean z18 = this.orderDown;
            if (!z18) {
                i3 = z18 ? 1 : 0;
            }
            int i28 = (i27 + i3) * 31;
            MsgSimpleInfo msgSimpleInfo = this.replyMsgInfo;
            if (msgSimpleInfo != null) {
                i18 = msgSimpleInfo.hashCode();
            }
            return i28 + i18;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (String) iPatchRedirector.redirect((short) 22, (Object) this);
            }
            return "NavigateBySeqEvent(source=" + this.source + ", msgSeq=" + this.msgSeq + ", msgId=" + this.msgId + ", needFlush=" + this.needFlush + ", navType=" + this.navType + ", needSelect=" + this.needSelect + ", orderDown=" + this.orderDown + ", replyMsgInfo=" + this.replyMsgInfo + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateBySeqEvent(@NotNull String source, long j3, long j16, boolean z16, @Nullable AIONavType aIONavType, boolean z17, boolean z18, @Nullable MsgSimpleInfo msgSimpleInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, source, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), aIONavType, Boolean.valueOf(z17), Boolean.valueOf(z18), msgSimpleInfo);
                return;
            }
            this.source = source;
            this.msgSeq = j3;
            this.msgId = j16;
            this.needFlush = z16;
            this.navType = aIONavType;
            this.needSelect = z17;
            this.orderDown = z18;
            this.replyMsgInfo = msgSimpleInfo;
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\n\u0010\u0019R\u0019\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateByTimeEvent;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "source", "", "J", "a", "()J", "clientSeq", "f", "b", "msgTime", tl.h.F, "Z", "()Z", "needFlush", "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "i", "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "c", "()Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "navType", "<init>", "(Ljava/lang/String;JJZLcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class NavigateByTimeEvent extends MsgNavigationEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long clientSeq;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long msgTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final boolean needFlush;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final AIONavType navType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateByTimeEvent(@NotNull String source, long j3, long j16, boolean z16, @Nullable AIONavType aIONavType) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, source, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), aIONavType);
                return;
            }
            this.source = source;
            this.clientSeq = j3;
            this.msgTime = j16;
            this.needFlush = z16;
            this.navType = aIONavType;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.clientSeq;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.msgTime;
        }

        @Nullable
        public final AIONavType c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (AIONavType) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.navType;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.needFlush;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.source;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavigateByTimeEvent)) {
                return false;
            }
            NavigateByTimeEvent navigateByTimeEvent = (NavigateByTimeEvent) other;
            if (Intrinsics.areEqual(this.source, navigateByTimeEvent.source) && this.clientSeq == navigateByTimeEvent.clientSeq && this.msgTime == navigateByTimeEvent.msgTime && this.needFlush == navigateByTimeEvent.needFlush && this.navType == navigateByTimeEvent.navType) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (String) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigateByTimeEvent";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            int hashCode2 = ((((this.source.hashCode() * 31) + androidx.fragment.app.a.a(this.clientSeq)) * 31) + androidx.fragment.app.a.a(this.msgTime)) * 31;
            boolean z16 = this.needFlush;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode2 + i3) * 31;
            AIONavType aIONavType = this.navType;
            if (aIONavType == null) {
                hashCode = 0;
            } else {
                hashCode = aIONavType.hashCode();
            }
            return i16 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "NavigateByTimeEvent(source=" + this.source + ", clientSeq=" + this.clientSeq + ", msgTime=" + this.msgTime + ", needFlush=" + this.needFlush + ", navType=" + this.navType + ")";
        }

        public /* synthetic */ NavigateByTimeEvent(String str, long j3, long j16, boolean z16, AIONavType aIONavType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j3, j16, (i3 & 8) != 0 ? true : z16, (i3 & 16) != 0 ? null : aIONavType);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), aIONavType, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateForMultiForward;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "clientSeq", "e", "c", "msgTime", "f", "b", "msgSeq", "<init>", "(JJJ)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class NavigateForMultiForward extends MsgNavigationEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long clientSeq;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long msgTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long msgSeq;

        public NavigateForMultiForward(long j3, long j16, long j17) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
                return;
            }
            this.clientSeq = j3;
            this.msgTime = j16;
            this.msgSeq = j17;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.clientSeq;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.msgSeq;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.msgTime;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavigateForMultiForward)) {
                return false;
            }
            NavigateForMultiForward navigateForMultiForward = (NavigateForMultiForward) other;
            if (this.clientSeq == navigateForMultiForward.clientSeq && this.msgTime == navigateForMultiForward.msgTime && this.msgSeq == navigateForMultiForward.msgSeq) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigateForMultiForward";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((androidx.fragment.app.a.a(this.clientSeq) * 31) + androidx.fragment.app.a.a(this.msgTime)) * 31) + androidx.fragment.app.a.a(this.msgSeq);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "NavigateForMultiForward(clientSeq=" + this.clientSeq + ", msgTime=" + this.msgTime + ", msgSeq=" + this.msgSeq + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateToBottomEvent;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "source", "<init>", "(Ljava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class NavigateToBottomEvent extends MsgNavigationEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToBottomEvent(@NotNull String source) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) source);
            } else {
                this.source = source;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof NavigateToBottomEvent) && Intrinsics.areEqual(this.source, ((NavigateToBottomEvent) other).source)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigateToBottomEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.source.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "NavigateToBottomEvent(source=" + this.source + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigationNotify;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class NavigationNotify extends MsgNavigationEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final NavigationNotify f188654d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46716);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f188654d = new NavigationNotify();
            }
        }

        NavigationNotify() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigationNotify";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigationResultNotify;", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "c", "()Z", "isSuccess", "", "e", "J", "a", "()J", "msgSeq", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateBySeqEvent;", "f", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateBySeqEvent;", "b", "()Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateBySeqEvent;", "setSourceEvent", "(Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateBySeqEvent;)V", "sourceEvent", "<init>", "(ZJLcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateBySeqEvent;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class NavigationResultNotify extends MsgNavigationEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long msgSeq;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private NavigateBySeqEvent sourceEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigationResultNotify(boolean z16, long j3, @NotNull NavigateBySeqEvent sourceEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Long.valueOf(j3), sourceEvent);
                return;
            }
            this.isSuccess = z16;
            this.msgSeq = j3;
            this.sourceEvent = sourceEvent;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.msgSeq;
        }

        @NotNull
        public final NavigateBySeqEvent b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (NavigateBySeqEvent) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.sourceEvent;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isSuccess;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavigationResultNotify)) {
                return false;
            }
            NavigationResultNotify navigationResultNotify = (NavigationResultNotify) other;
            if (this.isSuccess == navigationResultNotify.isSuccess && this.msgSeq == navigationResultNotify.msgSeq && Intrinsics.areEqual(this.sourceEvent, navigationResultNotify.sourceEvent)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigationResultNotify";
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + androidx.fragment.app.a.a(this.msgSeq)) * 31) + this.sourceEvent.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "NavigationResultNotify(isSuccess=" + this.isSuccess + ", msgSeq=" + this.msgSeq + ", sourceEvent=" + this.sourceEvent + ")";
        }
    }

    public /* synthetic */ MsgNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }

    MsgNavigationEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
