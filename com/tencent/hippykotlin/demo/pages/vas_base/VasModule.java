package com.tencent.hippykotlin.demo.pages.vas_base;

import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.AioPanelFontBubble;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.AudioManager;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.Card;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.FileOperation;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.FriendsImpl;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXHImpl;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.INativeApi;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.Login;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.Photo;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.Reader;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.Recharge;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.Secret;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.ThemeImpl;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.UpdateSystemImpl;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.vas.spanend.IH5DataCacheApi;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VasModule extends Module implements INativeApi {
    public static final Companion Companion = new Companion();
    public final /* synthetic */ ThemeImpl $$delegate_1 = new ThemeImpl();
    public final /* synthetic */ GXHImpl $$delegate_2 = new GXHImpl();
    public final /* synthetic */ FriendsImpl $$delegate_4;
    public final /* synthetic */ UpdateSystemImpl $$delegate_7;
    public final Lazy mainClientVersion$delegate;
    public final Lazy platformType$delegate;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public final VasModule getInstance() {
            return (VasModule) c.f117352a.g().acquireModule("VasKuiklyModule");
        }
    }

    public VasModule() {
        Lazy lazy;
        Lazy lazy2;
        LazyKt__LazyJVMKt.lazy(new Function0<Recharge>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.RechargeImpl$recharge$2
            @Override // kotlin.jvm.functions.Function0
            public final Recharge invoke() {
                return new Recharge();
            }
        });
        this.$$delegate_4 = new FriendsImpl();
        LazyKt__LazyJVMKt.lazy(new Function0<FileOperation>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.FileImpl$file$2
            @Override // kotlin.jvm.functions.Function0
            public final FileOperation invoke() {
                return new FileOperation();
            }
        });
        this.$$delegate_7 = new UpdateSystemImpl();
        LazyKt__LazyJVMKt.lazy(new Function0<AudioManager>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.VasAudioImpl$audio$2
            @Override // kotlin.jvm.functions.Function0
            public final AudioManager invoke() {
                return new AudioManager();
            }
        });
        LazyKt__LazyJVMKt.lazy(new Function0<Reader>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.ReaderImpl$reader$2
            @Override // kotlin.jvm.functions.Function0
            public final Reader invoke() {
                return new Reader();
            }
        });
        LazyKt__LazyJVMKt.lazy(new Function0<Photo>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.PhotoImpl$photo$2
            @Override // kotlin.jvm.functions.Function0
            public final Photo invoke() {
                return new Photo();
            }
        });
        LazyKt__LazyJVMKt.lazy(new Function0<Card>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.CardImpl$card$2
            @Override // kotlin.jvm.functions.Function0
            public final Card invoke() {
                return new Card();
            }
        });
        LazyKt__LazyJVMKt.lazy(new Function0<Secret>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.SecretImpl$secret$2
            @Override // kotlin.jvm.functions.Function0
            public final Secret invoke() {
                return new Secret();
            }
        });
        LazyKt__LazyJVMKt.lazy(new Function0<AioPanelFontBubble>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.AioPanelFontBubbleImpl$aioPanelFontBubble$2
            @Override // kotlin.jvm.functions.Function0
            public final AioPanelFontBubble invoke() {
                return new AioPanelFontBubble();
            }
        });
        LazyKt__LazyJVMKt.lazy(new Function0<Login>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.LoginImpl$login$2
            @Override // kotlin.jvm.functions.Function0
            public final Login invoke() {
                return new Login();
            }
        });
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasModule$platformType$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Integer intOrNull;
                VasModule vasModule = VasModule.this;
                vasModule.getClass();
                KLog.INSTANCE.e("VasModule", "onGetPlatformType");
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(vasModule.toNative(false, "getPlatformType", null, null, true).toString());
                return Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0);
            }
        });
        this.platformType$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasModule$mainClientVersion$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                VasModule vasModule = VasModule.this;
                vasModule.getClass();
                KLog.INSTANCE.e("VasModule", "onGetPlatformMainVersion");
                return vasModule.toNative(false, "getMainClientVersion", null, null, true).toString();
            }
        });
        this.mainClientVersion$delegate = lazy2;
    }

    public final Friends getFriends() {
        return (Friends) this.$$delegate_4.friends$delegate.getValue();
    }

    public final String getMainClientVersion() {
        return (String) this.mainClientVersion$delegate.getValue();
    }

    public final int getPlatformType() {
        return ((Number) this.platformType$delegate.getValue()).intValue();
    }

    public final boolean isDarkTheme() {
        this.$$delegate_1.getClass();
        if (QQUtils.INSTANCE.compare("9.0.35") >= 0) {
            return Intrinsics.areEqual(Companion.getInstance().toNative(false, "isDarkTheme", null, null, true).getReturnValue(), Boolean.TRUE);
        }
        return QUIToken.INSTANCE.isNightMode();
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "VasKuiklyModule";
    }

    public final void openPage(String str) {
        KLog.INSTANCE.e("VasModule", IndividuationPlugin.Method_OpenPage);
        toNative(false, IndividuationPlugin.Method_OpenPage, str, null, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setBackgroundPhoto(e eVar, Function3<? super String, ? super String, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        VasModule$setBackgroundPhoto$1 vasModule$setBackgroundPhoto$1;
        Object coroutine_suspended;
        int i3;
        Continuation intercepted;
        Object coroutine_suspended2;
        Object first;
        Object second;
        if (continuation instanceof VasModule$setBackgroundPhoto$1) {
            vasModule$setBackgroundPhoto$1 = (VasModule$setBackgroundPhoto$1) continuation;
            int i16 = vasModule$setBackgroundPhoto$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                vasModule$setBackgroundPhoto$1.label = i16 - Integer.MIN_VALUE;
                Object obj = vasModule$setBackgroundPhoto$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = vasModule$setBackgroundPhoto$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    KLog.INSTANCE.e("VasModule", "setBackgroundPhoto " + eVar);
                    vasModule$setBackgroundPhoto$1.L$0 = this;
                    vasModule$setBackgroundPhoto$1.L$1 = eVar;
                    vasModule$setBackgroundPhoto$1.L$2 = function3;
                    vasModule$setBackgroundPhoto$1.label = 1;
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(vasModule$setBackgroundPhoto$1);
                    final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                    toNative(false, "setBackgroundPhoto", eVar.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasModule$setBackgroundPhoto$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar2) {
                            String str;
                            String p16;
                            e eVar3 = eVar2;
                            String str2 = "";
                            if (eVar3 == null || (str = eVar3.p("result")) == null) {
                                str = "";
                            }
                            if (eVar3 != null && (p16 = eVar3.p("msg")) != null) {
                                str2 = p16;
                            }
                            KLog.INSTANCE.e("VasModule", QUISkinImage$$ExternalSyntheticOutline0.m("setBackgroundPhoto result = ", str, " msg = ", str2));
                            Continuation<Pair<String, String>> continuation2 = safeContinuation;
                            Result.Companion companion = Result.INSTANCE;
                            continuation2.resumeWith(Result.m476constructorimpl(TuplesKt.to(str, str2)));
                            return Unit.INSTANCE;
                        }
                    }, true);
                    obj = safeContinuation.getOrThrow();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (obj == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(vasModule$setBackgroundPhoto$1);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function3 = vasModule$setBackgroundPhoto$1.L$2;
                    ResultKt.throwOnFailure(obj);
                }
                Pair pair = (Pair) obj;
                first = pair.getFirst();
                second = pair.getSecond();
                vasModule$setBackgroundPhoto$1.L$0 = obj;
                vasModule$setBackgroundPhoto$1.L$1 = null;
                vasModule$setBackgroundPhoto$1.L$2 = null;
                vasModule$setBackgroundPhoto$1.label = 2;
                if (function3.invoke(first, second, vasModule$setBackgroundPhoto$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        vasModule$setBackgroundPhoto$1 = new VasModule$setBackgroundPhoto$1(this, continuation);
        Object obj2 = vasModule$setBackgroundPhoto$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = vasModule$setBackgroundPhoto$1.label;
        if (i3 != 0) {
        }
        Pair pair2 = (Pair) obj2;
        first = pair2.getFirst();
        second = pair2.getSecond();
        vasModule$setBackgroundPhoto$1.L$0 = obj2;
        vasModule$setBackgroundPhoto$1.L$1 = null;
        vasModule$setBackgroundPhoto$1.L$2 = null;
        vasModule$setBackgroundPhoto$1.label = 2;
        if (function3.invoke(first, second, vasModule$setBackgroundPhoto$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    public final void updateCurrentChatBgId(String str, int i3) {
        KLog.INSTANCE.e("VasModule", "updateCurrentChatBgId");
        e eVar = new e();
        eVar.v("chat_uin", str);
        eVar.v("chat_type", String.valueOf(i3));
        toNative(false, "updateCurrentChatBgId", eVar.toString(), null, false);
    }

    public final void writeH5Data(String str, String str2, String str3, Function1 function1) {
        if (QQUtils.INSTANCE.compare("9.0.65") >= 0) {
            e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("host", "qq.com", "path", str);
            m3.v("key", str2);
            m3.v("data", str3);
            Unit unit = Unit.INSTANCE;
            toNative(false, IH5DataCacheApi.METHOD_WRITE_H5_DATA, m3.toString(), function1, false);
        }
    }
}
