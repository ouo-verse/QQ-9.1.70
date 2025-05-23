package com.tencent.mobileqq.qqlive.api.room.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveHuYaRoomApi;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYa;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYaUrlManager;
import com.tencent.mobileqq.qqlive.huya.d;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import com.tencent.mobileqq.qqlive.sail.sso.request.GetHuYaRoomPlayRequest;
import com.tencent.mobileqq.qqlive.sail.ui.definition.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt3.j;
import rt3.m;
import rt3.q;
import rt3.u;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J.\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J*\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\t\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0006H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/impl/QQLiveHuYaRoomApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/room/IQQLiveHuYaRoomApi;", "", "roomId", "Lrt3/j;", "flv", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYaUrlManager$HuYaUrlInfo;", "", "callback", "getAndCacheInfo", "", "Ljava/lang/Void;", "getHuYaRoomPreviewUrl", "Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "getCurrentAnchorInfo", "<init>", "()V", "Companion", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveHuYaRoomApiImpl implements IQQLiveHuYaRoomApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "QQLiveHuYaRoomApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/impl/QQLiveHuYaRoomApiImpl$Companion;", "", "()V", "TAG", "", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21936);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveHuYaRoomApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        if (r11 != false) goto L12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void getAndCacheInfo(final long roomId, j flv, final Function1<? super QQLiveHuYaUrlManager.HuYaUrlInfo, Unit> callback) {
        boolean isBlank;
        final int a16 = a.INSTANCE.a();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        u[] uVarArr = flv.f432315c;
        Intrinsics.checkNotNullExpressionValue(uVarArr, "flv.lineDetail");
        boolean z16 = false;
        for (u uVar : uVarArr) {
            if (QQLiveHuYa.f271333a.h(uVar.f432359b) == a16) {
                objectRef.element = uVar.f432360c;
            }
        }
        CharSequence charSequence = (CharSequence) objectRef.element;
        if (charSequence != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(charSequence);
        }
        z16 = true;
        if (z16) {
            callback.invoke(null);
            return;
        }
        QQLiveHuYa qQLiveHuYa = QQLiveHuYa.f271333a;
        T t16 = objectRef.element;
        Intrinsics.checkNotNull(t16);
        qQLiveHuYa.i((String) t16, new d(roomId, objectRef, a16, callback) { // from class: com.tencent.mobileqq.qqlive.api.room.impl.QQLiveHuYaRoomApiImpl$getAndCacheInfo$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function1<QQLiveHuYaUrlManager.HuYaUrlInfo, Unit> $callback;
            final /* synthetic */ int $hintLevel;
            final /* synthetic */ Ref.ObjectRef<String> $originUrl;
            final /* synthetic */ long $roomId;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$roomId = roomId;
                this.$originUrl = objectRef;
                this.$hintLevel = a16;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Long.valueOf(roomId), objectRef, Integer.valueOf(a16), callback);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.huya.d
            public void onUrlCallback(@Nullable String urlWithToken) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) urlWithToken);
                    return;
                }
                QLog.i("QQLiveHuYaRoomApiImpl", 2, "getHuYaRoomPreviewUrl roomId=" + this.$roomId + ", originUrl=" + ((Object) this.$originUrl.element) + " urlWithToken:" + urlWithToken);
                String str = this.$originUrl.element;
                Intrinsics.checkNotNull(str);
                String str2 = str;
                if (urlWithToken == null) {
                    urlWithToken = "";
                }
                QQLiveHuYaUrlManager.HuYaUrlInfo huYaUrlInfo = new QQLiveHuYaUrlManager.HuYaUrlInfo(str2, urlWithToken, this.$hintLevel);
                QQLiveHuYaUrlManager.f271340a.c(this.$roomId, huYaUrlInfo);
                this.$callback.invoke(huYaUrlInfo);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IQQLiveHuYaRoomApi
    @Nullable
    public UserInfo getCurrentAnchorInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UserInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return c.f272176a.o();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IQQLiveHuYaRoomApi
    public void getHuYaRoomPreviewUrl(final long roomId, @Nullable final Function1<? super String, Void> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(roomId), callback);
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetHuYaRoomPlayRequest(roomId), new Function1<QQLiveResponse<m>, Unit>(roomId, callback, this) { // from class: com.tencent.mobileqq.qqlive.api.room.impl.QQLiveHuYaRoomApiImpl$getHuYaRoomPreviewUrl$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<String, Void> $callback;
                final /* synthetic */ long $roomId;
                final /* synthetic */ QQLiveHuYaRoomApiImpl this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$roomId = roomId;
                    this.$callback = callback;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Long.valueOf(roomId), callback, this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<m> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<m> response) {
                    j jVar;
                    q qVar;
                    j[] jVarArr;
                    Object firstOrNull;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isFailed() && response.getRsp() != null) {
                        m rsp = response.getRsp();
                        if (rsp == null || (qVar = rsp.f432326a) == null || (jVarArr = qVar.f432349m) == null) {
                            jVar = null;
                        } else {
                            firstOrNull = ArraysKt___ArraysKt.firstOrNull(jVarArr);
                            jVar = (j) firstOrNull;
                        }
                        if (jVar == null) {
                            QLog.w("QQLiveHuYaRoomApiImpl", 1, "getHuYaRoomPreviewUrl roomId=" + this.$roomId + ", flv is null");
                            Function1<String, Void> function1 = this.$callback;
                            if (function1 != null) {
                                function1.invoke(null);
                                return;
                            }
                            return;
                        }
                        QQLiveHuYaRoomApiImpl qQLiveHuYaRoomApiImpl = this.this$0;
                        long j3 = this.$roomId;
                        qQLiveHuYaRoomApiImpl.getAndCacheInfo(j3, jVar, new Function1<QQLiveHuYaUrlManager.HuYaUrlInfo, Unit>(j3, this.$callback) { // from class: com.tencent.mobileqq.qqlive.api.room.impl.QQLiveHuYaRoomApiImpl$getHuYaRoomPreviewUrl$1.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Function1<String, Void> $callback;
                            final /* synthetic */ long $roomId;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                this.$roomId = j3;
                                this.$callback = r7;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, Long.valueOf(j3), r7);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(QQLiveHuYaUrlManager.HuYaUrlInfo huYaUrlInfo) {
                                invoke2(huYaUrlInfo);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@Nullable QQLiveHuYaUrlManager.HuYaUrlInfo huYaUrlInfo) {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this, (Object) huYaUrlInfo);
                                    return;
                                }
                                QLog.i("QQLiveHuYaRoomApiImpl", 1, "getHuYaRoomPreviewUrl roomId=" + this.$roomId + ", info=" + huYaUrlInfo);
                                Function1<String, Void> function12 = this.$callback;
                                if (function12 != null) {
                                    function12.invoke(huYaUrlInfo != null ? huYaUrlInfo.getUrlWithToken() : null);
                                }
                            }
                        });
                        return;
                    }
                    QLog.w("QQLiveHuYaRoomApiImpl", 1, "getHuYaRoomPreviewUrl roomId=" + this.$roomId + ", response=" + response);
                    Function1<String, Void> function12 = this.$callback;
                    if (function12 != null) {
                        function12.invoke(null);
                    }
                }
            });
        }
    }
}
