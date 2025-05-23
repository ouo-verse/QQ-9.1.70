package com.tencent.mobileqq.tbstool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.ValueCallback;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.tencent.biz.qui.toast.QUIBottomToast;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.ITBSToolService;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.s;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.perf.report.PerfFeature;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.tbs.reader.TbsReaderView;
import com.tencent.tbs.reader.tool.ITbsToolHost;
import com.tencent.tbs.reader.tool.TbsToolEntrance;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b<\u0010=J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J*\u0010\u0017\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u0001J\u001d\u0010$\u001a\u00020\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u00a2\u0006\u0004\b$\u0010%J.\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020(2\u0006\u0010\b\u001a\u00020&2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00160'J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001JB\u0010-\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010'J\u0018\u0010.\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010/\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0005J\u0018\u00101\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u00100\u001a\u00020\u0005J\u0010\u00103\u001a\u00020\u00162\b\u00102\u001a\u0004\u0018\u00010\u0001J\u0018\u00104\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001J\u0018\u00107\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u000105J\u001a\u00108\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001J\u0010\u00109\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u0001J\u0006\u0010:\u001a\u00020\u0016J\b\u0010;\u001a\u0004\u0018\u00010\u0007\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/tbstool/TBSToolClientUtils;", "", "Landroid/content/Intent;", "data", "", "", "w", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "k", "tempFile", "srcFileName", "o", WadlProxyConsts.PARAM_FILENAME, "v", "callback", "", "isSaveNew", "savedFilePath", "", "sessionId", "", "l", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "u", "originEntity", "saveFilePath", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lmqq/app/AppRuntime;", "ar", "path", "p", "args", "I", "fileList", ReportConstant.COSTREPORT_PREFIX, "(Ljava/util/List;)V", "Landroidx/activity/ComponentActivity;", "Lkotlin/Function1;", "Landroidx/activity/result/ActivityResultLauncher;", "E", "J", "tempFilePath", "newSaveCallback", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "action", "y", "param", "B", "D", "Lcom/tencent/tbs/reader/TbsReaderView;", "tbsView", HippyTKDListViewAdapter.X, "t", BdhLogUtil.LogTag.Tag_Conn, DomainData.DOMAIN_NAME, "L", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TBSToolClientUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TBSToolClientUtils f291401a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/tbstool/TBSToolClientUtils$a", "Landroid/webkit/ValueCallback;", "", "value", "", "a", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements ValueCallback<Boolean> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<Activity> f291402a;

        a(WeakReference<Activity> weakReference) {
            this.f291402a = weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
            }
        }

        public void a(boolean value) {
            Activity activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, value);
            } else {
                if (value || (activity = this.f291402a.get()) == null) {
                    return;
                }
                activity.finish();
            }
        }

        @Override // android.webkit.ValueCallback
        public /* bridge */ /* synthetic */ void onReceiveValue(Boolean bool) {
            a(bool.booleanValue());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22845);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            f291401a = new TBSToolClientUtils();
        }
    }

    TBSToolClientUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void A(TBSToolClientUtils tBSToolClientUtils, long j3, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        tBSToolClientUtils.y(j3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 callback, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        List<String> w3 = f291401a.w(activityResult.getData());
        QLog.d("TBSToolClientFileUtils", 1, "btn_choose_album_photo pathList: " + w3);
        callback.invoke(w3);
    }

    public static /* synthetic */ void H(TBSToolClientUtils tBSToolClientUtils, long j3, String str, String str2, Object obj, Function1 function1, int i3, Object obj2) {
        Object obj3;
        Function1 function12;
        if ((i3 & 8) != 0) {
            obj3 = null;
        } else {
            obj3 = obj;
        }
        if ((i3 & 16) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        tBSToolClientUtils.G(j3, str, str2, obj3, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Object obj, String scene, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(scene, "$scene");
        if (obj instanceof Runnable) {
            ((Runnable) obj).run();
            c.f291412a.a(scene);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k(Activity activity) {
        int height = activity.getWindow().getDecorView().getHeight();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int statusBarHeight = (height - ImmersiveUtils.getStatusBarHeight(activity)) - displayMetrics.heightPixels;
        int c16 = com.tencent.biz.qui.quicommon.e.c(81.0f);
        if (statusBarHeight > 0) {
            return c16;
        }
        return c16 - com.tencent.biz.qui.quicommon.e.e(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Object callback, boolean isSaveNew, String savedFilePath, long sessionId) {
        if (callback instanceof ValueCallback) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("saveAsNewFile", isSaveNew);
            bundle.putString("filePath", savedFilePath);
            bundle.putLong("fileId", sessionId);
            QLog.d("TBSToolClientFileUtils", 1, "callbackSaveResult : " + bundle);
            ((ValueCallback) callback).onReceiveValue(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o(String tempFile, String srcFileName) {
        int lastIndexOf$default;
        if (!TextUtils.isEmpty(tempFile) && !TextUtils.isEmpty(srcFileName)) {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) srcFileName, ".", 0, false, 6, (Object) null);
            String n06 = ah.n0(tempFile);
            Intrinsics.checkNotNullExpressionValue(n06, "getFileSuffix(tempFile)");
            String lowerCase = n06.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            String substring = srcFileName.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring + "." + lowerCase;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileManagerEntity p(AppRuntime ar3, String path) {
        FileManagerEntity k16 = ah.k1(new FileInfo(path));
        k16.isDuplicateFile = true;
        k16.setCloudType(15);
        k16.srvTime = NetConnInfoCenter.getServerTimeMillis();
        k16.msgSeq = ah.P();
        k16.msgUid = ah.Q();
        k16.isReaded = true;
        k16.peerUid = ar3.getCurrentAccountUin();
        k16.peerType = 0;
        k16.status = 1;
        k16.nOpType = 56;
        k16.bSend = false;
        Intrinsics.checkNotNullExpressionValue(k16, "newEntityByLocalFileInfo\u2026end = false\n            }");
        return k16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileManagerEntity q(FileManagerEntity originEntity, String saveFilePath) {
        FileInfo fileInfo = new FileInfo(saveFilePath);
        final FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.copyFrom(originEntity);
        Long R = ah.R();
        Intrinsics.checkNotNullExpressionValue(R, "genSessionId()");
        fileManagerEntity.nSessionId = R.longValue();
        fileManagerEntity.uniseq = 0L;
        fileManagerEntity.msgSeq = ah.P();
        fileManagerEntity.msgUid = ah.Q();
        fileManagerEntity.isDuplicateFile = true;
        fileManagerEntity.setCloudType(15);
        fileManagerEntity.srvTime = NetConnInfoCenter.getServerTimeMillis();
        fileManagerEntity.isReaded = true;
        fileManagerEntity.status = 1;
        fileManagerEntity.nOpType = 56;
        fileManagerEntity.bSend = false;
        fileManagerEntity.fileName = fileInfo.j();
        fileManagerEntity.setFilePath(fileInfo.k());
        fileManagerEntity.fileSize = fileInfo.l();
        if (fileInfo.getType() == 5) {
            fileManagerEntity.nFileType = 5;
            ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(fileInfo.k(), new s() { // from class: com.tencent.mobileqq.tbstool.f
                @Override // com.tencent.mobileqq.filemanager.util.s
                public final void a(String str, String str2) {
                    TBSToolClientUtils.r(FileManagerEntity.this, str, str2);
                }
            });
        } else {
            fileManagerEntity.nFileType = ah.o0(fileInfo.j());
        }
        return fileManagerEntity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(FileManagerEntity this_apply, String str, String str2) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.fileName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileManagerEntity u(long sessionId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        EntityManager createEntityManager = peekAppRuntime.getEntityManagerFactory().createEntityManager();
        Entity find = DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) FileManagerEntity.class, String.valueOf(sessionId));
        if (!(find instanceof FileManagerEntity)) {
            return null;
        }
        FileManagerEntity fileManagerEntity = (FileManagerEntity) find;
        if (fileManagerEntity.isDuplicateFile) {
            return null;
        }
        long j3 = fileManagerEntity.duplicateEntitySessionId;
        if (j3 <= 0) {
            return null;
        }
        Entity find2 = DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) FileManagerEntity.class, String.valueOf(j3));
        if (!(find2 instanceof FileManagerEntity)) {
            return null;
        }
        return (FileManagerEntity) find2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String v(String fileName) {
        int lastIndexOf$default;
        int i3 = 1;
        while (true) {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) fileName, ".", 0, false, 6, (Object) null);
            String substring = fileName.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring2 = fileName.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            String str = substring + ("(" + i3 + ")") + substring2;
            String str2 = AppConstants.SDCARD_FILE_SAVE_TBS_TOOL + str;
            if (!new File(str2).exists()) {
                return str2;
            }
            i3++;
        }
    }

    private final List<String> w(Intent data) {
        boolean z16;
        int collectionSizeOrDefault;
        if (data == null) {
            return new ArrayList();
        }
        AlbumResult albumResult = (AlbumResult) data.getParcelableExtra("ALBUM_RESULT");
        if (albumResult == null) {
            QLog.i("TBSToolClientFileUtils", 1, "handleSelectPicResult AlbumResult is null.");
            return new ArrayList();
        }
        List<LocalMediaInfo> e16 = albumResult.e();
        List<LocalMediaInfo> list = e16;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.i("TBSToolClientFileUtils", 1, "[onSelectPicResult]selectInfo is null or empty.");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : e16) {
            if (!TextUtils.isEmpty(((LocalMediaInfo) obj).getPath())) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String path = ((LocalMediaInfo) it.next()).getPath();
            Intrinsics.checkNotNull(path);
            arrayList2.add(path);
        }
        return new ArrayList(arrayList2);
    }

    public final void B(@Nullable Object param) {
        int i3;
        ArrayList arrayList;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, param);
            return;
        }
        boolean z17 = true;
        QLog.d("TBSToolClientFileUtils", 1, "openTBSFile param: " + param);
        if (!(param instanceof Bundle)) {
            return;
        }
        Bundle bundle = (Bundle) param;
        String[] stringArray = bundle.getStringArray("filePath");
        if (stringArray != null) {
            i3 = stringArray.length;
        } else {
            i3 = 0;
        }
        if (i3 > 1) {
            Activity L = L();
            if (L == null) {
                return;
            }
            ITBSToolService iTBSToolService = (ITBSToolService) QRoute.api(ITBSToolService.class);
            Intrinsics.checkNotNull(stringArray);
            iTBSToolService.browserMedia(L, stringArray);
            return;
        }
        String[] stringArray2 = bundle.getStringArray("fileId");
        if (stringArray2 != null) {
            ArrayList arrayList2 = new ArrayList(stringArray2.length);
            int length = stringArray2.length;
            int i16 = 0;
            while (true) {
                long j3 = 0;
                if (i16 >= length) {
                    break;
                }
                String it = stringArray2[i16];
                try {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    j3 = Long.parseLong(it);
                } catch (Throwable unused) {
                }
                arrayList2.add(Long.valueOf(j3));
                i16++;
            }
            arrayList = new ArrayList();
            for (Object obj : arrayList2) {
                if (((Number) obj).longValue() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null || !(!arrayList.isEmpty())) {
            z17 = false;
        }
        if (!z17) {
            return;
        }
        String action = bundle.getString("action", "");
        long longValue = ((Number) arrayList.get(0)).longValue();
        Intrinsics.checkNotNullExpressionValue(action, "action");
        y(longValue, action);
    }

    public final void C(@Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, args);
            return;
        }
        if (!(args instanceof Bundle)) {
            QLog.d("TBSToolClientFileUtils", 1, "openTXDocApplets args illegal not bundle");
            return;
        }
        Activity L = L();
        if (L == null) {
            QLog.d("TBSToolClientFileUtils", 1, "openTXDocApplets topActivity null");
            return;
        }
        String string = ((Bundle) args).getString("filePath", "");
        if (TextUtils.isEmpty(string)) {
            QLog.d("TBSToolClientFileUtils", 1, "openTXDocApplets empty file path");
        } else {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppByIdWithFile(L, ITeamWorkUtils.TENCENT_DOC_MIMI_APPID, "pages/importFileMaterial/importFileMaterial", "", 1173, new File(string));
        }
    }

    public final void D(@NotNull Activity activity, @Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity, args);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!(args instanceof Bundle)) {
            QLog.d("TBSToolClientFileUtils", 1, "openWebPage illegal args: " + args);
            return;
        }
        String string = ((Bundle) args).getString("url");
        if (TextUtils.isEmpty(string)) {
            QLog.d("TBSToolClientFileUtils", 1, "openWebPage empty url: " + args);
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", string);
        activity.startActivity(intent);
    }

    @NotNull
    public final ActivityResultLauncher<Intent> E(@NotNull ComponentActivity activity, @NotNull final Function1<? super List<String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ActivityResultLauncher) iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) callback);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("TBSToolClientFileUtils", 1, "btn_choose_album_photo currentState: " + activity.getLifecycle().getCurrentState());
        ActivityResultLauncher<Intent> registerForActivityResult = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.tencent.mobileqq.tbstool.e
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                TBSToolClientUtils.F(Function1.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "activity.registerForActi\u2026k(pathList)\n            }");
        return registerForActivityResult;
    }

    public final void G(long sessionId, @NotNull String tempFilePath, @NotNull String srcFileName, @Nullable Object callback, @Nullable Function1<? super FileManagerEntity, Unit> newSaveCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(sessionId), tempFilePath, srcFileName, callback, newSaveCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(tempFilePath, "tempFilePath");
        Intrinsics.checkNotNullParameter(srcFileName, "srcFileName");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(i.b(96)), null, null, new TBSToolClientUtils$saveFile$1(sessionId, tempFilePath, srcFileName, callback, newSaveCallback, null), 3, null);
    }

    public final void I(@Nullable Object args) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, args);
            return;
        }
        if (!(args instanceof Bundle)) {
            return;
        }
        String string = ((Bundle) args).getString("filePath", "");
        if (!TextUtils.isEmpty(string)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(string);
            s(arrayListOf);
        } else {
            QLog.d("TBSToolClientFileUtils", 1, "shareFileFromTBS empty file path");
        }
    }

    public final void J(@NotNull Activity activity, @Nullable Object args) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, args);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (args instanceof Map) {
            Map map = (Map) args;
            Integer num = (Integer) map.get("level");
            String str = (String) map.get("text");
            String str2 = (String) map.get("actionText");
            final String str3 = (String) map.get("scene");
            if (str3 == null) {
                str3 = "";
            }
            if (num != null && num.intValue() == 0) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            if (TextUtils.isEmpty(str2)) {
                c.f291412a.b(str3);
                QQToast.makeText(activity, i3, str, 1).show();
            } else {
                final Object obj = map.get("action");
                QUIBottomToast.INSTANCE.a(activity, i3, str, str2, new View.OnClickListener() { // from class: com.tencent.mobileqq.tbstool.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TBSToolClientUtils.K(obj, str3, view);
                    }
                }, k(activity)).n();
                c.f291412a.b(str3);
            }
        }
    }

    @Nullable
    public final Activity L() {
        WeakReference<Activity> e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Activity) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            return qBaseActivity;
        }
        ITbsToolHost toolHost = TbsToolEntrance.getInstance().getToolHost();
        if (!(toolHost instanceof TBSToolInjector) || (e16 = ((TBSToolInjector) toolHost).e()) == null) {
            return null;
        }
        return e16.get();
    }

    public final void m(@Nullable Activity activity, long sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(i.b(32)), null, null, new TBSToolClientUtils$checkNewestCopyFile$1(sessionId, activity, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 7, this, activity, Long.valueOf(sessionId));
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQ_FILE);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQ_FILE)");
        if (fromV2.getBoolean("key_tbs_pdf_plugin", false)) {
            PerfFeature.a(PerfFeature.CustomFlag.TBSToolPDFMMKV);
            QLog.d("TBSToolClientFileUtils", 1, "checkTBSToolPluginState add flag TBSToolPDFMMKV");
        }
        if (fromV2.getBoolean("key_tbs_office_plugin", false)) {
            PerfFeature.a(PerfFeature.CustomFlag.TBSToolOfficeMMKV);
            QLog.d("TBSToolClientFileUtils", 1, "checkTBSToolPluginState add flag TBSToolOfficeMMKV");
        }
    }

    public final void s(@NotNull List<String> fileList) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fileList);
            return;
        }
        Intrinsics.checkNotNullParameter(fileList, "fileList");
        Activity L = L();
        if (L == null) {
            return;
        }
        List<String> list = fileList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ah.k1(new FileInfo((String) it.next())));
        }
        ah.O(arrayList, L);
    }

    public final void t(@Nullable Object args, @Nullable Object callback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, args, callback);
            return;
        }
        if (!(args instanceof Bundle)) {
            return;
        }
        String[] stringArray = ((Bundle) args).getStringArray("extFilter");
        boolean z17 = false;
        if (stringArray != null) {
            if (stringArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            }
        }
        if (z17) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(i.b(64)), null, null, new TBSToolClientUtils$getFileListByExt$1(stringArray, callback, null), 3, null);
        }
    }

    public final boolean x(@NotNull Activity activity, @Nullable TbsReaderView tbsView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity, (Object) tbsView)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (tbsView == null) {
            return false;
        }
        tbsView.doCommand(8002, null, new a(new WeakReference(activity)));
        return true;
    }

    public final void y(long sessionId, @NotNull String action) {
        AppRuntime peekAppRuntime;
        FileManagerEntity fileManagerEntity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(sessionId), action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Activity L = L();
        if (L == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        Entity find = DBMethodProxy.find(peekAppRuntime.getEntityManagerFactory().createEntityManager(), (Class<? extends Entity>) FileManagerEntity.class, String.valueOf(sessionId));
        if (find instanceof FileManagerEntity) {
            fileManagerEntity = (FileManagerEntity) find;
        } else {
            fileManagerEntity = null;
        }
        if (fileManagerEntity == null) {
            return;
        }
        ((ITBSToolService) QRoute.api(ITBSToolService.class)).browserFile(L, fileManagerEntity, action);
    }

    public final void z(@NotNull String path) {
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) path);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Activity L = L();
        if (L == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        ((ITBSToolService) QRoute.api(ITBSToolService.class)).browserFile(L, p(peekAppRuntime, path), "");
    }
}
