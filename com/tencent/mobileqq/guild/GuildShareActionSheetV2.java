package com.tencent.mobileqq.guild;

import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.share.FetchGuildArkInfo;
import com.tencent.mobileqq.guild.share.event.GuildShareActionSheetClickEvent;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.share.w;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0002\u0011:B_\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010)\u001a\u00020\n\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\u000f\u001a\u00020\u0002R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010)\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010%R\u0017\u0010.\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u00104\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/GuildShareActionSheetV2;", "", "", DomainData.DOMAIN_NAME, "", UIJsPlugin.EVENT_SHOW_TOAST, "Lkotlin/Function0;", "fetchedSuccess", "i", tl.h.F, "", "channelOrActionId", "l", "", "k", "o", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", EventKey.ACT, "Lcom/tencent/mobileqq/guild/share/m;", "b", "Lcom/tencent/mobileqq/guild/share/m;", "oldActionSheet", "Lcom/tencent/mobileqq/guild/share/FetchGuildArkInfo;", "c", "Lcom/tencent/mobileqq/guild/share/FetchGuildArkInfo;", "guildArkInfoFetcher", "Lcom/tencent/mobileqq/guild/share/w;", "d", "Lcom/tencent/mobileqq/guild/share/w;", "executor", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "e", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "guildSharePageSource", "f", "Ljava/lang/String;", "guildId", "g", "channelId", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/guild/share/g;", "Lcom/tencent/mobileqq/guild/share/g;", "getReportHelper", "()Lcom/tencent/mobileqq/guild/share/g;", "reportHelper", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "j", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "task", "Lcom/tencent/mobileqq/sharepanel/f;", "Lcom/tencent/mobileqq/sharepanel/f;", "sharePanel", "Lcom/tencent/mobileqq/guild/share/m$b;", "actionSheetListener", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/mobileqq/guild/share/m;Lcom/tencent/mobileqq/guild/share/m$b;Lcom/tencent/mobileqq/guild/share/FetchGuildArkInfo;Lcom/tencent/mobileqq/guild/share/w;Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "RequestThrowable", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildShareActionSheetV2 {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final ArrayList<String> f213851m;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentActivity act;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.share.m oldActionSheet;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FetchGuildArkInfo guildArkInfoFetcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final w executor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GuildSharePageSource guildSharePageSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String guildId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String channelId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sceneId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.share.g reportHelper;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b task;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.sharepanel.f sharePanel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/GuildShareActionSheetV2$RequestThrowable;", "", "result", "", "errorMsg", "", "resp", "", "(ILjava/lang/String;Ljava/lang/Object;)V", "getErrorMsg", "()Ljava/lang/String;", "getResp", "()Ljava/lang/Object;", "getResult", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final /* data */ class RequestThrowable extends Throwable {

        @NotNull
        private final String errorMsg;

        @NotNull
        private final Object resp;
        private final int result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestThrowable(int i3, @NotNull String errorMsg, @NotNull Object resp) {
            super(errorMsg);
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            Intrinsics.checkNotNullParameter(resp, "resp");
            this.result = i3;
            this.errorMsg = errorMsg;
            this.resp = resp;
        }

        public static /* synthetic */ RequestThrowable copy$default(RequestThrowable requestThrowable, int i3, String str, Object obj, int i16, Object obj2) {
            if ((i16 & 1) != 0) {
                i3 = requestThrowable.result;
            }
            if ((i16 & 2) != 0) {
                str = requestThrowable.errorMsg;
            }
            if ((i16 & 4) != 0) {
                obj = requestThrowable.resp;
            }
            return requestThrowable.copy(i3, str, obj);
        }

        /* renamed from: component1, reason: from getter */
        public final int getResult() {
            return this.result;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final Object getResp() {
            return this.resp;
        }

        @NotNull
        public final RequestThrowable copy(int result, @NotNull String errorMsg, @NotNull Object resp) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            Intrinsics.checkNotNullParameter(resp, "resp");
            return new RequestThrowable(result, errorMsg, resp);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestThrowable)) {
                return false;
            }
            RequestThrowable requestThrowable = (RequestThrowable) other;
            if (this.result == requestThrowable.result && Intrinsics.areEqual(this.errorMsg, requestThrowable.errorMsg) && Intrinsics.areEqual(this.resp, requestThrowable.resp)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        @NotNull
        public final Object getResp() {
            return this.resp;
        }

        public final int getResult() {
            return this.result;
        }

        public int hashCode() {
            return (((this.result * 31) + this.errorMsg.hashCode()) * 31) + this.resp.hashCode();
        }

        @Override // java.lang.Throwable
        @NotNull
        public String toString() {
            return "RequestThrowable(result=" + this.result + ", errorMsg=" + this.errorMsg + ", resp=" + this.resp + ")";
        }

        public /* synthetic */ RequestThrowable(int i3, String str, Object obj, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? -1 : i3, str, obj);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/GuildShareActionSheetV2$b", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements com.tencent.mobileqq.sharepanel.j {
        b() {
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NotNull String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            GuildShareActionSheetV2.this.l(channelId);
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NotNull String actionId) {
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            GuildShareActionSheetV2.this.l(actionId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/GuildShareActionSheetV2$c", "Lcom/tencent/mobileqq/sharepanel/k;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements com.tencent.mobileqq.sharepanel.k {
        c() {
        }

        @Override // com.tencent.mobileqq.sharepanel.k
        public void a() {
            GuildShareActionSheetV2.this.h();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/GuildShareActionSheetV2$d", "Lcom/tencent/mobileqq/sharepanel/i;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements com.tencent.mobileqq.sharepanel.i {
        d() {
        }

        @Override // com.tencent.mobileqq.sharepanel.i
        public void a() {
            GuildShareActionSheetV2.this.h();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/GuildShareActionSheetV2$e", "Lcom/tencent/mobileqq/sharepanel/l;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e implements com.tencent.mobileqq.sharepanel.l {
        e() {
        }

        @Override // com.tencent.mobileqq.sharepanel.l
        public void a() {
            GuildShareActionSheetV2.d(GuildShareActionSheetV2.this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/GuildShareActionSheetV2$f", "Lcom/tencent/mobileqq/sharepanel/b;", "", "success", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "targetList", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class f implements com.tencent.mobileqq.sharepanel.b {
        f() {
        }

        @Override // com.tencent.mobileqq.sharepanel.b
        public void a(boolean success, @NotNull List<? extends ResultRecord> targetList) {
            Object firstOrNull;
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) targetList);
            QLog.i("GuildShareActionSheetV2", 1, "showShareActionSheetInNewPanel  onForwardResult  listSize:" + targetList.size() + "   firstItem:" + ((ResultRecord) firstOrNull));
            GuildShareActionSheetV2.this.executor.m(targetList);
        }
    }

    static {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "uppin_homepage", "pin_to_homepage", "delete", "generate_qr_code", "copy_channel_number");
        f213851m = arrayListOf;
    }

    public GuildShareActionSheetV2(@NotNull FragmentActivity act, @NotNull com.tencent.mobileqq.guild.share.m oldActionSheet, @Nullable m.b bVar, @NotNull FetchGuildArkInfo guildArkInfoFetcher, @NotNull w executor, @Nullable GuildSharePageSource guildSharePageSource, @Nullable String str, @Nullable String str2, @NotNull String sceneId) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(oldActionSheet, "oldActionSheet");
        Intrinsics.checkNotNullParameter(guildArkInfoFetcher, "guildArkInfoFetcher");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        this.act = act;
        this.oldActionSheet = oldActionSheet;
        this.guildArkInfoFetcher = guildArkInfoFetcher;
        this.executor = executor;
        this.guildSharePageSource = guildSharePageSource;
        this.guildId = str;
        this.channelId = str2;
        this.sceneId = sceneId;
        this.reportHelper = new com.tencent.mobileqq.guild.share.g(act, guildSharePageSource, str, str2);
        this.sharePanel = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(act, sceneId);
    }

    public static final /* synthetic */ m.b d(GuildShareActionSheetV2 guildShareActionSheetV2) {
        guildShareActionSheetV2.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(boolean showToast, Function0<Unit> fetchedSuccess) {
        Job f16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.task;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = null;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
            Logger logger = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            bVar3.a().add("cancel the previous show");
            Iterator<T> it = bVar3.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildShareActionSheetV2", 1, (String) it.next(), null);
            }
        }
        CoroutineScope f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f17 != null) {
            bVar2 = CorountineFunKt.e(f17, "GuildShareActionSheetV2share panel", null, null, Boolean.TRUE, new GuildShareActionSheetV2$fetchArkInfo$2(this, showToast, fetchedSuccess, null), 6, null);
        }
        this.task = bVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void j(GuildShareActionSheetV2 guildShareActionSheetV2, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        guildShareActionSheetV2.i(z16, function0);
    }

    private final int k(String channelOrActionId) {
        return com.tencent.mobileqq.guild.share.util.e.f235124a.b(channelOrActionId, "scene_normal_guild");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String channelOrActionId) {
        final GuildShareActionSheetClickEvent guildShareActionSheetClickEvent = new GuildShareActionSheetClickEvent();
        guildShareActionSheetClickEvent.setChannelInfo(this.oldActionSheet.i());
        guildShareActionSheetClickEvent.setGuildInfo(this.oldActionSheet.j());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.l
            @Override // java.lang.Runnable
            public final void run() {
                GuildShareActionSheetV2.m(GuildShareActionSheetClickEvent.this);
            }
        });
        int k3 = k(channelOrActionId);
        QLog.i("GuildShareActionSheetV2", 1, "newSharePanelClick  channelOrActionId:" + channelOrActionId + "  action:" + k3);
        this.oldActionSheet.y(k3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GuildShareActionSheetClickEvent event) {
        Intrinsics.checkNotNullParameter(event, "$event");
        SimpleEventBus.getInstance().dispatchEvent(event);
    }

    private final void n() {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (this.oldActionSheet.k().isEmpty()) {
            arrayList.add(1);
        } else {
            Set<Integer> k3 = this.oldActionSheet.k();
            Intrinsics.checkNotNullExpressionValue(k3, "oldActionSheet.visibleAppendActionIds");
            arrayList.addAll(k3);
        }
        for (String str : f213851m) {
            boolean z17 = false;
            if (Intrinsics.areEqual(str, WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK) && arrayList.contains(197)) {
                z16 = true;
            } else {
                z16 = false;
            }
            int k16 = k(str);
            com.tencent.mobileqq.sharepanel.f fVar = this.sharePanel;
            if (arrayList.contains(Integer.valueOf(k16)) || z16) {
                z17 = true;
            }
            fVar.c0(str, z17);
        }
    }

    public final void o() {
        this.sharePanel.k0(new com.tencent.mobileqq.sharepanel.n() { // from class: com.tencent.mobileqq.guild.GuildShareActionSheetV2$showShareActionSheetInNewPanel$1
            @Override // com.tencent.mobileqq.sharepanel.n
            public void a(@NotNull ArrayList<ResultRecord> targetList, @NotNull com.tencent.mobileqq.sharepanel.m callback) {
                Intrinsics.checkNotNullParameter(targetList, "targetList");
                Intrinsics.checkNotNullParameter(callback, "callback");
                GuildShareActionSheetV2 guildShareActionSheetV2 = GuildShareActionSheetV2.this;
                guildShareActionSheetV2.i(true, new GuildShareActionSheetV2$showShareActionSheetInNewPanel$1$prepareForwardData$1(guildShareActionSheetV2, callback));
            }
        });
        this.sharePanel.t0(new b());
        this.sharePanel.n0(new c());
        this.sharePanel.i0(new d());
        this.sharePanel.e0(new e());
        this.sharePanel.d0(this.reportHelper.b());
        this.sharePanel.f0(new f());
        n();
        this.sharePanel.show();
        j(this, false, null, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
    }
}
