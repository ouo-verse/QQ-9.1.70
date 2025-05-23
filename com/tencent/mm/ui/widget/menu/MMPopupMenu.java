package com.tencent.mm.ui.widget.menu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.luggage.wxa.lo.m;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.mo.g;
import com.tencent.luggage.wxa.mo.h;
import com.tencent.luggage.wxa.mo.i;
import com.tencent.luggage.wxa.mo.o;
import com.tencent.luggage.wxa.mo.r;
import com.tencent.luggage.wxa.mo.s;
import com.tencent.luggage.wxa.mo.u;
import com.tencent.luggage.wxa.mo.x;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.menu.SubMenuLogic;
import com.tencent.mobileqq.R;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public class MMPopupMenu implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, View.OnKeyListener {

    /* renamed from: e0, reason: collision with root package name */
    public static int f153437e0 = 0;

    /* renamed from: f0, reason: collision with root package name */
    public static int f153438f0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    public static boolean f153439g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    public static int f153440h0 = 5;
    public View C;
    public View.OnCreateContextMenuListener D;
    public u E;
    public h F;
    public View G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public String O;
    public boolean P;
    public PopupWindow.OnDismissListener Q;
    public OnPopupShowListener R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public int W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public Context f153441a;

    /* renamed from: a0, reason: collision with root package name */
    public long f153442a0;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f153443b;

    /* renamed from: b0, reason: collision with root package name */
    public ICreateMenuViewListener f153444b0;

    /* renamed from: c, reason: collision with root package name */
    public View f153445c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f153446c0;

    /* renamed from: d, reason: collision with root package name */
    public SubmenuAdapter f153447d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f153448d0;

    /* renamed from: e, reason: collision with root package name */
    public g f153449e;

    /* renamed from: f, reason: collision with root package name */
    public x f153450f;

    /* renamed from: g, reason: collision with root package name */
    public x f153451g;

    /* renamed from: h, reason: collision with root package name */
    public x f153452h;

    /* renamed from: i, reason: collision with root package name */
    public x f153453i;

    /* renamed from: j, reason: collision with root package name */
    public int f153454j;

    /* renamed from: k, reason: collision with root package name */
    public int f153455k;

    /* renamed from: l, reason: collision with root package name */
    public DisplayMetrics f153456l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f153457m;

    /* loaded from: classes9.dex */
    public interface ICreateMenuViewListener {
        View create(Context context, MenuItem menuItem);
    }

    /* loaded from: classes9.dex */
    public interface OnPopupShowListener {
        void onShow();
    }

    /* loaded from: classes9.dex */
    public class SubmenuAdapter extends BaseAdapter {

        /* loaded from: classes9.dex */
        public class ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public WeImageView f153482a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f153483b;

            ViewHolder() {
            }
        }

        SubmenuAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return MMPopupMenu.this.F.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            TextView textView = null;
            byte b16 = 0;
            if (MMPopupMenu.this.L) {
                if (view == null) {
                    view = MMPopupMenu.this.f153443b.inflate(R.layout.frd, viewGroup, false);
                    viewHolder = new ViewHolder();
                    viewHolder.f153482a = (WeImageView) view.findViewById(R.id.icon);
                    viewHolder.f153483b = (TextView) view.findViewById(R.id.title);
                    view.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) view.getTag();
                }
                WeImageView weImageView = viewHolder.f153482a;
                if (weImageView != null) {
                    weImageView.setImageDrawable(MMPopupMenu.this.F.getItemList().get(i3).getIcon());
                }
                TextView textView2 = viewHolder.f153483b;
                if (textView2 != null) {
                    textView2.setText(MMPopupMenu.this.F.getItemList().get(i3).getTitle());
                }
                return view;
            }
            if (view == null) {
                textView = (TextView) MMPopupMenu.this.f153443b.inflate(R.layout.frg, viewGroup, false);
            } else if (view instanceof TextView) {
                textView = (TextView) view;
            }
            String item = getItem(i3);
            if (textView != null) {
                textView.setTag(item);
                textView.setText(item);
                textView.setBackgroundResource(R.drawable.k6u);
            }
            if (MMPopupMenu.this.X && MMPopupMenu.this.W != 0) {
                textView.setTextColor(MMPopupMenu.this.f153441a.getResources().getColor(MMPopupMenu.this.W));
            }
            MMPopupMenu.i(MMPopupMenu.this);
            return textView;
        }

        @Override // android.widget.Adapter
        public String getItem(int i3) {
            return (String) MMPopupMenu.this.F.getItemList().get(i3).getTitle();
        }
    }

    public MMPopupMenu(Context context, View view) {
        this.f153447d = null;
        this.f153457m = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = 0;
        this.P = false;
        this.S = false;
        this.T = false;
        this.U = true;
        this.V = true;
        this.W = 0;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f153442a0 = 0L;
        this.f153446c0 = true;
        this.f153448d0 = false;
        this.f153441a = context;
        this.f153445c = view;
        this.f153443b = (LayoutInflater) context.getSystemService("layout_inflater");
        c();
        f();
    }

    public static /* synthetic */ s i(MMPopupMenu mMPopupMenu) {
        mMPopupMenu.getClass();
        return null;
    }

    public static /* synthetic */ r o(MMPopupMenu mMPopupMenu) {
        mMPopupMenu.getClass();
        return null;
    }

    public void disableSelectedstatus(boolean z16) {
        this.f153457m = z16;
    }

    public boolean dismiss() {
        if (isShowing()) {
            g gVar = this.f153449e;
            if (gVar != null) {
                gVar.c();
            }
            return true;
        }
        if (isHorizontalMenuShowing()) {
            x xVar = this.f153450f;
            if (xVar != null) {
                xVar.dismiss();
            }
            return true;
        }
        if (isGridMenuShowing()) {
            x xVar2 = this.f153451g;
            if (xVar2 != null) {
                xVar2.dismiss();
            }
            return true;
        }
        if (isTickMenuShowing()) {
            x xVar3 = this.f153453i;
            if (xVar3 != null) {
                xVar3.dismiss();
            }
            return true;
        }
        return false;
    }

    public void enableCustomMenuColor(boolean z16) {
        this.X = z16;
    }

    public int getGridMenuMaxLineCount() {
        return f153440h0;
    }

    public int getGridPopupHeight() {
        x xVar = this.f153451g;
        if (xVar == null || xVar.getContentView() == null) {
            return 0;
        }
        View contentView = this.f153451g.getContentView();
        contentView.measure(0, 0);
        return contentView.getMeasuredHeight();
    }

    public int getMenuItemCount() {
        h hVar = this.F;
        if (hVar != null) {
            return hVar.size();
        }
        return 0;
    }

    public List<MenuItem> getMenuList() {
        return this.F.getItemList();
    }

    public long getMenuStartShowTime() {
        return this.f153442a0;
    }

    public boolean isGridMenuShowing() {
        x xVar = this.f153451g;
        if (xVar != null && xVar.isShowing()) {
            return true;
        }
        return false;
    }

    public boolean isHorizontalMenuShowing() {
        x xVar = this.f153450f;
        if (xVar != null && xVar.isShowing()) {
            return true;
        }
        return false;
    }

    public boolean isShowing() {
        g gVar = this.f153449e;
        if (gVar != null && gVar.g()) {
            return true;
        }
        return false;
    }

    public boolean isTickMenuShowing() {
        x xVar = this.f153453i;
        if (xVar != null && xVar.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (!this.f153457m) {
            View view = this.C;
            if (view != null) {
                view.setSelected(false);
            } else {
                this.f153445c.setSelected(false);
            }
        }
        PopupWindow.OnDismissListener onDismissListener = this.Q;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        return false;
    }

    public void openGridPopupMenu(View view, o oVar, u uVar, int i3, int i16) {
        this.E = uVar;
        this.f153445c = view;
        if (!(view instanceof TextView) && (i3 == 0 || i16 == 0)) {
            f();
        }
        this.F.clear();
        oVar.a(this.F, view, null);
        if (i3 == 0 && i16 == 0) {
            show();
        } else {
            show(i3, i16);
        }
    }

    public void openPopupMenu(View view, int i3, long j3, View.OnCreateContextMenuListener onCreateContextMenuListener, u uVar, int i16, int i17) {
        this.E = uVar;
        this.f153445c = view;
        f();
        this.F.clear();
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(view, i3, j3);
        onCreateContextMenuListener.onCreateContextMenu(this.F, view, adapterContextMenuInfo);
        Iterator<MenuItem> it = this.F.getItemList().iterator();
        while (it.hasNext()) {
            ((i) it.next()).a(adapterContextMenuInfo);
        }
        if (i16 == 0 && i17 == 0) {
            show();
        } else {
            show(i16, i17);
        }
    }

    public void openTextStylePopupMenu(View view, o oVar, u uVar, int i3, int i16) {
        this.E = uVar;
        this.f153445c = view;
        if (!(view instanceof TextView) && (i3 == 0 || i16 == 0)) {
            f();
        }
        this.F.clear();
        oVar.a(this.F, view, null);
        if (i3 == 0 && i16 == 0) {
            show();
        } else {
            show(i3, i16);
        }
    }

    public void registerGridPopupMenu(View view, o oVar, u uVar) {
        this.f153445c = view;
        f();
        this.E = uVar;
        if (view instanceof AbsListView) {
            n.d("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
            ((AbsListView) view).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(oVar) { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.3
                @Override // android.widget.AdapterView.OnItemLongClickListener
                public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i3, long j3) {
                    MMPopupMenu.this.F.clear();
                    n.d("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
                    new AdapterView.AdapterContextMenuInfo(view2, i3, j3);
                    h unused = MMPopupMenu.this.F;
                    throw null;
                }
            });
        } else {
            n.d("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
            view.setOnLongClickListener(new View.OnLongClickListener(oVar, view) { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.4

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ View f153470a;

                {
                    this.f153470a = view;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    n.d("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
                    MMPopupMenu.this.F.clear();
                    MMPopupMenu.this.f153445c = view2;
                    h unused = MMPopupMenu.this.F;
                    throw null;
                }
            });
        }
    }

    public void registerPopupMenu(View view, final View.OnCreateContextMenuListener onCreateContextMenuListener, u uVar) {
        this.f153445c = view;
        f();
        this.E = uVar;
        if (view instanceof AbsListView) {
            n.d("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
            ((AbsListView) view).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.1
                @Override // android.widget.AdapterView.OnItemLongClickListener
                public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i3, long j3) {
                    MMPopupMenu.this.F.clear();
                    n.d("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
                    AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(view2, i3, j3);
                    onCreateContextMenuListener.onCreateContextMenu(MMPopupMenu.this.F, view2, adapterContextMenuInfo);
                    Iterator<MenuItem> it = MMPopupMenu.this.F.getItemList().iterator();
                    while (it.hasNext()) {
                        ((i) it.next()).a(adapterContextMenuInfo);
                    }
                    MMPopupMenu.this.show();
                    return true;
                }
            });
        } else {
            n.d("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    n.d("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
                    MMPopupMenu.this.F.clear();
                    MMPopupMenu.this.f153445c = view2;
                    onCreateContextMenuListener.onCreateContextMenu(MMPopupMenu.this.F, view2, null);
                    if (view2.getTag(R.id.f100575sv) instanceof int[]) {
                        int[] iArr = (int[]) view2.getTag(R.id.f100575sv);
                        if (iArr == null) {
                            MMPopupMenu.this.show();
                        } else {
                            MMPopupMenu.this.show(iArr[0], iArr[1]);
                        }
                    } else {
                        MMPopupMenu.this.show();
                    }
                    view2.setTag(R.id.f86754si, Boolean.TRUE);
                    return true;
                }
            });
        }
    }

    public void registerPopupMenuWithoutTouchListener(View view, final View.OnCreateContextMenuListener onCreateContextMenuListener, u uVar) {
        this.f153445c = view;
        this.E = uVar;
        if (view instanceof AbsListView) {
            n.d("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
            ((AbsListView) view).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.11
                @Override // android.widget.AdapterView.OnItemLongClickListener
                public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i3, long j3) {
                    MMPopupMenu.this.F.clear();
                    n.d("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
                    AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(view2, i3, j3);
                    onCreateContextMenuListener.onCreateContextMenu(MMPopupMenu.this.F, view2, adapterContextMenuInfo);
                    Iterator<MenuItem> it = MMPopupMenu.this.F.getItemList().iterator();
                    while (it.hasNext()) {
                        ((i) it.next()).a(adapterContextMenuInfo);
                    }
                    MMPopupMenu.this.show();
                    return true;
                }
            });
        } else {
            n.d("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.12
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    n.d("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
                    MMPopupMenu.this.F.clear();
                    MMPopupMenu.this.f153445c = view2;
                    onCreateContextMenuListener.onCreateContextMenu(MMPopupMenu.this.F, view2, null);
                    if (view2.getTag(R.id.f100575sv) instanceof int[]) {
                        int[] iArr = (int[]) view2.getTag(R.id.f100575sv);
                        if (iArr == null) {
                            MMPopupMenu.this.show();
                        } else {
                            MMPopupMenu.this.show(iArr[0], iArr[1]);
                        }
                    } else {
                        MMPopupMenu.this.show();
                    }
                    return true;
                }
            });
        }
    }

    public void setCreateMenuViewListener(ICreateMenuViewListener iCreateMenuViewListener) {
        this.f153444b0 = iCreateMenuViewListener;
    }

    public void setGridPop(boolean z16) {
        this.I = z16;
    }

    public void setGridPopMinWidth(int i3) {
        this.N = i3;
    }

    public void setGridStyleForceShowAtBottom(boolean z16) {
        this.Y = z16;
    }

    public void setHorizontal(boolean z16) {
        this.H = z16;
    }

    public void setLeftArrowStyle(boolean z16) {
        this.M = z16;
    }

    public void setListPopupMenuForceIgnoreOutsideTouch(boolean z16) {
        this.f153448d0 = z16;
    }

    public void setListPopupMenuMode(boolean z16) {
        this.f153446c0 = z16;
    }

    public void setListViewTextColor(int i3) {
        this.W = i3;
    }

    public void setOnCreateMenuListener(View.OnCreateContextMenuListener onCreateContextMenuListener) {
        this.D = onCreateContextMenuListener;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.Q = onDismissListener;
    }

    public void setOnMenuSelectedListener(u uVar) {
        this.E = uVar;
    }

    public void setOnShowListener(OnPopupShowListener onPopupShowListener) {
        this.R = onPopupShowListener;
    }

    public void setPopupMenuBackground(int i3) {
        x xVar;
        if (this.Z && (xVar = this.f153453i) != null) {
            xVar.setBackgroundDrawable(this.f153441a.getResources().getDrawable(i3));
            return;
        }
        g gVar = this.f153449e;
        if (gVar != null) {
            gVar.a(this.f153441a.getResources().getDrawable(i3));
        }
    }

    public void setPressView(View view) {
        this.C = view;
    }

    public void setShowArrowAtBottomMiddle(Boolean bool) {
        this.Z = bool.booleanValue();
    }

    public void setTagTick(int i3) {
        this.f153454j = i3;
    }

    public void setTextStylePop(boolean z16) {
        this.J = z16;
    }

    public void setTextTipsStylePop(boolean z16) {
        this.K = z16;
    }

    public void setTipsPop(boolean z16) {
        this.L = z16;
    }

    public void setTitleText(String str) {
        this.O = str;
    }

    public void setmGridFocusable(boolean z16) {
        this.U = z16;
    }

    public void setmHorizontalFocusable(boolean z16) {
        this.S = z16;
    }

    public void setmHorizontalOutsideTouchable(boolean z16) {
        this.T = z16;
    }

    public void setmShowPointByTouch(boolean z16) {
        this.V = z16;
    }

    public boolean show() {
        return show(0, 0);
    }

    public final void c(int i3, int i16) {
        x xVar = new x(this.f153441a);
        this.f153452h = xVar;
        xVar.setOnDismissListener(this);
        this.f153452h.setWidth(-2);
        this.f153452h.setHeight(-2);
        this.f153452h.setFocusable(true);
        this.f153452h.setOutsideTouchable(true);
        this.f153452h.setAnimationStyle(R.style.a4i);
        this.f153452h.setInputMethodMode(2);
        View inflate = View.inflate(this.f153441a, R.layout.hse, null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f166241z43);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.uck);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.ucl);
        linearLayout.setVisibility(0);
        linearLayout.removeAllViews();
        for (final int i17 = 0; i17 < this.F.size(); i17++) {
            ICreateMenuViewListener iCreateMenuViewListener = this.f153444b0;
            View create = iCreateMenuViewListener != null ? iCreateMenuViewListener.create(this.f153441a, this.F.getItemList().get(i17)) : null;
            if (create == null) {
                create = View.inflate(this.f153441a, R.layout.fra, null);
                ((TextView) create.findViewById(R.id.b_5)).setText(this.F.getItemList().get(i17).getTitle());
            }
            create.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MMPopupMenu.this.E != null) {
                        MMPopupMenu.this.E.a(MMPopupMenu.this.F.getItem(i17), i17);
                    }
                    MMPopupMenu.this.f153452h.dismiss();
                }
            });
            if (linearLayout.getChildCount() < 5) {
                linearLayout.addView(create);
            }
        }
        this.f153452h.setContentView(inflate);
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = inflate.getMeasuredHeight();
        int measuredWidth = inflate.getMeasuredWidth();
        int a16 = com.tencent.luggage.wxa.lo.o.a(this.f153441a, 12);
        int i18 = i3 - ((int) (measuredWidth / 2.0f));
        int i19 = i18 + measuredWidth;
        int i26 = this.f153456l.widthPixels - a16;
        if (i19 > i26) {
            a16 = i26 - measuredWidth;
        } else if (i18 >= a16) {
            a16 = i18;
        }
        int c16 = (i16 - measuredHeight) - com.tencent.luggage.wxa.lo.o.c(this.f153441a, R.dimen.bgc);
        if (c16 < 0) {
            c16 = com.tencent.luggage.wxa.lo.o.c(this.f153441a, R.dimen.bgc) + i16 + this.f153445c.getHeight();
            imageView2.setVisibility(0);
            imageView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView2.getLayoutParams();
            layoutParams.leftMargin = (i3 - a16) - com.tencent.luggage.wxa.lo.o.a(this.f153441a, 7);
            imageView2.setLayoutParams(layoutParams);
        } else {
            imageView2.setVisibility(8);
            imageView.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = (i3 - a16) - com.tencent.luggage.wxa.lo.o.a(this.f153441a, 7);
            imageView.setLayoutParams(layoutParams2);
        }
        if (this.F.size() == 0) {
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
        }
        Context context = this.f153441a;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        this.f153452h.showAtLocation(this.f153445c, 0, a16, c16);
        this.f153442a0 = System.currentTimeMillis();
    }

    public final boolean d() {
        View findViewById;
        Context context = this.f153441a;
        if (context instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) context).getWindow().getDecorView();
            if (((Activity) this.f153441a).getResources().getConfiguration().orientation != 2 && (findViewById = viewGroup.findViewById(android.R.id.content)) != null) {
                Rect rect = new Rect();
                findViewById.getGlobalVisibleRect(rect);
                if (rect.left > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void e() {
        if (this.f153457m) {
            return;
        }
        View view = this.C;
        if (view != null) {
            view.setSelected(true);
        } else {
            this.f153445c.setSelected(true);
        }
    }

    public final boolean f(int i3, int i16) {
        if (!isShowing() && !isHorizontalMenuShowing() && !isGridMenuShowing()) {
            if (d()) {
                n.e("MicroMsg.MMPopupMenu", "is swiping, PASS tryShow", new Object[0]);
                return false;
            }
            boolean z16 = this.I;
            View.OnCreateContextMenuListener onCreateContextMenuListener = this.D;
            View view = null;
            if (onCreateContextMenuListener != null) {
                onCreateContextMenuListener.onCreateContextMenu(this.F, this.f153445c, null);
            }
            int count = this.f153447d.getCount() * this.f153441a.getResources().getDimensionPixelSize(R.dimen.bp7);
            if (count == 0 && !this.H && !this.I && !this.J && !this.K) {
                n.b("MicroMsg.MMPopupMenu", "tryShow failed, count:%d", Integer.valueOf(this.f153447d.getCount()));
                return false;
            }
            int dimensionPixelSize = this.f153441a.getResources().getDimensionPixelSize(R.dimen.caf);
            int a16 = a(this.f153447d);
            int c16 = com.tencent.luggage.wxa.lo.o.c(this.f153441a, R.dimen.cpw);
            if (a16 < c16) {
                a16 = c16;
            }
            boolean z17 = this.F.size() < 3;
            e();
            if (this.H) {
                b(i3, i16);
            } else if (this.I) {
                a(i3, i16);
            } else if (this.J) {
                c(i3, i16);
            } else if (this.K) {
                d(i3, i16);
            } else if (this.Z) {
                e(i3, i16);
            } else {
                SubMenuLogic.SubmnuLocation calculateLocation = SubMenuLogic.calculateLocation(this.f153441a, a16, i3, i16, count, dimensionPixelSize, z17);
                this.f153455k = i16 - this.f153441a.getResources().getDimensionPixelSize(R.dimen.caf);
                n.a("MicroMsg.MMPopupMenu", "showPointY=" + i16 + "verticalOffset=" + this.f153455k, new Object[0]);
                g gVar = new g(this.f153441a, null, 0);
                this.f153449e = gVar;
                gVar.a((PopupWindow.OnDismissListener) this);
                this.f153449e.a(new AdapterView.OnItemClickListener() { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.5
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view2, int i17, long j3) {
                        if (MMPopupMenu.this.E != null) {
                            if (MMPopupMenu.this.P && i17 >= 1) {
                                MMPopupMenu.this.E.a(MMPopupMenu.this.F.getItem(i17 - 1), i17);
                            } else {
                                MMPopupMenu.this.E.a(MMPopupMenu.this.F.getItem(i17), i17);
                            }
                        }
                        if (MMPopupMenu.this.f153449e != null && MMPopupMenu.this.f153449e.g()) {
                            MMPopupMenu.this.f153449e.c();
                        }
                    }
                });
                this.f153449e.a(this.f153447d);
                this.f153449e.b(this.f153446c0);
                this.f153449e.a(this.f153448d0);
                if (this.L) {
                    this.f153449e.a(this.f153441a.getResources().getDrawable(this.M ? R.drawable.ovy : R.drawable.ovx));
                } else {
                    this.f153449e.a(this.f153441a.getResources().getDrawable(R.drawable.oui));
                }
                this.f153449e.a(calculateLocation.animationStyle);
                this.f153449e.d(calculateLocation.marginRight);
                this.f153449e.f(calculateLocation.marginTop);
                this.f153449e.a(this.f153445c);
                this.f153449e.b(a16);
                this.f153449e.e(2);
                if (this.L) {
                    view = LayoutInflater.from(this.f153441a).inflate(R.layout.frc, (ViewGroup) null);
                    view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    this.f153449e.c((this.f153447d.getCount() * this.f153441a.getResources().getDimensionPixelSize(R.dimen.bir)) + this.f153441a.getResources().getDimensionPixelSize(R.dimen.bj8) + view.getMeasuredHeight());
                }
                Context context = this.f153441a;
                if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                    this.f153449e.i();
                    if (this.L && view != null) {
                        TextView textView = (TextView) view.findViewById(R.id.title);
                        String str = this.O;
                        if (str != null && str.length() > 0) {
                            textView.setText(this.O);
                            this.f153449e.e().addHeaderView(view);
                            this.P = true;
                        }
                    }
                    this.f153449e.e().setOnKeyListener(this);
                    this.f153449e.e().setDivider(new ColorDrawable(this.f153441a.getResources().getColor(R.color.f157973cs2)));
                    this.f153449e.e().setSelector(this.f153441a.getResources().getDrawable(R.drawable.k6u));
                    this.f153449e.e().setDividerHeight(0);
                    this.f153449e.e().setVerticalScrollBarEnabled(false);
                    this.f153449e.e().setHorizontalScrollBarEnabled(false);
                }
            }
            OnPopupShowListener onPopupShowListener = this.R;
            if (onPopupShowListener != null) {
                onPopupShowListener.onShow();
            }
            return true;
        }
        return false;
    }

    public boolean show(int i3, int i16) {
        int i17;
        int i18;
        int width;
        int dimensionPixelSize;
        View view = this.f153445c;
        if (((view != null && !view.equals(this.G)) || !f153439g0) && (i3 != 0 || i16 != 0)) {
            f153437e0 = i3;
            f153438f0 = i16;
        }
        this.G = null;
        if (this.V) {
            i17 = f153437e0;
            i18 = f153438f0;
        } else {
            i17 = 0;
            i18 = 0;
        }
        f153439g0 = false;
        if (this.f153456l == null) {
            this.f153456l = this.f153441a.getResources().getDisplayMetrics();
        }
        View view2 = this.f153445c;
        if (view2 != null) {
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            if (i17 == 0 || i17 > this.f153456l.widthPixels || this.L) {
                i17 = iArr[0] + (this.f153445c.getWidth() / 2);
            }
            if (this.L && !this.Z) {
                if (this.M) {
                    width = iArr[0];
                    dimensionPixelSize = this.f153441a.getResources().getDimensionPixelSize(R.dimen.bj8);
                } else {
                    width = iArr[0] + this.f153445c.getWidth();
                    dimensionPixelSize = this.f153441a.getResources().getDimensionPixelSize(R.dimen.bj8);
                }
                i17 = width - dimensionPixelSize;
            }
            int i19 = iArr[1];
            int height = this.f153445c.getHeight() + i19;
            if (i19 < 0) {
                i19 = 0;
            }
            int i26 = this.f153456l.heightPixels;
            if (height > i26) {
                height = i26;
            }
            if (i18 == 0 || this.L) {
                i18 = ((i19 + height) / 2) - (this.Z ? this.f153445c.getHeight() / 2 : 0);
            }
        }
        n.c("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        if (isShowing() && isHorizontalMenuShowing() && isGridMenuShowing()) {
            return dismiss() & f(i17, i18);
        }
        return f(i17, i18);
    }

    public final void b(int i3, int i16) {
        int dimensionPixelOffset = this.f153441a.getResources().getDimensionPixelOffset(R.dimen.bl9);
        int dimensionPixelOffset2 = this.f153441a.getResources().getDimensionPixelOffset(R.dimen.bkj);
        x xVar = new x(this.f153441a);
        this.f153450f = xVar;
        xVar.setOnDismissListener(this);
        this.f153450f.setWidth(-2);
        this.f153450f.setHeight(-2);
        this.f153450f.setBackgroundDrawable(this.f153441a.getResources().getDrawable(R.drawable.oui));
        this.f153450f.setFocusable(this.S);
        this.f153450f.setOutsideTouchable(this.T);
        LinearLayout linearLayout = new LinearLayout(this.f153441a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(this.f153441a.getResources().getColor(R.color.ah_));
        for (final int i17 = 0; i17 < this.F.size(); i17++) {
            TextView textView = (TextView) this.f153443b.inflate(R.layout.fa9, (ViewGroup) null, false);
            textView.setBackgroundResource(R.drawable.k6u);
            if (i17 == 0) {
                textView.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset, 0);
            } else if (i17 == this.F.size() - 1) {
                textView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset2, 0);
            }
            textView.setText(this.F.getItemList().get(i17).getTitle());
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MMPopupMenu.this.E != null) {
                        MMPopupMenu.this.E.a(MMPopupMenu.this.F.getItem(i17), i17);
                    }
                    MMPopupMenu.this.f153450f.dismiss();
                }
            });
            linearLayout.addView(textView);
        }
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = linearLayout.getMeasuredHeight();
        this.f153450f.setWidth(linearLayout.getMeasuredWidth() + com.tencent.luggage.wxa.lo.o.a(this.f153441a, 24));
        this.f153450f.setContentView(linearLayout);
        Context context = this.f153441a;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        this.f153450f.showAtLocation(this.f153445c, 0, i3, i16 - measuredHeight);
    }

    public final void a(int i3, int i16) {
        boolean z16;
        x xVar = new x(this.f153441a);
        this.f153451g = xVar;
        xVar.setOnDismissListener(this);
        this.f153451g.setWidth(-2);
        this.f153451g.setHeight(-2);
        this.f153451g.setFocusable(this.U);
        this.f153451g.setOutsideTouchable(true);
        this.f153451g.setAnimationStyle(R.style.a4i);
        this.f153451g.setInputMethodMode(2);
        View inflate = View.inflate(this.f153441a, R.layout.ed6, null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f166242z44);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.z46);
        View findViewById = inflate.findViewById(R.id.f166237eq1);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.uck);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.ucl);
        linearLayout.setVisibility(0);
        linearLayout.removeAllViews();
        if (this.F.size() > f153440h0) {
            linearLayout2.setVisibility(0);
            linearLayout2.removeAllViews();
            findViewById.setVisibility(0);
        } else {
            int i17 = 0;
            while (true) {
                if (i17 >= this.F.size()) {
                    z16 = false;
                    break;
                } else {
                    if (((i) this.F.getItem(i17)).p()) {
                        z16 = true;
                        break;
                    }
                    i17++;
                }
            }
            if (z16) {
                linearLayout2.setVisibility(0);
                linearLayout2.removeAllViews();
                findViewById.setVisibility(0);
            }
        }
        if (this.N > 0) {
            LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.f26330d9);
            linearLayout3.setMinimumWidth(this.N);
            if (linearLayout2.getVisibility() != 0) {
                a(linearLayout3, 1);
            }
        }
        for (final int i18 = 0; i18 < this.F.size(); i18++) {
            ICreateMenuViewListener iCreateMenuViewListener = this.f153444b0;
            View create = iCreateMenuViewListener != null ? iCreateMenuViewListener.create(this.f153441a, this.F.getItemList().get(i18)) : null;
            if (create == null) {
                create = View.inflate(this.f153441a, R.layout.fr_, null);
                WeImageView weImageView = (WeImageView) create.findViewById(R.id.icon);
                TextView textView = (TextView) create.findViewById(R.id.title);
                weImageView.setImageDrawable(this.F.getItemList().get(i18).getIcon());
                textView.setText(this.F.getItemList().get(i18).getTitle());
                if (this.X && (this.F.getItemList().get(i18) instanceof i)) {
                    int d16 = ((i) this.F.getItemList().get(i18)).d();
                    int l3 = ((i) this.F.getItemList().get(i18)).l();
                    if (d16 != 0) {
                        weImageView.setIconColor(d16);
                    }
                    if (l3 != 0) {
                        textView.setTextColor(l3);
                    }
                }
            }
            i iVar = (i) this.F.getItemList().get(i18);
            iVar.g();
            create.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MMPopupMenu.this.E != null) {
                        MMPopupMenu.this.E.a(MMPopupMenu.this.F.getItem(i18), i18);
                    }
                    MMPopupMenu.this.f153451g.dismiss();
                }
            });
            if (iVar.p()) {
                if (linearLayout2.getChildCount() < f153440h0) {
                    linearLayout2.addView(create);
                }
            } else if (linearLayout.getChildCount() < f153440h0) {
                linearLayout.addView(create);
            } else if (linearLayout2.getChildCount() < f153440h0) {
                linearLayout2.addView(create);
            }
        }
        this.f153451g.setContentView(inflate);
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = inflate.getMeasuredHeight();
        int measuredWidth = inflate.getMeasuredWidth();
        int a16 = com.tencent.luggage.wxa.lo.o.a(this.f153441a, 12);
        int i19 = i3 - ((int) (measuredWidth / 2.0f));
        int i26 = i19 + measuredWidth;
        int i27 = this.f153456l.widthPixels - a16;
        if (i26 > i27) {
            a16 = i27 - measuredWidth;
        } else if (i19 >= a16) {
            a16 = i19;
        }
        int c16 = (i16 - measuredHeight) - com.tencent.luggage.wxa.lo.o.c(this.f153441a, R.dimen.bgc);
        if (c16 >= 0 && !this.Y) {
            imageView2.setVisibility(8);
            imageView.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.leftMargin = (i3 - a16) - com.tencent.luggage.wxa.lo.o.a(this.f153441a, 7);
            imageView.setLayoutParams(layoutParams);
        } else {
            c16 = com.tencent.luggage.wxa.lo.o.c(this.f153441a, R.dimen.bgc) + i16 + this.f153445c.getHeight();
            imageView2.setVisibility(0);
            imageView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView2.getLayoutParams();
            layoutParams2.leftMargin = (i3 - a16) - com.tencent.luggage.wxa.lo.o.a(this.f153441a, 7);
            imageView2.setLayoutParams(layoutParams2);
        }
        if (this.F.size() == 0) {
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
        }
        Context context = this.f153441a;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        this.f153451g.showAtLocation(this.f153445c, 0, a16, c16);
        this.f153442a0 = System.currentTimeMillis();
    }

    public final void e(int i3, int i16) {
        x xVar = new x(this.f153441a);
        this.f153453i = xVar;
        xVar.setOnDismissListener(this);
        this.f153453i.setWidth(-2);
        this.f153453i.setHeight(-2);
        this.f153453i.setFocusable(true);
        this.f153453i.setOutsideTouchable(true);
        this.f153453i.setAnimationStyle(R.style.a4i);
        this.f153453i.setInputMethodMode(2);
        View inflate = View.inflate(this.f153441a, R.layout.frf, null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f166241z43);
        linearLayout.setVisibility(0);
        linearLayout.removeAllViews();
        int size = this.F.size();
        for (final int i17 = 0; i17 < size; i17++) {
            ICreateMenuViewListener iCreateMenuViewListener = this.f153444b0;
            View create = iCreateMenuViewListener != null ? iCreateMenuViewListener.create(this.f153441a, this.F.getItemList().get(i17)) : null;
            if (create == null) {
                MenuItem menuItem = this.F.getItemList().get(i17);
                View inflate2 = View.inflate(this.f153441a, R.layout.fre, null);
                WeImageView weImageView = (WeImageView) inflate2.findViewById(R.id.icon);
                TextView textView = (TextView) inflate2.findViewById(R.id.title);
                WeImageView weImageView2 = (WeImageView) inflate2.findViewById(R.id.f97195jq);
                weImageView.setImageDrawable(menuItem.getIcon());
                textView.setText(menuItem.getTitle());
                if (menuItem.getItemId() == this.f153454j) {
                    Context context = this.f153441a;
                    weImageView2.setImageDrawable(m.a(context, R.raw.f169316c3, context.getColor(R.color.ap9)));
                    weImageView2.setVisibility(0);
                }
                if (i17 + 1 == size) {
                    ((ImageView) inflate2.findViewById(R.id.f165001uk0)).setVisibility(8);
                }
                create = inflate2;
            }
            create.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MMPopupMenu.this.E != null) {
                        MMPopupMenu.this.E.a(MMPopupMenu.this.F.getItem(i17), i17);
                    }
                    MMPopupMenu.this.f153453i.dismiss();
                }
            });
            if (linearLayout.getChildCount() < 5) {
                linearLayout.addView(create);
            }
        }
        this.f153453i.setContentView(inflate);
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = inflate.getMeasuredHeight();
        int measuredWidth = inflate.getMeasuredWidth();
        int a16 = com.tencent.luggage.wxa.lo.o.a(this.f153441a, 12);
        int i18 = i3 - ((int) (measuredWidth / 2.0f));
        int i19 = i18 + measuredWidth;
        int i26 = this.f153456l.widthPixels - a16;
        if (i19 > i26) {
            a16 = i26 - measuredWidth;
        } else if (i18 >= a16) {
            a16 = i18;
        }
        int a17 = a16 - com.tencent.luggage.wxa.lo.o.a(this.f153441a, 8);
        int c16 = (i16 - measuredHeight) - com.tencent.luggage.wxa.lo.o.c(this.f153441a, R.dimen.bh9);
        if (c16 < 0 || this.Y) {
            c16 = com.tencent.luggage.wxa.lo.o.c(this.f153441a, R.dimen.bgc) + i16 + this.f153445c.getHeight();
        }
        Context context2 = this.f153441a;
        if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
            return;
        }
        n.c("MicroMsg.MMPopupMenu", "showTickStyleMenu, x:" + a17 + ", y:" + c16, new Object[0]);
        this.f153453i.showAtLocation(this.f153445c, 0, a17, c16);
        this.f153442a0 = System.currentTimeMillis();
    }

    public final void d(int i3, int i16) {
        x xVar = new x(this.f153441a);
        this.f153452h = xVar;
        xVar.setOnDismissListener(this);
        this.f153452h.setWidth(-2);
        this.f153452h.setHeight(-2);
        this.f153452h.setFocusable(true);
        this.f153452h.setOutsideTouchable(true);
        this.f153452h.setAnimationStyle(R.style.a4i);
        this.f153452h.setInputMethodMode(2);
        View inflate = View.inflate(this.f153441a, R.layout.hsf, null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f166241z43);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ucl);
        linearLayout.setVisibility(0);
        linearLayout.removeAllViews();
        final View inflate2 = View.inflate(this.f153441a, R.layout.frb, null);
        ((TextView) inflate2.findViewById(R.id.b_5)).setText(this.O);
        inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MMPopupMenu.o(MMPopupMenu.this);
                MMPopupMenu.this.f153452h.dismiss();
            }
        });
        linearLayout.addView(inflate2);
        this.f153452h.setContentView(inflate);
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = inflate.getMeasuredWidth();
        int a16 = com.tencent.luggage.wxa.lo.o.a(this.f153441a, 12);
        int i17 = i3 - ((int) (measuredWidth / 2.0f));
        int i18 = i17 + measuredWidth;
        int i19 = this.f153456l.widthPixels - a16;
        if (i18 > i19) {
            a16 = i19 - measuredWidth;
        } else if (i17 >= a16) {
            a16 = i17;
        }
        int c16 = i16 + com.tencent.luggage.wxa.lo.o.c(this.f153441a, R.dimen.bh9);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.leftMargin = (i3 - a16) - com.tencent.luggage.wxa.lo.o.a(this.f153441a, 7);
        imageView.setLayoutParams(layoutParams);
        Context context = this.f153441a;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        this.f153452h.showAtLocation(this.f153445c, 0, a16, c16);
        this.f153442a0 = System.currentTimeMillis();
    }

    public void openPopupMenu(View view, View.OnCreateContextMenuListener onCreateContextMenuListener, u uVar, int i3, int i16) {
        this.E = uVar;
        this.f153445c = view;
        if (!(view instanceof TextView) && (i3 == 0 || i16 == 0)) {
            f();
        }
        this.F.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.F, view, null);
        if (i3 == 0 && i16 == 0) {
            show();
        } else {
            show(i3, i16);
        }
    }

    public void registerTipsPopupMenu() {
    }

    public void setOnCreateMMMenuListener(o oVar) {
    }

    public void setOnGetViewListener(s sVar) {
    }

    public void setOnMMClickViewListener(r rVar) {
    }

    public MMPopupMenu(Context context) {
        this.f153445c = null;
        this.f153447d = null;
        this.f153457m = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = 0;
        this.P = false;
        this.S = false;
        this.T = false;
        this.U = true;
        this.V = true;
        this.W = 0;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f153442a0 = 0L;
        this.f153446c0 = true;
        this.f153448d0 = false;
        this.f153441a = context;
        this.f153443b = (LayoutInflater) context.getSystemService("layout_inflater");
        c();
    }

    public final void c() {
        dismiss();
        this.F = new h(this.f153441a);
        this.f153447d = new SubmenuAdapter();
        this.f153456l = this.f153441a.getResources().getDisplayMetrics();
    }

    public final void f() {
        this.f153445c.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mm.ui.widget.menu.MMPopupMenu.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if ((motionEvent.getAction() & 255) == 0) {
                    int unused = MMPopupMenu.f153437e0 = (int) motionEvent.getRawX();
                    int unused2 = MMPopupMenu.f153438f0 = (int) motionEvent.getRawY();
                    MMPopupMenu mMPopupMenu = MMPopupMenu.this;
                    mMPopupMenu.G = mMPopupMenu.f153445c;
                    boolean unused3 = MMPopupMenu.f153439g0 = true;
                    n.c("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + MMPopupMenu.f153437e0 + "y_down=" + MMPopupMenu.f153438f0, new Object[0]);
                }
                return false;
            }
        });
    }

    public final void a(LinearLayout linearLayout, int i3) {
        if (linearLayout != null) {
            linearLayout.setGravity(i3);
        }
    }

    public final int a(ListAdapter listAdapter) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i3 = 0;
        int i16 = 0;
        View view = null;
        for (int i17 = 0; i17 < count; i17++) {
            int itemViewType = listAdapter.getItemViewType(i17);
            if (itemViewType != i16) {
                view = null;
                i16 = itemViewType;
            }
            view = listAdapter.getView(i17, view, new FrameLayout(this.f153441a));
            if (view != null) {
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
            }
        }
        return i3;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
    }
}
