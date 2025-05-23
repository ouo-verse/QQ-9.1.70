package com.tencent.biz.qqcircle.immersive.viewmodel.wink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.immersive.events.QFSFeedPositionChangeEvent;
import com.tencent.biz.qqcircle.immersive.utils.ai;
import com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.PlusEntryBubbleComposer;
import com.tencent.biz.qqcircle.publish.plusentry.composer.dailypag.PlusEntryDailyPagComposer;
import com.tencent.biz.qqcircle.publish.plusentry.composer.normal.theme.PlusEntryTheme;
import com.tencent.biz.qqcircle.utils.cy;
import com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble;
import com.tencent.biz.qqcircle.wink.DTButtonInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.vip.pb.TianShuAccess;
import e40.QFSFeedBubbleInfo;
import e40.QFSPublishFeedVariantInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import ma0.BubbleUIData;
import ma0.DailyPagData;
import ma0.VariantUIData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u008e\u00012\u00020\u0001:\u0002\u008f\u0001B\t\u00a2\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J$\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001dH\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010#J\u0010\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010&J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)J\u000e\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0004J\u000e\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0004J\u0010\u00104\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u000102J\u000e\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0004J\u000e\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u000207J4\u0010<\u001a\u00020\u00062\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u00020\u00102\u0006\u0010'\u001a\u00020)2\u0014\b\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001dJ\b\u0010=\u001a\u00020\u0010H\u0016R\u0016\u0010@\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R(\u0010F\u001a\u0004\u0018\u00010\u00022\b\u0010A\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER$\u0010K\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020M0Q8\u0006\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR \u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\\0[0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010OR#\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\\0[0Q8\u0006\u00a2\u0006\f\n\u0004\b_\u0010S\u001a\u0004\b`\u0010UR \u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\\0[0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010OR#\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\\0[0Q8\u0006\u00a2\u0006\f\n\u0004\bc\u0010S\u001a\u0004\bd\u0010UR \u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020f0[0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010OR#\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020f0[0Q8\u0006\u00a2\u0006\f\n\u0004\bi\u0010S\u001a\u0004\bj\u0010UR$\u0010n\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bl\u0010H\u001a\u0004\bm\u0010JR\u0016\u0010p\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010HR$\u0010'\u001a\u00020)2\u0006\u0010A\u001a\u00020)8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bq\u0010?\u001a\u0004\br\u0010sR\"\u0010w\u001a\u0010\u0012\f\u0012\n u*\u0004\u0018\u00010t0t0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010OR\u001d\u0010z\u001a\b\u0012\u0004\u0012\u00020t0Q8\u0006\u00a2\u0006\f\n\u0004\bx\u0010S\u001a\u0004\by\u0010UR\"\u0010|\u001a\u0010\u0012\f\u0012\n u*\u0004\u0018\u00010\u00040\u00040L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010OR\"\u0010~\u001a\u0010\u0012\f\u0012\n u*\u0004\u0018\u00010\u00040\u00040L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010OR\u001d\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u007f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R \u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040Q8\u0006\u00a2\u0006\u000e\n\u0005\b\u0083\u0001\u0010S\u001a\u0005\b\u0084\u0001\u0010UR\u0013\u0010\u0087\u0001\u001a\u00020\u00048F\u00a2\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010JR\u0013\u0010\u0089\u0001\u001a\u00020\u00048F\u00a2\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010JR\u0013\u0010\u008b\u0001\u001a\u00020\u00048F\u00a2\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010J\u00a8\u0006\u0090\u0001"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/viewmodel/wink/QFSPublishFeedViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Le40/d;", "feedVariantInfo", "", "X1", "", Constants.BASE_IN_PLUGIN_VERSION, "O2", "y2", "m2", ICustomDataEditor.NUMBER_PARAM_2, "P2", "z2", "j2", "p2", "", "id", "o2", "F2", "M2", "J2", "i2", "W1", "needAnima", "K2", "l2", "k2", QZoneDTLoginReporter.SCHEMA, "", QQBrowserActivity.APP_PARAM, "U1", "u2", ICustomDataEditor.STRING_PARAM_2, "t2", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "r2", "", IProfileCardConst.KEY_FROM_TYPE, "Q2", "", "uiType", "q2", "useDarkTheme", "C2", "isEnableSkin", "H2", "isHomeTab", Constants.MMCCID, "Lcom/tencent/biz/qqcircle/immersive/events/QFSFeedPositionChangeEvent;", "event", NowProxyConstants.AccountInfoKey.A2, "show", "I2", "Landroid/content/Context;", "context", "N2", "url", "schemaParams", SemanticAttributes.DbSystemValues.H2, "getLogTag", "i", "I", "currentUIType", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Le40/d;", "getCurrentFeedVariantInfo", "()Le40/d;", "currentFeedVariantInfo", BdhLogUtil.LogTag.Tag_Conn, "Z", "e2", "()Z", "ptkBtnStart", "Landroidx/lifecycle/MutableLiveData;", "Lma0/d;", "D", "Landroidx/lifecycle/MutableLiveData;", "_ptkBtnLiveData", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "d2", "()Landroidx/lifecycle/LiveData;", "ptkBtnLiveData", "Le40/a;", UserInfo.SEX_FEMALE, "Le40/a;", "bubbleInfo", "Loa0/a;", "Lma0/a;", "G", "_newUserTipLiveData", "H", "c2", "newUserTipLiveData", "_publishTipLiveData", "J", "f2", "publishTipLiveData", "Lma0/b;", "K", "_dailyPagLiveData", "L", "Z1", "dailyPagLiveData", "M", "getPublishTipShowing", "publishTipShowing", "N", "isFromTypeFromScheme", "P", "b2", "()I", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/normal/theme/PlusEntryTheme;", "kotlin.jvm.PlatformType", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "_qTabTheme", BdhLogUtil.LogTag.Tag_Req, "g2", "qTabTheme", ExifInterface.LATITUDE_SOUTH, "_isEnableSkin", "T", "_isDynamicHomeTab", "Landroidx/lifecycle/MediatorLiveData;", "U", "Landroidx/lifecycle/MediatorLiveData;", "_finalEnableSkin", "V", ICustomDataEditor.STRING_ARRAY_PARAM_2, "finalEnableSkin", "x2", "isInTabType", "v2", "isInDynamicType", "w2", "isInQCircleTabType", "<init>", "()V", "W", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublishFeedViewModel extends BaseViewModel {

    @NotNull
    private static final Set<String> X = new LinkedHashSet();

    /* renamed from: C, reason: from kotlin metadata */
    private volatile boolean ptkBtnStart;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<VariantUIData> _ptkBtnLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<VariantUIData> ptkBtnLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private volatile QFSFeedBubbleInfo bubbleInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<oa0.a<BubbleUIData>> _newUserTipLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<oa0.a<BubbleUIData>> newUserTipLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<oa0.a<BubbleUIData>> _publishTipLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<oa0.a<BubbleUIData>> publishTipLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<oa0.a<DailyPagData>> _dailyPagLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<oa0.a<DailyPagData>> dailyPagLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    private volatile boolean publishTipShowing;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isFromTypeFromScheme;

    /* renamed from: P, reason: from kotlin metadata */
    private int fromType;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<PlusEntryTheme> _qTabTheme;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final LiveData<PlusEntryTheme> qTabTheme;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isEnableSkin;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isDynamicHomeTab;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<Boolean> _finalEnableSkin;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> finalEnableSkin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentUIType = -1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile QFSPublishFeedVariantInfo currentFeedVariantInfo;

    public QFSPublishFeedViewModel() {
        MutableLiveData<VariantUIData> mutableLiveData = new MutableLiveData<>();
        this._ptkBtnLiveData = mutableLiveData;
        this.ptkBtnLiveData = mutableLiveData;
        this.bubbleInfo = new QFSFeedBubbleInfo(false, null, null, null, null, null, null, null, 255, null);
        MutableLiveData<oa0.a<BubbleUIData>> mutableLiveData2 = new MutableLiveData<>();
        this._newUserTipLiveData = mutableLiveData2;
        this.newUserTipLiveData = mutableLiveData2;
        MutableLiveData<oa0.a<BubbleUIData>> mutableLiveData3 = new MutableLiveData<>();
        this._publishTipLiveData = mutableLiveData3;
        this.publishTipLiveData = mutableLiveData3;
        MutableLiveData<oa0.a<DailyPagData>> mutableLiveData4 = new MutableLiveData<>();
        this._dailyPagLiveData = mutableLiveData4;
        this.dailyPagLiveData = mutableLiveData4;
        this.fromType = 17;
        MutableLiveData<PlusEntryTheme> mutableLiveData5 = new MutableLiveData<>(PlusEntryTheme.Dark);
        this._qTabTheme = mutableLiveData5;
        this.qTabTheme = mutableLiveData5;
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>(Boolean.FALSE);
        this._isEnableSkin = mutableLiveData6;
        MutableLiveData<Boolean> mutableLiveData7 = new MutableLiveData<>(Boolean.TRUE);
        this._isDynamicHomeTab = mutableLiveData7;
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        this._finalEnableSkin = mediatorLiveData;
        this.finalEnableSkin = mediatorLiveData;
        QFSPublishPagBubble.INSTANCE.i();
        PlusEntryDailyPagComposer.INSTANCE.e();
        D2();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSPublishFeedViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                if (Intrinsics.areEqual(QFSPublishFeedViewModel.this._isDynamicHomeTab.getValue(), Boolean.FALSE)) {
                    QFSPublishFeedViewModel.this._finalEnableSkin.setValue(Boolean.TRUE);
                } else {
                    QFSPublishFeedViewModel.this._finalEnableSkin.setValue(bool);
                }
            }
        };
        mediatorLiveData.addSource(mutableLiveData6, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.wink.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPublishFeedViewModel.P1(Function1.this, obj);
            }
        });
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSPublishFeedViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
            
                if ((r3 == null ? false : r3.booleanValue()) != false) goto L9;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Boolean bool) {
                boolean z16;
                MediatorLiveData mediatorLiveData2 = QFSPublishFeedViewModel.this._finalEnableSkin;
                if (bool.booleanValue()) {
                    Boolean bool2 = (Boolean) QFSPublishFeedViewModel.this._isEnableSkin.getValue();
                    z16 = false;
                }
                z16 = true;
                mediatorLiveData2.setValue(Boolean.valueOf(z16));
            }
        };
        mediatorLiveData.addSource(mutableLiveData7, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.wink.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPublishFeedViewModel.Q1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B2(QFSFeedPositionChangeEvent qFSFeedPositionChangeEvent, QFSPublishFeedViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSPublishFeedVariantInfo.Companion companion = QFSPublishFeedVariantInfo.INSTANCE;
        int position = qFSFeedPositionChangeEvent.getPosition();
        FeedCloudMeta$StFeed g16 = qFSFeedPositionChangeEvent.getFeedData().g();
        Intrinsics.checkNotNullExpressionValue(g16, "event.feedData.sourceData");
        QFSPublishFeedVariantInfo a16 = companion.a(position, g16);
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "onFeedPosChanged, feedVariantInfo: " + a16 + ", currentFeedVariantInfo: " + this$0.currentFeedVariantInfo);
        if (!this$0.X1(a16)) {
            return;
        }
        this$0.currentFeedVariantInfo = a16;
        com.tencent.biz.qqcircle.wink.e.f93946a.z(new DTButtonInfo(a16.getBtnAdId(), null, 2, null));
        if (a16.getFeedPos() == 1) {
            QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "tryShowPublishTip ");
            if (this$0.P2()) {
                L2(this$0, a16, false, 2, null);
                return;
            } else if (this$0.i2(a16)) {
                this$0.M2(a16);
                return;
            } else {
                this$0.K2(a16, false);
                this$0.O2();
                return;
            }
        }
        this$0.M2(a16);
    }

    private final void D2() {
        List<TianShuAdPosItemData> listOf;
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "requestBubbleInfo, start ");
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 1060;
        tianShuAdPosItemData.mNeedCnt = 1;
        ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(tianShuAdPosItemData);
        iTianshuManager.requestAdv(listOf, new TianShuGetAdvCallback() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.wink.c
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                QFSPublishFeedViewModel.E2(QFSPublishFeedViewModel.this, z16, getAdsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(QFSPublishFeedViewModel this$0, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "requestBubbleInfo, result:" + z16 + ", getAdsRsp:" + getAdsRsp);
        if (z16 && getAdsRsp != null) {
            this$0.bubbleInfo = QFSFeedBubbleInfo.INSTANCE.a(getAdsRsp);
        }
    }

    private final void F2(String id5) {
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "saveShowTip, id: " + id5);
        X.add(id5);
    }

    private final void J2(QFSPublishFeedVariantInfo feedVariantInfo) {
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "startPtkBtnIfNeed, ptkBtnStart: " + this.ptkBtnStart);
        if (this.ptkBtnStart) {
            if (W1(feedVariantInfo)) {
                this._dailyPagLiveData.postValue(ma0.c.a(new DailyPagData(false)));
                this._ptkBtnLiveData.postValue(new VariantUIData(true, true, feedVariantInfo));
                return;
            }
            return;
        }
        this.ptkBtnStart = true;
        this._dailyPagLiveData.postValue(ma0.c.a(new DailyPagData(false)));
        this._ptkBtnLiveData.postValue(new VariantUIData(true, true, feedVariantInfo));
        p2();
    }

    private final void K2(QFSPublishFeedVariantInfo feedVariantInfo, boolean needAnima) {
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "stopPtkBtnIfNeed, ptkBtnStart: " + this.ptkBtnStart);
        if (this.ptkBtnStart) {
            this.ptkBtnStart = false;
            this._ptkBtnLiveData.postValue(new VariantUIData(false, needAnima, feedVariantInfo));
        }
    }

    static /* synthetic */ void L2(QFSPublishFeedViewModel qFSPublishFeedViewModel, QFSPublishFeedVariantInfo qFSPublishFeedVariantInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        qFSPublishFeedViewModel.K2(qFSPublishFeedVariantInfo, z16);
    }

    private final void M2(QFSPublishFeedVariantInfo feedVariantInfo) {
        if (i2(feedVariantInfo)) {
            J2(feedVariantInfo);
        } else {
            L2(this, feedVariantInfo, false, 2, null);
        }
    }

    private final boolean O2() {
        if (t2()) {
            QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "tryShowPublishAnimation, debug do not need show ");
            return false;
        }
        if (!y2()) {
            QLog.i("PlusEntry-QFSPublishFeedViewModel", 1, "tryShowPublishAnimation, do not need show ");
            return false;
        }
        QLog.i("PlusEntry-QFSPublishFeedViewModel", 1, "tryShowPublishAnimation, show ");
        this._dailyPagLiveData.postValue(ma0.c.a(new DailyPagData(true)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean P2() {
        if (u2()) {
            QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "tryShowPublishTip, debug do not need show ");
            return false;
        }
        if (!z2()) {
            QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "tryShowPublishTip, do not need show ");
            return false;
        }
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "tryShowPublishTip, bubbleInfo:" + this.bubbleInfo);
        PlusEntryBubbleComposer.INSTANCE.b(this.bubbleInfo.getAdId());
        F2(this.bubbleInfo.getAdId());
        I2(true);
        this._publishTipLiveData.postValue(ma0.c.a(new BubbleUIData(true, this.bubbleInfo)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final String U1(String schema, Map<String, String> extraParams) {
        boolean contains$default;
        StringBuilder sb5;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) schema, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
        if (contains$default) {
            sb5 = new StringBuilder(schema);
        } else {
            sb5 = new StringBuilder(schema);
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        }
        for (Map.Entry<String, String> entry : extraParams.entrySet()) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append(entry.getKey());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(entry.getValue());
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "appendExtraParams, ret: " + sb6);
        return sb6;
    }

    private final boolean W1(QFSPublishFeedVariantInfo feedVariantInfo) {
        String str;
        QFSPublishFeedVariantInfo variantInfo;
        String btnAdId = feedVariantInfo.getBtnAdId();
        VariantUIData value = this._ptkBtnLiveData.getValue();
        if (value != null && (variantInfo = value.getVariantInfo()) != null) {
            str = variantInfo.getBtnAdId();
        } else {
            str = null;
        }
        boolean z16 = !Intrinsics.areEqual(btnAdId, str);
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "checkBtnAdIdChanged, ret: " + z16);
        return z16;
    }

    private final boolean X1(QFSPublishFeedVariantInfo feedVariantInfo) {
        String str;
        String feedId = feedVariantInfo.getFeedId();
        QFSPublishFeedVariantInfo qFSPublishFeedVariantInfo = this.currentFeedVariantInfo;
        if (qFSPublishFeedVariantInfo != null) {
            str = qFSPublishFeedVariantInfo.getFeedId();
        } else {
            str = null;
        }
        boolean z16 = !Intrinsics.areEqual(feedId, str);
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "checkFeedIdChanged, ret: " + z16);
        return z16;
    }

    private final boolean i2(QFSPublishFeedVariantInfo feedVariantInfo) {
        boolean z16;
        boolean z17;
        if (s2()) {
            QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "hasPtkBtnInfo, debug do not need show ");
            return false;
        }
        if (!feedVariantInfo.getHasBtnVariant()) {
            return false;
        }
        if (feedVariantInfo.getBtnIcon().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (feedVariantInfo.getBtnJumpUrl().length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return false;
        }
        return true;
    }

    private final boolean j2() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (!this.bubbleInfo.getHasInfo() || !this.bubbleInfo.i()) {
            return false;
        }
        if (this.bubbleInfo.getJumpUrl().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (this.bubbleInfo.getIcon().length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            if (this.bubbleInfo.getTitle().length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                if (this.bubbleInfo.getSubtitle().length() > 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z19) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean k2() {
        boolean a16 = ai.a();
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "hasShowMessageNoticeView, ret: " + a16);
        return a16;
    }

    private final boolean l2() {
        boolean z16;
        if (x2() && k2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "hasShowMsgNoticeViewAndInTabType, ret:" + z16);
        return z16;
    }

    private final boolean m2() {
        if (com.tencent.biz.qqcircle.f.v().A() - 1 >= uq3.c.X2()) {
            return true;
        }
        return false;
    }

    private final boolean n2() {
        Calendar calendar = Calendar.getInstance();
        return Intrinsics.areEqual(com.tencent.biz.qqcircle.f.v().B(), calendar.get(1) + "-" + calendar.get(2) + "-" + calendar.get(5));
    }

    private final boolean o2(String id5) {
        boolean contains = X.contains(id5);
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "hasShowTip, id: " + id5 + ", ret: " + contains);
        return contains;
    }

    private final void p2() {
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "hidePublishTip, tipShowing: " + this.publishTipShowing);
        if (this.publishTipShowing) {
            I2(false);
            this._publishTipLiveData.postValue(ma0.c.a(new BubbleUIData(false, null, 2, null)));
        }
    }

    private final boolean s2() {
        return com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_SKIP_PTK, 0);
    }

    private final boolean t2() {
        return com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIECLE_AKIP_PUBLISH_ANIMATION, 0);
    }

    private final boolean u2() {
        return com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_SKIP_PUBLISHTIPS, 0);
    }

    private final boolean y2() {
        if (x2() && PlusEntryDailyPagComposer.INSTANCE.d() && !m2() && !n2()) {
            return true;
        }
        return false;
    }

    private final boolean z2() {
        if (!v2() && j2() && !o2(this.bubbleInfo.getAdId()) && !l2()) {
            return true;
        }
        return false;
    }

    public final void A2(@Nullable final QFSFeedPositionChangeEvent event) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        e30.b feedData;
        if (event != null && (feedData = event.getFeedData()) != null) {
            feedCloudMeta$StFeed = feedData.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.wink.d
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublishFeedViewModel.B2(QFSFeedPositionChangeEvent.this, this);
            }
        });
    }

    public final void C2(boolean useDarkTheme) {
        PlusEntryTheme plusEntryTheme;
        if (useDarkTheme) {
            plusEntryTheme = PlusEntryTheme.Dark;
        } else if (QQTheme.isNowThemeIsNight()) {
            plusEntryTheme = PlusEntryTheme.Dark;
        } else if (ThemeUtil.isDefaultTheme()) {
            plusEntryTheme = PlusEntryTheme.WhiteDefault;
        } else {
            plusEntryTheme = PlusEntryTheme.WhiteColor;
        }
        this._qTabTheme.postValue(plusEntryTheme);
    }

    public final void G2(boolean isHomeTab) {
        this._isDynamicHomeTab.postValue(Boolean.valueOf(isHomeTab));
    }

    public final void H2(boolean isEnableSkin) {
        this._isEnableSkin.postValue(Boolean.valueOf(isEnableSkin));
    }

    public final void I2(boolean show) {
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "setPublishTipShowing, show: " + show);
        this.publishTipShowing = show;
    }

    public final boolean N2(@NotNull Context context) {
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "tryInterceptJump2Publish, publishTipShowing: " + this.publishTipShowing + ", bubbleInfo: " + this.bubbleInfo);
        if (!this.publishTipShowing || !j2()) {
            return false;
        }
        String jumpUrl = this.bubbleInfo.getJumpUrl();
        int i3 = this.fromType;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_guide_text", this.bubbleInfo.getTitle()), TuplesKt.to("xsj_tianshu_task_id", this.bubbleInfo.getAdId()));
        h2(context, jumpUrl, i3, mapOf);
        return true;
    }

    public final void Q2(@Nullable Object fromType) {
        if (!this.isFromTypeFromScheme && (fromType instanceof Integer)) {
            int intValue = ((Number) fromType).intValue();
            if (intValue != 1) {
                if (intValue != 4) {
                    if (intValue == 6) {
                        this.fromType = 17;
                        return;
                    }
                    return;
                }
                this.fromType = 18;
                return;
            }
            this.fromType = 16;
        }
    }

    @NotNull
    public final LiveData<oa0.a<DailyPagData>> Z1() {
        return this.dailyPagLiveData;
    }

    @NotNull
    public final LiveData<Boolean> a2() {
        return this.finalEnableSkin;
    }

    /* renamed from: b2, reason: from getter */
    public final int getFromType() {
        return this.fromType;
    }

    @NotNull
    public final LiveData<oa0.a<BubbleUIData>> c2() {
        return this.newUserTipLiveData;
    }

    @NotNull
    public final LiveData<VariantUIData> d2() {
        return this.ptkBtnLiveData;
    }

    /* renamed from: e2, reason: from getter */
    public final boolean getPtkBtnStart() {
        return this.ptkBtnStart;
    }

    @NotNull
    public final LiveData<oa0.a<BubbleUIData>> f2() {
        return this.publishTipLiveData;
    }

    @NotNull
    public final LiveData<PlusEntryTheme> g2() {
        return this.qTabTheme;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "PlusEntry-QFSPublishFeedViewModel";
    }

    public final void h2(@NotNull Context context, @NotNull String url, int fromType, @NotNull Map<String, String> schemaParams) {
        Map<String, String> mutableMap;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(schemaParams, "schemaParams");
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "handleUrl, url: " + url);
        if (cy.n(url)) {
            mutableMap = MapsKt__MapsKt.toMutableMap(schemaParams);
            String traceId = QCirclePublishQualityReporter.getTraceId();
            Intrinsics.checkNotNullExpressionValue(traceId, "getTraceId()");
            mutableMap.put(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
            mutableMap.put(IProfileCardConst.KEY_FROM_TYPE, String.valueOf(fromType));
            mutableMap.put("xsj_publish_location", com.tencent.biz.qqcircle.wink.e.f93946a.w());
            com.tencent.biz.qqcircle.launcher.c.g(context, U1(url, mutableMap));
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.g(context, url);
    }

    public final void q2(int uiType) {
        QLog.d("PlusEntry-QFSPublishFeedViewModel", 1, "initData, uiType: " + uiType);
        this.currentUIType = uiType;
    }

    public final void r2(@Nullable Activity activity) {
        Intent intent;
        boolean z16;
        int i3;
        if (activity != null && (intent = activity.getIntent()) != null) {
            String stringExtra = intent.getStringExtra("key_scheme");
            if (stringExtra != null && stringExtra.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                this.isFromTypeFromScheme = true;
                if (intent.hasExtra(IProfileCardConst.KEY_FROM_TYPE)) {
                    i3 = intent.getIntExtra(IProfileCardConst.KEY_FROM_TYPE, this.fromType);
                } else {
                    i3 = 7;
                }
                this.fromType = i3;
            }
        }
    }

    public final boolean v2() {
        if (this.currentUIType == 2) {
            return true;
        }
        return false;
    }

    public final boolean w2() {
        if (this.currentUIType == 3) {
            return true;
        }
        return false;
    }

    public final boolean x2() {
        if (this.currentUIType == 1) {
            return true;
        }
        return false;
    }
}
