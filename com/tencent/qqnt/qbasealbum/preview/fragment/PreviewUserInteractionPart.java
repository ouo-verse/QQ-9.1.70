package com.tencent.qqnt.qbasealbum.preview.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic;
import com.tencent.qqnt.qbasealbum.event.MediaEditDoneEvent;
import com.tencent.qqnt.qbasealbum.event.SelectMediaSizeEvent;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.preview.fragment.PreviewUserInteractionPart;
import com.tencent.qqnt.qbasealbum.preview.viewmodel.PreviewMediaViewModel;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import com.tencent.qqnt.qbasealbum.utils.MediaTypeHelper;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 x2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003yz{B=\u0012\u001a\u0010.\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020*\u0018\u0001`+\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00106\u001a\u000203\u0012\b\u00109\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\bv\u0010wJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e0\u001dH\u0016J\u001a\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020!H\u0014J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020$J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020!R(\u0010.\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020*\u0018\u0001`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0018\u0010N\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010PR\u0018\u0010X\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010SR\u0018\u0010Z\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010PR\u0018\u0010\\\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010SR\u0018\u0010^\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010PR\u0018\u0010`\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010PR\u0018\u0010b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010PR\u0018\u0010d\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010PR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u001a\u0010l\u001a\u00060iR\u00020\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u00108R\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010u\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010t\u00a8\u0006|"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewUserInteractionPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "aa", "Landroid/widget/TextView;", "textView", "Landroid/widget/CheckBox;", "checkBox", "wa", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", "action", "Aa", "za", "ba", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "v", "", "checkAnySelection", "ea", "Lcom/tencent/qqnt/qbasealbum/datahub/a;", "ca", "ta", "da", NodeProps.VISIBLE, "va", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "previewMedia", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewMode;", "e", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewMode;", "previewMode", "Lcom/tencent/qqnt/qbasealbum/share/a;", "f", "Lcom/tencent/qqnt/qbasealbum/share/a;", "shareDataViewModel", tl.h.F, "Ljava/lang/String;", "business", "Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel;", "i", "Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel;", "mediaPreviewViewModel", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/richframework/gallery/viewmodel/RFWLayerViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/richframework/gallery/viewmodel/RFWLayerViewModel;", "layerViewModel", "Landroid/view/ViewGroup;", "D", "Landroid/view/ViewGroup;", "bottomBarRoot", "E", "topBarRoot", UserInfo.SEX_FEMALE, "Landroid/view/View;", "backBtn", "G", "Landroid/widget/TextView;", "titleTv", "H", "Landroid/widget/CheckBox;", "seqNumberText", "I", "editBtn", "J", "flashPicCb", "K", "flashPicTv", "L", "qualityCb", "M", "qualityTv", "N", "qualitySize", "P", "sendBtn", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "commentTv", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/recyclerview/widget/RecyclerView;", "selectedMediaRV", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewUserInteractionPart$c;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewUserInteractionPart$c;", "selectedMediaAdapter", "T", "sendInitText", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "U", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "qualityCheckListener", "V", "Z", "isBarShow", "<init>", "(Ljava/util/ArrayList;Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewMode;Lcom/tencent/qqnt/qbasealbum/share/a;Ljava/lang/String;)V", "W", "a", "b", "c", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class PreviewUserInteractionPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private RFWLayerViewModel layerViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup bottomBarRoot;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup topBarRoot;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View backBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView titleTv;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private CheckBox seqNumberText;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView editBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private CheckBox flashPicCb;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TextView flashPicTv;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private CheckBox qualityCb;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TextView qualityTv;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView qualitySize;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private TextView sendBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private TextView commentTv;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private RecyclerView selectedMediaRV;

    /* renamed from: S, reason: from kotlin metadata */
    private c selectedMediaAdapter;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String sendInitText;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final CompoundButton.OnCheckedChangeListener qualityCheckListener;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isBarShow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ArrayList<LocalMediaInfo> previewMedia;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PreviewMode previewMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.qbasealbum.share.a shareDataViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String business;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PreviewMediaViewModel mediaPreviewViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SelectedMediaViewModel selectedMediaViewModel;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewUserInteractionPart$a;", "", "", "SELECTED_MEDIA_ITEM_SPACE", UserInfo.SEX_FEMALE, "", "SELECT_NUM_THRESHOLD", "I", "", "SMOOTH_SCROLL_DELAY_TIME_MS", "J", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.preview.fragment.PreviewUserInteractionPart$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewUserInteractionPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "E", "Ljava/lang/String;", "gifPath", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewUserInteractionPart;Landroid/view/View;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private String gifPath;
        final /* synthetic */ PreviewUserInteractionPart F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull PreviewUserInteractionPart previewUserInteractionPart, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.F = previewUserInteractionPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) previewUserInteractionPart, (Object) itemView);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(PreviewUserInteractionPart this$0, LocalMediaInfo info, View view) {
            MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData;
            UIStateData<RFWLayerState> value;
            MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData2;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(info, "$info");
            RFWLayerViewModel rFWLayerViewModel = this$0.layerViewModel;
            if (rFWLayerViewModel != null && (mutableLiveData = rFWLayerViewModel.mRichMediaInfo) != null && (value = mutableLiveData.getValue()) != null) {
                RFWLayerState data = value.getData();
                List<RFWLayerItemMediaInfo> richMediaDataList = value.getData().getRichMediaDataList();
                int i3 = 0;
                if (richMediaDataList != null) {
                    Iterator<RFWLayerItemMediaInfo> it = richMediaDataList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual(it.next().getMediaId(), String.valueOf(info.get_id()))) {
                                break;
                            } else {
                                i3++;
                            }
                        } else {
                            i3 = -1;
                            break;
                        }
                    }
                }
                data.setSelectedPosition(i3);
                value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainSelectedPositionChanged(value.getData().getSelectedPosition()));
                RFWLayerViewModel rFWLayerViewModel2 = this$0.layerViewModel;
                if (rFWLayerViewModel2 != null && (mutableLiveData2 = rFWLayerViewModel2.mRichMediaInfo) != null) {
                    mutableLiveData2.postValue(value);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull final LocalMediaInfo info) {
            String str;
            int i3;
            boolean equals$default;
            LocalMediaInfo O1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.f27240fp);
            String path = info.getPath();
            PreviewMediaViewModel previewMediaViewModel = this.F.mediaPreviewViewModel;
            if (previewMediaViewModel != null && (O1 = previewMediaViewModel.O1()) != null) {
                str = O1.getPath();
            } else {
                str = null;
            }
            boolean areEqual = Intrinsics.areEqual(path, str);
            int i16 = 8;
            if (areEqual) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            ImageView imageView2 = (ImageView) this.itemView.findViewById(R.id.f27220fn);
            if (com.tencent.qqnt.qbasealbum.ktx.b.j(info)) {
                i16 = 0;
            }
            imageView2.setVisibility(i16);
            View view = this.itemView;
            final PreviewUserInteractionPart previewUserInteractionPart = this.F;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PreviewUserInteractionPart.b.n(PreviewUserInteractionPart.this, info, view2);
                }
            });
            if (MediaTypeHelper.f361628a.b(info)) {
                String str2 = this.gifPath;
                if (str2 != null) {
                    equals$default = StringsKt__StringsJVMKt.equals$default(str2, info.getPath(), false, 2, null);
                    if (equals$default) {
                        return;
                    }
                }
                this.gifPath = info.getPath();
            }
            View findViewById = this.itemView.findViewById(R.id.f27250fq);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById<Sq\u2026ew_flow_selectedThumbImg)");
            com.tencent.qqnt.qbasealbum.ktx.d.g((ImageView) findViewById, info);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewUserInteractionPart$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewUserInteractionPart$b;", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewUserInteractionPart;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "i0", "()Ljava/util/List;", "l0", "(Ljava/util/List;)V", "selectedMedia", "<init>", "(Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewUserInteractionPart;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class c extends RecyclerView.Adapter<b> {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<LocalMediaInfo> selectedMedia;

        public c() {
            List<LocalMediaInfo> emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                this.selectedMedia = emptyList;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreviewUserInteractionPart.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.selectedMedia.size();
        }

        @NotNull
        public final List<LocalMediaInfo> i0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.selectedMedia;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull b holder, int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, position);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            LocalMediaInfo localMediaInfo = this.selectedMedia.get(position);
            holder.m(localMediaInfo);
            holder.itemView.setContentDescription(com.tencent.qqnt.qbasealbum.query.b.f361494a.b(localMediaInfo, Integer.valueOf(position + 1)));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, viewType);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            PreviewUserInteractionPart previewUserInteractionPart = PreviewUserInteractionPart.this;
            View inflate = LayoutInflater.from(previewUserInteractionPart.getPartHost().getHostActivity()).inflate(R.layout.fta, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(partHost.hostActivi\u2026list_item, parent, false)");
            return new b(previewUserInteractionPart, inflate);
        }

        public final void l0(@NotNull List<LocalMediaInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            } else {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.selectedMedia = list;
            }
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361380a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44003);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[PreviewMode.values().length];
            try {
                iArr[PreviewMode.DIRECT_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreviewMode.SELECT_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f361380a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/qbasealbum/preview/fragment/PreviewUserInteractionPart$e", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/a;", "", "text", "", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreviewUserInteractionPart.this);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.preview.fragment.a
        public void a(@Nullable String text) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) text);
            } else if (text != null) {
                PreviewUserInteractionPart.this.shareDataViewModel.R1(text);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44018);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PreviewUserInteractionPart(@Nullable ArrayList<LocalMediaInfo> arrayList, @NotNull PreviewMode previewMode, @NotNull com.tencent.qqnt.qbasealbum.share.a shareDataViewModel, @Nullable String str) {
        Intrinsics.checkNotNullParameter(previewMode, "previewMode");
        Intrinsics.checkNotNullParameter(shareDataViewModel, "shareDataViewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, arrayList, previewMode, shareDataViewModel, str);
            return;
        }
        this.previewMedia = arrayList;
        this.previewMode = previewMode;
        this.shareDataViewModel = shareDataViewModel;
        this.business = str;
        this.sendInitText = "";
        this.qualityCheckListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                PreviewUserInteractionPart.ua(PreviewUserInteractionPart.this, compoundButton, z16);
            }
        };
        this.isBarShow = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa(final com.tencent.qqnt.qbasealbum.select.model.a action) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Object last;
        RecyclerView recyclerView3;
        c cVar = null;
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.f) {
            c cVar2 = this.selectedMediaAdapter;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                cVar2 = null;
            }
            com.tencent.qqnt.qbasealbum.select.model.f fVar = (com.tencent.qqnt.qbasealbum.select.model.f) action;
            cVar2.l0(fVar.a());
            c cVar3 = this.selectedMediaAdapter;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
            } else {
                cVar = cVar3;
            }
            cVar.notifyDataSetChanged();
            if (!fVar.a().isEmpty()) {
                if (!Intrinsics.areEqual(this.business, "FAST_IMAGE") && (recyclerView3 = this.selectedMediaRV) != null) {
                    recyclerView3.setVisibility(0);
                }
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) fVar.a());
                final int e16 = com.tencent.qqnt.qbasealbum.ktx.b.e((LocalMediaInfo) last);
                RecyclerView recyclerView4 = this.selectedMediaRV;
                if (recyclerView4 != null) {
                    recyclerView4.postDelayed(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            PreviewUserInteractionPart.Ba(PreviewUserInteractionPart.this, e16);
                        }
                    }, 100L);
                }
                za();
                return;
            }
            return;
        }
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.b) {
            c cVar4 = this.selectedMediaAdapter;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                cVar4 = null;
            }
            com.tencent.qqnt.qbasealbum.select.model.b bVar = (com.tencent.qqnt.qbasealbum.select.model.b) action;
            cVar4.l0(bVar.c());
            if (!Intrinsics.areEqual(this.business, "FAST_IMAGE") && (recyclerView2 = this.selectedMediaRV) != null) {
                recyclerView2.setVisibility(0);
            }
            c cVar5 = this.selectedMediaAdapter;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
            } else {
                cVar = cVar5;
            }
            cVar.notifyItemInserted(bVar.c().size());
            RecyclerView recyclerView5 = this.selectedMediaRV;
            if (recyclerView5 != null) {
                recyclerView5.postDelayed(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        PreviewUserInteractionPart.Ca(PreviewUserInteractionPart.this, action);
                    }
                }, 100L);
            }
            za();
            return;
        }
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.g) {
            c cVar6 = this.selectedMediaAdapter;
            if (cVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
            } else {
                cVar = cVar6;
            }
            com.tencent.qqnt.qbasealbum.select.model.g gVar = (com.tencent.qqnt.qbasealbum.select.model.g) action;
            cVar.notifyItemMoved(gVar.a(), gVar.b());
            RecyclerView recyclerView6 = this.selectedMediaRV;
            if (recyclerView6 != null) {
                recyclerView6.invalidateItemDecorations();
                return;
            }
            return;
        }
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.h) {
            c cVar7 = this.selectedMediaAdapter;
            if (cVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                cVar7 = null;
            }
            com.tencent.qqnt.qbasealbum.select.model.h hVar = (com.tencent.qqnt.qbasealbum.select.model.h) action;
            cVar7.l0(hVar.c());
            if (hVar.c().isEmpty() && (recyclerView = this.selectedMediaRV) != null) {
                recyclerView.setVisibility(8);
            }
            c cVar8 = this.selectedMediaAdapter;
            if (cVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
            } else {
                cVar = cVar8;
            }
            cVar.notifyDataSetChanged();
            RecyclerView recyclerView7 = this.selectedMediaRV;
            if (recyclerView7 != null) {
                recyclerView7.invalidateItemDecorations();
            }
            za();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(PreviewUserInteractionPart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.selectedMediaRV;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(PreviewUserInteractionPart this$0, com.tencent.qqnt.qbasealbum.select.model.a action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        RecyclerView recyclerView = this$0.selectedMediaRV;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(((com.tencent.qqnt.qbasealbum.select.model.b) action).b());
        }
    }

    private final void aa() {
        LocalMediaInfo O1;
        SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
        if (selectedMediaViewModel != null && selectedMediaViewModel.getSelectedMedia().isEmpty() && !Intrinsics.areEqual(this.business, "FAST_IMAGE")) {
            PreviewMediaViewModel previewMediaViewModel = this.mediaPreviewViewModel;
            if (previewMediaViewModel != null && (O1 = previewMediaViewModel.O1()) != null) {
                SelectedMediaViewModel.O1(selectedMediaViewModel, O1, 0, 2, null);
            }
            PreviewMediaViewModel previewMediaViewModel2 = this.mediaPreviewViewModel;
            if (previewMediaViewModel2 != null) {
                previewMediaViewModel2.L1(previewMediaViewModel2.P1(), previewMediaViewModel2.O1());
            }
        }
    }

    private final void ba() {
        TextView textView = this.flashPicTv;
        if (textView != null) {
            ViewCompat.setImportantForAccessibility(textView, 2);
        }
        TextView textView2 = this.qualityTv;
        if (textView2 != null) {
            ViewCompat.setImportantForAccessibility(textView2, 2);
        }
        CheckBox checkBox = this.flashPicCb;
        if (checkBox != null) {
            checkBox.setContentDescription(getContext().getResources().getString(R.string.f1769732p));
        }
        CheckBox checkBox2 = this.qualityCb;
        if (checkBox2 != null) {
            checkBox2.setContentDescription(getContext().getResources().getString(R.string.f1772333e));
        }
    }

    public static /* synthetic */ void ga(PreviewUserInteractionPart previewUserInteractionPart, View view, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = true;
            }
            previewUserInteractionPart.ea(view, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onConfirmBtnClick");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(PreviewUserInteractionPart this$0, View it) {
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick(this$0.getTAG()) && (c16 = CustomizationFacade.f361084a.c()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            c16.onMagicStickClick(it, this$0.business);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(PreviewUserInteractionPart this$0, CompoundButton compoundButton, boolean z16) {
        LocalMediaInfo localMediaInfo;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PreviewMediaViewModel previewMediaViewModel = this$0.mediaPreviewViewModel;
        if (previewMediaViewModel != null) {
            localMediaInfo = previewMediaViewModel.O1();
        } else {
            localMediaInfo = null;
        }
        if (localMediaInfo != null) {
            CustomizationFacade customizationFacade = CustomizationFacade.f361084a;
            AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16 = customizationFacade.c();
            boolean z17 = false;
            if (c16 != null && c16.checkFlashPicChange(localMediaInfo, z16)) {
                z17 = true;
            }
            if (z17) {
                AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c17 = customizationFacade.c();
                if (c17 != null) {
                    c17.onFlashPicChangeEvent(localMediaInfo, z16);
                }
                if (z16) {
                    this$0.aa();
                }
                this$0.shareDataViewModel.T1(z16);
            } else {
                compoundButton.setChecked(!z16);
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(PreviewUserInteractionPart this$0, Boolean isRaw) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CheckBox checkBox = this$0.qualityCb;
        String str = null;
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(null);
        }
        CheckBox checkBox2 = this$0.qualityCb;
        if (checkBox2 != null) {
            Intrinsics.checkNotNullExpressionValue(isRaw, "isRaw");
            checkBox2.setChecked(isRaw.booleanValue());
        }
        CheckBox checkBox3 = this$0.qualityCb;
        if (checkBox3 != null) {
            checkBox3.setOnCheckedChangeListener(this$0.qualityCheckListener);
        }
        Intrinsics.checkNotNullExpressionValue(isRaw, "isRaw");
        if (isRaw.booleanValue()) {
            TextView textView = this$0.qualitySize;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this$0.qualitySize;
            if (textView2 != null) {
                SelectedMediaViewModel selectedMediaViewModel = this$0.selectedMediaViewModel;
                if (selectedMediaViewModel != null) {
                    str = selectedMediaViewModel.a2();
                }
                textView2.setText(str);
                return;
            }
            return;
        }
        TextView textView3 = this$0.qualitySize;
        if (textView3 != null) {
            textView3.setVisibility(4);
        }
        TextView textView4 = this$0.qualitySize;
        if (textView4 != null) {
            textView4.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(PreviewUserInteractionPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int a16 = com.tencent.biz.qui.quicommon.e.a(20.0f);
        com.tencent.qqnt.qbasealbum.utils.d.f361649a.d(this$0.qualityTv, a16, a16, a16, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(PreviewUserInteractionPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qqnt.qbasealbum.inject.g gVar = com.tencent.qqnt.qbasealbum.inject.g.f361234b;
        Object partHost = this$0.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        FragmentActivity requireActivity = ((Fragment) partHost).requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "partHost as Fragment).requireActivity()");
        gVar.h(requireActivity, this$0.shareDataViewModel.L1(), new e());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(PreviewUserInteractionPart this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QAlbumPickerContext.f361201a.l() == null) {
            TextView textView = this$0.commentTv;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(it)) {
            TextView textView2 = this$0.commentTv;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView3 = this$0.commentTv;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = this$0.commentTv;
        if (textView4 != null) {
            com.tencent.qqnt.qbasealbum.inject.g gVar = com.tencent.qqnt.qbasealbum.inject.g.f361234b;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            textView4.setText(gVar.p(it));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(PreviewUserInteractionPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick(this$0.getTAG())) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ga(this$0, it, false, 2, null);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
    
        if (r3 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void qa(PreviewUserInteractionPart this$0, View it) {
        Integer num;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PreviewMediaViewModel previewMediaViewModel = this$0.mediaPreviewViewModel;
        LocalMediaInfo localMediaInfo = null;
        if (previewMediaViewModel != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            num = Integer.valueOf(previewMediaViewModel.N1(it));
        } else {
            num = null;
        }
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16 = CustomizationFacade.f361084a.c();
        if (c16 != null) {
            PreviewMediaViewModel previewMediaViewModel2 = this$0.mediaPreviewViewModel;
            if (previewMediaViewModel2 != null) {
                localMediaInfo = previewMediaViewModel2.O1();
            }
            if (num != null) {
                int intValue = num.intValue();
                z16 = true;
            }
            z16 = false;
            c16.onCurrentSelectStatusChangeEvent(localMediaInfo, z16);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(PreviewUserInteractionPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPartHost partHost = this$0.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.biz.richframework.part.BasePartFragment");
        ((BasePartFragment) partHost).onBackEvent();
        this$0.getPartHost().getHostActivity().onBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(PreviewUserInteractionPart this$0, CompoundButton compoundButton, boolean z16) {
        LocalMediaInfo O1;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PreviewMediaViewModel previewMediaViewModel = this$0.mediaPreviewViewModel;
        if (previewMediaViewModel != null && (O1 = previewMediaViewModel.O1()) != null) {
            CustomizationFacade customizationFacade = CustomizationFacade.f361084a;
            AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16 = customizationFacade.c();
            boolean z17 = false;
            if (c16 != null && c16.checkQualityRawChange(O1, z16)) {
                z17 = true;
            }
            if (z17) {
                AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c17 = customizationFacade.c();
                if (c17 != null) {
                    c17.onQualityRawChangeEvent(O1, z16);
                }
                if (z16) {
                    this$0.aa();
                }
                this$0.shareDataViewModel.W1(z16);
            } else {
                compoundButton.setChecked(!z16);
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void wa(TextView textView, final CheckBox checkBox) {
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreviewUserInteractionPart.xa(checkBox, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(CheckBox checkBox, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (checkBox != null) {
            checkBox.setChecked(!checkBox.isChecked());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void za() {
        Integer num;
        String str;
        int i3;
        TextView textView;
        int i16;
        com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> photoCommonData;
        com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> photoCommonData2;
        List<LocalMediaInfo> selectedMedia;
        SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
        if (selectedMediaViewModel != null && (selectedMedia = selectedMediaViewModel.getSelectedMedia()) != null) {
            num = Integer.valueOf(selectedMedia.size());
        } else {
            num = null;
        }
        if (num != null && num.intValue() != 0) {
            str = "(" + num + ")";
        } else {
            str = "";
        }
        TextView textView2 = this.sendBtn;
        if (textView2 != null) {
            textView2.setText(this.sendInitText + str);
        }
        CustomizationFacade customizationFacade = CustomizationFacade.f361084a;
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16 = customizationFacade.c();
        boolean z16 = true;
        if (c16 != null && (photoCommonData2 = c16.getPhotoCommonData()) != null) {
            i3 = photoCommonData2.e();
        } else {
            i3 = 1;
        }
        if (i3 == 1) {
            TextView textView3 = this.sendBtn;
            if (textView3 != null) {
                textView3.setEnabled(true);
                return;
            }
            return;
        }
        if (num != null && (textView = this.sendBtn) != null) {
            int intValue = num.intValue();
            AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c17 = customizationFacade.c();
            if (c17 != null && (photoCommonData = c17.getPhotoCommonData()) != null) {
                i16 = photoCommonData.e();
            } else {
                i16 = 1;
            }
            if (intValue < i16) {
                z16 = false;
            }
            textView.setEnabled(z16);
        }
    }

    public final void ca(@NotNull com.tencent.qqnt.qbasealbum.datahub.a event) {
        TextView textView;
        String str;
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData;
        UIStateData<RFWLayerState> value;
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        c cVar = null;
        if (event instanceof com.tencent.qqnt.qbasealbum.datahub.q) {
            c cVar2 = this.selectedMediaAdapter;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                cVar2 = null;
            }
            com.tencent.qqnt.qbasealbum.datahub.q qVar = (com.tencent.qqnt.qbasealbum.datahub.q) event;
            if (cVar2.i0().contains(qVar.a())) {
                c cVar3 = this.selectedMediaAdapter;
                if (cVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                    cVar3 = null;
                }
                c cVar4 = this.selectedMediaAdapter;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                } else {
                    cVar = cVar4;
                }
                cVar3.notifyItemChanged(cVar.i0().indexOf(qVar.a()));
                return;
            }
        }
        if (event instanceof com.tencent.qqnt.qbasealbum.datahub.p) {
            if (this.previewMode == PreviewMode.SELECT_MODE && (textView = this.titleTv) != null) {
                PreviewMediaViewModel previewMediaViewModel = this.mediaPreviewViewModel;
                if (previewMediaViewModel != null) {
                    int P1 = previewMediaViewModel.P1();
                    RFWLayerViewModel rFWLayerViewModel = this.layerViewModel;
                    if (rFWLayerViewModel != null && (mutableLiveData = rFWLayerViewModel.mRichMediaInfo) != null && (value = mutableLiveData.getValue()) != null && (data = value.getData()) != null && (richMediaDataList = data.getRichMediaDataList()) != null) {
                        int size = richMediaDataList.size();
                        if (size == 1) {
                            str = "\u9884\u89c8";
                        } else {
                            str = (P1 + 1) + "/" + size;
                        }
                        textView.setText(str);
                    }
                }
                str = null;
                textView.setText(str);
            }
            c cVar5 = this.selectedMediaAdapter;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
            } else {
                cVar = cVar5;
            }
            cVar.notifyDataSetChanged();
        }
    }

    public final void da() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        ViewGroup viewGroup = null;
        if (this.isBarShow) {
            ViewGroup viewGroup2 = this.bottomBarRoot;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBarRoot");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(8);
            ViewGroup viewGroup3 = this.topBarRoot;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarRoot");
            } else {
                viewGroup = viewGroup3;
            }
            viewGroup.setVisibility(8);
        } else {
            ViewGroup viewGroup4 = this.bottomBarRoot;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBarRoot");
                viewGroup4 = null;
            }
            viewGroup4.setVisibility(0);
            ViewGroup viewGroup5 = this.topBarRoot;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarRoot");
            } else {
                viewGroup = viewGroup5;
            }
            viewGroup.setVisibility(0);
        }
        this.isBarShow = !this.isBarShow;
    }

    protected void ea(@NotNull View v3, boolean checkAnySelection) {
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, v3, Boolean.valueOf(checkAnySelection));
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        PreviewMediaViewModel previewMediaViewModel = this.mediaPreviewViewModel;
        if (previewMediaViewModel == null || previewMediaViewModel.M1(v3, checkAnySelection)) {
            z16 = false;
        }
        if (z16 && (c16 = CustomizationFacade.f361084a.c()) != null) {
            c16.onSendClick();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(SelectMediaSizeEvent.class);
        arrayList.add(MediaEditDoneEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "PreviewUserInteractionPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        CheckBox checkBox;
        List<LocalMediaInfo> selectedMedia;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        FrameLayout frameLayout = new FrameLayout(rootView.getContext());
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, com.tencent.qqnt.qbasealbum.ktx.d.b(44));
        layoutParams.topToTop = 0;
        frameLayout.setLayoutParams(layoutParams);
        this.topBarRoot = frameLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        constraintLayout.addView(frameLayout);
        CustomizationFacade customizationFacade = CustomizationFacade.f361084a;
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16 = customizationFacade.c();
        if (c16 != null) {
            Context context = constraintLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            ViewGroup viewGroup = this.topBarRoot;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarRoot");
                viewGroup = null;
            }
            View titleView = c16.getTitleView(context, viewGroup);
            if (titleView != null) {
                com.tencent.qqnt.qbasealbum.inject.g gVar = com.tencent.qqnt.qbasealbum.inject.g.f361234b;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                gVar.f(context2, titleView);
                ViewGroup viewGroup2 = this.topBarRoot;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topBarRoot");
                    viewGroup2 = null;
                }
                viewGroup2.addView(titleView);
                ViewGroup viewGroup3 = this.topBarRoot;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topBarRoot");
                    viewGroup3 = null;
                }
                viewGroup3.setVisibility(0);
            }
        }
        FrameLayout frameLayout2 = new FrameLayout(constraintLayout.getContext());
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams2.bottomToBottom = 0;
        frameLayout2.setLayoutParams(layoutParams2);
        this.bottomBarRoot = frameLayout2;
        constraintLayout.addView(frameLayout2);
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c17 = customizationFacade.c();
        if (c17 != null) {
            Context context3 = constraintLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "rootView.context");
            ViewGroup viewGroup4 = this.bottomBarRoot;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBarRoot");
                viewGroup4 = null;
            }
            View bottomView = c17.getBottomView(context3, viewGroup4);
            if (bottomView != null) {
                com.tencent.qqnt.qbasealbum.inject.g gVar2 = com.tencent.qqnt.qbasealbum.inject.g.f361234b;
                Context context4 = getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "context");
                gVar2.f(context4, bottomView);
                ViewGroup viewGroup5 = this.bottomBarRoot;
                if (viewGroup5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomBarRoot");
                    viewGroup5 = null;
                }
                viewGroup5.addView(bottomView);
                ViewGroup viewGroup6 = this.bottomBarRoot;
                if (viewGroup6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomBarRoot");
                    viewGroup6 = null;
                }
                viewGroup6.setVisibility(0);
            }
        }
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c18 = customizationFacade.c();
        if (c18 != null) {
            this.backBtn = c18.getBackBtn();
            this.titleTv = c18.getTitleTv();
            this.seqNumberText = c18.getSelectedBox();
            this.editBtn = c18.getMagicStickBtn();
            this.flashPicCb = c18.getFlashPicCb();
            this.flashPicTv = c18.getFlashPicTv();
            this.qualityCb = c18.getQualityCb();
            this.qualityTv = c18.getQualityTv();
            this.qualitySize = c18.getQualitySize();
            this.sendBtn = c18.getSendBtn();
            this.commentTv = c18.getCommentTv();
            this.selectedMediaRV = c18.getSelectListView();
            if (!c18.getPhotoCommonData().d()) {
                CheckBox checkBox2 = this.flashPicCb;
                if (checkBox2 != null) {
                    checkBox2.setVisibility(8);
                }
                TextView textView = this.flashPicTv;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            }
            if (!c18.getPhotoCommonData().g()) {
                CheckBox checkBox3 = this.qualityCb;
                if (checkBox3 != null) {
                    checkBox3.setVisibility(8);
                }
                TextView textView2 = this.qualityTv;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                TextView textView3 = this.qualitySize;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
            }
        }
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment");
        this.mediaPreviewViewModel = com.tencent.qqnt.qbasealbum.album.b.c((QAlbumBaseFragment) partHost);
        Object partHost2 = getPartHost();
        Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        FragmentActivity requireActivity = ((Fragment) partHost2).requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "partHost as Fragment).requireActivity()");
        SelectedMediaViewModel g16 = com.tencent.qqnt.qbasealbum.album.b.g(requireActivity);
        this.selectedMediaViewModel = g16;
        PreviewMediaViewModel previewMediaViewModel = this.mediaPreviewViewModel;
        if (previewMediaViewModel != null) {
            previewMediaViewModel.R1(g16);
        }
        View view = this.backBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PreviewUserInteractionPart.sa(PreviewUserInteractionPart.this, view2);
                }
            });
        }
        SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
        int size = (selectedMediaViewModel == null || (selectedMedia = selectedMediaViewModel.getSelectedMedia()) == null) ? 0 : selectedMedia.size();
        TextView textView4 = this.titleTv;
        if (textView4 != null) {
            textView4.setVisibility(this.previewMode != PreviewMode.NORMAL_MODE ? 0 : 8);
        }
        TextView textView5 = this.titleTv;
        if (textView5 != null) {
            int i3 = d.f361380a[this.previewMode.ordinal()];
            String str = "\u9884\u89c8";
            String str2 = "";
            if (i3 == 1) {
                if (!Intrinsics.areEqual(this.business, "FAST_IMAGE")) {
                    str = "";
                }
            } else {
                if (i3 == 2) {
                    PreviewMediaViewModel previewMediaViewModel2 = this.mediaPreviewViewModel;
                    if (previewMediaViewModel2 != null) {
                        int P1 = previewMediaViewModel2.P1();
                        if (size != 1) {
                            str = (P1 + 1) + "/" + size;
                        }
                    } else {
                        str2 = null;
                    }
                }
                textView5.setText(str2);
            }
            str2 = str;
            textView5.setText(str2);
        }
        this.selectedMediaAdapter = new c();
        RecyclerView recyclerView = this.selectedMediaRV;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        RecyclerView recyclerView2 = this.selectedMediaRV;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new com.tencent.qqnt.qbasealbum.view.a(com.tencent.qqnt.qbasealbum.ktx.d.a(8.0f)));
        }
        RecyclerView recyclerView3 = this.selectedMediaRV;
        if (recyclerView3 != null) {
            c cVar = this.selectedMediaAdapter;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                cVar = null;
            }
            recyclerView3.setAdapter(cVar);
        }
        SelectedMediaViewModel selectedMediaViewModel2 = this.selectedMediaViewModel;
        if (selectedMediaViewModel2 != null) {
            c cVar2 = this.selectedMediaAdapter;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                cVar2 = null;
            }
            cVar2.l0(selectedMediaViewModel2.getSelectedMedia());
            c cVar3 = this.selectedMediaAdapter;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                cVar3 = null;
            }
            cVar3.notifyDataSetChanged();
            LiveData<com.tencent.qqnt.qbasealbum.select.model.a> S1 = selectedMediaViewModel2.S1();
            IPartHost partHost3 = getPartHost();
            Intrinsics.checkNotNull(partHost3, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit> function1 = new Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.PreviewUserInteractionPart$onInitView$9$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreviewUserInteractionPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.select.model.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.qqnt.qbasealbum.select.model.a action) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) action);
                        return;
                    }
                    PreviewUserInteractionPart previewUserInteractionPart = PreviewUserInteractionPart.this;
                    Intrinsics.checkNotNullExpressionValue(action, "action");
                    previewUserInteractionPart.Aa(action);
                }
            };
            S1.observe((LifecycleOwner) partHost3, new Observer() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PreviewUserInteractionPart.ha(Function1.this, obj);
                }
            });
        }
        if (size > 0 && !Intrinsics.areEqual(this.business, "FAST_IMAGE")) {
            RecyclerView recyclerView4 = this.selectedMediaRV;
            if (recyclerView4 != null) {
                recyclerView4.setVisibility(0);
            }
            RecyclerView recyclerView5 = this.selectedMediaRV;
            if (recyclerView5 != null) {
                c cVar4 = this.selectedMediaAdapter;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                    cVar4 = null;
                }
                recyclerView5.setAdapter(cVar4);
            }
        } else {
            RecyclerView recyclerView6 = this.selectedMediaRV;
            if (recyclerView6 != null) {
                recyclerView6.setVisibility(8);
            }
        }
        TextView textView6 = this.editBtn;
        if (textView6 != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PreviewUserInteractionPart.ia(PreviewUserInteractionPart.this, view2);
                }
            });
        }
        CheckBox checkBox4 = this.flashPicCb;
        if (checkBox4 != null) {
            checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.l
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    PreviewUserInteractionPart.ja(PreviewUserInteractionPart.this, compoundButton, z16);
                }
            });
        }
        CheckBox checkBox5 = this.qualityCb;
        if (checkBox5 != null) {
            checkBox5.setOnCheckedChangeListener(this.qualityCheckListener);
        }
        com.tencent.qqnt.qbasealbum.share.a aVar = this.shareDataViewModel;
        IPartHost partHost4 = getPartHost();
        Intrinsics.checkNotNull(partHost4, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        aVar.Q1((LifecycleOwner) partHost4, new Observer() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PreviewUserInteractionPart.la(PreviewUserInteractionPart.this, (Boolean) obj);
            }
        });
        wa(this.qualityTv, this.qualityCb);
        wa(this.flashPicTv, this.flashPicCb);
        TextView textView7 = this.qualityTv;
        if (textView7 != null) {
            textView7.post(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.n
                @Override // java.lang.Runnable
                public final void run() {
                    PreviewUserInteractionPart.ma(PreviewUserInteractionPart.this);
                }
            });
        }
        if (QAlbumPickerContext.f361201a.l() != null) {
            TextView textView8 = this.commentTv;
            if (textView8 != null) {
                textView8.setText(com.tencent.qqnt.qbasealbum.inject.g.f361234b.p(this.shareDataViewModel.L1()));
            }
            TextView textView9 = this.commentTv;
            if (textView9 != null) {
                textView9.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
            TextView textView10 = this.commentTv;
            if (textView10 != null) {
                textView10.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        PreviewUserInteractionPart.na(PreviewUserInteractionPart.this, view2);
                    }
                });
            }
            com.tencent.qqnt.qbasealbum.share.a aVar2 = this.shareDataViewModel;
            IPartHost partHost5 = getPartHost();
            Intrinsics.checkNotNull(partHost5, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            aVar2.P1((LifecycleOwner) partHost5, new Observer() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PreviewUserInteractionPart.oa(PreviewUserInteractionPart.this, (String) obj);
                }
            });
        }
        TextView textView11 = this.sendBtn;
        if (textView11 != null) {
            textView11.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PreviewUserInteractionPart.pa(PreviewUserInteractionPart.this, view2);
                }
            });
        }
        TextView textView12 = this.sendBtn;
        this.sendInitText = String.valueOf(textView12 != null ? textView12.getText() : null);
        za();
        if (Intrinsics.areEqual(this.business, "FAST_IMAGE") && (checkBox = this.seqNumberText) != null) {
            checkBox.setVisibility(8);
        }
        CheckBox checkBox6 = this.seqNumberText;
        if (checkBox6 != null) {
            checkBox6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PreviewUserInteractionPart.qa(PreviewUserInteractionPart.this, view2);
                }
            });
        }
        PreviewMediaViewModel previewMediaViewModel3 = this.mediaPreviewViewModel;
        Intrinsics.checkNotNull(previewMediaViewModel3);
        LiveData<PreviewMediaViewModel.b> Q1 = previewMediaViewModel3.Q1();
        Object partHost6 = getPartHost();
        Intrinsics.checkNotNull(partHost6, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        LifecycleOwner viewLifecycleOwner = ((Fragment) partHost6).getViewLifecycleOwner();
        final Function1<PreviewMediaViewModel.b, Unit> function12 = new Function1<PreviewMediaViewModel.b, Unit>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.PreviewUserInteractionPart$onInitView$18
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreviewUserInteractionPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PreviewMediaViewModel.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:37:0x0093  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x00b3  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x00df  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x012d  */
            /* JADX WARN: Removed duplicated region for block: B:73:0x0132  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x013e  */
            /* JADX WARN: Removed duplicated region for block: B:79:0x0145  */
            /* JADX WARN: Removed duplicated region for block: B:80:0x00bc  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(PreviewMediaViewModel.b bVar) {
                CheckBox checkBox7;
                CheckBox checkBox8;
                Integer intOrNull;
                SelectedMediaViewModel selectedMediaViewModel3;
                boolean z16;
                TextView textView13;
                PreviewMode previewMode;
                CheckBox checkBox9;
                PreviewUserInteractionPart.c cVar5;
                TextView textView14;
                SelectedMediaViewModel selectedMediaViewModel4;
                SelectedMediaViewModel selectedMediaViewModel5;
                int size2;
                String str3;
                TextView textView15;
                List<LocalMediaInfo> selectedMedia2;
                String str4;
                List<LocalMediaInfo> selectedMedia3;
                CheckBox checkBox10;
                CheckBox checkBox11;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar);
                    return;
                }
                checkBox7 = PreviewUserInteractionPart.this.seqNumberText;
                if (checkBox7 != null) {
                    checkBox7.setChecked(bVar.b());
                }
                checkBox8 = PreviewUserInteractionPart.this.seqNumberText;
                if (checkBox8 != null) {
                    checkBox8.setText(bVar.a());
                }
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(bVar.a());
                if (intOrNull != null) {
                    PreviewUserInteractionPart previewUserInteractionPart = PreviewUserInteractionPart.this;
                    if (intOrNull.intValue() > 99) {
                        checkBox11 = previewUserInteractionPart.seqNumberText;
                        if (checkBox11 != null) {
                            checkBox11.setTextSize(2, 11.0f);
                        }
                    } else {
                        checkBox10 = previewUserInteractionPart.seqNumberText;
                        if (checkBox10 != null) {
                            checkBox10.setTextSize(2, 14.0f);
                        }
                    }
                }
                selectedMediaViewModel3 = PreviewUserInteractionPart.this.selectedMediaViewModel;
                boolean z17 = false;
                int size3 = (selectedMediaViewModel3 == null || (selectedMedia3 = selectedMediaViewModel3.getSelectedMedia()) == null) ? 0 : selectedMedia3.size();
                if (!bVar.b() && size3 != 0) {
                    str4 = PreviewUserInteractionPart.this.business;
                    if (!Intrinsics.areEqual(str4, "FAST_IMAGE")) {
                        z16 = false;
                        textView13 = PreviewUserInteractionPart.this.editBtn;
                        if (textView13 != null) {
                            textView13.setEnabled(z16);
                            textView13.setTextColor(textView13.getContext().getColorStateList(z16 ? R.color.qui_common_text_allwhite_primary : R.color.qui_common_text_secondary_light));
                        }
                        PreviewMediaViewModel previewMediaViewModel4 = PreviewUserInteractionPart.this.mediaPreviewViewModel;
                        PreviewUserInteractionPart.c cVar6 = null;
                        Integer valueOf = previewMediaViewModel4 == null ? Integer.valueOf(previewMediaViewModel4.P1()) : null;
                        previewMode = PreviewUserInteractionPart.this.previewMode;
                        if (previewMode == PreviewMode.SELECT_MODE && valueOf != null) {
                            selectedMediaViewModel5 = PreviewUserInteractionPart.this.selectedMediaViewModel;
                            size2 = (selectedMediaViewModel5 != null || (selectedMedia2 = selectedMediaViewModel5.getSelectedMedia()) == null) ? 0 : selectedMedia2.size();
                            if (size2 != 0) {
                                if (size2 == 1) {
                                    str3 = "\u9884\u89c8";
                                } else {
                                    str3 = (valueOf.intValue() + 1) + "/" + size2;
                                }
                                textView15 = PreviewUserInteractionPart.this.titleTv;
                                if (textView15 != null) {
                                    textView15.setText(str3);
                                }
                            }
                        }
                        checkBox9 = PreviewUserInteractionPart.this.qualityCb;
                        if (checkBox9 != null && checkBox9.isChecked()) {
                            z17 = true;
                        }
                        if (z17 && textView14 != null) {
                            selectedMediaViewModel4 = PreviewUserInteractionPart.this.selectedMediaViewModel;
                            textView14.setText(selectedMediaViewModel4 == null ? selectedMediaViewModel4.a2() : null);
                        }
                        cVar5 = PreviewUserInteractionPart.this.selectedMediaAdapter;
                        if (cVar5 != null) {
                            Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                        } else {
                            cVar6 = cVar5;
                        }
                        cVar6.notifyDataSetChanged();
                    }
                }
                z16 = true;
                textView13 = PreviewUserInteractionPart.this.editBtn;
                if (textView13 != null) {
                }
                PreviewMediaViewModel previewMediaViewModel42 = PreviewUserInteractionPart.this.mediaPreviewViewModel;
                PreviewUserInteractionPart.c cVar62 = null;
                if (previewMediaViewModel42 == null) {
                }
                previewMode = PreviewUserInteractionPart.this.previewMode;
                if (previewMode == PreviewMode.SELECT_MODE) {
                    selectedMediaViewModel5 = PreviewUserInteractionPart.this.selectedMediaViewModel;
                    if (selectedMediaViewModel5 != null) {
                    }
                    if (size2 != 0) {
                    }
                }
                checkBox9 = PreviewUserInteractionPart.this.qualityCb;
                if (checkBox9 != null) {
                    z17 = true;
                }
                if (z17) {
                    textView14 = PreviewUserInteractionPart.this.qualitySize;
                    selectedMediaViewModel4 = PreviewUserInteractionPart.this.selectedMediaViewModel;
                    textView14.setText(selectedMediaViewModel4 == null ? selectedMediaViewModel4.a2() : null);
                }
                cVar5 = PreviewUserInteractionPart.this.selectedMediaAdapter;
                if (cVar5 != null) {
                }
                cVar62.notifyDataSetChanged();
            }
        };
        Q1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PreviewUserInteractionPart.ra(Function1.this, obj);
            }
        });
        ba();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.layerViewModel = (RFWLayerViewModel) getViewModel(RFWLayerViewModel.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        CheckBox checkBox;
        boolean z16;
        TextView textView;
        String str;
        List<LocalMediaInfo> selectedMedia;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
            return;
        }
        boolean z17 = true;
        if (event instanceof SelectMediaSizeEvent) {
            CheckBox checkBox2 = this.qualityCb;
            if (checkBox2 != null && checkBox2.isChecked()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
                if (selectedMediaViewModel == null || (selectedMedia = selectedMediaViewModel.getSelectedMedia()) == null || !(!selectedMedia.isEmpty())) {
                    z17 = false;
                }
                if (z17 && (textView = this.qualitySize) != null) {
                    SelectedMediaViewModel selectedMediaViewModel2 = this.selectedMediaViewModel;
                    if (selectedMediaViewModel2 != null) {
                        str = selectedMediaViewModel2.a2();
                    } else {
                        str = null;
                    }
                    textView.setText(str);
                    return;
                }
                return;
            }
            return;
        }
        if ((event instanceof MediaEditDoneEvent) && !Intrinsics.areEqual(this.business, "FAST_IMAGE")) {
            CheckBox checkBox3 = this.seqNumberText;
            if (checkBox3 == null || checkBox3.isChecked()) {
                z17 = false;
            }
            if (z17 && (checkBox = this.seqNumberText) != null) {
                checkBox.performClick();
            }
        }
    }

    public final void ta() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        PreviewMediaViewModel previewMediaViewModel = this.mediaPreviewViewModel;
        if (previewMediaViewModel != null) {
            previewMediaViewModel.L1(previewMediaViewModel.P1(), previewMediaViewModel.O1());
            za();
        }
    }

    public final void va(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, visible);
            return;
        }
        ViewGroup viewGroup = null;
        if (visible) {
            ViewGroup viewGroup2 = this.bottomBarRoot;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBarRoot");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(0);
            ViewGroup viewGroup3 = this.topBarRoot;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarRoot");
            } else {
                viewGroup = viewGroup3;
            }
            viewGroup.setVisibility(0);
            return;
        }
        ViewGroup viewGroup4 = this.bottomBarRoot;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBarRoot");
            viewGroup4 = null;
        }
        viewGroup4.setVisibility(8);
        ViewGroup viewGroup5 = this.topBarRoot;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBarRoot");
        } else {
            viewGroup = viewGroup5;
        }
        viewGroup.setVisibility(8);
    }
}
