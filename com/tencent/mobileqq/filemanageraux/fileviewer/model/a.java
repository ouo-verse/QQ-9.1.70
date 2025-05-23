package com.tencent.mobileqq.filemanageraux.fileviewer.model;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.gdtad.util.d;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.j;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0019B5\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/filemanageraux/fileviewer/model/a;", "Lcom/tencent/mobileqq/filemanager/fileviewer/model/C2CFileModel;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcc1/a;", "D", "", HippyTKDListViewAdapter.X, "E", "r", "w", "K", "", "Y0", "a0", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/app/Activity;", "ctx", "", "Lcom/tencent/mobileqq/filemanager/fileviewer/j;", "fileList", "index", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Ljava/util/List;I)V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends C2CFileModel {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/filemanageraux/fileviewer/model/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.filemanageraux.fileviewer.model.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/filemanageraux/fileviewer/model/a$b", "Lcc1/a;", "", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements cc1.a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/filemanageraux/fileviewer/model/a$b$a", "Lcom/tencent/mobileqq/filemanager/util/FMDialogUtil$c;", "", "b", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.filemanageraux.fileviewer.model.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C7593a implements FMDialogUtil.c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f209622a;

            C7593a(a aVar) {
                this.f209622a = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    if (((com.tencent.mobileqq.filemanager.fileviewer.model.b) this.f209622a).Q == null) {
                        return;
                    }
                    d.f109551a.h(((com.tencent.mobileqq.filemanager.fileviewer.model.b) this.f209622a).Q.getEntity());
                }
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // cc1.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                a aVar = a.this;
                aVar.Z0(false, kc1.a.c(((com.tencent.mobileqq.filemanager.fileviewer.model.b) aVar).Q.getEntity()), a.this.Q(), new C7593a(a.this));
            }
        }

        @Override // cc1.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                if (((com.tencent.mobileqq.filemanager.fileviewer.model.b) a.this).Q == null) {
                    return;
                }
                d.f109551a.g(((com.tencent.mobileqq.filemanager.fileviewer.model.b) a.this).Q.getEntity());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55114);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@Nullable QQAppInterface qQAppInterface, @Nullable Activity activity, @Nullable List<? extends j> list, int i3) {
        super(qQAppInterface, activity, list, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, activity, list, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AdFileModel<FileAssistant>", 1, "FileBrowserModel init: type = c2c");
        }
        l1(list, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (G() == 14) {
            return 3;
        }
        return super.A();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    @NotNull
    public cc1.a D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (cc1.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.C == null) {
            this.C = new b();
        }
        cc1.a mDownloadController = this.C;
        Intrinsics.checkNotNullExpressionValue(mDownloadController, "mDownloadController");
        return mDownloadController;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    @Nullable
    public String E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        FileManagerEntity entity = this.Q.getEntity();
        if (entity == null) {
            return null;
        }
        return entity.mExcitingSpeed;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    @NotNull
    public String K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        int V = V();
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null && V == 5) {
            String str = entity.yybApkIconUrl;
            Intrinsics.checkNotNullExpressionValue(str, "fileEntity.yybApkIconUrl");
            return str;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel, com.tencent.mobileqq.filemanager.fileviewer.model.b
    protected boolean Y0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    @NotNull
    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null) {
            String str = entity.yybApkPackageName;
            Intrinsics.checkNotNullExpressionValue(str, "fileEntity.yybApkPackageName");
            return str;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    @NotNull
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null) {
            String str = entity.yybApkName;
            Intrinsics.checkNotNullExpressionValue(str, "fileEntity.yybApkName");
            return str;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel, com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    @NotNull
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "biz_src_jc_file";
    }
}
