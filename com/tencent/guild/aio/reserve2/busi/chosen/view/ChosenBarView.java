package com.tencent.guild.aio.reserve2.busi.chosen.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.reserve2.busi.chosen.view.DotAnimIndexView;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.guild.aio.util.flowbus.a;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.IGuildTextViewFactoryApi;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import nq0.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.slf4j.Marker;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 d2\u00020\u0001:\u0001eB\u0011\b\u0016\u0012\u0006\u0010^\u001a\u00020]\u00a2\u0006\u0004\b_\u0010`B\u001b\b\u0016\u0012\u0006\u0010^\u001a\u00020]\u0012\b\u0010b\u001a\u0004\u0018\u00010a\u00a2\u0006\u0004\b_\u0010cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J \u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\tH\u0002J$\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020 0\u001fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020 `!H\u0002J\b\u0010#\u001a\u00020\u000bH\u0014J\u001c\u0010$\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tJ\u001c\u0010%\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010&\u001a\u00020\u000bJ\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\tJ\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010\tR\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0018\u00106\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00101R\u0018\u00108\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00101R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00101R\"\u0010I\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010P\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR'\u0010\\\u001a\u0012\u0012\u0004\u0012\u00020\u00070Wj\b\u0012\u0004\u0012\u00020\u0007`X8\u0006\u00a2\u0006\f\n\u0004\bR\u0010Y\u001a\u0004\bZ\u0010[\u00a8\u0006f"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/view/ChosenBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/widget/TextView;", "C0", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;", "msgSeqList", "", "channelId", "", "P0", "newChosenMsgLi", "", "D0", "M0", "", "msgId", "A0", "F0", "Lcom/tencent/guild/aio/reserve2/busi/chosen/a;", "chosenMsg", "J0", "I0", "guildId", "tinyId", "sendNickName", "E0", "eventId", "L0", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "H0", "onFinishInflate", "K0", "O0", "N0", "B0", "Q0", "updateSeq", "filePath", "R0", "Lcom/tencent/guild/aio/reserve2/busi/chosen/view/DotAnimIndexView;", "d", "Lcom/tencent/guild/aio/reserve2/busi/chosen/view/DotAnimIndexView;", "dotView", "e", "Landroid/widget/TextView;", "chosenTitleTv", "f", "chosenNumTv", h.F, "chosenIndexTv", "i", "chosenMsgContentTv", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "chosenMsgThumbIv", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "videoPlayIcon", "D", "picNum", "E", "Ljava/lang/String;", "getMChannelId", "()Ljava/lang/String;", "setMChannelId", "(Ljava/lang/String;)V", "mChannelId", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;", "G0", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;", "setCurTopMsg", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;)V", "curTopMsg", "G", "I", "curSelectedIndex", "H", "Lcom/tencent/guild/aio/reserve2/busi/chosen/a;", "curSelectedMsg", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getChosenMsgSeqLi", "()Ljava/util/ArrayList;", "chosenMsgSeqLi", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "J", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class ChosenBarView extends ConstraintLayout {
    private static float K = 13.0f;
    private static int L = com.tencent.guild.aio.util.c.b(4);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View videoPlayIcon;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView picNum;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String mChannelId;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IGProTopMsg curTopMsg;

    /* renamed from: G, reason: from kotlin metadata */
    private int curSelectedIndex;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.guild.aio.reserve2.busi.chosen.a curSelectedMsg;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<IGProTopMsg> chosenMsgSeqLi;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DotAnimIndexView dotView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView chosenTitleTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView chosenNumTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView chosenIndexTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView chosenMsgContentTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundRectImageView chosenMsgThumbIv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChosenBarView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mChannelId = "";
        this.curSelectedIndex = -1;
        this.chosenMsgSeqLi = new ArrayList<>();
    }

    private final void A0(long msgId) {
        QLog.i("ChosenBarView", 4, "autoSlideToSpecialMsg msgID=" + msgId);
        com.tencent.guild.aio.util.flowbus.a.INSTANCE.b(new d(msgId, true));
    }

    private final TextView C0(ViewGroup container) {
        IGuildTextViewFactoryApi iGuildTextViewFactoryApi = (IGuildTextViewFactoryApi) QRoute.api(IGuildTextViewFactoryApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TextView createGuildEmoETTextView = iGuildTextViewFactoryApi.createGuildEmoETTextView(context);
        createGuildEmoETTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        createGuildEmoETTextView.setEllipsize(TextUtils.TruncateAt.END);
        createGuildEmoETTextView.setMaxLines(1);
        createGuildEmoETTextView.setSingleLine(true);
        createGuildEmoETTextView.setId(R.id.vx7);
        createGuildEmoETTextView.setTextSize(2, K);
        GuildUIUtils.f235378a.b(createGuildEmoETTextView, R.color.qui_common_text_primary);
        container.addView(createGuildEmoETTextView);
        return createGuildEmoETTextView;
    }

    private final int D0(List<? extends IGProTopMsg> newChosenMsgLi) {
        int size;
        boolean z16;
        int i3 = this.curSelectedIndex;
        if (i3 >= 0 && i3 + 1 != this.chosenMsgSeqLi.size()) {
            int i16 = 0;
            for (IGProTopMsg iGProTopMsg : newChosenMsgLi) {
                int i17 = i16 + 1;
                IGProTopMsg iGProTopMsg2 = this.curTopMsg;
                if (iGProTopMsg2 != null && iGProTopMsg2.getTopMsgSeq() == iGProTopMsg.getTopMsgSeq()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return i16;
                }
                i16 = i17;
            }
            size = this.curSelectedIndex;
        } else {
            size = newChosenMsgLi.size();
        }
        return size - 1;
    }

    private final String E0(String guildId, String tinyId, String sendNickName) {
        boolean z16;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProTopMsg iGProTopMsg = this.curTopMsg;
        boolean z17 = true;
        if (iGProTopMsg != null && iGProTopMsg.getTopMsgType() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getGuildUserDisplayName(guildId, tinyId, sendNickName);
        }
        if (str != null && str.length() != 0) {
            z17 = false;
        }
        if (z17) {
            return "";
        }
        return str + MsgSummary.STR_COLON;
    }

    private final void F0() {
        int coerceAtMost;
        int coerceAtLeast;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.curSelectedIndex, this.chosenMsgSeqLi.size() - 1);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(coerceAtMost, 0);
        this.curSelectedIndex = coerceAtLeast;
        IGProTopMsg iGProTopMsg = this.chosenMsgSeqLi.get(coerceAtLeast);
        this.curTopMsg = iGProTopMsg;
        if (iGProTopMsg != null) {
            int i3 = this.curSelectedIndex;
            Intrinsics.checkNotNull(iGProTopMsg);
            QLog.i("ChosenBarView", 1, "bindData== pos=" + i3 + " curSelectedMsgSeq=" + iGProTopMsg.getTopMsgSeq());
            a.Companion companion = com.tencent.guild.aio.util.flowbus.a.INSTANCE;
            IGProTopMsg iGProTopMsg2 = this.curTopMsg;
            Intrinsics.checkNotNull(iGProTopMsg2);
            long topMsgSeq = iGProTopMsg2.getTopMsgSeq();
            IGProTopMsg iGProTopMsg3 = this.curTopMsg;
            Intrinsics.checkNotNull(iGProTopMsg3);
            companion.b(new nq0.b(topMsgSeq, iGProTopMsg3.getTopMsgType(), this.mChannelId));
        }
    }

    private final HashMap<String, Object> H0() {
        JSONObject a16;
        HashMap<String, Object> hashMap = new HashMap<>();
        com.tencent.guild.aio.reserve2.busi.chosen.a aVar = this.curSelectedMsg;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            ArrayList<MsgElement> arrayList = aVar.getMsg().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "curSelectedMsg!!.msg.elements");
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                MarkdownElement markdownElement = ((MsgElement) it.next()).markdownElement;
                if (markdownElement != null) {
                    Intrinsics.checkNotNullExpressionValue(markdownElement, "markdownElement");
                    com.tencent.android.androidbypass.parser.b a17 = com.tencent.android.androidbypass.parser.c.a(markdownElement.content);
                    if (a17 != null && (a16 = a17.a()) != null) {
                        hashMap.put("sgrp_template_id", String.valueOf(a16.optInt("id")));
                    }
                }
            }
        }
        hashMap.put("sgrp_top_sticky_num", Integer.valueOf(this.chosenMsgSeqLi.size()));
        hashMap.put("dt_pgid", "pg_sgrp_aio");
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReport.setElementId(this, "em_aio_top_sticky_post");
        VideoReport.setPageParams(this, new PageParams(hashMap));
        return hashMap;
    }

    private final void I0(com.tencent.guild.aio.reserve2.busi.chosen.a chosenMsg) {
        PicElement picElement;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        a aVar = a.f112232a;
        MsgElement e16 = aVar.e(chosenMsg.getMsg(), 2);
        if (e16 != null && (picElement = e16.picElement) != null) {
            String f16 = aVar.f(e16);
            if (!new File(f16).exists() && ((num = picElement.transferStatus) == null || num.intValue() != 2 || (num2 = picElement.transferStatus) == null || num2.intValue() != 3 || (num3 = picElement.transferStatus) == null || num3.intValue() != 4 || (num4 = picElement.transferStatus) == null || num4.intValue() != 5)) {
                com.tencent.guild.aio.util.flowbus.a.INSTANCE.b(new nq0.a(chosenMsg.getMsg(), 1));
            }
            QLog.i("ChosenBarView", 1, "handlePicIv path=" + f16);
            String f17 = aVar.f(e16);
            RoundRectImageView roundRectImageView = this.chosenMsgThumbIv;
            Intrinsics.checkNotNull(roundRectImageView);
            aVar.a(f17, roundRectImageView);
        }
    }

    private final void J0(com.tencent.guild.aio.reserve2.busi.chosen.a chosenMsg) {
        VideoElement videoElement;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        a aVar = a.f112232a;
        MsgElement e16 = aVar.e(chosenMsg.getMsg(), 5);
        if (e16 != null && (videoElement = e16.videoElement) != null) {
            String f16 = aVar.f(e16);
            if (!new File(f16).exists() && ((num = videoElement.transferStatus) == null || num.intValue() != 2 || (num2 = videoElement.transferStatus) == null || num2.intValue() != 3 || (num3 = videoElement.transferStatus) == null || num3.intValue() != 4 || (num4 = videoElement.transferStatus) == null || num4.intValue() != 5)) {
                com.tencent.guild.aio.util.flowbus.a.INSTANCE.b(new nq0.a(chosenMsg.getMsg(), 2));
            }
            QLog.i("ChosenBarView", 1, "handleVideoThumbNailIv path=" + f16);
            String f17 = aVar.f(e16);
            RoundRectImageView roundRectImageView = this.chosenMsgThumbIv;
            Intrinsics.checkNotNull(roundRectImageView);
            aVar.a(f17, roundRectImageView);
        }
    }

    private final void L0(String eventId) {
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent(eventId, this, H0());
    }

    private final void M0() {
        int i3 = this.curSelectedIndex - 1;
        this.curSelectedIndex = i3;
        if (i3 < 0) {
            this.curSelectedIndex = this.chosenMsgSeqLi.size() - 1;
        }
        F0();
    }

    private final void P0(final List<? extends IGProTopMsg> msgSeqList, String channelId) {
        this.mChannelId = channelId;
        this.chosenMsgSeqLi.clear();
        this.chosenMsgSeqLi.addAll(msgSeqList);
        QLog.i("ChosenBarView", 1, "update size:" + msgSeqList.size() + " curSelectedIndex=" + this.curSelectedIndex + " channelId=" + channelId);
        DotAnimIndexView dotAnimIndexView = this.dotView;
        if (dotAnimIndexView != null) {
            dotAnimIndexView.g(new Function1<DotAnimIndexView.Config, Unit>() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.view.ChosenBarView$updateData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DotAnimIndexView.Config config) {
                    invoke2(config);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull DotAnimIndexView.Config config) {
                    int i3;
                    Intrinsics.checkNotNullParameter(config, "$this$config");
                    config.j(msgSeqList.size());
                    i3 = this.curSelectedIndex;
                    config.i(i3);
                }
            });
        }
        if (this.chosenMsgSeqLi.isEmpty()) {
            ViewExtKt.a(this);
        } else {
            F0();
        }
    }

    public final void B0(@NotNull com.tencent.guild.aio.reserve2.busi.chosen.a chosenMsg) {
        Intrinsics.checkNotNullParameter(chosenMsg, "chosenMsg");
        setVisibility(0);
        if (this.curSelectedMsg != null) {
            L0("imp_end");
        }
        this.curSelectedMsg = chosenMsg;
        TextView textView = this.chosenTitleTv;
        if (textView != null) {
            textView.setText(chosenMsg.getTitle());
        }
        String str = "/" + this.chosenMsgSeqLi.size();
        TextView textView2 = this.chosenNumTv;
        if (textView2 != null) {
            textView2.setText(str);
        }
        String valueOf = String.valueOf(this.curSelectedIndex + 1);
        TextView textView3 = this.chosenIndexTv;
        if (textView3 != null) {
            textView3.setText(valueOf);
        }
        String str2 = chosenMsg.getMsg().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "chosenMsg.msg.guildId");
        String str3 = chosenMsg.getMsg().senderUid;
        Intrinsics.checkNotNullExpressionValue(str3, "chosenMsg.msg.senderUid");
        String str4 = chosenMsg.getMsg().sendNickName;
        Intrinsics.checkNotNullExpressionValue(str4, "chosenMsg.msg.sendNickName");
        String str5 = E0(str2, str3, str4) + ((Object) chosenMsg.getContent());
        TextView textView4 = this.chosenMsgContentTv;
        if (textView4 != null) {
            textView4.setText(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseQQText(str5));
        }
        RoundRectImageView roundRectImageView = this.chosenMsgThumbIv;
        if (roundRectImageView != null) {
            roundRectImageView.setVisibility(8);
        }
        View view = this.videoPlayIcon;
        if (view != null) {
            view.setVisibility(8);
        }
        TextView textView5 = this.picNum;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        if (!TextUtils.isEmpty(chosenMsg.getVideoThumbUrl())) {
            if (this.chosenMsgThumbIv != null) {
                J0(chosenMsg);
            }
            RoundRectImageView roundRectImageView2 = this.chosenMsgThumbIv;
            if (roundRectImageView2 != null) {
                roundRectImageView2.setVisibility(0);
            }
            View view2 = this.videoPlayIcon;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
        if (!TextUtils.isEmpty(chosenMsg.getPicThumbUrl())) {
            RoundRectImageView roundRectImageView3 = this.chosenMsgThumbIv;
            if (roundRectImageView3 != null) {
                roundRectImageView3.setVisibility(0);
            }
            View view3 = this.videoPlayIcon;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            if (this.chosenMsgThumbIv != null) {
                I0(chosenMsg);
            }
            if (chosenMsg.getPicNum() > 1) {
                TextView textView6 = this.picNum;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                TextView textView7 = this.picNum;
                if (textView7 != null) {
                    textView7.setText(Marker.ANY_NON_NULL_MARKER + chosenMsg.getPicNum());
                }
            }
        }
        if (!TextUtils.isEmpty(chosenMsg.getMissionPicUrl())) {
            RoundRectImageView roundRectImageView4 = this.chosenMsgThumbIv;
            if (roundRectImageView4 != null) {
                roundRectImageView4.setVisibility(0);
            }
            View view4 = this.videoPlayIcon;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            e.a().e(new Option().setUrl(chosenMsg.getMissionPicUrl()).setTargetView(this.chosenMsgThumbIv).setNeedFilterUrl(false));
        }
        L0("imp");
    }

    @Nullable
    /* renamed from: G0, reason: from getter */
    public final IGProTopMsg getCurTopMsg() {
        return this.curTopMsg;
    }

    public final void K0(@NotNull List<? extends IGProTopMsg> msgSeqList, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(msgSeqList, "msgSeqList");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        setVisibility(8);
        this.curSelectedIndex = msgSeqList.size() - 1;
        P0(msgSeqList, channelId);
    }

    public final void N0() {
        L0("clck");
        int i3 = this.curSelectedIndex;
        if (i3 >= 0 && i3 <= this.chosenMsgSeqLi.size() - 1) {
            IGProTopMsg iGProTopMsg = this.chosenMsgSeqLi.get(this.curSelectedIndex);
            Intrinsics.checkNotNullExpressionValue(iGProTopMsg, "chosenMsgSeqLi[curSelectedIndex]");
            IGProTopMsg iGProTopMsg2 = iGProTopMsg;
            A0(iGProTopMsg2.getTopMsgSeq());
            QLog.i("ChosenBarView", 1, "slidePre== pos=" + this.curSelectedIndex + "  chosenMsgSeq=" + iGProTopMsg2.getTopMsgSeq());
            DotAnimIndexView dotAnimIndexView = this.dotView;
            if (dotAnimIndexView != null) {
                dotAnimIndexView.l();
            }
            M0();
        }
    }

    public final void O0(@NotNull List<? extends IGProTopMsg> msgSeqList, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(msgSeqList, "msgSeqList");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.curSelectedIndex = D0(msgSeqList);
        P0(msgSeqList, channelId);
    }

    public final void Q0(@NotNull String tinyId) {
        com.tencent.guild.aio.reserve2.busi.chosen.a aVar;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        if (this.curSelectedIndex != -1 && !this.chosenMsgSeqLi.isEmpty() && (aVar = this.curSelectedMsg) != null) {
            Intrinsics.checkNotNull(aVar);
            if (Intrinsics.areEqual(tinyId, aVar.getMsg().senderUid)) {
                String str = aVar.getMsg().guildId;
                Intrinsics.checkNotNullExpressionValue(str, "chosenMsg.msg.guildId");
                String str2 = aVar.getMsg().senderUid;
                Intrinsics.checkNotNullExpressionValue(str2, "chosenMsg.msg.senderUid");
                String str3 = aVar.getMsg().sendNickName;
                Intrinsics.checkNotNullExpressionValue(str3, "chosenMsg.msg.sendNickName");
                String str4 = E0(str, str2, str3) + ((Object) aVar.getContent());
                TextView textView = this.chosenMsgContentTv;
                if (textView != null) {
                    textView.setText(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseQQText(str4));
                }
            }
        }
    }

    public final void R0(long updateSeq, @Nullable String filePath) {
        com.tencent.guild.aio.reserve2.busi.chosen.a aVar;
        MsgElement msgElement;
        IGProTopMsg iGProTopMsg = this.curTopMsg;
        boolean z16 = false;
        if (iGProTopMsg != null && iGProTopMsg.getTopMsgSeq() == updateSeq) {
            z16 = true;
        }
        if (z16 && (aVar = this.curSelectedMsg) != null) {
            Intrinsics.checkNotNull(aVar);
            if (!TextUtils.isEmpty(aVar.getVideoThumbUrl())) {
                msgElement = a.f112232a.e(aVar.getMsg(), 5);
            } else if (!TextUtils.isEmpty(aVar.getPicThumbUrl())) {
                msgElement = a.f112232a.e(aVar.getMsg(), 2);
            } else {
                msgElement = null;
            }
            if (msgElement != null) {
                if (filePath == null) {
                    filePath = a.f112232a.f(msgElement);
                }
                QLog.i("ChosenBarView", 1, "updatePicIvUI path=" + filePath);
                a aVar2 = a.f112232a;
                RoundRectImageView roundRectImageView = this.chosenMsgThumbIv;
                Intrinsics.checkNotNull(roundRectImageView);
                aVar2.a(filePath, roundRectImageView);
            }
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.dotView = (DotAnimIndexView) findViewById(R.id.ukn);
        this.chosenTitleTv = (TextView) findViewById(R.id.twn);
        this.chosenNumTv = (TextView) findViewById(R.id.twq);
        this.chosenIndexTv = (TextView) findViewById(R.id.twp);
        View findViewById = findViewById(R.id.zfw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.msg_content_container)");
        this.chosenMsgContentTv = C0((ViewGroup) findViewById);
        this.chosenMsgThumbIv = (RoundRectImageView) findViewById(R.id.twr);
        this.videoPlayIcon = findViewById(R.id.kro);
        this.picNum = (TextView) findViewById(R.id.f24810_5);
        RoundRectImageView roundRectImageView = this.chosenMsgThumbIv;
        if (roundRectImageView != null) {
            roundRectImageView.setCornerRadiusAndMode(L, 1);
        }
    }

    public final void setCurTopMsg(@Nullable IGProTopMsg iGProTopMsg) {
        this.curTopMsg = iGProTopMsg;
    }

    public final void setMChannelId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mChannelId = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChosenBarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mChannelId = "";
        this.curSelectedIndex = -1;
        this.chosenMsgSeqLi = new ArrayList<>();
    }
}
