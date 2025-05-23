package ak2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorFragment;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.VideoMaterialViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.aw;
import com.tencent.mobileqq.qqvideoedit.editor.menu.MenuType;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.mobileqq.qqvideoedit.editor.view.TextBoundsView;
import com.tencent.mobileqq.qqvideoedit.editor.view.TextColorView;
import com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.videocut.utils.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGPlayer;
import org.libpag.PAGText;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 t2\u00020\u0001:\u0001uB\u0007\u00a2\u0006\u0004\br\u0010sJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010%\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010#H\u0014J\b\u0010&\u001a\u00020\u0002H\u0014J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\u0002H\u0016R\u0018\u00100\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00102R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010M\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010.R\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010ZR\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010SR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010p\u00a8\u0006v"}, d2 = {"Lak2/ac;", "Lcom/tencent/mobileqq/qqvideoedit/editor/menu/h;", "", "Na", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Ka", "", "Sa", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Wa", "Da", "Ca", "Ha", "za", "", "index", "Va", "Ea", "hasBackgroundColor", "Ya", "", "categoryId", "Ua", NodeProps.VISIBLE, "Ta", "isUpdated", "wa", "Lcom/tencent/mobileqq/qqvideoedit/flow/ApplyMaterialTask;", "xa", "Lcom/tencent/mobileqq/qqvideoedit/editor/menu/MenuType;", "T9", "A9", "initAfterInflation", "Landroid/os/Bundle;", "args", "K9", "onDismiss", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel$EditMode;", "editMode", "J9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Y9", "I", "Ljava/lang/String;", "mInputMaxLimitTips", "J", "Landroid/view/View;", "mMaskView", "Lorg/libpag/PAGView;", "K", "Lorg/libpag/PAGView;", "mTextPagView", "Lcom/tencent/mobileqq/qqvideoedit/editor/view/TextBoundsView;", "L", "Lcom/tencent/mobileqq/qqvideoedit/editor/view/TextBoundsView;", "mTextBoundsView", "Landroid/widget/FrameLayout;", "M", "Landroid/widget/FrameLayout;", "mContentLayout", "N", "textContainerLayout", "Landroid/widget/EditText;", "P", "Landroid/widget/EditText;", "mTextInput", "Landroid/widget/LinearLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/LinearLayout;", "mMenuLayout", BdhLogUtil.LogTag.Tag_Req, "mColorSelectorLayout", ExifInterface.LATITUDE_SOUTH, "mLastIndex", "Landroid/widget/ImageView;", "T", "Landroid/widget/ImageView;", "mTextBgIgv", "U", "Z", "Landroid/support/v7/widget/RecyclerView;", "V", "Landroid/support/v7/widget/RecyclerView;", "mContentRecyclerView", "Landroid/view/animation/Animation;", "W", "Landroid/view/animation/Animation;", "mFadeInAnimation", "X", "mFadeOutAnimation", "Lcom/tencent/videocut/utils/i;", "Y", "Lcom/tencent/videocut/utils/i;", "mKeyboardStateHelper", "Lak2/a;", "Lak2/a;", "mTextFancyContentAdapter", "Lak2/o;", "a0", "Lak2/o;", "mTextViewModel", "b0", "Lcom/tencent/mobileqq/qqvideoedit/flow/ApplyMaterialTask;", "mApplyMaterialTask", "c0", "isPlayingWhenMenuShow", "Lcom/tencent/videocut/utils/i$b;", "d0", "Lcom/tencent/videocut/utils/i$b;", "mKeyboardStateListener", "<init>", "()V", "e0", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ac extends com.tencent.mobileqq.qqvideoedit.editor.menu.h {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String mInputMaxLimitTips;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View mMaskView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private PAGView mTextPagView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private TextBoundsView mTextBoundsView;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mContentLayout;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private View textContainerLayout;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private EditText mTextInput;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mMenuLayout;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mColorSelectorLayout;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private ImageView mTextBgIgv;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean hasBackgroundColor;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mContentRecyclerView;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private Animation mFadeInAnimation;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private Animation mFadeOutAnimation;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private com.tencent.videocut.utils.i mKeyboardStateHelper;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private a mTextFancyContentAdapter;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ApplyMaterialTask mApplyMaterialTask;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean isPlayingWhenMenuShow;

    /* renamed from: S, reason: from kotlin metadata */
    private int mLastIndex = -1;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private o mTextViewModel = new o();

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private i.b mKeyboardStateListener = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"ak2/ac$b", "Lcom/tencent/mobileqq/qqvideoedit/flow/a;", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/qqvideoedit/flow/ApplyMaterialTask$Status;", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "Lcom/tencent/mobileqq/qqvideoedit/flow/ApplyMaterialTask$a;", "callback", "", "f0", "g", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends com.tencent.mobileqq.qqvideoedit.flow.a {
        b() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.flow.a, com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask
        public void f0(@NotNull ApplyMaterialTask.Status downloadStatus, int position, @NotNull MetaMaterial material, @NotNull ApplyMaterialTask.a callback) {
            Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
            Intrinsics.checkNotNullParameter(material, "material");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (com.tencent.mobileqq.qqvideoedit.editor.sticker.h.E(material)) {
                super.f0(downloadStatus, position, material, callback);
            } else {
                com.tencent.mobileqq.qqvideoedit.editor.sticker.g.m(material, callback);
            }
        }

        @Override // com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask
        public void g(int position, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            ac.this.mTextViewModel.M1(material);
            oj2.c.b().c(material.f30533id, "video", "0");
        }

        @Override // com.tencent.mobileqq.qqvideoedit.flow.a, com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask
        public boolean z(int position, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            if (!Intrinsics.areEqual("TEXT_DEFAULT_DEFAULT_ID", material.f30533id) && !Intrinsics.areEqual("TEXT_PATTERN_NON_ID", material.f30533id) && !Intrinsics.areEqual("TEXT_DECOR_NON_ID", material.f30533id)) {
                return super.z(position, material);
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"ak2/ac$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements TextWatcher {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f26205e;

        c(EditText editText) {
            this.f26205e = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            if (s16 == null) {
                return;
            }
            String obj = s16.toString();
            if (s16.length() > 15) {
                QQToast.makeText(ac.this.getContext(), ac.this.mInputMaxLimitTips, 0).show();
                obj = s16.subSequence(0, 15).toString();
                this.f26205e.setText(obj);
                this.f26205e.setSelection(obj.length());
            }
            ac.this.mTextViewModel.r2(obj);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"ak2/ac$d", "Lcom/tencent/videocut/utils/i$b;", "", "onSoftKeyboardClosed", "", "keyboardHeightInPx", "onSoftKeyboardOpened", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements i.b {
        d() {
        }

        @Override // com.tencent.videocut.utils.i.b
        public void onSoftKeyboardClosed() {
            String value = ac.this.mTextViewModel.U1().getValue();
            if (!Intrinsics.areEqual("CATEGORY_KEYBOARD", value)) {
                ac.this.Ua(value);
            } else {
                ac acVar = ac.this;
                acVar.wa(acVar.Sa());
            }
        }

        @Override // com.tencent.videocut.utils.i.b
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            FrameLayout frameLayout = ac.this.mContentLayout;
            if (frameLayout != null && frameLayout.getLayoutParams().height != keyboardHeightInPx) {
                frameLayout.getLayoutParams().height = keyboardHeightInPx;
                frameLayout.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(ac this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        o oVar = this$0.mTextViewModel;
        Integer num = o.W.get(i3);
        Intrinsics.checkNotNullExpressionValue(num, "VideoEditorTextViewModel.COLOR_SELECTOR_SET[i]");
        int intValue = num.intValue();
        Integer num2 = o.X.get(i3);
        Intrinsics.checkNotNullExpressionValue(num2, "VideoEditorTextViewModel\u2026ACKGROUND_SELECTOR_SET[i]");
        oVar.q2(intValue, num2.intValue());
        this$0.Va(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(ac this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Va(i3);
    }

    private final void Ca(View rootView) {
        this.textContainerLayout = rootView.findViewById(R.id.f94745d4);
        com.tencent.videocut.utils.i iVar = new com.tencent.videocut.utils.i(getHostFragment().getView(), false, 2, null);
        iVar.a(this.mKeyboardStateListener);
        this.mKeyboardStateHelper = iVar;
        View findViewById = rootView.findViewById(R.id.f94815da);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.textInput)");
        EditText editText = (EditText) findViewById;
        editText.addTextChangedListener(new c(editText));
        this.mTextInput = editText;
    }

    private final void Da(View rootView) {
        this.mMenuLayout = (LinearLayout) rootView.findViewById(R.id.z3e);
    }

    private final void Ea(View rootView) {
        ImageView imageView = (ImageView) rootView.findViewById(R.id.f94645cu);
        this.mTextBgIgv = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ak2.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ac.Fa(ac.this, view);
                }
            });
        }
        this.mTextViewModel.e2().observe(getHostFragment(), new Observer() { // from class: ak2.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ac.Ga(ac.this, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(ac this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mTextViewModel.s2(!this$0.hasBackgroundColor);
        this$0.Ya(!this$0.hasBackgroundColor);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ga(ac this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ya(z16);
    }

    private final void Ha(View rootView) {
        final a aVar = new a(getContext(), E9().getEditMode());
        aVar.K(xa());
        this.mTextFancyContentAdapter = aVar;
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.u7w);
        this.mContentRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
            recyclerView.setAdapter(aVar);
        }
        this.mTextViewModel.d2().observe(getHostFragment(), new Observer() { // from class: ak2.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ac.Ia(a.this, (List) obj);
            }
        });
        this.mTextViewModel.c2().observe(getHostFragment(), new Observer() { // from class: ak2.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ac.Ja(a.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(a textFancyContentAdapter, List list) {
        Intrinsics.checkNotNullParameter(textFancyContentAdapter, "$textFancyContentAdapter");
        if (list == null) {
            return;
        }
        textFancyContentAdapter.M(list);
        textFancyContentAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(a textFancyContentAdapter, Integer num) {
        Intrinsics.checkNotNullParameter(textFancyContentAdapter, "$textFancyContentAdapter");
        if (num != null) {
            textFancyContentAdapter.N(num.intValue());
        }
    }

    private final void Ka(View rootView) {
        View findViewById = rootView.findViewById(R.id.enf);
        this.mMaskView = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: ak2.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ac.La(ac.this, view);
                }
            });
        }
        PAGView pAGView = (PAGView) rootView.findViewById(R.id.f94865df);
        this.mTextPagView = pAGView;
        if (pAGView != null) {
            pAGView.play();
            pAGView.setRepeatCount(0);
        }
        this.mTextViewModel.W1().observe(getHostFragment(), new Observer() { // from class: ak2.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ac.Ma(ac.this, (MetaMaterial) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(ac this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.wa(this$0.Sa());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(ac this$0, MetaMaterial material) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(material, "material");
        this$0.Wa(material);
    }

    private final void Na() {
        ViewModel viewModel = getViewModel(o.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(VideoEditorTextViewModel::class.java)");
        o oVar = (o) viewModel;
        this.mTextViewModel = oVar;
        oVar.a2().observe(getHostFragment(), new Observer() { // from class: ak2.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ac.Oa(ac.this, (VideoStickerModel) obj);
            }
        });
        this.mTextViewModel.Q1().observe(getHostFragment(), new Observer() { // from class: ak2.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ac.Pa(ac.this, (MetaMaterial) obj);
            }
        });
        VideoMaterialViewModel S9 = S9();
        Intrinsics.checkNotNull(S9);
        S9.getTextMaterialVOLiveData().observe(getHostFragment(), new Observer() { // from class: ak2.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ac.Qa(ac.this, (xj2.a) obj);
            }
        });
        this.mTextViewModel.U1().observe(getHostFragment(), new Observer() { // from class: ak2.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ac.Ra(ac.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(ac this$0, VideoStickerModel videoStickerModel) {
        aw F9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (videoStickerModel == null || (F9 = this$0.F9()) == null) {
            return;
        }
        F9.f0(videoStickerModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(ac this$0, MetaMaterial metaMaterial) {
        aw F9;
        VideoEditorFragment D9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (metaMaterial == null || (F9 = this$0.F9()) == null || (D9 = this$0.D9()) == null) {
            return;
        }
        com.tencent.mobileqq.qqvideoedit.editor.sticker.g.d(metaMaterial, F9, D9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qa(ac this$0, xj2.a videoMaterialVO) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoMaterialVO, "videoMaterialVO");
        this$0.mTextViewModel.k2(videoMaterialVO.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ra(ac this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ua(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Sa() {
        Editable editable;
        EditText editText = this.mTextInput;
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        return !TextUtils.isEmpty(String.valueOf(editable));
    }

    private final void Ta(boolean visible) {
        EditText editText = this.mTextInput;
        if (editText == null) {
            return;
        }
        if (visible) {
            View view = this.textContainerLayout;
            if (view != null) {
                view.setVisibility(0);
            }
            com.tencent.videocut.utils.j.f384247a.b(editText);
            String obj = editText.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                editText.setSelection(obj.length());
                return;
            }
            return;
        }
        View view2 = this.textContainerLayout;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        com.tencent.videocut.utils.j.f384247a.a(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ua(String categoryId) {
        com.tencent.videocut.utils.i iVar = this.mKeyboardStateHelper;
        if (iVar == null) {
            return;
        }
        boolean b16 = iVar.b();
        RecyclerView recyclerView = this.mContentRecyclerView;
        if (recyclerView != null && categoryId != null) {
            switch (categoryId.hashCode()) {
                case -921884268:
                    if (categoryId.equals("CATEGORY_TEXT_DECOR")) {
                        Ta(false);
                        if (!b16) {
                            recyclerView.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    return;
                case -907563552:
                    if (categoryId.equals("CATEGORY_TEXT_STYLE")) {
                        Ta(false);
                        if (!b16) {
                            recyclerView.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case 793913343:
                    if (categoryId.equals("CATEGORY_TEXT_PATTERN")) {
                        Ta(false);
                        if (!b16) {
                            recyclerView.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    return;
                case 910730760:
                    if (categoryId.equals("CATEGORY_KEYBOARD")) {
                        Ta(true);
                        recyclerView.setVisibility(8);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void Va(int index) {
        LinearLayout linearLayout = this.mColorSelectorLayout;
        if (linearLayout == null) {
            return;
        }
        int i3 = this.mLastIndex;
        if (i3 != -1) {
            linearLayout.getChildAt(i3).setSelected(false);
        }
        if (index != -1 && index >= 0 && index <= linearLayout.getChildCount()) {
            linearLayout.getChildAt(index).setSelected(true);
            this.mLastIndex = index;
        }
    }

    private final void Wa(final MetaMaterial material) {
        PAGText textData;
        final TextBoundsView textBoundsView;
        PAGView pAGView;
        EditText editText;
        if (!this.visible) {
            O9(null);
        }
        String t16 = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.t(material);
        final PAGFile c16 = com.tencent.mobileqq.qqvideoedit.utils.k.b().c(t16);
        if (c16 == null || (textData = c16.getTextData(0)) == null || (textBoundsView = this.mTextBoundsView) == null || (pAGView = this.mTextPagView) == null || (editText = this.mTextInput) == null) {
            return;
        }
        textData.text = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.h(material);
        if (Intrinsics.areEqual(t16, o.U)) {
            textData.fillColor = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.c(material);
            textData.backgroundColor = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.w(material);
            textBoundsView.setVisibility(8);
        } else {
            textData.fillColor = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.w(material);
            textBoundsView.setVisibility(0);
        }
        textData.justification = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.x(material);
        textData.fontStyle = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.m(material);
        textData.fontFamily = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.i(material);
        c16.replaceText(0, textData);
        pAGView.setComposition(c16);
        if (!Intrinsics.areEqual(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.h(material), editText.getText().toString()) && !Intrinsics.areEqual(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.h(material), o.V)) {
            editText.setText(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.h(material));
        }
        if (textBoundsView.getVisibility() == 0) {
            getMainHandler().post(new Runnable() { // from class: ak2.s
                @Override // java.lang.Runnable
                public final void run() {
                    ac.Xa(PAGFile.this, this, textBoundsView, material);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xa(PAGFile pagFile, ac this$0, TextBoundsView boundsView, MetaMaterial material) {
        Intrinsics.checkNotNullParameter(pagFile, "$pagFile");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(boundsView, "$boundsView");
        Intrinsics.checkNotNullParameter(material, "$material");
        PAGLayer[] layersByEditableIndex = pagFile.getLayersByEditableIndex(0, 3);
        Object b16 = com.tencent.robolectric.a.b(this$0.mTextPagView, "pagPlayer");
        Intrinsics.checkNotNullExpressionValue(b16, "getField(mTextPagView, \"pagPlayer\")");
        boundsView.setRect(((PAGPlayer) b16).getBounds(layersByEditableIndex[0]));
        boundsView.setColor(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.w(material));
        boundsView.invalidate();
    }

    private final void Ya(boolean hasBackgroundColor) {
        ImageView imageView = this.mTextBgIgv;
        if (imageView == null) {
            return;
        }
        if (hasBackgroundColor) {
            imageView.setImageResource(R.drawable.ngl);
        } else {
            imageView.setImageResource(R.drawable.ngk);
        }
        this.hasBackgroundColor = hasBackgroundColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wa(boolean isUpdated) {
        TextBoundsView textBoundsView = this.mTextBoundsView;
        if (textBoundsView != null) {
            textBoundsView.setVisibility(8);
        }
        com.tencent.videocut.utils.j jVar = com.tencent.videocut.utils.j.f384247a;
        EditText editText = this.mTextInput;
        Intrinsics.checkNotNull(editText);
        jVar.a(editText);
        this.mTextViewModel.P1(isUpdated);
        x9();
        EditText editText2 = this.mTextInput;
        if (editText2 != null) {
            editText2.setText("");
        }
    }

    private final ApplyMaterialTask xa() {
        if (this.mApplyMaterialTask == null) {
            this.mApplyMaterialTask = new b();
        }
        return this.mApplyMaterialTask;
    }

    private final void za(View rootView) {
        this.mTextBoundsView = (TextBoundsView) rootView.findViewById(R.id.f94685cy);
        View findViewById = rootView.findViewById(R.id.u0r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.colorSelectorLayout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        linearLayout.setGravity(16);
        this.mColorSelectorLayout = linearLayout;
        int size = o.W.size();
        for (final int i3 = 0; i3 < size; i3++) {
            TextColorView textColorView = new TextColorView(getContext());
            List<Integer> list = o.W;
            Integer num = list.get(i3);
            if (num != null && num.intValue() == -1) {
                textColorView.setColor(o.Y);
            } else {
                Integer num2 = list.get(i3);
                Intrinsics.checkNotNullExpressionValue(num2, "VideoEditorTextViewModel.COLOR_SELECTOR_SET[i]");
                textColorView.setColor(num2.intValue());
            }
            FrameLayout frameLayout = new FrameLayout(getContext());
            com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(eVar.a(28.0f), eVar.a(28.0f), 0);
            layoutParams.gravity = 17;
            frameLayout.addView(textColorView, layoutParams);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            textColorView.setOnClickListener(new View.OnClickListener() { // from class: ak2.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ac.Aa(ac.this, i3, view);
                }
            });
            this.mTextViewModel.b2().observe(getHostFragment(), new Observer() { // from class: ak2.r
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ac.Ba(ac.this, ((Integer) obj).intValue());
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public int A9() {
        return R.id.f94845dd;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h, com.tencent.mobileqq.qqvideoedit.editor.d
    public void J9(@NotNull VideoEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        super.J9(editMode);
        a aVar = this.mTextFancyContentAdapter;
        if (aVar != null) {
            aVar.P(editMode);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h, com.tencent.mobileqq.qqvideoedit.editor.d
    protected void K9(@Nullable Bundle args) {
        IPlayer currentPlayer;
        PAGView pAGView = this.mTextPagView;
        if (pAGView != null) {
            pAGView.startAnimation(this.mFadeInAnimation);
        }
        View view = this.mMaskView;
        if (view != null) {
            view.startAnimation(this.mFadeInAnimation);
        }
        LinearLayout linearLayout = this.mMenuLayout;
        if (linearLayout != null) {
            linearLayout.startAnimation(V9());
        }
        super.K9(args);
        this.mTextViewModel.L1();
        aw F9 = F9();
        if (F9 != null && (currentPlayer = F9.getCurrentPlayer()) != null && E9().getEditMode() == VideoEditorViewModel.EditMode.Video) {
            this.isPlayingWhenMenuShow = currentPlayer.isPlaying();
            currentPlayer.pause();
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h
    @NotNull
    public MenuType T9() {
        return MenuType.TEXT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        this.mInputMaxLimitTips = getContext().getResources().getString(R.string.f242967w0);
        this.mContentLayout = (FrameLayout) rootView.findViewById(R.id.leb);
        this.mFadeInAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154548b2);
        this.mFadeOutAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154550b4);
        Na();
        Ca(rootView);
        Ka(rootView);
        Da(rootView);
        Ha(rootView);
        za(rootView);
        Ea(rootView);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h, com.tencent.mobileqq.qqvideoedit.editor.d
    protected void onDismiss() {
        IPlayer currentPlayer;
        if (!Intrinsics.areEqual("CATEGORY_KEYBOARD", this.mTextViewModel.S1())) {
            PAGView pAGView = this.mTextPagView;
            if (pAGView != null) {
                pAGView.startAnimation(this.mFadeOutAnimation);
            }
            View view = this.mMaskView;
            if (view != null) {
                view.startAnimation(this.mFadeOutAnimation);
            }
            LinearLayout linearLayout = this.mMenuLayout;
            if (linearLayout != null) {
                linearLayout.startAnimation(U9());
            }
        } else {
            View partRootView = getPartRootView();
            if (partRootView != null) {
                partRootView.setVisibility(4);
            }
        }
        aw F9 = F9();
        if (F9 != null && (currentPlayer = F9.getCurrentPlayer()) != null && E9().getEditMode() == VideoEditorViewModel.EditMode.Video && this.isPlayingWhenMenuShow) {
            currentPlayer.play();
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        com.tencent.videocut.utils.i iVar = this.mKeyboardStateHelper;
        if (iVar != null) {
            iVar.f(this.mKeyboardStateListener);
            iVar.e();
        }
        this.mKeyboardStateHelper = null;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h
    public void Y9() {
    }
}
