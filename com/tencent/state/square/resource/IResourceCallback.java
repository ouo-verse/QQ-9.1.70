package com.tencent.state.square.resource;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.data.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/resource/IResourceCallback;", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "onRecordError", "", "type", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/resource/RecordRequest;", "errorCode", "onRecordStart", "resource", "Lcom/tencent/state/square/data/Resource;", "isStarted", "", "onRecordSuccess", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IResourceCallback extends IAvatarAnimListener {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static void onFirstFrame(IResourceCallback iResourceCallback) {
            IAvatarAnimListener.DefaultImpls.onFirstFrame(iResourceCallback);
        }

        public static void onPlayEnd(IResourceCallback iResourceCallback) {
            IAvatarAnimListener.DefaultImpls.onPlayEnd(iResourceCallback);
        }

        public static void onPlayError(IResourceCallback iResourceCallback, int i3) {
            IAvatarAnimListener.DefaultImpls.onPlayError(iResourceCallback, i3);
        }

        public static void onPlayStart(IResourceCallback iResourceCallback) {
            IAvatarAnimListener.DefaultImpls.onPlayStart(iResourceCallback);
        }

        public static void onRecordError(IResourceCallback iResourceCallback, int i3, RecordRequest request, int i16) {
            Intrinsics.checkNotNullParameter(request, "request");
        }

        public static void onRecordStart(IResourceCallback iResourceCallback, Resource resource, boolean z16) {
            Intrinsics.checkNotNullParameter(resource, "resource");
        }

        public static void onRecordSuccess(IResourceCallback iResourceCallback, RecordRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
        }

        public static void onRemovedListener(IResourceCallback iResourceCallback) {
            IAvatarAnimListener.DefaultImpls.onRemovedListener(iResourceCallback);
        }

        public static void onStaticFailed(IResourceCallback iResourceCallback) {
            IAvatarAnimListener.DefaultImpls.onStaticFailed(iResourceCallback);
        }

        public static void onStaticSuccess(IResourceCallback iResourceCallback) {
            IAvatarAnimListener.DefaultImpls.onStaticSuccess(iResourceCallback);
        }
    }

    void onRecordError(int type, RecordRequest request, int errorCode);

    void onRecordStart(Resource resource, boolean isStarted);

    void onRecordSuccess(RecordRequest request);
}
