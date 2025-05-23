package com.tencent.mobileqq.guild.discover;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.mainframe.q;
import com.tencent.mobileqq.guild.mainframe.v;
import com.tencent.mobileqq.guild.openentrance.eventbus.GuildFrameUpdateEvent;
import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProDiscoveryData;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNewUserGuideData;
import com.tencent.mobileqq.qqguildsdk.data.genc.s;
import com.tencent.mobileqq.qqguildsdk.data.genc.t;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wh2.an;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0002KLB\t\b\u0002\u00a2\u0006\u0004\bI\u0010JJD\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0007J\b\u0010\r\u001a\u00020\nH\u0007J\b\u0010\u000e\u001a\u00020\tH\u0007J4\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J#\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\"\u001a\u00020\nR\u001b\u0010'\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R*\u0010.\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00038F@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00101\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u0010&\"\u0004\b2\u00103R$\u00106\u001a\u00020\t2\u0006\u00104\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u0010&R\u0016\u00108\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00100R\u0016\u0010:\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00109R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00100R\u0018\u0010=\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010<R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010@R\u001b\u0010D\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010$\u001a\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\rR$\u0010H\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00038\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001b\"\u0004\bG\u0010-\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/discover/GuildDiscoverABTestHelper;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$b;", "", "fetchSceneId", "", "bizId", "source", "Lkotlin/Function2;", "", "", "onFinish", "r", "J", "B", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/s;", "req", "t", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildBottomTabExpData;", "tabExpData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildBottomTabExpData;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Conn, "E", "o", "I", "D", "Lcom/tencent/mobileqq/guild/mainframe/v;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "account", "onAccountChanged", "v", "p", "e", "Lkotlin/Lazy;", "w", "()Z", "enterNewUserDiscoverDirectly", "value", "f", HippyTKDListViewAdapter.X, "()I", UserInfo.SEX_FEMALE, "(I)V", "guildTabPageType", h.F, "Z", "isPlayingGuildAnim", "G", "(Z)V", "<set-?>", "i", "isNewGuildUser", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ToastView.ICON_LOADING, "Ljava/lang/String;", "accountUin", "firstSwitchGuildTab", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildBottomTabExpData;", "expData", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService;", "Lmqq/util/WeakReference;", "userService", "y", "()Lcom/tencent/mobileqq/guild/mainframe/v;", "guildTabStatusChangeListener", "", "lastFetchTime", "setDebugGuildTabPageType", "debugGuildTabPageType", "<init>", "()V", "ExpDataForCacheSave", "NewUserGuideData", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildDiscoverABTestHelper implements com.tencent.mobileqq.guild.base.repository.a, IGuildUserService.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private static String accountUin;

    /* renamed from: D, reason: from kotlin metadata */
    private static boolean firstSwitchGuildTab;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private static IGProGuildBottomTabExpData expData;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private static WeakReference<IGuildUserService> userService;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private static final Lazy guildTabStatusChangeListener;

    /* renamed from: H, reason: from kotlin metadata */
    private static long lastFetchTime;

    /* renamed from: I, reason: from kotlin metadata */
    private static int debugGuildTabPageType;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildDiscoverABTestHelper f216488d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enterNewUserDiscoverDirectly;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int guildTabPageType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isPlayingGuildAnim;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean isNewGuildUser;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static boolean loading;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/discover/GuildDiscoverABTestHelper$ExpDataForCacheSave;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildBottomTabExpData;", "()V", "data", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildBottomTabExpData;)V", TangramHippyConstants.EXP_ID, "", "expIndex", "", "isHit", "", "tabType", "", "userGuideData", "Lcom/tencent/mobileqq/guild/discover/GuildDiscoverABTestHelper$NewUserGuideData;", "clearNewUserData", "", "getDiscoveryData", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProDiscoveryData;", "getExpId", "getExpIndex", "getIsHit", "getTabType", "getUserGuideData", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class ExpDataForCacheSave implements IGProGuildBottomTabExpData {
        private long expId;

        @NotNull
        private String expIndex;
        private boolean isHit;
        private int tabType;

        @Nullable
        private NewUserGuideData userGuideData;

        public ExpDataForCacheSave() {
            this.expIndex = "";
        }

        public final void clearNewUserData() {
            NewUserGuideData newUserGuideData = this.userGuideData;
            if (newUserGuideData != null) {
                newUserGuideData.setAnimationUrl("");
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
        @Nullable
        public IGProDiscoveryData getDiscoveryData() {
            return null;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
        public long getExpId() {
            return this.expId;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
        @NotNull
        public String getExpIndex() {
            return this.expIndex;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
        public boolean getIsHit() {
            return this.isHit;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
        public int getTabType() {
            return this.tabType;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
        @NotNull
        public String toString() {
            return "ExpDataForCacheSave(isHit=" + this.isHit + ", expId=" + this.expId + ", expIndex='" + this.expIndex + "', tabType=" + this.tabType + ", userGuideData=" + this.userGuideData + ")";
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
        @Nullable
        public NewUserGuideData getUserGuideData() {
            return this.userGuideData;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ExpDataForCacheSave(@NotNull IGProGuildBottomTabExpData data) {
            this();
            NewUserGuideData newUserGuideData;
            Intrinsics.checkNotNullParameter(data, "data");
            this.isHit = data.getIsHit();
            this.expId = data.getExpId();
            String expIndex = data.getExpIndex();
            Intrinsics.checkNotNullExpressionValue(expIndex, "data.expIndex");
            this.expIndex = expIndex;
            this.tabType = data.getTabType();
            if (data.getUserGuideData() == null) {
                newUserGuideData = null;
            } else {
                IGProNewUserGuideData userGuideData = data.getUserGuideData();
                Intrinsics.checkNotNullExpressionValue(userGuideData, "data.userGuideData");
                newUserGuideData = new NewUserGuideData(userGuideData);
            }
            this.userGuideData = newUserGuideData;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\b\u0010\r\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/discover/GuildDiscoverABTestHelper$NewUserGuideData;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNewUserGuideData;", "sdkData", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNewUserGuideData;)V", "animationUrl", "", "tabExposeFlag", "", "getAnimationUrl", "getTabExposeFlag", "setAnimationUrl", "", "url", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class NewUserGuideData implements IGProNewUserGuideData {

        @NotNull
        private String animationUrl;
        private int tabExposeFlag;

        public NewUserGuideData(@NotNull IGProNewUserGuideData sdkData) {
            Intrinsics.checkNotNullParameter(sdkData, "sdkData");
            this.animationUrl = "";
            String animationUrl = sdkData.getAnimationUrl();
            Intrinsics.checkNotNullExpressionValue(animationUrl, "sdkData.animationUrl");
            this.animationUrl = animationUrl;
            this.tabExposeFlag = sdkData.getTabExposeFlag();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNewUserGuideData
        @NotNull
        public String getAnimationUrl() {
            return this.animationUrl;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNewUserGuideData
        public int getTabExposeFlag() {
            return this.tabExposeFlag;
        }

        public final void setAnimationUrl(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.animationUrl = url;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNewUserGuideData
        @NotNull
        public String toString() {
            return "NewUserGuideData(animationUrl='" + this.animationUrl + "', tabExposeFlag=" + this.tabExposeFlag + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/discover/GuildDiscoverABTestHelper$a", "Lcom/tencent/mobileqq/guild/mainframe/v;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements v {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.mainframe.v
        public void a() {
            if (q.l()) {
                GuildDiscoverABTestHelper guildDiscoverABTestHelper = GuildDiscoverABTestHelper.f216488d;
                q.x(guildDiscoverABTestHelper.y());
                guildDiscoverABTestHelper.D();
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        GuildDiscoverABTestHelper guildDiscoverABTestHelper = new GuildDiscoverABTestHelper();
        f216488d = guildDiscoverABTestHelper;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper$enterNewUserDiscoverDirectly$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).isEnableNewUserDiscover());
            }
        });
        enterNewUserDiscoverDirectly = lazy;
        guildTabPageType = 4;
        String g16 = ch.g();
        Intrinsics.checkNotNullExpressionValue(g16, "accountUin()");
        accountUin = g16;
        firstSwitchGuildTab = true;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<v>() { // from class: com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper$guildTabStatusChangeListener$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final v invoke() {
                v q16;
                q16 = GuildDiscoverABTestHelper.f216488d.q();
                return q16;
            }
        });
        guildTabStatusChangeListener = lazy2;
        AccountChangedNotifier.f214789d.a(guildDiscoverABTestHelper);
        guildDiscoverABTestHelper.C();
        guildDiscoverABTestHelper.o();
        guildDiscoverABTestHelper.I();
    }

    GuildDiscoverABTestHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object A(IGProGuildBottomTabExpData iGProGuildBottomTabExpData, String str, Continuation<? super Unit> continuation) {
        GuildDiscoverABTestHelper$handleTabExpData$1 guildDiscoverABTestHelper$handleTabExpData$1;
        Object coroutine_suspended;
        int i3;
        GuildDiscoverABTestHelper guildDiscoverABTestHelper;
        if (continuation instanceof GuildDiscoverABTestHelper$handleTabExpData$1) {
            guildDiscoverABTestHelper$handleTabExpData$1 = (GuildDiscoverABTestHelper$handleTabExpData$1) continuation;
            int i16 = guildDiscoverABTestHelper$handleTabExpData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildDiscoverABTestHelper$handleTabExpData$1.label = i16 - Integer.MIN_VALUE;
                GuildDiscoverABTestHelper$handleTabExpData$1 guildDiscoverABTestHelper$handleTabExpData$12 = guildDiscoverABTestHelper$handleTabExpData$1;
                Object obj = guildDiscoverABTestHelper$handleTabExpData$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildDiscoverABTestHelper$handleTabExpData$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        str = (String) guildDiscoverABTestHelper$handleTabExpData$12.L$1;
                        guildDiscoverABTestHelper = (GuildDiscoverABTestHelper) guildDiscoverABTestHelper$handleTabExpData$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    expData = iGProGuildBottomTabExpData;
                    i.d dVar = i.d.f261782e;
                    GuildDiscoverABTestHelper$handleTabExpData$2 guildDiscoverABTestHelper$handleTabExpData$2 = new GuildDiscoverABTestHelper$handleTabExpData$2(iGProGuildBottomTabExpData, null);
                    guildDiscoverABTestHelper$handleTabExpData$12.L$0 = this;
                    guildDiscoverABTestHelper$handleTabExpData$12.L$1 = str;
                    guildDiscoverABTestHelper$handleTabExpData$12.label = 1;
                    if (CorountineFunKt.i(dVar, "Guild.discovery.GuildDiscoverABTestHelper fetchGuildBottomTabExp", null, guildDiscoverABTestHelper$handleTabExpData$2, guildDiscoverABTestHelper$handleTabExpData$12, 4, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    guildDiscoverABTestHelper = this;
                }
                guildDiscoverABTestHelper.H();
                Logger.f235387a.d().i("Guild.discovery.GuildDiscoverABTestHelper", 1, "updateExpData(" + accountUin + ") success, " + str + " type:" + f216488d.x() + " expData: " + expData);
                return Unit.INSTANCE;
            }
        }
        guildDiscoverABTestHelper$handleTabExpData$1 = new GuildDiscoverABTestHelper$handleTabExpData$1(this, continuation);
        GuildDiscoverABTestHelper$handleTabExpData$1 guildDiscoverABTestHelper$handleTabExpData$122 = guildDiscoverABTestHelper$handleTabExpData$1;
        Object obj2 = guildDiscoverABTestHelper$handleTabExpData$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildDiscoverABTestHelper$handleTabExpData$122.label;
        if (i3 == 0) {
        }
        guildDiscoverABTestHelper.H();
        Logger.f235387a.d().i("Guild.discovery.GuildDiscoverABTestHelper", 1, "updateExpData(" + accountUin + ") success, " + str + " type:" + f216488d.x() + " expData: " + expData);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final boolean B() {
        if (f216488d.x() == 4) {
            return true;
        }
        return false;
    }

    private final void C() {
        F(bw.f235485a.M());
        Logger logger = Logger.f235387a;
        logger.d().i("Guild.discovery.GuildDiscoverABTestHelper", 1, "readCacheFromMMKV guildTabPageType" + f216488d.x());
        logger.d().i("Guild.discovery.GuildDiscoverABTestHelper", 1, "readCacheFromMMKV debugGuildTabPageType" + debugGuildTabPageType);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
        Intrinsics.checkNotNull(f16);
        CorountineFunKt.e(f16, "Guild.discovery.GuildDiscoverABTestHelper readCacheFromMMKV", null, null, null, new GuildDiscoverABTestHelper$readCacheFromMMKV$3(null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        int x16 = x();
        C();
        o();
        s(0, null, "onAccountChanged", null, 11, null);
        if (x16 != x()) {
            if (x() == 4 || x16 == 4) {
                Logger.f235387a.d().i("Guild.discovery.GuildDiscoverABTestHelper", 1, "onGuildModeChanged GuildFrameUpdate");
                ThreadUtils threadUtils = ThreadUtils.f235400a;
                if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                    SimpleEventBus.getInstance().dispatchEvent(new GuildFrameUpdateEvent());
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper$recoverDataOnAccountChanged$$inlined$ensureUiThread$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            SimpleEventBus.getInstance().dispatchEvent(new GuildFrameUpdateEvent());
                        }
                    });
                }
            }
        }
    }

    private final void E() {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
        Intrinsics.checkNotNull(f16);
        CorountineFunKt.e(f16, "Guild.discovery.GuildDiscoverABTestHelper savePageType", null, null, null, new GuildDiscoverABTestHelper$savePageType$1(null), 14, null);
    }

    private final void F(int i3) {
        if (i3 == guildTabPageType) {
            return;
        }
        E();
        guildTabPageType = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        String str;
        boolean z16;
        if (w()) {
            F(2);
            isNewGuildUser = true;
            return;
        }
        if (o()) {
            return;
        }
        IGProGuildBottomTabExpData iGProGuildBottomTabExpData = expData;
        if (iGProGuildBottomTabExpData == null) {
            F(1);
        } else {
            IGProNewUserGuideData userGuideData = iGProGuildBottomTabExpData.getUserGuideData();
            if (userGuideData != null) {
                str = userGuideData.getAnimationUrl();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                F(1);
                isNewGuildUser = true;
            } else {
                F(1);
            }
        }
        Logger.f235387a.d().i("Guild.discovery.GuildDiscoverABTestHelper", 1, "updateCurrentPageType(" + accountUin + ") type:" + f216488d.x() + " expData: " + expData);
    }

    private final void I() {
        IGuildUserService iGuildUserService;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.discovery.GuildDiscoverABTestHelper", 2, "removeGuildModeObserver");
        }
        WeakReference<IGuildUserService> weakReference = userService;
        if (weakReference != null && (iGuildUserService = weakReference.get()) != null) {
            iGuildUserService.removeListener(this);
        }
        IRuntimeService S0 = ch.S0(IGuildUserService.class, "Guild.discovery.GuildDiscoverABTestHelper");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGuildUserService iGuildUserService2 = (IGuildUserService) S0;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.discovery.GuildDiscoverABTestHelper", 2, "addGuildModeObserver");
        }
        WeakReference<IGuildUserService> weakReference2 = new WeakReference<>(iGuildUserService2);
        IGuildUserService iGuildUserService3 = weakReference2.get();
        if (iGuildUserService3 != null) {
            iGuildUserService3.addListener(this);
        }
        userService = weakReference2;
    }

    @JvmStatic
    public static final void J() {
        GuildDiscoverABTestHelper guildDiscoverABTestHelper = f216488d;
        if (guildDiscoverABTestHelper.x() == 2 && guildDiscoverABTestHelper.z()) {
            s(13, null, "updatePageTypeOnTabClick", null, 10, null);
            guildDiscoverABTestHelper.F(1);
        }
    }

    private final boolean o() {
        boolean z16;
        IRuntimeService S0 = ch.S0(IGuildUserService.class, "Guild.discovery.GuildDiscoverABTestHelper");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGuildUserService iGuildUserService = (IGuildUserService) S0;
        if (iGuildUserService.guildMode() == GuildMsgAbFlag.KSIMPLEMODEL) {
            z16 = true;
        } else {
            z16 = false;
        }
        Logger.f235387a.d().i("Guild.discovery.GuildDiscoverABTestHelper", 1, "checkNewDiscoverTab guildMode:" + iGuildUserService.guildMode() + " showNewDiscoverTab:" + z16);
        if (z16) {
            F(4);
            return true;
        }
        F(1);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final v q() {
        return new a();
    }

    @JvmStatic
    public static final void r(int fetchSceneId, @NotNull String bizId, @NotNull String source, @Nullable Function2<? super Boolean, ? super String, Unit> onFinish) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(source, "source");
        GuildDiscoverABTestHelper guildDiscoverABTestHelper = f216488d;
        if (guildDiscoverABTestHelper.x() == 4) {
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("Guild.discovery.GuildDiscoverABTestHelper", 1, "fetchAbTest " + source + " guildTabPageType:" + guildDiscoverABTestHelper.x() + " fetchType:" + fetchSceneId + " curData:" + expData);
                return;
            }
            return;
        }
        if (loading) {
            Logger logger2 = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger2.d().d("Guild.discovery.GuildDiscoverABTestHelper", 1, "fetchAbTest " + source + " isLoading:" + loading + " fetchType:" + fetchSceneId + " curData:" + expData);
                return;
            }
            return;
        }
        loading = true;
        s sVar = new s();
        t tVar = new t();
        tVar.e(fetchSceneId);
        tVar.d(bizId);
        sVar.d(tVar);
        sVar.c(3);
        Logger.f235387a.d().i("Guild.discovery.GuildDiscoverABTestHelper", 1, "start fetchAbTest " + source + " fetchSceneId:" + fetchSceneId + " bizId:" + bizId);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        Intrinsics.checkNotNull(f16);
        CorountineFunKt.e(f16, "Guild.discovery.GuildDiscoverABTestHelper fetchAbTest", Boolean.FALSE, null, null, new GuildDiscoverABTestHelper$fetchAbTest$5(sVar, onFinish, source, null), 12, null);
    }

    public static /* synthetic */ void s(int i3, String str, String str2, Function2 function2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 10;
        }
        if ((i16 & 2) != 0) {
            str = "";
        }
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        if ((i16 & 8) != 0) {
            function2 = null;
        }
        r(i3, str, str2, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(s req, final Function2<? super Boolean, ? super String, Unit> onFinish, final String source) {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).fetchGuildBottomTabExp(req, new an() { // from class: com.tencent.mobileqq.guild.discover.a
            @Override // wh2.an
            public final void a(int i3, String str, IGProGuildBottomTabExpData iGProGuildBottomTabExpData) {
                GuildDiscoverABTestHelper.u(Function2.this, source, i3, str, iGProGuildBottomTabExpData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function2 function2, String source, int i3, String str, IGProGuildBottomTabExpData iGProGuildBottomTabExpData) {
        Intrinsics.checkNotNullParameter(source, "$source");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "Guild.discovery.GuildDiscoverABTestHelper fetchGuildBottomTabExp", Boolean.FALSE, null, null, new GuildDiscoverABTestHelper$fetchGuildBottomTabExp$1$1(i3, iGProGuildBottomTabExpData, function2, str, source, null), 12, null);
        }
    }

    private final boolean w() {
        return ((Boolean) enterNewUserDiscoverDirectly.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final v y() {
        return (v) guildTabStatusChangeListener.getValue();
    }

    private final boolean z() {
        boolean z16;
        IRuntimeService S0 = ch.S0(IGPSService.class, "Guild.discovery.GuildDiscoverABTestHelper");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        List<IGProGuildInfo> guildList = ((IGPSService) S0).getGuildList();
        if (guildList != null && !guildList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    public final void G(boolean z16) {
        isPlayingGuildAnim = z16;
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        Logger logger = Logger.f235387a;
        logger.d().i("Guild.discovery.GuildDiscoverABTestHelper", 1, "AccountChangedAware: " + account);
        accountUin = account;
        firstSwitchGuildTab = true;
        expData = null;
        isNewGuildUser = false;
        q.x(y());
        I();
        if (!q.l()) {
            q.i(y());
            logger.d().i("Guild.discovery.GuildDiscoverABTestHelper", 1, account + " guild tab is not open");
            return;
        }
        D();
    }

    public final void p() {
        IGProGuildBottomTabExpData iGProGuildBottomTabExpData = expData;
        if (iGProGuildBottomTabExpData == null) {
            return;
        }
        Intrinsics.checkNotNull(iGProGuildBottomTabExpData);
        ExpDataForCacheSave expDataForCacheSave = new ExpDataForCacheSave(iGProGuildBottomTabExpData);
        expDataForCacheSave.clearNewUserData();
        expData = expDataForCacheSave;
        H();
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "Guild.discovery.GuildDiscoverABTestHelper clearNewUserData", Boolean.FALSE, null, null, new GuildDiscoverABTestHelper$clearNewUserData$1(expDataForCacheSave, null), 12, null);
        }
        Logger.f235387a.d().d("Guild.discovery.GuildDiscoverABTestHelper", 1, "clearNewUserData " + expData);
    }

    @Nullable
    public final IGProGuildBottomTabExpData v() {
        IGProGuildBottomTabExpData iGProGuildBottomTabExpData = expData;
        if (iGProGuildBottomTabExpData != null) {
            return iGProGuildBottomTabExpData;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("getBottomTabExpData, expData is null");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.discovery.GuildDiscoverABTestHelper", 1, (String) it.next(), null);
        }
        return null;
    }

    public final int x() {
        int i3 = debugGuildTabPageType;
        if (i3 != 0) {
            return i3;
        }
        return guildTabPageType;
    }
}
