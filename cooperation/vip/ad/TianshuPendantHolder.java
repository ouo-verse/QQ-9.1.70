package cooperation.vip.ad;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.chats.biz.tianshu.TianShuConversationThirdView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.event.TianshuAdCloseEvent;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;

/* loaded from: classes28.dex */
public class TianshuPendantHolder extends com.tencent.mobileqq.armap.d implements TianShuConversationThirdView.a, SimpleEventReceiver {

    /* renamed from: b0, reason: collision with root package name */
    public static float f391070b0 = 112.0f;
    private TianShuAccess.AdItem U;
    private QQAppInterface V;
    private Drawable W;
    private Rect X;
    private Rect Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private final Drawable.Callback f391071a0;

    /* loaded from: classes28.dex */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            View view = TianshuPendantHolder.this.J;
            if (view != null) {
                view.invalidate();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j3) {
            long uptimeMillis = j3 - SystemClock.uptimeMillis();
            View view = TianshuPendantHolder.this.J;
            if (view != null) {
                view.postDelayed(runnable, uptimeMillis);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            View view = TianshuPendantHolder.this.J;
            if (view != null) {
                view.removeCallbacks(runnable);
            }
        }
    }

    public TianshuPendantHolder(QQAppInterface qQAppInterface, View view) {
        super(view);
        this.f391071a0 = new a();
        this.V = qQAppInterface;
        if (this.W == null) {
            this.W = this.I.getResources().getDrawable(R.drawable.f160258mn4);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void p() {
        TianShuAccess.AdItem adItem;
        if (i.j() && (adItem = this.U) != null && adItem.argList.get() != null && !this.U.argList.get().isEmpty()) {
            for (TianShuAccess.MapEntry mapEntry : this.U.argList.get()) {
                if ("connect_adids".equals(mapEntry.key.get())) {
                    if (!TextUtils.isEmpty(mapEntry.value.get())) {
                        SimpleEventBus.getInstance().dispatchEvent(new TianshuAdCloseEvent(mapEntry.value.get(), hashCode()));
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void q(TianshuAdCloseEvent tianshuAdCloseEvent) {
        if (tianshuAdCloseEvent != null && tianshuAdCloseEvent.getList() != null && !tianshuAdCloseEvent.getList().isEmpty() && this.U != null && tianshuAdCloseEvent.getSenderHashCode() != hashCode()) {
            QLog.d("TianshuPendantHolder", 1, "handleCloseEvent currentAdId:" + this.U.iAdId.get());
            if (tianshuAdCloseEvent.getList().contains(Integer.valueOf(this.U.iAdId.get()))) {
                s(true);
            }
        }
    }

    private void s(boolean z16) {
        QLog.d("TianshuPendantHolder", 1, "onCloseClick");
        View view = this.J;
        if (view != null && (view instanceof TianShuConversationThirdView)) {
            ((TianShuConversationThirdView) view).setPendantHolder(null);
        }
        TianShuAccess.AdItem adItem = this.U;
        if (adItem != null) {
            w.f(String.valueOf(adItem.iAdId.get()), 122, this.U.traceinfo.get());
        }
        if (!z16) {
            p();
        }
    }

    private void t() {
        QLog.d("TianshuPendantHolder", 1, "onIconClick");
        i.h(this.V, this.I, this.Z, 4004);
        View view = this.J;
        if (view != null && (view instanceof TianShuConversationThirdView)) {
            ((TianShuConversationThirdView) view).setPendantHolder(null);
            ((TianShuConversationThirdView) this.J).setOnPendentClickListener(null);
        }
        TianShuAccess.AdItem adItem = this.U;
        if (adItem != null) {
            w.f(String.valueOf(adItem.iAdId.get()), 102, this.U.traceinfo.get());
        }
        p();
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.tianshu.TianShuConversationThirdView.a
    public void a(float f16, float f17) {
        QLog.d("TianshuPendantHolder", 1, "onPendentClick   | x = " + f16 + " | y = " + f17 + " | mTouchRect = " + this.G + " | mCloseClickArea = " + this.Y);
        Rect rect = this.Y;
        if (rect != null && rect.contains((int) f16, (int) f17)) {
            s(false);
        } else {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.armap.d
    public void f(Canvas canvas) {
        super.f(canvas);
        if (this.W != null) {
            canvas.save();
            this.W.setBounds(this.X);
            this.W.draw(canvas);
            canvas.restore();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(TianshuAdCloseEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.armap.d
    public void m(int i3) {
        super.m(i3);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof TianshuAdCloseEvent) {
            q((TianshuAdCloseEvent) simpleBaseEvent);
        }
    }

    public void r() {
        try {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: cooperation.vip.ad.TianshuPendantHolder.2
                @Override // java.lang.Runnable
                public void run() {
                    int dpToPx = ImmersiveUtils.dpToPx(160.0f);
                    int dpToPx2 = ImmersiveUtils.dpToPx(TianshuPendantHolder.f391070b0);
                    View view = TianshuPendantHolder.this.J;
                    if (view instanceof TianShuConversationThirdView) {
                        ((TianShuConversationThirdView) view).b(dpToPx, dpToPx2);
                    }
                    TianshuPendantHolder tianshuPendantHolder = TianshuPendantHolder.this;
                    tianshuPendantHolder.c(0, 0, dpToPx, dpToPx2, tianshuPendantHolder.J);
                    TianshuPendantHolder.this.X = new Rect((TianshuPendantHolder.this.f259360e + dpToPx) - ImmersiveUtils.dpToPx(23.0f), TianshuPendantHolder.this.f259361f + ImmersiveUtils.dpToPx(22.0f), (TianshuPendantHolder.this.f259360e + dpToPx) - ImmersiveUtils.dpToPx(8.0f), TianshuPendantHolder.this.f259361f + ImmersiveUtils.dpToPx(37.0f));
                    TianshuPendantHolder tianshuPendantHolder2 = TianshuPendantHolder.this;
                    int dpToPx3 = (TianshuPendantHolder.this.f259360e + dpToPx) - ImmersiveUtils.dpToPx(23.0f);
                    TianshuPendantHolder tianshuPendantHolder3 = TianshuPendantHolder.this;
                    int i3 = tianshuPendantHolder3.f259361f;
                    tianshuPendantHolder2.Y = new Rect(dpToPx3, i3, tianshuPendantHolder3.f259360e + dpToPx, ImmersiveUtils.dpToPx(37.0f) + i3);
                }
            });
        } catch (Throwable th5) {
            QLog.e("TianshuPendantHolder", 1, th5, new Object[0]);
        }
    }

    public void u(TianShuAccess.AdItem adItem) {
        if (adItem == null) {
            QLog.e("TianshuPendantHolder", 2, "showLayer with null ");
            return;
        }
        this.U = adItem;
        this.Z = null;
        String str = null;
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            if (mapEntry.key.get().equals("image")) {
                str = mapEntry.value.get();
            } else if (mapEntry.key.get().equals("url")) {
                this.Z = mapEntry.value.get();
            }
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.Z)) {
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).checkAndPreloadRes(this.Z);
            URLDrawable apngURLDrawable = VasApngUtil.getApngURLDrawable(str, new int[]{2}, com.tencent.mobileqq.urldrawable.b.f306350a, null, null);
            this.f259364m = apngURLDrawable;
            if (apngURLDrawable != null) {
                apngURLDrawable.setCallback(this.f391071a0);
                TianShuAccess.AdItem adItem2 = this.U;
                if (adItem2 != null) {
                    String valueOf = String.valueOf(adItem2.iAdId.get());
                    w.f(valueOf, 101, this.U.traceinfo.get());
                    IHippyAccessHelper iHippyAccessHelper = (IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class);
                    TabPreloadItem.AdType adType = TabPreloadItem.AdType.MESSAGE_TAB_DIAO_ZUI;
                    if (iHippyAccessHelper.isAdNeedsPreload(valueOf, adType)) {
                        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).preloadAdHippy(valueOf, adType);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        QLog.e("TianshuPendantHolder", 1, "setpendantres error with image url " + str + " jumpUrl " + this.Z);
    }

    @Override // com.tencent.mobileqq.armap.d
    protected void i(Canvas canvas) {
    }
}
