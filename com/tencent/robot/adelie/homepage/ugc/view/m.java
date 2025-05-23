package com.tencent.robot.adelie.homepage.ugc.view;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.adelie.homepage.ugc.view.m;
import com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import d24.GenerateImageItem;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCGenerate$GenerateRequest;
import qshadow.ShadowAIGCGenerate$Media;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005*+,-.B1\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0007J\u0014\u0010\u0011\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u000bH\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0006R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006/"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/m;", "Landroidx/recyclerview/widget/ListAdapter;", "Ld24/g;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "", "newDataList", "setData", "n0", "m0", "k0", "ugcImageState", "j0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "dataList", "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;", "getViewModel", "()Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;", "viewModel", "D", "I", "itemType", "Lcom/tencent/robot/adelie/homepage/ugc/view/m$e;", "E", "Lcom/tencent/robot/adelie/homepage/ugc/view/m$e;", "onItemClicked", "<init>", "(Ljava/util/List;Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;ILcom/tencent/robot/adelie/homepage/ugc/view/m$e;)V", UserInfo.SEX_FEMALE, "a", "b", "c", "d", "e", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class m extends ListAdapter<GenerateImageItem, RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AdelieUgcImageViewModel viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private final int itemType;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final e onItemClicked;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GenerateImageItem> dataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/m$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Ld24/g;", "oldItem", "newItem", "", "b", "p0", "p1", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends DiffUtil.ItemCallback<GenerateImageItem> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull GenerateImageItem p06, @NotNull GenerateImageItem p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull GenerateImageItem oldItem, @NotNull GenerateImageItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.c(), newItem.c());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/m$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "state", "Landroid/graphics/drawable/Drawable;", "drawable", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "url", "Lcom/tencent/image/URLDrawable;", "p", "Ld24/g;", "data", "l", "Lhn2/g;", "E", "Lhn2/g;", "o", "()Lhn2/g;", "binding", "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;", "getViewModel", "()Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;", "viewModel", "<init>", "(Lhn2/g;Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;)V", "G", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final hn2.g binding;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final AdelieUgcImageViewModel viewModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull hn2.g binding, @NotNull AdelieUgcImageViewModel viewModel) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            this.binding = binding;
            this.viewModel = viewModel;
        }

        private final void m(int position, int state, Drawable drawable) {
            if (state != 0) {
                if (state != 1) {
                    if (state != 2) {
                        if (state != 3) {
                            QLog.e("AdelieUgcImageItemAdapter.IconViewHolder", 1, "invalid state");
                            return;
                        }
                        this.binding.f405363c.setVisibility(8);
                        this.binding.f405368h.setVisibility(8);
                        this.binding.f405366f.setVisibility(8);
                        this.binding.f405365e.setVisibility(0);
                        return;
                    }
                    this.binding.f405363c.setVisibility(8);
                    this.binding.f405368h.setVisibility(8);
                    this.binding.f405366f.setVisibility(0);
                    this.binding.f405365e.setVisibility(8);
                    return;
                }
                this.binding.f405363c.setVisibility(0);
                this.binding.f405368h.setVisibility(8);
                this.binding.f405366f.setVisibility(8);
                this.binding.f405365e.setVisibility(8);
                this.binding.f405363c.setImageDrawable(drawable);
                return;
            }
            this.binding.f405363c.setVisibility(8);
            this.binding.f405368h.setVisibility(0);
            this.binding.f405366f.setVisibility(8);
            this.binding.f405365e.setVisibility(8);
            if (drawable != null) {
                this.binding.f405367g.setImageDrawable(drawable);
            }
        }

        private final URLDrawable p(String url) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
            Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(url, option)");
            return drawable2;
        }

        public final void l(@NotNull GenerateImageItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.binding.f405364d.setImageDrawable(p("https://downv6.qq.com/shadow_qqcamera/tmp/gy_ibot_loading_bg.png"));
            if (getPosition() == this.viewModel.getSelectedPosition()) {
                this.viewModel.w2(getPosition(), data);
            }
            if (data.getState() == 0) {
                m(getPosition(), 0, com.tencent.mobileqq.guild.util.qqui.d.d(this.binding.getRoot().getContext(), 1));
                return;
            }
            URLDrawable uRLDrawable = null;
            if (data.getState() == 3) {
                m(getPosition(), 3, null);
                return;
            }
            if (data.getState() != 2 && (data.getState() != 1 || (data.c().getValue() != null && !TextUtils.isEmpty(data.c().getValue())))) {
                String value = data.c().getValue();
                if (value != null) {
                    uRLDrawable = p(value);
                }
                m(getPosition(), 1, uRLDrawable);
                return;
            }
            m(getPosition(), 2, null);
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final hn2.g getBinding() {
            return this.binding;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/m$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ld24/g;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "likeState", ReportConstant.COSTREPORT_PREFIX, "", "r", "unlikeState", "t", DomainData.DOMAIN_NAME, "Lhn2/d;", "E", "Lhn2/d;", "getBinding", "()Lhn2/d;", "binding", "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;", "getViewModel", "()Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;", "viewModel", "<init>", "(Lhn2/d;Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;)V", "G", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final hn2.d binding;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final AdelieUgcImageViewModel viewModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull hn2.d binding, @NotNull AdelieUgcImageViewModel viewModel) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            this.binding = binding;
            this.viewModel = viewModel;
            q.f366599a.a(binding.getRoot().getContext(), binding.f405347c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(GenerateImageItem data, d this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int i3 = 1;
            if (data.getLikeState() == 1) {
                i3 = 2;
            }
            this$0.s(i3);
            data.h(i3);
            this$0.q(data);
            Object systemService = MobileQQ.sMobileQQ.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).vibrate(20L);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(GenerateImageItem data, d this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int i3 = 3;
            if (data.getLikeState() == 3) {
                i3 = 2;
            }
            this$0.s(i3);
            data.h(i3);
            this$0.q(data);
            Object systemService = MobileQQ.sMobileQQ.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).vibrate(20L);
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void q(GenerateImageItem data) {
            boolean z16;
            String str;
            PBRepeatMessageField<ShadowAIGCGenerate$Media> pBRepeatMessageField;
            ShadowAIGCGenerate$Media shadowAIGCGenerate$Media;
            PBStringField pBStringField;
            Map mapOf;
            PBRepeatMessageField<ShadowAIGCGenerate$Media> pBRepeatMessageField2;
            ShadowAIGCGenerate$GenerateRequest generateRequest = data.getGenerateRequest();
            if (generateRequest != null && (pBRepeatMessageField2 = generateRequest.medias) != null && pBRepeatMessageField2.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = "null";
            } else {
                ShadowAIGCGenerate$GenerateRequest generateRequest2 = data.getGenerateRequest();
                if (generateRequest2 != null && (pBRepeatMessageField = generateRequest2.medias) != null && (shadowAIGCGenerate$Media = pBRepeatMessageField.get(0)) != null && (pBStringField = shadowAIGCGenerate$Media.string_data) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
            }
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("dt_pgid", "pg_bas_select_image"), TuplesKt.to("display_position", Integer.valueOf(this.viewModel.getSelectedPosition())), TuplesKt.to("pic_id", data.getExtraInfo().getWorkflow_id()), TuplesKt.to("pad_url", str), TuplesKt.to("generated_url", data.c().getValue()), TuplesKt.to("extra_data_str", this.viewModel.k2()), TuplesKt.to("after_click_state", Integer.valueOf(data.getLikeState())));
            VideoReport.reportEvent("ev_bas_generate_image_feedback", mapOf);
        }

        private final void r(boolean likeState) {
            int i3;
            if (!likeState) {
                i3 = R.drawable.qui_like;
            } else {
                i3 = R.drawable.qui_like_filled;
            }
            try {
                this.binding.f405348d.setImageDrawable(ie0.a.f().o(this.binding.getRoot().getContext(), i3, R.color.qui_common_icon_allwhite_primary, 1001));
            } catch (Exception e16) {
                QLog.e("AdelieUgcImageItemAdapter.ImageViewHolder", 1, "likeIcon setDrawable error = " + e16);
            }
        }

        private final void s(int likeState) {
            if (likeState != 1) {
                if (likeState != 2) {
                    if (likeState == 3) {
                        r(false);
                        t(true);
                        return;
                    }
                    return;
                }
                r(false);
                t(false);
                return;
            }
            r(true);
            t(false);
        }

        private final void t(boolean unlikeState) {
            int i3;
            if (!unlikeState) {
                i3 = R.drawable.qui_dislike_icon;
            } else {
                i3 = R.drawable.qui_dislike_selected_icon_drawable;
            }
            try {
                this.binding.f405350f.setImageDrawable(ie0.a.f().o(this.binding.getRoot().getContext(), i3, R.color.qui_common_icon_allwhite_primary, 1001));
            } catch (Exception e16) {
                QLog.e("AdelieUgcImageItemAdapter.ImageViewHolder", 1, "unlikeIcon setDrawable error = " + e16);
            }
        }

        public final void n(@NotNull final GenerateImageItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            s(data.getLikeState());
            this.binding.f405348d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.d.o(GenerateImageItem.this, this, view);
                }
            });
            this.binding.f405350f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.d.p(GenerateImageItem.this, this, view);
                }
            });
            if (data.getState() != 0 && data.c().getValue() != null && !TextUtils.isEmpty(data.c().getValue()) && data.getState() != 2) {
                QLog.i("AdelieUgcImageItemAdapter.ImageViewHolder", 1, "position " + getPosition() + ", load image " + ((Object) data.c().getValue()) + ".");
                this.binding.f405346b.setVisibility(0);
                this.binding.f405347c.setVisibility(0);
                URLImageView uRLImageView = this.binding.f405346b;
                Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.imagePreview");
                CommonExKt.h(uRLImageView, data.c().getValue(), null, null, null, 14, null);
                return;
            }
            QLog.i("AdelieUgcImageItemAdapter.ImageViewHolder", 1, "position " + getPosition() + ", load image " + ((Object) data.c().getValue()) + ".");
            this.binding.f405347c.setVisibility(4);
            this.binding.f405346b.setVisibility(4);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/m$e;", "", "", "position", "", "onItemClick", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface e {
        void onItemClick(int position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull List<GenerateImageItem> dataList, @NotNull AdelieUgcImageViewModel viewModel, int i3, @Nullable e eVar) {
        super(new a());
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.dataList = dataList;
        this.viewModel = viewModel;
        this.itemType = i3;
        this.onItemClicked = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(c this_apply, m this$0, View view) {
        GenerateImageItem generateImageItem;
        e eVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int adapterPosition = this_apply.getAdapterPosition();
        boolean z16 = false;
        if (adapterPosition >= 0 && adapterPosition < this$0.getItemCount()) {
            z16 = true;
        }
        if (z16) {
            generateImageItem = this$0.dataList.get(adapterPosition);
        } else {
            generateImageItem = null;
        }
        if (generateImageItem != null && (eVar = this$0.onItemClicked) != null) {
            eVar.onItemClick(adapterPosition);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    public final void j0(int ugcImageState) {
        Object lastOrNull;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.dataList);
        GenerateImageItem generateImageItem = (GenerateImageItem) lastOrNull;
        if (generateImageItem != null && generateImageItem.getState() != 1 && generateImageItem.getState() != ugcImageState) {
            generateImageItem.i(ugcImageState);
            notifyItemChanged(this.dataList.size() - 1);
        }
    }

    @Nullable
    public final GenerateImageItem k0(int position) {
        if (position >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(position);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void m0() {
        Object last;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.dataList);
        if (((GenerateImageItem) last).getState() == 0) {
            this.dataList.remove(this.dataList.size() - 1);
            notifyDataSetChanged();
        }
    }

    public final void n0(@NotNull List<GenerateImageItem> newDataList) {
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        int size = this.dataList.size() - 1;
        this.dataList.addAll(size, newDataList);
        QLog.e("AdelieUgcImageItemAdapter", 1, "setMoreData. startPosition " + size);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        GenerateImageItem generateImageItem;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position >= this.dataList.size() || (generateImageItem = this.dataList.get(position)) == null) {
            return;
        }
        if (this.itemType == 0) {
            ((c) holder).l(generateImageItem);
        } else {
            ((d) holder).n(generateImageItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.itemType == 0) {
            hn2.g g16 = hn2.g.g(LayoutInflater.from(parent.getContext()));
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(parent.context))");
            final c cVar = new c(g16, this.viewModel);
            cVar.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.l0(m.c.this, this, view);
                }
            });
            return cVar;
        }
        hn2.d g17 = hn2.d.g(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(g17, "inflate(LayoutInflater.f\u2026t)).apply {\n            }");
        g17.getRoot().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return new d(g17, this.viewModel);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(@NotNull List<GenerateImageItem> newDataList) {
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        this.dataList.clear();
        this.dataList.addAll(newDataList);
        notifyDataSetChanged();
    }
}
