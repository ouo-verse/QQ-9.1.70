package com.tencent.robot.adelie.homepage.ugc.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import com.tencent.robot.adelie.homepage.download.AdelieAvatarResourceManager;
import com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarUgcTemplateAdapter;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003$%&B8\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015\u0012!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000b0\u0019\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007J\u0006\u0010\u0014\u001a\u00020\u000bR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R/\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000b0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarUgcTemplateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "holder", "position", "", "onBindViewHolder", "onViewAttachedToWindow", "getItemViewType", "j0", "", "Lcom/tencent/robot/adelie/homepage/ugc/view/z;", "dataList", "k0", "i0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "Lkotlin/Function1;", "Lcom/tencent/robot/adelie/homepage/ugc/view/i;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "selectedCallback", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "D", "a", "AdelieUgcTemplateViewHolder", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieAvatarUgcTemplateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function1<AdelieAvatarUgcTemplateMaterial, Unit> selectedCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<UgcTemplateItemData> itemList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR/\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarUgcTemplateAdapter$AdelieUgcTemplateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/robot/adelie/homepage/ugc/view/z;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", DomainData.DOMAIN_NAME, "p", "Lhn2/f;", "E", "Lhn2/f;", "getBinding", "()Lhn2/f;", "binding", "Lkotlin/Function1;", "Lcom/tencent/robot/adelie/homepage/ugc/view/i;", "Lkotlin/ParameterName;", "name", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "selectedCallback", "<init>", "(Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarUgcTemplateAdapter;Lhn2/f;Lkotlin/jvm/functions/Function1;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class AdelieUgcTemplateViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final hn2.f binding;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final Function1<AdelieAvatarUgcTemplateMaterial, Unit> selectedCallback;
        final /* synthetic */ AdelieAvatarUgcTemplateAdapter G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AdelieUgcTemplateViewHolder(@NotNull AdelieAvatarUgcTemplateAdapter adelieAvatarUgcTemplateAdapter, @NotNull hn2.f binding, Function1<? super AdelieAvatarUgcTemplateMaterial, Unit> selectedCallback) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(selectedCallback, "selectedCallback");
            this.G = adelieAvatarUgcTemplateAdapter;
            this.binding = binding;
            this.selectedCallback = selectedCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(final UgcTemplateItemData item, final AdelieUgcTemplateViewHolder this$0, final View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!NetworkUtil.isNetworkAvailable()) {
                C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarUgcTemplateAdapter$AdelieUgcTemplateViewHolder$bindData$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function1 function1;
                        function1 = AdelieAvatarUgcTemplateAdapter.AdelieUgcTemplateViewHolder.this.selectedCallback;
                        function1.invoke(new AdelieAvatarUgcTemplateMaterial(null, null, null, 7, null));
                    }
                });
            } else {
                new AdelieAvatarResourceManager().n(item.getMaterial(), new Function2<String, AdelieAvatarUgcTemplateMaterial, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarUgcTemplateAdapter$AdelieUgcTemplateViewHolder$bindData$3$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str, AdelieAvatarUgcTemplateMaterial adelieAvatarUgcTemplateMaterial) {
                        invoke2(str, adelieAvatarUgcTemplateMaterial);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String id5, @NotNull final AdelieAvatarUgcTemplateMaterial styleItem) {
                        Map mapOf;
                        Intrinsics.checkNotNullParameter(id5, "id");
                        Intrinsics.checkNotNullParameter(styleItem, "styleItem");
                        String str = UgcTemplateItemData.this.getMaterial().f30533id;
                        Intrinsics.checkNotNullExpressionValue(str, "item.material.id");
                        styleItem.d(str);
                        final AdelieAvatarUgcTemplateAdapter.AdelieUgcTemplateViewHolder adelieUgcTemplateViewHolder = this$0;
                        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarUgcTemplateAdapter$AdelieUgcTemplateViewHolder$bindData$3$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Function1 function1;
                                function1 = AdelieAvatarUgcTemplateAdapter.AdelieUgcTemplateViewHolder.this.selectedCallback;
                                function1.invoke(styleItem);
                            }
                        });
                        View view2 = view;
                        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("display_position", String.valueOf(this$0.getPosition())), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, UgcTemplateItemData.this.getMaterial().f30533id));
                        VideoReport.reportEvent("clck", view2, mapOf);
                    }
                });
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void n(@NotNull final UgcTemplateItemData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.binding.f405359g.setBackgroundColor(ie0.a.f().g(this.binding.f405359g.getContext(), R.color.qui_common_bg_bottom_light, 1000));
            this.binding.f405360h.setText(item.getMaterial().showName);
            Map<String, String> map = item.getMaterial().additionalFields;
            if (map != null && map.containsKey("name")) {
                this.binding.f405360h.setText(item.getMaterial().additionalFields.get("name"));
            }
            RoundImageView roundImageView = this.binding.f405357e;
            Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.itemIcon");
            CommonExKt.h(roundImageView, item.getMaterial().thumbUrl, null, null, null, 14, null);
            hn2.f fVar = this.binding;
            QQBlurViewWrapper qQBlurViewWrapper = fVar.f405356d;
            f.a aVar = new f.a(true, 10.0f, fVar.f405359g, 0, new ColorDrawable(0), Integer.valueOf(R.drawable.j3e));
            aVar.l(true);
            qQBlurViewWrapper.a(aVar);
            this.binding.f405354b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdelieAvatarUgcTemplateAdapter.AdelieUgcTemplateViewHolder.o(UgcTemplateItemData.this, this, view);
                }
            });
            com.tencent.robot.adelie.homepage.utils.h hVar = com.tencent.robot.adelie.homepage.utils.h.f366661a;
            TextView textView = this.binding.f405354b;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.btnUse");
            com.tencent.robot.adelie.homepage.utils.h.b(hVar, textView, "em_bas_use", null, null, null, null, null, 124, null);
            RoundImageView roundImageView2 = this.binding.f405357e;
            Intrinsics.checkNotNullExpressionValue(roundImageView2, "binding.itemIcon");
            com.tencent.robot.adelie.homepage.utils.h.b(hVar, roundImageView2, "em_bas_template_entry", null, null, null, null, null, 124, null);
        }

        public final void p(@NotNull UgcTemplateItemData item) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(item, "item");
            if (item.getHasReportImp()) {
                return;
            }
            RoundImageView roundImageView = this.binding.f405357e;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("display_position", String.valueOf(getPosition())), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, item.getMaterial().f30533id));
            VideoReport.reportEvent("imp", roundImageView, mapOf);
            item.c(true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarUgcTemplateAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/robot/adelie/homepage/ugc/view/z;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Lhn2/e;", "E", "Lhn2/e;", "getBinding", "()Lhn2/e;", "binding", "<init>", "(Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarUgcTemplateAdapter;Lhn2/e;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final hn2.e binding;
        final /* synthetic */ AdelieAvatarUgcTemplateAdapter F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull AdelieAvatarUgcTemplateAdapter adelieAvatarUgcTemplateAdapter, hn2.e binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.F = adelieAvatarUgcTemplateAdapter;
            this.binding = binding;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(a this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!u64.g.f438512a.g()) {
                com.tencent.robot.adelie.homepage.utils.n nVar = com.tencent.robot.adelie.homepage.utils.n.f366680a;
                Context context = this$0.binding.f405352b.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "binding.jumpLink.context");
                nVar.f(context, "mqqguild://guild/share?_wv=3&_wwv=128&appChannel=qqai_robot&inviteCode=221VgckLmZi&mainSourceId=qq_ai&subSourceId=robot");
                VideoReport.reportEvent("clck", view, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull UgcTemplateItemData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            ViewGroup.LayoutParams layoutParams = this.binding.getRoot().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            layoutParams2.setFullSpan(true);
            this.binding.getRoot().setLayoutParams(layoutParams2);
            RelativeLayout it = this.binding.f405352b;
            com.tencent.robot.adelie.homepage.utils.h hVar = com.tencent.robot.adelie.homepage.utils.h.f366661a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            com.tencent.robot.adelie.homepage.utils.h.b(hVar, it, "em_bas_join_channel", null, null, null, null, null, 124, null);
            it.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdelieAvatarUgcTemplateAdapter.a.n(AdelieAvatarUgcTemplateAdapter.a.this, view);
                }
            });
            if (je0.a.a(BaseApplication.getContext())) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(CommonExKt.l(Color.parseColor("#FFFFFF"), 0.1f));
                gradientDrawable.setCornerRadius(c24.a.a(4));
                it.setBackground(gradientDrawable);
            }
        }

        public final void o(@NotNull UgcTemplateItemData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (item.getHasReportImp()) {
                return;
            }
            VideoReport.reportEvent("imp", this.binding.f405352b, null);
            item.c(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdelieAvatarUgcTemplateAdapter(@NotNull List<UgcTemplateItemData> itemList, @NotNull Function1<? super AdelieAvatarUgcTemplateMaterial, Unit> selectedCallback) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(selectedCallback, "selectedCallback");
        this.itemList = itemList;
        this.selectedCallback = selectedCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.itemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (Intrinsics.areEqual(this.itemList.get(position).getMaterial().f30533id, "jumpLink")) {
            return 0;
        }
        return 1;
    }

    public final void i0() {
        Iterator<T> it = this.itemList.iterator();
        while (it.hasNext()) {
            ((UgcTemplateItemData) it.next()).c(false);
        }
    }

    public final void j0(@NotNull RecyclerView.ViewHolder holder) {
        a aVar;
        Intrinsics.checkNotNullParameter(holder, "holder");
        AdelieUgcTemplateViewHolder adelieUgcTemplateViewHolder = null;
        if (holder instanceof a) {
            aVar = (a) holder;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.o(this.itemList.get(((a) holder).getPosition()));
        }
        if (holder instanceof AdelieUgcTemplateViewHolder) {
            adelieUgcTemplateViewHolder = (AdelieUgcTemplateViewHolder) holder;
        }
        if (adelieUgcTemplateViewHolder != null) {
            adelieUgcTemplateViewHolder.p(this.itemList.get(((AdelieUgcTemplateViewHolder) holder).getPosition()));
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void k0(@NotNull List<UgcTemplateItemData> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        if (dataList.isEmpty()) {
            return;
        }
        this.itemList.clear();
        this.itemList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        UgcTemplateItemData ugcTemplateItemData = this.itemList.get(position);
        AdelieUgcTemplateViewHolder adelieUgcTemplateViewHolder = null;
        a aVar = null;
        if (Intrinsics.areEqual(ugcTemplateItemData.getMaterial().f30533id, "jumpLink")) {
            if (holder instanceof a) {
                aVar = (a) holder;
            }
            if (aVar != null) {
                aVar.m(ugcTemplateItemData);
                return;
            }
            return;
        }
        if (holder instanceof AdelieUgcTemplateViewHolder) {
            adelieUgcTemplateViewHolder = (AdelieUgcTemplateViewHolder) holder;
        }
        if (adelieUgcTemplateViewHolder != null) {
            adelieUgcTemplateViewHolder.n(ugcTemplateItemData);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            hn2.e g16 = hn2.e.g(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
            return new a(this, g16);
        }
        hn2.f g17 = hn2.f.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g17, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new AdelieUgcTemplateViewHolder(this, g17, this.selectedCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        j0(holder);
    }
}
