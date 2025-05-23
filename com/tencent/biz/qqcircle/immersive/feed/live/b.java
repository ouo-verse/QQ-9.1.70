package com.tencent.biz.qqcircle.immersive.feed.live;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$RoomInfoData;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLive;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import weprotocols.WEProtocolsVaslive$InteractivePlayInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 72\u00020\u0001:\u0001\u0005B!\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0007R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\"R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u0014\u0010&\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001eR$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00101\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/b;", "", "", "f", "", "a", "d", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "", "position", "e", "g", tl.h.F, "b", "", "c", "Landroid/view/View;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;", "Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;", "expEntityInfo", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "luckyBagLayout", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "liveTagImage", "luckyBagImage", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "luckyBagName", "luckyBagAwardName", "i", "luckyBagDivider", "Lweprotocols/WEProtocolsVaslive$InteractivePlayInfo;", "j", "Lweprotocols/WEProtocolsVaslive$InteractivePlayInfo;", "getInteractivePlayInfo", "()Lweprotocols/WEProtocolsVaslive$InteractivePlayInfo;", "setInteractivePlayInfo", "(Lweprotocols/WEProtocolsVaslive$InteractivePlayInfo;)V", "interactivePlayInfo", "k", "Z", "isGoodsImage", "()Z", "setGoodsImage", "(Z)V", "<init>", "(Landroid/view/View;Lcom/tencent/qqlive/common/api/IAegisLogApi;Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;)V", "l", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ExpEntityInfo expEntityInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout luckyBagLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView liveTagImage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView luckyBagImage;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView luckyBagName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView luckyBagAwardName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView luckyBagDivider;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WEProtocolsVaslive$InteractivePlayInfo interactivePlayInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isGoodsImage;

    public b(@NotNull View rootView, @NotNull IAegisLogApi aegisLog, @Nullable ExpEntityInfo expEntityInfo) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(aegisLog, "aegisLog");
        this.rootView = rootView;
        this.aegisLog = aegisLog;
        this.expEntityInfo = expEntityInfo;
        View findViewById = rootView.findViewById(R.id.v_u);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_show_feed_live_fudai_ll)");
        this.luckyBagLayout = (LinearLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.ymk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.living_anim_image)");
        this.liveTagImage = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.v_v);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026eed_live_lucky_bag_image)");
        this.luckyBagImage = (ImageView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.v_w);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026eed_live_lucky_bag_title)");
        this.luckyBagName = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.v_r);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026show_feed_live_awardName)");
        this.luckyBagAwardName = (TextView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.v_t);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026h_show_feed_live_divider)");
        this.luckyBagDivider = (ImageView) findViewById6;
    }

    private final String a() {
        String str;
        PBStringField pBStringField;
        WEProtocolsVaslive$InteractivePlayInfo wEProtocolsVaslive$InteractivePlayInfo = this.interactivePlayInfo;
        if (wEProtocolsVaslive$InteractivePlayInfo != null && (pBStringField = wEProtocolsVaslive$InteractivePlayInfo.liveIcon) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f() {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z16;
        PBStringField pBStringField;
        boolean z17;
        LinearLayout linearLayout;
        boolean z18;
        boolean z19;
        String str5;
        String str6;
        String str7;
        boolean isBlank;
        String str8;
        boolean z26;
        String str9;
        boolean z27;
        String str10;
        boolean z28;
        String str11;
        String str12;
        boolean isBlank2;
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8955/qqlive_fudai/qvideo_feed_tag_qqlive_divider.png").setTargetView(this.luckyBagDivider));
        WEProtocolsVaslive$InteractivePlayInfo wEProtocolsVaslive$InteractivePlayInfo = this.interactivePlayInfo;
        if (wEProtocolsVaslive$InteractivePlayInfo != null) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            PBStringField pBStringField2 = wEProtocolsVaslive$InteractivePlayInfo.liveIcon;
            String str13 = null;
            if (pBStringField2 != null) {
                str = pBStringField2.get();
            } else {
                str = null;
            }
            PBStringField pBStringField3 = wEProtocolsVaslive$InteractivePlayInfo.playIcon;
            if (pBStringField3 != null) {
                str2 = pBStringField3.get();
            } else {
                str2 = null;
            }
            PBStringField pBStringField4 = wEProtocolsVaslive$InteractivePlayInfo.title;
            if (pBStringField4 != null) {
                str3 = pBStringField4.get();
            } else {
                str3 = null;
            }
            PBStringField pBStringField5 = wEProtocolsVaslive$InteractivePlayInfo.awardName;
            if (pBStringField5 != null) {
                str4 = pBStringField5.get();
            } else {
                str4 = null;
            }
            companion.i("Audience|FeedLiveTagAnimController", "showLiveTag", "liveIcon:" + str + " playIcon:" + str2 + " title:" + str3 + " awardName:" + str4);
            PBStringField pBStringField6 = wEProtocolsVaslive$InteractivePlayInfo.liveIcon;
            boolean z29 = false;
            if (pBStringField6 != null && (str12 = pBStringField6.get()) != null) {
                Intrinsics.checkNotNullExpressionValue(str12, "get()");
                isBlank2 = StringsKt__StringsJVMKt.isBlank(str12);
                if (!isBlank2) {
                    z16 = true;
                    if (z16) {
                        ViewGroup.LayoutParams layoutParams = this.liveTagImage.getLayoutParams();
                        layoutParams.width = DisplayUtil.dip2px(this.liveTagImage.getContext(), wEProtocolsVaslive$InteractivePlayInfo.liveIconWidth.get());
                        layoutParams.height = DisplayUtil.dip2px(this.liveTagImage.getContext(), 24.0f);
                        QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
                        Option obtain = Option.obtain();
                        PBStringField pBStringField7 = wEProtocolsVaslive$InteractivePlayInfo.liveIcon;
                        if (pBStringField7 != null) {
                            str11 = pBStringField7.get();
                        } else {
                            str11 = null;
                        }
                        obtain.setUrl(str11);
                        obtain.setTargetView(this.liveTagImage);
                        g16.loadImage(obtain);
                    }
                    pBStringField = wEProtocolsVaslive$InteractivePlayInfo.playIcon;
                    if (pBStringField != null && (str10 = pBStringField.get()) != null) {
                        if (str10.length() != 0) {
                            z28 = true;
                        } else {
                            z28 = false;
                        }
                        if (z28) {
                            z17 = true;
                            if (!z17) {
                                PBStringField pBStringField8 = wEProtocolsVaslive$InteractivePlayInfo.title;
                                if (pBStringField8 != null && (str9 = pBStringField8.get()) != null) {
                                    if (str9.length() == 0) {
                                        z27 = true;
                                    } else {
                                        z27 = false;
                                    }
                                    if (z27) {
                                        z18 = true;
                                        if (!z18) {
                                            PBStringField pBStringField9 = wEProtocolsVaslive$InteractivePlayInfo.awardName;
                                            if (pBStringField9 != null && (str8 = pBStringField9.get()) != null) {
                                                if (str8.length() == 0) {
                                                    z26 = true;
                                                } else {
                                                    z26 = false;
                                                }
                                                if (z26) {
                                                    z19 = true;
                                                    if (!z19) {
                                                        LinearLayout linearLayout2 = this.luckyBagLayout;
                                                        if (linearLayout2 != null) {
                                                            linearLayout2.setVisibility(0);
                                                        }
                                                        PBStringField pBStringField10 = wEProtocolsVaslive$InteractivePlayInfo.playIcon;
                                                        if (pBStringField10 != null && (str7 = pBStringField10.get()) != null) {
                                                            Intrinsics.checkNotNullExpressionValue(str7, "get()");
                                                            isBlank = StringsKt__StringsJVMKt.isBlank(str7);
                                                            if (!isBlank) {
                                                                z29 = true;
                                                            }
                                                        }
                                                        if (z29) {
                                                            QCircleFeedPicLoader g17 = QCircleFeedPicLoader.g();
                                                            Option obtain2 = Option.obtain();
                                                            PBStringField pBStringField11 = wEProtocolsVaslive$InteractivePlayInfo.playIcon;
                                                            if (pBStringField11 != null) {
                                                                str6 = pBStringField11.get();
                                                            } else {
                                                                str6 = null;
                                                            }
                                                            g17.loadImage(obtain2.setUrl(str6).setTargetView(this.luckyBagImage));
                                                        }
                                                        TextView textView = this.luckyBagName;
                                                        if (textView != null) {
                                                            PBStringField pBStringField12 = wEProtocolsVaslive$InteractivePlayInfo.title;
                                                            if (pBStringField12 != null) {
                                                                str5 = pBStringField12.get();
                                                            } else {
                                                                str5 = null;
                                                            }
                                                            textView.setText(str5);
                                                        }
                                                        TextView textView2 = this.luckyBagAwardName;
                                                        if (textView2 != null) {
                                                            PBStringField pBStringField13 = wEProtocolsVaslive$InteractivePlayInfo.awardName;
                                                            if (pBStringField13 != null) {
                                                                str13 = pBStringField13.get();
                                                            }
                                                            textView2.setText(str13);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                }
                                            }
                                            z19 = false;
                                            if (!z19) {
                                            }
                                        }
                                    }
                                }
                                z18 = false;
                                if (!z18) {
                                }
                            }
                            companion.w("Audience|FeedLiveTagAnimController", "resetStatus", "luckyBag not show");
                            linearLayout = this.luckyBagLayout;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                                return;
                            }
                            return;
                        }
                    }
                    z17 = false;
                    if (!z17) {
                    }
                    companion.w("Audience|FeedLiveTagAnimController", "resetStatus", "luckyBag not show");
                    linearLayout = this.luckyBagLayout;
                    if (linearLayout != null) {
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
            pBStringField = wEProtocolsVaslive$InteractivePlayInfo.playIcon;
            if (pBStringField != null) {
                if (str10.length() != 0) {
                }
                if (z28) {
                }
            }
            z17 = false;
            if (!z17) {
            }
            companion.w("Audience|FeedLiveTagAnimController", "resetStatus", "luckyBag not show");
            linearLayout = this.luckyBagLayout;
            if (linearLayout != null) {
            }
        } else {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8955/qqlive_fudai/qvideo_feed_tag_qqlive.png").setTargetView(this.liveTagImage));
            LinearLayout linearLayout3 = this.luckyBagLayout;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
        }
    }

    @VisibleForTesting
    public final void b() {
        if (this.isGoodsImage) {
            return;
        }
        f();
    }

    @VisibleForTesting
    public final boolean c() {
        return !TextUtils.isEmpty(a());
    }

    public final void d() {
        this.aegisLog.i("Audience|FeedLiveTagAnimController", "onSelected, needLoadNetworkImage " + c());
        if (c()) {
            b();
        }
    }

    public final void e(@NotNull FeedCloudMeta$StFeed data, int position) {
        Long l3;
        Object obj;
        FeedCloudMeta$RoomInfoData feedCloudMeta$RoomInfoData;
        PBUInt64Field pBUInt64Field;
        Intrinsics.checkNotNullParameter(data, "data");
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        FeedCloudMeta$StLive feedCloudMeta$StLive = data.live;
        WEProtocolsVaslive$InteractivePlayInfo wEProtocolsVaslive$InteractivePlayInfo = null;
        if (feedCloudMeta$StLive != null && (feedCloudMeta$RoomInfoData = feedCloudMeta$StLive.room) != null && (pBUInt64Field = feedCloudMeta$RoomInfoData.roomId) != null) {
            l3 = Long.valueOf(pBUInt64Field.get());
        } else {
            l3 = null;
        }
        companion.i("Audience|FeedLiveTagAnimController", "resetStatus", "roomId:" + l3 + " needLoadNetworkImage " + c());
        this.liveTagImage.setImageDrawable(null);
        this.isGoodsImage = false;
        if (data.live.liveExtInfo.get() != null) {
            List<FeedCloudCommon$Entry> list = data.live.liveExtInfo.get();
            Intrinsics.checkNotNullExpressionValue(list, "data.live.liveExtInfo.get()");
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                if ("qqlive_ecom_has_goods_ext".equals(feedCloudCommon$Entry.key.get()) && "true".equals(feedCloudCommon$Entry.value.get())) {
                    this.isGoodsImage = true;
                    this.aegisLog.i("Audience|FeedLiveTagAnimController", "data type: " + data.type.get() + "id:" + data.f398449id.get() + ",pos:" + position);
                }
            }
        }
        if (this.isGoodsImage) {
            ViewGroup.LayoutParams layoutParams = this.liveTagImage.getLayoutParams();
            layoutParams.width = DisplayUtil.dip2px(this.liveTagImage.getContext(), 68.0f);
            layoutParams.height = DisplayUtil.dip2px(this.liveTagImage.getContext(), 26.0f);
            this.liveTagImage.setBackgroundResource(R.drawable.naj);
            return;
        }
        List<FeedCloudCommon$BytesEntry> list2 = data.live.liveBytesExtInfo.get();
        Intrinsics.checkNotNullExpressionValue(list2, "data.live.liveBytesExtInfo.get()");
        Iterator<T> it = list2.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((FeedCloudCommon$BytesEntry) obj).key.get(), "interactive_play_info")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = (FeedCloudCommon$BytesEntry) obj;
        if (feedCloudCommon$BytesEntry != null) {
            WEProtocolsVaslive$InteractivePlayInfo wEProtocolsVaslive$InteractivePlayInfo2 = new WEProtocolsVaslive$InteractivePlayInfo();
            try {
                WEProtocolsVaslive$InteractivePlayInfo mergeFrom = wEProtocolsVaslive$InteractivePlayInfo2.mergeFrom(feedCloudCommon$BytesEntry.value.get().toByteArray());
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "interactivePlayInfo.merg\u2026alue.get().toByteArray())");
                wEProtocolsVaslive$InteractivePlayInfo = mergeFrom;
            } catch (Exception e16) {
                this.aegisLog.e("Audience|FeedLiveTagAnimController", "resetStatus...", e16);
                wEProtocolsVaslive$InteractivePlayInfo = wEProtocolsVaslive$InteractivePlayInfo2;
            }
        }
        this.interactivePlayInfo = wEProtocolsVaslive$InteractivePlayInfo;
        f();
    }

    public final void g() {
    }

    public final void h() {
    }
}
