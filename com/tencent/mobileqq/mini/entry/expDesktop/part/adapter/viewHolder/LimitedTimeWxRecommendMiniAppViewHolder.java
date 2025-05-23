package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.ui.LimitedTimeRecommendAvatarGroup;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppExpDesktop04239ReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\b\u0010\u0010\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/LimitedTimeWxRecommendMiniAppViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mLimitedTimeRecommendGroupAppInfo", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "mMiniAppExpDesktopRankAvatarGroup", "Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/LimitedTimeRecommendAvatarGroup;", "mRvTitleMoreLl", "Landroid/widget/LinearLayout;", "mRvTitleTv", "Landroid/widget/TextView;", "bindView", "", "recentUsedGroupAppInfo", "gotoLimitedTimeRecommendPage", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class LimitedTimeWxRecommendMiniAppViewHolder extends RecyclerView.ViewHolder {
    public static final int MAX_MINI_APP_SHOW_COUNT = 3;
    private static final String TAG = "LimitedTimeWxRecommendMiniAppViewHolder";
    private ExpDesktopGroupAppInfo mLimitedTimeRecommendGroupAppInfo;
    private LimitedTimeRecommendAvatarGroup mMiniAppExpDesktopRankAvatarGroup;
    private LinearLayout mRvTitleMoreLl;
    private TextView mRvTitleTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LimitedTimeWxRecommendMiniAppViewHolder(View itemView) {
        super(itemView);
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        ArrayList arrayList = new ArrayList();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("", "");
        this.mLimitedTimeRecommendGroupAppInfo = new ExpDesktopGroupAppInfo("", 2, arrayList, arrayListOf, null, false, 48, null);
        View findViewById = itemView.findViewById(R.id.rjz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.module_title_title_tv)");
        this.mRvTitleTv = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.rjx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026module_title_more_layout)");
        this.mRvTitleMoreLl = (LinearLayout) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.rgd);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026esktop_avatars_container)");
        this.mMiniAppExpDesktopRankAvatarGroup = (LimitedTimeRecommendAvatarGroup) findViewById3;
        this.mRvTitleTv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LimitedTimeWxRecommendMiniAppViewHolder._init_$lambda$0(LimitedTimeWxRecommendMiniAppViewHolder.this, view);
            }
        });
        this.mRvTitleMoreLl.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LimitedTimeWxRecommendMiniAppViewHolder._init_$lambda$1(LimitedTimeWxRecommendMiniAppViewHolder.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(LimitedTimeWxRecommendMiniAppViewHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gotoLimitedTimeRecommendPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(LimitedTimeWxRecommendMiniAppViewHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gotoLimitedTimeRecommendPage();
    }

    private final void gotoLimitedTimeRecommendPage() {
        String joinToString$default;
        MiniAppLauncher.launchWxMiniGameCenter(this.itemView.getContext());
        MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(MiniAppDesktopDtReportHelper.INSTANCE.getInstance(), "qq_clck", MiniAppDesktopDtReportHelper.MINI_APP_EM_LIMITED_TIME_RECOMMENDED_MODULE, null, null, 12, null);
        if (this.mLimitedTimeRecommendGroupAppInfo.getGroupAppInfo().size() <= 3) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.mLimitedTimeRecommendGroupAppInfo.getGroupAppInfo(), ",", null, null, 0, null, new Function1<DesktopAppInfo, CharSequence>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.LimitedTimeWxRecommendMiniAppViewHolder$gotoLimitedTimeRecommendPage$appIds$2
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(DesktopAppInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String str = it.mMiniAppInfo.appId;
                    Intrinsics.checkNotNullExpressionValue(str, "it.mMiniAppInfo.appId");
                    return str;
                }
            }, 30, null);
        } else {
            List<DesktopAppInfo> subList = this.mLimitedTimeRecommendGroupAppInfo.getGroupAppInfo().subList(0, 3);
            Intrinsics.checkNotNullExpressionValue(subList, "mLimitedTimeRecommendGro\u2026 MAX_MINI_APP_SHOW_COUNT)");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(subList, ",", null, null, 0, null, new Function1<DesktopAppInfo, CharSequence>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.LimitedTimeWxRecommendMiniAppViewHolder$gotoLimitedTimeRecommendPage$appIds$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(DesktopAppInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String str = it.mMiniAppInfo.appId;
                    Intrinsics.checkNotNullExpressionValue(str, "it.mMiniAppInfo.appId");
                    return str;
                }
            }, 30, null);
        }
        MiniAppExpDesktop04239ReportHelper.INSTANCE.report((r23 & 1) != 0 ? null : joinToString$default, (r23 & 2) != 0 ? null : null, "em_click", (r23 & 8) != 0 ? null : MiniAppExpDesktop04239ReportHelper.RESERVE_ACTION_XSTG, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
        MiniProgramReporter.getInstance().flush();
        QLog.i(TAG, 1, "gotoLimitedTimeRecommendPage appIds:" + joinToString$default);
    }

    public final void bindView(ExpDesktopGroupAppInfo recentUsedGroupAppInfo) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(recentUsedGroupAppInfo, "recentUsedGroupAppInfo");
        this.mLimitedTimeRecommendGroupAppInfo = recentUsedGroupAppInfo;
        this.mRvTitleTv.setText(recentUsedGroupAppInfo.getMModuleTitle());
        ArrayList<DesktopAppInfo> groupAppInfo = recentUsedGroupAppInfo.getGroupAppInfo();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(groupAppInfo, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = groupAppInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(((DesktopAppInfo) it.next()).mMiniAppInfo.iconUrl);
        }
        if (arrayList.size() > 3) {
            LimitedTimeRecommendAvatarGroup limitedTimeRecommendAvatarGroup = this.mMiniAppExpDesktopRankAvatarGroup;
            Object[] array = arrayList.subList(0, 3).toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            limitedTimeRecommendAvatarGroup.setAvatars((String[]) array);
            return;
        }
        LimitedTimeRecommendAvatarGroup limitedTimeRecommendAvatarGroup2 = this.mMiniAppExpDesktopRankAvatarGroup;
        Object[] array2 = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        limitedTimeRecommendAvatarGroup2.setAvatars((String[]) array2);
    }
}
