package po0;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.at.quickAt.dialogui.component.searchbar.SearchBarGridView;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.guild.aio.input.at.utils.data.AtUserWithRoleInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import no0.k;
import po0.i;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h extends oo0.a implements i.a<IGProUserInfo> {

    /* renamed from: c, reason: collision with root package name */
    private Context f426582c;

    /* renamed from: d, reason: collision with root package name */
    private final k f426583d;

    /* renamed from: e, reason: collision with root package name */
    private i<IGProUserInfo> f426584e;

    /* renamed from: f, reason: collision with root package name */
    private c f426585f;

    /* renamed from: g, reason: collision with root package name */
    private View f426586g;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f426587h;

    /* renamed from: i, reason: collision with root package name */
    private EditText f426588i;

    /* renamed from: j, reason: collision with root package name */
    private SearchBarGridView f426589j;

    /* renamed from: k, reason: collision with root package name */
    public View.OnFocusChangeListener f426590k;

    /* renamed from: l, reason: collision with root package name */
    private int f426591l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f426592m;

    /* renamed from: n, reason: collision with root package name */
    public ye1.a f426593n;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends ye1.c {
        a() {
        }

        @Override // ye1.c, ye1.a
        public void a(Set<IGProUserInfo> set) {
            if (h.this.f426584e != null) {
                h.this.f426584e.i();
            }
        }

        @Override // ye1.a
        public void d(boolean z16, int i3, List<IGProUserInfo> list) {
            if (h.this.f426584e != null) {
                h.this.f426584e.i();
            }
            if (h.this.f426588i != null) {
                h.this.f426588i.getEditableText().clear();
                h.this.M(true);
                h.this.f426591l = 0;
                h.this.K(true, false);
            }
        }

        @Override // ye1.a
        public void e(boolean z16, String str, IGProUserInfo iGProUserInfo, int i3, int i16) {
            boolean z17;
            if (h.this.f426584e != null) {
                boolean z18 = true;
                if (z16) {
                    j jVar = new j(iGProUserInfo);
                    if (iGProUserInfo instanceof AtUserWithRoleInfo) {
                        AtUserWithRoleInfo atUserWithRoleInfo = (AtUserWithRoleInfo) iGProUserInfo;
                        int atType = atUserWithRoleInfo.getAtType();
                        if (atType == 8) {
                            AtRoleInfo atRole = atUserWithRoleInfo.getAtRole();
                            if (atRole != null) {
                                jVar.c(xo0.d.g((int) atRole.getColor()));
                            }
                        } else if (atType == 64) {
                            jVar.c(h.this.f426582c.getResources().getDrawable(R.drawable.guild_at_online));
                        } else {
                            jVar.c(h.this.f426582c.getResources().getDrawable(R.drawable.guild_at_all));
                        }
                    }
                    h.this.f426584e.a(str, jVar);
                    h.this.f426589j.smoothScrollToPosition(h.this.f426584e.getCount() - 1);
                } else {
                    h.this.f426584e.j(iGProUserInfo);
                }
                h hVar = h.this;
                if (i3 == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                hVar.M(z17);
                h hVar2 = h.this;
                if (i3 != 0 || hVar2.f426588i.hasFocus()) {
                    z18 = false;
                }
                hVar2.K(z18, false);
                h.this.f426591l = i3;
            }
        }

        @Override // ye1.c, ye1.b
        public void f() {
            if (h.this.f426584e != null) {
                h.this.f426584e.i();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface c {
        void a(IGProUserInfo iGProUserInfo);

        void b(IGProUserInfo iGProUserInfo);

        void c(String str);
    }

    public h(@NonNull Context context, @NonNull k kVar) {
        super(context);
        this.f426591l = 0;
        this.f426593n = new a();
        this.f426583d = kVar;
        this.f426582c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean A(View view, int i3, KeyEvent keyEvent) {
        int count;
        if (i3 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(this.f426588i.getText().toString()) && this.f426585f != null && this.f426584e.getCount() - 2 >= 0) {
            Object item = this.f426584e.getItem(count);
            if (item instanceof j) {
                this.f426585f.a(((j) item).getData());
                return true;
            }
        }
        if (i3 == 66) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(int i3) {
        this.f426588i.setTranslationX(0.0f);
        ViewGroup.LayoutParams layoutParams = this.f426588i.getLayoutParams();
        layoutParams.width = i3;
        this.f426588i.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EditText editText = this.f426588i;
        if (editText != null) {
            editText.setText("");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f426582c.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.f426588i, 1);
        }
    }

    private void F(SearchBarGridView searchBarGridView) {
        QLog.d("AtPanelSearchBar", 4, "onCreateView: set up grid adapter");
        i<IGProUserInfo> iVar = new i<>(this.f426583d, this.f426587h);
        this.f426584e = iVar;
        iVar.k(this);
        searchBarGridView.setAdapter((ListAdapter) this.f426584e);
        searchBarGridView.setOnItemClickListener(this.f426584e);
    }

    private void G() {
        this.f426588i.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: po0.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                h.this.z(view, z16);
            }
        });
        this.f426588i.setOnKeyListener(new View.OnKeyListener() { // from class: po0.f
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                boolean A;
                A = h.this.A(view, i3, keyEvent);
                return A;
            }
        });
        this.f426588i.setSingleLine();
        this.f426588i.addTextChangedListener(x());
    }

    private void H(SearchBarGridView searchBarGridView) {
        QLog.d("AtPanelSearchBar", 4, "onCreateView: setUp layout params");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        k.b bVar = this.f426583d.f420571a;
        int i3 = bVar.f420591f;
        layoutParams.setMargins(i3, bVar.f420593h, i3, bVar.f420592g);
        layoutParams.height = -2;
        searchBarGridView.setLayoutParams(layoutParams);
        Objects.requireNonNull(this.f426583d.f420571a);
        searchBarGridView.setNumColumns(4);
        searchBarGridView.setMinimumHeight(this.f426583d.f420571a.f420586a);
        searchBarGridView.setMaxHeight(this.f426583d.f420571a.f420587b);
        searchBarGridView.setHorizontalSpacing(this.f426583d.f420571a.f420594i);
        searchBarGridView.setVerticalSpacing(this.f426583d.f420571a.f420595j);
        searchBarGridView.setClipToPadding(false);
        searchBarGridView.setClipChildren(false);
        int i16 = this.f426583d.f420571a.f420594i;
        searchBarGridView.setPadding(i16, i16, i16, i16);
    }

    private void I(SearchBarGridView searchBarGridView, LinearLayout linearLayout) {
        QLog.d("AtPanelSearchBar", 4, "onCreateView: colorize view");
        searchBarGridView.setSelector(new ColorDrawable(0));
        searchBarGridView.setBackgroundResource(this.f426583d.f420573c.f420607b);
        linearLayout.setBackgroundColor(this.f426583d.f420572b.f420578e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z16, boolean z17) {
        final int i3;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f426588i.getLayoutParams();
        if (z16) {
            i3 = -2;
        } else {
            i3 = -1;
        }
        if (i3 != layoutParams.width) {
            if (z17) {
                if (z16) {
                    int width = this.f426587h.getWidth();
                    layoutParams.width = i3;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    this.f426588i.setLayoutParams(layoutParams);
                    this.f426588i.measure(makeMeasureSpec, makeMeasureSpec);
                    this.f426588i.setTranslationX((-(width - this.f426588i.getMeasuredWidth())) / 2.0f);
                    this.f426588i.animate().setDuration(150L).setInterpolator(new DecelerateInterpolator()).translationX(0.0f).start();
                    return;
                }
                this.f426588i.animate().setDuration(150L).setInterpolator(new DecelerateInterpolator()).translationX(-this.f426588i.getLeft()).withEndAction(new Runnable() { // from class: po0.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.this.B(i3);
                    }
                }).start();
                return;
            }
            layoutParams.width = i3;
            this.f426588i.setLayoutParams(layoutParams);
        }
    }

    private void L() {
        this.f426592m = new ImageView(this.f426582c);
        this.f426592m.setImageDrawable(ie0.a.f().o(this.f426582c, this.f426583d.f420573c.f420611f, R.color.qui_common_icon_secondary, 1001));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(18.0f), ViewUtils.dpToPx(18.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        this.f426592m.setLayoutParams(layoutParams);
        this.f426592m.setOnClickListener(new View.OnClickListener() { // from class: po0.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.this.C(view);
            }
        });
        this.f426592m.setVisibility(8);
        this.f426587h.addView(this.f426592m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f426588i.requestFocus();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view, boolean z16) {
        boolean z17;
        if (z16) {
            N();
        }
        if (this.f426591l == 0 && !z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        K(z17, true);
        this.f426588i.setCursorVisible(false);
        this.f426588i.setCursorVisible(true);
        View.OnFocusChangeListener onFocusChangeListener = this.f426590k;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z16);
        }
    }

    protected void E(SearchBarGridView searchBarGridView, LinearLayout linearLayout) {
        H(searchBarGridView);
        I(searchBarGridView, linearLayout);
        F(searchBarGridView);
        G();
    }

    public void J(c cVar) {
        this.f426585f = cVar;
    }

    public void M(boolean z16) {
        EditText editText;
        if (this.f426582c != null && (editText = this.f426588i) != null) {
            if (z16) {
                Drawable o16 = ie0.a.f().o(this.f426582c, this.f426583d.f420573c.f420610e, R.color.qui_common_icon_secondary, 1001);
                o16.setBounds(ViewUtils.dpToPx(5.0f), ViewUtils.dpToPx(1.0f), ViewUtils.dpToPx(22.0f), ViewUtils.dpToPx(18.0f));
                this.f426588i.setCompoundDrawables(o16, null, null, null);
                this.f426588i.setCompoundDrawablePadding(ViewUtils.dpToPx(8.0f));
                return;
            }
            editText.setCompoundDrawables(null, null, null, null);
        }
    }

    public void N() {
        this.f426588i.setFocusable(true);
        this.f426588i.setFocusableInTouchMode(true);
        this.f426588i.requestFocus();
        this.f426588i.postDelayed(new Runnable() { // from class: po0.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.D();
            }
        }, 200L);
    }

    @Override // po0.i.a
    public void a(int i3, i.b<IGProUserInfo> bVar) {
        c cVar = this.f426585f;
        if (cVar != null) {
            cVar.b(bVar.getData());
        }
    }

    @Override // oo0.a
    protected int b() {
        return 0;
    }

    @Override // oo0.a
    public View c() {
        if (this.f426586g == null) {
            this.f426586g = e(this.f426582c);
        }
        return this.f426586g;
    }

    @Override // oo0.a
    public int d() {
        return 0;
    }

    @Override // oo0.a
    protected View e(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f426587h = relativeLayout;
        relativeLayout.setPadding(0, 0, 0, 0);
        this.f426587h.setOnClickListener(new View.OnClickListener() { // from class: po0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.this.y(view);
            }
        });
        EditText editText = new EditText(context);
        this.f426588i = editText;
        editText.setPadding(0, 0, ViewUtils.dpToPx(25.0f), 0);
        this.f426588i.setBackground(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.f426588i.setLayoutParams(layoutParams);
        this.f426588i.setHintTextColor(this.f426583d.f420572b.f420575b);
        this.f426588i.setTextColor(this.f426583d.f420572b.f420576c);
        if (Build.VERSION.SDK_INT >= 29) {
            this.f426588i.setTextCursorDrawable(this.f426583d.f420573c.f420609d);
        }
        this.f426588i.setHint(R.string.f139840cc);
        this.f426588i.setTextSize(this.f426583d.f420571a.f420597l);
        this.f426587h.addView(this.f426588i);
        L();
        M(true);
        this.f426589j = new SearchBarGridView(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(this.f426589j);
        E(this.f426589j, linearLayout);
        return linearLayout;
    }

    @Override // oo0.a
    public void i() {
        this.f426582c = null;
    }

    protected TextWatcher x() {
        return new b();
    }

    @Override // oo0.a
    protected void h(@NonNull ViewGroup viewGroup) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        boolean f426595d = false;

        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (h.this.f426585f != null && !this.f426595d) {
                this.f426595d = true;
                h.this.f426585f.c(editable.toString());
                this.f426595d = false;
            }
            if (h.this.f426592m != null) {
                if (!editable.toString().isEmpty()) {
                    h.this.f426592m.setVisibility(0);
                } else {
                    h.this.f426592m.setVisibility(8);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
