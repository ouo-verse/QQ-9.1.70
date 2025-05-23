package com.qzone.detail.ui.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.util.ar;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: P */
/* loaded from: classes39.dex */
public class StyleChooserShareActionSheetBuilder extends ShareActionSheetBuilder {
    private final int Y;
    private final int Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f47040a0;

    /* renamed from: b0, reason: collision with root package name */
    private RelativeLayout f47041b0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (((ShareActionSheetBuilder) StyleChooserShareActionSheetBuilder.this).f307288f.isShowing()) {
                ((ShareActionSheetBuilder) StyleChooserShareActionSheetBuilder.this).f307288f.cancel();
                ((ShareActionSheetBuilder) StyleChooserShareActionSheetBuilder.this).f307288f.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private List<ShareActionSheetBuilder.ActionSheetItem> f47043d;

        /* renamed from: e, reason: collision with root package name */
        private LayoutInflater f47044e;

        /* renamed from: f, reason: collision with root package name */
        private int f47045f = 0;

        /* renamed from: h, reason: collision with root package name */
        private Resources f47046h;

        public b(Context context, List<ShareActionSheetBuilder.ActionSheetItem> list) {
            this.f47043d = list;
            this.f47044e = LayoutInflater.from(context);
        }

        private Drawable b(Drawable drawable, int i3) {
            Drawable mutate = drawable.getConstantState().newDrawable().mutate();
            mutate.setColorFilter(i3, PorterDuff.Mode.MULTIPLY);
            return mutate;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareActionSheetBuilder.ActionSheetItem getItem(int i3) {
            if (this.f47043d != null && i3 >= 0) {
                int i16 = -1;
                for (int i17 = 0; i17 < this.f47043d.size(); i17++) {
                    ShareActionSheetBuilder.ActionSheetItem actionSheetItem = this.f47043d.get(i17);
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

        @Override // android.widget.Adapter
        public int getCount() {
            List<ShareActionSheetBuilder.ActionSheetItem> list = this.f47043d;
            int i3 = 0;
            if (list == null) {
                return 0;
            }
            for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : list) {
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
            ShareActionSheetBuilder.c cVar;
            if (this.f47046h == null) {
                this.f47046h = viewGroup.getContext().getResources();
            }
            if (this.f47045f == 0) {
                this.f47045f = (int) this.f47046h.getDimension(R.dimen.f158592jv);
            }
            if (view == null) {
                view = this.f47044e.inflate(R.layout.f167788hi, viewGroup, false);
                cVar = new ShareActionSheetBuilder.c();
                cVar.f307308b = (ImageView) view.findViewById(R.id.iqu);
                cVar.f307308b.setLayoutParams(new FrameLayout.LayoutParams(ar.e(45.0f), ar.e(45.0f)));
                cVar.f307307a = (TextView) view.findViewById(R.id.iqv);
                view.setTag(cVar);
            } else {
                cVar = (ShareActionSheetBuilder.c) view.getTag();
            }
            ShareActionSheetBuilder.ActionSheetItem item = getItem(i3);
            cVar.f307311e = item;
            if (item == null) {
                QLog.e("StyleChooserShareActionSheetBuilder", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + i3 + ") == null !!!");
            } else {
                view.setId(item.f307296id);
                cVar.f307307a.setVisibility(8);
                cVar.f307308b.setImageResource(R.drawable.f160037n);
                ShareActionSheetBuilder.ActionSheetItem actionSheetItem = cVar.f307311e;
                Drawable drawable = actionSheetItem.iconDrawable;
                if (drawable == null) {
                    drawable = this.f47046h.getDrawable(actionSheetItem.icon);
                }
                if (cVar.f307311e.enable) {
                    cVar.f307308b.setImageDrawable(drawable);
                } else {
                    cVar.f307308b.setImageDrawable(b(drawable, LockFreeTaskQueueCore.MAX_CAPACITY_MASK));
                }
                AccessibilityUtil.p(view, cVar.f307311e.label);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    public StyleChooserShareActionSheetBuilder(Context context) {
        super(context);
        this.Y = ar.e(45.0f);
        this.Z = ar.e(16.0f);
        this.f47040a0 = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.utils.ShareActionSheetBuilder
    public View d() {
        List<ShareActionSheetBuilder.ActionSheetItem> arrayList;
        View inflate = View.inflate(this.f307286d, R.layout.bzl, null);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.f2104if);
        this.f47041b0 = relativeLayout;
        int i3 = this.f47040a0;
        if (i3 != -1) {
            relativeLayout.setBackgroundColor(i3);
        }
        this.R.d(this.f47041b0);
        TextView textView = (TextView) inflate.findViewById(R.id.f163933cv);
        this.C = textView;
        textView.setVisibility(0);
        CharSequence charSequence = this.H;
        if (charSequence != null) {
            this.C.setText(charSequence);
        }
        this.f307290i = (ElasticHorScrView) inflate.findViewById(R.id.iih);
        List<ShareActionSheetBuilder.ActionSheetItem>[] f16 = f();
        if (f16.length > 0) {
            arrayList = f16[0];
        } else {
            arrayList = new ArrayList<>(0);
        }
        boolean z16 = !arrayList.isEmpty();
        if (z16) {
            this.T = (GridView) inflate.findViewById(R.id.f165392cx3);
            this.f307290i.setOverScrollMode(2);
            Iterator<ShareActionSheetBuilder.ActionSheetItem> it = arrayList.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                if (it.next().visibility == 0) {
                    i16++;
                }
            }
            int iconWidth = this.L + getIconWidth() + this.L;
            this.T.setColumnWidth(iconWidth);
            this.T.setNumColumns(i16);
            ViewGroup.LayoutParams layoutParams = this.T.getLayoutParams();
            GridView gridView = this.T;
            gridView.setPadding(this.Q, gridView.getPaddingTop(), this.Q, this.T.getPaddingBottom());
            int i17 = this.Q;
            int i18 = (i16 * iconWidth) + i17 + i17;
            layoutParams.width = i18;
            this.F = i18;
            layoutParams.height = this.Y + this.Z;
            this.T.setLayoutParams(layoutParams);
            this.T.setAdapter((ListAdapter) new b(this.f307286d, arrayList));
            this.T.setSelector(new ColorDrawable(0));
            this.T.setOnItemClickListener(this.f307287e);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.f163928co);
        textView2.setText(R.string.cancel);
        textView2.setOnClickListener(new a());
        if (!z16) {
            this.f307290i.setVisibility(8);
        }
        inflate.post(new Runnable() { // from class: com.qzone.detail.ui.component.StyleChooserShareActionSheetBuilder.2
            @Override // java.lang.Runnable
            public void run() {
                if (StyleChooserShareActionSheetBuilder.this.f307290i.getWidth() < ((ShareActionSheetBuilder) StyleChooserShareActionSheetBuilder.this).F) {
                    StyleChooserShareActionSheetBuilder.this.f307290i.setMove(true);
                } else {
                    StyleChooserShareActionSheetBuilder.this.f307290i.setMove(false);
                }
            }
        });
        return inflate;
    }

    @Override // com.tencent.mobileqq.utils.ShareActionSheetBuilder, com.tencent.mobileqq.widget.share.ShareActionSheet
    public int getIconWidth() {
        return this.Y;
    }

    @Override // com.tencent.mobileqq.utils.ShareActionSheetBuilder, com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setAdvView(View view, RelativeLayout.LayoutParams layoutParams) {
        super.setAdvView(view, layoutParams);
    }
}
