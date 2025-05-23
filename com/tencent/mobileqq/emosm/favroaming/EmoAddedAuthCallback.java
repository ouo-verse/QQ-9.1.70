package com.tencent.mobileqq.emosm.favroaming;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.event.a;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.bus.api.IBusManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmoAddedAuthCallback implements ad, Handler.Callback {
    private WeakReference<c> C;

    /* renamed from: d, reason: collision with root package name */
    BaseQQAppInterface f204298d;

    /* renamed from: e, reason: collision with root package name */
    Context f204299e;

    /* renamed from: f, reason: collision with root package name */
    CustomEmotionData f204300f;

    /* renamed from: h, reason: collision with root package name */
    Object f204301h;

    /* renamed from: i, reason: collision with root package name */
    int f204302i;
    private float D = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    Handler f204303m = new Handler(Looper.getMainLooper(), this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f204304d;

        a(Dialog dialog) {
            this.f204304d = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f204304d.dismiss();
            IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) EmoAddedAuthCallback.this.f204298d.getRuntimeService(IFavroamingDBManagerService.class);
            CustomEmotionData customEmotionData = EmoAddedAuthCallback.this.f204300f;
            FavoriteEmoticonInfo favoriteEmoticonInfo = new FavoriteEmoticonInfo();
            favoriteEmoticonInfo.type = 4;
            favoriteEmoticonInfo.path = iFavroamingDBManagerService.getCustomEmoticonPath(customEmotionData);
            favoriteEmoticonInfo.srcType = 2;
            favoriteEmoticonInfo.eId = customEmotionData.eId;
            favoriteEmoticonInfo.url = customEmotionData.url;
            favoriteEmoticonInfo.roamingType = customEmotionData.RomaingType;
            favoriteEmoticonInfo.emoId = customEmotionData.emoId;
            favoriteEmoticonInfo.resID = customEmotionData.resid;
            ((IEmosmService) QRoute.api(IEmosmService.class)).enterEmotionPreview(EmoAddedAuthCallback.this.f204299e, favoriteEmoticonInfo, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f204306d;

        b(Dialog dialog) {
            this.f204306d = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!((Activity) EmoAddedAuthCallback.this.f204299e).isFinishing() && this.f204306d.isShowing()) {
                this.f204306d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface c {
        void a(int i3, String str);
    }

    public EmoAddedAuthCallback(BaseQQAppInterface baseQQAppInterface, Context context, CustomEmotionData customEmotionData, Object obj, int i3) {
        this.f204298d = baseQQAppInterface;
        this.f204299e = context;
        this.f204300f = customEmotionData;
        this.f204301h = obj;
        this.f204302i = i3;
    }

    private void f(Dialog dialog) {
        View view = (View) ((Button) dialog.findViewById(R.id.lfp)).getParent();
        if (view instanceof LinearLayout) {
            View view2 = (View) view.getParent();
            if (view2 instanceof LinearLayout) {
                float f16 = view2.getResources().getDisplayMetrics().density / FontSettingManager.systemMetrics.density;
                double d16 = f16;
                if (d16 != 1.0d) {
                    float f17 = this.D;
                    if (f17 == 0.0f || f17 != f16) {
                        if (d16 < 1.0d) {
                            if (QLog.isColorLevel()) {
                                QLog.i("EmoAddedAuthCallback", 2, "qqemoticonpanel_add_fav_guide_dialog scale small than 1");
                                return;
                            }
                            return;
                        } else {
                            this.D = f16;
                            float f18 = 1.0f / f16;
                            view2.setScaleX(f18);
                            view2.setScaleY(f18);
                            return;
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("EmoAddedAuthCallback", 2, "qqemoticonpanel_add_fav_guide_dialog fontsize doesnt change");
                }
            }
        }
    }

    public static void j(BaseQQAppInterface baseQQAppInterface, Context context, int i3) {
        if (i3 == 1) {
            QQToast.makeText(context, FavEmoConstant.getAddFavEmoOverLimitTips(), 0).show(R.dimen.title_bar_height);
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2007", 1);
        } else if (i3 == 2) {
            QQToast.makeText(context, FavEmoConstant.getAddFavEmoOverLimitTips(), 0).show(R.dimen.title_bar_height);
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2007", 1);
        }
    }

    private boolean l() {
        try {
            List<CustomEmotionData> emoticonDataList = ((IFavroamingDBManagerService) this.f204298d.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
            if (emoticonDataList != null) {
                QLog.i("EmoAddedAuthCallback", 2, "showSvipTips size=" + emoticonDataList.size());
                if (emoticonDataList.size() != 501) {
                    return false;
                }
                return true;
            }
        } catch (Exception e16) {
            QLog.e("EmoAddedAuthCallback", 1, "showSvipTips error", e16);
        }
        return false;
    }

    protected void a() {
        WeakReference<c> weakReference;
        c cVar;
        if (QLog.isColorLevel()) {
            QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result success");
        }
        int i3 = this.f204302i;
        if (i3 == 0) {
            CustomEmotionData customEmotionData = this.f204300f;
            if (!customEmotionData.isMarkFace && TextUtils.isEmpty(customEmotionData.md5)) {
                this.f204300f.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(this.f204300f.emoPath));
                EntityManager createEntityManager = this.f204298d.getEntityManagerFactory().createEntityManager();
                if (createEntityManager != null) {
                    createEntityManager.update(this.f204300f);
                    createEntityManager.close();
                }
            }
            ((IFavroamingDBManagerService) this.f204298d.getRuntimeService(IFavroamingDBManagerService.class)).insertCustomEmotion(this.f204300f);
            ((com.tencent.qqnt.emotion.api.IFavroamingDBManagerService) this.f204298d.getRuntimeService(com.tencent.qqnt.emotion.api.IFavroamingDBManagerService.class)).insertCustomEmotion(this.f204300f);
            if (this.f204301h != null) {
                ((IEmosmService) QRoute.api(IEmosmService.class)).handleComicStructMsg(this.f204298d, this.f204301h, this.f204300f);
            }
            this.f204303m.sendEmptyMessage(3);
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new a.C7508a());
            MqqHandler handler = this.f204298d.getHandler(((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityClass());
            if (handler != null) {
                handler.obtainMessage(10).sendToTarget();
                return;
            }
            return;
        }
        if (1 != i3) {
            if (2 == i3) {
                ((IFavroamingDBManagerService) this.f204298d.getRuntimeService(IFavroamingDBManagerService.class)).insertCustomEmotion(this.f204300f);
                if (2 == this.f204302i && (weakReference = this.C) != null && (cVar = weakReference.get()) != null) {
                    cVar.a(0, this.f204300f.md5);
                    return;
                }
                return;
            }
            if (3 == i3) {
                ((IFavroamingDBManagerService) this.f204298d.getRuntimeService(IFavroamingDBManagerService.class)).insertCustomEmotion(this.f204300f);
                this.f204303m.sendEmptyMessage(3);
            }
        }
    }

    protected void c(int i3) {
        if (400010 == i3 || 400011 == i3) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    int size = ((IFavroamingDBManagerService) EmoAddedAuthCallback.this.f204298d.getRuntimeService(IFavroamingDBManagerService.class)).syncGetCustomEmotionInfoShowedInPanel().size();
                    if (size != FavEmoConstant.FAV_ROAMING_MAX_COUNT) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("local_size", String.valueOf(size));
                        hashMap.put("roaming_max_size", String.valueOf(FavEmoConstant.FAV_ROAMING_MAX_COUNT));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AddFavEmotionError", false, 0L, 0L, hashMap, "");
                    }
                }
            });
        }
    }

    protected void d(int i3) {
        c cVar;
        WeakReference<c> weakReference = this.C;
        if (weakReference != null && (cVar = weakReference.get()) != null) {
            if (400010 == i3) {
                cVar.a(2, this.f204300f.md5);
            } else if (400011 == i3) {
                cVar.a(3, this.f204300f.md5);
            } else {
                cVar.a(i3, this.f204300f.md5);
            }
        }
    }

    protected void e(int i3) {
        if (400010 == i3) {
            this.f204303m.sendEmptyMessage(1);
        } else if (400011 == i3) {
            this.f204303m.sendEmptyMessage(2);
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
        return null;
    }

    public void h(c cVar) {
        this.C = new WeakReference<>(cVar);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        CustomEmotionData customEmotionData;
        int i16 = message.what;
        if (i16 != 1 && i16 != 2) {
            if (i16 == 3) {
                Context context = this.f204299e;
                if (context != null) {
                    if (l()) {
                        i3 = R.string.zuu;
                    } else {
                        i3 = R.string.f170069ez;
                    }
                    QQToast.makeText(context, 2, i3, 0).show(R.dimen.title_bar_height);
                    CustomEmotionData customEmotionData2 = this.f204300f;
                    if (customEmotionData2 != null && customEmotionData2.isMarkFace) {
                        StickerRecManagerImpl.get(this.f204298d).updateKeywordForFavEmotion();
                    }
                    if (com.tencent.mobileqq.core.util.b.b(this.f204299e, this.f204298d.getCurrentUin()) && (this.f204299e instanceof Activity) && (customEmotionData = this.f204300f) != null && !customEmotionData.isMarkFace && this.f204302i == 0) {
                        i();
                    }
                }
                EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
            }
        } else {
            k(this.f204298d, this.f204299e, i16);
        }
        return true;
    }

    protected void i() {
        ReportDialog reportDialog = new ReportDialog(this.f204299e, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.h7z);
        Button button = (Button) reportDialog.findViewById(R.id.lfp);
        Button button2 = (Button) reportDialog.findViewById(R.id.bij);
        button.setOnClickListener(new a(reportDialog));
        button2.setOnClickListener(new b(reportDialog));
        if (FontSettingManager.getFontLevel() != 16.0f) {
            f(reportDialog);
        }
        if (!((Activity) this.f204299e).isFinishing()) {
            com.tencent.mobileqq.core.util.b.e(this.f204299e, this.f204298d.getCurrentUin(), false);
            reportDialog.show();
        }
    }

    protected void k(BaseQQAppInterface baseQQAppInterface, Context context, int i3) {
        j(baseQQAppInterface, context, i3);
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void q(ad.a aVar) {
        int i3 = aVar.f258597a;
        if (i3 == 0) {
            a();
            return;
        }
        if (-1 == i3) {
            int i16 = aVar.f258598b;
            c(i16);
            if (QLog.isColorLevel()) {
                QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result errCode=" + i16);
            }
            int i17 = this.f204302i;
            if (i17 == 0) {
                e(i16);
            } else if (2 == i17) {
                d(i16);
            } else if (3 == i17) {
                e(i16);
            }
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void r(ad.a aVar) {
    }
}
