package com.qzone.reborn.feedpro.widget.header;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeNaviBar;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.qzone.util.ar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.CommCount;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.UserProfile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.cn;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.ProcessUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 !2\u00020\u0001:\u0002[\\B'\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V\u0012\b\b\u0002\u0010X\u001a\u00020\u0011\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J(\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u00b8\u0001\u0010!\u001a\u00020\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0081\u0001\u0010 \u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\n\u0010$\u001a\u0004\u0018\u00010#H\u0002J\u001c\u0010&\u001a\u00020\u00022\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\b\u0010(\u001a\u00020'H\u0002J\u0010\u0010+\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)J\u000e\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020'J\u000e\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020'J\u0012\u00102\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u000100H\u0016J\u0012\u00105\u001a\u00020\u00022\b\u00104\u001a\u0004\u0018\u000103H\u0014R\u0016\u00107\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\"R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010!R\u0016\u0010=\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010?R\u0018\u0010F\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010?R\u0018\u0010G\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010?R\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010IR\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010KR\u0016\u0010M\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010LR\u0016\u0010N\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010LR!\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010P\u001a\u0004\bQ\u0010R\u00a8\u0006]"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviBar;", "Landroid/widget/LinearLayout;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "D", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviBar$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/widget/LinearLayout$LayoutParams;", "layoutParams", "", "textNumSize", "textSize", "u", "", "width", "r", "", "", "countMap", "screenWidth", "leftPadding", "rightPadding", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "textResultMap", "itemWidth", "spaceWidth", "callback", "J", "I", "Landroid/app/Activity;", ReportConstant.COSTREPORT_PREFIX, "textMap", "E", "", "w", "Lwd/h;", "headInfo", "H", "isShowError", UserInfo.SEX_FEMALE, "isShowForbidden", "G", "Landroid/graphics/drawable/Drawable;", "background", "setBackground", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "d", "mBackgroundAlpha", "", "e", "mUin", "f", "Ljava/lang/String;", "nickName", tl.h.F, "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviBar$b;", "mMoodItem", "i", "mBlogItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mPhotoItem", BdhLogUtil.LogTag.Tag_Conn, "mMessageItem", "mVisitorItem", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageHeadRsp;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageHeadRsp;", "rsp", "Lwd/h;", "Z", "isShowErrorPage", "isShowForbiddenPage", "", "Lkotlin/Lazy;", "t", "()Ljava/util/List;", "naviItems", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QzoneFeedProUserHomeNaviBar extends LinearLayout {

    /* renamed from: J, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private NaviItem mMessageItem;

    /* renamed from: D, reason: from kotlin metadata */
    private NaviItem mVisitorItem;

    /* renamed from: E, reason: from kotlin metadata */
    private GetMainPageHeadRsp rsp;

    /* renamed from: F, reason: from kotlin metadata */
    private wd.h headInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isShowErrorPage;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isShowForbiddenPage;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy naviItems;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mBackgroundAlpha;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String nickName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private NaviItem mMoodItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private NaviItem mBlogItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private NaviItem mPhotoItem;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviBar$a;", "", "", "count", "", "a", "BLOG_CNT", "Ljava/lang/String;", "", "CONTAINER_PADDING", "I", "ITEM_HEIGHT", "MSG_CNT", "PIC_CNT", "SHUOSHUO_CNT", "TAG", "VISITOR_CNT", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeNaviBar$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final String a(long count) {
            if (count < 0) {
                return "0";
            }
            if (count <= AppConstants.LBS_HELLO_UIN_LONGVALUE) {
                return String.valueOf(count);
            }
            if (count <= MiniAppReportManager.MAX_TIME_VALUE) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf((count * 1.0d) / 10000)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format + com.qzone.util.l.a(R.string.ty7);
            }
            if (count <= 99999999) {
                return ((int) Math.floor(count / 10000)) + com.qzone.util.l.a(R.string.ty7);
            }
            if (count <= 99999999999L) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf((count * 1.0d) / 100000000)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                return format2 + com.qzone.util.l.a(R.string.ty6);
            }
            return ((int) Math.floor(count / 100000000)) + com.qzone.util.l.a(R.string.ty6);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProUserHomeNaviBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        ho.i.h().c(getContext(), new QZoneMoodListInitBean(this.mUin, this.nickName, "getMainPage"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        ho.i.z().w(s(), this.mUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(QzoneFeedProUserHomeNaviBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D();
    }

    private final void D() {
        Map<String, Integer> mutableMapOf;
        CommCount commCount;
        CommCount commCount2;
        CommCount commCount3;
        CommCount commCount4;
        CommCount commCount5;
        removeAllViews();
        Pair[] pairArr = new Pair[5];
        GetMainPageHeadRsp getMainPageHeadRsp = this.rsp;
        int i3 = 0;
        pairArr[0] = TuplesKt.to("shuoshuoCnt", Integer.valueOf((getMainPageHeadRsp == null || (commCount5 = getMainPageHeadRsp.commCount) == null) ? 0 : commCount5.shuoshuoCnt));
        GetMainPageHeadRsp getMainPageHeadRsp2 = this.rsp;
        pairArr[1] = TuplesKt.to("blogCnt", Integer.valueOf((getMainPageHeadRsp2 == null || (commCount4 = getMainPageHeadRsp2.commCount) == null) ? 0 : commCount4.blogCnt));
        GetMainPageHeadRsp getMainPageHeadRsp3 = this.rsp;
        pairArr[2] = TuplesKt.to("picCnt", Integer.valueOf((getMainPageHeadRsp3 == null || (commCount3 = getMainPageHeadRsp3.commCount) == null) ? 0 : commCount3.picCnt));
        GetMainPageHeadRsp getMainPageHeadRsp4 = this.rsp;
        pairArr[3] = TuplesKt.to("msgCnt", Integer.valueOf((getMainPageHeadRsp4 == null || (commCount2 = getMainPageHeadRsp4.commCount) == null) ? 0 : commCount2.msgCnt));
        GetMainPageHeadRsp getMainPageHeadRsp5 = this.rsp;
        if (getMainPageHeadRsp5 != null && (commCount = getMainPageHeadRsp5.commCount) != null) {
            i3 = commCount.visitorCnt;
        }
        pairArr[4] = TuplesKt.to("visitorCnt", Integer.valueOf(i3));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        J(mutableMapOf, ar.r(pl.a.f426446a.o(getContext())), 16, 16, new Function5<Map<String, String>, Integer, Integer, Integer, Integer, Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeNaviBar$rebuildNavigationBar$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, String> map, Integer num, Integer num2, Integer num3, Integer num4) {
                invoke(map, num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Map<String, String> textResultMap, int i16, int i17, int i18, int i19) {
                List t16;
                List t17;
                Intrinsics.checkNotNullParameter(textResultMap, "textResultMap");
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ef.d.b(i16) + ((ef.d.b(i17) - ((int) ef.d.a(Float.valueOf(0.5f)))) / 2), ef.d.b(50));
                t16 = QzoneFeedProUserHomeNaviBar.this.t();
                QzoneFeedProUserHomeNaviBar qzoneFeedProUserHomeNaviBar = QzoneFeedProUserHomeNaviBar.this;
                int i26 = 0;
                for (Object obj : t16) {
                    int i27 = i26 + 1;
                    if (i26 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    QzoneFeedProUserHomeNaviBar.NaviItem naviItem = (QzoneFeedProUserHomeNaviBar.NaviItem) obj;
                    if (i26 > 0) {
                        qzoneFeedProUserHomeNaviBar.r(ef.d.b(i17));
                    }
                    t17 = qzoneFeedProUserHomeNaviBar.t();
                    if (i26 == t17.size() - 1) {
                        layoutParams = new LinearLayout.LayoutParams(-1, ef.d.b(50));
                    }
                    qzoneFeedProUserHomeNaviBar.E(textResultMap);
                    qzoneFeedProUserHomeNaviBar.u(naviItem, layoutParams, i19, i18);
                    i26 = i27;
                }
                QzoneFeedProUserHomeNaviBar.this.I();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(Map<String, String> textMap) {
        NaviItem naviItem = this.mMoodItem;
        if (naviItem != null) {
            String str = textMap.get("shuoshuoCnt");
            if (str == null) {
                str = "0";
            }
            naviItem.f(str);
        }
        NaviItem naviItem2 = this.mBlogItem;
        if (naviItem2 != null) {
            String str2 = textMap.get("blogCnt");
            if (str2 == null) {
                str2 = "0";
            }
            naviItem2.f(str2);
        }
        NaviItem naviItem3 = this.mPhotoItem;
        if (naviItem3 != null) {
            String str3 = textMap.get("picCnt");
            if (str3 == null) {
                str3 = "0";
            }
            naviItem3.f(str3);
        }
        NaviItem naviItem4 = this.mMessageItem;
        if (naviItem4 != null) {
            String str4 = textMap.get("msgCnt");
            if (str4 == null) {
                str4 = "0";
            }
            naviItem4.f(str4);
        }
        NaviItem naviItem5 = this.mVisitorItem;
        if (naviItem5 == null) {
            return;
        }
        String str5 = textMap.get("visitorCnt");
        naviItem5.f(str5 != null ? str5 : "0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        setVisibility(!this.isShowForbiddenPage && !this.isShowErrorPage ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(int width) {
        View view = new View(getContext());
        Float valueOf = Float.valueOf(0.5f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) ef.d.a(valueOf), ef.d.b(50));
        layoutParams.setMarginStart(0);
        layoutParams.setMarginEnd((width - ((int) ef.d.a(valueOf))) / 2);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(view.getResources().getColor(R.color.qui_common_border_light));
        addView(view);
    }

    private final Activity s() {
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            return (Activity) context;
        }
        return ProcessUtils.getTopActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<NaviItem> t() {
        return (List) this.naviItems.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(final NaviItem item, LinearLayout.LayoutParams layoutParams, float textNumSize, float textSize) {
        QzoneFeedProUserHomeNaviItem view = item.getView();
        view.setName(item.getNameRes());
        view.setCount(item.getCount(), textNumSize, textSize);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.header.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QzoneFeedProUserHomeNaviBar.v(QzoneFeedProUserHomeNaviBar.this, item, view2);
            }
        });
        addView(item.getView(), layoutParams);
        fo.c.o(item.getView(), item.getElementId(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(QzoneFeedProUserHomeNaviBar this$0, NaviItem item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (this$0.rsp != null) {
            item.d().invoke(this$0.rsp);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean w() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        vo.b.f(getContext(), this.mUin, "getMainPage");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        vo.b.g(getContext(), this.mUin, this.nickName, "getMainPage");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        ho.i.z().l(getContext(), this.mUin);
    }

    public final void F(boolean isShowError) {
        this.isShowErrorPage = isShowError;
        I();
    }

    public final void G(boolean isShowForbidden) {
        this.isShowForbiddenPage = isShowForbidden;
        I();
    }

    public final void H(wd.h headInfo) {
        String str;
        UserProfile userProfile;
        UserProfile userProfile2;
        String str2;
        this.headInfo = headInfo;
        GetMainPageHeadRsp headRsp = headInfo != null ? headInfo.getHeadRsp() : null;
        this.rsp = headRsp;
        this.mUin = (headRsp == null || (userProfile2 = headRsp.userProfile) == null || (str2 = userProfile2.uin) == null) ? 0L : Long.parseLong(str2);
        GetMainPageHeadRsp getMainPageHeadRsp = this.rsp;
        if (getMainPageHeadRsp == null || (userProfile = getMainPageHeadRsp.userProfile) == null || (str = userProfile.nick) == null) {
            str = "";
        }
        this.nickName = str;
        D();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        QLog.i("QzoneFeedProUserHomeNaviBar", 1, "onConfigurationChanged");
        if (!com.qzone.reborn.configx.g.f53821a.b().J1() || this.rsp == null) {
            return;
        }
        post(new Runnable() { // from class: com.qzone.reborn.feedpro.widget.header.v
            @Override // java.lang.Runnable
            public final void run() {
                QzoneFeedProUserHomeNaviBar.C(QzoneFeedProUserHomeNaviBar.this);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProUserHomeNaviBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void J(Map<String, Integer> countMap, int screenWidth, int leftPadding, int rightPadding, Function5<? super Map<String, String>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> callback) {
        int mapCapacity;
        Map mutableMap;
        Object m912maxOrThrow;
        int i3;
        int i16;
        int coerceAtLeast;
        int coerceAtLeast2;
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(countMap.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = countMap.entrySet().iterator();
        while (it.hasNext()) {
            linkedHashMap.put(((Map.Entry) it.next()).getKey(), INSTANCE.a(((Number) r3.getValue()).intValue()));
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        m912maxOrThrow = CollectionsKt___CollectionsKt.m912maxOrThrow((Iterable<? extends Object>) countMap.values());
        int intValue = ((Number) m912maxOrThrow).intValue();
        int i17 = 48;
        int i18 = 14;
        if (intValue >= 1000000) {
            if (screenWidth > 420) {
                i17 = 68;
                i3 = 18;
            } else if (screenWidth > 390) {
                i17 = 62;
                i3 = 16;
            } else {
                i18 = 12;
                i16 = 10;
            }
            i18 = i3;
            i16 = 14;
        } else {
            if (intValue >= 100000) {
                if (screenWidth > 380) {
                    i17 = 60;
                } else {
                    i16 = 11;
                }
            } else if (screenWidth > 360) {
                i17 = 54;
            } else {
                i3 = 17;
                i18 = i3;
                i16 = 14;
            }
            i16 = 14;
            i18 = 20;
        }
        int i19 = 0;
        if (countMap.size() > 1) {
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(screenWidth - ((leftPadding + rightPadding) + (countMap.size() * i17)), 0);
            i19 = coerceAtLeast2 / (countMap.size() - 1);
        }
        if (i19 <= 0) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(countMap.size(), 1);
            i17 = ((screenWidth - leftPadding) - rightPadding) / coerceAtLeast;
            i18 -= 2;
            i16 -= 2;
        }
        QLog.i("QzoneFeedProUserHomeNaviBar", 1, "itemWidth: " + i17 + ", textSize: " + i16 + ", textNumSize:" + i18 + ", spaceWidth: " + i19 + ", screenWidth: " + screenWidth + ", maxNum: " + intValue);
        callback.invoke(mutableMap, Integer.valueOf(i17), Integer.valueOf(i19), Integer.valueOf(i16), Integer.valueOf(i18));
    }

    public /* synthetic */ QzoneFeedProUserHomeNaviBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        if (background != null) {
            Drawable f16 = cn.f(background);
            if (!w()) {
                f16.setAlpha(this.mBackgroundAlpha);
            } else {
                f16.setAlpha(0);
            }
        }
        super.setBackground(background);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0014\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u001d0\u001b\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\n\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015R%\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u001d0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u0019\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviBar$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviItem;", "a", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviItem;", "e", "()Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviItem;", "view", "b", "I", "c", "()I", "nameRes", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "count", "d", "elementId", "Lkotlin/Function1;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageHeadRsp;", "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", NodeProps.ON_CLICK, "<init>", "(Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviItem;ILjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeNaviBar$b, reason: from toString */
    /* loaded from: classes37.dex */
    public static final /* data */ class NaviItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final QzoneFeedProUserHomeNaviItem view;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int nameRes;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private String count;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String elementId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final Function1<GetMainPageHeadRsp, Unit> onClick;

        /* JADX WARN: Multi-variable type inference failed */
        public NaviItem(QzoneFeedProUserHomeNaviItem view, int i3, String count, String elementId, Function1<? super GetMainPageHeadRsp, Unit> onClick) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(count, "count");
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.view = view;
            this.nameRes = i3;
            this.count = count;
            this.elementId = elementId;
            this.onClick = onClick;
        }

        /* renamed from: a, reason: from getter */
        public final String getCount() {
            return this.count;
        }

        /* renamed from: b, reason: from getter */
        public final String getElementId() {
            return this.elementId;
        }

        /* renamed from: c, reason: from getter */
        public final int getNameRes() {
            return this.nameRes;
        }

        public final Function1<GetMainPageHeadRsp, Unit> d() {
            return this.onClick;
        }

        /* renamed from: e, reason: from getter */
        public final QzoneFeedProUserHomeNaviItem getView() {
            return this.view;
        }

        public final void f(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.count = str;
        }

        public int hashCode() {
            return (((((((this.view.hashCode() * 31) + this.nameRes) * 31) + this.count.hashCode()) * 31) + this.elementId.hashCode()) * 31) + this.onClick.hashCode();
        }

        public String toString() {
            return "NaviItem(view=" + this.view + ", nameRes=" + this.nameRes + ", count=" + this.count + ", elementId=" + this.elementId + ", onClick=" + this.onClick + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NaviItem)) {
                return false;
            }
            NaviItem naviItem = (NaviItem) other;
            return Intrinsics.areEqual(this.view, naviItem.view) && this.nameRes == naviItem.nameRes && Intrinsics.areEqual(this.count, naviItem.count) && Intrinsics.areEqual(this.elementId, naviItem.elementId) && Intrinsics.areEqual(this.onClick, naviItem.onClick);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProUserHomeNaviBar(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBackgroundAlpha = 255;
        this.nickName = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends NaviItem>>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeNaviBar$naviItems$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends QzoneFeedProUserHomeNaviBar.NaviItem> invoke() {
                List<? extends QzoneFeedProUserHomeNaviBar.NaviItem> listOf;
                QzoneFeedProUserHomeNaviItem qzoneFeedProUserHomeNaviItem = new QzoneFeedProUserHomeNaviItem(context, null, 0, 0, 14, null);
                final QzoneFeedProUserHomeNaviBar qzoneFeedProUserHomeNaviBar = this;
                QzoneFeedProUserHomeNaviBar.NaviItem naviItem = new QzoneFeedProUserHomeNaviBar.NaviItem(qzoneFeedProUserHomeNaviItem, R.string.caf, "", "em_qz_talk_about", new Function1<GetMainPageHeadRsp, Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeNaviBar$naviItems$2.1
                    {
                        super(1);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GetMainPageHeadRsp getMainPageHeadRsp) {
                        QzoneFeedProUserHomeNaviBar.this.A();
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GetMainPageHeadRsp getMainPageHeadRsp) {
                        invoke2(getMainPageHeadRsp);
                        return Unit.INSTANCE;
                    }
                });
                this.mMoodItem = naviItem;
                Unit unit = Unit.INSTANCE;
                QzoneFeedProUserHomeNaviItem qzoneFeedProUserHomeNaviItem2 = new QzoneFeedProUserHomeNaviItem(context, null, 0, 0, 14, null);
                final QzoneFeedProUserHomeNaviBar qzoneFeedProUserHomeNaviBar2 = this;
                QzoneFeedProUserHomeNaviBar.NaviItem naviItem2 = new QzoneFeedProUserHomeNaviBar.NaviItem(qzoneFeedProUserHomeNaviItem2, R.string.f170632wl, "", "em_qz_log_button", new Function1<GetMainPageHeadRsp, Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeNaviBar$naviItems$2.3
                    {
                        super(1);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GetMainPageHeadRsp getMainPageHeadRsp) {
                        QzoneFeedProUserHomeNaviBar.this.y();
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GetMainPageHeadRsp getMainPageHeadRsp) {
                        invoke2(getMainPageHeadRsp);
                        return Unit.INSTANCE;
                    }
                });
                this.mBlogItem = naviItem2;
                QzoneFeedProUserHomeNaviItem qzoneFeedProUserHomeNaviItem3 = new QzoneFeedProUserHomeNaviItem(context, null, 0, 0, 14, null);
                final QzoneFeedProUserHomeNaviBar qzoneFeedProUserHomeNaviBar3 = this;
                QzoneFeedProUserHomeNaviBar.NaviItem naviItem3 = new QzoneFeedProUserHomeNaviBar.NaviItem(qzoneFeedProUserHomeNaviItem3, R.string.ty5, "", "em_qz_album", new Function1<GetMainPageHeadRsp, Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeNaviBar$naviItems$2.5
                    {
                        super(1);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GetMainPageHeadRsp getMainPageHeadRsp) {
                        QzoneFeedProUserHomeNaviBar.this.x();
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GetMainPageHeadRsp getMainPageHeadRsp) {
                        invoke2(getMainPageHeadRsp);
                        return Unit.INSTANCE;
                    }
                });
                this.mPhotoItem = naviItem3;
                QzoneFeedProUserHomeNaviItem qzoneFeedProUserHomeNaviItem4 = new QzoneFeedProUserHomeNaviItem(context, null, 0, 0, 14, null);
                final QzoneFeedProUserHomeNaviBar qzoneFeedProUserHomeNaviBar4 = this;
                QzoneFeedProUserHomeNaviBar.NaviItem naviItem4 = new QzoneFeedProUserHomeNaviBar.NaviItem(qzoneFeedProUserHomeNaviItem4, R.string.c89, "", "em_qz_message_button", new Function1<GetMainPageHeadRsp, Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeNaviBar$naviItems$2.7
                    {
                        super(1);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GetMainPageHeadRsp getMainPageHeadRsp) {
                        QzoneFeedProUserHomeNaviBar.this.z();
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GetMainPageHeadRsp getMainPageHeadRsp) {
                        invoke2(getMainPageHeadRsp);
                        return Unit.INSTANCE;
                    }
                });
                this.mMessageItem = naviItem4;
                QzoneFeedProUserHomeNaviItem qzoneFeedProUserHomeNaviItem5 = new QzoneFeedProUserHomeNaviItem(context, null, 0, 0, 14, null);
                final QzoneFeedProUserHomeNaviBar qzoneFeedProUserHomeNaviBar5 = this;
                QzoneFeedProUserHomeNaviBar.NaviItem naviItem5 = new QzoneFeedProUserHomeNaviBar.NaviItem(qzoneFeedProUserHomeNaviItem5, R.string.if9, "", "em_qz_visitor_button", new Function1<GetMainPageHeadRsp, Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeNaviBar$naviItems$2.9
                    {
                        super(1);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GetMainPageHeadRsp getMainPageHeadRsp) {
                        QzoneFeedProUserHomeNaviBar.this.B();
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GetMainPageHeadRsp getMainPageHeadRsp) {
                        invoke2(getMainPageHeadRsp);
                        return Unit.INSTANCE;
                    }
                });
                this.mVisitorItem = naviItem5;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new QzoneFeedProUserHomeNaviBar.NaviItem[]{naviItem, naviItem2, naviItem3, naviItem4, naviItem5});
                return listOf;
            }
        });
        this.naviItems = lazy;
    }
}
