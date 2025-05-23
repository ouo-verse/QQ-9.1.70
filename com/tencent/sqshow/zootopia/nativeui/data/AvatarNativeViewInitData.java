package com.tencent.sqshow.zootopia.nativeui.data;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.nativeui.ue.aa;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m94.DressControllerInitData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u00c9\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010)\u001a\u00020\u0006\u0012\b\b\u0002\u0010/\u001a\u00020\u0004\u0012\b\b\u0002\u00102\u001a\u00020\u0004\u0012\b\b\u0002\u00105\u001a\u00020\u0004\u0012\b\b\u0002\u0010;\u001a\u00020\t\u0012\b\b\u0002\u0010?\u001a\u00020\u0006\u0012\b\b\u0002\u0010G\u001a\u00020@\u0012\b\b\u0002\u0010K\u001a\u00020\t\u0012\b\b\u0002\u0010Q\u001a\u00020L\u0012\b\b\u0002\u0010W\u001a\u00020R\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010X\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010^\u0012\b\b\u0002\u0010h\u001a\u00020e\u0012\b\b\u0002\u0010l\u001a\u00020i\u0012\b\b\u0002\u0010p\u001a\u00020m\u00a2\u0006\u0004\bq\u0010rJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u0012\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b\u0018\u0010,\"\u0004\b-\u0010.R\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010+\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\"\u00105\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010+\u001a\u0004\b\f\u0010,\"\u0004\b4\u0010.R\"\u0010;\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010?\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010$\u001a\u0004\b=\u0010&\"\u0004\b>\u0010(R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010K\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u00106\u001a\u0004\bI\u00108\"\u0004\bJ\u0010:R\"\u0010Q\u001a\u00020L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010M\u001a\u0004\b#\u0010N\"\u0004\bO\u0010PR\"\u0010W\u001a\u00020R8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010S\u001a\u0004\b3\u0010T\"\u0004\bU\u0010VR$\u0010]\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010Y\u001a\u0004\bA\u0010Z\"\u0004\b[\u0010\\R$\u0010d\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\bH\u0010a\"\u0004\bb\u0010cR\u0017\u0010h\u001a\u00020e8\u0006\u00a2\u0006\f\n\u0004\bI\u0010f\u001a\u0004\b_\u0010gR\u0017\u0010l\u001a\u00020i8\u0006\u00a2\u0006\f\n\u0004\bC\u0010j\u001a\u0004\b*\u0010kR\u0017\u0010p\u001a\u00020m8\u0006\u00a2\u0006\f\n\u0004\b4\u0010n\u001a\u0004\b<\u0010o\u00a8\u0006s"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/i;", "", "Lm94/d;", "D", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/lifecycle/LifecycleOwner;", "a", "Landroidx/lifecycle/LifecycleOwner;", "i", "()Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroid/app/Activity;", "b", "Landroid/app/Activity;", "d", "()Landroid/app/Activity;", "context", "Lcom/tencent/sqshow/zootopia/nativeui/data/o;", "c", "Lcom/tencent/sqshow/zootopia/nativeui/data/o;", "g", "()Lcom/tencent/sqshow/zootopia/nativeui/data/o;", "listener", "Lb94/c;", "Lb94/c;", "()Lb94/c;", "t", "(Lb94/c;)V", "backHandler", "e", "I", "getPanelInitState", "()I", "setPanelInitState", "(I)V", "panelInitState", "f", "Ljava/lang/String;", "()Ljava/lang/String;", "u", "(Ljava/lang/String;)V", "branchId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", "schemeParams", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "actionParams", "Z", DomainData.DOMAIN_NAME, "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Z)V", "skipReqDataOnInit", "j", "o", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "source", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "k", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "r", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "zootopiaSource", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "B", "withoutUi", "Lb94/a;", "Lb94/a;", "()Lb94/a;", "v", "(Lb94/a;)V", "engineApi", "Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeViewMode;", "Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeViewMode;", "()Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeViewMode;", "w", "(Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeViewMode;)V", "nativeViewMode", "La84/a;", "La84/a;", "()La84/a;", "setSceneComponentAvatar", "(La84/a;)V", "sceneComponentAvatar", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;", "p", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;", "()Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;", HippyTKDListViewAdapter.X, "(Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;)V", "sceneComponentAvatarV2", "Lcom/tencent/sqshow/zootopia/nativeui/data/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/h;", "()Lcom/tencent/sqshow/zootopia/nativeui/data/h;", "uiParam", "Lcom/tencent/sqshow/zootopia/nativeui/data/f;", "Lcom/tencent/sqshow/zootopia/nativeui/data/f;", "()Lcom/tencent/sqshow/zootopia/nativeui/data/f;", "interactParam", "Lcom/tencent/sqshow/zootopia/nativeui/data/g;", "Lcom/tencent/sqshow/zootopia/nativeui/data/g;", "()Lcom/tencent/sqshow/zootopia/nativeui/data/g;", "reportParam", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Landroid/app/Activity;Lcom/tencent/sqshow/zootopia/nativeui/data/o;Lb94/c;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILcom/tencent/mobileqq/zootopia/ZootopiaSource;ZLb94/a;Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeViewMode;La84/a;Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;Lcom/tencent/sqshow/zootopia/nativeui/data/h;Lcom/tencent/sqshow/zootopia/nativeui/data/f;Lcom/tencent/sqshow/zootopia/nativeui/data/g;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.nativeui.data.i, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class AvatarNativeViewInitData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final LifecycleOwner owner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final Activity context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final o listener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private b94.c backHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int panelInitState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String branchId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private String schemeParams;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String actionParams;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean skipReqDataOnInit;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int source;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaSource zootopiaSource;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean withoutUi;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private b94.a engineApi;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private AvatarNativeViewMode nativeViewMode;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private a84.a sceneComponentAvatar;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private com.tencent.sqshow.zootopia.recommend.characterV2.component.a sceneComponentAvatarV2;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private final h uiParam;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private final f interactParam;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private final g reportParam;

    public AvatarNativeViewInitData(LifecycleOwner owner, Activity context, o oVar, b94.c cVar, int i3, String branchId, String schemeParams, String actionParams, boolean z16, int i16, ZootopiaSource zootopiaSource, boolean z17, b94.a engineApi, AvatarNativeViewMode nativeViewMode, a84.a aVar, com.tencent.sqshow.zootopia.recommend.characterV2.component.a aVar2, h uiParam, f interactParam, g reportParam) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(branchId, "branchId");
        Intrinsics.checkNotNullParameter(schemeParams, "schemeParams");
        Intrinsics.checkNotNullParameter(actionParams, "actionParams");
        Intrinsics.checkNotNullParameter(zootopiaSource, "zootopiaSource");
        Intrinsics.checkNotNullParameter(engineApi, "engineApi");
        Intrinsics.checkNotNullParameter(nativeViewMode, "nativeViewMode");
        Intrinsics.checkNotNullParameter(uiParam, "uiParam");
        Intrinsics.checkNotNullParameter(interactParam, "interactParam");
        Intrinsics.checkNotNullParameter(reportParam, "reportParam");
        this.owner = owner;
        this.context = context;
        this.listener = oVar;
        this.backHandler = cVar;
        this.panelInitState = i3;
        this.branchId = branchId;
        this.schemeParams = schemeParams;
        this.actionParams = actionParams;
        this.skipReqDataOnInit = z16;
        this.source = i16;
        this.zootopiaSource = zootopiaSource;
        this.withoutUi = z17;
        this.engineApi = engineApi;
        this.nativeViewMode = nativeViewMode;
        this.sceneComponentAvatar = aVar;
        this.sceneComponentAvatarV2 = aVar2;
        this.uiParam = uiParam;
        this.interactParam = interactParam;
        this.reportParam = reportParam;
    }

    public final void A(int i3) {
        this.source = i3;
    }

    public final void B(boolean z16) {
        this.withoutUi = z16;
    }

    public final void C(ZootopiaSource zootopiaSource) {
        Intrinsics.checkNotNullParameter(zootopiaSource, "<set-?>");
        this.zootopiaSource = zootopiaSource;
    }

    public final DressControllerInitData D() {
        return new DressControllerInitData(this.branchId, this.schemeParams, this.zootopiaSource, this.source, this.engineApi);
    }

    /* renamed from: a, reason: from getter */
    public final String getActionParams() {
        return this.actionParams;
    }

    /* renamed from: b, reason: from getter */
    public final b94.c getBackHandler() {
        return this.backHandler;
    }

    /* renamed from: c, reason: from getter */
    public final String getBranchId() {
        return this.branchId;
    }

    /* renamed from: d, reason: from getter */
    public final Activity getContext() {
        return this.context;
    }

    /* renamed from: e, reason: from getter */
    public final b94.a getEngineApi() {
        return this.engineApi;
    }

    /* renamed from: f, reason: from getter */
    public final f getInteractParam() {
        return this.interactParam;
    }

    /* renamed from: g, reason: from getter */
    public final o getListener() {
        return this.listener;
    }

    /* renamed from: h, reason: from getter */
    public final AvatarNativeViewMode getNativeViewMode() {
        return this.nativeViewMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.owner.hashCode() * 31) + this.context.hashCode()) * 31;
        o oVar = this.listener;
        int hashCode2 = (hashCode + (oVar == null ? 0 : oVar.hashCode())) * 31;
        b94.c cVar = this.backHandler;
        int hashCode3 = (((((((((hashCode2 + (cVar == null ? 0 : cVar.hashCode())) * 31) + this.panelInitState) * 31) + this.branchId.hashCode()) * 31) + this.schemeParams.hashCode()) * 31) + this.actionParams.hashCode()) * 31;
        boolean z16 = this.skipReqDataOnInit;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode4 = (((((hashCode3 + i3) * 31) + this.source) * 31) + this.zootopiaSource.hashCode()) * 31;
        boolean z17 = this.withoutUi;
        int hashCode5 = (((((hashCode4 + (z17 ? 1 : z17 ? 1 : 0)) * 31) + this.engineApi.hashCode()) * 31) + this.nativeViewMode.hashCode()) * 31;
        a84.a aVar = this.sceneComponentAvatar;
        int hashCode6 = (hashCode5 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        com.tencent.sqshow.zootopia.recommend.characterV2.component.a aVar2 = this.sceneComponentAvatarV2;
        return ((((((hashCode6 + (aVar2 != null ? aVar2.hashCode() : 0)) * 31) + this.uiParam.hashCode()) * 31) + this.interactParam.hashCode()) * 31) + this.reportParam.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final LifecycleOwner getOwner() {
        return this.owner;
    }

    /* renamed from: j, reason: from getter */
    public final g getReportParam() {
        return this.reportParam;
    }

    /* renamed from: k, reason: from getter */
    public final a84.a getSceneComponentAvatar() {
        return this.sceneComponentAvatar;
    }

    /* renamed from: l, reason: from getter */
    public final com.tencent.sqshow.zootopia.recommend.characterV2.component.a getSceneComponentAvatarV2() {
        return this.sceneComponentAvatarV2;
    }

    /* renamed from: m, reason: from getter */
    public final String getSchemeParams() {
        return this.schemeParams;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getSkipReqDataOnInit() {
        return this.skipReqDataOnInit;
    }

    /* renamed from: o, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    /* renamed from: p, reason: from getter */
    public final h getUiParam() {
        return this.uiParam;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getWithoutUi() {
        return this.withoutUi;
    }

    /* renamed from: r, reason: from getter */
    public final ZootopiaSource getZootopiaSource() {
        return this.zootopiaSource;
    }

    public final void s(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.actionParams = str;
    }

    public final void t(b94.c cVar) {
        this.backHandler = cVar;
    }

    public final void u(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.branchId = str;
    }

    public final void v(b94.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.engineApi = aVar;
    }

    public final void w(AvatarNativeViewMode avatarNativeViewMode) {
        Intrinsics.checkNotNullParameter(avatarNativeViewMode, "<set-?>");
        this.nativeViewMode = avatarNativeViewMode;
    }

    public final void x(com.tencent.sqshow.zootopia.recommend.characterV2.component.a aVar) {
        this.sceneComponentAvatarV2 = aVar;
    }

    public final void y(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schemeParams = str;
    }

    public final void z(boolean z16) {
        this.skipReqDataOnInit = z16;
    }

    public String toString() {
        return "AvatarNativeViewInitData(owner=" + this.owner + ", context=" + this.context + ", listener=" + this.listener + ", backHandler=" + this.backHandler + ", panelInitState=" + this.panelInitState + ", branchId=" + this.branchId + ", schemeParams=" + this.schemeParams + ", actionParams=" + this.actionParams + ", skipReqDataOnInit=" + this.skipReqDataOnInit + ", source=" + this.source + ", zootopiaSource=" + this.zootopiaSource + ", withoutUi=" + this.withoutUi + ", engineApi=" + this.engineApi + ", nativeViewMode=" + this.nativeViewMode + ", sceneComponentAvatar=" + this.sceneComponentAvatar + ", sceneComponentAvatarV2=" + this.sceneComponentAvatarV2 + ", uiParam=" + this.uiParam + ", interactParam=" + this.interactParam + ", reportParam=" + this.reportParam + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarNativeViewInitData)) {
            return false;
        }
        AvatarNativeViewInitData avatarNativeViewInitData = (AvatarNativeViewInitData) other;
        return Intrinsics.areEqual(this.owner, avatarNativeViewInitData.owner) && Intrinsics.areEqual(this.context, avatarNativeViewInitData.context) && Intrinsics.areEqual(this.listener, avatarNativeViewInitData.listener) && Intrinsics.areEqual(this.backHandler, avatarNativeViewInitData.backHandler) && this.panelInitState == avatarNativeViewInitData.panelInitState && Intrinsics.areEqual(this.branchId, avatarNativeViewInitData.branchId) && Intrinsics.areEqual(this.schemeParams, avatarNativeViewInitData.schemeParams) && Intrinsics.areEqual(this.actionParams, avatarNativeViewInitData.actionParams) && this.skipReqDataOnInit == avatarNativeViewInitData.skipReqDataOnInit && this.source == avatarNativeViewInitData.source && Intrinsics.areEqual(this.zootopiaSource, avatarNativeViewInitData.zootopiaSource) && this.withoutUi == avatarNativeViewInitData.withoutUi && Intrinsics.areEqual(this.engineApi, avatarNativeViewInitData.engineApi) && this.nativeViewMode == avatarNativeViewInitData.nativeViewMode && Intrinsics.areEqual(this.sceneComponentAvatar, avatarNativeViewInitData.sceneComponentAvatar) && Intrinsics.areEqual(this.sceneComponentAvatarV2, avatarNativeViewInitData.sceneComponentAvatarV2) && Intrinsics.areEqual(this.uiParam, avatarNativeViewInitData.uiParam) && Intrinsics.areEqual(this.interactParam, avatarNativeViewInitData.interactParam) && Intrinsics.areEqual(this.reportParam, avatarNativeViewInitData.reportParam);
    }

    public /* synthetic */ AvatarNativeViewInitData(LifecycleOwner lifecycleOwner, Activity activity, o oVar, b94.c cVar, int i3, String str, String str2, String str3, boolean z16, int i16, ZootopiaSource zootopiaSource, boolean z17, b94.a aVar, AvatarNativeViewMode avatarNativeViewMode, a84.a aVar2, com.tencent.sqshow.zootopia.recommend.characterV2.component.a aVar3, h hVar, f fVar, g gVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycleOwner, activity, (i17 & 4) != 0 ? null : oVar, (i17 & 8) != 0 ? null : cVar, (i17 & 16) != 0 ? 2 : i3, (i17 & 32) != 0 ? "" : str, (i17 & 64) != 0 ? "" : str2, (i17 & 128) != 0 ? "" : str3, (i17 & 256) != 0 ? false : z16, (i17 & 512) != 0 ? 0 : i16, (i17 & 1024) != 0 ? ZootopiaSource.INSTANCE.i() : zootopiaSource, (i17 & 2048) != 0 ? false : z17, (i17 & 4096) != 0 ? aa.f371327d : aVar, (i17 & 8192) != 0 ? AvatarNativeViewMode.NORMAL : avatarNativeViewMode, (i17 & 16384) != 0 ? null : aVar2, (32768 & i17) != 0 ? null : aVar3, (65536 & i17) != 0 ? new h() : hVar, (131072 & i17) != 0 ? new f() : fVar, (i17 & 262144) != 0 ? new g() : gVar);
    }
}
