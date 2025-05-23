package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleRefreshIconDecorateEvent;
import com.tencent.biz.qqcircle.manager.QCircleAvatarDecorateManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StIconDecorate;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleAvatarDecorateView extends ImageView implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private FeedCloudMeta$StUser f92897d;

    /* renamed from: e, reason: collision with root package name */
    private int f92898e;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
    }

    public QCircleAvatarDecorateView(Context context) {
        this(context, null);
    }

    private void b() {
        setImageDrawable(null);
    }

    private void d(Context context, AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.E4);
        this.f92898e = obtainStyledAttributes.getInt(y91.a.F4, 0);
        obtainStyledAttributes.recycle();
    }

    public static boolean e(FeedCloudMeta$StIconDecorate feedCloudMeta$StIconDecorate) {
        if (feedCloudMeta$StIconDecorate == null || System.currentTimeMillis() >= feedCloudMeta$StIconDecorate.endTime.get()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        b();
        if (k()) {
            QLog.d("QCircleAvatarDecorateView", 1, "QCircleRefreshIconDecorate get from cache data succeed");
        } else if (h()) {
            QLog.d("QCircleAvatarDecorateView", 1, "QCircleRefreshIconDecorate get from server data succeed");
        }
    }

    private boolean g(FeedCloudMeta$StIconDecorate feedCloudMeta$StIconDecorate) {
        String str;
        if (feedCloudMeta$StIconDecorate == null) {
            i(false);
            return false;
        }
        if (!e(feedCloudMeta$StIconDecorate)) {
            QLog.d("QCircleAvatarDecorateView", 1, "QCircleRefreshIconDecorate cache over time endTime:" + feedCloudMeta$StIconDecorate.endTime.get());
            i(false);
            return false;
        }
        if (!TextUtils.isEmpty(feedCloudMeta$StIconDecorate.layerUrl.get()) && this.f92898e == 0) {
            str = feedCloudMeta$StIconDecorate.layerUrl.get();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(feedCloudMeta$StIconDecorate.mainpageUrl.get()) && this.f92898e == 1) {
            str = feedCloudMeta$StIconDecorate.mainpageUrl.get();
        }
        if (!TextUtils.isEmpty(str)) {
            c(str);
            i(true);
            return true;
        }
        i(false);
        return false;
    }

    private boolean h() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f92897d;
        if (feedCloudMeta$StUser == null) {
            return false;
        }
        return g(feedCloudMeta$StUser.iconDecorate);
    }

    private boolean k() {
        FeedCloudMeta$StIconDecorate ownerAvatarDecorateInfo;
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f92897d;
        if (feedCloudMeta$StUser == null || !QCirclePluginUtil.isOwner(feedCloudMeta$StUser) || (ownerAvatarDecorateInfo = QCircleAvatarDecorateManager.INSTANCE.getOwnerAvatarDecorateInfo()) == null) {
            return false;
        }
        return g(ownerAvatarDecorateInfo);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("QCircleAvatarDecorateView", str));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleRefreshIconDecorateEvent.class);
        return arrayList;
    }

    protected void j() {
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.d
            @Override // java.lang.Runnable
            public final void run() {
                QCircleAvatarDecorateView.this.f();
            }
        });
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            SimpleEventBus.getInstance().registerReceiver(this);
        }
        j();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isInEditMode()) {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleRefreshIconDecorateEvent) {
            QLog.d("QCircleAvatarDecorateView", 1, "QCircleRefreshIconDecorate receive QCircleRefreshIconDecorateEvent");
            j();
        }
    }

    public void setUser(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.f92897d = feedCloudMeta$StUser;
        j();
    }

    public QCircleAvatarDecorateView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleAvatarDecorateView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        d(context, attributeSet, i3);
    }

    private void i(boolean z16) {
    }

    public void setStateListener(a aVar) {
    }
}
