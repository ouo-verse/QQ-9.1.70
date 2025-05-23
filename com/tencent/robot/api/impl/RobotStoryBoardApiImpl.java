package com.tencent.robot.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.StoryAction;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.robot.adelie.homepage.utils.StoryUtils;
import com.tencent.robot.api.IRobotPersonalInfoService;
import com.tencent.robot.api.IRobotStoryBoardApi;
import com.tencent.robot.story.RobotStoryBoardDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/api/impl/RobotStoryBoardApiImpl;", "Lcom/tencent/robot/api/IRobotStoryBoardApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "from", "", "showRobotStoryBoard", "handleDelFriend", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotStoryBoardApiImpl implements IRobotStoryBoardApi {
    @Override // com.tencent.robot.api.IRobotStoryBoardApi
    public void handleDelFriend(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        final Context context = aioContext.c().getContext();
        if (context == null || !AdelieUtils.f365929a.T(aioContext) || aioContext.g().l().getBoolean("key_robot_story_deleted", false)) {
            return;
        }
        aioContext.g().l().putBoolean("key_robot_story_deleted", true);
        AIOParam aioParam = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(aioParam, "aioParam");
        long a16 = su3.c.a(aioParam);
        final String j3 = aioParam.r().c().j();
        String g16 = aioParam.r().c().g();
        final int e16 = aioParam.r().c().e();
        String string = aioParam.l().getString("key_robot_story_name");
        String string2 = aioParam.l().getString("key_robot_story_data");
        QLog.i("RobotStoryBoardApiImpl-RobotStory", 1, "handleDelFriend nick=" + g16 + ", from=" + string);
        StoryUtils.f366640a.F(context, a16, string2, StoryAction.QUITSTORY, false, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.robot.api.impl.RobotStoryBoardApiImpl$handleDelFriend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                invoke(bool.booleanValue(), num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3) {
                if (z16) {
                    StoryUtils storyUtils = StoryUtils.f366640a;
                    storyUtils.D(j3, true);
                    IRobotPersonalInfoService r16 = storyUtils.r();
                    if (r16 != null) {
                        r16.removeFromCache(j3);
                    }
                    String str = j3;
                    int i16 = e16;
                    String string3 = context.getString(R.string.f223566gk);
                    Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.robot_story_exit_tips)");
                    storyUtils.k(str, i16, string3);
                    return;
                }
                QQToast.makeText(context, 1, i3, 1).show();
            }
        });
    }

    @Override // com.tencent.robot.api.IRobotStoryBoardApi
    public void showRobotStoryBoard(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String from) {
        FragmentActivity activity;
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(from, "from");
        if (aioContext.c().getContext() != null && (activity = aioContext.c().getActivity()) != null && (intent = activity.getIntent()) != null && (extras = intent.getExtras()) != null) {
            Intrinsics.checkNotNullExpressionValue(extras, "aioContext.fragment.acti\u2026.intent?.extras ?: return");
            AIOParam g16 = aioContext.g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            extras.putLong("key_peerUin", su3.c.a(g16));
            extras.putString("key_peerId", aioContext.g().r().c().j());
            extras.putString("key_chat_name", aioContext.g().r().c().g());
            RobotStoryBoardDialog.INSTANCE.a(aioContext, from);
        }
    }
}
