package com.tencent.mobileqq.springhb.interactive.api;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.springhb.api.ISpringHbPreloadResApi;
import com.tencent.mobileqq.springhb.entry.model.DragonCardConfigData;
import com.tencent.mobileqq.springhb.entry.model.DragonCardData;
import com.tencent.mobileqq.springhb.interactive.helper.InteractiveAnimationHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy;
import com.tencent.mobileqq.vas.ui.PagViewProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.d;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u000e\b \u0018\u0000 \u001e2\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010#\u001a\u00020!\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u0004\u0018\u00010\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\u000bJ\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0010J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020\u0004R\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\"R\"\u0010*\u001a\u00020$8\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R[\u00102\u001aB\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n ,*\u0004\u0018\u00010-0- ,* \u0012\f\u0012\n ,*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n ,*\u0004\u0018\u00010-0-\u0018\u00010.0+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u00101R\u001b\u00105\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010/\u001a\u0004\b3\u00104R\u0016\u00107\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00108\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord;", "Lcom/tencent/mobileqq/springhb/interactive/config/b;", "", "t", "", "url", "Lorg/libpag/PAGFile;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", DomainData.DOMAIN_NAME, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ReportConstant.COSTREPORT_PREFIX, "r", "b", "getSessionId", "", "getChatType", "k", "getSource", "", "i", "a", "e", "getId", "getType", "c", "f", "", h.F, "g", "j", "d", "Lcom/tencent/qqnt/msg/d;", "Lcom/tencent/qqnt/msg/d;", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/mobileqq/springhb/entry/model/DragonCardConfigData;", "Lcom/tencent/mobileqq/springhb/entry/model/DragonCardConfigData;", "p", "()Lcom/tencent/mobileqq/springhb/entry/model/DragonCardConfigData;", "u", "(Lcom/tencent/mobileqq/springhb/entry/model/DragonCardConfigData;)V", DownloadInfo.spKey_Config, "", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/springhb/entry/model/DragonCardData;", "", "Lkotlin/Lazy;", "o", "()Ljava/util/Map;", "animationItemData", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", RemoteMessageConst.MessageBody.MSG_CONTENT, "Lcom/tencent/mobileqq/springhb/entry/model/DragonCardData;", "animationData", "Lorg/libpag/PAGFile;", "playFile", "<init>", "(Lcom/tencent/qqnt/msg/d;)V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class InteractiveRecord implements com.tencent.mobileqq.springhb.interactive.config.b {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d record;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public DragonCardConfigData config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy animationItemData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy msgContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private DragonCardData animationData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PAGFile playFile;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord$a;", "", "", "chatType", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String a(int chatType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, chatType);
            }
            if (chatType != 1) {
                if (chatType == 2 || chatType == 3) {
                    return "2";
                }
                if (chatType != 4) {
                    return "0";
                }
                return "3";
            }
            return "1";
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/springhb/interactive/api/InteractiveRecord$b", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$LoaderCallback;", "", "onLoadFailed", "onLoadSucceed", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements AbsAsyncLoadProxy.LoaderCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f289210a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f289211b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Ref.BooleanRef booleanRef, Continuation<? super Boolean> continuation) {
            this.f289210a = booleanRef;
            this.f289211b = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) booleanRef, (Object) continuation);
            }
        }

        @Override // com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.LoaderCallback
        public void onLoadFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.e("InteractiveRecord", 1, "pag so onLoadSucceed !! " + Thread.currentThread().getName());
            Ref.BooleanRef booleanRef = this.f289210a;
            if (booleanRef.element) {
                return;
            }
            booleanRef.element = true;
            Continuation<Boolean> continuation = this.f289211b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }

        @Override // com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.LoaderCallback
        public void onLoadSucceed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.d("InteractiveRecord", 1, "pag so onLoadSucceed !! " + Thread.currentThread().getName());
            Ref.BooleanRef booleanRef = this.f289210a;
            if (booleanRef.element) {
                return;
            }
            booleanRef.element = true;
            Continuation<Boolean> continuation = this.f289211b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20873);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InteractiveRecord(@NotNull d record) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(record, "record");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) record);
            return;
        }
        this.record = record;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, DragonCardData>>() { // from class: com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord$animationItemData$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InteractiveRecord.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, DragonCardData> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? InteractiveRecord.this.p().animationItems : (Map) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.animationItemData = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord$msgContent$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InteractiveRecord.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? InteractiveRecord.this.r() : (String) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.msgContent = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(String str, Continuation<? super PAGFile> continuation) {
        InteractiveRecord$checkFileResource$1 interactiveRecord$checkFileResource$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        String str2;
        if (continuation instanceof InteractiveRecord$checkFileResource$1) {
            interactiveRecord$checkFileResource$1 = (InteractiveRecord$checkFileResource$1) continuation;
            int i16 = interactiveRecord$checkFileResource$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                interactiveRecord$checkFileResource$1.label = i16 - Integer.MIN_VALUE;
                obj = interactiveRecord$checkFileResource$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = interactiveRecord$checkFileResource$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        str2 = (String) interactiveRecord$checkFileResource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    String filePath = ((ISpringHbPreloadResApi) QRoute.api(ISpringHbPreloadResApi.class)).getSpringFileRes(str).getFilePath();
                    QLog.d("InteractiveRecord", 1, "checkFileResource " + str + " -> " + filePath);
                    if (TextUtils.isEmpty(filePath)) {
                        return null;
                    }
                    interactiveRecord$checkFileResource$1.L$0 = filePath;
                    interactiveRecord$checkFileResource$1.label = 1;
                    Object n3 = n(interactiveRecord$checkFileResource$1);
                    if (n3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = n3;
                    str2 = filePath;
                }
                if (((Boolean) obj).booleanValue()) {
                    QLog.d("InteractiveRecord", 1, "checkPagSo is fail!!");
                    return null;
                }
                PAGFile Load = PagViewMonitor.Load(str2);
                if (Load == null) {
                    return null;
                }
                return Load;
            }
        }
        interactiveRecord$checkFileResource$1 = new InteractiveRecord$checkFileResource$1(this, continuation);
        obj = interactiveRecord$checkFileResource$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = interactiveRecord$checkFileResource$1.label;
        if (i3 == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    private final Object n(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        PagViewProxy.Companion companion = PagViewProxy.INSTANCE;
        if (!companion.getSLoader().isLoaded()) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            companion.getSLoader().syncLoad(new b(new Ref.BooleanRef(), safeContinuation));
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return Boxing.boxBoolean(true);
    }

    private final Map<String, DragonCardData> o() {
        return (Map) this.animationItemData.getValue();
    }

    private final String q() {
        return (String) this.msgContent.getValue();
    }

    private final void t() {
        if (getSource() != 1) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext4", "8");
        hashMap.put("ext2", e());
        hashMap.put("ext6", getSessionId());
        hashMap.put("ext49", INSTANCE.a(getChatType()));
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(d(), "8", "1069", "9514", "951401", "915871", "", hashMap);
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @Nullable
    public final PAGFile a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (PAGFile) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.playFile;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return TextUtils.equals(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid(), MsgExtKt.m(this.record));
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        DragonCardData dragonCardData = this.animationData;
        DragonCardData dragonCardData2 = null;
        if (dragonCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
            dragonCardData = null;
        }
        if (dragonCardData.guestJumpURL == null) {
            return "";
        }
        DragonCardData dragonCardData3 = this.animationData;
        if (dragonCardData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
        } else {
            dragonCardData2 = dragonCardData3;
        }
        String str = dragonCardData2.guestJumpURL;
        Intrinsics.checkNotNullExpressionValue(str, "animationData.guestJumpURL");
        return str;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        DragonCardData dragonCardData = this.animationData;
        if (dragonCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
            dragonCardData = null;
        }
        String str = dragonCardData.gameAppId;
        Intrinsics.checkNotNullExpressionValue(str, "animationData.gameAppId");
        return str;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        DragonCardData dragonCardData = this.animationData;
        if (dragonCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
            dragonCardData = null;
        }
        String str = dragonCardData.keyWord;
        Intrinsics.checkNotNullExpressionValue(str, "animationData.keyWord");
        return str;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        DragonCardData dragonCardData = this.animationData;
        DragonCardData dragonCardData2 = null;
        if (dragonCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
            dragonCardData = null;
        }
        if (dragonCardData.jumpURL == null) {
            return "";
        }
        DragonCardData dragonCardData3 = this.animationData;
        if (dragonCardData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
        } else {
            dragonCardData2 = dragonCardData3;
        }
        String str = dragonCardData2.jumpURL;
        Intrinsics.checkNotNullExpressionValue(str, "animationData.jumpURL");
        return str;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public final double g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Double) iPatchRedirector.redirect((short) 19, (Object) this)).doubleValue();
        }
        DragonCardData dragonCardData = this.animationData;
        if (dragonCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
            dragonCardData = null;
        }
        return dragonCardData.vibrateMoment;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public int getChatType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.record.a().chatType;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public final String getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        DragonCardData dragonCardData = this.animationData;
        if (dragonCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
            dragonCardData = null;
        }
        return String.valueOf(dragonCardData.f289094id);
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public String getSessionId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        int i3 = this.record.a().chatType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    return String.valueOf(this.record.a().senderUin);
                }
                String str = this.record.a().guildId;
                Intrinsics.checkNotNullExpressionValue(str, "record.msgRecord.guildId");
                return str;
            }
            return String.valueOf(this.record.a().peerUin);
        }
        return String.valueOf(this.record.a().peerUin);
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public int getSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        DragonCardData dragonCardData = this.animationData;
        if (dragonCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
            dragonCardData = null;
        }
        return dragonCardData.source;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public final int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        DragonCardData dragonCardData = this.animationData;
        if (dragonCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
            dragonCardData = null;
        }
        return dragonCardData.type;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public final double h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Double) iPatchRedirector.redirect((short) 18, (Object) this)).doubleValue();
        }
        DragonCardData dragonCardData = this.animationData;
        if (dragonCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
            dragonCardData = null;
        }
        return dragonCardData.unClickablePercentage;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public final long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        DragonCardData dragonCardData = this.animationData;
        if (dragonCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
            dragonCardData = null;
        }
        return dragonCardData.animationDuration;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public final long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, (Object) this)).longValue();
        }
        DragonCardData dragonCardData = this.animationData;
        if (dragonCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
            dragonCardData = null;
        }
        return dragonCardData.vibrateLength;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        DragonCardData dragonCardData = this.animationData;
        DragonCardData dragonCardData2 = null;
        if (dragonCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
            dragonCardData = null;
        }
        if (dragonCardData.actId == null) {
            return "";
        }
        DragonCardData dragonCardData3 = this.animationData;
        if (dragonCardData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationData");
        } else {
            dragonCardData2 = dragonCardData3;
        }
        String str = dragonCardData2.actId;
        Intrinsics.checkNotNullExpressionValue(str, "animationData.actId");
        return str;
    }

    @NotNull
    public final DragonCardConfigData p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DragonCardConfigData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        DragonCardConfigData dragonCardConfigData = this.config;
        if (dragonCardConfigData != null) {
            return dragonCardConfigData;
        }
        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        return null;
    }

    @NotNull
    public abstract String r();

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object s(@NotNull Continuation<? super InteractiveRecord> continuation) {
        InteractiveRecord$matchAnimation$1 interactiveRecord$matchAnimation$1;
        Object coroutine_suspended;
        int i3;
        InteractiveRecord interactiveRecord;
        InteractiveRecord interactiveRecord2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) continuation);
        }
        if (continuation instanceof InteractiveRecord$matchAnimation$1) {
            interactiveRecord$matchAnimation$1 = (InteractiveRecord$matchAnimation$1) continuation;
            int i16 = interactiveRecord$matchAnimation$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                interactiveRecord$matchAnimation$1.label = i16 - Integer.MIN_VALUE;
                Object obj = interactiveRecord$matchAnimation$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = interactiveRecord$matchAnimation$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        interactiveRecord2 = (InteractiveRecord) interactiveRecord$matchAnimation$1.L$1;
                        interactiveRecord = (InteractiveRecord) interactiveRecord$matchAnimation$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    DragonCardData c16 = com.tencent.mobileqq.springhb.utils.a.c(q(), o());
                    if (c16 == null) {
                        QLog.d("InteractiveRecord", 1, " " + q() + " noMatch !!");
                        return null;
                    }
                    this.animationData = c16;
                    t();
                    String str = c16.pagResUrl;
                    Intrinsics.checkNotNullExpressionValue(str, "itemData.pagResUrl");
                    interactiveRecord$matchAnimation$1.L$0 = this;
                    interactiveRecord$matchAnimation$1.L$1 = this;
                    interactiveRecord$matchAnimation$1.label = 1;
                    obj = m(str, interactiveRecord$matchAnimation$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    interactiveRecord = this;
                    interactiveRecord2 = interactiveRecord;
                }
                interactiveRecord2.playFile = (PAGFile) obj;
                if (interactiveRecord.playFile != null) {
                    QLog.d("InteractiveRecord", 1, interactiveRecord.q() + " noPlayFileSource!!");
                    InteractiveAnimationHelper.INSTANCE.a(interactiveRecord, "1");
                    return null;
                }
                return interactiveRecord;
            }
        }
        interactiveRecord$matchAnimation$1 = new InteractiveRecord$matchAnimation$1(this, continuation);
        Object obj2 = interactiveRecord$matchAnimation$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = interactiveRecord$matchAnimation$1.label;
        if (i3 == 0) {
        }
        interactiveRecord2.playFile = (PAGFile) obj2;
        if (interactiveRecord.playFile != null) {
        }
    }

    public final void u(@NotNull DragonCardConfigData dragonCardConfigData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dragonCardConfigData);
        } else {
            Intrinsics.checkNotNullParameter(dragonCardConfigData, "<set-?>");
            this.config = dragonCardConfigData;
        }
    }
}
