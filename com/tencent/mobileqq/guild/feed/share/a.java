package com.tencent.mobileqq.guild.feed.share;

import android.app.Activity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private ShareActionSheetBuilder.ActionSheetItem f223353a;

    /* renamed from: b, reason: collision with root package name */
    private c f223354b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f223355c;

    public Activity a() {
        return this.f223355c;
    }

    public c b() {
        return this.f223354b;
    }

    public ShareActionSheetBuilder.ActionSheetItem c() {
        return this.f223353a;
    }

    public void d(Activity activity) {
        this.f223355c = activity;
    }

    public void e(c cVar) {
        this.f223354b = cVar;
    }

    public void f(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        this.f223353a = actionSheetItem;
    }
}
