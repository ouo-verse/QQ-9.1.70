package mk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.intimate.bean.QZIntimateSpaceVipInfoBean;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.util.k;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import ij.i;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateProfileReader$CreateMoreSpaceGuide;
import qzone.QZIntimateProfileReader$SpaceThemeInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bF\u0010GJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002J\u0017\u0010\u001d\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u001d\u0010\u0010J\u0017\u0010\u001e\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u001e\u0010\u0010J\u0017\u0010\u001f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u001f\u0010\u0010J\u0017\u0010 \u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b \u0010\u0010J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002J\u0016\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0002J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010!\u001a\u00020&J\u000e\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(J\u0006\u0010,\u001a\u00020\u0014J\u000e\u0010.\u001a\u00020\r2\u0006\u0010-\u001a\u00020\rJ\u000e\u00101\u001a\u00020\r2\u0006\u00100\u001a\u00020/J\u0006\u00102\u001a\u00020\u0004J\u001f\u00104\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u00103\u001a\u00020\u0004\u00a2\u0006\u0004\b4\u00105J\u001f\u00109\u001a\u00020\r2\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00142\b\u00108\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b;\u0010<J\u0006\u0010=\u001a\u00020\u0004J\u000e\u0010?\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u0014J\u000e\u0010@\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0014J\u0017\u0010A\u001a\u00020\u00142\b\u00108\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\bA\u0010<J\u001f\u0010B\u001a\u00020\r2\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\bB\u0010:J#\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140C2\b\u00108\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\bD\u0010E\u00a8\u0006H"}, d2 = {"Lmk/d;", "", "Lij/i;", "spaceItemBean", "", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lqzone/QZIntimateProfileReader$CreateMoreSpaceGuide;", "createMoreSpaceGuide", "G", BdhLogUtil.LogTag.Tag_Conn, "v", "E", "", "type", UserInfo.SEX_FEMALE, "(Ljava/lang/Integer;)Z", "B", ReportConstant.COSTREPORT_PREFIX, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "y", "H", "w", "t", "bean", HippyTKDListViewAdapter.X, "oldItem", "newItem", "u", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "I", "Landroid/content/Context;", "context", "", "J", "r", "intimateType", "a", "", "checkInDays", "j", "L", "isFriendCheckInAlready", "d", "(Ljava/lang/Integer;Z)Ljava/lang/String;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "spaceType", "c", "(Landroid/app/Activity;Ljava/lang/Integer;)I", "i", "(Ljava/lang/Integer;)Ljava/lang/String;", "K", "spaceId", "e", "b", tl.h.F, "g", "Lkotlin/Pair;", "f", "(Ljava/lang/Integer;)Lkotlin/Pair;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f416875a = new d();

    d() {
    }

    public final boolean A(i item) {
        Intrinsics.checkNotNullParameter(item, "item");
        PBBoolField pBBoolField = item.getSpaceAbsData().has_recent_pub;
        return pBBoolField != null && pBBoolField.get();
    }

    public final boolean B(i spaceItemBean) {
        Intrinsics.checkNotNullParameter(spaceItemBean, "spaceItemBean");
        return spaceItemBean.getType() == 5 || spaceItemBean.getType() == 6 || spaceItemBean.getType() == 7 || spaceItemBean.getType() == 8;
    }

    public final boolean C(i spaceItemBean) {
        Intrinsics.checkNotNullParameter(spaceItemBean, "spaceItemBean");
        int type = spaceItemBean.getType();
        return type == 0 || type == 2 || type == 3 || type == 1;
    }

    public final boolean D(i spaceItemBean) {
        Intrinsics.checkNotNullParameter(spaceItemBean, "spaceItemBean");
        return C(spaceItemBean) || E(spaceItemBean) || B(spaceItemBean);
    }

    public final boolean E(i spaceItemBean) {
        Intrinsics.checkNotNullParameter(spaceItemBean, "spaceItemBean");
        return spaceItemBean.getType() == 4;
    }

    public final boolean I(QZoneIntimateSpaceBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (ArrayUtils.isOutOfArrayIndex(0, bean.getMembers())) {
            return false;
        }
        for (User user : bean.getMembers()) {
            if (!TextUtils.isEmpty(String.valueOf(user.uin)) && TextUtils.equals(String.valueOf(user.uin), String.valueOf(LoginData.getInstance().getUin()))) {
                return true;
            }
        }
        return false;
    }

    public final void J(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StringBuilder sb5 = new StringBuilder(QZoneConfigHelper.p0());
        if (TextUtils.isEmpty(sb5)) {
            QLog.e("QZoneIntimateSpaceDataUtil", 1, "[handleEntranceItemClick] jump_url is empty");
            return;
        }
        QLog.d("QZoneIntimateSpaceDataUtil", 1, "[handleEntranceItemClick] jump_url = " + ((Object) sb5));
        yo.d.d(sb5.toString(), context, null);
    }

    public final boolean K() {
        com.qzone.reborn.a aVar = com.qzone.reborn.a.f52169a;
        return aVar.d("exp_intimate_space_clock_in_share", "_B") || aVar.d("exp_intimate_space_clock_in_share", "_C");
    }

    public final boolean L() {
        return com.qzone.reborn.util.i.b().d("HAS_QUERY_JOB_BEFORE", false) && !com.qzone.reborn.util.i.b().d("WHETHER_HAS_MIGRATION_JOB", false);
    }

    public final int a(int intimateType) {
        if (intimateType != 5) {
            if (intimateType != 6) {
                if (intimateType != 7) {
                    if (intimateType != 8) {
                        return intimateType;
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public final boolean b(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        return com.qzone.reborn.util.i.b().d(e(spaceId), false);
    }

    public final int c(Activity activity, Integer spaceType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (y(spaceType)) {
            return ef.a.f396213a.a("#66FFDDEB", activity.getColor(R.color.qui_common_brand_standard));
        }
        if (H(spaceType)) {
            return ef.a.f396213a.a("#66FFEED7", activity.getColor(R.color.qui_common_brand_standard));
        }
        if (t(spaceType)) {
            return ef.a.f396213a.a("#66E7E4FF", activity.getColor(R.color.qui_common_brand_standard));
        }
        if (w(spaceType)) {
            return ef.a.f396213a.a("#6600BBFA", activity.getColor(R.color.qui_common_brand_standard));
        }
        return ef.a.f396213a.a("#660099FF", activity.getColor(R.color.qui_common_brand_standard));
    }

    public final String d(Integer type, boolean isFriendCheckInAlready) {
        if (y(type)) {
            if (isFriendCheckInAlready) {
                return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/calendar/ark/lover.png";
            }
            return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/calendar/ark/lover-single.png";
        }
        if (H(type)) {
            if (isFriendCheckInAlready) {
                return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/calendar/ark/sister.png";
            }
            return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/calendar/ark/sister-single.png";
        }
        if (t(type)) {
            if (isFriendCheckInAlready) {
                return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/calendar/ark/homie.png";
            }
            return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/calendar/ark/homie-single.png";
        }
        if (w(type)) {
            if (isFriendCheckInAlready) {
                return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/calendar/ark/friend.png";
            }
            return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/calendar/ark/friend-single.png";
        }
        if (isFriendCheckInAlready) {
            return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/calendar/ark/dazi.png";
        }
        return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/calendar/ark/dazi-single.png";
    }

    public final String e(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        return "auto_share_calendar_card_to_qzone_" + spaceId;
    }

    public final Pair<String, String> f(Integer spaceType) {
        if (y(spaceType)) {
            return new Pair<>("https://qzonestyle.gtimg.cn/qzone/client/intimate_space/ark/lover.png", "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/ark/lover-icon.png");
        }
        if (H(spaceType)) {
            return new Pair<>("https://qzonestyle.gtimg.cn/qzone/client/intimate_space/ark/sister.png", "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/ark/sister-icon.png");
        }
        if (t(spaceType)) {
            return new Pair<>("https://qzonestyle.gtimg.cn/qzone/client/intimate_space/ark/homie.png", "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/calendar/ark/sidang-icon.png");
        }
        if (w(spaceType)) {
            return new Pair<>("https://qzonestyle.gtimg.cn/qzone/client/intimate_space/ark/brother.png", "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/calendar/ark/jiyou-icon.png");
        }
        return new Pair<>("https://qzonestyle.gtimg.cn/qzone/client/intimate_space/ark/dazi.png", "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/ark/dazi-icon.png");
    }

    public final int g(Activity activity, Integer spaceType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (y(spaceType)) {
            return ef.a.f396213a.a("#FF80B4", activity.getColor(R.color.qui_common_brand_standard));
        }
        if (H(spaceType)) {
            return ef.a.f396213a.a("#FA9919", activity.getColor(R.color.qui_common_brand_standard));
        }
        if (t(spaceType)) {
            return ef.a.f396213a.a("#968CFF", activity.getColor(R.color.qui_common_brand_standard));
        }
        if (w(spaceType)) {
            return ef.a.f396213a.a("#00BBFA", activity.getColor(R.color.qui_common_brand_standard));
        }
        return ef.a.f396213a.a("#0099FF", activity.getColor(R.color.qui_common_brand_standard));
    }

    public final String h(Integer spaceType) {
        if (y(spaceType)) {
            return "\u60c5\u4fa3";
        }
        if (H(spaceType)) {
            return "\u95fa\u871c";
        }
        if (t(spaceType)) {
            return "\u6b7b\u515a";
        }
        if (w(spaceType)) {
            return "\u57fa\u53cb";
        }
        return "\u642d\u5b50";
    }

    public final String i(Integer spaceType) {
        if (y(spaceType)) {
            return QzoneConfig.DefaultValue.USERHOME_BAR_LOVER_ZONE_NAME;
        }
        if (H(spaceType)) {
            return "\u95fa\u871c\u7a7a\u95f4";
        }
        if (t(spaceType)) {
            return "\u6b7b\u515a\u7a7a\u95f4";
        }
        if (w(spaceType)) {
            return "\u57fa\u53cb\u7a7a\u95f4";
        }
        return "\u642d\u5b50\u7a7a\u95f4";
    }

    public final int j(long checkInDays) {
        if (checkInDays < 4) {
            return 1;
        }
        if (checkInDays < 16) {
            return 2;
        }
        return 3;
    }

    public final String k(i item) {
        Intrinsics.checkNotNullParameter(item, "item");
        QZIntimateProfileReader$SpaceThemeInfo qZIntimateProfileReader$SpaceThemeInfo = item.getSpaceAbsData().space_theme_info;
        QZIntimateProfileReader$SpaceThemeInfo qZIntimateProfileReader$SpaceThemeInfo2 = qZIntimateProfileReader$SpaceThemeInfo != null ? qZIntimateProfileReader$SpaceThemeInfo.get() : null;
        if (qZIntimateProfileReader$SpaceThemeInfo2 == null) {
            return "";
        }
        PBStringField pBStringField = qZIntimateProfileReader$SpaceThemeInfo2.card_daytime_color;
        String str = pBStringField != null ? pBStringField.get() : null;
        return str == null ? "" : str;
    }

    public final String l(i item) {
        Intrinsics.checkNotNullParameter(item, "item");
        String str = item.getSpaceAbsData().relation_icon.relation_icon.get();
        Intrinsics.checkNotNullExpressionValue(str, "item.spaceAbsData.relati\u2026_icon.relation_icon.get()");
        return str;
    }

    public final String m(i item) {
        Intrinsics.checkNotNullParameter(item, "item");
        QZIntimateProfileReader$SpaceThemeInfo qZIntimateProfileReader$SpaceThemeInfo = item.getSpaceAbsData().space_theme_info;
        QZIntimateProfileReader$SpaceThemeInfo qZIntimateProfileReader$SpaceThemeInfo2 = qZIntimateProfileReader$SpaceThemeInfo != null ? qZIntimateProfileReader$SpaceThemeInfo.get() : null;
        if (qZIntimateProfileReader$SpaceThemeInfo2 == null) {
            return "";
        }
        PBStringField pBStringField = qZIntimateProfileReader$SpaceThemeInfo2.card_night_color;
        String str = pBStringField != null ? pBStringField.get() : null;
        return str == null ? "" : str;
    }

    public final String n(i item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (ArrayUtils.isOutOfArrayIndex(0, item.getSpaceAbsData().partners.get())) {
            return "";
        }
        String str = item.getSpaceAbsData().partners.get(0).partner_icon.relation_icon.get();
        Intrinsics.checkNotNullExpressionValue(str, "item.spaceAbsData.partne\u2026_icon.relation_icon.get()");
        return str;
    }

    public final String o(i item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (ArrayUtils.isOutOfArrayIndex(0, item.getSpaceAbsData().user.get())) {
            return "";
        }
        PBStringField pBStringField = item.getSpaceAbsData().user.get(0).nick;
        String str = pBStringField != null ? pBStringField.get() : null;
        return str == null ? "" : str;
    }

    public final String p(i item) {
        String str;
        Intrinsics.checkNotNullParameter(item, "item");
        return (ArrayUtils.isOutOfArrayIndex(0, item.getSpaceAbsData().user.get()) || (str = item.getSpaceAbsData().user.get(0).uid.get()) == null) ? "" : str;
    }

    public final int q(i item) {
        Intrinsics.checkNotNullParameter(item, "item");
        QZIntimateSpaceVipInfoBean vipInfoBean = item.getVipInfoBean();
        if (vipInfoBean != null) {
            return vipInfoBean.getMemberStatus();
        }
        return -1;
    }

    public final String r() {
        if (k.f59549a.f()) {
            return com.qzone.reborn.configx.g.f53821a.b().X0();
        }
        return com.qzone.reborn.configx.g.f53821a.b().W0();
    }

    public final boolean u(i oldItem, i newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!TextUtils.equals(o(oldItem), o(newItem)) || !TextUtils.equals(p(oldItem), p(newItem)) || A(oldItem) != A(newItem) || !TextUtils.equals(k(oldItem), k(newItem)) || !TextUtils.equals(m(oldItem), m(newItem)) || !TextUtils.equals(l(oldItem), l(newItem)) || !TextUtils.equals(n(oldItem), n(newItem)) || q(oldItem) != q(newItem)) {
            return false;
        }
        QLog.i("QZoneIntimateSpaceDataUtil", 1, " isNeedUpdateDesc is " + newItem.getIsNeedUpdateDesc());
        return !newItem.getIsNeedUpdateDesc();
    }

    public final boolean x(i bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        return bean.getType() == 1000 || bean.getStatus() == 100;
    }

    public final boolean z(i spaceItemBean) {
        Intrinsics.checkNotNullParameter(spaceItemBean, "spaceItemBean");
        return spaceItemBean.getType() == 10001;
    }

    public final int s() {
        return ef.d.b(50);
    }

    public final boolean F(Integer type) {
        return type != null && type.intValue() == 4;
    }

    public final boolean H(Integer type) {
        return (type != null && type.intValue() == 2) || (type != null && type.intValue() == 7);
    }

    public final boolean t(Integer type) {
        return (type != null && type.intValue() == 3) || (type != null && type.intValue() == 8);
    }

    public final boolean v(i spaceItemBean) {
        return spaceItemBean != null && spaceItemBean.getStatus() == 3;
    }

    public final boolean y(Integer type) {
        return (type != null && type.intValue() == 0) || (type != null && type.intValue() == 5);
    }

    public final boolean G(QZIntimateProfileReader$CreateMoreSpaceGuide createMoreSpaceGuide) {
        if (createMoreSpaceGuide == null) {
            return false;
        }
        return !TextUtils.isEmpty(createMoreSpaceGuide.guide_text.get());
    }

    public final boolean w(Integer type) {
        if (type != null && type.intValue() == 1) {
            return true;
        }
        return type != null && type.intValue() == 6;
    }
}
