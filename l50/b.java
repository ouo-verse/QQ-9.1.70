package l50;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.events.QFSPublicAccountStaggerLifecycleEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.QFSPublicAccountXingHuanAdMaskView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.QFSPublicAccountXingHuanAdMaskDownloadManager;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.i;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.j;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\"\u0010\u0013\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0014\u001a\u00020\u0005J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00180\u0017H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001b\u00a8\u0006 "}, d2 = {"Ll50/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lorg/json/JSONObject;", "maskTaskInfo", "", h.F, "", "b", "", "e", "cachedMaskTaskInfo", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Le30/b;", "feed", "f", "d", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/xinghuan/QFSPublicAccountXingHuanAdMaskView;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/xinghuan/QFSPublicAccountXingHuanAdMaskView;", "maskView", "<init>", "()V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSPublicAccountXingHuanAdMaskView maskView;

    private final boolean b(JSONObject maskTaskInfo) {
        return k.a().i(e(), new LinkedHashSet()).contains(j.h(maskTaskInfo));
    }

    private final boolean c(JSONObject cachedMaskTaskInfo) {
        boolean z16;
        boolean z17;
        if (j.k(cachedMaskTaskInfo).length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (j.j(cachedMaskTaskInfo).length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d("QFSPublicAccountXingHuanAdMaskInterceptor", 1, "isAdPageResExist = " + z16 + " isAdCoverResExist=" + z17);
        if (!z16 && !z17) {
            return false;
        }
        return true;
    }

    private final String e() {
        return "exposedXingHuanMaskTaskIdSet" + i.f87158a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(b this$0, ViewGroup container, JSONObject maskTaskInfoJson) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(container, "$container");
        Intrinsics.checkNotNullParameter(maskTaskInfoJson, "$maskTaskInfoJson");
        QFSPublicAccountXingHuanAdMaskView qFSPublicAccountXingHuanAdMaskView = this$0.maskView;
        if (qFSPublicAccountXingHuanAdMaskView != null) {
            qFSPublicAccountXingHuanAdMaskView.n(container);
        }
        this$0.h(maskTaskInfoJson);
    }

    private final void h(JSONObject maskTaskInfo) {
        Set<String> i3 = k.a().i(e(), new LinkedHashSet());
        i3.add(j.h(maskTaskInfo));
        k.a().q(e(), i3);
    }

    public final void d() {
        this.maskView = null;
    }

    public final void f(@Nullable Activity activity, @NotNull final ViewGroup container, @Nullable e30.b feed) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (feed == null) {
            return;
        }
        FeedCloudMeta$StFeed g16 = feed.g();
        Intrinsics.checkNotNullExpressionValue(g16, "feed.sourceData");
        final JSONObject d16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.d(g16);
        if (d16.length() <= 0) {
            QLog.d("QFSPublicAccountXingHuanAdMaskInterceptor", 1, "maskTaskInfoJson is empty");
            return;
        }
        if (!j.a(d16)) {
            QLog.d("QFSPublicAccountXingHuanAdMaskInterceptor", 1, "ad has expired, cancel show");
            return;
        }
        if (b(d16)) {
            QLog.d("QFSPublicAccountXingHuanAdMaskInterceptor", 1, "ad has exposed, cancel show");
            return;
        }
        if (activity != null) {
            List<JSONObject> e16 = QFSPublicAccountXingHuanAdMaskDownloadManager.f87145a.e();
            if (e16.isEmpty()) {
                QLog.d("QFSPublicAccountXingHuanAdMaskInterceptor", 1, "ad no cache, cancel show");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            Iterator<JSONObject> it = e16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JSONObject next = it.next();
                if (Intrinsics.areEqual(j.h(next), j.h(d16))) {
                    QFSPublicAccountXingHuanAdMaskView qFSPublicAccountXingHuanAdMaskView = new QFSPublicAccountXingHuanAdMaskView(activity);
                    this.maskView = qFSPublicAccountXingHuanAdMaskView;
                    qFSPublicAccountXingHuanAdMaskView.g(d16, feed.g());
                    jSONObject = next;
                    break;
                }
            }
            if (c(jSONObject)) {
                activity.runOnUiThread(new Runnable() { // from class: l50.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.g(b.this, container, d16);
                    }
                });
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSPublicAccountStaggerLifecycleEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>");
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        QFSPublicAccountXingHuanAdMaskView qFSPublicAccountXingHuanAdMaskView;
        if ((event instanceof QFSPublicAccountStaggerLifecycleEvent) && ((QFSPublicAccountStaggerLifecycleEvent) event).getStatus() == 2 && (qFSPublicAccountXingHuanAdMaskView = this.maskView) != null) {
            qFSPublicAccountXingHuanAdMaskView.m(false);
        }
    }
}
