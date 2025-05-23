package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipTextViewMenuBuilder;
import com.tencent.widget.ThemeImageView;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected Context f254107d;

    /* renamed from: e, reason: collision with root package name */
    protected AppInterface f254108e;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.mobileqq.newfriend.ui.adapter.a f254109f;

    /* renamed from: h, reason: collision with root package name */
    protected SwipRightMenuBuilder f254110h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.newfriend.msg.i f254111i;

    /* renamed from: m, reason: collision with root package name */
    protected int f254112m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends SwipTextViewMenuBuilder {
        static IPatchRedirector $redirector_;

        a(int i3, int i16, int[] iArr, int i17, int[] iArr2, int[] iArr3, int[] iArr4) {
            super(i3, i16, iArr, i17, iArr2, iArr3, iArr4);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Integer.valueOf(i17), iArr2, iArr3, iArr4);
            }
        }

        @Override // com.tencent.widget.SwipRightMenuBuilder
        public void getRightMenuItemInfo(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), obj, swipRightMenuItemArr);
                return;
            }
            if (swipRightMenuItemArr != null && swipRightMenuItemArr.length > 0) {
                int f16 = d.this.f();
                if (swipRightMenuItemArr.length > 0) {
                    int i17 = f16 & 15;
                    if (i17 == 1) {
                        SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[0];
                        swipRightMenuItem.menuId = 0;
                        swipRightMenuItem.menuType = 0;
                    } else if (i17 == 2) {
                        SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem2 = swipRightMenuItemArr[0];
                        swipRightMenuItem2.menuId = 1;
                        swipRightMenuItem2.menuType = 0;
                    }
                    i16 = 1;
                }
                while (i16 < swipRightMenuItemArr.length) {
                    SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem3 = swipRightMenuItemArr[i16];
                    swipRightMenuItem3.menuId = -1;
                    swipRightMenuItem3.menuType = -1;
                    i16++;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b extends SwipRightMenuBuilder.SwipItemBaseHolder {
        static IPatchRedirector $redirector_;
        public TextView C;
        public String D;
        public ImageView E;
        public TroopLabelLayout F;
        public TextView G;
        public TextView H;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f254114d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f254115e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f254116f;

        /* renamed from: h, reason: collision with root package name */
        public TextView f254117h;

        /* renamed from: i, reason: collision with root package name */
        public Button f254118i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f254119m;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public d(Context context, AppInterface appInterface, com.tencent.mobileqq.newfriend.ui.adapter.a aVar, com.tencent.mobileqq.newfriend.msg.i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, aVar, iVar);
            return;
        }
        this.f254107d = context;
        this.f254108e = appInterface;
        this.f254109f = aVar;
        this.f254111i = iVar;
        this.f254112m = context.getResources().getDimensionPixelSize(R.dimen.f159220xq);
    }

    public static void j(View view, boolean z16) {
        if (view == null) {
            return;
        }
        int paddingBottom = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (z16) {
            view.setBackgroundResource(R.drawable.f160542jo);
        } else if (ThemeUtil.isDefaultTheme()) {
            view.setBackgroundResource(R.drawable.f160540jm);
        } else {
            view.setBackgroundResource(R.drawable.common_list_item_background);
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void m(View view, int i3) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, i3);
        } else {
            layoutParams.width = -1;
            layoutParams.height = i3;
        }
        view.setMinimumHeight(i3);
        view.setLayoutParams(layoutParams);
    }

    public void a(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (view instanceof ThemeImageView) {
            ((ThemeImageView) view).setSupportMaskView(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SwipRightMenuBuilder b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SwipRightMenuBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        return new a(1, 2, new int[]{context.getResources().getDimensionPixelSize(R.dimen.atw), context.getResources().getDimensionPixelSize(R.dimen.atx)}, -1, mb2.a.f416520c, mb2.a.f416518a, mb2.a.f416519b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View d(Context context, int i3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, Integer.valueOf(i3), bVar);
        }
        View inflate = LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
        if (this.f254109f != null) {
            return this.f254110h.createView(context, inflate, bVar, -1);
        }
        bVar.leftView = inflate;
        bVar.rightMenuItems = null;
        return inflate;
    }

    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f254107d.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public abstract View h(int i3, View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(View view) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        if (!Utils.p(SwipTextViewMenuBuilder.TAG_SWIP_ICON_MENU_ITEM, view.getTag())) {
            return;
        }
        char c16 = 0;
        if (!NetworkUtil.isNetworkAvailable(this.f254107d)) {
            Context context = this.f254107d;
            QQToast.makeText(context, context.getResources().getString(R.string.b3j), 0).show(g());
            return;
        }
        Object tag = view.getTag(-1);
        Object tag2 = view.getTag(-2);
        if ((tag instanceof Integer) && (tag2 instanceof Integer)) {
            int intValue = ((Integer) tag).intValue();
            int intValue2 = ((Integer) tag2).intValue();
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.NEW_FRIEND_ACTIVITY, 2, "SystemMsgListAdpater onClick position = " + intValue + "nMenuStrId = " + intValue2 + "v.getId() = " + view.getId());
            }
            try {
                str = this.f254107d.getResources().getString(intValue2);
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(LogTag.NEW_FRIEND_ACTIVITY, 4, e16.toString());
                }
                str = null;
            }
            Resources resources = this.f254107d.getResources();
            if (f() == 2) {
                c16 = 1;
            }
            if (Utils.p(str, resources.getString(mb2.a.f416518a[c16]))) {
                e();
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(LogTag.NEW_FRIEND_ACTIVITY, 4, "SystemMsgListAdpater onClick tag is not int");
        }
    }

    public void k(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, i3);
            return;
        }
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.ibi);
        if (findViewById != view && findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -1;
                layoutParams.height = i3;
                findViewById.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        m(view, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(Context context, View view, int i3, Object obj, SwipRightMenuBuilder.SwipItemBaseHolder swipItemBaseHolder, View.OnClickListener onClickListener) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, view, Integer.valueOf(i3), obj, swipItemBaseHolder, onClickListener);
            return;
        }
        SwipRightMenuBuilder swipRightMenuBuilder = this.f254110h;
        if (swipRightMenuBuilder != null) {
            i16 = swipRightMenuBuilder.updateRightMenuView(context, view, i3, obj, swipItemBaseHolder, onClickListener);
        } else {
            i16 = 0;
        }
        com.tencent.mobileqq.newfriend.ui.adapter.a aVar = this.f254109f;
        if (aVar != null && (i17 = aVar.f254100d) != -1) {
            if (i3 != i17) {
                view.scrollTo(0, 0);
            } else {
                view.scrollTo(i16, 0);
            }
        }
    }
}
