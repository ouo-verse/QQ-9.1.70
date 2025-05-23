package com.tencent.mobileqq.gamecenter.qa.util;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/util/f;", "", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/util/f$a;", "", "", "a", "", "b", "", "c", "ASK_BUTTON_TEST_A", "Ljava/lang/String;", "ASK_BUTTON_TEST_A_ID", "ASK_BUTTON_TEST_B", "ASK_BUTTON_TEST_B_ID", "ASK_BUTTON_TEST_C", "ASK_BUTTON_TEST_C_ID", "ASK_BUTTON_TEST_TYPE_A", "I", "ASK_BUTTON_TEST_TYPE_B", "ASK_BUTTON_TEST_TYPE_C", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.util.f$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int a() {
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_gamecenter_qa_pindao_askbutton_1505_20220511");
            Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026tants.ASK_BUTTON_TEST_ID)");
            if (expEntity.isExperiment("exp_gamecenter_qa_pindao_askbutton_1505_20220511_B")) {
                return 1;
            }
            if (expEntity.isExperiment("exp_gamecenter_qa_pindao_askbutton_1505_20220511_C")) {
                return 2;
            }
            return 0;
        }

        @JvmStatic
        @NotNull
        public final String b() {
            int a16 = a();
            if (a16 != 1) {
                if (a16 != 2) {
                    return "7984000";
                }
                return "7984002";
            }
            return "7984001";
        }

        @JvmStatic
        public final void c() {
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_gamecenter_qa_pindao_askbutton_1505_20220511");
            Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026tants.ASK_BUTTON_TEST_ID)");
            expEntity.reportExpExposure();
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final int a() {
        return INSTANCE.a();
    }

    @JvmStatic
    @NotNull
    public static final String b() {
        return INSTANCE.b();
    }

    @JvmStatic
    public static final void c() {
        INSTANCE.c();
    }
}
