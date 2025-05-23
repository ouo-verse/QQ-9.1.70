package com.tencent.biz.pubaccount.weishi.profile;

import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stSimpleMetaPerson;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface c extends com.tencent.biz.pubaccount.weishi.d<d> {
    stSimpleMetaPerson B();

    boolean S();

    void T(stSimpleMetaPerson stsimplemetaperson, String str);

    void W(boolean z16);

    void b(WSSimpleBaseEvent wSSimpleBaseEvent);

    ArrayList<Class> getEventClass();

    String getFrom();

    stShareInfo getShareInfo();

    boolean j0();

    boolean k();

    void l0();

    void m0(int i3);

    void o0(Bundle bundle);

    String q0();

    boolean r0();

    void u(boolean z16);

    boolean z();
}
