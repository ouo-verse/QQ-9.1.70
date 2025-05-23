package com.tencent.mobileqq.gamecenter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi;
import com.tencent.mobileqq.gamecenter.protocols.GameAuthPubAccHandler;
import com.tencent.mobileqq.gamecenter.ui.GameCenterAuthFragment;
import com.tencent.mobileqq.gamecenter.ui.GameCenterAuthPubAccGuideFragment;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameCenterAuthApiImpl implements IGameCenterAuthApi, GameAuthPubAccHandler.a {
    public static final String TAG = "GameCenterAuthApiImpl";

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Activity f211847a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f211848b;

        /* renamed from: c, reason: collision with root package name */
        public Class<? extends QPublicFragmentActivity> f211849c;

        /* renamed from: d, reason: collision with root package name */
        public int f211850d;
    }

    private void openPage(Class<? extends QPublicBaseFragment> cls, a aVar) {
        Intent intent;
        if (aVar != null && cls != null && (intent = aVar.f211848b) != null) {
            intent.putExtra("intent_key_request_code", aVar.f211850d);
            QPublicFragmentActivity.b.e(aVar.f211847a, aVar.f211848b, aVar.f211849c, cls, aVar.f211850d);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi
    public com.tencent.mobileqq.gamecenter.api.b getGameAuthHelper(Context context, String str, com.tencent.mobileqq.gamecenter.data.k kVar) {
        return getGameAuthHelper(context, str, kVar, 3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi
    public String getRangeString(Context context, int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "";
                }
                return context.getResources().getString(R.string.f1365904k);
            }
            return context.getResources().getString(R.string.f1366604r);
        }
        return context.getResources().getString(R.string.f1366504q);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi
    public String getYuanMengRangeString(Context context, int i3) {
        if (i3 != 4) {
            return getRangeString(context, i3);
        }
        return context.getResources().getString(R.string.f1365904k);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi
    public void jump2AuthFragmentWhenLogin(Activity activity, Intent intent, Class<? extends QPublicFragmentActivity> cls, int i3) {
        a aVar = new a();
        aVar.f211849c = cls;
        aVar.f211848b = intent;
        aVar.f211850d = i3;
        aVar.f211847a = activity;
        openPage(GameCenterAuthFragment.class, aVar);
    }

    @Override // com.tencent.mobileqq.gamecenter.protocols.GameAuthPubAccHandler.a
    public void onGetPubAccInfo(boolean z16, com.tencent.mobileqq.gamecenter.data.o oVar, a aVar, GameAuthPubAccHandler gameAuthPubAccHandler) {
        if (gameAuthPubAccHandler != null) {
            gameAuthPubAccHandler.e();
        }
        if (aVar == null) {
            QLog.e(TAG, 1, "[onGetPubAccInfo], authParams is null.");
        } else {
            if (z16) {
                aVar.f211848b.putExtra("intent_key_pub_acc_wording", oVar.f212065b);
                aVar.f211848b.putExtra("intent_key_pub_acc_type", oVar.f212064a);
                openPage(GameCenterAuthPubAccGuideFragment.class, aVar);
                return;
            }
            openPage(GameCenterAuthFragment.class, aVar);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi
    public com.tencent.mobileqq.gamecenter.api.b getGameAuthHelper(Context context, String str, com.tencent.mobileqq.gamecenter.data.k kVar, int i3) {
        return new com.tencent.mobileqq.gamecenter.logic.a(context, str, kVar, i3);
    }
}
