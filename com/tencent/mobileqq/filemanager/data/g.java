package com.tencent.mobileqq.filemanager.data;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private List<h> f207770d;

    /* renamed from: e, reason: collision with root package name */
    private BaseFileAssistantActivity f207771e;

    /* renamed from: f, reason: collision with root package name */
    private LayoutInflater f207772f;

    /* renamed from: h, reason: collision with root package name */
    private View.OnClickListener f207773h;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Cloneable {
        public int C;
        public String D;
        public TextView E;
        public TextView F;

        /* renamed from: d, reason: collision with root package name */
        public View f207774d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f207775e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f207776f;

        /* renamed from: h, reason: collision with root package name */
        public TextView f207777h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f207778i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f207779m;

        public a() {
        }
    }

    public g(BaseFileAssistantActivity baseFileAssistantActivity, List<h> list, View.OnClickListener onClickListener) {
        this.f207771e = baseFileAssistantActivity;
        this.f207770d = list;
        this.f207772f = LayoutInflater.from(baseFileAssistantActivity);
        this.f207773h = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f207770d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f207770d.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        if (this.f207770d.get(i3).f207780a == 0) {
            return 0;
        }
        if (this.f207770d.get(i3).f207780a == 3) {
            return 3;
        }
        if (this.f207770d.get(i3).f207780a == 2) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        View view3;
        h hVar = this.f207770d.get(i3);
        if (hVar == null) {
            view3 = view;
            view2 = null;
        } else {
            if (view == null) {
                aVar = new a();
                view2 = new RedTouch(this.f207771e, this.f207772f.inflate(hVar.f207781b, viewGroup, false)).setRightMargin(30.0f).applyTo();
                view2.setTag(aVar);
                int i16 = hVar.f207780a;
                if (i16 != 0 && i16 != 3) {
                    if (i16 == 1 || i16 == 4) {
                        aVar.E = (TextView) view2.findViewById(R.id.bms);
                        aVar.F = (TextView) view2.findViewById(R.id.jfo);
                    }
                } else {
                    View findViewById = view2.findViewById(R.id.arl);
                    aVar.f207774d = findViewById;
                    findViewById.setOnClickListener(this.f207773h);
                    aVar.f207775e = (ImageView) view2.findViewById(R.id.ark);
                    aVar.f207776f = (ImageView) view2.findViewById(R.id.i4s);
                    aVar.f207778i = (TextView) view2.findViewById(R.id.arm);
                    aVar.f207777h = (TextView) view2.findViewById(R.id.fca);
                    aVar.f207779m = (TextView) view2.findViewById(R.id.j1q);
                }
            } else {
                aVar = (a) view.getTag();
                view2 = view;
            }
            aVar.C = hVar.f207786g;
            aVar.D = hVar.f207790k;
            int i17 = hVar.f207780a;
            if (i17 == 0) {
                if (hVar.f207789j) {
                    aVar.f207776f.setVisibility(0);
                } else {
                    aVar.f207776f.setVisibility(8);
                }
                if (hVar.f207788i) {
                    aVar.f207775e.setVisibility(0);
                    aVar.f207775e.setBackgroundResource(hVar.f207782c);
                } else {
                    aVar.f207775e.setVisibility(8);
                }
                if (!TextUtils.isEmpty(hVar.f207787h)) {
                    aVar.f207779m.setText(hVar.f207787h);
                    aVar.f207779m.setVisibility(0);
                } else {
                    aVar.f207779m.setVisibility(8);
                }
                aVar.f207778i.setText(hVar.f207783d);
                aVar.f207774d.setTag(aVar);
                if (hVar.f207785f) {
                    aVar.f207777h.setText("(" + hVar.f207784e + ")");
                }
                int i18 = hVar.f207791l;
                if (i18 != 1) {
                    if (i18 != 2) {
                        if (i18 != 3) {
                            if (i18 != 4) {
                                aVar.f207774d.setBackgroundResource(R.drawable.common_strip_setting_bg);
                            } else {
                                aVar.f207774d.setBackgroundResource(R.drawable.common_strip_setting_bottom);
                            }
                        } else {
                            aVar.f207774d.setBackgroundResource(R.drawable.common_strip_setting_middle);
                        }
                    } else {
                        aVar.f207774d.setBackgroundResource(R.drawable.common_strip_setting_top);
                    }
                } else {
                    aVar.f207774d.setBackgroundResource(R.drawable.common_strip_setting_bg);
                }
                int i19 = hVar.f207786g;
                if (16 != i19 && 17 != i19) {
                    if (22 == i19) {
                        RedTouch redTouch = (RedTouch) view2;
                        redTouch.parseRedTouch(((IRedTouchManager) this.f207771e.D0.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("100160.100163"));
                        if (redTouch.hasRedTouch()) {
                            aVar.f207776f.setVisibility(4);
                        } else {
                            aVar.f207776f.setVisibility(8);
                        }
                    } else {
                        ((RedTouch) view2).clearRedTouch();
                    }
                }
            } else if (i17 == 1) {
                if (hVar.f207785f) {
                    aVar.F.setText(hVar.f207783d);
                } else {
                    aVar.F.setVisibility(4);
                }
            } else if (i17 == 4) {
                if (hVar.f207785f) {
                    aVar.F.setGravity(17);
                    IQQFileTempUtils iQQFileTempUtils = (IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class);
                    BaseFileAssistantActivity baseFileAssistantActivity = this.f207771e;
                    if (!iQQFileTempUtils.hasShortCut(baseFileAssistantActivity, new String[]{baseFileAssistantActivity.getString(R.string.b7l)})) {
                        String str = hVar.f207783d;
                        SpannableString Y = ah.Y(str, str, null);
                        aVar.F.setClickable(true);
                        aVar.F.setOnClickListener(this.f207773h);
                        aVar.F.setText(Y);
                        aVar.F.setTag(aVar);
                    }
                } else {
                    aVar.F.setVisibility(4);
                }
            }
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }
}
