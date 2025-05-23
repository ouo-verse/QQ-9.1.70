package com.tencent.mobileqq.qqlive.widget.chat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.widget.chat.ChatMessageLayout;
import com.tencent.mobileqq.qqlive.widget.chat.floating.ChatAnnounceMsgFloatingItemView;
import com.tencent.mobileqq.qqlive.widget.chat.floating.ChatGiftMsgFloatingItemView;
import com.tencent.mobileqq.qqlive.widget.chat.floating.ChatSysMsgFloatingItemView;
import com.tencent.mobileqq.qqlive.widget.chat.floating.ChatTextMsgFloatingItemView;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTeamHintMsgItemView;
import com.tencent.mobileqq.qqlive.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.qqlive.widget.chat.message.n;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import trpc.yes.common.MessageOuterClass$AnchorRoomBulletScreenMsg;
import trpc.yes.common.MessageOuterClass$AtUser;
import trpc.yes.common.MessageOuterClass$AtUserMsg;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TimMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 c2\u00020\u00012\u00020\u0002:\u00043=d+B'\b\u0007\u0012\u0006\u0010]\u001a\u00020\\\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u0012\b\b\u0002\u0010`\u001a\u00020\u0011\u00a2\u0006\u0004\ba\u0010bJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u0018\u001a\u00020\u0007*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J(\u0010#\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0014J(\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0003H\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\u001a\u00101\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u00010/H\u0016J \u00103\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\u0006\u00102\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0010\u00104\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0003H\u0016J\u0010\u00108\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u000207H\u0016J\u0012\u0010;\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010=\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0003H\u0016J\b\u0010>\u001a\u00020\u0007H\u0016J\u0006\u0010?\u001a\u00020\u0007R\u0016\u0010@\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u0014R\"\u0010B\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010FR\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0004R\u0016\u0010'\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\u0014R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010\u0004R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00050I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010JR\u0016\u0010N\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010MR\u0016\u0010P\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010RR\u0016\u0010V\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0016\u0010W\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010FR\u0016\u0010(\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010AR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/ChatFloatingMessageLayout;", "Landroid/widget/FrameLayout;", "Lvi2/b;", "", "J", "", "msg", "", BdhLogUtil.LogTag.Tag_Conn, "E", "Landroid/text/SpannableStringBuilder;", "B", "up", "Landroid/view/View$OnClickListener;", "listener", BdhLogUtil.LogTag.Tag_Req, "P", "", "H", "D", "I", "Landroidx/recyclerview/widget/RecyclerView;", com.tencent.luggage.wxa.c8.c.G, "useScrollTo", UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "setSupportFunc", "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "", "roomId", "ownerId", "roomType", "isSingleLineModel", "e", "f", "d", "g", "N", "notifyDataSetChanged", "", "platform", "i", "anchorUid", "b", "onExitRoom", "show", "a", "Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout$e;", "setAnchorMessageItemClickListener", "Landroid/view/ViewGroup;", "view", "setTouchViewGroup", LightConstants.DowngradeStrategyKey.SMOOTH, "c", "a0", "O", "sizeHeight", "Z", "isAnchor", "()Z", "setAnchor", "(Z)V", "Ljava/lang/String;", "chatId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Ljava/util/List;", "datas", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "newMsgView", "G", "newAtMsgView", "newMsgCount", "showAtMsgId", "K", "Lvi2/a;", "L", "Lvi2/c;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "M", "MsgRecyclerView", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ChatFloatingMessageLayout extends FrameLayout implements vi2.b {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<Object> datas;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private LinearLayoutManager linearLayoutManager;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private RecyclerView recyclerView;

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
    private boolean isSingleLineModel;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private vi2.a dataSupport;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private vi2.c playFunc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int sizeHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isAnchor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String chatId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int roomType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long ownerId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/ChatFloatingMessageLayout$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.bottom = wi2.c.b(7);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/ChatFloatingMessageLayout$b;", "", "", "LIMIT_DATA_NUMS", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.chat.ChatFloatingMessageLayout$b, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/ChatFloatingMessageLayout$c;", "", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface c {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/ChatFloatingMessageLayout$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/qqlive/widget/chat/ChatFloatingMessageLayout;Landroid/view/View;)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class d extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        final /* synthetic */ ChatFloatingMessageLayout E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull ChatFloatingMessageLayout chatFloatingMessageLayout, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = chatFloatingMessageLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatFloatingMessageLayout, (Object) itemView);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24384);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatFloatingMessageLayout(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            return;
        }
        iPatchRedirector.redirect((short) 26, (Object) this, (Object) ctx);
    }

    private final SpannableStringBuilder B() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("\u6709\u4eba@\u4f60");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.f157985cu1)), 2, 4, 33);
        return spannableStringBuilder;
    }

    private final void C(Object msg2) {
        this.datas.add(msg2);
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemInserted(this.datas.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        this.showAtMsgId = "";
        this.newMsgCount = 0;
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        TextView textView = this.newMsgView;
        if (textView != null) {
            wi2.d.e(textView, false);
        }
        this.newMsgCount = 0;
    }

    private final void F(final RecyclerView recyclerView, final int i3, final boolean z16) {
        if (i3 < this.datas.size() && i3 >= 0) {
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.chat.e
                @Override // java.lang.Runnable
                public final void run() {
                    ChatFloatingMessageLayout.G(RecyclerView.this, z16, i3, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(RecyclerView this_completeScrollToPos, boolean z16, int i3, ChatFloatingMessageLayout this$0) {
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
        this$0.D();
    }

    private final int H() {
        int size;
        if (!TextUtils.isEmpty(this.showAtMsgId)) {
            int i3 = 0;
            for (Object obj : this.datas) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if ((obj instanceof com.tencent.mobileqq.qqlive.widget.chat.message.e) && Intrinsics.areEqual(this.showAtMsgId, ((com.tencent.mobileqq.qqlive.widget.chat.message.e) obj).id()) && (size = this.datas.size() - i3) >= 0) {
                    return size;
                }
                i3 = i16;
            }
        }
        return 0;
    }

    private final boolean I(Object msg2) {
        boolean z16;
        MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent2;
        MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg2;
        PBRepeatMessageField<MessageOuterClass$AtUser> pBRepeatMessageField;
        boolean z17 = false;
        if (!(msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.e)) {
            return false;
        }
        com.tencent.mobileqq.qqlive.widget.chat.message.e eVar = (com.tencent.mobileqq.qqlive.widget.chat.message.e) msg2;
        MessageOuterClass$TimMsgBody a16 = eVar.a();
        if (a16 != null && (messageOuterClass$MsgContent2 = a16.content) != null && (messageOuterClass$AtUserMsg2 = messageOuterClass$MsgContent2.at_user_msg) != null && (pBRepeatMessageField = messageOuterClass$AtUserMsg2.user_list) != null && pBRepeatMessageField.size() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && TextUtils.isEmpty(this.showAtMsgId)) {
            vi2.a aVar = this.dataSupport;
            if (aVar != null) {
                MessageOuterClass$TimMsgBody a17 = eVar.a();
                if (a17 != null && (messageOuterClass$MsgContent = a17.content) != null) {
                    messageOuterClass$AtUserMsg = messageOuterClass$MsgContent.at_user_msg;
                } else {
                    messageOuterClass$AtUserMsg = null;
                }
                if (aVar.N(messageOuterClass$AtUserMsg)) {
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

    private final boolean J() {
        return !this.recyclerView.canScrollVertically(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K(ChatFloatingMessageLayout this$0, View view, MotionEvent motionEvent) {
        vi2.c cVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null && 1 == motionEvent.getAction() && (cVar = this$0.playFunc) != null) {
            cVar.i(motionEvent);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(ChatFloatingMessageLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O();
        this$0.newMsgCount = 0;
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(ChatFloatingMessageLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O();
        this$0.newMsgCount = 0;
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P() {
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setText(B());
        }
        final int H = H();
        AegisLogger.INSTANCE.d("Chat_Message|ChatFloatingMessageLayout", "showAtMsgShortCut: " + H);
        R(false, new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.widget.chat.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatFloatingMessageLayout.Q(ChatFloatingMessageLayout.this, H, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(ChatFloatingMessageLayout this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F(this$0.recyclerView, Math.max(0, this$0.datas.size() - i3), true);
        this$0.D();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R(boolean up5, View.OnClickListener listener) {
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.newAtMsgView;
        if (textView2 != null) {
            textView2.setOnClickListener(listener);
        }
    }

    public static final /* synthetic */ c q(ChatFloatingMessageLayout chatFloatingMessageLayout) {
        chatFloatingMessageLayout.getClass();
        return null;
    }

    public void N(int pos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, pos);
            return;
        }
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(pos, 0);
        }
    }

    public final void O() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            i3 = adapter.getNUM_BACKGOURND_ICON();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return;
        }
        this.recyclerView.stopScroll();
        this.linearLayoutManager.scrollToPositionWithOffset(i3 - 1, 0);
        E();
        D();
    }

    @Override // vi2.b
    public void a(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, show);
        }
    }

    @Override // vi2.b
    public void a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    @Override // vi2.b
    public void b(long roomId, long anchorUid, int roomType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(roomId), Long.valueOf(anchorUid), Integer.valueOf(roomType));
        }
    }

    @Override // vi2.b
    public void c(boolean smooth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, smooth);
        }
    }

    @Override // vi2.b
    public void d(@NotNull Object msg2) {
        String valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (J()) {
            C(msg2);
            O();
            return;
        }
        this.newMsgCount++;
        TextView textView = this.newMsgView;
        if (textView != null) {
            wi2.d.e(textView, true);
        }
        C(msg2);
        TextView textView2 = this.newMsgView;
        if (textView2 != null) {
            StringBuilder sb5 = new StringBuilder();
            int i3 = this.newMsgCount;
            if (i3 > 99) {
                valueOf = "99+";
            } else {
                valueOf = String.valueOf(i3);
            }
            sb5.append(valueOf);
            sb5.append("\u6761\u65b0\u6d88\u606f");
            textView2.setText(sb5.toString());
        }
        if (I(msg2)) {
            AegisLogger.INSTANCE.d("Chat_Message|ChatFloatingMessageLayout", "hasAtMeMessage: " + this.showAtMsgId);
            P();
        }
    }

    @Override // vi2.b
    public void e(long roomId, long ownerId, int roomType, boolean isSingleLineModel) {
        List<Object> d16;
        List takeLast;
        boolean z16;
        Object obj;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(roomId), Long.valueOf(ownerId), Integer.valueOf(roomType), Boolean.valueOf(isSingleLineModel));
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.d("Chat_Message|ChatFloatingMessageLayout", "onFloatingViewInit", "roomId[" + roomId + "] ownerId[" + ownerId + "] roomType[" + roomType + "] isSingleLineModel[" + isSingleLineModel + ']');
        this.roomId = roomId;
        this.chatId = String.valueOf(roomId);
        this.roomType = roomType;
        if (this.ownerId == ownerId) {
            companion.e("Chat_Message|ChatFloatingMessageLayout", "onFloatingViewInit !!ownerId[" + ownerId + ']', "");
            return;
        }
        this.ownerId = ownerId;
        this.isSingleLineModel = isSingleLineModel;
        this.datas.clear();
        vi2.a aVar = this.dataSupport;
        if (aVar != null && (d16 = aVar.d(roomId)) != null) {
            if (this.isSingleLineModel && !d16.isEmpty()) {
                ListIterator<Object> listIterator = d16.listIterator(d16.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        obj = listIterator.previous();
                        if (!(obj instanceof AnnouncePushMessage) && !(obj instanceof com.tencent.mobileqq.qqlive.widget.chat.message.j)) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj != null) {
                    this.datas.add(obj);
                }
            } else {
                List<Object> list = this.datas;
                takeLast = CollectionsKt___CollectionsKt.takeLast(d16, 100);
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : takeLast) {
                    if (!(obj2 instanceof AnnouncePushMessage) && !(obj2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.j)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(obj2);
                    }
                }
                list.addAll(arrayList);
            }
            QLog.d("Chat_Message|ChatFloatingMessageLayout", 1, "datas size: " + this.datas.size());
        }
        if (this.datas.isEmpty()) {
            QLog.d("Chat_Message|ChatFloatingMessageLayout", 1, "datas is empty");
            if (isSingleLineModel) {
                this.datas.add(new com.tencent.mobileqq.qqlive.widget.chat.message.j("\u76f4\u64ad\u95f4\u6d88\u606f\u63a8\u9001\u5c06\u5728\u6b64\u5904\u663e\u793a", 0, 0, null, null, 30, null));
            }
        }
        ViewGroup.LayoutParams layoutParams = this.recyclerView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = wi2.b.b(this);
            this.recyclerView.setLayoutParams(layoutParams);
            this.recyclerView.setHasFixedSize(false);
        }
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // vi2.b
    public void f(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, roomId);
            return;
        }
        AegisLogger.INSTANCE.i("Chat_Message|ChatFloatingMessageLayout", "onFloatingViewDismiss roomId[" + roomId + ']');
        if (roomId == this.roomId) {
            vi2.a aVar = this.dataSupport;
            if (aVar != null) {
                aVar.n(this.datas);
            }
            this.datas.clear();
            this.roomId = 0L;
            this.ownerId = 0L;
        }
    }

    @Override // vi2.b
    public void g(@NotNull Object msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.datas.clear();
        this.datas.add(msg2);
        N(0);
    }

    @Override // vi2.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @Override // vi2.b
    public void i(long roomId, @Nullable String platform) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(roomId), platform);
        }
    }

    @Override // vi2.b
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    @Override // vi2.b
    public void onExitRoom(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, roomId);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
            return;
        }
        super.onSizeChanged(w3, h16, oldw, oldh);
        AegisLogger.INSTANCE.i("Chat_Message|ChatFloatingMessageLayout", "w = [" + w3 + "], h = [" + h16 + "], oldw = [" + oldw + "], oldh = [" + oldh + ']');
        this.sizeHeight = h16;
    }

    public final void setAnchor(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isAnchor = z16;
        }
    }

    public void setAnchorMessageItemClickListener(@NotNull ChatMessageLayout.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }
    }

    @Override // vi2.b
    public void setSupportFunc(@NotNull vi2.a dataSupport, @NotNull vi2.c playFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dataSupport, (Object) playFunc);
            return;
        }
        Intrinsics.checkNotNullParameter(dataSupport, "dataSupport");
        Intrinsics.checkNotNullParameter(playFunc, "playFunc");
        this.dataSupport = dataSupport;
        this.playFunc = playFunc;
    }

    public void setTouchViewGroup(@Nullable ViewGroup view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) view);
        }
    }

    @Override // vi2.b
    @NotNull
    public RecyclerView x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.recyclerView;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0014J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/ChatFloatingMessageLayout$MsgRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/ViewParent;", BdhLogUtil.LogTag.Tag_Conn, "", "w", tl.h.F, "oldw", "oldh", "", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "widthSpec", "heightSpec", "onMeasure", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "direction", "canScrollHorizontally", "e", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "def", "<init>", "(Lcom/tencent/mobileqq/qqlive/widget/chat/ChatFloatingMessageLayout;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class MsgRecyclerView extends RecyclerView {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ChatFloatingMessageLayout f273737f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public MsgRecyclerView(@NotNull ChatFloatingMessageLayout chatFloatingMessageLayout, @Nullable Context ctx, AttributeSet attributeSet, int i3) {
            super(ctx, attributeSet, i3);
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            this.f273737f = chatFloatingMessageLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, chatFloatingMessageLayout, ctx, attributeSet, Integer.valueOf(i3));
        }

        private final ViewParent C() {
            ViewParent parent = getParent();
            while (true) {
                vi2.a aVar = this.f273737f.dataSupport;
                boolean z16 = false;
                if (aVar != null && aVar.u(parent)) {
                    z16 = true;
                }
                if (z16) {
                    if (parent != null) {
                        parent = parent.getParent();
                    } else {
                        parent = null;
                    }
                } else {
                    return parent;
                }
            }
        }

        @Override // android.view.View
        public boolean canScrollHorizontally(int direction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, direction)).booleanValue();
            }
            return false;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) ev5)).booleanValue();
            }
            return super.dispatchTouchEvent(ev5);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(@Nullable MotionEvent e16) {
            Integer num;
            ViewParent C;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) e16)).booleanValue();
            }
            if (e16 != null) {
                num = Integer.valueOf(e16.getAction());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                ViewParent C2 = C();
                if (this.f273737f.isSingleLineModel) {
                    if (C2 != null) {
                        C2.requestDisallowInterceptTouchEvent(false);
                    }
                } else if (C2 != null) {
                    C2.requestDisallowInterceptTouchEvent(true);
                }
            } else if (((num != null && num.intValue() == 1) || (num != null && num.intValue() == 3)) && (C = C()) != null) {
                C.requestDisallowInterceptTouchEvent(false);
            }
            return super.onInterceptTouchEvent(e16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public void onMeasure(int widthSpec, int heightSpec) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(widthSpec), Integer.valueOf(heightSpec));
            } else if (this.f273737f.sizeHeight > 0 && View.MeasureSpec.getSize(heightSpec) > this.f273737f.sizeHeight) {
                super.onMeasure(widthSpec, View.MeasureSpec.makeMeasureSpec(this.f273737f.sizeHeight, Integer.MIN_VALUE));
            } else {
                super.onMeasure(widthSpec, heightSpec);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public void onSizeChanged(int w3, int h16, int oldw, int oldh) {
            ViewGroup.LayoutParams layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
                return;
            }
            super.onSizeChanged(w3, h16, oldw, oldh);
            AegisLogger.INSTANCE.d("Chat_Message|ChatFloatingMessageLayout", "MsgRecyclerView onSizeChanged w = [" + w3 + "], h = [" + h16 + "], oldw = [" + oldw + "], oldh = [" + oldh + ']');
            if (h16 >= this.f273737f.sizeHeight && (layoutParams = getLayoutParams()) != null) {
                ChatFloatingMessageLayout chatFloatingMessageLayout = this.f273737f;
                layoutParams.height = chatFloatingMessageLayout.sizeHeight;
                setLayoutParams(layoutParams);
                chatFloatingMessageLayout.linearLayoutManager.setAutoMeasureEnabled(false);
                setHasFixedSize(true);
            }
        }

        public /* synthetic */ MsgRecyclerView(ChatFloatingMessageLayout chatFloatingMessageLayout, Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(chatFloatingMessageLayout, context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, chatFloatingMessageLayout, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatFloatingMessageLayout(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            return;
        }
        iPatchRedirector.redirect((short) 25, (Object) this, (Object) ctx, (Object) attributeSet);
    }

    public /* synthetic */ ChatFloatingMessageLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatFloatingMessageLayout(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, ctx, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.isAnchor = true;
        this.chatId = "999L";
        this.datas = new ArrayList();
        this.showAtMsgId = "";
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        MsgRecyclerView msgRecyclerView = new MsgRecyclerView(this, context, null, 0, 6, null);
        this.recyclerView = msgRecyclerView;
        msgRecyclerView.setEnabled(true);
        msgRecyclerView.setOverScrollMode(2);
        msgRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qqlive.widget.chat.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean K;
                K = ChatFloatingMessageLayout.K(ChatFloatingMessageLayout.this, view, motionEvent);
                return K;
            }
        });
        msgRecyclerView.setRecycledViewPool(new com.tencent.mobileqq.qqlive.widget.chat.util.c());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(wi2.b.a(this), wi2.b.b(this));
        layoutParams.gravity = 80;
        Unit unit = Unit.INSTANCE;
        addView(msgRecyclerView, layoutParams);
        TextView textView = new TextView(getContext());
        this.newMsgView = textView;
        wi2.b.d(textView, 12.0f);
        textView.setPadding(wi2.c.b(10), 0, wi2.c.b(10), 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.widget.chat.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatFloatingMessageLayout.L(ChatFloatingMessageLayout.this, view);
            }
        });
        textView.setTextColor(Color.parseColor("#6666FF"));
        textView.setGravity(17);
        textView.setVisibility(8);
        wi2.d.d(textView, wi2.c.b(18), com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.f158017al3));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(wi2.b.b(this), wi2.c.b(26));
        layoutParams2.gravity = 83;
        layoutParams2.bottomMargin = wi2.c.b(14);
        layoutParams2.leftMargin = wi2.c.b(16);
        setMinimumWidth(wi2.c.b(80));
        addView(textView, layoutParams2);
        TextView textView2 = new TextView(getContext());
        this.newAtMsgView = textView2;
        wi2.b.d(textView2, 12.0f);
        textView2.setPadding(wi2.c.b(11), 0, wi2.c.b(11), 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.widget.chat.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatFloatingMessageLayout.M(ChatFloatingMessageLayout.this, view);
            }
        });
        textView2.setCompoundDrawablePadding(wi2.c.b(3));
        textView2.setTextColor(com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.black));
        textView2.setGravity(17);
        textView2.setVisibility(8);
        wi2.d.d(textView2, wi2.c.b(18), com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.f158017al3));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(wi2.b.b(this), wi2.c.b(26));
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = wi2.c.b(14);
        addView(textView2, layoutParams3);
        setOverScrollMode(2);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext());
        this.linearLayoutManager = safeLinearLayoutManager;
        safeLinearLayoutManager.setOrientation(1);
        this.recyclerView.setLayoutManager(this.linearLayoutManager);
        this.recyclerView.setItemViewCacheSize(20);
        RecyclerView.ItemAnimator itemAnimator = this.recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(0L);
            itemAnimator.setRemoveDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
        }
        this.recyclerView.addItemDecoration(new a());
        this.recyclerView.setAdapter(new RecyclerView.Adapter<d>() { // from class: com.tencent.mobileqq.qqlive.widget.chat.ChatFloatingMessageLayout.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatFloatingMessageLayout.this);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            /* renamed from: getItemCount */
            public int getNUM_BACKGOURND_ICON() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 4, (Object) this)).intValue();
                }
                return ChatFloatingMessageLayout.this.datas.size();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemViewType(int position) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 3, (Object) this, position)).intValue();
                }
                return com.tencent.mobileqq.qqlive.widget.chat.util.a.a(ChatFloatingMessageLayout.this.datas.get(position));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            /* renamed from: i0, reason: merged with bridge method [inline-methods] */
            public void onBindViewHolder(@NotNull d holder, int position) {
                com.tencent.mobileqq.qqlive.widget.chat.message.l lVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) holder, position);
                    return;
                }
                Intrinsics.checkNotNullParameter(holder, "holder");
                Object obj = ChatFloatingMessageLayout.this.datas.get(position);
                AegisLogger.INSTANCE.d("Chat_Message|ChatFloatingMessageLayout", "onBindViewHolder", "msg:" + obj);
                View view = holder.itemView;
                if (view instanceof ChatBaseText) {
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText");
                    ((ChatBaseText) view).setRoomId(ChatFloatingMessageLayout.this.roomId);
                    View view2 = holder.itemView;
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText");
                    ((ChatBaseText) view2).k();
                    View view3 = holder.itemView;
                    Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText");
                    ((ChatBaseText) view3).setSupportFunc(ChatFloatingMessageLayout.this.dataSupport, ChatFloatingMessageLayout.this.playFunc);
                }
                View view4 = holder.itemView;
                if (view4 instanceof ChatSysMsgFloatingItemView) {
                    if (obj instanceof com.tencent.mobileqq.qqlive.widget.chat.message.j) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.floating.ChatSysMsgFloatingItemView");
                        ((ChatSysMsgFloatingItemView) view4).m((com.tencent.mobileqq.qqlive.widget.chat.message.j) obj);
                    }
                } else if (view4 instanceof ChatTextMsgFloatingItemView) {
                    if (obj instanceof com.tencent.mobileqq.qqlive.widget.chat.message.e) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).G((com.tencent.mobileqq.qqlive.widget.chat.message.e) obj, ChatFloatingMessageLayout.this.ownerId);
                    } else if (obj instanceof com.tencent.mobileqq.qqlive.widget.chat.message.c) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.floating.ChatTextMsgFloatingItemView");
                        long j3 = ChatFloatingMessageLayout.this.ownerId;
                        final ChatFloatingMessageLayout chatFloatingMessageLayout = ChatFloatingMessageLayout.this;
                        ((ChatTextMsgFloatingItemView) view4).E((com.tencent.mobileqq.qqlive.widget.chat.message.c) obj, j3, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqlive.widget.chat.ChatFloatingMessageLayout$9$onBindViewHolder$1
                            static IPatchRedirector $redirector_;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) ChatFloatingMessageLayout.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                RecyclerView recyclerView;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                recyclerView = ChatFloatingMessageLayout.this.recyclerView;
                                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                                if (adapter != null) {
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        });
                    } else if (obj instanceof com.tencent.mobileqq.qqlive.widget.chat.message.b) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).D((com.tencent.mobileqq.qqlive.widget.chat.message.b) obj, ChatFloatingMessageLayout.this.ownerId);
                    } else if (obj instanceof com.tencent.mobileqq.qqlive.widget.chat.message.g) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).F((com.tencent.mobileqq.qqlive.widget.chat.message.g) obj, ChatFloatingMessageLayout.this.ownerId);
                    } else if (obj instanceof com.tencent.mobileqq.qqlive.widget.chat.message.j) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).J((com.tencent.mobileqq.qqlive.widget.chat.message.j) obj, ChatFloatingMessageLayout.this.ownerId);
                    } else if (obj instanceof LiveLocalMsg) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).H((LiveLocalMsg) obj, ChatFloatingMessageLayout.this.ownerId);
                    } else if (obj instanceof MessageOuterClass$AnchorRoomBulletScreenMsg) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).C((MessageOuterClass$AnchorRoomBulletScreenMsg) obj, ChatFloatingMessageLayout.this.ownerId);
                    } else if (obj instanceof n) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).K((n) obj, ChatFloatingMessageLayout.this.ownerId);
                    }
                } else if (view4 instanceof ChatAnnounceMsgFloatingItemView) {
                    Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.floating.ChatAnnounceMsgFloatingItemView");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage");
                    ((ChatAnnounceMsgFloatingItemView) view4).c((AnnouncePushMessage) obj, ChatFloatingMessageLayout.this.roomId, ChatFloatingMessageLayout.this.dataSupport, ChatFloatingMessageLayout.this.playFunc);
                } else if (view4 instanceof ChatTeamHintMsgItemView) {
                    if (obj instanceof com.tencent.mobileqq.qqlive.widget.chat.message.l) {
                        lVar = (com.tencent.mobileqq.qqlive.widget.chat.message.l) obj;
                    } else {
                        lVar = null;
                    }
                    if (lVar == null) {
                        return;
                    }
                    Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTeamHintMsgItemView");
                    final ChatFloatingMessageLayout chatFloatingMessageLayout2 = ChatFloatingMessageLayout.this;
                    ((ChatTeamHintMsgItemView) view4).o(lVar, new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.qqlive.widget.chat.ChatFloatingMessageLayout$9$onBindViewHolder$2
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) ChatFloatingMessageLayout.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                            invoke(l3.longValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(long j16) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ChatFloatingMessageLayout.q(ChatFloatingMessageLayout.this);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this, j16);
                            }
                        }
                    });
                } else if (view4 instanceof ChatGiftMsgFloatingItemView) {
                    Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.floating.ChatGiftMsgFloatingItemView");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.message.GiftScreenMsg");
                    ((ChatGiftMsgFloatingItemView) view4).y((com.tencent.mobileqq.qqlive.widget.chat.message.d) obj, ChatFloatingMessageLayout.this.ownerId);
                }
                if (ChatFloatingMessageLayout.this.isSingleLineModel) {
                    ViewGroup.LayoutParams layoutParams4 = holder.itemView.getLayoutParams();
                    if (layoutParams4 != null) {
                        layoutParams4.height = wi2.c.b(25);
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams5 = holder.itemView.getLayoutParams();
                    if (layoutParams5 != null) {
                        layoutParams5.height = -2;
                    }
                }
                if (position == ChatFloatingMessageLayout.this.datas.size() - 1) {
                    ChatFloatingMessageLayout.this.E();
                    ChatFloatingMessageLayout.this.D();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            @NotNull
            /* renamed from: j0, reason: merged with bridge method [inline-methods] */
            public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
                View chatTextMsgFloatingItemView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (d) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) parent, viewType);
                }
                Intrinsics.checkNotNullParameter(parent, "parent");
                AegisLogger.INSTANCE.d("Chat_Message|ChatFloatingMessageLayout", "onCreateViewHolder, viewType = [" + viewType + ']');
                ChatFloatingMessageLayout chatFloatingMessageLayout = ChatFloatingMessageLayout.this;
                if (viewType != 1 && viewType != 2 && viewType != 3) {
                    if (viewType != 5) {
                        if (viewType != 6) {
                            if (viewType != 11) {
                                switch (viewType) {
                                    case 100:
                                    case 101:
                                    case 102:
                                        Context context2 = ChatFloatingMessageLayout.this.getContext();
                                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                                        chatTextMsgFloatingItemView = new ChatTextMsgFloatingItemView(context2, ChatFloatingMessageLayout.this.isSingleLineModel);
                                        break;
                                    default:
                                        Context context3 = ChatFloatingMessageLayout.this.getContext();
                                        Intrinsics.checkNotNullExpressionValue(context3, "context");
                                        chatTextMsgFloatingItemView = new ChatTextMsgFloatingItemView(context3, ChatFloatingMessageLayout.this.isSingleLineModel);
                                        break;
                                }
                            } else {
                                Context context4 = ChatFloatingMessageLayout.this.getContext();
                                Intrinsics.checkNotNullExpressionValue(context4, "context");
                                chatTextMsgFloatingItemView = new ChatTextMsgFloatingItemView(context4, ChatFloatingMessageLayout.this.isSingleLineModel);
                            }
                        }
                    } else {
                        chatTextMsgFloatingItemView = new ChatGiftMsgFloatingItemView(ChatFloatingMessageLayout.this.getContext());
                    }
                    return new d(chatFloatingMessageLayout, chatTextMsgFloatingItemView);
                }
                Context context5 = ChatFloatingMessageLayout.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "context");
                chatTextMsgFloatingItemView = new ChatTextMsgFloatingItemView(context5, ChatFloatingMessageLayout.this.isSingleLineModel);
                return new d(chatFloatingMessageLayout, chatTextMsgFloatingItemView);
            }
        });
    }
}
