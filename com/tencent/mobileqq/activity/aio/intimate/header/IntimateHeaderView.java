package com.tencent.mobileqq.activity.aio.intimate.header;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.header.g;
import com.tencent.mobileqq.activity.aio.intimate.qui.QUICardStackView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qzone.QZIntimateSpaceRedDotReader$EntranceInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0002\u001d\u001eB\u0011\b\u0016\u0012\u0006\u0010V\u001a\u00020U\u00a2\u0006\u0004\bW\u0010XB\u0019\b\u0016\u0012\u0006\u0010V\u001a\u00020U\u0012\u0006\u0010Z\u001a\u00020Y\u00a2\u0006\u0004\bW\u0010[B!\b\u0016\u0012\u0006\u0010V\u001a\u00020U\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010\\\u001a\u00020\u0004\u00a2\u0006\u0004\bW\u0010]J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0014J\b\u0010\u001e\u001a\u00020\u0002H\u0014J\u0010\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u000e\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\"J\u000e\u0010$\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010(\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u0004H\u0014J\u000e\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)J\b\u0010,\u001a\u00020\u0002H\u0014J\b\u0010-\u001a\u00020\u0002H\u0014J\b\u0010.\u001a\u00020\u0002H\u0014J\b\u0010/\u001a\u00020\u0002H\u0014J\b\u00100\u001a\u00020\u0002H\u0014J\u0012\u00102\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u0017H\u0014R'\u00109\u001a\u0012\u0012\u0004\u0012\u00020403j\b\u0012\u0004\u0012\u000204`58\u0006\u00a2\u0006\f\n\u0004\b\b\u00106\u001a\u0004\b7\u00108R\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010>R\u0016\u0010@\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\nR$\u0010B\u001a\u0012\u0012\u0004\u0012\u00020A03j\b\u0012\u0004\u0012\u00020A`58\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00106R\u0018\u0010D\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010HR\u0016\u0010J\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0018\u0010L\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010KR\"\u0010T\u001a\u00020M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/IntimateHeaderView;", "Lcom/tencent/mobileqq/activity/aio/intimate/view/IntimateContentItemBaseView;", "", "M", "", "type", "lightUpDays", "D", UserInfo.SEX_FEMALE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "I", "J", "H", "w", "K", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", HippyTKDListViewAdapter.X, "y", "B", BdhLogUtil.LogTag.Tag_Req, "N", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "view", "", com.tencent.luggage.wxa.c8.c.f123400v, "G", "P", "a", "b", "Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$c;", "listener", "setTabChangeListener", "Lcom/tencent/mobileqq/activity/aio/intimate/header/IntimateHeaderView$b;", "setPartnerListener", "setCurrentType", "Lcom/tencent/mobileqq/data/IntimateInfo;", "intimateInfoSrc", "friendIntimateType", "i", "Lqzone/QZIntimateSpaceRedDotReader$EntranceInfo;", "entranceInfo", BdhLogUtil.LogTag.Tag_Conn, "f", "e", tl.h.F, "g", "d", "v", "c", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/aio/intimate/header/g;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "E", "()Ljava/util/ArrayList;", IQQGameCommApi.K_ABTEST_MODELS, "Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView;", "Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView;", "mCardStackView", "Lcom/tencent/mobileqq/kandian/base/view/widget/ticker/TickerView;", "Lcom/tencent/mobileqq/kandian/base/view/widget/ticker/TickerView;", "daysTV", "intimateRealDays", "Lcom/tencent/mobileqq/activity/aio/intimate/header/f;", "mCardHolders", "Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$c;", "onTabChangeListener", "L", "Lcom/tencent/mobileqq/activity/aio/intimate/header/IntimateHeaderView$b;", "onPartnerUpdateListener", "Z", "isPartner", "currentType", "Lqzone/QZIntimateSpaceRedDotReader$EntranceInfo;", "mQZoneIntimateEntranceInfo", "Ljava/lang/Runnable;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/Runnable;", "getMUpdateDaysAnimBeginRunnable", "()Ljava/lang/Runnable;", "setMUpdateDaysAnimBeginRunnable", "(Ljava/lang/Runnable;)V", "mUpdateDaysAnimBeginRunnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class IntimateHeaderView extends IntimateContentItemBaseView {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<g> models;

    /* renamed from: G, reason: from kotlin metadata */
    private QUICardStackView mCardStackView;

    /* renamed from: H, reason: from kotlin metadata */
    private TickerView daysTV;

    /* renamed from: I, reason: from kotlin metadata */
    private int intimateRealDays;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<f> mCardHolders;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private QUICardStackView.c onTabChangeListener;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private b onPartnerUpdateListener;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isPartner;

    /* renamed from: N, reason: from kotlin metadata */
    private int currentType;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private QZIntimateSpaceRedDotReader$EntranceInfo mQZoneIntimateEntranceInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private Runnable mUpdateDaysAnimBeginRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/IntimateHeaderView$b;", "", "", "isPartnerIntimate", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean isPartnerIntimate);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/aio/intimate/header/IntimateHeaderView$c", "Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$a;", "Landroid/view/View;", "view", "", com.tencent.luggage.wxa.c8.c.f123400v, "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements QUICardStackView.a {
        c() {
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.qui.QUICardStackView.a
        public void a(@NotNull View view, float alpha) {
            Intrinsics.checkNotNullParameter(view, "view");
            IntimateHeaderView.this.G(view, alpha);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((g) t16).getLightUpTime()), Long.valueOf(((g) t17).getLightUpTime()));
            return compareValues;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntimateHeaderView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.models = new ArrayList<>();
        this.mCardHolders = new ArrayList<>();
        this.mUpdateDaysAnimBeginRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.header.i
            @Override // java.lang.Runnable
            public final void run() {
                IntimateHeaderView.L(IntimateHeaderView.this);
            }
        };
    }

    private final void A() {
        Iterator<g> it = this.models.iterator();
        while (it.hasNext()) {
            if ((it.next().getFlag() & 64) != 0) {
                b bVar = this.onPartnerUpdateListener;
                if (bVar != null) {
                    bVar.a(true);
                }
                this.isPartner = true;
                return;
            }
        }
    }

    private final void B() {
        this.mCardHolders.clear();
    }

    private final int D(int type, int lightUpDays) {
        int coerceAtLeast;
        if (type == 0 || IntimateHeaderCardUtil.O(type)) {
            IntimateInfo intimateInfo = this.f179223i;
            if (intimateInfo.beFriendDays > 0) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, intimateInfo.lastAnimAfterFriendDays);
                return coerceAtLeast;
            }
        }
        return lightUpDays;
    }

    private final int F(int type, int lightUpDays) {
        if (type == 0) {
            int i3 = this.f179223i.beFriendDays + 1;
            this.intimateRealDays = i3;
            return i3;
        }
        if (IntimateHeaderCardUtil.O(type)) {
            this.intimateRealDays = lightUpDays;
        }
        return lightUpDays;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(View view, float alpha) {
        boolean z16;
        Integer num;
        float f16 = 0.0f;
        int i3 = 0;
        if (alpha == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            view.setAlpha(0.0f);
            return;
        }
        float f17 = 1.0f;
        view.setAlpha(1.0f);
        View findViewById = view.findViewById(R.id.xpv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.intimate_header_card)");
        Object tag = findViewById.getTag();
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            i3 = num.intValue();
        }
        View findViewById2 = view.findViewById(R.id.xpx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.i\u2026mate_header_card_root_bg)");
        findViewById2.setAlpha(alpha);
        ImageView imageView = (ImageView) view.findViewById(R.id.xq6);
        float f18 = (alpha - 0.4f) / 0.6f;
        if (alpha > 0.4f) {
            f16 = f18;
        }
        imageView.setAlpha(f16);
        ((LinearLayout) view.findViewById(R.id.xqe)).setAlpha(f16);
        View findViewById3 = view.findViewById(R.id.xpw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.intimate_header_card_bg)");
        if ((ThemeUtil.isVasDarkTheme() || com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) && !IntimateHeaderCardUtil.M(i3)) {
            f17 = 0.1f;
        }
        findViewById3.setAlpha(f17 * alpha);
        ((LinearLayout) view.findViewById(R.id.f82914i6)).setAlpha(f16);
        ((LinearLayout) view.findViewById(R.id.vf5)).setAlpha(f16);
    }

    private final void H() {
        B();
        QUICardStackView qUICardStackView = this.mCardStackView;
        if (qUICardStackView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardStackView");
            qUICardStackView = null;
        }
        for (View view : qUICardStackView.m()) {
            Context context = this.f179219d;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String friendUin = this.f179220e;
            Intrinsics.checkNotNullExpressionValue(friendUin, "friendUin");
            f fVar = new f(context, view, friendUin);
            Iterator<T> it = fVar.g().iterator();
            while (it.hasNext()) {
                ((ViewGroup) it.next()).setOnTouchListener(this);
            }
            this.mCardHolders.add(fVar);
        }
        S();
        if (this.f179223i.maskType == 0 && !this.isPartner) {
            this.mCardHolders.get(0).s();
        }
    }

    private final void I() {
        J();
        H();
        w();
    }

    private final void J() {
        QUICardStackView qUICardStackView = this.mCardStackView;
        QUICardStackView qUICardStackView2 = null;
        if (qUICardStackView != null) {
            if (qUICardStackView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardStackView");
                qUICardStackView = null;
            }
            qUICardStackView.j();
            QUICardStackView qUICardStackView3 = this.mCardStackView;
            if (qUICardStackView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardStackView");
                qUICardStackView3 = null;
            }
            removeView(qUICardStackView3);
        }
        int size = this.models.size();
        if (this.currentType == 0) {
            l lVar = l.f179061a;
            String str = this.f179223i.friendUin;
            Intrinsics.checkNotNullExpressionValue(str, "intimateInfo.friendUin");
            this.currentType = lVar.c(str);
        }
        QLog.i("IntimateHeaderView", 1, "initCardStackView, currentType_init=" + this.currentType + ", cardCount=" + size);
        Context context = this.f179219d;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QUICardStackView z16 = new QUICardStackView(context).x(R.layout.duq, size, this.currentType, true, new c()).z(this.onTabChangeListener);
        this.mCardStackView = z16;
        if (z16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardStackView");
            z16 = null;
        }
        z16.setClipChildren(false);
        QUICardStackView qUICardStackView4 = this.mCardStackView;
        if (qUICardStackView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardStackView");
        } else {
            qUICardStackView2 = qUICardStackView4;
        }
        addView(qUICardStackView2);
    }

    private final void K() {
        int i3;
        if (this.mCardStackView != null) {
            if (this.models.size() > 1) {
                QUICardStackView qUICardStackView = this.mCardStackView;
                if (qUICardStackView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCardStackView");
                    qUICardStackView = null;
                }
                i3 = qUICardStackView.getCurrentCardPosition() - 1;
            } else {
                i3 = 0;
            }
            QUICardStackView.c cVar = this.onTabChangeListener;
            if (cVar != null) {
                cVar.onChanged(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(IntimateHeaderView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.f179221f) {
            this$0.R();
        }
    }

    private final void M() {
        List<MutualMarkModel> list;
        this.models.clear();
        f61.h hVar = this.f179223i.mutualMarkList;
        if (hVar != null && (list = hVar.f397922c) != null) {
            this.isPartner = false;
            for (MutualMarkModel mutualMarkModel : list) {
                if (mutualMarkModel.N && (IntimateHeaderCardUtil.O((int) mutualMarkModel.D) || (mutualMarkModel.X & 64) != 0)) {
                    long j3 = mutualMarkModel.D;
                    int i3 = (int) j3;
                    int i16 = (int) mutualMarkModel.H;
                    int D = D((int) j3, (int) mutualMarkModel.V);
                    int F = F((int) mutualMarkModel.D, (int) mutualMarkModel.V);
                    long j16 = mutualMarkModel.W;
                    int i17 = (int) mutualMarkModel.L;
                    long j17 = mutualMarkModel.X;
                    String str = mutualMarkModel.f252155a0;
                    if (str == null) {
                        str = "";
                    }
                    g gVar = new g(i3, i16, D, F, j16, i17, j17, str);
                    if ((mutualMarkModel.X & 64) != 0) {
                        b bVar = this.onPartnerUpdateListener;
                        if (bVar != null) {
                            bVar.a(true);
                        }
                        this.isPartner = true;
                    }
                    this.models.add(gVar);
                }
            }
            if (this.models.isEmpty()) {
                IntimateInfo intimateInfo = this.f179223i;
                int i18 = intimateInfo.maskType;
                this.models.add(new g(i18, intimateInfo.maskLevel, D(i18, 0), F(this.f179223i.maskType, 0), 0L, this.f179223i.scoreCardInfo.score, 0L, ""));
            }
            ArrayList<g> arrayList = this.models;
            if (arrayList.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new d());
            }
            a aVar = a.f179009a;
            if (aVar.d().get(this.f179223i.friendUin) != null) {
                aVar.d().remove(this.f179223i.friendUin);
            }
            ArrayList<g> g16 = a.g(this.models);
            aVar.d().put(this.f179223i.friendUin, g16);
            l lVar = l.f179061a;
            String str2 = this.f179223i.friendUin;
            Intrinsics.checkNotNullExpressionValue(str2, "intimateInfo.friendUin");
            lVar.i(str2, g16);
            Iterator<T> it = this.models.iterator();
            while (it.hasNext()) {
                QLog.i("IntimateHeaderView", 1, "obtainModelsFromIntimateInfo:" + ((g) it.next()));
            }
            return;
        }
        a aVar2 = a.f179009a;
        if (aVar2.d().get(this.f179223i.friendUin) == null) {
            l lVar2 = l.f179061a;
            String str3 = this.f179223i.friendUin;
            Intrinsics.checkNotNullExpressionValue(str3, "intimateInfo.friendUin");
            ArrayList<g> b16 = lVar2.b(str3);
            if (b16.size() <= 0) {
                Iterator<T> it5 = this.models.iterator();
                while (it5.hasNext()) {
                    QLog.i("IntimateHeaderView", 1, "obtainModelsFromIntimateInfo[only-intimate]:" + ((g) it5.next()));
                }
                return;
            }
            aVar2.d().put(this.f179223i.friendUin, b16);
            QLog.i("IntimateHeaderView", 1, "obtainModelsFromIntimateInfo[read-from-mmkv]");
        }
        this.models.clear();
        this.models.addAll(aVar2.d().get(this.f179223i.friendUin));
        Iterator<T> it6 = this.models.iterator();
        while (it6.hasNext()) {
            QLog.i("IntimateHeaderView", 1, "obtainModelsFromIntimateInfo[from-cache]:" + ((g) it6.next()));
        }
        A();
    }

    private final void N() {
        IntimateInfo intimateInfo;
        List listOf;
        if (!this.D || (intimateInfo = this.f179223i) == null) {
            return;
        }
        intimateInfo.lastAnimAfterFriendDays = this.intimateRealDays;
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.header.j
            @Override // java.lang.Runnable
            public final void run() {
                IntimateHeaderView.O(IntimateHeaderView.this);
            }
        }, null, true);
        if (QLog.isColorLevel()) {
            IntimateInfo intimateInfo2 = this.f179223i;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"friendUin", "troopUin", IProfileProtocolConst.PARAM_TROOP_CODE, "troopName", "addFriendWording"});
            QLog.d("IntimateHeaderView", 2, "onDaysUpdated intimateInfo: " + com.tencent.util.k.f(intimateInfo2, listOf));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(IntimateHeaderView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQAppInterface j3 = this$0.j();
        if (j3 != null && this$0.f179223i != null) {
            Manager manager = j3.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.friends.intimate.IntimateInfoManager");
            ((com.tencent.mobileqq.friends.intimate.c) manager).v(this$0.f179223i);
        }
    }

    private final void P() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.header.k
            @Override // java.lang.Runnable
            public final void run() {
                IntimateHeaderView.Q(IntimateHeaderView.this);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(IntimateHeaderView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null || TextUtils.isEmpty(this$0.f179220e)) {
            return;
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this$0.f179220e);
        IIntimateInfoService iIntimateInfoService = (IIntimateInfoService) QRoute.api(IIntimateInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = iIntimateInfoService.getIntimateSimpleInfoWithUid(uid, "IntimateHeaderView");
        if (intimateSimpleInfoWithUid != null) {
            m.f179063a.a(intimateSimpleInfoWithUid.j(), intimateSimpleInfoWithUid.f());
            QLog.i("IntimateHeaderView", 1, "preDownloadResource,frdUin=" + com.tencent.mobileqq.qcall.g.b(this$0.f179220e) + ",intimate_type=" + intimateSimpleInfoWithUid.j() + ",intimate_level=" + intimateSimpleInfoWithUid.f());
        }
    }

    private final void R() {
        int coerceAtLeast;
        int coerceAtLeast2;
        if (this.D && this.daysTV != null) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, this.f179223i.lastAnimAfterFriendDays);
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(0, this.intimateRealDays);
            int i3 = 2;
            if (QLog.isColorLevel()) {
                QLog.i("IntimateHeaderView", 2, "smoothUpdateDays fromDays:" + coerceAtLeast + " toDays:" + coerceAtLeast2);
            }
            TickerView tickerView = null;
            if (coerceAtLeast <= 0) {
                int length = String.valueOf(coerceAtLeast2).length();
                String str = "";
                for (int i16 = 0; i16 < length && i16 < 5; i16++) {
                    str = str + "0";
                }
                TickerView tickerView2 = this.daysTV;
                if (tickerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("daysTV");
                    tickerView2 = null;
                }
                tickerView2.setText(str, false);
            }
            TickerView tickerView3 = this.daysTV;
            if (tickerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("daysTV");
                tickerView3 = null;
            }
            if (coerceAtLeast2 > coerceAtLeast) {
                i3 = 1;
            }
            tickerView3.setPreferredScrollingDirection(i3);
            TickerView tickerView4 = this.daysTV;
            if (tickerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("daysTV");
                tickerView4 = null;
            }
            tickerView4.setDigitalAnimWidthSpeedIncrement(true);
            TickerView tickerView5 = this.daysTV;
            if (tickerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("daysTV");
                tickerView5 = null;
            }
            tickerView5.setIgnoreWidthAnim(true);
            TickerView tickerView6 = this.daysTV;
            if (tickerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("daysTV");
            } else {
                tickerView = tickerView6;
            }
            tickerView.setText(String.valueOf(coerceAtLeast2));
            N();
        }
    }

    private final void S() {
        QZIntimateSpaceRedDotReader$EntranceInfo qZIntimateSpaceRedDotReader$EntranceInfo;
        if (!this.D || (qZIntimateSpaceRedDotReader$EntranceInfo = this.mQZoneIntimateEntranceInfo) == null) {
            return;
        }
        Iterator<T> it = this.mCardHolders.iterator();
        while (it.hasNext()) {
            ((f) it.next()).r(qZIntimateSpaceRedDotReader$EntranceInfo);
        }
    }

    private final void w() {
        if (this.models.size() > 0 && this.mCardHolders.size() > 0) {
            if (this.models.size() == 1) {
                f fVar = this.mCardHolders.get(0);
                g gVar = this.models.get(0);
                Intrinsics.checkNotNullExpressionValue(gVar, "models[0]");
                fVar.n(gVar);
                if (IntimateHeaderCardUtil.O(this.models.get(0).getType()) || this.models.get(0).getType() == 0) {
                    View findViewById = this.mCardHolders.get(0).getMRootView().findViewById(R.id.xq9);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "mCardHolders[0].mRootVie\u2026eader_second_line_bignum)");
                    this.daysTV = (TickerView) findViewById;
                    return;
                }
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<g> arrayList3 = new ArrayList<>();
            f fVar2 = this.mCardHolders.get(0);
            g.Companion companion = g.INSTANCE;
            ArrayList<g> arrayList4 = this.models;
            g gVar2 = arrayList4.get(arrayList4.size() - 1);
            Intrinsics.checkNotNullExpressionValue(gVar2, "models[models.size - 1]");
            fVar2.n(companion.a(gVar2));
            int size = this.models.size() + 1;
            for (int i3 = 1; i3 < size; i3++) {
                int i16 = i3 - 1;
                int type = this.models.get(i16).getType();
                int level = this.models.get(i16).getLevel();
                this.models.get(i16).getFlag();
                arrayList.add(IntimateHeaderCardUtil.H(type, level));
                arrayList2.add(IntimateHeaderCardUtil.z(type));
                arrayList3.add(this.models.get(i16));
                f fVar3 = this.mCardHolders.get(i3);
                g gVar3 = this.models.get(i16);
                Intrinsics.checkNotNullExpressionValue(gVar3, "models[i - 1]");
                fVar3.n(gVar3);
                if ((this.daysTV == null && IntimateHeaderCardUtil.O(type)) || type == 0) {
                    View findViewById2 = this.mCardHolders.get(i3).getMRootView().findViewById(R.id.xq9);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "mCardHolders[i].mRootVie\u2026eader_second_line_bignum)");
                    this.daysTV = (TickerView) findViewById2;
                }
            }
            f fVar4 = this.mCardHolders.get(this.models.size() + 1);
            g.Companion companion2 = g.INSTANCE;
            g gVar4 = this.models.get(0);
            Intrinsics.checkNotNullExpressionValue(gVar4, "models[0]");
            fVar4.n(companion2.a(gVar4));
            f fVar5 = this.mCardHolders.get(this.models.size() + 2);
            g gVar5 = this.models.get(1);
            Intrinsics.checkNotNullExpressionValue(gVar5, "models[1]");
            fVar5.n(companion2.a(gVar5));
            QUICardStackView qUICardStackView = this.mCardStackView;
            if (qUICardStackView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardStackView");
                qUICardStackView = null;
            }
            qUICardStackView.A(arrayList, arrayList2, arrayList3);
        }
    }

    private final boolean x() {
        return true;
    }

    private final void y() {
        if (ArrayUtils.isOutOfArrayIndex(0, this.mCardHolders)) {
            return;
        }
        Iterator<f> it = this.mCardHolders.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
    }

    private final void z() {
        if (this.D && this.f179221f && this.f179223i != null) {
            removeCallbacks(this.mUpdateDaysAnimBeginRunnable);
            if (x()) {
                int i3 = this.f179223i.lastAnimAfterFriendDays;
                int i16 = this.intimateRealDays;
                if (i3 != i16 && i16 > 0) {
                    postDelayed(this.mUpdateDaysAnimBeginRunnable, 300L);
                }
            }
        }
    }

    public final void C(@NotNull QZIntimateSpaceRedDotReader$EntranceInfo entranceInfo) {
        Intrinsics.checkNotNullParameter(entranceInfo, "entranceInfo");
        this.mQZoneIntimateEntranceInfo = entranceInfo;
        S();
    }

    @NotNull
    public final ArrayList<g> E() {
        return this.models;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected boolean a() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void b() {
        setVisibility(0);
        P();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void d() {
        y();
        removeCallbacks(this.mUpdateDaysAnimBeginRunnable);
        QUICardStackView qUICardStackView = null;
        this.onTabChangeListener = null;
        this.onPartnerUpdateListener = null;
        QUICardStackView qUICardStackView2 = this.mCardStackView;
        if (qUICardStackView2 != null) {
            if (qUICardStackView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardStackView");
            } else {
                qUICardStackView = qUICardStackView2;
            }
            qUICardStackView.j();
        }
        B();
        super.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void e() {
        removeCallbacks(this.mUpdateDaysAnimBeginRunnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void f() {
        z();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void g() {
        removeCallbacks(this.mUpdateDaysAnimBeginRunnable);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void h() {
        z();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void i(@Nullable IntimateInfo intimateInfoSrc, int friendIntimateType) {
        if (intimateInfoSrc == null) {
            return;
        }
        this.f179223i = intimateInfoSrc;
        if (intimateInfoSrc.beFriendDays < 0) {
            return;
        }
        IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
        Intrinsics.checkNotNullExpressionValue(intimateInfoSrc, "intimateInfo");
        intimateHeaderCardUtil.V(intimateInfoSrc);
        M();
        I();
        K();
        z();
    }

    public final void setCurrentType(int type) {
        this.currentType = type;
    }

    public final void setMUpdateDaysAnimBeginRunnable(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.mUpdateDaysAnimBeginRunnable = runnable;
    }

    public final void setPartnerListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onPartnerUpdateListener = listener;
    }

    public final void setTabChangeListener(@Nullable QUICardStackView.c listener) {
        this.onTabChangeListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntimateHeaderView(@NotNull Context context, @NotNull AttributeSet attr) {
        super(context, attr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
        this.models = new ArrayList<>();
        this.mCardHolders = new ArrayList<>();
        this.mUpdateDaysAnimBeginRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.header.i
            @Override // java.lang.Runnable
            public final void run() {
                IntimateHeaderView.L(IntimateHeaderView.this);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntimateHeaderView(@NotNull Context context, @NotNull AttributeSet attr, int i3) {
        super(context, attr, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
        this.models = new ArrayList<>();
        this.mCardHolders = new ArrayList<>();
        this.mUpdateDaysAnimBeginRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.header.i
            @Override // java.lang.Runnable
            public final void run() {
                IntimateHeaderView.L(IntimateHeaderView.this);
            }
        };
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void c(@Nullable View v3) {
    }
}
