package com.tencent.mobileqq.guild.media.aio;

import androidx.annotation.DrawableRes;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.mobileqq.guild.media.model.AudioQueueState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import dt0.MediaUserEnterTipsModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0016\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0016\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", tl.h.F, "i", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", ReportConstant.COSTREPORT_PREFIX, "t", "u", "v", "Lcom/tencent/mobileqq/guild/media/aio/b$a;", "Lcom/tencent/mobileqq/guild/media/aio/b$b;", "Lcom/tencent/mobileqq/guild/media/aio/b$c;", "Lcom/tencent/mobileqq/guild/media/aio/b$d;", "Lcom/tencent/mobileqq/guild/media/aio/b$e;", "Lcom/tencent/mobileqq/guild/media/aio/b$f;", "Lcom/tencent/mobileqq/guild/media/aio/b$g;", "Lcom/tencent/mobileqq/guild/media/aio/b$h;", "Lcom/tencent/mobileqq/guild/media/aio/b$i;", "Lcom/tencent/mobileqq/guild/media/aio/b$j;", "Lcom/tencent/mobileqq/guild/media/aio/b$k;", "Lcom/tencent/mobileqq/guild/media/aio/b$l;", "Lcom/tencent/mobileqq/guild/media/aio/b$m;", "Lcom/tencent/mobileqq/guild/media/aio/b$n;", "Lcom/tencent/mobileqq/guild/media/aio/b$o;", "Lcom/tencent/mobileqq/guild/media/aio/b$p;", "Lcom/tencent/mobileqq/guild/media/aio/b$q;", "Lcom/tencent/mobileqq/guild/media/aio/b$r;", "Lcom/tencent/mobileqq/guild/media/aio/b$s;", "Lcom/tencent/mobileqq/guild/media/aio/b$t;", "Lcom/tencent/mobileqq/guild/media/aio/b$u;", "Lcom/tencent/mobileqq/guild/media/aio/b$v;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$a;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f227857a = new a();

        a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$b;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "d", "tinyId", "c", "nickName", "e", "tipsContent", "btnMsg", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.aio.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C7831b extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tinyId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String nickName;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tipsContent;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String btnMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7831b(@NotNull String guildId, @NotNull String tinyId, @NotNull String nickName, @NotNull String tipsContent, @NotNull String btnMsg) {
            super(null);
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            Intrinsics.checkNotNullParameter(tipsContent, "tipsContent");
            Intrinsics.checkNotNullParameter(btnMsg, "btnMsg");
            this.guildId = guildId;
            this.tinyId = tinyId;
            this.nickName = nickName;
            this.tipsContent = tipsContent;
            this.btnMsg = btnMsg;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getBtnMsg() {
            return this.btnMsg;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getNickName() {
            return this.nickName;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getTinyId() {
            return this.tinyId;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getTipsContent() {
            return this.tipsContent;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B1\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$c;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "a", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "iconRes", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "msg", "d", "preSuffix", "bgRes", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Integer iconRes;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String msg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String preSuffix;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Integer bgRes;

        public /* synthetic */ c(Integer num, String str, String str2, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(num, str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? null : num2);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Integer getBgRes() {
            return this.bgRes;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Integer getIconRes() {
            return this.iconRes;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getPreSuffix() {
            return this.preSuffix;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@DrawableRes @Nullable Integer num, @NotNull String msg2, @NotNull String preSuffix, @DrawableRes @Nullable Integer num2) {
            super(null);
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(preSuffix, "preSuffix");
            this.iconRes = num;
            this.msg = msg2;
            this.preSuffix = preSuffix;
            this.bgRes = num2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$d;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "iconString", "b", "activeMsg", "btnMsg", "d", "openIndex", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String iconString;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String activeMsg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String btnMsg;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String openIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull String iconString, @NotNull String activeMsg, @NotNull String btnMsg, @NotNull String openIndex) {
            super(null);
            Intrinsics.checkNotNullParameter(iconString, "iconString");
            Intrinsics.checkNotNullParameter(activeMsg, "activeMsg");
            Intrinsics.checkNotNullParameter(btnMsg, "btnMsg");
            Intrinsics.checkNotNullParameter(openIndex, "openIndex");
            this.iconString = iconString;
            this.activeMsg = activeMsg;
            this.btnMsg = btnMsg;
            this.openIndex = openIndex;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getActiveMsg() {
            return this.activeMsg;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getBtnMsg() {
            return this.btnMsg;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getIconString() {
            return this.iconString;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getOpenIndex() {
            return this.openIndex;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$e;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "Ldt0/a;", "a", "Ljava/util/List;", "()Ljava/util/List;", "data", "<init>", "(Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<MediaUserEnterTipsModel> data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull List<MediaUserEnterTipsModel> data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        @NotNull
        public final List<MediaUserEnterTipsModel> a() {
            return this.data;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$f;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "Lcom/tencent/mobileqq/guild/media/model/AudioQueueState;", "a", "Lcom/tencent/mobileqq/guild/media/model/AudioQueueState;", "()Lcom/tencent/mobileqq/guild/media/model/AudioQueueState;", "audioQueueState", "<init>", "(Lcom/tencent/mobileqq/guild/media/model/AudioQueueState;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AudioQueueState audioQueueState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull AudioQueueState audioQueueState) {
            super(null);
            Intrinsics.checkNotNullParameter(audioQueueState, "audioQueueState");
            this.audioQueueState = audioQueueState;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AudioQueueState getAudioQueueState() {
            return this.audioQueueState;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$g;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "a", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "()Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "tv", "<init>", "(Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildAIOInputEditText tv;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(@NotNull GuildAIOInputEditText tv5) {
            super(null);
            Intrinsics.checkNotNullParameter(tv5, "tv");
            this.tv = tv5;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildAIOInputEditText getTv() {
            return this.tv;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$h;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "a", "Z", "()Z", "clearContent", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean clearContent;

        public h() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getClearContent() {
            return this.clearContent;
        }

        public h(boolean z16) {
            super(null);
            this.clearContent = z16;
        }

        public /* synthetic */ h(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$i;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "a", "Z", "()Z", "isMicEnable", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isMicEnable;

        public i(boolean z16) {
            super(null);
            this.isMicEnable = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsMicEnable() {
            return this.isMicEnable;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$j;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "Lus0/b;", "a", "Lus0/b;", "()Lus0/b;", "aioCtrl", "<init>", "(Lus0/b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class j extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final us0.b aioCtrl;

        public j(@Nullable us0.b bVar) {
            super(null);
            this.aioCtrl = bVar;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final us0.b getAioCtrl() {
            return this.aioCtrl;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$k;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "a", "Z", "()Z", NodeProps.VISIBLE, "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class k extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean visible;

        public k(boolean z16) {
            super(null);
            this.visible = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$l;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class l extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final l f227878a = new l();

        l() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$m;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class m extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final m f227879a = new m();

        m() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$n;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class n extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final n f227880a = new n();

        n() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$o;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class o extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final o f227881a = new o();

        o() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$p;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "a", "I", "getOldSpeakModel", "()I", "oldSpeakModel", "b", "newSpeakModel", "<init>", "(II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class p extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int oldSpeakModel;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int newSpeakModel;

        public p(int i3, int i16) {
            super(null);
            this.oldSpeakModel = i3;
            this.newSpeakModel = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getNewSpeakModel() {
            return this.newSpeakModel;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$q;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "a", "Z", "()Z", "opened", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class q extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean opened;

        public q(boolean z16) {
            super(null);
            this.opened = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getOpened() {
            return this.opened;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$r;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "a", "Z", "()Z", "isSelectMode", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class r extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSelectMode;

        public r(boolean z16) {
            super(null);
            this.isSelectMode = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsSelectMode() {
            return this.isSelectMode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$s;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "a", "I", "()I", NodeProps.PADDING_TOP, "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class s extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int paddingTop;

        public s(int i3) {
            super(null);
            this.paddingTop = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getPaddingTop() {
            return this.paddingTop;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$t;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "a", "Z", "b", "()Z", "isPanelOrKeyBoardShow", "isAioInputBarShow", "<init>", "(ZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class t extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isPanelOrKeyBoardShow;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean isAioInputBarShow;

        public t(boolean z16, boolean z17) {
            super(null);
            this.isPanelOrKeyBoardShow = z16;
            this.isAioInputBarShow = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsAioInputBarShow() {
            return this.isAioInputBarShow;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsPanelOrKeyBoardShow() {
            return this.isPanelOrKeyBoardShow;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$u;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "", "a", "Z", "()Z", "isPanelOrKeyBoardShow", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class u extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isPanelOrKeyBoardShow;

        public u(boolean z16) {
            super(null);
            this.isPanelOrKeyBoardShow = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsPanelOrKeyBoardShow() {
            return this.isPanelOrKeyBoardShow;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/b$v;", "Lcom/tencent/mobileqq/guild/media/aio/b;", "Lcom/tencent/mobileqq/guild/media/aio/AioUiState;", "a", "Lcom/tencent/mobileqq/guild/media/aio/AioUiState;", "()Lcom/tencent/mobileqq/guild/media/aio/AioUiState;", "state", "<init>", "(Lcom/tencent/mobileqq/guild/media/aio/AioUiState;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class v extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AioUiState state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(@NotNull AioUiState state) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AioUiState getState() {
            return this.state;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
