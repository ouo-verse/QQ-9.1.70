package com.tencent.av.ui;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.av.ui.NormalMenuView;
import com.tencent.av.utils.AVUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class i implements NormalMenuView.a {

    /* renamed from: a, reason: collision with root package name */
    private String f75951a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f75952b = false;

    public i(String str) {
        this.f75951a = str;
    }

    @Override // com.tencent.av.ui.NormalMenuView.a
    public void a(long j3, RelativeLayout relativeLayout, boolean z16) {
        if (!this.f75952b && !TextUtils.isEmpty(this.f75951a)) {
            this.f75952b = true;
            AVUtil.a(this.f75951a, 0);
        }
        if (relativeLayout instanceof QavMenuBaseView) {
            ((QavMenuBaseView) relativeLayout).g(j3, z16);
        }
    }

    @Override // com.tencent.av.ui.NormalMenuView.a
    public void b(long j3, RelativeLayout relativeLayout, boolean z16) {
        this.f75952b = false;
        if (relativeLayout instanceof QavMenuBaseView) {
            ((QavMenuBaseView) relativeLayout).f(j3, z16);
        }
    }
}
