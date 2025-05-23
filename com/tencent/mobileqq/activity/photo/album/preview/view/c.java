package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCommonUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.preview.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import com.tencent.richmediabrowser.view.recyclerview.BrowserRecyclerView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends MainBrowserScene implements CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;
    public TextView C;
    public CheckBox D;
    public TextView E;
    public CheckBox F;
    public TextView G;
    public Button H;
    public NumberCheckBox I;
    public View J;
    public TextView K;
    public TextView L;
    public int M;
    public int N;
    private com.tencent.mobileqq.activity.photo.album.preview.presenter.c<? extends OtherCommonData> P;
    float Q;
    float R;

    /* renamed from: d, reason: collision with root package name */
    public PeakFragmentActivity f184362d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.mobileqq.activity.photo.album.preview.view.a f184363e;

    /* renamed from: f, reason: collision with root package name */
    public RelativeLayout f184364f;

    /* renamed from: h, reason: collision with root package name */
    public View f184365h;

    /* renamed from: i, reason: collision with root package name */
    public View f184366i;

    /* renamed from: m, reason: collision with root package name */
    public ViewGroup f184367m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.view.View.OnClickListener
        @RequiresApi(api = 17)
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                c.this.f184363e.p(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                c.this.f184363e.onBackPressed();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public c(PeakFragmentActivity peakFragmentActivity, com.tencent.mobileqq.activity.photo.album.preview.presenter.c cVar) {
        super(peakFragmentActivity, cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) peakFragmentActivity, (Object) cVar);
            return;
        }
        this.Q = 13.0f;
        this.R = 9.0f;
        this.f184362d = peakFragmentActivity;
        this.P = cVar;
    }

    public void a() {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.P.f184343h.f184323a) {
            this.f184364f.setVisibility(0);
        } else {
            this.f184364f.setVisibility(4);
        }
        if (this.P.f184343h.f184327e && (textView = this.L) != null) {
            textView.setVisibility(8);
        }
        View view = this.J;
        if (view != null) {
            view.setOnClickListener(new a());
        }
        TextView textView2 = this.K;
        if (textView2 != null) {
            textView2.setOnClickListener(new b());
        }
        this.f184363e.g();
        if (this.P.f184342f.isSingleMode) {
            NumberCheckBox numberCheckBox = this.I;
            if (numberCheckBox != null) {
                numberCheckBox.setVisibility(8);
            }
            View view2 = this.J;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.f184362d.getSystemService("layout_inflater");
        if (layoutInflater == null) {
            return null;
        }
        return layoutInflater.inflate(R.layout.gzr, (ViewGroup) null);
    }

    public View c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        this.f184364f = new RelativeLayout(this.f184362d);
        this.f184364f.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f184364f.setBackgroundColor(this.f184362d.getResources().getColor(R.color.ajr));
        View b16 = this.f184363e.b();
        this.f184365h = b16;
        if (b16 != null) {
            b16.setId(View.generateViewId());
            RelativeLayout.LayoutParams e16 = this.f184363e.e();
            if (e16 != null) {
                this.f184364f.addView(this.f184365h, e16);
            } else {
                this.f184364f.addView(this.f184365h);
            }
        }
        View d16 = this.f184363e.d();
        this.f184366i = d16;
        if (d16 != null) {
            d16.setId(View.generateViewId());
            RelativeLayout.LayoutParams f16 = this.f184363e.f();
            if (f16 != null) {
                this.f184364f.addView(this.f184366i, f16);
            } else {
                this.f184364f.addView(this.f184365h);
            }
        }
        return this.f184364f;
    }

    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.f184362d.getSystemService("layout_inflater");
        if (layoutInflater == null) {
            return null;
        }
        return layoutInflater.inflate(R.layout.gzo, (ViewGroup) null);
    }

    public RelativeLayout.LayoutParams e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        View view = this.f184365h;
        if (view != null && view.getLayoutParams() != null) {
            return new RelativeLayout.LayoutParams(this.f184365h.getLayoutParams());
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.f184362d.getResources().getDimension(R.dimen.title_bar_height));
        layoutParams.addRule(10);
        return layoutParams;
    }

    public RelativeLayout.LayoutParams f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        View view = this.f184366i;
        if (view != null && view.getLayoutParams() != null) {
            return new RelativeLayout.LayoutParams(this.f184366i.getLayoutParams());
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    public void g() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.H != null) {
            Resources resources = this.f184362d.getResources();
            String str = this.P.f184342f.customSendBtnText;
            if (str == null) {
                str = resources.getString(R.string.ctx);
            }
            ArrayList<String> arrayList = this.P.f184342f.selectedPhotoList;
            if (arrayList != null && arrayList.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.H.setEnabled(true);
                if (this.P.f184342f.isSingleMode) {
                    this.H.setText(str);
                } else {
                    this.H.setText(str + "(" + this.P.f184342f.selectedPhotoList.size() + ")");
                }
            } else {
                this.H.setText(str);
            }
        }
        if (this.I != null) {
            if (!this.P.f184342f.selectedIndex.contains(Integer.valueOf(i())) && this.P.f184342f.selectedPhotoList.size() >= this.P.f184342f.maxSelectNum) {
                this.I.setActivated(true);
            } else {
                this.I.setActivated(false);
            }
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.P.f184343h.f184323a = true;
            this.f184364f.setVisibility(0);
        }
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.P.getCurrentPosition();
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene
    public void initView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.initView();
        c();
        View view = this.f184366i;
        if (view != null) {
            this.f184367m = (ViewGroup) view.findViewById(R.id.t9z);
            this.C = (TextView) this.f184366i.findViewById(R.id.ekt);
            this.D = (CheckBox) this.f184366i.findViewById(R.id.ccu);
            this.E = (TextView) this.f184366i.findViewById(R.id.ccv);
            this.F = (CheckBox) this.f184366i.findViewById(R.id.h1y);
            this.G = (TextView) this.f184366i.findViewById(R.id.f166661h24);
            this.H = (Button) this.f184366i.findViewById(R.id.send_btn);
        }
        View view2 = this.f184365h;
        if (view2 != null) {
            this.I = (NumberCheckBox) view2.findViewById(R.id.iml);
            this.J = this.f184365h.findViewById(R.id.im5);
            this.L = (TextView) this.f184365h.findViewById(R.id.title);
            this.K = (TextView) this.f184365h.findViewById(R.id.a4c);
        }
        CheckBox checkBox = this.D;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        TextView textView = this.E;
        if (textView != null) {
            textView.setVisibility(8);
        }
        CheckBox checkBox2 = this.F;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        TextView textView2 = this.G;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.C;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        getContentView().addView(this.f184364f);
        BrowserRecyclerView browserRecyclerView = this.recyclerView;
        if (browserRecyclerView != null) {
            browserRecyclerView.addItemDecoration(new com.tencent.mobileqq.activity.photo.album.preview.a(QAlbumCommonUtil.dp2px(2.5f, ((MainBrowserScene) this).mContext.getResources())));
        }
        this.f184363e.a();
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f184362d.getResources().getString(R.string.cu_, Integer.valueOf(this.P.f184342f.maxSelectNum));
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        String str = getItem(i3).baseData.filePath;
        if (this.P.f184342f.selectedIndex.contains(Integer.valueOf(i3))) {
            if (str != null) {
                n(str);
            } else {
                this.I.setChecked(false);
            }
        } else {
            this.I.setChecked(false);
        }
        this.f184363e.g();
        d dVar = this.P.f184343h;
        if (!dVar.f184327e) {
            if (dVar.f184324b.size() > 1) {
                this.L.setText((i3 + 1) + " / " + this.P.f184343h.f184324b.size());
            } else {
                this.L.setText(this.f184362d.getResources().getString(R.string.d09));
            }
        }
        if (this.P.l(str) == 1 && !this.P.f184343h.f184323a) {
            h();
        }
    }

    public ArrayList<String> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ArrayList) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.P.f184342f.selectedPhotoList.isEmpty()) {
            int i3 = i();
            if (i3 < this.P.f184343h.f184324b.size() && i3 != -1) {
                arrayList.add(this.P.f184343h.f184324b.get(i3));
            }
        } else {
            arrayList.addAll(this.P.f184342f.selectedPhotoList);
        }
        return arrayList;
    }

    public void n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            o(str, -1);
        }
    }

    public void o(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, i3);
            return;
        }
        if (i3 >= 0) {
            this.I.setCheckedNumber(i3);
            return;
        }
        int indexOf = this.P.f184342f.selectedPhotoList.indexOf(str) + 1;
        if (indexOf <= 0) {
            this.I.setChecked(false);
            return;
        }
        if (indexOf >= 100) {
            this.I.setTextSize(this.R);
        } else {
            this.I.setTextSize(this.Q);
        }
        this.I.setCheckedNumber(indexOf);
    }

    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Intent intent = this.f184362d.getIntent();
        if (PhotoCommonBaseData.FROM_PHOTO_LIST.equals(this.P.f184343h.f184326d)) {
            intent.setClass(this.f184362d, this.f184363e.s());
            PhotoCommonBaseData<? extends OtherCommonData> photoCommonBaseData = this.P.f184342f;
            if (photoCommonBaseData.isSingleMode) {
                intent.removeExtra("PhotoConst.PHOTO_PATHS");
            } else {
                intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", photoCommonBaseData.selectedPhotoList);
                intent.putExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP, this.P.f184343h.f184325c);
            }
            this.f184362d.startActivity(intent);
        }
        if (intent.getBooleanExtra(QAlbumConstants.KEEP_SELECTED_STATUS_AFTER_FINISH, false)) {
            Intent intent2 = new Intent();
            intent2.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.P.f184342f.selectedPhotoList);
            intent2.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, this.P.f184342f.selectedIndex);
            intent2.putExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP, this.P.f184343h.f184325c);
            this.f184362d.setResult(-1, intent2);
        }
        this.f184362d.finish();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, compoundButton, Boolean.valueOf(z16));
        } else {
            int id5 = compoundButton.getId();
            if (id5 == R.id.h1y) {
                this.f184363e.q(compoundButton, z16);
            } else if (id5 == R.id.ccu) {
                this.f184363e.l(z16);
            }
            if (!this.F.isChecked() && !this.D.isChecked()) {
                this.G.setTextColor(-1);
                this.E.setTextColor(-1);
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener
    public void onClickDragView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            super.onClickDragView();
            this.f184363e.onClickDragView();
        }
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener
    public void onContentMove(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Float.valueOf(f16));
        } else {
            super.onContentMove(f16);
            this.f184363e.onContentMove(f16);
        }
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener
    public void onGestureFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.f184363e.onGestureFinish();
        }
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.BrowserBaseScene
    public void onItemSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            super.onItemSelected(i3);
            this.f184363e.k(i3);
        }
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener
    public void onResetPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            super.onResetPosition();
            this.f184363e.onResetPosition();
        }
    }

    public void p(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
            return;
        }
        this.f184362d.getResources();
        int i3 = i();
        if (this.P.f184342f.selectedIndex.contains(Integer.valueOf(i3))) {
            this.I.setChecked(false);
            int indexOf = this.P.f184342f.selectedIndex.indexOf(Integer.valueOf(i3));
            if (indexOf >= 0) {
                this.P.f184342f.selectedIndex.remove(indexOf);
                if (i3 != -1) {
                    com.tencent.mobileqq.activity.photo.album.preview.presenter.c<? extends OtherCommonData> cVar = this.P;
                    cVar.f184342f.selectedPhotoList.remove(cVar.f184343h.f184324b.get(i3));
                }
            }
        } else {
            int size = this.P.f184342f.selectedPhotoList.size();
            com.tencent.mobileqq.activity.photo.album.preview.presenter.c<? extends OtherCommonData> cVar2 = this.P;
            if (size >= cVar2.f184342f.maxSelectNum) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.P.f184343h.f184328f >= 700) {
                    QQToast.makeText(this.f184362d, j(), 1000).show();
                    this.P.f184343h.f184328f = currentTimeMillis;
                }
                this.I.setChecked(false);
                return;
            }
            if (i3 != -1) {
                String str = cVar2.f184343h.f184324b.get(i3);
                this.P.f184342f.selectedPhotoList.add(str);
                this.P.f184342f.selectedIndex.add(Integer.valueOf(i3));
                n(str);
            }
        }
        this.f184363e.g();
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.P.f184343h.f184323a = false;
            this.f184364f.setVisibility(4);
        }
    }

    public void t(com.tencent.mobileqq.activity.photo.album.preview.view.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f184363e = aVar;
        }
    }
}
