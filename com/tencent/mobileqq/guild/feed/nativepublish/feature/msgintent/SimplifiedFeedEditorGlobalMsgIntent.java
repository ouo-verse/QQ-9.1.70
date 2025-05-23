package com.tencent.mobileqq.guild.feed.nativepublish.feature.msgintent;

import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "ChangeDisplayMode", "HideAllPanelAndKeyboard", "OverwriteCloseIntent", "RestoreCloseIntent", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent$ChangeDisplayMode;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent$HideAllPanelAndKeyboard;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent$OverwriteCloseIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent$RestoreCloseIntent;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public abstract class SimplifiedFeedEditorGlobalMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent$ChangeDisplayMode;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent;", "", "d", "Z", "a", "()Z", OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ChangeDisplayMode extends SimplifiedFeedEditorGlobalMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isFullScreen;

        public ChangeDisplayMode(boolean z16) {
            super(null);
            this.isFullScreen = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsFullScreen() {
            return this.isFullScreen;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.feature.msgintent.SimplifiedFeedEditorGlobalMsgIntent.ChangeDisplayMode";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent$HideAllPanelAndKeyboard;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "source", "<init>", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class HideAllPanelAndKeyboard extends SimplifiedFeedEditorGlobalMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HideAllPanelAndKeyboard(@NotNull String source) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.feature.msgintent.SimplifiedFeedEditorGlobalMsgIntent.HideAllPanelAndKeyboard";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent$OverwriteCloseIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent;", "", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "source", "e", "b", "closeIntent", "", "f", "Z", "a", "()Z", "autoStash", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OverwriteCloseIntent extends SimplifiedFeedEditorGlobalMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String closeIntent;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean autoStash;

        public /* synthetic */ OverwriteCloseIntent(String str, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i3 & 4) != 0 ? true : z16);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getAutoStash() {
            return this.autoStash;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getCloseIntent() {
            return this.closeIntent;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.feature.msgintent.SimplifiedFeedEditorGlobalMsgIntent.OverwriteCloseIntent";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OverwriteCloseIntent(@NotNull String source, @Nullable String str, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.closeIntent = str;
            this.autoStash = z16;
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent$RestoreCloseIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class RestoreCloseIntent extends SimplifiedFeedEditorGlobalMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RestoreCloseIntent f222059d = new RestoreCloseIntent();

        RestoreCloseIntent() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.feature.msgintent.SimplifiedFeedEditorGlobalMsgIntent.RestoreCloseIntent";
        }
    }

    public /* synthetic */ SimplifiedFeedEditorGlobalMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    SimplifiedFeedEditorGlobalMsgIntent() {
    }
}
