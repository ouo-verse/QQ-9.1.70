package com.tencent.mobileqq.guild.main.view;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/main/view/a;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/mobileqq/guild/main/view/a$a;", "Lcom/tencent/mobileqq/guild/main/view/a$b;", "Lcom/tencent/mobileqq/guild/main/view/a$c;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/main/view/a$a;", "Lcom/tencent/mobileqq/guild/main/view/a;", "", "a", "I", "b", "()I", "lottieResource", "c", "tipsResource", "Lcom/tencent/mobileqq/guild/main/view/BackgroundColor;", "Lcom/tencent/mobileqq/guild/main/view/BackgroundColor;", "()Lcom/tencent/mobileqq/guild/main/view/BackgroundColor;", "backgroundColor", "<init>", "(IILcom/tencent/mobileqq/guild/main/view/BackgroundColor;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.main.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C7822a extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int lottieResource;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int tipsResource;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final BackgroundColor backgroundColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7822a(int i3, int i16, @NotNull BackgroundColor backgroundColor) {
            super(null);
            Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
            this.lottieResource = i3;
            this.tipsResource = i16;
            this.backgroundColor = backgroundColor;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final BackgroundColor getBackgroundColor() {
            return this.backgroundColor;
        }

        /* renamed from: b, reason: from getter */
        public final int getLottieResource() {
            return this.lottieResource;
        }

        /* renamed from: c, reason: from getter */
        public final int getTipsResource() {
            return this.tipsResource;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/main/view/a$b;", "Lcom/tencent/mobileqq/guild/main/view/a;", "", "a", "I", "b", "()I", "iconResource", "c", "tipsResource", "Lcom/tencent/mobileqq/guild/main/view/BackgroundColor;", "Lcom/tencent/mobileqq/guild/main/view/BackgroundColor;", "()Lcom/tencent/mobileqq/guild/main/view/BackgroundColor;", "backgroundColor", "<init>", "(IILcom/tencent/mobileqq/guild/main/view/BackgroundColor;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int iconResource;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int tipsResource;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final BackgroundColor backgroundColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i3, int i16, @NotNull BackgroundColor backgroundColor) {
            super(null);
            Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
            this.iconResource = i3;
            this.tipsResource = i16;
            this.backgroundColor = backgroundColor;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final BackgroundColor getBackgroundColor() {
            return this.backgroundColor;
        }

        /* renamed from: b, reason: from getter */
        public final int getIconResource() {
            return this.iconResource;
        }

        /* renamed from: c, reason: from getter */
        public final int getTipsResource() {
            return this.tipsResource;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/main/view/a$c;", "Lcom/tencent/mobileqq/guild/main/view/a;", "", "a", "Z", "c", "()Z", "specifiedInactiveIcon", "", "b", "I", "()I", "channelType", "channelSubId", "<init>", "(ZII)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean specifiedInactiveIcon;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int channelType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int channelSubId;

        public c(boolean z16, int i3, int i16) {
            super(null);
            this.specifiedInactiveIcon = z16;
            this.channelType = i3;
            this.channelSubId = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getChannelSubId() {
            return this.channelSubId;
        }

        /* renamed from: b, reason: from getter */
        public final int getChannelType() {
            return this.channelType;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getSpecifiedInactiveIcon() {
            return this.specifiedInactiveIcon;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
