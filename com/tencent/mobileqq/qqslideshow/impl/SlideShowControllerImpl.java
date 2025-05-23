package com.tencent.mobileqq.qqslideshow.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler;
import com.tencent.biz.qqstory.takevideo.slideshow.e;
import com.tencent.biz.qqstory.takevideo.slideshow.i;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqslideshow.ISlideShowController;
import com.tencent.sveffects.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class SlideShowControllerImpl implements ISlideShowController {
    static IPatchRedirector $redirector_;
    public i photoListController;
    public i photoPreviewController;

    public SlideShowControllerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public List<SlideItemInfo> getPhotoList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return SlideShowPhotoListManager.n().o();
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public List<SlideItemInfo> getTemp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return SlideShowPhotoListManager.n().p();
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void initPhotoListController(Activity activity, View view, e eVar, boolean z16) {
        TransitionHandler transitionHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, view, eVar, Boolean.valueOf(z16));
            return;
        }
        a.b();
        this.photoListController = new i(activity, view, eVar);
        SlideShowPhotoListManager.n().F(this.photoListController);
        SlideShowPhotoListManager.n().e(activity);
        if (z16 && (transitionHandler = (TransitionHandler) QQStoryContext.a().getBusinessHandler(PeakAppInterface.H)) != null) {
            transitionHandler.clear();
        }
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void initPhotoPreviewController(Activity activity, View view, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, view, eVar);
            return;
        }
        a.b();
        this.photoPreviewController = new i(activity, view, eVar);
        SlideShowPhotoListManager.n().F(this.photoPreviewController);
        SlideShowPhotoListManager.n().e(activity);
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void onClipFinish(Intent intent, Map<String, LocalMediaInfo> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent, (Object) map);
        } else {
            SlideShowPhotoListManager.n().t(intent, map);
        }
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void onItemsSelectChanged(List<String> list, HashMap<String, LocalMediaInfo> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            SlideShowPhotoListManager.n().u(list, hashMap);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) list, (Object) hashMap);
        }
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void onPhotoListDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            SlideShowPhotoListManager.n().G();
            this.photoListController = null;
        }
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void onPhotoPreviewDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            SlideShowPhotoListManager.n().G();
            this.photoPreviewController = null;
        }
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            SlideShowPhotoListManager.n().w();
        }
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void setData(List<SlideItemInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) list);
        } else {
            SlideShowPhotoListManager.n().C(list);
        }
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void setPhotoListController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            SlideShowPhotoListManager.n().F(this.photoListController);
        }
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void setPhotoPreviewController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            SlideShowPhotoListManager.n().F(this.photoPreviewController);
        }
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void setTemp(List<SlideItemInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) list);
        } else {
            SlideShowPhotoListManager.n().D(list);
        }
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void updatePhotoPreviewSelectUI(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        i iVar = this.photoPreviewController;
        if (iVar != null) {
            iVar.k(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqslideshow.ISlideShowController
    public void onItemsSelectChanged(List<String> list, HashMap<String, LocalMediaInfo> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            SlideShowPhotoListManager.n().v(list, hashMap, z16);
        } else {
            iPatchRedirector.redirect((short) 11, this, list, hashMap, Boolean.valueOf(z16));
        }
    }
}
