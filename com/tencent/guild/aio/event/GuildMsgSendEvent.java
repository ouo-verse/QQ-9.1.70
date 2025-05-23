package com.tencent.guild.aio.event;

import androidx.fragment.app.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.api.media.album.GuildPickPhotoResult;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/event/GuildMsgSendEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "CancelSendVideoMsg", "FileSendEvent", "InputContainerHighGetEventR", "MediaSendEvent", "MsgOnClickRecallMsgsEvent", "MsgOnClickReplyEvent", "PttSendEvent", "RichMediaDownloadCompleteEvent", "RichMediaDownloadProgressEvent", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent$CancelSendVideoMsg;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent$FileSendEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent$InputContainerHighGetEventR;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent$MediaSendEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent$MsgOnClickRecallMsgsEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent$MsgOnClickReplyEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent$PttSendEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent$RichMediaDownloadCompleteEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent$RichMediaDownloadProgressEvent;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class GuildMsgSendEvent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/event/GuildMsgSendEvent$CancelSendVideoMsg;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "msgId", "<init>", "(J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class CancelSendVideoMsg extends GuildMsgSendEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long msgId;

        public CancelSendVideoMsg(long j3) {
            super(null);
            this.msgId = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getMsgId() {
            return this.msgId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof CancelSendVideoMsg) && this.msgId == ((CancelSendVideoMsg) other).msgId) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return a.a(this.msgId);
        }

        @NotNull
        public String toString() {
            return "CancelSendVideoMsg(msgId=" + this.msgId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/aio/event/GuildMsgSendEvent$FileSendEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "path", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class FileSendEvent extends GuildMsgSendEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String path;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof FileSendEvent) && Intrinsics.areEqual(this.path, ((FileSendEvent) other).path)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.path.hashCode();
        }

        @NotNull
        public String toString() {
            return "FileSendEvent(path=" + this.path + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/event/GuildMsgSendEvent$InputContainerHighGetEventR;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class InputContainerHighGetEventR extends GuildMsgSendEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final InputContainerHighGetEventR f110361d = new InputContainerHighGetEventR();

        InputContainerHighGetEventR() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guild/aio/event/GuildMsgSendEvent$MediaSendEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/guild/api/media/album/d;", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "mediaList", "e", "Z", "c", "()Z", "needCarryInputText", "f", "a", "fromCamera", "<init>", "(Ljava/util/List;ZZ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class MediaSendEvent extends GuildMsgSendEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<GuildPickPhotoResult> mediaList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needCarryInputText;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean fromCamera;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaSendEvent(@NotNull List<GuildPickPhotoResult> mediaList, boolean z16, boolean z17) {
            super(null);
            Intrinsics.checkNotNullParameter(mediaList, "mediaList");
            this.mediaList = mediaList;
            this.needCarryInputText = z16;
            this.fromCamera = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getFromCamera() {
            return this.fromCamera;
        }

        @NotNull
        public final List<GuildPickPhotoResult> b() {
            return this.mediaList;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getNeedCarryInputText() {
            return this.needCarryInputText;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaSendEvent)) {
                return false;
            }
            MediaSendEvent mediaSendEvent = (MediaSendEvent) other;
            if (Intrinsics.areEqual(this.mediaList, mediaSendEvent.mediaList) && this.needCarryInputText == mediaSendEvent.needCarryInputText && this.fromCamera == mediaSendEvent.fromCamera) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.mediaList.hashCode() * 31;
            boolean z16 = this.needCarryInputText;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.fromCamera;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "MediaSendEvent(mediaList=" + this.mediaList + ", needCarryInputText=" + this.needCarryInputText + ", fromCamera=" + this.fromCamera + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/event/GuildMsgSendEvent$MsgOnClickRecallMsgsEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgItem", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class MsgOnClickRecallMsgsEvent extends GuildMsgSendEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MsgRecord msgItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MsgOnClickRecallMsgsEvent(@NotNull MsgRecord msgItem) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            this.msgItem = msgItem;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MsgRecord getMsgItem() {
            return this.msgItem;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof MsgOnClickRecallMsgsEvent) && Intrinsics.areEqual(this.msgItem, ((MsgOnClickRecallMsgsEvent) other).msgItem)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.msgItem.hashCode();
        }

        @NotNull
        public String toString() {
            return "MsgOnClickRecallMsgsEvent(msgItem=" + this.msgItem + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/event/GuildMsgSendEvent$MsgOnClickReplyEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/aio/data/msglist/a;", "d", "Lcom/tencent/aio/data/msglist/a;", "a", "()Lcom/tencent/aio/data/msglist/a;", "msgItem", "<init>", "(Lcom/tencent/aio/data/msglist/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class MsgOnClickReplyEvent extends GuildMsgSendEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final com.tencent.aio.data.msglist.a msgItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MsgOnClickReplyEvent(@NotNull com.tencent.aio.data.msglist.a msgItem) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            this.msgItem = msgItem;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.aio.data.msglist.a getMsgItem() {
            return this.msgItem;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof MsgOnClickReplyEvent) && Intrinsics.areEqual(this.msgItem, ((MsgOnClickReplyEvent) other).msgItem)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.msgItem.hashCode();
        }

        @NotNull
        public String toString() {
            return "MsgOnClickReplyEvent(msgItem=" + this.msgItem + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/event/GuildMsgSendEvent$PttSendEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "path", "", "e", UserInfo.SEX_FEMALE, "getDuration", "()F", "duration", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class PttSendEvent extends GuildMsgSendEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String path;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final float duration;

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PttSendEvent)) {
                return false;
            }
            PttSendEvent pttSendEvent = (PttSendEvent) other;
            if (Intrinsics.areEqual(this.path, pttSendEvent.path) && Float.compare(this.duration, pttSendEvent.duration) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.path.hashCode() * 31) + Float.floatToIntBits(this.duration);
        }

        @NotNull
        public String toString() {
            return "PttSendEvent(path=" + this.path + ", duration=" + this.duration + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/event/GuildMsgSendEvent$RichMediaDownloadCompleteEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "getFileInfo", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class RichMediaDownloadCompleteEvent extends GuildMsgSendEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final FileTransNotifyInfo fileInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RichMediaDownloadCompleteEvent(@NotNull FileTransNotifyInfo fileInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
            this.fileInfo = fileInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RichMediaDownloadCompleteEvent) && Intrinsics.areEqual(this.fileInfo, ((RichMediaDownloadCompleteEvent) other).fileInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.fileInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "RichMediaDownloadCompleteEvent(fileInfo=" + this.fileInfo + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/event/GuildMsgSendEvent$RichMediaDownloadProgressEvent;", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "getFileInfo", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class RichMediaDownloadProgressEvent extends GuildMsgSendEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final FileTransNotifyInfo fileInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RichMediaDownloadProgressEvent(@NotNull FileTransNotifyInfo fileInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
            this.fileInfo = fileInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RichMediaDownloadProgressEvent) && Intrinsics.areEqual(this.fileInfo, ((RichMediaDownloadProgressEvent) other).fileInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.fileInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "RichMediaDownloadProgressEvent(fileInfo=" + this.fileInfo + ")";
        }
    }

    public /* synthetic */ GuildMsgSendEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    GuildMsgSendEvent() {
    }
}
