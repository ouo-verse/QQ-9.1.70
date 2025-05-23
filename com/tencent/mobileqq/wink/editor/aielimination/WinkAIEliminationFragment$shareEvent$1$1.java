package com.tencent.mobileqq.wink.editor.aielimination;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$shareEvent$1$1;
import com.tencent.mobileqq.wink.share.WinkShareCommonModel;
import com.tencent.mobileqq.wink.share.WinkShareManager;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$shareEvent$1$1", f = "WinkAIEliminationFragment.kt", i = {0}, l = {com.tencent.luggage.wxa.sm.e.P}, m = "invokeSuspend", n = {"shareImgPaths"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class WinkAIEliminationFragment$shareEvent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $it;
    final /* synthetic */ boolean $userDefaultShare;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WinkAIEliminationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "type", "", "isSuccess", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$shareEvent$1$1$2, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass2 extends Lambda implements Function2<String, Boolean, Unit> {
        final /* synthetic */ int $shareType;
        final /* synthetic */ WinkAIEliminationFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i3, WinkAIEliminationFragment winkAIEliminationFragment) {
            super(2);
            this.$shareType = i3;
            this.this$0 = winkAIEliminationFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(String type, int i3, boolean z16, WinkAIEliminationFragment this$0) {
            int i16;
            int i17;
            Intrinsics.checkNotNullParameter(type, "$type");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            switch (type.hashCode()) {
                case -1052216532:
                    if (type.equals("save_to_phone")) {
                        Context context = this$0.getContext();
                        if (z16) {
                            i16 = 5;
                        } else {
                            i16 = 1;
                        }
                        if (z16) {
                            i17 = R.string.f240737pz;
                        } else {
                            i17 = R.string.f240727py;
                        }
                        QQToast.makeText(context, i16, i17, 0).show();
                        return;
                    }
                    return;
                case -791575966:
                    if (!type.equals("weixin")) {
                        return;
                    }
                    break;
                case -393543490:
                    if (!type.equals("qqfriend")) {
                        return;
                    }
                    break;
                case -304161157:
                    if (!type.equals("qzoneshuoshuo")) {
                        return;
                    }
                    break;
                case 154627506:
                    if (!type.equals("weixincircle")) {
                        return;
                    }
                    break;
                case 2024098531:
                    if (!type.equals("qqchannel")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            w53.b.f("WinkAIEliminationFragment", "shareCallback shareType: " + i3 + ", isSuccess: " + z16);
            if (z16) {
                this$0.ci();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool) {
            invoke(str, bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull final String type, final boolean z16) {
            Intrinsics.checkNotNullParameter(type, "type");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final int i3 = this.$shareType;
            final WinkAIEliminationFragment winkAIEliminationFragment = this.this$0;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.aielimination.u
                @Override // java.lang.Runnable
                public final void run() {
                    WinkAIEliminationFragment$shareEvent$1$1.AnonymousClass2.b(type, i3, z16, winkAIEliminationFragment);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIEliminationFragment$shareEvent$1$1(boolean z16, WinkAIEliminationFragment winkAIEliminationFragment, FragmentActivity fragmentActivity, Continuation<? super WinkAIEliminationFragment$shareEvent$1$1> continuation) {
        super(2, continuation);
        this.$userDefaultShare = z16;
        this.this$0 = winkAIEliminationFragment;
        this.$it = fragmentActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAIEliminationFragment$shareEvent$1$1(this.$userDefaultShare, this.this$0, this.$it, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f3  */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.LinkedHashMap, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef objectRef;
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog;
        Ref.ObjectRef objectRef2;
        T t16;
        Ref.ObjectRef objectRef3;
        String str;
        boolean z16;
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog3 = null;
        int i16 = 1;
        if (i3 != 0) {
            if (i3 == 1) {
                objectRef2 = (Ref.ObjectRef) this.L$1;
                objectRef3 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                t16 = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            objectRef = new Ref.ObjectRef();
            objectRef.element = new LinkedHashMap();
            if (!this.$userDefaultShare) {
                qCircleCommonLoadingDialog = this.this$0.shareDialog;
                if (qCircleCommonLoadingDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareDialog");
                    qCircleCommonLoadingDialog = null;
                }
                qCircleCommonLoadingDialog.show();
                WinkAiEliminationViewModel hi5 = this.this$0.hi();
                this.L$0 = objectRef;
                this.L$1 = objectRef;
                this.label = 1;
                Object Z1 = hi5.Z1(this);
                if (Z1 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef2 = objectRef;
                t16 = Z1;
                objectRef3 = objectRef2;
            }
            if (this.$userDefaultShare && !(!((Map) objectRef.element).isEmpty())) {
                w53.b.c("WinkAIEliminationFragment", "fetchShareImg failed. shareImgPath=" + objectRef.element);
                QQToast.makeText(this.this$0.getContext(), 1, R.string.f240617pn, 0).show();
            } else {
                final WinkAIEliminationFragment winkAIEliminationFragment = this.this$0;
                final boolean z17 = this.$userDefaultShare;
                com.tencent.mobileqq.wink.api.c cVar = new com.tencent.mobileqq.wink.api.c() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$shareEvent$1$1$eliminateData$1
                    @Override // com.tencent.mobileqq.wink.api.c
                    @NotNull
                    public Function1<Boolean, Unit> a() {
                        final WinkAIEliminationFragment winkAIEliminationFragment2 = WinkAIEliminationFragment.this;
                        return new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$shareEvent$1$1$eliminateData$1$getShareCallback$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z18) {
                                if (z18) {
                                    WinkAIEliminationFragment.this.ci();
                                }
                            }
                        };
                    }

                    @Override // com.tencent.mobileqq.wink.api.c
                    /* renamed from: b, reason: from getter */
                    public boolean getF318775b() {
                        return z17;
                    }

                    @Override // com.tencent.mobileqq.wink.api.c
                    @NotNull
                    public Function1<Boolean, Unit> c() {
                        final WinkAIEliminationFragment winkAIEliminationFragment2 = WinkAIEliminationFragment.this;
                        return new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$shareEvent$1$1$eliminateData$1$getSaveCallback$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z18) {
                                QQToast.makeText(WinkAIEliminationFragment.this.getContext(), z18 ? 5 : 1, z18 ? R.string.f240737pz : R.string.f240727py, 0).show();
                            }
                        };
                    }

                    @Override // com.tencent.mobileqq.wink.api.c
                    @NotNull
                    public Bundle d() {
                        return WinkAIEliminationFragment.this.hi().t2(null, z17);
                    }

                    @Override // com.tencent.mobileqq.wink.api.c
                    @NotNull
                    public Map<String, Object> e() {
                        return WinkAIEliminationFragment.this.ii();
                    }

                    @Override // com.tencent.mobileqq.wink.api.c
                    @NotNull
                    public Map<String, Object> f() {
                        return WinkAIEliminationFragment.this.hi().c2();
                    }
                };
                if (this.$userDefaultShare) {
                    i16 = 2;
                }
                str = (String) ((Map) objectRef.element).get("SHARE_PREFIX__QQ");
                if (str == null) {
                    str = "";
                }
                WinkShareManager winkShareManager = WinkShareManager.f326323a;
                FragmentActivity it = this.$it;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                WinkShareCommonModel C2 = this.this$0.hi().C2(i16);
                z16 = this.$userDefaultShare;
                C2.setSharePathForOutChannel((String) ((Map) objectRef.element).get("SHARE_PREFIX__OUT_CHANNEL"));
                if (!z16) {
                    C2.setShareUrl(str);
                }
                Unit unit = Unit.INSTANCE;
                winkShareManager.l(it, cVar, C2, i16, new AnonymousClass2(i16, this.this$0));
            }
            return Unit.INSTANCE;
        }
        objectRef2.element = t16;
        qCircleCommonLoadingDialog2 = this.this$0.shareDialog;
        if (qCircleCommonLoadingDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareDialog");
        } else {
            qCircleCommonLoadingDialog3 = qCircleCommonLoadingDialog2;
        }
        qCircleCommonLoadingDialog3.dismiss();
        objectRef = objectRef3;
        if (this.$userDefaultShare) {
        }
        final WinkAIEliminationFragment winkAIEliminationFragment2 = this.this$0;
        final boolean z172 = this.$userDefaultShare;
        com.tencent.mobileqq.wink.api.c cVar2 = new com.tencent.mobileqq.wink.api.c() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$shareEvent$1$1$eliminateData$1
            @Override // com.tencent.mobileqq.wink.api.c
            @NotNull
            public Function1<Boolean, Unit> a() {
                final WinkAIEliminationFragment winkAIEliminationFragment22 = WinkAIEliminationFragment.this;
                return new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$shareEvent$1$1$eliminateData$1$getShareCallback$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z18) {
                        if (z18) {
                            WinkAIEliminationFragment.this.ci();
                        }
                    }
                };
            }

            @Override // com.tencent.mobileqq.wink.api.c
            /* renamed from: b, reason: from getter */
            public boolean getF318775b() {
                return z172;
            }

            @Override // com.tencent.mobileqq.wink.api.c
            @NotNull
            public Function1<Boolean, Unit> c() {
                final WinkAIEliminationFragment winkAIEliminationFragment22 = WinkAIEliminationFragment.this;
                return new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$shareEvent$1$1$eliminateData$1$getSaveCallback$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z18) {
                        QQToast.makeText(WinkAIEliminationFragment.this.getContext(), z18 ? 5 : 1, z18 ? R.string.f240737pz : R.string.f240727py, 0).show();
                    }
                };
            }

            @Override // com.tencent.mobileqq.wink.api.c
            @NotNull
            public Bundle d() {
                return WinkAIEliminationFragment.this.hi().t2(null, z172);
            }

            @Override // com.tencent.mobileqq.wink.api.c
            @NotNull
            public Map<String, Object> e() {
                return WinkAIEliminationFragment.this.ii();
            }

            @Override // com.tencent.mobileqq.wink.api.c
            @NotNull
            public Map<String, Object> f() {
                return WinkAIEliminationFragment.this.hi().c2();
            }
        };
        if (this.$userDefaultShare) {
        }
        str = (String) ((Map) objectRef.element).get("SHARE_PREFIX__QQ");
        if (str == null) {
        }
        WinkShareManager winkShareManager2 = WinkShareManager.f326323a;
        FragmentActivity it5 = this.$it;
        Intrinsics.checkNotNullExpressionValue(it5, "it");
        WinkShareCommonModel C22 = this.this$0.hi().C2(i16);
        z16 = this.$userDefaultShare;
        C22.setSharePathForOutChannel((String) ((Map) objectRef.element).get("SHARE_PREFIX__OUT_CHANNEL"));
        if (!z16) {
        }
        Unit unit2 = Unit.INSTANCE;
        winkShareManager2.l(it5, cVar2, C22, i16, new AnonymousClass2(i16, this.this$0));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAIEliminationFragment$shareEvent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
