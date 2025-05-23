package com.tencent.mobileqq.qqvideoedit.zplan.parts;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.servlet.GetMaterialRelevantAppServlet;
import com.tencent.mobileqq.qqvideoedit.editor.aw;
import com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportProgress;
import com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.mobileqq.qqvideoedit.zplan.export.VideoEditTextGifExportTask;
import com.tencent.mobileqq.qqvideoedit.zplan.preview.ZootopiaGifPreviewFragment;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ik2.GifClipData;
import ik2.GifFileInfo;
import ik2.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b?\u0010@J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\"\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010 \u001a\u00020\u0003H\u0014J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R&\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00150.j\b\u0012\u0004\u0012\u00020\u0015`/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R6\u00104\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/zplan/parts/VideoEditExportGifPart;", "Lck2/f;", "Lik2/h;", "", "la", "()Lkotlin/Unit;", "", ViewStickEventHelper.IS_SHOW, "ia", "(Z)Lkotlin/Unit;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "ga", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lik2/d;", "data", "I9", "isAdd", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "text", "M9", "V9", "Lcom/tencent/mobileqq/qqvideoedit/editor/export/VideoExportViewModel;", "vm", "Lcom/tencent/mobileqq/qqvideoedit/editor/export/b;", "state", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "originInfo", "Y9", "U9", "T9", "t2", "Lik2/e;", "gifFileInfo", ICustomDataEditor.STRING_PARAM_2, "t7", "", "G", "J", "exportStartTime", "H", "Lik2/d;", "clipData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "I", "Ljava/util/ArrayList;", "textList", "Ljava/util/HashMap;", "extraInfo", "Lcom/tencent/mobileqq/qqvideoedit/zplan/export/a;", "K", "Lcom/tencent/mobileqq/qqvideoedit/zplan/export/a;", "gifExportTask", "Landroid/app/Dialog;", "L", "Lkotlin/Lazy;", "ha", "()Landroid/app/Dialog;", "gifProgressDialog", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoEditExportGifPart extends ck2.f implements h {

    /* renamed from: G, reason: from kotlin metadata */
    private long exportStartTime;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private GifClipData clipData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private ArrayList<MetaMaterial> textList = new ArrayList<>();

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private HashMap<String, String> extraInfo;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqvideoedit.zplan.export.a gifExportTask;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy gifProgressDialog;

    public VideoEditExportGifPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Dialog>() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.parts.VideoEditExportGifPart$gifProgressDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Dialog invoke() {
                ReportDialog reportDialog = new ReportDialog(VideoEditExportGifPart.this.getContext(), R.style.qZoneInputDialog);
                reportDialog.setCanceledOnTouchOutside(false);
                reportDialog.setCancelable(false);
                reportDialog.setContentView(R.layout.f168383uh);
                View findViewById = reportDialog.findViewById(R.id.photo_prievew_progress_dialog_text);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                return reportDialog;
            }
        });
        this.gifProgressDialog = lazy;
    }

    private final HashMap<String, String> ga() {
        Serializable serializable;
        Intent intent;
        if (this.extraInfo == null) {
            Activity activity = getActivity();
            HashMap<String, String> hashMap = null;
            if (activity != null && (intent = activity.getIntent()) != null) {
                serializable = intent.getSerializableExtra(GetMaterialRelevantAppServlet.KEY_EXTRA_INFO);
            } else {
                serializable = null;
            }
            if (serializable instanceof HashMap) {
                hashMap = (HashMap) serializable;
            }
            this.extraInfo = hashMap;
            QLog.i(this.TAG, 2, "getExtraData: " + hashMap);
        }
        HashMap<String, String> hashMap2 = this.extraInfo;
        if (hashMap2 == null) {
            return new HashMap<>();
        }
        return hashMap2;
    }

    private final Dialog ha() {
        return (Dialog) this.gifProgressDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Unit ia(final boolean isShow) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.parts.e
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEditExportGifPart.ja(isShow, this);
                }
            });
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(boolean z16, VideoEditExportGifPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.ha().show();
            return;
        }
        if (this$0.ha().isShowing()) {
            Activity activity = this$0.getActivity();
            boolean z17 = false;
            if (activity != null && !activity.isFinishing()) {
                z17 = true;
            }
            if (z17) {
                this$0.ha().dismiss();
            }
        }
    }

    private final Unit la() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.parts.d
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEditExportGifPart.ma(VideoEditExportGifPart.this);
                }
            });
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(VideoEditExportGifPart this$0) {
        Map<String, VideoStickerModel> m3;
        Collection<VideoStickerModel> values;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aw F9 = this$0.F9();
        if (F9 != null && (m3 = F9.m()) != null && (values = m3.values()) != null) {
            for (VideoStickerModel videoStickerModel : values) {
                if (this$0.D9() != null) {
                    float min = Math.min((r1.qh() * 1.0f) / r1.getRenderWidth(), (r1.ph() * 1.0f) / r1.getRenderHeight());
                    videoStickerModel.updatePositionInView((int) (r1.getRenderWidth() * min), (int) (r1.getRenderHeight() * min), 1.0f, videoStickerModel.centerX, videoStickerModel.centerY);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public void I9(@NotNull GifClipData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.clipData = data;
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "onClipChanged: data=" + data);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public void M9(boolean isAdd, @NotNull MetaMaterial text) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(text, "text");
        if (isAdd) {
            if (!this.textList.contains(text)) {
                this.textList.add(text);
            }
        } else {
            this.textList.remove(text);
        }
        if (QLog.isColorLevel()) {
            String str = this.TAG;
            String h16 = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.h(text);
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.textList, ", ", null, null, 0, null, new Function1<MetaMaterial, CharSequence>() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.parts.VideoEditExportGifPart$onVideoTextChanged$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull MetaMaterial it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return com.tencent.mobileqq.qqvideoedit.editor.sticker.h.h(it);
                }
            }, 30, null);
            QLog.i(str, 2, "onVideoTextChanged: isAdd=" + isAdd + ", text=" + h16 + ", currentTextList=" + joinToString$default);
        }
    }

    @Override // ck2.f
    public void T9() {
        QLog.i(this.TAG, 1, "onVideoExportCancel");
        com.tencent.mobileqq.qqvideoedit.zplan.export.a aVar = this.gifExportTask;
        if (aVar != null) {
            aVar.b();
        }
        this.gifExportTask = null;
        la();
    }

    @Override // ck2.f
    protected void U9() {
        QLog.e(this.TAG, 1, "onVideoExportError");
        com.tencent.mobileqq.qqvideoedit.zplan.export.a aVar = this.gifExportTask;
        if (aVar != null) {
            aVar.a();
        }
        la();
    }

    @Override // ck2.f
    public void V9() {
        com.tencent.mobileqq.qqvideoedit.zplan.export.a videoEditTextGifExportTask;
        this.exportStartTime = System.currentTimeMillis();
        com.tencent.mobileqq.qqvideoedit.zplan.export.a aVar = this.gifExportTask;
        if (aVar != null) {
            aVar.b();
        }
        boolean isEmpty = this.textList.isEmpty();
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onVideoExportStart: start GifExportTask, withTextCheck=");
        sb5.append(!isEmpty);
        QLog.i(str, 1, sb5.toString());
        if (isEmpty) {
            videoEditTextGifExportTask = new com.tencent.mobileqq.qqvideoedit.zplan.export.b(getContext(), this);
        } else {
            videoEditTextGifExportTask = new VideoEditTextGifExportTask(getContext(), this, new VideoEditExportGifPart$onVideoExportStart$1(this), new Function0<List<? extends String>>() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.parts.VideoEditExportGifPart$onVideoExportStart$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends String> invoke() {
                    ArrayList arrayList;
                    int collectionSizeOrDefault;
                    arrayList = VideoEditExportGifPart.this.textList;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.h((MetaMaterial) it.next()));
                    }
                    return arrayList2;
                }
            });
        }
        this.gifExportTask = videoEditTextGifExportTask;
        videoEditTextGifExportTask.d();
    }

    @Override // ck2.f
    protected void Y9(@NotNull VideoExportViewModel vm5, @NotNull VideoExportProgress state, @Nullable LocalMediaInfo originInfo) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(state, "state");
        QLog.i(this.TAG, 1, "onVideoExportSuccess: exportTotalCost=" + (System.currentTimeMillis() - this.exportStartTime) + "ms");
        LocalMediaInfo localMediaInfo = state.getLocalMediaInfo();
        com.tencent.mobileqq.qqvideoedit.zplan.export.a aVar = this.gifExportTask;
        if (aVar != null) {
            aVar.c(localMediaInfo, this.clipData);
        }
        la();
    }

    @Override // ck2.f, com.tencent.mobileqq.qqvideoedit.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        QUIButton nextButton = getNextButton();
        if (nextButton != null) {
            nextButton.setText(R.string.f238277jb);
        }
        QUIButton nextButton2 = getNextButton();
        if (nextButton2 != null) {
            kk2.c.a(nextButton2, new Function1<ConstraintLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.parts.VideoEditExportGifPart$onInitView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ConstraintLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ConstraintLayout.LayoutParams updateLayoutParams) {
                    Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                    ((ViewGroup.MarginLayoutParams) updateLayoutParams).height = x.c(VideoEditExportGifPart.this.getContext(), 32.0f);
                }
            });
        }
        ik2.c.f407905a.b();
    }

    @Override // ik2.h
    public void s2(@NotNull GifFileInfo gifFileInfo) {
        Intrinsics.checkNotNullParameter(gifFileInfo, "gifFileInfo");
        QLog.i(this.TAG, 1, "onGifExportSuccess: gif=" + gifFileInfo);
        ZootopiaGifPreviewFragment.INSTANCE.a(getContext(), gifFileInfo, ga());
        ia(false);
    }

    @Override // ik2.h
    public void t2() {
        QLog.i(this.TAG, 1, "onGifExportStart");
        ia(true);
    }

    @Override // ik2.h
    public void t7() {
        QLog.e(this.TAG, 1, "onGifExportError");
        QQToast.makeText(getContext(), 1, R.string.f242957vz, 0).show();
        ia(false);
    }
}
