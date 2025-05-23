package com.tencent.mobileqq.wink.newalbum.debug;

import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.debug.panel.WinkNewAlbumDebugPanelFragment;
import com.tencent.mobileqq.wink.newalbum.debug.panel.WinkNewAlbumDebugPanelViewModel;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumProcessorManager;
import com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor;
import com.tencent.mobileqq.wink.newalbum.resmanager.WinkNewAlbumResFetchResult;
import com.tencent.mobileqq.wink.newalbum.resmanager.WinkNewAlbumResManager;
import com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig.WinkNewAlbumTextFeatureManager;
import com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig.WinkNewAlbumTextFetchResult;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.weclip.LoadModelTYPE;
import com.tencent.weclip.WeClip;
import cooperation.peak.PeakConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s83.WinkNewAlbumConfigInfo;
import s83.WinkNewAlbumFeatureConfigInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/debug/t;", "Lp53/b;", "", "initData", "N9", "M9", "P9", "K9", "J9", "L9", "O9", "H9", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "filePath", "Z9", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyleView", "Lcom/tencent/biz/qqcircle/debug/c;", "e", "Lcom/tencent/biz/qqcircle/debug/c;", "mAdapter", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "f", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getMLayoutManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setMLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "mLayoutManager", "<init>", "()V", tl.h.F, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class t extends p53.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView mRecyleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.debug.c mAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView.LayoutManager mLayoutManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/newalbum/debug/t$b", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/a;", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/WinkNewAlbumResFetchResult;", "result", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements com.tencent.mobileqq.wink.newalbum.resmanager.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.newalbum.resmanager.a
        public void a(@NotNull WinkNewAlbumResFetchResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("WinkNewAlbumDebugPart", 1, "doClip, onResReady, result:" + result);
            System.load(r83.a.WECLIP_MODEL_PATH + "libomp.so");
            System.load(result.getSoLibCryptoPath());
            System.load(result.getSoLibSslPath());
            System.load(result.getSoLibNcnnPath());
            System.load(result.getSoLibWeClipPath());
            String str = r83.a.f430945a.b() + "/scaledres/";
            WeClip weClip = new WeClip();
            weClip.e(4, true, 0, 1011, result.getIvStr(), result.getKeyStr());
            weClip.f(result.getModelNcnnParamPath(), result.getModelNcnnBinPath(), LoadModelTYPE.LoadOriginEncryptedFile);
            String arrays = Arrays.toString(weClip.h(com.tencent.mobileqq.wink.utils.f.c(str + "a.PNG")));
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            QLog.d("WinkNewAlbumDebugPart", 1, "doClip, result:" + arrays);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/newalbum/debug/t$c", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/a;", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/WinkNewAlbumResFetchResult;", "result", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements com.tencent.mobileqq.wink.newalbum.resmanager.a {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.newalbum.resmanager.a
        public void a(@NotNull WinkNewAlbumResFetchResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ToastUtil.a().e("\u8d44\u6e90\u4e0b\u8f7d\u6210\u529f");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/newalbum/debug/t$d", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/albumconfig/a;", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/albumconfig/WinkNewAlbumTextFetchResult;", "result", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig.a {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig.a
        public void a(@NotNull WinkNewAlbumTextFetchResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            String jsonString = FileUtils.readFileToString(new File(result.getClipMemoryInfoJSONPath()));
            WinkNewAlbumConfigInfo.Companion companion = WinkNewAlbumConfigInfo.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonString, "jsonString");
            List<WinkNewAlbumConfigInfo> a16 = companion.a(jsonString);
            WinkNewAlbumFeatureConfigInfo.INSTANCE.a(t.this.Z9(result.getClipTextFeatureJSONPath()));
            int size = a16.size();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(size);
            QLog.d("WinkNewAlbumDebugPart", 1, sb5.toString());
        }
    }

    private final void H9() {
        WinkNewAlbumDatabaseImp.r();
        WinkNewAlbumDatabaseImp.q();
    }

    private final void I9() {
        new WinkNewAlbumDatabaseImp().p();
    }

    private final void J9() {
        WinkNewAlbumResManager.f324315d.c(new b());
    }

    private final void K9() {
        WinkNewAlbumResManager winkNewAlbumResManager = WinkNewAlbumResManager.f324315d;
        winkNewAlbumResManager.g();
        winkNewAlbumResManager.c(new c());
    }

    private final void L9() {
        WinkNewAlbumProcessorManager.f324234a.i();
    }

    private final void M9() {
        new WinkNewAlbumMediaScanProcessor(null, "").start();
    }

    private final void N9() {
        WinkNewAlbumDebugPanelViewModel c16 = u83.a.INSTANCE.c(new WinkNewMemoryAlbumResult());
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(getContext(), QQWinkActivity.class);
        intent.putExtra("public_fragment_class", WinkNewAlbumDebugPanelFragment.class.getName());
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, getActivity().getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID));
        intent.putExtra("result", c16);
        getContext().startActivity(intent);
    }

    private final void O9() {
        WinkNewAlbumProcessorManager.f324234a.b();
    }

    private final void P9() {
        WinkNewAlbumTextFeatureManager winkNewAlbumTextFeatureManager = WinkNewAlbumTextFeatureManager.f324317d;
        winkNewAlbumTextFeatureManager.g();
        winkNewAlbumTextFeatureManager.c(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(t this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(t this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(t this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(t this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(t this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(t this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(t this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(t this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(t this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initData() {
        com.tencent.biz.qqcircle.debug.c cVar = this.mAdapter;
        Intrinsics.checkNotNull(cVar);
        cVar.addData(new j());
        com.tencent.biz.qqcircle.debug.c cVar2 = this.mAdapter;
        Intrinsics.checkNotNull(cVar2);
        cVar2.addData(new g());
        com.tencent.biz.qqcircle.debug.c cVar3 = this.mAdapter;
        Intrinsics.checkNotNull(cVar3);
        cVar3.addData(new v());
        com.tencent.biz.qqcircle.debug.c cVar4 = this.mAdapter;
        Intrinsics.checkNotNull(cVar4);
        cVar4.addData(new f());
        com.tencent.biz.qqcircle.debug.c cVar5 = this.mAdapter;
        Intrinsics.checkNotNull(cVar5);
        cVar5.addData(new i());
        com.tencent.biz.qqcircle.debug.c cVar6 = this.mAdapter;
        Intrinsics.checkNotNull(cVar6);
        cVar6.addData(new h());
        com.tencent.biz.qqcircle.debug.c cVar7 = this.mAdapter;
        Intrinsics.checkNotNull(cVar7);
        cVar7.addData(new u());
    }

    @NotNull
    public final String Z9(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        StringBuilder sb5 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb5.append(readLine);
            } else {
                bufferedReader.close();
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
                return sb6;
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RecyclerView recyclerView;
        super.onInitView(rootView);
        if (rootView != null) {
            rootView.findViewById(R.id.f164683th0).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.Q9(t.this, view);
                }
            });
            rootView.findViewById(R.id.te_).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.R9(t.this, view);
                }
            });
            rootView.findViewById(R.id.tea).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.S9(t.this, view);
                }
            });
            rootView.findViewById(R.id.the).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.T9(t.this, view);
                }
            });
            rootView.findViewById(R.id.thh).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.U9(t.this, view);
                }
            });
            rootView.findViewById(R.id.th9).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.V9(t.this, view);
                }
            });
            rootView.findViewById(R.id.tfg).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.W9(t.this, view);
                }
            });
            rootView.findViewById(R.id.tda).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.X9(t.this, view);
                }
            });
            rootView.findViewById(R.id.tdd).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.Y9(t.this, view);
                }
            });
        }
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.uev);
        } else {
            recyclerView = null;
        }
        this.mRecyleView = recyclerView;
        this.mLayoutManager = new SafeLinearLayoutManager(getContext(), 1, false);
        RecyclerView recyclerView2 = this.mRecyleView;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setLayoutManager(this.mLayoutManager);
        this.mAdapter = new com.tencent.biz.qqcircle.debug.c();
        initData();
        RecyclerView recyclerView3 = this.mRecyleView;
        Intrinsics.checkNotNull(recyclerView3);
        recyclerView3.setAdapter(this.mAdapter);
    }
}
