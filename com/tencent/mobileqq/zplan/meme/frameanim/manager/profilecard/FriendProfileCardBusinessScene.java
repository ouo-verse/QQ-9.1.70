package com.tencent.mobileqq.zplan.meme.frameanim.manager.profilecard;

import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.mobileqq.zplan.meme.frameanim.manager.dynamic.DynamicBusinessScene;
import com.tencent.mobileqq.zplan.resource.api.impl.ZPlanAvatarInfoHelperImpl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/manager/profilecard/FriendProfileCardBusinessScene;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/manager/dynamic/DynamicBusinessScene;", "uin", "", "(Ljava/lang/String;)V", "getUin", "()Ljava/lang/String;", "fetchAvatarInfo", "Lorg/json/JSONObject;", "from", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;", "(Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class FriendProfileCardBusinessScene extends DynamicBusinessScene {
    private final String uin;

    public FriendProfileCardBusinessScene() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.dynamic.DynamicBusinessScene, com.tencent.filament.zplan.business.impl.AbsBusinessScene
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchAvatarInfo(AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom, Continuation<? super JSONObject> continuation) {
        FriendProfileCardBusinessScene$fetchAvatarInfo$1 friendProfileCardBusinessScene$fetchAvatarInfo$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        if (continuation instanceof FriendProfileCardBusinessScene$fetchAvatarInfo$1) {
            friendProfileCardBusinessScene$fetchAvatarInfo$1 = (FriendProfileCardBusinessScene$fetchAvatarInfo$1) continuation;
            int i16 = friendProfileCardBusinessScene$fetchAvatarInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                friendProfileCardBusinessScene$fetchAvatarInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = friendProfileCardBusinessScene$fetchAvatarInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = friendProfileCardBusinessScene$fetchAvatarInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str = this.uin;
                    if (str != null) {
                        ZPlanAvatarInfoHelperImpl.Companion companion = ZPlanAvatarInfoHelperImpl.INSTANCE;
                        friendProfileCardBusinessScene$fetchAvatarInfo$1.label = 1;
                        obj = companion.fetchOtherAvatarInfoWithUin(str, friendProfileCardBusinessScene$fetchAvatarInfo$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    QLog.e(DynamicBusinessScene.TAG, 1, "fetchAvatarInfo fail.");
                    return new JSONObject();
                }
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    QLog.e(DynamicBusinessScene.TAG, 1, "fetchAvatarInfo success.");
                    return jSONObject;
                }
                QLog.e(DynamicBusinessScene.TAG, 1, "fetchAvatarInfo fail.");
                return new JSONObject();
            }
        }
        friendProfileCardBusinessScene$fetchAvatarInfo$1 = new FriendProfileCardBusinessScene$fetchAvatarInfo$1(this, continuation);
        Object obj2 = friendProfileCardBusinessScene$fetchAvatarInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = friendProfileCardBusinessScene$fetchAvatarInfo$1.label;
        if (i3 != 0) {
        }
        jSONObject = (JSONObject) obj2;
        if (jSONObject != null) {
        }
        QLog.e(DynamicBusinessScene.TAG, 1, "fetchAvatarInfo fail.");
        return new JSONObject();
    }

    public final String getUin() {
        return this.uin;
    }

    public FriendProfileCardBusinessScene(String str) {
        this.uin = str;
    }

    public /* synthetic */ FriendProfileCardBusinessScene(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }
}
