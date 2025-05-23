package com.tencent.robot.scheme.api.impl.robotaio;

import android.content.Context;
import com.tencent.biz.richframework.ext.RFWStringsKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.HalfViewCardNode;
import com.tencent.qqnt.kernel.nativeinterface.OptID;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataRsp;
import com.tencent.qqnt.kernel.nativeinterface.StoryAction;
import com.tencent.qqnt.kernel.nativeinterface.StoryBaseInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.adelie.homepage.utils.StoryUtils;
import com.tencent.robot.api.IRobotIdentityApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/scheme/api/impl/robotaio/RobotOpenStoryAIOProcessor;", "Le54/a;", "Lcom/tencent/mobileqq/utils/ax;", "jumpAction", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotOpenStoryAIOProcessor implements e54.a {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v19, types: [T, java.lang.Object, java.lang.String] */
    @Override // e54.a
    public boolean a(@NotNull final ax jumpAction) {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(jumpAction, "jumpAction");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str2 = jumpAction.f307441f.get("uid");
        T t16 = str2;
        if (str2 == null) {
            t16 = "";
        }
        objectRef.element = t16;
        String str3 = jumpAction.f307441f.get("uin");
        if (str3 == null) {
            str3 = "";
        }
        String str4 = jumpAction.f307441f.get("fdata");
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        if (str3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (((CharSequence) objectRef.element).length() == 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                QLog.e("RobotOpenStoryAIOProcessor", 1, "uin is empty");
                return true;
            }
        }
        if (str3.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            ?? friendUidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUidFromUin(str3);
            Intrinsics.checkNotNullExpressionValue(friendUidFromUin, "api(IRelationNTUinAndUid\u2026tFriendUidFromUin(uinStr)");
            objectRef.element = friendUidFromUin;
        } else {
            if (((CharSequence) objectRef.element).length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                str3 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUinFromUid((String) objectRef.element);
                Intrinsics.checkNotNullExpressionValue(str3, "api(IRelationNTUinAndUid\u2026.getFriendUinFromUid(uid)");
            }
        }
        final long longOrDefault$default = RFWStringsKt.toLongOrDefault$default(str3, 0L, 0, 2, null);
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.ci7, 0).show();
            return true;
        }
        StoryUtils.f366640a.m((String) objectRef.element, OptID.KSTORY.ordinal(), str, false, new Function3<Boolean, String, QueryHalfViewDataRsp, Unit>() { // from class: com.tencent.robot.scheme.api.impl.robotaio.RobotOpenStoryAIOProcessor$process$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str5, QueryHalfViewDataRsp queryHalfViewDataRsp) {
                invoke(bool.booleanValue(), str5, queryHalfViewDataRsp);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z26, @NotNull String errMsg, @NotNull QueryHalfViewDataRsp rsp) {
                Object first;
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                QLog.i("RobotOpenStoryAIOProcessor", 1, "fetchRobotStoryHalfViewData success:" + z26 + ",errMsg:" + errMsg + ",rsp=" + rsp.cardNodes.size());
                final Context context = ax.this.f307437b;
                if (z26) {
                    Intrinsics.checkNotNullExpressionValue(rsp.cardNodes, "rsp.cardNodes");
                    if (!r9.isEmpty()) {
                        ArrayList<HalfViewCardNode> arrayList = rsp.cardNodes;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.cardNodes");
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                        final StoryBaseInfo storyBaseInfo = ((HalfViewCardNode) first).storyBaseInfo;
                        IRobotIdentityApi iRobotIdentityApi = (IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class);
                        final Ref.ObjectRef<String> objectRef2 = objectRef;
                        String str5 = objectRef2.element;
                        final long j3 = longOrDefault$default;
                        iRobotIdentityApi.checkAndAddFriend(str5, new Function0<Unit>() { // from class: com.tencent.robot.scheme.api.impl.robotaio.RobotOpenStoryAIOProcessor$process$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                QLog.i("RobotOpenStoryAIOProcessor", 1, "enterStory checkAndAddFriend success");
                                StoryBaseInfo storyBaseInfo2 = StoryBaseInfo.this;
                                String str6 = storyBaseInfo2 != null ? storyBaseInfo2.callbackData : null;
                                if (str6 == null) {
                                    str6 = "";
                                }
                                String str7 = str6;
                                StoryUtils storyUtils = StoryUtils.f366640a;
                                Context context2 = context;
                                Intrinsics.checkNotNullExpressionValue(context2, "context");
                                final long j16 = j3;
                                StoryAction storyAction = StoryAction.ENTERSTORY;
                                final StoryBaseInfo storyBaseInfo3 = StoryBaseInfo.this;
                                final Context context3 = context;
                                final Ref.ObjectRef<String> objectRef3 = objectRef2;
                                storyUtils.F(context2, j16, str7, storyAction, true, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.robot.scheme.api.impl.robotaio.RobotOpenStoryAIOProcessor.process.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                                        invoke(bool.booleanValue(), num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(boolean z27, int i3) {
                                        QLog.i("RobotOpenStoryAIOProcessor", 1, "enterStory success: " + z27);
                                        if (z27) {
                                            StoryUtils storyUtils2 = StoryUtils.f366640a;
                                            StoryBaseInfo storyBaseInfo4 = StoryBaseInfo.this;
                                            Context context4 = context3;
                                            Intrinsics.checkNotNullExpressionValue(context4, "context");
                                            StoryUtils.x(storyUtils2, storyBaseInfo4, context4, j16, objectRef3.element, null, false, false, 112, null);
                                            return;
                                        }
                                        QQToast.makeText(context3, 1, i3, 1).show();
                                    }
                                });
                            }
                        });
                        return;
                    }
                }
                QQToast.makeText(context, 1, R.string.f223536gh, 1).show();
            }
        });
        return true;
    }
}
