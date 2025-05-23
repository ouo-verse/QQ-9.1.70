package com.tencent.mobileqq.zplan.emoticon.recommend;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/recommend/RecommendTABHelper;", "", "", "a", "Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;", "b", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;", "expEntity", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RecommendTABHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final RecommendTABHelper f333312a = new RecommendTABHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy expEntity;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ExpEntityInfo>() { // from class: com.tencent.mobileqq.zplan.emoticon.recommend.RecommendTABHelper$expEntity$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExpEntityInfo invoke() {
                if (a.f333316a.e()) {
                    ExpEntityInfo expEntity2 = ABTestController.getInstance().getExpEntity("exp_zplan_emote_keyword_record");
                    expEntity2.reportExpExposure();
                    if (!QLog.isColorLevel()) {
                        return expEntity2;
                    }
                    QLog.i("RecommendTABHelper", 2, "exp_zplan_emote_keyword_record -> " + expEntity2.getAssignment());
                    return expEntity2;
                }
                QLog.i("RecommendTABHelper", 1, "enableRecommendRecord switch off");
                return null;
            }
        });
        expEntity = lazy;
    }

    RecommendTABHelper() {
    }

    private final ExpEntityInfo b() {
        return (ExpEntityInfo) expEntity.getValue();
    }

    public final boolean a() {
        ExpEntityInfo b16 = b();
        return b16 != null && b16.isExperiment("exp_zplan_emote_keyword_record_B");
    }
}
