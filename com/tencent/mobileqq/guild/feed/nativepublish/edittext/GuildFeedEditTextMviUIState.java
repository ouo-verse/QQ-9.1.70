package com.tencent.mobileqq.guild.feed.nativepublish.edittext;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import com.tencent.frame.edit.ComEditTextMviUIState;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.mobileqq.guild.util.HashTagViewType;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001:\r\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "Lcom/tencent/frame/edit/ComEditTextMviUIState;", "()V", "HideKeyboard", "InsertTextAtSelection", "RemoveSpecialSpans", "ReplyTextByAt", "ReplyTextByEmoji", "ReplyTextByGroupTag", "ReplyTextByHashtag", "SetEditText", "SetInputFilter", "SetTextChangeWatcher", "ShowKeyboard", "UpdateHintText", "UpdateLinkSpan", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public class GuildFeedEditTextMviUIState extends ComEditTextMviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$HideKeyboard;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class HideKeyboard extends GuildFeedEditTextMviUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final HideKeyboard f221847d = new HideKeyboard();

        HideKeyboard() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0019\u001a\u00020\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$InsertTextAtSelection;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/lang/CharSequence;", "c", "()Ljava/lang/CharSequence;", "text", "e", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "index", "f", "Z", "a", "()Z", "blockDetect", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class InsertTextAtSelection extends GuildFeedEditTextMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final CharSequence text;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer index;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean blockDetect;

        public InsertTextAtSelection(@NotNull CharSequence text, @Nullable Integer num, boolean z16) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.index = num;
            this.blockDetect = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getBlockDetect() {
            return this.blockDetect;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Integer getIndex() {
            return this.index;
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
            if (Intrinsics.areEqual(this.text, insertTextAtSelection.text) && Intrinsics.areEqual(this.index, insertTextAtSelection.index) && this.blockDetect == insertTextAtSelection.blockDetect) {
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
            boolean z16 = this.blockDetect;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @NotNull
        public String toString() {
            CharSequence charSequence = this.text;
            return "InsertTextAtSelection(text=" + ((Object) charSequence) + ", index=" + this.index + ", blockDetect=" + this.blockDetect + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$RemoveSpecialSpans;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class RemoveSpecialSpans extends GuildFeedEditTextMviUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RemoveSpecialSpans f221851d = new RemoveSpecialSpans();

        RemoveSpecialSpans() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$ReplyTextByAt;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "tinyId", "e", "c", "name", "", "f", "I", "b", "()I", "atType", "Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;", tl.h.F, "Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;", "a", "()Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;", "atRoleInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ReplyTextByAt extends GuildFeedEditTextMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tinyId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String name;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int atType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final AtRoleInfo atRoleInfo;

        public ReplyTextByAt(@NotNull String tinyId, @NotNull String name, int i3, @Nullable AtRoleInfo atRoleInfo) {
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intrinsics.checkNotNullParameter(name, "name");
            this.tinyId = tinyId;
            this.name = name;
            this.atType = i3;
            this.atRoleInfo = atRoleInfo;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final AtRoleInfo getAtRoleInfo() {
            return this.atRoleInfo;
        }

        /* renamed from: b, reason: from getter */
        public final int getAtType() {
            return this.atType;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getTinyId() {
            return this.tinyId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$ReplyTextByEmoji;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "", "d", "I", "b", "()I", "emojiType", "e", "a", "emojiCode", "<init>", "(II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ReplyTextByEmoji extends GuildFeedEditTextMviUIState {

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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$ReplyTextByGroupTag;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "", "d", "J", "a", "()J", "groupCode", "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "groupName", "<init>", "(JLjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ReplyTextByGroupTag extends GuildFeedEditTextMviUIState {

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
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$ReplyTextByHashtag;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "channelId", "e", "b", "channelName", "", "f", "I", "c", "()I", "channelType", "Lcom/tencent/mobileqq/guild/util/HashTagViewType;", tl.h.F, "Lcom/tencent/mobileqq/guild/util/HashTagViewType;", "()Lcom/tencent/mobileqq/guild/util/HashTagViewType;", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/guild/util/HashTagViewType;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ReplyTextByHashtag extends GuildFeedEditTextMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String channelId;

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
            this.channelId = str;
            this.channelName = str2;
            this.channelType = i3;
            this.type = type;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getChannelName() {
            return this.channelName;
        }

        /* renamed from: c, reason: from getter */
        public final int getChannelType() {
            return this.channelType;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final HashTagViewType getType() {
            return this.type;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$SetEditText;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "Landroid/text/Editable;", "d", "Landroid/text/Editable;", "a", "()Landroid/text/Editable;", "editable", "<init>", "(Landroid/text/Editable;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class SetEditText extends GuildFeedEditTextMviUIState {

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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$SetInputFilter;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "Landroid/text/InputFilter;", "d", "Landroid/text/InputFilter;", "a", "()Landroid/text/InputFilter;", "filter", "", "e", "Z", "b", "()Z", "isAdd", "<init>", "(Landroid/text/InputFilter;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class SetInputFilter extends GuildFeedEditTextMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final InputFilter filter;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isAdd;

        public SetInputFilter(@NotNull InputFilter filter, boolean z16) {
            Intrinsics.checkNotNullParameter(filter, "filter");
            this.filter = filter;
            this.isAdd = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final InputFilter getFilter() {
            return this.filter;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsAdd() {
            return this.isAdd;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$SetTextChangeWatcher;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "Landroid/text/TextWatcher;", "d", "Landroid/text/TextWatcher;", "a", "()Landroid/text/TextWatcher;", "watcher", "", "e", "Z", "b", "()Z", "isAdd", "<init>", "(Landroid/text/TextWatcher;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class SetTextChangeWatcher extends GuildFeedEditTextMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TextWatcher watcher;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isAdd;

        public SetTextChangeWatcher(@NotNull TextWatcher watcher, boolean z16) {
            Intrinsics.checkNotNullParameter(watcher, "watcher");
            this.watcher = watcher;
            this.isAdd = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final TextWatcher getWatcher() {
            return this.watcher;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsAdd() {
            return this.isAdd;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$ShowKeyboard;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class ShowKeyboard extends GuildFeedEditTextMviUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShowKeyboard f221869d = new ShowKeyboard();

        ShowKeyboard() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$UpdateHintText;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "", "d", "Ljava/lang/CharSequence;", "a", "()Ljava/lang/CharSequence;", "hint", "<init>", "(Ljava/lang/CharSequence;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class UpdateHintText extends GuildFeedEditTextMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence hint;

        public UpdateHintText(@NotNull CharSequence hint) {
            Intrinsics.checkNotNullParameter(hint, "hint");
            this.hint = hint;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final CharSequence getHint() {
            return this.hint;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00030\u0002\u00a2\u0006\u0004\b\f\u0010\rR/\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$UpdateLinkSpan;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "", "Lkotlin/Triple;", "Lsk1/b;", "", "", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", ForwardMiniChooseFriendOption.RESULT_LIST, "<init>", "(Ljava/util/List;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class UpdateLinkSpan extends GuildFeedEditTextMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Triple<sk1.b, String, Integer>> results;

        public UpdateLinkSpan(@NotNull List<Triple<sk1.b, String, Integer>> results) {
            Intrinsics.checkNotNullParameter(results, "results");
            this.results = results;
        }

        @NotNull
        public final List<Triple<sk1.b, String, Integer>> a() {
            return this.results;
        }
    }
}
