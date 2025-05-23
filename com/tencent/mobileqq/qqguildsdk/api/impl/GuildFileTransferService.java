package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.impl.GuildFileTransferService;
import com.tencent.mobileqq.qqguildsdk.internal.KLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateUploadFileGroupParam;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUploadFileGroupInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUploadFileInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateUploadFileGroupCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTransferFileOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0006\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001dB\u0019\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0013H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GuildFileTransferService;", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileUploadListener;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileTransferService;", "Luh2/h;", "listener", "com/tencent/mobileqq/qqguildsdk/api/impl/GuildFileTransferService$b", "Z0", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileUploadListener;)Lcom/tencent/mobileqq/qqguildsdk/api/impl/GuildFileTransferService$b;", "", "addFileUploadListener", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCreateUploadFileGroupParam;", "createParam", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProCreateUploadFileGroupCallback;", "callback", "createFileGroupUpload", "", "fileGroupId", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTransferFileOperateCallback;", "removeFileGroupUpload", "pauseFileGroupUpload", "resumeFileGroupUpload", "service", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "content", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileTransferService;Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GuildFileTransferService extends BaseService<IKernelGuildFileUploadListener, IKernelGuildFileTransferService> implements uh2.h {

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J0\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\t2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/qqguildsdk/api/impl/GuildFileTransferService$b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileUploadListener;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadFileInfo;", "file", "", "onFileUploadStatusChanged", "onFileCalcHashSuccess", "", "fileGroupId", "", "totalFileSize", "totalUploadSize", "onFileGroupUploadSizeChanged", "totalSpeed", "Ljava/util/HashMap;", "eachSpeed", "onFileGroupUploadSpeedChanged", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadFileGroupInfo;", "fileGroupInfo", "onFileGroupUploadStatusChanged", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements IKernelGuildFileUploadListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IKernelGuildFileUploadListener f265092b;

        b(IKernelGuildFileUploadListener iKernelGuildFileUploadListener) {
            this.f265092b = iKernelGuildFileUploadListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(IKernelGuildFileUploadListener listener, GProUploadFileInfo gProUploadFileInfo) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GuildFileTransferService", new Object[]{"onFileCalcHashSuccess"}, null, 4, null);
            listener.onFileCalcHashSuccess(gProUploadFileInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(IKernelGuildFileUploadListener listener, String str, long j3, long j16) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GuildFileTransferService", new Object[]{"onFileGroupUploadSizeChanged"}, null, 4, null);
            listener.onFileGroupUploadSizeChanged(str, j3, j16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(IKernelGuildFileUploadListener listener, String str, long j3, HashMap hashMap) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GuildFileTransferService", new Object[]{"onFileGroupUploadSpeedChanged"}, null, 4, null);
            listener.onFileGroupUploadSpeedChanged(str, j3, hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(IKernelGuildFileUploadListener listener, GProUploadFileGroupInfo gProUploadFileGroupInfo) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GuildFileTransferService", new Object[]{"onFileGroupUploadStatusChanged"}, null, 4, null);
            listener.onFileGroupUploadStatusChanged(gProUploadFileGroupInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(IKernelGuildFileUploadListener listener, GProUploadFileInfo gProUploadFileInfo) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GuildFileTransferService", new Object[]{"onFileUploadStatusChanged"}, null, 4, null);
            listener.onFileUploadStatusChanged(gProUploadFileInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener
        public void onFileCalcHashSuccess(@Nullable final GProUploadFileInfo file) {
            GuildFileTransferService guildFileTransferService = GuildFileTransferService.this;
            final IKernelGuildFileUploadListener iKernelGuildFileUploadListener = this.f265092b;
            guildFileTransferService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.dn
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFileTransferService.b.f(IKernelGuildFileUploadListener.this, file);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener
        public void onFileGroupUploadSizeChanged(@Nullable final String fileGroupId, final long totalFileSize, final long totalUploadSize) {
            GuildFileTransferService guildFileTransferService = GuildFileTransferService.this;
            final IKernelGuildFileUploadListener iKernelGuildFileUploadListener = this.f265092b;
            guildFileTransferService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.dk
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFileTransferService.b.g(IKernelGuildFileUploadListener.this, fileGroupId, totalFileSize, totalUploadSize);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener
        public void onFileGroupUploadSpeedChanged(@Nullable final String fileGroupId, final long totalSpeed, @Nullable final HashMap<String, Long> eachSpeed) {
            GuildFileTransferService guildFileTransferService = GuildFileTransferService.this;
            final IKernelGuildFileUploadListener iKernelGuildFileUploadListener = this.f265092b;
            guildFileTransferService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.dl
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFileTransferService.b.h(IKernelGuildFileUploadListener.this, fileGroupId, totalSpeed, eachSpeed);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener
        public void onFileGroupUploadStatusChanged(@Nullable final GProUploadFileGroupInfo fileGroupInfo) {
            GuildFileTransferService guildFileTransferService = GuildFileTransferService.this;
            final IKernelGuildFileUploadListener iKernelGuildFileUploadListener = this.f265092b;
            guildFileTransferService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.do
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFileTransferService.b.i(IKernelGuildFileUploadListener.this, fileGroupInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener
        public void onFileUploadStatusChanged(@Nullable final GProUploadFileInfo file) {
            GuildFileTransferService guildFileTransferService = GuildFileTransferService.this;
            final IKernelGuildFileUploadListener iKernelGuildFileUploadListener = this.f265092b;
            guildFileTransferService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.dm
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFileTransferService.b.j(IKernelGuildFileUploadListener.this, file);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFileTransferService(@Nullable IKernelGuildFileTransferService iKernelGuildFileTransferService, @NotNull ServiceContent content) {
        super("GuildFileTransferService", content, iKernelGuildFileTransferService);
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b Z0(IKernelGuildFileUploadListener listener) {
        return new b(listener);
    }

    @Override // uh2.h
    public void addFileUploadListener(@NotNull IKernelGuildFileUploadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        L0(listener, new Function1<IKernelGuildFileUploadListener, Long>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GuildFileTransferService$addFileUploadListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Long invoke(@NotNull IKernelGuildFileUploadListener it) {
                GuildFileTransferService.b Z0;
                Intrinsics.checkNotNullParameter(it, "it");
                IKernelGuildFileTransferService S0 = GuildFileTransferService.this.S0();
                if (S0 == null) {
                    return null;
                }
                Z0 = GuildFileTransferService.this.Z0(it);
                return Long.valueOf(S0.addFileUploadListener(Z0));
            }
        });
    }

    @Override // uh2.h
    public void c(@NotNull IKernelGuildFileUploadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        BaseService.X0(this, listener, false, new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GuildFileTransferService$removeFileUploadListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke(l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j3) {
                IKernelGuildFileTransferService S0 = GuildFileTransferService.this.S0();
                if (S0 != null) {
                    S0.removeFileUploadListener(j3);
                }
            }
        }, 2, null);
    }

    @Override // uh2.h
    public void createFileGroupUpload(@NotNull final GProCreateUploadFileGroupParam createParam, @NotNull final IGProCreateUploadFileGroupCallback callback) {
        Intrinsics.checkNotNullParameter(createParam, "createParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        P0("createFileGroupUploadInfo", new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GuildFileTransferService$createFileGroupUpload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                IGProCreateUploadFileGroupCallback.this.onCreateUploadFileGroupResult(i3, msg2, createParam.fileGroupInfo);
            }
        }, new GuildFileTransferService$createFileGroupUpload$2(createParam, this, callback));
    }

    @Override // uh2.h
    public void pauseFileGroupUpload(@NotNull String fileGroupId, @NotNull final IGProTransferFileOperateCallback callback) {
        Intrinsics.checkNotNullParameter(fileGroupId, "fileGroupId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        P0("pauseFileGroupUpload", new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GuildFileTransferService$pauseFileGroupUpload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                IGProTransferFileOperateCallback iGProTransferFileOperateCallback = IGProTransferFileOperateCallback.this;
                if (iGProTransferFileOperateCallback != null) {
                    iGProTransferFileOperateCallback.onResult(i3, msg2);
                }
            }
        }, new GuildFileTransferService$pauseFileGroupUpload$2(fileGroupId, this, callback));
    }

    @Override // uh2.h
    public void removeFileGroupUpload(@NotNull String fileGroupId, @NotNull final IGProTransferFileOperateCallback callback) {
        Intrinsics.checkNotNullParameter(fileGroupId, "fileGroupId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        P0("removeFileGroupUpload", new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GuildFileTransferService$removeFileGroupUpload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                IGProTransferFileOperateCallback iGProTransferFileOperateCallback = IGProTransferFileOperateCallback.this;
                if (iGProTransferFileOperateCallback != null) {
                    iGProTransferFileOperateCallback.onResult(i3, msg2);
                }
            }
        }, new GuildFileTransferService$removeFileGroupUpload$2(fileGroupId, this, callback));
    }

    @Override // uh2.h
    public void resumeFileGroupUpload(@NotNull String fileGroupId, @NotNull final IGProTransferFileOperateCallback callback) {
        Intrinsics.checkNotNullParameter(fileGroupId, "fileGroupId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        P0("resumeFileGroupUpload", new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GuildFileTransferService$resumeFileGroupUpload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                IGProTransferFileOperateCallback iGProTransferFileOperateCallback = IGProTransferFileOperateCallback.this;
                if (iGProTransferFileOperateCallback != null) {
                    iGProTransferFileOperateCallback.onResult(i3, msg2);
                }
            }
        }, new GuildFileTransferService$resumeFileGroupUpload$2(fileGroupId, this, callback));
    }
}
