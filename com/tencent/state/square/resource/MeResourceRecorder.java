package com.tencent.state.square.resource;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.RecordSuccessListener;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.invite.ISquareInviteManager;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.state.square.resource.MeResourceRecorder;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.zplan.meme.model.MemeResult;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 52\u00020\u0001:\u000245B\u0005\u00a2\u0006\u0002\u0010\u0002J3\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\u000eH\u0002JD\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00182\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002J\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J6\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\fH\u0002J*\u0010$\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0006\u0010)\u001a\u00020\nJ*\u0010*\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J(\u0010+\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020 H\u0016J*\u0010-\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J.\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u001aJ&\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u001aH\u0002J2\u0010.\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00182\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u001aJ4\u0010.\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00052\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00182\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u001aR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/tencent/state/square/resource/MeResourceRecorder;", "Lcom/tencent/state/square/api/RecordSuccessListener;", "()V", "callbacks", "", "", "Lcom/tencent/state/square/resource/MeResourceRecorder$AvatarResourceCallback;", "isCallbackAdded", "Ljava/util/concurrent/atomic/AtomicBoolean;", "checkCanRecord", "", "isForceRecord", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "canRecord", "doStartRecord", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/resource/RecordRequest;", "sender", "Lcom/tencent/state/square/record/UserIdentifier;", "receivers", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/state/square/resource/IResourceCallback;", "forceStartRecord", "getCallbackKey", "actionId", "", IECDtReport.ACTION_IDENTIFIER, "Lcom/tencent/state/square/record/RecordIdentifier;", "type", "Lcom/tencent/state/square/record/RecordType;", "needUpload", "onCloudRecordSuccess", "recordIdentifier", "cover", "Lcom/tencent/state/square/data/RecordSource;", "mp4", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onLocalRecordSuccess", "onRecordError", "errorCode", "onUploadSuccess", "startRecord", "inviter", "Lcom/tencent/state/square/invite/ISquareInviteManager;", "resource", "Lcom/tencent/state/square/data/Resource;", "forceRecord", "AvatarResourceCallback", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MeResourceRecorder implements RecordSuccessListener {
    private static final String TAG = "MeResourceRecorder";
    private final Map<String, AvatarResourceCallback> callbacks = new LinkedHashMap();
    private AtomicBoolean isCallbackAdded = new AtomicBoolean(false);

    private final void checkCanRecord(boolean isForceRecord, Function1<? super Boolean, Unit> callback) {
        SquareBaseKt.getSquareLog().i(TAG, "checkCanRecord: isForceRecord=" + isForceRecord);
        if (isForceRecord) {
            callback.invoke(Boolean.TRUE);
        } else if (SquareSwitchUtils.INSTANCE.enableFilamentRecord()) {
            callback.invoke(Boolean.TRUE);
        } else {
            callback.invoke(Boolean.FALSE);
        }
    }

    private final String getCallbackKey(int actionId, String sender, List<UserIdentifier> receivers, RecordType type, boolean needUpload) {
        String joinToString$default;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(actionId);
        sb5.append(util.base64_pad_url);
        sb5.append(sender);
        sb5.append(util.base64_pad_url);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(receivers, "_", null, null, 0, null, new Function1<UserIdentifier, CharSequence>() { // from class: com.tencent.state.square.resource.MeResourceRecorder$getCallbackKey$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(UserIdentifier it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getUin();
            }
        }, 30, null);
        sb5.append(joinToString$default);
        sb5.append(util.base64_pad_url);
        sb5.append(type);
        sb5.append(util.base64_pad_url);
        sb5.append(needUpload);
        return sb5.toString();
    }

    public static /* synthetic */ void startRecord$default(MeResourceRecorder meResourceRecorder, ISquareInviteManager iSquareInviteManager, Resource resource, boolean z16, IResourceCallback iResourceCallback, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            iResourceCallback = null;
        }
        meResourceRecorder.startRecord(iSquareInviteManager, resource, z16, iResourceCallback);
    }

    public final void forceStartRecord(RecordRequest r85, IResourceCallback callback) {
        List<UserIdentifier> emptyList;
        Intrinsics.checkNotNullParameter(r85, "request");
        UserIdentifier userIdentifier = new UserIdentifier(RecordIdentifier.INSTANCE.getSelfUin(), Integer.valueOf(SquareRecordManager.INSTANCE.getGender()));
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        doStartRecord(r85, userIdentifier, emptyList, true, new WeakReference<>(callback));
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onCloudRecordSuccess(int actionId, RecordIdentifier recordIdentifier, RecordSource cover, RecordSource mp42) {
        Resource resource;
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(cover, "cover");
        if (mp42 == null) {
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "onCloudRecordSuccess: actionId=" + actionId + ", uin=" + recordIdentifier + ", mp4=" + mp42 + ", cover=" + cover);
        final AvatarResourceCallback avatarResourceCallback = this.callbacks.get(getCallbackKey(actionId, recordIdentifier));
        if (avatarResourceCallback == null || (resource = avatarResourceCallback.getRequest().getResource()) == null) {
            return;
        }
        resource.getDynamic().setMd5(mp42.getMd5());
        resource.getDynamic().setUrl(mp42.getPath());
        resource.getStatic().setMd5(cover.getMd5());
        resource.getStatic().setUrl(cover.getPath());
        resource.setDefault(false);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.resource.MeResourceRecorder$onCloudRecordSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IResourceCallback callback = MeResourceRecorder.AvatarResourceCallback.this.getCallback();
                if (callback != null) {
                    callback.onRecordSuccess(MeResourceRecorder.AvatarResourceCallback.this.getRequest());
                }
            }
        });
    }

    public final void onDestroy() {
        this.callbacks.clear();
        Square.INSTANCE.getConfig().getRecorder().removeRecordDoneCallback(this);
        this.isCallbackAdded.set(false);
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onLocalRecordSuccess(int actionId, RecordIdentifier recordIdentifier, RecordSource cover, RecordSource mp42) {
        Resource resource;
        File copyTo$default;
        File copyTo$default2;
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(cover, "cover");
        if (mp42 != null && recordIdentifier.getType() == RecordType.MP4_SQUARE) {
            SquareBaseKt.getSquareLog().i(TAG, "onLocalRecordSuccess: actionId=" + actionId + ", uin=" + recordIdentifier + ", mp4=" + mp42 + ", cover=" + cover);
            final AvatarResourceCallback avatarResourceCallback = this.callbacks.get(getCallbackKey(actionId, recordIdentifier));
            if (avatarResourceCallback == null || (resource = avatarResourceCallback.getRequest().getResource()) == null) {
                return;
            }
            resource.getDynamic().setMd5(mp42.getMd5());
            resource.getStatic().setMd5(cover.getMd5());
            resource.setDefault(false);
            String downloadFile = SquareItemKt.getDownloadFile(resource, 2);
            File file = new File(mp42.getPath());
            if ((!Intrinsics.areEqual(downloadFile, mp42.getPath())) && file.exists()) {
                copyTo$default2 = FilesKt__UtilsKt.copyTo$default(file, new File(downloadFile), true, 0, 4, null);
                SquareBaseKt.getSquareLog().i(TAG, "copy mp4 after target=" + copyTo$default2.getAbsolutePath() + ", exist=" + copyTo$default2.exists());
            }
            String downloadFile2 = SquareItemKt.getDownloadFile(resource, 1);
            File file2 = new File(cover.getPath());
            if ((!Intrinsics.areEqual(downloadFile2, cover.getPath())) && file2.exists()) {
                copyTo$default = FilesKt__UtilsKt.copyTo$default(file2, new File(downloadFile2), true, 0, 4, null);
                SquareBaseKt.getSquareLog().i(TAG, "copy cover after target=" + copyTo$default.getAbsolutePath() + ", exist=" + copyTo$default.exists());
            }
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.resource.MeResourceRecorder$onLocalRecordSuccess$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IResourceCallback callback = MeResourceRecorder.AvatarResourceCallback.this.getCallback();
                    if (callback != null) {
                        callback.onRecordSuccess(MeResourceRecorder.AvatarResourceCallback.this.getRequest());
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onRecordDone(boolean z16, MemeResult result, RecordIdentifier identifier) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        RecordSuccessListener.DefaultImpls.onRecordDone(this, z16, result, identifier);
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onRecordError(int actionId, final int type, final int errorCode, RecordIdentifier recordIdentifier) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        if (recordIdentifier.getType() != RecordType.MP4_SQUARE) {
            return;
        }
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "onRecordError: actionId=" + actionId + ", type=" + type + ", uin=" + recordIdentifier + ", error=" + errorCode, null, 4, null);
        String callbackKey = getCallbackKey(actionId, recordIdentifier);
        final AvatarResourceCallback avatarResourceCallback = this.callbacks.get(callbackKey);
        if (avatarResourceCallback != null) {
            this.callbacks.remove(callbackKey);
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.resource.MeResourceRecorder$onRecordError$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IResourceCallback callback = MeResourceRecorder.AvatarResourceCallback.this.getCallback();
                    if (callback != null) {
                        callback.onRecordError(type, MeResourceRecorder.AvatarResourceCallback.this.getRequest(), errorCode);
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onUploadSuccess(int actionId, RecordIdentifier recordIdentifier, RecordSource cover, RecordSource mp42) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(cover, "cover");
        if (mp42 != null && recordIdentifier.getType() == RecordType.MP4_SQUARE) {
            SquareBaseKt.getSquareLog().i(TAG, "onUploadSuccess: actionId=" + actionId + ", mp4=" + mp42 + ", cover=" + cover);
            String callbackKey = getCallbackKey(actionId, recordIdentifier);
            AvatarResourceCallback avatarResourceCallback = this.callbacks.get(callbackKey);
            if (avatarResourceCallback != null) {
                this.callbacks.remove(callbackKey);
                Resource resource = avatarResourceCallback.getRequest().getResource();
                if (resource != null) {
                    resource.getDynamic().setUrl(mp42.getPath());
                    resource.getDynamic().setMd5(mp42.getMd5());
                    resource.getStatic().setUrl(cover.getPath());
                    resource.getStatic().setMd5(cover.getMd5());
                }
            }
        }
    }

    public final void startRecord(ISquareInviteManager inviter, Resource resource, boolean forceRecord, IResourceCallback callback) {
        if (resource != null) {
            if (resource.getActionType() != 1) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "startRecord actionType != 1, " + resource.getActionId() + ", " + resource.getActionType(), null, 4, null);
            }
            if (forceRecord || resource.getIsDefault()) {
                startRecord(inviter, MeResourceRecorderKt.toRecordRequest$default(resource, null, 0, 3, null), callback);
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/resource/MeResourceRecorder$AvatarResourceCallback;", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/resource/RecordRequest;", "callback", "Lcom/tencent/state/square/resource/IResourceCallback;", "(Lcom/tencent/state/square/resource/RecordRequest;Lcom/tencent/state/square/resource/IResourceCallback;)V", "getCallback", "()Lcom/tencent/state/square/resource/IResourceCallback;", "getRequest", "()Lcom/tencent/state/square/resource/RecordRequest;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final /* data */ class AvatarResourceCallback {
        private final IResourceCallback callback;
        private final RecordRequest request;

        public AvatarResourceCallback(RecordRequest request, IResourceCallback iResourceCallback) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
            this.callback = iResourceCallback;
        }

        /* renamed from: component1, reason: from getter */
        public final RecordRequest getRequest() {
            return this.request;
        }

        /* renamed from: component2, reason: from getter */
        public final IResourceCallback getCallback() {
            return this.callback;
        }

        public final AvatarResourceCallback copy(RecordRequest r26, IResourceCallback callback) {
            Intrinsics.checkNotNullParameter(r26, "request");
            return new AvatarResourceCallback(r26, callback);
        }

        public final IResourceCallback getCallback() {
            return this.callback;
        }

        public final RecordRequest getRequest() {
            return this.request;
        }

        public int hashCode() {
            RecordRequest recordRequest = this.request;
            int hashCode = (recordRequest != null ? recordRequest.hashCode() : 0) * 31;
            IResourceCallback iResourceCallback = this.callback;
            return hashCode + (iResourceCallback != null ? iResourceCallback.hashCode() : 0);
        }

        public String toString() {
            return "AvatarResourceCallback(request=" + this.request + ", callback=" + this.callback + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarResourceCallback)) {
                return false;
            }
            AvatarResourceCallback avatarResourceCallback = (AvatarResourceCallback) other;
            return Intrinsics.areEqual(this.request, avatarResourceCallback.request) && Intrinsics.areEqual(this.callback, avatarResourceCallback.callback);
        }

        public static /* synthetic */ AvatarResourceCallback copy$default(AvatarResourceCallback avatarResourceCallback, RecordRequest recordRequest, IResourceCallback iResourceCallback, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                recordRequest = avatarResourceCallback.request;
            }
            if ((i3 & 2) != 0) {
                iResourceCallback = avatarResourceCallback.callback;
            }
            return avatarResourceCallback.copy(recordRequest, iResourceCallback);
        }
    }

    private final void doStartRecord(RecordRequest r142, UserIdentifier sender, List<UserIdentifier> receivers, boolean isForceRecord, WeakReference<IResourceCallback> callback) {
        SquareBaseKt.getSquareLog().i(TAG, "startRecord: sender=" + sender + ", receivers=" + receivers + ", " + r142.getResource());
        Resource resource = r142.getResource();
        if (resource != null) {
            this.callbacks.put(getCallbackKey(resource.getActionId(), sender.getUin(), receivers, RecordType.MP4_SQUARE, true), new AvatarResourceCallback(r142, callback != null ? callback.get() : null));
            if (this.isCallbackAdded.compareAndSet(false, true)) {
                Square.INSTANCE.getConfig().getRecorder().addRecordDoneCallback(this);
            }
            checkCanRecord(isForceRecord, new MeResourceRecorder$doStartRecord$1(resource, sender, receivers, r142, callback));
        }
    }

    private final String getCallbackKey(int actionId, RecordIdentifier r85) {
        String callbackKey;
        return (r85 == null || (callbackKey = getCallbackKey(actionId, r85.getSender(), r85.getReceivers(), r85.getType(), r85.getNeedUpload())) == null) ? "" : callbackKey;
    }

    static /* synthetic */ void startRecord$default(MeResourceRecorder meResourceRecorder, ISquareInviteManager iSquareInviteManager, RecordRequest recordRequest, IResourceCallback iResourceCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            iResourceCallback = null;
        }
        meResourceRecorder.startRecord(iSquareInviteManager, recordRequest, iResourceCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startRecord$default(MeResourceRecorder meResourceRecorder, RecordRequest recordRequest, String str, List list, IResourceCallback iResourceCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = RecordIdentifier.INSTANCE.getSelfUin();
        }
        if ((i3 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i3 & 8) != 0) {
            iResourceCallback = null;
        }
        meResourceRecorder.startRecord(recordRequest, str, (List<UserIdentifier>) list, iResourceCallback);
    }

    static /* synthetic */ void doStartRecord$default(MeResourceRecorder meResourceRecorder, RecordRequest recordRequest, UserIdentifier userIdentifier, List list, boolean z16, WeakReference weakReference, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = list;
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 16) != 0) {
            weakReference = null;
        }
        meResourceRecorder.doStartRecord(recordRequest, userIdentifier, list2, z17, weakReference);
    }

    public static /* synthetic */ void forceStartRecord$default(MeResourceRecorder meResourceRecorder, RecordRequest recordRequest, IResourceCallback iResourceCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            iResourceCallback = null;
        }
        meResourceRecorder.forceStartRecord(recordRequest, iResourceCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startRecord$default(MeResourceRecorder meResourceRecorder, RecordRequest recordRequest, UserIdentifier userIdentifier, List list, IResourceCallback iResourceCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i3 & 8) != 0) {
            iResourceCallback = null;
        }
        meResourceRecorder.startRecord(recordRequest, userIdentifier, (List<UserIdentifier>) list, iResourceCallback);
    }

    private final void startRecord(ISquareInviteManager inviter, final RecordRequest r122, final IResourceCallback callback) {
        final Resource resource = r122.getResource();
        if (resource != null) {
            if (resource.isSingleAction()) {
                SquareBaseKt.getSquareLog().w(TAG, "startRecord: single action, record directly.");
                startRecord$default(this, r122, (String) null, (List) null, callback, 6, (Object) null);
            } else if (inviter == null) {
                SquareBaseKt.getSquareLog().w(TAG, "startRecord: inviter is null, record directly.");
                startRecord$default(this, r122, (String) null, (List) null, callback, 6, (Object) null);
            } else {
                inviter.getInviteStatus(false, new ResultCallback<SquareMultiMotionDetailData>() { // from class: com.tencent.state.square.resource.MeResourceRecorder$startRecord$1
                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int i3, String str, String str2) {
                        ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int error, String message) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "MeResourceRecorder", "startRecord getInviteStatus error: " + error + ", msg: " + message, null, 4, null);
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultSuccess(SquareMultiMotionDetailData result) {
                        List<UserIdentifier> listOf;
                        Intrinsics.checkNotNullParameter(result, "result");
                        SquareBaseKt.getSquareLog().i("MeResourceRecorder", "startRecord getInviteStatus success: " + result);
                        if (resource.isMultiAction() && result.getResource().getActionId() == r122.getResource().getActionId() && result.isInviteSuccess()) {
                            Long successOtherUin = result.getSuccessOtherUin();
                            SquareBaseKt.getSquareLog().i("MeResourceRecorder", "startRecord multi action:" + resource + ", receiver=" + successOtherUin);
                            if (successOtherUin != null) {
                                listOf = CollectionsKt__CollectionsJVMKt.listOf(new UserIdentifier(String.valueOf(successOtherUin.longValue()), Integer.valueOf(result.getOtherGender())));
                                MeResourceRecorder.this.startRecord(r122, RecordIdentifier.INSTANCE.getSelfUin(), listOf, callback);
                            }
                        }
                    }
                });
            }
        }
    }

    public final void startRecord(RecordRequest r36, String sender, List<UserIdentifier> receivers, IResourceCallback callback) {
        Intrinsics.checkNotNullParameter(r36, "request");
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(receivers, "receivers");
        startRecord(r36, new UserIdentifier(sender, Intrinsics.areEqual(sender, RecordIdentifier.INSTANCE.getSelfUin()) ? Integer.valueOf(SquareRecordManager.INSTANCE.getGender()) : null), receivers, callback);
    }

    public final void startRecord(RecordRequest r85, UserIdentifier sender, List<UserIdentifier> receivers, IResourceCallback callback) {
        Intrinsics.checkNotNullParameter(r85, "request");
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(receivers, "receivers");
        doStartRecord(r85, sender, receivers, false, new WeakReference<>(callback));
    }
}
