package com.tencent.robot.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.heytap.databaseengine.type.DataTableNameType;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "arkInfoStr", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotShareActionExecutor$shareToFriendByUin$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ITroopUtilApi $troopApi;
    final /* synthetic */ int $type;
    final /* synthetic */ String $uin;
    final /* synthetic */ RobotShareActionExecutor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotShareActionExecutor$shareToFriendByUin$1(ITroopUtilApi iTroopUtilApi, RobotShareActionExecutor robotShareActionExecutor, String str, int i3) {
        super(1);
        this.$troopApi = iTroopUtilApi;
        this.this$0 = robotShareActionExecutor;
        this.$uin = str;
        this.$type = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RobotShareActionExecutor this$0) {
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        activity = this$0.mActivity;
        QQToast.makeText(activity, 0, R.string.f223416g6, 0).show();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String arkInfoStr) {
        Activity activity;
        n nVar;
        Activity activity2;
        n nVar2;
        Intrinsics.checkNotNullParameter(arkInfoStr, "arkInfoStr");
        if (arkInfoStr.length() == 0) {
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final RobotShareActionExecutor robotShareActionExecutor = this.this$0;
            rFWThreadManager.runOnUiThread(new Runnable() { // from class: com.tencent.robot.share.j
                @Override // java.lang.Runnable
                public final void run() {
                    RobotShareActionExecutor$shareToFriendByUin$1.b(RobotShareActionExecutor.this);
                }
            });
            return;
        }
        ITroopUtilApi iTroopUtilApi = this.$troopApi;
        activity = this.this$0.mActivity;
        nVar = this.this$0.mProvider;
        Bundle forwardRobotCardBundle = iTroopUtilApi.getForwardRobotCardBundle(activity, nVar.l(), arkInfoStr);
        forwardRobotCardBundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        forwardRobotCardBundle.putInt("key_direct_show_uin_type", 1);
        forwardRobotCardBundle.putString("key_direct_show_uin", this.$uin);
        forwardRobotCardBundle.putInt("key_direct_show_uin_type", this.$type);
        if (this.$type == 10014) {
            forwardRobotCardBundle.putInt("forward_type", DataTableNameType.TABLE_WRIST_TEMPERATURE_STAT);
            nVar2 = this.this$0.mProvider;
            forwardRobotCardBundle.putString("robot_appid", nVar2.i());
        }
        forwardRobotCardBundle.putBoolean("is_need_show_toast", true);
        Intent intent = new Intent();
        intent.putExtra("isFromShare", true);
        intent.putExtras(forwardRobotCardBundle);
        activity2 = this.this$0.mActivity;
        RouteUtils.startActivityForResult(activity2, intent, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, -1);
        if (QLog.isColorLevel()) {
            QLog.d("robot.share.RobotShareActionExecutor", 1, "directlyShareToFriend success");
        }
    }
}
