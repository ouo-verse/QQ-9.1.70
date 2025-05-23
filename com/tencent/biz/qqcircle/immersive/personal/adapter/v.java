package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.immersive.personal.data.QFSTroopItemInfo;
import com.tencent.biz.qqcircle.immersive.personal.data.TroopItemType;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u000e\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004()*+B\u0007\u00a2\u0006\u0004\b%\u0010&J+\u0010\n\u001a\u00020\b2#\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003J\u0014\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0015H\u0016R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R3\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006,"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/adapter/v;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/Function1;", "Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "Lkotlin/ParameterName;", "name", "info", "", "listener", "n0", "", "list", "setData", "troop", "o0", "", "troopId", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "position", "getItemId", "getItemViewType", "viewHolder", "onBindViewHolder", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "data", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "onItemClickListener", "<init>", "()V", "D", "a", "b", "c", "d", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class v extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<? super QFSTroopItemInfo, Unit> onItemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QFSTroopItemInfo> data = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/adapter/v$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "info", "", "l", "Landroid/view/View;", "E", "Landroid/view/View;", "checkedView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "iconView", "G", "getContainer", "()Landroid/view/View;", ParseCommon.CONTAINER, "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final View checkedView;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private final ImageView iconView;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private final View container;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.checkedView = itemView.findViewById(R.id.f34280yq);
            this.iconView = (ImageView) itemView.findViewById(R.id.f34300ys);
            this.container = itemView.findViewById(R.id.f34290yr);
        }

        public final void l(@NotNull QFSTroopItemInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            if (info.getIsBound()) {
                View view = this.container;
                if (view != null) {
                    view.setBackgroundResource(R.drawable.qui_common_fill_standard_primary_bg);
                }
                View view2 = this.checkedView;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            } else {
                View view3 = this.checkedView;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
                View view4 = this.container;
                if (view4 != null) {
                    view4.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
                }
            }
            String url = QCircleSkinHelper.getInstance().getUrl("qvideo_post_icon_invisiblegroup");
            Option obtain = Option.obtain();
            obtain.setUrl(url);
            obtain.setTargetView(this.iconView);
            obtain.setRequestWidth(e83.a.b(44));
            obtain.setRequestHeight(e83.a.b(44));
            obtain.setLoadingDrawableColor(0);
            QCircleFeedPicLoader.g().loadImage(obtain);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/adapter/v$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "info", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private TextView titleView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(R.id.f4964239);
            this.titleView = textView;
            if (textView != null) {
                textView.setTextSize(12.0f);
            }
        }

        public final void l(@NotNull QFSTroopItemInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            TextView textView = this.titleView;
            if (textView != null) {
                textView.setText(info.getText());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\bR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\bR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\b\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/adapter/v$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "info", "", "l", "Landroid/view/View;", "E", "Landroid/view/View;", ParseCommon.CONTAINER, "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "headView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "nameView", "H", "memberView", "I", "descView", "J", "fullView", "K", "activeView", "L", "checkView", "M", "btnView", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private View container;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private QCircleAvatarView headView;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private TextView nameView;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private TextView memberView;

        /* renamed from: I, reason: from kotlin metadata */
        @Nullable
        private TextView descView;

        /* renamed from: J, reason: from kotlin metadata */
        @Nullable
        private final View fullView;

        /* renamed from: K, reason: from kotlin metadata */
        @Nullable
        private final View activeView;

        /* renamed from: L, reason: from kotlin metadata */
        @Nullable
        private final View checkView;

        /* renamed from: M, reason: from kotlin metadata */
        @Nullable
        private final View btnView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.container = itemView.findViewById(R.id.f55902j6);
            this.headView = (QCircleAvatarView) itemView.findViewById(R.id.f4958233);
            this.nameView = (TextView) itemView.findViewById(R.id.f4962237);
            this.memberView = (TextView) itemView.findViewById(R.id.f4960235);
            this.descView = (TextView) itemView.findViewById(R.id.f4956231);
            this.fullView = itemView.findViewById(R.id.f4957232);
            this.activeView = itemView.findViewById(R.id.f495022v);
            this.checkView = itemView.findViewById(R.id.f495322y);
            View findViewById = itemView.findViewById(R.id.f495222x);
            this.btnView = findViewById;
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            QCircleAvatarView qCircleAvatarView = this.headView;
            if (qCircleAvatarView != null) {
                qCircleAvatarView.i();
            }
        }

        public final void l(@NotNull QFSTroopItemInfo info) {
            boolean isBlank;
            Intrinsics.checkNotNullParameter(info, "info");
            QCircleAvatarView qCircleAvatarView = this.headView;
            if (qCircleAvatarView != null) {
                qCircleAvatarView.setAvatarByUrl(info.getHeadUrl(), new Size(e83.a.b(44), e83.a.b(44)));
            }
            TextView textView = this.nameView;
            if (textView != null) {
                textView.setText(info.getName());
            }
            TextView textView2 = this.memberView;
            if (textView2 != null) {
                textView2.setText(String.valueOf(info.getMemberNum()));
            }
            isBlank = StringsKt__StringsJVMKt.isBlank(info.getDesc());
            if (!isBlank) {
                TextView textView3 = this.descView;
                if (textView3 != null) {
                    textView3.setText(info.getDesc());
                }
                TextView textView4 = this.descView;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
            } else {
                TextView textView5 = this.descView;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
            }
            if (info.getIsBound()) {
                View view = this.container;
                if (view != null) {
                    view.setBackgroundResource(R.drawable.qui_common_fill_standard_primary_bg);
                }
                View view2 = this.checkView;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            } else {
                View view3 = this.container;
                if (view3 != null) {
                    view3.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
                }
                View view4 = this.checkView;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
            }
            if (info.getIsFull()) {
                View view5 = this.fullView;
                if (view5 != null) {
                    view5.setVisibility(0);
                }
            } else {
                View view6 = this.fullView;
                if (view6 != null) {
                    view6.setVisibility(8);
                }
            }
            if (info.getIsActive()) {
                View view7 = this.activeView;
                if (view7 != null) {
                    view7.setVisibility(0);
                    return;
                }
                return;
            }
            View view8 = this.activeView;
            if (view8 != null) {
                view8.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(v this$0, QFSTroopItemInfo info, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        Function1<? super QFSTroopItemInfo, Unit> function1 = this$0.onItemClickListener;
        if (function1 != null) {
            function1.invoke(info);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(v this$0, QFSTroopItemInfo info, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        Function1<? super QFSTroopItemInfo, Unit> function1 = this$0.onItemClickListener;
        if (function1 != null) {
            function1.invoke(info);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.data.get(position).getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.data.get(position).getType().ordinal();
    }

    @Nullable
    public final QFSTroopItemInfo k0(long troopId) {
        Object obj;
        boolean z16;
        Iterator<T> it = this.data.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((QFSTroopItemInfo) obj).getId() == troopId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (QFSTroopItemInfo) obj;
    }

    public final void n0(@Nullable Function1<? super QFSTroopItemInfo, Unit> listener) {
        this.onItemClickListener = listener;
    }

    public final void o0(@NotNull QFSTroopItemInfo troop) {
        Intrinsics.checkNotNullParameter(troop, "troop");
        notifyItemChanged(this.data.indexOf(troop));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final QFSTroopItemInfo qFSTroopItemInfo = this.data.get(position);
        if (viewHolder instanceof d) {
            ((d) viewHolder).l(qFSTroopItemInfo);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.l0(v.this, qFSTroopItemInfo, view);
                }
            });
        } else if (viewHolder instanceof b) {
            ((b) viewHolder).l(qFSTroopItemInfo);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.m0(v.this, qFSTroopItemInfo, view);
                }
            });
        } else if (viewHolder instanceof c) {
            ((c) viewHolder).l(qFSTroopItemInfo);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == TroopItemType.RESET.ordinal()) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.g87, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new b(itemView);
        }
        if (viewType == TroopItemType.TEXT.ordinal()) {
            View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.gnz, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            return new c(itemView2);
        }
        View itemView3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.gny, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView3, "itemView");
        return new d(itemView3);
    }

    public final void setData(@NotNull List<QFSTroopItemInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.data.clear();
        this.data.addAll(list);
        notifyDataSetChanged();
    }
}
