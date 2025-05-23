package com.tencent.robot.share;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.guild.mainframe.api.IGuildJumpApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\nJ\u0006\u0010\r\u001a\u00020\fJ\u0014\u0010\u000f\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0019j\b\u0012\u0004\u0012\u00020\u0005`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001bR$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0019j\b\u0012\u0004\u0012\u00020\u0005`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/robot/share/l;", "", "", "f", "", "", "actions", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "c", "d", "", "a", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "b", "pathActions", "e", "Landroid/content/Context;", "Landroid/content/Context;", "context", "", "Ljava/lang/String;", "robotUin", "subBusiness", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "mActionSheet", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mOperations", "mPaths", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "g", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String robotUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String subBusiness;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ShareActionSheet mActionSheet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> mOperations;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> mPaths;

    public l(@NotNull Context context, @NotNull String robotUin, @NotNull String subBusiness) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        this.context = context;
        this.robotUin = robotUin;
        this.subBusiness = subBusiness;
        this.mOperations = new ArrayList<>();
        this.mPaths = new ArrayList<>();
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        HashMap hashMap = new HashMap();
        hashMap.put("agent_uin", robotUin);
        hashMap.put("sub_biz_source", subBusiness);
        param.deReportParams = hashMap;
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        create.setRowVisibility(0, 0, 0);
        create.setActionSheetTitle(context.getString(R.string.f222116cn));
        Intrinsics.checkNotNullExpressionValue(create, "create(param).apply {\n  \u2026heet_share_to))\n        }");
        this.mActionSheet = create;
        d();
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> c(List<Integer> actions) {
        ArrayList arrayList = new ArrayList(actions.size());
        Iterator<Integer> it = actions.iterator();
        while (it.hasNext()) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(it.next().intValue()));
        }
        return arrayList;
    }

    private final void d() {
        this.mPaths.addAll(((IGuildJumpApi) QRoute.api(IGuildJumpApi.class)).isGuildUser() ? CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{2, 171, 3, 9, 10}) : CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{2, 3, 9, 10}));
    }

    private final void f() {
        Intent intent = new Intent();
        intent.putExtra("forward_source_business_type", -1);
        intent.putExtra("forward_source_sub_business_type", "");
        intent.putExtra("k_dataline", false);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra("only_single_selection", true);
        intent.putExtra("forward_type", 42);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
        intent.putExtra(IGuildFeatureAdapterApi.PARAM_NEED_SHOW_GUILD_ENTRANCE, false);
        this.mActionSheet.setIntentForStartForwardRecentActivity(intent);
    }

    @NotNull
    public final l a(@NotNull Collection<Integer> actions) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.mOperations.addAll(actions);
        return this;
    }

    @NotNull
    public final ShareActionSheet b() {
        f();
        this.mActionSheet.setActionSheetItems(c(this.mPaths), c(this.mOperations));
        return this.mActionSheet;
    }

    @NotNull
    public final l e(@NotNull List<Integer> pathActions) {
        Intrinsics.checkNotNullParameter(pathActions, "pathActions");
        if (pathActions.isEmpty()) {
            return this;
        }
        this.mPaths.clear();
        this.mPaths.addAll(pathActions);
        return this;
    }
}
