package com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.TroopBindGuildSwitchAdapter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B!\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fH\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/TroopBindGuildSwitchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/TroopBindGuildSwitchAdapter$a;", "", "isChecked", "", "p0", h.f248218g, "n0", "m0", "", "", "", "o0", "u0", "", "getItemCount", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "t0", "holder", "position", "s0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Lht2/g;", BdhLogUtil.LogTag.Tag_Conn, "Lht2/g;", "vm", "Landroidx/lifecycle/LifecycleOwner;", "D", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "E", "Z", "isSwitchOpen", UserInfo.SEX_FEMALE, "hasReportExposure", "<init>", "(Landroid/content/Context;Lht2/g;Landroidx/lifecycle/LifecycleOwner;)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopBindGuildSwitchAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ht2.g vm;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isSwitchOpen;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasReportExposure;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/TroopBindGuildSwitchAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "isSwitchOpen", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "E", "Landroid/view/View;", "view", "Lkotlin/Function1;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "callback", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "kotlin.jvm.PlatformType", "G", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "switchItemView", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View view;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final Function1<Boolean, Unit> callback;

        /* renamed from: G, reason: from kotlin metadata */
        private final QUISingleLineListItem switchItemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull View view, @NotNull Function1<? super Boolean, Unit> callback) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.view = view;
            this.callback = callback;
            this.switchItemView = (QUISingleLineListItem) view.findViewById(R.id.f912954s);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(a this$0, CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.callback.invoke(Boolean.valueOf(z16));
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }

        public final void m(boolean isSwitchOpen) {
            this.switchItemView.setBackgroundType(QUIListItemBackgroundType.AllRound);
            this.switchItemView.setStyle(QUIListItemStyle.Card);
            String qqStr = HardCodeUtil.qqStr(R.string.f2335977o);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.troop_guild_allow_troop_bind_guild)");
            x xVar = new x(new x.b.d(qqStr), new x.c.f(isSwitchOpen, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.g
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    TroopBindGuildSwitchAdapter.a.n(TroopBindGuildSwitchAdapter.a.this, compoundButton, z16);
                }
            }));
            this.switchItemView.setConfig(xVar.K(), xVar.O());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/TroopBindGuildSwitchAdapter$b", "Lkotlin/Function1;", "", "", "isChecked", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements Function1<Boolean, Unit> {
        b() {
        }

        public void a(boolean isChecked) {
            TroopBindGuildSwitchAdapter.this.p0(isChecked);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public TroopBindGuildSwitchAdapter(@Nullable Context context, @NotNull ht2.g vm5, @NotNull LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.context = context;
        this.vm = vm5;
        this.viewLifecycleOwner = viewLifecycleOwner;
    }

    private final void m0(boolean isOpen) {
        Map<String, ? extends Object> mapOf;
        if (this.hasReportExposure) {
            return;
        }
        int i3 = 1;
        this.hasReportExposure = true;
        ht2.g gVar = this.vm;
        if (!isOpen) {
            i3 = 2;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, Integer.valueOf(i3)));
        gVar.c2("em_group_channel_bind_switch", "dt_imp", mapOf);
    }

    private final void n0(boolean isOpen) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.viewLifecycleOwner), null, null, new TroopBindGuildSwitchAdapter$doSwitchAction$1(this, isOpen, null), 3, null);
        this.vm.c2("em_group_channel_bind_switch", "dt_clck", o0(isOpen));
        u0(isOpen);
    }

    private final Map<String, Object> o0(boolean isOpen) {
        int i3;
        Map<String, Object> mutableMapOf;
        int i16 = 2;
        Pair[] pairArr = new Pair[2];
        if (isOpen) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        pairArr[0] = TuplesKt.to(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, Integer.valueOf(i3));
        if (isOpen) {
            i16 = 1;
        }
        pairArr[1] = TuplesKt.to("after_click_state", Integer.valueOf(i16));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(boolean isChecked) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(Foreground.getTopActivity(), HardCodeUtil.qqStr(R.string.f146290ts), 0).show();
            u0(!isChecked);
            return;
        }
        if (!isChecked) {
            if (this.vm.a2()) {
                n0(false);
                return;
            }
            Context context = this.context;
            if (context != null) {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, HardCodeUtil.qqStr(R.string.f23378787), HardCodeUtil.qqStr(R.string.f2338578d), HardCodeUtil.qqStr(R.string.f2059456z), HardCodeUtil.qqStr(R.string.f2336177q), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.e
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        TroopBindGuildSwitchAdapter.q0(TroopBindGuildSwitchAdapter.this, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.f
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        TroopBindGuildSwitchAdapter.r0(TroopBindGuildSwitchAdapter.this, dialogInterface, i3);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026  }\n                    )");
                createCustomDialog.show();
                return;
            }
            return;
        }
        n0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(TroopBindGuildSwitchAdapter this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n0(false);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(TroopBindGuildSwitchAdapter this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u0(true);
        dialogInterface.dismiss();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.m(this.isSwitchOpen);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fzx, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026rent, false\n            )");
        return new a(inflate, new b());
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void u0(boolean isOpen) {
        this.isSwitchOpen = isOpen;
        notifyDataSetChanged();
        m0(isOpen);
    }
}
