package com.tencent.mobileqq.wink.publish.part;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart;
import com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishSettingItemState;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 72\u00020\u0001:\u000489:;B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#R#\u0010*\u001a\n &*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u001c\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u00103\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishAtFriendPart;", "Lcom/tencent/mobileqq/wink/publish/part/j;", "", "W9", "T9", "", "B9", "Landroid/view/View;", "mRootView", "onInitView", "Landroid/view/ViewStub;", "d", "Landroid/view/ViewStub;", "friendListViewStub", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "friendListContainView", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "friendListView", "Lcom/tencent/biz/qqcircle/publish/view/edittext/ExtendEditText;", tl.h.F, "Lcom/tencent/biz/qqcircle/publish/view/edittext/ExtendEditText;", "editTextView", "Lcom/tencent/mobileqq/wink/publish/part/PublishAtFriendPart$a$a;", "i", "Lkotlin/Lazy;", "R9", "()Lcom/tencent/mobileqq/wink/publish/part/PublishAtFriendPart$a$a;", "itemDecoration", "Lcom/tencent/mobileqq/wink/publish/viewmodel/m;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "V9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/m;", "viewModel", "Lcom/tencent/mobileqq/wink/publish/viewmodel/i;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Q9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/i;", "atFriendViewModel", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PartsStateViewModel;", "D", "S9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/PartsStateViewModel;", "partStateViewModel", "Lcom/tencent/mobileqq/wink/publish/part/PublishAtFriendPart$FriendListAdapter;", "E", "P9", "()Lcom/tencent/mobileqq/wink/publish/part/PublishAtFriendPart$FriendListAdapter;", "adapter", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "FriendListAdapter", "c", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishAtFriendPart extends j {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int G = cx.j(40.0f);
    private static final int H = cx.j(22.0f);
    private static final int I = cx.j(41.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy atFriendViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy partStateViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewStub friendListViewStub;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout friendListContainView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView friendListView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ExtendEditText editTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy itemDecoration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001dj\b\u0012\u0004\u0012\u00020\u0002`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishAtFriendPart$FriendListAdapter;", "Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter;", "Lcom/tencent/mobileqq/wink/publish/part/PublishAtFriendPart$b;", "", "friends", "", "setData", "", "uin", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", "Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter$OnItemClickListener;", "listener", "m0", "Landroid/view/LayoutInflater;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "j0", "()Landroid/view/LayoutInflater;", "layoutInflater", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "friendsList", "D", "Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter$OnItemClickListener;", "onItemClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class FriendListAdapter extends BaseListViewAdapter<FriendData> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final ArrayList<FriendData> friendsList;

        /* renamed from: D, reason: from kotlin metadata */
        @Nullable
        private BaseListViewAdapter.OnItemClickListener onItemClickListener;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy layoutInflater;

        public FriendListAdapter(@NotNull final Context context) {
            Lazy lazy;
            Intrinsics.checkNotNullParameter(context, "context");
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<LayoutInflater>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart$FriendListAdapter$layoutInflater$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final LayoutInflater invoke() {
                    return LayoutInflater.from(context);
                }
            });
            this.layoutInflater = lazy;
            this.friendsList = new ArrayList<>();
        }

        private final LayoutInflater j0() {
            Object value = this.layoutInflater.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-layoutInflater>(...)");
            return (LayoutInflater) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k0(FriendListAdapter this$0, FriendData friendData, int i3, RecyclerView.ViewHolder holder, FriendData data, View view) {
            HashMap hashMapOf;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(friendData, "$friendData");
            Intrinsics.checkNotNullParameter(holder, "$holder");
            Intrinsics.checkNotNullParameter(data, "$data");
            BaseListViewAdapter.OnItemClickListener onItemClickListener = this$0.onItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(view, friendData, Integer.valueOf(i3));
            }
            View view2 = holder.itemView;
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_USER_ID, data.getFriend().uin));
            VideoReport.reportEvent("ev_xsj_abnormal_clck", view2, hashMapOf);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.friendsList.size();
        }

        public final void l0(@NotNull String uin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Iterator<FriendData> it = this.friendsList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "friendsList.iterator()");
            int i3 = -1;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i3++;
                FriendData next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if (Intrinsics.areEqual(next.getFriend().uin, uin)) {
                    it.remove();
                    break;
                }
            }
            notifyItemRemoved(i3);
        }

        public final void m0(@NotNull BaseListViewAdapter.OnItemClickListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.onItemClickListener = listener;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull final RecyclerView.ViewHolder holder, final int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            FriendData friendData = this.friendsList.get(position);
            Intrinsics.checkNotNullExpressionValue(friendData, "friendsList[position]");
            final FriendData friendData2 = friendData;
            c cVar = (c) holder;
            cVar.m(friendData2);
            cVar.getHeadIcon().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishAtFriendPart.FriendListAdapter.k0(PublishAtFriendPart.FriendListAdapter.this, friendData2, position, holder, friendData2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = j0().inflate(R.layout.guz, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R\u2026item_view, parent, false)");
            return new c(inflate);
        }

        public final void setData(@NotNull List<FriendData> friends) {
            Intrinsics.checkNotNullParameter(friends, "friends");
            this.friendsList.clear();
            this.friendsList.addAll(friends);
            FriendData friendData = new FriendData(null, new Friends());
            friendData.getFriend().friendType = 2;
            this.friendsList.add(friendData);
            notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishAtFriendPart$a;", "", "", "MARGIN_START", "I", "c", "()I", "MARGIN_END", "b", "ITEM_DISTANCE", "a", "", "REQUEST_HEAD_LIMI_TIME", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u00a2\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishAtFriendPart$a$a;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "getStart", "()I", "start", "e", "getBetween", "between", "f", "getEnd", "end", "<init>", "(III)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public static final class C9083a extends RecyclerView.ItemDecoration {

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private final int start;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            private final int between;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata */
            private final int end;

            public C9083a(int i3, int i16, int i17) {
                this.start = i3;
                this.between = i16;
                this.end = i17;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view, parent, state);
                if (parent.getAdapter() == null) {
                    return;
                }
                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.left = this.start;
                    outRect.right = this.between / 2;
                    return;
                }
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                Intrinsics.checkNotNull(parent.getAdapter());
                if (childAdapterPosition == r4.getNUM_BACKGOURND_ICON() - 1) {
                    outRect.left = this.between / 2;
                    outRect.right = this.end;
                } else {
                    int i3 = this.between;
                    outRect.left = i3 / 2;
                    outRect.right = i3 / 2;
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return PublishAtFriendPart.I;
        }

        public final int b() {
            return PublishAtFriendPart.H;
        }

        public final int c() {
            return PublishAtFriendPart.G;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R!\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishAtFriendPart$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/ref/SoftReference;", "Landroid/graphics/drawable/Drawable;", "a", "Ljava/lang/ref/SoftReference;", "b", "()Ljava/lang/ref/SoftReference;", "headDrawable", "Lcom/tencent/mobileqq/data/Friends;", "Lcom/tencent/mobileqq/data/Friends;", "()Lcom/tencent/mobileqq/data/Friends;", GuildMsgItem.NICK_FRIEND, "<init>", "(Ljava/lang/ref/SoftReference;Lcom/tencent/mobileqq/data/Friends;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class FriendData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final SoftReference<Drawable> headDrawable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Friends friend;

        public FriendData(@Nullable SoftReference<Drawable> softReference, @NotNull Friends friend) {
            Intrinsics.checkNotNullParameter(friend, "friend");
            this.headDrawable = softReference;
            this.friend = friend;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Friends getFriend() {
            return this.friend;
        }

        @Nullable
        public final SoftReference<Drawable> b() {
            return this.headDrawable;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FriendData)) {
                return false;
            }
            FriendData friendData = (FriendData) other;
            if (Intrinsics.areEqual(this.headDrawable, friendData.headDrawable) && Intrinsics.areEqual(this.friend, friendData.friend)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            SoftReference<Drawable> softReference = this.headDrawable;
            if (softReference == null) {
                hashCode = 0;
            } else {
                hashCode = softReference.hashCode();
            }
            return (hashCode * 31) + this.friend.hashCode();
        }

        @NotNull
        public String toString() {
            return "FriendData(headDrawable=" + this.headDrawable + ", friend=" + this.friend + ")";
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishAtFriendPart$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "nickName", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/wink/publish/part/PublishAtFriendPart$b;", "data", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/Drawable;", "E", "Landroid/graphics/drawable/Drawable;", "getDefaultHeadIcon", "()Landroid/graphics/drawable/Drawable;", "setDefaultHeadIcon", "(Landroid/graphics/drawable/Drawable;)V", "defaultHeadIcon", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "o", "()Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "setHeadIcon", "(Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;)V", "headIcon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "getNickName", "()Landroid/widget/TextView;", "setNickName", "(Landroid/widget/TextView;)V", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private Drawable defaultHeadIcon;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private RoundCornerImageView headIcon;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private TextView nickName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Drawable drawable = itemView.getResources().getDrawable(R.drawable.nqp);
            Intrinsics.checkNotNullExpressionValue(drawable, "itemView.resources.getDr\u2026n_brand_qq_color_outline)");
            this.defaultHeadIcon = drawable;
            View findViewById = itemView.findViewById(R.id.f58432q0);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.qpublish_qq_friend_head)");
            this.headIcon = (RoundCornerImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f58442q1);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026blish_qq_friend_nickname)");
            this.nickName = (TextView) findViewById2;
        }

        private final void l(FriendData data) {
            Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
            if (data.getFriend().friendType == 0) {
                VideoReport.setElementId(this.itemView, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_USER_LIST);
                VideoReport.setElementReuseIdentifier(this.itemView, data.getFriend().uin.toString());
                Intrinsics.checkNotNullExpressionValue(params, "params");
                params.put(QCircleDaTongConstant.ElementParamKey.XSJ_USER_ID, data.getFriend().uin.toString());
            } else if (data.getFriend().friendType == 2) {
                VideoReport.setElementId(this.itemView, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_USER_LIST_MORE);
                VideoReport.setElementReuseIdentifier(this.itemView, "more_friend");
            }
            VideoReport.setElementParams(this.itemView, params);
        }

        private final String n(String nickName) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("@");
            if (nickName.length() > 5) {
                String substring = nickName.substring(0, 5);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                sb5.append(substring);
                sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
            } else {
                sb5.append(nickName);
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "resultSb.toString()");
            return sb6;
        }

        public final void m(@NotNull FriendData data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(data, "data");
            Drawable drawable = null;
            this.headIcon.setImageDrawable(null);
            int i3 = data.getFriend().friendType;
            if (i3 != 0) {
                if (i3 == 2) {
                    Drawable drawable2 = this.itemView.getResources().getDrawable(R.drawable.knv);
                    Drawable drawable3 = this.itemView.getResources().getDrawable(R.drawable.qvideo_skin_icon_nav_more_dot);
                    this.headIcon.setScaleType(ImageView.ScaleType.CENTER);
                    this.headIcon.setBackground(drawable2);
                    this.headIcon.setImageDrawable(drawable3);
                    this.nickName.setText("\u66f4\u591a\u597d\u53cb");
                }
            } else {
                String str = data.getFriend().uin;
                Intrinsics.checkNotNullExpressionValue(str, "data.friend.uin");
                boolean z17 = false;
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    String str2 = data.getFriend().name;
                    Intrinsics.checkNotNullExpressionValue(str2, "data.friend.name");
                    if (str2.length() > 0) {
                        z17 = true;
                    }
                    if (z17) {
                        TextView textView = this.nickName;
                        String str3 = data.getFriend().name;
                        Intrinsics.checkNotNullExpressionValue(str3, "data.friend.name");
                        textView.setText(n(str3));
                    } else {
                        TextView textView2 = this.nickName;
                        String str4 = data.getFriend().uin;
                        Intrinsics.checkNotNullExpressionValue(str4, "data.friend.uin");
                        textView2.setText(n(str4));
                    }
                    SoftReference<Drawable> b16 = data.b();
                    if (b16 != null) {
                        drawable = b16.get();
                    }
                    this.headIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    if (drawable != null && drawable.getIntrinsicHeight() != -1 && drawable.getIntrinsicWidth() != -1) {
                        this.headIcon.setImageDrawable(drawable);
                    } else {
                        this.headIcon.setImageDrawable(this.defaultHeadIcon);
                        QLog.e("PublishAtFriendPart", 1, "[bindData] headDrawable is null");
                    }
                } else {
                    this.headIcon.setImageDrawable(this.defaultHeadIcon);
                }
            }
            l(data);
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final RoundCornerImageView getHeadIcon() {
            return this.headIcon;
        }
    }

    public PublishAtFriendPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Companion.C9083a>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart$itemDecoration$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PublishAtFriendPart.Companion.C9083a invoke() {
                PublishAtFriendPart.Companion companion = PublishAtFriendPart.INSTANCE;
                return new PublishAtFriendPart.Companion.C9083a(companion.c(), companion.a(), companion.b());
            }
        });
        this.itemDecoration = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.publish.viewmodel.m>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.publish.viewmodel.m invoke() {
                return (com.tencent.mobileqq.wink.publish.viewmodel.m) PublishAtFriendPart.this.getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.m.class);
            }
        });
        this.viewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.publish.viewmodel.i>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart$atFriendViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.publish.viewmodel.i invoke() {
                return (com.tencent.mobileqq.wink.publish.viewmodel.i) PublishAtFriendPart.this.getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.i.class);
            }
        });
        this.atFriendViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<PartsStateViewModel>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart$partStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PartsStateViewModel invoke() {
                return (PartsStateViewModel) PublishAtFriendPart.this.getViewModel(PartsStateViewModel.class);
            }
        });
        this.partStateViewModel = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<FriendListAdapter>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PublishAtFriendPart.FriendListAdapter invoke() {
                Context context = PublishAtFriendPart.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return new PublishAtFriendPart.FriendListAdapter(context);
            }
        });
        this.adapter = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FriendListAdapter P9() {
        return (FriendListAdapter) this.adapter.getValue();
    }

    private final com.tencent.mobileqq.wink.publish.viewmodel.i Q9() {
        return (com.tencent.mobileqq.wink.publish.viewmodel.i) this.atFriendViewModel.getValue();
    }

    private final Companion.C9083a R9() {
        return (Companion.C9083a) this.itemDecoration.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PartsStateViewModel S9() {
        Object value = this.partStateViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-partStateViewModel>(...)");
        return (PartsStateViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.h
            @Override // java.lang.Runnable
            public final void run() {
                PublishAtFriendPart.U9(PublishAtFriendPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(PublishAtFriendPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        List<Friends> value = this$0.V9().O1().getValue();
        if (value != null) {
            for (Friends friends : value) {
                long currentTimeMillis = System.currentTimeMillis();
                Drawable drawable = null;
                while (true) {
                    if (drawable == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
                        drawable = HostFaceUtils.getHeadDrawable(friends.uin, 1);
                        if (System.currentTimeMillis() - currentTimeMillis > 200) {
                            QLog.e("PublishAtFriendPart", 1, "[getUserHeadDrawableAsync] request time out");
                            break;
                        }
                    }
                }
                arrayList.add(new SoftReference<>(drawable));
            }
        }
        this$0.V9().P1().postValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.publish.viewmodel.m V9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (com.tencent.mobileqq.wink.publish.viewmodel.m) value;
    }

    private final void W9() {
        MediatorLiveData<PublishSettingItemState> f26 = S9().f2();
        BasePartFragment hostFragment = getHostFragment();
        final Function1<PublishSettingItemState, Unit> function1 = new Function1<PublishSettingItemState, Unit>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart$initObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishSettingItemState publishSettingItemState) {
                invoke2(publishSettingItemState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishSettingItemState publishSettingItemState) {
                FrameLayout frameLayout;
                frameLayout = PublishAtFriendPart.this.friendListContainView;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("friendListContainView");
                    frameLayout = null;
                }
                frameLayout.setVisibility(publishSettingItemState.getVisible() ? 0 : 8);
            }
        };
        f26.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishAtFriendPart.X9(Function1.this, obj);
            }
        });
        MutableLiveData<List<Friends>> O1 = V9().O1();
        BasePartFragment hostFragment2 = getHostFragment();
        final Function1<List<Friends>, Unit> function12 = new Function1<List<Friends>, Unit>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart$initObserve$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<Friends> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Friends> it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!it.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (Friends friend : it) {
                        Intrinsics.checkNotNullExpressionValue(friend, "friend");
                        arrayList.add(new PublishAtFriendPart.FriendData(null, friend));
                    }
                    PublishAtFriendPart.this.T9();
                }
            }
        };
        O1.observe(hostFragment2, new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishAtFriendPart.Y9(Function1.this, obj);
            }
        });
        MutableLiveData<List<SoftReference<Drawable>>> P1 = V9().P1();
        BasePartFragment hostFragment3 = getHostFragment();
        final Function1<List<SoftReference<Drawable>>, Unit> function13 = new Function1<List<SoftReference<Drawable>>, Unit>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart$initObserve$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<SoftReference<Drawable>> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<SoftReference<Drawable>> it) {
                com.tencent.mobileqq.wink.publish.viewmodel.m V9;
                int i3;
                com.tencent.mobileqq.wink.publish.viewmodel.m V92;
                PublishAtFriendPart.FriendListAdapter P9;
                PartsStateViewModel S9;
                com.tencent.mobileqq.wink.publish.viewmodel.m V93;
                com.tencent.mobileqq.wink.publish.viewmodel.m V94;
                V9 = PublishAtFriendPart.this.V9();
                if (V9.O1().getValue() != null) {
                    V94 = PublishAtFriendPart.this.V9();
                    List<Friends> value = V94.O1().getValue();
                    Intrinsics.checkNotNull(value);
                    i3 = value.size();
                } else {
                    i3 = -1;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!it.isEmpty()) {
                    if (it.size() != i3) {
                        QLog.e("PublishAtFriendPart", 1, "[ObserveHeadDrawable] invalid size:" + i3);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    V92 = PublishAtFriendPart.this.V9();
                    List<Friends> value2 = V92.O1().getValue();
                    Intrinsics.checkNotNull(value2);
                    int size = value2.size();
                    for (int i16 = 0; i16 < size; i16++) {
                        Drawable drawable = it.get(i16).get();
                        if (drawable != null && drawable.getIntrinsicHeight() != -1 && drawable.getIntrinsicWidth() != -1) {
                            SoftReference<Drawable> softReference = it.get(i16);
                            V93 = PublishAtFriendPart.this.V9();
                            List<Friends> value3 = V93.O1().getValue();
                            Intrinsics.checkNotNull(value3);
                            Friends friends = value3.get(i16);
                            Intrinsics.checkNotNullExpressionValue(friends, "viewModel.friendsData.value!![index]");
                            arrayList.add(new PublishAtFriendPart.FriendData(softReference, friends));
                        }
                    }
                    if (arrayList.size() > 0) {
                        P9 = PublishAtFriendPart.this.P9();
                        P9.setData(arrayList);
                        S9 = PublishAtFriendPart.this.S9();
                        S9.N2(true);
                    }
                }
            }
        };
        P1.observe(hostFragment3, new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishAtFriendPart.Z9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(PublishAtFriendPart this$0, View view, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart.FriendData");
        FriendData friendData = (FriendData) obj;
        int i3 = friendData.getFriend().friendType;
        if (i3 != 0) {
            if (i3 == 2) {
                com.tencent.mobileqq.wink.publish.util.c.e(this$0.getContext(), true, 1, uq3.c.Z2(), this$0.Q9().N1(), 1001);
            }
        } else {
            this$0.V9().R1(friendData.getFriend());
            FriendListAdapter P9 = this$0.P9();
            String str = friendData.getFriend().uin;
            Intrinsics.checkNotNullExpressionValue(str, "data.friend.uin");
            P9.l0(str);
        }
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NotNull
    public String B9() {
        return "PublishAtFriendPart";
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View mRootView) {
        super.onInitView(mRootView);
        if (mRootView == null) {
            return;
        }
        View findViewById = getPartRootView().findViewById(R.id.bys);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.et_content)");
        this.editTextView = (ExtendEditText) findViewById;
        View findViewById2 = getPartRootView().findViewById(R.id.f58182pb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ish_at_friends_view_stub)");
        ViewStub viewStub = (ViewStub) findViewById2;
        this.friendListViewStub = viewStub;
        RecyclerView recyclerView = null;
        if (viewStub == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendListViewStub");
            viewStub = null;
        }
        View findViewById3 = viewStub.inflate().findViewById(R.id.f58172pa);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "friendListViewStub.infla\u2026h_at_friend_list_contain)");
        FrameLayout frameLayout = (FrameLayout) findViewById3;
        this.friendListContainView = frameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendListContainView");
            frameLayout = null;
        }
        View findViewById4 = frameLayout.findViewById(R.id.f58162p_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "friendListContainView.fi\u2026.qpublish_at_friend_list)");
        this.friendListView = (RecyclerView) findViewById4;
        q93.c cVar = new q93.c(getContext());
        cVar.setOrientation(0);
        RecyclerView recyclerView2 = this.friendListView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendListView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(cVar);
        RecyclerView recyclerView3 = this.friendListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendListView");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(R9());
        RecyclerView recyclerView4 = this.friendListView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendListView");
        } else {
            recyclerView = recyclerView4;
        }
        recyclerView.setAdapter(P9());
        P9().m0(new BaseListViewAdapter.OnItemClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.d
            @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter.OnItemClickListener
            public final void onItemClick(View view, Object obj, Object obj2) {
                PublishAtFriendPart.aa(PublishAtFriendPart.this, view, obj, obj2);
            }
        });
        W9();
        V9().N1();
    }
}
