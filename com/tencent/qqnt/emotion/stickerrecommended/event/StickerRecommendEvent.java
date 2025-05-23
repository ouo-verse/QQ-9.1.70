package com.tencent.qqnt.emotion.stickerrecommended.event;

import androidx.fragment.app.a;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.msg.data.g;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "CancelHideEmotionKeywordLayout", "HideEmotionKeywordLayout", "OnShowOrHideEmotionKeywordLayout", "SendMarketFace", "SendSticker", "ShowEmotionKeywordLayout", "TriggerShowEmotionKeywordLayout", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$CancelHideEmotionKeywordLayout;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$HideEmotionKeywordLayout;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$OnShowOrHideEmotionKeywordLayout;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$SendMarketFace;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$SendSticker;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$ShowEmotionKeywordLayout;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$TriggerShowEmotionKeywordLayout;", "emotion_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public abstract class StickerRecommendEvent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$CancelHideEmotionKeywordLayout;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent;", "()V", "emotion_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class CancelHideEmotionKeywordLayout extends StickerRecommendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final CancelHideEmotionKeywordLayout f356518d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38901);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f356518d = new CancelHideEmotionKeywordLayout();
            }
        }

        CancelHideEmotionKeywordLayout() {
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
            return "com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.CancelHideEmotionKeywordLayout";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$HideEmotionKeywordLayout;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "delayTimeInMillis", "<init>", "(J)V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class HideEmotionKeywordLayout extends StickerRecommendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long delayTimeInMillis;

        public HideEmotionKeywordLayout() {
            this(0L, 1, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.delayTimeInMillis;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof HideEmotionKeywordLayout) && this.delayTimeInMillis == ((HideEmotionKeywordLayout) other).delayTimeInMillis) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.HideEmotionKeywordLayout";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return a.a(this.delayTimeInMillis);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return "HideEmotionKeywordLayout(delayTimeInMillis=" + this.delayTimeInMillis + ")";
        }

        public HideEmotionKeywordLayout(long j3) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.delayTimeInMillis = j3;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, j3);
            }
        }

        public /* synthetic */ HideEmotionKeywordLayout(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$OnShowOrHideEmotionKeywordLayout;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "getShowEmotionKeyword", "()Z", "showEmotionKeyword", "<init>", "(Z)V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class OnShowOrHideEmotionKeywordLayout extends StickerRecommendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean showEmotionKeyword;

        public OnShowOrHideEmotionKeywordLayout(boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.showEmotionKeyword = z16;
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
            if ((other instanceof OnShowOrHideEmotionKeywordLayout) && this.showEmotionKeyword == ((OnShowOrHideEmotionKeywordLayout) other).showEmotionKeyword) {
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
            return "com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.OnShowOrHideEmotionKeywordLayout";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            boolean z16 = this.showEmotionKeyword;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "OnShowOrHideEmotionKeywordLayout(showEmotionKeyword=" + this.showEmotionKeyword + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$SendMarketFace;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "d", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "a", "()Lcom/tencent/mobileqq/data/MarkFaceMessage;", "marketFaceMessage", "<init>", "(Lcom/tencent/mobileqq/data/MarkFaceMessage;)V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class SendMarketFace extends StickerRecommendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MarkFaceMessage marketFaceMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendMarketFace(@NotNull MarkFaceMessage marketFaceMessage) {
            super(null);
            Intrinsics.checkNotNullParameter(marketFaceMessage, "marketFaceMessage");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) marketFaceMessage);
            } else {
                this.marketFaceMessage = marketFaceMessage;
            }
        }

        @NotNull
        public final MarkFaceMessage a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MarkFaceMessage) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.marketFaceMessage;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof SendMarketFace) && Intrinsics.areEqual(this.marketFaceMessage, ((SendMarketFace) other).marketFaceMessage)) {
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
            return "com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.SendMarketFace";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.marketFaceMessage.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SendMarketFace(marketFaceMessage=" + this.marketFaceMessage + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\n\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$SendSticker;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "filePath", "e", "b", "keyword", "Lcom/tencent/qqnt/msg/data/g;", "f", "Lcom/tencent/qqnt/msg/data/g;", "()Lcom/tencent/qqnt/msg/data/g;", "setPicExtBizInfo", "(Lcom/tencent/qqnt/msg/data/g;)V", "picExtBizInfo", h.F, "c", "setOriginalMd5", "(Ljava/lang/String;)V", "originalMd5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqnt/msg/data/g;Ljava/lang/String;)V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class SendSticker extends StickerRecommendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String filePath;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String keyword;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private g picExtBizInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String originalMd5;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public SendSticker(@NotNull String filePath, @Nullable String str, @Nullable g gVar) {
            this(filePath, str, gVar, null, 8, null);
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
                return;
            }
            iPatchRedirector.redirect((short) 17, this, filePath, str, gVar);
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.filePath;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.keyword;
        }

        @Nullable
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.originalMd5;
        }

        @Nullable
        public final g d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (g) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.picExtBizInfo;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendSticker)) {
                return false;
            }
            SendSticker sendSticker = (SendSticker) other;
            if (Intrinsics.areEqual(this.filePath, sendSticker.filePath) && Intrinsics.areEqual(this.keyword, sendSticker.keyword) && Intrinsics.areEqual(this.picExtBizInfo, sendSticker.picExtBizInfo) && Intrinsics.areEqual(this.originalMd5, sendSticker.originalMd5)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (String) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            return "com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.SendSticker";
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            int hashCode3 = this.filePath.hashCode() * 31;
            String str = this.keyword;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode3 + hashCode) * 31;
            g gVar = this.picExtBizInfo;
            if (gVar == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = gVar.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.originalMd5;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "SendSticker(filePath=" + this.filePath + ", keyword=" + this.keyword + ", picExtBizInfo=" + this.picExtBizInfo + ", originalMd5=" + this.originalMd5 + ")";
        }

        public /* synthetic */ SendSticker(String str, String str2, g gVar, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : gVar, (i3 & 8) == 0 ? str3 : null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, str2, gVar, str3, Integer.valueOf(i3), defaultConstructorMarker);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public SendSticker(@NotNull String filePath, @Nullable String str, @Nullable g gVar, @Nullable String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, filePath, str, gVar, str2);
                return;
            }
            this.filePath = filePath;
            this.keyword = str;
            this.picExtBizInfo = gVar;
            this.originalMd5 = str2;
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$ShowEmotionKeywordLayout;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "title", "<init>", "(Ljava/lang/String;)V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class ShowEmotionKeywordLayout extends StickerRecommendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String title;

        public ShowEmotionKeywordLayout(@Nullable String str) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.title = str;
            }
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.title;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof ShowEmotionKeywordLayout) && Intrinsics.areEqual(this.title, ((ShowEmotionKeywordLayout) other).title)) {
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
            return "com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.ShowEmotionKeywordLayout";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            String str = this.title;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "ShowEmotionKeywordLayout(title=" + this.title + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent$TriggerShowEmotionKeywordLayout;", "Lcom/tencent/qqnt/emotion/stickerrecommended/event/StickerRecommendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "keyword", "e", "Z", "a", "()Z", "ignoreSwitch", "<init>", "(Ljava/lang/String;Z)V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class TriggerShowEmotionKeywordLayout extends StickerRecommendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String keyword;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean ignoreSwitch;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TriggerShowEmotionKeywordLayout(@NotNull String keyword, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, keyword, Boolean.valueOf(z16));
            } else {
                this.keyword = keyword;
                this.ignoreSwitch = z16;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.ignoreSwitch;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.keyword;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof TriggerShowEmotionKeywordLayout)) {
                return false;
            }
            TriggerShowEmotionKeywordLayout triggerShowEmotionKeywordLayout = (TriggerShowEmotionKeywordLayout) other;
            if (Intrinsics.areEqual(this.keyword, triggerShowEmotionKeywordLayout.keyword) && this.ignoreSwitch == triggerShowEmotionKeywordLayout.ignoreSwitch) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.TriggerShowEmotionKeywordLayout";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            int hashCode = this.keyword.hashCode() * 31;
            boolean z16 = this.ignoreSwitch;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "TriggerShowEmotionKeywordLayout(keyword=" + this.keyword + ", ignoreSwitch=" + this.ignoreSwitch + ")";
        }
    }

    public /* synthetic */ StickerRecommendEvent(DefaultConstructorMarker defaultConstructorMarker) {
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

    StickerRecommendEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
