package com.tencent.mobileqq.wink.editor.templatecoll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment;
import com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.peak.PeakConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001RB\u0007\u00a2\u0006\u0004\bO\u0010PJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0007H\u0014J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0014J\b\u0010\u0014\u001a\u00020\u0005H\u0004J\b\u0010\u0015\u001a\u00020\u0005H\u0004J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0004J\b\u0010\u0019\u001a\u00020\u0018H\u0004R$\u0010 \u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00104\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u000100j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`18\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R$\u0010?\u001a\u0004\u0018\u0001088\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010F\u001a\u0004\u0018\u00010@8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010N\u001a\u0004\u0018\u00010G8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollAdjustFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/winkreport/crashreport/IWinkCrashReportCallback;", "Landroid/view/View;", "view", "", "Ch", "", "getStatusBarColor", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getLogTag", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "Bh", "Gh", "Ah", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "wh", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "vh", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "sh", "()Landroid/view/View;", "setCancelBtn", "(Landroid/view/View;)V", "cancelBtn", "D", "I", "uh", "()I", "setMediaIndex", "(I)V", "mediaIndex", "Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;", "E", "Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;", "th", "()Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;", "setHolderInfo", "(Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;)V", "holderInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "selectMediaPaths", "G", "Ljava/lang/String;", "originalScriptParams", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "H", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "yh", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "setOriginalMediaInfo", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "originalMediaInfo", "", "Ljava/lang/Boolean;", "xh", "()Ljava/lang/Boolean;", "setNeedDetectFace", "(Ljava/lang/Boolean;)V", "needDetectFace", "Lcom/tencent/mobileqq/wink/picker/TabType;", "J", "Lcom/tencent/mobileqq/wink/picker/TabType;", OcrConfig.CHINESE, "()Lcom/tencent/mobileqq/wink/picker/TabType;", "setPickerTabType", "(Lcom/tencent/mobileqq/wink/picker/TabType;)V", "pickerTabType", "<init>", "()V", "L", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class WinkEditorTemplateCollAdjustFragment extends ImmersivePartFragment implements IWinkCrashReportCallback {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View cancelBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private int mediaIndex;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TemplateLibraryHolderInfo holderInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ArrayList<String> selectMediaPaths;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String originalScriptParams;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LocalMediaInfo originalMediaInfo;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Boolean needDetectFace;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TabType pickerTabType;

    @NotNull
    public Map<Integer, View> K = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(WinkEditorTemplateCollAdjustFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Bh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(WinkEditorTemplateCollAdjustFragment this$0, View confirmBtn, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(confirmBtn, "confirmBtn");
        this$0.Ch(confirmBtn);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(WinkEditorTemplateCollAdjustFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ah();
        EventCollector.getInstance().onViewClicked(view);
    }

    protected final void Ah() {
        float f16;
        Activity hostActivity = getHostActivity();
        if (hostActivity != null) {
            QCircleTemplateLibraryMediaPickerFragment.Companion companion = QCircleTemplateLibraryMediaPickerFragment.INSTANCE;
            String stringExtra = hostActivity.getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
            MetaMaterial wh5 = wh();
            TabType tabType = this.pickerTabType;
            Boolean bool = this.needDetectFace;
            TemplateLibraryHolderInfo templateLibraryHolderInfo = this.holderInfo;
            if (templateLibraryHolderInfo != null) {
                f16 = templateLibraryHolderInfo.getHolderTimeSlot();
            } else {
                f16 = 0.0f;
            }
            Intent b16 = companion.b(hostActivity, stringExtra, wh5, tabType, bool, f16, this.mediaIndex, this.selectMediaPaths, this.originalScriptParams);
            b16.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
            b16.putExtra(QQWinkConstants.PICK_IS_FIRST_TEMPLATE, hostActivity.getIntent().getBooleanExtra(QQWinkConstants.PICK_IS_FIRST_TEMPLATE, false));
            TemplateLibraryHolderInfo templateLibraryHolderInfo2 = this.holderInfo;
            if (templateLibraryHolderInfo2 != null) {
                templateLibraryHolderInfo2.getHolderTimeSlot();
            }
            hostActivity.startActivityForResult(b16, 101);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bh() {
        Intent intent = new Intent();
        intent.putExtra("ARG_MEDIA_INDEX", this.mediaIndex);
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(100, 0, intent);
        }
        Gh();
    }

    public abstract void Ch(@NotNull View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Gh() {
        requireActivity().getSupportFragmentManager().popBackStack();
    }

    public void _$_clearFindViewByIdCache() {
        this.K.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "javaClass.name");
        return name;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return ContextCompat.getColor(requireContext(), R.color.bd5);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onAttachReport() {
        za3.a.b(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateReport() {
        za3.a.c(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateViewReport() {
        za3.a.d(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCustomReport(int i3) {
        za3.a.e(this, i3);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyReport() {
        za3.a.f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyViewReport() {
        za3.a.g(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onHiddenChangedReport(boolean z16) {
        za3.a.h(this, z16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        onPauseReport();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onPauseReport() {
        za3.a.i(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onResumeReport();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onResumeReport() {
        za3.a.j(this);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mediaIndex = arguments.getInt("ARG_MEDIA_INDEX", 0);
            this.holderInfo = (TemplateLibraryHolderInfo) arguments.getSerializable("ARG_HOLDER_INFO");
            this.selectMediaPaths = arguments.getStringArrayList("ARG_SELECT_MEDIA_PATHS");
            this.originalScriptParams = arguments.getString("ARG_ORIGINAL_SCRIPT_PARAMS");
            this.originalMediaInfo = (LocalMediaInfo) arguments.getParcelable("ARG_ORIGIN_MEDIA_INFO");
            this.needDetectFace = Boolean.valueOf(arguments.getBoolean(QQWinkConstants.MEDIA_PICKER_NEED_FACE_DETECT, false));
            TabType tabType = (TabType) arguments.getSerializable(QQWinkConstants.MEDIA_PICKER_TAB_TYPE);
            if (tabType == null) {
                tabType = TabType.ALL_MEDIA;
            }
            this.pickerTabType = tabType;
        }
        View findViewById = view.findViewById(R.id.aoo);
        this.cancelBtn = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WinkEditorTemplateCollAdjustFragment.Dh(WinkEditorTemplateCollAdjustFragment.this, view2);
                }
            });
        }
        final View findViewById2 = view.findViewById(R.id.f164879u42);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WinkEditorTemplateCollAdjustFragment.Eh(WinkEditorTemplateCollAdjustFragment.this, findViewById2, view2);
            }
        });
        View findViewById3 = view.findViewById(R.id.tr7);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WinkEditorTemplateCollAdjustFragment.Fh(WinkEditorTemplateCollAdjustFragment.this, view2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onViewCreatedReport() {
        za3.a.k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: sh, reason: from getter */
    public final View getCancelBtn() {
        return this.cancelBtn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: th, reason: from getter */
    public final TemplateLibraryHolderInfo getHolderInfo() {
        return this.holderInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: uh, reason: from getter */
    public final int getMediaIndex() {
        return this.mediaIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final MediaPickerScene vh() {
        Serializable serializable;
        Intent intent = getHostActivity().getIntent();
        MediaPickerScene mediaPickerScene = null;
        if (intent != null) {
            serializable = intent.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_SCENE);
        } else {
            serializable = null;
        }
        if (serializable instanceof MediaPickerScene) {
            mediaPickerScene = (MediaPickerScene) serializable;
        }
        if (mediaPickerScene == null) {
            mediaPickerScene = MediaPickerScene.TEMPLATE_LIBRARY;
        }
        if (mediaPickerScene == MediaPickerScene.TEMPLATE_ZSHOW) {
            return MediaPickerScene.TEMPLATE_ZSHOW_REPLACE;
        }
        return MediaPickerScene.TEMPLATE_LIBRARY_REPLACE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final MetaMaterial wh() {
        Serializable serializable;
        MetaMaterial metaMaterial;
        Serializable serializable2;
        Intent intent = getHostActivity().getIntent();
        String str = null;
        if (intent != null) {
            serializable = intent.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        } else {
            serializable = null;
        }
        if (serializable instanceof MetaMaterial) {
            metaMaterial = (MetaMaterial) serializable;
        } else {
            metaMaterial = null;
        }
        if (metaMaterial == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                serializable2 = arguments.getSerializable(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
            } else {
                serializable2 = null;
            }
            if (serializable2 instanceof MetaMaterial) {
                metaMaterial = (MetaMaterial) serializable2;
            } else {
                metaMaterial = null;
            }
        }
        if (intent != null) {
            str = intent.getStringExtra("lib_template_id");
        }
        if (metaMaterial == null && !TextUtils.isEmpty(str)) {
            return WinkEditorResourceManager.a1().P1(str);
        }
        return metaMaterial;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: xh, reason: from getter */
    public final Boolean getNeedDetectFace() {
        return this.needDetectFace;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: yh, reason: from getter */
    public final LocalMediaInfo getOriginalMediaInfo() {
        return this.originalMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: zh, reason: from getter */
    public final TabType getPickerTabType() {
        return this.pickerTabType;
    }
}
