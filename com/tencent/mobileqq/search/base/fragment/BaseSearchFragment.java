package com.tencent.mobileqq.search.base.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.util.VADHelper;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.ai;
import com.tencent.mobileqq.search.util.ao;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.app.MobileQQ;
import on2.b;
import on2.c;
import on2.d;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class BaseSearchFragment<M extends v> extends QBaseFragment implements Handler.Callback, d<M> {
    public static String KEY_NEED_SHOW_HEADER = "need_show_header";
    public static final int LOADING_MASK_CENTER_LOADING = 128;
    public static final int LOADING_MASK_FOOTER_ERROR = 16;
    public static final int LOADING_MASK_FOOTER_JUHUA_LOADING = 8;
    public static final int LOADING_MASK_FOOTER_LOADING = 4;
    public static final int LOADING_MASK_HEADER = 2;
    public static final int LOADING_MASK_NO_MORE_RESULT = 64;
    public static final int LOADING_MASK_NO_RESULT = 32;
    public static final long MAX_UPDATE_DURATION = 300;
    protected static final int MSG_WHAT_DELAY_REQ = 5;
    protected static final int MSG_WHAT_FINISH = 4;
    protected static final int MSG_WHAT_TIMEOUT = 3;
    protected static final int MSG_WHAT_UPDATE = 1;
    public static final int REQ_INTERVAR = 100;
    public static final int SEARCH_ENGINE_OP_CANCEL = 1;
    protected static final int SEARCH_ENGINE_OP_LOAD_MORE = 3;
    protected static final int SEARCH_ENGINE_OP_PAUSE = 2;
    private static final String TAG = "GroupSearchFragment";
    protected View activityContentView;
    protected mn2.a adapter;
    protected AppInterface appInterface;
    protected View centerLoadingLayout;
    protected IFaceDecoder faceDecoder;
    protected TextView footerErrorView;
    protected View footerLoadingJuhuaView;
    protected TextView footerLoadingView;
    protected View fragmentView;
    protected View headerLayout;
    protected volatile boolean isEngineInited;
    public volatile String keyword;
    protected ListView listView;
    protected boolean mIsApproximate;
    public List<M> mResultList;
    protected TextView noMoreResultView;
    protected LinearLayout noResultLayout;
    public b searchEngine;
    private pn2.a waitSendReq;
    public boolean isReported = false;
    public boolean tempFirstReq = false;
    private long lastUpdateTime = 0;
    protected Handler handler = new Handler(Looper.getMainLooper(), this);
    protected int searchTimes = 0;
    private long lastReqTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ((InputMethodManager) MobileQQ.sMobileQQ.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        }
    }

    protected String getDisplayType() {
        return "1";
    }

    protected String getHeaderText() {
        return null;
    }

    protected Bundle getOtherSearchRequestExtraInfo() {
        return null;
    }

    protected int getResourceId() {
        return R.layout.b1r;
    }

    protected String getRightTvText() {
        return null;
    }

    protected int getSearchModule() {
        return 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 == 5 && this.waitSendReq != null) {
                        this.lastReqTime = System.currentTimeMillis();
                        this.searchEngine.c(this.waitSendReq, this);
                        ao.c("startLocalSearch", -1);
                        if (QLog.isColorLevel()) {
                            pn2.a aVar = this.waitSendReq;
                            QLog.d(TAG, 1, "delay req keyword:", aVar.f426495a, " cookie:", aVar.f426497c, " extra:", aVar.f426496b);
                        }
                        this.waitSendReq = null;
                    }
                } else {
                    onSearchFinished(this.mResultList);
                }
            } else {
                onSearchTimeout(this.mResultList);
            }
        } else {
            this.lastUpdateTime = System.currentTimeMillis();
            onSearchUpdate(this.mResultList);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideLoading() {
        int i3;
        View view = this.headerLayout;
        if (needShowHeader()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        this.centerLoadingLayout.setVisibility(8);
        showNoResultLayout(false);
    }

    protected boolean ignoreDestroyEngine() {
        return false;
    }

    protected boolean isHideLoading() {
        return false;
    }

    protected boolean isNoResult() {
        return true;
    }

    protected boolean needShowHeader() {
        Bundle arguments = getArguments();
        Boolean bool = Boolean.TRUE;
        if (arguments != null) {
            bool = Boolean.valueOf(arguments.getBoolean(KEY_NEED_SHOW_HEADER, true));
        }
        return bool.booleanValue();
    }

    protected abstract mn2.a newAdapter();

    protected abstract b newSearchEngine();

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof QBaseActivity) {
            this.appInterface = (AppInterface) ((QBaseActivity) activity).getAppRuntime();
            return;
        }
        throw new IllegalStateException("Activity must be instance of BaseActivity");
    }

    @Override // on2.d
    public /* synthetic */ void onCancelSearch() {
        c.a(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.searchEngine = newSearchEngine();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3;
        View inflate = layoutInflater.inflate(getResourceId(), viewGroup, false);
        ListView listView = (ListView) inflate.findViewById(R.id.eap);
        this.listView = listView;
        listView.setOnTouchListener(new a());
        if (AppSetting.f99565y && ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("talkback_fix_enable_2")) {
            AccessibilityUtil.n(inflate, false);
            AccessibilityUtil.n(this.listView, false);
        }
        View findViewById = inflate.findViewById(R.id.d4l);
        this.headerLayout = findViewById;
        if (needShowHeader()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        ((TextView) inflate.findViewById(R.id.d3z)).setText(getHeaderText());
        this.centerLoadingLayout = inflate.findViewById(R.id.asn);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f166414fa2);
        this.noResultLayout = linearLayout;
        TextView textView = (TextView) linearLayout.findViewById(R.id.f166416fa4);
        String rightTvText = getRightTvText();
        if (!TextUtils.isEmpty(rightTvText)) {
            textView.setText(rightTvText);
        }
        View inflate2 = layoutInflater.inflate(R.layout.awk, (ViewGroup) null, false);
        TextView textView2 = (TextView) inflate2.findViewById(R.id.cih);
        this.footerLoadingView = textView2;
        textView2.setText(HardCodeUtil.qqStr(R.string.jzp));
        this.footerLoadingView.setVisibility(8);
        this.noMoreResultView = (TextView) inflate2.findViewById(R.id.f_u);
        View inflate3 = layoutInflater.inflate(R.layout.acp, (ViewGroup) null, false);
        View findViewById2 = inflate3.findViewById(R.id.cih);
        this.footerLoadingJuhuaView = findViewById2;
        findViewById2.setVisibility(8);
        this.listView.addFooterView(inflate3);
        View inflate4 = layoutInflater.inflate(R.layout.awk, (ViewGroup) null, false);
        TextView textView3 = (TextView) inflate4.findViewById(R.id.cih);
        this.footerErrorView = textView3;
        textView3.setText(HardCodeUtil.qqStr(R.string.jzu));
        this.footerErrorView.setTextSize(16.0f);
        this.footerErrorView.setTextColor(getActivity().getResources().getColor(R.color.skin_gray3));
        this.footerErrorView.setVisibility(8);
        this.listView.addFooterView(inflate4);
        this.fragmentView = inflate;
        if (aq.a()) {
            inflate.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (ignoreDestroyEngine()) {
            return;
        }
        IFaceDecoder iFaceDecoder = this.faceDecoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        ReportController.o(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", getSearchModule(), 0, String.valueOf(this.searchTimes), "", this.keyword, "");
        if (this.isEngineInited) {
            this.isEngineInited = false;
            b bVar = this.searchEngine;
            if (bVar != null) {
                bVar.cancel();
                this.searchEngine.destroy();
            }
        }
    }

    @Override // on2.d
    public void onFinish(List<M> list, int i3) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onFinish with status: ");
            sb5.append(i3);
            sb5.append(", resultList.size: ");
            sb5.append(list != null ? list.size() : 0);
            QLog.d(TAG, 2, sb5.toString());
        }
        VADHelper.e("voice_search_als_cost");
        VADHelper.e("voice_search_all_cost");
        onFinishProcess(list, i3);
        removeAllMessage();
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessage(4);
    }

    protected void onFinishProcess(List<M> list, int i3) {
        this.mResultList = list;
    }

    protected void onSearchFinished() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSearchTimeout(List<M> list) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSearchTimeout");
        }
        if (this.adapter.getCount() <= 0) {
            hideLoading();
            showNoResultLayout(true);
        }
    }

    protected void onSearchUpdate(List<M> list) {
        hideLoading();
        this.adapter.g(list);
        this.footerLoadingView.setVisibility(0);
    }

    public void onTimeout(String str) {
        this.handler.sendEmptyMessage(3);
    }

    @Override // on2.d
    public void onUpdate(List<M> list) {
        onUpdate(list, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        final boolean z16;
        super.onViewCreated(view, bundle);
        this.faceDecoder = ((IQQAvatarService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface) getQBaseActivity().getAppRuntime());
        mn2.a newAdapter = newAdapter();
        this.adapter = newAdapter;
        this.listView.setAdapter((ListAdapter) newAdapter);
        hideLoading();
        if (super.getQBaseActivity() instanceof BaseSearchActivity) {
            z16 = ((BaseSearchActivity) super.getQBaseActivity()).f282792k0;
        } else {
            z16 = false;
        }
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.search.base.fragment.BaseSearchFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (!BaseSearchFragment.this.isEngineInited) {
                    BaseSearchFragment.this.searchEngine.init();
                    BaseSearchFragment.this.isEngineInited = true;
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.base.fragment.BaseSearchFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BaseSearchFragment.this.isDetached()) {
                            return;
                        }
                        BaseSearchFragment.this.hideLoading();
                        if (TextUtils.isEmpty(BaseSearchFragment.this.keyword)) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (!z16) {
                                BaseSearchFragment.this.headerLayout.setVisibility(8);
                                return;
                            }
                        }
                        BaseSearchFragment baseSearchFragment = BaseSearchFragment.this;
                        baseSearchFragment.startSearch(baseSearchFragment.keyword);
                    }
                });
            }
        }, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeAllMessage() {
        this.handler.removeMessages(4);
        this.handler.removeMessages(1);
        this.handler.removeMessages(5);
    }

    public void setActivityContentView(View view) {
        this.activityContentView = view;
    }

    protected void setDaTongInfo() {
        int count;
        if (this.listView != null) {
            mn2.a aVar = this.adapter;
            if (aVar == null) {
                count = 0;
            } else {
                count = aVar.getCount();
            }
            ai.f(this.listView, String.valueOf(count), getDisplayType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoading() {
        mn2.a aVar = this.adapter;
        if (aVar == null || aVar.getCount() == 0) {
            this.centerLoadingLayout.setVisibility(0);
            this.headerLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showNoMoreResult(boolean z16) {
        int i3;
        TextView textView = this.noMoreResultView;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showNoResultLayout(boolean z16) {
        if (z16) {
            this.noResultLayout.setVisibility(0);
            ((TextView) this.noResultLayout.findViewById(R.id.f166413fa1)).setText(this.keyword);
            this.centerLoadingLayout.setVisibility(8);
            this.headerLayout.setVisibility(8);
            showNoMoreResult(false);
            return;
        }
        this.noResultLayout.setVisibility(8);
    }

    public void startSearch(String str, byte[] bArr) {
        startSearch(str, bArr, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSearchFinished(List<M> list) {
        hideLoading();
        this.adapter.g(list);
        onSearchFinished();
        this.footerLoadingView.setVisibility(8);
        if (this.adapter.getCount() <= 0) {
            showNoResultLayout(isNoResult());
        } else {
            showNoMoreResult(true);
        }
        setDaTongInfo();
        VADHelper.d(getQBaseActivity());
    }

    @Override // on2.d
    public void onUpdate(List<M> list, boolean z16) {
        List<M> list2;
        if (z16 && (list2 = this.mResultList) != null) {
            list2.addAll(list);
        } else {
            this.mResultList = list;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastUpdateTime >= 300) {
            this.handler.removeMessages(1);
            this.handler.sendEmptyMessage(1);
        } else {
            this.handler.removeMessages(1);
            this.handler.sendEmptyMessageDelayed(1, 300 - (currentTimeMillis - this.lastUpdateTime));
        }
    }

    public void startSearch(String str) {
        VADHelper.f("voice_search_als_cost");
        startSearch(str, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startSearch(String str, int i3) {
        startSearch(str, null, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean startSearch(String str, byte[] bArr, int i3) {
        return startSearch(new pn2.a(str, bArr), i3);
    }

    public boolean startSearch(pn2.a aVar, int i3) {
        String str = aVar.f426495a;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startSearch, key: " + af.a(str, 2) + getClass() + " searchEngineOp:" + i3);
        }
        QBaseActivity qBaseActivity = super.getQBaseActivity();
        boolean z16 = qBaseActivity instanceof BaseSearchActivity;
        boolean z17 = z16 ? ((BaseSearchActivity) qBaseActivity).f282792k0 : false;
        showNoMoreResult(false);
        if (TextUtils.isEmpty(str) && !z17 && this.adapter != null) {
            this.footerLoadingView.setVisibility(8);
            this.centerLoadingLayout.setVisibility(8);
            this.footerLoadingJuhuaView.setVisibility(8);
            this.footerErrorView.setVisibility(8);
            showNoMoreResult(false);
            showNoResultLayout(false);
            this.headerLayout.setVisibility(8);
            this.searchEngine.cancel();
            removeAllMessage();
            mn2.a aVar2 = this.adapter;
            if (aVar2 != null) {
                this.mResultList = null;
                aVar2.g(null);
            }
            this.keyword = str;
            return false;
        }
        this.keyword = str;
        if (this.listView == null) {
            return false;
        }
        if (i3 == 1) {
            this.searchEngine.cancel();
        } else if (i3 == 2) {
            this.searchEngine.pause();
        }
        removeAllMessage();
        if (!isHideLoading()) {
            showLoading();
        }
        this.footerLoadingView.setVisibility(8);
        if (this.isEngineInited) {
            this.searchTimes++;
            Bundle otherSearchRequestExtraInfo = getOtherSearchRequestExtraInfo();
            String str2 = z16 ? ((BaseSearchActivity) qBaseActivity).f282790i0 : null;
            if (str2 != null) {
                Bundle bundle = new Bundle();
                bundle.putString("search_restrict_mem", str2);
                BaseSearchActivity baseSearchActivity = (BaseSearchActivity) qBaseActivity;
                bundle.putString("search_restrict_uin", baseSearchActivity.f282791j0);
                bundle.putBoolean("search_restrict_empty", z17);
                bundle.putInt("search_restrict_uintype", baseSearchActivity.f282793l0);
                Bundle bundle2 = aVar.f426496b;
                if (bundle2 == null) {
                    aVar.f426496b = bundle;
                } else {
                    bundle2.putAll(bundle);
                }
            }
            if (otherSearchRequestExtraInfo != null) {
                Bundle bundle3 = aVar.f426496b;
                if (bundle3 == null) {
                    aVar.f426496b = otherSearchRequestExtraInfo;
                } else {
                    bundle3.putAll(otherSearchRequestExtraInfo);
                }
            }
            if (System.currentTimeMillis() - this.lastReqTime < 100) {
                pn2.a aVar3 = this.waitSendReq;
                if (aVar3 == null) {
                    this.waitSendReq = aVar;
                    this.handler.sendEmptyMessageDelayed(5, 100L);
                    QLog.d(TAG, 1, "sendEmptyMessageDelayed keyword:", aVar.f426495a, " cookie:", aVar.f426497c, " extra:", aVar.f426496b);
                } else {
                    QLog.d(TAG, 1, "ignored keyword:", aVar3.f426495a);
                    this.waitSendReq = aVar;
                }
                return false;
            }
            pn2.a aVar4 = this.waitSendReq;
            if (aVar4 != null) {
                QLog.d(TAG, 1, "ignored keyword:", aVar4.f426495a);
            }
            this.waitSendReq = null;
            this.lastReqTime = System.currentTimeMillis();
            this.searchEngine.c(aVar, this);
            ao.c("startLocalSearch", -1);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "searchAsync keyword:", aVar.f426495a, " cookie:", aVar.f426497c, " extra:", aVar.f426496b);
            }
        }
        return true;
    }

    public void onFinish(List<M> list, int i3, boolean z16) {
        List<M> list2;
        VADHelper.e("voice_search_als_cost");
        VADHelper.e("voice_search_all_cost");
        if (!z16 && (list2 = this.mResultList) != null) {
            list2.addAll(list);
        } else {
            this.mResultList = list;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[6];
            objArr[0] = "onFinish with status:";
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = " isFirstPage:";
            objArr[3] = Boolean.valueOf(z16);
            objArr[4] = " totalSize:";
            List<M> list3 = this.mResultList;
            objArr[5] = Integer.valueOf(list3 != null ? list3.size() : 0);
            QLog.d(TAG, 2, objArr);
        }
        removeAllMessage();
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessage(4);
    }

    @Override // on2.d
    public void onFinish(List<M> list, pn2.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onFinish with respData:", bVar.toString());
        }
        if (bVar.a(this.keyword)) {
            onFinish(list, bVar.f426500c);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onFinish not match keyword1:", bVar.f426498a, " keyword2:", this.keyword);
        }
    }
}
