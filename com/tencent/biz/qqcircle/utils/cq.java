package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.PbExtKt;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qzone.api.IQZoneVideoApi;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$RightInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StRight;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.RightFlag;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000f\u001a\u00020\u000eJ\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J \u0010\u001f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eJ\u0010\u0010 \u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010!\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\"\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010#\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010$\u001a\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010%\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010'\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\u000eJ\u001c\u0010,\u001a\u00020\u00142\u0014\u0010+\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)\u0018\u00010(J\u000e\u0010-\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u00060"}, d2 = {"Lcom/tencent/biz/qqcircle/utils/cq;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "key", "c", "Lfeedcloud/FeedCloudRead$StGetFeedListReq;", "req", "", "b", "Lfeedcloud/FeedCloudCommon$StCommonExt;", "extInfo", "a", "", "rightFlag", "j", "k", "f", "g", "", "r", "e", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "newRight", "downLoadOper", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", DomainData.DOMAIN_NAME, "o", ReportConstant.COSTREPORT_PREFIX, "i", "from", "u", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Le30/b;", "uiStateData", "t", "p", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class cq {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final cq f92752a = new cq();

    cq() {
    }

    private final String c(FeedCloudMeta$StFeed feed, String key) {
        String str;
        Object obj;
        PBBytesField pBBytesField;
        ByteStringMicro byteStringMicro;
        if (feed == null) {
            return "";
        }
        try {
            List<FeedCloudCommon$BytesEntry> list = feed.busiTranparent.get();
            Intrinsics.checkNotNullExpressionValue(list, "stFeed.busiTranparent.get()");
            Iterator<T> it = list.iterator();
            while (true) {
                str = null;
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((FeedCloudCommon$BytesEntry) obj).key.get(), key)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = (FeedCloudCommon$BytesEntry) obj;
            if (feedCloudCommon$BytesEntry != null && (pBBytesField = feedCloudCommon$BytesEntry.value) != null && (byteStringMicro = pBBytesField.get()) != null) {
                str = byteStringMicro.toStringUtf8();
            }
            if (str == null) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "stFeed.busiTranparent.ge\u2026t()?.toStringUtf8() ?: \"\"");
            return str;
        } catch (RuntimeException e16) {
            QLog.e("QQVideoUtil", 1, "[getBusiTranparentQZoneValueFromStFeed] key=" + key + ", error=" + e16);
            return "";
        }
    }

    public final void a(@Nullable FeedCloudCommon$StCommonExt extInfo) {
        if (extInfo == null) {
            return;
        }
        if (!extInfo.has()) {
            extInfo.setHasFlag(true);
        }
        String experimentId = ((IQZoneVideoApi) QRoute.api(IQZoneVideoApi.class)).getExperimentId();
        String experimentGrayId = ((IQZoneVideoApi) QRoute.api(IQZoneVideoApi.class)).getExperimentGrayId();
        if (experimentId == null) {
            experimentId = "";
        }
        if (experimentGrayId == null) {
            experimentGrayId = "";
        }
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("qq_video_exp_id");
        feedCloudCommon$Entry.value.set(experimentId);
        extInfo.mapInfo.add(feedCloudCommon$Entry);
        FeedCloudCommon$Entry feedCloudCommon$Entry2 = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry2.key.set("qq_video_exp_group_id");
        feedCloudCommon$Entry2.value.set(experimentGrayId);
        extInfo.mapInfo.add(feedCloudCommon$Entry2);
    }

    public final void b(@Nullable FeedCloudRead$StGetFeedListReq req) {
        if (req == null) {
            return;
        }
        a(req.extInfo);
    }

    @NotNull
    public final String d(@Nullable FeedCloudMeta$StFeed feed) {
        String d16;
        if (feed == null || (d16 = bh.d(feed.extInfo.get(), v4.b.CLIENTKEY)) == null) {
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(d16, "QFSExtInfoUtil.getValueF\u2026InfoKey.CLIENT_KEY) ?: \"\"");
        return d16;
    }

    public final int e(@NotNull FeedCloudMeta$StFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        return feed.right.commentRightFlag.get();
    }

    @NotNull
    public final String f(int rightFlag) {
        if (rightFlag == RightFlag.RIGHTFLAG_NONE.getValue()) {
            String a16 = h.a(R.string.f184403ls);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qcircle_p\u2026ssage_setting_choose_all)");
            return a16;
        }
        if (rightFlag == RightFlag.RIGHTFLAG_QQFRIEND.getValue()) {
            String a17 = h.a(R.string.f1922146w);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_only_qq_friends)");
            return a17;
        }
        if (rightFlag == RightFlag.RIGHTFLAG_WHITELIST.getValue()) {
            String a18 = h.a(R.string.f1922246x);
            Intrinsics.checkNotNullExpressionValue(a18, "qqStr(R.string.qfs_only_some_friends)");
            return a18;
        }
        if (rightFlag == RightFlag.RIGHTFLAG_BLACKLIST.getValue()) {
            String a19 = h.a(R.string.f195914fw);
            Intrinsics.checkNotNullExpressionValue(a19, "qqStr(R.string.qfs_some_people_not_allow_comment)");
            return a19;
        }
        if (rightFlag == RightFlag.RIGHTFLAG_NOBODY.getValue()) {
            String a26 = h.a(R.string.f188673xb);
            Intrinsics.checkNotNullExpressionValue(a26, "qqStr(R.string.qfs_close_comment)");
            return a26;
        }
        return "";
    }

    @NotNull
    public final String g(int rightFlag) {
        if (rightFlag == RightFlag.RIGHTFLAG_NONE.getValue()) {
            String a16 = h.a(R.string.f195374ef);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_setting_all_comment)");
            return a16;
        }
        if (rightFlag == RightFlag.RIGHTFLAG_QQFRIEND.getValue()) {
            String a17 = h.a(R.string.f195414ej);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_setting_only_qq_friends)");
            return a17;
        }
        if (rightFlag == RightFlag.RIGHTFLAG_WHITELIST.getValue()) {
            String a18 = h.a(R.string.f195424ek);
            Intrinsics.checkNotNullExpressionValue(a18, "qqStr(R.string.qfs_setting_only_some_friends)");
            return a18;
        }
        if (rightFlag == RightFlag.RIGHTFLAG_BLACKLIST.getValue()) {
            String a19 = h.a(R.string.f195444em);
            Intrinsics.checkNotNullExpressionValue(a19, "qqStr(R.string.qfs_setti\u2026people_not_allow_comment)");
            return a19;
        }
        if (rightFlag == RightFlag.RIGHTFLAG_NOBODY.getValue()) {
            String a26 = h.a(R.string.f195384eg);
            Intrinsics.checkNotNullExpressionValue(a26, "qqStr(R.string.qfs_setting_close_comment)");
            return a26;
        }
        return "";
    }

    public final int h(@Nullable FeedCloudMeta$StFeed feed) {
        FeedCloudMeta$RightInfo feedCloudMeta$RightInfo;
        PBEnumField pBEnumField;
        if (feed == null) {
            return 0;
        }
        cq cqVar = f92752a;
        if (cqVar.s(feed)) {
            int i3 = cqVar.i(feed);
            if (i3 != 1) {
                if (i3 == 2) {
                    return 2;
                }
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            return 0;
                        }
                        return 5;
                    }
                    return 3;
                }
                return 4;
            }
            return 1;
        }
        FeedCloudMeta$StRight feedCloudMeta$StRight = feed.right;
        if (feedCloudMeta$StRight == null || (feedCloudMeta$RightInfo = feedCloudMeta$StRight.ugcRight) == null || (pBEnumField = feedCloudMeta$RightInfo.rightFlag) == null) {
            return 0;
        }
        int i16 = pBEnumField.get();
        if (i16 != 1) {
            if (i16 != 2) {
                return 0;
            }
            return 3;
        }
        return 1;
    }

    public final int i(@Nullable FeedCloudMeta$StFeed feed) {
        Integer intOrNull;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(c(feed, "feed_output_right"));
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 0;
    }

    @NotNull
    public final String j(int rightFlag) {
        if (rightFlag != 1) {
            if (rightFlag != 2) {
                if (rightFlag != 3) {
                    if (rightFlag != 5) {
                        if (rightFlag != 6) {
                            return "";
                        }
                        String a16 = h.a(R.string.f19301492);
                        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_perso\u2026l_feed_private_blacklist)");
                        return a16;
                    }
                    String a17 = h.a(R.string.f19302493);
                    Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_personal_feed_private_onlyself)");
                    return a17;
                }
                String a18 = h.a(R.string.f19304495);
                Intrinsics.checkNotNullExpressionValue(a18, "qqStr(R.string.qfs_perso\u2026l_feed_private_whitelist)");
                return a18;
            }
            String a19 = h.a(R.string.f19303494);
            Intrinsics.checkNotNullExpressionValue(a19, "qqStr(R.string.qfs_perso\u2026l_feed_private_qq_friend)");
            return a19;
        }
        String a26 = h.a(R.string.f19300491);
        Intrinsics.checkNotNullExpressionValue(a26, "qqStr(R.string.qfs_personal_feed_private_all)");
        return a26;
    }

    @NotNull
    public final String k(int rightFlag) {
        if (rightFlag != 1) {
            if (rightFlag != 2) {
                if (rightFlag != 3) {
                    if (rightFlag != 5) {
                        if (rightFlag != 6) {
                            return "";
                        }
                        String a16 = h.a(R.string.f195924fx);
                        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_some_people_not_allow_watch)");
                        return a16;
                    }
                    String a17 = h.a(R.string.f19299490);
                    Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_personal_feed_private)");
                    return a17;
                }
                String a18 = h.a(R.string.f195904fv);
                Intrinsics.checkNotNullExpressionValue(a18, "qqStr(R.string.qfs_some_friends)");
                return a18;
            }
            String a19 = h.a(R.string.f194424bv);
            Intrinsics.checkNotNullExpressionValue(a19, "qqStr(R.string.qfs_qq_friends)");
            return a19;
        }
        String a26 = h.a(R.string.f184403ls);
        Intrinsics.checkNotNullExpressionValue(a26, "qqStr(R.string.qcircle_p\u2026ssage_setting_choose_all)");
        return a26;
    }

    @Nullable
    public final Drawable l(@Nullable Context context, int rightFlag) {
        int i3;
        if (rightFlag != 1) {
            if (rightFlag != 2) {
                if (rightFlag != 3) {
                    if (rightFlag != 5) {
                        if (rightFlag != 6) {
                            i3 = -1;
                        } else {
                            i3 = R.drawable.osj;
                        }
                    } else {
                        i3 = R.drawable.oso;
                    }
                } else {
                    i3 = R.drawable.oss;
                }
            } else {
                i3 = R.drawable.osq;
            }
        } else {
            i3 = R.drawable.osl;
        }
        if (i3 == -1) {
            return null;
        }
        return QCircleSkinHelper.getInstance().getDrawable(context, i3);
    }

    @Nullable
    public final Drawable m(@Nullable Context context, int rightFlag) {
        int i3;
        if (rightFlag != 1) {
            if (rightFlag != 2) {
                if (rightFlag != 3) {
                    if (rightFlag != 5) {
                        if (rightFlag != 6) {
                            i3 = -1;
                        } else {
                            i3 = R.drawable.osk;
                        }
                    } else {
                        i3 = R.drawable.osp;
                    }
                } else {
                    i3 = R.drawable.ost;
                }
            } else {
                i3 = R.drawable.osr;
            }
        } else {
            i3 = R.drawable.osm;
        }
        if (i3 == -1) {
            return null;
        }
        return QCircleSkinHelper.getInstance().getDrawable(context, i3);
    }

    @NotNull
    public final String n(@Nullable FeedCloudMeta$StFeed feed) {
        return c(feed, "qzone_feed_id");
    }

    @NotNull
    public final String o(@Nullable FeedCloudMeta$StFeed feed) {
        List split$default;
        if (feed != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) f92752a.n(feed), new String[]{"_"}, false, 0, 6, (Object) null);
            if (split$default.size() >= 3) {
                return (String) split$default.get(2);
            }
        }
        return "";
    }

    public final int p(@NotNull FeedCloudMeta$StFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        int QQ_CIRCLE_VIDEO = QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO();
        if (s(feed)) {
            return 102;
        }
        return QQ_CIRCLE_VIDEO;
    }

    @NotNull
    public final String q(@Nullable FeedCloudMeta$StFeed feed) {
        return c(feed, "qzone_ugc_key");
    }

    public final boolean r(@Nullable FeedCloudMeta$StFeed feed) {
        if (feed != null && e(feed) == RightFlag.RIGHTFLAG_NOBODY.getValue()) {
            return true;
        }
        return false;
    }

    public final boolean s(@Nullable FeedCloudMeta$StFeed feed) {
        return Intrinsics.areEqual(c(feed, "xsj_sync_content_src"), "100");
    }

    public final boolean t(@Nullable UIStateData<List<e30.b>> uiStateData) {
        if (uiStateData == null || uiStateData.getState() != 4) {
            return false;
        }
        if (uiStateData.getRetCode() != 20002 && uiStateData.getRetCode() != MiniAppCmdUtil.MINI_RET_CODE_TEMPLATEID_COUNT_OUT_OF_MAX && uiStateData.getRetCode() != 10014) {
            return false;
        }
        return true;
    }

    public final void u(@Nullable Context context, @Nullable FeedCloudMeta$StFeed feed, int from) {
        if (context == null) {
            QLog.e("QQVideoUtil", 1, "[jumpH5PermissionSettingPage] context is null");
        }
        if (feed == null) {
            QLog.e("QQVideoUtil", 1, "[jumpH5PermissionSettingPage] feed is null");
        }
        if (feed != null) {
            StringBuilder sb5 = new StringBuilder(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("101601", "https://h5.qzone.qq.com/v2/wezone/qq-video/right-setting/?"));
            sb5.append("feedId=");
            sb5.append(feed.f398449id.get());
            sb5.append("&createTime=");
            sb5.append(feed.createTime.get());
            sb5.append("&posterId=");
            sb5.append(feed.poster.f398463id.get());
            sb5.append("&downLoadOper=");
            sb5.append(!feed.right.notAllowDownLoad.get() ? 1 : 0);
            sb5.append("&feedsid=");
            cq cqVar = f92752a;
            sb5.append(cqVar.n(feed));
            sb5.append("&from=");
            sb5.append(from);
            sb5.append("&ugcKey=");
            sb5.append(cqVar.q(feed));
            sb5.append("&isQUIPage=1");
            QLog.d("QQVideoUtil", 1, "[jumpH5PermissionSettingPage] schema=" + ((Object) sb5));
            if (context != null) {
                QCircleSchemeLauncher.f(context, sb5.toString());
            }
        }
    }

    public final void v(@Nullable FeedCloudMeta$StFeed feed, int newRight, int downLoadOper) {
        boolean z16;
        if (feed != null) {
            boolean z17 = false;
            if (newRight != 0 && newRight != f92752a.i(feed)) {
                PBRepeatMessageField<FeedCloudCommon$BytesEntry> pBRepeatMessageField = feed.busiTranparent;
                Intrinsics.checkNotNullExpressionValue(pBRepeatMessageField, "it.busiTranparent");
                byte[] bytes = String.valueOf(newRight).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                PbExtKt.c(pBRepeatMessageField, "feed_output_right", bytes);
                if (newRight != 1) {
                    feed.opMask2.get().add(26);
                } else if (feed.opMask2.get().contains(26)) {
                    feed.opMask2.get().remove((Object) 26);
                }
                z16 = true;
            } else {
                z16 = false;
            }
            if (downLoadOper == 0 || downLoadOper == 1) {
                if (downLoadOper == 0) {
                    z17 = true;
                }
                if (z17 != feed.right.notAllowDownLoad.get()) {
                    feed.right.notAllowDownLoad.set(z17);
                    z16 = true;
                }
            }
            if (z16) {
                QLog.d("QQVideoUtil", 1, "[updateGlobalQQVideoRightInfo] needUpdateGlobal=" + z16 + ", newRight=" + newRight + ", downLoadOper=" + downLoadOper);
                w20.a.j().initOrUpdateGlobalState((w20.a) new e30.b(feed), true);
            }
        }
    }
}
