package com.tencent.qqnt.ntrelation.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.api.IMutualMarkDrawableApi;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.NTMutualMarkEntity;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012JH\u0010\n\u001a2\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\u0006j\b\u0012\u0004\u0012\u00020\t`\b0\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/ntrelation/api/impl/MutualMarkDrawableApiImpl;", "Lcom/tencent/qqnt/ntrelation/api/IMutualMarkDrawableApi;", "", "friendUid", "tag", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/NTMutualMarkEntity;", "getMutualMarkDrawableAndData", "Landroid/content/Context;", "context", "info", "Landroid/view/View;", "view", "getIconDrawableInRecentList", "<init>", "()V", "Companion", "a", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MutualMarkDrawableApiImpl implements IMutualMarkDrawableApi {
    private static final int ALPHA_MAX = 255;
    private static final int MARK_VERSION_NEW = 1;
    private static final int MARK_VERSION_OLD = 0;
    public static final String TAG = "QQRelationNameServiceImpl";

    @Override // com.tencent.qqnt.ntrelation.api.IMutualMarkDrawableApi
    public Pair<ArrayList<Drawable>, ArrayList<NTMutualMarkEntity>> getMutualMarkDrawableAndData(String friendUid, String tag) {
        Intrinsics.checkNotNullParameter(friendUid, "friendUid");
        Intrinsics.checkNotNullParameter(tag, "tag");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        FriendsManager friendsManager = (FriendsManager) (peekAppRuntime != null ? peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER) : null);
        if (friendsManager == null) {
            return new Pair<>(new ArrayList(), new ArrayList());
        }
        if (friendsManager.E(false) | ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getDisableInteractiveSwitchLocal()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MutualMarkDataCenter", 1, "getFriendMutualMarks disableReactive: true , mutualmark switch is close");
            }
            return new Pair<>(new ArrayList(), new ArrayList());
        }
        Context baseContext = MobileQQ.sMobileQQ.getBaseContext();
        if (baseContext == null) {
            return new Pair<>(new ArrayList(), new ArrayList());
        }
        a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(friendUid, tag);
        if (intimateSimpleInfoWithUid == null) {
            return new Pair<>(new ArrayList(), new ArrayList());
        }
        ArrayList<NTMutualMarkEntity> l3 = intimateSimpleInfoWithUid.l();
        if (l3 == null) {
            return new Pair<>(new ArrayList(), new ArrayList());
        }
        int size = l3.size();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            NTMutualMarkEntity nTMutualMarkEntity = l3.get(i3);
            Intrinsics.checkNotNullExpressionValue(nTMutualMarkEntity, "mutualMarkInfos[i]");
            arrayList.add(getIconDrawableInRecentList(baseContext, nTMutualMarkEntity, null));
        }
        return new Pair<>(arrayList, l3);
    }

    public static /* synthetic */ Drawable getIconDrawableInRecentList$default(MutualMarkDrawableApiImpl mutualMarkDrawableApiImpl, Context context, NTMutualMarkEntity nTMutualMarkEntity, View view, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            view = null;
        }
        return mutualMarkDrawableApiImpl.getIconDrawableInRecentList(context, nTMutualMarkEntity, view);
    }

    public final Drawable getIconDrawableInRecentList(Context context, NTMutualMarkEntity info, View view) {
        e eVar = null;
        if (context == null || info == null) {
            return null;
        }
        if (!TextUtils.isEmpty(info.iconUrl) && info.markVersion == MARK_VERSION_NEW) {
            String upgradeIconUrlToVersion2 = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).upgradeIconUrlToVersion2(info.iconUrl);
            Intrinsics.checkNotNullExpressionValue(upgradeIconUrlToVersion2, "api(IMutualMarkHelperApi\u2026lToVersion2(info.iconUrl)");
            info.iconUrl = upgradeIconUrlToVersion2;
            eVar = new e(context, info.iconUrl);
        } else if (!TextUtils.isEmpty(info.icon_dynamic_url) && info.markVersion == MARK_VERSION_OLD) {
            String upgradeIconUrlToVersion22 = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).upgradeIconUrlToVersion2(info.icon_dynamic_url);
            Intrinsics.checkNotNullExpressionValue(upgradeIconUrlToVersion22, "api(IMutualMarkHelperApi\u2026n2(info.icon_dynamic_url)");
            info.icon_dynamic_url = upgradeIconUrlToVersion22;
            eVar = new e(context, info.icon_dynamic_url);
        } else if (!TextUtils.isEmpty(info.icon_static_url) && info.markVersion == MARK_VERSION_OLD) {
            String upgradeIconUrlToVersion23 = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).upgradeIconUrlToVersion2(info.icon_static_url);
            Intrinsics.checkNotNullExpressionValue(upgradeIconUrlToVersion23, "api(IMutualMarkHelperApi\u2026on2(info.icon_static_url)");
            info.icon_static_url = upgradeIconUrlToVersion23;
            eVar = new e(context, info.icon_static_url);
        }
        if (eVar == null) {
            return eVar;
        }
        Drawable mutate = eVar.mutate();
        mutate.setBounds(0, 0, mutate.getIntrinsicWidth(), mutate.getIntrinsicHeight());
        return mutate;
    }
}
