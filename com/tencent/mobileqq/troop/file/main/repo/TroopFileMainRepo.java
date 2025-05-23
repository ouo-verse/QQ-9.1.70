package com.tencent.mobileqq.troop.file.main.repo;

import androidx.collection.LruCache;
import com.tencent.biz.troop.file.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.q;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import ef0.k;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ks2.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010+\u001a\u00020(\u00a2\u0006\u0004\bA\u0010BJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tJ7\u0010\u0013\u001a\u00020\u00022!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011J\u0016\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J\u0014\u0010\u001a\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018J[\u0010\"\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2K\u0010\u0005\u001aG\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00020\u001dJ[\u0010#\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00142K\u0010\u0005\u001aG\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00020\u001dJN\u0010&\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u001426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00020%J\u0006\u0010'\u001a\u00020\u001eR\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R#\u00102\u001a\n -*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R#\u00107\u001a\n -*\u0004\u0018\u000103038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106R\u001b\u0010;\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010/\u001a\u0004\b9\u0010:R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010<R\u001c\u0010@\u001a\n -*\u0004\u0018\u00010=0=8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/repo/TroopFileMainRepo;", "", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/troop/data/q;", "observer", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "g", "", "l", "Lkotlin/Function1;", "Lks2/c;", "Lkotlin/ParameterName;", "name", "mode", "updateUsedSpaceModel", "Lkotlin/Function0;", "showFileTooMany", "p", "", "fileId", "targetFolderId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "filePathList", "t", "Lcom/tencent/mobileqq/troop/data/n;", "fileInfo", "Lkotlin/Function3;", "", "isSuccess", "", "errorCode", "f", "e", "parentId", "Lkotlin/Function2;", "r", "o", "Lks2/b;", "a", "Lks2/b;", "args", "Lcom/tencent/mobileqq/troop/utils/TroopFileManager;", "kotlin.jvm.PlatformType", "b", "Lkotlin/Lazy;", "j", "()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;", "troopFileMgr", "Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;", "c", "k", "()Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;", "troopFileTransMgr", "d", "i", "()Lks2/c;", "fileUsedSpaceModel", "Lcom/tencent/mobileqq/troop/data/q;", "Lcom/tencent/mobileqq/app/QQAppInterface;", h.F, "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "<init>", "(Lks2/b;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileMainRepo {

    /* renamed from: g, reason: collision with root package name */
    private static final LruCache<String, ks2.c> f295610g = new LruCache<>(16);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ks2.b args;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy troopFileMgr;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy troopFileTransMgr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy fileUsedSpaceModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private q observer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/file/main/repo/TroopFileMainRepo$b", "Lef0/b;", "", "isSuccess", "", "errorCode", "Lcom/tencent/mobileqq/troop/data/n;", "folderInfo", "", "c", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends ef0.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function3<Boolean, Integer, String, Unit> f295616d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TroopFileMainRepo f295617e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f295618f;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function3<? super Boolean, ? super Integer, ? super String, Unit> function3, TroopFileMainRepo troopFileMainRepo, String str) {
            this.f295616d = function3;
            this.f295617e = troopFileMainRepo;
            this.f295618f = str;
        }

        @Override // ef0.b
        protected void c(boolean isSuccess, int errorCode, n folderInfo) {
            QLog.i("TroopFile.Main.TroopFileMainRepo", 1, "createFolder, name:" + this.f295618f + ", errorCode:" + errorCode + ", folderInfo:" + folderInfo);
            Function3<Boolean, Integer, String, Unit> function3 = this.f295616d;
            Boolean valueOf = Boolean.valueOf(isSuccess);
            Integer valueOf2 = Integer.valueOf(errorCode);
            String str = folderInfo != null ? folderInfo.f294916b : null;
            if (str == null) {
                str = "";
            }
            function3.invoke(valueOf, valueOf2, str);
            if (isSuccess) {
                this.f295617e.j().h(folderInfo);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/file/main/repo/TroopFileMainRepo$c", "Lef0/d;", "", "isSuccess", "", "errorCode", "", "c", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends ef0.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function3<Boolean, Integer, String, Unit> f295619d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ n f295620e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TroopFileMainRepo f295621f;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function3<? super Boolean, ? super Integer, ? super String, Unit> function3, n nVar, TroopFileMainRepo troopFileMainRepo) {
            this.f295619d = function3;
            this.f295620e = nVar;
            this.f295621f = troopFileMainRepo;
        }

        @Override // ef0.d
        protected void c(boolean isSuccess, int errorCode) {
            QLog.i("TroopFile.Main.TroopFileMainRepo", 1, "deleteFolder, errorCode:" + errorCode + ", fileInfo:" + this.f295620e);
            Function3<Boolean, Integer, String, Unit> function3 = this.f295619d;
            Boolean valueOf = Boolean.valueOf(isSuccess);
            Integer valueOf2 = Integer.valueOf(errorCode);
            String str = this.f295620e.f294916b;
            Intrinsics.checkNotNullExpressionValue(str, "fileInfo.mFileId");
            function3.invoke(valueOf, valueOf2, str);
            if (isSuccess) {
                this.f295621f.j().v(this.f295620e);
            } else if (errorCode == -136) {
                this.f295621f.j().v(this.f295620e);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/file/main/repo/TroopFileMainRepo$d", "Lef0/e;", "", "isSuccess", "fileTooMany", "", "allFileCount", "limitCount", "errorCode", "", "c", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends ef0.e {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<ks2.c, Unit> f295623e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f295624f;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super ks2.c, Unit> function1, Function0<Unit> function0) {
            this.f295623e = function1;
            this.f295624f = function0;
        }

        @Override // ef0.e
        public void c(boolean isSuccess, boolean fileTooMany, int allFileCount, int limitCount, int errorCode) {
            QLog.i("TroopFile.Main.TroopFileMainRepo", 1, "getFileCount, errorCode:" + errorCode + ", fileTooMany:" + fileTooMany + "-" + allFileCount);
            if (isSuccess) {
                TroopFileMainRepo.this.i().com.tencent.mm.vfs.QuotaFileSystem.STAT_FILE_COUNT java.lang.String = allFileCount;
                Function1<ks2.c, Unit> function1 = this.f295623e;
                ks2.c fileUsedSpaceModel = TroopFileMainRepo.this.i();
                Intrinsics.checkNotNullExpressionValue(fileUsedSpaceModel, "fileUsedSpaceModel");
                function1.invoke(fileUsedSpaceModel);
                if (fileTooMany) {
                    this.f295624f.invoke();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/file/main/repo/TroopFileMainRepo$e", "Lef0/h;", "", "isSuccess", "", "totalSpace", "usedSpace", "", "errorCode", "", "c", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e extends ef0.h {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<ks2.c, Unit> f295626e;

        /* JADX WARN: Multi-variable type inference failed */
        e(Function1<? super ks2.c, Unit> function1) {
            this.f295626e = function1;
        }

        @Override // ef0.h
        public void c(boolean isSuccess, long totalSpace, long usedSpace, int errorCode) {
            QLog.i("TroopFile.Main.TroopFileMainRepo", 1, "getFileSpace, errorCode:" + errorCode + ", " + totalSpace + "-" + usedSpace);
            if (isSuccess) {
                TroopFileMainRepo.this.i().fileTotalSpace = totalSpace;
                TroopFileMainRepo.this.i().fileUsedSpace = usedSpace;
                Function1<ks2.c, Unit> function1 = this.f295626e;
                ks2.c fileUsedSpaceModel = TroopFileMainRepo.this.i();
                Intrinsics.checkNotNullExpressionValue(fileUsedSpaceModel, "fileUsedSpaceModel");
                function1.invoke(fileUsedSpaceModel);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/file/main/repo/TroopFileMainRepo$f", "Lef0/k;", "", "isSuccess", "", "errorCode", "", "folderId", "newFolderName", "", "c", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f extends k {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, Integer, Unit> f295627d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TroopFileMainRepo f295628e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f295629f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f295630h;

        /* JADX WARN: Multi-variable type inference failed */
        f(Function2<? super Boolean, ? super Integer, Unit> function2, TroopFileMainRepo troopFileMainRepo, String str, String str2) {
            this.f295627d = function2;
            this.f295628e = troopFileMainRepo;
            this.f295629f = str;
            this.f295630h = str2;
        }

        @Override // ef0.k
        protected void c(boolean isSuccess, int errorCode, String folderId, String newFolderName) {
            n nVar;
            Intrinsics.checkNotNullParameter(folderId, "folderId");
            QLog.i("TroopFile.Main.TroopFileMainRepo", 1, "renameFolder, parentId:" + this.f295629f + ", name:" + this.f295630h + ", errorCode:" + errorCode + ", folderId:" + folderId);
            this.f295627d.invoke(Boolean.valueOf(isSuccess), Integer.valueOf(errorCode));
            if (!isSuccess || (nVar = this.f295628e.j().f301893e.get(folderId)) == null) {
                return;
            }
            nVar.f294917c = newFolderName;
            TroopFileManager.e eVar = this.f295628e.j().f301895g.get(nVar.f294929o);
            if (eVar == null) {
                return;
            }
            eVar.f301923f = null;
        }
    }

    public TroopFileMainRepo(ks2.b args) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(args, "args");
        this.args = args;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopFileManager>() { // from class: com.tencent.mobileqq.troop.file.main.repo.TroopFileMainRepo$troopFileMgr$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopFileManager invoke() {
                return TroopFileManager.F(TroopFileMainRepo.this.h(), TroopFileMainRepo.this.args.troopUinL);
            }
        });
        this.troopFileMgr = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TroopFileTransferManager>() { // from class: com.tencent.mobileqq.troop.file.main.repo.TroopFileMainRepo$troopFileTransMgr$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopFileTransferManager invoke() {
                return TroopFileTransferManager.O(TroopFileMainRepo.this.h(), TroopFileMainRepo.this.args.troopUinL);
            }
        });
        this.troopFileTransMgr = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ks2.c>() { // from class: com.tencent.mobileqq.troop.file.main.repo.TroopFileMainRepo$fileUsedSpaceModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                LruCache lruCache;
                LruCache lruCache2;
                lruCache = TroopFileMainRepo.f295610g;
                c cVar = (c) lruCache.get(TroopFileMainRepo.this.args.troopUinStr);
                if (cVar != null) {
                    return cVar;
                }
                c cVar2 = new c(0, 0L, 0L, 7, null);
                TroopFileMainRepo troopFileMainRepo = TroopFileMainRepo.this;
                lruCache2 = TroopFileMainRepo.f295610g;
                lruCache2.put(troopFileMainRepo.args.troopUinStr, cVar2);
                return cVar2;
            }
        });
        this.fileUsedSpaceModel = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQAppInterface h() {
        return TroopUtils.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopFileManager j() {
        return (TroopFileManager) this.troopFileMgr.getValue();
    }

    private final TroopFileTransferManager k() {
        return (TroopFileTransferManager) this.troopFileTransMgr.getValue();
    }

    public final void e(String name, Function3<? super Boolean, ? super Integer, ? super String, Unit> observer) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(observer, "observer");
        a.b(h(), this.args.troopUinL, "/", name, new b(observer, this, name));
    }

    public final void f(n fileInfo, Function3<? super Boolean, ? super Integer, ? super String, Unit> observer) {
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        Intrinsics.checkNotNullParameter(observer, "observer");
        a.d(h(), this.args.troopUinL, fileInfo.f294916b, new c(observer, fileInfo, this));
    }

    public final ks2.c i() {
        return (ks2.c) this.fileUsedSpaceModel.getValue();
    }

    public final int[] l() {
        int[] R = k().R();
        Intrinsics.checkNotNullExpressionValue(R, "troopFileTransMgr.uploadingFileInfoCount");
        return R;
    }

    public final void m(String fileId, String targetFolderId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(targetFolderId, "targetFolderId");
        n nVar = j().f301893e.get(fileId);
        if (nVar != null && nVar.f294916b.equals(fileId)) {
            j().i(nVar);
            j().l(nVar, targetFolderId);
            nVar.f294929o = targetFolderId;
            TroopFileTransferManager.Item J = k().J(nVar.f294915a);
            if (J != null) {
                J.mParentId = targetFolderId;
                k().i0(J);
            }
        }
    }

    public final boolean o() {
        return i().fileUsedSpace >= i().fileTotalSpace;
    }

    public final void p(Function1<? super ks2.c, Unit> updateUsedSpaceModel, Function0<Unit> showFileTooMany) {
        Intrinsics.checkNotNullParameter(updateUsedSpaceModel, "updateUsedSpaceModel");
        Intrinsics.checkNotNullParameter(showFileTooMany, "showFileTooMany");
        a.e(h(), this.args.troopUinL, new d(updateUsedSpaceModel, showFileTooMany));
        a.i(h(), this.args.troopUinL, new e(updateUsedSpaceModel));
    }

    public final void q(q observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!j().q(observer)) {
            j().registerObserver(observer);
        }
        this.observer = observer;
    }

    public final void r(String parentId, String name, Function2<? super Boolean, ? super Integer, Unit> observer) {
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(observer, "observer");
        a.n(h(), this.args.troopUinL, parentId, name, new f(observer, this, parentId, name));
    }

    public final void s() {
        j().f301899k = this.args.folderId;
    }

    public final void t(ArrayList<String> filePathList) {
        Intrinsics.checkNotNullParameter(filePathList, "filePathList");
        k().B0(filePathList, false);
    }

    public final void g() {
        QLog.i("TroopFile.Main.TroopFileMainRepo", 1, "destroy.");
        if (this.args.from == 2000) {
            j().p();
        }
        q qVar = this.observer;
        if (qVar != null) {
            j().unregisterObserver(qVar);
        }
        this.observer = null;
    }

    public final void n() {
        if (this.args.troopUinL != 0 && h() != null) {
            j().f301899k = this.args.folderId;
            TroopFileManager j3 = j();
            ks2.b bVar = this.args;
            j3.P(0, bVar.folderId, bVar.filterUin, null);
            int C = j().C();
            QLog.i("TroopFile.Main.TroopFileMainRepo", 1, "troopUin:" + this.args.troopUinStr + ", fileSum:" + C);
            QQAppInterface h16 = h();
            String str = this.args.troopUinStr;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(C);
            ReportController.o(h16, "CliOper", "", "", "Grp", "in_fileslist", 0, 0, "", str, sb5.toString(), "");
            return;
        }
        QLog.e("TroopFile.Main.TroopFileMainRepo", 1, "init error, troopUin:" + this.args.troopUinL + ", app:" + h());
        if (!AppSetting.isPublicVersion()) {
            throw new IllegalArgumentException("troopFileMainArgs invalid.");
        }
    }
}
