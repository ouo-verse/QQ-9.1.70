package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected AppInterface f292578a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f292579b;

    /* renamed from: c, reason: collision with root package name */
    protected BaseAdapter f292580c;

    /* renamed from: d, reason: collision with root package name */
    protected int f292581d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public h f292582a;

        public a() {
        }
    }

    public b(AppInterface appInterface, Context context, BaseAdapter baseAdapter, int i3) {
        this.f292578a = appInterface;
        this.f292579b = context;
        this.f292580c = baseAdapter;
        this.f292581d = i3;
    }

    public abstract View a(int i3, h hVar, View view, ViewGroup viewGroup, boolean z16, boolean z17, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, boolean z18, int i16);
}
