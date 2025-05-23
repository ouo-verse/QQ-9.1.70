package com.tencent.mobileqq.zplan.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarSceneConfigManager;
import com.tencent.mobileqq.zplan.aio.couple.a;
import com.tencent.mobileqq.zplan.api.IZPlanNTPushApi;
import com.tencent.mobileqq.zplan.push.ZPlanNTPushHandler;
import com.tencent.qphone.base.BaseConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00032\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0002j\b\u0012\u0004\u0012\u00020\t`\u0004H\u0016R\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanNTPushApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanNTPushApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onGetPushIdList", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", BaseConstants.EXTRA_PUSHID, "", "msgBuf", "", "onHandlePushMsg", "SCENE_LINKAGE_PUSH_ID", "J", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanNTPushApiImpl implements IZPlanNTPushApi {
    public static final String TAG = "ZPlanNTPushApiImpl";
    private final long SCENE_LINKAGE_PUSH_ID = 357;

    @Override // com.tencent.mobileqq.zplan.api.IZPlanNTPushApi
    public ArrayList<Long> onGetPushIdList() {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(this.SCENE_LINKAGE_PUSH_ID));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanNTPushApi
    public void onHandlePushMsg(BaseQQAppInterface app, long pushId, ArrayList<Byte> msgBuf) {
        byte[] byteArray;
        byte[] byteArray2;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgBuf, "msgBuf");
        if (pushId == this.SCENE_LINKAGE_PUSH_ID) {
            com.tencent.mobileqq.zplan.aio.couple.a aVar = com.tencent.mobileqq.zplan.aio.couple.a.f330997a;
            byteArray2 = CollectionsKt___CollectionsKt.toByteArray(msgBuf);
            a.MsgContent b16 = aVar.b(byteArray2);
            if (b16.getSceneId() != 0) {
                CoupleAvatarSceneConfigManager.f330980a.i(String.valueOf(b16.getFromUin()), b16.getSceneId());
            }
        }
        ZPlanNTPushHandler zPlanNTPushHandler = ZPlanNTPushHandler.f335027a;
        byteArray = CollectionsKt___CollectionsKt.toByteArray(msgBuf);
        zPlanNTPushHandler.a(pushId, byteArray);
    }
}
