package com.tencent.comic.hippy;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.richframework.compat.f;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.comic.data.a;
import com.tencent.comic.data.b;
import com.tencent.comic.data.e;
import com.tencent.comic.data.g;
import com.tencent.comic.hippy.api.ComicHippyBackEventInterceptorProxy;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class VipComicHippyFragment extends CommonHippyFragment {
    private static final String TAG = "VipComicHippyFragment";
    private boolean reportedBounceRate = false;
    private boolean backEventIntercepted = false;
    private boolean backEventInterceptChecked = false;
    private boolean hasRedDot = false;
    private Context mDialogContext = null;
    private long mLastTouchUpTime = 0;

    private boolean checkHasRedDot() {
        try {
            return TextUtils.equals("1", ((SerializableMap) getParameters().getSerializable(OpenHippyInfo.EXTRA_KEY_JS_PARAM_MAP)).getMap().get("hasRedDot"));
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean interceptedBackEvent() {
        HippyEngine hippyEngine;
        if (!isComicMainPage() || this.backEventInterceptChecked) {
            return false;
        }
        this.backEventInterceptChecked = true;
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine == null || (hippyEngine = hippyQQPreloadEngine.getHippyEngine()) == null) {
            return false;
        }
        a aVar = new a();
        aVar.f99287a = this.hasRedDot;
        aVar.f99288b = g.c(hippyEngine.hashCode(), 12);
        aVar.f99289c = g.c(hippyEngine.hashCode(), 13);
        aVar.f99290d = this.mLastTouchUpTime;
        if (!ComicHippyBackEventInterceptorProxy.INSTANCE.canShowCancelRedPoinDialog(aVar)) {
            return false;
        }
        showBackPopDialog();
        return true;
    }

    private boolean isComicMainPage() {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        return hippyQQPreloadEngine != null && TextUtils.isEmpty(hippyQQPreloadEngine.getPageUrl());
    }

    private void reportBounceRate() {
        HippyEngine hippyEngine;
        long j3;
        if (isComicMainPage() && !this.reportedBounceRate) {
            int i3 = 1;
            this.reportedBounceRate = true;
            HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
            if (hippyQQPreloadEngine == null || (hippyEngine = hippyQQPreloadEngine.getHippyEngine()) == null) {
                return;
            }
            HashMap<String, Long> performanceData = getPerformanceData();
            if (performanceData.containsKey(HippyQQConstants.STEP_NAME_OPEN_PAGE_START)) {
                g.d(hippyEngine.hashCode(), 1, performanceData.get(HippyQQConstants.STEP_NAME_OPEN_PAGE_START).longValue());
            }
            if (performanceData.containsKey(HippyQQConstants.STEP_NAME_LOAD_MODULE_START)) {
                g.d(hippyEngine.hashCode(), 2, performanceData.get(HippyQQConstants.STEP_NAME_LOAD_MODULE_START).longValue());
            }
            long c16 = g.c(hippyEngine.hashCode(), 1);
            int i16 = 0;
            while (true) {
                ArrayList<Integer> arrayList = g.f99363a;
                if (i16 >= arrayList.size()) {
                    j3 = c16;
                    break;
                }
                int intValue = arrayList.get(i16).intValue();
                if (g.b(hippyEngine.hashCode(), intValue)) {
                    j3 = g.c(hippyEngine.hashCode(), intValue);
                    i3 = intValue;
                    break;
                }
                i16++;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "reportHippyBounceRate:\nclickTime:" + c16 + "\nfinalStatus:" + i3 + "\nfinalStatusTime:" + j3 + "\nhasRedDot:" + this.hasRedDot + "\nmoduleVersion:" + hippyQQPreloadEngine.getModuleVersion() + "\nmoduleName:" + hippyQQPreloadEngine.getModuleName() + "\n");
            }
            b bVar = new b();
            bVar.f99291a = "qqcomic_web";
            bVar.f99292b = "page_break";
            bVar.f99293c = hippyQQPreloadEngine.getModuleName() + "_" + hippyQQPreloadEngine.getModuleVersion();
            bVar.f99301k = 2L;
            bVar.f99302l = this.hasRedDot ? 1L : 0L;
            bVar.f99303m = i3;
            bVar.f99304n = j3 - c16;
            bVar.f99305o = System.currentTimeMillis() - c16;
            bVar.f99310t = HttpUtil.getNetWorkTypeContain5G();
            ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportTechReport2021(bVar.toString());
        }
    }

    private void showBackPopDialog() {
        ComicHippyBackEventInterceptorProxy comicHippyBackEventInterceptorProxy = ComicHippyBackEventInterceptorProxy.INSTANCE;
        List<ComicCancelRedPointPopItemData> validCancelRedPointDialogData = comicHippyBackEventInterceptorProxy.getValidCancelRedPointDialogData();
        if (validCancelRedPointDialogData == null || validCancelRedPointDialogData.size() <= 0) {
            return;
        }
        this.backEventIntercepted = true;
        final com.tencent.comic.ui.a aVar = new com.tencent.comic.ui.a(this.mDialogContext, getActivity(), R.style.f243380n);
        aVar.g(validCancelRedPointDialogData);
        aVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.comic.hippy.VipComicHippyFragment.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!aVar.f99465d) {
                    VipComicHippyFragment.super.onBackEvent();
                } else {
                    VipComicHippyFragment.this.backEventIntercepted = false;
                }
                VipComicHippyFragment.this.reportDialogDismiss(aVar.f99465d);
            }
        });
        comicHippyBackEventInterceptorProxy.recordDialogShowTime();
        aVar.show();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.mLastTouchUpTime = System.currentTimeMillis();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean needDispatchTouchEvent() {
        return true;
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        reportBounceRate();
        if (this.backEventIntercepted) {
            return false;
        }
        if (interceptedBackEvent()) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.reportedBounceRate = false;
        this.hasRedDot = checkHasRedDot();
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mDialogContext = viewGroup.getContext();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        HippyEngine hippyEngine;
        reportBounceRate();
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null && (hippyEngine = hippyQQPreloadEngine.getHippyEngine()) != null) {
            g.a(hippyEngine.hashCode());
        }
        super.onDestroy();
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDialogDismiss(boolean z16) {
        if (z16) {
            return;
        }
        ComicHippyBackEventInterceptorProxy.INSTANCE.reportData(new e().x(TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID).w("2").v("201124"));
    }
}
