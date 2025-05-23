package com.tencent.qqnt.chats.core.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.adapter.holder.p;
import com.tencent.qqnt.chats.core.adapter.itemdata.i;
import com.tencent.qqnt.chats.core.ui.highlight.HighLightUtilsKt;
import com.tencent.qqnt.chats.core.ui.o;
import com.tencent.theme.SkinEngine;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u0094\u00012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u00012\u00020\u0004:\u0002\u0095\u0001B\u0010\u0012\u0006\u0010]\u001a\u00020V\u00a2\u0006\u0005\b\u0093\u0001\u0010\\J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001e\u0010\u0014\u001a\u00020\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J,\u0010\u0018\u001a\u00020\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0016\u0010\u0019\u001a\u00020\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0016\u0010\u001a\u001a\u00020\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0016\u0010\u001b\u001a\u00020\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J*\u0010\u001f\u001a\u00020\u00132\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\"\u0010 \u001a\u00020\u00132\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010 \u001a\u00020\u00132\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0016J \u0010!\u001a\u00020\u00132\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0006\u0010\"\u001a\u00020\u000eJ\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005J\u0016\u0010'\u001a\u00020\u00132\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u000eJ\u0016\u0010(\u001a\u00020\u00132\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u000eJ\u0016\u0010)\u001a\u00020\u00132\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u000eJ \u0010,\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010+\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u000eJ\u0014\u0010/\u001a\u00020\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020$0\u0005J\u001a\u00103\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\t00J\u0016\u00108\u001a\u00020\u00132\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u000206J2\u0010?\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;0>2\u0006\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020;J\u000e\u0010B\u001a\u00020\u00132\u0006\u0010A\u001a\u00020@J\u000e\u0010D\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\tJ\u000e\u0010E\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\tJ\u0010\u0010F\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0014J\u0010\u0010G\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010I\u001a\u00020\u00132\b\u0010H\u001a\u0004\u0018\u00010\u0016J4\u0010K\u001a\u00020\u00132\u0006\u0010J\u001a\u0002062\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\t002\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0007J\u0006\u0010L\u001a\u00020\tJ\b\u0010M\u001a\u00020\u0013H\u0016J\u0006\u0010N\u001a\u00020\u000eJ\u0010\u0010P\u001a\u00020O2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010R\u001a\u0004\u0018\u00010\u00022\u0006\u0010Q\u001a\u00020\u000eJ\u0006\u0010S\u001a\u00020\u000eJ\u000e\u0010U\u001a\u00020\u00132\u0006\u0010T\u001a\u00020\tR\"\u0010]\u001a\u00020V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010c\u001a\u0012\u0012\u0004\u0012\u00020_0^j\b\u0012\u0004\u0012\u00020_``8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR0\u0010h\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020$0dj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020$`e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u001e\u0010k\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010n\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010t\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010uR\u0016\u0010x\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010uR\u0016\u0010z\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010uR\u0016\u0010|\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010sR)\u0010\u0084\u0001\u001a\u0004\u0018\u00010}8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R+\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bM\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R\"\u0010\u008f\u0001\u001a\u000b\u0012\u0004\u0012\u000206\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001d\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\u00a8\u0006\u0096\u0001"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "Lcom/tencent/qqnt/chats/core/adapter/holder/b;", "Lcom/tencent/qqnt/chats/api/f;", "", "newList", "F0", "list", "", "C0", "v0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "L0", "holder", "position", "", "J0", "", "", "payloads", "K0", "M0", "N0", "O0", "isGuild", "Ljava/lang/Runnable;", "commitCallback", "c1", "submitList", "S0", "A0", "z0", "Landroid/view/View;", "view", "level", "q0", "h1", "R0", "type", "submit", "V0", "Q0", "views", "g1", "Lkotlin/Function1;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "predicate", "u0", "Lcom/tencent/qqnt/chats/core/adapter/h;", "listener", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Y0", "viewA", "viewB", "", HippyTKDListViewAdapter.X, "y", "Lkotlin/Pair;", "r0", "Lcom/tencent/qqnt/chats/core/itempart/d;", "itemPartCollect", "b1", "show", "E0", "D0", "x0", "getItemViewType", "payload", "H0", "rv", "I0", "B0", "N", "s0", "", "getItemId", com.tencent.luggage.wxa.c8.c.G, "y0", "getHeaderCount", "isShowHeader", "X0", "Lcom/tencent/qqnt/chats/core/data/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/chats/core/data/a;", "getMBuilder", "()Lcom/tencent/qqnt/chats/core/data/a;", "setMBuilder", "(Lcom/tencent/qqnt/chats/core/data/a;)V", "mBuilder", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/a;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "bannerHeaderItems", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "D", "Ljava/util/HashMap;", "fixedHeaderItemView", "E", "Ljava/util/List;", "showList", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chats/core/adapter/h;", "mOnRecentContactItemListener", "G", "Lcom/tencent/qqnt/chats/core/itempart/d;", "mItemPartCollect", "H", "I", "mStyle", "Z", "needShowSearchBar", "J", "needBannerHeaderItems", "K", "isShowHeaderEnabled", "L", "firstPos", "Lcom/tencent/qqnt/chats/core/ui/o;", "M", "Lcom/tencent/qqnt/chats/core/ui/o;", "getControlHelper", "()Lcom/tencent/qqnt/chats/core/ui/o;", "T0", "(Lcom/tencent/qqnt/chats/core/ui/o;)V", "controlHelper", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "t0", "()Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "U0", "(Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;)V", "dragHost", "Lmqq/util/WeakReference;", "P", "Lmqq/util/WeakReference;", "weakRecyclerView", "w0", "()Ljava/util/List;", "headItems", "<init>", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class ChatsListAdapter extends ListAdapter<com.tencent.qqnt.chats.core.adapter.itemdata.b, com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b>> implements com.tencent.qqnt.chats.api.f {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int R;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.qqnt.chats.core.adapter.itemdata.a> bannerHeaderItems;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Integer, View> fixedHeaderItemView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> showList;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private h mOnRecentContactItemListener;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.core.itempart.d mItemPartCollect;

    /* renamed from: H, reason: from kotlin metadata */
    private int mStyle;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean needShowSearchBar;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean needBannerHeaderItems;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isShowHeaderEnabled;

    /* renamed from: L, reason: from kotlin metadata */
    private int firstPos;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private o controlHelper;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private QUIBadgeDragLayout dragHost;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private WeakReference<RecyclerView> weakRecyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.chats.core.data.a mBuilder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter$a;", "", "", "BANNER_HEIGHT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.adapter.ChatsListAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 50)) {
            redirector.redirect((short) 50);
        } else {
            INSTANCE = new Companion(null);
            R = ScreenUtil.dip2px(48.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatsListAdapter(@NotNull com.tencent.qqnt.chats.core.data.a mBuilder) {
        super(a.f354449a);
        Intrinsics.checkNotNullParameter(mBuilder, "mBuilder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mBuilder);
            return;
        }
        this.mBuilder = mBuilder;
        this.bannerHeaderItems = new ArrayList<>();
        this.fixedHeaderItemView = new HashMap<>();
        this.mStyle = this.mBuilder.d();
        this.needShowSearchBar = this.mBuilder.h();
        this.needBannerHeaderItems = this.mBuilder.f();
        this.isShowHeaderEnabled = true;
        this.firstPos = -1;
    }

    private final boolean C0(List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list) {
        boolean z16;
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar;
        List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            com.tencent.qqnt.chats.core.adapter.itemdata.b bVar = list.get(0);
            Integer num = null;
            if (bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) bVar;
            } else {
                gVar = null;
            }
            if (gVar != null) {
                num = Integer.valueOf(gVar.n());
            }
            if (num != null && num.intValue() == 104) {
                return true;
            }
            if (num != null && num.intValue() == 119) {
                return true;
            }
        }
        return false;
    }

    private final List<com.tencent.qqnt.chats.core.adapter.itemdata.b> F0(List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> newList) {
        boolean z16;
        List<com.tencent.qqnt.chats.core.adapter.itemdata.b> plus;
        boolean z17;
        if (v0(newList) && !C0(newList)) {
            z16 = true;
        } else {
            z16 = false;
        }
        int size = w0().size();
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.qqnt.chats.core.adapter.itemdata.b bVar = w0().get(i3);
            boolean z18 = bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.a;
            if (z18) {
                z17 = ((com.tencent.qqnt.chats.core.adapter.itemdata.a) bVar).g();
            } else if (bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.c) {
                z17 = ((com.tencent.qqnt.chats.core.adapter.itemdata.c) bVar).f();
            } else {
                z17 = z16;
            }
            if (z17 != z16) {
                if (z18) {
                    com.tencent.qqnt.chats.core.adapter.itemdata.a aVar = (com.tencent.qqnt.chats.core.adapter.itemdata.a) bVar;
                    aVar.i(z16);
                    aVar.h(true);
                } else if (bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.c) {
                    com.tencent.qqnt.chats.core.adapter.itemdata.c cVar = (com.tencent.qqnt.chats.core.adapter.itemdata.c) bVar;
                    cVar.h(z16);
                    cVar.g(true);
                }
            }
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) w0(), (Iterable) newList);
        return plus;
    }

    public static /* synthetic */ void W0(ChatsListAdapter chatsListAdapter, int i3, View view, boolean z16, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 4) != 0) {
                z16 = true;
            }
            chatsListAdapter.V0(i3, view, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFixedHeaderView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(ChatsListAdapter this$0, boolean z16, int i3, QUIBadgeDragLayout from) {
        View dragView;
        Integer num;
        h hVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(from, "from");
        if (!z16 || (dragView = from.getDragView()) == null) {
            return;
        }
        Object tag = dragView.getTag(R.id.f70883mn);
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = null;
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        Object tag2 = dragView.getTag(R.id.f70873mm);
        if (tag2 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
            gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) tag2;
        }
        if (num != null && gVar != null && (hVar = this$0.mOnRecentContactItemListener) != null) {
            hVar.f(num.intValue(), gVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(ChatsListAdapter this$0, QUIBadgeDragLayout dragLayout, float f16, float f17) {
        RecyclerView recyclerView;
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar;
        RecentContactItemHolder recentContactItemHolder;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View dragView = dragLayout.getDragView();
        if (dragView == null) {
            return;
        }
        QLog.e("ChatsListAdapter", 1, "[singleClick] start");
        WeakReference<RecyclerView> weakReference = this$0.weakRecyclerView;
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar2 = null;
        if (weakReference != null) {
            recyclerView = weakReference.get();
        } else {
            recyclerView = null;
        }
        if (recyclerView != null) {
            Object tag = dragView.getTag(R.id.f70873mm);
            if (tag instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) tag;
            } else {
                gVar = null;
            }
            if (gVar == null) {
                QLog.e("ChatsListAdapter", 1, "[singleClick] is not recent reddot");
                return;
            }
            Intrinsics.checkNotNullExpressionValue(dragLayout, "dragLayout");
            Pair<Float, Float> r06 = this$0.r0(dragLayout, recyclerView, f16, f17);
            View findChildViewUnder = recyclerView.findChildViewUnder(r06.getFirst().floatValue(), r06.getSecond().floatValue());
            Object[] objArr = new Object[2];
            boolean z16 = false;
            objArr[0] = "[singleClick] childView ";
            if (findChildViewUnder != null) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            QLog.e("ChatsListAdapter", 1, objArr);
            if (findChildViewUnder != null) {
                QLog.e("ChatsListAdapter", 1, "[singleClick] viewHolder ");
                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(findChildViewUnder);
                if (childViewHolder == null) {
                    return;
                }
                if (childViewHolder instanceof RecentContactItemHolder) {
                    recentContactItemHolder = (RecentContactItemHolder) childViewHolder;
                } else {
                    recentContactItemHolder = null;
                }
                QLog.e("ChatsListAdapter", 1, "[singleClick] pos ");
                if (recentContactItemHolder != null) {
                    int adapterPosition = recentContactItemHolder.getAdapterPosition();
                    QLog.e("ChatsListAdapter", 1, "[singleClick] item ");
                    com.tencent.qqnt.chats.core.adapter.itemdata.b z17 = recentContactItemHolder.z();
                    if (z17 == null) {
                        return;
                    }
                    if (z17 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                        gVar2 = (com.tencent.qqnt.chats.core.adapter.itemdata.g) z17;
                    }
                    QLog.e("ChatsListAdapter", 1, "[singleClick] binding ");
                    RecentContactItemBinding y16 = recentContactItemHolder.y();
                    if (y16 != null && gVar2 != null) {
                        if (this$0.mStyle != 18) {
                            HighLightUtilsKt.d(y16.b(), y16.p());
                        }
                        QLog.e("ChatsListAdapter", 1, "[singleClick] suc ");
                        h hVar = this$0.mOnRecentContactItemListener;
                        if (hVar != null) {
                            hVar.a(adapterPosition, gVar2, y16);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(Runnable runnable, ChatsListAdapter this$0, long j3) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (runnable != null) {
            runnable.run();
        }
        if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
            List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list = this$0.showList;
            if (list != null) {
                num = Integer.valueOf(list.size());
            } else {
                num = null;
            }
            QLog.i("ChatsListAdapter", 1, "submitData size: " + num + " diff cost: " + (System.currentTimeMillis() - j3) + ",needBannerHeaderItems: " + this$0.needBannerHeaderItems);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(Runnable runnable, ChatsListAdapter this$0, long j3) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (runnable != null) {
            runnable.run();
        }
        if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
            List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list = this$0.showList;
            if (list != null) {
                num = Integer.valueOf(list.size());
            } else {
                num = null;
            }
            QLog.i("ChatsListAdapter", 1, "submitList2 size: " + num + " diff cost: " + (System.currentTimeMillis() - j3) + " ,needBannerHeaderItems: " + this$0.needBannerHeaderItems);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(ChatsListAdapter this$0, long j3) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
            List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list = this$0.showList;
            if (list != null) {
                num = Integer.valueOf(list.size());
            } else {
                num = null;
            }
            QLog.i("ChatsListAdapter", 1, "submitList1 size: " + num + " diff cost: " + (System.currentTimeMillis() - j3) + " ,needBannerHeaderItems: " + this$0.needBannerHeaderItems);
        }
    }

    private final boolean v0(List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list) {
        boolean z16;
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar;
        List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.b bVar = list.get(0);
        if (bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
            gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) bVar;
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return false;
        }
        return gVar.H();
    }

    private final List<com.tencent.qqnt.chats.core.adapter.itemdata.b> w0() {
        ArrayList<com.tencent.qqnt.chats.core.adapter.itemdata.a> arrayList;
        List<com.tencent.qqnt.chats.core.adapter.itemdata.b> plus;
        if (!this.isShowHeaderEnabled) {
            return new ArrayList();
        }
        ArrayList arrayList2 = new ArrayList();
        if (this.needShowSearchBar) {
            arrayList2.add(i.f354591c);
        }
        if (this.fixedHeaderItemView.containsKey(-4)) {
            arrayList2.add(com.tencent.qqnt.chats.core.adapter.itemdata.c.f354523c);
        }
        if (this.mBuilder.f()) {
            arrayList = this.bannerHeaderItems;
        } else {
            arrayList = new ArrayList<>();
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList);
        return plus;
    }

    public final int A0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list = this.showList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final boolean B0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list = this.showList;
        if (list != null && (!list.isEmpty())) {
            com.tencent.qqnt.chats.core.adapter.itemdata.b bVar = list.get(0);
            if (bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                return ((com.tencent.qqnt.chats.core.adapter.itemdata.g) bVar).H();
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D0(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, show);
        } else {
            if (this.needBannerHeaderItems == show) {
                return;
            }
            this.needBannerHeaderItems = show;
            submitList(this.showList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E0(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, show);
        } else {
            if (this.needShowSearchBar == show) {
                return;
            }
            this.needShowSearchBar = show;
            submitList(this.showList);
        }
    }

    public final void H0(@Nullable Object payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, payload);
            return;
        }
        List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list = this.showList;
        if (list != null) {
            notifyItemRangeChanged(w0().size(), list.size(), payload);
        }
    }

    @UiThread
    public final void I0(@NotNull RecyclerView rv5, @NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> predicate, @Nullable List<Object> payloads) {
        RecentContactItemHolder recentContactItemHolder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, rv5, predicate, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(rv5, "rv");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int u06 = u0(predicate);
        if (u06 == -1) {
            return;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = rv5.findViewHolderForAdapterPosition(u06);
        if (findViewHolderForAdapterPosition instanceof RecentContactItemHolder) {
            recentContactItemHolder = (RecentContactItemHolder) findViewHolderForAdapterPosition;
        } else {
            recentContactItemHolder = null;
        }
        if (recentContactItemHolder != null) {
            if (payloads == null) {
                onBindViewHolder(recentContactItemHolder, u06);
            } else {
                onBindViewHolder(recentContactItemHolder, u06, payloads);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        try {
            holder.l(getItem(position));
        } catch (Throwable th5) {
            if (!QLog.isDevelopLevel() && !QLog.isDebugVersion()) {
                QLog.e("ChatsListAdapter", 1, "[onBindViewHolder] throw:", th5);
                return;
            }
            throw th5;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        try {
            holder.m(getItem(position), payloads);
        } catch (Throwable th5) {
            if (!QLog.isDevelopLevel() && !QLog.isDebugVersion()) {
                QLog.e("ChatsListAdapter", 1, "[onBindViewHolder-payload] throw:", th5);
                return;
            }
            throw th5;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> onCreateViewHolder(@NotNull final ViewGroup parent, final int viewType) {
        com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> cVar;
        ViewParent viewParent;
        ViewGroup viewGroup;
        com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> cVar2;
        ViewParent viewParent2;
        ViewGroup viewGroup2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.chats.core.adapter.holder.b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewGroup viewGroup3 = null;
        if (viewType != -4) {
            if (viewType != -3) {
                if (viewType != -2) {
                    if (viewType != -1) {
                        cVar = (com.tencent.qqnt.chats.core.adapter.holder.b) com.tencent.qqnt.chats.utils.h.f355549a.e("createVH", !com.tencent.qqnt.util.b.f362976b.isPublicVersion(), new Function0<com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b>>(viewType, parent) { // from class: com.tencent.qqnt.chats.core.adapter.ChatsListAdapter$onCreateViewHolder$vh$1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ ViewGroup $parent;
                            final /* synthetic */ int $viewType;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$viewType = viewType;
                                this.$parent = parent;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, ChatsListAdapter.this, Integer.valueOf(viewType), parent);
                                }
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> invoke() {
                                int i3;
                                com.tencent.qqnt.chats.core.itempart.d dVar;
                                h hVar;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (com.tencent.qqnt.chats.core.adapter.holder.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                                com.tencent.qqnt.chats.core.adapter.factory.c cVar3 = com.tencent.qqnt.chats.core.adapter.factory.c.f354467a;
                                i3 = ChatsListAdapter.this.mStyle;
                                com.tencent.qqnt.chats.core.adapter.builder.a<? extends com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b>> b16 = cVar3.b(i3, this.$viewType);
                                ViewGroup viewGroup4 = this.$parent;
                                int i16 = this.$viewType;
                                dVar = ChatsListAdapter.this.mItemPartCollect;
                                QUIBadgeDragLayout t06 = ChatsListAdapter.this.t0();
                                hVar = ChatsListAdapter.this.mOnRecentContactItemListener;
                                return b16.a(viewGroup4, i16, dVar, t06, hVar);
                            }
                        });
                    } else {
                        if (this.fixedHeaderItemView.containsKey(Integer.valueOf(viewType))) {
                            View view = this.fixedHeaderItemView.get(Integer.valueOf(viewType));
                            if (view != null) {
                                viewParent2 = view.getParent();
                            } else {
                                viewParent2 = null;
                            }
                            if (viewParent2 instanceof ViewGroup) {
                                viewGroup2 = (ViewGroup) viewParent2;
                            } else {
                                viewGroup2 = null;
                            }
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(view);
                            }
                            Intrinsics.checkNotNull(view);
                            cVar2 = new com.tencent.qqnt.chats.core.adapter.holder.g(view);
                        } else {
                            pw3.c g16 = pw3.c.g(xv3.a.a(parent), parent, false);
                            Intrinsics.checkNotNullExpressionValue(g16, "inflate(parent.layoutInflater, parent, false)");
                            cVar2 = new p(g16, this.mOnRecentContactItemListener);
                        }
                        cVar = cVar2;
                    }
                } else {
                    FrameLayout frameLayout = new FrameLayout(parent.getContext());
                    frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    frameLayout.setClipChildren(true);
                    cVar = new com.tencent.qqnt.chats.core.adapter.holder.a(frameLayout);
                }
            } else {
                View c16 = this.mBuilder.c();
                if (c16 == null) {
                    QUIEmptyState.Builder builder = new QUIEmptyState.Builder(parent.getContext());
                    builder.setImageType(this.mBuilder.a());
                    builder.setHalfScreenState(false);
                    builder.setThemeType(0);
                    builder.setBackgroundColorType(0);
                    QUIEmptyState build = builder.build();
                    if (build.getLayoutParams() == null) {
                        build.setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
                    } else {
                        build.getLayoutParams().width = -1;
                    }
                    if (build.getLayoutParams() == null) {
                        build.setLayoutParams(new ViewGroup.LayoutParams(0, -1));
                    } else {
                        build.getLayoutParams().height = -1;
                    }
                    cVar2 = new com.tencent.qqnt.chats.core.adapter.holder.e(build);
                    cVar = cVar2;
                } else {
                    cVar = new com.tencent.qqnt.chats.core.adapter.holder.e(c16);
                }
            }
        } else if (this.fixedHeaderItemView.containsKey(Integer.valueOf(viewType))) {
            View view2 = this.fixedHeaderItemView.get(Integer.valueOf(viewType));
            if (view2 != null) {
                viewParent = view2.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = (ViewGroup) viewParent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view2);
            }
            Intrinsics.checkNotNull(view2);
            cVar2 = new com.tencent.qqnt.chats.core.adapter.holder.c(view2);
            cVar = cVar2;
        } else if (!com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
            FrameLayout frameLayout2 = new FrameLayout(parent.getContext());
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            cVar = new com.tencent.qqnt.chats.core.adapter.holder.c(frameLayout2);
        } else {
            throw new RuntimeException("card container data illegal!");
        }
        if (cVar.itemView.getParent() != null) {
            QLog.d("ChatsListAdapter", 1, viewType + " create a view, but attach: " + cVar);
            try {
                View view3 = cVar.itemView;
                Intrinsics.checkNotNullExpressionValue(view3, "vh.itemView");
                ViewParent parent2 = view3.getParent();
                if (parent2 instanceof ViewGroup) {
                    viewGroup3 = (ViewGroup) parent2;
                }
                if (viewGroup3 != null) {
                    viewGroup3.endViewTransition(view3);
                    view3.clearAnimation();
                }
            } catch (Throwable th5) {
                QLog.i("ChatsListAdapter", 1, "failed to remove from parent, exc=" + th5);
            }
            View view4 = cVar.itemView;
            Intrinsics.checkNotNullExpressionValue(view4, "vh.itemView");
            ab.c(view4);
        }
        if (cVar.itemView.getParent() == null) {
            return cVar;
        }
        throw new IllegalStateException("invalid view holder, builder=" + this.mBuilder.e() + " viewType=" + viewType + " vh=" + cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull final com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        com.tencent.qqnt.chats.utils.h.f(com.tencent.qqnt.chats.utils.h.f355549a, "ChatsListAdapter onViewDetachedFromWindow" + holder.hashCode(), false, new Function0<Unit>(holder) { // from class: com.tencent.qqnt.chats.core.adapter.ChatsListAdapter$onViewAttachedToWindow$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> $holder;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$holder = holder;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) holder);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    this.$holder.onViewAttachedToWindow();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 2, null);
    }

    @Override // com.tencent.qqnt.chats.api.f
    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        Iterator<T> it = this.bannerHeaderItems.iterator();
        while (it.hasNext()) {
            SkinEngine.invalidateAll(((com.tencent.qqnt.chats.core.adapter.itemdata.a) it.next()).f());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(@NotNull final com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        com.tencent.qqnt.chats.utils.h.f(com.tencent.qqnt.chats.utils.h.f355549a, "ChatsListAdapter onViewDetachedFromWindow" + holder.hashCode(), false, new Function0<Unit>(holder) { // from class: com.tencent.qqnt.chats.core.adapter.ChatsListAdapter$onViewDetachedFromWindow$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> $holder;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$holder = holder;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) holder);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    this.$holder.onViewDetachedFromWindow();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 2, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NotNull final com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        com.tencent.qqnt.chats.utils.h.f(com.tencent.qqnt.chats.utils.h.f355549a, "ChatsListAdapteronViewRecycled", false, new Function0<Unit>(holder) { // from class: com.tencent.qqnt.chats.core.adapter.ChatsListAdapter$onViewRecycled$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> $holder;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$holder = holder;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) holder);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    this.$holder.onRecycled();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q0(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, type);
            return;
        }
        this.fixedHeaderItemView.remove(Integer.valueOf(type));
        if (type == -4) {
            submitList(this.showList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R0(@NotNull View view, int level) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view, level);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Iterator<T> it = this.bannerHeaderItems.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((com.tencent.qqnt.chats.core.adapter.itemdata.a) obj).f(), view)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.a aVar = (com.tencent.qqnt.chats.core.adapter.itemdata.a) obj;
        if (aVar != null) {
            this.bannerHeaderItems.remove(aVar);
            submitList(this.showList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void S0(@Nullable List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list, boolean isGuild) {
        Object lastOrNull;
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar;
        o oVar;
        List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> plus;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, list, Boolean.valueOf(isGuild));
            return;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list);
        if (lastOrNull instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
            gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) lastOrNull;
        } else {
            gVar = null;
        }
        if (isGuild && GuildLayoutManager.f354256a.y()) {
            if (gVar == null || !gVar.E()) {
                z16 = false;
            }
            if (!z16) {
                plus = CollectionsKt___CollectionsKt.plus((Collection<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b>) ((Collection<? extends Object>) list), com.tencent.qqnt.chats.core.adapter.itemdata.e.f354527a.a());
                this.showList = plus;
                oVar = this.controlHelper;
                if (oVar == null) {
                    oVar.g(this.showList);
                    return;
                }
                return;
            }
        }
        this.showList = list;
        oVar = this.controlHelper;
        if (oVar == null) {
        }
    }

    public final void T0(@Nullable o oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) oVar);
        } else {
            this.controlHelper = oVar;
        }
    }

    public final void U0(@Nullable QUIBadgeDragLayout qUIBadgeDragLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qUIBadgeDragLayout);
        } else {
            this.dragHost = qUIBadgeDragLayout;
        }
    }

    public final void V0(int type, @NotNull View view, boolean submit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Integer.valueOf(type), view, Boolean.valueOf(submit));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        this.fixedHeaderItemView.put(Integer.valueOf(type), view);
        if (submit && type == -4) {
            submitList(this.showList);
        }
    }

    public final void X0(boolean isShowHeader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, isShowHeader);
        } else {
            this.isShowHeaderEnabled = isShowHeader;
        }
    }

    public final void Y0(@NotNull h listener, @NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) listener, (Object) recyclerView);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.mOnRecentContactItemListener = listener;
        this.weakRecyclerView = new WeakReference<>(recyclerView);
        QUIBadgeDragLayout qUIBadgeDragLayout = this.dragHost;
        if (qUIBadgeDragLayout != null) {
            qUIBadgeDragLayout.addOnDragModeChangeListener(new QUIBadgeDragLayout.OnDragModeChangedListener() { // from class: com.tencent.qqnt.chats.core.adapter.d
                @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
                public final void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout2) {
                    ChatsListAdapter.Z0(ChatsListAdapter.this, z16, i3, qUIBadgeDragLayout2);
                }
            }, false);
        }
        QUIBadgeDragLayout qUIBadgeDragLayout2 = this.dragHost;
        if (qUIBadgeDragLayout2 != null) {
            qUIBadgeDragLayout2.setOnDragSingleClick(new QUIBadgeDragLayout.OnDragSingleClick() { // from class: com.tencent.qqnt.chats.core.adapter.e
                @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragSingleClick
                public final void onClick(QUIBadgeDragLayout qUIBadgeDragLayout3, float f16, float f17) {
                    ChatsListAdapter.a1(ChatsListAdapter.this, qUIBadgeDragLayout3, f16, f17);
                }
            });
        }
    }

    public final void b1(@NotNull com.tencent.qqnt.chats.core.itempart.d itemPartCollect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) itemPartCollect);
        } else {
            Intrinsics.checkNotNullParameter(itemPartCollect, "itemPartCollect");
            this.mItemPartCollect = itemPartCollect;
        }
    }

    public final void c1(@Nullable List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list, boolean isGuild, @Nullable final Runnable commitCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, list, Boolean.valueOf(isGuild), commitCallback);
            return;
        }
        S0(list, isGuild);
        List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list2 = this.showList;
        if (list2 == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        super.submitList(F0(list2), new Runnable() { // from class: com.tencent.qqnt.chats.core.adapter.f
            @Override // java.lang.Runnable
            public final void run() {
                ChatsListAdapter.d1(commitCallback, this, currentTimeMillis);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g1(@NotNull List<? extends View> views) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) views);
            return;
        }
        Intrinsics.checkNotNullParameter(views, "views");
        this.bannerHeaderItems.clear();
        ArrayList<com.tencent.qqnt.chats.core.adapter.itemdata.a> arrayList = this.bannerHeaderItems;
        List<? extends View> list = views;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(new com.tencent.qqnt.chats.core.adapter.itemdata.a((View) it.next()));
        }
        arrayList.addAll(arrayList2);
        submitList(this.showList);
    }

    public final int getHeaderCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Integer) iPatchRedirector.redirect((short) 48, (Object) this)).intValue();
        }
        return w0().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Long) iPatchRedirector.redirect((short) 46, (Object) this, position)).longValue();
        }
        return getItem(position).id();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this, position)).intValue();
        }
        return com.tencent.qqnt.chats.core.adapter.factory.c.f354467a.c(this.mStyle).c(getItem(position));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h1(@NotNull View view, int level) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) view, level);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Iterator<com.tencent.qqnt.chats.core.adapter.itemdata.a> it = this.bannerHeaderItems.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().f(), view)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        this.bannerHeaderItems.remove(i3);
        this.bannerHeaderItems.add(i3, new com.tencent.qqnt.chats.core.adapter.itemdata.a(view));
        submitList(this.showList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q0(@NotNull View view, int level) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view, level);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Iterator<T> it = this.bannerHeaderItems.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((com.tencent.qqnt.chats.core.adapter.itemdata.a) obj).f(), view)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((com.tencent.qqnt.chats.core.adapter.itemdata.a) obj) == null) {
            this.bannerHeaderItems.add(new com.tencent.qqnt.chats.core.adapter.itemdata.a(view));
            submitList(this.showList);
        }
    }

    @NotNull
    public final Pair<Float, Float> r0(@NotNull View viewA, @NotNull View viewB, float x16, float y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (Pair) iPatchRedirector.redirect((short) 33, this, viewA, viewB, Float.valueOf(x16), Float.valueOf(y16));
        }
        Intrinsics.checkNotNullParameter(viewA, "viewA");
        Intrinsics.checkNotNullParameter(viewB, "viewB");
        viewA.getLocationOnScreen(new int[2]);
        viewB.getLocationOnScreen(new int[2]);
        return new Pair<>(Float.valueOf(x16 + (r3[0] - r0[0])), Float.valueOf(y16 + (r3[1] - r0[1])));
    }

    public final int s0() {
        int i3;
        int i16;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        int i17 = 0;
        if (this.needBannerHeaderItems) {
            Iterator<T> it = this.bannerHeaderItems.iterator();
            i3 = 0;
            while (it.hasNext()) {
                i3 += ((com.tencent.qqnt.chats.core.adapter.itemdata.a) it.next()).f().getHeight();
            }
        } else {
            i3 = 0;
        }
        if (this.needShowSearchBar && (view = this.fixedHeaderItemView.get(-1)) != null) {
            i16 = view.getHeight();
        } else {
            i16 = 0;
        }
        int i18 = i3 + i16;
        View view2 = this.fixedHeaderItemView.get(-4);
        if (view2 != null) {
            i17 = view2.getHeight();
        }
        return i18 + i17;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(@Nullable List<com.tencent.qqnt.chats.core.adapter.itemdata.b> list, @Nullable final Runnable commitCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) list, (Object) commitCallback);
            return;
        }
        S0(list, false);
        List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list2 = this.showList;
        if (list2 == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        super.submitList(F0(list2), new Runnable() { // from class: com.tencent.qqnt.chats.core.adapter.c
            @Override // java.lang.Runnable
            public final void run() {
                ChatsListAdapter.e1(commitCallback, this, currentTimeMillis);
            }
        });
    }

    @Nullable
    public final QUIBadgeDragLayout t0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QUIBadgeDragLayout) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.dragHost;
    }

    public final int u0(@NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> predicate) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this, (Object) predicate)).intValue();
        }
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List<com.tencent.qqnt.chats.core.adapter.itemdata.b> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "currentList");
        int i3 = 0;
        for (com.tencent.qqnt.chats.core.adapter.itemdata.b bVar : currentList) {
            if ((bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) && predicate.invoke(bVar).booleanValue()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3++;
            } else {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.ListAdapter
    @NotNull
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.chats.core.adapter.itemdata.b getItem(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (com.tencent.qqnt.chats.core.adapter.itemdata.b) iPatchRedirector.redirect((short) 38, (Object) this, position);
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.b item = (com.tencent.qqnt.chats.core.adapter.itemdata.b) super.getItem(position);
        if (item instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
            ((com.tencent.qqnt.chats.core.adapter.itemdata.g) item).N(this.mBuilder.e());
        }
        Intrinsics.checkNotNullExpressionValue(item, "item");
        return item;
    }

    @Nullable
    public final com.tencent.qqnt.chats.core.adapter.itemdata.b y0(int pos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (com.tencent.qqnt.chats.core.adapter.itemdata.b) iPatchRedirector.redirect((short) 47, (Object) this, pos);
        }
        int size = w0().size() + pos;
        boolean z16 = false;
        if (size >= 0 && size < getCurrentList().size()) {
            z16 = true;
        }
        if (z16) {
            return getCurrentList().get(size);
        }
        return null;
    }

    @Nullable
    public final List<com.tencent.qqnt.chats.core.adapter.itemdata.b> z0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (List) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.showList;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(@Nullable List<com.tencent.qqnt.chats.core.adapter.itemdata.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) list);
            return;
        }
        S0(list, false);
        final long currentTimeMillis = System.currentTimeMillis();
        List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list2 = this.showList;
        if (list2 == null) {
            return;
        }
        super.submitList(F0(list2), new Runnable() { // from class: com.tencent.qqnt.chats.core.adapter.b
            @Override // java.lang.Runnable
            public final void run() {
                ChatsListAdapter.f1(ChatsListAdapter.this, currentTimeMillis);
            }
        });
    }
}
