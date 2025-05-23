package com.tencent.sqshow.zootopia.nativeui.view.control;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import b94.a;
import b94.d;
import b94.e;
import com.google.protobuf.nano.MessageNano;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.filament.api.IZShowFilamentPreviewProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.DressTaskExtInfo;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.ue.u;
import com.tencent.sqshow.zootopia.nativeui.view.PortalStoreGroupPanelPageData;
import com.tencent.sqshow.zootopia.nativeui.view.control.PortalStorePanelControlView;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotView;
import com.tencent.zplan.luabridge.a;
import common.config.service.QzoneConfig;
import g94.f;
import ga4.g;
import h94.FinishAIMakeFaceData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.ca;
import s94.FaceInfoSyncData;
import tl.h;
import uv4.al;
import uv4.am;
import uv4.az;
import z94.a;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0002VWB'\b\u0007\u0012\u0006\u0010O\u001a\u00020N\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\b\u0002\u0010R\u001a\u00020\b\u00a2\u0006\u0004\bS\u0010TJ\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u001b\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0003H\u0002J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u001fJ\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rJ2\u0010'\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010#\u001a\u00020\r2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$J\u0006\u0010(\u001a\u00020\u0006J\u0006\u0010)\u001a\u00020\u0006J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001cJ\u0006\u0010,\u001a\u00020\u0006J\u0006\u0010-\u001a\u00020\u0006J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020.H\u0016R\u0016\u00101\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u00109R$\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u001f0;j\b\u0012\u0004\u0012\u00020\u001f`<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010=R$\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u00040?j\b\u0012\u0004\u0012\u00020\u0004`@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010AR$\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\n0?j\b\u0012\u0004\u0012\u00020\n`@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006X"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/control/PortalStorePanelControlView;", "Landroid/widget/FrameLayout;", "Lz94/a;", "", "Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "data", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "position", "Lcom/tencent/sqshow/zootopia/nativeui/view/control/PortalStorePanelControlView$b;", "j", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "l", "v", "t", "r", DomainData.DOMAIN_NAME, h.F, "from", BdhLogUtil.LogTag.Tag_Conn, "B", "Luv4/az;", "items", "p", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lb94/b;", "i", "selectedIndex", "setSelectIndex", "defaultIndex", "", "isFromChangeGender", "isFakeData", "setData", "w", HippyTKDListViewAdapter.X, "panelChannel", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lh94/a;", "d", "Ljava/lang/String;", "mSelectedIndex", "e", "I", "mSelectedPosition", "f", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Ln74/ca;", "Ln74/ca;", "mBinding", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mListenerPool", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mDataList", "mViewList", "D", "Lcom/tencent/sqshow/zootopia/nativeui/view/control/PortalStorePanelControlView$b;", "currentViewHolder", "Lqu4/a;", "E", "Lqu4/a;", "lastAvatarCharacter", UserInfo.SEX_FEMALE, "Z", "isViewShow", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStorePanelControlView extends FrameLayout implements a {

    /* renamed from: C */
    private final ArrayList<b> mViewList;

    /* renamed from: D, reason: from kotlin metadata */
    private b currentViewHolder;

    /* renamed from: E, reason: from kotlin metadata */
    private qu4.a lastAvatarCharacter;

    /* renamed from: F */
    private volatile boolean isViewShow;

    /* renamed from: d, reason: from kotlin metadata */
    private String mSelectedIndex;

    /* renamed from: e, reason: from kotlin metadata */
    private int mSelectedPosition;

    /* renamed from: f, reason: from kotlin metadata */
    private j mChannel;

    /* renamed from: h */
    private final ca mBinding;

    /* renamed from: i, reason: from kotlin metadata */
    private final HashSet<b94.b> mListenerPool;

    /* renamed from: m */
    private final ArrayList<PortalStoreGroupPanelPageData> mDataList;

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 ?2\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u00a2\u0006\u0004\b=\u0010>J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\bR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\"R\u001c\u0010'\u001a\n !*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010*\u001a\n !*\u0004\u0018\u00010(0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010)R\u001c\u0010-\u001a\n !*\u0004\u0018\u00010+0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010.R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b\u001b\u00105\"\u0004\b6\u00107R\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u0011\u001a\u0004\b%\u0010\u0013\"\u0004\b:\u0010;\u00a8\u0006@"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/control/PortalStorePanelControlView$b;", "", "", "id", "", "selected", "", "currentIndex", "", "g", "selectedIndex", "from", "Lcom/tencent/sqshow/zootopia/nativeui/view/control/PortalStorePanelControlView;", HippyNestedScrollComponent.PRIORITY_PARENT, h.F, "b", "a", "I", "getPosition", "()I", "position", "Landroid/view/View;", "Landroid/view/View;", "f", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "c", "Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "d", "()Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "data", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "Landroid/widget/LinearLayout;", "rootLayout", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "hintTxv", "Lcom/tencent/image/URLImageView;", "Lcom/tencent/image/URLImageView;", "iconIgv", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "redDot", "Lcom/tencent/sqshow/zootopia/nativeui/view/control/PortalStorePanelControlView;", "parentView", "i", "Ljava/lang/String;", "currentSelectedIndex", "j", "Z", "()Z", "setClearAfterNotSelected", "(Z)V", "clearAfterNotSelected", "k", "setRedDotId", "(I)V", "redDotId", "<init>", "(ILandroid/view/View;Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;)V", "l", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b {

        /* renamed from: a, reason: from kotlin metadata */
        private final int position;

        /* renamed from: b, reason: from kotlin metadata */
        private final View com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String;

        /* renamed from: c, reason: from kotlin metadata */
        private final PortalStoreGroupPanelPageData data;

        /* renamed from: d, reason: from kotlin metadata */
        private final LinearLayout rootLayout;

        /* renamed from: e, reason: from kotlin metadata */
        private final TextView hintTxv;

        /* renamed from: f, reason: from kotlin metadata */
        private final URLImageView iconIgv;

        /* renamed from: g, reason: from kotlin metadata */
        private final ZPlanRedDotView redDot;

        /* renamed from: h */
        private PortalStorePanelControlView parentView;

        /* renamed from: i, reason: from kotlin metadata */
        private String currentSelectedIndex;

        /* renamed from: j, reason: from kotlin metadata */
        private boolean clearAfterNotSelected;

        /* renamed from: k, reason: from kotlin metadata */
        private int redDotId;

        public b(int i3, View rootView, PortalStoreGroupPanelPageData data) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(data, "data");
            this.position = i3;
            this.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String = rootView;
            this.data = data;
            this.rootLayout = (LinearLayout) rootView.findViewById(R.id.pmk);
            this.hintTxv = (TextView) rootView.findViewById(R.id.pml);
            this.iconIgv = (URLImageView) rootView.findViewById(R.id.pmj);
            this.redDot = (ZPlanRedDotView) rootView.findViewById(R.id.qgv);
            this.currentSelectedIndex = "";
            this.redDotId = -1;
        }

        private final void g(int id5, boolean selected, String currentIndex) {
            this.redDotId = id5;
            this.redDot.g(1);
            this.redDot.h(id5);
            this.currentSelectedIndex = currentIndex;
            if (selected || !this.clearAfterNotSelected) {
                return;
            }
            PortalStorePanelControlView portalStorePanelControlView = this.parentView;
            if (portalStorePanelControlView != null && portalStorePanelControlView.isViewShow) {
                QLog.d("PortalStorePanelControlView_", 1, "clear redDot, id: " + this.redDotId + ", when not selected");
                b(id5);
                this.clearAfterNotSelected = false;
            }
        }

        public final void a() {
            b(this.redDotId);
        }

        public final void b(int id5) {
            f.b(f.f401577a, id5, this.redDot.getStoreType(), 0, false, 12, null);
        }

        /* renamed from: c, reason: from getter */
        public final boolean getClearAfterNotSelected() {
            return this.clearAfterNotSelected;
        }

        /* renamed from: d, reason: from getter */
        public final PortalStoreGroupPanelPageData getData() {
            return this.data;
        }

        /* renamed from: e, reason: from getter */
        public final int getRedDotId() {
            return this.redDotId;
        }

        /* renamed from: f, reason: from getter */
        public final View getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String() {
            return this.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String;
        }

        public final void h(String selectedIndex, String from, PortalStorePanelControlView parent) {
            Intrinsics.checkNotNullParameter(selectedIndex, "selectedIndex");
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(parent, "parent");
            this.parentView = parent;
            boolean areEqual = Intrinsics.areEqual(selectedIndex, this.data.getIndex());
            TextView textView = this.hintTxv;
            String str = this.data.getStoreGrpupCfgV1().f440267c;
            if (str.length() == 0) {
                str = this.data.getDefaultName();
            }
            textView.setText(str);
            g(this.data.getStoreGrpupCfgV1().f440272h, areEqual, this.data.getIndex());
            if (areEqual) {
                if (Intrinsics.areEqual(from, "click")) {
                    b(this.data.getStoreGrpupCfgV1().f440272h);
                }
                int hashCode = from.hashCode();
                if (hashCode == -449810799 ? from.equals("changeGender") : hashCode == 3273774 ? from.equals("jump") : !(hashCode != 1984503596 || !from.equals("setData"))) {
                    this.clearAfterNotSelected = true;
                }
                URLImageView iconIgv = this.iconIgv;
                Intrinsics.checkNotNullExpressionValue(iconIgv, "iconIgv");
                Context context = this.iconIgv.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "iconIgv.context");
                String str2 = this.data.getStoreGrpupCfgV1().f440269e;
                Intrinsics.checkNotNullExpressionValue(str2, "data.storeGrpupCfgV1.activeIcon");
                Drawable b16 = q.b(R.drawable.h4a);
                Intrinsics.checkNotNullExpressionValue(b16, "getDrawable(R.drawable.z\u2026r_panel_icon_default_4dp)");
                CommonExKt.y(iconIgv, context, str2, R.color.qui_common_icon_allwhite_primary, b16);
                this.hintTxv.setTextColor(this.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String.getContext().getColor(R.color.qui_common_text_allwhite_primary));
                this.rootLayout.setBackgroundResource(R.drawable.f159918i53);
                return;
            }
            this.rootLayout.setBackgroundColor(0);
            if (this.data.getFakeData()) {
                this.iconIgv.setImageResource(this.data.getDefaultResId());
                this.iconIgv.setAlpha(0.7f);
                this.hintTxv.setTextColor(this.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String.getContext().getColor(R.color.qui_common_text_tertiary));
                return;
            }
            URLImageView iconIgv2 = this.iconIgv;
            Intrinsics.checkNotNullExpressionValue(iconIgv2, "iconIgv");
            Context context2 = this.iconIgv.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "iconIgv.context");
            String str3 = this.data.getStoreGrpupCfgV1().f440268d;
            Intrinsics.checkNotNullExpressionValue(str3, "data.storeGrpupCfgV1.icon");
            Drawable b17 = q.b(R.drawable.h4a);
            Intrinsics.checkNotNullExpressionValue(b17, "getDrawable(R.drawable.z\u2026r_panel_icon_default_4dp)");
            CommonExKt.y(iconIgv2, context2, str3, R.color.qui_common_icon_primary, b17);
            this.hintTxv.setTextColor(this.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String.getContext().getColor(R.color.qui_common_text_primary));
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f371592a;

        static {
            int[] iArr = new int[AvatarEngineType.values().length];
            try {
                iArr[AvatarEngineType.UE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AvatarEngineType.FILAMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f371592a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/control/PortalStorePanelControlView$d", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements a.b {

        /* renamed from: d */
        final /* synthetic */ CameraKey f371593d;

        /* renamed from: e */
        final /* synthetic */ j f371594e;

        d(CameraKey cameraKey, j jVar) {
            this.f371593d = cameraKey;
            this.f371594e = jVar;
        }

        public static final void b(j channel, CameraKey currentCameraId) {
            Intrinsics.checkNotNullParameter(channel, "$channel");
            Intrinsics.checkNotNullParameter(currentCameraId, "$currentCameraId");
            channel.getCameraController().w(currentCameraId, "enterAiMakeFace");
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            a.b.C10064a.b(this, success, result);
            if (success && this.f371593d.c()) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final j jVar = this.f371594e;
                final CameraKey cameraKey = this.f371593d;
                uIHandlerV2.post(new Runnable() { // from class: ea4.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        PortalStorePanelControlView.d.b(j.this, cameraKey);
                    }
                });
            }
            QLog.i("PortalStorePanelControlView_", 1, "enterAiMakeFace onLuaResult, success: " + success + ", result:" + result);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelControlView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(List<PortalStoreGroupPanelPageData> list) {
        for (PortalStoreGroupPanelPageData portalStoreGroupPanelPageData : list) {
            String icon = portalStoreGroupPanelPageData.getStoreGrpupCfgV1().f440268d;
            if (icon != null) {
                Intrinsics.checkNotNullExpressionValue(icon, "icon");
                CommonExKt.o(icon, null, null, 3, null);
            }
            String activeIcon = portalStoreGroupPanelPageData.getStoreGrpupCfgV1().f440269e;
            if (activeIcon != null) {
                Intrinsics.checkNotNullExpressionValue(activeIcon, "activeIcon");
                CommonExKt.o(activeIcon, null, null, 3, null);
            }
        }
    }

    private final void B(PortalStoreGroupPanelPageData data) {
        int i3 = 8;
        if (r94.b.m(data.getStoreGrpupCfgV1()) == 2) {
            j jVar = this.mChannel;
            if (jVar == null) {
                return;
            }
            AvatarEngineType type = jVar.getEngineApi().getType();
            this.mBinding.f418967e.setVisibility(0);
            ImageView imageView = this.mBinding.f418964b;
            if (AvatarEngineType.FILAMENT != type || (!QzoneConfig.isNotShowFilamentAI() && ((IZShowFilamentPreviewProvider) QRoute.api(IZShowFilamentPreviewProvider.class)).isSupportFilament())) {
                i3 = 0;
            }
            imageView.setVisibility(i3);
            return;
        }
        this.mBinding.f418967e.setVisibility(8);
    }

    private final void C(String str) {
        int i3 = this.mSelectedPosition;
        if (i3 >= 0 && i3 < this.mDataList.size()) {
            PortalStoreGroupPanelPageData portalStoreGroupPanelPageData = this.mDataList.get(this.mSelectedPosition);
            Intrinsics.checkNotNullExpressionValue(portalStoreGroupPanelPageData, "mDataList[mSelectedPosition]");
            B(portalStoreGroupPanelPageData);
        }
        int i16 = 0;
        for (Object obj : this.mViewList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            b bVar = (b) obj;
            if (Intrinsics.areEqual(bVar.getData().getIndex(), this.mSelectedIndex)) {
                this.currentViewHolder = bVar;
            }
            bVar.h(this.mSelectedIndex, str, this);
            i16 = i17;
        }
    }

    private final void h(int i3, PortalStoreGroupPanelPageData portalStoreGroupPanelPageData) {
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        b j3 = j(i3, portalStoreGroupPanelPageData);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, i.b(32));
        layoutParams.gravity = 16;
        if (i3 == 0) {
            layoutParams.setMarginStart(i.b(2));
        }
        if (i3 == this.mDataList.size() - 1) {
            layoutParams.setMarginEnd(i.b(2));
        }
        this.mBinding.f418965c.addView(j3.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), layoutParams);
        this.mViewList.add(j3);
        j jVar = this.mChannel;
        if (jVar != null && (reporter = jVar.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
            mReporter.g(j3.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "em_zplan_mall_btn", (r16 & 4) != 0 ? null : l(portalStoreGroupPanelPageData), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
        VideoReport.setElementEndExposePolicy(j3.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), EndExposurePolicy.REPORT_ALL);
    }

    private final b j(final int position, final PortalStoreGroupPanelPageData data) {
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.de_, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        final b bVar = new b(position, itemView, data);
        aa.e(bVar.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), new View.OnClickListener() { // from class: ea4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStorePanelControlView.k(PortalStoreGroupPanelPageData.this, this, bVar, position, view);
            }
        }, 100L);
        return bVar;
    }

    public static final void k(PortalStoreGroupPanelPageData data, PortalStorePanelControlView this$0, b itemViewHolder, int i3, View view) {
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        e O;
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemViewHolder, "$itemViewHolder");
        if (data.getFakeData()) {
            return;
        }
        j jVar = this$0.mChannel;
        if (!((jVar == null || (O = jVar.O()) == null) ? false : O.getMPanelHasEnter())) {
            QLog.e("PortalStorePanelControlView_", 1, "panelHasEnter==false, no click can happened!");
            return;
        }
        j jVar2 = this$0.mChannel;
        if (jVar2 != null && (reporter = jVar2.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
            mReporter.e(itemViewHolder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "em_zplan_mall_btn", this$0.l(data));
        }
        String index = data.getIndex();
        this$0.mSelectedIndex = index;
        this$0.mSelectedPosition = i3;
        QLog.i("PortalStorePanelControlView_", 1, "item click controlType:" + index + ", mSelectedPosition:" + i3);
        this$0.C("click");
        Iterator<T> it = this$0.mListenerPool.iterator();
        while (it.hasNext()) {
            ((b94.b) it.next()).T(this$0.mSelectedIndex);
        }
    }

    private final HashMap<String, Object> l(PortalStoreGroupPanelPageData data) {
        Object obj;
        HashMap<String, Object> hashMap = new HashMap<>();
        int i3 = data.getStoreGrpupCfgV1().f440272h;
        gv4.e m3 = ZPlanRedDotManager.m(ZPlanRedDotManager.f373437a, i3, 0, 2, null);
        hashMap.put("zplan_mall_type", Integer.valueOf(data.getStoreGrpupCfgV1().f440266b));
        hashMap.put("zplan_redpoint_id", Integer.valueOf(i3));
        if (m3 != null) {
            obj = Integer.valueOf(m3.f403426b);
        } else {
            obj = "0";
        }
        hashMap.put("zplan_redpoint_type", obj);
        return hashMap;
    }

    private final void n() {
        CameraKey cameraKey;
        j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        boolean z16 = jVar.getEngineApi().getType() == AvatarEngineType.UE;
        if (z16 && !u.a.a(jVar.getUeStatusController(), false, 1, null)) {
            jVar.getEngineApi().e(new am(), null, null, jVar.getReporter().getMSource());
            return;
        }
        ZplanViewReportHelper mReporter = jVar.getReporter().getMReporter();
        ImageView imageView = this.mBinding.f418964b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.aiMakeFaceIgv");
        ZplanViewReportHelper.f(mReporter, imageView, "em_zplan_ai_sculpt", null, 4, null);
        j94.a aVar = j94.a.f409675a;
        am a16 = aVar.a();
        if (z16 && a16 == null) {
            QLog.e("PortalStorePanelControlView_", 1, "AiFaceCameraConfig is null");
            return;
        }
        e O = jVar.O();
        if (O == null || (cameraKey = O.getCameraId()) == null) {
            cameraKey = new CameraKey(0, 0, 2, null);
        }
        am b16 = aVar.b(cameraKey);
        d dVar = new d(cameraKey, jVar);
        b94.a engineApi = jVar.getEngineApi();
        if (a16 == null) {
            a16 = new am();
        }
        a.C0113a.b(engineApi, a16, b16, dVar, null, 8, null);
    }

    private final void p(List<az> items) {
        QLog.i("PortalStorePanelControlView_", 1, "handleAiMakeFaceDressTask items:" + r94.c.y(items));
        j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        e O = jVar.O();
        if (O != null) {
            O.Ya("handleAiMakeFaceDressTask", true, false);
        }
        jVar.a().addAll(r94.b.h(items));
        b94.d avatarDressController = jVar.getAvatarDressController();
        if (avatarDressController != null) {
            d.a.d(avatarDressController, items, null, null, DressTaskExtInfo.AI_MAKE_FACE, 6, null);
        }
    }

    private final void r() {
        final j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        z94.c.f452180e.b(this);
        ZplanViewReportHelper mReporter = jVar.getReporter().getMReporter();
        ImageView imageView = this.mBinding.f418964b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.aiMakeFaceIgv");
        mReporter.g(imageView, "em_zplan_ai_sculpt", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        VideoReport.setElementEndExposePolicy(this.mBinding.f418964b, EndExposurePolicy.REPORT_ALL);
        this.mBinding.f418964b.setImageDrawable(ie0.a.f().o(getContext(), R.drawable.idz, R.color.qui_common_icon_primary, 1000));
        ImageView imageView2 = this.mBinding.f418964b;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.aiMakeFaceIgv");
        aa.d(imageView2, new View.OnClickListener() { // from class: ea4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStorePanelControlView.s(j.this, this, view);
            }
        });
    }

    public static final void s(j channel, PortalStorePanelControlView this$0, View view) {
        Intrinsics.checkNotNullParameter(channel, "$channel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a84.a sceneComponentAvatar = channel.getSceneComponentAvatar();
        if (sceneComponentAvatar != null) {
            sceneComponentAvatar.N0();
        }
        com.tencent.sqshow.zootopia.recommend.characterV2.component.a sceneComponentAvatarV2 = channel.getSceneComponentAvatarV2();
        if (sceneComponentAvatarV2 != null) {
            sceneComponentAvatarV2.N0();
        }
        this$0.n();
    }

    private final void t() {
        final j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        ZplanViewReportHelper mReporter = jVar.getReporter().getMReporter();
        ImageView imageView = this.mBinding.f418966d;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.makeFaceIgv");
        mReporter.g(imageView, "em_zplan_sculpt", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        VideoReport.setElementEndExposePolicy(this.mBinding.f418966d, EndExposurePolicy.REPORT_ALL);
        this.mBinding.f418966d.setImageDrawable(ie0.a.f().o(getContext(), R.drawable.ie_, R.color.qui_common_icon_primary, 1000));
        ImageView imageView2 = this.mBinding.f418966d;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.makeFaceIgv");
        aa.d(imageView2, new View.OnClickListener() { // from class: ea4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStorePanelControlView.u(PortalStorePanelControlView.this, jVar, view);
            }
        });
    }

    public static final void u(PortalStorePanelControlView this$0, j panelChannel, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(panelChannel, "$panelChannel");
        j jVar = this$0.mChannel;
        if (jVar == null) {
            return;
        }
        b94.a engineApi = jVar.getEngineApi();
        ZplanViewReportHelper mReporter = panelChannel.getReporter().getMReporter();
        ImageView imageView = this$0.mBinding.f418966d;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.makeFaceIgv");
        ZplanViewReportHelper.f(mReporter, imageView, "em_zplan_sculpt", null, 4, null);
        int i3 = c.f371592a[engineApi.getType().ordinal()];
        if (i3 == 1) {
            if (u.a.a(jVar.getUeStatusController(), false, 1, null)) {
                this$0.o(panelChannel);
                return;
            }
            return;
        }
        if (i3 != 2) {
            return;
        }
        this$0.lastAvatarCharacter = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.k();
        Bundle bundle = new Bundle();
        bundle.putBoolean("onlyMakeupMode", true);
        QRouteApi api = QRoute.api(ISchemeApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ISchemeApi::class.java)");
        ISchemeApi iSchemeApi = (ISchemeApi) api;
        ZootopiaSource a16 = ah.a(panelChannel.getReporter().getMSource());
        if (a16 == null) {
            a16 = ZootopiaSource.INSTANCE.g();
        }
        String buildMakeUpPageScheme = iSchemeApi.buildMakeUpPageScheme(a16, bundle);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, buildMakeUpPageScheme);
    }

    private final void v() {
        this.mViewList.clear();
        this.mBinding.f418965c.removeAllViews();
        int size = this.mDataList.size();
        if (size <= 0) {
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            PortalStoreGroupPanelPageData portalStoreGroupPanelPageData = this.mDataList.get(i3);
            Intrinsics.checkNotNullExpressionValue(portalStoreGroupPanelPageData, "mDataList[i]");
            h(i3, portalStoreGroupPanelPageData);
        }
        t();
        r();
    }

    public static final void y(PortalStorePanelControlView this$0, List items) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(items, "$items");
        this$0.p(items);
    }

    @Override // z94.a
    public void c(FaceInfoSyncData faceInfoSyncData) {
        a.C11666a.a(this, faceInfoSyncData);
    }

    @Override // z94.a
    public void d(FinishAIMakeFaceData data) {
        byte[] bArr;
        final List list;
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("PortalStorePanelControlView_", 1, "onFinishAiMakeFace data:" + data);
        if (data.getResult() == 0) {
            try {
                bArr = Base64.decode(data.getItemsBase64(), 2);
            } catch (Exception e16) {
                QLog.e("PortalStorePanelControlView_", 1, "onFinishAiMakeFace Base64 error", e16);
                bArr = null;
            }
            if (bArr == null) {
                return;
            }
            al alVar = new al();
            MessageNano.mergeFrom(alVar, bArr);
            az[] azVarArr = alVar.f440153b;
            Intrinsics.checkNotNullExpressionValue(azVarArr, "storeAvatarInfo.items");
            list = ArraysKt___ArraysKt.toList(azVarArr);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ea4.c
                @Override // java.lang.Runnable
                public final void run() {
                    PortalStorePanelControlView.y(PortalStorePanelControlView.this, list);
                }
            });
        }
    }

    public final void i(b94.b l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListenerPool.add(l3);
    }

    public final void m() {
        z94.c.f452180e.c(this);
    }

    public final void o(j panelChannel) {
        g a16;
        Intrinsics.checkNotNullParameter(panelChannel, "panelChannel");
        ga4.j jVar = ga4.j.f401682a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        a16 = jVar.a(16, panelChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : true);
        a16.show();
    }

    public final void q(j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.mChannel = channel;
    }

    public final void setData(List<PortalStoreGroupPanelPageData> data, String defaultIndex, boolean isFromChangeGender, boolean isFakeData) {
        Object obj;
        Object obj2;
        int indexOf;
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(defaultIndex, "defaultIndex");
        A(data);
        Iterator<T> it = data.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            } else {
                obj2 = it.next();
                if (Intrinsics.areEqual(((PortalStoreGroupPanelPageData) obj2).getIndex(), defaultIndex)) {
                    break;
                }
            }
        }
        this.mSelectedIndex = obj2 != null ? defaultIndex : "";
        Iterator<T> it5 = this.mDataList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (Intrinsics.areEqual(((PortalStoreGroupPanelPageData) next).getIndex(), defaultIndex)) {
                obj = next;
                break;
            }
        }
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends PortalStoreGroupPanelPageData>) ((List<? extends Object>) this.mDataList), (PortalStoreGroupPanelPageData) obj);
        this.mSelectedPosition = indexOf;
        QLog.i("PortalStorePanelControlView_", 1, "setData controlType:" + this.mSelectedIndex + ", mSelectedPosition:" + indexOf + ", isFromChangeGender: " + isFromChangeGender);
        this.mDataList.clear();
        this.mDataList.addAll(data);
        v();
        if (isFromChangeGender) {
            str = "changeGender";
        } else {
            str = "setData";
        }
        if (isFakeData) {
            str = "fakeData";
        }
        C(str);
        if (Intrinsics.areEqual(this.mSelectedIndex, "")) {
            return;
        }
        Iterator<T> it6 = this.mListenerPool.iterator();
        while (it6.hasNext()) {
            ((b94.b) it6.next()).T(this.mSelectedIndex);
        }
    }

    public final void setSelectIndex(String selectedIndex, String from) {
        Object obj;
        int indexOf;
        Intrinsics.checkNotNullParameter(selectedIndex, "selectedIndex");
        Intrinsics.checkNotNullParameter(from, "from");
        this.mSelectedIndex = selectedIndex;
        Iterator<T> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((PortalStoreGroupPanelPageData) obj).getIndex(), this.mSelectedIndex)) {
                    break;
                }
            }
        }
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends PortalStoreGroupPanelPageData>) ((List<? extends Object>) this.mDataList), (PortalStoreGroupPanelPageData) obj);
        this.mSelectedPosition = indexOf;
        QLog.i("PortalStorePanelControlView_", 1, "setSelectType controlType:" + selectedIndex + ", mSelectedPosition:" + indexOf);
        C(from);
    }

    public final void z() {
        b94.d avatarDressController;
        qu4.a k3 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.k();
        qu4.a aVar = this.lastAvatarCharacter;
        if (aVar == null || r94.a.c(k3, aVar)) {
            return;
        }
        this.lastAvatarCharacter = k3;
        j jVar = this.mChannel;
        if (jVar == null || (avatarDressController = jVar.getAvatarDressController()) == null) {
            return;
        }
        d.a.h(avatarDressController, null, false, true, 3, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void w() {
        this.isViewShow = false;
        b bVar = this.currentViewHolder;
        Integer valueOf = bVar != null ? Integer.valueOf(bVar.getRedDotId()) : null;
        b bVar2 = this.currentViewHolder;
        QLog.i("PortalStorePanelControlView_", 1, "notifyViewHide, id:" + valueOf + ", clearAfterNotSelected: " + (bVar2 != null ? Boolean.valueOf(bVar2.getClearAfterNotSelected()) : null));
        b bVar3 = this.currentViewHolder;
        if (bVar3 != null) {
            bVar3.a();
        }
    }

    public final void x() {
        this.isViewShow = true;
    }

    public /* synthetic */ PortalStorePanelControlView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelControlView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSelectedIndex = "";
        this.mSelectedPosition = -1;
        ca f16 = ca.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mListenerPool = new HashSet<>();
        this.mDataList = new ArrayList<>();
        this.mViewList = new ArrayList<>();
        setClipChildren(false);
    }

    public static /* synthetic */ void setData$default(PortalStorePanelControlView portalStorePanelControlView, List list, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        portalStorePanelControlView.setData(list, str, z16, z17);
    }
}
