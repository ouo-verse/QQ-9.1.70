package com.tencent.qqnt.qwallet.aio.hb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.tencent.aio.data.AIOContact;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.reserve.Reserve1Event;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.qwallet.aio.AIOContextHolder;
import com.tencent.qqnt.qwallet.aio.hb.CommandHbGrabber;
import com.tencent.qqnt.qwallet.db.HbCommandEntity;
import com.tencent.qqnt.qwallet.db.QWalletDBManager;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u00011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b<\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\bH\u0002J\f\u0010\u0011\u001a\u00020\u0010*\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aJ&\u0010!\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\nR\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u001a\u00105\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\f\n\u0004\b\f\u00102\u0012\u0004\b3\u00104R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010*R*\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0016\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010:\u00a8\u0006="}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/CommandHbGrabber;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/qwallet/aio/hb/CommandFloatView;", "i", "", "cmd", "", "extraArgs", "", "j", "f", "Lcom/tencent/qqnt/qwallet/db/c;", "entity", "p", "Lorg/json/JSONObject;", "g", "floatView", "k", "", "chatType", "", "sendUin", "peerUin", tl.h.F, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "hbTitle", "listId", "hbMsgExpireTime", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRegistered", "Ljava/lang/ref/SoftReference;", "Landroidx/fragment/app/Fragment;", "c", "Ljava/lang/ref/SoftReference;", "fragmentRef", "d", "Ljava/lang/String;", "msgSendType", "e", "textChangeType", "com/tencent/qqnt/qwallet/aio/hb/CommandHbGrabber$b", "Lcom/tencent/qqnt/qwallet/aio/hb/CommandHbGrabber$b;", "getMsgSendAction$annotations", "()V", "msgSendAction", "Lkotlin/Triple;", "Lkotlin/Triple;", "floatParams", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalLayoutListener", "<init>", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class CommandHbGrabber {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static SoftReference<CommandFloatView> floatView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Triple<String, String, Long> floatParams;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CommandHbGrabber f361741a = new CommandHbGrabber();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean isRegistered = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SoftReference<Fragment> fragmentRef = new SoftReference<>(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final String msgSendType = Reflection.getOrCreateKotlinClass(AIOMsgSendEvent.OnMsgSendSuccessEvent.class).getQualifiedName();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final String textChangeType = Reflection.getOrCreateKotlinClass(InputEditTextMsgIntent.EditTextChangedMsgIntent.class).getQualifiedName();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b msgSendAction = new b();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/qwallet/aio/hb/CommandHbGrabber$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View view;
            QLog.d("CommandHbGrabber", 4, "call: onGlobalLayout");
            Fragment fragment = (Fragment) CommandHbGrabber.fragmentRef.get();
            if (fragment != null && (view = fragment.getView()) != null) {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int height = view.getHeight();
                int i3 = height - rect.bottom;
                double d16 = height * 0.05d;
                QLog.d("CommandHbGrabber", 4, "onGlobalLayout, keypadHeight=" + i3 + " screenHeight*0.05=" + d16);
                if (i3 < d16) {
                    CommandHbGrabber.f361741a.m();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/qwallet/aio/hb/CommandHbGrabber$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(MsgIntent successIntent, long j3, int i3, String str, ArrayList msgList) {
            Object obj;
            final Map mapOf;
            boolean z16;
            Intrinsics.checkNotNullParameter(successIntent, "$successIntent");
            if (i3 != 0) {
                QLog.d("CommandHbGrabber", 1, "call: getMsgsByMsgId result " + i3);
                return;
            }
            Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
            Iterator it = msgList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((MsgRecord) obj).msgId == j3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MsgRecord msgRecord = (MsgRecord) obj;
            if (msgRecord == null) {
                return;
            }
            final String valueOf = String.valueOf(((AIOMsgSendEvent.OnMsgSendSuccessEvent) successIntent).a());
            String b16 = com.tencent.securitysdk.utils.c.b(valueOf);
            Intrinsics.checkNotNullExpressionValue(b16, "toMD5(answer)");
            String lowerCase = b16.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("answer", valueOf), TuplesKt.to("msg_md5", lowerCase), TuplesKt.to("msg_id", Long.valueOf(msgRecord.msgRandom)), TuplesKt.to("msg_seq", Long.valueOf(msgRecord.clientSeq)));
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.hb.f
                @Override // java.lang.Runnable
                public final void run() {
                    CommandHbGrabber.b.d(valueOf, mapOf);
                }
            }, 32, null, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(String answer, Map extraArgs) {
            Intrinsics.checkNotNullParameter(answer, "$answer");
            Intrinsics.checkNotNullParameter(extraArgs, "$extraArgs");
            CommandHbGrabber.f361741a.j(answer, extraArgs);
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull final MsgIntent intent) {
            SoftReference softReference;
            CommandFloatView commandFloatView;
            ArrayList<Long> arrayListOf;
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (intent instanceof AIOMsgSendEvent.OnMsgSendSuccessEvent) {
                if (QWalletDBManager.f361825a.v()) {
                    QLog.d("CommandHbGrabber", 4, "call: no hb command cache loaded ");
                    return;
                }
                AIOMsgSendEvent.OnMsgSendSuccessEvent onMsgSendSuccessEvent = (AIOMsgSendEvent.OnMsgSendSuccessEvent) intent;
                final long b16 = onMsgSendSuccessEvent.b();
                AIOContact c16 = onMsgSendSuccessEvent.c().a().c();
                Contact contact = new Contact(c16.e(), c16.j(), c16.f());
                w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(onMsgSendSuccessEvent.b()));
                    e16.getMsgsByMsgId(contact, arrayListOf, new IMsgOperateCallback() { // from class: com.tencent.qqnt.qwallet.aio.hb.e
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                        public final void onResult(int i3, String str, ArrayList arrayList) {
                            CommandHbGrabber.b.c(MsgIntent.this, b16, i3, str, arrayList);
                        }
                    });
                    return;
                }
                return;
            }
            if ((intent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) && (softReference = CommandHbGrabber.floatView) != null && (commandFloatView = (CommandFloatView) softReference.get()) != null && Intrinsics.areEqual(((InputEditTextMsgIntent.EditTextChangedMsgIntent) intent).c().toString(), commandFloatView.getCmd())) {
                CommandHbGrabber.f361741a.m();
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    CommandHbGrabber() {
    }

    private final String f(String cmd) {
        Triple<String, String, Long> triple = floatParams;
        if (triple == null) {
            return null;
        }
        String first = triple.getFirst();
        String second = triple.getSecond();
        long longValue = triple.getThird().longValue();
        if (!Intrinsics.areEqual(first, cmd) || NetConnInfoCenter.getServerTime() >= longValue) {
            return null;
        }
        return second;
    }

    private final JSONObject g(HbCommandEntity hbCommandEntity) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listid", hbCommandEntity.getListId());
        jSONObject.put("senderuin", String.valueOf(hbCommandEntity.getSenderUin()));
        jSONObject.put("name", com.tencent.mobileqq.base.a.b());
        jSONObject.put("grouptype", f81.a.a(hbCommandEntity.getChatType()));
        jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, f361741a.h(hbCommandEntity.getChatType(), hbCommandEntity.getSenderUin(), hbCommandEntity.getPeerUin()));
        jSONObject.put(WadlProxyConsts.CHANNEL, hbCommandEntity.getRedChannel());
        jSONObject.put("resource_type", hbCommandEntity.getResourceType());
        jSONObject.put("skin_id", 0);
        jSONObject.put("outer_skin_id", "");
        jSONObject.put("skin_from", 0);
        jSONObject.put("hb_from", hbCommandEntity.getHbFrom());
        jSONObject.put("fromHBList", 0);
        jSONObject.put("groupuin", String.valueOf(hbCommandEntity.getSenderUin()));
        jSONObject.put("authkey", hbCommandEntity.getAuthKey());
        jSONObject.put("curFriendUin", String.valueOf(hbCommandEntity.getPeerUin()));
        jSONObject.put("pay_flag", hbCommandEntity.getPayFlag());
        jSONObject.put("hb_flag", hbCommandEntity.getHbFlag());
        return jSONObject;
    }

    private final String h(int chatType, long sendUin, long peerUin) {
        if (((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_C2C_GROUPID_USE_CURRENT_UIN, false)) {
            if (chatType == 1) {
                return com.tencent.mobileqq.base.a.c();
            }
            return String.valueOf(peerUin);
        }
        if (chatType == 1 && sendUin != com.tencent.mobileqq.base.a.a()) {
            return com.tencent.mobileqq.base.a.c();
        }
        return String.valueOf(peerUin);
    }

    private final CommandFloatView i(Context context) {
        CommandFloatView commandFloatView;
        SoftReference<CommandFloatView> softReference = floatView;
        if (softReference != null) {
            commandFloatView = softReference.get();
        } else {
            commandFloatView = null;
        }
        if (commandFloatView == null) {
            final CommandFloatView commandFloatView2 = new CommandFloatView(context);
            com.tencent.mobileqq.qwallet.k.d(commandFloatView2, 0L, new Function0<Unit>() { // from class: com.tencent.qqnt.qwallet.aio.hb.CommandHbGrabber$getOrCreateFloatView$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    CommandHbGrabber commandHbGrabber = CommandHbGrabber.f361741a;
                    commandHbGrabber.k(CommandFloatView.this);
                    AIOContextHolder.f361707d.c(new InputEditTextMsgIntent.SetTextToEditText(new SpannableString(CommandFloatView.this.getCmd()), false));
                    commandHbGrabber.m();
                }
            }, 1, null);
            floatView = new SoftReference<>(commandFloatView2);
            return commandFloatView2;
        }
        return commandFloatView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String cmd, Map<String, ? extends Object> extraArgs) {
        Context context;
        boolean z16;
        HbCommandEntity x16;
        QLog.d("CommandHbGrabber", 4, "onCommandSend: cmd " + cmd);
        Fragment fragment = fragmentRef.get();
        if (fragment != null && (context = fragment.getContext()) != null) {
            String f16 = f(cmd);
            QLog.d("CommandHbGrabber", 4, "onCommandSend: floatListId " + f16);
            if (f16 != null && f16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                x16 = QWalletDBManager.f361825a.w(cmd);
            } else {
                x16 = QWalletDBManager.f361825a.x(f16);
            }
            if (x16 != null) {
                f361741a.p(context, x16, extraArgs);
                QWalletDBManager.f361825a.A(x16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(CommandFloatView floatView2) {
        Triple<String, String, Long> triple = new Triple<>(floatView2.getCmd(), floatView2.getListId(), Long.valueOf(floatView2.getExpireTime()));
        floatParams = triple;
        QLog.d("CommandHbGrabber", 4, "onFloatClick: floatParams " + triple);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o() {
        View view;
        ViewTreeObserver viewTreeObserver;
        Fragment fragment = fragmentRef.get();
        if (fragment != null && (view = fragment.getView()) != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(globalLayoutListener);
        }
    }

    private final void p(Context context, HbCommandEntity entity, Map<String, ? extends Object> extraArgs) {
        QLog.d("CommandHbGrabber", 4, "startGrab: entity " + entity + ", extraArgs " + extraArgs);
        JSONObject g16 = g(entity);
        for (Map.Entry<String, ? extends Object> entry : extraArgs.entrySet()) {
            g16.put(entry.getKey(), entry.getValue());
        }
        String jSONObject = g16.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "entity.createBasicExtraD\u2026e) }\n        }.toString()");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userId", com.tencent.mobileqq.base.a.c());
        jSONObject2.put(HippyHeaderListViewController.VIEW_TAG, "graphb");
        jSONObject2.put(com.tencent.mobileqq.msf.core.c0.j.T0, "appid#1344242394|bargainor_id#1000030201|channel#msg");
        jSONObject2.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 2);
        jSONObject2.put("extra_data", jSONObject);
        jSONObject2.put("senderuin", entity.getSenderUin());
        Intent intent = new Intent();
        intent.putExtra(ark.ARKMETADATA_JSON, jSONObject2.toString());
        intent.putExtra("callbackSn", "0");
        intent.putExtra("pay_requestcode", 5);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTER_PAY_BRIDGE);
        floatParams = null;
    }

    public final void l(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AtomicBoolean atomicBoolean = isRegistered;
        QLog.d("CommandHbGrabber", 4, "register: isRegistered " + atomicBoolean.get());
        if (atomicBoolean.compareAndSet(false, true)) {
            com.tencent.mvi.base.route.j e16 = aioContext.e();
            String str = msgSendType;
            b bVar = msgSendAction;
            e16.d(str, bVar);
            aioContext.e().d(textChangeType, bVar);
        }
        fragmentRef = new SoftReference<>(aioContext.c());
    }

    public final void m() {
        View view;
        ViewTreeObserver viewTreeObserver;
        CommandFloatView commandFloatView;
        QLog.d("CommandHbGrabber", 4, "call: removeFloatView");
        SoftReference<CommandFloatView> softReference = floatView;
        if (softReference != null && (commandFloatView = softReference.get()) != null) {
            AIOContextHolder.f361707d.c(new Reserve1Event.RemoveFloatView(1, commandFloatView));
        }
        Fragment fragment = fragmentRef.get();
        if (fragment != null && (view = fragment.getView()) != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(globalLayoutListener);
        }
    }

    public final void n(@NotNull Context context, @NotNull String hbTitle, @NotNull String listId, long hbMsgExpireTime) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hbTitle, "hbTitle");
        Intrinsics.checkNotNullParameter(listId, "listId");
        CommandFloatView i3 = i(context);
        i3.setArgs(hbTitle, listId, hbMsgExpireTime);
        i3.e();
        Reserve1Event.AddFloatView addFloatView = new Reserve1Event.AddFloatView(1, i3);
        AIOContextHolder aIOContextHolder = AIOContextHolder.f361707d;
        aIOContextHolder.c(addFloatView);
        i3.d();
        QLog.d("CommandHbGrabber", 4, "call: showFloatView");
        aIOContextHolder.c(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L, 1, null));
        i3.postDelayed(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.hb.d
            @Override // java.lang.Runnable
            public final void run() {
                CommandHbGrabber.o();
            }
        }, 300L);
    }

    public final void q(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        CommandFloatView commandFloatView;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AtomicBoolean atomicBoolean = isRegistered;
        QLog.d("CommandHbGrabber", 4, "unregister: isRegistered " + atomicBoolean.get());
        if (atomicBoolean.compareAndSet(true, false)) {
            com.tencent.mvi.base.route.j e16 = aioContext.e();
            String str = msgSendType;
            b bVar = msgSendAction;
            e16.b(str, bVar);
            aioContext.e().b(textChangeType, bVar);
        }
        SoftReference<CommandFloatView> softReference = floatView;
        if (softReference != null && (commandFloatView = softReference.get()) != null) {
            commandFloatView.e();
        }
        fragmentRef.clear();
    }
}
