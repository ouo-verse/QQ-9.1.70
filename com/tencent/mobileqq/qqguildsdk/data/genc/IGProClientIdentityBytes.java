package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProClientIdentityBytes extends Serializable {
    int getClientId();

    ArrayList<IGProIdentityWithClientId> getDefaultIdentitys();

    ArrayList<IGProIdentity> getIdentitys();

    String toString();
}
