package com.tencent.aelight.camera.ae.flashshow.ui.panel;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAELocalMaterialItem;
import com.tencent.aelight.camera.ae.camera.ui.panel.bj;
import com.tencent.aelight.camera.ae.camera.ui.panel.bk;
import com.tencent.aelight.camera.ae.camera.ui.panel.br;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.ttpic.facedetect.GenderType;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001L\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001VB\u0019\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\b\u0002\u0010R\u001a\u00020&\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0002J&\u0010\u0016\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J(\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\u0004J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0016J\"\u0010,\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00132\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020&H\u0016J\u001a\u0010.\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00132\u0006\u0010-\u001a\u00020&H\u0016R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001c\u0010:\u001a\n 7*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\"\u0010G\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006W"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSCosmeticsProviderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder$b;", "Lcom/tencent/aelight/camera/download/a;", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "cosmeticList", "y", "p", "", "r", "t", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "k", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "data", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ReportConstant.COSTREPORT_PREFIX, "", "assetName", "destName", "versionCode", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/io/File;", "versionFile", "B", "Llq/b;", "partManager", "j", HippyTKDListViewAdapter.X, "w", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "b", "info", "isUsable", "resCode", "onDownloadFinish", "progress", "onProgressUpdate", "Lcom/tencent/aelight/camera/ae/flashshow/LSMiddleCameraUnit;", "d", "Lcom/tencent/aelight/camera/ae/flashshow/LSMiddleCameraUnit;", "viewModelStoreOwner", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/aa;", "e", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/aa;", "cosmeticsViewModel", "kotlin.jvm.PlatformType", "f", "Lcom/tencent/common/app/AppInterface;", "mApp", tl.h.F, "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "pendingSelectItem", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder;", "i", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder;", "cosmeticListManager", "I", "getGenderType", "()I", "setGenderType", "(I)V", "genderType", "Lcom/tencent/aelight/camera/ae/control/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aelight/camera/ae/control/b;", "mTemplateManager", "com/tencent/aelight/camera/ae/flashshow/ui/panel/LSCosmeticsProviderView$b", "D", "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSCosmeticsProviderView$b;", "mCosmeticDataChangeObserver", "Landroid/content/Context;", "context", "rightBeautyBtnMode", "<init>", "(Landroid/content/Context;I)V", "E", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class LSCosmeticsProviderView extends FrameLayout implements DYAEEffectListHolder.b, com.tencent.aelight.camera.download.a {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.aelight.camera.ae.control.b mTemplateManager;

    /* renamed from: D, reason: from kotlin metadata */
    private final b mCosmeticDataChangeObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LSMiddleCameraUnit viewModelStoreOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aelight.camera.ae.camera.ui.panel.aa cosmeticsViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AppInterface mApp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private bj pendingSelectItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final DYAEEffectListHolder cosmeticListManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int genderType;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/panel/LSCosmeticsProviderView$b", "Lcom/tencent/aelight/camera/aioeditor/capture/music/b;", "", "c", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b extends com.tencent.aelight.camera.aioeditor.capture.music.b {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.b
        public void c() {
            if (LSCosmeticsProviderView.this.r()) {
                return;
            }
            com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar = LSCosmeticsProviderView.this.cosmeticsViewModel;
            if (aaVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
                aaVar = null;
            }
            bj value = aaVar.N1().getValue();
            if (value == null || bk.a(value)) {
                LSCosmeticsProviderView.this.p();
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((bj) t16).getMaleOrder()), Integer.valueOf(((bj) t17).getMaleOrder()));
            return compareValues;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(-((bj) t16).getFemaleOrder()), Integer.valueOf(-((bj) t17).getFemaleOrder()));
            return compareValues;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LSCosmeticsProviderView(Context context, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        AppInterface a16 = com.tencent.aelight.camera.aebase.a.a();
        this.mApp = a16;
        this.cosmeticListManager = new DYAEEffectListHolder(context, this, this, i3);
        this.genderType = GenderType.DEFAULT.value;
        b bVar = new b();
        this.mCosmeticDataChangeObserver = bVar;
        this.mTemplateManager = f.a().getTemplateManager();
        l();
        a16.registObserver(bVar);
    }

    private final void A(String assetName, String destName, String versionCode) {
        String str;
        BufferedReader bufferedReader;
        File file = new File(destName);
        if (file.isFile()) {
            file.delete();
        }
        File file2 = new File(file, "__version");
        if (file.exists()) {
            if (file2.exists() && file2.isFile()) {
                Reader inputStreamReader = new InputStreamReader(new FileInputStream(file2), Charsets.UTF_8);
                if (inputStreamReader instanceof BufferedReader) {
                    bufferedReader = (BufferedReader) inputStreamReader;
                } else {
                    bufferedReader = new BufferedReader(inputStreamReader, 8192);
                }
                try {
                    str = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                } finally {
                }
            } else {
                str = "0";
            }
            if (!Intrinsics.areEqual(str, versionCode)) {
                file.delete();
                B(file2, assetName, destName, versionCode);
            }
        }
        if (file.exists()) {
            return;
        }
        B(file2, assetName, destName, versionCode);
    }

    private final void B(File versionFile, String assetName, String destName, String versionCode) {
        BufferedWriter bufferedWriter;
        File file = new File(g.a.C0559a.f65247a + "/cosmetic.zip");
        if (file.exists()) {
            file.delete();
        }
        FileUtils.copyAssetToFile(getContext(), assetName, file.getAbsolutePath());
        FileUtils.uncompressZip(file.getAbsolutePath(), destName, false);
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(versionFile), Charsets.UTF_8);
        if (outputStreamWriter instanceof BufferedWriter) {
            bufferedWriter = (BufferedWriter) outputStreamWriter;
        } else {
            bufferedWriter = new BufferedWriter(outputStreamWriter, 8192);
        }
        try {
            bufferedWriter.write(versionCode);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedWriter, null);
        } finally {
        }
    }

    private final List<AEMaterialCategory> k() {
        List<AEMaterialCategory> emptyList;
        com.tencent.aelight.camera.ae.control.b bVar = this.mTemplateManager;
        if (bVar instanceof AEFlashShowMaterialManager) {
            ms.a.f("AECosmeticProviderView", "get list from  flash mode");
            return ((AEFlashShowMaterialManager) bVar).v();
        }
        if (!(bVar instanceof AEMaterialManager)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ms.a.f("AECosmeticProviderView", "get list from default mode");
        List<AEMaterialCategory> w3 = ((AEMaterialManager) bVar).w();
        Intrinsics.checkNotNullExpressionValue(w3, "templateManager.cosmeticMaterialList");
        return w3;
    }

    private final void l() {
        com.tencent.aelight.camera.ae.control.b bVar = this.mTemplateManager;
        if (bVar instanceof AEFlashShowMaterialManager) {
            ((AEFlashShowMaterialManager) bVar).F(false);
        } else if (bVar instanceof AEMaterialManager) {
            ((AEMaterialManager) bVar).N(false);
        }
    }

    private final void m() {
        LSMiddleCameraUnit lSMiddleCameraUnit = this.viewModelStoreOwner;
        if (lSMiddleCameraUnit != null) {
            ViewModel viewModel = com.tencent.aelight.camera.ae.n.a(lSMiddleCameraUnit).get(com.tencent.aelight.camera.ae.camera.ui.panel.aa.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "of(it).get(AECosmeticsViewModel::class.java)");
            com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar = (com.tencent.aelight.camera.ae.camera.ui.panel.aa) viewModel;
            this.cosmeticsViewModel = aaVar;
            com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar2 = null;
            if (aaVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
                aaVar = null;
            }
            aaVar.N1().observe(lSMiddleCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.y
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    LSCosmeticsProviderView.n(LSCosmeticsProviderView.this, (bj) obj);
                }
            });
            com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar3 = this.cosmeticsViewModel;
            if (aaVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
            } else {
                aaVar2 = aaVar3;
            }
            aaVar2.M1().observe(lSMiddleCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.z
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    LSCosmeticsProviderView.o(LSCosmeticsProviderView.this, (List) obj);
                }
            });
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(LSCosmeticsProviderView this$0, bj bjVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DYAEEffectListHolder.l(this$0.cosmeticListManager, bjVar.getId(), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(LSCosmeticsProviderView this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DYAEEffectListHolder dYAEEffectListHolder = this$0.cosmeticListManager;
        Intrinsics.checkNotNullExpressionValue(list, "list");
        dYAEEffectListHolder.j(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.x
            @Override // java.lang.Runnable
            public final void run() {
                LSCosmeticsProviderView.q(LSCosmeticsProviderView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(LSCosmeticsProviderView this$0) {
        bj b16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        if (this$0.r()) {
            b16 = bk.c();
        } else {
            b16 = bk.b();
        }
        arrayList.add(b16);
        try {
            if (this$0.r()) {
                arrayList.addAll(this$0.s());
            } else {
                arrayList.addAll(this$0.t());
            }
        } catch (Throwable th5) {
            ms.a.d("AECosmeticProviderView", "load cosmetic data fail", th5);
        }
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar = this$0.cosmeticsViewModel;
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar2 = null;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
            aaVar = null;
        }
        aaVar.Q1(this$0.y(arrayList));
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar3 = this$0.cosmeticsViewModel;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
        } else {
            aaVar2 = aaVar3;
        }
        aaVar2.P1(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r() {
        return false;
    }

    private final List<bj> t() {
        int collectionSizeOrDefault;
        int i3;
        List<AEMaterialCategory> k3 = k();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = k3.iterator();
        while (it.hasNext()) {
            List<AEMaterialMetaData> list = ((AEMaterialCategory) it.next()).f69044d;
            Intrinsics.checkNotNullExpressionValue(list, "it.materialList");
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        int i16 = 0;
        for (Object obj : arrayList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            AEMaterialMetaData material = (AEMaterialMetaData) obj;
            Intrinsics.checkNotNullExpressionValue(material, "material");
            br brVar = new br(material);
            brVar.p(i16);
            try {
                String str = material.orderFemale;
                Intrinsics.checkNotNullExpressionValue(str, "material.orderFemale");
                i3 = Integer.parseInt(str);
            } catch (Exception unused) {
                i3 = 0;
            }
            brVar.o(i3);
            brVar.q(material.cosmeticSlidingValue);
            arrayList2.add(brVar);
            i16 = i17;
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(boolean z16, LSCosmeticsProviderView this$0, AEMaterialMetaData aEMaterialMetaData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            bj bjVar = this$0.pendingSelectItem;
            if (bjVar instanceof br) {
                Intrinsics.checkNotNull(bjVar, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.camera.ui.panel.DYAEMaterialItem");
                if (Intrinsics.areEqual(((br) bjVar).getMaterial().f69050id, aEMaterialMetaData.f69050id)) {
                    com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar = this$0.cosmeticsViewModel;
                    if (aaVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
                        aaVar = null;
                    }
                    bj bjVar2 = this$0.pendingSelectItem;
                    Intrinsics.checkNotNull(bjVar2);
                    aaVar.P1(bjVar2);
                    this$0.pendingSelectItem = null;
                }
            }
        } else {
            QQToast.makeText(this$0.getContext(), HardCodeUtil.qqStr(R.string.qdx), 0).show();
        }
        this$0.cosmeticListManager.c(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(AEMaterialMetaData aEMaterialMetaData, int i3, LSCosmeticsProviderView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aEMaterialMetaData.downloadProgress = i3;
        this$0.cosmeticListManager.c(false);
    }

    private final List<bj> y(List<? extends bj> cosmeticList) {
        List<bj> sortedWith;
        List<bj> sortedWith2;
        if (this.genderType == GenderType.MALE.value) {
            sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(cosmeticList, new c());
            return sortedWith2;
        }
        if ((!cosmeticList.isEmpty()) && bk.a(cosmeticList.get(0))) {
            cosmeticList.get(0).o(2147483646);
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(cosmeticList, new d());
        return sortedWith;
    }

    private final void z(AppInterface app, AEMaterialMetaData data, com.tencent.aelight.camera.download.a listener) {
        com.tencent.aelight.camera.ae.control.b bVar = this.mTemplateManager;
        if (bVar instanceof AEFlashShowMaterialManager) {
            ms.a.f("AECosmeticProviderView", "download in flash mode");
            ((AEFlashShowMaterialManager) bVar).r0(app, data, listener);
        } else if (bVar instanceof AEMaterialManager) {
            ms.a.f("AECosmeticProviderView", "download in default mode");
            ((AEMaterialManager) bVar).E0(app, data, listener);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder.b
    public void b(bj item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (!item.getUsable()) {
            this.pendingSelectItem = item;
            if (!item.getCom.tencent.libra.trace.LibraTraceConst.Node.IMAGE_DOWNLOADING java.lang.String()) {
                ms.a.a("AECosmeticProviderView", "start download material, material_id = " + item.getId());
                item.m(true);
                z(this.mApp, ((br) item).getMaterial(), this);
                this.cosmeticListManager.c(false);
            }
        } else {
            com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar = null;
            this.pendingSelectItem = null;
            com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar2 = this.cosmeticsViewModel;
            if (aaVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
            } else {
                aaVar = aaVar2;
            }
            aaVar.P1(item);
        }
        com.tencent.aelight.camera.ae.report.b.b().Z(item.getName(), AEProviderViewModel.INSTANCE.b(item));
    }

    public final void j(lq.b partManager) {
        Intrinsics.checkNotNullParameter(partManager, "partManager");
        this.viewModelStoreOwner = (LSMiddleCameraUnit) partManager.b(65537, new Object[0]);
        m();
    }

    public final void setGenderType(int i3) {
        this.genderType = i3;
    }

    public final void x() {
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar = this.cosmeticsViewModel;
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar2 = null;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
            aaVar = null;
        }
        List<bj> value = aaVar.M1().getValue();
        if (value == null) {
            return;
        }
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar3 = this.cosmeticsViewModel;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
        } else {
            aaVar2 = aaVar3;
        }
        aaVar2.M1().postValue(y(value));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<bj> s() {
        String str;
        BufferedReader bufferedReader;
        String str2 = "cosmetic_filters/cosmetic.zip";
        if (this.genderType == GenderType.FEMALE.value) {
            str = "cosmetic_filters/config.json";
        } else {
            str = "cosmetic_filters/config.json";
        }
        String str3 = g.a.b.f65252a + "/cosmetic_filters";
        ArrayList arrayList = new ArrayList();
        InputStream open = getResources().getAssets().open(str);
        Intrinsics.checkNotNullExpressionValue(open, "resources.assets.open(assetConfigPath)");
        Reader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
        if (inputStreamReader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) inputStreamReader;
        } else {
            bufferedReader = new BufferedReader(inputStreamReader, 8192);
        }
        try {
            JSONObject jSONObject = new JSONObject(TextStreamsKt.readText(bufferedReader));
            String str4 = null;
            CloseableKt.closeFinally(bufferedReader, null);
            Object obj = jSONObject.get("version");
            String str5 = obj instanceof String ? (String) obj : null;
            if (str5 == null) {
                str5 = "0";
            }
            A(str2, str3, str5);
            Object obj2 = jSONObject.get("data");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray = (JSONArray) obj2;
            int length = jSONArray.length();
            int i3 = 1;
            int i16 = 0;
            while (i16 < length) {
                Object obj3 = jSONArray.get(i16);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject2 = (JSONObject) obj3;
                Object obj4 = jSONObject2.get(QzoneZipCacheHelper.DIR);
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
                String str6 = (String) obj4;
                Object obj5 = jSONObject2.get("name");
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
                String str7 = (String) obj5;
                Object opt = jSONObject2.opt("thumb");
                String str8 = opt instanceof String ? (String) opt : str4;
                Object opt2 = jSONObject2.opt("maleOrder");
                Integer num = opt2 instanceof Integer ? (Integer) opt2 : str4;
                Object opt3 = jSONObject2.opt("femaleOrder");
                Integer num2 = opt3 instanceof Integer ? (Integer) opt3 : str4;
                String str9 = str3 + "/" + str6;
                if (new File(str9).exists()) {
                    int i17 = i3 + 1;
                    String valueOf = String.valueOf(i3);
                    if (str8 == null) {
                        str8 = "file://" + str9 + "/template.png";
                    }
                    DYAELocalMaterialItem dYAELocalMaterialItem = new DYAELocalMaterialItem(valueOf, str7, str8, str9);
                    dYAELocalMaterialItem.p(num != 0 ? num.intValue() : -1);
                    dYAELocalMaterialItem.o(num2 != 0 ? num2.intValue() : -1);
                    arrayList.add(dYAELocalMaterialItem);
                    i3 = i17;
                }
                i16++;
                str4 = null;
            }
            return arrayList;
        } finally {
        }
    }

    @Override // com.tencent.aelight.camera.download.a
    public void onDownloadFinish(final AEMaterialMetaData info, final boolean isUsable, int resCode) {
        if (info == null) {
            return;
        }
        ms.a.a("AECosmeticProviderView", "material download finish, id = " + info.f69050id + ", isUsable = " + isUsable + ", resCode = " + resCode);
        info.downloading = false;
        info.downloadProgress = 0;
        info.usable = isUsable;
        post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.w
            @Override // java.lang.Runnable
            public final void run() {
                LSCosmeticsProviderView.u(isUsable, this, info);
            }
        });
    }

    @Override // com.tencent.aelight.camera.download.a
    public void onProgressUpdate(final AEMaterialMetaData info, final int progress) {
        if (info == null) {
            return;
        }
        ms.a.a("AECosmeticProviderView", "material download update id = " + info.f69050id + ", progress = " + progress);
        post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.v
            @Override // java.lang.Runnable
            public final void run() {
                LSCosmeticsProviderView.v(AEMaterialMetaData.this, progress, this);
            }
        });
    }

    public final void w() {
    }
}
