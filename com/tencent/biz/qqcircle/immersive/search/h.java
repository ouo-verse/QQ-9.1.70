package com.tencent.biz.qqcircle.immersive.search;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchPageCloseEvent;
import com.tencent.biz.qqcircle.utils.cf;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.view.AutoHintLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.QUISearchBarResource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, SimpleEventReceiver, AutoHintLayout.b {
    private AutoHintLayout C;
    private QFSSearchInfo D;
    private boolean E;
    private String F;

    /* renamed from: d, reason: collision with root package name */
    private EditText f89880d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f89881e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f89882f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f89883h;

    /* renamed from: i, reason: collision with root package name */
    private InputMethodManager f89884i;

    /* renamed from: m, reason: collision with root package name */
    private QUISearchBar f89885m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b extends QUISearchBarResource {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public Drawable getBackground(@NonNull QUISearchBar qUISearchBar) {
            return new ColorDrawable(0);
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public Drawable getInputBackground(@NonNull QUISearchBar qUISearchBar) {
            return super.getInputBackground(qUISearchBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements QUISearchBar.ActionCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onBack() {
            h hVar = h.this;
            hVar.la(hVar.f89883h);
            h.this.U9();
            return true;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            SimpleEventBus.getInstance().dispatchEvent(new QFSSearchPageCloseEvent());
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            h hVar = h.this;
            hVar.la(hVar.f89881e);
            h.this.f89880d.setText("");
            h.this.f89880d.setSelection(0);
            h hVar2 = h.this;
            hVar2.ja(hVar2.f89880d);
            return true;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            if (fb0.a.b("QFSSearchInputPart", 500L)) {
                return;
            }
            String obj = h.this.f89880d.getText().toString();
            String i3 = h.this.C.i();
            if (!TextUtils.isEmpty(obj)) {
                QFSSearchInfo qFSSearchInfo = new QFSSearchInfo();
                qFSSearchInfo.k(obj);
                qFSSearchInfo.j(0);
                h.this.Z9(qFSSearchInfo);
                h.this.ma(qFSSearchInfo);
                return;
            }
            if (TextUtils.isEmpty(i3)) {
                h.this.da();
                return;
            }
            QFSSearchInfo qFSSearchInfo2 = new QFSSearchInfo();
            qFSSearchInfo2.k(i3);
            qFSSearchInfo2.j(9);
            h.this.X9(qFSSearchInfo2);
            h.this.ma(qFSSearchInfo2);
        }
    }

    private void M9() {
        this.f89880d.setText("");
        this.f89880d.setSelection(0);
        N9(new u60.b(0));
    }

    private void N9(u60.b bVar) {
        broadcastMessage("changePageState", bVar);
        if (bVar != null) {
            this.F = bVar.a();
        }
    }

    private void O9() {
        da();
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.search.f
            @Override // java.lang.Runnable
            public final void run() {
                h.this.ia();
            }
        }, 100L);
    }

    private void P9() {
        HashMap hashMap = new HashMap();
        String S9 = S9();
        if (!TextUtils.isEmpty(S9)) {
            hashMap.put("dt_ref_pgid", S9);
        }
        hashMap.put("xsj_custom_pgid", this.F);
        hashMap.put("dt_pgstp", 1);
        hashMap.put("xsj_query_text", this.f89880d.getText().toString());
        hashMap.putAll(Q9());
        EditText editText = this.f89880d;
        ua0.i.k(editText, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_BOX, hashMap, editText.hashCode());
        TextView textView = this.f89882f;
        ua0.i.k(textView, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_CANCEL, hashMap, textView.hashCode());
        ImageView imageView = this.f89881e;
        ua0.i.k(imageView, "em_xsj_close_button", hashMap, imageView.hashCode());
        ImageView imageView2 = this.f89883h;
        ua0.i.k(imageView2, "em_xsj_back_button", hashMap, imageView2.hashCode());
        AutoHintLayout autoHintLayout = this.C;
        ua0.i.k(autoHintLayout, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_GREY_WORD, hashMap, autoHintLayout.hashCode());
        TextView textView2 = this.f89882f;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(textView2, clickPolicy);
        VideoReport.setElementClickPolicy(this.f89881e, clickPolicy);
        VideoReport.setElementClickPolicy(this.f89883h, clickPolicy);
        VideoReport.traverseExposure();
    }

    private Map<String, Object> Q9() {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        HashMap hashMap = new HashMap();
        if (!(qCircleInitBean instanceof QFSSearchBean)) {
            getActivity().finish();
            return hashMap;
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_USER_SOURCE, String.valueOf(((QFSSearchBean) qCircleInitBean).getUserSource()));
        return hashMap;
    }

    private int R9() {
        Object broadcastGetMessage = broadcastGetMessage("getPageState", null);
        if (broadcastGetMessage instanceof Integer) {
            return ((Integer) broadcastGetMessage).intValue();
        }
        if (QCircleHostConstants._AppSetting.isPublicVersion()) {
            return 0;
        }
        throw new IllegalStateException("unknown page state: " + broadcastGetMessage);
    }

    private String S9() {
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo == null) {
            return "";
        }
        return pageInfo.pageId;
    }

    private TextWatcher T9() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9() {
        QFSSearchInfo qFSSearchInfo;
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (!(qCircleInitBean instanceof QFSSearchBean)) {
            O9();
            return;
        }
        QFSSearchBean qFSSearchBean = (QFSSearchBean) qCircleInitBean;
        if (ga()) {
            broadcastMessage("comment_panel_dismiss", null);
            return;
        }
        if (!qFSSearchBean.directlyCloseSearchPage() && R9() != 0) {
            if (R9() == 1 && (qFSSearchInfo = this.D) != null) {
                X9(qFSSearchInfo);
                return;
            } else {
                M9();
                return;
            }
        }
        O9();
    }

    private void V9() {
        u60.b bVar;
        EditText editText = this.f89880d;
        if (editText == null) {
            return;
        }
        String obj = editText.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            bVar = new u60.b(0);
        } else {
            bVar = new u60.b(1, obj);
        }
        N9(bVar);
        ja(this.f89880d);
    }

    private boolean W9() {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (!(qCircleInitBean instanceof QFSSearchBean)) {
            return false;
        }
        QFSSearchBean qFSSearchBean = (QFSSearchBean) qCircleInitBean;
        String searchKeyword = qFSSearchBean.getSearchKeyword();
        if (TextUtils.isEmpty(searchKeyword)) {
            return false;
        }
        QFSSearchInfo qFSSearchInfo = new QFSSearchInfo();
        qFSSearchInfo.k(searchKeyword);
        qFSSearchInfo.j(qFSSearchBean.getQuerySource());
        X9(qFSSearchInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X9(Object obj) {
        if (!(obj instanceof QFSSearchInfo)) {
            return;
        }
        QFSSearchInfo qFSSearchInfo = (QFSSearchInfo) obj;
        String f16 = qFSSearchInfo.f();
        QLog.d("QFSSearchInputPart", 1, "[handleSearchAutoComplete] keyword = " + f16);
        if (this.f89880d != null && !TextUtils.isEmpty(f16)) {
            this.E = true;
            this.f89880d.setText(f16);
            this.E = false;
            EditText editText = this.f89880d;
            editText.setSelection(editText.getText().length());
            Z9(qFSSearchInfo);
        }
    }

    private void Y9(Object obj) {
        AutoHintLayout autoHintLayout;
        if (this.f89880d != null && (autoHintLayout = this.C) != null && (obj instanceof u60.a)) {
            u60.a aVar = (u60.a) obj;
            autoHintLayout.m(this);
            this.C.setInterval(aVar.b());
            this.C.setReportDataList(aVar.c());
            this.C.setHintList(aVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z9(QFSSearchInfo qFSSearchInfo) {
        if (this.f89884i != null && this.f89880d != null) {
            QLog.d("QFSSearchInputPart", 1, "[handleSearchKeyword] keyword: " + qFSSearchInfo.f() + " querySource: " + qFSSearchInfo.e());
            da();
            this.D = qFSSearchInfo;
            this.f89880d.setSelection(0);
            N9(new u60.b(2, qFSSearchInfo));
        }
    }

    private void aa() {
        if (ha()) {
            oa();
        }
    }

    private void ba(final View view) {
        if (view == null) {
            return;
        }
        view.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.search.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.ja(view);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(Editable editable) {
        if (editable == null || this.f89881e == null) {
            return;
        }
        if (TextUtils.isEmpty(editable.toString())) {
            this.f89881e.setVisibility(8);
            N9(new u60.b(0));
            this.D = null;
        } else {
            this.f89881e.setVisibility(0);
            if (!this.E) {
                N9(new u60.b(1, editable.toString()));
            }
            oa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        if (this.f89884i != null && this.f89880d != null) {
            this.f89885m.setFocusable(true);
            this.f89885m.setFocusableInTouchMode(true);
            this.f89884i.hideSoftInputFromWindow(this.f89880d.getWindowToken(), 0);
            this.f89880d.setCursorVisible(false);
            this.f89880d.clearFocus();
        }
    }

    private void ea() {
        QuickPinyinEditText inputWidget = this.f89885m.getInputWidget();
        this.f89880d = inputWidget;
        inputWidget.setOnClickListener(this);
        this.f89884i = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.f89880d.addTextChangedListener(T9());
    }

    private boolean ga() {
        FrameLayout frameLayout;
        if (getPartRootView() == null || (frameLayout = (FrameLayout) getPartRootView().findViewById(R.id.u28)) == null || frameLayout.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private boolean ha() {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (!(qCircleInitBean instanceof QFSSearchBean)) {
            return false;
        }
        return ((QFSSearchBean) qCircleInitBean).isPageInteract();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ia() {
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(View view) {
        HashMap hashMap = new HashMap();
        String obj = this.f89880d.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            obj = this.C.i();
        }
        hashMap.put("xsj_custom_pgid", this.F);
        hashMap.put("xsj_query_text", obj);
        ua0.i.h(view, "ev_xsj_abnormal_clck", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma(QFSSearchInfo qFSSearchInfo) {
        if (qFSSearchInfo == null) {
            return;
        }
        cf.a(getContext(), QFS5507ReportHelper.ActionType.SEARCH_INPUT_ENTER, getReportBean(), getPageId(), qFSSearchInfo.f());
    }

    private void na() {
        Drawable textCursorDrawable;
        this.f89885m.setActionCallback(new c());
        if (Build.VERSION.SDK_INT >= 29 && (textCursorDrawable = this.f89885m.getInputWidget().getTextCursorDrawable()) != null) {
            textCursorDrawable.setTint(this.f89885m.getResources().getColor(R.color.cm8));
        }
        this.f89885m.setCustomResource(new b());
        this.f89885m.bindSearchChain(false);
    }

    private void oa() {
        this.f89885m.updateStyle(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pa, reason: merged with bridge method [inline-methods] */
    public void ja(View view) {
        if (view != null && this.f89884i != null) {
            this.f89885m.setFocusable(false);
            this.f89885m.setFocusableInTouchMode(false);
            view.requestFocus();
            this.f89884i.showSoftInput(view, 1);
            this.f89880d.setCursorVisible(true);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QFSSearchPageCloseEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchInputPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("qfs_search_words_auto_complete".equals(str)) {
            X9(obj);
        } else if ("qfs_search_hint_words_changed".equals(str)) {
            Y9(obj);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        U9();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f89880d) {
            V9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.search.view.AutoHintLayout.b
    public void onHintChange(int i3, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(i3));
        hashMap.put("xsj_query_text", str);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, str2);
        hashMap.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_GREY_WORD);
        hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_PAGE);
        ua0.i.h(this.C, "ev_xsj_abnormal_imp", hashMap);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        QUISearchBar qUISearchBar = (QUISearchBar) view.findViewById(R.id.f52502_z);
        this.f89885m = qUISearchBar;
        qUISearchBar.updateStyle(3);
        this.f89881e = this.f89885m.getClearView();
        this.f89882f = this.f89885m.getCancelView();
        this.f89883h = this.f89885m.getBackView();
        this.C = this.f89885m.getAutoHintLayout();
        aa();
        ea();
        if (!W9()) {
            N9(new u60.b(0));
            ba(this.f89880d);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        na();
        P9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        AutoHintLayout autoHintLayout = this.C;
        if (autoHintLayout != null) {
            autoHintLayout.u(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        AutoHintLayout autoHintLayout = this.C;
        if (autoHintLayout != null) {
            autoHintLayout.q();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        AutoHintLayout autoHintLayout = this.C;
        if (autoHintLayout != null) {
            autoHintLayout.s();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSearchPageCloseEvent) {
            O9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            h.this.ca(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
