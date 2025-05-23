package jq0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.aio.msglist.markdown.LinkSpanEntity;
import com.tencent.guild.aio.util.i;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.text.GrabParams;
import com.tencent.mobileqq.text.processor.ISpanCallback;
import com.tencent.mobileqq.text.processor.ISpanProcessor;
import com.tencent.mobileqq.utils.cg;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Map;
import jq0.a;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J4\u0010\u0014\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0019"}, d2 = {"Ljq0/a;", "Lcom/tencent/mobileqq/text/processor/ISpanProcessor;", "", WadlProxyConsts.FLAGS, "", "matchGrab", "Lcom/tencent/mobileqq/text/GrabParams;", "params", "Lcom/tencent/mobileqq/text/processor/ISpanCallback;", "callback", "", "doGrab", "", TtmlNode.TAG_SPAN, "matchPlain", "start", "end", "flag", "Ljava/lang/StringBuffer;", "sb", "doPlain", "<init>", "()V", "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements ISpanProcessor {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\t\u00a8\u0006\u0012"}, d2 = {"Ljq0/a$b;", "Landroid/text/style/ClickableSpan;", "", "e", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "d", "Ljava/lang/String;", "guildNumberStr", "", "Z", "isC2C", "f", "realGuildNumber", "<init>", "(Ljava/lang/String;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildNumberStr;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isC2C;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String realGuildNumber;

        public b(@NotNull String guildNumberStr, boolean z16) {
            Intrinsics.checkNotNullParameter(guildNumberStr, "guildNumberStr");
            this.guildNumberStr = guildNumberStr;
            this.isC2C = z16;
            this.realGuildNumber = "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(View widget, String guildNumber) {
            Map<String, Object> mapOf;
            Intrinsics.checkNotNullParameter(widget, "$widget");
            Intrinsics.checkNotNullParameter(guildNumber, "$guildNumber");
            IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_CHANNEL_SCORE, guildNumber));
            iGuildDTReportApi.reportDtEventManual(widget, "em_sgrp_channel_code_blue_highlight", "", "clck", mapOf);
        }

        private final String e() {
            boolean z16;
            String str;
            if (this.realGuildNumber.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                MatchResult find$default = Regex.find$default(new Regex("[a-zA-Z0-9]+"), this.guildNumberStr, 0, 2, null);
                if (find$default == null || (str = find$default.getValue()) == null) {
                    str = "";
                }
                this.realGuildNumber = str;
            }
            return this.realGuildNumber;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull final View widget) {
            byte b16;
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(widget, "widget");
            final String e16 = e();
            Logger.f235387a.d().d("Guild.jump.GuildNumberLinkSpanProcessor", 1, "click isC2C " + this.isC2C + ", " + this.guildNumberStr + ", parseGuildNumber : " + e16);
            if (e16.length() == 0) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 != false) {
                return;
            }
            JumpGuildParam jumpGuildParam = new JumpGuildParam("", "");
            jumpGuildParam.guildNumber = e16;
            jumpGuildParam.businessType = 9;
            if (this.isC2C) {
                str = "channel_code_c2c";
            } else {
                str = "channel_code_grp";
            }
            jumpGuildParam.setJoinInfoParam(new JumpGuildParam.JoinInfoParam("", "share_channel_code", str));
            Bundle bundle = jumpGuildParam.extras;
            if (this.isC2C) {
                str2 = "channel_code_highlight_c2c";
            } else {
                str2 = "channel_code_highlight_group";
            }
            bundle.putString("PGIN_SOURCE_REPORT_KEY", str2);
            jumpGuildParam.extras.putInt("curtype", 1 ^ (this.isC2C ? 1 : 0));
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildOnFullStandalone(widget.getContext(), jumpGuildParam);
            ThreadManagerV2.excute(new Runnable() { // from class: jq0.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.d(widget, e16);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public void doGrab(@Nullable GrabParams params, @Nullable ISpanCallback callback) {
        String str;
        AIOMsgItem aIOMsgItem;
        MsgRecord msgRecord = null;
        if (params != null) {
            str = params.text;
        } else {
            str = null;
        }
        if (str == null || str.length() > 1000 || !cg.f307523b.matcher(str).find()) {
            return;
        }
        Object obj = params.message;
        if (obj instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) obj;
        } else {
            aIOMsgItem = null;
        }
        if (aIOMsgItem != null) {
            msgRecord = aIOMsgItem.getMsgRecord();
        }
        for (LinkSpanEntity linkSpanEntity : i.f112408a.a(str)) {
            String content = linkSpanEntity.getContent();
            boolean z16 = false;
            if (msgRecord != null && msgRecord.chatType == 1) {
                z16 = true;
            }
            b bVar = new b(content, z16);
            if (callback != null) {
                callback.addSpan(bVar, linkSpanEntity.getStart(), linkSpanEntity.getEnd(), 33);
            }
        }
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public int doPlain(@Nullable Object span, int start, int end, int flag, @Nullable StringBuffer sb5) {
        return 0;
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public boolean matchGrab(int flags) {
        if ((flags & 64) == 64) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public boolean matchPlain(@Nullable Object span) {
        return false;
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public /* synthetic */ void setBizSrc(String str, Object[] objArr) {
        com.tencent.mobileqq.text.processor.a.a(this, str, objArr);
    }
}
