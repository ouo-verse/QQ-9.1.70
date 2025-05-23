package com.tencent.mobileqq.wink.editor.menu;

import a63.WinkBubbleInfo;
import a63.a;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils;
import com.tencent.mobileqq.wink.editor.nextbtn.DailyNextBtnPart;
import com.tencent.mobileqq.wink.reddot.WinkMaterialRedDotManager;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qzonehub.api.IQZoneMMKVApi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* compiled from: P */
/* loaded from: classes21.dex */
public class u extends com.tencent.mobileqq.wink.editor.d {
    private static final String M = "u";
    private static final Long N = 3600000L;
    protected LinearLayout D;
    protected WinkEditorViewModel E;
    protected com.tencent.mobileqq.wink.editor.hdr.q F;
    protected com.tencent.mobileqq.wink.editor.template.x G;
    protected final HashMap<MenuItem, View> H = new HashMap<>();
    protected e I = null;
    protected boolean J = false;
    protected com.tencent.mobileqq.widget.tip.a K;
    private HorizontalScrollView L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkBubbleInfo f320571d;

        a(WinkBubbleInfo winkBubbleInfo) {
            this.f320571d = winkBubbleInfo;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            u.this.D.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            u.this.Qa(this.f320571d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.tip.a f320573d;

        b(com.tencent.mobileqq.widget.tip.a aVar) {
            this.f320573d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f320573d.o();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f320576a;

        static {
            int[] iArr = new int[MenuItem.values().length];
            f320576a = iArr;
            try {
                iArr[MenuItem.TO_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f320576a[MenuItem.TO_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f320576a[MenuItem.FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f320576a[MenuItem.TEMPLATE_TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f320576a[MenuItem.ADD_TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f320576a[MenuItem.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f320576a[MenuItem.STICKER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f320576a[MenuItem.STICKER_OLD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f320576a[MenuItem.VIDEO_TEMPLATE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f320576a[MenuItem.CROP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f320576a[MenuItem.CLIPPING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f320576a[MenuItem.TEMPLATE_CLIP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f320576a[MenuItem.ENHANCE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f320576a[MenuItem.EFFECT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f320576a[MenuItem.SUBTITLE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f320576a[MenuItem.TTS.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f320576a[MenuItem.MOSAIC.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f320576a[MenuItem.OPENING_ENDING.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f320576a[MenuItem.AI_ELIMINATION.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f320576a[MenuItem.AI_TEMPLATE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Aa(MenuSwitchAction menuSwitchAction) {
        ab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ba(MenuType menuType) {
        w53.b.a(M, "getMenuRedDotLiveData = " + menuType);
        la(menuType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ca(Pair pair) {
        w53.b.a(M, "getNotifyTypeChildClear = " + pair);
        MenuType menuType = (MenuType) pair.getFirst();
        if (MenuType.VIDEO_TEMPLATE.equals(menuType)) {
            la(menuType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Da(Boolean bool) {
        int i3;
        LinearLayout linearLayout = this.D;
        if (bool.booleanValue()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        if (bool.booleanValue() && this.winkEditorViewModel.a2()) {
            MenuType menuType = MenuType.VIDEO_FIRST_TEMPLATE;
            if (ra(menuType) != null) {
                com.tencent.mobileqq.wink.editor.template.c.f322362a.b(ra(menuType));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ea(List list) {
        if (this.winkEditorViewModel.getIsFromTemplateColl()) {
            gb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fa(Boolean bool) {
        fb(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ga(Boolean bool) {
        if (this.winkEditorViewModel.getIsFromTemplateColl() && this.winkEditorViewModel.a2()) {
            gb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ha(Object obj) {
        ab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ia(MenuItem menuItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.winkEditorViewModel.F4(menuItem.getMenuType());
        eb(menuItem.getMenuType());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ja(DialogInterface dialogInterface, int i3) {
        this.E.u5(MenuType.TO_VIDEO, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void La(MenuType menuType, DialogInterface dialogInterface, int i3) {
        this.E.u5(menuType, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Na() {
        this.E.t5(true);
        this.E.c5(true);
    }

    private boolean Oa() {
        com.tencent.mobileqq.wink.utils.ar arVar = com.tencent.mobileqq.wink.utils.ar.f326685a;
        String k3 = arVar.k("ae_key_editor_need_show_switch_image_dialog");
        if (!arVar.c(k3, true) || H9() == null || !H9().U()) {
            return false;
        }
        arVar.m(k3, false);
        return true;
    }

    private boolean Pa() {
        com.tencent.mobileqq.wink.utils.ar arVar = com.tencent.mobileqq.wink.utils.ar.f326685a;
        String k3 = arVar.k("ae_key_editor_need_show_switch_video_dialog");
        if (!arVar.c(k3, true) || H9() == null || !H9().U()) {
            return false;
        }
        arVar.m(k3, false);
        return true;
    }

    private void Va() {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_CHARACTER_CHANGE_BACKGROUND_BUTTON);
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        buildElementParams.put("xsj_background_id", Integer.valueOf(this.E.getBackgroundMaterialIndex()));
        VideoReport.reportEvent("ev_xsj_camera_action", buildElementParams);
    }

    private void ma(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SOURCE_ENTRY, WinkContext.INSTANCE.i(true));
        if (str.equals(WinkDaTongReportConstant.ElementId.EM_XSJ_TRANSVIDEO_BUTTON)) {
            buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_PIC_EDIT_PAGE);
        } else if (str.equals(WinkDaTongReportConstant.ElementId.EM_XSJ_TRANSPIC_BUTTON)) {
            buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        }
        if (map != null) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private void na(View view, String str, boolean z16) {
        if (str.equals(WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_BUTTON)) {
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_if_red_dot", Integer.valueOf(z16 ? 1 : 0));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_ALIENATION_TEMPLATE, Integer.valueOf(this.winkEditorViewModel.a2() ? 1 : 0));
            ma(view, str, hashMap);
            return;
        }
        if (str.equals(WinkDaTongReportConstant.ElementId.EM_XSJ_IMAGE_ENHANCE_BUTTON)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_DEMOTON_IMAGE_ENHANCE, Integer.valueOf(!com.tencent.mobileqq.wink.editor.hdr.a.o() ? 1 : 0));
            ma(view, str, hashMap2);
            return;
        }
        ma(view, str, null);
    }

    private boolean oa() {
        if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE) && ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_PIC_QUALITY) && ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME)) {
            return true;
        }
        return false;
    }

    private String pa(MenuItem menuItem) {
        switch (d.f320576a[menuItem.ordinal()]) {
            case 1:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_TRANSVIDEO_BUTTON;
            case 2:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_TRANSPIC_BUTTON;
            case 3:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_FILTER_BUTTON;
            case 4:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_EDIT_CHAR_ENTRANCE;
            case 5:
            case 6:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_CHAR_BUTTON;
            case 7:
            case 8:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_BUTTON;
            case 9:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_BUTTON;
            case 10:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_PIC_EDIT_BUTTON;
            case 11:
            case 12:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_CUT_BUTTON;
            case 13:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_IMAGE_ENHANCE_BUTTON;
            case 14:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_TEXIAO_BUTTON;
            case 15:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_BUTTON;
            case 16:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_EMOTION_TEXT_READ_ICON;
            case 17:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_MOSAIC_BUTTON;
            case 18:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_OPENING_ENDING_BUTTON;
            case 19:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_ELIMINATE_BUTTON;
            case 20:
                return WinkDaTongReportConstant.ElementId.EM_XSJ_AI_TEMPLATE;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wa(String str) {
        Qa(a63.a.INSTANCE.a().e(getContext(), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xa(String str) {
        Qa(a63.a.INSTANCE.a().e(getContext(), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void za(Boolean bool) {
        dr H9 = H9();
        if (H9 != null && bool.booleanValue() && (H9 instanceof WinkVideoTavCut)) {
            ((WinkVideoTavCut) H9).n2();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.t9k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Qa(WinkBubbleInfo winkBubbleInfo) {
        MenuItem b16 = a63.a.INSTANCE.b(winkBubbleInfo);
        if (b16 != null && qa(b16) != null) {
            if (DailyNextBtnPart.INSTANCE.e()) {
                w53.b.f(M, "onMenuExposure... need to show daily bubble");
                return;
            }
            if (winkBubbleInfo.getShowLevel() == 3) {
                this.winkEditorViewModel.r5();
            }
            if (qa(b16).getMeasuredWidth() <= 0) {
                Ra(winkBubbleInfo);
            } else if (!va(qa(b16), sa())) {
                Sa(winkBubbleInfo);
            } else {
                cb(winkBubbleInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ra(WinkBubbleInfo winkBubbleInfo) {
        this.D.getViewTreeObserver().addOnGlobalLayoutListener(new a(winkBubbleInfo));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Sa(WinkBubbleInfo winkBubbleInfo) {
        if (this.I == null) {
            this.I = new e(winkBubbleInfo);
        } else {
            sa().getViewTreeObserver().removeOnScrollChangedListener(this.I);
        }
        sa().getViewTreeObserver().addOnScrollChangedListener(this.I);
        this.I.b(winkBubbleInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ta(View view, String str) {
        if (str.equals("winSubTitle")) {
            Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BUBBLE_IS_SHOW, "1");
            VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_BUTTON);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ua(String str, View view) {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_BUBBLE_STRIP);
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        if (str.equals("winSubTitle")) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BUBBLE_SHOW_LOCATION, "subtitle");
        } else if (str.equals("winkEnhanceTip")) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BUBBLE_SHOW_LOCATION, "image_enhance");
        } else {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BUBBLE_SHOW_LOCATION, "other");
        }
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_BUBBLE_STRIP);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.reportEvent("ev_xsj_camera_action", view, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wa() {
        String str = M;
        w53.b.f(str, "setupNewMenuPopup.");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("edit_image_mode", this.winkEditorViewModel.K2() + "");
        a.Companion companion = a63.a.INSTANCE;
        WinkBubbleInfo f16 = companion.a().f(getContext(), hashMap);
        if (companion.b(f16) != null && !this.winkEditorViewModel.getIsBubbleShowed()) {
            Ra(f16);
        } else {
            w53.b.f(str, "there is no need to show bubble.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Xa() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (!((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getBooleanValue(QQWinkConstants.KEY_IS_SHOW_ELIMINATE_GUIDE_POPUP_FROM_QZONE, false) && !((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getBooleanValue(QQWinkConstants.KEY_IS_SHOW_ELIMINATE_GUIDE_POPUP_PHOTO_PREVIEW, false)) {
            z16 = false;
        } else {
            z16 = true;
        }
        w53.b.a(M, "showAIEliminationBubble: isShowGuideOutside " + z16);
        if (z16) {
            return;
        }
        long e16 = AECameraPrefsUtil.c().e(AECameraPrefsUtil.E, 0L, 0);
        long longValue = (N.longValue() * 168) + e16;
        boolean b16 = AECameraPrefsUtil.c().b(AECameraPrefsUtil.F, false, 0);
        if (e16 == 0) {
            z17 = true;
        } else {
            if (longValue <= System.currentTimeMillis() && !b16) {
                z18 = 2;
                z17 = true;
                if (!z17) {
                    a.Companion companion = a63.a.INSTANCE;
                    if (!companion.f("WinkAIElimination") && this.H.containsKey(MenuItem.AI_ELIMINATION)) {
                        if (z18 == 1) {
                            AECameraPrefsUtil.c().j(AECameraPrefsUtil.E, System.currentTimeMillis(), 0);
                        }
                        this.winkEditorViewModel.w5(3);
                        WinkBubbleInfo e17 = companion.a().e(getContext(), "WinkAIElimination");
                        Qa(e17);
                        if (z18 == 2 && e17 != null) {
                            companion.g(e17);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            z17 = false;
        }
        z18 = z17;
        if (!z17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ya(View view) {
        View findViewById = view.findViewById(R.id.z3f);
        if (findViewById == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        findViewById.setPivotX(findViewById.getWidth() / 2);
        findViewById.setPivotY(findViewById.getHeight() / 2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet2.playSequentially(ObjectAnimator.ofFloat(findViewById, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.0f).setDuration(200L), ObjectAnimator.ofFloat(findViewById, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.14f).setDuration(600L), ObjectAnimator.ofFloat(findViewById, BasicAnimation.KeyPath.SCALE_X, 1.14f, 1.0f).setDuration(600L), ObjectAnimator.ofFloat(findViewById, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.14f).setDuration(600L), ObjectAnimator.ofFloat(findViewById, BasicAnimation.KeyPath.SCALE_X, 1.14f, 1.14f).setDuration(600L), ObjectAnimator.ofFloat(findViewById, BasicAnimation.KeyPath.SCALE_X, 1.14f, 1.0f).setDuration(600L));
        animatorSet3.playSequentially(ObjectAnimator.ofFloat(findViewById, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.0f).setDuration(200L), ObjectAnimator.ofFloat(findViewById, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.14f).setDuration(600L), ObjectAnimator.ofFloat(findViewById, BasicAnimation.KeyPath.SCALE_Y, 1.14f, 1.0f).setDuration(600L), ObjectAnimator.ofFloat(findViewById, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.14f).setDuration(600L), ObjectAnimator.ofFloat(findViewById, BasicAnimation.KeyPath.SCALE_Y, 1.14f, 1.14f).setDuration(600L), ObjectAnimator.ofFloat(findViewById, BasicAnimation.KeyPath.SCALE_Y, 1.14f, 1.0f).setDuration(600L));
        animatorSet.playTogether(animatorSet2, animatorSet3);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Za() {
        if (!this.winkEditorViewModel.getIsFromTemplateColl()) {
            return;
        }
        a.Companion companion = a63.a.INSTANCE;
        if (!companion.f("winkTemplateTextList") && this.H.containsKey(MenuItem.TEMPLATE_TEXT)) {
            this.winkEditorViewModel.w5(2);
            Qa(companion.a().e(getContext(), "winkTemplateTextList"));
        } else if (!companion.f("winkTemplateClip") && this.H.containsKey(MenuItem.TEMPLATE_CLIP)) {
            this.winkEditorViewModel.w5(2);
            Qa(companion.a().e(getContext(), "winkTemplateClip"));
        }
    }

    protected void ab() {
        if (this.winkEditorViewModel.getCurMenuType() == MenuType.BOTTOM_DASHBOARD && H9() != null && !H9().p() && (H9() instanceof WinkVideoTavCut) && !this.winkEditorViewModel.getIsHDRExporting() && !this.F.getHdrIniting() && !this.F.getCom.tencent.mobileqq.wink.editor.hdr.EhanceWinkEditUIData.enhanceBubbleShowed java.lang.String() && !H9().G()) {
            WinkHDRPicQualityDetectUtils winkHDRPicQualityDetectUtils = WinkHDRPicQualityDetectUtils.f320445a;
            if (!winkHDRPicQualityDetectUtils.p(((WinkVideoTavCut) H9()).a0()) || this.winkEditorViewModel.getIsAllImages() || !winkHDRPicQualityDetectUtils.l(((WinkVideoTavCut) H9()).a0())) {
                return;
            }
            a.Companion companion = a63.a.INSTANCE;
            WinkBubbleInfo e16 = companion.a().e(getActivity(), "winkEnhanceTip");
            View ra5 = ra(MenuType.ENHANCE);
            if (getActivity() != null && !getActivity().isFinishing() && e16 != null && ra5 != null) {
                if (this.winkEditorViewModel.p4(e16)) {
                    this.F.e2(this.winkEditorViewModel.getIsBubbleShowed());
                    return;
                }
                com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(ra5.getContext());
                int right = ra5.getRight() - getActivity().findViewById(R.id.t9m).getScrollX();
                if (right <= com.tencent.videocut.utils.o.g() && right > ra5.getWidth()) {
                    r16.o0(e16.getTipsString());
                    r16.m0(4);
                    r16.k0(0);
                    r16.R(0);
                    r16.S(ra5);
                    r16.s0();
                    r16.g0(false);
                    this.winkEditorViewModel.r5();
                    companion.g(e16);
                    Ua(e16.getName(), r16.v());
                    r16.v().setOnClickListener(new b(r16));
                    this.F.e2(true);
                    Ya(ra5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bb() {
        if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_fabuqi_wenzigongnengjiaohudiedai") && WinkContext.INSTANCE.d().u("QCIRCLE")) {
            a.Companion companion = a63.a.INSTANCE;
            WinkBubbleInfo e16 = companion.a().e(getContext(), "WinkText");
            if (companion.b(e16) != null && !this.winkEditorViewModel.getIsBubbleShowed()) {
                Ra(e16);
            } else {
                w53.b.f(M, "there is no need to show bubble.");
            }
        }
    }

    protected void cb(WinkBubbleInfo winkBubbleInfo) {
        com.tencent.mobileqq.widget.tip.a aVar;
        if (this.winkEditorViewModel.p4(winkBubbleInfo)) {
            return;
        }
        if (this.J && (aVar = this.K) != null) {
            aVar.o();
        }
        a.Companion companion = a63.a.INSTANCE;
        MenuItem b16 = companion.b(winkBubbleInfo);
        if (b16 == null) {
            return;
        }
        View qa5 = qa(b16);
        com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(qa5.getContext());
        this.K = r16;
        r16.o0(winkBubbleInfo.getTipsString());
        this.J = true;
        companion.g(winkBubbleInfo);
        this.winkEditorViewModel.r5();
        this.K.m0(4);
        this.K.k0(0);
        this.K.R(0);
        this.K.S(qa5);
        this.K.s0();
        this.K.f(new c());
        Ua(winkBubbleInfo.getName(), this.K.v());
        Ta(qa5, winkBubbleInfo.getName());
        a63.d.f25611a.d(winkBubbleInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eb(final MenuType menuType) {
        if (menuType == MenuType.TO_VIDEO && Pa()) {
            try {
                DialogUtil.createCustomDialog(getContext(), 230).setMessage(getContext().getResources().getString(R.string.f215845wp)).setPositiveButton(getContext().getString(R.string.f215835wo), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.menu.g
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        u.this.Ja(dialogInterface, i3);
                    }
                }).setNegativeButton(getContext().getString(R.string.f215825wn), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.menu.h
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        u.Ka(dialogInterface, i3);
                    }
                }).show();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        if (menuType == MenuType.TO_IMAGE && Oa()) {
            DialogUtil.createCustomDialog(getContext(), 230).setMessage(getContext().getResources().getString(R.string.f215855wq)).setPositiveButton(getContext().getString(R.string.f215835wo), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.menu.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    u.this.La(menuType, dialogInterface, i3);
                }
            }).setNegativeButton(getContext().getString(R.string.f215825wn), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.menu.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    u.Ma(dialogInterface, i3);
                }
            }).show();
            return;
        }
        if (menuType == MenuType.ENHANCE) {
            if (!oa()) {
                QQToast.makeText(getContext(), -1, getContext().getString(R.string.f239967nw), 0).show();
                return;
            }
            dr H9 = H9();
            if (H9 != null) {
                boolean p16 = H9.p();
                boolean b16 = AECameraPrefsUtil.c().b(AECameraPrefsUtil.D, true, 0);
                if (!p16) {
                    WinkHDRPicQualityDetectUtils.f320445a.d();
                }
                if (!p16 && b16) {
                    AECameraPrefsUtil.c().h(AECameraPrefsUtil.D, false, 0);
                    this.E.E4(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.menu.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            u.this.Na();
                        }
                    });
                    return;
                } else {
                    if (p16) {
                        fb(false);
                    }
                    this.E.t5(!p16);
                    this.E.c5(!p16);
                    return;
                }
            }
            return;
        }
        if (menuType == MenuType.BACKGROUND) {
            Va();
            this.E.S1();
        }
        if (menuType == MenuType.TTS) {
            this.E.D5(H9());
        } else {
            this.E.u5(menuType, null);
        }
        if (this.winkEditorViewModel.a2() && menuType == MenuType.VIDEO_FIRST_TEMPLATE) {
            com.tencent.mobileqq.wink.editor.template.c.f322362a.a(ra(menuType));
        }
        if (menuType == MenuType.AI_ELIMINATION) {
            AECameraPrefsUtil.c().h(AECameraPrefsUtil.F, true, 0);
        }
    }

    public void fb(boolean z16) {
        View findViewWithTag = this.D.findViewWithTag(MenuType.ENHANCE);
        if (findViewWithTag instanceof TextView) {
            ((TextView) findViewWithTag).setCompoundDrawablesWithIntrinsicBounds(0, v.a(z16), 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"ResourceType"})
    public void gb() {
        dr H9;
        View qa5 = qa(MenuItem.TEMPLATE_TEXT);
        if (qa5 != null && (H9 = H9()) != null && (H9 instanceof WinkVideoTavCut)) {
            boolean z16 = !((WinkVideoTavCut) H9).E1().isEmpty();
            qa5.setEnabled(z16);
            View findViewById = qa5.findViewById(R.id.z3f);
            if (findViewById != null) {
                if (z16) {
                    findViewById.clearAnimation();
                    return;
                }
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.4f, 0.4f);
                alphaAnimation.setDuration(0L);
                alphaAnimation.setFillAfter(true);
                findViewById.startAnimation(alphaAnimation);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return M;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void la(MenuType menuType) {
        View findViewById;
        int i3;
        WinkMaterialRedDotManager winkMaterialRedDotManager = WinkMaterialRedDotManager.f326249a;
        boolean f16 = winkMaterialRedDotManager.f(winkMaterialRedDotManager.a(menuType));
        View ra5 = ra(menuType);
        if (ra5 != null && (findViewById = ra5.findViewById(R.id.f72103py)) != null) {
            if (f16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            findViewById.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        com.tencent.mobileqq.widget.tip.a aVar = this.K;
        if (aVar != null) {
            aVar.o();
        }
        super.onPartDestroy(activity);
    }

    public View qa(MenuItem menuItem) {
        return this.H.get(menuItem);
    }

    public View ra(MenuType menuType) {
        for (Map.Entry<MenuItem, View> entry : this.H.entrySet()) {
            if (entry.getKey().getMenuType() == menuType) {
                return entry.getValue();
            }
        }
        return null;
    }

    protected View sa() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ta(MenuItem menuItem, View view, TextView textView) {
        int i3;
        WinkMaterialRedDotManager winkMaterialRedDotManager = WinkMaterialRedDotManager.f326249a;
        boolean f16 = winkMaterialRedDotManager.f(winkMaterialRedDotManager.a(menuItem.getMenuType()));
        View findViewById = view.findViewById(R.id.f72103py);
        TextView textView2 = (TextView) view.findViewById(R.id.ucx);
        if (f16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        na(view, pa(menuItem), f16);
        if (menuItem.getMenuType() == MenuType.AI_ELIMINATION) {
            textView.setPadding(0, textView.getPaddingTop(), com.tencent.videocut.utils.e.f384236a.a(19.0f), 0);
            textView2.setText(getContext().getText(R.string.f240677pt));
            textView2.setVisibility(0);
        } else {
            textView.setPadding(0, textView.getPaddingTop(), textView.getPaddingRight(), 0);
            textView2.setText((CharSequence) null);
            textView2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ua(List<MenuItem> list) {
        int i3;
        int c16;
        String str = M;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("invalidateMenuBar = ");
        int i16 = 0;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        w53.b.a(str, sb5.toString());
        if (list == null) {
            return;
        }
        if (v.c()) {
            w53.b.a(str, "use new Seq...");
            list = v.e(list);
        }
        Context context = getContext();
        int size = list.size();
        if (size < 7) {
            c16 = com.tencent.mobileqq.util.x.c(context, 26.0f);
        } else if (size == 7) {
            c16 = com.tencent.mobileqq.util.x.c(context, 12.0f);
        } else {
            c16 = com.tencent.mobileqq.util.x.c(context, 4.0f) / 2;
        }
        int c17 = com.tencent.mobileqq.util.x.c(context, 24.0f);
        this.D.setPadding(c16, 0, c16, 0);
        this.D.removeAllViews();
        this.H.clear();
        int size2 = list.size();
        for (int i17 = 0; i17 < size2; i17++) {
            final MenuItem menuItem = list.get(i17);
            View inflate = LayoutInflater.from(context).inflate(R.layout.hct, (ViewGroup) this.D, false);
            TextView textView = (TextView) inflate.findViewById(R.id.z3f);
            textView.setText(menuItem.getTitle());
            textView.setTag(menuItem.getMenuType());
            textView.setCompoundDrawablesWithIntrinsicBounds(0, menuItem.getIcon(), 0, 0);
            ta(menuItem, inflate, textView);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.menu.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.this.Ia(menuItem, view);
                }
            });
            if (size > 7) {
                int paddingRight = textView.getPaddingRight() - com.tencent.mobileqq.util.x.c(context, 6.0f);
                if (paddingRight > 0) {
                    int i18 = c17 / 2;
                    inflate.setPadding(i18, 0, i18 - paddingRight, 0);
                } else {
                    int i19 = c17 / 2;
                    inflate.setPadding(i19, 0, i19, 0);
                }
            }
            this.D.addView(inflate, new LinearLayout.LayoutParams(-2, -1));
            if (i17 != size2 - 1) {
                this.D.addView(new View(getContext()), new LinearLayout.LayoutParams(0, -1, 1.0f));
            }
            this.H.put(menuItem, inflate);
        }
        if (this.winkEditorViewModel.a2()) {
            MenuType menuType = MenuType.VIDEO_FIRST_TEMPLATE;
            if (ra(menuType) != null) {
                LinearLayout linearLayout = this.D;
                if (this.winkEditorViewModel.getCurMenuType() == menuType) {
                    i16 = 8;
                }
                linearLayout.setVisibility(i16);
            }
        }
        if (this.winkEditorViewModel.Z3()) {
            gb();
        }
        Wa();
        Za();
        Xa();
        bb();
    }

    protected boolean va(View view, View view2) {
        if (view == null || view.getRight() > view2.getRight() + view2.getScrollX()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void z9(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) getPartRootView();
        this.D = linearLayout;
        this.L = (HorizontalScrollView) linearLayout.getParent();
        this.E = (WinkEditorViewModel) getViewModel(WinkEditorViewModel.class);
        this.G = (com.tencent.mobileqq.wink.editor.template.x) getViewModel(com.tencent.mobileqq.wink.editor.template.x.class);
        this.F = (com.tencent.mobileqq.wink.editor.hdr.q) getViewModel(com.tencent.mobileqq.wink.editor.hdr.q.class);
        this.winkEditorViewModel.o2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.ua((List) obj);
            }
        });
        this.winkEditorViewModel.a3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.wa((String) obj);
            }
        });
        this.winkEditorViewModel.l3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.xa((String) obj);
            }
        });
        this.winkEditorViewModel.u3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.Qa((WinkBubbleInfo) obj);
            }
        });
        this.winkEditorViewModel.p2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.eb((MenuType) obj);
            }
        });
        this.winkEditorViewModel.f3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.Aa((MenuSwitchAction) obj);
            }
        });
        this.winkEditorViewModel.d3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.Ba((MenuType) obj);
            }
        });
        WinkMaterialRedDotManager.f326249a.b().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.Ca((Pair) obj);
            }
        });
        this.winkEditorViewModel.q2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.Da((Boolean) obj);
            }
        });
        this.winkEditorViewModel.n3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.Ea((List) obj);
            }
        });
        this.winkEditorViewModel.x3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.Fa((Boolean) obj);
            }
        });
        this.G.R1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.Ga((Boolean) obj);
            }
        });
        this.F.S1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.Ha(obj);
            }
        });
        this.F.Q1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.za((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements a.b {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* bridge */ /* synthetic */ void onClick(View view) {
            l53.d.a(this, view);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            u uVar = u.this;
            uVar.J = false;
            uVar.K = null;
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class e implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: d, reason: collision with root package name */
        private WinkBubbleInfo f320577d;

        /* renamed from: e, reason: collision with root package name */
        private CountDownTimer f320578e = new a(100, 1);

        e(WinkBubbleInfo winkBubbleInfo) {
            this.f320577d = winkBubbleInfo;
        }

        void b(WinkBubbleInfo winkBubbleInfo) {
            this.f320577d = winkBubbleInfo;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            this.f320578e.cancel();
            this.f320578e.start();
        }

        /* compiled from: P */
        /* loaded from: classes21.dex */
        class a extends CountDownTimer {
            a(long j3, long j16) {
                super(j3, j16);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ms.a.f(u.M, "stop scroll.");
                u.this.sa().getViewTreeObserver().removeOnScrollChangedListener(e.this);
                e eVar = e.this;
                if (u.this.winkEditorViewModel.p4(eVar.f320577d)) {
                    return;
                }
                e eVar2 = e.this;
                u.this.Qa(eVar2.f320577d);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ka(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ma(DialogInterface dialogInterface, int i3) {
    }
}
