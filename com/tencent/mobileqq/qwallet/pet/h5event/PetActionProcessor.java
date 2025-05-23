package com.tencent.mobileqq.qwallet.pet.h5event;

import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qwallet.pet.data.PetStateManager;
import com.tencent.mobileqq.qwallet.pet.h5event.PetActionProcessor;
import com.tencent.mobileqq.qwallet.pet.h5event.QWalletPetH5Controller;
import com.tencent.qphone.base.util.QLog;
import gl2.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0003\u0010\u0015\u0019B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/h5event/PetActionProcessor;", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller$b;", "Lcom/tencent/mobileqq/qwallet/pet/h5event/PetH5Method;", "h5Method", "", "g", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "j", "i", "h5Action", "f", "", "methodName", "", "a", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;", "h5Controller", "Lcom/tencent/mobileqq/qwallet/pet/h5event/PetActionProcessor$a;", "b", "Lcom/tencent/mobileqq/qwallet/pet/h5event/PetActionProcessor$a;", "playActionCallback", "Lcom/tencent/mobileqq/qwallet/pet/h5event/PetActionProcessor$c;", "c", "Lcom/tencent/mobileqq/qwallet/pet/h5event/PetActionProcessor$c;", "goFriendHomeData", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;)V", "d", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PetActionProcessor implements QWalletPetH5Controller.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletPetH5Controller h5Controller;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ActionCallback playActionCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GoFriendHomeData goFriendHomeData;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/h5event/PetActionProcessor$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lgl2/c;", "a", "Lgl2/c;", "b", "()Lgl2/c;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "Ljava/lang/String;", "()Ljava/lang/String;", "callback", "", "c", "J", "getTimeout", "()J", "timeout", "<init>", "(Lgl2/c;Ljava/lang/String;J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.h5event.PetActionProcessor$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class GoFriendHomeData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final c strategy;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String callback;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long timeout;

        public GoFriendHomeData(@NotNull c strategy, @Nullable String str, long j3) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.strategy = strategy;
            this.callback = str;
            this.timeout = j3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getCallback() {
            return this.callback;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final c getStrategy() {
            return this.strategy;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GoFriendHomeData)) {
                return false;
            }
            GoFriendHomeData goFriendHomeData = (GoFriendHomeData) other;
            if (Intrinsics.areEqual(this.strategy, goFriendHomeData.strategy) && Intrinsics.areEqual(this.callback, goFriendHomeData.callback) && this.timeout == goFriendHomeData.timeout) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.strategy.hashCode() * 31;
            String str = this.callback;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return ((hashCode2 + hashCode) * 31) + androidx.fragment.app.a.a(this.timeout);
        }

        @NotNull
        public String toString() {
            return "GoFriendHomeData(strategy=" + this.strategy + ", callback=" + this.callback + ", timeout=" + this.timeout + ")";
        }
    }

    public PetActionProcessor(@NotNull QWalletPetH5Controller h5Controller) {
        Intrinsics.checkNotNullParameter(h5Controller, "h5Controller");
        this.h5Controller = h5Controller;
    }

    private final void f(PetH5Method h5Action) {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QWallet.Pet.PetActionProcessor", null, null, null, new PetActionProcessor$applyDecoration$1(h5Action, null), 14, null);
        }
    }

    private final void g(PetH5Method h5Method) {
        Object firstOrNull;
        String str = null;
        this.goFriendHomeData = null;
        JSONObject optJSONObject = h5Method.getRawJSON().optJSONObject("data");
        if (optJSONObject == null) {
            return;
        }
        final String petType = optJSONObject.optString("petType");
        JSONArray optJSONArray = optJSONObject.optJSONArray("clothes");
        jl2.b bVar = jl2.b.f410584a;
        List<String> h16 = bVar.h(optJSONArray);
        if (h16 == null) {
            h16 = CollectionsKt__CollectionsKt.emptyList();
        }
        final List<String> list = h16;
        List<String> h17 = bVar.h(optJSONObject.optJSONArray("scenes"));
        if (h17 != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) h17);
            str = (String) firstOrNull;
        }
        final String str2 = str;
        long optLong = h5Method.getRawJSON().optLong("timeout", -1L);
        final GoFriendHomeData goFriendHomeData = new GoFriendHomeData(new c(), h5Method.getCallback(), optLong);
        c strategy = goFriendHomeData.getStrategy();
        Intrinsics.checkNotNullExpressionValue(petType, "petType");
        strategy.i(petType, list, str2);
        goFriendHomeData.getStrategy().h(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.h5event.PetActionProcessor$goFriendHome$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                PetActionProcessor.GoFriendHomeData goFriendHomeData2;
                PetActionProcessor.GoFriendHomeData goFriendHomeData3;
                QWalletPetH5Controller qWalletPetH5Controller;
                QWalletPetH5Controller qWalletPetH5Controller2;
                goFriendHomeData2 = PetActionProcessor.this.goFriendHomeData;
                if (goFriendHomeData2 != null) {
                    goFriendHomeData3 = PetActionProcessor.this.goFriendHomeData;
                    if (Intrinsics.areEqual(goFriendHomeData3 != null ? goFriendHomeData3.getStrategy() : null, goFriendHomeData.getStrategy())) {
                        if (!z16) {
                            qWalletPetH5Controller = PetActionProcessor.this.h5Controller;
                            qWalletPetH5Controller.b(goFriendHomeData.getCallback(), -1, "\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                        } else {
                            PetStateManager petStateManager = PetStateManager.f278740a;
                            String petType2 = petType;
                            Intrinsics.checkNotNullExpressionValue(petType2, "petType");
                            petStateManager.p(petType2, list, str2);
                            qWalletPetH5Controller2 = PetActionProcessor.this.h5Controller;
                            QWalletPetH5Controller.d(qWalletPetH5Controller2, goFriendHomeData.getCallback(), 0, null, 6, null);
                        }
                        PetActionProcessor.this.goFriendHomeData = null;
                    }
                }
            }
        });
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.pet.h5event.a
            @Override // java.lang.Runnable
            public final void run() {
                PetActionProcessor.h(PetActionProcessor.this);
            }
        }, optLong);
        this.goFriendHomeData = goFriendHomeData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(PetActionProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GoFriendHomeData goFriendHomeData = this$0.goFriendHomeData;
        if (goFriendHomeData != null) {
            this$0.h5Controller.b(goFriendHomeData.getCallback(), -1, "\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        }
        this$0.goFriendHomeData = null;
    }

    private final void i(PetH5Method h5Method) {
        String str;
        String str2;
        String optString = h5Method.getRawJSON().optString("actionType");
        if (optString == null) {
            QLog.w("QWallet.Pet.PetActionProcessor", 1, "onPlayActionFinish error, actionType is null");
            return;
        }
        ActionCallback actionCallback = this.playActionCallback;
        if (actionCallback != null) {
            str = actionCallback.getActionType();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(optString, str)) {
            ActionCallback actionCallback2 = this.playActionCallback;
            if (actionCallback2 != null) {
                str2 = actionCallback2.getCallback();
            } else {
                str2 = null;
            }
            this.playActionCallback = null;
            QWalletPetH5Controller.d(this.h5Controller, str2, 0, null, 6, null);
        }
    }

    private final void j(PetH5Method h5Method) {
        String str;
        ActionCallback actionCallback;
        String optString = h5Method.getRawJSON().optString("actionType");
        if (optString == null) {
            QLog.w("QWallet.Pet.PetActionProcessor", 1, "onPlayActionFinish error, actionType is null");
            return;
        }
        ActionCallback actionCallback2 = this.playActionCallback;
        if (actionCallback2 != null) {
            str = actionCallback2.getActionType();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(optString, str) && (actionCallback = this.playActionCallback) != null) {
            actionCallback.e(true);
        }
    }

    private final void k(PetH5Method h5Method) {
        String optString = h5Method.getRawJSON().optString("actionType");
        if (optString == null) {
            QLog.w("QWallet.Pet.PetActionProcessor", 1, "playAction error, actionType is null");
            return;
        }
        long optLong = h5Method.getRawJSON().optLong("timeout", -1L);
        ActionCallback actionCallback = new ActionCallback(optString, h5Method.getCallback(), optLong, false, false, 24, null);
        ActionCallback actionCallback2 = this.playActionCallback;
        if (actionCallback2 != null && (actionCallback2.getIsPlaying() || !actionCallback2.getIsTimeout())) {
            QWalletPetH5Controller.d(this.h5Controller, actionCallback2.getCallback(), 0, null, 6, null);
        }
        this.playActionCallback = actionCallback;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QWallet.Pet.PetActionProcessor", null, null, null, new PetActionProcessor$playAction$2(optString, optLong, actionCallback, this, null), 14, null);
        }
    }

    private final void l(PetH5Method h5Method) {
        PetStateManager.f278740a.A();
        QWalletPetH5Controller.d(this.h5Controller, h5Method.getCallback(), 0, null, 6, null);
    }

    private final void m(PetH5Method h5Method) {
        String optString = h5Method.getRawJSON().optString("petType");
        if (optString == null) {
            QLog.w("QWallet.Pet.PetActionProcessor", 1, "selectPet error, petType is null");
        } else {
            PetStateManager.m(PetStateManager.f278740a, optString, null, 2, null);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.pet.h5event.QWalletPetH5Controller.b
    public boolean a(@NotNull String methodName, @NotNull PetH5Method h5Method) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(h5Method, "h5Method");
        switch (methodName.hashCode()) {
            case -1249207638:
                if (methodName.equals("PlayAction")) {
                    k(h5Method);
                    return true;
                }
                return false;
            case -455769986:
                if (methodName.equals("DecorationApply")) {
                    f(h5Method);
                    return true;
                }
                return false;
            case 67169245:
                if (methodName.equals("PlayActionFinish")) {
                    i(h5Method);
                    return true;
                }
                return false;
            case 287978083:
                if (methodName.equals("SelectPet")) {
                    m(h5Method);
                    return true;
                }
                return false;
            case 538754541:
                if (methodName.equals("QuitFriend")) {
                    l(h5Method);
                    return true;
                }
                return false;
            case 568677336:
                if (methodName.equals("PlayActionStart")) {
                    j(h5Method);
                    return true;
                }
                return false;
            case 1026693574:
                if (methodName.equals("GoFriend")) {
                    g(h5Method);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u001b\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/h5event/PetActionProcessor$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "actionType", "b", "callback", "", "c", "J", "getTimeout", "()J", "timeout", "d", "Z", "()Z", "e", "(Z)V", "isPlaying", "f", "isTimeout", "<init>", "(Ljava/lang/String;Ljava/lang/String;JZZ)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.h5event.PetActionProcessor$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class ActionCallback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String actionType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String callback;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long timeout;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isPlaying;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isTimeout;

        public ActionCallback(@NotNull String actionType, @Nullable String str, long j3, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            this.actionType = actionType;
            this.callback = str;
            this.timeout = j3;
            this.isPlaying = z16;
            this.isTimeout = z17;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getActionType() {
            return this.actionType;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getCallback() {
            return this.callback;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsPlaying() {
            return this.isPlaying;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsTimeout() {
            return this.isTimeout;
        }

        public final void e(boolean z16) {
            this.isPlaying = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionCallback)) {
                return false;
            }
            ActionCallback actionCallback = (ActionCallback) other;
            if (Intrinsics.areEqual(this.actionType, actionCallback.actionType) && Intrinsics.areEqual(this.callback, actionCallback.callback) && this.timeout == actionCallback.timeout && this.isPlaying == actionCallback.isPlaying && this.isTimeout == actionCallback.isTimeout) {
                return true;
            }
            return false;
        }

        public final void f(boolean z16) {
            this.isTimeout = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = this.actionType.hashCode() * 31;
            String str = this.callback;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int a16 = (((hashCode2 + hashCode) * 31) + androidx.fragment.app.a.a(this.timeout)) * 31;
            boolean z16 = this.isPlaying;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (a16 + i16) * 31;
            boolean z17 = this.isTimeout;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "ActionCallback(actionType=" + this.actionType + ", callback=" + this.callback + ", timeout=" + this.timeout + ", isPlaying=" + this.isPlaying + ", isTimeout=" + this.isTimeout + ")";
        }

        public /* synthetic */ ActionCallback(String str, String str2, long j3, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, j3, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? false : z17);
        }
    }
}
