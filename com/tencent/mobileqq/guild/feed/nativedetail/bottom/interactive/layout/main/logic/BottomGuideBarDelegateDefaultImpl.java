package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic;

import android.content.Context;
import androidx.core.util.Supplier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import co1.k;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.data.s;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.base.GuideBarGuildInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBatchGetGuildLabelInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.r;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import okio.internal._Utf8Kt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;
import wk1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u0007*\u0001>\b\u0016\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001\u000fB_\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0018\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018\u0012\u0010\u0010%\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\"\u0012\b\b\u0002\u0010)\u001a\u00020&\u00a2\u0006\u0004\b\\\u0010]J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u001e\u0010%\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00108\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010(R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010G\u001a\u00020B8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001b\u0010M\u001a\u00020H8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0016\u0010P\u001a\u0004\u0018\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010QR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010UR\u0014\u0010W\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010UR\u0016\u0010[\u001a\u0004\u0018\u00010X8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bY\u0010Z\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/BottomGuideBarDelegateDefaultImpl;", "Lwk1/a;", "Landroidx/lifecycle/LifecycleEventObserver;", "", "guildId", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/GuideBarGuildInfo;", "v", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "Lkotlinx/coroutines/flow/Flow;", "a", "Landroid/content/Context;", "f", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/data/s;", tl.h.F, "Lcom/tencent/mobileqq/guild/data/s;", "contact", "Landroidx/core/util/Supplier;", "", "i", "Landroidx/core/util/Supplier;", "businessTypeProvider", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "joinGuildParamProvider", BdhLogUtil.LogTag.Tag_Conn, "extensionProvider", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "viewLifecycleOwnerLiveData", "", "E", "Z", "needRegisterGPServiceObserver", "Ljava/lang/Runnable;", UserInfo.SEX_FEMALE, "Ljava/lang/Runnable;", "w", "()Ljava/lang/Runnable;", "y", "(Ljava/lang/Runnable;)V", "enterGuildOperationDelegate", "Lwk1/g$a;", "<set-?>", "G", "Lwk1/g$a;", HippyTKDListViewAdapter.X, "()Lwk1/g$a;", "guildOperationDelegateCallback", "H", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/GuideBarGuildInfo;", "modelCached", "I", "isCacheReusable", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/BottomGuideBarDelegateDefaultImpl$e", "J", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/BottomGuideBarDelegateDefaultImpl$e;", "serviceObserver", "Lwk1/g;", "K", "Lwk1/g;", "d", "()Lwk1/g;", "guildOperationDelegate", "Lco1/k;", "L", "Lkotlin/Lazy;", "e", "()Lco1/k;", "reportDelegate", "g", "()Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "()I", "sourceBusinessType", "c", "()Ljava/lang/String;", "()Z", "isExperiment", "isMemberSync", "", "b", "()[I", "colorConfig", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/data/s;Landroidx/core/util/Supplier;Landroidx/core/util/Supplier;Landroidx/core/util/Supplier;Landroidx/lifecycle/LiveData;Z)V", "M", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class BottomGuideBarDelegateDefaultImpl extends wk1.a implements LifecycleEventObserver {

    @NotNull
    private static final a M = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Supplier<String> extensionProvider;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<? extends LifecycleOwner> viewLifecycleOwnerLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean needRegisterGPServiceObserver;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Runnable enterGuildOperationDelegate;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private g.a guildOperationDelegateCallback;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private volatile GuideBarGuildInfo modelCached;

    /* renamed from: I, reason: from kotlin metadata */
    private volatile boolean isCacheReusable;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final e serviceObserver;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final wk1.g guildOperationDelegate;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy reportDelegate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final s contact;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<Integer> businessTypeProvider;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<JumpGuildParam.JoinInfoParam> joinGuildParamProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/BottomGuideBarDelegateDefaultImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f220641a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f220641a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBatchGetGuildLabelInfoRsp;", "rsp", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBatchGetGuildLabelInfoRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements wh2.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<GuideBarGuildInfo> f220642a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f220643b;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super GuideBarGuildInfo> cancellableContinuation, String str) {
            this.f220642a = cancellableContinuation;
            this.f220643b = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005f, code lost:
        
            if (r12 == null) goto L16;
         */
        @Override // wh2.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(int i3, String str, IGProBatchGetGuildLabelInfoRsp iGProBatchGetGuildLabelInfoRsp) {
            Object firstOrNull;
            Object firstOrNull2;
            String str2;
            byte[] labelName;
            if (i3 == 0 && iGProBatchGetGuildLabelInfoRsp != null) {
                ArrayList<IGProGuildLabelInfo> list = iGProBatchGetGuildLabelInfoRsp.getList();
                Intrinsics.checkNotNullExpressionValue(list, "rsp.list");
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                IGProGuildLabelInfo iGProGuildLabelInfo = (IGProGuildLabelInfo) firstOrNull;
                if (iGProGuildLabelInfo == null) {
                    QLog.e("BottomGuideBarDelegateDefaultImpl", 1, "batchGetGuildLabelInfo|has responded but there is nothing info");
                    this.f220642a.resumeWith(Result.m476constructorimpl(null));
                    return;
                }
                CancellableContinuation<GuideBarGuildInfo> cancellableContinuation = this.f220642a;
                String str3 = this.f220643b;
                String guildName = iGProGuildLabelInfo.getGuildName();
                String guildIcon = iGProGuildLabelInfo.getGuildIcon();
                ArrayList<IGProGuildLabel> labels = iGProGuildLabelInfo.getLabels();
                Intrinsics.checkNotNullExpressionValue(labels, "it.labels");
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) labels);
                IGProGuildLabel iGProGuildLabel = (IGProGuildLabel) firstOrNull2;
                if (iGProGuildLabel != null && (labelName = iGProGuildLabel.getLabelName()) != null) {
                    Intrinsics.checkNotNullExpressionValue(labelName, "labelName");
                    str2 = _Utf8Kt.commonToUtf8String$default(labelName, 0, 0, 3, null);
                }
                str2 = "";
                cancellableContinuation.resumeWith(Result.m476constructorimpl(new GuideBarGuildInfo(str3, guildName, guildIcon, null, str2, 8, null)));
                return;
            }
            QLog.e("BottomGuideBarDelegateDefaultImpl", 1, "batchGetGuildLabelInfo|result=" + i3 + ", errMsg=" + str);
            this.f220642a.resumeWith(Result.m476constructorimpl(null));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/BottomGuideBarDelegateDefaultImpl$d", "Lwk1/g;", "Lwk1/g$a;", "callback", "", "c", "b", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements wk1.g {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(BottomGuideBarDelegateDefaultImpl this$0, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.i("BottomGuideBarDelegateDefaultImpl", 1, "onJoinGuild result=" + i3 + " errMsg=" + str + " security=" + iGProSecurityResult);
            if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
                g.a guildOperationDelegateCallback = this$0.getGuildOperationDelegateCallback();
                if (guildOperationDelegateCallback != null) {
                    guildOperationDelegateCallback.f((short) 1);
                    return;
                }
                return;
            }
            g.a guildOperationDelegateCallback2 = this$0.getGuildOperationDelegateCallback();
            if (guildOperationDelegateCallback2 != null) {
                guildOperationDelegateCallback2.f((short) 2);
            }
            com.tencent.mobileqq.guild.channel.joinchannel.h.c(this$0.context, i3, str, iGProSecurityResult);
        }

        @Override // wk1.g
        public void a() {
            Runnable enterGuildOperationDelegate = BottomGuideBarDelegateDefaultImpl.this.getEnterGuildOperationDelegate();
            if (enterGuildOperationDelegate == null) {
                Context context = BottomGuideBarDelegateDefaultImpl.this.context;
                JumpGuildParam jumpGuildParam = new JumpGuildParam(BottomGuideBarDelegateDefaultImpl.this.contact.getGuildId(), "");
                JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) BottomGuideBarDelegateDefaultImpl.this.joinGuildParamProvider.get();
                if (joinInfoParam != null) {
                    jumpGuildParam.setJoinInfoParam(joinInfoParam);
                }
                GuildJumpUtil.n(context, jumpGuildParam);
                return;
            }
            enterGuildOperationDelegate.run();
        }

        @Override // wk1.g
        public void b() {
            boolean z16;
            JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) BottomGuideBarDelegateDefaultImpl.this.joinGuildParamProvider.get();
            if (joinInfoParam != null) {
                String mainSource = joinInfoParam.getMainSource();
                if (mainSource != null && mainSource.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    JumpGuildParam jumpGuildParam = new JumpGuildParam(BottomGuideBarDelegateDefaultImpl.this.contact.getGuildId(), "", joinInfoParam.getJoinSignature(), joinInfoParam.getMainSource(), joinInfoParam.getSubSource());
                    jumpGuildParam.extras.putString("sgrp_channel_extension_info", (String) BottomGuideBarDelegateDefaultImpl.this.extensionProvider.get());
                    jumpGuildParam.setArkJumpId(joinInfoParam.getArkInviteCode(), joinInfoParam.getArkContentId());
                    jumpGuildParam.getJoinInfoParam().setInviteUUID(joinInfoParam.getInviteUUID());
                    Context context = BottomGuideBarDelegateDefaultImpl.this.context;
                    JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
                    jumpParam.c(false);
                    Unit unit = Unit.INSTANCE;
                    final BottomGuideBarDelegateDefaultImpl bottomGuideBarDelegateDefaultImpl = BottomGuideBarDelegateDefaultImpl.this;
                    com.tencent.mobileqq.guild.channel.joinchannel.h.a(context, jumpGuildParam, jumpParam, "BottomGuideBarDelegateDefaultImpl", new bv() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.b
                        @Override // vh2.bv
                        public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                            BottomGuideBarDelegateDefaultImpl.d.e(BottomGuideBarDelegateDefaultImpl.this, i3, str, iGProSecurityResult, iGProJoinGuildResult);
                        }
                    });
                    return;
                }
            }
            QLog.e("BottomGuideBarDelegateDefaultImpl", 1, "missing joinInfoParam or mainSource, joinParam=" + joinInfoParam);
        }

        @Override // wk1.g
        public void c(@Nullable g.a callback) {
            BottomGuideBarDelegateDefaultImpl.this.guildOperationDelegateCallback = callback;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/BottomGuideBarDelegateDefaultImpl$e", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "onAddGuildWithInfo", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "black", "onBeKickFromGuild", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e extends GPServiceObserver {
        e() {
        }

        private final void b(String guildId) {
            g.a guildOperationDelegateCallback;
            if (Intrinsics.areEqual(BottomGuideBarDelegateDefaultImpl.this.contact.getGuildId(), guildId) && (guildOperationDelegateCallback = BottomGuideBarDelegateDefaultImpl.this.getGuildOperationDelegateCallback()) != null) {
                guildOperationDelegateCallback.f((short) 2);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@NotNull IGProGuildInfo info, int sourceType) {
            g.a guildOperationDelegateCallback;
            Intrinsics.checkNotNullParameter(info, "info");
            if (Intrinsics.areEqual(info.getGuildID(), BottomGuideBarDelegateDefaultImpl.this.contact.getGuildId()) && (guildOperationDelegateCallback = BottomGuideBarDelegateDefaultImpl.this.getGuildOperationDelegateCallback()) != null) {
                guildOperationDelegateCallback.f((short) 1);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@NotNull String guildId, int black) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            b(guildId);
        }
    }

    public /* synthetic */ BottomGuideBarDelegateDefaultImpl(Context context, s sVar, Supplier supplier, Supplier supplier2, Supplier supplier3, LiveData liveData, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, sVar, supplier, supplier2, supplier3, liveData, (i3 & 64) != 0 ? true : z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object v(String str, Continuation<? super GuideBarGuildInfo> continuation) {
        Continuation intercepted;
        AppInterface appInterface;
        Object coroutine_suspended;
        ArrayList<Long> arrayListOf;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            r rVar = new r();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Boxing.boxLong(MiscKt.l(str)));
            rVar.c(arrayListOf);
            rVar.d(2);
            iGPSService.batchGetGuildLabelInfo(rVar, new c(cancellableContinuationImpl, str));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // wk1.a
    @NotNull
    public Flow<GuideBarGuildInfo> a() {
        String str;
        String guildId = this.contact.getGuildId();
        GuideBarGuildInfo guideBarGuildInfo = this.modelCached;
        if (this.isCacheReusable) {
            if (guideBarGuildInfo != null) {
                str = guideBarGuildInfo.getGuildId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(guildId, str)) {
                return FlowKt.flowOf(guideBarGuildInfo);
            }
        }
        this.isCacheReusable = false;
        return FlowKt.flow(new BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$$inlined$transform$1(FlowKt.callbackFlow(new BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1(guildId, this, null)), null, this));
    }

    @Override // wk1.a
    @Nullable
    public int[] b() {
        return null;
    }

    @Override // wk1.a
    @NotNull
    public String c() {
        return this.contact.getGuildId();
    }

    @Override // wk1.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public wk1.g getGuildOperationDelegate() {
        return this.guildOperationDelegate;
    }

    @Override // wk1.a
    @NotNull
    public k e() {
        return (k) this.reportDelegate.getValue();
    }

    @Override // wk1.a
    public int f() {
        Integer num = this.businessTypeProvider.get();
        Intrinsics.checkNotNullExpressionValue(num, "businessTypeProvider.get()");
        return num.intValue();
    }

    @Override // wk1.a
    @Nullable
    public LifecycleOwner g() {
        return this.viewLifecycleOwnerLiveData.getValue();
    }

    @Override // wk1.a
    public boolean h() {
        return tl1.e.f436522a.a(true)[0];
    }

    @Override // wk1.a
    public boolean i() {
        return !ch.j0(this.contact.getGuildId());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        AppInterface appInterface;
        AppInterface appInterface2;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = b.f220641a[event.ordinal()];
        IRuntimeService iRuntimeService = null;
        if (i3 != 1) {
            if (i3 == 2) {
                source.getLifecycle().removeObserver(this);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    appInterface2 = (AppInterface) peekAppRuntime;
                } else {
                    appInterface2 = null;
                }
                if (appInterface2 != null) {
                    iRuntimeService = appInterface2.getRuntimeService(IGPSService.class, "");
                }
                IGPSService iGPSService = (IGPSService) iRuntimeService;
                if (iGPSService != null) {
                    iGPSService.deleteObserver(this.serviceObserver);
                    return;
                }
                return;
            }
            return;
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime2;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService2 = (IGPSService) iRuntimeService;
        if (iGPSService2 != null) {
            iGPSService2.addObserver(this.serviceObserver);
        }
    }

    @Nullable
    /* renamed from: w, reason: from getter */
    public final Runnable getEnterGuildOperationDelegate() {
        return this.enterGuildOperationDelegate;
    }

    @Nullable
    /* renamed from: x, reason: from getter */
    public final g.a getGuildOperationDelegateCallback() {
        return this.guildOperationDelegateCallback;
    }

    public final void y(@Nullable Runnable runnable) {
        this.enterGuildOperationDelegate = runnable;
    }

    public BottomGuideBarDelegateDefaultImpl(@NotNull Context context, @NotNull s contact, @NotNull Supplier<Integer> businessTypeProvider, @NotNull Supplier<JumpGuildParam.JoinInfoParam> joinGuildParamProvider, @NotNull Supplier<String> extensionProvider, @NotNull LiveData<? extends LifecycleOwner> viewLifecycleOwnerLiveData, boolean z16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(businessTypeProvider, "businessTypeProvider");
        Intrinsics.checkNotNullParameter(joinGuildParamProvider, "joinGuildParamProvider");
        Intrinsics.checkNotNullParameter(extensionProvider, "extensionProvider");
        Intrinsics.checkNotNullParameter(viewLifecycleOwnerLiveData, "viewLifecycleOwnerLiveData");
        this.context = context;
        this.contact = contact;
        this.businessTypeProvider = businessTypeProvider;
        this.joinGuildParamProvider = joinGuildParamProvider;
        this.extensionProvider = extensionProvider;
        this.viewLifecycleOwnerLiveData = viewLifecycleOwnerLiveData;
        this.needRegisterGPServiceObserver = z16;
        if (z16) {
            final Function1<LifecycleOwner, Unit> function1 = new Function1<LifecycleOwner, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LifecycleOwner lifecycleOwner) {
                    invoke2(lifecycleOwner);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable LifecycleOwner lifecycleOwner) {
                    Lifecycle lifecycle;
                    if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
                        return;
                    }
                    lifecycle.addObserver(BottomGuideBarDelegateDefaultImpl.this);
                }
            };
            viewLifecycleOwnerLiveData.observeForever(new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BottomGuideBarDelegateDefaultImpl.l(Function1.this, obj);
                }
            });
        }
        this.serviceObserver = new e();
        this.guildOperationDelegate = new d();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<k>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl$reportDelegate$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final k invoke() {
                return NavigatorUI.INSTANCE.a();
            }
        });
        this.reportDelegate = lazy;
    }
}
