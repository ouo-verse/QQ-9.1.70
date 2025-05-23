package ho;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.reborn.base.QZoneShellActivity;
import com.qzone.reborn.feedx.fragment.QZoneBlogDetailFragment;
import com.qzone.reborn.feedx.fragment.QZoneFeedXDetailFragment;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.util.QZoneFeedxAnimUtils;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.push.MsgNotification;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import g6.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J*\u0010\u000e\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ<\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0016\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\u001b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J$\u0010\u001c\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J$\u0010!\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fJ*\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J:\u0010%\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0006H\u0007J\u0016\u0010(\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0012\u00a8\u0006+"}, d2 = {"Lho/c;", "Lho/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "f", "Landroid/view/View;", "view", "", "from", "", "d", "c", "context", "", "ownerUin", "", "uuid", "clickView", "l", "e", "j", "Landroid/content/Context;", "Landroid/os/Bundle;", "bundle", "g", tl.h.F, "Lcooperation/qzone/model/PhotoParam;", "photoParam", "Lcooperation/qzone/model/PhotoInfo;", "photoInfo", "k", "i", "clickPos", "checkUgcKey", "b", "actionUrl", "Landroid/content/Intent;", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c implements a {
    private final boolean f(Activity r65, BusinessFeedData feedData) {
        CellLeftThumb leftThumb = feedData.getLeftThumb();
        BusinessFeedData originalInfoSafe = feedData.getOriginalInfoSafe();
        if (leftThumb == null && (originalInfoSafe == null || originalInfoSafe.getLeftThumb() == null)) {
            return false;
        }
        if (leftThumb != null && !TextUtils.isEmpty(leftThumb.remark)) {
            if (leftThumb.isUsePost()) {
                yo.d.e(leftThumb.getActionUrl(), r65, leftThumb.getPostDatas(), null);
            } else {
                yo.d.e(leftThumb.getActionUrl(), r65, null, null);
            }
            return true;
        }
        if (originalInfoSafe.getLeftThumb() == null || TextUtils.isEmpty(originalInfoSafe.getLeftThumb().remark)) {
            return false;
        }
        if (originalInfoSafe.getLeftThumb().isUsePost()) {
            yo.d.e(originalInfoSafe.getLeftThumb().getActionUrl(), r65, originalInfoSafe.getLeftThumb().getPostDatas(), null);
        } else {
            yo.d.e(feedData.getOriginalInfoSafe().getLeftThumb().getActionUrl(), r65, null, null);
        }
        return true;
    }

    public final Intent a(Context context, String actionUrl) {
        String name;
        boolean contains$default;
        String str;
        boolean contains$default2;
        boolean contains$default3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionUrl, "actionUrl");
        Bundle bundle = new Bundle();
        try {
            Uri parse = Uri.parse(actionUrl);
            bundle.putString(s4.c.CELLID, parse.getQueryParameter("uid"));
            String queryParameter = parse.getQueryParameter("subid");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) actionUrl, (CharSequence) AlbumCacheData.PHOTO_NUM, false, 2, (Object) null);
            if (contains$default) {
                HashMap hashMap = new HashMap();
                hashMap.put(7, parse.getQueryParameter(AlbumCacheData.PHOTO_NUM));
                Integer valueOf = Integer.valueOf(parse.getQueryParameter(AlbumCacheData.PHOTO_NUM));
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(uri.getQueryParameter(\"photonum\"))");
                if (valueOf.intValue() > 1) {
                    str = parse.getQueryParameter("bid");
                    contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) actionUrl, (CharSequence) "bid", false, 2, (Object) null);
                    if (contains$default3) {
                        hashMap.put(2, parse.getQueryParameter("bid"));
                        hashMap.put(1, parse.getQueryParameter("bid"));
                    }
                } else {
                    str = "";
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) actionUrl, (CharSequence) "bid", false, 2, (Object) null);
                    if (contains$default2) {
                        hashMap.put(2, parse.getQueryParameter("bid"));
                        hashMap.put(1, parse.getQueryParameter("bid"));
                    }
                }
                bundle.putParcelable("businessparam", new MapParcelable(hashMap));
                queryParameter = str;
            }
            bundle.putString("subid", queryParameter);
            String queryParameter2 = parse.getQueryParameter("uin");
            Intrinsics.checkNotNull(queryParameter2);
            bundle.putLong("targetuin", Long.parseLong(queryParameter2));
            String queryParameter3 = parse.getQueryParameter("appid");
            Intrinsics.checkNotNull(queryParameter3);
            bundle.putInt("appid", Integer.parseInt(queryParameter3));
        } catch (Exception e16) {
            QLog.e(MsgNotification.TAG, 1, "getQZoneDetailIntent", e16);
        }
        if (h.a(bundle)) {
            name = QZoneBlogDetailFragment.class.getName();
        } else {
            name = QZoneFeedXDetailFragment.class.getName();
        }
        Intent intent = new Intent(context, (Class<?>) QZoneShellActivity.class);
        intent.putExtra("public_fragment_class", name);
        intent.putExtras(bundle);
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    public final void c(Activity r112, BusinessFeedData feedData, View view, int from) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (feedData != null && r112 != null) {
            if (feedData.isFakeFeed()) {
                QLog.e("QZoneDetailNativeLauncher", 1, "fake feed isn't allowed jumping to feed detail page");
                return;
            }
            if (ef.b.d(feedData)) {
                QLog.i("QZoneDetailNativeLauncher", 1, "launchFeedDetail isGroupAlbumFeed");
                i.m().e(r112, feedData, from, null, view);
                return;
            }
            if (ef.b.f(feedData)) {
                QLog.i("QZoneDetailNativeLauncher", 1, "launchFeedDetail isIntimateFeed");
                i.o().d(r112, feedData, view);
                return;
            } else if (feedData.isGDTAdvFeed()) {
                QLog.i("QZoneDetailNativeLauncher", 1, "launchFeedDetail isGDTAdvFeed");
                d(r112, feedData, view, from);
                return;
            } else if (f(r112, feedData)) {
                QLog.i("QZoneDetailNativeLauncher", 1, "launchFeedDetail launchLeftThumbDetail");
                return;
            } else {
                l(r112, feedData, 0L, from, null, view);
                return;
            }
        }
        QLog.e("QZoneDetailNativeLauncher", 1, "launchFeedDetail error, " + feedData + ", context: " + r112);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        if (r12.getOriginalInfoSafe() == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (r12.getOriginalInfoSafe().getUser() != null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
    
        if (r12.isBrandUgcAdvFeeds() == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r13 != 1) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        com.qzone.misc.network.report.f.o(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        r2 = r12.getOriginalInfo();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "feedData.originalInfo");
        m(r10, r11, r2, r14, r13, null, null, 32, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x002a, code lost:
    
        if (r0.intValue() == 50) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0024 A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:45:0x0008, B:47:0x000e, B:49:0x0014, B:13:0x004b, B:15:0x0051, B:20:0x005c, B:23:0x0064, B:24:0x0067, B:35:0x0042, B:38:0x0031, B:42:0x0024), top: B:44:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0023  */
    @Deprecated(message = "\u5df2\u5e9f\u5f03, \u6d88\u606f\u9875\u91cd\u6784\u540e\u79fb\u9664")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(Activity context, BusinessFeedData feedData, int from, long ownerUin) {
        CellFeedCommInfo feedCommInfo;
        Integer valueOf;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (feedData != null) {
            try {
                BusinessFeedData originalInfo = feedData.getOriginalInfo();
                if (originalInfo != null && (feedCommInfo = originalInfo.getFeedCommInfo()) != null) {
                    valueOf = Integer.valueOf(feedCommInfo.actiontype);
                    boolean z17 = false;
                    if (valueOf != null) {
                    }
                    if (valueOf != null && valueOf.intValue() == 51) {
                        z16 = true;
                        if (!z16) {
                            if (valueOf != null && valueOf.intValue() == 1) {
                            }
                        }
                        z17 = true;
                    }
                    z16 = false;
                    if (!z16) {
                    }
                    z17 = true;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        valueOf = null;
        boolean z172 = false;
        if (valueOf != null) {
        }
        if (valueOf != null) {
            z16 = true;
            if (!z16) {
            }
            z172 = true;
        }
        z16 = false;
        if (!z16) {
        }
        z172 = true;
    }

    public final void j(Activity r65, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(r65, "activity");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        if (feedData.getFeedCommInfo().appid == 333) {
            if (feedData.getGiftInfo() == null) {
                QZLog.e("JumpDetailUtil", "feedData.getGiftInfo() is null");
                return;
            } else {
                e(r65, feedData);
                return;
            }
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putLong("uin", feedData.getOriginalInfoSafe().getUser().uin);
        bundle.putInt("appid", feedData.getOriginalInfoSafe().getFeedCommInfo().appid);
        bundle.putString(s4.c.CELLID, feedData.getOriginalInfoSafe().getIdInfo().cellId);
        bundle.putString("subid", feedData.getOriginalInfoSafe().getIdInfo().subId);
        bundle.putString(s4.c.UGCKEY, feedData.getFeedCommInfo().ugckey);
        feedData.getOriginalInfoSafe().getOperationInfo().cookie = feedData.getOperationInfoV2().cookie;
        com.qzone.reborn.feedx.util.m.b("extra_key_parcelable_feed_for_detail", feedData.getOriginalInfoSafe());
        if (feedData.getOperationInfo().busiParam != null) {
            bundle.putParcelable("businessparam", new MapParcelable(feedData.getOperationInfo().busiParam));
        }
        intent.putExtra("refer", "getPassiveFeeds");
        intent.putExtra("from", 1);
        intent.putExtras(bundle);
        i.e().h(r65, feedData, intent.getExtras());
    }

    public final void l(Activity context, BusinessFeedData feedData, long ownerUin, int from, String uuid, View clickView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        QLog.i("QZoneDetailNativeLauncher", 1, "launchQZoneFeedDetail");
        if (feedData.isFakeFeed()) {
            QLog.e("JumpDetailUtil", 1, "fake feed cannot jump detail in feedx");
            return;
        }
        if (feedData.getFeedCommInfo().appid == 333) {
            if (feedData.getGiftInfo() == null) {
                QZLog.e("JumpDetailUtil", "eedData.getGiftInfo() is null");
                return;
            } else {
                e(context, feedData);
                return;
            }
        }
        Intent intent = new Intent();
        intent.putExtra(PluginStatic.PARAM_PLUGIN_GESTURELOCK, false);
        Bundle bundle = new Bundle();
        if (ownerUin >= 10001) {
            bundle.putLong("uin", ownerUin);
        } else {
            bundle.putLong("uin", feedData.getHostUin());
        }
        bundle.putInt("appid", feedData.getFeedCommInfo().appid);
        bundle.putString(s4.c.CELLID, feedData.getIdInfo().cellId);
        bundle.putString("subid", feedData.getIdInfo().subId);
        bundle.putString("feedskey", feedData.getFeedCommInfo().feedskey);
        bundle.putString("curlikekey", feedData.getFeedCommInfo().curlikekey);
        long j3 = 1000;
        bundle.putLong("feedtime", feedData.getFeedCommInfo().time / j3);
        com.qzone.reborn.feedx.util.m.b("extra_key_parcelable_feed_for_detail", feedData);
        bundle.putBoolean("isTodayInHistoryFeed", feedData.getFeedCommInfo().isTodayInHistoryFeed());
        if (feedData.getOperationInfo().busiParam != null) {
            HashMap hashMap = new HashMap(feedData.getOperationInfo().busiParam);
            hashMap.put(42, String.valueOf(feedData.getFeedCommInfo().time / j3));
            bundle.putParcelable("businessparam", new MapParcelable(hashMap));
        }
        if (from == 0) {
            intent.putExtra("refer", "getActiveFeeds");
        }
        intent.putExtra("from", from);
        intent.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
        intent.putExtras(bundle);
        if (uuid != null) {
            intent.putExtra("recommend_report_uuid", uuid);
        }
        QZoneFeedxAnimUtils qZoneFeedxAnimUtils = QZoneFeedxAnimUtils.f55700a;
        QZoneBaseFeedItemView b16 = qZoneFeedxAnimUtils.b(clickView);
        if (b16 != null) {
            AnimationParams c16 = qZoneFeedxAnimUtils.c(b16);
            Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type android.os.Parcelable");
            intent.putExtra("feed_detail_animation_params", (Parcelable) c16);
        }
        i.e().h(context, feedData, intent.getExtras());
    }

    private final void d(Activity r36, BusinessFeedData feedData, View view, int from) {
        QLog.i("QZoneDetailNativeLauncher", 4, "[GdtClickHandlerForQzone] use new click handler for tangram ad");
        a.b bVar = new a.b();
        bVar.f401410c = 2;
        bVar.f401408a = new WeakReference<>(r36);
        bVar.f401414g = new WeakReference<>(view);
        bVar.f401409b = feedData;
        g6.a.g(bVar);
        if ((feedData != null ? feedData.getOperationInfoV2() : null) != null && !TextUtils.isEmpty(feedData.getOperationInfoV2().actionUrl)) {
            yo.d.e(feedData.getOperationInfoV2().actionUrl, r36, null, null);
        } else {
            ToastUtil.g("Debug\u63d0\u793a: \u5e7f\u544aFeeds\u65bd\u5de5\u4e2d", 1);
        }
    }

    @Deprecated(message = "\u5df2\u5e9f\u5f03, \u8001Feeds\u4e0b\u7ebf\u540e\u79fb\u9664")
    public final void b(Activity context, BusinessFeedData feedData, int from, long ownerUin, int clickPos, boolean checkUgcKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intrinsics.checkNotNull(feedData);
            int i3 = feedData.getFeedCommInfo().actiontype;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        yo.d.d(feedData.getFeedCommInfo().actionurl, context, null);
                        return;
                    }
                    if (i3 == 7) {
                        i.g().d(context, feedData.getFeedCommInfo().actionurl);
                        return;
                    }
                    if (i3 == 11) {
                        i.g().c(context, feedData, from);
                        return;
                    }
                    if (i3 == 22) {
                        if (feedData.getOperationInfo() == null || TextUtils.isEmpty(feedData.getOperationInfo().actionUrl)) {
                            return;
                        }
                        i.g().d(context, feedData.getOperationInfo().actionUrl);
                        return;
                    }
                    if (i3 != 50) {
                        if (i3 != 51) {
                            switch (i3) {
                                case 27:
                                case 28:
                                case 29:
                                    break;
                                default:
                                    return;
                            }
                        }
                    }
                }
                if (feedData.getOriginalInfoSafe() != null && feedData.getOriginalInfoSafe().getUser() != null) {
                    if (feedData.isBrandUgcAdvFeeds() && from == 1) {
                        com.qzone.misc.network.report.f.o(feedData);
                    }
                    j(context, feedData);
                    return;
                }
                return;
            }
            if (feedData.isBrandUgcAdvFeeds() && from == 11) {
                if (checkUgcKey) {
                    com.qzone.misc.network.report.f.p(feedData);
                } else {
                    com.qzone.misc.network.report.f.b(feedData, 1, clickPos);
                }
            }
            m(this, context, feedData, ownerUin, from, null, null, 32, null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public final void h(Activity activity, BusinessFeedData businessFeedData, Bundle bundle) {
        boolean z16 = false;
        if (businessFeedData != null && businessFeedData.isSecretFeed()) {
            z16 = true;
        }
        if (z16) {
            if (businessFeedData.getFeedCommInfo().actionurl != null) {
                yo.d.d(businessFeedData.getFeedCommInfo().actionurl, activity, null);
                return;
            }
            return;
        }
        g(activity, bundle);
    }

    public final void e(Activity r56, BusinessFeedData feedData) {
        if (r56 == null || feedData == null) {
            return;
        }
        i.q(r56, yo.f.j(yo.f.w(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_GIFTDETAILPAGE, "https://h5.qzone.qq.com/gift/detail?_wv=2097155&uin={uin}&ugcid={ugcid}"), LoginData.getInstance().getUin()), "{ugcid}", feedData.getGiftInfo().giftBackId));
    }

    public final void g(Context context, Bundle bundle) {
        String name;
        if (context == null || bundle == null) {
            return;
        }
        if (h.a(bundle)) {
            name = QZoneBlogDetailFragment.class.getName();
        } else {
            name = QZoneFeedXDetailFragment.class.getName();
        }
        i.d(context, QZoneFeedxAnimUtils.f55700a.a(context, (AnimationParams) bundle.getParcelable("feed_detail_animation_params"))).withString("public_fragment_class", name).withAll(bundle).request();
        jo.h.f410717a.h("page_launch_feed_detail").t("LAUNCH_CLICK");
    }

    public final void k(Activity r102, PhotoParam photoParam, PhotoInfo photoInfo) {
        if (photoParam != null && r102 != null && photoInfo != null) {
            Bundle bundle = new Bundle();
            if (photoParam.appid != 4) {
                bundle.putString(s4.c.CELLID, photoParam.cell_id);
                bundle.putString("subid", photoParam.cell_subId);
                bundle.putParcelable("businessparam", new MapParcelable(photoParam.busi_param));
                bundle.putLong("uin", photoParam.feedUin);
            } else {
                Map map = photoParam.busi_param;
                if (map == null) {
                    map = new HashMap();
                }
                map.put(2, photoInfo.lloc);
                map.put(1, photoInfo.sloc);
                map.put(7, "1");
                bundle.putParcelable("businessparam", new MapParcelable(map));
                bundle.putString(s4.c.CELLID, photoParam.albumid);
                bundle.putLong("uin", photoParam.ownerUin);
            }
            bundle.putString("lloc", photoInfo.lloc);
            bundle.putInt("appid", photoParam.appid);
            bundle.putInt("source", 2);
            bundle.putString(s4.c.UGCKEY, photoParam.feedId);
            bundle.putString("refer", QZoneHelper.QZoneAppConstants.REFER_PHOTO_PREVIEW);
            bundle.putBoolean("isTodayInHistoryFeed", photoParam.isTihFeed);
            Navigator.withRequestCode$default(i.d(r102, "/qzone/holder_page").withString("public_fragment_class", QZoneFeedXDetailFragment.class.getName()).withAll(bundle), r102, QZoneContant.REQUEST_CODE_PHOTO_DETAIL, (Bundle) null, 4, (Object) null).request();
            jo.h.f410717a.h("page_launch_feed_detail").t("LAUNCH_CLICK");
            return;
        }
        RFWLog.d("QZoneDetailNativeLauncher", RFWLog.USR, "launchPhotoDetail fail, photoParam: " + photoParam + ", activity: " + r102 + ", photoInfo: " + photoInfo);
    }

    public static /* synthetic */ void m(c cVar, Activity activity, BusinessFeedData businessFeedData, long j3, int i3, String str, View view, int i16, Object obj) {
        cVar.l(activity, businessFeedData, j3, i3, str, (i16 & 32) != 0 ? null : view);
    }
}
