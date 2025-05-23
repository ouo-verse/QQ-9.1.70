package com.tencent.mobileqq.vas.hippy.view;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.data.dt.a;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.custom.HippyCustomPropsController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@HippyController(name = HippyCustomPropsController.CLASS_NAME)
/* loaded from: classes20.dex */
public class HippyDTReportController extends HippyCustomPropsController {
    private static final String TAG = "HippyDTReportController";
    a.InterfaceC7479a mDtCustomPublicParams;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f309496d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f309497e;

        a(View view, String str) {
            this.f309496d = view;
            this.f309497e = str;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            VideoReport.setPageId(this.f309496d, this.f309497e);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (HippyDTReportController.this.mDtCustomPublicParams != null) {
                com.tencent.mobileqq.data.dt.a.e().f(HippyDTReportController.this.mDtCustomPublicParams);
                HippyDTReportController.this.mDtCustomPublicParams = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements a.InterfaceC7479a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f309505a;

        d(HashMap hashMap) {
            this.f309505a = hashMap;
        }

        @Override // com.tencent.mobileqq.data.dt.a.InterfaceC7479a
        public void a(@NotNull Map<String, Object> map) {
            map.putAll(this.f309505a);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "dt_interactReportPolicy")
    public void setClickPolicy(@NonNull View view, String str) {
        try {
            VideoReport.setElementClickPolicy(view, ClickPolicy.valueOf(str));
        } catch (Exception unused) {
            QLog.e(TAG, 1, "clickPolicy Invalid exception, view is" + view + " clickPolicy:" + str);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = HippyCustomPropsController.DT_EBLID)
    public void setElementBizLeafIdentifier(@NonNull View view, String str) {
        if (!TextUtils.isEmpty(str)) {
            VideoReport.setElementReuseIdentifier(view, str);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "dt_elementId")
    public void setElementId(@NonNull View view, String str) {
        if (ViewCompat.isAttachedToWindow(view)) {
            VideoReport.setElementId(view, str);
        } else {
            view.addOnAttachStateChangeListener(new b(view, str));
        }
    }

    @HippyControllerProps(defaultType = "map", name = "dt_elementParams")
    public void setElementParams(@NonNull View view, HippyMap hippyMap) {
        if (hippyMap == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : hippyMap.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        VideoReport.setElementParams(view, hashMap);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "dt_endExposureReportPolicy")
    public void setEndExposePolicy(@NonNull View view, String str) {
        try {
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.valueOf(str));
        } catch (Exception unused) {
            QLog.e(TAG, 1, "endExposePolicy Invalid exception, view is" + view + " endExposePolicy:" + str);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "dt_exposureReportPolicy")
    public void setExposePolicy(@NonNull View view, String str) {
        try {
            VideoReport.setElementExposePolicy(view, ExposurePolicy.valueOf(str));
        } catch (Exception unused) {
            QLog.e(TAG, 1, "exposePolicy Invalid exception, view is" + view + " exposePolicy:" + str);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "dt_ignorePageInOutEvent")
    public void setIgnorePageInOutEvent(@NonNull View view, boolean z16) {
        VideoReport.ignorePageInOutEvent(view, z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "dt_pageBodyView")
    public void setMarkAsPageBodyView(@NonNull View view, boolean z16) {
        if (z16) {
            VideoReport.markAsPageBodyView(view);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "dt_pageContentId")
    public void setPageContentId(@NonNull View view, String str) {
        VideoReport.setPageContentId(view, str);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "dt_pageId")
    public void setPageId(@NonNull View view, String str) {
        if (ViewCompat.isAttachedToWindow(view)) {
            VideoReport.setPageId(view, str);
        } else {
            view.addOnAttachStateChangeListener(new a(view, str));
        }
    }

    @HippyControllerProps(defaultType = "map", name = "dt_pageParams")
    public void setPageParams(@NonNull View view, HippyMap hippyMap) {
        if (hippyMap != null && hippyMap.size() > 0) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry : hippyMap.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            if (ViewCompat.isAttachedToWindow(view)) {
                VideoReport.setPageParams(view, new PageParams(hashMap));
            } else {
                view.addOnAttachStateChangeListener(new c(view, hashMap));
            }
        }
    }

    @HippyControllerProps(defaultType = "number", name = "dt_pageSearchMode")
    public void setPageSearchMode(@NonNull View view, int i3) {
        VideoReport.setPageSearchMode(view, i3);
    }

    @HippyControllerProps(defaultType = "map", name = "dt_publicParams")
    public void setPublicParams(@NonNull View view, HippyMap hippyMap) {
        if (hippyMap != null && hippyMap.size() > 0) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry : hippyMap.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            if (this.mDtCustomPublicParams == null) {
                this.mDtCustomPublicParams = new d(hashMap);
            }
            com.tencent.mobileqq.data.dt.a.e().b(this.mDtCustomPublicParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f309499d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f309500e;

        b(View view, String str) {
            this.f309499d = view;
            this.f309500e = str;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            VideoReport.setElementId(this.f309499d, this.f309500e);
            VideoReport.traversePage(this.f309499d);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f309502d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashMap f309503e;

        c(View view, HashMap hashMap) {
            this.f309502d = view;
            this.f309503e = hashMap;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            VideoReport.setPageParams(this.f309502d, new PageParams(this.f309503e));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(View view, String str, HippyArray hippyArray) {
    }
}
