package com.tencent.qqnt.qbasealbum.album.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart;
import com.tencent.qqnt.qbasealbum.album.viewmodel.TimelineController;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import com.tencent.qqnt.qbasealbum.base.viewmodel.PickerBaseViewModel;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic;
import com.tencent.qqnt.qbasealbum.event.HalfModeExitEvent;
import com.tencent.qqnt.qbasealbum.event.OpenHalfAlbumEvent;
import com.tencent.qqnt.qbasealbum.event.PreviewEnterEvent;
import com.tencent.qqnt.qbasealbum.event.PreviewExitEvent;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.ktx.ListExKt;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.query.QueryViewModel;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import com.tencent.qqnt.qbasealbum.view.MediaRecyclerView;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 x2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002yzB\u0017\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010I\u001a\u00020F\u00a2\u0006\u0004\bv\u0010wJ\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0003J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\u001c\u0010\u0017\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013H\u0003J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J3\u0010!\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+H\u0002J\b\u0010.\u001a\u00020\u000bH\u0016J\u0006\u0010/\u001a\u00020\u0007J\u0012\u00102\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u000100H\u0016J\u001c\u00107\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u0001032\b\u00106\u001a\u0004\u0018\u000105H\u0016J\u0012\u00108\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010<\u001a\u00020+2\u0006\u00109\u001a\u00020\u00052\u0006\u0010;\u001a\u00020:H\u0017J\u0012\u0010=\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040?0>H\u0016J\u0012\u0010A\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u000103H\u0016R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010P\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010KR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010X\u001a\u00060UR\u00020\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010c\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010bR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010j\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010KR\u0016\u0010n\u001a\u0004\u0018\u00010k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010u\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010t\u00a8\u0006{"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "ca", "W9", "sa", "", "elementId", "clickView", "ra", "Y9", "Z9", "initViewModel", "X9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "uiStateData", "va", "ta", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", "action", "wa", "", "index", QAdVrReportParams.ParamKey.MEDIA, "", "payloads", "la", "(Ljava/lang/Integer;Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;Ljava/lang/Object;)V", "xa", "Lcom/tencent/qqnt/qbasealbum/select/model/h;", "qa", "na", "Lcom/tencent/qqnt/qbasealbum/select/model/e;", "oa", "Lcom/tencent/qqnt/qbasealbum/select/model/g;", "pa", "", "isResume", "V9", "getLogTag", "refresh", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onInitView", "v", "Landroid/view/MotionEvent;", "event", "onTouch", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "onPartDestroy", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "d", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "pageType", "Lcom/tencent/qqnt/qbasealbum/base/viewmodel/PickerBaseViewModel;", "e", "Lcom/tencent/qqnt/qbasealbum/base/viewmodel/PickerBaseViewModel;", "pickerViewModel", "f", "I", "mediaItemSpanCount", tl.h.F, "viewHolderGap", "i", "mediaViewHolderSize", "Lcom/tencent/qqnt/qbasealbum/view/MediaRecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/qbasealbum/view/MediaRecyclerView;", "mediaRecyclerView", "Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart$MediaListAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart$MediaListAdapter;", "mediaListAdapter", "Landroidx/recyclerview/widget/GridLayoutManager;", "D", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "E", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", UserInfo.SEX_FEMALE, "Z", "showFooter", "G", "selectEnable", "Lcom/tencent/qqnt/qbasealbum/album/viewmodel/TimelineController;", "H", "Lcom/tencent/qqnt/qbasealbum/album/viewmodel/TimelineController;", "timelineController", "timeBubbleOffset", "Lcom/tencent/qqnt/qbasealbum/base/model/c;", "J", "Lcom/tencent/qqnt/qbasealbum/base/model/c;", "performanceMonitorCallback", "Lcom/tencent/qqnt/qbasealbum/query/QueryViewModel;", "K", "Lcom/tencent/qqnt/qbasealbum/query/QueryViewModel;", "queryViewModel", "L", "Landroid/view/View;", "tipsLayout", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/PageType;Lcom/tencent/qqnt/qbasealbum/base/viewmodel/PickerBaseViewModel;)V", "M", "a", "MediaListAdapter", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PickerMediaListPart extends Part implements View.OnTouchListener, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private MediaListAdapter mediaListAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private GridLayoutManager layoutManager;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private SelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean showFooter;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean selectEnable;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TimelineController timelineController;

    /* renamed from: I, reason: from kotlin metadata */
    private final int timeBubbleOffset;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.qbasealbum.base.model.c performanceMonitorCallback;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private QueryViewModel queryViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View tipsLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PageType pageType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PickerBaseViewModel pickerViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mediaItemSpanCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int viewHolderGap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mediaViewHolderSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MediaRecyclerView mediaRecyclerView;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart$a;", "", "", "MEDIA_ITEM_SPAN_COUNT", "I", "", "REFRESH_SEQ", "Ljava/lang/String;", "REFRESH_THUMB_ALPHA", "SPECIAL_ITEM_SPAN_COUNT", "TAG", "", "THUMB_IMAGE_DISABLE_ALPHA", UserInfo.SEX_FEMALE, "THUMB_IMAGE_ENABLE_ALPHA", "TIPS_ELEMENT_ID", "VIEW_HOLD_GAP", "VIEW_TYPE_CONTENT", "VIEW_TYPE_CONTENT_FIRST_ROW", "VIEW_TYPE_EMPTY", "VIEW_TYPE_FOOTER", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart$a, reason: from kotlin metadata */
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f360767a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31228);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[PageType.values().length];
            try {
                iArr[PageType.LOCAL_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageType.LOCAL_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PageType.LOCAL_IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PageType.QZONE_ALL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PageType.ONLINE_ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f360767a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart$c", "Landroidx/recyclerview/widget/GridLayoutManager;", "", "supportsPredictiveItemAnimations", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends GridLayoutManager {
        static IPatchRedirector $redirector_;

        c(Context context, int i3) {
            super(context, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            }
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean supportsPredictiveItemAnimations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart$d", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends GridLayoutManager.SpanSizeLookup {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerMediaListPart.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanSize(int position) {
            boolean z16;
            MediaListAdapter mediaListAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, position)).intValue();
            }
            MediaListAdapter mediaListAdapter2 = null;
            if (PickerMediaListPart.this.showFooter) {
                MediaListAdapter mediaListAdapter3 = PickerMediaListPart.this.mediaListAdapter;
                if (mediaListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter3 = null;
                }
                if (position == mediaListAdapter3.getNUM_BACKGOURND_ICON() - 1) {
                    z16 = true;
                    mediaListAdapter = PickerMediaListPart.this.mediaListAdapter;
                    if (mediaListAdapter != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    } else {
                        mediaListAdapter2 = mediaListAdapter;
                    }
                    boolean isEmpty = mediaListAdapter2.j0().isEmpty();
                    if (!z16 || isEmpty) {
                        return PickerMediaListPart.this.mediaItemSpanCount;
                    }
                    return 1;
                }
            }
            z16 = false;
            mediaListAdapter = PickerMediaListPart.this.mediaListAdapter;
            if (mediaListAdapter != null) {
            }
            boolean isEmpty2 = mediaListAdapter2.j0().isEmpty();
            if (!z16) {
            }
            return PickerMediaListPart.this.mediaItemSpanCount;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerMediaListPart.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            com.tencent.qqnt.qbasealbum.base.model.c cVar = PickerMediaListPart.this.performanceMonitorCallback;
            if (cVar != null) {
                cVar.a(PickerMediaListPart.this.pageType, newState);
            }
            PickerMediaListPart pickerMediaListPart = PickerMediaListPart.this;
            if (newState != 0 && newState != 2) {
                z16 = false;
            } else {
                z16 = true;
            }
            pickerMediaListPart.V9(z16);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
            } else {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32501);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PickerMediaListPart(@NotNull PageType pageType, @NotNull PickerBaseViewModel pickerViewModel) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(pickerViewModel, "pickerViewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pageType, (Object) pickerViewModel);
            return;
        }
        this.pageType = pageType;
        this.pickerViewModel = pickerViewModel;
        this.mediaItemSpanCount = 4;
        this.selectEnable = true;
        this.timeBubbleOffset = com.tencent.qqnt.qbasealbum.ktx.d.b(59);
        this.performanceMonitorCallback = QAlbumPickerContext.f361201a.g().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(final boolean isResume) {
        try {
            ox3.a.a("QBaseAlbum.MediaLoad", new Function0<String>(isResume) { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart$changeURLDrawableStatus$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isResume;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$isResume = isResume;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, isResume);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "media list scrollStateChanged, URLDrawable isResume:" + this.$isResume;
                }
            });
            if (isResume) {
                URLDrawable.resume();
            } else {
                URLDrawable.pause();
            }
        } catch (Throwable th5) {
            ox3.a.f("QBaseAlbum.MediaLoad", new Function0<String>(th5) { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart$changeURLDrawableStatus$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Throwable $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = th5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) th5);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "media list URLDrawable status error, " + this.$e;
                }
            });
        }
    }

    private final void W9() {
        View view = this.tipsLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        com.tencent.qqnt.qbasealbum.utils.a.f361642a.g();
    }

    private final void X9() {
        MediaDragSelectHelper mediaDragSelectHelper;
        MediaRecyclerView mediaRecyclerView;
        MediaRecyclerView mediaRecyclerView2 = this.mediaRecyclerView;
        MediaRecyclerView mediaRecyclerView3 = null;
        if (mediaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView2 = null;
        }
        SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
        if (selectedMediaViewModel != null) {
            AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
            MediaRecyclerView mediaRecyclerView4 = this.mediaRecyclerView;
            if (mediaRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView = null;
            } else {
                mediaRecyclerView = mediaRecyclerView4;
            }
            PageType pageType = this.pageType;
            MediaListAdapter mediaListAdapter = this.mediaListAdapter;
            if (mediaListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                mediaListAdapter = null;
            }
            mediaDragSelectHelper = new MediaDragSelectHelper(b16, mediaRecyclerView, pageType, mediaListAdapter.j0(), selectedMediaViewModel);
        } else {
            mediaDragSelectHelper = null;
        }
        mediaRecyclerView2.setOnIndexChangedListener(mediaDragSelectHelper);
        MediaRecyclerView mediaRecyclerView5 = this.mediaRecyclerView;
        if (mediaRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView5 = null;
        }
        if (mediaRecyclerView5.getLayoutManager() instanceof GridLayoutManager) {
            MediaRecyclerView mediaRecyclerView6 = this.mediaRecyclerView;
            if (mediaRecyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView6 = null;
            }
            MediaRecyclerView mediaRecyclerView7 = this.mediaRecyclerView;
            if (mediaRecyclerView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            } else {
                mediaRecyclerView3 = mediaRecyclerView7;
            }
            RecyclerView.LayoutManager layoutManager = mediaRecyclerView3.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            mediaRecyclerView6.setGridLayoutManager((GridLayoutManager) layoutManager);
        }
    }

    private final void Y9() {
        SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
        if (selectedMediaViewModel == null) {
            return;
        }
        Intrinsics.checkNotNull(selectedMediaViewModel);
        MediaListAdapter mediaListAdapter = new MediaListAdapter(this, selectedMediaViewModel);
        this.mediaListAdapter = mediaListAdapter;
        mediaListAdapter.setHasStableIds(true);
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
        MediaRecyclerView mediaRecyclerView = null;
        if (b16 != null) {
            com.tencent.qqnt.qbasealbum.customization.picker.b bVar = b16.pickerData;
            MediaListAdapter mediaListAdapter2 = this.mediaListAdapter;
            if (mediaListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                mediaListAdapter2 = null;
            }
            bVar.c(mediaListAdapter2.j0());
        }
        c cVar = new c(getContext(), this.mediaItemSpanCount);
        this.layoutManager = cVar;
        cVar.setSpanSizeLookup(new d());
        View findViewById = getPartRootView().findViewById(R.id.yzg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.mediaRecyclerView)");
        this.mediaRecyclerView = (MediaRecyclerView) findViewById;
        QAlbumBaseMainFragment<?> a16 = com.tencent.qqnt.qbasealbum.ktx.c.a(this);
        if (a16 != null) {
            PageType pageType = this.pageType;
            MediaRecyclerView mediaRecyclerView2 = this.mediaRecyclerView;
            if (mediaRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView2 = null;
            }
            a16.vh(pageType, mediaRecyclerView2);
        }
        MediaRecyclerView mediaRecyclerView3 = this.mediaRecyclerView;
        if (mediaRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView3 = null;
        }
        GridLayoutManager gridLayoutManager = this.layoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager = null;
        }
        mediaRecyclerView3.setLayoutManager(gridLayoutManager);
        MediaRecyclerView mediaRecyclerView4 = this.mediaRecyclerView;
        if (mediaRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView4 = null;
        }
        MediaListAdapter mediaListAdapter3 = this.mediaListAdapter;
        if (mediaListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            mediaListAdapter3 = null;
        }
        mediaRecyclerView4.setAdapter(mediaListAdapter3);
        MediaRecyclerView mediaRecyclerView5 = this.mediaRecyclerView;
        if (mediaRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
        } else {
            mediaRecyclerView = mediaRecyclerView5;
        }
        mediaRecyclerView.addOnScrollListener(new e());
        if (QAlbumPickerContext.f361201a.e().l()) {
            X9();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void Z9() {
        View view;
        LiveData<com.tencent.qqnt.qbasealbum.select.model.a> S1;
        if (QAlbumPickerContext.f361201a.e().m() && this.pageType.isLocalMedia()) {
            View partRootView = getPartRootView();
            MediaRecyclerView mediaRecyclerView = null;
            if (partRootView != null) {
                view = partRootView.findViewById(R.id.f246109l);
            } else {
                view = null;
            }
            View rootView = getPartRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            MediaRecyclerView mediaRecyclerView2 = this.mediaRecyclerView;
            if (mediaRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView2 = null;
            }
            this.timelineController = new TimelineController(rootView, mediaRecyclerView2, this.mediaItemSpanCount, this.queryViewModel);
            MediaRecyclerView mediaRecyclerView3 = this.mediaRecyclerView;
            if (mediaRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView3 = null;
            }
            mediaRecyclerView3.setOnTouchListener(this);
            if (view != null) {
                view.setOnTouchListener(this);
            }
            MediaRecyclerView mediaRecyclerView4 = this.mediaRecyclerView;
            if (mediaRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            } else {
                mediaRecyclerView = mediaRecyclerView4;
            }
            mediaRecyclerView.post(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.album.view.l
                @Override // java.lang.Runnable
                public final void run() {
                    PickerMediaListPart.aa(PickerMediaListPart.this);
                }
            });
            SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
            if (selectedMediaViewModel != null && (S1 = selectedMediaViewModel.S1()) != null) {
                Object partHost = getPartHost();
                Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
                LifecycleOwner viewLifecycleOwner = ((Fragment) partHost).getViewLifecycleOwner();
                final PickerMediaListPart$initTimelineView$2 pickerMediaListPart$initTimelineView$2 = new PickerMediaListPart$initTimelineView$2(this);
                S1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.qbasealbum.album.view.m
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        PickerMediaListPart.ba(Function1.this, obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(PickerMediaListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimelineController timelineController = this$0.timelineController;
        if (timelineController != null) {
            MediaRecyclerView mediaRecyclerView = this$0.mediaRecyclerView;
            MediaRecyclerView mediaRecyclerView2 = null;
            if (mediaRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView = null;
            }
            int height = mediaRecyclerView.getHeight();
            MediaRecyclerView mediaRecyclerView3 = this$0.mediaRecyclerView;
            if (mediaRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            } else {
                mediaRecyclerView2 = mediaRecyclerView3;
            }
            timelineController.A((height - mediaRecyclerView2.getTop()) - this$0.timeBubbleOffset);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ca(View rootView) {
        View view;
        final TextView textView;
        ViewStub viewStub;
        final ImageView imageView = null;
        if (rootView != null && (viewStub = (ViewStub) rootView.findViewById(R.id.f29850mr)) != null) {
            view = viewStub.inflate();
        } else {
            view = null;
        }
        this.tipsLayout = view;
        if (view != null) {
            com.tencent.qqnt.qbasealbum.inject.g gVar = com.tencent.qqnt.qbasealbum.inject.g.f361234b;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            gVar.f(activity, view);
        }
        View view2 = this.tipsLayout;
        if (view2 != null) {
            textView = (TextView) view2.findViewById(R.id.f83964kz);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.album.view.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    PickerMediaListPart.da(PickerMediaListPart.this, textView, view3);
                }
            });
        }
        View view3 = this.tipsLayout;
        if (view3 != null) {
            imageView = (ImageView) view3.findViewById(R.id.azb);
        }
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.album.view.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    PickerMediaListPart.ea(PickerMediaListPart.this, imageView, view4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(PickerMediaListPart this$0, TextView textView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        aVar.n(activity, false);
        this$0.W9();
        this$0.ra("em_bas_text_chain", textView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(PickerMediaListPart this$0, ImageView imageView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W9();
        this$0.ra("em_bas_close", imageView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initViewModel() {
        LiveData<com.tencent.qqnt.qbasealbum.select.model.a> W1;
        QAlbumBaseMainFragment<?> a16 = com.tencent.qqnt.qbasealbum.ktx.c.a(this);
        if (a16 != null) {
            FragmentActivity requireActivity = a16.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            SelectedMediaViewModel g16 = com.tencent.qqnt.qbasealbum.album.b.g(requireActivity);
            this.pickerViewModel.Z1(this.pageType, g16.S1());
            this.selectedMediaViewModel = g16;
            FragmentActivity requireActivity2 = a16.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            this.queryViewModel = com.tencent.qqnt.qbasealbum.album.b.f(requireActivity2);
        }
        LiveData<UIStateData<List<LocalMediaInfo>>> U1 = this.pickerViewModel.U1(this.pageType);
        Object partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        LifecycleOwner viewLifecycleOwner = ((Fragment) partHost).getViewLifecycleOwner();
        final Function1<UIStateData<List<LocalMediaInfo>>, Unit> function1 = new Function1<UIStateData<List<LocalMediaInfo>>, Unit>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart$initViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerMediaListPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<LocalMediaInfo>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<LocalMediaInfo>> uiStateData) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) uiStateData);
                    return;
                }
                PickerMediaListPart pickerMediaListPart = PickerMediaListPart.this;
                Intrinsics.checkNotNullExpressionValue(uiStateData, "uiStateData");
                pickerMediaListPart.va(uiStateData);
            }
        };
        U1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.qbasealbum.album.view.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PickerMediaListPart.ja(Function1.this, obj);
            }
        });
        LiveData<com.tencent.qqnt.qbasealbum.select.model.a> mediaChangedActionLiveData = this.pickerViewModel.getMediaChangedActionLiveData();
        Object partHost2 = getPartHost();
        Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        LifecycleOwner viewLifecycleOwner2 = ((Fragment) partHost2).getViewLifecycleOwner();
        final Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit> function12 = new Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart$initViewModel$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerMediaListPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.select.model.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.qbasealbum.select.model.a action) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) action);
                    return;
                }
                PickerMediaListPart pickerMediaListPart = PickerMediaListPart.this;
                Intrinsics.checkNotNullExpressionValue(action, "action");
                pickerMediaListPart.xa(action);
            }
        };
        mediaChangedActionLiveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.qqnt.qbasealbum.album.view.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PickerMediaListPart.ga(Function1.this, obj);
            }
        });
        QueryViewModel queryViewModel = this.queryViewModel;
        if (queryViewModel != null && (W1 = queryViewModel.W1()) != null) {
            Object partHost3 = getPartHost();
            Intrinsics.checkNotNull(partHost3, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            LifecycleOwner viewLifecycleOwner3 = ((Fragment) partHost3).getViewLifecycleOwner();
            final Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit> function13 = new Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart$initViewModel$4
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerMediaListPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.select.model.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.qqnt.qbasealbum.select.model.a action) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) action);
                        return;
                    }
                    PickerMediaListPart pickerMediaListPart = PickerMediaListPart.this;
                    Intrinsics.checkNotNullExpressionValue(action, "action");
                    pickerMediaListPart.wa(action);
                }
            };
            W1.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.qqnt.qbasealbum.album.view.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PickerMediaListPart.ha(Function1.this, obj);
                }
            });
        }
        MutableLiveData<String> T1 = this.pickerViewModel.T1();
        Object partHost4 = getPartHost();
        Intrinsics.checkNotNull(partHost4, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        LifecycleOwner viewLifecycleOwner4 = ((Fragment) partHost4).getViewLifecycleOwner();
        final Function1<String, Unit> function14 = new Function1<String, Unit>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart$initViewModel$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerMediaListPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                TimelineController timelineController;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                timelineController = PickerMediaListPart.this.timelineController;
                if (timelineController != null) {
                    timelineController.E();
                }
            }
        };
        T1.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.qqnt.qbasealbum.album.view.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PickerMediaListPart.ia(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void la(Integer index, LocalMediaInfo media, Object payloads) {
        int indexOf;
        int i3 = b.f360767a[this.pageType.ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) {
            MediaListAdapter mediaListAdapter = null;
            if (index != null) {
                indexOf = index.intValue();
            } else {
                MediaListAdapter mediaListAdapter2 = this.mediaListAdapter;
                if (mediaListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter2 = null;
                }
                indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends LocalMediaInfo>) ((List<? extends Object>) mediaListAdapter2.j0()), media);
            }
            if (indexOf != -1) {
                MediaListAdapter mediaListAdapter3 = this.mediaListAdapter;
                if (mediaListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                } else {
                    mediaListAdapter = mediaListAdapter3;
                }
                mediaListAdapter.notifyItemChanged(indexOf, payloads);
            }
        }
    }

    static /* synthetic */ void ma(PickerMediaListPart pickerMediaListPart, Integer num, LocalMediaInfo localMediaInfo, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        if ((i3 & 2) != 0) {
            localMediaInfo = null;
        }
        if ((i3 & 4) != 0) {
            obj = null;
        }
        pickerMediaListPart.la(num, localMediaInfo, obj);
    }

    private final void na() {
        this.selectEnable = false;
        MediaListAdapter mediaListAdapter = this.mediaListAdapter;
        if (mediaListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            mediaListAdapter = null;
        }
        int size = mediaListAdapter.j0().size();
        for (int i3 = 0; i3 < size; i3++) {
            ma(this, Integer.valueOf(i3), null, "refreshThumbAlpha", 2, null);
        }
    }

    private final void oa(com.tencent.qqnt.qbasealbum.select.model.e action) {
        MediaListAdapter mediaListAdapter = this.mediaListAdapter;
        MediaListAdapter mediaListAdapter2 = null;
        if (mediaListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            mediaListAdapter = null;
        }
        int indexOf = mediaListAdapter.j0().indexOf(action.a());
        if (action.b() != -1) {
            MediaListAdapter mediaListAdapter3 = this.mediaListAdapter;
            if (mediaListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            } else {
                mediaListAdapter2 = mediaListAdapter3;
            }
            mediaListAdapter2.notifyItemChanged(indexOf, action);
            return;
        }
        MediaListAdapter mediaListAdapter4 = this.mediaListAdapter;
        if (mediaListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
        } else {
            mediaListAdapter2 = mediaListAdapter4;
        }
        mediaListAdapter2.notifyItemChanged(indexOf);
    }

    private final void pa(com.tencent.qqnt.qbasealbum.select.model.g action) {
        ma(this, null, action.c().get(action.a()), "refreshSeq", 1, null);
        ma(this, null, action.c().get(action.b()), "refreshSeq", 1, null);
    }

    private final void qa(com.tencent.qqnt.qbasealbum.select.model.h action) {
        if (!this.selectEnable) {
            this.selectEnable = true;
            MediaListAdapter mediaListAdapter = this.mediaListAdapter;
            if (mediaListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                mediaListAdapter = null;
            }
            int size = mediaListAdapter.j0().size();
            for (int i3 = 0; i3 < size; i3++) {
                List<LocalMediaInfo> c16 = action.c();
                MediaListAdapter mediaListAdapter2 = this.mediaListAdapter;
                if (mediaListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter2 = null;
                }
                if (!c16.contains(mediaListAdapter2.j0().get(i3))) {
                    ma(this, Integer.valueOf(i3), null, "refreshThumbAlpha", 2, null);
                }
            }
        }
        Iterator<T> it = action.c().iterator();
        while (it.hasNext()) {
            ma(this, null, (LocalMediaInfo) it.next(), "refreshSeq", 1, null);
        }
        ma(this, null, action.b(), null, 5, null);
    }

    private final void ra(String elementId, View clickView) {
        HashMap hashMap = new HashMap();
        VideoReport.setElementId(clickView, elementId);
        VideoReport.setElementClickPolicy(clickView, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", clickView, hashMap);
    }

    private final void sa() {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_album_selector");
        hashMap.put("graph_selector_source", 2);
        hashMap.put("dt_eid", "em_bas_guide_small_horizontal_bar");
        VideoReport.reportEvent("dt_imp", hashMap);
    }

    private final void ta() {
        MediaRecyclerView mediaRecyclerView = this.mediaRecyclerView;
        if (mediaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView = null;
        }
        mediaRecyclerView.post(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.album.view.o
            @Override // java.lang.Runnable
            public final void run() {
                PickerMediaListPart.ua(PickerMediaListPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(PickerMediaListPart this$0) {
        int coerceAtLeast;
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GridLayoutManager gridLayoutManager = this$0.layoutManager;
        MediaListAdapter mediaListAdapter = null;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager = null;
        }
        int findFirstCompletelyVisibleItemPosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
        GridLayoutManager gridLayoutManager2 = this$0.layoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager2 = null;
        }
        int findLastCompletelyVisibleItemPosition = gridLayoutManager2.findLastCompletelyVisibleItemPosition();
        ox3.a.c("QBaseAlbum.MediaLoad", PickerMediaListPart$updateByAlbumChange$1$1.INSTANCE);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(findFirstCompletelyVisibleItemPosition - 300, 0);
        int i3 = findLastCompletelyVisibleItemPosition + 300;
        MediaListAdapter mediaListAdapter2 = this$0.mediaListAdapter;
        if (mediaListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            mediaListAdapter2 = null;
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, mediaListAdapter2.j0().size());
        MediaListAdapter mediaListAdapter3 = this$0.mediaListAdapter;
        if (mediaListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
        } else {
            mediaListAdapter = mediaListAdapter3;
        }
        List a16 = ListExKt.a(new ArrayList(mediaListAdapter.j0()), coerceAtLeast, coerceAtMost);
        QueryViewModel queryViewModel = this$0.queryViewModel;
        if (queryViewModel != null) {
            QueryViewModel.b2(queryViewModel, coerceAtLeast, coerceAtMost, a16, true, null, true, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public final void va(UIStateData<List<LocalMediaInfo>> uiStateData) {
        String str;
        String str2;
        int state = uiStateData.getState();
        boolean z16 = false;
        MediaListAdapter mediaListAdapter = null;
        if (state != 0) {
            if (state == 2 || state == 3) {
                this.showFooter = !uiStateData.getIsFinish();
                MediaListAdapter mediaListAdapter2 = this.mediaListAdapter;
                if (mediaListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter2 = null;
                }
                int size = mediaListAdapter2.j0().size();
                int size2 = uiStateData.getData().size();
                if (size != 0 && size <= size2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            MediaListAdapter mediaListAdapter3 = this.mediaListAdapter;
                            if (mediaListAdapter3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                                mediaListAdapter3 = null;
                            }
                            LocalMediaInfo localMediaInfo = mediaListAdapter3.j0().get(i3);
                            if (localMediaInfo != null) {
                                str = localMediaInfo.getPath();
                            } else {
                                str = null;
                            }
                            LocalMediaInfo localMediaInfo2 = uiStateData.getData().get(i3);
                            if (localMediaInfo2 != null) {
                                str2 = localMediaInfo2.getPath();
                            } else {
                                str2 = null;
                            }
                            if (!Intrinsics.areEqual(str, str2)) {
                                break;
                            }
                            MediaListAdapter mediaListAdapter4 = this.mediaListAdapter;
                            if (mediaListAdapter4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                                mediaListAdapter4 = null;
                            }
                            if (com.tencent.qqnt.qbasealbum.ktx.b.j(mediaListAdapter4.j0().get(i3)) && !this.showFooter) {
                                MediaListAdapter mediaListAdapter5 = this.mediaListAdapter;
                                if (mediaListAdapter5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                                    mediaListAdapter5 = null;
                                }
                                mediaListAdapter5.notifyItemChanged(i3);
                            }
                            i3++;
                        } else {
                            z16 = true;
                            break;
                        }
                    }
                    if (!z16) {
                        MediaListAdapter mediaListAdapter6 = this.mediaListAdapter;
                        if (mediaListAdapter6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                            mediaListAdapter6 = null;
                        }
                        mediaListAdapter6.j0().clear();
                        MediaListAdapter mediaListAdapter7 = this.mediaListAdapter;
                        if (mediaListAdapter7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                            mediaListAdapter7 = null;
                        }
                        List<LocalMediaInfo> j06 = mediaListAdapter7.j0();
                        List<LocalMediaInfo> data = uiStateData.getData();
                        Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
                        j06.addAll(data);
                        MediaListAdapter mediaListAdapter8 = this.mediaListAdapter;
                        if (mediaListAdapter8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                        } else {
                            mediaListAdapter = mediaListAdapter8;
                        }
                        mediaListAdapter.notifyDataSetChanged();
                        TimelineController timelineController = this.timelineController;
                        if (timelineController != null) {
                            timelineController.B(uiStateData);
                        }
                        ta();
                        return;
                    }
                    MediaListAdapter mediaListAdapter9 = this.mediaListAdapter;
                    if (mediaListAdapter9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                        mediaListAdapter9 = null;
                    }
                    mediaListAdapter9.j0().clear();
                    MediaListAdapter mediaListAdapter10 = this.mediaListAdapter;
                    if (mediaListAdapter10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                        mediaListAdapter10 = null;
                    }
                    List<LocalMediaInfo> j07 = mediaListAdapter10.j0();
                    List<LocalMediaInfo> data2 = uiStateData.getData();
                    Intrinsics.checkNotNullExpressionValue(data2, "uiStateData.data");
                    j07.addAll(data2);
                    MediaListAdapter mediaListAdapter11 = this.mediaListAdapter;
                    if (mediaListAdapter11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    } else {
                        mediaListAdapter = mediaListAdapter11;
                    }
                    mediaListAdapter.notifyItemRangeInserted(size, size2);
                    TimelineController timelineController2 = this.timelineController;
                    if (timelineController2 != null) {
                        timelineController2.B(uiStateData);
                        return;
                    }
                    return;
                }
                MediaListAdapter mediaListAdapter12 = this.mediaListAdapter;
                if (mediaListAdapter12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter12 = null;
                }
                mediaListAdapter12.j0().clear();
                MediaListAdapter mediaListAdapter13 = this.mediaListAdapter;
                if (mediaListAdapter13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter13 = null;
                }
                List<LocalMediaInfo> j08 = mediaListAdapter13.j0();
                List<LocalMediaInfo> data3 = uiStateData.getData();
                Intrinsics.checkNotNullExpressionValue(data3, "uiStateData.data");
                j08.addAll(data3);
                MediaListAdapter mediaListAdapter14 = this.mediaListAdapter;
                if (mediaListAdapter14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                } else {
                    mediaListAdapter = mediaListAdapter14;
                }
                mediaListAdapter.notifyDataSetChanged();
                TimelineController timelineController3 = this.timelineController;
                if (timelineController3 != null) {
                    timelineController3.B(uiStateData);
                }
                ta();
                return;
            }
            return;
        }
        this.showFooter = false;
        MediaListAdapter mediaListAdapter15 = this.mediaListAdapter;
        if (mediaListAdapter15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            mediaListAdapter15 = null;
        }
        if (mediaListAdapter15.j0().size() > 0) {
            MediaListAdapter mediaListAdapter16 = this.mediaListAdapter;
            if (mediaListAdapter16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                mediaListAdapter16 = null;
            }
            mediaListAdapter16.j0().clear();
            MediaListAdapter mediaListAdapter17 = this.mediaListAdapter;
            if (mediaListAdapter17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            } else {
                mediaListAdapter = mediaListAdapter17;
            }
            mediaListAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wa(final com.tencent.qqnt.qbasealbum.select.model.a action) {
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.j) {
            ox3.a.c("QBaseAlbum.MediaLoad", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart$updateRecyclerViewByPayload$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.qbasealbum.select.model.a.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "updateRecyclerViewByPayload start: " + ((com.tencent.qqnt.qbasealbum.select.model.j) com.tencent.qqnt.qbasealbum.select.model.a.this).b() + " end: " + ((com.tencent.qqnt.qbasealbum.select.model.j) com.tencent.qqnt.qbasealbum.select.model.a.this).a();
                }
            });
            MediaListAdapter mediaListAdapter = this.mediaListAdapter;
            if (mediaListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                mediaListAdapter = null;
            }
            com.tencent.qqnt.qbasealbum.select.model.j jVar = (com.tencent.qqnt.qbasealbum.select.model.j) action;
            mediaListAdapter.notifyItemRangeChanged(jVar.b(), jVar.a() - jVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa(final com.tencent.qqnt.qbasealbum.select.model.a action) {
        MediaRecyclerView mediaRecyclerView = this.mediaRecyclerView;
        MediaListAdapter mediaListAdapter = null;
        MediaRecyclerView mediaRecyclerView2 = null;
        if (mediaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView = null;
        }
        if (mediaRecyclerView.isComputingLayout()) {
            ox3.a.k("QBaseAlbum.MediaLoad", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart$updateRecyclerViewWhenDataChanged$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.qbasealbum.select.model.a.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "encounter isComputingLayout, post updateRecyclerViewWhenDataChanged, action=" + com.tencent.qqnt.qbasealbum.select.model.a.this;
                }
            });
            MediaRecyclerView mediaRecyclerView3 = this.mediaRecyclerView;
            if (mediaRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            } else {
                mediaRecyclerView2 = mediaRecyclerView3;
            }
            mediaRecyclerView2.post(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.album.view.n
                @Override // java.lang.Runnable
                public final void run() {
                    PickerMediaListPart.za(PickerMediaListPart.this, action);
                }
            });
            return;
        }
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.i) {
            MediaListAdapter mediaListAdapter2 = this.mediaListAdapter;
            if (mediaListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            } else {
                mediaListAdapter = mediaListAdapter2;
            }
            mediaListAdapter.notifyDataSetChanged();
            return;
        }
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.b) {
            ma(this, null, ((com.tencent.qqnt.qbasealbum.select.model.b) action).a(), null, 5, null);
            return;
        }
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.h) {
            qa((com.tencent.qqnt.qbasealbum.select.model.h) action);
            return;
        }
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.d) {
            na();
        } else if (action instanceof com.tencent.qqnt.qbasealbum.select.model.e) {
            oa((com.tencent.qqnt.qbasealbum.select.model.e) action);
        } else if (action instanceof com.tencent.qqnt.qbasealbum.select.model.g) {
            pa((com.tencent.qqnt.qbasealbum.select.model.g) action);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(PickerMediaListPart this$0, com.tencent.qqnt.qbasealbum.select.model.a action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        this$0.xa(action);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(PreviewEnterEvent.class);
        arrayList.add(PreviewExitEvent.class);
        arrayList.add(HalfModeExitEvent.class);
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
        return "QBaseAlbum.MediaLoad";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        ox3.a.a("QBaseAlbum.MediaLoad", PickerMediaListPart$onConfigurationChanged$1.INSTANCE);
        MediaListAdapter mediaListAdapter = this.mediaListAdapter;
        MediaListAdapter mediaListAdapter2 = null;
        if (mediaListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            mediaListAdapter = null;
        }
        List<LocalMediaInfo> j06 = mediaListAdapter.j0();
        SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
        Intrinsics.checkNotNull(selectedMediaViewModel);
        this.mediaListAdapter = new MediaListAdapter(this, selectedMediaViewModel);
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
        if (b16 != null) {
            com.tencent.qqnt.qbasealbum.customization.picker.b bVar = b16.pickerData;
            MediaListAdapter mediaListAdapter3 = this.mediaListAdapter;
            if (mediaListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                mediaListAdapter3 = null;
            }
            bVar.c(mediaListAdapter3.j0());
        }
        MediaListAdapter mediaListAdapter4 = this.mediaListAdapter;
        if (mediaListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            mediaListAdapter4 = null;
        }
        mediaListAdapter4.j0().addAll(j06);
        MediaRecyclerView mediaRecyclerView = this.mediaRecyclerView;
        if (mediaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView = null;
        }
        MediaListAdapter mediaListAdapter5 = this.mediaListAdapter;
        if (mediaListAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
        } else {
            mediaListAdapter2 = mediaListAdapter5;
        }
        mediaRecyclerView.setAdapter(mediaListAdapter2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        this.mediaItemSpanCount = QAlbumPickerContext.f361201a.e().g();
        this.viewHolderGap = com.tencent.qqnt.qbasealbum.ktx.d.a(2.0f);
        int g16 = com.tencent.qqnt.qbasealbum.utils.d.f361649a.g();
        int i3 = this.mediaItemSpanCount;
        this.mediaViewHolderSize = (g16 - ((i3 - 1) * this.viewHolderGap)) / i3;
        initViewModel();
        com.tencent.qqnt.qbasealbum.utils.a aVar = com.tencent.qqnt.qbasealbum.utils.a.f361642a;
        if (aVar.c() && aVar.d() && getActivity().getIntent().getBooleanExtra("show_album_mode_tips", false)) {
            ca(rootView);
            aVar.f(1);
            sa();
        }
        Y9();
        Z9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        MediaRecyclerView mediaRecyclerView = null;
        if (event instanceof PreviewEnterEvent) {
            MediaRecyclerView mediaRecyclerView2 = this.mediaRecyclerView;
            if (mediaRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            } else {
                mediaRecyclerView = mediaRecyclerView2;
            }
            ViewCompat.setImportantForAccessibility(mediaRecyclerView, 4);
            return;
        }
        if (event instanceof PreviewExitEvent) {
            MediaRecyclerView mediaRecyclerView3 = this.mediaRecyclerView;
            if (mediaRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            } else {
                mediaRecyclerView = mediaRecyclerView3;
            }
            ViewCompat.setImportantForAccessibility(mediaRecyclerView, 1);
            return;
        }
        if (event instanceof HalfModeExitEvent) {
            int intExtra = getActivity().getIntent().getIntExtra("album_open_id", 0);
            getActivity().finish();
            SimpleEventBus.getInstance().dispatchEvent(new OpenHalfAlbumEvent(intExtra));
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        TimelineController timelineController = this.timelineController;
        if (timelineController != null) {
            return timelineController.z(v3, event);
        }
        return false;
    }

    public final void refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        MediaListAdapter mediaListAdapter = this.mediaListAdapter;
        if (mediaListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            mediaListAdapter = null;
        }
        mediaListAdapter.notifyDataSetChanged();
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\r8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart$MediaListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", com.tencent.luggage.wxa.c8.c.G, "", "onBindViewHolder", "position", "", "", "payloads", "getItemViewType", "getItemCount", "", "getItemId", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "j0", "()Ljava/util/List;", QAdVrReportParams.ParamKey.MEDIA, "<init>", "(Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart;Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class MediaListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final List<LocalMediaInfo> media;
        final /* synthetic */ PickerMediaListPart D;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SelectedMediaViewModel selectedMediaViewModel;

        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart$MediaListAdapter$a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class a extends RecyclerView.ViewHolder {
            static IPatchRedirector $redirector_;

            a(View view) {
                super(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart$MediaListAdapter$b", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class b extends RecyclerView.ViewHolder {
            static IPatchRedirector $redirector_;

            b(View view) {
                super(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                }
            }
        }

        public MediaListAdapter(@NotNull PickerMediaListPart pickerMediaListPart, SelectedMediaViewModel selectedMediaViewModel) {
            Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
            this.D = pickerMediaListPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) pickerMediaListPart, (Object) selectedMediaViewModel);
            } else {
                this.selectedMediaViewModel = selectedMediaViewModel;
                this.media = new ArrayList();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            if (this.media.size() == 0) {
                return 1;
            }
            if (this.D.showFooter) {
                return 1 + this.media.size();
            }
            return this.media.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, position)).longValue();
            }
            return position;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, position)).intValue();
            }
            if (this.media.size() == 0) {
                return 3;
            }
            if (this.D.showFooter && position == getNUM_BACKGOURND_ICON() - 1) {
                return 2;
            }
            if (position >= this.D.mediaItemSpanCount) {
                return 1;
            }
            return 0;
        }

        @NotNull
        public final List<LocalMediaInfo> j0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.media;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull final RecyclerView.ViewHolder holder, int pos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) holder, pos);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof com.tencent.qqnt.qbasealbum.base.model.b) {
                LocalMediaInfo localMediaInfo = this.media.get(pos);
                final com.tencent.qqnt.qbasealbum.base.model.a a16 = QAlbumPickerContext.f361201a.g().a();
                final PickerMediaListPart pickerMediaListPart = this.D;
                Function1<View, Unit> function1 = new Function1<View, Unit>(this, holder, pickerMediaListPart) { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart$MediaListAdapter$onBindViewHolder$onItemClick$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ RecyclerView.ViewHolder $holder;
                    final /* synthetic */ PickerMediaListPart.MediaListAdapter this$0;
                    final /* synthetic */ PickerMediaListPart this$1;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                        this.$holder = holder;
                        this.this$1 = pickerMediaListPart;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, com.tencent.qqnt.qbasealbum.base.model.a.this, this, holder, pickerMediaListPart);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        com.tencent.qqnt.qbasealbum.base.model.a.this.b(it, this.this$0.j0(), ((com.tencent.qqnt.qbasealbum.base.model.b) this.$holder).getLayoutPosition());
                        QAlbumBaseMainFragment<?> a17 = com.tencent.qqnt.qbasealbum.ktx.c.a(this.this$1);
                        if (a17 != null) {
                            Rect rect = new Rect();
                            it.getGlobalVisibleRect(rect);
                            FragmentActivity requireActivity = a17.requireActivity();
                            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                            com.tencent.qqnt.qbasealbum.album.b.h(requireActivity).S1(rect);
                        }
                    }
                };
                final PickerMediaListPart pickerMediaListPart2 = this.D;
                Function1<View, Unit> function12 = new Function1<View, Unit>(this, holder, pickerMediaListPart2) { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart$MediaListAdapter$onBindViewHolder$onItemSelect$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ RecyclerView.ViewHolder $holder;
                    final /* synthetic */ PickerMediaListPart.MediaListAdapter this$0;
                    final /* synthetic */ PickerMediaListPart this$1;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                        this.$holder = holder;
                        this.this$1 = pickerMediaListPart2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, com.tencent.qqnt.qbasealbum.base.model.a.this, this, holder, pickerMediaListPart2);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        SelectedMediaViewModel selectedMediaViewModel;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        com.tencent.qqnt.qbasealbum.base.model.a aVar = com.tencent.qqnt.qbasealbum.base.model.a.this;
                        LocalMediaInfo localMediaInfo2 = this.this$0.j0().get(((com.tencent.qqnt.qbasealbum.base.model.b) this.$holder).getLayoutPosition());
                        PageType pageType = this.this$1.pageType;
                        selectedMediaViewModel = this.this$0.selectedMediaViewModel;
                        aVar.a(it, localMediaInfo2, pageType, selectedMediaViewModel);
                    }
                };
                com.tencent.qqnt.qbasealbum.base.model.b bVar = (com.tencent.qqnt.qbasealbum.base.model.b) holder;
                bVar.l(localMediaInfo, bVar.getLayoutPosition(), function1, function12);
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
                if (b16 != null) {
                    Context context = this.D.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    b16.bindPickerHolder(context, (com.tencent.qqnt.qbasealbum.base.view.e) holder, localMediaInfo);
                }
            }
            com.tencent.qqnt.qbasealbum.base.model.c cVar = this.D.performanceMonitorCallback;
            if (cVar != null) {
                cVar.b(this.D.pageType);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            com.tencent.qqnt.qbasealbum.base.view.e createPickerHolder;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent, viewType);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (viewType != 0 && viewType != 1) {
                if (viewType != 3) {
                    return new b(LayoutInflater.from(parent.getContext()).inflate(R.layout.f168437ft1, parent, false));
                }
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ftg, parent, false);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13, -1);
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.f24910_e);
                QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(parent.getContext()).setImageType(6);
                String string = parent.getContext().getString(R.string.f1771933a);
                Intrinsics.checkNotNullExpressionValue(string, "parent.context.getString\u2026ring.qalbum_picker_empty)");
                relativeLayout.addView(imageType.setDesc(string).setBackgroundColorType(1).build(), layoutParams);
                return new a(inflate);
            }
            CustomizationFacade customizationFacade = CustomizationFacade.f361084a;
            if (customizationFacade.b() == null) {
                ox3.a.f("QBaseAlbum.Customization", PickerMediaListPart$MediaListAdapter$onCreateViewHolder$holder$1.INSTANCE);
                View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168436ft0, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context).inf\u2026item_view, parent, false)");
                createPickerHolder = new com.tencent.qqnt.qbasealbum.base.view.e(inflate2);
            } else {
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = customizationFacade.b();
                Intrinsics.checkNotNull(b16);
                Context context = this.D.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                createPickerHolder = b16.createPickerHolder(context, this.D.mediaItemSpanCount, this.D.viewHolderGap, parent);
            }
            createPickerHolder.O(this.selectedMediaViewModel);
            return createPickerHolder;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position, @NotNull List<Object> payloads) {
            Object firstOrNull;
            Object firstOrNull2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, holder, Integer.valueOf(position), payloads);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            if (!payloads.isEmpty()) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) payloads);
                if ((firstOrNull instanceof com.tencent.qqnt.qbasealbum.select.model.e) && (holder instanceof com.tencent.qqnt.qbasealbum.base.model.b)) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) payloads);
                    Intrinsics.checkNotNull(firstOrNull2, "null cannot be cast to non-null type com.tencent.qqnt.qbasealbum.select.model.DataDownloadAction");
                    ((com.tencent.qqnt.qbasealbum.base.model.b) holder).H(((com.tencent.qqnt.qbasealbum.select.model.e) firstOrNull2).b());
                }
                if (payloads.contains("refreshSeq") && (holder instanceof com.tencent.qqnt.qbasealbum.base.model.b)) {
                    ((com.tencent.qqnt.qbasealbum.base.model.b) holder).I(this.media.get(position));
                }
                if (payloads.contains("refreshThumbAlpha") && (holder instanceof com.tencent.qqnt.qbasealbum.base.model.b)) {
                    ((com.tencent.qqnt.qbasealbum.base.model.b) holder).J(this.media.get(position));
                    return;
                }
                return;
            }
            onBindViewHolder(holder, position);
        }
    }
}
