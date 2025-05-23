package com.tencent.mobileqq.troop.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private SparseArray<View> f293793d;

    /* renamed from: e, reason: collision with root package name */
    private View f293794e;

    /* renamed from: f, reason: collision with root package name */
    private Context f293795f;

    public c(Context context, View view) {
        super(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) view);
            return;
        }
        this.f293795f = context;
        this.f293794e = view;
        this.f293793d = new SparseArray<>();
    }

    public static c b(Context context, View view) {
        return new c(context, view);
    }

    public static c c(Context context, ViewGroup viewGroup, int i3) {
        return new c(context, LayoutInflater.from(context).inflate(i3, viewGroup, false));
    }

    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f293794e;
    }
}
