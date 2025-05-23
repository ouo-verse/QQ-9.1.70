package com.tencent.mobileqq.guild.feed.nativepublish.edittext;

import android.app.Activity;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.input.at.utils.data.AtUserWithRoleInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildTextUtil;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMviUIState;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextVB;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextVM$hashtagDetectCallback$2;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextVM$urlDetectCallback$2;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.a;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.b;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.e;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.HashtagCharTextWatcherPlugin;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.LinkTextWatcherPlugin;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.msgintent.SimplifiedFeedEditorGlobalMsgIntent;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopicInfo;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002CH\u0018\u0000 P2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00072\u00020\b2\u00020\t:\u0001QB\u0011\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u00a2\u0006\u0004\bN\u0010OJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J8\u0010&\u001a2\u0012\u0012\u0012\u0010\u0012\b\u0012\u00060\u001fj\u0002` 0\u001ej\u0002`!\u0012\u0012\u0012\u0010\u0012\b\u0012\u00060\"j\u0002`#0\u001ej\u0002`$\u0018\u00010\u001dj\u0004\u0018\u0001`%H\u0002J\b\u0010'\u001a\u00020\u0017H\u0002J\n\u0010)\u001a\u0004\u0018\u00010(H\u0002J\b\u0010*\u001a\u00020\u000fH\u0003R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u00101\u001a\u0004\bE\u0010FR\u001b\u0010K\u001a\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u00101\u001a\u0004\bI\u0010J\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVM;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVM;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/input/base/mvicompat/ex/a;", "", "", "J2", "f0", "context", "", "B", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", HippyTKDListViewAdapter.X, "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", "Lcom/tencent/mvi/base/route/k;", "I", "y", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lao1/a;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTopicInfo;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/topic/panel/TopicSearchResultGProItem;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/topic/panel/TopicSearchResult;", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/topic/panel/TopicCandidateWordUIData;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/topic/panel/TopicSearchUIResult;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/topic/panel/TopicSelectPanelManager;", "u", "w", "Landroid/text/Editable;", BdhLogUtil.LogTag.Tag_Conn, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "d", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "vmMessengerProtocolSupport", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/LinkTextWatcherPlugin;", "e", "Lkotlin/Lazy;", "t", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/LinkTextWatcherPlugin;", "linkTextWatcherPlugin", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/HashtagCharTextWatcherPlugin;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/HashtagCharTextWatcherPlugin;", "hashtagCharTextWatcherPlugin", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/g;", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/g;", "hashtagGuildJumpPlugin", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher;", "i", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher;", "specialCharDetectTextWatcher", "com/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVM$hashtagDetectCallback$2$a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVM$hashtagDetectCallback$2$a;", "hashtagDetectCallback", "com/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVM$urlDetectCallback$2$a", "v", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVM$urlDetectCallback$2$a;", "urlDetectCallback", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVB$b;", DownloadInfo.spKey_Config, "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVB$b;)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedEditTextVM extends BaseVM<b, GuildFeedEditTextMviUIState, com.tencent.base.api.runtime.a<zl1.a>> implements LifecycleObserver, com.tencent.input.base.mvicompat.ex.a {

    @NotNull
    private static final a D = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy urlDetectCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VMMessengerProtocolSupport vmMessengerProtocolSupport = new VMMessengerProtocolSupport(this);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy linkTextWatcherPlugin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy hashtagCharTextWatcherPlugin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy hashtagGuildJumpPlugin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private SpecialCharDetectTextWatcher specialCharDetectTextWatcher;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy hashtagDetectCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public GuildFeedEditTextVM(@Nullable GuildFeedEditTextVB.b bVar) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<LinkTextWatcherPlugin>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextVM$linkTextWatcherPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinkTextWatcherPlugin invoke() {
                GuildFeedEditTextVM$urlDetectCallback$2.a v3;
                Fragment c16 = ((com.tencent.base.api.runtime.a) GuildFeedEditTextVM.this.getMContext()).c();
                Intrinsics.checkNotNullExpressionValue(c16, "mContext.fragment");
                LinkTextWatcherPlugin linkTextWatcherPlugin = new LinkTextWatcherPlugin(LifecycleOwnerKt.getLifecycleScope(c16));
                v3 = GuildFeedEditTextVM.this.v();
                linkTextWatcherPlugin.z(v3);
                return linkTextWatcherPlugin;
            }
        });
        this.linkTextWatcherPlugin = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HashtagCharTextWatcherPlugin>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextVM$hashtagCharTextWatcherPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashtagCharTextWatcherPlugin invoke() {
                GuildFeedEditTextVM$hashtagDetectCallback$2.a r16;
                HashtagCharTextWatcherPlugin hashtagCharTextWatcherPlugin = new HashtagCharTextWatcherPlugin();
                r16 = GuildFeedEditTextVM.this.r();
                hashtagCharTextWatcherPlugin.T(r16);
                return hashtagCharTextWatcherPlugin;
            }
        });
        this.hashtagCharTextWatcherPlugin = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new GuildFeedEditTextVM$hashtagGuildJumpPlugin$2(this));
        this.hashtagGuildJumpPlugin = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<GuildFeedEditTextVM$hashtagDetectCallback$2.a>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextVM$hashtagDetectCallback$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVM$hashtagDetectCallback$2$a", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/HashtagCharTextWatcherPlugin$a;", "", "keyword", "", "b", "a", "Ljava/lang/String;", "currentKeyword", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements HashtagCharTextWatcherPlugin.a {

                /* renamed from: a, reason: collision with root package name and from kotlin metadata */
                @Nullable
                private String currentKeyword;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ GuildFeedEditTextVM f221891b;

                a(GuildFeedEditTextVM guildFeedEditTextVM) {
                    this.f221891b = guildFeedEditTextVM;
                }

                @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.HashtagCharTextWatcherPlugin.a
                public void a() {
                    QLog.d("GuildFeedEditTextVM", 4, "stopSearch");
                    GuildFeedEditTextVM.n(this.f221891b);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.HashtagCharTextWatcherPlugin.a
                public void b(@NotNull String keyword) {
                    Intrinsics.checkNotNullParameter(keyword, "keyword");
                    QLog.d("GuildFeedEditTextVM", 4, "triggerSearch|keyword='" + keyword + "'");
                    this.currentKeyword = keyword;
                    GuildFeedEditTextVM.n(this.f221891b);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildFeedEditTextVM.this);
            }
        });
        this.hashtagDetectCallback = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<GuildFeedEditTextVM$urlDetectCallback$2.a>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextVM$urlDetectCallback$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVM$urlDetectCallback$2$a", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/LinkTextWatcherPlugin$a;", "", "Lkotlin/Triple;", "Lsk1/b;", "", "", ForwardMiniChooseFriendOption.RESULT_LIST, "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements LinkTextWatcherPlugin.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ GuildFeedEditTextVM f221892a;

                a(GuildFeedEditTextVM guildFeedEditTextVM) {
                    this.f221892a = guildFeedEditTextVM;
                }

                @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.LinkTextWatcherPlugin.a
                public void a(@NotNull List<Triple<sk1.b, String, Integer>> results) {
                    Intrinsics.checkNotNullParameter(results, "results");
                    this.f221892a.updateUI(new GuildFeedEditTextMviUIState.UpdateLinkSpan(results));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildFeedEditTextVM.this);
            }
        });
        this.urlDetectCallback = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Editable A(GuildFeedEditTextVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.C();
    }

    private final Editable C() {
        e.a aVar = new e.a();
        fetchVBState(aVar);
        return aVar.getEditableText();
    }

    public static final /* synthetic */ ao1.a n(GuildFeedEditTextVM guildFeedEditTextVM) {
        guildFeedEditTextVM.u();
        return null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        updateUI(GuildFeedEditTextMviUIState.HideKeyboard.f221847d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final CharSequence p() {
        boolean z16;
        boolean z17;
        String str;
        if (((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).getHintText().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return ((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).getHintText();
        }
        Object h16 = ((com.tencent.base.api.runtime.a) getMContext()).h();
        Intrinsics.checkNotNullExpressionValue(h16, "mContext.baseParam");
        if (zl1.b.o((zl1.a) h16)) {
            String string = ((com.tencent.base.api.runtime.a) getMContext()).f().getString(R.string.f1522619x);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.activity.getStr\u2026g.guild_publish_new_feed)");
            return string;
        }
        IGProChannelInfo B = ch.B(((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).a());
        if (B != null && B.isHiddenPostChannel()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            String string2 = ((com.tencent.base.api.runtime.a) getMContext()).f().getString(R.string.f1522619x);
            Intrinsics.checkNotNullExpressionValue(string2, "mContext.activity.getStr\u2026g.guild_publish_new_feed)");
            return string2;
        }
        Activity f16 = ((com.tencent.base.api.runtime.a) getMContext()).f();
        Object[] objArr = new Object[1];
        if (B != null) {
            str = B.getChannelName();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        String string3 = f16.getString(R.string.f1522819z, objArr);
        Intrinsics.checkNotNullExpressionValue(string3, "mContext.activity.getStr\u2026annel?.channelName ?: \"\")");
        return string3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashtagCharTextWatcherPlugin q() {
        return (HashtagCharTextWatcherPlugin) this.hashtagCharTextWatcherPlugin.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildFeedEditTextVM$hashtagDetectCallback$2.a r() {
        return (GuildFeedEditTextVM$hashtagDetectCallback$2.a) this.hashtagDetectCallback.getValue();
    }

    private final com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.g s() {
        return (com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.g) this.hashtagGuildJumpPlugin.getValue();
    }

    private final LinkTextWatcherPlugin t() {
        return (LinkTextWatcherPlugin) this.linkTextWatcherPlugin.getValue();
    }

    private final ao1.a<List<GProTopicInfo>, List<Object>> u() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildFeedEditTextVM$urlDetectCallback$2.a v() {
        return (GuildFeedEditTextVM$urlDetectCallback$2.a) this.urlDetectCallback.getValue();
    }

    private final k w() {
        Editable C = C();
        if (C == null) {
            C = new SpannableStringBuilder();
        }
        return new a.b(C);
    }

    private final void y() {
        updateUI(new GuildFeedEditTextMviUIState.UpdateHintText(p()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(s());
        if (((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).getConfiguration().getIsSupportHashtag()) {
            linkedList.add(q());
        }
        com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.a aVar = new com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.a(true, true);
        aVar.j(((com.tencent.base.api.runtime.a) getMContext()).e());
        linkedList.add(aVar);
        linkedList.add(t());
        Object[] array = linkedList.toArray(new SpecialCharDetectTextWatcher.b[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        SpecialCharDetectTextWatcher specialCharDetectTextWatcher = new SpecialCharDetectTextWatcher((SpecialCharDetectTextWatcher.b[]) array);
        specialCharDetectTextWatcher.a(new Supplier() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.f
            @Override // androidx.core.util.Supplier
            public final Object get() {
                Editable A;
                A = GuildFeedEditTextVM.A(GuildFeedEditTextVM.this);
                return A;
            }
        });
        this.specialCharDetectTextWatcher = specialCharDetectTextWatcher;
        updateUI(new GuildFeedEditTextMviUIState.SetTextChangeWatcher(specialCharDetectTextWatcher, true));
        SpecialCharDetectTextWatcher specialCharDetectTextWatcher2 = this.specialCharDetectTextWatcher;
        if (specialCharDetectTextWatcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("specialCharDetectTextWatcher");
            specialCharDetectTextWatcher2 = null;
        }
        updateUI(new GuildFeedEditTextMviUIState.SetInputFilter(specialCharDetectTextWatcher2, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<zl1.a> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate((GuildFeedEditTextVM) context);
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.vmMessengerProtocolSupport;
        j e16 = context.e();
        Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
        vMMessengerProtocolSupport.d(e16);
        ((com.tencent.base.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
        z();
        y();
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof GuildFeedEditTextMsgIntent.ReplyTextByEmoji) {
            GuildFeedEditTextMsgIntent.ReplyTextByEmoji replyTextByEmoji = (GuildFeedEditTextMsgIntent.ReplyTextByEmoji) event;
            updateUI(new GuildFeedEditTextMviUIState.ReplyTextByEmoji(replyTextByEmoji.getEmojiType(), replyTextByEmoji.getEmojiCode()));
            return;
        }
        if (event instanceof GuildFeedEditTextMsgIntent.ReplyTextByAt) {
            for (IGProUserInfo iGProUserInfo : ((GuildFeedEditTextMsgIntent.ReplyTextByAt) event).a()) {
                if (iGProUserInfo instanceof AtUserWithRoleInfo) {
                    AtUserWithRoleInfo atUserWithRoleInfo = (AtUserWithRoleInfo) iGProUserInfo;
                    updateUI(new GuildFeedEditTextMviUIState.ReplyTextByAt(atUserWithRoleInfo.getTinyId(), atUserWithRoleInfo.getName(), atUserWithRoleInfo.getAtType(), atUserWithRoleInfo.getAtRole()));
                } else {
                    String tinyId = iGProUserInfo.getTinyId();
                    Intrinsics.checkNotNullExpressionValue(tinyId, "it.tinyId");
                    String name = iGProUserInfo.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.displayName");
                    updateUI(new GuildFeedEditTextMviUIState.ReplyTextByAt(tinyId, name, 2, null));
                }
            }
            return;
        }
        if (event instanceof GuildFeedEditTextMsgIntent.ReplyTextByHashtag) {
            GuildFeedEditTextMsgIntent.ReplyTextByHashtag replyTextByHashtag = (GuildFeedEditTextMsgIntent.ReplyTextByHashtag) event;
            updateUI(new GuildFeedEditTextMviUIState.ReplyTextByHashtag(replyTextByHashtag.getChannelUin(), replyTextByHashtag.getChannelName(), replyTextByHashtag.getChannelType(), replyTextByHashtag.getType()));
            return;
        }
        if (event instanceof GuildFeedEditTextMsgIntent.ReplyTextByGroupTag) {
            GuildFeedEditTextMsgIntent.ReplyTextByGroupTag replyTextByGroupTag = (GuildFeedEditTextMsgIntent.ReplyTextByGroupTag) event;
            updateUI(new GuildFeedEditTextMviUIState.ReplyTextByGroupTag(replyTextByGroupTag.getGroupCode(), replyTextByGroupTag.getGroupName()));
            return;
        }
        if (event instanceof GuildFeedEditTextMsgIntent.SetEditText) {
            GuildFeedEditTextMsgIntent.SetEditText setEditText = (GuildFeedEditTextMsgIntent.SetEditText) event;
            t().w(setEditText.getEditable());
            com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.g.INSTANCE.a(setEditText.getEditable(), new IntRange(0, setEditText.getEditable().length()));
            updateUI(new GuildFeedEditTextMviUIState.SetEditText(setEditText.getEditable()));
            return;
        }
        if (event instanceof GuildFeedEditTextMsgIntent.ShowKeyboard) {
            updateUI(GuildFeedEditTextMviUIState.ShowKeyboard.f221869d);
        } else if (event instanceof GuildFeedEditTextMsgIntent.InsertTextAtSelection) {
            GuildFeedEditTextMsgIntent.InsertTextAtSelection insertTextAtSelection = (GuildFeedEditTextMsgIntent.InsertTextAtSelection) event;
            updateUI(new GuildFeedEditTextMviUIState.InsertTextAtSelection(insertTextAtSelection.getText(), insertTextAtSelection.getIndex(), insertTextAtSelection.getSkipTextWatcher()));
        }
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public k I(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof GuildFeedEditTextMsgIntent.GetEditableText) {
            return w();
        }
        return new a.C7764a();
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> J2() {
        List<String> listOf;
        String b16 = com.tencent.mvi.base.route.c.b(GuildFeedEditTextMsgIntent.ReplyTextByEmoji.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        String b17 = com.tencent.mvi.base.route.c.b(GuildFeedEditTextMsgIntent.ReplyTextByAt.class);
        Intrinsics.checkNotNullExpressionValue(b17, "get(java)");
        String b18 = com.tencent.mvi.base.route.c.b(GuildFeedEditTextMsgIntent.ReplyTextByHashtag.class);
        Intrinsics.checkNotNullExpressionValue(b18, "get(java)");
        String b19 = com.tencent.mvi.base.route.c.b(GuildFeedEditTextMsgIntent.SetEditText.class);
        Intrinsics.checkNotNullExpressionValue(b19, "get(java)");
        String b26 = com.tencent.mvi.base.route.c.b(GuildFeedEditTextMsgIntent.ShowKeyboard.class);
        Intrinsics.checkNotNullExpressionValue(b26, "get(java)");
        String b27 = com.tencent.mvi.base.route.c.b(GuildFeedEditTextMsgIntent.ReplyTextByGroupTag.class);
        Intrinsics.checkNotNullExpressionValue(b27, "get(java)");
        String b28 = com.tencent.mvi.base.route.c.b(GuildFeedEditTextMsgIntent.InsertTextAtSelection.class);
        Intrinsics.checkNotNullExpressionValue(b28, "get(java)");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{b16, b17, b18, b19, b26, b27, b28});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> f0() {
        List<String> listOf;
        String b16 = com.tencent.mvi.base.route.c.b(GuildFeedEditTextMsgIntent.GetEditableText.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(b16);
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.vmMessengerProtocolSupport;
        j e16 = ((com.tencent.base.api.runtime.a) getMContext()).e();
        Intrinsics.checkNotNullExpressionValue(e16, "mContext.messenger");
        vMMessengerProtocolSupport.e(e16);
        ((com.tencent.base.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
        SpecialCharDetectTextWatcher specialCharDetectTextWatcher = this.specialCharDetectTextWatcher;
        if (specialCharDetectTextWatcher != null) {
            if (specialCharDetectTextWatcher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("specialCharDetectTextWatcher");
                specialCharDetectTextWatcher = null;
            }
            updateUI(new GuildFeedEditTextMviUIState.SetTextChangeWatcher(specialCharDetectTextWatcher, false));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b intent) {
        com.tencent.base.api.runtime.a aVar;
        j e16;
        boolean z16;
        Intrinsics.checkNotNullParameter(intent, "intent");
        boolean z17 = false;
        if (intent instanceof b.TextChangedIntent) {
            Editable s16 = ((b.TextChangedIntent) intent).getS();
            StringBuilder sb5 = new StringBuilder();
            int length = s16.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = s16.charAt(i3);
                if (charAt != ' ' && charAt != '\n') {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    sb5.append(charAt);
                }
            }
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(new GuildFeedEditTextMsgIntent.OnTextChanged(((IGuildTextUtil) QRoute.api(IGuildTextUtil.class)).countText(sb5)));
            return;
        }
        SpecialCharDetectTextWatcher specialCharDetectTextWatcher = null;
        if (intent instanceof b.d) {
            SpecialCharDetectTextWatcher specialCharDetectTextWatcher2 = this.specialCharDetectTextWatcher;
            if (specialCharDetectTextWatcher2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("specialCharDetectTextWatcher");
            } else {
                specialCharDetectTextWatcher = specialCharDetectTextWatcher2;
            }
            specialCharDetectTextWatcher.b();
            return;
        }
        if (intent instanceof b.a) {
            SpecialCharDetectTextWatcher specialCharDetectTextWatcher3 = this.specialCharDetectTextWatcher;
            if (specialCharDetectTextWatcher3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("specialCharDetectTextWatcher");
            } else {
                specialCharDetectTextWatcher = specialCharDetectTextWatcher3;
            }
            specialCharDetectTextWatcher.d(((b.a) intent).getBlockTextDetectFlag());
            return;
        }
        if (intent instanceof b.e) {
            j e17 = ((com.tencent.base.api.runtime.a) getMContext()).e();
            if (((b.e) intent).getDirection() < 0) {
                z17 = true;
            }
            e17.h(new SimplifiedFeedEditorGlobalMsgIntent.ChangeDisplayMode(z17));
            return;
        }
        if ((intent instanceof b.C7765b) && (aVar = (com.tencent.base.api.runtime.a) getSafetyContext()) != null && (e16 = aVar.e()) != null) {
            e16.h(new SimplifiedFeedEditorGlobalMsgIntent.ChangeDisplayMode(true));
        }
    }
}
