package com.tencent.mobileqq.zplan.aio.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.aio.IZPlanMiniAIOHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/impl/ZPlanMiniAIOHelperImpl;", "Lcom/tencent/mobileqq/zplan/aio/IZPlanMiniAIOHelper;", "()V", "TAG", "", "doNotifyUnreadCount", "", "getMiniAioObserver", "", "notifyUnreadCount", "openMiniMsgTab", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanMiniAIOHelperImpl implements IZPlanMiniAIOHelper {
    private final String TAG = "ZPlanMiniAIOHelperImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyUnreadCount$lambda$0(ZPlanMiniAIOHelperImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doNotifyUnreadCount();
    }

    public final void doNotifyUnreadCount() {
        QQAppInterface qQAppInterface;
        if (!ZPlanServiceHelper.I.l0()) {
            if (QLog.isColorLevel()) {
                QLog.i(this.TAG, 2, "notifyUnreadCount engine is not ready");
                return;
            }
            return;
        }
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            qQAppInterface = (QQAppInterface) runtime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            ((ke3.a) k74.i.INSTANCE.a(ke3.a.class)).notifyUnreadCount(com.tencent.mobileqq.activity.home.chats.unread.c.b());
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanMiniAIOHelper
    public Object getMiniAioObserver() {
        return new ke3.f();
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanMiniAIOHelper
    public void notifyUnreadCount() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.t
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanMiniAIOHelperImpl.notifyUnreadCount$lambda$0(ZPlanMiniAIOHelperImpl.this);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanMiniAIOHelper
    public void openMiniMsgTab(Activity activity) {
        if (activity == null) {
            QLog.d(this.TAG, 1, "activity is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_TYPE, 1);
        intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_NEED_HEADER, true);
        intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_SHIELD_GO_MSGTAB_BTN, true);
        intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_NEED_EMPTY_DATA, false);
        intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME, 30);
        intent.putExtra(MiniChatConstants.KEY_MINI_PIE_NEED_TITLE_RIGHT_BTN, false);
        intent.putExtra(MiniChatConstants.KEY_TAB_GOTO_PIE_WITH_ORIGIN_INTENT, true);
        MiniChatActivity.W2(activity, intent, 0);
    }
}
