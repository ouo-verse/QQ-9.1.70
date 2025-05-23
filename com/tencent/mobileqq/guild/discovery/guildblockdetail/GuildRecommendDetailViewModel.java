package com.tencent.mobileqq.guild.discovery.guildblockdetail;

import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.ViewModelKt;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.guild.base.b;
import com.tencent.mobileqq.guild.discovery.avblockdetail.model.GuildRecommendCardItem;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.GuildRecommendGuildCardDelegate;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildNewRecommendFragment;
import com.tencent.mobileqq.guild.theme.d;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryPageGuildsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEntry;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendExtra;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.bf;
import com.tencent.mobileqq.qqguildsdk.data.genc.cy;
import com.tencent.mobileqq.qqguildsdk.data.genc.t;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.bt;
import wy1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 F2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002GHB)\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u0012\u0006\u0010(\u001a\u00020\u0006\u0012\u0006\u0010*\u001a\u00020\u0006\u0012\u0006\u0010,\u001a\u00020\u0013\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001b\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u00020\rH\u0002J(\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0006\u0010\u001b\u001a\u00020\u0004J$\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u0013J\b\u0010#\u001a\u00020\u0004H\u0016R\u0017\u0010$\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'R\u0017\u0010*\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'R\u0017\u0010,\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u0011008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\n008\u0006\u00a2\u0006\f\n\u0004\b5\u00102\u001a\u0004\b6\u00104R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\n008\u0006\u00a2\u0006\f\n\u0004\b7\u00102\u001a\u0004\b8\u00104R\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\u0011008\u0006\u00a2\u0006\f\n\u0004\b9\u00102\u001a\u0004\b:\u00104R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0011008\u0006\u00a2\u0006\f\n\u0004\b;\u00102\u001a\u0004\b<\u00104R\"\u0010=\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010-\u001a\u0004\b\u001a\u0010/\"\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010%R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010%R\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010%R\u0016\u0010C\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010-\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel;", "Lcom/tencent/mobileqq/guild/theme/d;", "Lcom/tencent/mobileqq/guild/base/b;", "Lwy1/a;", "", "resetLoadParams", "", "refreshNum", "Lkotlinx/coroutines/Job;", "fetchData", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel$b;", "getDiscoverRecommendDetail", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/t;", "getRequestSource", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryPageGuildsRsp;", "rsp", "", "isLeftItem", "", "curCategoryName", "itemCategoryPosition", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/GuildRecommendCardItem;", "genCardUIData", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendItem;", "recommendItem", "getCategorySourceName", "refresh", "loadCategoryId", "loadCategoryConfId", "loadCategoryName", "loadData", "getQueryCategoryId", "getQueryCategoryConfId", "getQueryCategoryName", "onThemeChanged", "pageFrom", "I", "getPageFrom", "()I", "categoryId", "getCategoryId", "categoryConfId", "getCategoryConfId", "categoryName", "Ljava/lang/String;", "getCategoryName", "()Ljava/lang/String;", "Le12/a;", UIJsPlugin.EVENT_HIDE_LOADING, "Le12/a;", "getHideLoading", "()Le12/a;", "discoverRecommendDetailRsp", "getDiscoverRecommendDetailRsp", "discoverRecommendDetailRspForNewCard", "getDiscoverRecommendDetailRspForNewCard", HippyReporter.RemoveEngineReason.THEME_CHANGED, "getThemeChanged", "networkInvalid", "getNetworkInvalid", "categorySourceName", "setCategorySourceName", "(Ljava/lang/String;)V", "mRefreshNum", "_categoryId", "_categoryConfId", "_categoryName", "<init>", "(IIILjava/lang/String;)V", "Companion", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildRecommendDetailViewModel extends b<a> implements d {
    public static final int FRIENDS_NUMBER = 2;
    private static final int GUILD_STATE = 1;
    public static final int MAX_LABEL_TEXT_LENGTH = 6;
    public static final int MEDAL_OFFICIAL_LEVEL = 2;
    public static final int ONLINE_NUMBER = 3;
    public static final int OPERATE_ARTIFICIAL_WUJI = 9;

    @NotNull
    private static final String TAG = "Guild.discovery.recommend.GuildRecommendDetailViewModel";
    private int _categoryConfId;
    private int _categoryId;

    @NotNull
    private String _categoryName;
    private final int categoryConfId;
    private final int categoryId;

    @NotNull
    private final String categoryName;

    @NotNull
    private String categorySourceName;

    @NotNull
    private final e12.a<DiscoverRecommendDetailRsp> discoverRecommendDetailRsp;

    @NotNull
    private final e12.a<DiscoverRecommendDetailRsp> discoverRecommendDetailRspForNewCard;

    @NotNull
    private final e12.a<Boolean> hideLoading;
    private int mRefreshNum;

    @NotNull
    private final e12.a<Boolean> networkInvalid;
    private final int pageFrom;

    @NotNull
    private final e12.a<Boolean> themeChanged;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018R'\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u0016\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "categoryId", "categoryConfId", "Lkh1/a;", "c", "Lkh1/a;", "e", "()Lkh1/a;", "result", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryPageGuildsRsp;", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryPageGuildsRsp;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryPageGuildsRsp;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/GuildRecommendCardItem;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "items", "<init>", "(IILkh1/a;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryPageGuildsRsp;Ljava/util/ArrayList;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discovery.guildblockdetail.GuildRecommendDetailViewModel$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class DiscoverRecommendDetailRsp {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int categoryId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int categoryConfId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final kh1.a result;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final IGProGetCategoryPageGuildsRsp data;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ArrayList<GuildRecommendCardItem> items;

        public DiscoverRecommendDetailRsp(int i3, int i16, @NotNull kh1.a result, @NotNull IGProGetCategoryPageGuildsRsp data, @NotNull ArrayList<GuildRecommendCardItem> items) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(items, "items");
            this.categoryId = i3;
            this.categoryConfId = i16;
            this.result = result;
            this.data = data;
            this.items = items;
        }

        /* renamed from: a, reason: from getter */
        public final int getCategoryConfId() {
            return this.categoryConfId;
        }

        /* renamed from: b, reason: from getter */
        public final int getCategoryId() {
            return this.categoryId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final IGProGetCategoryPageGuildsRsp getData() {
            return this.data;
        }

        @NotNull
        public final ArrayList<GuildRecommendCardItem> d() {
            return this.items;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final kh1.a getResult() {
            return this.result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DiscoverRecommendDetailRsp)) {
                return false;
            }
            DiscoverRecommendDetailRsp discoverRecommendDetailRsp = (DiscoverRecommendDetailRsp) other;
            if (this.categoryId == discoverRecommendDetailRsp.categoryId && this.categoryConfId == discoverRecommendDetailRsp.categoryConfId && Intrinsics.areEqual(this.result, discoverRecommendDetailRsp.result) && Intrinsics.areEqual(this.data, discoverRecommendDetailRsp.data) && Intrinsics.areEqual(this.items, discoverRecommendDetailRsp.items)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.categoryId * 31) + this.categoryConfId) * 31) + this.result.hashCode()) * 31) + this.data.hashCode()) * 31) + this.items.hashCode();
        }

        @NotNull
        public String toString() {
            return "DiscoverRecommendDetailRsp(categoryId=" + this.categoryId + ", categoryConfId=" + this.categoryConfId + ", result=" + this.result + ", data=" + this.data + ", items=" + this.items + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryPageGuildsRsp;", "rsp", "", "<anonymous parameter 3>", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryPageGuildsRsp;[B)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements bt {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<DiscoverRecommendDetailRsp> f216651a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bf f216652b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildRecommendDetailViewModel f216653c;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super DiscoverRecommendDetailRsp> continuation, bf bfVar, GuildRecommendDetailViewModel guildRecommendDetailViewModel) {
            this.f216651a = continuation;
            this.f216652b = bfVar;
            this.f216653c = guildRecommendDetailViewModel;
        }

        @Override // wh2.bt
        public final void a(int i3, String errMsg, IGProGetCategoryPageGuildsRsp rsp, byte[] bArr) {
            int i16;
            boolean z16;
            ArrayList<GuildRecommendCardItem> d16;
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d(GuildRecommendDetailViewModel.TAG, "getDiscoverRecommendDetail response result: " + i3 + " ,errMsg: " + errMsg + " ,traceId: " + rsp.getTraceId() + ", isEnd: " + rsp.getIsEnd() + ", rsp.items.size: " + rsp.getItems().size());
            }
            if (i3 == 0 && !rsp.getItems().isEmpty()) {
                GuildNewRecommendFragment.INSTANCE.b(null);
                ArrayList arrayList = new ArrayList();
                DiscoverRecommendDetailRsp value = this.f216653c.getDiscoverRecommendDetailRsp().getValue();
                int i17 = 0;
                if (value != null && (d16 = value.d()) != null) {
                    i16 = d16.size();
                } else {
                    i16 = 0;
                }
                if (i16 % 2 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ArrayList<IGProRecommendItem> items = rsp.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "rsp.items");
                GuildRecommendDetailViewModel guildRecommendDetailViewModel = this.f216653c;
                for (Object obj : items) {
                    int i18 = i17 + 1;
                    if (i17 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    arrayList.add(guildRecommendDetailViewModel.genCardUIData(rsp, z16, guildRecommendDetailViewModel._categoryName, i17));
                    z16 = !z16;
                    i17 = i18;
                }
                Continuation<DiscoverRecommendDetailRsp> continuation = this.f216651a;
                Result.Companion companion = Result.INSTANCE;
                int b16 = this.f216652b.a().b();
                int a16 = this.f216652b.a().a();
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                kh1.a aVar = new kh1.a(i3, errMsg);
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                continuation.resumeWith(Result.m476constructorimpl(new DiscoverRecommendDetailRsp(b16, a16, aVar, rsp, arrayList)));
                return;
            }
            Continuation<DiscoverRecommendDetailRsp> continuation2 = this.f216651a;
            Result.Companion companion2 = Result.INSTANCE;
            int b17 = this.f216652b.a().b();
            int a17 = this.f216652b.a().a();
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            kh1.a aVar2 = new kh1.a(i3, errMsg);
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            continuation2.resumeWith(Result.m476constructorimpl(new DiscoverRecommendDetailRsp(b17, a17, aVar2, rsp, new ArrayList())));
        }
    }

    public /* synthetic */ GuildRecommendDetailViewModel(int i3, int i16, int i17, String str, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, i16, i17, str);
    }

    private final Job fetchData(int refreshNum) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new GuildRecommendDetailViewModel$fetchData$1(this, refreshNum, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildRecommendCardItem genCardUIData(IGProGetCategoryPageGuildsRsp rsp, boolean isLeftItem, String curCategoryName, int itemCategoryPosition) {
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        int i3;
        IGProRecommendItem recommendItem = rsp.getItems().get(itemCategoryPosition);
        if (this.categorySourceName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(recommendItem, "recommendItem");
            this.categorySourceName = getCategorySourceName(recommendItem);
        }
        IGProRecommendChannelInfo channelInfo = recommendItem.getChannelInfo();
        if (channelInfo.getMedalLevel() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(channelInfo.getStateList(), "channelInfo.stateList");
        if (!(!r2.isEmpty())) {
            str = "";
            z18 = false;
            i3 = 0;
        } else {
            int state = channelInfo.getStateList().get(0).getState();
            String desc = channelInfo.getStateList().get(0).getDesc();
            Intrinsics.checkNotNullExpressionValue(desc, "channelInfo.stateList[0].desc");
            z18 = GuildRecommendGuildCardDelegate.INSTANCE.d(state);
            i3 = state;
            str = desc;
        }
        ArrayList<IGProRecommendLabel> tagList = channelInfo.getTagList();
        Intrinsics.checkNotNullExpressionValue(tagList, "channelInfo.tagList");
        String str2 = "";
        int i16 = 0;
        for (IGProRecommendLabel iGProRecommendLabel : tagList) {
            int labelType = iGProRecommendLabel.getLabelType();
            if (labelType != 2) {
                if (labelType != 3) {
                    if (labelType == 9 && !TextUtils.isEmpty(iGProRecommendLabel.getLabelName()) && iGProRecommendLabel.getLabelName().length() <= 6 && (!z18 || arrayList.size() <= 0)) {
                        arrayList.add(iGProRecommendLabel.getLabelName());
                    }
                } else if (!TextUtils.isEmpty(iGProRecommendLabel.getLabelName())) {
                    String labelName = iGProRecommendLabel.getLabelName();
                    Intrinsics.checkNotNullExpressionValue(labelName, "tagItem.labelName");
                    str2 = labelName;
                }
            } else {
                i16 = iGProRecommendLabel.getLabelValue();
            }
        }
        String itemId = recommendItem.getItemId();
        Intrinsics.checkNotNullExpressionValue(itemId, "recommendItem.itemId");
        String traceId = rsp.getTraceId();
        Intrinsics.checkNotNullExpressionValue(traceId, "rsp.traceId");
        String valueOf = String.valueOf(channelInfo.getGuildId());
        String joinGuildSig = channelInfo.getJoinGuildSig();
        int joinedGuild = channelInfo.getJoinedGuild();
        String guildName = channelInfo.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "channelInfo.guildName");
        String guildProfile = channelInfo.getGuildProfile();
        Intrinsics.checkNotNullExpressionValue(guildProfile, "channelInfo.guildProfile");
        String guildIcon = channelInfo.getGuildIcon();
        Intrinsics.checkNotNullExpressionValue(guildIcon, "channelInfo.guildIcon");
        String coverUrl = channelInfo.getCoverUrl();
        Intrinsics.checkNotNullExpressionValue(coverUrl, "channelInfo.coverUrl");
        IGProRecommendExtra extra = recommendItem.getExtra();
        Intrinsics.checkNotNullExpressionValue(extra, "recommendItem.extra");
        List t16 = GuildMedalUtils.t(channelInfo.getMedalInfoList(), 0, 2, null);
        ArrayList<IGProRecommendLabel> tagList2 = channelInfo.getTagList();
        Intrinsics.checkNotNullExpressionValue(tagList2, "channelInfo.tagList");
        return new GuildRecommendCardItem(itemId, traceId, curCategoryName, valueOf, joinGuildSig, joinedGuild, guildName, guildProfile, guildIcon, coverUrl, z17, isLeftItem, i3, str, i16, str2, null, arrayList, itemCategoryPosition, false, 0, null, extra, t16, tagList2, 3735552, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getDiscoverRecommendDetail(int i3, Continuation<? super DiscoverRecommendDetailRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        bf bfVar = new bf();
        bfVar.a().i(this._categoryId);
        bfVar.a().h(this._categoryConfId);
        bfVar.a().j(this._categoryName);
        bfVar.g(getRequestSource());
        bfVar.f(i3);
        List<cy> a16 = GuildNewRecommendFragment.INSTANCE.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.qqguildsdk.data.genc.GWGProItemIdInfo>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.qqguildsdk.data.genc.GWGProItemIdInfo> }");
        bfVar.e((ArrayList) a16);
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d(TAG, "getDiscoverRecommendDetail request req: " + bfVar);
        }
        iGPSService.getCategoryPageGuilds(bfVar, new c(safeContinuation, bfVar, this));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final t getRequestSource() {
        return mh1.b.f416778a.a(this.pageFrom);
    }

    public static /* synthetic */ void loadData$default(GuildRecommendDetailViewModel guildRecommendDetailViewModel, int i3, int i16, String str, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = guildRecommendDetailViewModel.categoryId;
        }
        if ((i17 & 2) != 0) {
            i16 = guildRecommendDetailViewModel.categoryConfId;
        }
        if ((i17 & 4) != 0) {
            str = guildRecommendDetailViewModel.categoryName;
        }
        guildRecommendDetailViewModel.loadData(i3, i16, str);
    }

    private final void resetLoadParams() {
        ArrayList<GuildRecommendCardItem> d16;
        ArrayList<GuildRecommendCardItem> d17;
        if (!NetworkUtil.isNetworkAvailable()) {
            e12.a<Boolean> aVar = this.hideLoading;
            Boolean bool = Boolean.TRUE;
            aVar.setValue(bool);
            this.networkInvalid.setValue(bool);
            return;
        }
        DiscoverRecommendDetailRsp value = this.discoverRecommendDetailRsp.getValue();
        if (value != null && (d17 = value.d()) != null) {
            d17.clear();
        }
        DiscoverRecommendDetailRsp value2 = this.discoverRecommendDetailRspForNewCard.getValue();
        if (value2 != null && (d16 = value2.d()) != null) {
            d16.clear();
        }
        this.mRefreshNum = 0;
    }

    public final int getCategoryConfId() {
        return this.categoryConfId;
    }

    public final int getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final String getCategorySourceName() {
        return this.categorySourceName;
    }

    @NotNull
    public final e12.a<DiscoverRecommendDetailRsp> getDiscoverRecommendDetailRsp() {
        return this.discoverRecommendDetailRsp;
    }

    @NotNull
    public final e12.a<DiscoverRecommendDetailRsp> getDiscoverRecommendDetailRspForNewCard() {
        return this.discoverRecommendDetailRspForNewCard;
    }

    @NotNull
    public final e12.a<Boolean> getHideLoading() {
        return this.hideLoading;
    }

    @NotNull
    public final e12.a<Boolean> getNetworkInvalid() {
        return this.networkInvalid;
    }

    public final int getPageFrom() {
        return this.pageFrom;
    }

    /* renamed from: getQueryCategoryConfId, reason: from getter */
    public final int get_categoryConfId() {
        return this._categoryConfId;
    }

    /* renamed from: getQueryCategoryId, reason: from getter */
    public final int get_categoryId() {
        return this._categoryId;
    }

    @NotNull
    /* renamed from: getQueryCategoryName, reason: from getter */
    public final String get_categoryName() {
        return this._categoryName;
    }

    @NotNull
    public final e12.a<Boolean> getThemeChanged() {
        return this.themeChanged;
    }

    public final void loadData(int loadCategoryId, int loadCategoryConfId, @NotNull String loadCategoryName) {
        ArrayList<GuildRecommendCardItem> d16;
        Intrinsics.checkNotNullParameter(loadCategoryName, "loadCategoryName");
        QLog.d(TAG, 4, "loadData= id=" + loadCategoryId + ", confId=" + loadCategoryConfId + ", name=" + loadCategoryName);
        if (loadCategoryId != this._categoryId || loadCategoryConfId != this._categoryConfId || !Intrinsics.areEqual(loadCategoryName, this._categoryName)) {
            resetLoadParams();
            this._categoryId = loadCategoryId;
            this._categoryConfId = loadCategoryConfId;
            this._categoryName = loadCategoryName;
        }
        DiscoverRecommendDetailRsp value = this.discoverRecommendDetailRsp.getValue();
        boolean z16 = false;
        if (value != null && (d16 = value.d()) != null && !d16.isEmpty()) {
            z16 = true;
        }
        if (!z16) {
            this.hideLoading.setValue(Boolean.FALSE);
        }
        fetchData(this.mRefreshNum);
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        this.themeChanged.setValue(Boolean.TRUE);
    }

    public final void refresh() {
        resetLoadParams();
        fetchData(this.mRefreshNum);
    }

    public final void setCategorySourceName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categorySourceName = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRecommendDetailViewModel(int i3, int i16, int i17, @NotNull String categoryName) {
        super(new a());
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        this.pageFrom = i3;
        this.categoryId = i16;
        this.categoryConfId = i17;
        this.categoryName = categoryName;
        this.hideLoading = new e12.a<>();
        this.discoverRecommendDetailRsp = new e12.a<>();
        this.discoverRecommendDetailRspForNewCard = new e12.a<>();
        this.themeChanged = new e12.a<>();
        this.networkInvalid = new e12.a<>();
        this.categorySourceName = "";
        this._categoryId = i16;
        this._categoryConfId = i17;
        this._categoryName = categoryName;
    }

    private final String getCategorySourceName(IGProRecommendItem recommendItem) {
        Intrinsics.checkNotNullExpressionValue(recommendItem.getExtra().getReports(), "recommendItem.extra.reports");
        boolean z16 = true;
        if (!r0.isEmpty()) {
            ArrayList<IGProRecommendEntry> reports = recommendItem.getExtra().getReports();
            Intrinsics.checkNotNullExpressionValue(reports, "recommendItem.extra.reports");
            if (!(reports instanceof Collection) || !reports.isEmpty()) {
                Iterator<T> it = reports.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual("sgrp_category_source", ((IGProRecommendEntry) it.next()).getKey())) {
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                ArrayList<IGProRecommendEntry> reports2 = recommendItem.getExtra().getReports();
                Intrinsics.checkNotNullExpressionValue(reports2, "recommendItem.extra.reports");
                ArrayList arrayList = new ArrayList();
                for (Object obj : reports2) {
                    if (Intrinsics.areEqual("sgrp_category_source", ((IGProRecommendEntry) obj).getKey())) {
                        arrayList.add(obj);
                    }
                }
                byte[] value = ((IGProRecommendEntry) arrayList.get(0)).getValue();
                Intrinsics.checkNotNullExpressionValue(value, "recommendItem.extra.repo\u2026URCE == it.key }[0].value");
                return new String(value, Charsets.UTF_8);
            }
        }
        return "";
    }
}
