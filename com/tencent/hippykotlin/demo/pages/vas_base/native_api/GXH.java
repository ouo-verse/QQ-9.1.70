package com.tencent.hippykotlin.demo.pages.vas_base.native_api;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQContext;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXH;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class GXH {
    public GXH() {
        if (QQContext.INSTANCE.isDebug() && QQUtils.INSTANCE.compare("9.0.80") < 0) {
            throw new RuntimeException("debug\u5305\u5f02\u5e38\uff1a\u4e0d\u652f\u63019085\u4ee5\u4e0b\u7248\u672c\u8c03\u7528");
        }
    }

    public final Object getCustomBgList(Continuation<? super List<CustomBgItemInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        VasModule.Companion.getInstance().toNative(false, "gxhGetCustomBgList", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXH$getCustomBgList$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                b l3;
                int c16;
                e eVar2 = eVar;
                ArrayList arrayList = new ArrayList();
                if (eVar2 != null && (l3 = eVar2.l("result")) != null && (c16 = l3.c()) >= 0) {
                    int i3 = 0;
                    while (true) {
                        e l16 = l3.l(i3);
                        if (l16 != null) {
                            arrayList.add(new GXH.CustomBgItemInfo(l16.p("uin"), l16.p("nick"), l16.j("type"), l16.j("effectId"), l16.p("imageName")));
                        }
                        if (i3 == c16) {
                            break;
                        }
                        i3++;
                    }
                }
                safeContinuation.resumeWith(Result.m476constructorimpl(arrayList));
                return Unit.INSTANCE;
            }
        }, false);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class CustomBgItemInfo {
        public final int effectId;
        public final String imageName;
        public final String nick;
        public final int type;
        public final String uin;

        public CustomBgItemInfo(String str, String str2, int i3, int i16, String str3) {
            this.uin = str;
            this.nick = str2;
            this.type = i3;
            this.effectId = i16;
            this.imageName = str3;
        }

        public final int hashCode() {
            return this.imageName.hashCode() + QQAudioParams$$ExternalSyntheticOutline0.m(this.effectId, QQAudioParams$$ExternalSyntheticOutline0.m(this.type, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.nick, this.uin.hashCode() * 31, 31), 31), 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CustomBgItemInfo(uin=");
            m3.append(this.uin);
            m3.append(", nick=");
            m3.append(this.nick);
            m3.append(", type=");
            m3.append(this.type);
            m3.append(", effectId=");
            m3.append(this.effectId);
            m3.append(", imageName=");
            return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.imageName, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomBgItemInfo)) {
                return false;
            }
            CustomBgItemInfo customBgItemInfo = (CustomBgItemInfo) obj;
            return Intrinsics.areEqual(this.uin, customBgItemInfo.uin) && Intrinsics.areEqual(this.nick, customBgItemInfo.nick) && this.type == customBgItemInfo.type && this.effectId == customBgItemInfo.effectId && Intrinsics.areEqual(this.imageName, customBgItemInfo.imageName);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Result {
        public final String message;
        public final int result;
        public final int status;

        public Result(int i3, String str, int i16) {
            this.result = i3;
            this.message = str;
            this.status = i16;
        }

        public final int hashCode() {
            return this.status + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.message, this.result * 31, 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Result(result=");
            m3.append(this.result);
            m3.append(", message=");
            m3.append(this.message);
            m3.append(", status=");
            return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.status, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return this.result == result.result && Intrinsics.areEqual(this.message, result.message) && this.status == result.status;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /* JADX WARN: Type inference failed for: r12v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, com.tencent.kuikly.core.nvi.serialization.json.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object batchSetCustomBg(e eVar, Continuation<? super Result> continuation) {
        GXH$batchSetCustomBg$1 gXH$batchSetCustomBg$1;
        Object coroutine_suspended;
        int i3;
        e eVar2;
        Continuation intercepted;
        Object orThrow;
        Object coroutine_suspended2;
        GXH gxh;
        e eVar3;
        GXH gxh2;
        e eVar4;
        List<CustomBgItemInfo> list;
        ?? l3;
        Continuation intercepted2;
        Object coroutine_suspended3;
        Object d16;
        if (continuation instanceof GXH$batchSetCustomBg$1) {
            gXH$batchSetCustomBg$1 = (GXH$batchSetCustomBg$1) continuation;
            int i16 = gXH$batchSetCustomBg$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                gXH$batchSetCustomBg$1.label = i16 - Integer.MIN_VALUE;
                Object obj = gXH$batchSetCustomBg$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = gXH$batchSetCustomBg$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj);
                                e eVar5 = (e) obj;
                                return new Result(eVar5.k("result", -1), eVar5.p("message"), eVar5.k("status", -1));
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        eVar4 = gXH$batchSetCustomBg$1.L$1;
                        gxh2 = gXH$batchSetCustomBg$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        list = (List) obj;
                        String p16 = eVar4.p("friendUin");
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        objectRef.element = "";
                        if (list != null) {
                            for (CustomBgItemInfo customBgItemInfo : list) {
                                if ((customBgItemInfo instanceof CustomBgItemInfo) && Intrinsics.areEqual(customBgItemInfo.uin, p16)) {
                                    objectRef.element = customBgItemInfo.imageName;
                                }
                            }
                        }
                        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        l3 = eVar4.l("batchSet");
                        objectRef2.element = l3;
                        if (l3 != 0) {
                            int c16 = l3.c();
                            for (int i17 = 0; i17 < c16; i17++) {
                                if (BooleanCompanionObject.INSTANCE instanceof e) {
                                    d16 = Boxing.boxBoolean(l3.e(i17));
                                } else if (IntCompanionObject.INSTANCE instanceof e) {
                                    d16 = Boxing.boxInt(l3.i(i17));
                                } else if (LongCompanionObject.INSTANCE instanceof e) {
                                    d16 = Boxing.boxLong(l3.m(i17));
                                } else if (StringCompanionObject.INSTANCE instanceof e) {
                                    d16 = l3.o(i17);
                                } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                                    d16 = Boxing.boxDouble(l3.g(i17));
                                } else {
                                    d16 = l3.d(i17);
                                }
                                if (d16 != null) {
                                    ((e) d16).v("imageName", objectRef.element);
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                }
                            }
                        }
                        final e eVar6 = new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXH$batchSetCustomBg$response$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar7) {
                                e eVar8 = eVar7;
                                eVar8.z("itemId", ThemeBackground.DIY_UPLOAD_BG_ID);
                                eVar8.z("batchSet", objectRef2.element);
                                return Unit.INSTANCE;
                            }
                        });
                        gXH$batchSetCustomBg$1.L$0 = null;
                        gXH$batchSetCustomBg$1.L$1 = null;
                        gXH$batchSetCustomBg$1.label = 3;
                        gxh2.getClass();
                        intercepted2 = IntrinsicsKt__IntrinsicsJvmKt.intercepted(gXH$batchSetCustomBg$1);
                        final SafeContinuation safeContinuation = new SafeContinuation(intercepted2);
                        VasModule.Companion.getInstance().toNative(false, "gxhNotify", new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXH$notify$2$1
                            public final /* synthetic */ String $business = "8";
                            public final /* synthetic */ String $setKey = "";

                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar7) {
                                e eVar8 = eVar7;
                                eVar8.z("business", this.$business);
                                eVar8.z("data", e.this);
                                eVar8.z(VasCommonJsbProxy.JSON_KEY_SET_KEY, this.$setKey);
                                return Unit.INSTANCE;
                            }
                        }).toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXH$notify$2$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar7) {
                                e eVar8 = eVar7;
                                Continuation<e> continuation2 = safeContinuation;
                                Result.Companion companion = Result.INSTANCE;
                                if (eVar8 == null) {
                                    eVar8 = new e(INativeApi$Companion$wrapJsonCallback$1.INSTANCE);
                                }
                                continuation2.resumeWith(Result.m476constructorimpl(eVar8));
                                return Unit.INSTANCE;
                            }
                        }, false);
                        obj = safeContinuation.getOrThrow();
                        coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (obj == coroutine_suspended3) {
                            DebugProbes.probeCoroutineSuspended(gXH$batchSetCustomBg$1);
                        }
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        e eVar52 = (e) obj;
                        return new Result(eVar52.k("result", -1), eVar52.p("message"), eVar52.k("status", -1));
                    }
                    e eVar7 = gXH$batchSetCustomBg$1.L$1;
                    gxh = gXH$batchSetCustomBg$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    orThrow = obj;
                    eVar2 = eVar7;
                } else {
                    ResultKt.throwOnFailure(obj);
                    gXH$batchSetCustomBg$1.L$0 = this;
                    eVar2 = eVar;
                    gXH$batchSetCustomBg$1.L$1 = eVar2;
                    gXH$batchSetCustomBg$1.label = 1;
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(gXH$batchSetCustomBg$1);
                    final SafeContinuation safeContinuation2 = new SafeContinuation(intercepted);
                    VasModule.Companion.getInstance().toNative(false, "setBackgroundPhoto", eVar.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXH$setBackgroundPhoto$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar8) {
                            e eVar9 = eVar8;
                            Continuation<e> continuation2 = safeContinuation2;
                            Result.Companion companion = Result.INSTANCE;
                            if (eVar9 == null) {
                                eVar9 = new e(INativeApi$Companion$wrapJsonCallback$1.INSTANCE);
                            }
                            continuation2.resumeWith(Result.m476constructorimpl(eVar9));
                            return Unit.INSTANCE;
                        }
                    }, true);
                    orThrow = safeContinuation2.getOrThrow();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (orThrow == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(gXH$batchSetCustomBg$1);
                    }
                    if (orThrow == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    gxh = this;
                }
                eVar3 = (e) orThrow;
                if (!Intrinsics.areEqual(eVar3.p("result"), "0")) {
                    gXH$batchSetCustomBg$1.L$0 = gxh;
                    gXH$batchSetCustomBg$1.L$1 = eVar2;
                    gXH$batchSetCustomBg$1.label = 2;
                    Object customBgList = gxh.getCustomBgList(gXH$batchSetCustomBg$1);
                    if (customBgList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    gxh2 = gxh;
                    eVar4 = eVar2;
                    obj = customBgList;
                    list = (List) obj;
                    String p162 = eVar4.p("friendUin");
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    objectRef3.element = "";
                    if (list != null) {
                    }
                    final Ref.ObjectRef<b> objectRef22 = new Ref.ObjectRef();
                    l3 = eVar4.l("batchSet");
                    objectRef22.element = l3;
                    if (l3 != 0) {
                    }
                    final e eVar62 = new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXH$batchSetCustomBg$response$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar72) {
                            e eVar8 = eVar72;
                            eVar8.z("itemId", ThemeBackground.DIY_UPLOAD_BG_ID);
                            eVar8.z("batchSet", objectRef22.element);
                            return Unit.INSTANCE;
                        }
                    });
                    gXH$batchSetCustomBg$1.L$0 = null;
                    gXH$batchSetCustomBg$1.L$1 = null;
                    gXH$batchSetCustomBg$1.label = 3;
                    gxh2.getClass();
                    intercepted2 = IntrinsicsKt__IntrinsicsJvmKt.intercepted(gXH$batchSetCustomBg$1);
                    final Continuation<? super e> safeContinuation3 = new SafeContinuation(intercepted2);
                    VasModule.Companion.getInstance().toNative(false, "gxhNotify", new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXH$notify$2$1
                        public final /* synthetic */ String $business = "8";
                        public final /* synthetic */ String $setKey = "";

                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar72) {
                            e eVar8 = eVar72;
                            eVar8.z("business", this.$business);
                            eVar8.z("data", e.this);
                            eVar8.z(VasCommonJsbProxy.JSON_KEY_SET_KEY, this.$setKey);
                            return Unit.INSTANCE;
                        }
                    }).toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXH$notify$2$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar72) {
                            e eVar8 = eVar72;
                            Continuation<e> continuation2 = safeContinuation3;
                            Result.Companion companion = Result.INSTANCE;
                            if (eVar8 == null) {
                                eVar8 = new e(INativeApi$Companion$wrapJsonCallback$1.INSTANCE);
                            }
                            continuation2.resumeWith(Result.m476constructorimpl(eVar8));
                            return Unit.INSTANCE;
                        }
                    }, false);
                    obj = safeContinuation3.getOrThrow();
                    coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (obj == coroutine_suspended3) {
                    }
                    if (obj == coroutine_suspended) {
                    }
                    e eVar522 = (e) obj;
                    return new Result(eVar522.k("result", -1), eVar522.p("message"), eVar522.k("status", -1));
                }
                return new Result(Integer.parseInt(eVar3.p("result")), eVar3.p("message"), -1);
            }
        }
        gXH$batchSetCustomBg$1 = new GXH$batchSetCustomBg$1(this, continuation);
        Object obj2 = gXH$batchSetCustomBg$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = gXH$batchSetCustomBg$1.label;
        if (i3 == 0) {
        }
        eVar3 = (e) orThrow;
        if (!Intrinsics.areEqual(eVar3.p("result"), "0")) {
        }
    }
}
