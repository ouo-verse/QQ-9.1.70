package com.tencent.mobileqq.troop.troopcard.ui.medal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMedalInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B\u0017\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0014\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00050/j\b\u0012\u0004\u0012\u00020\u0005`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\"\u0010:\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/ui/medal/TroopInfoCardMedalAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopcard/ui/medal/b;", "", "position", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMedalInfo;", "l0", "", "o0", "", "dp", "k0", "medalInfo", "", "", "m0", "", "medalList", "", "t0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "r0", "getItemCount", "viewHolder", "p0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/troopcard/ui/medal/c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopcard/ui/medal/c;", "getCallback", "()Lcom/tencent/mobileqq/troop/troopcard/ui/medal/c;", "callback", "D", "Lkotlin/Lazy;", "n0", "()I", "totalItemWidth", "E", "I", "itemWidth", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "medalInfoList", "G", "Ljava/lang/String;", "getMedalDetailsPageUrl", "()Ljava/lang/String;", "s0", "(Ljava/lang/String;)V", "medalDetailsPageUrl", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/troop/troopcard/ui/medal/c;)V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"NotifyDataSetChanged"})
/* loaded from: classes19.dex */
public final class TroopInfoCardMedalAdapter extends RecyclerView.Adapter<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c callback;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy totalItemWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private int itemWidth;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<GroupMedalInfo> medalInfoList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String medalDetailsPageUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/ui/medal/TroopInfoCardMedalAdapter$a;", "", "", "GAP_LINE_WIDTH", UserInfo.SEX_FEMALE, "HORIZONTAL_MARGIN", "ITEM_WIDTH", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.ui.medal.TroopInfoCardMedalAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57408);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopInfoCardMedalAdapter(@NotNull Context context, @NotNull c callback) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) callback);
            return;
        }
        this.context = context;
        this.callback = callback;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.troop.troopcard.ui.medal.TroopInfoCardMedalAdapter$totalItemWidth$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInfoCardMedalAdapter.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                int k06;
                int k07;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                int i3 = TroopInfoCardMedalAdapter.this.getContext().getResources().getDisplayMetrics().widthPixels;
                k06 = TroopInfoCardMedalAdapter.this.k0(32.0f);
                int i16 = i3 - k06;
                k07 = TroopInfoCardMedalAdapter.this.k0(13.0f);
                return Integer.valueOf(i16 + k07);
            }
        });
        this.totalItemWidth = lazy;
        this.itemWidth = k0(72.0f);
        this.medalInfoList = new ArrayList<>();
        this.medalDetailsPageUrl = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k0(float dp5) {
        return Utils.n(dp5, this.context.getResources());
    }

    private final GroupMedalInfo l0(int position) {
        boolean z16 = false;
        if (position >= 0 && position < getItemCount()) {
            z16 = true;
        }
        if (z16) {
            GroupMedalInfo groupMedalInfo = this.medalInfoList.get(position);
            Intrinsics.checkNotNullExpressionValue(groupMedalInfo, "medalInfoList[position]");
            return groupMedalInfo;
        }
        return new GroupMedalInfo();
    }

    private final Map<String, String> m0(GroupMedalInfo medalInfo) {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("medal_id", medalInfo.medalID), TuplesKt.to("medal_status", String.valueOf(medalInfo.medalStatus.ordinal())), TuplesKt.to("medal_level", String.valueOf(medalInfo.medalLevel)));
        return mutableMapOf;
    }

    private final int n0() {
        return ((Number) this.totalItemWidth.getValue()).intValue();
    }

    private final boolean o0() {
        int n06 = n0() - (k0(85.0f) * getItemCount());
        if (n06 >= 0 && n06 < k0(72.0f)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(TroopInfoCardMedalAdapter this$0, GroupMedalInfo medalInfo, View view) {
        String replace$default;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(medalInfo, "$medalInfo");
        Intent intent = new Intent(this$0.context, (Class<?>) QQBrowserActivity.class);
        String str = this$0.medalDetailsPageUrl;
        String str2 = medalInfo.medalID;
        Intrinsics.checkNotNullExpressionValue(str2, "medalInfo.medalID");
        replace$default = StringsKt__StringsJVMKt.replace$default(str, "$MEDALID$", str2, false, 4, (Object) null);
        intent.putExtra("url", replace$default);
        this$0.context.startActivity(intent);
        TroopCardDtHelper.f299952a.z(this$0.m0(medalInfo));
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.medalInfoList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b viewHolder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) viewHolder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final GroupMedalInfo l06 = l0(position);
        viewHolder.l(position, l06, this.itemWidth);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.ui.medal.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopInfoCardMedalAdapter.q0(TroopInfoCardMedalAdapter.this, l06, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.h65, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new b(itemView);
    }

    public final void s0(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.medalDetailsPageUrl = str;
        }
    }

    public final void t0(@NotNull List<GroupMedalInfo> medalList) {
        int k06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) medalList);
            return;
        }
        Intrinsics.checkNotNullParameter(medalList, "medalList");
        this.medalInfoList.clear();
        this.medalInfoList.addAll(medalList);
        boolean o06 = o0();
        if (o06) {
            k06 = ((n0() / getItemCount()) - k0(13.0f)) - k0(5.0f);
        } else {
            k06 = k0(72.0f);
        }
        this.itemWidth = k06;
        this.callback.a(!o06);
        notifyDataSetChanged();
    }
}
