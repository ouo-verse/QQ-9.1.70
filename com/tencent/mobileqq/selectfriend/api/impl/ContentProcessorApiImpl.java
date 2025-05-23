package com.tencent.mobileqq.selectfriend.api.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardNewVersionDialog;
import com.tencent.mobileqq.forward.utils.f;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.selectfriend.api.IContentProcessorApi;
import com.tencent.mobileqq.selectfriend.processor.j;
import com.tencent.mobileqq.selectfriend.processor.m;
import com.tencent.mobileqq.selectfriend.processor.n;
import com.tencent.mobileqq.selectfriend.view.ForwardFriendHomeFragment;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.cw;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.forward.NtMsgForwardUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J,\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0018\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J.\u0010\u0015\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001d\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\u001c\u0010!\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u001fH\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/api/impl/ContentProcessorApiImpl;", "Lcom/tencent/mobileqq/selectfriend/api/IContentProcessorApi;", "Lcom/tencent/mobileqq/utils/cw;", "dialog", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "targetList", "", "showForwardTargetAvatar", "", "forwardContentType", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/selectfriend/processor/d;", "getForwardContentProcessor", "", "toUin", "uinType", "toUinType", "guildId", "saveForwardRecord", "Lcom/tencent/mobileqq/selectfriend/model/a;", "dialogData", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "getForwardDefaultDialog", "Landroid/os/Bundle;", "bundle", "resultRecord", "sendMessage", "getForwardId", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivity;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getForwardNodeAdapter", "<init>", "()V", "Companion", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ContentProcessorApiImpl implements IContentProcessorApi {
    private static final String TAG = "ContentProcessorApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getForwardDefaultDialog$lambda$0(View view) {
        return false;
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IContentProcessorApi
    public QQCustomDialog getForwardDefaultDialog(Activity activity, com.tencent.mobileqq.selectfriend.model.a dialogData) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ForwardNewVersionDialog forwardNewVersionDialog = new ForwardNewVersionDialog(activity);
        if (dialogData == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "dialogData is null");
            }
            return forwardNewVersionDialog;
        }
        forwardNewVersionDialog.y0(!dialogData.i());
        forwardNewVersionDialog.C0(210);
        forwardNewVersionDialog.s0(dialogData.c());
        forwardNewVersionDialog.setCanceledOnTouchOutside(false);
        forwardNewVersionDialog.w0(dialogData.d(), dialogData.e(), dialogData.f(), dialogData.g(), dialogData.b(), dialogData.a());
        forwardNewVersionDialog.D0(new ForwardNewVersionDialog.j() { // from class: com.tencent.mobileqq.selectfriend.api.impl.a
            @Override // com.tencent.mobileqq.forward.ForwardNewVersionDialog.j
            public final boolean a(View view) {
                boolean forwardDefaultDialog$lambda$0;
                forwardDefaultDialog$lambda$0 = ContentProcessorApiImpl.getForwardDefaultDialog$lambda$0(view);
                return forwardDefaultDialog$lambda$0;
            }
        });
        showForwardTargetAvatar(forwardNewVersionDialog, activity, dialogData.h());
        if (!activity.isFinishing()) {
            forwardNewVersionDialog.show();
        }
        return forwardNewVersionDialog;
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IContentProcessorApi
    public int getForwardId() {
        return com.tencent.mobileqq.activity.aio.forward.b.d().c();
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IContentProcessorApi
    public List<RecyclerView.Adapter<?>> getForwardNodeAdapter(QPublicFragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QPublicBaseFragment fragment = activity.getFragment();
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.tencent.mobileqq.selectfriend.view.ForwardFriendHomeFragment");
        return ((ForwardFriendHomeFragment) fragment).th();
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IContentProcessorApi
    public void saveForwardRecord(String toUin, String uinType, int toUinType, String guildId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof QQAppInterface)) {
            ForwardUtils.i0((QQAppInterface) peekAppRuntime, toUin, toUinType, guildId);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveForwardRecord null == runtime || (!(runtime instanceof QQAppInterface))");
        }
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IContentProcessorApi
    public void sendMessage(Bundle bundle, ResultRecord resultRecord) {
        if (NtMsgForwardUtils.f(bundle)) {
            return;
        }
        SessionInfo sessionInfo = new SessionInfo();
        if (resultRecord != null) {
            sessionInfo.f179555d = resultRecord.getUinType();
            sessionInfo.f179557e = resultRecord.uin;
            sessionInfo.f179559f = resultRecord.groupUin;
        }
        String string = bundle != null ? bundle.getString(AppConstants.Key.FORWARD_TEXT) : null;
        int c16 = com.tencent.mobileqq.activity.aio.forward.b.d().c();
        int i3 = sessionInfo.f179555d;
        if (i3 != 10014 && i3 != 10016) {
            if (bundle != null && bundle.getInt("forward_type") == 1060) {
                return;
            }
            if (bundle != null && bundle.getInt("forward_type") == 1068) {
                return;
            }
            f.f211079a.i(sessionInfo, string);
            return;
        }
        com.tencent.mobileqq.activity.aio.forward.b.d().h(sessionInfo, string, c16);
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IContentProcessorApi
    public Class<? extends com.tencent.mobileqq.selectfriend.processor.d> getForwardContentProcessor(int forwardContentType) {
        if (forwardContentType == -1000) {
            return n.class;
        }
        if (forwardContentType == -1) {
            return m.class;
        }
        if (forwardContentType != 1) {
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("forwardContentType = %s getForwardContentProcessor is null", Arrays.copyOf(new Object[]{String.valueOf(forwardContentType)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.d(TAG, 2, format);
            }
            return n.class;
        }
        return j.class;
    }

    private final void showForwardTargetAvatar(cw dialog, Activity activity, List<? extends ResultRecord> targetList) {
        String str;
        if (dialog == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !(peekAppRuntime instanceof QQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "saveForwardRecord null == runtime || (!(runtime instanceof QQAppInterface))");
            }
        } else if (targetList != null) {
            if (targetList.size() == 1) {
                ResultRecord resultRecord = targetList.get(0);
                if (resultRecord.uinType == 10014) {
                    str = resultRecord.guildId;
                } else {
                    str = resultRecord.uin;
                }
                dialog.a0((QQAppInterface) peekAppRuntime, activity, str, resultRecord.getUinType(), resultRecord.name, false);
                return;
            }
            dialog.b0((QQAppInterface) peekAppRuntime, activity, targetList, true);
        }
    }
}
