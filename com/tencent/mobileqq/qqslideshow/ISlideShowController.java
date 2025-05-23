package com.tencent.mobileqq.qqslideshow;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.e;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@QRouteFactory
@QAPI(process = {"peak"})
/* loaded from: classes17.dex */
public interface ISlideShowController extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;
    public static final int CODE_FROM_SLIDE_SHOW_CLIP = 24747;
    public static final String KEY_REPORT_FIRST_EXPOSURE = "report_first_exposure";
    public static final int RECYCLERVIEW_HEIGHT;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(33545), (Class<?>) ISlideShowController.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            RECYCLERVIEW_HEIGHT = x.c(BaseApplication.getContext(), 62.0f);
        }
    }

    List<SlideItemInfo> getPhotoList();

    List<SlideItemInfo> getTemp();

    void initPhotoListController(Activity activity, View view, e eVar, boolean z16);

    void initPhotoPreviewController(Activity activity, View view, e eVar);

    void onClipFinish(Intent intent, Map<String, LocalMediaInfo> map);

    void onItemsSelectChanged(List<String> list, HashMap<String, LocalMediaInfo> hashMap);

    void onItemsSelectChanged(List<String> list, HashMap<String, LocalMediaInfo> hashMap, boolean z16);

    void onPhotoListDestroy();

    void onPhotoPreviewDestroy();

    void onResume();

    void setData(List<SlideItemInfo> list);

    void setPhotoListController();

    void setPhotoPreviewController();

    void setTemp(List<SlideItemInfo> list);

    void updatePhotoPreviewSelectUI(int i3);
}
