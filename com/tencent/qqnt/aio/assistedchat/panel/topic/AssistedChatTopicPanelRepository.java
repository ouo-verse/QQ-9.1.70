package com.tencent.qqnt.aio.assistedchat.panel.topic;

import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.cache.AssistedChatCacheHelper;
import com.tencent.qqnt.aio.assistedchat.model.c;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.d;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$RecommendRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0011\u0018\u0000 02\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b.\u0010/J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001b\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010-\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/topic/AssistedChatTopicPanelRepository;", "", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/d;", "j", "", "isRefresh", "k", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", h.F, "Lkotlinx/coroutines/flow/Flow;", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/data/AIOContact;", "a", "Lcom/tencent/aio/data/AIOContact;", "aioContact", "", "b", "Ljava/util/List;", "recommends", "Lcom/tencent/qqnt/aio/assistedchat/cache/AssistedChatCacheHelper;", "c", "Lkotlin/Lazy;", "i", "()Lcom/tencent/qqnt/aio/assistedchat/cache/AssistedChatCacheHelper;", "cacheHelper", "", "d", "Ljava/lang/String;", "logKeywords", "", "e", "[B", "l", "()[B", "o", "([B)V", "extData", "f", "getShowPanelSource", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "showPanelSource", "<init>", "(Lcom/tencent/aio/data/AIOContact;)V", "g", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatTopicPanelRepository {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOContact aioContact;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c> recommends;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cacheHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logKeywords;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private byte[] extData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String showPanelSource;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/topic/AssistedChatTopicPanelRepository$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.topic.AssistedChatTopicPanelRepository$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59754);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatTopicPanelRepository(@NotNull AIOContact aioContact) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(aioContact, "aioContact");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContact);
            return;
        }
        this.aioContact = aioContact;
        this.recommends = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AssistedChatCacheHelper>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.topic.AssistedChatTopicPanelRepository$cacheHelper$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatTopicPanelRepository.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AssistedChatCacheHelper invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AssistedChatCacheHelper) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
                if (currentAccountUin == null) {
                    currentAccountUin = "";
                }
                return new AssistedChatCacheHelper(context, currentAccountUin, AssistedChatTopicPanelRepository.this.aioContact.e(), AssistedChatTopicPanelRepository.this.aioContact.j(), 1);
            }
        });
        this.cacheHelper = lazy;
        this.logKeywords = aioContact.e() + "-" + aioContact.j();
        this.extData = new byte[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<c> h() {
        return new ArrayList(this.recommends);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AssistedChatCacheHelper i() {
        return (AssistedChatCacheHelper) this.cacheHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d j() {
        try {
            AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp = new AssistedChatPB$RecommendRsp();
            byte[] k3 = i().k();
            if (k3 == null) {
                return null;
            }
            assistedChatPB$RecommendRsp.mergeFrom(k3);
            return com.tencent.qqnt.aio.assistedchat.protocolbuffer.a.c(assistedChatPB$RecommendRsp, 5, false, 2, null);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("AssistedChatTopicPanelRepository", 1, "getDataFromCache exception: ", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object k(final boolean z16, Continuation<? super d> continuation) {
        Continuation intercepted;
        int size;
        Object coroutine_suspended;
        if (AppNetConnInfo.isNetSupport()) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            if (z16) {
                size = 0;
            } else {
                size = this.recommends.size();
            }
            int i3 = size;
            final int i16 = 5;
            com.tencent.qqnt.aio.assistedchat.request.a.c(com.tencent.qqnt.aio.assistedchat.request.a.f349425a, this.aioContact.e(), this.aioContact.j(), 5, null, i3, null, 8, false, null, l(), new Function3<Integer, String, AssistedChatPB$RecommendRsp, Unit>(z16, this, i16, cancellableContinuationImpl) { // from class: com.tencent.qqnt.aio.assistedchat.panel.topic.AssistedChatTopicPanelRepository$getDataFromServer$2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ CancellableContinuation<d> $continuation;
                final /* synthetic */ boolean $isRefresh;
                final /* synthetic */ int $scene;
                final /* synthetic */ AssistedChatTopicPanelRepository this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.$isRefresh = z16;
                    this.this$0 = this;
                    this.$scene = i16;
                    this.$continuation = cancellableContinuationImpl;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), this, Integer.valueOf(i16), cancellableContinuationImpl);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp) {
                    invoke(num.intValue(), str, assistedChatPB$RecommendRsp);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i17, @Nullable String str, @Nullable AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp) {
                    AssistedChatCacheHelper i18;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i17), str, assistedChatPB$RecommendRsp);
                        return;
                    }
                    QLog.i("AssistedChatTopicPanelRepository", 1, "getDataFromServer response code=" + i17 + " msg=" + str + " rsp=" + assistedChatPB$RecommendRsp);
                    if (i17 == 0 && assistedChatPB$RecommendRsp != null) {
                        if (this.$isRefresh) {
                            i18 = this.this$0.i();
                            byte[] byteArray = assistedChatPB$RecommendRsp.toByteArray();
                            Intrinsics.checkNotNullExpressionValue(byteArray, "rsp.toByteArray()");
                            i18.m(byteArray);
                        }
                        int i19 = assistedChatPB$RecommendRsp.rsp_head.ret_code.get();
                        if (i19 != 0) {
                            QLog.i("AssistedChatTopicPanelRepository", 1, "getDataFromServer response ret_code=" + i19);
                        }
                        d b16 = com.tencent.qqnt.aio.assistedchat.protocolbuffer.a.b(assistedChatPB$RecommendRsp, this.$scene, i19 == 0);
                        b16.l(i19);
                        this.this$0.o(b16.d());
                        this.$continuation.resume(b16, AnonymousClass1.INSTANCE);
                        return;
                    }
                    this.$continuation.resume(new d(false, null, null, 6, null), AnonymousClass2.INSTANCE);
                }
            }, 424, null);
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return new d(false, null, null, 6, null);
    }

    @NotNull
    public final byte[] l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.extData;
    }

    @NotNull
    public final Flow<d> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Flow) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return FlowKt.flow(new AssistedChatTopicPanelRepository$loadMoreRecommends$1(this, null));
    }

    @NotNull
    public final Flow<d> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Flow) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return FlowKt.flow(new AssistedChatTopicPanelRepository$refreshRecommends$1(this, null));
    }

    public final void o(@NotNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
        } else {
            Intrinsics.checkNotNullParameter(bArr, "<set-?>");
            this.extData = bArr;
        }
    }

    public final void p(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.showPanelSource = str;
        }
    }
}
