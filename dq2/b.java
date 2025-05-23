package dq2;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.selectfriend.model.FSLayoutData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b,\u0018\u0000 L2\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\u001a\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\rR\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010(R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010(R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010(R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010(R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010(R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010(R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010(R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010(R\u0018\u0010B\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0011\u0010G\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR\u0011\u0010I\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010F\u00a8\u0006N"}, d2 = {"Ldq2/b;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "f2", "", "actionType", "subActionType", "reserves", "reserves2", "e2", SemanticAttributes.DbSystemValues.H2, "", "b", "g2", "getLogTag", "Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;", "fsLayout", "d2", "Landroidx/lifecycle/MutableLiveData;", "", "N1", "R1", "O1", "P1", "S1", "X1", "L1", "T1", "Q1", "W1", "U1", "M1", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", ICustomDataEditor.STRING_ARRAY_PARAM_2, "isSingleStatusInSearch", "Z1", "i", "Landroidx/lifecycle/MutableLiveData;", "titleLiveData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "selectSingleModeLiveData", BdhLogUtil.LogTag.Tag_Conn, "refreshRightBtnLiveData", "D", "finishLiveData", "E", "switch2MultiSelectStatusLiveData", UserInfo.SEX_FEMALE, "switch2DefaultSelectStatusLiveData", "G", "rightButtonVisibleLiveData", "H", "leftButtonVisibleLiveData", "I", "rightButtonTextLiveData", "J", "leftButtonTextLiveData", "K", "leftButtonResLiveData", "L", "forward2MultiTargetsLiveData", "M", "Ljava/lang/Integer;", "mCurrentStatus", "N", "mCurrentMode", "c2", "()Z", "isMultiSelectStatus", "b2", "isMultiSelectMode", "<init>", "()V", "P", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<String> titleLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> selectSingleModeLiveData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> refreshRightBtnLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> finishLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> switch2MultiSelectStatusLiveData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> switch2DefaultSelectStatusLiveData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> rightButtonVisibleLiveData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> leftButtonVisibleLiveData = new MutableLiveData<>();

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<String> rightButtonTextLiveData = new MutableLiveData<>();

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<String> leftButtonTextLiveData = new MutableLiveData<>();

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<Integer> leftButtonResLiveData = new MutableLiveData<>();

    /* renamed from: L, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> forward2MultiTargetsLiveData = new MutableLiveData<>();

    /* renamed from: M, reason: from kotlin metadata */
    private Integer mCurrentStatus = 0;

    /* renamed from: N, reason: from kotlin metadata */
    private Integer mCurrentMode = 2;

    private final void e2(String actionType, String subActionType, String reserves, String reserves2) {
        Bundle bundle = new Bundle();
        bundle.putString("key_mini_report_event_action_type", actionType);
        bundle.putString("key_mini_report_event_sub_action_type", subActionType);
        bundle.putString("key_mini_report_event_reserves", reserves);
        bundle.putString("key_mini_report_event_reserves2", reserves2);
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_REPORT_EVENT, bundle, null);
    }

    public final MutableLiveData<Boolean> L1() {
        return this.finishLiveData;
    }

    public final MutableLiveData<Boolean> M1() {
        return this.forward2MultiTargetsLiveData;
    }

    public final MutableLiveData<Integer> N1() {
        return this.leftButtonResLiveData;
    }

    public final MutableLiveData<String> O1() {
        return this.leftButtonTextLiveData;
    }

    public final MutableLiveData<Boolean> P1() {
        return this.leftButtonVisibleLiveData;
    }

    public final MutableLiveData<Boolean> Q1() {
        return this.refreshRightBtnLiveData;
    }

    public final MutableLiveData<String> R1() {
        return this.rightButtonTextLiveData;
    }

    public final MutableLiveData<Boolean> S1() {
        return this.rightButtonVisibleLiveData;
    }

    public final MutableLiveData<Boolean> T1() {
        return this.selectSingleModeLiveData;
    }

    public final MutableLiveData<Boolean> U1() {
        return this.switch2DefaultSelectStatusLiveData;
    }

    public final MutableLiveData<Boolean> W1() {
        return this.switch2MultiSelectStatusLiveData;
    }

    public final MutableLiveData<String> X1() {
        return this.titleLiveData;
    }

    public final void Z1(boolean isSingleStatusInSearch) {
        if (c2()) {
            g2(true);
        } else if (isSingleStatusInSearch) {
            g2(true);
        } else {
            this.finishLiveData.postValue(Boolean.TRUE);
        }
    }

    public final void a2(QQAppInterface app, Bundle extraData) {
        if (!b2()) {
            IPhoneContactService iPhoneContactService = app != null ? (IPhoneContactService) app.getRuntimeService(IPhoneContactService.class, "") : null;
            boolean z16 = false;
            if (iPhoneContactService != null) {
                iPhoneContactService.setOpeningShareFlag(false);
            }
            Boolean valueOf = extraData != null ? Boolean.valueOf(extraData.getBoolean("needShareCallBack", false)) : null;
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(valueOf, bool)) {
                QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_FAIL_CALLBACK, null, null);
            }
            f2(extraData);
            this.finishLiveData.postValue(bool);
            if (extraData != null && extraData.getBoolean(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK, false)) {
                z16 = true;
            }
            if (z16) {
                ReportController.o(app, "dc00898", "", "", "0X8009F7A", "0X8009F7A", 0, 0, "2", "", "", "");
                return;
            }
            return;
        }
        if (c2()) {
            this.forward2MultiTargetsLiveData.postValue(Boolean.TRUE);
        } else {
            h2();
        }
    }

    public final boolean b2() {
        Integer num = this.mCurrentMode;
        return num != null && num.intValue() == 2;
    }

    public final boolean c2() {
        Integer num = this.mCurrentStatus;
        return num != null && num.intValue() == 1;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "ForwardFriend..HomeTitleBarViewModel";
    }

    private final void g2(boolean b16) {
        this.mCurrentStatus = 0;
        this.switch2DefaultSelectStatusLiveData.postValue(Boolean.TRUE);
    }

    private final void h2() {
        this.mCurrentStatus = 1;
        this.switch2MultiSelectStatusLiveData.postValue(Boolean.TRUE);
    }

    private final void f2(Bundle extraData) {
        Integer valueOf = extraData != null ? Integer.valueOf(extraData.getInt("miniAppShareFrom", -1)) : null;
        if (valueOf != null && valueOf.intValue() == 10) {
            e2("user_click", "more_about", "share", "fail");
            return;
        }
        if (valueOf != null && valueOf.intValue() == 11) {
            e2("user_click", "custom_button", "share_QQ", "fail");
        } else if (valueOf != null && valueOf.intValue() == 12) {
            e2("user_click", "more_button", "share_QQ", "fail");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
    
        if (r2.intValue() == 1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d2(Bundle extraData, FSLayoutData fsLayout) {
        if (extraData == null) {
            return;
        }
        String e16 = fsLayout != null ? fsLayout.e() : null;
        if (TextUtils.isEmpty(e16)) {
            e16 = HardCodeUtil.qqStr(R.string.moi);
        }
        this.titleLiveData.postValue(e16);
        Integer valueOf = Integer.valueOf(fsLayout != null ? fsLayout.c() : 2);
        this.mCurrentMode = valueOf;
        MutableLiveData<Boolean> mutableLiveData = this.selectSingleModeLiveData;
        boolean z16 = (valueOf == null || (r2 = this.mCurrentStatus) == null) ? false : true;
        mutableLiveData.postValue(Boolean.valueOf(z16));
    }
}
