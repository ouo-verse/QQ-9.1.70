package com.tencent.mobileqq.onlinestatus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.tempapi.IEmojiPanelApi;
import com.tencent.mobileqq.onlinestatus.view.SoftInputDetectView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AutoReplyEditActivity extends QIphoneTitleBarFragment implements SoftInputDetectView.a {
    private ViewGroup C;
    private EditText D;
    private View E;
    private AutoReplyText F;
    private ImageView G;
    private ImageView H;
    private View.OnTouchListener I = new a();
    private Handler J;
    private AppRuntime K;
    private boolean L;
    private boolean M;
    private boolean N;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b extends Editable.Factory {
        b() {
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            if (charSequence instanceof QQTextBuilder) {
                return (Editable) charSequence;
            }
            return new QQTextBuilder(charSequence, 3, (int) (AutoReplyEditActivity.this.D.getTextSize() / AutoReplyEditActivity.this.D.getPaint().density));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (AutoReplyEditActivity.this.L) {
                AutoReplyEditActivity.this.Jh(false);
            } else if (AutoReplyEditActivity.this.M) {
                AutoReplyEditActivity.this.Ih(false);
            } else {
                AutoReplyEditActivity.this.Jh(true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AutoReplyEditActivity.this.Ih(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!AutoReplyEditActivity.this.getQBaseActivity().isFinishing()) {
                AutoReplyEditActivity.this.getQBaseActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh() {
        if (!this.M && !this.L) {
            this.H.setImageResource(R.drawable.byq);
            this.H.setContentDescription(getQBaseActivity().getString(R.string.f170524ts));
        } else {
            this.H.setImageResource(R.drawable.byp);
            this.H.setContentDescription(getQBaseActivity().getString(R.string.f170521tp));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void Eh(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        setTitle(getString(R.string.f170514ta));
        this.quiSecNavBar.setLeftType(1);
        this.quiSecNavBar.setRightType(1);
        this.quiSecNavBar.setLeftText(getResources().getString(R.string.cancel));
        this.quiSecNavBar.setRightText(getResources().getString(R.string.b9f));
        this.quiSecNavBar.setOnBaseTitleBarClickListener(new Function2() { // from class: com.tencent.mobileqq.onlinestatus.s
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit Gh;
                Gh = AutoReplyEditActivity.this.Gh((View) obj, (BaseAction) obj2);
                return Gh;
            }
        });
        ((SoftInputDetectView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.dmq)).setOnImStateChangedListener(this);
        this.F = (AutoReplyText) bundle.getParcelable("AutoReplyEditActivity:text");
        this.C = (ViewGroup) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.bvc);
        EditText editText = (EditText) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.a1p);
        this.D = editText;
        editText.setEditableFactory(new b());
        AutoReplyText autoReplyText = this.F;
        if (autoReplyText != null) {
            if (autoReplyText.getTextId() == Integer.MAX_VALUE) {
                this.N = false;
            } else {
                this.D.setText(this.F.getRawText());
            }
        } else {
            this.N = true;
        }
        this.D.setFocusable(true);
        this.D.setFocusableInTouchMode(true);
        this.D.requestFocus();
        View findAndInitEmojiPanel = ((IEmojiPanelApi) QRoute.api(IEmojiPanelApi.class)).findAndInitEmojiPanel(this.K, getQBaseActivity(), ((QIphoneTitleBarFragment) this).mContentView, R.id.bve, this.D);
        this.E = findAndInitEmojiPanel;
        findAndInitEmojiPanel.setVisibility(8);
        if (TextUtils.isEmpty(this.D.getText())) {
            this.quiSecNavBar.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, false);
        }
        this.D.addTextChangedListener(new c());
        ImageView imageView = (ImageView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.bvo);
        this.G = imageView;
        imageView.setOnTouchListener(this.I);
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutoReplyEditActivity.this.Hh(view);
            }
        });
        ImageView imageView2 = (ImageView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.bvq);
        this.H = imageView2;
        imageView2.setOnTouchListener(this.I);
        this.H.setOnClickListener(new d());
        if (!QQTheme.isDefaultTheme()) {
            ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.jta).setVisibility(8);
            ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.acn).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fh(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Gh(View view, BaseAction baseAction) {
        String str;
        if (baseAction == BaseAction.ACTION_LEFT_TEXT) {
            as.d(this.K, false);
            String valueOf = String.valueOf(this.D.getText());
            AutoReplyText autoReplyText = this.F;
            if (autoReplyText != null) {
                str = autoReplyText.getRawText();
            } else {
                str = "";
            }
            if (valueOf.equals(str)) {
                super.onBackEvent();
                return null;
            }
            Kh();
            return null;
        }
        if (baseAction == BaseAction.ACTION_RIGHT_TEXT) {
            as.d(this.K, true);
            Intent intent = new Intent();
            intent.putExtra("AutoReplyEditActivity:new_text", this.N);
            if (this.F != null) {
                intent.putExtra("AutoReplyEditActivity:text", new AutoReplyText(AutoReplyText.trimRawString(String.valueOf(this.D.getText()), false), this.F.getTextId()));
            }
            getQBaseActivity().setResult(325, intent);
            getQBaseActivity().finish();
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Ih(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih(boolean z16) {
        long j3;
        if (z16) {
            Jh(false);
            Handler handler = this.J;
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.6

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity$6$a */
                /* loaded from: classes16.dex */
                class a implements View.OnClickListener {
                    a() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        AutoReplyEditActivity.this.Jh(true);
                        EventCollector.getInstance().onViewClicked(view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    AutoReplyEditActivity.this.M = true;
                    ViewGroup.LayoutParams layoutParams = AutoReplyEditActivity.this.C.getLayoutParams();
                    AutoReplyEditActivity.this.G.setImageResource(R.drawable.f160027bz1);
                    QBaseActivity qBaseActivity = AutoReplyEditActivity.this.getQBaseActivity();
                    if (qBaseActivity != null) {
                        AutoReplyEditActivity.this.G.setContentDescription(qBaseActivity.getString(R.string.f170520tn));
                    }
                    AutoReplyEditActivity.this.G.setOnClickListener(new a());
                    AutoReplyEditActivity.this.E.setVisibility(0);
                    layoutParams.height = (ScreenUtil.SCREEN_HIGHT / 3) + ScreenUtil.dip2px(50.0f);
                    AutoReplyEditActivity.this.C.setMinimumHeight(layoutParams.height);
                    AutoReplyEditActivity.this.C.setLayoutParams(layoutParams);
                    AutoReplyEditActivity.this.Dh();
                }
            };
            if (this.L) {
                j3 = 500;
            } else {
                j3 = 10;
            }
            handler.postDelayed(runnable, j3);
            return;
        }
        this.M = false;
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        this.G.setImageResource(R.drawable.skin_aio_panel_emotion_nor);
        this.G.setContentDescription(getQBaseActivity().getString(R.string.f170519tm));
        this.G.setOnClickListener(new e());
        this.E.setVisibility(8);
        layoutParams.height = -2;
        this.C.setMinimumHeight(0);
        this.C.setLayoutParams(layoutParams);
        Dh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh(boolean z16) {
        if (z16) {
            Ih(false);
            this.J.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    InputMethodUtil.show(AutoReplyEditActivity.this.D);
                }
            }, 0L);
        } else {
            InputMethodUtil.hide(this.D);
        }
    }

    private void Kh() {
        QQCustomDialog message = DialogUtil.createCustomDialog(getQBaseActivity(), 230).setMessage(getString(R.string.f170523tr));
        message.setPositiveButton(R.string.f171151ok, new f());
        message.setNegativeButton(R.string.cancel, new g());
        message.show();
    }

    public static void Lh(Activity activity, int i3, AutoReplyText autoReplyText) {
        Intent intent = new Intent();
        intent.putExtra("AutoReplyEditActivity:text", autoReplyText);
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) AutoReplyEditActivity.class, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.K = MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.J = new Handler();
        this.L = false;
        this.N = false;
        this.M = false;
        Eh(getArguments());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167525r;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.getWindow().setSoftInputMode(16);
        activity.getWindow().getDecorView().setBackgroundResource(R.drawable.bg_texture);
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.SoftInputDetectView.a
    public void n4(boolean z16, int i3) {
        if (z16) {
            Ih(false);
        }
        this.L = z16;
        Dh();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (!getQBaseActivity().isFinishing() && this.E.getVisibility() == 0) {
            Ih(false);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f255281d;

        /* renamed from: e, reason: collision with root package name */
        private int f255282e;

        /* renamed from: f, reason: collision with root package name */
        private int f255283f;

        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CharSequence charSequence = this.f255281d;
            if (charSequence != null && com.tencent.mobileqq.text.TextUtils.getQQTextCharCount(String.valueOf(charSequence), 3) > 100) {
                QQToast.makeText(AutoReplyEditActivity.this.getQBaseActivity(), 1, R.string.f170518tl, 0).show();
                editable.delete(this.f255282e, this.f255283f);
            }
            AutoReplyEditActivity autoReplyEditActivity = AutoReplyEditActivity.this;
            autoReplyEditActivity.quiSecNavBar.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, autoReplyEditActivity.Fh(String.valueOf(autoReplyEditActivity.D.getText())));
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            this.f255281d = charSequence;
            this.f255282e = i3;
            this.f255283f = i3 + i17;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
