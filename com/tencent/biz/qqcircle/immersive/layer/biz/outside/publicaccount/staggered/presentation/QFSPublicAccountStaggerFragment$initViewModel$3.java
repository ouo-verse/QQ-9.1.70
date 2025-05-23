package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation;

import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class QFSPublicAccountStaggerFragment$initViewModel$3 extends FunctionReferenceImpl implements Function1<UIStateData<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public QFSPublicAccountStaggerFragment$initViewModel$3(Object obj) {
        super(1, obj, QFSPublicAccountStaggerFragment.class, "handleFollowUsersUIState", "handleFollowUsersUIState(Lcom/tencent/richframework/data/base/UIStateData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UIStateData<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp> uIStateData) {
        invoke2(uIStateData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable UIStateData<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp> uIStateData) {
        ((QFSPublicAccountStaggerFragment) this.receiver).Uh(uIStateData);
    }
}
