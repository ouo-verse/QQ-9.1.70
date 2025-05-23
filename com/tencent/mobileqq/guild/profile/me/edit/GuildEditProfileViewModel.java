package com.tencent.mobileqq.guild.profile.me.edit;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.profile.me.aj;
import com.tencent.mobileqq.guild.profile.me.ak;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GProLocationInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPersonalSignatureTemplate;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes14.dex */
public class GuildEditProfileViewModel extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    public static final String TAG = "Guild.profile.GuildEditProfileViewModel";
    private String mCalledFunctionName;
    public final cn<String> mErrorToastEvent;
    private IGPSService mGproService;
    public final MutableLiveData<ev> mLiveProfileInfo;
    private ak mProfileChangeListener;

    /* loaded from: classes14.dex */
    public class a implements ak {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.profile.me.ak
        public void a(@NonNull ev evVar) {
            if (QLog.isColorLevel()) {
                QLog.i(GuildEditProfileViewModel.TAG, 2, "onProfileChange nickname: " + evVar.getNickName());
            }
            GuildEditProfileViewModel.this.mLiveProfileInfo.postValue(evVar);
        }
    }

    public GuildEditProfileViewModel() {
        super(new wy1.a());
        this.mLiveProfileInfo = new MutableLiveData<>();
        this.mErrorToastEvent = new cn<>();
        this.mProfileChangeListener = createProfileChangeListener();
        this.mCalledFunctionName = "";
        this.mGproService = (IGPSService) ch.R0(IGPSService.class);
        addListener();
    }

    private void addListener() {
        aj.g(this.mProfileChangeListener);
    }

    @NonNull
    private ak createProfileChangeListener() {
        return new a();
    }

    public void handleUpdateCallback(int i3, String str) {
        if (i3 != 0) {
            QLog.e(TAG, 1, this.mCalledFunctionName, " error, result", Integer.valueOf(i3), " errorMsg", str);
            this.mErrorToastEvent.setValue(str);
        } else {
            QLog.d(TAG, 2, this.mCalledFunctionName, " success");
        }
    }

    private void removeListener() {
        aj.q(this.mProfileChangeListener);
    }

    public cn<String> getErrorToast() {
        return this.mErrorToastEvent;
    }

    public MutableLiveData<ev> getLiveProfileInfo() {
        return this.mLiveProfileInfo;
    }

    public ArrayList<IGProPersonalSignatureTemplate> getPersonalSignatureTemplates() {
        return this.mGproService.getPersonalSignatureTemplate();
    }

    public void initData() {
        ev l3 = aj.l();
        if (l3 != null) {
            this.mLiveProfileInfo.setValue(l3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        removeListener();
    }

    public void refreshProfile() {
        aj.p();
    }

    public void setBirthday(int i3, int i16, int i17) {
        this.mCalledFunctionName = "setGender";
        this.mGproService.setMyBirthday((short) i3, (short) i16, (short) i17, new aa(this));
    }

    public void setGender(int i3) {
        this.mCalledFunctionName = "setGender";
        this.mGproService.setGender(i3, new z(this));
    }

    public void setLocation(GProLocationInfo gProLocationInfo) {
        gProLocationInfo.r(gProLocationInfo.g());
        gProLocationInfo.t(gProLocationInfo.k());
        gProLocationInfo.n(gProLocationInfo.b());
        this.mCalledFunctionName = "setLocation";
        this.mGproService.setLocation(gProLocationInfo, new z(this));
    }

    public void setPersonalSignature(String str) {
        this.mCalledFunctionName = "setPersonalSignature";
        this.mGproService.setMyPersonalSignature(str, new aa(this));
    }
}
