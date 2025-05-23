package com.qzone.reborn.part.plusnew;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.part.plusnew.b;
import com.qzone.reborn.util.QZoneProcessPreloadManager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenImmersiveFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 S2\u00020\u0001:\u0001TB\u0017\u0012\u0006\u0010L\u001a\u00020\n\u0012\u0006\u0010P\u001a\u00020\u0014\u00a2\u0006\u0004\bQ\u0010RJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J.\u0010\u0017\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\nH\u0002J\u001a\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0007H\u0002J\"\u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020\u0014H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\"\u0010+\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020\u0014H\u0002J\b\u0010-\u001a\u00020,H\u0002R\u0018\u00100\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0018\u0010C\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010L\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006U"}, d2 = {"Lcom/qzone/reborn/part/plusnew/QzoneNewPlusMenuContainerPart;", "Lcom/qzone/reborn/base/k;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "onPartResume", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "initView", "T9", "Landroid/widget/ImageView;", "imageView", "iconUrl", "", "width", "height", "Z9", "initData", "contentLayout", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "S9", "ia", "U9", "ha", "", "showDialog", LocaleUtils.L_JAPANESE, "evintId", "aa", "eid", "view", "ba", "position", "da", "ca", "ga", "ea", "Lcom/qzone/reborn/part/plusnew/c;", "V9", "d", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "guideDialog", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/qzone/reborn/part/plusnew/b;", "f", "Lcom/qzone/reborn/part/plusnew/b;", "qzonePlusItemAdapter", tl.h.F, "Lcom/qzone/reborn/part/plusnew/c;", "qzonePlusInfo", "i", "Landroid/view/View;", "shuoshuoHeadView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "albumHeadView", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "albumImageView", "D", "shuoshuoImageView", "Lcom/qzone/reborn/part/plus/f;", "E", "Lcom/qzone/reborn/part/plus/f;", "mPlusMenuHelper", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "refer", "G", "I", IProfileCardConst.KEY_FROM_TYPE, "pageId", "<init>", "(Ljava/lang/String;I)V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneNewPlusMenuContainerPart extends com.qzone.reborn.base.k {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int I = ViewUtils.dip2px(72.0f);
    private static final int J = ViewUtils.dip2px(72.0f);
    private static final int K = ImmersiveUtils.dpToPx(88.0f);
    private static final int L = (int) (ImmersiveUtils.dpToPx(812.0f) * 0.6d);
    private static final int M = ImmersiveUtils.dpToPx(478.0f);
    private static int N = ViewUtils.dip2px(40.0f);
    private static int P = ViewUtils.dip2px(40.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView albumImageView;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView shuoshuoImageView;

    /* renamed from: E, reason: from kotlin metadata */
    private com.qzone.reborn.part.plus.f mPlusMenuHelper;

    /* renamed from: F, reason: from kotlin metadata */
    private final String refer;

    /* renamed from: G, reason: from kotlin metadata */
    private int fromType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUSHalfScreenImmersiveFloatingView guideDialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.part.plusnew.b qzonePlusItemAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.part.plusnew.c qzonePlusInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View shuoshuoHeadView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View albumHeadView;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000eR\u0014\u0010\u001a\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001b\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/part/plusnew/QzoneNewPlusMenuContainerPart$a;", "", "", "SMALL_ICON_WIDTH", "I", "b", "()I", "setSMALL_ICON_WIDTH", "(I)V", "SMALL_ICON_HEIGHT", "a", "setSMALL_ICON_HEIGHT", "", "AI_DRAOW_ICON_URL", "Ljava/lang/String;", "ALBUM_ICON_URL", "BLOG_ICON_URL", "CAMERA_ICON_URL", "DEFAULT_DIALOG_HEIGHT", "DEFAULT_HEIGHT", "DIALOG_TOP_PADDING", "ICON_HEIGHT", "ICON_WIDTH", "INSIGHT_ICON_URL", "MINIMUM_DIALOG_HEIGHT", "REGISTRATION_ICON_URL", "SHUOSHUO_ICON_URL", "TAG", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.part.plusnew.QzoneNewPlusMenuContainerPart$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return QzoneNewPlusMenuContainerPart.P;
        }

        public final int b() {
            return QzoneNewPlusMenuContainerPart.N;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/part/plusnew/QzoneNewPlusMenuContainerPart$b", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$o;", "", "a", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QUSBaseHalfScreenFloatingView.o {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public void a() {
            QzoneNewPlusMenuContainerPart.this.T9();
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public boolean onClick(View v3) {
            return true;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/part/plusnew/QzoneNewPlusMenuContainerPart$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "defaultHeight", "", HippyTKDListViewAdapter.X, "y", "", "canScrollDown", "canScrollUp", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f58528d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QzoneNewPlusMenuContainerPart f58529e;

        c(View view, QzoneNewPlusMenuContainerPart qzoneNewPlusMenuContainerPart) {
            this.f58528d = view;
            this.f58529e = qzoneNewPlusMenuContainerPart;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            RecyclerView recyclerView = this.f58529e.recyclerView;
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager == null) {
                return super.canScrollUp(x16, y16);
            }
            if (linearLayoutManager.findFirstVisibleItemPosition() != 0) {
                return true;
            }
            RecyclerView recyclerView3 = this.f58529e.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView3;
            }
            if (recyclerView2.getChildAt(0) != null) {
                View childAt = linearLayoutManager.getChildAt(0);
                if (!(childAt != null && childAt.getTop() == 0)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            RecyclerView recyclerView = this.f58529e.recyclerView;
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager == null) {
                return super.canScrollUp(x16, y16);
            }
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            RecyclerView recyclerView3 = this.f58529e.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView3 = null;
            }
            if (findLastVisibleItemPosition != recyclerView3.getChildCount() - 1) {
                return true;
            }
            RecyclerView recyclerView4 = this.f58529e.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView4 = null;
            }
            RecyclerView recyclerView5 = this.f58529e.recyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView5 = null;
            }
            View childAt = recyclerView4.getChildAt(recyclerView5.getChildCount() - 1);
            if (childAt == null) {
                return true;
            }
            int bottom = childAt.getBottom();
            RecyclerView recyclerView6 = this.f58529e.recyclerView;
            if (recyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView6;
            }
            return bottom != recyclerView2.getHeight();
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView, reason: from getter */
        public View getF58528d() {
            return this.f58528d;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int defaultHeight() {
            if (this.f58529e.getPartRootView().getHeight() > QzoneNewPlusMenuContainerPart.L) {
                return QzoneNewPlusMenuContainerPart.M;
            }
            return maxHeight();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return this.f58529e.getPartRootView().getHeight() - QzoneNewPlusMenuContainerPart.K;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/part/plusnew/QzoneNewPlusMenuContainerPart$e", "Lcom/qzone/reborn/part/plusnew/b$a;", "", "position", "", QZoneDTLoginReporter.SCHEMA, "Landroid/view/View;", "view", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements b.a {
        e() {
        }

        @Override // com.qzone.reborn.part.plusnew.b.a
        public void a(int position, String schema, View view) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(view, "view");
            com.qzone.reborn.part.plus.f fVar = QzoneNewPlusMenuContainerPart.this.mPlusMenuHelper;
            if (fVar != null) {
                fVar.h(schema);
            }
            QzoneNewPlusMenuContainerPart.this.T9();
            QzoneNewPlusMenuContainerPart.this.da("em_qz_function_item", view, position);
        }
    }

    public QzoneNewPlusMenuContainerPart(String refer, int i3) {
        Intrinsics.checkNotNullParameter(refer, "refer");
        this.refer = refer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9() {
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.guideDialog;
        if (qUSHalfScreenImmersiveFloatingView != null) {
            qUSHalfScreenImmersiveFloatingView.t();
        }
    }

    private final void U9() {
        com.qzone.reborn.part.plusnew.c cVar;
        ArrayList<QzoneNewPlusItemData> b16;
        com.qzone.reborn.part.plusnew.c cVar2 = this.qzonePlusInfo;
        if (cVar2 != null) {
            boolean z16 = false;
            if (cVar2 != null && cVar2.getAdId() == 0) {
                z16 = true;
            }
            if (!z16) {
                ArrayList arrayList = new ArrayList();
                com.qzone.reborn.part.plusnew.c cVar3 = this.qzonePlusInfo;
                if (cVar3 != null && (b16 = cVar3.b()) != null) {
                    for (QzoneNewPlusItemData qzoneNewPlusItemData : b16) {
                        if (qzoneNewPlusItemData.getItemId() != 0) {
                            arrayList.add(Integer.valueOf(qzoneNewPlusItemData.getItemId()));
                        }
                    }
                }
                com.qzone.reborn.part.plusnew.c cVar4 = this.qzonePlusInfo;
                if (cVar4 == null || cVar4.b() == null || (cVar = this.qzonePlusInfo) == null) {
                    return;
                }
                o.f58563a.q(arrayList, cVar, new Function1<com.qzone.reborn.part.plusnew.c, Unit>() { // from class: com.qzone.reborn.part.plusnew.QzoneNewPlusMenuContainerPart$fetchRedQzoneData$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(c cVar5) {
                        invoke2(cVar5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(c cVar5) {
                        b bVar;
                        bVar = QzoneNewPlusMenuContainerPart.this.qzonePlusItemAdapter;
                        if (bVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("qzonePlusItemAdapter");
                            bVar = null;
                        }
                        bVar.r0(cVar5, true);
                        QzoneNewPlusMenuContainerPart.this.ca();
                    }
                });
                return;
            }
        }
        QLog.e("QzoneNewPlusMenuContainerPart", 2, "no red dot Data");
    }

    private final com.qzone.reborn.part.plusnew.c V9() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QzoneNewPlusItemData(0, "https://qzonestyle.gtimg.cn/qzone/client/mqq/publisher/publisher_icon_camear.png", "\u76f8\u673a", "mqqapi://videostory/takevideo?src_type=internal&version=1&from=qzoneCamera&uin=&appid=406&widgetid=&shareto=2", null, 0, null, null, 1, 241, null));
        String a16 = com.qzone.business.plusunion.plusoperation.c.a();
        Intrinsics.checkNotNullExpressionValue(a16, "getPlusSignInSchemePrefix()");
        arrayList.add(new QzoneNewPlusItemData(0, "https://qzonestyle.gtimg.cn/qzone/client/mqq/publisher/publisher_icon_registration.png", "\u7b7e\u5230", a16, null, 0, null, null, 2, 241, null));
        arrayList.add(new QzoneNewPlusItemData(0, "https://qzonestyle.gtimg.cn/qzone/client/mqq/publisher/publisher_icon_blog.png", "\u65e5\u5fd7", "https://h5.qzone.qq.com/blog/list2?_wv=3&_proxy=1&source=panel", null, 0, null, null, 3, 241, null));
        arrayList.add(new QzoneNewPlusItemData(0, "https://qzonestyle.gtimg.cn/qzone/client/mqq/publisher/publisher_icon_insight.png", "AI\u5999\u7ed8", "mqqapi://arouse/openqqpublish/mood?target=2", null, 0, null, null, 4, 241, null));
        arrayList.add(new QzoneNewPlusItemData(0, "https://qzonestyle.gtimg.cn/qzone/client/mqq/publisher/publisher_icon_aidraw.png", "\u73a9\u6cd5\u63a8\u8350", "mqzone://arouse/openqqpublish/mood?target=15", null, 0, null, null, 5, 241, null));
        Unit unit = Unit.INSTANCE;
        return new com.qzone.reborn.part.plusnew.c(-1, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QzoneNewPlusMenuContainerPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.aa("dt_pgout");
        this$0.ja(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(QzoneNewPlusMenuContainerPart this$0, View view) {
        com.qzone.reborn.part.plus.f fVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.qzone.reborn.util.l.f59550a.T(this$0.getActivity(), this$0.getHostFragment()) && (fVar = this$0.mPlusMenuHelper) != null) {
            fVar.h("mqzone://arouse/writemood");
        }
        this$0.T9();
        this$0.ba("em_qz_write_talk", this$0.shuoshuoHeadView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(QzoneNewPlusMenuContainerPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qzone.reborn.part.plus.f fVar = this$0.mPlusMenuHelper;
        if (fVar != null) {
            fVar.h(QZoneJsConstants.SCHEME_PREFIX_UPLOAD_PHOTO);
        }
        this$0.T9();
        this$0.ba("em_qz_upload_album", this$0.albumHeadView);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void aa(String evintId) {
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(this.fromType));
        hashMap.put("qq_pgid", "pg_qz_publish_plus_panel");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, eo.c.f396879a.c());
        fo.c.c(evintId, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca() {
        ArrayList<QzoneNewPlusItemData> b16;
        com.qzone.reborn.part.plusnew.c cVar = this.qzonePlusInfo;
        if (cVar == null || (b16 = cVar.b()) == null) {
            return;
        }
        int i3 = 0;
        for (QzoneNewPlusItemData qzoneNewPlusItemData : b16) {
            com.qzone.reborn.part.plusnew.c cVar2 = this.qzonePlusInfo;
            RecyclerView recyclerView = null;
            ArrayList<QzoneNewPlusItemData> b17 = cVar2 != null ? cVar2.b() : null;
            Intrinsics.checkNotNull(b17);
            if (i3 < Math.min(6, b17.size())) {
                RecyclerView recyclerView2 = this.recyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView = recyclerView2;
                }
                ea("em_qz_function_item", recyclerView, i3);
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga() {
        ArrayList<QzoneNewPlusItemData> b16;
        ArrayList<QzoneNewPlusItemData> b17;
        com.qzone.reborn.part.plusnew.c cVar = this.qzonePlusInfo;
        if (cVar == null || (b16 = cVar.b()) == null) {
            return;
        }
        int i3 = 0;
        for (QzoneNewPlusItemData qzoneNewPlusItemData : b16) {
            if (i3 >= 6) {
                com.qzone.reborn.part.plusnew.c cVar2 = this.qzonePlusInfo;
                RecyclerView recyclerView = null;
                Integer valueOf = (cVar2 == null || (b17 = cVar2.b()) == null) ? null : Integer.valueOf(b17.size());
                Intrinsics.checkNotNull(valueOf);
                if (i3 < valueOf.intValue()) {
                    RecyclerView recyclerView2 = this.recyclerView;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        recyclerView = recyclerView2;
                    }
                    ea("em_qz_function_item", recyclerView, i3);
                }
            }
            i3++;
        }
    }

    private final void ha(Object args) {
        if (QZoneUnreadServletLogic.o(LoginData.getInstance().getUin()) == 2) {
            com.qzone.util.e.a(getActivity(), false);
            return;
        }
        QLog.i("QzoneNewPlusMenuContainerPart", 2, "showNewPlusOperationDialog");
        if (this.guideDialog == null) {
            initView();
        }
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.guideDialog;
        if (qUSHalfScreenImmersiveFloatingView != null) {
            qUSHalfScreenImmersiveFloatingView.N(1);
        }
        com.qzone.reborn.part.plusnew.b bVar = this.qzonePlusItemAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qzonePlusItemAdapter");
            bVar = null;
        }
        com.qzone.reborn.part.plusnew.b.s0(bVar, this.qzonePlusInfo, false, 2, null);
        QZoneProcessPreloadManager.g().preloadPeak();
        aa("dt_pgin");
    }

    private final void ia() {
        com.qzone.reborn.part.plusnew.c g16 = o.f58563a.g();
        this.qzonePlusInfo = g16;
        if (g16 != null) {
            Intrinsics.checkNotNull(g16);
            if (!g16.b().isEmpty()) {
                return;
            }
        }
        QLog.i("QzoneNewPlusMenuContainerPart", 2, "no data use lastDataInfo");
        this.qzonePlusInfo = V9();
    }

    private final void initData() {
        o.f58563a.m();
    }

    private final void initView() {
        com.qzone.reborn.part.plusnew.b bVar = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cnc, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026_menu_guide_layout, null)");
        ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(android.R.id.content);
        QUSHalfScreenImmersiveFloatingView S9 = S9(inflate);
        this.guideDialog = S9;
        viewGroup.addView(S9, new ViewGroup.LayoutParams(-1, -1));
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.guideDialog;
        if (qUSHalfScreenImmersiveFloatingView != null) {
            qUSHalfScreenImmersiveFloatingView.j(new d());
        }
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2 = this.guideDialog;
        if (qUSHalfScreenImmersiveFloatingView2 != null) {
            qUSHalfScreenImmersiveFloatingView2.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.qzone.reborn.part.plusnew.e
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    QzoneNewPlusMenuContainerPart.W9(QzoneNewPlusMenuContainerPart.this);
                }
            });
        }
        VideoReport.setElementExposePolicy(this.guideDialog, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(this.guideDialog, EndExposurePolicy.REPORT_NONE);
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView3 = this.guideDialog;
        if (qUSHalfScreenImmersiveFloatingView3 != null) {
            qUSHalfScreenImmersiveFloatingView3.setVisibility(8);
        }
        View findViewById = inflate.findViewById(R.id.nfb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.rv_space_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.qzonePlusItemAdapter = new com.qzone.reborn.part.plusnew.b();
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        com.qzone.reborn.part.plusnew.b bVar2 = this.qzonePlusItemAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qzonePlusItemAdapter");
            bVar2 = null;
        }
        recyclerView2.setAdapter(bVar2);
        this.shuoshuoHeadView = inflate.findViewById(R.id.nla);
        this.albumHeadView = inflate.findViewById(R.id.nl5);
        View view = this.shuoshuoHeadView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.part.plusnew.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QzoneNewPlusMenuContainerPart.X9(QzoneNewPlusMenuContainerPart.this, view2);
                }
            });
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ktu);
        this.albumImageView = imageView;
        int i3 = I;
        int i16 = J;
        Z9(imageView, "https://qzonestyle.gtimg.cn/qzone/client/mqq/publisher/publisher_icon_qzonealbum.png", i3, i16);
        View view2 = this.albumHeadView;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.part.plusnew.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    QzoneNewPlusMenuContainerPart.Y9(QzoneNewPlusMenuContainerPart.this, view3);
                }
            });
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.lrw);
        this.shuoshuoImageView = imageView2;
        Z9(imageView2, "https://qzonestyle.gtimg.cn/qzone/client/mqq/publisher/publisher_icon_shuoshuo.png", I, i16);
        com.qzone.reborn.part.plusnew.b bVar3 = this.qzonePlusItemAdapter;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qzonePlusItemAdapter");
        } else {
            bVar = bVar3;
        }
        bVar.q0(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ja(boolean showDialog) {
        if (AccessibilityUtil.j(getContext())) {
            ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(android.R.id.content);
            if (showDialog) {
                AccessibilityUtil.e(viewGroup, false);
                AccessibilityUtil.e(this.guideDialog, true);
                AccessibilityUtil.l(getContext(), this.guideDialog);
                return;
            }
            AccessibilityUtil.e(viewGroup, true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual("OPEN_NEW_PLUS_MENU", action)) {
            QZLog.d("QzoneNewPlusMenuContainerPart", 2, "OPEN_NEW_PLUS_MENU");
            ia();
            U9();
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type kotlin.Int");
            this.fromType = ((Integer) args).intValue();
            ha(args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.mPlusMenuHelper = new com.qzone.reborn.part.plus.f(getActivity(), this.refer);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.guideDialog != null && activity != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
                if (viewGroup != null) {
                    viewGroup.removeView(this.guideDialog);
                }
            } catch (Throwable th5) {
                QZLog.e("QzoneNewPlusMenuContainerPart", 1, th5, new Object[0]);
            }
        }
        this.guideDialog = null;
        com.qzone.reborn.part.plusnew.b bVar = this.qzonePlusItemAdapter;
        if (bVar != null) {
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qzonePlusItemAdapter");
                bVar = null;
            }
            bVar.q0(null);
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.setAdapter(null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        initData();
    }

    private final QUSHalfScreenImmersiveFloatingView S9(View contentLayout) {
        QLog.i("QzoneNewPlusMenuContainerPart", 2, "createDialogContainer");
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = new QUSHalfScreenImmersiveFloatingView(getContext());
        qUSHalfScreenImmersiveFloatingView.setBackgroundColor(0);
        qUSHalfScreenImmersiveFloatingView.setIgnoreHorizontalMove(true);
        qUSHalfScreenImmersiveFloatingView.setDraggable(true);
        qUSHalfScreenImmersiveFloatingView.setOnOutsideClickListener(new b());
        qUSHalfScreenImmersiveFloatingView.setQUSDragFloatController(new c(contentLayout, this));
        return qUSHalfScreenImmersiveFloatingView;
    }

    private final void Z9(ImageView imageView, String iconUrl, int width, int height) {
        if (imageView != null) {
            com.qzone.reborn.util.h.i(getContext(), imageView, iconUrl, width, height);
        }
    }

    private final void ba(String eid, View view) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(this.fromType));
            fo.c.e(eid, "pg_qz_publish_plus_panel", view, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da(String eid, View view, int position) {
        String str;
        String str2;
        QzoneNewPlusRedItemData redPointInfo;
        String redPointTitle;
        QzoneNewPlusRedItemData redPointInfo2;
        QzoneNewPlusRedItemData redPointInfo3;
        QzoneNewPlusRedItemData redPointInfo4;
        ArrayList<QzoneNewPlusItemData> b16;
        if (view != null) {
            HashMap hashMap = new HashMap();
            com.qzone.reborn.part.plusnew.c cVar = this.qzonePlusInfo;
            String str3 = null;
            QzoneNewPlusItemData qzoneNewPlusItemData = (cVar == null || (b16 = cVar.b()) == null) ? null : b16.get(position);
            String str4 = "";
            if (qzoneNewPlusItemData == null || (str = qzoneNewPlusItemData.getMainItemTitle()) == null) {
                str = "";
            }
            hashMap.put("item_name", str);
            int i3 = 0;
            if (qzoneNewPlusItemData != null && (redPointInfo4 = qzoneNewPlusItemData.getRedPointInfo()) != null && redPointInfo4.getShowRedPoint()) {
                i3 = 1;
            }
            hashMap.put("is_red_tips", Integer.valueOf(i3));
            if (qzoneNewPlusItemData != null && (redPointInfo3 = qzoneNewPlusItemData.getRedPointInfo()) != null) {
                str3 = redPointInfo3.getRedPointImage();
            }
            hashMap.put("have_icon", Integer.valueOf(!TextUtils.isEmpty(str3) ? 1 : 0));
            if (qzoneNewPlusItemData == null || (redPointInfo2 = qzoneNewPlusItemData.getRedPointInfo()) == null || (str2 = redPointInfo2.getSubTitle()) == null) {
                str2 = "";
            }
            hashMap.put("red_tips_context", str2);
            if (qzoneNewPlusItemData != null && (redPointInfo = qzoneNewPlusItemData.getRedPointInfo()) != null && (redPointTitle = redPointInfo.getRedPointTitle()) != null) {
                str4 = redPointTitle;
            }
            hashMap.put("recommend_context", str4);
            new HashMap().put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(this.fromType));
            fo.c.e(eid, "pg_qz_publish_plus_panel", view, hashMap);
        }
    }

    private final void ea(String eid, View view, int position) {
        String str;
        String str2;
        QzoneNewPlusRedItemData redPointInfo;
        String redPointTitle;
        QzoneNewPlusRedItemData redPointInfo2;
        QzoneNewPlusRedItemData redPointInfo3;
        QzoneNewPlusRedItemData redPointInfo4;
        ArrayList<QzoneNewPlusItemData> b16;
        if (view != null) {
            HashMap hashMap = new HashMap();
            com.qzone.reborn.part.plusnew.c cVar = this.qzonePlusInfo;
            String str3 = null;
            QzoneNewPlusItemData qzoneNewPlusItemData = (cVar == null || (b16 = cVar.b()) == null) ? null : b16.get(position);
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(this.fromType));
            String str4 = "";
            if (qzoneNewPlusItemData == null || (str = qzoneNewPlusItemData.getMainItemTitle()) == null) {
                str = "";
            }
            hashMap.put("item_name", str);
            int i3 = 0;
            if (qzoneNewPlusItemData != null && (redPointInfo4 = qzoneNewPlusItemData.getRedPointInfo()) != null && redPointInfo4.getShowRedPoint()) {
                i3 = 1;
            }
            hashMap.put("is_red_tips", Integer.valueOf(i3));
            if (qzoneNewPlusItemData != null && (redPointInfo3 = qzoneNewPlusItemData.getRedPointInfo()) != null) {
                str3 = redPointInfo3.getRedPointImage();
            }
            hashMap.put("have_icon", Integer.valueOf(!TextUtils.isEmpty(str3) ? 1 : 0));
            if (qzoneNewPlusItemData == null || (redPointInfo2 = qzoneNewPlusItemData.getRedPointInfo()) == null || (str2 = redPointInfo2.getSubTitle()) == null) {
                str2 = "";
            }
            hashMap.put("red_tips_context", str2);
            if (qzoneNewPlusItemData != null && (redPointInfo = qzoneNewPlusItemData.getRedPointInfo()) != null && (redPointTitle = redPointInfo.getRedPointTitle()) != null) {
                str4 = redPointTitle;
            }
            hashMap.put("recommend_context", str4);
            fo.c.g(eid, "pg_qz_publish_plus_panel", view, hashMap);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/part/plusnew/QzoneNewPlusMenuContainerPart$d", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$p;", "", "onShowTotalStart", "onShowTotal", "onShowDefaultStart", "onShowDefault", "onShowMinStart", "onShowMin", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements QUSBaseHalfScreenFloatingView.p {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefaultStart() {
            QzoneNewPlusMenuContainerPart.this.ja(true);
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            QzoneNewPlusMenuContainerPart.this.ga();
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefault() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMin() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMinStart() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
        }
    }
}
