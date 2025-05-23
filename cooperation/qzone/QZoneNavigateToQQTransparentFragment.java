package cooperation.qzone;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.chat.e;
import com.tencent.mobileqq.qqexpand.utils.ICampusHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import ne0.a;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneNavigateToQQTransparentFragment extends PublicBaseFragment {
    public static final String EXTRA_KEY_EXTEND_FRIEND_CAMPUS_AIO_CODE = "extend_friend_campus_aio_code";
    public static final String EXTRA_KEY_EXTEND_FRIEND_CAMPUS_ALGORITHM_ID = "extend_friend_campus_algorithm_id";
    public static final String EXTRA_KEY_EXTEND_FRIEND_CAMPUS_CURRENT_TAB = "extend_friend_campus_current_tab";
    public static final String EXTRA_KEY_NICKNAME = "nickname";
    public static final String EXTRA_KEY_REQUEST_CODE = "request_code";
    public static final String EXTRA_KEY_UIN = "uin";
    public static final int REQUEST_CODE_LAUNCH_CAMPUS_AIO_CHAT = 1;
    private static final String TAG = "QZoneNavigateToQQTransparentFragment";
    private boolean mHasParsedIntent;

    public static void enterAio(BaseActivity baseActivity, String str, String str2) {
        if (baseActivity == null) {
            return;
        }
        Intent intent = new Intent(baseActivity, (Class<?>) ChatActivity.class);
        intent.putExtra("uin", str);
        intent.putExtra("uinname", str2);
        intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 23);
        intent.putExtra("uintype", 1045);
        intent.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_ENTER_TYPE, 1);
        intent.putExtras(new Bundle());
        baseActivity.startActivity(intent);
        baseActivity.finish();
    }

    public static void showCampusVerifyDialog(final BaseActivity baseActivity, final boolean z16, final int i3, final String str, final String str2) {
        if (baseActivity != null && baseActivity.isResume()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(baseActivity, 230);
            createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: cooperation.qzone.QZoneNavigateToQQTransparentFragment.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    BaseActivity.this.finish();
                }
            });
            createCustomDialog.setMessage(baseActivity.getString(R.string.f198894ny)).setNegativeButton(baseActivity.getString(R.string.f198874nw), new DialogInterface.OnClickListener() { // from class: cooperation.qzone.QZoneNavigateToQQTransparentFragment.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i16) {
                    dialogInterface.dismiss();
                }
            }).setPositiveButton(baseActivity.getString(R.string.f198884nx), new DialogInterface.OnClickListener() { // from class: cooperation.qzone.QZoneNavigateToQQTransparentFragment.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i16) {
                    if (z16) {
                        ((ICampusHelper) QRoute.api(ICampusHelper.class)).jumpToSchoolCertificateWebPage(baseActivity, i3, str, str2);
                    } else {
                        ((ICampusHelper) QRoute.api(ICampusHelper.class)).jumpToSchoolFillInWebPage(baseActivity, str);
                    }
                    dialogInterface.dismiss();
                }
            }).show();
            return;
        }
        QLog.d(TAG, 1, "showCampusVerifyDialog() activity is null or is not onResume() just return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showMatchCountDialog(final BaseActivity baseActivity) {
        if (baseActivity != null && baseActivity.isResume()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(baseActivity, 230);
            createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: cooperation.qzone.QZoneNavigateToQQTransparentFragment.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    BaseActivity.this.finish();
                }
            });
            createCustomDialog.setMessage(baseActivity.getString(R.string.f198914o0)).setPositiveButton(baseActivity.getString(R.string.f198904nz), new DialogInterface.OnClickListener() { // from class: cooperation.qzone.QZoneNavigateToQQTransparentFragment.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            }).show();
            return;
        }
        QLog.d(TAG, 1, "showMatchCountDialog() activity is null or is not onResume() just return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showToast(final BaseActivity baseActivity, String str) {
        if (baseActivity != null && baseActivity.isResume()) {
            QQToast.makeText(baseActivity, str, 0).show(baseActivity.getTitleBarHeight());
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: cooperation.qzone.QZoneNavigateToQQTransparentFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    BaseActivity.this.finish();
                }
            }, 0L);
        } else {
            QLog.d(TAG, 1, "showToast() activity is null or is not onResume() just return");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.requestWindowFeature(1);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            baseActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            baseActivity.finish();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mHasParsedIntent) {
            this.mHasParsedIntent = true;
            parseIntent();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    protected void parseIntent() {
        Intent intent;
        Bundle extras;
        final BaseActivity baseActivity = getBaseActivity();
        byte[] bArr = null;
        if (baseActivity != null) {
            intent = baseActivity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        int i3 = extras.getInt(EXTRA_KEY_REQUEST_CODE);
        if (i3 != 1) {
            QZLog.i(TAG, "parseIntent: wrong code " + i3);
            return;
        }
        long j3 = extras.getLong("uin");
        String string = extras.getString("nickname");
        String string2 = extras.getString(EXTRA_KEY_EXTEND_FRIEND_CAMPUS_AIO_CODE);
        QZLog.i(TAG, "parseIntent: " + j3 + " " + string + " " + string2);
        if (!TextUtils.isEmpty(string2)) {
            try {
                bArr = Base64.decode(string2, 0);
            } catch (Throwable th5) {
                QLog.d(TAG, 2, "[open limit chat] parse strKuolieCampusAIOKey error! " + string2, th5);
            }
        }
        ((IExpandMsgSendHelper) QRoute.api(IExpandMsgSendHelper.class)).sendMsgDirectly(baseActivity.app, String.valueOf(j3), string, bArr, 1, new e() { // from class: cooperation.qzone.QZoneNavigateToQQTransparentFragment.1
            @Override // com.tencent.mobileqq.qqexpand.chat.e
            public void enterAio(String str, String str2) {
                QZoneNavigateToQQTransparentFragment.enterAio(baseActivity, str, str2);
            }

            public void showCampusVerifyDialog(boolean z16, int i16, String str, String str2) {
                QZoneNavigateToQQTransparentFragment.showCampusVerifyDialog(baseActivity, z16, i16, str, str2);
            }

            @Override // com.tencent.mobileqq.qqexpand.chat.e
            public void showMatchCountDialog() {
                QZoneNavigateToQQTransparentFragment.showMatchCountDialog(baseActivity);
            }

            @Override // com.tencent.mobileqq.qqexpand.chat.e
            public void showToast(int i16) {
                BaseActivity baseActivity2 = baseActivity;
                if (baseActivity2 != null) {
                    QZoneNavigateToQQTransparentFragment.showToast(baseActivity2, baseActivity2.getString(i16));
                } else {
                    QLog.d(QZoneNavigateToQQTransparentFragment.TAG, 1, "sendMsgDirectly()-> showToast() activity is null just return");
                }
            }
        });
        ExtendFriendReport.a().n(1, String.valueOf(j3), "", "0", extras.getString(EXTRA_KEY_EXTEND_FRIEND_CAMPUS_ALGORITHM_ID), extras.getString(EXTRA_KEY_EXTEND_FRIEND_CAMPUS_CURRENT_TAB, "\u63a8\u8350"));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return a.c(this, str, cls);
    }
}
