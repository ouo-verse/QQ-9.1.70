package com.tencent.mobileqq.qwallet.hb.skin.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinRepository;
import com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi;
import com.tencent.mobileqq.qwallet.hb.skin.share.HbSkinShareEntryFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J$\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016JG\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022#\u0010\b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\rH\u0016J*\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J8\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\t0\rH\u0016J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0002H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/api/impl/HbSkinApiImpl;", "Lcom/tencent/mobileqq/qwallet/hb/skin/api/IHbSkinApi;", "", "skinId", "", "outerSkinId", "skinFrom", "Landroid/os/ResultReceiver;", "receiver", "", "ipcGetSkinType", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "getSkinDataFromLocal", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "hbSkinData", "getSkinData", "ipcGetSkinPopUrl", "result", "updateSkinData", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "inSkinId", "shareSkinArkToMsg", "<init>", "()V", "Companion", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinApiImpl implements IHbSkinApi {

    @NotNull
    private static final String TAG = "HbSkinApi";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSkinData$lambda$0(int i3, String str, int i16, final Function1 result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        HbSkinRepository.f277840a.i(i3, str, i16, new Function1<HbSkinData, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.skin.api.impl.HbSkinApiImpl$updateSkinData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinData hbSkinData) {
                invoke2(hbSkinData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable HbSkinData hbSkinData) {
                result.invoke(hbSkinData);
                QLog.i("HbSkinApi", 2, "updateSkinData data = " + hbSkinData);
            }
        });
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi
    public void getSkinData(int skinId, @Nullable String outerSkinId, int skinFrom, @NotNull Function1<? super HbSkinData, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        HbSkinRepository.f277840a.d(skinId, outerSkinId, skinFrom, receiver);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi
    @Nullable
    public HbSkinData getSkinDataFromLocal(int skinId, @Nullable String outerSkinId, int skinFrom) {
        return HbSkinRepository.f277840a.e(skinId, outerSkinId, skinFrom);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi
    public void ipcGetSkinPopUrl(int skinId, @Nullable String outerSkinId, int skinFrom, @NotNull final ResultReceiver receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        HbSkinRepository.f277840a.d(skinId, outerSkinId, skinFrom, new Function1<HbSkinData, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.skin.api.impl.HbSkinApiImpl$ipcGetSkinPopUrl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinData hbSkinData) {
                invoke2(hbSkinData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable HbSkinData hbSkinData) {
                String str;
                String str2;
                String activityUrl;
                ResultReceiver resultReceiver = receiver;
                Bundle bundle = new Bundle();
                String str3 = "";
                if (hbSkinData == null || (str = hbSkinData.getPopResUrl()) == null) {
                    str = "";
                }
                bundle.putString("skin_pop_res_url", str);
                if (hbSkinData == null || (str2 = hbSkinData.getActivityEntryName()) == null) {
                    str2 = "";
                }
                bundle.putString("skin_activity_name", str2);
                if (hbSkinData != null && (activityUrl = hbSkinData.getActivityUrl()) != null) {
                    str3 = activityUrl;
                }
                bundle.putString("skin_activity_url", str3);
                Unit unit = Unit.INSTANCE;
                resultReceiver.send(0, bundle);
            }
        });
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi
    public void ipcGetSkinType(int skinId, @Nullable String outerSkinId, int skinFrom, @NotNull final ResultReceiver receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        HbSkinRepository.f277840a.g(skinId, outerSkinId, skinFrom, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.skin.api.impl.HbSkinApiImpl$ipcGetSkinType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                ResultReceiver resultReceiver = receiver;
                Bundle bundle = new Bundle();
                bundle.putInt("skin_type", i3);
                Unit unit = Unit.INSTANCE;
                resultReceiver.send(0, bundle);
            }
        });
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi
    public boolean isDefaultRedPocketSkin(int i3, @Nullable String str, int i16) {
        return IHbSkinApi.a.a(this, i3, str, i16);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi
    public boolean isLocalRedPocketSkin(int i3) {
        return IHbSkinApi.a.b(this, i3);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi
    public boolean isQCircleRedPocketSkin(@Nullable String str, int i3) {
        return IHbSkinApi.a.c(this, str, i3);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi
    public boolean isSupportSkinStory(int i3) {
        return IHbSkinApi.a.d(this, i3);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi
    public boolean isValidRedPocketSkin(int i3, @Nullable String str, int i16) {
        return IHbSkinApi.a.e(this, i3, str, i16);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi
    public void shareSkinArkToMsg(@Nullable Activity activity, int inSkinId) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("KEY_IN_PARAM_SKIN_ID", inSkinId);
        QPublicFragmentActivity.b.b(activity, intent, QPublicTransFragmentActivity.class, HbSkinShareEntryFragment.class);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi
    public void updateSkinData(final int skinId, @Nullable final String outerSkinId, final int skinFrom, @NotNull final Function1<? super HbSkinData, Unit> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.skin.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                HbSkinApiImpl.updateSkinData$lambda$0(skinId, outerSkinId, skinFrom, result);
            }
        }, 128, null, false);
    }
}
