package com.tencent.mobileqq.guild.setting.guildmanage.profile;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildNumRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNumInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberGetBoundGroupRsp;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditBaseItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ce;
import wh2.cj;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 C2\u00020\u0001:\u0004DEFGB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0014R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R)\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\u001a0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00148\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00148\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00148\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00148\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u001f\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00148\u0006\u00a2\u0006\f\n\u0004\b.\u0010\u0016\u001a\u0004\b/\u0010\u0018R\u001d\u00104\u001a\b\u0012\u0004\u0012\u0002010\u00148\u0006\u00a2\u0006\f\n\u0004\b2\u0010\u0016\u001a\u0004\b3\u0010\u0018R\"\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "j2", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "U1", SemanticAttributes.DbSystemValues.H2, "k2", "m2", "account", "onAccountChanged", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "guildId", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "b2", "()Landroidx/lifecycle/MutableLiveData;", "guildInfoLiveData", "Lcom/tencent/util/Pair;", "E", "e2", "guildNumInfoLiveData", "Lcom/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileViewModel$c;", UserInfo.SEX_FEMALE, "d2", "guildNameInfoLiveData", "G", "Z1", "guildAvatarInfoLiveData", "H", ICustomDataEditor.STRING_ARRAY_PARAM_2, "guildCoverLiveData", "I", "c2", "guildIntroLiveData", "J", "g2", "guildRuleLiveData", "K", "X1", "guildAuditTipsLiveData", "Lcom/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileViewModel$d;", "L", "f2", "guildRelativeGroupItemLiveData", "", "M", "Ljava/util/Map;", "typeToNameMap", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "N", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "P", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpServiceObserver", "<init>", "(Ljava/lang/String;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "c", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<IGProGuildInfo> guildInfoLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<String, Integer>> guildNumInfoLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ItemContent> guildNameInfoLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ItemContent> guildAvatarInfoLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ItemContent> guildCoverLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ItemContent> guildIntroLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ItemContent> guildRuleLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> guildAuditTipsLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<RelativeChatGroupItemShow> guildRelativeGroupItemLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private Map<Integer, String> typeToNameMap;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpServiceObserver;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileViewModel$a;", "", "", "a", "I", "b", "()I", "auditType", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "content", "", "J", "()J", "auditTime", "<init>", "(ILjava/lang/String;J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int auditType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String content;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long auditTime;

        public a(int i3, @NotNull String content, long j3) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.auditType = i3;
            this.content = content;
            this.auditTime = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getAuditTime() {
            return this.auditTime;
        }

        /* renamed from: b, reason: from getter */
        public final int getAuditType() {
            return this.auditType;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getContent() {
            return this.content;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileViewModel$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isAudit", "Ljava/lang/String;", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "content", "<init>", "(ZLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileViewModel$c, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class ItemContent {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isAudit;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String content;

        public ItemContent(boolean z16, @NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.isAudit = z16;
            this.content = content;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsAudit() {
            return this.isAudit;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemContent)) {
                return false;
            }
            ItemContent itemContent = (ItemContent) other;
            if (this.isAudit == itemContent.isAudit && Intrinsics.areEqual(this.content, itemContent.content)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isAudit;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.content.hashCode();
        }

        @NotNull
        public String toString() {
            return "ItemContent(isAudit=" + this.isAudit + ", content=" + this.content + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileViewModel$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "content", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileViewModel$d, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class RelativeChatGroupItemShow {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String content;

        public RelativeChatGroupItemShow(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RelativeChatGroupItemShow) && Intrinsics.areEqual(this.content, ((RelativeChatGroupItemShow) other).content)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.content.hashCode();
        }

        @NotNull
        public String toString() {
            return "RelativeChatGroupItemShow(content=" + this.content + ")";
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileViewModel$e", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onGuildInfoUpdated", "", "guildNumber", "", "status", "onChangeGuildNumber", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends GPServiceObserver {
        e() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChangeGuildNumber(long guildId, @NotNull String guildNumber, int status) {
            Intrinsics.checkNotNullParameter(guildNumber, "guildNumber");
            if (Intrinsics.areEqual(String.valueOf(guildId), GuildProfileViewModel.this.guildId)) {
                GuildProfileViewModel.this.e2().postValue(new Pair<>(guildNumber, Integer.valueOf(status)));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (!Intrinsics.areEqual(guildId, GuildProfileViewModel.this.guildId)) {
                return;
            }
            IGProGuildInfo L = ch.L(guildId);
            if (L != null) {
                GuildProfileViewModel.this.j2(L);
            } else {
                Logger.f235387a.d().i("Guild.mnr.GuildProfileViewModel", 1, "onGuildInfoUpdated guildInfo is null");
            }
        }
    }

    public GuildProfileViewModel(@NotNull String guildId) {
        Map<Integer, String> mapOf;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.guildInfoLiveData = new MutableLiveData<>();
        this.guildNumInfoLiveData = new MutableLiveData<>();
        this.guildNameInfoLiveData = new MutableLiveData<>();
        this.guildAvatarInfoLiveData = new MutableLiveData<>();
        this.guildCoverLiveData = new MutableLiveData<>();
        this.guildIntroLiveData = new MutableLiveData<>();
        this.guildRuleLiveData = new MutableLiveData<>();
        this.guildAuditTipsLiveData = new MutableLiveData<>();
        this.guildRelativeGroupItemLiveData = new MutableLiveData<>();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "\u540d\u79f0"), TuplesKt.to(2, "\u5934\u50cf"), TuplesKt.to(3, "\u5c01\u9762"), TuplesKt.to(4, "\u7b80\u4ecb"), TuplesKt.to(10, "\u9891\u9053\u89c4\u5219"));
        this.typeToNameMap = mapOf;
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.gProService = (IGPSService) R0;
        e eVar = new e();
        this.gpServiceObserver = eVar;
        IGProGuildInfo L = ch.L(this.guildId);
        if (L != null) {
            j2(L);
        }
        this.gProService.addObserver(eVar);
        h2();
        k2();
        m2();
    }

    private final LinkedHashMap<Integer, String> U1(IGProGuildInfo guildInfo) {
        ArrayList<GProGuildAuditBaseItem> arrayList;
        boolean z16;
        List<a> sortedWith;
        Object first;
        boolean z17;
        String content;
        boolean z18;
        int collectionSizeOrDefault;
        String take;
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        GProGuildAuditInfo guildAuditInfo = guildInfo.getGuildAuditInfo();
        ArrayList arrayList2 = null;
        if (guildAuditInfo != null) {
            arrayList = guildAuditInfo.auditContentList;
        } else {
            arrayList = null;
        }
        Logger.a d16 = Logger.f235387a.d();
        if (arrayList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (GProGuildAuditBaseItem gProGuildAuditBaseItem : arrayList) {
                Object obj = this.typeToNameMap.get(Integer.valueOf(gProGuildAuditBaseItem.type));
                long j3 = gProGuildAuditBaseItem.auditTime;
                long j16 = gProGuildAuditBaseItem.auditContentNum;
                String str = gProGuildAuditBaseItem.auditContentStr;
                Intrinsics.checkNotNullExpressionValue(str, "it.auditContentStr");
                take = StringsKt___StringsKt.take(str, 2);
                arrayList2.add(obj + " - " + j3 + " - " + j16 + " - " + take + " - " + gProGuildAuditBaseItem.msgId);
            }
        }
        d16.i("Guild.mnr.GuildProfileViewModel", 1, "auditContent\uff1a " + arrayList2);
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return linkedHashMap;
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList<GProGuildAuditBaseItem> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((GProGuildAuditBaseItem) obj2).type != 10) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                arrayList4.add(obj2);
            }
        }
        for (GProGuildAuditBaseItem gProGuildAuditBaseItem2 : arrayList4) {
            int i3 = gProGuildAuditBaseItem2.type;
            if (i3 != 2) {
                if (i3 != 3) {
                    content = gProGuildAuditBaseItem2.auditContentStr;
                } else {
                    content = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getCoverUrl(this.guildId + "audit", gProGuildAuditBaseItem2.auditContentNum, 0, 0);
                }
            } else {
                content = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getAvatarUrl(this.guildId + "audit", gProGuildAuditBaseItem2.auditContentNum, 0);
            }
            int i16 = gProGuildAuditBaseItem2.type;
            Intrinsics.checkNotNullExpressionValue(content, "content");
            arrayList3.add(new a(i16, content, gProGuildAuditBaseItem2.auditTime));
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (((GProGuildAuditBaseItem) obj3).type == 10) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList5.add(obj3);
            }
        }
        if (!arrayList5.isEmpty()) {
            String str2 = arrayList5.size() + "\u6761\u89c4\u5219";
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList5);
            arrayList3.add(new a(10, str2, ((GProGuildAuditBaseItem) first).auditTime));
        }
        final GuildProfileViewModel$getAuditData$4 guildProfileViewModel$getAuditData$4 = new Function2<a, a, Integer>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileViewModel$getAuditData$4
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Integer invoke(GuildProfileViewModel.a aVar, GuildProfileViewModel.a aVar2) {
                int i17 = -1;
                if (aVar.getAuditTime() >= aVar2.getAuditTime()) {
                    if (aVar.getAuditTime() <= aVar2.getAuditTime()) {
                        if (aVar.getAuditType() != 1) {
                            if (aVar2.getAuditType() != 1) {
                                i17 = 0;
                            }
                        }
                    }
                    i17 = 1;
                }
                return Integer.valueOf(i17);
            }
        };
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.ab
            @Override // java.util.Comparator
            public final int compare(Object obj4, Object obj5) {
                int W1;
                W1 = GuildProfileViewModel.W1(Function2.this, obj4, obj5);
                return W1;
            }
        });
        for (a aVar : sortedWith) {
            linkedHashMap.put(Integer.valueOf(aVar.getAuditType()), aVar.getContent());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int W1(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final void h2() {
        if (TextUtils.isEmpty(this.guildId)) {
            return;
        }
        this.gProService.getGuildNum(Long.parseLong(this.guildId), new cj() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.y
            @Override // wh2.cj
            public final void a(int i3, String str, IGProGetGuildNumRsp iGProGetGuildNumRsp) {
                GuildProfileViewModel.i2(GuildProfileViewModel.this, i3, str, iGProGetGuildNumRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(GuildProfileViewModel this$0, int i3, String errMsg, IGProGetGuildNumRsp iGProGetGuildNumRsp) {
        IGProGuildNumInfo iGProGuildNumInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Logger.f235387a.d().i("Guild.mnr.GuildProfileViewModel", 1, "getGuildNum(" + this$0.guildId + ") result:" + i3 + ", errMsg:" + errMsg + ", rsp:" + iGProGetGuildNumRsp);
        if (iGProGetGuildNumRsp != null) {
            iGProGuildNumInfo = iGProGetGuildNumRsp.getGuildNumInfo();
        } else {
            iGProGuildNumInfo = null;
        }
        if (iGProGuildNumInfo != null) {
            this$0.guildNumInfoLiveData.postValue(new Pair<>(iGProGetGuildNumRsp.getGuildNumInfo().getName(), Integer.valueOf(iGProGetGuildNumRsp.getGuildNumInfo().getStatus())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j2(IGProGuildInfo guildInfo) {
        List list;
        List take;
        int collectionSizeOrDefault;
        String joinToString$default;
        String str;
        ItemContent itemContent;
        ItemContent itemContent2;
        ItemContent itemContent3;
        ItemContent itemContent4;
        String str2;
        ItemContent itemContent5;
        boolean z16;
        Logger.f235387a.d().i("Guild.mnr.GuildProfileViewModel", 1, "notifyGuildInfoChange guildId:" + this.guildId);
        this.guildInfoLiveData.postValue(guildInfo);
        LinkedHashMap<Integer, String> U1 = U1(guildInfo);
        if (U1.isEmpty()) {
            this.guildAuditTipsLiveData.setValue(null);
        } else {
            Set<Integer> keySet = U1.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "auditLinkedMap.keys");
            list = CollectionsKt___CollectionsKt.toList(keySet);
            take = CollectionsKt___CollectionsKt.take(list, 3);
            List list2 = take;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(this.typeToNameMap.get((Integer) it.next()));
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "\u3001", null, null, 0, null, null, 62, null);
            MutableLiveData<String> mutableLiveData = this.guildAuditTipsLiveData;
            if (list.size() < 4) {
                str = joinToString$default + "\u6b63\u5728\u5ba1\u6838\u4e2d";
            } else {
                str = joinToString$default + "\u7b49" + list.size() + "\u9879\u8d44\u6599\u6b63\u5728\u5ba1\u6838\u4e2d";
            }
            mutableLiveData.setValue(str);
        }
        MutableLiveData<ItemContent> mutableLiveData2 = this.guildNameInfoLiveData;
        if (U1.containsKey(1)) {
            String str3 = U1.get(1);
            Intrinsics.checkNotNull(str3);
            itemContent = new ItemContent(true, str3);
        } else {
            String guildName = guildInfo.getGuildName();
            Intrinsics.checkNotNullExpressionValue(guildName, "guildInfo.guildName");
            itemContent = new ItemContent(false, guildName);
        }
        mutableLiveData2.setValue(itemContent);
        MutableLiveData<ItemContent> mutableLiveData3 = this.guildAvatarInfoLiveData;
        if (U1.containsKey(2)) {
            String str4 = U1.get(2);
            Intrinsics.checkNotNull(str4);
            itemContent2 = new ItemContent(true, str4);
        } else {
            String avatarUrl = guildInfo.getAvatarUrl(0);
            Intrinsics.checkNotNullExpressionValue(avatarUrl, "guildInfo.getAvatarUrl(I\u2026atarUrlType.SIZE_DEFAULT)");
            itemContent2 = new ItemContent(false, avatarUrl);
        }
        mutableLiveData3.setValue(itemContent2);
        MutableLiveData<ItemContent> mutableLiveData4 = this.guildCoverLiveData;
        if (U1.containsKey(3)) {
            String str5 = U1.get(3);
            Intrinsics.checkNotNull(str5);
            itemContent3 = new ItemContent(true, str5);
        } else {
            String canBeEmptyCoverUrl = guildInfo.getCanBeEmptyCoverUrl(0, 0);
            if (canBeEmptyCoverUrl == null) {
                canBeEmptyCoverUrl = "";
            }
            itemContent3 = new ItemContent(false, canBeEmptyCoverUrl);
        }
        mutableLiveData4.setValue(itemContent3);
        MutableLiveData<ItemContent> mutableLiveData5 = this.guildIntroLiveData;
        if (U1.containsKey(4)) {
            String str6 = U1.get(4);
            Intrinsics.checkNotNull(str6);
            itemContent4 = new ItemContent(true, str6);
        } else {
            String profile = guildInfo.getProfile();
            Intrinsics.checkNotNullExpressionValue(profile, "guildInfo.profile");
            itemContent4 = new ItemContent(false, profile);
        }
        mutableLiveData5.setValue(itemContent4);
        MutableLiveData<ItemContent> mutableLiveData6 = this.guildRuleLiveData;
        if (U1.containsKey(10)) {
            String str7 = U1.get(10);
            Intrinsics.checkNotNull(str7);
            itemContent5 = new ItemContent(true, str7);
        } else if (guildInfo.getUint32GuildRuleChangeTime() == 0) {
            itemContent5 = new ItemContent(false, "1\u6761\u89c4\u5219");
        } else {
            ArrayList<GProGuildAuditBaseItem> guildRules = guildInfo.getGuildRules();
            Intrinsics.checkNotNullExpressionValue(guildRules, "guildInfo.guildRules");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : guildRules) {
                if (((GProGuildAuditBaseItem) obj).status == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList2.add(obj);
                }
            }
            int size = arrayList2.size();
            if (size > 0) {
                str2 = size + "\u6761\u89c4\u5219";
            } else {
                str2 = "\u672a\u8bbe\u7f6e";
            }
            itemContent5 = new ItemContent(false, str2);
        }
        mutableLiveData6.setValue(itemContent5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(int i3, String str, IGProGuildInfo iGProGuildInfo) {
        Logger.f235387a.d().i("Guild.mnr.GuildProfileViewModel", 1, "refreshGuildInfo end result:" + i3 + " errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(GuildProfileViewModel this$0, int i3, String str, IGProMemberGetBoundGroupRsp iGProMemberGetBoundGroupRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetchBoundGroupsFirstPage failed: " + i3 + "-" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.group.GuildBindGroupSettingViewModel", 1, (String) it.next(), null);
            }
            this$0.guildRelativeGroupItemLiveData.setValue(new RelativeChatGroupItemShow(""));
            return;
        }
        this$0.guildRelativeGroupItemLiveData.setValue(new RelativeChatGroupItemShow(iGProMemberGetBoundGroupRsp.getBindingGroupSize() + "\u4e2a"));
        Logger.f235387a.d().i("Guild.group.GuildBindGroupSettingViewModel", 1, "fetchBoundGroupsFirstPage: " + i3);
    }

    @NotNull
    public final MutableLiveData<String> X1() {
        return this.guildAuditTipsLiveData;
    }

    @NotNull
    public final MutableLiveData<ItemContent> Z1() {
        return this.guildAvatarInfoLiveData;
    }

    @NotNull
    public final MutableLiveData<ItemContent> a2() {
        return this.guildCoverLiveData;
    }

    @NotNull
    public final MutableLiveData<IGProGuildInfo> b2() {
        return this.guildInfoLiveData;
    }

    @NotNull
    public final MutableLiveData<ItemContent> c2() {
        return this.guildIntroLiveData;
    }

    @NotNull
    public final MutableLiveData<ItemContent> d2() {
        return this.guildNameInfoLiveData;
    }

    @NotNull
    public final MutableLiveData<Pair<String, Integer>> e2() {
        return this.guildNumInfoLiveData;
    }

    @NotNull
    public final MutableLiveData<RelativeChatGroupItemShow> f2() {
        return this.guildRelativeGroupItemLiveData;
    }

    @NotNull
    public final MutableLiveData<ItemContent> g2() {
        return this.guildRuleLiveData;
    }

    public final void k2() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).fetchGuildInfoWithSource(this.guildId, 107, new vh2.v() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.aa
            @Override // vh2.v
            public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
                GuildProfileViewModel.l2(i3, str, iGProGuildInfo);
            }
        });
    }

    public final void m2() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).getGuildBoundGroupsFirstPage(this.guildId, 50, new ce() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.z
            @Override // wh2.ce
            public final void a(int i3, String str, IGProMemberGetBoundGroupRsp iGProMemberGetBoundGroupRsp) {
                GuildProfileViewModel.n2(GuildProfileViewModel.this, i3, str, iGProMemberGetBoundGroupRsp);
            }
        });
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        this.gProService.deleteObserver(this.gpServiceObserver);
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.gProService = iGPSService;
        iGPSService.addObserver(this.gpServiceObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.gProService.deleteObserver(this.gpServiceObserver);
    }
}
