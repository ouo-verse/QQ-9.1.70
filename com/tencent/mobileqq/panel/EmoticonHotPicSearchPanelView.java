package com.tencent.mobileqq.panel;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.api.INTPanelInteractionListener;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.emosearch.api.IRichTextPanelSearchHelperApi;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonPanelOnScrollListener;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPool;
import com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class EmoticonHotPicSearchPanelView extends RichTextPanelView {
    static IPatchRedirector $redirector_;
    private IEmotionHotPicSearchAdapter C;
    private com.tencent.mobileqq.emosm.emosearch.c D;

    /* renamed from: f, reason: collision with root package name */
    private f f257106f;

    /* renamed from: h, reason: collision with root package name */
    private EmotionPanelListView f257107h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f257108i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.qqnt.aio.api.e f257109m;

    public EmoticonHotPicSearchPanelView(Context context, com.tencent.aio.api.runtime.a aVar, AppRuntime appRuntime, EditText editText, com.tencent.qqnt.aio.api.e eVar, f fVar) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, aVar, appRuntime, editText, eVar, fVar);
            return;
        }
        setAppRuntime(appRuntime);
        setEditText(editText);
        this.f257109m = eVar;
        this.f257108i = aVar;
        this.f257106f = fVar;
        this.D = ((IRichTextPanelSearchHelperApi) QRoute.api(IRichTextPanelSearchHelperApi.class)).createSearchHelper(((INTPanelInteractionListener) QRoute.api(INTPanelInteractionListener.class)).getNTPanelInteractionListener(context, editText, aVar, (IAIOEmoticonUIHelper) eVar, null), context, fVar);
        d();
    }

    private void d() {
        EmotionPanelListView emotionPanelListView = new EmotionPanelListView(getContext());
        this.f257107h = emotionPanelListView;
        emotionPanelListView.setVerticalScrollBarEnabled(false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        relativeLayout.addView(this.f257107h, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        View inflate = View.inflate(getContext(), R.layout.duv, null);
        relativeLayout.addView(inflate, layoutParams);
        this.C = ((IRichTextPanelSearchHelperApi) QRoute.api(IRichTextPanelSearchHelperApi.class)).createSearchAdapter(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(this.f257150d), ((INTPanelInteractionListener) QRoute.api(INTPanelInteractionListener.class)).getNTPanelInteractionListener(getContext(), this.f257151e, this.f257108i, (IAIOEmoticonUIHelper) this.f257109m, null), getContext(), 4, 14, 12, (EmoticonCallback) this.f257109m);
        this.f257107h.setDivider(null);
        this.f257107h.setSelector(R.drawable.f162601b70);
        this.C.setWidthPixels(ViewUtils.getScreenWidth());
        this.C.setCurrentListView(this.f257107h);
        ((com.tencent.mobileqq.emosm.emosearch.d) this.D).a(this.f257107h, this.C);
        this.D.setEmptyView(inflate);
        this.f257107h.setAdapter((ListAdapter) this.C);
        this.f257107h.setEnableExtendPanle(true);
        this.f257107h.setPullAndFastScrollListener(this.f257106f);
        EmotionPanelListView emotionPanelListView2 = this.f257107h;
        emotionPanelListView2.setOnScrollListener(new EmoticonPanelOnScrollListener(emotionPanelListView2, this.f257106f, null));
        this.f257107h.addOnScrollListener((AbsListView.OnScrollListener) this.D);
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        EditText editText = this.f257151e;
        if (editText != null && editText.getText() != null) {
            this.D.startSearch(this.f257151e.getText().toString());
        }
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return getContext().getString(R.string.yqb);
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (((IEmotionSearchManagerService) this.f257150d.getRuntimeService(IEmotionSearchManagerService.class, "")).getSearchCallBack() instanceof com.tencent.mobileqq.emosm.emosearch.d) {
            this.D.resetEmoticonSearch();
        }
        super.b();
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else if (z16) {
            f();
        } else {
            e(true);
        }
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.D.onHide(z16);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        EditText editText = this.f257151e;
        if (editText != null && editText.getText() != null) {
            String searchWord = this.D.getSearchWord();
            String obj = this.f257151e.getText().toString();
            if (!StringUtil.isEmpty(searchWord) && searchWord.equals(obj)) {
                this.D.setLoadingStatus(3);
                return;
            }
            this.C.setData(new ArrayList());
            this.D.setSearchWords(obj);
            this.D.onShow();
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonHotPicSearchPanelView", 4, " reportDefaultExposedEvent ");
        }
        this.D.reportItemExposed();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDetachedFromWindow();
            EmotionPanelViewPool.getInstance().destory();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int measuredWidth = getMeasuredWidth();
        if (com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT && (measuredWidth == ViewUtils.getScreenWidth() || measuredWidth == ViewUtils.getScreenHeight())) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonHotPicSearchPanelView", 2, "measuredWidth not correct, width:" + measuredWidth);
                return;
            }
            return;
        }
        IEmotionHotPicSearchAdapter iEmotionHotPicSearchAdapter = this.C;
        if (iEmotionHotPicSearchAdapter != null && iEmotionHotPicSearchAdapter.getWidthPixels() != measuredWidth) {
            this.C.setWidthPixels(measuredWidth);
            this.f257107h.setAdapter((ListAdapter) this.C);
        }
    }
}
