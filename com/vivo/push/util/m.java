package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class m implements BaseNotifyLayoutAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Resources f387910a;

    /* renamed from: b, reason: collision with root package name */
    private String f387911b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f387910a.getIdentifier("push_notify", TtmlNode.TAG_LAYOUT, this.f387911b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        if (n.f387915d) {
            resources = this.f387910a;
            str = "notify_icon_rom30";
        } else if (n.f387914c) {
            resources = this.f387910a;
            str = "notify_icon_rom20";
        } else {
            resources = this.f387910a;
            str = "notify_icon";
        }
        return resources.getIdentifier(str, "id", this.f387911b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i3;
        try {
            i3 = ((Integer) ag.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = 0;
        }
        if (i3 > 0) {
            return this.f387910a.getColor(i3);
        }
        boolean z16 = n.f387915d;
        if (z16) {
            return -1;
        }
        if (n.f387914c) {
            if (!z16) {
                return -1;
            }
            return Color.parseColor("#ff999999");
        }
        return -16777216;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.f387911b = context.getPackageName();
        this.f387910a = context.getResources();
    }
}
