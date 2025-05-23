package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qcircleshadow.lib.QCircleHostChatHelper;
import com.tencent.biz.qqcircle.immersive.personal.data.QFSTroopItemInfo;
import com.tencent.biz.qqcircle.immersive.personal.data.TroopItemType;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0010\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003/01B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\u000f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ@\u0010\u0016\u001a\u00020\u000328\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010J\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$RH\u0010(\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00062"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/adapter/r;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "m0", "Landroid/widget/TextView;", "btnView", "Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "info", "p0", "Landroid/content/Context;", "context", "l0", "", "list", "setData", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "position", "click", "q0", "r0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "getItemCount", "", "getItemId", "holder", "onBindViewHolder", "getItemViewType", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "data", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "onButtonClick", "D", "Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "titleInfo", "<init>", "()V", "E", "a", "b", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class r extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function2<? super QFSTroopItemInfo, ? super Integer, Unit> onButtonClick;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QFSTroopItemInfo titleInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QFSTroopItemInfo> data = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020\u0013\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/adapter/r$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "info", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "E", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "headView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "nameView", "G", "memberView", "H", "descView", "Landroid/view/View;", "I", "Landroid/view/View;", "fullView", "J", "activeView", "K", "o", "()Landroid/widget/TextView;", "setBtnView", "(Landroid/widget/TextView;)V", "btnView", "Landroid/view/ViewGroup;", "L", "Landroid/view/ViewGroup;", "p", "()Landroid/view/ViewGroup;", "setBtnViewContainer", "(Landroid/view/ViewGroup;)V", "btnViewContainer", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private QCircleAvatarView headView;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private TextView nameView;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private TextView memberView;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private TextView descView;

        /* renamed from: I, reason: from kotlin metadata */
        @Nullable
        private View fullView;

        /* renamed from: J, reason: from kotlin metadata */
        @Nullable
        private View activeView;

        /* renamed from: K, reason: from kotlin metadata */
        @Nullable
        private TextView btnView;

        /* renamed from: L, reason: from kotlin metadata */
        @Nullable
        private ViewGroup btnViewContainer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.headView = (QCircleAvatarView) itemView.findViewById(R.id.f4958233);
            this.nameView = (TextView) itemView.findViewById(R.id.f4962237);
            this.memberView = (TextView) itemView.findViewById(R.id.f4960235);
            this.descView = (TextView) itemView.findViewById(R.id.f4956231);
            this.fullView = itemView.findViewById(R.id.f4957232);
            this.activeView = itemView.findViewById(R.id.f495022v);
            this.btnView = (TextView) itemView.findViewById(R.id.f495122w);
            this.btnViewContainer = (ViewGroup) itemView.findViewById(R.id.f495222x);
        }

        private final void l(QFSTroopItemInfo info) {
            CharSequence charSequence;
            VideoReport.setElementId(this.btnView, QCircleDaTongConstant.ElementId.EM_XSJ_JOIN_GROUP_BUTTON);
            Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_GROUP_ID, Long.valueOf(info.getId()));
            TextView textView = this.btnView;
            if (textView != null) {
                charSequence = textView.getText();
            } else {
                charSequence = null;
            }
            if (charSequence == null) {
                charSequence = "";
            }
            map.put("xsj_button_text", charSequence);
            VideoReport.setElementParams(this.btnView, map);
            VideoReport.setElementExposePolicy(this.btnView, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(this.btnView, ClickPolicy.REPORT_NONE);
        }

        public final void m(@NotNull QFSTroopItemInfo info) {
            boolean isBlank;
            Intrinsics.checkNotNullParameter(info, "info");
            QCircleAvatarView qCircleAvatarView = this.headView;
            if (qCircleAvatarView != null) {
                qCircleAvatarView.setAvatarByUrl(info.getHeadUrl(), new Size(e83.a.b(44), e83.a.b(44)));
            }
            TextView textView = this.nameView;
            if (textView != null) {
                textView.setText(info.getName());
            }
            TextView textView2 = this.memberView;
            if (textView2 != null) {
                textView2.setText(String.valueOf(info.getMemberNum()));
            }
            isBlank = StringsKt__StringsJVMKt.isBlank(info.getDesc());
            if (!isBlank) {
                TextView textView3 = this.descView;
                if (textView3 != null) {
                    textView3.setText(info.getDesc());
                }
                TextView textView4 = this.descView;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
            } else {
                TextView textView5 = this.descView;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
            }
            if (info.getIsBound()) {
                TextView textView6 = this.btnView;
                if (textView6 != null) {
                    textView6.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f19233478));
                }
                TextView textView7 = this.btnView;
                if (textView7 != null) {
                    textView7.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qui_button_bg_secondary_default_bg_corner_4_border_1));
                }
                TextView textView8 = this.btnView;
                if (textView8 != null) {
                    textView8.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.qui_button_text_secondary_default));
                }
            } else {
                TextView textView9 = this.btnView;
                if (textView9 != null) {
                    textView9.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1923547_));
                }
                TextView textView10 = this.btnView;
                if (textView10 != null) {
                    textView10.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qui_button_bg_primary_default_bg_corner_4));
                }
                TextView textView11 = this.btnView;
                if (textView11 != null) {
                    textView11.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.qui_button_text_primary_default));
                }
            }
            if (info.getIsFull()) {
                View view = this.fullView;
                if (view != null) {
                    view.setVisibility(0);
                }
            } else {
                View view2 = this.fullView;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            if (info.getIsActive()) {
                View view3 = this.activeView;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
            } else {
                View view4 = this.activeView;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
            }
            l(info);
        }

        @Nullable
        /* renamed from: o, reason: from getter */
        public final TextView getBtnView() {
            return this.btnView;
        }

        @Nullable
        /* renamed from: p, reason: from getter */
        public final ViewGroup getBtnViewContainer() {
            return this.btnViewContainer;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/adapter/r$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "info", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private TextView titleView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.titleView = (TextView) itemView.findViewById(R.id.f4964239);
        }

        public final void l(@NotNull QFSTroopItemInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            TextView textView = this.titleView;
            if (textView != null) {
                textView.setText(info.getText());
            }
        }
    }

    private final void l0(Context context, QFSTroopItemInfo info) {
        String valueOf = String.valueOf(info.getId());
        Bundle bundle = new Bundle();
        bundle.putInt("uintype", 1);
        QCircleHostChatHelper.prepareAndJumpAIOActivity(context, valueOf, "", valueOf, bundle, true);
    }

    private final void m0() {
        boolean z16;
        Object obj;
        QFSTroopItemInfo qFSTroopItemInfo;
        boolean z17;
        boolean z18;
        List<QFSTroopItemInfo> list = this.data;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z19 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((QFSTroopItemInfo) next).getType() == TroopItemType.DATA) {
                z19 = true;
            }
            if (z19) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                if (!((QFSTroopItemInfo) it5.next()).getIsBound()) {
                    z16 = false;
                    break;
                }
            }
        }
        z16 = true;
        Object obj2 = null;
        if (z16) {
            Iterator<T> it6 = this.data.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    break;
                }
                Object next2 = it6.next();
                if (((QFSTroopItemInfo) next2).getType() == TroopItemType.TEXT) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    obj2 = next2;
                    break;
                }
            }
            QFSTroopItemInfo qFSTroopItemInfo2 = (QFSTroopItemInfo) obj2;
            if (qFSTroopItemInfo2 != null) {
                this.titleInfo = qFSTroopItemInfo2;
                int indexOf = this.data.indexOf(qFSTroopItemInfo2);
                this.data.remove(indexOf);
                notifyItemRemoved(indexOf);
                return;
            }
            return;
        }
        Iterator<T> it7 = this.data.iterator();
        while (true) {
            if (it7.hasNext()) {
                obj = it7.next();
                if (((QFSTroopItemInfo) obj).getType() == TroopItemType.TEXT) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null && (qFSTroopItemInfo = this.titleInfo) != null) {
            Iterator<T> it8 = this.data.iterator();
            while (true) {
                if (!it8.hasNext()) {
                    break;
                }
                Object next3 = it8.next();
                if (!((QFSTroopItemInfo) next3).getIsBound()) {
                    obj2 = next3;
                    break;
                }
            }
            QFSTroopItemInfo qFSTroopItemInfo3 = (QFSTroopItemInfo) obj2;
            if (qFSTroopItemInfo3 != null) {
                int indexOf2 = this.data.indexOf(qFSTroopItemInfo3);
                this.data.add(indexOf2, qFSTroopItemInfo);
                notifyItemInserted(indexOf2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(r this$0, RecyclerView.ViewHolder holder, QFSTroopItemInfo info, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(info, "$info");
        this$0.p0(((b) holder).getBtnView(), info);
        Function2<? super QFSTroopItemInfo, ? super Integer, Unit> function2 = this$0.onButtonClick;
        if (function2 != null) {
            function2.invoke(info, Integer.valueOf(i3));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(r this$0, QFSTroopItemInfo info, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.l0(context, info);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p0(TextView btnView, QFSTroopItemInfo info) {
        if (btnView != null) {
            VideoReport.setElementId(btnView, QCircleDaTongConstant.ElementId.EM_XSJ_JOIN_GROUP_BUTTON);
            Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put(QCircleDaTongConstant.ElementParamKey.XSJ_GROUP_ID, String.valueOf(info.getId()));
            params.put("xsj_button_text", btnView.getText());
            VideoReport.reportEvent("clck", btnView, params);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(r this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.data.get(position).getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.data.get(position).getType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull final RecyclerView.ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final QFSTroopItemInfo qFSTroopItemInfo = this.data.get(position);
        if (holder instanceof c) {
            ((c) holder).l(qFSTroopItemInfo);
            return;
        }
        if (holder instanceof b) {
            b bVar = (b) holder;
            bVar.m(qFSTroopItemInfo);
            ViewGroup btnViewContainer = bVar.getBtnViewContainer();
            if (btnViewContainer != null) {
                btnViewContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        r.n0(r.this, holder, qFSTroopItemInfo, position, view);
                    }
                });
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.o0(r.this, qFSTroopItemInfo, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == TroopItemType.TEXT.ordinal()) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gnz, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new c(itemView);
        }
        View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.gny, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        return new b(itemView2);
    }

    public final void q0(@Nullable Function2<? super QFSTroopItemInfo, ? super Integer, Unit> click) {
        this.onButtonClick = click;
    }

    public final void r0(@NotNull QFSTroopItemInfo info) {
        List sortedWith;
        Intrinsics.checkNotNullParameter(info, "info");
        int indexOf = this.data.indexOf(info);
        notifyItemChanged(indexOf);
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.data, QFSTroopItemInfo.INSTANCE.g());
        int indexOf2 = sortedWith.indexOf(info);
        QLog.d("QFSProfileHostTroopAdapter", 1, "[updateTroop] oldPosition=" + indexOf + ", newPosition=" + indexOf2);
        this.data.remove(indexOf);
        this.data.add(indexOf2, info);
        notifyItemMoved(indexOf, indexOf2);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.q
            @Override // java.lang.Runnable
            public final void run() {
                r.s0(r.this);
            }
        });
    }

    public final void setData(@NotNull List<QFSTroopItemInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.data.clear();
        this.data.addAll(list);
        notifyDataSetChanged();
        m0();
    }
}
