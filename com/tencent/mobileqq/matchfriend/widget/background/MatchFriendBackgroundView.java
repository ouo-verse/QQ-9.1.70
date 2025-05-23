package com.tencent.mobileqq.matchfriend.widget.background;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendBackgroundView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Context f245675d;

    /* renamed from: e, reason: collision with root package name */
    private MatchFriendStarView f245676e;

    /* renamed from: f, reason: collision with root package name */
    private MatchFriendCometView f245677f;

    public MatchFriendBackgroundView(Context context) {
        this(context, null);
    }

    public void a() {
        this.f245677f.m();
    }

    public void b() {
        this.f245677f.r();
    }

    public MatchFriendBackgroundView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MatchFriendBackgroundView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f245675d = context;
        this.f245676e = new MatchFriendStarView(context);
        this.f245677f = new MatchFriendCometView(context);
        addView(this.f245676e);
        addView(this.f245677f);
    }
}
