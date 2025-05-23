package com.tencent.robot.aio.share;

import android.app.Activity;
import android.os.Bundle;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J3\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000eH\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J>\u0010\u0019\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000eH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002JF\u0010&\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\"2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110$J,\u0010(\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00102\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\"JB\u0010)\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000e\u00a8\u0006-"}, d2 = {"Lcom/tencent/robot/aio/share/RobotSessionShareActionExecutor;", "", "", "robotUin", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "", "type", "Lzo4/b;", "g", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lzo4/a;", "e", "Lkotlin/Function2;", "Lcom/tencent/robot/aio/share/d;", "Lcom/tencent/robot/aio/share/RobotSessionShareInfo;", "", "callback", "com/tencent/robot/aio/share/RobotSessionShareActionExecutor$b", "f", "(ILkotlin/jvm/functions/Function2;)Lcom/tencent/robot/aio/share/RobotSessionShareActionExecutor$b;", "errorCode", "", "data", DomainData.DOMAIN_NAME, "Lzo4/c;", "rsp", "", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/robot/aio/share/RobotSessionShareParams;", "params", "Lkotlin/Function0;", "callbackAfterShare", "Lkotlin/Function1;", "callBackAfterResponse", "k", "info", h.F, "l", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSessionShareActionExecutor {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RobotSessionShareActionExecutor f367323a = new RobotSessionShareActionExecutor();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J*\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ*\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/aio/share/RobotSessionShareActionExecutor$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/robot/aio/share/RobotSessionShareInfo;", "info", "Lcom/tencent/robot/aio/share/RobotSessionShareParams;", "params", "", "c", "f", "a", "e", "Ljava/lang/Runnable;", "finishRunnable", "g", h.F, "b", "d", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f367324a = new a();

        a() {
        }

        public final void a(@NotNull Activity activity, @NotNull RobotSessionShareInfo info, @NotNull RobotSessionShareParams params) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.robot.aio.share.util.a.e(activity, info.getShareArkInfo(), false, 17003);
        }

        public final void b(@NotNull Activity activity, @NotNull RobotSessionShareInfo info, @NotNull RobotSessionShareParams params) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.robot.aio.share.util.a.f(activity, "robot_share_session_url", info.getShareLink());
        }

        public final void c(@NotNull Activity activity, @NotNull RobotSessionShareInfo info, @NotNull RobotSessionShareParams params) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.robot.aio.share.util.a.g(activity, info.getShareArkInfo(), true, 17003);
        }

        public final void d(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            QLog.e("ShareActionHandler", 1, "Invalid share type");
            QQToast.makeText(activity, "\u5206\u4eab\u7c7b\u578b\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
        }

        public final void e(@NotNull Activity activity, @NotNull RobotSessionShareInfo info, @NotNull RobotSessionShareParams params) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.robot.aio.share.util.a.h(activity, info.getShareLink(), info.getShareDesc(), info.getShareTitle(), info.getShareIcon(), 17003);
        }

        public final void f(@NotNull Activity activity, @NotNull RobotSessionShareInfo info, @NotNull RobotSessionShareParams params) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.robot.aio.share.util.a.i(activity, info.getShareArkInfo(), false, params.getUin(), params.getUinType(), 17003);
        }

        public final void g(@NotNull Activity activity, @NotNull RobotSessionShareInfo info, @NotNull RobotSessionShareParams params, @Nullable Runnable finishRunnable) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.robot.aio.share.util.a.j(activity, info.getShareLink(), info.getShareDesc(), info.getShareTitle(), info.getShareIcon(), finishRunnable);
        }

        public final void h(@NotNull Activity activity, @NotNull RobotSessionShareInfo info, @NotNull RobotSessionShareParams params, @Nullable Runnable finishRunnable) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.robot.aio.share.util.a.l(activity, info.getShareLink(), info.getShareDesc(), info.getShareTitle(), info.getShareIcon(), finishRunnable);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/robot/aio/share/RobotSessionShareActionExecutor$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f367325d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<ShareStatus, RobotSessionShareInfo, Unit> f367326e;

        /* JADX WARN: Multi-variable type inference failed */
        b(int i3, Function2<? super ShareStatus, ? super RobotSessionShareInfo, Unit> function2) {
            this.f367325d = i3;
            this.f367326e = function2;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, @Nullable String errorMsg, @Nullable Bundle bundle) {
            Function2<ShareStatus, RobotSessionShareInfo, Unit> function2 = this.f367326e;
            if (errorMsg == null) {
                errorMsg = "";
            }
            function2.invoke(new ShareStatus(false, errorCode, errorMsg), null);
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            RobotSessionShareActionExecutor.f367323a.n(this.f367325d, errorCode, data, this.f367326e);
        }
    }

    RobotSessionShareActionExecutor() {
    }

    private final boolean d(zo4.c rsp) {
        boolean z16;
        boolean z17;
        JSONObject jSONObject;
        String str = rsp.f452917b;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("RobotShareSessionHelper", 1, "shareUrl is null or empty");
            return false;
        }
        String str2 = rsp.f452923h;
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            QLog.e("RobotShareSessionHelper", 1, "arkSign is null or empty");
            return false;
        }
        try {
            String str3 = rsp.f452923h;
            if (str3 != null) {
                jSONObject = new JSONObject(str3);
            } else {
                jSONObject = new JSONObject();
            }
        } catch (Exception e16) {
            QLog.e("RobotShareSessionHelper", 1, e16, new Object[0]);
            jSONObject = new JSONObject();
        }
        if (!jSONObject.isNull("app") && !jSONObject.isNull("view") && !jSONObject.isNull(PublicAccountMessageUtilImpl.META_NAME)) {
            return true;
        }
        QLog.e("RobotShareSessionHelper", 1, "arkSign is invalid, " + rsp.f452923h);
        return false;
    }

    private final zo4.a e(AIOMsgItem item) {
        zo4.a aVar = new zo4.a();
        MsgRecord msgRecord = item.getMsgRecord();
        aVar.f452908a = msgRecord.msgSeq;
        aVar.f452909b = msgRecord.msgRandom;
        aVar.f452910c = msgRecord.msgTime;
        aVar.f452911d = msgRecord.clientSeq;
        return aVar;
    }

    private final b f(int type, Function2<? super ShareStatus, ? super RobotSessionShareInfo, Unit> callback) {
        return new b(type, callback);
    }

    private final zo4.b g(long robotUin, List<? extends AIOMsgItem> msgList, int type) {
        int collectionSizeOrDefault;
        zo4.b bVar = new zo4.b();
        bVar.f452915d = robotUin;
        List<? extends AIOMsgItem> list = msgList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f367323a.e((AIOMsgItem) it.next()));
        }
        Object[] array = arrayList.toArray(new zo4.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        bVar.f452913b = (zo4.a[]) array;
        bVar.f452914c = type;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function0 callbackAfterShare) {
        Intrinsics.checkNotNullParameter(callbackAfterShare, "$callbackAfterShare");
        callbackAfterShare.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function0 callbackAfterShare) {
        Intrinsics.checkNotNullParameter(callbackAfterShare, "$callbackAfterShare");
        callbackAfterShare.invoke();
    }

    public static /* synthetic */ void m(RobotSessionShareActionExecutor robotSessionShareActionExecutor, long j3, List list, int i3, Function2 function2, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 2;
        }
        robotSessionShareActionExecutor.l(j3, list, i3, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(int type, int errorCode, byte[] data, Function2<? super ShareStatus, ? super RobotSessionShareInfo, Unit> callback) {
        boolean z16;
        try {
            if (data == null) {
                QLog.e("RobotShareSessionHelper", 1, "Empty response data");
                callback.invoke(new ShareStatus(false, errorCode, "data is null"), null);
            } else if (type == 3) {
                zo4.c rsp = zo4.c.c(data);
                if (errorCode == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ShareStatus shareStatus = new ShareStatus(z16, errorCode, "");
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                callback.invoke(shareStatus, new RobotSessionShareInfo(rsp));
            } else {
                zo4.c rsp2 = zo4.c.c(data);
                Intrinsics.checkNotNullExpressionValue(rsp2, "rsp");
                if (d(rsp2)) {
                    callback.invoke(new ShareStatus(true, 0, null, 6, null), new RobotSessionShareInfo(rsp2));
                } else {
                    callback.invoke(new ShareStatus(false, errorCode, "data is invalid"), null);
                }
            }
        } catch (Exception e16) {
            QLog.e("RobotShareSessionHelper", 1, "Parse response failed", e16);
            callback.invoke(new ShareStatus(false, errorCode, "Parse response failed"), null);
        }
    }

    public final void h(@NotNull Activity activity, @NotNull RobotSessionShareParams params, @NotNull RobotSessionShareInfo info, @NotNull final Function0<Unit> callbackAfterShare) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(callbackAfterShare, "callbackAfterShare");
        int action = params.getAction();
        if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action != 9) {
                        if (action != 10) {
                            if (action != 72) {
                                if (action != 73) {
                                    if (action != 171) {
                                        a.f367324a.d(activity);
                                        return;
                                    } else {
                                        a.f367324a.a(activity, info, params);
                                        return;
                                    }
                                }
                            } else {
                                a.f367324a.f(activity, info, params);
                                return;
                            }
                        } else {
                            a.f367324a.h(activity, info, params, new Runnable() { // from class: com.tencent.robot.aio.share.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    RobotSessionShareActionExecutor.j(Function0.this);
                                }
                            });
                            return;
                        }
                    } else {
                        a.f367324a.g(activity, info, params, new Runnable() { // from class: com.tencent.robot.aio.share.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                RobotSessionShareActionExecutor.i(Function0.this);
                            }
                        });
                        return;
                    }
                } else {
                    a.f367324a.e(activity, info, params);
                    return;
                }
            }
            a.f367324a.c(activity, info, params);
            return;
        }
        a.f367324a.b(activity, info, params);
        callbackAfterShare.invoke();
    }

    public final void k(@NotNull final Activity activity, @NotNull final RobotSessionShareParams params, @NotNull List<? extends AIOMsgItem> msgList, @NotNull final Function0<Unit> callbackAfterShare, @NotNull final Function1<? super ShareStatus, Unit> callBackAfterResponse) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(callbackAfterShare, "callbackAfterShare");
        Intrinsics.checkNotNullParameter(callBackAfterResponse, "callBackAfterResponse");
        String robotUin = params.getRobotUin();
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("RobotShareSessionHelper", 1, "Robot uin is null");
            callBackAfterResponse.invoke(new ShareStatus(false, 0, null, 6, null));
        } else {
            l(Long.parseLong(robotUin), msgList, params.getShareType(), new Function2<ShareStatus, RobotSessionShareInfo, Unit>() { // from class: com.tencent.robot.aio.share.RobotSessionShareActionExecutor$fetchInfoAndShareThenDo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ShareStatus shareStatus, RobotSessionShareInfo robotSessionShareInfo) {
                    invoke2(shareStatus, robotSessionShareInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ShareStatus status, @Nullable RobotSessionShareInfo robotSessionShareInfo) {
                    Intrinsics.checkNotNullParameter(status, "status");
                    callBackAfterResponse.invoke(status);
                    if (!status.getIsSuccess() || robotSessionShareInfo == null) {
                        return;
                    }
                    RobotSessionShareActionExecutor.f367323a.h(activity, params, robotSessionShareInfo, callbackAfterShare);
                }
            });
        }
    }

    public final void l(long robotUin, @NotNull List<? extends AIOMsgItem> msgList, int type, @NotNull Function2<? super ShareStatus, ? super RobotSessionShareInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ProtoUtils.a(MobileQQ.sMobileQQ.peekAppRuntime(), f(type, callback), MessageNano.toByteArray(g(robotUin, msgList, type)), "OidbSvcTrpcTcp.0x9414", 37908, 1);
    }
}
