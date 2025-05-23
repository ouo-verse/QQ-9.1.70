package com.tencent.qqnt.aio.gallery.part;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerMorePart;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.aio.gallery.share.NTShareContext;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoLoadState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.delegate.INTLayerOperationListener;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u0089\u0001B\u001b\u0012\u0006\u0010X\u001a\u00020S\u0012\b\b\u0002\u0010[\u001a\u00020<\u00a2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\b\u0010\b\u001a\u00020\u0007H\u0002J0\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\f\u0010\u001b\u001a\u00020\u001a*\u00020\u001aH\u0002J\f\u0010\u001c\u001a\u00020\u001a*\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\tH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J*\u0010%\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\u001aH\u0002J0\u0010+\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010!\u001a\u00020&2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)H\u0002J\b\u0010,\u001a\u00020\u0007H\u0002J$\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0-j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r`.H\u0002J\u001a\u00104\u001a\u00020\u00072\u0006\u00101\u001a\u0002002\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u0010\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u000205H\u0016J\u0010\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u000205H\u0016J\u0006\u0010:\u001a\u00020\u0007J\u0018\u0010>\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\t2\u0006\u0010=\u001a\u00020<H\u0016J\u0010\u0010A\u001a\u00020\u00072\u0006\u0010@\u001a\u00020?H\u0016J\u0018\u0010E\u001a\u00020\u00072\u0006\u0010B\u001a\u00020(2\u0006\u0010D\u001a\u00020CH\u0016J\u0010\u0010G\u001a\u00020\u00072\u0006\u0010F\u001a\u00020&H\u0016J\u0010\u0010H\u001a\u00020\u00072\u0006\u0010F\u001a\u00020&H\u0016J\u0010\u0010I\u001a\u00020\u00072\u0006\u0010F\u001a\u00020&H\u0016J\"\u0010M\u001a\u00020\u00072\u0006\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020&2\b\u0010L\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010N\u001a\u00020\u0007J\u0010\u0010O\u001a\u00020\u00072\u0006\u0010@\u001a\u00020?H\u0014J\u0012\u0010R\u001a\u00020\u00072\b\u0010Q\u001a\u0004\u0018\u00010PH\u0016R\u0017\u0010X\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010f\u001a\u00020&8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010i\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010o\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010lR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010$\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010|\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u001c\u0010\u0080\u0001\u001a\u00020C8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\be\u0010}\u001a\u0004\b~\u0010\u007fR'\u0010\u0086\u0001\u001a\n\u0012\u0005\u0012\u00030\u0082\u00010\u0081\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0083\u0001\u0010}\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerMorePart;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "Landroid/content/DialogInterface$OnDismissListener;", "Lev3/b;", "", "W9", "", "pgId", "elementId", "", "", "params", "R9", "S9", "U9", "P9", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "Y9", "L9", "Z9", "Landroid/content/Intent;", "M9", "Lcom/tencent/mobileqq/sharepanel/f;", "N9", "O9", "dealId", "G9", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "H9", "action", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "shareLine", "sharePanel", "E9", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "Lkotlin/collections/ArrayList;", "list", "D9", "F9", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "K9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "X9", "actionId", "", NodeProps.VISIBLE, "c0", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "onItemClick", "position", "onItemLongClick", "onItemLongClickUp", "onItemLongClickCancel", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "aa", "updateLayerState", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager;", "d", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager;", "getMShareManager", "()Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager;", "mShareManager", "e", "Z", "isUseNewShare", "Landroid/widget/ImageButton;", "f", "Landroid/widget/ImageButton;", "mMoreBtn", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", tl.h.F, "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "mViewPagerRoot", "i", "I", "VIDEO_DURATION_TIME", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "mRatePlayTipsView", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mFirstImg", "D", "mSecondImg", "Landroid/animation/ValueAnimator;", "E", "Landroid/animation/ValueAnimator;", "mVideoIconAnimator", "Lev3/a;", UserInfo.SEX_FEMALE, "Lev3/a;", "mBottomControlLayout", "G", "Lcom/tencent/mobileqq/sharepanel/f;", "H", "Ljava/lang/String;", "EXP_QQ_VIDEO_VIEWING_TAPPING_HOLD", "Lkotlin/Lazy;", "I9", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "mSASBuilder", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState;", "J", "J9", "()Landroidx/lifecycle/Observer;", "mVideoLoadStateObserver", "<init>", "(Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager;Z)V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class NTAIOLayerMorePart extends NTAIOLayerBasePart implements View.OnClickListener, ShareActionSheet.OnItemClickListener, RFWGalleryViewPager.OnItemLongClickListener, DialogInterface.OnDismissListener, ev3.b {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mFirstImg;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mSecondImg;

    /* renamed from: E, reason: from kotlin metadata */
    private ValueAnimator mVideoIconAnimator;

    /* renamed from: F, reason: from kotlin metadata */
    private ev3.a mBottomControlLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.mobileqq.sharepanel.f sharePanel;

    /* renamed from: H, reason: from kotlin metadata */
    private final String EXP_QQ_VIDEO_VIEWING_TAPPING_HOLD;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy mSASBuilder;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy mVideoLoadStateObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final NTShareActionManager mShareManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isUseNewShare;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageButton mMoreBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWGalleryViewPager mViewPagerRoot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int VIDEO_DURATION_TIME;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mRatePlayTipsView;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerMorePart$a;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState;", "videoLoadState", "", "a", "<init>", "(Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerMorePart;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class a implements Observer<RFWLayerVideoLoadState> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(RFWLayerVideoLoadState videoLoadState) {
            Intrinsics.checkNotNullParameter(videoLoadState, "videoLoadState");
            if (videoLoadState.getCurrentPlayState() != RFWLayerVideoLoadState.PlayState.PLAYING) {
                NTAIOLayerMorePart.this.F9();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/gallery/part/NTAIOLayerMorePart$b", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.sharepanel.j {
        b() {
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            NTAIOLayerMorePart.this.G9(channelId);
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(String actionId) {
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            NTAIOLayerMorePart.this.G9(actionId);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/gallery/part/NTAIOLayerMorePart$c", "Lcom/tencent/mobileqq/sharepanel/k;", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.sharepanel.k {
        c() {
        }

        @Override // com.tencent.mobileqq.sharepanel.k
        public void a() {
            NTAIOLayerMorePart.this.broadcastMessage("LOCK_AUTO_PLAY", Boolean.FALSE);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/gallery/part/NTAIOLayerMorePart$d", "Lcom/tencent/mobileqq/sharepanel/n;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.sharepanel.n {
        d() {
        }

        @Override // com.tencent.mobileqq.sharepanel.n
        public void a(ArrayList<ResultRecord> targetList, com.tencent.mobileqq.sharepanel.m callback) {
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = NTAIOLayerMorePart.this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            if (rFWLayerItemMediaInfo.getInvalid()) {
                callback.onFail();
            } else {
                NTAIOLayerMorePart nTAIOLayerMorePart = NTAIOLayerMorePart.this;
                callback.a(nTAIOLayerMorePart.M9(nTAIOLayerMorePart.L9()));
            }
        }
    }

    public NTAIOLayerMorePart(NTShareActionManager mShareManager, boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mShareManager, "mShareManager");
        this.mShareManager = mShareManager;
        this.isUseNewShare = z16;
        this.VIDEO_DURATION_TIME = 3000;
        this.EXP_QQ_VIDEO_VIEWING_TAPPING_HOLD = "exp_QQ_video_viewing_tapping_hold";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ShareActionSheet>() { // from class: com.tencent.qqnt.aio.gallery.part.NTAIOLayerMorePart$mSASBuilder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShareActionSheet invoke() {
                ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                param.context = NTAIOLayerMorePart.this.getActivity();
                param.deReportParams = new HashMap();
                return ShareActionSheetFactory.create(param);
            }
        });
        this.mSASBuilder = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.qqnt.aio.gallery.part.NTAIOLayerMorePart$mVideoLoadStateObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NTAIOLayerMorePart.a invoke() {
                return new NTAIOLayerMorePart.a();
            }
        });
        this.mVideoLoadStateObserver = lazy2;
    }

    private final void D9(NTShareContext shareContext, int action, ArrayList<ShareActionSheetBuilder.ActionSheetItem> list) {
        com.tencent.qqnt.aio.gallery.share.a e16 = this.mShareManager.e(action);
        if (e16 != null && e16.g(shareContext)) {
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(action);
            build.visibility = e16.f() ? 0 : 8;
            list.add(build);
        }
    }

    private final void E9(NTShareContext shareContext, String action, NTShareActionManager.ShareLine shareLine, com.tencent.mobileqq.sharepanel.f sharePanel) {
        com.tencent.qqnt.aio.gallery.share.a c16 = this.mShareManager.c(action);
        if (c16 == null) {
            return;
        }
        boolean g16 = c16.g(shareContext);
        if (shareLine == NTShareActionManager.ShareLine.FIRST) {
            if (sharePanel != null) {
                sharePanel.l0(action, g16 && c16.f());
            }
        } else {
            if (shareLine != NTShareActionManager.ShareLine.SECOND || sharePanel == null) {
                return;
            }
            sharePanel.c0(action, g16 && c16.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        ValueAnimator valueAnimator = this.mVideoIconAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            IVideoPlayerProvider mLayerVideoControlProvider = getMLayerVideoControlProvider();
            if (mLayerVideoControlProvider != null) {
                mLayerVideoControlProvider.setPlayRate(1.0f);
            }
            IVideoPlayerProvider mLayerVideoControlProvider2 = getMLayerVideoControlProvider();
            if (mLayerVideoControlProvider2 != null) {
                mLayerVideoControlProvider2.changeOperationLayoutVisible(IVideoPlayerProvider.ControlLayoutVisibleState.VISIBLE_THEN_HIDE);
            }
            ValueAnimator valueAnimator2 = this.mVideoIconAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            View view = this.mRatePlayTipsView;
            if (view != null) {
                view.setVisibility(8);
            }
            ev3.a aVar = this.mBottomControlLayout;
            if (aVar != null) {
                aVar.r9(false);
            }
            V9(this, "em_bas_fast_forward_logo", null, 2, null);
        }
        ev3.a aVar2 = this.mBottomControlLayout;
        if (aVar2 != null) {
            aVar2.d7(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(String dealId) {
        NTShareContext L9 = L9();
        L9.l(dealId);
        com.tencent.qqnt.aio.gallery.share.a c16 = this.mShareManager.c(dealId);
        if (c16 != null) {
            c16.a(L9);
        }
    }

    private final AIORichMediaData H9() {
        com.tencent.qqnt.aio.gallery.j jVar = com.tencent.qqnt.aio.gallery.j.f350008a;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        AIORichMediaData b16 = jVar.b(rFWLayerItemMediaInfo != null ? rFWLayerItemMediaInfo.getMediaId() : null);
        if (b16 == null) {
            QLog.e(getTAG(), 1, "getAIORichMediaData is null, so create new aioRichMediaData");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return null;
            }
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
            if ((rFWLayerItemMediaInfo2 != null ? rFWLayerItemMediaInfo2.getExtraData() : null) instanceof AIOMsgItem) {
                ru3.c cVar = ru3.c.f432503a;
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo3 = this.mCurrentSelectedItem;
                Intrinsics.checkNotNull(rFWLayerItemMediaInfo3);
                Object extraData = rFWLayerItemMediaInfo3.getExtraData();
                Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
                List<? extends AIORichMediaData> c16 = ru3.c.c(cVar, peekAppRuntime, ((AIOMsgItem) extraData).getMsgRecord(), null, null, 12, null);
                List<? extends AIORichMediaData> list = c16;
                if (!(list == null || list.isEmpty())) {
                    b16 = c16.get(0);
                    jVar.f(c16);
                }
            }
        }
        if (b16 == null) {
            String tag = getTAG();
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo4 = this.mCurrentSelectedItem;
            QLog.e(tag, 1, "aioRichMediaData is null, mediaId = " + (rFWLayerItemMediaInfo4 != null ? rFWLayerItemMediaInfo4.getMediaId() : null));
        }
        return b16;
    }

    private final Observer<RFWLayerVideoLoadState> J9() {
        return (Observer) this.mVideoLoadStateObserver.getValue();
    }

    private final HashMap<String, Object> K9() {
        Pair<Long, Integer> a16;
        MsgRecord mCurrentSelectedMessage;
        HashMap<String, Object> hashMap = new HashMap<>();
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null && (a16 = com.tencent.qqnt.aio.gallery.b.f349994a.a(rFWLayerItemMediaInfo)) != null && (mCurrentSelectedMessage = getMCurrentSelectedMessage()) != null) {
            hashMap.put("transmission_mode", Integer.valueOf(com.tencent.qqnt.aio.gallery.e.a(mCurrentSelectedMessage, a16.getSecond().intValue())));
            hashMap.put("aio_type", Integer.valueOf(mCurrentSelectedMessage.chatType));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NTShareContext L9() {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        NTShareActionManager nTShareActionManager = this.mShareManager;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        AIOBrowserBaseData g16 = com.tencent.mobileqq.richmediabrowser.utils.d.g(H9());
        Intrinsics.checkNotNullExpressionValue(g16, "convertGalleryBaseData(getAIORichMediaData())");
        return new NTShareContext(activity, nTShareActionManager, rFWLayerItemMediaInfo, g16, getMCurrentSelectedMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent M9(NTShareContext shareContext) {
        if (shareContext.getMediaType() != 4 && shareContext.getMediaType() != 2) {
            Intent intent = null;
            if (shareContext.getMediaType() == 3) {
                if (shareContext.getMsgRecord() != null && shareContext.f() != null) {
                    com.tencent.qqnt.aio.adapter.richmedia.provider.h provider = shareContext.getProvider();
                    if (provider != null) {
                        MsgRecord msgRecord = shareContext.getMsgRecord();
                        Pair<Long, Integer> f16 = shareContext.f();
                        Intrinsics.checkNotNull(f16);
                        int intValue = f16.getSecond().intValue();
                        ArrayList<MsgElement> arrayList = shareContext.getMsgRecord().elements;
                        Pair<Long, Integer> f17 = shareContext.f();
                        Intrinsics.checkNotNull(f17);
                        intent = provider.h(msgRecord, intValue, arrayList.get(f17.getSecond().intValue()), shareContext.getMsgRecord().chatType);
                    }
                    if (intent != null) {
                        return intent;
                    }
                }
                Intent intent2 = new Intent();
                intent2.putExtra("forward_type", 21);
                return intent2;
            }
            Intent intent3 = new Intent();
            intent3.putExtra("forward_type", 1);
            RFWLayerPicInfo layerPicInfo = shareContext.getLayerItemInfo().getLayerPicInfo();
            intent3.putExtra(AppConstants.Key.FORWARD_FILEPATH, layerPicInfo != null ? layerPicInfo.getMaxsizeFile() : null);
            RFWLayerPicInfo layerPicInfo2 = shareContext.getLayerItemInfo().getLayerPicInfo();
            intent3.putExtra(AppConstants.Key.FORWARD_THUMB, layerPicInfo2 != null ? layerPicInfo2.getMaxsizeFile() : null);
            intent3.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
            intent3.putExtra("key_allow_multiple_forward_from_limit", false);
            return intent3;
        }
        Intent intent4 = new Intent();
        intent4.putExtra(AppConstants.Key.FORWARD_NT_FROM_AIO_MSG, true);
        MsgRecord msgRecord2 = shareContext.getMsgRecord();
        Intrinsics.checkNotNull(msgRecord2);
        intent4.putExtra(AppConstants.Key.FORWARD_NT_MSG_ID, msgRecord2.msgId);
        intent4.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_UID, shareContext.getMsgRecord().peerUid);
        intent4.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_CHATTYPE, shareContext.getMsgRecord().chatType);
        if (shareContext.getMediaType() == 4) {
            intent4.putExtra("forward_type", 3);
        } else {
            intent4.putExtra("forward_type", 1);
        }
        AIOMsgItem aIOMsgItem = new AIOMsgItem(shareContext.getMsgRecord());
        if (shareContext.f() != null) {
            Pair<Long, Integer> f18 = shareContext.f();
            Intrinsics.checkNotNull(f18);
            if (f18.getSecond().intValue() > 0) {
                Pair<Long, Integer> f19 = shareContext.f();
                intent4.putExtra(AppConstants.Key.FORWARD_NT_FILE_INDEX, f19 != null ? f19.getSecond().intValue() : 0);
            }
        }
        new com.tencent.qqnt.aio.forward.b().a(aIOMsgItem, new AIOContact(0, "", "", ""), intent4);
        intent4.putExtra("forward _key_nojump", false);
        return intent4;
    }

    private final com.tencent.mobileqq.sharepanel.f N9(com.tencent.mobileqq.sharepanel.f fVar) {
        fVar.t0(new b());
        return fVar;
    }

    private final com.tencent.mobileqq.sharepanel.f O9(com.tencent.mobileqq.sharepanel.f fVar) {
        fVar.n0(new c());
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(NTAIOLayerMorePart this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ImageView imageView = this$0.mFirstImg;
        if (imageView != null) {
            Intrinsics.checkNotNull(imageView);
            imageView.setAlpha(floatValue);
        }
        ImageView imageView2 = this$0.mSecondImg;
        if (imageView2 != null) {
            Intrinsics.checkNotNull(imageView2);
            imageView2.setAlpha(1.0f - floatValue);
        }
    }

    private final void W9() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(this.EXP_QQ_VIDEO_VIEWING_TAPPING_HOLD);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026DEO_VIEWING_TAPPING_HOLD)");
        expEntity.reportExpExposure();
    }

    private final void Y9(NTShareContext shareContext) {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        if (H9() == null) {
            return;
        }
        this.mShareManager.h(I9());
        I9().setRowVisibility(0, 0, 0);
        if (getActivity().getIntent() != null) {
            getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_photo");
        }
        for (Map.Entry<Integer, com.tencent.qqnt.aio.gallery.share.a> entry : this.mShareManager.f().entrySet()) {
            if (entry.getValue().d() == NTShareActionManager.ShareLine.FIRST) {
                D9(shareContext, entry.getKey().intValue(), arrayList);
            } else if (entry.getValue().d() == NTShareActionManager.ShareLine.SECOND) {
                D9(shareContext, entry.getKey().intValue(), arrayList2);
            }
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        Intent M9 = !rFWLayerItemMediaInfo.getInvalid() ? M9(shareContext) : null;
        if (M9 != null) {
            M9.putExtra(RichMediaBrowserConstants.KEY_TYPE_FROM_NEW_IMG_SHARE_ACTION_SHEET, 1);
            M9.putExtra(((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getShowDataLine(), true);
            I9().setIntentForStartForwardRecentActivity(M9);
        } else {
            I9().setIntentForStartForwardRecentActivity(null);
            if (QLog.isColorLevel()) {
                QLog.e(getTAG(), 2, "showActionSheetForPic setIntentForStartForwardRecentActivity get null intent");
            }
        }
        this.mShareManager.g(arrayList, arrayList2);
        I9().setItemClickListenerV2(this);
        I9().setOnDismissListener(this);
        aa();
        broadcastMessage("LOCK_AUTO_PLAY", Boolean.TRUE);
        this.mShareManager.i(shareContext);
    }

    private final void Z9(NTShareContext shareContext) {
        QLog.i(getTAG(), 1, "showNewActionSheet");
        if (getActivity() instanceof FragmentActivity) {
            if (H9() == null) {
                return;
            }
            String e16 = com.tencent.qqnt.aio.gallery.j.f350008a.e(shareContext.getMediaType());
            if (TextUtils.isEmpty(e16)) {
                QLog.e(getTAG(), 1, "sceneId is error!");
                Y9(shareContext);
                return;
            }
            ISharePanelApi iSharePanelApi = (ISharePanelApi) QRoute.api(ISharePanelApi.class);
            Activity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            this.sharePanel = O9(N9(iSharePanelApi.createSharePanel((FragmentActivity) activity, e16).k0(new d())));
            for (Map.Entry<String, com.tencent.qqnt.aio.gallery.share.a> entry : this.mShareManager.d().entrySet()) {
                if (entry.getValue().d() == NTShareActionManager.ShareLine.FIRST) {
                    E9(shareContext, entry.getKey(), entry.getValue().d(), this.sharePanel);
                } else if (entry.getValue().d() == NTShareActionManager.ShareLine.SECOND) {
                    E9(shareContext, entry.getKey(), entry.getValue().d(), this.sharePanel);
                }
            }
            Iterator<T> it = this.mShareManager.b().iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.aio.gallery.share.a) it.next()).h(shareContext, true);
            }
            aa();
            broadcastMessage("LOCK_AUTO_PLAY", Boolean.TRUE);
            com.tencent.mobileqq.sharepanel.f fVar = this.sharePanel;
            if (fVar != null) {
                fVar.show();
                return;
            }
            return;
        }
        QLog.e(getTAG(), 1, "activity is not FragmentActivity, so open default!");
        Y9(shareContext);
    }

    public final ShareActionSheet I9() {
        Object value = this.mSASBuilder.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mSASBuilder>(...)");
        return (ShareActionSheet) value;
    }

    public final void X9() {
        if (H9() == null) {
            QLog.d(getTAG(), 1, "showActionSheet getAIORichMediaData is null");
            return;
        }
        NTShareContext L9 = L9();
        com.tencent.qqnt.aio.gallery.j jVar = com.tencent.qqnt.aio.gallery.j.f350008a;
        if (jVar.g(this.isUseNewShare, jVar.e(L9.getMediaType()))) {
            Z9(L9);
        } else {
            Y9(L9);
        }
    }

    public final void aa() {
        IVideoPlayerProvider mLayerVideoControlProvider;
        IVideoPlayerProvider mLayerVideoControlProvider2 = getMLayerVideoControlProvider();
        boolean z16 = false;
        if (mLayerVideoControlProvider2 != null && mLayerVideoControlProvider2.isPlaying()) {
            z16 = true;
        }
        if (z16) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            if (!rFWLayerItemMediaInfo.isVideo() || (mLayerVideoControlProvider = getMLayerVideoControlProvider()) == null) {
                return;
            }
            mLayerVideoControlProvider.stop();
        }
    }

    @Override // ev3.b
    public void c0(String actionId, boolean visible) {
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        com.tencent.mobileqq.sharepanel.f fVar = this.sharePanel;
        if (fVar != null) {
            fVar.c0(actionId, visible);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 19005 && I9().isShowing()) {
            I9().dismiss();
        }
        if (resultCode == -1 && requestCode == 10001) {
            QQToast.makeText(getActivity(), R.string.hky, 0).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.zvd) {
            X9();
            INTLayerOperationListener mLayerOperateListener = getMLayerOperateListener();
            if (mLayerOperateListener != null) {
                mLayerOperateListener.clickShowMoreBtn();
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        broadcastMessage("LOCK_AUTO_PLAY", Boolean.FALSE);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.mMoreBtn = (ImageButton) rootView.findViewById(R.id.zvd);
        this.mViewPagerRoot = (RFWGalleryViewPager) rootView.findViewById(R.id.f73943ux);
        ImageButton imageButton = this.mMoreBtn;
        if (imageButton != null) {
            imageButton.setVisibility(0);
        }
        ImageButton imageButton2 = this.mMoreBtn;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
        }
        ImageButton imageButton3 = this.mMoreBtn;
        if (imageButton3 != null) {
            bindDtElement(imageButton3);
        }
        this.mRatePlayTipsView = LayoutInflater.from(rootView.getContext()).inflate(R.layout.i3h, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, ImmersiveUtils.dpToPx(36.0f));
        layoutParams.gravity = 1;
        layoutParams.topMargin = ImmersiveUtils.dpToPx(100.0f);
        View view = this.mRatePlayTipsView;
        if (view != null) {
            view.setClickable(false);
        }
        ((ViewGroup) rootView).addView(this.mRatePlayTipsView, layoutParams);
        this.mFirstImg = (ImageView) rootView.findViewById(R.id.v76);
        this.mSecondImg = (ImageView) rootView.findViewById(R.id.f81704ew);
        P9();
        this.mBottomControlLayout = (ev3.a) RFWIocAbilityProvider.g().getIocInterface(ev3.a.class, rootView, null);
        RFWIocAbilityProvider.g().registerGlobalIoc(getActivity(), this, ev3.b.class);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        int i3 = item.action;
        if (i3 != 72 || item.uinType == 10027) {
            I9().dismiss();
        }
        com.tencent.qqnt.aio.gallery.share.a e16 = this.mShareManager.e(i3);
        if (e16 != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            NTShareActionManager nTShareActionManager = this.mShareManager;
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            AIOBrowserBaseData g16 = com.tencent.mobileqq.richmediabrowser.utils.d.g(H9());
            Intrinsics.checkNotNullExpressionValue(g16, "convertGalleryBaseData(getAIORichMediaData())");
            e16.b(new NTShareContext(activity, nTShareActionManager, rFWLayerItemMediaInfo, g16, getMCurrentSelectedMessage()), item);
        }
        if (i3 == 2) {
            R9("pg_qdesign_shareview", "em_bas_friend_channel", new HashMap());
        }
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClick(int position) {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null) {
            if (rFWLayerItemMediaInfo.isVideo()) {
                IVideoPlayerProvider mLayerVideoControlProvider = getMLayerVideoControlProvider();
                if (mLayerVideoControlProvider != null && mLayerVideoControlProvider.isPlaying()) {
                    IVideoPlayerProvider mLayerVideoControlProvider2 = getMLayerVideoControlProvider();
                    Intrinsics.checkNotNull(mLayerVideoControlProvider2);
                    if (mLayerVideoControlProvider2.getDurationMs() > this.VIDEO_DURATION_TIME) {
                        IVideoPlayerProvider mLayerVideoControlProvider3 = getMLayerVideoControlProvider();
                        if (mLayerVideoControlProvider3 != null) {
                            mLayerVideoControlProvider3.setPlayRate(2.0f);
                        }
                        IVideoPlayerProvider mLayerVideoControlProvider4 = getMLayerVideoControlProvider();
                        if (mLayerVideoControlProvider4 != null) {
                            mLayerVideoControlProvider4.changeOperationLayoutVisible(IVideoPlayerProvider.ControlLayoutVisibleState.VISIBLE_LOCK);
                        }
                        ValueAnimator valueAnimator = this.mVideoIconAnimator;
                        if (valueAnimator != null) {
                            valueAnimator.start();
                        }
                        View view = this.mRatePlayTipsView;
                        if (view != null) {
                            view.setVisibility(0);
                        }
                        ev3.a aVar = this.mBottomControlLayout;
                        if (aVar != null) {
                            aVar.r9(true);
                        }
                        ev3.a aVar2 = this.mBottomControlLayout;
                        if (aVar2 != null) {
                            aVar2.d7(true);
                        }
                        T9(this, "em_bas_fast_forward_logo", null, 2, null);
                    }
                }
            }
            X9();
        }
        INTLayerOperationListener mLayerOperateListener = getMLayerOperateListener();
        if (mLayerOperateListener != null) {
            mLayerOperateListener.onLongPress();
        }
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickCancel(int position) {
        F9();
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickUp(int position) {
        F9();
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        if (H9() != null) {
            RFWGalleryViewPager rFWGalleryViewPager = this.mViewPagerRoot;
            if (rFWGalleryViewPager != null) {
                rFWGalleryViewPager.setOnItemLongClickListener(this);
                return;
            }
            return;
        }
        RFWGalleryViewPager rFWGalleryViewPager2 = this.mViewPagerRoot;
        if (rFWGalleryViewPager2 != null) {
            rFWGalleryViewPager2.setOnItemClickListener(null);
        }
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        W9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart, com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.updateLayerState(layerState);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo == null || !rFWLayerItemMediaInfo.isVideo()) {
            return;
        }
        RFWLayerDataCenter.INSTANCE.observerGlobalState(RFWLayerVideoLoadState.class, rFWLayerItemMediaInfo.getMediaId(), J9());
    }

    private final void P9() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.8f, 0.2f).setDuration(500L);
        this.mVideoIconAnimator = duration;
        if (duration != null) {
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.aio.gallery.part.p
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    NTAIOLayerMorePart.Q9(NTAIOLayerMorePart.this, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator = this.mVideoIconAnimator;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(-1);
        }
        ValueAnimator valueAnimator2 = this.mVideoIconAnimator;
        if (valueAnimator2 == null) {
            return;
        }
        valueAnimator2.setRepeatMode(2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r4 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void R9(String pgId, String elementId, Map<String, Object> params) {
        Map map;
        if (params == null) {
            map = new HashMap();
        }
        map.put("qq_eid", elementId);
        map.put("qq_pgid", pgId);
        HashMap hashMap = new HashMap();
        hashMap.put("biz_source", " biz_src_jc_video");
        map.put("cur_pg", hashMap);
        VideoReport.reportEvent("qq_clck", map);
    }

    private final void S9(String elementId, Map<String, Object> params) {
        if (params == null) {
            params = new HashMap<>();
        }
        params.put("dt_eid", elementId);
        params.put("dt_pgid", getPageId());
        params.put("cur_pg", K9());
        VideoReport.reportEvent("dt_imp", params);
    }

    private final void U9(String elementId, Map<String, Object> params) {
        if (params == null) {
            params = new HashMap<>();
        }
        params.put("dt_eid", elementId);
        params.put("dt_pgid", getPageId());
        params.put("cur_pg", K9());
        VideoReport.reportEvent("dt_imp_end", params);
    }

    public /* synthetic */ NTAIOLayerMorePart(NTShareActionManager nTShareActionManager, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(nTShareActionManager, (i3 & 2) != 0 ? false : z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void T9(NTAIOLayerMorePart nTAIOLayerMorePart, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        nTAIOLayerMorePart.S9(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void V9(NTAIOLayerMorePart nTAIOLayerMorePart, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        nTAIOLayerMorePart.U9(str, map);
    }
}
