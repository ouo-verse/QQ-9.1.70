package com.tencent.mobileqq.guild.widget.selector;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected Activity f236603a;

    /* renamed from: b, reason: collision with root package name */
    protected GuildActionSheetProfileEdit f236604b;

    /* renamed from: c, reason: collision with root package name */
    protected GuildEditPickerView f236605c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f236606d;

    public a(Activity activity, boolean z16) {
        this.f236603a = activity;
        this.f236606d = z16;
        GuildActionSheetProfileEdit Y = GuildActionSheetProfileEdit.Y(activity, z16);
        this.f236604b = Y;
        this.f236605c = (GuildEditPickerView) Y.findViewById(R.id.lzh);
    }

    public GuildActionSheetProfileEdit.d a() {
        return this.f236604b.Z();
    }

    public void b(GuildActionSheetProfileEdit.d dVar) {
        this.f236604b.a0(dVar);
    }

    public void c(String str) {
        this.f236604b.setTitle(str);
    }

    public void d() {
        try {
            Activity activity = this.f236603a;
            if (activity != null && !activity.isFinishing() && !this.f236604b.isShowing()) {
                this.f236604b.show();
            }
        } catch (Exception e16) {
            QLog.e("BaseSelectorView", 1, "BaseSelectorView show error", e16);
        }
    }
}
