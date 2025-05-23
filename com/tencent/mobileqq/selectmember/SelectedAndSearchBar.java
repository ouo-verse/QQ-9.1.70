package com.tencent.mobileqq.selectmember;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.mobileqq.widget.ForwardHeadView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SelectedAndSearchBar extends RelativeLayout implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    private CustomHorizontalScrollView C;
    private float D;
    private List<ResultRecord> E;
    private h F;
    private IFaceDecoder G;
    private Context H;
    private i I;
    private boolean J;
    private final ResultRecord.DefaultComparator K;
    private IQQGuildService L;
    private int M;
    private int N;
    private final TextWatcher P;

    /* renamed from: d, reason: collision with root package name */
    private View f285787d;

    /* renamed from: e, reason: collision with root package name */
    private CustomGridView f285788e;

    /* renamed from: f, reason: collision with root package name */
    private EditText f285789f;

    /* renamed from: h, reason: collision with root package name */
    private View f285790h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f285791i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f285792m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectedAndSearchBar.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                SelectedAndSearchBar.this.G();
                if (SelectedAndSearchBar.this.I != null) {
                    SelectedAndSearchBar.this.I.afterTextChanged(editable);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectedAndSearchBar.this);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                ResultRecord resultRecord = (ResultRecord) SelectedAndSearchBar.this.E.get(i3);
                if (SelectedAndSearchBar.this.I != null) {
                    SelectedAndSearchBar.this.I.a(resultRecord);
                }
                SelectedAndSearchBar.this.p(false);
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements View.OnKeyListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectedAndSearchBar.this);
            }
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 67) {
                if (keyEvent.getAction() == 0) {
                    SelectedAndSearchBar selectedAndSearchBar = SelectedAndSearchBar.this;
                    selectedAndSearchBar.J = TextUtils.isEmpty(selectedAndSearchBar.f285789f.getText());
                } else if (keyEvent.getAction() == 1 && SelectedAndSearchBar.this.J) {
                    SelectedAndSearchBar.this.F.b();
                    SelectedAndSearchBar.this.P.afterTextChanged(SelectedAndSearchBar.this.f285789f.getText());
                    SelectedAndSearchBar.this.f285790h.setVisibility(8);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements View.OnFocusChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectedAndSearchBar.this);
            }
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
            } else if (SelectedAndSearchBar.this.I != null) {
                SelectedAndSearchBar.this.I.b(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectedAndSearchBar.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SelectedAndSearchBar.this.f285789f.setText("");
                view.setVisibility(8);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f285798d;

        f(View.OnClickListener onClickListener) {
            this.f285798d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectedAndSearchBar.this, (Object) onClickListener);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                View.OnClickListener onClickListener = this.f285798d;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout.LayoutParams f285800d;

        g(RelativeLayout.LayoutParams layoutParams) {
            this.f285800d = layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectedAndSearchBar.this, (Object) layoutParams);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                this.f285800d.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SelectedAndSearchBar.this.f285787d.setLayoutParams(this.f285800d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f285802d;

        /* renamed from: e, reason: collision with root package name */
        private Drawable f285803e;

        /* renamed from: f, reason: collision with root package name */
        private Bitmap f285804f;

        public h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectedAndSearchBar.this);
                return;
            }
            this.f285802d = false;
            this.f285803e = SelectedAndSearchBar.this.H.getResources().getDrawable(R.drawable.abc);
            this.f285804f = BaseImageUtil.getDefaultFaceBitmap();
        }

        private int a(int i3) {
            if (i3 == 1006) {
                return 11;
            }
            if (i3 == 1) {
                return 4;
            }
            if (i3 == 3000) {
                return 101;
            }
            if (i3 != 10014 && i3 != 10027) {
                return 1;
            }
            return 117;
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            if (this.f285802d) {
                if (SelectedAndSearchBar.this.E != null && SelectedAndSearchBar.this.E.size() > 0) {
                    ResultRecord resultRecord = (ResultRecord) SelectedAndSearchBar.this.E.get(SelectedAndSearchBar.this.E.size() - 1);
                    if (SelectedAndSearchBar.this.I != null) {
                        SelectedAndSearchBar.this.I.a(resultRecord);
                    }
                    SelectedAndSearchBar.this.p(false);
                    this.f285802d = false;
                    return;
                }
                return;
            }
            this.f285802d = true;
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return SelectedAndSearchBar.this.E.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return SelectedAndSearchBar.this.E.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            int a16;
            View view2;
            View view3;
            Drawable drawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                ResultRecord resultRecord = (ResultRecord) getItem(i3);
                Drawable drawable2 = null;
                if (view == null) {
                    view = LayoutInflater.from(SelectedAndSearchBar.this.H).inflate(R.layout.hpg, (ViewGroup) null);
                }
                view.setTag(resultRecord);
                ForwardHeadView forwardHeadView = (ForwardHeadView) view.findViewById(R.id.c0o);
                if (i3 == getCount() - 1) {
                    if (this.f285802d) {
                        drawable = this.f285803e;
                    } else {
                        drawable = null;
                    }
                    forwardHeadView.setImageDrawable(drawable);
                } else {
                    forwardHeadView.setImageDrawable(null);
                }
                if (resultRecord.getUinType() == -1) {
                    a16 = resultRecord.type;
                } else {
                    a16 = a(resultRecord.getUinType());
                }
                int i16 = resultRecord.type;
                if (i16 == -1) {
                    i16 = a16;
                }
                resultRecord.type = i16;
                int i17 = resultRecord.uinType;
                if (i17 == 10016 || i17 == 10014 || i17 == 10027) {
                    z16 = true;
                }
                forwardHeadView.setShowGuildIcon(z16);
                int i18 = resultRecord.uinType;
                if (i18 != 10014 && i18 != 10027) {
                    if (AppConstants.DATALINE_PC_UIN.equals(resultRecord.uin)) {
                        forwardHeadView.setBackgroundResource(R.drawable.qfile_dataline_pc_recent);
                    } else if (AppConstants.DATALINE_IPAD_UIN.equals(resultRecord.uin)) {
                        forwardHeadView.setBackgroundResource(R.drawable.qfile_dataline_ipad_recent);
                    } else if (AppConstants.DATALINE_PHONE_UIN.equals(resultRecord.uin)) {
                        forwardHeadView.setBackgroundResource(R.drawable.qfile_dataline_user_aio);
                    } else if (AppConstants.DATALINE_PRINTER_UIN.equals(resultRecord.uin)) {
                        forwardHeadView.setBackgroundResource(R.drawable.qfile_dataline_printer_recent);
                    } else if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(resultRecord.uin)) {
                        forwardHeadView.setBackgroundResource(R.drawable.device_search_icon);
                    } else if (resultRecord.type == 5) {
                        forwardHeadView.setImageResource(R.drawable.day);
                    } else {
                        String str = resultRecord.uin;
                        Bitmap bitmapFromCache = SelectedAndSearchBar.this.G.getBitmapFromCache(a16, str);
                        if (bitmapFromCache == null) {
                            SelectedAndSearchBar.this.G.requestDecodeFace(str, a16, true);
                            bitmapFromCache = this.f285804f;
                        }
                        forwardHeadView.setBackgroundDrawable(new BitmapDrawable(SelectedAndSearchBar.this.H.getResources(), bitmapFromCache));
                    }
                } else {
                    if (SelectedAndSearchBar.this.L != null) {
                        drawable2 = SelectedAndSearchBar.this.L.getAvatarDrawable(resultRecord.guildId, 100, null, true);
                    }
                    forwardHeadView.setBackgroundDrawable(drawable2);
                }
                forwardHeadView.setContentDescription(resultRecord.name + "\u6309\u94ae \u70b9\u51fb\u5220\u9664");
                if (SelectedAndSearchBar.this.M == 1) {
                    ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).updateSelectGradeIcon((ImageView) view.findViewById(R.id.y3s), resultRecord.uin);
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                this.f285802d = false;
                super.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface i {
        void a(ResultRecord resultRecord);

        void afterTextChanged(Editable editable);

        void b(boolean z16);
    }

    public SelectedAndSearchBar(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.E = new ArrayList();
        this.K = new ResultRecord.DefaultComparator();
        this.P = new a();
        B();
        D();
    }

    private int A() {
        float realWidth = ScreenUtil.getRealWidth(this.H);
        return (int) (((int) (((int) (realWidth - (90.0f * r1))) / (r1 * 50.0f))) * this.D * 50.0f);
    }

    private void B() {
        this.D = getResources().getDisplayMetrics().density;
        this.H = getContext();
    }

    private void C() {
        this.N = A();
        int i3 = (int) (this.D * 300.0f);
        if (FontSettingManager.isFontSizeLarge()) {
            i3 = this.N;
        }
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        layoutParams.width = i3;
        this.C.setLayoutParams(layoutParams);
    }

    private void D() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.byo, this);
        this.f285787d = inflate;
        this.f285788e = (CustomGridView) inflate.findViewById(R.id.imn);
        this.f285789f = (EditText) this.f285787d.findViewById(R.id.ik5);
        this.f285790h = this.f285787d.findViewById(R.id.f81214dk);
        this.f285791i = (ImageView) this.f285787d.findViewById(R.id.dif);
        this.f285792m = (ImageView) this.f285787d.findViewById(R.id.ijw);
        CustomHorizontalScrollView customHorizontalScrollView = (CustomHorizontalScrollView) this.f285787d.findViewById(R.id.iig);
        this.C = customHorizontalScrollView;
        AccessibilityUtil.n(customHorizontalScrollView, false);
        this.C.setOverScrollMode(2);
        this.f285788e.setOverScrollMode(2);
        this.f285788e.setOnItemClickListener(new b());
        this.f285789f.setOnKeyListener(new c());
        this.f285789f.addTextChangedListener(this.P);
        this.f285789f.setOnFocusChangeListener(new d());
        this.f285790h.setOnClickListener(new e());
        x();
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        EditText editText = this.f285789f;
        if (editText != null && editText.getText() != null) {
            if (!TextUtils.isEmpty(this.f285789f.getText().toString())) {
                this.f285790h.setVisibility(0);
            } else {
                this.f285790h.setVisibility(8);
            }
        }
    }

    public static final int y(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f285789f.hasFocus();
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.C.scrollTo(this.f285788e.getLayoutParams().width, 0);
        }
    }

    public void H(List<ResultRecord> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, list, Boolean.valueOf(z16));
            return;
        }
        Collections.sort(list, this.K);
        this.E = list;
        p(z16);
    }

    public void o(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onClickListener);
        } else {
            this.f285789f.setOnClickListener(new f(onClickListener));
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (this.f285788e == null) {
            return;
        }
        for (int i17 = 0; i17 < this.f285788e.getChildCount(); i17++) {
            View childAt = this.f285788e.getChildAt(i17);
            Object tag = childAt.getTag();
            if (tag != null && (tag instanceof ResultRecord)) {
                ResultRecord resultRecord = (ResultRecord) tag;
                if (str.equals(resultRecord.uin) && resultRecord.type == i16) {
                    ((ForwardHeadView) childAt.findViewById(R.id.c0o)).setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));
                }
            }
        }
    }

    public void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        this.f285788e.setNumColumns(this.E.size());
        ViewGroup.LayoutParams layoutParams = this.f285788e.getLayoutParams();
        layoutParams.width = (int) (((this.E.size() * 40) + (this.E.size() * 10)) * this.D);
        this.f285788e.setLayoutParams(layoutParams);
        q();
        if (z16) {
            postDelayed(new Runnable() { // from class: com.tencent.mobileqq.selectmember.SelectedAndSearchBar.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectedAndSearchBar.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SelectedAndSearchBar.this.F();
                    }
                }
            }, 200L);
        }
        this.F.notifyDataSetChanged();
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (this.D * 40.0f));
        int i3 = (int) (this.D * 40.0f);
        if (this.E.size() > 0) {
            if (this.E.size() < 7) {
                float size = (this.E.size() * 40) + (this.E.size() * 10);
                float f16 = this.D;
                i3 = ((int) (size * f16)) + ((int) (f16 * 10.0f));
            } else {
                i3 = (int) (this.D * 310.0f);
            }
            if (FontSettingManager.isFontSizeLarge()) {
                i3 = Math.min(i3, this.N + ((int) (this.D * 10.0f)));
            }
            this.f285792m.setVisibility(8);
        } else {
            this.f285792m.setVisibility(0);
        }
        layoutParams.addRule(15);
        layoutParams.setMargins(i3, 0, 0, 0);
        this.f285789f.setLayoutParams(layoutParams);
    }

    public void r(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
            return;
        }
        int y16 = y(60.0f, getResources());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f285787d.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(-y16, 0);
        ofInt.setDuration(j3);
        ofInt.addUpdateListener(new g(layoutParams));
        ofInt.start();
    }

    public void s(List<ResultRecord> list, IFaceDecoder iFaceDecoder, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, list, iFaceDecoder, iVar);
            return;
        }
        if (list != null) {
            this.E = list;
        }
        this.G = iFaceDecoder;
        this.I = iVar;
        h hVar = new h();
        this.F = hVar;
        this.f285788e.setAdapter((ListAdapter) hVar);
        this.f285788e.setSmoothScrollbarEnabled(false);
        this.G.setDecodeTaskCompletionListener(this);
    }

    public void setIsFrom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.M = i3;
        }
    }

    public void t(List<ResultRecord> list, IFaceDecoder iFaceDecoder, i iVar, IQQGuildService iQQGuildService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, list, iFaceDecoder, iVar, iQQGuildService);
        } else {
            this.L = iQQGuildService;
            s(list, iFaceDecoder, iVar);
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.f285789f.setText("");
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.f285789f.clearFocus();
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        this.f285789f.removeTextChangedListener(this.P);
        this.f285789f.setText("");
        this.f285789f.addTextChangedListener(this.P);
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (Build.VERSION.SDK_INT < 26) {
                return;
            }
            try {
                View.class.getMethod("setImportantForAutofill", Integer.TYPE).invoke(this.f285789f, 8);
            } catch (Exception e16) {
                QLog.w("SelectedAndSearchBar", 2, "disable auto fill error", e16);
            }
        }
    }

    public Editable z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Editable) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f285789f.getText();
    }

    public SelectedAndSearchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.E = new ArrayList();
        this.K = new ResultRecord.DefaultComparator();
        this.P = new a();
        B();
        D();
    }

    public SelectedAndSearchBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.E = new ArrayList();
        this.K = new ResultRecord.DefaultComparator();
        this.P = new a();
        B();
        D();
    }
}
