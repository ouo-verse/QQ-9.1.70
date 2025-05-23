package com.tencent.hippykotlin.demo.pages.nearby.public_account_follow;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.PublicAccountConfig;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.PublicAccountUtils;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.NBPBaseActivity;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPPublicAccountFollowActivity extends NBPBaseActivity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public int appId;
    public INBPPublicAccountFollowModalHandle modal;

    public static final void access$onClosed(NBPPublicAccountFollowActivity nBPPublicAccountFollowActivity) {
        nBPPublicAccountFollowActivity.getClass();
        k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
        e eVar = new e();
        eVar.t("app_id", nBPPublicAccountFollowActivity.appId);
        eVar.w(QCircleDaTongConstant.ElementParamValue.FOLLOWED, false);
        Unit unit = Unit.INSTANCE;
        k.d(kVar, "NEARBY_CLOSE_PUBLIC_ACCOUNT_GUIDE_EVENT", eVar, false, 4, null);
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.closePage$default();
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        this.appId = getPageData().n().k("app_id", 2);
        b.c(this, null, ComposableLambdaKt.composableLambdaInstance(1522186419, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity$onCreate$1

            /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity$onCreate$1$1, reason: invalid class name */
            /* loaded from: classes31.dex */
            public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPPublicAccountFollowActivity.access$onClosed((NBPPublicAccountFollowActivity) this.receiver);
                    return Unit.INSTANCE;
                }

                public AnonymousClass1(Object obj) {
                    super(0, obj, NBPPublicAccountFollowActivity.class, "onClosed", "onClosed()V", 0);
                }
            }

            /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity$onCreate$1$2, reason: invalid class name */
            /* loaded from: classes31.dex */
            public final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Integer num) {
                    String str;
                    final int intValue = num.intValue();
                    final NBPPublicAccountFollowActivity nBPPublicAccountFollowActivity = (NBPPublicAccountFollowActivity) this.receiver;
                    int i3 = NBPPublicAccountFollowActivity.$r8$clinit;
                    nBPPublicAccountFollowActivity.getClass();
                    PublicAccountUtils publicAccountUtils = PublicAccountUtils.INSTANCE;
                    boolean isFollowed = publicAccountUtils.isFollowed(intValue);
                    KLog.INSTANCE.i("NPMPublicAccountFollowActivity", "onFollow appId=" + intValue + ", \u5df2\u7ecf\u5173\u6ce8=" + isFollowed);
                    final Function1<Boolean, Unit> function1 = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003a: CONSTRUCTOR (r2v2 'function1' kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit>) = 
                          (r7v2 'intValue' int A[DONT_INLINE])
                          (r0v1 'nBPPublicAccountFollowActivity' com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity A[DONT_INLINE])
                         A[DECLARE_VAR, MD:(int, com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity):void (m)] (LINE:59) call: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity$onFollow$1.<init>(int, com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity):void type: CONSTRUCTOR in method: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity$onCreate$1.2.invoke(java.lang.Integer):kotlin.Unit, file: classes31.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity$onFollow$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        java.lang.Number r7 = (java.lang.Number) r7
                        int r7 = r7.intValue()
                        java.lang.Object r0 = r6.receiver
                        com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity r0 = (com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity) r0
                        int r1 = com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity.$r8$clinit
                        r0.getClass()
                        com.tencent.hippykotlin.demo.pages.nearby.base.utils.PublicAccountUtils r1 = com.tencent.hippykotlin.demo.pages.nearby.base.utils.PublicAccountUtils.INSTANCE
                        boolean r2 = r1.isFollowed(r7)
                        com.tencent.kuikly.core.log.KLog r3 = com.tencent.kuikly.core.log.KLog.INSTANCE
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder
                        r4.<init>()
                        java.lang.String r5 = "onFollow appId="
                        r4.append(r5)
                        r4.append(r7)
                        java.lang.String r5 = ", \u5df2\u7ecf\u5173\u6ce8="
                        r4.append(r5)
                        r4.append(r2)
                        java.lang.String r2 = r4.toString()
                        java.lang.String r4 = "NPMPublicAccountFollowActivity"
                        r3.i(r4, r2)
                        com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity$onFollow$1 r2 = new com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity$onFollow$1
                        r2.<init>(r7, r0)
                        com.tencent.hippykotlin.demo.pages.nearby.base.utils.PublicAccountConfig r7 = r1.getConfig(r7)
                        if (r7 == 0) goto L67
                        java.lang.String r7 = r7.uin
                        if (r7 != 0) goto L48
                        goto L67
                    L48:
                        com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$Companion r0 = com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule.Companion
                        com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule r0 = r0.getInstance()
                        r0.getClass()
                        com.tencent.kuikly.core.nvi.serialization.json.e r1 = new com.tencent.kuikly.core.nvi.serialization.json.e
                        r1.<init>()
                        java.lang.String r3 = "uin"
                        r1.v(r3, r7)
                        com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$followPublicAccount$1 r7 = new com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$followPublicAccount$1
                        r7.<init>(r2)
                        java.lang.String r2 = "followPublicAccount"
                        r0.asyncToNativeMethod(r2, r1, r7)
                    L67:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity$onCreate$1.AnonymousClass2.invoke(java.lang.Object):java.lang.Object");
                }

                public AnonymousClass2(Object obj) {
                    super(1, obj, NBPPublicAccountFollowActivity.class, "onFollow", "onFollow(I)V", 0);
                }
            }

            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer, Integer num) {
                Composer composer2 = composer;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522186419, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity.onCreate.<anonymous> (NPMPublicAccountFollowActivity.kt:65)");
                    }
                    NBPPublicAccountFollowActivity nBPPublicAccountFollowActivity = NBPPublicAccountFollowActivity.this;
                    final int i3 = nBPPublicAccountFollowActivity.appId;
                    final AnonymousClass1 anonymousClass1 = new AnonymousClass1(NBPPublicAccountFollowActivity.this);
                    final AnonymousClass2 anonymousClass2 = new AnonymousClass2(NBPPublicAccountFollowActivity.this);
                    composer2.startReplaceableGroup(246239874);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(246239874, 0, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowModal (NPMPublicAccountFollowActivity.kt:113)");
                    }
                    final PublicAccountConfig config = PublicAccountUtils.INSTANCE.getConfig(i3);
                    INBPPublicAccountFollowModalHandle iNBPPublicAccountFollowModalHandle = null;
                    if (config == null) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                    } else {
                        final float e16 = ((com.tencent.ntcompose.ui.platform.a) composer2.consume(CompositionLocalsKt.d())).e() - 64.0f;
                        final float f16 = (170.0f * e16) / 310.0f;
                        float f17 = 190.0f + f16;
                        composer2.startReplaceableGroup(-492369756);
                        Object rememberedValue = composer2.rememberedValue();
                        Composer.Companion companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        final MutableState mutableState = (MutableState) rememberedValue;
                        Boolean valueOf = Boolean.valueOf(((Boolean) mutableState.getValue()).booleanValue());
                        composer2.startReplaceableGroup(1157296644);
                        boolean changed = composer2.changed(mutableState);
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changed || rememberedValue2 == companion.getEmpty()) {
                            rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NPMPublicAccountFollowActivityKt$NBPPublicAccountFollowModal$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Boolean bool) {
                                    mutableState.setValue(Boolean.valueOf(bool.booleanValue()));
                                    return Unit.INSTANCE;
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        Function1 function1 = (Function1) rememberedValue2;
                        composer2.startReplaceableGroup(1157296644);
                        boolean changed2 = composer2.changed(anonymousClass1);
                        Object rememberedValue3 = composer2.rememberedValue();
                        if (changed2 || rememberedValue3 == companion.getEmpty()) {
                            rememberedValue3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NPMPublicAccountFollowActivityKt$NBPPublicAccountFollowModal$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    anonymousClass1.invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        NBPHalfScreenModalKt.NBPHalfScreenModal(null, f17, valueOf, function1, (Function0) rememberedValue3, ComposableLambdaKt.composableLambda(composer2, -483431514, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NPMPublicAccountFollowActivityKt$NBPPublicAccountFollowModal$3
                            public final /* synthetic */ int $$changed = 0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer3, Integer num2) {
                                Composer composer4 = composer3;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-483431514, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowModal.<anonymous> (NPMPublicAccountFollowActivity.kt:134)");
                                    }
                                    ColumnKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NPMPublicAccountFollowActivityKt$NBPPublicAccountFollowModal$3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            KLog.INSTANCE.i("NBPPublicAccountFollowModal", "");
                                            return Unit.INSTANCE;
                                        }
                                    }, 3, null), null, Alignment.Horizontal.CenterHorizontally, null, ComposableLambdaKt.composableLambda(composer4, 278419549, true, new Function3<d, Composer, Integer, Unit>(e16, f16, anonymousClass2, i3, this.$$changed) { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NPMPublicAccountFollowActivityKt$NBPPublicAccountFollowModal$3.2
                                        public final /* synthetic */ int $appId;
                                        public final /* synthetic */ float $imageHeight;
                                        public final /* synthetic */ float $imageWidth;
                                        public final /* synthetic */ Function1<Integer, Unit> $onFollow;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer5, Integer num3) {
                                            Composer composer6 = composer5;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(278419549, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowModal.<anonymous>.<anonymous> (NPMPublicAccountFollowActivity.kt:140)");
                                                }
                                                i.Companion companion2 = i.INSTANCE;
                                                BoxKt.a(ModifiersKt.a(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion2, 36.0f, 5.0f), 0.0f, 4.5f, 0.0f, 0.0f, 13, null), QUIToken.color$default("icon_tertiary")), 3.0f), "\u4e0b\u62c9\u5173\u95ed"), null, null, null, composer6, 8, 14);
                                                TextKt.a(PublicAccountConfig.this.followModal.title, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion2), 0.0f, 27.5f, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, new bp3.c(500), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, an.d(an.INSTANCE.b()), null, 1, null, null, null, null, null, null, null, false, composer6, 28736, 102236208, 0, 133887908);
                                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, this.$imageWidth), this.$imageHeight), 0.0f, 24.0f, 0.0f, 0.0f, 13, null), null, 0, null, null, PublicAccountConfig.this.followModal.posterUrl, null, null, null, null, null, null, null, null, null, null, composer6, 262144, 0, 0, 2096095);
                                                Function1<Integer, Unit> function12 = this.$onFollow;
                                                Integer valueOf2 = Integer.valueOf(this.$appId);
                                                final Function1<Integer, Unit> function13 = this.$onFollow;
                                                final int i16 = this.$appId;
                                                composer6.startReplaceableGroup(511388516);
                                                boolean changed3 = composer6.changed(function12) | composer6.changed(valueOf2);
                                                Object rememberedValue4 = composer6.rememberedValue();
                                                if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NPMPublicAccountFollowActivityKt$NBPPublicAccountFollowModal$3$2$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            function13.invoke(Integer.valueOf(i16));
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(rememberedValue4);
                                                }
                                                composer6.endReplaceableGroup();
                                                ButtonKt.a(null, (Function1) rememberedValue4, ModifiersKt.d(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.n(companion2, 0.0f, 24.0f, 0.0f, 0.0f, 13, null), 168.0f), 45.0f), 4.0f), QUIToken.color$default("button_bg_primary_default")), null, ComposableSingletons$NPMPublicAccountFollowActivityKt.f91lambda1, composer6, 25088, 9);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer4, 24968, 10);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer2, 196608, 1);
                        iNBPPublicAccountFollowModalHandle = new INBPPublicAccountFollowModalHandle() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NPMPublicAccountFollowActivityKt$NBPPublicAccountFollowModal$4
                            @Override // com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.INBPPublicAccountFollowModalHandle
                            public final void close() {
                                mutableState.setValue(Boolean.FALSE);
                            }
                        };
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                    }
                    nBPPublicAccountFollowActivity.modal = iNBPPublicAccountFollowModalHandle;
                    NBPPublicAccountFollowActivity nBPPublicAccountFollowActivity2 = NBPPublicAccountFollowActivity.this;
                    if (nBPPublicAccountFollowActivity2.modal == null) {
                        NBPPublicAccountFollowActivity.access$onClosed(nBPPublicAccountFollowActivity2);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        INBPPublicAccountFollowModalHandle iNBPPublicAccountFollowModalHandle;
        super.onReceivePagerEvent(str, eVar);
        if (!Intrinsics.areEqual(str, "onModalModeBackPressed") || (iNBPPublicAccountFollowModalHandle = this.modal) == null) {
            return;
        }
        iNBPPublicAccountFollowModalHandle.close();
    }
}
