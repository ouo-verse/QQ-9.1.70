package com.tencent.mobileqq.zplan.utils;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ZPlanAvatarSource;
import com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory;
import com.tencent.mobileqq.zplan.view.AbsZPlanStaticFrameLayout;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J&\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/ag;", "", "Ljava/lang/Class;", "Lmqq/manager/Manager;", "d", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/view/AbsZPlanStaticFrameLayout;", "c", "Landroid/view/View;", "parentView", "Lcom/tencent/mobileqq/zplan/meme/frameanim/model/ZPlanAvatarSource;", "source", "", "enableFoldSplit", "", "friendUin", "Lcom/tencent/mobileqq/zplan/view/b;", "b", "Lcom/tencent/mobileqq/data/MessageRecord;", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ag f335760a = new ag();

    ag() {
    }

    @Nullable
    public final MessageRecord a() {
        try {
            return ((IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class)).createMessageForZPlan();
        } catch (Throwable th5) {
            QLog.e("ZPlanClassObjectUtil", 1, "createMessageForZPlan error, " + th5);
            return null;
        }
    }

    @NotNull
    public final com.tencent.mobileqq.zplan.view.b b(@NotNull View parentView, @NotNull ZPlanAvatarSource source, boolean enableFoldSplit, long friendUin) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(source, "source");
        return ((IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class)).createZPlanHeaderTouchDelegate(parentView, source, enableFoldSplit, friendUin);
    }

    @NotNull
    public final AbsZPlanStaticFrameLayout c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ((IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class)).createZPlanStaticFrameLayout(context);
    }

    @Nullable
    public final Class<? extends Manager> d() {
        try {
            return ((IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class)).getZPlanEditAvatarManagerClass();
        } catch (Throwable th5) {
            QLog.e("ZPlanClassObjectUtil", 1, "getZPlanEditAvatarManagerClass error, " + th5);
            return null;
        }
    }
}
