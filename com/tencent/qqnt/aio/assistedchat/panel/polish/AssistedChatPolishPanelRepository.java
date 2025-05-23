package com.tencent.qqnt.aio.assistedchat.panel.polish;

import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$RecommendRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0015\u0018\u0000 \u001c2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b,\u0010-J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010(\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00158F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R+\u0010+\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00158F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\t\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelRepository;", "", "", "isRefresh", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/d;", "l", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "f", "Lkotlinx/coroutines/flow/Flow;", "k", "j", "Lcom/tencent/aio/data/AIOContact;", "a", "Lcom/tencent/aio/data/AIOContact;", "aioContact", "", "b", "Ljava/util/List;", "recommends", "", "c", "Ljava/lang/String;", "logKeywords", "", "d", "[B", "g", "()[B", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "([B)V", "extData", "<set-?>", "e", "Lkotlin/properties/ReadWriteProperty;", h.F, "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "inputContent", "i", "o", "promptId", "<init>", "(Lcom/tencent/aio/data/AIOContact;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatPolishPanelRepository {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f349207h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOContact aioContact;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.aio.assistedchat.model.c> recommends;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logKeywords;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private byte[] extData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReadWriteProperty inputContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReadWriteProperty promptId;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelRepository$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelRepository$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b extends ObservableProperty<String> {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AssistedChatPolishPanelRepository f349214b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, AssistedChatPolishPanelRepository assistedChatPolishPanelRepository) {
            super(obj);
            this.f349214b = assistedChatPolishPanelRepository;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj, (Object) assistedChatPolishPanelRepository);
            }
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(@NotNull KProperty<?> property, String oldValue, String newValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, property, oldValue, newValue);
                return;
            }
            Intrinsics.checkNotNullParameter(property, "property");
            if (!Intrinsics.areEqual(newValue, oldValue)) {
                this.f349214b.recommends.clear();
                this.f349214b.m(new byte[0]);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends ObservableProperty<String> {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AssistedChatPolishPanelRepository f349215b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Object obj, AssistedChatPolishPanelRepository assistedChatPolishPanelRepository) {
            super(obj);
            this.f349215b = assistedChatPolishPanelRepository;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj, (Object) assistedChatPolishPanelRepository);
            }
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(@NotNull KProperty<?> property, String oldValue, String newValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, property, oldValue, newValue);
                return;
            }
            Intrinsics.checkNotNullParameter(property, "property");
            if (!Intrinsics.areEqual(newValue, oldValue)) {
                this.f349215b.m(new byte[0]);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59224);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f349207h = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(AssistedChatPolishPanelRepository.class, "inputContent", "getInputContent()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(AssistedChatPolishPanelRepository.class, "promptId", "getPromptId()Ljava/lang/String;", 0))};
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatPolishPanelRepository(@NotNull AIOContact aioContact) {
        Intrinsics.checkNotNullParameter(aioContact, "aioContact");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContact);
            return;
        }
        this.aioContact = aioContact;
        this.recommends = new ArrayList();
        this.logKeywords = aioContact.e() + "-" + aioContact.j();
        this.extData = new byte[0];
        Delegates delegates = Delegates.INSTANCE;
        this.inputContent = new b("", this);
        this.promptId = new c("", this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.qqnt.aio.assistedchat.model.c> f() {
        return new ArrayList(this.recommends);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(boolean z16, Continuation<? super com.tencent.qqnt.aio.assistedchat.panel.subpanel.d> continuation) {
        int size;
        Continuation intercepted;
        Object coroutine_suspended;
        if (!AppNetConnInfo.isNetSupport()) {
            return new com.tencent.qqnt.aio.assistedchat.panel.subpanel.d(false, null, null, 6, null);
        }
        if (z16) {
            size = 0;
        } else {
            size = this.recommends.size();
        }
        int i3 = size;
        final String i16 = i();
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        com.tencent.qqnt.aio.assistedchat.request.a.c(com.tencent.qqnt.aio.assistedchat.request.a.f349425a, this.aioContact.e(), this.aioContact.j(), 3, h(), i3, null, 8, false, i16, g(), new Function3<Integer, String, AssistedChatPB$RecommendRsp, Unit>(cancellableContinuationImpl, i16) { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelRepository$requestPolishData$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ CancellableContinuation<com.tencent.qqnt.aio.assistedchat.panel.subpanel.d> $continuation;
            final /* synthetic */ String $requestPromptId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
                this.$continuation = cancellableContinuationImpl;
                this.$requestPromptId = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AssistedChatPolishPanelRepository.this, cancellableContinuationImpl, i16);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp) {
                invoke(num.intValue(), str, assistedChatPB$RecommendRsp);
                return Unit.INSTANCE;
            }

            public final void invoke(int i17, @Nullable String str, @Nullable AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i17), str, assistedChatPB$RecommendRsp);
                    return;
                }
                QLog.i("AssistedChatPolishPanelRepository", 1, "requestPolishData response code=" + i17 + " msg=" + str + " rsp=" + assistedChatPB$RecommendRsp);
                if (i17 == 0 && assistedChatPB$RecommendRsp != null) {
                    int i18 = assistedChatPB$RecommendRsp.rsp_head.ret_code.get();
                    if (i18 != 0) {
                        QLog.i("AssistedChatPolishPanelRepository", 1, "requestPolishData response ret_code=" + i18);
                    }
                    com.tencent.qqnt.aio.assistedchat.panel.subpanel.d b16 = com.tencent.qqnt.aio.assistedchat.protocolbuffer.a.b(assistedChatPB$RecommendRsp, 3, i18 == 0);
                    String str2 = this.$requestPromptId;
                    b16.l(i18);
                    b16.r(str2);
                    AssistedChatPolishPanelRepository.this.m(b16.d());
                    this.$continuation.resume(b16, AnonymousClass1.INSTANCE);
                    return;
                }
                this.$continuation.resume(new com.tencent.qqnt.aio.assistedchat.panel.subpanel.d(false, null, null, 6, null), AnonymousClass2.INSTANCE);
            }
        }, 160, null);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @NotNull
    public final byte[] g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.extData;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (String) this.inputContent.getValue(this, f349207h[0]);
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (String) this.promptId.getValue(this, f349207h[1]);
    }

    @NotNull
    public final Flow<com.tencent.qqnt.aio.assistedchat.panel.subpanel.d> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Flow) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return FlowKt.flow(new AssistedChatPolishPanelRepository$loadMore$1(this, null));
    }

    @NotNull
    public final Flow<com.tencent.qqnt.aio.assistedchat.panel.subpanel.d> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Flow) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return FlowKt.flow(new AssistedChatPolishPanelRepository$refresh$1(this, null));
    }

    public final void m(@NotNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
        } else {
            Intrinsics.checkNotNullParameter(bArr, "<set-?>");
            this.extData = bArr;
        }
    }

    public final void n(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.inputContent.setValue(this, f349207h[0], str);
        }
    }

    public final void o(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.promptId.setValue(this, f349207h[1], str);
        }
    }
}
