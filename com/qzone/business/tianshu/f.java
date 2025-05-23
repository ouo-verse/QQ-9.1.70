package com.qzone.business.tianshu;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.vip.pb.TianShuAccess;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import q5.QZoneFloatPlusBubbleInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\f\u001a\u00020\u0006H\u0014J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0014R0\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/business/tianshu/f;", "Lcom/qzone/business/tianshu/b;", "", "redPointTianShuTrans", "", "j", "", "adPostId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "f", "b", "", "c", "Lmqq/util/WeakReference;", "Landroidx/lifecycle/MutableLiveData;", "Lq5/b;", "Lmqq/util/WeakReference;", "getBubbleLiveDataWeakRef", "()Lmqq/util/WeakReference;", "l", "(Lmqq/util/WeakReference;)V", "bubbleLiveDataWeakRef", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class f extends b {

    /* renamed from: b, reason: collision with root package name */
    public static final f f44865b = new f();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<MutableLiveData<QZoneFloatPlusBubbleInfo>> bubbleLiveDataWeakRef;

    f() {
    }

    private final void j(final byte[] redPointTianShuTrans) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.business.tianshu.e
            @Override // java.lang.Runnable
            public final void run() {
                f.k(redPointTianShuTrans, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(byte[] redPointTianShuTrans, f this$0) {
        Intrinsics.checkNotNullParameter(redPointTianShuTrans, "$redPointTianShuTrans");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            TianShuAccess.RspEntry rspEntry = new TianShuAccess.RspEntry();
            rspEntry.mergeFrom(redPointTianShuTrans);
            if (rspEntry.has()) {
                f fVar = f44865b;
                if (fVar.h(rspEntry) && fVar.m(rspEntry.key.get())) {
                    fVar.f44856a = rspEntry.value.lst.get(0);
                    fVar.f(rspEntry.key.get());
                    com.qzone.reborn.util.i.b().m("publish_plus_icon_tian_shu_entry", null);
                    QLog.d("QZoneFloatPlusBubbleHelper", 1, "fetchData from red point success,adPostId: " + rspEntry.key.get());
                }
            }
            super.a();
        } catch (Exception e16) {
            QLog.e("QZoneFloatPlusBubbleHelper", 1, "fetchData parse tian shu error " + e16);
        }
    }

    private final boolean m(int adPostId) {
        if (adPostId == 1362) {
            return true;
        }
        return false;
    }

    @Override // com.qzone.business.tianshu.b
    public void a() {
        byte[] tianShuByteTrans = com.qzone.reborn.util.i.b().e("publish_plus_icon_tian_shu_entry", null);
        boolean z16 = false;
        if (tianShuByteTrans != null) {
            if (!(tianShuByteTrans.length == 0)) {
                z16 = true;
            }
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(tianShuByteTrans, "tianShuByteTrans");
            j(tianShuByteTrans);
        } else {
            super.a();
        }
    }

    @Override // com.qzone.business.tianshu.b
    protected int b() {
        return 1362;
    }

    @Override // com.qzone.business.tianshu.b
    protected void f(int adPostId) {
        MutableLiveData<QZoneFloatPlusBubbleInfo> mutableLiveData;
        HashMap<String, String> argMap = g();
        RFWLog.d("QZoneFloatPlusBubbleHelper", RFWLog.USR, "parseBubbleInfo\uff1a" + argMap);
        Intrinsics.checkNotNullExpressionValue(argMap, "argMap");
        if (!argMap.isEmpty()) {
            QZoneFloatPlusBubbleInfo a16 = QZoneFloatPlusBubbleInfo.INSTANCE.a(this.f44856a, argMap);
            WeakReference<MutableLiveData<QZoneFloatPlusBubbleInfo>> weakReference = bubbleLiveDataWeakRef;
            if (weakReference == null || (mutableLiveData = weakReference.get()) == null) {
                return;
            }
            mutableLiveData.postValue(a16);
        }
    }

    public final void l(WeakReference<MutableLiveData<QZoneFloatPlusBubbleInfo>> weakReference) {
        bubbleLiveDataWeakRef = weakReference;
    }

    @Override // com.qzone.business.tianshu.b
    protected List<Integer> c() {
        List<Integer> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Integer.valueOf(b()));
        return mutableListOf;
    }
}
