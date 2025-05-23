package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FunctionSearchFragment extends BaseSearchFragment {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends mn2.b<y, sn2.c> {
        a(ListView listView, IFaceDecoder iFaceDecoder) {
            super(listView, iFaceDecoder);
        }

        @Override // mn2.a
        protected qn2.d<y, sn2.c> e(int i3) {
            return new com.tencent.mobileqq.search.presenter.b(this.f417042e, 268435456);
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new com.tencent.mobileqq.search.view.q(viewGroup, 268435456);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean qh(View view, MotionEvent motionEvent) {
        ((InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
        return false;
    }

    public static FunctionSearchFragment rh() {
        return new FunctionSearchFragment();
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getHeaderText() {
        return nn2.a.c();
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getRightTvText() {
        return getHeaderText();
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected int getSearchModule() {
        return 120;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected mn2.a newAdapter() {
        return new a(this.listView, this.faceDecoder);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected on2.b newSearchEngine() {
        return new com.tencent.mobileqq.search.searchlocal.searchengine.a().a((QQAppInterface) this.appInterface, -1);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.listView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.search.fragment.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean qh5;
                qh5 = FunctionSearchFragment.qh(view2, motionEvent);
                return qh5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void startSearch(String str, int i3) {
        super.startSearch(str, i3);
    }
}
