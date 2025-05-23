package com.tencent.mobileqq.wink.editor.clipping;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment;
import com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingMenuPartV2;
import com.tencent.mobileqq.wink.editor.clipping.model.WinkClippingTemplateMusicInfo;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.smartclip.viewmodel.WinkEditSmartClipViewModel;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.videocut.model.MediaClip;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.AudioSource;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.TimeRange;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingMenuPartV2;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "", "Ba", "wa", "", "mButtonName", "za", "xa", "Aa", "getLogTag", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "oa", "", "B9", "M9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "Landroid/os/Bundle;", "args", "L9", "", "onBackEvent", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/wink/editor/template/x;", "M", "Lcom/tencent/mobileqq/wink/editor/template/x;", "mWinkEditorTemplateViewModel", "Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/WinkEditSmartClipViewModel;", "N", "Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/WinkEditSmartClipViewModel;", "mWinkEditSmartClipViewModel", "P", "Landroid/os/Bundle;", "mBundle", "Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment;", "mClippingFragment", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorClippingMenuPartV2 extends WinkEditorMenuPart {

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.template.x mWinkEditorTemplateViewModel;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private WinkEditSmartClipViewModel mWinkEditSmartClipViewModel;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Bundle mBundle;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private WinkEditorClippingFragment mClippingFragment;

    private final void Aa() {
        dr H9 = H9();
        if (H9 != null && (H9 instanceof WinkVideoTavCut)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkEditorClippingMenuPartV2$preloadTimelineThumb$1$1(H9, null), 3, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0173, code lost:
    
        if (r8 == null) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Ba() {
        boolean z16;
        WinkVideoTavCut winkVideoTavCut;
        int collectionSizeOrDefault;
        String path;
        long j3;
        long j16;
        Object obj;
        AudioSource audioSource;
        Bundle bundle = new Bundle();
        List<MediaClip> arrayList = new ArrayList<>();
        if (H9() instanceof WinkVideoTavCut) {
            dr H9 = H9();
            Intrinsics.checkNotNull(H9);
            arrayList = H9.g0();
            dr H92 = H9();
            Intrinsics.checkNotNull(H92);
            bundle.putParcelable(QQWinkConstants.BACKGROUND_MODEL, H92.V().backgroundModel);
            dr H93 = H9();
            Intrinsics.checkNotNull(H93);
            bundle.putString(QQWinkConstants.TEMPLATE_PATH, H93.getTemplatePath());
            WinkVideoTavCut winkVideoTavCut2 = (WinkVideoTavCut) H9();
            Intrinsics.checkNotNull(winkVideoTavCut2);
            bundle.putSerializable(QQWinkConstants.TEMPLATE_MATERIAL, winkVideoTavCut2.getTemplateMaterial());
        }
        bundle.putParcelableArrayList(QQWinkConstants.CLIP_RESOURCE_MODEL, new ArrayList<>(arrayList));
        dr H94 = H9();
        if (H94 != null) {
            z16 = H94.G();
        } else {
            z16 = false;
        }
        bundle.putBoolean(QQWinkConstants.IS_USE_TEMPLATE, z16);
        Long value = G9().B2().getValue();
        if (value == null) {
            value = 0L;
        }
        bundle.putLong(QQWinkConstants.CLIP_CURRENT_PLAY_TIME, value.longValue());
        bundle.putBoolean(QQWinkConstants.IS_QCIRCLE_AUTO_TEMPLATE, G9().getIsQCircleAutoTemplate());
        dr H95 = H9();
        if (H95 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H95;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            List<Entity> C1 = winkVideoTavCut.C1();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = C1.iterator();
            while (it.hasNext()) {
                Collection<Component> components = ((Entity) it.next()).getComponents();
                Intrinsics.checkNotNullExpressionValue(components, "entity.components");
                Iterator<T> it5 = components.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj = it5.next();
                        if (((Component) obj) instanceof AudioSource) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj instanceof AudioSource) {
                    audioSource = (AudioSource) obj;
                } else {
                    audioSource = null;
                }
                if (audioSource != null) {
                    arrayList2.add(audioSource);
                }
            }
            ArrayList<InputSource> arrayList3 = new ArrayList();
            Iterator it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                String src = ((AudioSource) it6.next()).getSrc();
                Intrinsics.checkNotNullExpressionValue(src, "audioSource.src");
                InputSource P0 = winkVideoTavCut.P0(src);
                if (P0 != null) {
                    arrayList3.add(P0);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
            for (InputSource inputSource : arrayList3) {
                String templatePath = winkVideoTavCut.getTemplatePath();
                if (templatePath == null) {
                    templatePath = "";
                }
                String parent = new File(templatePath).getParent();
                if (parent != null) {
                    Intrinsics.checkNotNullExpressionValue(parent, "parent");
                    path = parent + File.separator + inputSource.getPath();
                }
                path = inputSource.getPath();
                String str = path;
                String label = inputSource.getLabel();
                TimeRange timeRange = inputSource.getTimeRange();
                if (timeRange != null) {
                    j3 = timeRange.startTime;
                } else {
                    j3 = 0;
                }
                TimeRange timeRange2 = inputSource.getTimeRange();
                if (timeRange2 != null) {
                    j16 = timeRange2.duration;
                } else {
                    j16 = 0;
                }
                arrayList4.add(new WinkClippingTemplateMusicInfo(label, str, j3, j16));
            }
            Object[] array = arrayList4.toArray(new WinkClippingTemplateMusicInfo[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            bundle.putParcelableArray(QQWinkConstants.CLIP_TEMPLATE_MUSIC_INFO, (Parcelable[]) array);
        }
        this.mBundle = bundle;
    }

    private final void wa() {
        com.tencent.mobileqq.wink.editor.a aVar;
        FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        Ba();
        WinkEditorClippingFragment winkEditorClippingFragment = (WinkEditorClippingFragment) childFragmentManager.findFragmentByTag("CLIPPING");
        this.mClippingFragment = winkEditorClippingFragment;
        if (winkEditorClippingFragment == null) {
            WinkEditorClippingFragment winkEditorClippingFragment2 = new WinkEditorClippingFragment();
            this.mClippingFragment = winkEditorClippingFragment2;
            Intrinsics.checkNotNull(winkEditorClippingFragment2);
            winkEditorClippingFragment2.setArguments(this.mBundle);
            FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
            WinkEditorClippingFragment winkEditorClippingFragment3 = this.mClippingFragment;
            Intrinsics.checkNotNull(winkEditorClippingFragment3);
            beginTransaction.add(R.id.f123867ht, winkEditorClippingFragment3, "CLIPPING").addToBackStack("CLIPPING").commit();
        } else {
            Intrinsics.checkNotNull(winkEditorClippingFragment);
            winkEditorClippingFragment.setArguments(this.mBundle);
            FragmentTransaction beginTransaction2 = childFragmentManager.beginTransaction();
            WinkEditorClippingFragment winkEditorClippingFragment4 = this.mClippingFragment;
            Intrinsics.checkNotNull(winkEditorClippingFragment4);
            beginTransaction2.show(winkEditorClippingFragment4).commit();
        }
        ActivityResultCaller hostFragment = getHostFragment();
        if (hostFragment instanceof com.tencent.mobileqq.wink.editor.a) {
            aVar = (com.tencent.mobileqq.wink.editor.a) hostFragment;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.g1(true);
        }
        if (getHostFragment() instanceof WinkEditorFragment) {
            com.tencent.mobileqq.wink.editor.export.u uVar = (com.tencent.mobileqq.wink.editor.export.u) getViewModel(com.tencent.mobileqq.wink.editor.export.u.class);
            WinkEditorClippingFragment winkEditorClippingFragment5 = this.mClippingFragment;
            Intrinsics.checkNotNull(winkEditorClippingFragment5);
            winkEditorClippingFragment5.fk(new b(uVar, this));
        }
    }

    private final void xa() {
        if (AECameraPrefsUtil.c().b("SP_USE_PRELOAD_TIMELINE", true, 0)) {
            Aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void za(String mButtonName) {
        Map<String, Object> mParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(mParams, "mParams");
        mParams.put("xsj_actiontype", mButtonName);
        mParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        mParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_IMAGE_ENHANCE_TERMINATE_PANEL_ONE);
        VideoReport.reportEvent("ev_xsj_camera_action", null, mParams);
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.tyl;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        super.L9(args);
        wa();
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void M9() {
        super.M9();
        if (G9().getIsFromTemplateColl()) {
            return;
        }
        xa();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.CLIPPING;
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        String simpleName = WinkEditorClippingMenuPartV2.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        QLog.d(getTAG(), 4, "[initAfterInflation]");
        this.mWinkEditorTemplateViewModel = (com.tencent.mobileqq.wink.editor.template.x) getViewModel(com.tencent.mobileqq.wink.editor.template.x.class);
        this.mWinkEditSmartClipViewModel = (WinkEditSmartClipViewModel) getViewModel(WinkEditSmartClipViewModel.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        WinkEditorClippingFragment winkEditorClippingFragment = this.mClippingFragment;
        if (winkEditorClippingFragment != null && winkEditorClippingFragment.handleBackEvent()) {
            return true;
        }
        FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        int backStackEntryCount = childFragmentManager.getBackStackEntryCount();
        if (childFragmentManager.getBackStackEntryCount() > 0) {
            String name = childFragmentManager.getBackStackEntryAt(backStackEntryCount - 1).getName();
            childFragmentManager.popBackStack();
            if (name != null && Intrinsics.areEqual(name, "CLIPPING")) {
                x9();
            }
            return true;
        }
        x9();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        String name;
        FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        int backStackEntryCount = childFragmentManager.getBackStackEntryCount();
        if (childFragmentManager.getBackStackEntryCount() > 0 && (name = childFragmentManager.getBackStackEntryAt(backStackEntryCount - 1).getName()) != null && Intrinsics.areEqual(name, "CLIPPING")) {
            childFragmentManager.popBackStack();
            this.mClippingFragment = null;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingMenuPartV2$b", "Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$a;", "Ljava/lang/Runnable;", "onConfirm", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkEditorClippingFragment.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.editor.export.u f319128a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkEditorClippingMenuPartV2 f319129b;

        b(com.tencent.mobileqq.wink.editor.export.u uVar, WinkEditorClippingMenuPartV2 winkEditorClippingMenuPartV2) {
            this.f319128a = uVar;
            this.f319129b = winkEditorClippingMenuPartV2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(com.tencent.mobileqq.wink.editor.export.u uVar, Runnable onConfirm, WinkEditorClippingMenuPartV2 this$0, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            uVar.S1();
            onConfirm.run();
            this$0.za(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment.a
        public boolean a(@NotNull final Runnable onConfirm) {
            Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
            boolean A2 = this.f319128a.A2();
            if (A2) {
                this.f319128a.F2(true);
                Context context = this.f319129b.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Integer valueOf = Integer.valueOf(R.string.f239437mg);
                final com.tencent.mobileqq.wink.editor.export.u uVar = this.f319128a;
                final WinkEditorClippingMenuPartV2 winkEditorClippingMenuPartV2 = this.f319129b;
                ViewUtilsKt.n(context, R.string.f170648xe, R.string.cancel, valueOf, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.aq
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        WinkEditorClippingMenuPartV2.b.d(com.tencent.mobileqq.wink.editor.export.u.this, onConfirm, winkEditorClippingMenuPartV2, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.ar
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        WinkEditorClippingMenuPartV2.b.e(dialogInterface, i3);
                    }
                }, null, 64, null);
                this.f319129b.za("exp");
            }
            return A2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(DialogInterface dialogInterface, int i3) {
        }
    }
}
