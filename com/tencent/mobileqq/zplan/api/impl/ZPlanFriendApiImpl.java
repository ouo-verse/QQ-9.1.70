package com.tencent.mobileqq.zplan.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.au;
import com.tencent.mobileqq.zplan.api.IZPlanFriendApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class ZPlanFriendApiImpl implements IZPlanFriendApi {
    private static final String TAG = "ZPlanFriendApiImpl";

    /* loaded from: classes35.dex */
    class a implements au.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f331358a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f331359b;

        a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
            this.f331358a = onClickListener;
            this.f331359b = onClickListener2;
        }

        @Override // com.tencent.mobileqq.vas.au.b
        public void onLeftClick() {
            this.f331358a.onClick(null);
        }

        @Override // com.tencent.mobileqq.vas.au.b
        public void onRightClick() {
            this.f331359b.onClick(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNotifyUnreadCount(int i3) {
        if (!ZPlanServiceHelper.I.l0()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "notifyUnreadCount engine is not ready");
            }
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("newInvitationCount", i3);
                ((com.tencent.mobileqq.zootopia.ipc.u) k74.i.f(com.tencent.mobileqq.zootopia.ipc.u.class)).onNewFriendInvitation(jSONObject);
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "doNotifyUnreadCount JSONException", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanFriendApi
    public void notifyUnreadCount() {
        final int zPlanUnreadNum = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getZPlanUnreadNum();
        if (zPlanUnreadNum > 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanFriendApiImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    ZPlanFriendApiImpl.this.doNotifyUnreadCount(zPlanUnreadNum);
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanFriendApi
    public void openNativeForwardRecentPage(Context context, Intent intent, String str, boolean z16, int i3) {
        openNativeForwardRecentPage(context, intent, str, z16, i3, true);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanFriendApi
    public boolean shouldShowDoubleZanPopWindow(AppInterface appInterface) {
        return VoteHelper.n((QQAppInterface) appInterface);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanFriendApi
    public void showDoubleZanDialog(Activity activity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        au auVar = new au(activity);
        auVar.N(new a(onClickListener, onClickListener2));
        auVar.show();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanFriendApi
    public void showRefuseAddFriendDialog(final Activity activity) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanFriendApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = activity;
                if (activity2 != null && !activity2.isFinishing()) {
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
                    createCustomDialog.setTitle(activity.getString(R.string.yke));
                    createCustomDialog.setMessage(activity.getString(R.string.h0a));
                    createCustomDialog.setCancelable(false);
                    createCustomDialog.setCanceledOnTouchOutside(false);
                    Window window = createCustomDialog.getWindow();
                    if (window != null) {
                        window.setDimAmount(0.5f);
                        window.addFlags(2);
                    }
                    createCustomDialog.setPositiveButton(R.string.f171151ok, new a()).setNegativeButton((String) null, (DialogInterface.OnClickListener) null).show();
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ZPlanFriendApiImpl.TAG, 2, "showRefuseAddFriendDialog is finishing return");
                }
            }

            /* renamed from: com.tencent.mobileqq.zplan.api.impl.ZPlanFriendApiImpl$1$a */
            /* loaded from: classes35.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanFriendApi
    public void openNativeForwardRecentPage(Context context, Intent intent, String str, boolean z16, int i3, boolean z17) {
        if (context != null && intent != null && !TextUtils.isEmpty(str)) {
            Intent intent2 = new Intent(intent);
            if (z17) {
                intent2.putExtra("forward_type", 49);
                intent2.putExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN, true);
                intent2.putExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN_APPID, str);
            } else {
                intent2.putExtra("forward_type", 54);
            }
            intent2.putExtra(ForwardRecentActivity.SELECTION_MODE, z16 ? 2 : 1);
            RouteUtils.startActivityForResult(context, intent2, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, i3);
            return;
        }
        QLog.e(TAG, 1, "openNativeForwardRecentPage param error");
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanFriendApi
    public void notifyNewFriendDialogClose(JSONObject jSONObject) {
        if (jSONObject != null) {
            ((com.tencent.mobileqq.zootopia.ipc.u) k74.i.f(com.tencent.mobileqq.zootopia.ipc.u.class)).onNewFriendDialogClose(jSONObject);
        }
    }
}
