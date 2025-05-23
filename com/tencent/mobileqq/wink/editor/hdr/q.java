package com.tencent.mobileqq.wink.editor.hdr;

import android.content.Context;
import android.content.DialogInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.pref.api.IPhoneConfig;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.export.u;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.MediaClip;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 J2\u00020\u0001:\u0002KLB\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\nJ\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010J&\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u001e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0010J\b\u0010\u001c\u001a\u00020\u0004H\u0014R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001f\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010$R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00100&8\u0006\u00a2\u0006\f\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*R\"\u00107\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u0010<\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00108\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00102\u001a\u0004\b:\u00104\"\u0004\b;\u00106R*\u0010@\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00108\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00102\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020B0A8\u0006\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/q;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Landroid/content/Context;", "context", "", SemanticAttributes.DbSystemValues.H2, "c2", "", "getLogTag", "g2", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "uiData", "b2", "R1", "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "winkEditorFragment", "", "isOnHiddenOption", "isChangedAfterCrop", "O1", "hasNewClip", "isBlur", "Z1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "isBlurAfterCrop", "W1", HippyControllerProps.BOOLEAN, "k2", "onCleared", "Lcom/tencent/mobileqq/wink/editor/hdr/EhanceWinkEditUIData;", "i", "Lcom/tencent/mobileqq/wink/editor/hdr/EhanceWinkEditUIData;", "draftUIData", "Landroidx/lifecycle/MutableLiveData;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_enhanceBubbleShow", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "enhanceBubbleShow", "D", "_applySharpenEnhance", "E", "Q1", "applySuperEnhance", UserInfo.SEX_FEMALE, "Z", "U1", "()Z", "f2", "(Z)V", "hdrIniting", "value", "G", "getEnhanceBubbleDialogRefused", "d2", "enhanceBubbleDialogRefused", "H", "T1", "e2", EhanceWinkEditUIData.enhanceBubbleShowed, "", "Lcom/tencent/mobileqq/wink/editor/hdr/q$b;", "I", "Ljava/util/List;", "getSuperResolutionPerformanceList", "()Ljava/util/List;", "superResolutionPerformanceList", "<init>", "()V", "J", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class q extends BaseViewModel {

    /* renamed from: C */
    @NotNull
    private final LiveData<Object> enhanceBubbleShow;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _applySharpenEnhance;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> applySuperEnhance;

    /* renamed from: F */
    private boolean hdrIniting;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean enhanceBubbleDialogRefused;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean com.tencent.mobileqq.wink.editor.hdr.EhanceWinkEditUIData.enhanceBubbleShowed java.lang.String;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final List<SuperResolutionPerformance> superResolutionPerformanceList;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private EhanceWinkEditUIData draftUIData = new EhanceWinkEditUIData(this);

    /* renamed from: m */
    @NotNull
    private final MutableLiveData<Object> _enhanceBubbleShow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001b\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/q$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "D", "c", "()D", "setTotalTime", "(D)V", "totalTime", "", "b", "J", "()J", "setCount", "(J)V", "count", "Ljava/lang/String;", "()Ljava/lang/String;", "height", "d", "width", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.hdr.q$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class SuperResolutionPerformance {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private double totalTime;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private long count;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        @NotNull
        private final String height;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        @NotNull
        private final String width;

        /* renamed from: a, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getHeight() {
            return this.height;
        }

        /* renamed from: c, reason: from getter */
        public final double getTotalTime() {
            return this.totalTime;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getWidth() {
            return this.width;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SuperResolutionPerformance)) {
                return false;
            }
            SuperResolutionPerformance superResolutionPerformance = (SuperResolutionPerformance) other;
            if (Double.compare(this.totalTime, superResolutionPerformance.totalTime) == 0 && this.count == superResolutionPerformance.count && Intrinsics.areEqual(this.height, superResolutionPerformance.height) && Intrinsics.areEqual(this.width, superResolutionPerformance.width)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((com.tencent.biz.qqcircle.comment.recpic.a.a(this.totalTime) * 31) + androidx.fragment.app.a.a(this.count)) * 31) + this.height.hashCode()) * 31) + this.width.hashCode();
        }

        @NotNull
        public String toString() {
            return "SuperResolutionPerformance(totalTime=" + this.totalTime + ", count=" + this.count + ", height=" + this.height + ", width=" + this.width + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/hdr/q$c", "Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRPicQualityDetectUtils$a;", "", "isBlur", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements WinkHDRPicQualityDetectUtils.a {

        /* renamed from: a */
        final /* synthetic */ WinkEditorFragment f320505a;

        /* renamed from: b */
        final /* synthetic */ boolean f320506b;

        /* renamed from: c */
        final /* synthetic */ q f320507c;

        /* renamed from: d */
        final /* synthetic */ boolean f320508d;

        c(WinkEditorFragment winkEditorFragment, boolean z16, q qVar, boolean z17) {
            this.f320505a = winkEditorFragment;
            this.f320506b = z16;
            this.f320507c = qVar;
            this.f320508d = z17;
        }

        @Override // com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils.a
        public void a(boolean isBlur) {
            w53.b.a("WinkEditorFragment", "detectMediaClipsDeblur isBlur:" + isBlur);
            if (this.f320505a.Hm()) {
                if (this.f320506b) {
                    this.f320507c.W1(this.f320505a, isBlur, this.f320508d);
                } else {
                    this.f320507c.g2();
                }
            }
        }
    }

    public q() {
        MutableLiveData<Object> mutableLiveData = new MutableLiveData<>();
        this._enhanceBubbleShow = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any?>");
        this.enhanceBubbleShow = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._applySharpenEnhance = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.applySuperEnhance = mutableLiveData2;
        this.superResolutionPerformanceList = new ArrayList();
    }

    public static /* synthetic */ void P1(q qVar, WinkEditorFragment winkEditorFragment, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        qVar.O1(winkEditorFragment, z16, z17);
    }

    public static final void X1(q this$0, WinkEditorFragment winkEditorFragment) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(winkEditorFragment, "$winkEditorFragment");
        this$0.h2(winkEditorFragment.getActivity());
    }

    private final void c2() {
        for (SuperResolutionPerformance superResolutionPerformance : this.superResolutionPerformanceList) {
            Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put("xsj_enhance_phone_level", Integer.valueOf(((IPhoneConfig) QRoute.api(IPhoneConfig.class)).getPhoneLevel()));
            map.put("sr_width", superResolutionPerformance.getWidth());
            map.put("sr_costtime", String.valueOf(superResolutionPerformance.getTotalTime() / superResolutionPerformance.getCount()));
            map.put("sr_height", superResolutionPerformance.getHeight());
            map.put("is_debug", Integer.valueOf(e.f320476a.b() ? 1 : 0));
            ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportWinkCommonEvents(WinkDaTongReportConstant.ElementParamValue.XSJ_IMAGE_ENHANCE_SUPER_RESOLUTION, map);
        }
    }

    private final void h2(Context context) {
        if (context == null) {
            return;
        }
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
        createCustomDialog.setMessage(R.string.f215535vv);
        createCustomDialog.setPositiveButton(R.string.f215525vu, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.hdr.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                q.i2(q.this, createCustomDialog, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(R.string.f215515vt, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.hdr.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                q.j2(q.this, createCustomDialog, dialogInterface, i3);
            }
        });
        try {
            if (!createCustomDialog.isShowing()) {
                createCustomDialog.show();
                Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
                Intrinsics.checkNotNullExpressionValue(params, "params");
                params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
                com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, "ev_xsj_abnormal_imp", createCustomDialog.getRootView(), WinkDaTongReportConstant.ElementId.EM_XSJ_IMAGE_ENHANCE_PANEL, params, null, 16, null);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static final void i2(q this$0, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k2(true);
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, "ev_xsj_abnormal_clck", qQCustomDialog.findViewById(R.id.dialogRightBtn), WinkDaTongReportConstant.ElementId.EM_XSJ_IMAGE_ENHANCE_CONFIRM_BUTTON, params, null, 16, null);
    }

    public static final void j2(q this$0, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        this$0.d2(true);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, "ev_xsj_abnormal_clck", qQCustomDialog.findViewById(R.id.dialogLeftBtn), WinkDaTongReportConstant.ElementId.EM_XSJ_IMAGE_ENHANCE_IGNORE_BUTTON, params, null, 16, null);
    }

    public final void O1(@NotNull WinkEditorFragment winkEditorFragment, boolean isOnHiddenOption, boolean isChangedAfterCrop) {
        List<MediaClip> list;
        Intrinsics.checkNotNullParameter(winkEditorFragment, "winkEditorFragment");
        WinkHDRPicQualityDetectUtils winkHDRPicQualityDetectUtils = WinkHDRPicQualityDetectUtils.f320445a;
        ViewModel viewModel = winkEditorFragment.getViewModel(u.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "winkEditorFragment.getVi\u2026ortViewModel::class.java)");
        u uVar = (u) viewModel;
        dr curTavCut = winkEditorFragment.getCurTavCut();
        if (curTavCut != null) {
            list = com.tencent.mobileqq.wink.editor.draft.c.l(curTavCut);
        } else {
            list = null;
        }
        winkHDRPicQualityDetectUtils.r(uVar, list, new c(winkEditorFragment, isOnHiddenOption, this, isChangedAfterCrop), winkEditorFragment.getCurTavCut());
    }

    @NotNull
    public final LiveData<Boolean> Q1() {
        return this.applySuperEnhance;
    }

    @NotNull
    public final WinkEditUIData R1() {
        return this.draftUIData;
    }

    @NotNull
    public final LiveData<Object> S1() {
        return this.enhanceBubbleShow;
    }

    /* renamed from: T1, reason: from getter */
    public final boolean getCom.tencent.mobileqq.wink.editor.hdr.EhanceWinkEditUIData.enhanceBubbleShowed java.lang.String() {
        return this.com.tencent.mobileqq.wink.editor.hdr.EhanceWinkEditUIData.enhanceBubbleShowed java.lang.String;
    }

    /* renamed from: U1, reason: from getter */
    public final boolean getHdrIniting() {
        return this.hdrIniting;
    }

    public final void W1(@NotNull final WinkEditorFragment winkEditorFragment, boolean isBlurAfterCrop, boolean isChangedAfterCrop) {
        boolean z16;
        boolean z17;
        List<MediaClip> list;
        Intrinsics.checkNotNullParameter(winkEditorFragment, "winkEditorFragment");
        dr curTavCut = winkEditorFragment.getCurTavCut();
        t73.a<Boolean> value = winkEditorFragment.Tk().M2().getValue();
        boolean z18 = false;
        if (value != null) {
            z16 = value.b().booleanValue();
        } else {
            z16 = false;
        }
        if (curTavCut != null) {
            z17 = curTavCut.G();
        } else {
            z17 = false;
        }
        WinkHDRPicQualityDetectUtils winkHDRPicQualityDetectUtils = WinkHDRPicQualityDetectUtils.f320445a;
        WinkVideoTavCut winkVideoTavCut = null;
        if (curTavCut != null) {
            list = curTavCut.a0();
        } else {
            list = null;
        }
        if (winkHDRPicQualityDetectUtils.l(list)) {
            boolean z19 = this.com.tencent.mobileqq.wink.editor.hdr.EhanceWinkEditUIData.enhanceBubbleShowed java.lang.String;
            if (!z16 && !z19) {
                w53.b.a("WinkEditorFragment", "show enhance popup");
                g2();
                return;
            }
            if (z16 && !z17 && isChangedAfterCrop) {
                if (curTavCut instanceof WinkVideoTavCut) {
                    winkVideoTavCut = (WinkVideoTavCut) curTavCut;
                }
                if (winkVideoTavCut != null && !winkVideoTavCut.j2()) {
                    z18 = true;
                }
                if (z18 && !this.enhanceBubbleDialogRefused) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.hdr.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            q.X1(q.this, winkEditorFragment);
                        }
                    });
                }
            }
        }
    }

    public final void Z1(@NotNull WinkEditorFragment winkEditorFragment, boolean hasNewClip, boolean isBlur, boolean isChangedAfterCrop) {
        boolean z16;
        Intrinsics.checkNotNullParameter(winkEditorFragment, "winkEditorFragment");
        if (hasNewClip) {
            t73.a<Boolean> value = winkEditorFragment.Tk().M2().getValue();
            if (value != null) {
                z16 = value.b().booleanValue();
            } else {
                z16 = false;
            }
            if (!z16 && WinkHDRPicQualityDetectUtils.f320445a.o()) {
                O1(winkEditorFragment, true, isChangedAfterCrop);
                return;
            }
            return;
        }
        W1(winkEditorFragment, isBlur, isChangedAfterCrop);
    }

    public final void a2(@NotNull WinkEditorFragment winkEditorFragment, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(winkEditorFragment, "winkEditorFragment");
        W1(winkEditorFragment, z16, z17);
    }

    public final void b2(@Nullable WinkEditUIData uiData) {
        if (!(uiData instanceof EhanceWinkEditUIData)) {
            return;
        }
        EhanceWinkEditUIData ehanceWinkEditUIData = (EhanceWinkEditUIData) uiData;
        e2(ehanceWinkEditUIData.getUIDraft());
        d2(ehanceWinkEditUIData.getEnhanceDialogShowed());
    }

    public final void d2(boolean z16) {
        if (!z16) {
            return;
        }
        this.draftUIData.saveEnhanceDialogShowed(z16);
        this.enhanceBubbleDialogRefused = z16;
    }

    public final void e2(boolean z16) {
        if (!z16) {
            return;
        }
        this.draftUIData.saveUIDraft(z16);
        this.com.tencent.mobileqq.wink.editor.hdr.EhanceWinkEditUIData.enhanceBubbleShowed java.lang.String = z16;
    }

    public final void f2(boolean z16) {
        this.hdrIniting = z16;
    }

    public final void g2() {
        if (this.com.tencent.mobileqq.wink.editor.hdr.EhanceWinkEditUIData.enhanceBubbleShowed java.lang.String) {
            return;
        }
        this._enhanceBubbleShow.postValue(null);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkHDRViewModel";
    }

    public final void k2(boolean r26) {
        this._applySharpenEnhance.postValue(Boolean.valueOf(r26));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        c2();
        super.onCleared();
    }
}
