package com.tencent.guildlive.aio.msglist.list;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AIOLayoutManager;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.OnAIOTouchListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IBounceScrollApi;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.api.list.l;
import com.tencent.aio.api.refreshLoad.c;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataState;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListViewState;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.factory.business.holder.msglist.k;
import com.tencent.guild.aio.msglist.highlight.HighLightViewHolderUIState;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.msglist.list.d;
import com.tencent.guildlive.aio.msglist.refresh.GuildLiveRefreshUIState;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.guildlive.widget.GuildLiveMsgListFrameLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001]\u0018\u0000 @2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001cB\u0017\u0012\u000e\u0010;\u001a\n\u0012\u0004\u0012\u000208\u0018\u000107\u00a2\u0006\u0004\ba\u0010bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0002J0\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010!\u001a\u00020 H\u0002J \u0010&\u001a\u00020$2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030(H\u0016J\u0016\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030+0*H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\u0018\u0010.\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u00100\u001a\u00020/H\u0016J\u001a\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b010*H\u0016J\u0010\u00106\u001a\u0002052\u0006\u00104\u001a\u000203H\u0016R\u001c\u0010;\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\"\u0010E\u001a\u00020>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010I\u001a\u00020>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010@\u001a\u0004\bG\u0010B\"\u0004\bH\u0010DR\u0016\u0010L\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010=R\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010@R\u0016\u0010V\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010@R\u0016\u0010X\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010@R\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_\u00a8\u0006d"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVB;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/c;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Landroidx/recyclerview/widget/AIORecycleView;", "recycleView", "", "R1", "", HippyTKDListViewAdapter.SCROLL_STATE, "f2", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "S1", "topPadding", "c2", "Lcom/tencent/guild/aio/msglist/highlight/HighLightViewHolderUIState;", "state", "X1", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataState;", "W1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "d2", "videoState", "Z1", "height", "Y1", "leftPad", "topPad", "rightPad", "bottomPad", "g2", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "V1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "childView", "T0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/base/mvvm/b;", "F0", "", "Ljava/lang/Class;", "getObserverStates", "S0", "u0", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "E1", "Lkotlin/Pair;", "e", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "Ljava/lang/ref/WeakReference;", "Lts0/a;", "M", "Ljava/lang/ref/WeakReference;", "liveAIOListener", "N", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "", "P", "Z", "U1", "()Z", "setMPanelOrKeyboardShow", "(Z)V", "mPanelOrKeyboardShow", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "T1", "setMLiveIsLandScreen", "mLiveIsLandScreen", BdhLogUtil.LogTag.Tag_Req, "I", "bottomMargin", ExifInterface.LATITUDE_SOUTH, "listUIOperationApi", "Lbq0/f;", "T", "Lbq0/f;", "mHighLightViewHolderApi", "U", "couldTrigerDismissPanel", "V", "couldTriggerShowKeyboard", "W", "scrolling", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b;", "X", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b;", "focusBottomHandler", "com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVB$g", "Y", "Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVB$g;", "onScrollListener", "<init>", "(Ljava/lang/ref/WeakReference;)V", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveMsgListDataVB extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c<at.b, MsgListUiState> {

    /* renamed from: a0, reason: collision with root package name */
    private static final float f112897a0 = ViewUtils.dip2px(56.0f);

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private final WeakReference<ts0.a> liveAIOListener;

    /* renamed from: N, reason: from kotlin metadata */
    private IListUIOperationApi uiHelper;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mPanelOrKeyboardShow;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean mLiveIsLandScreen;

    /* renamed from: R, reason: from kotlin metadata */
    private int bottomMargin;

    /* renamed from: S, reason: from kotlin metadata */
    private IListUIOperationApi listUIOperationApi;

    /* renamed from: T, reason: from kotlin metadata */
    private bq0.f mHighLightViewHolderApi;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean scrolling;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean couldTrigerDismissPanel = true;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean couldTriggerShowKeyboard = true;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b focusBottomHandler = new com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b();

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final g onScrollListener = new g();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVB$b", "Landroidx/recyclerview/widget/OnAIOTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements OnAIOTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GestureDetector f112898d;

        b(GestureDetector gestureDetector) {
            this.f112898d = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
            return this.f112898d.onTouchEvent(event);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVB$c", "Lcom/tencent/aio/api/refreshLoad/c$b;", "", ReportConstant.COSTREPORT_PREFIX, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements c.b {
        c() {
        }

        @Override // com.tencent.aio.api.refreshLoad.c.b
        public void onRefresh() {
            GuildLiveMsgListDataVB.this.sendIntent(new a.c("GuildLiveMsgListDataVB"));
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildLiveMsgListDataVB", "[onBounceLayoutMove] LoadTopPage");
            }
        }

        @Override // com.tencent.aio.api.refreshLoad.c.b
        public void s() {
            GuildLiveMsgListDataVB.this.sendIntent(new a.C0640a("GuildLiveMsgListDataVB"));
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildLiveMsgListDataVB", "[onBounceLayoutMove] LoadBottomPage");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVB$d", "Lcom/tencent/aio/api/list/IBounceScrollApi$b;", "", "moveType", "moveDistance", "", "totalDistance", "", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements IBounceScrollApi.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f112902b;

        d(boolean z16) {
            this.f112902b = z16;
        }

        @Override // com.tencent.aio.api.list.IBounceScrollApi.b
        public void a(int moveType, int moveDistance, float totalDistance) {
            Logger logger = Logger.f235387a;
            GuildLiveMsgListDataVB guildLiveMsgListDataVB = GuildLiveMsgListDataVB.this;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildLiveMsgListDataVB", "[onBounceLayoutMove] scrolling " + guildLiveMsgListDataVB.scrolling + ", moveType " + moveType + ", moveDistance " + moveDistance + ",  totalDistance " + totalDistance);
            }
            if (moveType == 1 && moveDistance < 0 && Math.abs(totalDistance) > 400.0f && GuildLiveMsgListDataVB.this.couldTriggerShowKeyboard) {
                if (!((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).guildLiveVideoIsLandScreenState()) {
                    if (this.f112902b || !GuildLiveMsgListDataVB.this.scrolling) {
                        GuildLiveMsgListDataVB.this.sendIntent(a.l.f110477d);
                    }
                    if (QLog.isDevelopLevel()) {
                        Log.d("GuildLiveMsgListDataVB", "[onBounceLayoutMove] showKeyBoard ");
                    }
                }
                GuildLiveMsgListDataVB.this.couldTriggerShowKeyboard = false;
                GuildLiveMsgListDataVB.this.couldTrigerDismissPanel = false;
                return;
            }
            if (moveType == 1 && moveDistance > 0 && GuildLiveMsgListDataVB.this.couldTrigerDismissPanel) {
                GuildLiveMsgListDataVB.this.sendIntent(a.C1186a.f110458d);
                if (QLog.isDevelopLevel()) {
                    Log.d("GuildLiveMsgListDataVB", "[onBounceLayoutMove] hideKeyBoard");
                }
                GuildLiveMsgListDataVB.this.couldTrigerDismissPanel = false;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVB$e", "Lcom/tencent/aio/api/list/l;", "", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e implements l {
        e() {
        }

        @Override // com.tencent.aio.api.list.l
        public void a() {
            ts0.a aVar;
            WeakReference weakReference = GuildLiveMsgListDataVB.this.liveAIOListener;
            if (weakReference != null && (aVar = (ts0.a) weakReference.get()) != null) {
                aVar.l0();
            }
            IListUIOperationApi iListUIOperationApi = GuildLiveMsgListDataVB.this.listUIOperationApi;
            if (iListUIOperationApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi = null;
            }
            iListUIOperationApi.J0(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVB$f", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapUp", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f extends GestureDetector.SimpleOnGestureListener {
        f() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent e16) {
            GuildLiveMsgListDataVB.this.sendIntent(a.C1186a.f110458d);
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVB$g", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g extends RecyclerView.OnScrollListener {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                GuildLiveMsgListDataVB.this.couldTrigerDismissPanel = true;
                GuildLiveMsgListDataVB.this.couldTriggerShowKeyboard = true;
                GuildLiveMsgListDataVB.this.f2(newState);
                GuildLiveMsgListDataVB.this.scrolling = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (recyclerView.getScrollState() == 1) {
                if (GuildLiveMsgListDataVB.this.couldTrigerDismissPanel) {
                    GuildLiveMsgListDataVB.this.couldTrigerDismissPanel = false;
                    GuildLiveMsgListDataVB.this.sendIntent(a.C1186a.f110458d);
                    Logger logger = Logger.f235387a;
                    if (QLog.isDevelopLevel()) {
                        Log.d("GuildLiveMsgListDataVB", "[configRecyclerView] hideKeyBoard");
                    }
                }
                GuildLiveMsgListDataVB.this.scrolling = true;
            }
        }
    }

    public GuildLiveMsgListDataVB(@Nullable WeakReference<ts0.a> weakReference) {
        this.liveAIOListener = weakReference;
    }

    private final void R1(AIORecycleView recycleView) {
        recycleView.addOnScrollListener(this.onScrollListener);
        recycleView.addOnTouchListener(new b(new GestureDetector(getMContext(), V1())));
    }

    private final void S1(IListUIOperationApi uiHelper) {
        boolean z16;
        this.listUIOperationApi = uiHelper;
        IListUIOperationApi iListUIOperationApi = null;
        if (uiHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            uiHelper = null;
        }
        uiHelper.l(new c());
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.PHONE) {
            z16 = true;
        } else {
            z16 = false;
        }
        IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
        if (iListUIOperationApi2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi2 = null;
        }
        iListUIOperationApi2.C(new d(z16));
        IListUIOperationApi iListUIOperationApi3 = this.listUIOperationApi;
        if (iListUIOperationApi3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
        } else {
            iListUIOperationApi = iListUIOperationApi3;
        }
        iListUIOperationApi.s(new e());
    }

    private final GestureDetector.SimpleOnGestureListener V1() {
        return new f();
    }

    private final void W1(GuildMsgListDataState state, IListUIOperationApi uiHelper) {
        if (state.getForceUpdate()) {
            a2();
        } else {
            super.u0(state, uiHelper);
        }
    }

    private final void X1(HighLightViewHolderUIState state) {
        bq0.f fVar = this.mHighLightViewHolderApi;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHighLightViewHolderApi");
            fVar = null;
        }
        fVar.b(state.getPosition(), state.getMsgRecord(), state.getParserId(), state.getExtra(), state.getItemView());
    }

    private final void Y1(int height) {
        if (this.bottomMargin != height) {
            this.bottomMargin = height;
            h2(this, 0, 0, 0, height, 7, null);
        }
    }

    private final void Z1(int videoState) {
        boolean z16;
        if (videoState == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mLiveIsLandScreen = z16;
        IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
        if (iListUIOperationApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi = null;
        }
        iListUIOperationApi.i().setVerticalScrollBarEnabled(!this.mLiveIsLandScreen);
    }

    private final void a2() {
        d2();
    }

    private final void c2(int topPadding) {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveMsgListDataVB", "[onExcellentMsgViewVisibleChange] topPadding = " + topPadding);
        h2(this, 0, topPadding, 0, 0, 13, null);
    }

    private final void d2() {
        IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
        IListUIOperationApi iListUIOperationApi2 = null;
        if (iListUIOperationApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi = null;
        }
        if (!iListUIOperationApi.i().isComputingLayout()) {
            IListUIOperationApi iListUIOperationApi3 = this.listUIOperationApi;
            if (iListUIOperationApi3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            } else {
                iListUIOperationApi2 = iListUIOperationApi3;
            }
            RecyclerView.Adapter adapter = iListUIOperationApi2.i().getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.guildlive.aio.msglist.list.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildLiveMsgListDataVB.e2(GuildLiveMsgListDataVB.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(GuildLiveMsgListDataVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IListUIOperationApi iListUIOperationApi = this$0.listUIOperationApi;
        IListUIOperationApi iListUIOperationApi2 = null;
        if (iListUIOperationApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi = null;
        }
        if (!iListUIOperationApi.i().isComputingLayout()) {
            IListUIOperationApi iListUIOperationApi3 = this$0.listUIOperationApi;
            if (iListUIOperationApi3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            } else {
                iListUIOperationApi2 = iListUIOperationApi3;
            }
            RecyclerView.Adapter adapter = iListUIOperationApi2.i().getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(int scrollState) {
        int i3;
        com.tencent.aio.data.msglist.a aVar;
        int i16;
        IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
        com.tencent.aio.data.msglist.a aVar2 = null;
        if (iListUIOperationApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi = null;
        }
        AIOLayoutManager layoutManager = iListUIOperationApi.i().getLayoutManager();
        int i17 = -1;
        try {
            i3 = layoutManager.findFirstVisibleItemPosition();
            try {
                i17 = layoutManager.findLastVisibleItemPosition();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i3 = -1;
        }
        if (i3 >= 0 && i17 >= 0) {
            IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
            if (iListUIOperationApi2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi2 = null;
            }
            Pair<com.tencent.aio.api.vo.a, com.tencent.aio.api.vo.a> J = iListUIOperationApi2.J(i3, i17);
            com.tencent.aio.api.vo.a first = J.getFirst();
            if (first != null) {
                com.tencent.aio.data.msglist.a a16 = first.a();
                i16 = first.b();
                aVar = a16;
            } else {
                aVar = null;
                i16 = i3;
            }
            com.tencent.aio.api.vo.a second = J.getSecond();
            if (second != null) {
                aVar2 = second.a();
                i17 = second.b();
            }
            sendIntent(new a.g(scrollState, i16, i17, aVar, aVar2));
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildLiveMsgListDataVB", "[sendScrollStateIdleIntent] scrollStateIdle");
            }
        }
    }

    private final void g2(int leftPad, int topPad, int rightPad, int bottomPad) {
        getHostView().setPadding(leftPad, topPad, rightPad, bottomPad);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildLiveMsgListDataVB", "[updatePadding] topPad:" + topPad + ", bottomPad:" + bottomPad);
        }
    }

    static /* synthetic */ void h2(GuildLiveMsgListDataVB guildLiveMsgListDataVB, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = guildLiveMsgListDataVB.getHostView().getPaddingLeft();
        }
        if ((i19 & 2) != 0) {
            i16 = guildLiveMsgListDataVB.getHostView().getPaddingTop();
        }
        if ((i19 & 4) != 0) {
            i17 = guildLiveMsgListDataVB.getHostView().getPaddingRight();
        }
        if ((i19 & 8) != 0) {
            i18 = guildLiveMsgListDataVB.getHostView().getPaddingBottom();
        }
        guildLiveMsgListDataVB.g2(i3, i16, i17, i18);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c
    @NotNull
    public AbsMsgListVB.b E1() {
        return new AbsMsgListVB.b() { // from class: com.tencent.guildlive.aio.msglist.list.GuildLiveMsgListDataVB$createFocusIndex$1
            @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB.b
            public void a(@NotNull MsgListState state, @NotNull IListUIOperationApi helper) {
                com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b bVar;
                IListUIOperationApi iListUIOperationApi;
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(helper, "helper");
                com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar2 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
                if (bVar2.j(state.getExtra())) {
                    boolean m3 = bVar2.m(state, helper);
                    QLog.i("GuildLiveMsgListDataVB", 1, "processFocusIndex, FOCUS_BOTTOM state.size = " + state.size() + ", needHandle: " + m3);
                    if (m3) {
                        bVar = GuildLiveMsgListDataVB.this.focusBottomHandler;
                        bVar.i(state, helper);
                        iListUIOperationApi = GuildLiveMsgListDataVB.this.uiHelper;
                        if (iListUIOperationApi == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("uiHelper");
                            iListUIOperationApi = null;
                        }
                        iListUIOperationApi.i().getLayoutManager().requestSimpleAnimationsInNextLayout();
                        return;
                    }
                    return;
                }
                if (bVar2.k(state.getExtra())) {
                    QLog.i("GuildLiveMsgListDataVB", 1, "processFocusIndex, FOCUS_HEAD state.size = " + state.size());
                    a.C11562a.a(helper, 0, false, null, 6, null);
                    return;
                }
                if (bVar2.l(state.getExtra())) {
                    final GuildLiveMsgListDataVB guildLiveMsgListDataVB = GuildLiveMsgListDataVB.this;
                    bVar2.i(state, helper, "GuildLiveMsgListDataVB", new Function1<at.b, Unit>() { // from class: com.tencent.guildlive.aio.msglist.list.GuildLiveMsgListDataVB$createFocusIndex$1$processFocusIndex$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(at.b bVar3) {
                            invoke2(bVar3);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull at.b intent) {
                            Intrinsics.checkNotNullParameter(intent, "intent");
                            GuildLiveMsgListDataVB.this.sendIntent(intent);
                        }
                    });
                }
            }
        };
    }

    @Override // com.tencent.aio.api.list.j
    @NotNull
    public com.tencent.aio.base.mvvm.b<at.b, MsgListUiState> F0() {
        return new GuildLiveMsgListDataVM(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void S0() {
        super.S0();
        sendIntent(a.t.f110488d);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper) {
        ts0.a aVar;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        super.T0(createViewParams, childView, uiHelper);
        this.uiHelper = uiHelper;
        AIORecycleView i3 = uiHelper.i();
        GuildLiveMsgListFrameLayout guildLiveMsgListFrameLayout = new GuildLiveMsgListFrameLayout(createViewParams.a(), null, 0, 6, null);
        WeakReference<ts0.a> weakReference = this.liveAIOListener;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        guildLiveMsgListFrameLayout.a(aVar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.rightMargin = (int) getMContext().getResources().getDimension(R.dimen.cg9);
        Unit unit = Unit.INSTANCE;
        guildLiveMsgListFrameLayout.addView(childView, layoutParams);
        guildLiveMsgListFrameLayout.setPositionAndDrawSize(1, f112897a0);
        guildLiveMsgListFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        S1(uiHelper);
        this.mHighLightViewHolderApi = new bq0.b(uiHelper);
        R1(i3);
        return guildLiveMsgListFrameLayout;
    }

    /* renamed from: T1, reason: from getter */
    public final boolean getMLiveIsLandScreen() {
        return this.mLiveIsLandScreen;
    }

    /* renamed from: U1, reason: from getter */
    public final boolean getMPanelOrKeyboardShow() {
        return this.mPanelOrKeyboardShow;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, et.a
    @NotNull
    public List<Pair<Integer, Integer>> e() {
        List<Pair<Integer, Integer>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(7, 25), new Pair(6, 25), new Pair(17, 15), new Pair(50, 15), new Pair(51, 15), new Pair(27, 15), new Pair(28, 15), new Pair(24, 15), new Pair(23, 15), new Pair(31, 15), new Pair(30, 15)});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @NotNull
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        View view;
        com.tencent.aio.data.msglist.a aVar;
        com.tencent.aio.data.msglist.a aVar2;
        com.tencent.aio.data.msglist.a aVar3;
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        com.tencent.aio.data.msglist.a aVar4 = null;
        RecyclerView.ViewHolder viewHolder = null;
        IListUIOperationApi iListUIOperationApi = null;
        if (stateCmd instanceof k.b) {
            try {
                IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
                if (iListUIOperationApi2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                    iListUIOperationApi2 = null;
                }
                viewHolder = iListUIOperationApi2.G(((k.b) stateCmd).getDisplayListIndex());
            } catch (Exception e16) {
                GuildLiveLogUtil.INSTANCE.d("GuildLiveMsgListDataVB", "[generateVBState] GetMsgHolderRectF e:" + e16);
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
        if (stateCmd instanceof d.a) {
            com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b bVar = this.focusBottomHandler;
            IListUIOperationApi iListUIOperationApi3 = this.uiHelper;
            if (iListUIOperationApi3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiHelper");
            } else {
                iListUIOperationApi = iListUIOperationApi3;
            }
            boolean h16 = bVar.h(iListUIOperationApi, 2);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildLiveMsgListDataVB", "[generateVBState] isBottomRange:" + h16);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("is_bottom_range", h16);
            return bundle2;
        }
        if (stateCmd instanceof k.a) {
            Bundle bundle3 = new Bundle();
            IListUIOperationApi iListUIOperationApi4 = this.listUIOperationApi;
            if (iListUIOperationApi4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi4 = null;
            }
            AIOLayoutManager layoutManager = iListUIOperationApi4.i().getLayoutManager();
            try {
                int findFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                IListUIOperationApi iListUIOperationApi5 = this.listUIOperationApi;
                if (iListUIOperationApi5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                    iListUIOperationApi5 = null;
                }
                Pair<com.tencent.aio.api.vo.a, com.tencent.aio.api.vo.a> J = iListUIOperationApi5.J(findFirstVisibleItemPosition, findLastVisibleItemPosition);
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
                    bundle3.putSerializable("aio_top_msg", (GuildMsgItem) aVar3);
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
                        aVar4 = second2.a();
                    }
                    Intrinsics.checkNotNull(aVar4, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                    bundle3.putSerializable("aio_bottom_msg", (GuildMsgItem) aVar4);
                }
            } catch (NullPointerException e17) {
                e17.printStackTrace();
            }
            return bundle3;
        }
        return new Bundle();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends MsgListUiState>> getObserverStates() {
        List<Class<? extends MsgListUiState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildLiveRefreshUIState.ExcellentMsgViewVisibleChangeUIState.class);
        return listOf;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IListUIOperationApi iListUIOperationApi = this.uiHelper;
        if (iListUIOperationApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiHelper");
            iListUIOperationApi = null;
        }
        iListUIOperationApi.i().removeOnScrollListener(this.onScrollListener);
        super.onDestroy();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void u0(@NotNull MsgListUiState state, @NotNull IListUIOperationApi uiHelper) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        if (state instanceof GuildMsgListDataState) {
            W1((GuildMsgListDataState) state, uiHelper);
            return;
        }
        if (state instanceof GuildLiveRefreshUIState.PanelVisibleChange) {
            this.mPanelOrKeyboardShow = ((GuildLiveRefreshUIState.PanelVisibleChange) state).getShow();
            return;
        }
        if (state instanceof GuildLiveRefreshUIState.VideoScreenChange) {
            Z1(((GuildLiveRefreshUIState.VideoScreenChange) state).getVideoState());
            return;
        }
        if (state instanceof GuildLiveRefreshUIState.NotifyMsgList) {
            a2();
            return;
        }
        if (state instanceof GuildMsgListViewState.GuildInputBarHeightChangeDataState) {
            Y1(((GuildMsgListViewState.GuildInputBarHeightChangeDataState) state).getHeight());
        } else if (state instanceof HighLightViewHolderUIState) {
            X1((HighLightViewHolderUIState) state);
        } else if (state instanceof GuildLiveRefreshUIState.ExcellentMsgViewVisibleChangeUIState) {
            c2(((GuildLiveRefreshUIState.ExcellentMsgViewVisibleChangeUIState) state).getHeightSpace());
        }
    }
}
