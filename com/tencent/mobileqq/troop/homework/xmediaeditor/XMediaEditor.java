package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.f;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.g;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes19.dex */
public class XMediaEditor extends RecyclerView {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private Bundle E;
    private com.tencent.mobileqq.troop.homework.xmediaeditor.ui.c F;
    private int G;
    private int H;
    private f I;
    a.InterfaceC8754a J;
    private View K;

    /* renamed from: d, reason: collision with root package name */
    private boolean f297346d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f297347e;

    /* renamed from: f, reason: collision with root package name */
    private String f297348f;

    /* renamed from: h, reason: collision with root package name */
    com.tencent.mobileqq.troop.homework.xmediaeditor.a f297349h;

    /* renamed from: i, reason: collision with root package name */
    private d f297350i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f297351m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements a.InterfaceC8754a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) XMediaEditor.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a.InterfaceC8754a
        public void a(RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewHolder);
                return;
            }
            TextItem.e eVar = (TextItem.e) viewHolder;
            if (XMediaEditor.this.I != null) {
                XMediaEditor.this.I.f297415f = false;
            }
            XMediaEditor.this.I = (f) eVar.f297481d;
            if (XMediaEditor.this.f297350i != null) {
                XMediaEditor.this.f297350i.onFocusChanged(eVar.f297476f, true);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a.InterfaceC8754a
        public void b(RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder);
            } else {
                XMediaEditor.this.n(((b.a) viewHolder).f297481d.f297409a);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a.InterfaceC8754a
        public void c(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                if (i3 == i16) {
                    return;
                }
                XMediaEditor.e(XMediaEditor.this);
                XMediaEditor.this.C += i16 - i3;
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a.InterfaceC8754a
        public void d(RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewHolder);
                return;
            }
            TextItem.e eVar = (TextItem.e) viewHolder;
            if (XMediaEditor.this.f297350i != null) {
                XMediaEditor.this.f297350i.onFocusChanged(eVar.f297476f, false);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a.InterfaceC8754a
        public void e(RecyclerView.ViewHolder viewHolder, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, viewHolder, Boolean.valueOf(z16));
            } else if (XMediaEditor.this.f297351m != XMediaEditor.this.f297349h.y()) {
                XMediaEditor.this.f297351m = !r6.f297351m;
                XMediaEditor.c(XMediaEditor.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a.InterfaceC8754a
        public void f(RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder);
                return;
            }
            int i3 = ((b.a) viewHolder).f297481d.f297409a;
            if (i3 == 0) {
                return;
            }
            int i16 = i3 - 1;
            com.tencent.mobileqq.troop.homework.xmediaeditor.model.b t16 = XMediaEditor.this.f297349h.t(i16);
            if (t16 != null && t16.c() == -1) {
                return;
            }
            XMediaEditor.this.n(i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface d {
        void onFocusChanged(View view, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class e extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f297357d;

        public e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.f297357d = i3;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
            } else if (recyclerView.getChildAdapterPosition(view) != 0) {
                rect.top = this.f297357d;
            }
        }
    }

    public XMediaEditor(Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    static /* bridge */ /* synthetic */ b c(XMediaEditor xMediaEditor) {
        xMediaEditor.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ c e(XMediaEditor xMediaEditor) {
        xMediaEditor.getClass();
        return null;
    }

    private <T extends View> T o(Class<T> cls, View view) {
        ViewGroup viewGroup;
        int childCount;
        if (view == null) {
            return null;
        }
        if (cls.isInstance(view)) {
            return cls.cast(view);
        }
        if (!(view instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) view).getChildCount()) <= 0) {
            return null;
        }
        return (T) o(cls, viewGroup.getChildAt(childCount - 1));
    }

    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this)).booleanValue();
        }
        return this.f297349h.x();
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        f fVar = this.I;
        fVar.f297415f = false;
        TextItem.e eVar = (TextItem.e) findViewHolderForAdapterPosition(fVar.f297409a);
        if (eVar != null) {
            eVar.f297476f.setFocusable(false);
            eVar.f297476f.setFocusableInTouchMode(false);
            ThreadManager.getUIHandler().post(new Runnable(eVar) { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TextItem.e f297354d;

                {
                    this.f297354d = eVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) XMediaEditor.this, (Object) eVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f297354d.f297476f.clearFocus();
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    ((InputMethodManager) XMediaEditor.this.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(AnonymousClass2.this.f297354d.f297476f.getWindowToken(), 0);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void C(com.tencent.mobileqq.troop.homework.xmediaeditor.model.b bVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
            return;
        }
        if (bVar == null) {
            QQToast.makeText(getContext(), "\u63d2\u5165\u7684EditItemInfoBase\u4e3a\u7a7a", 0).show();
            return;
        }
        String str2 = "";
        if (this.f297349h.getItemCount() == 0) {
            if (bVar instanceof f) {
                this.f297349h.q(bVar);
                this.f297349h.notifyDataSetChanged();
                f fVar = (f) bVar;
                this.I = fVar;
                fVar.f297409a = 0;
                fVar.f297415f = true;
                return;
            }
            f fVar2 = new f("");
            f fVar3 = new f("");
            this.f297349h.q(fVar2);
            this.f297349h.q(bVar);
            this.f297349h.q(fVar3);
            this.I = fVar3;
            fVar3.f297415f = true;
            fVar3.f297409a = 2;
            this.f297349h.notifyDataSetChanged();
            this.J.e(null, false);
            smoothScrollToPosition(this.I.f297409a);
            return;
        }
        if (this.I == null) {
            com.tencent.mobileqq.troop.homework.xmediaeditor.a aVar = this.f297349h;
            com.tencent.mobileqq.troop.homework.xmediaeditor.model.b t16 = aVar.t(aVar.getItemCount() - 1);
            if (t16 instanceof f) {
                this.I = (f) t16;
            } else {
                f fVar4 = new f("");
                this.I = fVar4;
                fVar4.f297409a = this.f297349h.getItemCount();
                this.f297349h.q(fVar4);
            }
            this.I.f297415f = true;
        }
        f fVar5 = this.I;
        int i3 = fVar5.f297409a;
        if (fVar5.f297414e < 0) {
            fVar5.f297414e = 0;
        }
        int i16 = fVar5.f297414e;
        TextItem.e eVar = (TextItem.e) findViewHolderForAdapterPosition(i3);
        if (eVar != null) {
            i16 = eVar.f297476f.getSelectionStart();
        }
        if (i16 == 0) {
            if (this.I.f297413d.length() == 0) {
                str = "";
            } else {
                str = this.I.f297413d;
            }
        } else {
            String substring = this.I.f297413d.substring(0, i16);
            if (this.I.f297413d.length() != i16) {
                str2 = this.I.f297413d.substring(i16);
            }
            str = str2;
            str2 = substring;
        }
        if (bVar instanceof f) {
            f fVar6 = (f) bVar;
            this.I.g(str2 + fVar6.f297413d + str);
            f fVar7 = this.I;
            fVar7.f297414e = fVar7.f297414e + fVar6.f297413d.length();
        } else {
            com.tencent.mobileqq.troop.homework.xmediaeditor.model.b t17 = this.f297349h.t(i3);
            if (t17 instanceof f) {
                ((f) t17).g(str2);
            } else if (QLog.isColorLevel()) {
                QLog.d("XMediaEditor", 2, "insert item \u7c7b\u578b\u4e0d\u5bf9 insertPosition" + i3);
            }
            f fVar8 = new f(str);
            this.I.f297415f = false;
            fVar8.f297415f = true;
            fVar8.f297414e = 0;
            this.I = fVar8;
            int i17 = i3 + 1;
            this.f297349h.p(i17, fVar8);
            this.f297349h.p(i17, bVar);
            this.I.f297409a = i3 + 2;
            this.f297349h.notifyDataSetChanged();
        }
        smoothScrollToPosition(this.I.f297409a);
        this.J.e(null, false);
    }

    public void D(List<com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            C(list.get(i3));
        }
    }

    public void E(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
        } else {
            this.f297349h.z(i3, str);
            this.J.e(null, false);
        }
    }

    public void F(ArrayList<g> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) arrayList);
        } else {
            this.f297349h.A(arrayList);
        }
    }

    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        f fVar = this.I;
        fVar.f297415f = true;
        TextItem.e eVar = (TextItem.e) findViewHolderForAdapterPosition(fVar.f297409a);
        if (eVar != null) {
            eVar.f297476f.setFocusable(true);
            eVar.f297476f.setFocusableInTouchMode(true);
            ThreadManager.getUIHandler().post(new Runnable(eVar) { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TextItem.e f297352d;

                {
                    this.f297352d = eVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) XMediaEditor.this, (Object) eVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    this.f297352d.f297476f.requestFocus();
                    this.f297352d.f297476f.findFocus();
                    EditText editText = this.f297352d.f297476f;
                    if (XMediaEditor.this.I.f297414e >= 0) {
                        i3 = XMediaEditor.this.I.f297414e;
                    } else {
                        i3 = 0;
                    }
                    editText.setSelection(i3);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                ((InputMethodManager) XMediaEditor.this.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(AnonymousClass1.this.f297352d.f297476f, 2);
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, i3)).booleanValue();
        }
        if (this.f297346d && super.canScrollVertically(i3)) {
            return true;
        }
        return false;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            setDefaultContent();
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        this.K = null;
        this.F.p(null);
        if (this.f297349h.x()) {
            this.f297349h.C(0);
            this.f297349h.notifyDataSetChanged();
        }
    }

    public void n(int i3) {
        com.tencent.mobileqq.troop.homework.xmediaeditor.model.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        int i16 = 0;
        if (i3 == 0) {
            this.f297349h.C(0);
            this.f297349h.notifyDataSetChanged();
            this.J.e(null, false);
            return;
        }
        int i17 = i3 - 1;
        com.tencent.mobileqq.troop.homework.xmediaeditor.model.b t16 = this.f297349h.t(i17);
        int i18 = i3 + 1;
        if (i18 < this.f297349h.getItemCount()) {
            bVar = this.f297349h.t(i18);
        } else {
            bVar = null;
        }
        if (bVar == null) {
            if (t16 instanceof f) {
                f fVar = this.I;
                if (fVar != null) {
                    fVar.f297415f = false;
                }
                f fVar2 = (f) t16;
                this.I = fVar2;
                fVar2.f297415f = true;
            }
            this.f297349h.C(i3);
            this.f297349h.notifyDataSetChanged();
            this.J.e(null, false);
            return;
        }
        if ((bVar instanceof f) && (t16 instanceof f)) {
            f fVar3 = (f) bVar;
            f fVar4 = (f) t16;
            fVar4.f297414e = fVar4.f297413d.length();
            TextItem.e eVar = (TextItem.e) findViewHolderForAdapterPosition(fVar4.f297409a);
            if (eVar != null) {
                eVar.f297476f.setSelection(fVar4.f297414e);
            }
            if (!TextUtils.isEmpty(fVar3.f297413d)) {
                if (TextUtils.isEmpty(fVar4.f297413d)) {
                    fVar4.g(fVar3.f297413d);
                } else {
                    fVar4.g(fVar4.f297413d + fVar3.f297413d);
                }
            }
            f fVar5 = this.I;
            if (fVar5 != null) {
                fVar5.f297415f = false;
            }
            this.I = fVar4;
            fVar4.f297415f = true;
            this.f297349h.C(i18);
            this.f297349h.C(i3);
            this.f297349h.notifyDataSetChanged();
            this.J.e(null, false);
            if (i17 >= 0) {
                i16 = i17;
            }
            smoothScrollToPosition(i16);
            return;
        }
        this.f297349h.C(i3);
        this.f297349h.notifyDataSetChanged();
        this.J.e(null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDetachedFromWindow();
            this.f297349h.B();
        }
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.f297347e) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int i17 = this.G;
        if (i17 != Integer.MAX_VALUE) {
            i16 = View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i16);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        EditText editText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (x() == 0 && motionEvent.getAction() == 1 && (editText = (EditText) o(EditText.class, this)) != null) {
            editText.getLocationOnScreen(new int[2]);
            if (r3[1] <= motionEvent.getRawY()) {
                if (QLog.isColorLevel()) {
                    QLog.d("XMediaEditor", 2, "Oops! found et");
                }
                if (!editText.isFocused()) {
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.requestFocus();
                }
                InputMethodUtil.show(editText);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return this.C;
    }

    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f297349h.r();
    }

    public String r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this, (Object) str);
        }
        return this.E.getString(str);
    }

    public String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f297348f;
    }

    public void setChildClickable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.f297347e = z16;
        }
    }

    public void setCommitStateChangeListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) bVar);
        }
    }

    public void setContentLengthChangeListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) cVar);
        }
    }

    public void setData(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) str2);
            return;
        }
        try {
            this.f297349h.D(new JSONArray(str), str2);
            this.J.e(null, false);
            int s16 = this.f297349h.s();
            this.J.c(this.C, s16);
            this.C = s16;
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void setDataByEdit(JSONArray jSONArray, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) jSONArray, (Object) str);
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                com.tencent.mobileqq.troop.homework.xmediaeditor.model.b a16 = com.tencent.mobileqq.troop.homework.xmediaeditor.model.c.a(jSONArray.getJSONObject(i3), str);
                if (a16 != null) {
                    if (a16 instanceof g) {
                        ((g) a16).f297417d = 3;
                        if (a16 instanceof ImageInfo) {
                            ((ImageInfo) a16).f297370o = 100;
                        }
                    }
                    if (a16 instanceof f) {
                        this.I.g(((f) a16).f297413d);
                        this.I.f297414e = ((f) a16).f297413d.length();
                        this.I.f297415f = false;
                        this.f297349h.notifyDataSetChanged();
                    } else {
                        C(a16);
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        int s16 = this.f297349h.s();
        int i16 = 0;
        while (true) {
            if (i16 >= s16) {
                break;
            }
            com.tencent.mobileqq.troop.homework.xmediaeditor.model.b t16 = this.f297349h.t(i16);
            if (t16 instanceof f) {
                f fVar = (f) t16;
                this.I = fVar;
                fVar.f297415f = true;
                break;
            }
            i16++;
        }
        this.f297349h.notifyDataSetChanged();
        smoothScrollToPosition(0);
    }

    public void setDefaultContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        setData("[" + new f("").toString() + "]", "");
        this.I = (f) this.f297349h.t(0);
    }

    public void setExtraValue(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) str, (Object) str2);
        } else {
            this.E.putString(str, str2);
        }
    }

    public void setFocusChangeListener(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) dVar);
        } else {
            this.f297350i = dVar;
        }
    }

    public void setHeaderView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) view);
            return;
        }
        if (view == null) {
            m();
            return;
        }
        this.K = view;
        this.F.p(view);
        if (this.f297349h.x()) {
            this.f297349h.notifyDataSetChanged();
        } else {
            this.f297349h.p(0, new com.tencent.mobileqq.troop.homework.xmediaeditor.model.d());
            this.f297349h.notifyDataSetChanged();
        }
    }

    public void setHint(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.f297348f = str;
        }
    }

    public void setLeftRightPadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.H = i3;
        }
    }

    public void setMaxHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, i3);
        } else {
            this.G = i3;
        }
    }

    public void setScrollable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
        } else {
            this.f297346d = z16;
        }
    }

    public void setShowType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f297349h.E(i3);
        }
    }

    public void setSizeLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3);
        } else {
            this.D = i3;
        }
    }

    public ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.e> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ArrayList) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.f297349h.u();
    }

    public int u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this, i3)).intValue();
        }
        int i16 = 0;
        for (int i17 = 0; i17 < this.f297349h.getItemCount(); i17++) {
            if (this.f297349h.t(i17) != null && this.f297349h.t(i17).c() == i3) {
                i16++;
            }
        }
        return i16;
    }

    public ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (ArrayList) iPatchRedirector.redirect((short) 27, (Object) this, i3);
        }
        ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> arrayList = new ArrayList<>();
        for (int i16 = 0; i16 < this.f297349h.getItemCount(); i16++) {
            if (this.f297349h.t(i16) != null && this.f297349h.t(i16).c() == i3) {
                arrayList.add(this.f297349h.t(i16));
            }
        }
        return arrayList;
    }

    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.H;
    }

    public int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Integer) iPatchRedirector.redirect((short) 42, (Object) this)).intValue();
        }
        return this.f297349h.v();
    }

    public int y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return this.D;
    }

    public ArrayList<g> z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ArrayList) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.f297349h.w();
    }

    public XMediaEditor(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public XMediaEditor(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f297346d = true;
        this.f297347e = true;
        this.f297351m = false;
        this.C = 0;
        this.D = 0;
        this.E = new Bundle();
        this.G = Integer.MAX_VALUE;
        this.J = new a();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        addItemDecoration(new e(26));
        setLayoutManager(linearLayoutManager);
        SparseArray sparseArray = new SparseArray();
        com.tencent.mobileqq.troop.homework.xmediaeditor.ui.c cVar = new com.tencent.mobileqq.troop.homework.xmediaeditor.ui.c(this, context);
        this.F = cVar;
        cVar.k(this.J);
        sparseArray.put(-1, this.F);
        sparseArray.put(0, new TextItem(this, context).k(this.J));
        sparseArray.put(3, new AudioItem(this, context).k(this.J));
        sparseArray.put(1, new ImageItem(this).k(this.J));
        sparseArray.put(2, new com.tencent.mobileqq.troop.homework.xmediaeditor.ui.e(this).k(this.J));
        com.tencent.mobileqq.troop.homework.xmediaeditor.a aVar = new com.tencent.mobileqq.troop.homework.xmediaeditor.a(sparseArray);
        this.f297349h = aVar;
        setAdapter(aVar);
        setDefaultContent();
    }
}
