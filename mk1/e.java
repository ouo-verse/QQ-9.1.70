package mk1;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryShareViewEvent;
import com.tencent.mobileqq.guild.feed.gallery.data.GuildGalleryCommentPanelParams;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J,\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J,\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u00062\u0006\u0010\u0003\u001a\u00020\bH\u0007J,\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rH\u0007J\u001a\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007J\b\u0010\u0016\u001a\u00020\u0015H\u0007J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0012J(\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012J\u0012\u0010\"\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010!\u001a\u00020 J\u0012\u0010$\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010\u0019\u001a\u00020#J\u0010\u0010%\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002J\u0016\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u001bR\u0014\u0010*\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b%\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00120+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010,R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00120+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010,\u00a8\u00061"}, d2 = {"Lmk1/e;", "", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "galleryInitBean", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "e", "Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "d", "c", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "jumpInitBean", "", "reportDtParams", "", "a", "bean", "", "sortMode", "f", "", "g", "businessType", tl.h.F, "initBean", "curPos", "Landroid/content/Context;", "context", "curVerPos", "k", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$h;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "j", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "i", "b", "", "duration", "l", "Ljava/lang/String;", "TAG", "", "Ljava/util/List;", "BUSINESS_TYPE_SCENE_TROOP", "BUSINESS_TYPE_SCENE_FEED_SQUARE", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f416895a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "Guild_Feed_GAL_GuildFeedGalleryUtils";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Integer> BUSINESS_TYPE_SCENE_TROOP;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Integer> BUSINESS_TYPE_SCENE_FEED_SQUARE;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(15);
        arrayList.add(16);
        arrayList.add(14);
        BUSINESS_TYPE_SCENE_TROOP = arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(15);
        arrayList2.add(16);
        arrayList2.add(14);
        BUSINESS_TYPE_SCENE_FEED_SQUARE = arrayList2;
    }

    e() {
    }

    @JvmStatic
    public static final void a(@NotNull GuildFeedBaseInitBean jumpInitBean, @NotNull Map<String, Object> reportDtParams) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(jumpInitBean, "jumpInitBean");
        Intrinsics.checkNotNullParameter(reportDtParams, "reportDtParams");
        HashMap<String, Serializable> attrs = jumpInitBean.getAttrs();
        Intrinsics.checkNotNullExpressionValue(attrs, "jumpInitBean.attrs");
        Object obj = reportDtParams.get(JumpGuildParam.EXTRA_KEY_TRACE_ID);
        if (obj instanceof Serializable) {
            serializable = (Serializable) obj;
        } else {
            serializable = null;
        }
        if (serializable == null) {
            serializable = "";
        }
        attrs.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, serializable);
    }

    @JvmStatic
    @NotNull
    public static final HashMap<String, Object> c(@NotNull GuildFeedGalleryInitBean galleryInitBean) {
        Object obj;
        HashMap<String, Object> hashMapOf;
        Intrinsics.checkNotNullParameter(galleryInitBean, "galleryInitBean");
        HashMap<String, Serializable> attrs = galleryInitBean.getAttrs();
        String str = null;
        if (attrs != null) {
            obj = (Serializable) attrs.get(JumpGuildParam.EXTRA_KEY_TRACE_ID);
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        }
        if (str == null) {
            str = galleryInitBean.getTraceId();
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_forum_viewer_enter_source", String.valueOf(galleryInitBean.getImmersiveSource())), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, str));
        hashMapOf.putAll(com.tencent.mobileqq.guild.report.b.d());
        return hashMapOf;
    }

    @JvmStatic
    @NotNull
    public static final HashMap<String, Object> d(@NotNull GuildGalleryCommentPanelParams galleryInitBean) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(galleryInitBean, "galleryInitBean");
        HashMap hashMap = new HashMap();
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        String traceId = galleryInitBean.getTraceId();
        Pair[] pairArr = new Pair[8];
        String guildId = galleryInitBean.getGuildId();
        String str = "";
        if (guildId == null) {
            guildId = "";
        }
        pairArr[0] = TuplesKt.to("sgrp_channel_id", guildId);
        String channelId = galleryInitBean.getChannelId();
        if (channelId == null) {
            channelId = "";
        }
        pairArr[1] = TuplesKt.to("sgrp_sub_channel_id", channelId);
        pairArr[2] = TuplesKt.to("sgrp_user_type", com.tencent.mobileqq.guild.feed.report.f.j(galleryInitBean.getGuildId()));
        pairArr[3] = TuplesKt.to("sgrp_forum_viewer_enter_source", String.valueOf(galleryInitBean.getImmersiveSource()));
        String posterId = galleryInitBean.getPosterId();
        if (posterId == null) {
            posterId = "";
        }
        pairArr[4] = TuplesKt.to("sgrp_author_uin", posterId);
        String feedId = galleryInitBean.getFeedId();
        if (feedId == null) {
            feedId = "";
        }
        pairArr[5] = TuplesKt.to("sgrp_feed_id", feedId);
        String feedId2 = galleryInitBean.getFeedId();
        if (feedId2 != null) {
            str = feedId2;
        }
        pairArr[6] = TuplesKt.to("sgrp_content_id", str);
        pairArr[7] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, traceId);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        if (!TextUtils.isEmpty(galleryInitBean.getTraceId())) {
            hashMapOf.put("sgrp_forum_trace_id", galleryInitBean.getTraceId());
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.putAll(hashMap);
        hashMap2.putAll(hashMapOf);
        return hashMap2;
    }

    @JvmStatic
    @NotNull
    public static final HashMap<String, Object> e(@NotNull GuildFeedGalleryInitBean galleryInitBean) {
        Object obj;
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(galleryInitBean, "galleryInitBean");
        HashMap<String, Object> c16 = c(galleryInitBean);
        HashMap<String, Serializable> attrs = galleryInitBean.getAttrs();
        String str = null;
        if (attrs != null) {
            obj = (Serializable) attrs.get(JumpGuildParam.EXTRA_KEY_TRACE_ID);
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        }
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str) && (str = galleryInitBean.getTraceId()) == null) {
            str = "";
        }
        Pair[] pairArr = new Pair[8];
        String guildId = galleryInitBean.getGuildId();
        if (guildId == null) {
            guildId = "";
        }
        pairArr[0] = TuplesKt.to("sgrp_channel_id", guildId);
        String channelId = galleryInitBean.getChannelId();
        if (channelId == null) {
            channelId = "";
        }
        pairArr[1] = TuplesKt.to("sgrp_sub_channel_id", channelId);
        pairArr[2] = TuplesKt.to("sgrp_user_type", com.tencent.mobileqq.guild.feed.report.f.j(galleryInitBean.getGuildId()));
        pairArr[3] = TuplesKt.to("sgrp_forum_viewer_enter_source", String.valueOf(galleryInitBean.getImmersiveSource()));
        String posterId = galleryInitBean.getPosterId();
        if (posterId == null) {
            posterId = "";
        }
        pairArr[4] = TuplesKt.to("sgrp_author_uin", posterId);
        String feedId = galleryInitBean.getFeedId();
        if (feedId == null) {
            feedId = "";
        }
        pairArr[5] = TuplesKt.to("sgrp_feed_id", feedId);
        String feedId2 = galleryInitBean.getFeedId();
        if (feedId2 == null) {
            feedId2 = "";
        }
        pairArr[6] = TuplesKt.to("sgrp_content_id", feedId2);
        pairArr[7] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, str);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        if (!TextUtils.isEmpty(galleryInitBean.getTraceId())) {
            String traceId = galleryInitBean.getTraceId();
            Intrinsics.checkNotNullExpressionValue(traceId, "galleryInitBean.traceId");
            hashMapOf.put("sgrp_forum_trace_id", traceId);
        }
        String sessionId = galleryInitBean.getSessionId();
        if (sessionId != null) {
            str2 = sessionId;
        }
        hashMapOf.put("sgrp_recommend_session", str2);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.putAll(c16);
        hashMap.putAll(hashMapOf);
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0046, code lost:
    
        if (r8 != 2) goto L17;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int f(@NotNull GuildFeedBaseInitBean bean, int sortMode) {
        String str;
        Intrinsics.checkNotNullParameter(bean, "bean");
        int businessType = bean.getBusinessType();
        int i3 = 6;
        if (businessType == 0 && sortMode != 0) {
            businessType = 6;
        }
        if (businessType != 3) {
            if (businessType != 4) {
                if (businessType != 5) {
                    if (businessType != 6) {
                        if (businessType != 7) {
                            switch (businessType) {
                                case 14:
                                    i3 = 4;
                                    break;
                                case 15:
                                    i3 = 2;
                                    break;
                                case 16:
                                    i3 = 5;
                                    break;
                                default:
                                    i3 = bean.getImmersiveSource();
                                    break;
                            }
                        } else if (sortMode != 1) {
                            if (sortMode != 2) {
                                i3 = 12;
                            } else {
                                i3 = 11;
                            }
                        } else {
                            i3 = 13;
                        }
                    } else if (sortMode != 1) {
                        if (sortMode == 2) {
                            i3 = 1;
                        }
                        i3 = 2;
                    } else {
                        i3 = 3;
                    }
                } else if (sortMode != 1) {
                }
            } else {
                i3 = 17;
            }
        } else {
            JumpGuildParam.JoinInfoParam joinInfoParam = bean.getJoinInfoParam();
            if (joinInfoParam != null) {
                str = joinInfoParam.getMainSource();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "profile_card")) {
                i3 = 18;
            } else if (Intrinsics.areEqual(str, "mine")) {
                i3 = 16;
            } else {
                i3 = bean.getImmersiveSource();
            }
        }
        Logger logger = Logger.f235387a;
        String str2 = TAG;
        logger.d().d(str2, 1, "[initImmersiveSource] businessType: " + bean.getBusinessType() + ", immersiveSource: " + i3 + ", sortMode: " + sortMode);
        return i3;
    }

    @JvmStatic
    public static final boolean g() {
        DeviceType a16 = PadUtil.a(BaseApplication.getContext());
        if (a16 != DeviceType.TABLET && a16 != DeviceType.FOLD) {
            return false;
        }
        return true;
    }

    public final void b(@Nullable GuildFeedGalleryInitBean initBean) {
        GProStFeed feed;
        if (initBean != null && (feed = initBean.getFeed()) != null) {
            Intrinsics.checkNotNullExpressionValue(feed, "feed");
            if (TextUtils.isEmpty(initBean.getGuildId()) || Intrinsics.areEqual(initBean.getGuildId(), "0")) {
                initBean.setGuildId(String.valueOf(feed.channelInfo.sign.guildId));
                Logger logger = Logger.f235387a;
                String str = TAG;
                logger.d().d(str, 1, "[checkGalleryInitBean] guildId " + initBean.getGuildId());
            }
            if (TextUtils.isEmpty(initBean.getChannelId()) || Intrinsics.areEqual(initBean.getChannelId(), "0")) {
                initBean.setChannelId(String.valueOf(feed.channelInfo.sign.channelId));
                Logger logger2 = Logger.f235387a;
                String str2 = TAG;
                logger2.d().d(str2, 1, "[checkGalleryInitBean] channelId " + initBean.getChannelId());
            }
        }
    }

    public final boolean h(int businessType) {
        if (!BUSINESS_TYPE_SCENE_FEED_SQUARE.contains(Integer.valueOf(businessType)) && businessType != 7 && businessType != 19) {
            return true;
        }
        return false;
    }

    @NotNull
    public final a.OnCommentMainFeedDataResult i(@NotNull a.OnCommentMainFeedDataResult onCommentMainFeedDataResult, @NotNull GuildFeedDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(onCommentMainFeedDataResult, "<this>");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        String guildId = initBean.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "initBean.guildId");
        String channelId = initBean.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "initBean.channelId");
        String feedId = initBean.getFeedId();
        Intrinsics.checkNotNullExpressionValue(feedId, "initBean.feedId");
        long createTime = initBean.getCreateTime();
        String posterTinyId = initBean.getPosterTinyId();
        Intrinsics.checkNotNullExpressionValue(posterTinyId, "initBean.posterTinyId");
        onCommentMainFeedDataResult.b(new a.CommentMainFeedData(guildId, channelId, feedId, createTime, posterTinyId));
        return onCommentMainFeedDataResult;
    }

    @NotNull
    public final a.OnCommentMainFeedDataResult j(@NotNull a.OnCommentMainFeedDataResult onCommentMainFeedDataResult, @NotNull GProStFeed stFeed) {
        Intrinsics.checkNotNullParameter(onCommentMainFeedDataResult, "<this>");
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        String valueOf = String.valueOf(stFeed.channelInfo.sign.guildId);
        String valueOf2 = String.valueOf(stFeed.channelInfo.sign.channelId);
        String str = stFeed.idd;
        Intrinsics.checkNotNullExpressionValue(str, "stFeed.idd");
        long j3 = stFeed.createTime;
        String str2 = stFeed.poster.idd;
        Intrinsics.checkNotNullExpressionValue(str2, "stFeed.poster.idd");
        onCommentMainFeedDataResult.b(new a.CommentMainFeedData(valueOf, valueOf2, str, j3, str2));
        return onCommentMainFeedDataResult;
    }

    public final void k(@Nullable GuildFeedGalleryInitBean initBean, int curPos, @NotNull Context context, int curVerPos) {
        Integer num;
        Intrinsics.checkNotNullParameter(context, "context");
        if (initBean != null && curPos < initBean.getRichMediaDataList().size()) {
            if (curPos >= 0 && curPos < initBean.getRichMediaDataList().size()) {
                GuildFeedRichMediaData guildFeedRichMediaData = initBean.getRichMediaDataList().get(curPos);
                Intrinsics.checkNotNullExpressionValue(guildFeedRichMediaData, "initBean.richMediaDataList[curPos]");
                GuildFeedGalleryShareViewEvent guildFeedGalleryShareViewEvent = new GuildFeedGalleryShareViewEvent();
                guildFeedGalleryShareViewEvent.setSource(GuildSharePageSource.FEED_LIST);
                com.tencent.mobileqq.guild.feed.share.c cVar = new com.tencent.mobileqq.guild.feed.share.c();
                cVar.p(curVerPos);
                cVar.k(context.hashCode());
                cVar.o(guildFeedRichMediaData);
                cVar.l(initBean.getFeed());
                cVar.n(initBean.getGuildId());
                cVar.j(initBean.getChannelId());
                cVar.q(initBean.getPosterId());
                cVar.m(initBean.getFromPage());
                cVar.i(initBean.getBusinessType());
                guildFeedGalleryShareViewEvent.setGalleryShareInfo(cVar);
                guildFeedGalleryShareViewEvent.setGalleryInitBean(initBean);
                SimpleEventBus.getInstance().dispatchEvent(guildFeedGalleryShareViewEvent);
                return;
            }
            String str = TAG;
            List<GuildFeedRichMediaData> richMediaDataList = initBean.getRichMediaDataList();
            if (richMediaDataList != null) {
                num = Integer.valueOf(richMediaDataList.size());
            } else {
                num = null;
            }
            QLog.w(str, 1, "[showShareView] invalid pos. curPos: " + curPos + ", total: " + num);
        }
    }

    public final void l(long duration, @NotNull Context context) {
        VibrationEffect createOneShot;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        Vibrator vibrator = (Vibrator) systemService;
        if (vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= 26) {
                createOneShot = VibrationEffect.createOneShot(duration, -1);
                vibrator.vibrate(createOneShot);
            } else {
                vibrator.vibrate(duration);
            }
        }
    }
}
