package com.tencent.mobileqq.guild.message.directmessage.model.data;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.k;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernelgpro.nativeinterface.DirectSessionInfo;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yt1.DraftInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b@\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001\"B\u0087\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0010\u00a2\u0006\u0004\bX\u0010YJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\tJ\u0091\u0001\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0010H\u00c6\u0001J\t\u0010\u001e\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010!\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b&\u0010%R\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u00107\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010'\u001a\u0004\b?\u0010)\"\u0004\b@\u0010+R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010'\u001a\u0004\bB\u0010)\"\u0004\bC\u0010+R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010N\u001a\u0004\b>\u0010O\"\u0004\bP\u0010QR\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u00102R$\u0010T\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00108F@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b(\u00102\u001a\u0004\bA\u00104R$\u0010W\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\u00108F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bR\u00104\"\u0004\bV\u00106\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "", "", "e", "", "b", "from", "", "f", "", "y", "guildId", "channelId", "notifyType", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/d;", "source", "", "eventTime", "isInBlack", "isVisible", "draftIdentify", "memberType", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "lastMessage", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "unreadInfo", "Lyt1/a;", "draftInfo", "_messageTime", "c", "toString", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "g", "I", DomainData.DOMAIN_NAME, "()I", "setNotifyType", "(I)V", "d", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/d;", "o", "()Lcom/tencent/mobileqq/guild/message/directmessage/model/data/d;", "setSource", "(Lcom/tencent/mobileqq/guild/message/directmessage/model/data/d;)V", "J", "getEventTime", "()J", "setEventTime", "(J)V", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "t", "(Z)V", "r", HippyTKDListViewAdapter.X, h.F, "getDraftIdentify", "setDraftIdentify", "i", "l", "setMemberType", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "k", "()Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "u", "(Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;)V", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "p", "()Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "w", "(Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;)V", "Lyt1/a;", "()Lyt1/a;", ReportConstant.COSTREPORT_PREFIX, "(Lyt1/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<set-?>", "draftTime", "value", "v", "messageTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/guild/message/directmessage/model/data/d;JZZIILcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;Lyt1/a;J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.message.directmessage.model.data.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class DirectMessageNode {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int notifyType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private MessageSource source;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long eventTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isInBlack;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isVisible;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int draftIdentify;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int memberType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private LastMessage lastMessage;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private UnreadInfo unreadInfo;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private DraftInfo draftInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private long _messageTime;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long draftTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006R\u001a\u0010\f\u001a\u00020\t*\u0004\u0018\u00010\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/k;", SessionDbHelper.SESSION_ID, "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/DirectSessionInfo;", "d", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "", "b", "(Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;)J", "timeInMills", "", "NOTIFY_TYPE_GRAY_TYPE", "I", "NOTIFY_TYPE_RED_POINT", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.message.directmessage.model.data.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long b(LastMessage lastMessage) {
            if (lastMessage != null) {
                return lastMessage.getTime() * 1000;
            }
            return 0L;
        }

        @NotNull
        public final DirectMessageNode c(@NotNull k session) {
            Intrinsics.checkNotNullParameter(session, "session");
            String b16 = session.b();
            Intrinsics.checkNotNullExpressionValue(b16, "session.guildId");
            String a16 = session.a();
            Intrinsics.checkNotNullExpressionValue(a16, "session.channelId");
            int c16 = session.c();
            String f16 = session.f();
            Intrinsics.checkNotNullExpressionValue(f16, "session.srcGuildId");
            String g16 = session.g();
            Intrinsics.checkNotNullExpressionValue(g16, "session.srcGuildName");
            String j3 = session.j();
            Intrinsics.checkNotNullExpressionValue(j3, "session.srcTinyId");
            String i3 = session.i();
            Intrinsics.checkNotNullExpressionValue(i3, "session.srcNickName");
            String h16 = session.h();
            Intrinsics.checkNotNullExpressionValue(h16, "session.srcMemberName");
            DirectMessageNode directMessageNode = new DirectMessageNode(b16, a16, c16, new MessageSource(f16, g16, j3, i3, h16), 0L, false, false, 0, session.e(), null, null, null, 0L, 7920, null);
            directMessageNode.v(session.d() * 1000);
            return directMessageNode;
        }

        @NotNull
        public final DirectMessageNode d(@NotNull DirectSessionInfo session) {
            String valueOf;
            String valueOf2;
            Intrinsics.checkNotNullParameter(session, "session");
            String str = session.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "session.guildId");
            String str2 = session.channelId;
            Intrinsics.checkNotNullExpressionValue(str2, "session.channelId");
            int i3 = session.notifyType;
            long j3 = session.srcGuildId;
            if (j3 == 0) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(j3);
            }
            String str3 = session.srcGuildName;
            Intrinsics.checkNotNullExpressionValue(str3, "session.srcGuildName");
            long j16 = session.tinyId;
            if (j16 == 0) {
                valueOf2 = "";
            } else {
                valueOf2 = String.valueOf(j16);
            }
            String str4 = session.nickName;
            Intrinsics.checkNotNullExpressionValue(str4, "session.nickName");
            String str5 = session.memberName;
            Intrinsics.checkNotNullExpressionValue(str5, "session.memberName");
            DirectMessageNode directMessageNode = new DirectMessageNode(str, str2, i3, new MessageSource(valueOf, str3, valueOf2, str4, str5), 0L, false, false, 0, session.memberType, null, null, null, 0L, 7920, null);
            directMessageNode.v(session.msgTime * 1000);
            return directMessageNode;
        }

        Companion() {
        }
    }

    public DirectMessageNode(@NotNull String guildId, @NotNull String channelId, int i3, @NotNull MessageSource source, long j3, boolean z16, boolean z17, int i16, int i17, @Nullable LastMessage lastMessage, @Nullable UnreadInfo unreadInfo, @Nullable DraftInfo draftInfo, long j16) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(source, "source");
        this.guildId = guildId;
        this.channelId = channelId;
        this.notifyType = i3;
        this.source = source;
        this.eventTime = j3;
        this.isInBlack = z16;
        this.isVisible = z17;
        this.draftIdentify = i16;
        this.memberType = i17;
        this.lastMessage = lastMessage;
        this.unreadInfo = unreadInfo;
        this.draftInfo = draftInfo;
        this._messageTime = j16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(long j3) {
        this._messageTime = j3;
    }

    public final int b() {
        UnreadInfo unreadInfo = this.unreadInfo;
        if (unreadInfo != null) {
            return unreadInfo.j();
        }
        return 0;
    }

    @NotNull
    public final DirectMessageNode c(@NotNull String guildId, @NotNull String channelId, int notifyType, @NotNull MessageSource source, long eventTime, boolean isInBlack, boolean isVisible, int draftIdentify, int memberType, @Nullable LastMessage lastMessage, @Nullable UnreadInfo unreadInfo, @Nullable DraftInfo draftInfo, long _messageTime) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(source, "source");
        return new DirectMessageNode(guildId, channelId, notifyType, source, eventTime, isInBlack, isVisible, draftIdentify, memberType, lastMessage, unreadInfo, draftInfo, _messageTime);
    }

    @NotNull
    public final String e() {
        CharSequence charSequence;
        Long l3;
        int i3;
        int i16;
        int i17;
        CharSequence content;
        String str = this.channelId;
        String str2 = this.guildId;
        String nickName = this.source.getNickName();
        String remarkName = this.source.getRemarkName();
        String tinyId = this.source.getTinyId();
        long m3 = m();
        long i18 = i();
        LastMessage lastMessage = this.lastMessage;
        String str3 = null;
        if (lastMessage != null && (content = lastMessage.getContent()) != null) {
            charSequence = StringsKt___StringsKt.take(content, 8);
        } else {
            charSequence = null;
        }
        LastMessage lastMessage2 = this.lastMessage;
        if (lastMessage2 != null) {
            l3 = Long.valueOf(lastMessage2.getTime());
        } else {
            l3 = null;
        }
        UnreadInfo unreadInfo = this.unreadInfo;
        if (unreadInfo != null) {
            str3 = unreadInfo.a();
        }
        int i19 = this.notifyType;
        String guildId = this.source.getGuildId();
        String guildName = this.source.getGuildName();
        boolean z16 = this.isInBlack;
        boolean z17 = this.isVisible;
        int i26 = this.memberType;
        if (this.lastMessage != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (this.unreadInfo != null) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        if (this.draftInfo != null) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        return str + "/" + str2 + MsgSummary.STR_COLON + nickName + "/" + remarkName + "/" + tinyId + " time: " + m3 + "/" + i18 + " last: " + ((Object) charSequence) + "/" + l3 + " unread: " + str3 + " misc: " + i19 + "/" + guildId + "/" + guildName + "/BLACK(" + (z16 ? 1 : 0) + ")/SHOW(" + (z17 ? 1 : 0) + ")/" + i26 + "/" + i3 + "/" + i16 + "/" + i17;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectMessageNode)) {
            return false;
        }
        DirectMessageNode directMessageNode = (DirectMessageNode) other;
        if (Intrinsics.areEqual(this.guildId, directMessageNode.guildId) && Intrinsics.areEqual(this.channelId, directMessageNode.channelId) && this.notifyType == directMessageNode.notifyType && Intrinsics.areEqual(this.source, directMessageNode.source) && this.eventTime == directMessageNode.eventTime && this.isInBlack == directMessageNode.isInBlack && this.isVisible == directMessageNode.isVisible && this.draftIdentify == directMessageNode.draftIdentify && this.memberType == directMessageNode.memberType && Intrinsics.areEqual(this.lastMessage, directMessageNode.lastMessage) && Intrinsics.areEqual(this.unreadInfo, directMessageNode.unreadInfo) && Intrinsics.areEqual(this.draftInfo, directMessageNode.draftInfo) && this._messageTime == directMessageNode._messageTime) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull DirectMessageNode from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (this.unreadInfo == null) {
            this.unreadInfo = from.unreadInfo;
        }
        if (this.draftInfo == null) {
            this.draftInfo = from.draftInfo;
        }
        if (this.lastMessage == null) {
            this.lastMessage = from.lastMessage;
        }
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final DraftInfo getDraftInfo() {
        return this.draftInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((((((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.notifyType) * 31) + this.source.hashCode()) * 31) + androidx.fragment.app.a.a(this.eventTime)) * 31;
        boolean z16 = this.isInBlack;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode3 + i16) * 31;
        boolean z17 = this.isVisible;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i18 = (((((i17 + i3) * 31) + this.draftIdentify) * 31) + this.memberType) * 31;
        LastMessage lastMessage = this.lastMessage;
        int i19 = 0;
        if (lastMessage == null) {
            hashCode = 0;
        } else {
            hashCode = lastMessage.hashCode();
        }
        int i26 = (i18 + hashCode) * 31;
        UnreadInfo unreadInfo = this.unreadInfo;
        if (unreadInfo == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = unreadInfo.hashCode();
        }
        int i27 = (i26 + hashCode2) * 31;
        DraftInfo draftInfo = this.draftInfo;
        if (draftInfo != null) {
            i19 = draftInfo.hashCode();
        }
        return ((i27 + i19) * 31) + androidx.fragment.app.a.a(this._messageTime);
    }

    public final long i() {
        DraftInfo draftInfo = this.draftInfo;
        if (draftInfo != null) {
            return draftInfo.getTime();
        }
        return this.draftTime;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final LastMessage getLastMessage() {
        return this.lastMessage;
    }

    /* renamed from: l, reason: from getter */
    public final int getMemberType() {
        return this.memberType;
    }

    public final long m() {
        Companion companion = INSTANCE;
        if (companion.b(this.lastMessage) != 0) {
            return companion.b(this.lastMessage);
        }
        return this._messageTime;
    }

    /* renamed from: n, reason: from getter */
    public final int getNotifyType() {
        return this.notifyType;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final MessageSource getSource() {
        return this.source;
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final UnreadInfo getUnreadInfo() {
        return this.unreadInfo;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsInBlack() {
        return this.isInBlack;
    }

    /* renamed from: r, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public final void s(@Nullable DraftInfo draftInfo) {
        this.draftInfo = draftInfo;
    }

    public final void t(boolean z16) {
        this.isInBlack = z16;
    }

    @NotNull
    public String toString() {
        return "DirectMessageNode(guildId=" + this.guildId + ", channelId=" + this.channelId + ", notifyType=" + this.notifyType + ", source=" + this.source + ", eventTime=" + this.eventTime + ", isInBlack=" + this.isInBlack + ", isVisible=" + this.isVisible + ", draftIdentify=" + this.draftIdentify + ", memberType=" + this.memberType + ", lastMessage=" + this.lastMessage + ", unreadInfo=" + this.unreadInfo + ", draftInfo=" + this.draftInfo + ", _messageTime=" + this._messageTime + ")";
    }

    public final void u(@Nullable LastMessage lastMessage) {
        this.lastMessage = lastMessage;
    }

    public final void w(@Nullable UnreadInfo unreadInfo) {
        this.unreadInfo = unreadInfo;
    }

    public final void x(boolean z16) {
        this.isVisible = z16;
    }

    public final boolean y() {
        if (this.notifyType == 1) {
            return true;
        }
        return false;
    }

    public /* synthetic */ DirectMessageNode(String str, String str2, int i3, MessageSource messageSource, long j3, boolean z16, boolean z17, int i16, int i17, LastMessage lastMessage, UnreadInfo unreadInfo, DraftInfo draftInfo, long j16, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, messageSource, (i18 & 16) != 0 ? 0L : j3, (i18 & 32) != 0 ? false : z16, (i18 & 64) != 0 ? true : z17, (i18 & 128) != 0 ? 0 : i16, (i18 & 256) != 0 ? 0 : i17, (i18 & 512) != 0 ? null : lastMessage, (i18 & 1024) != 0 ? null : unreadInfo, (i18 & 2048) != 0 ? null : draftInfo, (i18 & 4096) != 0 ? 0L : j16);
    }
}
