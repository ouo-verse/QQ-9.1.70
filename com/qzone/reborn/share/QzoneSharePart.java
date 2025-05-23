package com.qzone.reborn.share;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.base.k;
import com.qzone.reborn.share.i;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.sharepanel.j;
import com.tencent.mobileqq.sharepanel.l;
import com.tencent.mobileqq.sharepanel.m;
import com.tencent.mobileqq.sharepanel.model.ShareConfirmAction;
import com.tencent.mobileqq.sharepanel.n;
import com.tencent.mobileqq.sharepanel.o;
import com.tencent.mobileqq.sharepanel.p;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u001d\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000!\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0014J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0006\u0010\u0013\u001a\u00020\u0004J\b\u0010\u0014\u001a\u00020\u0004H\u0004J\"\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/qzone/reborn/share/QzoneSharePart;", "Lcom/qzone/reborn/share/i;", "T", "Lcom/qzone/reborn/base/k;", "", "H9", "Lcom/qzone/reborn/share/e;", "G9", "initListener", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "I9", "onPartDestroy", "E9", "L9", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/qzone/reborn/share/QQShareActionManagerV2;", "d", "Lcom/qzone/reborn/share/QQShareActionManagerV2;", "F9", "()Lcom/qzone/reborn/share/QQShareActionManagerV2;", "mShareManager", "Ljava/lang/Class;", "e", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "viewModelClass", "", "f", "Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/sharepanel/f;", tl.h.F, "Lcom/tencent/mobileqq/sharepanel/f;", "sharePanel", "<init>", "(Lcom/qzone/reborn/share/QQShareActionManagerV2;Ljava/lang/Class;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QzoneSharePart<T extends i> extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QQShareActionManagerV2 mShareManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Class<T> viewModelClass;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String TAG;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.sharepanel.f sharePanel;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/share/QzoneSharePart$a", "Lcom/tencent/mobileqq/sharepanel/l;", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList<com.qzone.reborn.share.f> f59467a;

        a(CopyOnWriteArrayList<com.qzone.reborn.share.f> copyOnWriteArrayList) {
            this.f59467a = copyOnWriteArrayList;
        }

        @Override // com.tencent.mobileqq.sharepanel.l
        public void a() {
            Iterator<T> it = this.f59467a.iterator();
            while (it.hasNext()) {
                ((com.qzone.reborn.share.f) it.next()).a();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/share/QzoneSharePart$b", "Lcom/tencent/mobileqq/sharepanel/k;", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements com.tencent.mobileqq.sharepanel.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList<com.qzone.reborn.share.f> f59468a;

        b(CopyOnWriteArrayList<com.qzone.reborn.share.f> copyOnWriteArrayList) {
            this.f59468a = copyOnWriteArrayList;
        }

        @Override // com.tencent.mobileqq.sharepanel.k
        public void a() {
            Iterator<T> it = this.f59468a.iterator();
            while (it.hasNext()) {
                ((com.qzone.reborn.share.f) it.next()).b();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/share/QzoneSharePart$c", "Lcom/tencent/mobileqq/sharepanel/i;", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements com.tencent.mobileqq.sharepanel.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList<com.qzone.reborn.share.f> f59469a;

        c(CopyOnWriteArrayList<com.qzone.reborn.share.f> copyOnWriteArrayList) {
            this.f59469a = copyOnWriteArrayList;
        }

        @Override // com.tencent.mobileqq.sharepanel.i
        public void a() {
            Iterator<T> it = this.f59469a.iterator();
            while (it.hasNext()) {
                ((com.qzone.reborn.share.f) it.next()).c();
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/share/QzoneSharePart$d", "Lcom/tencent/mobileqq/sharepanel/n;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QzoneSharePart<T> f59470a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f59471b;

        d(QzoneSharePart<T> qzoneSharePart, com.qzone.reborn.share.e eVar) {
            this.f59470a = qzoneSharePart;
            this.f59471b = eVar;
        }

        @Override // com.tencent.mobileqq.sharepanel.n
        public void a(ArrayList<ResultRecord> targetList, m callback) {
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f59470a.getMShareManager().m(this.f59471b, targetList, callback);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/share/QzoneSharePart$e", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QzoneSharePart<T> f59472a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f59473b;

        e(QzoneSharePart<T> qzoneSharePart, com.qzone.reborn.share.e eVar) {
            this.f59472a = qzoneSharePart;
            this.f59473b = eVar;
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.f59472a.getMShareManager().d(this.f59473b, new com.qzone.reborn.share.b(channelId));
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(String actionId) {
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            this.f59472a.getMShareManager().d(this.f59473b, new com.qzone.reborn.share.b(actionId));
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/share/QzoneSharePart$f", "Lcom/tencent/mobileqq/sharepanel/d;", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "targetList", "", "leaveMsg", "", "J", "l", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class f implements com.tencent.mobileqq.sharepanel.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QzoneSharePart<T> f59474a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f59475b;

        f(QzoneSharePart<T> qzoneSharePart, com.qzone.reborn.share.e eVar) {
            this.f59474a = qzoneSharePart;
            this.f59475b = eVar;
        }

        @Override // com.tencent.mobileqq.sharepanel.d
        public boolean J(List<? extends ResultRecord> targetList, String leaveMsg) {
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            Intrinsics.checkNotNullParameter(leaveMsg, "leaveMsg");
            return this.f59474a.getMShareManager().g(this.f59475b, targetList, leaveMsg);
        }

        @Override // com.tencent.mobileqq.sharepanel.d
        public boolean l(List<? extends ResultRecord> targetList) {
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            return this.f59474a.getMShareManager().e(this.f59475b, targetList);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/share/QzoneSharePart$g", "Lcom/tencent/mobileqq/sharepanel/p;", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "action", "Lcom/tencent/mobileqq/sharepanel/o;", "callback", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class g implements p {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QzoneSharePart<T> f59476a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f59477b;

        g(QzoneSharePart<T> qzoneSharePart, com.qzone.reborn.share.e eVar) {
            this.f59476a = qzoneSharePart;
            this.f59477b = eVar;
        }

        @Override // com.tencent.mobileqq.sharepanel.p
        public void a(ShareConfirmAction action, o callback) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f59476a.getMShareManager().f(this.f59477b, action, callback);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/share/QzoneSharePart$h", "Lcom/tencent/mobileqq/sharepanel/h;", "", "channelId", "", "b", "actionId", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class h implements com.tencent.mobileqq.sharepanel.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QzoneSharePart<T> f59478a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f59479b;

        h(QzoneSharePart<T> qzoneSharePart, com.qzone.reborn.share.e eVar) {
            this.f59478a = qzoneSharePart;
            this.f59479b = eVar;
        }

        @Override // com.tencent.mobileqq.sharepanel.h
        public void a(String actionId) {
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            this.f59478a.getMShareManager().l(this.f59479b, actionId);
        }

        @Override // com.tencent.mobileqq.sharepanel.h
        public void b(String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.f59478a.getMShareManager().l(this.f59479b, channelId);
        }
    }

    public QzoneSharePart(QQShareActionManagerV2 mShareManager, Class<T> viewModelClass) {
        Intrinsics.checkNotNullParameter(mShareManager, "mShareManager");
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        this.mShareManager = mShareManager;
        this.viewModelClass = viewModelClass;
        this.TAG = "QzoneSharePart";
    }

    private final com.qzone.reborn.share.e G9() {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        QQShareActionManagerV2 qQShareActionManagerV2 = this.mShareManager;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        com.qzone.reborn.share.e eVar = new com.qzone.reborn.share.e(activity, qQShareActionManagerV2, lifecycleOwner, getPartRootView());
        i viewModel = this.mShareManager.getViewModel();
        eVar.e(viewModel != null ? viewModel.getData() : null);
        return eVar;
    }

    private final void H9() {
        Class<T> cls;
        if (this.mShareManager.getViewModel() != null || (cls = this.viewModelClass) == null) {
            return;
        }
        this.mShareManager.p((i) getViewModel(cls));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initListener() {
        com.qzone.reborn.share.d config;
        CopyOnWriteArrayList<com.qzone.reborn.share.f> c16;
        i viewModel = this.mShareManager.getViewModel();
        if (viewModel == null || (config = viewModel.getConfig()) == null || (c16 = config.c()) == null || c16.isEmpty()) {
            return;
        }
        com.tencent.mobileqq.sharepanel.f fVar = this.sharePanel;
        if (fVar != null) {
            fVar.e0(new a(c16));
        }
        com.tencent.mobileqq.sharepanel.f fVar2 = this.sharePanel;
        if (fVar2 != null) {
            fVar2.n0(new b(c16));
        }
        com.tencent.mobileqq.sharepanel.f fVar3 = this.sharePanel;
        if (fVar3 != null) {
            fVar3.i0(new c(c16));
        }
    }

    public final void E9() {
        this.mShareManager.c(G9());
    }

    /* renamed from: F9, reason: from getter */
    public final QQShareActionManagerV2 getMShareManager() {
        return this.mShareManager;
    }

    protected void I9() {
        MutableLiveData<wd.f> M1;
        MutableLiveData<Boolean> O1;
        i viewModel = this.mShareManager.getViewModel();
        if (viewModel != null && (O1 = viewModel.O1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(this) { // from class: com.qzone.reborn.share.QzoneSharePart$onInitData$1
                final /* synthetic */ QzoneSharePart<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        this.this$0.L9();
                    } else {
                        this.this$0.E9();
                    }
                }
            };
            O1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.share.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneSharePart.J9(Function1.this, obj);
                }
            });
        }
        i viewModel2 = this.mShareManager.getViewModel();
        if (viewModel2 == null || (M1 = viewModel2.M1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<wd.f, Unit> function12 = new Function1<wd.f, Unit>(this) { // from class: com.qzone.reborn.share.QzoneSharePart$onInitData$2
            final /* synthetic */ QzoneSharePart<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(wd.f fVar) {
                invoke2(fVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(wd.f fVar) {
                if (fVar == null) {
                    return;
                }
                this.this$0.broadcastMessage(fVar.getKey(), fVar.getMsg());
            }
        };
        M1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.share.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneSharePart.K9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L9() {
        com.tencent.mobileqq.sharepanel.f fVar;
        com.tencent.mobileqq.sharepanel.f fVar2;
        com.tencent.mobileqq.sharepanel.f fVar3;
        Activity activity = getActivity();
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity == null) {
            return;
        }
        i viewModel = this.mShareManager.getViewModel();
        com.qzone.reborn.share.d config = viewModel != null ? viewModel.getConfig() : null;
        if (config == null) {
            QLog.e(this.TAG, 1, "config is null ");
            return;
        }
        com.qzone.reborn.share.e G9 = G9();
        this.sharePanel = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(fragmentActivity, config.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String()).k0(new d(this, G9)).t0(new e(this, G9)).p0(new f(this, G9)).h0(new g(this, G9)).r0(new h(this, G9));
        if (config.getIsHideRecentContact() && (fVar3 = this.sharePanel) != null) {
            fVar3.s0();
        }
        if ((config.getTitle().length() > 0) && (fVar2 = this.sharePanel) != null) {
            fVar2.setTitle(config.getTitle());
        }
        if (config.getPreviewBitmap() != null && (fVar = this.sharePanel) != null) {
            Bitmap previewBitmap = config.getPreviewBitmap();
            Intrinsics.checkNotNull(previewBitmap);
            fVar.q0(previewBitmap);
        }
        initListener();
        com.tencent.mobileqq.sharepanel.f fVar4 = this.sharePanel;
        if (fVar4 != null) {
            fVar4.u0(false);
        }
        com.tencent.mobileqq.sharepanel.f fVar5 = this.sharePanel;
        if (fVar5 != null) {
            fVar5.m0(false);
        }
        this.mShareManager.o(this.sharePanel);
        this.mShareManager.t(G9);
        this.mShareManager.s(G9);
        this.mShareManager.r(G9);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.mShareManager.k(requestCode, resultCode, data);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        I9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        E9();
        this.mShareManager.n();
    }
}
