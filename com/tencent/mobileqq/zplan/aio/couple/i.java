package com.tencent.mobileqq.zplan.aio.couple;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.api.IZootopiaFriendsDressUpApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 ;2\u00020\u0001:\u0002/\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\fH&J\u0013\u0010\u0011\u001a\u00020\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH&J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H&J\b\u0010!\u001a\u00020\u0004H&J\b\u0010\"\u001a\u00020\u0004H&J\b\u0010#\u001a\u00020\u0004H&J\u0013\u0010$\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010\u0012J\u001a\u0010(\u001a\u0004\u0018\u00010\u00182\u0006\u0010%\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H&J(\u0010-\u001a\u00020,2\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H&J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\tH&J\b\u00100\u001a\u00020\u0002H&J\u0010\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0002H&J\b\u00103\u001a\u00020\u0004H&J\b\u00104\u001a\u00020\u0004H&J\u0018\u00108\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00142\u0006\u00107\u001a\u000206H&J\b\u00109\u001a\u00020\u0014H&J\b\u0010:\u001a\u00020\u0014H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/couple/i;", "", "", "state", "", "onMoveToState", "Lcom/tencent/mobileqq/zplan/aio/couple/i$b;", "actionInfo", ReportConstant.COSTREPORT_PREFIX, "Lle3/b;", "actionConfig", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;", "subScene", "d", "l", "Landroid/view/View;", "o", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sceneConfig", "", "needPush", "b", "(Lle3/b;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "data", "i", "Lcom/tencent/mobileqq/zplan/aio/couple/g;", "listener", "f", "width", "height", "c", "j", "g", "t", "e", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/zplan/aio/couple/h;", "listner", "w", "peerUin", "Landroid/content/Context;", "context", "Landroid/widget/ImageView;", "p", "resourceConfig", "a", "r", "newID", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "register", "Lcom/tencent/mobileqq/zplan/push/a;", "observer", "u", "isInitFinished", "v", ICustomDataEditor.STRING_PARAM_4, "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface i {

    /* renamed from: s4, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f331007a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/couple/i$a;", "", "Landroid/content/Context;", "context", "", "subSource", "", "b", "", "friendUin", "", "pageSource", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aio.couple.i$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f331007a = new Companion();

        Companion() {
        }

        public final void a(@NotNull Context context, long friendUin, int pageSource) {
            Intrinsics.checkNotNullParameter(context, "context");
            ((IZootopiaFriendsDressUpApi) QRoute.api(IZootopiaFriendsDressUpApi.class)).openSingleFriendDressUp(context, friendUin, pageSource);
        }

        public final void b(@NotNull Context context, @NotNull String subSource) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(subSource, "subSource");
            ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startPortalActivity(context, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.AvatarCoupleAvatar, subSource, null, 4, null), null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001cJ1\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/couple/i$b;", "", "", "actionId", "", "actionName", "", "isMultiAction", "isSelf", "a", "toString", "hashCode", "other", "equals", "I", "c", "()I", "b", "Ljava/lang/String;", "getActionName", "()Ljava/lang/String;", "setActionName", "(Ljava/lang/String;)V", "Z", "d", "()Z", "e", "<init>", "(ILjava/lang/String;ZZ)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aio.couple.i$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ZPlanActionInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int actionId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String actionName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isMultiAction;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSelf;

        public ZPlanActionInfo(int i3, @NotNull String actionName, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(actionName, "actionName");
            this.actionId = i3;
            this.actionName = actionName;
            this.isMultiAction = z16;
            this.isSelf = z17;
        }

        public static /* synthetic */ ZPlanActionInfo b(ZPlanActionInfo zPlanActionInfo, int i3, String str, boolean z16, boolean z17, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = zPlanActionInfo.actionId;
            }
            if ((i16 & 2) != 0) {
                str = zPlanActionInfo.actionName;
            }
            if ((i16 & 4) != 0) {
                z16 = zPlanActionInfo.isMultiAction;
            }
            if ((i16 & 8) != 0) {
                z17 = zPlanActionInfo.isSelf;
            }
            return zPlanActionInfo.a(i3, str, z16, z17);
        }

        @NotNull
        public final ZPlanActionInfo a(int actionId, @NotNull String actionName, boolean isMultiAction, boolean isSelf) {
            Intrinsics.checkNotNullParameter(actionName, "actionName");
            return new ZPlanActionInfo(actionId, actionName, isMultiAction, isSelf);
        }

        /* renamed from: c, reason: from getter */
        public final int getActionId() {
            return this.actionId;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsMultiAction() {
            return this.isMultiAction;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsSelf() {
            return this.isSelf;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ZPlanActionInfo)) {
                return false;
            }
            ZPlanActionInfo zPlanActionInfo = (ZPlanActionInfo) other;
            if (this.actionId == zPlanActionInfo.actionId && Intrinsics.areEqual(this.actionName, zPlanActionInfo.actionName) && this.isMultiAction == zPlanActionInfo.isMultiAction && this.isSelf == zPlanActionInfo.isSelf) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.actionId * 31) + this.actionName.hashCode()) * 31;
            boolean z16 = this.isMultiAction;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.isSelf;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "ZPlanActionInfo(actionId=" + this.actionId + ", actionName=" + this.actionName + ", isMultiAction=" + this.isMultiAction + ", isSelf=" + this.isSelf + ')';
        }
    }

    void a(@NotNull le3.b resourceConfig);

    @Nullable
    Object b(@NotNull le3.b bVar, boolean z16, @NotNull Continuation<? super Unit> continuation);

    void c(int width, int height);

    void d(@NotNull CoupleAvatarSubScene subScene);

    @Nullable
    Object e(@NotNull Continuation<? super Integer> continuation);

    void f(@NotNull CoupleAvatarSubScene subScene, @NotNull g listener);

    void g();

    void i(@NotNull String data);

    boolean isInitFinished();

    void j();

    void k();

    @NotNull
    CoupleAvatarSubScene l();

    void m();

    void n(@NotNull le3.b actionConfig);

    @Nullable
    Object o(@NotNull Continuation<? super View> continuation);

    void onMoveToState(int state);

    @NotNull
    ImageView p(@NotNull String peerUin, int width, int height, @NotNull Context context);

    void q(int newID);

    int r();

    void s(@NotNull ZPlanActionInfo actionInfo);

    void t();

    void u(boolean register, @NotNull com.tencent.mobileqq.zplan.push.a observer);

    boolean v();

    @Nullable
    String w(int sceneId, @NotNull h listner);
}
