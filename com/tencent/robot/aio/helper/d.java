package com.tencent.robot.aio.helper;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.adelie.av.api.IAdelieAVActivityApi;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.InputBox;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.api.IRobotProfileInfoApi;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0006\u0010\u0016\u001a\u00020\u0004J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/aio/helper/d;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "e", tl.h.F, "", "robotUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "g", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "k", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/aio/api/runtime/a;", "d", "Ljava/lang/ref/WeakReference;", "mAIOContext", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "mAddFriendDialog", "Lcom/tencent/mvi/base/route/a;", "f", "Lcom/tencent/mvi/base/route/a;", "mAction1", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes25.dex */
public final class d implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<com.tencent.aio.api.runtime.a> mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog mAddFriendDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a mAction1 = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/aio/helper/d$b", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            d.this.e(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(MsgIntent intent) {
        if (intent instanceof AIOTitleEvent.Right2IvClickEvent) {
            h();
        }
    }

    private final void g(String robotUin, GroupRobotProfile robotProfile) {
        InputBox inputBox;
        String str;
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.mvi.base.route.j e16;
        Context context;
        com.tencent.aio.api.runtime.a aVar2;
        com.tencent.mvi.base.route.j e17;
        com.tencent.aio.api.runtime.a aVar3;
        com.tencent.mvi.base.route.j e18;
        com.tencent.aio.api.runtime.a aVar4;
        Fragment c16;
        InputBox inputBox2;
        com.tencent.aio.api.runtime.a aVar5;
        AIOParam g16;
        com.tencent.aio.api.runtime.a aVar6;
        AIOParam g17;
        InputBox inputBox3 = null;
        r0 = null;
        r0 = null;
        String str2 = null;
        if (robotProfile != null) {
            inputBox = robotProfile.inputBox;
        } else {
            inputBox = null;
        }
        boolean z16 = true;
        QLog.d("CallHelper", 1, "111 handleRobotProfileInfoFromLocalCallback inputBox=" + inputBox + " robotUin=" + robotUin);
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.mAIOContext;
        if (weakReference != null && (aVar6 = weakReference.get()) != null && (g17 = aVar6.g()) != null) {
            str = su3.c.b(g17);
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(robotUin, str)) {
            WeakReference<com.tencent.aio.api.runtime.a> weakReference2 = this.mAIOContext;
            if (weakReference2 != null && (aVar5 = weakReference2.get()) != null && (g16 = aVar5.g()) != null) {
                str2 = su3.c.b(g16);
            }
            QLog.d("CallHelper", 1, "handleRobotProfileInfoFromLocalCallback peerUinStr=" + str2);
            return;
        }
        boolean isOpenEntrance = ((IAdelieAVActivityApi) QRoute.api(IAdelieAVActivityApi.class)).isOpenEntrance();
        if (robotProfile != null) {
            inputBox3 = robotProfile.inputBox;
        }
        QLog.d("CallHelper", 1, "handleRobotProfileInfoFromLocalCallback inputBox=" + inputBox3 + " isOpenEntrance=" + isOpenEntrance);
        if (robotProfile == null || (inputBox2 = robotProfile.inputBox) == null || inputBox2.supportTelephone != 0) {
            z16 = false;
        }
        if (!z16 && isOpenEntrance) {
            WeakReference<com.tencent.aio.api.runtime.a> weakReference3 = this.mAIOContext;
            if (weakReference3 == null || (aVar4 = weakReference3.get()) == null || (c16 = aVar4.c()) == null || (context = c16.getContext()) == null) {
                context = BaseApplication.getContext();
            }
            Drawable drawable = context.getDrawable(R.drawable.qui_telephone_icon_nav_secondary);
            WeakReference<com.tencent.aio.api.runtime.a> weakReference4 = this.mAIOContext;
            if (weakReference4 != null && (aVar3 = weakReference4.get()) != null && (e18 = aVar3.e()) != null) {
                e18.h(new AIOTitleEvent.UpdateRight2IvEvent(false, true, drawable, 1, "0"));
            }
            WeakReference<com.tencent.aio.api.runtime.a> weakReference5 = this.mAIOContext;
            if (weakReference5 != null && (aVar2 = weakReference5.get()) != null && (e17 = aVar2.e()) != null) {
                e17.d(Reflection.getOrCreateKotlinClass(AIOTitleEvent.Right2IvClickEvent.class).getQualifiedName(), this.mAction1);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("element_position", "1");
            com.tencent.mobileqq.aio.utils.b.q("em_bas_agent_voice_call", hashMap);
            return;
        }
        WeakReference<com.tencent.aio.api.runtime.a> weakReference6 = this.mAIOContext;
        if (weakReference6 != null && (aVar = weakReference6.get()) != null && (e16 = aVar.e()) != null) {
            e16.h(new AIOTitleEvent.UpdateRight2IvEvent(false, false, null, 1, "0"));
        }
    }

    private final void h() {
        FragmentActivity fragmentActivity;
        int i3;
        Long l3;
        String str;
        String str2;
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        Bundle l16;
        com.tencent.aio.api.runtime.a aVar2;
        AIOParam g17;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar3;
        AIOParam g18;
        com.tencent.aio.api.runtime.a aVar4;
        AIOParam g19;
        AIOSession r17;
        AIOContact c17;
        com.tencent.aio.api.runtime.a aVar5;
        Fragment c18;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.mAIOContext;
        String str3 = null;
        if (weakReference != null && (aVar5 = weakReference.get()) != null && (c18 = aVar5.c()) != null) {
            fragmentActivity = c18.requireActivity();
        } else {
            fragmentActivity = null;
        }
        WeakReference<com.tencent.aio.api.runtime.a> weakReference2 = this.mAIOContext;
        if (weakReference2 != null && (aVar4 = weakReference2.get()) != null && (g19 = aVar4.g()) != null && (r17 = g19.r()) != null && (c17 = r17.c()) != null) {
            i3 = c17.e();
        } else {
            i3 = 10021;
        }
        int c19 = com.tencent.nt.adapter.session.c.c(i3);
        WeakReference<com.tencent.aio.api.runtime.a> weakReference3 = this.mAIOContext;
        if (weakReference3 != null && (aVar3 = weakReference3.get()) != null && (g18 = aVar3.g()) != null) {
            l3 = Long.valueOf(su3.c.a(g18));
        } else {
            l3 = null;
        }
        WeakReference<com.tencent.aio.api.runtime.a> weakReference4 = this.mAIOContext;
        if (weakReference4 != null && (aVar2 = weakReference4.get()) != null && (g17 = aVar2.g()) != null && (r16 = g17.r()) != null && (c16 = r16.c()) != null) {
            str = c16.g();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            WeakReference<com.tencent.aio.api.runtime.a> weakReference5 = this.mAIOContext;
            if (weakReference5 != null && (aVar = weakReference5.get()) != null && (g16 = aVar.g()) != null && (l16 = g16.l()) != null) {
                str3 = l16.getString("nick_" + l3);
            }
            QLog.i("CallHelper", 1, "startAudioCall another way to get nick: " + l3);
            str2 = str3;
        } else {
            str2 = str;
        }
        if (l3 != null) {
            ((IAdelieAVActivityApi) QRoute.api(IAdelieAVActivityApi.class)).startAudioCall(l3.longValue(), peekAppRuntime, fragmentActivity, c19, str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("element_position", "1");
        com.tencent.mobileqq.aio.utils.b.l("em_bas_agent_voice_call", hashMap);
        QLog.d("CallHelper", 1, "onClockClick............");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final d this$0, final String str, int i3, String str2, final GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.robot.aio.helper.c
            @Override // java.lang.Runnable
            public final void run() {
                d.j(d.this, str, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(d this$0, String str, GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g(str, groupRobotProfile);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350634g;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "CallHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        final String str;
        AIOParam g16;
        Intrinsics.checkNotNullParameter(param, "param");
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = new WeakReference<>(param.a());
        this.mAIOContext = weakReference;
        com.tencent.aio.api.runtime.a aVar = weakReference.get();
        if (aVar != null && (g16 = aVar.g()) != null) {
            str = su3.c.b(g16);
        } else {
            str = null;
        }
        if (str != null) {
            ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotProfileInfoFromLocal(str, null, new IGetGroupRobotProfileCallback() { // from class: com.tencent.robot.aio.helper.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
                public final void onResult(int i3, String str2, GroupRobotProfile groupRobotProfile) {
                    d.i(d.this, str, i3, str2, groupRobotProfile);
                }
            });
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.mvi.base.route.j e16;
        h.a.b(this);
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.mAIOContext;
        if (weakReference != null && (aVar = weakReference.get()) != null && (e16 = aVar.e()) != null) {
            e16.b(Reflection.getOrCreateKotlinClass(AIOTitleEvent.Right2IvClickEvent.class).getQualifiedName(), this.mAction1);
        }
        Dialog dialog = this.mAddFriendDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            if (dialog.isShowing()) {
                Dialog dialog2 = this.mAddFriendDialog;
                Intrinsics.checkNotNull(dialog2);
                dialog2.dismiss();
                this.mAddFriendDialog = null;
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 3) {
            if (state == 12) {
                onDestroy();
                return;
            }
            return;
        }
        k();
    }

    public final void k() {
    }
}
