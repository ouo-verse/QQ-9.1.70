package com.tencent.mobileqq.guild.feed.nativepublish.edittext;

import android.text.Editable;
import android.view.KeyEvent;
import com.tencent.mobileqq.guild.util.HashTagViewType;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001:\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "GetEditableText", "InsertTextAtSelection", "OnKeyPreIme", "OnTextChanged", "OnTouchEvent", "ReplyTextByAt", "ReplyTextByEmoji", "ReplyTextByGroupTag", "ReplyTextByHashtag", "SetEditText", "ShowKeyboard", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildFeedEditTextMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$GetEditableText;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class GetEditableText extends GuildFeedEditTextMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetEditableText f221829d = new GetEditableText();

        GetEditableText() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$InsertTextAtSelection;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/lang/CharSequence;", "c", "()Ljava/lang/CharSequence;", "text", "e", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "index", "f", "Z", "b", "()Z", "skipTextWatcher", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class InsertTextAtSelection extends GuildFeedEditTextMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final CharSequence text;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer index;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean skipTextWatcher;

        public /* synthetic */ InsertTextAtSelection(CharSequence charSequence, Integer num, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? false : z16);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Integer getIndex() {
            return this.index;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getSkipTextWatcher() {
            return this.skipTextWatcher;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InsertTextAtSelection)) {
                return false;
            }
            InsertTextAtSelection insertTextAtSelection = (InsertTextAtSelection) other;
            if (Intrinsics.areEqual(this.text, insertTextAtSelection.text) && Intrinsics.areEqual(this.index, insertTextAtSelection.index) && this.skipTextWatcher == insertTextAtSelection.skipTextWatcher) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = this.text.hashCode() * 31;
            Integer num = this.index;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i3 = (hashCode2 + hashCode) * 31;
            boolean z16 = this.skipTextWatcher;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @NotNull
        public String toString() {
            CharSequence charSequence = this.text;
            return "InsertTextAtSelection(text=" + ((Object) charSequence) + ", index=" + this.index + ", skipTextWatcher=" + this.skipTextWatcher + ")";
        }

        public InsertTextAtSelection(@NotNull CharSequence text, @Nullable Integer num, boolean z16) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.index = num;
            this.skipTextWatcher = z16;
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$OnKeyPreIme;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent;", "Landroid/view/KeyEvent;", "d", "Landroid/view/KeyEvent;", "a", "()Landroid/view/KeyEvent;", "keyEvent", "", "e", "Z", "b", "()Z", "c", "(Z)V", "isConsumed", "<init>", "(Landroid/view/KeyEvent;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnKeyPreIme extends GuildFeedEditTextMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final KeyEvent keyEvent;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean isConsumed;

        public /* synthetic */ OnKeyPreIme(KeyEvent keyEvent, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(keyEvent, (i3 & 2) != 0 ? false : z16);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final KeyEvent getKeyEvent() {
            return this.keyEvent;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsConsumed() {
            return this.isConsumed;
        }

        public final void c(boolean z16) {
            this.isConsumed = z16;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent.OnKeyPreIme";
        }

        public OnKeyPreIme(@NotNull KeyEvent keyEvent, boolean z16) {
            Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
            this.keyEvent = keyEvent;
            this.isConsumed = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$OnTextChanged;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent;", "", "d", "I", "a", "()I", "length", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnTextChanged extends GuildFeedEditTextMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int length;

        public OnTextChanged(int i3) {
            this.length = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getLength() {
            return this.length;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$OnTouchEvent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class OnTouchEvent extends GuildFeedEditTextMsgIntent {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$ReplyTextByAt;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "users", "<init>", "(Ljava/util/List;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ReplyTextByAt extends GuildFeedEditTextMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<IGProUserInfo> users;

        /* JADX WARN: Multi-variable type inference failed */
        public ReplyTextByAt(@NotNull List<? extends IGProUserInfo> users) {
            Intrinsics.checkNotNullParameter(users, "users");
            this.users = users;
        }

        @NotNull
        public final List<IGProUserInfo> a() {
            return this.users;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$ReplyTextByEmoji;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent;", "", "d", "I", "b", "()I", "emojiType", "e", "a", "emojiCode", "<init>", "(II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ReplyTextByEmoji extends GuildFeedEditTextMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int emojiType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int emojiCode;

        public ReplyTextByEmoji(int i3, int i16) {
            this.emojiType = i3;
            this.emojiCode = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getEmojiCode() {
            return this.emojiCode;
        }

        /* renamed from: b, reason: from getter */
        public final int getEmojiType() {
            return this.emojiType;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$ReplyTextByGroupTag;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent;", "", "d", "J", "a", "()J", "groupCode", "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "groupName", "<init>", "(JLjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ReplyTextByGroupTag extends GuildFeedEditTextMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long groupCode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String groupName;

        public ReplyTextByGroupTag(long j3, @NotNull String groupName) {
            Intrinsics.checkNotNullParameter(groupName, "groupName");
            this.groupCode = j3;
            this.groupName = groupName;
        }

        /* renamed from: a, reason: from getter */
        public final long getGroupCode() {
            return this.groupCode;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getGroupName() {
            return this.groupName;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$ReplyTextByHashtag;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent;", "", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "channelUin", "e", "a", "channelName", "", "f", "I", "b", "()I", "channelType", "Lcom/tencent/mobileqq/guild/util/HashTagViewType;", tl.h.F, "Lcom/tencent/mobileqq/guild/util/HashTagViewType;", "()Lcom/tencent/mobileqq/guild/util/HashTagViewType;", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/guild/util/HashTagViewType;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ReplyTextByHashtag extends GuildFeedEditTextMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String channelUin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String channelName;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int channelType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final HashTagViewType type;

        public ReplyTextByHashtag(@Nullable String str, @Nullable String str2, int i3, @NotNull HashTagViewType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.channelUin = str;
            this.channelName = str2;
            this.channelType = i3;
            this.type = type;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getChannelName() {
            return this.channelName;
        }

        /* renamed from: b, reason: from getter */
        public final int getChannelType() {
            return this.channelType;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getChannelUin() {
            return this.channelUin;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final HashTagViewType getType() {
            return this.type;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$SetEditText;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent;", "Landroid/text/Editable;", "d", "Landroid/text/Editable;", "a", "()Landroid/text/Editable;", "editable", "<init>", "(Landroid/text/Editable;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class SetEditText extends GuildFeedEditTextMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Editable editable;

        public SetEditText(@NotNull Editable editable) {
            Intrinsics.checkNotNullParameter(editable, "editable");
            this.editable = editable;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Editable getEditable() {
            return this.editable;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$ShowKeyboard;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class ShowKeyboard extends GuildFeedEditTextMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShowKeyboard f221846d = new ShowKeyboard();

        ShowKeyboard() {
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }
}
