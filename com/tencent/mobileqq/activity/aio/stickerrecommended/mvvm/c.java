package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonReportDtHelper;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends com.tencent.mobileqq.mvvm.b implements com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.a {
    Observer<y61.a> C = new a();
    Observer<String> D = new b();
    Observer<y61.b> E = new C7137c();

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f179950d;

    /* renamed from: e, reason: collision with root package name */
    public EmotionKeywordLayout f179951e;

    /* renamed from: f, reason: collision with root package name */
    private AppInterface f179952f;

    /* renamed from: h, reason: collision with root package name */
    private QBaseActivity f179953h;

    /* renamed from: i, reason: collision with root package name */
    private a61.b f179954i;

    /* renamed from: m, reason: collision with root package name */
    private d f179955m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Observer<y61.a> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(y61.a aVar) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecViewBinder", 2, "layoutStatus change:", Integer.valueOf(aVar.f449517a), " ,layout:", c.this.f179951e);
            }
            int i3 = aVar.f449517a;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            c cVar = c.this;
                            if (cVar.f179951e != null && cVar.f179950d != null) {
                                c.this.f179950d.removeView(c.this.f179951e);
                                c cVar2 = c.this;
                                cVar2.f179951e = null;
                                cVar2.getClass();
                                c.this.f179955m.M1(false);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    EmotionKeywordLayout emotionKeywordLayout = c.this.f179951e;
                    if (emotionKeywordLayout != null) {
                        emotionKeywordLayout.hide();
                        c.this.f179955m.M1(false);
                    }
                    ((IRecommendEmotionService) QRoute.api(IRecommendEmotionService.class)).clearSpecWordType(c.this.f179954i);
                    return;
                }
                EmotionKeywordLayout emotionKeywordLayout2 = c.this.f179951e;
                if (emotionKeywordLayout2 != null) {
                    emotionKeywordLayout2.hide();
                    c.this.f179955m.M1(false);
                    return;
                }
                return;
            }
            EmotionKeywordLayout emotionKeywordLayout3 = c.this.f179951e;
            if (emotionKeywordLayout3 != null) {
                emotionKeywordLayout3.show(aVar.f449518b);
                c.this.f179955m.M1(true);
                c.this.f179951e.bringToFront();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements Observer<String> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            EmotionKeywordLayout emotionKeywordLayout = c.this.f179951e;
            if (emotionKeywordLayout != null) {
                EmoticonReportDtHelper.bindStickersRecommendBar(emotionKeywordLayout, str);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.c$c, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C7137c implements Observer<y61.b> {
        C7137c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(y61.b bVar) {
            c.i(c.this);
        }
    }

    public c(AppInterface appInterface, QBaseActivity qBaseActivity, a61.b bVar, com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.b bVar2) {
        this.f179952f = appInterface;
        this.f179953h = qBaseActivity;
        this.f179954i = bVar;
        this.f179955m = (d) bVar2;
    }

    static /* bridge */ /* synthetic */ com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.a i(c cVar) {
        cVar.getClass();
        return null;
    }
}
