package com.tencent.mobileqq.icgame.widget.chat;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUser;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUserMsg;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.widget.chat.adapter.ChatMessageAdapter;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatSysMsgItemView;
import com.tencent.mobileqq.icgame.widget.chat.recyclerview.ChatRecyclerView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import z42.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ee\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u0002:\u0002JFB\u0015\b\u0016\u0012\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001B!\b\u0016\u0012\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001\u0012\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001\u00a2\u0006\u0006\b\u008e\u0001\u0010\u0092\u0001B*\b\u0016\u0012\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001\u0012\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001\u0012\u0007\u0010\u0093\u0001\u001a\u00020\u0010\u00a2\u0006\u0006\b\u008e\u0001\u0010\u0094\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001c\u0010\u0019\u001a\u00020\u0005*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0016H\u0016J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0016J\u0012\u0010,\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J(\u00100\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u0010H\u0014J\u0012\u00103\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u000101H\u0014J\u0010\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u000204H\u0016J \u00109\u001a\u00020\u00052\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u0010H\u0016J\u0010\u0010:\u001a\u00020\u00052\u0006\u00105\u001a\u000204H\u0016J\b\u0010;\u001a\u00020\u0005H\u0014J\b\u0010<\u001a\u00020\u0005H\u0016J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020=H\u0016J\u0012\u0010A\u001a\u00020\u00052\b\u0010@\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0003H\u0016J\u0010\u0010E\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020DH\u0016J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010G\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0003H\u0016R\u0016\u0010L\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010KR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00130M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010NR\u0016\u0010Q\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010PR\u0016\u0010S\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010RR\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010<R\u0016\u00108\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010PR\"\u00107\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010<\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00130Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010cR\u0016\u0010h\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010PR\u0016\u0010i\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010RR\u0018\u0010k\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010jR\u0016\u0010n\u001a\u00020l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010u\u001a\u00020s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010tR\"\u0010|\u001a\u00020v8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0017\u0010\u0080\u0001\u001a\u00020}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0082\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010PR\u0017\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010bR\u001a\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001a\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001a\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u00a8\u0006\u0096\u0001"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/ChatMessageLayout;", "Landroid/widget/FrameLayout;", "Lz42/b;", "", "D", "", BdhLogUtil.LogTag.Tag_Conn, "M", "v", "Landroid/text/SpannableStringBuilder;", "r", "up", "Landroid/view/View$OnClickListener;", "listener", "N", "K", "", "y", "u", "", "msg", "B", "Landroidx/recyclerview/widget/RecyclerView;", com.tencent.luggage.wxa.c8.c.G, "useScrollTo", "w", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "height", "setMinHeight", "", "proportion", "setHeightProportion", "notifyDataSetChanged", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "recyclerView", "t", "Lz42/a;", "dataSupport", "Lz42/c;", "playFunc", "setSupportFunc", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "roomId", "e", "ownerId", "roomType", "b", "onExitRoom", NodeProps.ON_DETACHED_FROM_WINDOW, "J", "Lcom/tencent/mobileqq/icgame/widget/chat/ChatMessageLayout$d;", "setAnchorMessageItemClickListener", "Landroid/view/ViewGroup;", "view", "setTouchViewGroup", "show", "a", "Lw42/f;", "f", "d", "g", ReportConstant.COSTREPORT_PREFIX, LightConstants.DowngradeStrategyKey.SMOOTH, "c", "Z", "mIsLandscape", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "mCacheMsgInLanScape", "I", "sizeHeight", "Ljava/lang/String;", "chatId", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getOwnerId", "()J", "setOwnerId", "(J)V", "", "Ljava/util/List;", "datas", "Landroidx/recyclerview/widget/LinearLayoutManager;", "E", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "newMsgView", "G", "newAtMsgView", "H", "newMsgCount", "showAtMsgId", "Landroid/view/ViewGroup;", "touchViewGroup", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatSysMsgItemView;", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatSysMsgItemView;", "fakeMsgView", "Landroid/view/View;", "L", "Landroid/view/View;", "realMsgView", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "smoothScroller", "Lcom/tencent/mobileqq/icgame/widget/chat/recyclerview/ChatRecyclerView;", "Lcom/tencent/mobileqq/icgame/widget/chat/recyclerview/ChatRecyclerView;", "getMsgRecyclerView", "()Lcom/tencent/mobileqq/icgame/widget/chat/recyclerview/ChatRecyclerView;", "setMsgRecyclerView", "(Lcom/tencent/mobileqq/icgame/widget/chat/recyclerview/ChatRecyclerView;)V", "msgRecyclerView", "Lcom/tencent/mobileqq/icgame/widget/chat/adapter/ChatMessageAdapter;", "P", "Lcom/tencent/mobileqq/icgame/widget/chat/adapter/ChatMessageAdapter;", "adapter", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "lastVisibleItemPos", BdhLogUtil.LogTag.Tag_Req, "Lx42/b;", ExifInterface.LATITUDE_SOUTH, "Lx42/b;", "liveShadowMgr", "T", "Lz42/a;", "U", "Lz42/c;", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "def", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class ChatMessageLayout extends FrameLayout implements z42.b {

    /* renamed from: C, reason: from kotlin metadata */
    private long ownerId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<Object> datas;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private LinearLayoutManager linearLayoutManager;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView newMsgView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView newAtMsgView;

    /* renamed from: H, reason: from kotlin metadata */
    private int newMsgCount;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String showAtMsgId;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ViewGroup touchViewGroup;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private ChatSysMsgItemView fakeMsgView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private View realMsgView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private LinearSmoothScroller smoothScroller;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private ChatRecyclerView msgRecyclerView;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private ChatMessageAdapter adapter;

    /* renamed from: Q, reason: from kotlin metadata */
    private int lastVisibleItemPos;

    /* renamed from: R, reason: from kotlin metadata */
    private float proportion;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private x42.b liveShadowMgr;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private z42.a dataSupport;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private z42.c playFunc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLandscape;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<Object> mCacheMsgInLanScape;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int sizeHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String chatId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int roomType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/icgame/widget/chat/ChatMessageLayout$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            boolean z16;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            z42.c cVar = ChatMessageLayout.this.playFunc;
            if (cVar != null) {
                if (newState != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                cVar.k(z16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/icgame/widget/chat/ChatMessageLayout$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = wi2.c.b(4);
            }
            outRect.bottom = wi2.c.b(4);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/ChatMessageLayout$d;", "", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface d {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/icgame/widget/chat/ChatMessageLayout$e", "Lcom/tencent/mobileqq/icgame/widget/chat/adapter/ChatMessageAdapter$a;", "", "a", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e implements ChatMessageAdapter.a {
        e() {
        }

        @Override // com.tencent.mobileqq.icgame.widget.chat.adapter.ChatMessageAdapter.a
        public void a() {
            ChatMessageLayout.this.v();
            ChatMessageLayout.this.u();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMessageLayout(@NotNull Context ctx) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.mCacheMsgInLanScape = new LinkedList<>();
        this.sizeHeight = DisplayUtil.dip2px(getContext(), 50.0f);
        this.chatId = "999L";
        this.datas = new ArrayList();
        this.showAtMsgId = "";
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.smoothScroller = v42.a.a(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.adapter = new ChatMessageAdapter(context2);
        this.proportion = 1.0f;
        this.liveShadowMgr = new x42.b(wi2.c.d(30), wi2.c.d(4), -16777216);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        ChatSysMsgItemView chatSysMsgItemView = new ChatSysMsgItemView(context3, null, 0, 6, null);
        this.fakeMsgView = chatSysMsgItemView;
        chatSysMsgItemView.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(wi2.b.a(this), wi2.b.b(this));
        layoutParams.gravity = 80;
        layoutParams.leftMargin = wi2.c.b(12);
        layoutParams.rightMargin = wi2.c.b(12);
        layoutParams.bottomMargin = wi2.c.b(4);
        Unit unit = Unit.INSTANCE;
        addView(chatSysMsgItemView, layoutParams);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.realMsgView = frameLayout;
        Context context4 = frameLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        ChatRecyclerView chatRecyclerView = new ChatRecyclerView(context4, this.sizeHeight, null, 0, 12, null);
        this.msgRecyclerView = chatRecyclerView;
        chatRecyclerView.setEnabled(true);
        chatRecyclerView.setOverScrollMode(2);
        chatRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean F;
                F = ChatMessageLayout.F(ChatMessageLayout.this, view, motionEvent);
                return F;
            }
        });
        chatRecyclerView.addOnScrollListener(new a());
        chatRecyclerView.setRecycledViewPool(new a52.b());
        chatRecyclerView.setPadding(wi2.c.b(12), wi2.c.b(0), wi2.c.b(12), wi2.c.b(0));
        t(chatRecyclerView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(wi2.b.a(frameLayout), wi2.b.b(frameLayout));
        layoutParams2.gravity = 80;
        frameLayout.addView(chatRecyclerView, layoutParams2);
        TextView textView = new TextView(frameLayout.getContext());
        this.newMsgView = textView;
        wi2.b.d(textView, 12.0f);
        textView.setPadding(wi2.c.b(12), 0, wi2.c.b(12), 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatMessageLayout.G(ChatMessageLayout.this, view);
            }
        });
        textView.setTextColor(Color.parseColor("#6666FF"));
        textView.setGravity(17);
        textView.setVisibility(8);
        wi2.d.d(textView, wi2.c.b(18), c52.a.a(R.color.f158017al3));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(wi2.b.b(frameLayout), wi2.c.b(26));
        layoutParams3.gravity = 83;
        layoutParams3.bottomMargin = z();
        layoutParams3.leftMargin = wi2.c.b(16);
        frameLayout.setMinimumWidth(wi2.c.b(80));
        frameLayout.addView(textView, layoutParams3);
        TextView textView2 = new TextView(frameLayout.getContext());
        this.newAtMsgView = textView2;
        wi2.b.d(textView2, 12.0f);
        textView2.setPadding(wi2.c.b(12), 0, wi2.c.b(12), 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatMessageLayout.E(ChatMessageLayout.this, view);
            }
        });
        textView2.setCompoundDrawablePadding(wi2.c.b(3));
        textView2.setTextColor(c52.a.a(R.color.black));
        textView2.setGravity(17);
        textView2.setVisibility(8);
        wi2.d.d(textView2, wi2.c.b(18), c52.a.a(R.color.f158017al3));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(wi2.b.b(frameLayout), wi2.c.b(26));
        layoutParams4.gravity = 81;
        layoutParams4.bottomMargin = z();
        frameLayout.addView(textView2, layoutParams4);
        addView(frameLayout, new FrameLayout.LayoutParams(wi2.b.a(this), wi2.b.a(this)));
        setOverScrollMode(2);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext());
        this.linearLayoutManager = safeLinearLayoutManager;
        safeLinearLayoutManager.setStackFromEnd(true);
        this.linearLayoutManager.setOrientation(1);
        this.msgRecyclerView.setLayoutManager(this.linearLayoutManager);
        this.msgRecyclerView.setItemViewCacheSize(20);
        RecyclerView.ItemAnimator itemAnimator = this.msgRecyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(0L);
            itemAnimator.setRemoveDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
        }
        this.msgRecyclerView.addItemDecoration(new b());
        this.msgRecyclerView.setAdapter(this.adapter);
    }

    private final boolean B(Object msg2) {
        boolean z16;
        MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent2;
        MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg2;
        PBRepeatMessageField<MessageOuterClass$AtUser> pBRepeatMessageField;
        boolean z17 = false;
        if (!(msg2 instanceof w42.e)) {
            return false;
        }
        w42.e eVar = (w42.e) msg2;
        MessageOuterClass$TimMsgBody a16 = eVar.a();
        if (a16 != null && (messageOuterClass$MsgContent2 = a16.content) != null && (messageOuterClass$AtUserMsg2 = messageOuterClass$MsgContent2.at_user_msg) != null && (pBRepeatMessageField = messageOuterClass$AtUserMsg2.user_list) != null && pBRepeatMessageField.size() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && TextUtils.isEmpty(this.showAtMsgId)) {
            z42.a aVar = this.dataSupport;
            if (aVar != null) {
                MessageOuterClass$TimMsgBody a17 = eVar.a();
                if (a17 != null && (messageOuterClass$MsgContent = a17.content) != null) {
                    messageOuterClass$AtUserMsg = messageOuterClass$MsgContent.at_user_msg;
                } else {
                    messageOuterClass$AtUserMsg = null;
                }
                if (aVar.b(messageOuterClass$AtUserMsg)) {
                    z17 = true;
                }
            }
            if (z17) {
                this.showAtMsgId = eVar.id();
                return true;
            }
        }
        return !TextUtils.isEmpty(this.showAtMsgId);
    }

    private final void C() {
        this.mCacheMsgInLanScape.clear();
        if (this.datas.size() > 1000) {
            List<Object> list = this.datas;
            this.mCacheMsgInLanScape.addAll(new ArrayList(list.subList(list.size() - 1000, this.datas.size())));
            return;
        }
        this.mCacheMsgInLanScape.addAll(this.datas);
    }

    private final boolean D() {
        int findLastVisibleItemPosition = this.linearLayoutManager.findLastVisibleItemPosition();
        boolean z16 = false;
        if (findLastVisibleItemPosition >= 0 && findLastVisibleItemPosition < this.lastVisibleItemPos) {
            z16 = true;
        }
        this.lastVisibleItemPos = findLastVisibleItemPosition;
        return !z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(ChatMessageLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.a.a(this$0, false, 1, null);
        this$0.newMsgCount = 0;
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F(ChatMessageLayout this$0, View view, MotionEvent motionEvent) {
        z42.c cVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null && 1 == motionEvent.getAction() && (cVar = this$0.playFunc) != null) {
            cVar.i(motionEvent);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(ChatMessageLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c(false);
        this$0.newMsgCount = 0;
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ChatMessageLayout this$0) {
        z42.c cVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object obj = null;
        b.a.a(this$0, false, 1, null);
        Iterator<T> it = this$0.datas.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next instanceof AnnouncePushMessage) {
                obj = next;
                break;
            }
        }
        if (obj == null && (cVar = this$0.playFunc) != null) {
            cVar.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(ChatMessageLayout this$0, long j3) {
        String str;
        List<Object> d16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z42.a aVar = this$0.dataSupport;
        if (aVar != null && (d16 = aVar.d(j3)) != null) {
            this$0.datas.addAll(d16);
            RecyclerView.Adapter adapter = this$0.msgRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        b.a.a(this$0, false, 1, null);
        if (this$0.datas.isEmpty()) {
            rt0.a.INSTANCE.j(this$0.A(), "datas is empty");
            z42.a aVar2 = this$0.dataSupport;
            if (aVar2 != null) {
                z42.c cVar = this$0.playFunc;
                if (cVar == null || (str = cVar.h()) == null) {
                    str = "";
                }
                aVar2.s(new w42.j(str, 1, 0, 4, null));
            }
        }
    }

    private final void K() {
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setText(r());
        }
        final int y16 = y();
        rt0.a.INSTANCE.f(A(), "showAtMsgShortCut: " + y16);
        N(false, new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatMessageLayout.L(ChatMessageLayout.this, y16, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(ChatMessageLayout this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w(this$0.msgRecyclerView, Math.max(0, this$0.datas.size() - i3), true);
        this$0.u();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void M() {
        rt0.a.INSTANCE.j(A(), "showCachedLandScapeMsg size=" + this.mCacheMsgInLanScape.size());
        this.datas.clear();
        this.datas.addAll(this.mCacheMsgInLanScape);
        RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        b.a.a(this, false, 1, null);
        this.mCacheMsgInLanScape.clear();
    }

    private final void N(boolean up5, View.OnClickListener listener) {
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.newAtMsgView;
        if (textView2 != null) {
            textView2.setOnClickListener(listener);
        }
    }

    private final SpannableStringBuilder r() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("\u6709\u4eba@\u4f60");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(c52.a.a(R.color.f158017al3)), 2, 4, 33);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        this.showAtMsgId = "";
        this.newMsgCount = 0;
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        TextView textView = this.newMsgView;
        if (textView != null) {
            wi2.d.e(textView, false);
        }
        this.newMsgCount = 0;
    }

    private final void w(final RecyclerView recyclerView, final int i3, final boolean z16) {
        if (i3 < this.datas.size() && i3 >= 0) {
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.widget.chat.k
                @Override // java.lang.Runnable
                public final void run() {
                    ChatMessageLayout.x(RecyclerView.this, z16, i3, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(RecyclerView this_completeScrollToPos, boolean z16, int i3, ChatMessageLayout this$0) {
        Intrinsics.checkNotNullParameter(this_completeScrollToPos, "$this_completeScrollToPos");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_completeScrollToPos.stopScroll();
        if (z16) {
            this_completeScrollToPos.scrollToPosition(i3);
        } else {
            RecyclerView.LayoutManager layoutManager = this_completeScrollToPos.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, 0);
        }
        this$0.u();
    }

    private final int y() {
        int size;
        if (!TextUtils.isEmpty(this.showAtMsgId)) {
            int i3 = 0;
            for (Object obj : this.datas) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if ((obj instanceof w42.e) && Intrinsics.areEqual(this.showAtMsgId, ((w42.e) obj).id()) && (size = this.datas.size() - i3) >= 0) {
                    return size;
                }
                i3 = i16;
            }
        }
        return 0;
    }

    @NotNull
    public String A() {
        return "ICGameChat_Message|ICGameChatMessageLayout";
    }

    public void J() {
        z42.a aVar = this.dataSupport;
        if (aVar != null) {
            aVar.n(this.datas);
        }
    }

    @Override // z42.b
    public void a(boolean show) {
        String str;
        if (show) {
            this.realMsgView.setVisibility(0);
            this.fakeMsgView.setVisibility(8);
            return;
        }
        this.realMsgView.setVisibility(8);
        this.fakeMsgView.setVisibility(0);
        ChatSysMsgItemView chatSysMsgItemView = this.fakeMsgView;
        z42.c cVar = this.playFunc;
        if (cVar == null || (str = cVar.h()) == null) {
            str = "";
        }
        chatSysMsgItemView.l(new w42.j(str, 0, 0, 6, null));
    }

    @Override // z42.b
    public void b(long roomId, long ownerId, int roomType) {
        rt0.a.INSTANCE.j(A(), "onEnterRoom roomId[" + roomId + ']');
        z42.a aVar = this.dataSupport;
        if (aVar != null) {
            aVar.unregister();
        }
        z42.a aVar2 = this.dataSupport;
        if (aVar2 != null) {
            aVar2.B(this.datas);
        }
        this.roomType = roomType;
        this.roomId = roomId;
        this.chatId = String.valueOf(roomId);
        if (this.ownerId == ownerId) {
            z42.a aVar3 = this.dataSupport;
            if (aVar3 != null) {
                aVar3.register();
                return;
            }
            return;
        }
        this.ownerId = ownerId;
        z42.a aVar4 = this.dataSupport;
        if (aVar4 != null) {
            aVar4.register();
        }
        this.adapter.k0(roomId, ownerId, this.datas, this.dataSupport, this.playFunc);
        this.adapter.j0(new e());
        this.msgRecyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.widget.chat.l
            @Override // java.lang.Runnable
            public final void run() {
                ChatMessageLayout.H(ChatMessageLayout.this);
            }
        });
    }

    @Override // z42.b
    public void c(boolean smooth) {
        int i3;
        RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
        if (adapter != null) {
            i3 = adapter.getItemCount();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return;
        }
        this.msgRecyclerView.stopScroll();
        if (smooth) {
            this.smoothScroller.setTargetPosition(i3 - 1);
            RecyclerView.LayoutManager layoutManager = this.msgRecyclerView.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.startSmoothScroll(this.smoothScroller);
            }
        } else {
            this.linearLayoutManager.scrollToPositionWithOffset(i3 - 1, 0);
        }
        v();
        u();
    }

    @Override // z42.b
    public void d(@NotNull Object msg2) {
        String valueOf;
        boolean z16;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (D()) {
            TextView textView = this.newMsgView;
            if (textView != null && textView.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                s(msg2);
                b.a.a(this, false, 1, null);
                return;
            }
        }
        this.newMsgCount++;
        TextView textView2 = this.newMsgView;
        if (textView2 != null) {
            wi2.d.e(textView2, true);
        }
        s(msg2);
        TextView textView3 = this.newMsgView;
        if (textView3 != null) {
            StringBuilder sb5 = new StringBuilder();
            int i3 = this.newMsgCount;
            if (i3 > 99) {
                valueOf = "99+";
            } else {
                valueOf = String.valueOf(i3);
            }
            sb5.append(valueOf);
            sb5.append("\u6761\u65b0\u6d88\u606f");
            textView3.setText(sb5.toString());
        }
        if (B(msg2)) {
            rt0.a.INSTANCE.f(A(), "hasAtMeMessage: " + this.showAtMsgId);
            K();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r5.getPointerCount() == 1) goto L10;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        boolean z16;
        ViewGroup viewGroup = this.touchViewGroup;
        if (viewGroup != null) {
            if (ev5 != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                ev5.getPointerId(0);
                viewGroup.dispatchTouchEvent(ev5);
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // z42.b
    public void e(final long roomId) {
        rt0.a.INSTANCE.j(A(), "onPreLoadRoom roomId[" + roomId + "] ownerId[" + this.ownerId + ']');
        this.roomId = roomId;
        this.chatId = String.valueOf(roomId);
        this.adapter.k0(roomId, this.ownerId, this.datas, this.dataSupport, this.playFunc);
        ViewGroup.LayoutParams layoutParams = this.msgRecyclerView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = wi2.b.b(this);
            this.msgRecyclerView.setLayoutParams(layoutParams);
            this.msgRecyclerView.setHasFixedSize(false);
        }
        this.datas.clear();
        RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        this.msgRecyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.widget.chat.j
            @Override // java.lang.Runnable
            public final void run() {
                ChatMessageLayout.I(ChatMessageLayout.this, roomId);
            }
        });
    }

    @Override // z42.b
    public void f(@NotNull w42.f msg2) {
        Object lastOrNull;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.datas);
        if (lastOrNull instanceof w42.b) {
            z16 = true;
        } else {
            z16 = lastOrNull instanceof w42.g;
        }
        if (z16) {
            z17 = true;
        } else {
            z17 = lastOrNull instanceof w42.k;
        }
        if (z17) {
            int size = this.datas.size() - 1;
            this.datas.set(size, msg2);
            z42.a aVar = this.dataSupport;
            if (aVar != null) {
                aVar.x(msg2, size);
                return;
            }
            return;
        }
        z42.a aVar2 = this.dataSupport;
        if (aVar2 != null) {
            aVar2.s(msg2);
        }
    }

    @Override // z42.b
    public void g(int pos) {
        RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(pos, 0);
        }
    }

    @Override // z42.b
    public void notifyDataSetChanged() {
        RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        boolean z16;
        super.onConfigurationChanged(newConfig);
        Intrinsics.checkNotNull(newConfig);
        if (newConfig.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        rt0.a.INSTANCE.j(A(), "onConfigurationChanged -> orientation: isLandscape:" + z16 + ",oldIsLandscape:" + this.mIsLandscape);
        boolean z17 = this.mIsLandscape;
        if (z17 == z16) {
            return;
        }
        if (z17 && !z16) {
            M();
            this.mIsLandscape = z16;
        } else if (!z17 && z16) {
            C();
            this.mIsLandscape = z16;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rt0.a.INSTANCE.j(A(), NodeProps.ON_DETACHED_FROM_WINDOW);
        J();
        z42.a aVar = this.dataSupport;
        if (aVar != null) {
            aVar.unregister();
        }
    }

    @Override // z42.b
    public void onExitRoom(long roomId) {
        rt0.a.INSTANCE.j(A(), "onExitRoom");
        if (roomId == this.roomId) {
            z42.a aVar = this.dataSupport;
            if (aVar != null) {
                aVar.unregister();
            }
            this.datas.clear();
            RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            this.roomId = 0L;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        rt0.a.INSTANCE.j(A(), "w = [" + w3 + "], h = [" + h16 + "], oldw = [" + oldw + "], oldh = [" + oldh + "] proportion=[" + this.proportion + ']');
        int i3 = (int) (((float) h16) * this.proportion);
        this.sizeHeight = i3;
        this.msgRecyclerView.C(i3);
        this.liveShadowMgr.e(w3, h16, oldw, oldh);
    }

    public void s(@NotNull Object msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (this.mIsLandscape) {
            this.mCacheMsgInLanScape.add(msg2);
            int size = this.mCacheMsgInLanScape.size();
            if (size > 1000) {
                rt0.a.INSTANCE.j(A(), "reduce 500 msg items");
                LinkedList linkedList = new LinkedList(this.mCacheMsgInLanScape.subList(500, size));
                this.mCacheMsgInLanScape.clear();
                this.mCacheMsgInLanScape.addAll(linkedList);
                return;
            }
            return;
        }
        this.datas.add(msg2);
        int size2 = this.datas.size();
        if (size2 > 1000) {
            rt0.a.INSTANCE.j(A(), "reduce 500 msg items");
            ArrayList arrayList = new ArrayList(this.datas.subList(500, size2));
            this.datas.clear();
            this.datas.addAll(arrayList);
            RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemRangeRemoved(0, 500);
            }
        }
        RecyclerView.Adapter adapter2 = this.msgRecyclerView.getAdapter();
        if (adapter2 != null) {
            adapter2.notifyItemInserted(this.datas.size() - 1);
        }
    }

    public void setAnchorMessageItemClickListener(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.adapter.p0(listener);
    }

    public final void setHeightProportion(float proportion) {
        this.proportion = proportion;
    }

    public final void setMinHeight(int height) {
        this.sizeHeight = height;
        this.msgRecyclerView.C(height);
    }

    public final void setMsgRecyclerView(@NotNull ChatRecyclerView chatRecyclerView) {
        Intrinsics.checkNotNullParameter(chatRecyclerView, "<set-?>");
        this.msgRecyclerView = chatRecyclerView;
    }

    public final void setOwnerId(long j3) {
        this.ownerId = j3;
    }

    @Override // z42.b
    public void setSupportFunc(@NotNull z42.a dataSupport, @NotNull z42.c playFunc) {
        Intrinsics.checkNotNullParameter(dataSupport, "dataSupport");
        Intrinsics.checkNotNullParameter(playFunc, "playFunc");
        this.dataSupport = dataSupport;
        this.playFunc = playFunc;
    }

    public void setTouchViewGroup(@Nullable ViewGroup view) {
        this.touchViewGroup = view;
    }

    public void t(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.liveShadowMgr == null) {
            this.liveShadowMgr = new x42.b(wi2.c.d(30), wi2.c.d(4), -16777216);
        }
        recyclerView.addItemDecoration(this.liveShadowMgr.d());
    }

    public int z() {
        return wi2.c.b(14);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMessageLayout(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        super(ctx, attributeSet);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.mCacheMsgInLanScape = new LinkedList<>();
        this.sizeHeight = DisplayUtil.dip2px(getContext(), 50.0f);
        this.chatId = "999L";
        this.datas = new ArrayList();
        this.showAtMsgId = "";
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.smoothScroller = v42.a.a(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.adapter = new ChatMessageAdapter(context2);
        this.proportion = 1.0f;
        this.liveShadowMgr = new x42.b(wi2.c.d(30), wi2.c.d(4), -16777216);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        ChatSysMsgItemView chatSysMsgItemView = new ChatSysMsgItemView(context3, null, 0, 6, null);
        this.fakeMsgView = chatSysMsgItemView;
        chatSysMsgItemView.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(wi2.b.a(this), wi2.b.b(this));
        layoutParams.gravity = 80;
        layoutParams.leftMargin = wi2.c.b(12);
        layoutParams.rightMargin = wi2.c.b(12);
        layoutParams.bottomMargin = wi2.c.b(4);
        Unit unit = Unit.INSTANCE;
        addView(chatSysMsgItemView, layoutParams);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.realMsgView = frameLayout;
        Context context4 = frameLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        ChatRecyclerView chatRecyclerView = new ChatRecyclerView(context4, this.sizeHeight, null, 0, 12, null);
        this.msgRecyclerView = chatRecyclerView;
        chatRecyclerView.setEnabled(true);
        chatRecyclerView.setOverScrollMode(2);
        chatRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean F;
                F = ChatMessageLayout.F(ChatMessageLayout.this, view, motionEvent);
                return F;
            }
        });
        chatRecyclerView.addOnScrollListener(new a());
        chatRecyclerView.setRecycledViewPool(new a52.b());
        chatRecyclerView.setPadding(wi2.c.b(12), wi2.c.b(0), wi2.c.b(12), wi2.c.b(0));
        t(chatRecyclerView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(wi2.b.a(frameLayout), wi2.b.b(frameLayout));
        layoutParams2.gravity = 80;
        frameLayout.addView(chatRecyclerView, layoutParams2);
        TextView textView = new TextView(frameLayout.getContext());
        this.newMsgView = textView;
        wi2.b.d(textView, 12.0f);
        textView.setPadding(wi2.c.b(12), 0, wi2.c.b(12), 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatMessageLayout.G(ChatMessageLayout.this, view);
            }
        });
        textView.setTextColor(Color.parseColor("#6666FF"));
        textView.setGravity(17);
        textView.setVisibility(8);
        wi2.d.d(textView, wi2.c.b(18), c52.a.a(R.color.f158017al3));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(wi2.b.b(frameLayout), wi2.c.b(26));
        layoutParams3.gravity = 83;
        layoutParams3.bottomMargin = z();
        layoutParams3.leftMargin = wi2.c.b(16);
        frameLayout.setMinimumWidth(wi2.c.b(80));
        frameLayout.addView(textView, layoutParams3);
        TextView textView2 = new TextView(frameLayout.getContext());
        this.newAtMsgView = textView2;
        wi2.b.d(textView2, 12.0f);
        textView2.setPadding(wi2.c.b(12), 0, wi2.c.b(12), 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatMessageLayout.E(ChatMessageLayout.this, view);
            }
        });
        textView2.setCompoundDrawablePadding(wi2.c.b(3));
        textView2.setTextColor(c52.a.a(R.color.black));
        textView2.setGravity(17);
        textView2.setVisibility(8);
        wi2.d.d(textView2, wi2.c.b(18), c52.a.a(R.color.f158017al3));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(wi2.b.b(frameLayout), wi2.c.b(26));
        layoutParams4.gravity = 81;
        layoutParams4.bottomMargin = z();
        frameLayout.addView(textView2, layoutParams4);
        addView(frameLayout, new FrameLayout.LayoutParams(wi2.b.a(this), wi2.b.a(this)));
        setOverScrollMode(2);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext());
        this.linearLayoutManager = safeLinearLayoutManager;
        safeLinearLayoutManager.setStackFromEnd(true);
        this.linearLayoutManager.setOrientation(1);
        this.msgRecyclerView.setLayoutManager(this.linearLayoutManager);
        this.msgRecyclerView.setItemViewCacheSize(20);
        RecyclerView.ItemAnimator itemAnimator = this.msgRecyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(0L);
            itemAnimator.setRemoveDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
        }
        this.msgRecyclerView.addItemDecoration(new b());
        this.msgRecyclerView.setAdapter(this.adapter);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMessageLayout(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.mCacheMsgInLanScape = new LinkedList<>();
        this.sizeHeight = DisplayUtil.dip2px(getContext(), 50.0f);
        this.chatId = "999L";
        this.datas = new ArrayList();
        this.showAtMsgId = "";
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.smoothScroller = v42.a.a(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.adapter = new ChatMessageAdapter(context2);
        this.proportion = 1.0f;
        this.liveShadowMgr = new x42.b(wi2.c.d(30), wi2.c.d(4), -16777216);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        ChatSysMsgItemView chatSysMsgItemView = new ChatSysMsgItemView(context3, null, 0, 6, null);
        this.fakeMsgView = chatSysMsgItemView;
        chatSysMsgItemView.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(wi2.b.a(this), wi2.b.b(this));
        layoutParams.gravity = 80;
        layoutParams.leftMargin = wi2.c.b(12);
        layoutParams.rightMargin = wi2.c.b(12);
        layoutParams.bottomMargin = wi2.c.b(4);
        Unit unit = Unit.INSTANCE;
        addView(chatSysMsgItemView, layoutParams);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.realMsgView = frameLayout;
        Context context4 = frameLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        ChatRecyclerView chatRecyclerView = new ChatRecyclerView(context4, this.sizeHeight, null, 0, 12, null);
        this.msgRecyclerView = chatRecyclerView;
        chatRecyclerView.setEnabled(true);
        chatRecyclerView.setOverScrollMode(2);
        chatRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean F;
                F = ChatMessageLayout.F(ChatMessageLayout.this, view, motionEvent);
                return F;
            }
        });
        chatRecyclerView.addOnScrollListener(new a());
        chatRecyclerView.setRecycledViewPool(new a52.b());
        chatRecyclerView.setPadding(wi2.c.b(12), wi2.c.b(0), wi2.c.b(12), wi2.c.b(0));
        t(chatRecyclerView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(wi2.b.a(frameLayout), wi2.b.b(frameLayout));
        layoutParams2.gravity = 80;
        frameLayout.addView(chatRecyclerView, layoutParams2);
        TextView textView = new TextView(frameLayout.getContext());
        this.newMsgView = textView;
        wi2.b.d(textView, 12.0f);
        textView.setPadding(wi2.c.b(12), 0, wi2.c.b(12), 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatMessageLayout.G(ChatMessageLayout.this, view);
            }
        });
        textView.setTextColor(Color.parseColor("#6666FF"));
        textView.setGravity(17);
        textView.setVisibility(8);
        wi2.d.d(textView, wi2.c.b(18), c52.a.a(R.color.f158017al3));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(wi2.b.b(frameLayout), wi2.c.b(26));
        layoutParams3.gravity = 83;
        layoutParams3.bottomMargin = z();
        layoutParams3.leftMargin = wi2.c.b(16);
        frameLayout.setMinimumWidth(wi2.c.b(80));
        frameLayout.addView(textView, layoutParams3);
        TextView textView2 = new TextView(frameLayout.getContext());
        this.newAtMsgView = textView2;
        wi2.b.d(textView2, 12.0f);
        textView2.setPadding(wi2.c.b(12), 0, wi2.c.b(12), 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatMessageLayout.E(ChatMessageLayout.this, view);
            }
        });
        textView2.setCompoundDrawablePadding(wi2.c.b(3));
        textView2.setTextColor(c52.a.a(R.color.black));
        textView2.setGravity(17);
        textView2.setVisibility(8);
        wi2.d.d(textView2, wi2.c.b(18), c52.a.a(R.color.f158017al3));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(wi2.b.b(frameLayout), wi2.c.b(26));
        layoutParams4.gravity = 81;
        layoutParams4.bottomMargin = z();
        frameLayout.addView(textView2, layoutParams4);
        addView(frameLayout, new FrameLayout.LayoutParams(wi2.b.a(this), wi2.b.a(this)));
        setOverScrollMode(2);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext());
        this.linearLayoutManager = safeLinearLayoutManager;
        safeLinearLayoutManager.setStackFromEnd(true);
        this.linearLayoutManager.setOrientation(1);
        this.msgRecyclerView.setLayoutManager(this.linearLayoutManager);
        this.msgRecyclerView.setItemViewCacheSize(20);
        RecyclerView.ItemAnimator itemAnimator = this.msgRecyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(0L);
            itemAnimator.setRemoveDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
        }
        this.msgRecyclerView.addItemDecoration(new b());
        this.msgRecyclerView.setAdapter(this.adapter);
    }
}
