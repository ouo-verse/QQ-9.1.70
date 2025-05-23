package com.tencent.mobileqq.troop.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import java.util.Map;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopNotificationService extends IRuntimeService {
    void addLackApplicantInfoUinToCacheBy0x5eb(Long l3);

    void addLackApplicantInfoUinToCacheBy0x668(Long l3);

    @Nullable
    com.tencent.mobileqq.data.troop.d getApplicantInfo(Long l3);

    void getNotifyCationApplicantInfoBy0x5eb(@Nullable List<Long> list);

    void getNotifyCationApplicantQQLevelBy0x668(@Nullable List<Long> list);

    @NonNull
    List<Long> getWaitingLevelApplicantInfoUinFromCache();

    @NonNull
    List<Long> getWaitingTagApplicantInfoUinFromCache();

    void saveApplicantInfoListToCacheFrom0x5eb(@Nullable List<com.tencent.mobileqq.data.troop.d> list);

    void saveApplicantInfoToCacheFrom0x668(Map<Long, Integer> map);
}
