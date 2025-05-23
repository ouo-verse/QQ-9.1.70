package com.tencent.mobileqq.guild.contentshare.template.content;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bq0.GuildHighlightParams;
import com.tencent.guild.aio.msglist.text.util.TextBubbleContentParser;
import com.tencent.guild.aio.util.ui.GuildChatPicDownloader;
import com.tencent.guild.aio.util.ui.PicSize;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.msg.IGuildMsgElementApi;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.image.URLDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.contentshare.h;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.text.ISpanRefreshCallback;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import jr0.GuildImageOptions;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 H2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u00101\u001a\u00020/\u00a2\u0006\u0004\bF\u0010GJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J6\u0010\u000b\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\bj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n`\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J8\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J(\u0010\u001d\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0002JD\u0010%\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\u001a\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010'\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010(\u001a\u00020\u0006H\u0002J\"\u0010.\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\f2\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u00100R$\u00108\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010-\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/template/content/MsgContentComponent;", "Lcom/tencent/mobileqq/guild/contentshare/g;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "contentWidth", "", "r", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "u", "Landroid/view/ViewGroup;", "msgAreaViewGroup", "textElements", "i", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "msgElements", "Landroid/widget/TextView;", "textView", "Landroid/text/SpannableStringBuilder;", "p", "", "text", "v", "picElement", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/ReplyElement;", "replyElement", "l", "result", "", "errMsg", TabPreloadItem.TAB_NAME_MESSAGE, "o", "replyMsgRecord", ReportConstant.COSTREPORT_PREFIX, "j", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/guild/contentshare/d;", "shareData", "Lcom/tencent/mobileqq/guild/contentshare/h;", "style", "a", "Lcom/tencent/mobileqq/guild/contentshare/f;", "Lcom/tencent/mobileqq/guild/contentshare/f;", "layoutListener", "b", "Landroid/view/ViewGroup;", "getMsgLayout", "()Landroid/view/ViewGroup;", "setMsgLayout", "(Landroid/view/ViewGroup;)V", "msgLayout", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Lcom/tencent/mobileqq/guild/contentshare/h$a;", "d", "Lcom/tencent/mobileqq/guild/contentshare/h$a;", "getStyle", "()Lcom/tencent/mobileqq/guild/contentshare/h$a;", "setStyle", "(Lcom/tencent/mobileqq/guild/contentshare/h$a;)V", "<init>", "(Lcom/tencent/mobileqq/guild/contentshare/f;)V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MsgContentComponent implements com.tencent.mobileqq.guild.contentshare.g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.contentshare.f layoutListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup msgLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h.MsgContentStyle style;

    public MsgContentComponent(@NotNull com.tencent.mobileqq.guild.contentshare.f layoutListener) {
        Intrinsics.checkNotNullParameter(layoutListener, "layoutListener");
        this.layoutListener = layoutListener;
    }

    private final void h(ViewGroup msgAreaViewGroup, GuildMsgItem msgItem, MsgElement picElement, int contentWidth) {
        float f16;
        boolean z16;
        LinearLayout.LayoutParams layoutParams;
        h.MsgContentStyle msgContentStyle = this.style;
        if (msgContentStyle != null) {
            f16 = msgContentStyle.getMsgContentMarginLeftRightDp();
        } else {
            f16 = 0.0f;
        }
        int dpToPx = contentWidth - (ViewUtils.dpToPx(f16) * 2);
        PicElement picElement2 = picElement.picElement;
        int i3 = picElement2.picWidth;
        int i16 = picElement2.picHeight;
        if (i3 > dpToPx) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i16 = (i16 * dpToPx) / i3;
        } else {
            dpToPx = i3;
        }
        ImageView imageView = new ImageView(msgAreaViewGroup.getContext());
        if (z16) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (msgAreaViewGroup.getChildCount() > 0) {
            layoutParams.topMargin = ViewUtils.dpToPx(10.1f);
        }
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        GuildChatPicDownloader guildChatPicDownloader = GuildChatPicDownloader.f112420a;
        PicSize picSize = PicSize.PIC_DOWNLOAD_AIO;
        Option e16 = new GuildImageOptions(guildChatPicDownloader.q(picElement, picSize), imageView, false, dpToPx, i16, UIUtil.t(dpToPx, i16), UIUtil.u(dpToPx, i16)).e();
        e16.setDecodeMode(UIUtil.f112434a.r(picElement));
        e16.setRegionScaleType(imageView.getScaleType());
        e16.setRegionWidth(dpToPx);
        e16.setRegionHeight(i16);
        GuildChatPicDownloader.v(guildChatPicDownloader, e16, picSize, picElement, msgItem.getMsgRecord(), 0, null, 16, null);
        msgAreaViewGroup.addView(imageView);
    }

    private final void i(ViewGroup msgAreaViewGroup, GuildMsgItem msgItem, ArrayList<MsgElement> textElements) {
        TextView textView = new TextView(msgAreaViewGroup.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (msgAreaViewGroup.getChildCount() > 0) {
            layoutParams.topMargin = ViewUtils.dpToPx(10.1f);
        }
        textView.setLayoutParams(layoutParams);
        cw.i(textView, cw.a(21.63f));
        textView.setTextSize(2, 11.53f);
        h.MsgContentStyle msgContentStyle = this.style;
        if (msgContentStyle != null) {
            textView.setTextColor(msgContentStyle.getTextColor());
        }
        Context context = msgAreaViewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "msgAreaViewGroup.context");
        SpannableStringBuilder p16 = p(context, msgItem.getMsgRecord(), textElements, textView);
        v(p16);
        textView.setText(p16, TextView.BufferType.SPANNABLE);
        msgAreaViewGroup.addView(textView);
    }

    private final void j() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = this.msgLayout;
        if (viewGroup2 != null && (viewGroup = (ViewGroup) viewGroup2.findViewById(R.id.zfp)) != null) {
            viewGroup.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.contentshare.template.content.f
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    MsgContentComponent.k(MsgContentComponent.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MsgContentComponent this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view.getMeasuredHeight() > ViewUtils.dpToPx(912.0f)) {
            this$0.layoutListener.b();
        }
    }

    private final void l(final GuildMsgItem msgItem, final ReplyElement replyElement) {
        Contact contact = new Contact(msgItem.getMsgRecord().chatType, msgItem.getMsgRecord().peerUid, com.tencent.guild.aio.util.ex.f.a(msgItem));
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str = msgItem.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
        boolean isSelfGuest = iGuildChannelApi.isSelfGuest(str, com.tencent.guild.aio.util.ex.f.a(msgItem));
        QLog.i("MsgContentComponent", 1, "getReplySourceMsg, isGuest: " + isSelfGuest + ", msgItem msgId = " + msgItem.getMsgId() + " msgSeq = " + msgItem.getMsgSeq() + ", replyMsgSeq = " + replyElement.replayMsgSeq);
        if (isSelfGuest) {
            ((IMsgService) QRoute.api(IMsgService.class)).getGuestMsgByRange(contact, replyElement.replayMsgSeq.longValue() + 1, 1, true, new Random().nextInt(), new IGuestMsgOperateCallback() { // from class: com.tencent.mobileqq.guild.contentshare.template.content.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback
                public final void onResult(int i3, String str2, ArrayList arrayList, HashMap hashMap) {
                    MsgContentComponent.m(MsgContentComponent.this, replyElement, msgItem, i3, str2, arrayList, hashMap);
                }
            });
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(replyElement.replayMsgSeq);
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgsBySeqs(contact, arrayList, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.guild.contentshare.template.content.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str2, ArrayList arrayList2) {
                MsgContentComponent.n(MsgContentComponent.this, replyElement, msgItem, i3, str2, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MsgContentComponent this$0, ReplyElement replyElement, GuildMsgItem msgItem, int i3, String errMsg, ArrayList arrayList, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.o(i3, errMsg, arrayList, replyElement, msgItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(MsgContentComponent this$0, ReplyElement replyElement, GuildMsgItem msgItem, int i3, String errMsg, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.o(i3, errMsg, arrayList, replyElement, msgItem);
    }

    private final void o(int result, String errMsg, ArrayList<MsgRecord> msgList, final ReplyElement replyElement, final GuildMsgItem msgItem) {
        Object obj;
        boolean z16;
        if (msgList != null) {
            QLog.i("MsgContentComponent", 1, "handleGetReplySourceMsg result=" + result + " errMsg=" + errMsg + " msgList: " + msgList.size());
            Iterator<T> it = msgList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    long j3 = ((MsgRecord) obj).msgSeq;
                    Long l3 = replyElement.replayMsgSeq;
                    if (l3 != null && j3 == l3.longValue()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            final MsgRecord msgRecord = (MsgRecord) obj;
            if (msgRecord != null) {
                C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.contentshare.template.content.MsgContentComponent$handleGetReplySourceMsg$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MsgContentComponent.this.s(replyElement, msgRecord, msgItem);
                    }
                });
            }
        }
    }

    private final SpannableStringBuilder p(Context context, MsgRecord msgRecord, ArrayList<MsgElement> msgElements, final TextView textView) {
        GuildHighlightParams guildHighlightParams;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (msgElements.isEmpty()) {
            return spannableStringBuilder;
        }
        QRouteApi api = QRoute.api(IGuildMsgElementApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMsgElementApi::class.java)");
        IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) api;
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        for (MsgElement msgElement : msgElements) {
            int i3 = msgElement.elementType;
            if (i3 == 6) {
                FaceElement faceElement = msgElement.faceElement;
                if (faceElement != null) {
                    Intrinsics.checkNotNullExpressionValue(faceElement, "faceElement");
                    spannableStringBuilder2.append(com.tencent.guild.aio.msglist.text.util.d.f111941a.e(faceElement, 13, false, new ISpanRefreshCallback() { // from class: com.tencent.mobileqq.guild.contentshare.template.content.e
                        @Override // com.tencent.mobileqq.text.ISpanRefreshCallback
                        public final void invalidateDrawable(Drawable drawable) {
                            MsgContentComponent.q(textView, drawable);
                        }
                    }));
                }
            } else if (i3 == 1) {
                String elementContent = iGuildMsgElementApi.getElementContent(msgElement);
                if (msgElement.textElement.atType != 0) {
                    int length = spannableStringBuilder2.length();
                    SpannableStringBuilder it = spannableStringBuilder2.append((CharSequence) elementContent);
                    WeakReference weakReference = new WeakReference(context);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    int length2 = it.length();
                    int i16 = msgElement.textElement.atType;
                    Bundle bundle = new Bundle();
                    int channelType = ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getChannelType(MobileQQ.sMobileQQ.peekAppRuntime(), msgRecord.guildId, msgRecord.channelId);
                    bundle.putString("jumpChannelId", String.valueOf(msgElement.textElement.atChannelId));
                    bundle.putInt("CHANNEL_TYPE", channelType);
                    Unit unit = Unit.INSTANCE;
                    bq0.e eVar = bq0.e.f28951a;
                    GuildHighlightParams guildHighlightParams2 = new GuildHighlightParams(weakReference, null, it, length, length2, i16, bundle, true, eVar.h(false, false, false, 11.53f, 11.53f), 0, 512, null);
                    TextElement textElement = msgElement.textElement;
                    if (textElement.atType == 8) {
                        Integer num = textElement.atRoleColor;
                        Intrinsics.checkNotNullExpressionValue(num, "element.textElement.atRoleColor");
                        guildHighlightParams = guildHighlightParams2;
                        guildHighlightParams.k(num.intValue());
                    } else {
                        guildHighlightParams = guildHighlightParams2;
                        h.MsgContentStyle msgContentStyle = this.style;
                        if (msgContentStyle != null) {
                            Intrinsics.checkNotNull(msgContentStyle);
                            guildHighlightParams.k(msgContentStyle.getAtTextColor());
                        }
                    }
                    eVar.p(guildHighlightParams, context, null);
                    spannableStringBuilder2 = it;
                } else {
                    spannableStringBuilder2.append((CharSequence) new QQText(elementContent, 3, 16));
                }
            }
        }
        TextBubbleContentParser.g(TextBubbleContentParser.f111932a, spannableStringBuilder2, msgRecord, null, 4, null);
        return spannableStringBuilder2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(TextView textView, Drawable drawable) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        Intrinsics.checkNotNullParameter(drawable, "<anonymous parameter 0>");
        textView.invalidate();
    }

    private final void r(GuildMsgItem msgItem, int contentWidth) {
        Object first;
        ViewGroup viewGroup;
        Object first2;
        ViewGroup viewGroup2;
        Object first3;
        Object first4;
        Object first5;
        for (ArrayList<MsgElement> arrayList : u(msgItem)) {
            IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            if (iGuildMsgElementApi.isTextElem((MsgElement) first)) {
                ViewGroup viewGroup3 = this.msgLayout;
                if (viewGroup3 != null && (viewGroup = (ViewGroup) viewGroup3.findViewById(R.id.zfp)) != null) {
                    Intrinsics.checkNotNullExpressionValue(viewGroup, "findViewById<ViewGroup>(R.id.msg_area)");
                    i(viewGroup, msgItem, arrayList);
                }
            } else {
                IGuildMsgElementApi iGuildMsgElementApi2 = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                if (iGuildMsgElementApi2.isPictureElem((MsgElement) first2)) {
                    ViewGroup viewGroup4 = this.msgLayout;
                    if (viewGroup4 != null && (viewGroup2 = (ViewGroup) viewGroup4.findViewById(R.id.zfp)) != null) {
                        Intrinsics.checkNotNullExpressionValue(viewGroup2, "findViewById<ViewGroup>(R.id.msg_area)");
                        first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                        h(viewGroup2, msgItem, (MsgElement) first3, contentWidth);
                    }
                } else {
                    IGuildMsgElementApi iGuildMsgElementApi3 = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
                    first4 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                    if (iGuildMsgElementApi3.isReplyElem((MsgElement) first4)) {
                        first5 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                        ReplyElement replyElement = ((MsgElement) first5).replyElement;
                        Intrinsics.checkNotNullExpressionValue(replyElement, "msgElementList.first().replyElement");
                        l(msgItem, replyElement);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(ReplyElement replyElement, MsgRecord replyMsgRecord, GuildMsgItem msgItem) {
        ArrayList arrayListOf;
        final TextView textView;
        ViewGroup viewGroup;
        Context context = this.context;
        if (context != null) {
            String m3 = iq0.a.m(String.valueOf(replyElement.senderUid), com.tencent.guild.aio.util.ex.f.a(msgItem), replyMsgRecord);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(2, 5, 1, 6, 14, 3, 9, 10, 11);
            String q16 = iq0.a.q(context, replyMsgRecord, replyElement, arrayListOf, false);
            ViewGroup viewGroup2 = this.msgLayout;
            if (viewGroup2 != null) {
                textView = (TextView) viewGroup2.findViewById(R.id.f73083sl);
            } else {
                textView = null;
            }
            CharSequence parseQQText = ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseQQText(m3 + q16, 16, 3, new ISpanRefreshCallback() { // from class: com.tencent.mobileqq.guild.contentshare.template.content.g
                @Override // com.tencent.mobileqq.text.ISpanRefreshCallback
                public final void invalidateDrawable(Drawable drawable) {
                    MsgContentComponent.t(textView, drawable);
                }
            });
            if (textView != null) {
                textView.setText(parseQQText);
            }
            ViewGroup viewGroup3 = this.msgLayout;
            if (viewGroup3 != null && (viewGroup = (ViewGroup) viewGroup3.findViewById(R.id.f73213sy)) != null) {
                Intrinsics.checkNotNullExpressionValue(viewGroup, "findViewById<ViewGroup>(R.id.reply_layout)");
                viewGroup.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(TextView textView, Drawable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (textView != null) {
            textView.invalidate();
        }
    }

    private final ArrayList<ArrayList<MsgElement>> u(GuildMsgItem msgItem) {
        ArrayList<MsgElement> arrayListOf;
        ArrayList<MsgElement> arrayListOf2;
        ArrayList<ArrayList<MsgElement>> arrayList = new ArrayList<>();
        ArrayList<MsgElement> arrayList2 = new ArrayList<>();
        ArrayList<MsgElement> arrayList3 = msgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "msgItem.msgRecord.elements");
        for (MsgElement element : arrayList3) {
            IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
            Intrinsics.checkNotNullExpressionValue(element, "element");
            if (iGuildMsgElementApi.isTextElem(element)) {
                arrayList2.add(element);
            } else if (((IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class)).isPictureElem(element)) {
                if (arrayList2.size() > 0) {
                    arrayList.add(arrayList2);
                    arrayList2 = new ArrayList<>();
                }
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(element);
                arrayList.add(arrayListOf);
            } else if (((IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class)).isReplyElem(element)) {
                if (arrayList2.size() > 0) {
                    arrayList.add(arrayList2);
                    arrayList2 = new ArrayList<>();
                }
                arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(element);
                arrayList.add(arrayListOf2);
            }
        }
        if (arrayList2.size() > 0) {
            arrayList.add(arrayList2);
            new ArrayList();
        }
        return arrayList;
    }

    private final void v(CharSequence text) {
        h.MsgContentStyle msgContentStyle = this.style;
        if (msgContentStyle != null && (text instanceof SpannableStringBuilder)) {
            com.tencent.guild.aio.input.at.hashtag.ui.c[] imageSpan = (com.tencent.guild.aio.input.at.hashtag.ui.c[]) ((SpannableStringBuilder) text).getSpans(0, text.length(), com.tencent.guild.aio.input.at.hashtag.ui.c.class);
            Intrinsics.checkNotNullExpressionValue(imageSpan, "imageSpan");
            for (com.tencent.guild.aio.input.at.hashtag.ui.c cVar : imageSpan) {
                cVar.f(msgContentStyle.getAtTextColor());
                if (!(cVar.getDrawable() instanceof URLDrawable)) {
                    cVar.getDrawable().setColorFilter(new PorterDuffColorFilter(msgContentStyle.getTextColor(), PorterDuff.Mode.SRC_ATOP));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.contentshare.g
    public void a(@NotNull ViewGroup parent, @NotNull com.tencent.mobileqq.guild.contentshare.d shareData, @Nullable com.tencent.mobileqq.guild.contentshare.h style) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(shareData, "shareData");
        if (shareData.getData() instanceof GuildMsgItem) {
            this.context = parent.getContext();
            if (style instanceof h.MsgContentStyle) {
                h.MsgContentStyle msgContentStyle = (h.MsgContentStyle) style;
                this.style = msgContentStyle;
                View inflate = LayoutInflater.from(parent.getContext()).inflate(msgContentStyle.getReplyLayoutResId(), parent);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                this.msgLayout = (ViewGroup) inflate;
                Object data = shareData.getData();
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                r((GuildMsgItem) data, shareData.getWidth());
                j();
            }
        }
    }
}
