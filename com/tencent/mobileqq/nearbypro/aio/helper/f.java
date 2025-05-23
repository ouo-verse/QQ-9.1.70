package com.tencent.mobileqq.nearbypro.aio.helper;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.ITacitInviteFriendApi;
import com.tencent.mobileqq.nearbypro.aio.api.INearbyProAIOHelperApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.AIOLifeCycleEvent;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.aio.utils.j;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001*\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0013J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000bH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010$R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00070%j\b\u0012\u0004\u0012\u00020\u0007`&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/helper/f;", "Lcom/tencent/aio/main/businesshelper/h;", "", "c", "e", "", "isFromInvite", "", "peerId", "i", "g", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "Lcom/tencent/mvi/base/route/MsgIntent;", "b", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "", "J", "mFriendTinyId", "Landroid/app/Activity;", "f", "Landroid/app/Activity;", "mActivity", h.F, "Z", "Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "registerMsgList", "com/tencent/mobileqq/nearbypro/aio/helper/f$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/nearbypro/aio/helper/f$b;", "action", "<init>", "()V", "D", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mFriendTinyId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity mActivity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isFromInvite;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String peerId = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> registerMsgList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/aio/helper/f$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            f.this.b(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public f() {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOLifeCycleEvent.OnNewIntent.class)));
        this.registerMsgList = arrayListOf;
        this.action = new b();
    }

    private final void c() {
        long j3;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j16;
        Activity activity = this.mActivity;
        Intrinsics.checkNotNull(activity);
        Intent intent = activity.getIntent();
        if (intent != null) {
            this.isFromInvite = intent.getBooleanExtra("key_from_invite", false);
            this.peerId = String.valueOf(intent.getStringExtra("key_peerId"));
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null && (g16 = aVar.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null && (j16 = c16.j()) != null) {
            j3 = Long.parseLong(j16);
        } else {
            j3 = 0;
        }
        this.mFriendTinyId = j3;
    }

    private final void e() {
        Activity activity = this.mActivity;
        if (activity != null) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                Intrinsics.checkNotNullExpressionValue(intent, "intent");
                i(this.isFromInvite, this.peerId);
                return;
            } else {
                com.tencent.mobileqq.nearbypro.base.j.c().c("NearbyProTacitAioHelper", "[initToSendMsgByInvite] exception: intent is null");
                return;
            }
        }
        com.tencent.mobileqq.nearbypro.base.j.c().c("NearbyProTacitAioHelper", "[initToSendMsgByInvite] exception: mActivity is null");
    }

    private final void g(final String peerId) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.aio.helper.e
            @Override // java.lang.Runnable
            public final void run() {
                f.h(peerId);
            }
        }, 16, null, true, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String peerId) {
        Intrinsics.checkNotNullParameter(peerId, "$peerId");
        ((ITacitInviteFriendApi) QRoute.api(ITacitInviteFriendApi.class)).sendGrayMsg(peerId, 2);
    }

    private final void i(boolean isFromInvite, String peerId) {
        Unit unit;
        if (this.mActivity != null) {
            com.tencent.mobileqq.nearbypro.base.j.c().c("NearbyProTacitAioHelper", "[sendInviteMsg] isFromInvite:" + isFromInvite + ", peerId:" + peerId);
            if (isFromInvite && peerId != null) {
                ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).sendText(peerId, 119, "Hi! \u597d\u60f3\u77e5\u9053\u6211\u4eec\u7684\u9ed8\u5951\u5ea6\uff0c\u5feb\u6765\u586b\u5199\u5427\uff5e");
                g(peerId);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            com.tencent.mobileqq.nearbypro.base.j.c().c("NearbyProTacitAioHelper", "[sendInviteMsg] exception: mActivity is null");
        }
    }

    public final void b(@NotNull MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof AIOLifeCycleEvent.OnNewIntent) {
            c();
            e();
            com.tencent.mobileqq.nearbypro.base.j.c().c("NearbyProTacitAioHelper", "OnNewIntent: " + this.isFromInvite + ", " + this.peerId);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return ((INearbyProAIOHelperApi) QRoute.api(INearbyProAIOHelperApi.class)).getNearbyProTacitHelperId();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "NearbyProTacitAioHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        FragmentActivity fragmentActivity;
        com.tencent.mvi.base.route.j e16;
        Fragment c16;
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 != null && (c16 = a16.c()) != null) {
            fragmentActivity = c16.getActivity();
        } else {
            fragmentActivity = null;
        }
        this.mActivity = fragmentActivity;
        for (String str : this.registerMsgList) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar != null && (e16 = aVar.e()) != null) {
                b bVar = this.action;
                LifecycleOwner lifecycleOwner = aVar.d();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
                e16.c(str, bVar, lifecycleOwner);
            }
        }
        c();
        e();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
