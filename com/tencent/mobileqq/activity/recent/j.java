package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class j {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f185633c;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f185634d;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f185635e;

    /* renamed from: a, reason: collision with root package name */
    protected RecentAdapter f185636a;

    /* renamed from: b, reason: collision with root package name */
    protected SwipRightMenuBuilder f185637b;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends SwipRightMenuBuilder.SwipItemBaseHolder {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b extends SwipTextViewMenuBuilder {
        static IPatchRedirector $redirector_;

        public b(int i3, int i16, int[] iArr, int i17, int[] iArr2, int[] iArr3, int[] iArr4) {
            super(i3, i16, iArr, i17, iArr2, iArr3, iArr4);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Integer.valueOf(i17), iArr2, iArr3, iArr4);
            }
        }

        private int a(RecentBaseData recentBaseData, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr, int i3) {
            if (RecentPubAccHelper.e(recentBaseData.getRecentUserUin()) && m.a().e() && !m.a().f(recentBaseData.getRecentUserUin())) {
                SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[i3];
                swipRightMenuItem.menuId = 6;
                swipRightMenuItem.menuType = 1;
                i3++;
            }
            if (i3 < swipRightMenuItemArr.length) {
                SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem2 = swipRightMenuItemArr[i3];
                swipRightMenuItem2.menuId = 0;
                swipRightMenuItem2.menuType = 0;
                return i3 + 1;
            }
            return i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int b(Object obj, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr, int i3, int i16) {
            int i17;
            int i18 = i3 & 240;
            if (i18 == 32) {
                SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[i16];
                swipRightMenuItem.menuId = 2;
                swipRightMenuItem.menuType = 1;
            } else {
                if (i18 == 16) {
                    SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem2 = swipRightMenuItemArr[i16];
                    swipRightMenuItem2.menuId = 3;
                    swipRightMenuItem2.menuType = 0;
                }
                if (i16 < swipRightMenuItemArr.length && (obj instanceof RecentBaseData) && ((RecentBaseData) obj).isUnreadMsgNumInTabNum()) {
                    i17 = 983040 & i3;
                    if (i17 != 65536) {
                        SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem3 = swipRightMenuItemArr[i16];
                        swipRightMenuItem3.menuId = 4;
                        swipRightMenuItem3.menuType = 1;
                    } else if (i17 == 131072) {
                        SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem4 = swipRightMenuItemArr[i16];
                        swipRightMenuItem4.menuId = 5;
                        swipRightMenuItem4.menuType = 1;
                    }
                    i16++;
                }
                if (i16 < swipRightMenuItemArr.length && (251658240 & i3) == 16777216) {
                    SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem5 = swipRightMenuItemArr[i16];
                    swipRightMenuItem5.menuId = 9;
                    swipRightMenuItem5.menuType = 1;
                    i16++;
                }
                if (i16 < swipRightMenuItemArr.length && (i3 & 15) == 1) {
                    SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem6 = swipRightMenuItemArr[i16];
                    swipRightMenuItem6.menuId = 0;
                    swipRightMenuItem6.menuType = 0;
                    i16++;
                }
                if (i16 >= swipRightMenuItemArr.length && (3145728 & i3) == 2097152) {
                    SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem7 = swipRightMenuItemArr[i16];
                    swipRightMenuItem7.menuId = 6;
                    swipRightMenuItem7.menuType = 1;
                    return i16 + 1;
                }
            }
            i16++;
            if (i16 < swipRightMenuItemArr.length) {
                i17 = 983040 & i3;
                if (i17 != 65536) {
                }
                i16++;
            }
            if (i16 < swipRightMenuItemArr.length) {
                SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem52 = swipRightMenuItemArr[i16];
                swipRightMenuItem52.menuId = 9;
                swipRightMenuItem52.menuType = 1;
                i16++;
            }
            if (i16 < swipRightMenuItemArr.length) {
                SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem62 = swipRightMenuItemArr[i16];
                swipRightMenuItem62.menuId = 0;
                swipRightMenuItem62.menuType = 0;
                i16++;
            }
            return i16 >= swipRightMenuItemArr.length ? i16 : i16;
        }

        private int c(RecentBaseData recentBaseData, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr, int i3, int i16) {
            int i17;
            int i18;
            if (RecentPubAccHelper.f()) {
                int i19 = i3 & 240;
                if (i19 == 32) {
                    SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[i16];
                    swipRightMenuItem.menuId = 2;
                    swipRightMenuItem.menuType = 1;
                } else if (i19 == 16) {
                    SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem2 = swipRightMenuItemArr[i16];
                    swipRightMenuItem2.menuId = 3;
                    swipRightMenuItem2.menuType = 0;
                }
                i16++;
            }
            if (i16 < swipRightMenuItemArr.length && RecentPubAccHelper.e(recentBaseData.getRecentUserUin()) && m.a().e() && !m.a().f(recentBaseData.getRecentUserUin())) {
                SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem3 = swipRightMenuItemArr[i16];
                if (RecentPubAccHelper.f()) {
                    i18 = 11;
                } else {
                    i18 = 6;
                }
                swipRightMenuItem3.menuId = i18;
                swipRightMenuItemArr[i16].menuType = 1;
                i16++;
            }
            if (i16 < swipRightMenuItemArr.length) {
                SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem4 = swipRightMenuItemArr[i16];
                if (RecentPubAccHelper.f()) {
                    i17 = 10;
                } else {
                    i17 = 0;
                }
                swipRightMenuItem4.menuId = i17;
                swipRightMenuItemArr[i16].menuType = 0;
                return i16 + 1;
            }
            return i16;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x005d A[LOOP:0: B:19:0x005a->B:21:0x005d, LOOP_END] */
        @Override // com.tencent.widget.SwipRightMenuBuilder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void getRightMenuItemInfo(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr) {
            int i16;
            int b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), obj, swipRightMenuItemArr);
                return;
            }
            if (swipRightMenuItemArr != null && swipRightMenuItemArr.length > 0) {
                boolean z16 = obj instanceof RecentBaseData;
                if (z16) {
                    i16 = ((RecentBaseData) obj).mMenuFlag;
                } else {
                    i16 = 0;
                }
                if (z16) {
                    RecentBaseData recentBaseData = (RecentBaseData) obj;
                    if (recentBaseData.getRecentUserType() == 7220) {
                        b16 = a(recentBaseData, swipRightMenuItemArr, 0);
                        while (b16 < swipRightMenuItemArr.length) {
                            SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[b16];
                            swipRightMenuItem.menuId = -1;
                            swipRightMenuItem.menuType = -1;
                            b16++;
                        }
                    }
                }
                if (z16) {
                    RecentBaseData recentBaseData2 = (RecentBaseData) obj;
                    if (recentBaseData2.getRecentUserType() == 1008) {
                        b16 = c(recentBaseData2, swipRightMenuItemArr, i16, 0);
                        while (b16 < swipRightMenuItemArr.length) {
                        }
                    }
                }
                b16 = b(obj, swipRightMenuItemArr, i16, 0);
                while (b16 < swipRightMenuItemArr.length) {
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69157);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        f185633c = new int[]{R.string.f170822ak3, R.string.aeb, R.string.adi, R.string.adm, R.string.adj, R.string.adk, R.string.cdq, R.string.bnr, R.string.bnq, R.string.vzb, R.string.f170822ak3, R.string.zom, R.string.zol, R.string.zol};
        f185634d = new int[]{R.drawable.cja, R.drawable.cj9, R.drawable.mrz, R.drawable.mrz, R.drawable.cjb, R.drawable.cjb, R.drawable.cj9, R.drawable.mrz, R.drawable.mrz, R.drawable.cjb, R.drawable.cja, R.drawable.f160581ms1, R.drawable.cja, R.drawable.f160581ms1};
        f185635e = new int[]{R.id.epz, R.id.eql, R.id.epu, R.id.eqe, R.id.eqa, R.id.eqb, R.id.eqo, R.id.eqk, R.id.eqj, R.id.gsg, R.id.z4a, R.id.z4b, R.id.z3n, R.id.z3n};
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(View view, RecentBaseData recentBaseData, Context context, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, recentBaseData, context, drawable);
        }
    }

    public SwipRightMenuBuilder b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SwipRightMenuBuilder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
        }
        return new b(d(), 2, new int[]{context.getResources().getDimensionPixelSize(R.dimen.dbt), context.getResources().getDimensionPixelSize(R.dimen.atx)}, -1, f185635e, f185633c, f185634d);
    }

    public final View c(Context context, int i3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, this, context, Integer.valueOf(i3), aVar);
        }
        View inflate = LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
        RecentAdapter recentAdapter = this.f185636a;
        if (recentAdapter != null && recentAdapter.n()) {
            if (this.f185637b == null) {
                this.f185637b = b(context);
            }
            return this.f185637b.createView(context, inflate, aVar, -1);
        }
        aVar.leftView = inflate;
        aVar.rightMenuItems = null;
        return inflate;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 1;
    }

    public List<String> e(RecentBaseData recentBaseData, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) recentBaseData, (Object) context);
        }
        return null;
    }

    public abstract View f(int i3, Object obj, i iVar, View view, ViewGroup viewGroup, Context context, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, DragFrameLayout.b bVar);

    public void g(RecentAdapter recentAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) recentAdapter);
        } else {
            this.f185636a = recentAdapter;
        }
    }

    public void h(Context context, View view, int i3, Object obj, a aVar, View.OnClickListener onClickListener) {
        int i16;
        Integer valueOf;
        RecentAdapter recentAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, view, Integer.valueOf(i3), obj, aVar, onClickListener);
            return;
        }
        SwipRightMenuBuilder swipRightMenuBuilder = this.f185637b;
        if (swipRightMenuBuilder != null) {
            SimpleModeHelper.m(swipRightMenuBuilder);
            i16 = this.f185637b.updateRightMenuView(context, view, i3, obj, aVar, onClickListener);
        } else {
            i16 = 0;
        }
        int scrollX = view.getScrollX();
        if (i3 >= 0 && (recentAdapter = this.f185636a) != null && recentAdapter.J == i3) {
            view.scrollTo(i16, 0);
        } else if (scrollX != 0) {
            view.scrollTo(0, 0);
        }
        if (scrollX != 0 && QLog.isDevelopLevel()) {
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = Integer.valueOf(scrollX);
            RecentAdapter recentAdapter2 = this.f185636a;
            if (recentAdapter2 == null) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(recentAdapter2.J);
            }
            objArr[2] = valueOf;
            com.tencent.mobileqq.nearby.l.b("updateItemMenuView", objArr);
        }
    }
}
