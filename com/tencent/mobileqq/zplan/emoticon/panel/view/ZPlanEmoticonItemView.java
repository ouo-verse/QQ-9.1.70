package com.tencent.mobileqq.zplan.emoticon.panel.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.ZPlanPicExtraData;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.emoticon.ZPlanEmoticonInfo;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.emoticon.panel.view.util.DelayedLongClickHelper;
import com.tencent.mobileqq.zplan.emoticon.report.ZPlanEmoticonReport;
import com.tencent.mobileqq.zplan.message.ZPlanSessionInfo;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.record.model.Source;
import cooperation.qzone.QZoneClickReport;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;
import nh3.ZPlanEmoticonReportData;
import t74.r;
import tl.h;

@Metadata(d1 = {"\u0000\u00b1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b*\u0001S\u0018\u0000 c2\u00020\u0001:\u0002deBO\u0012\u0006\u0010Z\u001a\u00020Y\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010[\u0012\b\b\u0002\u0010]\u001a\u00020\u000e\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u0010*\u001a\u00020!\u0012\b\u0010.\u001a\u0004\u0018\u00010+\u0012\u0006\u0010\u0016\u001a\u00020/\u00a2\u0006\u0004\b`\u0010aB;\b\u0016\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u0010*\u001a\u00020!\u0012\b\u0010.\u001a\u0004\u0018\u00010+\u0012\u0006\u0010\u0016\u001a\u00020/\u00a2\u0006\u0004\b`\u0010bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J4\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00042\u001a\u0010\u0016\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u0015H\u0002J$\u0010\u001d\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H\u0002R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010\u0016\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010:\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\bR\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010DR\u0014\u0010G\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010FR\u0016\u0010I\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010\bR\u0016\u0010J\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010DR\"\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010LR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020O0N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u0004\u0018\u00010\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bW\u0010=\u00a8\u0006f"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanEmoticonItemView;", "Landroid/widget/LinearLayout;", "", "performClick", "", "recordPath", "", "J", "I", "B", "Lcom/tencent/mobileqq/zplan/model/e;", "data", UserInfo.SEX_FEMALE, "E", "", "loadingType", "Lnh3/b;", "reportData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "actionInfo", "selfUin", "Lkotlin/Function2;", "callback", "t", "url", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "options", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zplan/message/c;", "zPlanSessionInfo", "G", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "aioRoot", "e", "Lcom/tencent/mobileqq/zplan/message/c;", "sessionInfo", "Lmh3/b;", "f", "Lmh3/b;", "zPlanEmotionReportManager", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", h.F, "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "name", "<set-?>", "Lkotlin/properties/ReadWriteProperty;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/zplan/model/e;", "setData", "(Lcom/tencent/mobileqq/zplan/model/e;)V", "defaultDrawableColor", "Landroid/graphics/drawable/GradientDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "defaultDrawable", "Ljava/lang/String;", "localIconPath", "Z", "isNightTheme", "H", "emotionStatus", "recorderType", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "loadingType2Status", "Lkotlin/Lazy;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/view/util/DelayedLongClickHelper;", "K", "Lkotlin/Lazy;", "longClickHelper", "com/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanEmoticonItemView$d", "L", "Lcom/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanEmoticonItemView$d;", "touchListener", "w", "currentData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "", "itemWidth", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/view/ViewGroup;FLcom/tencent/mobileqq/zplan/message/c;Lmh3/b;Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;)V", "(Landroid/content/Context;Landroid/view/ViewGroup;FLcom/tencent/mobileqq/zplan/message/c;Lmh3/b;Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;)V", "M", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonItemView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final ReadWriteProperty data;

    /* renamed from: D, reason: from kotlin metadata */
    private final int defaultDrawableColor;

    /* renamed from: E, reason: from kotlin metadata */
    private final GradientDrawable defaultDrawable;

    /* renamed from: F, reason: from kotlin metadata */
    private String localIconPath;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isNightTheme;

    /* renamed from: H, reason: from kotlin metadata */
    private int emotionStatus;

    /* renamed from: I, reason: from kotlin metadata */
    private volatile String recorderType;

    /* renamed from: J, reason: from kotlin metadata */
    private ConcurrentHashMap<Integer, Boolean> loadingType2Status;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy<DelayedLongClickHelper> longClickHelper;

    /* renamed from: L, reason: from kotlin metadata */
    private final d touchListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup aioRoot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ZPlanSessionInfo sessionInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final mh3.b zPlanEmotionReportManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final EmoticonCallback callback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ImageView icon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView name;
    static final /* synthetic */ KProperty<Object>[] N = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ZPlanEmoticonItemView.class, "data", "getData()Lcom/tencent/mobileqq/zplan/model/ZPlanActionInfo;", 0))};

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanEmoticonItemView$b;", "Ljh3/b;", "", "success", "", "path", "Lnh3/b;", "reportData", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanEmoticonItemView;", "Lmqq/util/WeakReference;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/zplan/model/e;", "b", "Lcom/tencent/mobileqq/zplan/model/e;", "data", "<init>", "(Lmqq/util/WeakReference;Lcom/tencent/mobileqq/zplan/model/e;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements jh3.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZPlanEmoticonItemView> item;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final ZPlanActionInfo data;

        public b(WeakReference<ZPlanEmoticonItemView> item, ZPlanActionInfo data) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(data, "data");
            this.item = item;
            this.data = data;
        }

        @Override // jh3.b
        public void a(boolean success, String path, ZPlanEmoticonReportData reportData, MODE mode) {
            ZPlanActionInfo w3;
            Intrinsics.checkNotNullParameter(reportData, "reportData");
            Intrinsics.checkNotNullParameter(mode, "mode");
            ZPlanEmoticonItemView zPlanEmoticonItemView = this.item.get();
            if (zPlanEmoticonItemView == null || (w3 = zPlanEmoticonItemView.w()) == null) {
                return;
            }
            QLog.i("[zplan][ZPlanEmoticonItemView]", 1, "onGetCoverAndGifResource, success: " + success + ", path:" + path + ", currentData:" + w3);
            if (success && w3.getId() == this.data.getId()) {
                zPlanEmoticonItemView.recorderType = reportData.getRecorderType();
                if (mode == MODE.FRAME) {
                    zPlanEmoticonItemView.J(path);
                    zPlanEmoticonItemView.A(0, this.data, reportData);
                } else {
                    zPlanEmoticonItemView.A(1, this.data, reportData);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends ObservableProperty<ZPlanActionInfo> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanEmoticonItemView f333275b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Object obj, ZPlanEmoticonItemView zPlanEmoticonItemView) {
            super(obj);
            this.f333275b = zPlanEmoticonItemView;
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(KProperty<?> property, ZPlanActionInfo oldValue, ZPlanActionInfo newValue) {
            Intrinsics.checkNotNullParameter(property, "property");
            ZPlanActionInfo zPlanActionInfo = newValue;
            ZPlanEmoticonItemView zPlanEmoticonItemView = this.f333275b;
            Intrinsics.checkNotNull(zPlanActionInfo);
            zPlanEmoticonItemView.F(zPlanActionInfo);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonItemView(final Context context, AttributeSet attributeSet, int i3, ViewGroup aioRoot, float f16, ZPlanSessionInfo sessionInfo, mh3.b bVar, EmoticonCallback callback) {
        super(context, attributeSet, i3);
        Lazy<DelayedLongClickHelper> lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioRoot, "aioRoot");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.aioRoot = aioRoot;
        this.sessionInfo = sessionInfo;
        this.zPlanEmotionReportManager = bVar;
        this.callback = callback;
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.icon = imageView;
        TextView textView = new TextView(context);
        textView.setMaxLines(1);
        this.name = textView;
        Delegates delegates = Delegates.INSTANCE;
        this.data = new c(null, this);
        int color = getResources().getColor(R.color.qui_common_overlay_light, null);
        this.defaultDrawableColor = color;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ViewUtils.dip2px(2.0f));
        gradientDrawable.setColor(color);
        this.defaultDrawable = gradientDrawable;
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        this.isNightTheme = isNowThemeIsNight;
        this.emotionStatus = 1;
        this.recorderType = Source.LOCAL_CACHE.name();
        this.loadingType2Status = new ConcurrentHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DelayedLongClickHelper>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.view.ZPlanEmoticonItemView$longClickHelper$1

            @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanEmoticonItemView$longClickHelper$1$a", "Lcom/tencent/mobileqq/zplan/emoticon/panel/view/util/DelayedLongClickHelper$a;", "", "a", "d", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanPopupView;", "b", "Lcom/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanPopupView;", "popupView", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements DelayedLongClickHelper.a {

                /* renamed from: a, reason: collision with root package name and from kotlin metadata */
                private Drawable drawable;

                /* renamed from: b, reason: collision with root package name and from kotlin metadata */
                private ZPlanPopupView popupView;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ ZPlanEmoticonItemView f333279c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f333280d;

                a(ZPlanEmoticonItemView zPlanEmoticonItemView, Context context) {
                    this.f333279c = zPlanEmoticonItemView;
                    this.f333280d = context;
                }

                @Override // com.tencent.mobileqq.zplan.emoticon.panel.view.util.DelayedLongClickHelper.a
                public void a() {
                    Drawable z16;
                    ViewGroup viewGroup;
                    z16 = this.f333279c.z();
                    if (z16 == null) {
                        return;
                    }
                    this.drawable = z16;
                    if (this.popupView == null) {
                        Context context = this.f333279c.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                        this.popupView = new ZPlanPopupView(context, null, 0, 6, null);
                    }
                    ZPlanPopupView zPlanPopupView = this.popupView;
                    if (zPlanPopupView != null) {
                        ZPlanEmoticonItemView zPlanEmoticonItemView = this.f333279c;
                        zPlanPopupView.setImageDrawable(z16);
                        viewGroup = zPlanEmoticonItemView.aioRoot;
                        zPlanPopupView.c(viewGroup, zPlanEmoticonItemView);
                    }
                }

                @Override // com.tencent.mobileqq.zplan.emoticon.panel.view.util.DelayedLongClickHelper.a
                public void d() {
                    if (this.drawable == null) {
                        return;
                    }
                    this.drawable = null;
                    ZPlanPopupView zPlanPopupView = this.popupView;
                    if (zPlanPopupView != null) {
                        zPlanPopupView.setImageDrawable(null);
                        zPlanPopupView.b();
                    }
                    this.popupView = null;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DelayedLongClickHelper invoke() {
                DelayedLongClickHelper delayedLongClickHelper = new DelayedLongClickHelper();
                delayedLongClickHelper.c(new a(ZPlanEmoticonItemView.this, context));
                return delayedLongClickHelper;
            }
        });
        this.longClickHelper = lazy;
        d dVar = new d();
        this.touchListener = dVar;
        setFocusable(true);
        setOrientation(1);
        setOnTouchListener(dVar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(f16), ViewUtils.dip2px(f16));
        layoutParams.gravity = 1;
        addView(imageView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = ViewUtils.dip2px(6.0f);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(ie0.a.f().g(context, R.color.qui_common_text_secondary, isNowThemeIsNight ? 1002 : 1001));
        addView(textView, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(int loadingType, ZPlanActionInfo data, ZPlanEmoticonReportData reportData) {
        mh3.b bVar;
        Integer valueOf = Integer.valueOf(loadingType);
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.loadingType2Status;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put(valueOf, bool);
        if (!Intrinsics.areEqual(this.loadingType2Status.get(0), bool)) {
            String str = this.localIconPath;
            if (str == null || str.length() == 0) {
                return;
            }
        }
        if (!Intrinsics.areEqual(this.loadingType2Status.get(1), bool) || (bVar = this.zPlanEmotionReportManager) == null) {
            return;
        }
        bVar.c(data.getId(), reportData);
    }

    private final void B() {
        if (x() == null) {
            return;
        }
        int sessionType = this.sessionInfo.getSessionType();
        int i3 = sessionType != 1 ? sessionType != 3000 ? 0 : 11 : 3;
        Intent intent = new Intent();
        intent.putExtra("troop_uin", this.sessionInfo.getTroopUin());
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, i3);
        intent.putExtra("param_is_pop_up_style", true);
        intent.putExtra("param_troop_send_zplan_msg", true);
        RouteUtils.startActivityForResult(getContext(), intent, "/troop/memberlist/TroopMemberList", 6001);
    }

    private final boolean C(ZPlanActionInfo actionInfo) {
        return actionInfo.getPlayerNumber() > 1;
    }

    private final boolean D() {
        ZPlanActionInfo x16 = x();
        return x16 != null && this.sessionInfo.getIsTroop() && C(x16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(ZPlanActionInfo data) {
        com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.m(data, this.sessionInfo.getSelfUin(), Priority.HIGH, new b(new WeakReference(this), data));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(ZPlanActionInfo data) {
        this.name.setText(data.getName());
        setContentDescription(data.getName());
        t(data, this.sessionInfo.getSelfUin(), new ZPlanEmoticonItemView$refreshView$1(this, data));
    }

    private final void G(final ZPlanActionInfo actionInfo, final ZPlanSessionInfo zPlanSessionInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.view.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEmoticonItemView.H(ZPlanActionInfo.this, zPlanSessionInfo);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ZPlanActionInfo actionInfo, ZPlanSessionInfo zPlanSessionInfo) {
        boolean F;
        boolean G;
        Intrinsics.checkNotNullParameter(actionInfo, "$actionInfo");
        Intrinsics.checkNotNullParameter(zPlanSessionInfo, "$zPlanSessionInfo");
        if (actionInfo.getOriginType() == 100) {
            F = com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.i(actionInfo, zPlanSessionInfo.getSelfUin());
        } else {
            F = ZPlanEmoticonUtil.f333176e.F(actionInfo, zPlanSessionInfo.getSelfUin());
        }
        boolean z16 = F;
        if (actionInfo.getOriginType() == 100) {
            G = com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.j(actionInfo, zPlanSessionInfo.getSelfUin());
        } else {
            G = ZPlanEmoticonUtil.f333176e.G(actionInfo, zPlanSessionInfo.getSelfUin());
        }
        ZPlanEmoticonReport.f333324a.l(actionInfo.getId(), zPlanSessionInfo.getIsTroop(), actionInfo.getPlayerNumber(), z16, G);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void I() {
        int i3;
        ZPlanUserInfo userInfo;
        String str;
        Object obj;
        String str2;
        String str3;
        mh3.b bVar;
        Object obj2;
        String isFirstEnter;
        ZPlanActionInfo x16 = x();
        if (x16 == null) {
            return;
        }
        ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
        String A = zPlanEmoticonUtil.A(x16, this.sessionInfo.getSelfUin());
        HashMap hashMap = new HashMap();
        boolean z16 = false;
        if (this.emotionStatus == 3) {
            if (!(A == null || A.length() == 0)) {
                i3 = 4;
                this.emotionStatus = i3;
                mh3.b bVar2 = this.zPlanEmotionReportManager;
                String appearanceKey = bVar2 == null ? bVar2.getAppearanceKey() : null;
                mh3.b bVar3 = this.zPlanEmotionReportManager;
                userInfo = bVar3 == null ? bVar3.getUserInfo() : null;
                hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                hashMap.put("zplan_action_type", "click");
                hashMap.put("zplan_emote_id", String.valueOf(x16.getId()));
                hashMap.put("zplan_emote_name", String.valueOf(x16.getName()));
                if (x16.getPic2DMode() != MODE.GIF) {
                    str = "gif";
                } else {
                    str = "sharpp";
                }
                hashMap.put("zplan_emote_type", str);
                if (!(A != null || A.length() == 0)) {
                    obj = "0";
                } else {
                    obj = "1";
                }
                hashMap.put("zplan_if_success", obj);
                hashMap.put("zplan_emote_position", String.valueOf(x16.getPosition()));
                str2 = "2";
                if (PadUtil.a(getContext()) != DeviceType.TABLET) {
                    str3 = "3";
                } else if (!bb.f335811a.p()) {
                    str3 = "1";
                } else {
                    str3 = "2";
                }
                hashMap.put("zplan_user_screen_type", str3);
                hashMap.put("zplan_click_emote_situation", String.valueOf(this.emotionStatus));
                mh3.b bVar4 = this.zPlanEmotionReportManager;
                hashMap.put("zplan_emote_record_type", String.valueOf(bVar4 != null ? Integer.valueOf(bVar4.p(this.recorderType)) : null));
                bVar = this.zPlanEmotionReportManager;
                if (bVar != null && (isFirstEnter = bVar.getIsFirstEnter()) != null) {
                    str2 = isFirstEnter;
                }
                hashMap.put("zplan_is_the_first_time_enter", str2);
                hashMap.put("zplan_dress_up_key", appearanceKey);
                if (userInfo != null && userInfo.hasCustomDressUp()) {
                    z16 = true;
                }
                if (z16) {
                    obj2 = "0";
                } else {
                    obj2 = "1";
                }
                hashMap.put("zplan_is_dress_up_user", obj2);
                hashMap.put("zplan_emote_source", "1");
                hashMap.put("plan_emote_single_emote_loading_time", "0");
                hashMap.put("zplan_emote_page_from", zPlanEmoticonUtil.E());
                hashMap.put("zplan_emote_scene_type", QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
                VideoReport.reportEvent("ev_zplan_emote_click", hashMap);
            }
        }
        i3 = this.emotionStatus;
        this.emotionStatus = i3;
        mh3.b bVar22 = this.zPlanEmotionReportManager;
        if (bVar22 == null) {
        }
        mh3.b bVar32 = this.zPlanEmotionReportManager;
        if (bVar32 == null) {
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_action_type", "click");
        hashMap.put("zplan_emote_id", String.valueOf(x16.getId()));
        hashMap.put("zplan_emote_name", String.valueOf(x16.getName()));
        if (x16.getPic2DMode() != MODE.GIF) {
        }
        hashMap.put("zplan_emote_type", str);
        if (!(A != null || A.length() == 0)) {
        }
        hashMap.put("zplan_if_success", obj);
        hashMap.put("zplan_emote_position", String.valueOf(x16.getPosition()));
        str2 = "2";
        if (PadUtil.a(getContext()) != DeviceType.TABLET) {
        }
        hashMap.put("zplan_user_screen_type", str3);
        hashMap.put("zplan_click_emote_situation", String.valueOf(this.emotionStatus));
        mh3.b bVar42 = this.zPlanEmotionReportManager;
        hashMap.put("zplan_emote_record_type", String.valueOf(bVar42 != null ? Integer.valueOf(bVar42.p(this.recorderType)) : null));
        bVar = this.zPlanEmotionReportManager;
        if (bVar != null) {
            str2 = isFirstEnter;
        }
        hashMap.put("zplan_is_the_first_time_enter", str2);
        hashMap.put("zplan_dress_up_key", appearanceKey);
        if (userInfo != null) {
            z16 = true;
        }
        if (z16) {
        }
        hashMap.put("zplan_is_dress_up_user", obj2);
        hashMap.put("zplan_emote_source", "1");
        hashMap.put("plan_emote_single_emote_loading_time", "0");
        hashMap.put("zplan_emote_page_from", zPlanEmoticonUtil.E());
        hashMap.put("zplan_emote_scene_type", QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
        VideoReport.reportEvent("ev_zplan_emote_click", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(String recordPath) {
        boolean equals$default;
        String str = this.localIconPath;
        if (str != null) {
            equals$default = StringsKt__StringsJVMKt.equals$default(str, recordPath, false, 2, null);
            if (equals$default) {
                QLog.w("[zplan][ZPlanEmoticonItemView]", 1, "localIconPath:" + this.localIconPath + " == recordPath:" + recordPath + ", return!!");
                return;
            }
        }
        QLog.i("[zplan][ZPlanEmoticonItemView]", 1, "show icon from:" + this.localIconPath + " to:" + recordPath);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = this.icon.getDrawable();
        obtain.mFailedDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        final URLDrawable fileDrawable = URLDrawable.getFileDrawable(recordPath, obtain);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.view.d
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEmoticonItemView.K(ZPlanEmoticonItemView.this, fileDrawable);
            }
        });
        this.localIconPath = recordPath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(ZPlanEmoticonItemView this$0, URLDrawable uRLDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.emotionStatus = 3;
        this$0.icon.setImageDrawable(uRLDrawable);
    }

    private final void t(final ZPlanActionInfo actionInfo, final String selfUin, final Function2<? super String, ? super Integer, Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.view.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEmoticonItemView.u(ZPlanEmoticonItemView.this, actionInfo, selfUin, callback);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ZPlanEmoticonItemView this$0, final ZPlanActionInfo actionInfo, String selfUin, final Function2 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionInfo, "$actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "$selfUin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ZPlanActionInfo x16 = this$0.x();
        final String str = null;
        Integer valueOf = x16 != null ? Integer.valueOf(x16.getOriginType()) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            str = ZPlanEmoticonUtil.f333176e.w(actionInfo, selfUin);
        } else if (valueOf != null && valueOf.intValue() == 100) {
            str = com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.d(actionInfo, selfUin);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.view.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEmoticonItemView.v(Function2.this, str, actionInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function2 callback, String str, ZPlanActionInfo actionInfo) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(actionInfo, "$actionInfo");
        callback.invoke(str, Integer.valueOf(actionInfo.getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZPlanActionInfo w() {
        return x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable y(String url, URLDrawable.URLDrawableOptions options) {
        if (!bb.f335811a.q(url)) {
            return this.defaultDrawable;
        }
        this.emotionStatus = 2;
        return URLDrawable.getDrawable(url, options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable z() {
        ZPlanActionInfo x16 = x();
        if (x16 == null) {
            return null;
        }
        String selfUin = this.sessionInfo.getSelfUin();
        String friendUin = this.sessionInfo.getFriendUin();
        ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
        String A = zPlanEmoticonUtil.A(x16, selfUin);
        if (A == null) {
            ZPlanEmoticonUtil.U(zPlanEmoticonUtil, x16, selfUin, Priority.HIGH, null, 8, null);
            QLog.i("[zplan][ZPlanEmoticonItemView]", 1, "pic file null, do record action.");
            return null;
        }
        QLog.i("[zplan][ZPlanEmoticonItemView]", 1, "senderUin: " + selfUin + ", receiverUin: " + friendUin + " filePath: " + A);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        GradientDrawable gradientDrawable = this.defaultDrawable;
        obtain.mLoadingDrawable = gradientDrawable;
        obtain.mFailedDrawable = gradientDrawable;
        if (x16.getPic2DMode() == MODE.GIF) {
            obtain.mPlayGifImage = true;
            Bundle bundle = new Bundle();
            bundle.putInt(AbstractGifImage.KEY_REFRESH_DELAY, 0);
            obtain.mExtraInfo = bundle;
        } else {
            obtain.mUseSharpPAnimImage = true;
        }
        return URLDrawable.getFileDrawable(A, obtain);
    }

    public final void setData(ZPlanActionInfo zPlanActionInfo) {
        this.data.setValue(this, N[0], zPlanActionInfo);
    }

    public final ZPlanActionInfo x() {
        return (ZPlanActionInfo) this.data.getValue(this, N[0]);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanEmoticonItemView$d", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v3, MotionEvent event) {
            if (event == null) {
                return false;
            }
            ZPlanEmoticonItemView zPlanEmoticonItemView = ZPlanEmoticonItemView.this;
            int action = event.getAction();
            if (action == 0) {
                ((DelayedLongClickHelper) zPlanEmoticonItemView.longClickHelper.getValue()).b(zPlanEmoticonItemView, 400L);
                return true;
            }
            if (action != 1) {
                if (action != 3) {
                    return false;
                }
                if (zPlanEmoticonItemView.longClickHelper.isInitialized()) {
                    ((DelayedLongClickHelper) zPlanEmoticonItemView.longClickHelper.getValue()).e();
                }
                return true;
            }
            if (zPlanEmoticonItemView.longClickHelper.isInitialized()) {
                if (((DelayedLongClickHelper) zPlanEmoticonItemView.longClickHelper.getValue()).e()) {
                    return zPlanEmoticonItemView.performClick();
                }
                return true;
            }
            return zPlanEmoticonItemView.performClick();
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        ZPlanActionInfo x16 = x();
        if (x16 == null) {
            return false;
        }
        QLog.i("[zplan][ZPlanEmoticonItemView]", 1, "onClick, data:" + x16);
        G(x16, this.sessionInfo);
        if (TextUtils.isEmpty(this.localIconPath) && ZPlanFeatureSwitch.f369852a.m3()) {
            if (!kh3.d.f412402a.c()) {
                QQToast.makeText(getContext(), 1, R.string.xja, 0).show();
            } else {
                QQToast.makeText(getContext(), R.string.xj_, 0).show();
            }
            ZPlanEmoticonUtil.O(ZPlanEmoticonUtil.f333176e, x16, this.sessionInfo.getSelfUin(), Priority.HIGH, null, 8, null);
            return false;
        }
        if (D()) {
            B();
        } else {
            String A = ZPlanEmoticonUtil.f333176e.A(x16, this.sessionInfo.getSelfUin());
            if (!TextUtils.isEmpty(A)) {
                ZPlanPicExtraData zPlanPicExtraData = new ZPlanPicExtraData(x16.getId(), x16.getName(), x16.getPlayerNumber(), x16.getOriginType(), 0L, null, null, x16.getWidth(), x16.getHeight(), 112, null);
                Intrinsics.checkNotNull(A);
                ZPlanEmoticonInfo zPlanEmoticonInfo = new ZPlanEmoticonInfo(A, this.sessionInfo.getSessionType(), this.sessionInfo.getSelfUin(), this.sessionInfo.getFriendUin(), this.sessionInfo.getTroopUin(), x16.getId(), x16.getName(), x16.getOriginType(), x16.getPlayerNumber(), x16.getWidth(), x16.getHeight(), zPlanPicExtraData);
                QLog.i("[zplan][ZPlanEmoticonItemView]", 1, "sendZPlanGifMessage,callback : " + this.callback + ", emoticonInfo: " + zPlanEmoticonInfo.getEmoticonOrActionName());
                this.callback.send(zPlanEmoticonInfo);
            }
            I();
            if (TextUtils.isEmpty(A)) {
                QLog.w("[zplan][ZPlanMessageUtil]", 1, "sendZPlanGifMessage, picPath is null");
                E(x16);
            }
        }
        r.c("aio", "emojicmtab", "clicksticker", new rj3.a().b(this.sessionInfo.getSessionType()).e(2).k(x16.getOriginType()).c(String.valueOf(x16.getId())).h(x16.getPlayerNumber()).a());
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonItemView(Context context, ViewGroup aioRoot, float f16, ZPlanSessionInfo sessionInfo, mh3.b bVar, EmoticonCallback callback) {
        this(context, null, 0, aioRoot, f16, sessionInfo, bVar, callback);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioRoot, "aioRoot");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }
}
