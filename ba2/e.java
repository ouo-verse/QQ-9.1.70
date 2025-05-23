package ba2;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.aio.msglist.holder.f;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.nearbypro.aio.request.AIONetworkHelper;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProUserInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JQ\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2-\b\u0002\u0010\u0010\u001a'\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016JO\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2-\b\u0002\u0010\u0010\u001a'\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u00a8\u0006\u0018"}, d2 = {"Lba2/e;", "Lcom/tencent/mobileqq/aio/msglist/holder/f;", "Landroid/view/View;", "avatarView", "", PhotoCategorySummaryInfo.AVATAR_URL, "", "f", "", "tid", "", "forceUpdate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "tinyId", "completion", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "a", "d", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e implements f {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"ba2/e$b", "Lcom/tencent/mobileqq/nearbypro/aio/request/AIONetworkHelper$a;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/NearbyProUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements AIONetworkHelper.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Long, String, Unit> f28147a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f28148b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference<View> f28149c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f28150d;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Long, ? super String, Unit> function2, long j3, WeakReference<View> weakReference, e eVar) {
            this.f28147a = function2;
            this.f28148b = j3;
            this.f28149c = weakReference;
            this.f28150d = eVar;
        }

        @Override // com.tencent.mobileqq.nearbypro.aio.request.AIONetworkHelper.a
        public void a(int result, @NotNull String errMsg, @NotNull NearbyProUserInfo userInfo) {
            View view;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            j.c().e("NearbyProAIOAvatarProcessor", "fetchNearbyProUserInfo result = " + result + " errMsg = " + errMsg);
            if (result == 0) {
                String str = userInfo.avatarUrl;
                aa2.a.f25755a.e(userInfo);
                Function2<Long, String, Unit> function2 = this.f28147a;
                if (function2 != null) {
                    function2.invoke(Long.valueOf(userInfo.tinyId), str);
                }
                if (this.f28148b == userInfo.tinyId && (view = this.f28149c.get()) != null) {
                    e eVar = this.f28150d;
                    String str2 = userInfo.avatarUrl;
                    Intrinsics.checkNotNullExpressionValue(str2, "userInfo.avatarUrl");
                    eVar.f(view, str2);
                }
            }
        }
    }

    public static /* synthetic */ void e(e eVar, View view, long j3, boolean z16, Function2 function2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 8) != 0) {
            function2 = null;
        }
        eVar.d(view, j3, z17, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final View avatarView, final String avatarUrl) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ba2.d
            @Override // java.lang.Runnable
            public final void run() {
                e.g(avatarUrl, avatarView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String avatarUrl, View avatarView) {
        Intrinsics.checkNotNullParameter(avatarUrl, "$avatarUrl");
        Intrinsics.checkNotNullParameter(avatarView, "$avatarView");
        ((IQQGuildAvatarApi) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IQQGuildAvatarApi.class)).loadCommonPic(avatarUrl, (ImageView) avatarView);
    }

    private final void h(View avatarView, long tid, boolean forceUpdate, Function2<? super Long, ? super String, Unit> completion) {
        AIONetworkHelper.f253140a.g(String.valueOf(tid), forceUpdate, new b(completion, tid, new WeakReference(avatarView), this));
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.f
    public void a(@NotNull View avatarView, @NotNull MsgRecord msgRecord) {
        AppInterface appInterface;
        SelfUserInfo selfUserInfo;
        String avatarUrl;
        boolean z16;
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        String str = msgRecord.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
        long parseLong = Long.parseLong(str);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        ab2.a aVar = ab2.a.f25767a;
        if (!Intrinsics.areEqual(String.valueOf(aVar.m()), msgRecord.senderUid) && !Intrinsics.areEqual(appInterface.getCurrentUid(), msgRecord.senderUid)) {
            if (aa2.a.f25755a.b(parseLong) == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            e(this, avatarView, parseLong, z16, null, 8, null);
            return;
        }
        aa2.a aVar2 = aa2.a.f25755a;
        NearbyProUserInfo b16 = aVar2.b(aVar.m());
        if (b16 != null && !TextUtils.isEmpty(b16.avatarUrl)) {
            String str2 = b16.avatarUrl;
            Intrinsics.checkNotNullExpressionValue(str2, "userInfo.avatarUrl");
            f(avatarView, str2);
        } else {
            IMapNearbyDataService f16 = aVar.f();
            if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null && (avatarUrl = selfUserInfo.getAvatarUrl()) != null) {
                f(avatarView, avatarUrl);
            }
            aVar2.c();
        }
    }

    public final void d(@NotNull View avatarView, long tid, boolean forceUpdate, @Nullable Function2<? super Long, ? super String, Unit> completion) {
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        NearbyProUserInfo b16 = aa2.a.f25755a.b(tid);
        if (b16 != null && !TextUtils.isEmpty(b16.avatarUrl)) {
            String str = b16.avatarUrl;
            Intrinsics.checkNotNullExpressionValue(str, "userInfo.avatarUrl");
            f(avatarView, str);
            return;
        }
        h(avatarView, tid, forceUpdate, completion);
    }
}
