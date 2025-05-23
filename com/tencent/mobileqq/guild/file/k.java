package com.tencent.mobileqq.guild.file;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.guild.file.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.msg.api.IMsgService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u000f\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB/\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/file/k;", "Lcom/tencent/mobileqq/filemanager/fileviewer/model/b;", "", "l0", "B0", "Lcc1/d;", "g0", "Lcc1/a;", "D", "t1", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "Y", "()[Ljava/util/ArrayList;", "com/tencent/mobileqq/guild/file/k$d", "Z", "Lcom/tencent/mobileqq/guild/file/k$d;", "msgListener", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/app/Activity;", "ctx", "", "Lcom/tencent/mobileqq/filemanager/fileviewer/j;", "fileList", "", "index", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Ljava/util/List;I)V", "a0", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class k extends com.tencent.mobileqq.filemanager.fileviewer.model.b {

    /* renamed from: Z, reason: from kotlin metadata */
    private d msgListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/file/k$c", "Lcc1/d;", "", "e", "f", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements cc1.d {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/file/k$c$a", "Lcom/tencent/mobileqq/filemanager/util/FMDialogUtil$c;", "", "b", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes33.dex */
        public static final class a implements FMDialogUtil.c {
            a() {
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                QLog.i("NewGuildFileModel", 1, "getUploadController onYes. not implemented!");
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }

        c() {
        }

        @Override // cc1.d
        public void e() {
            k kVar = k.this;
            kVar.Z0(true, kc1.a.c(((com.tencent.mobileqq.filemanager.fileviewer.model.b) kVar).Q.getEntity()), k.this.Q(), new a());
        }

        @Override // cc1.d
        public void f() {
            QLog.i("NewGuildFileModel", 1, "getUploadController doPauseUpload. not implemented!");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(QQAppInterface app, Activity ctx, List<? extends com.tencent.mobileqq.filemanager.fileviewer.j> fileList, int i3) {
        super(app, ctx);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(fileList, "fileList");
        this.msgListener = new d();
        QLog.i("NewGuildFileModel", 1, "NewGuildFileModel init: type = GUILD");
        l1(fileList, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    protected void B0() {
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.removeMsgListener(this.msgListener);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public cc1.a D() {
        if (this.C == null) {
            this.C = new b();
        }
        cc1.a mDownloadController = this.C;
        Intrinsics.checkNotNullExpressionValue(mDownloadController, "mDownloadController");
        return mDownloadController;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] Y() {
        if (!TextUtils.isEmpty(this.Q.getFilePath()) && new File(this.Q.getFilePath()).exists()) {
            ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] Y = super.Y();
            Intrinsics.checkNotNullExpressionValue(Y, "super.getMenus()");
            return Y;
        }
        return new ArrayList[0];
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public cc1.d g0() {
        if (this.D == null) {
            this.D = new c();
        }
        cc1.d mUploadController = this.D;
        Intrinsics.checkNotNullExpressionValue(mUploadController, "mUploadController");
        return mUploadController;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void l0() {
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.addMsgListener(this.msgListener);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/file/k$d", "Lcom/tencent/qqnt/msg/i;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "onRichMediaProgerssUpdate", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d extends com.tencent.qqnt.msg.i {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(k this$0, FileTransNotifyInfo fileTransNotifyInfo) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FileBrowserModelBase.f fVar = ((FileBrowserModelBase) this$0).E;
            if (fVar != null) {
                fVar.f();
            }
            if (((com.tencent.mobileqq.filemanager.fileviewer.model.b) this$0).N == null || ((com.tencent.mobileqq.filemanager.fileviewer.model.b) this$0).N.getApplicationContext() == null || ((int) fileTransNotifyInfo.fileErrCode) != 0) {
                return;
            }
            QQToast.makeText(((com.tencent.mobileqq.filemanager.fileviewer.model.b) this$0).N.getApplicationContext(), R.string.f132573s, 1).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(k this$0, float f16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FileBrowserModelBase.f fVar = ((FileBrowserModelBase) this$0).E;
            if (fVar != null) {
                fVar.a(f16);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(final FileTransNotifyInfo notifyInfo) {
            if (notifyInfo == null || notifyInfo.msgElementId != ((com.tencent.mobileqq.filemanager.fileviewer.model.b) k.this).Q.getEntity().nSessionId) {
                return;
            }
            QLog.i("NewGuildFileModel", 1, "[onRichMediaDownloadComplete] elemId: " + ((com.tencent.mobileqq.filemanager.fileviewer.model.b) k.this).Q.getEntity().nSessionId);
            ((com.tencent.mobileqq.filemanager.fileviewer.model.b) k.this).Q.getEntity().setFilePath(notifyInfo.filePath);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final k kVar = k.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.file.m
                @Override // java.lang.Runnable
                public final void run() {
                    k.d.c(k.this, notifyInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaProgerssUpdate(FileTransNotifyInfo notifyInfo) {
            if (notifyInfo == null || notifyInfo.msgElementId != ((com.tencent.mobileqq.filemanager.fileviewer.model.b) k.this).Q.getEntity().nSessionId || ((com.tencent.mobileqq.filemanager.fileviewer.model.b) k.this).Q.getEntity().fileSize <= 0) {
                return;
            }
            final float f16 = ((float) notifyInfo.fileProgress) / ((float) ((com.tencent.mobileqq.filemanager.fileviewer.model.b) k.this).Q.getEntity().fileSize);
            if (QLog.isDevelopLevel()) {
                QLog.d("NewGuildFileModel", 4, "[onRichMediaProgerssUpdate] elemId: " + ((com.tencent.mobileqq.filemanager.fileviewer.model.b) k.this).Q.getEntity().nSessionId + ", progress: " + f16);
            }
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final k kVar = k.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.file.l
                @Override // java.lang.Runnable
                public final void run() {
                    k.d.d(k.this, f16);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/file/k$b", "Lcc1/a;", "", "a", "b", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements cc1.a {
        b() {
        }

        @Override // cc1.a
        public void a() {
            k kVar = k.this;
            kVar.Z0(false, kc1.a.c(((com.tencent.mobileqq.filemanager.fileviewer.model.b) kVar).Q.getEntity()), k.this.Q(), new a(k.this));
        }

        @Override // cc1.a
        public void b() {
            QLog.i("NewGuildFileModel", 1, "getDownloadController doPauseDownload.");
            ((IMsgService) QRoute.api(IMsgService.class)).cancelGetRichMediaElement(new RichMediaElementGetReq(((com.tencent.mobileqq.filemanager.fileviewer.model.b) k.this).Q.getEntity().msgUid, ((com.tencent.mobileqq.filemanager.fileviewer.model.b) k.this).Q.getEntity().channelId, 4, ((com.tencent.mobileqq.filemanager.fileviewer.model.b) k.this).Q.getEntity().nSessionId, 1, 0, "", 0L, 0, 0));
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/file/k$b$a", "Lcom/tencent/mobileqq/filemanager/util/FMDialogUtil$c;", "", "b", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes33.dex */
        public static final class a implements FMDialogUtil.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ k f224405a;

            a(k kVar) {
                this.f224405a = kVar;
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                this.f224405a.t1();
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }

    public void t1() {
        QLog.i("NewGuildFileModel", 1, "[startDownload] channelId: " + this.Q.getEntity().channelId + ", msgId: " + this.Q.getEntity().msgUid + ", elemId: " + this.Q.getEntity().nSessionId);
        ((IMsgService) QRoute.api(IMsgService.class)).getRichMediaElement(new RichMediaElementGetReq(this.Q.getEntity().msgUid, this.Q.getEntity().channelId, 4, this.Q.getEntity().nSessionId, 1, 0, "", 0L, 0, 0));
        FileBrowserModelBase.f fVar = this.E;
        if (fVar != null) {
            fVar.j();
        }
    }
}
