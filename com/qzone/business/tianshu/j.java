package com.qzone.business.tianshu;

import android.app.Activity;
import android.text.TextUtils;
import com.qzone.business.tianshu.model.QZoneFeedGuideTianshuInfo;
import com.qzone.util.ak;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.vip.pb.TianShuAccess;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u0003B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u001a\u0010\r\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R \u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R \u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/business/tianshu/j;", "Lcom/qzone/business/tianshu/b;", "", "b", "", "c", "adPostId", "", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/business/tianshu/j$b;", "listener", "l", "o", DomainData.DOMAIN_NAME, "Lcom/qzone/business/tianshu/model/QZoneFeedGuideTianshuInfo;", "Lcom/qzone/business/tianshu/model/QZoneFeedGuideTianshuInfo;", "mGuideTianshuInfo", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "mActivityRef", "d", "mListenerRef", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class j extends com.qzone.business.tianshu.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static j f44874f;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedGuideTianshuInfo mGuideTianshuInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Activity> mActivityRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<b> mListenerRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/business/tianshu/j$a;", "", "Lcom/qzone/business/tianshu/j;", "a", "", "GUIDE_FLOATING_POST_ID", "I", "", "KEY_BUTTON_TEXT", "Ljava/lang/String;", "KEY_PIC", "KEY_TEXT", "KEY_TITLE", "KEY_URL", "TAG", "sHelper", "Lcom/qzone/business/tianshu/j;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.business.tianshu.j$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final j a() {
            if (j.f44874f == null) {
                synchronized (j.class) {
                    if (j.f44874f == null) {
                        j.f44874f = new j();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            j jVar = j.f44874f;
            Intrinsics.checkNotNull(jVar);
            return jVar;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/qzone/business/tianshu/j$b;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/business/tianshu/model/QZoneFeedGuideTianshuInfo;", "tianshuInfo", "", "N1", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public interface b {
        void N1(Activity activity, QZoneFeedGuideTianshuInfo tianshuInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(j this$0) {
        QZoneFeedGuideTianshuInfo qZoneFeedGuideTianshuInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<b> weakReference = this$0.mListenerRef;
        b bVar = weakReference != null ? weakReference.get() : null;
        WeakReference<Activity> weakReference2 = this$0.mActivityRef;
        Activity activity = weakReference2 != null ? weakReference2.get() : null;
        if (bVar == null || activity == null || (qZoneFeedGuideTianshuInfo = this$0.mGuideTianshuInfo) == null) {
            return;
        }
        bVar.N1(activity, qZoneFeedGuideTianshuInfo);
    }

    @Override // com.qzone.business.tianshu.b
    public int b() {
        return 1378;
    }

    @Override // com.qzone.business.tianshu.b
    public List<Integer> c() {
        return null;
    }

    @Override // com.qzone.business.tianshu.b
    protected void f(int adPostId) {
        TianShuAccess.AdItem adItem = this.f44856a;
        if (adItem == null) {
            return;
        }
        List<TianShuAccess.MapEntry> list = adItem.argList.get();
        if (bl.b(this.f44856a.argList.get())) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (TianShuAccess.MapEntry mapEntry : list) {
            String keyStr = mapEntry.key.get();
            String valueStr = mapEntry.value.get();
            if (!TextUtils.isEmpty(keyStr) && !TextUtils.isEmpty(valueStr)) {
                Intrinsics.checkNotNullExpressionValue(keyStr, "keyStr");
                Intrinsics.checkNotNullExpressionValue(valueStr, "valueStr");
                hashMap.put(keyStr, valueStr);
            }
        }
        TianShuAccess.AdItem mAdItem = this.f44856a;
        Intrinsics.checkNotNullExpressionValue(mAdItem, "mAdItem");
        QZoneFeedGuideTianshuInfo qZoneFeedGuideTianshuInfo = new QZoneFeedGuideTianshuInfo(mAdItem);
        this.mGuideTianshuInfo = qZoneFeedGuideTianshuInfo;
        Intrinsics.checkNotNull(qZoneFeedGuideTianshuInfo);
        qZoneFeedGuideTianshuInfo.setTitle((String) hashMap.get("title"));
        QZoneFeedGuideTianshuInfo qZoneFeedGuideTianshuInfo2 = this.mGuideTianshuInfo;
        Intrinsics.checkNotNull(qZoneFeedGuideTianshuInfo2);
        qZoneFeedGuideTianshuInfo2.setText((String) hashMap.get("text"));
        QZoneFeedGuideTianshuInfo qZoneFeedGuideTianshuInfo3 = this.mGuideTianshuInfo;
        Intrinsics.checkNotNull(qZoneFeedGuideTianshuInfo3);
        qZoneFeedGuideTianshuInfo3.setPic((String) hashMap.get("pic"));
        QZoneFeedGuideTianshuInfo qZoneFeedGuideTianshuInfo4 = this.mGuideTianshuInfo;
        Intrinsics.checkNotNull(qZoneFeedGuideTianshuInfo4);
        qZoneFeedGuideTianshuInfo4.setButtonText((String) hashMap.get("ButtonText"));
        QZoneFeedGuideTianshuInfo qZoneFeedGuideTianshuInfo5 = this.mGuideTianshuInfo;
        Intrinsics.checkNotNull(qZoneFeedGuideTianshuInfo5);
        qZoneFeedGuideTianshuInfo5.setUrl((String) hashMap.get("url"));
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.business.tianshu.i
            @Override // java.lang.Runnable
            public final void run() {
                j.m(j.this);
            }
        });
    }

    public final void l(Activity activity, b listener) {
        this.mActivityRef = new WeakReference<>(activity);
        this.mListenerRef = new WeakReference<>(listener);
        a();
    }

    public final void n() {
        ak.g(this.f44856a, 102);
    }

    public final void o() {
        ak.g(this.f44856a, 101);
    }
}
