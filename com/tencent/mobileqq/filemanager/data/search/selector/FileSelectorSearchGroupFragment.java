package com.tencent.mobileqq.filemanager.data.search.selector;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ListView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileSelectorSearchGroupFragment extends IphoneTitleBarFragment {
    private static com.tencent.mobileqq.filemanager.data.search.selector.a H;
    private Bundle C;
    private ListView D;
    private View E;
    private b F;
    private com.tencent.mobileqq.filemanager.widget.e G;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ((InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class b extends mn2.a<y, sn2.c> {

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements e {
            a() {
            }

            @Override // com.tencent.mobileqq.filemanager.data.search.selector.e
            public void a() {
                FileSelectorSearchGroupFragment.this.G.f();
            }
        }

        public b(com.tencent.mobileqq.filemanager.data.search.selector.a aVar) {
            try {
                List<y> H = aVar.H(FileSelectorSearchGroupFragment.this.getBaseActivity().app, FileSelectorSearchGroupFragment.this.getBaseActivity());
                if (H != null && !H.isEmpty()) {
                    g(H);
                }
            } catch (Exception unused) {
            }
        }

        @Override // mn2.a
        protected qn2.d<y, sn2.c> e(int i3) {
            com.tencent.mobileqq.filemanager.data.search.selector.b bVar = new com.tencent.mobileqq.filemanager.data.search.selector.b();
            bVar.e(new a());
            return bVar;
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new c(viewGroup);
        }
    }

    private String getHeaderText() {
        if (H != null) {
            return String.format(getString(R.string.ipj), Integer.valueOf(H.L()), H.getKeyword());
        }
        return "";
    }

    public static void rh(com.tencent.mobileqq.filemanager.data.search.selector.a aVar) {
        H = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        RelativeLayout relativeLayout = (RelativeLayout) ((IphoneTitleBarFragment) this).mContentView;
        ListView listView = (ListView) relativeLayout.findViewById(R.id.eap);
        this.D = listView;
        listView.setOnTouchListener(new a());
        this.E = relativeLayout.findViewById(R.id.d4l);
        QFileSendBottomView qFileSendBottomView = new QFileSendBottomView(relativeLayout.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(qFileSendBottomView, layoutParams);
        this.C = getArguments().getBundle("qfile_search_param_ex_params");
        com.tencent.mobileqq.filemanager.widget.e a16 = com.tencent.mobileqq.filemanager.widget.e.a(getBaseActivity().app, getBaseActivity(), qFileSendBottomView, this.C);
        this.G = a16;
        a16.d(this.C);
        this.G.e();
        this.G.d(this.C);
        qFileSendBottomView.a(this.D);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.as9;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        H = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        setTitle(H.I());
        super.onViewCreated(view, bundle);
        ((TextView) this.E.findViewById(R.id.d3z)).setText(getHeaderText());
        b bVar = new b(H);
        this.F = bVar;
        this.D.setAdapter((ListAdapter) bVar);
        this.G.f();
    }
}
