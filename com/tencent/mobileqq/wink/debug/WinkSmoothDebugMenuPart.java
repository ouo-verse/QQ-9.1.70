package com.tencent.mobileqq.wink.debug;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.enhance.api.IEnhanceHelper;
import com.tencent.aelight.camera.struct.editor.EnhanceConfig;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.export.u;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.enums.SmoothSharpenType;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014R\"\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R#\u00102\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/wink/debug/WinkSmoothDebugMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "", "Ra", "Sa", "Ga", "Fa", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "oa", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "", "M", "Z", "isOpenSmooth", "()Z", "setOpenSmooth", "(Z)V", "N", "isOpenSr", "setOpenSr", "P", "I", "getSmoothType", "()I", "setSmoothType", "(I)V", "smoothType", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "D", "Ia", "()D", "Qa", "(D)V", "smoothStrength", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "mTextStrength", "", "Lcom/tencent/aelight/camera/struct/editor/EnhanceConfig$SharpenStrength;", ExifInterface.LATITUDE_SOUTH, "Lkotlin/Lazy;", "Ha", "()Ljava/util/List;", "enhanceConfig", "<init>", "()V", "T", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkSmoothDebugMenuPart extends WinkEditorMenuPart {
    private static boolean U;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isOpenSmooth;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isOpenSr;

    /* renamed from: P, reason: from kotlin metadata */
    private int smoothType = SmoothSharpenType.SharpenDefault.value;

    /* renamed from: Q, reason: from kotlin metadata */
    private double smoothStrength = 1.0d;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private TextView mTextStrength;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy enhanceConfig;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/debug/WinkSmoothDebugMenuPart$c", "Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRPicQualityDetectUtils$a;", "", "isBlur", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements WinkHDRPicQualityDetectUtils.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<MediaClip> f318178b;

        /* JADX WARN: Multi-variable type inference failed */
        c(List<? extends MediaClip> list) {
            this.f318178b = list;
        }

        @Override // com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils.a
        public void a(boolean isBlur) {
            String str;
            Float f16;
            w53.b.a(WinkSmoothDebugMenuPart.this.TAG, "onPicDetectResult isBlur " + isBlur);
            StringBuilder sb5 = new StringBuilder();
            List<MediaClip> list = this.f318178b;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ResourceModel resourceModel = ((MediaClip) it.next()).resource;
                    if (resourceModel != null) {
                        f16 = Float.valueOf(resourceModel.deblurScore);
                    } else {
                        f16 = null;
                    }
                    sb5.append(f16 + ",");
                }
            }
            if (isBlur) {
                str = "\u6a21\u7cca";
            } else {
                str = "\u6e05\u6670";
            }
            QQToastUtil.showQQToastInUiThread(0, "\u753b\u8d28\u5f97\u5206 " + ((Object) sb5) + ", \u68c0\u6d4b\u7ed3\u679c\uff1a" + str);
        }
    }

    public WinkSmoothDebugMenuPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends EnhanceConfig.SharpenStrength>>() { // from class: com.tencent.mobileqq.wink.debug.WinkSmoothDebugMenuPart$enhanceConfig$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final List<? extends EnhanceConfig.SharpenStrength> invoke() {
                return ((IEnhanceHelper) QRoute.api(IEnhanceHelper.class)).getEnhanceConfig().g();
            }
        });
        this.enhanceConfig = lazy;
    }

    private final void Fa() {
        WinkHDRPicQualityDetectUtils.f320445a.t(Ha());
        Ga();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        r0 = r4.copy((r39 & 1) != 0 ? r4.id : null, (r39 & 2) != 0 ? r4.name : null, (r39 & 4) != 0 ? r4.version : null, (r39 & 8) != 0 ? r4.createTime : null, (r39 & 16) != 0 ? r4.updateTime : null, (r39 & 32) != 0 ? r4.duration : null, (r39 & 64) != 0 ? r4.videos : null, (r39 & 128) != 0 ? r4.audios : null, (r39 & 256) != 0 ? r4.stickers : null, (r39 & 512) != 0 ? r4.backgroundModel : null, (r39 & 1024) != 0 ? r4.filterModels : null, (r39 & 2048) != 0 ? r4.specialEffects : null, (r39 & 4096) != 0 ? r4.transitions : null, (r39 & 8192) != 0 ? r4.templateModel : null, (r39 & 16384) != 0 ? r4.coverInfo : null, (r39 & 32768) != 0 ? r4.exportSetting : null, (r39 & 65536) != 0 ? r4.openHDR : null, (r39 & 131072) != 0 ? r4.hdrModels : null, (r39 & 262144) != 0 ? r4.smoothModels : null, (r39 & 524288) != 0 ? r4.openSuperHDR : java.lang.Boolean.TRUE, (r39 & 1048576) != 0 ? r4.unknownFields() : null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        r0 = r2.copy((r39 & 1) != 0 ? r2.id : null, (r39 & 2) != 0 ? r2.name : null, (r39 & 4) != 0 ? r2.version : null, (r39 & 8) != 0 ? r2.createTime : null, (r39 & 16) != 0 ? r2.updateTime : null, (r39 & 32) != 0 ? r2.duration : null, (r39 & 64) != 0 ? r2.videos : null, (r39 & 128) != 0 ? r2.audios : null, (r39 & 256) != 0 ? r2.stickers : null, (r39 & 512) != 0 ? r2.backgroundModel : null, (r39 & 1024) != 0 ? r2.filterModels : null, (r39 & 2048) != 0 ? r2.specialEffects : null, (r39 & 4096) != 0 ? r2.transitions : null, (r39 & 8192) != 0 ? r2.templateModel : null, (r39 & 16384) != 0 ? r2.coverInfo : null, (r39 & 32768) != 0 ? r2.exportSetting : null, (r39 & 65536) != 0 ? r2.openHDR : null, (r39 & 131072) != 0 ? r2.hdrModels : null, (r39 & 262144) != 0 ? r2.smoothModels : null, (r39 & 524288) != 0 ? r2.openSuperHDR : java.lang.Boolean.FALSE, (r39 & 1048576) != 0 ? r2.unknownFields() : null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Ga() {
        WinkEditData h06;
        MediaModel copy;
        WinkEditData winkEditData;
        WinkEditData h07;
        MediaModel copy2;
        WinkEditData winkEditData2;
        dr H9 = H9();
        if (H9 != null && (h07 = H9.h0()) != null && (r2 = h07.getMediaModel()) != null && copy2 != null) {
            dr H92 = H9();
            if (H92 != null) {
                winkEditData2 = H92.h0();
            } else {
                winkEditData2 = null;
            }
            if (winkEditData2 != null) {
                winkEditData2.setMediaModel(copy2);
            }
        }
        dr H93 = H9();
        if (H93 != null) {
            dr.b.b(H93, false, 1, null);
        }
        dr H94 = H9();
        if (H94 != null && (h06 = H94.h0()) != null && (r4 = h06.getMediaModel()) != null && copy != null) {
            dr H95 = H9();
            if (H95 != null) {
                winkEditData = H95.h0();
            } else {
                winkEditData = null;
            }
            if (winkEditData != null) {
                winkEditData.setMediaModel(copy);
            }
        }
        dr H96 = H9();
        if (H96 != null) {
            dr.b.b(H96, false, 1, null);
        }
    }

    private final List<EnhanceConfig.SharpenStrength> Ha() {
        return (List) this.enhanceConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(WinkSmoothDebugMenuPart this$0, RadioGroup radioGroup, int i3) {
        int i16;
        EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == R.id.f70533lp) {
            i16 = SmoothSharpenType.SharpenDefault.value;
        } else {
            i16 = SmoothSharpenType.HighPass.value;
        }
        this$0.smoothType = i16;
        this$0.Sa();
        EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(WinkSmoothDebugMenuPart this$0, View view) {
        List<MediaClip> list;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        if (H9 != null) {
            list = H9.a0();
        } else {
            list = null;
        }
        List<MediaClip> list2 = list;
        WinkHDRPicQualityDetectUtils winkHDRPicQualityDetectUtils = WinkHDRPicQualityDetectUtils.f320445a;
        ViewModel viewModel = this$0.getViewModel(u.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(WinkExportViewModel::class.java)");
        WinkHDRPicQualityDetectUtils.s(winkHDRPicQualityDetectUtils, (u) viewModel, list2, new c(list2), null, 8, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(WinkSmoothDebugMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        if (H9 != null) {
            H9.pause();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(WinkSmoothDebugMenuPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isOpenSmooth = z16;
        this$0.Sa();
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Na(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        U = z16;
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(WinkSmoothDebugMenuPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isOpenSr = z16;
        this$0.Ra();
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(WinkSmoothDebugMenuPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fa();
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void Ra() {
        ArrayList arrayList = new ArrayList();
        EnhanceConfig.SharpenStrength sharpenStrength = new EnhanceConfig.SharpenStrength();
        sharpenStrength.setDeblurScoreStart(-1000);
        sharpenStrength.setSuperResolution(this.isOpenSr ? 1 : 0);
        arrayList.add(sharpenStrength);
        WinkHDRPicQualityDetectUtils.f320445a.t(arrayList);
        Ga();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sa() {
        float f16;
        ArrayList arrayList = new ArrayList();
        EnhanceConfig.SharpenStrength sharpenStrength = new EnhanceConfig.SharpenStrength();
        sharpenStrength.setDeblurScoreStart(-1000);
        if (this.isOpenSmooth) {
            f16 = (float) this.smoothStrength;
        } else {
            f16 = 0.0f;
        }
        sharpenStrength.setStrength(f16);
        sharpenStrength.setSharpenType(this.smoothType);
        arrayList.add(sharpenStrength);
        WinkHDRPicQualityDetectUtils.f320445a.t(arrayList);
        Ga();
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f86594s3;
    }

    /* renamed from: Ia, reason: from getter */
    public final double getSmoothStrength() {
        return this.smoothStrength;
    }

    public final void Qa(double d16) {
        this.smoothStrength = d16;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.SMOOTH_DEBUG_CONFIG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        ms.a.f(this.TAG, "initAfterInflation");
        this.mTextStrength = (TextView) rootView.findViewById(R.id.f95735fs);
        StartPointSeekBar startPointSeekBar = (StartPointSeekBar) rootView.findViewById(R.id.f81884fd);
        if (startPointSeekBar != null) {
            startPointSeekBar.setProgress(this.smoothStrength * 100);
            TextView textView = this.mTextStrength;
            if (textView != null) {
                textView.setText("\u9510\u5316\u5f3a\u5ea6 " + this.smoothStrength);
            }
            startPointSeekBar.setOnSeekBarChangeListener(new b());
        }
        CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.tvk);
        if (checkBox != null) {
            checkBox.setChecked(this.isOpenSmooth);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.debug.a
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    WinkSmoothDebugMenuPart.Ma(WinkSmoothDebugMenuPart.this, compoundButton, z16);
                }
            });
        }
        CheckBox checkBox2 = (CheckBox) rootView.findViewById(R.id.tvj);
        if (checkBox2 != null) {
            checkBox2.setChecked(U);
            checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.debug.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    WinkSmoothDebugMenuPart.Na(compoundButton, z16);
                }
            });
        }
        CheckBox checkBox3 = (CheckBox) rootView.findViewById(R.id.tvl);
        if (checkBox3 != null) {
            checkBox3.setChecked(this.isOpenSr);
            checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.debug.c
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    WinkSmoothDebugMenuPart.Oa(WinkSmoothDebugMenuPart.this, compoundButton, z16);
                }
            });
        }
        CheckBox checkBox4 = (CheckBox) rootView.findViewById(R.id.td_);
        if (checkBox4 != null) {
            checkBox4.setChecked(this.isOpenSr);
            checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.debug.d
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    WinkSmoothDebugMenuPart.Pa(WinkSmoothDebugMenuPart.this, compoundButton, z16);
                }
            });
        }
        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.f70513ln);
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.debug.e
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i3) {
                    WinkSmoothDebugMenuPart.Ja(WinkSmoothDebugMenuPart.this, radioGroup2, i3);
                }
            });
        }
        View findViewById = rootView.findViewById(R.id.th7);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.debug.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkSmoothDebugMenuPart.Ka(WinkSmoothDebugMenuPart.this, view);
                }
            });
        }
        View findViewById2 = rootView.findViewById(R.id.aiv);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.debug.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkSmoothDebugMenuPart.La(WinkSmoothDebugMenuPart.this, view);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/debug/WinkSmoothDebugMenuPart$b", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar$a;", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "bar", "", "value", "", "wd", "seekbar", "uc", "Fd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements StartPointSeekBar.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void wd(@Nullable StartPointSeekBar bar, int value) {
            WinkSmoothDebugMenuPart.this.Qa((value * 1.0d) / 100);
            TextView textView = WinkSmoothDebugMenuPart.this.mTextStrength;
            if (textView != null) {
                textView.setText("\u9510\u5316\u5f3a\u5ea6 " + WinkSmoothDebugMenuPart.this.getSmoothStrength());
            }
            WinkSmoothDebugMenuPart.this.Sa();
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void Fd(@Nullable StartPointSeekBar seekbar) {
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void uc(@Nullable StartPointSeekBar seekbar) {
        }
    }
}
