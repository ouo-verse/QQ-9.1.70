package com.tencent.mobileqq.filemanager.activity.localfile;

import android.database.Cursor;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.api.IFileSandboxPathUtilApi;
import com.tencent.mobileqq.filemanager.data.CostData;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LoadParam;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.nativefilescan.FileScanCore;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bD\u0010EJ\u00ae\u0001\u0010\f\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000b`\u000628\u0010\b\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u000628\u0010\t\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u0006H\u0002JR\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000328\u0010\u000f\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u0006H\u0002J\u00ba\u0001\u0010\u0016\u001a4\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0002j\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0004j\b\u0012\u0004\u0012\u00028\u0001`\u0007`\u0006\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u001328\u0010\u0014\u001a4\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0002j\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0004j\b\u0012\u0004\u0012\u00028\u0001`\u0007`\u000628\u0010\u0015\u001a4\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0002j\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0004j\b\u0012\u0004\u0012\u00028\u0001`\u0007`\u0006H\u0002JJ\u0010\u001b\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002JJ\u0010\u001c\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002JJ\u0010\u001d\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002JJ\u0010\u001e\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002JX\u0010$\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0002JJ\u0010%\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002JJ\u0010&\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002JJ\u0010'\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0002J\u00ec\u0001\u0010-\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000b`\u000628\u0010*\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u000628\u0010+\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u00062<\u0010,\u001a8\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0002j \u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007\u0018\u0001`\u0006H\u0002Jt\u00100\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040.j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`/28\u0010\u000f\u001a4\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\u0006H\u0002J\u0006\u00102\u001a\u000201J\u00d4\u0001\u0010;\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u00c3\u0001\u0010:\u001a\u00be\u0001\u0012E\u0012C\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000b`\u0006\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012#\u0012!\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000b\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(7\u0012#\u0012!\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000b\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(8\u0012#\u0012!\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000b\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001003J\u0090\u0001\u0010>\u001a\u00020\u00102\u0006\u0010<\u001a\u0002012\u0006\u0010\u0018\u001a\u00020\u00172x\u0010:\u001at\u0012E\u0012C\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000b`\u0006\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012#\u0012!\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000b\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00100=R$\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u00050?j\b\u0012\u0004\u0012\u00020\u0005`@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/filemanager/activity/localfile/FileInfoLoader;", "", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lcom/tencent/mobileqq/filemanager/data/FileInfo;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/HashSet;", "systemVideoFileInfo", "systemAudioFileInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "u", "target", "source", "map", "", "w", "K", "V", "map1", "map2", "v", "Lcom/tencent/mobileqq/filemanager/data/k;", "loadParams", "Lcom/tencent/mobileqq/filemanager/data/b;", "costData", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "", "Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView$h;", "scanParams", "inFilter", "outFilter", DomainData.DOMAIN_NAME, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "o", "l", "groupName", ReportConstant.COSTREPORT_PREFIX, "systemPicFileInfo", "sandboxPicFileInfo", "choosePicFileInfo", "t", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", HippyTKDListViewAdapter.X, "", "y", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "mediaStoreFile", "allFile", "sandBoxAudioFile", "sandBoxVideoFile", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isFileChooseSupport", "Lkotlin/Function2;", "r", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "b", "Ljava/util/Comparator;", "sMediaComparatorByTime", "<init>", "()V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileInfoLoader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FileInfoLoader f206609a = new FileInfoLoader();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Comparator<FileInfo> sMediaComparatorByTime = new Comparator() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int C;
            C = FileInfoLoader.C((FileInfo) obj, (FileInfo) obj2);
            return C;
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JQ\u0010\r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/filemanager/activity/localfile/FileInfoLoader$a", "Lcom/tencent/mobileqq/nativefilescan/a;", "", "", "filePathArray", "nameArray", "extensionArrayArray", "", "lastModifiedTimeArray", "sizeArray", "", "lastIndex", "", "onFileInfoAvailable", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[J[JI)V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends com.tencent.mobileqq.nativefilescan.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f206611a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap<String, HashSet<FileInfo>> f206612b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f206613c;

        a(Ref.IntRef intRef, HashMap<String, HashSet<FileInfo>> hashMap, String str) {
            this.f206611a = intRef;
            this.f206612b = hashMap;
            this.f206613c = str;
        }

        @Override // com.tencent.mobileqq.nativefilescan.a, com.tencent.mobileqq.nativefilescan.Callback
        public void onFileInfoAvailable(@NotNull String[] filePathArray, @NotNull String[] nameArray, @NotNull String[] extensionArrayArray, @NotNull long[] lastModifiedTimeArray, @NotNull long[] sizeArray, int lastIndex) {
            Intrinsics.checkNotNullParameter(filePathArray, "filePathArray");
            Intrinsics.checkNotNullParameter(nameArray, "nameArray");
            Intrinsics.checkNotNullParameter(extensionArrayArray, "extensionArrayArray");
            Intrinsics.checkNotNullParameter(lastModifiedTimeArray, "lastModifiedTimeArray");
            Intrinsics.checkNotNullParameter(sizeArray, "sizeArray");
            this.f206611a.element += lastIndex;
            if (lastIndex >= 0) {
                int i3 = 0;
                while (true) {
                    String str = extensionArrayArray[i3];
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.B(ah.q0(str));
                    fileInfo.z(filePathArray[i3]);
                    fileInfo.y(nameArray[i3]);
                    fileInfo.A(sizeArray[i3]);
                    fileInfo.r(lastModifiedTimeArray[i3] * 1000);
                    if (!this.f206612b.containsKey(this.f206613c)) {
                        HashMap<String, HashSet<FileInfo>> hashMap = this.f206612b;
                        String groupName = this.f206613c;
                        Intrinsics.checkNotNullExpressionValue(groupName, "groupName");
                        hashMap.put(groupName, new HashSet<>());
                    }
                    HashSet<FileInfo> hashSet = this.f206612b.get(this.f206613c);
                    Intrinsics.checkNotNull(hashSet);
                    hashSet.add(fileInfo);
                    if (i3 != lastIndex) {
                        i3++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JQ\u0010\r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/filemanager/activity/localfile/FileInfoLoader$b", "Lcom/tencent/mobileqq/nativefilescan/a;", "", "", "filePathArray", "nameArray", "extensionArrayArray", "", "lastModifiedTimeArray", "sizeArray", "", "lastIndex", "", "onFileInfoAvailable", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[J[JI)V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends com.tencent.mobileqq.nativefilescan.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f206614a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap<String, HashSet<FileInfo>> f206615b;

        b(Ref.IntRef intRef, HashMap<String, HashSet<FileInfo>> hashMap) {
            this.f206614a = intRef;
            this.f206615b = hashMap;
        }

        @Override // com.tencent.mobileqq.nativefilescan.a, com.tencent.mobileqq.nativefilescan.Callback
        public void onFileInfoAvailable(@NotNull String[] filePathArray, @NotNull String[] nameArray, @NotNull String[] extensionArrayArray, @NotNull long[] lastModifiedTimeArray, @NotNull long[] sizeArray, int lastIndex) {
            Intrinsics.checkNotNullParameter(filePathArray, "filePathArray");
            Intrinsics.checkNotNullParameter(nameArray, "nameArray");
            Intrinsics.checkNotNullParameter(extensionArrayArray, "extensionArrayArray");
            Intrinsics.checkNotNullParameter(lastModifiedTimeArray, "lastModifiedTimeArray");
            Intrinsics.checkNotNullParameter(sizeArray, "sizeArray");
            this.f206614a.element += lastIndex + 1;
            if (lastIndex >= 0) {
                int i3 = 0;
                while (true) {
                    String str = extensionArrayArray[i3];
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.B(ah.q0(str));
                    fileInfo.z(filePathArray[i3]);
                    fileInfo.y(nameArray[i3]);
                    fileInfo.A(sizeArray[i3]);
                    fileInfo.r(lastModifiedTimeArray[i3] * 1000);
                    if (!this.f206615b.containsKey(str)) {
                        this.f206615b.put(str, new HashSet<>());
                    }
                    HashSet<FileInfo> hashSet = this.f206615b.get(str);
                    Intrinsics.checkNotNull(hashSet);
                    hashSet.add(fileInfo);
                    if (i3 != lastIndex) {
                        i3++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    FileInfoLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, HashSet<FileInfo>> A(LoadParam loadParams, CostData costData) {
        boolean equals;
        if (MobileQQ.sMobileQQ.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) != 0) {
            return new HashMap<>();
        }
        if (!loadParams.getIncludeSystemMediaStorage()) {
            return new HashMap<>();
        }
        HashMap<String, HashSet<FileInfo>> hashMap = new HashMap<>();
        Cursor cursor = null;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            Cursor query = ContactsMonitor.query(BaseApplication.context.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "bucket_display_name", "_data", InputMethodUtil.SOUGOU_URI_DISPLAYNAME, "_size", "date_added"}, null, null, "date_added desc");
            if (query == null) {
                return new HashMap<>();
            }
            try {
                int count = query.getCount();
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = query.getColumnIndexOrThrow("_data");
                int columnIndexOrThrow3 = query.getColumnIndexOrThrow(InputMethodUtil.SOUGOU_URI_DISPLAYNAME);
                int columnIndexOrThrow4 = query.getColumnIndexOrThrow("date_added");
                int columnIndexOrThrow5 = query.getColumnIndexOrThrow("_size");
                int columnIndexOrThrow6 = query.getColumnIndexOrThrow("bucket_display_name");
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow2);
                    if (string != null) {
                        FileInfo fileInfo = new FileInfo();
                        fileInfo.x(query.getInt(columnIndexOrThrow));
                        fileInfo.B(0);
                        fileInfo.u(query.getString(columnIndexOrThrow6));
                        fileInfo.t(false);
                        fileInfo.z(string);
                        fileInfo.y(query.getString(columnIndexOrThrow3));
                        int i3 = columnIndexOrThrow;
                        int i16 = columnIndexOrThrow2;
                        fileInfo.r(query.getLong(columnIndexOrThrow4) * 1000);
                        fileInfo.A(query.getLong(columnIndexOrThrow5));
                        if (!TextUtils.isEmpty(fileInfo.f())) {
                            if (!hashMap.containsKey(fileInfo.f())) {
                                String f16 = fileInfo.f();
                                Intrinsics.checkNotNullExpressionValue(f16, "inf.groupName");
                                hashMap.put(f16, new HashSet<>());
                            }
                            HashSet<FileInfo> hashSet = hashMap.get(fileInfo.f());
                            if (hashSet != null) {
                                hashSet.add(fileInfo);
                            }
                        }
                        columnIndexOrThrow = i3;
                        columnIndexOrThrow2 = i16;
                    }
                }
                costData.n(SystemClock.uptimeMillis() - uptimeMillis);
                QLog.d("FileInfoLoader", 1, "queryMediaStorePics total cost: " + costData.getSystemPicCost() + ", fileCount: " + count);
                query.close();
                Iterator<Map.Entry<String, HashSet<FileInfo>>> it = hashMap.entrySet().iterator();
                while (it.hasNext()) {
                    equals = StringsKt__StringsJVMKt.equals("QQfile_recv", it.next().getKey(), true);
                    if (equals) {
                        it.remove();
                    }
                }
                return hashMap;
            } catch (Throwable th5) {
                th = th5;
                cursor = query;
                Cursor cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, HashSet<FileInfo>> B(LoadParam loadParams, CostData costData) {
        boolean equals;
        if (MobileQQ.sMobileQQ.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) != 0) {
            return new HashMap<>();
        }
        if (loadParams.getIncludeSystemMediaStorage() && (loadParams.getMediaFlag() & 2) > 0) {
            HashMap<String, HashSet<FileInfo>> hashMap = new HashMap<>();
            Cursor cursor = null;
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                Cursor query = ContactsMonitor.query(BaseApplication.context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "bucket_id", "bucket_display_name", "_data", InputMethodUtil.SOUGOU_URI_DISPLAYNAME, "_size", "date_added"}, null, null, null);
                if (query == null) {
                    return new HashMap<>();
                }
                try {
                    int count = query.getCount();
                    int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                    int columnIndexOrThrow2 = query.getColumnIndexOrThrow("_data");
                    int columnIndexOrThrow3 = query.getColumnIndexOrThrow(InputMethodUtil.SOUGOU_URI_DISPLAYNAME);
                    int columnIndexOrThrow4 = query.getColumnIndexOrThrow("date_added");
                    int columnIndexOrThrow5 = query.getColumnIndexOrThrow("_size");
                    int columnIndexOrThrow6 = query.getColumnIndexOrThrow("bucket_display_name");
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndexOrThrow2);
                        if (!TextUtils.isEmpty(string)) {
                            String string2 = query.getString(columnIndexOrThrow6);
                            String str = "";
                            if (string2 == null) {
                                string2 = "";
                            }
                            if (!TextUtils.isEmpty(string2)) {
                                FileInfo fileInfo = new FileInfo();
                                fileInfo.x(query.getInt(columnIndexOrThrow));
                                fileInfo.B(2);
                                fileInfo.u(string2);
                                fileInfo.t(false);
                                fileInfo.z(string);
                                String string3 = query.getString(columnIndexOrThrow3);
                                if (string3 != null) {
                                    str = string3;
                                }
                                fileInfo.y(str);
                                int i3 = count;
                                fileInfo.r(query.getLong(columnIndexOrThrow4) * 1000);
                                fileInfo.A(query.getLong(columnIndexOrThrow5));
                                if (!hashMap.containsKey(fileInfo.f())) {
                                    String f16 = fileInfo.f();
                                    Intrinsics.checkNotNullExpressionValue(f16, "inf.groupName");
                                    hashMap.put(f16, new HashSet<>());
                                }
                                HashSet<FileInfo> hashSet = hashMap.get(fileInfo.f());
                                if (hashSet != null) {
                                    hashSet.add(fileInfo);
                                }
                                count = i3;
                            }
                        }
                    }
                    costData.o(SystemClock.uptimeMillis() - uptimeMillis);
                    QLog.d("FileInfoLoader", 1, "queryMediaStoreVideos total cost: " + costData.getSystemVideoCost() + ", fileCount: " + count);
                    query.close();
                    Iterator<Map.Entry<String, HashSet<FileInfo>>> it = hashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        equals = StringsKt__StringsJVMKt.equals("QQfile_recv", it.next().getKey(), true);
                        if (equals) {
                            it.remove();
                        }
                    }
                    return hashMap;
                } catch (Throwable th5) {
                    th = th5;
                    cursor = query;
                    Cursor cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            return new HashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int C(FileInfo fileInfo, FileInfo fileInfo2) {
        return -Intrinsics.compare(fileInfo.e(), fileInfo2.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, HashSet<FileInfo>> l(LoadParam loadParams, CostData costData) {
        boolean endsWith$default;
        String str;
        String str2 = ((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(AppConstants.SDCARD_PATH) + "/chatpic/chatimg/";
        HashMap<String, HashSet<FileInfo>> hashMap = new HashMap<>();
        String qqStr = HardCodeUtil.qqStr(R.string.f187293tl);
        Ref.IntRef intRef = new Ref.IntRef();
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, "/", false, 2, null);
        if (endsWith$default) {
            String substring = str2.substring(0, str2.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            str = substring;
        } else {
            str = str2;
        }
        QLog.d("FileInfoLoader", 1, "getLocalSandBoxMedia queryPath: " + str + ", origin path: " + str2);
        FileScanCore.Companion.b(FileScanCore.INSTANCE, null, 1, null).e(str, true, true, "", "", new a(intRef, hashMap, qqStr));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, HashSet<FileInfo>> m(LoadParam loadParams, CostData costData) {
        if ((loadParams.getMediaFlag() & 1) > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            HashMap<String, HashSet<FileInfo>> n3 = n(loadParams.c(), ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg");
            costData.j(SystemClock.uptimeMillis() - uptimeMillis);
            return n3;
        }
        return new HashMap<>();
    }

    private final HashMap<String, HashSet<FileInfo>> n(List<? extends QfileTabBarView.h> scanParams, String inFilter, String outFilter) {
        boolean endsWith$default;
        String a16;
        long uptimeMillis = SystemClock.uptimeMillis();
        HashMap<String, HashSet<FileInfo>> hashMap = new HashMap<>();
        Ref.IntRef intRef = new Ref.IntRef();
        for (QfileTabBarView.h hVar : scanParams) {
            String a17 = hVar.a();
            Intrinsics.checkNotNullExpressionValue(a17, "dir.strPath");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(a17, "/", false, 2, null);
            if (endsWith$default) {
                String a18 = hVar.a();
                Intrinsics.checkNotNullExpressionValue(a18, "dir.strPath");
                a16 = a18.substring(0, hVar.a().length() - 1);
                Intrinsics.checkNotNullExpressionValue(a16, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            } else {
                a16 = hVar.a();
            }
            String queryPath = a16;
            QLog.d("FileInfoLoader", 1, "getLocalSandBoxMedia queryPath: " + queryPath + ", origin path: " + hVar.a());
            FileScanCore b16 = FileScanCore.Companion.b(FileScanCore.INSTANCE, null, 1, null);
            Intrinsics.checkNotNullExpressionValue(queryPath, "queryPath");
            b16.e(queryPath, true, true, inFilter, outFilter, new b(intRef, hashMap));
        }
        QLog.d("FileInfoLoader", 1, "getLocalSandBoxMedia  inFilter: " + inFilter + ", total cost: " + (SystemClock.uptimeMillis() - uptimeMillis) + ", count: " + intRef.element);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, HashSet<FileInfo>> o(LoadParam loadParams, CostData costData) {
        long uptimeMillis = SystemClock.uptimeMillis();
        HashMap<String, HashSet<FileInfo>> n3 = n(loadParams.c(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "");
        costData.k(SystemClock.uptimeMillis() - uptimeMillis);
        QLog.d("FileInfoLoader", 1, "getLocalSandBoxPic sandBoxPicCost=" + costData.getSandBoxPicCost());
        return n3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, HashSet<FileInfo>> p(LoadParam loadParams, CostData costData) {
        if ((loadParams.getMediaFlag() & 2) > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            HashMap<String, HashSet<FileInfo>> n3 = n(loadParams.c(), ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "");
            costData.l(SystemClock.uptimeMillis() - uptimeMillis);
            return n3;
        }
        return new HashMap<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String s(String groupName) {
        String qqStr;
        boolean equals;
        boolean equals2;
        boolean equals3;
        if (!TextUtils.isEmpty(groupName)) {
            equals2 = StringsKt__StringsJVMKt.equals(groupName, "QQfile_recv", true);
            if (!equals2) {
                equals3 = StringsKt__StringsJVMKt.equals(groupName, "QQ", true);
                if (!equals3) {
                    qqStr = groupName;
                    equals = StringsKt__StringsJVMKt.equals(groupName, "camera", true);
                    if (!equals) {
                        String qqStr2 = HardCodeUtil.qqStr(R.string.f187103t3);
                        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qfile_file_mobile_picture)");
                        return qqStr2;
                    }
                    return qqStr;
                }
            }
        }
        qqStr = HardCodeUtil.qqStr(R.string.f186993ss);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qfile_file_downoaded_image)");
        equals = StringsKt__StringsJVMKt.equals(groupName, "camera", true);
        if (!equals) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, ArrayList<FileInfo>> t(HashMap<String, HashSet<FileInfo>> systemPicFileInfo, HashMap<String, HashSet<FileInfo>> sandboxPicFileInfo, HashMap<String, HashSet<FileInfo>> choosePicFileInfo) {
        int mapCapacity;
        List list;
        boolean contains;
        LinkedHashMap<String, HashSet<FileInfo>> x16 = x(v(sandboxPicFileInfo, systemPicFileInfo));
        if (choosePicFileInfo != null) {
            HashMap v3 = v(choosePicFileInfo, x16);
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type java.util.LinkedHashMap<kotlin.String, java.util.HashSet<com.tencent.mobileqq.filemanager.data.FileInfo>>{ kotlin.collections.TypeAliasesKt.LinkedHashMap<kotlin.String, java.util.HashSet<com.tencent.mobileqq.filemanager.data.FileInfo>{ kotlin.collections.TypeAliasesKt.HashSet<com.tencent.mobileqq.filemanager.data.FileInfo> }> }");
            x16 = (LinkedHashMap) v3;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, HashSet<FileInfo>> entry : x16.entrySet()) {
            String key = entry.getKey();
            entry.getValue();
            contains = StringsKt__StringsKt.contains((CharSequence) ".jpg|.bmp|.jpeg|.gif|.png|.ico|", (CharSequence) key, true);
            if (!contains) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size());
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(mapCapacity);
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key2 = entry2.getKey();
            list = CollectionsKt___CollectionsKt.toList((Iterable) entry2.getValue());
            linkedHashMap3.put(key2, new ArrayList(list));
        }
        linkedHashMap2.putAll(linkedHashMap3);
        Iterator it = linkedHashMap2.entrySet().iterator();
        while (it.hasNext()) {
            Collections.sort((List) ((Map.Entry) it.next()).getValue(), sMediaComparatorByTime);
        }
        return linkedHashMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, ArrayList<FileInfo>> u(HashMap<String, HashSet<FileInfo>> systemVideoFileInfo, HashMap<String, HashSet<FileInfo>> systemAudioFileInfo) {
        int mapCapacity;
        List list;
        HashMap<String, HashSet<FileInfo>> v3 = v(systemVideoFileInfo, systemAudioFileInfo);
        w("Camera", "camera", v3);
        w("Camera", ComponentFactory.ComponentType.VIDEO, v3);
        String downloadedVideo = HardCodeUtil.qqStr(R.string.f186983sr);
        Intrinsics.checkNotNullExpressionValue(downloadedVideo, "downloadedVideo");
        w(downloadedVideo, "QQ", v3);
        HashMap<String, ArrayList<FileInfo>> hashMap = new HashMap<>();
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(v3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = v3.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            list = CollectionsKt___CollectionsKt.toList((Iterable) entry.getValue());
            linkedHashMap.put(key, new ArrayList(list));
        }
        hashMap.putAll(linkedHashMap);
        Iterator<Map.Entry<String, ArrayList<FileInfo>>> it5 = hashMap.entrySet().iterator();
        while (it5.hasNext()) {
            Collections.sort(it5.next().getValue(), sMediaComparatorByTime);
        }
        return hashMap;
    }

    private final <K, V> HashMap<K, HashSet<V>> v(HashMap<K, HashSet<V>> map1, HashMap<K, HashSet<V>> map2) {
        Object clone = map2.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.HashMap<K of com.tencent.mobileqq.filemanager.activity.localfile.FileInfoLoader.mergeMap, java.util.HashSet<V of com.tencent.mobileqq.filemanager.activity.localfile.FileInfoLoader.mergeMap>>{ kotlin.collections.TypeAliasesKt.HashMap<K of com.tencent.mobileqq.filemanager.activity.localfile.FileInfoLoader.mergeMap, java.util.HashSet<V of com.tencent.mobileqq.filemanager.activity.localfile.FileInfoLoader.mergeMap>{ kotlin.collections.TypeAliasesKt.HashSet<V of com.tencent.mobileqq.filemanager.activity.localfile.FileInfoLoader.mergeMap> }> }");
        HashMap<K, HashSet<V>> hashMap = (HashMap) clone;
        for (Map.Entry<K, HashSet<V>> entry : map1.entrySet()) {
            if (hashMap.containsKey(entry.getKey())) {
                HashSet<V> hashSet = hashMap.get(entry.getKey());
                Intrinsics.checkNotNull(hashSet);
                hashSet.addAll(entry.getValue());
            } else {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    private final void w(String target, String source, HashMap<String, HashSet<FileInfo>> map) {
        boolean equals;
        Object clone = map.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, java.util.HashSet<com.tencent.mobileqq.filemanager.data.FileInfo>>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, java.util.HashSet<com.tencent.mobileqq.filemanager.data.FileInfo>{ kotlin.collections.TypeAliasesKt.HashSet<com.tencent.mobileqq.filemanager.data.FileInfo> }> }");
        HashMap hashMap = (HashMap) clone;
        hashMap.remove(target);
        Set<Map.Entry> entrySet = hashMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "temp.entries");
        for (Map.Entry entry : entrySet) {
            equals = StringsKt__StringsJVMKt.equals(source, (String) entry.getKey(), true);
            if (equals) {
                Intrinsics.checkNotNullExpressionValue(entry.getValue(), "it.value");
                if (!((Collection) r2).isEmpty()) {
                    if (!map.containsKey(target)) {
                        map.put(target, new HashSet<>());
                    }
                    HashSet<FileInfo> hashSet = map.get(target);
                    Intrinsics.checkNotNull(hashSet);
                    hashSet.addAll((Collection) entry.getValue());
                }
            }
        }
    }

    private final LinkedHashMap<String, HashSet<FileInfo>> x(HashMap<String, HashSet<FileInfo>> map) {
        LinkedHashMap<String, HashSet<FileInfo>> linkedHashMap = new LinkedHashMap<>();
        String qqStr = HardCodeUtil.qqStr(R.string.f187103t3);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qfile_file_mobile_picture)");
        linkedHashMap.put(qqStr, new HashSet<>());
        String qqStr2 = HardCodeUtil.qqStr(R.string.f186993ss);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qfile_file_downoaded_image)");
        linkedHashMap.put(qqStr2, new HashSet<>());
        for (String groupName : map.keySet()) {
            Intrinsics.checkNotNullExpressionValue(groupName, "groupName");
            String s16 = s(groupName);
            if (!linkedHashMap.containsKey(s16)) {
                linkedHashMap.put(s16, new HashSet<>());
            }
            HashSet<FileInfo> hashSet = map.get(groupName);
            if (hashSet != null) {
                HashSet<FileInfo> hashSet2 = linkedHashMap.get(s16);
                Intrinsics.checkNotNull(hashSet2);
                hashSet2.addAll(hashSet);
            }
        }
        map.clear();
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, HashSet<FileInfo>> z(LoadParam loadParams, CostData costData) {
        HashMap<String, HashSet<FileInfo>> hashMapOf;
        if (MobileQQ.sMobileQQ.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) != 0) {
            return new HashMap<>();
        }
        if (loadParams.getIncludeSystemMediaStorage()) {
            int i3 = 1;
            if ((loadParams.getMediaFlag() & 1) > 0) {
                String qqStr = HardCodeUtil.qqStr(R.string.bad);
                HashSet hashSet = new HashSet();
                Cursor cursor = null;
                try {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    Cursor query = ContactsMonitor.query(BaseApplication.context.getContentResolver(), MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", InputMethodUtil.SOUGOU_URI_DISPLAYNAME, "date_added", "_data", "_size"}, null, null, null);
                    if (query == null) {
                        return new HashMap<>();
                    }
                    try {
                        int count = query.getCount();
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                        int columnIndexOrThrow2 = query.getColumnIndexOrThrow("_id");
                        int columnIndexOrThrow3 = query.getColumnIndexOrThrow(InputMethodUtil.SOUGOU_URI_DISPLAYNAME);
                        int columnIndexOrThrow4 = query.getColumnIndexOrThrow("date_added");
                        int columnIndexOrThrow5 = query.getColumnIndexOrThrow("_size");
                        while (query.moveToNext()) {
                            String string = query.getString(columnIndexOrThrow);
                            if (!TextUtils.isEmpty(string)) {
                                FileInfo fileInfo = new FileInfo();
                                fileInfo.x(query.getInt(columnIndexOrThrow2));
                                fileInfo.B(i3);
                                fileInfo.u(qqStr);
                                fileInfo.t(false);
                                fileInfo.z(string);
                                String string2 = query.getString(columnIndexOrThrow3);
                                if (string2 == null) {
                                    string2 = "";
                                }
                                fileInfo.y(string2);
                                HashSet hashSet2 = hashSet;
                                fileInfo.r(query.getLong(columnIndexOrThrow4) * 1000);
                                fileInfo.A(query.getLong(columnIndexOrThrow5));
                                hashSet2.add(fileInfo);
                                hashSet = hashSet2;
                                i3 = 1;
                            }
                        }
                        HashSet hashSet3 = hashSet;
                        costData.m(SystemClock.uptimeMillis() - uptimeMillis);
                        QLog.d("FileInfoLoader", 1, "queryMediaStoreAudios total cost: " + costData.getSystemAudioCost() + ", fileCount: " + count);
                        query.close();
                        if (!hashSet3.isEmpty()) {
                            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(qqStr, hashSet3));
                            return hashMapOf;
                        }
                        return new HashMap<>();
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = query;
                        Cursor cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        }
        return new HashMap<>();
    }

    public final void q(@NotNull LoadParam loadParams, @NotNull Function4<? super HashMap<String, ArrayList<FileInfo>>, ? super ArrayList<FileInfo>, ? super ArrayList<FileInfo>, ? super ArrayList<FileInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(loadParams, "loadParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.filemanager.activity.localfile.b.e(96), null, null, new FileInfoLoader$getMediaTabFileInfo$1(loadParams, callback, null), 3, null);
    }

    public final void r(boolean isFileChooseSupport, @NotNull LoadParam loadParams, @NotNull Function2<? super HashMap<String, ArrayList<FileInfo>>, ? super ArrayList<FileInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(loadParams, "loadParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.filemanager.activity.localfile.b.e(96), null, null, new FileInfoLoader$getPicTabFileInfo$1(isFileChooseSupport, loadParams, callback, null), 3, null);
    }

    public final boolean y() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105554", false);
        QLog.d("FileInfoLoader", 1, "needOptimize value: " + isSwitchOn);
        return isSwitchOn;
    }
}
