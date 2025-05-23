package com.tencent.qqnt.aio.assistedchat.panel.subpanel;

import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "()V", "OnInputContentChangedState", "RequestRecommendsFailUIState", "UpdatePromptListUIState", "UpdateRecommendsUIState", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState$OnInputContentChangedState;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState$RequestRecommendsFailUIState;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState$UpdatePromptListUIState;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState$UpdateRecommendsUIState;", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public abstract class AssistedChatSubPanelUIState implements PanelUIState {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState$OnInputContentChangedState;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "content", "<init>", "(Ljava/lang/String;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class OnInputContentChangedState extends AssistedChatSubPanelUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnInputContentChangedState(@NotNull String content) {
            super(null);
            Intrinsics.checkNotNullParameter(content, "content");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) content);
            } else {
                this.content = content;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.content;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState$RequestRecommendsFailUIState;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState;", "", "d", "I", "a", "()I", "bizErrCode", "", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "e", "Ljava/util/List;", "b", "()Ljava/util/List;", "recommends", "", "f", "Z", "c", "()Z", "isRefresh", "<init>", "(ILjava/util/List;Z)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class RequestRecommendsFailUIState extends AssistedChatSubPanelUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int bizErrCode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.qqnt.aio.assistedchat.model.c> recommends;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean isRefresh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestRecommendsFailUIState(int i3, @NotNull List<com.tencent.qqnt.aio.assistedchat.model.c> recommends, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(recommends, "recommends");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), recommends, Boolean.valueOf(z16));
                return;
            }
            this.bizErrCode = i3;
            this.recommends = recommends;
            this.isRefresh = z16;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.bizErrCode;
        }

        @NotNull
        public final List<com.tencent.qqnt.aio.assistedchat.model.c> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.recommends;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.isRefresh;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState$UpdatePromptListUIState;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState;", "", "Lcom/tencent/qqnt/aio/assistedchat/model/a;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "promptList", "<init>", "(Ljava/util/List;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class UpdatePromptListUIState extends AssistedChatSubPanelUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.qqnt.aio.assistedchat.model.a> promptList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdatePromptListUIState(@NotNull List<com.tencent.qqnt.aio.assistedchat.model.a> promptList) {
            super(null);
            Intrinsics.checkNotNullParameter(promptList, "promptList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) promptList);
            } else {
                this.promptList = promptList;
            }
        }

        @NotNull
        public final List<com.tencent.qqnt.aio.assistedchat.model.a> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.promptList;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState$UpdateRecommendsUIState;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState;", "", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "recommends", "", "e", "Z", "c", "()Z", "isRefresh", "f", "a", "hasMore", "", tl.h.F, "Ljava/lang/String;", "getGuide", "()Ljava/lang/String;", "guide", "<init>", "(Ljava/util/List;ZZLjava/lang/String;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class UpdateRecommendsUIState extends AssistedChatSubPanelUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.qqnt.aio.assistedchat.model.c> recommends;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isRefresh;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean hasMore;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guide;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateRecommendsUIState(@NotNull List<com.tencent.qqnt.aio.assistedchat.model.c> recommends, boolean z16, boolean z17, @NotNull String guide) {
            super(null);
            Intrinsics.checkNotNullParameter(recommends, "recommends");
            Intrinsics.checkNotNullParameter(guide, "guide");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, recommends, Boolean.valueOf(z16), Boolean.valueOf(z17), guide);
                return;
            }
            this.recommends = recommends;
            this.isRefresh = z16;
            this.hasMore = z17;
            this.guide = guide;
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.hasMore;
        }

        @NotNull
        public final List<com.tencent.qqnt.aio.assistedchat.model.c> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.recommends;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.isRefresh;
        }
    }

    public /* synthetic */ AssistedChatSubPanelUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    AssistedChatSubPanelUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
