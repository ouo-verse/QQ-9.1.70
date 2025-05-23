package com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.part;

import androidx.lifecycle.Observer;

/* compiled from: P */
/* loaded from: classes33.dex */
public final /* synthetic */ class a implements Observer {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ QQStrangerMsgSettingListPart f244753d;

    public /* synthetic */ a(QQStrangerMsgSettingListPart qQStrangerMsgSettingListPart) {
        this.f244753d = qQStrangerMsgSettingListPart;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        QQStrangerMsgSettingListPart.z9(this.f244753d, (com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel.a) obj);
    }
}
