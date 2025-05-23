package fo0;

import android.os.Bundle;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u00002\u00020\u0001:\u0011\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0015"}, d2 = {"Lfo0/e;", "Lat/a;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", tl.h.F, "i", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class e implements at.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lfo0/e$a;", "Lfo0/e;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends e {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final a f400136d = new a();

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lfo0/e$b;", "Lfo0/e;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends e {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lfo0/e$c;", "Lfo0/e;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "a", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildMsgItem msgItem;

        public c(@NotNull GuildMsgItem msgItem) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            this.msgItem = msgItem;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildMsgItem getMsgItem() {
            return this.msgItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lfo0/e$d;", "Lfo0/e;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d extends e {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final d f400138d = new d();

        d() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lfo0/e$e;", "Lfo0/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "action", "Landroid/os/Bundle;", "e", "Landroid/os/Bundle;", "b", "()Landroid/os/Bundle;", "data", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fo0.e$e, reason: collision with other inner class name and from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class IMECommandIntent extends e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String action;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Bundle data;

        public IMECommandIntent(@Nullable String str, @Nullable Bundle bundle) {
            this.action = str;
            this.data = bundle;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getAction() {
            return this.action;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Bundle getData() {
            return this.data;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IMECommandIntent)) {
                return false;
            }
            IMECommandIntent iMECommandIntent = (IMECommandIntent) other;
            if (Intrinsics.areEqual(this.action, iMECommandIntent.action) && Intrinsics.areEqual(this.data, iMECommandIntent.data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            String str = this.action;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            Bundle bundle = this.data;
            if (bundle != null) {
                i3 = bundle.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "IMECommandIntent(action=" + this.action + ", data=" + this.data + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lfo0/e$f;", "Lfo0/e;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f extends e {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final f f400141d = new f();

        f() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lfo0/e$g;", "Lfo0/e;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g extends e {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final g f400142d = new g();

        g() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lfo0/e$h;", "Lfo0/e;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class h extends e {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final h f400143d = new h();

        h() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lfo0/e$i;", "Lfo0/e;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class i extends e {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final i f400144d = new i();

        i() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lfo0/e$j;", "Lfo0/e;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class j extends e {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final j f400145d = new j();

        j() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lfo0/e$k;", "Lfo0/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lfo0/e$l;", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "texts", "Lfo0/e$p;", "e", "Lfo0/e$p;", "a", "()Lfo0/e$p;", "replyData", "<init>", "(Ljava/util/List;Lfo0/e$p;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fo0.e$k, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class InputSendMultiTextIntent extends e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<InputSendTextIntent> texts;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final ReplyData replyData;

        public InputSendMultiTextIntent(@NotNull List<InputSendTextIntent> texts, @Nullable ReplyData replyData) {
            Intrinsics.checkNotNullParameter(texts, "texts");
            this.texts = texts;
            this.replyData = replyData;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final ReplyData getReplyData() {
            return this.replyData;
        }

        @NotNull
        public final List<InputSendTextIntent> b() {
            return this.texts;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputSendMultiTextIntent)) {
                return false;
            }
            InputSendMultiTextIntent inputSendMultiTextIntent = (InputSendMultiTextIntent) other;
            if (Intrinsics.areEqual(this.texts, inputSendMultiTextIntent.texts) && Intrinsics.areEqual(this.replyData, inputSendMultiTextIntent.replyData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.texts.hashCode() * 31;
            ReplyData replyData = this.replyData;
            if (replyData == null) {
                hashCode = 0;
            } else {
                hashCode = replyData.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "InputSendMultiTextIntent(texts=" + this.texts + ", replyData=" + this.replyData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lfo0/e$l;", "Lfo0/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "content", "I", "c", "()I", "atType", "", "f", "J", "()J", "atUid", tl.h.F, "b", "atTinyId", "Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;", "i", "Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;", "a", "()Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;", "atRoleInfo", "<init>", "(Ljava/lang/String;IJJLcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fo0.e$l, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class InputSendTextIntent extends e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String content;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int atType;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final long atUid;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final long atTinyId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final AtRoleInfo atRoleInfo;

        public /* synthetic */ InputSendTextIntent(String str, int i3, long j3, long j16, AtRoleInfo atRoleInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? 0L : j3, (i16 & 8) == 0 ? j16 : 0L, (i16 & 16) != 0 ? null : atRoleInfo);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final AtRoleInfo getAtRoleInfo() {
            return this.atRoleInfo;
        }

        /* renamed from: b, reason: from getter */
        public final long getAtTinyId() {
            return this.atTinyId;
        }

        /* renamed from: c, reason: from getter */
        public final int getAtType() {
            return this.atType;
        }

        /* renamed from: d, reason: from getter */
        public final long getAtUid() {
            return this.atUid;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputSendTextIntent)) {
                return false;
            }
            InputSendTextIntent inputSendTextIntent = (InputSendTextIntent) other;
            if (Intrinsics.areEqual(this.content, inputSendTextIntent.content) && this.atType == inputSendTextIntent.atType && this.atUid == inputSendTextIntent.atUid && this.atTinyId == inputSendTextIntent.atTinyId && Intrinsics.areEqual(this.atRoleInfo, inputSendTextIntent.atRoleInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((((this.content.hashCode() * 31) + this.atType) * 31) + androidx.fragment.app.a.a(this.atUid)) * 31) + androidx.fragment.app.a.a(this.atTinyId)) * 31;
            AtRoleInfo atRoleInfo = this.atRoleInfo;
            if (atRoleInfo == null) {
                hashCode = 0;
            } else {
                hashCode = atRoleInfo.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "InputSendTextIntent(content=" + this.content + ", atType=" + this.atType + ", atUid=" + this.atUid + ", atTinyId=" + this.atTinyId + ", atRoleInfo=" + this.atRoleInfo + ")";
        }

        public InputSendTextIntent(@NotNull String content, int i3, long j3, long j16, @Nullable AtRoleInfo atRoleInfo) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
            this.atType = i3;
            this.atUid = j3;
            this.atTinyId = j16;
            this.atRoleInfo = atRoleInfo;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lfo0/e$m;", "Lfo0/e;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class m extends e {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final m f400153d = new m();

        m() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lfo0/e$n;", "Lfo0/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgItem", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fo0.e$n, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class ReeditRecallMsg extends e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MsgRecord msgItem;

        public ReeditRecallMsg(@NotNull MsgRecord msgItem) {
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
            if ((other instanceof ReeditRecallMsg) && Intrinsics.areEqual(this.msgItem, ((ReeditRecallMsg) other).msgItem)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.msgItem.hashCode();
        }

        @NotNull
        public String toString() {
            return "ReeditRecallMsg(msgItem=" + this.msgItem + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lfo0/e$o;", "Lfo0/e;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class o extends e {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final o f400155d = new o();

        o() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lfo0/e$p;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "replyMsgId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "replyNick", "replyContent", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fo0.e$p, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class ReplyData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long replyMsgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String replyNick;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String replyContent;

        public ReplyData(long j3, @NotNull String replyNick, @NotNull String replyContent) {
            Intrinsics.checkNotNullParameter(replyNick, "replyNick");
            Intrinsics.checkNotNullParameter(replyContent, "replyContent");
            this.replyMsgId = j3;
            this.replyNick = replyNick;
            this.replyContent = replyContent;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getReplyContent() {
            return this.replyContent;
        }

        /* renamed from: b, reason: from getter */
        public final long getReplyMsgId() {
            return this.replyMsgId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getReplyNick() {
            return this.replyNick;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplyData)) {
                return false;
            }
            ReplyData replyData = (ReplyData) other;
            if (this.replyMsgId == replyData.replyMsgId && Intrinsics.areEqual(this.replyNick, replyData.replyNick) && Intrinsics.areEqual(this.replyContent, replyData.replyContent)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((androidx.fragment.app.a.a(this.replyMsgId) * 31) + this.replyNick.hashCode()) * 31) + this.replyContent.hashCode();
        }

        @NotNull
        public String toString() {
            return "ReplyData(replyMsgId=" + this.replyMsgId + ", replyNick=" + this.replyNick + ", replyContent=" + this.replyContent + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lfo0/e$q;", "Lfo0/e;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class q extends e {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final q f400159d = new q();

        q() {
        }
    }
}
