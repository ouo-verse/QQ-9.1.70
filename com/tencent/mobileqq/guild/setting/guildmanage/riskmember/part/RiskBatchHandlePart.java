package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildRemoveGuildDialogFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.BatchHandleRiskData;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.GuildRiskMemberBottomLayout;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.k;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/part/RiskBatchHandlePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/k;", "selectedMemberInfo", "", "F9", "", "isBlack", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "d", "I", "layoutId", "Lpz1/c;", "e", "Lpz1/c;", "C9", "()Lpz1/c;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "getViewLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskMemberBottomLayout;", tl.h.F, "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskMemberBottomLayout;", "batchHandleLayout", "<init>", "(ILpz1/c;Landroidx/lifecycle/LifecycleOwner;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class RiskBatchHandlePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int layoutId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final pz1.c viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildRiskMemberBottomLayout batchHandleLayout;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/riskmember/part/RiskBatchHandlePart$a", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/f;", "", "a", "onCancel", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/k;", "selectedMemberInfo", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements com.tencent.mobileqq.guild.setting.guildmanage.riskmember.f {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.f
        public void a() {
            RiskBatchHandlePart.this.getViewModel().m2(true);
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.f
        public void b(@NotNull k selectedMemberInfo) {
            Intrinsics.checkNotNullParameter(selectedMemberInfo, "selectedMemberInfo");
            RiskBatchHandlePart.this.F9(selectedMemberInfo);
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.f
        public void onCancel() {
            RiskBatchHandlePart.this.getViewModel().m2(false);
        }
    }

    public RiskBatchHandlePart(int i3, @NotNull pz1.c viewModel, @NotNull LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.layoutId = i3;
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void E9(k selectedMemberInfo, boolean isBlack) {
        if (!(getActivity() instanceof FragmentActivity)) {
            return;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        GuildRemoveGuildDialogFragment.wh((FragmentActivity) activity, this.viewModel.getGuildId(), (int) selectedMemberInfo.c(), isBlack, new b(selectedMemberInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(final k selectedMemberInfo) {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton(R.string.f140270di, 3);
        actionSheet.addButton(R.string.f1520219_, 3);
        if (selectedMemberInfo.c() > 1) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f140640ei);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_batch_remove_guild_title)");
            String format = String.format(qqStr, Arrays.copyOf(new Object[]{Long.valueOf(selectedMemberInfo.c())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            actionSheet.setMainTitle(format);
        }
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.b
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                RiskBatchHandlePart.G9(k.this, this, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.f140850f3);
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(k selectedMemberInfo, RiskBatchHandlePart this$0, ActionSheet actionSheet, View view, int i3) {
        List<Long> list;
        List<Long> list2;
        Intrinsics.checkNotNullParameter(selectedMemberInfo, "$selectedMemberInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 != 0) {
            if (i3 == 1) {
                if (selectedMemberInfo.c() > 1) {
                    pz1.c cVar = this$0.viewModel;
                    boolean isChooseSelectAll = selectedMemberInfo.getIsChooseSelectAll();
                    list2 = CollectionsKt___CollectionsKt.toList(selectedMemberInfo.d());
                    cVar.f2(true, 0, true, isChooseSelectAll, list2);
                } else {
                    this$0.E9(selectedMemberInfo, true);
                }
                actionSheet.dismiss();
                return;
            }
            return;
        }
        if (selectedMemberInfo.c() > 1) {
            pz1.c cVar2 = this$0.viewModel;
            boolean isChooseSelectAll2 = selectedMemberInfo.getIsChooseSelectAll();
            list = CollectionsKt___CollectionsKt.toList(selectedMemberInfo.d());
            cVar2.f2(false, 0, true, isChooseSelectAll2, list);
        } else {
            this$0.E9(selectedMemberInfo, false);
        }
        actionSheet.dismiss();
    }

    @NotNull
    /* renamed from: C9, reason: from getter */
    public final pz1.c getViewModel() {
        return this.viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(this.layoutId);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(layoutId)");
        GuildRiskMemberBottomLayout guildRiskMemberBottomLayout = (GuildRiskMemberBottomLayout) findViewById;
        this.batchHandleLayout = guildRiskMemberBottomLayout;
        if (guildRiskMemberBottomLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("batchHandleLayout");
            guildRiskMemberBottomLayout = null;
        }
        guildRiskMemberBottomLayout.setOnClickCallback(new a());
        MutableLiveData<BatchHandleRiskData> X1 = this.viewModel.X1();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<BatchHandleRiskData, Unit> function1 = new Function1<BatchHandleRiskData, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.RiskBatchHandlePart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BatchHandleRiskData batchHandleRiskData) {
                invoke2(batchHandleRiskData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BatchHandleRiskData batchHandleRiskData) {
                GuildRiskMemberBottomLayout guildRiskMemberBottomLayout2;
                guildRiskMemberBottomLayout2 = RiskBatchHandlePart.this.batchHandleLayout;
                if (guildRiskMemberBottomLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("batchHandleLayout");
                    guildRiskMemberBottomLayout2 = null;
                }
                guildRiskMemberBottomLayout2.a(batchHandleRiskData);
            }
        };
        X1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RiskBatchHandlePart.D9(Function1.this, obj);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/riskmember/part/RiskBatchHandlePart$b", "Llv1/b;", "", "isBlack", "", "msgRevokeType", "", "a", "onDismiss", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements lv1.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f234208b;

        b(k kVar) {
            this.f234208b = kVar;
        }

        @Override // lv1.b
        public void a(boolean isBlack, int msgRevokeType) {
            List<Long> list;
            pz1.c viewModel = RiskBatchHandlePart.this.getViewModel();
            boolean isChooseSelectAll = this.f234208b.getIsChooseSelectAll();
            list = CollectionsKt___CollectionsKt.toList(this.f234208b.d());
            viewModel.f2(isBlack, msgRevokeType, true, isChooseSelectAll, list);
        }

        @Override // lv1.b
        public void onDismiss() {
        }
    }
}
