package com.tencent.mobileqq.minigame.api.impl;

import android.app.Activity;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.metafarm.network.MetaFarmIsFarmUserRequest;
import com.tencent.mobileqq.minigame.metafarm.ui.MetaFarmProfileGuideFragment;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "isSuccess", "", "isFarmUser", "invoke", "(ZLjava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
final class MetaFarmProfileApiImpl$showGuideFragment$1 extends Lambda implements Function2<Boolean, Boolean, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ MetaFarmIsFarmUserRequest $request;
    final /* synthetic */ MetaFarmProfileApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetaFarmProfileApiImpl$showGuideFragment$1(MetaFarmProfileApiImpl metaFarmProfileApiImpl, MetaFarmIsFarmUserRequest metaFarmIsFarmUserRequest, Activity activity) {
        super(2);
        this.this$0 = metaFarmProfileApiImpl;
        this.$request = metaFarmIsFarmUserRequest;
        this.$activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        supportFragmentManager.beginTransaction().add(new MetaFarmProfileGuideFragment(), MetaFarmProfileGuideFragment.TAG).commitAllowingStateLoss();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
        invoke(bool.booleanValue(), bool2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, Boolean bool) {
        QLog.d("MetaFarmProfileApiImpl", 1, "MetaFarmIsFarmUserRequest req isSuccess:" + z16 + ", isFarmUser:" + bool);
        if (z16 && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            this.this$0.setGuideFragmentShown();
            ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).setBizPopGuideShow(true);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Activity activity = this.$activity;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.minigame.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    MetaFarmProfileApiImpl$showGuideFragment$1.invoke$lambda$0(activity);
                }
            });
        }
        this.$request.setListener(null);
        this.this$0.mIsReqStarted = false;
    }
}
