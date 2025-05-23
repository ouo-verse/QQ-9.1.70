package com.tencent.guild.aio.reserve2.busi.chosen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgState;
import com.tencent.guild.aio.reserve2.busi.chosen.view.ChosenBarView;
import com.tencent.guild.aio.util.ae;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qq0.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\n*\u0001/\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u000267B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\f\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u0016\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0003H\u0016J\u0016\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030!0\u0006H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00068"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/d;", "Lcom/tencent/aio/base/mvvm/a;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState;", "", ICustomDataEditor.NUMBER_PARAM_1, "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;", "msgSeqList", "", "channelId", "e1", "m1", "Lcom/tencent/guild/aio/reserve2/busi/chosen/a;", "chosenMsg", "o1", "", "selectedMsgSeq", "filePath", "q1", "tinyId", "p1", "msgSeq", "l1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "f1", "state", "h1", "Ljava/lang/Class;", "getObserverStates", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lvn0/a;", "d", "Lvn0/a;", "g1", "()Lvn0/a;", "k1", "(Lvn0/a;)V", "binding", "e", "J", "lastClickTime", "com/tencent/guild/aio/reserve2/busi/chosen/d$d", "f", "Lcom/tencent/guild/aio/reserve2/busi/chosen/d$d;", "mGuildThemeCallback", "<init>", "()V", h.F, "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends com.tencent.aio.base.mvvm.a<qq0.b, GuildChosenMsgState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public vn0.a binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C1210d mGuildThemeCallback = new C1210d(this);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/d$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/aio/data/AIOContact;", "a", "Lcom/tencent/aio/data/AIOContact;", "()Lcom/tencent/aio/data/AIOContact;", "ioaParams", "", "b", "J", "()J", "selectedMsgSeq", "<init>", "(Lcom/tencent/aio/data/AIOContact;J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.reserve2.busi.chosen.d$a, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class ChosenParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final AIOContact ioaParams;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long selectedMsgSeq;

        public ChosenParams(@NotNull AIOContact ioaParams, long j3) {
            Intrinsics.checkNotNullParameter(ioaParams, "ioaParams");
            this.ioaParams = ioaParams;
            this.selectedMsgSeq = j3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AIOContact getIoaParams() {
            return this.ioaParams;
        }

        /* renamed from: b, reason: from getter */
        public final long getSelectedMsgSeq() {
            return this.selectedMsgSeq;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChosenParams)) {
                return false;
            }
            ChosenParams chosenParams = (ChosenParams) other;
            if (Intrinsics.areEqual(this.ioaParams, chosenParams.ioaParams) && this.selectedMsgSeq == chosenParams.selectedMsgSeq) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.ioaParams.hashCode() * 31) + androidx.fragment.app.a.a(this.selectedMsgSeq);
        }

        @NotNull
        public String toString() {
            return "ChosenParams(ioaParams=" + this.ioaParams + ", selectedMsgSeq=" + this.selectedMsgSeq + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class c<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((IGProTopMsg) t16).getTopMsgSeq()), Long.valueOf(((IGProTopMsg) t17).getTopMsgSeq()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R%\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/guild/aio/reserve2/busi/chosen/d$d", "Lor0/a;", "", "onThemeChanged", "Lmqq/util/WeakReference;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/d;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "getWeakRef", "()Lmqq/util/WeakReference;", "weakRef", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.reserve2.busi.chosen.d$d, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1210d implements or0.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<d> weakRef;

        C1210d(d dVar) {
            this.weakRef = new WeakReference<>(dVar);
        }

        @Override // or0.a
        public void onThemeChanged() {
            d dVar = this.weakRef.get();
            if (dVar != null) {
                dVar.n1();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class e<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((IGProTopMsg) t16).getTopMsgSeq()), Long.valueOf(((IGProTopMsg) t17).getTopMsgSeq()));
            return compareValues;
        }
    }

    private final void e1(List<? extends IGProTopMsg> msgSeqList, String channelId) {
        List<? extends IGProTopMsg> sortedWith;
        if (!msgSeqList.isEmpty()) {
            ChosenBarView root = g1().getRoot();
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(msgSeqList, new c());
            root.K0(sortedWith, channelId);
        } else {
            QLog.i("GuildChosenMsgVB", 1, "createAndInitChosenBar root gone");
            g1().getRoot().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i1(vn0.a this_apply, d this$0, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IGProTopMsg curTopMsg = this_apply.getRoot().getCurTopMsg();
        if (curTopMsg != null) {
            this$0.l1(curTopMsg.getTopMsgSeq());
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(d this$0, vn0.a this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        QLog.i("GuildChosenMsgVB", 4, "onClick chosen bar");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this$0.lastClickTime > 1000) {
            this$0.lastClickTime = currentTimeMillis;
            ae.d(ae.f112367a, this$0.getMContext(), 0L, 2, null);
            this_apply.getRoot().N0();
        } else {
            QLog.i("GuildChosenMsgVB", 1, "onCreateView, onclick chose bar so fast");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l1(long msgSeq) {
        FragmentActivity fragmentActivity;
        Context mContext = getMContext();
        if (mContext instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) mContext;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            sendIntent(new b.d(getMContext(), msgSeq));
        }
    }

    private final void m1(List<? extends IGProTopMsg> msgSeqList, String channelId) {
        List<? extends IGProTopMsg> sortedWith;
        if (!msgSeqList.isEmpty()) {
            ChosenBarView root = g1().getRoot();
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(msgSeqList, new e());
            root.O0(sortedWith, channelId);
        } else {
            QLog.i("GuildChosenMsgVB", 1, "updateChosenBar root gone");
            g1().getRoot().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1() {
        g1().f441890c.setBackgroundResource(0);
        if (UIUtil.f112434a.A()) {
            g1().f441890c.setBackgroundResource(R.drawable.guild_bg_nav_bottom_aio_corner_6);
        } else {
            g1().f441890c.setBackgroundResource(R.drawable.guild_topping_bar_normal_bg);
        }
    }

    private final void o1(a chosenMsg) {
        g1().getRoot().B0(chosenMsg);
    }

    private final void p1(String tinyId) {
        g1().getRoot().Q0(tinyId);
    }

    private final void q1(long selectedMsgSeq, String filePath) {
        g1().getRoot().R0(selectedMsgSeq, filePath);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        n1();
        QQGuildThemeManager.c(this.mGuildThemeCallback);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<qq0.b, GuildChosenMsgState> createVM() {
        return new GuildChosenMsgVM(null, 1, null);
    }

    @NotNull
    public final vn0.a g1() {
        vn0.a aVar = this.binding;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildChosenMsgState>> getObserverStates() {
        List<Class<? extends GuildChosenMsgState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildChosenMsgState.GuildUpdateNickNameUIState.class, GuildChosenMsgState.GuildUpdatePicIvUIState.class, GuildChosenMsgState.GuildUpdateListUIState.class, GuildChosenMsgState.GuildInitListUIState.class, GuildChosenMsgState.GuildGetCurMsgUIState.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildChosenMsgState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildChosenMsgState.GuildUpdatePicIvUIState) {
            GuildChosenMsgState.GuildUpdatePicIvUIState guildUpdatePicIvUIState = (GuildChosenMsgState.GuildUpdatePicIvUIState) state;
            q1(guildUpdatePicIvUIState.getUpdatePicSeq(), guildUpdatePicIvUIState.getFilePath());
            return;
        }
        if (state instanceof GuildChosenMsgState.GuildUpdateListUIState) {
            GuildChosenMsgState.GuildUpdateListUIState guildUpdateListUIState = (GuildChosenMsgState.GuildUpdateListUIState) state;
            m1(guildUpdateListUIState.b(), guildUpdateListUIState.getChannelId());
        } else if (state instanceof GuildChosenMsgState.GuildInitListUIState) {
            GuildChosenMsgState.GuildInitListUIState guildInitListUIState = (GuildChosenMsgState.GuildInitListUIState) state;
            e1(guildInitListUIState.b(), guildInitListUIState.getChannelId());
        } else if (state instanceof GuildChosenMsgState.GuildGetCurMsgUIState) {
            o1(((GuildChosenMsgState.GuildGetCurMsgUIState) state).getChosenMsg());
        } else if (state instanceof GuildChosenMsgState.GuildUpdateNickNameUIState) {
            p1(((GuildChosenMsgState.GuildUpdateNickNameUIState) state).getTinyId());
        }
    }

    public final void k1(@NotNull vn0.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.binding = aVar;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        vn0.a g16 = vn0.a.g(LayoutInflater.from(getMContext()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        k1(g16);
        g1().getRoot().setVisibility(8);
        final vn0.a g17 = g1();
        ChosenBarView root = g17.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "root");
        com.tencent.mobileqq.guild.component.token.c.c(root, null, 2, null);
        g17.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean i16;
                i16 = d.i1(vn0.a.this, this, view);
                return i16;
            }
        });
        g17.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.j1(d.this, g17, view);
            }
        });
        ChosenBarView root2 = g1().getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        return root2;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        QQGuildThemeManager.d(this.mGuildThemeCallback);
    }
}
