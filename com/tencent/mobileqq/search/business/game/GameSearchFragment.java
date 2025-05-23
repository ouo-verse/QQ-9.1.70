package com.tencent.mobileqq.search.business.game;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import lo2.s;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GameSearchFragment extends QPublicBaseFragment implements com.tencent.mobileqq.search.business.game.c, Handler.Callback, TextView.OnEditorActionListener, TextWatcher {
    private com.tencent.mobileqq.search.business.game.a C = new com.tencent.mobileqq.search.business.game.a(this);
    private String D;
    protected QuickPinyinEditText E;
    protected Button F;
    protected ImageButton G;
    protected ListView H;
    protected mn2.a I;
    protected TextView J;
    protected TextView K;
    protected TextView L;
    protected View M;
    protected ImageView N;
    private Handler P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GameSearchFragment.this.getActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            GameSearchFragment.this.hideInputMethod();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GameSearchFragment.this.E.setText("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GameSearchFragment.this.getActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e extends mn2.b<y, sn2.c> {
        e(ListView listView, IFaceDecoder iFaceDecoder) {
            super(listView, iFaceDecoder);
        }

        @Override // mn2.a
        protected qn2.d<y, sn2.c> e(int i3) {
            return new com.tencent.mobileqq.search.business.game.b(this.f417042e);
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new com.tencent.mobileqq.search.business.game.e(viewGroup, R.layout.fuj);
        }
    }

    private void initData() {
        this.P = new Handler(this);
        this.D = getArguments().getString("search_words");
    }

    private void initViews(View view) {
        this.M = view.findViewById(R.id.asn);
        this.K = (TextView) view.findViewById(R.id.f95565fb);
        ImageView imageView = (ImageView) view.findViewById(R.id.du6);
        this.N = imageView;
        imageView.setVisibility(0);
        this.N.setOnClickListener(new a());
        ListView listView = (ListView) view.findViewById(R.id.eap);
        this.H = listView;
        listView.setOnTouchListener(new b());
        View inflate = getLayoutInflater().inflate(R.layout.awk, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.cih);
        this.J = textView;
        textView.setText(HardCodeUtil.qqStr(R.string.jzu));
        this.J.setTextSize(16.0f);
        this.J.setTextColor(getResources().getColor(R.color.skin_gray3));
        this.J.setVisibility(8);
        this.L = (TextView) inflate.findViewById(R.id.f_u);
        this.H.addFooterView(inflate);
        mn2.a ph5 = ph();
        this.I = ph5;
        this.H.setAdapter((ListAdapter) ph5);
    }

    private mn2.a ph() {
        return new e(this.H, ((IQQAvatarService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface) getQBaseActivity().getAppRuntime()));
    }

    private View qh(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.hpn, (ViewGroup) null, false);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            inflate.setFitsSystemWindows(true);
        }
        return inflate;
    }

    private void rh(View view) {
        QuickPinyinEditText quickPinyinEditText = (QuickPinyinEditText) view.findViewById(R.id.et_search_keyword);
        this.E = quickPinyinEditText;
        quickPinyinEditText.setHint(getResources().getString(R.string.jzt));
        this.E.setImeOptions(3);
        this.E.setOnEditorActionListener(this);
        this.E.addTextChangedListener(this);
        this.E.setInputType(524289);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.ib_clear_text);
        this.G = imageButton;
        imageButton.setOnClickListener(new c());
        Button button = (Button) view.findViewById(R.id.btn_cancel_search);
        this.F = button;
        button.setVisibility(0);
        this.F.setText(R.string.cancel);
        this.F.setOnClickListener(new d());
    }

    private void sh(Message message) {
        Object obj;
        if (message != null && (obj = message.obj) != null) {
            Object[] objArr = (Object[]) obj;
            String str = (String) objArr[0];
            Long l3 = (Long) objArr[1];
            List<s> list = (List) objArr[2];
            if (l3.longValue() == 0) {
                if (list != null && list.size() > 0) {
                    vh(list);
                    return;
                } else {
                    wh(str);
                    return;
                }
            }
            uh();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i3;
        String obj = this.E.getText().toString();
        ImageButton imageButton = this.G;
        if (TextUtils.isEmpty(obj)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        imageButton.setVisibility(i3);
        startSearch(obj.trim());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        sh(message);
        return true;
    }

    protected void hideInputMethod() {
        this.E.clearFocus();
        ((InputMethodManager) MobileQQ.sMobileQQ.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.E.getWindowToken(), 0);
    }

    @Override // com.tencent.mobileqq.search.business.game.c
    public void kc(String str, long j3, List<s> list) {
        String str2 = this.D;
        if (str2 != null && str2.equals(str) && this.P != null) {
            Object[] objArr = {str, Long.valueOf(j3), list};
            Message obtainMessage = this.P.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = objArr;
            this.P.removeMessages(1);
            this.P.sendMessage(obtainMessage);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        initData();
        View qh5 = qh(layoutInflater);
        initViews(qh5);
        rh(qh5);
        this.E.setText(this.D);
        this.E.setSelection(this.D.length());
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "982", "9075", "907801", "907218", "", "", "7", "");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, qh5);
        return qh5;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Handler handler = this.P;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.C.e();
        super.onDestroy();
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        boolean z16;
        if (i3 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            z16 = false;
        } else {
            startSearch(this.E.getText().toString().trim());
            hideInputMethod();
            z16 = true;
        }
        EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
        return z16;
    }

    protected void startSearch(String str) {
        if (TextUtils.isEmpty(str)) {
            th();
            return;
        }
        this.D = str;
        this.C.g(str);
        xh();
    }

    protected void th() {
        this.I.g(null);
        this.M.setVisibility(8);
        this.K.setVisibility(8);
        this.J.setVisibility(8);
        this.L.setVisibility(8);
    }

    protected void uh() {
        this.I.g(null);
        this.M.setVisibility(8);
        this.K.setVisibility(8);
        this.J.setVisibility(0);
        this.L.setVisibility(8);
    }

    protected void vh(List<s> list) {
        this.I.g(list);
        this.M.setVisibility(8);
        this.K.setVisibility(8);
        this.J.setVisibility(8);
        this.L.setVisibility(0);
    }

    protected void wh(String str) {
        this.I.g(null);
        this.M.setVisibility(8);
        this.K.setVisibility(0);
        this.J.setVisibility(8);
        this.L.setVisibility(8);
        if (str == null) {
            str = "";
        }
        String string = getResources().getString(R.string.f213915rh);
        String string2 = getResources().getString(R.string.f213925ri);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append((CharSequence) string2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.search.util.a.a()), string.length(), string.length() + str.length(), 17);
        this.K.setText(spannableStringBuilder);
    }

    protected void xh() {
        this.I.g(null);
        this.M.setVisibility(0);
        this.K.setVisibility(8);
        this.J.setVisibility(8);
        this.L.setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
