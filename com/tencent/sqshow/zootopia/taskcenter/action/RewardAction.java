package com.tencent.sqshow.zootopia.taskcenter.action;

import android.content.Context;
import cc4.b;
import cc4.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zplan.download.api.ISourceDownloadHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskRewardInfo;
import com.tencent.sqshow.zootopia.taskcenter.getreward.ReceivedRewardController;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001eB/\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/action/RewardAction;", "", "", "b", "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "Lcom/tencent/sqshow/zootopia/data/w;", "Ljava/util/List;", "getRewardList", "()Ljava/util/List;", "rewardList", "", "c", "I", "getType", "()I", "type", "", "d", "J", "getIndex", "()J", "index", "<init>", "(Landroid/content/Context;Ljava/util/List;IJ)V", "RewardType", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RewardAction {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<ZootopiaTaskRewardInfo> rewardList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long index;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/action/RewardAction$RewardType;", "", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes34.dex */
    public @interface RewardType {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.f373007a;
        public static final int REWARD_BLIND_BOX = 1;
        public static final int REWARD_DAILY = 0;
        public static final int REWARD_TASK = 2;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/action/RewardAction$RewardType$a;", "", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.taskcenter.action.RewardAction$RewardType$a, reason: from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f373007a = new Companion();

            Companion() {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/sqshow/zootopia/taskcenter/action/RewardAction$a", "Lcc4/b$b;", "", "dismiss", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements b.InterfaceC0182b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f373008a;

        a(d dVar) {
            this.f373008a = dVar;
        }

        @Override // cc4.b.InterfaceC0182b
        public void dismiss() {
            this.f373008a.dismiss();
        }
    }

    public RewardAction(Context context, List<ZootopiaTaskRewardInfo> rewardList, int i3, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rewardList, "rewardList");
        this.context = context;
        this.rewardList = rewardList;
        this.type = i3;
        this.index = j3;
    }

    private final void b() {
        QRouteApi api = QRoute.api(ISourceDownloadHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ISourceDownloadHelper::class.java)");
        ISourceDownloadHelper iSourceDownloadHelper = (ISourceDownloadHelper) api;
        if (this.type == 1) {
            iSourceDownloadHelper.downloadSource("https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/task_engine/blindbox_open.pag", ZPlanFileCategory.MP3_RES.getValue());
        }
        ZPlanFileCategory zPlanFileCategory = ZPlanFileCategory.MP3_RES;
        iSourceDownloadHelper.downloadSource("https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/task_engine/zplan_get_blind_box.mp3", zPlanFileCategory.getValue());
        iSourceDownloadHelper.downloadSource("https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/task_engine/zplan_get_reward.mp3", zPlanFileCategory.getValue());
    }

    public void a() {
        b();
        d dVar = new d(this.context, 0, 2, null);
        ReceivedRewardController receivedRewardController = new ReceivedRewardController(this.context, this.rewardList, this.type, this.index);
        receivedRewardController.b(new a(dVar));
        dVar.f(receivedRewardController);
        dVar.show();
    }
}
