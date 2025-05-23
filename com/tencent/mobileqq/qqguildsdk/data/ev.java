package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserJoinedGuildSummary;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface ev {
    int a();

    short b();

    int c();

    er d();

    short e();

    @Nullable
    String f();

    int g();

    byte getAge();

    String getAvatarMeta();

    String getCity();

    IGProClientIdentityInfo getClientIdentity();

    IGProClientPresenceInfo getClientPresence();

    String getDisplayName();

    int getGender();

    int getIsMember();

    long getJoinTime();

    IGProUserJoinedGuildSummary getJoinedGuildSummary();

    ArrayList<eu> getMedals();

    String getMemberName();

    String getNickName();

    String getOpenId();

    String getProvince();

    int getPublishedFeedShowSwitch();

    @Nullable
    ea getRoomState();

    long getShutUpExpireTime();

    String getTinyId();

    String getUin();

    int getUserType();

    String getVerifyUrl();

    String h();

    String i();

    boolean isValid();

    xh2.c j();

    boolean k();

    boolean l();

    ArrayList<dj> m();

    boolean n();

    short o();

    int p();

    long q();

    IGProUserPublishedFeedSummary r();

    em s();

    @Nullable
    String t();
}
