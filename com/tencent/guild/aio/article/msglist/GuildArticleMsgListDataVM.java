package com.tencent.guild.aio.article.msglist;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.MsgListIntent;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.article.data.GuildArticleMsgListCenter;
import com.tencent.guild.aio.article.fragment.GuildArticleWrapperFragment;
import com.tencent.guild.aio.article.msglist.GuildArticleMsgListDataUIState;
import com.tencent.guild.aio.article.msglist.GuildArticleMsgListEvent;
import com.tencent.guild.aio.article.msglist.f;
import com.tencent.guild.aio.article.msglist.h;
import com.tencent.guild.aio.article.msglist.holder.GuildRefreshReplyNickEvent;
import com.tencent.guild.aio.article.msglist.i;
import com.tencent.guild.aio.article.title.GuildArticleTitleEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataState;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListViewState;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.highlight.HighLightViewHolderUIState;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guild.aio.util.flowbus.FlowEventReceiver;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmoPreviewApi;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0002rv\u0018\u0000 |2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001}B\u0007\u00a2\u0006\u0004\bz\u0010{J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000b\u001a\u00020\u0007H\u0007J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0006\u0010\u0017\u001a\u00020\u0007J*\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0002J\"\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0018H\u0002J$\u0010'\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u001fH\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0018H\u0002J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0018H\u0002J\u001a\u00102\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u000100H\u0002J\u0012\u00106\u001a\u0002052\b\u00104\u001a\u0004\u0018\u000103H\u0002J\u001a\u00108\u001a\u00020\u00072\u0006\u0010/\u001a\u0002032\b\u00107\u001a\u0004\u0018\u000100H\u0002J\u0010\u0010:\u001a\u0002052\u0006\u00109\u001a\u00020\u0018H\u0002J\u001c\u0010?\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010>\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010A\u001a\u00020@2\u0006\u0010*\u001a\u00020)H\u0002J\"\u0010F\u001a\u00020\u00072\b\b\u0002\u0010B\u001a\u0002052\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002J$\u0010J\u001a\u00020\u00072\u0006\u0010H\u001a\u00020G2\b\u0010&\u001a\u0004\u0018\u0001032\b\u0010I\u001a\u0004\u0018\u000103H\u0002J\u0012\u0010L\u001a\u00020\u00072\b\b\u0002\u0010K\u001a\u000205H\u0002J\b\u0010M\u001a\u00020\u0007H\u0002J\b\u0010N\u001a\u00020\u0007H\u0002J\u0010\u0010P\u001a\u00020\u00072\u0006\u0010O\u001a\u000205H\u0002J\u0010\u0010S\u001a\u00020\u00072\u0006\u0010R\u001a\u00020QH\u0002J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010R\u001a\u00020QH\u0002J\u0010\u0010U\u001a\u00020\u00072\u0006\u0010R\u001a\u00020QH\u0002J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010R\u001a\u00020QH\u0002J\b\u0010X\u001a\u00020WH\u0002R\u0018\u0010[\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010ZR\u0014\u0010`\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010_R$\u0010e\u001a\u0012\u0012\u0004\u0012\u00020b0aj\b\u0012\u0004\u0012\u00020b`c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010dR\u0016\u0010h\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010nR\u0014\u0010q\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010pR\u0014\u0010u\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010y\u001a\u00020v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010x\u00a8\u0006~"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListDataVM;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "o", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$a;", "p", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", UserInfo.SEX_FEMALE, "implState", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataState;", "P", "w", "x0", "", HippyTKDListViewAdapter.SCROLL_STATE, "Lcom/tencent/aio/data/msglist/a;", "firstMsg", "firstPosition", "lastPosition", "e0", "", "springBackDistance", "X", "Y", "h0", "position", "Z", "aioTopMsg", ExifInterface.LATITUDE_SOUTH, "i0", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "E", "height", "a0", "j0", "msgItem", "Landroid/view/View;", "msgBubbleView", "d0", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msg", "", "k0", "clickedView", "u0", "type", "l0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "w0", "Lcom/tencent/mvi/base/route/k;", "I", "forceUpdate", "", "", "payloads", "p0", "", "source", "aioBottomMsg", "U", FileReaderHelper.OPEN_FILE_FROM_FORCE, "y0", "c0", "b0", "isSuccess", "W", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "o0", "m0", "n0", "g0", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", BdhLogUtil.LogTag.Tag_Req, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/data/msglist/a;", "topAIOMsg", "D", "bottomAIOMsg", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "eventReceiver", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "visibleIds", "G", "J", "mFirstUnreadMsgSeq", "Lcom/tencent/guild/aio/article/data/GuildArticleMsgListCenter;", "H", "Lcom/tencent/guild/aio/article/data/GuildArticleMsgListCenter;", "mMsgListCenter", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgRepoDelegate;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgRepoDelegate;", "mMsgRepoDelegate", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpsObserver", "com/tencent/guild/aio/article/msglist/GuildArticleMsgListDataVM$d", "K", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListDataVM$d;", "mAction", "com/tencent/guild/aio/article/msglist/GuildArticleMsgListDataVM$e", "L", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListDataVM$e;", "mActionR", "<init>", "()V", "M", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleMsgListDataVM extends MsgListVMWrapper<at.b, MsgListUiState> implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a topAIOMsg;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a bottomAIOMsg;

    /* renamed from: G, reason: from kotlin metadata */
    private long mFirstUnreadMsgSeq;

    /* renamed from: H, reason: from kotlin metadata */
    private GuildArticleMsgListCenter mMsgListCenter;

    /* renamed from: I, reason: from kotlin metadata */
    private GuildArticleMsgRepoDelegate mMsgRepoDelegate;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final FlowEventReceiver eventReceiver = new FlowEventReceiver(null, 1, null);

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Long> visibleIds = new ArrayList<>();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpsObserver = R();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final d mAction = new d();

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final e mActionR = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/article/msglist/GuildArticleMsgListDataVM$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "tinyId", "", "onMemberTopRoleChanged", "onUserDisplayNameUpdate", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onMemberTopRoleChanged(@Nullable String guildId, @Nullable String tinyId) {
            if (QLog.isDevelopLevel()) {
                QLog.i("GuildArticleMsgListDataVM", 4, "onMemberTopRoleChanged. guildId: " + guildId + ", tinyId: " + tinyId);
            }
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildArticleMsgListDataVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.g(g16), guildId) && tinyId != null) {
                up0.a.f439407a.h("TAG_MEMBER_ROLE_CACHE", com.tencent.guild.aio.util.h.f112401a.y(tinyId, ((com.tencent.aio.api.runtime.a) GuildArticleMsgListDataVM.this.getMContext()).g().r().c().j()));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            if (tinyId != null) {
                ((com.tencent.aio.api.runtime.a) GuildArticleMsgListDataVM.this.getMContext()).e().h(new GuildRefreshReplyNickEvent(tinyId));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/guild/aio/article/msglist/GuildArticleMsgListDataVM$c", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "lastMsg", "firstMsg", "", "b", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d {
        c() {
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        public boolean a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            GuildArticleMsgListCenter guildArticleMsgListCenter = GuildArticleMsgListDataVM.this.mMsgListCenter;
            if (guildArticleMsgListCenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgListCenter");
                guildArticleMsgListCenter = null;
            }
            return !guildArticleMsgListCenter.I();
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        public boolean b(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            GuildArticleMsgListCenter guildArticleMsgListCenter = GuildArticleMsgListDataVM.this.mMsgListCenter;
            if (guildArticleMsgListCenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgListCenter");
                guildArticleMsgListCenter = null;
            }
            return !guildArticleMsgListCenter.i();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/article/msglist/GuildArticleMsgListDataVM$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        d() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildArticleMsgListDataVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/article/msglist/GuildArticleMsgListDataVM$e", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e implements com.tencent.mvi.base.route.b {
        e() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return GuildArticleMsgListDataVM.this.I(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildMsgNavigateEvent.GuildNavigateToMsgEvent) {
            m().A(((GuildMsgNavigateEvent.GuildNavigateToMsgEvent) i3).getMsgSeq());
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            q0(this, true, null, 2, null);
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GuildMsgListRefreshEvent) {
            p0(true, ((GuildMsgListIntent.GuildMsgListRefreshEvent) i3).a());
            return;
        }
        if (i3 instanceof GuildMsgNavigateEvent.GuildNavigateToAIOBottomEvent) {
            b0();
            return;
        }
        if (i3 instanceof GuildArticleTitleEvent.NavigateMainMsgIntent) {
            c0();
            return;
        }
        if (i3 instanceof GuildArticleMsgListEvent.FirstPageMsgInitCompleted) {
            W(((GuildArticleMsgListEvent.FirstPageMsgInitCompleted) i3).getIsSuccess());
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GuildMsgItemContentViewClickEvent) {
            GuildMsgListIntent.GuildMsgItemContentViewClickEvent guildMsgItemContentViewClickEvent = (GuildMsgListIntent.GuildMsgItemContentViewClickEvent) i3;
            d0(guildMsgItemContentViewClickEvent.getMsgItem(), guildMsgItemContentViewClickEvent.getMsgBubbleView());
            return;
        }
        if (i3 instanceof GuildArticleMsgListEvent.UpdateMsgItemState) {
            j0(((GuildArticleMsgListEvent.UpdateMsgItemState) i3).getPosition());
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GuildInputBarHeightChangEvent) {
            a0(((GuildMsgListIntent.GuildInputBarHeightChangEvent) i3).getHeight());
        } else if (i3 instanceof GuildArticleMsgListEvent.UpdateCanScrollUpState) {
            i0();
        } else if (i3 instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            updateUI(new GuildArticleMsgListDataUIState.PanelStatusChangedUIState());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent i3) {
        GuildArticleMsgListCenter guildArticleMsgListCenter = null;
        if (i3 instanceof GuildArticleMsgListEvent.MainMsgSeqGet) {
            GuildArticleMsgListCenter guildArticleMsgListCenter2 = this.mMsgListCenter;
            if (guildArticleMsgListCenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgListCenter");
            } else {
                guildArticleMsgListCenter = guildArticleMsgListCenter2;
            }
            return new h.c(guildArticleMsgListCenter.m());
        }
        if (i3 instanceof GuildArticleMsgListEvent.MainMsgIdGet) {
            GuildArticleMsgListCenter guildArticleMsgListCenter3 = this.mMsgListCenter;
            if (guildArticleMsgListCenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgListCenter");
            } else {
                guildArticleMsgListCenter = guildArticleMsgListCenter3;
            }
            return new h.a(guildArticleMsgListCenter.k());
        }
        if (i3 instanceof GuildArticleMsgListEvent.MainMsgRecordGet) {
            GuildArticleMsgListCenter guildArticleMsgListCenter4 = this.mMsgListCenter;
            if (guildArticleMsgListCenter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgListCenter");
            } else {
                guildArticleMsgListCenter = guildArticleMsgListCenter4;
            }
            return new h.b(guildArticleMsgListCenter.l());
        }
        return pn0.b.f426490a;
    }

    private final GPServiceObserver R() {
        return new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void S(com.tencent.aio.data.msglist.a aioTopMsg, int firstPosition, float springBackDistance) {
        Bundle bundle = new Bundle();
        if (aioTopMsg != null) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) aioTopMsg;
            if (!TextUtils.isEmpty(GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem, "guild_article_is_main_empty_msg", null, 2, null))) {
                bundle = fetchVBState(new i.b(firstPosition + 1, (int) springBackDistance)).b();
            } else if (!TextUtils.isEmpty(GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem, "guild_article_is_main_msg", null, 2, null))) {
                bundle = fetchVBState(new i.b(firstPosition, (int) springBackDistance)).b();
            }
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildArticleMsgListEvent.MainMsgViewScreenPositionChanged(bundle.getBoolean("guild_article_main_msg_is_showing", false), bundle.getInt("guild_article_main_msg_top_screen_position", Integer.MAX_VALUE), bundle.getInt("guild_article_main_msg_bottom_screen_position", Integer.MAX_VALUE)));
        }
    }

    static /* synthetic */ void T(GuildArticleMsgListDataVM guildArticleMsgListDataVM, com.tencent.aio.data.msglist.a aVar, int i3, float f16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            f16 = 0.0f;
        }
        guildArticleMsgListDataVM.S(aVar, i3, f16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U(String source, GuildMsgItem aioTopMsg, GuildMsgItem aioBottomMsg) {
        this.topAIOMsg = aioTopMsg;
        this.bottomAIOMsg = aioBottomMsg;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgListScrollEvent(source, aioTopMsg, aioBottomMsg, (GuildMsgItem) m().H()));
    }

    private final void W(boolean isSuccess) {
        if (isSuccess) {
            updateUI(new GuildArticleMsgListDataUIState.FirstPageMsgInitCompletedState());
        }
    }

    private final void X(float springBackDistance, com.tencent.aio.data.msglist.a firstMsg, int firstPosition) {
        S((GuildMsgItem) firstMsg, firstPosition, springBackDistance);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Y() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildArticleMsgListDataVM", false, 2, null));
    }

    private final void Z(int position) {
        List<com.tencent.aio.data.msglist.a> l3 = l();
        if (l3 == null) {
            l3 = new CopyOnWriteArrayList<>();
        }
        if (l3.size() > position) {
            com.tencent.aio.data.msglist.a aVar = l3.get(position);
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            updateUI(new HighLightViewHolderUIState(position, ((GuildMsgItem) aVar).getMsgRecord(), 0, new Bundle(), null, 16, null));
        }
    }

    private final void a0(int height) {
        updateUI(new GuildMsgListViewState.GuildInputBarHeightChangeDataState(height));
    }

    private final void b0() {
        GuildArticleMsgRepoDelegate guildArticleMsgRepoDelegate = this.mMsgRepoDelegate;
        if (guildArticleMsgRepoDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsgRepoDelegate");
            guildArticleMsgRepoDelegate = null;
        }
        guildArticleMsgRepoDelegate.Q();
    }

    private final void c0() {
        GuildArticleMsgRepoDelegate guildArticleMsgRepoDelegate = this.mMsgRepoDelegate;
        if (guildArticleMsgRepoDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsgRepoDelegate");
            guildArticleMsgRepoDelegate = null;
        }
        guildArticleMsgRepoDelegate.S();
    }

    private final void d0(com.tencent.aio.data.msglist.a msgItem, View msgBubbleView) {
        GuildMsgItem guildMsgItem;
        MsgRecord msgRecord;
        GuildMsgItem guildMsgItem2 = null;
        if (l0(msgItem.getViewType())) {
            if (msgItem instanceof GuildMsgItem) {
                guildMsgItem = (GuildMsgItem) msgItem;
            } else {
                guildMsgItem = null;
            }
            if (guildMsgItem != null) {
                msgRecord = guildMsgItem.getMsgRecord();
            } else {
                msgRecord = null;
            }
            w0(msgRecord, null);
            return;
        }
        if (msgItem instanceof GuildMsgItem) {
            guildMsgItem2 = (GuildMsgItem) msgItem;
        }
        if (k0(guildMsgItem2)) {
            Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            u0((GuildMsgItem) msgItem, msgBubbleView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e0(int scrollState, com.tencent.aio.data.msglist.a firstMsg, int firstPosition, int lastPosition) {
        T(this, (GuildMsgItem) firstMsg, firstPosition, 0.0f, 4, null);
        if (scrollState == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.ExposureVisibleMsgListEvent(firstPosition, lastPosition, new CopyOnWriteArrayList(l())));
        }
    }

    private final void g0(FileTransNotifyInfo fileInfo) {
        GuildMsgItem guildMsgItem;
        List<com.tencent.aio.data.msglist.a> l3 = l();
        if (!TypeIntrinsics.isMutableList(l3)) {
            l3 = null;
        }
        if (l3 != null) {
            boolean z16 = false;
            int i3 = 0;
            for (Object obj : l3) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
                if (aVar.getMsgId() == fileInfo.msgId) {
                    if (aVar instanceof GuildMsgItem) {
                        guildMsgItem = (GuildMsgItem) aVar;
                    } else {
                        guildMsgItem = null;
                    }
                    if (guildMsgItem == null) {
                        return;
                    }
                    com.tencent.aio.data.msglist.a cloneNewInstance = guildMsgItem.cloneNewInstance();
                    Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                    GuildMsgItem guildMsgItem2 = (GuildMsgItem) cloneNewInstance;
                    guildMsgItem2.setFileTransNotifyInfo(fileInfo);
                    l3.set(i3, guildMsgItem2);
                    z16 = true;
                }
                i3 = i16;
            }
            if (z16) {
                x0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h0() {
        GuildArticleMsgListCenter guildArticleMsgListCenter = this.mMsgListCenter;
        GuildArticleMsgListCenter guildArticleMsgListCenter2 = null;
        if (guildArticleMsgListCenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsgListCenter");
            guildArticleMsgListCenter = null;
        }
        if (guildArticleMsgListCenter.i()) {
            GuildArticleMsgListCenter guildArticleMsgListCenter3 = this.mMsgListCenter;
            if (guildArticleMsgListCenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgListCenter");
            } else {
                guildArticleMsgListCenter2 = guildArticleMsgListCenter3;
            }
            MsgRecord l3 = guildArticleMsgListCenter2.l();
            boolean z16 = false;
            if (l3 != null && l3.msgType == 5) {
                z16 = true;
            }
            if (!z16) {
                AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                String g17 = com.tencent.guild.aio.util.a.g(g16);
                AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
                int a16 = fo0.h.a(g17, com.tencent.guild.aio.util.a.b(g18));
                GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
                AIOParam g19 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g19, "mContext.aioParam");
                if (companion.d(a16, com.tencent.guild.aio.util.a.g(g19))) {
                    ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowKeyboardAnyStatus("GuildArticleMsgListDataVM"));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void i0() {
        boolean z16;
        boolean z17 = true;
        if (!fetchVBState(new i.a()).b().getBoolean("guild_article_can_scroll_vertically_up")) {
            GuildArticleMsgListCenter guildArticleMsgListCenter = this.mMsgListCenter;
            GuildArticleMsgListCenter guildArticleMsgListCenter2 = null;
            if (guildArticleMsgListCenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgListCenter");
                guildArticleMsgListCenter = null;
            }
            if (guildArticleMsgListCenter.I()) {
                com.tencent.aio.data.msglist.a G = m().G();
                if (G != null) {
                    long msgSeq = G.getMsgSeq();
                    GuildArticleMsgListCenter guildArticleMsgListCenter3 = this.mMsgListCenter;
                    if (guildArticleMsgListCenter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgListCenter");
                    } else {
                        guildArticleMsgListCenter2 = guildArticleMsgListCenter3;
                    }
                    if (msgSeq == guildArticleMsgListCenter2.m()) {
                        z16 = true;
                        if (z16) {
                            z17 = false;
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
        }
        Fragment parentFragment = ((com.tencent.aio.api.runtime.a) getMContext()).c().getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.guild.aio.article.fragment.GuildArticleWrapperFragment");
        ((GuildArticleWrapperFragment) parentFragment).th(z17);
    }

    private final void j0(int position) {
        updateUI(new GuildMsgListViewState.GuildMsgItemChangedState(position));
    }

    private final boolean k0(GuildMsgItem msg2) {
        if (msg2 == null || !qr0.d.i(msg2)) {
            return false;
        }
        return true;
    }

    private final boolean l0(int type) {
        if (type != 4 && type != 5) {
            return false;
        }
        return true;
    }

    private final void m0(FileTransNotifyInfo fileInfo) {
        QLog.d("GuildArticleMsgListDataVM", 1, "onRichMediaDownloadComplete fileInfo: " + fileInfo);
        g0(fileInfo);
    }

    private final void n0(FileTransNotifyInfo fileInfo) {
        QLog.d("GuildArticleMsgListDataVM", 1, "onRichMediaDownloadProgressUpdate fileInfo: " + fileInfo);
        g0(fileInfo);
    }

    private final void o0(FileTransNotifyInfo fileInfo) {
        QLog.d("GuildArticleMsgListDataVM", 1, "onRichMediaUploadComplete fileInfo: " + fileInfo);
        g0(fileInfo);
    }

    private final void p0(boolean forceUpdate, List<Object> payloads) {
        y0(forceUpdate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void q0(GuildArticleMsgListDataVM guildArticleMsgListDataVM, boolean z16, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            list = new ArrayList();
        }
        guildArticleMsgListDataVM.p0(z16, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object r0(GuildArticleMsgListDataVM guildArticleMsgListDataVM, FileTransNotifyInfo fileTransNotifyInfo, Continuation continuation) {
        guildArticleMsgListDataVM.m0(fileTransNotifyInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object s0(GuildArticleMsgListDataVM guildArticleMsgListDataVM, FileTransNotifyInfo fileTransNotifyInfo, Continuation continuation) {
        guildArticleMsgListDataVM.n0(fileTransNotifyInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object t0(GuildArticleMsgListDataVM guildArticleMsgListDataVM, FileTransNotifyInfo fileTransNotifyInfo, Continuation continuation) {
        guildArticleMsgListDataVM.o0(fileTransNotifyInfo);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u0(GuildMsgItem msgItem, View clickedView) {
        boolean z16;
        QLog.i("GuildArticleMsgListDataVM", 4, "showMarketFacePreview");
        MarketFaceElement a16 = qr0.d.a(msgItem);
        if (clickedView != null && a16 != null) {
            QLog.i("GuildArticleMsgListDataVM", 4, "showEmoPreview===");
            if (((com.tencent.aio.api.runtime.a) getMContext()).g().l().getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            IGuildEmoPreviewApi iGuildEmoPreviewApi = (IGuildEmoPreviewApi) QRoute.api(IGuildEmoPreviewApi.class);
            long msgId = msgItem.getMsgId();
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g16);
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            iGuildEmoPreviewApi.showEmoPreview(clickedView, a16, msgId, b16, com.tencent.guild.aio.util.a.g(g17), z16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w0(MsgRecord msgRecord, PicElement picElement) {
        if (msgRecord != null) {
            AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
            IGuildRichMediaBrowserApi iGuildRichMediaBrowserApi = (IGuildRichMediaBrowserApi) QRoute.api(IGuildRichMediaBrowserApi.class);
            Intrinsics.checkNotNullExpressionValue(app, "app");
            iGuildRichMediaBrowserApi.enterImagePreview(app, ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext(), null, msgRecord, picElement, false, null, null);
        }
    }

    private final void y0(boolean force) {
        List<com.tencent.aio.data.msglist.a> l3 = l();
        if (l3 != null) {
            updateUI(new GuildMsgListDataState(l3, force, m().H(), 0, null, 24, null));
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper
    @NotNull
    public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d F() {
        return new c();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper
    @Nullable
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public GuildMsgListDataState D(@NotNull MsgListUiState implState) {
        Intrinsics.checkNotNullParameter(implState, "implState");
        if (implState instanceof MsgListState) {
            MsgListState msgListState = (MsgListState) implState;
            return new GuildMsgListDataState((Collection) implState, false, m().H(), msgListState.getUpdateType(), msgListState.getExtra());
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final MsgListRepo Q() {
        g gVar = new g((com.tencent.aio.api.runtime.a) getMContext(), vmScope());
        GuildArticleMsgListCenter guildArticleMsgListCenter = this.mMsgListCenter;
        if (guildArticleMsgListCenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsgListCenter");
            guildArticleMsgListCenter = null;
        }
        GuildArticleMsgRepoDelegate guildArticleMsgRepoDelegate = new GuildArticleMsgRepoDelegate(gVar, guildArticleMsgListCenter, this.mFirstUnreadMsgSeq, vmScope());
        this.mMsgRepoDelegate = guildArticleMsgRepoDelegate;
        gVar.Y(guildArticleMsgRepoDelegate);
        return gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull at.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof MsgListIntent.a) {
            p((MsgListIntent.a) intent);
            return;
        }
        if (intent instanceof a.b) {
            m().v(((a.b) intent).a());
            return;
        }
        if (intent instanceof a.c) {
            m().x();
            return;
        }
        if (intent instanceof a.C0640a) {
            m().w();
            return;
        }
        if (intent instanceof bq0.c) {
            Z(((bq0.c) intent).getPosition());
            return;
        }
        if (intent instanceof a.C1186a) {
            Y();
            return;
        }
        if (intent instanceof a.l) {
            h0();
            return;
        }
        if (intent instanceof a.d) {
            w();
            return;
        }
        if (intent instanceof a.g) {
            a.g gVar = (a.g) intent;
            e0(gVar.getCom.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.SCROLL_STATE java.lang.String(), gVar.getFirstVisibleMsg(), gVar.getFirstPosition(), gVar.getLastPosition());
        } else {
            if (intent instanceof f.b) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildArticleMsgListEvent.ArticleMsgListUpdated(l(), ((f.b) intent).getLastPosition()));
                return;
            }
            if (intent instanceof MsgListIntent.b) {
                s((MsgListIntent.b) intent);
            } else if (intent instanceof f.GuildArticleSpringBackIntent) {
                f.GuildArticleSpringBackIntent guildArticleSpringBackIntent = (f.GuildArticleSpringBackIntent) intent;
                X(guildArticleSpringBackIntent.getSpringBackDistance(), guildArticleSpringBackIntent.getFirstVisibleMsg(), guildArticleSpringBackIntent.getFirstPosition());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.GuildNavigateToMsgEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.GuildNavigateToAIOBottomEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListRefreshEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleTitleEvent.NavigateMainMsgIntent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.FirstPageMsgInitCompleted.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().a(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgSeqGet.class).getQualifiedName());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().a(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgIdGet.class).getQualifiedName());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().a(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgRecordGet.class).getQualifiedName());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgItemContentViewClickEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.UpdateMsgItemState.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildInputBarHeightChangEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.UpdateCanScrollUpState.class).getQualifiedName(), this.mAction);
        this.eventReceiver.d();
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
            iGPSService.deleteObserver(this.gpsObserver);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        AbstractGifImage.resumeAll();
        ApngImage.resumeAll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void p(@NotNull MsgListIntent.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.p(intent);
        GuildMsgItem guildMsgItem = (GuildMsgItem) intent.b();
        U("GuildArticleMsgListDataVM", guildMsgItem, (GuildMsgItem) intent.d());
        T(this, guildMsgItem, intent.a(), 0.0f, 4, null);
        if (intent.e() == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.ExposureVisibleMsgListEvent(intent.a(), intent.c(), new CopyOnWriteArrayList(l())));
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void w() {
        ChannelAIOMsgService channelAIOMsgService = ChannelAIOMsgService.f112613a;
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.D(), new GuildArticleMsgListDataVM$registerMsgNotification$1(this)), Dispatchers.getIO()), vmScope());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.B(), new GuildArticleMsgListDataVM$registerMsgNotification$2(this)), Dispatchers.getIO()), vmScope());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.C(), new GuildArticleMsgListDataVM$registerMsgNotification$3(this)), Dispatchers.getIO()), vmScope());
    }

    public final void x0() {
        y0(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.guild.aio.util.ex.a.m((com.tencent.aio.api.runtime.a) getMContext(), FromScene.ARTICLE.ordinal());
        Fragment parentFragment = ((com.tencent.aio.api.runtime.a) getMContext()).c().getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.guild.aio.article.fragment.GuildArticleWrapperFragment");
        this.mMsgListCenter = ((GuildArticleWrapperFragment) parentFragment).rh();
        z(Q());
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.GuildNavigateToMsgEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.GuildNavigateToAIOBottomEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListRefreshEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleTitleEvent.NavigateMainMsgIntent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.FirstPageMsgInitCompleted.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().j(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgSeqGet.class).getQualifiedName(), this.mActionR);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().j(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgIdGet.class).getQualifiedName(), this.mActionR);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().j(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgRecordGet.class).getQualifiedName(), this.mActionR);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgItemContentViewClickEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.UpdateMsgItemState.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildInputBarHeightChangEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.UpdateCanScrollUpState.class).getQualifiedName(), this.mAction);
        this.eventReceiver.c(nq0.d.class, true, new GuildArticleMsgListDataVM$onCreate$1(this, null));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(this.gpsObserver);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
    }
}
