package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ac implements u {

    /* renamed from: d, reason: collision with root package name */
    private int f178762d;

    public void a() {
        this.f178762d = 0;
        if (QLog.isColorLevel()) {
            QLog.d("SpecWordEmotionThinkHelper", 2, " clearSpecWordType");
        }
    }

    public String b() {
        String str;
        if (this.f178762d == 1) {
            str = HardCodeUtil.qqStr(R.string.tn9);
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpecWordEmotionThinkHelper", 2, " getSpecKeyWord:  mSpecWordType=" + this.f178762d);
        }
        return str;
    }

    public boolean c() {
        boolean z16 = true;
        if (this.f178762d != 1) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpecWordEmotionThinkHelper", 2, " needSendMixMsg:  mSpecWordType=" + this.f178762d);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.activity.aio.z
    public void onMoveToState(int i3) {
        if (i3 == 15 || i3 == 19) {
            a();
        }
    }
}
