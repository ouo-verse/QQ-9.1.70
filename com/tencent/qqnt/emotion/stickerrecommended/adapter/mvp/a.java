package com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.tencent.aio.data.AIOContact;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.temp.report.StatisticCollector;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mvi.base.route.k;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmosmService;
import com.tencent.qqnt.emotion.api.IEmoticonMarketFace;
import com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.qqnt.emotion.stickerrecommended.m;
import com.tencent.qqnt.emotion.stickerrecommended.o;
import com.tencent.qqnt.emotion.stickerrecommended.r;
import com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.IScenesRecommendManager;
import com.tencent.qqnt.emotion.stickerrecommended.t;
import cooperation.peak.PeakConstants;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import org.apache.http.Header;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private static List<StickerRecCacheEntity> f356468k;

    /* renamed from: l, reason: collision with root package name */
    private static HashSet<String> f356469l;

    /* renamed from: a, reason: collision with root package name */
    b f356470a;

    /* renamed from: b, reason: collision with root package name */
    com.tencent.qqnt.emotion.stickerrecommended.g f356471b;

    /* renamed from: c, reason: collision with root package name */
    public AppInterface f356472c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.aio.api.runtime.a f356473d;

    /* renamed from: e, reason: collision with root package name */
    EditText f356474e;

    /* renamed from: f, reason: collision with root package name */
    AIOContact f356475f;

    /* renamed from: g, reason: collision with root package name */
    String f356476g;

    /* renamed from: h, reason: collision with root package name */
    int f356477h;

    /* renamed from: i, reason: collision with root package name */
    private StickerRecKeywordFrom f356478i;

    /* renamed from: j, reason: collision with root package name */
    private URLDrawableDownListener f356479j;

    /* compiled from: P */
    /* renamed from: com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    class C9617a implements URLDrawableDownListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private long f356480d;

        C9617a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) uRLDrawable);
            } else if (QLog.isColorLevel()) {
                QLog.d("CommonStickerRec", 2, "drawableListener onLoadCancelled");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                a.this.t(uRLDrawable);
                if (QLog.isColorLevel() && System.currentTimeMillis() - this.f356480d > 1000) {
                    QLog.e("CommonStickerRec", 2, "drawableListener onLoadFialed:" + uRLDrawable.getURL(), th5);
                    this.f356480d = System.currentTimeMillis();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, th5);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, uRLDrawable, interruptedException);
            } else if (QLog.isColorLevel()) {
                QLog.d("CommonStickerRec", 2, "drawableListener onLoadInterrupted");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, view, uRLDrawable, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            String value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            long j3 = -1;
            try {
                Header header = uRLDrawable.getHeader("report_key_start_download");
                if (header != null && (value = header.getValue()) != null) {
                    j3 = System.currentTimeMillis() - Long.parseLong(value);
                }
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("CommonStickerRec", 2, "onLoadSuccessed:get start download time");
                }
            }
            a.this.u(uRLDrawable, j3);
            Object tag = view.getTag();
            if (StickerRecManagerImpl.isStickerRecFromRemote((com.tencent.qqnt.emotion.stickerrecommended.g) tag)) {
                o oVar = (o) tag;
                if (StickerRecManagerImpl.isStickerRecFromRemote(oVar) && !a.f356469l.contains(oVar.r())) {
                    a.f356469l.add(oVar.r());
                    a.f356468k.add(new StickerRecCacheEntity(oVar.j(), System.currentTimeMillis(), oVar.r()));
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45516);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f356468k = new ArrayList();
            f356469l = new HashSet<>();
        }
    }

    public a(AppInterface appInterface, com.tencent.aio.api.runtime.a aVar, EditText editText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appInterface, aVar, editText);
            return;
        }
        this.f356479j = new C9617a();
        this.f356472c = appInterface;
        this.f356473d = aVar;
        this.f356475f = aVar.g().r().c();
        this.f356474e = editText;
    }

    public static void j() {
        f356469l.clear();
        f356468k.clear();
    }

    public static List<StickerRecCacheEntity> k() {
        return new ArrayList(f356468k);
    }

    private String m() {
        k k3 = this.f356473d.e().k(new InputEvent.GetInputString());
        if (k3 instanceof d.C7264d) {
            return ((d.C7264d) k3).a().toString();
        }
        return "";
    }

    private CharSequence o() {
        if (this.f356478i == StickerRecKeywordFrom.LITE_ACTION) {
            return this.f356476g;
        }
        return this.f356474e.getEditableText();
    }

    @NotNull
    private URLDrawable.URLDrawableOptions p(com.tencent.qqnt.emotion.stickerrecommended.g gVar) {
        URLDrawable.URLDrawableOptions uRLDrawableOptions = gVar.getURLDrawableOptions();
        if (uRLDrawableOptions == null) {
            uRLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        }
        uRLDrawableOptions.mLoadingDrawable = this.f356470a.b();
        uRLDrawableOptions.mFailedDrawable = this.f356470a.b();
        uRLDrawableOptions.mPlayGifImage = true;
        return uRLDrawableOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(URLDrawable uRLDrawable) {
        if (uRLDrawable == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        URL url = uRLDrawable.getURL();
        if (url != null) {
            hashMap.put("sticker_url", url.toString());
        }
        StatisticCollector.d(BaseApplication.getContext()).c(null, "StickerRecImgLoad", false, 0L, 0L, hashMap, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(URLDrawable uRLDrawable, long j3) {
        if (uRLDrawable == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        URL url = uRLDrawable.getURL();
        if (url != null) {
            hashMap.put("sticker_url", url.toString());
        }
        StatisticCollector.d(BaseApplication.getContext()).c(null, "StickerRecImgLoad", true, j3, 0L, hashMap, "");
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.d
    public void a(StickerRecKeywordFrom stickerRecKeywordFrom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) stickerRecKeywordFrom);
        } else {
            this.f356478i = stickerRecKeywordFrom;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.d
    public void b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
        } else {
            this.f356476g = str;
            this.f356477h = i3;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.d
    public void c(e eVar, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar, (Object) cVar);
            return;
        }
        if (!i(eVar)) {
            QLog.e("CommonStickerRec", 1, "binding view error!");
            return;
        }
        if (!h(cVar)) {
            QLog.e("CommonStickerRec", 1, "binding model error!");
            this.f356470a.c(false);
            return;
        }
        URL protocolURL = this.f356471b.getProtocolURL();
        if (protocolURL == null) {
            this.f356470a.c(false);
            return;
        }
        com.tencent.qqnt.emotion.stickerrecommended.g gVar = this.f356471b;
        URLDrawable uRLDrawable = gVar.getURLDrawable(protocolURL, p(gVar));
        this.f356470a.f356485h.setTag(this.f356471b);
        if (uRLDrawable.getStatus() != 1) {
            uRLDrawable.addHeader("my_uin", this.f356472c.getAccount());
            uRLDrawable.addHeader(ProtocolDownloaderConstants.HEADER_EMOTICON_NEED_BIG, "true");
            uRLDrawable.addHeader("report_key_start_download", String.valueOf(System.currentTimeMillis()));
            if (uRLDrawable.getStatus() == 2 || uRLDrawable.getStatus() == 3) {
                uRLDrawable.restartDownload();
            }
        } else if (StickerRecManagerImpl.isStickerRecFromRemote(this.f356471b) && !f356469l.contains(((o) this.f356471b).r())) {
            f356469l.add(((o) this.f356471b).r());
            f356468k.add(new StickerRecCacheEntity(((o) this.f356471b).j(), System.currentTimeMillis(), ((o) this.f356471b).r()));
        }
        this.f356470a.f356485h.setImageDrawable(uRLDrawable);
        this.f356470a.f356485h.setURLDrawableDownListener(this.f356479j);
        this.f356470a.f356485h.setFocusable(true);
        this.f356470a.f356485h.setFocusableInTouchMode(true);
        if (StickerRecManagerImpl.isStickerRecFromRemote(this.f356471b)) {
            ((o) this.f356471b).F(true);
        }
        this.f356470a.c(true);
        this.f356471b.f(this.f356476g);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.d
    public c getModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (c) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f356471b;
    }

    public boolean h(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar)).booleanValue();
        }
        if (cVar instanceof com.tencent.qqnt.emotion.stickerrecommended.g) {
            this.f356471b = (com.tencent.qqnt.emotion.stickerrecommended.g) cVar;
            return true;
        }
        return false;
    }

    public boolean i(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar)).booleanValue();
        }
        if (eVar instanceof b) {
            this.f356470a = (b) eVar;
            return true;
        }
        return false;
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        com.tencent.qqnt.emotion.stickerrecommended.g gVar = this.f356471b;
        if (gVar == null) {
            return this.f356470a.f356483e;
        }
        if (StickerRecManagerImpl.isStickerRecFromLocal(gVar)) {
            return this.f356470a.f356483e;
        }
        if (!StickerRecManagerImpl.isStickerRecFromRemote(this.f356471b)) {
            return this.f356470a.f356483e;
        }
        o oVar = (o) this.f356471b;
        float y16 = oVar.y();
        float l3 = oVar.l();
        float f16 = y16 / l3;
        if (f16 <= 1.7777778f && f16 >= 0.5625f) {
            b bVar = this.f356470a;
            int i3 = (int) ((bVar.f356482d * y16) / l3);
            if (i3 == 0) {
                return bVar.f356483e;
            }
            return i3;
        }
        return this.f356470a.f356483e;
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f356476g;
    }

    public boolean q() {
        boolean z16;
        com.tencent.qqnt.emotion.stickerrecommended.g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.f356470a.f356485h.getDrawable() instanceof URLDrawable) {
            if (((URLDrawable) this.f356470a.f356485h.getDrawable()).getStatus() == 1) {
                w(this.f356471b);
                z16 = true;
                if (z16 && (gVar = this.f356471b) != null && StickerRecManagerImpl.isStickerRecFromRemote(gVar)) {
                    ((o) this.f356471b).D(true);
                }
                HashMap hashMap = new HashMap();
                hashMap.put(EmotionReportDtImpl.TEXT_IN_TEXTBOX, m());
                com.tencent.mobileqq.aio.utils.b.l(EmotionReportDtImpl.EM_AIO_TEXTBOX_STICKERS_RECOMMEND_BAR, hashMap);
                v();
                return z16;
            }
            if (QLog.isColorLevel()) {
                QLog.e("CommonStickerRec", 2, "onClick:URLDrawable status != successed");
            }
        }
        z16 = false;
        if (z16) {
            ((o) this.f356471b).D(true);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(EmotionReportDtImpl.TEXT_IN_TEXTBOX, m());
        com.tencent.mobileqq.aio.utils.b.l(EmotionReportDtImpl.EM_AIO_TEXTBOX_STICKERS_RECOMMEND_BAR, hashMap2);
        v();
        return z16;
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f356471b instanceof m;
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        com.tencent.qqnt.emotion.stickerrecommended.g gVar = this.f356471b;
        if (gVar instanceof t) {
            return ((t) gVar).h();
        }
        if (gVar instanceof r) {
            return ((r) gVar).h();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        int i3;
        HashMap hashMap = new HashMap();
        hashMap.put(EmotionReportDtImpl.PARAM_EXPRESSION_PACK_ID, this.f356471b.g());
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, this.f356471b.a());
        hashMap.put("associative_text", this.f356476g);
        if (this.f356478i == StickerRecKeywordFrom.LITE_ACTION) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("come_from", Integer.valueOf(i3));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_slot_memes_recommended", hashMap);
    }

    protected void w(com.tencent.qqnt.emotion.stickerrecommended.g gVar) {
        com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.c findScenesRecItemByID;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) gVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CommonStickerRec", 2, "sendPic");
        }
        if (gVar == null) {
            return;
        }
        String str = this.f356476g;
        if (this.f356477h == 1 && (findScenesRecItemByID = ((IScenesRecommendManager) this.f356472c.getRuntimeService(IScenesRecommendManager.class, "")).findScenesRecItemByID(this.f356476g)) != null) {
            str = findScenesRecItemByID.b();
        }
        StickerRecManagerImpl.get(this.f356472c).setCurrentText(str);
        if (StickerRecManagerImpl.isStickerRecFromLocal(gVar)) {
            gVar.d((BaseQQAppInterface) this.f356472c, this.f356473d);
            MqqHandler handler = this.f356472c.getHandler(getClass());
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(94));
                return;
            }
            return;
        }
        o oVar = (o) gVar;
        Intent intent = new Intent();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(oVar.j());
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        boolean z16 = false;
        intent.putExtra("PicContants.NEED_COMPRESS", false);
        intent.putExtra("uin", this.f356475f.j());
        intent.putExtra("uintype", this.f356475f.e());
        intent.putExtra("troop_uin", this.f356475f.j());
        intent.putExtra(PeakConstants.SEND_SIZE_SPEC, 0);
        intent.putExtra(PeakConstants.SEND_IN_BACKGROUND, true);
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList);
        intent.putExtra("PicContants.NEED_COMPRESS", false);
        intent.putExtra(IPicBus.ORIGINAL_MD5, oVar.getImgMd5());
        intent.putExtra(IPicBus.ORIGINAL_SIZE, oVar.m());
        intent.putExtra(IPicBus.THUMB_MD5, oVar.v());
        intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1047);
        intent.putExtra(HotPicData.HOT_PIC_HAS_EXTRA, true);
        if (TextUtils.isEmpty(oVar.x()) || oVar.x().length() <= 100) {
            z16 = true;
        }
        if (z16) {
            intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_FROM, oVar.k());
            intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_INFO, oVar.u());
            intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_WEBURL, oVar.x());
            intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_ICONURL, "");
            intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_PACKAGE, oVar.s());
            intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_EPID, oVar.i());
        } else {
            com.tencent.mobileqq.temp.report.a.a(null, "dc00898", "", "", "0X800A7EA", "0X800A7EA", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.i("CommonStickerRec", 2, "sendPic over limited!");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("CommonStickerRec", 2, "sendPic md5:" + oVar.getImgMd5() + ", srcfrom:" + oVar.k() + ", desc:" + oVar.u() + ", webUrl:" + oVar.x() + ", pack:" + oVar.s() + ", epid:" + oVar.i());
        }
        if (oVar.k() == 1) {
            o.a q16 = oVar.q();
            ((IEmoticonMarketFace) QRoute.api(IEmoticonMarketFace.class)).sendMarketFace(this.f356473d, q16.f356620a, q16.f356621b);
        } else {
            ((IEmosmService) QRoute.api(IEmosmService.class)).sendRecEmoPic(this.f356472c, this.f356473d, o(), intent, arrayList);
        }
        MqqHandler handler2 = this.f356472c.getHandler(getClass());
        if (handler2 != null) {
            handler2.sendMessage(handler2.obtainMessage(94));
        }
    }
}
