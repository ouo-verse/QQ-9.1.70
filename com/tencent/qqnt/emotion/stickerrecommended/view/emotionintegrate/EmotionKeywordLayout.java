package com.tencent.qqnt.emotion.stickerrecommended.view.emotionintegrate;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.aio.utils.b;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.IRecommendEmotionService;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.StickerRecKeywordFrom;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.e;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.h;
import com.tencent.qqnt.emotion.stickerrecommended.f;
import com.tencent.qqnt.emotion.stickerrecommended.g;
import com.tencent.qqnt.emotion.stickerrecommended.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public class EmotionKeywordLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    WeakReference<a> f356655d;

    /* renamed from: e, reason: collision with root package name */
    ViewGroup f356656e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f356657f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f356658h;

    public EmotionKeywordLayout(Context context, a aVar, ViewGroup viewGroup) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, aVar, viewGroup);
            return;
        }
        this.f356657f = false;
        this.f356658h = false;
        this.f356655d = new WeakReference<>(aVar);
        this.f356656e = viewGroup;
    }

    void a(g gVar, StickerRecKeywordFrom stickerRecKeywordFrom) {
        if (gVar.b() != 0) {
            return;
        }
        int i3 = 1;
        gVar.e(1);
        HashMap hashMap = new HashMap();
        hashMap.put(EmotionReportDtImpl.PARAM_EXPRESSION_PACK_ID, gVar.g());
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, gVar.a());
        hashMap.put("associative_text", gVar.c());
        if (stickerRecKeywordFrom != StickerRecKeywordFrom.LITE_ACTION) {
            i3 = 2;
        }
        hashMap.put("come_from", Integer.valueOf(i3));
        b.r("em_bas_slot_memes_recommended", hashMap, gVar.getImgMd5());
    }

    void b(g gVar, StickerRecKeywordFrom stickerRecKeywordFrom) {
        int i3 = 1;
        if (gVar.b() != 1) {
            return;
        }
        gVar.e(2);
        HashMap hashMap = new HashMap();
        hashMap.put(EmotionReportDtImpl.PARAM_EXPRESSION_PACK_ID, gVar.g());
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, gVar.a());
        hashMap.put("associative_text", gVar.c());
        if (stickerRecKeywordFrom != StickerRecKeywordFrom.LITE_ACTION) {
            i3 = 2;
        }
        hashMap.put("come_from", Integer.valueOf(i3));
        b.u("em_bas_slot_memes_recommended", hashMap, gVar.getImgMd5());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        Object tag = getTag();
        if (tag instanceof e) {
            e eVar = (e) tag;
            g gVar = (g) eVar.getPresenter().getModel();
            if (gVar != null && gVar.isExposed()) {
                gVar.startExposed(System.currentTimeMillis());
            }
            if ((eVar instanceof h) && p.a(gVar)) {
                ((h) eVar).d();
            }
            a(gVar, eVar.getFrom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        Object tag = getTag();
        if (tag instanceof e) {
            e eVar = (e) tag;
            g gVar = (g) eVar.getPresenter().getModel();
            if (gVar != null && gVar.isExposed()) {
                gVar.endExposed(System.currentTimeMillis());
            }
            if ((eVar instanceof h) && p.a(gVar)) {
                ((h) eVar).e();
            }
            b(gVar, eVar.getFrom());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (QLog.isColorLevel()) {
                        QLog.i("EmotionKeywordLayoutIntegrate", 2, "EmotionKeywordLayout.onTouchEvent ACTION_MOVE");
                    }
                    if (this.f356657f && (viewGroup = this.f356656e) != null) {
                        if (!this.f356658h && (viewGroup instanceof TopGestureLayout)) {
                            Object gestureDetector = ((TopGestureLayout) viewGroup).getGestureDetector();
                            if (gestureDetector instanceof f) {
                                f fVar = (f) gestureDetector;
                                fVar.setLastX(motionEvent.getRawX());
                                fVar.setLastY(motionEvent.getRawY());
                                this.f356658h = true;
                            }
                        }
                        this.f356656e.onTouchEvent(motionEvent);
                        return true;
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("EmotionKeywordLayoutIntegrate", 2, "EmotionKeywordLayout.onTouchEvent ACTION_UP");
                }
                if (this.f356657f && this.f356656e != null) {
                    WeakReference<a> weakReference = this.f356655d;
                    if (weakReference != null) {
                        aVar = weakReference.get();
                    } else {
                        aVar = null;
                    }
                    ((IRecommendEmotionService) QRoute.api(IRecommendEmotionService.class)).onEmotionKeywordDimiss(aVar);
                    this.f356657f = false;
                    this.f356658h = false;
                    this.f356656e.onTouchEvent(motionEvent);
                    return true;
                }
                this.f356657f = false;
                this.f356658h = false;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("EmotionKeywordLayoutIntegrate", 2, "EmotionKeywordLayout.onTouchEvent ACTION_DOWN");
            }
            this.f356658h = false;
            this.f356657f = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, i3);
            return;
        }
        super.onVisibilityChanged(view, i3);
        if (i3 != 0) {
            Object tag = getTag();
            if (tag instanceof e) {
                e eVar = (e) tag;
                b((g) eVar.getPresenter().getModel(), eVar.getFrom());
            }
        }
    }
}
