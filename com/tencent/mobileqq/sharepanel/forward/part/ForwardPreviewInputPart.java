package com.tencent.mobileqq.sharepanel.forward.part;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.impl.CommonPanelInteractionListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.fragment.DismissType;
import com.tencent.mobileqq.sharepanel.input.SharePanelKeyboardAnimationHelper;
import com.tencent.mobileqq.sharepanel.multiSelect.widget.AnimateHeightLayout;
import com.tencent.mobileqq.sharepanel.multiSelect.widget.MaxHeightScrollView;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 K2\u00020\u0001:\u0001LB\u000f\u0012\u0006\u0010H\u001a\u00020G\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001b\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewInputPart;", "Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewBasePart;", "", "T9", "ca", "W9", "", "show", "Q9", "", "panelOrKeyboardHeight", "ia", "(Ljava/lang/Integer;)V", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Z9", "aa", "V9", "S9", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "R9", "U9", "ha", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/sharepanel/fragment/DismissType;", "dismissType", "D9", "Landroid/widget/EditText;", "f", "Landroid/widget/EditText;", "editTextView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "emoticonImageView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "i", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "sendButton", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "emojiPanelContainer", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "emoticonMainPanel", "Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/MaxHeightScrollView;", "D", "Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/MaxHeightScrollView;", "maxHeightScrollView", "Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHeightLayout;", "E", "Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHeightLayout;", "animateHeightView", "Lcom/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper;", "keyboardAnimationHelper", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "G", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "callBack", "Lcom/tencent/mobileqq/sharepanel/forward/d;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/forward/d;)V", "H", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ForwardPreviewInputPart extends ForwardPreviewBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private IEmoticonMainPanel emoticonMainPanel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MaxHeightScrollView maxHeightScrollView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private AnimateHeightLayout animateHeightView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private SharePanelKeyboardAnimationHelper keyboardAnimationHelper;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final EmoticonCallback callBack;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText editTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView emoticonImageView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIButton sendButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout emojiPanelContainer;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewInputPart$a;", "", "", "LENGTH_LIMIT_TIP", "Ljava/lang/String;", "", "MAX_INPUT_LENGTH", "I", "", "PANEL_MAX_HEIGHT_RATIO", UserInfo.SEX_FEMALE, "TAG", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewInputPart$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewInputPart$b", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements EmoticonCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPreviewInputPart.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                EditText editText = ForwardPreviewInputPart.this.editTextView;
                if (editText == null) {
                    return;
                }
                TextUtils.backspace(editText);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(@Nullable EmoticonInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) info);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) info)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, oldInfo, newInfo, d16);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(@Nullable EmoticonInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
                return;
            }
            EditText editText = ForwardPreviewInputPart.this.editTextView;
            if (editText == null || info == null) {
                return;
            }
            info.send(MobileQQ.sMobileQQ.peekAppRuntime(), ForwardPreviewInputPart.this.getContext(), editText, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewInputPart$c", "Lcom/tencent/mobileqq/emoticonview/api/ICommonPanelInteractionView;", "Landroid/widget/EditText;", "getAIOInput", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "getIEmoticonMainPanel", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements ICommonPanelInteractionView {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f287263a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ForwardPreviewInputPart f287264b;

        c(EditText editText, ForwardPreviewInputPart forwardPreviewInputPart) {
            this.f287263a = editText;
            this.f287264b = forwardPreviewInputPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) editText, (Object) forwardPreviewInputPart);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView
        @NotNull
        public EditText getAIOInput() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EditText) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f287263a;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView
        @NotNull
        public IEmoticonMainPanel getIEmoticonMainPanel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                IEmoticonMainPanel iEmoticonMainPanel = this.f287264b.emoticonMainPanel;
                if (iEmoticonMainPanel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emoticonMainPanel");
                    return null;
                }
                return iEmoticonMainPanel;
            }
            return (IEmoticonMainPanel) iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewInputPart$d", "Lcom/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$c;", "", "b", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements SharePanelKeyboardAnimationHelper.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPreviewInputPart.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.input.SharePanelKeyboardAnimationHelper.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.i("ForwardPreviewInputPart", 1, "panelContainer onCollapse");
                ForwardPreviewInputPart.this.Q9(true);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.input.SharePanelKeyboardAnimationHelper.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("ForwardPreviewInputPart", 1, "panelContainer onExpend");
            AnimateHeightLayout animateHeightLayout = ForwardPreviewInputPart.this.animateHeightView;
            if (animateHeightLayout != null) {
                animateHeightLayout.f(false);
            }
            ForwardPreviewInputPart.this.Q9(false);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewInputPart$e", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f287266d;

        e(EditText editText) {
            this.f287266d = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) editText);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
                return;
            }
            if (this.f287266d.getText().length() == 150) {
                if (s16 == null || s16.charAt(149) != 20) {
                    z16 = false;
                }
                if (z16) {
                    this.f287266d.setText(s16.subSequence(0, 149));
                    this.f287266d.setSelection(149);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewInputPart$f", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f extends Editable.Factory {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.text.Editable.Factory
        @NotNull
        public Editable newEditable(@Nullable CharSequence source) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Editable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) source);
            }
            if (source instanceof h53.b) {
                return (Editable) source;
            }
            return new h53.b(source, 3, 16);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewInputPart$g", "Lee0/b;", "Landroid/content/Context;", "context", "", "buttonType", "sizeType", "f", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class g extends ee0.b {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ee0.b
        public int f(@Nullable Context context, int buttonType, int sizeType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(buttonType), Integer.valueOf(sizeType))).intValue();
            }
            return ViewUtils.f352270a.a(10.0f);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33564);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForwardPreviewInputPart(@NotNull com.tencent.mobileqq.sharepanel.forward.d param) {
        super(param);
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        } else {
            this.callBack = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(boolean show) {
        QUIButton qUIButton = this.sendButton;
        if (qUIButton != null) {
            if (show) {
                com.tencent.mobileqq.sharepanel.util.h.f287606a.e(qUIButton);
            } else {
                com.tencent.mobileqq.sharepanel.util.h.f287606a.c(qUIButton);
            }
        }
    }

    private final Drawable R9(Context context) {
        Drawable o16 = ie0.a.f().o(context, R.drawable.qui_emoticon, R.color.qui_common_icon_aio_toolbar_normal, 1000);
        Drawable o17 = ie0.a.f().o(context, R.drawable.qui_keyboard_circle, R.color.qui_common_icon_aio_toolbar_normal, 1000);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, o17);
        stateListDrawable.addState(new int[0], o16);
        return stateListDrawable;
    }

    private final void S9() {
        EditText editText = this.editTextView;
        if (editText == null) {
            return;
        }
        IEmoticonMainPanelService.PanelBuilder toastOffset = ((IEmoticonMainPanelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IEmoticonMainPanelService.class, "")).newBuilder(getContext(), 100003).setCallBack(this.callBack).setOnlySysAndEmoji(true).setPanelInteractionListener(new CommonPanelInteractionListener(new c(editText, this))).setShowEmotionPanelDeleteButton(true).setToastOffset(ViewUtils.f352270a.a(44.0f));
        Intrinsics.checkNotNullExpressionValue(toastOffset, "private fun createEmotic\u2026        )\n        }\n    }");
        IEmoticonMainPanel create = toastOffset.create();
        Intrinsics.checkNotNullExpressionValue(create, "panelBuilder.create()");
        this.emoticonMainPanel = create;
        if (create == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonMainPanel");
            create = null;
        }
        create.hideAllTabs();
        IEmoticonMainPanel iEmoticonMainPanel = this.emoticonMainPanel;
        if (iEmoticonMainPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonMainPanel");
            iEmoticonMainPanel = null;
        }
        RelativeLayout view = iEmoticonMainPanel.getView();
        view.setBackgroundColor(view.getContext().getResources().getColor(R.color.qui_common_bg_middle_standard, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9() {
        SharePanelKeyboardAnimationHelper sharePanelKeyboardAnimationHelper = this.keyboardAnimationHelper;
        if (sharePanelKeyboardAnimationHelper != null) {
            sharePanelKeyboardAnimationHelper.D();
        }
    }

    private final void U9(View rootView) {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("em_share_emoji", "em_share_send", "em_share_input_field");
        Iterator it = arrayListOf.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.sharepanel.ioc.f.k(com.tencent.mobileqq.sharepanel.ioc.f.f287347a, rootView, (String) it.next(), null, 4, null);
        }
    }

    private final void V9(View rootView) {
        ImageView imageView;
        FrameLayout frameLayout;
        IEmoticonMainPanel iEmoticonMainPanel = null;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.utb);
        } else {
            imageView = null;
        }
        this.emoticonImageView = imageView;
        if (imageView != null) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            imageView.setImageDrawable(R9(context));
        }
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f165079ut1);
        } else {
            frameLayout = null;
        }
        this.emojiPanelContainer = frameLayout;
        S9();
        IEmoticonMainPanel iEmoticonMainPanel2 = this.emoticonMainPanel;
        if (iEmoticonMainPanel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonMainPanel");
            iEmoticonMainPanel2 = null;
        }
        iEmoticonMainPanel2.getView().setVisibility(8);
        FrameLayout frameLayout2 = this.emojiPanelContainer;
        if (frameLayout2 != null) {
            IEmoticonMainPanel iEmoticonMainPanel3 = this.emoticonMainPanel;
            if (iEmoticonMainPanel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoticonMainPanel");
            } else {
                iEmoticonMainPanel = iEmoticonMainPanel3;
            }
            frameLayout2.addView(iEmoticonMainPanel.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private final void W9() {
        if (this.emojiPanelContainer != null && this.editTextView != null) {
            EditText editText = this.editTextView;
            Intrinsics.checkNotNull(editText);
            FrameLayout frameLayout = this.emojiPanelContainer;
            Intrinsics.checkNotNull(frameLayout);
            IEmoticonMainPanel iEmoticonMainPanel = this.emoticonMainPanel;
            if (iEmoticonMainPanel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoticonMainPanel");
                iEmoticonMainPanel = null;
            }
            RelativeLayout view = iEmoticonMainPanel.getView();
            Intrinsics.checkNotNullExpressionValue(view, "emoticonMainPanel.view");
            SharePanelKeyboardAnimationHelper sharePanelKeyboardAnimationHelper = new SharePanelKeyboardAnimationHelper(editText, frameLayout, view, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewInputPart$initHelper$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPreviewInputPart.this);
                    }
                }

                public final void invoke(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ForwardPreviewInputPart.this.ia(Integer.valueOf(i3));
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }
            });
            sharePanelKeyboardAnimationHelper.H(new d());
            sharePanelKeyboardAnimationHelper.I(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.forward.part.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ForwardPreviewInputPart.X9(view2);
                }
            });
            ImageView imageView = this.emoticonImageView;
            if (imageView != null) {
                sharePanelKeyboardAnimationHelper.w(imageView);
            }
            this.keyboardAnimationHelper = sharePanelKeyboardAnimationHelper;
            EditText editText2 = this.editTextView;
            if (editText2 != null) {
                editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.sharepanel.forward.part.l
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view2, boolean z16) {
                        ForwardPreviewInputPart.Y9(ForwardPreviewInputPart.this, view2, z16);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.sharepanel.ioc.f.e(com.tencent.mobileqq.sharepanel.ioc.f.f287347a, view, "em_share_emoji", null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(ForwardPreviewInputPart this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            com.tencent.mobileqq.sharepanel.ioc.f.e(com.tencent.mobileqq.sharepanel.ioc.f.f287347a, this$0.editTextView, "em_share_input_field", null, 4, null);
        }
    }

    private final void Z9(View rootView) {
        EditText editText;
        if (rootView != null) {
            editText = (EditText) rootView.findViewById(R.id.btb);
        } else {
            editText = null;
        }
        this.editTextView = editText;
        if (editText != null) {
            editText.setFilters(new com.tencent.mobileqq.sharepanel.util.e[]{new com.tencent.mobileqq.sharepanel.util.e(150, "\u5b57\u6570\u8d85\u8fc7\u4e0a\u9650")});
        }
        EditText editText2 = this.editTextView;
        if (editText2 != null) {
            editText2.addTextChangedListener(new e(editText2));
        }
        EditText editText3 = this.editTextView;
        if (editText3 != null) {
            editText3.setEditableFactory(new f());
        }
    }

    private final void aa(View rootView) {
        QUIButton qUIButton;
        String str;
        if (rootView != null) {
            qUIButton = (QUIButton) rootView.findViewById(R.id.send_btn);
        } else {
            qUIButton = null;
        }
        this.sendButton = qUIButton;
        if (qUIButton != null) {
            if (B9().c().size() > 1) {
                str = "\u53d1\u9001\uff08" + B9().c().size() + "\uff09";
            } else {
                str = "\u53d1\u9001";
            }
            qUIButton.setText(str);
        }
        QUIButton qUIButton2 = this.sendButton;
        if (qUIButton2 != null) {
            qUIButton2.setBackground(new g().a(getContext(), 0, 0, 1000));
        }
        QUIButton qUIButton3 = this.sendButton;
        if (qUIButton3 != null) {
            qUIButton3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.forward.part.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ForwardPreviewInputPart.ba(ForwardPreviewInputPart.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(ForwardPreviewInputPart this$0, View view) {
        CharSequence charSequence;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u.a().b()) {
            com.tencent.mobileqq.sharepanel.forward.a a16 = this$0.B9().a();
            if (a16 != null) {
                EditText editText = this$0.editTextView;
                if (editText != null) {
                    charSequence = editText.getText();
                } else {
                    charSequence = null;
                }
                if (charSequence == null) {
                    charSequence = "";
                }
                a16.a(charSequence);
            }
            com.tencent.mobileqq.sharepanel.ioc.f.f287347a.d(view, "em_share_send", com.tencent.mobileqq.sharepanel.report.a.c(this$0.B9().c()));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ca() {
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        if (lifecycleOwner != null) {
            LiveData<Boolean> L1 = C9().L1();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewInputPart$observeData$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPreviewInputPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        ForwardPreviewInputPart.this.T9();
                    }
                }
            };
            L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.forward.part.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ForwardPreviewInputPart.da(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(View it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(ForwardPreviewInputPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ha() {
        com.tencent.mobileqq.sharepanel.ioc.f fVar = com.tencent.mobileqq.sharepanel.ioc.f.f287347a;
        com.tencent.mobileqq.sharepanel.ioc.f.h(fVar, this.editTextView, "em_share_input_field", null, 4, null);
        com.tencent.mobileqq.sharepanel.ioc.f.h(fVar, this.emoticonImageView, "em_share_emoji", null, 4, null);
        fVar.g(this.sendButton, "em_share_send", com.tencent.mobileqq.sharepanel.report.a.c(B9().c()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ia(Integer panelOrKeyboardHeight) {
        int a16;
        int i3;
        int coerceAtLeast;
        MaxHeightScrollView maxHeightScrollView;
        if (this.maxHeightScrollView == null) {
            View partRootView = getPartRootView();
            if (partRootView != null) {
                maxHeightScrollView = (MaxHeightScrollView) partRootView.findViewById(R.id.iig);
            } else {
                maxHeightScrollView = null;
            }
            this.maxHeightScrollView = maxHeightScrollView;
        }
        MaxHeightScrollView maxHeightScrollView2 = this.maxHeightScrollView;
        if (maxHeightScrollView2 == null) {
            return;
        }
        int i16 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
        if (panelOrKeyboardHeight != null) {
            a16 = panelOrKeyboardHeight.intValue();
        } else {
            a16 = ViewUtils.f352270a.a(78.0f);
        }
        com.tencent.mobileqq.sharepanel.util.b bVar = com.tencent.mobileqq.sharepanel.util.b.f287600a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (bVar.c(context)) {
            i3 = i16 - DisplayUtil.getTopHeight(getContext());
        } else {
            i3 = (int) (i16 * 0.85f);
        }
        ViewUtils viewUtils = ViewUtils.f352270a;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(viewUtils.a(20.0f), i3 - (viewUtils.a(120.0f) + a16));
        maxHeightScrollView2.setMaxHeight(coerceAtLeast);
    }

    static /* synthetic */ void ja(ForwardPreviewInputPart forwardPreviewInputPart, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        forwardPreviewInputPart.ia(num);
    }

    @Override // com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewBasePart
    public boolean D9(@NotNull DismissType dismissType) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) dismissType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dismissType, "dismissType");
        if (dismissType == DismissType.CANCEL) {
            SharePanelKeyboardAnimationHelper sharePanelKeyboardAnimationHelper = this.keyboardAnimationHelper;
            if (sharePanelKeyboardAnimationHelper != null && sharePanelKeyboardAnimationHelper.F()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                T9();
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        QLog.i("ForwardPreviewInputPart", 1, "onConfigurationChanged");
        T9();
        ja(this, null, 1, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        List listOf;
        View findViewById;
        final View findViewById2;
        View findViewById3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        aa(rootView);
        AnimateHeightLayout animateHeightLayout = null;
        ja(this, null, 1, null);
        if (rootView != null) {
            animateHeightLayout = (AnimateHeightLayout) rootView.findViewById(R.id.spq);
        }
        this.animateHeightView = animateHeightLayout;
        if (animateHeightLayout != null) {
            animateHeightLayout.f(true);
        }
        if (!B9().d().b()) {
            if (rootView != null && (findViewById3 = rootView.findViewById(R.id.dmo)) != null) {
                findViewById3.setVisibility(8);
                return;
            }
            return;
        }
        if (rootView != null && (findViewById2 = rootView.findViewById(R.id.xof)) != null) {
            findViewById2.post(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.forward.part.h
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardPreviewInputPart.ea(findViewById2);
                }
            });
        }
        Z9(rootView);
        V9(rootView);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.yey), Integer.valueOf(R.id.f80474bk)});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (rootView != null && (findViewById = rootView.findViewById(intValue)) != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.forward.part.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ForwardPreviewInputPart.ga(ForwardPreviewInputPart.this, view);
                    }
                });
            }
        }
        W9();
        ca();
        U9(rootView);
        ha();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartPause(activity);
            T9();
        }
    }
}
