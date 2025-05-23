package com.qzone.reborn.albumx.qzone.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.qzone.base.media.view.MediaRecyclerView;
import com.qzone.reborn.albumx.qzone.base.media.viewmodel.MediaSelectedViewModel;
import com.qzone.reborn.albumx.qzone.bean.init.QZoneAlbumxMediaListInitBean;
import com.qzone.reborn.albumx.qzone.event.QZoneAlbumxMediaListTitleEvent;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.qzone.util.ToastUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWClassifyInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.events.QZoneUploadPhotoPageFinishEvent;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import fa.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0003ghiB\u0007\u00a2\u0006\u0004\bd\u0010eJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0012\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00170\u0016H\u0016J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J \u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J \u0010!\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\bH\u0002J\b\u0010&\u001a\u00020\bH\u0002J\b\u0010'\u001a\u00020\bH\u0002J\u001e\u0010+\u001a\u00020\b2\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0)\u0018\u00010(H\u0002J\u0010\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0002J\u0010\u00100\u001a\u00020\b2\u0006\u0010-\u001a\u00020/H\u0002J\u0010\u00102\u001a\u00020\b2\u0006\u0010-\u001a\u000201H\u0002J\u0010\u00104\u001a\u00020\b2\u0006\u0010-\u001a\u000203H\u0002J\b\u00105\u001a\u00020\bH\u0002J\b\u00107\u001a\u000206H\u0002J\u0012\u00109\u001a\u0004\u0018\u00010\u001c2\u0006\u00108\u001a\u00020\u001aH\u0002J\u0010\u0010:\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010)H\u0002J\u0010\u0010<\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020;H\u0002J\u0010\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010)H\u0002J\b\u0010>\u001a\u00020\bH\u0002J\u0010\u0010@\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020?H\u0002J \u0010A\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010B\u001a\u00020\bH\u0002J\b\u0010C\u001a\u00020\bH\u0002R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010b\u00a8\u0006j"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxMediaListBodyPart;", "Lcom/qzone/reborn/base/k;", "Lia/c;", "Lia/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "outState", "onPartSaveInstanceState", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "view", "", "position", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "Q4", "Landroid/widget/ImageView;", "z2", "d5", "w7", "b7", "D0", "X9", "M9", "initViewModel", "Lcom/tencent/richframework/data/base/UIStateData;", "", "listUIStateData", "V9", "Lda/a;", "action", "ia", "Lda/b;", "S9", "Lda/c;", "R9", "Lda/f;", "T9", "ea", "", "ba", "globalPosition", "Q9", "P9", "Lcom/qzone/reborn/albumx/qzone/event/QZoneAlbumxMediaListTitleEvent;", "U9", "O9", "N9", "Lcom/tencent/qzonehub/api/events/QZoneUploadPhotoPageFinishEvent;", "W9", "ca", "ha", "ga", "Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView;", "d", "Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView;", "mMediaRecyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "e", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mConcatAdapter", "Lca/c;", "f", "Lca/c;", "mMediaListAdapter", "Lfa/a;", tl.h.F, "Lfa/a;", "mMediaDragSelectHelper", "Lqa/d;", "i", "Lqa/d;", "mMediaViewModel", "Lcom/qzone/reborn/albumx/qzone/base/media/viewmodel/MediaSelectedViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/albumx/qzone/base/media/viewmodel/MediaSelectedViewModel;", "mSelectViewModel", "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxMediaListInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxMediaListInitBean;", "mInitBean", "Ljava/lang/Runnable;", "D", "Ljava/lang/Runnable;", "mQueryMediaListAsyncRunnable", "<init>", "()V", "E", "a", "b", "c", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxMediaListBodyPart extends com.qzone.reborn.base.k implements ia.c, ia.b, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneAlbumxMediaListInitBean mInitBean;

    /* renamed from: D, reason: from kotlin metadata */
    private final Runnable mQueryMediaListAsyncRunnable = new Runnable() { // from class: com.qzone.reborn.albumx.qzone.part.l
        @Override // java.lang.Runnable
        public final void run() {
            QZoneAlbumxMediaListBodyPart.da(QZoneAlbumxMediaListBodyPart.this);
        }
    };

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MediaRecyclerView mMediaRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter mConcatAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ca.c mMediaListAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private fa.a mMediaDragSelectHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private qa.d mMediaViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MediaSelectedViewModel mSelectViewModel;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxMediaListBodyPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "spacing", "<init>", "(Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxMediaListBodyPart;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int spacing;

        public b(int i3) {
            this.spacing = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int i3 = this.spacing;
            outRect.top = i3;
            outRect.bottom = i3;
            outRect.left = i3;
            outRect.right = i3;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxMediaListBodyPart$c;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "unUpLoadedList", "c", "hasUploadedList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private List<? extends LocalMediaInfo> unUpLoadedList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private List<? extends LocalMediaInfo> hasUploadedList;

        public final List<LocalMediaInfo> a() {
            return this.hasUploadedList;
        }

        public final List<LocalMediaInfo> b() {
            return this.unUpLoadedList;
        }

        public final void c(List<? extends LocalMediaInfo> list) {
            this.hasUploadedList = list;
        }

        public final void d(List<? extends LocalMediaInfo> list) {
            this.unUpLoadedList = list;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/albumx/qzone/part/QZoneAlbumxMediaListBodyPart$d", "Lfa/a$b;", "", "globalPosition", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements a.b {
        d() {
        }

        @Override // fa.a.b
        public LocalMediaInfo a(int globalPosition) {
            return QZoneAlbumxMediaListBodyPart.this.Q9(globalPosition);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/albumx/qzone/part/QZoneAlbumxMediaListBodyPart$e", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e extends GridLayoutManager.SpanSizeLookup {
        e() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            int g16;
            LocalMediaInfo Q9 = QZoneAlbumxMediaListBodyPart.this.Q9(position);
            int i3 = 1;
            if (Q9 != null && ((g16 = ea.a.g(Q9)) == 1 || g16 == 3)) {
                i3 = 3;
            }
            if (Q9 == null) {
                return 3;
            }
            return i3;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/albumx/qzone/part/QZoneAlbumxMediaListBodyPart$f", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDirectorV2$QueryCallBack;", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "queryResult", "", "queryFinish", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class f implements RFWUploadRecommendDirectorV2.QueryCallBack {
        f() {
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2.QueryCallBack
        public void queryFinish(List<RFWMediaInfo> queryResult) {
            List<LocalMediaInfo> data;
            Intrinsics.checkNotNullParameter(queryResult, "queryResult");
            qa.d dVar = QZoneAlbumxMediaListBodyPart.this.mMediaViewModel;
            Integer num = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaViewModel");
                dVar = null;
            }
            dVar.l2(queryResult);
            String tag = QZoneAlbumxMediaListBodyPart.this.getTAG();
            qa.d dVar2 = QZoneAlbumxMediaListBodyPart.this.mMediaViewModel;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaViewModel");
                dVar2 = null;
            }
            UIStateData<List<LocalMediaInfo>> value = dVar2.f2().getValue();
            if (value != null && (data = value.getData()) != null) {
                num = Integer.valueOf(data.size());
            }
            QLog.d(tag, 1, "[queryMediaListAsync] debug --> queryFinish, mediaInfos.size=" + num);
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/albumx/qzone/part/QZoneAlbumxMediaListBodyPart$g", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDirectorV2$QueryCallBack;", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "queryResult", "", "queryFinish", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class g implements RFWUploadRecommendDirectorV2.QueryCallBack {
        g() {
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2.QueryCallBack
        public void queryFinish(List<RFWMediaInfo> queryResult) {
            List<LocalMediaInfo> data;
            Intrinsics.checkNotNullParameter(queryResult, "queryResult");
            qa.d dVar = QZoneAlbumxMediaListBodyPart.this.mMediaViewModel;
            Integer num = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaViewModel");
                dVar = null;
            }
            dVar.l2(queryResult);
            String tag = QZoneAlbumxMediaListBodyPart.this.getTAG();
            qa.d dVar2 = QZoneAlbumxMediaListBodyPart.this.mMediaViewModel;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaViewModel");
                dVar2 = null;
            }
            UIStateData<List<LocalMediaInfo>> value = dVar2.f2().getValue();
            if (value != null && (data = value.getData()) != null) {
                num = Integer.valueOf(data.size());
            }
            QLog.d(tag, 1, "[queryMediaListAsync] --> queryFinish, mediaInfos.size=" + num);
        }
    }

    private final void M9() {
        ca.c cVar = new ca.c();
        this.mMediaListAdapter = cVar;
        cVar.setHasStableIds(true);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[1];
        ca.c cVar2 = this.mMediaListAdapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaListAdapter");
            cVar2 = null;
        }
        adapterArr[0] = cVar2;
        this.mConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
    }

    private final void N9() {
        MediaSelectedViewModel mediaSelectedViewModel = this.mSelectViewModel;
        MediaSelectedViewModel mediaSelectedViewModel2 = null;
        if (mediaSelectedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel = null;
        }
        mediaSelectedViewModel.Z1(true);
        MediaSelectedViewModel mediaSelectedViewModel3 = this.mSelectViewModel;
        if (mediaSelectedViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
        } else {
            mediaSelectedViewModel2 = mediaSelectedViewModel3;
        }
        mediaSelectedViewModel2.P1(P9());
    }

    private final List<LocalMediaInfo> O9() {
        List<LocalMediaInfo> P9 = P9();
        List<LocalMediaInfo> mutableList = P9 != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) P9) : null;
        if (mutableList != null) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) mutableList, (Function1) new Function1<LocalMediaInfo, Boolean>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListBodyPart$filterDescData$1$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LocalMediaInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    boolean z16 = true;
                    if (ea.a.g(it) != 1 && ea.a.g(it) != 3) {
                        z16 = false;
                    }
                    return Boolean.valueOf(z16);
                }
            });
        }
        return mutableList;
    }

    private final List<LocalMediaInfo> P9() {
        qa.d dVar = this.mMediaViewModel;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaViewModel");
            dVar = null;
        }
        UIStateData<List<LocalMediaInfo>> value = dVar.f2().getValue();
        if (value != null) {
            return value.getData();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalMediaInfo Q9(int globalPosition) {
        Object orNull;
        List<LocalMediaInfo> P9 = P9();
        if (P9 == null) {
            return null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(P9, globalPosition);
        return (LocalMediaInfo) orNull;
    }

    private final void R9(da.c action) {
        ca.c cVar = this.mMediaListAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaListAdapter");
            cVar = null;
        }
        cVar.notifyDataSetChanged();
        if (action.getValidStatus() == -5) {
            ha();
        }
    }

    private final void S9(da.b action) {
        ca.c cVar = null;
        if (action.getValidStatus() == -10000) {
            ca.c cVar2 = this.mMediaListAdapter;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaListAdapter");
            } else {
                cVar = cVar2;
            }
            cVar.notifyItemChanged(ea.a.b(action.getAddedMedia()));
            return;
        }
        if (action.getValidStatus() == -5) {
            ha();
        }
        ca.c cVar3 = this.mMediaListAdapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaListAdapter");
        } else {
            cVar = cVar3;
        }
        cVar.notifyDataSetChanged();
    }

    private final void T9(da.f action) {
        ca.c cVar = null;
        if (action.getValidStatus() == -10000) {
            ca.c cVar2 = this.mMediaListAdapter;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaListAdapter");
            } else {
                cVar = cVar2;
            }
            cVar.notifyItemChanged(ea.a.b(action.getRemovedMedia()));
            return;
        }
        ca.c cVar3 = this.mMediaListAdapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaListAdapter");
        } else {
            cVar = cVar3;
        }
        cVar.notifyDataSetChanged();
    }

    private final void U9(QZoneAlbumxMediaListTitleEvent event) {
        QLog.d(getTAG(), 1, "[handleMediaListTitleClickEvent] clickType=" + event.getClickType());
        int clickType = event.getClickType();
        if (clickType == 1) {
            N9();
            return;
        }
        MediaSelectedViewModel mediaSelectedViewModel = null;
        if (clickType == 3) {
            MediaSelectedViewModel mediaSelectedViewModel2 = this.mSelectViewModel;
            if (mediaSelectedViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
                mediaSelectedViewModel2 = null;
            }
            MediaSelectedViewModel.O1(mediaSelectedViewModel2, O9(), false, 2, null);
            return;
        }
        if (clickType != 4) {
            return;
        }
        MediaSelectedViewModel mediaSelectedViewModel3 = this.mSelectViewModel;
        if (mediaSelectedViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
        } else {
            mediaSelectedViewModel = mediaSelectedViewModel3;
        }
        mediaSelectedViewModel.P1(P9());
    }

    private final void W9(QZoneUploadPhotoPageFinishEvent event) {
        QLog.d(getTAG(), 1, "[handleUploadPhotoPageFinishEvent] clickUpload=" + event.isClickUpload() + ", comeFrom=" + event.getComeFrom());
        if (event.getComeFrom() == 1 && event.isClickUpload()) {
            RFWThreadManager.getInstance().remove(this.mQueryMediaListAsyncRunnable);
            RFWThreadManager.getInstance().execOnSubThread(this.mQueryMediaListAsyncRunnable, 1000L);
        }
    }

    private final void X9() {
        d dVar = new d();
        MediaSelectedViewModel mediaSelectedViewModel = this.mSelectViewModel;
        fa.a aVar = null;
        if (mediaSelectedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel = null;
        }
        this.mMediaDragSelectHelper = new fa.a(dVar, mediaSelectedViewModel);
        MediaRecyclerView mediaRecyclerView = this.mMediaRecyclerView;
        if (mediaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaRecyclerView");
            mediaRecyclerView = null;
        }
        fa.a aVar2 = this.mMediaDragSelectHelper;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaDragSelectHelper");
        } else {
            aVar = aVar2;
        }
        mediaRecyclerView.setOnIndexChangedListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean ba() {
        QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean = this.mInitBean;
        if (qZoneAlbumxMediaListInitBean != null) {
            Intrinsics.checkNotNull(qZoneAlbumxMediaListInitBean);
            if (Intrinsics.areEqual(qZoneAlbumxMediaListInitBean.getMediaDisplayName(), com.qzone.util.l.a(R.string.jfo))) {
                return gd.a.f401926a.c("KEY_SHOW_RECOMMEND_PHOTO_DEBUG_INFO", false);
            }
        }
        QLog.d(getTAG(), 1, "[isQueryDebugMediaList] is debug " + this.mInitBean);
        return false;
    }

    private final void ca(ImageView view, int position, LocalMediaInfo mediaInfo) {
        List<LocalMediaInfo> P9 = P9();
        if (P9 == null) {
            QLog.e(getTAG(), 1, "[launchMediaLayerPage] allData is null");
        }
        if (P9 != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : P9) {
                if (!TextUtils.isEmpty(((LocalMediaInfo) obj).path)) {
                    arrayList.add(obj);
                }
            }
            int i3 = position - 1;
            qa.d dVar = this.mMediaViewModel;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaViewModel");
                dVar = null;
            }
            List<LocalMediaInfo> value = dVar.g2().getValue();
            int size = value != null ? value.size() : 0;
            if (ea.a.g(mediaInfo) == 4 && size > 0) {
                i3--;
            }
            int i16 = (i3 < 0 || i3 >= arrayList.size()) ? 0 : i3;
            ka.a y16 = ho.i.y();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean = this.mInitBean;
            y16.f(context, view, i16, qZoneAlbumxMediaListInitBean != null ? qZoneAlbumxMediaListInitBean.getMediaDisplayName() : null, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(QZoneAlbumxMediaListBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ea();
    }

    private final void ea() {
        QLog.d(getTAG(), 1, "[queryMediaListAsync] " + this.mInitBean);
        if (ba()) {
            QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean = this.mInitBean;
            if (qZoneAlbumxMediaListInitBean != null) {
                QZoneUploadRecommendDirector.INSTANCE.a().queryMediaListByTime(qZoneAlbumxMediaListInitBean.getSubClassifyId(), qZoneAlbumxMediaListInitBean.getSelectArg(), qZoneAlbumxMediaListInitBean.getMediaCount(), new f());
                return;
            }
            return;
        }
        QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean2 = this.mInitBean;
        if (qZoneAlbumxMediaListInitBean2 != null) {
            QZoneUploadRecommendDirector.INSTANCE.a().queryMediaListByClassifyInfo(new RFWClassifyInfo(qZoneAlbumxMediaListInitBean2.getClassifyId(), qZoneAlbumxMediaListInitBean2.getSubClassifyId(), qZoneAlbumxMediaListInitBean2.getSelectArg()), new g());
        }
    }

    private final void ga() {
        ToastUtil.s(BaseApplication.getContext().getString(R.string.jfv), 0);
    }

    private final void ha() {
        BaseApplication context = BaseApplication.getContext();
        Object[] objArr = new Object[1];
        MediaSelectedViewModel mediaSelectedViewModel = this.mSelectViewModel;
        if (mediaSelectedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel = null;
        }
        objArr[0] = Integer.valueOf(mediaSelectedViewModel.getMaxSelectMediaSize());
        ToastUtil.s(context.getString(R.string.jfr, objArr), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ia(final da.a action) {
        MediaRecyclerView mediaRecyclerView = this.mMediaRecyclerView;
        ca.c cVar = null;
        if (mediaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaRecyclerView");
            mediaRecyclerView = null;
        }
        if (mediaRecyclerView.isComputingLayout()) {
            QLog.d(getTAG(), 1, "[updateRecyclerViewWhenDataChanged] recyclerView isComputingLayout, post, action=" + action);
            MediaRecyclerView mediaRecyclerView2 = this.mMediaRecyclerView;
            if (mediaRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaRecyclerView");
                mediaRecyclerView2 = null;
            }
            mediaRecyclerView2.post(new Runnable() { // from class: com.qzone.reborn.albumx.qzone.part.p
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneAlbumxMediaListBodyPart.ja(QZoneAlbumxMediaListBodyPart.this, action);
                }
            });
        }
        if (action instanceof da.b) {
            S9((da.b) action);
            return;
        }
        if (action instanceof da.c) {
            R9((da.c) action);
            return;
        }
        if (action instanceof da.f) {
            T9((da.f) action);
            return;
        }
        if (action instanceof da.d) {
            ca.c cVar2 = this.mMediaListAdapter;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaListAdapter");
            } else {
                cVar = cVar2;
            }
            cVar.notifyDataSetChanged();
            return;
        }
        if (action instanceof da.e) {
            ca.c cVar3 = this.mMediaListAdapter;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaListAdapter");
            } else {
                cVar = cVar3;
            }
            cVar.notifyDataSetChanged();
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(qa.d.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneAlbumx\u2026istViewModel::class.java)");
        qa.d dVar = (qa.d) viewModel;
        this.mMediaViewModel = dVar;
        qa.d dVar2 = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaViewModel");
            dVar = null;
        }
        LiveData<UIStateData<List<LocalMediaInfo>>> f26 = dVar.f2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends LocalMediaInfo>>, Unit> function1 = new Function1<UIStateData<List<? extends LocalMediaInfo>>, Unit>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListBodyPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends LocalMediaInfo>> uIStateData) {
                invoke2((UIStateData<List<LocalMediaInfo>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<LocalMediaInfo>> uIStateData) {
                QZoneAlbumxMediaListBodyPart.this.V9(uIStateData);
            }
        };
        f26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzone.part.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumxMediaListBodyPart.Y9(Function1.this, obj);
            }
        });
        ViewModel viewModel2 = getViewModel(MediaSelectedViewModel.class);
        MediaSelectedViewModel mediaSelectedViewModel = (MediaSelectedViewModel) viewModel2;
        qa.d dVar3 = this.mMediaViewModel;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaViewModel");
            dVar3 = null;
        }
        dVar3.T1(getPartHost().getLifecycleOwner(), mediaSelectedViewModel.T1());
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(MediaSelect\u2026a\n            )\n        }");
        this.mSelectViewModel = mediaSelectedViewModel;
        if (mediaSelectedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel = null;
        }
        LiveData<Boolean> W1 = mediaSelectedViewModel.W1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListBodyPart$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                MediaRecyclerView mediaRecyclerView;
                mediaRecyclerView = QZoneAlbumxMediaListBodyPart.this.mMediaRecyclerView;
                if (mediaRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaRecyclerView");
                    mediaRecyclerView = null;
                }
                AtomicBoolean D = mediaRecyclerView.D();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                D.set(it.booleanValue());
            }
        };
        W1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzone.part.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumxMediaListBodyPart.Z9(Function1.this, obj);
            }
        });
        qa.d dVar4 = this.mMediaViewModel;
        if (dVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaViewModel");
        } else {
            dVar2 = dVar4;
        }
        LiveData<da.a> mediaChangedActionLiveData = dVar2.getMediaChangedActionLiveData();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<da.a, Unit> function13 = new Function1<da.a, Unit>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListBodyPart$initViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(da.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(da.a it) {
                QZoneAlbumxMediaListBodyPart qZoneAlbumxMediaListBodyPart = QZoneAlbumxMediaListBodyPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZoneAlbumxMediaListBodyPart.ia(it);
            }
        };
        mediaChangedActionLiveData.observe(lifecycleOwner3, new Observer() { // from class: com.qzone.reborn.albumx.qzone.part.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumxMediaListBodyPart.aa(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(QZoneAlbumxMediaListBodyPart this$0, da.a action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        this$0.ia(action);
    }

    @Override // ia.b
    public void D0(View view) {
        Object orNull;
        Intrinsics.checkNotNullParameter(view, "view");
        MediaSelectedViewModel mediaSelectedViewModel = this.mSelectViewModel;
        if (mediaSelectedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel = null;
        }
        List<LocalMediaInfo> selectedMedia = mediaSelectedViewModel.getSelectedMedia();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = selectedMedia.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = ((LocalMediaInfo) next).path;
            if (!(str == null || str.length() == 0)) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull;
            String str2 = localMediaInfo != null ? localMediaInfo.path : null;
            String tag = getTAG();
            int size = arrayList.size();
            QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean = this.mInitBean;
            String templateId = qZoneAlbumxMediaListInitBean != null ? qZoneAlbumxMediaListInitBean.getTemplateId() : null;
            QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean2 = this.mInitBean;
            QLog.d(tag, 1, "[launchWinkTemplatePreviewPage] select media size=" + size + ", firstMediaPath=" + str2 + ", templateId=" + templateId + ", classifyId=" + (qZoneAlbumxMediaListInitBean2 != null ? qZoneAlbumxMediaListInitBean2.getClassifyId() : null));
            ka.a y16 = ho.i.y();
            Intrinsics.checkNotNullExpressionValue(y16, "qzoneAlbumx()");
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean3 = this.mInitBean;
            String templateId2 = qZoneAlbumxMediaListInitBean3 != null ? qZoneAlbumxMediaListInitBean3.getTemplateId() : null;
            ArrayList arrayList2 = new ArrayList(arrayList);
            QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean4 = this.mInitBean;
            ka.a.l(y16, context, templateId2, str2, arrayList2, qZoneAlbumxMediaListInitBean4 != null ? qZoneAlbumxMediaListInitBean4.getClassifyId() : null, 0, 32, null);
            return;
        }
        ga();
        QLog.d(getTAG(), 1, "[onMakeVideoClick] select media is empty");
    }

    @Override // ia.c
    public void Q4(View view, int position, LocalMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        QLog.d(getTAG(), 1, "[onMediaListCheckBoxClick] addSelectedMedia, pos=" + position + ", selectStatus=" + mediaInfo.selectStatus);
        int i3 = mediaInfo.selectStatus;
        MediaSelectedViewModel mediaSelectedViewModel = null;
        if (i3 == 1) {
            MediaSelectedViewModel mediaSelectedViewModel2 = this.mSelectViewModel;
            if (mediaSelectedViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            } else {
                mediaSelectedViewModel = mediaSelectedViewModel2;
            }
            mediaSelectedViewModel.X1(ea.a.c(mediaInfo), mediaInfo);
            return;
        }
        if (i3 != 2) {
            return;
        }
        MediaSelectedViewModel mediaSelectedViewModel3 = this.mSelectViewModel;
        if (mediaSelectedViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel3 = null;
        }
        if (mediaSelectedViewModel3.U1()) {
            MediaSelectedViewModel mediaSelectedViewModel4 = this.mSelectViewModel;
            if (mediaSelectedViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
                mediaSelectedViewModel4 = null;
            }
            MediaSelectedViewModel.M1(mediaSelectedViewModel4, mediaInfo, 0, 2, null);
            return;
        }
        ha();
    }

    @Override // ia.b
    public void b7(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        String tag = getTAG();
        ca.c cVar = this.mMediaListAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaListAdapter");
            cVar = null;
        }
        QLog.d(tag, 1, "[onUpdateAllPhotoClick] all photo size=" + cVar.getNUM_BACKGOURND_ICON());
        qa.d dVar = this.mMediaViewModel;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaViewModel");
            dVar = null;
        }
        List<LocalMediaInfo> value = dVar.g2().getValue();
        if (value == null) {
            QLog.e(getTAG(), 1, "[onUpdateAllPhotoClick] allNotUploadedData is null");
        }
        if (value != null) {
            List arrayList = new ArrayList();
            for (Object obj : value) {
                if (!TextUtils.isEmpty(((LocalMediaInfo) obj).path)) {
                    arrayList.add(obj);
                }
            }
            Context context = getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                ka.a y16 = ho.i.y();
                Intrinsics.checkNotNullExpressionValue(y16, "qzoneAlbumx()");
                int size = arrayList.size();
                MediaSelectedViewModel mediaSelectedViewModel = this.mSelectViewModel;
                if (mediaSelectedViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
                    mediaSelectedViewModel = null;
                }
                if (size >= mediaSelectedViewModel.getMaxSelectMediaSize()) {
                    MediaSelectedViewModel mediaSelectedViewModel2 = this.mSelectViewModel;
                    if (mediaSelectedViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
                        mediaSelectedViewModel2 = null;
                    }
                    arrayList = arrayList.subList(0, mediaSelectedViewModel2.getMaxSelectMediaSize());
                }
                ArrayList arrayList2 = new ArrayList(arrayList);
                QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean = this.mInitBean;
                ka.a.i(y16, activity, arrayList2, qZoneAlbumxMediaListInitBean != null ? qZoneAlbumxMediaListInitBean.getClassifyId() : null, 1, null, 0, 48, null);
            }
        }
    }

    @Override // ia.c
    public void d5(ImageView view, int position, LocalMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        MediaSelectedViewModel mediaSelectedViewModel = this.mSelectViewModel;
        if (mediaSelectedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel = null;
        }
        Boolean value = mediaSelectedViewModel.W1().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        QLog.d(getTAG(), 1, "[onPicImageOnLongClick] pos=" + position + ", isSelectMode=" + booleanValue);
        if (booleanValue) {
            ca(view, position, mediaInfo);
            return;
        }
        N9();
        MediaSelectedViewModel mediaSelectedViewModel2 = this.mSelectViewModel;
        if (mediaSelectedViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel2 = null;
        }
        MediaSelectedViewModel.M1(mediaSelectedViewModel2, mediaInfo, 0, 2, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumxLocalPhotoRecommendMediaListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, ia.b.class);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, ia.c.class);
        View findViewById = rootView.findViewById(R.id.nf_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rv_media_list)");
        this.mMediaRecyclerView = (MediaRecyclerView) findViewById;
        M9();
        MediaRecyclerView mediaRecyclerView = this.mMediaRecyclerView;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (mediaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaRecyclerView");
            mediaRecyclerView = null;
        }
        mediaRecyclerView.setDisallowParentIntercept(true);
        MediaRecyclerView mediaRecyclerView2 = this.mMediaRecyclerView;
        if (mediaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaRecyclerView");
            mediaRecyclerView2 = null;
        }
        mediaRecyclerView2.setNestedScrollingEnabled(true);
        SafeGridLayoutManager safeGridLayoutManager = new SafeGridLayoutManager(getContext(), 3);
        safeGridLayoutManager.setSpanSizeLookup(new e());
        MediaRecyclerView mediaRecyclerView3 = this.mMediaRecyclerView;
        if (mediaRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaRecyclerView");
            mediaRecyclerView3 = null;
        }
        mediaRecyclerView3.setLayoutManager(safeGridLayoutManager);
        MediaRecyclerView mediaRecyclerView4 = this.mMediaRecyclerView;
        if (mediaRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaRecyclerView");
            mediaRecyclerView4 = null;
        }
        mediaRecyclerView4.addItemDecoration(new b(DisplayUtil.dip2px(getContext(), 1.0f)));
        MediaRecyclerView mediaRecyclerView5 = this.mMediaRecyclerView;
        if (mediaRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaRecyclerView");
            mediaRecyclerView5 = null;
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        mediaRecyclerView5.setItemAnimator(defaultItemAnimator);
        MediaRecyclerView mediaRecyclerView6 = this.mMediaRecyclerView;
        if (mediaRecyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaRecyclerView");
            mediaRecyclerView6 = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.mConcatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        mediaRecyclerView6.setAdapter(rFWConcatAdapter);
        initViewModel();
        X9();
        ea();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean;
        Intent intent;
        super.onPartCreate(activity, savedInstanceState);
        if (savedInstanceState == null) {
            Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
            qZoneAlbumxMediaListInitBean = serializableExtra instanceof QZoneAlbumxMediaListInitBean ? (QZoneAlbumxMediaListInitBean) serializableExtra : null;
            this.mInitBean = qZoneAlbumxMediaListInitBean;
            QLog.d("QZoneAlbumxLocalPhotoRecommendMediaListPart", 1, "onPartCreate: " + qZoneAlbumxMediaListInitBean);
        } else {
            Serializable serializable = savedInstanceState.getSerializable("key_bundle_common_init_bean");
            qZoneAlbumxMediaListInitBean = serializable instanceof QZoneAlbumxMediaListInitBean ? (QZoneAlbumxMediaListInitBean) serializable : null;
            this.mInitBean = qZoneAlbumxMediaListInitBean;
            QLog.d("QZoneAlbumxLocalPhotoRecommendMediaListPart", 1, "onPartCreate, savedInstanceState: " + qZoneAlbumxMediaListInitBean);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        RFWThreadManager.getInstance().remove(this.mQueryMediaListAsyncRunnable);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartSaveInstanceState(Activity activity, Bundle outState) {
        super.onPartSaveInstanceState(activity, outState);
        if (outState != null) {
            outState.putSerializable("key_bundle_common_init_bean", this.mInitBean);
        }
        QLog.d("QZoneAlbumxLocalPhotoRecommendMediaListPart", 1, "onPartSaveInstanceState: " + this.mInitBean);
    }

    @Override // ia.b
    public void w7(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        String tag = getTAG();
        MediaSelectedViewModel mediaSelectedViewModel = this.mSelectViewModel;
        if (mediaSelectedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel = null;
        }
        QLog.d(tag, 1, "[onUploadSelectedPhotoClick] select photo size=" + mediaSelectedViewModel.getSelectedMedia().size());
        MediaSelectedViewModel mediaSelectedViewModel2 = this.mSelectViewModel;
        if (mediaSelectedViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel2 = null;
        }
        if (mediaSelectedViewModel2.getSelectedMedia().isEmpty()) {
            ga();
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            ka.a y16 = ho.i.y();
            Intrinsics.checkNotNullExpressionValue(y16, "qzoneAlbumx()");
            MediaSelectedViewModel mediaSelectedViewModel3 = this.mSelectViewModel;
            if (mediaSelectedViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
                mediaSelectedViewModel3 = null;
            }
            ArrayList arrayList = new ArrayList(mediaSelectedViewModel3.getSelectedMedia());
            QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean = this.mInitBean;
            ka.a.i(y16, activity, arrayList, qZoneAlbumxMediaListInitBean != null ? qZoneAlbumxMediaListInitBean.getClassifyId() : null, 1, null, 0, 48, null);
        }
    }

    @Override // ia.c
    public void z2(ImageView view, int position, LocalMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        QLog.d(getTAG(), 1, "[onPicImageOnClick] pos = " + position);
        ca(view, position, mediaInfo);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneAlbumxMediaListTitleEvent.class, QZoneUploadPhotoPageFinishEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(UIStateData<List<LocalMediaInfo>> listUIStateData) {
        if (listUIStateData != null) {
            ca.c cVar = this.mMediaListAdapter;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaListAdapter");
                cVar = null;
            }
            cVar.setItems(listUIStateData.getData());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event != null) {
            if (event instanceof QZoneAlbumxMediaListTitleEvent) {
                U9((QZoneAlbumxMediaListTitleEvent) event);
            } else if (event instanceof QZoneUploadPhotoPageFinishEvent) {
                W9((QZoneUploadPhotoPageFinishEvent) event);
            }
        }
    }
}
