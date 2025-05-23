package com.tencent.open.agent;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.open.agent.datamodel.Friend;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class OpenFrame extends InnerFrame {
    protected BaseQQAppInterface C;
    protected LayoutInflater D;

    /* renamed from: h, reason: collision with root package name */
    protected gp3.b f339902h;

    /* renamed from: i, reason: collision with root package name */
    protected FriendChooser f339903i;

    /* renamed from: m, reason: collision with root package name */
    protected InnerFrameManager f339904m;

    public OpenFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void j(Bundle bundle) {
        super.j(bundle);
        this.f339903i = (FriendChooser) super.e();
        this.f339904m = super.g();
        this.C = super.f();
        this.D = this.f339903i.getLayoutInflater();
        this.f339902h = gp3.b.g();
    }

    public List<Friend> n() {
        ArrayList arrayList = new ArrayList(50);
        for (int i3 = 0; i3 < this.f339902h.f(); i3++) {
            arrayList.addAll(this.f339902h.d(i3));
        }
        return arrayList;
    }

    public abstract void o();
}
