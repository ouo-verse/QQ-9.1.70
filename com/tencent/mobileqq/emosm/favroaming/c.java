package com.tencent.mobileqq.emosm.favroaming;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.IChatHistoryEmotionBaseFragment;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.multimsg.save.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c implements Handler.Callback, k {
    int C;
    int D;
    BaseQQAppInterface F;
    com.tencent.mobileqq.multimsg.save.a G;
    public boolean H;
    public int J;
    int L;

    /* renamed from: e, reason: collision with root package name */
    IChatHistoryEmotionBaseFragment f204332e;

    /* renamed from: f, reason: collision with root package name */
    int f204333f;

    /* renamed from: h, reason: collision with root package name */
    int f204334h;

    /* renamed from: i, reason: collision with root package name */
    int f204335i;

    /* renamed from: m, reason: collision with root package name */
    int f204336m;
    boolean E = false;

    /* renamed from: d, reason: collision with root package name */
    Handler f204331d = new Handler(Looper.getMainLooper(), this);
    a.b I = new a();
    public Map<String, Integer> K = new HashMap();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements a.b {
        a() {
        }

        @Override // com.tencent.mobileqq.multimsg.save.a.b
        public void cancel() {
            c cVar = c.this;
            cVar.E = true;
            cVar.H = true;
        }
    }

    public c(IChatHistoryEmotionBaseFragment iChatHistoryEmotionBaseFragment, BaseQQAppInterface baseQQAppInterface) {
        this.f204332e = iChatHistoryEmotionBaseFragment;
        this.F = baseQQAppInterface;
    }

    private void f() {
        if (!this.E) {
            this.E = true;
            com.tencent.mobileqq.multimsg.save.a aVar = this.G;
            if (aVar != null && aVar.isShowing()) {
                this.G.dismiss();
                this.G = null;
            }
            MqqHandler handler = this.F.getHandler(((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityClass());
            if (handler != null) {
                handler.obtainMessage(10).sendToTarget();
            }
            IChatHistoryEmotionBaseFragment iChatHistoryEmotionBaseFragment = this.f204332e;
            if (iChatHistoryEmotionBaseFragment != null) {
                iChatHistoryEmotionBaseFragment.changeToUnSelected();
                if (this.f204335i > 0) {
                    QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.zpk), 1).show();
                } else if (this.C == this.f204333f) {
                    QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.zu_), 1).show();
                } else {
                    int i3 = this.f204336m;
                    if (i3 == 0) {
                        QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.inb), 1).show();
                    } else if (i3 > 0) {
                        if (this.D > 0) {
                            QQToast.makeText(BaseApplication.getContext(), 0, BaseApplication.getContext().getString(R.string.ind), 1).show();
                        } else {
                            QQToast.makeText(BaseApplication.getContext(), 2, BaseApplication.getContext().getString(R.string.zua), 1).show();
                        }
                    }
                }
            }
            StickerRecManagerImpl.get(this.F).updateKeywordForFavEmotion();
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
        }
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.k
    public int a() {
        return this.J;
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.k
    public synchronized void b(int i3) {
        Handler handler = this.f204331d;
        if (handler != null) {
            handler.sendEmptyMessage(i3);
        }
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.k
    public int c(Integer num) {
        return this.L + num.intValue();
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.k
    public boolean contains(String str) {
        return this.K.containsKey(str);
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.k
    public int d(String str) {
        Map<String, Integer> map = this.K;
        if (map != null) {
            return map.get(str).intValue();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.k
    public void e(String str, Integer num) {
        this.K.put(str, Integer.valueOf(this.L + num.intValue()));
    }

    public void g() {
        com.tencent.mobileqq.multimsg.save.a aVar = new com.tencent.mobileqq.multimsg.save.a(this.f204332e.getBaseActivity());
        this.G = aVar;
        aVar.P(this.I);
        this.G.show();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.H) {
            return false;
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 100) {
                            g();
                            return true;
                        }
                    } else {
                        this.f204336m++;
                    }
                } else {
                    this.D++;
                }
            } else {
                this.C++;
            }
        } else {
            this.f204335i++;
        }
        int i16 = this.f204334h - 1;
        this.f204334h = i16;
        com.tencent.mobileqq.multimsg.save.a aVar = this.G;
        if (aVar != null) {
            int i17 = this.f204333f;
            aVar.Q(((i17 - i16) * 100) / i17);
        }
        if (this.f204334h <= 0 || message.what == 1) {
            f();
        }
        QLog.d("EmoBatchAdded", 2, "ahandleMessage =" + message.what + ",mNeedAddCount:" + this.f204334h + ",mTotalCount:" + this.f204333f);
        return true;
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.k
    public void init(int i3) {
        this.f204333f = i3;
        this.f204334h = i3;
        this.f204335i = 0;
        this.f204336m = 0;
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.H = false;
        this.K.clear();
        this.L = 1;
        this.J = 0;
        List<CustomEmotionData> emoticonDataList = ((IFavroamingDBManagerService) this.F.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
        if (emoticonDataList != null) {
            for (int i16 = 0; i16 < emoticonDataList.size(); i16++) {
                int i17 = emoticonDataList.get(i16).emoId;
                if (this.L < i17) {
                    this.L = i17;
                }
                if (TextUtils.isEmpty(emoticonDataList.get(i16).RomaingType) || !"needDel".equals(emoticonDataList.get(i16).RomaingType)) {
                    this.J++;
                }
            }
        }
        QLog.i("EmoBatchAddedHandler", 4, "init emoCount=" + this.J);
        this.L = this.L + 1;
    }
}
