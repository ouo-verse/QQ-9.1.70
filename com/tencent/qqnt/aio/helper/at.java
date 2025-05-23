package com.tencent.qqnt.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0006\u0010\u0013\u001a\u00020\u0002R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010%R\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010%\u00a8\u0006:"}, d2 = {"Lcom/tencent/qqnt/aio/helper/at;", "Lcom/tencent/aio/main/businesshelper/h;", "", "e", "", "tip", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "b", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "g", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Landroid/app/Activity;", "f", "Landroid/app/Activity;", "mActivity", "Lcom/tencent/mobileqq/app/QQAppInterface;", tl.h.F, "Lcom/tencent/mobileqq/app/QQAppInterface;", "mApp", "", "i", "Z", "mThirdPartyPull", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mPullAudio", BdhLogUtil.LogTag.Tag_Conn, "mPullVideo", "D", "Ljava/lang/String;", "mOpenId", "E", "mAppId", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "G", "hasHandled", "<init>", "()V", "H", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class at implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mPullVideo;

    /* renamed from: D, reason: from kotlin metadata */
    private String mOpenId;

    /* renamed from: E, reason: from kotlin metadata */
    private String mAppId;

    /* renamed from: F, reason: from kotlin metadata */
    private SessionInfo sessionInfo = new SessionInfo();

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasHandled;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Activity mActivity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QQAppInterface mApp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mThirdPartyPull;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mPullAudio;

    private final QQCustomDialog b(String tip) {
        QQCustomDialog message = DialogUtil.createCustomDialog(this.mActivity, 230).setTitle((String) null).setMessage(tip);
        Activity activity = this.mActivity;
        Intrinsics.checkNotNull(activity);
        QQCustomDialog positiveButton = message.setPositiveButton(activity.getString(R.string.f170648xe), new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.as
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                at.c(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "createCustomDialog(mActi\u2026ch -> dialog.dismiss() })");
        return positiveButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void e() {
        AIOParam g16;
        if (QLog.isColorLevel()) {
            QLog.d("ForwardIMByThirdPartyHelper", 2, "handleForwardIM");
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        Bundle l3 = (aVar == null || (g16 = aVar.g()) == null) ? null : g16.l();
        if (l3 == null) {
            this.hasHandled = false;
            return;
        }
        this.mThirdPartyPull = l3.getBoolean(AppConstants.Key.THRIPARTY_PULL_AIO, false);
        this.mPullAudio = l3.getBoolean(AppConstants.Key.PULL_AIO_AUDIO, false);
        this.mPullVideo = l3.getBoolean(AppConstants.Key.PULL_AIO_VIDEO, false);
        this.mOpenId = l3.getString("openid", "");
        this.mAppId = l3.getString("appid", "");
        this.sessionInfo.f179557e = l3.getString("uin");
        this.sessionInfo.f179555d = l3.getInt("uintype");
        this.sessionInfo.f179564m = l3.getString(AppConstants.Key.PHONENUM);
        this.sessionInfo.f179563i = l3.getString("uinname", "");
        if (this.mThirdPartyPull) {
            g();
        } else {
            this.hasHandled = false;
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.D0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "ForwardIMByThirdPartyHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Fragment c16;
        Fragment c17;
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        FragmentActivity fragmentActivity = null;
        Context requireContext = (a16 == null || (c17 = a16.c()) == null) ? null : c17.requireContext();
        Intrinsics.checkNotNull(requireContext);
        this.mContext = requireContext;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null && (c16 = aVar.c()) != null) {
            fragmentActivity = c16.getActivity();
        }
        this.mActivity = fragmentActivity;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        this.mApp = (QQAppInterface) peekAppRuntime;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        this.mAIOContext = null;
        this.mContext = null;
        this.mActivity = null;
    }

    public final void g() {
        QQAppInterface qQAppInterface = this.mApp;
        if (qQAppInterface != null) {
            if (this.mPullAudio) {
                Intrinsics.checkNotNull(qQAppInterface);
                if (Intrinsics.areEqual(qQAppInterface.getCurrentAccountUin(), this.sessionInfo.f179557e)) {
                    Activity activity = this.mActivity;
                    Intrinsics.checkNotNull(activity);
                    String string = activity.getString(R.string.izj);
                    Intrinsics.checkNotNullExpressionValue(string, "mActivity!!.getString(R.\u2026ty_audio_video_self_fail)");
                    b(string).show();
                    return;
                }
                ReportController.o(this.mApp, "dc01160", "", "", "0X800A40C", "0X800A40C", 0, 0, "", "", "", "");
                QQAppInterface qQAppInterface2 = this.mApp;
                Activity activity2 = this.mActivity;
                SessionInfo sessionInfo = this.sessionInfo;
                ChatActivityUtils.j0(qQAppInterface2, activity2, sessionInfo.f179555d, sessionInfo.f179557e, sessionInfo.f179563i, sessionInfo.f179564m, true, "", true, true, null, "from_internal", null);
                return;
            }
            if (this.mPullVideo) {
                Intrinsics.checkNotNull(qQAppInterface);
                if (Intrinsics.areEqual(qQAppInterface.getCurrentAccountUin(), this.sessionInfo.f179557e)) {
                    Activity activity3 = this.mActivity;
                    Intrinsics.checkNotNull(activity3);
                    String string2 = activity3.getString(R.string.izj);
                    Intrinsics.checkNotNullExpressionValue(string2, "mActivity!!.getString(R.\u2026ty_audio_video_self_fail)");
                    b(string2).show();
                    return;
                }
                ReportController.o(this.mApp, "dc01160", "", "", "0X800A40D", "0X800A40D", 0, 0, "", "", "", "");
                QQAppInterface qQAppInterface3 = this.mApp;
                Activity activity4 = this.mActivity;
                SessionInfo sessionInfo2 = this.sessionInfo;
                ChatActivityUtils.j0(qQAppInterface3, activity4, sessionInfo2.f179555d, sessionInfo2.f179557e, sessionInfo2.f179563i, sessionInfo2.f179564m, false, "", true, true, null, "from_internal", null);
                return;
            }
            ReportController.o(qQAppInterface, "dc01160", "", "", "0X800A40B", "0X800A40B", 0, 0, "", "", "", "");
            this.hasHandled = false;
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 3) {
            if (state == 12 && QLog.isColorLevel()) {
                QLog.d("ForwardIMByThirdPartyHelper", 4, "DESTROY");
                return;
            }
            return;
        }
        if (this.hasHandled) {
            return;
        }
        this.hasHandled = true;
        e();
    }
}
