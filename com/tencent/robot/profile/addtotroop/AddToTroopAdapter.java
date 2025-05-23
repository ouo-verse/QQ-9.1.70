package com.tencent.robot.profile.addtotroop;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.common.EventData;
import com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback;
import com.tencent.robot.profile.addtotroop.AddToTroopAdapter;
import com.tencent.robot.profile.data.AddToTroopData;
import com.tencent.robot.profile.data.AddToTroopItemType;
import com.tencent.robot.profile.data.AddToTroopTitleData;
import com.tencent.robot.profile.data.ShareToTroopData;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import com.tencent.robot.relation.api.IRobotRelationService;
import hn2.h;
import hn2.i;
import hn2.j;
import java.util.List;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003123B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J,\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u001c\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0006\u0010\u001d\u001a\u00020\bR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\"\u0010.\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\u001a0\u001a0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00064"}, d2 = {"Lcom/tencent/robot/profile/addtotroop/AddToTroopAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "", "troopUin", "Landroid/graphics/Bitmap;", "i0", "", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", "getItemViewType", "remainingTasks", "type", "uin", "avatar", "onDecodeTaskCompleted", "", "Lcom/tencent/robot/profile/data/a;", "data", "submitList", "destroy", "Landroid/os/Bundle;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Bundle;", "getDtReportData", "()Landroid/os/Bundle;", "k0", "(Landroid/os/Bundle;)V", "dtReportData", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "decoder", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "D", "Landroidx/recyclerview/widget/AsyncListDiffer;", "differ", "<init>", "()V", "a", "AddToTroopViewHolder", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AddToTroopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements DecodeTaskCompletionListener {

    /* renamed from: C, reason: from kotlin metadata */
    private IFaceDecoder decoder;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AsyncListDiffer<com.tencent.robot.profile.data.a> differ = new AsyncListDiffer<>(this, new d());

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bundle dtReportData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/robot/profile/addtotroop/AddToTroopAdapter$AddToTroopViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/robot/profile/data/b;", "data", "Landroid/graphics/Bitmap;", "avatar", "", "p", "Lhn2/h;", "E", "Lhn2/h;", "binding", UserInfo.SEX_FEMALE, "Lcom/tencent/robot/profile/data/b;", "r", "()Lcom/tencent/robot/profile/data/b;", "u", "(Lcom/tencent/robot/profile/data/b;)V", "itemData", "Landroid/os/Bundle;", "G", "Landroid/os/Bundle;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/os/Bundle;", "t", "(Landroid/os/Bundle;)V", "dtReportData", "<init>", "(Lhn2/h;)V", "H", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class AddToTroopViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final h binding;

        /* renamed from: F, reason: from kotlin metadata */
        public AddToTroopData itemData;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private Bundle dtReportData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddToTroopViewHolder(@NotNull h binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            binding.f405371c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.profile.addtotroop.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddToTroopAdapter.AddToTroopViewHolder.n(AddToTroopAdapter.AddToTroopViewHolder.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(final AddToTroopViewHolder this$0, final View view) {
            IRuntimeService iRuntimeService;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!u64.g.f438512a.g()) {
                if (this$0.itemData == null) {
                    QLog.e("AddToTroopViewHolder", 1, " onClick itemData not initialized");
                } else if (!AppNetConnInfo.isNetSupport()) {
                    QQToast.makeText(BaseApplication.getContext(), 1, R.string.ci7, 0).show();
                } else {
                    String robotUin = this$0.r().getRobotUin();
                    String troopUin = this$0.r().getTroopUin();
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
                    } else {
                        iRuntimeService = null;
                    }
                    IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
                    if (iRobotRelationService != null) {
                        IRobotRelationService.a.a(iRobotRelationService, robotUin, troopUin, null, new ISetAddRobotToGroupCallback() { // from class: com.tencent.robot.profile.addtotroop.b
                            @Override // com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback
                            public final void onResult(int i3, String str) {
                                AddToTroopAdapter.AddToTroopViewHolder.s(view, this$0, i3, str);
                            }
                        }, 4, null);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(final View view, final AddToTroopViewHolder this$0, final int i3, final String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.profile.addtotroop.AddToTroopAdapter$AddToTroopViewHolder$1$1$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    h hVar;
                    h hVar2;
                    int i16 = i3;
                    if (i16 != 0) {
                        QLog.e("AddToTroopViewHolder", 1, "setAddRobotToGroup result=" + i16 + " errMsg=" + str);
                        String str2 = str;
                        String string = str2 == null || str2.length() == 0 ? BaseApplication.getContext().getString(R.string.f222136cp) : str;
                        Intrinsics.checkNotNullExpressionValue(string, "if (errMsg.isNullOrEmpty\u2026t_add_failed) else errMsg");
                        QQToast.makeText(view.getContext(), 1, string, 0).show();
                        return;
                    }
                    QQToast.makeText(view.getContext(), 2, "\u6dfb\u52a0\u6210\u529f", 0).show();
                    this$0.r().g(true);
                    hVar = this$0.binding;
                    hVar.f405371c.setVisibility(8);
                    hVar2 = this$0.binding;
                    hVar2.f405372d.setVisibility(0);
                    VideoReport.reportEvent(EventData.builder().withId("ev_sgrp_robot_add_success").withParam("to_uin", this$0.r().getTroopUin()).withParam("add_type", 1).withParam("robot_id", this$0.r().getRobotUin()).withParams(RobotProfileUtils.f368193a.g(this$0.getDtReportData())).build());
                }
            });
        }

        public final void p(@NotNull AddToTroopData data, @NotNull Bitmap avatar) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(avatar, "avatar");
            u(data);
            this.binding.f405373e.setImageBitmap(avatar);
            QUIButton qUIButton = this.binding.f405371c;
            Boolean valueOf = Boolean.valueOf(!data.getIsInTroop());
            qUIButton.setVisibility(0);
            if (((View) au.a(valueOf, qUIButton)) == null) {
                qUIButton.setVisibility(8);
            }
            TextView textView = this.binding.f405372d;
            Boolean valueOf2 = Boolean.valueOf(data.getIsInTroop());
            textView.setVisibility(0);
            if (((View) au.a(valueOf2, textView)) == null) {
                textView.setVisibility(8);
            }
            this.binding.f405374f.setText(data.getTroopName());
        }

        @Nullable
        /* renamed from: q, reason: from getter */
        public final Bundle getDtReportData() {
            return this.dtReportData;
        }

        @NotNull
        public final AddToTroopData r() {
            AddToTroopData addToTroopData = this.itemData;
            if (addToTroopData != null) {
                return addToTroopData;
            }
            Intrinsics.throwUninitializedPropertyAccessException("itemData");
            return null;
        }

        public final void t(@Nullable Bundle bundle) {
            this.dtReportData = bundle;
        }

        public final void u(@NotNull AddToTroopData addToTroopData) {
            Intrinsics.checkNotNullParameter(addToTroopData, "<set-?>");
            this.itemData = addToTroopData;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/profile/addtotroop/AddToTroopAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/robot/profile/data/c;", "data", "", "l", "Lhn2/j;", "E", "Lhn2/j;", "binding", UserInfo.SEX_FEMALE, "Lcom/tencent/robot/profile/data/c;", "getItemData", "()Lcom/tencent/robot/profile/data/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/robot/profile/data/c;)V", "itemData", "<init>", "(Lhn2/j;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final j binding;

        /* renamed from: F, reason: from kotlin metadata */
        public AddToTroopTitleData itemData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull j binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void l(@NotNull AddToTroopTitleData data) {
            int i3;
            Intrinsics.checkNotNullParameter(data, "data");
            m(data);
            View view = this.binding.f405380b;
            Boolean valueOf = Boolean.valueOf(data.getShowDivider());
            view.setVisibility(0);
            if (((View) au.a(valueOf, view)) == null) {
                view.setVisibility(8);
            }
            TextView textView = this.binding.f405381c;
            if (data.getShowDivider()) {
                i3 = R.string.ykz;
            } else {
                i3 = R.string.ykx;
            }
            textView.setText(i3);
        }

        public final void m(@NotNull AddToTroopTitleData addToTroopTitleData) {
            Intrinsics.checkNotNullParameter(addToTroopTitleData, "<set-?>");
            this.itemData = addToTroopTitleData;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/profile/addtotroop/AddToTroopAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/robot/profile/data/q;", "data", "Landroid/graphics/Bitmap;", "avatar", "", DomainData.DOMAIN_NAME, "Lhn2/i;", "E", "Lhn2/i;", "binding", UserInfo.SEX_FEMALE, "Lcom/tencent/robot/profile/data/q;", "itemData", "<init>", "(Lhn2/i;)V", "G", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final i binding;

        /* renamed from: F, reason: from kotlin metadata */
        private ShareToTroopData itemData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull i binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            binding.f405376b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.profile.addtotroop.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddToTroopAdapter.b.m(AddToTroopAdapter.b.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(b this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!u64.g.f438512a.g()) {
                if (this$0.itemData == null) {
                    QLog.e("ShareToTroopViewHolder", 1, "onClick itemData not initialized");
                } else {
                    RobotProfileUtils robotProfileUtils = RobotProfileUtils.f368193a;
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "it.context");
                    ShareToTroopData shareToTroopData = this$0.itemData;
                    ShareToTroopData shareToTroopData2 = null;
                    if (shareToTroopData == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("itemData");
                        shareToTroopData = null;
                    }
                    String robotUin = shareToTroopData.getRobotUin();
                    ShareToTroopData shareToTroopData3 = this$0.itemData;
                    if (shareToTroopData3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("itemData");
                    } else {
                        shareToTroopData2 = shareToTroopData3;
                    }
                    robotProfileUtils.A(context, robotUin, shareToTroopData2.getTroopUin());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void n(@NotNull ShareToTroopData data, @NotNull Bitmap avatar) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(avatar, "avatar");
            this.itemData = data;
            this.binding.f405377c.setImageBitmap(avatar);
            TextView textView = this.binding.f405378d;
            ShareToTroopData shareToTroopData = this.itemData;
            if (shareToTroopData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                shareToTroopData = null;
            }
            textView.setText(shareToTroopData.getTroopName());
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f367855a;

        static {
            int[] iArr = new int[AddToTroopItemType.values().length];
            try {
                iArr[AddToTroopItemType.TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AddToTroopItemType.ADD_ITEM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AddToTroopItemType.SHARE_ITEM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f367855a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/profile/addtotroop/AddToTroopAdapter$d", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/robot/profile/data/a;", "oldItem", "newItem", "", "b", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends DiffUtil.ItemCallback<com.tencent.robot.profile.data.a> {
        d() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull com.tencent.robot.profile.data.a oldItem, @NotNull com.tencent.robot.profile.data.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (!(oldItem instanceof AddToTroopData) || !(newItem instanceof AddToTroopData) || ((AddToTroopData) oldItem).getIsInTroop() == ((AddToTroopData) newItem).getIsInTroop()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull com.tencent.robot.profile.data.a oldItem, @NotNull com.tencent.robot.profile.data.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getItemId(), newItem.getItemId());
        }
    }

    public AddToTroopAdapter() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IFaceDecoder iFaceDecoder = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
            Intrinsics.checkNotNullExpressionValue(iQQAvatarService, "app.getRuntimeService(IQ\u2026nt.MAIN).getInstance(app)");
            this.decoder = iQQAvatarService;
            if (iQQAvatarService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
            } else {
                iFaceDecoder = iQQAvatarService;
            }
            iFaceDecoder.setDecodeTaskCompletionListener(this);
        }
    }

    private final Bitmap i0(String troopUin) {
        IFaceDecoder iFaceDecoder = this.decoder;
        IFaceDecoder iFaceDecoder2 = null;
        if (iFaceDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            iFaceDecoder = null;
        }
        Bitmap avatar = iFaceDecoder.getBitmapFromCache(4, troopUin);
        if (avatar == null) {
            avatar = BaseImageUtil.getDefaultFaceBitmap();
            IFaceDecoder iFaceDecoder3 = this.decoder;
            if (iFaceDecoder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
                iFaceDecoder3 = null;
            }
            if (!iFaceDecoder3.isPausing()) {
                IFaceDecoder iFaceDecoder4 = this.decoder;
                if (iFaceDecoder4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("decoder");
                } else {
                    iFaceDecoder2 = iFaceDecoder4;
                }
                iFaceDecoder2.requestDecodeFace(troopUin, 4, false);
            }
        }
        Intrinsics.checkNotNullExpressionValue(avatar, "avatar");
        return avatar;
    }

    private final void j0(String troopUin) {
        int size = this.differ.getCurrentList().size();
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.robot.profile.data.a aVar = this.differ.getCurrentList().get(i3);
            if (aVar instanceof AddToTroopData) {
                if (Intrinsics.areEqual(((AddToTroopData) aVar).getTroopUin(), troopUin)) {
                    notifyItemChanged(i3);
                    return;
                }
            } else if ((aVar instanceof ShareToTroopData) && Intrinsics.areEqual(((ShareToTroopData) aVar).getTroopUin(), troopUin)) {
                notifyItemChanged(i3);
                return;
            }
        }
    }

    public final void destroy() {
        IFaceDecoder iFaceDecoder = this.decoder;
        if (iFaceDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            iFaceDecoder = null;
        }
        iFaceDecoder.destory();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.differ.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.differ.getCurrentList().get(position).getItemType().getType();
    }

    public final void k0(@Nullable Bundle bundle) {
        this.dtReportData = bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.robot.profile.data.a aVar = this.differ.getCurrentList().get(position);
        int i3 = c.f367855a[aVar.getItemType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.robot.profile.data.ShareToTroopData");
                    ShareToTroopData shareToTroopData = (ShareToTroopData) aVar;
                    ((b) holder).n(shareToTroopData, i0(shareToTroopData.getTroopUin()));
                    return;
                }
                return;
            }
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.robot.profile.data.AddToTroopData");
            AddToTroopData addToTroopData = (AddToTroopData) aVar;
            ((AddToTroopViewHolder) holder).p(addToTroopData, i0(addToTroopData.getTroopUin()));
            return;
        }
        Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.robot.profile.data.AddToTroopTitleData");
        ((a) holder).l((AddToTroopTitleData) aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == AddToTroopItemType.TITLE.getType()) {
            j g16 = j.g(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
            return new a(g16);
        }
        if (viewType == AddToTroopItemType.ADD_ITEM.getType()) {
            h g17 = h.g(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(g17, "inflate(LayoutInflater.f\u2026.context), parent, false)");
            AddToTroopViewHolder addToTroopViewHolder = new AddToTroopViewHolder(g17);
            addToTroopViewHolder.t(this.dtReportData);
            return addToTroopViewHolder;
        }
        if (viewType == AddToTroopItemType.SHARE_ITEM.getType()) {
            i g18 = i.g(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(g18, "inflate(LayoutInflater.f\u2026.context), parent, false)");
            return new b(g18);
        }
        j g19 = j.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g19, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new a(g19);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, @Nullable String uin, @Nullable Bitmap avatar) {
        boolean z16;
        IFaceDecoder iFaceDecoder = this.decoder;
        if (iFaceDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            iFaceDecoder = null;
        }
        if (!iFaceDecoder.isPausing()) {
            if (uin != null && uin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                j0(uin);
            }
        }
    }

    public final void submitList(@NotNull List<? extends com.tencent.robot.profile.data.a> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.differ.submitList(data);
    }
}
