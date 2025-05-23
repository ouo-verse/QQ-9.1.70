package com.tencent.ecommerce.biz.register.refactoring.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.register.officialAccountFollowedChecker.ECAccountFollowedCheckerViewModel;
import com.tencent.ecommerce.repo.register.ECAgreementCheckBox;
import com.tencent.ecommerce.repo.register.ECRegisterAgreementInfo;
import com.tencent.ecommerce.repo.register.ECRegisterBindFlagToastInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u00168\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001aR\"\u0010+\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterAgreementViewModel;", "Landroidx/lifecycle/ViewModel;", "", "O1", "P1", "R1", "", "index", "", "isChecked", "W1", "N1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/ecommerce/repo/register/c;", "i", "Landroidx/lifecycle/MutableLiveData;", "_agreementInfo", "Lcom/tencent/ecommerce/repo/register/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_bindFlagRespInfo", BdhLogUtil.LogTag.Tag_Conn, "_goOnIsEnable", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "setAgreementInfoLiveData", "(Landroidx/lifecycle/LiveData;)V", "agreementInfoLiveData", "E", "T1", "setBindFlagRespInfoLiveData", "bindFlagRespInfoLiveData", UserInfo.SEX_FEMALE, "U1", "goOnIsEnableLiveData", "G", "Z", "Q1", "()Z", "setAccountFollowChecked", "(Z)V", "accountFollowChecked", "Lcom/tencent/ecommerce/biz/register/officialAccountFollowedChecker/ECAccountFollowedCheckerViewModel;", "H", "Lcom/tencent/ecommerce/biz/register/officialAccountFollowedChecker/ECAccountFollowedCheckerViewModel;", "accountFollowedViewModel", "<init>", "()V", "I", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRegisterAgreementViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<Boolean> _goOnIsEnable;

    /* renamed from: D, reason: from kotlin metadata */
    private LiveData<ECRegisterAgreementInfo> agreementInfoLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private LiveData<ECRegisterBindFlagToastInfo> bindFlagRespInfoLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Boolean> goOnIsEnableLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean accountFollowChecked;

    /* renamed from: H, reason: from kotlin metadata */
    private ECAccountFollowedCheckerViewModel accountFollowedViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<ECRegisterAgreementInfo> _agreementInfo = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<ECRegisterBindFlagToastInfo> _bindFlagRespInfo = new MutableLiveData<>();

    public ECRegisterAgreementViewModel() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._goOnIsEnable = mutableLiveData;
        this.agreementInfoLiveData = this._agreementInfo;
        this.bindFlagRespInfoLiveData = this._bindFlagRespInfo;
        this.goOnIsEnableLiveData = mutableLiveData;
    }

    private final void O1() {
        if (this._agreementInfo.getValue() == null) {
            this._goOnIsEnable.setValue(Boolean.FALSE);
            return;
        }
        ECRegisterAgreementInfo value = this._agreementInfo.getValue();
        List<ECAgreementCheckBox> a16 = value != null ? value.a() : null;
        List<ECAgreementCheckBox> list = a16;
        if (list == null || list.isEmpty()) {
            this._goOnIsEnable.setValue(Boolean.TRUE);
            return;
        }
        for (ECAgreementCheckBox eCAgreementCheckBox : a16) {
            if (eCAgreementCheckBox.isRequired && !eCAgreementCheckBox.getIsChecked()) {
                this._goOnIsEnable.setValue(Boolean.FALSE);
                return;
            }
        }
        this._goOnIsEnable.setValue(Boolean.TRUE);
    }

    private final void P1() {
        if (this.accountFollowedViewModel == null) {
            this.accountFollowedViewModel = new ECAccountFollowedCheckerViewModel();
        }
        ECAccountFollowedCheckerViewModel eCAccountFollowedCheckerViewModel = this.accountFollowedViewModel;
        if (eCAccountFollowedCheckerViewModel != null) {
            eCAccountFollowedCheckerViewModel.N1(1, 2);
        }
    }

    public final void N1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECRegisterAgreementViewModel$bindMcnRightFlag$1(this, null), 3, null);
    }

    /* renamed from: Q1, reason: from getter */
    public final boolean getAccountFollowChecked() {
        return this.accountFollowChecked;
    }

    public final void R1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECRegisterAgreementViewModel$getAgreementInfo$1(this, null), 3, null);
        O1();
    }

    public final LiveData<ECRegisterAgreementInfo> S1() {
        return this.agreementInfoLiveData;
    }

    public final LiveData<ECRegisterBindFlagToastInfo> T1() {
        return this.bindFlagRespInfoLiveData;
    }

    public final LiveData<Boolean> U1() {
        return this.goOnIsEnableLiveData;
    }

    public final void W1(int index, boolean isChecked) {
        List<ECAgreementCheckBox> a16;
        ECRegisterAgreementInfo value = this._agreementInfo.getValue();
        ECAgreementCheckBox eCAgreementCheckBox = (value == null || (a16 = value.a()) == null) ? null : a16.get(index);
        if (eCAgreementCheckBox != null) {
            eCAgreementCheckBox.c(isChecked);
        }
        O1();
        if (eCAgreementCheckBox == null || eCAgreementCheckBox.type != 1) {
            return;
        }
        if (isChecked) {
            P1();
        }
        this.accountFollowChecked = isChecked;
    }
}
