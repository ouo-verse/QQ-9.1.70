package com.tencent.mobileqq.search.searchdetail.multimedia;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.SearchInteractiveData;
import com.tencent.mobileqq.search.searchdetail.SearchInteractiveView;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateNineBoxGridItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchVerticalDetailTemplateItem;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchGuildJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchInteractiveComponents;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchNineBoxContent;
import com.tencent.qqnt.kernel.nativeinterface.SearchPicture;
import com.tencent.qqnt.kernel.nativeinterface.SearchPictureDetail;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchStFeed;
import com.tencent.qqnt.kernel.nativeinterface.SearchStImage;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import com.tencent.qqnt.kernel.nativeinterface.SearchVideo;
import com.tencent.util.AppSetting;
import feedcloud.FeedCloudMeta$StFeed;
import hp2.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u007f2\u00020\u0001:\u0002V\\B\u0017\u0012\u0006\u0010Z\u001a\u00020U\u0012\u0006\u0010^\u001a\u00020[\u00a2\u0006\u0004\b}\u0010~J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\f\u0010\u0017\u001a\u00020\u0016*\u00020\u0013H\u0002J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0002J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JJ\u00105\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u0001012\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u000103H\u0002JJ\u00106\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u0001012\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u000103H\u0002JJ\u00107\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u0001012\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u000103H\u0002J*\u00108\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u0001012\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u000103H\u0002J\u0018\u00109\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010>\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010@\u001a\u00020?J\u0016\u0010D\u001a\u00020\u00042\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\u000fJ\u000e\u0010F\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0016J\u0014\u0010I\u001a\u00020\u00042\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040GJ\u0010\u0010J\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000101J\u000e\u0010L\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0006J;\u0010T\u001a\u00020\u0004\"\b\b\u0000\u0010N*\u00020M*\u00020\n2\u001d\u0010Q\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040O\u00a2\u0006\u0002\bP2\u0006\u0010S\u001a\u00020RR\u0017\u0010Z\u001a\u00020U8\u0006\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R$\u0010e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0014\u0010h\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\"\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0i0i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR$\u0010q\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0n0n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u001c\u0010v\u001a\n s*\u0004\u0018\u00010r0r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010uR$\u0010|\u001a\u00020?2\u0006\u0010w\u001a\u00020?8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{\u00a8\u0006\u0080\u0001"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/multimedia/NetSearchMultiMediaCard;", "", "", "position", "", "c0", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/n;", "model", "l0", "h0", "Landroid/view/View;", "targetView", "w", "n0", "q0", "", "ratioString", ExifInterface.LATITUDE_SOUTH, "T", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchNineBoxContent;", "mediaInfo", BdhLogUtil.LogTag.Tag_Conn, "", "G", "columnIndex", "rowIndex", "U", "o0", "D", "E", UserInfo.SEX_FEMALE, "content", "L", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", ReportConstant.COSTREPORT_PREFIX, "r", "u", "s0", "e0", "colorId", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "b0", "V", "", "guildId", "docId", "traceId", "likeStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "jumpInfo", "", "extensionMap", "N", "O", "M", "H", "u0", "m0", "w0", "a0", "k0", "d0", "", "v", "Landroid/widget/ImageView;", "imageView", "url", "K", NodeProps.VISIBLE, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Function0;", "cb", "P", "J", "data", HippyTKDListViewAdapter.X, "Landroid/view/ViewGroup$LayoutParams;", "LP", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "block", "Lcom/tencent/mobileqq/search/searchdetail/multimedia/NetSearchMultiMediaCard$b;", "observer", "x0", "Lhp2/am;", "a", "Lhp2/am;", "y", "()Lhp2/am;", "binding", "Lcom/tencent/mobileqq/search/searchdetail/multimedia/MultiMediaSection;", "b", "Lcom/tencent/mobileqq/search/searchdetail/multimedia/MultiMediaSection;", "section", "c", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/n;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/search/searchdetail/content/template/model/n;", "setContentModel", "(Lcom/tencent/mobileqq/search/searchdetail/content/template/model/n;)V", "contentModel", "d", "Lcom/tencent/mobileqq/search/searchdetail/multimedia/NetSearchMultiMediaCard$b;", "rootWidthObservable", "", "Landroidx/constraintlayout/utils/widget/ImageFilterView;", "e", "Ljava/util/List;", "nineGridImageViews", "", "f", "[[Landroid/view/View;", "nineGridImagePlayIconViews", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "g", "Landroid/content/Context;", "context", "value", "B", "()F", BdhLogUtil.LogTag.Tag_Req, "(F)V", "rootWidthPercent33", "<init>", "(Lhp2/am;Lcom/tencent/mobileqq/search/searchdetail/multimedia/MultiMediaSection;)V", tl.h.F, "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchMultiMediaCard {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final am binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MultiMediaSection section;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NetSearchTemplateNineBoxGridItem contentModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b rootWidthObservable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends List<? extends ImageFilterView>> nineGridImageViews;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View[][] nineGridImagePlayIconViews;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\u0004R$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR+\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00028F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/multimedia/NetSearchMultiMediaCard$b;", "", "", "newWidth", "", "c", "Lkotlin/Function1;", "listener", "f", "d", "a", "Lkotlin/jvm/functions/Function1;", "<set-?>", "b", "Lkotlin/properties/ReadWriteProperty;", "()F", "e", "(F)V", "width", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f284515c = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "width", "getWidth()F", 0))};

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function1<? super Float, Unit> listener;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ReadWriteProperty width;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes18.dex */
        public static final class a extends ObservableProperty<Float> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f284518b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, b bVar) {
                super(obj);
                this.f284518b = bVar;
            }

            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(@NotNull KProperty<?> property, Float oldValue, Float newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                float floatValue = newValue.floatValue();
                if (Math.abs(oldValue.floatValue() - floatValue) > 0.01d) {
                    this.f284518b.c(floatValue);
                }
            }
        }

        public b() {
            Delegates delegates = Delegates.INSTANCE;
            this.width = new a(Float.valueOf(0.0f), this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(float newWidth) {
            Function1<? super Float, Unit> function1 = this.listener;
            if (function1 != null) {
                function1.invoke(Float.valueOf(newWidth));
            }
        }

        public final float b() {
            return ((Number) this.width.getValue(this, f284515c[0])).floatValue();
        }

        public final void d() {
            this.listener = null;
        }

        public final void e(float f16) {
            this.width.setValue(this, f284515c[0], Float.valueOf(f16));
        }

        public final void f(@Nullable Function1<? super Float, Unit> listener) {
            this.listener = listener;
            if (listener != null) {
                listener.invoke(Float.valueOf(b()));
            }
        }
    }

    public NetSearchMultiMediaCard(@NotNull am binding, @NotNull MultiMediaSection section) {
        List listOf;
        List<? extends List<? extends ImageFilterView>> listOf2;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(section, "section");
        this.binding = binding;
        this.section = section;
        this.rootWidthObservable = new b();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ImageFilterView[]{binding.f405617p, binding.f405618q, binding.f405619r});
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(listOf);
        this.nineGridImageViews = listOf2;
        this.nineGridImagePlayIconViews = new View[][]{new View[]{null, null, null}, new View[]{null, null, null}, new View[]{null, null, null}};
        this.context = binding.getRoot().getContext();
    }

    private final String C(SearchNineBoxContent mediaInfo) {
        SearchPicture searchPicture;
        String str;
        SearchStFeed searchStFeed;
        SearchStImage searchStImage;
        boolean z16;
        SearchStFeed searchStFeed2;
        SearchStImage searchStImage2;
        if (mediaInfo == null) {
            return null;
        }
        if (G(mediaInfo)) {
            SearchVideo searchVideo = mediaInfo.video;
            if (searchVideo != null && (searchStFeed2 = searchVideo.feed) != null && (searchStImage2 = searchStFeed2.cover) != null) {
                str = searchStImage2.picUrl;
            } else {
                str = null;
            }
            boolean z17 = false;
            if (str != null) {
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (z17) {
                return str;
            }
            SearchVideo searchVideo2 = mediaInfo.video;
            if (searchVideo2 == null || (searchStFeed = searchVideo2.feed) == null || (searchStImage = searchStFeed.cover) == null) {
                return null;
            }
            return searchStImage.layerPicUrl;
        }
        SearchPictureDetail searchPictureDetail = mediaInfo.picture;
        if (searchPictureDetail == null || (searchPicture = searchPictureDetail.small) == null) {
            return null;
        }
        return searchPicture.picLink;
    }

    private final void D() {
        Iterator<? extends List<? extends ImageFilterView>> it = this.nineGridImageViews.iterator();
        while (it.hasNext()) {
            Iterator<? extends ImageFilterView> it5 = it.next().iterator();
            while (it5.hasNext()) {
                it5.next().setVisibility(8);
            }
        }
        this.binding.f405615n.setVisibility(8);
    }

    private final void E() {
        this.binding.f405627z.setVisibility(8);
        this.binding.f405626y.setVisibility(8);
    }

    private final void F() {
        this.binding.A.U0();
        this.binding.A.setVisibility(8);
    }

    private final boolean G(SearchNineBoxContent searchNineBoxContent) {
        if (searchNineBoxContent.type == 2) {
            return true;
        }
        return false;
    }

    private final void H(SearchJump jumpInfo, Map<String, String> extensionMap) {
        Integer num;
        String str;
        String str2 = null;
        if (jumpInfo != null) {
            num = Integer.valueOf(jumpInfo.type);
        } else {
            num = null;
        }
        if (jumpInfo != null) {
            str = jumpInfo.jumpLink;
        } else {
            str = null;
        }
        if (jumpInfo != null) {
            str2 = jumpInfo.jumpAndLink;
        }
        QLog.d("QQSearch.NetDetail.SearchDetailMultiMediaCard", 1, "jump type:" + num + "," + str + "," + str2);
        if (jumpInfo == null) {
            return;
        }
        this.section.d(jumpInfo, extensionMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void I(NetSearchMultiMediaCard netSearchMultiMediaCard, SearchJump searchJump, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        netSearchMultiMediaCard.H(searchJump, map);
    }

    private final void L(String content) {
        if (AppSetting.isDebugVersion()) {
            QLog.d("QQSearch.NetDetail.SearchDetailMultiMediaCard", 4, content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(long guildId, String docId, String traceId, int likeStatus, SearchJump jumpInfo, Map<String, String> extensionMap) {
        H(jumpInfo, extensionMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(long guildId, String docId, String traceId, int likeStatus, SearchJump jumpInfo, Map<String, String> extensionMap) {
        H(jumpInfo, extensionMap);
        this.section.d0(guildId, docId, likeStatus, traceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(long guildId, String docId, String traceId, int likeStatus, SearchJump jumpInfo, Map<String, String> extensionMap) {
        H(jumpInfo, extensionMap);
        this.section.e0(guildId, docId, traceId);
    }

    private final void S(final String ratioString) {
        ImageFilterView imageFilterView = this.binding.f405627z;
        Intrinsics.checkNotNullExpressionValue(imageFilterView, "binding.singleImage");
        x0(imageFilterView, new Function2<ConstraintLayout.LayoutParams, Integer, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$setSinglePictureRatioInFixedHeight$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ConstraintLayout.LayoutParams layoutParams, Integer num) {
                invoke(layoutParams, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintLayout.LayoutParams updateLayoutParamsWithListener, int i3) {
                Intrinsics.checkNotNullParameter(updateLayoutParamsWithListener, "$this$updateLayoutParamsWithListener");
                updateLayoutParamsWithListener.dimensionRatio = ratioString;
                ((ViewGroup.MarginLayoutParams) updateLayoutParamsWithListener).height = i3;
                updateLayoutParamsWithListener.endToEnd = -1;
            }
        }, this.rootWidthObservable);
    }

    private final void T(final String ratioString) {
        ImageFilterView imageFilterView = this.binding.f405627z;
        Intrinsics.checkNotNullExpressionValue(imageFilterView, "binding.singleImage");
        p.a(imageFilterView, new Function1<ConstraintLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$setSinglePictureRatioInFixedWidth$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConstraintLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConstraintLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                updateLayoutParams.dimensionRatio = ratioString;
                ((ViewGroup.MarginLayoutParams) updateLayoutParams).height = 0;
                updateLayoutParams.endToEnd = this.getBinding().f405612k.getId();
            }
        });
    }

    private final void U(int columnIndex, int rowIndex, SearchNineBoxContent mediaInfo) {
        View view = this.nineGridImagePlayIconViews[columnIndex][rowIndex];
        View view2 = view;
        if (!G(mediaInfo)) {
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (view == null) {
            FrameLayout frameLayout = new FrameLayout(this.context);
            this.nineGridImagePlayIconViews[columnIndex][rowIndex] = frameLayout;
            this.binding.getRoot().addView(frameLayout);
            ImageFilterView imageFilterView = this.nineGridImageViews.get(columnIndex).get(rowIndex);
            Intrinsics.checkNotNullExpressionValue(imageFilterView, "nineGridImageViews[columnIndex][rowIndex]");
            final ImageFilterView imageFilterView2 = imageFilterView;
            p.a(frameLayout, new Function1<ConstraintLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$setSmallPlayIconForMultiMedia$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ConstraintLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ConstraintLayout.LayoutParams updateLayoutParams) {
                    Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                    ((ViewGroup.MarginLayoutParams) updateLayoutParams).width = 0;
                    ((ViewGroup.MarginLayoutParams) updateLayoutParams).height = 0;
                    updateLayoutParams.startToStart = ImageFilterView.this.getId();
                    updateLayoutParams.endToEnd = ImageFilterView.this.getId();
                    updateLayoutParams.topToTop = ImageFilterView.this.getId();
                    updateLayoutParams.bottomToBottom = ImageFilterView.this.getId();
                }
            });
            frameLayout.setBackgroundColor(z(R.color.qui_common_overlay_standard_secondary));
            ImageView imageView = new ImageView(this.context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageDrawable(AppCompatResources.getDrawable(this.context, R.drawable.qui_play_filled_icon_white));
            frameLayout.addView(imageView);
            p.a(imageView, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$setSmallPlayIconForMultiMedia$1$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull FrameLayout.LayoutParams updateLayoutParams) {
                    Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                    updateLayoutParams.width = ViewUtils.dpToPx(24.0f);
                    updateLayoutParams.height = ViewUtils.dpToPx(24.0f);
                    updateLayoutParams.gravity = 17;
                }
            });
            view2 = frameLayout;
        }
        view2.setVisibility(0);
    }

    private final void V(NetSearchTemplateNineBoxGridItem model) {
        final SearchJump searchJump;
        SearchIcon contentIcon = model.getContentIcon();
        if (contentIcon != null) {
            searchJump = contentIcon.jumpLink;
        } else {
            searchJump = null;
        }
        final Function1<View, Unit> function1 = new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$setTitleAreaClick$clickHead$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                NetSearchMultiMediaCard.I(NetSearchMultiMediaCard.this, searchJump, null, 2, null);
            }
        };
        this.binding.f405605d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchMultiMediaCard.W(Function1.this, view);
            }
        });
        this.binding.f405608g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchMultiMediaCard.X(Function1.this, view);
            }
        });
        this.binding.C.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchMultiMediaCard.Y(Function1.this, view);
            }
        });
        this.binding.f405609h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchMultiMediaCard.Z(Function1.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 tmp0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Function1 tmp0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void a0(NetSearchTemplateNineBoxGridItem model) {
        String str;
        boolean z16;
        SearchPictureDetail searchPictureDetail;
        SearchPicture searchPicture;
        SearchIcon contentIcon = model.getContentIcon();
        if (contentIcon != null && (searchPictureDetail = contentIcon.auth) != null && (searchPicture = searchPictureDetail.small) != null) {
            str = searchPicture.picLink;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.binding.f405606e.setVisibility(8);
            return;
        }
        this.binding.f405606e.setVisibility(0);
        ImageFilterView imageFilterView = this.binding.f405606e;
        Intrinsics.checkNotNullExpressionValue(imageFilterView, "binding.cardIconSubscript");
        K(imageFilterView, str);
    }

    private final void b0(NetSearchTemplateNineBoxGridItem model, int position) {
        String str;
        Integer num;
        String str2;
        boolean z16;
        SearchText searchText;
        SearchIcon contentIcon = model.getContentIcon();
        SearchReportInfo searchReportInfo = null;
        if (contentIcon != null && (searchText = contentIcon.title) != null) {
            str = searchText.text;
        } else {
            str = null;
        }
        SearchIcon contentIcon2 = model.getContentIcon();
        if (contentIcon2 != null) {
            num = Integer.valueOf(contentIcon2.iconType);
        } else {
            num = null;
        }
        QLog.i("QQSearch.NetDetail.SearchDetailMultiMediaCard", 2, "buildBaseInfo:nickName:" + str + ",icon.type:" + num);
        SearchIcon contentIcon3 = model.getContentIcon();
        if (contentIcon3 != null) {
            str2 = contentIcon3.iconLink;
        } else {
            str2 = null;
        }
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w0(model);
        } else {
            k0(model);
        }
        com.tencent.mobileqq.search.searchdetail.util.f fVar = com.tencent.mobileqq.search.searchdetail.util.f.f284742a;
        QQProAvatarView qQProAvatarView = this.binding.f405605d;
        Intrinsics.checkNotNullExpressionValue(qQProAvatarView, "binding.cardIcon");
        SearchIcon contentIcon4 = model.getContentIcon();
        if (contentIcon4 != null) {
            searchReportInfo = contentIcon4.reportInfo;
        }
        com.tencent.mobileqq.search.searchdetail.util.f.b(fVar, qQProAvatarView, searchReportInfo, model.getCommonInfo().getItemId(), null, 8, null);
        a0(model);
        u0(model, position);
        V(model);
    }

    private final void c0(int position) {
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem = this.contentModel;
        if (netSearchTemplateNineBoxGridItem == null) {
            QLog.e("QQSearch.NetDetail.SearchDetailMultiMediaCard", 1, "showContent but contentData is null");
            return;
        }
        b0(netSearchTemplateNineBoxGridItem, position);
        e0(netSearchTemplateNineBoxGridItem);
        n0(netSearchTemplateNineBoxGridItem);
        h0(netSearchTemplateNineBoxGridItem);
        l0(netSearchTemplateNineBoxGridItem);
    }

    private final void e0(final NetSearchTemplateNineBoxGridItem model) {
        String str;
        boolean z16;
        CharSequence charSequence;
        String str2;
        SearchReportInfo searchReportInfo;
        String keyword;
        String str3;
        String str4;
        SearchText contentTitle = model.getContentTitle();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        SearchJump searchJump = null;
        if (contentTitle != null) {
            str = contentTitle.text;
        } else {
            str = null;
        }
        boolean z17 = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        booleanRef.element = !z16;
        TextView textView = this.binding.f405604c;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.cardContentTitle");
        p.b(textView, booleanRef.element);
        TextView textView2 = this.binding.f405604c;
        String str5 = "";
        if (!booleanRef.element) {
            charSequence = "";
        } else {
            q qVar = new q(model.getNineBoxGrid().richText);
            if (contentTitle != null) {
                str3 = contentTitle.text;
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "contentTitle?.text ?: \"\"");
            }
            qVar.e(str3);
            com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = this.section.getDtReportIoc();
            if (dtReportIoc == null || (str4 = dtReportIoc.getKeyword()) == null) {
                str4 = "";
            }
            qVar.f(str4);
            Context context = this.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            charSequence = qVar.g(context, new Function1<SearchText, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$showContentInfo$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SearchText searchText) {
                    invoke2(searchText);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SearchText searchText) {
                    Intrinsics.checkNotNullParameter(searchText, "searchText");
                    NetSearchMultiMediaCard.I(NetSearchMultiMediaCard.this, searchText.jumpLink, null, 2, null);
                }
            });
        }
        textView2.setText(charSequence);
        SearchText text = model.getText();
        if (text != null) {
            str2 = text.text;
        } else {
            str2 = null;
        }
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        }
        if (z17) {
            this.binding.f405603b.setVisibility(8);
            this.binding.f405603b.setOnClickListener(null);
            return;
        }
        q contentRichText = model.getContentRichText();
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc2 = this.section.getDtReportIoc();
        if (dtReportIoc2 != null && (keyword = dtReportIoc2.getKeyword()) != null) {
            str5 = keyword;
        }
        contentRichText.f(str5);
        this.binding.f405603b.setVisibility(0);
        Context context2 = this.context;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        SpannableString g16 = contentRichText.g(context2, new Function1<SearchText, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$showContentInfo$text$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchText searchText) {
                invoke2(searchText);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SearchText searchText) {
                Intrinsics.checkNotNullParameter(searchText, "searchText");
                NetSearchMultiMediaCard.I(NetSearchMultiMediaCard.this, searchText.jumpLink, null, 2, null);
            }
        });
        rn2.j jVar = rn2.j.f431768a;
        TextView textView3 = this.binding.f405603b;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.cardContent");
        jVar.s(textView3, g16);
        TextView textView4 = this.binding.f405603b;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.cardContent");
        p.a(textView4, new Function1<ConstraintLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$showContentInfo$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConstraintLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConstraintLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                if (Ref.BooleanRef.this.element) {
                    ((ViewGroup.MarginLayoutParams) updateLayoutParams).topMargin = ViewUtils.dpToPx(4.0f);
                } else {
                    ((ViewGroup.MarginLayoutParams) updateLayoutParams).topMargin = ViewUtils.dpToPx(10.0f);
                }
            }
        });
        com.tencent.mobileqq.search.searchdetail.util.f fVar = com.tencent.mobileqq.search.searchdetail.util.f.f284742a;
        TextView textView5 = this.binding.f405603b;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.cardContent");
        SearchText text2 = model.getText();
        if (text2 != null) {
            searchReportInfo = text2.reportInfo;
        } else {
            searchReportInfo = null;
        }
        com.tencent.mobileqq.search.searchdetail.util.f.b(fVar, textView5, searchReportInfo, model.getCommonInfo().getItemId(), null, 8, null);
        SearchText text3 = model.getText();
        if (text3 != null) {
            searchJump = text3.jumpLink;
        }
        if (searchJump != null) {
            this.binding.f405603b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NetSearchMultiMediaCard.f0(NetSearchMultiMediaCard.this, model, view);
                }
            });
        } else {
            this.binding.f405603b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NetSearchMultiMediaCard.g0(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(NetSearchMultiMediaCard this$0, NetSearchTemplateNineBoxGridItem model, View view) {
        SearchJump searchJump;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "$model");
        SearchText text = model.getText();
        if (text != null) {
            searchJump = text.jumpLink;
        } else {
            searchJump = null;
        }
        I(this$0, searchJump, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void h0(final NetSearchTemplateNineBoxGridItem model) {
        String str;
        boolean z16;
        String str2;
        String str3;
        boolean z17;
        String str4;
        boolean z18;
        boolean z19;
        final SearchIcon describe = model.getDescribe();
        Context context = this.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String P = model.P(context);
        SearchText searchText = describe.title;
        String str5 = null;
        if (searchText != null) {
            str = searchText.text;
        } else {
            str = null;
        }
        boolean z26 = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            SearchText searchText2 = describe.subTitle;
            if (searchText2 != null) {
                str4 = searchText2.text;
            } else {
                str4 = null;
            }
            if (str4 != null && str4.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                if (P.length() == 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    this.binding.f405610i.setVisibility(8);
                    return;
                }
            }
        }
        this.binding.f405610i.setVisibility(0);
        TextView textView = this.binding.f405611j;
        SearchText searchText3 = describe.subTitle;
        String str6 = "";
        if (searchText3 == null || (str2 = searchText3.text) == null) {
            str2 = "";
        }
        textView.setText(str2);
        this.binding.f405610i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchMultiMediaCard.i0(SearchIcon.this, model, this, view);
            }
        });
        this.binding.f405607f.setText(P);
        SearchIcon contentIcon = model.getContentIcon();
        if (contentIcon != null) {
            str3 = contentIcon.visibleRangeIconLink;
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        if (str3.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            this.binding.D.setVisibility(8);
        } else {
            this.binding.D.setVisibility(0);
            ImageView imageView = this.binding.D;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.visibleRangeIcon");
            K(imageView, str3);
        }
        SearchIcon contentIcon2 = model.getContentIcon();
        if (contentIcon2 != null) {
            str5 = contentIcon2.visibleRangeTitleText;
        }
        if (str5 != null) {
            str6 = str5;
        }
        if (str6.length() != 0) {
            z26 = false;
        }
        if (z26) {
            this.binding.E.setVisibility(8);
        } else {
            this.binding.E.setVisibility(0);
            this.binding.E.setText(str6);
        }
        this.binding.f405610i.post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.e
            @Override // java.lang.Runnable
            public final void run() {
                NetSearchMultiMediaCard.j0(NetSearchMultiMediaCard.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(SearchIcon searchIcon, NetSearchTemplateNineBoxGridItem model, NetSearchMultiMediaCard this$0, View view) {
        SearchJump searchJump;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(model, "$model");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchText searchText = searchIcon.subTitle;
        if (searchText != null) {
            searchJump = searchText.jumpLink;
        } else {
            searchJump = null;
        }
        if (searchJump == null) {
            searchJump = searchIcon.jumpLink;
        }
        if (searchJump == null) {
            searchJump = model.getJumpLink();
        }
        I(this$0, searchJump, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(NetSearchMultiMediaCard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int width = this$0.binding.f405610i.getWidth();
        if (width > 0) {
            am amVar = this$0.binding;
            amVar.f405611j.setMaxWidth(((width - amVar.f405607f.getWidth()) - this$0.binding.E.getWidth()) - this$0.binding.D.getWidth());
        }
    }

    private final void k0(NetSearchTemplateNineBoxGridItem model) {
        SearchIcon contentIcon = model.getContentIcon();
        if (contentIcon == null) {
            return;
        }
        int i3 = contentIcon.iconType;
        if (i3 != 1) {
            if (i3 == 2) {
                ab.d(this.binding.f405605d.s(), ViewUtils.dpToPx(5.0f));
            }
        } else {
            ab.d(this.binding.f405605d.s(), ViewUtils.dpToPx(19.0f));
        }
        ImageView s16 = this.binding.f405605d.s();
        String str = contentIcon.iconLink;
        Intrinsics.checkNotNullExpressionValue(str, "iconNonNull.iconLink");
        K(s16, str);
    }

    private final void l0(NetSearchTemplateNineBoxGridItem model) {
        long j3;
        long j16;
        Object findViewById = this.binding.f405616o.findViewById(R.id.xpk);
        SearchInteractiveComponents searchInteractiveComponents = model.getNineBoxGrid().interactiveComponents;
        Object obj = null;
        if (searchInteractiveComponents != null) {
            ArrayList arrayList = new ArrayList();
            SearchIcon searchIcon = searchInteractiveComponents.likeIcon;
            Intrinsics.checkNotNullExpressionValue(searchIcon, "originData.likeIcon");
            String itemId = model.getCommonInfo().getItemId();
            SearchReportInfo searchReportInfo = searchInteractiveComponents.likeIcon.reportInfo;
            Long l3 = model.l();
            long j17 = 0;
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            arrayList.add(new SearchInteractiveData("like", searchIcon, itemId, searchReportInfo, j3, model.k(), model.getCommonInfo().getTraceId(), new NetSearchMultiMediaCard$showInterActiveInfo$1$interactiveDataList$1$1(this)));
            SearchIcon searchIcon2 = searchInteractiveComponents.commentIcon;
            Intrinsics.checkNotNullExpressionValue(searchIcon2, "originData.commentIcon");
            String itemId2 = model.getCommonInfo().getItemId();
            SearchReportInfo searchReportInfo2 = searchInteractiveComponents.commentIcon.reportInfo;
            Long l16 = model.l();
            if (l16 != null) {
                j16 = l16.longValue();
            } else {
                j16 = 0;
            }
            arrayList.add(new SearchInteractiveData("comment", searchIcon2, itemId2, searchReportInfo2, j16, model.k(), model.getCommonInfo().getTraceId(), new NetSearchMultiMediaCard$showInterActiveInfo$1$interactiveDataList$1$2(this)));
            SearchIcon searchIcon3 = searchInteractiveComponents.shareIcon;
            Intrinsics.checkNotNullExpressionValue(searchIcon3, "originData.shareIcon");
            String itemId3 = model.getCommonInfo().getItemId();
            SearchReportInfo searchReportInfo3 = searchInteractiveComponents.shareIcon.reportInfo;
            Long l17 = model.l();
            if (l17 != null) {
                j17 = l17.longValue();
            }
            arrayList.add(new SearchInteractiveData("share", searchIcon3, itemId3, searchReportInfo3, j17, model.k(), model.getCommonInfo().getTraceId(), new NetSearchMultiMediaCard$showInterActiveInfo$1$interactiveDataList$1$3(this)));
            if (findViewById == null) {
                Object inflate = this.binding.f405614m.inflate();
                if (inflate instanceof SearchInteractiveView) {
                    obj = (SearchInteractiveView) inflate;
                }
                findViewById = obj;
            }
            SearchInteractiveView searchInteractiveView = (SearchInteractiveView) findViewById;
            if (searchInteractiveView != null) {
                searchInteractiveView.setData(arrayList);
            }
            if (searchInteractiveView != null) {
                searchInteractiveView.setVisibility(0);
            }
            obj = Unit.INSTANCE;
        }
        if (obj == null) {
            QLog.e("QQSearch.NetDetail.SearchDetailMultiMediaCard", 1, "interactiveComponents is null, set interactiveView to be gone!!!");
            SearchInteractiveView searchInteractiveView2 = (SearchInteractiveView) findViewById;
            if (searchInteractiveView2 != null) {
                searchInteractiveView2.setVisibility(8);
            }
        }
    }

    private final void m0(final NetSearchTemplateNineBoxGridItem model, int position) {
        String str;
        Object obj;
        Unit unit;
        String str2;
        SearchGuildJump searchGuildJump;
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = this.section.getDtReportIoc();
        if (dtReportIoc == null || (str = dtReportIoc.getKeyword()) == null) {
            str = "";
        }
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc2 = this.section.getDtReportIoc();
        boolean z16 = true;
        if (dtReportIoc2 != null) {
            obj = Long.valueOf(dtReportIoc2.getTabMask());
        } else {
            obj = 1;
        }
        final com.tencent.mobileqq.search.searchdetail.content.template.model.k buttonInfo = model.getButtonInfo();
        if (buttonInfo != null) {
            SearchJump jumpInfo = buttonInfo.getJumpInfo();
            if (jumpInfo == null || (searchGuildJump = jumpInfo.guildJump) == null || !com.tencent.mobileqq.search.searchdetail.content.template.model.o.b(searchGuildJump)) {
                z16 = false;
            }
            if (!z16 && buttonInfo.getButtonType() == 3) {
                this.binding.B.setVisibility(0);
                if (buttonInfo.getJoinGuildStatus() != 0) {
                    rn2.j jVar = rn2.j.f431768a;
                    TextView textView = this.binding.B;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.tvRightJoinButton");
                    rn2.j.u(jVar, textView, "QQSearch.NetDetail.SearchDetailMultiMediaCard", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$showJoinBtn$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull View it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            NetSearchMultiMediaCard netSearchMultiMediaCard = NetSearchMultiMediaCard.this;
                            SearchIcon contentIcon = model.getContentIcon();
                            NetSearchMultiMediaCard.I(netSearchMultiMediaCard, contentIcon != null ? contentIcon.jumpLink : null, null, 2, null);
                        }
                    }, 2, null);
                } else {
                    boolean areEqual = Intrinsics.areEqual(obj, (Object) 3L);
                    boolean b16 = NetSearchVerticalDetailTemplateItem.INSTANCE.b(str);
                    if (areEqual) {
                        if (b16) {
                            str2 = "qq_network_search_channel_sub_tab_searchid";
                        } else {
                            str2 = "qq_network_search_channel_sub_tab_keyword";
                        }
                    } else if (b16) {
                        str2 = "qq_network_search_channel_all_tab_searchid";
                    } else {
                        str2 = "qq_network_search_channel_all_tab_keyword";
                    }
                    buttonInfo.e().put("subSource", str2);
                    rn2.j jVar2 = rn2.j.f431768a;
                    TextView textView2 = this.binding.B;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvRightJoinButton");
                    rn2.j.u(jVar2, textView2, "QQSearch.NetDetail.SearchDetailMultiMediaCard", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$showJoinBtn$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull View it) {
                            MultiMediaSection multiMediaSection;
                            Intrinsics.checkNotNullParameter(it, "it");
                            multiMediaSection = NetSearchMultiMediaCard.this.section;
                            multiMediaSection.d(buttonInfo.getJumpInfo(), buttonInfo.e());
                        }
                    }, 2, null);
                }
                this.binding.B.setText(buttonInfo.getText());
                com.tencent.mobileqq.search.searchdetail.content.template.f.a(buttonInfo.getStatus(), this.binding.B);
                SearchReportInfo reportInfo = buttonInfo.getReportInfo();
                if (reportInfo != null) {
                    com.tencent.mobileqq.search.searchdetail.r rVar = com.tencent.mobileqq.search.searchdetail.r.f284572a;
                    TextView textView3 = this.binding.B;
                    Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvRightJoinButton");
                    String str3 = reportInfo.eid;
                    Intrinsics.checkNotNullExpressionValue(str3, "reportInfo.eid");
                    rVar.e(textView3, str3, this.section.T(position));
                }
            } else {
                this.binding.B.setVisibility(8);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.binding.B.setVisibility(8);
        }
    }

    private final void n0(NetSearchTemplateNineBoxGridItem model) {
        View view;
        this.rootWidthObservable.d();
        R(v());
        if (model.getIsContainVideo()) {
            E();
            D();
            s0(model);
            NetSearchMultiMediaVideoView netSearchMultiMediaVideoView = this.binding.A;
            Intrinsics.checkNotNullExpressionValue(netSearchMultiMediaVideoView, "binding.singleVideo");
            w(netSearchMultiMediaVideoView);
            return;
        }
        if (model.J().size() == 1 && model.J().get(0).size() == 1) {
            D();
            F();
            q0(model);
            ImageFilterView imageFilterView = this.binding.f405627z;
            Intrinsics.checkNotNullExpressionValue(imageFilterView, "binding.singleImage");
            w(imageFilterView);
            return;
        }
        E();
        F();
        o0(model);
        if (this.binding.f405623v.getVisibility() == 0) {
            view = this.binding.f405623v;
            Intrinsics.checkNotNullExpressionValue(view, "binding.picture6");
        } else if (this.binding.f405620s.getVisibility() == 0) {
            view = this.binding.f405620s;
            Intrinsics.checkNotNullExpressionValue(view, "binding.picture3");
        } else if (this.binding.f405617p.getVisibility() == 0) {
            view = this.binding.f405617p;
            Intrinsics.checkNotNullExpressionValue(view, "binding.picture0");
        } else {
            view = this.binding.f405603b;
            Intrinsics.checkNotNullExpressionValue(view, "binding.cardContent");
        }
        w(view);
    }

    private final void o0(NetSearchTemplateNineBoxGridItem model) {
        int i3;
        Object last;
        Object last2;
        boolean z16;
        int i16;
        Object orNull;
        final SearchNineBoxContent searchNineBoxContent;
        boolean z17;
        Object orNull2;
        int size = this.nineGridImageViews.size();
        int i17 = 0;
        while (true) {
            i3 = 8;
            if (i17 >= size) {
                break;
            }
            int size2 = this.nineGridImageViews.get(i17).size();
            for (int i18 = 0; i18 < size2; i18++) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(model.J(), i17);
                List list = (List) orNull;
                if (list != null) {
                    orNull2 = CollectionsKt___CollectionsKt.getOrNull(list, i18);
                    searchNineBoxContent = (SearchNineBoxContent) orNull2;
                } else {
                    searchNineBoxContent = null;
                }
                ImageFilterView imageFilterView = this.nineGridImageViews.get(i17).get(i18);
                Intrinsics.checkNotNullExpressionValue(imageFilterView, "nineGridImageViews[columnIndex][rowIndex]");
                ImageFilterView imageFilterView2 = imageFilterView;
                String C = C(searchNineBoxContent);
                if (searchNineBoxContent != null) {
                    if (C != null && C.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        imageFilterView2.setVisibility(0);
                        U(i17, i18, searchNineBoxContent);
                        K(imageFilterView2, C);
                        imageFilterView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.f
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                NetSearchMultiMediaCard.p0(NetSearchMultiMediaCard.this, searchNineBoxContent, view);
                            }
                        });
                        com.tencent.mobileqq.search.searchdetail.util.f.b(com.tencent.mobileqq.search.searchdetail.util.f.f284742a, imageFilterView2, searchNineBoxContent.reportInfo, model.getCommonInfo().getItemId(), null, 8, null);
                    }
                }
                imageFilterView2.setVisibility(8);
                View view = this.nineGridImagePlayIconViews[i17][i18];
                if (view != null) {
                    view.setVisibility(8);
                }
            }
            i17++;
        }
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.nineGridImageViews);
        last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) last);
        Intrinsics.checkNotNullExpressionValue(last2, "nineGridImageViews.last().last()");
        if (((ImageFilterView) last2).getVisibility() == 0 && model.getMoreCount() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        TextView textView = this.binding.f405615n;
        if (z16) {
            i3 = 0;
        }
        textView.setVisibility(i3);
        TextView textView2 = this.binding.f405615n;
        Context context = this.context;
        Object[] objArr = new Object[1];
        ArrayList<SearchNineBoxContent> arrayList = model.getNineBoxGrid().contentList;
        if (arrayList != null) {
            i16 = arrayList.size();
        } else {
            i16 = 0;
        }
        objArr[0] = Integer.valueOf(i16);
        textView2.setText(context.getString(R.string.f224476j1, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(NetSearchMultiMediaCard this$0, SearchNineBoxContent searchNineBoxContent, View view) {
        SearchPicture searchPicture;
        SearchJump searchJump;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.G(searchNineBoxContent)) {
            SearchVideo searchVideo = searchNineBoxContent.video;
            if (searchVideo != null) {
                searchJump = searchVideo.jumpLink;
            }
            searchJump = null;
        } else {
            SearchPictureDetail searchPictureDetail = searchNineBoxContent.picture;
            if (searchPictureDetail != null && (searchPicture = searchPictureDetail.small) != null) {
                searchJump = searchPicture.jumpLink;
            }
            searchJump = null;
        }
        I(this$0, searchJump, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q() {
        Float f16;
        SearchIcon contentIcon;
        SearchText searchText;
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem = this.contentModel;
        String str = null;
        if (netSearchTemplateNineBoxGridItem != null) {
            f16 = Float.valueOf(netSearchTemplateNineBoxGridItem.getVideoRatio());
        } else {
            f16 = null;
        }
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem2 = this.contentModel;
        if (netSearchTemplateNineBoxGridItem2 != null && (contentIcon = netSearchTemplateNineBoxGridItem2.getContentIcon()) != null && (searchText = contentIcon.title) != null) {
            str = searchText.text;
        }
        L("adjustSingleVideoFor11,videoRatio:" + f16 + ",title:" + str);
        NetSearchMultiMediaVideoView netSearchMultiMediaVideoView = this.binding.A;
        Intrinsics.checkNotNullExpressionValue(netSearchMultiMediaVideoView, "binding.singleVideo");
        p.a(netSearchMultiMediaVideoView, new Function1<ConstraintLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$adjustSingleVideoFor11$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConstraintLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConstraintLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                updateLayoutParams.setMarginEnd(ViewUtils.dpToPx(1.0f));
                ((ViewGroup.MarginLayoutParams) updateLayoutParams).height = 0;
                updateLayoutParams.endToEnd = NetSearchMultiMediaCard.this.getBinding().f405612k.getId();
                updateLayoutParams.dimensionRatio = "1:1";
            }
        });
    }

    private final void q0(final NetSearchTemplateNineBoxGridItem model) {
        Object firstOrNull;
        SearchNineBoxContent searchNineBoxContent;
        String str;
        boolean z16;
        boolean z17;
        SearchPictureDetail searchPictureDetail;
        SearchPicture searchPicture;
        Object firstOrNull2;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) model.J());
        List list = (List) firstOrNull;
        SearchReportInfo searchReportInfo = null;
        if (list != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            searchNineBoxContent = (SearchNineBoxContent) firstOrNull2;
        } else {
            searchNineBoxContent = null;
        }
        if (searchNineBoxContent != null && (searchPictureDetail = searchNineBoxContent.picture) != null && (searchPicture = searchPictureDetail.large) != null) {
            str = searchPicture.picLink;
        } else {
            str = null;
        }
        boolean z18 = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.binding.f405627z.setVisibility(0);
            return;
        }
        this.binding.f405627z.setVisibility(0);
        this.binding.f405627z.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchMultiMediaCard.r0(NetSearchTemplateNineBoxGridItem.this, this, view);
            }
        });
        ImageFilterView imageFilterView = this.binding.f405627z;
        Intrinsics.checkNotNullExpressionValue(imageFilterView, "binding.singleImage");
        K(imageFilterView, str);
        float a16 = com.tencent.mobileqq.search.searchdetail.content.template.model.o.a(searchNineBoxContent);
        if (a16 == 1.0f) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            T("1:1");
        } else if (a16 > 1.0f) {
            S("4:3");
        } else if (a16 < 1.0f) {
            T("3:4");
        }
        TextView textView = this.binding.f405626y;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.showBigImage");
        if (a16 >= 0.33333334f) {
            z18 = false;
        }
        p.b(textView, z18);
        com.tencent.mobileqq.search.searchdetail.util.f fVar = com.tencent.mobileqq.search.searchdetail.util.f.f284742a;
        ImageFilterView imageFilterView2 = this.binding.f405627z;
        Intrinsics.checkNotNullExpressionValue(imageFilterView2, "binding.singleImage");
        SearchNineBoxContent z19 = model.z();
        if (z19 != null) {
            searchReportInfo = z19.reportInfo;
        }
        com.tencent.mobileqq.search.searchdetail.util.f.b(fVar, imageFilterView2, searchReportInfo, model.getCommonInfo().getItemId(), null, 8, null);
    }

    private final void r() {
        Float f16;
        SearchIcon contentIcon;
        SearchText searchText;
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem = this.contentModel;
        String str = null;
        if (netSearchTemplateNineBoxGridItem != null) {
            f16 = Float.valueOf(netSearchTemplateNineBoxGridItem.getVideoRatio());
        } else {
            f16 = null;
        }
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem2 = this.contentModel;
        if (netSearchTemplateNineBoxGridItem2 != null && (contentIcon = netSearchTemplateNineBoxGridItem2.getContentIcon()) != null && (searchText = contentIcon.title) != null) {
            str = searchText.text;
        }
        L("adjustSingleVideoFor16To9,videoRatio:" + f16 + ",title:" + str);
        NetSearchMultiMediaVideoView netSearchMultiMediaVideoView = this.binding.A;
        Intrinsics.checkNotNullExpressionValue(netSearchMultiMediaVideoView, "binding.singleVideo");
        x0(netSearchMultiMediaVideoView, new Function2<ConstraintLayout.LayoutParams, Integer, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$adjustSingleVideoFor16To9$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ConstraintLayout.LayoutParams layoutParams, Integer num) {
                invoke(layoutParams, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintLayout.LayoutParams updateLayoutParamsWithListener, int i3) {
                Intrinsics.checkNotNullParameter(updateLayoutParamsWithListener, "$this$updateLayoutParamsWithListener");
                updateLayoutParamsWithListener.setMarginEnd(0);
                ((ViewGroup.MarginLayoutParams) updateLayoutParamsWithListener).height = i3;
                updateLayoutParamsWithListener.endToEnd = -1;
                updateLayoutParamsWithListener.dimensionRatio = "16:9";
            }
        }, this.rootWidthObservable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(NetSearchTemplateNineBoxGridItem model, NetSearchMultiMediaCard this$0, View view) {
        SearchJump searchJump;
        SearchPictureDetail searchPictureDetail;
        SearchPicture searchPicture;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(model, "$model");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchNineBoxContent z16 = model.z();
        if (z16 != null && (searchPictureDetail = z16.picture) != null && (searchPicture = searchPictureDetail.large) != null) {
            searchJump = searchPicture.jumpLink;
        } else {
            searchJump = null;
        }
        QLog.d("QQSearch.NetDetail.SearchDetailMultiMediaCard", 1, "single image onclick:" + searchJump);
        I(this$0, searchJump, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s() {
        Float f16;
        SearchIcon contentIcon;
        SearchText searchText;
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem = this.contentModel;
        String str = null;
        if (netSearchTemplateNineBoxGridItem != null) {
            f16 = Float.valueOf(netSearchTemplateNineBoxGridItem.getVideoRatio());
        } else {
            f16 = null;
        }
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem2 = this.contentModel;
        if (netSearchTemplateNineBoxGridItem2 != null && (contentIcon = netSearchTemplateNineBoxGridItem2.getContentIcon()) != null && (searchText = contentIcon.title) != null) {
            str = searchText.text;
        }
        L("adjustSingleVideoFor34,videoRatio:" + f16 + ",title:" + str);
        NetSearchMultiMediaVideoView netSearchMultiMediaVideoView = this.binding.A;
        Intrinsics.checkNotNullExpressionValue(netSearchMultiMediaVideoView, "binding.singleVideo");
        p.a(netSearchMultiMediaVideoView, new Function1<ConstraintLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$adjustSingleVideoFor34$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConstraintLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConstraintLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                updateLayoutParams.setMarginEnd(ViewUtils.dpToPx(1.0f));
                ((ViewGroup.MarginLayoutParams) updateLayoutParams).height = 0;
                updateLayoutParams.endToEnd = NetSearchMultiMediaCard.this.getBinding().f405612k.getId();
                updateLayoutParams.dimensionRatio = "3:4";
            }
        });
    }

    private final void s0(final NetSearchTemplateNineBoxGridItem model) {
        Float f16;
        String str;
        SearchText searchText;
        SearchText searchText2;
        SearchIcon contentIcon;
        SearchText searchText3;
        FeedCloudMeta$StFeed singleVideoData = model.getSingleVideoData();
        if (singleVideoData == null) {
            QLog.e("QQSearch.NetDetail.SearchDetailMultiMediaCard", 1, "showSingleVideo but stFeedData is null, something wrong");
            this.binding.A.setVisibility(8);
            return;
        }
        this.binding.A.setDataSource(singleVideoData, model);
        float videoRatio = model.getVideoRatio();
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem = this.contentModel;
        SearchReportInfo searchReportInfo = null;
        if (netSearchTemplateNineBoxGridItem != null) {
            f16 = Float.valueOf(netSearchTemplateNineBoxGridItem.getVideoRatio());
        } else {
            f16 = null;
        }
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem2 = this.contentModel;
        if (netSearchTemplateNineBoxGridItem2 != null && (contentIcon = netSearchTemplateNineBoxGridItem2.getContentIcon()) != null && (searchText3 = contentIcon.title) != null) {
            str = searchText3.text;
        } else {
            str = null;
        }
        L("showSingleVideo,videoRatio:" + f16 + ",title:" + str + ",rootWidthPercent33:" + B());
        int d16 = o.f284545a.d(videoRatio);
        if (d16 != 0) {
            if (d16 != 1) {
                if (d16 != 2) {
                    if (d16 != 3) {
                        if (d16 == 4) {
                            r();
                        }
                    } else {
                        t();
                    }
                } else {
                    q();
                }
            } else {
                s();
            }
        } else {
            u();
        }
        this.binding.A.setVisibility(0);
        this.binding.A.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchMultiMediaCard.t0(NetSearchTemplateNineBoxGridItem.this, this, view);
            }
        });
        if (model.getPlayState() == 1) {
            SearchIcon contentIcon2 = model.getContentIcon();
            if (contentIcon2 != null) {
                searchText2 = contentIcon2.title;
            } else {
                searchText2 = null;
            }
            QLog.d("QQSearch.NetDetail.SearchDetailMultiMediaCard", 4, "start play for " + searchText2);
            NetSearchMultiMediaVideoView netSearchMultiMediaVideoView = this.binding.A;
            Intrinsics.checkNotNullExpressionValue(netSearchMultiMediaVideoView, "binding.singleVideo");
            NetSearchMultiMediaVideoView.T0(netSearchMultiMediaVideoView, false, 1, null);
        } else if (model.getPlayState() == 0) {
            SearchIcon contentIcon3 = model.getContentIcon();
            if (contentIcon3 != null) {
                searchText = contentIcon3.title;
            } else {
                searchText = null;
            }
            QLog.d("QQSearch.NetDetail.SearchDetailMultiMediaCard", 4, "stop play for " + searchText);
            this.binding.A.U0();
        }
        com.tencent.mobileqq.search.searchdetail.util.f fVar = com.tencent.mobileqq.search.searchdetail.util.f.f284742a;
        NetSearchMultiMediaVideoView netSearchMultiMediaVideoView2 = this.binding.A;
        Intrinsics.checkNotNullExpressionValue(netSearchMultiMediaVideoView2, "binding.singleVideo");
        SearchNineBoxContent videoItem = model.getVideoItem();
        if (videoItem != null) {
            searchReportInfo = videoItem.reportInfo;
        }
        com.tencent.mobileqq.search.searchdetail.util.f.b(fVar, netSearchMultiMediaVideoView2, searchReportInfo, model.getCommonInfo().getItemId(), null, 8, null);
    }

    private final void t() {
        Float f16;
        SearchIcon contentIcon;
        SearchText searchText;
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem = this.contentModel;
        String str = null;
        if (netSearchTemplateNineBoxGridItem != null) {
            f16 = Float.valueOf(netSearchTemplateNineBoxGridItem.getVideoRatio());
        } else {
            f16 = null;
        }
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem2 = this.contentModel;
        if (netSearchTemplateNineBoxGridItem2 != null && (contentIcon = netSearchTemplateNineBoxGridItem2.getContentIcon()) != null && (searchText = contentIcon.title) != null) {
            str = searchText.text;
        }
        L("adjustSingleVideoFor43,videoRatio:" + f16 + ",title:" + str);
        NetSearchMultiMediaVideoView netSearchMultiMediaVideoView = this.binding.A;
        Intrinsics.checkNotNullExpressionValue(netSearchMultiMediaVideoView, "binding.singleVideo");
        x0(netSearchMultiMediaVideoView, new Function2<ConstraintLayout.LayoutParams, Integer, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$adjustSingleVideoFor43$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ConstraintLayout.LayoutParams layoutParams, Integer num) {
                invoke(layoutParams, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintLayout.LayoutParams updateLayoutParamsWithListener, int i3) {
                Intrinsics.checkNotNullParameter(updateLayoutParamsWithListener, "$this$updateLayoutParamsWithListener");
                updateLayoutParamsWithListener.setMarginEnd(0);
                ((ViewGroup.MarginLayoutParams) updateLayoutParamsWithListener).height = i3;
                updateLayoutParamsWithListener.endToEnd = -1;
                updateLayoutParamsWithListener.dimensionRatio = "4:3";
            }
        }, this.rootWidthObservable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(NetSearchTemplateNineBoxGridItem model, NetSearchMultiMediaCard this$0, View view) {
        SearchJump searchJump;
        SearchVideo searchVideo;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(model, "$model");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchNineBoxContent videoItem = model.getVideoItem();
        if (videoItem != null && (searchVideo = videoItem.video) != null) {
            searchJump = searchVideo.jumpLink;
        } else {
            searchJump = null;
        }
        QLog.d("QQSearch.NetDetail.SearchDetailMultiMediaCard", 1, "single video onclick:" + searchJump);
        I(this$0, searchJump, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void u() {
        Float f16;
        SearchIcon contentIcon;
        SearchText searchText;
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem = this.contentModel;
        String str = null;
        if (netSearchTemplateNineBoxGridItem != null) {
            f16 = Float.valueOf(netSearchTemplateNineBoxGridItem.getVideoRatio());
        } else {
            f16 = null;
        }
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem2 = this.contentModel;
        if (netSearchTemplateNineBoxGridItem2 != null && (contentIcon = netSearchTemplateNineBoxGridItem2.getContentIcon()) != null && (searchText = contentIcon.title) != null) {
            str = searchText.text;
        }
        L("adjustSingleVideoFor9To16,videoRatio:" + f16 + ",title:" + str);
        NetSearchMultiMediaVideoView netSearchMultiMediaVideoView = this.binding.A;
        Intrinsics.checkNotNullExpressionValue(netSearchMultiMediaVideoView, "binding.singleVideo");
        p.a(netSearchMultiMediaVideoView, new Function1<ConstraintLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$adjustSingleVideoFor9To16$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConstraintLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConstraintLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                updateLayoutParams.setMarginEnd(ViewUtils.dpToPx(1.0f));
                ((ViewGroup.MarginLayoutParams) updateLayoutParams).height = 0;
                updateLayoutParams.endToEnd = NetSearchMultiMediaCard.this.getBinding().f405612k.getId();
                updateLayoutParams.dimensionRatio = "9:16";
            }
        });
    }

    private final void u0(NetSearchTemplateNineBoxGridItem model, int position) {
        String str;
        boolean z16;
        Object m476constructorimpl;
        SearchText searchText;
        final SearchIcon contentIcon = model.getContentIcon();
        if (contentIcon != null && (searchText = contentIcon.title) != null) {
            str = searchText.text;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.binding.f405608g.setOnClickListener(null);
            this.binding.f405608g.setVisibility(8);
            return;
        }
        this.binding.f405608g.setVisibility(0);
        this.binding.f405608g.setText(str);
        this.binding.f405608g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchMultiMediaCard.v0(NetSearchMultiMediaCard.this, contentIcon, view);
            }
        });
        try {
            Result.Companion companion = Result.INSTANCE;
            SearchIcon titleTag = model.getTitleTag();
            Intrinsics.checkNotNullExpressionValue(titleTag, "model.titleTag");
            ImageView imageView = this.binding.C;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.vBadge");
            m476constructorimpl = Result.m476constructorimpl(Boolean.valueOf(com.tencent.mobileqq.search.searchdetail.util.e.b(titleTag, imageView)));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            m476constructorimpl = Boolean.FALSE;
        }
        if (((Boolean) m476constructorimpl).booleanValue()) {
            this.binding.C.setVisibility(0);
        } else {
            this.binding.C.setVisibility(8);
        }
        m0(model, position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(NetSearchMultiMediaCard this$0, SearchIcon searchIcon, View view) {
        SearchJump searchJump;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchText searchText = searchIcon.title;
        if (searchText != null) {
            searchJump = searchText.jumpLink;
        } else {
            searchJump = null;
        }
        I(this$0, searchJump, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w(final View targetView) {
        LinearLayout linearLayout = this.binding.f405610i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.footAuthorContainer");
        p.a(linearLayout, new Function1<ConstraintLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$changeFootTop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConstraintLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConstraintLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                updateLayoutParams.topToBottom = targetView.getId();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void w0(NetSearchTemplateNineBoxGridItem model) {
        Long longOrNull;
        ab.d(this.binding.f405605d.s(), ViewUtils.dpToPx(5.0f));
        SearchIcon contentIcon = model.getContentIcon();
        if (contentIcon != null && (r4 = contentIcon.uin) != null && longOrNull != null) {
            this.binding.f405605d.w(1, String.valueOf(longOrNull.longValue()));
        }
    }

    private final int z(int colorId) {
        return this.context.getColor(colorId);
    }

    @Nullable
    /* renamed from: A, reason: from getter */
    public final NetSearchTemplateNineBoxGridItem getContentModel() {
        return this.contentModel;
    }

    public final float B() {
        return this.rootWidthObservable.b();
    }

    public final void J(@Nullable SearchJump jumpInfo) {
        String str;
        String str2;
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem;
        List<com.tencent.mobileqq.search.searchdetail.c> c16;
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem2;
        FeedCloudMeta$StFeed singleVideoData;
        if (jumpInfo != null) {
            str = jumpInfo.jumpLink;
        } else {
            str = null;
        }
        if (jumpInfo != null) {
            str2 = jumpInfo.jumpAndLink;
        } else {
            str2 = null;
        }
        QLog.d("QQSearch.NetDetail.SearchDetailMultiMediaCard", 1, "jumpVideoInfo " + str + "," + str2);
        if (jumpInfo == null || (netSearchTemplateNineBoxGridItem = this.contentModel) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("playIndex", 0);
        jSONObject.put("playPosition", 0);
        jSONObject.put("sourceType", 70);
        jSONObject.put("subSourceType", 0);
        jSONObject.put("useOneDragN", false);
        jSONObject.put("keyword", "");
        jSONObject.put("pageName", "qsearch_detail");
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.search.searchdetail.content.part.r r16 = this.section.r();
        if (r16 != null && (c16 = r16.c(netSearchTemplateNineBoxGridItem)) != null) {
            for (com.tencent.mobileqq.search.searchdetail.c cVar : c16) {
                if (cVar instanceof NetSearchTemplateNineBoxGridItem) {
                    netSearchTemplateNineBoxGridItem2 = (NetSearchTemplateNineBoxGridItem) cVar;
                } else {
                    netSearchTemplateNineBoxGridItem2 = null;
                }
                if (netSearchTemplateNineBoxGridItem2 != null && (singleVideoData = netSearchTemplateNineBoxGridItem2.getSingleVideoData()) != null) {
                    arrayList.add(singleVideoData);
                }
            }
        }
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).iniSdkConfig();
        IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
        if (qCircleApi != null) {
            Context context = this.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            qCircleApi.launchQCircleFeed(context, arrayList, String.valueOf(hashCode()), jSONObject);
        }
    }

    public final void K(@NotNull ImageView imageView, @NotNull String url) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(url, "url");
        o.g(o.f284545a, "QQSearch.NetDetail.SearchDetailMultiMediaCard", imageView, url, null, 8, null);
    }

    public final void P(@NotNull Function0<Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.binding.A.setClickPlayIconListener(cb5);
    }

    public final void Q(boolean visible) {
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem;
        if (!visible && (netSearchTemplateNineBoxGridItem = this.contentModel) != null && netSearchTemplateNineBoxGridItem.isPlaying()) {
            netSearchTemplateNineBoxGridItem.Y(0);
            x(netSearchTemplateNineBoxGridItem);
        }
    }

    public final void R(float f16) {
        this.rootWidthObservable.e(f16);
    }

    public final void d0(@NotNull NetSearchTemplateNineBoxGridItem model, int position) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.contentModel = model;
        c0(position);
    }

    public final float v() {
        return (float) ((this.binding.f405616o.getWidth() - ViewUtils.dpToPx(32.0f)) * 0.333333d);
    }

    public final void x(@NotNull NetSearchTemplateNineBoxGridItem data) {
        String str;
        SearchText searchText;
        Intrinsics.checkNotNullParameter(data, "data");
        int playState = data.getPlayState();
        SearchIcon contentIcon = data.getContentIcon();
        if (contentIcon != null && (searchText = contentIcon.title) != null) {
            str = searchText.text;
        } else {
            str = null;
        }
        QLog.d("QQSearch.NetDetail.SearchDetailMultiMediaCard", 1, "changePlayState to " + playState + " for " + str);
        if (data.getPlayState() == 1) {
            NetSearchMultiMediaVideoView netSearchMultiMediaVideoView = this.binding.A;
            Intrinsics.checkNotNullExpressionValue(netSearchMultiMediaVideoView, "binding.singleVideo");
            NetSearchMultiMediaVideoView.T0(netSearchMultiMediaVideoView, false, 1, null);
            return;
        }
        this.binding.A.U0();
    }

    public final <LP extends ViewGroup.LayoutParams> void x0(@NotNull final View view, @NotNull final Function2<? super LP, ? super Integer, Unit> block, @NotNull b observer) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(observer, "observer");
        observer.f(new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard$updateLayoutParamsWithListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                invoke(f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f16) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type LP of com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaCard.updateLayoutParamsWithListener");
                block.invoke(layoutParams, Integer.valueOf((f16 > 0.0f ? (int) f16 : ViewUtils.dpToPx(125.33f)) - ViewUtils.dpToPx(1.0f)));
                view.setLayoutParams(layoutParams);
            }
        });
    }

    @NotNull
    /* renamed from: y, reason: from getter */
    public final am getBinding() {
        return this.binding;
    }
}
