package com.tencent.mobileqq.aio.notification;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u0000 \t2\u00020\u0001:\u0004\u0018\t\u0003\u0019R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nRN\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "b", "()Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "busiId", "", "getToken", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", "token", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "uiModel", "", "event", "", "getEventCallback", "()Lkotlin/jvm/functions/Function2;", "setEventCallback", "(Lkotlin/jvm/functions/Function2;)V", "eventCallback", "ActionIcon", "c", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface IAIONotificationUIModel {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;", "", "(Ljava/lang/String;I)V", "NONE", "ARROW", "CLICKABLE_ARROW", "CLOSE", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class ActionIcon {
        private static final /* synthetic */ ActionIcon[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ActionIcon ARROW;
        public static final ActionIcon CLICKABLE_ARROW;
        public static final ActionIcon CLOSE;
        public static final ActionIcon NONE;

        private static final /* synthetic */ ActionIcon[] $values() {
            return new ActionIcon[]{NONE, ARROW, CLICKABLE_ARROW, CLOSE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49691);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            NONE = new ActionIcon("NONE", 0);
            ARROW = new ActionIcon("ARROW", 1);
            CLICKABLE_ARROW = new ActionIcon("CLICKABLE_ARROW", 2);
            CLOSE = new ActionIcon("CLOSE", 3);
            $VALUES = $values();
        }

        ActionIcon(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ActionIcon valueOf(String str) {
            return (ActionIcon) Enum.valueOf(ActionIcon.class, str);
        }

        public static ActionIcon[] values() {
            return (ActionIcon[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0003\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$a;", "", "", "b", "I", "a", "()I", "(I)V", "tokenId", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.IAIONotificationUIModel$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f192782a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static int tokenId;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49695);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                f192782a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return tokenId;
        }

        public final void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                tokenId = i3;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u00018B\u0081\u0001\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020!\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\b\u0012:\b\u0002\u00106\u001a4\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010+\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\"\u0010&\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\"\u001a\u0004\b\u000f\u0010#\"\u0004\b$\u0010%R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b'\u0010\u0014R\"\u0010*\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b)\u0010\u001bRT\u00106\u001a4\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010+8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b$\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00109\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0010\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$c;", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "", "toString", "", "other", "", "equals", "", "hashCode", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "b", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "()Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "busiId", "c", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setHighLightText", "(Ljava/lang/String;)V", "highLightText", "d", "I", h.F, "()I", "setHighLightTextColor", "(I)V", "highLightTextColor", "e", "f", "k", "content", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;", "()Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;", "i", "(Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;)V", "actionIcon", "j", "actionText", "setActionTextColor", "actionTextColor", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "uiModel", "event", "", "Lkotlin/jvm/functions/Function2;", "getEventCallback", "()Lkotlin/jvm/functions/Function2;", "setEventCallback", "(Lkotlin/jvm/functions/Function2;)V", "eventCallback", "getToken", "a", "token", "<init>", "(Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;Ljava/lang/String;ILkotlin/jvm/functions/Function2;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class c implements IAIONotificationUIModel {
        static IPatchRedirector $redirector_;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIONotificationBusiId busiId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String highLightText;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int highLightTextColor;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String content;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ActionIcon actionIcon;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String actionText;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int actionTextColor;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function2<? super IAIONotificationUIModel, ? super Integer, Unit> eventCallback;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String token;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JX\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000428\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$c$a;", "", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "busiId", "", "highLightText", "content", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "Lkotlin/ParameterName;", "name", "uiModel", "", "event", "", "eventCallback", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$c;", "a", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.aio.notification.IAIONotificationUIModel$c$a, reason: from kotlin metadata */
        /* loaded from: classes11.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            @NotNull
            public final c a(@NotNull AIONotificationBusiId busiId, @NotNull String highLightText, @NotNull String content, @Nullable Function2<? super IAIONotificationUIModel, ? super Integer, Unit> eventCallback) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (c) iPatchRedirector.redirect((short) 2, this, busiId, highLightText, content, eventCallback);
                }
                Intrinsics.checkNotNullParameter(busiId, "busiId");
                Intrinsics.checkNotNullParameter(highLightText, "highLightText");
                Intrinsics.checkNotNullParameter(content, "content");
                return new c(busiId, highLightText, R.color.qui_common_feedback_error, content, ActionIcon.ARROW, "", R.color.qui_common_text_link, eventCallback);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49707);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 32)) {
                redirector.redirect((short) 32);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public c(@NotNull AIONotificationBusiId busiId, @NotNull String highLightText, int i3, @NotNull String content, @NotNull ActionIcon actionIcon, @NotNull String actionText, int i16, @Nullable Function2<? super IAIONotificationUIModel, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(busiId, "busiId");
            Intrinsics.checkNotNullParameter(highLightText, "highLightText");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(actionIcon, "actionIcon");
            Intrinsics.checkNotNullParameter(actionText, "actionText");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, busiId, highLightText, Integer.valueOf(i3), content, actionIcon, actionText, Integer.valueOf(i16), function2);
                return;
            }
            this.busiId = busiId;
            this.highLightText = highLightText;
            this.highLightTextColor = i3;
            this.content = content;
            this.actionIcon = actionIcon;
            this.actionText = actionText;
            this.actionTextColor = i16;
            this.eventCallback = function2;
            String tag = b().getTag();
            Companion companion = IAIONotificationUIModel.INSTANCE;
            int a16 = companion.a();
            companion.b(a16 + 1);
            this.token = tag + "-" + a16;
        }

        @Override // com.tencent.mobileqq.aio.notification.IAIONotificationUIModel
        public void a(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.token = str;
            }
        }

        @Override // com.tencent.mobileqq.aio.notification.IAIONotificationUIModel
        @NotNull
        public AIONotificationBusiId b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AIONotificationBusiId) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.busiId;
        }

        @NotNull
        public final ActionIcon c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (ActionIcon) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.actionIcon;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.actionText;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            return this.actionTextColor;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof c) && Intrinsics.areEqual(getToken(), ((c) other).getToken())) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.content;
        }

        @NotNull
        public final String g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.highLightText;
        }

        @Override // com.tencent.mobileqq.aio.notification.IAIONotificationUIModel
        @Nullable
        public Function2<IAIONotificationUIModel, Integer, Unit> getEventCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Function2) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return this.eventCallback;
        }

        @Override // com.tencent.mobileqq.aio.notification.IAIONotificationUIModel
        @NotNull
        public String getToken() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (String) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return this.token;
        }

        public final int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.highLightTextColor;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
            }
            return getToken().hashCode();
        }

        public final void i(@NotNull ActionIcon actionIcon) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) actionIcon);
            } else {
                Intrinsics.checkNotNullParameter(actionIcon, "<set-?>");
                this.actionIcon = actionIcon;
            }
        }

        public final void j(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.actionText = str;
            }
        }

        public final void k(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.content = str;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (String) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            return "TodoUIModel(token='" + getToken() + "', content='" + this.content + "')";
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(49709), (Class<?>) IAIONotificationUIModel.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f192782a;
        }
    }

    void a(@NotNull String str);

    @NotNull
    AIONotificationBusiId b();

    @Nullable
    Function2<IAIONotificationUIModel, Integer, Unit> getEventCallback();

    @NotNull
    String getToken();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\b\u0012:\b\u0002\u00104\u001a4\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u00010)\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0010\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0018\u0010 \"\u0004\b!\u0010\"R\"\u0010(\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010$\u001a\u0004\b\u001e\u0010%\"\u0004\b&\u0010'RT\u00104\u001a4\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u00010)8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00107\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$b;", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "", "toString", "", "other", "", "equals", "", "hashCode", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "b", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "()Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "busiId", "", "c", "Ljava/lang/CharSequence;", "f", "()Ljava/lang/CharSequence;", h.F, "(Ljava/lang/CharSequence;)V", "content", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;", "d", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;", "()Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;", "g", "(Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;)V", "actionIcon", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "actionText", "I", "()I", "setActionTextColor", "(I)V", "actionTextColor", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "uiModel", "event", "", "Lkotlin/jvm/functions/Function2;", "getEventCallback", "()Lkotlin/jvm/functions/Function2;", "setEventCallback", "(Lkotlin/jvm/functions/Function2;)V", "eventCallback", "getToken", "a", "token", "<init>", "(Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;Ljava/lang/CharSequence;Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;Ljava/lang/String;ILkotlin/jvm/functions/Function2;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class b implements IAIONotificationUIModel {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIONotificationBusiId busiId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private CharSequence content;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ActionIcon actionIcon;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String actionText;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int actionTextColor;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function2<? super IAIONotificationUIModel, ? super Integer, Unit> eventCallback;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String token;

        public b(@NotNull AIONotificationBusiId busiId, @NotNull CharSequence content, @NotNull ActionIcon actionIcon, @NotNull String actionText, int i3, @Nullable Function2<? super IAIONotificationUIModel, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(busiId, "busiId");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(actionIcon, "actionIcon");
            Intrinsics.checkNotNullParameter(actionText, "actionText");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, busiId, content, actionIcon, actionText, Integer.valueOf(i3), function2);
                return;
            }
            this.busiId = busiId;
            this.content = content;
            this.actionIcon = actionIcon;
            this.actionText = actionText;
            this.actionTextColor = i3;
            this.eventCallback = function2;
            String tag = b().getTag();
            Companion companion = IAIONotificationUIModel.INSTANCE;
            int a16 = companion.a();
            companion.b(a16 + 1);
            this.token = tag + "-" + a16;
        }

        @Override // com.tencent.mobileqq.aio.notification.IAIONotificationUIModel
        public void a(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.token = str;
            }
        }

        @Override // com.tencent.mobileqq.aio.notification.IAIONotificationUIModel
        @NotNull
        public AIONotificationBusiId b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AIONotificationBusiId) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.busiId;
        }

        @NotNull
        public final ActionIcon c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ActionIcon) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.actionIcon;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.actionText;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.actionTextColor;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof b) && Intrinsics.areEqual(getToken(), ((b) other).getToken())) {
                return true;
            }
            return false;
        }

        @NotNull
        public final CharSequence f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.content;
        }

        public final void g(@NotNull ActionIcon actionIcon) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) actionIcon);
            } else {
                Intrinsics.checkNotNullParameter(actionIcon, "<set-?>");
                this.actionIcon = actionIcon;
            }
        }

        @Override // com.tencent.mobileqq.aio.notification.IAIONotificationUIModel
        @Nullable
        public Function2<IAIONotificationUIModel, Integer, Unit> getEventCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Function2) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.eventCallback;
        }

        @Override // com.tencent.mobileqq.aio.notification.IAIONotificationUIModel
        @NotNull
        public String getToken() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return this.token;
        }

        public final void h(@NotNull CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) charSequence);
            } else {
                Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
                this.content = charSequence;
            }
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
            }
            return getToken().hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (String) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return "SimpleUIModel(token='" + getToken() + "', content='" + ((Object) this.content) + "')";
        }

        public /* synthetic */ b(AIONotificationBusiId aIONotificationBusiId, CharSequence charSequence, ActionIcon actionIcon, String str, int i3, Function2 function2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(aIONotificationBusiId, charSequence, (i16 & 4) != 0 ? ActionIcon.NONE : actionIcon, (i16 & 8) != 0 ? "" : str, (i16 & 16) != 0 ? 0 : i3, (i16 & 32) != 0 ? null : function2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, aIONotificationBusiId, charSequence, actionIcon, str, Integer.valueOf(i3), function2, Integer.valueOf(i16), defaultConstructorMarker);
        }
    }
}
