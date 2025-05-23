package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.b;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.c;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.e;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.f;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends RecyclerView.Adapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<b> f297358d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.mobileqq.troop.homework.xmediaeditor.ui.b f297359e;

    /* renamed from: f, reason: collision with root package name */
    int f297360f;

    public a(SparseArray<com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sparseArray);
            return;
        }
        this.f297358d = new ArrayList<>();
        this.f297360f = 0;
        com.tencent.mobileqq.troop.homework.xmediaeditor.ui.b bVar = new com.tencent.mobileqq.troop.homework.xmediaeditor.ui.b();
        this.f297359e = bVar;
        bVar.l(sparseArray);
    }

    public void A(ArrayList<g> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) arrayList);
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.f297359e.j(arrayList.get(i3));
        }
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.f297359e.k();
        }
    }

    public void C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        ArrayList<b> arrayList = this.f297358d;
        if (arrayList != null) {
            this.f297359e.e(arrayList.get(i3));
            this.f297358d.remove(i3);
        }
    }

    public void D(JSONArray jSONArray, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) jSONArray, (Object) str);
            return;
        }
        for (int i3 = 0; i3 < this.f297358d.size(); i3++) {
            try {
                this.f297359e.e(this.f297358d.get(i3));
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        this.f297358d.clear();
        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
            b a16 = c.a(jSONArray.getJSONObject(i16), str);
            if (a16 != null) {
                q(a16);
            }
        }
        f fVar = null;
        boolean z16 = false;
        for (int size = this.f297358d.size() - 1; size >= 0; size--) {
            b bVar = this.f297358d.get(size);
            if (bVar instanceof f) {
                if (fVar == null) {
                    fVar = (f) bVar;
                }
                if (z16) {
                    int i17 = size + 1;
                    f fVar2 = (f) this.f297358d.get(i17);
                    f fVar3 = (f) bVar;
                    if (!TextUtils.isEmpty(fVar2.f297413d)) {
                        if (TextUtils.isEmpty(fVar3.f297413d)) {
                            fVar3.f297413d = fVar2.f297413d;
                        } else {
                            fVar3.f297413d += "\n" + fVar2.f297413d;
                        }
                    }
                    C(i17);
                } else {
                    z16 = true;
                }
            } else {
                z16 = false;
            }
        }
        notifyDataSetChanged();
    }

    public void E(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f297360f = i3;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f297358d.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Long) iPatchRedirector.redirect((short) 25, (Object) this, i3)).longValue();
        }
        return this.f297358d.get(i3).hashCode();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
        }
        return this.f297358d.get(i3).c();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder, i3);
        } else {
            QLog.i("xmediaEditor", 2, "Adapter onBindViewHolder, holder type:" + viewHolder.getItemViewType() + ", position:" + i3);
            b bVar = this.f297358d.get(i3);
            bVar.f297409a = i3;
            this.f297359e.b(viewHolder, bVar, this.f297360f);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        QLog.i("xmediaEditor", 2, "Adapter onCreateViewHolder, type:" + i3);
        return this.f297359e.c(viewGroup, i3);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewHolder);
            return;
        }
        QLog.i("xmediaEditor", 2, "Adapter onViewAttachedToWindow, holder type:" + viewHolder.getItemViewType());
        super.onViewAttachedToWindow(viewHolder);
        this.f297359e.g(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewHolder);
            return;
        }
        QLog.i("xmediaEditor", 2, "Adapter onViewDetachedFromWindow, holder type:" + viewHolder.getItemViewType());
        super.onViewDetachedFromWindow(viewHolder);
        this.f297359e.h(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder);
            return;
        }
        QLog.i("xmediaEditor", 2, "Adapter onViewRecycled, holder type:" + viewHolder.getItemViewType());
        super.onViewRecycled(viewHolder);
        this.f297359e.i(viewHolder);
    }

    public void p(int i3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3, (Object) bVar);
        } else if (this.f297358d != null) {
            this.f297359e.d(bVar);
            this.f297358d.add(i3, bVar);
        }
    }

    public void q(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bVar);
        } else if (this.f297358d != null) {
            this.f297359e.d(bVar);
            this.f297358d.add(bVar);
        }
    }

    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < this.f297358d.size(); i3++) {
            b bVar = this.f297358d.get(i3);
            if (bVar.c() != -1) {
                jSONArray.mo162put(bVar.a());
            }
        }
        return jSONArray.toString();
    }

    public int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.f297358d.size(); i16++) {
            i3 += this.f297358d.get(i16).b();
        }
        return i3;
    }

    public b t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (b) iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }
        ArrayList<b> arrayList = this.f297358d;
        if (arrayList != null) {
            if (i3 >= 0 && i3 < arrayList.size()) {
                return this.f297358d.get(i3);
            }
            QLog.e("XMediaEditor", 2, "getEditItemInfo index out of bound, index:" + i3 + ", mItemList.size():" + this.f297358d.size());
            return null;
        }
        return null;
    }

    public ArrayList<e> u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ArrayList) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        ArrayList<e> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.f297358d.size(); i3++) {
            Object obj = (b) this.f297358d.get(i3);
            if (obj instanceof e) {
                arrayList.add((e) obj);
            }
        }
        return arrayList;
    }

    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f297360f;
    }

    public ArrayList<g> w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ArrayList) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        ArrayList<g> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.f297358d.size(); i3++) {
            b bVar = this.f297358d.get(i3);
            if (bVar instanceof g) {
                g gVar = (g) bVar;
                if (gVar.f297417d != 3) {
                    arrayList.add(gVar);
                }
            }
        }
        return arrayList;
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        if (this.f297358d.size() <= 0 || this.f297358d.get(0).c() != -1) {
            return false;
        }
        return true;
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        for (int i3 = 0; i3 < this.f297358d.size(); i3++) {
            if (!this.f297358d.get(i3).d()) {
                return false;
            }
        }
        return true;
    }

    public void z(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3, (Object) str);
            return;
        }
        b t16 = t(i3);
        if (t16 != null) {
            t16.e(str);
            notifyItemChanged(i3);
            this.f297359e.f(t16);
        }
    }
}
