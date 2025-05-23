package com.tencent.mobileqq.guild.channellist.process;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.channellist.AppChannelData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000267B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J)\u0010\u0012\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0019\u001a\u00020\u0018\"\b\b\u0000\u0010\u0015*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\n8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR \u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010$R\u0014\u0010(\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001cR\u0014\u0010.\u001a\u00020+8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R \u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020 0/8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/process/AppChnnPreInfoProcessor;", "Lcom/tencent/mobileqq/guild/channellist/process/a;", "Lcom/tencent/mobileqq/guild/channellist/process/AppChnnPreInfoProcessor$b;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "v", "Loo1/a;", "w", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "guildId", "c", "", "Lcom/tencent/mobileqq/guild/channellist/c;", VideoTemplateParser.ITEM_LIST, "", "isFirstTimeUpdate", "j", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "T", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "data", "Lcom/tencent/mobileqq/guild/channellist/process/ReplaceResult;", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/guild/channellist/c;Ljava/lang/Object;)Lcom/tencent/mobileqq/guild/channellist/process/ReplaceResult;", h.F, "Ljava/lang/String;", "()Ljava/lang/String;", "name", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/guild/channellist/process/b;", "i", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_flow", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gproObserver", BdhLogUtil.LogTag.Tag_Conn, "Loo1/a;", "guildObserver", "D", "activateGuildId", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "u", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "igpsService", "Lkotlinx/coroutines/flow/Flow;", "g", "()Lkotlinx/coroutines/flow/Flow;", "eventSource", "<init>", "()V", "E", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AppChnnPreInfoProcessor extends a<PreInfoData> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name = "AppChnnPreInfoProcessor";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<ItemsProcessEvent<PreInfoData>> _flow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver gproObserver = v();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final oo1.a guildObserver = w();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String activateGuildId = "";

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/process/AppChnnPreInfoProcessor$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "tips", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channellist.process.AppChnnPreInfoProcessor$b, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class PreInfoData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String tips;

        public PreInfoData() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getTips() {
            return this.tips;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof PreInfoData) && Intrinsics.areEqual(this.tips, ((PreInfoData) other).tips)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.tips;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @NotNull
        public String toString() {
            return "PreInfoData(tips=" + this.tips + ")";
        }

        public PreInfoData(@Nullable String str) {
            this.tips = str;
        }

        public /* synthetic */ PreInfoData(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/channellist/process/AppChnnPreInfoProcessor$c", "Loo1/a;", "", "isSuccess", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "", "from", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends oo1.a {
        c() {
        }

        @Override // oo1.a
        public void a(boolean isSuccess, @Nullable IGProChannelInfo channelInfo, @Nullable String from) {
            AppChnnPreInfoProcessor.this.u().refreshPollingData(AppChnnPreInfoProcessor.this.activateGuildId, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGPSService u() {
        RuntimeServiceHolder i3;
        i3 = i();
        if (Intrinsics.areEqual("", "VASH_TAG")) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("RuntimeServiceHolder", 1, "VASH_TAG: _obtain(, " + IGPSService.class.getSimpleName() + ") calling...");
            } else if (logger.c()) {
                String str = "VASH_TAG: _obtain(, " + IGPSService.class.getSimpleName() + ") calling...";
                for (int i16 = 0; i16 < str.length(); i16++) {
                    char charAt = str.charAt(i16);
                    Logger logger2 = Logger.f235387a;
                    if (logger2.c() && QLog.isColorLevel()) {
                        logger2.d().d("RuntimeServiceHolder", 1, String.valueOf(charAt));
                    }
                }
            }
        }
        return (IGPSService) i3.b("", IGPSService.class);
    }

    private final GPServiceObserver v() {
        return new GPServiceObserver() { // from class: com.tencent.mobileqq.guild.channellist.process.AppChnnPreInfoProcessor$newGproObserver$1
            @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
            protected void onAppChnnPreInfoListUpdated(@NotNull String guildId, @NotNull List<String> removeIds, @NotNull List<String> changeIds) {
                Intrinsics.checkNotNullParameter(guildId, "guildId");
                Intrinsics.checkNotNullParameter(removeIds, "removeIds");
                Intrinsics.checkNotNullParameter(changeIds, "changeIds");
                if (!Intrinsics.areEqual(guildId, AppChnnPreInfoProcessor.this.activateGuildId)) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "preInfoUpdate: no-op, guildId=" + guildId;
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("AppChnnPreInfoProcessor", 1, (String) it.next(), null);
                    }
                    return;
                }
                AppChnnPreInfoProcessor appChnnPreInfoProcessor = AppChnnPreInfoProcessor.this;
                BuildersKt__Builders_commonKt.launch$default(appChnnPreInfoProcessor, null, null, new AppChnnPreInfoProcessor$newGproObserver$1$onAppChnnPreInfoListUpdated$2(removeIds, changeIds, appChnnPreInfoProcessor, null), 3, null);
            }
        };
    }

    private final oo1.a w() {
        return new c();
    }

    @Override // com.tencent.mobileqq.guild.channellist.process.a
    public void c(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.activateGuildId = guildId;
    }

    @Override // com.tencent.mobileqq.guild.channellist.process.a
    @NotNull
    public Flow<ItemsProcessEvent<PreInfoData>> g() {
        return this._flow;
    }

    @Override // com.tencent.mobileqq.guild.channellist.process.a
    @NotNull
    /* renamed from: h, reason: from getter */
    public String getName() {
        return this.name;
    }

    @Override // com.tencent.mobileqq.guild.channellist.process.a
    @Nullable
    public Object j(@NotNull List<? extends com.tencent.mobileqq.guild.channellist.c> list, boolean z16, @NotNull Continuation<? super Unit> continuation) {
        Logger logger = Logger.f235387a;
        logger.d().i("AppChnnPreInfoProcessor", 1, "notifyItemList: isFirstTimeUpdate=" + z16);
        if (z16) {
            u().refreshPollingData(this.activateGuildId, 3);
            Object appChannelPreInfos = u().getAppChannelPreInfos(this.activateGuildId);
            if (appChannelPreInfos == null) {
                appChannelPreInfos = CollectionsKt__CollectionsKt.emptyList();
            }
            logger.d().d("AppChnnPreInfoProcessor", 1, "notifyItemList: appChnnPreInfos=" + appChannelPreInfos);
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.guild.channellist.process.a
    public void l() {
        u().addObserver(this.gproObserver);
        f().addObserver(this.guildObserver);
    }

    @Override // com.tencent.mobileqq.guild.channellist.process.a
    public void m() {
        u().deleteObserver(this.gproObserver);
        f().removeObserver(this.guildObserver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channellist.process.a
    @NotNull
    public <T> ReplaceResult n(@NotNull com.tencent.mobileqq.guild.channellist.c item, @NotNull T data) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(data, "data");
        if (item instanceof AppChannelData) {
            if (!(data instanceof PreInfoData)) {
                return ReplaceResult.INSTANCE.a();
            }
            return ReplaceResult.INSTANCE.b(AppChannelData.g((AppChannelData) item, 0L, 0L, null, false, 0L, null, 0, null, ((PreInfoData) data).getTips(), 255, null));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
