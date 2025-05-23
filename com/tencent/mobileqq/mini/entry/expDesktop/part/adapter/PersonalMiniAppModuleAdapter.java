package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.PersonalMiniAppViewHolder;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniAppExpDesktopNotifyUtil;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniExpValidExpoReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppExpDesktop04239ReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0006\u0010\u000b\u001a\u00020\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J(\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bJ\u001a\u0010\u001c\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/PersonalMiniAppModuleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/PersonalMiniAppViewHolder;", "moduleType", "", "(I)V", "mModuleType", "mPersonalGroupAppInfo", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "mPersonalMiniAppViewHolder", "getItemCount", "getModuleType", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "onViewDetachedFromWindow", "holder", "refreshMiniAppInfo", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "miniAppInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "Lkotlin/collections/ArrayList;", "setData", "personalGroupAppInfo", "setPartHost", "partHost", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class PersonalMiniAppModuleAdapter extends RecyclerView.Adapter<PersonalMiniAppViewHolder> {
    private static final int HIDE_PERSONAL_MODULE = 0;
    private static final int SHOW_PERSONAL_MODULE = 1;
    private static final String TAG = "PersonalMiniAppModuleAdapter";
    private int mModuleType;
    private ExpDesktopGroupAppInfo mPersonalGroupAppInfo;
    private PersonalMiniAppViewHolder mPersonalMiniAppViewHolder;

    public PersonalMiniAppModuleAdapter(int i3) {
        ArrayList arrayListOf;
        ArrayList arrayList = new ArrayList();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("", "");
        this.mPersonalGroupAppInfo = new ExpDesktopGroupAppInfo("", 1, arrayList, arrayListOf, null, false, 48, null);
        this.mModuleType = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mPersonalGroupAppInfo.getGroupAppInfo().isEmpty() ^ true ? 1 : 0;
    }

    /* renamed from: getModuleType, reason: from getter */
    public final int getMModuleType() {
        return this.mModuleType;
    }

    public final void refreshMiniAppInfo(RecyclerView recyclerView, ArrayList<DesktopAppInfo> miniAppInfo) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        this.mPersonalGroupAppInfo.setGroupAppInfo(miniAppInfo);
        MiniAppExpDesktopNotifyUtil.INSTANCE.safeNotifyDataSetChanged(recyclerView, this);
    }

    public final void setPartHost(IPartHost partHost) {
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        PersonalMiniAppViewHolder personalMiniAppViewHolder = this.mPersonalMiniAppViewHolder;
        if (personalMiniAppViewHolder != null) {
            personalMiniAppViewHolder.setPartHost(partHost);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PersonalMiniAppViewHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        PersonalMiniAppViewHolder personalMiniAppViewHolder = this.mPersonalMiniAppViewHolder;
        if (personalMiniAppViewHolder != null) {
            personalMiniAppViewHolder.bindView(this.mPersonalGroupAppInfo, this.mModuleType);
        }
        MiniAppExpDesktop04239ReportHelper miniAppExpDesktop04239ReportHelper = MiniAppExpDesktop04239ReportHelper.INSTANCE;
        miniAppExpDesktop04239ReportHelper.report((r23 & 1) != 0 ? null : null, (r23 & 2) != 0 ? null : null, "em_expo", (r23 & 8) != 0 ? null : miniAppExpDesktop04239ReportHelper.getPageReserveAction(this.mModuleType, false), (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
        MiniProgramReporter.getInstance().flush();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PersonalMiniAppViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167476dj0, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026er_layout, parent, false)");
        PersonalMiniAppViewHolder personalMiniAppViewHolder = new PersonalMiniAppViewHolder(inflate);
        this.mPersonalMiniAppViewHolder = personalMiniAppViewHolder;
        Intrinsics.checkNotNull(personalMiniAppViewHolder);
        return personalMiniAppViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(PersonalMiniAppViewHolder holder) {
        MiniExpValidExpoReportHelper mExpoReportHelper;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow((PersonalMiniAppModuleAdapter) holder);
        PersonalMiniAppViewHolder personalMiniAppViewHolder = this.mPersonalMiniAppViewHolder;
        if (personalMiniAppViewHolder == null || (mExpoReportHelper = personalMiniAppViewHolder.getMExpoReportHelper()) == null) {
            return;
        }
        mExpoReportHelper.stopValidExpoReport(false);
    }

    public final void setData(RecyclerView recyclerView, ExpDesktopGroupAppInfo personalGroupAppInfo) {
        if (personalGroupAppInfo == null) {
            QLog.i(TAG, 1, "setData recentUsedGroupAppInfo is null!");
            return;
        }
        MiniAppExpDesktopNotifyUtil.Companion companion = MiniAppExpDesktopNotifyUtil.INSTANCE;
        companion.removeNullMiniAppForFixError(personalGroupAppInfo);
        this.mPersonalGroupAppInfo = personalGroupAppInfo;
        companion.safeNotifyDataSetChanged(recyclerView, this);
    }
}
