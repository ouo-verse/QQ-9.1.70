package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ShareActionSheetBuilder implements ShareActionSheet {
    protected TextView C;
    public LinearLayout D;
    public TextView E;
    protected int F;
    protected int G;
    protected CharSequence H;
    protected List<ActionSheetItem>[] I;
    protected boolean J;
    protected int K;
    protected int L;
    protected int M;
    protected int N;
    protected int P;
    protected int Q;
    protected d R;
    protected boolean S;
    protected GridView T;
    protected GridView U;
    private boolean V;
    private String W;
    private ShareActionSheet X;

    /* renamed from: d, reason: collision with root package name */
    protected Context f307286d;

    /* renamed from: e, reason: collision with root package name */
    protected AdapterView.OnItemClickListener f307287e;

    /* renamed from: f, reason: collision with root package name */
    protected ActionSheet f307288f;

    /* renamed from: h, reason: collision with root package name */
    protected View f307289h;

    /* renamed from: i, reason: collision with root package name */
    public ElasticHorScrView f307290i;

    /* renamed from: m, reason: collision with root package name */
    public ElasticHorScrView f307291m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ShareActionSheetBuilder.this.f307288f.isShowing()) {
                ShareActionSheetBuilder.this.f307288f.cancel();
                ShareActionSheetBuilder.this.f307288f.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private List<ActionSheetItem> f307298d;

        /* renamed from: e, reason: collision with root package name */
        private LayoutInflater f307299e;

        /* renamed from: h, reason: collision with root package name */
        private a f307301h;

        /* renamed from: i, reason: collision with root package name */
        private Resources f307302i;

        /* renamed from: f, reason: collision with root package name */
        private int f307300f = 0;

        /* renamed from: m, reason: collision with root package name */
        private boolean f307303m = false;

        /* JADX INFO: Access modifiers changed from: protected */
        /* compiled from: P */
        /* loaded from: classes20.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            protected Context f307304a;

            /* renamed from: b, reason: collision with root package name */
            protected Drawable f307305b;

            /* renamed from: c, reason: collision with root package name */
            protected Drawable f307306c;

            /* JADX INFO: Access modifiers changed from: protected */
            public a(Context context) {
                this.f307304a = context;
                Resources resources = context.getResources();
                this.f307305b = resources.getDrawable(R.drawable.f160036m);
                this.f307306c = resources.getDrawable(R.drawable.f160039o);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public Drawable g(Drawable drawable) {
                Drawable mutate = drawable.getConstantState().newDrawable().mutate();
                mutate.setColorFilter(Integer.MAX_VALUE, PorterDuff.Mode.MULTIPLY);
                return mutate;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public Drawable h(Drawable drawable) {
                return new LayerDrawable(new Drawable[]{drawable, this.f307306c});
            }

            Drawable c(Drawable drawable, int i3, int i16) {
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f307305b, drawable});
                layerDrawable.setLayerInset(1, i3, i16, i3, i16);
                return layerDrawable;
            }

            public void d() {
                this.f307305b = this.f307304a.getResources().getDrawable(e());
                this.f307306c = f(this.f307304a);
            }

            public int e() {
                if (QQTheme.isNowThemeIsNight()) {
                    return R.drawable.j2d;
                }
                return R.drawable.j2c;
            }

            public Drawable f(Context context) {
                return context.getResources().getDrawable(R.drawable.j2e);
            }

            StateListDrawable i(Drawable drawable, Drawable drawable2) {
                int[] iArr = {android.R.attr.state_pressed};
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(iArr, drawable2);
                stateListDrawable.addState(new int[0], drawable);
                return stateListDrawable;
            }
        }

        public b(Context context, List<ActionSheetItem> list) {
            this.f307298d = list;
            this.f307299e = LayoutInflater.from(context);
        }

        protected a a(Context context) {
            a aVar = new a(context);
            if (this.f307303m) {
                aVar.d();
            }
            return aVar;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActionSheetItem getItem(int i3) {
            if (this.f307298d != null && i3 >= 0) {
                int i16 = -1;
                for (int i17 = 0; i17 < this.f307298d.size(); i17++) {
                    ActionSheetItem actionSheetItem = this.f307298d.get(i17);
                    if (actionSheetItem != null && actionSheetItem.visibility == 0) {
                        i16++;
                    }
                    if (i16 == i3) {
                        return actionSheetItem;
                    }
                }
            }
            return null;
        }

        protected int c() {
            return R.layout.f167788hi;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<ActionSheetItem> list = this.f307298d;
            int i3 = 0;
            if (list == null) {
                return 0;
            }
            for (ActionSheetItem actionSheetItem : list) {
                if (actionSheetItem != null && actionSheetItem.visibility == 0) {
                    i3++;
                }
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            c cVar;
            int i16;
            int i17;
            if (this.f307302i == null) {
                this.f307302i = viewGroup.getContext().getResources();
            }
            if (this.f307300f == 0) {
                this.f307300f = (int) this.f307302i.getDimension(R.dimen.f158592jv);
            }
            if (this.f307301h == null) {
                this.f307301h = a(viewGroup.getContext());
            }
            int i18 = 0;
            if (view == null) {
                view = this.f307299e.inflate(c(), viewGroup, false);
                cVar = new c();
                cVar.f307308b = (ImageView) view.findViewById(R.id.iqu);
                cVar.f307307a = (TextView) view.findViewById(R.id.iqv);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            ActionSheetItem item = getItem(i3);
            cVar.f307311e = item;
            if (item == null) {
                QLog.e("ShareActionSheetBuilder", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + i3 + ") == null !!!");
            } else {
                view.setId(item.f307296id);
                float dimension = this.f307302i.getDimension(R.dimen.f158592jv);
                TextPaint paint = cVar.f307307a.getPaint();
                paint.setTextSize(this.f307302i.getDimensionPixelSize(R.dimen.ayj));
                TextView textView = cVar.f307307a;
                ActionSheetItem actionSheetItem = cVar.f307311e;
                String str = actionSheetItem.label;
                int i19 = actionSheetItem.firstLineCount;
                if (i19 <= 0) {
                    i19 = 5;
                }
                textView.setText(ShareActionSheetBuilder.b(paint, dimension, str, i19));
                TextView textView2 = cVar.f307307a;
                if (cVar.f307311e.enable) {
                    i16 = RichStatus.ACTION_COLOR_NORMAL;
                } else {
                    i16 = 2138535799;
                }
                textView2.setTextColor(i16);
                ActionSheetItem actionSheetItem2 = cVar.f307311e;
                if (actionSheetItem2.iconNeedBg) {
                    Drawable drawable = actionSheetItem2.iconDrawable;
                    if (drawable == null) {
                        drawable = this.f307302i.getDrawable(actionSheetItem2.icon);
                    }
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    int i26 = this.f307300f;
                    if (i26 > intrinsicWidth) {
                        i17 = (int) ((i26 - intrinsicWidth) / 2.0f);
                    } else {
                        i17 = 0;
                    }
                    if (i26 > intrinsicHeight) {
                        i18 = (int) ((i26 - intrinsicHeight) / 2.0f);
                    }
                    Drawable c16 = this.f307301h.c(drawable, i17, i18);
                    if (cVar.f307311e.enable) {
                        cVar.f307308b.setImageDrawable(this.f307301h.i(c16, this.f307301h.h(c16)));
                    } else {
                        cVar.f307308b.setImageDrawable(this.f307301h.g(c16));
                    }
                    cVar.f307308b.setBackground(null);
                } else {
                    cVar.f307308b.setImageResource(R.drawable.f160037n);
                    ActionSheetItem actionSheetItem3 = cVar.f307311e;
                    Drawable drawable2 = actionSheetItem3.iconDrawable;
                    if (drawable2 != null) {
                        cVar.f307308b.setBackground(drawable2);
                    } else {
                        cVar.f307308b.setBackgroundResource(actionSheetItem3.icon);
                    }
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public TextView f307307a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f307308b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f307309c;

        /* renamed from: d, reason: collision with root package name */
        public QUIBadge f307310d;

        /* renamed from: e, reason: collision with root package name */
        public ActionSheetItem f307311e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private ViewGroup f307312a;

        /* renamed from: b, reason: collision with root package name */
        private View f307313b;

        protected d() {
        }

        private void a() {
            View view;
            ViewGroup viewGroup = this.f307312a;
            if (viewGroup != null && (view = this.f307313b) != null) {
                viewGroup.addView(view);
            }
        }

        private void b(View view) {
            ViewParent parent;
            if (view != null && (parent = view.getParent()) != null && (parent instanceof ViewGroup)) {
                c((ViewGroup) parent);
            }
        }

        private void c(ViewGroup viewGroup) {
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
        }

        public void d(RelativeLayout relativeLayout) {
            c(this.f307312a);
            c(relativeLayout);
            this.f307312a = relativeLayout;
            a();
        }

        void e(View view, RelativeLayout.LayoutParams layoutParams) {
            b(this.f307313b);
            b(view);
            if (view != null) {
                view.setLayoutParams(layoutParams);
            }
            this.f307313b = view;
            a();
        }

        void f(int i3) {
            ViewGroup viewGroup = this.f307312a;
            if (viewGroup != null) {
                viewGroup.setBackgroundColor(i3);
            }
        }
    }

    @Deprecated
    public ShareActionSheetBuilder(Context context) {
        this(context, false);
    }

    protected static String b(TextPaint textPaint, float f16, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int e16 = e(textPaint, str, f16);
        if (LocaleManager.isLocaleCN()) {
            int min = Math.min(i3, e16);
            if (str.length() <= min) {
                return str;
            }
            String substring = str.substring(0, min);
            String substring2 = str.substring(min);
            int e17 = e(textPaint, substring2, f16);
            if (substring2.length() > e17) {
                substring2 = substring2.substring(0, e17) + "..";
            }
            return substring + "\n" + substring2;
        }
        if (str.length() <= e16) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str2 : str.split(" ")) {
            int length = sb5.toString().length() + str2.length();
            if (length > e16 * 2) {
                break;
            }
            if (!sb5.toString().contains("\n") && length > e16) {
                sb5.append("\n");
            }
            sb5.append(str2);
            sb5.append(" ");
        }
        String trim = sb5.toString().trim();
        if (trim.length() > e16 * 2) {
            return trim.substring(0, e16) + "..";
        }
        return trim;
    }

    private static int e(TextPaint textPaint, String str, float f16) {
        if (textPaint.measureText(str) < f16) {
            return str.length();
        }
        for (int i3 = 1; i3 <= str.length(); i3++) {
            if (textPaint.measureText(str.substring(0, i3)) > f16) {
                return i3;
            }
        }
        return str.length();
    }

    private void i(GridView gridView, List<ActionSheetItem> list, StaticLayout staticLayout, int i3) {
        gridView.setOverScrollMode(2);
        Iterator<ActionSheetItem> it = list.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            if (it.next().visibility == 0) {
                i16++;
            }
        }
        int iconWidth = this.L + getIconWidth() + this.L;
        gridView.setColumnWidth(iconWidth);
        gridView.setNumColumns(i16);
        ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
        gridView.setPadding(this.Q, gridView.getPaddingTop(), this.Q, gridView.getPaddingBottom());
        int i17 = this.Q;
        layoutParams.width = (i16 * iconWidth) + i17 + i17;
        layoutParams.height = this.K + this.N + staticLayout.getHeight() + i3;
        gridView.setLayoutParams(layoutParams);
        gridView.setAdapter((ListAdapter) c(this.f307286d, list));
        gridView.setSelector(new ColorDrawable(0));
        gridView.setOnItemClickListener(this.f307287e);
    }

    private void k(View view, List<ActionSheetItem> list, StaticLayout staticLayout, int i3) {
        GridView gridView = (GridView) view.findViewById(R.id.cx4);
        this.U = gridView;
        gridView.setSmoothScrollbarEnabled(false);
        i(this.U, list, staticLayout, i3);
        this.G = this.U.getLayoutParams().width;
    }

    protected b c(Context context, List<ActionSheetItem> list) {
        return new b(context, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(9)
    public View d() {
        List<ActionSheetItem> arrayList;
        List<ActionSheetItem> arrayList2;
        View inflate = View.inflate(this.f307286d, g(), null);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.f2104if);
        this.R.d(relativeLayout);
        this.D = (LinearLayout) inflate.findViewById(R.id.f163935cx);
        TextView textView = (TextView) inflate.findViewById(R.id.f163933cv);
        this.C = textView;
        if (this.S) {
            textView.setVisibility(0);
            CharSequence charSequence = this.H;
            if (charSequence != null) {
                this.C.setText(charSequence);
            }
        } else {
            hideTitle();
        }
        this.f307290i = (ElasticHorScrView) inflate.findViewById(R.id.iih);
        this.f307291m = (ElasticHorScrView) inflate.findViewById(R.id.iii);
        List<ActionSheetItem>[] f16 = f();
        if (f16.length > 0) {
            arrayList = f16[0];
        } else {
            arrayList = new ArrayList<>(0);
        }
        boolean z16 = !arrayList.isEmpty();
        if (f16.length > 1) {
            arrayList2 = f16[1];
        } else {
            arrayList2 = new ArrayList<>(0);
        }
        boolean z17 = !arrayList2.isEmpty();
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(this.f307286d.getResources().getDimensionPixelSize(R.dimen.ayi));
        StaticLayout staticLayout = new StaticLayout(b(textPaint, this.M, h(arrayList), 5), textPaint, this.M, Layout.Alignment.ALIGN_CENTER, 1.0f, this.P, true);
        StaticLayout staticLayout2 = new StaticLayout(b(textPaint, this.M, h(arrayList2), 5), textPaint, this.M, Layout.Alignment.ALIGN_CENTER, 1.0f, this.P, true);
        if (staticLayout.getHeight() >= staticLayout2.getHeight()) {
            staticLayout2 = staticLayout;
        }
        int dimensionPixelOffset = this.f307286d.getResources().getDimensionPixelOffset(R.dimen.f158591ju);
        if (z16) {
            j(inflate, arrayList, staticLayout2, dimensionPixelOffset);
        }
        if (z17) {
            k(inflate, arrayList2, staticLayout2, dimensionPixelOffset);
        }
        this.E = (TextView) inflate.findViewById(R.id.f163928co);
        if (QQTheme.isNowSimpleUI() || QQTheme.isNowThemeIsNight()) {
            int color = this.f307286d.getResources().getColor(R.color.skin_share_panel_bg);
            relativeLayout.setBackgroundColor(color);
            this.D.setBackgroundColor(color);
            this.E.setBackgroundColor(color);
            this.C.setTextColor(this.f307286d.getResources().getColor(R.color.skin_gray2_item));
            this.E.setTextColor(this.f307286d.getResources().getColor(R.color.skin_share_panel_cancel));
        }
        this.E.setText(R.string.cancel);
        this.E.setOnClickListener(new a());
        if (!z16) {
            this.f307290i.setVisibility(8);
        }
        if (!z17) {
            this.f307291m.setVisibility(8);
        }
        inflate.post(new Runnable() { // from class: com.tencent.mobileqq.utils.ShareActionSheetBuilder.2
            @Override // java.lang.Runnable
            public void run() {
                ShareActionSheetBuilder shareActionSheetBuilder = ShareActionSheetBuilder.this;
                shareActionSheetBuilder.l(shareActionSheetBuilder.f307290i, shareActionSheetBuilder.F);
                ShareActionSheetBuilder shareActionSheetBuilder2 = ShareActionSheetBuilder.this;
                shareActionSheetBuilder2.l(shareActionSheetBuilder2.f307291m, shareActionSheetBuilder2.G);
            }
        });
        return inflate;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void dismiss() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.dismiss();
            return;
        }
        setOpenSource(null);
        if (isShowing()) {
            try {
                this.f307288f.dismiss();
                this.f307289h = null;
            } catch (RuntimeException e16) {
                QLog.w("ShareActionSheetBuilder", 2, "Exception while dismiss", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void dismissImmediately() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.dismissImmediately();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<ActionSheetItem>[] f() {
        List<ActionSheetItem>[] listArr = this.I;
        if (listArr != null) {
            return listArr;
        }
        return new ArrayList[0];
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public View findViewById(int i3) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            return shareActionSheet.findViewById(i3);
        }
        Window window = this.f307288f.getWindow();
        if (window != null) {
            return window.findViewById(i3);
        }
        return null;
    }

    protected int g() {
        return R.layout.f167789hj;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public ActionSheet getActionSheet() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            return shareActionSheet.getActionSheet();
        }
        return this.f307288f;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public int getActionSheetPanelViewHeight() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            return shareActionSheet.getActionSheetPanelViewHeight();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public Bundle getExtras() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            return shareActionSheet.getExtras();
        }
        return null;
    }

    public int getIconMarginLeftRight() {
        return this.L;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public int getIconWidth() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            return shareActionSheet.getIconWidth();
        }
        return this.K;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public String getOpenSource() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            return shareActionSheet.getOpenSource();
        }
        return this.W;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public Window getWindow() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            return shareActionSheet.getWindow();
        }
        return this.f307288f.getWindow();
    }

    protected String h(List<ActionSheetItem> list) {
        String str = "";
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str2 = list.get(i3).label;
            if (str2.length() > str.length()) {
                str = str2;
            }
        }
        return str;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void hideTitle() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.hideTitle();
            return;
        }
        this.S = false;
        TextView textView = this.C;
        if (textView != null && textView.getVisibility() != 8) {
            this.C.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public boolean isShowing() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            return shareActionSheet.isShowing();
        }
        return this.f307288f.isShowing();
    }

    protected void j(View view, List<ActionSheetItem> list, StaticLayout staticLayout, int i3) {
        GridView gridView = (GridView) view.findViewById(R.id.f165392cx3);
        this.T = gridView;
        i(gridView, list, staticLayout, i3);
        this.F = this.T.getLayoutParams().width;
    }

    protected void l(ElasticHorScrView elasticHorScrView, int i3) {
        int width = elasticHorScrView.getWidth();
        boolean z16 = true;
        if (width < i3) {
            elasticHorScrView.setMove(true);
        } else {
            elasticHorScrView.setMove(false);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setMove, scrollViewLength = ");
            sb5.append(width);
            sb5.append("; gridViewLength = ");
            sb5.append(i3);
            sb5.append("; move = ");
            if (width >= i3) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("ShareActionSheetBuilder", 2, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void onConfigurationChanged() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.onConfigurationChanged();
            return;
        }
        Context context = this.f307286d;
        if (context == null) {
            return;
        }
        int i3 = context.getResources().getDisplayMetrics().widthPixels - this.Q;
        ElasticHorScrView elasticHorScrView = this.f307290i;
        if (elasticHorScrView != null && this.f307291m != null) {
            if (i3 < this.F) {
                elasticHorScrView.setMove(true);
            } else {
                elasticHorScrView.setMove(false);
            }
            if (i3 < this.G) {
                this.f307291m.setMove(true);
            } else {
                this.f307291m.setMove(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void refresh() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.refresh();
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetItems(List<ActionSheetItem> list, List<ActionSheetItem> list2) {
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetTitle(CharSequence charSequence) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setActionSheetTitle(charSequence);
            return;
        }
        this.H = charSequence;
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setAdvBgColor(int i3) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setAdvBgColor(i3);
        } else {
            this.R.f(i3);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setAdvView(View view, RelativeLayout.LayoutParams layoutParams) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setAdvView(view, layoutParams);
        } else {
            this.R.e(view, layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setBottomBarInterface(ShareActionSheet.b bVar) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setBottomBarInterface(bVar);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setCancelListener(onCancelListener);
        } else {
            this.f307288f.setOnCancelListener(onCancelListener);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setEnableNotTriggerVirtualNavigationBar(boolean z16) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setEnableNotTriggerVirtualNavigationBar(z16);
        } else {
            this.V = z16;
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setExtras(Bundle bundle) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setExtras(bundle);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setIconMarginLeftRight(int i3) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setIconMarginLeftRight(i3);
        } else {
            this.L = i3;
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setIntentForStartForwardRecentActivity(Intent intent) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setIntentForStartForwardRecentActivity(intent);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setItemClickListener(onItemClickListener);
            return;
        }
        this.f307287e = onItemClickListener;
        this.J = true;
        if (onItemClickListener == null) {
            GridView gridView = this.T;
            if (gridView != null) {
                gridView.setOnItemClickListener(null);
            }
            GridView gridView2 = this.U;
            if (gridView2 != null) {
                gridView2.setOnItemClickListener(null);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener onItemClickListener) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setItemClickListenerV2(onItemClickListener);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListenerV3(ShareActionSheet.c cVar) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setItemClickListenerV3(cVar);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setOnDismissListener(onDismissListener);
            return;
        }
        ActionSheet actionSheet = this.f307288f;
        if (actionSheet != null) {
            actionSheet.setOnDismissListener(onDismissListener);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setOnShowListener(onShowListener);
        } else {
            this.f307288f.setOnShowListener(onShowListener);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setOpenSource(String str) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setOpenSource(str);
        } else {
            this.W = str;
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setRecentlyUserSorter(ShareActionSheet.a aVar) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setRecentlyUserSorter(aVar);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setRowMarginLeftRight(int i3) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setRowMarginLeftRight(i3);
        } else {
            this.Q = i3;
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setRowVisibility(int i3, int i16, int i17) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setRowVisibility(i3, i16, i17);
        }
    }

    public void setTitlePadding(int i3, int i16, int i17, int i18) {
        TextView textView = this.C;
        if (textView != null) {
            textView.setPadding(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void show() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.show();
            return;
        }
        if (this.f307289h == null || this.J) {
            this.f307289h = d();
        }
        this.f307288f.setActionContentView(this.f307289h, null);
        try {
            if (!isShowing()) {
                if (getWindow() != null) {
                    com.tencent.mobileqq.theme.a.d(getWindow());
                }
                if (this.V) {
                    com.tencent.biz.subscribe.utils.g.b(getWindow());
                }
                this.f307288f.show();
                if (this.V) {
                    com.tencent.biz.subscribe.utils.g.c(getWindow());
                    com.tencent.biz.subscribe.utils.g.a(getWindow());
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheetBuilder", 2, "actionSheet.show exception=" + e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void updateUI() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.updateUI();
        } else if (this.f307288f.isShowing()) {
            View d16 = d();
            this.f307289h = d16;
            this.f307288f.setActionContentView(d16, null);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void updateUIIfShowing() {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.updateUIIfShowing();
        } else if (this.f307288f.isShowing()) {
            View d16 = d();
            this.f307289h = d16;
            this.f307288f.setActionContentView(d16, null);
        }
    }

    @Deprecated
    public ShareActionSheetBuilder(Context context, boolean z16) {
        this(context, z16, 1);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetItems(List<ActionSheetItem>[] listArr) {
        ShareActionSheet shareActionSheet = this.X;
        if (shareActionSheet != null) {
            shareActionSheet.setActionSheetItems(listArr);
        } else {
            this.I = listArr;
            this.J = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ActionSheetItem {
        public static final int ACTION_ADBLOCK = 90;
        public static final int ACTION_ADD_COLOR_NOTE = 70;
        public static final int ACTION_ADD_FAVORITER = 6;
        public static final int ACTION_ADD_FRIEND = 35;
        public static final int ACTION_ADD_GOODS = 156;
        public static final int ACTION_ADD_MINIAPP_TO_CURRENT_TROOP = 159;
        public static final int ACTION_ADD_SHORTCUT = 14;
        public static final int ACTION_ADD_TOP = 186;
        public static final int ACTION_ADD_TROOP_APP = 15;
        public static final int ACTION_ADJUST_FONT_SIZE = 7;
        public static final int ACTION_ADMIN_BLOCK_USER = 240;
        public static final int ACTION_ADMIN_DELETE_FEED = 235;
        public static final int ACTION_BARRAGE_CLOSE = 143;
        public static final int ACTION_BARRAGE_OPEN = 142;
        public static final int ACTION_BATCH_MANAGEMENT = 224;
        public static final int ACTION_CANCEL_ONLY_SEE_FRIEND = 103;
        public static final int ACTION_CANCEL_PUSH_DISABLE = 167;
        public static final int ACTION_CANCEL_WATCH_LATER = 237;
        public static final int ACTION_CARTON_DETAIL = 125;
        public static final int ACTION_CHANNEL_FACE2FACE_SHARE_TROOP = 24;
        public static final int ACTION_CHANNEL_QR_CODE = 23;
        public static final int ACTION_CHOOSE_FACE = 106;
        public static final int ACTION_CLOSE_BARRAGE = 164;
        public static final int ACTION_CLOSE_SUPER_QQ_SHOW = 207;
        public static final int ACTION_COMIC_SWITCH_SECRET_MODE_ = 33;
        public static final int ACTION_CONTENT_FEEDBACK = 223;
        public static final int ACTION_CONTENT_PROMOTION = 211;
        public static final int ACTION_COPYLINK = 1;
        public static final int ACTION_COPY_AVGAME_ROOM_ID = 160;
        public static final int ACTION_COPY_CONTENT = 221;
        public static final int ACTION_COPY_GUILD_NUMBER = 213;
        public static final int ACTION_COPY_SHORT_LINK = 232;
        public static final int ACTION_DAKA = 238;
        public static final int ACTION_DANMU_SETTING = 195;
        public static final int ACTION_DATA_ANALYZE = 209;
        public static final int ACTION_DELETE = 40;
        public static final int ACTION_DELETE_FANS = 137;
        public static final int ACTION_DELETE_HAS_PUSH = 140;
        public static final int ACTION_DELETE_QCIRCLE_ALBUM = 190;
        public static final int ACTION_DIRECT_SEND_TO_FRIEND = 41;
        public static final int ACTION_DIRECT_SEND_TO_STORY = 42;
        public static final int ACTION_DOWNLOAD = 124;
        public static final int ACTION_EDIT = 94;
        public static final int ACTION_EDIT_QCIRCLE_ALBUM = 191;
        public static final int ACTION_EMPTY = 0;
        public static final int ACTION_ENABLE_MINI_GAME_BOX_FLOAT = 208;
        public static final int ACTION_ENTER_FLOAT_WINDOW = 179;
        public static final int ACTION_EXPORT_TENCENT_DOCS = 68;
        public static final int ACTION_FAN_GROUP_MANAGER = 152;
        public static final int ACTION_FAV_DETAIL = 130;
        public static final int ACTION_FAV_GROUP = 129;
        public static final int ACTION_FEED_BIND_QQ_GROUP = 214;
        public static final int ACTION_FILE_CREATE_LINK = 122;
        public static final int ACTION_FILE_CREATE_QR = 123;
        public static final int ACTION_FILE_IMPORT_READER = 118;
        public static final int ACTION_FILE_IMPORT_TXDOC = 119;
        public static final int ACTION_FILE_OPEN_WITH_MINIAPP = 166;
        public static final int ACTION_FILE_PRINT = 121;
        public static final int ACTION_FILE_SAFE_FORWARD = 120;
        public static final int ACTION_FOLLOW = 87;
        public static final int ACTION_FOLLOW_MANAGE = 144;
        public static final int ACTION_FORWARD_TO_LITTLE_WORLD = 184;
        public static final int ACTION_GALLERY_EMOTION_LIST = 65;
        public static final int ACTION_GALLERY_PIC_ADD_TO_EMO = 48;
        public static final int ACTION_GALLERY_PIC_FORWARD_TO_GROUP_ALBUM = 51;
        public static final int ACTION_GALLERY_PIC_FORWARD_TO_QZONE_ALBUM = 50;
        public static final int ACTION_GALLERY_PIC_OCR = 52;
        public static final int ACTION_GALLERY_PIC_OCR_TRANSLATE_MODE = 220;
        public static final int ACTION_GALLERY_PIC_RECO_MINI = 56;
        public static final int ACTION_GALLERY_PIC_RECO_QR = 55;
        public static final int ACTION_GALLERY_PIC_REPORT = 66;
        public static final int ACTION_GALLERY_SHORTVIDEO_OPEN_BY_OTHER_APP = 64;
        public static final int ACTION_GALLERY_VIDEO_MINICODE = 127;
        public static final int ACTION_GALLERY_VIDEO_QRCODE = 126;
        public static final int ACTION_GENERATE_IMAGE = 241;
        public static final int ACTION_GO_FRIEND_AIO = 37;
        public static final int ACTION_GO_SUBSCRIPT_AIO = 30;
        public static final int ACTION_GUILD_COPYLINK = 197;
        public static final int ACTION_GUILD_QR_CODE = 196;
        public static final int ACTION_HIDE_AIO_VIDEO_SUBTITLE = 202;
        public static final int ACTION_HIDE_FEED = 85;
        public static final int ACTION_HIDE_HIM = 86;
        public static final int ACTION_HIDE_THIS_WORK = 141;
        public static final int ACTION_LAUNCH_CHAT = 92;
        public static final int ACTION_LOCATE_TO_CHAT_POS = 54;
        public static final int ACTION_MINIAPP_ABOUT = 78;
        public static final int ACTION_MINIAPP_ADD_TO_MINE = 76;
        public static final int ACTION_MINIAPP_BACK_HOMEPAGE = 81;
        public static final int ACTION_MINIAPP_DEBUG_OFF = 75;
        public static final int ACTION_MINIAPP_DEBUG_ON = 74;
        public static final int ACTION_MINIAPP_EXPORT_CONSOLE_LOG = 169;
        public static final int ACTION_MINIAPP_PERFORMANCE_OFF = 80;
        public static final int ACTION_MINIAPP_PERFORMANCE_ON = 79;
        public static final int ACTION_MINIAPP_REMOVE_FROM_MINE = 77;
        public static final int ACTION_MINIAPP_RESTART_MINIAPP = 128;
        public static final int ACTION_MINI_GAME_SCREEN_RECORD_SHOW = 180;
        public static final int ACTION_MINI_GAME_SCREEN_RECORD_STOP = 182;
        public static final int ACTION_MINI_GAME_SCREEN_RECORD_VIDEO_EDITION = 185;
        public static final int ACTION_MOVE_FEED = 225;
        public static final int ACTION_NOT_CARE = 38;
        public static final int ACTION_ONLY_SEE_FRIEND = 102;
        public static final int ACTION_OPEN_APP_DETAIL = 16;
        public static final int ACTION_OPEN_BARRAGE = 163;
        public static final int ACTION_OPEN_FILE_WITHOUT_DEFAULT_APP = 132;
        public static final int ACTION_OPEN_IN_QQ_BROWSER = 5;
        public static final int ACTION_OPEN_IN_SYS_BROWSER = 4;
        public static final int ACTION_OPEN_SUPER_QQ_SHOW = 206;
        public static final int ACTION_OPEN_WEISHI_ACCOUNT = 45;
        public static final int ACTION_ORDER_LIST = 155;
        public static final int ACTION_PARTY_ROOM_SEND_TO_MATCH_FRIEND = 198;
        public static final int ACTION_PA_REPORT = 36;
        public static final int ACTION_PHOTO_REPAIR = 230;
        public static final int ACTION_PITU = 105;
        public static final int ACTION_PORTAL_ENTER_STYLE_HOME = 205;
        public static final int ACTION_PORTAL_SET_PORTAL_AVATAR = 204;
        public static final int ACTION_PRIVATE_MESSAGE = 138;
        public static final int ACTION_PRIVATE_PERMISSION = 189;
        public static final int ACTION_PROMOTION = 89;
        public static final int ACTION_PUBLIC_PERMISSION = 188;
        public static final int ACTION_PUPU_PRIVACY = 116;
        public static final int ACTION_PUPU_PRIVACY_CANCEL = 117;
        public static final int ACTION_PUSH_RAN_COMMENT = 239;
        public static final int ACTION_QCIRCLE_ENTER_FLOATING_WINDOW = 216;
        public static final int ACTION_QCIRCLE_PRIVATE_MESSAGE = 162;
        public static final int ACTION_REFRESH_TROOP_APP_VIEW = 18;
        public static final int ACTION_REMOVE_COLOR_NOTE = 82;
        public static final int ACTION_REMOVE_FAVORITE = 84;
        public static final int ACTION_REMOVE_TOP = 187;
        public static final int ACTION_REPORT = 11;
        public static final int ACTION_REPORT_DIS_LIKE = 44;
        public static final int ACTION_REPORT_VIDEO_NOT_LIKE = 22;
        public static final int ACTION_REPRINT_BLOG = 101;
        public static final int ACTION_REPRINT_PHOTO = 100;
        public static final int ACTION_RIJ_COINED = 193;
        public static final int ACTION_RIJ_NO_COIN = 194;
        public static final int ACTION_RIJ_VIDEO_SETTING = 165;
        public static final int ACTION_RIJ_WATCH_WORD = 133;
        public static final int ACTION_SAVE = 39;
        public static final int ACTION_SAVE_OTHER_PATH = 229;
        public static final int ACTION_SAVE_PIC = 43;
        public static final int ACTION_SAVE_QRCODE = 210;
        public static final int ACTION_SCALE_TO_FLOAT_WINDOW = 168;
        public static final int ACTION_SCREEN_LONG_SHOT = 71;
        public static final int ACTION_SEND_TO_CHANNEL = 171;
        public static final int ACTION_SEND_TO_CLIPBOARD = 28;
        public static final int ACTION_SEND_TO_DIANDIAN = 34;
        public static final int ACTION_SEND_TO_EVERNOTE = 91;
        public static final int ACTION_SEND_TO_FRIEND = 2;
        public static final int ACTION_SEND_TO_MAIL = 25;
        public static final int ACTION_SEND_TO_MORE_FRIEND = 73;
        public static final int ACTION_SEND_TO_PC = 26;
        public static final int ACTION_SEND_TO_QIDIAN = 19;
        public static final int ACTION_SEND_TO_QIYEQQ = 20;
        public static final int ACTION_SEND_TO_QZONE = 3;
        public static final int ACTION_SEND_TO_READINJOY = 13;
        public static final int ACTION_SEND_TO_SINA = 12;
        public static final int ACTION_SEND_TO_SPECIFIED_FRIEND = 72;
        public static final int ACTION_SEND_TO_STORY_DISCOVER = 29;
        public static final int ACTION_SEND_TO_TENCENT_DOCS = 222;
        public static final int ACTION_SEND_TO_WECHAT = 9;
        public static final int ACTION_SEND_TO_WECHAT_CIRCLE = 10;
        public static final int ACTION_SEND_TO_WEIYUN = 27;
        public static final int ACTION_SEND_TO_XHS = 218;
        public static final int ACTION_SETTING = 83;
        public static final int ACTION_SET_BACKGROUND = 107;
        public static final int ACTION_SET_DRESS = 98;
        public static final int ACTION_SET_MINIAPP_TO_TROOP = 158;
        public static final int ACTION_SET_PRIVATE = 95;
        public static final int ACTION_SET_QQ_PROFILE_COVER = 231;
        public static final int ACTION_SET_TOP = 96;
        public static final int ACTION_SET_TOP_FEED = 242;
        public static final int ACTION_SET_TOP_FEED_IN_SECTION = 244;
        public static final int ACTION_SHARE_PICTURE = 153;
        public static final int ACTION_SHARE_TO_LITTLE_WORLD = 203;
        public static final int ACTION_SHARE_TO_QZONE_INTIMATE_SPACE = 219;
        public static final int ACTION_SHARE_TROOP_APP = 17;
        public static final int ACTION_SHOW_AIO_VIDEO_SUBTITLE = 201;
        public static final int ACTION_SHOW_FEED_BACKGROUND_MUSIC = 217;
        public static final int ACTION_SHOW_MORE_INFO = 31;
        public static final int ACTION_SHOW_ORIGINALURL = 131;
        public static final int ACTION_SHOW_SOURCE_IMAGE = 212;
        public static final int ACTION_SMALL_HOME_BG = 200;
        public static final int ACTION_STORE_MANAGER = 157;
        public static final int ACTION_SYNC_QZONE = 154;
        public static final int ACTION_TAKE_SCREEN_SHOT = 21;
        public static final int ACTION_TIMI_CF_TEAM_UP = 176;
        public static final int ACTION_TIMI_CODM_TEAM_UP = 175;
        public static final int ACTION_TIMI_CURRENT_LIVE = 177;
        public static final int ACTION_TIMI_HEPING_TEAM_UP = 174;
        public static final int ACTION_TIMI_KING_TEAM_UP = 172;
        public static final int ACTION_TIMI_SEND_TO_EXPAND_FRIEND = 178;
        public static final int ACTION_TIMI_SPEED_TEAM_UP = 173;
        public static final int ACTION_TORT_REPORT = 170;
        public static final int ACTION_TRIBE_ADD_TO_DIGEST = 145;
        public static final int ACTION_TRIBE_CANCEL_DIGEST = 146;
        public static final int ACTION_TRIBE_FEEDBACK = 151;
        public static final int ACTION_TRIBE_INTEREST = 147;
        public static final int ACTION_TRIBE_LOOK_OWNER = 148;
        public static final int ACTION_TRIBE_PULL_BLACK = 150;
        public static final int ACTION_TRIBE_PUSH_TOPIC = 149;
        public static final int ACTION_TROOP_REVOKE_MSG = 228;
        public static final int ACTION_UNFOLLOW = 32;
        public static final int ACTION_UN_SET_TOP = 97;
        public static final int ACTION_UN_SET_TOP_FEED = 243;
        public static final int ACTION_UN_SET_TOP_FEED_IN_SECTION = 245;
        public static final int ACTION_VIDEO_PASTER = 192;
        public static final int ACTION_VIDEO_PLAY_FEEDBACK = 161;
        public static final int ACTION_VIEW_DRESS = 99;
        public static final int ACTION_VIEW_PUB_ACCOUNT = 8;
        public static final int ACTION_WATCH_LATER = 236;
        public static final int ACTION_WATCH_ON_TV = 104;
        public static final int ACTION_WATCH_ORIGINAL_VIDEO = 88;
        public static final int ACTION_ZPLAN_SMALL_HOME_SET_BACKGROUND = 199;

        /* renamed from: b, reason: collision with root package name */
        private static final int[] f307292b = {R.drawable.qui_check_account, R.drawable.qui_complaint, R.drawable.cp5, R.drawable.cp7, R.drawable.qui_add, R.drawable.qui_chat_settings, R.drawable.qui_share, R.drawable.qui_refresh, R.drawable.nco, R.drawable.ncp, R.drawable.qui_scan, R.drawable.cch, R.drawable.f160517ch1, R.drawable.dlv, R.drawable.dlx, R.drawable.ffc, R.drawable.fkd, R.drawable.ccm, R.drawable.dlm, R.drawable.dte, R.drawable.clp, R.drawable.qui_miniapp, R.drawable.clq, R.drawable.clr, R.drawable.qui_emoticon, R.drawable.qui_computer_feedback_normal, R.drawable.qui_qqdocs, R.drawable.f162380ou1, R.drawable.f160830com, R.drawable.qui_more, R.drawable.dgd, R.drawable.cn9, R.drawable.n1c, R.drawable.qui_star, R.drawable.qui_star_off, R.drawable.d5l, R.drawable.nkr, R.drawable.nkp, R.drawable.qui_hometown, R.drawable.qui_debug, R.drawable.qui_setting, R.drawable.dls, R.drawable.qui_set_top_off, R.drawable.qui_set_top, R.drawable.qui_lock, R.drawable.qui_skin, R.drawable.qui_greeting, R.drawable.qui_collection, R.drawable.qui_share_feedback_normal, R.drawable.qui_edit, R.drawable.f160376oh2, R.drawable.qui_collection_off, R.drawable.qui_eye_off, R.drawable.qui_add_friend, R.drawable.qui_remove_user, R.drawable.qui_delete, R.drawable.nwu, R.drawable.nwv, R.drawable.nx_, R.drawable.qui_set_background, R.drawable.qui_contact, R.drawable.dls, R.drawable.qui_edit, R.drawable.qui_safety_feedback_normal, R.drawable.qui_printer, R.drawable.qui_move_to_group, R.drawable.qui_collection_detail, R.drawable.qui_url, R.drawable.qui_change_app, R.drawable.jrk, R.drawable.jrl, R.drawable.jrg, R.drawable.jrh, R.drawable.qui_mail, R.drawable.qui_group_application, R.drawable.n__, R.drawable.ke8, R.drawable.n_8, R.drawable.qui_remark, R.drawable.qui_rec, R.drawable.qui_record_stop, R.drawable.f160864mz0, R.drawable.f160865mz1, R.drawable.qui_set_top, R.drawable.qui_set_top_off, R.drawable.qui_recall, R.drawable.os7, R.drawable.qvideo_skin_icon_authority_global_primary, R.drawable.os8, R.drawable.otb, R.drawable.ofd, R.drawable.ofe, R.drawable.qui_computer_feedback_normal, R.drawable.oh5, R.drawable.qui_transmission_file_feedback_normal, R.drawable.qui_more_feedback_normal, R.drawable.ohi, R.drawable.oh7, R.drawable.f160374oh0, R.drawable.qui_channel_feedback_normal, R.drawable.oj5, R.drawable.oh9, R.drawable.qui_mini_program_feedback_normal, R.drawable.nks, R.drawable.qui_image_feedback_normal, R.drawable.qui_image, R.drawable.ohe, R.drawable.oh8, R.drawable.ohd, R.drawable.qui_weiyun_feedback_normal, R.drawable.ohj, R.drawable.ohb, R.drawable.qui_info_circle, R.drawable.qui_caiqian_on, R.drawable.qui_add_emoji, R.drawable.qui_add_friend, R.drawable.qui_phone, R.drawable.qui_typeface, R.drawable.qui_shield_circle, R.drawable.qui_caiqian_off, R.drawable.qui_download, R.drawable.qui_collection, R.drawable.qui_link, R.drawable.qui_qrcode, R.drawable.qui_target_to_chat, R.drawable.qui_long_screenshot, R.drawable.qui_message, R.drawable.qui_complaint, R.drawable.qui_textextract, R.drawable.qui_heart_off, R.drawable.qui_collection_form, R.drawable.qui_subtitle_off, R.drawable.qui_subtitle_on, R.drawable.qui_screenshot, R.drawable.qui_picture_in_picture, R.drawable.qui_copy, R.drawable.qui_hide_state, R.drawable.qui_avatar, R.drawable.qui_try_on, R.drawable.qui_super_qqshow_open, R.drawable.qui_super_qqshow_open_night, R.drawable.qui_super_qqshow_close, R.drawable.qui_super_qqshow_close_night, R.drawable.qui_mini_game_box, R.drawable.qui_rank, R.drawable.qui_promotion, R.drawable.qui_search_detail, R.drawable.qui_group, R.drawable.nkt, R.drawable.nkv, R.drawable.nku, R.drawable.qui_picture_in_picture, R.drawable.ohc, R.drawable.qui_image_reprint_normal, R.drawable.qui_music, R.drawable.qui_translate, R.drawable.ohk, R.drawable.qui_translate, R.drawable.qui_copy, R.drawable.nkw, R.drawable.qui_key, R.drawable.qui_copy, R.drawable.qui_music, R.drawable.qui_move, R.drawable.qui_batch, R.drawable.qui_image_aio_oversized, R.drawable.qui_download, R.drawable.qui_set_top, R.drawable.qui_set_top_off, R.drawable.qui_watch_later, R.drawable.qui_cancel_watch_later, R.drawable.qui_pin_to_top_oversized, R.drawable.qui_cancel_to_top_oversized};

        /* renamed from: c, reason: collision with root package name */
        private static final int[] f307293c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f307294d;

        /* renamed from: a, reason: collision with root package name */
        private IllegalStateException f307295a;
        public int firstLineCount;
        public String guildId;

        /* renamed from: id, reason: collision with root package name */
        public int f307296id;
        public View.OnClickListener listener;
        public String matchFriendAvatarUrl;
        public String reportID;
        public String uin;
        public int uinType;
        public int icon = 0;
        public Drawable iconDrawable = null;
        public Drawable badgeIconDrawable = null;
        public boolean iconNeedBg = true;
        public String label = null;
        public int action = 0;
        public String argus = null;
        public int visibility = 0;
        public boolean enable = true;
        public int source = 2;
        public Bundle extraData = new Bundle();
        public boolean showRedDot = false;

        static {
            int[] iArr;
            HashSet hashSet = new HashSet();
            int i3 = 0;
            while (true) {
                iArr = f307292b;
                if (i3 >= iArr.length) {
                    break;
                }
                if (hashSet.contains(Integer.valueOf(iArr[i3]))) {
                    BaseApplication context = BaseApplication.getContext();
                    if (context != null) {
                        QLog.e("ShareActionSheetBuilder", 1, "static initializer() called duplicated icon " + i3 + ", " + context.getResources().getResourceEntryName(iArr[i3]));
                    } else {
                        QLog.e("ShareActionSheetBuilder", 1, "static initializer() called duplicated icon " + i3);
                    }
                } else {
                    hashSet.add(Integer.valueOf(iArr[i3]));
                }
                i3++;
            }
            Arrays.sort(iArr);
            f307293c = new int[]{R.string.w7l, R.string.w7r, R.string.w7s, R.string.w6x, R.string.f227106q5, R.string.w6y, R.string.w6z, R.string.w7i, R.string.w7v, R.string.w87, R.string.f227136q8, R.string.f173135w84, R.string.w85, R.string.w86, R.string.f173132w81, R.string.w6w, R.string.w7o, R.string.w7q, R.string.w7k, R.string.w7m, R.string.f173134w83, R.string.f173125w74, R.string.w7n, R.string.w7z, R.string.w7x, R.string.w7y, R.string.w75, R.string.w7t, R.string.w7c, R.string.f227306qo, R.string.f227126q7, R.string.f227116q6, R.string.w7_, R.string.w78, R.string.w7a, R.string.w79, R.string.w7b, R.string.w7h, R.string.w7e, R.string.w7f, R.string.w6v, R.string.w77, R.string.w7p, R.string.w7w, R.string.w76, R.string.f173131w80, R.string.f187533u9, R.string.w7g, R.string.f173121w70, R.string.f173124w73, R.string.f173123w72, R.string.f173122w71, R.string.f173133w82, R.string.w7u, R.string.f227346qs, R.string.f227256qj, R.string.f227146q9, R.string.w7d, R.string.f227316qp, R.string.wcr, R.string.wcs, R.string.wd9, R.string.wcw, R.string.wci, R.string.wcj, R.string.eif, R.string.eii, R.string.eil, R.string.eik, R.string.f171311dy3, R.string.d7a, R.string.wde, R.string.wcp, R.string.f227206qe, R.string.wcq, R.string.wco, R.string.wdf, R.string.wdi, R.string.wcx, R.string.wce, R.string.wcn, R.string.wct, R.string.wcm, R.string.wdb, R.string.wdc, R.string.wdd, R.string.wda, R.string.wdg, R.string.wd8, R.string.wcu, R.string.wcf, R.string.wck, R.string.wdh, R.string.wcv, R.string.wch, R.string.wd_, R.string.d7a, R.string.wxt, R.string.wxs, R.string.wxu, R.string.f186783s8, R.string.wd6, R.string.wcx, R.string.wce, R.string.wd6, R.string.wx6, R.string.wxo, R.string.wx8, R.string.wxc, R.string.wxn, R.string.wx7, R.string.wxa, R.string.f226736p5, R.string.wxb, R.string.wxa, R.string.wx9, R.string.wxd, R.string.wxf, R.string.wx_, R.string.wx5, R.string.wxe, R.string.f227176qb, R.string.wxg, R.string.wxh, R.string.wxj, R.string.wxk, R.string.wxm, R.string.wxl, R.string.wxi, R.string.wcg, R.string.wcl, R.string.ztm, R.string.ztl, R.string.dym, R.string.f226906pl, R.string.f227266qk, R.string.f227196qd, R.string.f227026px, R.string.f227036py, R.string.f227016pw, R.string.f226996pu, R.string.f226986pt, R.string.f227006pv, R.string.f227166qa, R.string.f226966pr, R.string.f226976ps, R.string.f195594f1, R.string.f226916pm, R.string.f226936po, R.string.f226926pn, R.string.f227236qh, R.string.f226916pm, R.string.f226806pb, R.string.f226816pc, R.string.f227526r_, R.string.f227386qw, R.string.f226896pk, R.string.f226886pj, R.string.f227086q3, R.string.f226886pj, R.string.f226646ow, R.string.f226636ov, R.string.f226786p_, R.string.f227156q_, R.string.f227376qv, R.string.f227466r4, R.string.f227076q2, R.string.f227096q4, R.string.f226766p8, R.string.f226746p6, R.string.f226866ph, R.string.f227416qz, R.string.f227396qx, R.string.f226836pe, R.string.f226826pd, R.string.f195584f0, R.string.f226846pf, R.string.f227366qu, R.string.f227356qt, R.string.f226726p4, R.string.f227336qr, R.string.f226726p4, R.string.f227356qt, R.string.f227366qu, R.string.f226846pf, R.string.f226776p9, R.string.f226696p1, R.string.f226716p3, R.string.f227326qq, R.string.f226686p0, R.string.f226676oz, R.string.f227066q1, R.string.f226706p2, R.string.f226796pa, R.string.f226876pi, R.string.f226756p7, R.string.f226946pp, R.string.f227046pz, R.string.f226956pq, R.string.f227056q0};
            HashSet hashSet2 = new HashSet();
            int i16 = 0;
            while (true) {
                int[] iArr2 = f307293c;
                if (i16 < iArr2.length) {
                    if (hashSet2.contains(Integer.valueOf(iArr2[i16]))) {
                        if (BaseApplication.getContext() != null) {
                            QLog.e("ShareActionSheetBuilder", 1, "static initializer() called duplicated label " + i16 + ", " + BaseApplication.getContext().getResources().getResourceEntryName(iArr2[i16]));
                        } else {
                            QLog.e("ShareActionSheetBuilder", 1, "static initializer() called duplicated label " + i16 + ", ");
                        }
                    } else {
                        hashSet2.add(Integer.valueOf(iArr2[i16]));
                    }
                    i16++;
                } else {
                    Arrays.sort(iArr2);
                    f307294d = false;
                    return;
                }
            }
        }

        ActionSheetItem() {
            if (!new Throwable().getStackTrace()[1].getClassName().equals(ActionSheetItem.class.getName())) {
                IllegalStateException illegalStateException = new IllegalStateException("Must use method com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem.build(int) to create me !");
                this.f307295a = illegalStateException;
                QLog.e("ShareActionSheetBuilder", 1, "ActionSheetItem: ", illegalStateException);
            }
        }

        private static ActionSheetItem A() {
            return c(R.string.wcg, "carton_detail");
        }

        private static ActionSheetItem A0() {
            return a(R.drawable.qui_long_screenshot, R.string.w7k, "long_screenshot");
        }

        private static ActionSheetItem A1() {
            return a(R.drawable.qui_scan, R.string.w7y, "scan_qrcode");
        }

        private static ActionSheetItem A2() {
            return a(R.drawable.nwu, R.string.wdh, "watch_on_tv");
        }

        private static ActionSheetItem B() {
            return a(R.drawable.qui_check_account, R.string.dym, "check_profile");
        }

        private static ActionSheetItem B0() {
            return a(R.drawable.qui_debug, R.string.w79, "applet_closeperformance");
        }

        private static ActionSheetItem B1() {
            return a(R.drawable.qui_screenshot, R.string.f173121w70, "Screenshot_share");
        }

        private static ActionSheetItem B2() {
            return c(R.string.wdi, "orignal");
        }

        private static ActionSheetItem C() {
            return a(R.drawable.nx_, R.string.wch, "rec_face");
        }

        private static ActionSheetItem C0() {
            return a(R.drawable.qui_debug, R.string.w7a, "applet_openperformance");
        }

        private static ActionSheetItem C1() {
            return a(R.drawable.oj5, R.string.f227106q5, "guild_channel");
        }

        private static ActionSheetItem C2() {
            return a(R.drawable.qui_try_on, R.string.f227096q4, "portal_enter_stylehome");
        }

        private static ActionSheetItem D() {
            return c(R.string.ztl, "close_viola_barrage");
        }

        private static ActionSheetItem D0() {
            return a(R.drawable.qui_group_application, R.string.f227116q6, "add_to_group");
        }

        private static ActionSheetItem D1() {
            return a(R.drawable.f160376oh2, R.string.wcn, "Evernote");
        }

        private static ActionSheetItem D2() {
            return a(R.drawable.qui_avatar, R.string.f227076q2, "portal_set_portalavatar");
        }

        private static ActionSheetItem E() {
            return a(R.drawable.qui_debug, R.string.w78, "applet_closedebug");
        }

        private static ActionSheetItem E0() {
            return a(R.drawable.qui_group_application, R.string.f227126q7, "group_app");
        }

        private static ActionSheetItem E1() {
            return a(R.drawable.oh9, R.string.w6x, "Qfriend");
        }

        private static ActionSheetItem E2() {
            return a(R.drawable.qui_image, R.string.f227086q3, "xiaowo_set_background");
        }

        private static ActionSheetItem F(boolean z16) {
            int i3;
            String str;
            if (z16) {
                i3 = R.string.f226886pj;
            } else {
                i3 = R.string.f226896pk;
            }
            if (z16) {
                str = "rij_coined";
            } else {
                str = "rij_no_coin";
            }
            return c(i3, str);
        }

        private static ActionSheetItem F0() {
            return a(R.drawable.qui_more, R.string.d7a, "share_more");
        }

        private static ActionSheetItem F1() {
            return a(R.drawable.oh5, R.string.f227236qh, "email");
        }

        private static boolean F2() {
            if (!QQTheme.isNowThemeIsNight() && !f307294d) {
                return false;
            }
            return true;
        }

        private static ActionSheetItem G() {
            return a(R.drawable.qui_heart_off, R.string.f226716p3, "content_feedback");
        }

        private static ActionSheetItem G0() {
            return a(R.drawable.qui_move, R.string.f226776p9, "move_feed");
        }

        private static ActionSheetItem G1() {
            return a(R.drawable.ohd, R.string.w6y, "Qzone");
        }

        private static ActionSheetItem H() {
            return a(R.drawable.qui_copy, R.string.f227376qv, "send_to_clipboard");
        }

        private static ActionSheetItem H0() {
            int i3;
            int i16;
            if (com.tencent.mobileqq.filemanager.fileassistant.util.h.o()) {
                i3 = R.string.f187533u9;
                i16 = R.drawable.qui_transmission_file_feedback_normal;
            } else {
                i3 = R.string.f173131w80;
                i16 = R.drawable.qui_computer_feedback_normal;
            }
            return a(i16, i3, "sent_pc");
        }

        private static ActionSheetItem H1() {
            return a(R.drawable.nkw, R.string.f227336qr, "send_to_tencent_docs");
        }

        private static ActionSheetItem I() {
            return a(R.drawable.qui_copy, R.string.f227396qx, "guild_copy_number");
        }

        private static ActionSheetItem I0() {
            return a(R.drawable.qui_shield_circle, R.string.w7m, "not_care");
        }

        private static ActionSheetItem I1() {
            return a(R.drawable.oh7, R.string.w85, "wechat_");
        }

        private static ActionSheetItem J() {
            return a(R.drawable.qui_link, R.string.w7g, "copy_short_link");
        }

        private static ActionSheetItem J0() {
            return a(R.drawable.qui_heart_off, R.string.f173133w82, "uninterested");
        }

        private static ActionSheetItem J1() {
            return a(R.drawable.ohi, R.string.f173135w84, "wechat");
        }

        private static ActionSheetItem K() {
            return a(R.drawable.qui_link, R.string.w7g, WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK);
        }

        private static ActionSheetItem K0() {
            return a(R.drawable.qui_contact, R.string.wcu, "only_friend");
        }

        private static ActionSheetItem K1() {
            return a(R.drawable.qui_weiyun_feedback_normal, R.string.w87, "weiyun");
        }

        private static ActionSheetItem L() {
            return a(R.drawable.qui_copy, R.string.f226726p4, "copy_content");
        }

        private static ActionSheetItem L0() {
            return a(R.drawable.qui_message, R.string.w7n, "open_aio");
        }

        private static ActionSheetItem L1() {
            return a(R.drawable.ohj, R.string.w86, "weibo");
        }

        private static ActionSheetItem M() {
            return a(R.drawable.qui_link, R.string.wci, "generate_link");
        }

        private static ActionSheetItem M0() {
            return c(R.string.ztm, "open_viola_barrage");
        }

        private static ActionSheetItem M1() {
            return a(R.drawable.ohk, R.string.f227366qu, "send_to_xhs");
        }

        private static ActionSheetItem N() {
            return a(R.drawable.qui_qrcode, R.string.wcj, "generate_QRcode");
        }

        private static ActionSheetItem N0() {
            return a(R.drawable.qui_change_app, R.string.f186783s8, "other_app");
        }

        private static ActionSheetItem N1() {
            return a(R.drawable.qui_set_background, R.string.wd_, "set_background");
        }

        private static ActionSheetItem O() {
            return c(R.string.wxo, "kouling_share");
        }

        private static ActionSheetItem O0() {
            return a(R.drawable.qui_debug, R.string.w7_, "applet_opendebug");
        }

        private static ActionSheetItem O1() {
            return a(R.drawable.qui_skin, R.string.wda, "set_card");
        }

        private static ActionSheetItem P() {
            return c(R.string.f227386qw, "danmu_setting");
        }

        private static ActionSheetItem P0() {
            return a(R.drawable.qui_mini_program_feedback_normal, R.string.f227266qk, "open_with_miniapp");
        }

        private static ActionSheetItem P1() {
            return a(R.drawable.qui_lock, R.string.wdb, "privacy");
        }

        private static ActionSheetItem Q() {
            return a(R.drawable.qui_rank, R.string.f226746p6, "data_analyze");
        }

        private static ActionSheetItem Q0() {
            return c(R.string.wx_, "orderlist");
        }

        private static ActionSheetItem Q1() {
            return a(R.drawable.qui_qqcover, R.string.f227476r5, "set_qq_profile_cover");
        }

        private static ActionSheetItem R() {
            return a(R.drawable.qui_delete, R.string.wck, "delete");
        }

        private static ActionSheetItem R0() {
            return a(R.drawable.qui_more_feedback_normal, R.string.w7o, "other_app");
        }

        private static ActionSheetItem R1() {
            return a(R.drawable.qui_set_top, R.string.wdc, "stick");
        }

        private static ActionSheetItem S() {
            return a(R.drawable.qui_delete, R.string.f226806pb, "delete_alnum");
        }

        private static ActionSheetItem S0() {
            return a(R.drawable.qui_retouch, R.string.f227276ql, "photo_repair");
        }

        private static ActionSheetItem S1() {
            return a(R.drawable.qui_lock, R.string.f226786p_, QCircleDaTongConstant.ElementParamValue.SET_PERMISSION);
        }

        private static ActionSheetItem T() {
            return c(R.string.wx7, "delete_fans");
        }

        private static ActionSheetItem T0() {
            return a(R.drawable.nwv, R.string.wcv, "psapp");
        }

        private static ActionSheetItem T1() {
            return a(R.drawable.qui_image, R.string.wxd, "sharepicture");
        }

        private static ActionSheetItem U() {
            return a(R.drawable.ke8, R.string.wxb, "delete_launch");
        }

        private static ActionSheetItem U0() {
            return a(R.drawable.qui_printer, R.string.wcw, "print");
        }

        private static ActionSheetItem U1() {
            int i3;
            if (com.dataline.util.j.a()) {
                i3 = R.drawable.ohc;
            } else {
                i3 = R.drawable.ohb;
            }
            ActionSheetItem actionSheetItem = new ActionSheetItem();
            actionSheetItem.icon = i3;
            actionSheetItem.label = com.tencent.mobileqq.widget.az.g(R.string.f195594f1);
            actionSheetItem.reportID = WinkDaTongReportConstant.ElementParamValue.LITTLE_WORLD;
            return actionSheetItem;
        }

        private static ActionSheetItem V() {
            return c(R.string.wcl, "download");
        }

        private static ActionSheetItem V0() {
            return a(R.drawable.qui_mail, R.string.wxa, "private_chat");
        }

        private static ActionSheetItem V1() {
            return a(R.drawable.ohc, R.string.f195594f1, "qcircle");
        }

        private static ActionSheetItem W() {
            return a(R.drawable.qui_edit, R.string.wcm, "edit");
        }

        private static ActionSheetItem W0() {
            return a(R.drawable.qui_firelike, R.string.f227456r3, "push_ran_comment");
        }

        private static ActionSheetItem W1() {
            return a(R.drawable.f160378oh4, R.string.f227226qg, "send_to_intimate_space");
        }

        private static ActionSheetItem X() {
            return a(R.drawable.qui_mini_game_box, R.string.f226766p8, "enable_minigame_box_float");
        }

        private static ActionSheetItem X0() {
            return a(R.drawable.qui_setting, R.string.w7q, "push_setup");
        }

        private static ActionSheetItem X1() {
            return c(R.string.wxe, "store_manage");
        }

        private static ActionSheetItem Y() {
            return a(R.drawable.qui_qqdocs, R.string.f173134w83, "url_to_txdoc");
        }

        private static ActionSheetItem Y0() {
            return a(R.drawable.qui_picture_in_picture, R.string.f226826pd, "qcircle_enter_floating_window");
        }

        private static ActionSheetItem Y1() {
            return a(R.drawable.qui_search_detail, R.string.f227416qz, "qui_search_detail");
        }

        private static ActionSheetItem Z() {
            return a(R.drawable.qui_debug, R.string.w7b, "applet_vconsolelog");
        }

        private static ActionSheetItem Z0() {
            return a(R.drawable.qui_group, R.string.f226836pe, "feed_bind_qq_group");
        }

        private static ActionSheetItem Z1() {
            return c(R.string.f227486r6, "xiaowo_group_background");
        }

        private static ActionSheetItem a(int i3, int i16, String str) {
            return b(i3, i16, str, BaseApplication.getContext().getResources());
        }

        private static ActionSheetItem a0() {
            return a(R.drawable.qui_textextract, R.string.w7p, "pick_words");
        }

        private static ActionSheetItem a1() {
            return a(R.drawable.qui_music, R.string.f226846pf, "open_music_aggregation_page");
        }

        private static ActionSheetItem a2(boolean z16) {
            int i3;
            int i16;
            String str;
            if (z16) {
                i3 = R.drawable.qui_subtitle_on;
            } else {
                i3 = R.drawable.qui_subtitle_off;
            }
            if (z16) {
                i16 = R.string.f226646ow;
            } else {
                i16 = R.string.f226636ov;
            }
            if (z16) {
                str = "aio_video_action_sheet_show_subtitle";
            } else {
                str = "aio_video_action_sheet_hide_subtitle";
            }
            return a(i3, i16, str);
        }

        private static ActionSheetItem b(int i3, int i16, String str, Resources resources) {
            ActionSheetItem actionSheetItem = new ActionSheetItem();
            actionSheetItem.icon = i3;
            actionSheetItem.label = resources.getString(i16);
            actionSheetItem.reportID = str;
            return actionSheetItem;
        }

        private static ActionSheetItem b0() {
            return a(R.drawable.qui_collection_detail, R.string.wxs, "fav_detail");
        }

        private static ActionSheetItem b1() {
            return a(R.drawable.qui_promotion, R.string.f226866ph, "qcircle_promotion");
        }

        private static ActionSheetItem b2(boolean z16) {
            int i3;
            int i16;
            String str;
            if (z16) {
                i3 = R.drawable.qui_super_qqshow_open;
            } else {
                i3 = R.drawable.qui_super_qqshow_close;
            }
            if (z16) {
                i16 = R.string.f226666oy;
            } else {
                i16 = R.string.f226656ox;
            }
            if (z16) {
                str = "open_super_qq_show";
            } else {
                str = "close_super_qq_show";
            }
            return a(i3, i16, str);
        }

        public static ActionSheetItem build(int i3, boolean z16) {
            f307294d = z16;
            ActionSheetItem build = build(i3);
            f307294d = false;
            return build;
        }

        private static ActionSheetItem c(int i3, String str) {
            return b(R.drawable.qui_complaint, i3, str, BaseApplication.getContext().getResources());
        }

        private static ActionSheetItem c0() {
            return a(R.drawable.qui_move_to_group, R.string.wxt, "fav_group");
        }

        private static ActionSheetItem c1() {
            return a(R.drawable.oh8, R.string.w6w, "Qbrowser");
        }

        private static ActionSheetItem c2() {
            return c(R.string.wxf, "Sync_zone");
        }

        private static ActionSheetItem d() {
            return a(R.drawable.qui_info_circle, R.string.f173122w71, "about");
        }

        private static ActionSheetItem d0() {
            return a(R.drawable.qui_url, R.string.wxu, "fav_show_originalurl");
        }

        private static ActionSheetItem d1() {
            return a(R.drawable.qui_qrcode, R.string.w6v, "QRcode");
        }

        private static ActionSheetItem d2() {
            return c(R.string.f226986pt, "cf_team_up");
        }

        private static ActionSheetItem e() {
            int i3;
            if (F2()) {
                i3 = R.drawable.jrl;
            } else {
                i3 = R.drawable.jrk;
            }
            return a(i3, R.string.wce, "ad_block");
        }

        private static ActionSheetItem e0() {
            return a(R.drawable.qui_collection, R.string.w7d, QCircleDaTongConstant.ElementParamValue.COLLECT);
        }

        private static ActionSheetItem e1() {
            return a(R.drawable.ohe, R.string.w6z, "Qzone_album");
        }

        private static ActionSheetItem e2() {
            return c(R.string.f226996pu, "codm_team_up");
        }

        private static ActionSheetItem f() {
            int i3;
            if (F2()) {
                i3 = R.drawable.jrh;
            } else {
                i3 = R.drawable.jrg;
            }
            return a(i3, R.string.wcx, "ad_promotion");
        }

        private static ActionSheetItem f0() {
            return a(R.drawable.qui_pin_to_top_oversized, R.string.f226956pq, "top_feed_in_section");
        }

        private static ActionSheetItem f1() {
            return c(R.string.f226856pg, "qcircle_private_message");
        }

        private static ActionSheetItem f2() {
            return c(R.string.f227006pv, "current_live");
        }

        private static ActionSheetItem g() {
            return a(R.drawable.qui_caiqian_on, R.string.w7e, "colornote");
        }

        private static ActionSheetItem g0() {
            return a(R.drawable.qui_cancel_to_top_oversized, R.string.f227056q0, "un_top_feed_in_section");
        }

        private static ActionSheetItem g1() {
            return a(R.drawable.nco, R.string.w7r, "qidian");
        }

        private static ActionSheetItem g2() {
            return c(R.string.f227016pw, "heping_team_up");
        }

        private static ActionSheetItem h() {
            return a(R.drawable.qui_add_emoji, R.string.f173124w73, "add_emotion");
        }

        private static ActionSheetItem h0() {
            return a(R.drawable.qui_set_top, R.string.f226946pp, "top_feed");
        }

        private static ActionSheetItem h1() {
            F2();
            return a(R.drawable.ncp, R.string.w7s, "qiyeqq");
        }

        private static ActionSheetItem h2() {
            return c(R.string.f227026px, "king_team_up");
        }

        private static ActionSheetItem i() {
            return a(R.drawable.qui_add_friend, R.string.f173125w74, LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND);
        }

        private static ActionSheetItem i0() {
            return a(R.drawable.qui_set_top_off, R.string.f227046pz, "un_top_feed");
        }

        private static ActionSheetItem i1() {
            return a(R.drawable.qui_rec, R.string.f226966pr, "open_bubble");
        }

        private static ActionSheetItem i2() {
            return c(R.string.f227036py, "speed_team_up");
        }

        private static ActionSheetItem j() {
            return c(R.string.wx5, "adding goods");
        }

        private static ActionSheetItem j0() {
            return a(R.drawable.qui_picture_in_picture, R.string.f227166qa, "float_window");
        }

        private static ActionSheetItem j1() {
            return a(R.drawable.qui_record_stop, R.string.f226976ps, "finish_record");
        }

        private static ActionSheetItem j2() {
            return c(R.string.f227346qs, "tort_report");
        }

        private static ActionSheetItem k() {
            return a(R.drawable.qui_phone, R.string.f173123w72, "add_desktop");
        }

        private static ActionSheetItem k0() {
            return a(R.drawable.qui_add_friend, R.string.wco, "follow");
        }

        private static ActionSheetItem k1() {
            return c(R.string.f226916pm, "edit_video");
        }

        private static ActionSheetItem k2() {
            return a(R.drawable.qui_translate, R.string.f227356qt, CanvasView.ACTION_TRANSLATE);
        }

        private static ActionSheetItem l() {
            return a(R.drawable.qui_star, R.string.w75, "add_my");
        }

        private static ActionSheetItem l0() {
            return a(R.drawable.qui_setting, R.string.f227176qb, "follow_manage");
        }

        private static ActionSheetItem l1() {
            return a(R.drawable.qui_caiqian_off, R.string.w7f, "colornote_cancel");
        }

        private static ActionSheetItem l2() {
            return c(R.string.wxg, "add_to_digest");
        }

        private static ActionSheetItem m() {
            return a(R.drawable.qui_set_top, R.string.f227286qm, "add_top");
        }

        private static ActionSheetItem m0() {
            return a(R.drawable.qui_image, R.string.f227186qc, "generate_image");
        }

        private static ActionSheetItem m1() {
            return a(R.drawable.qui_collection_off, R.string.wde, QCircleDaTongConstant.ElementParamValue.COLLECT_CANCEL);
        }

        private static ActionSheetItem m2() {
            return c(R.string.wxh, "cancel_digest");
        }

        private static ActionSheetItem n() {
            return a(R.drawable.qui_typeface, R.string.w76, "adjust_font");
        }

        private static ActionSheetItem n0() {
            return a(R.drawable.qui_message, R.string.d5p, "open_aio");
        }

        private static ActionSheetItem n1() {
            return a(R.drawable.qui_star_off, R.string.w7t, "remove_my");
        }

        private static ActionSheetItem n2() {
            return a(R.drawable.qui_remark, R.string.wxi, "feedback");
        }

        private static ActionSheetItem o() {
            return a(R.drawable.qui_delete, R.string.f226676oz, "super_block_user");
        }

        private static ActionSheetItem o0() {
            return a(R.drawable.qui_image_reprint_normal, R.string.w7i, "group_album");
        }

        private static ActionSheetItem o1() {
            return a(R.drawable.qui_set_top_off, R.string.f227296qn, "remove_top");
        }

        private static ActionSheetItem o2() {
            return c(R.string.wxj, "interest");
        }

        private static ActionSheetItem p() {
            return a(R.drawable.qui_delete, R.string.f226686p0, "super_delete");
        }

        private static ActionSheetItem p0() {
            return c(R.string.wx9, "fan_group_manage");
        }

        private static ActionSheetItem p1() {
            return a(R.drawable.qui_complaint, R.string.w7u, "report");
        }

        private static ActionSheetItem p2() {
            return c(R.string.wxk, "look_owner");
        }

        private static ActionSheetItem q() {
            return a(R.drawable.qui_target_to_chat, R.string.w77, "aio_position");
        }

        private static ActionSheetItem q0() {
            return a(R.drawable.qui_link, R.string.w7g, WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK);
        }

        private static ActionSheetItem q1() {
            return a(R.drawable.qui_complaint, R.string.w7u, "report");
        }

        private static ActionSheetItem q2() {
            return c(R.string.wxl, "pull_black");
        }

        private static ActionSheetItem r() {
            return a(R.drawable.qui_edit, R.string.f226816pc, "edit_album");
        }

        private static ActionSheetItem r0() {
            return a(R.drawable.qui_qrcode, R.string.f227406qy, "generate_QRcode");
        }

        private static ActionSheetItem r1() {
            return a(R.drawable.qui_share_feedback_normal, R.string.wd8, "reprint_diary");
        }

        private static ActionSheetItem r2() {
            return c(R.string.wxm, "push_topics");
        }

        private static ActionSheetItem s() {
            return a(R.drawable.qui_hometown, R.string.w7c, "backtohome");
        }

        private static ActionSheetItem s0() {
            return a(R.drawable.qui_eye_off, R.string.wcp, "hide_this_feed");
        }

        private static ActionSheetItem s1() {
            return a(R.drawable.qui_share_feedback_normal, R.string.w7v, "reprint_photo");
        }

        private static ActionSheetItem s2() {
            return a(R.drawable.qui_recall, R.string.f227316qp, "troop_revoke_msg");
        }

        private static ActionSheetItem t() {
            return a(R.drawable.nkp, R.string.f227146q9, "close_barrage");
        }

        private static ActionSheetItem t0() {
            return a(R.drawable.qui_eye_off, R.string.wcq, "hide_him");
        }

        private static ActionSheetItem t1() {
            return a(R.drawable.qui_refresh, R.string.f227306qo, "restart_applet");
        }

        private static ActionSheetItem t2() {
            return a(R.drawable.qui_remove_user, R.string.wdf, IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW);
        }

        private static ActionSheetItem u() {
            return a(R.drawable.nkr, R.string.f227256qj, "open_barrage");
        }

        private static ActionSheetItem u0() {
            return a(R.drawable.qui_hide_state, R.string.f227206qe, "hide_works");
        }

        private static ActionSheetItem u1() {
            return c(R.string.f226906pl, "biz_src_kandian_playvideo");
        }

        private static ActionSheetItem u2() {
            return a(R.drawable.qui_set_top_off, R.string.wdd, "unstick");
        }

        private static ActionSheetItem v() {
            return a(R.drawable.qui_batch, R.string.f226696p1, "batch_management");
        }

        private static ActionSheetItem v0() {
            return c(R.string.wcr, "Import_reader");
        }

        private static ActionSheetItem v1() {
            return a(R.drawable.qui_safety_feedback_normal, R.string.wd9, "safe_share");
        }

        private static ActionSheetItem v2() {
            return c(R.string.wxn, "play_feedback");
        }

        private static ActionSheetItem w() {
            return a(R.drawable.f160374oh0, R.string.f173132w81, "browser");
        }

        private static ActionSheetItem w0() {
            return a(R.drawable.qui_edit, R.string.wcs, "edit_online");
        }

        private static ActionSheetItem w1() {
            return a(R.drawable.qui_download, R.string.f227326qq, "save_other_path");
        }

        private static ActionSheetItem w2() {
            return c(R.string.f227526r_, "video_paster");
        }

        private static ActionSheetItem x() {
            return a(R.drawable.n_8, R.string.wxb, "cancel_push_off");
        }

        private static ActionSheetItem x0() {
            return a(R.drawable.qui_daka, R.string.f227216qf, "intimate_check_in");
        }

        private static ActionSheetItem x1() {
            return a(R.drawable.qui_download, R.string.w7w, "save");
        }

        private static ActionSheetItem x2() {
            return a(R.drawable.qui_skin, R.string.wdg, "look_dress");
        }

        private static ActionSheetItem y() {
            return a(R.drawable.qui_collection, R.string.wcf, "no_only_friend");
        }

        private static ActionSheetItem y0() {
            return c(R.string.f227136q8, "biu");
        }

        private static ActionSheetItem y1() {
            return c(R.string.f227196qd, "biz_src_qqchannel_share_minimize");
        }

        private static ActionSheetItem y2() {
            return a(R.drawable.qui_emoticon, R.string.w7z, "search_emotion");
        }

        private static ActionSheetItem z() {
            return a(R.drawable.qui_cancel_watch_later, R.string.f226706p2, "cancel_watch_later");
        }

        private static ActionSheetItem z0() {
            return a(R.drawable.qui_greeting, R.string.wct, "open_aio");
        }

        private static ActionSheetItem z1() {
            return a(R.drawable.qui_miniapp, R.string.w7x, "scan_appletcode");
        }

        private static ActionSheetItem z2() {
            return a(R.drawable.qui_watch_later, R.string.f227066q1, "watch_later");
        }

        public boolean isShowRedDot() {
            return this.showRedDot;
        }

        public boolean isValidCreate() {
            if (this.f307295a == null) {
                return true;
            }
            return false;
        }

        public boolean isValidIcon() {
            if (this.iconNeedBg) {
                if (Arrays.binarySearch(f307292b, this.icon) >= 0) {
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ShareActionSheetBuilder", 2, this.label + " is in invalid icon " + this);
                }
            }
            this.icon = R.drawable.qui_qq;
            return true;
        }

        public boolean isValidLabel() {
            int i3 = 0;
            while (true) {
                int[] iArr = f307293c;
                if (i3 >= iArr.length || TextUtils.equals(this.label, com.tencent.mobileqq.widget.az.g(iArr[i3]))) {
                    return true;
                }
                i3++;
            }
        }

        public static ActionSheetItem build(int i3) {
            ActionSheetItem K;
            switch (i3) {
                case 1:
                case 160:
                    K = K();
                    break;
                case 2:
                    K = E1();
                    break;
                case 3:
                    K = G1();
                    break;
                case 4:
                    K = w();
                    break;
                case 5:
                    K = c1();
                    break;
                case 6:
                    K = e0();
                    break;
                case 7:
                    K = n();
                    break;
                case 8:
                    K = B();
                    break;
                case 9:
                    K = J1();
                    break;
                case 10:
                    K = I1();
                    break;
                case 11:
                    K = q1();
                    break;
                case 12:
                    K = L1();
                    break;
                case 13:
                    K = y0();
                    break;
                case 14:
                    K = k();
                    break;
                case 15:
                    K = a(R.drawable.qui_add, R.string.eif, "add_troop_app");
                    break;
                case 16:
                    K = a(R.drawable.qui_chat_settings, R.string.eii, "open_app_detail");
                    break;
                case 17:
                    K = a(R.drawable.qui_share, R.string.eil, "share_troop_app");
                    break;
                case 18:
                    K = a(R.drawable.qui_refresh, R.string.eik, "refresh_troop_app_view");
                    break;
                case 19:
                    K = g1();
                    break;
                case 20:
                    K = h1();
                    break;
                case 21:
                    K = B1();
                    break;
                case 22:
                    K = v2();
                    break;
                case 23:
                    K = d1();
                    break;
                case 24:
                case 29:
                case 33:
                case 36:
                case 41:
                case 42:
                case 43:
                case 46:
                case 47:
                case 49:
                case 53:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 67:
                case 69:
                case 93:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 134:
                case 135:
                case 136:
                case 139:
                case 181:
                case 183:
                case 215:
                case 226:
                case 227:
                case 233:
                case 234:
                default:
                    K = new ActionSheetItem();
                    K.icon = R.drawable.qui_complaint;
                    K.reportID = "default v2 not support id";
                    QLog.e("ShareActionSheetBuilder", 1, "buildV2: notSupportAction = [" + i3 + "]", new IllegalArgumentException());
                    break;
                case 25:
                    K = F1();
                    break;
                case 26:
                    K = H0();
                    break;
                case 27:
                    K = K1();
                    break;
                case 28:
                    K = H();
                    break;
                case 30:
                    K = L0();
                    break;
                case 31:
                    K = F0();
                    break;
                case 32:
                    K = t2();
                    break;
                case 34:
                    K = c(R.string.f171311dy3, "share_diandian");
                    break;
                case 35:
                    K = i();
                    break;
                case 37:
                    K = n0();
                    break;
                case 38:
                    K = I0();
                    break;
                case 39:
                case 210:
                    K = x1();
                    break;
                case 40:
                    K = R();
                    break;
                case 44:
                    K = J0();
                    break;
                case 45:
                case 83:
                    K = X0();
                    break;
                case 48:
                    K = h();
                    break;
                case 50:
                    K = e1();
                    break;
                case 51:
                    K = o0();
                    break;
                case 52:
                    K = a0();
                    break;
                case 54:
                    K = q();
                    break;
                case 55:
                case 126:
                    K = A1();
                    break;
                case 56:
                case 127:
                    K = z1();
                    break;
                case 64:
                    K = R0();
                    break;
                case 65:
                    K = y2();
                    break;
                case 66:
                    K = p1();
                    break;
                case 68:
                    K = Y();
                    break;
                case 70:
                    K = g();
                    break;
                case 71:
                    K = A0();
                    break;
                case 72:
                    K = a(R.drawable.f160830com, R.string.w6x, "");
                    break;
                case 73:
                    K = a(R.drawable.qui_more, R.string.w7l, "");
                    break;
                case 74:
                    K = O0();
                    break;
                case 75:
                    K = E();
                    break;
                case 76:
                    K = l();
                    break;
                case 77:
                    K = n1();
                    break;
                case 78:
                    K = d();
                    break;
                case 79:
                    K = C0();
                    break;
                case 80:
                    K = B0();
                    break;
                case 81:
                    K = s();
                    break;
                case 82:
                    K = l1();
                    break;
                case 84:
                    K = m1();
                    break;
                case 85:
                    K = s0();
                    break;
                case 86:
                    K = t0();
                    break;
                case 87:
                    K = k0();
                    break;
                case 88:
                    K = B2();
                    break;
                case 89:
                    K = f();
                    break;
                case 90:
                    K = e();
                    break;
                case 91:
                    K = D1();
                    break;
                case 92:
                    K = z0();
                    break;
                case 94:
                    K = W();
                    break;
                case 95:
                    K = P1();
                    break;
                case 96:
                    K = R1();
                    break;
                case 97:
                    K = u2();
                    break;
                case 98:
                    K = O1();
                    break;
                case 99:
                    K = x2();
                    break;
                case 100:
                    K = s1();
                    break;
                case 101:
                    K = r1();
                    break;
                case 102:
                    K = K0();
                    break;
                case 103:
                    K = y();
                    break;
                case 104:
                    K = A2();
                    break;
                case 105:
                    K = T0();
                    break;
                case 106:
                    K = C();
                    break;
                case 107:
                    K = N1();
                    break;
                case 118:
                    K = v0();
                    break;
                case 119:
                    K = w0();
                    break;
                case 120:
                    K = v1();
                    break;
                case 121:
                    K = U0();
                    break;
                case 122:
                    K = M();
                    break;
                case 123:
                    K = N();
                    break;
                case 124:
                    K = V();
                    break;
                case 125:
                    K = A();
                    break;
                case 128:
                    K = t1();
                    break;
                case 129:
                    K = c0();
                    break;
                case 130:
                    K = b0();
                    break;
                case 131:
                    K = d0();
                    break;
                case 132:
                    K = N0();
                    break;
                case 133:
                    K = O();
                    break;
                case 137:
                    K = T();
                    break;
                case 138:
                    K = V0();
                    break;
                case 140:
                    K = U();
                    break;
                case 141:
                    K = u0();
                    break;
                case 142:
                    K = u();
                    break;
                case 143:
                    K = t();
                    break;
                case 144:
                    K = l0();
                    break;
                case 145:
                    K = l2();
                    break;
                case 146:
                    K = m2();
                    break;
                case 147:
                    K = o2();
                    break;
                case 148:
                    K = p2();
                    break;
                case 149:
                    K = r2();
                    break;
                case 150:
                    K = q2();
                    break;
                case 151:
                    K = n2();
                    break;
                case 152:
                    K = p0();
                    break;
                case 153:
                    K = T1();
                    break;
                case 154:
                    K = c2();
                    break;
                case 155:
                    K = Q0();
                    break;
                case 156:
                    K = j();
                    break;
                case 157:
                    K = X1();
                    break;
                case 158:
                    K = E0();
                    break;
                case 159:
                    K = D0();
                    break;
                case 161:
                    K = v2();
                    break;
                case 162:
                    K = f1();
                    break;
                case 163:
                    K = M0();
                    break;
                case 164:
                    K = D();
                    break;
                case 165:
                    K = u1();
                    break;
                case 166:
                    K = P0();
                    break;
                case 167:
                    K = x();
                    break;
                case 168:
                    K = y1();
                    break;
                case 169:
                    K = Z();
                    break;
                case 170:
                    K = j2();
                    break;
                case 171:
                    K = C1();
                    break;
                case 172:
                    K = h2();
                    break;
                case 173:
                    K = i2();
                    break;
                case 174:
                    K = g2();
                    break;
                case 175:
                    K = e2();
                    break;
                case 176:
                    K = d2();
                    break;
                case 177:
                    K = f2();
                    break;
                case 178:
                    K = a(R.drawable.f160830com, R.string.w6x, "");
                    break;
                case 179:
                    K = j0();
                    break;
                case 180:
                    K = i1();
                    break;
                case 182:
                    K = j1();
                    break;
                case 184:
                    K = U1();
                    break;
                case 185:
                    K = k1();
                    break;
                case 186:
                    K = m();
                    break;
                case 187:
                    K = o1();
                    break;
                case 188:
                case 189:
                    K = S1();
                    break;
                case 190:
                    K = S();
                    break;
                case 191:
                    K = r();
                    break;
                case 192:
                    K = w2();
                    break;
                case 193:
                    K = F(true);
                    break;
                case 194:
                    K = F(false);
                    break;
                case 195:
                    K = P();
                    break;
                case 196:
                    K = r0();
                    break;
                case 197:
                    K = q0();
                    break;
                case 198:
                    K = a(R.drawable.f160830com, R.string.f227246qi, "");
                    break;
                case 199:
                    K = E2();
                    break;
                case 200:
                    K = Z1();
                    break;
                case 201:
                    K = a2(true);
                    break;
                case 202:
                    K = a2(false);
                    break;
                case 203:
                    K = V1();
                    break;
                case 204:
                    K = D2();
                    break;
                case 205:
                    K = C2();
                    break;
                case 206:
                    K = b2(true);
                    break;
                case 207:
                    K = b2(false);
                    break;
                case 208:
                    K = X();
                    break;
                case 209:
                    K = Q();
                    break;
                case 211:
                    K = b1();
                    break;
                case 212:
                    K = Y1();
                    break;
                case 213:
                    K = I();
                    break;
                case 214:
                    K = Z0();
                    break;
                case 216:
                    K = Y0();
                    break;
                case 217:
                    K = a1();
                    break;
                case 218:
                    K = M1();
                    break;
                case 219:
                    K = W1();
                    break;
                case 220:
                    K = k2();
                    break;
                case 221:
                    K = L();
                    break;
                case 222:
                    K = H1();
                    break;
                case 223:
                    K = G();
                    break;
                case 224:
                    K = v();
                    break;
                case 225:
                    K = G0();
                    break;
                case 228:
                    K = s2();
                    break;
                case 229:
                    K = w1();
                    break;
                case 230:
                    K = S0();
                    break;
                case 231:
                    K = Q1();
                    break;
                case 232:
                    K = J();
                    break;
                case 235:
                    K = p();
                    break;
                case 236:
                    K = z2();
                    break;
                case 237:
                    K = z();
                    break;
                case 238:
                    K = x0();
                    break;
                case 239:
                    K = W0();
                    break;
                case 240:
                    K = o();
                    break;
                case 241:
                    K = m0();
                    break;
                case 242:
                    K = h0();
                    break;
                case 243:
                    K = i0();
                    break;
                case 244:
                    K = f0();
                    break;
                case 245:
                    K = g0();
                    break;
            }
            K.action = i3;
            return K;
        }
    }

    @Deprecated
    public ShareActionSheetBuilder(Context context, boolean z16, int i3) {
        this.J = false;
        this.S = true;
        if (i3 == 2) {
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.context = context;
            param.fullScreen = z16;
            this.X = ShareActionSheetFactory.create(param);
            return;
        }
        this.f307286d = context;
        if (z16) {
            this.f307288f = (ActionSheet) ActionSheetHelper.createFullScreenDialog(context, null);
        } else {
            this.f307288f = (ActionSheet) ActionSheetHelper.createDialog(context, null);
        }
        Resources resources = this.f307286d.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f158592jv);
        this.K = dimensionPixelSize;
        this.M = dimensionPixelSize;
        this.N = resources.getDimensionPixelOffset(R.dimen.f158594jx);
        this.P = resources.getDimensionPixelOffset(R.dimen.f158595jy);
        this.R = new d();
        int i16 = resources.getDisplayMetrics().widthPixels;
        int i17 = resources.getDisplayMetrics().heightPixels;
        setIconMarginLeftRight(((i16 > i17 ? i17 : i16) - ((int) (getIconWidth() * 5.2f))) / ((((int) 5.2f) + 1) * 2));
        setRowMarginLeftRight((int) ((r4 * 6) / 5.5f));
    }
}
