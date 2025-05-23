package com.tencent.guild.aio.factory.business.holder.msglist;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AIOLayoutManager;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.OnAIOTouchListener;
import androidx.recyclerview.widget.RecyclerView;
import bq0.f;
import com.tencent.aio.api.list.IBounceScrollApi;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.api.list.g;
import com.tencent.aio.api.list.l;
import com.tencent.aio.api.refreshLoad.c;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVB;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListViewState;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.factory.business.holder.msglist.k;
import com.tencent.guild.aio.factory.business.holder.msglist.scrollers.GuildMsgListScrollManager;
import com.tencent.guild.aio.msglist.highlight.HighLightUnreadAtMsgState;
import com.tencent.guild.aio.msglist.highlight.HighLightViewHolderUIState;
import com.tencent.guild.aio.msglist.text.util.TextBubbleContentParser;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.tab.QQGuildTabManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.mvi.api.ability.a;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.theme.SkinEngine;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\t*\u0001a\b\u0016\u0018\u0000 U2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002ghB\u0011\u0012\b\b\u0002\u0010C\u001a\u00020@\u00a2\u0006\u0004\be\u0010fJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0018\u0010%\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020'H\u0002J \u0010-\u001a\u00020+2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010.\u001a\u00020\tH\u0016J\u0016\u00101\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u0003000/H\u0016J\u0018\u00102\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u00104\u001a\u000203H\u0016J\u0010\u00105\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u001a\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007060/H\u0016J\u0018\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007060/J\u0014\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000309H\u0016J\u001a\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007060/H\u0016J\u0012\u0010?\u001a\u0004\u0018\u00010>2\u0006\u0010=\u001a\u00020<H\u0016R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010K\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010UR\u0016\u0010`\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010ER\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010c\u00a8\u0006i"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/c;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Lcom/tencent/mvi/api/ability/a;", "", SemanticAttributes.DbSystemValues.H2, "", HippyTKDListViewAdapter.SCROLL_STATE, "", "i2", "guildTab", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/guild/aio/msglist/highlight/HighLightViewHolderUIState;", "state", "d2", "", "newMsgSeq", "", "selfTid", "c2", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataState;", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "Z1", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "helper", "U1", "V1", "height", "e2", "newTopMargin", "f2", com.tencent.luggage.wxa.c8.c.G, "W1", "", "payloads", "X1", "Y1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "T1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "childView", "T0", "S0", "", "Ljava/lang/Class;", "getObserverStates", "u0", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "E1", "p", "Lkotlin/Pair;", "e", "S1", "Lcom/tencent/aio/base/mvvm/b;", "F0", tl.h.F, "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$b;", "M", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$b;", "viewModelProvider", "N", "I", "bottomMargin", "P", "topMargin", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/aio/api/list/IListUIOperationApi;", "listUIOperationApi", "Lbq0/f;", BdhLogUtil.LogTag.Tag_Req, "Lbq0/f;", "mHighLightViewHolderApi", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b;", "focusBottomHandler", "T", "Z", "couldTrigerDismissPanel", "U", "couldTriggerShowKeyboard", "Lbo0/a;", "V", "Lbo0/a;", "skeletonHolder", "W", "scrolling", "X", "scrollCookie", "com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$i", "Y", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$i;", "onTabChanged", "<init>", "(Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$b;)V", "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildMsgListDataVB extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c<at.b, MsgListUiState> implements com.tencent.mvi.api.ability.a {

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final b viewModelProvider;

    /* renamed from: N, reason: from kotlin metadata */
    private int bottomMargin;

    /* renamed from: P, reason: from kotlin metadata */
    private int topMargin;

    /* renamed from: Q, reason: from kotlin metadata */
    private IListUIOperationApi listUIOperationApi;

    /* renamed from: R, reason: from kotlin metadata */
    private bq0.f mHighLightViewHolderApi;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b focusBottomHandler;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean couldTrigerDismissPanel;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean couldTriggerShowKeyboard;

    /* renamed from: V, reason: from kotlin metadata */
    private bo0.a skeletonHolder;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean scrolling;

    /* renamed from: X, reason: from kotlin metadata */
    private int scrollCookie;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final i onTabChanged;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$a;", "", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$b;", "c", "", "DEFAULT_TOP_MARGIN", "I", "", "HIGH_LIGHT_DELAY", "J", "PRE_LOAD_NUM", "SHOW_KEYBOARD_DISTANCE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVB$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final b c() {
            return new b() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.c
                @Override // com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVB.b
                public final com.tencent.aio.base.mvvm.b provide() {
                    com.tencent.aio.base.mvvm.b d16;
                    d16 = GuildMsgListDataVB.Companion.d();
                    return d16;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final com.tencent.aio.base.mvvm.b d() {
            return new GuildMsgListDataVM(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$b;", "", "Lcom/tencent/aio/base/mvvm/b;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "provide", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface b {
        @NotNull
        com.tencent.aio.base.mvvm.b<at.b, MsgListUiState> provide();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$c", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapUp", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent e16) {
            GuildMsgListDataVB.this.sendIntent(a.C1186a.f110458d);
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$d", "Lcom/tencent/aio/api/refreshLoad/c$b;", "", ReportConstant.COSTREPORT_PREFIX, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements c.b {
        d() {
        }

        @Override // com.tencent.aio.api.refreshLoad.c.b
        public void onRefresh() {
            QLog.i("GuildMsgListDataVB", 1, "onCreateView, onRefresh");
            GuildMsgListDataVB.this.sendIntent(new a.c("GuildMsgListDataVB"));
        }

        @Override // com.tencent.aio.api.refreshLoad.c.b
        public void s() {
            QLog.i("GuildMsgListDataVB", 1, "onCreateView, onLoadMore");
            GuildMsgListDataVB.this.sendIntent(new a.C0640a("GuildMsgListDataVB"));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$e", "Lcom/tencent/aio/api/list/l;", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e implements l {
        e() {
        }

        @Override // com.tencent.aio.api.list.l
        public void a() {
            QLog.i("GuildMsgListDataVB", 1, "afterListRender");
            g12.b bVar = g12.b.f401087a;
            if (!bVar.b()) {
                bVar.g(true);
                bVar.a(GuildHistogramScene.GUILD_AIO_FIRST_VIEW_TIME_COST, "");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$f", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f extends RecyclerView.OnScrollListener {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                GuildMsgListDataVB.this.couldTrigerDismissPanel = true;
                GuildMsgListDataVB.this.couldTriggerShowKeyboard = true;
                GuildMsgListDataVB.this.i2(newState);
                GuildMsgListDataVB.this.scrolling = false;
                TraceUtils.j("msgScrolling", GuildMsgListDataVB.this.scrollCookie);
            } else if (!GuildMsgListDataVB.this.scrolling) {
                GuildMsgListDataVB.this.scrolling = true;
                GuildMsgListDataVB.this.scrollCookie = TraceUtils.g("msgScrolling");
            }
            ((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).handleScrollStateChanged("aio_msg_list", newState);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (recyclerView.getScrollState() == 1 && GuildMsgListDataVB.this.couldTrigerDismissPanel) {
                GuildMsgListDataVB.this.couldTrigerDismissPanel = false;
                GuildMsgListDataVB.this.sendIntent(a.C1186a.f110458d);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$g", "Lcom/tencent/aio/api/list/IBounceScrollApi$b;", "", "moveType", "moveDistance", "", "totalDistance", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g implements IBounceScrollApi.b {
        g() {
        }

        @Override // com.tencent.aio.api.list.IBounceScrollApi.b
        public void a(int moveType, int moveDistance, float totalDistance) {
            if (moveType == 1 && moveDistance < 0 && Math.abs(totalDistance) > 400.0f && GuildMsgListDataVB.this.couldTriggerShowKeyboard) {
                QLog.i("GuildMsgListDataVB", 1, "onBounceLayoutMove, showKeyBoard, moveDistance = " + moveDistance + ", totalDistance = " + totalDistance);
                GuildMsgListDataVB.this.sendIntent(a.l.f110477d);
                GuildMsgListDataVB.this.couldTriggerShowKeyboard = false;
                GuildMsgListDataVB.this.couldTrigerDismissPanel = false;
                return;
            }
            if (moveType == 1 && moveDistance > 0 && GuildMsgListDataVB.this.couldTrigerDismissPanel) {
                QLog.i("GuildMsgListDataVB", 1, "onBounceLayoutMove, hideKeyBoard moveDistance = " + moveDistance + ", totalDistance = " + totalDistance);
                GuildMsgListDataVB.this.sendIntent(a.C1186a.f110458d);
                GuildMsgListDataVB.this.couldTrigerDismissPanel = false;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$h", "Landroidx/recyclerview/widget/OnAIOTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class h implements OnAIOTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GestureDetector f110395d;

        h(GestureDetector gestureDetector) {
            this.f110395d = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
            return this.f110395d.onTouchEvent(event);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB$i", "Lnr0/a;", "", "guildTab", "", "onTabChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class i implements nr0.a {
        i() {
        }

        @Override // nr0.a
        public void onTabChanged(boolean guildTab) {
            if (QLog.isColorLevel()) {
                QLog.i("GuildMsgListDataVB", 2, "[onTabChanged] ");
            }
            GuildMsgListDataVB.this.a2(guildTab);
        }
    }

    public GuildMsgListDataVB() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final GestureDetector.SimpleOnGestureListener T1() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(MsgListState state, IListUIOperationApi helper) {
        boolean m3 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a.m(state, helper);
        QLog.i("GuildMsgListDataVB", 1, "processFocusIndex, FOCUS_BOTTOM, state.size = " + state.size() + ", needHandle: " + m3 + ", updateType: " + state.getUpdateType());
        if (m3) {
            this.focusBottomHandler.i(state, helper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V1(MsgListState state, IListUIOperationApi helper) {
        QLog.i("GuildMsgListDataVB", 1, "processFocusIndex, FOCUS_HEAD, state.size = " + state.size() + ", opType: " + state.getUpdateType());
        a.C11562a.a(helper, 0, false, null, 6, null);
    }

    private final void W1(int pos) {
        if (pos >= 0) {
            IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
            if (iListUIOperationApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi = null;
            }
            iListUIOperationApi.d(pos, 1);
        }
    }

    private final void X1(int pos, Object payloads) {
        if (pos >= 0) {
            IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
            if (iListUIOperationApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi = null;
            }
            iListUIOperationApi.u(pos, 1, payloads);
        }
    }

    private final void Y1(int pos) {
        if (pos >= 0) {
            IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
            if (iListUIOperationApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi = null;
            }
            iListUIOperationApi.e(pos, 1);
        }
    }

    private final void Z1(GuildMsgListDataState state, IListUIOperationApi uiHelper) {
        boolean z16;
        Object firstOrNull;
        Long l3;
        Object firstOrNull2;
        Long l16;
        Object lastOrNull;
        Long l17;
        Object lastOrNull2;
        Long l18;
        if (state.getExtra() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        int updateType = state.getUpdateType();
        boolean forceUpdate = state.getForceUpdate();
        int size = state.size();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) state);
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
        IListUIOperationApi iListUIOperationApi = null;
        if (aVar != null) {
            l3 = Long.valueOf(aVar.getMsgSeq());
        } else {
            l3 = null;
        }
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) state);
        com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) firstOrNull2;
        if (aVar2 != null) {
            l16 = Long.valueOf(aVar2.getMsgId());
        } else {
            l16 = null;
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) state);
        com.tencent.aio.data.msglist.a aVar3 = (com.tencent.aio.data.msglist.a) lastOrNull;
        if (aVar3 != null) {
            l17 = Long.valueOf(aVar3.getMsgSeq());
        } else {
            l17 = null;
        }
        lastOrNull2 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) state);
        com.tencent.aio.data.msglist.a aVar4 = (com.tencent.aio.data.msglist.a) lastOrNull2;
        if (aVar4 != null) {
            l18 = Long.valueOf(aVar4.getMsgId());
        } else {
            l18 = null;
        }
        QLog.i("GuildMsgListDataVB", 1, "handleGuildMsgListDataState, has extra: " + z16 + ", updateType: " + updateType + ",force = " + forceUpdate + ", size = " + size + ", firstMsg:{ seq: " + l3 + ", id: " + l16 + " }lastMsg:{ seq: " + l17 + ", id: " + l18 + " }");
        if (state.getForceUpdate()) {
            IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
            if (iListUIOperationApi2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            } else {
                iListUIOperationApi = iListUIOperationApi2;
            }
            RecyclerView.Adapter adapter = iListUIOperationApi.i().getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        super.u0(state, uiHelper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(boolean guildTab) {
        if (!guildTab) {
            IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
            IListUIOperationApi iListUIOperationApi2 = null;
            if (iListUIOperationApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi = null;
            }
            RecyclerView.Adapter adapter = iListUIOperationApi.i().getAdapter();
            IListUIOperationApi iListUIOperationApi3 = this.listUIOperationApi;
            if (iListUIOperationApi3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi3 = null;
            }
            iListUIOperationApi3.i().swapAdapter(adapter, true);
            IListUIOperationApi iListUIOperationApi4 = this.listUIOperationApi;
            if (iListUIOperationApi4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi4 = null;
            }
            RecyclerView.RecycledViewPool recycledViewPool = iListUIOperationApi4.i().getRecycledViewPool();
            Iterator<T> it = S1().iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                recycledViewPool.setMaxRecycledViews(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
            }
            IListUIOperationApi iListUIOperationApi5 = this.listUIOperationApi;
            if (iListUIOperationApi5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            } else {
                iListUIOperationApi2 = iListUIOperationApi5;
            }
            RecyclerView.RecycledViewPool recycledViewPool2 = iListUIOperationApi2.i().getRecycledViewPool();
            Iterator<T> it5 = e().iterator();
            while (it5.hasNext()) {
                Pair pair2 = (Pair) it5.next();
                recycledViewPool2.setMaxRecycledViews(((Number) pair2.getFirst()).intValue(), ((Number) pair2.getSecond()).intValue());
            }
        }
    }

    private final void c2(long newMsgSeq, String selfTid) {
        int i3;
        IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
        if (iListUIOperationApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi = null;
        }
        AIOLayoutManager layoutManager = iListUIOperationApi.i().getLayoutManager();
        int findFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
            return;
        }
        while (true) {
            IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
            if (iListUIOperationApi2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi2 = null;
            }
            com.tencent.aio.data.msglist.a x16 = iListUIOperationApi2.x(findFirstVisibleItemPosition);
            if (x16 instanceof GuildMsgItem) {
                GuildMsgItem guildMsgItem = (GuildMsgItem) x16;
                if (guildMsgItem.getMsgSeq() >= newMsgSeq && MsgExtKt.F(guildMsgItem.getMsgRecord(), selfTid)) {
                    if (TextBubbleContentParser.f111932a.j(guildMsgItem)) {
                        i3 = 2;
                    } else {
                        i3 = 3;
                    }
                    int i16 = i3;
                    bq0.f fVar = this.mHighLightViewHolderApi;
                    if (fVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHighLightViewHolderApi");
                        fVar = null;
                    }
                    f.a.a(fVar, findFirstVisibleItemPosition, i16, null, 4, null);
                }
            }
            if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                findFirstVisibleItemPosition++;
            } else {
                return;
            }
        }
    }

    private final void d2(HighLightViewHolderUIState state) {
        bq0.f fVar = this.mHighLightViewHolderApi;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHighLightViewHolderApi");
            fVar = null;
        }
        fVar.b(state.getPosition(), state.getMsgRecord(), state.getParserId(), state.getExtra(), state.getItemView());
    }

    private final void e2(int height, IListUIOperationApi uiHelper) {
        if (this.bottomMargin != height) {
            QLog.i("GuildMsgListDataVB", 1, "handleInputBarHeightChange, height = " + height + " host " + getHostView());
            this.bottomMargin = height;
            ViewGroup.LayoutParams layoutParams = getHostView().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.bottomMargin;
            getHostView().requestLayout();
        }
    }

    private final void f2(int newTopMargin) {
        if (newTopMargin != this.topMargin) {
            QLog.i("GuildMsgListDataVB", 1, "handleListTopMargin, newTopMargin = " + newTopMargin);
            this.topMargin = newTopMargin;
            ViewGroup.LayoutParams layoutParams = getHostView().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = newTopMargin;
            getHostView().requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(GuildMsgListDataVB this$0, MsgListUiState state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        this$0.d2((HighLightViewHolderUIState) state);
    }

    private final boolean h2() {
        a.e eVar = new a.e(false, 1, null);
        sendIntent(eVar);
        return eVar.getRet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i2(int scrollState) {
        com.tencent.aio.data.msglist.a aVar;
        int i3;
        IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
        com.tencent.aio.data.msglist.a aVar2 = null;
        if (iListUIOperationApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi = null;
        }
        AIOLayoutManager layoutManager = iListUIOperationApi.i().getLayoutManager();
        int findFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition >= 0 && findLastVisibleItemPosition >= 0) {
            IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
            if (iListUIOperationApi2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi2 = null;
            }
            Pair<com.tencent.aio.api.vo.a, com.tencent.aio.api.vo.a> J = iListUIOperationApi2.J(findFirstVisibleItemPosition, findLastVisibleItemPosition);
            com.tencent.aio.api.vo.a first = J.getFirst();
            if (first != null) {
                aVar = first.a();
                i3 = first.b();
            } else {
                aVar = null;
                i3 = findFirstVisibleItemPosition;
            }
            com.tencent.aio.api.vo.a second = J.getSecond();
            if (second != null) {
                aVar2 = second.a();
                findLastVisibleItemPosition = second.b();
            }
            sendIntent(new a.g(scrollState, i3, findLastVisibleItemPosition, aVar, aVar2));
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c
    @NotNull
    public AbsMsgListVB.b E1() {
        return new AbsMsgListVB.b() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVB$createFocusIndex$1
            @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB.b
            public void a(@NotNull MsgListState state, @NotNull IListUIOperationApi helper) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(helper, "helper");
                com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
                if (bVar.j(state.getExtra())) {
                    GuildMsgListDataVB.this.U1(state, helper);
                    return;
                }
                if (bVar.k(state.getExtra())) {
                    GuildMsgListDataVB.this.V1(state, helper);
                } else if (bVar.l(state.getExtra())) {
                    final GuildMsgListDataVB guildMsgListDataVB = GuildMsgListDataVB.this;
                    bVar.i(state, helper, "GuildMsgListDataVB", new Function1<at.b, Unit>() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVB$createFocusIndex$1$processFocusIndex$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(at.b bVar2) {
                            invoke2(bVar2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull at.b intent) {
                            Intrinsics.checkNotNullParameter(intent, "intent");
                            GuildMsgListDataVB.this.sendIntent(intent);
                        }
                    });
                }
            }
        };
    }

    @Override // com.tencent.aio.api.list.j
    @NotNull
    public com.tencent.aio.base.mvvm.b<at.b, MsgListUiState> F0() {
        return this.viewModelProvider.provide();
    }

    @Override // com.tencent.mvi.api.ability.a
    @MainThread
    @NotNull
    public com.tencent.mvi.api.ability.c Q0() {
        return a.C9234a.b(this);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void S0() {
        super.S0();
        if (h2()) {
            if (this.skeletonHolder == null) {
                this.skeletonHolder = new bo0.a(new GuildMsgListDataVB$bindMsgViewAndData$2(this));
                IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
                bo0.a aVar = null;
                if (iListUIOperationApi == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                    iListUIOperationApi = null;
                }
                bo0.a aVar2 = this.skeletonHolder;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("skeletonHolder");
                } else {
                    aVar = aVar2;
                }
                iListUIOperationApi.I(aVar);
            }
            sendIntent(a.q.f110485d);
        }
        sendIntent(new a.b("from_first_screen"));
        sendIntent(a.t.f110488d);
    }

    @NotNull
    public final List<Pair<Integer, Integer>> S1() {
        List<Pair<Integer, Integer>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(7, 5), new Pair(6, 8), new Pair(5, 2), new Pair(4, 2), new Pair(60, 1), new Pair(61, 1), new Pair(62, 1), new Pair(63, 1), new Pair(11, 1), new Pair(10, 1), new Pair(9, 1), new Pair(8, 1), new Pair(56, 3), new Pair(22, 1), new Pair(21, 1), new Pair(24, 2), new Pair(23, 2), new Pair(26, 2), new Pair(25, 2), new Pair(34, 2), new Pair(35, 2), new Pair(37, 1), new Pair(36, 1), new Pair(31, 1), new Pair(30, 1)});
        return listOf;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper) {
        IListUIOperationApi iListUIOperationApi;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        this.listUIOperationApi = uiHelper;
        IListUIOperationApi iListUIOperationApi2 = null;
        if (uiHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi = null;
        } else {
            iListUIOperationApi = uiHelper;
        }
        iListUIOperationApi.i().setItemAnimator(null);
        IListUIOperationApi iListUIOperationApi3 = this.listUIOperationApi;
        if (iListUIOperationApi3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi3 = null;
        }
        iListUIOperationApi3.l(new d());
        IListUIOperationApi iListUIOperationApi4 = this.listUIOperationApi;
        if (iListUIOperationApi4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi4 = null;
        }
        iListUIOperationApi4.s(new e());
        uiHelper.D(20);
        uiHelper.E(20);
        AIORecycleView i3 = uiHelper.i();
        this.mHighLightViewHolderApi = new bq0.b(uiHelper);
        i3.addOnScrollListener(new f());
        GuildMsgListDataVB$onCreateView$4 guildMsgListDataVB$onCreateView$4 = new GuildMsgListDataVB$onCreateView$4(this);
        IListUIOperationApi iListUIOperationApi5 = this.listUIOperationApi;
        if (iListUIOperationApi5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi5 = null;
        }
        i3.addOnScrollListener(new GuildMsgListScrollManager(i3, guildMsgListDataVB$onCreateView$4, iListUIOperationApi5));
        IListUIOperationApi iListUIOperationApi6 = this.listUIOperationApi;
        if (iListUIOperationApi6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
        } else {
            iListUIOperationApi2 = iListUIOperationApi6;
        }
        iListUIOperationApi2.C(new g());
        i3.setPadding(i3.getPaddingLeft(), i3.getPaddingTop(), i3.getPaddingRight(), createViewParams.a().getResources().getDimensionPixelSize(R.dimen.cha));
        i3.setClipToPadding(false);
        i3.addOnTouchListener(new h(new GestureDetector(getMContext(), T1())));
        QQGuildTabManager.c(new WeakReference(this.onTabChanged));
        return super.T0(createViewParams, childView, uiHelper);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, et.a
    @NotNull
    public List<Pair<Integer, Integer>> e() {
        List<Pair<Integer, Integer>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(7, 5), new Pair(6, 10), new Pair(5, 2), new Pair(4, 5), new Pair(60, 2), new Pair(61, 3), new Pair(62, 2), new Pair(63, 2), new Pair(11, 2), new Pair(10, 2), new Pair(9, 2), new Pair(8, 2), new Pair(56, 8), new Pair(22, 2), new Pair(21, 3), new Pair(24, 2), new Pair(23, 5), new Pair(26, 2), new Pair(25, 5), new Pair(34, 2), new Pair(35, 5), new Pair(37, 2), new Pair(36, 5), new Pair(31, 2), new Pair(30, 3)});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        com.tencent.aio.data.msglist.a aVar;
        com.tencent.aio.data.msglist.a aVar2;
        com.tencent.aio.data.msglist.a aVar3;
        View view;
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        bo0.a aVar4 = null;
        RecyclerView.ViewHolder viewHolder = null;
        com.tencent.aio.data.msglist.a aVar5 = null;
        if (stateCmd instanceof k.b) {
            try {
                IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
                if (iListUIOperationApi == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                    iListUIOperationApi = null;
                }
                viewHolder = iListUIOperationApi.G(((k.b) stateCmd).getDisplayListIndex());
            } catch (Exception e16) {
                QLog.e("GuildMsgListDataVB", 1, "GetMsgHolderRectF e:" + e16);
            }
            Bundle bundle = new Bundle();
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                bundle.putInt("left", iArr[0]);
                bundle.putInt("right", iArr[0] + view.getWidth());
                bundle.putInt("top", iArr[1]);
                bundle.putInt("bottom", iArr[1] + view.getHeight());
            }
            return bundle;
        }
        if (stateCmd instanceof k.a) {
            Bundle bundle2 = new Bundle();
            IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
            if (iListUIOperationApi2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi2 = null;
            }
            AIOLayoutManager layoutManager = iListUIOperationApi2.i().getLayoutManager();
            int findFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
            IListUIOperationApi iListUIOperationApi3 = this.listUIOperationApi;
            if (iListUIOperationApi3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi3 = null;
            }
            Pair<com.tencent.aio.api.vo.a, com.tencent.aio.api.vo.a> J = iListUIOperationApi3.J(findFirstVisibleItemPosition, findLastVisibleItemPosition);
            com.tencent.aio.api.vo.a first = J.getFirst();
            if (first != null) {
                aVar = first.a();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                com.tencent.aio.api.vo.a first2 = J.getFirst();
                if (first2 != null) {
                    aVar3 = first2.a();
                } else {
                    aVar3 = null;
                }
                Intrinsics.checkNotNull(aVar3, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                bundle2.putSerializable("aio_top_msg", (GuildMsgItem) aVar3);
            }
            com.tencent.aio.api.vo.a second = J.getSecond();
            if (second != null) {
                aVar2 = second.a();
            } else {
                aVar2 = null;
            }
            if (aVar2 != null) {
                com.tencent.aio.api.vo.a second2 = J.getSecond();
                if (second2 != null) {
                    aVar5 = second2.a();
                }
                Intrinsics.checkNotNull(aVar5, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                bundle2.putSerializable("aio_bottom_msg", (GuildMsgItem) aVar5);
            }
            return bundle2;
        }
        if (stateCmd instanceof k.c) {
            Bundle bundle3 = new Bundle();
            bo0.a aVar6 = this.skeletonHolder;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skeletonHolder");
            } else {
                aVar4 = aVar6;
            }
            bundle3.putBoolean("is_skeleton_showing", aVar4.g());
            return bundle3;
        }
        return new Bundle();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends MsgListUiState>> getObserverStates() {
        List<Class<? extends MsgListUiState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildMsgListViewState.GuildOnThemeChanged.class, GuildMsgListViewState.GuildInputBarHeightChangeDataState.class, HighLightViewHolderUIState.class, GuildMsgListViewState.GuildMsgListTopMarginChangeState.class, GuildMsgListViewState.GuildMsgItemChangedState.class, GuildMsgListViewState.GuildMsgItemChangedStateWithPayload.class, GuildMsgListViewState.GuildMsgItemRemoveState.class});
        return listOf;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, et.a
    @NotNull
    public List<Pair<Integer, Integer>> h() {
        List<Pair<Integer, Integer>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(7, 5), new Pair(6, 10), new Pair(5, 2), new Pair(4, 5), new Pair(60, 1), new Pair(61, 3), new Pair(62, 1), new Pair(63, 3), new Pair(11, 1), new Pair(10, 3), new Pair(9, 1), new Pair(8, 3), new Pair(56, 2), new Pair(24, 2), new Pair(23, 5), new Pair(34, 2), new Pair(35, 5), new Pair(37, 2), new Pair(36, 5), new Pair(31, 1), new Pair(30, 3)});
        return listOf;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void p(@NotNull IListUIOperationApi uiHelper) {
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        uiHelper.n(new g.b(null, null, false, null, 15, null));
        uiHelper.i().swapAdapter(uiHelper.i().getAdapter(), true);
    }

    @Override // com.tencent.mvi.api.ability.a
    @MainThread
    @Nullable
    public String q() {
        return a.C9234a.a(this);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void u0(@NotNull final MsgListUiState state, @NotNull IListUIOperationApi uiHelper) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        if (state instanceof GuildMsgListDataState) {
            Z1((GuildMsgListDataState) state, uiHelper);
            return;
        }
        if (state instanceof GuildMsgListViewState.GuildOnThemeChanged) {
            uiHelper.A();
            uiHelper.b();
            SkinEngine.invalidateAll(uiHelper.i());
            return;
        }
        if (state instanceof GuildMsgListViewState.GuildInputBarHeightChangeDataState) {
            e2(((GuildMsgListViewState.GuildInputBarHeightChangeDataState) state).getHeight(), uiHelper);
            return;
        }
        if (state instanceof HighLightViewHolderUIState) {
            uiHelper.i().postDelayed(new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.b
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgListDataVB.g2(GuildMsgListDataVB.this, state);
                }
            }, 50L);
            return;
        }
        if (state instanceof HighLightUnreadAtMsgState) {
            HighLightUnreadAtMsgState highLightUnreadAtMsgState = (HighLightUnreadAtMsgState) state;
            c2(highLightUnreadAtMsgState.getNewMsgSeq(), highLightUnreadAtMsgState.getSelfTid());
            return;
        }
        if (state instanceof GuildMsgListViewState.GuildMsgListTopMarginChangeState) {
            f2(((GuildMsgListViewState.GuildMsgListTopMarginChangeState) state).getTopMargin());
            return;
        }
        if (state instanceof GuildMsgListViewState.GuildMsgItemChangedState) {
            W1(((GuildMsgListViewState.GuildMsgItemChangedState) state).getPos());
            return;
        }
        if (state instanceof GuildMsgListViewState.GuildMsgItemChangedStateWithPayload) {
            GuildMsgListViewState.GuildMsgItemChangedStateWithPayload guildMsgItemChangedStateWithPayload = (GuildMsgListViewState.GuildMsgItemChangedStateWithPayload) state;
            X1(guildMsgItemChangedStateWithPayload.getPos(), guildMsgItemChangedStateWithPayload.getPayloads());
        } else if (state instanceof GuildMsgListViewState.GuildMsgItemRemoveState) {
            Y1(((GuildMsgListViewState.GuildMsgItemRemoveState) state).getPos());
        }
    }

    public /* synthetic */ GuildMsgListDataVB(b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? INSTANCE.c() : bVar);
    }

    public GuildMsgListDataVB(@NotNull b viewModelProvider) {
        Intrinsics.checkNotNullParameter(viewModelProvider, "viewModelProvider");
        this.viewModelProvider = viewModelProvider;
        this.topMargin = com.tencent.guild.aio.util.c.b(0);
        this.focusBottomHandler = new com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b();
        this.couldTrigerDismissPanel = true;
        this.couldTriggerShowKeyboard = true;
        this.onTabChanged = new i();
    }
}
