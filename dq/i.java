package dq;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.camera.ui.panel.bz;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.flashshow.ab;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001DB\u001f\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00103\u001a\u000200\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0014\u0010\u0011\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fJ\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004J\"\u0010%\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0014H\u0016J\u001a\u0010'\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u0014H\u0016R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010?\u00a8\u0006E"}, d2 = {"Ldq/i;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bz;", "Lcom/tencent/aelight/camera/download/a;", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "info", "", "G", "v", WadlProxyConsts.KEY_MATERIAL, BdhLogUtil.LogTag.Tag_Conn, "w", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "category", "K", "", "list", "L", "Landroid/view/ViewGroup;", "viewGroup", "", "viewType", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "viewHolder", "position", HippyTKDListViewAdapter.X, "holder", "E", UserInfo.SEX_FEMALE, "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "onDetachedFromRecyclerView", "getItemCount", "I", "", "isSuccess", "resCode", "onDownloadFinish", "progress", "onProgressUpdate", "Landroid/content/Context;", "d", "Landroid/content/Context;", "mContext", "Ldq/b;", "e", "Ldq/b;", "mRepository", "Ldq/a;", "f", "Ldq/a;", "mEnvironment", tl.h.F, "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "mCategory", "i", "Ljava/util/List;", "mTemplateList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "mLastMaterial", "Ljava/util/HashSet;", "", "Ljava/util/HashSet;", "mPendingReportMaterialIds", "<init>", "(Landroid/content/Context;Ldq/b;Ldq/a;)V", "D", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i extends RecyclerView.Adapter<bz> implements com.tencent.aelight.camera.download.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final HashSet<String> mPendingReportMaterialIds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b mRepository;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final a mEnvironment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AEMaterialCategory mCategory;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<? extends AEMaterialMetaData> mTemplateList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private AEMaterialMetaData mLastMaterial;

    public i(Context mContext, b mRepository, a mEnvironment) {
        List<? extends AEMaterialMetaData> emptyList;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mRepository, "mRepository");
        Intrinsics.checkNotNullParameter(mEnvironment, "mEnvironment");
        this.mContext = mContext;
        this.mRepository = mRepository;
        this.mEnvironment = mEnvironment;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mTemplateList = emptyList;
        this.mPendingReportMaterialIds = new HashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(i this$0, AEMaterialMetaData aEMaterialMetaData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!Intrinsics.areEqual(this$0.mLastMaterial, aEMaterialMetaData)) {
            AEMaterialMetaData aEMaterialMetaData2 = this$0.mLastMaterial;
            ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "last chosen material [" + (aEMaterialMetaData2 != null ? aEMaterialMetaData2.f69050id : null) + "] is not the download material");
            this$0.notifyDataSetChanged();
            return;
        }
        String d16 = this$0.mRepository.d();
        if (!Intrinsics.areEqual(d16, aEMaterialMetaData.f69050id)) {
            ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "last select materail [" + d16 + "] is not the download material");
            this$0.notifyDataSetChanged();
            return;
        }
        if (this$0.mEnvironment.a()) {
            ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "onDownloadFinish but is capturing, just refresh UI");
            this$0.notifyDataSetChanged();
        } else if (!this$0.mEnvironment.b()) {
            ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "onDownloadFinish but is not resume, just refresh UI");
            this$0.notifyDataSetChanged();
        } else {
            this$0.mRepository.a(aEMaterialMetaData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.mContext, HardCodeUtil.qqStr(R.string.qdx), 0).show();
    }

    private final void C(AEMaterialMetaData material) {
        AEMaterialCategory aEMaterialCategory = this.mCategory;
        String str = aEMaterialCategory != null ? aEMaterialCategory.f69047h : null;
        ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "onMaterialClicked, categoryname = [" + str + "], materialid = [" + material.f69050id + "]");
        if (!Intrinsics.areEqual(this.mLastMaterial, material)) {
            AEMaterialMetaData aEMaterialMetaData = this.mLastMaterial;
            if (aEMaterialMetaData != null) {
                aEMaterialMetaData.ischoose = false;
            }
            if (aEMaterialMetaData != null) {
                aEMaterialMetaData.isdoubleclick = false;
            }
        }
        if (material.ischoose) {
            material.isdoubleclick = true;
        }
        material.ischoose = true;
        I(material);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(i this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyItemChanged(i3, 1);
    }

    private final void G(final AEMaterialMetaData info) {
        this.mPendingReportMaterialIds.add(info.f69050id);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: dq.g
            @Override // java.lang.Runnable
            public final void run() {
                i.H(i.this, info);
            }
        }, 16, null, true, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(i this$0, AEMaterialMetaData info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        if (this$0.mPendingReportMaterialIds.contains(info.f69050id)) {
            ms.a.a("AEBottomPanelPart_AENewMaterialAdapter", "delay report expose for " + info.f69050id);
            com.tencent.aelight.camera.ae.report.b.b().H0(info.f69050id, info.sysRaceId, info.sysRaceLevel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J() {
        ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "use material failed because of so load failed");
        if (com.tencent.aelight.camera.ae.d.j()) {
            com.tencent.aelight.camera.ae.d.u();
        }
    }

    private final void v(AEMaterialMetaData info) {
        this.mPendingReportMaterialIds.remove(info.f69050id);
    }

    private final void w(AEMaterialMetaData material) {
        if (material.downloading || TextUtils.isEmpty(material.f69050id)) {
            return;
        }
        this.mRepository.e(material, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(i this$0, AEMaterialMetaData material, View it) {
        Map<String, ?> mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(material, "$material");
        AEMaterialMetaData b16 = this$0.mRepository.b();
        this$0.mLastMaterial = b16;
        if (Intrinsics.areEqual(b16 != null ? b16.f69050id : null, material.f69050id)) {
            AEMaterialMetaData aEMaterialMetaData = this$0.mLastMaterial;
            if (!(aEMaterialMetaData != null && aEMaterialMetaData.editablewatermark)) {
                AEMaterialMetaData MATERIAL_NONE = AEMaterialMetaData.MATERIAL_NONE;
                Intrinsics.checkNotNullExpressionValue(MATERIAL_NONE, "MATERIAL_NONE");
                this$0.C(MATERIAL_NONE);
                return;
            }
        }
        this$0.C(material);
        vq.a aVar = vq.a.f443174a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        String str = material.f69050id;
        Intrinsics.checkNotNullExpressionValue(str, "material.id");
        aVar.c(it, "em_ae_motion_item", str);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("ae_motion_name", material.f69050id), TuplesKt.to("ae_props_category", material.firstcategoryname));
        aVar.a(it, mapOf);
    }

    public final void I(AEMaterialMetaData material) {
        Intrinsics.checkNotNullParameter(material, "material");
        AEBaseReportParam.U().j1(material.recommendReason);
        AEBaseReportParam.U().a(material.f69050id);
        Iterator<? extends AEMaterialMetaData> it = this.mTemplateList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else {
                if (Intrinsics.areEqual(material.f69050id, it.next().f69050id)) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        AEBaseReportParam.U().R0(i3 + 1);
        AEBaseReportParam U = AEBaseReportParam.U();
        AEMaterialCategory aEMaterialCategory = this.mCategory;
        U.S0(aEMaterialCategory != null ? aEMaterialCategory.f69047h : null);
        AEBaseReportParam.U().Q0("1");
        AEBaseReportParam.U().T0(0);
        com.tencent.aelight.camera.ae.report.b.b().L0(material.f69050id);
        ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "\u3010Select Material\u3011\uff1a" + material.f69050id);
        ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "\u3010Select Material\u3011Usable :" + material.usable);
        this.mLastMaterial = material;
        String str = material.f69050id;
        if (!(str == null || str.length() == 0) && !AEMaterialMetaData.isNoneMaterial(material)) {
            ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "### [material panel] select material id = " + material.f69050id);
            if (material.isWsBanner()) {
                com.tencent.biz.qqstory.utils.l.g(this.mContext, material, 1);
                return;
            }
            if (!material.usable) {
                this.mRepository.c(material.f69050id);
                w(material);
                return;
            } else {
                if (!AEResUtil.R()) {
                    QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.qdv), 0).show();
                    ThreadManagerV2.excute(new Runnable() { // from class: dq.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.J();
                        }
                    }, 64, null, true);
                    return;
                }
                ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "### [material panel] select material " + material.f69050id);
                this.mRepository.a(material);
                return;
            }
        }
        ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "### [material panel] select material none");
        Context context = this.mContext;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context).getIntent().removeExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
        this.mRepository.a(material);
    }

    public final void K(AEMaterialCategory category) {
        this.mCategory = category;
    }

    public final void L(List<? extends AEMaterialMetaData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mTemplateList = new ArrayList(list);
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mTemplateList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        ms.a.a("AEBottomPanelPart_AENewMaterialAdapter", "onDetachedFromRecyclerView");
        this.mPendingReportMaterialIds.clear();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(bz viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final AEMaterialMetaData aEMaterialMetaData = this.mTemplateList.get(position);
        AEMaterialMetaData b16 = this.mRepository.b();
        String str = b16 != null ? b16.f69050id : null;
        if (aEMaterialMetaData.usable && Intrinsics.areEqual(aEMaterialMetaData.f69050id, str)) {
            ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "update selected material: " + aEMaterialMetaData.f69050id);
            viewHolder.e(2, aEMaterialMetaData);
        } else {
            aEMaterialMetaData.editablewatermark = false;
            viewHolder.e(1, aEMaterialMetaData);
        }
        VideoReport.setElementReuseIdentifier(viewHolder.itemView, aEMaterialMetaData.f69050id);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: dq.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.y(i.this, aEMaterialMetaData, view);
            }
        });
        vq.a aVar = vq.a.f443174a;
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        aVar.b(view, "em_ae_motion_item");
        VideoReport.setElementId(viewHolder.itemView, "em_xsj_props_item");
        HashMap hashMap = new HashMap();
        hashMap.putAll(ab.c().g());
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME, aEMaterialMetaData.f69050id);
        AEMaterialCategory aEMaterialCategory = this.mCategory;
        String str2 = aEMaterialCategory != null ? aEMaterialCategory.f69047h : null;
        if (str2 == null) {
            str2 = "none";
        }
        hashMap.put("xsj_props_category", str2);
        VideoReport.setElementParams(viewHolder.itemView, hashMap);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public bz onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        bz bzVar = new bz(LayoutInflater.from(this.mContext).inflate(R.layout.f167493dm2, viewGroup, false));
        bzVar.c(this.mContext);
        return bzVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(bz holder) {
        int adapterPosition;
        if (holder == null || (adapterPosition = holder.getAdapterPosition()) == -1) {
            return;
        }
        AEMaterialMetaData aEMaterialMetaData = this.mTemplateList.get(adapterPosition);
        ms.a.a("AEBottomPanelPart_AENewMaterialAdapter", "onViewAttachedToWindow---position=" + adapterPosition + ", material=" + (aEMaterialMetaData != null ? aEMaterialMetaData.f69050id : null));
        if (aEMaterialMetaData != null) {
            G(aEMaterialMetaData);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(bz holder) {
        int adapterPosition;
        if (holder == null || (adapterPosition = holder.getAdapterPosition()) == -1) {
            return;
        }
        AEMaterialMetaData aEMaterialMetaData = this.mTemplateList.get(adapterPosition);
        ms.a.a("AEBottomPanelPart_AENewMaterialAdapter", "onViewDetachedFromWindow---position=" + adapterPosition + ", material=" + (aEMaterialMetaData != null ? aEMaterialMetaData.f69050id : null));
        if (aEMaterialMetaData != null) {
            v(aEMaterialMetaData);
        }
    }

    @Override // com.tencent.aelight.camera.download.a
    public void onDownloadFinish(AEMaterialMetaData info, boolean isSuccess, int resCode) {
        List listOf;
        if (info == null) {
            return;
        }
        ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "material [" + info.f69050id + "] download finish, success = " + isSuccess + ", resCode = " + resCode);
        Object obj = null;
        if (!isSuccess) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: dq.d
                @Override // java.lang.Runnable
                public final void run() {
                    i.B(i.this);
                }
            });
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{info.f69050id, info.resurl, String.valueOf(resCode)});
            com.tencent.aelight.camera.report.atta.d.d("motion_down_failed", listOf, null);
            return;
        }
        Iterator<T> it = this.mTemplateList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((AEMaterialMetaData) next).f69050id, info.f69050id)) {
                obj = next;
                break;
            }
        }
        final AEMaterialMetaData aEMaterialMetaData = (AEMaterialMetaData) obj;
        if (aEMaterialMetaData == null) {
            ms.a.f("AEBottomPanelPart_AENewMaterialAdapter", "download material is not present in list anymore!");
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: dq.e
                @Override // java.lang.Runnable
                public final void run() {
                    i.A(i.this, aEMaterialMetaData);
                }
            });
        }
    }

    @Override // com.tencent.aelight.camera.download.a
    public void onProgressUpdate(AEMaterialMetaData info, int progress) {
        if (info == null) {
            return;
        }
        Iterator<? extends AEMaterialMetaData> it = this.mTemplateList.iterator();
        final int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (Intrinsics.areEqual(info.f69050id, it.next().f69050id)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: dq.f
                @Override // java.lang.Runnable
                public final void run() {
                    i.D(i.this, i3);
                }
            });
        }
    }
}
