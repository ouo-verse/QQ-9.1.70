package com.tencent.timi.game.component.gamecore.impl.widget;

import ag4.i;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.gamecore.impl.widget.GameAccountSelectView;
import com.tencent.timi.game.utils.l;
import fh4.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.bb;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAbsInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0003#\u0005\u000bB'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\u000b\u001a\u0004\u0018\u00010\bR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u00060\u0013R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/timi/game/component/gamecore/impl/widget/GameAccountSelectView;", "Landroid/widget/FrameLayout;", "", "d", "", "b", "yesGameId", "", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", "list", "setData", "c", "I", "mYesGameId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "mSombaAccountList", "Lcom/tencent/timi/game/component/gamecore/impl/widget/GameAccountSelectView$a;", "f", "Lcom/tencent/timi/game/component/gamecore/impl/widget/GameAccountSelectView$a;", "mAdapter", "Lnr2/bb;", h.F, "Lnr2/bb;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class GameAccountSelectView extends FrameLayout {
    private static final int C;

    /* renamed from: m, reason: collision with root package name */
    private static final int f376774m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mYesGameId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<YesGameInfoOuterClass$YesGameRoleAbsInfo> mSombaAccountList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bb binding;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0003J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/timi/game/component/gamecore/impl/widget/GameAccountSelectView$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/component/gamecore/impl/widget/GameAccountSelectView$c;", "", "selectedPos", "", "n0", "j0", "Landroid/view/ViewGroup;", "viewGroup", "position", "m0", "holder", "k0", "getItemCount", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "mSelectFlags", BdhLogUtil.LogTag.Tag_Conn, "I", "mSelectedPos", "<init>", "(Lcom/tencent/timi/game/component/gamecore/impl/widget/GameAccountSelectView;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class a extends RecyclerView.Adapter<c> {

        /* renamed from: C, reason: from kotlin metadata */
        private int mSelectedPos;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<Boolean> mSelectFlags = new ArrayList<>();

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l0(a this$0, int i3, View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.mSelectFlags.clear();
            int num_backgournd_icon = this$0.getNUM_BACKGOURND_ICON();
            for (int i16 = 0; i16 < num_backgournd_icon; i16++) {
                ArrayList<Boolean> arrayList = this$0.mSelectFlags;
                if (i16 == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                arrayList.add(Boolean.valueOf(z16));
            }
            this$0.mSelectedPos = i3;
            this$0.notifyDataSetChanged();
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return GameAccountSelectView.this.mSombaAccountList.size();
        }

        public final int j0() {
            l.i("GameAccountSelectView_", "mSelectedPos=" + this.mSelectedPos);
            return this.mSelectedPos;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull c holder, final int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Object obj = GameAccountSelectView.this.mSombaAccountList.get(position);
            Intrinsics.checkNotNullExpressionValue(obj, "mSombaAccountList[position]");
            YesGameInfoOuterClass$YesGameRoleAbsInfo yesGameInfoOuterClass$YesGameRoleAbsInfo = (YesGameInfoOuterClass$YesGameRoleAbsInfo) obj;
            Boolean bool = this.mSelectFlags.get(position);
            Intrinsics.checkNotNullExpressionValue(bool, "mSelectFlags[position]");
            if (bool.booleanValue()) {
                holder.getCheckHintImg().setVisibility(0);
                holder.getCheckHintImg().setImageResource(R.drawable.o7m);
            } else {
                holder.getCheckHintImg().setVisibility(4);
            }
            holder.getRoleNameTxv().setText(yesGameInfoOuterClass$YesGameRoleAbsInfo.role_name.get());
            holder.getRoleDescTxv().setText(yesGameInfoOuterClass$YesGameRoleAbsInfo.role_desc.get());
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.gamecore.impl.widget.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameAccountSelectView.a.l0(GameAccountSelectView.a.this, position, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(@NotNull ViewGroup viewGroup, int position) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View view = View.inflate(GameAccountSelectView.this.getContext(), R.layout.hxl, null);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new c(view);
        }

        public final void n0(int selectedPos) {
            boolean z16;
            int num_backgournd_icon = getNUM_BACKGOURND_ICON();
            this.mSelectFlags.clear();
            for (int i3 = 0; i3 < num_backgournd_icon; i3++) {
                ArrayList<Boolean> arrayList = this.mSelectFlags;
                if (i3 == selectedPos) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                arrayList.add(Boolean.valueOf(z16));
            }
            this.mSelectedPos = selectedPos;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/component/gamecore/impl/widget/GameAccountSelectView$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "checkHintImg", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "roleNameTxv", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "roleDescTxv", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView checkHintImg;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView roleNameTxv;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView roleDescTxv;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.tuk);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.checkHintImg)");
            this.checkHintImg = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.f7773456);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.roleNameTxv)");
            this.roleNameTxv = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.f776144u);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.roleDescTxv)");
            this.roleDescTxv = (TextView) findViewById3;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ImageView getCheckHintImg() {
            return this.checkHintImg;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getRoleDescTxv() {
            return this.roleDescTxv;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final TextView getRoleNameTxv() {
            return this.roleNameTxv;
        }
    }

    static {
        int b16 = b.b(63);
        f376774m = b16;
        C = b16 * 3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GameAccountSelectView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int b() {
        YesGameInfoOuterClass$GetUserGameDefaultRoleRsp value;
        boolean z16;
        LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2 = ((i) mm4.b.b(i.class)).B2(this.mYesGameId);
        if (B2 != null && (value = B2.getValue()) != null) {
            Iterator<YesGameInfoOuterClass$YesGameRoleAbsInfo> it = this.mSombaAccountList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int i16 = i3 + 1;
                YesGameInfoOuterClass$YesGameRoleAbsInfo next = it.next();
                int i17 = next.area.get();
                int i18 = value.role_info.area.get();
                l.i("GameAccountSelectView_", "areaOfCurrent =" + i17 + ", areaOfDefault =" + i18);
                int i19 = next.partition.get();
                int i26 = value.role_info.partition.get();
                l.i("GameAccountSelectView_", "partitionOfCurrent =" + i19 + ", partitionOfDefault =" + i26);
                String str = next.role_name.get();
                String str2 = value.role_info.role_name.get();
                l.i("GameAccountSelectView_", "roleNameOfCurrent =" + str + ", roleNameOfDefault =" + str2);
                if (i17 == i18 && i19 == i26 && Intrinsics.areEqual(str, str2)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                l.i("GameAccountSelectView_", "compare result:" + z16);
                if (z16) {
                    return i3;
                }
                i3 = i16;
            }
        }
        return 0;
    }

    private final void d() {
        this.binding.f420976b.setAdapter(this.mAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.binding.f420976b.setLayoutManager(linearLayoutManager);
        this.binding.f420976b.setOverScrollMode(2);
    }

    @Nullable
    public final YesGameInfoOuterClass$YesGameRoleAbsInfo c() {
        int j06 = this.mAdapter.j0();
        if (this.mSombaAccountList.size() <= j06) {
            return null;
        }
        return this.mSombaAccountList.get(j06);
    }

    public final void setData(int yesGameId, @NotNull List<YesGameInfoOuterClass$YesGameRoleAbsInfo> list) {
        Object obj;
        int indexOf;
        Intrinsics.checkNotNullParameter(list, "list");
        this.mYesGameId = yesGameId;
        this.mSombaAccountList.clear();
        this.mSombaAccountList.addAll(list);
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((YesGameInfoOuterClass$YesGameRoleAbsInfo) obj).is_default.get()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends YesGameInfoOuterClass$YesGameRoleAbsInfo>) ((List<? extends Object>) this.mSombaAccountList), (YesGameInfoOuterClass$YesGameRoleAbsInfo) obj);
        l.i("GameAccountSelectView_", "selectedPosInList:" + indexOf);
        int b16 = b();
        l.i("GameAccountSelectView_", "selectedPosFromCompare:" + indexOf);
        this.mAdapter.n0(b16);
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GameAccountSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GameAccountSelectView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GameAccountSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSombaAccountList = new ArrayList<>();
        this.mAdapter = new a();
        bb f16 = bb.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        d();
    }
}
