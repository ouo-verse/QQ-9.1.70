package com.tencent.mobileqq.profilecard.api;

import android.os.Bundle;
import com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileProtocolService extends IRuntimeService, IProfileProtocolConst {
    <T extends AbsProfileBusinessProcessor> T getBusinessProcessor(Class<? extends AbsProfileBusinessProcessor> cls);

    void getProfileDetail(String str, List<Short> list, int i3, Bundle bundle);

    void getProfileDetailForEdit();

    void getProfileDetailForLogin();

    void requestProfileCard(Bundle bundle);

    void requestProfileCard(String str, String str2, int i3, long j3, byte b16, long j16, long j17, byte[] bArr, String str3, long j18, int i16, byte[] bArr2, byte b17);

    void setProfileDetail(Bundle bundle);
}
