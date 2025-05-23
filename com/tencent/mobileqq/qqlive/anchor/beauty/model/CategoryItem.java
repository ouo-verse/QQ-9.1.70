package com.tencent.mobileqq.qqlive.anchor.beauty.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class CategoryItem {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f270407a;

    /* renamed from: b, reason: collision with root package name */
    @CategoryType
    public int f270408b;

    /* renamed from: c, reason: collision with root package name */
    public int f270409c;

    /* renamed from: d, reason: collision with root package name */
    public String f270410d;

    /* renamed from: e, reason: collision with root package name */
    public List<a> f270411e;

    /* renamed from: f, reason: collision with root package name */
    public DataModel.BeautyItem f270412f;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public @interface CategoryType {
        public static final int BEAUTY = 1;
        public static final int BODY = 4;
        public static final int DEFAULT = 0;
        public static final int FILTER = 3;
        public static final int MAKEUP = 2;
        public static final int SECOND_TYPE_THIN_FACE = 11;
    }

    public CategoryItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f270407a = 0;
        this.f270409c = 0;
        this.f270410d = "";
        this.f270411e = new ArrayList();
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        List<a> list = this.f270411e;
        if (list != null) {
            list.add(aVar);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<a> it = this.f270411e.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @CategoryType
        public int f270413a;

        /* renamed from: b, reason: collision with root package name */
        public DataModel.BeautyItem f270414b;

        /* renamed from: c, reason: collision with root package name */
        public DataModel.MakeUpItem f270415c;

        /* renamed from: d, reason: collision with root package name */
        public DataModel.FilterItem f270416d;

        /* renamed from: e, reason: collision with root package name */
        public DataModel.BeautySecondaryItem f270417e;

        public a(int i3, DataModel.MakeUpItem makeUpItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) makeUpItem);
            } else {
                this.f270413a = i3;
                this.f270415c = makeUpItem;
            }
        }

        private DataModel.a b() {
            int i3 = this.f270413a;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 11) {
                            return null;
                        }
                        return this.f270417e;
                    }
                    return this.f270416d;
                }
                return this.f270415c;
            }
            return this.f270414b;
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            return b().getCurValue();
        }

        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            return b().getDefValue();
        }

        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return b().getIconRes();
        }

        public String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return b().getOnlineUrl();
        }

        public int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
            }
            return b().getIndex();
        }

        public int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return b().getMax();
        }

        public int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            return b().getMin();
        }

        public String i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return b().getName();
        }

        public boolean j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
            }
            return b().getSelect();
        }

        public void k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this);
            } else {
                b().loadFromLocal();
            }
        }

        public void l(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                b().setCurValue(i3);
            }
        }

        public void m(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                b().setSelect(z16);
            }
        }

        public a(int i3, DataModel.FilterItem filterItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) filterItem);
            } else {
                this.f270413a = i3;
                this.f270416d = filterItem;
            }
        }

        public a(int i3, DataModel.BeautyItem beautyItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) beautyItem);
            } else {
                this.f270413a = i3;
                this.f270414b = beautyItem;
            }
        }

        public a(int i3, DataModel.BeautySecondaryItem beautySecondaryItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) beautySecondaryItem);
            } else {
                this.f270413a = i3;
                this.f270417e = beautySecondaryItem;
            }
        }
    }

    public CategoryItem(int i3, @CategoryType int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        this.f270407a = 0;
        this.f270409c = 0;
        this.f270410d = "";
        this.f270411e = new ArrayList();
        this.f270407a = i3;
        this.f270408b = i16;
        this.f270409c = i17;
        this.f270410d = str;
    }

    public CategoryItem(int i3, @CategoryType int i16, int i17, String str, DataModel.BeautyItem beautyItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, beautyItem);
            return;
        }
        this.f270407a = 0;
        this.f270409c = 0;
        this.f270410d = "";
        this.f270411e = new ArrayList();
        this.f270407a = i3;
        this.f270408b = i16;
        this.f270409c = i17;
        this.f270410d = str;
        this.f270412f = beautyItem;
    }
}
