package com.tencent.robot.slash.dialog.content.avatarbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003ABCB\u0007\u00a2\u0006\u0004\b>\u0010?J\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u001e\u0010\u001b\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\b\u0002\u0010\u001a\u001a\u00020\nJ\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010'\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016R\u0014\u0010*\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102RT\u0010=\u001a4\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006D"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/b$a;", "Lfn2/a;", "", "position", "", "k0", "j0", "x0", "", "l0", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "n0", "o0", "Landroid/view/View;", "view", "v0", "u0", "w0", "", "Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;", "m0", "uiDataList", "resetSelectPositionToFirst", "y0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "s0", "getItemCount", "holder", "t0", "p0", "", "", "payloads", "q0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Object;", "mSelectItemChangedPayload", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mRobotInfoList", "D", "I", "mSelectedPosition", "E", "Landroid/graphics/drawable/Drawable;", "mRecentTitleDrawable", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function2;", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemClickListener", "<init>", "()V", "G", "a", "b", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends RecyclerView.Adapter<a> {

    @NotNull
    private static final C9781b G = new C9781b(null);

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Drawable mRecentTitleDrawable;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function2<? super View, ? super Integer, Unit> onItemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object mSelectItemChangedPayload = new Object();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<UIModelData> mRobotInfoList = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    private int mSelectedPosition = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lfn2/a;", "E", "Lfn2/a;", "l", "()Lfn2/a;", "mBinding", "<init>", "(Lfn2/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final fn2.a mBinding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull fn2.a mBinding) {
            super(mBinding.getRoot());
            Intrinsics.checkNotNullParameter(mBinding, "mBinding");
            this.mBinding = mBinding;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final fn2.a getMBinding() {
            return this.mBinding;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/b$b;", "", "", "ALPHA_SELECTED", UserInfo.SEX_FEMALE, "ALPHA_UNSELECTED", "", "INVALID_POSITION", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.slash.dialog.content.avatarbar.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    private static final class C9781b {
        public /* synthetic */ C9781b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        C9781b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "uin", "name", "c", "Z", "()Z", "setRecentRecordTitle", "(Z)V", "isRecentRecordTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.slash.dialog.content.avatarbar.b$c, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class UIModelData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String name;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isRecentRecordTitle;

        public UIModelData(@Nullable String str, @Nullable String str2, boolean z16) {
            this.uin = str;
            this.name = str2;
            this.isRecentRecordTitle = z16;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsRecentRecordTitle() {
            return this.isRecentRecordTitle;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UIModelData)) {
                return false;
            }
            UIModelData uIModelData = (UIModelData) other;
            if (Intrinsics.areEqual(this.uin, uIModelData.uin) && Intrinsics.areEqual(this.name, uIModelData.name) && this.isRecentRecordTitle == uIModelData.isRecentRecordTitle) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            String str = this.uin;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.name;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            int i17 = (i16 + i3) * 31;
            boolean z16 = this.isRecentRecordTitle;
            int i18 = z16;
            if (z16 != 0) {
                i18 = 1;
            }
            return i17 + i18;
        }

        @NotNull
        public String toString() {
            return "UIModelData(uin=" + this.uin + ", name=" + this.name + ", isRecentRecordTitle=" + this.isRecentRecordTitle + ")";
        }
    }

    private final void j0(fn2.a aVar, int i3) {
        float f16;
        ImageView imageView = aVar.f400107c;
        if (this.mSelectedPosition == i3) {
            f16 = 1.0f;
        } else {
            f16 = 0.7f;
        }
        imageView.setAlpha(f16);
    }

    private final void k0(fn2.a aVar, int i3) {
        int i16;
        View view = aVar.f400106b;
        if (this.mSelectedPosition == i3) {
            i16 = 0;
        } else {
            i16 = 4;
        }
        view.setVisibility(i16);
        j0(aVar, i3);
    }

    private final boolean l0(int position) {
        if (position < 0 || position > getItemCount() - 1) {
            return true;
        }
        return false;
    }

    private final Drawable n0(Context context, int position) {
        Drawable b16;
        UIModelData uIModelData = this.mRobotInfoList.get(position);
        if (uIModelData.getIsRecentRecordTitle()) {
            b16 = o0(context);
            if (b16 != null) {
                b16.setColorFilter(new PorterDuffColorFilter(ResourcesCompat.getColor(context.getResources(), R.color.qui_common_brand_standard, null), PorterDuff.Mode.SRC_IN));
            }
            b16 = null;
        } else {
            String uin = uIModelData.getUin();
            if (uin != null) {
                b16 = u64.c.b(uin);
            }
            b16 = null;
        }
        if (b16 == null) {
            return ResourcesCompat.getDrawable(context.getResources(), R.drawable.guild_robot_default_avatar, null);
        }
        return b16;
    }

    private final Drawable o0(Context context) {
        if (this.mRecentTitleDrawable == null) {
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            this.mRecentTitleDrawable = u64.c.d(resources, R.drawable.qui_time);
        }
        return this.mRecentTitleDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(b this$0, a holder, int i3, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        this$0.u0(view, i3);
        Function2<? super View, ? super Integer, Unit> function2 = this$0.onItemClickListener;
        if (function2 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function2.invoke(it, Integer.valueOf(i3));
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void u0(View view, int position) {
        UIModelData uIModelData = this.mRobotInfoList.get(position);
        String name = uIModelData.getName();
        String str = "";
        if (name == null) {
            name = "";
        }
        String uin = uIModelData.getUin();
        if (uin != null) {
            str = uin;
        }
        boolean isRecentRecordTitle = uIModelData.getIsRecentRecordTitle();
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_robot_name", name);
        hashMap.put("sgrp_robot_id", str);
        hashMap.put("sgrp_robot_recent_function_tab", Integer.valueOf(isRecentRecordTitle ? 1 : 0));
        hashMap.put("sgrp_robot_tab_number", Integer.valueOf(position));
        VideoReport.setElementId(view, "em_sgrp_robot_slash_tab");
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }

    private final void v0(View view, int position) {
        UIModelData uIModelData = this.mRobotInfoList.get(position);
        String name = uIModelData.getName();
        String str = "";
        if (name == null) {
            name = "";
        }
        String uin = uIModelData.getUin();
        if (uin != null) {
            str = uin;
        }
        boolean isRecentRecordTitle = uIModelData.getIsRecentRecordTitle();
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_robot_name", name);
        hashMap.put("sgrp_robot_id", str);
        hashMap.put("sgrp_robot_recent_function_tab", Integer.valueOf(isRecentRecordTitle ? 1 : 0));
        hashMap.put("sgrp_robot_tab_number", Integer.valueOf(position));
        VideoReport.setElementId(view, "em_sgrp_robot_slash_tab");
        VideoReport.reportEvent("dt_imp", view, hashMap);
    }

    private final void x0(fn2.a aVar, int i3) {
        ImageView imageView = aVar.f400107c;
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.robotAvatarIv.context");
        imageView.setImageDrawable(n0(context, i3));
        aVar.f400107c.invalidate();
    }

    public static /* synthetic */ void z0(b bVar, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        bVar.y0(list, z16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mRobotInfoList.size();
    }

    @NotNull
    public final List<UIModelData> m0() {
        return this.mRobotInfoList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final a holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (l0(position)) {
            return;
        }
        holder.getMBinding().getRoot().setTag(R.id.f86134qu, Integer.valueOf(position));
        fn2.a mBinding = holder.getMBinding();
        x0(mBinding, position);
        k0(mBinding, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.slash.dialog.content.avatarbar.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.r0(b.this, holder, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.contains(this.mSelectItemChangedPayload)) {
            k0(holder.getMBinding(), position);
            if (this.mRobotInfoList.get(position).getIsRecentRecordTitle()) {
                x0(holder.getMBinding(), position);
                return;
            }
            return;
        }
        onBindViewHolder(holder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        fn2.a g16 = fn2.a.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        VideoReport.setElementClickPolicy(g16.getRoot(), ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(g16.getRoot(), ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(g16.getRoot(), EndExposurePolicy.REPORT_NONE);
        return new a(g16);
    }

    public final void setOnItemClickListener(@Nullable Function2<? super View, ? super Integer, Unit> function2) {
        this.onItemClickListener = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull a holder) {
        Integer num;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        Object tag = holder.itemView.getTag(R.id.f86134qu);
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            int intValue = num.intValue();
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            v0(view, intValue);
        }
    }

    public final void w0(int position) {
        int i3 = this.mSelectedPosition;
        if (position > getItemCount() - 1 || position < 0) {
            QLog.e("AvatarBarAdapter", 1, "[selectPosition]: set an invalid position: " + position);
            position = -1;
        }
        this.mSelectedPosition = position;
        if (i3 != -1) {
            notifyItemChanged(i3, this.mSelectItemChangedPayload);
        }
        int i16 = this.mSelectedPosition;
        if (i16 != -1) {
            notifyItemChanged(i16, this.mSelectItemChangedPayload);
        }
    }

    public final void y0(@NotNull List<UIModelData> uiDataList, boolean resetSelectPositionToFirst) {
        int i3;
        Intrinsics.checkNotNullParameter(uiDataList, "uiDataList");
        this.mRobotInfoList = uiDataList;
        if (resetSelectPositionToFirst) {
            if (!uiDataList.isEmpty()) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            this.mSelectedPosition = i3;
        }
        notifyDataSetChanged();
    }
}
