package com.tencent.mobileqq.teamwork.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class MenuTabViewBase extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    protected List<au> f292193d;

    /* renamed from: e, reason: collision with root package name */
    protected List<MenuConfig$ToolBoxPageConfig> f292194e;

    /* renamed from: f, reason: collision with root package name */
    protected a f292195f;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        boolean a(au auVar);
    }

    public MenuTabViewBase(Context context) {
        this(context, null);
    }

    protected abstract void a();

    public abstract void b();

    public abstract void c();

    public void d(List<au> list, List<MenuConfig$ToolBoxPageConfig> list2) {
        this.f292193d = list;
        this.f292194e = list2;
    }

    public void setMenuClickListener(a aVar) {
        this.f292195f = aVar;
    }

    public MenuTabViewBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MenuTabViewBase(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
