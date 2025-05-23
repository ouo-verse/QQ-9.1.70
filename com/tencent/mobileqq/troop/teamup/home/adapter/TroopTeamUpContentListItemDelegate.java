package com.tencent.mobileqq.troop.teamup.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.teamup.detail.fragment.TroopTeamUpDetailFragment;
import com.tencent.mobileqq.troop.teamup.home.data.TroopTeamUpData;
import com.tencent.mobileqq.troop.teamup.home.view.MediaDisplayView;
import com.tencent.mobileqq.troop.teamup.member.fragment.TroopTeamUpMemberListFragment;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u000b2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001*B\u0017\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010'\u001a\u00020#\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J.\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010H\u0014R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/adapter/TroopTeamUpContentListItemDelegate;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/troop/teamup/home/data/TroopTeamUpData;", "Lcom/tencent/mobileqq/troop/teamup/home/adapter/TroopTeamUpContentListItemViewHolder;", "Landroid/view/View;", "view", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "e", "Lcom/tencent/mobileqq/troop/teamup/home/view/MediaDisplayView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "", "eid", IECDtReport.ACTION_IDENTIFIER, "g", "", "items", "", "position", "", h.F, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "l", "holder", "", "payloads", "i", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "J", "getTroopId", "()J", "troopId", "<init>", "(Landroidx/lifecycle/LifecycleOwner;J)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpContentListItemDelegate extends AbsListItemAdapterDelegate<TroopTeamUpData, TroopTeamUpData, TroopTeamUpContentListItemViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long troopId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/adapter/TroopTeamUpContentListItemDelegate$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.home.adapter.TroopTeamUpContentListItemDelegate$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f298955a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55754);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TroopTeamUpData.TroopTeamUpState.values().length];
            try {
                iArr[TroopTeamUpData.TroopTeamUpState.ALREADY_UPLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TroopTeamUpData.TroopTeamUpState.ALREADY_APPLIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TroopTeamUpData.TroopTeamUpState.CAN_APPLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TroopTeamUpData.TroopTeamUpState.CAN_APPLY_WITH_IMG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f298955a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55764);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopTeamUpContentListItemDelegate(@NotNull LifecycleOwner lifecycleOwner, long j3) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, lifecycleOwner, Long.valueOf(j3));
        } else {
            this.lifecycleOwner = lifecycleOwner;
            this.troopId = j3;
        }
    }

    private final void e(View view, TroopTeamUpData item) {
        String str;
        int i3 = b.f298955a[item.i().ordinal()];
        if (i3 != 1 && i3 != 2) {
            str = "em_group_goto_regist";
            if (i3 != 3 && i3 != 4) {
                return;
            }
        } else {
            str = "em_group_already_regist";
        }
        g(view, item, str, "team_up_apply_button");
    }

    private final void f(MediaDisplayView view, TroopTeamUpData item) {
        g(view, item, "em_group_teamup_list", "team_up_content");
        LinearLayout linearLayout = view.g().f437426d;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "view.foldViewBinding.mediaBottomView");
        g(linearLayout, item, "em_group_view_details", "item_expand");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(View view, TroopTeamUpData item, String eid, String identifier) {
        HashMap hashMapOf;
        VideoReport.setElementId(view, eid);
        VideoReport.setElementReuseIdentifier(view, identifier + "_" + item.f());
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("teamup_id", item.f()), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, Integer.valueOf(item.e().templateId)));
        VideoReport.setElementParams(view, hashMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(TroopTeamUpData item, TroopTeamUpContentListItemViewHolder holder, TroopTeamUpContentListItemDelegate this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        if (item.l()) {
            TroopTeamUpMemberListFragment.Companion companion = TroopTeamUpMemberListFragment.INSTANCE;
            Context context = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
            companion.a(context, item.e(), false);
        } else {
            TroopTeamUpDetailFragment.Companion companion2 = TroopTeamUpDetailFragment.INSTANCE;
            Context context2 = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "v.context");
            companion2.a(context2, String.valueOf(this$0.troopId), item.e());
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(TroopTeamUpContentListItemDelegate this$0, TroopTeamUpData item, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(v3, "v");
        TroopTeamUpDetailFragment.Companion companion = TroopTeamUpDetailFragment.INSTANCE;
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        companion.a(context, String.valueOf(this$0.troopId), item.e());
        EventCollector.getInstance().onViewClicked(v3);
    }

    private final void m(MediaDisplayView view, final TroopTeamUpData item) {
        view.f().g(new Function1<View, Unit>(item) { // from class: com.tencent.mobileqq.troop.teamup.home.adapter.TroopTeamUpContentListItemDelegate$setImageElementReport$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TroopTeamUpData $item;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$item = item;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpContentListItemDelegate.this, (Object) item);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View imageView) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) imageView);
                } else {
                    Intrinsics.checkNotNullParameter(imageView, "imageView");
                    TroopTeamUpContentListItemDelegate.this.g(imageView, this.$item, "em_group_pic_preview", String.valueOf(imageView.hashCode()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull TroopTeamUpData item, @NotNull List<TroopTeamUpData> items, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, item, items, Integer.valueOf(position))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull final TroopTeamUpData item, @NotNull final TroopTeamUpContentListItemViewHolder holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, item, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        m(holder.u(), item);
        holder.q(item);
        View v3 = holder.v();
        Intrinsics.checkNotNullExpressionValue(v3, "holder.titleArea");
        e(v3, item);
        f(holder.u(), item);
        holder.y(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.home.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpContentListItemDelegate.j(TroopTeamUpData.this, holder, this, view);
            }
        });
        holder.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.home.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpContentListItemDelegate.k(TroopTeamUpContentListItemDelegate.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public TroopTeamUpContentListItemViewHolder onCreateViewHolder(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopTeamUpContentListItemViewHolder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.i1b, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new TroopTeamUpContentListItemViewHolder(view);
    }
}
