package com.tencent.mobileqq.vas.social.hippy;

import android.app.Activity;
import android.content.Intent;
import android.util.Size;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.vas.message.SquareAioService;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.api.SquareMiniAioMultiSelectedRecord;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.media.MediaSource;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.MeResourceRecorder;
import com.tencent.state.square.resource.RecordRequest;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b%\u0010&J?\u0010\u0007\u001a\u00020\u00062.\u0010\u0005\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u0002\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u000bH\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012J \u0010\u001e\u001a\u00020\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/vas/social/hippy/SquareHippyManager;", "", "", "Lkotlin/Pair;", "", "keyValues", "Lcom/tencent/mtt/hippy/common/HippyMap;", "f", "([Lkotlin/Pair;)Lcom/tencent/mtt/hippy/common/HippyMap;", "T", "", "Lkotlin/Function1;", "transform", "Lcom/tencent/mtt/hippy/common/HippyArray;", "b", "", "g", "params", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "e", "Landroid/content/Intent;", "intent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "", "c", "Lcom/tencent/state/square/resource/MeResourceRecorder;", "a", "Lcom/tencent/state/square/resource/MeResourceRecorder;", "recorder", "Lcom/tencent/mtt/hippy/modules/Promise;", "friendSelectCallback", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SquareHippyManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private MeResourceRecorder recorder;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Promise friendSelectCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/vas/social/hippy/SquareHippyManager$b", "Lcom/tencent/state/square/resource/IResourceCallback;", "Lcom/tencent/state/square/data/Resource;", "resource", "", "isStarted", "", "onRecordStart", "Lcom/tencent/state/square/resource/RecordRequest;", Const.BUNDLE_KEY_REQUEST, "onRecordSuccess", "", "type", "errorCode", "onRecordError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IResourceCallback {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f310773e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Promise f310774f;

        b(int i3, Promise promise) {
            this.f310773e = i3;
            this.f310774f = promise;
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onFirstFrame() {
            IResourceCallback.DefaultImpls.onFirstFrame(this);
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onPlayEnd() {
            IResourceCallback.DefaultImpls.onPlayEnd(this);
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onPlayError(int i3) {
            IResourceCallback.DefaultImpls.onPlayError(this, i3);
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onPlayStart() {
            IResourceCallback.DefaultImpls.onPlayStart(this);
        }

        @Override // com.tencent.state.square.resource.IResourceCallback
        public void onRecordError(int type, RecordRequest request, int errorCode) {
            Intrinsics.checkNotNullParameter(request, "request");
            QLog.e("SquareHippyManager", 1, "onRecordError: type=" + type + ", errorCode=" + errorCode + ", request=" + request);
            this.f310774f.resolve(SquareHippyManager.this.f(TuplesKt.to("result", -1), TuplesKt.to("actionId", Integer.valueOf(this.f310773e)), TuplesKt.to("errorCode", Integer.valueOf(errorCode))));
        }

        @Override // com.tencent.state.square.resource.IResourceCallback
        public void onRecordStart(Resource resource, boolean isStarted) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            QLog.i("SquareHippyManager", 1, "onRecordStart: isStarted=" + isStarted + ", resource=" + resource);
        }

        @Override // com.tencent.state.square.resource.IResourceCallback
        public void onRecordSuccess(RecordRequest request) {
            MediaSource mediaSource;
            Intrinsics.checkNotNullParameter(request, "request");
            Resource resource = request.getResource();
            HippyMap f16 = SquareHippyManager.this.f(TuplesKt.to("result", 0), TuplesKt.to("actionId", Integer.valueOf(this.f310773e)), TuplesKt.to("path", "file://" + ((resource == null || (mediaSource = SquareItemKt.toMediaSource(resource)) == null) ? null : mediaSource.getCoverPath())));
            QLog.i("SquareHippyManager", 1, "onRecordSuccess: result=" + f16 + ", request=" + request);
            this.f310774f.resolve(f16);
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onRemovedListener() {
            IResourceCallback.DefaultImpls.onRemovedListener(this);
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onStaticFailed() {
            IResourceCallback.DefaultImpls.onStaticFailed(this);
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onStaticSuccess() {
            IResourceCallback.DefaultImpls.onStaticSuccess(this);
        }
    }

    private final <T> HippyArray b(Iterable<? extends T> iterable, Function1<? super T, ? extends HippyMap> function1) {
        HippyArray hippyArray = new HippyArray();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            hippyArray.pushMap(function1.invoke(it.next()));
        }
        return hippyArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HippyMap f(Pair<String, ? extends Object>... keyValues) {
        HippyMap hippyMap = new HippyMap();
        for (Pair<String, ? extends Object> pair : keyValues) {
            hippyMap.pushObject(pair.getFirst(), pair.getSecond());
        }
        return hippyMap;
    }

    public final void e(Activity activity, HippyMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i("SquareHippyManager", 1, "handleOpenFriendSelector: params=" + params);
        String string = params.getString("title");
        String str = string == null ? "" : string;
        boolean z16 = params.getInt("needTroop") != 0;
        String string2 = params.getString("troopTitle");
        String str2 = string2 == null ? "" : string2;
        String string3 = params.getString("finishText");
        String str3 = string3 != null ? string3 : "";
        String str4 = str3.length() == 0 ? "\u5b8c\u6210" : str3;
        boolean z17 = params.getInt("isMultiSelect") != 0;
        this.friendSelectCallback = promise;
        ForwardUtils.W(activity, 1001, str, str2, str4, z16, z17);
    }

    public final void g() {
        QLog.i("SquareHippyManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        MeResourceRecorder meResourceRecorder = this.recorder;
        if (meResourceRecorder != null) {
            meResourceRecorder.onDestroy();
        }
    }

    public final boolean c(Intent intent, int requestCode, int resultCode) {
        HippyMap f16;
        List<SquareMiniAioMultiSelectedRecord> listOf;
        if (requestCode != 1001) {
            return false;
        }
        Promise promise = this.friendSelectCallback;
        if (promise != null) {
            if (resultCode == -1 && intent != null) {
                SquareAioService squareAioService = new SquareAioService();
                if (!intent.hasExtra("selected_target_list")) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(squareAioService.pareSingleSelectUinInfo(intent));
                } else {
                    listOf = squareAioService.parseMultiSelectedUinInfo(intent);
                }
                f16 = f(TuplesKt.to("result", 0), TuplesKt.to("selected", b(listOf, new Function1<SquareMiniAioMultiSelectedRecord, HippyMap>() { // from class: com.tencent.mobileqq.vas.social.hippy.SquareHippyManager$doOnActivityResult$result$selected$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final HippyMap invoke(SquareMiniAioMultiSelectedRecord it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return SquareHippyManager.this.f(TuplesKt.to("type", Integer.valueOf(it.getType())), TuplesKt.to("uin", it.getUin()));
                    }
                })));
            } else {
                f16 = f(TuplesKt.to("result", -1));
            }
            QLog.i("SquareHippyManager", 1, "onFriendSelected: result=" + f16);
            promise.resolve(f16);
            this.friendSelectCallback = null;
        }
        return true;
    }

    public final void d(HippyMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i("SquareHippyManager", 1, "handleAvatarRecord: params=" + params);
        int i3 = params.getInt("actionId");
        int i16 = params.getInt("actionType");
        int i17 = params.getInt("recordWidth");
        int i18 = params.getInt("recordHeight");
        if (i3 != 0 && i17 > 0 && i18 > 0) {
            RecordRequest recordRequest = new RecordRequest(new Resource(i3, null, null, null, new Size(i17, i18), true, null, i16, 0, null, 846, null), null, 0, 6, null);
            if (this.recorder == null) {
                this.recorder = new MeResourceRecorder();
            }
            MeResourceRecorder meResourceRecorder = this.recorder;
            if (meResourceRecorder != null) {
                meResourceRecorder.forceStartRecord(recordRequest, new b(i3, promise));
                return;
            }
            return;
        }
        promise.resolve(f(TuplesKt.to("result", -2), TuplesKt.to("actionId", Integer.valueOf(i3))));
    }
}
