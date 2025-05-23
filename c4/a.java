package c4;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppGroup;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Belt;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$DateRange;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Declaim;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$GetHomepageV2Rsp;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Market;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$RedDot;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$RedPoint;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$VirtualEntity;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.home.u;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0004\u001a\u0014\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n\u001a\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\t\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\t\u001a(\u0010\u0015\u001a\u00020\u0014*\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u0012\u0010\u001b\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u001a\u001a\f\u0010\u001c\u001a\u00020\u0001*\u0004\u0018\u00010\u0016\u001a\f\u0010\u001d\u001a\u00020\u0007*\u0004\u0018\u00010\u0016\u001a\n\u0010\u001e\u001a\u00020\u0007*\u00020\u0016\u001a\n\u0010\u001f\u001a\u00020\u0014*\u00020\u0004\u001a\n\u0010 \u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010!\u001a\u00020\u0014*\u00020\u0004\u001a\n\u0010\"\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010#\u001a\u00020\u0014*\u00020\u0016\u001a\n\u0010$\u001a\u00020\u0001*\u00020\u0016\u001a\n\u0010%\u001a\u00020\u0014*\u00020\u0016\u001a\n\u0010&\u001a\u00020\u0001*\u00020\u0016\u001a(\u0010*\u001a\u00020\u0014*\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020(\u001a(\u0010,\u001a\u00020\u0014*\u0004\u0018\u00010+2\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u001a\n\u0010-\u001a\u00020\u0001*\u00020+\u001a\n\u0010/\u001a\u00020\u0001*\u00020.\u001a\n\u00101\u001a\u00020\u0001*\u000200\u001a\u0014\u00104\u001a\u00020\u0007*\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u0007\"\u0015\u00108\u001a\u00020\u0007*\u0002058F\u00a2\u0006\u0006\u001a\u0004\b6\u00107\u00a8\u00069"}, d2 = {"Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Belt;", "", "o", "p", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$VirtualEntity;", "l", "k", "", "E", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Market;", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", h.F, "e", "i", "r", "actionName", "reportTag", "name", "", "w", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "other", DomainData.DOMAIN_NAME, "j", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppGroup;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", "D", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, "d", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "b", "B", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "a", "r4", "", IProfileCardConst.KEY_FROM_TYPE, "v", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$RedPoint;", HippyTKDListViewAdapter.X, "t", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$RedDot;", ReportConstant.COSTREPORT_PREFIX, "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$DateRange;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Declaim;", "companyName", "f", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$GetHomepageV2Rsp;", "g", "(Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$GetHomepageV2Rsp;)Ljava/lang/String;", "contentSize", "qwallet-impl_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "QWalletHomePageExt")
/* loaded from: classes3.dex */
public final class a {
    public static final void A(@NotNull QWalletHomePage$VirtualEntity qWalletHomePage$VirtualEntity) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$VirtualEntity, "<this>");
        g.n("entity_" + E(qWalletHomePage$VirtualEntity) + "_market_" + com.tencent.mobileqq.base.a.c(), qWalletHomePage$VirtualEntity.market.f41694id.get());
    }

    public static final void B(@NotNull QWalletHomePage$AppInfo qWalletHomePage$AppInfo) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$AppInfo, "<this>");
        g.n("app_info_" + F(qWalletHomePage$AppInfo) + "_red_" + com.tencent.mobileqq.base.a.c(), qWalletHomePage$AppInfo.red_point.f41696id.get());
    }

    public static final void C(@NotNull QWalletHomePage$VirtualEntity qWalletHomePage$VirtualEntity) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$VirtualEntity, "<this>");
        g.n("entity_" + E(qWalletHomePage$VirtualEntity) + "_red_" + com.tencent.mobileqq.base.a.c(), qWalletHomePage$VirtualEntity.red_point.f41696id.get());
    }

    @NotNull
    public static final String D(@Nullable QWalletHomePage$AppInfo qWalletHomePage$AppInfo) {
        if (qWalletHomePage$AppInfo == null) {
            return "";
        }
        return qWalletHomePage$AppInfo.type.get() + "_" + qWalletHomePage$AppInfo.f41686id.get();
    }

    @NotNull
    public static final String E(@NotNull QWalletHomePage$VirtualEntity qWalletHomePage$VirtualEntity) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$VirtualEntity, "<this>");
        return qWalletHomePage$VirtualEntity.type.get() + "_" + qWalletHomePage$VirtualEntity.f41700id.get();
    }

    @NotNull
    public static final String F(@NotNull QWalletHomePage$AppInfo qWalletHomePage$AppInfo) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$AppInfo, "<this>");
        return qWalletHomePage$AppInfo.f41686id.get() + "_" + qWalletHomePage$AppInfo.type.get() + "_" + qWalletHomePage$AppInfo.f41687pv.get();
    }

    public static final boolean a(@NotNull QWalletHomePage$AppInfo qWalletHomePage$AppInfo) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$AppInfo, "<this>");
        QWalletHomePage$Market market = qWalletHomePage$AppInfo.market;
        Intrinsics.checkNotNullExpressionValue(market, "market");
        if (r(market)) {
            if (g.e("app_info_" + F(qWalletHomePage$AppInfo) + "_market_" + com.tencent.mobileqq.base.a.c(), -1) != qWalletHomePage$AppInfo.market.f41694id.get()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(@NotNull QWalletHomePage$VirtualEntity qWalletHomePage$VirtualEntity) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$VirtualEntity, "<this>");
        QWalletHomePage$Market market = qWalletHomePage$VirtualEntity.market;
        Intrinsics.checkNotNullExpressionValue(market, "market");
        if (r(market)) {
            if (g.e("entity_" + E(qWalletHomePage$VirtualEntity) + "_market_" + com.tencent.mobileqq.base.a.c(), -1) != qWalletHomePage$VirtualEntity.market.f41694id.get()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(@NotNull QWalletHomePage$AppInfo qWalletHomePage$AppInfo) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$AppInfo, "<this>");
        QWalletHomePage$RedPoint red_point = qWalletHomePage$AppInfo.red_point;
        Intrinsics.checkNotNullExpressionValue(red_point, "red_point");
        if (t(red_point)) {
            if (g.e("app_info_" + F(qWalletHomePage$AppInfo) + "_red_" + com.tencent.mobileqq.base.a.c(), -1) != qWalletHomePage$AppInfo.red_point.f41696id.get()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean d(@NotNull QWalletHomePage$VirtualEntity qWalletHomePage$VirtualEntity) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$VirtualEntity, "<this>");
        QWalletHomePage$RedPoint red_point = qWalletHomePage$VirtualEntity.red_point;
        Intrinsics.checkNotNullExpressionValue(red_point, "red_point");
        if (t(red_point)) {
            if (g.e("entity_" + E(qWalletHomePage$VirtualEntity) + "_red_" + com.tencent.mobileqq.base.a.c(), -1) != qWalletHomePage$VirtualEntity.red_point.f41696id.get()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final String e(@NotNull QWalletHomePage$Market qWalletHomePage$Market, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$Market, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = qWalletHomePage$Market.type.get();
        if (i3 != 1) {
            if (i3 != 2 && i3 != 6) {
                return null;
            }
            return context.getString(R.string.vp5);
        }
        return context.getString(R.string.vp6);
    }

    @NotNull
    public static final String f(@Nullable QWalletHomePage$Declaim qWalletHomePage$Declaim, @NotNull String companyName) {
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        if (qWalletHomePage$Declaim == null) {
            return "";
        }
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = qWalletHomePage$Declaim.statement_content.get();
            Intrinsics.checkNotNullExpressionValue(str, "statement_content.get()");
            String format = String.format(str, Arrays.copyOf(new Object[]{companyName}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        } catch (Exception e16) {
            QLog.d("QWalletHomePageExt", 1, "Declaim?.getContent: ", e16);
            return "";
        }
    }

    @NotNull
    public static final String g(@NotNull QWalletHomePage$GetHomepageV2Rsp qWalletHomePage$GetHomepageV2Rsp) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$GetHomepageV2Rsp, "<this>");
        int size = qWalletHomePage$GetHomepageV2Rsp.top_apps.size();
        int size2 = qWalletHomePage$GetHomepageV2Rsp.finance_app_group.apps.size();
        int size3 = qWalletHomePage$GetHomepageV2Rsp.life_app_group.apps.size();
        List<QWalletHomePage$AppGroup> list = qWalletHomePage$GetHomepageV2Rsp.app_list.get();
        Intrinsics.checkNotNullExpressionValue(list, "app_list.get()");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<QWalletHomePage$AppInfo> list2 = ((QWalletHomePage$AppGroup) it.next()).apps.get();
            Intrinsics.checkNotNullExpressionValue(list2, "it.apps.get()");
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, list2);
        }
        return "top apps " + size + ", finance apps " + size2 + ", life apps " + size3 + ", app list " + arrayList.size() + ", belts " + qWalletHomePage$GetHomepageV2Rsp.belts.size() + ", assets " + qWalletHomePage$GetHomepageV2Rsp.assets.size() + ", virtual entities " + qWalletHomePage$GetHomepageV2Rsp.virtual_entities.size();
    }

    @Nullable
    public static final Drawable h(@NotNull QWalletHomePage$Market qWalletHomePage$Market, @NotNull Context context) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(qWalletHomePage$Market, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = qWalletHomePage$Market.type.get();
        if (i3 != 1) {
            if (i3 != 2 && i3 != 6) {
                drawable = new ColorDrawable(0);
            } else {
                drawable = ContextCompat.getDrawable(context, R.drawable.f162117fp1);
            }
        } else {
            drawable = ContextCompat.getDrawable(context, R.drawable.foz);
        }
        return QWalletPicHelper.getNetDrawableForQWallet(qWalletHomePage$Market.icon.get(), drawable, drawable);
    }

    public static final boolean i(@NotNull QWalletHomePage$Market qWalletHomePage$Market) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$Market, "<this>");
        if (qWalletHomePage$Market.type.get() == 6) {
            return true;
        }
        return false;
    }

    public static final boolean j(@NotNull QWalletHomePage$AppInfo qWalletHomePage$AppInfo, @NotNull QWalletHomePage$AppInfo other) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$AppInfo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (qWalletHomePage$AppInfo != other && (qWalletHomePage$AppInfo.f41686id.get() != other.f41686id.get() || qWalletHomePage$AppInfo.type.get() != other.type.get() || !Intrinsics.areEqual(qWalletHomePage$AppInfo.name.get(), other.name.get()) || !Intrinsics.areEqual(qWalletHomePage$AppInfo.icon.get(), other.icon.get()) || !Intrinsics.areEqual(qWalletHomePage$AppInfo.desc.get(), other.desc.get()) || !Intrinsics.areEqual(qWalletHomePage$AppInfo.background.get(), other.background.get()) || !Intrinsics.areEqual(qWalletHomePage$AppInfo.night_background.get(), other.night_background.get()))) {
            return false;
        }
        return true;
    }

    public static final boolean k(@NotNull QWalletHomePage$VirtualEntity qWalletHomePage$VirtualEntity) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$VirtualEntity, "<this>");
        if (qWalletHomePage$VirtualEntity.type.get() == 2) {
            return true;
        }
        return false;
    }

    public static final boolean l(@NotNull QWalletHomePage$VirtualEntity qWalletHomePage$VirtualEntity) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$VirtualEntity, "<this>");
        if (qWalletHomePage$VirtualEntity.type.get() == 1) {
            return true;
        }
        return false;
    }

    public static final boolean m(@NotNull QWalletHomePage$AppGroup qWalletHomePage$AppGroup, @NotNull QWalletHomePage$AppGroup other) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$AppGroup, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (qWalletHomePage$AppGroup != other && (!Intrinsics.areEqual(qWalletHomePage$AppGroup.title.get(), other.title.get()) || qWalletHomePage$AppGroup.apps.get().size() != other.apps.get().size())) {
            return false;
        }
        return true;
    }

    public static final boolean n(@NotNull QWalletHomePage$AppInfo qWalletHomePage$AppInfo, @NotNull QWalletHomePage$AppInfo other) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$AppInfo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (qWalletHomePage$AppInfo != other && (qWalletHomePage$AppInfo.f41686id.get() != other.f41686id.get() || qWalletHomePage$AppInfo.type.get() != other.type.get())) {
            return false;
        }
        return true;
    }

    public static final boolean o(@NotNull QWalletHomePage$Belt qWalletHomePage$Belt) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$Belt, "<this>");
        if (qWalletHomePage$Belt.type.get() == 3) {
            return true;
        }
        return false;
    }

    public static final boolean p(@NotNull QWalletHomePage$Belt qWalletHomePage$Belt) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$Belt, "<this>");
        if (qWalletHomePage$Belt.f41688id.get() != 0) {
            QWalletHomePage$DateRange range = qWalletHomePage$Belt.range;
            Intrinsics.checkNotNullExpressionValue(range, "range");
            if (q(range)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean q(@NotNull QWalletHomePage$DateRange qWalletHomePage$DateRange) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$DateRange, "<this>");
        long serverTime = NetConnInfoCenter.getServerTime();
        if (serverTime >= qWalletHomePage$DateRange.begin.get() && serverTime <= qWalletHomePage$DateRange.end.get()) {
            return true;
        }
        return false;
    }

    public static final boolean r(@NotNull QWalletHomePage$Market qWalletHomePage$Market) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$Market, "<this>");
        if (qWalletHomePage$Market.f41694id.get() != 0) {
            QWalletHomePage$DateRange range = qWalletHomePage$Market.range;
            Intrinsics.checkNotNullExpressionValue(range, "range");
            if (q(range)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean s(@NotNull QWalletHomePage$RedDot qWalletHomePage$RedDot) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$RedDot, "<this>");
        QWalletHomePage$DateRange date_range = qWalletHomePage$RedDot.date_range;
        Intrinsics.checkNotNullExpressionValue(date_range, "date_range");
        if (!q(date_range)) {
            return false;
        }
        if (qWalletHomePage$RedDot.type.get() != 2 && qWalletHomePage$RedDot.type.get() != 3) {
            return true;
        }
        String str = qWalletHomePage$RedDot.content.get();
        Intrinsics.checkNotNullExpressionValue(str, "content.get()");
        if (str.length() <= 0) {
            return false;
        }
        return true;
    }

    public static final boolean t(@NotNull QWalletHomePage$RedPoint qWalletHomePage$RedPoint) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$RedPoint, "<this>");
        if (qWalletHomePage$RedPoint.f41696id.get() != 0) {
            QWalletHomePage$DateRange qWalletHomePage$DateRange = qWalletHomePage$RedPoint.range.get();
            Intrinsics.checkNotNullExpressionValue(qWalletHomePage$DateRange, "range.get()");
            if (q(qWalletHomePage$DateRange)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean u(@Nullable QWalletHomePage$AppInfo qWalletHomePage$AppInfo) {
        if (qWalletHomePage$AppInfo == null || qWalletHomePage$AppInfo.type.get() < 0) {
            return false;
        }
        return true;
    }

    public static final void v(@Nullable QWalletHomePage$AppInfo qWalletHomePage$AppInfo, @NotNull String actionName, @NotNull String r46, int i3) {
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(r46, "r4");
        if (qWalletHomePage$AppInfo == null) {
            return;
        }
        String str = qWalletHomePage$AppInfo.f41687pv.get();
        Intrinsics.checkNotNullExpressionValue(str, "pv.get()");
        String valueOf = String.valueOf(qWalletHomePage$AppInfo.f41686id.get());
        String str2 = qWalletHomePage$AppInfo.name.get();
        Intrinsics.checkNotNullExpressionValue(str2, "name.get()");
        u.l(actionName, str, valueOf, r46, str2, i3);
    }

    public static final void w(@Nullable QWalletHomePage$Market qWalletHomePage$Market, @NotNull String actionName, @NotNull String reportTag, @NotNull String name) {
        Integer num;
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(reportTag, "reportTag");
        Intrinsics.checkNotNullParameter(name, "name");
        if (qWalletHomePage$Market == null) {
            return;
        }
        PBInt32Field pBInt32Field = qWalletHomePage$Market.type;
        Integer num2 = null;
        if (pBInt32Field != null) {
            num = Integer.valueOf(pBInt32Field.get());
        } else {
            num = null;
        }
        String valueOf = String.valueOf(num);
        PBInt32Field pBInt32Field2 = qWalletHomePage$Market.f41694id;
        if (pBInt32Field2 != null) {
            num2 = Integer.valueOf(pBInt32Field2.get());
        }
        u.m(actionName, valueOf, String.valueOf(num2), reportTag, name, 0, 32, null);
    }

    public static final void x(@Nullable QWalletHomePage$RedPoint qWalletHomePage$RedPoint, @NotNull String actionName, @NotNull String reportTag, @NotNull String name) {
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(reportTag, "reportTag");
        Intrinsics.checkNotNullParameter(name, "name");
        if (qWalletHomePage$RedPoint == null) {
            return;
        }
        u.m(actionName, String.valueOf(qWalletHomePage$RedPoint.type.get()), String.valueOf(qWalletHomePage$RedPoint.f41696id.get()), reportTag, name, 0, 32, null);
    }

    public static /* synthetic */ void y(QWalletHomePage$AppInfo qWalletHomePage$AppInfo, String str, String str2, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str2 = "";
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        v(qWalletHomePage$AppInfo, str, str2, i3);
    }

    public static final void z(@NotNull QWalletHomePage$AppInfo qWalletHomePage$AppInfo) {
        Intrinsics.checkNotNullParameter(qWalletHomePage$AppInfo, "<this>");
        g.n("app_info_" + F(qWalletHomePage$AppInfo) + "_market_" + com.tencent.mobileqq.base.a.c(), qWalletHomePage$AppInfo.market.f41694id.get());
    }
}
