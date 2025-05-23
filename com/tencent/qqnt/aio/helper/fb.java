package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.at.a;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.AIOLifeCycleEvent;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import tencent.im.oidb.cmd0x934.cmd0x934$RspBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0007*\u0001,\b\u0007\u0018\u0000 \u00062\u00020\u00012\u00020\u0002:\u00011B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J6\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J0\u0010\u0015\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\u000e\u0010\"\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010'R\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/aio/helper/fb;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", "e", tl.h.F, "i", "p", "Landroid/content/Context;", "context", "", "strMsg", "strRobotUin", "strRobotName", "", "isSendToRobotServer", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/troop/robot/api/ITroopRobotService;", "troopRobotService", "strTroopUin", "strContent", "k", "", "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "g", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Ljava/lang/String;", "mTroopUin", "f", "Z", "mIsFirstResume", "com/tencent/qqnt/aio/helper/fb$b", "Lcom/tencent/qqnt/aio/helper/fb$b;", "action", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class fb implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mTroopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFirstResume = true;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final b action = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/fb$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            fb.this.g(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final void e() {
        p();
    }

    private final void h() {
        p();
        if (this.mIsFirstResume) {
            this.mIsFirstResume = false;
            i();
        }
    }

    private final void i() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ey
            @Override // java.lang.Runnable
            public final void run() {
                fb.j(fb.this);
            }
        }, 192, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(fb this$0) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null || !((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getIfRobotRedInfoNeedUpdate(appInterface)) {
            return;
        }
        Object businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopRobotHandlerName());
        ct2.a aVar = businessHandler instanceof ct2.a ? (ct2.a) businessHandler : null;
        if (aVar != null) {
            String str2 = this$0.mTroopUin;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            } else {
                str = str2;
            }
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
            aVar.N(longOrNull != null ? longOrNull.longValue() : 0L);
        }
    }

    private final void k(final Context context, ITroopRobotService troopRobotService, String strTroopUin, String strRobotUin, String strContent) {
        try {
            long parseLong = Long.parseLong(strTroopUin);
            long parseLong2 = Long.parseLong(strRobotUin);
            ITroopRobotService.a aVar = new ITroopRobotService.a() { // from class: com.tencent.qqnt.aio.helper.fa
                @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService.a
                public final void a(int i3, cmd0x934$RspBody cmd0x934_rspbody) {
                    fb.m(context, i3, cmd0x934_rspbody);
                }
            };
            if (Intrinsics.areEqual("1", strTroopUin)) {
                troopRobotService.sendContent(parseLong2, strContent, aVar);
            } else {
                troopRobotService.sendContent(parseLong, parseLong2, strContent, aVar);
            }
        } catch (Exception unused) {
            QLog.e("TroopRobotFunctionHelper", 2, "sendContent exception:" + strTroopUin + ":" + strRobotUin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Context context, int i3, cmd0x934$RspBody cmd0x934_rspbody) {
        Intrinsics.checkNotNullParameter(context, "$context");
        if (i3 != 0) {
            QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.t2q), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(fb this$0, CharSequence atSpan, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(atSpan, "$atSpan");
        com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        SpannableStringBuilder append = new SpannableStringBuilder(atSpan).append((CharSequence) str);
        Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder(atSpan).append(strMsg)");
        SpannedString valueOf = SpannedString.valueOf(append);
        Intrinsics.checkNotNullExpressionValue(valueOf, "SpannedString.valueOf(this)");
        e16.h(new InputEditTextMsgIntent.SetTextToEditText(valueOf, true));
    }

    public final void g(MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof AIOLifeCycleEvent.OnNewIntent) {
            e();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350630e1;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.AIOLifeCycleEvent.OnNewIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopRobotFunctionHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        this.mTroopUin = a16.g().r().c().j();
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().f(this, this.action);
        this.mIsFirstResume = true;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().i(this, this.action);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3};
    }

    private final void p() {
        AppRuntime peekAppRuntime;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        int indexOf$default;
        String str;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        Bundle l3 = aVar.g().l();
        Bundle bundle = l3.getBundle(AppConstants.Key.KEY_INVOKE_TROOP_ROBOT_FUNCTION);
        if (bundle == null) {
            return;
        }
        l3.remove(AppConstants.Key.KEY_INVOKE_TROOP_ROBOT_FUNCTION);
        String string = bundle.getString("troopuin");
        String string2 = bundle.getString("robotuin");
        if (string2 == null || string2.length() == 0) {
            return;
        }
        if (string == null || string.length() == 0) {
            return;
        }
        String str2 = this.mTroopUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str2 = null;
        }
        if (Intrinsics.areEqual(str2, string) && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopRobotService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
            ITroopRobotService iTroopRobotService = (ITroopRobotService) runtimeService;
            String string3 = bundle.getString("robotname");
            RobotPanelLayoutBase.b a16 = RobotPanelLayoutBase.b.a(bundle.getString("onurl"), bundle.getString("ontitle"), bundle.getString("offurl"), bundle.getString("offtitle"));
            if (TextUtils.isEmpty(a16.f302402b.f302405a)) {
                String str3 = a16.f302401a.f302407c;
                if (!(str3 == null || str3.length() == 0)) {
                    com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                        aVar2 = null;
                    }
                    Context context = aVar2.c().getContext();
                    if (context == null) {
                        return;
                    }
                    String str4 = a16.f302401a.f302407c;
                    Intrinsics.checkNotNullExpressionValue(str4, "itemData.offinfo.url");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str4, "inputKeyOp://sendToRobot", false, 2, null);
                    if (startsWith$default) {
                        QLog.i("TroopRobotFunctionHelper", 2, "send to robot: " + a16.f302401a.f302405a);
                        n(context, a16.f302401a.f302405a, string2, string3, false);
                        return;
                    }
                    String str5 = a16.f302401a.f302407c;
                    Intrinsics.checkNotNullExpressionValue(str5, "itemData.offinfo.url");
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str5, "inputKeyOp://sendToBackEnd", false, 2, null);
                    if (startsWith$default2) {
                        String str6 = a16.f302401a.f302407c;
                        Intrinsics.checkNotNullExpressionValue(str6, "itemData.offinfo.url");
                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str6, "content=", 0, false, 6, (Object) null);
                        if (indexOf$default > 0) {
                            String str7 = a16.f302401a.f302407c;
                            Intrinsics.checkNotNullExpressionValue(str7, "itemData.offinfo.url");
                            String substring = str7.substring(indexOf$default + 8);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                            str = substring;
                        } else {
                            str = null;
                        }
                        n(context, a16.f302401a.f302405a, string2, string3, true);
                        if (str == null || str.length() == 0) {
                            QLog.i("TroopRobotFunctionHelper", 1, "content is empty");
                            return;
                        }
                        QLog.i("TroopRobotFunctionHelper", 2, "send to server: " + a16.f302401a.f302405a);
                        k(context, iTroopRobotService, string, string2, str);
                        return;
                    }
                    String str8 = a16.f302401a.f302407c;
                    Intrinsics.checkNotNullExpressionValue(str8, "itemData.offinfo.url");
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(str8, "http", false, 2, null);
                    if (startsWith$default3) {
                        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", a16.f302401a.f302407c);
                        context.startActivity(intent);
                        return;
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopRobotFunctionHelper", 2, "talking: itemData.onInfo.title return.");
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            h();
        }
    }

    private final void n(Context context, final String strMsg, String strRobotUin, String strRobotName, boolean isSendToRobotServer) {
        final CharSequence a16;
        if (strMsg == null || strMsg.length() == 0) {
            return;
        }
        if (strRobotUin == null || strRobotUin.length() == 0) {
            return;
        }
        if (strRobotName == null || strRobotName.length() == 0) {
            return;
        }
        if (strMsg.length() > context.getResources().getInteger(R.integer.f167165o)) {
            ChatActivityUtils.m0(context, R.string.her, 1);
            return;
        }
        new ChatActivityFacade.d().f175156t = isSendToRobotServer;
        String robotUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(strRobotUin);
        if (TextUtils.isEmpty(robotUid)) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        Intrinsics.checkNotNullExpressionValue(robotUid, "robotUid");
        com.tencent.mvi.base.route.k k3 = e16.k(new InputAtMsgIntent.CreateAtSpan(robotUid, strRobotUin, strRobotName, true));
        a.C7251a c7251a = k3 instanceof a.C7251a ? (a.C7251a) k3 : null;
        if (c7251a == null || (a16 = c7251a.a()) == null) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().h(new InputEditTextMsgIntent.PostToDoRunnable(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ez
            @Override // java.lang.Runnable
            public final void run() {
                fb.o(fb.this, a16, strMsg);
            }
        }));
    }
}
