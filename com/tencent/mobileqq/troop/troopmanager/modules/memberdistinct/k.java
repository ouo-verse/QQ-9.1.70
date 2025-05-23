package com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.TroopMemberDistinctResultListItemType;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.protofile.TroopMemberDetectSvr$DuplicateMember;
import com.tencent.protofile.TroopMemberDetectSvr$GroupInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u001d\u0010\u0011\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012JB\u0010\u001b\u001a\u00020\f2:\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\f0\u0013j\u0002`\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dRN\u0010!\u001a:\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013j\u0004\u0018\u0001`\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/k;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/m;", "", "getItemCount", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "n0", "holder", "", "k0", "", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/a;", "data", "o0", "([Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/a;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "itemModel", "", "isChecked", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/TapItemCallback;", "callback", "p0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/a;", "dataList", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "tapItemCallback", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class k extends RecyclerView.Adapter<m> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function2<? super com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a, ? super Boolean, Unit> tapItemCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a[] dataList;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.dataList = new com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(m holder, k this$0, int i3, com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a itemModel, View view) {
        PBUInt64Field pBUInt64Field;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemModel, "$itemModel");
        l lVar = (l) holder;
        lVar.p();
        Function2<? super com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a, ? super Boolean, Unit> function2 = this$0.tapItemCallback;
        if (function2 != null) {
            function2.invoke(itemModel, Boolean.valueOf(lVar.o()));
        }
        TroopMemberDetectSvr$DuplicateMember b16 = itemModel.b();
        PBUInt64Field pBUInt64Field2 = null;
        if (b16 != null) {
            pBUInt64Field = b16.uin;
        } else {
            pBUInt64Field = null;
        }
        TroopMemberDetectSvr$GroupInfo a16 = itemModel.a();
        if (a16 != null) {
            pBUInt64Field2 = a16.group_id;
        }
        QLog.i("TroopMemberDistinct", 1, "tap check group, [pos:" + i3 + " uin:" + pBUInt64Field + " group:" + pBUInt64Field2 + "]");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(k this$0, int i3, com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a itemModel, View view) {
        PBUInt64Field pBUInt64Field;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemModel, "$itemModel");
        Function2<? super com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a, ? super Boolean, Unit> function2 = this$0.tapItemCallback;
        if (function2 != null) {
            function2.invoke(itemModel, Boolean.FALSE);
        }
        TroopMemberDetectSvr$DuplicateMember b16 = itemModel.b();
        PBUInt64Field pBUInt64Field2 = null;
        if (b16 != null) {
            pBUInt64Field = b16.uin;
        } else {
            pBUInt64Field = null;
        }
        TroopMemberDetectSvr$GroupInfo a16 = itemModel.a();
        if (a16 != null) {
            pBUInt64Field2 = a16.group_id;
        }
        QLog.i("TroopMemberDistinct", 1, "tap check user, [pos:" + i3 + " uin:" + pBUInt64Field + " group:" + pBUInt64Field2 + "]");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.dataList.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a aVar;
        TroopMemberDistinctResultListItemType c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, position)).intValue();
        }
        com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a[] aVarArr = this.dataList;
        if (position <= aVarArr.length) {
            aVar = aVarArr[position];
        } else {
            aVar = null;
        }
        if (aVar != null && (c16 = aVar.c()) != null) {
            return c16.getIndex();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final m holder, final int position) {
        l lVar;
        View m3;
        View m16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a[] aVarArr = this.dataList;
        if (position <= aVarArr.length) {
            final com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a aVar = aVarArr[position];
            holder.l(aVar, position);
            o oVar = null;
            if (holder instanceof l) {
                lVar = (l) holder;
            } else {
                lVar = null;
            }
            if (lVar != null && (m16 = lVar.m()) != null) {
                m16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        k.l0(m.this, this, position, aVar, view);
                    }
                });
            }
            if (holder instanceof o) {
                oVar = (o) holder;
            }
            if (oVar != null && (m3 = oVar.m()) != null) {
                m3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        k.m0(k.this, position, aVar, view);
                    }
                });
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public m onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (m) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == TroopMemberDistinctResultListItemType.USER.getIndex()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.g17, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new o(view);
        }
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.g16, parent, false);
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        return new l(view2);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void o0(@NotNull com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a[] data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.dataList = data;
        notifyDataSetChanged();
        QLog.i("TroopMemberDistinct", 1, "refresh result list, count:" + data.length);
    }

    public final void p0(@NotNull Function2<? super com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a, ? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.tapItemCallback = callback;
        }
    }
}
